package NS_MINI_AD;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBStringField;

public final class MiniAppAd$StAppAdInfo
  extends MessageMicro<StAppAdInfo>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16, 26 }, new String[] { "strAppId", "iPosition", "strAdInfo" }, new Object[] { "", Long.valueOf(0L), "" }, StAppAdInfo.class);
  public final PBInt64Field iPosition = PBField.initInt64(0L);
  public final PBStringField strAdInfo = PBField.initString("");
  public final PBStringField strAppId = PBField.initString("");
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     NS_MINI_AD.MiniAppAd.StAppAdInfo
 * JD-Core Version:    0.7.0.1
 */