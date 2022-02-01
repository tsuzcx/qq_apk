import android.content.Context;
import android.content.res.Resources;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import mqq.app.AppRuntime;

public class aank
{
  private static boolean a;
  
  public static void a(Context paramContext, String paramString, aanq paramaanq)
  {
    if (TextUtils.isEmpty(paramString)) {
      QLog.e("SubscribeFollowUserUtil", 2, "follow user failed! user is null");
    }
    do
    {
      return;
      AppRuntime localAppRuntime = BaseApplicationImpl.getApplication().getRuntime();
      if ((localAppRuntime instanceof QQAppInterface))
      {
        tzq.a((QQAppInterface)localAppRuntime, paramContext, paramString, new aano(paramaanq), false, 0, true);
        return;
      }
    } while (paramaanq == null);
    paramaanq.a(false, paramString, false);
  }
  
  public static void a(Context paramContext, String paramString1, String paramString2, aanq paramaanq)
  {
    a(paramContext, paramString1, true, paramString2, 2131695784, paramaanq);
  }
  
  public static void a(Context paramContext, String paramString1, boolean paramBoolean, String paramString2, int paramInt, aanq paramaanq)
  {
    if (paramContext == null) {}
    blir localblir;
    do
    {
      return;
      localblir = blir.a(paramContext);
      if (paramBoolean) {
        localblir.a(String.format(paramContext.getResources().getString(2131694704), new Object[] { paramString2 }));
      }
      localblir.a(paramInt, 3);
      localblir.c(2131690580);
      localblir.setOnDismissListener(new aanl());
      localblir.a(new aanm(paramaanq, paramString1, localblir));
      localblir.a(new aann(paramContext, paramString1, paramaanq, localblir));
    } while (localblir.isShowing());
    a = false;
    localblir.show();
  }
  
  public static void b(Context paramContext, String paramString, aanq paramaanq)
  {
    a(paramContext, paramString, false, "", 2131694702, paramaanq);
  }
  
  public static void c(Context paramContext, String paramString, aanq paramaanq)
  {
    if (TextUtils.isEmpty(paramString)) {
      QLog.e("SubscribeFollowUserUtil", 2, "unfollow user failed! user is null");
    }
    do
    {
      return;
      AppRuntime localAppRuntime = BaseApplicationImpl.getApplication().getRuntime();
      if ((localAppRuntime instanceof QQAppInterface))
      {
        tzq.a((QQAppInterface)localAppRuntime, paramContext, paramString, false, new aanp(paramaanq), true);
        return;
      }
    } while (paramaanq == null);
    paramaanq.a(false, paramString, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aank
 * JD-Core Version:    0.7.0.1
 */