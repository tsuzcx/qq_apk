import android.app.Activity;
import android.support.v4.app.FragmentActivity;
import android.text.TextPaint;
import android.text.style.ClickableSpan;
import android.view.View;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.activity.ChatFragment;

class ahfk
  extends ClickableSpan
{
  ahfk(ahed paramahed, int paramInt) {}
  
  public void onClick(View paramView)
  {
    if ((this.jdField_a_of_type_Ahed.a instanceof Activity))
    {
      paramView = blir.a(this.jdField_a_of_type_Ahed.a);
      paramView.b(2131691672);
      paramView.c(2131690580);
      paramView.a(new ahfl(this, paramView));
      paramView.show();
      BaseChatPie localBaseChatPie = ((FragmentActivity)this.jdField_a_of_type_Ahed.a).getChatFragment().a();
      if ((localBaseChatPie instanceof aijc)) {
        ((aijc)localBaseChatPie).a = paramView;
      }
    }
  }
  
  public void updateDrawState(TextPaint paramTextPaint)
  {
    paramTextPaint.setColor(-12541697);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ahfk
 * JD-Core Version:    0.7.0.1
 */