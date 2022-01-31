import android.text.TextPaint;
import android.text.style.ClickableSpan;
import android.view.View;
import android.view.View.OnClickListener;

public class aaqs
  extends ClickableSpan
{
  private final View.OnClickListener a;
  
  public aaqs(View.OnClickListener paramOnClickListener)
  {
    this.a = paramOnClickListener;
  }
  
  public void onClick(View paramView)
  {
    this.a.onClick(paramView);
  }
  
  public void updateDrawState(TextPaint paramTextPaint)
  {
    paramTextPaint.setColor(1226741);
    paramTextPaint.setAlpha(255);
    paramTextPaint.setUnderlineText(false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aaqs
 * JD-Core Version:    0.7.0.1
 */