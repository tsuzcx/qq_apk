import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.pb.PBUInt32Field;
import java.util.List;
import msf.msgcomm.msg_comm.Msg;
import tencent.im.msg.im_msg_body.CommonElem;
import tencent.im.msg.im_msg_body.Elem;

public class adih
  extends adic
{
  public int a()
  {
    return super.a() + 1;
  }
  
  public boolean a(List<im_msg_body.Elem> paramList, msg_comm.Msg paramMsg, List<MessageRecord> paramList1, StringBuilder paramStringBuilder, boolean paramBoolean1, boolean paramBoolean2, bfoy parambfoy, bcsc parambcsc, bcre parambcre)
  {
    aqzo.a(paramList, paramList1, paramStringBuilder, paramMsg);
    return true;
  }
  
  public boolean a(im_msg_body.Elem paramElem)
  {
    return (paramElem.common_elem.has()) && (21 == paramElem.common_elem.uint32_service_type.get()) && (3 == paramElem.common_elem.uint32_business_type.get());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     adih
 * JD-Core Version:    0.7.0.1
 */