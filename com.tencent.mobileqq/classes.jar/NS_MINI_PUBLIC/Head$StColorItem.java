package NS_MINI_PUBLIC;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;

public final class Head$StColorItem
  extends MessageMicro<StColorItem>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBInt32Field l5Cmd = PBField.initInt32(0);
  public final PBInt32Field l5Mod = PBField.initInt32(0);
  public final PBStringField moduleName = PBField.initString("");
  
  static
  {
    Integer localInteger = Integer.valueOf(0);
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16, 24 }, new String[] { "moduleName", "l5Mod", "l5Cmd" }, new Object[] { "", localInteger, localInteger }, StColorItem.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     NS_MINI_PUBLIC.Head.StColorItem
 * JD-Core Version:    0.7.0.1
 */