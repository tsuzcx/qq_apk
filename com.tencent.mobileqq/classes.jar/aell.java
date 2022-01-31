import android.text.TextUtils.TruncateAt;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageForQQWalletMsg;
import com.tencent.mobileqq.data.QQWalletRedPacketMsg;
import com.tencent.mobileqq.data.QQWalletTransferMsgElem;

public class aell
  extends aekr
{
  agvx a;
  
  public aell(QQAppInterface paramQQAppInterface, aelj paramaelj, QQWalletTransferMsgElem paramQQWalletTransferMsgElem, int paramInt, acvf paramacvf)
  {
    super(paramQQAppInterface, paramaelj, paramQQWalletTransferMsgElem, paramInt, paramacvf);
    this.jdField_a_of_type_Agvx = ((agvx)paramQQAppInterface.getManager(125));
    if (a(this.jdField_a_of_type_Agvx.a(this.jdField_a_of_type_ComTencentMobileqqDataMessageForQQWalletMsg.mQQWalletRedPacketMsg.redPacketId))) {}
    for (this.i = 0;; this.i = paramQQWalletTransferMsgElem.effectsId)
    {
      this.j = 2130846322;
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
    this.jdField_a_of_type_Aelj.b.setText(aekw.b);
    this.jdField_a_of_type_Aelj.b.setSingleLine(true);
    this.jdField_a_of_type_Aelj.b.setEllipsize(TextUtils.TruncateAt.START);
    this.jdField_a_of_type_Aelj.b.setSelected(true);
    return false;
  }
  
  public void i()
  {
    QQWalletRedPacketMsg localQQWalletRedPacketMsg = this.jdField_a_of_type_ComTencentMobileqqDataMessageForQQWalletMsg.mQQWalletRedPacketMsg;
    Object localObject2 = this.jdField_a_of_type_Agvx.a(localQQWalletRedPacketMsg.redPacketId);
    Object localObject1 = localObject2;
    if (localObject2 == null)
    {
      localObject1 = new agvw(localQQWalletRedPacketMsg.redPacketId, localQQWalletRedPacketMsg.redPacketIndex, this.jdField_a_of_type_ComTencentMobileqqDataMessageForQQWalletMsg.senderuin, this.jdField_a_of_type_ComTencentMobileqqDataMessageForQQWalletMsg.time + 90000L, this.jdField_a_of_type_ComTencentMobileqqDataQQWalletTransferMsgElem.title, false, false, false, 4);
      this.jdField_a_of_type_Agvx.a(localQQWalletRedPacketMsg.redPacketId, localQQWalletRedPacketMsg.redPacketIndex, this.jdField_a_of_type_ComTencentMobileqqDataQQWalletTransferMsgElem.title, this.jdField_a_of_type_ComTencentMobileqqDataMessageForQQWalletMsg.senderuin, this.jdField_a_of_type_ComTencentMobileqqDataMessageForQQWalletMsg.time + 90000L, String.valueOf(this.jdField_a_of_type_Agvx.a(this.jdField_a_of_type_ComTencentMobileqqDataMessageForQQWalletMsg.istroop)), this.jdField_a_of_type_ComTencentMobileqqDataMessageForQQWalletMsg.frienduin, localQQWalletRedPacketMsg.authkey, false, false, 4);
    }
    if ((bbkk.a(((agvw)localObject1).e)) || (bbkk.a(((agvw)localObject1).e.trim()))) {
      this.jdField_a_of_type_Agvx.a(localQQWalletRedPacketMsg.redPacketId, localQQWalletRedPacketMsg.elem.title, localQQWalletRedPacketMsg.elem.lastPinyin, 0);
    }
    if (!a((agvw)localObject1))
    {
      this.jdField_a_of_type_Aelj.d.setVisibility(8);
      if (bbkk.a(((agvw)localObject1).e)) {
        break label339;
      }
      if (!((agvw)localObject1).b) {
        break label258;
      }
      this.jdField_a_of_type_Aelj.b.setText(ajya.a(2131714227));
    }
    label258:
    label339:
    while (!((agvw)localObject1).b)
    {
      do
      {
        return;
        this.jdField_a_of_type_Aelj.d.setVisibility(0);
        break;
        localObject2 = ((agvw)localObject1).e;
        localObject2 = this.jdField_a_of_type_Agvx.a((String)localObject2);
      } while (bbkk.a((String)localObject2));
      this.jdField_a_of_type_Aelj.b.setText(ajya.a(2131714228) + ((String)localObject2).trim() + " ");
      this.jdField_a_of_type_Agvx.a(this.jdField_a_of_type_AndroidContentContext, ((String)localObject2).trim(), ((agvw)localObject1).a);
      return;
    }
    this.jdField_a_of_type_Aelj.b.setText(ajya.a(2131714226));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     aell
 * JD-Core Version:    0.7.0.1
 */