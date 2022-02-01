import com.tencent.mobileqq.data.MessageRecord;
import java.util.List;
import msf.msgcomm.msg_comm.Msg;
import tencent.im.msg.im_msg_body.Elem;
import tencent.im.msg.im_msg_body.RichMsg;

public class adhz
  extends adic
{
  public int a()
  {
    return super.a() + 6;
  }
  
  public boolean a(List<im_msg_body.Elem> paramList, msg_comm.Msg paramMsg, List<MessageRecord> paramList1, StringBuilder paramStringBuilder, boolean paramBoolean1, boolean paramBoolean2, bfoy parambfoy, bcsc parambcsc, bcre parambcre)
  {
    new bcrt().f(paramList, paramList1, paramStringBuilder, paramMsg, parambfoy);
    return true;
  }
  
  public boolean a(im_msg_body.Elem paramElem)
  {
    return paramElem.rich_msg.has();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     adhz
 * JD-Core Version:    0.7.0.1
 */