import android.content.Context;
import android.content.res.Resources;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import mqq.app.AppRuntime;

public class aajj
{
  private static boolean a;
  
  public static void a(Context paramContext, String paramString, aajp paramaajp)
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
        tzo.a((QQAppInterface)localAppRuntime, paramContext, paramString, new aajn(paramaajp), false, 0, true);
        return;
      }
    } while (paramaajp == null);
    paramaajp.a(false, paramString, false);
  }
  
  public static void a(Context paramContext, String paramString1, String paramString2, aajp paramaajp)
  {
    a(paramContext, paramString1, true, paramString2, 2131695741, paramaajp);
  }
  
  public static void a(Context paramContext, String paramString1, boolean paramBoolean, String paramString2, int paramInt, aajp paramaajp)
  {
    if (paramContext == null) {}
    bkho localbkho;
    do
    {
      return;
      localbkho = bkho.a(paramContext);
      if (paramBoolean) {
        localbkho.a(String.format(paramContext.getResources().getString(2131694662), new Object[] { paramString2 }));
      }
      localbkho.a(paramInt, 3);
      localbkho.c(2131690582);
      localbkho.setOnDismissListener(new aajk());
      localbkho.a(new aajl(paramaajp, paramString1, localbkho));
      localbkho.a(new aajm(paramContext, paramString1, paramaajp, localbkho));
    } while (localbkho.isShowing());
    a = false;
    localbkho.show();
  }
  
  public static void b(Context paramContext, String paramString, aajp paramaajp)
  {
    a(paramContext, paramString, false, "", 2131694660, paramaajp);
  }
  
  public static void c(Context paramContext, String paramString, aajp paramaajp)
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
        tzo.a((QQAppInterface)localAppRuntime, paramContext, paramString, false, new aajo(paramaajp), true);
        return;
      }
    } while (paramaajp == null);
    paramaajp.a(false, paramString, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aajj
 * JD-Core Version:    0.7.0.1
 */