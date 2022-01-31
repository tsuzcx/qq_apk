package WEISHI_USER_GROWTH;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

public final class WEISHI$stGetPersonalPageReq
  extends MessageMicro<stGetPersonalPageReq>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16, 26 }, new String[] { "person_id", "type", "attach_info" }, new Object[] { "", Integer.valueOf(0), "" }, stGetPersonalPageReq.class);
  public final PBStringField attach_info = PBField.initString("");
  public final PBStringField person_id = PBField.initString("");
  public final PBEnumField type = PBField.initEnum(0);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     WEISHI_USER_GROWTH.WEISHI.stGetPersonalPageReq
 * JD-Core Version:    0.7.0.1
 */