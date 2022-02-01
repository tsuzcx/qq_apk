package NS_QQ_STORY_CLIENT;

import NS_COMM.COMM.StCommonExt;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class CLIENT$StAddInteractEmojiRsp
  extends MessageMicro<StAddInteractEmojiRsp>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16 }, new String[] { "extInfo", "emojiTotalCount" }, new Object[] { null, Long.valueOf(0L) }, StAddInteractEmojiRsp.class);
  public final PBUInt64Field emojiTotalCount = PBField.initUInt64(0L);
  public COMM.StCommonExt extInfo = new COMM.StCommonExt();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     NS_QQ_STORY_CLIENT.CLIENT.StAddInteractEmojiRsp
 * JD-Core Version:    0.7.0.1
 */