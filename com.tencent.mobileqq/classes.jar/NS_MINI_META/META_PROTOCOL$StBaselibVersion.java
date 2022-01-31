package NS_MINI_META;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

public final class META_PROTOCOL$StBaselibVersion
  extends MessageMicro<StBaselibVersion>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18 }, new String[] { "version", "affectedPercentage" }, new Object[] { "", "" }, StBaselibVersion.class);
  public final PBStringField affectedPercentage = PBField.initString("");
  public final PBStringField version = PBField.initString("");
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     NS_MINI_META.META_PROTOCOL.StBaselibVersion
 * JD-Core Version:    0.7.0.1
 */