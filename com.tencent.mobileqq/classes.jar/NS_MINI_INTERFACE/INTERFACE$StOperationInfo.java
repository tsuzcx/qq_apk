package NS_MINI_INTERFACE;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

public final class INTERFACE$StOperationInfo
  extends MessageMicro<StOperationInfo>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18 }, new String[] { "reportData", "amsAdInfo" }, new Object[] { "", "" }, StOperationInfo.class);
  public final PBStringField amsAdInfo = PBField.initString("");
  public final PBStringField reportData = PBField.initString("");
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     NS_MINI_INTERFACE.INTERFACE.StOperationInfo
 * JD-Core Version:    0.7.0.1
 */