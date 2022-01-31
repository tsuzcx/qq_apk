import android.os.Handler;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageForDeliverGiftTips;
import com.tencent.mobileqq.troop.data.TroopGiftBagInfo;
import com.tencent.mobileqq.troop.utils.AIOAnimationControlManager;
import com.tencent.mobileqq.troop.utils.TroopGiftCallback;
import com.tencent.mobileqq.utils.ContactUtils;
import com.tencent.qphone.base.util.QLog;

public class ajus
  extends TroopGiftCallback
{
  public ajus(AIOAnimationControlManager paramAIOAnimationControlManager, MessageForDeliverGiftTips paramMessageForDeliverGiftTips, String paramString, boolean paramBoolean) {}
  
  public void a(int paramInt, String paramString)
  {
    this.jdField_a_of_type_ComTencentMobileqqDataMessageForDeliverGiftTips.hasFetchButFailed = true;
    this.jdField_a_of_type_ComTencentMobileqqDataMessageForDeliverGiftTips.showButton = true;
    if ((this.jdField_a_of_type_ComTencentMobileqqTroopUtilsAIOAnimationControlManager.jdField_a_of_type_ComTencentCommonAppAppInterface instanceof QQAppInterface)) {}
    for (this.jdField_a_of_type_ComTencentMobileqqDataMessageForDeliverGiftTips.senderName = ContactUtils.g((QQAppInterface)this.jdField_a_of_type_ComTencentMobileqqTroopUtilsAIOAnimationControlManager.jdField_a_of_type_ComTencentCommonAppAppInterface, this.jdField_a_of_type_JavaLangString, "" + this.jdField_a_of_type_ComTencentMobileqqDataMessageForDeliverGiftTips.senderUin);; this.jdField_a_of_type_ComTencentMobileqqDataMessageForDeliverGiftTips.senderName = this.jdField_a_of_type_ComTencentMobileqqTroopUtilsAIOAnimationControlManager.jdField_a_of_type_ComTencentCommonAppAppInterface.getDisplayName(1, this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqDataMessageForDeliverGiftTips.senderUin + ""))
    {
      if (QLog.isColorLevel()) {
        QLog.i(".troop.send_gift", 2, "playGiftBigAnimation getGrabBagInfo onError. errorCode:" + paramInt + " errorMsg:" + paramString);
      }
      this.jdField_a_of_type_ComTencentMobileqqTroopUtilsAIOAnimationControlManager.jdField_a_of_type_AndroidOsHandler.post(new ajuu(this));
      return;
    }
  }
  
  public void a(TroopGiftBagInfo paramTroopGiftBagInfo)
  {
    if (paramTroopGiftBagInfo.myGrabResult == null)
    {
      this.jdField_a_of_type_ComTencentMobileqqDataMessageForDeliverGiftTips.hasFetchButFailed = true;
      this.jdField_a_of_type_ComTencentMobileqqDataMessageForDeliverGiftTips.showButton = true;
      if (!(this.jdField_a_of_type_ComTencentMobileqqTroopUtilsAIOAnimationControlManager.jdField_a_of_type_ComTencentCommonAppAppInterface instanceof QQAppInterface)) {
        break label105;
      }
    }
    label105:
    for (this.jdField_a_of_type_ComTencentMobileqqDataMessageForDeliverGiftTips.senderName = ContactUtils.g((QQAppInterface)this.jdField_a_of_type_ComTencentMobileqqTroopUtilsAIOAnimationControlManager.jdField_a_of_type_ComTencentCommonAppAppInterface, this.jdField_a_of_type_JavaLangString, "" + this.jdField_a_of_type_ComTencentMobileqqDataMessageForDeliverGiftTips.senderUin);; this.jdField_a_of_type_ComTencentMobileqqDataMessageForDeliverGiftTips.senderName = this.jdField_a_of_type_ComTencentMobileqqTroopUtilsAIOAnimationControlManager.jdField_a_of_type_ComTencentCommonAppAppInterface.getDisplayName(1, this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqDataMessageForDeliverGiftTips.senderUin + ""))
    {
      this.jdField_a_of_type_ComTencentMobileqqTroopUtilsAIOAnimationControlManager.jdField_a_of_type_AndroidOsHandler.post(new ajut(this));
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ajus
 * JD-Core Version:    0.7.0.1
 */