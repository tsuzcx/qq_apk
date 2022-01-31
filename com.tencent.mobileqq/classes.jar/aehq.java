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

class aehq
  implements AdapterView.OnItemClickListener
{
  aehq(aegu paramaegu, AIOImageData paramAIOImageData, aeja paramaeja, File paramFile) {}
  
  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    paramAdapterView = paramView.getTag();
    if (paramAdapterView == null) {
      return;
    }
    this.jdField_a_of_type_Aegu.jdField_a_of_type_Bbjc.b();
    paramAdapterView = ((bbjh)paramAdapterView).a;
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
      axqw.b(null, "dc00898", "", "", "0X8009EF6", "0X8009EF6", paramInt, 0, "", "", "", "");
      return;
      paramInt = 12;
      if (QLog.isColorLevel()) {
        QLog.i("EmoticonFromGroup_Manager", 2, "action sheet add to favorite.");
      }
      paramAdapterView = new Bundle();
      paramAdapterView.putString("pic_md5", this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOImageData.jdField_f_of_type_JavaLangString);
      paramView = new aehr(this);
      QIPCClientHelper.getInstance().callServer("EmoticonIPCModule", "action_group_emo_big_pic_add_fav", paramAdapterView, paramView);
      if (this.jdField_a_of_type_Aegu.jdField_h_of_type_Boolean)
      {
        VasWebviewUtil.reportCommercialDrainage("", "QLbq", "MoreOp", "0", 1, 0, 0, "", "", "1", "", "", "", "", 0, 0, 0, 0);
        paramInt = 12;
        continue;
        paramInt = 1;
        this.jdField_a_of_type_Aegu.a("Pic_Forward_Contacts", 0);
        this.jdField_a_of_type_Aegu.a(this.jdField_a_of_type_Aeja, aegu.o(this.jdField_a_of_type_Aegu), 0);
        if (this.jdField_a_of_type_Aegu.jdField_h_of_type_Boolean) {
          VasWebviewUtil.reportCommercialDrainage("", "QLbq", "MoreOp", "0", 1, 0, 0, "", "", "2", "", "", "", "", 0, 0, 0, 0);
        }
        if (this.jdField_a_of_type_Aegu.jdField_c_of_type_Boolean)
        {
          asuf.a("0X8009ABA");
          paramInt = 1;
          continue;
          paramInt = 4;
          this.jdField_a_of_type_Aegu.a("Pic_Forward_Qzone", 0);
          aehy.a(aegu.p(this.jdField_a_of_type_Aegu), this.jdField_a_of_type_Aegu.b, this.jdField_a_of_type_Aegu.e, this.jdField_a_of_type_Aegu.jdField_f_of_type_Int, this.jdField_a_of_type_Aeja, this.jdField_a_of_type_Aegu.i, this.jdField_a_of_type_Aegu.d);
          if (this.jdField_a_of_type_Aegu.jdField_h_of_type_Boolean)
          {
            VasWebviewUtil.reportCommercialDrainage("", "QLbq", "MoreOp", "0", 1, 0, 0, "", "", "4", "", "", "", "", 0, 0, 0, 0);
            paramInt = 4;
            continue;
            if (LocalMultiProcConfig.getInt4Uin(this.jdField_a_of_type_Aegu.b + "__qzone_pic_permission__" + this.jdField_a_of_type_Aegu.d, -1, Long.valueOf(this.jdField_a_of_type_Aegu.b).longValue()) == 0)
            {
              paramAdapterView = new bbgg(aegu.q(this.jdField_a_of_type_Aegu), 2131755791);
              paramAdapterView.setContentView(2131558906);
              paramAdapterView.setTitle(aegu.r(this.jdField_a_of_type_Aegu).getString(2131697910));
              paramAdapterView.setMessage(aegu.s(this.jdField_a_of_type_Aegu).getString(2131697908));
              paramAdapterView.setNegativeButton(aegu.t(this.jdField_a_of_type_Aegu).getString(2131697909), new aehs(this));
              paramAdapterView.setCanceledOnTouchOutside(false);
              paramAdapterView.setCancelable(false);
              paramAdapterView.show();
              QZoneClickReport.startReportImediately(this.jdField_a_of_type_Aegu.b, "40", "1");
              paramInt = 5;
            }
            else
            {
              this.jdField_a_of_type_Aegu.a("Pic_Forward_Grpalbum", 0);
              aehy.a(aegu.v(this.jdField_a_of_type_Aegu), this.jdField_a_of_type_Aegu.b, this.jdField_a_of_type_Aegu.d, this.jdField_a_of_type_Aegu.e, this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOImageData.a, this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOImageData.e, this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOImageData.c, -1);
              paramInt = 5;
              continue;
              paramInt = 2;
              this.jdField_a_of_type_Aegu.a("Pic_save", 0);
              if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOImageData.a(4) == null) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOImageData.a(4)) && (AppNetConnInfo.isNetSupport())) {
                if ((!AppNetConnInfo.isWifiConn()) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOImageData.jdField_h_of_type_Long > 29360128L)) {
                  this.jdField_a_of_type_Aegu.a(1, this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOImageData, this.jdField_a_of_type_Aeja);
                }
              }
              for (;;)
              {
                this.jdField_a_of_type_Aegu.a(this.jdField_a_of_type_JavaIoFile.getAbsolutePath(), 55);
                if (this.jdField_a_of_type_Aegu.jdField_h_of_type_Boolean) {
                  VasWebviewUtil.reportCommercialDrainage("", "QLbq", "MoreOp", "0", 1, 0, 0, "", "", "3", "", "", "", "", 0, 0, 0, 0);
                }
                if (!this.jdField_a_of_type_Aegu.jdField_c_of_type_Boolean) {
                  break label1809;
                }
                asuf.a("0X8009ABB");
                paramInt = 2;
                break;
                aegu.a(this.jdField_a_of_type_Aegu, this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOImageData, this.jdField_a_of_type_Aeja);
                this.jdField_a_of_type_Aeja.jdField_a_of_type_Aejb.e = true;
                this.jdField_a_of_type_Aegu.u();
                continue;
                aehy.a(aegu.w(this.jdField_a_of_type_Aegu), this.jdField_a_of_type_JavaIoFile, Utils.Crc64String(this.jdField_a_of_type_JavaIoFile.getAbsolutePath() + NetConnInfoCenter.getServerTime()));
              }
              paramView = new Intent();
              paramView.putExtra("preResult", paramAdapterView);
              this.jdField_a_of_type_Aegu.a(this.jdField_a_of_type_Aegu.jdField_f_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOImageData.jdField_g_of_type_Int, this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOImageData.jdField_h_of_type_Boolean, this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOImageData.k, this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOImageData.jdField_f_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOImageData.jdField_j_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOImageData.e, 1, paramView);
              axqw.b(null, "P_CliOper", "qrcode", "", "0X80059A4", "0X80059A4", 0, 0, "", "", "", "");
              paramInt = 9;
              continue;
              paramView = new Intent();
              paramView.putExtra("preResult", paramAdapterView);
              this.jdField_a_of_type_Aegu.a(this.jdField_a_of_type_Aegu.jdField_f_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOImageData.jdField_g_of_type_Int, this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOImageData.jdField_h_of_type_Boolean, this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOImageData.k, this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOImageData.jdField_f_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOImageData.jdField_j_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOImageData.e, 2, paramView);
              paramInt = 10;
              continue;
              paramInt = 3;
              for (;;)
              {
                try
                {
                  paramAdapterView = this.jdField_a_of_type_Aegu.jdField_a_of_type_Aejd.a(this.jdField_a_of_type_Aeja.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData.jdField_f_of_type_Long, this.jdField_a_of_type_Aeja.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData.jdField_f_of_type_Int);
                  if (paramAdapterView != null) {
                    break label1272;
                  }
                  bgpd.b(this.jdField_a_of_type_JavaIoFile.getAbsolutePath()).a(aegu.x(this.jdField_a_of_type_Aegu), this.jdField_a_of_type_Aegu.b);
                  bgpr.a(null, 40, 3);
                }
                catch (RemoteException paramAdapterView)
                {
                  if (QLog.isColorLevel()) {
                    QLog.e("AIOGalleryScene", 2, "", paramAdapterView);
                  }
                  bcpw.a(aegu.z(this.jdField_a_of_type_Aegu).getApplicationContext(), aegu.A(this.jdField_a_of_type_Aegu).getString(2131692901), 0).a();
                }
                break;
                label1272:
                new bgpd(paramAdapterView).a(aegu.y(this.jdField_a_of_type_Aegu), this.jdField_a_of_type_Aegu.b);
              }
              paramInt = 8;
              OCRResultActivity.a(aegu.B(this.jdField_a_of_type_Aegu), this.jdField_a_of_type_JavaIoFile.getAbsolutePath(), 1);
              continue;
              int i = 6;
              if (this.jdField_a_of_type_Aegu.jdField_h_of_type_Boolean)
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
                  if (this.jdField_a_of_type_Aegu.jdField_a_of_type_Aejd.asBinder().pingBinder())
                  {
                    this.jdField_a_of_type_Aegu.jdField_a_of_type_Aejd.c(this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOImageData.jdField_f_of_type_Long);
                    bcpw.a(aegu.C(this.jdField_a_of_type_Aegu), aegu.D(this.jdField_a_of_type_Aegu).getString(2131692829), 0).a();
                    paramInt = 6;
                    continue;
                    paramAdapterView = this.jdField_a_of_type_Aegu.d;
                    if (TextUtils.isEmpty(paramAdapterView)) {
                      paramAdapterView = this.jdField_a_of_type_Aegu.jdField_c_of_type_JavaLangString;
                    }
                    for (;;)
                    {
                      axqw.b(null, "P_CliOper", "dwop_via", "", "0X8009BE3", "0X8009BE3", this.jdField_a_of_type_Aegu.k, 0, "", "", "", "");
                      aegu.a(aegu.E(this.jdField_a_of_type_Aegu), this.jdField_a_of_type_Aegu.jdField_g_of_type_Int, this.jdField_a_of_type_Aegu.jdField_c_of_type_JavaLangString, paramAdapterView, this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOImageData.jdField_g_of_type_Long, this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOImageData.i, this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOImageData.jdField_g_of_type_Int, false);
                      paramInt = 7;
                      break label142;
                      paramAdapterView = BaseApplicationImpl.getApplication().getRuntime();
                      if ((this.jdField_a_of_type_Aegu.jdField_a_of_type_Aejd == null) || (paramAdapterView == null)) {
                        break;
                      }
                      if (this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOImageData.jdField_j_of_type_Boolean)
                      {
                        this.jdField_a_of_type_Aegu.jdField_a_of_type_Aejd.a(this.jdField_a_of_type_Aegu.jdField_g_of_type_Int, true, this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOImageData.m, this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOImageData.l, paramAdapterView.getAccount(), this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOImageData.n);
                        paramInt = 0;
                        break label142;
                      }
                      this.jdField_a_of_type_Aegu.jdField_a_of_type_Aejd.a(this.jdField_a_of_type_Aegu.jdField_g_of_type_Int, false, this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOImageData.k, this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOImageData.l, paramAdapterView.getAccount(), this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOImageData.n);
                      paramInt = 0;
                      break label142;
                      PicShareToWX.a(this.jdField_a_of_type_JavaIoFile.getPath(), aegu.F(this.jdField_a_of_type_Aegu), 1);
                      axqw.b(null, "dc00898", "", "", "0X800A4FF", "0X800A4FF", 0, 0, "", "", "", "");
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
 * Qualified Name:     aehq
 * JD-Core Version:    0.7.0.1
 */