import com.tencent.mobileqq.data.MessageRecord;
import java.util.List;
import msf.msgcomm.msg_comm.Msg;
import tencent.im.msg.im_msg_body.CustomFace;
import tencent.im.msg.im_msg_body.Elem;
import tencent.im.msg.im_msg_body.NotOnlineImage;

public class aceo
  extends acew
{
  public int a()
  {
    return super.a() + 4;
  }
  
  public boolean a(List<im_msg_body.Elem> paramList, msg_comm.Msg paramMsg, List<MessageRecord> paramList1, StringBuilder paramStringBuilder, boolean paramBoolean1, boolean paramBoolean2, bdyi parambdyi, bblm parambblm, bbkm parambbkm)
  {
    new bblb().b(paramList, paramList1, paramStringBuilder, paramMsg, parambdyi, paramBoolean2);
    return true;
  }
  
  public boolean a(im_msg_body.Elem paramElem)
  {
    return (paramElem.not_online_image.has()) || (paramElem.custom_face.has());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aceo
 * JD-Core Version:    0.7.0.1
 */