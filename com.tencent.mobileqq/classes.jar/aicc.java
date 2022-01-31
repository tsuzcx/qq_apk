import com.tencent.biz.pubaccount.PublicAccountManager;
import com.tencent.mobileqq.service.message.MessagePBElemDecoder;

public class aicc
  implements Runnable
{
  public aicc(MessagePBElemDecoder paramMessagePBElemDecoder) {}
  
  public void run()
  {
    PublicAccountManager.a().a(MessagePBElemDecoder.a(this.a));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aicc
 * JD-Core Version:    0.7.0.1
 */