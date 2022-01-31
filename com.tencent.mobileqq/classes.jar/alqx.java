import EncounterSvc.EntranceContent;
import EncounterSvc.RespEncounterInfo;
import EncounterSvc.RespGetEntrance;
import EncounterSvc.RespGetRecommender;
import LBSAddrProtocol.GPS;
import LBSAddrProtocol.RspGetPositionApi;
import NeighborSvc.RespGetSwitches;
import NeighborSvc.RespSetStateSwitch;
import NeighborSvc.Switch;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface.OnClickListener;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import appoint.define.appoint_define.LBSInfo;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.NearbyRecommendTroop;
import com.tencent.mobileqq.dating.CarrierHelper.EntranceConfig;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBFixed32Field;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.struct.AdData;
import com.tencent.proto.lbsshare.LBSShare.GetShopsByIdsReq;
import com.tencent.proto.lbsshare.LBSShare.LocationReq;
import com.tencent.proto.lbsshare.LBSShare.NearByShopsReq;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.regex.Pattern;
import org.json.JSONException;
import org.json.JSONObject;
import tencent.im.nearby.entrance.NearbyEntranceContent;
import tencent.im.oidb.cmd0x7f5.cmd0x7f5.GPS;
import tencent.im.oidb.cmd0x7f5.cmd0x7f5.GroupInfo;
import tencent.im.oidb.cmd0x7f5.cmd0x7f5.ReqBody;
import tencent.im.oidb.cmd0x7f5.cmd0x7f5.RspBody;
import tencent.im.oidb.cmd0x9c0.cmd0x9c0.NearbyUser;
import tencent.im.oidb.cmd0x9c0.cmd0x9c0.ReqBody;
import tencent.im.oidb.cmd0x9c0.cmd0x9c0.RspBody;
import tencent.im.oidb.cmd0x9c1.cmd0x9c1.ReqBody;
import tencent.im.oidb.cmd0x9c1.cmd0x9c1.RspBody;
import tencent.im.oidb.oidb_sso.OIDBSSOPkg;
import tencent.im.s2c.msgtype0x210.submsgtype0x27.SubMsgType0x27.NewComeinUser;
import tencent.im.s2c.msgtype0x210.submsgtype0x27.SubMsgType0x27.NewComeinUserNotify;
import tencent.im.s2c.msgtype0x210.submsgtype0x67.submsgtype0x67.GroupInfo;

public class alqx
  extends alko
{
  public static String a;
  
  public alqx(QQAppInterface paramQQAppInterface)
  {
    super(paramQQAppInterface);
  }
  
  public static Dialog a(Context paramContext, String paramString, DialogInterface.OnClickListener paramOnClickListener1, DialogInterface.OnClickListener paramOnClickListener2)
  {
    paramString = bdcd.a(paramContext, 230, null, paramString, 2131690648, 2131719755, paramOnClickListener1, paramOnClickListener2);
    if (paramString != null)
    {
      ((TextView)paramString.findViewById(2131365209)).setVisibility(8);
      paramOnClickListener1 = (TextView)paramString.findViewById(2131365231);
      paramOnClickListener2 = new LinearLayout.LayoutParams(-2, -2);
      paramOnClickListener2.gravity = 17;
      paramOnClickListener1.setLayoutParams(paramOnClickListener2);
      paramOnClickListener1.setMinHeight(bcwh.a(paramContext, 35.0F));
      paramOnClickListener1.setGravity(17);
    }
    return paramString;
  }
  
  private void a(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    boolean bool1;
    label62:
    int i;
    label109:
    int j;
    label128:
    boolean bool2;
    label177:
    int k;
    label193:
    label248:
    String str;
    if ((paramObject != null) && (paramFromServiceMsg != null) && (paramFromServiceMsg.isSuccess()))
    {
      bool1 = true;
      paramToServiceMsg = null;
      if (bool1)
      {
        try
        {
          paramFromServiceMsg = new oidb_sso.OIDBSSOPkg();
          paramFromServiceMsg.mergeFrom((byte[])paramObject);
          if ((paramFromServiceMsg == null) || (paramFromServiceMsg.uint32_result.get() != 0)) {
            break label892;
          }
          bool1 = true;
          if (bool1)
          {
            paramObject = new cmd0x9c0.RspBody();
            paramObject.mergeFrom(paramFromServiceMsg.bytes_bodybuffer.get().toByteArray());
            if (!paramObject.uint32_req_interval.has()) {
              break label898;
            }
            i = paramObject.uint32_req_interval.get();
          }
        }
        catch (Exception paramObject)
        {
          for (;;)
          {
            List localList;
            label294:
            label337:
            label381:
            label511:
            m = -1;
            paramToServiceMsg = null;
            j = -1;
            bool2 = false;
            i = j;
            k = m;
            paramFromServiceMsg = paramToServiceMsg;
            bool1 = bool2;
            if (QLog.isColorLevel())
            {
              QLog.d("LBSHandler", 2, "rspFacetoFaceAddFriendReg Exception " + paramObject.getMessage());
              i = j;
              k = m;
              paramFromServiceMsg = paramToServiceMsg;
              bool1 = bool2;
            }
          }
          if (!QLog.isColorLevel()) {
            break label947;
          }
        }
        try
        {
          if (!paramObject.uint32_heartbeat_interval.has()) {
            break label904;
          }
          j = paramObject.uint32_heartbeat_interval.get();
        }
        catch (Exception paramObject)
        {
          paramToServiceMsg = null;
          j = -1;
          m = i;
          break label665;
        }
        try
        {
          localList = paramObject.rpt_nearby_user_list.get();
          if ((localList != null) && (localList.size() > 0)) {
            break label863;
          }
          bool2 = false;
          bool1 = bool2;
          if (QLog.isColorLevel())
          {
            QLog.d("LBSHandler", 2, "rcv nearbyUserList is null!");
            bool1 = bool2;
          }
        }
        catch (Exception paramObject)
        {
          paramToServiceMsg = null;
          m = i;
          break label665;
          break label511;
          break label177;
        }
        if (bool1)
        {
          paramToServiceMsg = new ArrayList();
          k = 0;
          try
          {
            if (k < localList.size())
            {
              if (!((cmd0x9c0.NearbyUser)localList.get(k)).uint64_nearby_uin.has()) {
                break label910;
              }
              paramFromServiceMsg = String.valueOf(((cmd0x9c0.NearbyUser)localList.get(k)).uint64_nearby_uin.get());
              if (!((cmd0x9c0.NearbyUser)localList.get(k)).uint32_is_frd.has()) {
                break label923;
              }
              if (((cmd0x9c0.NearbyUser)localList.get(k)).uint32_is_frd.get() != 1) {
                break label917;
              }
              bool2 = true;
              if (!((cmd0x9c0.NearbyUser)localList.get(k)).bytes_remark.has()) {
                break label929;
              }
              paramObject = ((cmd0x9c0.NearbyUser)localList.get(k)).bytes_remark.get().toStringUtf8();
              if (!((cmd0x9c0.NearbyUser)localList.get(k)).bytes_nick.has()) {
                break label936;
              }
              str = ((cmd0x9c0.NearbyUser)localList.get(k)).bytes_nick.get().toStringUtf8();
              if (QLog.isColorLevel()) {
                QLog.d("LBSHandler", 2, "faceTofaceNearbyUser: i: " + k + ", nearbyUin: " + paramFromServiceMsg + ", isFriend: " + bool2 + ", remark: " + paramObject + ", nick: " + str);
              }
              if (TextUtils.isEmpty(paramFromServiceMsg)) {
                break label877;
              }
              paramToServiceMsg.add(new aqgp(paramFromServiceMsg, bool2, paramObject, str));
              break label877;
            }
            if ((paramToServiceMsg != null) && (paramToServiceMsg.size() > 0)) {
              break label857;
            }
            if (QLog.isColorLevel()) {
              QLog.d("LBSHandler", 2, "faceTofaceNearbyUserList is empty!");
            }
            bool1 = false;
          }
          catch (Exception paramObject)
          {
            for (;;)
            {
              m = i;
            }
          }
          paramFromServiceMsg = paramToServiceMsg;
          k = i;
          i = j;
        }
      }
    }
    for (;;)
    {
      label521:
      notifyUI(25, bool1, new Object[] { paramFromServiceMsg, Integer.valueOf(k), Integer.valueOf(i) });
      return;
      if (paramFromServiceMsg != null)
      {
        i = paramFromServiceMsg.uint32_result.get();
        switch (i)
        {
        }
      }
      for (;;)
      {
        if (!QLog.isColorLevel()) {
          break label947;
        }
        QLog.d("LBSHandler", 2, "rspFacetoFaceAddFriendReg  fail resultCode : " + i);
        break label947;
        if (!QLog.isColorLevel()) {
          break label947;
        }
        QLog.d("LBSHandler", 2, "rspFacetoFaceAddFriendReg  fail resultCode : body uin is not equal bodyhead uin");
        break label947;
        int m;
        label665:
        QLog.d("LBSHandler", 2, "rspFacetoFaceAddFriendReg  fail resultCode : get nearbylist fail");
        break label947;
        if (!QLog.isColorLevel()) {
          break label947;
        }
        QLog.d("LBSHandler", 2, "rspFacetoFaceAddFriendReg  fail resultCode : judge friend ralationship fail");
        break label947;
        if (!QLog.isColorLevel()) {
          break label947;
        }
        QLog.d("LBSHandler", 2, "rspFacetoFaceAddFriendReg  fail resultCode : get remark fail");
        break label947;
        if (!QLog.isColorLevel()) {
          break label947;
        }
        QLog.d("LBSHandler", 2, "rspFacetoFaceAddFriendReg  fail resultCode : get nick fail");
        break label947;
        if (QLog.isColorLevel()) {
          QLog.d("LBSHandler", 2, "ssoPkg is null");
        }
        paramFromServiceMsg = null;
        i = -1;
        k = -1;
        break label521;
        label857:
        label863:
        k = -1;
        paramFromServiceMsg = null;
        i = -1;
        break label521;
        label877:
        k += 1;
        break label193;
        bool1 = false;
        break;
        label892:
        bool1 = false;
        break label62;
        label898:
        i = -1;
        break label109;
        label904:
        j = -1;
        break label128;
        label910:
        paramFromServiceMsg = "";
        break label248;
        label917:
        bool2 = false;
        break label294;
        label923:
        bool2 = false;
        break label294;
        label929:
        paramObject = "";
        break label337;
        label936:
        str = "";
        break label381;
      }
      label947:
      paramFromServiceMsg = null;
      i = -1;
      k = -1;
    }
  }
  
  public static boolean a(QQAppInterface paramQQAppInterface, String paramString)
  {
    boolean bool1;
    if (paramQQAppInterface == null) {
      bool1 = false;
    }
    boolean bool2;
    do
    {
      return bool1;
      bool2 = paramQQAppInterface.a().a(paramString, 1001);
      bool1 = bool2;
    } while (!QLog.isColorLevel());
    QLog.d("LBSHandlerQ.nearby.follow", 2, "hasReply:" + bool2);
    return bool2;
  }
  
  private void b(FromServiceMsg paramFromServiceMsg, ToServiceMsg paramToServiceMsg, Object paramObject)
  {
    apds.b("LBSHandler", new Object[] { "handleGetEntrance", paramObject });
    if ((paramObject instanceof Object[]))
    {
      paramFromServiceMsg = (Object[])paramObject;
      paramObject = (NeighborComm.RespHeader)paramFromServiceMsg[0];
      paramToServiceMsg = (RespGetEntrance)paramFromServiceMsg[1];
      Object localObject1;
      label148:
      label201:
      EntranceContent localEntranceContent;
      Object localObject2;
      if (QLog.isColorLevel())
      {
        localObject1 = new StringBuilder().append("handleGetEntrance---->respHeader=").append(paramObject).append("|error code=");
        if (paramObject == null)
        {
          paramFromServiceMsg = "null";
          QLog.d("LBSHandler", 2, paramFromServiceMsg);
        }
      }
      else
      {
        if ((paramObject == null) || (paramObject.eReplyCode != 0) || (paramToServiceMsg == null)) {
          break label798;
        }
        if (QLog.isColorLevel())
        {
          paramObject = new StringBuilder().append("handleGetEntrance---->RespGetEntrance.entrance_list size=");
          if (paramToServiceMsg.entrance_list != null) {
            break label483;
          }
          paramFromServiceMsg = "null";
          QLog.d("LBSHandler", 2, paramFromServiceMsg);
        }
        paramFromServiceMsg = new Object[2];
        paramObject = new LinkedList();
        if ((paramToServiceMsg.entrance_list == null) || (paramToServiceMsg.entrance_list.isEmpty())) {
          break label551;
        }
        localObject1 = paramToServiceMsg.entrance_list.iterator();
        if (!((Iterator)localObject1).hasNext()) {
          break label551;
        }
        localEntranceContent = (EntranceContent)((Iterator)localObject1).next();
        localObject2 = new AdData();
        if (localEntranceContent.type != 100) {
          break label497;
        }
      }
      label483:
      label497:
      for (int i = 5;; i = localEntranceContent.type)
      {
        ((AdData)localObject2).ad_source = i;
        NearbyEntranceContent localNearbyEntranceContent = new NearbyEntranceContent();
        try
        {
          localNearbyEntranceContent.mergeFrom(localEntranceContent.content_buff);
          ((AdData)localObject2).id = localNearbyEntranceContent.int64_id.get();
          ((AdData)localObject2).idType = localNearbyEntranceContent.int32_id_type.get();
          ((AdData)localObject2).jump_url = localNearbyEntranceContent.str_url.get();
          ((AdData)localObject2).picType = localNearbyEntranceContent.int32_pic_type.get();
          ((AdData)localObject2).title = localNearbyEntranceContent.str_title.get();
          ((AdData)localObject2).content = localNearbyEntranceContent.str_content.get();
          ((AdData)localObject2).content2 = localNearbyEntranceContent.str_content2.get();
          ((AdData)localObject2).img_url = localNearbyEntranceContent.pic_url.get();
          ((AdData)localObject2).fontColor = AdData.parseAdColor(((AdData)localObject2).ad_source, false, localNearbyEntranceContent.txt_color.get());
          ((AdData)localObject2).bgColor = AdData.parseAdColor(((AdData)localObject2).ad_source, true, localNearbyEntranceContent.bg_color.get());
          ((AdData)localObject2).wording = AdData.getWording(((AdData)localObject2).ad_source, localNearbyEntranceContent.corner_wording.get());
          ((AdData)localObject2).distance = localNearbyEntranceContent.str_distance.get();
          i = 1;
        }
        catch (InvalidProtocolBufferMicroException localInvalidProtocolBufferMicroException)
        {
          for (;;)
          {
            if (QLog.isColorLevel()) {
              QLog.w("LBSHandler", 2, "handleGetEntrance error:" + localInvalidProtocolBufferMicroException.getMessage());
            }
            i = 0;
          }
        }
        if (i == 0) {
          break label201;
        }
        paramObject.add(localObject2);
        break label201;
        paramFromServiceMsg = Integer.valueOf(paramObject.eReplyCode);
        break;
        paramFromServiceMsg = Integer.valueOf(paramToServiceMsg.entrance_list.size());
        break label148;
      }
      label551:
      paramFromServiceMsg[0] = paramObject;
      if ((paramToServiceMsg.xml_list != null) && (paramToServiceMsg.xml_list.size() > 0))
      {
        paramObject = new ArrayList();
        paramToServiceMsg = paramToServiceMsg.xml_list.iterator();
        while (paramToServiceMsg.hasNext())
        {
          localObject1 = (String)paramToServiceMsg.next();
          if (!bdje.a((String)localObject1))
          {
            localObject2 = new CarrierHelper.EntranceConfig();
            paramObject.add(localObject2);
            try
            {
              JSONObject localJSONObject = new JSONObject((String)localObject1);
              if (localJSONObject.has("type")) {
                ((CarrierHelper.EntranceConfig)localObject2).type = localJSONObject.getInt("type");
              }
              if (localJSONObject.has("icon_url")) {
                ((CarrierHelper.EntranceConfig)localObject2).iconUrl = localJSONObject.getString("icon_url");
              }
              if (localJSONObject.has("wording")) {
                ((CarrierHelper.EntranceConfig)localObject2).wording = localJSONObject.getString("wording");
              }
              if (localJSONObject.has("jump_url")) {
                ((CarrierHelper.EntranceConfig)localObject2).jumpUrl = localJSONObject.getString("jump_url");
              }
            }
            catch (JSONException localJSONException)
            {
              if (QLog.isColorLevel()) {
                QLog.d("LBSHandler", 2, "handleGetEntrance---->JSONException was thrown when parse JSON. string=" + (String)localObject1);
              }
              localJSONException.printStackTrace();
            }
          }
        }
        paramFromServiceMsg[1] = paramObject;
      }
      notifyUI(24, true, paramFromServiceMsg);
      return;
      label798:
      notifyUI(24, false, null);
      return;
    }
    notifyUI(24, false, null);
  }
  
  private void b(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    boolean bool2 = false;
    boolean bool1;
    if ((paramObject != null) && (paramFromServiceMsg != null) && (paramFromServiceMsg.isSuccess()))
    {
      bool1 = true;
      paramFromServiceMsg = paramToServiceMsg.extraData.getString("currentAccountUin");
      if (!bool1) {
        break label344;
      }
    }
    label344:
    for (;;)
    {
      try
      {
        paramToServiceMsg = new oidb_sso.OIDBSSOPkg();
        paramToServiceMsg.mergeFrom((byte[])paramObject);
        if ((paramToServiceMsg == null) || (paramToServiceMsg.uint32_result.get() != 0)) {
          continue;
        }
        bool1 = true;
        if (!bool1) {
          continue;
        }
        paramObject = new cmd0x9c1.RspBody();
        paramObject.mergeFrom(paramToServiceMsg.bytes_bodybuffer.get().toByteArray());
        if (!paramObject.uint64_uin.has()) {
          continue;
        }
        paramToServiceMsg = String.valueOf(paramObject.uint64_uin.get());
        if (QLog.isColorLevel()) {
          QLog.d("LBSHandler", 2, "rspFacetoFaceAddFriendUnreg RspUin " + paramToServiceMsg + " ReqUin " + paramFromServiceMsg);
        }
      }
      catch (Exception paramToServiceMsg)
      {
        bool1 = bool2;
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.d("LBSHandler", 2, "rspFacetoFaceAddFriendUnreg Exception " + paramToServiceMsg.getMessage());
        bool1 = bool2;
        continue;
        bool1 = bool2;
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.d("LBSHandler", 2, "rspFacetoFaceAddFriendUnreg ssoPkg is null");
        bool1 = bool2;
        continue;
      }
      if (QLog.isColorLevel()) {
        QLog.d("LBSHandler", 2, "rspFacetoFaceAddFriendUnreg  isSuccess " + bool1);
      }
      return;
      bool1 = false;
      break;
      bool1 = false;
      continue;
      paramToServiceMsg = "";
      continue;
      if (paramToServiceMsg != null)
      {
        bool1 = bool2;
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.d("LBSHandler", 2, "rspFacetoFaceAddFriendUnreg  fail resultCode : " + paramToServiceMsg.uint32_result.get());
        bool1 = bool2;
      }
    }
  }
  
  private void c(FromServiceMsg paramFromServiceMsg, ToServiceMsg paramToServiceMsg, Object paramObject)
  {
    if (QLog.isColorLevel()) {
      QLog.d("LBSHandler", 2, "handleGetNearbyRecommender");
    }
    int j;
    if ((paramObject instanceof Object[]))
    {
      paramFromServiceMsg = (Object[])paramObject;
      Object localObject = (NeighborComm.RespHeader)paramFromServiceMsg[0];
      paramObject = (RespGetRecommender)paramFromServiceMsg[1];
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder().append("handleGetNearbyRecommender---->respHeader=").append(localObject).append("|error code=");
        if (localObject == null)
        {
          paramFromServiceMsg = "null";
          QLog.d("LBSHandler", 2, paramFromServiceMsg);
        }
      }
      else
      {
        if ((localObject == null) || (((NeighborComm.RespHeader)localObject).eReplyCode != 0)) {
          break label586;
        }
        j = paramToServiceMsg.extraData.getInt("timingType", -1);
        if ((paramObject == null) || (paramObject.vEncounterInfos == null) || (paramObject.vEncounterInfos.size() <= 0)) {
          break label552;
        }
        localObject = paramObject.vEncounterInfos;
        if (QLog.isColorLevel())
        {
          paramToServiceMsg = new StringBuilder().append("handleGetNearbyRecommender---->RespGetRecommender.vEncounterInfos size=");
          if (localObject != null) {
            break label375;
          }
        }
      }
      label375:
      for (paramFromServiceMsg = "null";; paramFromServiceMsg = Integer.valueOf(((List)localObject).size()))
      {
        QLog.d("LBSHandler", 2, paramFromServiceMsg + ",resasonType=" + paramObject.eReasonType);
        paramFromServiceMsg = new ArrayList();
        paramFromServiceMsg.addAll((Collection)localObject);
        if (j == 0) {
          avpv.a(this.app, paramObject.strBrief, paramObject.uRecommendTime);
        }
        avpv.a(this.app.getApplication(), getCurrentAccountUin(), paramFromServiceMsg);
        notifyUI(27, true, new Object[] { localObject, Integer.valueOf(j) });
        if (localObject == null) {
          break label389;
        }
        paramFromServiceMsg = "";
        int i = 0;
        for (;;)
        {
          paramToServiceMsg = paramFromServiceMsg;
          if (i >= ((List)localObject).size()) {
            break;
          }
          paramFromServiceMsg = paramFromServiceMsg + Long.toString(((RespEncounterInfo)((List)localObject).get(i)).lEctID) + ";";
          i += 1;
        }
        paramFromServiceMsg = Integer.valueOf(((NeighborComm.RespHeader)localObject).eReplyCode);
        break;
      }
      label389:
      paramToServiceMsg = "";
      if ("".equals(paramToServiceMsg)) {
        break label604;
      }
    }
    label552:
    label586:
    label604:
    for (paramFromServiceMsg = paramToServiceMsg.substring(0, paramToServiceMsg.length() - 1);; paramFromServiceMsg = paramToServiceMsg)
    {
      azmj.b(this.app, "CliOper", "", "", "0X80055FA", "0X80055FA", 0, 0, Integer.toString(paramObject.eReasonType), "", paramFromServiceMsg, "");
      paramToServiceMsg = new Bundle();
      if (paramObject != null)
      {
        paramToServiceMsg.putInt("key_login_pull_interval", paramObject.iOuterInterval);
        paramToServiceMsg.putInt("key_msgbox_pull_interval", paramObject.iInnerInterval);
        paramToServiceMsg.putInt("key_expiretime", paramObject.iExpiretime);
        paramToServiceMsg.putString("key_nearbyrecommender_title", paramObject.strTitle);
        paramToServiceMsg.putInt("key_nearbyrecommender_reasontype", paramObject.eReasonType);
      }
      paramToServiceMsg.putString("key_nearbyrecommender_uins", paramFromServiceMsg);
      if (j == 0) {
        paramToServiceMsg.putLong("key_login_pull_time", System.currentTimeMillis());
      }
      for (;;)
      {
        avpv.a(this.app, paramToServiceMsg);
        return;
        notifyUI(27, false, null);
        paramFromServiceMsg = "";
        break;
        if (j == 1) {
          paramToServiceMsg.putLong("key_msgbox_pull_time", System.currentTimeMillis());
        }
      }
      notifyUI(27, false, null);
      return;
      notifyUI(27, false, null);
      return;
    }
  }
  
  public void a()
  {
    send(new ToServiceMsg("mobileqq.service", getCurrentAccountUin(), "NeighborSvc.ReqGetSwitches"));
  }
  
  public void a(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.i("LBSHandler", 2, "getNearbyRecommender| timingType = " + paramInt);
    }
    ToServiceMsg localToServiceMsg = new ToServiceMsg("mobileqq.service", getCurrentAccountUin(), "NeighborRecommender.ReqGetRecommender");
    localToServiceMsg.extraData.putInt("timingType", paramInt);
    send(localToServiceMsg);
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("LBSHandler", 2, "getNewNearbyTroops lat = " + paramInt1 + " lon = " + paramInt2);
    }
    Object localObject2 = new cmd0x7f5.ReqBody();
    ((cmd0x7f5.ReqBody)localObject2).uint32_max_count.set(1);
    ((cmd0x7f5.ReqBody)localObject2).uint32_max_distance.set(1000);
    ((cmd0x7f5.ReqBody)localObject2).uint32_loc_type.set(0);
    Object localObject1 = BaseApplicationImpl.getContext();
    try
    {
      Object localObject3;
      if (bdee.h((Context)localObject1))
      {
        localObject1 = (WifiManager)((Context)localObject1).getSystemService("wifi");
        localObject3 = ((WifiManager)localObject1).getConnectionInfo().getBSSID();
        ((cmd0x7f5.ReqBody)localObject2).bytes_route_mac.set(ByteStringMicro.copyFromUtf8((String)localObject3));
        ((cmd0x7f5.ReqBody)localObject2).uint32_ipv4.set(((WifiManager)localObject1).getConnectionInfo().getIpAddress());
      }
      for (;;)
      {
        localObject1 = new cmd0x7f5.GPS();
        ((cmd0x7f5.GPS)localObject1).uint32_latitude.set(paramInt1);
        ((cmd0x7f5.GPS)localObject1).uint32_longitude.set(paramInt2);
        ((cmd0x7f5.GPS)localObject1).bytes_client_version.set(ByteStringMicro.copyFromUtf8("8.3.3"));
        ((cmd0x7f5.GPS)localObject1).uint32_client.set(2);
        ((cmd0x7f5.ReqBody)localObject2).msg_gps.set((MessageMicro)localObject1);
        localObject1 = new oidb_sso.OIDBSSOPkg();
        ((oidb_sso.OIDBSSOPkg)localObject1).uint32_command.set(2037);
        ((oidb_sso.OIDBSSOPkg)localObject1).uint32_result.set(0);
        ((oidb_sso.OIDBSSOPkg)localObject1).uint32_service_type.set(1);
        ((oidb_sso.OIDBSSOPkg)localObject1).bytes_bodybuffer.set(ByteStringMicro.copyFrom(((cmd0x7f5.ReqBody)localObject2).toByteArray()));
        localObject2 = createToServiceMsg("OidbSvc.0x7f5_1");
        ((ToServiceMsg)localObject2).putWupBuffer(((oidb_sso.OIDBSSOPkg)localObject1).toByteArray());
        sendPbReq((ToServiceMsg)localObject2);
        return;
        if (bdee.c((Context)localObject1))
        {
          localObject1 = a;
          if (!TextUtils.isEmpty((CharSequence)localObject1)) {
            break label412;
          }
          localObject1 = abpv.k();
          if (TextUtils.isEmpty((CharSequence)localObject1)) {
            break;
          }
          localObject3 = ((String)localObject1).split(Pattern.quote("."));
          int k = localObject3.length;
          int j = 0;
          int m;
          for (i = 0; j < k; i = m | i << 8)
          {
            m = Integer.parseInt(localObject3[j]);
            j += 1;
          }
          a = (String)localObject1;
          if (i != 0) {
            ((cmd0x7f5.ReqBody)localObject2).uint32_ipv4.set(i);
          }
        }
      }
    }
    catch (Exception localException)
    {
      label412:
      for (;;)
      {
        localException.printStackTrace();
        continue;
        int i = 0;
      }
    }
  }
  
  public void a(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5)
  {
    if ((paramInt1 == 0) || (paramInt2 == 0) || (paramInt3 < 0) || (paramInt3 > 1)) {
      return;
    }
    ToServiceMsg localToServiceMsg = new ToServiceMsg("mobileqq.service", getCurrentAccountUin(), "LbsShareSvr.nearby_shops");
    LBSShare.NearByShopsReq localNearByShopsReq = new LBSShare.NearByShopsReq();
    localNearByShopsReq.lat.set(paramInt1);
    localNearByShopsReq.lng.set(paramInt2);
    localNearByShopsReq.coordinate.set(paramInt3);
    localNearByShopsReq.begin.set(paramInt4);
    localNearByShopsReq.limit.set(paramInt5);
    localNearByShopsReq.version.set(1);
    Bundle localBundle = new Bundle();
    localBundle.putInt("latitude", paramInt1);
    localBundle.putInt("longitude", paramInt2);
    localBundle.putInt("coordinate", paramInt3);
    localBundle.putInt("begin", paramInt4);
    localBundle.putInt("count", paramInt5);
    localToServiceMsg.extraData.putBundle("req", localBundle);
    localToServiceMsg.putWupBuffer(localNearByShopsReq.toByteArray());
    sendPbReq(localToServiceMsg);
  }
  
  public void a(int paramInt1, int paramInt2, int paramInt3, String paramString1, String paramString2, int paramInt4, int paramInt5, int paramInt6)
  {
    if ((paramInt1 == 0) || (paramInt2 == 0) || (paramInt3 < 0) || (paramInt3 > 1) || (paramInt4 < 0) || (paramInt5 < 0) || (paramInt5 > 100)) {
      return;
    }
    String str = paramString1;
    if (paramString1 == null) {
      str = "";
    }
    paramString1 = paramString2;
    if (paramString2 == null) {
      paramString1 = "";
    }
    ToServiceMsg localToServiceMsg = new ToServiceMsg("mobileqq.service", getCurrentAccountUin(), "LbsShareSvr.location");
    LBSShare.LocationReq localLocationReq = new LBSShare.LocationReq();
    localLocationReq.lat.set(paramInt1);
    localLocationReq.lng.set(paramInt2);
    localLocationReq.coordinate.set(paramInt3);
    localLocationReq.keyword.set(str);
    localLocationReq.category.set(paramString1);
    localLocationReq.page.set(paramInt4);
    localLocationReq.count.set(paramInt5);
    localLocationReq.requireMyLbs.set(paramInt6);
    Object localObject = bdcb.a();
    paramString2 = (String)localObject;
    if (localObject == null) {
      paramString2 = "";
    }
    localLocationReq.imei.set(paramString2);
    localObject = new Bundle();
    ((Bundle)localObject).putInt("latitude", paramInt1);
    ((Bundle)localObject).putInt("longitude", paramInt2);
    ((Bundle)localObject).putInt("coordinate", paramInt3);
    ((Bundle)localObject).putString("keyword", str);
    ((Bundle)localObject).putString("category", paramString1);
    ((Bundle)localObject).putInt("page", paramInt4);
    ((Bundle)localObject).putInt("count", paramInt5);
    ((Bundle)localObject).putInt("requireMyLbs", paramInt6);
    ((Bundle)localObject).putString("imei", paramString2);
    localToServiceMsg.extraData.putBundle("req", (Bundle)localObject);
    localToServiceMsg.putWupBuffer(localLocationReq.toByteArray());
    sendPbReq(localToServiceMsg);
  }
  
  public void a(int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean)
  {
    ToServiceMsg localToServiceMsg = new ToServiceMsg("mobileqq.service", getCurrentAccountUin(), "NearbyGroup.ReqGetAreaList");
    localToServiceMsg.extraData.putInt("lat", paramInt1);
    localToServiceMsg.extraData.putInt("lon", paramInt2);
    localToServiceMsg.extraData.putInt("radius", paramInt3);
    localToServiceMsg.extraData.putBoolean("clickable", paramBoolean);
    send(localToServiceMsg);
  }
  
  public void a(FromServiceMsg paramFromServiceMsg, ToServiceMsg paramToServiceMsg, Object paramObject)
  {
    boolean bool3 = true;
    boolean bool2 = false;
    if (QLog.isColorLevel()) {
      QLog.d("LBSHandler", 2, "handleGetNewNearbyTroops");
    }
    boolean bool1;
    if ((paramObject != null) && (paramFromServiceMsg != null) && (paramFromServiceMsg.isSuccess()))
    {
      bool1 = true;
      if (!bool1) {
        break label318;
      }
    }
    label318:
    for (;;)
    {
      try
      {
        paramFromServiceMsg = new oidb_sso.OIDBSSOPkg();
        paramFromServiceMsg.mergeFrom((byte[])paramObject);
        if ((paramFromServiceMsg == null) || (paramFromServiceMsg.uint32_result.get() != 0)) {
          continue;
        }
        bool1 = bool3;
        if (!bool1) {
          continue;
        }
        paramObject = new cmd0x7f5.RspBody();
        paramObject.mergeFrom(paramFromServiceMsg.bytes_bodybuffer.get().toByteArray());
        int i = paramObject.uint32_recruit_number.get();
        paramToServiceMsg = null;
        paramObject = paramObject.rpt_group_info.get();
        paramFromServiceMsg = paramToServiceMsg;
        if (paramObject != null)
        {
          paramFromServiceMsg = paramToServiceMsg;
          if (paramObject.size() > 0) {
            paramFromServiceMsg = (cmd0x7f5.GroupInfo)paramObject.get(0);
          }
        }
        notifyUI(28, bool1, new Object[] { Integer.valueOf(i), paramFromServiceMsg });
      }
      catch (Exception paramFromServiceMsg)
      {
        bool1 = bool2;
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.d("LBSHandler", 2, "handleGetNewNearbyTroops Exception " + paramFromServiceMsg.getMessage());
        bool1 = bool2;
        continue;
      }
      if (QLog.isColorLevel()) {
        QLog.d("LBSHandler", 2, "handleGetNewNearbyTroops  isSuccess " + bool1);
      }
      return;
      bool1 = false;
      break;
      bool1 = false;
      continue;
      if (QLog.isColorLevel()) {
        QLog.d("LBSHandler", 2, "handleGetNewNearbyTroops  fail resultCode : " + paramFromServiceMsg.uint32_result.get());
      }
      bool1 = false;
    }
  }
  
  public void a(String paramString)
  {
    Object localObject = new cmd0x9c1.ReqBody();
    ((cmd0x9c1.ReqBody)localObject).uint64_uin.set(Long.valueOf(paramString).longValue());
    oidb_sso.OIDBSSOPkg localOIDBSSOPkg = new oidb_sso.OIDBSSOPkg();
    localOIDBSSOPkg.uint32_command.set(2497);
    localOIDBSSOPkg.uint32_result.set(0);
    localOIDBSSOPkg.uint32_service_type.set(0);
    localOIDBSSOPkg.bytes_bodybuffer.set(ByteStringMicro.copyFrom(((cmd0x9c1.ReqBody)localObject).toByteArray()));
    localObject = createToServiceMsg("OidbSvc.0x9c1_0");
    ((ToServiceMsg)localObject).putWupBuffer(localOIDBSSOPkg.toByteArray());
    ((ToServiceMsg)localObject).extraData.putString("currentAccountUin", paramString);
    if (QLog.isColorLevel()) {
      QLog.d("LBSHandler", 2, "Face2FaceAddFriendActivity reqFacetoFaceAddFriendUnreg");
    }
    sendPbReq((ToServiceMsg)localObject);
  }
  
  public void a(String paramString, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5) {}
  
  public void a(ArrayList<String> paramArrayList)
  {
    if (paramArrayList == null) {
      return;
    }
    ToServiceMsg localToServiceMsg = new ToServiceMsg("mobileqq.service", getCurrentAccountUin(), "LbsShareSvr.get_shops_by_ids");
    LBSShare.GetShopsByIdsReq localGetShopsByIdsReq = new LBSShare.GetShopsByIdsReq();
    localGetShopsByIdsReq.ids.set(paramArrayList);
    localToServiceMsg.putWupBuffer(localGetShopsByIdsReq.toByteArray());
    sendPbReq(localToServiceMsg);
  }
  
  public void a(List<submsgtype0x67.GroupInfo> paramList)
  {
    if ((paramList == null) || (paramList.size() == 0))
    {
      notifyUI(19, false, Integer.valueOf(0));
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("nearbyTroopPush", 2, "handleNearbyRecommendTroopPush:" + paramList.size());
    }
    awbw localawbw = this.app.getEntityManagerFactory(getCurrentAccountUin()).createEntityManager();
    awby localawby = localawbw.a();
    localawby.a();
    int i = 0;
    try
    {
      while (i < paramList.size())
      {
        submsgtype0x67.GroupInfo localGroupInfo = (submsgtype0x67.GroupInfo)paramList.get(i);
        NearbyRecommendTroop localNearbyRecommendTroop = new NearbyRecommendTroop();
        localNearbyRecommendTroop.uin = (localGroupInfo.uint64_group_code.get() + "");
        localNearbyRecommendTroop.name = localGroupInfo.str_group_name.get();
        localNearbyRecommendTroop.intro = localGroupInfo.str_group_memo.get();
        localNearbyRecommendTroop.memberNum = localGroupInfo.uint32_member_num.get();
        localNearbyRecommendTroop.troopType = localGroupInfo.uint32_group_type.get();
        localawbw.b(localNearbyRecommendTroop);
        i += 1;
      }
      localawby.c();
      notifyUI(19, true, Integer.valueOf(paramList.size()));
      return;
    }
    catch (Exception paramList)
    {
      if (QLog.isColorLevel()) {
        QLog.d("recommendTroopPush", 2, "handleNearbyRecommendTroopPush exception" + paramList.toString());
      }
      return;
    }
    finally
    {
      localawby.b();
    }
  }
  
  public void a(SubMsgType0x27.NewComeinUserNotify paramNewComeinUserNotify)
  {
    String str1 = null;
    if (paramNewComeinUserNotify == null) {
      return;
    }
    Object localObject;
    label59:
    boolean bool;
    label84:
    String str2;
    if (paramNewComeinUserNotify.msg_new_comein_user.has())
    {
      localObject = (SubMsgType0x27.NewComeinUser)paramNewComeinUserNotify.msg_new_comein_user.get();
      if (localObject == null) {
        break label343;
      }
      if (!((SubMsgType0x27.NewComeinUser)localObject).uint64_uin.has()) {
        break label309;
      }
      str1 = String.valueOf(((SubMsgType0x27.NewComeinUser)localObject).uint64_uin.get());
      if (!((SubMsgType0x27.NewComeinUser)localObject).uint32_is_frd.has()) {
        break label322;
      }
      if (((SubMsgType0x27.NewComeinUser)localObject).uint32_is_frd.get() != 1) {
        break label317;
      }
      bool = true;
      if (!((SubMsgType0x27.NewComeinUser)localObject).bytes_remark.has()) {
        break label327;
      }
      str2 = ((SubMsgType0x27.NewComeinUser)localObject).bytes_remark.get().toStringUtf8();
      label108:
      if (!((SubMsgType0x27.NewComeinUser)localObject).bytes_nick.has()) {
        break label335;
      }
      localObject = ((SubMsgType0x27.NewComeinUser)localObject).bytes_nick.get().toStringUtf8();
      label132:
      if (QLog.isColorLevel()) {
        QLog.d("LBSHandler", 2, "faceTofaceNearbyUser: push nearbyUin: " + str1 + ", isFriend: " + bool + ", remark: " + str2 + ", nick: " + (String)localObject);
      }
      if (TextUtils.isEmpty(str1)) {
        break label379;
      }
      localObject = new aqgp(str1, bool, str2, (String)localObject);
    }
    for (;;)
    {
      label218:
      if (paramNewComeinUserNotify.uint32_msg_type.has()) {
        paramNewComeinUserNotify.uint32_msg_type.get();
      }
      if (paramNewComeinUserNotify.bool_strong_notify.has())
      {
        bool = paramNewComeinUserNotify.bool_strong_notify.get();
        label254:
        if (!paramNewComeinUserNotify.uint32_push_time.has()) {
          break label374;
        }
      }
      label309:
      label317:
      label322:
      label327:
      label335:
      label343:
      label374:
      for (int i = paramNewComeinUserNotify.uint32_push_time.get();; i = -1)
      {
        notifyUI(26, true, new Object[] { localObject, Boolean.valueOf(bool), Integer.valueOf(i) });
        return;
        localObject = null;
        break;
        str1 = "";
        break label59;
        bool = false;
        break label84;
        bool = false;
        break label84;
        str2 = "";
        break label108;
        localObject = "";
        break label132;
        localObject = str1;
        if (!QLog.isColorLevel()) {
          break label218;
        }
        QLog.d("LBSHandler", 2, "faceTofaceNearbyUser  push NewComeinUser is null ");
        localObject = str1;
        break label218;
        bool = false;
        break label254;
      }
      label379:
      localObject = null;
    }
  }
  
  public void a(boolean paramBoolean)
  {
    ToServiceMsg localToServiceMsg = new ToServiceMsg("mobileqq.service", getCurrentAccountUin(), "NeighborSvc.ReqSetStateSwitch");
    localToServiceMsg.extraData.putBoolean("k_be_share", paramBoolean);
    send(localToServiceMsg);
  }
  
  public void a(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, String paramString, int paramInt4)
  {
    short s2 = 0;
    ToServiceMsg localToServiceMsg = new ToServiceMsg("mobileqq.service", getCurrentAccountUin(), "NearbyGroup.GetGroupList");
    localToServiceMsg.extraData.putLong("startTime", System.currentTimeMillis());
    localToServiceMsg.extraData.putBoolean("first", paramBoolean);
    if (!TextUtils.isEmpty(paramString)) {
      localToServiceMsg.extraData.putString("strGroupArea", paramString);
    }
    if ((paramInt1 != 0) && (paramInt2 != 0))
    {
      localToServiceMsg.extraData.putInt("lat", paramInt1);
      localToServiceMsg.extraData.putInt("lon", paramInt2);
    }
    short s1 = s2;
    switch (paramInt3)
    {
    default: 
      s1 = s2;
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("LBSHandler", 2, "shSortType:" + s1 + ",iFilterId:" + paramInt4);
      }
      localToServiceMsg.extraData.putShort("shSortType", s1);
      send(localToServiceMsg);
      return;
      s1 = 1;
      continue;
      s1 = 2;
      continue;
      s1 = 3;
      localToServiceMsg.extraData.putInt("iFilterId", paramInt4);
    }
  }
  
  public boolean a(String paramString, boolean paramBoolean)
  {
    Object localObject = new cmd0x9c0.ReqBody();
    ((cmd0x9c0.ReqBody)localObject).uint64_uin.set(Long.valueOf(paramString).longValue());
    paramString = ((cmd0x9c0.ReqBody)localObject).uint32_heartbeat;
    if (paramBoolean) {}
    for (int i = 1;; i = 0)
    {
      paramString.set(i);
      if (paramBoolean) {
        break label91;
      }
      paramString = aupw.a(getClass().getSimpleName());
      if (paramString != null) {
        break;
      }
      if (QLog.isColorLevel()) {
        QLog.d("LBSHandler", 2, "lbsInfo is null");
      }
      return false;
    }
    ((cmd0x9c0.ReqBody)localObject).msg_lbs_info.set(paramString);
    label91:
    paramString = new oidb_sso.OIDBSSOPkg();
    paramString.uint32_command.set(2496);
    paramString.uint32_result.set(0);
    paramString.uint32_service_type.set(0);
    paramString.bytes_bodybuffer.set(ByteStringMicro.copyFrom(((cmd0x9c0.ReqBody)localObject).toByteArray()));
    localObject = createToServiceMsg("OidbSvc.0x9c0_0");
    ((ToServiceMsg)localObject).putWupBuffer(paramString.toByteArray());
    sendPbReq((ToServiceMsg)localObject);
    return true;
  }
  
  public void b()
  {
    alsw.a(this, false, true, 0, 0);
  }
  
  public void b(int paramInt1, int paramInt2)
  {
    alsw.a(this, true, false, paramInt1, paramInt2);
  }
  
  protected boolean msgCmdFilter(String paramString)
  {
    if (this.allowCmdSet == null)
    {
      this.allowCmdSet = new HashSet();
      this.allowCmdSet.add("LBS.AddressService");
      this.allowCmdSet.add("EncounterSvc.ReqGetEntrance");
      this.allowCmdSet.add("NeighborRecommender.ReqGetRecommender");
      this.allowCmdSet.add("NearbyGroup.GetGroupList");
      this.allowCmdSet.add("NeighborSvc.ReqSetStateSwitch");
      this.allowCmdSet.add("NeighborSvc.ReqGetSwitches");
      this.allowCmdSet.add("NeighborSvc.ReqGetPoint");
      this.allowCmdSet.add("NearbyGroup.ReqGetAreaList");
      this.allowCmdSet.add("NearbyGroup.ReqGetGroupInArea");
      this.allowCmdSet.add("OidbSvc.0x568_20");
      this.allowCmdSet.add("LbsShareSvr.location");
      this.allowCmdSet.add("LbsShareSvr.nearby_shops");
      this.allowCmdSet.add("LbsShareSvr.get_shops_by_ids");
      this.allowCmdSet.add("OidbSvc.0x9c0_0");
      this.allowCmdSet.add("OidbSvc.0x9c1_0");
      this.allowCmdSet.add("OidbSvc.0x7f5_1");
    }
    return !this.allowCmdSet.contains(paramString);
  }
  
  protected Class<? extends alkr> observerClass()
  {
    return alqy.class;
  }
  
  public void onReceive(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    boolean bool2 = true;
    if (msgCmdFilter(paramFromServiceMsg.getServiceCmd())) {
      if (QLog.isColorLevel()) {
        QLog.d("msgCmdFilter", 2, "cmdfilter error=" + paramFromServiceMsg.getServiceCmd());
      }
    }
    label683:
    label727:
    label734:
    do
    {
      return;
      checkReportErrorToMM(paramFromServiceMsg);
      if ("LBS.AddressService".equals(paramFromServiceMsg.getServiceCmd()))
      {
        paramFromServiceMsg = (RspGetPositionApi)paramObject;
        paramToServiceMsg = paramToServiceMsg.extraData.getByteArray("devicedata");
        if (paramFromServiceMsg != null)
        {
          notifyUI(1, true, new Object[] { paramToServiceMsg, String.valueOf(paramFromServiceMsg.stUsrLoc.iLat / 1000000.0D), String.valueOf(paramFromServiceMsg.stUsrLoc.iLon / 1000000.0D), paramFromServiceMsg.strCity.trim() + paramFromServiceMsg.strDistrict.trim() + paramFromServiceMsg.strRoad.trim() });
          return;
        }
        notifyUI(1, false, paramToServiceMsg);
        return;
      }
      if ("EncounterSvc.ReqGetEntrance".equals(paramFromServiceMsg.getServiceCmd()))
      {
        b(paramFromServiceMsg, paramToServiceMsg, paramObject);
        return;
      }
      int i;
      boolean bool1;
      if ("NearbyGroup.GetGroupList".equals(paramFromServiceMsg.getServiceCmd()))
      {
        bool2 = paramToServiceMsg.extraData.getBoolean("first");
        i = paramToServiceMsg.extraData.getInt("iFilterId");
        if (paramObject != null) {}
        for (bool1 = true;; bool1 = false)
        {
          notifyUI(8, bool1, new Object[] { Integer.valueOf(i), Boolean.valueOf(bool2), paramObject });
          return;
        }
      }
      if ("NearbyGroup.ReqGetAreaList".equals(paramFromServiceMsg.getServiceCmd()))
      {
        bool2 = paramToServiceMsg.extraData.getBoolean("clickable");
        if (paramObject != null) {}
        for (bool1 = true;; bool1 = false)
        {
          notifyUI(12, bool1, new Object[] { Boolean.valueOf(bool2), paramObject });
          return;
        }
      }
      if ("NearbyGroup.ReqGetGroupInArea".equals(paramFromServiceMsg.getServiceCmd()))
      {
        if (paramObject != null) {}
        for (bool1 = true;; bool1 = false)
        {
          notifyUI(13, bool1, new Object[] { paramObject });
          return;
        }
      }
      if ("OidbSvc.0x568_20".equals(paramFromServiceMsg.getServiceCmd()))
      {
        int j;
        long l;
        if ((paramFromServiceMsg.isSuccess()) && (paramObject != null))
        {
          j = 1;
          l = paramToServiceMsg.extraData.getLong("key_troopuin", 0L);
          bool1 = paramToServiceMsg.extraData.getBoolean("key_show");
          i = j;
          if (j == 0) {}
        }
        for (;;)
        {
          try
          {
            paramToServiceMsg = new oidb_sso.OIDBSSOPkg();
            paramToServiceMsg.mergeFrom((byte[])paramObject);
            i = paramToServiceMsg.uint32_result.get();
            if (i != 0) {
              continue;
            }
            i = 1;
          }
          catch (Exception paramToServiceMsg)
          {
            i = 0;
            continue;
            notifyUI(14, false, null);
            return;
          }
          if (i == 0) {
            continue;
          }
          notifyUI(14, true, new Object[] { Long.valueOf(l), Boolean.valueOf(bool1) });
          return;
          j = 0;
          break;
          i = 0;
        }
      }
      if ("NeighborSvc.ReqSetStateSwitch".equals(paramFromServiceMsg.getServiceCmd()))
      {
        bool1 = paramToServiceMsg.extraData.getBoolean("k_be_share", false);
        if ((paramObject == null) || (((RespSetStateSwitch)paramObject).stHeader.eReplyCode != 0))
        {
          bool1 = this.app.n();
          bool2 = false;
        }
        for (;;)
        {
          notifyUI(9, bool2, Boolean.valueOf(bool1));
          return;
          this.app.b(bool1, true);
        }
      }
      if ("NeighborSvc.ReqGetSwitches".equals(paramFromServiceMsg.getServiceCmd()))
      {
        if ((paramObject != null) && (((RespGetSwitches)paramObject).stHeader.eReplyCode == 0))
        {
          paramToServiceMsg = ((RespGetSwitches)paramObject).switches.iterator();
          if (paramToServiceMsg.hasNext())
          {
            paramFromServiceMsg = (Switch)paramToServiceMsg.next();
            if (paramFromServiceMsg.type != 64) {
              break label787;
            }
            paramObject = this.app;
            if (paramFromServiceMsg.is_open != 1) {
              break label781;
            }
            bool1 = true;
            paramObject.b(bool1, true);
            i = paramFromServiceMsg.type;
            if (paramFromServiceMsg.is_open != 1) {
              break label830;
            }
          }
          for (bool1 = true;; bool1 = false)
          {
            notifyUI(10, true, new Object[] { Integer.valueOf(i), Boolean.valueOf(bool1) });
            break label683;
            break;
            bool1 = false;
            break label727;
            if (paramFromServiceMsg.type != 1) {
              break label734;
            }
            paramObject = this.app.getAccount();
            if (paramFromServiceMsg.is_open == 1) {}
            for (bool1 = true;; bool1 = false)
            {
              aush.b(paramObject, bool1);
              break;
            }
          }
        }
        notifyUI(10, false, null);
        return;
      }
      if ("NeighborSvc.ReqGetPoint".equals(paramFromServiceMsg.getServiceCmd()))
      {
        if (paramToServiceMsg.extraData.getBoolean("req_street_view")) {}
        for (i = 11;; i = 18)
        {
          alsw.a(this, i, paramToServiceMsg, paramFromServiceMsg, paramObject);
          return;
        }
      }
      if ("LbsShareSvr.location".equals(paramFromServiceMsg.getServiceCmd()))
      {
        if (paramObject != null)
        {
          notifyUI(15, true, new Object[] { paramToServiceMsg, paramObject });
          return;
        }
        notifyUI(15, false, null);
        return;
      }
      if ("LbsShareSvr.nearby_shops".equals(paramFromServiceMsg.getServiceCmd()))
      {
        if (paramObject != null)
        {
          notifyUI(16, true, new Object[] { paramToServiceMsg, paramObject });
          return;
        }
        notifyUI(16, false, null);
        return;
      }
      if ("LbsShareSvr.get_shops_by_ids".equals(paramFromServiceMsg.getServiceCmd()))
      {
        if (paramObject != null)
        {
          notifyUI(17, true, new Object[] { paramToServiceMsg, paramObject });
          return;
        }
        notifyUI(17, false, null);
        return;
      }
      if ("OidbSvc.0x9c0_0".equals(paramFromServiceMsg.getServiceCmd()))
      {
        a(paramToServiceMsg, paramFromServiceMsg, paramObject);
        return;
      }
      if ("OidbSvc.0x9c1_0".equals(paramFromServiceMsg.getServiceCmd()))
      {
        b(paramToServiceMsg, paramFromServiceMsg, paramObject);
        return;
      }
      if ("NeighborRecommender.ReqGetRecommender".equals(paramFromServiceMsg.getServiceCmd()))
      {
        c(paramFromServiceMsg, paramToServiceMsg, paramObject);
        return;
      }
    } while (!"OidbSvc.0x7f5_1".equals(paramFromServiceMsg.getServiceCmd()));
    label781:
    label787:
    label830:
    a(paramFromServiceMsg, paramToServiceMsg, paramObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     alqx
 * JD-Core Version:    0.7.0.1
 */