import com.tencent.mobileqq.activity.aio.item.ShortVideoItemBuilder.CompressUpdateListenerImpl.1;
import com.tencent.mobileqq.activity.aio.item.ShortVideoItemBuilder.CompressUpdateListenerImpl.2;
import com.tencent.mobileqq.customviews.VideoProgressView;
import com.tencent.mobileqq.data.MessageForShortVideo;
import com.tencent.qphone.base.util.QLog;

public class ahgj
  implements bcyw
{
  private ahgj(ahfz paramahfz) {}
  
  public void a(MessageForShortVideo paramMessageForShortVideo, float paramFloat)
  {
    ahgk localahgk = ahfz.a(this.a, paramMessageForShortVideo);
    if (localahgk == null) {
      return;
    }
    paramMessageForShortVideo = paramMessageForShortVideo.frienduin + paramMessageForShortVideo.uniseq;
    localahgk.a.setAnimProgress(anvx.a(2131713515), paramMessageForShortVideo);
    localahgk.a.a(paramMessageForShortVideo, paramFloat);
  }
  
  public void a(MessageForShortVideo paramMessageForShortVideo, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ShortVideoItemBuilder", 2, "CompressUpdateListener,onFinish. seq = " + paramMessageForShortVideo.uniseq);
    }
    bkyq.a(new ShortVideoItemBuilder.CompressUpdateListenerImpl.2(this, paramMessageForShortVideo, paramInt));
  }
  
  public void a(MessageForShortVideo paramMessageForShortVideo, boolean paramBoolean)
  {
    ahgk localahgk = ahfz.a(this.a, paramMessageForShortVideo);
    if (localahgk == null) {
      return;
    }
    bkyq.a(new ShortVideoItemBuilder.CompressUpdateListenerImpl.1(this, paramMessageForShortVideo, paramBoolean, localahgk));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ahgj
 * JD-Core Version:    0.7.0.1
 */