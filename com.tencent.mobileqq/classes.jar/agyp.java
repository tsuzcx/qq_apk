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

class agyp
  implements AdapterView.OnItemClickListener
{
  agyp(agyh paramagyh, AIOShortVideoData paramAIOShortVideoData, File paramFile, int paramInt, aham paramaham) {}
  
  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    int i = 0;
    Object localObject = paramView.getTag();
    if (localObject == null) {}
    for (;;)
    {
      EventCollector.getInstance().onItemClick(paramAdapterView, paramView, paramInt, paramLong);
      return;
      this.jdField_a_of_type_Agyh.jdField_a_of_type_ComTencentMobileqqUtilsShareActionSheetBuilder.dismiss();
      switch (((ShareActionSheetBuilder.ActionSheetItemViewHolder)localObject).sheetItem.action)
      {
      }
      for (;;)
      {
        localObject = this.jdField_a_of_type_Agyh.jdField_a_of_type_Agzn.a();
        if ((localObject == null) || (((aham)localObject).a == null) || (!AIOShortVideoData.class.isInstance(((aham)localObject).a))) {
          break;
        }
        localObject = (AIOShortVideoData)((aham)localObject).a;
        if (((AIOShortVideoData)localObject).b != 0) {
          break label640;
        }
        bcef.b(null, "dc00898", "", "", "0X8009EF9", "0X8009EF9", i, 0, "", "", "", "");
        break;
        i = 1;
        agyh.a(this.jdField_a_of_type_Agyh, this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOShortVideoData);
        continue;
        if (QLog.isColorLevel()) {
          QLog.d("AIOGalleryScene", 2, "click menu to share to qzone");
        }
        localObject = QZoneHelper.UserInfo.getInstance();
        ((QZoneHelper.UserInfo)localObject).qzone_uin = this.jdField_a_of_type_Agyh.b;
        QZoneHelper.forwardToPublishMood(agyh.t(this.jdField_a_of_type_Agyh), (QZoneHelper.UserInfo)localObject, this.jdField_a_of_type_JavaIoFile.getAbsolutePath(), 10001);
        bcef.b(null, "dc00898", "", "", "0X8007539", "0X8007539", 0, 0, "", "", "", "");
        i = 4;
        continue;
        agyh.a(this.jdField_a_of_type_Agyh, this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOShortVideoData, this.jdField_a_of_type_JavaIoFile, this.jdField_a_of_type_Int, this.jdField_a_of_type_Aham);
        continue;
        bcef.b(null, "P_CliOper", "dwop_via", "", "0X8009BE4", "0X8009BE4", this.jdField_a_of_type_Agyh.k, 0, "", "", "", "");
        String str = this.jdField_a_of_type_Agyh.d;
        localObject = str;
        if (TextUtils.isEmpty(str)) {
          localObject = this.jdField_a_of_type_Agyh.c;
        }
        agyh.a(agyh.u(this.jdField_a_of_type_Agyh), this.jdField_a_of_type_Agyh.jdField_g_of_type_Int, this.jdField_a_of_type_Agyh.c, (String)localObject, this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOShortVideoData.jdField_g_of_type_Long, this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOShortVideoData.i, this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOShortVideoData.jdField_g_of_type_Int, false);
        i = 6;
        continue;
        int j = 3;
        i = j;
        if (this.jdField_a_of_type_Agyh.jdField_a_of_type_Ahap.asBinder().pingBinder())
        {
          localObject = this.jdField_a_of_type_Agyh.jdField_a_of_type_Ahap.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOShortVideoData.jdField_f_of_type_Long, this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOShortVideoData.jdField_f_of_type_Int, this.jdField_a_of_type_Agyh.jdField_g_of_type_Int);
          i = j;
          if (localObject != null)
          {
            bkov.a((Intent)localObject).a(agyh.v(this.jdField_a_of_type_Agyh), BaseApplicationImpl.getApplication().getRuntime().getAccount());
            bkpf.a(null, 3, 0, this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOShortVideoData.jdField_g_of_type_Int);
            bkpf.a(BaseApplicationImpl.getApplication().getRuntime(), 6, 5);
            i = j;
            continue;
            i = 7;
            agyh.b(this.jdField_a_of_type_Agyh, this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOShortVideoData);
            continue;
            j = 6;
            i = j;
            if (this.jdField_a_of_type_Agyh.jdField_a_of_type_Ahap.asBinder().pingBinder())
            {
              this.jdField_a_of_type_Agyh.jdField_a_of_type_Ahap.c(this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOShortVideoData.jdField_f_of_type_Long);
              QQToast.a(agyh.w(this.jdField_a_of_type_Agyh), agyh.x(this.jdField_a_of_type_Agyh).getString(2131692493), 0).a();
              i = j;
            }
          }
        }
      }
      label640:
      if (((AIOShortVideoData)localObject).b == 1) {
        bcef.b(null, "dc00898", "", "", "0X8009EF8", "0X8009EF8", i, 0, "", "", "", "");
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     agyp
 * JD-Core Version:    0.7.0.1
 */