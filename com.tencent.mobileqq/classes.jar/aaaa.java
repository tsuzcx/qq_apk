import IMMsgBodyPack.MsgType0x210;
import com.tencent.av.service.QavWrapper;
import com.tencent.av.service.QavWrapper.OnReadyListener;
import com.tencent.mobileqq.app.message.OnLinePushMessageProcessor;

public class aaaa
  implements QavWrapper.OnReadyListener
{
  public aaaa(OnLinePushMessageProcessor paramOnLinePushMessageProcessor, MsgType0x210 paramMsgType0x210) {}
  
  public void a(QavWrapper paramQavWrapper)
  {
    paramQavWrapper.b(this.jdField_a_of_type_IMMsgBodyPackMsgType0x210.vProtobuf);
    paramQavWrapper.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     aaaa
 * JD-Core Version:    0.7.0.1
 */