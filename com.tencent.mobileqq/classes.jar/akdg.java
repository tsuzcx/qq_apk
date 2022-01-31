import android.app.Activity;
import com.tencent.mobileqq.activity.SplashActivity;
import mqq.app.Foreground;

public class akdg
{
  public static String a()
  {
    Activity localActivity = Foreground.getTopActivity();
    String str;
    if (localActivity != null)
    {
      str = localActivity.getClass().getName();
      if ((localActivity instanceof SplashActivity))
      {
        if (SplashActivity.a == 1) {
          return str + "_" + ((SplashActivity)localActivity).a();
        }
        return str + "_ChatFragment";
      }
    }
    else
    {
      return "Null";
    }
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     akdg
 * JD-Core Version:    0.7.0.1
 */