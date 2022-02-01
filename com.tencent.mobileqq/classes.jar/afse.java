import android.graphics.Color;
import android.text.TextPaint;
import android.text.style.ClickableSpan;
import android.view.View;
import com.tencent.mobileqq.activity.activateFriend.ActivateFriendActivity;

public class afse
  extends ClickableSpan
{
  public afse(ActivateFriendActivity paramActivateFriendActivity) {}
  
  public void onClick(View paramView)
  {
    this.a.b();
  }
  
  public void updateDrawState(TextPaint paramTextPaint)
  {
    paramTextPaint.setColor(Color.rgb(0, 165, 224));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     afse
 * JD-Core Version:    0.7.0.1
 */