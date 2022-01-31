package NS_MINI_AD;

import NS_COMM.COMM.StCommonExt;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

public final class MiniAppAd$StBatchGetAppPlayingFriRsp
  extends MessageMicro<StBatchGetAppPlayingFriRsp>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18 }, new String[] { "extInfo", "vecAppPlayingFri" }, new Object[] { null, null }, StBatchGetAppPlayingFriRsp.class);
  public COMM.StCommonExt extInfo = new COMM.StCommonExt();
  public final PBRepeatMessageField<MiniAppAd.StAppPlayingFriList> vecAppPlayingFri = PBField.initRepeatMessage(MiniAppAd.StAppPlayingFriList.class);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     NS_MINI_AD.MiniAppAd.StBatchGetAppPlayingFriRsp
 * JD-Core Version:    0.7.0.1
 */