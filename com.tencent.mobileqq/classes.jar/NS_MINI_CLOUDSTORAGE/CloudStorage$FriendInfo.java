package NS_MINI_CLOUDSTORAGE;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

public final class CloudStorage$FriendInfo
  extends MessageMicro<FriendInfo>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26 }, new String[] { "avatarUrl", "nickname", "openid" }, new Object[] { "", "", "" }, FriendInfo.class);
  public final PBStringField avatarUrl = PBField.initString("");
  public final PBStringField nickname = PBField.initString("");
  public final PBStringField openid = PBField.initString("");
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     NS_MINI_CLOUDSTORAGE.CloudStorage.FriendInfo
 * JD-Core Version:    0.7.0.1
 */