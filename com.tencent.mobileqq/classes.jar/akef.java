import android.view.SurfaceHolder;
import android.view.SurfaceHolder.Callback;
import android.widget.ImageView;
import com.tencent.mobileqq.activity.shortvideo.ShortVideoPreviewActivity;
import com.tencent.qphone.base.util.QLog;
import mqq.os.MqqHandler;

public class akef
  implements SurfaceHolder.Callback
{
  public akef(ShortVideoPreviewActivity paramShortVideoPreviewActivity) {}
  
  public void surfaceChanged(SurfaceHolder paramSurfaceHolder, int paramInt1, int paramInt2, int paramInt3) {}
  
  public void surfaceCreated(SurfaceHolder paramSurfaceHolder)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ShortVideoPreviewActivity", 2, "surfaceCreated: mSavedCurPosition:" + this.a.g + ",mSavedPlayState : " + this.a.a(this.a.h));
    }
    if ((this.a.h == 1) && (this.a.g > 0))
    {
      this.a.a(this.a.g);
      this.a.g = 0;
      this.a.h = 0;
      return;
    }
    this.a.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
  }
  
  public void surfaceDestroyed(SurfaceHolder paramSurfaceHolder)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ShortVideoPreviewActivity", 2, "surfaceDestroyed ");
    }
    if (this.a.jdField_a_of_type_Bdzk != null) {
      this.a.jdField_a_of_type_Bdzk.c();
    }
    if (this.a.jdField_a_of_type_MqqOsMqqHandler != null) {
      this.a.jdField_a_of_type_MqqOsMqqHandler.removeCallbacks(this.a.jdField_a_of_type_JavaLangRunnable);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     akef
 * JD-Core Version:    0.7.0.1
 */