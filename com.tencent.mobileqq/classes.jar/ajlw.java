import android.os.Bundle;
import com.tencent.qphone.base.util.QLog;

public class ajlw
{
  public static void a(String paramString, Bundle paramBundle)
  {
    if (paramBundle == null) {}
    int i;
    do
    {
      String str;
      for (;;)
      {
        return;
        try
        {
          if (ajls.a())
          {
            i = paramBundle.getInt("featureId");
            str = paramBundle.getString("featureKey");
            if ("action_begin_trace".equals(paramString))
            {
              ajls.a().a(i, str, paramBundle);
              return;
            }
          }
        }
        catch (Exception paramString)
        {
          QLog.e("TraceReport", 1, paramString, new Object[0]);
          return;
        }
      }
      if ("action_end_trace".equals(paramString))
      {
        ajls.a().b(i, str, paramBundle);
        return;
      }
      if ("action_report_span".equals(paramString))
      {
        ajls.a().c(i, str, paramBundle);
        return;
      }
      if ("action_update_trace".equals(paramString))
      {
        ajls.a().a(i, paramBundle);
        return;
      }
    } while (!"action_enable_trace".equals(paramString));
    boolean bool = paramBundle.getBoolean("enable");
    ajls.a().a(i, bool);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     ajlw
 * JD-Core Version:    0.7.0.1
 */