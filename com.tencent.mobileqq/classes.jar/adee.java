import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.activity.AccountManageActivity;
import com.tencent.mobileqq.activity.AccountManageActivity.26.1;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.data.SubAccountInfo;
import com.tencent.mobileqq.utils.ContactUtils;
import com.tencent.mobileqq.widget.FormSimpleItem;
import com.tencent.qphone.base.remote.SimpleAccount;
import java.util.ArrayList;
import java.util.List;

public class adee
  extends anvi
{
  public adee(AccountManageActivity paramAccountManageActivity) {}
  
  void a(String paramString, int paramInt)
  {
    this.a.runOnUiThread(new AccountManageActivity.26.1(this, paramString, paramInt));
  }
  
  protected void onUpdateCustomHead(boolean paramBoolean, String paramString)
  {
    int j = 0;
    if ((!paramBoolean) || (paramString == null)) {}
    for (;;)
    {
      return;
      int i;
      if (this.a.jdField_a_of_type_AndroidWidgetLinearLayout != null) {
        i = this.a.jdField_a_of_type_AndroidWidgetLinearLayout.getChildCount();
      }
      while (j < this.a.jdField_a_of_type_JavaUtilList.size())
      {
        if ((i > j) && (this.a.jdField_a_of_type_JavaUtilList.get(j) != null) && (paramString.equals(((SimpleAccount)this.a.jdField_a_of_type_JavaUtilList.get(j)).getUin())))
        {
          a(paramString, j);
          return;
        }
        j += 1;
        continue;
        i = 0;
      }
    }
  }
  
  protected void onUpdateFriendInfo(String paramString, boolean paramBoolean)
  {
    int j = 0;
    if ((!paramBoolean) || (paramString == null)) {
      return;
    }
    Object localObject3 = (bdxs)this.a.app.getManager(QQManagerFactory.SUB_ACCOUNT_MANAGER);
    Object localObject1 = "";
    int i = ((bdxs)localObject3).a();
    label68:
    label125:
    Object localObject2;
    if (i == 0)
    {
      AccountManageActivity.a(this.a).setVisibility(8);
      AccountManageActivity.b(this.a).setVisibility(8);
      if (AppSetting.c) {
        AccountManageActivity.a(this.a).setContentDescription("关联QQ号" + (String)localObject1);
      }
      if (this.a.jdField_a_of_type_AndroidWidgetLinearLayout == null) {
        break label567;
      }
      i = this.a.jdField_a_of_type_AndroidWidgetLinearLayout.getChildCount();
      if (j >= this.a.jdField_a_of_type_JavaUtilList.size()) {
        break label570;
      }
      if ((i > j) && (this.a.jdField_a_of_type_JavaUtilList.get(j) != null) && (paramString.equals(((SimpleAccount)this.a.jdField_a_of_type_JavaUtilList.get(j)).getUin())))
      {
        localObject1 = (TextView)this.a.jdField_a_of_type_AndroidWidgetLinearLayout.getChildAt(j).findViewById(2131371803);
        localObject2 = (TextView)this.a.jdField_a_of_type_AndroidWidgetLinearLayout.getChildAt(j).findViewById(2131361858);
        ((TextView)localObject1).setText(ContactUtils.getAccountNickName(this.a.app, paramString));
        ((TextView)localObject2).setText(paramString);
        a(paramString, j);
      }
    }
    else if (i == 1)
    {
      localObject3 = ((bdxs)localObject3).a("sub.uin.default");
      if (localObject3 == null) {
        break label572;
      }
      localObject2 = ContactUtils.getBuddyNickName(this.a.app, ((SubAccountInfo)localObject3).subuin, false);
      localObject1 = localObject2;
      if (!TextUtils.isEmpty((CharSequence)localObject2)) {
        if (!TextUtils.isEmpty(((SubAccountInfo)localObject3).subname))
        {
          localObject1 = localObject2;
          if (((String)localObject2).equals(((SubAccountInfo)localObject3).subname)) {}
        }
        else
        {
          ((SubAccountInfo)localObject3).subname = ((String)localObject2);
          this.a.a(AccountManageActivity.b(this.a), ((SubAccountInfo)localObject3).subuin);
          AccountManageActivity.b(this.a).setVisibility(0);
          AccountManageActivity.a(this.a).setVisibility(8);
          localObject1 = localObject2;
          if (AppSetting.c) {
            AccountManageActivity.a(this.a).setContentDescription("关联QQ号" + (String)localObject2);
          }
        }
      }
    }
    label567:
    label570:
    label572:
    for (localObject1 = localObject2;; localObject1 = "")
    {
      break label68;
      localObject2 = i + anvx.a(2131699251);
      localObject3 = ((bdxs)localObject3).a();
      localObject1 = localObject2;
      if (((ArrayList)localObject3).size() != 2) {
        break label68;
      }
      this.a.a(AccountManageActivity.b(this.a), (String)((ArrayList)localObject3).get(0));
      AccountManageActivity.b(this.a).setVisibility(0);
      this.a.a(AccountManageActivity.b(this.a), (String)((ArrayList)localObject3).get(1));
      AccountManageActivity.a(this.a).setVisibility(0);
      localObject1 = localObject2;
      break label68;
      j += 1;
      break label125;
      i = 0;
      break label125;
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     adee
 * JD-Core Version:    0.7.0.1
 */