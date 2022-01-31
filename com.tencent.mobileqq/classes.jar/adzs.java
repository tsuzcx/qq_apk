import com.tencent.image.VideoDrawable.OnAudioPlayOnceListener;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;

class adzs
  implements VideoDrawable.OnAudioPlayOnceListener
{
  adzs(adzq paramadzq) {}
  
  public void onFinish()
  {
    if (QLog.isColorLevel()) {
      QLog.e("ShortVideoPTVItemBuilder", 2, "VideoDrawable.OnAudioPlayOnceListener.onFinish");
    }
    if ((adzq.a() != null) && (adzq.a().get() != null))
    {
      adzq.a(adzq.a(this.a), (ChatMessage)adzq.a().get());
      adzq.a(null);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     adzs
 * JD-Core Version:    0.7.0.1
 */