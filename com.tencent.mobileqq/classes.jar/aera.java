import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.mobileqq.nearby.interestTag.ChooseInterestTagActivity;
import com.tencent.mobileqq.widget.MonitorSizeChangeHSV;

class aera
  implements Runnable
{
  aera(aeqz paramaeqz, int paramInt) {}
  
  public void run()
  {
    if (this.jdField_a_of_type_Int >= 0)
    {
      ((RelativeLayout.LayoutParams)ChooseInterestTagActivity.a(this.jdField_a_of_type_Aeqz.a).getLayoutParams()).leftMargin = ((int)(this.jdField_a_of_type_Int + ChooseInterestTagActivity.a(this.jdField_a_of_type_Aeqz.a) * 7.0F));
      ChooseInterestTagActivity.a(this.jdField_a_of_type_Aeqz.a).requestLayout();
    }
    RelativeLayout.LayoutParams localLayoutParams;
    if (ChooseInterestTagActivity.a(this.jdField_a_of_type_Aeqz.a).getChildCount() <= 0)
    {
      ChooseInterestTagActivity.a(this.jdField_a_of_type_Aeqz.a).setVisibility(8);
      if (ChooseInterestTagActivity.b(this.jdField_a_of_type_Aeqz.a))
      {
        localLayoutParams = (RelativeLayout.LayoutParams)ChooseInterestTagActivity.a(this.jdField_a_of_type_Aeqz.a).getLayoutParams();
        localLayoutParams.height = 1;
        if (!ChooseInterestTagActivity.a(this.jdField_a_of_type_Aeqz.a)) {
          break label183;
        }
      }
    }
    label183:
    for (int i = (int)(ChooseInterestTagActivity.a(this.jdField_a_of_type_Aeqz.a) * 7.0F + 0.5D);; i = 0)
    {
      localLayoutParams.topMargin = i;
      localLayoutParams.bottomMargin = i;
      ChooseInterestTagActivity.a(this.jdField_a_of_type_Aeqz.a).setLayoutParams(localLayoutParams);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aera
 * JD-Core Version:    0.7.0.1
 */