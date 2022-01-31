import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageForQQWalletMsg;
import com.tencent.mobileqq.data.QQWalletRedPacketMsg;
import com.tencent.mobileqq.data.QQWalletTransferMsgElem;

public class aeku
  extends aekt
{
  agvz a;
  
  public aeku(QQAppInterface paramQQAppInterface, aell paramaell, QQWalletTransferMsgElem paramQQWalletTransferMsgElem, int paramInt, acvj paramacvj)
  {
    super(paramQQAppInterface, paramaell, paramQQWalletTransferMsgElem, paramInt, paramacvj);
    this.jdField_a_of_type_Agvz = ((agvz)paramQQAppInterface.getManager(125));
    if (a(this.jdField_a_of_type_Agvz.a(this.jdField_a_of_type_ComTencentMobileqqDataMessageForQQWalletMsg.mQQWalletRedPacketMsg.redPacketId))) {}
    for (this.i = 0;; this.i = paramQQWalletTransferMsgElem.effectsId)
    {
      this.j = 2130846312;
      return;
    }
  }
  
  public boolean b()
  {
    boolean bool = super.b();
    if (bool) {
      return bool;
    }
    this.jdField_a_of_type_Aell.b.setVisibility(0);
    this.jdField_a_of_type_Aell.b.setTextColor(-8947849);
    this.jdField_a_of_type_Aell.b.setText(aeky.c);
    return true;
  }
  
  public void f()
  {
    super.f();
    try
    {
      this.jdField_a_of_type_Aell.a.setText(ahiy.a(this.jdField_a_of_type_Aell.a.getContext(), this.jdField_a_of_type_ComTencentMobileqqDataQQWalletTransferMsgElem.title, 330, this.jdField_a_of_type_Aell.a.getPaint()));
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
    agvy localagvy2 = this.jdField_a_of_type_Agvz.a(localQQWalletRedPacketMsg.redPacketId);
    agvy localagvy1 = localagvy2;
    if (localagvy2 == null)
    {
      localagvy1 = new agvy(localQQWalletRedPacketMsg.redPacketId, localQQWalletRedPacketMsg.redPacketIndex, this.jdField_a_of_type_ComTencentMobileqqDataMessageForQQWalletMsg.senderuin, this.jdField_a_of_type_ComTencentMobileqqDataMessageForQQWalletMsg.time + 90000L, this.jdField_a_of_type_ComTencentMobileqqDataQQWalletTransferMsgElem.title, false, false, false, 5);
      this.jdField_a_of_type_Agvz.a(localQQWalletRedPacketMsg.redPacketId, localQQWalletRedPacketMsg.redPacketIndex, this.jdField_a_of_type_ComTencentMobileqqDataQQWalletTransferMsgElem.title, this.jdField_a_of_type_ComTencentMobileqqDataMessageForQQWalletMsg.senderuin, this.jdField_a_of_type_ComTencentMobileqqDataMessageForQQWalletMsg.time + 90000L, String.valueOf(this.jdField_a_of_type_Agvz.a(this.jdField_a_of_type_ComTencentMobileqqDataMessageForQQWalletMsg.istroop)), this.jdField_a_of_type_ComTencentMobileqqDataMessageForQQWalletMsg.frienduin, localQQWalletRedPacketMsg.authkey, false, false, 5);
    }
    if (!a(localagvy1))
    {
      this.jdField_a_of_type_Aell.d.setVisibility(8);
      return;
    }
    this.jdField_a_of_type_Aell.d.setVisibility(0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     aeku
 * JD-Core Version:    0.7.0.1
 */