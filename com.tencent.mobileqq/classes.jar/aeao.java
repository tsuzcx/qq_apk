import android.text.TextUtils.TruncateAt;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageForQQWalletMsg;
import com.tencent.mobileqq.data.QQWalletRedPacketMsg;
import com.tencent.mobileqq.data.QQWalletTransferMsgElem;

public class aeao
  extends adzu
{
  agjk a;
  
  public aeao(QQAppInterface paramQQAppInterface, aeam paramaeam, QQWalletTransferMsgElem paramQQWalletTransferMsgElem, int paramInt, ackq paramackq)
  {
    super(paramQQAppInterface, paramaeam, paramQQWalletTransferMsgElem, paramInt, paramackq);
    this.jdField_a_of_type_Agjk = ((agjk)paramQQAppInterface.getManager(125));
    if (a(this.jdField_a_of_type_Agjk.a(this.jdField_a_of_type_ComTencentMobileqqDataMessageForQQWalletMsg.mQQWalletRedPacketMsg.redPacketId))) {}
    for (this.i = 0;; this.i = paramQQWalletTransferMsgElem.effectsId)
    {
      this.j = 2130846135;
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
    this.jdField_a_of_type_Aeam.b.setText(adzz.b);
    this.jdField_a_of_type_Aeam.b.setSingleLine(true);
    this.jdField_a_of_type_Aeam.b.setEllipsize(TextUtils.TruncateAt.START);
    this.jdField_a_of_type_Aeam.b.setSelected(true);
    return false;
  }
  
  public void i()
  {
    QQWalletRedPacketMsg localQQWalletRedPacketMsg = this.jdField_a_of_type_ComTencentMobileqqDataMessageForQQWalletMsg.mQQWalletRedPacketMsg;
    Object localObject2 = this.jdField_a_of_type_Agjk.a(localQQWalletRedPacketMsg.redPacketId);
    Object localObject1 = localObject2;
    if (localObject2 == null)
    {
      localObject1 = new agjj(localQQWalletRedPacketMsg.redPacketId, localQQWalletRedPacketMsg.redPacketIndex, this.jdField_a_of_type_ComTencentMobileqqDataMessageForQQWalletMsg.senderuin, this.jdField_a_of_type_ComTencentMobileqqDataMessageForQQWalletMsg.time + 90000L, this.jdField_a_of_type_ComTencentMobileqqDataQQWalletTransferMsgElem.title, false, false, false, 4);
      this.jdField_a_of_type_Agjk.a(localQQWalletRedPacketMsg.redPacketId, localQQWalletRedPacketMsg.redPacketIndex, this.jdField_a_of_type_ComTencentMobileqqDataQQWalletTransferMsgElem.title, this.jdField_a_of_type_ComTencentMobileqqDataMessageForQQWalletMsg.senderuin, this.jdField_a_of_type_ComTencentMobileqqDataMessageForQQWalletMsg.time + 90000L, String.valueOf(this.jdField_a_of_type_Agjk.a(this.jdField_a_of_type_ComTencentMobileqqDataMessageForQQWalletMsg.istroop)), this.jdField_a_of_type_ComTencentMobileqqDataMessageForQQWalletMsg.frienduin, localQQWalletRedPacketMsg.authkey, false, false, 4);
    }
    if ((baip.a(((agjj)localObject1).e)) || (baip.a(((agjj)localObject1).e.trim()))) {
      this.jdField_a_of_type_Agjk.a(localQQWalletRedPacketMsg.redPacketId, localQQWalletRedPacketMsg.elem.title, localQQWalletRedPacketMsg.elem.lastPinyin, 0);
    }
    if (!a((agjj)localObject1))
    {
      this.jdField_a_of_type_Aeam.d.setVisibility(8);
      if (baip.a(((agjj)localObject1).e)) {
        break label339;
      }
      if (!((agjj)localObject1).b) {
        break label258;
      }
      this.jdField_a_of_type_Aeam.b.setText(ajjy.a(2131648427));
    }
    label258:
    label339:
    while (!((agjj)localObject1).b)
    {
      do
      {
        return;
        this.jdField_a_of_type_Aeam.d.setVisibility(0);
        break;
        localObject2 = ((agjj)localObject1).e;
        localObject2 = this.jdField_a_of_type_Agjk.a((String)localObject2);
      } while (baip.a((String)localObject2));
      this.jdField_a_of_type_Aeam.b.setText(ajjy.a(2131648428) + ((String)localObject2).trim() + " ");
      this.jdField_a_of_type_Agjk.a(this.jdField_a_of_type_AndroidContentContext, ((String)localObject2).trim(), ((agjj)localObject1).a);
      return;
    }
    this.jdField_a_of_type_Aeam.b.setText(ajjy.a(2131648426));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     aeao
 * JD-Core Version:    0.7.0.1
 */