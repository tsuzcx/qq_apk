import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageForQQWalletMsg;
import com.tencent.mobileqq.data.QQWalletRedPacketMsg;
import com.tencent.mobileqq.data.QQWalletTransferMsgElem;

public class aeaa
  extends adzu
{
  agjk a;
  
  public aeaa(QQAppInterface paramQQAppInterface, aeam paramaeam, QQWalletTransferMsgElem paramQQWalletTransferMsgElem, int paramInt, ackq paramackq)
  {
    super(paramQQAppInterface, paramaeam, paramQQWalletTransferMsgElem, paramInt, paramackq);
    this.jdField_a_of_type_Agjk = ((agjk)paramQQAppInterface.getManager(125));
    if (a(this.jdField_a_of_type_Agjk.a(this.jdField_a_of_type_ComTencentMobileqqDataMessageForQQWalletMsg.mQQWalletRedPacketMsg.redPacketId))) {}
    for (this.i = 0;; this.i = paramQQWalletTransferMsgElem.effectsId)
    {
      this.j = 2130846137;
      return;
    }
  }
  
  public boolean b()
  {
    boolean bool = super.b();
    if (bool) {
      return bool;
    }
    this.jdField_a_of_type_Aeam.b.setVisibility(0);
    this.jdField_a_of_type_Aeam.b.setTextColor(-8947849);
    this.jdField_a_of_type_Aeam.b.setText("K歌红包");
    return true;
  }
  
  public void f()
  {
    super.f();
    try
    {
      this.jdField_a_of_type_Aeam.a.setText(agwj.a(this.jdField_a_of_type_Aeam.a.getContext(), this.jdField_a_of_type_ComTencentMobileqqDataQQWalletTransferMsgElem.title, 330, this.jdField_a_of_type_Aeam.a.getPaint()));
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
    agjj localagjj2 = this.jdField_a_of_type_Agjk.a(localQQWalletRedPacketMsg.redPacketId);
    agjj localagjj1 = localagjj2;
    if (localagjj2 == null)
    {
      localagjj1 = new agjj(localQQWalletRedPacketMsg.redPacketId, localQQWalletRedPacketMsg.redPacketIndex, this.jdField_a_of_type_ComTencentMobileqqDataMessageForQQWalletMsg.senderuin, this.jdField_a_of_type_ComTencentMobileqqDataMessageForQQWalletMsg.time + 90000L, this.jdField_a_of_type_ComTencentMobileqqDataQQWalletTransferMsgElem.title, false, false, false, 2);
      this.jdField_a_of_type_Agjk.a(localQQWalletRedPacketMsg.redPacketId, localQQWalletRedPacketMsg.redPacketIndex, this.jdField_a_of_type_ComTencentMobileqqDataQQWalletTransferMsgElem.title, this.jdField_a_of_type_ComTencentMobileqqDataMessageForQQWalletMsg.senderuin, this.jdField_a_of_type_ComTencentMobileqqDataMessageForQQWalletMsg.time + 90000L, String.valueOf(this.jdField_a_of_type_Agjk.a(this.jdField_a_of_type_ComTencentMobileqqDataMessageForQQWalletMsg.istroop)), this.jdField_a_of_type_ComTencentMobileqqDataMessageForQQWalletMsg.frienduin, localQQWalletRedPacketMsg.authkey, false, false, 2);
    }
    if (!a(localagjj1))
    {
      this.jdField_a_of_type_Aeam.d.setVisibility(8);
      return;
    }
    this.jdField_a_of_type_Aeam.d.setVisibility(0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     aeaa
 * JD-Core Version:    0.7.0.1
 */