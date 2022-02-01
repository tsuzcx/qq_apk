package NS_MINI_INTERFACE;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

public final class INTERFACE$StGamePublicationInfo
  extends MessageMicro<StGamePublicationInfo>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26, 34 }, new String[] { "gamePublicationNumber", "gamePublicationCommpany", "gameApprovalNumber", "gameOperatingCompany" }, new Object[] { "", "", "", "" }, StGamePublicationInfo.class);
  public final PBStringField gameApprovalNumber = PBField.initString("");
  public final PBStringField gameOperatingCompany = PBField.initString("");
  public final PBStringField gamePublicationCommpany = PBField.initString("");
  public final PBStringField gamePublicationNumber = PBField.initString("");
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     NS_MINI_INTERFACE.INTERFACE.StGamePublicationInfo
 * JD-Core Version:    0.7.0.1
 */