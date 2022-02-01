package NS_CERTIFIED_ACCOUNT_READ;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

public final class CertifiedAccountRead$GetPortalRsp$BannerItem
  extends MessageMicro<BannerItem>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18 }, new String[] { "pic_url", "jump_url" }, new Object[] { "", "" }, BannerItem.class);
  public final PBStringField jump_url = PBField.initString("");
  public final PBStringField pic_url = PBField.initString("");
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     NS_CERTIFIED_ACCOUNT_READ.CertifiedAccountRead.GetPortalRsp.BannerItem
 * JD-Core Version:    0.7.0.1
 */