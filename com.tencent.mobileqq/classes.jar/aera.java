import android.os.Bundle;
import android.text.TextUtils;
import android.widget.EditText;
import com.tencent.mobileqq.activity.FriendProfileMoreInfoActivity;
import com.tencent.mobileqq.activity.contact.addcontact.SearchBaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.Card;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class aera
  extends anuw
{
  public aera(FriendProfileMoreInfoActivity paramFriendProfileMoreInfoActivity) {}
  
  protected void onCardDownload(boolean paramBoolean, Object paramObject)
  {
    if ((paramBoolean) && ((paramObject instanceof Card)) && (bhjx.a(this.a.app.getCurrentAccountUin(), ((Card)paramObject).uin)))
    {
      FriendProfileMoreInfoActivity.a(this.a, (Card)paramObject, true);
      if (!this.a.i)
      {
        paramObject = (aqmx)this.a.app.getManager(112);
        FriendProfileMoreInfoActivity.a(this.a, paramObject.a());
      }
    }
  }
  
  protected void onGetDetailInfo(boolean paramBoolean, String paramString, Card paramCard)
  {
    if ((paramBoolean) && (paramCard != null) && (bhjx.a(this.a.app.getCurrentAccountUin(), paramCard.uin))) {
      FriendProfileMoreInfoActivity.a(this.a, paramCard, true);
    }
  }
  
  protected void onGetEducationList(boolean paramBoolean, long paramLong, ArrayList<azyi> paramArrayList)
  {
    if (QLog.isColorLevel()) {
      QLog.d("FriendProfileMoreInfoActivity", 2, "onGetEducationList, success:" + paramBoolean + ", uin=" + paramLong);
    }
    if (paramBoolean) {
      FriendProfileMoreInfoActivity.a(this.a, paramArrayList);
    }
  }
  
  protected void onGetLocationDescription(boolean paramBoolean, String paramString, Card paramCard)
  {
    if ((paramBoolean) && (paramCard != null) && (bhjx.a(this.a.app.getCurrentAccountUin(), paramCard.uin))) {
      FriendProfileMoreInfoActivity.a(this.a, paramCard, true);
    }
  }
  
  protected void onSetDetailInfo(boolean paramBoolean, int paramInt, Card paramCard)
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
        this.a.removeObserver(this.a.jdField_a_of_type_Anuw);
        this.a.jdField_b_of_type_Boolean = false;
      }
      if ((!this.a.jdField_a_of_type_Boolean) || (this.a.jdField_b_of_type_Bjbs == null)) {
        break label756;
      }
      if (paramBoolean)
      {
        bdll.b(this.a.app, "dc00898", "", "", "0X8007EC3", "0X8007EC3", 0, 0, "", "", "", "");
        if (this.a.jdField_a_of_type_Aerl.jdField_b_of_type_Boolean)
        {
          paramCard = this.a.jdField_a_of_type_AndroidWidgetEditText.getText().toString();
          if ((!TextUtils.isEmpty(paramCard)) && (!TextUtils.isEmpty(paramCard.trim()))) {
            break label686;
          }
        }
        label216:
        if (this.a.jdField_c_of_type_Boolean) {
          bdll.b(this.a.app, "dc00898", "", "", "0X8007EC8", "0X8007EC8", 0, 0, "", "", "", "");
        }
        if (this.a.jdField_d_of_type_Boolean) {
          bdll.b(this.a.app, "dc00898", "", "", "0X8007EC9", "0X8007EC9", 0, 0, "", "", "", "");
        }
        if (this.a.e) {
          bdll.b(this.a.app, "dc00898", "", "", "0X8007ECA", "0X8007ECA", 0, 0, "", "", "", "");
        }
        if (this.a.jdField_b_of_type_Aerl.jdField_b_of_type_Boolean) {
          bdll.b(this.a.app, "dc00898", "", "", "0X8007ECB", "0X8007ECB", 0, 0, "", "", "", "");
        }
        if (this.a.jdField_c_of_type_Aerl.jdField_b_of_type_Boolean) {
          bdll.b(this.a.app, "dc00898", "", "", "0X8007ECC", "0X8007ECC", 0, 0, "", "", "", "");
        }
        if (this.a.f) {
          bdll.b(this.a.app, "dc00898", "", "", "0X8007ECD", "0X8007ECD", 0, 0, "", "", "", "");
        }
        if (this.a.g) {
          bdll.b(this.a.app, "dc00898", "", "", "0X8007ECE", "0X8007ECE", 0, 0, "", "", "", "");
        }
        if (this.a.jdField_d_of_type_Aerl.jdField_b_of_type_Boolean)
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
        bdll.b(this.a.app, "dc00898", "", "", "0X8007ED0", "0X8007ED0", 0, 0, "", "", "", "");
      }
      if (this.a.jdField_a_of_type_AndroidOsBundle == null) {
        this.a.jdField_a_of_type_AndroidOsBundle = new Bundle();
      }
      this.a.jdField_a_of_type_Boolean = false;
      this.a.jdField_b_of_type_Bjbs.dismiss();
      if (this.a.isFinishing()) {
        break;
      }
      this.a.finish();
      return;
      if (paramInt == 40)
      {
        FriendProfileMoreInfoActivity.a(this.a, 2131717945, 1);
        break label86;
      }
      FriendProfileMoreInfoActivity.a(this.a, 2131694572, 1);
      break label86;
      label686:
      bdll.b(this.a.app, "dc00898", "", "", "0X8007EC7", "0X8007EC7", 0, 0, "", "", "", "");
      break label216;
      label721:
      bdll.b(this.a.app, "dc00898", "", "", "0X8007ECF", "0X8007ECF", 0, 0, "", "", "", "");
    }
    label756:
    FriendProfileMoreInfoActivity.a(this.a, paramCard, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aera
 * JD-Core Version:    0.7.0.1
 */