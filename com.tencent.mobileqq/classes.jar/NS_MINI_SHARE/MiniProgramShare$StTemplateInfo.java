package NS_MINI_SHARE;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

public final class MiniProgramShare$StTemplateInfo
  extends MessageMicro<StTemplateInfo>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18 }, new String[] { "templateId", "templateData" }, new Object[] { "", "" }, StTemplateInfo.class);
  public final PBStringField templateData = PBField.initString("");
  public final PBStringField templateId = PBField.initString("");
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     NS_MINI_SHARE.MiniProgramShare.StTemplateInfo
 * JD-Core Version:    0.7.0.1
 */