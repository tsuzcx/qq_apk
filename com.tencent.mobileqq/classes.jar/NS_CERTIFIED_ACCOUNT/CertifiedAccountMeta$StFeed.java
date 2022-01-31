package NS_CERTIFIED_ACCOUNT;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class CertifiedAccountMeta$StFeed
  extends MessageMicro<StFeed>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBytesField adBuffer = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBUInt32Field commentCount = PBField.initUInt32(0);
  public final PBStringField content = PBField.initString("");
  public CertifiedAccountMeta.StImage cover = new CertifiedAccountMeta.StImage();
  public final PBUInt64Field createTime = PBField.initUInt64(0L);
  public final PBStringField ext = PBField.initString("");
  public final PBUInt64Field feedAttr = PBField.initUInt64(0L);
  public final PBUInt32Field feedLevel = PBField.initUInt32(0);
  public final PBRepeatMessageField<CertifiedAccountMeta.StYouZanGood> goods = PBField.initRepeatMessage(CertifiedAccountMeta.StYouZanGood.class);
  public final PBStringField id = PBField.initString("");
  public final PBRepeatMessageField<CertifiedAccountMeta.StImage> images = PBField.initRepeatMessage(CertifiedAccountMeta.StImage.class);
  public CertifiedAccountMeta.StLike likeInfo = new CertifiedAccountMeta.StLike();
  public CertifiedAccountMeta.StPoiInfoV2 poiInfo = new CertifiedAccountMeta.StPoiInfoV2();
  public CertifiedAccountMeta.StUser poster = new CertifiedAccountMeta.StUser();
  public final PBUInt32Field pushStatus = PBField.initUInt32(0);
  public CertifiedAccountMeta.StShare share = new CertifiedAccountMeta.StShare();
  public final PBUInt32Field status = PBField.initUInt32(0);
  public final PBStringField subtitle = PBField.initString("");
  public final PBStringField title = PBField.initString("");
  public final PBUInt32Field type = PBField.initUInt32(0);
  public final PBRepeatMessageField<CertifiedAccountMeta.StComment> vecComment = PBField.initRepeatMessage(CertifiedAccountMeta.StComment.class);
  public CertifiedAccountMeta.StVideo video = new CertifiedAccountMeta.StVideo();
  public CertifiedAccountMeta.StVisitor visitorInfo = new CertifiedAccountMeta.StVisitor();
  
  static
  {
    ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26, 34, 42, 50, 58, 64, 72, 82, 88, 98, 106, 114, 122, 128, 136, 146, 152, 162, 170, 176, 186 }, new String[] { "id", "title", "subtitle", "poster", "cover", "video", "content", "type", "createTime", "likeInfo", "commentCount", "vecComment", "share", "visitorInfo", "images", "status", "pushStatus", "poiInfo", "feedLevel", "adBuffer", "goods", "feedAttr", "ext" }, new Object[] { "", "", "", null, null, null, "", Integer.valueOf(0), Long.valueOf(0L), null, Integer.valueOf(0), null, null, null, null, Integer.valueOf(0), Integer.valueOf(0), null, Integer.valueOf(0), localByteStringMicro, null, Long.valueOf(0L), "" }, StFeed.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta.StFeed
 * JD-Core Version:    0.7.0.1
 */