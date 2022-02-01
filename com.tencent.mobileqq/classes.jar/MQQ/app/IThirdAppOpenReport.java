package mqq.app;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

public abstract interface IThirdAppOpenReport
{
  public static final int TYPE_BIND_SERVICE = 2;
  public static final int TYPE_START_ACTIVITY = 0;
  public static final int TYPE_START_SERVICE = 1;
  
  public abstract void report(Context paramContext, Intent paramIntent, int paramInt);
  
  public abstract void startActivityForResult(Activity paramActivity, Intent paramIntent, int paramInt, Bundle paramBundle);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     mqq.app.IThirdAppOpenReport
 * JD-Core Version:    0.7.0.1
 */