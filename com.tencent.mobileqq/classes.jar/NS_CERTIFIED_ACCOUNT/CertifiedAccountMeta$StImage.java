package NS_CERTIFIED_ACCOUNT;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class CertifiedAccountMeta$StImage
  extends MessageMicro<StImage>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBStringField fileId = PBField.initString("");
  public final PBUInt32Field height = PBField.initUInt32(0);
  public final PBStringField url = PBField.initString("");
  public final PBRepeatMessageField<CertifiedAccountMeta.StImageUrl> vecImageUrl = PBField.initRepeatMessage(CertifiedAccountMeta.StImageUrl.class);
  public final PBUInt32Field width = PBField.initUInt32(0);
  
  static
  {
    Integer localInteger = Integer.valueOf(0);
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16, 24, 34, 42 }, new String[] { "url", "width", "height", "vecImageUrl", "fileId" }, new Object[] { "", localInteger, localInteger, null, "" }, StImage.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta.StImage
 * JD-Core Version:    0.7.0.1
 */