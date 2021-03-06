package NS_CERTIFIED_ACCOUNT_READ;

import NS_COMM.COMM.StCommonExt;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class CertifiedAccountRead$StGetFeedDetailReq
  extends MessageMicro<StGetFeedDetailReq>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBStringField adAttchInfo = PBField.initString("");
  public final PBBytesField adres = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBUInt64Field createTime = PBField.initUInt64(0L);
  public COMM.StCommonExt extInfo = new COMM.StCommonExt();
  public final PBStringField feedId = PBField.initString("");
  public final PBInt32Field from = PBField.initInt32(0);
  public final PBStringField userId = PBField.initString("");
  
  static
  {
    ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16, 26, 34, 40, 50, 58 }, new String[] { "extInfo", "from", "userId", "feedId", "createTime", "adres", "adAttchInfo" }, new Object[] { null, Integer.valueOf(0), "", "", Long.valueOf(0L), localByteStringMicro, "" }, StGetFeedDetailReq.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     NS_CERTIFIED_ACCOUNT_READ.CertifiedAccountRead.StGetFeedDetailReq
 * JD-Core Version:    0.7.0.1
 */