import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import java.util.List;
import msf.msgcomm.msg_comm.Msg;
import tencent.im.msg.im_msg_body.CommonElem;
import tencent.im.msg.im_msg_body.Elem;
import tencent.im.msg.im_msg_body.Face;
import tencent.im.msg.im_msg_body.OnlineImage;
import tencent.im.msg.im_msg_body.SmallEmoji;
import tencent.im.msg.im_msg_body.Text;

public class adie
  extends adic
{
  public static Boolean a(im_msg_body.Elem paramElem)
  {
    boolean bool = true;
    if ((paramElem.text.has()) || (paramElem.face.has()) || (paramElem.small_emoji.has()) || (paramElem.online_image.has()) || (paramElem.bankcode_ctrl_info.has())) {
      return Boolean.valueOf(true);
    }
    if (paramElem.common_elem.has())
    {
      if (33 == paramElem.common_elem.uint32_service_type.get()) {}
      for (;;)
      {
        return Boolean.valueOf(bool);
        bool = false;
      }
    }
    return Boolean.valueOf(false);
  }
  
  public int a()
  {
    return -1;
  }
  
  public boolean a(List<im_msg_body.Elem> paramList, msg_comm.Msg paramMsg, List<MessageRecord> paramList1, StringBuilder paramStringBuilder, boolean paramBoolean1, boolean paramBoolean2, bfoy parambfoy, bcsc parambcsc, bcre parambcre)
  {
    new bcrt().i(paramList, paramList1, paramStringBuilder, paramMsg, parambfoy);
    return true;
  }
  
  public boolean a(im_msg_body.Elem paramElem)
  {
    return a(paramElem).booleanValue();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     adie
 * JD-Core Version:    0.7.0.1
 */