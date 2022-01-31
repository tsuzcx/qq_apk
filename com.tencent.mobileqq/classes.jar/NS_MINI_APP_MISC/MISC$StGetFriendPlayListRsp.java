package NS_MINI_APP_MISC;

import NS_COMM.COMM.StCommonExt;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class MISC$StGetFriendPlayListRsp
  extends MessageMicro<StGetFriendPlayListRsp>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 26, 34, 42, 48 }, new String[] { "total", "finish", "appPlayingInfos", "moreJumpLink", "ext", "showOtherFriPlay" }, new Object[] { Integer.valueOf(0), Boolean.valueOf(false), null, "", null, Boolean.valueOf(false) }, StGetFriendPlayListRsp.class);
  public final PBRepeatMessageField<MISC.StAppPlayingInfo> appPlayingInfos = PBField.initRepeatMessage(MISC.StAppPlayingInfo.class);
  public COMM.StCommonExt ext = new COMM.StCommonExt();
  public final PBBoolField finish = PBField.initBool(false);
  public final PBStringField moreJumpLink = PBField.initString("");
  public final PBBoolField showOtherFriPlay = PBField.initBool(false);
  public final PBUInt32Field total = PBField.initUInt32(0);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     NS_MINI_APP_MISC.MISC.StGetFriendPlayListRsp
 * JD-Core Version:    0.7.0.1
 */