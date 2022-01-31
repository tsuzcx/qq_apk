import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.HotChatHandler.2;
import com.tencent.mobileqq.app.HotChatManager;
import com.tencent.mobileqq.app.HotChatManager.HotChatStateWrapper;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.soso.SosoInterface;
import com.tencent.mobileqq.app.soso.SosoInterface.SosoCell;
import com.tencent.mobileqq.app.soso.SosoInterface.SosoLbsInfo;
import com.tencent.mobileqq.app.soso.SosoInterface.SosoLocation;
import com.tencent.mobileqq.app.soso.SosoInterface.SosoWifi;
import com.tencent.mobileqq.data.HotChatInfo;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.PrintStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import tencent.im.oidb.cmd0x62c.oidb_cmd0x62c.ReqBody;
import tencent.im.oidb.cmd0x88d.oidb_0x88d.GroupInfo;
import tencent.im.oidb.cmd0x88d.oidb_0x88d.ReqBody;
import tencent.im.oidb.cmd0x88d.oidb_0x88d.ReqGroupInfo;
import tencent.im.oidb.cmd0x88d.oidb_0x88d.RspBody;
import tencent.im.oidb.cmd0x88d.oidb_0x88d.RspGroupInfo;
import tencent.im.oidb.cmd0x897.cmd0x897.RspBody;
import tencent.im.oidb.cmd0x89a.oidb_0x89a.ReqBody;
import tencent.im.oidb.cmd0x89a.oidb_0x89a.RspBody;
import tencent.im.oidb.cmd0x89a.oidb_0x89a.groupinfo;
import tencent.im.oidb.cmd0x89b.oidb_0x89b.ExitPublicGroupReqBody;
import tencent.im.oidb.cmd0x89b.oidb_0x89b.KickPublicGroupVisitorReqBody;
import tencent.im.oidb.cmd0x89b.oidb_0x89b.ReqBody;
import tencent.im.oidb.cmd0x89b.oidb_0x89b.RspBody;
import tencent.im.oidb.cmd0x8a7.cmd0x8a7.RspBody;
import tencent.im.oidb.cmd0x8b2.oidb_0x8b2.ReqBody;
import tencent.im.oidb.cmd0x8b2.oidb_0x8b2.RspBody;
import tencent.im.oidb.cmd0x8b3.oidb_0x8b3.ReqBody;
import tencent.im.oidb.cmd0x8b3.oidb_0x8b3.groupinfo;
import tencent.im.oidb.cmd0xa81.oidb_0xa81.RspBody;
import tencent.im.oidb.hotchat.Common.WifiPOIInfo;
import tencent.im.oidb.hotchat.CreateHotChat.ReqBody;
import tencent.im.oidb.hotchat.CreateHotChat.RspBody;
import tencent.im.oidb.hotchat.GetJoinedHotChatList.ReqBody;
import tencent.im.oidb.hotchat.GetJoinedHotChatList.RspBody;
import tencent.im.oidb.hotchat.LBS.Attribute;
import tencent.im.oidb.hotchat.LBS.Cell;
import tencent.im.oidb.hotchat.LBS.GPS;
import tencent.im.oidb.hotchat.LBS.LBSInfo;
import tencent.im.oidb.hotchat.LBS.Wifi;
import tencent.im.oidb.hotchat.oidb_0x81f.GetAuthDataReq;
import tencent.im.oidb.hotchat.oidb_0x81f.ReqBody;
import tencent.im.oidb.hotchat.oidb_0x823.KickPublicGroupVisitorReqBody;
import tencent.im.oidb.hotchat.oidb_0x823.KickPublicGroupVisitorRspBody;
import tencent.im.oidb.hotchat.oidb_0x823.PlayerDeviceInfo;
import tencent.im.oidb.hotchat.oidb_0x823.ReqBody;
import tencent.im.oidb.hotchat.oidb_0x823.RspBody;
import tencent.im.oidb.hotchat.oidb_0x8ab.ReqBody;
import tencent.im.oidb.hotchat.oidb_0x8ab.RspBody;
import tencent.im.oidb.oidb_sso.OIDBSSOPkg;

public class aluj
  extends alpd
{
  public static final String a;
  public static final String b = alud.a(2131705952);
  public static final String c = alud.a(2131705951);
  private volatile boolean a;
  
  static
  {
    jdField_a_of_type_JavaLangString = alud.a(2131705943);
  }
  
  public aluj(QQAppInterface paramQQAppInterface)
  {
    super(paramQQAppInterface);
  }
  
  public static LBS.LBSInfo a(boolean paramBoolean)
  {
    LBS.LBSInfo localLBSInfo = new LBS.LBSInfo();
    SosoInterface.a(3600000L, aluj.class.getSimpleName());
    Object localObject1 = SosoInterface.a();
    if ((localObject1 == null) || (((SosoInterface.SosoLbsInfo)localObject1).jdField_a_of_type_ComTencentMobileqqAppSosoSosoInterface$SosoLocation == null)) {
      return null;
    }
    Object localObject2 = new LBS.GPS();
    ((LBS.GPS)localObject2).latitude.set((int)(((SosoInterface.SosoLbsInfo)localObject1).jdField_a_of_type_ComTencentMobileqqAppSosoSosoInterface$SosoLocation.c * 1000000.0D));
    ((LBS.GPS)localObject2).longitude.set((int)(((SosoInterface.SosoLbsInfo)localObject1).jdField_a_of_type_ComTencentMobileqqAppSosoSosoInterface$SosoLocation.d * 1000000.0D));
    ((LBS.GPS)localObject2).altitude.set(-1);
    ((LBS.GPS)localObject2).coordinate.set(0);
    localLBSInfo.gps.set((MessageMicro)localObject2);
    Object localObject3;
    if (((SosoInterface.SosoLbsInfo)localObject1).b != null)
    {
      localObject2 = ((SosoInterface.SosoLbsInfo)localObject1).b.iterator();
      while (((Iterator)localObject2).hasNext())
      {
        localObject3 = (SosoInterface.SosoWifi)((Iterator)localObject2).next();
        LBS.Wifi localWifi = new LBS.Wifi();
        localWifi.mac.set(((SosoInterface.SosoWifi)localObject3).jdField_a_of_type_Long);
        localWifi.rssi.set(((SosoInterface.SosoWifi)localObject3).jdField_a_of_type_Int);
        localLBSInfo.rpt_wifi.add(localWifi);
      }
    }
    if (((SosoInterface.SosoLbsInfo)localObject1).jdField_a_of_type_JavaUtilArrayList != null)
    {
      localObject1 = ((SosoInterface.SosoLbsInfo)localObject1).jdField_a_of_type_JavaUtilArrayList.iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (SosoInterface.SosoCell)((Iterator)localObject1).next();
        localObject3 = new LBS.Cell();
        ((LBS.Cell)localObject3).mcc.set(((SosoInterface.SosoCell)localObject2).jdField_a_of_type_Int);
        ((LBS.Cell)localObject3).mnc.set(((SosoInterface.SosoCell)localObject2).b);
        ((LBS.Cell)localObject3).lac.set(((SosoInterface.SosoCell)localObject2).c);
        ((LBS.Cell)localObject3).cellid.set(((SosoInterface.SosoCell)localObject2).d);
        ((LBS.Cell)localObject3).rssi.set(((SosoInterface.SosoCell)localObject2).e);
        localLBSInfo.rpt_cell.add((MessageMicro)localObject3);
      }
    }
    localObject1 = new LBS.Attribute();
    localObject2 = bdgk.a();
    if (!TextUtils.isEmpty((CharSequence)localObject2)) {
      ((LBS.Attribute)localObject1).imei.set(ByteStringMicro.copyFrom(((String)localObject2).getBytes()));
    }
    localObject2 = bdgk.b();
    if (!TextUtils.isEmpty((CharSequence)localObject2)) {
      ((LBS.Attribute)localObject1).imsi.set(ByteStringMicro.copyFrom(((String)localObject2).getBytes()));
    }
    localLBSInfo.attribute.set((MessageMicro)localObject1);
    return localLBSInfo;
  }
  
  public static LBS.Wifi a()
  {
    Object localObject1 = (WifiManager)BaseApplication.getContext().getSystemService("wifi");
    if (!((WifiManager)localObject1).isWifiEnabled()) {
      return null;
    }
    Object localObject2 = ((WifiManager)localObject1).getConnectionInfo();
    localObject1 = HotChatManager.a((WifiInfo)localObject2);
    long l = SosoInterface.SosoWifi.a(((WifiInfo)localObject2).getBSSID());
    int i = ((WifiInfo)localObject2).getRssi();
    localObject2 = new LBS.Wifi();
    ((LBS.Wifi)localObject2).rssi.set(i);
    ((LBS.Wifi)localObject2).essid.set(ByteStringMicro.copyFrom(((String)localObject1).getBytes()));
    ((LBS.Wifi)localObject2).mac.set(l);
    return localObject2;
  }
  
  private void a(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg)
  {
    String str = paramFromServiceMsg.getServiceCmd();
    if (QLog.isColorLevel()) {
      QLog.d("HotChatHandler", 2, "<<---handleError serviceCmd:" + str);
    }
    if ("OidbSvc.0x8a4".equals(str)) {
      a(paramToServiceMsg, paramFromServiceMsg, false);
    }
    do
    {
      do
      {
        do
        {
          int i;
          do
          {
            do
            {
              do
              {
                do
                {
                  return;
                  if (!"OidbSvc.0x89b_3".equals(str)) {
                    break;
                  }
                  if (paramToServiceMsg.extraData.getBoolean("kick", false))
                  {
                    j(paramToServiceMsg, paramFromServiceMsg);
                    return;
                  }
                } while (paramToServiceMsg.extraData.getBoolean("isJoin"));
                c(paramToServiceMsg, paramFromServiceMsg);
                return;
              } while ("OidbSvc.0x823_0".equals(str));
              if ("OidbSvc.0x8a2".equals(str))
              {
                d(paramToServiceMsg, paramFromServiceMsg);
                return;
              }
              if ("OidbSvc.0x8ab".equals(str))
              {
                e(paramToServiceMsg, paramFromServiceMsg);
                return;
              }
              if ("OidbSvc.0x8b3".equals(str))
              {
                f(paramToServiceMsg, paramFromServiceMsg);
                return;
              }
              if (!"OidbSvc.0x8b2".equals(str)) {
                break;
              }
            } while ((paramToServiceMsg == null) || (paramToServiceMsg.extraData == null));
            i = paramToServiceMsg.extraData.getInt("serviceType");
            if (QLog.isColorLevel()) {
              QLog.d("HotChatHandlerQ.hotchat.oidb_0x8b2", 2, "handleError, cmd:" + str + "|serviceType:" + i);
            }
          } while (i != 2);
          g(paramToServiceMsg, paramFromServiceMsg);
          return;
          if ("OidbSvc.0xa81".equals(str))
          {
            k(paramToServiceMsg, paramFromServiceMsg);
            return;
          }
          if ("OidbSvc.0x88d_0".equals(str))
          {
            h(paramToServiceMsg, paramFromServiceMsg);
            return;
          }
          if ("OidbSvc.0x89a_0".equals(str))
          {
            i(paramToServiceMsg, paramFromServiceMsg);
            return;
          }
        } while ("OidbSvc.0xa8b".equals(str));
        if ("OidbSvc.0x897_0".equals(str))
        {
          o(paramToServiceMsg, paramFromServiceMsg, null);
          return;
        }
        if ("OidbSvc.0x88d_1".equals(str))
        {
          n(paramToServiceMsg, paramFromServiceMsg, null);
          return;
        }
      } while ("OidbSvc.0x8a3_7".equals(str));
      if ("OidbSvc.0x8a7_0".equals(str))
      {
        q(paramToServiceMsg, paramFromServiceMsg, null);
        return;
      }
    } while (!"OidbSvc.0x62c_4".equals(str));
    a(paramToServiceMsg, paramFromServiceMsg, null);
  }
  
  private void a(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, boolean paramBoolean)
  {
    this.jdField_a_of_type_Boolean = false;
    if (QLog.isColorLevel()) {
      QLog.i("HotChatHandler", 2, "handleGetMyHostChatListRespError timeOut: " + paramBoolean);
    }
    notifyUI(1031, false, null);
    if (paramBoolean) {
      ((HotChatManager)this.app.getManager(60)).a(null, false);
    }
  }
  
  private void a(Common.WifiPOIInfo paramWifiPOIInfo, boolean paramBoolean, int paramInt)
  {
    int i = 2;
    int j = 0;
    if (QLog.isColorLevel()) {
      auwz.a("HotChatHandler", new Object[] { "createHotChat", Boolean.valueOf(paramBoolean), Integer.valueOf(paramInt), paramWifiPOIInfo });
    }
    if (paramWifiPOIInfo == null) {
      return;
    }
    Object localObject = paramWifiPOIInfo.uint32_wifi_poi_type;
    if (paramBoolean) {
      i = 1;
    }
    ((PBUInt32Field)localObject).set(i);
    localObject = HotChatInfo.createHotChat(paramWifiPOIInfo, paramBoolean, paramInt);
    CreateHotChat.ReqBody localReqBody = new CreateHotChat.ReqBody();
    localReqBody.create_req_info.setHasFlag(true);
    localReqBody.create_req_info.set(paramWifiPOIInfo);
    paramInt = j;
    if (paramBoolean)
    {
      paramWifiPOIInfo = a(true);
      if (paramWifiPOIInfo != null) {
        localReqBody.lbs_info.set(paramWifiPOIInfo);
      }
      paramInt = 1;
    }
    paramWifiPOIInfo = makeOIDBPkg("OidbSvc.0x8a2", 2210, paramInt, localReqBody.toByteArray(), 10000L);
    paramWifiPOIInfo.extraData.putSerializable("HOT_CHAT_INFO", (Serializable)localObject);
    sendPbReq(paramWifiPOIInfo);
  }
  
  private void b(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg)
  {
    String str = paramFromServiceMsg.getServiceCmd();
    if (QLog.isColorLevel()) {
      QLog.d("HotChatHandler", 2, "<<---handleTimeOut serviceCmd:" + str);
    }
    if ("OidbSvc.0x8a4".equals(str)) {
      a(paramToServiceMsg, paramFromServiceMsg, true);
    }
    do
    {
      do
      {
        int i;
        do
        {
          do
          {
            do
            {
              do
              {
                return;
                if (!"OidbSvc.0x89b_3".equals(str)) {
                  break;
                }
                if (paramToServiceMsg.extraData.getBoolean("kick", false))
                {
                  j(paramToServiceMsg, paramFromServiceMsg);
                  return;
                }
              } while (paramToServiceMsg.extraData.getBoolean("isJoin"));
              c(paramToServiceMsg, paramFromServiceMsg);
              return;
            } while ("OidbSvc.0x823_0".equals(str));
            if ("OidbSvc.0x8a2".equals(str))
            {
              d(paramToServiceMsg, paramFromServiceMsg);
              return;
            }
            if ("OidbSvc.0x8ab".equals(str))
            {
              e(paramToServiceMsg, paramFromServiceMsg);
              return;
            }
            if ("OidbSvc.0x8b3".equals(str))
            {
              f(paramToServiceMsg, paramFromServiceMsg);
              return;
            }
            if (!"OidbSvc.0x8b2".equals(str)) {
              break;
            }
          } while ((paramToServiceMsg == null) || (paramToServiceMsg.extraData == null));
          i = paramToServiceMsg.extraData.getInt("serviceType");
          if (QLog.isColorLevel()) {
            QLog.d("HotChatHandlerQ.hotchat.oidb_0x8b2", 2, "handleTimeOut, cmd:" + str + "|serviceType:" + i);
          }
        } while (i != 2);
        g(paramToServiceMsg, paramFromServiceMsg);
        return;
        if ("OidbSvc.0xa81".equals(str))
        {
          k(paramToServiceMsg, paramFromServiceMsg);
          return;
        }
        if ("OidbSvc.0x88d_0".equals(str))
        {
          h(paramToServiceMsg, paramFromServiceMsg);
          return;
        }
        if ("OidbSvc.0x89a_0".equals(str))
        {
          i(paramToServiceMsg, paramFromServiceMsg);
          return;
        }
      } while ("OidbSvc.0xa8b".equals(str));
      if ("OidbSvc.0x897_0".equals(str))
      {
        o(paramToServiceMsg, paramFromServiceMsg, null);
        return;
      }
      if ("OidbSvc.0x88d_1".equals(str))
      {
        n(paramToServiceMsg, paramFromServiceMsg, null);
        return;
      }
    } while (!"OidbSvc.0x8a7_0".equals(str));
    q(paramToServiceMsg, paramFromServiceMsg, null);
  }
  
  private void c(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg)
  {
    if (QLog.isColorLevel()) {
      QLog.i("HotChatHandler", 2, "handleExtHotChatRespErrorOrTimeOut()");
    }
    paramFromServiceMsg = jdField_a_of_type_JavaLangString;
    notifyUI(1033, false, new Object[] { paramToServiceMsg.extraData.getString("troopUin"), paramFromServiceMsg });
  }
  
  private void c(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if (QLog.isColorLevel()) {
      QLog.i("HotChatHandler", 2, "handleExitHotChatResp()");
    }
    if ((paramToServiceMsg == null) || (paramFromServiceMsg == null)) {
      return;
    }
    String str2 = jdField_a_of_type_JavaLangString;
    String str1 = paramToServiceMsg.extraData.getString("troopUin");
    if (paramFromServiceMsg.getResultCode() != 1000)
    {
      notifyUI(1033, false, new Object[] { str1, str2 });
      return;
    }
    paramFromServiceMsg = new oidb_sso.OIDBSSOPkg();
    try
    {
      paramFromServiceMsg = (oidb_sso.OIDBSSOPkg)paramFromServiceMsg.mergeFrom((byte[])paramObject);
      if (paramFromServiceMsg == null)
      {
        notifyUI(1033, false, new Object[] { str1, str2 });
        return;
      }
    }
    catch (InvalidProtocolBufferMicroException paramFromServiceMsg)
    {
      for (;;)
      {
        paramFromServiceMsg = null;
      }
      if (!paramFromServiceMsg.uint32_result.has())
      {
        notifyUI(1033, false, new Object[] { str1, str2 });
        return;
      }
      int i = paramFromServiceMsg.uint32_result.get();
      if (QLog.isColorLevel()) {
        QLog.i("HotChatHandler", 2, "handleExitHotChatResp result " + i);
      }
      if (i == 0)
      {
        paramToServiceMsg = (HotChatManager.HotChatStateWrapper)paramToServiceMsg.extraData.getSerializable("targetHotChatState");
        paramFromServiceMsg = (HotChatManager)this.app.getManager(60);
        paramFromServiceMsg.a(paramFromServiceMsg.a(str1), paramToServiceMsg);
        notifyUI(1033, true, new Object[] { str1, b });
        return;
      }
      notifyUI(1033, false, new Object[] { str1, str2 });
    }
  }
  
  private void d(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg)
  {
    paramToServiceMsg = (HotChatInfo)paramToServiceMsg.extraData.get("HOT_CHAT_INFO");
    notifyUI(1032, false, new Object[] { paramToServiceMsg.troopUin, alud.a(2131705955), paramToServiceMsg.name });
  }
  
  private void d(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    String str = alud.a(2131705948);
    HotChatInfo localHotChatInfo = (HotChatInfo)paramToServiceMsg.extraData.getSerializable("HOT_CHAT_INFO");
    boolean bool = paramToServiceMsg.extraData.getBoolean("isWifiHotChat", false);
    if (paramFromServiceMsg.getResultCode() != 1000)
    {
      notifyUI(1032, false, new Object[] { localHotChatInfo.troopUin, str, localHotChatInfo.name });
      return;
    }
    paramToServiceMsg = new oidb_sso.OIDBSSOPkg();
    try
    {
      paramToServiceMsg = (oidb_sso.OIDBSSOPkg)paramToServiceMsg.mergeFrom((byte[])paramObject);
      if (paramToServiceMsg == null)
      {
        notifyUI(1032, false, new Object[] { localHotChatInfo.troopUin, str, localHotChatInfo.name });
        return;
      }
    }
    catch (InvalidProtocolBufferMicroException paramToServiceMsg)
    {
      for (;;)
      {
        paramToServiceMsg = null;
      }
      if (!paramToServiceMsg.uint32_result.has())
      {
        notifyUI(1032, false, new Object[] { localHotChatInfo.troopUin, str, localHotChatInfo.name });
        return;
      }
      int i = paramToServiceMsg.uint32_result.get();
      if (QLog.isColorLevel()) {
        QLog.i("HotChatHandler", 2, "handleCreateHotChatResp result " + i);
      }
      if (i == 0)
      {
        paramFromServiceMsg = new CreateHotChat.RspBody();
        try
        {
          paramFromServiceMsg.mergeFrom(paramToServiceMsg.bytes_bodybuffer.get().toByteArray());
          long l1 = bdeu.a(paramFromServiceMsg.uint32_group_code.get());
          long l2 = bdeu.a(paramFromServiceMsg.uint32_group_uin.get());
          localHotChatInfo.troopUin = String.valueOf(l1);
          localHotChatInfo.troopCode = String.valueOf(l2);
          localHotChatInfo.state = 0;
          ((HotChatManager)this.app.getManager(60)).a(localHotChatInfo, 4);
          notifyUI(1032, true, new Object[] { alud.a(2131705938), localHotChatInfo.troopCode, localHotChatInfo.troopUin, localHotChatInfo.name, Boolean.valueOf(bool) });
          return;
        }
        catch (Exception paramToServiceMsg)
        {
          notifyUI(1032, false, new Object[] { localHotChatInfo.troopUin, str, localHotChatInfo.name });
          return;
        }
      }
      switch (i)
      {
      case 1284: 
      case 1285: 
      case 1286: 
      case 1287: 
      case 1288: 
      case 1289: 
      default: 
        paramToServiceMsg = alud.a(2131705957);
      }
    }
    for (;;)
    {
      notifyUI(1032, false, new Object[] { localHotChatInfo.troopUin, paramToServiceMsg, localHotChatInfo.name });
      return;
      paramToServiceMsg = alud.a(2131705950);
      continue;
      paramToServiceMsg = alud.a(2131705944);
      continue;
      paramToServiceMsg = alud.a(2131705953);
      continue;
      paramToServiceMsg = alud.a(2131705954);
      continue;
      paramToServiceMsg = alud.a(2131705945);
      continue;
      paramToServiceMsg = alud.a(2131705940);
    }
  }
  
  private void e(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg)
  {
    System.out.println("-----> handleQuickJoinHotChatErrorOrTimeOut");
  }
  
  private void e(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    this.jdField_a_of_type_Boolean = false;
    boolean bool2;
    boolean bool1;
    if (paramToServiceMsg.extraData.getInt("serviceType", 0) == 2)
    {
      bool2 = true;
      paramToServiceMsg = new GetJoinedHotChatList.RspBody();
      if ((!paramFromServiceMsg.isSuccess()) || (paramObject == null)) {
        break label275;
      }
      bool1 = true;
      label45:
      if (!bool1) {
        break label383;
      }
      paramFromServiceMsg = new oidb_sso.OIDBSSOPkg();
    }
    for (;;)
    {
      try
      {
        paramFromServiceMsg = (oidb_sso.OIDBSSOPkg)paramFromServiceMsg.mergeFrom((byte[])paramObject);
        if (!paramFromServiceMsg.uint32_result.has()) {
          break label377;
        }
        i = paramFromServiceMsg.uint32_result.get();
        if (i != 0) {}
      }
      catch (Exception paramToServiceMsg)
      {
        label275:
        i = 0;
        bool1 = false;
        paramToServiceMsg = null;
        continue;
        boolean bool3 = false;
        continue;
        bool3 = false;
        ((HotChatManager)this.app.getManager(60)).a(paramToServiceMsg, bool2);
        if (bool2) {
          new Handler(Looper.getMainLooper()).post(new HotChatHandler.2(this, bool3, paramToServiceMsg));
        }
        notifyUI(1031, true, null);
        return;
      }
      try
      {
        paramToServiceMsg.mergeFrom(paramFromServiceMsg.bytes_bodybuffer.get().toByteArray());
        if (QLog.isColorLevel()) {
          QLog.i("HotChatHandler", 2, "handleGetMyHotChatListResp isSuccess: " + bool1 + ", result:" + i + ",resp=" + paramToServiceMsg);
        }
        if (paramToServiceMsg == null) {
          break label360;
        }
        paramFromServiceMsg = paramToServiceMsg.rpt_msg_wifi_poi_info.get();
        paramToServiceMsg = new ArrayList();
        if (paramFromServiceMsg == null) {
          continue;
        }
        paramFromServiceMsg = paramFromServiceMsg.iterator();
        bool1 = false;
        bool3 = bool1;
        if (!paramFromServiceMsg.hasNext()) {
          continue;
        }
        paramObject = (Common.WifiPOIInfo)paramFromServiceMsg.next();
        if (paramObject.uint32_wifi_poi_type.get() != 1) {
          continue;
        }
        bool3 = true;
        paramObject = HotChatInfo.createHotChat(paramObject, bool3);
        paramToServiceMsg.add(paramObject);
        if (!bool2) {
          break label374;
        }
        paramObject.isGameRoom = true;
        bool1 = true;
        continue;
      }
      catch (Exception paramToServiceMsg)
      {
        continue;
        continue;
      }
      bool2 = false;
      break;
      bool1 = false;
      break label45;
      label360:
      notifyUI(1031, false, null);
      return;
      label374:
      label377:
      int i = 0;
      continue;
      label383:
      i = 0;
    }
  }
  
  private void f(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg)
  {
    paramToServiceMsg = paramToServiceMsg.extraData.getByteArray("uid");
    int i = paramFromServiceMsg.getResultCode();
    notifyUI(1035, false, new Object[] { paramToServiceMsg, Integer.valueOf(i), "" });
    if (QLog.isColorLevel()) {
      QLog.i("HotChatHandler", 2, "handleSetHotChatAnnounceTimeOutOrError,result= " + i + ",uid=" + paramToServiceMsg);
    }
  }
  
  private void f(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    String str = paramToServiceMsg.extraData.getString("hotnamecode");
    int j = paramToServiceMsg.extraData.getInt("HOTCHAT_EXTRA_FLAG");
    int k = paramToServiceMsg.extraData.getInt("preHotChatState");
    Object localObject1 = null;
    Object localObject2 = null;
    Object localObject3 = new oidb_0x8ab.RspBody();
    int m = parseOIDBPkg(paramFromServiceMsg, paramObject, (MessageMicro)localObject3);
    if (m == 0)
    {
      paramFromServiceMsg = (FromServiceMsg)localObject2;
      paramObject = localObject1;
    }
    for (;;)
    {
      try
      {
        if (((oidb_0x8ab.RspBody)localObject3).poi_info.has())
        {
          paramObject = localObject1;
          paramFromServiceMsg = (Common.WifiPOIInfo)((oidb_0x8ab.RspBody)localObject3).poi_info.get();
        }
        paramObject = paramFromServiceMsg;
        if (!((oidb_0x8ab.RspBody)localObject3).join_poi_status.has()) {
          break label795;
        }
        paramObject = paramFromServiceMsg;
        i = ((oidb_0x8ab.RspBody)localObject3).join_poi_status.get();
      }
      catch (Exception paramFromServiceMsg)
      {
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.i("HotChatHandler", 2, paramFromServiceMsg.toString());
        i = 0;
        paramFromServiceMsg = paramObject;
        continue;
        if ((((HotChatInfo)localObject2).userCreate != paramObject.userCreate) || (!bdeu.a(((HotChatInfo)localObject2).uuid, paramObject.uuid)) || (bdeu.a(((HotChatInfo)localObject2).troopUin, paramObject.troopUin))) {
          continue;
        }
        if (!QLog.isColorLevel()) {
          continue;
        }
        auwz.a("HotChatHandler", new Object[] { "handleQuickJoinHotChat_check", String.format("userCreate:%d, uuid:%s, local:[%s,%s], server:[%s,%s]", new Object[] { Integer.valueOf(((HotChatInfo)localObject2).userCreate), ((HotChatInfo)localObject2).uuid, ((HotChatInfo)localObject2).troopUin, ((HotChatInfo)localObject2).troopCode, paramObject.troopUin, paramObject.troopCode }) });
        paramToServiceMsg.a((HotChatInfo)localObject2, HotChatManager.HotChatStateWrapper.STATE_LEFT_NORMAL);
        continue;
        if (i != 1) {
          continue;
        }
        paramToServiceMsg.a(paramObject, k);
        if (!paramFromServiceMsg.uint64_exit_group_code.has()) {
          continue;
        }
        l = paramFromServiceMsg.uint64_exit_group_code.get();
        localObject2 = paramToServiceMsg.a();
        if ((localObject1 == null) || (((List)localObject2).size() <= 0)) {
          continue;
        }
        localObject1 = ((List)localObject2).iterator();
        if (!((Iterator)localObject1).hasNext()) {
          continue;
        }
        localObject2 = (HotChatInfo)((Iterator)localObject1).next();
        if ((((HotChatInfo)localObject2).adminLevel != 0) || (!String.valueOf(l).equals(((HotChatInfo)localObject2).troopUin))) {
          continue;
        }
        paramToServiceMsg.a((HotChatInfo)localObject2, HotChatManager.HotChatStateWrapper.STATE_HOT_CHAT_LEFT_OVERCOUNT);
        continue;
        if (i != 2) {
          continue;
        }
        localObject2 = paramToServiceMsg.a(paramObject.troopUin);
        if (localObject2 != null) {
          continue;
        }
        paramToServiceMsg.a(paramObject, 4);
        continue;
        if (k != 1) {
          continue;
        }
        paramToServiceMsg.a(paramObject, k);
        continue;
        ((HotChatInfo)localObject2).updateHotChatInfo(paramObject);
        localObject3 = this.app.getEntityManagerFactory().createEntityManager();
        ((awgf)localObject3).a((awge)localObject2);
        ((awgf)localObject3).a();
        continue;
        paramToServiceMsg = paramObject;
      }
      if (paramFromServiceMsg != null)
      {
        paramObject = HotChatInfo.createHotChat(paramFromServiceMsg, false, j);
        j = paramToServiceMsg.extraData.getInt("apolloGameId");
        if (j > 0)
        {
          paramObject.apolloGameId = j;
          if (QLog.isColorLevel()) {
            QLog.d("HotChatHandler", 2, "handleQuickJoinHotChat jionHotChat, apolloGameId:" + j);
          }
        }
        if (QLog.isDevelopLevel()) {
          auwz.a("PttShow", new Object[] { "handleQuickJoinHotChat", paramObject });
        }
        paramToServiceMsg = (HotChatManager)this.app.getManager(60);
        localObject1 = paramToServiceMsg.a();
        if ((localObject1 != null) && (((List)localObject1).size() > 0))
        {
          j = ((List)localObject1).size() - 1;
          if (j >= 0)
          {
            localObject2 = (HotChatInfo)((List)localObject1).get(j);
            if (localObject2 == null)
            {
              j -= 1;
              continue;
            }
          }
        }
      }
      for (;;)
      {
        long l;
        notifyUI(1034, true, new Object[] { paramToServiceMsg, paramFromServiceMsg, Integer.valueOf(i), str });
        for (;;)
        {
          if (QLog.isColorLevel()) {
            QLog.i("HotChatHandler", 2, "handleQuickJoinHotChat, " + m + "," + paramToServiceMsg + "," + paramFromServiceMsg);
          }
          return;
          notifyUI(1034, false, new Object[] { null, null, Integer.valueOf(m), str });
          paramToServiceMsg = null;
          paramFromServiceMsg = null;
        }
        paramToServiceMsg = null;
      }
      label795:
      int i = 0;
    }
  }
  
  private void g(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg)
  {
    byte[] arrayOfByte = paramToServiceMsg.extraData.getByteArray("uid");
    paramToServiceMsg = paramToServiceMsg.extraData.getString("troop_uin");
    int i = paramFromServiceMsg.getResultCode();
    notifyUI(1036, false, new Object[] { paramToServiceMsg, arrayOfByte, Integer.valueOf(i), "", "", null });
    if (QLog.isColorLevel()) {
      QLog.i("HotChatHandlerQ.hotchat.oidb_0x8b2", 2, "handleGetHotChatAnnounceTimeOutOrError,result= " + i + ",uid=" + arrayOfByte);
    }
  }
  
  private void g(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    byte[] arrayOfByte = paramToServiceMsg.extraData.getByteArray("uid");
    for (;;)
    {
      try
      {
        paramToServiceMsg = new oidb_sso.OIDBSSOPkg();
        int j;
        paramObject = paramToServiceMsg;
      }
      catch (InvalidProtocolBufferMicroException paramFromServiceMsg)
      {
        try
        {
          paramToServiceMsg.mergeFrom((byte[])paramObject);
          paramObject = paramToServiceMsg;
          j = -1;
          i = j;
          if (paramObject != null)
          {
            i = j;
            if (paramObject.uint32_result.has()) {
              i = paramObject.uint32_result.get();
            }
          }
          if (i != 0) {
            break label174;
          }
          notifyUI(1035, true, new Object[] { arrayOfByte, Integer.valueOf(i), null });
          if (QLog.isColorLevel()) {
            QLog.i("HotChatHandler", 2, "handleSetHotChatAnnounce,result= " + i + ",strErr=" + null);
          }
          return;
        }
        catch (InvalidProtocolBufferMicroException paramFromServiceMsg)
        {
          int i;
          break label150;
        }
        paramFromServiceMsg = paramFromServiceMsg;
        paramToServiceMsg = null;
      }
      label150:
      if (QLog.isColorLevel())
      {
        QLog.i("HotChatHandler", 2, paramFromServiceMsg.toString());
        paramObject = paramToServiceMsg;
        continue;
        label174:
        notifyUI(1035, false, new Object[] { arrayOfByte, Integer.valueOf(i), null });
      }
    }
  }
  
  private void h(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg)
  {
    paramToServiceMsg = paramToServiceMsg.extraData.getString("groupcode");
    int i = paramFromServiceMsg.getResultCode();
    notifyUI(1039, false, new Object[] { paramToServiceMsg, Integer.valueOf(i), "", Long.valueOf(0L) });
    if (QLog.isColorLevel()) {
      QLog.i("HotChatHandler", 2, "handleGetUserCreateHotChatAnnounceTimeOutOrError,result= " + i + ",groupcode=" + paramToServiceMsg);
    }
  }
  
  /* Error */
  private void h(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    // Byte code:
    //   0: aload_1
    //   1: getfield 314	com/tencent/qphone/base/remote/ToServiceMsg:extraData	Landroid/os/Bundle;
    //   4: ldc_w 688
    //   7: invokevirtual 692	android/os/Bundle:getByteArray	(Ljava/lang/String;)[B
    //   10: astore 8
    //   12: aload_1
    //   13: getfield 314	com/tencent/qphone/base/remote/ToServiceMsg:extraData	Landroid/os/Bundle;
    //   16: ldc_w 804
    //   19: invokevirtual 517	android/os/Bundle:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   22: astore 9
    //   24: new 526	tencent/im/oidb/oidb_sso$OIDBSSOPkg
    //   27: dup
    //   28: invokespecial 527	tencent/im/oidb/oidb_sso$OIDBSSOPkg:<init>	()V
    //   31: astore_1
    //   32: aload_1
    //   33: aload_3
    //   34: checkcast 529	[B
    //   37: checkcast 529	[B
    //   40: invokevirtual 533	tencent/im/oidb/oidb_sso$OIDBSSOPkg:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   43: pop
    //   44: aload_1
    //   45: astore_2
    //   46: aload_2
    //   47: ifnull +528 -> 575
    //   50: aload_2
    //   51: getfield 536	tencent/im/oidb/oidb_sso$OIDBSSOPkg:uint32_result	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   54: invokevirtual 539	com/tencent/mobileqq/pb/PBUInt32Field:has	()Z
    //   57: ifeq +518 -> 575
    //   60: aload_2
    //   61: getfield 536	tencent/im/oidb/oidb_sso$OIDBSSOPkg:uint32_result	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   64: invokevirtual 542	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   67: istore 4
    //   69: aconst_null
    //   70: astore 6
    //   72: aconst_null
    //   73: astore 7
    //   75: aconst_null
    //   76: astore_3
    //   77: iload 4
    //   79: ifne +418 -> 497
    //   82: new 824	tencent/im/oidb/cmd0x8b2/oidb_0x8b2$RspBody
    //   85: dup
    //   86: invokespecial 825	tencent/im/oidb/cmd0x8b2/oidb_0x8b2$RspBody:<init>	()V
    //   89: astore 6
    //   91: aload 6
    //   93: aload_2
    //   94: getfield 579	tencent/im/oidb/oidb_sso$OIDBSSOPkg:bytes_bodybuffer	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   97: invokevirtual 582	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   100: invokevirtual 583	com/tencent/mobileqq/pb/ByteStringMicro:toByteArray	()[B
    //   103: invokevirtual 826	tencent/im/oidb/cmd0x8b2/oidb_0x8b2$RspBody:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   106: pop
    //   107: aload 6
    //   109: getfield 829	tencent/im/oidb/cmd0x8b2/oidb_0x8b2$RspBody:string_group_memo	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   112: invokevirtual 830	com/tencent/mobileqq/pb/PBBytesField:has	()Z
    //   115: ifeq +455 -> 570
    //   118: aload 6
    //   120: getfield 829	tencent/im/oidb/cmd0x8b2/oidb_0x8b2$RspBody:string_group_memo	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   123: invokevirtual 582	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   126: invokevirtual 833	com/tencent/mobileqq/pb/ByteStringMicro:toStringUtf8	()Ljava/lang/String;
    //   129: astore_1
    //   130: aload 6
    //   132: getfield 836	tencent/im/oidb/cmd0x8b2/oidb_0x8b2$RspBody:string_jumping_url	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   135: invokevirtual 830	com/tencent/mobileqq/pb/PBBytesField:has	()Z
    //   138: ifeq +427 -> 565
    //   141: aload 6
    //   143: getfield 836	tencent/im/oidb/cmd0x8b2/oidb_0x8b2$RspBody:string_jumping_url	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   146: invokevirtual 582	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   149: invokevirtual 833	com/tencent/mobileqq/pb/ByteStringMicro:toStringUtf8	()Ljava/lang/String;
    //   152: astore_2
    //   153: aload 6
    //   155: getfield 840	tencent/im/oidb/cmd0x8b2/oidb_0x8b2$RspBody:uint64_administrator_uin	Lcom/tencent/mobileqq/pb/PBRepeatField;
    //   158: invokevirtual 843	com/tencent/mobileqq/pb/PBRepeatField:has	()Z
    //   161: ifeq +12 -> 173
    //   164: aload 6
    //   166: getfield 840	tencent/im/oidb/cmd0x8b2/oidb_0x8b2$RspBody:uint64_administrator_uin	Lcom/tencent/mobileqq/pb/PBRepeatField;
    //   169: invokevirtual 844	com/tencent/mobileqq/pb/PBRepeatField:get	()Ljava/util/List;
    //   172: astore_3
    //   173: aload_1
    //   174: astore 6
    //   176: aload_3
    //   177: astore_1
    //   178: aload 6
    //   180: astore_3
    //   181: aload_0
    //   182: getfield 423	aluj:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   185: bipush 60
    //   187: invokevirtual 429	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   190: checkcast 251	com/tencent/mobileqq/app/HotChatManager
    //   193: astore 6
    //   195: aload 6
    //   197: aload 9
    //   199: invokevirtual 555	com/tencent/mobileqq/app/HotChatManager:a	(Ljava/lang/String;)Lcom/tencent/mobileqq/data/HotChatInfo;
    //   202: astore 7
    //   204: aload 7
    //   206: ifnull +183 -> 389
    //   209: aload_3
    //   210: ifnonnull +144 -> 354
    //   213: aload 7
    //   215: getfield 847	com/tencent/mobileqq/data/HotChatInfo:memo	Ljava/lang/String;
    //   218: ifnonnull +148 -> 366
    //   221: aload 7
    //   223: aload_3
    //   224: putfield 847	com/tencent/mobileqq/data/HotChatInfo:memo	Ljava/lang/String;
    //   227: aload 7
    //   229: aload_2
    //   230: putfield 850	com/tencent/mobileqq/data/HotChatInfo:memoUrl	Ljava/lang/String;
    //   233: new 104	java/util/ArrayList
    //   236: dup
    //   237: invokespecial 655	java/util/ArrayList:<init>	()V
    //   240: astore 10
    //   242: aload_1
    //   243: ifnull +132 -> 375
    //   246: aload_1
    //   247: invokeinterface 739 1 0
    //   252: ifle +123 -> 375
    //   255: iconst_0
    //   256: istore 5
    //   258: iload 5
    //   260: aload_1
    //   261: invokeinterface 739 1 0
    //   266: if_icmpge +109 -> 375
    //   269: aload 10
    //   271: aload_1
    //   272: iload 5
    //   274: invokeinterface 742 2 0
    //   279: checkcast 815	java/lang/Long
    //   282: invokestatic 853	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   285: invokevirtual 854	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   288: pop
    //   289: iload 5
    //   291: iconst_1
    //   292: iadd
    //   293: istore 5
    //   295: goto -37 -> 258
    //   298: astore_3
    //   299: aconst_null
    //   300: astore_1
    //   301: aload_1
    //   302: astore_2
    //   303: invokestatic 280	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   306: ifeq -260 -> 46
    //   309: ldc_w 282
    //   312: iconst_2
    //   313: aload_3
    //   314: invokevirtual 811	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException:toString	()Ljava/lang/String;
    //   317: invokestatic 415	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   320: aload_1
    //   321: astore_2
    //   322: goto -276 -> 46
    //   325: astore_3
    //   326: aconst_null
    //   327: astore_1
    //   328: aconst_null
    //   329: astore_2
    //   330: invokestatic 280	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   333: ifeq +14 -> 347
    //   336: ldc_w 282
    //   339: iconst_2
    //   340: aload_3
    //   341: invokevirtual 743	java/lang/Exception:toString	()Ljava/lang/String;
    //   344: invokestatic 415	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   347: aload_1
    //   348: astore_3
    //   349: aconst_null
    //   350: astore_1
    //   351: goto -170 -> 181
    //   354: aload_3
    //   355: aload 7
    //   357: getfield 847	com/tencent/mobileqq/data/HotChatInfo:memo	Ljava/lang/String;
    //   360: invokevirtual 303	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   363: ifne -142 -> 221
    //   366: aload 7
    //   368: iconst_0
    //   369: putfield 857	com/tencent/mobileqq/data/HotChatInfo:memoShowed	Z
    //   372: goto -151 -> 221
    //   375: aload 7
    //   377: aload 10
    //   379: putfield 861	com/tencent/mobileqq/data/HotChatInfo:adminUins	Ljava/util/List;
    //   382: aload 6
    //   384: aload 7
    //   386: invokevirtual 863	com/tencent/mobileqq/app/HotChatManager:a	(Lcom/tencent/mobileqq/data/HotChatInfo;)V
    //   389: aload_0
    //   390: sipush 1036
    //   393: iconst_1
    //   394: bipush 6
    //   396: anewarray 435	java/lang/Object
    //   399: dup
    //   400: iconst_0
    //   401: aload 9
    //   403: aastore
    //   404: dup
    //   405: iconst_1
    //   406: aload 8
    //   408: aastore
    //   409: dup
    //   410: iconst_2
    //   411: iload 4
    //   413: invokestatic 448	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   416: aastore
    //   417: dup
    //   418: iconst_3
    //   419: aload_3
    //   420: aastore
    //   421: dup
    //   422: iconst_4
    //   423: aload_2
    //   424: aastore
    //   425: dup
    //   426: iconst_5
    //   427: aload_1
    //   428: aastore
    //   429: invokevirtual 419	aluj:notifyUI	(IZLjava/lang/Object;)V
    //   432: invokestatic 280	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   435: ifeq +61 -> 496
    //   438: ldc_w 357
    //   441: iconst_2
    //   442: new 284	java/lang/StringBuilder
    //   445: dup
    //   446: invokespecial 285	java/lang/StringBuilder:<init>	()V
    //   449: ldc_w 865
    //   452: invokevirtual 291	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   455: iload 4
    //   457: invokevirtual 364	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   460: ldc_w 867
    //   463: invokevirtual 291	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   466: aload_3
    //   467: invokevirtual 291	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   470: ldc_w 869
    //   473: invokevirtual 291	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   476: aload_2
    //   477: invokevirtual 291	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   480: ldc_w 871
    //   483: invokevirtual 291	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   486: aload_1
    //   487: invokevirtual 648	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   490: invokevirtual 294	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   493: invokestatic 415	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   496: return
    //   497: aload_0
    //   498: sipush 1036
    //   501: iconst_0
    //   502: bipush 6
    //   504: anewarray 435	java/lang/Object
    //   507: dup
    //   508: iconst_0
    //   509: aload 9
    //   511: aastore
    //   512: dup
    //   513: iconst_1
    //   514: aload 8
    //   516: aastore
    //   517: dup
    //   518: iconst_2
    //   519: iload 4
    //   521: invokestatic 448	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   524: aastore
    //   525: dup
    //   526: iconst_3
    //   527: aconst_null
    //   528: aastore
    //   529: dup
    //   530: iconst_4
    //   531: aconst_null
    //   532: aastore
    //   533: dup
    //   534: iconst_5
    //   535: aconst_null
    //   536: aastore
    //   537: invokevirtual 419	aluj:notifyUI	(IZLjava/lang/Object;)V
    //   540: aconst_null
    //   541: astore_1
    //   542: aload 7
    //   544: astore_2
    //   545: aload 6
    //   547: astore_3
    //   548: goto -116 -> 432
    //   551: astore_3
    //   552: aconst_null
    //   553: astore_2
    //   554: goto -224 -> 330
    //   557: astore_3
    //   558: goto -228 -> 330
    //   561: astore_3
    //   562: goto -261 -> 301
    //   565: aconst_null
    //   566: astore_2
    //   567: goto -414 -> 153
    //   570: aconst_null
    //   571: astore_1
    //   572: goto -442 -> 130
    //   575: iconst_m1
    //   576: istore 4
    //   578: goto -509 -> 69
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	581	0	this	aluj
    //   0	581	1	paramToServiceMsg	ToServiceMsg
    //   0	581	2	paramFromServiceMsg	FromServiceMsg
    //   0	581	3	paramObject	Object
    //   67	510	4	i	int
    //   256	38	5	j	int
    //   70	476	6	localObject	Object
    //   73	470	7	localHotChatInfo	HotChatInfo
    //   10	505	8	arrayOfByte	byte[]
    //   22	488	9	str	String
    //   240	138	10	localArrayList	ArrayList
    // Exception table:
    //   from	to	target	type
    //   24	32	298	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   91	130	325	java/lang/Exception
    //   130	153	551	java/lang/Exception
    //   153	173	557	java/lang/Exception
    //   32	44	561	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
  }
  
  private void i(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg)
  {
    paramToServiceMsg = paramToServiceMsg.extraData.getString("groupcode");
    int i = paramFromServiceMsg.getResultCode();
    notifyUI(1040, false, new Object[] { paramToServiceMsg, Integer.valueOf(i), "" });
    if (QLog.isColorLevel()) {
      QLog.i("HotChatHandler", 2, "handleSetUserCreateHotChatAnnounce,result= " + i + ",groupcode=" + paramToServiceMsg);
    }
  }
  
  private void i(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    localObject = paramToServiceMsg.extraData.getString("groupcode");
    try
    {
      paramToServiceMsg = new oidb_sso.OIDBSSOPkg();
    }
    catch (InvalidProtocolBufferMicroException paramFromServiceMsg)
    {
      for (;;)
      {
        try
        {
          label57:
          oidb_0x88d.RspBody localRspBody;
          localRspBody.mergeFrom(paramFromServiceMsg.bytes_bodybuffer.get().toByteArray());
          paramFromServiceMsg = paramObject;
          if (localRspBody.stzrspgroupinfo.has()) {
            paramFromServiceMsg = localRspBody.stzrspgroupinfo.get();
          }
          if ((paramFromServiceMsg != null) && (paramFromServiceMsg.size() > 0))
          {
            paramFromServiceMsg = (oidb_0x88d.RspGroupInfo)paramFromServiceMsg.get(0);
            if (!paramFromServiceMsg.uint32_result.has()) {
              break label641;
            }
            j = paramFromServiceMsg.uint32_result.get();
            i = j;
            if (i != 0) {}
          }
        }
        catch (Exception localException2)
        {
          HotChatInfo localHotChatInfo;
          int j;
          long l;
          paramFromServiceMsg = null;
          continue;
        }
        try
        {
          if (!paramFromServiceMsg.stgroupinfo.has()) {
            break label636;
          }
          paramObject = (oidb_0x88d.GroupInfo)paramFromServiceMsg.stgroupinfo.get();
          if (paramObject == null) {
            break label627;
          }
          paramFromServiceMsg = localHotChatInfo;
          if (paramObject.string_group_memo.has()) {
            paramFromServiceMsg = paramObject.string_group_memo.get().toStringUtf8();
          }
        }
        catch (Exception localException3)
        {
          paramFromServiceMsg = null;
          continue;
        }
        try
        {
          if (!paramObject.uint64_group_owner.has()) {
            break;
          }
          l = paramObject.uint64_group_owner.get();
          paramObject = Long.valueOf(l);
          paramToServiceMsg = paramFromServiceMsg;
          paramFromServiceMsg = paramObject;
          try
          {
            paramObject = (HotChatManager)this.app.getManager(60);
            localHotChatInfo = paramObject.a((String)localObject);
            if (localHotChatInfo != null)
            {
              if (paramToServiceMsg == null)
              {
                if (localHotChatInfo.memo != null) {
                  continue;
                }
                localHotChatInfo.memo = paramToServiceMsg;
                localHotChatInfo.memoUrl = null;
                localHotChatInfo.ownerUin = String.valueOf(paramFromServiceMsg);
                paramObject.a(localHotChatInfo);
              }
            }
            else
            {
              notifyUI(1039, true, new Object[] { localObject, Integer.valueOf(i), paramToServiceMsg, paramFromServiceMsg });
              j = i;
              localObject = paramToServiceMsg;
              paramObject = paramFromServiceMsg;
              if (QLog.isColorLevel()) {
                QLog.i("HotChatHandler", 2, "handleGetUserCreateHotChatAnnounce,result= " + j + ",memo=" + (String)localObject + ",troopOwner=" + paramObject);
              }
              return;
              paramFromServiceMsg = paramFromServiceMsg;
              paramToServiceMsg = null;
              if (QLog.isColorLevel()) {
                QLog.i("HotChatHandler", 2, paramFromServiceMsg.toString());
              }
              paramFromServiceMsg = paramToServiceMsg;
              continue;
            }
            if (paramToServiceMsg.equals(localHotChatInfo.memo)) {
              continue;
            }
            localHotChatInfo.memoShowed = false;
            continue;
            paramObject = paramToServiceMsg;
          }
          catch (Exception localException1)
          {
            paramObject = paramFromServiceMsg;
            paramFromServiceMsg = paramToServiceMsg;
            paramToServiceMsg = paramObject;
          }
        }
        catch (Exception localException4)
        {
          continue;
        }
        localObject = paramFromServiceMsg;
        j = i;
        if (QLog.isColorLevel())
        {
          QLog.i("HotChatHandler", 2, localException1.toString());
          paramObject = paramToServiceMsg;
          localObject = paramFromServiceMsg;
          j = i;
          continue;
          notifyUI(1039, false, new Object[] { localObject, Integer.valueOf(i), null, paramToServiceMsg });
          localObject = null;
          paramObject = paramToServiceMsg;
          j = i;
          continue;
          notifyUI(1039, false, new Object[] { localObject, Integer.valueOf(i), null, paramToServiceMsg });
          localObject = null;
          paramObject = paramToServiceMsg;
          j = i;
        }
      }
    }
    try
    {
      paramToServiceMsg.mergeFrom((byte[])paramObject);
      paramFromServiceMsg = paramToServiceMsg;
      if ((paramFromServiceMsg == null) || (!paramFromServiceMsg.uint32_result.has())) {
        break label644;
      }
      i = paramFromServiceMsg.uint32_result.get();
    }
    catch (InvalidProtocolBufferMicroException paramFromServiceMsg)
    {
      break label415;
      paramObject = paramFromServiceMsg;
      paramFromServiceMsg = paramToServiceMsg;
      paramToServiceMsg = paramObject;
      break label249;
      paramObject = null;
      paramFromServiceMsg = paramToServiceMsg;
      paramToServiceMsg = paramObject;
      break label249;
      paramObject = null;
      break label192;
      break label166;
      i = -1;
      break label57;
    }
    localHotChatInfo = null;
    paramToServiceMsg = Long.valueOf(0L);
    paramObject = null;
    if (i == 0) {
      localRspBody = new oidb_0x88d.RspBody();
    }
  }
  
  private void j(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg)
  {
    String str = paramToServiceMsg.extraData.getString("groupuin");
    paramToServiceMsg = paramToServiceMsg.extraData.getString("memberuin");
    int i = paramFromServiceMsg.getResultCode();
    notifyUI(1037, false, new Object[] { str, Integer.valueOf(i), paramToServiceMsg, null });
    if (QLog.isColorLevel()) {
      QLog.i("HotChatHandler", 2, "handleKickHotChatMemberErrorOrTimeout,result= " + i + ",groupuin=" + str + ",memberUin=" + paramToServiceMsg);
    }
  }
  
  private void j(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    str = paramToServiceMsg.extraData.getString("groupcode");
    try
    {
      paramToServiceMsg = new oidb_sso.OIDBSSOPkg();
    }
    catch (InvalidProtocolBufferMicroException paramFromServiceMsg)
    {
      for (;;)
      {
        label55:
        paramToServiceMsg = null;
        if (QLog.isColorLevel()) {
          QLog.i("HotChatHandler", 2, paramFromServiceMsg.toString());
        }
        continue;
        paramFromServiceMsg = new oidb_0x89a.RspBody();
        try
        {
          paramFromServiceMsg.mergeFrom(paramToServiceMsg.bytes_bodybuffer.get().toByteArray());
          boolean bool = paramFromServiceMsg.str_errorinfo.has();
          if (!bool) {}
        }
        catch (Exception paramToServiceMsg)
        {
          for (;;)
          {
            if (QLog.isColorLevel()) {
              QLog.i("HotChatHandler", 2, paramToServiceMsg.toString());
            }
          }
        }
        notifyUI(1040, false, new Object[] { str, Integer.valueOf(i), null });
      }
    }
    try
    {
      paramToServiceMsg.mergeFrom((byte[])paramObject);
      if ((paramToServiceMsg == null) || (!paramToServiceMsg.uint32_result.has())) {
        break label251;
      }
      i = paramToServiceMsg.uint32_result.get();
    }
    catch (InvalidProtocolBufferMicroException paramFromServiceMsg)
    {
      break label137;
      i = -1;
      break label55;
    }
    if (i == 0)
    {
      notifyUI(1040, true, new Object[] { str, Integer.valueOf(i), null });
      if (QLog.isColorLevel()) {
        QLog.i("HotChatHandler", 2, "handleSetUserCreateHotChatAnnounce,result= " + i + ",strErr=" + null);
      }
      return;
    }
  }
  
  private void k(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg)
  {
    String str = paramToServiceMsg.extraData.getString("groupuin");
    paramToServiceMsg = paramToServiceMsg.extraData.getString("groupcode");
    int i = paramFromServiceMsg.getResultCode();
    notifyUI(1038, false, new Object[] { str, Integer.valueOf(i), paramToServiceMsg });
    if (QLog.isColorLevel()) {
      QLog.i("HotChatHandler", 2, "handleDismissHotChatTimeOutOrError,result= " + i + ",groupuin=" + str + ",groupcode=" + paramToServiceMsg);
    }
  }
  
  private void k(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    str1 = paramToServiceMsg.extraData.getString("groupuin");
    str2 = paramToServiceMsg.extraData.getString("groupcode");
    str3 = paramToServiceMsg.extraData.getString("memberuin");
    str4 = paramToServiceMsg.extraData.getString("nickname");
    try
    {
      paramToServiceMsg = new oidb_sso.OIDBSSOPkg();
    }
    catch (InvalidProtocolBufferMicroException paramObject)
    {
      for (;;)
      {
        try
        {
          label93:
          paramToServiceMsg.mergeFrom(paramFromServiceMsg.bytes_bodybuffer.get().toByteArray());
          if (paramToServiceMsg.msg_kick_visitor.has()) {
            paramToServiceMsg = (oidb_0x823.KickPublicGroupVisitorRspBody)paramToServiceMsg.msg_kick_visitor.get();
          }
          amkl.a(this.app, String.valueOf(str2), str4 + BaseApplicationImpl.getContext().getString(2131693425), 1, false, true);
          notifyUI(1052, true, new Object[] { str1, Integer.valueOf(i), str3, null });
          if (QLog.isColorLevel()) {
            QLog.i("HotChatHandlerQ.hotchat.hotchat_kick_mem_by_global_admin", 2, "handleKickHotChatMemberByGlobalAmdminResp,result= " + i + ",groupuin=" + str1 + ",memberUin=" + str3 + ",strErr=" + null);
          }
          return;
          paramObject = paramObject;
          paramToServiceMsg = null;
          paramFromServiceMsg = paramToServiceMsg;
          if (!QLog.isColorLevel()) {
            continue;
          }
          QLog.i("HotChatHandler", 2, paramObject.toString());
          paramFromServiceMsg = paramToServiceMsg;
        }
        catch (Exception paramToServiceMsg)
        {
          if (!QLog.isColorLevel()) {
            continue;
          }
          QLog.i("HotChatHandler", 2, paramToServiceMsg.toString());
          continue;
        }
        notifyUI(1052, false, new Object[] { str1, Integer.valueOf(i), str3, null });
      }
    }
    try
    {
      paramToServiceMsg.mergeFrom((byte[])paramObject);
      paramFromServiceMsg = paramToServiceMsg;
      if ((paramFromServiceMsg == null) || (!paramFromServiceMsg.uint32_result.has())) {
        break label374;
      }
      i = paramFromServiceMsg.uint32_result.get();
    }
    catch (InvalidProtocolBufferMicroException paramObject)
    {
      break label288;
      i = -1;
      break label93;
    }
    if (i == 0) {
      paramToServiceMsg = new oidb_0x823.RspBody();
    }
  }
  
  private void l(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    str1 = paramToServiceMsg.extraData.getString("groupuin");
    String str3 = paramToServiceMsg.extraData.getString("groupcode");
    str2 = paramToServiceMsg.extraData.getString("memberuin");
    String str4 = paramToServiceMsg.extraData.getString("nickname");
    try
    {
      paramToServiceMsg = new oidb_sso.OIDBSSOPkg();
    }
    catch (InvalidProtocolBufferMicroException paramObject)
    {
      for (;;)
      {
        label93:
        paramToServiceMsg = null;
        paramFromServiceMsg = paramToServiceMsg;
        if (QLog.isColorLevel())
        {
          QLog.i("HotChatHandler", 2, paramObject.toString());
          paramFromServiceMsg = paramToServiceMsg;
          continue;
          notifyUI(1037, false, new Object[] { str1, Integer.valueOf(i), str2, null });
          paramToServiceMsg = null;
        }
      }
    }
    try
    {
      paramToServiceMsg.mergeFrom((byte[])paramObject);
      paramFromServiceMsg = paramToServiceMsg;
      if ((paramFromServiceMsg == null) || (!paramFromServiceMsg.uint32_result.has())) {
        break label377;
      }
      i = paramFromServiceMsg.uint32_result.get();
    }
    catch (InvalidProtocolBufferMicroException paramObject)
    {
      break label287;
      i = -1;
      break label93;
    }
    paramToServiceMsg = null;
    if (i == 0)
    {
      paramObject = new oidb_0x89b.RspBody();
      try
      {
        paramObject.mergeFrom(paramFromServiceMsg.bytes_bodybuffer.get().toByteArray());
        if (paramObject.str_err_msg.has()) {
          paramToServiceMsg = paramObject.str_err_msg.get();
        }
      }
      catch (Exception paramToServiceMsg)
      {
        for (;;)
        {
          if (QLog.isColorLevel()) {
            QLog.i("HotChatHandler", 2, paramToServiceMsg.toString());
          }
          paramToServiceMsg = null;
        }
      }
      amkl.a(this.app, String.valueOf(str3), str4 + BaseApplicationImpl.getContext().getString(2131693425), 1, false, true);
      notifyUI(1037, true, new Object[] { str1, Integer.valueOf(i), str2, paramToServiceMsg });
      if (QLog.isColorLevel()) {
        QLog.i("HotChatHandler", 2, "handleKickHotChatMemberResp,result= " + i + ",groupuin=" + str1 + ",memberUin=" + str2 + ",strErr=" + paramToServiceMsg);
      }
      return;
    }
  }
  
  private void m(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    str = paramToServiceMsg.extraData.getString("groupcode");
    try
    {
      paramToServiceMsg = new oidb_sso.OIDBSSOPkg();
    }
    catch (InvalidProtocolBufferMicroException paramFromServiceMsg)
    {
      for (;;)
      {
        label57:
        paramToServiceMsg = null;
        if (QLog.isColorLevel()) {
          QLog.i("HotChatHandler", 2, paramFromServiceMsg.toString());
        }
        continue;
        notifyUI(1038, false, new Object[] { str, Integer.valueOf(i), null });
      }
    }
    try
    {
      paramToServiceMsg.mergeFrom((byte[])paramObject);
      paramFromServiceMsg = null;
      if ((paramToServiceMsg == null) || (!paramToServiceMsg.uint32_result.has())) {
        break label297;
      }
      i = paramToServiceMsg.uint32_result.get();
    }
    catch (InvalidProtocolBufferMicroException paramFromServiceMsg)
    {
      break label218;
      i = -1;
      break label57;
    }
    if (i == 0)
    {
      paramObject = new oidb_0xa81.RspBody();
      try
      {
        paramObject.mergeFrom(paramToServiceMsg.bytes_bodybuffer.get().toByteArray());
        paramToServiceMsg = paramFromServiceMsg;
        if (paramObject.str_err_msg.has()) {
          paramToServiceMsg = paramObject.str_err_msg.get().toStringUtf8();
        }
      }
      catch (Exception paramToServiceMsg)
      {
        for (;;)
        {
          if (QLog.isColorLevel()) {
            QLog.i("HotChatHandler", 2, paramToServiceMsg.toString());
          }
          paramToServiceMsg = null;
        }
      }
      paramFromServiceMsg = (HotChatManager)this.app.getManager(60);
      paramObject = paramFromServiceMsg.a(str);
      if (paramObject != null) {
        paramFromServiceMsg.a(paramObject, HotChatManager.HotChatStateWrapper.STATE_LEFT_NORMAL);
      }
      notifyUI(1038, true, new Object[] { str, Integer.valueOf(i), paramToServiceMsg });
      if (QLog.isColorLevel()) {
        QLog.i("HotChatHandler", 2, "handleDismissHotChat,result= " + i + ",groupcode=" + str);
      }
      return;
    }
  }
  
  private void n(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if ((paramToServiceMsg == null) || (paramFromServiceMsg == null)) {
      return;
    }
    String str = paramToServiceMsg.extraData.getString("troopCode");
    boolean bool = paramToServiceMsg.extraData.getBoolean("isHotChat");
    paramToServiceMsg = new Object[3];
    paramToServiceMsg[0] = str;
    paramToServiceMsg[1] = Integer.valueOf(-1);
    paramToServiceMsg[2] = Boolean.valueOf(bool);
    if (QLog.isColorLevel()) {
      QLog.d("HotChatHandler", 2, "handleGetTroopInfo isHotChat = " + bool);
    }
    if ((paramObject == null) || (paramFromServiceMsg.getResultCode() != 1000))
    {
      notifyUI(1047, false, paramToServiceMsg);
      return;
    }
    paramFromServiceMsg = new oidb_sso.OIDBSSOPkg();
    try
    {
      paramFromServiceMsg = (oidb_sso.OIDBSSOPkg)paramFromServiceMsg.mergeFrom((byte[])paramObject);
      if ((paramFromServiceMsg == null) || (!paramFromServiceMsg.uint32_result.has()) || (paramFromServiceMsg.uint32_result.get() != 0) || (!paramFromServiceMsg.bytes_bodybuffer.has()) || (paramFromServiceMsg.bytes_bodybuffer.get() == null))
      {
        notifyUI(1047, false, paramToServiceMsg);
        return;
      }
    }
    catch (InvalidProtocolBufferMicroException paramFromServiceMsg)
    {
      notifyUI(1047, false, paramToServiceMsg);
      return;
    }
    paramObject = new oidb_0x88d.RspBody();
    int i;
    try
    {
      paramObject.mergeFrom(paramFromServiceMsg.bytes_bodybuffer.get().toByteArray());
      paramFromServiceMsg = paramObject.stzrspgroupinfo.get();
      if ((paramFromServiceMsg == null) || (paramFromServiceMsg.size() <= 0)) {
        break label365;
      }
      paramFromServiceMsg = (oidb_0x88d.RspGroupInfo)paramFromServiceMsg.get(0);
      i = paramFromServiceMsg.uint32_result.get();
      if (i == 0)
      {
        notifyUI(1047, true, new Object[] { str, Integer.valueOf(i), Boolean.valueOf(bool), (oidb_0x88d.GroupInfo)paramFromServiceMsg.stgroupinfo.get() });
        return;
      }
    }
    catch (InvalidProtocolBufferMicroException paramFromServiceMsg)
    {
      notifyUI(1047, false, paramToServiceMsg);
      return;
    }
    notifyUI(1047, false, new Object[] { str, Integer.valueOf(i), Boolean.valueOf(bool) });
    return;
    label365:
    notifyUI(1047, false, paramToServiceMsg);
  }
  
  private void o(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    paramToServiceMsg = Long.valueOf(paramToServiceMsg.extraData.getLong("uitag"));
    if ((paramFromServiceMsg == null) || (paramObject == null) || (paramFromServiceMsg.getResultCode() != 1000)) {
      notifyUI(1046, false, new Object[] { Integer.valueOf(1), null, paramToServiceMsg });
    }
    for (;;)
    {
      return;
      paramFromServiceMsg = new oidb_sso.OIDBSSOPkg();
      try
      {
        paramObject = (oidb_sso.OIDBSSOPkg)paramFromServiceMsg.mergeFrom((byte[])paramObject);
        if ((paramObject == null) || (!paramObject.uint32_result.has()) || (!paramObject.bytes_bodybuffer.has()) || (paramObject.bytes_bodybuffer.get() == null))
        {
          notifyUI(1046, false, new Object[] { Integer.valueOf(1), null, paramToServiceMsg });
          return;
        }
      }
      catch (InvalidProtocolBufferMicroException paramFromServiceMsg)
      {
        notifyUI(1046, false, new Object[] { Integer.valueOf(1), null, paramToServiceMsg });
        return;
      }
      paramFromServiceMsg = new cmd0x897.RspBody();
      try
      {
        paramFromServiceMsg.mergeFrom(paramObject.bytes_bodybuffer.get().toByteArray());
        if (paramFromServiceMsg.uint32_result.has()) {
          if (paramFromServiceMsg.uint32_result.get() == 0)
          {
            if (!paramFromServiceMsg.rpt_msg_grp_visitor_info.isEmpty()) {
              notifyUI(1046, true, new Object[] { Integer.valueOf(0), paramFromServiceMsg.rpt_msg_grp_visitor_info.get(), paramToServiceMsg });
            }
            while (QLog.isColorLevel())
            {
              int i = -1;
              if (paramFromServiceMsg.uint32_result.has()) {
                i = paramFromServiceMsg.uint32_result.get();
              }
              QLog.i("HotChatHandler", 2, "handleGetHotChatTroopMemberList.result=" + i);
              return;
              notifyUI(1046, false, new Object[] { Integer.valueOf(2), null, paramToServiceMsg });
            }
          }
        }
      }
      catch (InvalidProtocolBufferMicroException paramObject)
      {
        for (;;)
        {
          notifyUI(1046, false, new Object[] { Integer.valueOf(1), null, paramToServiceMsg });
          continue;
          notifyUI(1046, false, new Object[] { Integer.valueOf(3), null, paramToServiceMsg });
          continue;
          notifyUI(1046, false, new Object[] { Integer.valueOf(1), null, paramToServiceMsg });
        }
      }
    }
  }
  
  private void p(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    byte[] arrayOfByte = paramToServiceMsg.extraData.getByteArray("uid");
    String str = paramToServiceMsg.extraData.getString("troop_uin");
    ArrayList localArrayList = paramToServiceMsg.extraData.getStringArrayList("uins");
    int k = paramToServiceMsg.extraData.getInt("serviceType");
    try
    {
      paramToServiceMsg = new oidb_sso.OIDBSSOPkg();
    }
    catch (InvalidProtocolBufferMicroException paramObject)
    {
      try
      {
        label93:
        label224:
        do
        {
          paramToServiceMsg.mergeFrom(paramFromServiceMsg.bytes_bodybuffer.get().toByteArray());
          paramToServiceMsg = (HotChatManager)this.app.getManager(60);
          paramFromServiceMsg = paramToServiceMsg.a(str);
          if (paramFromServiceMsg == null) {
            break label308;
          }
          if ((localArrayList == null) || (localArrayList.size() <= 0)) {
            break label303;
          }
          j = 0;
          for (;;)
          {
            if (j >= localArrayList.size()) {
              break label303;
            }
            paramObject = (String)localArrayList.get(j);
            if ((k != 5) || (paramFromServiceMsg.adminUins.contains(paramObject))) {
              break;
            }
            paramFromServiceMsg.adminUins.add(paramObject);
            j += 1;
          }
          paramObject = paramObject;
          paramToServiceMsg = null;
          paramFromServiceMsg = paramToServiceMsg;
        } while (!QLog.isColorLevel());
        QLog.i("HotChatHandler", 2, paramObject.toString());
        paramFromServiceMsg = paramToServiceMsg;
      }
      catch (Exception paramToServiceMsg)
      {
        for (;;)
        {
          if (QLog.isColorLevel())
          {
            QLog.i("HotChatHandler", 2, paramToServiceMsg.toString());
            continue;
            if ((k == 6) && (paramFromServiceMsg.adminUins.contains(paramObject))) {
              paramFromServiceMsg.adminUins.remove(paramObject);
            }
          }
        }
        label303:
        paramToServiceMsg.a(paramFromServiceMsg);
        label308:
        notifyUI(1050, true, new Object[] { str, arrayOfByte, Integer.valueOf(i), Integer.valueOf(k), localArrayList });
      }
      if (QLog.isColorLevel()) {
        QLog.i("HotChatHandlerQ.hotchat.setadmin", 2, "handleSetHotChatAdminFlag==>,operaUins=" + localArrayList);
      }
      return;
    }
    try
    {
      paramToServiceMsg.mergeFrom((byte[])paramObject);
      paramFromServiceMsg = paramToServiceMsg;
      if ((paramFromServiceMsg == null) || (!paramFromServiceMsg.uint32_result.has())) {
        break label436;
      }
      i = paramFromServiceMsg.uint32_result.get();
    }
    catch (InvalidProtocolBufferMicroException paramObject)
    {
      break label224;
      i = -1;
      break label93;
    }
    if (i == 0) {
      paramToServiceMsg = new oidb_0x8b2.RspBody();
    }
    for (;;)
    {
      int j;
      notifyUI(1050, false, new Object[] { str, arrayOfByte, Integer.valueOf(i), Integer.valueOf(k), localArrayList });
    }
  }
  
  private void q(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if ((paramToServiceMsg == null) || (paramFromServiceMsg == null))
    {
      if (QLog.isColorLevel()) {
        QLog.i("Q.hotchat.remainCount", 2, "req == null || res == null");
      }
      return;
    }
    String str = paramToServiceMsg.extraData.getString("troopCode");
    Object[] arrayOfObject = new Object[4];
    arrayOfObject[0] = str;
    arrayOfObject[1] = Boolean.valueOf(false);
    arrayOfObject[2] = "";
    arrayOfObject[3] = "";
    if (paramObject == null)
    {
      if (QLog.isColorLevel()) {
        QLog.i("Q.hotchat.remainCount", 2, "time out or error");
      }
      notifyUI(1053, false, arrayOfObject);
      return;
    }
    if (paramFromServiceMsg.getResultCode() != 1000)
    {
      notifyUI(1053, false, arrayOfObject);
      return;
    }
    paramToServiceMsg = new oidb_sso.OIDBSSOPkg();
    try
    {
      paramToServiceMsg = (oidb_sso.OIDBSSOPkg)paramToServiceMsg.mergeFrom((byte[])paramObject);
      if ((!paramToServiceMsg.uint32_result.has()) || (paramToServiceMsg.uint32_result.get() != 0) || (!paramToServiceMsg.bytes_bodybuffer.has()) || (paramToServiceMsg.bytes_bodybuffer.get() == null))
      {
        notifyUI(1053, false, arrayOfObject);
        return;
      }
    }
    catch (InvalidProtocolBufferMicroException paramToServiceMsg)
    {
      notifyUI(1053, false, arrayOfObject);
      return;
    }
    paramObject = new cmd0x8a7.RspBody();
    for (;;)
    {
      try
      {
        paramObject.mergeFrom(paramToServiceMsg.bytes_bodybuffer.get().toByteArray());
        boolean bool = paramObject.bool_can_at_all.get();
        if (!paramObject.bytes_prompt_msg_1.has()) {
          break label483;
        }
        paramToServiceMsg = paramObject.bytes_prompt_msg_1.get().toStringUtf8();
        if (!paramObject.bytes_prompt_msg_2.has()) {
          break label476;
        }
        paramFromServiceMsg = paramObject.bytes_prompt_msg_2.get().toStringUtf8();
        if (!paramObject.uint32_remain_at_all_count_for_group.has()) {
          break label470;
        }
        i = paramObject.uint32_remain_at_all_count_for_group.get();
        if (paramObject.uint32_remain_at_all_count_for_uin.has())
        {
          j = paramObject.uint32_remain_at_all_count_for_uin.get();
          if (QLog.isColorLevel())
          {
            paramObject = new StringBuilder();
            paramObject.append("handleGetAtAllRemainCountInfo:").append("troopCode:").append(str).append(",groupRemainCnt:").append(i).append(",memberRemainCount:").append(j).append(", beCanAtAll:").append(bool).append(",tips1:").append(paramToServiceMsg).append(",tips2:").append(paramFromServiceMsg);
            QLog.d("Q.hotchat.remainCount", 2, paramObject.toString());
          }
          notifyUI(1053, true, new Object[] { str, Boolean.valueOf(bool), paramToServiceMsg, paramFromServiceMsg });
          return;
        }
      }
      catch (InvalidProtocolBufferMicroException paramToServiceMsg)
      {
        notifyUI(1053, false, arrayOfObject);
        return;
      }
      int j = 0;
      continue;
      label470:
      int i = 0;
      continue;
      label476:
      paramFromServiceMsg = "";
      continue;
      label483:
      paramToServiceMsg = "";
    }
  }
  
  public void a()
  {
    a(0);
    if (bdne.i(this.app.getApplication(), getCurrentAccountUin())) {
      a(2);
    }
    if (bdne.h(this.app.getApplication(), getCurrentAccountUin())) {
      ((bema)this.app.a(107)).a(new aluk(this));
    }
  }
  
  public void a(int paramInt)
  {
    if (QLog.isColorLevel()) {
      auwz.a("HotChatHandler", new Object[] { "getMyHotChatList()", Boolean.valueOf(this.jdField_a_of_type_Boolean) });
    }
    long l = Long.parseLong(this.app.getAccount());
    Object localObject = new GetJoinedHotChatList.ReqBody();
    ((GetJoinedHotChatList.ReqBody)localObject).uint64_uin.set(l);
    ((GetJoinedHotChatList.ReqBody)localObject).uint32_req_type.set(3);
    localObject = makeOIDBPkg("OidbSvc.0x8a4", 2212, paramInt, ((GetJoinedHotChatList.ReqBody)localObject).toByteArray());
    ((ToServiceMsg)localObject).setTimeout(10000L);
    ((ToServiceMsg)localObject).extraData.putInt("serviceType", paramInt);
    sendPbReq((ToServiceMsg)localObject);
    this.jdField_a_of_type_Boolean = true;
  }
  
  public void a(long paramLong, String paramString)
  {
    oidb_0x81f.ReqBody localReqBody = new oidb_0x81f.ReqBody();
    localReqBody.uint64_uin.set(paramLong);
    try
    {
      localReqBody.gc.set(Long.parseLong(paramString));
      paramString = new oidb_0x81f.GetAuthDataReq();
      paramString.uint32_auth.set(1);
      localReqBody.msg_auth_data.set(paramString);
      paramString = makeOIDBPkg("OidbSvc.0x81f", 2079, 0, localReqBody.toByteArray());
      paramString.extraData.putLong("uin", paramLong);
      sendPbReq(paramString);
      return;
    }
    catch (NumberFormatException localNumberFormatException)
    {
      while (!QLog.isColorLevel()) {}
      QLog.e("HotChatHandler", 2, "getGlobalAdmin, NumberFormatException. troopUin:" + paramString);
    }
  }
  
  public void a(QQAppInterface paramQQAppInterface, String paramString, List<Long> paramList, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("HotChatHandlerQ.hotchat.setadmin", 2, "setHotChatAdminFlag:|serviceType:" + paramInt);
    }
    if ((paramList == null) || (paramList.isEmpty())) {
      if (QLog.isColorLevel()) {
        QLog.e("HotChatHandlerQ.hotchat.setadmin", 2, "memberUins is empty!");
      }
    }
    ToServiceMsg localToServiceMsg;
    for (;;)
    {
      return;
      if ((paramInt != 5) && (paramInt != 6))
      {
        if (QLog.isColorLevel()) {
          QLog.e("HotChatHandlerQ.hotchat.setadmin", 2, "serviceType is not correct!");
        }
      }
      else
      {
        oidb_0x8b2.ReqBody localReqBody = new oidb_0x8b2.ReqBody();
        try
        {
          localReqBody.uint64_group_code.set(Long.parseLong(paramString));
          HotChatInfo localHotChatInfo = ((HotChatManager)paramQQAppInterface.getManager(60)).a(paramString);
          localToServiceMsg = null;
          paramQQAppInterface = localToServiceMsg;
          if (localHotChatInfo != null)
          {
            paramQQAppInterface = localToServiceMsg;
            if (localHotChatInfo.uuid != null)
            {
              paramQQAppInterface = localHotChatInfo.uuid.getBytes();
              localReqBody.string_hot_group_id.set(ByteStringMicro.copyFrom(paramQQAppInterface));
            }
          }
          localReqBody.uint64_administrator_uin.set(paramList);
          localToServiceMsg = makeOIDBPkg("OidbSvc.0x8b2", 2226, paramInt, localReqBody.toByteArray());
          localToServiceMsg.extraData.putInt("serviceType", paramInt);
          localToServiceMsg.extraData.putByteArray("uid", paramQQAppInterface);
          localToServiceMsg.extraData.putString("troop_uin", paramString);
          paramQQAppInterface = new ArrayList();
          paramInt = 0;
          while (paramInt < paramList.size())
          {
            paramQQAppInterface.add(paramList.get(paramInt) + "");
            paramInt += 1;
          }
          if (!QLog.isColorLevel()) {}
        }
        catch (NumberFormatException paramQQAppInterface) {}
      }
    }
    QLog.e("HotChatHandlerQ.hotchat.setadmin", 2, "NumberFormatException ,troopUinis not correct," + paramString);
    return;
    localToServiceMsg.extraData.putStringArrayList("uins", paramQQAppInterface);
    sendPbReq(localToServiceMsg);
  }
  
  public void a(HotChatInfo paramHotChatInfo, HotChatManager.HotChatStateWrapper paramHotChatStateWrapper)
  {
    if (QLog.isColorLevel()) {
      auwz.a("HotChatHandler", new Object[] { "exitHotChat", paramHotChatInfo, paramHotChatStateWrapper });
    }
    if (paramHotChatInfo == null)
    {
      notifyUI(1033, false, new Object[] { "", jdField_a_of_type_JavaLangString });
      return;
    }
    Object localObject = new oidb_0x89b.ExitPublicGroupReqBody();
    ((oidb_0x89b.ExitPublicGroupReqBody)localObject).uint64_visitor_uin.set(aloz.a(this.app.getCurrentAccountUin()));
    oidb_0x89b.ReqBody localReqBody = new oidb_0x89b.ReqBody();
    localReqBody.uint64_group_code.set(aloz.a(paramHotChatInfo.troopUin));
    localReqBody.uint32_req_type.set(5);
    localReqBody.msg_exit_group.set((MessageMicro)localObject);
    localObject = makeOIDBPkg("OidbSvc.0x89b_3", 2203, 3, localReqBody.toByteArray(), 10000L);
    ((ToServiceMsg)localObject).extraData.putBoolean("isJoin", false);
    ((ToServiceMsg)localObject).extraData.putString("troopUin", paramHotChatInfo.troopUin);
    ((ToServiceMsg)localObject).extraData.putSerializable("targetHotChatState", paramHotChatStateWrapper);
    ((ToServiceMsg)localObject).setTimeout(10000L);
    sendPbReq((ToServiceMsg)localObject);
  }
  
  /* Error */
  public void a(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    // Byte code:
    //   0: new 104	java/util/ArrayList
    //   3: dup
    //   4: invokespecial 655	java/util/ArrayList:<init>	()V
    //   7: astore 5
    //   9: new 104	java/util/ArrayList
    //   12: dup
    //   13: invokespecial 655	java/util/ArrayList:<init>	()V
    //   16: astore 6
    //   18: aload_1
    //   19: ifnull +17 -> 36
    //   22: aload_3
    //   23: ifnull +13 -> 36
    //   26: aload_2
    //   27: invokevirtual 524	com/tencent/qphone/base/remote/FromServiceMsg:getResultCode	()I
    //   30: sipush 1000
    //   33: if_icmpeq +26 -> 59
    //   36: aload_0
    //   37: sipush 1058
    //   40: iconst_0
    //   41: iconst_2
    //   42: anewarray 435	java/lang/Object
    //   45: dup
    //   46: iconst_0
    //   47: aload 5
    //   49: aastore
    //   50: dup
    //   51: iconst_1
    //   52: aload 6
    //   54: aastore
    //   55: invokevirtual 419	aluj:notifyUI	(IZLjava/lang/Object;)V
    //   58: return
    //   59: new 526	tencent/im/oidb/oidb_sso$OIDBSSOPkg
    //   62: dup
    //   63: invokespecial 527	tencent/im/oidb/oidb_sso$OIDBSSOPkg:<init>	()V
    //   66: astore_1
    //   67: aload_1
    //   68: aload_3
    //   69: checkcast 529	[B
    //   72: checkcast 529	[B
    //   75: invokevirtual 533	tencent/im/oidb/oidb_sso$OIDBSSOPkg:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   78: pop
    //   79: aload_1
    //   80: ifnull +178 -> 258
    //   83: aload_1
    //   84: getfield 536	tencent/im/oidb/oidb_sso$OIDBSSOPkg:uint32_result	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   87: invokevirtual 539	com/tencent/mobileqq/pb/PBUInt32Field:has	()Z
    //   90: ifeq +168 -> 258
    //   93: aload_1
    //   94: getfield 536	tencent/im/oidb/oidb_sso$OIDBSSOPkg:uint32_result	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   97: invokevirtual 542	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   100: ifne -42 -> 58
    //   103: new 1218	tencent/im/oidb/cmd0x62c/oidb_cmd0x62c$RspBody
    //   106: dup
    //   107: invokespecial 1219	tencent/im/oidb/cmd0x62c/oidb_cmd0x62c$RspBody:<init>	()V
    //   110: astore_2
    //   111: aload_2
    //   112: aload_1
    //   113: getfield 579	tencent/im/oidb/oidb_sso$OIDBSSOPkg:bytes_bodybuffer	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   116: invokevirtual 582	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   119: invokevirtual 583	com/tencent/mobileqq/pb/ByteStringMicro:toByteArray	()[B
    //   122: invokevirtual 1220	tencent/im/oidb/cmd0x62c/oidb_cmd0x62c$RspBody:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   125: pop
    //   126: new 104	java/util/ArrayList
    //   129: dup
    //   130: invokespecial 655	java/util/ArrayList:<init>	()V
    //   133: pop
    //   134: aload_2
    //   135: getfield 1223	tencent/im/oidb/cmd0x62c/oidb_cmd0x62c$RspBody:msg_tinyid_info	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   138: invokevirtual 654	com/tencent/mobileqq/pb/PBRepeatMessageField:get	()Ljava/util/List;
    //   141: astore_1
    //   142: iconst_0
    //   143: istore 4
    //   145: iload 4
    //   147: aload_1
    //   148: invokeinterface 739 1 0
    //   153: if_icmpge +128 -> 281
    //   156: aload 6
    //   158: aload_1
    //   159: iload 4
    //   161: invokeinterface 742 2 0
    //   166: checkcast 1225	tencent/im/oidb/cmd0x62c/oidb_cmd0x62c$TinyIDInfo
    //   169: getfield 1228	tencent/im/oidb/cmd0x62c/oidb_cmd0x62c$TinyIDInfo:uint64_tinyid	Lcom/tencent/mobileqq/pb/PBUInt64Field;
    //   172: invokevirtual 771	com/tencent/mobileqq/pb/PBUInt64Field:get	()J
    //   175: invokestatic 598	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   178: invokevirtual 854	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   181: pop
    //   182: aload 5
    //   184: aload_1
    //   185: iload 4
    //   187: invokeinterface 742 2 0
    //   192: checkcast 1225	tencent/im/oidb/cmd0x62c/oidb_cmd0x62c$TinyIDInfo
    //   195: getfield 1229	tencent/im/oidb/cmd0x62c/oidb_cmd0x62c$TinyIDInfo:uint64_uin	Lcom/tencent/mobileqq/pb/PBUInt64Field;
    //   198: invokevirtual 771	com/tencent/mobileqq/pb/PBUInt64Field:get	()J
    //   201: invokestatic 598	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   204: invokevirtual 854	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   207: pop
    //   208: iload 4
    //   210: iconst_1
    //   211: iadd
    //   212: istore 4
    //   214: goto -69 -> 145
    //   217: astore_1
    //   218: invokestatic 280	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   221: ifeq +14 -> 235
    //   224: ldc_w 282
    //   227: iconst_2
    //   228: aload_1
    //   229: invokevirtual 811	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException:toString	()Ljava/lang/String;
    //   232: invokestatic 415	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   235: aload_0
    //   236: sipush 1058
    //   239: iconst_0
    //   240: iconst_2
    //   241: anewarray 435	java/lang/Object
    //   244: dup
    //   245: iconst_0
    //   246: aload 5
    //   248: aastore
    //   249: dup
    //   250: iconst_1
    //   251: aload 6
    //   253: aastore
    //   254: invokevirtual 419	aluj:notifyUI	(IZLjava/lang/Object;)V
    //   257: return
    //   258: aload_0
    //   259: sipush 1058
    //   262: iconst_0
    //   263: iconst_2
    //   264: anewarray 435	java/lang/Object
    //   267: dup
    //   268: iconst_0
    //   269: aload 5
    //   271: aastore
    //   272: dup
    //   273: iconst_1
    //   274: aload 6
    //   276: aastore
    //   277: invokevirtual 419	aluj:notifyUI	(IZLjava/lang/Object;)V
    //   280: return
    //   281: aload_0
    //   282: sipush 1058
    //   285: iconst_1
    //   286: iconst_2
    //   287: anewarray 435	java/lang/Object
    //   290: dup
    //   291: iconst_0
    //   292: aload 5
    //   294: aastore
    //   295: dup
    //   296: iconst_1
    //   297: aload 6
    //   299: aastore
    //   300: invokevirtual 419	aluj:notifyUI	(IZLjava/lang/Object;)V
    //   303: return
    //   304: astore_1
    //   305: aload_0
    //   306: sipush 1058
    //   309: iconst_0
    //   310: iconst_2
    //   311: anewarray 435	java/lang/Object
    //   314: dup
    //   315: iconst_0
    //   316: aload 5
    //   318: aastore
    //   319: dup
    //   320: iconst_1
    //   321: aload 6
    //   323: aastore
    //   324: invokevirtual 419	aluj:notifyUI	(IZLjava/lang/Object;)V
    //   327: invokestatic 280	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   330: ifeq -272 -> 58
    //   333: ldc_w 282
    //   336: iconst_2
    //   337: aload_1
    //   338: invokevirtual 811	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException:toString	()Ljava/lang/String;
    //   341: invokestatic 415	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   344: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	345	0	this	aluj
    //   0	345	1	paramToServiceMsg	ToServiceMsg
    //   0	345	2	paramFromServiceMsg	FromServiceMsg
    //   0	345	3	paramObject	Object
    //   143	70	4	i	int
    //   7	310	5	localArrayList1	ArrayList
    //   16	306	6	localArrayList2	ArrayList
    // Exception table:
    //   from	to	target	type
    //   59	79	217	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   111	142	304	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   145	208	304	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   281	303	304	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
  }
  
  public void a(String paramString)
  {
    notifyUI(1056, true, new Object[] { paramString, b });
  }
  
  public void a(String paramString1, String paramString2)
  {
    notifyUI(1055, true, new Object[] { paramString1, paramString2 });
  }
  
  public void a(String paramString1, String paramString2, String paramString3)
  {
    notifyUI(1054, true, new Object[] { paramString1, paramString2, paramString3 });
  }
  
  public void a(ArrayList<String> paramArrayList)
  {
    oidb_cmd0x62c.ReqBody localReqBody = new oidb_cmd0x62c.ReqBody();
    ArrayList localArrayList = new ArrayList();
    int i = 0;
    while (i < paramArrayList.size())
    {
      localArrayList.add(Long.valueOf((String)paramArrayList.get(i)));
      i += 1;
    }
    localReqBody.uint64_tinyid.set(localArrayList);
    sendPbReq(makeOIDBPkg("OidbSvc.0x62c_4", 1580, 4, localReqBody.toByteArray(), 10000L));
  }
  
  public void a(Common.WifiPOIInfo paramWifiPOIInfo, boolean paramBoolean, int paramInt1, int paramInt2)
  {
    if (QLog.isColorLevel()) {}
    try
    {
      QLog.i("HotChatHandler", 2, "joinHotChat() WifiPOIInfo = " + paramWifiPOIInfo.bytes_name.get().toStringUtf8() + ", " + paramWifiPOIInfo.bytes_uid.get().toStringUtf8());
      label61:
      int i = 0;
      String str = null;
      if (paramWifiPOIInfo.uint32_group_uin.has()) {
        str = String.valueOf(bdeu.a(paramWifiPOIInfo.uint32_group_uin.get()));
      }
      if ((str == null) || (str.equals("")) || (str.equals("0"))) {
        i = 1;
      }
      if (i != 0)
      {
        a(paramWifiPOIInfo, paramBoolean, paramInt2);
        return;
      }
      try
      {
        a(paramWifiPOIInfo.bytes_uid.get().toStringUtf8(), paramInt2, true, paramInt1);
        return;
      }
      catch (Exception paramWifiPOIInfo)
      {
        paramWifiPOIInfo.printStackTrace();
        return;
      }
    }
    catch (Exception localException)
    {
      break label61;
    }
  }
  
  public boolean a(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.i("HotChatHandler", 2, "getUserCreateHotChatAnnounce.groupcode=" + paramString);
    }
    if (TextUtils.isEmpty(paramString)) {
      return false;
    }
    Object localObject2 = new oidb_0x88d.GroupInfo();
    ((oidb_0x88d.GroupInfo)localObject2).uint64_group_owner.set(1L);
    ((oidb_0x88d.GroupInfo)localObject2).string_group_memo.set(ByteStringMicro.copyFrom("1".getBytes()));
    Object localObject1 = new oidb_0x88d.ReqGroupInfo();
    ((oidb_0x88d.ReqGroupInfo)localObject1).uint64_group_code.set(Long.valueOf(paramString).longValue());
    ((oidb_0x88d.ReqGroupInfo)localObject1).stgroupinfo.set((MessageMicro)localObject2);
    localObject2 = new oidb_0x88d.ReqBody();
    ((oidb_0x88d.ReqBody)localObject2).uint32_appid.set(this.app.getAppid());
    ((oidb_0x88d.ReqBody)localObject2).stzreqgroupinfo.add((MessageMicro)localObject1);
    localObject1 = makeOIDBPkg("OidbSvc.0x88d_0", 2189, 6, ((oidb_0x88d.ReqBody)localObject2).toByteArray());
    ((ToServiceMsg)localObject1).extraData.putString("groupcode", paramString);
    ((ToServiceMsg)localObject1).extraData.putInt("serviceType", 6);
    sendPbReq((ToServiceMsg)localObject1);
    return true;
  }
  
  public boolean a(String paramString, int paramInt, boolean paramBoolean)
  {
    return a(paramString, paramInt, paramBoolean, 4);
  }
  
  public boolean a(String paramString, int paramInt1, boolean paramBoolean, int paramInt2)
  {
    return a(paramString, paramInt1, paramBoolean, paramInt2, -1);
  }
  
  public boolean a(String paramString, int paramInt1, boolean paramBoolean, int paramInt2, int paramInt3)
  {
    if ((paramString == null) || (paramString.length() == 0)) {}
    do
    {
      return false;
      localObject2 = a(false);
      localObject1 = localObject2;
      if (localObject2 == null)
      {
        localObject1 = localObject2;
        if (!paramBoolean) {
          localObject1 = new LBS.LBSInfo();
        }
      }
      if (localObject1 != null) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.i("HotChatHandler", 2, "quickJoinHotChat, lbs is null, needLBS = " + paramBoolean);
    return false;
    Object localObject2 = new oidb_0x8ab.ReqBody();
    ((oidb_0x8ab.ReqBody)localObject2).hotnamecode.set(ByteStringMicro.copyFromUtf8(paramString));
    ((oidb_0x8ab.ReqBody)localObject2).lbs_info.set((MessageMicro)localObject1);
    ((oidb_0x8ab.ReqBody)localObject2).version_flag.set(1);
    Object localObject1 = makeOIDBPkg("OidbSvc.0x8ab", 2219, 0, ((oidb_0x8ab.ReqBody)localObject2).toByteArray());
    ((ToServiceMsg)localObject1).extraData.putString("hotnamecode", paramString);
    ((ToServiceMsg)localObject1).extraData.putInt("HOTCHAT_EXTRA_FLAG", paramInt1);
    ((ToServiceMsg)localObject1).extraData.putInt("preHotChatState", paramInt2);
    if (paramInt3 > 0) {
      ((ToServiceMsg)localObject1).extraData.putInt("apolloGameId", paramInt3);
    }
    sendPbReq((ToServiceMsg)localObject1);
    return true;
  }
  
  public boolean a(String paramString1, String paramString2)
  {
    if (QLog.isColorLevel()) {
      QLog.i("HotChatHandler", 2, "setUserCreateHotChatAnnounce.groupcode=" + paramString1 + ",memo=" + paramString2);
    }
    if ((TextUtils.isEmpty(paramString1)) || (paramString2 == null)) {
      return false;
    }
    oidb_0x89a.groupinfo localgroupinfo = new oidb_0x89a.groupinfo();
    localgroupinfo.string_group_memo.set(ByteStringMicro.copyFrom(paramString2.getBytes()));
    paramString2 = this.app.getCurrentAccountUin();
    oidb_0x89a.ReqBody localReqBody = new oidb_0x89a.ReqBody();
    localReqBody.uint64_group_code.set(Long.valueOf(paramString1).longValue());
    localReqBody.uint64_original_operator_uin.set(Long.valueOf(paramString2).longValue());
    localReqBody.st_group_info.set(localgroupinfo);
    paramString2 = makeOIDBPkg("OidbSvc.0x89a_0", 2202, 0, localReqBody.toByteArray());
    paramString2.extraData.putString("groupcode", paramString1);
    sendPbReq(paramString2);
    return true;
  }
  
  public boolean a(String paramString1, String paramString2, String paramString3, String paramString4, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.i("HotChatHandlerQ.hotchat.hotchat_kick_mem_by_global_admin", 2, "kickHotChatMemberByGlobalAdmin.groupcode=" + paramString1 + ",groupuin=" + paramString2 + ",memberuin=" + paramString3);
    }
    if ((TextUtils.isEmpty(paramString1)) || (TextUtils.isEmpty(paramString2)) || (TextUtils.isEmpty(paramString3))) {
      return false;
    }
    Object localObject2 = new ArrayList();
    try
    {
      ((List)localObject2).add(Long.valueOf(Long.parseLong(paramString3)));
      Object localObject1 = new oidb_0x823.KickPublicGroupVisitorReqBody();
      ((oidb_0x823.KickPublicGroupVisitorReqBody)localObject1).rpt_uint64_visitor_uin.set((List)localObject2);
      localObject2 = new oidb_0x823.PlayerDeviceInfo();
      ((oidb_0x823.PlayerDeviceInfo)localObject2).int32_client_type.set(1);
      ((oidb_0x823.PlayerDeviceInfo)localObject2).uint32_portal.set(paramInt);
      oidb_0x823.ReqBody localReqBody = new oidb_0x823.ReqBody();
      localReqBody.msg_kick_visitor.set((MessageMicro)localObject1);
      localReqBody.uint64_group_uin.set(Long.valueOf(paramString2).longValue());
      localReqBody.uint64_group_code.set(Long.valueOf(paramString1).longValue());
      localReqBody.msg_req_info.set((MessageMicro)localObject2);
      localObject1 = makeOIDBPkg("OidbSvc.0x823_0", 2083, 0, localReqBody.toByteArray());
      ((ToServiceMsg)localObject1).extraData.putString("groupcode", paramString1);
      ((ToServiceMsg)localObject1).extraData.putString("groupuin", paramString2);
      ((ToServiceMsg)localObject1).extraData.putString("memberuin", paramString3);
      ((ToServiceMsg)localObject1).extraData.putBoolean("kick", true);
      ((ToServiceMsg)localObject1).extraData.putString("nickname", paramString4);
      sendPbReq((ToServiceMsg)localObject1);
      return true;
    }
    catch (NumberFormatException paramString1)
    {
      if (QLog.isColorLevel()) {
        QLog.i("HotChatHandlerQ.hotchat.hotchat_kick_mem_by_global_admin", 2, "kickHotChatMemberByGlobalAdmin.NumberFormatException");
      }
    }
    return false;
  }
  
  public boolean a(byte[] paramArrayOfByte, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.i("HotChatHandlerQ.hotchat.oidb_0x8b2", 2, "getHotChatAnnounce.uid=" + new String(paramArrayOfByte) + ", troopUin=" + paramString);
    }
    if ((paramArrayOfByte == null) || (paramArrayOfByte.length <= 0)) {
      return false;
    }
    Object localObject = new oidb_0x8b2.ReqBody();
    ((oidb_0x8b2.ReqBody)localObject).string_hot_group_id.set(ByteStringMicro.copyFrom(paramArrayOfByte));
    localObject = makeOIDBPkg("OidbSvc.0x8b2", 2226, 2, ((oidb_0x8b2.ReqBody)localObject).toByteArray());
    ((ToServiceMsg)localObject).extraData.putInt("serviceType", 2);
    ((ToServiceMsg)localObject).extraData.putByteArray("uid", paramArrayOfByte);
    ((ToServiceMsg)localObject).extraData.putString("troop_uin", paramString);
    sendPbReq((ToServiceMsg)localObject);
    return true;
  }
  
  public boolean a(byte[] paramArrayOfByte, String paramString1, String paramString2)
  {
    if (QLog.isColorLevel()) {
      QLog.i("HotChatHandler", 2, "setHotChatAnnounce.memo=" + paramString1 + ",url=" + paramString2 + ",uid=" + new String(paramArrayOfByte));
    }
    if ((paramArrayOfByte == null) || (paramArrayOfByte.length <= 0)) {
      return false;
    }
    String str = paramString1;
    if (TextUtils.isEmpty(paramString1)) {
      str = "";
    }
    paramString1 = paramString2;
    if (TextUtils.isEmpty(paramString2)) {
      paramString1 = "";
    }
    paramString2 = new oidb_0x8b3.ReqBody();
    paramString2.string_hot_group_id.set(ByteStringMicro.copyFrom(paramArrayOfByte));
    oidb_0x8b3.groupinfo localgroupinfo = new oidb_0x8b3.groupinfo();
    localgroupinfo.string_group_memo.set(ByteStringMicro.copyFrom(str.getBytes()));
    localgroupinfo.string_jumping_url.set(ByteStringMicro.copyFrom(paramString1.getBytes()));
    paramString2.st_group_info.set(localgroupinfo);
    paramString1 = makeOIDBPkg("OidbSvc.0x8b3", 2227, 0, paramString2.toByteArray());
    paramString1.extraData.putByteArray("uid", paramArrayOfByte);
    sendPbReq(paramString1);
    return true;
  }
  
  /* Error */
  public void b(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    // Byte code:
    //   0: new 284	java/lang/StringBuilder
    //   3: dup
    //   4: invokespecial 285	java/lang/StringBuilder:<init>	()V
    //   7: aload_1
    //   8: getfield 314	com/tencent/qphone/base/remote/ToServiceMsg:extraData	Landroid/os/Bundle;
    //   11: ldc_w 1143
    //   14: invokevirtual 986	android/os/Bundle:getLong	(Ljava/lang/String;)J
    //   17: invokevirtual 1402	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   20: ldc_w 694
    //   23: invokevirtual 291	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   26: invokevirtual 294	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   29: astore 7
    //   31: new 526	tencent/im/oidb/oidb_sso$OIDBSSOPkg
    //   34: dup
    //   35: invokespecial 527	tencent/im/oidb/oidb_sso$OIDBSSOPkg:<init>	()V
    //   38: astore_1
    //   39: aload_1
    //   40: aload_3
    //   41: checkcast 529	[B
    //   44: checkcast 529	[B
    //   47: invokevirtual 533	tencent/im/oidb/oidb_sso$OIDBSSOPkg:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   50: pop
    //   51: aload_1
    //   52: astore_2
    //   53: iconst_m1
    //   54: istore 5
    //   56: iload 5
    //   58: istore 4
    //   60: aload_2
    //   61: ifnull +26 -> 87
    //   64: iload 5
    //   66: istore 4
    //   68: aload_2
    //   69: getfield 536	tencent/im/oidb/oidb_sso$OIDBSSOPkg:uint32_result	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   72: invokevirtual 539	com/tencent/mobileqq/pb/PBUInt32Field:has	()Z
    //   75: ifeq +12 -> 87
    //   78: aload_2
    //   79: getfield 536	tencent/im/oidb/oidb_sso$OIDBSSOPkg:uint32_result	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   82: invokevirtual 542	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   85: istore 4
    //   87: iload 4
    //   89: ifne +235 -> 324
    //   92: new 1404	tencent/im/oidb/hotchat/oidb_0x81f$RspBody
    //   95: dup
    //   96: invokespecial 1405	tencent/im/oidb/hotchat/oidb_0x81f$RspBody:<init>	()V
    //   99: astore_1
    //   100: aload_1
    //   101: aload_2
    //   102: getfield 579	tencent/im/oidb/oidb_sso$OIDBSSOPkg:bytes_bodybuffer	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   105: invokevirtual 582	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   108: invokevirtual 583	com/tencent/mobileqq/pb/ByteStringMicro:toByteArray	()[B
    //   111: invokevirtual 1406	tencent/im/oidb/hotchat/oidb_0x81f$RspBody:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   114: pop
    //   115: aload_1
    //   116: getfield 1409	tencent/im/oidb/hotchat/oidb_0x81f$RspBody:msg_auth_data	Ltencent/im/oidb/hotchat/oidb_0x81f$GetAuthDataRsp;
    //   119: invokevirtual 1412	tencent/im/oidb/hotchat/oidb_0x81f$GetAuthDataRsp:has	()Z
    //   122: ifeq +244 -> 366
    //   125: aload_1
    //   126: getfield 1409	tencent/im/oidb/hotchat/oidb_0x81f$RspBody:msg_auth_data	Ltencent/im/oidb/hotchat/oidb_0x81f$GetAuthDataRsp;
    //   129: invokevirtual 1413	tencent/im/oidb/hotchat/oidb_0x81f$GetAuthDataRsp:get	()Lcom/tencent/mobileqq/pb/MessageMicro;
    //   132: checkcast 1411	tencent/im/oidb/hotchat/oidb_0x81f$GetAuthDataRsp
    //   135: astore_1
    //   136: aload_1
    //   137: getfield 1414	tencent/im/oidb/hotchat/oidb_0x81f$GetAuthDataRsp:uint32_auth	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   140: invokevirtual 542	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   143: istore 4
    //   145: aload_0
    //   146: getfield 423	aluj:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   149: bipush 60
    //   151: invokevirtual 429	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   154: checkcast 251	com/tencent/mobileqq/app/HotChatManager
    //   157: astore_2
    //   158: iload 4
    //   160: ifne +126 -> 286
    //   163: iconst_1
    //   164: istore 6
    //   166: aload_2
    //   167: iload 6
    //   169: invokevirtual 1416	com/tencent/mobileqq/app/HotChatManager:a	(Z)V
    //   172: iload 4
    //   174: ifne +14 -> 188
    //   177: aload_2
    //   178: aload_1
    //   179: getfield 1419	tencent/im/oidb/hotchat/oidb_0x81f$GetAuthDataRsp:uint64_timestamp	Lcom/tencent/mobileqq/pb/PBUInt64Field;
    //   182: invokevirtual 771	com/tencent/mobileqq/pb/PBUInt64Field:get	()J
    //   185: invokevirtual 1421	com/tencent/mobileqq/app/HotChatManager:a	(J)V
    //   188: aload_0
    //   189: sipush 1051
    //   192: iconst_1
    //   193: iconst_2
    //   194: anewarray 435	java/lang/Object
    //   197: dup
    //   198: iconst_0
    //   199: aload 7
    //   201: aastore
    //   202: dup
    //   203: iconst_1
    //   204: iload 4
    //   206: invokestatic 448	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   209: aastore
    //   210: invokevirtual 419	aluj:notifyUI	(IZLjava/lang/Object;)V
    //   213: invokestatic 280	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   216: ifeq +42 -> 258
    //   219: ldc_w 1015
    //   222: iconst_2
    //   223: new 284	java/lang/StringBuilder
    //   226: dup
    //   227: invokespecial 285	java/lang/StringBuilder:<init>	()V
    //   230: ldc_w 1423
    //   233: invokevirtual 291	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   236: aload 7
    //   238: invokevirtual 291	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   241: ldc_w 1425
    //   244: invokevirtual 291	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   247: iload 4
    //   249: invokevirtual 364	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   252: invokevirtual 294	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   255: invokestatic 415	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   258: return
    //   259: astore_3
    //   260: aconst_null
    //   261: astore_1
    //   262: aload_1
    //   263: astore_2
    //   264: invokestatic 280	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   267: ifeq -214 -> 53
    //   270: ldc_w 282
    //   273: iconst_2
    //   274: aload_3
    //   275: invokevirtual 811	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException:toString	()Ljava/lang/String;
    //   278: invokestatic 415	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   281: aload_1
    //   282: astore_2
    //   283: goto -230 -> 53
    //   286: iconst_0
    //   287: istore 6
    //   289: goto -123 -> 166
    //   292: astore_1
    //   293: iconst_0
    //   294: istore 5
    //   296: iload 5
    //   298: istore 4
    //   300: invokestatic 280	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   303: ifeq -115 -> 188
    //   306: ldc_w 282
    //   309: iconst_2
    //   310: aload_1
    //   311: invokevirtual 743	java/lang/Exception:toString	()Ljava/lang/String;
    //   314: invokestatic 415	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   317: iload 5
    //   319: istore 4
    //   321: goto -133 -> 188
    //   324: aload_0
    //   325: sipush 1051
    //   328: iconst_0
    //   329: iconst_2
    //   330: anewarray 435	java/lang/Object
    //   333: dup
    //   334: iconst_0
    //   335: aload 7
    //   337: aastore
    //   338: dup
    //   339: iconst_1
    //   340: iconst_0
    //   341: invokestatic 448	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   344: aastore
    //   345: invokevirtual 419	aluj:notifyUI	(IZLjava/lang/Object;)V
    //   348: iconst_0
    //   349: istore 4
    //   351: goto -138 -> 213
    //   354: astore_1
    //   355: iload 4
    //   357: istore 5
    //   359: goto -63 -> 296
    //   362: astore_3
    //   363: goto -101 -> 262
    //   366: iconst_0
    //   367: istore 4
    //   369: goto -181 -> 188
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	372	0	this	aluj
    //   0	372	1	paramToServiceMsg	ToServiceMsg
    //   0	372	2	paramFromServiceMsg	FromServiceMsg
    //   0	372	3	paramObject	Object
    //   58	310	4	i	int
    //   54	304	5	j	int
    //   164	124	6	bool	boolean
    //   29	307	7	str	String
    // Exception table:
    //   from	to	target	type
    //   31	39	259	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   100	145	292	java/lang/Exception
    //   145	158	354	java/lang/Exception
    //   166	172	354	java/lang/Exception
    //   177	188	354	java/lang/Exception
    //   39	51	362	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
  }
  
  public void b(String paramString1, String paramString2)
  {
    notifyUI(1057, true, new Object[] { paramString1, paramString2 });
  }
  
  public void b(String paramString1, String paramString2, String paramString3)
  {
    amkl.a(this.app, String.valueOf(paramString1), paramString3 + BaseApplicationImpl.getContext().getString(2131693425), 1, false, true);
    notifyUI(1037, true, new Object[] { paramString1, Integer.valueOf(0), paramString2, "" });
  }
  
  public boolean b(String paramString1, String paramString2, String paramString3, String paramString4, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.i("HotChatHandler", 2, "kickHotChatMember.groupcode=" + paramString1 + ",groupuin=" + paramString2 + ",memberuin=" + paramString3);
    }
    if ((TextUtils.isEmpty(paramString1)) || (TextUtils.isEmpty(paramString2)) || (TextUtils.isEmpty(paramString3))) {
      return false;
    }
    if (this.app.a(true).b()) {
      return a(paramString1, paramString2, paramString3, paramString4, paramInt);
    }
    Object localObject = new oidb_0x89b.KickPublicGroupVisitorReqBody();
    ((oidb_0x89b.KickPublicGroupVisitorReqBody)localObject).rpt_uint64_visitor_uin.add(Long.valueOf(paramString3));
    oidb_0x89b.ReqBody localReqBody = new oidb_0x89b.ReqBody();
    localReqBody.uint64_group_uin.set(Long.valueOf(paramString2).longValue());
    localReqBody.uint64_group_code.set(Long.valueOf(paramString1).longValue());
    localReqBody.uint32_req_type.set(6);
    localReqBody.msg_kick_visitor.set((MessageMicro)localObject);
    localObject = makeOIDBPkg("OidbSvc.0x89b_3", 2203, 5, localReqBody.toByteArray());
    ((ToServiceMsg)localObject).extraData.putString("groupcode", paramString1);
    ((ToServiceMsg)localObject).extraData.putString("groupuin", paramString2);
    ((ToServiceMsg)localObject).extraData.putString("memberuin", paramString3);
    ((ToServiceMsg)localObject).extraData.putBoolean("kick", true);
    ((ToServiceMsg)localObject).extraData.putString("nickname", paramString4);
    sendPbReq((ToServiceMsg)localObject);
    return true;
  }
  
  protected boolean msgCmdFilter(String paramString)
  {
    if (this.allowCmdSet == null)
    {
      this.allowCmdSet = new HashSet();
      this.allowCmdSet.add("OidbSvc.0x8a4");
      this.allowCmdSet.add("OidbSvc.0x89b_3");
      this.allowCmdSet.add("OidbSvc.0x823_0");
      this.allowCmdSet.add("OidbSvc.0x8a2");
      this.allowCmdSet.add("OidbSvc.0x8ab");
      this.allowCmdSet.add("OidbSvc.0x8b3");
      this.allowCmdSet.add("OidbSvc.0x8b2");
      this.allowCmdSet.add("OidbSvc.0x81f");
      this.allowCmdSet.add("OidbSvc.0xa81");
      this.allowCmdSet.add("OidbSvc.0x88d_0");
      this.allowCmdSet.add("OidbSvc.0x89a_0");
      this.allowCmdSet.add("OidbSvc.0x435");
      this.allowCmdSet.add("OidbSvc.0x897_0");
      this.allowCmdSet.add("OidbSvc.0x88d_1");
      this.allowCmdSet.add("OidbSvc.0xa8b");
      this.allowCmdSet.add("OidbSvc.0x8a3_7");
      this.allowCmdSet.add("OidbSvc.0x8a7_0");
      this.allowCmdSet.add("OidbSvc.0x62c_4");
    }
    return !this.allowCmdSet.contains(paramString);
  }
  
  protected Class<? extends alpg> observerClass()
  {
    return aluu.class;
  }
  
  public void onReceive(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    String str = paramFromServiceMsg.getServiceCmd();
    if (msgCmdFilter(str)) {
      if (QLog.isColorLevel()) {
        QLog.d("HotChatHandler", 2, "cmdfilter error=" + str);
      }
    }
    do
    {
      do
      {
        do
        {
          int i;
          do
          {
            do
            {
              do
              {
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
                  if ("OidbSvc.0x8a4".equals(str))
                  {
                    e(paramToServiceMsg, paramFromServiceMsg, paramObject);
                    return;
                  }
                  if (!"OidbSvc.0x89b_3".equals(str)) {
                    break;
                  }
                  if (paramToServiceMsg.extraData.getBoolean("kick", false))
                  {
                    l(paramToServiceMsg, paramFromServiceMsg, paramObject);
                    return;
                  }
                } while (paramToServiceMsg.extraData.getBoolean("isJoin"));
                c(paramToServiceMsg, paramFromServiceMsg, paramObject);
                return;
                if ("OidbSvc.0x823_0".equals(str))
                {
                  k(paramToServiceMsg, paramFromServiceMsg, paramObject);
                  return;
                }
                if ("OidbSvc.0x8a2".equals(str))
                {
                  d(paramToServiceMsg, paramFromServiceMsg, paramObject);
                  return;
                }
                if ("OidbSvc.0x8ab".equals(str))
                {
                  f(paramToServiceMsg, paramFromServiceMsg, paramObject);
                  return;
                }
                if ("OidbSvc.0x8b3".equals(str))
                {
                  g(paramToServiceMsg, paramFromServiceMsg, paramObject);
                  return;
                }
                if (!"OidbSvc.0x8b2".equals(str)) {
                  break;
                }
              } while ((paramToServiceMsg == null) || (paramToServiceMsg.extraData == null));
              i = paramToServiceMsg.extraData.getInt("serviceType");
              if (QLog.isColorLevel()) {
                QLog.d("HotChatHandlerQ.hotchat.oidb_0x8b2", 2, "onReceive, cmd:" + str + "|serviceType:" + i);
              }
              if (i == 2)
              {
                h(paramToServiceMsg, paramFromServiceMsg, paramObject);
                return;
              }
            } while ((i != 5) && (i != 6));
            p(paramToServiceMsg, paramFromServiceMsg, paramObject);
            return;
            if ("OidbSvc.0x81f".equals(str))
            {
              b(paramToServiceMsg, paramFromServiceMsg, paramObject);
              return;
            }
            if ("OidbSvc.0xa81".equals(str))
            {
              m(paramToServiceMsg, paramFromServiceMsg, paramObject);
              return;
            }
            if (!"OidbSvc.0x88d_0".equals(str)) {
              break;
            }
            i = paramToServiceMsg.extraData.getInt("serviceType");
            if (QLog.isColorLevel()) {
              QLog.d("HotChatHandler", 2, "onReceive, cmd:" + str + "|serviceType:" + i);
            }
          } while (6 != i);
          i(paramToServiceMsg, paramFromServiceMsg, paramObject);
          return;
          if ("OidbSvc.0x89a_0".equals(str))
          {
            j(paramToServiceMsg, paramFromServiceMsg, paramObject);
            return;
          }
        } while ("OidbSvc.0x435".equals(str));
        if ("OidbSvc.0x897_0".equals(str))
        {
          o(paramToServiceMsg, paramFromServiceMsg, paramObject);
          return;
        }
        if ("OidbSvc.0x88d_1".equals(str))
        {
          n(paramToServiceMsg, paramFromServiceMsg, paramObject);
          return;
        }
      } while ("OidbSvc.0x8a3_7".equals(str));
      if ("OidbSvc.0x8a7_0".equals(str))
      {
        q(paramToServiceMsg, paramFromServiceMsg, paramObject);
        return;
      }
    } while (!"OidbSvc.0x62c_4".equals(str));
    a(paramToServiceMsg, paramFromServiceMsg, paramObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     aluj
 * JD-Core Version:    0.7.0.1
 */