import android.content.Intent;
import android.os.Build;
import android.os.Build.VERSION;
import android.view.View;
import com.tencent.mobileqq.activity.ProfileActivity;
import com.tencent.mobileqq.activity.ProfileActivity.AllInOne;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.pendant.AvatarPendantActivity;
import com.tencent.mobileqq.activity.pendant.AvatarPendantActivity.13.2;
import com.tencent.mobileqq.activity.photo.PhotoUtils;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.avatar.dynamicavatar.DynamicAvatarRecordActivity;
import com.tencent.mobileqq.shortvideo.VideoEnvironment;
import com.tencent.mobileqq.utils.AudioHelper;
import com.tencent.mobileqq.widget.QQToast;

public class aift
  implements bhqd
{
  public aift(AvatarPendantActivity paramAvatarPendantActivity, boolean paramBoolean, bhpy parambhpy) {}
  
  public void OnClick(View paramView, int paramInt)
  {
    switch (paramInt)
    {
    }
    for (;;)
    {
      try
      {
        this.jdField_a_of_type_Bhpy.dismiss();
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
        QQToast.a(this.jdField_a_of_type_ComTencentMobileqqActivityPendantAvatarPendantActivity, alpo.a(2131701241), 0).a();
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
              this.jdField_a_of_type_ComTencentMobileqqActivityPendantAvatarPendantActivity.requestPermissions(new aifu(this), 1, new String[] { "android.permission.CAMERA", "android.permission.RECORD_AUDIO", "android.permission.WRITE_EXTERNAL_STORAGE" });
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
          azmj.b(this.jdField_a_of_type_ComTencentMobileqqActivityPendantAvatarPendantActivity.app, "dc00898", "", "", "0X8007100", "0X8007100", 0, 0, "", "", "", "");
        }
        else
        {
          DynamicAvatarRecordActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityPendantAvatarPendantActivity, 1, 1);
          azmj.b(this.jdField_a_of_type_ComTencentMobileqqActivityPendantAvatarPendantActivity.app, "dc00898", "", "", "0X8007100", "0X8007100", 0, 0, "", "", "", "");
        }
      }
      else
      {
        if (!this.jdField_a_of_type_ComTencentMobileqqActivityPendantAvatarPendantActivity.e)
        {
          ThreadManager.postImmediately(new AvatarPendantActivity.13.2(this), null, true);
          this.jdField_a_of_type_ComTencentMobileqqActivityPendantAvatarPendantActivity.e = true;
        }
        QQToast.a(this.jdField_a_of_type_ComTencentMobileqqActivityPendantAvatarPendantActivity, alpo.a(2131701245), 0).a();
        continue;
        this.jdField_a_of_type_ComTencentMobileqqActivityPendantAvatarPendantActivity.g();
        paramView = new Intent();
        paramInt = bcyw.b(this.jdField_a_of_type_ComTencentMobileqqActivityPendantAvatarPendantActivity);
        paramView.putExtra("PhotoConst.PHOTO_LIST_SHOW_PREVIEW", true);
        paramView.putExtra("Business_Origin", 100);
        paramView.putExtra("BUSINESS_ORIGIN_NEW", 100);
        paramView.putExtra("PhotoConst.PHOTOLIST_KEY_FILTER_GIF_VIDEO", true);
        paramView.putExtra("fromWhereClick", 11);
        PhotoUtils.a(paramView, this.jdField_a_of_type_ComTencentMobileqqActivityPendantAvatarPendantActivity, AvatarPendantActivity.class.getName(), paramInt, paramInt, 1080, 1080, bcyw.a());
        azmj.b(this.jdField_a_of_type_ComTencentMobileqqActivityPendantAvatarPendantActivity.app, "CliOper", "", "", "0X8004177", "0X8004177", this.jdField_a_of_type_ComTencentMobileqqActivityPendantAvatarPendantActivity.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.h, 0, "", "", "", "");
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
              this.jdField_a_of_type_ComTencentMobileqqActivityPendantAvatarPendantActivity.requestPermissions(new aifv(this), 2, new String[] { "android.permission.CAMERA", "android.permission.WRITE_EXTERNAL_STORAGE" });
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
          azmj.b(this.jdField_a_of_type_ComTencentMobileqqActivityPendantAvatarPendantActivity.app, "CliOper", "", "", "0X8004176", "0X8004176", this.jdField_a_of_type_ComTencentMobileqqActivityPendantAvatarPendantActivity.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.h, 0, "", "", "", "");
        }
        else
        {
          this.jdField_a_of_type_ComTencentMobileqqActivityPendantAvatarPendantActivity.jdField_a_of_type_AndroidNetUri = ProfileActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityPendantAvatarPendantActivity, 5);
          azmj.b(this.jdField_a_of_type_ComTencentMobileqqActivityPendantAvatarPendantActivity.app, "CliOper", "", "", "0X8004176", "0X8004176", this.jdField_a_of_type_ComTencentMobileqqActivityPendantAvatarPendantActivity.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.h, 0, "", "", "", "");
          continue;
          if (this.jdField_a_of_type_Boolean)
          {
            paramView = new Intent(this.jdField_a_of_type_ComTencentMobileqqActivityPendantAvatarPendantActivity, QQBrowserActivity.class);
            paramView.putExtra("url", "https://ti.qq.com/avatarlist/public/index.html?_wv=3&_wwv=4");
            this.jdField_a_of_type_ComTencentMobileqqActivityPendantAvatarPendantActivity.startActivity(paramView);
            azmj.b(this.jdField_a_of_type_ComTencentMobileqqActivityPendantAvatarPendantActivity.app, "dc00898", "", "", "0X8007C10", "0X8007C10", 0, 0, "", "", "", "");
          }
          else
          {
            bcyw.a(this.jdField_a_of_type_ComTencentMobileqqActivityPendantAvatarPendantActivity.app, this.jdField_a_of_type_ComTencentMobileqqActivityPendantAvatarPendantActivity, this.jdField_a_of_type_ComTencentMobileqqActivityPendantAvatarPendantActivity.jdField_a_of_type_ComTencentMobileqqAvatarDynamicavatarDynamicAvatarView, this.jdField_a_of_type_ComTencentMobileqqActivityPendantAvatarPendantActivity.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.a, 0, 0);
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aift
 * JD-Core Version:    0.7.0.1
 */