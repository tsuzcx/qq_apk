import android.widget.PopupWindow.OnDismissListener;
import com.tencent.mobileqq.ar.config.MainDownAni;
import com.tencent.mobileqq.ar.config.WorldCupStaticInstance;
import com.tencent.qphone.base.util.QLog;

public class aapp
  implements PopupWindow.OnDismissListener
{
  public aapp(MainDownAni paramMainDownAni, aapz paramaapz) {}
  
  public void onDismiss()
  {
    QLog.w(MainDownAni.a(this.jdField_a_of_type_ComTencentMobileqqArConfigMainDownAni), 1, "modifyMenu, onDismiss");
    WorldCupStaticInstance.a().a = false;
    this.jdField_a_of_type_ComTencentMobileqqArConfigMainDownAni.a(this.jdField_a_of_type_Aapz.d);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aapp
 * JD-Core Version:    0.7.0.1
 */