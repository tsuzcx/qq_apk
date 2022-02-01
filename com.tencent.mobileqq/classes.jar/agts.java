import android.app.Activity;
import android.text.TextPaint;
import android.text.style.ClickableSpan;
import android.view.View;

class agts
  extends ClickableSpan
{
  agts(agtf paramagtf) {}
  
  public void onClick(View paramView)
  {
    if ((this.a.jdField_a_of_type_AndroidContentContext instanceof Activity))
    {
      paramView = bkzi.a(this.a.jdField_a_of_type_AndroidContentContext);
      paramView.b(2131719436);
      paramView.c(2131690697);
      paramView.a(new agtt(this));
      agtf.a(this.a, paramView);
      paramView.show();
      bdla.b(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8005973", "0X8005973", 0, 0, "", "", "", "");
    }
  }
  
  public void updateDrawState(TextPaint paramTextPaint)
  {
    paramTextPaint.setColor(-12541697);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     agts
 * JD-Core Version:    0.7.0.1
 */