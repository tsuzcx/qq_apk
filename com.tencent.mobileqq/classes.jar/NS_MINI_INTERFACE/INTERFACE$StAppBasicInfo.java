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
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16, 24, 34, 40, 48, 58, 64, 74, 82, 90, 98, 106 }, new String[] { "operationTags", "feiqiziduan", "usrFileSizeLimit", "preCacheList", "versionUpdateTime", "noNeedRealRecommend", "pluginInfo", "pkgType", "renderInfo", "qualificationInfo", "shareId", "via", "ideConfig" }, new Object[] { "", Integer.valueOf(0), Long.valueOf(0L), null, Integer.valueOf(0), Integer.valueOf(0), null, Integer.valueOf(0), null, "", "", "", null }, StAppBasicInfo.class);
  public final PBInt32Field feiqiziduan = PBField.initInt32(0);
  public INTERFACE.StIdeConfig ideConfig = new INTERFACE.StIdeConfig();
  public final PBInt32Field noNeedRealRecommend = PBField.initInt32(0);
  public final PBStringField operationTags = PBField.initString("");
  public final PBUInt32Field pkgType = PBField.initUInt32(0);
  public INTERFACE.StPluginInfo pluginInfo = new INTERFACE.StPluginInfo();
  public final PBRepeatMessageField<INTERFACE.StAppPreCacheInfo> preCacheList = PBField.initRepeatMessage(INTERFACE.StAppPreCacheInfo.class);
  public final PBRepeatField<String> qualificationInfo = PBField.initRepeat(PBStringField.__repeatHelper__);
  public INTERFACE.StRenderInfo renderInfo = new INTERFACE.StRenderInfo();
  public final PBStringField shareId = PBField.initString("");
  public final PBInt64Field usrFileSizeLimit = PBField.initInt64(0L);
  public final PBUInt32Field versionUpdateTime = PBField.initUInt32(0);
  public final PBStringField via = PBField.initString("");
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     NS_MINI_INTERFACE.INTERFACE.StAppBasicInfo
 * JD-Core Version:    0.7.0.1
 */