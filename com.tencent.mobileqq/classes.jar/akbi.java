import EncounterSvc.ReqGetEncounterV2;
import EncounterSvc.RespGetEncounterV2;
import EncounterSvc.UserData;
import NearbyPubAcct.ReqGetNearbyPubAcctInfo;
import NeighborComm.LocalInfoType;
import NeighborComm.RespHeader;
import NeighborComm.SOSO_Cell;
import NeighborComm.SOSO_Wifi;
import NeighborSvc.ReqGetPoint;
import NeighborSvc.RespGetPoint;
import NeighborSvc.UserDetailLocalInfo;
import QQService.ReqFavorite;
import QQService.ReqHead;
import QQService.RespFavorite;
import QQService.RespHead;
import android.os.Bundle;
import android.os.RemoteException;
import android.text.TextUtils;
import appoint.define.appoint_define.InterestTag;
import appoint.define.appoint_define.LocaleInfo;
import com.qq.jce.wup.UniPacket;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.soso.SosoInterface;
import com.tencent.mobileqq.app.soso.SosoInterface.SosoCell;
import com.tencent.mobileqq.app.soso.SosoInterface.SosoLbsInfo;
import com.tencent.mobileqq.app.soso.SosoInterface.SosoLocation;
import com.tencent.mobileqq.app.soso.SosoInterface.SosoWifi;
import com.tencent.mobileqq.dating.DatingFilters;
import com.tencent.mobileqq.nearby.NearbyAppInterface;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.IBaseActionListener;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import tencent.im.oidb.cmd0x5fb.ReqInfo;
import tencent.im.oidb.cmd0x682.ChatInfo;
import tencent.im.oidb.cmd0x682.ReqBody;
import tencent.im.oidb.cmd0x682.RspBody;
import tencent.im.oidb.cmd0x686.Oidb_0x686.CharmEvent;
import tencent.im.oidb.cmd0x686.Oidb_0x686.NearbyCharmNotify;
import tencent.im.oidb.cmd0x686.Oidb_0x686.NearbyFeedConfig;
import tencent.im.oidb.cmd0x686.Oidb_0x686.NearbyRankConfig;
import tencent.im.oidb.cmd0x686.Oidb_0x686.RspBody;
import tencent.im.oidb.cmd0x9c7.cmd0x9c7.ReqBody;
import tencent.im.oidb.cmd0x9c7.cmd0x9c7.RspBody;
import tencent.im.oidb.oidb_sso.OIDBSSOPkg;

public class akbi
{
  public static int a(ToServiceMsg paramToServiceMsg)
  {
    int j = 0;
    int i = j;
    if (paramToServiceMsg != null)
    {
      int k = paramToServiceMsg.extraData.getByte("neighbor_interest_id");
      long l = paramToServiceMsg.extraData.getLong("neighbor_sub_interest_id");
      i = j;
      if (k != 0)
      {
        i = j;
        if (l != 0L) {
          i = 1;
        }
      }
    }
    return i;
  }
  
  private static NearbyPubAcct.LBSInfo a(NearbyGroup.LBSInfo paramLBSInfo)
  {
    Object localObject1 = null;
    if (paramLBSInfo != null)
    {
      localObject1 = new NearbyPubAcct.GPS(paramLBSInfo.stGps.iLat, paramLBSInfo.stGps.iLon, paramLBSInfo.stGps.iAlt, paramLBSInfo.stGps.eType);
      NearbyPubAcct.Attr localAttr = new NearbyPubAcct.Attr(paramLBSInfo.stAttr.strImei, paramLBSInfo.stAttr.strImsi, paramLBSInfo.stAttr.strPhonenum);
      ArrayList localArrayList = new ArrayList();
      Object localObject2 = paramLBSInfo.vWifis.iterator();
      Object localObject3;
      while (((Iterator)localObject2).hasNext())
      {
        localObject3 = (NearbyGroup.Wifi)((Iterator)localObject2).next();
        localArrayList.add(new NearbyPubAcct.Wifi(((NearbyGroup.Wifi)localObject3).lMac, ((NearbyGroup.Wifi)localObject3).shRssi));
      }
      localObject2 = new ArrayList();
      paramLBSInfo = paramLBSInfo.vCells.iterator();
      while (paramLBSInfo.hasNext())
      {
        localObject3 = (NearbyGroup.Cell)paramLBSInfo.next();
        ((ArrayList)localObject2).add(new NearbyPubAcct.Cell(((NearbyGroup.Cell)localObject3).shMcc, ((NearbyGroup.Cell)localObject3).shMnc, ((NearbyGroup.Cell)localObject3).iLac, ((NearbyGroup.Cell)localObject3).iCellId, ((NearbyGroup.Cell)localObject3).shRssi));
      }
      localObject1 = new NearbyPubAcct.LBSInfo((NearbyPubAcct.GPS)localObject1, localArrayList, (ArrayList)localObject2, localAttr);
    }
    return localObject1;
  }
  
  public static Object a(AppInterface paramAppInterface, FromServiceMsg paramFromServiceMsg, ToServiceMsg paramToServiceMsg, xop paramxop)
  {
    RespHeader localRespHeader = (RespHeader)a(paramFromServiceMsg.getWupBuffer(), "RespHeader", new RespHeader());
    UserData localUserData;
    boolean bool;
    int i;
    if (localRespHeader != null)
    {
      arzw.a("LBS", "CMD_GET_ENCOUNTER eReplyCode:" + localRespHeader.eReplyCode);
      localUserData = null;
      bool = false;
      if (localRespHeader == null) {
        break label488;
      }
      i = localRespHeader.eReplyCode;
      if ((i != 0) && (i != 300)) {
        break label416;
      }
      paramFromServiceMsg = (RespGetEncounterV2)a(paramFromServiceMsg.getWupBuffer(), "RespGetEncounterV2", new RespGetEncounterV2());
      if (paramFromServiceMsg == null) {
        break label497;
      }
      localUserData = paramFromServiceMsg.stUserData;
      i = a(paramToServiceMsg);
      if (!(paramxop instanceof awzt)) {
        break label385;
      }
      ((awzt)paramxop).a[i] = localUserData;
      label140:
      if (atbp.b())
      {
        if (localUserData != null) {
          break label407;
        }
        paramAppInterface = "user data is null";
        label154:
        atbp.a("NearbyCmdHelper", new Object[] { "decodeGetEncounter", Integer.valueOf(i), paramAppInterface });
      }
      if (localUserData != null)
      {
        anmd.a(paramToServiceMsg.extraData.getString("account"), localUserData.iLon, localUserData.iLat, localUserData.lTime);
        if (QLog.isColorLevel()) {
          QLog.d("NearbyCmdHelper", 2, "respone stUserData.lTime=" + localUserData.lTime + " iLat=" + localUserData.iLat + " iLon" + localUserData.iLon + " lOriginGrid=" + localUserData.lOriginGrid + " lNextGrid=" + localUserData.lNextGrid + " strProvince=" + localUserData.strProvince + " strCookie" + localUserData.strCookie);
        }
      }
      bool = true;
      paramAppInterface = paramFromServiceMsg;
    }
    for (;;)
    {
      return new Object[] { localRespHeader, paramAppInterface, Boolean.valueOf(bool) };
      arzw.a("LBS", "CMD_GET_ENCOUNTER eReplyCode:" + null);
      break;
      label385:
      if (!(paramxop instanceof awzr)) {
        break label140;
      }
      ((awzr)paramxop).a[i] = localUserData;
      break label140;
      label407:
      paramAppInterface = localUserData.strProvince;
      break label154;
      label416:
      if (QLog.isColorLevel()) {
        QLog.d("NearbyCmdHelper", 2, "cmd = " + paramFromServiceMsg.getServiceCmd() + " ReplyCode = " + i + ",strResult=" + localRespHeader.strResult);
      }
      akbm.a(paramAppInterface, i);
      paramAppInterface = localUserData;
      continue;
      label488:
      akbm.a(paramAppInterface, -1111);
      return null;
      label497:
      bool = true;
      paramAppInterface = paramFromServiceMsg;
    }
  }
  
  public static Object a(xop paramxop, FromServiceMsg paramFromServiceMsg, ToServiceMsg paramToServiceMsg)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.nearby", 2, "LBSService --> decodeGetPointInfo(), isSuccess: " + paramFromServiceMsg.isSuccess());
    }
    if (paramFromServiceMsg.isSuccess())
    {
      paramxop = (RespGetPoint)paramxop.a(paramFromServiceMsg.getWupBuffer(), "RespGetPoint", new RespGetPoint());
      if (paramxop != null)
      {
        if (QLog.isColorLevel()) {
          QLog.d("Q.nearby", 2, "LBSService --> decodeGetPointInfo(), url: " + new String(paramxop.stUDLinfo.SOSOUrl) + " , cityId = " + paramxop.stUDLinfo.cityId);
        }
        return paramxop;
      }
    }
    return null;
  }
  
  public static final <T> T a(byte[] paramArrayOfByte, String paramString, T paramT)
  {
    UniPacket localUniPacket = new UniPacket(true);
    try
    {
      localUniPacket.setEncodeName("utf-8");
      localUniPacket.decode(paramArrayOfByte);
      return localUniPacket.getByClass(paramString, paramT);
    }
    catch (Exception paramArrayOfByte)
    {
      return null;
    }
    catch (RuntimeException paramArrayOfByte) {}
    return null;
  }
  
  public static void a(ajtd paramajtd, byte paramByte)
  {
    try
    {
      long l = Long.parseLong(paramajtd.getCurrentAccountUin());
      Object localObject = new byte[13];
      bbmj.a((byte[])localObject, 0, l);
      localObject[4] = 0;
      bbmj.a((byte[])localObject, 5, (short)1);
      bbmj.a((byte[])localObject, 7, 40493);
      bbmj.a((byte[])localObject, 9, (short)2);
      bbmj.a((byte[])localObject, 11, (short)paramByte);
      localObject = paramajtd.makeOIDBPkg("OidbSvc.0x4ff_9", 1279, 9, (byte[])localObject);
      ((ToServiceMsg)localObject).extraData.putByte("session_switch_value", paramByte);
      ((ToServiceMsg)localObject).extraData.putBoolean("reqFromDatingHandler", true);
      paramajtd.sendPbReq((ToServiceMsg)localObject);
      anmg.a("send_oidb_0x4ff_9", new Object[] { Byte.valueOf(paramByte) });
      return;
    }
    catch (Exception paramajtd)
    {
      while (!QLog.isColorLevel()) {}
      QLog.w("Q.dating", 2, "send_oidb_0x4ff_9 error", paramajtd);
    }
  }
  
  public static void a(ajtd paramajtd, int paramInt, ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    ByteBuffer localByteBuffer = null;
    boolean bool1 = paramToServiceMsg.extraData.getBoolean("req_street_view");
    boolean bool2 = paramToServiceMsg.extraData.getBoolean("req_current_loc");
    if ((paramObject != null) && (paramFromServiceMsg.isSuccess()))
    {
      paramFromServiceMsg = (RespGetPoint)paramObject;
      paramObject = paramFromServiceMsg.stUDLinfo;
      if (bool1) {
        if ((paramObject != null) && (paramObject.SOSOUrl.length > 0)) {
          paramajtd.notifyUI(paramInt, true, paramObject.SOSOUrl);
        }
      }
    }
    do
    {
      do
      {
        return;
      } while (!bool2);
      paramToServiceMsg = localByteBuffer;
      if (paramObject.cityId != null)
      {
        paramToServiceMsg = localByteBuffer;
        if (paramObject.cityId.length == 16)
        {
          localByteBuffer = ByteBuffer.wrap(paramObject.cityId);
          paramToServiceMsg = new String[4];
          paramToServiceMsg[0] = ajty.a(localByteBuffer.getInt());
          paramToServiceMsg[1] = ajty.a(localByteBuffer.getInt());
          paramToServiceMsg[2] = ajty.a(localByteBuffer.getInt());
          paramToServiceMsg[3] = "0";
        }
      }
      paramajtd.notifyUI(paramInt, true, new Object[] { "", paramObject.strProvince, paramObject.strCity, paramObject.strDistrict, paramObject.strTown, "", paramObject.strRoad, "", Integer.valueOf(paramFromServiceMsg.stGps.iLat), Integer.valueOf(paramFromServiceMsg.stGps.iLon), Integer.valueOf(paramFromServiceMsg.stGps.iAlt), paramToServiceMsg });
      return;
      if (bool1)
      {
        paramajtd.notifyUI(paramInt, false, null);
        return;
      }
    } while (!bool2);
    paramajtd.notifyUI(paramInt, false, null);
  }
  
  public static void a(ajtd paramajtd, int paramInt1, List<atfk> paramList, int paramInt2, int paramInt3)
  {
    if (paramList == null)
    {
      c(paramajtd, paramInt1, null, null, null);
      return;
    }
    cmd0x9c7.ReqBody localReqBody = new cmd0x9c7.ReqBody();
    localReqBody.uint32_set_mode.set(paramInt2);
    localReqBody.uint32_test_mode.set(paramInt3);
    paramInt1 = 0;
    while (paramInt1 < paramList.size())
    {
      atfk localatfk = (atfk)paramList.get(paramInt1);
      if (localatfk != null) {
        localReqBody.rpt_msg_tags.add(localatfk.a());
      }
      paramInt1 += 1;
    }
    paramList = paramajtd.makeOIDBPkg("OidbSvc.0x9c7_0", 2503, 0, localReqBody.toByteArray());
    paramList.extraData.putInt("set_mode", paramInt2);
    paramList.extraData.putInt("test_mode", paramInt3);
    paramajtd.sendPbReq(paramList);
  }
  
  public static void a(ajtd paramajtd, long paramLong, int paramInt, byte[] paramArrayOfByte)
  {
    Object localObject = new cmd0x682.ReqBody();
    ((cmd0x682.ReqBody)localObject).rpt_uint64_touinlist.add(Long.valueOf(paramLong));
    localObject = paramajtd.makeOIDBPkg("OidbSvc.0x682", 1666, 0, ((cmd0x682.ReqBody)localObject).toByteArray());
    ((ToServiceMsg)localObject).extraData.putByteArray("showlove_chat_sig", paramArrayOfByte);
    paramajtd.sendPbReq((ToServiceMsg)localObject);
    a(paramajtd.mApp, paramInt);
    anmg.c("getShowLove", new Object[] { "from type " + paramInt });
  }
  
  public static void a(ajtd paramajtd, boolean paramBoolean1, boolean paramBoolean2, int paramInt1, int paramInt2)
  {
    if ((!paramBoolean1) && (!paramBoolean2)) {
      return;
    }
    ToServiceMsg localToServiceMsg = new ToServiceMsg("mobileqq.service", paramajtd.getCurrentAccountUin(), "NeighborSvc.ReqGetPoint");
    if ((paramInt1 != 0) && (paramInt2 != 0))
    {
      localToServiceMsg.extraData.putInt("lat", paramInt1);
      localToServiceMsg.extraData.putInt("lon", paramInt2);
    }
    if (paramBoolean1) {
      localToServiceMsg.extraData.putBoolean("req_street_view", true);
    }
    for (;;)
    {
      paramajtd.send(localToServiceMsg);
      return;
      localToServiceMsg.extraData.putBoolean("req_current_loc", true);
    }
  }
  
  private static void a(AppInterface paramAppInterface, int paramInt)
  {
    String str = "";
    if ((paramInt & 0x4) == 4)
    {
      str = "0X8005283";
      paramAppInterface.reportClickEvent("CliOper", "", "", str, str, 0, 0, "", "", "", "");
      anmg.c("getShowLove", new Object[] { "report value ", str });
      str = "";
      if ((paramInt & 0x1) != 1) {
        break label184;
      }
      str = "0X8005288";
    }
    for (;;)
    {
      if (!TextUtils.isEmpty(str))
      {
        paramAppInterface.reportClickEvent("CliOper", "", "", str, str, 0, 0, "", "", "", "");
        anmg.c("getShowLove", new Object[] { "report value2 ", str });
      }
      return;
      if ((paramInt & 0x8) == 8)
      {
        str = "0X8005284";
        break;
      }
      if ((paramInt & 0x10) == 16)
      {
        str = "0X8005285";
        break;
      }
      if ((paramInt & 0x20) != 32) {
        break;
      }
      str = "0X8005281";
      break;
      label184:
      if ((paramInt & 0x2) == 2) {
        str = "0X8005289";
      }
    }
  }
  
  public static void a(FromServiceMsg paramFromServiceMsg, ToServiceMsg paramToServiceMsg)
  {
    paramToServiceMsg = (RespFavorite)a(paramFromServiceMsg.getWupBuffer(), "RespFavorite", new RespFavorite());
    paramFromServiceMsg.getAttributes().put("result", paramToServiceMsg);
    switch (paramToServiceMsg.stHeader.iReplyCode)
    {
    default: 
      paramFromServiceMsg.setMsgFail();
      return;
    }
    paramFromServiceMsg.setMsgSuccess();
  }
  
  public static boolean a(AppInterface paramAppInterface, ToServiceMsg paramToServiceMsg, UniPacket paramUniPacket, xop paramxop)
  {
    if (QLog.isColorLevel()) {
      QLog.d("NearbyCmdHelper", 2, "handleGetEncounter start...");
    }
    if (paramToServiceMsg.extraData.getBoolean("isCheckInReq", false)) {
      return b(paramAppInterface, paramToServiceMsg, paramUniPacket, paramxop);
    }
    int i = a(paramToServiceMsg);
    if ((paramxop instanceof awzt)) {
      paramxop = ((awzt)paramxop).a[i];
    }
    label155:
    label1454:
    for (;;)
    {
      Object localObject1;
      label75:
      int m;
      int n;
      int j;
      boolean bool1;
      boolean bool3;
      NeighborComm.ReqHeader localReqHeader;
      EncounterSvc.ReqUserInfo localReqUserInfo1;
      label319:
      EncounterSvc.ReqUserInfo localReqUserInfo2;
      int k;
      boolean bool2;
      if (atbp.b())
      {
        if (paramxop == null)
        {
          localObject1 = "user data is null";
          atbp.a("NearbyCmdHelper", new Object[] { "handleGetEncounter", Integer.valueOf(i), localObject1 });
        }
      }
      else
      {
        m = paramToServiceMsg.extraData.getInt("lat");
        n = paramToServiceMsg.extraData.getInt("lon");
        j = paramToServiceMsg.extraData.getInt("roamMode");
        if ((m == 0) || (n == 0)) {
          break label613;
        }
        localObject1 = null;
        bool1 = true;
        if ((localObject1 == null) && (!bool1)) {
          break label1784;
        }
        bool3 = paramToServiceMsg.extraData.getBoolean("first");
        localReqHeader = new NeighborComm.ReqHeader();
        localReqHeader.shVersion = 3;
        localReqHeader.lMID = xop.a(Long.parseLong(paramToServiceMsg.getUin()));
        localReqHeader.iAppID = AppSetting.a();
        localReqHeader.eBusiType = 0;
        localReqHeader.eMqqSysType = 2;
        localReqUserInfo1 = new EncounterSvc.ReqUserInfo();
        localReqUserInfo1.strAuthName = "B1_QQ_Neighbor_android";
        localReqUserInfo1.strAuthPassword = "NzVK_qGE";
        localReqUserInfo1.eListType = 0;
        if (!bool1) {
          break label658;
        }
        localReqUserInfo1.vCells = new ArrayList(1);
        localReqUserInfo1.vMacs = new ArrayList(1);
        localReqUserInfo1.eLocalInfo = LocalInfoType.LocalInfoType_Decode.value();
        localReqUserInfo1.stGps = new EncounterSvc.GPS(m, n, 0, 1);
        localReqUserInfo2 = new EncounterSvc.ReqUserInfo();
        i = paramToServiceMsg.extraData.getInt("localLat");
        k = paramToServiceMsg.extraData.getInt("localLon");
        if ((i != 0) && (k != 0))
        {
          localReqUserInfo2.vCells = new ArrayList(1);
          localReqUserInfo2.vMacs = new ArrayList(1);
          localReqUserInfo2.eLocalInfo = LocalInfoType.LocalInfoType_Decode.value();
          localReqUserInfo2.stGps = new EncounterSvc.GPS(i, k, 0, 1);
        }
        if ((paramxop != null) && (!bool3)) {
          break label1919;
        }
        if (QLog.isColorLevel())
        {
          localObject2 = new StringBuilder().append("temp==ull:");
          if (paramxop != null) {
            break label946;
          }
          bool2 = true;
          label454:
          QLog.i("NearbyCmdHelper", 2, bool2 + " first:" + bool3);
        }
      }
      label613:
      label1777:
      label1784:
      label1919:
      for (Object localObject2 = new UserData();; localObject2 = paramxop)
      {
        k = paramToServiceMsg.extraData.getInt("gender");
        Object localObject5 = paramToServiceMsg.extraData.getLongArray("tags");
        Object localObject4 = null;
        Object localObject3 = localObject4;
        if (localObject5 != null)
        {
          localObject3 = localObject4;
          if (localObject5.length > 0)
          {
            localObject4 = new ArrayList();
            i = 0;
            for (;;)
            {
              localObject3 = localObject4;
              if (i >= localObject5.length) {
                break;
              }
              ((ArrayList)localObject4).add(Long.valueOf(localObject5[i]));
              i += 1;
            }
            if (!(paramxop instanceof awzr)) {
              break label1925;
            }
            paramxop = ((awzr)paramxop).a[i];
            break;
            localObject1 = paramxop.strProvince;
            break label75;
            l1 = System.currentTimeMillis();
            SosoInterface.a(60000L, "NearbyProtocolCoder.Encounter");
            localObject1 = SosoInterface.a();
            l2 = System.currentTimeMillis();
            paramToServiceMsg.extraData.putLong("lbsTime", l2 - l1);
            bool1 = false;
            break label155;
            localReqUserInfo1.eLocalInfo = LocalInfoType.LocalInfoType_SOSO.value();
            localReqUserInfo1.stGps = new EncounterSvc.GPS((int)(((SosoInterface.SosoLbsInfo)localObject1).jdField_a_of_type_ComTencentMobileqqAppSosoSosoInterface$SosoLocation.c * 1000000.0D), (int)(((SosoInterface.SosoLbsInfo)localObject1).jdField_a_of_type_ComTencentMobileqqAppSosoSosoInterface$SosoLocation.d * 1000000.0D), -1, 0);
            if (QLog.isColorLevel()) {
              QLog.i("NearbyCmdHelper", 2, "mLat_84=" + ((SosoInterface.SosoLbsInfo)localObject1).jdField_a_of_type_ComTencentMobileqqAppSosoSosoInterface$SosoLocation.c + ",mLon_84" + ((SosoInterface.SosoLbsInfo)localObject1).jdField_a_of_type_ComTencentMobileqqAppSosoSosoInterface$SosoLocation.d);
            }
            localReqUserInfo1.vSOSOCells = new ArrayList();
            if (((SosoInterface.SosoLbsInfo)localObject1).jdField_a_of_type_JavaUtilArrayList != null)
            {
              localObject2 = ((SosoInterface.SosoLbsInfo)localObject1).jdField_a_of_type_JavaUtilArrayList.iterator();
              while (((Iterator)localObject2).hasNext())
              {
                localObject3 = (SosoInterface.SosoCell)((Iterator)localObject2).next();
                localReqUserInfo1.vSOSOCells.add(new SOSO_Cell((short)((SosoInterface.SosoCell)localObject3).jdField_a_of_type_Int, (short)((SosoInterface.SosoCell)localObject3).jdField_b_of_type_Int, ((SosoInterface.SosoCell)localObject3).c, ((SosoInterface.SosoCell)localObject3).d, (short)((SosoInterface.SosoCell)localObject3).e));
              }
            }
            localReqUserInfo1.vSOSOMac = new ArrayList();
            if (((SosoInterface.SosoLbsInfo)localObject1).b == null) {
              break label319;
            }
            localObject2 = ((SosoInterface.SosoLbsInfo)localObject1).b.iterator();
            while (((Iterator)localObject2).hasNext())
            {
              localObject3 = (SosoInterface.SosoWifi)((Iterator)localObject2).next();
              localReqUserInfo1.vSOSOMac.add(new SOSO_Wifi(((SosoInterface.SosoWifi)localObject3).jdField_a_of_type_Long, (short)((SosoInterface.SosoWifi)localObject3).jdField_a_of_type_Int));
            }
            break label319;
            bool2 = false;
            break label454;
          }
        }
        localObject4 = a(m, n, bool3);
        byte b1 = paramToServiceMsg.extraData.getByte("constellation");
        byte b2 = paramToServiceMsg.extraData.getByte("neighbor_interest_id");
        m = paramToServiceMsg.extraData.getInt("timeInterval");
        byte b3 = paramToServiceMsg.extraData.getByte("ageLow");
        byte b4 = paramToServiceMsg.extraData.getByte("ageUp");
        n = paramToServiceMsg.extraData.getInt("careerID");
        int i1 = paramToServiceMsg.extraData.getInt("hometownCountry");
        int i2 = paramToServiceMsg.extraData.getInt("hometownProvince");
        int i3 = paramToServiceMsg.extraData.getInt("hometownCity");
        localObject5 = paramToServiceMsg.extraData.getString("adExtra");
        long l1 = paramToServiceMsg.extraData.getLong("adCtrl");
        byte b5 = paramToServiceMsg.extraData.getByte("rankListNum");
        int i4 = paramToServiceMsg.extraData.getInt("neighbor_list_source");
        long l2 = paramToServiceMsg.extraData.getLong("neighbor_sub_interest_id");
        if ((QLog.isColorLevel()) && (paramxop != null)) {
          QLog.d("NearbyCmdHelper", 2, "request stUserData.lTime=" + paramxop.lTime + " iLat=" + paramxop.iLat + " iLon" + paramxop.iLon + " lOriginGrid=" + paramxop.lOriginGrid + " lNextGrid=" + paramxop.lNextGrid + " strProvince=" + paramxop.strProvince + " strCookie" + paramxop.strCookie);
        }
        if (atbp.b()) {
          atbp.a("NearbyCmdHelper", "handleGetEncounter interest", new Object[] { Byte.valueOf(b2), Long.valueOf(l2) });
        }
        paramToServiceMsg = (DatingFilters)paramToServiceMsg.extraData.getParcelable("datingFilter");
        paramxop = new cmd0x5fb.ReqInfo();
        if (paramToServiceMsg != null)
        {
          paramxop.uint32_time.set(paramToServiceMsg.jdField_b_of_type_Int);
          paramxop.uint32_subject.set(paramToServiceMsg.d);
          paramxop.uint32_gender.set(paramToServiceMsg.jdField_a_of_type_Int);
          paramxop.uint32_age_low.set(DatingFilters.jdField_b_of_type_ArrayOfInt[paramToServiceMsg.e]);
          paramxop.uint32_age_up.set(DatingFilters.jdField_a_of_type_ArrayOfInt[paramToServiceMsg.e]);
          PBUInt32Field localPBUInt32Field = paramxop.uint32_profession;
          if (paramToServiceMsg.f >= 0) {
            break label1687;
          }
          i = 0;
          localPBUInt32Field.set(i);
          paramxop.bytes_cookie.set(ByteStringMicro.copyFrom(new byte[0]));
          if ((paramToServiceMsg.jdField_a_of_type_AppointDefineAppoint_define$LocaleInfo != null) && (paramToServiceMsg.d == 5)) {
            paramxop.msg_destination.set(paramToServiceMsg.jdField_a_of_type_AppointDefineAppoint_define$LocaleInfo);
          }
        }
        if (((Boolean)atbg.a(paramAppInterface.getAccount(), "is_nearby_novice", Boolean.valueOf(false))).booleanValue())
        {
          i = 1;
          if (QLog.isColorLevel()) {
            QLog.i("NearbyCmdHelper", 2, "handleGetEncounter isNearbyNovice: " + i);
          }
          if (!bool1) {
            break label1702;
          }
          paramToServiceMsg = new ReqGetEncounterV2(localReqUserInfo1, (UserData)localObject2, k, -1, (ArrayList)localObject3, new byte[1], (byte)j, 2000, -1, 0, null, (byte[])localObject4, 0, (byte)1, b1, b3, b4, m, n, i2, i3, (byte)1, i1, localReqUserInfo2, 15, paramxop.toByteArray(), (byte)0, (byte)0, b2, (String)localObject5, l1, 0L, b5, i, i4, l2);
          paramUniPacket.setEncodeName("utf-8");
          paramUniPacket.setServantName("EncounterObj");
          paramUniPacket.setFuncName("CMD_GET_ENCOUNTERV2");
          paramUniPacket.put("ReqHeader", localReqHeader);
          paramUniPacket.put("ReqGetEncounterV2", paramToServiceMsg);
          paramUniPacket = new HashMap();
          if (localObject1 == null) {
            break label1777;
          }
        }
        for (paramToServiceMsg = "lbs is not null";; paramToServiceMsg = "isUseGps is true")
        {
          paramUniPacket.put("param_reason", paramToServiceMsg);
          paramUniPacket.put("param_NetType", bbev.a(null) + "");
          axrl.a(BaseApplicationImpl.getContext()).a(paramAppInterface.getCurrentAccountUin(), "GET_ENCOUNTER_LOCATION", true, 0L, 0L, paramUniPacket, "");
          return true;
          i = paramToServiceMsg.f;
          break;
          i = 0;
          break label1454;
          paramToServiceMsg = new ReqGetEncounterV2(localReqUserInfo1, (UserData)localObject2, k, -1, (ArrayList)localObject3, new byte[1], (byte)0, 2000, -1, 0, null, (byte[])localObject4, 0, (byte)1, b1, b3, b4, m, n, i2, i3, (byte)1, i1, null, 15, paramxop.toByteArray(), (byte)0, (byte)0, b2, (String)localObject5, l1, 0L, b5, i, i4, l2);
          break label1567;
        }
        if (QLog.isColorLevel()) {
          QLog.d("NearbyCmdHelper", 2, "handleGetEncounter lbsInfo=" + localObject1 + ", isUseGps=" + bool1);
        }
        if (localObject1 == null) {
          paramToServiceMsg.extraData.putBoolean("isLbsInfoNull", true);
        }
        paramToServiceMsg = new HashMap();
        paramToServiceMsg.put("param_reason", "all is null");
        paramToServiceMsg.put("param_NetType", bbev.a(null) + "");
        axrl.a(BaseApplicationImpl.getContext()).a(paramAppInterface.getCurrentAccountUin(), "GET_ENCOUNTER_LOCATION", false, 0L, 0L, paramToServiceMsg, "");
        return false;
      }
      label946:
      paramxop = null;
    }
  }
  
  public static boolean a(ToServiceMsg paramToServiceMsg, UniPacket paramUniPacket)
  {
    long l1 = paramToServiceMsg.extraData.getLong("selfUin");
    long l2 = paramToServiceMsg.extraData.getLong("targetUin");
    Object localObject = paramToServiceMsg.extraData.getByteArray("vCookies");
    int i = paramToServiceMsg.extraData.getInt("favoriteSource");
    int j = paramToServiceMsg.extraData.getInt("iCount");
    localObject = new ReqFavorite(new ReqHead(l1, (short)1, paramUniPacket.getRequestId(), (byte)1, (byte)0, (byte[])localObject), l2, 0, i, j);
    paramUniPacket.setServantName("VisitorSvc");
    paramUniPacket.setFuncName("ReqFavorite");
    paramUniPacket.put("ReqFavorite", localObject);
    paramToServiceMsg.setTimeout(10000L);
    paramToServiceMsg.setServiceCmd("VisitorSvc.ReqFavorite");
    return true;
  }
  
  public static boolean a(xop paramxop, ToServiceMsg paramToServiceMsg, UniPacket paramUniPacket)
  {
    boolean bool1 = false;
    int j = 0;
    boolean bool2 = paramToServiceMsg.extraData.getBoolean("req_street_view");
    boolean bool3 = paramToServiceMsg.extraData.getBoolean("req_current_loc");
    int i = paramToServiceMsg.extraData.getInt("lat");
    int k = paramToServiceMsg.extraData.getInt("lon");
    if (((bool2) && (i != 0) && (k != 0)) || (bool3))
    {
      paramxop = new NeighborSvc.ReqHeader();
      paramxop.shVersion = 2;
      paramxop.lMID = xop.a(Long.parseLong(paramToServiceMsg.getUin()));
      paramxop.iAppID = AppSetting.a();
      paramxop.eBusiType = 0;
      paramxop.eMqqSysType = 2;
      Object localObject1 = new NeighborSvc.ReqUserInfo();
      ((NeighborSvc.ReqUserInfo)localObject1).strAuthName = "B1_QQ_Neighbor_android";
      ((NeighborSvc.ReqUserInfo)localObject1).strAuthPassword = "NzVK_qGE";
      ((NeighborSvc.ReqUserInfo)localObject1).eListType = 0;
      if (bool2)
      {
        ((NeighborSvc.ReqUserInfo)localObject1).vCells = new ArrayList(1);
        ((NeighborSvc.ReqUserInfo)localObject1).vMacs = new ArrayList(1);
        ((NeighborSvc.ReqUserInfo)localObject1).stGps = new NeighborSvc.GPS(i, k, 0, 1);
        ((NeighborSvc.ReqUserInfo)localObject1).eLocalInfo = LocalInfoType.LocalInfoType_Decode.value();
        if (!bool2) {
          break label467;
        }
      }
      label297:
      label467:
      for (i = 1;; i = 0) {
        for (;;)
        {
          byte b = (byte)i;
          i = j;
          if (bool3) {
            i = 1;
          }
          localObject1 = new ReqGetPoint((NeighborSvc.ReqUserInfo)localObject1, b, (byte)i);
          paramUniPacket.setServantName("NeighborObj");
          paramUniPacket.setFuncName("CMD_GET_POINT");
          paramUniPacket.put("ReqHeader", paramxop);
          paramUniPacket.put("ReqGetPoint", localObject1);
          paramToServiceMsg.setTimeout(30000L);
          paramToServiceMsg.setServiceCmd("NeighborSvc.ReqGetPoint");
          bool1 = true;
          return bool1;
          if ((bool3 == true) && (i != 0) && (k != 0))
          {
            ((NeighborSvc.ReqUserInfo)localObject1).vCells = new ArrayList(1);
            ((NeighborSvc.ReqUserInfo)localObject1).vMacs = new ArrayList(1);
            ((NeighborSvc.ReqUserInfo)localObject1).stGps = new NeighborSvc.GPS(i, k, 0, 1);
            break;
          }
          akug.a(new akbj("LBSService.Point", paramToServiceMsg));
          try
          {
            paramToServiceMsg.wait();
            Object localObject2 = asyx.a(true, akug.a("LBSService.Point"));
            if (localObject2 == null) {
              break label297;
            }
            if (((NearbyGroup.LBSInfo)localObject2).stGps == null) {
              break;
            }
            localObject2 = ((NearbyGroup.LBSInfo)localObject2).stGps;
            ((NeighborSvc.ReqUserInfo)localObject1).stGps = new NeighborSvc.GPS(((NearbyGroup.GPS)localObject2).iLat, ((NearbyGroup.GPS)localObject2).iLon, ((NearbyGroup.GPS)localObject2).iAlt, ((NearbyGroup.GPS)localObject2).eType);
            break;
          }
          catch (InterruptedException localInterruptedException)
          {
            for (;;)
            {
              localInterruptedException.printStackTrace();
            }
          }
          finally {}
        }
      }
    }
    paramxop = new FromServiceMsg(paramToServiceMsg.getUin(), paramToServiceMsg.getServiceCmd());
    paramxop.setMsgFail();
    try
    {
      paramToServiceMsg.actionListener.onActionResult(paramxop);
      return false;
    }
    catch (RemoteException paramxop) {}
    return false;
  }
  
  private static byte[] a(int paramInt1, int paramInt2, boolean paramBoolean)
  {
    Object localObject = null;
    if (paramBoolean)
    {
      if ((paramInt1 == 0) || (paramInt2 == 0)) {
        break label100;
      }
      localObject = new NearbyPubAcct.LBSInfo();
      ((NearbyPubAcct.LBSInfo)localObject).stGps = new NearbyPubAcct.GPS(paramInt1, paramInt2, 0, 1);
    }
    for (;;)
    {
      localObject = new ReqGetNearbyPubAcctInfo((short)2, new byte[0], 2, (NearbyPubAcct.LBSInfo)localObject);
      UniPacket localUniPacket = new UniPacket(true);
      localUniPacket.setRequestId(1);
      localUniPacket.setServantName("PubAccountSvc.nearby_pubacct");
      localUniPacket.setFuncName("nearby_pubacct");
      localUniPacket.put("nearby_pubacct", localObject);
      localObject = localUniPacket.encode();
      return localObject;
      label100:
      localObject = a(asyx.a());
    }
  }
  
  public static void b(ajtd paramajtd, int paramInt, ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    boolean bool2 = false;
    int i = -1;
    try
    {
      paramFromServiceMsg = new oidb_sso.OIDBSSOPkg();
      paramFromServiceMsg.mergeFrom((byte[])paramObject);
      boolean bool1 = bool2;
      int j;
      if (paramFromServiceMsg != null)
      {
        j = paramFromServiceMsg.uint32_result.get();
        i = j;
        bool1 = bool2;
        if (j == 0)
        {
          bool1 = true;
          i = j;
        }
      }
      if (QLog.isColorLevel()) {
        QLog.d("Q.nearby", 2, "rspNearbyCharmEvent,result code：" + i + ",isSuccess:" + bool1);
      }
      if (bool1)
      {
        Oidb_0x686.RspBody localRspBody = new Oidb_0x686.RspBody();
        i = paramFromServiceMsg.uint32_service_type.get();
        localRspBody.mergeFrom(paramFromServiceMsg.bytes_bodybuffer.get().toByteArray());
        if (localRspBody.uint32_config_seq.has())
        {
          j = localRspBody.uint32_config_seq.get();
          atbg.a(paramajtd.mApp.getAccount(), "toplist_hide_boygod_seq", Integer.valueOf(j));
        }
        if (localRspBody.uint32_config_time.has())
        {
          j = localRspBody.uint32_config_time.get();
          atbg.a(paramajtd.mApp.getAccount(), "key_last_config_time", Integer.valueOf(j));
        }
        paramFromServiceMsg = null;
        paramObject = null;
        Object localObject3 = null;
        Object localObject4 = null;
        if (localRspBody.msg_rank_config.has()) {
          paramFromServiceMsg = (Oidb_0x686.NearbyRankConfig)localRspBody.msg_rank_config.get();
        }
        if (localRspBody.msg_feed_config.has()) {
          paramObject = (Oidb_0x686.NearbyFeedConfig)localRspBody.msg_feed_config.get();
        }
        Object localObject1;
        Object localObject2;
        if ((i == 2) && (localRspBody.msg_charm_event.has()))
        {
          localObject1 = (Oidb_0x686.CharmEvent)localRspBody.msg_charm_event.get();
          localObject2 = localObject4;
          if (!(paramajtd.mApp instanceof NearbyAppInterface)) {
            break label600;
          }
        }
        int k;
        int m;
        int n;
        int i1;
        for (;;)
        {
          if ((localObject1 == null) || (((Oidb_0x686.CharmEvent)localObject1).uint32_pop_flag.get() != 1)) {
            break label637;
          }
          i = ((Oidb_0x686.CharmEvent)localObject1).uint32_old_charm.get();
          j = ((Oidb_0x686.CharmEvent)localObject1).uint32_old_charm_level.get();
          k = ((Oidb_0x686.CharmEvent)localObject1).uint32_new_charm.get();
          m = ((Oidb_0x686.CharmEvent)localObject1).uint32_new_charm_level.get();
          n = ((Oidb_0x686.CharmEvent)localObject1).uint32_cur_level_threshold.get();
          i1 = ((Oidb_0x686.CharmEvent)localObject1).uint32_next_level_threshold.get();
          paramFromServiceMsg = ((Oidb_0x686.CharmEvent)localObject1).str_tips_content.get();
          paramToServiceMsg = paramFromServiceMsg;
          if (paramFromServiceMsg == null) {
            paramToServiceMsg = "";
          }
          paramajtd.notifyUI(paramInt, true, new Object[] { Boolean.valueOf(false), Integer.valueOf(i), Integer.valueOf(j), Integer.valueOf(k), Integer.valueOf(m), Integer.valueOf(n), Integer.valueOf(i1), paramToServiceMsg });
          paramToServiceMsg = "0X80052B1";
          if (k - i < 0) {
            paramToServiceMsg = "0X80052B2";
          }
          paramajtd.mApp.reportClickEvent("CliOper", "", "", paramToServiceMsg, paramToServiceMsg, 0, 0, "", "", "", "");
          return;
          localObject1 = localObject3;
          localObject2 = localObject4;
          if (i != 1) {
            break;
          }
          localObject1 = localObject3;
          localObject2 = localObject4;
          if (!localRspBody.msg_notify_event.has()) {
            break;
          }
          localObject2 = (Oidb_0x686.NearbyCharmNotify)localRspBody.msg_notify_event.get();
          localObject1 = localObject3;
          break;
          label600:
          if ((paramajtd.mApp instanceof QQAppInterface)) {
            ((QQAppInterface)paramajtd.mApp).a().a(paramToServiceMsg.getUin(), paramFromServiceMsg, paramObject, (Oidb_0x686.CharmEvent)localObject1, (Oidb_0x686.NearbyCharmNotify)localObject2);
          }
        }
        label637:
        if ((localObject2 != null) && (((Oidb_0x686.NearbyCharmNotify)localObject2).uint32_pop_flag.get() == 1))
        {
          i = ((Oidb_0x686.NearbyCharmNotify)localObject2).uint32_old_charm.get();
          j = ((Oidb_0x686.NearbyCharmNotify)localObject2).uint32_old_charm_level.get();
          k = ((Oidb_0x686.NearbyCharmNotify)localObject2).uint32_new_charm.get();
          m = ((Oidb_0x686.NearbyCharmNotify)localObject2).uint32_new_charm_level.get();
          n = ((Oidb_0x686.NearbyCharmNotify)localObject2).uint32_cur_level_threshold.get();
          i1 = ((Oidb_0x686.NearbyCharmNotify)localObject2).uint32_next_level_threshold.get();
          int i2 = ((Oidb_0x686.NearbyCharmNotify)localObject2).uint32_old_prof_percent.get();
          int i3 = ((Oidb_0x686.NearbyCharmNotify)localObject2).uint32_new_prof_percent.get();
          paramFromServiceMsg = ((Oidb_0x686.NearbyCharmNotify)localObject2).str_tips_content.get();
          paramToServiceMsg = paramFromServiceMsg;
          if (paramFromServiceMsg == null) {
            paramToServiceMsg = "";
          }
          paramajtd.notifyUI(paramInt, true, new Object[] { Integer.valueOf(i), Integer.valueOf(j), Integer.valueOf(k), Integer.valueOf(m), Integer.valueOf(n), Integer.valueOf(i1), Integer.valueOf(i2), Integer.valueOf(i3), paramToServiceMsg });
          paramToServiceMsg = "0X80052AE";
          if (k - i < 0) {
            paramToServiceMsg = "0X80052AF";
          }
          paramajtd.mApp.reportClickEvent("CliOper", "", "", paramToServiceMsg, paramToServiceMsg, 0, 0, "", "", "", "");
        }
      }
      return;
    }
    catch (Exception paramajtd) {}
  }
  
  protected static boolean b(AppInterface paramAppInterface, ToServiceMsg paramToServiceMsg, UniPacket paramUniPacket, xop paramxop)
  {
    int i = paramToServiceMsg.extraData.getInt("localLat");
    int j = paramToServiceMsg.extraData.getInt("localLon");
    if (QLog.isColorLevel()) {
      QLog.d("Q.hotChatDistance", 2, "NearbyCmdHelper.handleCheckIn,  lat=" + i + ", lon=" + j);
    }
    if ((i != 0) && (j != 0))
    {
      paramAppInterface = new NeighborComm.ReqHeader();
      paramAppInterface.shVersion = 3;
      paramAppInterface.lMID = xop.a(Long.parseLong(paramToServiceMsg.getUin()));
      paramAppInterface.iAppID = AppSetting.a();
      paramAppInterface.eBusiType = 0;
      paramAppInterface.eMqqSysType = 2;
      paramToServiceMsg = new EncounterSvc.ReqUserInfo();
      paramToServiceMsg.strAuthName = "B1_QQ_Neighbor_android";
      paramToServiceMsg.strAuthPassword = "NzVK_qGE";
      paramToServiceMsg.eListType = 0;
      paramToServiceMsg.vCells = new ArrayList(1);
      paramToServiceMsg.vMacs = new ArrayList(1);
      paramToServiceMsg.eLocalInfo = LocalInfoType.LocalInfoType_Decode.value();
      paramToServiceMsg.stGps = new EncounterSvc.GPS(i, j, 0, 1);
      paramxop = new ReqGetEncounterV2();
      paramxop.stUserData = new UserData();
      paramxop.stUserInfo = paramToServiceMsg;
      paramxop.eNewListType = 100;
      paramxop.neighbor_list_source = 4;
      paramUniPacket.setEncodeName("utf-8");
      paramUniPacket.setServantName("EncounterObj");
      paramUniPacket.setFuncName("CMD_GET_ENCOUNTERV2");
      paramUniPacket.put("ReqHeader", paramAppInterface);
      paramUniPacket.put("ReqGetEncounterV2", paramxop);
      return true;
    }
    return false;
  }
  
  public static void c(ajtd paramajtd, int paramInt, ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if ((paramToServiceMsg == null) || (paramFromServiceMsg == null))
    {
      paramajtd.notifyUI(paramInt, false, new Object[] { "", null, ajyc.a(2131707119), Integer.valueOf(-1), Integer.valueOf(-1) });
      return;
    }
    int i;
    int j;
    label72:
    cmd0x9c7.RspBody localRspBody;
    int m;
    if (paramToServiceMsg.extraData == null)
    {
      i = -1;
      if (paramToServiceMsg.extraData != null) {
        break label227;
      }
      j = -1;
      localRspBody = new cmd0x9c7.RspBody();
      m = ajtd.parseOIDBPkg(paramFromServiceMsg, paramObject, localRspBody);
      if (m != 0) {
        break label472;
      }
      if (!localRspBody.str_test_result_url.has()) {
        break label242;
      }
      paramToServiceMsg = localRspBody.str_test_result_url.get();
      label116:
      if (!localRspBody.rpt_msg_tags.has()) {
        break label249;
      }
    }
    label227:
    label242:
    label249:
    for (paramFromServiceMsg = localRspBody.rpt_msg_tags.get();; paramFromServiceMsg = null)
    {
      paramObject = new ArrayList();
      if ((paramFromServiceMsg == null) || (paramFromServiceMsg.size() <= 0)) {
        break label254;
      }
      int k = 0;
      while (k < paramFromServiceMsg.size())
      {
        atfk localatfk = atfk.a((appoint_define.InterestTag)paramFromServiceMsg.get(k));
        if (localatfk != null) {
          paramObject.add(localatfk);
        }
        k += 1;
      }
      i = paramToServiceMsg.extraData.getInt("set_mode");
      break;
      j = paramToServiceMsg.extraData.getInt("test_mode");
      break label72;
      paramToServiceMsg = "";
      break label116;
    }
    label254:
    if (paramObject.size() <= 0)
    {
      paramajtd.notifyUI(4, false, new Object[] { "", null, ajyc.a(2131707120), Integer.valueOf(i), Integer.valueOf(j) });
      atbp.a("Q.nearby_people_card.", "handle_oidb_0x9c7_0", new Object[] { Integer.valueOf(m), Boolean.valueOf(true), null, paramToServiceMsg });
      return;
    }
    if ((paramajtd.mApp instanceof NearbyAppInterface)) {
      ((NearbyAppInterface)paramajtd.mApp).a().a(localRspBody);
    }
    for (;;)
    {
      paramajtd.notifyUI(paramInt, true, new Object[] { paramToServiceMsg, paramObject, "", Integer.valueOf(i), Integer.valueOf(j) });
      atbp.a("Q.nearby_people_card.", "handle_oidb_0x9c7_0", new Object[] { Integer.valueOf(m), Boolean.valueOf(true), paramObject, paramToServiceMsg });
      return;
      if (paramajtd.app != null) {
        paramajtd.app.a().a(localRspBody);
      }
    }
    label472:
    if (localRspBody.str_error.has()) {}
    for (paramToServiceMsg = localRspBody.str_error.get();; paramToServiceMsg = "")
    {
      paramajtd.notifyUI(paramInt, false, new Object[] { "", null, paramToServiceMsg, Integer.valueOf(i), Integer.valueOf(j) });
      return;
    }
  }
  
  public static void d(ajtd paramajtd, int paramInt, ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    boolean bool2 = true;
    boolean bool1;
    if ((paramFromServiceMsg != null) && (paramFromServiceMsg.getResultCode() == 1000))
    {
      paramObject = new oidb_sso.OIDBSSOPkg();
      try
      {
        paramFromServiceMsg = (oidb_sso.OIDBSSOPkg)paramObject.mergeFrom(paramFromServiceMsg.getWupBuffer());
        if ((paramFromServiceMsg != null) && (paramFromServiceMsg.uint32_result.has()))
        {
          int i = paramFromServiceMsg.uint32_result.get();
          if (QLog.isColorLevel()) {
            QLog.i("Q.dating", 2, "handle_oidb_0x4ff_9 ret=" + i);
          }
          if ((i == 0) && (paramFromServiceMsg.bytes_bodybuffer.has()) && (paramFromServiceMsg.bytes_bodybuffer.get() != null))
          {
            paramFromServiceMsg = paramFromServiceMsg.bytes_bodybuffer.get().toByteArray();
            if (4 <= paramFromServiceMsg.length)
            {
              paramFromServiceMsg = String.valueOf(bbmj.a(paramFromServiceMsg, 0));
              if ((paramFromServiceMsg == null) || (!paramFromServiceMsg.equals(paramajtd.getCurrentAccountUin())))
              {
                if (QLog.isColorLevel()) {
                  QLog.w("Q.dating", 2, "handle_oidb_0x4ff_9 uin error");
                }
                return;
              }
            }
          }
        }
      }
      catch (InvalidProtocolBufferMicroException paramFromServiceMsg)
      {
        for (;;)
        {
          paramFromServiceMsg.printStackTrace();
          paramFromServiceMsg = paramObject;
        }
        bool1 = true;
      }
    }
    for (;;)
    {
      if ((paramajtd.mApp instanceof QQAppInterface)) {
        if (paramInt == 7)
        {
          paramInt = paramToServiceMsg.extraData.getByte("session_switch_value", (byte)0).byteValue();
          if (bool1)
          {
            paramToServiceMsg = ((QQAppInterface)paramajtd.mApp).a();
            if (paramInt != 0) {
              break label294;
            }
            paramToServiceMsg.a(bool2);
          }
          paramajtd.notifyUI(7, bool1, null);
        }
      }
      for (;;)
      {
        if (!QLog.isColorLevel()) {
          break label364;
        }
        QLog.d("Q.dating", 2, "handle_oidb_0x4ff_9, isSuccess:" + bool1);
        return;
        label294:
        bool2 = false;
        break;
        if ((paramajtd.mApp instanceof NearbyAppInterface))
        {
          paramFromServiceMsg = (NearbyAppInterface)paramajtd.mApp;
          if (paramInt == 10)
          {
            byte b = paramToServiceMsg.extraData.getByte("session_switch_value", (byte)0).byteValue();
            if (bool1) {
              paramFromServiceMsg.a().a(b);
            }
            paramajtd.notifyUI(10, bool1, null);
          }
        }
      }
      label364:
      break;
      bool1 = true;
      continue;
      bool1 = false;
    }
  }
  
  public static void e(ajtd paramajtd, int paramInt, ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    cmd0x682.RspBody localRspBody = new cmd0x682.RspBody();
    int i = ajtd.parseOIDBPkg(paramFromServiceMsg, paramObject, localRspBody);
    anmg.a("getShowLove", new Object[] { "handleGetShowLoveLimit result = " + i });
    int n;
    if ((i == 0) && (localRspBody.rpt_msg_chatinfo.has()) && (localRspBody.rpt_msg_chatinfo.size() > 0))
    {
      paramObject = (cmd0x682.ChatInfo)localRspBody.rpt_msg_chatinfo.get(0);
      long l = paramObject.uint64_touin.get();
      paramInt = paramObject.uint32_chatflag.get();
      int j = paramObject.uint32_goldflag.get();
      int k = paramObject.uint32_totalexpcount.get();
      int m = paramObject.uint32_curexpcount.get();
      n = paramObject.uint32_totalFlag.get();
      int i1 = paramObject.uint32_curdayFlag.get();
      paramFromServiceMsg = paramObject.express_tips_msg.get().toStringUtf8();
      paramObject = paramObject.express_msg.get().toStringUtf8();
      boolean bool1 = false;
      boolean bool3 = false;
      paramToServiceMsg = paramToServiceMsg.extraData.getByteArray("showlove_chat_sig");
      if (((paramInt & 0x2) == 2) || (j == 2)) {
        bool1 = true;
      }
      boolean bool2 = bool3;
      if (j == 1)
      {
        bool2 = bool3;
        if (n == 0)
        {
          bool2 = bool3;
          if (i1 == 0) {
            bool2 = true;
          }
        }
      }
      if ((paramajtd instanceof atbx)) {
        paramajtd.notifyUI(9, true, new Object[] { Long.valueOf(l), Boolean.valueOf(bool1), Boolean.valueOf(bool2), paramToServiceMsg, paramFromServiceMsg, paramObject });
      }
      if (QLog.isColorLevel()) {
        QLog.d("DatingSayHello", 2, "toUin:" + l + ",chatFlag:" + paramInt + ",godFlag:" + j + ",totalCount:" + k + ",curCount" + m + ",totalFlag:" + n + ",curdayFlag:" + i1 + ",canChat:" + bool1 + ",canShowLove:" + bool2 + ",wordStr:" + paramFromServiceMsg + "showloveStr: " + paramObject);
      }
      if (i1 == 1) {
        paramajtd.mApp.reportClickEvent("CliOper", "", "", "0X8005290", "0X8005290", 0, 0, "", "", "", "");
      }
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.nearby_bank", 2, "handleGetShowLoveLimit,result：" + i);
      }
      return;
      if (n == 1)
      {
        paramajtd.mApp.reportClickEvent("CliOper", "", "", "0X8005291", "0X8005291", 0, 0, "", "", "", "");
        continue;
        paramajtd.notifyUI(paramInt, false, null);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     akbi
 * JD-Core Version:    0.7.0.1
 */