import android.view.animation.Animation;
import android.widget.TextView;
import com.tencent.mobileqq.activity.VisitorsActivity;

public class aemm
  extends bhry
{
  public aemm(VisitorsActivity paramVisitorsActivity) {}
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    if ((paramAnimation == this.a.b) && (this.a.d)) {
      this.a.centerView.setText("");
    }
    this.a.centerView.clearAnimation();
  }
  
  public void onAnimationStart(Animation paramAnimation)
  {
    if (paramAnimation == this.a.a) {
      this.a.centerView.setText(2131694709);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aemm
 * JD-Core Version:    0.7.0.1
 */