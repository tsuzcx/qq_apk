import android.app.Activity;
import android.support.v4.app.FragmentActivity;
import android.text.TextPaint;
import android.text.style.ClickableSpan;
import android.view.View;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.activity.ChatFragment;

class agvw
  extends ClickableSpan
{
  agvw(agup paramagup, int paramInt) {}
  
  public void onClick(View paramView)
  {
    if ((this.jdField_a_of_type_Agup.a instanceof Activity))
    {
      paramView = bkho.a(this.jdField_a_of_type_Agup.a);
      paramView.b(2131691669);
      paramView.c(2131690582);
      paramView.a(new agvx(this, paramView));
      paramView.show();
      BaseChatPie localBaseChatPie = ((FragmentActivity)this.jdField_a_of_type_Agup.a).getChatFragment().a();
      if ((localBaseChatPie instanceof ahzo)) {
        ((ahzo)localBaseChatPie).a = paramView;
      }
    }
  }
  
  public void updateDrawState(TextPaint paramTextPaint)
  {
    paramTextPaint.setColor(-12541697);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     agvw
 * JD-Core Version:    0.7.0.1
 */