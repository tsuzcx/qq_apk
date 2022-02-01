import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.data.MessageForQQWalletMsg;
import com.tencent.mobileqq.data.QQWalletBaseMsgElem;
import com.tencent.mobileqq.data.QQWalletRedPacketMsg;

public class ahxz
  extends ahwx
{
  akqe a;
  
  public ahxz(QQAppInterface paramQQAppInterface, ahxr paramahxr, QQWalletBaseMsgElem paramQQWalletBaseMsgElem, int paramInt, afrr paramafrr)
  {
    super(paramQQAppInterface, paramahxr, paramQQWalletBaseMsgElem, paramInt, paramafrr);
    this.jdField_a_of_type_Akqe = ((akqe)paramQQAppInterface.getManager(QQManagerFactory.PASSWD_RED_BAG_MANAGER));
    if (a(this.jdField_a_of_type_Akqe.a(this.jdField_a_of_type_ComTencentMobileqqDataMessageForQQWalletMsg.mQQWalletRedPacketMsg.redPacketId))) {}
    for (this.i = 0;; this.i = paramQQWalletBaseMsgElem.effectsId)
    {
      this.j = 2130847252;
      return;
    }
  }
  
  public boolean b()
  {
    boolean bool = super.b();
    if (bool) {
      return bool;
    }
    this.jdField_a_of_type_Ahxr.b.setVisibility(0);
    this.jdField_a_of_type_Ahxr.b.setTextColor(-8947849);
    this.jdField_a_of_type_Ahxr.b.setText(ahxc.e);
    return true;
  }
  
  public void i()
  {
    QQWalletRedPacketMsg localQQWalletRedPacketMsg = this.jdField_a_of_type_ComTencentMobileqqDataMessageForQQWalletMsg.mQQWalletRedPacketMsg;
    akqd localakqd2 = this.jdField_a_of_type_Akqe.a(localQQWalletRedPacketMsg.redPacketId);
    akqd localakqd1 = localakqd2;
    if (localakqd2 == null)
    {
      localakqd1 = new akqd(localQQWalletRedPacketMsg.redPacketId, localQQWalletRedPacketMsg.redPacketIndex, this.jdField_a_of_type_ComTencentMobileqqDataMessageForQQWalletMsg.senderuin, this.jdField_a_of_type_ComTencentMobileqqDataMessageForQQWalletMsg.time + 90000L, this.jdField_a_of_type_ComTencentMobileqqDataQQWalletBaseMsgElem.title, false, false, false, 1);
      this.jdField_a_of_type_Akqe.a(localQQWalletRedPacketMsg.redPacketId, localQQWalletRedPacketMsg.redPacketIndex, this.jdField_a_of_type_ComTencentMobileqqDataQQWalletBaseMsgElem.title, this.jdField_a_of_type_ComTencentMobileqqDataMessageForQQWalletMsg.senderuin, this.jdField_a_of_type_ComTencentMobileqqDataMessageForQQWalletMsg.time + 90000L, String.valueOf(this.jdField_a_of_type_Akqe.a(this.jdField_a_of_type_ComTencentMobileqqDataMessageForQQWalletMsg.istroop)), this.jdField_a_of_type_ComTencentMobileqqDataMessageForQQWalletMsg.frienduin, localQQWalletRedPacketMsg.authkey, false, false, 1);
    }
    if (!a(localakqd1))
    {
      this.jdField_a_of_type_Ahxr.d.setVisibility(8);
      return;
    }
    this.jdField_a_of_type_Ahxr.d.setVisibility(0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ahxz
 * JD-Core Version:    0.7.0.1
 */