import QTimedMessage.QTimedMessage.C2CMessage;
import QTimedMessage.QTimedMessage.C2CMessage.RichText;
import QTimedMessage.QTimedMessage.Client;
import QTimedMessage.QTimedMessage.Content;
import QTimedMessage.QTimedMessage.Message;
import QTimedMessage.QTimedMessage.Timer;
import QTimedMessage.QTimedMessage.User;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.util.QLog;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import mqq.app.AppRuntime;
import mqq.app.MSFServlet;
import mqq.app.NewIntent;
import mqq.app.Packet;
import org.json.JSONException;
import org.json.JSONObject;
import tencent.im.oidb.cmd0x75f.cmd0x75f.AddBatchReq;
import tencent.im.oidb.cmd0x75f.cmd0x75f.AddBatchRsp;
import tencent.im.oidb.cmd0x75f.cmd0x75f.ReqBody;
import tencent.im.oidb.cmd0x75f.cmd0x75f.RspBody;
import tencent.im.oidb.cmd0x7c9.cmd0x7c9.ReqBody;
import tencent.im.oidb.cmd0x7c9.cmd0x7c9.ReqHelloType;
import tencent.im.oidb.cmd0x7c9.cmd0x7c9.RspBody;
import tencent.im.oidb.cmd0x7c9.cmd0x7c9.RspHelloContent;
import tencent.im.oidb.cmd0x82a.cmd0x82a.MsgInfo;
import tencent.im.oidb.cmd0x82a.cmd0x82a.ReqBody;
import tencent.im.oidb.oidb_sso.OIDBSSOPkg;

public class akju
  extends MSFServlet
{
  private void a(Intent paramIntent, FromServiceMsg paramFromServiceMsg)
  {
    long[] arrayOfLong = paramIntent.getExtras().getLongArray("p_uin_list");
    ArrayList localArrayList = new ArrayList();
    akjv localakjv = (akjv)getAppRuntime().getManager(85);
    Bundle localBundle = new Bundle();
    StringBuilder localStringBuilder;
    if (QLog.isColorLevel())
    {
      localStringBuilder = new StringBuilder(1024);
      localStringBuilder.append("rspSendMessage response.getResultCode()=").append(paramFromServiceMsg.getResultCode()).append("send count = ").append(arrayOfLong.length);
      if (!paramFromServiceMsg.isSuccess()) {}
    }
    for (;;)
    {
      Object localObject1;
      Object localObject3;
      try
      {
        localObject1 = new oidb_sso.OIDBSSOPkg();
      }
      catch (InvalidProtocolBufferMicroException localInvalidProtocolBufferMicroException1)
      {
        Object localObject2;
        localObject1 = null;
      }
      try
      {
        localObject2 = ByteBuffer.wrap(paramFromServiceMsg.getWupBuffer());
        localObject3 = new byte[((ByteBuffer)localObject2).getInt() - 4];
        ((ByteBuffer)localObject2).get((byte[])localObject3);
        ((oidb_sso.OIDBSSOPkg)localObject1).mergeFrom((byte[])localObject3);
        localObject3 = localObject1;
        i = ((oidb_sso.OIDBSSOPkg)localObject3).uint32_result.get();
        if (localStringBuilder != null) {
          localStringBuilder.append(" respGetBirthday|oidb_sso.OIDBSSOPkg.result=").append(i);
        }
        if (((i != 0) && (i != 1401)) || (!((oidb_sso.OIDBSSOPkg)localObject3).bytes_bodybuffer.has()) || (((oidb_sso.OIDBSSOPkg)localObject3).bytes_bodybuffer.get() == null)) {
          break label494;
        }
        localObject2 = ((oidb_sso.OIDBSSOPkg)localObject3).bytes_bodybuffer.get().toByteArray();
      }
      catch (InvalidProtocolBufferMicroException localInvalidProtocolBufferMicroException2)
      {
        label415:
        break label415;
      }
      try
      {
        localObject1 = new cmd0x75f.RspBody();
        ((cmd0x75f.RspBody)localObject1).mergeFrom((byte[])localObject2);
        paramFromServiceMsg = ByteBuffer.wrap(paramFromServiceMsg.getWupBuffer());
        localObject2 = new byte[paramFromServiceMsg.getInt() - 4];
        paramFromServiceMsg.get((byte[])localObject2);
        ((cmd0x75f.RspBody)localObject1).mergeFrom((byte[])localObject2);
        paramFromServiceMsg = (cmd0x75f.AddBatchRsp)((cmd0x75f.RspBody)localObject1).msg_add_batch_rsp.get();
        if (localStringBuilder == null) {
          break label680;
        }
        localStringBuilder.append(" rpt_messages size=").append(paramFromServiceMsg.rpt_messages.get().size());
      }
      catch (InvalidProtocolBufferMicroException paramFromServiceMsg)
      {
        if (!QLog.isColorLevel()) {
          break label494;
        }
        QLog.d("ActivateFriends.Servlet", 2, "respSendTimingMsg erro ", paramFromServiceMsg);
      }
      int j = paramFromServiceMsg.rpt_messages.get().size();
      if (i < j)
      {
        try
        {
          long l = ((QTimedMessage.Message)paramFromServiceMsg.rpt_messages.get().get(i)).msg_content.msg_c2c_message.msg_to_user.uint64_uin.get();
          localArrayList.add(Long.valueOf(l));
          if (localStringBuilder != null)
          {
            localStringBuilder.append("{");
            localStringBuilder.append(l);
            localStringBuilder.append("}");
          }
        }
        catch (Exception localException)
        {
          if (!QLog.isColorLevel()) {
            continue;
          }
          QLog.d("ActivateFriends.Servlet", 2, "respSendMessage index=" + i);
          continue;
        }
        i += 1;
        continue;
        localObject3 = localObject1;
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.d("ActivateFriends.Servlet", 2, "rspSendMessage|oidb_sso parseFrom byte", localInvalidProtocolBufferMicroException1);
        localObject3 = localObject1;
        continue;
      }
      label494:
      if (localArrayList.size() == arrayOfLong.length) {
        i = 0;
      }
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.d("ActivateFriends.Servlet", 2, localStringBuilder.toString());
        }
        if (i == 2) {
          break label648;
        }
        paramFromServiceMsg = new long[localArrayList.size()];
        j = 0;
        while (j < localArrayList.size())
        {
          paramFromServiceMsg[j] = ((Long)localArrayList.get(j)).longValue();
          j += 1;
        }
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.d("ActivateFriends.Servlet", 2, "respSendMsg | response.result = " + paramFromServiceMsg.getResultCode());
        break;
        if (localArrayList.size() > 0) {
          i = 1;
        } else {
          i = 2;
        }
      }
      localakjv.a(paramFromServiceMsg, 2);
      label648:
      localBundle.putInt("key_rt_type", i);
      notifyObserver(paramIntent, 113, true, localBundle, akjy.class);
      return;
      localStringBuilder = null;
      break;
      label680:
      int i = 0;
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, ArrayList<String> paramArrayList)
  {
    NewIntent localNewIntent = new NewIntent(paramQQAppInterface.getApplication(), akju.class);
    localNewIntent.putExtra("param_req_type", 116);
    localNewIntent.putStringArrayListExtra("data", paramArrayList);
    paramQQAppInterface.startServlet(localNewIntent);
  }
  
  public static void a(QQAppInterface paramQQAppInterface, boolean paramBoolean1, boolean paramBoolean2)
  {
    NewIntent localNewIntent = new NewIntent(paramQQAppInterface.getApplication(), akju.class);
    localNewIntent.putExtra("param_req_type", 114);
    localNewIntent.putExtra("param_req_birthday", paramBoolean1);
    localNewIntent.putExtra("param_req_memorial", paramBoolean2);
    paramQQAppInterface.startServlet(localNewIntent);
  }
  
  public static void a(QQAppInterface paramQQAppInterface, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ActivateFriends.Servlet", 2, "sendGetBirthDayMsgForce");
    }
    NewIntent localNewIntent = new NewIntent(paramQQAppInterface.getApplication(), akju.class);
    localNewIntent.putExtra("param_req_type", 114);
    localNewIntent.putExtra("param_has_birthday_data", paramBoolean1);
    localNewIntent.putExtra("param_has_memorial_data", paramBoolean3);
    localNewIntent.putExtra("param_req_birthday", paramBoolean2);
    localNewIntent.putExtra("param_req_memorial", paramBoolean4);
    paramQQAppInterface.startServlet(localNewIntent);
  }
  
  public static boolean a(QQAppInterface paramQQAppInterface, String paramString, long[] paramArrayOfLong1, long[] paramArrayOfLong2, int paramInt)
  {
    if ((paramArrayOfLong1.length == 0) || (paramArrayOfLong1.length != paramArrayOfLong2.length)) {
      return false;
    }
    NewIntent localNewIntent = new NewIntent(paramQQAppInterface.getApplication(), akju.class);
    localNewIntent.putExtra("param_req_type", 113);
    localNewIntent.putExtra("p_msg", paramString);
    localNewIntent.putExtra("p_uin_list", paramArrayOfLong1);
    localNewIntent.putExtra("p_time_list", paramArrayOfLong2);
    localNewIntent.putExtra("p_gift_id", paramInt);
    paramQQAppInterface.startServlet(localNewIntent);
    return true;
  }
  
  private void b(Intent paramIntent, FromServiceMsg paramFromServiceMsg)
  {
    Object localObject = null;
    StringBuilder localStringBuilder;
    if (QLog.isColorLevel())
    {
      localStringBuilder = new StringBuilder(1024);
      localStringBuilder.append("response.getResultCode()=").append(paramFromServiceMsg.getResultCode());
    }
    for (;;)
    {
      if (paramFromServiceMsg.getResultCode() == 1000) {}
      for (;;)
      {
        try
        {
          paramIntent = new oidb_sso.OIDBSSOPkg();
          localObject = paramIntent;
        }
        catch (InvalidProtocolBufferMicroException paramFromServiceMsg)
        {
          try
          {
            paramFromServiceMsg = ByteBuffer.wrap(paramFromServiceMsg.getWupBuffer());
            localObject = new byte[paramFromServiceMsg.getInt() - 4];
            paramFromServiceMsg.get((byte[])localObject);
            paramIntent.mergeFrom((byte[])localObject);
            localObject = paramIntent;
            if (localObject != null)
            {
              i = ((oidb_sso.OIDBSSOPkg)localObject).uint32_result.get();
              if (localStringBuilder != null) {
                localStringBuilder.append(" respGetBirthday|oidb_sso.OIDBSSOPkg.result=").append(i);
              }
              if ((i == 0) && (((oidb_sso.OIDBSSOPkg)localObject).bytes_bodybuffer.has()) && (((oidb_sso.OIDBSSOPkg)localObject).bytes_bodybuffer.get() != null))
              {
                paramIntent = ((oidb_sso.OIDBSSOPkg)localObject).bytes_bodybuffer.get().toByteArray();
                try
                {
                  paramFromServiceMsg = new cmd0x7c9.RspBody();
                  paramFromServiceMsg.mergeFrom(paramIntent);
                  if (!paramFromServiceMsg.rpt_hello_content.has()) {
                    break label382;
                  }
                  paramIntent = (akjv)getAppRuntime().getManager(85);
                  paramFromServiceMsg = paramFromServiceMsg.rpt_hello_content.get().iterator();
                  if (paramFromServiceMsg.hasNext())
                  {
                    localObject = (cmd0x7c9.RspHelloContent)paramFromServiceMsg.next();
                    i = ((cmd0x7c9.RspHelloContent)localObject).uint32_next_time_gap.get();
                    j = ((cmd0x7c9.RspHelloContent)localObject).uint32_req_type.get();
                    if (localStringBuilder != null) {
                      localStringBuilder.append(" type=").append(j).append(" interval=").append(i);
                    }
                    if (j != 1) {
                      break label359;
                    }
                    paramIntent.a(i * 1000);
                    continue;
                  }
                  if (localStringBuilder == null) {
                    continue;
                  }
                }
                catch (Exception paramIntent)
                {
                  if (QLog.isColorLevel()) {
                    QLog.d("ActivateFriends.Servlet", 2, "respGetBirthday|oidb_sso parseFrom byte", paramIntent);
                  }
                }
              }
            }
            QLog.d("ActivateFriends.Servlet", 2, localStringBuilder.toString());
            return;
          }
          catch (InvalidProtocolBufferMicroException paramFromServiceMsg)
          {
            int i;
            int j;
            long l;
            break label334;
          }
          paramFromServiceMsg = paramFromServiceMsg;
          paramIntent = (Intent)localObject;
        }
        label334:
        if (QLog.isColorLevel())
        {
          QLog.d("ActivateFriends.Servlet", 2, "respGetBirthday|oidb_sso parseFrom byte", paramFromServiceMsg);
          localObject = paramIntent;
          continue;
          label359:
          if (j == 2)
          {
            l = i * 1000;
            paramIntent.b(l);
            continue;
            label382:
            if (localStringBuilder != null)
            {
              localStringBuilder.append(" rspBody.rpt_hello_content hasno ");
              continue;
              if (QLog.isColorLevel()) {
                QLog.d("ActivateFriends.Servlet", 2, "respGetBirthday | response.result = " + paramFromServiceMsg.getResultCode());
              }
            }
          }
        }
      }
      localStringBuilder = null;
    }
  }
  
  private void c(Intent paramIntent, FromServiceMsg paramFromServiceMsg)
  {
    StringBuilder localStringBuilder = new StringBuilder(1024);
    if (QLog.isColorLevel()) {
      localStringBuilder.append("activiate_friends|response.getResultCode()=").append(paramFromServiceMsg.getResultCode());
    }
    if (paramFromServiceMsg.getResultCode() == 1000) {}
    for (;;)
    {
      try
      {
        paramIntent = new oidb_sso.OIDBSSOPkg();
        int i;
        localObject = paramIntent;
      }
      catch (InvalidProtocolBufferMicroException paramFromServiceMsg)
      {
        try
        {
          paramFromServiceMsg = ByteBuffer.wrap(paramFromServiceMsg.getWupBuffer());
          localObject = new byte[paramFromServiceMsg.getInt() - 4];
          paramFromServiceMsg.get((byte[])localObject);
          paramIntent.mergeFrom((byte[])localObject);
          localObject = paramIntent;
          if (localObject != null)
          {
            i = ((oidb_sso.OIDBSSOPkg)localObject).uint32_result.get();
            if (localStringBuilder != null) {
              localStringBuilder.append(" respSendReadedActivateFriends|oidb_sso.OIDBSSOPkg.result=").append(i);
            }
          }
          if (localStringBuilder != null) {
            QLog.d("ActivateFriends.Servlet", 2, localStringBuilder.toString());
          }
          return;
        }
        catch (InvalidProtocolBufferMicroException paramFromServiceMsg)
        {
          Object localObject;
          break label139;
        }
        paramFromServiceMsg = paramFromServiceMsg;
        paramIntent = null;
      }
      label139:
      if (QLog.isColorLevel())
      {
        QLog.d("ActivateFriends.Servlet", 2, "respSendReadedActivateFriends|oidb_sso parseFrom byte", paramFromServiceMsg);
        localObject = paramIntent;
        continue;
        if (QLog.isColorLevel()) {
          QLog.d("ActivateFriends.Servlet", 2, "respSendReadedActivateFriends | response.result = " + paramFromServiceMsg.getResultCode());
        }
      }
    }
  }
  
  private void c(Intent paramIntent, Packet paramPacket)
  {
    Object localObject1 = paramIntent.getLongArrayExtra("p_uin_list");
    long[] arrayOfLong = paramIntent.getLongArrayExtra("p_time_list");
    String str = paramIntent.getStringExtra("p_msg");
    int j = paramIntent.getIntExtra("p_gift_id", -1);
    if (QLog.isColorLevel()) {
      QLog.d("ActivateFriends.Servlet", 2, "reqSendMessage | uin = " + Arrays.toString((long[])localObject1) + " | time = " + Arrays.toString(arrayOfLong));
    }
    paramIntent = new cmd0x75f.ReqBody();
    paramIntent.uint64_appid.set(1800000011L);
    paramIntent.uint32_subcmd.set(6);
    cmd0x75f.AddBatchReq localAddBatchReq = new cmd0x75f.AddBatchReq();
    ArrayList localArrayList = new ArrayList(localObject1.length);
    int i = 0;
    if (i < localObject1.length)
    {
      QTimedMessage.Message localMessage = new QTimedMessage.Message();
      localMessage.uint64_appid.set(1800000011L);
      Object localObject2 = new QTimedMessage.User();
      ((QTimedMessage.User)localObject2).enum_uin_type.set(3);
      ((QTimedMessage.User)localObject2).uint64_uin.set(getAppRuntime().getLongAccountUin());
      localMessage.msg_author.set((MessageMicro)localObject2);
      localMessage.uint32_main_type.set(100);
      localMessage.uint32_sub_type.set(1);
      localMessage.uint64_create_time.set(System.currentTimeMillis());
      localObject2 = new QTimedMessage.Timer();
      ((QTimedMessage.Timer)localObject2).uint64_time.set(arrayOfLong[i] * 1000L);
      localMessage.msg_timer.set((MessageMicro)localObject2);
      localObject2 = new QTimedMessage.Content();
      QTimedMessage.C2CMessage localC2CMessage = new QTimedMessage.C2CMessage();
      Object localObject3 = new QTimedMessage.User();
      ((QTimedMessage.User)localObject3).enum_uin_type.set(3);
      ((QTimedMessage.User)localObject3).uint64_uin.set(getAppRuntime().getLongAccountUin());
      localC2CMessage.msg_from_user.set((MessageMicro)localObject3);
      localObject3 = new QTimedMessage.User();
      ((QTimedMessage.User)localObject3).enum_uin_type.set(3);
      ((QTimedMessage.User)localObject3).uint64_uin.set(localObject1[i]);
      localC2CMessage.msg_to_user.set((MessageMicro)localObject3);
      localObject3 = new QTimedMessage.Client();
      ((QTimedMessage.Client)localObject3).uint32_Mobile.set(1);
      ((QTimedMessage.Client)localObject3).uint32_PC.set(1);
      localC2CMessage.msg_recv_client.set((MessageMicro)localObject3);
      if (j != -1)
      {
        localObject3 = new QTimedMessage.C2CMessage.RichText();
        ((QTimedMessage.C2CMessage.RichText)localObject3).uint32_service_id.set(51);
        ((QTimedMessage.C2CMessage.RichText)localObject3).uint32_gift_id.set(j);
        localC2CMessage.msg_rich_text.set((MessageMicro)localObject3);
        localC2CMessage.uint32_send_rich_text_standalone.set(1);
        localC2CMessage.bytes_text.set(ByteStringMicro.copyFrom(str.getBytes()));
        localC2CMessage.uint32_send_text_standalone.set(1);
      }
      for (;;)
      {
        ((QTimedMessage.Content)localObject2).msg_c2c_message.set(localC2CMessage);
        localMessage.msg_content.set((MessageMicro)localObject2);
        localArrayList.add(localMessage);
        i += 1;
        break;
        localC2CMessage.bytes_text.set(ByteStringMicro.copyFrom(str.getBytes()));
        localC2CMessage.uint32_send_text_standalone.set(1);
      }
    }
    localAddBatchReq.rpt_messages.set(localArrayList);
    paramIntent.msg_add_batch_req.set(localAddBatchReq);
    localObject1 = new oidb_sso.OIDBSSOPkg();
    ((oidb_sso.OIDBSSOPkg)localObject1).uint32_command.set(1887);
    ((oidb_sso.OIDBSSOPkg)localObject1).uint32_service_type.set(3);
    ((oidb_sso.OIDBSSOPkg)localObject1).uint32_result.set(0);
    ((oidb_sso.OIDBSSOPkg)localObject1).bytes_bodybuffer.set(ByteStringMicro.copyFrom(paramIntent.toByteArray()));
    paramIntent = ((oidb_sso.OIDBSSOPkg)localObject1).toByteArray();
    paramPacket.setSSOCommand("OidbSvc.0x75f");
    localObject1 = ByteBuffer.allocate(paramIntent.length + 4);
    ((ByteBuffer)localObject1).putInt(paramIntent.length + 4);
    ((ByteBuffer)localObject1).put(paramIntent);
    paramPacket.putSendData(((ByteBuffer)localObject1).array());
  }
  
  public void a(Intent paramIntent, Packet paramPacket)
  {
    int j = 1;
    boolean bool2 = paramIntent.getBooleanExtra("param_req_birthday", false);
    boolean bool1 = paramIntent.getBooleanExtra("param_req_memorial", false);
    if (QLog.isColorLevel()) {
      QLog.d("ActivateFriends.Servlet", 2, "req send get birthday message birthday=" + bool2 + " memorial=" + bool1);
    }
    Object localObject = new cmd0x7c9.ReqBody();
    ArrayList localArrayList = new ArrayList(2);
    cmd0x7c9.ReqHelloType localReqHelloType;
    if (bool2)
    {
      localReqHelloType = new cmd0x7c9.ReqHelloType();
      localReqHelloType.string_qua.set(bgyi.a());
      localReqHelloType.uint32_req_type.set(1);
      if (paramIntent.hasExtra("param_has_birthday_data"))
      {
        bool2 = paramIntent.getBooleanExtra("param_has_birthday_data", false);
        PBUInt32Field localPBUInt32Field = localReqHelloType.uint32_has_data;
        if (bool2)
        {
          i = 1;
          localPBUInt32Field.set(i);
        }
      }
      else
      {
        localArrayList.add(localReqHelloType);
      }
    }
    else if (bool1)
    {
      localReqHelloType = new cmd0x7c9.ReqHelloType();
      localReqHelloType.string_qua.set(bgyi.a());
      localReqHelloType.uint32_req_type.set(2);
      if (paramIntent.hasExtra("param_has_memorial_data"))
      {
        bool1 = paramIntent.getBooleanExtra("param_has_memorial_data", false);
        paramIntent = localReqHelloType.uint32_has_data;
        if (!bool1) {
          break label376;
        }
      }
    }
    label376:
    for (int i = j;; i = 0)
    {
      paramIntent.set(i);
      localArrayList.add(localReqHelloType);
      ((cmd0x7c9.ReqBody)localObject).rpt_hello_type.set(localArrayList);
      ((cmd0x7c9.ReqBody)localObject).string_qua.set(bgyi.a());
      paramIntent = new oidb_sso.OIDBSSOPkg();
      paramIntent.uint32_command.set(1993);
      paramIntent.uint32_service_type.set(2);
      paramIntent.uint32_result.set(0);
      paramIntent.bytes_bodybuffer.set(ByteStringMicro.copyFrom(((cmd0x7c9.ReqBody)localObject).toByteArray()));
      paramPacket.setSSOCommand("OidbSvc.0x7c9_2");
      paramIntent = paramIntent.toByteArray();
      localObject = ByteBuffer.allocate(paramIntent.length + 4);
      ((ByteBuffer)localObject).putInt(paramIntent.length + 4);
      ((ByteBuffer)localObject).put(paramIntent);
      paramPacket.putSendData(((ByteBuffer)localObject).array());
      return;
      i = 0;
      break;
    }
  }
  
  public void b(Intent paramIntent, Packet paramPacket)
  {
    Object localObject1 = paramIntent.getStringArrayListExtra("data");
    if (localObject1 == null) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.i("ActivateFriends.Servlet", 2, "activiate_friends|reqSendReadedActivateFriends size:" + ((List)localObject1).size());
    }
    paramIntent = new cmd0x82a.ReqBody();
    paramIntent.uint32_app_id.set(1001);
    paramIntent.uint32_inst_id.set(AppSetting.a());
    ArrayList localArrayList = new ArrayList(((List)localObject1).size());
    int i = 0;
    for (;;)
    {
      if (i < ((List)localObject1).size())
      {
        String str1 = (String)((List)localObject1).get(i);
        try
        {
          Object localObject2 = new JSONObject(str1);
          str1 = ((JSONObject)localObject2).optString("key_msg_ext_from_uin", "");
          String str2 = ((JSONObject)localObject2).optString("key_msg_ext_to_uin", "");
          String str3 = ((JSONObject)localObject2).optString("key_msg_ext_msg_seq", "");
          String str4 = ((JSONObject)localObject2).optString("key_msg_ext_msg_type", "");
          localObject2 = ((JSONObject)localObject2).optString("key_msg_ext_msg_sub_type", "");
          if ((TextUtils.isEmpty(str1)) || (TextUtils.isEmpty(str2)) || (TextUtils.isEmpty(str3)) || (TextUtils.isEmpty(str4)) || (TextUtils.isEmpty((CharSequence)localObject2))) {
            break label503;
          }
          cmd0x82a.MsgInfo localMsgInfo = new cmd0x82a.MsgInfo();
          localMsgInfo.uint64_from_uin.set(Long.valueOf(str1).longValue());
          localMsgInfo.uint64_to_uin.set(Long.valueOf(str2).longValue());
          localMsgInfo.uint32_msg_seq.set(Integer.valueOf(str3).intValue());
          localMsgInfo.uint32_type.set(Integer.valueOf(str4).intValue());
          localMsgInfo.uint32_subtype.set(Integer.valueOf((String)localObject2).intValue());
          localArrayList.add(localMsgInfo);
        }
        catch (JSONException localJSONException)
        {
          if (!QLog.isColorLevel()) {
            break label503;
          }
          QLog.i("ActivateFriends.Servlet", 2, localJSONException.getMessage(), localJSONException);
        }
        catch (Exception localException)
        {
          if (!QLog.isColorLevel()) {
            break label503;
          }
        }
        QLog.i("ActivateFriends.Servlet", 2, localException.getMessage(), localException);
      }
      else
      {
        paramIntent.msg_info.set(localArrayList);
        localObject1 = new oidb_sso.OIDBSSOPkg();
        ((oidb_sso.OIDBSSOPkg)localObject1).uint32_command.set(2090);
        ((oidb_sso.OIDBSSOPkg)localObject1).uint32_service_type.set(1);
        ((oidb_sso.OIDBSSOPkg)localObject1).uint32_result.set(0);
        ((oidb_sso.OIDBSSOPkg)localObject1).bytes_bodybuffer.set(ByteStringMicro.copyFrom(paramIntent.toByteArray()));
        paramPacket.setSSOCommand("OidbSvc.0x82a_1");
        paramIntent = ((oidb_sso.OIDBSSOPkg)localObject1).toByteArray();
        localObject1 = ByteBuffer.allocate(paramIntent.length + 4);
        ((ByteBuffer)localObject1).putInt(paramIntent.length + 4);
        ((ByteBuffer)localObject1).put(paramIntent);
        paramPacket.putSendData(((ByteBuffer)localObject1).array());
        return;
      }
      label503:
      i += 1;
    }
  }
  
  public void onReceive(Intent paramIntent, FromServiceMsg paramFromServiceMsg)
  {
    String str2 = paramFromServiceMsg.getServiceCmd();
    if (str2 == null) {}
    label98:
    do
    {
      return;
      StringBuilder localStringBuilder;
      if (QLog.isColorLevel())
      {
        boolean bool = paramFromServiceMsg.isSuccess();
        localStringBuilder = new StringBuilder().append("resp:").append(str2).append(" is ");
        if (!bool) {
          break label98;
        }
      }
      for (String str1 = "";; str1 = "not")
      {
        QLog.d("ActivateFriends.Servlet", 2, str1 + " success");
        if (!str2.equals("OidbSvc.0x7c9_2")) {
          break;
        }
        b(paramIntent, paramFromServiceMsg);
        return;
      }
      if (str2.equals("OidbSvc.0x75f"))
      {
        a(paramIntent, paramFromServiceMsg);
        return;
      }
    } while (!str2.equals("OidbSvc.0x82a_1"));
    c(paramIntent, paramFromServiceMsg);
  }
  
  public void onSend(Intent paramIntent, Packet paramPacket)
  {
    Bundle localBundle = paramIntent.getExtras();
    if (localBundle == null) {
      return;
    }
    switch (localBundle.getInt("param_req_type", 0))
    {
    case 115: 
    default: 
      return;
    case 113: 
      if (QLog.isColorLevel()) {
        QLog.d("ActivateFriends.Servlet", 2, "req send timing message");
      }
      c(paramIntent, paramPacket);
      return;
    case 114: 
      a(paramIntent, paramPacket);
      return;
    }
    b(paramIntent, paramPacket);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     akju
 * JD-Core Version:    0.7.0.1
 */