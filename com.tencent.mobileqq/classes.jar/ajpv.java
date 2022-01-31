import android.app.Activity;
import android.os.Looper;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.apollo.view.ApolloGameWrapper.1;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;

public class ajpv
{
  public static void a(boolean paramBoolean, Activity paramActivity, aeyv paramaeyv, AppInterface paramAppInterface, String paramString, ajpw paramajpw)
  {
    a(paramBoolean, paramActivity, paramaeyv, paramAppInterface, paramString, paramajpw, true);
  }
  
  public static void a(boolean paramBoolean1, Activity paramActivity, aeyv paramaeyv, AppInterface paramAppInterface, String paramString, ajpw paramajpw, boolean paramBoolean2)
  {
    if (paramajpw == null)
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
      paramajpw.a(false, null);
      return;
    }
    if (Looper.getMainLooper() == Looper.myLooper())
    {
      paramaeyv = ajcm.a(paramString);
      if ((paramaeyv == null) || (paramaeyv.a == null) || (paramaeyv.a.get() != paramActivity))
      {
        paramajpw.a(false, paramaeyv);
        return;
      }
      paramajpw.a(true, paramaeyv);
      return;
    }
    paramActivity.runOnUiThread(new ApolloGameWrapper.1(paramString, paramActivity, paramajpw));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     ajpv
 * JD-Core Version:    0.7.0.1
 */