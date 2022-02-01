import com.tencent.image.VideoDrawable.OnAudioPlayOnceListener;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;

class ahrk
  implements VideoDrawable.OnAudioPlayOnceListener
{
  ahrk(ahri paramahri) {}
  
  public void onFinish()
  {
    if (QLog.isColorLevel()) {
      QLog.e("ShortVideoPTVItemBuilder", 2, "VideoDrawable.OnAudioPlayOnceListener.onFinish");
    }
    if ((ahri.a() != null) && (ahri.a().get() != null))
    {
      ahri.a(ahri.a(this.a), (ChatMessage)ahri.a().get());
      ahri.a(null);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ahrk
 * JD-Core Version:    0.7.0.1
 */