package NS_MINI_APP_MISC;

import NS_COMM.COMM.StCommonExt;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class MISC$StGetFriendPlayListReq
  extends MessageMicro<StGetFriendPlayListReq>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16, 26 }, new String[] { "friendUin", "pageSize", "ext" }, new Object[] { "", Integer.valueOf(0), null }, StGetFriendPlayListReq.class);
  public COMM.StCommonExt ext = new COMM.StCommonExt();
  public final PBStringField friendUin = PBField.initString("");
  public final PBUInt32Field pageSize = PBField.initUInt32(0);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     NS_MINI_APP_MISC.MISC.StGetFriendPlayListReq
 * JD-Core Version:    0.7.0.1
 */