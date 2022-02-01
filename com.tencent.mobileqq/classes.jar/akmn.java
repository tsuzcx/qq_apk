import android.content.Intent;
import android.os.Build;
import android.os.Build.VERSION;
import android.view.View;
import com.tencent.mobileqq.activity.ProfileActivity;
import com.tencent.mobileqq.activity.ProfileActivity.AllInOne;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.pendant.AvatarPendantActivity;
import com.tencent.mobileqq.activity.pendant.AvatarPendantActivity.14.2;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.avatar.dynamicavatar.DynamicAvatarRecordActivity;
import com.tencent.mobileqq.shortvideo.VideoEnvironment;
import com.tencent.mobileqq.utils.AudioHelper;
import com.tencent.mobileqq.widget.QQToast;

public class akmn
  implements bliz
{
  public akmn(AvatarPendantActivity paramAvatarPendantActivity, boolean paramBoolean, blir paramblir) {}
  
  public void OnClick(View paramView, int paramInt)
  {
    switch (paramInt)
    {
    }
    for (;;)
    {
      try
      {
        this.jdField_a_of_type_Blir.dismiss();
        return;
      }
      catch (Exception paramView)
      {
        boolean bool;
        int i;
        int j;
        paramView.printStackTrace();
      }
      bool = VideoEnvironment.e();
      if ((AudioHelper.b()) || (Build.MODEL.contains("Redmi 3")) || (Build.MODEL.contains("M3S")))
      {
        QQToast.a(this.jdField_a_of_type_ComTencentMobileqqActivityPendantAvatarPendantActivity, anzj.a(2131699785), 0).a();
      }
      else if (bool)
      {
        if (Build.VERSION.SDK_INT >= 23)
        {
          if (this.jdField_a_of_type_ComTencentMobileqqActivityPendantAvatarPendantActivity.checkSelfPermission("android.permission.CAMERA") != 0)
          {
            paramInt = 1;
            if (this.jdField_a_of_type_ComTencentMobileqqActivityPendantAvatarPendantActivity.checkSelfPermission("android.permission.RECORD_AUDIO") != 0)
            {
              i = 1;
              if (this.jdField_a_of_type_ComTencentMobileqqActivityPendantAvatarPendantActivity.checkSelfPermission("android.permission.WRITE_EXTERNAL_STORAGE") == 0) {
                continue;
              }
              j = 1;
              if ((paramInt == 0) && (i == 0) && (j == 0)) {
                continue;
              }
              this.jdField_a_of_type_ComTencentMobileqqActivityPendantAvatarPendantActivity.requestPermissions(new akmo(this), 1, new String[] { "android.permission.CAMERA", "android.permission.RECORD_AUDIO", "android.permission.WRITE_EXTERNAL_STORAGE" });
            }
          }
          else
          {
            paramInt = 0;
            continue;
          }
          i = 0;
          continue;
          j = 0;
          continue;
          DynamicAvatarRecordActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityPendantAvatarPendantActivity, 1, 1);
          bdll.b(this.jdField_a_of_type_ComTencentMobileqqActivityPendantAvatarPendantActivity.app, "dc00898", "", "", "0X8007100", "0X8007100", 0, 0, "", "", "", "");
        }
        else
        {
          DynamicAvatarRecordActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityPendantAvatarPendantActivity, 1, 1);
          bdll.b(this.jdField_a_of_type_ComTencentMobileqqActivityPendantAvatarPendantActivity.app, "dc00898", "", "", "0X8007100", "0X8007100", 0, 0, "", "", "", "");
        }
      }
      else
      {
        if (!this.jdField_a_of_type_ComTencentMobileqqActivityPendantAvatarPendantActivity.e)
        {
          ThreadManager.postImmediately(new AvatarPendantActivity.14.2(this), null, true);
          this.jdField_a_of_type_ComTencentMobileqqActivityPendantAvatarPendantActivity.e = true;
        }
        QQToast.a(this.jdField_a_of_type_ComTencentMobileqqActivityPendantAvatarPendantActivity, anzj.a(2131699789), 0).a();
        continue;
        this.jdField_a_of_type_ComTencentMobileqqActivityPendantAvatarPendantActivity.g();
        AvatarPendantActivity.b(this.jdField_a_of_type_ComTencentMobileqqActivityPendantAvatarPendantActivity);
        continue;
        this.jdField_a_of_type_ComTencentMobileqqActivityPendantAvatarPendantActivity.g();
        if (Build.VERSION.SDK_INT >= 23)
        {
          if (this.jdField_a_of_type_ComTencentMobileqqActivityPendantAvatarPendantActivity.checkSelfPermission("android.permission.CAMERA") != 0)
          {
            paramInt = 1;
            if (this.jdField_a_of_type_ComTencentMobileqqActivityPendantAvatarPendantActivity.checkSelfPermission("android.permission.WRITE_EXTERNAL_STORAGE") != 0)
            {
              i = 1;
              if ((paramInt == 0) && (i == 0)) {
                continue;
              }
              this.jdField_a_of_type_ComTencentMobileqqActivityPendantAvatarPendantActivity.requestPermissions(new akmp(this), 2, new String[] { "android.permission.CAMERA", "android.permission.WRITE_EXTERNAL_STORAGE" });
            }
          }
          else
          {
            paramInt = 0;
            continue;
          }
          i = 0;
          continue;
          this.jdField_a_of_type_ComTencentMobileqqActivityPendantAvatarPendantActivity.jdField_a_of_type_AndroidNetUri = ProfileActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityPendantAvatarPendantActivity, 5);
          bdll.b(this.jdField_a_of_type_ComTencentMobileqqActivityPendantAvatarPendantActivity.app, "CliOper", "", "", "0X8004176", "0X8004176", this.jdField_a_of_type_ComTencentMobileqqActivityPendantAvatarPendantActivity.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.h, 0, "", "", "", "");
        }
        else
        {
          this.jdField_a_of_type_ComTencentMobileqqActivityPendantAvatarPendantActivity.jdField_a_of_type_AndroidNetUri = ProfileActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityPendantAvatarPendantActivity, 5);
          bdll.b(this.jdField_a_of_type_ComTencentMobileqqActivityPendantAvatarPendantActivity.app, "CliOper", "", "", "0X8004176", "0X8004176", this.jdField_a_of_type_ComTencentMobileqqActivityPendantAvatarPendantActivity.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.h, 0, "", "", "", "");
          continue;
          if (this.jdField_a_of_type_Boolean)
          {
            paramView = new Intent(this.jdField_a_of_type_ComTencentMobileqqActivityPendantAvatarPendantActivity, QQBrowserActivity.class);
            paramView.putExtra("url", "https://ti.qq.com/avatarlist/public/index.html?_wv=3&_wwv=4");
            this.jdField_a_of_type_ComTencentMobileqqActivityPendantAvatarPendantActivity.startActivity(paramView);
            bdll.b(this.jdField_a_of_type_ComTencentMobileqqActivityPendantAvatarPendantActivity.app, "dc00898", "", "", "0X8007C10", "0X8007C10", 0, 0, "", "", "", "");
          }
          else
          {
            bhhz.a(this.jdField_a_of_type_ComTencentMobileqqActivityPendantAvatarPendantActivity.app, this.jdField_a_of_type_ComTencentMobileqqActivityPendantAvatarPendantActivity, this.jdField_a_of_type_ComTencentMobileqqActivityPendantAvatarPendantActivity.jdField_a_of_type_ComTencentMobileqqAvatarDynamicavatarDynamicAvatarView, this.jdField_a_of_type_ComTencentMobileqqActivityPendantAvatarPendantActivity.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.a, 0, 0);
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     akmn
 * JD-Core Version:    0.7.0.1
 */