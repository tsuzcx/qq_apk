import android.util.Log;
import com.tencent.mobileqq.lyric.widget.LyricViewScroll;
import com.tencent.mobileqq.lyric.widget.LyricViewScroll.LyricViewScrollListener;
import java.util.Timer;
import java.util.TimerTask;

public class aede
  extends TimerTask
{
  int jdField_a_of_type_Int;
  
  public aede(LyricViewScroll paramLyricViewScroll) {}
  
  public void run()
  {
    Log.v("LyricViewScroll", "fling detect running");
    if (this.jdField_a_of_type_Int == this.jdField_a_of_type_ComTencentMobileqqLyricWidgetLyricViewScroll.getScrollY())
    {
      this.jdField_a_of_type_ComTencentMobileqqLyricWidgetLyricViewScroll.jdField_a_of_type_Int = this.jdField_a_of_type_Int;
      LyricViewScroll.a(this.jdField_a_of_type_ComTencentMobileqqLyricWidgetLyricViewScroll).b(this.jdField_a_of_type_Int);
      Log.d("LyricViewScroll", "fling stop");
      this.jdField_a_of_type_ComTencentMobileqqLyricWidgetLyricViewScroll.jdField_a_of_type_JavaUtilTimer.cancel();
      this.jdField_a_of_type_ComTencentMobileqqLyricWidgetLyricViewScroll.jdField_a_of_type_Boolean = false;
      LyricViewScroll.a(this.jdField_a_of_type_ComTencentMobileqqLyricWidgetLyricViewScroll, false);
      return;
    }
    this.jdField_a_of_type_Int = this.jdField_a_of_type_ComTencentMobileqqLyricWidgetLyricViewScroll.getScrollY();
    LyricViewScroll.a(this.jdField_a_of_type_ComTencentMobileqqLyricWidgetLyricViewScroll).a(this.jdField_a_of_type_Int);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aede
 * JD-Core Version:    0.7.0.1
 */