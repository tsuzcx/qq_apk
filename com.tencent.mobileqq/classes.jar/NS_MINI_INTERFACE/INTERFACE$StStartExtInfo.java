package NS_MINI_INTERFACE;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;

public final class INTERFACE$StStartExtInfo
  extends MessageMicro<StStartExtInfo>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBInt32Field deviceOrientation = PBField.initInt32(0);
  public final PBInt32Field showStatusBar = PBField.initInt32(0);
  
  static
  {
    Integer localInteger = Integer.valueOf(0);
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16 }, new String[] { "deviceOrientation", "showStatusBar" }, new Object[] { localInteger, localInteger }, StStartExtInfo.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     NS_MINI_INTERFACE.INTERFACE.StStartExtInfo
 * JD-Core Version:    0.7.0.1
 */