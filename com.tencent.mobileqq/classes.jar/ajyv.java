import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import com.tencent.mobileqq.activity.shortvideo.ShortVideoPlayActivity;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.shortvideo.ShortVideoUtils;
import com.tencent.mobileqq.shortvideo.ShortVideoUtils.VideoFileSaveRunnable;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import mqq.os.MqqHandler;

public class ajyv
  implements bhqd
{
  public ajyv(ShortVideoPlayActivity paramShortVideoPlayActivity, bhpy parambhpy, String paramString1, String paramString2, String paramString3, boolean paramBoolean, String paramString4, String paramString5, String paramString6) {}
  
  public void OnClick(View paramView, int paramInt)
  {
    this.jdField_a_of_type_Bhpy.dismiss();
    paramView = this.jdField_a_of_type_Bhpy.a(paramInt);
    if (paramView != null)
    {
      if (!paramView.equals(this.jdField_a_of_type_JavaLangString)) {
        break label213;
      }
      if (QLog.isColorLevel()) {
        QLog.d("ShortVideoPlayActivity", 2, "click menu to forward shortVideo......");
      }
      paramView = this.jdField_a_of_type_ComTencentMobileqqActivityShortvideoShortVideoPlayActivity;
      Bundle localBundle = ShortVideoPlayActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityShortvideoShortVideoPlayActivity).getExtras();
      localBundle.putInt("forward_type", 21);
      localBundle.putBoolean("forward_need_sendmsg", true);
      localBundle.putString("forward_thumb", ShortVideoUtils.a(this.jdField_a_of_type_ComTencentMobileqqActivityShortvideoShortVideoPlayActivity.h, "jpg"));
      localBundle.putString("file_send_path", this.b);
      if (bdcs.b(this.b))
      {
        localBundle.putBoolean("k_dataline", true);
        localBundle.putString("forward_extra", this.b);
        localBundle.putBoolean("direct_send_if_dataline_forward", true);
      }
      Intent localIntent = new Intent();
      localIntent.putExtras(localBundle);
      arum.a(paramView, localIntent);
      ShortVideoPlayActivity.c(this.jdField_a_of_type_ComTencentMobileqqActivityShortvideoShortVideoPlayActivity);
      if (this.jdField_a_of_type_ComTencentMobileqqActivityShortvideoShortVideoPlayActivity.c) {
        aule.a("0X8009ABC");
      }
      azmj.b(this.jdField_a_of_type_ComTencentMobileqqActivityShortvideoShortVideoPlayActivity.app, "CliOper", "", "", "0X80052CC", "0X80052CC", 0, 0, "", "2", "", "");
    }
    label213:
    do
    {
      return;
      if (paramView.equals(this.c))
      {
        if (QLog.isColorLevel()) {
          QLog.d("ShortVideoPlayActivity", 2, "click menu to share to qzone, finalVideoExists=" + this.jdField_a_of_type_Boolean);
        }
        if (this.jdField_a_of_type_Boolean)
        {
          ShortVideoPlayActivity.d(this.jdField_a_of_type_ComTencentMobileqqActivityShortvideoShortVideoPlayActivity);
          return;
        }
        QQToast.a(this.jdField_a_of_type_ComTencentMobileqqActivityShortvideoShortVideoPlayActivity.a, 0, 2131720085, 0).b(this.jdField_a_of_type_ComTencentMobileqqActivityShortvideoShortVideoPlayActivity.a.getResources().getDimensionPixelSize(2131298914));
        return;
      }
      if (paramView.equals(this.d))
      {
        if (!this.jdField_a_of_type_Boolean)
        {
          QQToast.a(this.jdField_a_of_type_ComTencentMobileqqActivityShortvideoShortVideoPlayActivity.a, 0, 2131720085, 0).b(this.jdField_a_of_type_ComTencentMobileqqActivityShortvideoShortVideoPlayActivity.a.getResources().getDimensionPixelSize(2131298914));
          return;
        }
        if (this.jdField_a_of_type_ComTencentMobileqqActivityShortvideoShortVideoPlayActivity.b.get() != null) {
          ThreadManager.getFileThreadHandler().post(new ShortVideoUtils.VideoFileSaveRunnable(this.e, (MqqHandler)this.jdField_a_of_type_ComTencentMobileqqActivityShortvideoShortVideoPlayActivity.b.get(), this.jdField_a_of_type_ComTencentMobileqqActivityShortvideoShortVideoPlayActivity.g + ".mp4", false));
        }
        if (this.jdField_a_of_type_ComTencentMobileqqActivityShortvideoShortVideoPlayActivity.e == 0)
        {
          azmj.b(this.jdField_a_of_type_ComTencentMobileqqActivityShortvideoShortVideoPlayActivity.app, "CliOper", "", "", "0X8004675", "0X8004675", 0, 0, "", "1", "", "");
          this.jdField_a_of_type_ComTencentMobileqqActivityShortvideoShortVideoPlayActivity.d = true;
        }
        for (;;)
        {
          new axot(BaseApplication.getContext()).a(this.jdField_a_of_type_ComTencentMobileqqActivityShortvideoShortVideoPlayActivity.app, 2002, this.jdField_a_of_type_ComTencentMobileqqActivityShortvideoShortVideoPlayActivity.f, this.jdField_a_of_type_ComTencentMobileqqActivityShortvideoShortVideoPlayActivity.j);
          if (!this.jdField_a_of_type_ComTencentMobileqqActivityShortvideoShortVideoPlayActivity.c) {
            break;
          }
          aule.a("0X8009ABD");
          return;
          if (this.jdField_a_of_type_ComTencentMobileqqActivityShortvideoShortVideoPlayActivity.e == 3000)
          {
            azmj.b(this.jdField_a_of_type_ComTencentMobileqqActivityShortvideoShortVideoPlayActivity.app, "CliOper", "", "", "0X8004675", "0X8004675", 0, 0, "", "2", "", "");
            this.jdField_a_of_type_ComTencentMobileqqActivityShortvideoShortVideoPlayActivity.d = true;
          }
          else if (this.jdField_a_of_type_ComTencentMobileqqActivityShortvideoShortVideoPlayActivity.e == 1)
          {
            azmj.b(this.jdField_a_of_type_ComTencentMobileqqActivityShortvideoShortVideoPlayActivity.app, "CliOper", "", "", "0X8004675", "0X8004675", 0, 0, "", "3", "", "");
            this.jdField_a_of_type_ComTencentMobileqqActivityShortvideoShortVideoPlayActivity.d = true;
          }
          else
          {
            azmj.b(this.jdField_a_of_type_ComTencentMobileqqActivityShortvideoShortVideoPlayActivity.app, "CliOper", "", "", "0X8004675", "0X8004675", 0, 0, "", "4", "", "");
            this.jdField_a_of_type_ComTencentMobileqqActivityShortvideoShortVideoPlayActivity.d = true;
          }
        }
      }
    } while (!paramView.equals(this.f));
    if (!this.jdField_a_of_type_Boolean)
    {
      QQToast.a(this.jdField_a_of_type_ComTencentMobileqqActivityShortvideoShortVideoPlayActivity.a, 0, 2131720085, 0).b(this.jdField_a_of_type_ComTencentMobileqqActivityShortvideoShortVideoPlayActivity.a.getResources().getDimensionPixelSize(2131298914));
      return;
    }
    paramView = new Intent("android.intent.action.VIEW");
    paramView.setDataAndType(Uri.parse("file://" + this.e), "video/*");
    this.jdField_a_of_type_ComTencentMobileqqActivityShortvideoShortVideoPlayActivity.startActivity(paramView);
    if (this.jdField_a_of_type_ComTencentMobileqqActivityShortvideoShortVideoPlayActivity.e == 0)
    {
      azmj.b(this.jdField_a_of_type_ComTencentMobileqqActivityShortvideoShortVideoPlayActivity.app, "CliOper", "", "", "0X8004676", "0X8004676", 0, 0, "", "1", "", "");
      this.jdField_a_of_type_ComTencentMobileqqActivityShortvideoShortVideoPlayActivity.d = true;
      return;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqActivityShortvideoShortVideoPlayActivity.e == 3000)
    {
      azmj.b(this.jdField_a_of_type_ComTencentMobileqqActivityShortvideoShortVideoPlayActivity.app, "CliOper", "", "", "0X8004676", "0X8004676", 0, 0, "", "2", "", "");
      this.jdField_a_of_type_ComTencentMobileqqActivityShortvideoShortVideoPlayActivity.d = true;
      return;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqActivityShortvideoShortVideoPlayActivity.e == 1)
    {
      azmj.b(this.jdField_a_of_type_ComTencentMobileqqActivityShortvideoShortVideoPlayActivity.app, "CliOper", "", "", "0X8004676", "0X8004676", 0, 0, "", "3", "", "");
      this.jdField_a_of_type_ComTencentMobileqqActivityShortvideoShortVideoPlayActivity.d = true;
      return;
    }
    azmj.b(this.jdField_a_of_type_ComTencentMobileqqActivityShortvideoShortVideoPlayActivity.app, "CliOper", "", "", "0X8004676", "0X8004676", 0, 0, "", "4", "", "");
    this.jdField_a_of_type_ComTencentMobileqqActivityShortvideoShortVideoPlayActivity.d = true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ajyv
 * JD-Core Version:    0.7.0.1
 */