import android.view.SurfaceView;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import com.tencent.mobileqq.activity.photo.PhotoPreviewActivity;
import com.tencent.qphone.base.util.QLog;

public class agob
  implements ViewTreeObserver.OnGlobalLayoutListener
{
  public agob(PhotoPreviewActivity paramPhotoPreviewActivity) {}
  
  public void onGlobalLayout()
  {
    this.a.p = this.a.a.getWidth();
    this.a.q = this.a.a.getHeight();
    if (QLog.isColorLevel()) {
      QLog.d("PhotoPreviewActivity", 2, "onGlobalLayout,mSurfaceViewWidth:" + this.a.p + ",mSurfaceViewHeight:" + this.a.q);
    }
    this.a.a.getViewTreeObserver().removeGlobalOnLayoutListener(this);
    this.a.a.setVisibility(8);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     agob
 * JD-Core Version:    0.7.0.1
 */