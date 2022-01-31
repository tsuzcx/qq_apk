import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageForQQWalletMsg;
import com.tencent.mobileqq.data.QQWalletRedPacketMsg;
import com.tencent.mobileqq.data.QQWalletTransferMsgElem;

public class aglz
  extends aglx
{
  aiul a;
  
  public aglz(QQAppInterface paramQQAppInterface, agmp paramagmp, QQWalletTransferMsgElem paramQQWalletTransferMsgElem, int paramInt, aere paramaere)
  {
    super(paramQQAppInterface, paramagmp, paramQQWalletTransferMsgElem, paramInt, paramaere);
    this.jdField_a_of_type_Aiul = ((aiul)paramQQAppInterface.getManager(125));
    if (a(this.jdField_a_of_type_Aiul.a(this.jdField_a_of_type_ComTencentMobileqqDataMessageForQQWalletMsg.mQQWalletRedPacketMsg.redPacketId))) {}
    for (this.i = 0;; this.i = paramQQWalletTransferMsgElem.effectsId)
    {
      this.j = 2130846772;
      return;
    }
  }
  
  public boolean b()
  {
    boolean bool = super.b();
    if (bool) {
      return bool;
    }
    this.jdField_a_of_type_Agmp.b.setVisibility(0);
    this.jdField_a_of_type_Agmp.b.setTextColor(-8947849);
    this.jdField_a_of_type_Agmp.b.setText(agmc.a);
    return true;
  }
  
  public void f()
  {
    super.f();
    try
    {
      this.jdField_a_of_type_Agmp.a.setText(ajeu.a(this.jdField_a_of_type_Agmp.a.getContext(), this.jdField_a_of_type_ComTencentMobileqqDataQQWalletTransferMsgElem.title, 330, this.jdField_a_of_type_Agmp.a.getPaint()));
      return;
    }
    catch (Throwable localThrowable)
    {
      localThrowable.printStackTrace();
    }
  }
  
  public void i()
  {
    QQWalletRedPacketMsg localQQWalletRedPacketMsg = this.jdField_a_of_type_ComTencentMobileqqDataMessageForQQWalletMsg.mQQWalletRedPacketMsg;
    aiuk localaiuk2 = this.jdField_a_of_type_Aiul.a(localQQWalletRedPacketMsg.redPacketId);
    aiuk localaiuk1 = localaiuk2;
    if (localaiuk2 == null)
    {
      localaiuk1 = new aiuk(localQQWalletRedPacketMsg.redPacketId, localQQWalletRedPacketMsg.redPacketIndex, this.jdField_a_of_type_ComTencentMobileqqDataMessageForQQWalletMsg.senderuin, this.jdField_a_of_type_ComTencentMobileqqDataMessageForQQWalletMsg.time + 90000L, this.jdField_a_of_type_ComTencentMobileqqDataQQWalletTransferMsgElem.title, false, false, false, 2);
      this.jdField_a_of_type_Aiul.a(localQQWalletRedPacketMsg.redPacketId, localQQWalletRedPacketMsg.redPacketIndex, this.jdField_a_of_type_ComTencentMobileqqDataQQWalletTransferMsgElem.title, this.jdField_a_of_type_ComTencentMobileqqDataMessageForQQWalletMsg.senderuin, this.jdField_a_of_type_ComTencentMobileqqDataMessageForQQWalletMsg.time + 90000L, String.valueOf(this.jdField_a_of_type_Aiul.a(this.jdField_a_of_type_ComTencentMobileqqDataMessageForQQWalletMsg.istroop)), this.jdField_a_of_type_ComTencentMobileqqDataMessageForQQWalletMsg.frienduin, localQQWalletRedPacketMsg.authkey, false, false, 2);
    }
    if (!super.a(localaiuk1))
    {
      this.jdField_a_of_type_Agmp.d.setVisibility(8);
      return;
    }
    this.jdField_a_of_type_Agmp.d.setVisibility(0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aglz
 * JD-Core Version:    0.7.0.1
 */