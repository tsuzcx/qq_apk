package NS_MINI_CLOUDSTORAGE;

import NS_COMM.COMM.StCommonExt;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

public final class CloudStorage$StGetPotentialFriendListRsp
  extends MessageMicro<StGetPotentialFriendListRsp>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18 }, new String[] { "ext", "data" }, new Object[] { null, null }, StGetPotentialFriendListRsp.class);
  public final PBRepeatMessageField<CloudStorage.StUserGameData> data = PBField.initRepeatMessage(CloudStorage.StUserGameData.class);
  public COMM.StCommonExt ext = new COMM.StCommonExt();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     NS_MINI_CLOUDSTORAGE.CloudStorage.StGetPotentialFriendListRsp
 * JD-Core Version:    0.7.0.1
 */