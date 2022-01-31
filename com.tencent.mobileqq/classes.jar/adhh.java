import android.app.Activity;
import android.support.v4.app.FragmentActivity;
import android.text.TextPaint;
import android.text.style.ClickableSpan;
import android.view.View;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.activity.ChatFragment;

class adhh
  extends ClickableSpan
{
  adhh(adfw paramadfw, int paramInt) {}
  
  public void onClick(View paramView)
  {
    if ((this.jdField_a_of_type_Adfw.a instanceof Activity))
    {
      paramView = begr.a(this.jdField_a_of_type_Adfw.a);
      paramView.b(2131626362);
      paramView.c(2131625035);
      paramView.a(new adhi(this, paramView));
      paramView.show();
      BaseChatPie localBaseChatPie = ((FragmentActivity)this.jdField_a_of_type_Adfw.a).getChatFragment().a();
      if ((localBaseChatPie instanceof aede)) {
        ((aede)localBaseChatPie).a = paramView;
      }
    }
  }
  
  public void updateDrawState(TextPaint paramTextPaint)
  {
    paramTextPaint.setColor(-12541697);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     adhh
 * JD-Core Version:    0.7.0.1
 */