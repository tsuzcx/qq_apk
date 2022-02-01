package NS_MINI_INTERFACE;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class INTERFACE$StOperationInfo
  extends MessageMicro<StOperationInfo>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 24 }, new String[] { "reportData", "amsAdInfo", "tianshuAdId" }, new Object[] { "", "", Integer.valueOf(0) }, StOperationInfo.class);
  public final PBStringField amsAdInfo = PBField.initString("");
  public final PBStringField reportData = PBField.initString("");
  public final PBUInt32Field tianshuAdId = PBField.initUInt32(0);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     NS_MINI_INTERFACE.INTERFACE.StOperationInfo
 * JD-Core Version:    0.7.0.1
 */