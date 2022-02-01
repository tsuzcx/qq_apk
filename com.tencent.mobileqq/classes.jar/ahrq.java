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
import com.tencent.mobileqq.utils.ShareActionSheetBuilder.ActionSheetItemViewHolder;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import cooperation.qzone.QZoneHelper;
import cooperation.qzone.QZoneHelper.UserInfo;
import java.io.File;
import mqq.app.AppRuntime;

class ahrq
  implements AdapterView.OnItemClickListener
{
  ahrq(ahri paramahri, AIOShortVideoData paramAIOShortVideoData, File paramFile, int paramInt, ahtm paramahtm) {}
  
  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    int i = 0;
    Object localObject = paramView.getTag();
    if (localObject == null) {}
    for (;;)
    {
      EventCollector.getInstance().onItemClick(paramAdapterView, paramView, paramInt, paramLong);
      return;
      this.jdField_a_of_type_Ahri.jdField_a_of_type_ComTencentMobileqqUtilsShareActionSheetBuilder.dismiss();
      switch (((ShareActionSheetBuilder.ActionSheetItemViewHolder)localObject).sheetItem.action)
      {
      }
      for (;;)
      {
        localObject = this.jdField_a_of_type_Ahri.jdField_a_of_type_Ahsn.a();
        if ((localObject == null) || (((ahtm)localObject).a == null) || (!AIOShortVideoData.class.isInstance(((ahtm)localObject).a))) {
          break;
        }
        localObject = (AIOShortVideoData)((ahtm)localObject).a;
        if (((AIOShortVideoData)localObject).b != 0) {
          break label640;
        }
        bdla.b(null, "dc00898", "", "", "0X8009EF9", "0X8009EF9", i, 0, "", "", "", "");
        break;
        i = 1;
        ahri.a(this.jdField_a_of_type_Ahri, this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOShortVideoData);
        continue;
        if (QLog.isColorLevel()) {
          QLog.d("AIOGalleryScene", 2, "click menu to share to qzone");
        }
        localObject = QZoneHelper.UserInfo.getInstance();
        ((QZoneHelper.UserInfo)localObject).qzone_uin = this.jdField_a_of_type_Ahri.b;
        QZoneHelper.forwardToPublishMood(ahri.t(this.jdField_a_of_type_Ahri), (QZoneHelper.UserInfo)localObject, this.jdField_a_of_type_JavaIoFile.getAbsolutePath(), 10001);
        bdla.b(null, "dc00898", "", "", "0X8007539", "0X8007539", 0, 0, "", "", "", "");
        i = 4;
        continue;
        ahri.a(this.jdField_a_of_type_Ahri, this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOShortVideoData, this.jdField_a_of_type_JavaIoFile, this.jdField_a_of_type_Int, this.jdField_a_of_type_Ahtm);
        continue;
        bdla.b(null, "P_CliOper", "dwop_via", "", "0X8009BE4", "0X8009BE4", this.jdField_a_of_type_Ahri.k, 0, "", "", "", "");
        String str = this.jdField_a_of_type_Ahri.d;
        localObject = str;
        if (TextUtils.isEmpty(str)) {
          localObject = this.jdField_a_of_type_Ahri.c;
        }
        ahri.a(ahri.u(this.jdField_a_of_type_Ahri), this.jdField_a_of_type_Ahri.jdField_g_of_type_Int, this.jdField_a_of_type_Ahri.c, (String)localObject, this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOShortVideoData.jdField_g_of_type_Long, this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOShortVideoData.i, this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOShortVideoData.jdField_g_of_type_Int, false);
        i = 6;
        continue;
        int j = 3;
        i = j;
        if (this.jdField_a_of_type_Ahri.jdField_a_of_type_Ahtp.asBinder().pingBinder())
        {
          localObject = this.jdField_a_of_type_Ahri.jdField_a_of_type_Ahtp.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOShortVideoData.jdField_f_of_type_Long, this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOShortVideoData.jdField_f_of_type_Int, this.jdField_a_of_type_Ahri.jdField_g_of_type_Int);
          i = j;
          if (localObject != null)
          {
            bmad.a((Intent)localObject).a(ahri.v(this.jdField_a_of_type_Ahri), BaseApplicationImpl.getApplication().getRuntime().getAccount());
            bman.a(null, 3, 0, this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOShortVideoData.jdField_g_of_type_Int);
            bman.a(BaseApplicationImpl.getApplication().getRuntime(), 6, 5);
            i = j;
            continue;
            i = 7;
            ahri.b(this.jdField_a_of_type_Ahri, this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOShortVideoData);
            continue;
            j = 6;
            i = j;
            if (this.jdField_a_of_type_Ahri.jdField_a_of_type_Ahtp.asBinder().pingBinder())
            {
              this.jdField_a_of_type_Ahri.jdField_a_of_type_Ahtp.c(this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOShortVideoData.jdField_f_of_type_Long);
              QQToast.a(ahri.w(this.jdField_a_of_type_Ahri), ahri.x(this.jdField_a_of_type_Ahri).getString(2131692595), 0).a();
              i = j;
            }
          }
        }
      }
      label640:
      if (((AIOShortVideoData)localObject).b == 1) {
        bdla.b(null, "dc00898", "", "", "0X8009EF8", "0X8009EF8", i, 0, "", "", "", "");
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ahrq
 * JD-Core Version:    0.7.0.1
 */