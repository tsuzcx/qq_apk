import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import com.tencent.mobileqq.campuscircle.CampusCirclePublishActivity;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.ScrollView;

public class abik
  implements View.OnTouchListener
{
  public abik(CampusCirclePublishActivity paramCampusCirclePublishActivity) {}
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    int i;
    if (paramView == this.a.jdField_a_of_type_ComTencentWidgetPrefixXEditText)
    {
      i = paramMotionEvent.getAction() & 0xFF;
      if (i != 0) {
        break label51;
      }
      this.a.jdField_a_of_type_ComTencentWidgetScrollView.requestDisallowInterceptTouchEvent(true);
      if (QLog.isDevelopLevel()) {
        QLog.i("CampusCircle", 4, "disallow intercept touch event");
      }
    }
    label51:
    do
    {
      do
      {
        return false;
      } while ((i != 1) && (i != 3));
      this.a.jdField_a_of_type_ComTencentWidgetScrollView.requestDisallowInterceptTouchEvent(false);
    } while (!QLog.isDevelopLevel());
    QLog.i("CampusCircle", 4, "all intercept touch event");
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\aaa.jar
 * Qualified Name:     abik
 * JD-Core Version:    0.7.0.1
 */