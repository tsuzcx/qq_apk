import android.animation.Animator;
import com.tencent.mobileqq.activity.richmedia.AnimatorAdapter;
import com.tencent.qphone.base.util.QLog;

class aaqm
  extends AnimatorAdapter
{
  aaqm(aaqk paramaaqk) {}
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    QLog.w("WorldCupMgr", 1, "loadMovingAnimation动画结束");
  }
  
  public void onAnimationStart(Animator paramAnimator)
  {
    QLog.w("WorldCupMgr", 1, "loadMovingAnimation动画开始");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aaqm
 * JD-Core Version:    0.7.0.1
 */