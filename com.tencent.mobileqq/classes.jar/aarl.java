import android.text.TextUtils;
import com.tencent.biz.pubaccount.CustomWebView;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.webview.swift.WebViewPlugin;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.Set;
import mqq.manager.TicketManager;

public class aarl
  extends WebViewPlugin
{
  private nro a;
  
  public aarl()
  {
    this.mPluginNameSpace = getClass().getSimpleName();
  }
  
  public boolean handleSchemaRequest(String paramString1, String paramString2)
  {
    Object localObject2 = null;
    if (((!"http".equals(paramString2)) && (!"https".equals(paramString2))) || (TextUtils.isEmpty(paramString1))) {}
    long l;
    do
    {
      do
      {
        return false;
        l = System.currentTimeMillis();
        if (QLog.isColorLevel()) {
          QLog.d("PtloginPlugin", 2, "handleSchemaRequest, originUrl=" + paramString1);
        }
      } while (this.a == null);
      paramString2 = this.a.a("ptlogin2");
    } while ((paramString2 == null) || (paramString2.isEmpty()));
    Object localObject3 = this.mRuntime.a();
    paramString2 = paramString2.iterator();
    Object localObject1;
    int i;
    for (;;)
    {
      if (paramString2.hasNext())
      {
        localObject1 = (String)paramString2.next();
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append((String)localObject1).append("/jump?");
        if (paramString1.startsWith(localStringBuilder.toString())) {
          if (paramString1.contains("clientuin=$UIN$"))
          {
            paramString2 = paramString1.replace("clientuin=$UIN$", "clientuin=" + ((AppInterface)localObject3).getAccount());
            i = 1;
            label207:
            if (!paramString1.contains("clientkey=$KEY$")) {
              break label440;
            }
            localObject1 = (TicketManager)((AppInterface)localObject3).getManager(2);
            if (localObject1 != null) {
              break label423;
            }
            localObject1 = null;
            label235:
            localObject3 = new StringBuilder().append("clientkey=");
            localObject2 = localObject1;
            if (TextUtils.isEmpty((CharSequence)localObject1)) {
              localObject2 = "";
            }
            localObject1 = paramString2.replace("clientkey=$KEY$", (String)localObject2);
            i = 1;
            label285:
            if (!paramString1.contains("keyindex=$KEYINDEX$")) {
              break label542;
            }
            paramString2 = ((String)localObject1).replace("keyindex=$KEYINDEX$", "keyindex=19");
            i = 1;
          }
        }
      }
    }
    for (;;)
    {
      if (i != 0)
      {
        if (QLog.isColorLevel()) {
          QLog.d("PtloginPlugin", 2, "handleSchemaRequest, replacePtloginUrl, duration=" + (System.currentTimeMillis() - l));
        }
        if (QLog.isColorLevel()) {
          QLog.d("PtloginPlugin", 2, "handleSchemaRequest, load replaced url");
        }
        paramString1 = this.mRuntime.a();
        if (paramString1 != null) {
          paramString1.loadUrlOriginal(paramString2);
        }
        return true;
        if (!paramString1.contains("clientuin=$UIN")) {
          break label607;
        }
        paramString2 = paramString1.replace("clientuin=$UIN", "clientuin=" + ((AppInterface)localObject3).getAccount());
        i = 1;
        break label207;
        label423:
        localObject1 = ((TicketManager)localObject1).getStweb(((AppInterface)localObject3).getAccount());
        break label235;
        label440:
        localObject1 = paramString2;
        if (!paramString1.contains("clientkey=$KEY")) {
          break label285;
        }
        localObject1 = (TicketManager)((AppInterface)localObject3).getManager(2);
        if (localObject1 == null) {}
        for (localObject1 = localObject2;; localObject1 = ((TicketManager)localObject1).getStweb(((AppInterface)localObject3).getAccount()))
        {
          localObject3 = new StringBuilder().append("clientkey=");
          localObject2 = localObject1;
          if (TextUtils.isEmpty((CharSequence)localObject1)) {
            localObject2 = "";
          }
          localObject1 = paramString2.replace("clientkey=$KEY", (String)localObject2);
          i = 1;
          break;
        }
        label542:
        paramString2 = (String)localObject1;
        if (!paramString1.contains("keyindex=$KEYINDEX")) {
          continue;
        }
        paramString2 = ((String)localObject1).replace("keyindex=$KEYINDEX", "keyindex=19");
        i = 1;
        continue;
      }
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d("PtloginPlugin", 2, "handleSchemaRequest, not replaced, duration=" + (System.currentTimeMillis() - l));
      return false;
      label607:
      i = 0;
      paramString2 = paramString1;
      break label207;
      i = 0;
      paramString2 = paramString1;
    }
  }
  
  public void onCreate()
  {
    super.onCreate();
    this.a = nro.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aarl
 * JD-Core Version:    0.7.0.1
 */