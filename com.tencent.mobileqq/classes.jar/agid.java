import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.IBinder;
import android.text.TextUtils;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.aio.photo.AIOShortVideoData;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.msf.sdk.AppNetConnInfo;
import com.tencent.mobileqq.shortvideo.ShortVideoUtils.VideoFileSaveRunnable;
import com.tencent.mobileqq.utils.ShareActionSheetBuilder;
import com.tencent.mobileqq.utils.ShareActionSheetBuilder.ActionSheetItem;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.Locale;
import mqq.app.AppRuntime;
import mqq.os.MqqHandler;

class agid
  implements AdapterView.OnItemClickListener
{
  agid(aghx paramaghx, AIOShortVideoData paramAIOShortVideoData, File paramFile, int paramInt, agkf paramagkf) {}
  
  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    paramInt = 0;
    paramAdapterView = paramView.getTag();
    if (paramAdapterView == null) {}
    label1299:
    do
    {
      return;
      this.jdField_a_of_type_Aghx.jdField_a_of_type_ComTencentMobileqqUtilsShareActionSheetBuilder.dismiss();
      switch (((bdmy)paramAdapterView).a.action)
      {
      }
      for (;;)
      {
        paramAdapterView = this.jdField_a_of_type_Aghx.jdField_a_of_type_Agjh.a();
        if ((paramAdapterView == null) || (paramAdapterView.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData == null) || (!AIOShortVideoData.class.isInstance(paramAdapterView.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData))) {
          break;
        }
        paramAdapterView = (AIOShortVideoData)paramAdapterView.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData;
        if (paramAdapterView.jdField_b_of_type_Int != 0) {
          break label1299;
        }
        azqs.b(null, "dc00898", "", "", "0X8009EF9", "0X8009EF9", paramInt, 0, "", "", "", "");
        return;
        int i = 1;
        if (this.jdField_a_of_type_Aghx.jdField_a_of_type_Agki.asBinder().pingBinder())
        {
          paramAdapterView = this.jdField_a_of_type_Aghx.jdField_a_of_type_Agki.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOShortVideoData.jdField_f_of_type_Long, this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOShortVideoData.jdField_f_of_type_Int, this.jdField_a_of_type_Aghx.jdField_g_of_type_Int);
          if (paramAdapterView != null)
          {
            paramAdapterView.putExtra("NeedReportForwardShortVideo", true);
            if (this.jdField_a_of_type_Aghx.jdField_a_of_type_Agjh.a() != null)
            {
              paramView = this.jdField_a_of_type_Aghx.jdField_a_of_type_Agjh.a().jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData;
              if ((paramView instanceof AIOShortVideoData))
              {
                paramView = (AIOShortVideoData)paramView;
                paramInt = paramView.jdField_e_of_type_Int;
                AppRuntime localAppRuntime = BaseApplicationImpl.sApplication.getRuntime();
                if ((paramInt == LocalMediaInfo.REDBAG_TYPE_GET) && (localAppRuntime.getAccount().equals(paramView.d)))
                {
                  paramAdapterView.putExtra("param_key_redbag_type", paramInt);
                  paramAdapterView.putExtra("param_key_redbag_video_id", paramView.jdField_c_of_type_JavaLangString);
                  paramAdapterView.putExtra("from_session_uin", paramView.jdField_e_of_type_JavaLangString);
                }
                if (paramView.k == 2) {
                  paramAdapterView.putExtra("special_video_type", paramView.k);
                }
              }
            }
            aryv.a(aghx.G(this.jdField_a_of_type_Aghx), paramAdapterView);
          }
        }
        paramInt = i;
        if (this.jdField_a_of_type_Aghx.jdField_c_of_type_Boolean)
        {
          aupn.a("0X8009ABC");
          paramInt = i;
          continue;
          if (QLog.isColorLevel()) {
            QLog.d("AIOGalleryScene", 2, "click menu to share to qzone");
          }
          paramAdapterView = bjea.a();
          paramAdapterView.a = this.jdField_a_of_type_Aghx.jdField_b_of_type_JavaLangString;
          bjdt.c(aghx.H(this.jdField_a_of_type_Aghx), paramAdapterView, this.jdField_a_of_type_JavaIoFile.getAbsolutePath(), 10001);
          azqs.b(null, "dc00898", "", "", "0X8007539", "0X8007539", 0, 0, "", "", "", "");
          paramInt = 4;
          continue;
          if (this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOShortVideoData.j == 5002)
          {
            if (QLog.isColorLevel()) {
              QLog.d("AIOGalleryScene", 2, "video file is expired");
            }
            QQToast.a(aghx.I(this.jdField_a_of_type_Aghx), 1, alud.a(2131700433), 0).a();
            return;
          }
          if (this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOShortVideoData.jdField_b_of_type_Int == 1)
          {
            aghx.a(this.jdField_a_of_type_Aghx, this.jdField_a_of_type_Int, this.jdField_a_of_type_JavaIoFile);
          }
          else if ((this.jdField_a_of_type_JavaIoFile != null) && (this.jdField_a_of_type_JavaIoFile.exists()) && (this.jdField_a_of_type_JavaIoFile.length() == this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOShortVideoData.h))
          {
            paramAdapterView = new StringBuilder().append(this.jdField_a_of_type_JavaIoFile.getParentFile().getName()).append(NetConnInfoCenter.getServerTime()).toString().toLowerCase(Locale.US) + ".mp4";
            ThreadManager.getFileThreadHandler().post(new ShortVideoUtils.VideoFileSaveRunnable(this.jdField_a_of_type_JavaIoFile.getAbsolutePath(), this.jdField_a_of_type_Aghx.jdField_a_of_type_MqqOsMqqHandler, paramAdapterView, false));
          }
          else if (!AppNetConnInfo.isNetSupport())
          {
            this.jdField_a_of_type_Aghx.jdField_a_of_type_MqqOsMqqHandler.sendEmptyMessage(10001);
          }
          else if ((!AppNetConnInfo.isWifiConn()) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOShortVideoData.h > 29360128L))
          {
            this.jdField_a_of_type_Aghx.a(3, this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOShortVideoData, this.jdField_a_of_type_Agkf);
          }
          else
          {
            aghx.a(this.jdField_a_of_type_Aghx, this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOShortVideoData, this.jdField_a_of_type_Agkf);
            this.jdField_a_of_type_Agkf.jdField_a_of_type_Agkg.a = true;
            this.jdField_a_of_type_Aghx.u();
            continue;
            azqs.b(null, "P_CliOper", "dwop_via", "", "0X8009BE4", "0X8009BE4", this.jdField_a_of_type_Aghx.k, 0, "", "", "", "");
            paramView = this.jdField_a_of_type_Aghx.d;
            paramAdapterView = paramView;
            if (TextUtils.isEmpty(paramView)) {
              paramAdapterView = this.jdField_a_of_type_Aghx.jdField_c_of_type_JavaLangString;
            }
            aghx.a(aghx.J(this.jdField_a_of_type_Aghx), this.jdField_a_of_type_Aghx.jdField_g_of_type_Int, this.jdField_a_of_type_Aghx.jdField_c_of_type_JavaLangString, paramAdapterView, this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOShortVideoData.jdField_g_of_type_Long, this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOShortVideoData.i, this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOShortVideoData.jdField_g_of_type_Int, false);
            paramInt = 6;
            continue;
            i = 3;
            paramInt = i;
            if (this.jdField_a_of_type_Aghx.jdField_a_of_type_Agki.asBinder().pingBinder())
            {
              paramAdapterView = this.jdField_a_of_type_Aghx.jdField_a_of_type_Agki.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOShortVideoData.jdField_f_of_type_Long, this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOShortVideoData.jdField_f_of_type_Int, this.jdField_a_of_type_Aghx.jdField_g_of_type_Int);
              paramInt = i;
              if (paramAdapterView != null)
              {
                biva.a(paramAdapterView).a(aghx.K(this.jdField_a_of_type_Aghx), BaseApplicationImpl.getApplication().getRuntime().getAccount());
                bivo.a(null, 3, 0, this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOShortVideoData.jdField_g_of_type_Int);
                bivo.a(BaseApplicationImpl.getApplication().getRuntime(), 6, 5);
                paramInt = i;
                continue;
                paramAdapterView = new Intent("android.intent.action.VIEW");
                paramAdapterView.setDataAndType(Uri.parse("file://" + this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOShortVideoData.jdField_b_of_type_JavaLangString), "video/*");
                paramAdapterView.putExtra("big_brother_source_key", " biz_src_jc_video");
                aghx.L(this.jdField_a_of_type_Aghx).startActivity(paramAdapterView);
                paramInt = this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOShortVideoData.jdField_g_of_type_Int;
                if (paramInt == 0)
                {
                  azqs.b(null, "CliOper", "", "", "0X8004676", "0X8004676", 0, 0, "", "1", "", "");
                  paramInt = 7;
                }
                else if (paramInt == 3000)
                {
                  azqs.b(null, "CliOper", "", "", "0X8004676", "0X8004676", 0, 0, "", "2", "", "");
                  paramInt = 7;
                }
                else if (paramInt == 1)
                {
                  azqs.b(null, "CliOper", "", "", "0X8004676", "0X8004676", 0, 0, "", "3", "", "");
                  paramInt = 7;
                }
                else
                {
                  azqs.b(null, "CliOper", "", "", "0X8004676", "0X8004676", 0, 0, "", "4", "", "");
                  paramInt = 7;
                  continue;
                  i = 6;
                  paramInt = i;
                  if (this.jdField_a_of_type_Aghx.jdField_a_of_type_Agki.asBinder().pingBinder())
                  {
                    this.jdField_a_of_type_Aghx.jdField_a_of_type_Agki.c(this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOShortVideoData.jdField_f_of_type_Long);
                    QQToast.a(aghx.M(this.jdField_a_of_type_Aghx), aghx.N(this.jdField_a_of_type_Aghx).getString(2131692914), 0).a();
                    paramInt = i;
                  }
                }
              }
            }
          }
        }
      }
    } while (paramAdapterView.jdField_b_of_type_Int != 1);
    azqs.b(null, "dc00898", "", "", "0X8009EF8", "0X8009EF8", paramInt, 0, "", "", "", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     agid
 * JD-Core Version:    0.7.0.1
 */