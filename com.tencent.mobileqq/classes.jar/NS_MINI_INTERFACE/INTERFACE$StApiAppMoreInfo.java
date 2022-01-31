package NS_MINI_INTERFACE;

import NS_MINI_META.META_PROTOCOL.StAppInfo;
import NS_MINI_META.META_PROTOCOL.StDeveloperInfo;
import NS_MINI_META.META_PROTOCOL.StServerDomainInfo;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class INTERFACE$StApiAppMoreInfo
  extends MessageMicro<StApiAppMoreInfo>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26, 32 }, new String[] { "appInfo", "developerInfo", "serverDomainInfo", "updateTime" }, new Object[] { null, null, null, Integer.valueOf(0) }, StApiAppMoreInfo.class);
  public META_PROTOCOL.StAppInfo appInfo = new META_PROTOCOL.StAppInfo();
  public META_PROTOCOL.StDeveloperInfo developerInfo = new META_PROTOCOL.StDeveloperInfo();
  public META_PROTOCOL.StServerDomainInfo serverDomainInfo = new META_PROTOCOL.StServerDomainInfo();
  public final PBUInt32Field updateTime = PBField.initUInt32(0);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     NS_MINI_INTERFACE.INTERFACE.StApiAppMoreInfo
 * JD-Core Version:    0.7.0.1
 */