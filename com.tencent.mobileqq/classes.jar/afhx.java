import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import tencent.im.nearfield_friend.nearfield_friend.GPS;
import tencent.im.nearfield_friend.nearfield_friend.ReqEnter;
import tencent.im.nearfield_friend.nearfield_friend.ReqExit;
import tencent.im.nearfield_friend.nearfield_friend.ReqHeartBeat;
import tencent.im.nearfield_friend.nearfield_friend.ResultInfo;
import tencent.im.nearfield_friend.nearfield_friend.RspEnter;
import tencent.im.nearfield_friend.nearfield_friend.RspExit;
import tencent.im.nearfield_friend.nearfield_friend.RspHeartBeat;
import tencent.im.s2c.msgtype0x210.submsgtype0x133.submsgtype0x133.FaceFriend;
import tencent.im.s2c.msgtype0x210.submsgtype0x133.submsgtype0x133.MsgBody;

public class afhx
  extends ajtd
{
  public afhx(QQAppInterface paramQQAppInterface)
  {
    super(paramQQAppInterface);
  }
  
  private void a(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, boolean paramBoolean, Object paramObject)
  {
    paramFromServiceMsg = null;
    String str;
    boolean bool;
    if (paramToServiceMsg != null)
    {
      paramFromServiceMsg = paramToServiceMsg.extraData.getString("face2face_add_contact_session_id");
      str = paramToServiceMsg.extraData.getString("face2face_add_contact_number");
      bool = paramToServiceMsg.extraData.getBoolean("face2face_add_contact_enter_after_verify", false);
      paramToServiceMsg = str;
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Face2FaceAddContactHandler", 2, "handleEnterFace2faceAddContact:" + paramBoolean + " sessionId:" + paramFromServiceMsg + " number:" + paramToServiceMsg);
      }
      int j;
      int i;
      if (paramBoolean)
      {
        paramToServiceMsg = new nearfield_friend.RspEnter();
        try
        {
          paramToServiceMsg.mergeFrom((byte[])paramObject);
          paramObject = paramToServiceMsg;
        }
        catch (Exception paramToServiceMsg)
        {
          for (;;)
          {
            paramBoolean = false;
            if (QLog.isColorLevel()) {
              QLog.e("Face2FaceAddContactHandler", 2, "handleEnterFace2faceAddContact:" + paramToServiceMsg.toString());
            }
            paramObject = null;
            continue;
            paramToServiceMsg = null;
            continue;
            paramToServiceMsg = "";
            continue;
            j = 0;
            continue;
            str = null;
            continue;
            k = 60;
            continue;
            m = 1200;
          }
        }
        if ((paramBoolean) && (paramObject != null)) {
          if (paramObject.result.has())
          {
            paramToServiceMsg = (nearfield_friend.ResultInfo)paramObject.result.get();
            j = 0;
            i = 0;
            if (paramToServiceMsg == null) {
              break label459;
            }
            if (paramToServiceMsg.errcode.has()) {
              i = paramToServiceMsg.errcode.get();
            }
            if (!paramToServiceMsg.errmsg.has()) {
              break label403;
            }
            paramToServiceMsg = paramToServiceMsg.errmsg.get().toStringUtf8();
          }
        }
      }
      for (;;)
      {
        int k;
        int m;
        if (paramObject.security_level.has())
        {
          j = paramObject.security_level.get();
          if (!paramObject.verify_url.has()) {
            break label415;
          }
          str = paramObject.verify_url.get().toStringUtf8();
          if (!paramObject.heartbeat_time.has()) {
            break label421;
          }
          k = paramObject.heartbeat_time.get();
          if (!paramObject.expire_time.has()) {
            break label428;
          }
          m = paramObject.expire_time.get();
          notifyUI(1, true, new Object[] { paramFromServiceMsg, Integer.valueOf(i), paramToServiceMsg, Integer.valueOf(j), str, Integer.valueOf(k), Integer.valueOf(m), Boolean.valueOf(bool) });
        }
        label403:
        label415:
        label421:
        label428:
        notifyUI(1, false, new Object[] { paramFromServiceMsg, Boolean.valueOf(bool) });
        return;
        label459:
        paramToServiceMsg = "";
        i = j;
      }
      paramToServiceMsg = null;
      bool = false;
    }
  }
  
  private void b(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, boolean paramBoolean, Object paramObject)
  {
    if (paramToServiceMsg != null) {}
    for (paramFromServiceMsg = paramToServiceMsg.extraData.getString("face2face_add_contact_session_id");; paramFromServiceMsg = null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Face2FaceAddContactHandler", 2, "handleExitFace2FaceAddContact:" + paramBoolean + " sessionId:" + paramFromServiceMsg);
      }
      if (paramBoolean) {
        paramToServiceMsg = new nearfield_friend.RspExit();
      }
      for (;;)
      {
        try
        {
          paramToServiceMsg.mergeFrom((byte[])paramObject);
          if ((paramBoolean) && (paramToServiceMsg != null)) {
            if (paramToServiceMsg.result.has())
            {
              paramToServiceMsg = (nearfield_friend.ResultInfo)paramToServiceMsg.result.get();
              if (paramToServiceMsg == null) {
                break label253;
              }
              if (!paramToServiceMsg.errcode.has()) {
                continue;
              }
              i = paramToServiceMsg.errcode.get();
              if (!paramToServiceMsg.errmsg.has()) {
                continue;
              }
              paramToServiceMsg = paramToServiceMsg.errmsg.get().toStringUtf8();
              notifyUI(2, true, new Object[] { paramFromServiceMsg, Integer.valueOf(i), paramToServiceMsg });
            }
          }
        }
        catch (Exception paramToServiceMsg)
        {
          if (QLog.isColorLevel()) {
            QLog.e("Face2FaceAddContactHandler", 2, "handleExitFace2FaceAddContact:" + paramToServiceMsg.toString());
          }
          paramToServiceMsg = null;
          paramBoolean = false;
          continue;
          paramToServiceMsg = null;
          continue;
          i = 0;
          continue;
          paramToServiceMsg = "";
          continue;
        }
        notifyUI(2, false, new Object[] { paramFromServiceMsg });
        return;
        label253:
        paramToServiceMsg = "";
        int i = 0;
      }
    }
  }
  
  private void c(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, boolean paramBoolean, Object paramObject)
  {
    Object localObject = null;
    if (paramToServiceMsg != null) {}
    for (paramFromServiceMsg = paramToServiceMsg.extraData.getString("face2face_add_contact_session_id");; paramFromServiceMsg = null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Face2FaceAddContactHandler", 2, "handleFace2FaceAddContactHeartBeat:" + paramBoolean + " sessionId:" + paramFromServiceMsg);
      }
      String str;
      int i;
      if (paramBoolean)
      {
        paramToServiceMsg = new nearfield_friend.RspHeartBeat();
        try
        {
          paramToServiceMsg.mergeFrom((byte[])paramObject);
          paramObject = paramToServiceMsg;
        }
        catch (Exception paramToServiceMsg)
        {
          for (;;)
          {
            if (QLog.isColorLevel()) {
              QLog.e("Face2FaceAddContactHandler", 2, "handleFace2FaceAddContactHeartBeat:" + paramToServiceMsg.toString());
            }
            paramObject = null;
            paramBoolean = false;
            continue;
            paramToServiceMsg = null;
            continue;
            i = 0;
            continue;
            paramToServiceMsg = "";
          }
          notifyUI(3, true, new Object[] { paramFromServiceMsg, Integer.valueOf(i), paramToServiceMsg, paramObject });
          return;
        }
        if ((paramBoolean) && (paramObject != null)) {
          if (paramObject.result.has())
          {
            paramToServiceMsg = (nearfield_friend.ResultInfo)paramObject.result.get();
            str = "";
            if (paramToServiceMsg == null) {
              break label358;
            }
            if (!paramToServiceMsg.errcode.has()) {
              break label299;
            }
            i = paramToServiceMsg.errcode.get();
            if (!paramToServiceMsg.errmsg.has()) {
              break label305;
            }
          }
        }
      }
      for (paramToServiceMsg = paramToServiceMsg.errmsg.get().toStringUtf8();; paramToServiceMsg = str)
      {
        if (paramObject.uin_list.has()) {
          localObject = paramObject.uin_list.get();
        }
        paramObject = new ArrayList();
        if ((localObject != null) && (((List)localObject).size() > 0))
        {
          localObject = ((List)localObject).iterator();
          while (((Iterator)localObject).hasNext()) {
            paramObject.add(String.valueOf((Long)((Iterator)localObject).next()));
          }
        }
        label299:
        label305:
        notifyUI(3, false, new Object[] { paramFromServiceMsg });
        return;
        label358:
        i = 0;
      }
    }
  }
  
  public void a(String paramString)
  {
    QLog.i("Face2FaceAddContactHandler", 1, "exitFace2FaceAddContact sessionId=" + paramString);
    nearfield_friend.ReqExit localReqExit = new nearfield_friend.ReqExit();
    localReqExit.session_id.set(paramString);
    ToServiceMsg localToServiceMsg = createToServiceMsg("NearFieldFriendSvr.ReqExit");
    localToServiceMsg.extraData.putString("face2face_add_contact_session_id", paramString);
    localToServiceMsg.putWupBuffer(localReqExit.toByteArray());
    localToServiceMsg.setTimeout(30000L);
    sendPbReq(localToServiceMsg);
  }
  
  public void a(String paramString1, String paramString2, nearfield_friend.GPS paramGPS, byte[] paramArrayOfByte)
  {
    QLog.i("Face2FaceAddContactHandler", 1, "enterFace2faceAddContact sessionId=" + paramString1 + " number:" + paramString2);
    nearfield_friend.ReqEnter localReqEnter = new nearfield_friend.ReqEnter();
    localReqEnter.session_id.set(paramString1);
    if (paramGPS != null) {
      localReqEnter.gps_info.set(paramGPS);
    }
    localReqEnter.number.set(paramString2);
    paramGPS = createToServiceMsg("NearFieldFriendSvr.ReqEnter");
    if ((paramArrayOfByte != null) && (paramArrayOfByte.length > 0))
    {
      localReqEnter.verify_sig.set(ByteStringMicro.copyFrom(paramArrayOfByte));
      paramGPS.extraData.putBoolean("face2face_add_contact_enter_after_verify", true);
    }
    paramGPS.extraData.putString("face2face_add_contact_number", paramString2);
    paramGPS.extraData.putString("face2face_add_contact_session_id", paramString1);
    paramGPS.putWupBuffer(localReqEnter.toByteArray());
    paramGPS.setTimeout(30000L);
    sendPbReq(paramGPS);
  }
  
  public void a(String paramString, List<String> paramList)
  {
    QLog.i("Face2FaceAddContactHandler", 1, "face2FaceAddContactHeartBeat sessionId=" + paramString);
    nearfield_friend.ReqHeartBeat localReqHeartBeat = new nearfield_friend.ReqHeartBeat();
    localReqHeartBeat.session_id.set(paramString);
    if ((paramList != null) && (paramList.size() > 0)) {
      try
      {
        paramList = paramList.iterator();
        while (paramList.hasNext())
        {
          long l = Long.parseLong((String)paramList.next());
          localReqHeartBeat.uin_list.add(Long.valueOf(l));
        }
        paramList = createToServiceMsg("NearFieldFriendSvr.ReqHeartBeat");
      }
      catch (Exception paramList)
      {
        QLog.e("Face2FaceAddContactHandler", 1, "face2FaceAddContactHeartBeat error:" + paramList.getMessage());
      }
    }
    paramList.extraData.putString("face2face_add_contact_session_id", paramString);
    paramList.putWupBuffer(localReqHeartBeat.toByteArray());
    paramList.setTimeout(30000L);
    sendPbReq(paramList);
  }
  
  public void a(byte[] paramArrayOfByte)
  {
    Object localObject1 = null;
    if (paramArrayOfByte != null) {}
    for (;;)
    {
      Object localObject2;
      try
      {
        localObject2 = new submsgtype0x133.MsgBody();
        ((submsgtype0x133.MsgBody)localObject2).mergeFrom(paramArrayOfByte);
        if (((submsgtype0x133.MsgBody)localObject2).uint64_uin.has())
        {
          paramArrayOfByte = String.valueOf(((submsgtype0x133.MsgBody)localObject2).uint64_uin.get());
          if (!((submsgtype0x133.MsgBody)localObject2).str_session_id.has()) {
            break label336;
          }
          str = ((submsgtype0x133.MsgBody)localObject2).str_session_id.get();
          if (((submsgtype0x133.MsgBody)localObject2).rpt_msg_friends.has()) {
            localObject1 = ((submsgtype0x133.MsgBody)localObject2).rpt_msg_friends.get();
          }
          QLog.i("Face2FaceAddContactHandler", 1, "decodePush0x210_0x133 uin:" + paramArrayOfByte + " sessionId:" + str);
          if ((!TextUtils.isEmpty(paramArrayOfByte)) && (!TextUtils.isEmpty(str)) && (TextUtils.equals(paramArrayOfByte, this.app.getCurrentAccountUin())))
          {
            localObject2 = new ArrayList();
            if ((localObject1 == null) || (((List)localObject1).size() <= 0)) {
              break label348;
            }
            Iterator localIterator = ((List)localObject1).iterator();
            if (!localIterator.hasNext()) {
              break label348;
            }
            submsgtype0x133.FaceFriend localFaceFriend = (submsgtype0x133.FaceFriend)localIterator.next();
            afif localafif = new afif();
            localafif.jdField_a_of_type_JavaLangString = String.valueOf(localFaceFriend.uint64_friend.get());
            if (!localFaceFriend.bytes_name.has()) {
              break label341;
            }
            localObject1 = localFaceFriend.bytes_name.get().toStringUtf8();
            localafif.b = ((String)localObject1);
            if (!localFaceFriend.uint32_type.has()) {
              break label382;
            }
            i = localFaceFriend.uint32_type.get();
            localafif.jdField_a_of_type_Int = i;
            ((List)localObject2).add(localafif);
            continue;
          }
          return;
        }
      }
      catch (Throwable paramArrayOfByte)
      {
        QLog.e("Face2FaceAddContactHandler", 1, "decodePush0x210_0x133 decode error, e=" + paramArrayOfByte.toString());
      }
      paramArrayOfByte = null;
      continue;
      label336:
      String str = null;
      continue;
      label341:
      localObject1 = "";
      continue;
      label348:
      notifyUI(4, true, new Object[] { paramArrayOfByte, str, localObject2 });
      return;
      QLog.e("Face2FaceAddContactHandler", 1, "decodePush0x210_0x133 pbData = null");
      return;
      label382:
      int i = 0;
    }
  }
  
  protected boolean msgCmdFilter(String paramString)
  {
    if (this.allowCmdSet == null)
    {
      this.allowCmdSet = new HashSet();
      this.allowCmdSet.add("NearFieldFriendSvr.ReqEnter");
      this.allowCmdSet.add("NearFieldFriendSvr.ReqExit");
      this.allowCmdSet.add("NearFieldFriendSvr.ReqHeartBeat");
    }
    return !this.allowCmdSet.contains(paramString);
  }
  
  protected Class<? extends ajtg> observerClass()
  {
    return afhy.class;
  }
  
  public void onReceive(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    String str = "";
    if (paramFromServiceMsg != null) {
      str = paramFromServiceMsg.getServiceCmd();
    }
    if (QLog.isColorLevel()) {
      QLog.d("Face2FaceAddContactHandler", 2, "onReceive:" + str);
    }
    if (msgCmdFilter(str)) {
      if (QLog.isColorLevel()) {
        QLog.d("Face2FaceAddContactHandler", 2, "msgCmdFilter error=" + str);
      }
    }
    boolean bool;
    do
    {
      return;
      if ((paramFromServiceMsg != null) && (paramFromServiceMsg.isSuccess()) && (paramObject != null)) {}
      for (bool = true; "NearFieldFriendSvr.ReqEnter".equalsIgnoreCase(str); bool = false)
      {
        a(paramToServiceMsg, paramFromServiceMsg, bool, paramObject);
        return;
      }
      if ("NearFieldFriendSvr.ReqExit".equalsIgnoreCase(str))
      {
        b(paramToServiceMsg, paramFromServiceMsg, bool, paramObject);
        return;
      }
    } while (!"NearFieldFriendSvr.ReqHeartBeat".equalsIgnoreCase(str));
    c(paramToServiceMsg, paramFromServiceMsg, bool, paramObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     afhx
 * JD-Core Version:    0.7.0.1
 */