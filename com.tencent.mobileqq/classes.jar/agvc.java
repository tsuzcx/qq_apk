import android.app.Activity;
import android.text.TextPaint;
import android.text.style.ClickableSpan;
import android.view.View;

class agvc
  extends ClickableSpan
{
  agvc(agup paramagup) {}
  
  public void onClick(View paramView)
  {
    if ((this.a.jdField_a_of_type_AndroidContentContext instanceof Activity))
    {
      paramView = bkho.a(this.a.jdField_a_of_type_AndroidContentContext);
      paramView.b(2131718646);
      paramView.c(2131690582);
      paramView.a(new agvd(this));
      paramView.a(new agve(this, paramView));
      paramView.show();
      bcst.b(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8005973", "0X8005973", 0, 0, "", "", "", "");
    }
  }
  
  public void updateDrawState(TextPaint paramTextPaint)
  {
    paramTextPaint.setColor(-12541697);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     agvc
 * JD-Core Version:    0.7.0.1
 */