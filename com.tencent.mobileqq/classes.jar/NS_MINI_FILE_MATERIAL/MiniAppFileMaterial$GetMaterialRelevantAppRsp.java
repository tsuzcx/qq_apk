package NS_MINI_FILE_MATERIAL;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;

public final class MiniAppFileMaterial$GetMaterialRelevantAppRsp
  extends MessageMicro<GetMaterialRelevantAppRsp>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 24, 34 }, new String[] { "title", "relevant_list", "hasMore", "extra" }, new Object[] { "", null, Boolean.valueOf(false), "" }, GetMaterialRelevantAppRsp.class);
  public final PBStringField extra = PBField.initString("");
  public final PBBoolField hasMore = PBField.initBool(false);
  public final PBRepeatMessageField<MiniAppFileMaterial.AppMaterialInfo> relevant_list = PBField.initRepeatMessage(MiniAppFileMaterial.AppMaterialInfo.class);
  public final PBStringField title = PBField.initString("");
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     NS_MINI_FILE_MATERIAL.MiniAppFileMaterial.GetMaterialRelevantAppRsp
 * JD-Core Version:    0.7.0.1
 */