import android.app.Activity;
import android.os.Looper;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.apollo.view.ApolloGameWrapper.1;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;

public class ajpx
{
  public static void a(boolean paramBoolean, Activity paramActivity, aeyx paramaeyx, AppInterface paramAppInterface, String paramString, ajpy paramajpy)
  {
    a(paramBoolean, paramActivity, paramaeyx, paramAppInterface, paramString, paramajpy, true);
  }
  
  public static void a(boolean paramBoolean1, Activity paramActivity, aeyx paramaeyx, AppInterface paramAppInterface, String paramString, ajpy paramajpy, boolean paramBoolean2)
  {
    if (paramajpy == null)
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
      paramajpy.a(false, null);
      return;
    }
    if (Looper.getMainLooper() == Looper.myLooper())
    {
      paramaeyx = ajco.a(paramString);
      if ((paramaeyx == null) || (paramaeyx.a == null) || (paramaeyx.a.get() != paramActivity))
      {
        paramajpy.a(false, paramaeyx);
        return;
      }
      paramajpy.a(true, paramaeyx);
      return;
    }
    paramActivity.runOnUiThread(new ApolloGameWrapper.1(paramString, paramActivity, paramajpy));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     ajpx
 * JD-Core Version:    0.7.0.1
 */