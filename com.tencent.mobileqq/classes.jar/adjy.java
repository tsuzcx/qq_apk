import android.os.Bundle;
import android.text.TextUtils;
import android.widget.EditText;
import com.tencent.mobileqq.activity.FriendProfileMoreInfoActivity;
import com.tencent.mobileqq.activity.contact.addcontact.SearchBaseActivity;
import com.tencent.mobileqq.app.CardObserver;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.Card;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class adjy
  extends CardObserver
{
  public adjy(FriendProfileMoreInfoActivity paramFriendProfileMoreInfoActivity) {}
  
  public void onCardDownload(boolean paramBoolean, Object paramObject)
  {
    if ((paramBoolean) && ((paramObject instanceof Card)) && (bftf.a(this.a.app.getCurrentAccountUin(), ((Card)paramObject).uin)))
    {
      FriendProfileMoreInfoActivity.a(this.a, (Card)paramObject, true);
      if (!this.a.i)
      {
        paramObject = (apgi)this.a.app.getManager(112);
        FriendProfileMoreInfoActivity.a(this.a, paramObject.a());
      }
    }
  }
  
  public void onGetDetailInfo(boolean paramBoolean, String paramString, Card paramCard)
  {
    if ((paramBoolean) && (paramCard != null) && (bftf.a(this.a.app.getCurrentAccountUin(), paramCard.uin))) {
      FriendProfileMoreInfoActivity.a(this.a, paramCard, true);
    }
  }
  
  public void onGetEducationList(boolean paramBoolean, long paramLong, ArrayList<aymx> paramArrayList)
  {
    if (QLog.isColorLevel()) {
      QLog.d("FriendProfileMoreInfoActivity", 2, "onGetEducationList, success:" + paramBoolean + ", uin=" + paramLong);
    }
    if (paramBoolean) {
      FriendProfileMoreInfoActivity.a(this.a, paramArrayList);
    }
  }
  
  public void onGetLocationDescription(boolean paramBoolean, String paramString, Card paramCard)
  {
    if ((paramBoolean) && (paramCard != null) && (bftf.a(this.a.app.getCurrentAccountUin(), paramCard.uin))) {
      FriendProfileMoreInfoActivity.a(this.a, paramCard, true);
    }
  }
  
  public void onSetDetailInfo(boolean paramBoolean, int paramInt, Card paramCard)
  {
    if (QLog.isColorLevel()) {
      QLog.d("FriendProfileMoreInfoActivity", 2, String.format("onSetDetailInfo success=%s resultCode=%s mDelayRemoveCardObserver=%s", new Object[] { Boolean.valueOf(paramBoolean), Integer.valueOf(paramInt), Boolean.valueOf(this.a.jdField_b_of_type_Boolean) }));
    }
    if (FriendProfileMoreInfoActivity.a(this.a))
    {
      FriendProfileMoreInfoActivity.a(this.a, paramBoolean, paramCard);
      return;
    }
    if (((paramBoolean) && (paramInt == 0)) || ((!paramBoolean) && (paramInt == 34)))
    {
      label86:
      if (this.a.jdField_b_of_type_Boolean)
      {
        this.a.removeObserver(this.a.jdField_a_of_type_ComTencentMobileqqAppCardObserver);
        this.a.jdField_b_of_type_Boolean = false;
      }
      if ((!this.a.jdField_a_of_type_Boolean) || (this.a.jdField_b_of_type_Bhht == null)) {
        break label756;
      }
      if (paramBoolean)
      {
        bcef.b(this.a.app, "dc00898", "", "", "0X8007EC3", "0X8007EC3", 0, 0, "", "", "", "");
        if (this.a.jdField_a_of_type_Adkj.jdField_b_of_type_Boolean)
        {
          paramCard = this.a.jdField_a_of_type_AndroidWidgetEditText.getText().toString();
          if ((!TextUtils.isEmpty(paramCard)) && (!TextUtils.isEmpty(paramCard.trim()))) {
            break label686;
          }
        }
        label216:
        if (this.a.jdField_c_of_type_Boolean) {
          bcef.b(this.a.app, "dc00898", "", "", "0X8007EC8", "0X8007EC8", 0, 0, "", "", "", "");
        }
        if (this.a.jdField_d_of_type_Boolean) {
          bcef.b(this.a.app, "dc00898", "", "", "0X8007EC9", "0X8007EC9", 0, 0, "", "", "", "");
        }
        if (this.a.e) {
          bcef.b(this.a.app, "dc00898", "", "", "0X8007ECA", "0X8007ECA", 0, 0, "", "", "", "");
        }
        if (this.a.jdField_b_of_type_Adkj.jdField_b_of_type_Boolean) {
          bcef.b(this.a.app, "dc00898", "", "", "0X8007ECB", "0X8007ECB", 0, 0, "", "", "", "");
        }
        if (this.a.jdField_c_of_type_Adkj.jdField_b_of_type_Boolean) {
          bcef.b(this.a.app, "dc00898", "", "", "0X8007ECC", "0X8007ECC", 0, 0, "", "", "", "");
        }
        if (this.a.f) {
          bcef.b(this.a.app, "dc00898", "", "", "0X8007ECD", "0X8007ECD", 0, 0, "", "", "", "");
        }
        if (this.a.g) {
          bcef.b(this.a.app, "dc00898", "", "", "0X8007ECE", "0X8007ECE", 0, 0, "", "", "", "");
        }
        if (this.a.jdField_d_of_type_Adkj.jdField_b_of_type_Boolean)
        {
          paramCard = this.a.jdField_d_of_type_AndroidWidgetEditText.getText().toString();
          Matcher localMatcher = SearchBaseActivity.a.matcher(paramCard);
          if ((TextUtils.isEmpty(paramCard)) || (localMatcher.matches())) {
            break label721;
          }
        }
      }
    }
    for (;;)
    {
      if (this.a.h) {
        bcef.b(this.a.app, "dc00898", "", "", "0X8007ED0", "0X8007ED0", 0, 0, "", "", "", "");
      }
      if (this.a.jdField_a_of_type_AndroidOsBundle == null) {
        this.a.jdField_a_of_type_AndroidOsBundle = new Bundle();
      }
      this.a.jdField_a_of_type_Boolean = false;
      this.a.jdField_b_of_type_Bhht.dismiss();
      if (this.a.isFinishing()) {
        break;
      }
      this.a.finish();
      return;
      if (paramInt == 40)
      {
        FriendProfileMoreInfoActivity.a(this.a, 2131718186, 1);
        break label86;
      }
      FriendProfileMoreInfoActivity.a(this.a, 2131694688, 1);
      break label86;
      label686:
      bcef.b(this.a.app, "dc00898", "", "", "0X8007EC7", "0X8007EC7", 0, 0, "", "", "", "");
      break label216;
      label721:
      bcef.b(this.a.app, "dc00898", "", "", "0X8007ECF", "0X8007ECF", 0, 0, "", "", "", "");
    }
    label756:
    FriendProfileMoreInfoActivity.a(this.a, paramCard, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     adjy
 * JD-Core Version:    0.7.0.1
 */