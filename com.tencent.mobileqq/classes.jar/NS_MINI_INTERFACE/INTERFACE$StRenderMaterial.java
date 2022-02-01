package NS_MINI_INTERFACE;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

public final class INTERFACE$StRenderMaterial
  extends MessageMicro<StRenderMaterial>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18 }, new String[] { "renderMode", "downloadUrl" }, new Object[] { Integer.valueOf(0), "" }, StRenderMaterial.class);
  public final PBStringField downloadUrl = PBField.initString("");
  public final PBEnumField renderMode = PBField.initEnum(0);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     NS_MINI_INTERFACE.INTERFACE.StRenderMaterial
 * JD-Core Version:    0.7.0.1
 */