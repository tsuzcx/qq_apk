import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import com.tencent.mobileqq.ark.ArkViewAdjustFromKeyboard;

public class aark
  implements ViewTreeObserver.OnGlobalLayoutListener
{
  public aark(ArkViewAdjustFromKeyboard paramArkViewAdjustFromKeyboard) {}
  
  public void onGlobalLayout()
  {
    ArkViewAdjustFromKeyboard.a(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aark
 * JD-Core Version:    0.7.0.1
 */