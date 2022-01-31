package NS_MINI_AD;

import NS_COMM.COMM.StCommonExt;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBStringField;

public final class MiniAppAd$StBatchGetAppPlayingFriReq
  extends MessageMicro<StBatchGetAppPlayingFriReq>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18 }, new String[] { "extInfo", "vecAppId" }, new Object[] { null, "" }, StBatchGetAppPlayingFriReq.class);
  public COMM.StCommonExt extInfo = new COMM.StCommonExt();
  public final PBRepeatField<String> vecAppId = PBField.initRepeat(PBStringField.__repeatHelper__);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     NS_MINI_AD.MiniAppAd.StBatchGetAppPlayingFriReq
 * JD-Core Version:    0.7.0.1
 */