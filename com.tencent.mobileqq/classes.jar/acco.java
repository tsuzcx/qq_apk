import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.style.ClickableSpan;
import android.view.View;
import com.tencent.mobileqq.activity.PayBridgeActivity;
import com.tencent.mobileqq.app.HotChatManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageForQQWalletTips;
import com.tencent.mobileqq.utils.ContactUtils;
import java.lang.ref.SoftReference;
import org.json.JSONObject;

public class acco
  extends ClickableSpan
{
  public acco(MessageForQQWalletTips paramMessageForQQWalletTips, SoftReference paramSoftReference1, SoftReference paramSoftReference2, String paramString, int paramInt) {}
  
  public void onClick(View paramView)
  {
    int j = 0;
    Context localContext = (Context)this.jdField_a_of_type_JavaLangRefSoftReference.get();
    QQAppInterface localQQAppInterface = (QQAppInterface)this.b.get();
    if ((localQQAppInterface == null) || (localContext == null)) {
      return;
    }
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqDataMessageForQQWalletTips.frienduin;
    int i;
    switch (this.jdField_a_of_type_ComTencentMobileqqDataMessageForQQWalletTips.istroop)
    {
    default: 
      paramView = "";
      i = 0;
      j = -1;
    }
    for (;;)
    {
      if ((i != 0) && (localQQAppInterface.getCurrentAccountUin().equals(this.jdField_a_of_type_ComTencentMobileqqDataMessageForQQWalletTips.reciverUin))) {
        localObject = localQQAppInterface.getCurrentAccountUin();
      }
      for (;;)
      {
        JSONObject localJSONObject2 = new JSONObject();
        JSONObject localJSONObject1 = new JSONObject();
        try
        {
          localJSONObject2.put("listid", this.jdField_a_of_type_JavaLangString);
          localJSONObject2.put("name", paramView);
          localJSONObject2.put("grouptype", j + "");
          localJSONObject2.put("groupid", localObject);
          if (this.jdField_a_of_type_ComTencentMobileqqDataMessageForQQWalletTips.authKey != null) {
            localJSONObject2.put("authkey", this.jdField_a_of_type_ComTencentMobileqqDataMessageForQQWalletTips.authKey);
          }
          localJSONObject1.put("userId", localQQAppInterface.getCurrentAccountUin());
          localJSONObject1.put("viewTag", "redgiftDetail");
          localJSONObject1.put("app_info", "appid#1344242394|bargainor_id#1000030201|channel#graytips");
          localJSONObject1.put("come_from", 2);
          localJSONObject1.put("extra_data", localJSONObject2);
        }
        catch (Exception paramView)
        {
          label317:
          break label317;
        }
        paramView = new Bundle();
        paramView.putString("json", localJSONObject1.toString());
        paramView.putString("callbackSn", "0");
        localObject = new Intent(localContext, PayBridgeActivity.class);
        ((Intent)localObject).putExtras(paramView);
        ((Intent)localObject).putExtra("pay_requestcode", 5);
        localContext.startActivity((Intent)localObject);
        return;
        paramView = localQQAppInterface.getCurrentNickname();
        i = 1;
        break;
        paramView = (HotChatManager)localQQAppInterface.getManager(59);
        if ((paramView != null) && (paramView.b(this.jdField_a_of_type_ComTencentMobileqqDataMessageForQQWalletTips.frienduin)))
        {
          paramView = ContactUtils.q(localQQAppInterface, localQQAppInterface.getCurrentNickname());
          if (!TextUtils.isEmpty(paramView)) {
            break label562;
          }
          paramView = localQQAppInterface.getCurrentNickname();
          i = 0;
          j = 5;
          break;
        }
        paramView = localQQAppInterface.getCurrentNickname();
        j = 1;
        i = 0;
        break;
        paramView = ContactUtils.a(localQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqDataMessageForQQWalletTips.frienduin, this.jdField_a_of_type_ComTencentMobileqqDataMessageForQQWalletTips.memberUin);
        i = 0;
        j = 2;
        break;
        j = 3;
        paramView = localQQAppInterface.getCurrentNickname();
        i = 1;
        break;
        j = 4;
        paramView = localQQAppInterface.getCurrentNickname();
        i = 1;
        break;
        j = 6;
        paramView = ContactUtils.q(localQQAppInterface, localQQAppInterface.getCurrentNickname());
        if (!TextUtils.isEmpty(paramView)) {
          break label557;
        }
        paramView = localQQAppInterface.getCurrentNickname();
        i = 1;
        break;
      }
      label557:
      i = 1;
      continue;
      label562:
      i = 0;
      j = 5;
    }
  }
  
  public void updateDrawState(TextPaint paramTextPaint)
  {
    super.updateDrawState(paramTextPaint);
    paramTextPaint.setColor(this.jdField_a_of_type_Int);
    paramTextPaint.setUnderlineText(false);
    paramTextPaint.clearShadowLayer();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     acco
 * JD-Core Version:    0.7.0.1
 */