package NS_MINI_INTERFACE;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class INTERFACE$StAppBasicInfo
  extends MessageMicro<StAppBasicInfo>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBInt32Field feiqiziduan = PBField.initInt32(0);
  public final PBStringField gameCopyrightInfo = PBField.initString("");
  public INTERFACE.StGamePublicationInfo gamePublicationInfo = new INTERFACE.StGamePublicationInfo();
  public INTERFACE.StIdeConfig ideConfig = new INTERFACE.StIdeConfig();
  public final PBInt32Field noNeedRealRecommend = PBField.initInt32(0);
  public final PBStringField operationTags = PBField.initString("");
  public final PBUInt32Field pkgType = PBField.initUInt32(0);
  public INTERFACE.StPluginInfo pluginInfo = new INTERFACE.StPluginInfo();
  public final PBRepeatMessageField<INTERFACE.StAppPreCacheInfo> preCacheList = PBField.initRepeatMessage(INTERFACE.StAppPreCacheInfo.class);
  public final PBRepeatField<String> qualificationInfo = PBField.initRepeat(PBStringField.__repeatHelper__);
  public INTERFACE.StRenderInfo renderInfo = new INTERFACE.StRenderInfo();
  public final PBRepeatMessageField<INTERFACE.StResourcePreCacheInfo> resourcePreCacheList = PBField.initRepeatMessage(INTERFACE.StResourcePreCacheInfo.class);
  public final PBStringField shareId = PBField.initString("");
  public final PBUInt32Field splashScreenAd = PBField.initUInt32(0);
  public final PBStringField splashScreenAdId = PBField.initString("");
  public final PBUInt32Field template = PBField.initUInt32(0);
  public final PBInt64Field usrFileSizeLimit = PBField.initInt64(0L);
  public final PBUInt32Field versionUpdateTime = PBField.initUInt32(0);
  public final PBStringField via = PBField.initString("");
  
  static
  {
    Integer localInteger = Integer.valueOf(0);
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16, 24, 34, 40, 48, 58, 64, 74, 82, 90, 98, 106, 114, 120, 130, 136, 146, 154 }, new String[] { "operationTags", "feiqiziduan", "usrFileSizeLimit", "preCacheList", "versionUpdateTime", "noNeedRealRecommend", "pluginInfo", "pkgType", "renderInfo", "qualificationInfo", "shareId", "via", "ideConfig", "resourcePreCacheList", "splashScreenAd", "splashScreenAdId", "template", "gamePublicationInfo", "gameCopyrightInfo" }, new Object[] { "", localInteger, Long.valueOf(0L), null, localInteger, localInteger, null, localInteger, null, "", "", "", null, null, localInteger, "", localInteger, null, "" }, StAppBasicInfo.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     NS_MINI_INTERFACE.INTERFACE.StAppBasicInfo
 * JD-Core Version:    0.7.0.1
 */