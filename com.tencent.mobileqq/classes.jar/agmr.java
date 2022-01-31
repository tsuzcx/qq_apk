import android.text.TextUtils.TruncateAt;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageForQQWalletMsg;
import com.tencent.mobileqq.data.QQWalletAioBodyReserve;
import com.tencent.mobileqq.data.QQWalletRedPacketMsg;
import com.tencent.mobileqq.data.QQWalletTransferMsgElem;
import org.json.JSONException;
import org.json.JSONObject;

public class agmr
  extends aglx
{
  aiul a;
  
  public agmr(QQAppInterface paramQQAppInterface, agmp paramagmp, QQWalletTransferMsgElem paramQQWalletTransferMsgElem, int paramInt, aere paramaere)
  {
    super(paramQQAppInterface, paramagmp, paramQQWalletTransferMsgElem, paramInt, paramaere);
    this.jdField_a_of_type_Aiul = ((aiul)paramQQAppInterface.getManager(125));
    if (a(this.jdField_a_of_type_Aiul.a(this.jdField_a_of_type_ComTencentMobileqqDataMessageForQQWalletMsg.mQQWalletRedPacketMsg.redPacketId))) {}
    for (this.i = 0;; this.i = paramQQWalletTransferMsgElem.effectsId)
    {
      this.j = 2130846774;
      return;
    }
  }
  
  public boolean b()
  {
    boolean bool = super.b();
    if (bool) {
      return bool;
    }
    this.jdField_a_of_type_Agmp.b.setVisibility(0);
    this.jdField_a_of_type_Agmp.b.setTextColor(-8947849);
    this.jdField_a_of_type_Agmp.b.setText(agmc.b);
    this.jdField_a_of_type_Agmp.b.setSingleLine(true);
    this.jdField_a_of_type_Agmp.b.setEllipsize(TextUtils.TruncateAt.START);
    this.jdField_a_of_type_Agmp.b.setSelected(true);
    return false;
  }
  
  public void i()
  {
    QQWalletRedPacketMsg localQQWalletRedPacketMsg = this.jdField_a_of_type_ComTencentMobileqqDataMessageForQQWalletMsg.mQQWalletRedPacketMsg;
    aiuk localaiuk = this.jdField_a_of_type_Aiul.a(localQQWalletRedPacketMsg.redPacketId);
    Object localObject = localaiuk;
    if (localaiuk == null) {
      localObject = new JSONObject();
    }
    label294:
    do
    {
      try
      {
        ((JSONObject)localObject).put("key_sub_channel", localQQWalletRedPacketMsg.body.subChannel);
        localObject = new aiuk(localQQWalletRedPacketMsg.redPacketId, localQQWalletRedPacketMsg.redPacketIndex, this.jdField_a_of_type_ComTencentMobileqqDataMessageForQQWalletMsg.senderuin, this.jdField_a_of_type_ComTencentMobileqqDataMessageForQQWalletMsg.time + 90000L, this.jdField_a_of_type_ComTencentMobileqqDataQQWalletTransferMsgElem.title, false, false, false, 4, "", ((JSONObject)localObject).toString());
        this.jdField_a_of_type_Aiul.a(localQQWalletRedPacketMsg.redPacketId, localQQWalletRedPacketMsg.redPacketIndex, this.jdField_a_of_type_ComTencentMobileqqDataQQWalletTransferMsgElem.title, this.jdField_a_of_type_ComTencentMobileqqDataMessageForQQWalletMsg.senderuin, this.jdField_a_of_type_ComTencentMobileqqDataMessageForQQWalletMsg.time + 90000L, String.valueOf(this.jdField_a_of_type_Aiul.a(this.jdField_a_of_type_ComTencentMobileqqDataMessageForQQWalletMsg.istroop)), this.jdField_a_of_type_ComTencentMobileqqDataMessageForQQWalletMsg.frienduin, localQQWalletRedPacketMsg.authkey, false, false, 4);
        if ((bdnn.a(((aiuk)localObject).e)) || (bdnn.a(((aiuk)localObject).e.trim()))) {
          this.jdField_a_of_type_Aiul.a(localQQWalletRedPacketMsg.redPacketId, localQQWalletRedPacketMsg.elem.title, localQQWalletRedPacketMsg.elem.lastPinyin, 0);
        }
        if (!a((aiuk)localObject))
        {
          this.jdField_a_of_type_Agmp.d.setVisibility(8);
          if (bdnn.a(((aiuk)localObject).e)) {
            continue;
          }
          if (!((aiuk)localObject).b) {
            break label294;
          }
          this.jdField_a_of_type_Agmp.b.setText(alud.a(2131714611));
        }
      }
      catch (JSONException localJSONException)
      {
        String str;
        do
        {
          for (;;)
          {
            localJSONException.printStackTrace();
            continue;
            this.jdField_a_of_type_Agmp.d.setVisibility(0);
          }
          str = ((aiuk)localObject).e;
          str = this.jdField_a_of_type_Aiul.a(str);
        } while (bdnn.a(str));
        this.jdField_a_of_type_Agmp.b.setText(alud.a(2131714612) + str.trim() + " ");
        this.jdField_a_of_type_Aiul.a(this.jdField_a_of_type_AndroidContentContext, str.trim(), ((aiuk)localObject).a);
        return;
      }
    } while (!((aiuk)localObject).b);
    this.jdField_a_of_type_Agmp.b.setText(alud.a(2131714610));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     agmr
 * JD-Core Version:    0.7.0.1
 */