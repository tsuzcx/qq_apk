package NS_MINI_META;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class META_PROTOCOL$StMemberInfo
  extends MessageMicro<StMemberInfo>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16, 24, 32, 42, 50, 58, 66, 74 }, new String[] { "appid", "createTime", "updateTime", "state", "uin", "nick", "avatar", "remark", "authority" }, new Object[] { "", Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), "", "", "", "", null }, StMemberInfo.class);
  public final PBStringField appid = PBField.initString("");
  public META_PROTOCOL.StAuthorityInfo authority = new META_PROTOCOL.StAuthorityInfo();
  public final PBStringField avatar = PBField.initString("");
  public final PBUInt32Field createTime = PBField.initUInt32(0);
  public final PBStringField nick = PBField.initString("");
  public final PBStringField remark = PBField.initString("");
  public final PBUInt32Field state = PBField.initUInt32(0);
  public final PBStringField uin = PBField.initString("");
  public final PBUInt32Field updateTime = PBField.initUInt32(0);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     NS_MINI_META.META_PROTOCOL.StMemberInfo
 * JD-Core Version:    0.7.0.1
 */