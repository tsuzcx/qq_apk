import android.content.res.Resources;
import android.util.DisplayMetrics;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ScrollView;
import com.tencent.mobileqq.nearby.guide.NearbyGuideActivity;

public class aecz
  implements Runnable
{
  public aecz(NearbyGuideActivity paramNearbyGuideActivity) {}
  
  public void run()
  {
    int i = (int)(this.a.b.getBottom() - this.a.jdField_a_of_type_AndroidWidgetEditText.getBottom() + 30.0F * this.a.getResources().getDisplayMetrics().density);
    this.a.jdField_a_of_type_AndroidWidgetScrollView.smoothScrollBy(0, i);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aecz
 * JD-Core Version:    0.7.0.1
 */