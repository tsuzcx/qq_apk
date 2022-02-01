import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class RecommendPool$ItemMeta
  extends MessageMicro<ItemMeta>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 24, 32, 40, 48, 56, 64, 74, 82, 90, 98, 106, 114, 122, 128, 138, 144, 152, 162, 170, 178, 186, 192, 202, 210, 218 }, new String[] { "ContentId", "SourceItemId", "DataType", "Status", "CreateTime", "ModifyTime", "InTime", "ReviewTime", "Uid", "UserInfo", "Title", "Content", "VideoList", "PhotoList", "AudioList", "IsRecommend", "BlockRecReason", "Grade", "OperationFlag", "CateName", "SubCateName", "Tag", "MachineTag", "SourceAppId", "TopicId", "TopicName", "Reserve1" }, new Object[] { Long.valueOf(0L), "", Integer.valueOf(0), Integer.valueOf(0), Long.valueOf(0L), Long.valueOf(0L), Long.valueOf(0L), Long.valueOf(0L), "", "", "", "", "", "", "", Integer.valueOf(0), "", Integer.valueOf(0), Integer.valueOf(0), "", "", "", "", Integer.valueOf(0), "", "", "" }, ItemMeta.class);
  public final PBStringField AudioList = PBField.initString("");
  public final PBStringField BlockRecReason = PBField.initString("");
  public final PBStringField CateName = PBField.initString("");
  public final PBStringField Content = PBField.initString("");
  public final PBInt64Field ContentId = PBField.initInt64(0L);
  public final PBUInt64Field CreateTime = PBField.initUInt64(0L);
  public final PBInt32Field DataType = PBField.initInt32(0);
  public final PBInt32Field Grade = PBField.initInt32(0);
  public final PBUInt64Field InTime = PBField.initUInt64(0L);
  public final PBInt32Field IsRecommend = PBField.initInt32(0);
  public final PBStringField MachineTag = PBField.initString("");
  public final PBUInt64Field ModifyTime = PBField.initUInt64(0L);
  public final PBInt32Field OperationFlag = PBField.initInt32(0);
  public final PBStringField PhotoList = PBField.initString("");
  public final PBStringField Reserve1 = PBField.initString("");
  public final PBUInt64Field ReviewTime = PBField.initUInt64(0L);
  public final PBInt32Field SourceAppId = PBField.initInt32(0);
  public final PBStringField SourceItemId = PBField.initString("");
  public final PBInt32Field Status = PBField.initInt32(0);
  public final PBStringField SubCateName = PBField.initString("");
  public final PBStringField Tag = PBField.initString("");
  public final PBStringField Title = PBField.initString("");
  public final PBStringField TopicId = PBField.initString("");
  public final PBStringField TopicName = PBField.initString("");
  public final PBStringField Uid = PBField.initString("");
  public final PBStringField UserInfo = PBField.initString("");
  public final PBStringField VideoList = PBField.initString("");
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     RecommendPool.ItemMeta
 * JD-Core Version:    0.7.0.1
 */