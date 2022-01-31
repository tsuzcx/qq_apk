import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.data.MessageForDeliverGiftTips;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.EntityManagerFactory;
import com.tencent.mobileqq.troop.utils.AIOAnimationControlManager;
import com.tencent.mobileqq.troop.utils.TroopGiftCallback;
import com.tencent.mobileqq.troopgift.TroopInteractGiftAnimationController;
import com.tencent.qphone.base.util.QLog;
import java.util.Collections;
import java.util.List;
import tencent.im.oidb.cmd0x962.oidb_0x962.FinishInfo;
import tencent.im.oidb.cmd0x962.oidb_0x962.RspBody;

public class aiyz
  extends TroopGiftCallback
{
  public aiyz(AIOAnimationControlManager paramAIOAnimationControlManager, MessageForDeliverGiftTips paramMessageForDeliverGiftTips, List paramList1, boolean paramBoolean, List paramList2, String paramString) {}
  
  public void a(int paramInt, oidb_0x962.RspBody paramRspBody)
  {
    if (paramInt == 0)
    {
      this.jdField_a_of_type_ComTencentMobileqqDataMessageForDeliverGiftTips.interactState = paramRspBody.uint32_play_state.get();
      if (QLog.isColorLevel()) {
        QLog.d("AIOAnimationControlManager", 2, "checkInteract interactId: " + this.jdField_a_of_type_ComTencentMobileqqDataMessageForDeliverGiftTips.interactId + ", interactState: " + this.jdField_a_of_type_ComTencentMobileqqDataMessageForDeliverGiftTips.interactState);
      }
      this.jdField_a_of_type_ComTencentMobileqqDataMessageForDeliverGiftTips.alreadyPlayMicroseconds = paramRspBody.uint64_already_pay_microseconds.get();
      this.jdField_a_of_type_ComTencentMobileqqDataMessageForDeliverGiftTips.playTotalMicroseconds = paramRspBody.uint64_play_total_microseconds.get();
      if ((this.jdField_a_of_type_ComTencentMobileqqDataMessageForDeliverGiftTips.interactState == 2) && (paramRspBody.msg_finish_info.has()))
      {
        paramRspBody = (oidb_0x962.FinishInfo)paramRspBody.msg_finish_info.get();
        this.jdField_a_of_type_ComTencentMobileqqDataMessageForDeliverGiftTips.interactText = paramRspBody.bytes_text.get().toStringUtf8();
        this.jdField_a_of_type_ComTencentMobileqqDataMessageForDeliverGiftTips.participateNum = paramRspBody.uint32_participate_num.get();
        this.jdField_a_of_type_ComTencentMobileqqDataMessageForDeliverGiftTips.interactFirstUin = paramRspBody.uint64_first_uin.get();
        this.jdField_a_of_type_ComTencentMobileqqDataMessageForDeliverGiftTips.interactFirstNickname = paramRspBody.bytes_first_nick_name.get().toStringUtf8();
        this.jdField_a_of_type_ComTencentMobileqqDataMessageForDeliverGiftTips.interacEndtUrl = paramRspBody.bytes_url.get().toStringUtf8();
        this.jdField_a_of_type_JavaUtilList.remove(this.jdField_a_of_type_ComTencentMobileqqDataMessageForDeliverGiftTips);
        if (this.jdField_a_of_type_Boolean)
        {
          this.jdField_a_of_type_ComTencentMobileqqTroopUtilsAIOAnimationControlManager.a(this.jdField_a_of_type_ComTencentMobileqqDataMessageForDeliverGiftTips, false);
          if ((this.jdField_a_of_type_JavaUtilList.isEmpty()) && (this.b != null)) {
            Collections.sort(this.b, this.jdField_a_of_type_ComTencentMobileqqTroopUtilsAIOAnimationControlManager.jdField_a_of_type_JavaUtilComparator);
          }
        }
        this.jdField_a_of_type_ComTencentMobileqqTroopUtilsAIOAnimationControlManager.jdField_a_of_type_Int = 1;
        this.jdField_a_of_type_ComTencentMobileqqTroopUtilsAIOAnimationControlManager.a(this.jdField_a_of_type_Boolean);
      }
      for (;;)
      {
        this.jdField_a_of_type_ComTencentMobileqqTroopUtilsAIOAnimationControlManager.jdField_a_of_type_ComTencentCommonAppAppInterface.getEntityManagerFactory().createEntityManager().a(this.jdField_a_of_type_ComTencentMobileqqDataMessageForDeliverGiftTips);
        return;
        this.jdField_a_of_type_ComTencentMobileqqTroopUtilsAIOAnimationControlManager.h();
        this.jdField_a_of_type_ComTencentMobileqqTroopUtilsAIOAnimationControlManager.jdField_a_of_type_Int = 2;
        if ((this.jdField_a_of_type_Boolean) && (this.b != null)) {
          this.b.clear();
        }
        if (this.jdField_a_of_type_ComTencentMobileqqTroopUtilsAIOAnimationControlManager.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie != null)
        {
          this.jdField_a_of_type_JavaUtilList.remove(this.jdField_a_of_type_ComTencentMobileqqDataMessageForDeliverGiftTips);
          this.jdField_a_of_type_ComTencentMobileqqTroopUtilsAIOAnimationControlManager.jdField_a_of_type_ComTencentMobileqqTroopgiftTroopInteractGiftAnimationController.a(this.jdField_a_of_type_ComTencentMobileqqDataMessageForDeliverGiftTips, this.jdField_a_of_type_JavaLangString, true, new aiza(this));
        }
      }
    }
    if (QLog.isColorLevel()) {
      QLog.e("AIOAnimationControlManager", 2, "checkInteract errorCode: " + paramInt);
    }
    this.jdField_a_of_type_JavaUtilList.remove(this.jdField_a_of_type_ComTencentMobileqqDataMessageForDeliverGiftTips);
    if (!this.jdField_a_of_type_Boolean)
    {
      this.jdField_a_of_type_ComTencentMobileqqTroopUtilsAIOAnimationControlManager.a(this.jdField_a_of_type_ComTencentMobileqqDataMessageForDeliverGiftTips, false);
      if (this.jdField_a_of_type_JavaUtilList.isEmpty()) {
        Collections.sort(this.b, this.jdField_a_of_type_ComTencentMobileqqTroopUtilsAIOAnimationControlManager.jdField_a_of_type_JavaUtilComparator);
      }
    }
    this.jdField_a_of_type_ComTencentMobileqqTroopUtilsAIOAnimationControlManager.jdField_a_of_type_Int = 1;
    this.jdField_a_of_type_ComTencentMobileqqTroopUtilsAIOAnimationControlManager.a(this.jdField_a_of_type_Boolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\aaa.jar
 * Qualified Name:     aiyz
 * JD-Core Version:    0.7.0.1
 */