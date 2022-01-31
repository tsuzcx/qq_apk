package NS_MINI_META;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class META_PROTOCOL$StVersionInfo
  extends MessageMicro<StVersionInfo>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16, 26, 34, 42, 50, 58, 66, 72, 80, 90, 96, 104 }, new String[] { "versionId", "type", "creater", "appid", "version", "versionDesc", "resourceName", "resourceUrl", "createTime", "updateTime", "restoreIp", "releaseRate", "hasSubPkg" }, new Object[] { "", Integer.valueOf(0), "", "", "", "", "", "", Integer.valueOf(0), Integer.valueOf(0), "", Integer.valueOf(0), Integer.valueOf(0) }, StVersionInfo.class);
  public final PBStringField appid = PBField.initString("");
  public final PBUInt32Field createTime = PBField.initUInt32(0);
  public final PBStringField creater = PBField.initString("");
  public final PBInt32Field hasSubPkg = PBField.initInt32(0);
  public final PBUInt32Field releaseRate = PBField.initUInt32(0);
  public final PBStringField resourceName = PBField.initString("");
  public final PBStringField resourceUrl = PBField.initString("");
  public final PBStringField restoreIp = PBField.initString("");
  public final PBUInt32Field type = PBField.initUInt32(0);
  public final PBUInt32Field updateTime = PBField.initUInt32(0);
  public final PBStringField version = PBField.initString("");
  public final PBStringField versionDesc = PBField.initString("");
  public final PBStringField versionId = PBField.initString("");
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     NS_MINI_META.META_PROTOCOL.StVersionInfo
 * JD-Core Version:    0.7.0.1
 */