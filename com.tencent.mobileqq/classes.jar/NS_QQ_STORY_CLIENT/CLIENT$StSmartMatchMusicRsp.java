package NS_QQ_STORY_CLIENT;

import NS_COMM.COMM.StCommonExt;
import NS_QQ_STORY_META.META.StMusic;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

public final class CLIENT$StSmartMatchMusicRsp
  extends MessageMicro<StSmartMatchMusicRsp>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18 }, new String[] { "extInfo", "vecMusic" }, new Object[] { null, null }, StSmartMatchMusicRsp.class);
  public COMM.StCommonExt extInfo = new COMM.StCommonExt();
  public final PBRepeatMessageField<META.StMusic> vecMusic = PBField.initRepeatMessage(META.StMusic.class);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     NS_QQ_STORY_CLIENT.CLIENT.StSmartMatchMusicRsp
 * JD-Core Version:    0.7.0.1
 */