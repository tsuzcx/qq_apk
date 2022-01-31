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
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.LocalMultiProcConfig;
import cooperation.qzone.QZoneClickReport;
import java.io.File;

class adwe
  implements AdapterView.OnItemClickListener
{
  adwe(advv paramadvv, AIORichMediaData paramAIORichMediaData, boolean paramBoolean, File paramFile) {}
  
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
        awqx.b(null, "dc00898", "", "", paramAdapterView, paramAdapterView, paramInt, 0, "", "", "", "");
        return;
        i = 1;
        paramInt = i;
        if (!this.jdField_a_of_type_Advv.jdField_a_of_type_Adye.asBinder().pingBinder()) {
          break label130;
        }
        paramAdapterView = this.jdField_a_of_type_Advv.jdField_a_of_type_Adye.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData.jdField_f_of_type_Long, this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData.jdField_f_of_type_Int, 0);
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
          aphp.a(advv.Q(this.jdField_a_of_type_Advv), paramAdapterView, 103);
          paramInt = i;
          break;
        }
        label467:
        aphp.a(advv.R(this.jdField_a_of_type_Advv), paramAdapterView, 21);
        paramInt = i;
        break label130;
        if (LocalMultiProcConfig.getInt4Uin(this.jdField_a_of_type_Advv.b + "__qzone_pic_permission__" + this.jdField_a_of_type_Advv.d, -1, Long.valueOf(this.jdField_a_of_type_Advv.b).longValue()) == 0)
        {
          paramAdapterView = new bafb(advv.S(this.jdField_a_of_type_Advv), 2131690181);
          paramAdapterView.setContentView(2131493345);
          paramAdapterView.setTitle(advv.T(this.jdField_a_of_type_Advv).getString(2131632185));
          paramAdapterView.setMessage(advv.U(this.jdField_a_of_type_Advv).getString(2131632183));
          paramAdapterView.setNegativeButton(advv.V(this.jdField_a_of_type_Advv).getString(2131632184), new adwf(this));
          paramAdapterView.setCanceledOnTouchOutside(false);
          paramAdapterView.setCancelable(false);
          paramAdapterView.show();
          QZoneClickReport.startReportImediately(this.jdField_a_of_type_Advv.b, "40", "1");
          paramInt = 5;
          break label130;
        }
        paramAdapterView = (AIOImageData)this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData;
        this.jdField_a_of_type_Advv.a("Pic_Forward_Grpalbum", 0);
        adwz.a(advv.X(this.jdField_a_of_type_Advv), this.jdField_a_of_type_Advv.b, this.jdField_a_of_type_Advv.d, this.jdField_a_of_type_Advv.e, paramAdapterView.a, paramAdapterView.e, paramAdapterView.c, -1);
        paramInt = 5;
        break label130;
        if (this.jdField_a_of_type_Boolean) {}
        for (paramInt = 6;; paramInt = 5)
        {
          i = paramInt;
          if (!this.jdField_a_of_type_Advv.jdField_a_of_type_Adye.asBinder().pingBinder()) {
            break label1773;
          }
          this.jdField_a_of_type_Advv.jdField_a_of_type_Adye.c(this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData.jdField_f_of_type_Long);
          bbmy.a(advv.Y(this.jdField_a_of_type_Advv), advv.Z(this.jdField_a_of_type_Advv).getString(2131627191), 0).a();
          break;
        }
        if (!this.jdField_a_of_type_Advv.jdField_a_of_type_Adye.asBinder().pingBinder()) {
          break;
        }
        this.jdField_a_of_type_Advv.jdField_a_of_type_Adye.d(this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData.jdField_f_of_type_Long);
        awqx.b(null, "dc00898", "", "", "0X800A60E", "0X800A60E", 0, 0, "", "", "", "");
        bbmy.a(advv.aa(this.jdField_a_of_type_Advv), 2, advv.ab(this.jdField_a_of_type_Advv).getString(2131627117), 0).a();
        paramInt = -1;
        break label130;
        i = 2;
        if (AIOFilePicData.class.isInstance(this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData))
        {
          adwz.a(advv.ac(this.jdField_a_of_type_Advv), this.jdField_a_of_type_JavaIoFile, Utils.Crc64String(this.jdField_a_of_type_JavaIoFile.getAbsolutePath()));
          paramInt = i;
          break label130;
        }
        if (AIOFileVideoData.class.isInstance(this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData))
        {
          paramAdapterView = new Bundle();
          float f = 0.0F;
          if (agfb.class.isInstance(this.jdField_a_of_type_Advv.jdField_a_of_type_Agez)) {
            f = ((agfb)this.jdField_a_of_type_Advv.jdField_a_of_type_Agez).a(this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData.jdField_f_of_type_Long);
          }
          paramAdapterView.putFloat("progress", f);
          this.jdField_a_of_type_Advv.jdField_a_of_type_Adye.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData.jdField_f_of_type_Long, 13, paramAdapterView);
          ((AIOFileVideoData)this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData).d = true;
          this.jdField_a_of_type_Advv.jdField_a_of_type_Agez.h();
          this.jdField_a_of_type_Advv.u();
          paramInt = i;
          break label130;
        }
        paramInt = i;
        if (!AIOImageData.class.isInstance(this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData)) {
          break label130;
        }
        if ((this.jdField_a_of_type_JavaIoFile != null) && (this.jdField_a_of_type_JavaIoFile.exists()))
        {
          adwz.a(advv.ad(this.jdField_a_of_type_Advv), this.jdField_a_of_type_JavaIoFile, Utils.Crc64String(this.jdField_a_of_type_JavaIoFile.getAbsolutePath()));
          paramInt = i;
          break label130;
        }
        QLog.i("AIOGalleryScene", 1, "menu item click, troop file action AIOGallerysence, but file is null");
        paramInt = i;
        break label130;
        i = 3;
        if (!this.jdField_a_of_type_Advv.jdField_a_of_type_Adye.asBinder().pingBinder()) {
          break label1773;
        }
        this.jdField_a_of_type_Advv.jdField_a_of_type_Adye.e(this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData.jdField_f_of_type_Long);
        paramInt = 3;
        break label130;
        if (this.jdField_a_of_type_Boolean) {}
        for (paramInt = 7;; paramInt = 6)
        {
          paramView = this.jdField_a_of_type_Advv.d;
          paramAdapterView = paramView;
          if (TextUtils.isEmpty(paramView)) {
            paramAdapterView = this.jdField_a_of_type_Advv.c;
          }
          advv.a(advv.ae(this.jdField_a_of_type_Advv), this.jdField_a_of_type_Advv.jdField_g_of_type_Int, this.jdField_a_of_type_Advv.c, paramAdapterView, this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData.jdField_g_of_type_Long, this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData.i, this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData.jdField_g_of_type_Int, false);
          break;
        }
        OCRResultActivity.a(advv.af(this.jdField_a_of_type_Advv), this.jdField_a_of_type_JavaIoFile.getAbsolutePath(), 1);
        paramInt = 8;
        break label130;
        paramView = new Intent();
        paramView.putExtra("preResult", paramAdapterView);
        if (AIOImageData.class.isInstance(this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData))
        {
          paramAdapterView = (AIOImageData)this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData;
          this.jdField_a_of_type_Advv.a(this.jdField_a_of_type_Advv.f, paramAdapterView.jdField_g_of_type_Int, paramAdapterView.h, paramAdapterView.k, paramAdapterView.f, paramAdapterView.j, paramAdapterView.e, 1, paramView);
        }
        while (!AIOFilePicData.class.isInstance(this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData))
        {
          awqx.b(null, "P_CliOper", "qrcode", "", "0X80059A4", "0X80059A4", 0, 0, "", "", "", "");
          paramInt = 9;
          break;
        }
        Object localObject = (AIOFilePicData)this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData;
        if (bado.a(((AIOFilePicData)localObject).b)) {}
        for (paramAdapterView = this.jdField_a_of_type_Advv.b;; paramAdapterView = this.jdField_a_of_type_Advv.c)
        {
          this.jdField_a_of_type_Advv.a(this.jdField_a_of_type_Advv.f, ((AIOFilePicData)localObject).a, true, paramAdapterView, null, null, ((AIOFilePicData)localObject).h, 1, paramView);
          break;
        }
        paramView = new Intent();
        paramView.putExtra("preResult", paramAdapterView);
        if (AIOImageData.class.isInstance(this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData))
        {
          paramAdapterView = (AIOImageData)this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData;
          this.jdField_a_of_type_Advv.a(this.jdField_a_of_type_Advv.f, paramAdapterView.jdField_g_of_type_Int, paramAdapterView.h, paramAdapterView.k, paramAdapterView.f, paramAdapterView.j, paramAdapterView.e, 2, paramView);
        }
        while (!AIOFilePicData.class.isInstance(this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData))
        {
          paramInt = 10;
          break;
        }
        localObject = (AIOFilePicData)this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData;
        if (bado.a(((AIOFilePicData)localObject).b)) {}
        for (paramAdapterView = this.jdField_a_of_type_Advv.b;; paramAdapterView = this.jdField_a_of_type_Advv.c)
        {
          this.jdField_a_of_type_Advv.a(this.jdField_a_of_type_Advv.f, ((AIOFilePicData)localObject).a, true, paramAdapterView, null, null, ((AIOFilePicData)localObject).h, 2, paramView);
          break;
        }
        paramInt = 11;
        paramAdapterView = (AIOFileVideoData)this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData;
        apck.b(advv.ag(this.jdField_a_of_type_Advv), paramAdapterView.c);
        break label130;
        PicShareToWX.a(this.jdField_a_of_type_JavaIoFile.getPath(), advv.ah(this.jdField_a_of_type_Advv), 1);
        awqx.b(null, "dc00898", "", "", "0X800A4FF", "0X800A4FF", 0, 0, "", "", "", "");
        break;
      }
      label1773:
      paramInt = i;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     adwe
 * JD-Core Version:    0.7.0.1
 */