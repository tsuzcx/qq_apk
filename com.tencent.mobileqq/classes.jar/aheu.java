import android.app.Activity;
import android.text.TextPaint;
import android.text.style.ClickableSpan;
import android.view.View;

class aheu
  extends ClickableSpan
{
  aheu(ahed paramahed) {}
  
  public void onClick(View paramView)
  {
    if ((this.a.jdField_a_of_type_AndroidContentContext instanceof Activity))
    {
      paramView = blir.a(this.a.jdField_a_of_type_AndroidContentContext);
      paramView.b(2131718792);
      paramView.c(2131690580);
      paramView.a(new ahev(this));
      paramView.a(new ahew(this, paramView));
      paramView.show();
      bdll.b(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8005975", "0X8005975", 0, 0, "", "", "", "");
    }
  }
  
  public void updateDrawState(TextPaint paramTextPaint)
  {
    paramTextPaint.setColor(-12541697);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aheu
 * JD-Core Version:    0.7.0.1
 */