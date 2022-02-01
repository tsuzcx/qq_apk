import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.pb.PBUInt32Field;
import java.util.List;
import msf.msgcomm.msg_comm.Msg;
import tencent.im.msg.im_msg_body.CommonElem;
import tencent.im.msg.im_msg_body.Elem;

public class adha
  extends adic
{
  public int a()
  {
    return 1000;
  }
  
  public boolean a(List<im_msg_body.Elem> paramList, msg_comm.Msg paramMsg, List<MessageRecord> paramList1, StringBuilder paramStringBuilder, boolean paramBoolean1, boolean paramBoolean2, bfoy parambfoy, bcsc parambcsc, bcre parambcre)
  {
    new bcrt().d(paramList, paramList1, paramStringBuilder, paramMsg, parambfoy);
    return true;
  }
  
  public boolean a(im_msg_body.Elem paramElem)
  {
    return (paramElem.common_elem.has()) && (20 == paramElem.common_elem.uint32_service_type.get());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     adha
 * JD-Core Version:    0.7.0.1
 */