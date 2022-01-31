package NS_MINI_AD;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;

public final class MiniAppAd$StAdPageFlipTemplate
  extends MessageMicro<StAdPageFlipTemplate>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16 }, new String[] { "ad_type", "effect_id" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0) }, StAdPageFlipTemplate.class);
  public final PBInt32Field ad_type = PBField.initInt32(0);
  public final PBInt32Field effect_id = PBField.initInt32(0);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     NS_MINI_AD.MiniAppAd.StAdPageFlipTemplate
 * JD-Core Version:    0.7.0.1
 */