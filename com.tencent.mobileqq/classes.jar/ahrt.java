import android.app.Activity;
import android.os.IBinder;
import android.text.TextUtils;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import com.tencent.mobileqq.activity.aio.photo.AIOFileVideoData;
import com.tencent.mobileqq.activity.aio.photo.AIORichMediaData;
import com.tencent.mobileqq.ocr.OCRResultActivity;
import com.tencent.mobileqq.pic.PicShareToWX;
import com.tencent.mobileqq.utils.ShareActionSheetBuilder;
import com.tencent.mobileqq.utils.ShareActionSheetBuilder.ActionSheetItem;
import com.tencent.mobileqq.utils.ShareActionSheetBuilder.ActionSheetItemViewHolder;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.io.File;

class ahrt
  implements AdapterView.OnItemClickListener
{
  ahrt(ahri paramahri, AIORichMediaData paramAIORichMediaData, boolean paramBoolean, File paramFile) {}
  
  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    Object localObject = paramView.getTag();
    if (localObject == null)
    {
      EventCollector.getInstance().onItemClick(paramAdapterView, paramView, paramInt, paramLong);
      return;
    }
    this.jdField_a_of_type_Ahri.jdField_a_of_type_ComTencentMobileqqUtilsShareActionSheetBuilder.dismiss();
    localObject = ((ShareActionSheetBuilder.ActionSheetItemViewHolder)localObject).sheetItem;
    int i = ((ShareActionSheetBuilder.ActionSheetItem)localObject).action;
    localObject = ((ShareActionSheetBuilder.ActionSheetItem)localObject).argus;
    switch (i)
    {
    case 60: 
    case 61: 
    case 62: 
    case 63: 
    case 65: 
    case 66: 
    case 68: 
    default: 
      label148:
      i = -1;
    }
    for (;;)
    {
      label151:
      if (this.jdField_a_of_type_Boolean) {}
      int j;
      for (localObject = "0X8009EF7";; localObject = "0X8009EFA")
      {
        bdla.b(null, "dc00898", "", "", (String)localObject, (String)localObject, i, 0, "", "", "", "");
        break;
        ahri.a(this.jdField_a_of_type_Ahri, this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData);
        i = 1;
        break label151;
        ahri.b(this.jdField_a_of_type_Ahri, this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData);
        i = 5;
        break label151;
        if (this.jdField_a_of_type_Boolean) {}
        for (i = 6;; i = 5)
        {
          j = i;
          if (!this.jdField_a_of_type_Ahri.jdField_a_of_type_Ahtp.asBinder().pingBinder()) {
            break label727;
          }
          this.jdField_a_of_type_Ahri.jdField_a_of_type_Ahtp.c(this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData.f);
          QQToast.a(ahri.A(this.jdField_a_of_type_Ahri), ahri.B(this.jdField_a_of_type_Ahri).getString(2131692595), 0).a();
          break;
        }
        if (!this.jdField_a_of_type_Ahri.jdField_a_of_type_Ahtp.asBinder().pingBinder()) {
          break label148;
        }
        this.jdField_a_of_type_Ahri.jdField_a_of_type_Ahtp.d(this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData.f);
        bdla.b(null, "dc00898", "", "", "0X800A60E", "0X800A60E", 0, 0, "", "", "", "");
        QQToast.a(ahri.C(this.jdField_a_of_type_Ahri), 2, ahri.D(this.jdField_a_of_type_Ahri).getString(2131692551), 0).a();
        i = -1;
        break label151;
        ahri.a(this.jdField_a_of_type_Ahri, this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData, this.jdField_a_of_type_JavaIoFile);
        i = 2;
        break label151;
        j = 3;
        if (!this.jdField_a_of_type_Ahri.jdField_a_of_type_Ahtp.asBinder().pingBinder()) {
          break label727;
        }
        this.jdField_a_of_type_Ahri.jdField_a_of_type_Ahtp.e(this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData.f);
        i = 3;
        break label151;
        if (this.jdField_a_of_type_Boolean) {}
        for (i = 7;; i = 6)
        {
          String str = this.jdField_a_of_type_Ahri.d;
          localObject = str;
          if (TextUtils.isEmpty(str)) {
            localObject = this.jdField_a_of_type_Ahri.c;
          }
          ahri.a(ahri.E(this.jdField_a_of_type_Ahri), this.jdField_a_of_type_Ahri.jdField_g_of_type_Int, this.jdField_a_of_type_Ahri.c, (String)localObject, this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData.jdField_g_of_type_Long, this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData.i, this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData.jdField_g_of_type_Int, false);
          break;
        }
        OCRResultActivity.a(ahri.F(this.jdField_a_of_type_Ahri), this.jdField_a_of_type_JavaIoFile.getAbsolutePath(), 1);
        i = 8;
        break label151;
        ahri.a(this.jdField_a_of_type_Ahri, this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData, (String)localObject);
        i = 9;
        break label151;
        ahri.b(this.jdField_a_of_type_Ahri, this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData, (String)localObject);
        i = 10;
        break label151;
        i = 11;
        localObject = (AIOFileVideoData)this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData;
        auea.a(ahri.G(this.jdField_a_of_type_Ahri), ((AIOFileVideoData)localObject).c);
        break label151;
        PicShareToWX.a(this.jdField_a_of_type_JavaIoFile.getPath(), ahri.H(this.jdField_a_of_type_Ahri), 1);
        bdla.b(null, "dc00898", "", "", "0X800A4FF", "0X800A4FF", 0, 0, "", "", "", "");
        break label148;
      }
      label727:
      i = j;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ahrt
 * JD-Core Version:    0.7.0.1
 */