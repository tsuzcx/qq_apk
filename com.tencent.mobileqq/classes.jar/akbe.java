import android.os.Bundle;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import java.util.HashSet;
import java.util.Set;
import tencent.im.nearfield_discuss.nearfield_discuss.BusiRespHead;
import tencent.im.nearfield_discuss.nearfield_discuss.LBSInfo;
import tencent.im.nearfield_discuss.nearfield_discuss.NotifyList;
import tencent.im.nearfield_discuss.nearfield_discuss.ReqExit;
import tencent.im.nearfield_discuss.nearfield_discuss.ReqGetList;
import tencent.im.nearfield_discuss.nearfield_discuss.ReqJoinDiscuss;
import tencent.im.nearfield_discuss.nearfield_discuss.RespGetList;
import tencent.im.nearfield_discuss.nearfield_discuss.RespJoinDiscuss;

public class akbe
  extends ajtd
{
  byte[] a;
  
  public akbe(QQAppInterface paramQQAppInterface)
  {
    super(paramQQAppInterface);
  }
  
  private void a(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg)
  {
    String str = paramFromServiceMsg.getServiceCmd();
    QLog.i("NearFieldDiscussHandler", 1, "<<---handleError serviceCmd:" + str);
    if ("NearFieldDiscussSvr.ReqJoinDiscuss".equals(str)) {
      d(paramToServiceMsg, paramFromServiceMsg);
    }
    while (!"NearFieldDiscussSvr.ReqGetList".equals(str)) {
      return;
    }
  }
  
  private void b(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg)
  {
    String str = paramFromServiceMsg.getServiceCmd();
    QLog.i("NearFieldDiscussHandler", 1, "<<---handleTimeOut serviceCmd:" + str);
    if ("NearFieldDiscussSvr.ReqJoinDiscuss".equals(str)) {
      e(paramToServiceMsg, paramFromServiceMsg);
    }
    while (!"NearFieldDiscussSvr.ReqGetList".equals(str)) {
      return;
    }
    c(paramToServiceMsg, paramFromServiceMsg);
  }
  
  private void b(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    boolean bool1;
    int j;
    int i;
    int m;
    if ((paramFromServiceMsg != null) && (paramFromServiceMsg.isSuccess()) && (paramObject != null))
    {
      bool1 = true;
      if (QLog.isColorLevel()) {
        QLog.d("NearFieldDiscussHandler", 2, "handleGetFaceToFaceDiscussInfo");
      }
      j = paramToServiceMsg.extraData.getInt("session_id", -1);
      i = paramToServiceMsg.extraData.getInt("join_type", -1);
      m = paramToServiceMsg.extraData.getInt("from", 0);
      if (!bool1) {
        break label497;
      }
    }
    for (;;)
    {
      try
      {
        localRespJoinDiscuss = new nearfield_discuss.RespJoinDiscuss();
        localRespJoinDiscuss.mergeFrom((byte[])paramObject);
        k = ((nearfield_discuss.BusiRespHead)localRespJoinDiscuss.msg_head.get()).int32_reply_code.get();
        if (k == 0)
        {
          bool1 = true;
          QLog.i("NearFieldDiscussHandler", 1, "handleGetFaceToFaceDiscussInfo retCOde = " + k + " joinType = " + i + " sessionId = " + j);
          if (!bool1) {
            continue;
          }
          k = localRespJoinDiscuss.uint32_discuss_id.get();
          ((ajvi)this.app.a(6)).a(k);
          paramFromServiceMsg = String.valueOf(k);
        }
      }
      catch (Exception paramFromServiceMsg)
      {
        nearfield_discuss.RespJoinDiscuss localRespJoinDiscuss;
        paramToServiceMsg = "";
        boolean bool2 = false;
        k = i;
        m = j;
        paramObject = paramToServiceMsg;
        bool1 = bool2;
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.d("NearFieldDiscussHandler", 2, "handleGetFaceToFaceDiscussInfo exp", paramFromServiceMsg);
        k = i;
        m = j;
        paramObject = paramToServiceMsg;
        bool1 = bool2;
        continue;
        paramObject = "";
        k = i;
        m = j;
        continue;
      }
      try
      {
        bool2 = localRespJoinDiscuss.bool_is_creater.get();
        k = localRespJoinDiscuss.uint32_session_id.get();
      }
      catch (Exception paramObject)
      {
        paramToServiceMsg = paramFromServiceMsg;
        paramFromServiceMsg = paramObject;
        continue;
      }
      try
      {
        j = localRespJoinDiscuss.uint32_join_type.get();
        if ((!bool2) || (j != 2)) {}
      }
      catch (Exception paramObject)
      {
        paramToServiceMsg = paramFromServiceMsg;
        j = k;
        paramFromServiceMsg = paramObject;
        continue;
      }
      try
      {
        paramToServiceMsg = paramToServiceMsg.extraData.getString("FACE_TO_FACE_ID");
        ((azoa)this.app.getManager(32)).a(paramFromServiceMsg, false, paramToServiceMsg);
        axqw.b(this.app, "dc00899", "Grp_create_new", "", "suc_create", "face_create", 0, 0, "" + paramFromServiceMsg, "" + m, "", "");
        paramObject = paramFromServiceMsg;
        m = k;
        k = j;
        notifyUI(1020, bool1, new Object[] { Integer.valueOf(m), paramObject, Integer.valueOf(k) });
        return;
      }
      catch (Exception paramObject)
      {
        paramToServiceMsg = paramFromServiceMsg;
        i = j;
        j = k;
        paramFromServiceMsg = paramObject;
        continue;
      }
      bool1 = false;
      break;
      bool1 = false;
      continue;
      label497:
      paramObject = "";
      int k = i;
      m = j;
    }
  }
  
  private void c(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg)
  {
    notifyUI(1021, false, null);
  }
  
  private void c(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if (QLog.isColorLevel()) {
      QLog.d("NearFieldDiscussHandler", 2, "handleNotifyPush");
    }
    boolean bool1;
    if ((paramFromServiceMsg != null) && (paramFromServiceMsg.isSuccess()) && (paramObject != null)) {
      bool1 = true;
    }
    for (;;)
    {
      j = -1;
      i = j;
      bool2 = bool1;
      if (bool1) {}
      for (;;)
      {
        try
        {
          paramToServiceMsg = new nearfield_discuss.NotifyList();
        }
        catch (Exception paramToServiceMsg)
        {
          if (!QLog.isColorLevel()) {
            continue;
          }
          QLog.d("NearFieldDiscussHandler", 2, "handleNotifyPush exp", paramToServiceMsg);
          bool2 = false;
          i = j;
          continue;
        }
        try
        {
          paramToServiceMsg.mergeFrom((byte[])paramObject);
          i = paramToServiceMsg.uint32_session_id.get();
          bool2 = bool1;
          notifyUI(1022, bool2, new Object[] { Integer.valueOf(i) });
          return;
          bool1 = false;
        }
        catch (InvalidProtocolBufferMicroException paramFromServiceMsg)
        {
          paramFromServiceMsg.printStackTrace();
          bool1 = false;
        }
      }
    }
  }
  
  private void d(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg)
  {
    notifyUI(1020, false, new Object[] { Integer.valueOf(paramToServiceMsg.extraData.getInt("session_id")) });
  }
  
  private void e(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg)
  {
    int i = paramToServiceMsg.extraData.getInt("retryTime", 0);
    if (i < 1)
    {
      paramToServiceMsg.extraData.putInt("retryTime", i + 1);
      send(paramToServiceMsg);
      return;
    }
    d(paramToServiceMsg, paramFromServiceMsg);
  }
  
  protected void a(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    boolean bool1;
    if ((paramFromServiceMsg.isSuccess()) && (paramObject != null)) {
      bool1 = true;
    }
    boolean bool2;
    for (;;)
    {
      QLog.i("NearFieldDiscussHandler", 1, "handleGetFaceToFaceMemberListResp isSuccess:" + bool1 + "  ResultCode:" + paramFromServiceMsg.getResultCode());
      bool2 = bool1;
      if (bool1)
      {
        paramToServiceMsg = new nearfield_discuss.RespGetList();
        try
        {
          paramToServiceMsg.mergeFrom((byte[])paramObject);
          if ((paramToServiceMsg != null) && (bool1))
          {
            paramFromServiceMsg = null;
            if (paramToServiceMsg.rpt_msg_user_list.has()) {
              paramFromServiceMsg = paramToServiceMsg.rpt_msg_user_list.get();
            }
            int i = 60000;
            if (paramToServiceMsg.int32_update_interval.has()) {
              i = paramToServiceMsg.int32_update_interval.get();
            }
            if (paramToServiceMsg.bytes_cookie.has()) {
              this.a = paramToServiceMsg.bytes_cookie.get().toByteArray();
            }
            int j = 0;
            if (paramToServiceMsg.uint32_session_id.has()) {
              j = paramToServiceMsg.uint32_session_id.get();
            }
            paramObject = new nearfield_discuss.BusiRespHead();
            if (paramToServiceMsg.msg_head.has())
            {
              paramObject.int32_reply_code.set(paramToServiceMsg.msg_head.int32_reply_code.get());
              paramObject.str_result.set(paramToServiceMsg.msg_head.str_result.get());
            }
            int k = 0;
            if (paramToServiceMsg.uint32_button_switch.has()) {
              k = paramToServiceMsg.uint32_button_switch.get();
            }
            int m = 0;
            if (paramToServiceMsg.uint32_has_created.has()) {
              m = paramToServiceMsg.uint32_has_created.get();
            }
            long l = 0L;
            if (paramToServiceMsg.uint64_creator.has()) {
              l = paramToServiceMsg.uint64_creator.get();
            }
            notifyUI(1021, bool1, new Object[] { paramFromServiceMsg, Integer.valueOf(i), Integer.valueOf(j), paramObject, Integer.valueOf(k), Integer.valueOf(m), Long.valueOf(l) });
            return;
            bool1 = false;
          }
        }
        catch (Exception paramToServiceMsg)
        {
          for (;;)
          {
            bool1 = false;
            paramToServiceMsg = null;
          }
          bool2 = bool1;
        }
      }
    }
    notifyUI(1021, bool2, null);
  }
  
  public void a(String paramString, int paramInt, nearfield_discuss.LBSInfo paramLBSInfo)
  {
    ToServiceMsg localToServiceMsg = createToServiceMsg("NearFieldDiscussSvr.ReqExit");
    nearfield_discuss.ReqExit localReqExit = new nearfield_discuss.ReqExit();
    if (paramLBSInfo != null) {
      localReqExit.msg_lbs_info.set(paramLBSInfo);
    }
    localReqExit.str_number.set(paramString);
    localReqExit.uint32_session_id.set(paramInt);
    localToServiceMsg.putWupBuffer(localReqExit.toByteArray());
    localToServiceMsg.setTimeout(30000L);
    sendPbReq(localToServiceMsg);
  }
  
  public void a(String paramString, int paramInt1, nearfield_discuss.LBSInfo paramLBSInfo, int paramInt2, int paramInt3)
  {
    QLog.i("NearFieldDiscussHandler", 1, "getNearFieldDiscussInfo hallId=" + paramString + " sessionId=" + paramInt1 + " joinType:" + paramInt2);
    nearfield_discuss.ReqJoinDiscuss localReqJoinDiscuss = new nearfield_discuss.ReqJoinDiscuss();
    localReqJoinDiscuss.str_number.set(paramString);
    if (paramLBSInfo != null) {
      localReqJoinDiscuss.msg_lbs_info.set(paramLBSInfo);
    }
    localReqJoinDiscuss.uint32_session_id.set(paramInt1);
    localReqJoinDiscuss.uint32_join_type.set(paramInt2);
    paramLBSInfo = createToServiceMsg("NearFieldDiscussSvr.ReqJoinDiscuss");
    paramLBSInfo.extraData.putString("FACE_TO_FACE_ID", paramString);
    paramLBSInfo.extraData.putInt("session_id", paramInt1);
    paramLBSInfo.extraData.putInt("join_type", paramInt2);
    paramLBSInfo.extraData.putInt("from", paramInt3);
    paramLBSInfo.putWupBuffer(localReqJoinDiscuss.toByteArray());
    paramLBSInfo.setTimeout(30000L);
    sendPbReq(paramLBSInfo);
  }
  
  public void a(String paramString, int paramInt, nearfield_discuss.LBSInfo paramLBSInfo, boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.i("NearFieldDiscussHandler", 2, "get list | sessionId = " + paramInt + " | digits = " + paramString);
    }
    ToServiceMsg localToServiceMsg = createToServiceMsg("NearFieldDiscussSvr.ReqGetList");
    nearfield_discuss.ReqGetList localReqGetList = new nearfield_discuss.ReqGetList();
    if (paramLBSInfo != null) {
      localReqGetList.msg_lbs_info.set(paramLBSInfo);
    }
    localReqGetList.str_number.set(paramString);
    localReqGetList.uint32_session_id.set(paramInt);
    if ((!paramBoolean) && (this.a != null)) {
      localReqGetList.bytes_cookie.set(ByteStringMicro.copyFrom(this.a));
    }
    localToServiceMsg.putWupBuffer(localReqGetList.toByteArray());
    localToServiceMsg.setTimeout(30000L);
    sendPbReq(localToServiceMsg);
  }
  
  protected boolean msgCmdFilter(String paramString)
  {
    if (this.allowCmdSet == null)
    {
      this.allowCmdSet = new HashSet();
      this.allowCmdSet.add("NearFieldDiscussSvr.ReqJoinDiscuss");
      this.allowCmdSet.add("NearFieldDiscussSvr.ReqGetList");
      this.allowCmdSet.add("NearFieldDiscussSvr.ReqExit");
      this.allowCmdSet.add("NearFieldDiscussSvr.NotifyList");
    }
    return !this.allowCmdSet.contains(paramString);
  }
  
  protected Class<? extends ajtg> observerClass()
  {
    return akbf.class;
  }
  
  public void onReceive(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    String str = paramFromServiceMsg.getServiceCmd();
    if (msgCmdFilter(str)) {
      if (QLog.isColorLevel()) {
        QLog.d("NearFieldDiscussHandler", 2, "cmdfilter error=" + str);
      }
    }
    do
    {
      return;
      if (paramFromServiceMsg.getResultCode() == 1002)
      {
        b(paramToServiceMsg, paramFromServiceMsg);
        return;
      }
      if (paramFromServiceMsg.getResultCode() != 1000)
      {
        a(paramToServiceMsg, paramFromServiceMsg);
        return;
      }
      if ("NearFieldDiscussSvr.ReqJoinDiscuss".equalsIgnoreCase(str))
      {
        b(paramToServiceMsg, paramFromServiceMsg, paramObject);
        return;
      }
      if ("NearFieldDiscussSvr.NotifyList".equalsIgnoreCase(str))
      {
        c(paramToServiceMsg, paramFromServiceMsg, paramObject);
        return;
      }
      if ("NearFieldDiscussSvr.ReqGetList".equalsIgnoreCase(str))
      {
        a(paramToServiceMsg, paramFromServiceMsg, paramObject);
        return;
      }
    } while (!"NearFieldDiscussSvr.ReqExit".equalsIgnoreCase(str));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     akbe
 * JD-Core Version:    0.7.0.1
 */