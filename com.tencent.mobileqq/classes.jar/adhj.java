import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.pb.PBUInt32Field;
import java.util.Iterator;
import java.util.List;
import msf.msgcomm.msg_comm.Msg;
import tencent.im.msg.im_msg_body.CommonElem;
import tencent.im.msg.im_msg_body.Elem;

public class adhj
  extends adic
{
  public int a()
  {
    return -1000;
  }
  
  public boolean a(List<im_msg_body.Elem> paramList, msg_comm.Msg paramMsg, List<MessageRecord> paramList1, StringBuilder paramStringBuilder, boolean paramBoolean1, boolean paramBoolean2, bfoy parambfoy, bcsc parambcsc, bcre parambcre)
  {
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      paramStringBuilder = (im_msg_body.Elem)paramList.next();
      if (a(paramStringBuilder)) {
        avlm.a(paramMsg, paramStringBuilder, paramList1, (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime(), parambcre);
      }
    }
    return false;
  }
  
  public boolean a(im_msg_body.Elem paramElem)
  {
    return (paramElem.common_elem.has()) && (34 == paramElem.common_elem.uint32_service_type.get());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     adhj
 * JD-Core Version:    0.7.0.1
 */