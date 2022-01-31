package NS_MINI_META;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class META_PROTOCOL$StDeveloperInfo
  extends MessageMicro<StDeveloperInfo>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16, 24, 34, 40, 48, 56, 66, 74, 82, 90, 98, 106, 112 }, new String[] { "developerId", "createTimestamp", "updateTimestamp", "email", "type", "auditState", "IDType", "IDName", "IDNum", "IDImg", "contactPhoneNum", "contactAddress", "administratorInfo", "appNum" }, new Object[] { "", Integer.valueOf(0), Integer.valueOf(0), "", Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), "", "", "", "", "", null, Integer.valueOf(0) }, StDeveloperInfo.class);
  public final PBStringField IDImg = PBField.initString("");
  public final PBStringField IDName = PBField.initString("");
  public final PBStringField IDNum = PBField.initString("");
  public final PBUInt32Field IDType = PBField.initUInt32(0);
  public META_PROTOCOL.StAdministratorInfo administratorInfo = new META_PROTOCOL.StAdministratorInfo();
  public final PBUInt32Field appNum = PBField.initUInt32(0);
  public final PBUInt32Field auditState = PBField.initUInt32(0);
  public final PBStringField contactAddress = PBField.initString("");
  public final PBStringField contactPhoneNum = PBField.initString("");
  public final PBUInt32Field createTimestamp = PBField.initUInt32(0);
  public final PBStringField developerId = PBField.initString("");
  public final PBStringField email = PBField.initString("");
  public final PBUInt32Field type = PBField.initUInt32(0);
  public final PBUInt32Field updateTimestamp = PBField.initUInt32(0);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     NS_MINI_META.META_PROTOCOL.StDeveloperInfo
 * JD-Core Version:    0.7.0.1
 */