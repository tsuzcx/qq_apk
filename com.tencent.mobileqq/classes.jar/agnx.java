import com.tencent.image.VideoDrawable.OnAudioPlayOnceListener;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;

class agnx
  implements VideoDrawable.OnAudioPlayOnceListener
{
  agnx(agnv paramagnv) {}
  
  public void onFinish()
  {
    if (QLog.isColorLevel()) {
      QLog.e("ShortVideoPTVItemBuilder", 2, "VideoDrawable.OnAudioPlayOnceListener.onFinish");
    }
    if ((agnv.a() != null) && (agnv.a().get() != null))
    {
      agnv.a(agnv.a(this.a), (ChatMessage)agnv.a().get());
      agnv.a(null);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     agnx
 * JD-Core Version:    0.7.0.1
 */