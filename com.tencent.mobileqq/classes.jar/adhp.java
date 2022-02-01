import com.tencent.mobileqq.data.MessageForLimitChatConfirm;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.List;
import msf.msgcomm.msg_comm.Msg;
import tencent.im.msg.hummer.servtype.hummer_commelem.MsgElemInfo_servtype24;
import tencent.im.msg.hummer.servtype.hummer_commelem.MsgElemInfo_servtype24.LimitChatEnter;
import tencent.im.msg.hummer.servtype.hummer_commelem.MsgElemInfo_servtype24.LimitChatExit;
import tencent.im.msg.im_msg_body.CommonElem;
import tencent.im.msg.im_msg_body.Elem;

public class adhp
  extends adic
{
  private void a(List<im_msg_body.Elem> paramList, List<MessageRecord> paramList1, StringBuilder paramStringBuilder)
  {
    MessageForLimitChatConfirm localMessageForLimitChatConfirm = null;
    Iterator localIterator = paramList.iterator();
    do
    {
      paramList = localMessageForLimitChatConfirm;
      if (!localIterator.hasNext()) {
        break;
      }
      paramList = (im_msg_body.Elem)localIterator.next();
    } while (!paramList.common_elem.has());
    paramList = (im_msg_body.CommonElem)paramList.common_elem.get();
    if (paramList == null) {
      return;
    }
    if (QLog.isColorLevel()) {
      paramStringBuilder.append("decodePBMsgElems_LimitChatConfirmMsg;\n");
    }
    paramStringBuilder = new hummer_commelem.MsgElemInfo_servtype24();
    for (;;)
    {
      try
      {
        paramStringBuilder.mergeFrom(paramList.bytes_pb_elem.get().toByteArray());
        localMessageForLimitChatConfirm = (MessageForLimitChatConfirm)bcry.a(-7005);
        localMessageForLimitChatConfirm.msgtype = -7005;
        if (paramList.uint32_business_type.has())
        {
          i = paramList.uint32_business_type.get();
          if (i != 1) {
            break label375;
          }
          if (!paramStringBuilder.limit_chat_enter.has()) {
            break label364;
          }
          localMessageForLimitChatConfirm.SenderNickName = paramStringBuilder.limit_chat_enter.bytes_match_nick.get().toStringUtf8();
          localMessageForLimitChatConfirm.tipsWording = paramStringBuilder.limit_chat_enter.bytes_tips_wording.get().toStringUtf8();
          localMessageForLimitChatConfirm.leftChatTime = paramStringBuilder.limit_chat_enter.uint32_left_chat_time.get();
          localMessageForLimitChatConfirm.c2cExpiredTime = paramStringBuilder.limit_chat_enter.uint32_c2c_expired_time.get();
          localMessageForLimitChatConfirm.matchExpiredTime = paramStringBuilder.limit_chat_enter.uint32_match_expired_time.get();
          localMessageForLimitChatConfirm.timeStamp = paramStringBuilder.limit_chat_enter.uint64_match_ts.get();
          localMessageForLimitChatConfirm.readyTs = paramStringBuilder.limit_chat_enter.uint64_ready_ts.get();
          localMessageForLimitChatConfirm.bEnterMsg = true;
          if (QLog.isColorLevel()) {
            QLog.i("LimitChatConfirmElemDecoderLimitChatConfirm msg", 1, " decodePBMsgElems_LimitChatConfirmMsg type" + i + " " + localMessageForLimitChatConfirm.matchExpiredTime + " " + localMessageForLimitChatConfirm.frienduin);
          }
          localMessageForLimitChatConfirm.prewrite();
          paramList1.add(localMessageForLimitChatConfirm);
          return;
        }
      }
      catch (InvalidProtocolBufferMicroException paramList)
      {
        paramList.printStackTrace();
        QLog.e("LimitChatConfirmElemDecoderscribble msg", 1, paramList, new Object[0]);
        return;
      }
      int i = 1;
      continue;
      label364:
      QLog.e("LimitChatConfirmElemDecoderExtendFriendLimitChatLimitChatConfirm msg", 1, " !!!limitChatElem  limit_chat_enter is null ");
      continue;
      label375:
      if (paramStringBuilder.limit_chat_exit.has())
      {
        localMessageForLimitChatConfirm.bEnterMsg = false;
        localMessageForLimitChatConfirm.leaveChatType = paramStringBuilder.limit_chat_exit.uint32_exit_method.get();
        localMessageForLimitChatConfirm.timeStamp = paramStringBuilder.limit_chat_exit.uint64_match_ts.get();
      }
      else
      {
        QLog.e("LimitChatConfirmElemDecoderLimitChatConfirm msg", 1, " limitChatElem  limit_chat_exit is null ");
      }
    }
  }
  
  public int a()
  {
    return 1000;
  }
  
  public boolean a(List<im_msg_body.Elem> paramList, msg_comm.Msg paramMsg, List<MessageRecord> paramList1, StringBuilder paramStringBuilder, boolean paramBoolean1, boolean paramBoolean2, bfoy parambfoy, bcsc parambcsc, bcre parambcre)
  {
    a(paramList, paramList1, paramStringBuilder);
    return true;
  }
  
  public boolean a(im_msg_body.Elem paramElem)
  {
    return (paramElem.common_elem.has()) && (24 == paramElem.common_elem.uint32_service_type.get());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     adhp
 * JD-Core Version:    0.7.0.1
 */