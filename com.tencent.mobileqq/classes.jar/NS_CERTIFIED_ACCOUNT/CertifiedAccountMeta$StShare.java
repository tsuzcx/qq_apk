package NS_CERTIFIED_ACCOUNT;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class CertifiedAccountMeta$StShare
  extends MessageMicro<StShare>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 24, 34, 42, 50, 58, 66, 74, 82, 90 }, new String[] { "title", "desc", "type", "url", "author", "poster", "cover", "video", "shorturl", "shareCardInfo", "shareQzoneInfo" }, new Object[] { "", "", Integer.valueOf(0), "", null, null, null, null, "", "", null }, StShare.class);
  public CertifiedAccountMeta.StUser author = new CertifiedAccountMeta.StUser();
  public CertifiedAccountMeta.StImage cover = new CertifiedAccountMeta.StImage();
  public final PBStringField desc = PBField.initString("");
  public CertifiedAccountMeta.StUser poster = new CertifiedAccountMeta.StUser();
  public final PBStringField shareCardInfo = PBField.initString("");
  public CertifiedAccountMeta.StShareQzoneInfo shareQzoneInfo = new CertifiedAccountMeta.StShareQzoneInfo();
  public final PBStringField shorturl = PBField.initString("");
  public final PBStringField title = PBField.initString("");
  public final PBUInt32Field type = PBField.initUInt32(0);
  public final PBStringField url = PBField.initString("");
  public CertifiedAccountMeta.StVideo video = new CertifiedAccountMeta.StVideo();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta.StShare
 * JD-Core Version:    0.7.0.1
 */