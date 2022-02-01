import com.tencent.mobileqq.data.MessageRecord;
import java.util.List;
import msf.msgcomm.msg_comm.Msg;
import tencent.im.msg.im_msg_body.ArkAppElem;
import tencent.im.msg.im_msg_body.Elem;
import tencent.im.msg.im_msg_body.LightAppElem;

public class acyc
  extends aczg
{
  public int a()
  {
    return 1000;
  }
  
  public boolean a(List<im_msg_body.Elem> paramList, msg_comm.Msg paramMsg, List<MessageRecord> paramList1, StringBuilder paramStringBuilder, boolean paramBoolean1, boolean paramBoolean2, bepr parambepr, bbzl parambbzl, bbyn parambbyn)
  {
    new bbzc().c(paramList, paramList1, paramStringBuilder, paramMsg, parambepr);
    return true;
  }
  
  public boolean a(im_msg_body.Elem paramElem)
  {
    return (paramElem.ark_app.has()) || (paramElem.light_app.has());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     acyc
 * JD-Core Version:    0.7.0.1
 */