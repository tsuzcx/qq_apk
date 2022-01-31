import android.app.Activity;
import android.support.v4.app.FragmentActivity;
import android.text.TextPaint;
import android.text.style.ClickableSpan;
import android.view.View;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.activity.ChatFragment;

class afpb
  extends ClickableSpan
{
  afpb(afnq paramafnq, int paramInt) {}
  
  public void onClick(View paramView)
  {
    if ((this.jdField_a_of_type_Afnq.a instanceof Activity))
    {
      paramView = bhuf.a(this.jdField_a_of_type_Afnq.a);
      paramView.b(2131692001);
      paramView.c(2131690648);
      paramView.a(new afpc(this, paramView));
      paramView.show();
      BaseChatPie localBaseChatPie = ((FragmentActivity)this.jdField_a_of_type_Afnq.a).getChatFragment().a();
      if ((localBaseChatPie instanceof agpi)) {
        ((agpi)localBaseChatPie).a = paramView;
      }
    }
  }
  
  public void updateDrawState(TextPaint paramTextPaint)
  {
    paramTextPaint.setColor(-12541697);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     afpb
 * JD-Core Version:    0.7.0.1
 */