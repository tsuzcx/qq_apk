import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.IBinder;
import android.text.TextUtils;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import com.tencent.image.Utils;
import com.tencent.mobileqq.activity.aio.photo.AIOFilePicData;
import com.tencent.mobileqq.activity.aio.photo.AIOFileVideoData;
import com.tencent.mobileqq.activity.aio.photo.AIOImageData;
import com.tencent.mobileqq.activity.aio.photo.AIORichMediaData;
import com.tencent.mobileqq.filemanager.data.ForwardFileInfo;
import com.tencent.mobileqq.ocr.OCRResultActivity;
import com.tencent.mobileqq.pic.PicShareToWX;
import com.tencent.mobileqq.utils.ShareActionSheetBuilder;
import com.tencent.mobileqq.utils.ShareActionSheetBuilder.ActionSheetItem;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.LocalMultiProcConfig;
import cooperation.qzone.QZoneClickReport;
import java.io.File;

class agdr
  implements AdapterView.OnItemClickListener
{
  agdr(agdi paramagdi, AIORichMediaData paramAIORichMediaData, boolean paramBoolean, File paramFile) {}
  
  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    paramAdapterView = paramView.getTag();
    if (paramAdapterView == null) {
      return;
    }
    this.jdField_a_of_type_Agdi.jdField_a_of_type_ComTencentMobileqqUtilsShareActionSheetBuilder.dismiss();
    paramAdapterView = ((bdip)paramAdapterView).a;
    paramInt = paramAdapterView.action;
    paramAdapterView = paramAdapterView.argus;
    switch (paramInt)
    {
    case 60: 
    case 61: 
    case 62: 
    case 63: 
    case 65: 
    case 66: 
    case 68: 
    default: 
      paramInt = -1;
    }
    for (;;)
    {
      label130:
      if (this.jdField_a_of_type_Boolean) {}
      int i;
      for (paramAdapterView = "0X8009EF7";; paramAdapterView = "0X8009EFA")
      {
        azmj.b(null, "dc00898", "", "", paramAdapterView, paramAdapterView, paramInt, 0, "", "", "", "");
        return;
        i = 1;
        paramInt = i;
        if (!this.jdField_a_of_type_Agdi.jdField_a_of_type_Agft.asBinder().pingBinder()) {
          break label130;
        }
        paramAdapterView = this.jdField_a_of_type_Agdi.jdField_a_of_type_Agft.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData.jdField_f_of_type_Long, this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData.jdField_f_of_type_Int, 0);
        if (paramAdapterView == null)
        {
          QLog.w("AIOGalleryScene", 1, "getForwardData return null from main process");
          return;
        }
        paramAdapterView.setExtrasClassLoader(ForwardFileInfo.class.getClassLoader());
        if (this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData.jdField_g_of_type_Int == 1) {}
        for (paramInt = 1;; paramInt = 0)
        {
          if (paramInt != 0) {
            break label467;
          }
          paramAdapterView.putExtra("filepictest", true);
          paramView = (ForwardFileInfo)paramAdapterView.getParcelableExtra("fileinfo");
          localObject = paramAdapterView.getStringExtra("forward_filepath");
          boolean bool1 = paramAdapterView.getBooleanExtra("k_favorites", false);
          String str = paramAdapterView.getStringExtra("forward_text");
          boolean bool2 = paramAdapterView.getBooleanExtra("isFromShare", false);
          paramInt = paramAdapterView.getIntExtra("forward_type", 0);
          Intent localIntent = new Intent();
          localIntent.setExtrasClassLoader(ForwardFileInfo.class.getClassLoader());
          Bundle localBundle = new Bundle();
          localBundle.putInt("forward_type", paramInt);
          localBundle.putParcelable("fileinfo", paramView);
          localBundle.putBoolean("not_forward", true);
          localIntent.putExtras(localBundle);
          localIntent.putExtra("forward_filepath", (String)localObject);
          localIntent.putExtra("forward_text", str);
          localIntent.putExtra("k_favorites", bool1);
          localIntent.putExtra("isFromShare", bool2);
          if (AIOFilePicData.class.isInstance(paramAdapterView))
          {
            localIntent.putExtra("isPic", true);
            localIntent.putExtra("direct_send_if_dataline_forward", true);
          }
          arum.a(agdi.Q(this.jdField_a_of_type_Agdi), paramAdapterView, 103);
          paramInt = i;
          break;
        }
        label467:
        arum.a(agdi.R(this.jdField_a_of_type_Agdi), paramAdapterView, 21);
        paramInt = i;
        break label130;
        if (LocalMultiProcConfig.getInt4Uin(this.jdField_a_of_type_Agdi.b + "__qzone_pic_permission__" + this.jdField_a_of_type_Agdi.d, -1, Long.valueOf(this.jdField_a_of_type_Agdi.b).longValue()) == 0)
        {
          paramAdapterView = new bdfq(agdi.S(this.jdField_a_of_type_Agdi), 2131755801);
          paramAdapterView.setContentView(2131558943);
          paramAdapterView.setTitle(agdi.T(this.jdField_a_of_type_Agdi).getString(2131698097));
          paramAdapterView.setMessage(agdi.U(this.jdField_a_of_type_Agdi).getString(2131698095));
          paramAdapterView.setNegativeButton(agdi.V(this.jdField_a_of_type_Agdi).getString(2131698096), new agds(this));
          paramAdapterView.setCanceledOnTouchOutside(false);
          paramAdapterView.setCancelable(false);
          paramAdapterView.show();
          QZoneClickReport.startReportImediately(this.jdField_a_of_type_Agdi.b, "40", "1");
          paramInt = 5;
          break label130;
        }
        paramAdapterView = (AIOImageData)this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData;
        this.jdField_a_of_type_Agdi.a("Pic_Forward_Grpalbum", 0);
        agem.a(agdi.X(this.jdField_a_of_type_Agdi), this.jdField_a_of_type_Agdi.b, this.jdField_a_of_type_Agdi.d, this.jdField_a_of_type_Agdi.e, paramAdapterView.a, paramAdapterView.e, paramAdapterView.c, -1);
        paramInt = 5;
        break label130;
        if (this.jdField_a_of_type_Boolean) {}
        for (paramInt = 6;; paramInt = 5)
        {
          i = paramInt;
          if (!this.jdField_a_of_type_Agdi.jdField_a_of_type_Agft.asBinder().pingBinder()) {
            break label1774;
          }
          this.jdField_a_of_type_Agdi.jdField_a_of_type_Agft.c(this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData.jdField_f_of_type_Long);
          QQToast.a(agdi.Y(this.jdField_a_of_type_Agdi), agdi.Z(this.jdField_a_of_type_Agdi).getString(2131692912), 0).a();
          break;
        }
        if (!this.jdField_a_of_type_Agdi.jdField_a_of_type_Agft.asBinder().pingBinder()) {
          break;
        }
        this.jdField_a_of_type_Agdi.jdField_a_of_type_Agft.d(this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData.jdField_f_of_type_Long);
        azmj.b(null, "dc00898", "", "", "0X800A60E", "0X800A60E", 0, 0, "", "", "", "");
        QQToast.a(agdi.aa(this.jdField_a_of_type_Agdi), 2, agdi.ab(this.jdField_a_of_type_Agdi).getString(2131692838), 0).a();
        paramInt = -1;
        break label130;
        i = 2;
        if (AIOFilePicData.class.isInstance(this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData))
        {
          agem.a(agdi.ac(this.jdField_a_of_type_Agdi), this.jdField_a_of_type_JavaIoFile, Utils.Crc64String(this.jdField_a_of_type_JavaIoFile.getAbsolutePath()));
          paramInt = i;
          break label130;
        }
        if (AIOFileVideoData.class.isInstance(this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData))
        {
          paramAdapterView = new Bundle();
          float f = 0.0F;
          if (ailv.class.isInstance(this.jdField_a_of_type_Agdi.jdField_a_of_type_Ailt)) {
            f = ((ailv)this.jdField_a_of_type_Agdi.jdField_a_of_type_Ailt).a(this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData.jdField_f_of_type_Long);
          }
          paramAdapterView.putFloat("progress", f);
          this.jdField_a_of_type_Agdi.jdField_a_of_type_Agft.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData.jdField_f_of_type_Long, 13, paramAdapterView);
          ((AIOFileVideoData)this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData).d = true;
          this.jdField_a_of_type_Agdi.jdField_a_of_type_Ailt.h();
          this.jdField_a_of_type_Agdi.u();
          paramInt = i;
          break label130;
        }
        paramInt = i;
        if (!AIOImageData.class.isInstance(this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData)) {
          break label130;
        }
        if ((this.jdField_a_of_type_JavaIoFile != null) && (this.jdField_a_of_type_JavaIoFile.exists()))
        {
          agem.a(agdi.ad(this.jdField_a_of_type_Agdi), this.jdField_a_of_type_JavaIoFile, Utils.Crc64String(this.jdField_a_of_type_JavaIoFile.getAbsolutePath()));
          paramInt = i;
          break label130;
        }
        QLog.i("AIOGalleryScene", 1, "menu item click, troop file action AIOGallerysence, but file is null");
        paramInt = i;
        break label130;
        i = 3;
        if (!this.jdField_a_of_type_Agdi.jdField_a_of_type_Agft.asBinder().pingBinder()) {
          break label1774;
        }
        this.jdField_a_of_type_Agdi.jdField_a_of_type_Agft.e(this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData.jdField_f_of_type_Long);
        paramInt = 3;
        break label130;
        if (this.jdField_a_of_type_Boolean) {}
        for (paramInt = 7;; paramInt = 6)
        {
          paramView = this.jdField_a_of_type_Agdi.d;
          paramAdapterView = paramView;
          if (TextUtils.isEmpty(paramView)) {
            paramAdapterView = this.jdField_a_of_type_Agdi.c;
          }
          agdi.a(agdi.ae(this.jdField_a_of_type_Agdi), this.jdField_a_of_type_Agdi.jdField_g_of_type_Int, this.jdField_a_of_type_Agdi.c, paramAdapterView, this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData.jdField_g_of_type_Long, this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData.i, this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData.jdField_g_of_type_Int, false);
          break;
        }
        OCRResultActivity.a(agdi.af(this.jdField_a_of_type_Agdi), this.jdField_a_of_type_JavaIoFile.getAbsolutePath(), 1);
        paramInt = 8;
        break label130;
        paramView = new Intent();
        paramView.putExtra("preResult", paramAdapterView);
        if (AIOImageData.class.isInstance(this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData))
        {
          paramAdapterView = (AIOImageData)this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData;
          this.jdField_a_of_type_Agdi.a(this.jdField_a_of_type_Agdi.f, paramAdapterView.jdField_g_of_type_Int, paramAdapterView.h, paramAdapterView.k, paramAdapterView.f, paramAdapterView.j, paramAdapterView.e, 1, paramView);
        }
        while (!AIOFilePicData.class.isInstance(this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData))
        {
          azmj.b(null, "P_CliOper", "qrcode", "", "0X80059A4", "0X80059A4", 0, 0, "", "", "", "");
          paramInt = 9;
          break;
        }
        Object localObject = (AIOFilePicData)this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData;
        if (bdec.a(((AIOFilePicData)localObject).b)) {}
        for (paramAdapterView = this.jdField_a_of_type_Agdi.b;; paramAdapterView = this.jdField_a_of_type_Agdi.c)
        {
          this.jdField_a_of_type_Agdi.a(this.jdField_a_of_type_Agdi.f, ((AIOFilePicData)localObject).a, true, paramAdapterView, null, null, ((AIOFilePicData)localObject).h, 1, paramView);
          break;
        }
        paramView = new Intent();
        paramView.putExtra("preResult", paramAdapterView);
        if (AIOImageData.class.isInstance(this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData))
        {
          paramAdapterView = (AIOImageData)this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData;
          this.jdField_a_of_type_Agdi.a(this.jdField_a_of_type_Agdi.f, paramAdapterView.jdField_g_of_type_Int, paramAdapterView.h, paramAdapterView.k, paramAdapterView.f, paramAdapterView.j, paramAdapterView.e, 2, paramView);
        }
        while (!AIOFilePicData.class.isInstance(this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData))
        {
          paramInt = 10;
          break;
        }
        localObject = (AIOFilePicData)this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData;
        if (bdec.a(((AIOFilePicData)localObject).b)) {}
        for (paramAdapterView = this.jdField_a_of_type_Agdi.b;; paramAdapterView = this.jdField_a_of_type_Agdi.c)
        {
          this.jdField_a_of_type_Agdi.a(this.jdField_a_of_type_Agdi.f, ((AIOFilePicData)localObject).a, true, paramAdapterView, null, null, ((AIOFilePicData)localObject).h, 2, paramView);
          break;
        }
        paramInt = 11;
        paramAdapterView = (AIOFileVideoData)this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData;
        arni.a(agdi.ag(this.jdField_a_of_type_Agdi), paramAdapterView.c);
        break label130;
        PicShareToWX.a(this.jdField_a_of_type_JavaIoFile.getPath(), agdi.ah(this.jdField_a_of_type_Agdi), 1);
        azmj.b(null, "dc00898", "", "", "0X800A4FF", "0X800A4FF", 0, 0, "", "", "", "");
        break;
      }
      label1774:
      paramInt = i;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     agdr
 * JD-Core Version:    0.7.0.1
 */