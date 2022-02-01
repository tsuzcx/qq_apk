package NS_MINI_INTERFACE;

import NS_COMM.COMM.Entry;
import NS_COMM.COMM.StCommonExt;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

public final class INTERFACE$StContentAccelerateRsp
  extends MessageMicro<StContentAccelerateRsp>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBytesField cacheData = PBField.initBytes(ByteStringMicro.EMPTY);
  public COMM.StCommonExt extInfo = new COMM.StCommonExt();
  public final PBInt32Field httpReturnCode = PBField.initInt32(0);
  public final PBRepeatMessageField<COMM.Entry> rspHeaders = PBField.initRepeatMessage(COMM.Entry.class);
  
  static
  {
    ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26, 32 }, new String[] { "extInfo", "rspHeaders", "cacheData", "httpReturnCode" }, new Object[] { null, null, localByteStringMicro, Integer.valueOf(0) }, StContentAccelerateRsp.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     NS_MINI_INTERFACE.INTERFACE.StContentAccelerateRsp
 * JD-Core Version:    0.7.0.1
 */