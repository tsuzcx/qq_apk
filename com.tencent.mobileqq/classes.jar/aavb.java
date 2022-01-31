import android.view.View;
import com.tencent.mobileqq.armap.ARMapShuaMsgView;
import com.tencent.mobileqq.armap.ConversationPullDownActiveBase;
import com.tencent.mobileqq.portal.StrokeTextView;
import com.tencent.qphone.base.util.QLog;

public class aavb
  implements Runnable
{
  public aavb(ARMapShuaMsgView paramARMapShuaMsgView) {}
  
  public void run()
  {
    boolean bool2 = true;
    StringBuilder localStringBuilder;
    if ((QLog.isColorLevel()) && (this.a.jdField_a_of_type_ComTencentMobileqqPortalStrokeTextView != null) && (this.a.jdField_a_of_type_AndroidViewView != null))
    {
      localStringBuilder = new StringBuilder().append("SpringBackRunnable, pullType=").append(this.a.jdField_a_of_type_Int).append("  refreshProgressRoot.visible:");
      if (this.a.jdField_a_of_type_AndroidViewView.getVisibility() != 0) {
        break label135;
      }
      bool1 = true;
      localStringBuilder = localStringBuilder.append(bool1).append("  refreshMsgText.visible:");
      if (this.a.jdField_a_of_type_ComTencentMobileqqPortalStrokeTextView.getVisibility() != 0) {
        break label140;
      }
    }
    label135:
    label140:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      QLog.d("ARMapShuaMsgView", 2, bool1);
      if ((this.a.jdField_a_of_type_Int != 0) && (this.a.jdField_a_of_type_AndroidViewView.getVisibility() == 0)) {
        break label145;
      }
      return;
      bool1 = false;
      break;
    }
    label145:
    this.a.jdField_a_of_type_AndroidViewView.setVisibility(4);
    this.a.jdField_a_of_type_ComTencentMobileqqArmapConversationPullDownActiveBase.c(0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aavb
 * JD-Core Version:    0.7.0.1
 */