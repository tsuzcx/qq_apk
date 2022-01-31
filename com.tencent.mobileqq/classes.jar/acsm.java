import android.view.View;
import com.tencent.image.GifDrawable;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawableDownListener;
import com.tencent.mobileqq.activity.aio.doodle.DoodleMsgLayout;

public class acsm
  implements URLDrawableDownListener
{
  public acsm(DoodleMsgLayout paramDoodleMsgLayout) {}
  
  public void onLoadCancelled(View paramView, URLDrawable paramURLDrawable) {}
  
  public void onLoadFailed(View paramView, URLDrawable paramURLDrawable, Throwable paramThrowable) {}
  
  public void onLoadInterrupted(View paramView, URLDrawable paramURLDrawable, InterruptedException paramInterruptedException) {}
  
  public void onLoadProgressed(View paramView, URLDrawable paramURLDrawable, int paramInt) {}
  
  public void onLoadSuccessed(View paramView, URLDrawable paramURLDrawable)
  {
    if (paramView == DoodleMsgLayout.a(this.a))
    {
      DoodleMsgLayout.a(this.a, true);
      DoodleMsgLayout.a(this.a);
    }
    do
    {
      return;
      if (paramView == DoodleMsgLayout.b(this.a))
      {
        ((GifDrawable)paramURLDrawable.getCurrDrawable()).setGIFPlayOnceListener(this.a);
        return;
      }
    } while (paramView != DoodleMsgLayout.c(this.a));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     acsm
 * JD-Core Version:    0.7.0.1
 */