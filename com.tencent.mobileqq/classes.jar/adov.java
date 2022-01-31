import com.tencent.image.VideoDrawable.OnAudioPlayOnceListener;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;

class adov
  implements VideoDrawable.OnAudioPlayOnceListener
{
  adov(adot paramadot) {}
  
  public void onFinish()
  {
    if (QLog.isColorLevel()) {
      QLog.e("ShortVideoPTVItemBuilder", 2, "VideoDrawable.OnAudioPlayOnceListener.onFinish");
    }
    if ((adot.a() != null) && (adot.a().get() != null))
    {
      adot.a(adot.a(this.a), (ChatMessage)adot.a().get());
      adot.a(null);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     adov
 * JD-Core Version:    0.7.0.1
 */