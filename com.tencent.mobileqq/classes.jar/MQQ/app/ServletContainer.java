package mqq.app;

import android.content.ComponentName;
import android.content.Intent;
import android.os.Looper;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.util.QLog;
import java.lang.Class<+Lmqq.app.MSFServlet;>;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import mqq.util.MqqConnRateReport;
import mqq.util.MqqConnRateReport.EventType;

public class ServletContainer
{
  private final ConcurrentHashMap<String, Set<String>> actionMap = new ConcurrentHashMap();
  private AppRuntime app;
  private ExecutorService mService = Executors.newSingleThreadExecutor(new ServletContainer.1(this));
  final ConcurrentHashMap<String, Servlet> managedServlet = new ConcurrentHashMap();
  
  public ServletContainer(AppRuntime paramAppRuntime)
  {
    this.app = paramAppRuntime;
  }
  
  public void destroy()
  {
    this.mService.shutdown();
    Iterator localIterator = this.managedServlet.entrySet().iterator();
    while (localIterator.hasNext()) {
      ((Servlet)((Map.Entry)localIterator.next()).getValue()).onDestroy();
    }
    this.managedServlet.clear();
  }
  
  public void forward(AppRuntime paramAppRuntime, Intent paramIntent)
  {
    if (!this.mService.isShutdown())
    {
      paramAppRuntime = new ServletContainer.2(this, paramIntent.getComponent().getClassName(), paramIntent);
      boolean bool = false;
      if ((paramIntent instanceof NewIntent)) {
        bool = ((NewIntent)paramIntent).runNow;
      }
      if ((!bool) && (Thread.currentThread() == Looper.getMainLooper().getThread()))
      {
        this.mService.execute(paramAppRuntime);
        return;
      }
      paramAppRuntime.run();
      return;
    }
    paramAppRuntime = new StringBuilder();
    paramAppRuntime.append("ServletContainer has destoryed,");
    paramAppRuntime.append(paramIntent.getComponent().getClassName());
    paramAppRuntime.append(" can not be started.");
    QLog.e("mqq", 1, paramAppRuntime.toString());
  }
  
  Servlet getServlet(String paramString)
  {
    Object localObject = (Servlet)this.managedServlet.get(paramString);
    if (localObject == null) {
      synchronized (this.managedServlet)
      {
        Servlet localServlet = (Servlet)this.managedServlet.get(paramString);
        localObject = localServlet;
        if (localServlet == null) {
          for (;;)
          {
            try
            {
              localObject = Class.forName(paramString);
            }
            catch (Throwable localThrowable)
            {
              continue;
            }
            try
            {
              localObject = this.app.getClass().getClassLoader().loadClass(paramString);
              localServlet = (Servlet)((Class)localObject).newInstance();
              localServlet.init(this.app, this);
              localServlet.onCreate();
              this.managedServlet.put(paramString, localServlet);
              localObject = new StringBuilder();
              ((StringBuilder)localObject).append("newServlet = ");
              ((StringBuilder)localObject).append(localServlet);
              QLog.d("mqq", 1, ((StringBuilder)localObject).toString());
              localObject = localServlet;
              if ((localServlet instanceof MSFServlet))
              {
                String[] arrayOfString = ((MSFServlet)localServlet).getPreferSSOCommands();
                localObject = localServlet;
                if (arrayOfString != null)
                {
                  int j = arrayOfString.length;
                  int i = 0;
                  localObject = localServlet;
                  if (i < j)
                  {
                    String str = arrayOfString[i];
                    Set localSet = (Set)this.actionMap.get(str);
                    localObject = localSet;
                    if (localSet == null)
                    {
                      localObject = new HashSet();
                      this.actionMap.put(str, localObject);
                    }
                    ((Set)localObject).add(paramString);
                    i += 1;
                    continue;
                  }
                }
              }
            }
            catch (Throwable paramString)
            {
              paramString.printStackTrace();
              return null;
            }
          }
        }
        return localObject;
      }
    }
    return localObject;
  }
  
  public void notifyMSFServlet(Class<? extends MSFServlet> paramClass, FromServiceMsg paramFromServiceMsg)
  {
    if (paramClass != null)
    {
      localObject = (MSFServlet)getServlet(paramClass.getName());
      paramClass = (Class<? extends MSFServlet>)localObject;
      if (localObject != null)
      {
        ((MSFServlet)localObject).onReceive(paramFromServiceMsg);
        paramClass = (Class<? extends MSFServlet>)localObject;
      }
    }
    else
    {
      paramClass = null;
    }
    Object localObject = (Set)this.actionMap.get(paramFromServiceMsg.getServiceCmd());
    if (localObject != null)
    {
      localObject = ((Set)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        MSFServlet localMSFServlet = (MSFServlet)getServlet((String)((Iterator)localObject).next());
        if ((localMSFServlet != null) && (localMSFServlet != paramClass)) {
          localMSFServlet.onReceive(paramFromServiceMsg);
        } else if ((paramFromServiceMsg != null) && (paramFromServiceMsg.getServiceCmd() != null) && (paramFromServiceMsg.getServiceCmd().equals("SharpSvr.s2c"))) {
          MqqConnRateReport.getInstance().doReport(MqqConnRateReport.EventType.eMSFRecvInviteMsg, paramFromServiceMsg.getWupBuffer(), 20);
        }
      }
    }
    if ((paramFromServiceMsg != null) && (paramFromServiceMsg.getServiceCmd() != null) && (paramFromServiceMsg.getServiceCmd().equals("SharpSvr.s2c"))) {
      MqqConnRateReport.getInstance().doReport(MqqConnRateReport.EventType.eMSFRecvInviteMsg, paramFromServiceMsg.getWupBuffer(), 19);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     mqq.app.ServletContainer
 * JD-Core Version:    0.7.0.1
 */