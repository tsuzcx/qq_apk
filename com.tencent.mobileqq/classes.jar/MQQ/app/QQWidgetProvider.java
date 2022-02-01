package mqq.app;

import android.appwidget.AppWidgetProvider;
import android.content.Context;
import android.content.Intent;

public class QQWidgetProvider
  extends AppWidgetProvider
{
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    super.onReceive(paramContext, paramIntent);
    MobileQQ.sMobileQQ.onActivityCreate(this, paramIntent);
    onReceive(MobileQQ.sMobileQQ.waitAppRuntime(null), paramContext, paramIntent);
  }
  
  public void onReceive(AppRuntime paramAppRuntime, Context paramContext, Intent paramIntent) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     mqq.app.QQWidgetProvider
 * JD-Core Version:    0.7.0.1
 */