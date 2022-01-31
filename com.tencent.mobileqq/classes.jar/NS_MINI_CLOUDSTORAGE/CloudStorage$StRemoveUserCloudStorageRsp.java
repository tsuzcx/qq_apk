package NS_MINI_CLOUDSTORAGE;

import NS_COMM.COMM.StCommonExt;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;

public final class CloudStorage$StRemoveUserCloudStorageRsp
  extends MessageMicro<StRemoveUserCloudStorageRsp>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10 }, new String[] { "ext" }, new Object[] { null }, StRemoveUserCloudStorageRsp.class);
  public COMM.StCommonExt ext = new COMM.StCommonExt();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     NS_MINI_CLOUDSTORAGE.CloudStorage.StRemoveUserCloudStorageRsp
 * JD-Core Version:    0.7.0.1
 */