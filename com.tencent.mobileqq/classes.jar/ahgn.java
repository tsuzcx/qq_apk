import com.tencent.image.VideoDrawable.OnAudioPlayOnceListener;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;

class ahgn
  implements VideoDrawable.OnAudioPlayOnceListener
{
  ahgn(ahgl paramahgl) {}
  
  public void onFinish()
  {
    if (QLog.isColorLevel()) {
      QLog.e("ShortVideoPTVItemBuilder", 2, "VideoDrawable.OnAudioPlayOnceListener.onFinish");
    }
    if ((ahgl.a() != null) && (ahgl.a().get() != null))
    {
      ahgl.a(ahgl.a(this.a), (ChatMessage)ahgl.a().get());
      ahgl.a(null);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ahgn
 * JD-Core Version:    0.7.0.1
 */