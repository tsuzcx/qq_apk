package NS_MINI_AD;

import NS_COMM.COMM.StCommonExt;
import NS_MINI_INTERFACE.INTERFACE.StApiAppInfo;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;

public final class MiniAppAd$StGetAdRsp
  extends MessageMicro<StGetAdRsp>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public COMM.StCommonExt extInfo = new COMM.StCommonExt();
  public final PBInt64Field iPreLoadLevel = PBField.initInt64(0L);
  public final PBInt64Field iTestId = PBField.initInt64(0L);
  public final PBStringField strAdTemplateJson = PBField.initString("");
  public final PBStringField strAdsJson = PBField.initString("");
  public final PBRepeatMessageField<INTERFACE.StApiAppInfo> vecAppInfo = PBField.initRepeatMessage(INTERFACE.StApiAppInfo.class);
  
  static
  {
    Long localLong = Long.valueOf(0L);
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26, 32, 42, 48 }, new String[] { "extInfo", "strAdsJson", "strAdTemplateJson", "iTestId", "vecAppInfo", "iPreLoadLevel" }, new Object[] { null, "", "", localLong, null, localLong }, StGetAdRsp.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     NS_MINI_AD.MiniAppAd.StGetAdRsp
 * JD-Core Version:    0.7.0.1
 */