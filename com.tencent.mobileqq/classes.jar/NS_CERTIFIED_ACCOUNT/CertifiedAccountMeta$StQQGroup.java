package NS_CERTIFIED_ACCOUNT;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class CertifiedAccountMeta$StQQGroup
  extends MessageMicro<StQQGroup>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBStringField auth = PBField.initString("");
  public final PBUInt32Field createTime = PBField.initUInt32(0);
  public final PBStringField desc = PBField.initString("");
  public final PBUInt32Field icon = PBField.initUInt32(0);
  public final PBUInt64Field id = PBField.initUInt64(0L);
  public final PBUInt32Field joinState = PBField.initUInt32(0);
  public final PBUInt32Field joinTime = PBField.initUInt32(0);
  public final PBUInt32Field memberMaxNum = PBField.initUInt32(0);
  public final PBUInt32Field memberNum = PBField.initUInt32(0);
  public final PBStringField name = PBField.initString("");
  public final PBUInt64Field owner = PBField.initUInt64(0L);
  public final PBUInt32Field safeState = PBField.initUInt32(0);
  
  static
  {
    Integer localInteger = Integer.valueOf(0);
    Long localLong = Long.valueOf(0L);
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 32, 40, 48, 58, 66, 72, 80, 90, 96 }, new String[] { "id", "owner", "createTime", "memberMaxNum", "memberNum", "icon", "name", "desc", "joinState", "joinTime", "auth", "safeState" }, new Object[] { localLong, localLong, localInteger, localInteger, localInteger, localInteger, "", "", localInteger, localInteger, "", localInteger }, StQQGroup.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta.StQQGroup
 * JD-Core Version:    0.7.0.1
 */