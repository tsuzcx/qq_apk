import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageForQQWalletMsg;
import com.tencent.mobileqq.data.QQWalletBaseMsgElem;
import com.tencent.mobileqq.data.QQWalletRedPacketMsg;

public class ahwj
  extends ahwb
{
  aklj a;
  
  public ahwj(QQAppInterface paramQQAppInterface, ahwv paramahwv, QQWalletBaseMsgElem paramQQWalletBaseMsgElem, int paramInt, afxp paramafxp)
  {
    super(paramQQAppInterface, paramahwv, paramQQWalletBaseMsgElem, paramInt, paramafxp);
    this.jdField_a_of_type_Aklj = ((aklj)paramQQAppInterface.getManager(125));
    if (a(this.jdField_a_of_type_Aklj.a(this.jdField_a_of_type_ComTencentMobileqqDataMessageForQQWalletMsg.mQQWalletRedPacketMsg.redPacketId))) {}
    for (this.i = 0;; this.i = paramQQWalletBaseMsgElem.effectsId)
    {
      this.j = 2130847227;
      return;
    }
  }
  
  public boolean b()
  {
    boolean bool = super.b();
    if (bool) {
      return bool;
    }
    this.jdField_a_of_type_Ahwv.b.setVisibility(0);
    this.jdField_a_of_type_Ahwv.b.setTextColor(-8947849);
    this.jdField_a_of_type_Ahwv.b.setText(ahwg.f);
    return false;
  }
  
  public void i()
  {
    QQWalletRedPacketMsg localQQWalletRedPacketMsg = this.jdField_a_of_type_ComTencentMobileqqDataMessageForQQWalletMsg.mQQWalletRedPacketMsg;
    akli localakli2 = this.jdField_a_of_type_Aklj.a(localQQWalletRedPacketMsg.redPacketId);
    akli localakli1 = localakli2;
    if (localakli2 == null)
    {
      localakli1 = new akli(localQQWalletRedPacketMsg.redPacketId, localQQWalletRedPacketMsg.redPacketIndex, this.jdField_a_of_type_ComTencentMobileqqDataMessageForQQWalletMsg.senderuin, this.jdField_a_of_type_ComTencentMobileqqDataMessageForQQWalletMsg.time + 90000L, this.jdField_a_of_type_ComTencentMobileqqDataQQWalletBaseMsgElem.title, false, false, false, 0);
      this.jdField_a_of_type_Aklj.a(localQQWalletRedPacketMsg.redPacketId, localQQWalletRedPacketMsg.redPacketIndex, this.jdField_a_of_type_ComTencentMobileqqDataQQWalletBaseMsgElem.title, this.jdField_a_of_type_ComTencentMobileqqDataMessageForQQWalletMsg.senderuin, this.jdField_a_of_type_ComTencentMobileqqDataMessageForQQWalletMsg.time + 90000L, String.valueOf(this.jdField_a_of_type_Aklj.a(this.jdField_a_of_type_ComTencentMobileqqDataMessageForQQWalletMsg.istroop)), this.jdField_a_of_type_ComTencentMobileqqDataMessageForQQWalletMsg.frienduin, localQQWalletRedPacketMsg.authkey, false, false, 0);
    }
    if (!a(localakli1))
    {
      this.jdField_a_of_type_Ahwv.d.setVisibility(8);
      return;
    }
    this.jdField_a_of_type_Ahwv.d.setVisibility(0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ahwj
 * JD-Core Version:    0.7.0.1
 */