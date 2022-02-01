import android.view.SurfaceView;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import com.tencent.mobileqq.activity.shortvideo.ShortVideoPreviewActivity;
import com.tencent.qphone.base.util.QLog;

public class ambl
  implements ViewTreeObserver.OnGlobalLayoutListener
{
  public ambl(ShortVideoPreviewActivity paramShortVideoPreviewActivity) {}
  
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     ambl
 * JD-Core Version:    0.7.0.1
 */