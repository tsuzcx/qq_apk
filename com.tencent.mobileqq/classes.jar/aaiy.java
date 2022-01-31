import android.widget.PopupWindow.OnDismissListener;
import com.tencent.mobileqq.ar.config.MainDownAni;
import com.tencent.mobileqq.ar.config.WorldCupStaticInstance;
import com.tencent.qphone.base.util.QLog;

public class aaiy
  implements PopupWindow.OnDismissListener
{
  public aaiy(MainDownAni paramMainDownAni, aaji paramaaji) {}
  
  public void onDismiss()
  {
    QLog.w(MainDownAni.a(), 1, "modifyMenu, onDismiss");
    WorldCupStaticInstance.a().a = false;
    this.jdField_a_of_type_ComTencentMobileqqArConfigMainDownAni.a(this.jdField_a_of_type_Aaji.d);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aaiy
 * JD-Core Version:    0.7.0.1
 */