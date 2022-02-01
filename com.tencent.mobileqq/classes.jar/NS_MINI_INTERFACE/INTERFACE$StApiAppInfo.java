package NS_MINI_INTERFACE;

import NS_COMM.COMM.StCommonExt;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class INTERFACE$StApiAppInfo
  extends MessageMicro<StApiAppInfo>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public INTERFACE.StApiRightController apiRight = new INTERFACE.StApiRightController();
  public final PBStringField appId = PBField.initString("");
  public INTERFACE.StAppMode appMode = new INTERFACE.StAppMode();
  public final PBStringField appName = PBField.initString("");
  public INTERFACE.StAppFixInfoExt appNoCacheExt = new INTERFACE.StAppFixInfoExt();
  public final PBUInt32Field appType = PBField.initUInt32(0);
  public final PBStringField baselibMiniVersion = PBField.initString("");
  public INTERFACE.StAppBasicInfo basicInfo = new INTERFACE.StAppBasicInfo();
  public final PBRepeatMessageField<INTERFACE.StAppDataCache> dataCache = PBField.initRepeatMessage(INTERFACE.StAppDataCache.class);
  public final PBStringField desc = PBField.initString("");
  public INTERFACE.StDeveloperInfo devInfo = new INTERFACE.StDeveloperInfo();
  public INTERFACE.StDomainConfig domain = new INTERFACE.StDomainConfig();
  public final PBStringField donwLoadUrl = PBField.initString("");
  public final PBRepeatMessageField<INTERFACE.StExtConfigInfo> extConfig = PBField.initRepeatMessage(INTERFACE.StExtConfigInfo.class);
  public final PBStringField extData = PBField.initString("");
  public INTERFACE.StGameCenterInfo extGameCenter = new INTERFACE.StGameCenterInfo();
  public COMM.StCommonExt extInfo = new COMM.StCommonExt();
  public final PBStringField extendData = PBField.initString("");
  public INTERFACE.StFirstPage first = new INTERFACE.StFirstPage();
  public final PBStringField icon = PBField.initString("");
  public final PBInt32Field isRecommend = PBField.initInt32(0);
  public INTERFACE.StMDebugInfo mDebug = new INTERFACE.StMDebugInfo();
  public INTERFACE.StMainPageExtInfo mainExt = new INTERFACE.StMainPageExtInfo();
  public INTERFACE.StOperationInfo operInfo = new INTERFACE.StOperationInfo();
  public final PBRepeatMessageField<INTERFACE.StPublicAccount> pubAccts = PBField.initRepeatMessage(INTERFACE.StPublicAccount.class);
  public final PBRepeatField<String> serviceCategory = PBField.initRepeat(PBStringField.__repeatHelper__);
  public final PBInt32Field skipDomainCheck = PBField.initInt32(0);
  public final PBRepeatMessageField<INTERFACE.StSubPkgInfo> subPkgs = PBField.initRepeatMessage(INTERFACE.StSubPkgInfo.class);
  public final PBInt32Field supportOffline = PBField.initInt32(0);
  public final PBStringField tags = PBField.initString("");
  public final PBEnumField type = PBField.initEnum(0);
  public final PBStringField version = PBField.initString("");
  public final PBStringField versionId = PBField.initString("");
  
  static
  {
    Integer localInteger = Integer.valueOf(0);
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26, 34, 42, 50, 58, 64, 74, 82, 90, 98, 104, 114, 122, 130, 138, 146, 154, 162, 170, 176, 186, 192, 202, 210, 216, 226, 234, 242, 250, 258, 266 }, new String[] { "appId", "appName", "icon", "donwLoadUrl", "version", "desc", "pubAccts", "type", "baselibMiniVersion", "subPkgs", "first", "domain", "appType", "mDebug", "versionId", "apiRight", "dataCache", "mainExt", "devInfo", "extData", "extGameCenter", "isRecommend", "serviceCategory", "supportOffline", "appMode", "operInfo", "skipDomainCheck", "extInfo", "extendData", "tags", "extConfig", "appNoCacheExt", "basicInfo" }, new Object[] { "", "", "", "", "", "", null, localInteger, "", null, null, null, localInteger, null, "", null, null, null, null, "", null, localInteger, "", localInteger, null, null, localInteger, null, "", "", null, null, null }, StApiAppInfo.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     NS_MINI_INTERFACE.INTERFACE.StApiAppInfo
 * JD-Core Version:    0.7.0.1
 */