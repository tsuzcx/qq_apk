package NS_MINI_CLOUDSTORAGE;

import NS_COMM.COMM.StCommonExt;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBStringField;

public final class CloudStorage$StGetUserInteractiveStorageReq
  extends MessageMicro<StGetUserInteractiveStorageReq>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26 }, new String[] { "ext", "appid", "keyList" }, new Object[] { null, "", "" }, StGetUserInteractiveStorageReq.class);
  public final PBStringField appid = PBField.initString("");
  public COMM.StCommonExt ext = new COMM.StCommonExt();
  public final PBRepeatField<String> keyList = PBField.initRepeat(PBStringField.__repeatHelper__);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     NS_MINI_CLOUDSTORAGE.CloudStorage.StGetUserInteractiveStorageReq
 * JD-Core Version:    0.7.0.1
 */