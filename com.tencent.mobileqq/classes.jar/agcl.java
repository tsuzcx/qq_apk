import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import com.tencent.mobileqq.activity.aio.panel.PEPanel;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.ListView;

public class agcl
  implements Animator.AnimatorListener, ValueAnimator.AnimatorUpdateListener
{
  public agcl(PEPanel paramPEPanel) {}
  
  public void onAnimationCancel(Animator paramAnimator) {}
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    if ((PEPanel.a(this.a) != null) && (QLog.isColorLevel())) {
      QLog.d("PokeEmo.PEPanel", 2, String.format(" playLottieAnim onAnimationEnd listView.visibility = %d ", new Object[] { Integer.valueOf(PEPanel.a(this.a).getVisibility()) }));
    }
    if ((PEPanel.a(this.a) != null) && (PEPanel.a(this.a).getVisibility() != 0)) {
      PEPanel.a(this.a).setVisibility(0);
    }
  }
  
  public void onAnimationRepeat(Animator paramAnimator) {}
  
  public void onAnimationStart(Animator paramAnimator)
  {
    this.a.setListViewVisibile(8);
  }
  
  public void onAnimationUpdate(ValueAnimator paramValueAnimator) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     agcl
 * JD-Core Version:    0.7.0.1
 */