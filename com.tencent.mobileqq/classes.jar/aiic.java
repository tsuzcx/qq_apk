import android.view.SurfaceView;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import com.tencent.mobileqq.activity.shortvideo.ShortVideoPreviewActivity;
import com.tencent.qphone.base.util.QLog;

public class aiic
  implements ViewTreeObserver.OnGlobalLayoutListener
{
  public aiic(ShortVideoPreviewActivity paramShortVideoPreviewActivity) {}
  
  public void onGlobalLayout()
  {
    this.a.e = this.a.a.getWidth();
    this.a.f = this.a.a.getHeight();
    if (QLog.isColorLevel()) {
      QLog.d("ShortVideoPreviewActivity", 2, "onGlobalLayout,mSurfaceViewWidth:" + this.a.e + ",mSurfaceViewHeight:" + this.a.f);
    }
    this.a.a.getViewTreeObserver().removeGlobalOnLayoutListener(this);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     aiic
 * JD-Core Version:    0.7.0.1
 */