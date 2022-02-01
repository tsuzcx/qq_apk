import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.pb.PBUInt64Field;
import java.util.List;
import msf.msgcomm.msg_comm.Msg;
import tencent.im.msg.im_msg_body.Elem;
import tencent.im.msg.im_msg_body.GroupPubAccountInfo;

public class acuy
  extends acve
{
  public int a()
  {
    return 1000;
  }
  
  public boolean a(List<im_msg_body.Elem> paramList, msg_comm.Msg paramMsg, List<MessageRecord> paramList1, StringBuilder paramStringBuilder, boolean paramBoolean1, boolean paramBoolean2, bffl parambffl, bcse parambcse, bcre parambcre)
  {
    new bcrt().g(paramList, paramList1, paramStringBuilder, paramMsg, parambffl);
    return true;
  }
  
  public boolean a(im_msg_body.Elem paramElem)
  {
    return (paramElem.group_pub_acc_info.has()) && (paramElem.group_pub_acc_info.uint64_pub_account.has());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     acuy
 * JD-Core Version:    0.7.0.1
 */