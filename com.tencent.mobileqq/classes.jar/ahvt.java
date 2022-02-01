import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.QQAppInterface;

public class ahvt
  extends ahvq
{
  protected void b(BaseChatPie paramBaseChatPie)
  {
    try
    {
      l = Long.parseLong(paramBaseChatPie.sessionInfo.curFriendUin);
      abgm localabgm = (abgm)paramBaseChatPie.app.getBusinessHandler(BusinessHandlerFactory.DEVICEPROXYMGR_HANDLER);
      if ((localabgm != null) && (localabgm.c(l))) {
        a(paramBaseChatPie.sessionInfo.curType, 206);
      }
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        localException.printStackTrace();
        long l = 0L;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ahvt
 * JD-Core Version:    0.7.0.1
 */