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
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.pb.apollomsgextend.ApolloMsgExtend.AuthReserve;
import com.tencent.pb.apollomsgextend.ApolloMsgExtend.ThreeDBaseInfo;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.List;
import java.util.List<Ltencent.im.msg.im_msg_body.Elem;>;
import msf.msgcomm.msg_comm.Msg;
import org.json.JSONArray;
import org.json.JSONObject;
import tencent.im.msg.im_msg_body.ApolloActMsg;
import tencent.im.msg.im_msg_body.Elem;

public class actz
  extends acve
{
  private float a(float paramFloat, ApolloMsgExtend.AuthReserve paramAuthReserve)
  {
    if (paramAuthReserve.diy_voice_begin_ts.has()) {
      paramFloat = (float)paramAuthReserve.diy_voice_begin_ts.get() / 1000.0F;
    }
    return paramFloat;
  }
  
  private int a(int paramInt, ApolloMsgExtend.AuthReserve paramAuthReserve)
  {
    if (paramAuthReserve.diy_voice_id.has()) {
      paramInt = paramAuthReserve.diy_voice_id.get();
    }
    return paramInt;
  }
  
  private long a(long paramLong, ApolloMsgExtend.AuthReserve paramAuthReserve)
  {
    if (paramAuthReserve.room_id.has()) {
      paramLong = paramAuthReserve.room_id.get();
    }
    return paramLong;
  }
  
  private long a(long paramLong, ApolloMsgExtend.AuthReserve paramAuthReserve, QQAppInterface paramQQAppInterface)
  {
    paramLong = paramAuthReserve.action_ver.get();
    if ((paramLong != 0L) && (paramLong > ApolloUtil.a(1))) {
      aozm.a(paramQQAppInterface, 1);
    }
    return paramLong;
  }
  
  private Apollo3DMessage a(Apollo3DMessage paramApollo3DMessage, ApolloMsgExtend.AuthReserve paramAuthReserve)
  {
    if (paramAuthReserve.act3d.has())
    {
      paramAuthReserve = (ApolloMsgExtend.ThreeDBaseInfo)paramAuthReserve.act3d.get();
      if (paramAuthReserve.uint32_action_id.has()) {
        paramApollo3DMessage.actionID_3D = paramAuthReserve.uint32_action_id.get();
      }
      if (paramAuthReserve.action_type.has()) {
        paramApollo3DMessage.actionType_3D = paramAuthReserve.action_type.get();
      }
      if (paramAuthReserve.bytes_action_name.has()) {
        paramApollo3DMessage.actionName_3D = new String(paramAuthReserve.bytes_action_name.get().toByteArray());
      }
      if (paramAuthReserve.int32_sender_status.has()) {
        paramApollo3DMessage.senderStatus_3D = paramAuthReserve.int32_sender_status.get();
      }
      if (paramAuthReserve.int32_peer_status.has()) {
        paramApollo3DMessage.peerStatus_3D = paramAuthReserve.int32_peer_status.get();
      }
    }
    return paramApollo3DMessage;
  }
  
  private String a(String paramString, ApolloMsgExtend.AuthReserve paramAuthReserve)
  {
    String str = paramString;
    if (paramAuthReserve.game_name.has())
    {
      str = paramString;
      if (paramAuthReserve.game_name.get() != null) {
        str = new String(paramAuthReserve.game_name.get().toByteArray());
      }
    }
    return str;
  }
  
  private List<Long> a(List<Long> paramList, ApolloMsgExtend.AuthReserve paramAuthReserve)
  {
    if (paramAuthReserve.uin_list.has()) {
      paramList = paramAuthReserve.uin_list.get();
    }
    return paramList;
  }
  
  private void a(List<im_msg_body.Elem> paramList, List<MessageRecord> paramList1, StringBuilder paramStringBuilder, boolean paramBoolean)
  {
    Object localObject7 = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
    int i = 0;
    if (i < paramList.size()) {
      if (!((im_msg_body.Elem)paramList.get(i)).apollo_msg.has()) {}
    }
    for (Object localObject3 = (im_msg_body.ApolloActMsg)((im_msg_body.Elem)paramList.get(i)).apollo_msg.get();; localObject3 = null)
    {
      if (localObject3 == null)
      {
        return;
        i += 1;
        break;
      }
      if (QLog.isColorLevel()) {
        paramStringBuilder.append("elemType:Apollo...\n");
      }
      ApolloMessage localApolloMessage;
      int i5;
      float f2;
      long l6;
      int i6;
      int i3;
      int i8;
      long l4;
      String str2;
      int i7;
      Object localObject6;
      String str1;
      int i9;
      int i4;
      long l5;
      ApolloMsgExtend.AuthReserve localAuthReserve;
      long l1;
      int j;
      Object localObject1;
      int k;
      Object localObject2;
      long l2;
      int n;
      int m;
      int i1;
      float f1;
      long l3;
      int i2;
      label1479:
      try
      {
        localApolloMessage = new ApolloMessage();
        localApolloMessage.id = ((im_msg_body.ApolloActMsg)localObject3).uint32_action_id.get();
        localApolloMessage.name = ((im_msg_body.ApolloActMsg)localObject3).bytes_action_name.get().toByteArray();
        if ((!paramBoolean) && (((im_msg_body.ApolloActMsg)localObject3).bytes_action_text.has())) {
          localApolloMessage.text = ((im_msg_body.ApolloActMsg)localObject3).bytes_action_text.get().toByteArray();
        }
        i5 = -1;
        f2 = 0.0F;
        l6 = 0L;
        i6 = -1;
        i3 = 0;
        i8 = 0;
        l4 = 0L;
        str2 = null;
        i7 = 0;
        localObject6 = null;
        str1 = null;
        i9 = 0;
        i4 = 0;
        l5 = 0L;
        localObject5 = new Apollo3DMessage();
        localAuthReserve = new ApolloMsgExtend.AuthReserve();
        paramList = (List<im_msg_body.Elem>)localObject5;
        l1 = l5;
        i = i4;
        j = i9;
        paramStringBuilder = str1;
        localObject1 = localObject6;
        k = i7;
        localObject2 = str2;
        l2 = l4;
        n = i8;
        m = i3;
        i1 = i6;
        f1 = f2;
        l3 = l6;
        i2 = i5;
      }
      catch (Throwable paramList) {}
      try
      {
        localAuthReserve.mergeFrom(((im_msg_body.ApolloActMsg)localObject3).bytes_pb_reserve.get().toByteArray());
        paramList = (List<im_msg_body.Elem>)localObject5;
        l1 = l5;
        i = i4;
        j = i9;
        paramStringBuilder = str1;
        localObject1 = localObject6;
        k = i7;
        localObject2 = str2;
        l2 = l4;
        n = i8;
        m = i3;
        i1 = i6;
        f1 = f2;
        l3 = l6;
        i2 = i5;
        i5 = a(-1, localAuthReserve);
        paramList = (List<im_msg_body.Elem>)localObject5;
        l1 = l5;
        i = i4;
        j = i9;
        paramStringBuilder = str1;
        localObject1 = localObject6;
        k = i7;
        localObject2 = str2;
        l2 = l4;
        n = i8;
        m = i3;
        i1 = i6;
        f1 = f2;
        l3 = l6;
        i2 = i5;
        f2 = a(0.0F, localAuthReserve);
        paramList = (List<im_msg_body.Elem>)localObject5;
        l1 = l5;
        i = i4;
        j = i9;
        paramStringBuilder = str1;
        localObject1 = localObject6;
        k = i7;
        localObject2 = str2;
        l2 = l4;
        n = i8;
        m = i3;
        i1 = i6;
        f1 = f2;
        l3 = l6;
        i2 = i5;
        i6 = b(-1, localAuthReserve);
        paramList = (List<im_msg_body.Elem>)localObject5;
        l1 = l5;
        i = i4;
        j = i9;
        paramStringBuilder = str1;
        localObject1 = localObject6;
        k = i7;
        localObject2 = str2;
        l2 = l4;
        n = i8;
        m = i3;
        i1 = i6;
        f1 = f2;
        l3 = l6;
        i2 = i5;
        i3 = c(0, localAuthReserve);
        paramList = (List<im_msg_body.Elem>)localObject5;
        l1 = l5;
        i = i4;
        j = i9;
        paramStringBuilder = str1;
        localObject1 = localObject6;
        k = i7;
        localObject2 = str2;
        l2 = l4;
        n = i8;
        m = i3;
        i1 = i6;
        f1 = f2;
        l3 = l6;
        i2 = i5;
        l4 = a(0L, localAuthReserve);
        paramList = (List<im_msg_body.Elem>)localObject5;
        l1 = l5;
        i = i4;
        j = i9;
        paramStringBuilder = str1;
        localObject1 = localObject6;
        k = i7;
        localObject2 = str2;
        l2 = l4;
        n = i8;
        m = i3;
        i1 = i6;
        f1 = f2;
        l3 = l6;
        i2 = i5;
        str2 = a(null, localAuthReserve);
        paramList = (List<im_msg_body.Elem>)localObject5;
        l1 = l5;
        i = i4;
        j = i9;
        paramStringBuilder = str1;
        localObject1 = localObject6;
        k = i7;
        localObject2 = str2;
        l2 = l4;
        n = i8;
        m = i3;
        i1 = i6;
        f1 = f2;
        l3 = l6;
        i2 = i5;
        str1 = b(null, localAuthReserve);
        paramList = (List<im_msg_body.Elem>)localObject5;
        l1 = l5;
        i = i4;
        j = i9;
        paramStringBuilder = str1;
        localObject1 = localObject6;
        k = i7;
        localObject2 = str2;
        l2 = l4;
        n = i8;
        m = i3;
        i1 = i6;
        f1 = f2;
        l3 = l6;
        i2 = i5;
        l6 = b(0L, localAuthReserve);
        paramList = (List<im_msg_body.Elem>)localObject5;
        l1 = l5;
        i = i4;
        j = i9;
        paramStringBuilder = str1;
        localObject1 = localObject6;
        k = i7;
        localObject2 = str2;
        l2 = l4;
        n = i8;
        m = i3;
        i1 = i6;
        f1 = f2;
        l3 = l6;
        i2 = i5;
        a(0L, localAuthReserve, (QQAppInterface)localObject7);
        paramList = (List<im_msg_body.Elem>)localObject5;
        l1 = l5;
        i = i4;
        j = i9;
        paramStringBuilder = str1;
        localObject1 = localObject6;
        k = i7;
        localObject2 = str2;
        l2 = l4;
        n = i8;
        m = i3;
        i1 = i6;
        f1 = f2;
        l3 = l6;
        i2 = i5;
        i8 = d(0, localAuthReserve);
        paramList = (List<im_msg_body.Elem>)localObject5;
        l1 = l5;
        i = i4;
        j = i9;
        paramStringBuilder = str1;
        localObject1 = localObject6;
        k = i7;
        localObject2 = str2;
        l2 = l4;
        n = i8;
        m = i3;
        i1 = i6;
        f1 = f2;
        l3 = l6;
        i2 = i5;
        localObject6 = c(null, localAuthReserve);
        paramList = (List<im_msg_body.Elem>)localObject5;
        l1 = l5;
        i = i4;
        j = i9;
        paramStringBuilder = str1;
        localObject1 = localObject6;
        k = i7;
        localObject2 = str2;
        l2 = l4;
        n = i8;
        m = i3;
        i1 = i6;
        f1 = f2;
        l3 = l6;
        i2 = i5;
        i7 = e(0, localAuthReserve);
        paramList = (List<im_msg_body.Elem>)localObject5;
        l1 = l5;
        i = i4;
        j = i9;
        paramStringBuilder = str1;
        localObject1 = localObject6;
        k = i7;
        localObject2 = str2;
        l2 = l4;
        n = i8;
        m = i3;
        i1 = i6;
        f1 = f2;
        l3 = l6;
        i2 = i5;
        localObject5 = a((Apollo3DMessage)localObject5, localAuthReserve);
        paramList = (List<im_msg_body.Elem>)localObject5;
        l1 = l5;
        i = i4;
        j = i9;
        paramStringBuilder = str1;
        localObject1 = localObject6;
        k = i7;
        localObject2 = str2;
        l2 = l4;
        n = i8;
        m = i3;
        i1 = i6;
        f1 = f2;
        l3 = l6;
        i2 = i5;
        i4 = f(0, localAuthReserve);
        paramList = (List<im_msg_body.Elem>)localObject5;
        l1 = l5;
        i = i4;
        j = i9;
        paramStringBuilder = str1;
        localObject1 = localObject6;
        k = i7;
        localObject2 = str2;
        l2 = l4;
        n = i8;
        m = i3;
        i1 = i6;
        f1 = f2;
        l3 = l6;
        i2 = i5;
        i9 = g(0, localAuthReserve);
        paramList = (List<im_msg_body.Elem>)localObject5;
        l1 = l5;
        i = i4;
        j = i9;
        paramStringBuilder = str1;
        localObject1 = localObject6;
        k = i7;
        localObject2 = str2;
        l2 = l4;
        n = i8;
        m = i3;
        i1 = i6;
        f1 = f2;
        l3 = l6;
        i2 = i5;
        l5 = c(0L, localAuthReserve);
        paramList = (List<im_msg_body.Elem>)localObject5;
        l1 = l5;
        i = i4;
        j = i9;
        paramStringBuilder = str1;
        localObject1 = localObject6;
        k = i7;
        localObject2 = str2;
        l2 = l4;
        n = i8;
        m = i3;
        i1 = i6;
        f1 = f2;
        l3 = l6;
        i2 = i5;
        localObject7 = a(null, localAuthReserve);
        m = i3;
        localObject2 = localObject6;
        localObject1 = str1;
        paramStringBuilder = (StringBuilder)localObject7;
        paramList = (List<im_msg_body.Elem>)localObject5;
        i2 = i5;
        l3 = l6;
        i1 = i6;
        n = i8;
        str1 = str2;
      }
      catch (InvalidProtocolBufferMicroException localInvalidProtocolBufferMicroException)
      {
        localInvalidProtocolBufferMicroException.printStackTrace();
        localObject4 = localObject2;
        localObject2 = localObject1;
        localObject1 = paramStringBuilder;
        paramStringBuilder = null;
        l5 = l1;
        i4 = i;
        i9 = j;
        i7 = k;
        l4 = l2;
        f2 = f1;
        break label1479;
        ((JSONObject)localObject5).put("welcomeUinList", localObject6);
        localObject6 = paramList.getMessageJSONObject();
        if (localObject6 == null) {
          break label1864;
        }
        ((JSONObject)localObject5).put("mApollo3DMessage", localObject6);
        localApolloMessage.extStr = ((JSONObject)localObject5).toString();
        localApolloMessage.flag = ((im_msg_body.ApolloActMsg)localObject3).uint32_flag.get();
        localApolloMessage.peer_uin = bhbx.a(((im_msg_body.ApolloActMsg)localObject3).uint32_peer_uin.get());
        localApolloMessage.sender_ts = bhbx.a(((im_msg_body.ApolloActMsg)localObject3).uint32_sender_ts.get());
        localApolloMessage.peer_ts = bhbx.a(((im_msg_body.ApolloActMsg)localObject3).uint32_peer_ts.get());
        localApolloMessage.sender_status = ((im_msg_body.ApolloActMsg)localObject3).int32_sender_status.get();
        localApolloMessage.peer_status = ((im_msg_body.ApolloActMsg)localObject3).int32_peer_status.get();
        localObject3 = (MessageForApollo)bcsa.a(-2039);
        ((MessageForApollo)localObject3).msgtype = -2039;
        ((MessageForApollo)localObject3).mApolloMessage = localApolloMessage;
        ((MessageForApollo)localObject3).msgData = apab.a(localApolloMessage);
        ((MessageForApollo)localObject3).inputText = str2;
        ((MessageForApollo)localObject3).audioId = i2;
        ((MessageForApollo)localObject3).audioStartTime = f2;
        ((MessageForApollo)localObject3).msgType = i1;
        ((MessageForApollo)localObject3).gameId = m;
        ((MessageForApollo)localObject3).mGameMode = n;
        ((MessageForApollo)localObject3).roomId = l4;
        ((MessageForApollo)localObject3).signTs = l3;
        ((MessageForApollo)localObject3).gameName = localObject4;
        ((MessageForApollo)localObject3).actionType = i7;
        ((MessageForApollo)localObject3).extendJson = ((String)localObject2);
        ((MessageForApollo)localObject3).gameExtendJson = ((String)localObject1);
        ((MessageForApollo)localObject3).gameStatus = ApolloUtil.a(((MessageForApollo)localObject3).extendJson, "gameStatus");
        ((MessageForApollo)localObject3).mApollo3DMessage = paramList;
        ((MessageForApollo)localObject3).stickerHeight = i4;
        ((MessageForApollo)localObject3).stickerWidth = i9;
        ((MessageForApollo)localObject3).welcomeId = l5;
        ((MessageForApollo)localObject3).welcomeUinList = paramStringBuilder;
        paramList1.add(localObject3);
        return;
      }
      Object localObject5 = new JSONObject();
      if (((im_msg_body.ApolloActMsg)localObject3).input_text.has())
      {
        str2 = new String(((im_msg_body.ApolloActMsg)localObject3).input_text.get().toByteArray());
        ((JSONObject)localObject5).put("inputText", str2);
      }
      for (;;)
      {
        if (i2 > 0)
        {
          ((JSONObject)localObject5).put("audioID", i2);
          ((JSONObject)localObject5).put("audioStartTime", f2);
        }
        if (ApolloGameUtil.a(i1))
        {
          ((JSONObject)localObject5).put("gameId", m);
          ((JSONObject)localObject5).put("gameMode", n);
          ((JSONObject)localObject5).put("roomid", l4);
          ((JSONObject)localObject5).put("msgTyep", i1);
          ((JSONObject)localObject5).put("gameName", str1);
          ((JSONObject)localObject5).put("gameExtendJson", localObject1);
        }
        if (!TextUtils.isEmpty((CharSequence)localObject2)) {
          ((JSONObject)localObject5).put("extendJson", localObject2);
        }
        ((JSONObject)localObject5).put("msgTyep", i1);
        ((JSONObject)localObject5).put("actionType", i7);
        ((JSONObject)localObject5).put("stickerHeight", i4);
        ((JSONObject)localObject5).put("stickerWidth", i9);
        ((JSONObject)localObject5).put("welcomeId", l5);
        if ((paramStringBuilder != null) && (!paramStringBuilder.isEmpty()))
        {
          localObject6 = new JSONArray();
          localObject7 = paramStringBuilder.iterator();
          for (;;)
          {
            if (((Iterator)localObject7).hasNext())
            {
              ((JSONArray)localObject6).put((Long)((Iterator)localObject7).next());
              continue;
              if (!QLog.isColorLevel()) {
                break;
              }
              QLog.e("ApolloElemDecoder", 2, "decode apollo msg failed", paramList);
              return;
            }
          }
        }
        Object localObject4;
        label1864:
        str2 = null;
      }
    }
  }
  
  private int b(int paramInt, ApolloMsgExtend.AuthReserve paramAuthReserve)
  {
    if (paramAuthReserve.sub_type.has()) {
      paramInt = paramAuthReserve.sub_type.get();
    }
    return paramInt;
  }
  
  private long b(long paramLong, ApolloMsgExtend.AuthReserve paramAuthReserve)
  {
    if (paramAuthReserve.sign_ts.has()) {
      paramLong = paramAuthReserve.sign_ts.get();
    }
    return paramLong;
  }
  
  private String b(String paramString, ApolloMsgExtend.AuthReserve paramAuthReserve)
  {
    String str = paramString;
    if (paramAuthReserve.game_share_ark_json.has())
    {
      str = paramString;
      if (paramAuthReserve.game_share_ark_json.get() != null) {
        str = new String(paramAuthReserve.game_share_ark_json.get().toByteArray());
      }
    }
    return str;
  }
  
  private int c(int paramInt, ApolloMsgExtend.AuthReserve paramAuthReserve)
  {
    if (paramAuthReserve.game_id.has()) {
      paramInt = paramAuthReserve.game_id.get();
    }
    return paramInt;
  }
  
  private long c(long paramLong, ApolloMsgExtend.AuthReserve paramAuthReserve)
  {
    if (paramAuthReserve.welcome_id.has()) {
      paramLong = paramAuthReserve.welcome_id.get();
    }
    return paramLong;
  }
  
  private String c(String paramString, ApolloMsgExtend.AuthReserve paramAuthReserve)
  {
    if (paramAuthReserve.extend_json.has()) {
      paramString = new String(paramAuthReserve.extend_json.get().toByteArray());
    }
    return paramString;
  }
  
  private int d(int paramInt, ApolloMsgExtend.AuthReserve paramAuthReserve)
  {
    if (paramAuthReserve.game_mode.has()) {
      paramInt = paramAuthReserve.game_mode.get();
    }
    return paramInt;
  }
  
  private int e(int paramInt, ApolloMsgExtend.AuthReserve paramAuthReserve)
  {
    if (paramAuthReserve.action_type.has()) {
      paramInt = paramAuthReserve.action_type.get();
    }
    return paramInt;
  }
  
  private int f(int paramInt, ApolloMsgExtend.AuthReserve paramAuthReserve)
  {
    if (paramAuthReserve.sticker_height.has()) {
      paramInt = paramAuthReserve.sticker_height.get();
    }
    return paramInt;
  }
  
  private int g(int paramInt, ApolloMsgExtend.AuthReserve paramAuthReserve)
  {
    if (paramAuthReserve.sticker_width.has()) {
      paramInt = paramAuthReserve.sticker_width.get();
    }
    return paramInt;
  }
  
  public int a()
  {
    return 1000;
  }
  
  public boolean a(List<im_msg_body.Elem> paramList, msg_comm.Msg paramMsg, List<MessageRecord> paramList1, StringBuilder paramStringBuilder, boolean paramBoolean1, boolean paramBoolean2, bffl parambffl, bcse parambcse, bcre parambcre)
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
 * Qualified Name:     actz
 * JD-Core Version:    0.7.0.1
 */