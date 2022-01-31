import NS_MOBILE_MAIN_PAGE.mobile_sub_get_photo_wall_rsp;
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

public class acxj
  extends allb
{
  public acxj(FriendProfileMoreInfoActivity paramFriendProfileMoreInfoActivity) {}
  
  protected void onCardDownload(boolean paramBoolean, Object paramObject)
  {
    if ((paramBoolean) && ((paramObject instanceof Card)) && (bdal.a(this.a.app.getCurrentAccountUin(), ((Card)paramObject).uin)))
    {
      FriendProfileMoreInfoActivity.a(this.a, (Card)paramObject, true);
      if (!this.a.i)
      {
        paramObject = (anuj)this.a.app.getManager(112);
        FriendProfileMoreInfoActivity.a(this.a, paramObject.a());
      }
    }
  }
  
  protected void onGetDetailInfo(boolean paramBoolean, String paramString, Card paramCard)
  {
    if ((paramBoolean) && (paramCard != null) && (bdal.a(this.a.app.getCurrentAccountUin(), paramCard.uin))) {
      FriendProfileMoreInfoActivity.a(this.a, paramCard, true);
    }
  }
  
  protected void onGetEducationList(boolean paramBoolean, long paramLong, ArrayList<awnc> paramArrayList)
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
    if ((paramBoolean) && (paramCard != null) && (bdal.a(this.a.app.getCurrentAccountUin(), paramCard.uin))) {
      FriendProfileMoreInfoActivity.a(this.a, paramCard, true);
    }
  }
  
  protected void onGetQZonePhotoWall(boolean paramBoolean, String paramString1, mobile_sub_get_photo_wall_rsp parammobile_sub_get_photo_wall_rsp, String paramString2)
  {
    if ((paramBoolean) && (parammobile_sub_get_photo_wall_rsp != null))
    {
      paramString1 = new ArrayList();
      this.a.a(parammobile_sub_get_photo_wall_rsp.total_pic, parammobile_sub_get_photo_wall_rsp.iHasMore, parammobile_sub_get_photo_wall_rsp.attachInfo, parammobile_sub_get_photo_wall_rsp.vecUrls, paramString1);
      parammobile_sub_get_photo_wall_rsp = this.a.jdField_a_of_type_Bhow.obtainMessage(1002);
      parammobile_sub_get_photo_wall_rsp.obj = paramString1;
      this.a.jdField_a_of_type_Bhow.sendMessage(parammobile_sub_get_photo_wall_rsp);
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
        this.a.removeObserver(this.a.jdField_a_of_type_Allb);
        this.a.jdField_b_of_type_Boolean = false;
      }
      if ((!this.a.jdField_a_of_type_Boolean) || (this.a.jdField_b_of_type_Bepp == null)) {
        break label762;
      }
      if (paramBoolean)
      {
        azmj.b(this.a.app, "dc00898", "", "", "0X8007EC3", "0X8007EC3", 0, 0, "", "", "", "");
        String str;
        if (this.a.jdField_a_of_type_Acxv.jdField_b_of_type_Boolean)
        {
          str = this.a.jdField_a_of_type_AndroidWidgetEditText.getText().toString();
          if ((!TextUtils.isEmpty(str)) && (!TextUtils.isEmpty(str.trim()))) {
            break label692;
          }
        }
        label219:
        if (this.a.jdField_c_of_type_Boolean) {
          azmj.b(this.a.app, "dc00898", "", "", "0X8007EC8", "0X8007EC8", 0, 0, "", "", "", "");
        }
        if (this.a.jdField_d_of_type_Boolean) {
          azmj.b(this.a.app, "dc00898", "", "", "0X8007EC9", "0X8007EC9", 0, 0, "", "", "", "");
        }
        if (this.a.e) {
          azmj.b(this.a.app, "dc00898", "", "", "0X8007ECA", "0X8007ECA", 0, 0, "", "", "", "");
        }
        if (this.a.jdField_b_of_type_Acxv.jdField_b_of_type_Boolean) {
          azmj.b(this.a.app, "dc00898", "", "", "0X8007ECB", "0X8007ECB", 0, 0, "", "", "", "");
        }
        if (this.a.jdField_c_of_type_Acxv.jdField_b_of_type_Boolean) {
          azmj.b(this.a.app, "dc00898", "", "", "0X8007ECC", "0X8007ECC", 0, 0, "", "", "", "");
        }
        if (this.a.f) {
          azmj.b(this.a.app, "dc00898", "", "", "0X8007ECD", "0X8007ECD", 0, 0, "", "", "", "");
        }
        if (this.a.g) {
          azmj.b(this.a.app, "dc00898", "", "", "0X8007ECE", "0X8007ECE", 0, 0, "", "", "", "");
        }
        if (this.a.jdField_d_of_type_Acxv.jdField_b_of_type_Boolean)
        {
          str = this.a.jdField_d_of_type_AndroidWidgetEditText.getText().toString();
          Matcher localMatcher = SearchBaseActivity.a.matcher(str);
          if ((TextUtils.isEmpty(str)) || (localMatcher.matches())) {
            break label727;
          }
        }
      }
    }
    for (;;)
    {
      if (this.a.h) {
        azmj.b(this.a.app, "dc00898", "", "", "0X8007ED0", "0X8007ED0", 0, 0, "", "", "", "");
      }
      if (this.a.jdField_a_of_type_AndroidOsBundle == null) {
        this.a.jdField_a_of_type_AndroidOsBundle = new Bundle();
      }
      this.a.jdField_a_of_type_AndroidOsBundle.putShort("key_personality_label_switch", paramCard.switch_disable_personality_label);
      this.a.jdField_a_of_type_Boolean = false;
      this.a.jdField_b_of_type_Bepp.dismiss();
      if (this.a.isFinishing()) {
        break;
      }
      this.a.finish();
      return;
      this.a.a(2131695605, 1);
      break label86;
      label692:
      azmj.b(this.a.app, "dc00898", "", "", "0X8007EC7", "0X8007EC7", 0, 0, "", "", "", "");
      break label219;
      label727:
      azmj.b(this.a.app, "dc00898", "", "", "0X8007ECF", "0X8007ECF", 0, 0, "", "", "", "");
    }
    label762:
    FriendProfileMoreInfoActivity.a(this.a, paramCard, true);
  }
  
  protected void onSetNick(boolean paramBoolean, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("FriendProfileMoreInfoActivity", 2, "onSetNick, success:" + paramBoolean + ", nick=" + paramString);
    }
    if ((paramBoolean) && (!TextUtils.isEmpty(paramString)) && (this.a.jdField_a_of_type_AndroidWidgetEditText != null) && (!paramString.equals(this.a.jdField_a_of_type_AndroidWidgetEditText.getText().toString())))
    {
      this.a.a(paramString);
      this.a.jdField_a_of_type_Acxv.jdField_b_of_type_Boolean = true;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     acxj
 * JD-Core Version:    0.7.0.1
 */