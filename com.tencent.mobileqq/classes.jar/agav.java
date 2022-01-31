import com.tencent.image.VideoDrawable.OnAudioPlayOnceListener;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;

class agav
  implements VideoDrawable.OnAudioPlayOnceListener
{
  agav(agat paramagat) {}
  
  public void onFinish()
  {
    if (QLog.isColorLevel()) {
      QLog.e("ShortVideoPTVItemBuilder", 2, "VideoDrawable.OnAudioPlayOnceListener.onFinish");
    }
    if ((agat.a() != null) && (agat.a().get() != null))
    {
      agat.a(agat.a(this.a), (ChatMessage)agat.a().get());
      agat.a(null);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     agav
 * JD-Core Version:    0.7.0.1
 */