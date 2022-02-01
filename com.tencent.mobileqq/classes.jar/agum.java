import android.app.Activity;
import android.support.v4.app.FragmentActivity;
import android.text.TextPaint;
import android.text.style.ClickableSpan;
import android.view.View;
import com.tencent.mobileqq.activity.ChatFragment;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;

class agum
  extends ClickableSpan
{
  agum(agtf paramagtf, int paramInt) {}
  
  public void onClick(View paramView)
  {
    if ((this.jdField_a_of_type_Agtf.a instanceof Activity))
    {
      paramView = bkzi.a(this.jdField_a_of_type_Agtf.a);
      paramView.b(2131691805);
      paramView.c(2131690697);
      paramView.a(new agun(this, paramView));
      paramView.show();
      BaseChatPie localBaseChatPie = ((FragmentActivity)this.jdField_a_of_type_Agtf.a).getChatFragment().a();
      if ((localBaseChatPie instanceof afzr)) {
        ((afzr)localBaseChatPie).a = paramView;
      }
    }
  }
  
  public void updateDrawState(TextPaint paramTextPaint)
  {
    paramTextPaint.setColor(-12541697);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     agum
 * JD-Core Version:    0.7.0.1
 */