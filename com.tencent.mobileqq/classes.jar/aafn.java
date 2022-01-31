import android.text.TextUtils;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.activity.AccountManageActivity;
import com.tencent.mobileqq.activity.AccountManageActivity.24.1;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.SubAccountInfo;
import com.tencent.mobileqq.widget.FormSimpleItem;
import com.tencent.qphone.base.remote.SimpleAccount;
import java.util.List;

public class aafn
  extends ajxl
{
  public aafn(AccountManageActivity paramAccountManageActivity) {}
  
  void a(String paramString, int paramInt)
  {
    this.a.runOnUiThread(new AccountManageActivity.24.1(this, paramString, paramInt));
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
    Object localObject2 = (ayav)this.a.app.getManager(61);
    Object localObject1 = "";
    int i = ((ayav)localObject2).a();
    if (i == 0)
    {
      label43:
      AccountManageActivity.a(this.a).setRightText((CharSequence)localObject1);
      if (AppSetting.d) {
        AccountManageActivity.a(this.a).setContentDescription("关联QQ号" + (String)localObject1);
      }
      if (this.a.jdField_a_of_type_AndroidWidgetLinearLayout == null) {
        break label432;
      }
      i = this.a.jdField_a_of_type_AndroidWidgetLinearLayout.getChildCount();
      label112:
      if (j >= this.a.jdField_a_of_type_JavaUtilList.size()) {
        break label435;
      }
      if ((i > j) && (this.a.jdField_a_of_type_JavaUtilList.get(j) != null) && (paramString.equals(((SimpleAccount)this.a.jdField_a_of_type_JavaUtilList.get(j)).getUin())))
      {
        localObject1 = (TextView)this.a.jdField_a_of_type_AndroidWidgetLinearLayout.getChildAt(j).findViewById(2131370647);
        localObject2 = (TextView)this.a.jdField_a_of_type_AndroidWidgetLinearLayout.getChildAt(j).findViewById(2131361823);
        ((TextView)localObject1).setText(bbcl.h(this.a.app, paramString));
        ((TextView)localObject2).setText(paramString);
        a(paramString, j);
      }
    }
    else if (i == 1)
    {
      SubAccountInfo localSubAccountInfo = ((ayav)localObject2).a("sub.uin.default");
      if (localSubAccountInfo == null) {
        break label437;
      }
      localObject2 = bbcl.c(this.a.app, localSubAccountInfo.subuin, false);
      localObject1 = localObject2;
      if (!TextUtils.isEmpty((CharSequence)localObject2)) {
        if (!TextUtils.isEmpty(localSubAccountInfo.subname))
        {
          localObject1 = localObject2;
          if (((String)localObject2).equals(localSubAccountInfo.subname)) {}
        }
        else
        {
          localSubAccountInfo.subname = ((String)localObject2);
          AccountManageActivity.a(this.a).setRightText((CharSequence)localObject2);
          localObject1 = localObject2;
          if (AppSetting.d) {
            AccountManageActivity.a(this.a).setContentDescription("关联QQ号" + (String)localObject2);
          }
        }
      }
    }
    label432:
    label435:
    label437:
    for (localObject1 = localObject2;; localObject1 = "")
    {
      break label43;
      localObject1 = i + ajyc.a(2131699740);
      break label43;
      j += 1;
      break label112;
      i = 0;
      break label112;
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     aafn
 * JD-Core Version:    0.7.0.1
 */