package NS_CERTIFIED_ACCOUNT_WRITE;

import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta.StFeed;
import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta.StUser;
import NS_COMM.COMM.StCommonExt;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class CertifiedAccountWrite$StDoTipOffReq
  extends MessageMicro<StDoTipOffReq>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public COMM.StCommonExt extInfo = new COMM.StCommonExt();
  public CertifiedAccountMeta.StFeed feed = new CertifiedAccountMeta.StFeed();
  public final PBUInt32Field feedbackType = PBField.initUInt32(0);
  public final PBEnumField reasonId = PBField.initEnum(1);
  public final PBStringField reasonText = PBField.initString("");
  public final PBUInt32Field tipOffType = PBField.initUInt32(0);
  public CertifiedAccountMeta.StUser user = new CertifiedAccountMeta.StUser();
  
  static
  {
    Integer localInteger = Integer.valueOf(0);
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16, 26, 32, 42, 50, 56 }, new String[] { "extInfo", "reasonId", "reasonText", "tipOffType", "user", "feed", "feedbackType" }, new Object[] { null, Integer.valueOf(1), "", localInteger, null, null, localInteger }, StDoTipOffReq.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     NS_CERTIFIED_ACCOUNT_WRITE.CertifiedAccountWrite.StDoTipOffReq
 * JD-Core Version:    0.7.0.1
 */