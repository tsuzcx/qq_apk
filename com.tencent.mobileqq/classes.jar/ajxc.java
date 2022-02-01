import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.activity.home.Conversation;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.upgrade.UpgradeTIMManager;
import com.tencent.mobileqq.upgrade.UpgradeTIMWrapper;

public class ajxc
  implements DialogInterface.OnClickListener
{
  public ajxc(Conversation paramConversation, UpgradeTIMWrapper paramUpgradeTIMWrapper) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    Conversation.a(this.jdField_a_of_type_ComTencentMobileqqActivityHomeConversation, null);
    ((UpgradeTIMManager)this.jdField_a_of_type_ComTencentMobileqqActivityHomeConversation.a.getManager(QQManagerFactory.TIM_UPGRADE_DOWNLOAD_MANAGER)).a(this.jdField_a_of_type_ComTencentMobileqqActivityHomeConversation.a(), this.jdField_a_of_type_ComTencentMobileqqUpgradeUpgradeTIMWrapper.c);
    bdla.b(this.jdField_a_of_type_ComTencentMobileqqActivityHomeConversation.a, "CliOper", "", "", "0X800815D", "0X800815D", 0, 0, "", "", "", "");
    bdla.b(this.jdField_a_of_type_ComTencentMobileqqActivityHomeConversation.a, "CliOper", "", "", "0X8008657", "0X8008657", 0, 0, "", "", "", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ajxc
 * JD-Core Version:    0.7.0.1
 */