import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteException;
import android.text.TextUtils;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.Utils;
import com.tencent.mobileqq.activity.aio.photo.AIOImageData;
import com.tencent.mobileqq.activity.aio.photo.AIORichMediaData;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.msf.sdk.AppNetConnInfo;
import com.tencent.mobileqq.ocr.OCRResultActivity;
import com.tencent.mobileqq.pic.PicShareToWX;
import com.tencent.mobileqq.qipc.QIPCClientHelper;
import com.tencent.mobileqq.vaswebviewplugin.VasWebviewUtil;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.LocalMultiProcConfig;
import cooperation.qzone.QZoneClickReport;
import java.io.File;
import mqq.app.AppRuntime;

class adwr
  implements AdapterView.OnItemClickListener
{
  adwr(advv paramadvv, AIOImageData paramAIOImageData, adyb paramadyb, File paramFile) {}
  
  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    paramAdapterView = paramView.getTag();
    if (paramAdapterView == null) {
      return;
    }
    this.jdField_a_of_type_Advv.jdField_a_of_type_Bahv.b();
    paramAdapterView = ((baia)paramAdapterView).a;
    paramInt = paramAdapterView.c;
    paramAdapterView = paramAdapterView.b;
    switch (paramInt)
    {
    case 59: 
    case 60: 
    case 61: 
    case 62: 
    case 63: 
    case 64: 
    case 65: 
    case 67: 
    case 68: 
    default: 
      paramInt = 0;
    }
    label142:
    label1809:
    for (;;)
    {
      awqx.b(null, "dc00898", "", "", "0X8009EF6", "0X8009EF6", paramInt, 0, "", "", "", "");
      return;
      paramInt = 12;
      if (QLog.isColorLevel()) {
        QLog.i("EmoticonFromGroup_Manager", 2, "action sheet add to favorite.");
      }
      paramAdapterView = new Bundle();
      paramAdapterView.putString("pic_md5", this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOImageData.jdField_f_of_type_JavaLangString);
      paramView = new adws(this);
      QIPCClientHelper.getInstance().callServer("EmoticonIPCModule", "action_group_emo_big_pic_add_fav", paramAdapterView, paramView);
      if (this.jdField_a_of_type_Advv.jdField_h_of_type_Boolean)
      {
        VasWebviewUtil.reportCommercialDrainage("", "QLbq", "MoreOp", "0", 1, 0, 0, "", "", "1", "", "", "", "", 0, 0, 0, 0);
        paramInt = 12;
        continue;
        paramInt = 1;
        this.jdField_a_of_type_Advv.a("Pic_Forward_Contacts", 0);
        this.jdField_a_of_type_Advv.a(this.jdField_a_of_type_Adyb, advv.o(this.jdField_a_of_type_Advv), 0);
        if (this.jdField_a_of_type_Advv.jdField_h_of_type_Boolean) {
          VasWebviewUtil.reportCommercialDrainage("", "QLbq", "MoreOp", "0", 1, 0, 0, "", "", "2", "", "", "", "", 0, 0, 0, 0);
        }
        if (this.jdField_a_of_type_Advv.jdField_c_of_type_Boolean)
        {
          aryb.a("0X8009ABA");
          paramInt = 1;
          continue;
          paramInt = 4;
          this.jdField_a_of_type_Advv.a("Pic_Forward_Qzone", 0);
          adwz.a(advv.p(this.jdField_a_of_type_Advv), this.jdField_a_of_type_Advv.b, this.jdField_a_of_type_Advv.e, this.jdField_a_of_type_Advv.jdField_f_of_type_Int, this.jdField_a_of_type_Adyb, this.jdField_a_of_type_Advv.i, this.jdField_a_of_type_Advv.d);
          if (this.jdField_a_of_type_Advv.jdField_h_of_type_Boolean)
          {
            VasWebviewUtil.reportCommercialDrainage("", "QLbq", "MoreOp", "0", 1, 0, 0, "", "", "4", "", "", "", "", 0, 0, 0, 0);
            paramInt = 4;
            continue;
            if (LocalMultiProcConfig.getInt4Uin(this.jdField_a_of_type_Advv.b + "__qzone_pic_permission__" + this.jdField_a_of_type_Advv.d, -1, Long.valueOf(this.jdField_a_of_type_Advv.b).longValue()) == 0)
            {
              paramAdapterView = new bafb(advv.q(this.jdField_a_of_type_Advv), 2131690181);
              paramAdapterView.setContentView(2131493345);
              paramAdapterView.setTitle(advv.r(this.jdField_a_of_type_Advv).getString(2131632185));
              paramAdapterView.setMessage(advv.s(this.jdField_a_of_type_Advv).getString(2131632183));
              paramAdapterView.setNegativeButton(advv.t(this.jdField_a_of_type_Advv).getString(2131632184), new adwt(this));
              paramAdapterView.setCanceledOnTouchOutside(false);
              paramAdapterView.setCancelable(false);
              paramAdapterView.show();
              QZoneClickReport.startReportImediately(this.jdField_a_of_type_Advv.b, "40", "1");
              paramInt = 5;
            }
            else
            {
              this.jdField_a_of_type_Advv.a("Pic_Forward_Grpalbum", 0);
              adwz.a(advv.v(this.jdField_a_of_type_Advv), this.jdField_a_of_type_Advv.b, this.jdField_a_of_type_Advv.d, this.jdField_a_of_type_Advv.e, this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOImageData.a, this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOImageData.e, this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOImageData.c, -1);
              paramInt = 5;
              continue;
              paramInt = 2;
              this.jdField_a_of_type_Advv.a("Pic_save", 0);
              if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOImageData.a(4) == null) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOImageData.a(4)) && (AppNetConnInfo.isNetSupport())) {
                if ((!AppNetConnInfo.isWifiConn()) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOImageData.jdField_h_of_type_Long > 29360128L)) {
                  this.jdField_a_of_type_Advv.a(1, this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOImageData, this.jdField_a_of_type_Adyb);
                }
              }
              for (;;)
              {
                this.jdField_a_of_type_Advv.a(this.jdField_a_of_type_JavaIoFile.getAbsolutePath(), 55);
                if (this.jdField_a_of_type_Advv.jdField_h_of_type_Boolean) {
                  VasWebviewUtil.reportCommercialDrainage("", "QLbq", "MoreOp", "0", 1, 0, 0, "", "", "3", "", "", "", "", 0, 0, 0, 0);
                }
                if (!this.jdField_a_of_type_Advv.jdField_c_of_type_Boolean) {
                  break label1809;
                }
                aryb.a("0X8009ABB");
                paramInt = 2;
                break;
                advv.a(this.jdField_a_of_type_Advv, this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOImageData, this.jdField_a_of_type_Adyb);
                this.jdField_a_of_type_Adyb.jdField_a_of_type_Adyc.e = true;
                this.jdField_a_of_type_Advv.u();
                continue;
                adwz.a(advv.w(this.jdField_a_of_type_Advv), this.jdField_a_of_type_JavaIoFile, Utils.Crc64String(this.jdField_a_of_type_JavaIoFile.getAbsolutePath() + NetConnInfoCenter.getServerTime()));
              }
              paramView = new Intent();
              paramView.putExtra("preResult", paramAdapterView);
              this.jdField_a_of_type_Advv.a(this.jdField_a_of_type_Advv.jdField_f_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOImageData.jdField_g_of_type_Int, this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOImageData.jdField_h_of_type_Boolean, this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOImageData.k, this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOImageData.jdField_f_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOImageData.jdField_j_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOImageData.e, 1, paramView);
              awqx.b(null, "P_CliOper", "qrcode", "", "0X80059A4", "0X80059A4", 0, 0, "", "", "", "");
              paramInt = 9;
              continue;
              paramView = new Intent();
              paramView.putExtra("preResult", paramAdapterView);
              this.jdField_a_of_type_Advv.a(this.jdField_a_of_type_Advv.jdField_f_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOImageData.jdField_g_of_type_Int, this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOImageData.jdField_h_of_type_Boolean, this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOImageData.k, this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOImageData.jdField_f_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOImageData.jdField_j_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOImageData.e, 2, paramView);
              paramInt = 10;
              continue;
              paramInt = 3;
              for (;;)
              {
                try
                {
                  paramAdapterView = this.jdField_a_of_type_Advv.jdField_a_of_type_Adye.a(this.jdField_a_of_type_Adyb.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData.jdField_f_of_type_Long, this.jdField_a_of_type_Adyb.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData.jdField_f_of_type_Int);
                  if (paramAdapterView != null) {
                    break label1272;
                  }
                  bfhl.b(this.jdField_a_of_type_JavaIoFile.getAbsolutePath()).a(advv.x(this.jdField_a_of_type_Advv), this.jdField_a_of_type_Advv.b);
                  bfhz.a(null, 40, 3);
                }
                catch (RemoteException paramAdapterView)
                {
                  if (QLog.isColorLevel()) {
                    QLog.e("AIOGalleryScene", 2, "", paramAdapterView);
                  }
                  bbmy.a(advv.z(this.jdField_a_of_type_Advv).getApplicationContext(), advv.A(this.jdField_a_of_type_Advv).getString(2131627263), 0).a();
                }
                break;
                label1272:
                new bfhl(paramAdapterView).a(advv.y(this.jdField_a_of_type_Advv), this.jdField_a_of_type_Advv.b);
              }
              paramInt = 8;
              OCRResultActivity.a(advv.B(this.jdField_a_of_type_Advv), this.jdField_a_of_type_JavaIoFile.getAbsolutePath(), 1);
              continue;
              int i = 6;
              if (this.jdField_a_of_type_Advv.jdField_h_of_type_Boolean)
              {
                if (QLog.isColorLevel()) {
                  QLog.i("EmoticonFromGroup_Manager", 2, "action sheet share weiyun.");
                }
                paramAdapterView = new Bundle();
                paramAdapterView.putString("pic_md5", this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOImageData.jdField_f_of_type_JavaLangString);
                QIPCClientHelper.getInstance().callServer("EmoticonIPCModule", "action_group_emo_big_pic_upload_wy", paramAdapterView, null);
                VasWebviewUtil.reportCommercialDrainage("", "QLbq", "MoreOp", "0", 1, 0, 0, "", "", "5", "", "", "", "", 0, 0, 0, 0);
                paramInt = 6;
              }
              else
              {
                paramInt = i;
                if (this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOImageData.jdField_f_of_type_Long > 0L)
                {
                  paramInt = i;
                  if (this.jdField_a_of_type_Advv.jdField_a_of_type_Adye.asBinder().pingBinder())
                  {
                    this.jdField_a_of_type_Advv.jdField_a_of_type_Adye.c(this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOImageData.jdField_f_of_type_Long);
                    bbmy.a(advv.C(this.jdField_a_of_type_Advv), advv.D(this.jdField_a_of_type_Advv).getString(2131627191), 0).a();
                    paramInt = 6;
                    continue;
                    paramAdapterView = this.jdField_a_of_type_Advv.d;
                    if (TextUtils.isEmpty(paramAdapterView)) {
                      paramAdapterView = this.jdField_a_of_type_Advv.jdField_c_of_type_JavaLangString;
                    }
                    for (;;)
                    {
                      awqx.b(null, "P_CliOper", "dwop_via", "", "0X8009BE3", "0X8009BE3", this.jdField_a_of_type_Advv.k, 0, "", "", "", "");
                      advv.a(advv.E(this.jdField_a_of_type_Advv), this.jdField_a_of_type_Advv.jdField_g_of_type_Int, this.jdField_a_of_type_Advv.jdField_c_of_type_JavaLangString, paramAdapterView, this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOImageData.jdField_g_of_type_Long, this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOImageData.i, this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOImageData.jdField_g_of_type_Int, false);
                      paramInt = 7;
                      break label142;
                      paramAdapterView = BaseApplicationImpl.getApplication().getRuntime();
                      if ((this.jdField_a_of_type_Advv.jdField_a_of_type_Adye == null) || (paramAdapterView == null)) {
                        break;
                      }
                      if (this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOImageData.jdField_j_of_type_Boolean)
                      {
                        this.jdField_a_of_type_Advv.jdField_a_of_type_Adye.a(this.jdField_a_of_type_Advv.jdField_g_of_type_Int, true, this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOImageData.m, this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOImageData.l, paramAdapterView.getAccount(), this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOImageData.n);
                        paramInt = 0;
                        break label142;
                      }
                      this.jdField_a_of_type_Advv.jdField_a_of_type_Adye.a(this.jdField_a_of_type_Advv.jdField_g_of_type_Int, false, this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOImageData.k, this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOImageData.l, paramAdapterView.getAccount(), this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOImageData.n);
                      paramInt = 0;
                      break label142;
                      PicShareToWX.a(this.jdField_a_of_type_JavaIoFile.getPath(), advv.F(this.jdField_a_of_type_Advv), 1);
                      awqx.b(null, "dc00898", "", "", "0X800A4FF", "0X800A4FF", 0, 0, "", "", "", "");
                      break;
                    }
                  }
                }
              }
            }
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     adwr
 * JD-Core Version:    0.7.0.1
 */