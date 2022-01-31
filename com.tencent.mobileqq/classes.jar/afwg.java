import com.tencent.image.VideoDrawable.OnAudioPlayOnceListener;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;

class afwg
  implements VideoDrawable.OnAudioPlayOnceListener
{
  afwg(afwe paramafwe) {}
  
  public void onFinish()
  {
    if (QLog.isColorLevel()) {
      QLog.e("ShortVideoPTVItemBuilder", 2, "VideoDrawable.OnAudioPlayOnceListener.onFinish");
    }
    if ((afwe.a() != null) && (afwe.a().get() != null))
    {
      afwe.a(afwe.a(this.a), (ChatMessage)afwe.a().get());
      afwe.a(null);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     afwg
 * JD-Core Version:    0.7.0.1
 */