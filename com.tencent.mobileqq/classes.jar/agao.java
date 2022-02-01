import android.view.animation.Animation;
import android.widget.ImageView;
import com.tencent.mobileqq.activity.VisitorsActivity;

public class agao
  extends blgm
{
  public agao(VisitorsActivity paramVisitorsActivity) {}
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    this.a.f = false;
  }
  
  public void onAnimationStart(Animation paramAnimation)
  {
    this.a.c.setVisibility(0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     agao
 * JD-Core Version:    0.7.0.1
 */