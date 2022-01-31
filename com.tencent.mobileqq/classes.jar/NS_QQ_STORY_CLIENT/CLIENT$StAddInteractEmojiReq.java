package NS_QQ_STORY_CLIENT;

import NS_COMM.COMM.StCommonExt;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;

public final class CLIENT$StAddInteractEmojiReq
  extends MessageMicro<StAddInteractEmojiReq>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26, 32, 40 }, new String[] { "extInfo", "feedID", "feedPosterUin", "emojiId", "emojiAddCount" }, new Object[] { null, "", "", Integer.valueOf(1), Integer.valueOf(0) }, StAddInteractEmojiReq.class);
  public final PBInt32Field emojiAddCount = PBField.initInt32(0);
  public final PBEnumField emojiId = PBField.initEnum(1);
  public COMM.StCommonExt extInfo = new COMM.StCommonExt();
  public final PBStringField feedID = PBField.initString("");
  public final PBStringField feedPosterUin = PBField.initString("");
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     NS_QQ_STORY_CLIENT.CLIENT.StAddInteractEmojiReq
 * JD-Core Version:    0.7.0.1
 */