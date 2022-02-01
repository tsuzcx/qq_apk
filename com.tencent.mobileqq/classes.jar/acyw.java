import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.List;
import msf.msgcomm.msg_comm.Msg;
import tencent.im.msg.im_msg_body.Elem;
import tencent.im.msg.im_msg_body.NearByMessageType;

public class acyw
  extends aczg
{
  public int a()
  {
    return -1000;
  }
  
  public boolean a(List<im_msg_body.Elem> paramList, msg_comm.Msg paramMsg, List<MessageRecord> paramList1, StringBuilder paramStringBuilder, boolean paramBoolean1, boolean paramBoolean2, bepr parambepr, bbzl parambbzl, bbyn parambbyn)
  {
    paramList = paramList.iterator();
    while (paramList.hasNext()) {
      if (a((im_msg_body.Elem)paramList.next()))
      {
        if (!paramList1.isEmpty()) {
          ((MessageRecord)paramList1.get(0)).saveExtInfoToExtStr("identify_flag", "true");
        }
        if (QLog.isColorLevel()) {
          paramStringBuilder.append("elemType: near_by_msg has identify;\n");
        }
      }
    }
    return false;
  }
  
  public boolean a(im_msg_body.Elem paramElem)
  {
    return (paramElem.near_by_msg.has()) && (paramElem.near_by_msg.uint32_identify_type.has()) && (paramElem.near_by_msg.uint32_identify_type.get() == 1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     acyw
 * JD-Core Version:    0.7.0.1
 */