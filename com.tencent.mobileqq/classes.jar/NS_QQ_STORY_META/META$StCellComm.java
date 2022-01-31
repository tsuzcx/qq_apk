package NS_QQ_STORY_META;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class META$StCellComm
  extends MessageMicro<StCellComm>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 32 }, new String[] { "operateMask", "feedsAttr", "operateMask2", "feedsAttr2" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0) }, StCellComm.class);
  public final PBUInt32Field feedsAttr = PBField.initUInt32(0);
  public final PBUInt32Field feedsAttr2 = PBField.initUInt32(0);
  public final PBUInt32Field operateMask = PBField.initUInt32(0);
  public final PBUInt32Field operateMask2 = PBField.initUInt32(0);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     NS_QQ_STORY_META.META.StCellComm
 * JD-Core Version:    0.7.0.1
 */