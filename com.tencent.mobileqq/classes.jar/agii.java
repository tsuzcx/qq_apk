import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageForQQWalletMsg;
import com.tencent.mobileqq.data.QQWalletRedPacketMsg;
import com.tencent.mobileqq.data.QQWalletTransferMsgElem;

public class agii
  extends aghi
{
  aipw a;
  
  public agii(QQAppInterface paramQQAppInterface, agia paramagia, QQWalletTransferMsgElem paramQQWalletTransferMsgElem, int paramInt, aemp paramaemp)
  {
    super(paramQQAppInterface, paramagia, paramQQWalletTransferMsgElem, paramInt, paramaemp);
    this.jdField_a_of_type_Aipw = ((aipw)paramQQAppInterface.getManager(125));
    if (a(this.jdField_a_of_type_Aipw.a(this.jdField_a_of_type_ComTencentMobileqqDataMessageForQQWalletMsg.mQQWalletRedPacketMsg.redPacketId))) {}
    for (this.i = 0;; this.i = paramQQWalletTransferMsgElem.effectsId)
    {
      this.j = 2130846706;
      return;
    }
  }
  
  public boolean b()
  {
    boolean bool = super.b();
    if (bool) {
      return bool;
    }
    this.jdField_a_of_type_Agia.b.setVisibility(0);
    this.jdField_a_of_type_Agia.b.setTextColor(-8947849);
    this.jdField_a_of_type_Agia.b.setText("QQ语音口令红包");
    return true;
  }
  
  public void i()
  {
    QQWalletRedPacketMsg localQQWalletRedPacketMsg = this.jdField_a_of_type_ComTencentMobileqqDataMessageForQQWalletMsg.mQQWalletRedPacketMsg;
    aipv localaipv2 = this.jdField_a_of_type_Aipw.a(localQQWalletRedPacketMsg.redPacketId);
    aipv localaipv1 = localaipv2;
    if (localaipv2 == null)
    {
      localaipv1 = new aipv(localQQWalletRedPacketMsg.redPacketId, localQQWalletRedPacketMsg.redPacketIndex, this.jdField_a_of_type_ComTencentMobileqqDataMessageForQQWalletMsg.senderuin, this.jdField_a_of_type_ComTencentMobileqqDataMessageForQQWalletMsg.time + 90000L, this.jdField_a_of_type_ComTencentMobileqqDataQQWalletTransferMsgElem.title, false, false, false, 1);
      this.jdField_a_of_type_Aipw.a(localQQWalletRedPacketMsg.redPacketId, localQQWalletRedPacketMsg.redPacketIndex, this.jdField_a_of_type_ComTencentMobileqqDataQQWalletTransferMsgElem.title, this.jdField_a_of_type_ComTencentMobileqqDataMessageForQQWalletMsg.senderuin, this.jdField_a_of_type_ComTencentMobileqqDataMessageForQQWalletMsg.time + 90000L, String.valueOf(this.jdField_a_of_type_Aipw.a(this.jdField_a_of_type_ComTencentMobileqqDataMessageForQQWalletMsg.istroop)), this.jdField_a_of_type_ComTencentMobileqqDataMessageForQQWalletMsg.frienduin, localQQWalletRedPacketMsg.authkey, false, false, 1);
    }
    if (!a(localaipv1))
    {
      this.jdField_a_of_type_Agia.d.setVisibility(8);
      return;
    }
    this.jdField_a_of_type_Agia.d.setVisibility(0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     agii
 * JD-Core Version:    0.7.0.1
 */