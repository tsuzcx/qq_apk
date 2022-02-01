package NS_MINI_CLOUDSTORAGE;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class CloudStorage$StInteractiveTemplate
  extends MessageMicro<StInteractiveTemplate>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 24 }, new String[] { "action", "object", "ratio" }, new Object[] { "", "", Integer.valueOf(0) }, StInteractiveTemplate.class);
  public final PBStringField action = PBField.initString("");
  public final PBStringField object = PBField.initString("");
  public final PBUInt32Field ratio = PBField.initUInt32(0);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     NS_MINI_CLOUDSTORAGE.CloudStorage.StInteractiveTemplate
 * JD-Core Version:    0.7.0.1
 */