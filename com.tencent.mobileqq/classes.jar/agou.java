import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.aio.helper.AIOLongShotHelper;
import com.tencent.mobileqq.activity.photo.DragGallery;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.activity.photo.PhotoPreviewActivity;
import com.tencent.mobileqq.activity.richmedia.EditLocalVideoActivity;
import com.tencent.mobileqq.troop.activity.TroopBarPublishActivity;
import com.tencent.mobileqq.troop.activity.TroopBarReplyActivity;
import cooperation.qzone.report.lp.LpReportInfo_pf00064;
import dov.com.tencent.biz.qqstory.takevideo.EditPicActivity;
import dov.com.tencent.mobileqq.activity.richmedia.QzoneEditPictureActivity;
import java.util.ArrayList;
import java.util.HashMap;

public class agou
  implements View.OnClickListener
{
  public agou(PhotoPreviewActivity paramPhotoPreviewActivity) {}
  
  public void onClick(View paramView)
  {
    if (this.a.t < this.a.jdField_a_of_type_JavaUtilArrayList.size()) {
      this.a.jdField_f_of_type_JavaLangString = ((String)this.a.jdField_a_of_type_JavaUtilArrayList.get(this.a.t));
    }
    Intent localIntent;
    label439:
    label460:
    int j;
    if (this.a.jdField_f_of_type_JavaLangString != null)
    {
      axqw.b(null, "CliOper", "", "", "0x8004B39", "0x8004B39", 0, 0, "", "", "", "");
      if (this.a.L) {
        axqw.b(null, "CliOper", "", "", "0X8004D95", "0X8004D95", 0, 0, "", "", "", "");
      }
      new Intent();
      paramView = null;
      if (this.a.g != null) {
        paramView = (LocalMediaInfo)this.a.g.get(this.a.jdField_f_of_type_JavaLangString);
      }
      if ((!this.a.H) || (bbbj.a(paramView) != 1) || (!this.a.z) || (this.a.jdField_b_of_type_Boolean) || (this.a.c) || (this.a.jdField_f_of_type_Boolean) || (this.a.d) || (!this.a.j)) {
        break label700;
      }
      new HashMap(1).put("param_localmediainfo", paramView);
      localIntent = new Intent(BaseApplicationImpl.getContext(), EditLocalVideoActivity.class);
      localIntent.putExtras(this.a.getIntent());
      localIntent.putExtra("PhotoConst.PLUGIN_APK", "qzone_plugin.apk");
      localIntent.putExtra("PhotoConst.PLUGIN_NAME", "QZone");
      localIntent.putExtra("DirectBackToQzone", true);
      localIntent.putExtra("qzone_plugin_activity_name", "com.tencent.pubaccount.publish.QQPublicAccountPublishFeedActivity");
      localIntent.putExtra("short_video_refer", getClass().getName());
      localIntent.putExtra("PhotoConst.EDIT_LOCAL_VIDEO_ENTRY", 1);
      localIntent.putExtra("file_send_path", this.a.jdField_f_of_type_JavaLangString);
      localIntent.putExtra("PhotoConst.VIDEO_SIZE", paramView.fileSize);
      localIntent.putExtra("file_send_duration", paramView.mDuration);
      localIntent.putExtra("file_width", paramView.mediaWidth);
      localIntent.putExtra("file_height", paramView.mediaHeight);
      paramView = localIntent;
      paramView.putExtra("PhotoConst.CURRENT_QUALITY_TYPE", this.a.e);
      if (!PhotoPreviewActivity.a(this.a)) {
        break label1100;
      }
      paramView.putExtra("PhotoConst.SEND_BUSINESS_TYPE", 1040);
      if (!this.a.G) {
        break label1117;
      }
      this.a.startActivityForResult(paramView, 18003);
      this.a.overridePendingTransition(2130772036, 2130772038);
      this.a.jdField_a_of_type_AndroidWidgetButton.setClickable(false);
      paramView = this.a.getIntent();
      if ((paramView != null) && (paramView.hasExtra("custom_photopreview_editbtn_reportActionName")))
      {
        paramView = paramView.getStringExtra("custom_photopreview_editbtn_reportActionName");
        if (paramView != null) {
          axqw.b(null, "CliOper", "", "", paramView, paramView, 0, 0, "", "", "", "");
        }
      }
      if (!TextUtils.isEmpty(this.a.jdField_a_of_type_JavaLangString))
      {
        if (!TroopBarPublishActivity.class.getSimpleName().equals(this.a.jdField_a_of_type_JavaLangString)) {
          break label1152;
        }
        baih.a("pub_page_new", "clk_photo_edit", 0, 0, new String[0]);
      }
      label580:
      if ((this.a.b()) && (this.a.n > 0))
      {
        j = this.a.n;
        paramView = new StringBuilder();
        if (this.a.jdField_b_of_type_JavaUtilArrayList == null) {
          break label1188;
        }
      }
    }
    label1152:
    label1188:
    for (int i = this.a.jdField_b_of_type_JavaUtilArrayList.size();; i = 0)
    {
      axqw.b(null, "dc00898", "", "", "0X800A06D", "0X800A06D", j, 0, i + "", "", "", "");
      LpReportInfo_pf00064.allReport(603, 4, 1);
      if (this.a.G) {
        AIOLongShotHelper.a("0X8009DED");
      }
      return;
      label700:
      if (this.a.j)
      {
        if ((this.a.jdField_b_of_type_Boolean) || (this.a.c) || (this.a.jdField_f_of_type_Boolean) || (this.a.d))
        {
          if (this.a.c)
          {
            i = this.a.jdField_a_of_type_ComTencentMobileqqActivityPhotoDragGallery.getFirstVisiblePosition();
            if (i < this.a.jdField_a_of_type_JavaUtilArrayList.size()) {
              this.a.jdField_f_of_type_JavaLangString = ((String)this.a.jdField_a_of_type_JavaUtilArrayList.get(i));
            }
          }
          paramView = EditPicActivity.a(this.a, this.a.jdField_f_of_type_JavaLangString, true, true, true, true, true, 8);
          break;
        }
        paramView = new HashMap(1);
        if ((this.a.g != null) && ((LocalMediaInfo)this.a.g.get(this.a.jdField_f_of_type_JavaLangString) != null)) {
          paramView.put("param_localmediainfo", this.a.g.get(this.a.jdField_f_of_type_JavaLangString));
        }
        if (this.a.z)
        {
          paramView = QzoneEditPictureActivity.a(this.a, this.a.jdField_f_of_type_JavaLangString);
          break;
        }
        paramView = EditPicActivity.a(this.a, this.a.jdField_f_of_type_JavaLangString, true, true, true, true, true, 3, 99, 4, paramView);
        break;
      }
      paramView = new Bundle();
      if (this.a.b()) {
        paramView.putBoolean("key_multi_edit_pic", true);
      }
      localIntent = EditPicActivity.a(this.a, this.a.jdField_f_of_type_JavaLangString, true, true, true, true, true, 2, 99, 4, paramView);
      if (this.a.G) {
        localIntent = EditPicActivity.a(this.a, this.a.jdField_f_of_type_JavaLangString, true, true, true, true, true, false, false, false, 2, 122, 0, false, null);
      }
      if (this.a.z) {
        localIntent = QzoneEditPictureActivity.a(this.a, this.a.jdField_f_of_type_JavaLangString);
      }
      paramView = localIntent;
      if (!this.a.E) {
        break;
      }
      localIntent.putExtra("key_enable_edit_title_bar", true);
      paramView = localIntent;
      break;
      label1100:
      paramView.putExtra("PhotoConst.SEND_BUSINESS_TYPE", PhotoPreviewActivity.b(this.a));
      break label439;
      label1117:
      if (this.a.E)
      {
        this.a.startActivityForResult(paramView, 10000);
        break label460;
      }
      this.a.startActivity(paramView);
      break label460;
      if (!TroopBarReplyActivity.class.getSimpleName().equals(this.a.jdField_a_of_type_JavaLangString)) {
        break label580;
      }
      baih.a("reply", "clk_photo_edit", 0, 0, new String[0]);
      break label580;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     agou
 * JD-Core Version:    0.7.0.1
 */