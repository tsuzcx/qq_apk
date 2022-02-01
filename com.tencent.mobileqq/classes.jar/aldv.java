import android.view.Surface;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.widget.SeekBar;
import android.widget.TextView;
import com.tencent.mobileqq.activity.shortvideo.ShortVideoPreviewActivity;
import com.tencent.mobileqq.shortvideo.ShortVideoUtils;
import com.tencent.qphone.base.util.QLog;

public class aldv
  implements bgnn
{
  public aldv(ShortVideoPreviewActivity paramShortVideoPreviewActivity) {}
  
  public void a(bgnk parambgnk)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ShortVideoPreviewActivity", 2, "mMediaPlayer onPrepared: mDuration=" + this.a.b);
    }
    SurfaceHolder localSurfaceHolder = this.a.jdField_a_of_type_AndroidViewSurfaceView.getHolder();
    if ((localSurfaceHolder == null) || (!localSurfaceHolder.getSurface().isValid())) {
      aszk.a(2131691190);
    }
    do
    {
      do
      {
        return;
        bfst.a(this.a.jdField_a_of_type_AndroidViewSurfaceView, this.a.e, this.a.f, this.a.jdField_a_of_type_Bgnk.d(), this.a.jdField_a_of_type_Bgnk.e());
      } while (this.a.j != 10);
      parambgnk.a(localSurfaceHolder);
      this.a.jdField_a_of_type_Int = parambgnk.c();
    } while (this.a.jdField_a_of_type_Int <= 0);
    if (QLog.isColorLevel()) {
      QLog.d("ShortVideoPreviewActivity", 2, "此时的时长为" + ShortVideoUtils.stringForTime(this.a.jdField_a_of_type_Int));
    }
    this.a.d.setText(ShortVideoUtils.stringForTime(this.a.jdField_a_of_type_Int));
    this.a.jdField_a_of_type_AndroidWidgetSeekBar.setMax(this.a.jdField_a_of_type_Int);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aldv
 * JD-Core Version:    0.7.0.1
 */