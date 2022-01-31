import android.app.Activity;
import android.os.Looper;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.apollo.view.ApolloGameWrapper.1;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;

public class allx
{
  public static void a(boolean paramBoolean, Activity paramActivity, ahap paramahap, AppInterface paramAppInterface, String paramString, ally paramally)
  {
    a(paramBoolean, paramActivity, paramahap, paramAppInterface, paramString, paramally, true);
  }
  
  public static void a(boolean paramBoolean1, Activity paramActivity, ahap paramahap, AppInterface paramAppInterface, String paramString, ally paramally, boolean paramBoolean2)
  {
    if (paramally == null)
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
      paramally.a(false, null);
      return;
    }
    if (Looper.getMainLooper() == Looper.myLooper())
    {
      paramahap = akyn.a(paramString);
      if ((paramahap == null) || (paramahap.a == null) || (paramahap.a.get() != paramActivity))
      {
        paramally.a(false, paramahap);
        return;
      }
      paramally.a(true, paramahap);
      return;
    }
    paramActivity.runOnUiThread(new ApolloGameWrapper.1(paramString, paramActivity, paramally));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     allx
 * JD-Core Version:    0.7.0.1
 */