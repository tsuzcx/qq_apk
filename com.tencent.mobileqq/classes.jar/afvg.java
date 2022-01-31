import android.content.Context;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;

public class afvg
{
  public static afuz a(Context paramContext, SessionInfo paramSessionInfo, QQAppInterface paramQQAppInterface)
  {
    int i = paramSessionInfo.a;
    Object localObject = null;
    if (paramSessionInfo.f == 3) {
      paramSessionInfo = new afvj(paramContext, paramSessionInfo, paramQQAppInterface);
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
      paramContext = new afvh(paramContext, paramSessionInfo, paramQQAppInterface);
      break;
      paramContext = new afvi(paramContext, paramSessionInfo, paramQQAppInterface);
      break;
      paramContext = new afvm(paramContext, paramSessionInfo, paramQQAppInterface);
      break;
      paramContext = new afvl(paramContext, paramSessionInfo, paramQQAppInterface);
      break;
      paramContext = new afvk(paramContext, paramSessionInfo, paramQQAppInterface);
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     afvg
 * JD-Core Version:    0.7.0.1
 */