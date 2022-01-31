package NS_QQ_STORY_META;

import NS_COMM.COMM.BytesEntry;
import NS_COMM.COMM.Entry;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class META$StStoryFeed
  extends MessageMicro<StStoryFeed>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26, 34, 42, 48, 58, 66, 72, 82, 90, 98, 106, 114, 122, 128 }, new String[] { "id", "desc", "postUser", "coverImage", "storyVideo", "createTime", "vecText", "likeInfo", "commentCount", "vecComment", "cellComm", "vecExtInfo", "storyMusic", "emojiInfo", "vecBytesExt", "secureHit" }, new Object[] { "", "", null, null, null, Long.valueOf(0L), "", null, Integer.valueOf(0), null, null, null, null, null, null, Integer.valueOf(0) }, StStoryFeed.class);
  public META.StCellComm cellComm = new META.StCellComm();
  public final PBUInt32Field commentCount = PBField.initUInt32(0);
  public META.StImage coverImage = new META.StImage();
  public final PBUInt64Field createTime = PBField.initUInt64(0L);
  public final PBStringField desc = PBField.initString("");
  public META.StEmoji emojiInfo = new META.StEmoji();
  public final PBStringField id = PBField.initString("");
  public META.StLike likeInfo = new META.StLike();
  public META.StUser postUser = new META.StUser();
  public final PBUInt32Field secureHit = PBField.initUInt32(0);
  public META.StMusic storyMusic = new META.StMusic();
  public META.StVideo storyVideo = new META.StVideo();
  public final PBRepeatMessageField<COMM.BytesEntry> vecBytesExt = PBField.initRepeatMessage(COMM.BytesEntry.class);
  public final PBRepeatMessageField<META.StComment> vecComment = PBField.initRepeatMessage(META.StComment.class);
  public final PBRepeatMessageField<COMM.Entry> vecExtInfo = PBField.initRepeatMessage(COMM.Entry.class);
  public final PBRepeatField<String> vecText = PBField.initRepeat(PBStringField.__repeatHelper__);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     NS_QQ_STORY_META.META.StStoryFeed
 * JD-Core Version:    0.7.0.1
 */