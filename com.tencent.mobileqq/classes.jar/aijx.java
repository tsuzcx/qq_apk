import android.content.Context;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;

public class aijx
{
  public static aijq a(Context paramContext, SessionInfo paramSessionInfo, QQAppInterface paramQQAppInterface)
  {
    int i = paramSessionInfo.a;
    Object localObject = null;
    if (paramSessionInfo.f == 3) {
      paramSessionInfo = new aika(paramContext, paramSessionInfo, paramQQAppInterface);
    }
    do
    {
      return paramSessionInfo;
      switch (i)
      {
      default: 
        paramContext = localObject;
        paramSessionInfo = paramContext;
      }
    } while (!QLog.isColorLevel());
    paramQQAppInterface = new StringBuilder().append("getChatPie uinType = ").append(i).append(" miniPie ");
    if (paramContext == null) {}
    for (paramSessionInfo = "null";; paramSessionInfo = Integer.valueOf(paramContext.hashCode()))
    {
      QLog.i("MiniPieFactory", 2, paramSessionInfo);
      return paramContext;
      paramContext = new aijy(paramContext, paramSessionInfo, paramQQAppInterface);
      break;
      paramContext = new aijz(paramContext, paramSessionInfo, paramQQAppInterface);
      break;
      paramContext = new aikd(paramContext, paramSessionInfo, paramQQAppInterface);
      break;
      paramContext = new aikc(paramContext, paramSessionInfo, paramQQAppInterface);
      break;
      paramContext = new aikb(paramContext, paramSessionInfo, paramQQAppInterface);
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aijx
 * JD-Core Version:    0.7.0.1
 */