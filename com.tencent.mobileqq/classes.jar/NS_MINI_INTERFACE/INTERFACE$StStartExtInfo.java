package NS_MINI_INTERFACE;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;

public final class INTERFACE$StStartExtInfo
  extends MessageMicro<StStartExtInfo>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16 }, new String[] { "deviceOrientation", "showStatusBar" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0) }, StStartExtInfo.class);
  public final PBInt32Field deviceOrientation = PBField.initInt32(0);
  public final PBInt32Field showStatusBar = PBField.initInt32(0);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     NS_MINI_INTERFACE.INTERFACE.StStartExtInfo
 * JD-Core Version:    0.7.0.1
 */