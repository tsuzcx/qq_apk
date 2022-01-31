import android.animation.Animator;
import android.widget.ImageView;
import com.tencent.mobileqq.activity.richmedia.AnimatorAdapter;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.ar.config.MainDownAni;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import mqq.os.MqqHandler;

class aajg
  extends AnimatorAdapter
{
  aajg(aaje paramaaje) {}
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    QLog.w(MainDownAni.a(), 1, "loadDownAnimation动画结束");
    this.a.jdField_a_of_type_ComTencentMobileqqArConfigMainDownAni.a();
    this.a.jdField_a_of_type_ComTencentMobileqqArConfigMainDownAni.b(this.a.jdField_a_of_type_Aaji, this.a.jdField_a_of_type_Aajp);
  }
  
  public void onAnimationStart(Animator paramAnimator)
  {
    QLog.w(MainDownAni.a(), 1, "loadDownAnimation动画开始");
    paramAnimator = (ImageView)this.a.jdField_a_of_type_Aaji.c.get();
    if (paramAnimator != null)
    {
      paramAnimator.setVisibility(4);
      paramAnimator.setImageDrawable(null);
    }
    paramAnimator = (ImageView)this.a.jdField_a_of_type_Aaji.e.get();
    if (paramAnimator != null) {
      paramAnimator.setVisibility(0);
    }
    ThreadManager.getUIHandler().postDelayed(new aajh(this), 1700L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aajg
 * JD-Core Version:    0.7.0.1
 */