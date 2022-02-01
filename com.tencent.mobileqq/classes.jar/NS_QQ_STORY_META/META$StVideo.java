package NS_QQ_STORY_META;

import NS_COMM.COMM.Entry;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class META$StVideo
  extends MessageMicro<StVideo>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBUInt32Field duration = PBField.initUInt32(0);
  public final PBStringField fileId = PBField.initString("");
  public final PBUInt32Field fileSize = PBField.initUInt32(0);
  public final PBUInt32Field height = PBField.initUInt32(0);
  public final PBUInt32Field playCount = PBField.initUInt32(0);
  public final PBStringField playUrl = PBField.initString("");
  public final PBUInt32Field transStatus = PBField.initUInt32(0);
  public final PBRepeatMessageField<COMM.Entry> vecExtInfo = PBField.initRepeatMessage(COMM.Entry.class);
  public final PBRepeatMessageField<META.StVideoUrl> vecVideoUrl = PBField.initRepeatMessage(META.StVideoUrl.class);
  public final PBUInt32Field videoPrior = PBField.initUInt32(0);
  public final PBUInt32Field videoRate = PBField.initUInt32(0);
  public final PBUInt32Field width = PBField.initUInt32(0);
  
  static
  {
    Integer localInteger = Integer.valueOf(0);
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16, 24, 32, 40, 50, 56, 64, 72, 82, 88, 98 }, new String[] { "fileId", "fileSize", "duration", "width", "height", "playUrl", "transStatus", "videoPrior", "videoRate", "vecVideoUrl", "playCount", "vecExtInfo" }, new Object[] { "", localInteger, localInteger, localInteger, localInteger, "", localInteger, localInteger, localInteger, null, localInteger, null }, StVideo.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     NS_QQ_STORY_META.META.StVideo
 * JD-Core Version:    0.7.0.1
 */