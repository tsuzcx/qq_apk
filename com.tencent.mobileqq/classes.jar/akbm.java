import android.text.TextUtils;
import com.tencent.mobileqq.activity.ProfileActivity.AllInOne;
import com.tencent.mobileqq.activity.pendant.AvatarPendantActivity;
import com.tencent.mobileqq.activity.pendant.AvatarPendantActivity.22.1;
import com.tencent.mobileqq.activity.pendant.AvatarPendantActivity.22.2;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.face.QQHeadDownloadHandler;
import com.tencent.mobileqq.data.Setting;
import com.tencent.mobileqq.msf.sdk.MsfSdkUtils;
import com.tencent.qphone.base.util.QLog;
import mqq.os.MqqHandler;

public class akbm
  extends anmu
{
  public akbm(AvatarPendantActivity paramAvatarPendantActivity) {}
  
  protected void onGetHeadInfo(boolean paramBoolean, Setting paramSetting)
  {
    if ((paramSetting == null) || (this.a.a == null) || (!this.a.a.a.equals(paramSetting.uin)))
    {
      if (QLog.isColorLevel()) {
        QLog.d("AvatarPendantActivity", 2, "onGetHeadInfo， fail");
      }
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("AvatarPendantActivity", 2, "onGetHeadInfo: uin=" + paramSetting.uin);
    }
    AvatarPendantActivity.d(this.a);
    if (!this.a.isResume()) {
      AvatarPendantActivity.a(this.a, true);
    }
    String str2 = QQHeadDownloadHandler.a(paramSetting.url, paramSetting.bFaceFlags);
    String str1 = str2;
    if (!TextUtils.isEmpty(str2)) {
      str1 = MsfSdkUtils.insertMtype("QQHeadIcon", str2);
    }
    this.a.d = paramSetting.headImgTimestamp;
    ThreadManager.getUIHandler().post(new AvatarPendantActivity.22.2(this, str1));
  }
  
  protected void onUpdateCustomHead(boolean paramBoolean, String paramString)
  {
    AvatarPendantActivity.d(this.a);
    if (!this.a.isResume()) {
      AvatarPendantActivity.a(this.a, true);
    }
    if (paramBoolean) {
      ThreadManager.excute(new AvatarPendantActivity.22.1(this), 32, null, false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     akbm
 * JD-Core Version:    0.7.0.1
 */