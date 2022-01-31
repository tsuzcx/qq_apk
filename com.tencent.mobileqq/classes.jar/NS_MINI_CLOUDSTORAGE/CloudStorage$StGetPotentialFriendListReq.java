package NS_MINI_CLOUDSTORAGE;

import NS_COMM.COMM.StCommonExt;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

public final class CloudStorage$StGetPotentialFriendListReq
  extends MessageMicro<StGetPotentialFriendListReq>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18 }, new String[] { "ext", "appid" }, new Object[] { null, "" }, StGetPotentialFriendListReq.class);
  public final PBStringField appid = PBField.initString("");
  public COMM.StCommonExt ext = new COMM.StCommonExt();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     NS_MINI_CLOUDSTORAGE.CloudStorage.StGetPotentialFriendListReq
 * JD-Core Version:    0.7.0.1
 */