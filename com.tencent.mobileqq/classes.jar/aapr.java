import android.view.View;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import com.tencent.mobileqq.ar.config.MainDownAni;
import com.tencent.mobileqq.ar.config.WorldCupMgr;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.PopupMenuDialog;
import java.lang.ref.WeakReference;

public class aapr
  implements ViewTreeObserver.OnGlobalLayoutListener
{
  public aapr(MainDownAni paramMainDownAni, aapz paramaapz, WorldCupMgr paramWorldCupMgr) {}
  
  public void onGlobalLayout()
  {
    PopupMenuDialog localPopupMenuDialog = (PopupMenuDialog)this.jdField_a_of_type_Aapz.d.get();
    if (localPopupMenuDialog != null)
    {
      localPopupMenuDialog.getContentView().getViewTreeObserver().removeGlobalOnLayoutListener(this);
      this.jdField_a_of_type_ComTencentMobileqqArConfigMainDownAni.a = true;
      QLog.w(MainDownAni.a(this.jdField_a_of_type_ComTencentMobileqqArConfigMainDownAni), 1, "MainDownAni.onGlobalLayout, mTaskStatus[" + this.jdField_a_of_type_ComTencentMobileqqArConfigWorldCupMgr.a.g + "]");
      this.jdField_a_of_type_ComTencentMobileqqArConfigMainDownAni.a(this.jdField_a_of_type_Aapz);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aapr
 * JD-Core Version:    0.7.0.1
 */