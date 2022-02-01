package NS_MINI_CLOUDSTORAGE;

import NS_COMM.COMM.StCommonExt;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

public final class CloudStorage$StGetReactiveFriendListRsp
  extends MessageMicro<StGetReactiveFriendListRsp>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18 }, new String[] { "ext", "list" }, new Object[] { null, null }, StGetReactiveFriendListRsp.class);
  public COMM.StCommonExt ext = new COMM.StCommonExt();
  public final PBRepeatMessageField<CloudStorage.FriendInfo> list = PBField.initRepeatMessage(CloudStorage.FriendInfo.class);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     NS_MINI_CLOUDSTORAGE.CloudStorage.StGetReactiveFriendListRsp
 * JD-Core Version:    0.7.0.1
 */