import android.content.Context;
import android.widget.TextView;
import com.tencent.widget.BubblePopupWindow;

public final class akbx
  extends TextView
{
  public akbx(Context paramContext, BubblePopupWindow paramBubblePopupWindow)
  {
    super(paramContext);
  }
  
  public boolean performClick()
  {
    boolean bool = super.performClick();
    this.a.a();
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     akbx
 * JD-Core Version:    0.7.0.1
 */