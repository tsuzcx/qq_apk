package NS_MINI_INTERFACE;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

public final class INTERFACE$StAppDataCache
  extends MessageMicro<StAppDataCache>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18 }, new String[] { "wnsCgiUrl", "cacheKey" }, new Object[] { "", "" }, StAppDataCache.class);
  public final PBStringField cacheKey = PBField.initString("");
  public final PBStringField wnsCgiUrl = PBField.initString("");
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     NS_MINI_INTERFACE.INTERFACE.StAppDataCache
 * JD-Core Version:    0.7.0.1
 */