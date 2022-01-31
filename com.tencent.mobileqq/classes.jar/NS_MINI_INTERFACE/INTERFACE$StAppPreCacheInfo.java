package NS_MINI_INTERFACE;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBStringField;

public final class INTERFACE$StAppPreCacheInfo
  extends MessageMicro<StAppPreCacheInfo>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 24 }, new String[] { "getDataUrl", "preCacheKey", "expireTime" }, new Object[] { "", "", Long.valueOf(0L) }, StAppPreCacheInfo.class);
  public final PBInt64Field expireTime = PBField.initInt64(0L);
  public final PBStringField getDataUrl = PBField.initString("");
  public final PBStringField preCacheKey = PBField.initString("");
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     NS_MINI_INTERFACE.INTERFACE.StAppPreCacheInfo
 * JD-Core Version:    0.7.0.1
 */