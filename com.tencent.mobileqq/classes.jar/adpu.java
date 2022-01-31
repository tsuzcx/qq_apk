import android.os.SystemClock;
import android.util.Log;
import com.tencent.mobileqq.lyric.data.Lyric;
import com.tencent.mobileqq.lyric.widget.LyricViewController;
import com.tencent.mobileqq.lyric.widget.LyricViewInternal;

public class adpu
  implements Runnable
{
  public adpu(LyricViewController paramLyricViewController, int paramInt) {}
  
  public void run()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqLyricWidgetLyricViewController.jdField_a_of_type_ComTencentMobileqqLyricWidgetLyricViewInternal != null) {
      this.jdField_a_of_type_ComTencentMobileqqLyricWidgetLyricViewController.jdField_a_of_type_ComTencentMobileqqLyricWidgetLyricViewInternal.b();
    }
    if ((this.jdField_a_of_type_ComTencentMobileqqLyricWidgetLyricViewController.jdField_a_of_type_ComTencentMobileqqLyricDataLyric == null) || (this.jdField_a_of_type_ComTencentMobileqqLyricWidgetLyricViewController.jdField_a_of_type_ComTencentMobileqqLyricDataLyric.a()))
    {
      Log.w("ModuleController", "seek before set lyric");
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqLyricWidgetLyricViewController.jdField_a_of_type_Long = (SystemClock.elapsedRealtime() - this.jdField_a_of_type_Int);
    if ((this.jdField_a_of_type_ComTencentMobileqqLyricWidgetLyricViewController.b) && (this.jdField_a_of_type_ComTencentMobileqqLyricWidgetLyricViewController.jdField_a_of_type_Int > 0))
    {
      LyricViewController localLyricViewController = this.jdField_a_of_type_ComTencentMobileqqLyricWidgetLyricViewController;
      localLyricViewController.jdField_a_of_type_Long -= this.jdField_a_of_type_ComTencentMobileqqLyricWidgetLyricViewController.jdField_a_of_type_Int;
    }
    LyricViewController.a(this.jdField_a_of_type_ComTencentMobileqqLyricWidgetLyricViewController);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     adpu
 * JD-Core Version:    0.7.0.1
 */