import com.tencent.mobileqq.data.MessageForShakeWindow;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.ShakeWindowMsg;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.List;
import msf.msgcomm.msg_comm.Msg;
import tencent.im.msg.im_msg_body.Elem;
import tencent.im.msg.im_msg_body.ShakeWindow;

public class aceu
  extends acew
{
  private void a(List<im_msg_body.Elem> paramList, List<MessageRecord> paramList1, StringBuilder paramStringBuilder, boolean paramBoolean)
  {
    Object localObject = paramList.iterator();
    do
    {
      if (!((Iterator)localObject).hasNext()) {
        break;
      }
      paramList = (im_msg_body.Elem)((Iterator)localObject).next();
    } while (!paramList.shake_window.has());
    for (;;)
    {
      if (paramList == null) {
        return;
      }
      if (QLog.isColorLevel()) {
        paramStringBuilder.append("elemType:ShakeWindow;\n");
      }
      paramList = (im_msg_body.ShakeWindow)paramList.shake_window.get();
      localObject = (MessageForShakeWindow)bbli.a(-2020);
      ((MessageForShakeWindow)localObject).msgtype = -2020;
      ((MessageForShakeWindow)localObject).msg = "[Shake Window]";
      ShakeWindowMsg localShakeWindowMsg = new ShakeWindowMsg();
      localShakeWindowMsg.mType = paramList.uint32_type.get();
      localShakeWindowMsg.mReserve = paramList.uint32_reserve.get();
      if (paramBoolean) {}
      for (int i = 2;; i = 1)
      {
        localShakeWindowMsg.onlineFlag = i;
        localShakeWindowMsg.shake = true;
        ((MessageForShakeWindow)localObject).msgData = localShakeWindowMsg.getBytes();
        if (((MessageForShakeWindow)localObject).msgData != null) {
          break label186;
        }
        if (!QLog.isColorLevel()) {
          break;
        }
        paramStringBuilder.append("c2cMsgContent.data:null;\n");
        return;
      }
      label186:
      paramList1.add(localObject);
      return;
      paramList = null;
    }
  }
  
  public int a()
  {
    return 1000;
  }
  
  public boolean a(List<im_msg_body.Elem> paramList, msg_comm.Msg paramMsg, List<MessageRecord> paramList1, StringBuilder paramStringBuilder, boolean paramBoolean1, boolean paramBoolean2, bdyi parambdyi, bblm parambblm, bbkm parambbkm)
  {
    a(paramList, paramList1, paramStringBuilder, paramBoolean1);
    return true;
  }
  
  public boolean a(im_msg_body.Elem paramElem)
  {
    return paramElem.shake_window.has();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aceu
 * JD-Core Version:    0.7.0.1
 */