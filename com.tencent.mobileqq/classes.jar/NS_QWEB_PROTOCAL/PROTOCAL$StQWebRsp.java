package NS_QWEB_PROTOCAL;

import NS_COMM.COMM.Entry;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class PROTOCAL$StQWebRsp
  extends MessageMicro<StQWebRsp>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBRepeatMessageField<COMM.Entry> Extinfo = PBField.initRepeatMessage(COMM.Entry.class);
  public final PBUInt64Field Seq = PBField.initUInt64(0L);
  public final PBBytesField busiBuff = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField errMsg = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBInt64Field retCode = PBField.initInt64(0L);
  
  static
  {
    ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 26, 34, 42 }, new String[] { "Seq", "retCode", "errMsg", "busiBuff", "Extinfo" }, new Object[] { Long.valueOf(0L), Long.valueOf(0L), localByteStringMicro1, localByteStringMicro2, null }, StQWebRsp.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     NS_QWEB_PROTOCAL.PROTOCAL.StQWebRsp
 * JD-Core Version:    0.7.0.1
 */