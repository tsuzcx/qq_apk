import android.app.Activity;
import android.os.Looper;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.apollo.view.ApolloGameWrapper.1;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;

public class alhi
{
  public static void a(boolean paramBoolean, Activity paramActivity, agwa paramagwa, AppInterface paramAppInterface, String paramString, alhj paramalhj)
  {
    a(paramBoolean, paramActivity, paramagwa, paramAppInterface, paramString, paramalhj, true);
  }
  
  public static void a(boolean paramBoolean1, Activity paramActivity, agwa paramagwa, AppInterface paramAppInterface, String paramString, alhj paramalhj, boolean paramBoolean2)
  {
    if (paramalhj == null)
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
      paramalhj.a(false, null);
      return;
    }
    if (Looper.getMainLooper() == Looper.myLooper())
    {
      paramagwa = akty.a(paramString);
      if ((paramagwa == null) || (paramagwa.a == null) || (paramagwa.a.get() != paramActivity))
      {
        paramalhj.a(false, paramagwa);
        return;
      }
      paramalhj.a(true, paramagwa);
      return;
    }
    paramActivity.runOnUiThread(new ApolloGameWrapper.1(paramString, paramActivity, paramalhj));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     alhi
 * JD-Core Version:    0.7.0.1
 */