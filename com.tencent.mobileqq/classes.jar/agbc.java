import android.app.Activity;
import android.text.TextPaint;
import android.text.style.ClickableSpan;
import android.view.View;

class agbc
  extends ClickableSpan
{
  agbc(agap paramagap) {}
  
  public void onClick(View paramView)
  {
    if ((this.a.jdField_a_of_type_AndroidContentContext instanceof Activity))
    {
      paramView = bjnw.a(this.a.jdField_a_of_type_AndroidContentContext);
      paramView.b(2131719031);
      paramView.c(2131690620);
      paramView.a(new agbd(this));
      paramView.a(new agbe(this, paramView));
      paramView.show();
      bcef.b(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8005973", "0X8005973", 0, 0, "", "", "", "");
    }
  }
  
  public void updateDrawState(TextPaint paramTextPaint)
  {
    paramTextPaint.setColor(-12541697);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     agbc
 * JD-Core Version:    0.7.0.1
 */