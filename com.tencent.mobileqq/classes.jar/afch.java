import android.content.Context;
import android.support.v4.app.FragmentActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;

public class afch
{
  public static afcf a(QQAppInterface paramQQAppInterface, FragmentActivity paramFragmentActivity, Context paramContext, String paramString)
  {
    boolean bool = true;
    aloz localaloz = (aloz)paramQQAppInterface.getManager(51);
    if (localaloz != null) {
      bool = localaloz.b(paramString);
    }
    if (bool)
    {
      paramQQAppInterface = new aenv(paramQQAppInterface, paramFragmentActivity, paramContext, paramString);
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
      paramQQAppInterface = new afco(paramQQAppInterface, paramFragmentActivity, paramContext, paramString);
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     afch
 * JD-Core Version:    0.7.0.1
 */