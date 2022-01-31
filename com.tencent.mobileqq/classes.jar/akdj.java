import android.widget.SeekBar;
import android.widget.SeekBar.OnSeekBarChangeListener;
import com.tencent.mobileqq.activity.shortvideo.ShortVideoPlayActivity;
import com.tencent.qphone.base.util.QLog;

public class akdj
  implements SeekBar.OnSeekBarChangeListener
{
  public akdj(ShortVideoPlayActivity paramShortVideoPlayActivity) {}
  
  public void onProgressChanged(SeekBar paramSeekBar, int paramInt, boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ShortVideoPlayActivity", 2, "onProgressChanged: progress = " + paramInt + ",fromUser=" + paramBoolean);
    }
    this.a.m = true;
    if (paramBoolean)
    {
      paramSeekBar = this.a;
      paramSeekBar.h += 1;
      ShortVideoPlayActivity.b(this.a, true);
      ShortVideoPlayActivity.c(this.a, true);
    }
    this.a.b(paramInt * this.a.b / 10000L);
  }
  
  public void onStartTrackingTouch(SeekBar paramSeekBar)
  {
    int i = this.a.jdField_a_of_type_AndroidWidgetSeekBar.getProgress();
    ShortVideoPlayActivity.b(this.a, true);
    if (QLog.isColorLevel()) {
      QLog.d("ShortVideoPlayActivity", 2, "onStartTrackingTouch: progress = " + i);
    }
  }
  
  public void onStopTrackingTouch(SeekBar paramSeekBar)
  {
    this.a.l();
    paramSeekBar = this.a;
    paramSeekBar.i += 1;
    this.a.g = true;
    int i = this.a.jdField_a_of_type_AndroidWidgetSeekBar.getProgress();
    int j = (int)(i * this.a.b / 10000L);
    if (QLog.isColorLevel()) {
      QLog.d("ShortVideoPlayActivity", 2, "onStopTrackingTouch: seekProgress = " + i + ", mCacheProgress= " + ShortVideoPlayActivity.b(this.a) + ", timestamp = " + j);
    }
    if (this.a.jdField_a_of_type_JavaLangRefWeakReference != null)
    {
      if (this.a.jdField_a_of_type_Int == 2) {
        this.a.a();
      }
      this.a.a(j);
    }
    ShortVideoPlayActivity.b(this.a, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     akdj
 * JD-Core Version:    0.7.0.1
 */