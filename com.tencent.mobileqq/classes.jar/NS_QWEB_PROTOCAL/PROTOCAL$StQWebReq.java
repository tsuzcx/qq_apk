package NS_QWEB_PROTOCAL;

import NS_COMM.COMM.Entry;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class PROTOCAL$StQWebReq
  extends MessageMicro<StQWebReq>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBStringField Cmdname = PBField.initString("");
  public PROTOCAL.StEncryption Crypto = new PROTOCAL.StEncryption();
  public final PBRepeatMessageField<COMM.Entry> Extinfo = PBField.initRepeatMessage(COMM.Entry.class);
  public final PBStringField Module = PBField.initString("");
  public final PBUInt64Field Seq = PBField.initUInt64(0L);
  public final PBBytesField busiBuff = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBUInt32Field contentType = PBField.initUInt32(0);
  public final PBStringField deviceInfo = PBField.initString("");
  public PROTOCAL.StAuthInfo loginSig = new PROTOCAL.StAuthInfo();
  public final PBStringField qua = PBField.initString("");
  public final PBStringField traceid = PBField.initString("");
  
  static
  {
    ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26, 34, 42, 50, 58, 66, 74, 82, 88 }, new String[] { "Seq", "qua", "deviceInfo", "busiBuff", "traceid", "Module", "Cmdname", "loginSig", "Crypto", "Extinfo", "contentType" }, new Object[] { Long.valueOf(0L), "", "", localByteStringMicro, "", "", "", null, null, null, Integer.valueOf(0) }, StQWebReq.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     NS_QWEB_PROTOCAL.PROTOCAL.StQWebReq
 * JD-Core Version:    0.7.0.1
 */