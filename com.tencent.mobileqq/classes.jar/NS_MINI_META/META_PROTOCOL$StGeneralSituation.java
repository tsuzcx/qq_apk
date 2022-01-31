package NS_MINI_META;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class META_PROTOCOL$StGeneralSituation
  extends MessageMicro<StGeneralSituation>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 26, 34, 42 }, new String[] { "dataType", "number", "dayContrast", "weekContrast", "monthContrast" }, new Object[] { Integer.valueOf(1), Long.valueOf(0L), "", "", "" }, StGeneralSituation.class);
  public final PBEnumField dataType = PBField.initEnum(1);
  public final PBStringField dayContrast = PBField.initString("");
  public final PBStringField monthContrast = PBField.initString("");
  public final PBUInt64Field number = PBField.initUInt64(0L);
  public final PBStringField weekContrast = PBField.initString("");
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     NS_MINI_META.META_PROTOCOL.StGeneralSituation
 * JD-Core Version:    0.7.0.1
 */