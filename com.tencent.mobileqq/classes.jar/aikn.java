import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.rebuild.GameMsgChatPie.7.1;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.utils.SendMessageHandler;
import com.tencent.qphone.base.util.QLog;
import mqq.os.MqqHandler;

public class aikn
  extends aocj
{
  aikn(aikg paramaikg) {}
  
  protected void a(String paramString1, int paramInt1, int paramInt2, SendMessageHandler paramSendMessageHandler, long paramLong1, long paramLong2, String paramString2)
  {
    if (QLog.isColorLevel()) {
      QLog.d(aikg.g, 2, "[onUpdateSendMsgError], errMsg:" + paramString2 + ",replyCode:" + paramInt2);
    }
    ThreadManager.getUIHandler().post(new GameMsgChatPie.7.1(this, paramString2));
  }
  
  protected void a(boolean paramBoolean, String paramString, long paramLong)
  {
    a(paramBoolean, paramString, paramLong, null);
  }
  
  protected void a(boolean paramBoolean, String paramString, long paramLong, aocg paramaocg)
  {
    if ((paramString == null) || (paramString.length() == 0)) {}
    while (!paramString.equals(this.a.a.a)) {
      return;
    }
    this.a.t = true;
    this.a.a(262144, paramaocg, paramLong);
  }
  
  public void b(String paramString)
  {
    if (QLog.isDevelopLevel()) {
      QLog.d("MsgSend", 4, "delay 100ms, starting upadte ui");
    }
    this.a.f(131072);
  }
  
  protected void c(boolean paramBoolean, String paramString)
  {
    this.a.f(65536);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aikn
 * JD-Core Version:    0.7.0.1
 */