import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.widget.ImageButton;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.widget.XEditTextEx;

class afqr
  implements ViewTreeObserver.OnGlobalLayoutListener
{
  afqr(afqj paramafqj) {}
  
  public void onGlobalLayout()
  {
    if ((afqj.a(this.a).input.getLineCount() > 3) && (afqj.a(this.a).enableFullScreenInput()) && (afqj.a(this.a).getInputEnable()) && (!bbyp.b()))
    {
      this.a.a.setVisibility(0);
      return;
    }
    this.a.a.setVisibility(8);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     afqr
 * JD-Core Version:    0.7.0.1
 */