package NS_MINI_AD;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class MiniAppAd$DebugInfo
  extends MessageMicro<DebugInfo>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBoolField debug = PBField.initBool(false);
  public final PBUInt32Field debug_adindexid = PBField.initUInt32(0);
  public final PBBoolField nomatch = PBField.initBool(false);
  
  static
  {
    Boolean localBoolean = Boolean.valueOf(false);
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24 }, new String[] { "debug_adindexid", "nomatch", "debug" }, new Object[] { Integer.valueOf(0), localBoolean, localBoolean }, DebugInfo.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     NS_MINI_AD.MiniAppAd.DebugInfo
 * JD-Core Version:    0.7.0.1
 */