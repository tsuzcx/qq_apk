package NS_MINI_INTERFACE;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

public final class INTERFACE$StRenderInfo
  extends MessageMicro<StRenderInfo>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18 }, new String[] { "renderMode", "renderMaterials" }, new Object[] { Integer.valueOf(0), null }, StRenderInfo.class);
  public final PBRepeatMessageField<INTERFACE.StRenderMaterial> renderMaterials = PBField.initRepeatMessage(INTERFACE.StRenderMaterial.class);
  public final PBEnumField renderMode = PBField.initEnum(0);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     NS_MINI_INTERFACE.INTERFACE.StRenderInfo
 * JD-Core Version:    0.7.0.1
 */