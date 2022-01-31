package NS_QWEB_PROTOCAL;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

public final class PROTOCAL$StAuthInfo
  extends MessageMicro<StAuthInfo>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBStringField platform = PBField.initString("");
  public final PBBytesField sig = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBStringField uin = PBField.initString("");
  
  static
  {
    ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26 }, new String[] { "uin", "sig", "platform" }, new Object[] { "", localByteStringMicro, "" }, StAuthInfo.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     NS_QWEB_PROTOCAL.PROTOCAL.StAuthInfo
 * JD-Core Version:    0.7.0.1
 */