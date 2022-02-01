import com.tencent.image.VideoDrawable.OnAudioPlayOnceListener;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;

class ahia
  implements VideoDrawable.OnAudioPlayOnceListener
{
  ahia(ahhy paramahhy) {}
  
  public void onFinish()
  {
    if (QLog.isColorLevel()) {
      QLog.e("ShortVideoPTVItemBuilder", 2, "VideoDrawable.OnAudioPlayOnceListener.onFinish");
    }
    if ((ahhy.a() != null) && (ahhy.a().get() != null))
    {
      ahhy.a(ahhy.a(this.a), (ChatMessage)ahhy.a().get());
      ahhy.a(null);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ahia
 * JD-Core Version:    0.7.0.1
 */