import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.photo.AlbumListActivity;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.activity.photo.PhotoListActivity;
import com.tencent.mobileqq.data.QQAlbumInfo;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.AdapterView;
import com.tencent.widget.XListView;
import cooperation.qzone.report.lp.LpReportInfo_pf00064;
import java.util.List;
import mqq.app.AppRuntime;

public class agla
  implements bfpc
{
  private agla(AlbumListActivity paramAlbumListActivity) {}
  
  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    paramAdapterView = this.a.jdField_a_of_type_Aglc.a(paramInt);
    if ((paramAdapterView == null) || (paramAdapterView.mMediaFileCount <= 0) || (TextUtils.isEmpty(paramAdapterView.name))) {
      bcpw.a(this.a, 2131690020, 0).a();
    }
    Object localObject;
    do
    {
      return;
      if (this.a.k)
      {
        paramView = this.a.getIntent();
        paramView.putExtra("ALBUM_ID", paramAdapterView._id);
        paramView.putExtra("ALBUM_NAME", paramAdapterView.name);
        paramView.putExtra("PhotoConst.CURRENT_QUALITY_TYPE", paramView.getIntExtra("PhotoConst.CURRENT_QUALITY_TYPE", 0));
        paramView.putExtra("album_enter_directly", false);
        this.a.setResult(-1, paramView);
        this.a.finish();
        bbbj.a(this.a, true, true);
        return;
      }
      if (paramAdapterView._id != "qzone_album") {
        break;
      }
      if (this.a.q) {
        LpReportInfo_pf00064.allReport(96, 1, 2);
      }
      paramAdapterView = this.a.getIntent();
      paramView = paramAdapterView.getExtras();
      paramView.putInt("key_personal_album_enter_model", 1);
      paramView.putInt("PhotoConst.CURRENT_QUALITY_TYPE", paramAdapterView.getIntExtra("PhotoConst.CURRENT_QUALITY_TYPE", 0));
      paramView.putSerializable("PhotoConst.PHOTO_INFOS", paramAdapterView.getSerializableExtra("PhotoConst.PHOTO_INFOS"));
      paramView.putBoolean("PhotoConst.IS_SHOW_QZONE_ALBUM", true);
      paramView.putStringArrayList("PhotoConst.PHOTO_PATHS", paramAdapterView.getStringArrayListExtra("PhotoConst.PHOTO_PATHS"));
      localObject = bgyf.a();
      ((bgyf)localObject).a = BaseApplicationImpl.getApplication().getRuntime().getAccount();
      paramView.putString("keyAction", "actionSelectPicture");
      paramView.putBoolean("key_need_change_to_jpg", true);
      bgxy.a(this.a, (bgyf)localObject, paramView, 0);
      if (paramAdapterView.getBooleanExtra("PhotoConst.IS_FROM_P2V", false))
      {
        this.a.finish();
        bbbj.a(this.a, true, true);
      }
      if (this.a.j) {
        paramAdapterView.putExtra("PeakConstants.selectedMediaInfoHashMap", this.a.jdField_a_of_type_JavaUtilHashMap);
      }
    } while (!this.a.l);
    if (this.a.n) {}
    for (paramInt = 0;; paramInt = 1) {
      for (;;)
      {
        for (;;)
        {
          vel.a("pic_choose_slides", "change_album", paramInt, 0, new String[0]);
          return;
          if (paramAdapterView._id == "$CustomAlbumId")
          {
            paramAdapterView = this.a.getIntent();
            paramAdapterView.putExtra("from_qqstory_custom_data", true);
            paramView = vuc.a().b();
            if (paramView.size() > 0) {
              paramAdapterView.putExtra("ALBUM_NAME", ((LocalMediaInfo)paramView.get(0)).mAlbumName);
            }
            paramAdapterView.putExtra("ALBUM_ID", "$CustomAlbumId");
            paramAdapterView.putExtra("PhotoConst.PHOTOLIST_KEY_SHOW_MEDIA", 5);
            paramAdapterView.putExtra("PhotoConst.IS_SINGLE_MODE", false);
            paramAdapterView.putExtra("from_qqstory_slideshow", true);
            paramAdapterView.putExtra("from_qqstory_entrance", true);
            paramAdapterView.putExtra("from_qqstory_custom_data", true);
            paramAdapterView.putExtra("PhotoConst.MAXUM_SELECTED_NUM", 10);
            paramAdapterView.putExtra("report_first_exposure", true);
            paramAdapterView.putExtra("PhotoConst.IS_SUPPORT_VIDEO_CHECKBOX", true);
            paramAdapterView.putExtra("PhotoConst.IS_FROM_EDIT", true);
            paramAdapterView.putExtra("PhotoConst.IS_FROM_EDIT", false);
            paramAdapterView.putExtra("PhotoConst.IS_FROM_EMOTION_FAVORITE_TO_ALBUM", this.a.s);
            paramAdapterView.setClass(this.a, PhotoListActivity.class);
            paramAdapterView.addFlags(603979776);
            this.a.startActivity(paramAdapterView);
            try
            {
              this.a.finish();
              bbbj.a(this.a, true, true);
            }
            catch (Exception paramAdapterView)
            {
              for (;;)
              {
                if (QLog.isColorLevel()) {
                  QLog.d("AlbumListActivity", 2, "onItemClick finish() exception=" + paramAdapterView.getMessage());
                }
              }
            }
          }
        }
        paramView = this.a.getIntent();
        paramView.putExtra("ALBUM_ID", paramAdapterView._id);
        paramView.putExtra("ALBUM_NAME", paramAdapterView.name);
        paramView.putExtra("PhotoConst.CURRENT_QUALITY_TYPE", paramView.getIntExtra("PhotoConst.CURRENT_QUALITY_TYPE", 0));
        paramView.putExtra("album_enter_directly", false);
        paramView.putExtra("PhotoConst.ALWAYS_SHOW_NUMBER_WHEN_ONLY_ONE_IMAGE", this.a.b);
        paramView.putExtra("PhotoConst.DISABLE_UPLOAD_TO_TROOP_ALBUM", this.a.c);
        paramView.putExtra("PhotoConst.UPLOAD_CHECKBOX_IS_CHECKED", this.a.d);
        paramView.putExtra("PhotoConst.AIO_TO_PHOTO_LIST_NEED_SHOW_UPLOAD_BAR", this.a.f);
        paramView.putExtra("PhotoConst.IS_JUMPTO_TROOP_ALBUM", this.a.p);
        paramView.putExtra("PhotoConst.IS_FROM_EMOTION_FAVORITE_TO_ALBUM", this.a.s);
        paramView.putExtra("PhotoConst.photo_selection_index", this.a.jdField_a_of_type_ComTencentWidgetXListView.getFirstVisiblePosition());
        localObject = this.a.jdField_a_of_type_ComTencentWidgetXListView.getChildAt(0);
        if (localObject == null)
        {
          paramInt = 0;
          paramView.putExtra("PhotoConst.photo_selection_y", paramInt);
          if (QLog.isColorLevel()) {
            QLog.d("AlbumListActivity", 2, "save Scroll Position,index:" + this.a.jdField_a_of_type_ComTencentWidgetXListView.getFirstVisiblePosition() + " top:" + paramInt);
          }
          AlbumListActivity.a(this.a, true);
          paramView.setClass(this.a, PhotoListActivity.class);
          paramView.addFlags(603979776);
          if (this.a.j) {
            paramView.putExtra("PeakConstants.selectedMediaInfoHashMap", this.a.jdField_a_of_type_JavaUtilHashMap);
          }
          this.a.startActivity(paramView);
          if ("$VideoAlbumId".equals(paramAdapterView._id)) {
            axqw.b(null, "CliOper", "", "", "0X8006131", "0X8006131", 0, 0, "", "", "", "");
          }
        }
        try
        {
          this.a.finish();
          bbbj.a(this.a, true, true);
          break;
          paramInt = ((View)localObject).getTop();
        }
        catch (Exception paramAdapterView)
        {
          for (;;)
          {
            if (QLog.isColorLevel()) {
              QLog.d("AlbumListActivity", 2, "onItemClick finish() exception=" + paramAdapterView.getMessage());
            }
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     agla
 * JD-Core Version:    0.7.0.1
 */