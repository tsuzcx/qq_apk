package NS_CERTIFIED_ACCOUNT;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt64Field;

public final class CertifiedAccountMeta$StGPSV2
  extends MessageMicro<StGPSV2>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBInt64Field alt = PBField.initInt64(0L);
  public final PBInt64Field eType = PBField.initInt64(0L);
  public final PBInt64Field lat = PBField.initInt64(0L);
  public final PBInt64Field lon = PBField.initInt64(0L);
  
  static
  {
    Long localLong = Long.valueOf(0L);
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 32 }, new String[] { "lat", "lon", "eType", "alt" }, new Object[] { localLong, localLong, localLong, localLong }, StGPSV2.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta.StGPSV2
 * JD-Core Version:    0.7.0.1
 */