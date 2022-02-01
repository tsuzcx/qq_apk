import com.tencent.biz.bmqq.protocol.Crm.CrmCCNotify;
import com.tencent.biz.bmqq.protocol.Crm.GrayMsg;
import com.tencent.biz.bmqq.protocol.Crm.QidianGroupMsg;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.MessageHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.qidian.data.BmqqAccountType;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import msf.msgcomm.msg_comm.Msg;
import msf.msgcomm.msg_comm.MsgHead;
import org.json.JSONObject;
import tencent.im.msg.im_msg_body.CrmElem;
import tencent.im.msg.im_msg_body.Elem;

public class acdw
  extends acew
{
  public int a()
  {
    return -1000;
  }
  
  public void a(im_msg_body.Elem paramElem, List<MessageRecord> paramList, StringBuilder paramStringBuilder, msg_comm.Msg paramMsg, bblm parambblm)
  {
    QQAppInterface localQQAppInterface = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
    Object localObject1 = localQQAppInterface.getMsgHandler();
    Object localObject2 = (im_msg_body.CrmElem)paramElem.crm_elem.get();
    if (localObject2 != null)
    {
      i = ((im_msg_body.CrmElem)localObject2).uint32_qidian_flag.get();
      if (QLog.isColorLevel()) {
        paramStringBuilder.append("has uint32_qidian_flag:").append(i).append(";");
      }
      if (i == 1)
      {
        if (!paramList.isEmpty()) {
          ((MessageRecord)paramList.get(0)).saveExtInfoToExtStr("crmelem_qidian_flag", i + "");
        }
        paramStringBuilder = ((MessageHandler)localObject1).app.getCurrentAccountUin();
        paramElem = String.valueOf(paramMsg.msg_head.from_uin.get());
        if (!paramStringBuilder.equals(paramElem))
        {
          paramStringBuilder = (bily)((MessageHandler)localObject1).app.getManager(165);
          if (!paramStringBuilder.a.containsKey(paramElem)) {
            paramStringBuilder.a(new BmqqAccountType(paramElem, 1));
          }
        }
        if ((parambblm != null) && (parambblm.a == 1024)) {
          parambblm.a = 1025;
        }
      }
      if (((im_msg_body.CrmElem)localObject2).crm_buf.has()) {
        paramElem = new Crm.CrmCCNotify();
      }
    }
    while (!QLog.isColorLevel()) {
      try
      {
        paramElem.mergeFrom(((im_msg_body.CrmElem)localObject2).crm_buf.get().toByteArray());
        int i = paramElem.crm_flag.get();
        int j;
        long l1;
        if ((i == 8) && (paramElem.qidian_group_msg.has()))
        {
          paramStringBuilder = (Crm.QidianGroupMsg)paramElem.qidian_group_msg.get();
          j = paramStringBuilder.uint32_group_task_id.get();
          int k = paramStringBuilder.uint32_group_msg_type.get();
          l1 = paramStringBuilder.uint64_kfuin.get();
          int m = paramStringBuilder.uint32_show_tip.get();
          paramStringBuilder = paramStringBuilder.str_tip_text.get();
          if (!paramList.isEmpty())
          {
            localObject2 = (MessageRecord)paramList.get(0);
            if (localObject2 != null)
            {
              ((MessageRecord)localObject2).mQidianTaskId = j;
              ((MessageRecord)localObject2).mQidianMasterUin = l1;
              ((MessageRecord)localObject2).mIsShowQidianTips = m;
              ((MessageRecord)localObject2).mQidianTipText = paramStringBuilder;
            }
          }
          if (QLog.isColorLevel()) {
            QLog.d("CrmFlagsElemDecoder", 2, String.format("received qidian bulk message taskId: %d, msgType: %d", new Object[] { Integer.valueOf(j), Integer.valueOf(k) }));
          }
          bblf.a((MessageHandler)localObject1, paramMsg.msg_head.from_uin.get(), paramMsg.msg_head.msg_seq.get(), paramMsg.msg_head.msg_uid.get(), paramMsg.msg_head.msg_type.get());
          if (j != 0)
          {
            paramStringBuilder = (bing)localQQAppInterface.getBusinessHandler(85);
            localObject1 = new JSONObject();
            ((JSONObject)localObject1).put("action", "receive");
            ((JSONObject)localObject1).put("fromUin", String.valueOf(paramMsg.msg_head.from_uin.get()));
            ((JSONObject)localObject1).put("toUin", localQQAppInterface.getCurrentAccountUin());
            ((JSONObject)localObject1).put("taskID", String.valueOf(j));
            ((JSONObject)localObject1).put("clickURL", "");
            ((JSONObject)localObject1).put("timestamp", String.valueOf(System.currentTimeMillis() / 1000L));
            paramStringBuilder.a(((JSONObject)localObject1).toString(), String.valueOf(paramMsg.msg_head.from_uin.get()), "", 10009, 0);
          }
        }
        if ((i == 11) && (paramElem.msg_gray_msg.has()))
        {
          localObject1 = (Crm.GrayMsg)paramElem.msg_gray_msg.get();
          i = ((Crm.GrayMsg)localObject1).uint32_type.get();
          paramStringBuilder = ((Crm.GrayMsg)localObject1).str_text.get();
          l1 = ((Crm.GrayMsg)localObject1).uint64_from_uin.get();
          j = paramMsg.msg_head.msg_seq.get();
          long l2 = paramMsg.msg_head.msg_uid.get();
          localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append(j);
          ((StringBuilder)localObject1).append(l2);
          if (QLog.isColorLevel()) {
            QLog.d("CrmFlagsElemDecoder", 2, String.format("received qidian gray msg type: %d, tips: %s, fromUin: %d", new Object[] { Integer.valueOf(i), paramStringBuilder, Long.valueOf(l1) }));
          }
          bint.a(localQQAppInterface, String.valueOf(l1), paramStringBuilder, 1024, ((StringBuilder)localObject1).toString());
        }
        if (paramElem.str_check_id.has()) {
          bint.a(localQQAppInterface, paramList, paramMsg, parambblm, paramElem);
        }
        if ((parambblm != null) && (parambblm.a == 1024) && (paramElem.str_ext_nick_name.has()))
        {
          paramElem = paramElem.str_ext_nick_name.get();
          if (!paramList.isEmpty())
          {
            paramList = (MessageRecord)paramList.get(0);
            if (paramList != null) {
              paramList.saveExtInfoToExtStr("qidian_ext_nick_name", paramElem);
            }
          }
        }
        return;
      }
      catch (Exception paramElem)
      {
        while (!QLog.isColorLevel()) {}
        QLog.e("CrmFlagsElemDecoder", 2, "receive ccNotify but throw exception " + paramElem.getMessage());
        return;
      }
    }
    paramStringBuilder.append("has crmElem, but crmElem is null");
  }
  
  public boolean a(List<im_msg_body.Elem> paramList, msg_comm.Msg paramMsg, List<MessageRecord> paramList1, StringBuilder paramStringBuilder, boolean paramBoolean1, boolean paramBoolean2, bdyi parambdyi, bblm parambblm, bbkm parambbkm)
  {
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      parambdyi = (im_msg_body.Elem)paramList.next();
      if (a(parambdyi)) {
        a(parambdyi, paramList1, paramStringBuilder, paramMsg, parambblm);
      }
    }
    return false;
  }
  
  public boolean a(im_msg_body.Elem paramElem)
  {
    return paramElem.crm_elem.has();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     acdw
 * JD-Core Version:    0.7.0.1
 */