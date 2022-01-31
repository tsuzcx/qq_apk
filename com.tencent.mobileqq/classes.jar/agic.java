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

public class agic
  extends aghi
{
  aipw a;
  
  public agic(QQAppInterface paramQQAppInterface, agia paramagia, QQWalletTransferMsgElem paramQQWalletTransferMsgElem, int paramInt, aemp paramaemp)
  {
    super(paramQQAppInterface, paramagia, paramQQWalletTransferMsgElem, paramInt, paramaemp);
    this.jdField_a_of_type_Aipw = ((aipw)paramQQAppInterface.getManager(125));
    if (a(this.jdField_a_of_type_Aipw.a(this.jdField_a_of_type_ComTencentMobileqqDataMessageForQQWalletMsg.mQQWalletRedPacketMsg.redPacketId))) {}
    for (this.i = 0;; this.i = paramQQWalletTransferMsgElem.effectsId)
    {
      this.j = 2130846701;
      return;
    }
  }
  
  public boolean b()
  {
    boolean bool = super.b();
    if (bool) {
      return bool;
    }
    this.jdField_a_of_type_Agia.b.setVisibility(0);
    this.jdField_a_of_type_Agia.b.setTextColor(-8947849);
    this.jdField_a_of_type_Agia.b.setText(aghn.b);
    this.jdField_a_of_type_Agia.b.setSingleLine(true);
    this.jdField_a_of_type_Agia.b.setEllipsize(TextUtils.TruncateAt.START);
    this.jdField_a_of_type_Agia.b.setSelected(true);
    return false;
  }
  
  public void i()
  {
    QQWalletRedPacketMsg localQQWalletRedPacketMsg = this.jdField_a_of_type_ComTencentMobileqqDataMessageForQQWalletMsg.mQQWalletRedPacketMsg;
    aipv localaipv = this.jdField_a_of_type_Aipw.a(localQQWalletRedPacketMsg.redPacketId);
    Object localObject = localaipv;
    if (localaipv == null) {
      localObject = new JSONObject();
    }
    label294:
    do
    {
      try
      {
        ((JSONObject)localObject).put("key_sub_channel", localQQWalletRedPacketMsg.body.subChannel);
        localObject = new aipv(localQQWalletRedPacketMsg.redPacketId, localQQWalletRedPacketMsg.redPacketIndex, this.jdField_a_of_type_ComTencentMobileqqDataMessageForQQWalletMsg.senderuin, this.jdField_a_of_type_ComTencentMobileqqDataMessageForQQWalletMsg.time + 90000L, this.jdField_a_of_type_ComTencentMobileqqDataQQWalletTransferMsgElem.title, false, false, false, 4, "", ((JSONObject)localObject).toString());
        this.jdField_a_of_type_Aipw.a(localQQWalletRedPacketMsg.redPacketId, localQQWalletRedPacketMsg.redPacketIndex, this.jdField_a_of_type_ComTencentMobileqqDataQQWalletTransferMsgElem.title, this.jdField_a_of_type_ComTencentMobileqqDataMessageForQQWalletMsg.senderuin, this.jdField_a_of_type_ComTencentMobileqqDataMessageForQQWalletMsg.time + 90000L, String.valueOf(this.jdField_a_of_type_Aipw.a(this.jdField_a_of_type_ComTencentMobileqqDataMessageForQQWalletMsg.istroop)), this.jdField_a_of_type_ComTencentMobileqqDataMessageForQQWalletMsg.frienduin, localQQWalletRedPacketMsg.authkey, false, false, 4);
        if ((bdje.a(((aipv)localObject).e)) || (bdje.a(((aipv)localObject).e.trim()))) {
          this.jdField_a_of_type_Aipw.a(localQQWalletRedPacketMsg.redPacketId, localQQWalletRedPacketMsg.elem.title, localQQWalletRedPacketMsg.elem.lastPinyin, 0);
        }
        if (!a((aipv)localObject))
        {
          this.jdField_a_of_type_Agia.d.setVisibility(8);
          if (bdje.a(((aipv)localObject).e)) {
            continue;
          }
          if (!((aipv)localObject).b) {
            break label294;
          }
          this.jdField_a_of_type_Agia.b.setText(alpo.a(2131714599));
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
            this.jdField_a_of_type_Agia.d.setVisibility(0);
          }
          str = ((aipv)localObject).e;
          str = this.jdField_a_of_type_Aipw.a(str);
        } while (bdje.a(str));
        this.jdField_a_of_type_Agia.b.setText(alpo.a(2131714600) + str.trim() + " ");
        this.jdField_a_of_type_Aipw.a(this.jdField_a_of_type_AndroidContentContext, str.trim(), ((aipv)localObject).a);
        return;
      }
    } while (!((aipv)localObject).b);
    this.jdField_a_of_type_Agia.b.setText(alpo.a(2131714598));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     agic
 * JD-Core Version:    0.7.0.1
 */