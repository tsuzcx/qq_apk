import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.widget.ImageButton;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.widget.XEditTextEx;

class agus
  implements ViewTreeObserver.OnGlobalLayoutListener
{
  agus(aguk paramaguk) {}
  
  public void onGlobalLayout()
  {
    if ((aguk.a(this.a).a.getLineCount() > 3) && (aguk.a(this.a).h()) && (aguk.a(this.a).C()) && (!bdgb.b()))
    {
      this.a.a.setVisibility(0);
      return;
    }
    this.a.a.setVisibility(8);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     agus
 * JD-Core Version:    0.7.0.1
 */