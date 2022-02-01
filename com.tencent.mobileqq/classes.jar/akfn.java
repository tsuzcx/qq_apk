import android.content.Context;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;

public class akfn
{
  public static akfg a(Context paramContext, SessionInfo paramSessionInfo, QQAppInterface paramQQAppInterface)
  {
    int i = paramSessionInfo.curType;
    Object localObject = null;
    if (paramSessionInfo.isFromForward == 3) {
      paramSessionInfo = new akfq(paramContext, paramSessionInfo, paramQQAppInterface);
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
      paramContext = new akfo(paramContext, paramSessionInfo, paramQQAppInterface);
      break;
      paramContext = new akfp(paramContext, paramSessionInfo, paramQQAppInterface);
      break;
      paramContext = new akft(paramContext, paramSessionInfo, paramQQAppInterface);
      break;
      paramContext = new akfs(paramContext, paramSessionInfo, paramQQAppInterface);
      break;
      paramContext = new akfr(paramContext, paramSessionInfo, paramQQAppInterface);
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     akfn
 * JD-Core Version:    0.7.0.1
 */