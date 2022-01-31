import android.util.Log;
import com.tencent.mobileqq.lyric.data.Lyric;
import com.tencent.mobileqq.lyric.widget.LyricViewController;
import com.tencent.mobileqq.lyric.widget.LyricViewInternal;

public class aecy
  implements Runnable
{
  public aecy(LyricViewController paramLyricViewController, Lyric paramLyric1, Lyric paramLyric2, Lyric paramLyric3) {}
  
  public void run()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqLyricDataLyric == null) {
      Log.d("ModuleController", "setLyric -> pronounce is null");
    }
    if (this.b == null)
    {
      Log.d("ModuleController", "setLyric -> qrc is null");
      this.jdField_a_of_type_ComTencentMobileqqLyricWidgetLyricViewController.jdField_a_of_type_ComTencentMobileqqLyricWidgetLyricViewInternal.a(this.c, this.jdField_a_of_type_ComTencentMobileqqLyricDataLyric);
      this.jdField_a_of_type_ComTencentMobileqqLyricWidgetLyricViewController.jdField_a_of_type_ComTencentMobileqqLyricDataLyric = this.c;
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqLyricWidgetLyricViewController.jdField_a_of_type_ComTencentMobileqqLyricWidgetLyricViewInternal.a(this.b, this.jdField_a_of_type_ComTencentMobileqqLyricDataLyric);
    this.jdField_a_of_type_ComTencentMobileqqLyricWidgetLyricViewController.jdField_a_of_type_ComTencentMobileqqLyricDataLyric = this.b;
    this.jdField_a_of_type_ComTencentMobileqqLyricWidgetLyricViewController.b = this.jdField_a_of_type_ComTencentMobileqqLyricWidgetLyricViewController.jdField_a_of_type_ComTencentMobileqqLyricDataLyric.c();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aecy
 * JD-Core Version:    0.7.0.1
 */