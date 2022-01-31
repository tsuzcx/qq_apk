import android.app.Activity;
import android.support.v4.app.FragmentActivity;
import android.text.TextPaint;
import android.text.style.ClickableSpan;
import android.view.View;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.activity.ChatFragment;

class afkm
  extends ClickableSpan
{
  afkm(afjb paramafjb, int paramInt) {}
  
  public void onClick(View paramView)
  {
    if ((this.jdField_a_of_type_Afjb.a instanceof Activity))
    {
      paramView = bhpy.a(this.jdField_a_of_type_Afjb.a);
      paramView.b(2131692000);
      paramView.c(2131690648);
      paramView.a(new afkn(this, paramView));
      paramView.show();
      BaseChatPie localBaseChatPie = ((FragmentActivity)this.jdField_a_of_type_Afjb.a).getChatFragment().a();
      if ((localBaseChatPie instanceof agkt)) {
        ((agkt)localBaseChatPie).a = paramView;
      }
    }
  }
  
  public void updateDrawState(TextPaint paramTextPaint)
  {
    paramTextPaint.setColor(-12541697);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     afkm
 * JD-Core Version:    0.7.0.1
 */