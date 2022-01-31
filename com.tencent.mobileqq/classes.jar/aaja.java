import android.view.View;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import com.tencent.mobileqq.ar.config.MainDownAni;
import com.tencent.mobileqq.ar.config.WorldCupMgr;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.PopupMenuDialog;
import java.lang.ref.WeakReference;

public class aaja
  implements ViewTreeObserver.OnGlobalLayoutListener
{
  public aaja(MainDownAni paramMainDownAni, aaji paramaaji, WorldCupMgr paramWorldCupMgr) {}
  
  public void onGlobalLayout()
  {
    PopupMenuDialog localPopupMenuDialog = (PopupMenuDialog)this.jdField_a_of_type_Aaji.d.get();
    if (localPopupMenuDialog != null)
    {
      localPopupMenuDialog.getContentView().getViewTreeObserver().removeGlobalOnLayoutListener(this);
      this.jdField_a_of_type_ComTencentMobileqqArConfigMainDownAni.a = true;
      QLog.w(MainDownAni.a(), 1, "MainDownAni.onGlobalLayout, mTaskStatus[" + this.jdField_a_of_type_ComTencentMobileqqArConfigWorldCupMgr.a.g + "]");
      this.jdField_a_of_type_ComTencentMobileqqArConfigMainDownAni.a(this.jdField_a_of_type_Aaji);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aaja
 * JD-Core Version:    0.7.0.1
 */