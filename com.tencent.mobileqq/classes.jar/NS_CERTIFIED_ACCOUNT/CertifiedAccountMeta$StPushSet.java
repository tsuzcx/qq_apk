package NS_CERTIFIED_ACCOUNT;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class CertifiedAccountMeta$StPushSet
  extends MessageMicro<StPushSet>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBUInt32Field createTime = PBField.initUInt32(0);
  public final PBRepeatMessageField<CertifiedAccountMeta.StPushFeed> pFeeds = PBField.initRepeatMessage(CertifiedAccountMeta.StPushFeed.class);
  public final PBStringField pushSetID = PBField.initString("");
  public final PBUInt32Field sendTime = PBField.initUInt32(0);
  
  static
  {
    Integer localInteger = Integer.valueOf(0);
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 26, 34 }, new String[] { "createTime", "sendTime", "pFeeds", "pushSetID" }, new Object[] { localInteger, localInteger, null, "" }, StPushSet.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta.StPushSet
 * JD-Core Version:    0.7.0.1
 */