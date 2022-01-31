package NS_MINI_PUBLIC;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

public final class Head$StColorLink
  extends MessageMicro<StColorLink>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16 }, new String[] { "links", "soft_level" }, new Object[] { null, Integer.valueOf(0) }, StColorLink.class);
  public final PBRepeatMessageField<Head.StColorItem> links = PBField.initRepeatMessage(Head.StColorItem.class);
  public final PBInt32Field soft_level = PBField.initInt32(0);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     NS_MINI_PUBLIC.Head.StColorLink
 * JD-Core Version:    0.7.0.1
 */