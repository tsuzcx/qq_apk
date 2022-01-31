import android.app.Activity;
import android.support.v4.app.FragmentActivity;
import android.text.TextPaint;
import android.text.style.ClickableSpan;
import android.view.View;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.activity.ChatFragment;

class adsj
  extends ClickableSpan
{
  adsj(adqy paramadqy, int paramInt) {}
  
  public void onClick(View paramView)
  {
    if ((this.jdField_a_of_type_Adqy.a instanceof Activity))
    {
      paramView = bfol.a(this.jdField_a_of_type_Adqy.a);
      paramView.b(2131691945);
      paramView.c(2131690596);
      paramView.a(new adsk(this, paramView));
      paramView.show();
      BaseChatPie localBaseChatPie = ((FragmentActivity)this.jdField_a_of_type_Adqy.a).getChatFragment().a();
      if ((localBaseChatPie instanceof aeoe)) {
        ((aeoe)localBaseChatPie).a = paramView;
      }
    }
  }
  
  public void updateDrawState(TextPaint paramTextPaint)
  {
    paramTextPaint.setColor(-12541697);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     adsj
 * JD-Core Version:    0.7.0.1
 */