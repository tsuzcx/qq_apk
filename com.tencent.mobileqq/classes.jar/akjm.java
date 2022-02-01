import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Message;
import android.support.annotation.NonNull;
import android.support.v7.widget.GridLayoutManager;
import android.text.TextUtils;
import android.util.Pair;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.biz.qqstory.takevideo.slideshow.SlideItemInfo;
import com.tencent.component.media.image.ImageManager;
import com.tencent.mobileqq.activity.PublicFragmentActivityForPeak;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.activity.photo.MimeHelper;
import com.tencent.mobileqq.activity.photo.PhotoUtils;
import com.tencent.mobileqq.activity.photo.QzonePhotoPreviewActivity;
import com.tencent.mobileqq.activity.photo.album.AbstractPhotoListActivity.Holder;
import com.tencent.mobileqq.activity.photo.album.AbstractPhotoListActivity.PhotoListAdapter;
import com.tencent.mobileqq.activity.photo.album.NewPhotoListActivity;
import com.tencent.mobileqq.activity.photo.album.NewPhotoPreviewActivity;
import com.tencent.mobileqq.activity.photo.album.PhotoCommonBaseData;
import com.tencent.mobileqq.activity.photo.album.QAlbumUtil;
import com.tencent.mobileqq.activity.photo.album.logicImp.PhotoListLogicQzone.2;
import com.tencent.mobileqq.activity.shortvideo.SendVideoActivity.SendVideoInfo;
import com.tencent.mobileqq.activity.shortvideo.ShortVideoPreviewActivity;
import com.tencent.mobileqq.pic.PresendPicMgr;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.PhotoGridView;
import common.config.service.QzoneConfig;
import cooperation.qzone.QZoneVideoDownloadActivity;
import cooperation.qzone.QzonePluginProxyActivity;
import cooperation.qzone.report.lp.LpReportInfo_pf00064;
import cooperation.qzone.thread.QzoneBaseThread;
import cooperation.qzone.thread.QzoneHandlerThreadFactory;
import cooperation.qzone.util.QZLog;
import dov.com.tencent.biz.qqstory.takevideo.EditPicActivity;
import dov.com.tencent.mobileqq.activity.richmedia.QzoneEditPictureActivity;
import java.io.File;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map.Entry;
import java.util.Set;

public class akjm
  extends akhu
{
  public static boolean e;
  public static boolean g;
  int jdField_a_of_type_Int = 0;
  long jdField_a_of_type_Long;
  public String a;
  HashMap<String, Integer> jdField_a_of_type_JavaUtilHashMap;
  private LinkedHashMap<String, LocalMediaInfo> jdField_a_of_type_JavaUtilLinkedHashMap;
  boolean jdField_a_of_type_Boolean = false;
  int jdField_b_of_type_Int;
  private String jdField_b_of_type_JavaLangString = "";
  boolean jdField_b_of_type_Boolean = false;
  private int jdField_c_of_type_Int;
  boolean jdField_c_of_type_Boolean = false;
  boolean d = false;
  protected boolean f;
  boolean h = false;
  boolean i = false;
  boolean j;
  boolean k;
  private boolean l;
  private boolean m;
  private boolean n;
  private boolean o;
  private boolean p;
  private boolean q;
  
  akjm(NewPhotoListActivity paramNewPhotoListActivity)
  {
    super(paramNewPhotoListActivity);
    this.jdField_a_of_type_JavaLangString = "";
  }
  
  private Intent a(Intent paramIntent, String paramString)
  {
    if ((this.jdField_b_of_type_Boolean) || (this.jdField_a_of_type_Boolean) || (this.jdField_c_of_type_Boolean) || (this.p) || (this.n)) {
      paramIntent = QzoneEditPictureActivity.a(this.mActivity, paramString);
    }
    return paramIntent;
  }
  
  private ArrayList<String> a(String paramString)
  {
    localArrayList = new ArrayList();
    try
    {
      paramString = paramString.split(";");
      if ((paramString != null) && (paramString.length > 0))
      {
        int i1 = 0;
        while (i1 < paramString.length)
        {
          localArrayList.add(paramString[i1]);
          i1 += 1;
        }
      }
      return localArrayList;
    }
    catch (NullPointerException paramString)
    {
      QLog.e("PhotoListActivity", 2, "parseBlockPaths error!");
    }
  }
  
  private List<LocalMediaInfo> a(int paramInt1, int paramInt2)
  {
    ArrayList localArrayList = new ArrayList();
    for (;;)
    {
      if ((paramInt1 >= 0) && (paramInt2 >= 0) && (paramInt1 <= paramInt2) && (paramInt1 <= paramInt2)) {
        try
        {
          if (paramInt1 < ((NewPhotoListActivity)this.mActivity).photoListAdapter.getItemCount())
          {
            LocalMediaInfo localLocalMediaInfo = ((NewPhotoListActivity)this.mActivity).photoListAdapter.getItem(paramInt1);
            if (localLocalMediaInfo.mMimeType.equals("image/jpeg")) {
              localArrayList.add(localLocalMediaInfo);
            }
          }
          paramInt1 += 1;
        }
        catch (Exception localException)
        {
          QLog.e("PhotoListActivity", 2, "getExposedMedia error!", localException);
        }
      }
    }
    return localArrayList;
  }
  
  private void a(int paramInt)
  {
    HashMap localHashMap = new HashMap();
    switch (paramInt)
    {
    }
    while (localHashMap.size() > 0)
    {
      QLog.i("PhotoListActivity", 2, "begin report");
      bctj.a(BaseApplication.getContext()).a(null, "qzoneChoosePhotoCamera", true, 0L, 0L, localHashMap, null, true);
      return;
      if (!this.l)
      {
        this.l = true;
        localHashMap.put("exposure", "1");
        QLog.i("PhotoListActivity", 2, "exposure");
        continue;
        localHashMap.put("click_fail", "1");
        QLog.i("PhotoListActivity", 2, "click_fail");
        continue;
        localHashMap.put("click_pass", "1");
        QLog.i("PhotoListActivity", 2, "click_pass");
        continue;
        localHashMap.put("result_video", "1");
        QLog.i("PhotoListActivity", 2, "result_video");
        continue;
        localHashMap.put("result_photo", "1");
        QLog.i("PhotoListActivity", 2, "result_photo");
      }
    }
    QLog.i("PhotoListActivity", 2, "no param");
  }
  
  private void a(int paramInt, Intent paramIntent)
  {
    Intent localIntent = ((NewPhotoListActivity)this.mActivity).getIntent();
    localIntent.putExtra("ALBUM_NAME", this.mPhotoCommonData.albumName);
    localIntent.putExtra("ALBUM_ID", this.mPhotoCommonData.albumId);
    LocalMediaInfo localLocalMediaInfo = ((NewPhotoListActivity)this.mActivity).photoListAdapter.getItem(paramInt);
    int i1 = localLocalMediaInfo.position.intValue();
    paramInt = i1;
    if (!e)
    {
      paramInt = i1;
      if (bgkc.getMediaType(localLocalMediaInfo) == 1)
      {
        if (this.mPhotoCommonData.mediaPathsList == null) {
          break label610;
        }
        this.mPhotoCommonData.mediaPathsList.clear();
        this.mPhotoCommonData.mediaPathsList.add(localLocalMediaInfo.path);
        if (this.mPhotoCommonData.selectedPhotoList == null) {
          break label627;
        }
        this.mPhotoCommonData.selectedPhotoList.clear();
        label142:
        this.mPhotoCommonData.selectedPhotoList.add(localLocalMediaInfo.path);
        if (this.mPhotoCommonData.selectedIndex == null) {
          break label644;
        }
        this.mPhotoCommonData.selectedIndex.clear();
        label178:
        this.mPhotoCommonData.selectedIndex.add(Integer.valueOf(0));
        if (this.mPhotoCommonData.selectedMediaInfoHashMap == null) {
          break label661;
        }
        this.mPhotoCommonData.selectedMediaInfoHashMap.clear();
        label213:
        this.mPhotoCommonData.selectedMediaInfoHashMap.put(localLocalMediaInfo.path, localLocalMediaInfo);
        paramInt = 0;
        localIntent.putExtra("PhotoConst.IS_SINGLE_MODE", true);
      }
    }
    localIntent.putExtra("PhotoConst.CURRENT_SELECTED_INDEX", paramInt);
    localIntent.putStringArrayListExtra("PhotoConst.SELECTED_PATHS", this.mPhotoCommonData.selectedPhotoList);
    localIntent.putIntegerArrayListExtra("PhotoConst.SELECTED_INDEXS", this.mPhotoCommonData.selectedIndex);
    localIntent.putExtra("FROM_WHERE", "FROM_PHOTO_LIST");
    localIntent.putExtra("PhotoConst.CURRENT_QUALITY_TYPE", this.mPhotoCommonData.currentQualityType);
    localIntent.putExtra("PhotoConst.SHOW_ALBUM", true);
    localIntent.putExtra("PhotoConst.SHOW_MAGIC_USE_PASTER", this.jdField_a_of_type_Akht.e);
    localIntent.putExtra("PasterConstants.paster_id", this.jdField_a_of_type_Akht.jdField_a_of_type_JavaLangString);
    localIntent.putExtra("PasterConstants.paster_cate_id", this.jdField_a_of_type_Akht.jdField_b_of_type_JavaLangString);
    akht.sPhotoListFirstPos = ((NewPhotoListActivity)this.mActivity).gridLayoutManager.findFirstVisibleItemPosition();
    if (!this.mPhotoCommonData.selectedMediaInfoHashMap.containsKey(localLocalMediaInfo.path)) {
      this.mPhotoCommonData.selectedMediaInfoHashMap.put(localLocalMediaInfo.path, localLocalMediaInfo);
    }
    localIntent.putExtra("PeakConstants.selectedMediaInfoHashMap", this.mPhotoCommonData.selectedMediaInfoHashMap);
    localIntent.putExtra("PasterConstants.pasters_data", this.jdField_a_of_type_Akht.jdField_b_of_type_JavaUtilHashMap);
    localIntent.setClass(this.mActivity, NewPhotoPreviewActivity.class);
    if (this.jdField_b_of_type_Boolean) {
      paramIntent.putExtra("PhotoConst.IS_FROM_SHUOSHUO", this.jdField_b_of_type_Boolean);
    }
    localIntent.putExtra("from_qzone", this.n);
    localIntent.addFlags(603979776);
    if ((this.mPhotoCommonData.selectedPhotoList != null) && (this.mPhotoCommonData.selectedPhotoList.size() > 0)) {
      bcst.b(null, "CliOper", "", this.mPhotoCommonData.myUin, "0X8005674", "0X8005674", 0, this.mPhotoCommonData.selectedPhotoList.size(), 0, "", "", "", "");
    }
    if (((akib)this.mOtherCommonData).a()) {
      ((NewPhotoListActivity)this.mActivity).startActivityForResult(paramIntent, 100010);
    }
    for (;;)
    {
      bgkc.anim(this.mActivity, true, true);
      return;
      label610:
      this.mPhotoCommonData.mediaPathsList = new ArrayList();
      break;
      label627:
      this.mPhotoCommonData.selectedPhotoList = new ArrayList();
      break label142;
      label644:
      this.mPhotoCommonData.selectedIndex = new ArrayList();
      break label178;
      label661:
      this.mPhotoCommonData.selectedMediaInfoHashMap = new HashMap();
      break label213;
      ((NewPhotoListActivity)this.mActivity).startActivity(localIntent);
      ((NewPhotoListActivity)this.mActivity).finish();
    }
  }
  
  private void a(LocalMediaInfo paramLocalMediaInfo, Intent paramIntent)
  {
    paramIntent.putExtra("file_send_path", paramLocalMediaInfo.path);
    paramIntent.putExtra("PhotoConst.IS_VIDEO_SELECTED", true);
    paramIntent.putExtra("PhotoConst.VIDEO_SIZE", paramLocalMediaInfo.fileSize);
    paramIntent.putExtra("file_send_duration", paramLocalMediaInfo.mDuration);
    paramIntent.putExtra("file_width", paramLocalMediaInfo.mediaWidth);
    paramIntent.putExtra("file_height", paramLocalMediaInfo.mediaHeight);
    paramIntent.putExtra("media_info", paramLocalMediaInfo);
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(paramLocalMediaInfo.path);
    PhotoUtils.a(this.mActivity, paramIntent, localArrayList, 2, false);
  }
  
  private void a(List<LocalMediaInfo> paramList)
  {
    QzoneHandlerThreadFactory.getHandlerThread("Normal_HandlerThread").post(new PhotoListLogicQzone.2(this, paramList));
  }
  
  private boolean a(LocalMediaInfo paramLocalMediaInfo, Intent paramIntent, String paramString)
  {
    boolean bool = true;
    if (this.f) {
      if ("qzone_plugin.apk".equals(paramString))
      {
        paramString = paramIntent.getStringExtra("PhotoConst.INIT_ACTIVITY_CLASS_NAME");
        if ((paramString == null) || (paramString.contains("TrimVideoActivity"))) {
          break label245;
        }
        if ((this.mPhotoCommonData.selectedPhotoList != null) && (this.mPhotoCommonData.selectedPhotoList.size() > 0))
        {
          QQToast.a(this.mActivity, "不能同时选择照片和视频", 0).a();
          this.jdField_a_of_type_Akht.jdField_b_of_type_Boolean = false;
          return true;
        }
        if (paramLocalMediaInfo.mDuration >= this.mPhotoCommonData.videoDurationLimit) {
          break label115;
        }
        this.jdField_a_of_type_Akht.jdField_b_of_type_Boolean = true;
      }
    }
    for (;;)
    {
      return false;
      label115:
      this.jdField_a_of_type_Akht.jdField_b_of_type_Boolean = false;
      paramLocalMediaInfo = new StringBuilder();
      long l1 = this.mPhotoCommonData.videoDurationLimit / 1000L;
      if (l1 > 60L)
      {
        l1 /= 60L;
        if (l1 > 60L) {
          paramLocalMediaInfo.append(l1 / 60L).append("小时");
        }
      }
      for (;;)
      {
        paramLocalMediaInfo.append("以上的视频不可选");
        QQToast.a(this.mActivity, paramLocalMediaInfo.toString(), 0).a();
        return true;
        paramLocalMediaInfo.append(l1).append("分钟");
        continue;
        paramLocalMediaInfo.append(l1).append("秒");
      }
      label245:
      if (((akib)this.mOtherCommonData).a())
      {
        this.jdField_a_of_type_Akht.jdField_b_of_type_Boolean = true;
      }
      else
      {
        paramString = this.jdField_a_of_type_Akht;
        if (paramLocalMediaInfo.mDuration > this.mPhotoCommonData.videoDurationLimit) {}
        for (bool = true;; bool = false)
        {
          paramString.jdField_b_of_type_Boolean = bool;
          paramIntent.putExtra("PhotoConst.IS_PREVIEW_VIDEO", this.jdField_a_of_type_Akht.jdField_b_of_type_Boolean);
          break;
        }
        if ("qzone_plugin.apk".equals(paramString))
        {
          paramString = paramIntent.getStringExtra("PhotoConst.INIT_ACTIVITY_CLASS_NAME");
          if ((paramString != null) && (!paramString.contains("TrimVideoActivity")))
          {
            if ((this.j) || (paramLocalMediaInfo.mDuration > this.mPhotoCommonData.videoDurationLimit) || (this.jdField_a_of_type_Boolean) || ((this.jdField_b_of_type_Boolean) && (e)))
            {
              this.jdField_a_of_type_Akht.jdField_b_of_type_Boolean = true;
            }
            else
            {
              this.jdField_a_of_type_Akht.jdField_b_of_type_Boolean = false;
              paramIntent.putExtra("support_record", false);
              paramIntent.putExtra("support_trim", true);
              paramIntent.putExtra("PhotoConst.IS_CALL_IN_PLUGIN", false);
              paramIntent.putExtra("PhotoConst.INIT_ACTIVITY_PACKAGE_NAME", "com.tencent.mobileqq");
              paramIntent.putExtra("PhotoConst.INIT_ACTIVITY_CLASS_NAME", "cooperation.qzone.QZoneVideoDownloadActivity");
              paramIntent.putExtra("PhotoConst.SHOW_MAGIC_USE_PASTER", this.jdField_a_of_type_Akht.e);
            }
          }
          else
          {
            if (!((akib)this.mOtherCommonData).a()) {
              break;
            }
            this.jdField_a_of_type_Akht.jdField_b_of_type_Boolean = true;
          }
        }
      }
    }
    paramString = this.jdField_a_of_type_Akht;
    if (paramLocalMediaInfo.mDuration > this.mPhotoCommonData.videoDurationLimit) {}
    for (;;)
    {
      paramString.jdField_b_of_type_Boolean = bool;
      paramIntent.putExtra("PhotoConst.IS_PREVIEW_VIDEO", this.jdField_a_of_type_Akht.jdField_b_of_type_Boolean);
      break;
      bool = false;
    }
  }
  
  private boolean a(String paramString)
  {
    return "com.qzone.publish.ui.activity.QZoneUploadPhotoRealActivity".equals(paramString);
  }
  
  private void b(int paramInt)
  {
    int i1 = 2;
    if (TextUtils.isEmpty(this.jdField_b_of_type_JavaLangString)) {
      return;
    }
    int i4 = this.mPhotoCommonData.selectedPhotoList.size();
    int i3;
    int i2;
    if (i4 == 0)
    {
      i3 = 601;
      i2 = 0;
      switch (paramInt)
      {
      default: 
        return;
      case 2131368947: 
        i1 = 3;
      }
    }
    for (;;)
    {
      if ((this.jdField_a_of_type_Int != 1) || (paramInt != 2131377184)) {
        break label157;
      }
      LpReportInfo_pf00064.allReport(586, 47, 3, String.valueOf(i4));
      return;
      i3 = 600;
      if (i4 == 1)
      {
        i2 = 1;
        break;
      }
      i2 = 2;
      break;
      i1 = 4;
      continue;
      i1 = 1;
      continue;
      i1 = 5;
    }
    label157:
    LpReportInfo_pf00064.allReport(i3, i2, i1);
  }
  
  private void b(Intent paramIntent)
  {
    this.jdField_a_of_type_JavaLangString = paramIntent.getStringExtra("PhotoConst.INIT_ACTIVITY_CLASS_NAME");
    this.j = paramIntent.getBooleanExtra("PhotoConst.IS_TRIM_VIDEO_BLACK_LIST", false);
    this.h = paramIntent.getBooleanExtra("PhotoConst.IS_FROM_DYNAMIC_ALBUM", false);
    this.k = paramIntent.getBooleanExtra("PhotoConst.IS_FROM_P2V", false);
    this.m = paramIntent.getBooleanExtra("NEED_QZONE_MACHINE_LEARNING_REPORT", false);
    e = paramIntent.getBooleanExtra("QZONE_SUPPORT_MIX_MOOD", false);
    this.f = paramIntent.getBooleanExtra("QZONE_PEAK_SUPPORT_VIDEO_EDIT_WHEN_PREVIEW", false);
    g = paramIntent.getBooleanExtra("upload_single_video", false);
    this.jdField_a_of_type_Int = paramIntent.getIntExtra("PhotoConst.KEY_SHOW_TYPE", 0);
    this.jdField_c_of_type_Int = paramIntent.getIntExtra("PhotoConst.KEY_SHOW_TYPE", -1);
    this.jdField_a_of_type_JavaUtilHashMap = ((HashMap)paramIntent.getSerializableExtra("PhotoConst.PANORAMA_IMAGES"));
    this.i = paramIntent.getBooleanExtra("PhotoConst.IS_NO_PANORAMA", false);
    this.jdField_a_of_type_Long = paramIntent.getLongExtra("PhotoConst.QZONE_COVER_PHOTOLIST_KEY_VIDEO_DURATION", 9223372036854775807L);
    this.p = paramIntent.getBooleanExtra("from_qzoneshare", false);
    this.jdField_b_of_type_JavaLangString = paramIntent.getStringExtra("report_from");
  }
  
  private void b(LocalMediaInfo paramLocalMediaInfo, Intent paramIntent)
  {
    Intent localIntent = new Intent(this.mActivity, ShortVideoPreviewActivity.class);
    localIntent.putExtras(paramIntent);
    localIntent.putExtra("file_send_path", paramLocalMediaInfo.path);
    localIntent.putExtra("file_send_size", paramLocalMediaInfo.fileSize);
    localIntent.putExtra("file_send_duration", paramLocalMediaInfo.mDuration);
    localIntent.putExtra("file_width", paramLocalMediaInfo.mediaWidth);
    localIntent.putExtra("file_height", paramLocalMediaInfo.mediaHeight);
    localIntent.putExtra("uin", this.jdField_a_of_type_Akht.d);
    localIntent.putExtra("uintype", this.jdField_a_of_type_Akht.jdField_a_of_type_Int);
    localIntent.putExtra("file_source", "album");
    localIntent.putExtra("is_from_system_media", paramLocalMediaInfo.isSystemMeidaStore);
    if (this.jdField_a_of_type_Akht.isSupportVideoCheckbox)
    {
      localIntent.putExtra("PhotoConst.IS_SUPPORT_VIDEO_CHECKBOX", true);
      localIntent.putExtra("PhotoConst.PHOTO_PATHS", this.mPhotoCommonData.selectedPhotoList);
    }
    if (((this.jdField_a_of_type_Boolean) || ((this.jdField_b_of_type_Boolean) && (e) && (!g))) && (this.jdField_a_of_type_Akht.isSupportVideoCheckbox)) {
      localIntent.putExtra("preview_only", true);
    }
    ((NewPhotoListActivity)this.mActivity).startActivityForResult(localIntent, 17);
  }
  
  private boolean b(String paramString)
  {
    return ("com.qzone.publish.ui.activity.QZonePublishMoodTabActivity".equals(paramString)) || ("com.qzone.publish.ui.activity.QZonePublishMoodRealActivity".equals(paramString)) || ("com.tencent.pubaccount.publish.QQPublicAccountPublishFeedActivity".equals(paramString)) || ("com.tencent.qcircle.QCirclePublishFeedActivity".equals(paramString));
  }
  
  private void c(Intent paramIntent)
  {
    if (paramIntent != null) {
      try
      {
        if (this.jdField_a_of_type_JavaUtilLinkedHashMap == null) {
          return;
        }
        paramIntent = paramIntent.getSerializableExtra("qzone_album_machine_learning_exposed_media_list");
        if (paramIntent != null)
        {
          paramIntent = ((List)paramIntent).iterator();
          while (paramIntent.hasNext())
          {
            LocalMediaInfo localLocalMediaInfo = (LocalMediaInfo)paramIntent.next();
            this.jdField_a_of_type_JavaUtilLinkedHashMap.put(localLocalMediaInfo.path, localLocalMediaInfo);
          }
        }
        return;
      }
      catch (Exception paramIntent)
      {
        QLog.e("PhotoListActivity", 2, "restoreUnSelectedExposedData error!", paramIntent);
      }
    }
  }
  
  private boolean c(String paramString)
  {
    return "com.qzone.publish.ui.activity.QZonePublishVoiceMoodActivity".equals(paramString);
  }
  
  private void d(Intent paramIntent)
  {
    if ((this.mPhotoCommonData.selectedMediaInfoHashMap == null) || (this.jdField_a_of_type_JavaUtilLinkedHashMap == null)) {
      return;
    }
    for (;;)
    {
      try
      {
        if ((!this.q) && (((NewPhotoListActivity)this.mActivity).photoListAdapter != null) && (((NewPhotoListActivity)this.mActivity).photoListAdapter.getItemCount() > 0)) {
          h();
        }
        int i2 = QzoneConfig.getInstance().getConfig("PhotoAlbum", "MachineLearningExposedMediaUpperBound", 50) - this.mPhotoCommonData.selectedMediaInfoHashMap.size();
        if (i2 <= 0) {
          break;
        }
        int i1 = 0;
        ArrayList localArrayList = new ArrayList();
        Iterator localIterator = this.jdField_a_of_type_JavaUtilLinkedHashMap.entrySet().iterator();
        if ((localIterator.hasNext()) && (i1 < i2))
        {
          LocalMediaInfo localLocalMediaInfo = (LocalMediaInfo)((Map.Entry)localIterator.next()).getValue();
          if (!this.mPhotoCommonData.selectedMediaInfoHashMap.containsKey(localLocalMediaInfo.path))
          {
            localArrayList.add(localLocalMediaInfo);
            i1 += 1;
          }
        }
        else
        {
          paramIntent.putExtra("qzone_album_machine_learning_exposed_media_list", (Serializable)localArrayList);
          return;
        }
      }
      catch (Exception paramIntent)
      {
        QLog.e("PhotoListActivity", 2, "prepareExposedMediaInfo error!", paramIntent);
        return;
      }
    }
  }
  
  private boolean d(String paramString)
  {
    return ("com.qzone.publish.ui.activity.QZoneUploadPhotoRealActivity".equals(paramString)) || ("com.qzone.publish.ui.activity.QZonePublishMoodRealActivity".equals(paramString)) || ("com.qzone.publish.ui.activity.QZonePublishMoodTabActivity".equals(paramString)) || ("com.qzone.common.activities.FeedActionPanelActivity".equals(paramString)) || ("com.tencent.pubaccount.publish.QQPublicAccountPublishFeedActivity".equals(paramString)) || (this.h) || (this.d);
  }
  
  private void e(Intent paramIntent)
  {
    String str1 = paramIntent.getStringExtra("PhotoConst.PLUGIN_APK");
    String str2 = paramIntent.getStringExtra("PhotoConst.INIT_ACTIVITY_CLASS_NAME");
    if (("qzone_plugin.apk".equals(str1)) && ("com.qzone.video.activity.TrimVideoActivity".equals(str2)))
    {
      paramIntent.putExtra("PhotoConst.PLUGIN_NAME", "QZone");
      paramIntent.putExtra("PhotoConst.PLUGIN_APK", "qzone_plugin.apk");
      paramIntent.putExtra("PhotoConst.INIT_ACTIVITY_PACKAGE_NAME", "com.tencent.mobileqq");
      paramIntent.putExtra("PhotoConst.INIT_ACTIVITY_CLASS_NAME", "com.qzone.publish.ui.activity.QZonePublishMoodRealActivity");
    }
    if ("qzone_plugin.apk".equals(str1)) {
      paramIntent.putExtra("isEmbedInTabActivity", paramIntent.getBooleanExtra("isEmbedInTabActivity", false));
    }
    if ((this.jdField_a_of_type_Boolean) || ((this.jdField_b_of_type_Boolean) && (e)) || (this.d)) {
      paramIntent.putExtra("PeakConstants.selectedMediaInfoHashMap", this.mPhotoCommonData.selectedMediaInfoHashMap);
    }
    if (this.m) {
      d(paramIntent);
    }
    if (this.mPhotoCommonData.selectedPhotoList != null) {
      alkm.a(this.mPhotoCommonData.selectedPhotoList);
    }
    paramIntent.putExtra("PhotoConst.PANORAMA_IMAGES", this.jdField_a_of_type_JavaUtilHashMap);
    if (1 == this.jdField_a_of_type_Int)
    {
      paramIntent.putExtra("PhotoConst.KEY_SHOW_TYPE", 1);
      paramIntent.putExtra("PhotoConst.KEY_SHOW_ORIGIN_TYPE", 1);
    }
    for (;;)
    {
      paramIntent.putExtra("key_state_type", this.jdField_c_of_type_Int);
      a(paramIntent, false, this.mPhotoCommonData.selectedPhotoList);
      return;
      paramIntent.putExtra("PhotoConst.KEY_SHOW_TYPE", 0);
    }
  }
  
  private void f()
  {
    Object localObject = this.mPhotoCommonData.selectedPhotoList.iterator();
    int i2 = 0;
    int i1 = 0;
    while (((Iterator)localObject).hasNext())
    {
      String str = (String)((Iterator)localObject).next();
      if ((this.mPhotoCommonData.selectedMediaInfoHashMap.containsKey(str)) && (bgkc.getMediaType((LocalMediaInfo)this.mPhotoCommonData.selectedMediaInfoHashMap.get(str)) == 1))
      {
        ((Iterator)localObject).remove();
        i1 = 1;
      }
      else if ((!this.mPhotoCommonData.selectedMediaInfoHashMap.containsKey(str)) && (!str.startsWith("http://qzs.qq.com")) && (!str.startsWith("https://qzs.qq.com")) && (str.toLowerCase().endsWith(".gif")))
      {
        ((Iterator)localObject).remove();
        i2 = 1;
      }
    }
    localObject = null;
    if (this.mPhotoCommonData.selectedPhotoList.size() > this.mPhotoCommonData.maxSelectNum)
    {
      localObject = ((NewPhotoListActivity)this.mActivity).getResources().getString(2131694268, new Object[] { Integer.valueOf(this.mPhotoCommonData.maxSelectNum) });
      this.mPhotoCommonData.selectedPhotoList.subList(this.mPhotoCommonData.maxSelectNum, this.mPhotoCommonData.selectedPhotoList.size()).clear();
    }
    for (;;)
    {
      if (localObject != null) {
        QQToast.a(this.mActivity, (CharSequence)localObject, 0).b(((NewPhotoListActivity)this.mActivity).mTitleBarHeight);
      }
      return;
      if (i1 != 0) {
        localObject = ((NewPhotoListActivity)this.mActivity).getResources().getString(2131694273);
      } else if (i2 != 0) {
        localObject = ((NewPhotoListActivity)this.mActivity).getResources().getString(2131694272);
      }
    }
  }
  
  private void g()
  {
    Iterator localIterator = this.mPhotoCommonData.selectedPhotoList.iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      if (bgkc.getMediaType((LocalMediaInfo)this.mPhotoCommonData.selectedMediaInfoHashMap.get(str)) == 1) {
        localIterator.remove();
      }
    }
  }
  
  private void g(LocalMediaInfo paramLocalMediaInfo)
  {
    bmkc.a().a(new akjo(this, paramLocalMediaInfo));
  }
  
  private void h()
  {
    if ((((NewPhotoListActivity)this.mActivity).mGridView == null) || (this.jdField_a_of_type_JavaUtilLinkedHashMap == null)) {
      return;
    }
    Object localObject = a(((NewPhotoListActivity)this.mActivity).gridLayoutManager.findFirstVisibleItemPosition(), ((NewPhotoListActivity)this.mActivity).gridLayoutManager.findLastVisibleItemPosition());
    if ((localObject != null) && (this.jdField_a_of_type_JavaUtilLinkedHashMap != null))
    {
      localObject = ((List)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        LocalMediaInfo localLocalMediaInfo = (LocalMediaInfo)((Iterator)localObject).next();
        if (!this.jdField_a_of_type_JavaUtilLinkedHashMap.containsKey(localLocalMediaInfo.path)) {
          this.jdField_a_of_type_JavaUtilLinkedHashMap.put(localLocalMediaInfo.path, localLocalMediaInfo);
        }
      }
    }
    this.q = true;
  }
  
  private void i()
  {
    Object localObject = bltj.a();
    if ((!((bltk)localObject).a()) || (!bann.a()))
    {
      String str = QzoneConfig.getInstance().getConfig("QZoneTextSetting", "PhotoListCameraNotSupport", "当前不支持拍摄");
      if ((((bltk)localObject).a() != null) && (((bltk)localObject).b()))
      {
        str = QzoneConfig.getInstance().getConfig("QZoneTextSetting", "ToastStartLiveVideoFailForMemory", "SD卡不存在或手机内存不足");
        QQToast.a(this.mActivity, str, 0).a();
      }
      for (;;)
      {
        if (((bltk)localObject).a() != null) {
          QZLog.e("PhotoListActivity", 2, new Object[] { "gotoCamera fail", ((bltk)localObject).a() });
        }
        a(2);
        return;
        QQToast.a(this.mActivity, str, 0).a();
      }
    }
    localObject = new Intent(this.mActivity, QZoneVideoDownloadActivity.class);
    ((Intent)localObject).putExtra("extra.busi_type", 3);
    ((Intent)localObject).putExtra("extra_directly_back", true);
    ((Intent)localObject).putExtra("PhotoConst.PLUGIN_APK", "qzone_plugin.apk");
    ((Intent)localObject).putExtra("DirectBackToQzone", true);
    ((Intent)localObject).putExtra("PhotoConst.PHOTO_SELECT_ACTIVITY_CLASS_NAME", NewPhotoListActivity.class.getName());
    ((Intent)localObject).putExtra("pic_confirm_text", ((NewPhotoListActivity)this.mActivity).getString(2131694260));
    ((Intent)localObject).putExtra("enable_edit_video", true);
    ((Intent)localObject).putExtra("enable_input_text", false);
    ((Intent)localObject).putExtra("enable_priv_list", false);
    ((Intent)localObject).putExtra("entry_source", 5);
    ((Intent)localObject).putExtra("support_record", true);
    ((Intent)localObject).putExtra("enable_local_video", false);
    ((Intent)localObject).putExtra("enable_local_button", false);
    ((Intent)localObject).putExtra("go_publish_activity", false);
    ((Intent)localObject).putExtra("enterPtu", false);
    if ("$VideoAlbumId".equals(this.mPhotoCommonData.albumId)) {
      ((Intent)localObject).putExtra("support_pic", false);
    }
    for (;;)
    {
      ((Intent)localObject).putExtra("key_latitude", ((NewPhotoListActivity)this.mActivity).getIntent().getDoubleExtra("key_latitude", 4.9E-324D));
      ((Intent)localObject).putExtra("key_longtitude", ((NewPhotoListActivity)this.mActivity).getIntent().getDoubleExtra("key_longtitude", 4.9E-324D));
      ((NewPhotoListActivity)this.mActivity).startActivity((Intent)localObject);
      a(3);
      return;
      ((Intent)localObject).putExtra("support_pic", true);
    }
  }
  
  public int a()
  {
    Iterator localIterator = this.mPhotoCommonData.selectedMediaInfoHashMap.entrySet().iterator();
    int i1 = 0;
    if (localIterator.hasNext())
    {
      if (QAlbumUtil.getMediaType((LocalMediaInfo)((Map.Entry)localIterator.next()).getValue()) != 1) {
        break label60;
      }
      i1 += 1;
    }
    label60:
    for (;;)
    {
      break;
      return i1;
    }
  }
  
  protected void a(Intent paramIntent, boolean paramBoolean, ArrayList<String> paramArrayList)
  {
    int i7 = PhotoUtils.b(this.jdField_a_of_type_Akht.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo);
    paramArrayList = new HashMap();
    int i2 = 0;
    int i1 = 0;
    int i6 = 0;
    int i3 = 0;
    while (i6 < this.mPhotoCommonData.selectedPhotoList.size())
    {
      Object localObject = (String)this.mPhotoCommonData.selectedPhotoList.get(i6);
      int i4;
      if (ImageManager.isNetworkUrl((String)localObject))
      {
        i4 = i3;
        i3 = i1;
        i1 = i4;
        i6 += 1;
        i4 = i3;
        i3 = i1;
        i1 = i4;
      }
      else
      {
        int i5;
        if (((NewPhotoListActivity)this.mActivity).a((String)localObject) == 1)
        {
          localObject = ((NewPhotoListActivity)this.mActivity).a((String)localObject);
          i5 = i2;
          i4 = i1;
          if (localObject != null)
          {
            SendVideoActivity.SendVideoInfo localSendVideoInfo = new SendVideoActivity.SendVideoInfo();
            localSendVideoInfo.fileSize = ((LocalMediaInfo)localObject).fileSize;
            localSendVideoInfo.duration = ((LocalMediaInfo)localObject).mDuration;
            paramArrayList.put(Integer.valueOf(i3), localSendVideoInfo);
            i4 = i1 + 1;
            i5 = i2;
          }
        }
        for (;;)
        {
          i1 = i3 + 1;
          i2 = i5;
          i3 = i4;
          break;
          i5 = i2 + 1;
          i4 = i1;
        }
      }
    }
    if (!paramArrayList.isEmpty()) {
      paramIntent.putExtra("PhotoConst.VIDEO_INFOS", paramArrayList);
    }
    if (paramBoolean) {
      PhotoUtils.a(this.mActivity, paramIntent, this.mPhotoCommonData.selectedPhotoList, this.jdField_a_of_type_Akht.jdField_a_of_type_JavaUtilHashMap, this.mPhotoCommonData.currentQualityType, false);
    }
    for (;;)
    {
      bcst.b(null, "CliOper", "", "", "0X8009AB0", "0X8009AB0", i7, 0, String.valueOf(i2), String.valueOf(i1), "", "");
      return;
      PhotoUtils.a(this.mActivity, paramIntent, this.mPhotoCommonData.selectedPhotoList, this.mPhotoCommonData.currentQualityType, this.jdField_a_of_type_Akht.jdField_a_of_type_Boolean);
    }
  }
  
  public void a(SlideItemInfo paramSlideItemInfo)
  {
    Object localObject = ((NewPhotoListActivity)this.mActivity).photoListAdapter;
    int i1;
    if ((localObject != null) && (paramSlideItemInfo != null))
    {
      List localList = ((AbstractPhotoListActivity.PhotoListAdapter)localObject).getPhotoList();
      i1 = 0;
      if (i1 >= localList.size()) {
        break label97;
      }
      if (!((LocalMediaInfo)localList.get(i1)).path.equals(paramSlideItemInfo.jdField_b_of_type_JavaLangString)) {
        break label90;
      }
    }
    for (;;)
    {
      if (i1 >= 0)
      {
        localObject = ((AbstractPhotoListActivity.PhotoListAdapter)localObject).getItem(i1);
        this.jdField_a_of_type_JavaUtilHashMap.remove(((LocalMediaInfo)localObject).path);
      }
      super.a(paramSlideItemInfo);
      return;
      label90:
      i1 += 1;
      break;
      label97:
      i1 = -1;
    }
  }
  
  protected void a(LocalMediaInfo paramLocalMediaInfo, int paramInt)
  {
    Intent localIntent = ((NewPhotoListActivity)this.mActivity).getIntent();
    if ((!this.jdField_a_of_type_Akht.f) && (!this.jdField_a_of_type_Akht.g) && (this.jdField_b_of_type_Boolean)) {
      localIntent.putExtra("PhotoConst.IS_FROM_SHUOSHUO", this.jdField_b_of_type_Boolean);
    }
    super.a(paramLocalMediaInfo, paramInt);
  }
  
  public boolean addAndRemovePhotoByGesture(LocalMediaInfo paramLocalMediaInfo, boolean paramBoolean)
  {
    boolean bool1 = false;
    if (paramBoolean)
    {
      String[] arrayOfString = MimeHelper.getMimeType(paramLocalMediaInfo.mMimeType);
      if ((!this.jdField_a_of_type_Akht.isSupportVideoCheckbox) || (arrayOfString == null) || (!"video".equals(arrayOfString[0])) || (bgkc.a(this.mActivity, a(), paramLocalMediaInfo, this.jdField_b_of_type_Boolean))) {}
    }
    boolean bool2;
    do
    {
      return bool1;
      bool2 = super.addAndRemovePhotoByGesture(paramLocalMediaInfo, paramBoolean);
      bool1 = bool2;
    } while (!bool2);
    if (paramBoolean)
    {
      this.jdField_a_of_type_JavaUtilHashMap.put(paramLocalMediaInfo.path, Integer.valueOf(paramLocalMediaInfo.panoramaPhotoType));
      return bool2;
    }
    this.jdField_a_of_type_JavaUtilHashMap.remove(paramLocalMediaInfo.path);
    return bool2;
  }
  
  protected void b()
  {
    Intent localIntent = ((NewPhotoListActivity)this.mActivity).getIntent();
    if (this.mPhotoCommonData.albumId.equals("$RecentAlbumId")) {
      bctj.a(this.mActivity).a(null, "sendAlbumRecent", true, 0L, 0L, null, "");
    }
    PresendPicMgr localPresendPicMgr;
    for (;;)
    {
      localPresendPicMgr = PresendPicMgr.a();
      if ((!this.jdField_a_of_type_Akht.e) || ((TextUtils.isEmpty(this.jdField_a_of_type_Akht.jdField_a_of_type_JavaLangString)) && (TextUtils.isEmpty(this.jdField_a_of_type_Akht.jdField_b_of_type_JavaLangString)))) {
        break;
      }
      ((NewPhotoListActivity)this.mActivity).a.performClick();
      return;
      if ((this.mPhotoCommonData.albumName.equalsIgnoreCase("Camera")) || (this.mPhotoCommonData.albumName.equalsIgnoreCase("camera")) || (this.mPhotoCommonData.albumName.contains("Camera")) || (this.mPhotoCommonData.albumName.contains("camera"))) {
        bctj.a(this.mActivity).a(null, "sendAlbumRecent", false, 0L, 0L, null, "");
      } else {
        bctj.a(this.mActivity).a(null, "sendAlbumOther", true, 0L, 0L, null, "");
      }
    }
    if (this.mPhotoCommonData.selectedPhotoList != null)
    {
      akgm.a(localIntent, this.mPhotoCommonData.selectedPhotoList.size());
      akgm.a(localIntent, this.mPhotoCommonData.selectedPhotoList.size(), this.mPhotoCommonData.currentQualityType);
    }
    if (this.mPhotoCommonData.currentQualityType == 2)
    {
      if (localPresendPicMgr != null)
      {
        localPresendPicMgr.a(1008);
        localPresendPicMgr.a();
      }
      bcst.b(null, "CliOper", "", "", "0X8005148", "0X8005148", 0, 0, "", "", "", "");
    }
    e(localIntent);
  }
  
  public void caseCamera(View paramView, int paramInt)
  {
    if (!bgjw.a())
    {
      QQToast.a(this.mActivity, ((NewPhotoListActivity)this.mActivity).getResources().getString(2131717588), 0).a();
      return;
    }
    if ((this.jdField_b_of_type_Boolean) || (this.jdField_a_of_type_Boolean))
    {
      i();
      return;
    }
    ((NewPhotoListActivity)this.mActivity).a();
  }
  
  public Intent caseNoSingModeImage(View paramView, int paramInt)
  {
    paramView = super.caseNoSingModeImage(paramView, paramInt);
    LocalMediaInfo localLocalMediaInfo1 = ((NewPhotoListActivity)this.mActivity).photoListAdapter.getItem(paramInt);
    if ((this.jdField_b_of_type_Boolean) && (!e) && (this.mPhotoCommonData.allMediaInfoHashMap != null))
    {
      if (this.jdField_a_of_type_Int == 1) {
        paramView.putStringArrayListExtra("PhotoConst.PHOTO_PATHS", this.mPhotoCommonData.selectedPhotoList);
      }
    }
    else
    {
      paramView.putExtra("from_qzone", this.n);
      if (this.jdField_b_of_type_Boolean) {
        paramView.putExtra("PhotoConst.IS_FROM_SHUOSHUO", this.jdField_b_of_type_Boolean);
      }
      return paramView;
    }
    ArrayList localArrayList1 = new ArrayList();
    ArrayList localArrayList2 = new ArrayList();
    int i1 = paramInt - 1;
    int i4 = this.mPhotoCommonData.mediaPathsList.size();
    int i3 = 0;
    int i2 = 0;
    label142:
    if (i3 < i4)
    {
      String str = (String)this.mPhotoCommonData.mediaPathsList.get(i3);
      LocalMediaInfo localLocalMediaInfo2 = (LocalMediaInfo)this.mPhotoCommonData.allMediaInfoHashMap.get(str);
      if (bgkc.getMediaType(localLocalMediaInfo2) != 0) {
        break label334;
      }
      localArrayList1.add(str);
      if ((this.mPhotoCommonData.selectedPhotoList != null) && (this.mPhotoCommonData.selectedPhotoList.contains(str))) {
        localArrayList2.add(Integer.valueOf(i2));
      }
      if (localLocalMediaInfo2.position.intValue() != paramInt - 1) {
        break label331;
      }
      i1 = i2;
      label252:
      i2 += 1;
    }
    label331:
    label334:
    for (;;)
    {
      i3 += 1;
      break label142;
      this.mPhotoCommonData.mediaPathsList = localArrayList1;
      paramView.putStringArrayListExtra("PhotoConst.PHOTO_PATHS", localArrayList1);
      paramView.putStringArrayListExtra("PhotoConst.SELECTED_PATHS", this.mPhotoCommonData.selectedPhotoList);
      paramView.putIntegerArrayListExtra("PhotoConst.SELECTED_INDEXS", localArrayList2);
      if (bgkc.getMediaType(localLocalMediaInfo1) != 0) {
        break;
      }
      paramView.putExtra("PhotoConst.CURRENT_SELECTED_INDEX", i1);
      break;
      break label252;
    }
  }
  
  public void caseSingleModeImage(View paramView, int paramInt)
  {
    LocalMediaInfo localLocalMediaInfo = ((NewPhotoListActivity)this.mActivity).photoListAdapter.getItem(paramInt);
    if ((this.jdField_c_of_type_Boolean) && (localLocalMediaInfo.mediaWidth > 0) && (localLocalMediaInfo.mediaHeight > 0) && (this.jdField_b_of_type_Int > 0) && (localLocalMediaInfo.fileSize > this.jdField_b_of_type_Int))
    {
      QQToast.a(this.mActivity, ((NewPhotoListActivity)this.mActivity).getResources().getString(2131694313, new Object[] { Integer.valueOf(this.jdField_b_of_type_Int / 1048576) }), 0).b(((NewPhotoListActivity)this.mActivity).getResources().getDimensionPixelSize(2131298998));
      return;
    }
    super.caseSingleModeImage(paramView, paramInt);
  }
  
  public void caseVideo(View paramView, int paramInt)
  {
    if (!bgjw.a()) {
      QQToast.a(this.mActivity, ((NewPhotoListActivity)this.mActivity).getResources().getString(2131717588), 0).a();
    }
    Intent localIntent;
    String str1;
    label207:
    do
    {
      do
      {
        return;
        paramView = ((NewPhotoListActivity)this.mActivity).photoListAdapter.getItem(paramInt);
      } while (paramView == null);
      localIntent = ((NewPhotoListActivity)this.mActivity).getIntent();
      str1 = localIntent.getStringExtra("PhotoConst.PLUGIN_APK");
      String str2 = localIntent.getStringExtra("video_refer");
      int i1 = 0;
      if (!TextUtils.isEmpty(str2))
      {
        if ((!str2.contains("QZonePublishMoodTabActivity")) && (!str2.contains("QZoneUploadPhotoRealActivity"))) {
          break label207;
        }
        i1 = 1;
      }
      while (i1 != 0)
      {
        long l1 = localIntent.getLongExtra("PhotoConst.PHOTOLIST_KEY_VIDEO_CAN_UPLOAD_DURATION", 9223372036854775807L);
        if (paramView.mDuration > l1)
        {
          paramView = "请选择不超过" + l1 / 60L / 1000L + "分钟的视频";
          QQToast.a(this.mActivity, paramView, 0).b(((NewPhotoListActivity)this.mActivity).getTitleBarHeight());
          return;
          i1 = 0;
        }
        else
        {
          l1 = blsb.b();
          if (paramView.fileSize > l1)
          {
            QQToast.a(this.mActivity, "请选择不超过" + (float)l1 / 1024.0F / 1024.0F / 1024.0F + "G的视频", 0).b(((NewPhotoListActivity)this.mActivity).getTitleBarHeight());
            return;
          }
        }
      }
      if ((i1 == 0) && (paramView.fileSize > this.mPhotoCommonData.videoSizeLimit))
      {
        paramView = bglp.a(this.mActivity, "你选择的视频文件过大，无法发送。");
        paramView.setPositiveButton(2131694081, new bgmc());
        paramView.show();
        return;
      }
      HashMap localHashMap = bgkc.sSelectItemAlbum;
      if (!localHashMap.containsKey(paramView.path))
      {
        Pair localPair = new Pair(this.mPhotoCommonData.albumId, this.mPhotoCommonData.albumName);
        localHashMap.put(paramView.path, localPair);
      }
      ((NewPhotoListActivity)this.mActivity).recordLastPos(paramView.path);
      if (("cover_mall_record_video".equals(str2)) && (paramView.mDuration / 1000L > this.jdField_a_of_type_Long / 1000L))
      {
        paramView = "视频时间不能超过" + this.jdField_a_of_type_Long / 1000L + "s，请重新选择";
        QQToast.a(this.mActivity, paramView, 0).b(((NewPhotoListActivity)this.mActivity).getTitleBarHeight());
        QLog.i("PhotoListActivity", 1, "QQToast:" + paramView);
        return;
      }
    } while (a(paramView, localIntent, str1));
    if (!this.jdField_a_of_type_Akht.jdField_b_of_type_Boolean)
    {
      a(paramView, localIntent);
      return;
    }
    if (((this.jdField_a_of_type_Boolean) || (this.jdField_b_of_type_Boolean) || (this.d) || (((akib)this.mOtherCommonData).a())) && ((this.jdField_a_of_type_Akht.isSupportVideoCheckbox) || (this.f)))
    {
      a(paramInt, localIntent);
      return;
    }
    b(paramView, localIntent);
  }
  
  public void enterAlbumListFragment(Intent paramIntent)
  {
    if (this.m) {
      d(paramIntent);
    }
    if (this.n)
    {
      paramIntent.putExtra("PhotoConst.IS_FROM_QZONE_AND_NEED_FILTER_RECENT_IMAGES", true);
      paramIntent.putExtra("PhotoConst.RECENT_IMAGES_MAX_COUNT", QzoneConfig.getInstance().getConfig("PhotoAlbum", "MaxRecentPhotoNum", 200));
      paramIntent.putExtra("PhotoConst.RECENT_IMAGES_LIMIT_SIZE", QzoneConfig.getInstance().getConfig("PhotoAlbum", "RecentPhotoLimitSize", 20480));
      paramIntent.putExtra("PhotoConst.RECENT_IMAGES_LIMIT_WIDTH", QzoneConfig.getInstance().getConfig("PhotoAlbum", "RecentPhotoLimitWidth", 100));
      String str = QzoneConfig.getInstance().getConfig("PhotoAlbum", "RecentPhotoBlockPaths", "MagazineUnlock");
      ArrayList localArrayList = null;
      if (str != null) {
        localArrayList = a(str);
      }
      paramIntent.putStringArrayListExtra("PhotoConst.RECENT_IMAGES_BLOCK_PATHS", localArrayList);
      paramIntent.putExtra("from_qzone", this.n);
    }
    super.enterAlbumListFragment(paramIntent);
  }
  
  public void enterPhotoPreviewActivity(boolean paramBoolean, Intent paramIntent)
  {
    paramIntent.putExtra("from_qzone", this.n);
    paramIntent.putExtra("readSource", this.jdField_b_of_type_JavaLangString);
    paramIntent.putExtra("p_e_s_type", 3);
    if (this.jdField_b_of_type_Boolean) {
      paramIntent.putExtra("PhotoConst.IS_FROM_SHUOSHUO", this.jdField_b_of_type_Boolean);
    }
    super.enterPhotoPreviewActivity(paramBoolean, paramIntent);
  }
  
  public String getExceedMaxSelectNumStr(LocalMediaInfo paramLocalMediaInfo)
  {
    String str2 = super.getExceedMaxSelectNumStr(paramLocalMediaInfo);
    long l1 = this.mPhotoCommonData.maxSelectNum;
    String str1 = str2;
    if (paramLocalMediaInfo != null)
    {
      paramLocalMediaInfo = MimeHelper.getMimeType(paramLocalMediaInfo.mMimeType);
      if ((a() <= 0) && ((!this.jdField_a_of_type_Akht.isSupportVideoCheckbox) || (paramLocalMediaInfo == null) || (!"video".equals(paramLocalMediaInfo[0])))) {
        break label202;
      }
      if ((a() == l1) && (this.jdField_a_of_type_Akht.isSupportVideoCheckbox) && (paramLocalMediaInfo != null) && ("video".equals(paramLocalMediaInfo[0]))) {
        ((NewPhotoListActivity)this.mActivity).getResources().getString(2131694278, new Object[] { Long.valueOf(l1) });
      }
      if (!((akib)this.mOtherCommonData).a()) {
        break label174;
      }
      str1 = ((NewPhotoListActivity)this.mActivity).getResources().getString(2131694277, new Object[] { Long.valueOf(l1) });
    }
    label174:
    label202:
    do
    {
      return str1;
      return ((NewPhotoListActivity)this.mActivity).getResources().getString(2131694275, new Object[] { Long.valueOf(l1) });
      str1 = str2;
    } while (this.jdField_a_of_type_Int != 1);
    return ((NewPhotoListActivity)this.mActivity).getResources().getString(2131694268, new Object[] { Long.valueOf(l1) });
  }
  
  public AbstractPhotoListActivity.Holder getViewCaseCamera(@NonNull AbstractPhotoListActivity.Holder paramHolder, int paramInt)
  {
    if ((this.jdField_b_of_type_Boolean) || (this.jdField_a_of_type_Boolean)) {
      a(1);
    }
    return super.getViewCaseCamera(paramHolder, paramInt);
  }
  
  public AbstractPhotoListActivity.Holder getViewCaseImage(@NonNull AbstractPhotoListActivity.Holder paramHolder, int paramInt)
  {
    AbstractPhotoListActivity.Holder localHolder = super.getViewCaseImage(paramHolder, paramInt);
    LocalMediaInfo localLocalMediaInfo = ((NewPhotoListActivity)this.mActivity).photoListAdapter.getItem(paramInt);
    if ((localLocalMediaInfo != null) && (localLocalMediaInfo.isPanoramaPhoto()) && ((this.jdField_b_of_type_Boolean) || (this.jdField_a_of_type_Boolean))) {
      paramHolder.mImageViewPanoramaIcon.setVisibility(0);
    }
    return localHolder;
  }
  
  public void handlePicCapture(Intent paramIntent)
  {
    a(5);
    super.handlePicCapture(paramIntent);
  }
  
  public void handleVideoCapture(Intent paramIntent)
  {
    a(4);
    super.handleVideoCapture(paramIntent);
  }
  
  public void handleVideoEncodeSucceed(Message paramMessage)
  {
    ((NewPhotoListActivity)this.mActivity).cancleProgressDailog();
    int i1;
    if ((paramMessage.obj instanceof String))
    {
      paramMessage = (String)paramMessage.obj;
      QZLog.d("PhotoListActivity", 2, new Object[] { "onEncodeSuccess = ", paramMessage });
      if (this.mPhotoCommonData.selectedPhotoList == null) {
        this.mPhotoCommonData.selectedPhotoList = new ArrayList();
      }
      if (!this.jdField_b_of_type_Boolean) {
        break label163;
      }
      i1 = bgkc.b();
      if (this.mPhotoCommonData.selectedPhotoList.size() < this.mPhotoCommonData.maxSelectNum) {
        break label170;
      }
      QQToast.a(this.mActivity, String.format(((NewPhotoListActivity)this.mActivity).getResources().getString(2131694275), new Object[] { Integer.valueOf(this.mPhotoCommonData.maxSelectNum) }), 0).a();
    }
    for (;;)
    {
      ((NewPhotoListActivity)this.mActivity).a(paramMessage);
      return;
      label163:
      i1 = bgkc.a();
      break;
      label170:
      if (a() >= i1)
      {
        QQToast.a(this.mActivity, String.format(((NewPhotoListActivity)this.mActivity).getResources().getString(2131694280), new Object[] { Integer.valueOf(i1) }), 0).a();
      }
      else
      {
        this.mPhotoCommonData.selectedPhotoList.add(paramMessage);
        ((NewPhotoListActivity)this.mActivity).b();
      }
    }
  }
  
  public void initData(Intent paramIntent)
  {
    this.o = paramIntent.getBooleanExtra("from_qzone_slideshow", false);
    ((akib)this.mOtherCommonData).a(this.o, this.mPhotoCommonData);
    super.initData(paramIntent);
    b(paramIntent);
    if (!TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString))
    {
      this.jdField_a_of_type_Boolean = a(this.jdField_a_of_type_JavaLangString);
      this.jdField_b_of_type_Boolean = b(this.jdField_a_of_type_JavaLangString);
      this.jdField_c_of_type_Boolean = c(this.jdField_a_of_type_JavaLangString);
      this.n = d(this.jdField_a_of_type_JavaLangString);
    }
    if (this.k)
    {
      this.d = true;
      this.jdField_b_of_type_Boolean = true;
    }
    if ((this.jdField_a_of_type_Boolean) || (this.jdField_b_of_type_Boolean)) {
      this.mPhotoCommonData.needMediaInfo = true;
    }
    if (this.m)
    {
      this.jdField_a_of_type_JavaUtilLinkedHashMap = new LinkedHashMap();
      c(paramIntent);
    }
    if (this.jdField_a_of_type_JavaUtilHashMap == null) {
      this.jdField_a_of_type_JavaUtilHashMap = new HashMap();
    }
    if (this.jdField_c_of_type_Boolean) {
      this.jdField_b_of_type_Int = paramIntent.getIntExtra("imageSizeLimit", 0);
    }
    if (this.jdField_a_of_type_Int == 1) {
      f();
    }
    if (this.f) {
      g();
    }
    if ((((akib)this.mOtherCommonData).a()) && (((NewPhotoListActivity)this.mActivity).getIntent().getIntExtra("qq_sub_business_id", -1) == 3))
    {
      zgl.a().c(22);
      zgl.a().b(14);
      zgl.a().e();
      ((NewPhotoListActivity)this.mActivity).getIntent().removeExtra("qq_sub_business_id");
    }
    if (((this.n) && (this.mPhotoCommonData.albumId.equals("$RecentAlbumId"))) || ((this.h) && (this.i)))
    {
      int i1 = QzoneConfig.getInstance().getConfig("PhotoAlbum", "RecentPhotoLimitSize", 20480);
      int i2 = QzoneConfig.getInstance().getConfig("PhotoAlbum", "RecentPhotoLimitWidth", 100);
      String str = QzoneConfig.getInstance().getConfig("PhotoAlbum", "RecentPhotoBlockPaths", "MagazineUnlock");
      paramIntent = null;
      if (str != null) {
        paramIntent = a(str);
      }
      this.mPhotoCommonData.filter.imageMinWidth = i2;
      this.mPhotoCommonData.filter.imageMinHeight = i2;
      this.mPhotoCommonData.filter.imageMinSize = i1;
      this.mPhotoCommonData.filter.blockPaths = paramIntent;
      this.mPhotoCommonData.filter.videoMaxDuration = this.jdField_a_of_type_Akht.filterVideoDurationLimit;
    }
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if ((this.o) && (paramInt2 == -1) && (paramInt1 != 24747))
    {
      ((NewPhotoListActivity)this.mActivity).setResult(paramInt2, paramIntent);
      ((NewPhotoListActivity)this.mActivity).finish();
      return;
    }
    if ((paramInt2 != -1) && (paramInt1 == 10001) && (this.o) && (paramIntent != null))
    {
      String str = paramIntent.getStringExtra("PhotoConst.FROM_QQSTORY_SLIDESHOW_DATA");
      if (!TextUtils.isEmpty(str)) {
        bgmg.a(new File(str).getParent());
      }
      ((NewPhotoListActivity)this.mActivity).setResult(0, paramIntent);
      ((NewPhotoListActivity)this.mActivity).finish();
    }
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
  }
  
  public void onCheckBoxClick(View paramView, int paramInt, CheckBox paramCheckBox)
  {
    LocalMediaInfo localLocalMediaInfo = ((NewPhotoListActivity)this.mActivity).photoListAdapter.getItem(paramInt);
    if (localLocalMediaInfo.selectStatus == 1) {}
    for (int i1 = 1; i1 == 0; i1 = 0)
    {
      String[] arrayOfString = MimeHelper.getMimeType(localLocalMediaInfo.mMimeType);
      if ((!this.jdField_a_of_type_Akht.isSupportVideoCheckbox) || (arrayOfString == null) || (!"video".equals(arrayOfString[0])) || (bgkc.a(this.mActivity, a(), localLocalMediaInfo, this.jdField_b_of_type_Boolean))) {
        break;
      }
      localLocalMediaInfo.selectStatus = 2;
      return;
    }
    super.onCheckBoxClick(paramView, paramInt, paramCheckBox);
    if (i1 == 0)
    {
      MimeHelper.getMimeType(localLocalMediaInfo.mMimeType);
      this.jdField_a_of_type_JavaUtilHashMap.put(localLocalMediaInfo.path, Integer.valueOf(localLocalMediaInfo.panoramaPhotoType));
      return;
    }
    MimeHelper.getMimeType(localLocalMediaInfo.mMimeType);
    this.jdField_a_of_type_JavaUtilHashMap.remove(localLocalMediaInfo.path);
  }
  
  public void onMagicStickClick(View paramView, Bundle paramBundle, int paramInt, Intent paramIntent)
  {
    b(paramView.getId());
    paramView = ((NewPhotoListActivity)this.mActivity).getIntent();
    if (this.mPhotoCommonData.selectedPhotoList.size() > 0)
    {
      paramView.removeExtra("param_initTime");
      paramView.putStringArrayListExtra("PhotoConst.PHOTO_PATHS", this.mPhotoCommonData.selectedPhotoList);
      bcst.b(null, "CliOper", "", "", "0x8004B39", "0x8004B39", 0, 0, "", "", "", "");
      paramView = new HashMap(1);
      if ((this.mPhotoCommonData.selectedMediaInfoHashMap != null) && (this.mPhotoCommonData.selectedMediaInfoHashMap.get(this.mPhotoCommonData.selectedPhotoList.get(0)) != null)) {
        paramView.put("param_localmediainfo", this.mPhotoCommonData.selectedMediaInfoHashMap.get(this.mPhotoCommonData.selectedPhotoList.get(0)));
      }
      paramView = a(EditPicActivity.a(this.mActivity, (String)this.mPhotoCommonData.selectedPhotoList.get(0), true, true, true, true, true, 3, 99, 5, paramView), (String)this.mPhotoCommonData.selectedPhotoList.get(0));
      ((NewPhotoListActivity)this.mActivity).startActivity(paramView);
      ((NewPhotoListActivity)this.mActivity).a.setClickable(false);
    }
  }
  
  public void onPreviewBtnClick(View paramView)
  {
    b(paramView.getId());
    super.onPreviewBtnClick(paramView);
  }
  
  public void onQueryMediaListBack(List<LocalMediaInfo> paramList)
  {
    if (((this.jdField_b_of_type_Boolean) || (this.jdField_a_of_type_Boolean)) && (QzoneConfig.getInstance().getConfig("PhotoAlbum", "paranoramaOpenCheck", 1) != 0)) {
      a(paramList);
    }
    for (;;)
    {
      super.onQueryMediaListBack(paramList);
      return;
      QLog.i("PhotoListActivity", 2, "@panoramatest isnot fromqzone");
    }
  }
  
  public void onSendBtnClick(View paramView)
  {
    b(paramView.getId());
    ((NewPhotoListActivity)this.mActivity).sendBtn.setClickable(false);
    if (!this.mPhotoCommonData.selectedPhotoList.isEmpty()) {
      ((NewPhotoListActivity)this.mActivity).recordLastPos((String)this.mPhotoCommonData.selectedPhotoList.get(this.mPhotoCommonData.selectedPhotoList.size() - 1));
    }
    bgkc.a();
    if (this.mPhotoCommonData.selectedPhotoList.size() == 0)
    {
      if (QLog.isColorLevel()) {
        QLog.e("PhotoList", 2, "size == 0");
      }
      return;
    }
    Intent localIntent = ((NewPhotoListActivity)this.mActivity).getIntent();
    if (localIntent.getBooleanExtra("PhotoConst.IS_SEND_FILESIZE_LIMIT", false))
    {
      paramView = this.mPhotoCommonData.selectedPhotoList.iterator();
      for (long l1 = 0L; paramView.hasNext(); l1 = bgmg.a((String)paramView.next()) + l1) {}
      if (atvo.a())
      {
        atvb.a(this.mActivity, 2131692321, 2131692326, new akjp(this));
        return;
      }
    }
    if (this.p)
    {
      String str = localIntent.getStringExtra("PhotoConst.DEST_ACTIVITY_CLASS_NAME");
      paramView = str;
      if (TextUtils.isEmpty(str)) {
        paramView = localIntent.getStringExtra("PhotoConst.INIT_ACTIVITY_CLASS_NAME");
      }
      localIntent.addFlags(603979776);
      QzonePluginProxyActivity.a(localIntent, paramView);
      paramView = blsi.a();
      blsb.a(this.mActivity, paramView, localIntent, -1, null);
      return;
    }
    b();
  }
  
  public void onTitleBtnCancelClick(View paramView)
  {
    if (paramView != null) {
      b(paramView.getId());
    }
    paramView = ((NewPhotoListActivity)this.mActivity).getIntent();
    bgkc.clearSelectItemInfo();
    bgkc.a();
    Object localObject = PresendPicMgr.a();
    if (localObject != null) {
      ((PresendPicMgr)localObject).a(1006);
    }
    if (this.mPhotoCommonData.selectedPhotoList != null) {}
    for (int i1 = this.mPhotoCommonData.selectedPhotoList.size();; i1 = 0)
    {
      akgm.b(paramView, i1);
      if (this.jdField_a_of_type_Akht.i) {
        break;
      }
      ((NewPhotoListActivity)this.mActivity).finish();
      bgkc.anim(this.mActivity, false, false);
      return;
    }
    localObject = paramView.getStringExtra("PhotoConst.INIT_ACTIVITY_CLASS_NAME");
    String str1 = paramView.getStringExtra("PhotoConst.INIT_ACTIVITY_PACKAGE_NAME");
    if (localObject == null)
    {
      QQToast.a(this.mActivity, "请设置INIT_ACTIVITY_CLASS_NAME ", 0).a();
      return;
    }
    paramView.setClassName(str1, (String)localObject);
    paramView.removeExtra("PhotoConst.PHOTO_PATHS");
    paramView.removeExtra("PhotoConst.SINGLE_PHOTO_PATH");
    if (this.jdField_a_of_type_Boolean) {
      paramView.removeExtra("PeakConstants.selectedMediaInfoHashMap");
    }
    paramView.addFlags(603979776);
    if (!paramView.getBooleanExtra("PhotoConst.IS_CALL_IN_PLUGIN", false)) {
      ((NewPhotoListActivity)this.mActivity).startActivity(paramView);
    }
    for (;;)
    {
      ((NewPhotoListActivity)this.mActivity).finish();
      bgkc.anim(this.mActivity, false, false);
      return;
      paramView.getStringExtra("PhotoConst.PLUGIN_NAME");
      str1 = paramView.getStringExtra("PhotoConst.PLUGIN_APK");
      String str2 = paramView.getStringExtra("PhotoConst.UIN");
      if ("qzone_plugin.apk".equals(str1))
      {
        QzonePluginProxyActivity.a(paramView, (String)localObject);
        blsb.a(this.mActivity, str2, paramView, 2);
      }
      else if ("qqfav.apk".equals(str1))
      {
        bljn.a(this.mActivity, str2, paramView, 2);
      }
      else
      {
        QLog.e("PhotoListActivity", 1, "Watermark has been deleted!");
      }
    }
  }
  
  public void postInitUI()
  {
    super.postInitUI();
    ((NewPhotoListActivity)this.mActivity).mGridView.addOnScrollListener(new akjn(this));
    if ((TextUtils.isEmpty(this.jdField_a_of_type_Akht.customSendBtnText)) && (1 == this.jdField_a_of_type_Int))
    {
      String str = ((NewPhotoListActivity)this.mActivity).getString(2131694281);
      ((NewPhotoListActivity)this.mActivity).c.setVisibility(0);
      ((NewPhotoListActivity)this.mActivity).c.setText(((NewPhotoListActivity)this.mActivity).getString(2131694290));
      ((NewPhotoListActivity)this.mActivity).sendBtn.setText(str);
    }
  }
  
  public void startPhotoPreviewActivity(Intent paramIntent)
  {
    if (this.jdField_a_of_type_Int == 1)
    {
      aevv.a(this.mActivity, paramIntent, PublicFragmentActivityForPeak.class, QzonePhotoPreviewActivity.class);
      return;
    }
    super.startPhotoPreviewActivity(paramIntent);
  }
  
  public void updateButton()
  {
    boolean bool2 = true;
    boolean bool1 = true;
    super.updateButton();
    String str;
    if (this.jdField_a_of_type_Akht.customSendBtnText != null)
    {
      str = this.jdField_a_of_type_Akht.customSendBtnText;
      if (1 == this.jdField_a_of_type_Int) {
        break label209;
      }
      if (this.mPhotoCommonData.selectedPhotoList.size() <= 0) {
        break label204;
      }
      label47:
      if (!bool1) {
        break label233;
      }
      str = str + "(" + this.mPhotoCommonData.selectedPhotoList.size() + ")";
    }
    label204:
    label209:
    label233:
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("_photo", 2, "updateButton selectedPhotoList.size()=" + this.mPhotoCommonData.selectedPhotoList.size());
      }
      ((NewPhotoListActivity)this.mActivity).sendBtn.setText(str);
      ((NewPhotoListActivity)this.mActivity).sendBtn.setEnabled(bool1);
      return;
      if (1 == this.jdField_a_of_type_Int)
      {
        str = ((NewPhotoListActivity)this.mActivity).getString(2131694281);
        break;
      }
      str = ((NewPhotoListActivity)this.mActivity).getString(2131694260);
      break;
      bool1 = false;
      break label47;
      if (this.mPhotoCommonData.selectedPhotoList.size() >= 3) {}
      for (bool1 = bool2;; bool1 = false) {
        break;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     akjm
 * JD-Core Version:    0.7.0.1
 */