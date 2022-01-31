package NS_MINI_INTERFACE;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class INTERFACE$StLastVersion
  extends MessageMicro<StLastVersion>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 24, 34, 40 }, new String[] { "custom_version", "inner_version", "release_time", "source_md5", "source_size" }, new Object[] { "", "", Integer.valueOf(0), "", Integer.valueOf(0) }, StLastVersion.class);
  public final PBStringField custom_version = PBField.initString("");
  public final PBStringField inner_version = PBField.initString("");
  public final PBUInt32Field release_time = PBField.initUInt32(0);
  public final PBStringField source_md5 = PBField.initString("");
  public final PBUInt32Field source_size = PBField.initUInt32(0);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     NS_MINI_INTERFACE.INTERFACE.StLastVersion
 * JD-Core Version:    0.7.0.1
 */