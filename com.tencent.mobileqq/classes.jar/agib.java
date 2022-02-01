import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.widget.ImageButton;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.widget.XEditTextEx;

class agib
  implements ViewTreeObserver.OnGlobalLayoutListener
{
  agib(aght paramaght) {}
  
  public void onGlobalLayout()
  {
    if ((aght.a(this.a).input.getLineCount() > 3) && (aght.a(this.a).enableFullScreenInput()) && (aght.a(this.a).getInputEnable()) && (!bdfk.b()))
    {
      this.a.a.setVisibility(0);
      return;
    }
    this.a.a.setVisibility(8);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     agib
 * JD-Core Version:    0.7.0.1
 */