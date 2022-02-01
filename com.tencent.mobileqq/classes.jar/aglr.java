import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.widget.ImageButton;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.widget.XEditTextEx;

class aglr
  implements ViewTreeObserver.OnGlobalLayoutListener
{
  aglr(aglj paramaglj) {}
  
  public void onGlobalLayout()
  {
    if ((aglj.a(this.a).a.getLineCount() > 3) && (aglj.a(this.a).h()) && (aglj.a(this.a).C()) && (!bcnj.b()))
    {
      this.a.a.setVisibility(0);
      return;
    }
    this.a.a.setVisibility(8);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aglr
 * JD-Core Version:    0.7.0.1
 */