package NS_QQ_STORY_CONFIG;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBStringField;

public final class CONFIG$StIntConf
  extends MessageMicro<StIntConf>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16 }, new String[] { "key", "value" }, new Object[] { "", Long.valueOf(0L) }, StIntConf.class);
  public final PBStringField key = PBField.initString("");
  public final PBInt64Field value = PBField.initInt64(0L);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     NS_QQ_STORY_CONFIG.CONFIG.StIntConf
 * JD-Core Version:    0.7.0.1
 */