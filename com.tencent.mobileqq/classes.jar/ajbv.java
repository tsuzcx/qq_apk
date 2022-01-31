import android.app.Activity;
import android.os.Looper;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.apollo.view.ApolloGameWrapper.1;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;

public class ajbv
{
  public static void a(boolean paramBoolean, Activity paramActivity, aeob paramaeob, AppInterface paramAppInterface, String paramString, ajbw paramajbw)
  {
    a(paramBoolean, paramActivity, paramaeob, paramAppInterface, paramString, paramajbw, true);
  }
  
  public static void a(boolean paramBoolean1, Activity paramActivity, aeob paramaeob, AppInterface paramAppInterface, String paramString, ajbw paramajbw, boolean paramBoolean2)
  {
    if (paramajbw == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("cmgame_process.ApolloGameWrapper", 2, "checkApolloGame listener is null");
      }
      return;
    }
    if ((paramActivity == null) || (paramAppInterface == null))
    {
      if (QLog.isColorLevel()) {
        QLog.d("cmgame_process.ApolloGameWrapper", 2, "checkApolloGame activity is null OR appInterface is null");
      }
      paramajbw.a(false, null);
      return;
    }
    if (Looper.getMainLooper() == Looper.myLooper())
    {
      paramaeob = aipq.a(paramString);
      if ((paramaeob == null) || (paramaeob.a == null) || (paramaeob.a.get() != paramActivity))
      {
        paramajbw.a(false, paramaeob);
        return;
      }
      paramajbw.a(true, paramaeob);
      return;
    }
    paramActivity.runOnUiThread(new ApolloGameWrapper.1(paramString, paramActivity, paramajbw));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     ajbv
 * JD-Core Version:    0.7.0.1
 */