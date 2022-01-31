import android.text.TextUtils.TruncateAt;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageForQQWalletMsg;
import com.tencent.mobileqq.data.QQWalletRedPacketMsg;
import com.tencent.mobileqq.data.QQWalletTransferMsgElem;

public class aeln
  extends aekt
{
  agvz a;
  
  public aeln(QQAppInterface paramQQAppInterface, aell paramaell, QQWalletTransferMsgElem paramQQWalletTransferMsgElem, int paramInt, acvj paramacvj)
  {
    super(paramQQAppInterface, paramaell, paramQQWalletTransferMsgElem, paramInt, paramacvj);
    this.jdField_a_of_type_Agvz = ((agvz)paramQQAppInterface.getManager(125));
    if (a(this.jdField_a_of_type_Agvz.a(this.jdField_a_of_type_ComTencentMobileqqDataMessageForQQWalletMsg.mQQWalletRedPacketMsg.redPacketId))) {}
    for (this.i = 0;; this.i = paramQQWalletTransferMsgElem.effectsId)
    {
      this.j = 2130846316;
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
    this.jdField_a_of_type_Aell.b.setText(aeky.b);
    this.jdField_a_of_type_Aell.b.setSingleLine(true);
    this.jdField_a_of_type_Aell.b.setEllipsize(TextUtils.TruncateAt.START);
    this.jdField_a_of_type_Aell.b.setSelected(true);
    return false;
  }
  
  public void i()
  {
    QQWalletRedPacketMsg localQQWalletRedPacketMsg = this.jdField_a_of_type_ComTencentMobileqqDataMessageForQQWalletMsg.mQQWalletRedPacketMsg;
    Object localObject2 = this.jdField_a_of_type_Agvz.a(localQQWalletRedPacketMsg.redPacketId);
    Object localObject1 = localObject2;
    if (localObject2 == null)
    {
      localObject1 = new agvy(localQQWalletRedPacketMsg.redPacketId, localQQWalletRedPacketMsg.redPacketIndex, this.jdField_a_of_type_ComTencentMobileqqDataMessageForQQWalletMsg.senderuin, this.jdField_a_of_type_ComTencentMobileqqDataMessageForQQWalletMsg.time + 90000L, this.jdField_a_of_type_ComTencentMobileqqDataQQWalletTransferMsgElem.title, false, false, false, 4);
      this.jdField_a_of_type_Agvz.a(localQQWalletRedPacketMsg.redPacketId, localQQWalletRedPacketMsg.redPacketIndex, this.jdField_a_of_type_ComTencentMobileqqDataQQWalletTransferMsgElem.title, this.jdField_a_of_type_ComTencentMobileqqDataMessageForQQWalletMsg.senderuin, this.jdField_a_of_type_ComTencentMobileqqDataMessageForQQWalletMsg.time + 90000L, String.valueOf(this.jdField_a_of_type_Agvz.a(this.jdField_a_of_type_ComTencentMobileqqDataMessageForQQWalletMsg.istroop)), this.jdField_a_of_type_ComTencentMobileqqDataMessageForQQWalletMsg.frienduin, localQQWalletRedPacketMsg.authkey, false, false, 4);
    }
    if ((bbjw.a(((agvy)localObject1).e)) || (bbjw.a(((agvy)localObject1).e.trim()))) {
      this.jdField_a_of_type_Agvz.a(localQQWalletRedPacketMsg.redPacketId, localQQWalletRedPacketMsg.elem.title, localQQWalletRedPacketMsg.elem.lastPinyin, 0);
    }
    if (!a((agvy)localObject1))
    {
      this.jdField_a_of_type_Aell.d.setVisibility(8);
      if (bbjw.a(((agvy)localObject1).e)) {
        break label339;
      }
      if (!((agvy)localObject1).b) {
        break label258;
      }
      this.jdField_a_of_type_Aell.b.setText(ajyc.a(2131714216));
    }
    label258:
    label339:
    while (!((agvy)localObject1).b)
    {
      do
      {
        return;
        this.jdField_a_of_type_Aell.d.setVisibility(0);
        break;
        localObject2 = ((agvy)localObject1).e;
        localObject2 = this.jdField_a_of_type_Agvz.a((String)localObject2);
      } while (bbjw.a((String)localObject2));
      this.jdField_a_of_type_Aell.b.setText(ajyc.a(2131714217) + ((String)localObject2).trim() + " ");
      this.jdField_a_of_type_Agvz.a(this.jdField_a_of_type_AndroidContentContext, ((String)localObject2).trim(), ((agvy)localObject1).a);
      return;
    }
    this.jdField_a_of_type_Aell.b.setText(ajyc.a(2131714215));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     aeln
 * JD-Core Version:    0.7.0.1
 */