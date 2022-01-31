package NS_MINI_META;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

public final class META_PROTOCOL$StAdministratorInfo
  extends MessageMicro<StAdministratorInfo>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26, 34 }, new String[] { "uin", "IDName", "IDNum", "phoneNum" }, new Object[] { "", "", "", "" }, StAdministratorInfo.class);
  public final PBStringField IDName = PBField.initString("");
  public final PBStringField IDNum = PBField.initString("");
  public final PBStringField phoneNum = PBField.initString("");
  public final PBStringField uin = PBField.initString("");
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     NS_MINI_META.META_PROTOCOL.StAdministratorInfo
 * JD-Core Version:    0.7.0.1
 */