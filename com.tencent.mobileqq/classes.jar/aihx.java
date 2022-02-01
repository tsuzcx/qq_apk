import android.view.View;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawableDownListener;
import com.tencent.mobileqq.activity.aio.stickerrecommended.StickerRecCacheEntity;
import com.tencent.qphone.base.util.QLog;
import java.util.HashSet;
import java.util.List;
import org.apache.http.Header;

class aihx
  implements URLDrawableDownListener
{
  aihx(aihw paramaihw) {}
  
  public void onLoadCancelled(View paramView, URLDrawable paramURLDrawable)
  {
    if (QLog.isColorLevel()) {
      QLog.d("StickerRecBarAdapter", 2, "drawableListener onLoadCancelled");
    }
  }
  
  public void onLoadFailed(View paramView, URLDrawable paramURLDrawable, Throwable paramThrowable)
  {
    aihw.a(this.a, paramURLDrawable);
    if (QLog.isColorLevel()) {
      QLog.e("StickerRecBarAdapter", 2, "drawableListener onLoadFialed:" + paramURLDrawable.getURL(), paramThrowable);
    }
  }
  
  public void onLoadInterrupted(View paramView, URLDrawable paramURLDrawable, InterruptedException paramInterruptedException)
  {
    if (QLog.isColorLevel()) {
      QLog.d("StickerRecBarAdapter", 2, "drawableListener onLoadInterrupted");
    }
  }
  
  public void onLoadProgressed(View paramView, URLDrawable paramURLDrawable, int paramInt) {}
  
  public void onLoadSuccessed(View paramView, URLDrawable paramURLDrawable)
  {
    l2 = -1L;
    try
    {
      Object localObject = paramURLDrawable.getHeader("report_key_start_download");
      l1 = l2;
      if (localObject != null)
      {
        localObject = ((Header)localObject).getValue();
        l1 = l2;
        if (localObject != null)
        {
          l1 = Long.parseLong((String)localObject);
          long l3 = System.currentTimeMillis();
          l1 = l3 - l1;
        }
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        long l1 = l2;
        if (QLog.isColorLevel())
        {
          QLog.e("StickerRecBarAdapter", 2, "onLoadSuccessed:get start download time");
          l1 = l2;
        }
      }
    }
    aihw.a(this.a, paramURLDrawable, l1);
    paramView = paramView.getTag();
    if (aiin.b((aihq)paramView))
    {
      paramView = (aiig)paramView;
      if ((aiin.b(paramView)) && (!aihw.a(this.a).contains(paramView.k())))
      {
        aihw.a(this.a).add(paramView.k());
        paramURLDrawable = paramView.m();
        aihw.a(this.a).add(new StickerRecCacheEntity(paramURLDrawable, System.currentTimeMillis(), paramView.k()));
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aihx
 * JD-Core Version:    0.7.0.1
 */