import android.graphics.drawable.BitmapDrawable;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableListener;
import com.tencent.mqq.MqqImageLoader;
import com.tencent.plato.sdk.IImageLoader.Listener;

public class alhb
  implements URLDrawable.URLDrawableListener
{
  public alhb(MqqImageLoader paramMqqImageLoader, IImageLoader.Listener paramListener) {}
  
  public void onLoadCanceled(URLDrawable paramURLDrawable) {}
  
  public void onLoadFialed(URLDrawable paramURLDrawable, Throwable paramThrowable) {}
  
  public void onLoadProgressed(URLDrawable paramURLDrawable, int paramInt) {}
  
  public void onLoadSuccessed(URLDrawable paramURLDrawable)
  {
    if (this.jdField_a_of_type_ComTencentPlatoSdkIImageLoader$Listener != null)
    {
      paramURLDrawable = paramURLDrawable.getCurrDrawable();
      this.jdField_a_of_type_ComTencentPlatoSdkIImageLoader$Listener.onLoad((BitmapDrawable)paramURLDrawable);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     alhb
 * JD-Core Version:    0.7.0.1
 */