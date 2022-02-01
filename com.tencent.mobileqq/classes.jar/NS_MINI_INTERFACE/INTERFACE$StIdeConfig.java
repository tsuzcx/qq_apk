package NS_MINI_INTERFACE;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

public final class INTERFACE$StIdeConfig
  extends MessageMicro<StIdeConfig>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26, 34 }, new String[] { "scene", "extraAppid", "extraData", "startExtInfo" }, new Object[] { "", "", "", null }, StIdeConfig.class);
  public final PBStringField extraAppid = PBField.initString("");
  public final PBStringField extraData = PBField.initString("");
  public final PBStringField scene = PBField.initString("");
  public INTERFACE.StStartExtInfo startExtInfo = new INTERFACE.StStartExtInfo();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     NS_MINI_INTERFACE.INTERFACE.StIdeConfig
 * JD-Core Version:    0.7.0.1
 */