import android.content.Context;
import android.content.SharedPreferences;
import com.tencent.qphone.base.util.QLog;

public class aajq
{
  private static SharedPreferences a;
  
  public static SharedPreferences a(Context paramContext)
  {
    if (a == null)
    {
      if (paramContext == null)
      {
        QLog.e("SubscribeSpUtil", 2, "getPreference error, context is null");
        return null;
      }
      a = paramContext.getSharedPreferences("biz_subscribe", 0);
    }
    return a;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aajq
 * JD-Core Version:    0.7.0.1
 */