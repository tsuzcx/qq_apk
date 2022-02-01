package QTimedMessage;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class QTimedMessage$Host
  extends MessageMicro<Host>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBytesField bytes_ip = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBUInt32Field uint32_cmlb_id = PBField.initUInt32(0);
  public final PBUInt32Field uint32_port = PBField.initUInt32(0);
  
  static
  {
    Integer localInteger = Integer.valueOf(0);
    ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 24 }, new String[] { "uint32_cmlb_id", "bytes_ip", "uint32_port" }, new Object[] { localInteger, localByteStringMicro, localInteger }, Host.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     QTimedMessage.QTimedMessage.Host
 * JD-Core Version:    0.7.0.1
 */