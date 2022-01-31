package NS_MINI_CLOUDSTORAGE;

import NS_COMM.COMM.StCommonExt;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;

public final class CloudStorage$StModifyFriendInteractiveStorageReq
  extends MessageMicro<StModifyFriendInteractiveStorageReq>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26, 34, 40, 50, 58, 64 }, new String[] { "ext", "appid", "toUser", "shareId", "opNum", "operation", "KVDataList", "version" }, new Object[] { null, "", "", "", Integer.valueOf(0), "", null, Integer.valueOf(0) }, StModifyFriendInteractiveStorageReq.class);
  public final PBRepeatMessageField<CloudStorage.StKVData> KVDataList = PBField.initRepeatMessage(CloudStorage.StKVData.class);
  public final PBStringField appid = PBField.initString("");
  public COMM.StCommonExt ext = new COMM.StCommonExt();
  public final PBInt32Field opNum = PBField.initInt32(0);
  public final PBStringField operation = PBField.initString("");
  public final PBStringField shareId = PBField.initString("");
  public final PBStringField toUser = PBField.initString("");
  public final PBInt32Field version = PBField.initInt32(0);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     NS_MINI_CLOUDSTORAGE.CloudStorage.StModifyFriendInteractiveStorageReq
 * JD-Core Version:    0.7.0.1
 */