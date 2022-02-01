import android.content.Context;
import android.support.v4.app.FragmentActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.qphone.base.util.QLog;

public class aglq
{
  public static agll a(QQAppInterface paramQQAppInterface, FragmentActivity paramFragmentActivity, Context paramContext, String paramString)
  {
    boolean bool = true;
    anvk localanvk = (anvk)paramQQAppInterface.getManager(QQManagerFactory.FRIENDS_MANAGER);
    if (localanvk != null) {
      bool = localanvk.b(paramString);
    }
    if (bool)
    {
      paramQQAppInterface = new afsv(paramQQAppInterface, paramFragmentActivity, paramContext, paramString);
      if (QLog.isColorLevel())
      {
        paramContext = new StringBuilder().append("getIntimateView bFriend = ").append(bool).append(" IntimateView ");
        if (paramQQAppInterface != null) {
          break label112;
        }
      }
    }
    label112:
    for (paramFragmentActivity = "null";; paramFragmentActivity = "created")
    {
      QLog.i("IntimateViewFactory", 2, paramFragmentActivity);
      return paramQQAppInterface;
      paramQQAppInterface = new aglx(paramQQAppInterface, paramFragmentActivity, paramContext, paramString);
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aglq
 * JD-Core Version:    0.7.0.1
 */