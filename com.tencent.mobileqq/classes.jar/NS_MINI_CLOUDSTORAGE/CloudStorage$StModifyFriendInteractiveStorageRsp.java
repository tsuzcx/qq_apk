package NS_MINI_CLOUDSTORAGE;

import NS_COMM.COMM.StCommonExt;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

public final class CloudStorage$StModifyFriendInteractiveStorageRsp
  extends MessageMicro<StModifyFriendInteractiveStorageRsp>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18 }, new String[] { "ext", "details" }, new Object[] { null, "" }, StModifyFriendInteractiveStorageRsp.class);
  public final PBStringField details = PBField.initString("");
  public COMM.StCommonExt ext = new COMM.StCommonExt();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     NS_MINI_CLOUDSTORAGE.CloudStorage.StModifyFriendInteractiveStorageRsp
 * JD-Core Version:    0.7.0.1
 */