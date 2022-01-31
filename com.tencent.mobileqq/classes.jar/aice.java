import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.service.message.MessagePBElemDecoder;
import cooperation.dingdong.data.OfficeCenterSharedPref;

public class aice
  implements Runnable
{
  public aice(MessagePBElemDecoder paramMessagePBElemDecoder) {}
  
  public void run()
  {
    if (!OfficeCenterSharedPref.a().a(MessagePBElemDecoder.a(this.a).getCurrentAccountUin() + "officecenter_receive_schedule_message", false)) {
      OfficeCenterSharedPref.a().b(MessagePBElemDecoder.a(this.a).getCurrentAccountUin() + "officecenter_receive_schedule_message", true);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aice
 * JD-Core Version:    0.7.0.1
 */