import android.content.Context;
import android.support.v4.app.FragmentActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;

public class adjx
{
  public static adjv a(QQAppInterface paramQQAppInterface, FragmentActivity paramFragmentActivity, Context paramContext, String paramString)
  {
    boolean bool = true;
    ajxl localajxl = (ajxl)paramQQAppInterface.getManager(51);
    if (localajxl != null) {
      bool = localajxl.b(paramString);
    }
    if (bool)
    {
      paramQQAppInterface = new acwl(paramQQAppInterface, paramFragmentActivity, paramContext, paramString);
      if (QLog.isColorLevel())
      {
        paramContext = new StringBuilder().append("getIntimateView bFriend = ").append(bool).append(" IntimateView ");
        if (paramQQAppInterface != null) {
          break label111;
        }
      }
    }
    label111:
    for (paramFragmentActivity = "null";; paramFragmentActivity = "created")
    {
      QLog.i("IntimateViewFactory", 2, paramFragmentActivity);
      return paramQQAppInterface;
      paramQQAppInterface = new adke(paramQQAppInterface, paramFragmentActivity, paramContext, paramString);
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     adjx
 * JD-Core Version:    0.7.0.1
 */