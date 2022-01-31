import android.view.Surface;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.widget.SeekBar;
import android.widget.TextView;
import com.tencent.mobileqq.activity.shortvideo.ShortVideoPreviewActivity;
import com.tencent.mobileqq.shortvideo.ShortVideoUtils;
import com.tencent.qphone.base.util.QLog;

public class ajzs
  implements bdve
{
  public ajzs(ShortVideoPreviewActivity paramShortVideoPreviewActivity) {}
  
  public void a(bdvb parambdvb)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ShortVideoPreviewActivity", 2, "mMediaPlayer onPrepared: mDuration=" + this.a.b);
    }
    SurfaceHolder localSurfaceHolder = this.a.jdField_a_of_type_AndroidViewSurfaceView.getHolder();
    if ((localSurfaceHolder == null) || (!localSurfaceHolder.getSurface().isValid())) {
      armz.a(2131691371);
    }
    do
    {
      do
      {
        return;
        bczz.a(this.a.jdField_a_of_type_AndroidViewSurfaceView, this.a.e, this.a.f, this.a.jdField_a_of_type_Bdvb.d(), this.a.jdField_a_of_type_Bdvb.e());
      } while (this.a.j != 10);
      parambdvb.a(localSurfaceHolder);
      this.a.jdField_a_of_type_Int = parambdvb.c();
    } while (this.a.jdField_a_of_type_Int <= 0);
    if (QLog.isColorLevel()) {
      QLog.d("ShortVideoPreviewActivity", 2, "此时的时长为" + ShortVideoUtils.a(this.a.jdField_a_of_type_Int));
    }
    this.a.d.setText(ShortVideoUtils.a(this.a.jdField_a_of_type_Int));
    this.a.jdField_a_of_type_AndroidWidgetSeekBar.setMax(this.a.jdField_a_of_type_Int);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ajzs
 * JD-Core Version:    0.7.0.1
 */