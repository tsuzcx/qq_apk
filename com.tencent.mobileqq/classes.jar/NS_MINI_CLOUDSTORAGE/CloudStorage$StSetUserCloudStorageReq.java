package NS_MINI_CLOUDSTORAGE;

import NS_COMM.COMM.StCommonExt;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;

public final class CloudStorage$StSetUserCloudStorageReq
  extends MessageMicro<StSetUserCloudStorageReq>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26, 34, 42, 50, 58 }, new String[] { "ext", "appid", "openid", "accessToken", "signature", "sigMethod", "KVDataList" }, new Object[] { null, "", "", "", "", "", null }, StSetUserCloudStorageReq.class);
  public final PBRepeatMessageField<CloudStorage.StKVData> KVDataList = PBField.initRepeatMessage(CloudStorage.StKVData.class);
  public final PBStringField accessToken = PBField.initString("");
  public final PBStringField appid = PBField.initString("");
  public COMM.StCommonExt ext = new COMM.StCommonExt();
  public final PBStringField openid = PBField.initString("");
  public final PBStringField sigMethod = PBField.initString("");
  public final PBStringField signature = PBField.initString("");
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     NS_MINI_CLOUDSTORAGE.CloudStorage.StSetUserCloudStorageReq
 * JD-Core Version:    0.7.0.1
 */