package addcontacts;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.richstatus.RichStatus;

public final class AccountSearchPb$record
  extends MessageMicro<record>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBUInt32Field account_flag = PBField.initUInt32(0);
  public final PBUInt64Field account_id = PBField.initUInt64(0L);
  public final PBStringField accout = PBField.initString("");
  public final PBUInt32Field age = PBField.initUInt32(0);
  public final PBStringField article_author = PBField.initString("");
  public final PBStringField article_create_time = PBField.initString("");
  public final PBStringField article_short_url = PBField.initString("");
  public final PBStringField brief = PBField.initString("");
  public final PBBytesField bytes_join_group_auth = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_token = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBUInt32Field city = PBField.initUInt32(0);
  public final PBStringField city_name = PBField.initString("");
  public final PBUInt32Field class_index = PBField.initUInt32(0);
  public final PBStringField class_name = PBField.initString("");
  public final PBUInt64Field code = PBField.initUInt64(0L);
  public final PBUInt32Field country = PBField.initUInt32(0);
  public final PBStringField country_name = PBField.initString("");
  public final PBUInt64Field flag = PBField.initUInt64(0L);
  public final PBStringField mobile = PBField.initString("");
  public final PBRepeatMessageField<AccountSearchPb.Label> msg_group_labels = PBField.initRepeatMessage(AccountSearchPb.Label.class);
  public final PBStringField name = PBField.initString("");
  public final PBUInt32Field number = PBField.initUInt32(0);
  public final PBUInt32Field province = PBField.initUInt32(0);
  public final PBStringField province_name = PBField.initString("");
  public final PBUInt64Field relation = PBField.initUInt64(0L);
  public RichStatus richStatus;
  public final PBUInt32Field sex = PBField.initUInt32(0);
  public final PBBytesField sign = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBEnumField source = PBField.initEnum(1);
  public final PBStringField title_image = PBField.initString("");
  public final PBUInt64Field uin = PBField.initUInt64(0L);
  public final PBInt32Field uin_privilege = PBField.initInt32(0);
  public final PBUInt32Field uint32_richflag1_59 = PBField.initUInt32(0);
  public final PBUInt32Field uint32_richflag4_409 = PBField.initUInt32(0);
  public final PBUInt32Field video_account = PBField.initUInt32(0);
  public final PBUInt32Field video_article = PBField.initUInt32(0);
  
  static
  {
    Integer localInteger = Integer.valueOf(0);
    Long localLong = Long.valueOf(0L);
    ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro3 = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 34, 40, 48, 58, 66, 72, 80, 88, 98, 106, 112, 120, 128, 136, 146, 154, 162, 170, 176, 186, 194, 202, 210, 216, 242, 248, 256, 264, 274, 4002, 324824, 339272 }, new String[] { "uin", "code", "source", "name", "sex", "age", "accout", "brief", "number", "flag", "relation", "mobile", "sign", "country", "province", "city", "class_index", "class_name", "country_name", "province_name", "city_name", "account_flag", "title_image", "article_short_url", "article_create_time", "article_author", "account_id", "msg_group_labels", "video_account", "video_article", "uin_privilege", "bytes_join_group_auth", "bytes_token", "uint32_richflag1_59", "uint32_richflag4_409" }, new Object[] { localLong, localLong, Integer.valueOf(1), "", localInteger, localInteger, "", "", localInteger, localLong, localLong, "", localByteStringMicro1, localInteger, localInteger, localInteger, localInteger, "", "", "", "", localInteger, "", "", "", "", localLong, null, localInteger, localInteger, localInteger, localByteStringMicro2, localByteStringMicro3, localInteger, localInteger }, record.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     addcontacts.AccountSearchPb.record
 * JD-Core Version:    0.7.0.1
 */