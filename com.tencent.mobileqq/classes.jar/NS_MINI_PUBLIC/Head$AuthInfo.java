package NS_MINI_PUBLIC;

import NS_COMM.COMM.Entry;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class Head$AuthInfo
  extends MessageMicro<AuthInfo>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBytesField bytes_sig = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBRepeatMessageField<COMM.Entry> extinfo = PBField.initRepeatMessage(COMM.Entry.class);
  public final PBStringField str_appid = PBField.initString("");
  public final PBStringField str_uid = PBField.initString("");
  public final PBUInt32Field uint32_type = PBField.initUInt32(0);
  
  static
  {
    ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26, 34, 42 }, new String[] { "uint32_type", "str_uid", "bytes_sig", "str_appid", "extinfo" }, new Object[] { Integer.valueOf(0), "", localByteStringMicro, "", null }, AuthInfo.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     NS_MINI_PUBLIC.Head.AuthInfo
 * JD-Core Version:    0.7.0.1
 */