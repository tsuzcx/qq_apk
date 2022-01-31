import android.view.Surface;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import com.tencent.mobileqq.activity.photo.PhotoPreviewActivity;
import com.tencent.qphone.base.util.QLog;

public class agol
  implements bbvd
{
  public agol(PhotoPreviewActivity paramPhotoPreviewActivity) {}
  
  public void a(bbva parambbva)
  {
    if (QLog.isColorLevel()) {
      QLog.d("PhotoPreviewActivity", 2, "mMediaPlayer onPrepared: ");
    }
    SurfaceHolder localSurfaceHolder = this.a.jdField_a_of_type_AndroidViewSurfaceView.getHolder();
    if ((localSurfaceHolder == null) || (!localSurfaceHolder.getSurface().isValid()))
    {
      aptv.a(2131691318);
      return;
    }
    bbar.a(this.a.jdField_a_of_type_AndroidViewSurfaceView, this.a.p, this.a.q, this.a.jdField_a_of_type_Bbva.d(), this.a.jdField_a_of_type_Bbva.e());
    parambbva.a(localSurfaceHolder);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     agol
 * JD-Core Version:    0.7.0.1
 */