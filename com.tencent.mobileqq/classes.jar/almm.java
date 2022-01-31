import android.app.Activity;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.apkupdate.logic.data.ApkUpdateDetail;
import com.tencent.open.adapter.CommonDataAdapter;
import com.tencent.open.appcommon.now.download.js.DownloadJSApi;
import com.tencent.open.base.APNUtil;
import com.tencent.open.base.LogUtility;
import com.tencent.open.downloadnew.DownloadConstants;
import com.tencent.open.downloadnew.DownloadInfo;
import com.tencent.open.downloadnew.DownloadManager;

public final class almm
  implements Runnable
{
  public almm(Bundle paramBundle, int paramInt1, int paramInt2, Activity paramActivity, ApkUpdateDetail paramApkUpdateDetail) {}
  
  public void run()
  {
    boolean bool2 = true;
    Object localObject1 = new StringBuilder().append("doDownloadAction pParams=").append(this.jdField_a_of_type_AndroidOsBundle).append(" source=").append(this.jdField_a_of_type_Int).append(" myAppConfig=").append(this.b).append(" ac==null is");
    if (this.jdField_a_of_type_AndroidAppActivity == null) {}
    for (boolean bool1 = true;; bool1 = false)
    {
      LogUtility.a("DownloadJSApi", bool1);
      if (this.jdField_a_of_type_AndroidOsBundle != null) {
        break;
      }
      LogUtility.e("DownloadJSApi", "doDownloadAction pParams == null return");
      return;
    }
    Object localObject2 = this.jdField_a_of_type_AndroidOsBundle.getString(DownloadConstants.a);
    this.jdField_a_of_type_AndroidOsBundle.putInt(DownloadConstants.r, this.jdField_a_of_type_Int);
    this.jdField_a_of_type_AndroidOsBundle.putInt(DownloadConstants.D, 1);
    String str = this.jdField_a_of_type_AndroidOsBundle.getString(DownloadConstants.A);
    localObject1 = this.jdField_a_of_type_AndroidOsBundle.getString(DownloadConstants.h);
    if ((TextUtils.isEmpty(str)) || (str.equals("0"))) {
      this.jdField_a_of_type_AndroidOsBundle.putString(DownloadConstants.A, "");
    }
    localObject2 = DownloadManager.a().a((String)localObject2);
    if ((localObject2 != null) && (!TextUtils.isEmpty((CharSequence)localObject1))) {
      ((DownloadInfo)localObject2).g = ((String)localObject1);
    }
    if ((this.jdField_a_of_type_ComTencentApkupdateLogicDataApkUpdateDetail != null) && (this.jdField_a_of_type_ComTencentApkupdateLogicDataApkUpdateDetail.updatemethod == 2) && (TextUtils.isEmpty(this.jdField_a_of_type_AndroidOsBundle.getString(DownloadConstants.i))) && (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentApkupdateLogicDataApkUpdateDetail.url))) {
      this.jdField_a_of_type_AndroidOsBundle.putString(DownloadConstants.i, this.jdField_a_of_type_ComTencentApkupdateLogicDataApkUpdateDetail.url);
    }
    boolean bool3 = APNUtil.d(CommonDataAdapter.a().a());
    boolean bool4 = APNUtil.c(CommonDataAdapter.a().a());
    if ((localObject2 == null) || (((DownloadInfo)localObject2).a() == 1))
    {
      bool1 = true;
      if (this.jdField_a_of_type_AndroidAppActivity != null) {
        break label426;
      }
    }
    for (;;)
    {
      LogUtility.a("DownloadJSApi", "check wifi dialog isWifiActive=" + bool4 + " isFirstDownload=" + bool1 + " acIsNull=" + bool2);
      if ((!bool3) || (bool2) || (bool4) || (!bool1) || (!this.jdField_a_of_type_AndroidOsBundle.getBoolean(DownloadConstants.q))) {
        break label431;
      }
      DownloadJSApi.b(this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_AndroidOsBundle, this.jdField_a_of_type_Int, this.jdField_a_of_type_ComTencentApkupdateLogicDataApkUpdateDetail, this.b);
      return;
      bool1 = false;
      break;
      label426:
      bool2 = false;
    }
    label431:
    DownloadJSApi.a(this.jdField_a_of_type_AndroidOsBundle, this.jdField_a_of_type_Int, this.jdField_a_of_type_ComTencentApkupdateLogicDataApkUpdateDetail);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     almm
 * JD-Core Version:    0.7.0.1
 */