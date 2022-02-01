package NS_CERTIFIED_ACCOUNT_READ;

import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta.StFeed;
import NS_COMM.COMM.StCommonExt;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class CertifiedAccountRead$StGetFeedListReq
  extends MessageMicro<StGetFeedListReq>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBStringField adAttchInfo = PBField.initString("");
  public final PBBytesField adres = PBField.initBytes(ByteStringMicro.EMPTY);
  public COMM.StCommonExt extInfo = new COMM.StCommonExt();
  public CertifiedAccountMeta.StFeed feed = new CertifiedAccountMeta.StFeed();
  public final PBInt32Field from = PBField.initInt32(0);
  public final PBUInt32Field listNum = PBField.initUInt32(0);
  public final PBStringField livePageInfo = PBField.initString("");
  public final PBInt32Field source = PBField.initInt32(0);
  
  static
  {
    Integer localInteger = Integer.valueOf(0);
    ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16, 24, 34, 42, 50, 80, 90 }, new String[] { "extInfo", "listNum", "from", "feed", "adres", "adAttchInfo", "source", "livePageInfo" }, new Object[] { null, localInteger, localInteger, null, localByteStringMicro, "", localInteger, "" }, StGetFeedListReq.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     NS_CERTIFIED_ACCOUNT_READ.CertifiedAccountRead.StGetFeedListReq
 * JD-Core Version:    0.7.0.1
 */