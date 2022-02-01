package mqq.app;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;

public class ToolProcReceiver
  extends BroadcastReceiver
{
  AppRuntime mRt;
  boolean registered;
  
  public String[] getModularReceiveActions()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("mqq.intent.action.EXIT_");
    localStringBuilder.append(MobileQQ.getContext().getPackageName());
    return new String[] { "mqq.intent.action.ACCOUNT_KICKED", localStringBuilder.toString(), "mqq.intent.action.ACCOUNT_CHANGED", "mqq.intent.action.ACCOUNT_EXPIRED", "mqq.intent.action.LOGOUT", "com.tencent.process.exit" };
  }
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    if (paramIntent != null)
    {
      String str = paramIntent.getAction();
      boolean bool1 = false;
      boolean bool2 = false;
      Object localObject1;
      Object localObject2;
      if ("com.tencent.process.exit".equals(str))
      {
        localObject1 = paramIntent.getExtras();
        if (localObject1 == null) {
          return;
        }
        localObject2 = ((Bundle)localObject1).getStringArrayList("procNameList");
        if ((AppProcHelper.isLegalBroadcast(((Bundle)localObject1).getString("verify"), (ArrayList)localObject2)) && (AppProcHelper.isContainsProc(paramContext, (ArrayList)localObject2)))
        {
          paramContext = this.mRt.subRuntimeMap.values().iterator();
          for (;;)
          {
            bool1 = bool2;
            if (!paramContext.hasNext()) {
              break;
            }
            localObject1 = (AppRuntime)paramContext.next();
            if (((localObject1 instanceof IToolProcEventListener)) && (((IToolProcEventListener)localObject1).onReceiveLegalExitProcAction(paramIntent)))
            {
              if (QLog.isColorLevel())
              {
                localObject2 = new StringBuilder();
                ((StringBuilder)localObject2).append("notKillBy(LegalExit) ");
                ((StringBuilder)localObject2).append(((AppRuntime)localObject1).getModuleId());
                QLog.d("mqq", 2, ((StringBuilder)localObject2).toString());
              }
              bool2 = true;
            }
          }
        }
        bool1 = true;
      }
      else
      {
        paramContext = this.mRt.subRuntimeMap.values().iterator();
        for (bool2 = bool1;; bool2 = true)
        {
          do
          {
            bool1 = bool2;
            if (!paramContext.hasNext()) {
              break;
            }
            localObject1 = (AppRuntime)paramContext.next();
          } while ((!(localObject1 instanceof IToolProcEventListener)) || (!((IToolProcEventListener)localObject1).onReceiveAccountAction(str, paramIntent)));
          if (QLog.isColorLevel())
          {
            localObject2 = new StringBuilder();
            ((StringBuilder)localObject2).append("notKillBy(Account) ");
            ((StringBuilder)localObject2).append(((AppRuntime)localObject1).getModuleId());
            QLog.d("mqq", 2, ((StringBuilder)localObject2).toString());
          }
        }
      }
      if (QLog.isColorLevel())
      {
        paramContext = new StringBuilder();
        paramContext.append("ToolProcReceiver ");
        paramContext.append(str);
        paramContext.append(".");
        paramContext.append(bool1);
        QLog.d("mqq", 2, paramContext.toString());
      }
      if (!bool1)
      {
        paramContext = this.mRt.subRuntimeMap.values().iterator();
        while (paramContext.hasNext())
        {
          paramIntent = (AppRuntime)paramContext.next();
          if ((paramIntent instanceof IToolProcEventListener)) {
            ((IToolProcEventListener)paramIntent).onBeforeExitProc();
          }
        }
        this.mRt.exitToolProc();
      }
    }
  }
  
  void register()
  {
    if (this.registered) {
      return;
    }
    try
    {
      IntentFilter localIntentFilter = new IntentFilter();
      String[] arrayOfString = getModularReceiveActions();
      int j = arrayOfString.length;
      int i = 0;
      while (i < j)
      {
        localIntentFilter.addAction(arrayOfString[i]);
        i += 1;
      }
      MobileQQ.getContext().registerReceiver(this, localIntentFilter);
      this.registered = true;
      return;
    }
    catch (Throwable localThrowable)
    {
      if (QLog.isColorLevel()) {
        localThrowable.printStackTrace();
      }
    }
  }
  
  void unRegister()
  {
    try
    {
      if (this.registered) {
        MobileQQ.getContext().unregisterReceiver(this);
      }
      this.registered = false;
      return;
    }
    catch (Throwable localThrowable)
    {
      if (QLog.isColorLevel()) {
        localThrowable.printStackTrace();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     mqq.app.ToolProcReceiver
 * JD-Core Version:    0.7.0.1
 */