import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.mobileqq.nearby.interestTag.ChooseInterestTagActivity;
import com.tencent.mobileqq.widget.MonitorSizeChangeHSV;

class aedu
  implements Runnable
{
  aedu(aedt paramaedt, int paramInt) {}
  
  public void run()
  {
    if (this.jdField_a_of_type_Int >= 0)
    {
      ((RelativeLayout.LayoutParams)ChooseInterestTagActivity.a(this.jdField_a_of_type_Aedt.a).getLayoutParams()).leftMargin = ((int)(this.jdField_a_of_type_Int + ChooseInterestTagActivity.a(this.jdField_a_of_type_Aedt.a) * 7.0F));
      ChooseInterestTagActivity.a(this.jdField_a_of_type_Aedt.a).requestLayout();
    }
    RelativeLayout.LayoutParams localLayoutParams;
    if (ChooseInterestTagActivity.a(this.jdField_a_of_type_Aedt.a).getChildCount() <= 0)
    {
      ChooseInterestTagActivity.a(this.jdField_a_of_type_Aedt.a).setVisibility(8);
      if (ChooseInterestTagActivity.b(this.jdField_a_of_type_Aedt.a))
      {
        localLayoutParams = (RelativeLayout.LayoutParams)ChooseInterestTagActivity.a(this.jdField_a_of_type_Aedt.a).getLayoutParams();
        localLayoutParams.height = 1;
        if (!ChooseInterestTagActivity.a(this.jdField_a_of_type_Aedt.a)) {
          break label183;
        }
      }
    }
    label183:
    for (int i = (int)(ChooseInterestTagActivity.a(this.jdField_a_of_type_Aedt.a) * 7.0F + 0.5D);; i = 0)
    {
      localLayoutParams.topMargin = i;
      localLayoutParams.bottomMargin = i;
      ChooseInterestTagActivity.a(this.jdField_a_of_type_Aedt.a).setLayoutParams(localLayoutParams);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aedu
 * JD-Core Version:    0.7.0.1
 */