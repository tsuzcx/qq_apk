package mqq.app;

import android.app.Activity;
import android.content.pm.ActivityInfo;
import android.content.res.TypedArray;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class AndroidOreoUtils
{
  private Activity mActivity;
  private ActivityInfo mActivityInfo = null;
  
  public AndroidOreoUtils(Activity paramActivity)
  {
    this.mActivity = paramActivity;
  }
  
  public boolean fixOrientation()
  {
    try
    {
      Field localField = Activity.class.getDeclaredField("mActivityInfo");
      localField.setAccessible(true);
      ActivityInfo localActivityInfo = (ActivityInfo)localField.get(this.mActivity);
      if (isFixedOrientation(localActivityInfo, localActivityInfo.screenOrientation)) {
        localActivityInfo.screenOrientation = -1;
      }
      localField.setAccessible(false);
      return true;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
    return false;
  }
  
  public ActivityInfo getCurrentActivityInfo()
  {
    if (this.mActivityInfo == null) {
      try
      {
        Field localField = Activity.class.getDeclaredField("mActivityInfo");
        localField.setAccessible(true);
        this.mActivityInfo = ((ActivityInfo)localField.get(this.mActivity));
        localField.setAccessible(false);
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
      }
    }
    return this.mActivityInfo;
  }
  
  public boolean isFixedOrientation(ActivityInfo paramActivityInfo, int paramInt)
  {
    boolean bool;
    try
    {
      Method localMethod = ActivityInfo.class.getMethod("isFixedOrientation", new Class[] { Integer.TYPE });
      localMethod.setAccessible(true);
      bool = ((Boolean)localMethod.invoke(paramActivityInfo, new Object[] { Integer.valueOf(paramInt) })).booleanValue();
      try
      {
        localMethod.setAccessible(false);
        return bool;
      }
      catch (Exception paramActivityInfo) {}
      paramActivityInfo.printStackTrace();
    }
    catch (Exception paramActivityInfo)
    {
      bool = false;
    }
    return bool;
  }
  
  public boolean isTranslucentOrFloating()
  {
    boolean bool1 = false;
    try
    {
      Object localObject = (int[])Class.forName("com.android.internal.R$styleable").getField("Window").get(null);
      localObject = this.mActivity.obtainStyledAttributes((int[])localObject);
      Method localMethod = ActivityInfo.class.getMethod("isTranslucentOrFloating", new Class[] { TypedArray.class });
      localMethod.setAccessible(true);
      boolean bool2 = ((Boolean)localMethod.invoke(null, new Object[] { localObject })).booleanValue();
      try
      {
        localMethod.setAccessible(false);
        return bool2;
      }
      catch (Exception localException1)
      {
        bool1 = bool2;
      }
      localException2.printStackTrace();
    }
    catch (Exception localException2) {}
    return bool1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     mqq.app.AndroidOreoUtils
 * JD-Core Version:    0.7.0.1
 */