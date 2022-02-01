import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageForQQWalletMsg;
import com.tencent.mobileqq.data.QQWalletBaseMsgElem;
import com.tencent.mobileqq.data.QQWalletRedPacketMsg;

public class ahch
  extends ahcf
{
  ajul a;
  
  public ahch(QQAppInterface paramQQAppInterface, ahcz paramahcz, QQWalletBaseMsgElem paramQQWalletBaseMsgElem, int paramInt, afaf paramafaf)
  {
    super(paramQQAppInterface, paramahcz, paramQQWalletBaseMsgElem, paramInt, paramafaf);
    this.jdField_a_of_type_Ajul = ((ajul)paramQQAppInterface.getManager(125));
    if (a(this.jdField_a_of_type_Ajul.a(this.jdField_a_of_type_ComTencentMobileqqDataMessageForQQWalletMsg.mQQWalletRedPacketMsg.redPacketId))) {}
    for (this.i = 0;; this.i = paramQQWalletBaseMsgElem.effectsId)
    {
      this.j = 2130847146;
      return;
    }
  }
  
  public boolean b()
  {
    boolean bool = super.b();
    if (bool) {
      return bool;
    }
    this.jdField_a_of_type_Ahcz.b.setVisibility(0);
    this.jdField_a_of_type_Ahcz.b.setTextColor(-8947849);
    this.jdField_a_of_type_Ahcz.b.setText(ahck.j);
    return true;
  }
  
  public void f()
  {
    super.f();
    try
    {
      this.jdField_a_of_type_Ahcz.a.setText(akgd.a(this.jdField_a_of_type_Ahcz.a.getContext(), this.jdField_a_of_type_ComTencentMobileqqDataQQWalletBaseMsgElem.title, 330, this.jdField_a_of_type_Ahcz.a.getPaint()));
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
    ajuk localajuk2 = this.jdField_a_of_type_Ajul.a(localQQWalletRedPacketMsg.redPacketId);
    ajuk localajuk1 = localajuk2;
    if (localajuk2 == null)
    {
      localajuk1 = new ajuk(localQQWalletRedPacketMsg.redPacketId, localQQWalletRedPacketMsg.redPacketIndex, this.jdField_a_of_type_ComTencentMobileqqDataMessageForQQWalletMsg.senderuin, this.jdField_a_of_type_ComTencentMobileqqDataMessageForQQWalletMsg.time + 90000L, this.jdField_a_of_type_ComTencentMobileqqDataQQWalletBaseMsgElem.title, false, false, false, 3);
      this.jdField_a_of_type_Ajul.a(localQQWalletRedPacketMsg.redPacketId, localQQWalletRedPacketMsg.redPacketIndex, this.jdField_a_of_type_ComTencentMobileqqDataQQWalletBaseMsgElem.title, this.jdField_a_of_type_ComTencentMobileqqDataMessageForQQWalletMsg.senderuin, this.jdField_a_of_type_ComTencentMobileqqDataMessageForQQWalletMsg.time + 90000L, String.valueOf(this.jdField_a_of_type_Ajul.a(this.jdField_a_of_type_ComTencentMobileqqDataMessageForQQWalletMsg.istroop)), this.jdField_a_of_type_ComTencentMobileqqDataMessageForQQWalletMsg.frienduin, localQQWalletRedPacketMsg.authkey, false, false, 3);
    }
    if (!super.a(localajuk1))
    {
      this.jdField_a_of_type_Ahcz.d.setVisibility(8);
      return;
    }
    this.jdField_a_of_type_Ahcz.d.setVisibility(0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ahch
 * JD-Core Version:    0.7.0.1
 */