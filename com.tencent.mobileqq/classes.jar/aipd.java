import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;
import com.tencent.biz.qqstory.takevideo.slideshow.SlideItemInfo;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.activity.photo.album.NewPhotoPreviewActivity;
import com.tencent.mobileqq.activity.richmedia.EditLocalVideoActivity;
import com.tencent.mobileqq.widget.NumberCheckBox;
import cooperation.qzone.report.lp.LpReportInfo_pf00064;
import dov.com.tencent.biz.qqstory.takevideo.EditPicActivity;
import dov.com.tencent.mobileqq.activity.richmedia.QzoneEditPictureActivity;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class aipd
  extends aimu
  implements aind
{
  int jdField_a_of_type_Int = 0;
  private HashMap<String, Integer> jdField_a_of_type_JavaUtilHashMap;
  protected boolean a;
  boolean b;
  public boolean c;
  public boolean d;
  boolean e;
  
  protected aipd(NewPhotoPreviewActivity paramNewPhotoPreviewActivity)
  {
    super(paramNewPhotoPreviewActivity);
  }
  
  private int a()
  {
    int j;
    int k;
    if (this.mPhotoCommonData.selectedPhotoList != null)
    {
      j = 0;
      int i = 0;
      k = i;
      if (j >= this.mPhotoCommonData.selectedPhotoList.size()) {
        break label75;
      }
      String str = (String)this.mPhotoCommonData.selectedPhotoList.get(j);
      if (((NewPhotoPreviewActivity)this.mActivity).getMediaType(str) != 1) {
        break label77;
      }
      i += 1;
    }
    label75:
    label77:
    for (;;)
    {
      j += 1;
      break;
      k = 0;
      return k;
    }
  }
  
  protected boolean a()
  {
    return !this.c;
  }
  
  public void a_(SlideItemInfo paramSlideItemInfo)
  {
    int i = 0;
    if (i < this.jdField_a_of_type_Aimr.paths.size()) {
      if (!((String)this.jdField_a_of_type_Aimr.paths.get(i)).equals(paramSlideItemInfo.b)) {}
    }
    for (;;)
    {
      if ((i >= 0) && (i < this.jdField_a_of_type_Aimr.paths.size()) && (this.jdField_a_of_type_JavaUtilHashMap != null)) {
        this.jdField_a_of_type_JavaUtilHashMap.remove(this.jdField_a_of_type_Aimr.paths.get(i));
      }
      return;
      i += 1;
      break;
      i = -1;
    }
  }
  
  public void ay_()
  {
    int i = ((NewPhotoPreviewActivity)this.mActivity).getCurrentSelectedPostion();
    if (i != -1)
    {
      String str = (String)this.jdField_a_of_type_Aimr.paths.get(i);
      if (this.c)
      {
        if (this.mPhotoCommonData.selectedMediaInfoHashMap == null) {
          this.mPhotoCommonData.selectedMediaInfoHashMap = new HashMap();
        }
        LocalMediaInfo localLocalMediaInfo = ((NewPhotoPreviewActivity)this.mActivity).getMediaInfo(str);
        this.mPhotoCommonData.selectedMediaInfoHashMap.put(str, localLocalMediaInfo);
        if (this.jdField_a_of_type_JavaUtilHashMap == null) {
          this.jdField_a_of_type_JavaUtilHashMap = new HashMap();
        }
        if (localLocalMediaInfo != null) {
          this.jdField_a_of_type_JavaUtilHashMap.put(str, Integer.valueOf(localLocalMediaInfo.panoramaPhotoType));
        }
      }
    }
  }
  
  protected void c()
  {
    if (this.d)
    {
      localObject1 = new Intent();
      ((Intent)localObject1).putIntegerArrayListExtra("PhotoConst.SELECTED_INDEXS", this.mPhotoCommonData.selectedIndex);
      ((NewPhotoPreviewActivity)this.mActivity).setResult(-1, (Intent)localObject1);
      ((NewPhotoPreviewActivity)this.mActivity).finish();
      return;
    }
    Object localObject1 = ((NewPhotoPreviewActivity)this.mActivity).getSubmitPhotoList();
    Object localObject2;
    Object localObject3;
    if ((this.c) && (this.mPhotoCommonData.selectedPhotoList != null) && (this.mPhotoCommonData.selectedPhotoList.isEmpty()) && (((ArrayList)localObject1).size() == 1))
    {
      localObject2 = (String)((ArrayList)localObject1).get(0);
      localObject3 = ((NewPhotoPreviewActivity)this.mActivity).getMediaInfo((String)localObject2);
      if (localObject3 != null)
      {
        if (this.jdField_a_of_type_JavaUtilHashMap == null) {
          this.jdField_a_of_type_JavaUtilHashMap = new HashMap();
        }
        this.jdField_a_of_type_JavaUtilHashMap.put(localObject2, Integer.valueOf(((LocalMediaInfo)localObject3).panoramaPhotoType));
        if (this.mPhotoCommonData.selectedMediaInfoHashMap != null)
        {
          this.mPhotoCommonData.selectedMediaInfoHashMap.clear();
          this.mPhotoCommonData.selectedMediaInfoHashMap.put(localObject2, localObject3);
        }
      }
      if ((((NewPhotoPreviewActivity)this.mActivity).getMediaType((String)localObject2) == 1) && (!bdar.a(this.mActivity, a(), (LocalMediaInfo)localObject3, this.e)))
      {
        ((NewPhotoPreviewActivity)this.mActivity).sendBtn.setClickable(true);
        return;
      }
    }
    if (localObject1 != null)
    {
      aild.a(((ArrayList)localObject1).size(), this.jdField_a_of_type_Aimr.totalPicCount);
      aild.a(((NewPhotoPreviewActivity)this.mActivity).getIntent(), ((ArrayList)localObject1).size(), this.mPhotoCommonData.currentQualityType);
    }
    Intent localIntent = ((NewPhotoPreviewActivity)this.mActivity).getIntent();
    if (localObject1 != null) {
      ajnh.a((List)localObject1);
    }
    if ((this.c) || (this.mPhotoCommonData.a()))
    {
      localIntent.putExtra("PeakConstants.selectedMediaInfoHashMap", this.mPhotoCommonData.selectedMediaInfoHashMap);
      localIntent.putExtra("PhotoConst.PANORAMA_IMAGES", this.jdField_a_of_type_JavaUtilHashMap);
    }
    if (1 == this.jdField_a_of_type_Int) {
      localIntent.putExtra("PhotoConst.KEY_SHOW_TYPE", 1);
    }
    for (;;)
    {
      a(localIntent, false, ((NewPhotoPreviewActivity)this.mActivity).getSubmitPhotoList());
      if (!localIntent.getBooleanExtra("custom_photopreview_sendbtn_report", false)) {
        break;
      }
      localObject3 = localIntent.getStringExtra("custom_photopreview_sendbtn_reportActionName");
      localObject2 = localIntent.getStringExtra("custom_photopreview_sendbtn_album_reportReverse2");
      localObject1 = localObject2;
      if (localObject2 == null) {
        localObject1 = localIntent.getStringExtra("custom_photopreview_sendbtn_camera_reportReverse2");
      }
      localObject2 = localObject1;
      if (localObject1 == null) {
        localObject2 = localIntent.getStringExtra("custom_photopreview_sendbtn_reportReverse2");
      }
      localObject1 = localObject2;
      if (localObject2 == null) {
        localObject1 = "";
      }
      if ((localObject3 == null) || (localObject1 == null)) {
        break;
      }
      azmj.b(null, "CliOper", "", "", (String)localObject3, (String)localObject3, 0, 0, (String)localObject1, "", "", "");
      return;
      localIntent.putExtra("PhotoConst.KEY_SHOW_TYPE", 0);
    }
  }
  
  public void initData(Intent paramIntent)
  {
    this.jdField_a_of_type_Aimr.c = true;
    super.initData(paramIntent);
    this.jdField_a_of_type_JavaUtilHashMap = ((HashMap)paramIntent.getSerializableExtra("PhotoConst.PANORAMA_IMAGES"));
    this.jdField_a_of_type_Int = paramIntent.getIntExtra("PhotoConst.KEY_SHOW_TYPE", 0);
    this.jdField_a_of_type_Boolean = paramIntent.getBooleanExtra("QZONE_PEAK_SUPPORT_VIDEO_EDIT_WHEN_PREVIEW", false);
    this.b = paramIntent.getBooleanExtra("from_qzone_slideshow", false);
    this.mPhotoCommonData.a(this.b);
    this.c = paramIntent.getBooleanExtra("from_qzone", false);
    this.d = paramIntent.getBooleanExtra("fromQzonePhotoGroup", false);
    this.e = paramIntent.getBooleanExtra("PhotoConst.IS_FROM_SHUOSHUO", false);
    if (this.b) {
      xir.a().b(19);
    }
  }
  
  public void initUI()
  {
    super.initUI();
    if (this.jdField_a_of_type_Boolean) {
      ((NewPhotoPreviewActivity)this.mActivity).magicStickBtn.setVisibility(0);
    }
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if ((this.b) && (paramInt2 == -1))
    {
      ((NewPhotoPreviewActivity)this.mActivity).setResult(paramInt2, null);
      ((NewPhotoPreviewActivity)this.mActivity).finish();
      return;
    }
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
  }
  
  public void onMagicStickClick(View paramView, int paramInt1, Bundle paramBundle, int paramInt2, Intent paramIntent)
  {
    paramInt1 = ((NewPhotoPreviewActivity)this.mActivity).getCurrentSelectedPostion();
    if (paramInt1 != -1) {
      this.jdField_a_of_type_Aimr.a = ((String)this.jdField_a_of_type_Aimr.paths.get(paramInt1));
    }
    if (this.jdField_a_of_type_Aimr.a != null)
    {
      azmj.b(null, "CliOper", "", "", "0x8004B39", "0x8004B39", 0, 0, "", "", "", "");
      paramBundle = new Intent();
      if (this.mPhotoCommonData.selectedMediaInfoHashMap == null) {
        break label594;
      }
    }
    label594:
    for (paramView = (LocalMediaInfo)this.mPhotoCommonData.selectedMediaInfoHashMap.get(this.jdField_a_of_type_Aimr.a);; paramView = null)
    {
      if ((this.jdField_a_of_type_Boolean) && (bdar.getMediaType(paramView) == 1) && (this.c) && (this.jdField_a_of_type_Aimr.c))
      {
        new HashMap(1).put("param_localmediainfo", paramView);
        paramBundle = new Intent(BaseApplicationImpl.getContext(), EditLocalVideoActivity.class);
        paramBundle.putExtras(((NewPhotoPreviewActivity)this.mActivity).getIntent());
        paramBundle.putExtra("PhotoConst.PLUGIN_APK", "qzone_plugin.apk");
        paramBundle.putExtra("PhotoConst.PLUGIN_NAME", "QZone");
        paramBundle.putExtra("DirectBackToQzone", true);
        paramBundle.putExtra("qzone_plugin_activity_name", "com.tencent.pubaccount.publish.QQPublicAccountPublishFeedActivity");
        paramBundle.putExtra("short_video_refer", getClass().getName());
        paramBundle.putExtra("PhotoConst.EDIT_LOCAL_VIDEO_ENTRY", 1);
        paramBundle.putExtra("file_send_path", this.jdField_a_of_type_Aimr.a);
        paramBundle.putExtra("PhotoConst.VIDEO_SIZE", paramView.fileSize);
        paramBundle.putExtra("file_send_duration", paramView.mDuration);
        paramBundle.putExtra("file_width", paramView.mediaWidth);
        paramBundle.putExtra("file_height", paramView.mediaHeight);
        paramView = paramBundle;
      }
      for (;;)
      {
        paramView.putExtra("PhotoConst.CURRENT_QUALITY_TYPE", this.mPhotoCommonData.currentQualityType);
        paramView.putExtra("PhotoConst.SEND_BUSINESS_TYPE", this.jdField_a_of_type_Aimr.b);
        ((NewPhotoPreviewActivity)this.mActivity).startActivity(paramView);
        ((NewPhotoPreviewActivity)this.mActivity).overridePendingTransition(2130772036, 2130772038);
        ((NewPhotoPreviewActivity)this.mActivity).magicStickBtn.setClickable(false);
        paramView = ((NewPhotoPreviewActivity)this.mActivity).getIntent();
        if ((paramView != null) && (paramView.hasExtra("custom_photopreview_editbtn_reportActionName")))
        {
          paramView = paramView.getStringExtra("custom_photopreview_editbtn_reportActionName");
          if (paramView != null) {
            azmj.b(null, "CliOper", "", "", paramView, paramView, 0, 0, "", "", "", "");
          }
        }
        LpReportInfo_pf00064.allReport(603, 4, 1);
        return;
        if (this.jdField_a_of_type_Aimr.c)
        {
          paramView = new HashMap(1);
          if ((this.mPhotoCommonData.selectedMediaInfoHashMap != null) && ((LocalMediaInfo)this.mPhotoCommonData.selectedMediaInfoHashMap.get(this.jdField_a_of_type_Aimr.a) != null)) {
            paramView.put("param_localmediainfo", this.mPhotoCommonData.selectedMediaInfoHashMap.get(this.jdField_a_of_type_Aimr.a));
          }
          if (this.c) {
            paramView = QzoneEditPictureActivity.a(this.mActivity, this.jdField_a_of_type_Aimr.a);
          } else {
            paramView = EditPicActivity.a(this.mActivity, this.jdField_a_of_type_Aimr.a, true, true, true, true, true, 3, 99, 4, paramView);
          }
        }
        else
        {
          paramView = paramBundle;
        }
      }
    }
  }
  
  public void onSelectClick(View paramView)
  {
    int i = ((NewPhotoPreviewActivity)this.mActivity).getCurrentSelectedPostion();
    if (this.mPhotoCommonData.selectedIndex.contains(Integer.valueOf(i)))
    {
      if ((this.mPhotoCommonData.selectedIndex.indexOf(Integer.valueOf(i)) >= 0) && (i != -1) && (this.jdField_a_of_type_JavaUtilHashMap != null)) {
        this.jdField_a_of_type_JavaUtilHashMap.remove(this.jdField_a_of_type_Aimr.paths.get(i));
      }
      super.onSelectClick(paramView);
      return;
    }
    if (i != -1) {}
    for (String str = (String)this.jdField_a_of_type_Aimr.paths.get(i);; str = "")
    {
      LocalMediaInfo localLocalMediaInfo = ((NewPhotoPreviewActivity)this.mActivity).getMediaInfo(str);
      if ((this.c) && (this.jdField_a_of_type_Aimr.paths != null) && (((NewPhotoPreviewActivity)this.mActivity).getMediaType(str) == 1) && (!bdar.a(this.mActivity, a(), localLocalMediaInfo, this.mPhotoCommonData.a())))
      {
        ((NewPhotoPreviewActivity)this.mActivity).selectedBox.setChecked(false);
        return;
      }
      if (i == -1) {
        break;
      }
      str = (String)this.jdField_a_of_type_Aimr.paths.get(i);
      if ((!this.c) && (!this.mPhotoCommonData.a())) {
        break;
      }
      if (this.mPhotoCommonData.selectedMediaInfoHashMap == null) {
        this.mPhotoCommonData.selectedMediaInfoHashMap = new HashMap();
      }
      localLocalMediaInfo = ((NewPhotoPreviewActivity)this.mActivity).getMediaInfo(str);
      this.mPhotoCommonData.selectedMediaInfoHashMap.put(str, localLocalMediaInfo);
      if (this.jdField_a_of_type_JavaUtilHashMap == null) {
        this.jdField_a_of_type_JavaUtilHashMap = new HashMap();
      }
      if (localLocalMediaInfo == null) {
        break;
      }
      this.jdField_a_of_type_JavaUtilHashMap.put(str, Integer.valueOf(localLocalMediaInfo.panoramaPhotoType));
      break;
    }
  }
  
  public void updateButton()
  {
    boolean bool2 = true;
    super.updateButton();
    Object localObject;
    if (this.mPhotoCommonData.a())
    {
      localObject = ((NewPhotoPreviewActivity)this.mActivity).getString(2131699899);
      if (this.jdField_a_of_type_Int == 1) {
        localObject = ((NewPhotoPreviewActivity)this.mActivity).getString(2131695265);
      }
      if (this.jdField_a_of_type_Aimr.customSendBtnText == null) {
        break label382;
      }
      localObject = this.jdField_a_of_type_Aimr.customSendBtnText;
    }
    label129:
    label377:
    label382:
    for (;;)
    {
      if ((this.mPhotoCommonData.selectedPhotoList != null) && (this.mPhotoCommonData.selectedPhotoList.size() > 0) && (this.jdField_a_of_type_Int == 1))
      {
        Button localButton = ((NewPhotoPreviewActivity)this.mActivity).sendBtn;
        if (this.mPhotoCommonData.selectedPhotoList.size() >= 3)
        {
          bool1 = true;
          localButton.setEnabled(bool1);
          ((NewPhotoPreviewActivity)this.mActivity).sendBtn.setText((String)localObject + "(" + this.mPhotoCommonData.selectedPhotoList.size() + ")");
        }
      }
      else if (this.jdField_a_of_type_Boolean)
      {
        ((NewPhotoPreviewActivity)this.mActivity).sendBtn.setText((CharSequence)localObject);
        if (this.mPhotoCommonData.a()) {
          ((NewPhotoPreviewActivity)this.mActivity).sendBtn.setEnabled(false);
        }
        if ((this.c) && (this.jdField_a_of_type_Aimr.paths != null)) {
          ((NewPhotoPreviewActivity)this.mActivity).magicStickBtn.setEnabled(true);
        }
        ((NewPhotoPreviewActivity)this.mActivity).qualityCheckBox.setOnCheckedChangeListener(null);
        localObject = ((NewPhotoPreviewActivity)this.mActivity).qualityCheckBox;
        if (this.mPhotoCommonData.currentQualityType != 2) {
          break label377;
        }
      }
      for (boolean bool1 = bool2;; bool1 = false)
      {
        ((CheckBox)localObject).setChecked(bool1);
        ((NewPhotoPreviewActivity)this.mActivity).qualityCheckBox.setOnCheckedChangeListener(this.mActivity);
        if (this.mPhotoCommonData.currentQualityType == 2) {
          ((NewPhotoPreviewActivity)this.mActivity).qualityTv.setTextColor(-16734752);
        }
        b();
        return;
        localObject = ((NewPhotoPreviewActivity)this.mActivity).getString(2131695243);
        break;
        bool1 = false;
        break label129;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aipd
 * JD-Core Version:    0.7.0.1
 */