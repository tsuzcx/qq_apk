import android.app.Activity;
import android.content.Intent;
import android.os.IBinder;
import android.text.TextUtils;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.aio.photo.AIOShortVideoData;
import com.tencent.mobileqq.utils.ShareActionSheetBuilder;
import com.tencent.mobileqq.utils.ShareActionSheetBuilder.ActionSheetItem;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.io.File;
import mqq.app.AppRuntime;

class ahsl
  implements AdapterView.OnItemClickListener
{
  ahsl(ahsd paramahsd, AIOShortVideoData paramAIOShortVideoData, File paramFile, int paramInt, ahui paramahui) {}
  
  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    int i = 0;
    Object localObject = paramView.getTag();
    if (localObject == null) {}
    for (;;)
    {
      EventCollector.getInstance().onItemClick(paramAdapterView, paramView, paramInt, paramLong);
      return;
      this.jdField_a_of_type_Ahsd.jdField_a_of_type_ComTencentMobileqqUtilsShareActionSheetBuilder.dismiss();
      switch (((bgsa)localObject).a.action)
      {
      }
      for (;;)
      {
        localObject = this.jdField_a_of_type_Ahsd.jdField_a_of_type_Ahtj.a();
        if ((localObject == null) || (((ahui)localObject).a == null) || (!AIOShortVideoData.class.isInstance(((ahui)localObject).a))) {
          break;
        }
        localObject = (AIOShortVideoData)((ahui)localObject).a;
        if (((AIOShortVideoData)localObject).b != 0) {
          break label640;
        }
        bcst.b(null, "dc00898", "", "", "0X8009EF9", "0X8009EF9", i, 0, "", "", "", "");
        break;
        i = 1;
        ahsd.a(this.jdField_a_of_type_Ahsd, this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOShortVideoData);
        continue;
        if (QLog.isColorLevel()) {
          QLog.d("AIOGalleryScene", 2, "click menu to share to qzone");
        }
        localObject = blsi.a();
        ((blsi)localObject).a = this.jdField_a_of_type_Ahsd.b;
        blsb.c(ahsd.t(this.jdField_a_of_type_Ahsd), (blsi)localObject, this.jdField_a_of_type_JavaIoFile.getAbsolutePath(), 10001);
        bcst.b(null, "dc00898", "", "", "0X8007539", "0X8007539", 0, 0, "", "", "", "");
        i = 4;
        continue;
        ahsd.a(this.jdField_a_of_type_Ahsd, this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOShortVideoData, this.jdField_a_of_type_JavaIoFile, this.jdField_a_of_type_Int, this.jdField_a_of_type_Ahui);
        continue;
        bcst.b(null, "P_CliOper", "dwop_via", "", "0X8009BE4", "0X8009BE4", this.jdField_a_of_type_Ahsd.k, 0, "", "", "", "");
        String str = this.jdField_a_of_type_Ahsd.d;
        localObject = str;
        if (TextUtils.isEmpty(str)) {
          localObject = this.jdField_a_of_type_Ahsd.c;
        }
        ahsd.a(ahsd.u(this.jdField_a_of_type_Ahsd), this.jdField_a_of_type_Ahsd.jdField_g_of_type_Int, this.jdField_a_of_type_Ahsd.c, (String)localObject, this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOShortVideoData.jdField_g_of_type_Long, this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOShortVideoData.i, this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOShortVideoData.jdField_g_of_type_Int, false);
        i = 6;
        continue;
        int j = 3;
        i = j;
        if (this.jdField_a_of_type_Ahsd.jdField_a_of_type_Ahul.asBinder().pingBinder())
        {
          localObject = this.jdField_a_of_type_Ahsd.jdField_a_of_type_Ahul.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOShortVideoData.jdField_f_of_type_Long, this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOShortVideoData.jdField_f_of_type_Int, this.jdField_a_of_type_Ahsd.jdField_g_of_type_Int);
          i = j;
          if (localObject != null)
          {
            bljl.a((Intent)localObject).a(ahsd.v(this.jdField_a_of_type_Ahsd), BaseApplicationImpl.getApplication().getRuntime().getAccount());
            bljv.a(null, 3, 0, this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOShortVideoData.jdField_g_of_type_Int);
            bljv.a(BaseApplicationImpl.getApplication().getRuntime(), 6, 5);
            i = j;
            continue;
            i = 7;
            ahsd.b(this.jdField_a_of_type_Ahsd, this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOShortVideoData);
            continue;
            j = 6;
            i = j;
            if (this.jdField_a_of_type_Ahsd.jdField_a_of_type_Ahul.asBinder().pingBinder())
            {
              this.jdField_a_of_type_Ahsd.jdField_a_of_type_Ahul.c(this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOShortVideoData.jdField_f_of_type_Long);
              QQToast.a(ahsd.w(this.jdField_a_of_type_Ahsd), ahsd.x(this.jdField_a_of_type_Ahsd).getString(2131692439), 0).a();
              i = j;
            }
          }
        }
      }
      label640:
      if (((AIOShortVideoData)localObject).b == 1) {
        bcst.b(null, "dc00898", "", "", "0X8009EF8", "0X8009EF8", i, 0, "", "", "", "");
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ahsl
 * JD-Core Version:    0.7.0.1
 */