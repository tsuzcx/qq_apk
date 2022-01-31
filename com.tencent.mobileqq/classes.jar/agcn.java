import android.view.Surface;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import com.tencent.mobileqq.activity.photo.PhotoPreviewActivity;
import com.tencent.qphone.base.util.QLog;

public class agcn
  implements basv
{
  public agcn(PhotoPreviewActivity paramPhotoPreviewActivity) {}
  
  public void a(bass parambass)
  {
    if (QLog.isColorLevel()) {
      QLog.d("PhotoPreviewActivity", 2, "mMediaPlayer onPrepared: ");
    }
    SurfaceHolder localSurfaceHolder = this.a.jdField_a_of_type_AndroidViewSurfaceView.getHolder();
    if ((localSurfaceHolder == null) || (!localSurfaceHolder.getSurface().isValid()))
    {
      apcb.a(2131625742);
      return;
    }
    azzn.a(this.a.jdField_a_of_type_AndroidViewSurfaceView, this.a.p, this.a.q, this.a.jdField_a_of_type_Bass.d(), this.a.jdField_a_of_type_Bass.e());
    parambass.a(localSurfaceHolder);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     agcn
 * JD-Core Version:    0.7.0.1
 */