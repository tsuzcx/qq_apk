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

class aibz
  implements AdapterView.OnItemClickListener
{
  aibz(aibr paramaibr, AIOShortVideoData paramAIOShortVideoData, File paramFile, int paramInt, aidw paramaidw) {}
  
  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    int i = 0;
    Object localObject = paramView.getTag();
    if (localObject == null) {}
    for (;;)
    {
      EventCollector.getInstance().onItemClick(paramAdapterView, paramView, paramInt, paramLong);
      return;
      this.jdField_a_of_type_Aibr.jdField_a_of_type_ComTencentMobileqqUtilsShareActionSheetBuilder.dismiss();
      switch (((bhsc)localObject).a.action)
      {
      }
      for (;;)
      {
        localObject = this.jdField_a_of_type_Aibr.jdField_a_of_type_Aicx.a();
        if ((localObject == null) || (((aidw)localObject).a == null) || (!AIOShortVideoData.class.isInstance(((aidw)localObject).a))) {
          break;
        }
        localObject = (AIOShortVideoData)((aidw)localObject).a;
        if (((AIOShortVideoData)localObject).b != 0) {
          break label640;
        }
        bdll.b(null, "dc00898", "", "", "0X8009EF9", "0X8009EF9", i, 0, "", "", "", "");
        break;
        i = 1;
        aibr.a(this.jdField_a_of_type_Aibr, this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOShortVideoData);
        continue;
        if (QLog.isColorLevel()) {
          QLog.d("AIOGalleryScene", 2, "click menu to share to qzone");
        }
        localObject = bmtk.a();
        ((bmtk)localObject).a = this.jdField_a_of_type_Aibr.b;
        bmtd.c(aibr.t(this.jdField_a_of_type_Aibr), (bmtk)localObject, this.jdField_a_of_type_JavaIoFile.getAbsolutePath(), 10001);
        bdll.b(null, "dc00898", "", "", "0X8007539", "0X8007539", 0, 0, "", "", "", "");
        i = 4;
        continue;
        aibr.a(this.jdField_a_of_type_Aibr, this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOShortVideoData, this.jdField_a_of_type_JavaIoFile, this.jdField_a_of_type_Int, this.jdField_a_of_type_Aidw);
        continue;
        bdll.b(null, "P_CliOper", "dwop_via", "", "0X8009BE4", "0X8009BE4", this.jdField_a_of_type_Aibr.k, 0, "", "", "", "");
        String str = this.jdField_a_of_type_Aibr.d;
        localObject = str;
        if (TextUtils.isEmpty(str)) {
          localObject = this.jdField_a_of_type_Aibr.c;
        }
        aibr.a(aibr.u(this.jdField_a_of_type_Aibr), this.jdField_a_of_type_Aibr.jdField_g_of_type_Int, this.jdField_a_of_type_Aibr.c, (String)localObject, this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOShortVideoData.jdField_g_of_type_Long, this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOShortVideoData.i, this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOShortVideoData.jdField_g_of_type_Int, false);
        i = 6;
        continue;
        int j = 3;
        i = j;
        if (this.jdField_a_of_type_Aibr.jdField_a_of_type_Aidz.asBinder().pingBinder())
        {
          localObject = this.jdField_a_of_type_Aibr.jdField_a_of_type_Aidz.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOShortVideoData.jdField_f_of_type_Long, this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOShortVideoData.jdField_f_of_type_Int, this.jdField_a_of_type_Aibr.jdField_g_of_type_Int);
          i = j;
          if (localObject != null)
          {
            bmko.a((Intent)localObject).a(aibr.v(this.jdField_a_of_type_Aibr), BaseApplicationImpl.getApplication().getRuntime().getAccount());
            bmky.a(null, 3, 0, this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOShortVideoData.jdField_g_of_type_Int);
            bmky.a(BaseApplicationImpl.getApplication().getRuntime(), 6, 5);
            i = j;
            continue;
            i = 7;
            aibr.b(this.jdField_a_of_type_Aibr, this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOShortVideoData);
            continue;
            j = 6;
            i = j;
            if (this.jdField_a_of_type_Aibr.jdField_a_of_type_Aidz.asBinder().pingBinder())
            {
              this.jdField_a_of_type_Aibr.jdField_a_of_type_Aidz.c(this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOShortVideoData.jdField_f_of_type_Long);
              QQToast.a(aibr.w(this.jdField_a_of_type_Aibr), aibr.x(this.jdField_a_of_type_Aibr).getString(2131692445), 0).a();
              i = j;
            }
          }
        }
      }
      label640:
      if (((AIOShortVideoData)localObject).b == 1) {
        bdll.b(null, "dc00898", "", "", "0X8009EF8", "0X8009EF8", i, 0, "", "", "", "");
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aibz
 * JD-Core Version:    0.7.0.1
 */