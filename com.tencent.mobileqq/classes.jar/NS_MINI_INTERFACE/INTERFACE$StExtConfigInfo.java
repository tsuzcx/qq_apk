package NS_MINI_INTERFACE;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

public final class INTERFACE$StExtConfigInfo
  extends MessageMicro<StExtConfigInfo>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBStringField configKey = PBField.initString("");
  public final PBStringField configVersion = PBField.initString("");
  public final PBBytesField dataBuf = PBField.initBytes(ByteStringMicro.EMPTY);
  
  static
  {
    ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26 }, new String[] { "configKey", "configVersion", "dataBuf" }, new Object[] { "", "", localByteStringMicro }, StExtConfigInfo.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     NS_MINI_INTERFACE.INTERFACE.StExtConfigInfo
 * JD-Core Version:    0.7.0.1
 */