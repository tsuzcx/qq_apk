import android.widget.EditText;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.nearby.now.view.ShortVideoCommentsView;
import mqq.os.MqqHandler;

public class aekt
  implements Runnable
{
  long jdField_a_of_type_Long;
  
  public aekt(ShortVideoCommentsView paramShortVideoCommentsView, long paramLong)
  {
    this.jdField_a_of_type_Long = paramLong;
  }
  
  public void run()
  {
    if (System.currentTimeMillis() - this.jdField_a_of_type_Long > 1000L) {
      return;
    }
    ShortVideoCommentsView.a(this.jdField_a_of_type_ComTencentMobileqqNearbyNowViewShortVideoCommentsView).setFocusable(true);
    ShortVideoCommentsView.a(this.jdField_a_of_type_ComTencentMobileqqNearbyNowViewShortVideoCommentsView).setFocusableInTouchMode(true);
    ShortVideoCommentsView.a(this.jdField_a_of_type_ComTencentMobileqqNearbyNowViewShortVideoCommentsView).requestFocus();
    ThreadManager.getUIHandler().postDelayed(this, 100L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aekt
 * JD-Core Version:    0.7.0.1
 */