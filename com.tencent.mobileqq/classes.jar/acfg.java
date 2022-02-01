import com.tencent.mobileqq.data.MessageForLongTextMsg;
import com.tencent.mobileqq.data.MessageForText;
import com.tencent.mobileqq.data.MessageForWriteTogether;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.List;
import msf.msgcomm.msg_comm.Msg;
import tencent.im.msg.hummer.servtype.hummer_commelem.MsgElemInfo_servtype35;
import tencent.im.msg.im_msg_body.CommonElem;
import tencent.im.msg.im_msg_body.Elem;

public class acfg
  extends acew
{
  private MessageForWriteTogether a(im_msg_body.Elem paramElem, MessageRecord paramMessageRecord)
  {
    boolean bool1 = true;
    MessageForWriteTogether localMessageForWriteTogether = new MessageForWriteTogether();
    MessageRecord.copyMessageRecordBaseField(localMessageForWriteTogether, paramMessageRecord);
    hummer_commelem.MsgElemInfo_servtype35 localMsgElemInfo_servtype35;
    if (paramElem.common_elem.bytes_pb_elem.has()) {
      localMsgElemInfo_servtype35 = new hummer_commelem.MsgElemInfo_servtype35();
    }
    try
    {
      localMsgElemInfo_servtype35.mergeFrom(paramElem.common_elem.bytes_pb_elem.get().toByteArray());
      if (!localMsgElemInfo_servtype35.bytes_global_padid.has()) {}
      paramElem = localMsgElemInfo_servtype35.bytes_token.get().toStringUtf8();
      String str = localMsgElemInfo_servtype35.bytes_global_padid.get().toStringUtf8();
      int i = localMsgElemInfo_servtype35.uint32_get_rev.get();
      int j = localMsgElemInfo_servtype35.uint32_his_edit_uin_num.get();
      bool2 = false;
      if ((paramMessageRecord instanceof MessageForLongTextMsg))
      {
        paramMessageRecord = (MessageForLongTextMsg)paramMessageRecord;
        paramMessageRecord.parse();
        if ((paramMessageRecord.sb == null) || (paramMessageRecord.sb.length() < 6000)) {
          break label236;
        }
        a(localMessageForWriteTogether, paramElem, str, i, bool1, j);
        return localMessageForWriteTogether;
      }
    }
    catch (InvalidProtocolBufferMicroException paramElem)
    {
      for (;;)
      {
        boolean bool2;
        paramElem.printStackTrace();
        continue;
        bool1 = bool2;
        if ((paramMessageRecord instanceof MessageForText))
        {
          paramMessageRecord = (MessageForText)paramMessageRecord;
          paramMessageRecord.parse();
          bool1 = bool2;
          if (paramMessageRecord.sb != null)
          {
            bool1 = bool2;
            if (paramMessageRecord.sb.length() >= 6000)
            {
              bool1 = true;
              continue;
              label236:
              bool1 = false;
            }
          }
        }
      }
    }
  }
  
  private void a(MessageForWriteTogether paramMessageForWriteTogether, String paramString1, String paramString2, int paramInt1, boolean paramBoolean, int paramInt2)
  {
    paramMessageForWriteTogether.token = paramString1;
    paramMessageForWriteTogether.padId = paramString2;
    paramMessageForWriteTogether.baseRev = paramInt1;
    paramMessageForWriteTogether.isLongMsg = paramBoolean;
    paramMessageForWriteTogether.partCnt = paramInt2;
    paramMessageForWriteTogether.msgtype = -7014;
    paramMessageForWriteTogether.saveExtInfoToExtStr("write_together_token", paramString1);
    paramMessageForWriteTogether.saveExtInfoToExtStr("write_together_pad_id", paramString2);
    paramMessageForWriteTogether.saveExtInfoToExtStr("write_together_base_rev", String.valueOf(paramInt1));
    paramMessageForWriteTogether.saveExtInfoToExtStr("write_together_part_cnt", String.valueOf(paramInt2));
    paramMessageForWriteTogether.saveExtInfoToExtStr("write_together_long_msg", String.valueOf(paramBoolean));
  }
  
  private boolean a(im_msg_body.Elem paramElem, List<MessageRecord> paramList)
  {
    if ((paramElem == null) || (paramList == null) || (paramList.size() == 0))
    {
      QLog.e("WriteTogetherElemDecode", 1, "[decodeWriteTogetherMsg] elem: " + paramElem + ", message: " + paramList);
      return false;
    }
    if ((QLog.isColorLevel()) && (paramList.size() != 1))
    {
      Iterator localIterator = paramList.iterator();
      while (localIterator.hasNext())
      {
        MessageRecord localMessageRecord = (MessageRecord)localIterator.next();
        QLog.d("WriteTogetherElemDecode", 1, "[decodeWriteTogetherMsg] " + localMessageRecord.toString());
      }
    }
    paramList.set(0, a(paramElem, (MessageRecord)paramList.get(0)));
    return true;
  }
  
  public int a()
  {
    return -1000;
  }
  
  public boolean a(List<im_msg_body.Elem> paramList, msg_comm.Msg paramMsg, List<MessageRecord> paramList1, StringBuilder paramStringBuilder, boolean paramBoolean1, boolean paramBoolean2, bdyi parambdyi, bblm parambblm, bbkm parambbkm)
  {
    if (paramList1 == null) {
      return false;
    }
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      paramMsg = (im_msg_body.Elem)paramList.next();
      if ((a(paramMsg)) && (a(paramMsg, paramList1))) {
        return true;
      }
    }
    return false;
  }
  
  public boolean a(im_msg_body.Elem paramElem)
  {
    return (paramElem.common_elem.has()) && (35 == paramElem.common_elem.uint32_service_type.get());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     acfg
 * JD-Core Version:    0.7.0.1
 */