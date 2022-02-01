import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.Window;
import android.view.WindowManager.LayoutParams;
import com.tencent.mobileqq.activity.AddFriendLogicActivity;
import com.tencent.mobileqq.activity.AddFriendLogicActivity.MyFriendListObserver.1;
import com.tencent.mobileqq.activity.AddFriendVerifyActivity;
import com.tencent.mobileqq.activity.ProfileActivity;
import com.tencent.mobileqq.activity.ProfileActivity.AllInOne;
import com.tencent.mobileqq.activity.contact.phonecontact.PhoneContactManagerImp;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qidian.QidianProfileCardActivity;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import mqq.util.WeakReference;

public class adso
  extends anyu
{
  final WeakReference<AddFriendLogicActivity> a;
  
  public adso(AddFriendLogicActivity paramAddFriendLogicActivity1, AddFriendLogicActivity paramAddFriendLogicActivity2)
  {
    this.jdField_a_of_type_MqqUtilWeakReference = new WeakReference(paramAddFriendLogicActivity2);
  }
  
  protected void onQueryUinSafetyFlag(boolean paramBoolean, long paramLong, int paramInt1, int paramInt2)
  {
    Object localObject = (AddFriendLogicActivity)this.jdField_a_of_type_MqqUtilWeakReference.get();
    if ((localObject == null) || (!((AddFriendLogicActivity)localObject).isResume())) {}
    do
    {
      return;
      if (QLog.isColorLevel()) {
        QLog.i("addFriendTag", 2, String.format("onQueryUinSafetyFlag [uin:%s, isSuc:%s, type:%s, serviceType:%s, status:%s]", new Object[] { bhjx.b(String.valueOf(paramLong)), Boolean.valueOf(paramBoolean), Integer.valueOf(AddFriendLogicActivity.c(this.jdField_a_of_type_ComTencentMobileqqActivityAddFriendLogicActivity)), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) }));
      }
    } while ((AddFriendLogicActivity.c(this.jdField_a_of_type_ComTencentMobileqqActivityAddFriendLogicActivity) != 1) || (paramInt1 != 147) || (!String.valueOf(paramLong).equals(AddFriendLogicActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityAddFriendLogicActivity))));
    if ((!paramBoolean) || (paramInt2 == 0))
    {
      AddFriendLogicActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityAddFriendLogicActivity);
      return;
    }
    AddFriendLogicActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityAddFriendLogicActivity, false);
    AddFriendLogicActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityAddFriendLogicActivity, paramInt2);
    bhkf.a().a(this.jdField_a_of_type_ComTencentMobileqqActivityAddFriendLogicActivity.app, "SecWarningCfg");
    try
    {
      AddFriendLogicActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityAddFriendLogicActivity, bhlq.a(this.jdField_a_of_type_ComTencentMobileqqActivityAddFriendLogicActivity, 230, "", "", this.jdField_a_of_type_ComTencentMobileqqActivityAddFriendLogicActivity.jdField_a_of_type_AndroidContentDialogInterface$OnClickListener, this.jdField_a_of_type_ComTencentMobileqqActivityAddFriendLogicActivity.jdField_b_of_type_AndroidContentDialogInterface$OnClickListener));
      AddFriendLogicActivity.c(this.jdField_a_of_type_ComTencentMobileqqActivityAddFriendLogicActivity);
      localObject = AddFriendLogicActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityAddFriendLogicActivity).getWindow();
      if (localObject != null)
      {
        WindowManager.LayoutParams localLayoutParams = ((Window)localObject).getAttributes();
        if ((QLog.isColorLevel()) && (localLayoutParams != null)) {
          QLog.i("addFriendTag", 2, String.format("onQueryUinSafetyFlag [%s, %s, %s]", new Object[] { Float.valueOf(localLayoutParams.dimAmount), Integer.valueOf(localLayoutParams.flags), Integer.valueOf(localLayoutParams.flags & 0x2) }));
        }
        ((Window)localObject).setDimAmount(0.5F);
        ((Window)localObject).addFlags(2);
      }
      AddFriendLogicActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityAddFriendLogicActivity).setOnDismissListener(this.jdField_a_of_type_ComTencentMobileqqActivityAddFriendLogicActivity.jdField_a_of_type_AndroidContentDialogInterface$OnDismissListener);
      AddFriendLogicActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityAddFriendLogicActivity).show();
    }
    catch (Exception localException)
    {
      for (;;)
      {
        localException.printStackTrace();
      }
    }
    bdll.b(this.jdField_a_of_type_ComTencentMobileqqActivityAddFriendLogicActivity.app, "P_CliOper", "Safe_AntiFraud", this.jdField_a_of_type_ComTencentMobileqqActivityAddFriendLogicActivity.app.getCurrentAccountUin(), "AlertDialog", "Display", 0, AddFriendLogicActivity.d(this.jdField_a_of_type_ComTencentMobileqqActivityAddFriendLogicActivity), "", "", "", "");
  }
  
  protected void onUpdateAddFriend(boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, String paramString, Bundle paramBundle)
  {
    if ((AddFriendLogicActivity.b(this.jdField_a_of_type_ComTencentMobileqqActivityAddFriendLogicActivity) == 3024) && (AddFriendLogicActivity.e(this.jdField_a_of_type_ComTencentMobileqqActivityAddFriendLogicActivity) == 0))
    {
      paramString = this.jdField_a_of_type_ComTencentMobileqqActivityAddFriendLogicActivity.app.getApplication();
      if (!paramBoolean1) {
        break label70;
      }
    }
    label70:
    for (int i = 2131717892;; i = 2131717456)
    {
      QQToast.a(paramString, i, 0).b(this.jdField_a_of_type_ComTencentMobileqqActivityAddFriendLogicActivity.getTitleBarHeight());
      this.jdField_a_of_type_ComTencentMobileqqActivityAddFriendLogicActivity.finish();
      return;
    }
  }
  
  protected void onUpdateAddFriendSetting(boolean paramBoolean, Bundle paramBundle)
  {
    Object localObject = paramBundle.getString("uin");
    if (!AddFriendLogicActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityAddFriendLogicActivity).equals(localObject)) {}
    int i;
    do
    {
      return;
      i = paramBundle.getInt("random_key");
    } while ((i != 0) && (i != AddFriendLogicActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityAddFriendLogicActivity)));
    if (QLog.isColorLevel()) {
      QLog.i("addFriendTag", 2, String.format("onUpdateAddFriendSetting [uin:%s, key:%s, isSuc:%s]", new Object[] { bhjx.b((String)localObject), Integer.valueOf(i), Boolean.valueOf(paramBoolean) }));
    }
    AddFriendLogicActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityAddFriendLogicActivity, false);
    if (paramBoolean)
    {
      i = paramBundle.getInt("friend_setting");
      ArrayList localArrayList = paramBundle.getStringArrayList("user_question");
      Boolean localBoolean = Boolean.valueOf(paramBundle.getBoolean("contact_bothway"));
      long l = paramBundle.getLong("query_friend_uin");
      try
      {
        paramBundle = Long.toString(l);
        if ((localBoolean.booleanValue()) && (i != 0))
        {
          if (AddFriendLogicActivity.b(this.jdField_a_of_type_ComTencentMobileqqActivityAddFriendLogicActivity) == 3006) {
            this.jdField_a_of_type_ComTencentMobileqqActivityAddFriendLogicActivity.getIntent().putExtra("sub_source_id", 2);
          }
          this.jdField_a_of_type_ComTencentMobileqqActivityAddFriendLogicActivity.a(i, localBoolean.booleanValue(), localArrayList, AddFriendVerifyActivity.class, AddFriendLogicActivity.b(this.jdField_a_of_type_ComTencentMobileqqActivityAddFriendLogicActivity));
          return;
        }
      }
      catch (Exception paramBundle)
      {
        for (;;)
        {
          paramBundle = null;
        }
        switch (i)
        {
        default: 
          AddFriendLogicActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityAddFriendLogicActivity, -1, anzj.a(2131698769));
          QQToast.a(this.jdField_a_of_type_ComTencentMobileqqActivityAddFriendLogicActivity.app.getApplication(), 2131717454, 0).b(this.jdField_a_of_type_ComTencentMobileqqActivityAddFriendLogicActivity.getTitleBarHeight());
          this.jdField_a_of_type_ComTencentMobileqqActivityAddFriendLogicActivity.finish();
          return;
        }
      }
      this.jdField_a_of_type_ComTencentMobileqqActivityAddFriendLogicActivity.a(i, localBoolean.booleanValue(), localArrayList, AddFriendVerifyActivity.class, AddFriendLogicActivity.b(this.jdField_a_of_type_ComTencentMobileqqActivityAddFriendLogicActivity));
      return;
      AddFriendLogicActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityAddFriendLogicActivity, -1, this.jdField_a_of_type_ComTencentMobileqqActivityAddFriendLogicActivity.getString(2131717416));
      AddFriendLogicActivity.b(this.jdField_a_of_type_ComTencentMobileqqActivityAddFriendLogicActivity);
      return;
      if (AddFriendLogicActivity.c(this.jdField_a_of_type_ComTencentMobileqqActivityAddFriendLogicActivity) == 1) {
        ThreadManager.post(new AddFriendLogicActivity.MyFriendListObserver.1(this, (String)localObject), 8, null, true);
      }
      while ((this.jdField_a_of_type_ComTencentMobileqqActivityAddFriendLogicActivity.getIntent().getBooleanExtra("webim_qd_ext", false)) && (!TextUtils.isEmpty(paramBundle)))
      {
        paramBundle = new ProfileActivity.AllInOne(paramBundle, 1);
        localObject = new Intent(this.jdField_a_of_type_ComTencentMobileqqActivityAddFriendLogicActivity, QidianProfileCardActivity.class);
        ((Intent)localObject).putExtra("AllInOne", paramBundle);
        ((Intent)localObject).addFlags(536870912);
        this.jdField_a_of_type_ComTencentMobileqqActivityAddFriendLogicActivity.startActivity((Intent)localObject);
        this.jdField_a_of_type_ComTencentMobileqqActivityAddFriendLogicActivity.setResult(-1);
        this.jdField_a_of_type_ComTencentMobileqqActivityAddFriendLogicActivity.finish();
        return;
        if (AddFriendLogicActivity.c(this.jdField_a_of_type_ComTencentMobileqqActivityAddFriendLogicActivity) == 2) {
          ((PhoneContactManagerImp)this.jdField_a_of_type_ComTencentMobileqqActivityAddFriendLogicActivity.app.getManager(11)).b();
        }
      }
      if ((!TextUtils.isEmpty(paramBundle)) && (!"0".equals(paramBundle)))
      {
        paramBundle = new ProfileActivity.AllInOne(paramBundle, 1);
        paramBundle.h = 115;
        localObject = ProfileActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityAddFriendLogicActivity, paramBundle);
        ((Intent)localObject).putExtra("AllInOne", paramBundle);
        ((Intent)localObject).putExtra("src_name", AddFriendLogicActivity.b(this.jdField_a_of_type_ComTencentMobileqqActivityAddFriendLogicActivity));
        ((Intent)localObject).putExtra("source_id", this.jdField_a_of_type_ComTencentMobileqqActivityAddFriendLogicActivity.getIntent().getIntExtra("source_id", 3999));
        ((Intent)localObject).putExtra("extra", this.jdField_a_of_type_ComTencentMobileqqActivityAddFriendLogicActivity.getIntent().getStringExtra("extra"));
        ((Intent)localObject).addFlags(536870912);
        ((Intent)localObject).addFlags(268435456);
        AddFriendLogicActivity.jdField_b_of_type_Boolean = true;
        this.jdField_a_of_type_ComTencentMobileqqActivityAddFriendLogicActivity.startActivity((Intent)localObject);
        this.jdField_a_of_type_ComTencentMobileqqActivityAddFriendLogicActivity.setResult(-1);
        this.jdField_a_of_type_ComTencentMobileqqActivityAddFriendLogicActivity.finish();
        return;
      }
      AddFriendLogicActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityAddFriendLogicActivity, -1, anzj.a(2131698768));
      QQToast.a(this.jdField_a_of_type_ComTencentMobileqqActivityAddFriendLogicActivity.app.getApplication(), anzj.a(2131698765), 0).b(this.jdField_a_of_type_ComTencentMobileqqActivityAddFriendLogicActivity.getTitleBarHeight());
      this.jdField_a_of_type_ComTencentMobileqqActivityAddFriendLogicActivity.setResult(-1);
      this.jdField_a_of_type_ComTencentMobileqqActivityAddFriendLogicActivity.finish();
      return;
    }
    AddFriendLogicActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityAddFriendLogicActivity, -1, anzj.a(2131698772));
    QQToast.a(this.jdField_a_of_type_ComTencentMobileqqActivityAddFriendLogicActivity.app.getApplication(), 2131717454, 0).b(this.jdField_a_of_type_ComTencentMobileqqActivityAddFriendLogicActivity.getTitleBarHeight());
    this.jdField_a_of_type_ComTencentMobileqqActivityAddFriendLogicActivity.finish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     adso
 * JD-Core Version:    0.7.0.1
 */