package NS_MINI_META;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;

public final class META_PROTOCOL$StAppResidueModifyTime
  extends MessageMicro<StAppResidueModifyTime>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 32, 40 }, new String[] { "appname", "appIcon", "appDesc", "serviceCategory", "serverDomain" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0) }, StAppResidueModifyTime.class);
  public final PBInt32Field appDesc = PBField.initInt32(0);
  public final PBInt32Field appIcon = PBField.initInt32(0);
  public final PBInt32Field appname = PBField.initInt32(0);
  public final PBInt32Field serverDomain = PBField.initInt32(0);
  public final PBInt32Field serviceCategory = PBField.initInt32(0);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     NS_MINI_META.META_PROTOCOL.StAppResidueModifyTime
 * JD-Core Version:    0.7.0.1
 */