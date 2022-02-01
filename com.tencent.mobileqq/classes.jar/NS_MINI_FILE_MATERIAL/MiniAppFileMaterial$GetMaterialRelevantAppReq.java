package NS_MINI_FILE_MATERIAL;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

public final class MiniAppFileMaterial$GetMaterialRelevantAppReq
  extends MessageMicro<GetMaterialRelevantAppReq>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18 }, new String[] { "mime_type", "extra" }, new Object[] { "", "" }, GetMaterialRelevantAppReq.class);
  public final PBStringField extra = PBField.initString("");
  public final PBStringField mime_type = PBField.initString("");
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     NS_MINI_FILE_MATERIAL.MiniAppFileMaterial.GetMaterialRelevantAppReq
 * JD-Core Version:    0.7.0.1
 */