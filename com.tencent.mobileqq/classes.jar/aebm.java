import android.support.v4.view.ViewPager;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.leba.view.LebaGridIndicator;

public class aebm
  implements View.OnClickListener
{
  public aebm(LebaGridIndicator paramLebaGridIndicator, int paramInt) {}
  
  public void onClick(View paramView)
  {
    if (LebaGridIndicator.a(this.jdField_a_of_type_ComTencentMobileqqLebaViewLebaGridIndicator) != null) {
      LebaGridIndicator.b(this.jdField_a_of_type_ComTencentMobileqqLebaViewLebaGridIndicator).setCurrentItem(this.jdField_a_of_type_Int);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aebm
 * JD-Core Version:    0.7.0.1
 */