import android.animation.Animator;
import android.widget.ImageView;
import com.tencent.mobileqq.activity.richmedia.AnimatorAdapter;
import com.tencent.mobileqq.ar.config.MainEntryAni;
import com.tencent.mobileqq.ar.config.WorldCupConfigInfo;
import com.tencent.mobileqq.ar.config.WorldCupReport;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;

class aaqe
  extends AnimatorAdapter
{
  aaqe(aaqc paramaaqc) {}
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    QLog.w("WorldCupMgr", 1, "loadRollAnimation动画结束");
    this.a.jdField_a_of_type_ComTencentMobileqqArConfigMainEntryAni.a(this.a.jdField_a_of_type_Aaqf, this.a.jdField_a_of_type_Aaqg);
    MainEntryAni.a(this.a.jdField_a_of_type_ComTencentMobileqqArConfigMainEntryAni, this.a.jdField_a_of_type_Aaqf);
  }
  
  public void onAnimationStart(Animator paramAnimator)
  {
    QLog.w("WorldCupMgr", 1, "loadRollAnimation动画开始");
    WorldCupConfigInfo.a(this.a.jdField_a_of_type_Aaqf.a.l, WorldCupConfigInfo.a());
    WorldCupReport.a();
    paramAnimator = (ImageView)this.a.jdField_a_of_type_Aaqf.e.get();
    if (paramAnimator != null) {
      paramAnimator.setVisibility(4);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aaqe
 * JD-Core Version:    0.7.0.1
 */