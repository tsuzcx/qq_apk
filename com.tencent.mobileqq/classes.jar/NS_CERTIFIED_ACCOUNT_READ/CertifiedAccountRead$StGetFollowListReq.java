package NS_CERTIFIED_ACCOUNT_READ;

import NS_COMM.COMM.StCommonExt;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class CertifiedAccountRead$StGetFollowListReq
  extends MessageMicro<StGetFollowListReq>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBStringField attach_info = PBField.initString("");
  public final PBUInt32Field count = PBField.initUInt32(0);
  public COMM.StCommonExt extInfo = new COMM.StCommonExt();
  public final PBUInt32Field seq = PBField.initUInt32(0);
  public final PBInt32Field source = PBField.initInt32(0);
  
  static
  {
    Integer localInteger = Integer.valueOf(0);
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16, 26, 32, 40 }, new String[] { "extInfo", "seq", "attach_info", "count", "source" }, new Object[] { null, localInteger, "", localInteger, localInteger }, StGetFollowListReq.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     NS_CERTIFIED_ACCOUNT_READ.CertifiedAccountRead.StGetFollowListReq
 * JD-Core Version:    0.7.0.1
 */