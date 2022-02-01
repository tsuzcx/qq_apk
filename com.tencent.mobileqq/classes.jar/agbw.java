import android.app.Activity;
import android.support.v4.app.FragmentActivity;
import android.text.TextPaint;
import android.text.style.ClickableSpan;
import android.view.View;
import com.tencent.mobileqq.activity.ChatFragment;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;

class agbw
  extends ClickableSpan
{
  agbw(agap paramagap, int paramInt) {}
  
  public void onClick(View paramView)
  {
    if ((this.jdField_a_of_type_Agap.a instanceof Activity))
    {
      paramView = bjnw.a(this.jdField_a_of_type_Agap.a);
      paramView.b(2131691717);
      paramView.c(2131690620);
      paramView.a(new agbx(this, paramView));
      paramView.show();
      BaseChatPie localBaseChatPie = ((FragmentActivity)this.jdField_a_of_type_Agap.a).getChatFragment().a();
      if ((localBaseChatPie instanceof afim)) {
        ((afim)localBaseChatPie).a = paramView;
      }
    }
  }
  
  public void updateDrawState(TextPaint paramTextPaint)
  {
    paramTextPaint.setColor(-12541697);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     agbw
 * JD-Core Version:    0.7.0.1
 */