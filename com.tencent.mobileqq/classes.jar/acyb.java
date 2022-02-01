import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.apollo.utils.ApolloGameUtil;
import com.tencent.mobileqq.apollo.utils.ApolloUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.Apollo3DMessage;
import com.tencent.mobileqq.data.ApolloMessage;
import com.tencent.mobileqq.data.MessageForApollo;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.pb.apollomsgextend.ApolloMsgExtend.AuthReserve;
import com.tencent.pb.apollomsgextend.ApolloMsgExtend.ThreeDBaseInfo;
import com.tencent.qphone.base.util.QLog;
import java.util.List;
import java.util.List<Ltencent.im.msg.im_msg_body.Elem;>;
import msf.msgcomm.msg_comm.Msg;
import org.json.JSONObject;
import tencent.im.msg.im_msg_body.ApolloActMsg;
import tencent.im.msg.im_msg_body.Elem;

public class acyb
  extends aczg
{
  private void a(List<im_msg_body.Elem> paramList, List<MessageRecord> paramList1, StringBuilder paramStringBuilder, boolean paramBoolean)
  {
    QQAppInterface localQQAppInterface = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
    int i = 0;
    if (i < paramList.size()) {
      if (!((im_msg_body.Elem)paramList.get(i)).apollo_msg.has()) {}
    }
    float f2;
    long l1;
    int j;
    Object localObject1;
    Object localObject4;
    Object localObject3;
    int i1;
    Object localObject2;
    int n;
    int m;
    int k;
    long l3;
    float f1;
    label2349:
    label2809:
    for (im_msg_body.ApolloActMsg localApolloActMsg = (im_msg_body.ApolloActMsg)((im_msg_body.Elem)paramList.get(i)).apollo_msg.get();; localApolloActMsg = null)
    {
      if (localApolloActMsg == null) {}
      label2299:
      do
      {
        return;
        i += 1;
        break;
        if (QLog.isColorLevel()) {
          paramStringBuilder.append("elemType:Apollo...\n");
        }
        ApolloMessage localApolloMessage;
        int i5;
        long l5;
        int i3;
        int i4;
        int i7;
        Object localObject7;
        int i6;
        ApolloMsgExtend.ThreeDBaseInfo localThreeDBaseInfo;
        Object localObject6;
        Object localObject5;
        Apollo3DMessage localApollo3DMessage;
        ApolloMsgExtend.AuthReserve localAuthReserve;
        long l2;
        int i2;
        long l4;
        try
        {
          localApolloMessage = new ApolloMessage();
          localApolloMessage.id = localApolloActMsg.uint32_action_id.get();
          localApolloMessage.name = localApolloActMsg.bytes_action_name.get().toByteArray();
          if ((!paramBoolean) && (localApolloActMsg.bytes_action_text.has())) {
            localApolloMessage.text = localApolloActMsg.bytes_action_text.get().toByteArray();
          }
          i5 = -1;
          f2 = 0.0F;
          l5 = 0L;
          i3 = -1;
          i4 = 0;
          i7 = 0;
          i = 0;
          l1 = 0L;
          localObject7 = null;
          paramStringBuilder = null;
          i6 = 0;
          j = 0;
          localThreeDBaseInfo = null;
          localObject1 = null;
          localObject6 = null;
          localObject5 = null;
          localApollo3DMessage = new Apollo3DMessage();
          localAuthReserve = new ApolloMsgExtend.AuthReserve();
          localObject4 = localObject6;
          localObject3 = localThreeDBaseInfo;
          i1 = i6;
          localObject2 = localObject7;
          n = i7;
          l2 = l1;
          m = i4;
          k = i3;
          l3 = l5;
          f1 = f2;
          i2 = i5;
        }
        catch (Throwable paramList) {}
        try
        {
          localAuthReserve.mergeFrom(localApolloActMsg.bytes_pb_reserve.get().toByteArray());
          localObject4 = localObject6;
          localObject3 = localThreeDBaseInfo;
          i1 = i6;
          localObject2 = localObject7;
          n = i7;
          l2 = l1;
          m = i4;
          k = i3;
          l3 = l5;
          f1 = f2;
          i2 = i5;
          i5 = localAuthReserve.diy_voice_id.get();
          localObject4 = localObject6;
          localObject3 = localThreeDBaseInfo;
          i1 = i6;
          localObject2 = localObject7;
          n = i7;
          l2 = l1;
          m = i4;
          k = i3;
          l3 = l5;
          f1 = f2;
          i2 = i5;
          f2 = (float)localAuthReserve.diy_voice_begin_ts.get();
          localObject4 = localObject6;
          localObject3 = localThreeDBaseInfo;
          i1 = i6;
          localObject2 = localObject7;
          n = i7;
          l2 = l1;
          m = i4;
          k = i3;
          l3 = l5;
          f1 = f2;
          i2 = i5;
          f2 /= 1000.0F;
          localObject4 = localObject6;
          localObject3 = localThreeDBaseInfo;
          i1 = i6;
          localObject2 = localObject7;
          n = i7;
          l2 = l1;
          m = i4;
          k = i3;
          l3 = l5;
          f1 = f2;
          i2 = i5;
          i3 = localAuthReserve.sub_type.get();
          localObject4 = localObject6;
          localObject3 = localThreeDBaseInfo;
          i1 = i6;
          localObject2 = localObject7;
          n = i7;
          l2 = l1;
          m = i4;
          k = i3;
          l3 = l5;
          f1 = f2;
          i2 = i5;
          i4 = localAuthReserve.game_id.get();
          localObject4 = localObject6;
          localObject3 = localThreeDBaseInfo;
          i1 = i6;
          localObject2 = localObject7;
          n = i7;
          l2 = l1;
          m = i4;
          k = i3;
          l3 = l5;
          f1 = f2;
          i2 = i5;
          l4 = localAuthReserve.room_id.get();
          paramList = paramStringBuilder;
          localObject4 = localObject6;
          localObject3 = localThreeDBaseInfo;
          i1 = i6;
          localObject2 = localObject7;
          n = i7;
          l2 = l4;
          m = i4;
          k = i3;
          l3 = l5;
          f1 = f2;
          i2 = i5;
          if (localAuthReserve.game_name.has())
          {
            paramList = paramStringBuilder;
            localObject4 = localObject6;
            localObject3 = localThreeDBaseInfo;
            i1 = i6;
            localObject2 = localObject7;
            n = i7;
            l2 = l4;
            m = i4;
            k = i3;
            l3 = l5;
            f1 = f2;
            i2 = i5;
            if (localAuthReserve.game_name.get() != null)
            {
              localObject4 = localObject6;
              localObject3 = localThreeDBaseInfo;
              i1 = i6;
              localObject2 = localObject7;
              n = i7;
              l2 = l4;
              m = i4;
              k = i3;
              l3 = l5;
              f1 = f2;
              i2 = i5;
              paramList = new String(localAuthReserve.game_name.get().toByteArray());
            }
          }
          paramStringBuilder = localObject5;
          localObject4 = localObject6;
          localObject3 = localThreeDBaseInfo;
          i1 = i6;
          localObject2 = paramList;
          n = i7;
          l2 = l4;
          m = i4;
          k = i3;
          l3 = l5;
          f1 = f2;
          i2 = i5;
          if (localAuthReserve.game_share_ark_json.has())
          {
            paramStringBuilder = localObject5;
            localObject4 = localObject6;
            localObject3 = localThreeDBaseInfo;
            i1 = i6;
            localObject2 = paramList;
            n = i7;
            l2 = l4;
            m = i4;
            k = i3;
            l3 = l5;
            f1 = f2;
            i2 = i5;
            if (localAuthReserve.game_share_ark_json.get() != null)
            {
              localObject4 = localObject6;
              localObject3 = localThreeDBaseInfo;
              i1 = i6;
              localObject2 = paramList;
              n = i7;
              l2 = l4;
              m = i4;
              k = i3;
              l3 = l5;
              f1 = f2;
              i2 = i5;
              paramStringBuilder = new String(localAuthReserve.game_share_ark_json.get().toByteArray());
            }
          }
          l1 = l5;
          localObject4 = paramStringBuilder;
          localObject3 = localThreeDBaseInfo;
          i1 = i6;
          localObject2 = paramList;
          n = i7;
          l2 = l4;
          m = i4;
          k = i3;
          l3 = l5;
          f1 = f2;
          i2 = i5;
          if (localAuthReserve.sign_ts.has())
          {
            localObject4 = paramStringBuilder;
            localObject3 = localThreeDBaseInfo;
            i1 = i6;
            localObject2 = paramList;
            n = i7;
            l2 = l4;
            m = i4;
            k = i3;
            l3 = l5;
            f1 = f2;
            i2 = i5;
            l1 = localAuthReserve.sign_ts.get();
          }
          localObject4 = paramStringBuilder;
          localObject3 = localThreeDBaseInfo;
          i1 = i6;
          localObject2 = paramList;
          n = i7;
          l2 = l4;
          m = i4;
          k = i3;
          l3 = l1;
          f1 = f2;
          i2 = i5;
          if (localAuthReserve.action_ver.has())
          {
            localObject4 = paramStringBuilder;
            localObject3 = localThreeDBaseInfo;
            i1 = i6;
            localObject2 = paramList;
            n = i7;
            l2 = l4;
            m = i4;
            k = i3;
            l3 = l1;
            f1 = f2;
            i2 = i5;
            l5 = localAuthReserve.action_ver.get();
            if (l5 != 0L)
            {
              localObject4 = paramStringBuilder;
              localObject3 = localThreeDBaseInfo;
              i1 = i6;
              localObject2 = paramList;
              n = i7;
              l2 = l4;
              m = i4;
              k = i3;
              l3 = l1;
              f1 = f2;
              i2 = i5;
              if (l5 > ApolloUtil.a(1))
              {
                localObject4 = paramStringBuilder;
                localObject3 = localThreeDBaseInfo;
                i1 = i6;
                localObject2 = paramList;
                n = i7;
                l2 = l4;
                m = i4;
                k = i3;
                l3 = l1;
                f1 = f2;
                i2 = i5;
                aoph.a(localQQAppInterface, 1);
              }
            }
          }
          localObject4 = paramStringBuilder;
          localObject3 = localThreeDBaseInfo;
          i1 = i6;
          localObject2 = paramList;
          n = i7;
          l2 = l4;
          m = i4;
          k = i3;
          l3 = l1;
          f1 = f2;
          i2 = i5;
          if (localAuthReserve.game_mode.has())
          {
            localObject4 = paramStringBuilder;
            localObject3 = localThreeDBaseInfo;
            i1 = i6;
            localObject2 = paramList;
            n = i7;
            l2 = l4;
            m = i4;
            k = i3;
            l3 = l1;
            f1 = f2;
            i2 = i5;
            i = localAuthReserve.game_mode.get();
          }
          localObject4 = paramStringBuilder;
          localObject3 = localThreeDBaseInfo;
          i1 = i6;
          localObject2 = paramList;
          n = i;
          l2 = l4;
          m = i4;
          k = i3;
          l3 = l1;
          f1 = f2;
          i2 = i5;
          if (localAuthReserve.extend_json.has())
          {
            localObject4 = paramStringBuilder;
            localObject3 = localThreeDBaseInfo;
            i1 = i6;
            localObject2 = paramList;
            n = i;
            l2 = l4;
            m = i4;
            k = i3;
            l3 = l1;
            f1 = f2;
            i2 = i5;
            localObject1 = new String(localAuthReserve.extend_json.get().toByteArray());
          }
          localObject4 = paramStringBuilder;
          localObject3 = localObject1;
          i1 = i6;
          localObject2 = paramList;
          n = i;
          l2 = l4;
          m = i4;
          k = i3;
          l3 = l1;
          f1 = f2;
          i2 = i5;
          if (localAuthReserve.action_type.has())
          {
            localObject4 = paramStringBuilder;
            localObject3 = localObject1;
            i1 = i6;
            localObject2 = paramList;
            n = i;
            l2 = l4;
            m = i4;
            k = i3;
            l3 = l1;
            f1 = f2;
            i2 = i5;
            j = localAuthReserve.action_type.get();
          }
          localObject4 = paramStringBuilder;
          localObject3 = localObject1;
          i1 = j;
          localObject2 = paramList;
          n = i;
          l2 = l4;
          m = i4;
          k = i3;
          l3 = l1;
          f1 = f2;
          i2 = i5;
          if (localAuthReserve.act3d.has())
          {
            localObject4 = paramStringBuilder;
            localObject3 = localObject1;
            i1 = j;
            localObject2 = paramList;
            n = i;
            l2 = l4;
            m = i4;
            k = i3;
            l3 = l1;
            f1 = f2;
            i2 = i5;
            localThreeDBaseInfo = (ApolloMsgExtend.ThreeDBaseInfo)localAuthReserve.act3d.get();
            localObject4 = paramStringBuilder;
            localObject3 = localObject1;
            i1 = j;
            localObject2 = paramList;
            n = i;
            l2 = l4;
            m = i4;
            k = i3;
            l3 = l1;
            f1 = f2;
            i2 = i5;
            if (localThreeDBaseInfo.uint32_action_id.has())
            {
              localObject4 = paramStringBuilder;
              localObject3 = localObject1;
              i1 = j;
              localObject2 = paramList;
              n = i;
              l2 = l4;
              m = i4;
              k = i3;
              l3 = l1;
              f1 = f2;
              i2 = i5;
              localApollo3DMessage.actionID_3D = localThreeDBaseInfo.uint32_action_id.get();
            }
            localObject4 = paramStringBuilder;
            localObject3 = localObject1;
            i1 = j;
            localObject2 = paramList;
            n = i;
            l2 = l4;
            m = i4;
            k = i3;
            l3 = l1;
            f1 = f2;
            i2 = i5;
            if (localThreeDBaseInfo.action_type.has())
            {
              localObject4 = paramStringBuilder;
              localObject3 = localObject1;
              i1 = j;
              localObject2 = paramList;
              n = i;
              l2 = l4;
              m = i4;
              k = i3;
              l3 = l1;
              f1 = f2;
              i2 = i5;
              localApollo3DMessage.actionType_3D = localThreeDBaseInfo.action_type.get();
            }
            localObject4 = paramStringBuilder;
            localObject3 = localObject1;
            i1 = j;
            localObject2 = paramList;
            n = i;
            l2 = l4;
            m = i4;
            k = i3;
            l3 = l1;
            f1 = f2;
            i2 = i5;
            if (localThreeDBaseInfo.bytes_action_name.has())
            {
              localObject4 = paramStringBuilder;
              localObject3 = localObject1;
              i1 = j;
              localObject2 = paramList;
              n = i;
              l2 = l4;
              m = i4;
              k = i3;
              l3 = l1;
              f1 = f2;
              i2 = i5;
              localApollo3DMessage.actionName_3D = new String(localThreeDBaseInfo.bytes_action_name.get().toByteArray());
            }
            localObject4 = paramStringBuilder;
            localObject3 = localObject1;
            i1 = j;
            localObject2 = paramList;
            n = i;
            l2 = l4;
            m = i4;
            k = i3;
            l3 = l1;
            f1 = f2;
            i2 = i5;
            if (localThreeDBaseInfo.int32_sender_status.has())
            {
              localObject4 = paramStringBuilder;
              localObject3 = localObject1;
              i1 = j;
              localObject2 = paramList;
              n = i;
              l2 = l4;
              m = i4;
              k = i3;
              l3 = l1;
              f1 = f2;
              i2 = i5;
              localApollo3DMessage.senderStatus_3D = localThreeDBaseInfo.int32_sender_status.get();
            }
            localObject4 = paramStringBuilder;
            localObject3 = localObject1;
            i1 = j;
            localObject2 = paramList;
            n = i;
            l2 = l4;
            m = i4;
            k = i3;
            l3 = l1;
            f1 = f2;
            i2 = i5;
            if (localThreeDBaseInfo.int32_peer_status.has())
            {
              localObject4 = paramStringBuilder;
              localObject3 = localObject1;
              i1 = j;
              localObject2 = paramList;
              n = i;
              l2 = l4;
              m = i4;
              k = i3;
              l3 = l1;
              f1 = f2;
              i2 = i5;
              localApollo3DMessage.peerStatus_3D = localThreeDBaseInfo.int32_peer_status.get();
            }
          }
          localObject2 = paramStringBuilder;
          paramStringBuilder = (StringBuilder)localObject1;
          k = i4;
          m = i3;
          i2 = i5;
          l2 = l4;
          localObject1 = paramList;
          paramList = (List<im_msg_body.Elem>)localObject2;
        }
        catch (InvalidProtocolBufferMicroException paramList)
        {
          paramList.printStackTrace();
          paramList = (List<im_msg_body.Elem>)localObject4;
          paramStringBuilder = (StringBuilder)localObject3;
          j = i1;
          localObject1 = localObject2;
          i = n;
          n = k;
          l1 = l3;
          k = m;
          m = n;
          f2 = f1;
          break label2299;
          localObject2 = null;
          break label2349;
        }
        localObject3 = new JSONObject();
        if (!localApolloActMsg.input_text.has()) {
          break label2809;
        }
        localObject2 = new String(localApolloActMsg.input_text.get().toByteArray());
        ((JSONObject)localObject3).put("inputText", localObject2);
        if (i2 > 0)
        {
          ((JSONObject)localObject3).put("audioID", i2);
          ((JSONObject)localObject3).put("audioStartTime", f2);
        }
        if (ApolloGameUtil.a(m))
        {
          ((JSONObject)localObject3).put("gameId", k);
          ((JSONObject)localObject3).put("gameMode", i);
          ((JSONObject)localObject3).put("roomid", l2);
          ((JSONObject)localObject3).put("msgTyep", m);
          ((JSONObject)localObject3).put("gameName", localObject1);
          ((JSONObject)localObject3).put("gameExtendJson", paramList);
        }
        if (!TextUtils.isEmpty(paramStringBuilder)) {
          ((JSONObject)localObject3).put("extendJson", paramStringBuilder);
        }
        ((JSONObject)localObject3).put("actionType", j);
        localObject4 = localApollo3DMessage.getMessageJSONObject();
        if (localObject4 != null) {
          ((JSONObject)localObject3).put("mApollo3DMessage", localObject4);
        }
        localApolloMessage.extStr = ((JSONObject)localObject3).toString();
        localApolloMessage.flag = localApolloActMsg.uint32_flag.get();
        localApolloMessage.peer_uin = bgjw.a(localApolloActMsg.uint32_peer_uin.get());
        localApolloMessage.sender_ts = bgjw.a(localApolloActMsg.uint32_sender_ts.get());
        localApolloMessage.peer_ts = bgjw.a(localApolloActMsg.uint32_peer_ts.get());
        localApolloMessage.sender_status = localApolloActMsg.int32_sender_status.get();
        localApolloMessage.peer_status = localApolloActMsg.int32_peer_status.get();
        localObject3 = (MessageForApollo)bbzh.a(-2039);
        ((MessageForApollo)localObject3).msgtype = -2039;
        ((MessageForApollo)localObject3).mApolloMessage = localApolloMessage;
        ((MessageForApollo)localObject3).msgData = aopw.a(localApolloMessage);
        ((MessageForApollo)localObject3).inputText = ((String)localObject2);
        ((MessageForApollo)localObject3).audioId = i2;
        ((MessageForApollo)localObject3).audioStartTime = f2;
        ((MessageForApollo)localObject3).msgType = m;
        ((MessageForApollo)localObject3).gameId = k;
        ((MessageForApollo)localObject3).mGameMode = i;
        ((MessageForApollo)localObject3).roomId = l2;
        ((MessageForApollo)localObject3).signTs = l1;
        ((MessageForApollo)localObject3).gameName = ((String)localObject1);
        ((MessageForApollo)localObject3).actionType = j;
        ((MessageForApollo)localObject3).extendJson = paramStringBuilder;
        ((MessageForApollo)localObject3).gameExtendJson = paramList;
        ((MessageForApollo)localObject3).gameStatus = ApolloUtil.a(((MessageForApollo)localObject3).extendJson, "gameStatus");
        ((MessageForApollo)localObject3).mApollo3DMessage = localApollo3DMessage;
        paramList1.add(localObject3);
        return;
      } while (!QLog.isColorLevel());
      QLog.e("ApolloElemDecoder", 2, "decode apollo msg failed", paramList);
      return;
    }
  }
  
  public int a()
  {
    return 1000;
  }
  
  public boolean a(List<im_msg_body.Elem> paramList, msg_comm.Msg paramMsg, List<MessageRecord> paramList1, StringBuilder paramStringBuilder, boolean paramBoolean1, boolean paramBoolean2, bepr parambepr, bbzl parambbzl, bbyn parambbyn)
  {
    a(paramList, paramList1, paramStringBuilder, paramBoolean2);
    return true;
  }
  
  public boolean a(im_msg_body.Elem paramElem)
  {
    return paramElem.apollo_msg.has();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     acyb
 * JD-Core Version:    0.7.0.1
 */