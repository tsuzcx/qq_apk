import com.tencent.mobileqq.activity.aio.item.ShortVideoItemBuilder.CompressUpdateListenerImpl.1;
import com.tencent.mobileqq.activity.aio.item.ShortVideoItemBuilder.CompressUpdateListenerImpl.2;
import com.tencent.mobileqq.customviews.VideoProgressView;
import com.tencent.mobileqq.data.MessageForShortVideo;
import com.tencent.qphone.base.util.QLog;

public class ahrg
  implements bcyt
{
  private ahrg(ahqw paramahqw) {}
  
  public void a(MessageForShortVideo paramMessageForShortVideo, float paramFloat)
  {
    ahrh localahrh = ahqw.a(this.a, paramMessageForShortVideo);
    if (localahrh == null) {
      return;
    }
    paramMessageForShortVideo = paramMessageForShortVideo.frienduin + paramMessageForShortVideo.uniseq;
    localahrh.a.setAnimProgress(anzj.a(2131712936), paramMessageForShortVideo);
    localahrh.a.a(paramMessageForShortVideo, paramFloat);
  }
  
  public void a(MessageForShortVideo paramMessageForShortVideo, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ShortVideoItemBuilder", 2, "CompressUpdateListener,onFinish. seq = " + paramMessageForShortVideo.uniseq);
    }
    blho.a(new ShortVideoItemBuilder.CompressUpdateListenerImpl.2(this, paramMessageForShortVideo, paramInt));
  }
  
  public void a(MessageForShortVideo paramMessageForShortVideo, boolean paramBoolean)
  {
    ahrh localahrh = ahqw.a(this.a, paramMessageForShortVideo);
    if (localahrh == null) {
      return;
    }
    blho.a(new ShortVideoItemBuilder.CompressUpdateListenerImpl.1(this, paramMessageForShortVideo, paramBoolean, localahrh));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ahrg
 * JD-Core Version:    0.7.0.1
 */