import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton.OnCheckedChangeListener;
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
import mqq.util.WeakReference;

public class agve
  extends agta
  implements agst
{
  int jdField_a_of_type_Int = 0;
  private HashMap<String, Integer> jdField_a_of_type_JavaUtilHashMap;
  protected boolean a;
  boolean b;
  public boolean c;
  public boolean d;
  boolean e;
  
  protected agve(NewPhotoPreviewActivity paramNewPhotoPreviewActivity)
  {
    super(paramNewPhotoPreviewActivity);
  }
  
  private int a()
  {
    int j;
    int k;
    if (this.jdField_a_of_type_Agrz.jdField_a_of_type_JavaUtilArrayList != null)
    {
      j = 0;
      int i = 0;
      k = i;
      if (j >= this.jdField_a_of_type_Agrz.jdField_a_of_type_JavaUtilArrayList.size()) {
        break label78;
      }
      String str = (String)this.jdField_a_of_type_Agrz.jdField_a_of_type_JavaUtilArrayList.get(j);
      if (((NewPhotoPreviewActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).a(str) != 1) {
        break label80;
      }
      i += 1;
    }
    label78:
    label80:
    for (;;)
    {
      j += 1;
      break;
      k = 0;
      return k;
    }
  }
  
  public static agsq b(NewPhotoPreviewActivity paramNewPhotoPreviewActivity)
  {
    if ((jdField_a_of_type_Agsq == null) || (jdField_a_of_type_Agsq.jdField_a_of_type_MqqUtilWeakReference.get() != paramNewPhotoPreviewActivity)) {}
    try
    {
      if ((jdField_a_of_type_Agsq == null) || (jdField_a_of_type_Agsq.jdField_a_of_type_MqqUtilWeakReference.get() != paramNewPhotoPreviewActivity)) {
        jdField_a_of_type_Agsq = new agve(paramNewPhotoPreviewActivity);
      }
      return jdField_a_of_type_Agsq;
    }
    finally {}
  }
  
  protected void a(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if ((this.b) && (paramInt2 == -1))
    {
      ((NewPhotoPreviewActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).setResult(paramInt2, null);
      ((NewPhotoPreviewActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).finish();
      return;
    }
    super.a(paramInt1, paramInt2, paramIntent);
  }
  
  protected void a(Intent paramIntent)
  {
    this.jdField_a_of_type_Agsp.g = true;
    super.a(paramIntent);
    this.jdField_a_of_type_JavaUtilHashMap = ((HashMap)paramIntent.getSerializableExtra("PhotoConst.PANORAMA_IMAGES"));
    this.jdField_a_of_type_Int = paramIntent.getIntExtra("PhotoConst.KEY_SHOW_TYPE", 0);
    this.jdField_a_of_type_Boolean = paramIntent.getBooleanExtra("QZONE_PEAK_SUPPORT_VIDEO_EDIT_WHEN_PREVIEW", false);
    this.b = paramIntent.getBooleanExtra("from_qzone_slideshow", false);
    this.jdField_a_of_type_Agrz.a(this.b);
    this.c = paramIntent.getBooleanExtra("from_qzone", false);
    this.d = paramIntent.getBooleanExtra("fromQzonePhotoGroup", false);
    this.e = paramIntent.getBooleanExtra("PhotoConst.IS_FROM_SHUOSHUO", false);
    if (this.b) {
      vtz.a().b(19);
    }
  }
  
  protected void a(View paramView)
  {
    int i = ((NewPhotoPreviewActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).a();
    if (this.jdField_a_of_type_Agrz.b.contains(Integer.valueOf(i)))
    {
      if ((this.jdField_a_of_type_Agrz.b.indexOf(Integer.valueOf(i)) >= 0) && (i != -1) && (this.jdField_a_of_type_JavaUtilHashMap != null)) {
        this.jdField_a_of_type_JavaUtilHashMap.remove(this.jdField_a_of_type_Agsp.jdField_a_of_type_JavaUtilArrayList.get(i));
      }
      super.a(paramView);
      return;
    }
    if (i != -1) {}
    for (String str = (String)this.jdField_a_of_type_Agsp.jdField_a_of_type_JavaUtilArrayList.get(i);; str = "")
    {
      LocalMediaInfo localLocalMediaInfo = ((NewPhotoPreviewActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).b(str);
      if ((this.c) && (this.jdField_a_of_type_Agsp.jdField_a_of_type_JavaUtilArrayList != null) && (((NewPhotoPreviewActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).a(str) == 1) && (!bbbx.a((Context)this.jdField_a_of_type_MqqUtilWeakReference.get(), a(), localLocalMediaInfo, this.jdField_a_of_type_Agrz.a())))
      {
        ((NewPhotoPreviewActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).jdField_a_of_type_ComTencentMobileqqWidgetNumberCheckBox.setChecked(false);
        return;
      }
      if (i == -1) {
        break;
      }
      str = (String)this.jdField_a_of_type_Agsp.jdField_a_of_type_JavaUtilArrayList.get(i);
      if ((!this.c) && (!this.jdField_a_of_type_Agrz.a())) {
        break;
      }
      if (this.jdField_a_of_type_Agrz.jdField_a_of_type_JavaUtilHashMap == null) {
        this.jdField_a_of_type_Agrz.jdField_a_of_type_JavaUtilHashMap = new HashMap();
      }
      localLocalMediaInfo = ((NewPhotoPreviewActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).b(str);
      this.jdField_a_of_type_Agrz.jdField_a_of_type_JavaUtilHashMap.put(str, localLocalMediaInfo);
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
  
  protected void a(View paramView, int paramInt1, Bundle paramBundle, int paramInt2, Intent paramIntent)
  {
    paramInt1 = ((NewPhotoPreviewActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).a();
    if (paramInt1 != -1) {
      this.jdField_a_of_type_Agsp.d = ((String)this.jdField_a_of_type_Agsp.jdField_a_of_type_JavaUtilArrayList.get(paramInt1));
    }
    if (this.jdField_a_of_type_Agsp.d != null)
    {
      axqy.b(null, "CliOper", "", "", "0x8004B39", "0x8004B39", 0, 0, "", "", "", "");
      paramBundle = new Intent();
      if (this.jdField_a_of_type_Agrz.jdField_a_of_type_JavaUtilHashMap == null) {
        break label615;
      }
    }
    label615:
    for (paramView = (LocalMediaInfo)this.jdField_a_of_type_Agrz.jdField_a_of_type_JavaUtilHashMap.get(this.jdField_a_of_type_Agsp.d);; paramView = null)
    {
      if ((this.jdField_a_of_type_Boolean) && (bbbx.a(paramView) == 1) && (this.c) && (this.jdField_a_of_type_Agsp.g))
      {
        new HashMap(1).put("param_localmediainfo", paramView);
        paramBundle = new Intent(BaseApplicationImpl.getContext(), EditLocalVideoActivity.class);
        paramBundle.putExtras(((NewPhotoPreviewActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).getIntent());
        paramBundle.putExtra("PhotoConst.PLUGIN_APK", "qzone_plugin.apk");
        paramBundle.putExtra("PhotoConst.PLUGIN_NAME", "QZone");
        paramBundle.putExtra("DirectBackToQzone", true);
        paramBundle.putExtra("qzone_plugin_activity_name", "com.tencent.pubaccount.publish.QQPublicAccountPublishFeedActivity");
        paramBundle.putExtra("short_video_refer", getClass().getName());
        paramBundle.putExtra("PhotoConst.EDIT_LOCAL_VIDEO_ENTRY", 1);
        paramBundle.putExtra("file_send_path", this.jdField_a_of_type_Agsp.d);
        paramBundle.putExtra("PhotoConst.VIDEO_SIZE", paramView.fileSize);
        paramBundle.putExtra("file_send_duration", paramView.mDuration);
        paramBundle.putExtra("file_width", paramView.mediaWidth);
        paramBundle.putExtra("file_height", paramView.mediaHeight);
        paramView = paramBundle;
      }
      for (;;)
      {
        paramView.putExtra("PhotoConst.CURRENT_QUALITY_TYPE", this.jdField_a_of_type_Agrz.c);
        paramView.putExtra("PhotoConst.SEND_BUSINESS_TYPE", this.jdField_a_of_type_Agsp.f);
        ((NewPhotoPreviewActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).startActivity(paramView);
        ((NewPhotoPreviewActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).overridePendingTransition(2130772036, 2130772038);
        ((NewPhotoPreviewActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).jdField_a_of_type_AndroidWidgetButton.setClickable(false);
        paramView = ((NewPhotoPreviewActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).getIntent();
        if ((paramView != null) && (paramView.hasExtra("custom_photopreview_editbtn_reportActionName")))
        {
          paramView = paramView.getStringExtra("custom_photopreview_editbtn_reportActionName");
          if (paramView != null) {
            axqy.b(null, "CliOper", "", "", paramView, paramView, 0, 0, "", "", "", "");
          }
        }
        LpReportInfo_pf00064.allReport(603, 4, 1);
        return;
        if (this.jdField_a_of_type_Agsp.g)
        {
          paramView = new HashMap(1);
          if ((this.jdField_a_of_type_Agrz.jdField_a_of_type_JavaUtilHashMap != null) && ((LocalMediaInfo)this.jdField_a_of_type_Agrz.jdField_a_of_type_JavaUtilHashMap.get(this.jdField_a_of_type_Agsp.d) != null)) {
            paramView.put("param_localmediainfo", this.jdField_a_of_type_Agrz.jdField_a_of_type_JavaUtilHashMap.get(this.jdField_a_of_type_Agsp.d));
          }
          if (this.c) {
            paramView = QzoneEditPictureActivity.a((Activity)this.jdField_a_of_type_MqqUtilWeakReference.get(), this.jdField_a_of_type_Agsp.d);
          } else {
            paramView = EditPicActivity.a((Activity)this.jdField_a_of_type_MqqUtilWeakReference.get(), this.jdField_a_of_type_Agsp.d, true, true, true, true, true, 3, 99, 4, paramView);
          }
        }
        else
        {
          paramView = paramBundle;
        }
      }
    }
  }
  
  public void a_(SlideItemInfo paramSlideItemInfo)
  {
    int i = 0;
    if (i < this.jdField_a_of_type_Agsp.jdField_a_of_type_JavaUtilArrayList.size()) {
      if (!((String)this.jdField_a_of_type_Agsp.jdField_a_of_type_JavaUtilArrayList.get(i)).equals(paramSlideItemInfo.jdField_b_of_type_JavaLangString)) {}
    }
    for (;;)
    {
      if ((i >= 0) && (i < this.jdField_a_of_type_Agsp.jdField_a_of_type_JavaUtilArrayList.size()) && (this.jdField_a_of_type_JavaUtilHashMap != null)) {
        this.jdField_a_of_type_JavaUtilHashMap.remove(this.jdField_a_of_type_Agsp.jdField_a_of_type_JavaUtilArrayList.get(i));
      }
      return;
      i += 1;
      break;
      i = -1;
    }
  }
  
  public void aq_()
  {
    int i = ((NewPhotoPreviewActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).a();
    if (i != -1)
    {
      String str = (String)this.jdField_a_of_type_Agsp.jdField_a_of_type_JavaUtilArrayList.get(i);
      if (this.c)
      {
        if (this.jdField_a_of_type_Agrz.jdField_a_of_type_JavaUtilHashMap == null) {
          this.jdField_a_of_type_Agrz.jdField_a_of_type_JavaUtilHashMap = new HashMap();
        }
        LocalMediaInfo localLocalMediaInfo = ((NewPhotoPreviewActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).b(str);
        this.jdField_a_of_type_Agrz.jdField_a_of_type_JavaUtilHashMap.put(str, localLocalMediaInfo);
        if (this.jdField_a_of_type_JavaUtilHashMap == null) {
          this.jdField_a_of_type_JavaUtilHashMap = new HashMap();
        }
        if (localLocalMediaInfo != null) {
          this.jdField_a_of_type_JavaUtilHashMap.put(str, Integer.valueOf(localLocalMediaInfo.panoramaPhotoType));
        }
      }
    }
  }
  
  protected boolean b()
  {
    return !this.c;
  }
  
  protected void c()
  {
    super.c();
    if (this.jdField_a_of_type_Boolean) {
      ((NewPhotoPreviewActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).jdField_a_of_type_AndroidWidgetButton.setVisibility(0);
    }
  }
  
  protected void d()
  {
    boolean bool2 = true;
    super.d();
    Object localObject;
    if (this.jdField_a_of_type_Agrz.a())
    {
      localObject = ((NewPhotoPreviewActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).getString(2131699544);
      if (this.jdField_a_of_type_Int == 1) {
        localObject = ((NewPhotoPreviewActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).getString(2131695107);
      }
      if (this.jdField_a_of_type_Agsp.jdField_b_of_type_JavaLangString == null) {
        break label424;
      }
      localObject = this.jdField_a_of_type_Agsp.jdField_b_of_type_JavaLangString;
    }
    label138:
    label419:
    label424:
    for (;;)
    {
      if ((this.jdField_a_of_type_Agrz.jdField_a_of_type_JavaUtilArrayList != null) && (this.jdField_a_of_type_Agrz.jdField_a_of_type_JavaUtilArrayList.size() > 0) && (this.jdField_a_of_type_Int == 1))
      {
        Button localButton = ((NewPhotoPreviewActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).jdField_b_of_type_AndroidWidgetButton;
        if (this.jdField_a_of_type_Agrz.jdField_a_of_type_JavaUtilArrayList.size() >= 3)
        {
          bool1 = true;
          localButton.setEnabled(bool1);
          ((NewPhotoPreviewActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).jdField_b_of_type_AndroidWidgetButton.setText((String)localObject + "(" + this.jdField_a_of_type_Agrz.jdField_a_of_type_JavaUtilArrayList.size() + ")");
        }
      }
      else if (this.jdField_a_of_type_Boolean)
      {
        ((NewPhotoPreviewActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).jdField_b_of_type_AndroidWidgetButton.setText((CharSequence)localObject);
        if (this.jdField_a_of_type_Agrz.a()) {
          ((NewPhotoPreviewActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).jdField_b_of_type_AndroidWidgetButton.setEnabled(false);
        }
        if ((this.c) && (this.jdField_a_of_type_Agsp.jdField_a_of_type_JavaUtilArrayList != null)) {
          ((NewPhotoPreviewActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).jdField_a_of_type_AndroidWidgetButton.setEnabled(true);
        }
        ((NewPhotoPreviewActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).jdField_b_of_type_AndroidWidgetCheckBox.setOnCheckedChangeListener(null);
        localObject = ((NewPhotoPreviewActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).jdField_b_of_type_AndroidWidgetCheckBox;
        if (this.jdField_a_of_type_Agrz.c != 2) {
          break label419;
        }
      }
      for (boolean bool1 = bool2;; bool1 = false)
      {
        ((CheckBox)localObject).setChecked(bool1);
        ((NewPhotoPreviewActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).jdField_b_of_type_AndroidWidgetCheckBox.setOnCheckedChangeListener((CompoundButton.OnCheckedChangeListener)this.jdField_a_of_type_MqqUtilWeakReference.get());
        if (this.jdField_a_of_type_Agrz.c == 2) {
          ((NewPhotoPreviewActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).jdField_b_of_type_AndroidWidgetTextView.setTextColor(-16734752);
        }
        g();
        return;
        localObject = ((NewPhotoPreviewActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).getString(2131695085);
        break;
        bool1 = false;
        break label138;
      }
    }
  }
  
  protected void h()
  {
    if (this.d)
    {
      localObject1 = new Intent();
      ((Intent)localObject1).putIntegerArrayListExtra("PhotoConst.SELECTED_INDEXS", this.jdField_a_of_type_Agrz.b);
      ((NewPhotoPreviewActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).setResult(-1, (Intent)localObject1);
      ((NewPhotoPreviewActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).finish();
      return;
    }
    Object localObject1 = ((NewPhotoPreviewActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).a();
    Object localObject2;
    Object localObject3;
    if ((this.c) && (this.jdField_a_of_type_Agrz.jdField_a_of_type_JavaUtilArrayList != null) && (this.jdField_a_of_type_Agrz.jdField_a_of_type_JavaUtilArrayList.isEmpty()) && (((ArrayList)localObject1).size() == 1))
    {
      localObject2 = (String)((ArrayList)localObject1).get(0);
      localObject3 = ((NewPhotoPreviewActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).b((String)localObject2);
      if (localObject3 != null)
      {
        if (this.jdField_a_of_type_JavaUtilHashMap == null) {
          this.jdField_a_of_type_JavaUtilHashMap = new HashMap();
        }
        this.jdField_a_of_type_JavaUtilHashMap.put(localObject2, Integer.valueOf(((LocalMediaInfo)localObject3).panoramaPhotoType));
        if (this.jdField_a_of_type_Agrz.jdField_a_of_type_JavaUtilHashMap != null)
        {
          this.jdField_a_of_type_Agrz.jdField_a_of_type_JavaUtilHashMap.clear();
          this.jdField_a_of_type_Agrz.jdField_a_of_type_JavaUtilHashMap.put(localObject2, localObject3);
        }
      }
      if ((((NewPhotoPreviewActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).a((String)localObject2) == 1) && (!bbbx.a((Context)this.jdField_a_of_type_MqqUtilWeakReference.get(), a(), (LocalMediaInfo)localObject3, this.e)))
      {
        ((NewPhotoPreviewActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).jdField_b_of_type_AndroidWidgetButton.setClickable(true);
        return;
      }
    }
    if (localObject1 != null)
    {
      agqd.a(((ArrayList)localObject1).size(), this.jdField_a_of_type_Agsp.jdField_b_of_type_Int);
      agqd.a(((NewPhotoPreviewActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).getIntent(), ((ArrayList)localObject1).size(), this.jdField_a_of_type_Agrz.c);
    }
    Intent localIntent = ((NewPhotoPreviewActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).getIntent();
    if (localObject1 != null) {
      ahvx.a((List)localObject1);
    }
    if ((this.c) || (this.jdField_a_of_type_Agrz.a()))
    {
      localIntent.putExtra("PeakConstants.selectedMediaInfoHashMap", this.jdField_a_of_type_Agrz.jdField_a_of_type_JavaUtilHashMap);
      localIntent.putExtra("PhotoConst.PANORAMA_IMAGES", this.jdField_a_of_type_JavaUtilHashMap);
    }
    if (1 == this.jdField_a_of_type_Int) {
      localIntent.putExtra("PhotoConst.KEY_SHOW_TYPE", 1);
    }
    for (;;)
    {
      a(localIntent, false, ((NewPhotoPreviewActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).a());
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
      axqy.b(null, "CliOper", "", "", (String)localObject3, (String)localObject3, 0, 0, (String)localObject1, "", "", "");
      return;
      localIntent.putExtra("PhotoConst.KEY_SHOW_TYPE", 0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     agve
 * JD-Core Version:    0.7.0.1
 */