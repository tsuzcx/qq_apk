import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageForQQWalletMsg;
import com.tencent.mobileqq.data.QQWalletRedPacketMsg;
import com.tencent.mobileqq.data.QQWalletTransferMsgElem;

public class aeky
  extends aekr
{
  agvx a;
  
  public aeky(QQAppInterface paramQQAppInterface, aelj paramaelj, QQWalletTransferMsgElem paramQQWalletTransferMsgElem, int paramInt, acvf paramacvf)
  {
    super(paramQQAppInterface, paramaelj, paramQQWalletTransferMsgElem, paramInt, paramacvf);
    this.jdField_a_of_type_Agvx = ((agvx)paramQQAppInterface.getManager(125));
    if (a(this.jdField_a_of_type_Agvx.a(this.jdField_a_of_type_ComTencentMobileqqDataMessageForQQWalletMsg.mQQWalletRedPacketMsg.redPacketId))) {}
    for (this.i = 0;; this.i = paramQQWalletTransferMsgElem.effectsId)
    {
      this.j = 2130846325;
      return;
    }
  }
  
  public boolean b()
  {
    boolean bool = super.b();
    if (bool) {
      return bool;
    }
    this.jdField_a_of_type_Aelj.b.setVisibility(0);
    this.jdField_a_of_type_Aelj.b.setTextColor(-8947849);
    this.jdField_a_of_type_Aelj.b.setText("QQ文字口令红包");
    return false;
  }
  
  public void i()
  {
    QQWalletRedPacketMsg localQQWalletRedPacketMsg = this.jdField_a_of_type_ComTencentMobileqqDataMessageForQQWalletMsg.mQQWalletRedPacketMsg;
    agvw localagvw2 = this.jdField_a_of_type_Agvx.a(localQQWalletRedPacketMsg.redPacketId);
    agvw localagvw1 = localagvw2;
    if (localagvw2 == null)
    {
      localagvw1 = new agvw(localQQWalletRedPacketMsg.redPacketId, localQQWalletRedPacketMsg.redPacketIndex, this.jdField_a_of_type_ComTencentMobileqqDataMessageForQQWalletMsg.senderuin, this.jdField_a_of_type_ComTencentMobileqqDataMessageForQQWalletMsg.time + 90000L, this.jdField_a_of_type_ComTencentMobileqqDataQQWalletTransferMsgElem.title, false, false, false, 0);
      this.jdField_a_of_type_Agvx.a(localQQWalletRedPacketMsg.redPacketId, localQQWalletRedPacketMsg.redPacketIndex, this.jdField_a_of_type_ComTencentMobileqqDataQQWalletTransferMsgElem.title, this.jdField_a_of_type_ComTencentMobileqqDataMessageForQQWalletMsg.senderuin, this.jdField_a_of_type_ComTencentMobileqqDataMessageForQQWalletMsg.time + 90000L, String.valueOf(this.jdField_a_of_type_Agvx.a(this.jdField_a_of_type_ComTencentMobileqqDataMessageForQQWalletMsg.istroop)), this.jdField_a_of_type_ComTencentMobileqqDataMessageForQQWalletMsg.frienduin, localQQWalletRedPacketMsg.authkey, false, false, 0);
    }
    if (!a(localagvw1))
    {
      this.jdField_a_of_type_Aelj.d.setVisibility(8);
      return;
    }
    this.jdField_a_of_type_Aelj.d.setVisibility(0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     aeky
 * JD-Core Version:    0.7.0.1
 */