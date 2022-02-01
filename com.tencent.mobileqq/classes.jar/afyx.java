import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.troop.TroopMemberInfo;
import com.tencent.mobileqq.vas.avatar.VasAvatar;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;

class afyx
  implements aofo
{
  private afyw jdField_a_of_type_Afyw;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private ChatMessage jdField_a_of_type_ComTencentMobileqqDataChatMessage;
  private VasAvatar jdField_a_of_type_ComTencentMobileqqVasAvatarVasAvatar;
  
  afyx(VasAvatar paramVasAvatar, ChatMessage paramChatMessage, QQAppInterface paramQQAppInterface, afyw paramafyw)
  {
    this.jdField_a_of_type_ComTencentMobileqqVasAvatarVasAvatar = paramVasAvatar;
    this.jdField_a_of_type_ComTencentMobileqqDataChatMessage = paramChatMessage;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_Afyw = paramafyw;
  }
  
  public void a(TroopMemberInfo paramTroopMemberInfo)
  {
    if (paramTroopMemberInfo == null)
    {
      if (TextUtils.equals(this.jdField_a_of_type_ComTencentMobileqqDataChatMessage.senderuin, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin())) {}
      for (int i = 2131694495;; i = 2131694496)
      {
        QQToast.a(BaseApplicationImpl.getContext(), 0, i, 0).a();
        if (QLog.isColorLevel()) {
          QLog.d("AvatarOnGestureListener", 2, "onDoubleTap() isKicked");
        }
        return;
      }
    }
    afyw.a(this.jdField_a_of_type_Afyw, this.jdField_a_of_type_ComTencentMobileqqVasAvatarVasAvatar, this.jdField_a_of_type_ComTencentMobileqqDataChatMessage, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     afyx
 * JD-Core Version:    0.7.0.1
 */