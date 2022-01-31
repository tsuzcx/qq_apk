import com.tencent.image.VideoDrawable.OnAudioPlayOnceListener;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;

class adzu
  implements VideoDrawable.OnAudioPlayOnceListener
{
  adzu(adzs paramadzs) {}
  
  public void onFinish()
  {
    if (QLog.isColorLevel()) {
      QLog.e("ShortVideoPTVItemBuilder", 2, "VideoDrawable.OnAudioPlayOnceListener.onFinish");
    }
    if ((adzs.a() != null) && (adzs.a().get() != null))
    {
      adzs.a(adzs.a(this.a), (ChatMessage)adzs.a().get());
      adzs.a(null);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     adzu
 * JD-Core Version:    0.7.0.1
 */