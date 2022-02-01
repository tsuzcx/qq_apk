import android.text.TextUtils.TruncateAt;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageForQQWalletMsg;
import com.tencent.mobileqq.data.QQWalletAioBodyReserve;
import com.tencent.mobileqq.data.QQWalletBaseMsgElem;
import com.tencent.mobileqq.data.QQWalletRedPacketMsg;
import com.tencent.mobileqq.utils.StringUtil;
import org.json.JSONException;
import org.json.JSONObject;

public class ahdb
  extends ahcf
{
  ajul a;
  
  public ahdb(QQAppInterface paramQQAppInterface, ahcz paramahcz, QQWalletBaseMsgElem paramQQWalletBaseMsgElem, int paramInt, afaf paramafaf)
  {
    super(paramQQAppInterface, paramahcz, paramQQWalletBaseMsgElem, paramInt, paramafaf);
    this.jdField_a_of_type_Ajul = ((ajul)paramQQAppInterface.getManager(125));
    if (a(this.jdField_a_of_type_Ajul.a(this.jdField_a_of_type_ComTencentMobileqqDataMessageForQQWalletMsg.mQQWalletRedPacketMsg.redPacketId))) {}
    for (this.i = 0;; this.i = paramQQWalletBaseMsgElem.effectsId)
    {
      this.j = 2130847148;
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
    this.jdField_a_of_type_Ahcz.b.setText(ahck.k);
    this.jdField_a_of_type_Ahcz.b.setSingleLine(true);
    this.jdField_a_of_type_Ahcz.b.setEllipsize(TextUtils.TruncateAt.END);
    this.jdField_a_of_type_Ahcz.b.setSelected(true);
    return false;
  }
  
  public void i()
  {
    QQWalletRedPacketMsg localQQWalletRedPacketMsg = this.jdField_a_of_type_ComTencentMobileqqDataMessageForQQWalletMsg.mQQWalletRedPacketMsg;
    Object localObject2 = this.jdField_a_of_type_Ajul.a(localQQWalletRedPacketMsg.redPacketId);
    if (localObject2 == null) {
      localObject2 = new JSONObject();
    }
    for (;;)
    {
      try
      {
        ((JSONObject)localObject2).put("key_sub_channel", localQQWalletRedPacketMsg.body.subChannel);
        ajuk.a((JSONObject)localObject2, localQQWalletRedPacketMsg.body.poemRule);
        if (localQQWalletRedPacketMsg.body.subChannel == 2)
        {
          String str1 = localQQWalletRedPacketMsg.elem.lastPinyin;
          localObject2 = new ajuk(localQQWalletRedPacketMsg.redPacketId, localQQWalletRedPacketMsg.redPacketIndex, this.jdField_a_of_type_ComTencentMobileqqDataMessageForQQWalletMsg.senderuin, this.jdField_a_of_type_ComTencentMobileqqDataMessageForQQWalletMsg.time + 90000L, this.jdField_a_of_type_ComTencentMobileqqDataQQWalletBaseMsgElem.title, false, false, false, 4, str1, ((JSONObject)localObject2).toString());
          this.jdField_a_of_type_Ajul.a(localQQWalletRedPacketMsg.redPacketId, localQQWalletRedPacketMsg.redPacketIndex, this.jdField_a_of_type_ComTencentMobileqqDataQQWalletBaseMsgElem.title, this.jdField_a_of_type_ComTencentMobileqqDataMessageForQQWalletMsg.senderuin, this.jdField_a_of_type_ComTencentMobileqqDataMessageForQQWalletMsg.time + 90000L, String.valueOf(this.jdField_a_of_type_Ajul.a(this.jdField_a_of_type_ComTencentMobileqqDataMessageForQQWalletMsg.istroop)), this.jdField_a_of_type_ComTencentMobileqqDataMessageForQQWalletMsg.frienduin, localQQWalletRedPacketMsg.authkey, false, false, 4);
          if ((StringUtil.isEmpty(((ajuk)localObject2).e)) || (StringUtil.isEmpty(((ajuk)localObject2).e.trim()))) {
            this.jdField_a_of_type_Ajul.a(localQQWalletRedPacketMsg.redPacketId, localQQWalletRedPacketMsg.elem.title, localQQWalletRedPacketMsg.elem.lastPinyin, 0, localQQWalletRedPacketMsg.body.poemRule);
          }
          if (a((ajuk)localObject2)) {
            continue;
          }
          this.jdField_a_of_type_Ahcz.d.setVisibility(8);
          if (StringUtil.isEmpty(((ajuk)localObject2).e)) {
            continue;
          }
          if (!((ajuk)localObject2).b) {
            continue;
          }
          this.jdField_a_of_type_Ahcz.b.setText(ahck.k);
        }
      }
      catch (JSONException localJSONException)
      {
        localJSONException.printStackTrace();
        continue;
        Object localObject1 = "";
        continue;
        this.jdField_a_of_type_Ahcz.d.setVisibility(0);
        continue;
        localObject1 = ((ajuk)localObject2).e;
        String str2 = ajul.a((String)localObject1);
        String str3 = ajul.b((String)localObject1);
        if (!StringUtil.isEmpty(str2))
        {
          switch (localQQWalletRedPacketMsg.body.subChannel)
          {
          default: 
            localObject1 = amtj.a(2131713320) + str2.trim() + " ";
            this.jdField_a_of_type_Ahcz.b.setText((CharSequence)localObject1);
            if (((ajuk)localObject2).a() != 3) {
              continue;
            }
            localObject1 = str3;
            this.jdField_a_of_type_Ajul.a(this.jdField_a_of_type_AndroidContentContext, (String)localObject1, ((ajuk)localObject2).a);
            return;
          case 2: 
            localObject1 = amtj.a(2131713319) + str2.trim() + " ";
            break;
          }
          localObject1 = "接龙红包：" + str3;
          continue;
          localObject1 = str2;
          continue;
          if (((ajuk)localObject2).b)
          {
            this.jdField_a_of_type_Ahcz.b.setText(ahck.k);
            return;
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ahdb
 * JD-Core Version:    0.7.0.1
 */