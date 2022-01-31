import android.app.Activity;
import android.text.TextPaint;
import android.text.style.ClickableSpan;
import android.view.View;

class adgl
  extends ClickableSpan
{
  adgl(adfw paramadfw) {}
  
  public void onClick(View paramView)
  {
    if ((this.a.jdField_a_of_type_AndroidContentContext instanceof Activity))
    {
      paramView = begr.a(this.a.jdField_a_of_type_AndroidContentContext);
      paramView.b(2131654456);
      paramView.c(2131625035);
      paramView.a(new adgm(this));
      paramView.a(new adgn(this, paramView));
      paramView.show();
      awqx.b(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8005973", "0X8005973", 0, 0, "", "", "", "");
    }
  }
  
  public void updateDrawState(TextPaint paramTextPaint)
  {
    paramTextPaint.setColor(-12541697);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     adgl
 * JD-Core Version:    0.7.0.1
 */