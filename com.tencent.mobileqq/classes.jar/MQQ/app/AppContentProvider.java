package mqq.app;

import android.app.Application;
import android.content.ContentProvider;
import android.content.Context;
import android.util.Log;
import com.tencent.qphone.base.util.QLog;

public abstract class AppContentProvider
  extends ContentProvider
{
  public String getModuleId()
  {
    return null;
  }
  
  public AppRuntime getRuntime(String paramString)
  {
    try
    {
      paramString = MobileQQ.sMobileQQ.getAppRuntime(paramString).getAppRuntime(getModuleId());
      return paramString;
    }
    catch (AccountNotMatchException paramString)
    {
      paramString.printStackTrace();
      QLog.e("mqq", 2, Log.getStackTraceString(paramString));
    }
    return null;
  }
  
  public boolean onCreate()
  {
    try
    {
      ((Application)getContext().getApplicationContext()).onCreate();
    }
    catch (Exception localException)
    {
      QLog.e("mqq", 2, Log.getStackTraceString(localException));
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     mqq.app.AppContentProvider
 * JD-Core Version:    0.7.0.1
 */