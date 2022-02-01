import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageForQQWalletMsg;
import com.tencent.mobileqq.data.QQWalletBaseMsgElem;
import com.tencent.mobileqq.data.QQWalletRedPacketMsg;

public class aifq
  extends aifp
{
  akwu a;
  
  public aifq(QQAppInterface paramQQAppInterface, aigj paramaigj, QQWalletBaseMsgElem paramQQWalletBaseMsgElem, int paramInt, aghj paramaghj)
  {
    super(paramQQAppInterface, paramaigj, paramQQWalletBaseMsgElem, paramInt, paramaghj);
    this.jdField_a_of_type_Akwu = ((akwu)paramQQAppInterface.getManager(125));
    if (a(this.jdField_a_of_type_Akwu.a(this.jdField_a_of_type_ComTencentMobileqqDataMessageForQQWalletMsg.mQQWalletRedPacketMsg.redPacketId))) {}
    for (this.i = 0;; this.i = paramQQWalletBaseMsgElem.effectsId)
    {
      this.j = 2130847236;
      return;
    }
  }
  
  public boolean b()
  {
    boolean bool = super.b();
    if (bool) {
      return bool;
    }
    this.jdField_a_of_type_Aigj.b.setVisibility(0);
    this.jdField_a_of_type_Aigj.b.setTextColor(-8947849);
    this.jdField_a_of_type_Aigj.b.setText(aifu.l);
    return true;
  }
  
  public void f()
  {
    super.f();
    try
    {
      this.jdField_a_of_type_Aigj.a.setText(alil.a(this.jdField_a_of_type_Aigj.a.getContext(), this.jdField_a_of_type_ComTencentMobileqqDataQQWalletBaseMsgElem.title, 330, this.jdField_a_of_type_Aigj.a.getPaint()));
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
    akwt localakwt2 = this.jdField_a_of_type_Akwu.a(localQQWalletRedPacketMsg.redPacketId);
    akwt localakwt1 = localakwt2;
    if (localakwt2 == null)
    {
      localakwt1 = new akwt(localQQWalletRedPacketMsg.redPacketId, localQQWalletRedPacketMsg.redPacketIndex, this.jdField_a_of_type_ComTencentMobileqqDataMessageForQQWalletMsg.senderuin, this.jdField_a_of_type_ComTencentMobileqqDataMessageForQQWalletMsg.time + 90000L, this.jdField_a_of_type_ComTencentMobileqqDataQQWalletBaseMsgElem.title, false, false, false, 5);
      this.jdField_a_of_type_Akwu.a(localQQWalletRedPacketMsg.redPacketId, localQQWalletRedPacketMsg.redPacketIndex, this.jdField_a_of_type_ComTencentMobileqqDataQQWalletBaseMsgElem.title, this.jdField_a_of_type_ComTencentMobileqqDataMessageForQQWalletMsg.senderuin, this.jdField_a_of_type_ComTencentMobileqqDataMessageForQQWalletMsg.time + 90000L, String.valueOf(this.jdField_a_of_type_Akwu.a(this.jdField_a_of_type_ComTencentMobileqqDataMessageForQQWalletMsg.istroop)), this.jdField_a_of_type_ComTencentMobileqqDataMessageForQQWalletMsg.frienduin, localQQWalletRedPacketMsg.authkey, false, false, 5);
    }
    if (!a(localakwt1))
    {
      this.jdField_a_of_type_Aigj.d.setVisibility(8);
      return;
    }
    this.jdField_a_of_type_Aigj.d.setVisibility(0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aifq
 * JD-Core Version:    0.7.0.1
 */