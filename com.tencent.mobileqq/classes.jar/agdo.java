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

class agdo
  implements AdapterView.OnItemClickListener
{
  agdo(agdi paramagdi, AIOShortVideoData paramAIOShortVideoData, File paramFile, int paramInt, agfq paramagfq) {}
  
  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    paramInt = 0;
    paramAdapterView = paramView.getTag();
    if (paramAdapterView == null) {}
    label1299:
    do
    {
      return;
      this.jdField_a_of_type_Agdi.jdField_a_of_type_ComTencentMobileqqUtilsShareActionSheetBuilder.dismiss();
      switch (((bdip)paramAdapterView).a.action)
      {
      }
      for (;;)
      {
        paramAdapterView = this.jdField_a_of_type_Agdi.jdField_a_of_type_Ages.a();
        if ((paramAdapterView == null) || (paramAdapterView.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData == null) || (!AIOShortVideoData.class.isInstance(paramAdapterView.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData))) {
          break;
        }
        paramAdapterView = (AIOShortVideoData)paramAdapterView.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData;
        if (paramAdapterView.jdField_b_of_type_Int != 0) {
          break label1299;
        }
        azmj.b(null, "dc00898", "", "", "0X8009EF9", "0X8009EF9", paramInt, 0, "", "", "", "");
        return;
        int i = 1;
        if (this.jdField_a_of_type_Agdi.jdField_a_of_type_Agft.asBinder().pingBinder())
        {
          paramAdapterView = this.jdField_a_of_type_Agdi.jdField_a_of_type_Agft.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOShortVideoData.jdField_f_of_type_Long, this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOShortVideoData.jdField_f_of_type_Int, this.jdField_a_of_type_Agdi.jdField_g_of_type_Int);
          if (paramAdapterView != null)
          {
            paramAdapterView.putExtra("NeedReportForwardShortVideo", true);
            if (this.jdField_a_of_type_Agdi.jdField_a_of_type_Ages.a() != null)
            {
              paramView = this.jdField_a_of_type_Agdi.jdField_a_of_type_Ages.a().jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData;
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
            arum.a(agdi.G(this.jdField_a_of_type_Agdi), paramAdapterView);
          }
        }
        paramInt = i;
        if (this.jdField_a_of_type_Agdi.jdField_c_of_type_Boolean)
        {
          aule.a("0X8009ABC");
          paramInt = i;
          continue;
          if (QLog.isColorLevel()) {
            QLog.d("AIOGalleryScene", 2, "click menu to share to qzone");
          }
          paramAdapterView = bizt.a();
          paramAdapterView.a = this.jdField_a_of_type_Agdi.jdField_b_of_type_JavaLangString;
          bizm.c(agdi.H(this.jdField_a_of_type_Agdi), paramAdapterView, this.jdField_a_of_type_JavaIoFile.getAbsolutePath(), 10001);
          azmj.b(null, "dc00898", "", "", "0X8007539", "0X8007539", 0, 0, "", "", "", "");
          paramInt = 4;
          continue;
          if (this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOShortVideoData.j == 5002)
          {
            if (QLog.isColorLevel()) {
              QLog.d("AIOGalleryScene", 2, "video file is expired");
            }
            QQToast.a(agdi.I(this.jdField_a_of_type_Agdi), 1, alpo.a(2131700421), 0).a();
            return;
          }
          if (this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOShortVideoData.jdField_b_of_type_Int == 1)
          {
            agdi.a(this.jdField_a_of_type_Agdi, this.jdField_a_of_type_Int, this.jdField_a_of_type_JavaIoFile);
          }
          else if ((this.jdField_a_of_type_JavaIoFile != null) && (this.jdField_a_of_type_JavaIoFile.exists()) && (this.jdField_a_of_type_JavaIoFile.length() == this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOShortVideoData.h))
          {
            paramAdapterView = new StringBuilder().append(this.jdField_a_of_type_JavaIoFile.getParentFile().getName()).append(NetConnInfoCenter.getServerTime()).toString().toLowerCase(Locale.US) + ".mp4";
            ThreadManager.getFileThreadHandler().post(new ShortVideoUtils.VideoFileSaveRunnable(this.jdField_a_of_type_JavaIoFile.getAbsolutePath(), this.jdField_a_of_type_Agdi.jdField_a_of_type_MqqOsMqqHandler, paramAdapterView, false));
          }
          else if (!AppNetConnInfo.isNetSupport())
          {
            this.jdField_a_of_type_Agdi.jdField_a_of_type_MqqOsMqqHandler.sendEmptyMessage(10001);
          }
          else if ((!AppNetConnInfo.isWifiConn()) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOShortVideoData.h > 29360128L))
          {
            this.jdField_a_of_type_Agdi.a(3, this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOShortVideoData, this.jdField_a_of_type_Agfq);
          }
          else
          {
            agdi.a(this.jdField_a_of_type_Agdi, this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOShortVideoData, this.jdField_a_of_type_Agfq);
            this.jdField_a_of_type_Agfq.jdField_a_of_type_Agfr.a = true;
            this.jdField_a_of_type_Agdi.u();
            continue;
            azmj.b(null, "P_CliOper", "dwop_via", "", "0X8009BE4", "0X8009BE4", this.jdField_a_of_type_Agdi.k, 0, "", "", "", "");
            paramView = this.jdField_a_of_type_Agdi.d;
            paramAdapterView = paramView;
            if (TextUtils.isEmpty(paramView)) {
              paramAdapterView = this.jdField_a_of_type_Agdi.jdField_c_of_type_JavaLangString;
            }
            agdi.a(agdi.J(this.jdField_a_of_type_Agdi), this.jdField_a_of_type_Agdi.jdField_g_of_type_Int, this.jdField_a_of_type_Agdi.jdField_c_of_type_JavaLangString, paramAdapterView, this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOShortVideoData.jdField_g_of_type_Long, this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOShortVideoData.i, this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOShortVideoData.jdField_g_of_type_Int, false);
            paramInt = 6;
            continue;
            i = 3;
            paramInt = i;
            if (this.jdField_a_of_type_Agdi.jdField_a_of_type_Agft.asBinder().pingBinder())
            {
              paramAdapterView = this.jdField_a_of_type_Agdi.jdField_a_of_type_Agft.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOShortVideoData.jdField_f_of_type_Long, this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOShortVideoData.jdField_f_of_type_Int, this.jdField_a_of_type_Agdi.jdField_g_of_type_Int);
              paramInt = i;
              if (paramAdapterView != null)
              {
                biqt.a(paramAdapterView).a(agdi.K(this.jdField_a_of_type_Agdi), BaseApplicationImpl.getApplication().getRuntime().getAccount());
                birh.a(null, 3, 0, this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOShortVideoData.jdField_g_of_type_Int);
                birh.a(BaseApplicationImpl.getApplication().getRuntime(), 6, 5);
                paramInt = i;
                continue;
                paramAdapterView = new Intent("android.intent.action.VIEW");
                paramAdapterView.setDataAndType(Uri.parse("file://" + this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOShortVideoData.jdField_b_of_type_JavaLangString), "video/*");
                paramAdapterView.putExtra("big_brother_source_key", " biz_src_jc_video");
                agdi.L(this.jdField_a_of_type_Agdi).startActivity(paramAdapterView);
                paramInt = this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOShortVideoData.jdField_g_of_type_Int;
                if (paramInt == 0)
                {
                  azmj.b(null, "CliOper", "", "", "0X8004676", "0X8004676", 0, 0, "", "1", "", "");
                  paramInt = 7;
                }
                else if (paramInt == 3000)
                {
                  azmj.b(null, "CliOper", "", "", "0X8004676", "0X8004676", 0, 0, "", "2", "", "");
                  paramInt = 7;
                }
                else if (paramInt == 1)
                {
                  azmj.b(null, "CliOper", "", "", "0X8004676", "0X8004676", 0, 0, "", "3", "", "");
                  paramInt = 7;
                }
                else
                {
                  azmj.b(null, "CliOper", "", "", "0X8004676", "0X8004676", 0, 0, "", "4", "", "");
                  paramInt = 7;
                  continue;
                  i = 6;
                  paramInt = i;
                  if (this.jdField_a_of_type_Agdi.jdField_a_of_type_Agft.asBinder().pingBinder())
                  {
                    this.jdField_a_of_type_Agdi.jdField_a_of_type_Agft.c(this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOShortVideoData.jdField_f_of_type_Long);
                    QQToast.a(agdi.M(this.jdField_a_of_type_Agdi), agdi.N(this.jdField_a_of_type_Agdi).getString(2131692912), 0).a();
                    paramInt = i;
                  }
                }
              }
            }
          }
        }
      }
    } while (paramAdapterView.jdField_b_of_type_Int != 1);
    azmj.b(null, "dc00898", "", "", "0X8009EF8", "0X8009EF8", paramInt, 0, "", "", "", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     agdo
 * JD-Core Version:    0.7.0.1
 */