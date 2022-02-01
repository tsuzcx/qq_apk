import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import com.tencent.mobileqq.activity.contact.addcontact.findtroop.AddContactViewPagerTroopFragment;

public class aivt
  implements View.OnTouchListener
{
  float jdField_a_of_type_Float = 0.0F;
  
  public aivt(AddContactViewPagerTroopFragment paramAddContactViewPagerTroopFragment) {}
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    if (paramMotionEvent.getAction() == 0)
    {
      this.jdField_a_of_type_Float = paramView.getAlpha();
      paramView.setAlpha(this.jdField_a_of_type_Float * 0.5F);
    }
    for (;;)
    {
      return false;
      if ((paramMotionEvent.getAction() == 1) || (paramMotionEvent.getAction() == 3)) {
        paramView.setAlpha(this.jdField_a_of_type_Float);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aivt
 * JD-Core Version:    0.7.0.1
 */