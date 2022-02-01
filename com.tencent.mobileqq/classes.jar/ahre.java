import android.os.Handler;
import android.os.Looper;
import com.tencent.image.VideoDrawable.OnPlayRepeatListener;
import com.tencent.mobileqq.activity.aio.photo.AIOGalleryAdapter;
import com.tencent.mobileqq.activity.aio.photo.AIOGalleryAdapter.VideoListener.1;

public class ahre
  implements VideoDrawable.OnPlayRepeatListener
{
  public AIOGalleryAdapter a;
  
  public ahre(AIOGalleryAdapter paramAIOGalleryAdapter)
  {
    this.a = paramAIOGalleryAdapter;
  }
  
  public void onPlayRepeat(int paramInt)
  {
    if (paramInt != 1) {
      return;
    }
    new Handler(Looper.getMainLooper()).post(new AIOGalleryAdapter.VideoListener.1(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ahre
 * JD-Core Version:    0.7.0.1
 */