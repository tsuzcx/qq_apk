package WEISHI_USER_GROWTH;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;

public final class WEISHI$stGetPersonalPageRsp
  extends MessageMicro<stGetPersonalPageRsp>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 16, 66, 82, 90 }, new String[] { "feed_num", "feeds", "attach_info", "personid" }, new Object[] { Integer.valueOf(0), null, "", "" }, stGetPersonalPageRsp.class);
  public final PBStringField attach_info = PBField.initString("");
  public final PBInt32Field feed_num = PBField.initInt32(0);
  public final PBRepeatMessageField<WEISHI.stMetaFeed> feeds = PBField.initRepeatMessage(WEISHI.stMetaFeed.class);
  public final PBStringField personid = PBField.initString("");
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     WEISHI_USER_GROWTH.WEISHI.stGetPersonalPageRsp
 * JD-Core Version:    0.7.0.1
 */