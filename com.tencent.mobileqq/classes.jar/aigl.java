import android.text.TextUtils.TruncateAt;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageForQQWalletMsg;
import com.tencent.mobileqq.data.QQWalletAioBodyReserve;
import com.tencent.mobileqq.data.QQWalletBaseMsgElem;
import com.tencent.mobileqq.data.QQWalletRedPacketMsg;
import org.json.JSONException;
import org.json.JSONObject;

public class aigl
  extends aifp
{
  akwu a;
  
  public aigl(QQAppInterface paramQQAppInterface, aigj paramaigj, QQWalletBaseMsgElem paramQQWalletBaseMsgElem, int paramInt, aghj paramaghj)
  {
    super(paramQQAppInterface, paramaigj, paramQQWalletBaseMsgElem, paramInt, paramaghj);
    this.jdField_a_of_type_Akwu = ((akwu)paramQQAppInterface.getManager(125));
    if (a(this.jdField_a_of_type_Akwu.a(this.jdField_a_of_type_ComTencentMobileqqDataMessageForQQWalletMsg.mQQWalletRedPacketMsg.redPacketId))) {}
    for (this.i = 0;; this.i = paramQQWalletBaseMsgElem.effectsId)
    {
      this.j = 2130847240;
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
    this.jdField_a_of_type_Aigj.b.setText(aifu.k);
    this.jdField_a_of_type_Aigj.b.setSingleLine(true);
    this.jdField_a_of_type_Aigj.b.setEllipsize(TextUtils.TruncateAt.END);
    this.jdField_a_of_type_Aigj.b.setSelected(true);
    return false;
  }
  
  public void i()
  {
    QQWalletRedPacketMsg localQQWalletRedPacketMsg = this.jdField_a_of_type_ComTencentMobileqqDataMessageForQQWalletMsg.mQQWalletRedPacketMsg;
    Object localObject2 = this.jdField_a_of_type_Akwu.a(localQQWalletRedPacketMsg.redPacketId);
    if (localObject2 == null) {
      localObject2 = new JSONObject();
    }
    for (;;)
    {
      try
      {
        ((JSONObject)localObject2).put("key_sub_channel", localQQWalletRedPacketMsg.body.subChannel);
        akwt.a((JSONObject)localObject2, localQQWalletRedPacketMsg.body.poemRule);
        if (localQQWalletRedPacketMsg.body.subChannel == 2)
        {
          String str1 = localQQWalletRedPacketMsg.elem.lastPinyin;
          localObject2 = new akwt(localQQWalletRedPacketMsg.redPacketId, localQQWalletRedPacketMsg.redPacketIndex, this.jdField_a_of_type_ComTencentMobileqqDataMessageForQQWalletMsg.senderuin, this.jdField_a_of_type_ComTencentMobileqqDataMessageForQQWalletMsg.time + 90000L, this.jdField_a_of_type_ComTencentMobileqqDataQQWalletBaseMsgElem.title, false, false, false, 4, str1, ((JSONObject)localObject2).toString());
          this.jdField_a_of_type_Akwu.a(localQQWalletRedPacketMsg.redPacketId, localQQWalletRedPacketMsg.redPacketIndex, this.jdField_a_of_type_ComTencentMobileqqDataQQWalletBaseMsgElem.title, this.jdField_a_of_type_ComTencentMobileqqDataMessageForQQWalletMsg.senderuin, this.jdField_a_of_type_ComTencentMobileqqDataMessageForQQWalletMsg.time + 90000L, String.valueOf(this.jdField_a_of_type_Akwu.a(this.jdField_a_of_type_ComTencentMobileqqDataMessageForQQWalletMsg.istroop)), this.jdField_a_of_type_ComTencentMobileqqDataMessageForQQWalletMsg.frienduin, localQQWalletRedPacketMsg.authkey, false, false, 4);
          if ((bhsr.a(((akwt)localObject2).e)) || (bhsr.a(((akwt)localObject2).e.trim()))) {
            this.jdField_a_of_type_Akwu.a(localQQWalletRedPacketMsg.redPacketId, localQQWalletRedPacketMsg.elem.title, localQQWalletRedPacketMsg.elem.lastPinyin, 0, localQQWalletRedPacketMsg.body.poemRule);
          }
          if (a((akwt)localObject2)) {
            continue;
          }
          this.jdField_a_of_type_Aigj.d.setVisibility(8);
          if (bhsr.a(((akwt)localObject2).e)) {
            continue;
          }
          if (!((akwt)localObject2).b) {
            continue;
          }
          this.jdField_a_of_type_Aigj.b.setText(aifu.k);
        }
      }
      catch (JSONException localJSONException)
      {
        localJSONException.printStackTrace();
        continue;
        Object localObject1 = "";
        continue;
        this.jdField_a_of_type_Aigj.d.setVisibility(0);
        continue;
        localObject1 = ((akwt)localObject2).e;
        String str2 = akwu.a((String)localObject1);
        String str3 = akwu.b((String)localObject1);
        if (!bhsr.a(str2))
        {
          switch (localQQWalletRedPacketMsg.body.subChannel)
          {
          default: 
            localObject1 = anzj.a(2131713088) + str2.trim() + " ";
            this.jdField_a_of_type_Aigj.b.setText((CharSequence)localObject1);
            if (((akwt)localObject2).a() != 3) {
              continue;
            }
            localObject1 = str3;
            this.jdField_a_of_type_Akwu.a(this.jdField_a_of_type_AndroidContentContext, (String)localObject1, ((akwt)localObject2).a);
            return;
          case 2: 
            localObject1 = anzj.a(2131713087) + str2.trim() + " ";
            break;
          }
          localObject1 = "接龙红包：" + str3;
          continue;
          localObject1 = str2;
          continue;
          if (((akwt)localObject2).b)
          {
            this.jdField_a_of_type_Aigj.b.setText(aifu.k);
            return;
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aigl
 * JD-Core Version:    0.7.0.1
 */