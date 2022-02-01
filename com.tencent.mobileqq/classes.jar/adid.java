import com.tencent.mobileqq.data.MessageRecord;
import java.util.List;
import msf.msgcomm.msg_comm.Msg;
import tencent.im.msg.im_msg_body.Elem;
import tencent.im.msg.im_msg_body.SourceMsg;

public class adid
  extends adic
{
  public int a()
  {
    return super.a() + 3;
  }
  
  public boolean a(List<im_msg_body.Elem> paramList, msg_comm.Msg paramMsg, List<MessageRecord> paramList1, StringBuilder paramStringBuilder, boolean paramBoolean1, boolean paramBoolean2, bfoy parambfoy, bcsc parambcsc, bcre parambcre)
  {
    new bcrt().h(paramList, paramList1, paramStringBuilder, paramMsg, parambfoy);
    return true;
  }
  
  public boolean a(im_msg_body.Elem paramElem)
  {
    return paramElem.src_msg.has();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     adid
 * JD-Core Version:    0.7.0.1
 */