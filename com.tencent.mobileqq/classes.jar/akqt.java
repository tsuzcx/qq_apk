import ActionMsg.MsgBody;
import IMMsgBodyPack.MsgType0x210;
import OnlinePushPack.MsgInfo;
import PushNotifyPack.RequestPushNotify;
import android.content.res.Resources;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.mobileqq.apollo.utils.ApolloUtil;
import com.tencent.mobileqq.app.MessageHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.mobileqq.data.AppShareID;
import com.tencent.mobileqq.data.MarkFaceMessage;
import com.tencent.mobileqq.data.MessageForApollo;
import com.tencent.mobileqq.data.MessageForArkBabyqReply;
import com.tencent.mobileqq.data.MessageForFuDai;
import com.tencent.mobileqq.data.MessageForMarketFace;
import com.tencent.mobileqq.data.MessageForPic;
import com.tencent.mobileqq.data.MessageForPubAccount;
import com.tencent.mobileqq.data.MessageForQQWalletMsg;
import com.tencent.mobileqq.data.MessageForStructing;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.PAMessage;
import com.tencent.mobileqq.data.PAMessage.Item;
import com.tencent.mobileqq.data.SubAccountInfo;
import com.tencent.mobileqq.data.SubAccountMessage;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.structmsg.AbsStructMsg;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.SimpleAccount;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import mqq.app.MobileQQ;
import mqq.manager.TicketManager;
import mqq.manager.WtloginManager;
import msf.msgcomm.msg_comm.Msg;
import msf.msgcomm.msg_comm.MsgHead;
import msf.msgcomm.msg_comm.UinPairMsg;
import msf.msgsvc.msg_svc.PbBindUinGetMsgReq;
import msf.msgsvc.msg_svc.PbBindUinMsgReadedConfirmReq;
import msf.msgsvc.msg_svc.PbBindUinMsgReadedConfirmResp;
import msf.msgsvc.msg_svc.PbGetMsgResp;
import msf.msgsvc.msg_svc.PbThirdQQUnReadMsgNumReq;
import msf.msgsvc.msg_svc.PbThirdQQUnReadMsgNumReq.ThirdQQReqInfo;
import msf.msgsvc.msg_svc.PbThirdQQUnReadMsgNumResp;
import msf.msgsvc.msg_svc.PbThirdQQUnReadMsgNumResp.ThirdQQRespInfo;
import msf.msgsvc.msg_svc.PbUnReadMsgSeqReq;
import msf.msgsvc.msg_svc.PbUnReadMsgSeqResp;
import oicq.wlogin_sdk.request.Ticket;
import tencent.im.msg.im_msg_body.MsgBody;
import tencent.im.msg.im_msg_body.NotOnlineFile;
import tencent.im.msg.im_msg_body.RichText;
import tencent.im.msgsync.cmd0x100.Submsgtype0x8a.ReqBody;
import tencent.im.oidb.cmd0x5d0.Oidb_0x5d0.ReqBody;
import tencent.im.oidb.cmd0x5d0.Oidb_0x5d0.RspBody;
import tencent.im.oidb.oidb_sso.OIDBSSOPkg;

public class akqt
  extends akow
{
  public akqt(QQAppInterface paramQQAppInterface, MessageHandler paramMessageHandler)
  {
    super(paramQQAppInterface, paramMessageHandler);
  }
  
  private void b(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    String str1;
    if (paramToServiceMsg == null) {
      str1 = "null";
    }
    for (;;)
    {
      String str2;
      label16:
      int i;
      long l;
      Object localObject2;
      msg_svc.PbBindUinMsgReadedConfirmResp localPbBindUinMsgReadedConfirmResp;
      Object localObject1;
      int j;
      if (paramToServiceMsg == null)
      {
        str2 = "null";
        i = -1;
        l = 0L;
        localObject2 = null;
        paramFromServiceMsg = null;
        localPbBindUinMsgReadedConfirmResp = new msg_svc.PbBindUinMsgReadedConfirmResp();
        localObject1 = localObject2;
        j = i;
      }
      try
      {
        paramObject = (msg_svc.PbBindUinMsgReadedConfirmResp)localPbBindUinMsgReadedConfirmResp.mergeFrom((byte[])paramObject);
        localObject1 = localObject2;
        j = i;
        i = paramObject.result.get();
        localObject1 = localObject2;
        j = i;
        if (paramObject.sync_cookie.has())
        {
          localObject1 = localObject2;
          j = i;
          paramFromServiceMsg = paramObject.sync_cookie.get().toByteArray();
        }
        localObject1 = paramFromServiceMsg;
        j = i;
        if (paramObject.bind_uin.has())
        {
          localObject1 = paramFromServiceMsg;
          j = i;
          l = paramObject.bind_uin.get();
        }
        localObject1 = paramFromServiceMsg;
        j = i;
        if (paramObject.errmsg.has())
        {
          localObject1 = paramFromServiceMsg;
          j = i;
          paramObject = paramObject.errmsg.get();
          localObject2 = paramObject;
          localObject1 = paramFromServiceMsg;
          j = i;
        }
      }
      catch (Exception localException1)
      {
        for (;;)
        {
          try
          {
            if (QLog.isColorLevel())
            {
              localObject2 = new StringBuilder().append("handleConfirmSubAccountMsgNumReaded() subUin=").append(str2).append(" lSubUin=").append(l).append(" errMsg=").append(paramObject).append(" cookie=");
              if (paramFromServiceMsg == null)
              {
                localObject1 = "null";
                QLog.d("SUB_ACCOUNT", 2, localObject1);
                j = i;
                localObject1 = paramFromServiceMsg;
                localObject2 = paramObject;
              }
            }
            else
            {
              if (QLog.isColorLevel())
              {
                paramFromServiceMsg = new StringBuilder().append("handleConfirmSubAccountMsgNumReaded() ssoSeq:");
                if (paramToServiceMsg != null) {
                  continue;
                }
                paramToServiceMsg = "null";
                paramFromServiceMsg = paramFromServiceMsg.append(paramToServiceMsg).append(" result=").append(j).append(" syncCookie=");
                if (localObject1 != null) {
                  continue;
                }
                paramToServiceMsg = "null";
                QLog.d("SUB_ACCOUNT", 2, paramToServiceMsg + " errms=" + String.valueOf(localObject2));
              }
              boolean bool = false;
              if (j == 0)
              {
                paramToServiceMsg = (ayav)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(61);
                if (paramToServiceMsg != null) {
                  paramToServiceMsg.a(str2, (byte[])localObject1);
                }
                bool = true;
              }
              a(8011, bool, new String[] { str2, str1 });
              return;
              str1 = paramToServiceMsg.extraData.getString("nextAction");
              break;
              str2 = paramToServiceMsg.extraData.getString("subAccount");
              break label16;
            }
            j = paramFromServiceMsg.length;
            localObject1 = Integer.valueOf(j);
            continue;
            localException1 = localException1;
            paramObject = null;
            i = j;
            paramFromServiceMsg = (FromServiceMsg)localObject1;
          }
          catch (Exception localException2)
          {
            continue;
          }
          localObject2 = paramObject;
          localObject1 = paramFromServiceMsg;
          j = i;
          if (QLog.isColorLevel())
          {
            QLog.e("SUB_ACCOUNT", 2, "handleConfirmSubAccountMsgNumReaded() decode pb:", localException1);
            localObject2 = paramObject;
            localObject1 = paramFromServiceMsg;
            j = i;
            continue;
            paramToServiceMsg = Integer.valueOf(paramToServiceMsg.getRequestSsoSeq());
            continue;
            paramToServiceMsg = Integer.toString(localObject1.length);
            continue;
            paramObject = null;
          }
        }
      }
    }
  }
  
  private void c(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    ayaw localayaw = new ayaw();
    String str1 = paramToServiceMsg.extraData.getString("subAccount");
    String str2 = paramToServiceMsg.getUin();
    localayaw.jdField_b_of_type_JavaLangString = str2;
    localayaw.jdField_c_of_type_JavaLangString = str1;
    if (QLog.isColorLevel()) {
      QLog.d("SUB_ACCOUNT", 2, "subaccount cmd= CMD_MESSAGESERVICE_GETSUBACCOUNTMSG_PB handleGetSubC2CMessageResp_PB subUin=" + str1);
    }
    Object localObject1 = new msg_svc.PbGetMsgResp();
    try
    {
      if (QLog.isColorLevel()) {
        QLog.d("printPBuffer", 2, bbdm.a((byte[])paramObject));
      }
      paramObject = (msg_svc.PbGetMsgResp)((msg_svc.PbGetMsgResp)localObject1).mergeFrom((byte[])paramObject);
    }
    catch (Exception paramObject)
    {
      for (;;)
      {
        StringBuilder localStringBuilder;
        if (QLog.isColorLevel()) {
          QLog.e("Q.msg.C2CMessageProcessor", 2, "subaccount <---handleGetSubC2CMessageResp_PB : decode pb:", paramObject);
        }
        paramObject = null;
        continue;
        localObject1 = Integer.valueOf(paramToServiceMsg.getRequestSsoSeq());
        continue;
        localObject1 = Integer.valueOf(paramObject.result.get());
        continue;
        localObject1 = Boolean.valueOf(paramObject.sync_cookie.has());
        continue;
        localObject1 = Integer.valueOf(paramObject.sync_flag.get());
      }
      localayav = (ayav)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(61);
      if (!paramObject.result.has()) {
        break label415;
      }
    }
    if (QLog.isColorLevel())
    {
      localStringBuilder = new StringBuilder().append("subaccount <---handleGetSubC2CMessageResp_PB ssoSeq:");
      if (paramToServiceMsg == null)
      {
        localObject1 = "null";
        localStringBuilder = localStringBuilder.append(localObject1).append(" msgStruct.cReplyCode: ");
        if (paramObject != null) {
          break label336;
        }
        localObject1 = "null";
        localStringBuilder = localStringBuilder.append(localObject1).append(",hasSyncCookie:");
        if (paramObject != null) {
          break label351;
        }
        localObject1 = "null";
        localStringBuilder = localStringBuilder.append(localObject1).append(",syncFlag:");
        if (paramObject != null) {
          break label366;
        }
        localObject1 = "null";
        QLog.d("SUB_ACCOUNT", 2, localObject1);
      }
    }
    else
    {
      if (paramObject != null) {
        break label381;
      }
      paramToServiceMsg = new HashMap();
      paramToServiceMsg.put("param_FailCode", "12014");
      paramToServiceMsg.put("fail_step", "getmsgresp_null");
      paramToServiceMsg.put("fail_location", "MessageHandler");
      axrl.a(BaseApplication.getContext()).a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), "actSBGetMsg", false, 0L, 0L, paramToServiceMsg, "");
      a(8003, false, localayaw);
      return;
    }
    label336:
    label351:
    label366:
    label381:
    ayav localayav;
    label415:
    int i;
    if (paramObject.result.get() != 0)
    {
      i = paramObject.result.get();
      if (QLog.isColorLevel()) {
        QLog.d("SUB_ACCOUNT", 2, "subaccount <PbGetMsg><R><---handleGetSubC2CMessageResp_PB rspResult = " + i);
      }
      paramToServiceMsg = new HashMap();
      paramToServiceMsg.put("param_FailCode", "12015");
      paramToServiceMsg.put("fail_step", "result_" + i);
      paramToServiceMsg.put("fail_location", "MessageHandler");
      axrl.a(BaseApplication.getContext()).a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), "actSBGetMsg", false, 0L, 0L, paramToServiceMsg, "");
      if (i <= 100) {
        break label5472;
      }
      i -= 100;
    }
    label2080:
    label2740:
    label4029:
    label5472:
    for (;;)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.d("SUB_ACCOUNT", 2, "subaccount <PbGetMsg><R><---handleGetSubC2CMessageResp_PB really rspResult = " + i);
        }
        boolean bool1;
        switch (i)
        {
        default: 
          if ((i == 1200) || (i == 1214) || (i == 1215) || (i == 1218) || (i == 1232) || (i == 1233) || (i == 1240) || (i == 1241) || (i == 1242) || (i == 1221))
          {
            localayaw.jdField_a_of_type_Int = 1004;
            localayaw.jdField_b_of_type_Int = i;
            localayaw.jdField_a_of_type_JavaLangString = paramObject.errmsg.get();
            localayaw.jdField_c_of_type_Boolean = true;
            ayao.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (byte)0, str1);
            ayao.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, str1, 6);
            localayaw.d = true;
            localayav.a(str1, null, true);
            bool1 = localayav.a(str1, 3);
            localayav.a(str1, i, paramObject.errmsg.get());
            localayav.e(str1);
            if (bool1)
            {
              i = 1 - this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(str1, 7000);
              if (i != 0)
              {
                this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().c(str1, 7000, i);
                this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(new String[] { ajsf.x, str1 });
              }
              if (QLog.isColorLevel()) {
                QLog.d("SUB_ACCOUNT", 2, "processSubAccountMessage() hint need to verify,msg num=1, subUin=" + str1);
              }
            }
            this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.updateSubAccountLogin(str1, false);
            this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication().refreAccountList();
          }
          break;
        }
        for (;;)
        {
          a(8003, false, localayaw);
          if (!QLog.isColorLevel()) {
            break;
          }
          QLog.d("SUB_ACCOUNT", 2, "subaccount <PbGetMsg><R><---handleGetSubC2CMessageResp_PB getMsgResp == null || !getMsgResp.result.has() || getMsgResp.result.get() != 0 ");
          return;
          localayaw.jdField_a_of_type_Int = 1008;
          ayao.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "sub.uin.all");
          continue;
          localayaw.jdField_a_of_type_Int = 1002;
          ayao.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (byte)0, str1);
          ayao.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, str1);
          continue;
          localayaw.jdField_a_of_type_Int = 1006;
          continue;
          localayaw.jdField_a_of_type_Int = 1000;
        }
        localayav.a(str1, 1);
        localObject1 = paramFromServiceMsg.getUin();
        long l2 = -1L;
        try
        {
          l1 = Long.parseLong(str1);
          if (localObject1 == null)
          {
            a(8003, false, localayaw);
            if (QLog.isColorLevel()) {
              QLog.d("SUB_ACCOUNT", 2, "subaccount <PbGetMsg><R><---handleGetSubC2CMessageResp_PB tmpBackUin == null ");
            }
            paramToServiceMsg = new HashMap();
            paramToServiceMsg.put("param_FailCode", "12014");
            paramToServiceMsg.put("fail_step", "backuin_null");
            paramToServiceMsg.put("fail_location", "MessageHandler");
            axrl.a(BaseApplication.getContext()).a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), "actSBGetMsg", false, 0L, 0L, paramToServiceMsg, "");
            return;
          }
        }
        catch (Exception localException1)
        {
          for (;;)
          {
            localException1.printStackTrace();
            long l1 = l2;
            if (QLog.isColorLevel())
            {
              QLog.d("SUB_ACCOUNT", 2, "subaccount <PbGetMsg><R><---handleGetSubC2CMessageResp_PB subAccount parselong error ");
              l1 = l2;
              continue;
              try
              {
                l2 = Long.valueOf(paramFromServiceMsg.getUin()).longValue();
                if (l2 == -1L)
                {
                  a(8003, false, localayaw);
                  if (QLog.isColorLevel()) {
                    QLog.d("SUB_ACCOUNT", 2, "subaccount <PbGetMsg><R><---handleGetSubC2CMessageResp_PB selfUin == -1 ");
                  }
                  paramToServiceMsg = new HashMap();
                  paramToServiceMsg.put("param_FailCode", "12014");
                  paramToServiceMsg.put("fail_step", "selfUin_null");
                  paramToServiceMsg.put("fail_location", "MessageHandler");
                  axrl.a(BaseApplication.getContext()).a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), "actSBGetMsg", false, 0L, 0L, paramToServiceMsg, "");
                  return;
                }
              }
              catch (Exception paramFromServiceMsg)
              {
                for (;;)
                {
                  if (QLog.isColorLevel()) {
                    QLog.d("SUB_ACCOUNT", 2, "subaccount <PbGetMsg><R><---handleGetSubC2CMessageResp_PB selfUin parselong error ");
                  }
                  l2 = -1L;
                }
                if (paramObject.sync_cookie.has()) {}
                for (localObject1 = paramObject.sync_cookie.get().toByteArray();; localObject1 = null)
                {
                  if (paramObject.sync_flag.has()) {}
                  for (int j = paramObject.sync_flag.get();; j = 2)
                  {
                    byte b;
                    int k;
                    if (j < 2)
                    {
                      b = (byte)1;
                      k = 0;
                    }
                    for (;;)
                    {
                      if (paramObject.bind_uin.has()) {}
                      for (long l3 = paramObject.bind_uin.get();; l3 = 0L)
                      {
                        if (localayav != null) {}
                        for (List localList1 = localayav.a(Long.toString(l3));; localList1 = null)
                        {
                          ArrayList localArrayList = paramToServiceMsg.extraData.getStringArrayList("hadGetMsgListUin");
                          if (localArrayList == null) {
                            localArrayList = new ArrayList();
                          }
                          for (;;)
                          {
                            HashMap localHashMap = new HashMap();
                            List localList2 = paramObject.uin_pair_msgs.get();
                            int m = 0;
                            if (m < localList2.size())
                            {
                              paramFromServiceMsg = (msg_comm.UinPairMsg)localList2.get(m);
                              long l6 = paramFromServiceMsg.peer_uin.get();
                              long l4 = paramFromServiceMsg.last_read_time.get();
                              paramObject = paramFromServiceMsg.msg.get();
                              if (k == 0) {
                                localArrayList.add(Long.toString(l6));
                              }
                              int n = paramFromServiceMsg.unread_msg_num.get();
                              if (QLog.isColorLevel()) {
                                QLog.d("SUB_ACCOUNT", 2, "subaccount <---handleGetSubC2CMessageResp_PB pkgPeerUi cc n:" + l6);
                              }
                              if ((paramObject == null) || (paramObject.size() == 0) || (n == 0))
                              {
                                if (QLog.isColorLevel()) {
                                  QLog.d("SUB_ACCOUNT", 2, "subaccount <PbGetMsg><R><---handleGetSubC2CMessageResp_PB msgList == null || msgList.size() == 0 msg is null " + l6);
                                }
                                if (localList1 != null)
                                {
                                  paramFromServiceMsg = localList1.iterator();
                                  while (paramFromServiceMsg.hasNext())
                                  {
                                    paramObject = (SubAccountMessage)paramFromServiceMsg.next();
                                    if (paramObject != null)
                                    {
                                      paramObject = paramObject.frienduin;
                                      if ((paramObject != null) && (paramObject.equalsIgnoreCase(String.valueOf(l6))))
                                      {
                                        localArrayList.add(String.valueOf(l6));
                                        localHashMap.put(String.valueOf(l6), Integer.valueOf(n));
                                      }
                                    }
                                  }
                                }
                              }
                              awzu localawzu;
                              do
                              {
                                m += 1;
                                break;
                                if (QLog.isColorLevel()) {
                                  QLog.d("SUB_ACCOUNT", 2, "subaccount <---handleGetSubC2CMessageResp_PB pkgPeerUin:" + l6 + ",msgList size:" + paramObject.size());
                                }
                                localawzu = new awzu(l1, l6, false, false, false, true);
                              } while ((paramObject == null) || (paramObject.size() <= 0));
                              Collections.sort(paramObject, new akqu(this));
                              Iterator localIterator1;
                              if ((paramFromServiceMsg.msg_completed.has()) && (paramFromServiceMsg.msg_completed.get() != 0))
                              {
                                bool1 = true;
                                if (QLog.isColorLevel()) {
                                  QLog.d("SUB_ACCOUNT", 2, "subaccount <---handleGetSubC2CMessageResp_PB pkgPeerUin:" + l6 + "msgList size: " + paramObject.size() + ",uMsgCompleted:" + bool1 + ",lastReadTime:" + (l4 & 0xFFFFFFFF));
                                }
                                localIterator1 = paramObject.iterator();
                                label1893:
                                break label2080;
                              }
                              label1894:
                              Object localObject2;
                              Object localObject3;
                              int i1;
                              for (;;)
                              {
                                if (!localIterator1.hasNext()) {
                                  break label4882;
                                }
                                localObject2 = (msg_comm.Msg)localIterator1.next();
                                if (localObject2 != null)
                                {
                                  localObject3 = (msg_comm.MsgHead)((msg_comm.Msg)localObject2).msg_head.get();
                                  i = ((msg_comm.MsgHead)localObject3).msg_type.get();
                                  paramFromServiceMsg = null;
                                  i1 = ((msg_comm.MsgHead)((msg_comm.Msg)localObject2).msg_head.get()).c2c_cmd.get();
                                  if ((193 == i) || (734 == i)) {
                                    if (l1 != l6) {}
                                  }
                                  for (;;)
                                  {
                                    for (;;)
                                    {
                                      if ((paramFromServiceMsg != null) && (!paramFromServiceMsg.isEmpty()) && (localList1 != null) && (!localList1.isEmpty()) && (((MessageRecord)paramFromServiceMsg.get(0)).time < ((SubAccountMessage)localList1.get(0)).time)) {
                                        paramFromServiceMsg.clear();
                                      }
                                      if ((paramFromServiceMsg != null) && (paramFromServiceMsg.size() != 0)) {
                                        break label2701;
                                      }
                                      if (localList1 == null) {
                                        break label1894;
                                      }
                                      paramFromServiceMsg = localList1.iterator();
                                      if (!paramFromServiceMsg.hasNext()) {
                                        break label1894;
                                      }
                                      paramObject = (SubAccountMessage)paramFromServiceMsg.next();
                                      if (paramObject == null) {
                                        break label1893;
                                      }
                                      paramObject = paramObject.frienduin;
                                      if ((paramObject == null) || (!paramObject.equalsIgnoreCase(String.valueOf(l6)))) {
                                        break label1893;
                                      }
                                      localArrayList.add(String.valueOf(l6));
                                      localHashMap.put(String.valueOf(l6), Integer.valueOf(n));
                                      break label1894;
                                      bool1 = false;
                                      break;
                                      paramFromServiceMsg = new ArrayList();
                                      paramObject = axaq.a(193);
                                      paramObject.selfuin = String.valueOf(l1);
                                      paramObject.frienduin = String.valueOf(l6);
                                      paramObject.senderuin = String.valueOf(l6);
                                      paramObject.shmsgseq = ((msg_comm.MsgHead)localObject3).msg_seq.get();
                                      paramObject.msgUid = ((msg_comm.MsgHead)localObject3).msg_uid.get();
                                      paramObject.time = ((msg_comm.MsgHead)localObject3).msg_time.get();
                                      paramObject.istroop = 0;
                                      paramObject.msg = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getResources().getString(2131720720);
                                      paramObject.msgtype = 193;
                                      paramFromServiceMsg.add(paramObject);
                                      continue;
                                      if ((axas.c(i)) && (((msg_comm.MsgHead)localObject3).c2c_cmd.has()) && ((i1 == 169) || (i1 == 241) || (i1 == 242) || (i1 == 243) || (i1 == 129) || (i1 == 131) || (i1 == 133)))
                                      {
                                        if ((i1 == 129) || (i1 == 131) || (i1 == 133) || (i1 == 135) || (i1 == 243)) {
                                          break label1894;
                                        }
                                        for (;;)
                                        {
                                          try
                                          {
                                            paramFromServiceMsg = ((im_msg_body.NotOnlineFile)((im_msg_body.RichText)((im_msg_body.MsgBody)((msg_comm.Msg)localObject2).msg_body.get()).rich_text.get()).not_online_file.get()).bytes_file_name.get().toStringUtf8();
                                            paramObject = paramFromServiceMsg;
                                          }
                                          catch (Exception paramObject)
                                          {
                                            try
                                            {
                                              if (QLog.isColorLevel())
                                              {
                                                QLog.d("SUB_ACCOUNT", 2, "fileName = " + paramFromServiceMsg);
                                                paramObject = paramFromServiceMsg;
                                              }
                                              paramFromServiceMsg = paramObject;
                                              if (TextUtils.isEmpty(paramObject)) {
                                                paramFromServiceMsg = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getResources().getString(2131691292);
                                              }
                                              paramObject = axaq.a(-2005);
                                              paramObject.selfuin = String.valueOf(l1);
                                              paramObject.frienduin = String.valueOf(l6);
                                              paramObject.senderuin = String.valueOf(l6);
                                              paramObject.shmsgseq = ((msg_comm.MsgHead)localObject3).msg_seq.get();
                                              paramObject.msgUid = ((msg_comm.MsgHead)localObject3).msg_uid.get();
                                              paramObject.time = ((msg_comm.MsgHead)localObject3).msg_time.get();
                                              paramObject.istroop = 0;
                                              paramObject.msg = paramFromServiceMsg;
                                              paramObject.msgtype = -2005;
                                              paramFromServiceMsg = new ArrayList();
                                              paramFromServiceMsg.add(paramObject);
                                            }
                                            catch (Exception paramObject)
                                            {
                                              for (;;)
                                              {
                                                StringBuffer localStringBuffer;
                                                long l5;
                                                Iterator localIterator2;
                                                Object localObject4;
                                                boolean bool2;
                                                continue;
                                                paramFromServiceMsg = null;
                                                continue;
                                                continue;
                                                paramFromServiceMsg = paramObject;
                                                continue;
                                                i = 0;
                                              }
                                            }
                                            paramObject = paramObject;
                                            paramFromServiceMsg = null;
                                          }
                                          paramObject.printStackTrace();
                                          paramObject = paramFromServiceMsg;
                                        }
                                      }
                                      try
                                      {
                                        paramFromServiceMsg = a((msg_comm.Msg)localObject2, localawzu);
                                        if (paramFromServiceMsg == null) {}
                                      }
                                      catch (Exception paramObject)
                                      {
                                        try
                                        {
                                          if (paramFromServiceMsg.size() > 0)
                                          {
                                            paramObject = (MessageRecord)paramFromServiceMsg.get(0);
                                            if (paramObject.istroop == 1033) {
                                              break label1894;
                                            }
                                            i = paramObject.istroop;
                                            if (i == 1034) {
                                              break label1894;
                                            }
                                          }
                                        }
                                        catch (Exception paramObject)
                                        {
                                          break label2682;
                                        }
                                        paramObject = paramObject;
                                        paramFromServiceMsg = null;
                                      }
                                    }
                                    label2682:
                                    if (QLog.isColorLevel()) {
                                      QLog.w("Q.msg.C2CMessageProcessor", 2, "decodeSinglePBMsg_C2C error,", paramObject);
                                    }
                                  }
                                  localStringBuffer = new StringBuffer();
                                  localObject3 = (MessageRecord)paramFromServiceMsg.get(0);
                                  l5 = ((MessageRecord)localObject3).time;
                                  localIterator2 = paramFromServiceMsg.iterator();
                                  bool1 = false;
                                  do
                                  {
                                    if (!localIterator2.hasNext()) {
                                      break;
                                    }
                                    localObject4 = (MessageRecord)localIterator2.next();
                                  } while (localObject4 == null);
                                  if (QLog.isColorLevel()) {
                                    QLog.d("SUB_ACCOUNT", 2, "subaccount handleGetSubC2CMessageResp_PB mr=" + localObject4);
                                  }
                                  paramObject = ((MessageRecord)localObject4).msg;
                                  if (paramObject != null) {}
                                  try
                                  {
                                    if (QLog.isColorLevel()) {
                                      QLog.d("SUB_ACCOUNT", 2, "subaccount handleGetSubC2CMessageResp_PB  basemsg  = ");
                                    }
                                    if (((MessageRecord)localObject4).frienduin == null) {
                                      break label2740;
                                    }
                                    if (String.valueOf(ajsf.G).equalsIgnoreCase(((MessageRecord)localObject4).frienduin))
                                    {
                                      paramFromServiceMsg = ayao.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramObject, ((MessageRecord)localObject4).msgtype, ((MessageRecord)localObject4).senderuin);
                                      if (paramFromServiceMsg == null)
                                      {
                                        i = 1;
                                        if ((localStringBuffer != null) && (localStringBuffer.length() != 0)) {
                                          break label4029;
                                        }
                                        if (!QLog.isColorLevel()) {
                                          continue;
                                        }
                                        QLog.d("SUB_ACCOUNT", 2, "subaccount <---handleGetSubC2CMessageResp_PB show == null || show.length() == 0; msg is not decode success.");
                                      }
                                    }
                                  }
                                  catch (Exception paramFromServiceMsg)
                                  {
                                    for (;;)
                                    {
                                      paramFromServiceMsg.printStackTrace();
                                      continue;
                                      localStringBuffer.append(paramFromServiceMsg);
                                      i = 1;
                                    }
                                    switch (((MessageRecord)localObject4).msgtype)
                                    {
                                    }
                                  }
                                }
                              }
                              for (;;)
                              {
                                try
                                {
                                  if (!bbbg.a(((MessageRecord)localObject4).msgtype)) {
                                    continue;
                                  }
                                  localObject4 = bbbg.a(((MessageRecord)localObject4).msg);
                                  paramFromServiceMsg = paramObject;
                                  if (localObject4 != null)
                                  {
                                    if ((((MsgBody)localObject4).actMsgContentValue == null) || (((MsgBody)localObject4).actMsgContentValue.length() <= 0)) {
                                      continue;
                                    }
                                    paramFromServiceMsg = ((MsgBody)localObject4).actMsgContentValue;
                                  }
                                }
                                catch (Exception localException2)
                                {
                                  paramObject = null;
                                  localException2.printStackTrace();
                                  paramFromServiceMsg = paramObject;
                                  if (!QLog.isColorLevel()) {
                                    continue;
                                  }
                                  QLog.d("SUB_ACCOUNT", 2, "subaccount handlerMsgPB, MSG_TYPE_PUBLIC_ACCOUNT error e = " + localException2.getMessage());
                                  paramFromServiceMsg = paramObject;
                                  continue;
                                }
                                paramObject = paramFromServiceMsg;
                                if (paramFromServiceMsg == null) {
                                  paramObject = "";
                                }
                                localStringBuffer.append(paramObject);
                                break;
                                if (!(localObject4 instanceof MessageForStructing)) {
                                  break label5425;
                                }
                                paramFromServiceMsg = (MessageForStructing)localObject4;
                                if (paramFromServiceMsg.structingMsg == null) {
                                  break label5425;
                                }
                                paramFromServiceMsg = paramFromServiceMsg.structingMsg.mMsgBrief;
                                if (!TextUtils.isEmpty(paramFromServiceMsg)) {
                                  break label5422;
                                }
                                paramFromServiceMsg = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getResources().getString(2131719891);
                                continue;
                                if (ajwd.a((MessageRecord)localObject4))
                                {
                                  paramFromServiceMsg = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getResources().getString(2131691293);
                                }
                                else if ((localObject4 instanceof MessageForPic))
                                {
                                  paramFromServiceMsg = ((MessageForPic)localObject4).getSummaryMsg();
                                }
                                else
                                {
                                  paramFromServiceMsg = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getResources().getString(2131691297);
                                  continue;
                                  localObject4 = ((MessageRecord)localObject4).msg;
                                  paramFromServiceMsg = null;
                                  paramObject = paramFromServiceMsg;
                                  try
                                  {
                                    if (!TextUtils.isEmpty((CharSequence)localObject4))
                                    {
                                      localObject4 = ((String)localObject4).split("/");
                                      paramObject = paramFromServiceMsg;
                                      if (localObject4 != null)
                                      {
                                        paramObject = paramFromServiceMsg;
                                        if (localObject4.length > 0)
                                        {
                                          localObject4 = localObject4[(localObject4.length - 1)].split("\\|");
                                          paramObject = paramFromServiceMsg;
                                          if (localObject4 != null)
                                          {
                                            paramObject = paramFromServiceMsg;
                                            if (localObject4.length > 0) {
                                              paramObject = localObject4[0];
                                            }
                                          }
                                        }
                                      }
                                    }
                                  }
                                  catch (Exception paramObject)
                                  {
                                    paramObject.printStackTrace();
                                    paramObject = paramFromServiceMsg;
                                    continue;
                                    paramFromServiceMsg = paramObject;
                                    if (paramObject.equalsIgnoreCase(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getResources().getString(2131691292))) {
                                      continue;
                                    }
                                    paramFromServiceMsg = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getResources().getString(2131691292) + paramObject;
                                    continue;
                                  }
                                  if (TextUtils.isEmpty(paramObject))
                                  {
                                    paramFromServiceMsg = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getResources().getString(2131691292);
                                  }
                                  else
                                  {
                                    paramFromServiceMsg = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getResources().getString(2131691298);
                                    continue;
                                    if ((localObject4 instanceof MessageForMarketFace))
                                    {
                                      paramFromServiceMsg = ((MessageForMarketFace)localObject4).mMarkFaceMessage;
                                      if ((paramFromServiceMsg != null) && (!TextUtils.isEmpty(paramFromServiceMsg.faceName))) {
                                        paramFromServiceMsg = "[" + paramFromServiceMsg.faceName + "]";
                                      } else {
                                        paramFromServiceMsg = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getResources().getString(2131692043);
                                      }
                                    }
                                    else
                                    {
                                      paramFromServiceMsg = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getResources().getString(2131692043);
                                      continue;
                                      paramFromServiceMsg = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getResources().getString(2131719771);
                                      continue;
                                      paramFromServiceMsg = (MessageForApollo)localObject4;
                                      paramFromServiceMsg.parse();
                                      paramFromServiceMsg = ApolloUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramFromServiceMsg);
                                      continue;
                                      paramFromServiceMsg = paramObject;
                                      if (!(localObject4 instanceof MessageForPubAccount)) {
                                        continue;
                                      }
                                      if ("2010741172".equals(((MessageRecord)localObject3).senderuin)) {
                                        bool1 = true;
                                      }
                                      try
                                      {
                                        paramObject = ((MessageForPubAccount)localObject4).mPAMessage;
                                        if (paramObject == null)
                                        {
                                          paramFromServiceMsg = null;
                                          continue;
                                        }
                                        paramFromServiceMsg = ((PAMessage.Item)paramObject.items.get(0)).title;
                                        if ((((PAMessage.Item)paramObject.items.get(0)).cover == null) && (((PAMessage.Item)paramObject.items.get(0)).digestList != null))
                                        {
                                          paramFromServiceMsg = paramFromServiceMsg + "：" + (String)((PAMessage.Item)paramObject.items.get(0)).digestList.get(0);
                                          continue;
                                        }
                                        continue;
                                      }
                                      catch (Exception paramObject)
                                      {
                                        paramFromServiceMsg = null;
                                        paramObject.printStackTrace();
                                        if (QLog.isColorLevel()) {
                                          QLog.d("SUB_ACCOUNT", 2, "subaccount handlerMsgPB, MSG_TYPE_PUBLIC_ACCOUNT error e = " + paramObject.getMessage());
                                        }
                                      }
                                      paramFromServiceMsg = paramObject;
                                      if (!(localObject4 instanceof MessageForArkBabyqReply)) {
                                        continue;
                                      }
                                      paramFromServiceMsg = (MessageForArkBabyqReply)localObject4;
                                      paramFromServiceMsg.parse();
                                      paramFromServiceMsg = paramFromServiceMsg.babyqReplyText;
                                      continue;
                                      paramFromServiceMsg = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(bbbo.a(((MsgBody)localObject4).shareAppID));
                                      paramFromServiceMsg = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getString(2131690148) + paramFromServiceMsg.messagetail + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getString(2131690149);
                                      continue;
                                      paramFromServiceMsg = paramObject;
                                      if (!bbbg.b(((MessageRecord)localObject4).msgtype))
                                      {
                                        paramFromServiceMsg = paramObject;
                                        if (((MessageRecord)localObject4).msg != null)
                                        {
                                          paramFromServiceMsg = paramObject;
                                          if (((MessageRecord)localObject4).msg.indexOf("http://maps.google.com/maps?q=") != -1)
                                          {
                                            localObject4 = axas.a(((MessageRecord)localObject4).msg);
                                            paramObject = "";
                                            paramFromServiceMsg = paramObject;
                                            if (localObject4 != null)
                                            {
                                              paramFromServiceMsg = paramObject;
                                              if (localObject4[2] != null) {
                                                paramFromServiceMsg = localObject4[2];
                                              }
                                            }
                                            paramFromServiceMsg = "[" + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getString(2131720363) + "] " + paramFromServiceMsg;
                                          }
                                        }
                                      }
                                    }
                                  }
                                }
                              }
                              if ((localList1 != null) && (i == 0))
                              {
                                paramFromServiceMsg = localList1.iterator();
                                while (paramFromServiceMsg.hasNext())
                                {
                                  paramObject = (SubAccountMessage)paramFromServiceMsg.next();
                                  if (paramObject != null)
                                  {
                                    paramObject = paramObject.frienduin;
                                    if ((paramObject != null) && (paramObject.equalsIgnoreCase(String.valueOf(l6)))) {
                                      localArrayList.add(String.valueOf(l6));
                                    }
                                  }
                                }
                              }
                              paramFromServiceMsg = (msg_comm.MsgHead)((msg_comm.Msg)localObject2).msg_head.get();
                              if ((paramFromServiceMsg != null) && (paramFromServiceMsg.from_nick.has()))
                              {
                                paramFromServiceMsg = paramFromServiceMsg.from_nick.get();
                                if (i != 0) {
                                  paramFromServiceMsg = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getResources().getString(2131719974);
                                }
                                if (QLog.isColorLevel()) {
                                  QLog.d("SUB_ACCOUNT", 2, "sub.account.msg isQQMail=" + bool1);
                                }
                                localayaw.jdField_c_of_type_Boolean = true;
                                localObject2 = new SubAccountMessage();
                                if (i != 0)
                                {
                                  ((SubAccountMessage)localObject2).frienduin = String.valueOf(ajsf.G);
                                  label4222:
                                  if (!bool1) {
                                    break label4897;
                                  }
                                  bool2 = true;
                                  ((SubAccountMessage)localObject2).isread = bool2;
                                  ((SubAccountMessage)localObject2).msg = localStringBuffer.toString();
                                  ((SubAccountMessage)localObject2).extInt = ((MessageRecord)localObject3).extInt;
                                  ((SubAccountMessage)localObject2).extLong = ((MessageRecord)localObject3).extLong;
                                  ((SubAccountMessage)localObject2).extraflag = ((MessageRecord)localObject3).extraflag;
                                  ((SubAccountMessage)localObject2).extStr = ((MessageRecord)localObject3).extStr;
                                  ((SubAccountMessage)localObject2).istroop = ((MessageRecord)localObject3).istroop;
                                  ((SubAccountMessage)localObject2).isValid = ((MessageRecord)localObject3).isValid;
                                  ((SubAccountMessage)localObject2).longMsgCount = ((MessageRecord)localObject3).longMsgCount;
                                  ((SubAccountMessage)localObject2).longMsgId = ((MessageRecord)localObject3).longMsgId;
                                  ((SubAccountMessage)localObject2).longMsgIndex = ((MessageRecord)localObject3).longMsgIndex;
                                  ((SubAccountMessage)localObject2).msgUid = ((MessageRecord)localObject3).msgUid;
                                  ((SubAccountMessage)localObject2).shmsgseq = ((MessageRecord)localObject3).shmsgseq;
                                  ((SubAccountMessage)localObject2).uniseq = ((MessageRecord)localObject3).uniseq;
                                  ((SubAccountMessage)localObject2).msgseq = ((MessageRecord)localObject3).msgseq;
                                  if (!bool1) {
                                    break label4903;
                                  }
                                  i = 0;
                                  ((SubAccountMessage)localObject2).unreadNum = i;
                                  ((SubAccountMessage)localObject2).msgtype = -1000;
                                  ((SubAccountMessage)localObject2).selfuin = String.valueOf(l2);
                                  if (paramFromServiceMsg != null)
                                  {
                                    paramObject = paramFromServiceMsg;
                                    if (paramFromServiceMsg.length() != 0) {}
                                  }
                                  else
                                  {
                                    paramObject = ((SubAccountMessage)localObject2).frienduin;
                                  }
                                  ((SubAccountMessage)localObject2).sendername = paramObject;
                                  ((SubAccountMessage)localObject2).senderuin = String.valueOf(l6);
                                  ((SubAccountMessage)localObject2).subUin = Long.toString(l3);
                                  if (l5 != 0L) {
                                    break label4910;
                                  }
                                }
                                for (l4 = System.currentTimeMillis() / 1000L;; l4 = l5)
                                {
                                  ((SubAccountMessage)localObject2).time = l4;
                                  ((SubAccountMessage)localObject2).needNotify = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.isBackground_Pause;
                                  ((SubAccountMessage)localObject2).mTimeString = bbkb.a(1000L * l5, true, ayao.jdField_a_of_type_JavaLangString);
                                  ((SubAccountMessage)localObject2).mEmoRecentMsg = new ayki(((SubAccountMessage)localObject2).msg, 3, 16);
                                  if (MessageForQQWalletMsg.isRedPacketMsg((MessageRecord)localObject3)) {
                                    ((SubAccountMessage)localObject2).subExtr = "RED_PACKET";
                                  }
                                  if ((localObject3 instanceof MessageForFuDai)) {
                                    ((SubAccountMessage)localObject2).subExtr = "RED_PACKET";
                                  }
                                  if (localayav != null) {
                                    localayav.a((SubAccountMessage)localObject2);
                                  }
                                  if (QLog.isColorLevel())
                                  {
                                    QLog.d("SUB_ACCOUNT", 2, "subaccount set msg read false hasData = false  unreadNum=" + ((SubAccountMessage)localObject2).unreadNum);
                                    if (!TextUtils.isEmpty(((SubAccountMessage)localObject2).msg)) {
                                      QLog.d("SUB_ACCOUNT", 2, "msg=" + ((SubAccountMessage)localObject2).msg.charAt(0));
                                    }
                                  }
                                  ayao.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, str1, 6);
                                  localayaw.d = true;
                                  paramFromServiceMsg = axaq.a(((MessageRecord)localObject3).msgtype);
                                  MessageRecord.copyMessageRecordBaseField(paramFromServiceMsg, (MessageRecord)localObject3);
                                  paramFromServiceMsg.istroop = 7000;
                                  paramFromServiceMsg.frienduin = str1;
                                  i1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(paramFromServiceMsg.frienduin, paramFromServiceMsg.istroop);
                                  i = 0;
                                  if (localayav != null) {
                                    i = localayav.c(str1);
                                  }
                                  int i2 = i - i1;
                                  if (i2 != 0) {
                                    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().c(paramFromServiceMsg.frienduin, paramFromServiceMsg.istroop, i2);
                                  }
                                  if (QLog.isColorLevel()) {
                                    QLog.d("SUB_ACCOUNT", 2, "sub.account.msg conversion subUin=" + str1 + " target=" + i + " old=" + i1 + " increase=" + i2);
                                  }
                                  paramObject = new ArrayList();
                                  paramObject.add(paramFromServiceMsg);
                                  this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(paramObject, str2, false, false, true);
                                  if (bool1) {
                                    break label1894;
                                  }
                                  this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(paramObject.size(), true, true);
                                  break label1894;
                                  break;
                                  ((SubAccountMessage)localObject2).frienduin = String.valueOf(l6);
                                  break label4222;
                                  bool2 = false;
                                  break label4230;
                                  i = n;
                                  break label4385;
                                }
                              }
                            }
                            else
                            {
                              if ((localList1 != null) && (localList1.size() > 0) && (k != 0))
                              {
                                if (QLog.isColorLevel()) {
                                  QLog.d("SUB_ACCOUNT", 2, "handleGetSubC2CMessageResp_PB dbSubMsgList......");
                                }
                                i = 0;
                                if (i < localList1.size())
                                {
                                  paramFromServiceMsg = (SubAccountMessage)localList1.get(i);
                                  if ((paramFromServiceMsg == null) || (paramFromServiceMsg.frienduin == null)) {}
                                  for (;;)
                                  {
                                    i += 1;
                                    break;
                                    if (!paramFromServiceMsg.frienduin.equals(String.valueOf(ajsf.G)))
                                    {
                                      m = 0;
                                      paramObject = localArrayList.iterator();
                                      do
                                      {
                                        k = m;
                                        if (!paramObject.hasNext()) {
                                          break;
                                        }
                                        str2 = (String)paramObject.next();
                                      } while ((str2 == null) || (!paramFromServiceMsg.frienduin.equalsIgnoreCase(str2)));
                                      k = 1;
                                      if ((k != 0) && (localHashMap.containsKey(paramFromServiceMsg.frienduin))) {
                                        localayav.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, String.valueOf(l3), paramFromServiceMsg.frienduin, ((Integer)localHashMap.get(paramFromServiceMsg.frienduin)).intValue());
                                      }
                                      if ((k == 0) && (localayav != null))
                                      {
                                        k = localayav.a(String.valueOf(l3), paramFromServiceMsg.frienduin);
                                        if (k != 0)
                                        {
                                          this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().c(str1, 7000, k);
                                          this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(new String[] { ajsf.x, str1 });
                                        }
                                      }
                                    }
                                  }
                                }
                              }
                              if (QLog.isColorLevel())
                              {
                                if (localObject1 == null) {
                                  break label5350;
                                }
                                QLog.d("SUB_ACCOUNT", 2, "subaccount handleGetSubC2CMessageResp_PB  cookie = ");
                              }
                              for (;;)
                              {
                                if (localayav != null) {
                                  localayav.a(str1, (byte[])localObject1);
                                }
                                paramFromServiceMsg = new HashMap();
                                paramFromServiceMsg.put("param_FailCode", "12016");
                                paramFromServiceMsg.put("fail_step", "success");
                                paramFromServiceMsg.put("fail_location", "MessageHandler");
                                axrl.a(BaseApplication.getContext()).a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), "actSBGetMsg", true, 0L, 0L, paramFromServiceMsg, "");
                                if (b <= 0) {
                                  break label5377;
                                }
                                if (l3 <= 0L) {
                                  break;
                                }
                                paramToServiceMsg = paramToServiceMsg.extraData.getString("subaccount_a2");
                                if (paramToServiceMsg == null) {
                                  break label5377;
                                }
                                a(b, j, String.valueOf(l3), paramToServiceMsg, localArrayList);
                                localayaw.jdField_a_of_type_Boolean = false;
                                a(8003, true, localayaw);
                                return;
                                label5350:
                                QLog.d("SUB_ACCOUNT", 2, "subaccount handleGetSubC2CMessageResp_PB  cookie = null");
                              }
                              if (QLog.isColorLevel()) {
                                QLog.e("Q.msg.C2CMessageProcessor", 2, "subaccount handleGetSubC2CMessageResp_PB error happen, binduin <= 0 from server");
                              }
                              localayaw.jdField_a_of_type_Int = 0;
                              a(8003, true, localayaw);
                              if (!QLog.isColorLevel()) {
                                break;
                              }
                              QLog.d("SUB_ACCOUNT", 2, "subaccount <PbGetMsg><R><---handleGetSubC2CMessageResp_PB end");
                              return;
                            }
                          }
                        }
                      }
                      k = 1;
                      b = 0;
                    }
                  }
                }
              }
            }
          }
        }
      }
    }
  }
  
  private void d(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if ((paramToServiceMsg == null) || (paramFromServiceMsg == null) || (paramFromServiceMsg.getResultCode() != 1000) || (paramObject == null)) {}
    Object localObject;
    label222:
    String str;
    int i;
    int j;
    do
    {
      do
      {
        for (;;)
        {
          return;
          if (QLog.isColorLevel()) {
            QLog.d("Q.msg.C2CMessageProcessor", 2, "handleGetSubAccountSpecialCare() req = " + paramToServiceMsg);
          }
          if (QLog.isColorLevel()) {
            QLog.d("Q.msg.C2CMessageProcessor", 2, "handleGetSubAccountSpecialCare() resultCode = " + paramFromServiceMsg.getResultCode() + " isSuccess = " + paramFromServiceMsg.isSuccess() + " resp = " + paramFromServiceMsg);
          }
          localObject = new oidb_sso.OIDBSSOPkg();
          try
          {
            localObject = (oidb_sso.OIDBSSOPkg)((oidb_sso.OIDBSSOPkg)localObject).mergeFrom((byte[])paramObject);
            if ((localObject != null) && (((oidb_sso.OIDBSSOPkg)localObject).uint32_result.has()) && (((oidb_sso.OIDBSSOPkg)localObject).bytes_bodybuffer.has()) && (((oidb_sso.OIDBSSOPkg)localObject).bytes_bodybuffer.get() != null) && (((oidb_sso.OIDBSSOPkg)localObject).uint32_service_type.get() == 1)) {
              break label222;
            }
            if (QLog.isColorLevel())
            {
              QLog.d("Q.msg.C2CMessageProcessor", 2, "handleGetSubAccountSpecialCare ssoPkg check error");
              return;
            }
          }
          catch (InvalidProtocolBufferMicroException paramToServiceMsg) {}
        }
      } while (!QLog.isColorLevel());
      QLog.d("Q.msg.C2CMessageProcessor", 2, "handleGetSubAccountSpecialCare ssoPkg.mergeFrom exception");
      return;
      paramObject = new Oidb_0x5d0.RspBody();
      try
      {
        paramObject.mergeFrom(((oidb_sso.OIDBSSOPkg)localObject).bytes_bodybuffer.get().toByteArray());
        if (QLog.isColorLevel()) {
          QLog.d("Q.msg.C2CMessageProcessor", 2, "handleGetSubAccountSpecialCare  contentItem.size=" + paramObject.rpt_msg_contentItem.size());
        }
        localObject = String.valueOf(paramObject.uint64_uin.get());
        paramToServiceMsg = String.valueOf(paramToServiceMsg.getAttribute("subaccount"));
        str = paramFromServiceMsg.getUin();
        i = paramObject.uint32_sys_time.get();
        j = paramObject.uint32_advise_gap.get();
        if (QLog.isColorLevel()) {
          QLog.d("Q.msg.C2CMessageProcessor", 2, "handleGetSubAccountSpecialCare  contentItem.size=" + paramObject.rpt_msg_contentItem.get().size() + "  rspBody.uin=" + String.valueOf(paramObject.uint64_uin.get()) + "  resp.getUin()=" + paramFromServiceMsg.getUin() + "  sysTime=" + i + " adviseGap=" + j);
        }
        if ((!TextUtils.isEmpty((CharSequence)localObject)) && (!"0".equals(localObject)) && (TextUtils.equals((CharSequence)localObject, paramToServiceMsg)) && (TextUtils.equals(str, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c()))) {
          break;
        }
        QLog.d("Q.msg.C2CMessageProcessor", 2, "handleGetSubAccountSpecialCare req or resp params error");
        return;
      }
      catch (Exception paramToServiceMsg)
      {
        paramToServiceMsg.printStackTrace();
      }
    } while (!QLog.isColorLevel());
    QLog.d("Q.msg.C2CMessageProcessor", 2, "handleGetSubAccountSpecialCare  rspBody==null");
    return;
    new akqv(this, paramObject, str, (String)localObject, i, j).execute(new Void[0]);
  }
  
  public void a(byte paramByte, int paramInt, String paramString1, String paramString2, ArrayList<String> paramArrayList)
  {
    if (QLog.isColorLevel()) {
      QLog.d("SUB_ACCOUNT", 2, "getSubAccoundMsg_PB() start, subUin=" + paramString1);
    }
    ToServiceMsg localToServiceMsg = this.jdField_a_of_type_ComTencentMobileqqAppMessageHandler.createToServiceMsg("MessageSvc.PbBindUinGetMsg");
    localToServiceMsg.extraData.putByte("cChannel", paramByte);
    localToServiceMsg.extraData.putInt("cSyncFlag", paramInt);
    localToServiceMsg.extraData.putBoolean("isSubAccount", true);
    localToServiceMsg.extraData.putString("subAccount", paramString1);
    localToServiceMsg.extraData.putString("subaccount_a2", paramString2);
    if ((paramArrayList != null) && (paramArrayList.size() > 0)) {
      localToServiceMsg.extraData.putStringArrayList("hadGetMsgListUin", paramArrayList);
    }
    paramArrayList = (ayav)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(61);
    if (paramArrayList != null) {}
    for (paramArrayList = paramArrayList.a(paramString1);; paramArrayList = null)
    {
      msg_svc.PbBindUinGetMsgReq localPbBindUinGetMsgReq = new msg_svc.PbBindUinGetMsgReq();
      if (paramString1 != null) {}
      try
      {
        localPbBindUinGetMsgReq.bind_uin.set(Long.parseLong(paramString1));
        if (paramString2 == null) {}
      }
      catch (Exception paramString1)
      {
        try
        {
          do
          {
            localPbBindUinGetMsgReq.bind_uin_sig.set(ByteStringMicro.copyFrom(bbmj.a(paramString2)));
            if (paramArrayList == null) {
              break;
            }
            if (QLog.isColorLevel()) {
              QLog.d("SUB_ACCOUNT", 2, "getSubAccoundMsg_PB() cookie=" + paramArrayList.length);
            }
            localPbBindUinGetMsgReq.sync_cookie.set(ByteStringMicro.copyFrom(paramArrayList));
            localPbBindUinGetMsgReq.sync_flag.set(paramInt);
            localToServiceMsg.putWupBuffer(localPbBindUinGetMsgReq.toByteArray());
            this.jdField_a_of_type_ComTencentMobileqqAppMessageHandler.sendPbReq(localToServiceMsg);
            return;
            paramString1 = paramString1;
            paramString1.printStackTrace();
          } while (!QLog.isColorLevel());
          QLog.e("SUB_ACCOUNT", 2, "getSubAccoundMsg_PB() subAccount is null or not a long");
        }
        catch (Exception paramString1)
        {
          for (;;)
          {
            paramString1.printStackTrace();
            continue;
            if (QLog.isColorLevel()) {
              QLog.d("SUB_ACCOUNT", 2, "getSubAccoundMsg_PB() cookie = null");
            }
          }
        }
      }
    }
  }
  
  public void a(int paramInt, ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg)
  {
    if (QLog.isColorLevel()) {
      QLog.d("SUB_ACCOUNT", 2, "SubAccountMessageProcessor processError");
    }
    switch (paramInt)
    {
    default: 
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("SUB_ACCOUNT", 2, "subaccount cmd =  CMD_MESSAGESERVICE_GETSUBACCOUNTMSG_PB handlerGetSubAccountError end");
    }
    paramFromServiceMsg = new ayaw();
    String str = paramToServiceMsg.extraData.getString("subAccount");
    paramFromServiceMsg.jdField_b_of_type_JavaLangString = paramToServiceMsg.getUin();
    paramFromServiceMsg.jdField_c_of_type_JavaLangString = str;
    paramFromServiceMsg.jdField_a_of_type_Int = 1001;
    a(8003, false, paramFromServiceMsg);
  }
  
  public void a(int paramInt, Object... paramVarArgs)
  {
    if (QLog.isColorLevel()) {
      QLog.d("SUB_ACCOUNT", 2, "SubAccountMessageProcessor processResponse");
    }
    switch (paramInt)
    {
    }
    do
    {
      return;
      if ((paramVarArgs != null) && (paramVarArgs.length == 3))
      {
        c((ToServiceMsg)paramVarArgs[0], (FromServiceMsg)paramVarArgs[1], paramVarArgs[2]);
        return;
      }
      a(getClass().getName(), paramInt);
      return;
      if ((paramVarArgs != null) && (paramVarArgs.length == 3))
      {
        b((ToServiceMsg)paramVarArgs[0], (FromServiceMsg)paramVarArgs[1], paramVarArgs[2]);
        return;
      }
      a(getClass().getName(), paramInt);
      return;
      if ((paramVarArgs != null) && (paramVarArgs.length == 3))
      {
        d((ToServiceMsg)paramVarArgs[0], (FromServiceMsg)paramVarArgs[1], paramVarArgs[2]);
        return;
      }
    } while (!QLog.isColorLevel());
    QLog.d("SUB_ACCOUNT", 2, "subaccount cmd=CMD_MESSAGESERVICE_SUBACCOUNT_SPECIAL_CARE GetSubAccountSpecialCare error");
  }
  
  public void a(RequestPushNotify paramRequestPushNotify)
  {
    Object localObject = paramRequestPushNotify.stMsgInfo;
    if (528 == ((MsgInfo)localObject).shMsgType)
    {
      localObject = awzo.a(((MsgInfo)localObject).vMsg);
      if ((localObject != null) && (((MsgType0x210)localObject).vProtobuf != null)) {
        break label35;
      }
    }
    label35:
    do
    {
      do
      {
        return;
      } while ((((MsgType0x210)localObject).uSubMsgType != 138L) && (((MsgType0x210)localObject).uSubMsgType != 139L));
      Submsgtype0x8a.ReqBody localReqBody = new Submsgtype0x8a.ReqBody();
      try
      {
        localReqBody.mergeFrom(((MsgType0x210)localObject).vProtobuf);
        axao.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localReqBody, paramRequestPushNotify.lBindedUin, true);
        return;
      }
      catch (Exception paramRequestPushNotify) {}
    } while (!QLog.isColorLevel());
    QLog.d("revokeMsg", 2, "recv 0x210_0x8a_8b sub account msg, prase reqBody error");
  }
  
  public void a(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.msg.C2CMessageProcessor", 2, "handleGetThirdQQUnreadMsgNumTimeOut");
    }
    paramToServiceMsg = new ayax();
    paramToServiceMsg.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount();
    paramToServiceMsg.jdField_a_of_type_Int = 1;
    this.jdField_a_of_type_ComTencentMobileqqAppMessageHandler.notifyUI(8024, false, paramToServiceMsg);
  }
  
  public void a(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if (paramObject == null)
    {
      b(paramToServiceMsg, paramFromServiceMsg);
      return;
    }
    Object localObject = new msg_svc.PbUnReadMsgSeqResp();
    try
    {
      paramObject = (msg_svc.PbUnReadMsgSeqResp)((msg_svc.PbUnReadMsgSeqResp)localObject).mergeFrom((byte[])paramObject);
      if ((!paramObject.thirdqq_unread_info.has()) || (paramObject.thirdqq_unread_info.get() == null))
      {
        if (QLog.isColorLevel()) {
          QLog.e("Q.msg.C2CMessageProcessor", 2, "handleGetThirdQQUnreadMsgNumResp_PB: server did not return thirdqq_unread_info");
        }
        b(paramToServiceMsg, paramFromServiceMsg);
        return;
      }
    }
    catch (Exception paramObject)
    {
      if (QLog.isColorLevel()) {
        QLog.e("Q.msg.C2CMessageProcessor", 2, "handleGetThirdQQUnreadMsgNumResp_PB: server did not return a valid response");
      }
      b(paramToServiceMsg, paramFromServiceMsg);
      return;
    }
    paramObject = (msg_svc.PbThirdQQUnReadMsgNumResp)paramObject.thirdqq_unread_info.get();
    if ((paramObject.result.get() != 0) || (paramObject.thirdqq_resp_info.get() == null))
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.msg.C2CMessageProcessor", 2, "handleGetThirdQQUnreadMsgNumResp_PB unreadNumSeqResp.result: " + paramObject.result.get() + " ,unreadNumSeqResp.errmsg: " + paramObject.errmsg.get() + " or thirdqq_resp_info is null");
      }
      b(paramToServiceMsg, paramFromServiceMsg);
      return;
    }
    paramFromServiceMsg = new ayax();
    int i = paramObject.result.get();
    localObject = paramObject.errmsg.get();
    int j = paramObject.interval.get();
    paramFromServiceMsg.c = j;
    paramFromServiceMsg.jdField_b_of_type_JavaLangString = ((String)localObject);
    paramFromServiceMsg.jdField_b_of_type_Int = i;
    paramToServiceMsg = paramToServiceMsg.extraData.getString("mainAccount");
    paramFromServiceMsg.jdField_a_of_type_JavaLangString = paramToServiceMsg;
    if (QLog.isColorLevel()) {
      QLog.d("Q.msg.C2CMessageProcessor", 2, "handleGetThirdQQUnreadMsgNumResp_PB: result  interval=" + j + " errmsg=" + (String)localObject + " result=" + i);
    }
    long l = awzw.a();
    i = 0;
    while (i < paramObject.thirdqq_resp_info.get().size())
    {
      localObject = (msg_svc.PbThirdQQUnReadMsgNumResp.ThirdQQRespInfo)paramObject.thirdqq_resp_info.get().get(i);
      String str = String.valueOf(((msg_svc.PbThirdQQUnReadMsgNumResp.ThirdQQRespInfo)localObject).third_uin.get());
      byte[] arrayOfByte = ((msg_svc.PbThirdQQUnReadMsgNumResp.ThirdQQRespInfo)localObject).third_uin_cookie.get().toByteArray();
      int k = ((msg_svc.PbThirdQQUnReadMsgNumResp.ThirdQQRespInfo)localObject).msg_num.get();
      int m = ((msg_svc.PbThirdQQUnReadMsgNumResp.ThirdQQRespInfo)localObject).msg_flag.get();
      int n = ((msg_svc.PbThirdQQUnReadMsgNumResp.ThirdQQRespInfo)localObject).redbag_time.get();
      int i1 = ((msg_svc.PbThirdQQUnReadMsgNumResp.ThirdQQRespInfo)localObject).status.get();
      int i2 = ((msg_svc.PbThirdQQUnReadMsgNumResp.ThirdQQRespInfo)localObject).last_msg_time.get();
      if ((paramFromServiceMsg.d < i2) && (i2 <= l)) {
        paramFromServiceMsg.d = i2;
      }
      if (QLog.isColorLevel()) {
        QLog.d("Q.msg.C2CMessageProcessor", 2, "handleGetThirdQQUnreadMsgNumResp_PB: thirdUin=" + str + " num=" + k + " flag=" + m + " redbagtime=" + n + " status=" + i1 + " lastmsgtime=" + i2 + "  cookie=" + arrayOfByte);
      }
      ayao.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramToServiceMsg, str, arrayOfByte, k, m, n, i1, i2);
      i += 1;
    }
    ayao.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramToServiceMsg, j);
    this.jdField_a_of_type_ComTencentMobileqqAppMessageHandler.notifyUI(8024, true, paramFromServiceMsg);
  }
  
  public void a(String paramString1, String paramString2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("SUB_ACCOUNT", 2, "confirmSubAccountMsgNumReaded() subAccount=" + paramString1);
    }
    long l;
    try
    {
      l = Long.parseLong(paramString1);
      if (l <= 10000L)
      {
        if (QLog.isColorLevel()) {
          QLog.d("SUB_ACCOUNT", 2, "confirmSubAccountMsgNumReaded() return, lSubUin=" + l);
        }
        return;
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        localException.printStackTrace();
        l = 0L;
      }
      localObject = (ayav)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(61);
      if (localObject == null) {}
    }
    for (Object localObject = ((ayav)localObject).a(paramString1);; localObject = null)
    {
      ToServiceMsg localToServiceMsg = this.jdField_a_of_type_ComTencentMobileqqAppMessageHandler.createToServiceMsg("PbMessageSvc.PbBindUinMsgReadedConfirm");
      localToServiceMsg.extraData.putBoolean("isSubAccount", true);
      localToServiceMsg.extraData.putString("subAccount", paramString1);
      localToServiceMsg.extraData.putString("nextAction", paramString2);
      paramString1 = new msg_svc.PbBindUinMsgReadedConfirmReq();
      paramString1.bind_uin.set(l);
      if (localObject != null)
      {
        if (QLog.isColorLevel()) {
          QLog.d("SUB_ACCOUNT", 2, "confirmSubAccountMsgNumReaded() getSubAccoundMsg_PB  syncCookie=" + Integer.toString(localObject.length));
        }
        paramString1.sync_cookie.set(ByteStringMicro.copyFrom((byte[])localObject));
      }
      for (;;)
      {
        localToServiceMsg.putWupBuffer(paramString1.toByteArray());
        this.jdField_a_of_type_ComTencentMobileqqAppMessageHandler.sendPbReq(localToServiceMsg);
        return;
        if (QLog.isColorLevel()) {
          QLog.d("SUB_ACCOUNT", 2, "confirmSubAccountMsgNumReaded() getSubAccoundMsg_PB  cookie = null");
        }
      }
    }
  }
  
  public void a(boolean paramBoolean, ArrayList<SimpleAccount> paramArrayList)
  {
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder().append("getThirdQQUnreadMsgNum_PB isCronJob = ").append(paramBoolean).append(" thirdAccount size = ");
      if (paramArrayList != null) {
        break label110;
      }
    }
    label110:
    for (int i = 0;; i = paramArrayList.size())
    {
      QLog.d("Q.msg.C2CMessageProcessor", 2, i);
      if ((paramArrayList != null) && (paramArrayList.size() != 0)) {
        break;
      }
      paramArrayList = new ayax();
      paramArrayList.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount();
      if (QLog.isColorLevel()) {
        QLog.e("Q.msg.C2CMessageProcessor", 2, "getThirdQQUnreadMsgNum_PB error no third account");
      }
      this.jdField_a_of_type_ComTencentMobileqqAppMessageHandler.notifyUI(8024, false, paramArrayList);
      return;
    }
    TicketManager localTicketManager = (TicketManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(2);
    WtloginManager localWtloginManager = (WtloginManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(1);
    Object localObject1 = new msg_svc.PbUnReadMsgSeqReq();
    msg_svc.PbThirdQQUnReadMsgNumReq localPbThirdQQUnReadMsgNumReq = new msg_svc.PbThirdQQUnReadMsgNumReq();
    long l1 = awzw.a();
    if ((localTicketManager != null) && (localWtloginManager != null))
    {
      paramArrayList = paramArrayList.iterator();
      while (paramArrayList.hasNext())
      {
        Object localObject2 = (SimpleAccount)paramArrayList.next();
        if (localObject2 != null)
        {
          try
          {
            msg_svc.PbThirdQQUnReadMsgNumReq.ThirdQQReqInfo localThirdQQReqInfo = new msg_svc.PbThirdQQUnReadMsgNumReq.ThirdQQReqInfo();
            localObject2 = ((SimpleAccount)localObject2).getUin();
            Object localObject3 = localTicketManager.getA2((String)localObject2);
            if ((TextUtils.isEmpty((CharSequence)localObject2)) || (TextUtils.isEmpty((CharSequence)localObject3)) || (TextUtils.isEmpty(((String)localObject3).trim()))) {
              continue;
            }
            Ticket localTicket = localWtloginManager.GetLocalTicket((String)localObject2, 16L, 64);
            if ((localTicket == null) || (l1 > localTicket._expire_time)) {
              continue;
            }
            long l2 = Long.parseLong((String)localObject2);
            localThirdQQReqInfo.third_uin.set(l2);
            localThirdQQReqInfo.third_uin_sig.set(ByteStringMicro.copyFrom(bbmj.a((String)localObject3)));
            localObject3 = ayao.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (String)localObject2);
            if (localObject3 != null) {
              localThirdQQReqInfo.third_uin_cookie.set(ByteStringMicro.copyFrom((byte[])localObject3));
            }
            if (QLog.isColorLevel()) {
              QLog.d("Q.msg.C2CMessageProcessor", 2, "getThirdQQUnreadMsgNum_PB third uin = " + (String)localObject2);
            }
            localPbThirdQQUnReadMsgNumReq.thirdqq_req_info.add(localThirdQQReqInfo);
          }
          catch (NumberFormatException localNumberFormatException) {}
          if (QLog.isColorLevel()) {
            QLog.e("Q.msg.C2CMessageProcessor", 2, "getThirdQQUnreadMsgNum_PB error " + localNumberFormatException.getMessage());
          }
        }
      }
    }
    if ((!localPbThirdQQUnReadMsgNumReq.thirdqq_req_info.has()) || (localPbThirdQQUnReadMsgNumReq.thirdqq_req_info.get() == null) || (localPbThirdQQUnReadMsgNumReq.thirdqq_req_info.get().size() == 0))
    {
      paramArrayList = new ayax();
      paramArrayList.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount();
      if (QLog.isColorLevel()) {
        QLog.e("Q.msg.C2CMessageProcessor", 2, "getThirdQQUnreadMsgNum_PB error no third qq info");
      }
      this.jdField_a_of_type_ComTencentMobileqqAppMessageHandler.notifyUI(8024, false, paramArrayList);
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("Q.msg.C2CMessageProcessor", 2, "getThirdQQUnreadMsgNum_PB really send msg to service");
    }
    paramArrayList = localPbThirdQQUnReadMsgNumReq.source;
    if (paramBoolean) {}
    for (i = 1;; i = 2)
    {
      paramArrayList.set(i);
      ((msg_svc.PbUnReadMsgSeqReq)localObject1).thirdqq_unread_info.set(localPbThirdQQUnReadMsgNumReq);
      paramArrayList = new ToServiceMsg("mobileqq.service", this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c(), "PbMessageSvc.PbUnReadMsgSeq");
      paramArrayList.extraData.putString("action", "getThirdQQUnreadNum");
      paramArrayList.extraData.putString("mainAccount", this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount());
      paramArrayList.putWupBuffer(((msg_svc.PbUnReadMsgSeqReq)localObject1).toByteArray());
      this.jdField_a_of_type_ComTencentMobileqqAppMessageHandler.sendPbReq(paramArrayList);
      return;
    }
  }
  
  public boolean a(SubAccountInfo paramSubAccountInfo)
  {
    boolean bool = true;
    if (QLog.isColorLevel()) {
      QLog.d("Q.msg.C2CMessageProcessor", 2, "getSubAccountSpecialCareList()");
    }
    if ((paramSubAccountInfo == null) || (TextUtils.isEmpty(paramSubAccountInfo.subuin))) {
      bool = false;
    }
    for (;;)
    {
      return bool;
      Object localObject1 = new Oidb_0x5d0.ReqBody();
      Object localObject2 = new ArrayList();
      ((List)localObject2).add(Integer.valueOf(9));
      ((Oidb_0x5d0.ReqBody)localObject1).rpt_uint32_fieldlist.set((List)localObject2);
      ((Oidb_0x5d0.ReqBody)localObject1).uint32_start_time.set(ayao.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c(), paramSubAccountInfo.subuin));
      try
      {
        long l = Long.parseLong(paramSubAccountInfo.subuin);
        ((Oidb_0x5d0.ReqBody)localObject1).uint64_bind_uin.set(l);
        localObject2 = new oidb_sso.OIDBSSOPkg();
        ((oidb_sso.OIDBSSOPkg)localObject2).uint32_command.set(1488);
        ((oidb_sso.OIDBSSOPkg)localObject2).uint32_result.set(0);
        ((oidb_sso.OIDBSSOPkg)localObject2).uint32_service_type.set(1);
        ((oidb_sso.OIDBSSOPkg)localObject2).bytes_bodybuffer.set(ByteStringMicro.copyFrom(((Oidb_0x5d0.ReqBody)localObject1).toByteArray()));
        if (QLog.isColorLevel()) {
          QLog.d("Q.msg.C2CMessageProcessor", 2, "getSubAccountSpecialCareList() uin = " + paramSubAccountInfo.subuin);
        }
        localObject1 = this.jdField_a_of_type_ComTencentMobileqqAppMessageHandler.createToServiceMsg("OidbSvc.0x5d0_1");
        ((ToServiceMsg)localObject1).putWupBuffer(((oidb_sso.OIDBSSOPkg)localObject2).toByteArray());
        ((ToServiceMsg)localObject1).setTimeout(60000L);
        ((ToServiceMsg)localObject1).addAttribute("from_where", "subaccount");
        ((ToServiceMsg)localObject1).addAttribute("subaccount", paramSubAccountInfo.subuin);
        if (QLog.isColorLevel()) {
          QLog.d("Q.msg.C2CMessageProcessor", 2, "getSubAccountSpecialCareList() before send request = " + localObject1);
        }
        this.jdField_a_of_type_ComTencentMobileqqAppMessageHandler.sendPbReq((ToServiceMsg)localObject1);
        if (QLog.isColorLevel())
        {
          QLog.d("Q.msg.C2CMessageProcessor", 2, "getSubAccountSpecialCareList() after send request = " + localObject1);
          return true;
        }
      }
      catch (NumberFormatException paramSubAccountInfo)
      {
        paramSubAccountInfo.printStackTrace();
        if (QLog.isColorLevel()) {
          QLog.d("SUB_ACCOUNT", 2, "getSubAccountSpecialCareList subAccount parselong error ");
        }
      }
    }
    return false;
  }
  
  public void b(int paramInt, ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg)
  {
    if (QLog.isColorLevel()) {
      QLog.d("SUB_ACCOUNT", 2, "SubAccountMessageProcessor processTimeOut");
    }
    switch (paramInt)
    {
    default: 
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("SUB_ACCOUNT", 2, "subaccount cmd =  CMD_MESSAGESERVICE_GETSUBACCOUNTMSG_PB handlerGetSubAccountTimeout end");
    }
    paramFromServiceMsg = new ayaw();
    String str = paramToServiceMsg.extraData.getString("subAccount");
    paramFromServiceMsg.jdField_b_of_type_JavaLangString = paramToServiceMsg.getUin();
    paramFromServiceMsg.jdField_c_of_type_JavaLangString = str;
    paramFromServiceMsg.jdField_a_of_type_Int = 1007;
    a(8003, false, paramFromServiceMsg);
  }
  
  public void b(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.msg.C2CMessageProcessor", 2, "handleGetThirdQQUnreadMsgNumError");
    }
    paramToServiceMsg = new ayax();
    paramToServiceMsg.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount();
    this.jdField_a_of_type_ComTencentMobileqqAppMessageHandler.notifyUI(8024, false, paramToServiceMsg);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     akqt
 * JD-Core Version:    0.7.0.1
 */