import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Message;
import android.text.TextUtils;
import android.util.Pair;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
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
import com.tencent.mobileqq.activity.photo.album.AbstractPhotoListActivity.CheckBoxClickedListener;
import com.tencent.mobileqq.activity.photo.album.AbstractPhotoListActivity.PhotoListAdapter;
import com.tencent.mobileqq.activity.photo.album.AbstractPhotoListActivity.PhotoListAdapter.Holder;
import com.tencent.mobileqq.activity.photo.album.NewPhotoListActivity;
import com.tencent.mobileqq.activity.photo.album.NewPhotoPreviewActivity;
import com.tencent.mobileqq.activity.photo.album.logicImp.PhotoListLogicQzone.2;
import com.tencent.mobileqq.activity.shortvideo.SendVideoActivity.SendVideoInfo;
import com.tencent.mobileqq.activity.shortvideo.ShortVideoPreviewActivity;
import com.tencent.mobileqq.pic.PresendPicMgr;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.AbsListView.LayoutParams;
import com.tencent.widget.AdapterView;
import com.tencent.widget.GestureSelectGridView;
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

public class aisq
  extends aira
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
  private boolean k;
  private boolean l;
  private boolean m;
  private boolean n;
  private boolean o;
  private boolean p;
  
  aisq(NewPhotoListActivity paramNewPhotoListActivity)
  {
    super(paramNewPhotoListActivity);
    this.jdField_a_of_type_JavaLangString = "";
  }
  
  private Intent a(Intent paramIntent, String paramString)
  {
    if ((this.jdField_b_of_type_Boolean) || (this.jdField_a_of_type_Boolean) || (this.jdField_c_of_type_Boolean) || (this.o) || (this.m)) {
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
          if (paramInt1 < ((NewPhotoListActivity)this.mActivity).photoListAdapter.getCount())
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
      azri.a(BaseApplication.getContext()).a(null, "qzoneChoosePhotoCamera", true, 0L, 0L, localHashMap, null, true);
      return;
      if (!this.k)
      {
        this.k = true;
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
  
  private void a(LocalMediaInfo paramLocalMediaInfo)
  {
    bjvs.a().a(new aiss(this, paramLocalMediaInfo));
  }
  
  private void a(List<LocalMediaInfo> paramList)
  {
    QzoneHandlerThreadFactory.getHandlerThread("Normal_HandlerThread").post(new PhotoListLogicQzone.2(this, paramList));
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
      case 2131368624: 
        i1 = 3;
      }
    }
    for (;;)
    {
      if ((this.jdField_a_of_type_Int != 1) || (paramInt != 2131376395)) {
        break label156;
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
    label156:
    LpReportInfo_pf00064.allReport(i3, i2, i1);
  }
  
  private void b(Intent paramIntent)
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
  
  private void c(Intent paramIntent)
  {
    if ((this.mPhotoCommonData.selectedMediaInfoHashMap == null) || (this.jdField_a_of_type_JavaUtilLinkedHashMap == null)) {
      return;
    }
    for (;;)
    {
      try
      {
        if ((!this.p) && (((NewPhotoListActivity)this.mActivity).photoListAdapter != null) && (((NewPhotoListActivity)this.mActivity).photoListAdapter.getCount() > 0)) {
          g();
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
  
  private void g()
  {
    if ((((NewPhotoListActivity)this.mActivity).mGridView == null) || (this.jdField_a_of_type_JavaUtilLinkedHashMap == null)) {
      return;
    }
    Object localObject = a(((NewPhotoListActivity)this.mActivity).mGridView.getFirstVisiblePosition(), ((NewPhotoListActivity)this.mActivity).mGridView.getLastVisiblePosition());
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
    this.p = true;
  }
  
  private void h()
  {
    Object localObject = bjfd.a();
    if ((!((bjfe)localObject).a()) || (!axpm.a()))
    {
      String str = QzoneConfig.getInstance().getConfig("QZoneTextSetting", "PhotoListCameraNotSupport", "当前不支持拍摄");
      if ((((bjfe)localObject).a() != null) && (((bjfe)localObject).b()))
      {
        str = QzoneConfig.getInstance().getConfig("QZoneTextSetting", "ToastStartLiveVideoFailForMemory", "SD卡不存在或手机内存不足");
        QQToast.a(this.mActivity, str, 0).a();
      }
      for (;;)
      {
        if (((bjfe)localObject).a() != null) {
          QZLog.e("PhotoListActivity", 2, new Object[] { "gotoCamera fail", ((bjfe)localObject).a() });
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
    ((Intent)localObject).putExtra("pic_confirm_text", ((NewPhotoListActivity)this.mActivity).getString(2131695245));
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
  
  protected void a(Intent paramIntent, boolean paramBoolean, ArrayList<String> paramArrayList)
  {
    int i7 = PhotoUtils.b(this.jdField_a_of_type_Aiqz.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo);
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
      PhotoUtils.a(this.mActivity, paramIntent, this.mPhotoCommonData.selectedPhotoList, this.jdField_a_of_type_Aiqz.jdField_a_of_type_JavaUtilHashMap, this.mPhotoCommonData.currentQualityType, false);
    }
    for (;;)
    {
      azqs.b(null, "CliOper", "", "", "0X8009AB0", "0X8009AB0", i7, 0, String.valueOf(i2), String.valueOf(i1), "", "");
      return;
      PhotoUtils.a(this.mActivity, paramIntent, this.mPhotoCommonData.selectedPhotoList, this.mPhotoCommonData.currentQualityType, this.jdField_a_of_type_Aiqz.jdField_a_of_type_Boolean);
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
    if ((!this.jdField_a_of_type_Aiqz.f) && (!this.jdField_a_of_type_Aiqz.g) && (this.jdField_b_of_type_Boolean)) {
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
      if ((!this.jdField_a_of_type_Aiqz.isSupportVideoCheckbox) || (arrayOfString == null) || (!"video".equals(arrayOfString[0])) || (bdfa.a(this.mActivity, this.mPhotoCommonData.getSelectedVideoNum(), paramLocalMediaInfo, this.jdField_b_of_type_Boolean))) {}
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
      azri.a(this.mActivity).a(null, "sendAlbumRecent", true, 0L, 0L, null, "");
    }
    Object localObject;
    for (;;)
    {
      localObject = PresendPicMgr.a();
      if ((!this.jdField_a_of_type_Aiqz.e) || ((TextUtils.isEmpty(this.jdField_a_of_type_Aiqz.jdField_a_of_type_JavaLangString)) && (TextUtils.isEmpty(this.jdField_a_of_type_Aiqz.jdField_b_of_type_JavaLangString)))) {
        break;
      }
      ((NewPhotoListActivity)this.mActivity).a.performClick();
      return;
      if ((this.mPhotoCommonData.albumName.equalsIgnoreCase("Camera")) || (this.mPhotoCommonData.albumName.equalsIgnoreCase("camera")) || (this.mPhotoCommonData.albumName.contains("Camera")) || (this.mPhotoCommonData.albumName.contains("camera"))) {
        azri.a(this.mActivity).a(null, "sendAlbumRecent", false, 0L, 0L, null, "");
      } else {
        azri.a(this.mActivity).a(null, "sendAlbumOther", true, 0L, 0L, null, "");
      }
    }
    if (this.mPhotoCommonData.selectedPhotoList != null)
    {
      aips.a(localIntent, this.mPhotoCommonData.selectedPhotoList.size());
      aips.a(localIntent, this.mPhotoCommonData.selectedPhotoList.size(), this.mPhotoCommonData.currentQualityType);
    }
    if (this.mPhotoCommonData.currentQualityType == 2)
    {
      if (localObject != null)
      {
        ((PresendPicMgr)localObject).a(1008);
        ((PresendPicMgr)localObject).a();
      }
      azqs.b(null, "CliOper", "", "", "0X8005148", "0X8005148", 0, 0, "", "", "", "");
      localObject = localIntent.getStringExtra("PhotoConst.PLUGIN_APK");
      String str = localIntent.getStringExtra("PhotoConst.INIT_ACTIVITY_CLASS_NAME");
      if (("qzone_plugin.apk".equals(localObject)) && ("com.qzone.video.activity.TrimVideoActivity".equals(str)))
      {
        localIntent.putExtra("PhotoConst.PLUGIN_NAME", "QZone");
        localIntent.putExtra("PhotoConst.PLUGIN_APK", "qzone_plugin.apk");
        localIntent.putExtra("PhotoConst.INIT_ACTIVITY_PACKAGE_NAME", "com.tencent.mobileqq");
        localIntent.putExtra("PhotoConst.INIT_ACTIVITY_CLASS_NAME", "com.qzone.publish.ui.activity.QZonePublishMoodRealActivity");
      }
      if ("qzone_plugin.apk".equals(localObject)) {
        localIntent.putExtra("isEmbedInTabActivity", localIntent.getBooleanExtra("isEmbedInTabActivity", false));
      }
      if ((this.jdField_a_of_type_Boolean) || ((this.jdField_b_of_type_Boolean) && (e)) || (this.d)) {
        localIntent.putExtra("PeakConstants.selectedMediaInfoHashMap", this.mPhotoCommonData.selectedMediaInfoHashMap);
      }
      if (this.l) {
        c(localIntent);
      }
      if (this.mPhotoCommonData.selectedPhotoList != null) {
        ajrw.a(this.mPhotoCommonData.selectedPhotoList);
      }
      a(localIntent);
      localIntent.putExtra("PhotoConst.PANORAMA_IMAGES", this.jdField_a_of_type_JavaUtilHashMap);
      if (1 != this.jdField_a_of_type_Int) {
        break label581;
      }
      localIntent.putExtra("PhotoConst.KEY_SHOW_TYPE", 1);
      localIntent.putExtra("PhotoConst.KEY_SHOW_ORIGIN_TYPE", 1);
    }
    for (;;)
    {
      localIntent.putExtra("key_state_type", this.jdField_c_of_type_Int);
      a(localIntent, false, this.mPhotoCommonData.selectedPhotoList);
      return;
      if ((localObject == null) || (this.jdField_a_of_type_Aiqz.l)) {
        break;
      }
      ((PresendPicMgr)localObject).a(localIntent);
      break;
      label581:
      localIntent.putExtra("PhotoConst.KEY_SHOW_TYPE", 0);
    }
  }
  
  public void caseCamera(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    if (!bdeu.a())
    {
      QQToast.a(this.mActivity, ((NewPhotoListActivity)this.mActivity).getResources().getString(2131719547), 0).a();
      return;
    }
    if ((this.jdField_b_of_type_Boolean) || (this.jdField_a_of_type_Boolean))
    {
      h();
      return;
    }
    ((NewPhotoListActivity)this.mActivity).a();
  }
  
  public Intent caseNoSingModeImage(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    paramAdapterView = super.caseNoSingModeImage(paramAdapterView, paramView, paramInt, paramLong);
    paramView = ((NewPhotoListActivity)this.mActivity).photoListAdapter.getItem(paramInt);
    ArrayList localArrayList1;
    ArrayList localArrayList2;
    int i1;
    int i3;
    if ((this.jdField_b_of_type_Boolean) && (!e) && (this.mPhotoCommonData.allMediaInfoHashMap != null))
    {
      localArrayList1 = new ArrayList();
      localArrayList2 = new ArrayList();
      i1 = paramInt - 1;
      int i2 = 0;
      int i4 = this.mPhotoCommonData.mediaPathsList.size();
      i3 = 0;
      if (i3 < i4)
      {
        String str = (String)this.mPhotoCommonData.mediaPathsList.get(i3);
        LocalMediaInfo localLocalMediaInfo = (LocalMediaInfo)this.mPhotoCommonData.allMediaInfoHashMap.get(str);
        if (bdfa.getMediaType(localLocalMediaInfo) != 0) {
          break label312;
        }
        localArrayList1.add(str);
        if ((this.mPhotoCommonData.selectedPhotoList != null) && (this.mPhotoCommonData.selectedPhotoList.contains(str))) {
          localArrayList2.add(Integer.valueOf(i2));
        }
        if (localLocalMediaInfo.position.intValue() != paramInt - 1) {
          break label309;
        }
        i1 = i2;
        label200:
        i2 += 1;
      }
    }
    label309:
    label312:
    for (;;)
    {
      i3 += 1;
      break;
      this.mPhotoCommonData.mediaPathsList = localArrayList1;
      paramAdapterView.putStringArrayListExtra("PhotoConst.PHOTO_PATHS", localArrayList1);
      paramAdapterView.putStringArrayListExtra("PhotoConst.SELECTED_PATHS", this.mPhotoCommonData.selectedPhotoList);
      paramAdapterView.putIntegerArrayListExtra("PhotoConst.SELECTED_INDEXS", localArrayList2);
      if (bdfa.getMediaType(paramView) == 0) {
        paramAdapterView.putExtra("PhotoConst.CURRENT_SELECTED_INDEX", i1);
      }
      paramAdapterView.putExtra("from_qzone", this.m);
      if (this.jdField_b_of_type_Boolean) {
        paramAdapterView.putExtra("PhotoConst.IS_FROM_SHUOSHUO", this.jdField_b_of_type_Boolean);
      }
      return paramAdapterView;
      break label200;
    }
  }
  
  public void caseSingleModeImage(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    LocalMediaInfo localLocalMediaInfo = ((NewPhotoListActivity)this.mActivity).photoListAdapter.getItem(paramInt);
    if ((this.jdField_c_of_type_Boolean) && (localLocalMediaInfo.mediaWidth > 0) && (localLocalMediaInfo.mediaHeight > 0) && (this.jdField_b_of_type_Int > 0) && (localLocalMediaInfo.fileSize > this.jdField_b_of_type_Int))
    {
      QQToast.a(this.mActivity, ((NewPhotoListActivity)this.mActivity).getResources().getString(2131695332, new Object[] { Integer.valueOf(this.jdField_b_of_type_Int / 1048576) }), 0).b(((NewPhotoListActivity)this.mActivity).getResources().getDimensionPixelSize(2131298914));
      return;
    }
    super.caseSingleModeImage(paramAdapterView, paramView, paramInt, paramLong);
  }
  
  public void caseVideo(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    if (!bdeu.a()) {
      QQToast.a(this.mActivity, ((NewPhotoListActivity)this.mActivity).getResources().getString(2131719547), 0).a();
    }
    do
    {
      return;
      paramView = ((NewPhotoListActivity)this.mActivity).photoListAdapter.getItem(paramInt);
    } while (paramView == null);
    paramAdapterView = ((NewPhotoListActivity)this.mActivity).getIntent();
    Object localObject = paramAdapterView.getStringExtra("PhotoConst.PLUGIN_APK");
    String str = paramAdapterView.getStringExtra("video_refer");
    int i1 = 0;
    if (!TextUtils.isEmpty(str))
    {
      if ((!str.contains("QZonePublishMoodTabActivity")) && (!str.contains("QZoneUploadPhotoRealActivity"))) {
        break label206;
      }
      i1 = 1;
    }
    while (i1 != 0)
    {
      paramLong = paramAdapterView.getLongExtra("PhotoConst.PHOTOLIST_KEY_VIDEO_CAN_UPLOAD_DURATION", 9223372036854775807L);
      if (paramView.mDuration > paramLong)
      {
        paramAdapterView = "请选择不超过" + paramLong / 60L / 1000L + "分钟的视频";
        QQToast.a(this.mActivity, paramAdapterView, 0).b(((NewPhotoListActivity)this.mActivity).getTitleBarHeight());
        return;
        label206:
        i1 = 0;
      }
      else
      {
        paramLong = bjdt.b();
        if (paramView.fileSize > paramLong)
        {
          QQToast.a(this.mActivity, "请选择不超过" + (float)paramLong / 1024.0F / 1024.0F / 1024.0F + "G的视频", 0).b(((NewPhotoListActivity)this.mActivity).getTitleBarHeight());
          return;
        }
      }
    }
    if ((i1 == 0) && (paramView.fileSize > this.mPhotoCommonData.videoSizeLimit))
    {
      paramAdapterView = bdgm.a(this.mActivity, "你选择的视频文件过大，无法发送。");
      paramAdapterView.setPositiveButton(2131694953, new bdgx());
      paramAdapterView.show();
      return;
    }
    HashMap localHashMap = bdfa.sSelectItemAlbum;
    if (!localHashMap.containsKey(paramView.path))
    {
      Pair localPair = new Pair(this.mPhotoCommonData.albumId, this.mPhotoCommonData.albumName);
      localHashMap.put(paramView.path, localPair);
    }
    ((NewPhotoListActivity)this.mActivity).recordLastPos(paramView.path);
    if (("cover_mall_record_video".equals(str)) && (paramView.mDuration / 1000L > this.jdField_a_of_type_Long / 1000L))
    {
      paramAdapterView = "视频时间不能超过" + this.jdField_a_of_type_Long / 1000L + "s，请重新选择";
      QQToast.a(this.mActivity, paramAdapterView, 0).b(((NewPhotoListActivity)this.mActivity).getTitleBarHeight());
      QLog.i("PhotoListActivity", 1, "QQToast:" + paramAdapterView);
      return;
    }
    if (this.f) {
      if ("qzone_plugin.apk".equals(localObject))
      {
        localObject = paramAdapterView.getStringExtra("PhotoConst.INIT_ACTIVITY_CLASS_NAME");
        if ((localObject == null) || (((String)localObject).contains("TrimVideoActivity"))) {
          break label884;
        }
        if ((this.mPhotoCommonData.selectedPhotoList != null) && (this.mPhotoCommonData.selectedPhotoList.size() > 0))
        {
          QQToast.a(this.mActivity, "不能同时选择照片和视频", 0).a();
          this.jdField_a_of_type_Aiqz.jdField_b_of_type_Boolean = false;
          return;
        }
        if (paramView.mDuration >= this.mPhotoCommonData.videoDurationLimit) {
          break label755;
        }
        this.jdField_a_of_type_Aiqz.jdField_b_of_type_Boolean = true;
      }
    }
    while (!this.jdField_a_of_type_Aiqz.jdField_b_of_type_Boolean)
    {
      paramAdapterView.putExtra("file_send_path", paramView.path);
      paramAdapterView.putExtra("PhotoConst.IS_VIDEO_SELECTED", true);
      paramAdapterView.putExtra("PhotoConst.VIDEO_SIZE", paramView.fileSize);
      paramAdapterView.putExtra("file_send_duration", paramView.mDuration);
      paramAdapterView.putExtra("file_width", paramView.mediaWidth);
      paramAdapterView.putExtra("file_height", paramView.mediaHeight);
      paramAdapterView.putExtra("media_info", paramView);
      localObject = new ArrayList();
      ((ArrayList)localObject).add(paramView.path);
      PhotoUtils.a(this.mActivity, paramAdapterView, (ArrayList)localObject, 2, false);
      return;
      label755:
      this.jdField_a_of_type_Aiqz.jdField_b_of_type_Boolean = false;
      paramAdapterView = new StringBuilder();
      paramLong = this.mPhotoCommonData.videoDurationLimit / 1000L;
      if (paramLong > 60L)
      {
        paramLong /= 60L;
        if (paramLong > 60L) {
          paramAdapterView.append(paramLong / 60L).append("小时");
        }
      }
      for (;;)
      {
        paramAdapterView.append("以上的视频不可选");
        QQToast.a(this.mActivity, paramAdapterView.toString(), 0).a();
        return;
        paramAdapterView.append(paramLong).append("分钟");
        continue;
        paramAdapterView.append(paramLong).append("秒");
      }
      label884:
      if (this.mPhotoCommonData.a())
      {
        this.jdField_a_of_type_Aiqz.jdField_b_of_type_Boolean = true;
      }
      else
      {
        localObject = this.jdField_a_of_type_Aiqz;
        if (paramView.mDuration > this.mPhotoCommonData.videoDurationLimit) {}
        for (boolean bool = true;; bool = false)
        {
          ((aiqz)localObject).jdField_b_of_type_Boolean = bool;
          paramAdapterView.putExtra("PhotoConst.IS_PREVIEW_VIDEO", this.jdField_a_of_type_Aiqz.jdField_b_of_type_Boolean);
          break;
        }
        if ("qzone_plugin.apk".equals(localObject))
        {
          localObject = paramAdapterView.getStringExtra("PhotoConst.INIT_ACTIVITY_CLASS_NAME");
          if ((localObject != null) && (!((String)localObject).contains("TrimVideoActivity")))
          {
            if ((this.j) || (paramView.mDuration > this.mPhotoCommonData.videoDurationLimit) || (this.jdField_a_of_type_Boolean) || ((this.jdField_b_of_type_Boolean) && (e)))
            {
              this.jdField_a_of_type_Aiqz.jdField_b_of_type_Boolean = true;
            }
            else
            {
              this.jdField_a_of_type_Aiqz.jdField_b_of_type_Boolean = false;
              paramAdapterView.putExtra("support_record", false);
              paramAdapterView.putExtra("support_trim", true);
              paramAdapterView.putExtra("PhotoConst.IS_CALL_IN_PLUGIN", false);
              paramAdapterView.putExtra("PhotoConst.INIT_ACTIVITY_PACKAGE_NAME", "com.tencent.mobileqq");
              paramAdapterView.putExtra("PhotoConst.INIT_ACTIVITY_CLASS_NAME", "cooperation.qzone.QZoneVideoDownloadActivity");
              paramAdapterView.putExtra("PhotoConst.SHOW_MAGIC_USE_PASTER", this.jdField_a_of_type_Aiqz.e);
            }
          }
          else if (this.mPhotoCommonData.a())
          {
            this.jdField_a_of_type_Aiqz.jdField_b_of_type_Boolean = true;
          }
          else
          {
            localObject = this.jdField_a_of_type_Aiqz;
            if (paramView.mDuration > this.mPhotoCommonData.videoDurationLimit) {}
            for (bool = true;; bool = false)
            {
              ((aiqz)localObject).jdField_b_of_type_Boolean = bool;
              paramAdapterView.putExtra("PhotoConst.IS_PREVIEW_VIDEO", this.jdField_a_of_type_Aiqz.jdField_b_of_type_Boolean);
              break;
            }
          }
        }
      }
    }
    if (((this.jdField_a_of_type_Boolean) || (this.jdField_b_of_type_Boolean) || (this.d) || (this.mPhotoCommonData.a())) && ((this.jdField_a_of_type_Aiqz.isSupportVideoCheckbox) || (this.f)))
    {
      paramView = ((NewPhotoListActivity)this.mActivity).getIntent();
      paramView.putExtra("ALBUM_NAME", this.mPhotoCommonData.albumName);
      paramView.putExtra("ALBUM_ID", this.mPhotoCommonData.albumId);
      localObject = ((NewPhotoListActivity)this.mActivity).photoListAdapter.getItem(paramInt);
      i1 = ((LocalMediaInfo)localObject).position.intValue();
      paramInt = i1;
      if (!e)
      {
        paramInt = i1;
        if (bdfa.getMediaType((LocalMediaInfo)localObject) == 1)
        {
          if (this.mPhotoCommonData.mediaPathsList == null) {
            break label1843;
          }
          this.mPhotoCommonData.mediaPathsList.clear();
          this.mPhotoCommonData.mediaPathsList.add(((LocalMediaInfo)localObject).path);
          if (this.mPhotoCommonData.selectedPhotoList == null) {
            break label1860;
          }
          this.mPhotoCommonData.selectedPhotoList.clear();
          label1392:
          this.mPhotoCommonData.selectedPhotoList.add(((LocalMediaInfo)localObject).path);
          if (this.mPhotoCommonData.selectedIndex == null) {
            break label1877;
          }
          this.mPhotoCommonData.selectedIndex.clear();
          label1428:
          this.mPhotoCommonData.selectedIndex.add(Integer.valueOf(0));
          if (this.mPhotoCommonData.selectedMediaInfoHashMap == null) {
            break label1894;
          }
          this.mPhotoCommonData.selectedMediaInfoHashMap.clear();
          label1463:
          this.mPhotoCommonData.selectedMediaInfoHashMap.put(((LocalMediaInfo)localObject).path, localObject);
          paramInt = 0;
          paramView.putExtra("PhotoConst.IS_SINGLE_MODE", true);
        }
      }
      paramView.putExtra("PhotoConst.CURRENT_SELECTED_INDEX", paramInt);
      paramView.putStringArrayListExtra("PhotoConst.SELECTED_PATHS", this.mPhotoCommonData.selectedPhotoList);
      paramView.putIntegerArrayListExtra("PhotoConst.SELECTED_INDEXS", this.mPhotoCommonData.selectedIndex);
      paramView.putExtra("FROM_WHERE", "FROM_PHOTO_LIST");
      paramView.putExtra("PhotoConst.CURRENT_QUALITY_TYPE", this.mPhotoCommonData.currentQualityType);
      paramView.putExtra("PhotoConst.SHOW_ALBUM", true);
      paramView.putExtra("PhotoConst.SHOW_MAGIC_USE_PASTER", this.jdField_a_of_type_Aiqz.e);
      paramView.putExtra("PasterConstants.paster_id", this.jdField_a_of_type_Aiqz.jdField_a_of_type_JavaLangString);
      paramView.putExtra("PasterConstants.paster_cate_id", this.jdField_a_of_type_Aiqz.jdField_b_of_type_JavaLangString);
      aiqz.sPhotoListFirstPos = ((NewPhotoListActivity)this.mActivity).mGridView.getFirstVisiblePosition();
      if (!this.mPhotoCommonData.selectedMediaInfoHashMap.containsKey(((LocalMediaInfo)localObject).path)) {
        this.mPhotoCommonData.selectedMediaInfoHashMap.put(((LocalMediaInfo)localObject).path, localObject);
      }
      paramView.putExtra("PeakConstants.selectedMediaInfoHashMap", this.mPhotoCommonData.selectedMediaInfoHashMap);
      paramView.putExtra("PasterConstants.pasters_data", this.jdField_a_of_type_Aiqz.jdField_b_of_type_JavaUtilHashMap);
      paramView.setClass(this.mActivity, NewPhotoPreviewActivity.class);
      if (this.jdField_b_of_type_Boolean) {
        paramAdapterView.putExtra("PhotoConst.IS_FROM_SHUOSHUO", this.jdField_b_of_type_Boolean);
      }
      paramView.putExtra("from_qzone", this.m);
      paramView.addFlags(603979776);
      if ((this.mPhotoCommonData.selectedPhotoList != null) && (this.mPhotoCommonData.selectedPhotoList.size() > 0)) {
        azqs.b(null, "CliOper", "", this.mPhotoCommonData.myUin, "0X8005674", "0X8005674", 0, this.mPhotoCommonData.selectedPhotoList.size(), 0, "", "", "", "");
      }
      if (this.mPhotoCommonData.a()) {
        ((NewPhotoListActivity)this.mActivity).startActivityForResult(paramAdapterView, 100010);
      }
      for (;;)
      {
        bdfa.anim(this.mActivity, true, true);
        return;
        label1843:
        this.mPhotoCommonData.mediaPathsList = new ArrayList();
        break;
        label1860:
        this.mPhotoCommonData.selectedPhotoList = new ArrayList();
        break label1392;
        label1877:
        this.mPhotoCommonData.selectedIndex = new ArrayList();
        break label1428;
        label1894:
        this.mPhotoCommonData.selectedMediaInfoHashMap = new HashMap();
        break label1463;
        ((NewPhotoListActivity)this.mActivity).startActivity(paramView);
        ((NewPhotoListActivity)this.mActivity).finish();
      }
    }
    localObject = new Intent(this.mActivity, ShortVideoPreviewActivity.class);
    ((Intent)localObject).putExtras(paramAdapterView);
    ((Intent)localObject).putExtra("file_send_path", paramView.path);
    ((Intent)localObject).putExtra("file_send_size", paramView.fileSize);
    ((Intent)localObject).putExtra("file_send_duration", paramView.mDuration);
    ((Intent)localObject).putExtra("file_width", paramView.mediaWidth);
    ((Intent)localObject).putExtra("file_height", paramView.mediaHeight);
    ((Intent)localObject).putExtra("uin", this.jdField_a_of_type_Aiqz.d);
    ((Intent)localObject).putExtra("uintype", this.jdField_a_of_type_Aiqz.jdField_a_of_type_Int);
    ((Intent)localObject).putExtra("file_source", "album");
    ((Intent)localObject).putExtra("is_from_system_media", paramView.isSystemMeidaStore);
    if (this.jdField_a_of_type_Aiqz.isSupportVideoCheckbox)
    {
      ((Intent)localObject).putExtra("PhotoConst.IS_SUPPORT_VIDEO_CHECKBOX", true);
      ((Intent)localObject).putExtra("PhotoConst.PHOTO_PATHS", this.mPhotoCommonData.selectedPhotoList);
    }
    if (((this.jdField_a_of_type_Boolean) || ((this.jdField_b_of_type_Boolean) && (e) && (!g))) && (this.jdField_a_of_type_Aiqz.isSupportVideoCheckbox)) {
      ((Intent)localObject).putExtra("preview_only", true);
    }
    ((NewPhotoListActivity)this.mActivity).startActivityForResult((Intent)localObject, 17);
  }
  
  public void enterAlbumListFragment(Intent paramIntent)
  {
    if (this.l) {
      c(paramIntent);
    }
    if (this.m)
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
      paramIntent.putExtra("from_qzone", this.m);
    }
    super.enterAlbumListFragment(paramIntent);
  }
  
  public void enterPhotoPreviewActivity(boolean paramBoolean, Intent paramIntent)
  {
    paramIntent.putExtra("from_qzone", this.m);
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
      if ((this.mPhotoCommonData.getSelectedVideoNum() <= 0) && ((!this.jdField_a_of_type_Aiqz.isSupportVideoCheckbox) || (paramLocalMediaInfo == null) || (!"video".equals(paramLocalMediaInfo[0])))) {
        break label205;
      }
      if ((this.mPhotoCommonData.getSelectedVideoNum() == l1) && (this.jdField_a_of_type_Aiqz.isSupportVideoCheckbox) && (paramLocalMediaInfo != null) && ("video".equals(paramLocalMediaInfo[0]))) {
        ((NewPhotoListActivity)this.mActivity).getResources().getString(2131695263, new Object[] { Long.valueOf(l1) });
      }
      if (!this.mPhotoCommonData.a()) {
        break label177;
      }
      str1 = ((NewPhotoListActivity)this.mActivity).getResources().getString(2131695262, new Object[] { Long.valueOf(l1) });
    }
    label177:
    label205:
    do
    {
      return str1;
      return ((NewPhotoListActivity)this.mActivity).getResources().getString(2131695260, new Object[] { Long.valueOf(l1) });
      str1 = str2;
    } while (this.jdField_a_of_type_Int != 1);
    return ((NewPhotoListActivity)this.mActivity).getResources().getString(2131695253, new Object[] { Long.valueOf(l1) });
  }
  
  public List<LocalMediaInfo> getLocalMediaInfos()
  {
    int i1 = -1;
    if (this.mPhotoCommonData.albumId.equals("$RecentAlbumId"))
    {
      i1 = 100;
      if (this.m) {
        i1 = QzoneConfig.getInstance().getConfig("PhotoAlbum", "MaxRecentPhotoNum", 200);
      }
    }
    int i2;
    Object localObject1;
    if (((this.m) && (this.mPhotoCommonData.albumId.equals("$RecentAlbumId"))) || ((this.h) && (this.i)))
    {
      i2 = QzoneConfig.getInstance().getConfig("PhotoAlbum", "RecentPhotoLimitSize", 20480);
      int i3 = QzoneConfig.getInstance().getConfig("PhotoAlbum", "RecentPhotoLimitWidth", 100);
      localObject2 = QzoneConfig.getInstance().getConfig("PhotoAlbum", "RecentPhotoBlockPaths", "MagazineUnlock");
      localObject1 = null;
      if (localObject2 != null) {
        localObject1 = a((String)localObject2);
      }
      localObject1 = bdfa.getAlbumMedias(this.mActivity, this.mPhotoCommonData.albumId, this.mPhotoCommonData.albumName, i1, this.jdField_a_of_type_Aiqz.filter, i2, i3, true, (ArrayList)localObject1, this.i, this.jdField_a_of_type_Aiqz.filterVideoDurationLimit);
      bdif.a("PEAK", "getAlbumMedias");
      if (localObject1 != null) {
        break label381;
      }
      if (QLog.isColorLevel()) {
        QLog.d("SelectPhotoTrace", 2, "photoList is null");
      }
      localObject2 = null;
    }
    label381:
    do
    {
      do
      {
        do
        {
          return localObject2;
          if (this.mPhotoCommonData.a())
          {
            if ((!TextUtils.isEmpty(this.mPhotoCommonData.albumId)) && (this.mPhotoCommonData.albumId.equals("$CustomAlbumId")))
            {
              localObject1 = new ArrayList();
              ((List)localObject1).addAll(xna.a().b());
              break;
            }
            localObject1 = bdfa.getAlbumMedias(this.mActivity, this.mPhotoCommonData.albumId, this.mPhotoCommonData.albumName, i1, this.jdField_a_of_type_Aiqz.filter, 0, 0, true, null, false, this.jdField_a_of_type_Aiqz.filterVideoDurationLimit, 1);
            break;
          }
          localObject1 = bdfa.getAlbumMedias(this.mActivity, this.mPhotoCommonData.albumId, this.mPhotoCommonData.albumName, i1, this.jdField_a_of_type_Aiqz.filter, this.jdField_a_of_type_Aiqz.filterVideoDurationLimit);
          break;
          if (((!this.jdField_b_of_type_Boolean) && (!this.jdField_a_of_type_Boolean)) || (QzoneConfig.getInstance().getConfig("PhotoAlbum", "paranoramaOpenCheck", 1) == 0)) {
            break label510;
          }
          a((List)localObject1);
          localObject2 = localObject1;
        } while (this.mPhotoCommonData.selectedPhotoList == null);
        localObject2 = localObject1;
      } while (this.mPhotoCommonData.selectedPhotoList.size() == 0);
      i1 = 0;
      localObject2 = localObject1;
    } while (i1 >= this.mPhotoCommonData.selectedPhotoList.size());
    label450:
    Object localObject2 = (String)this.mPhotoCommonData.selectedPhotoList.get(i1);
    if (TextUtils.isEmpty((CharSequence)localObject2))
    {
      QZLog.e("PhotoListActivity:QueryPhotoTask", "doInBackground: filter photo error, tempPath null");
      i2 = i1;
    }
    for (;;)
    {
      i1 = i2 + 1;
      break label450;
      label510:
      QLog.i("PhotoListActivity", 2, "@panoramatest isnot fromqzone");
      break;
      i2 = i1;
      if (!new File((String)localObject2).exists()) {
        if ((((String)localObject2).startsWith("http")) && (this.mPhotoCommonData.jdField_a_of_type_JavaUtilHashMap != null))
        {
          i2 = i1;
          if (this.mPhotoCommonData.jdField_a_of_type_JavaUtilHashMap.containsKey(localObject2)) {}
        }
        else
        {
          this.mPhotoCommonData.selectedPhotoList.remove(i1);
          i1 -= 1;
          i2 = i1;
          if (this.mPhotoCommonData.needMediaInfo)
          {
            i2 = i1;
            if (this.mPhotoCommonData.selectedMediaInfoHashMap != null)
            {
              i2 = i1;
              if (this.mPhotoCommonData.selectedMediaInfoHashMap.containsKey(localObject2))
              {
                this.mPhotoCommonData.selectedMediaInfoHashMap.remove(localObject2);
                i2 = i1;
              }
            }
          }
        }
      }
    }
  }
  
  public View getViewCaseCamera(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    if ((this.jdField_b_of_type_Boolean) || (this.jdField_a_of_type_Boolean))
    {
      paramViewGroup = paramView;
      if (paramView == null)
      {
        paramViewGroup = ((NewPhotoListActivity)this.mActivity).photoListAdapter.mInflater.inflate(2131562265, null);
        paramViewGroup.setLayoutParams(new AbsListView.LayoutParams(((NewPhotoListActivity)this.mActivity).mImageWidth, ((NewPhotoListActivity)this.mActivity).mImageHeight));
        a(1);
      }
      return paramViewGroup;
    }
    return super.getViewCaseCamera(paramInt, paramView, paramViewGroup);
  }
  
  public View getViewCaseImage(int paramInt, View paramView, ViewGroup paramViewGroup, AbstractPhotoListActivity.PhotoListAdapter.Holder paramHolder, AbstractPhotoListActivity.CheckBoxClickedListener paramCheckBoxClickedListener)
  {
    paramView = super.getViewCaseImage(paramInt, paramView, paramViewGroup, paramHolder, paramCheckBoxClickedListener);
    paramViewGroup = ((NewPhotoListActivity)this.mActivity).photoListAdapter.getItem(paramInt);
    if ((paramViewGroup != null) && (paramViewGroup.isPanoramaPhoto()) && ((this.jdField_b_of_type_Boolean) || (this.jdField_a_of_type_Boolean))) {
      paramHolder.mImageViewPanoramaIcon.setVisibility(0);
    }
    return paramView;
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
      i1 = bdfa.b();
      if (this.mPhotoCommonData.selectedPhotoList.size() < this.mPhotoCommonData.maxSelectNum) {
        break label170;
      }
      QQToast.a(this.mActivity, String.format(((NewPhotoListActivity)this.mActivity).getResources().getString(2131695260), new Object[] { Integer.valueOf(this.mPhotoCommonData.maxSelectNum) }), 0).a();
    }
    for (;;)
    {
      ((NewPhotoListActivity)this.mActivity).a(paramMessage);
      return;
      label163:
      i1 = bdfa.a();
      break;
      label170:
      if (this.mPhotoCommonData.getSelectedVideoNum() >= i1)
      {
        QQToast.a(this.mActivity, String.format(((NewPhotoListActivity)this.mActivity).getResources().getString(2131695265), new Object[] { Integer.valueOf(i1) }), 0).a();
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
    this.jdField_a_of_type_JavaLangString = paramIntent.getStringExtra("PhotoConst.INIT_ACTIVITY_CLASS_NAME");
    this.n = paramIntent.getBooleanExtra("from_qzone_slideshow", false);
    this.mPhotoCommonData.a(this.n);
    super.initData(paramIntent);
    this.j = paramIntent.getBooleanExtra("PhotoConst.IS_TRIM_VIDEO_BLACK_LIST", false);
    this.h = paramIntent.getBooleanExtra("PhotoConst.IS_FROM_DYNAMIC_ALBUM", false);
    if (!TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString))
    {
      if (this.jdField_a_of_type_JavaLangString.equals("com.qzone.publish.ui.activity.QZoneUploadPhotoRealActivity")) {
        this.jdField_a_of_type_Boolean = true;
      }
      if ((this.jdField_a_of_type_JavaLangString.equals("com.qzone.publish.ui.activity.QZonePublishMoodTabActivity")) || (this.jdField_a_of_type_JavaLangString.equals("com.qzone.publish.ui.activity.QZonePublishMoodRealActivity")) || ("com.tencent.pubaccount.publish.QQPublicAccountPublishFeedActivity".equals(this.jdField_a_of_type_JavaLangString)) || ("com.tencent.qcircle.QCirclePublishFeedActivity".equals(this.jdField_a_of_type_JavaLangString))) {
        this.jdField_b_of_type_Boolean = true;
      }
      if (this.jdField_a_of_type_JavaLangString.equals("com.qzone.publish.ui.activity.QZonePublishVoiceMoodActivity")) {
        this.jdField_c_of_type_Boolean = true;
      }
      if (paramIntent.getBooleanExtra("PhotoConst.IS_FROM_P2V", false))
      {
        this.d = true;
        this.jdField_b_of_type_Boolean = true;
      }
    }
    if ((this.jdField_a_of_type_Boolean) || (this.jdField_b_of_type_Boolean)) {
      this.mPhotoCommonData.needMediaInfo = true;
    }
    this.l = paramIntent.getBooleanExtra("NEED_QZONE_MACHINE_LEARNING_REPORT", false);
    if (this.l)
    {
      this.jdField_a_of_type_JavaUtilLinkedHashMap = new LinkedHashMap();
      b(paramIntent);
    }
    e = paramIntent.getBooleanExtra("QZONE_SUPPORT_MIX_MOOD", false);
    this.f = paramIntent.getBooleanExtra("QZONE_PEAK_SUPPORT_VIDEO_EDIT_WHEN_PREVIEW", false);
    g = paramIntent.getBooleanExtra("upload_single_video", false);
    if (((!TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)) && ((this.jdField_a_of_type_JavaLangString.equals("com.qzone.publish.ui.activity.QZoneUploadPhotoRealActivity")) || (this.jdField_a_of_type_JavaLangString.equals("com.qzone.publish.ui.activity.QZonePublishMoodRealActivity")) || (this.jdField_a_of_type_JavaLangString.equals("com.qzone.publish.ui.activity.QZonePublishMoodTabActivity")) || (this.jdField_a_of_type_JavaLangString.equals("com.qzone.common.activities.FeedActionPanelActivity")) || ("com.tencent.pubaccount.publish.QQPublicAccountPublishFeedActivity".equals(this.jdField_a_of_type_JavaLangString)))) || (this.h) || (this.d)) {
      this.m = true;
    }
    this.jdField_a_of_type_Int = paramIntent.getIntExtra("PhotoConst.KEY_SHOW_TYPE", 0);
    this.jdField_c_of_type_Int = paramIntent.getIntExtra("PhotoConst.KEY_SHOW_TYPE", -1);
    this.jdField_a_of_type_JavaUtilHashMap = ((HashMap)paramIntent.getSerializableExtra("PhotoConst.PANORAMA_IMAGES"));
    if (this.jdField_a_of_type_JavaUtilHashMap == null) {
      this.jdField_a_of_type_JavaUtilHashMap = new HashMap();
    }
    this.i = paramIntent.getBooleanExtra("PhotoConst.IS_NO_PANORAMA", false);
    this.jdField_a_of_type_Long = paramIntent.getLongExtra("PhotoConst.QZONE_COVER_PHOTOLIST_KEY_VIDEO_DURATION", 9223372036854775807L);
    if (this.jdField_c_of_type_Boolean) {
      this.jdField_b_of_type_Int = paramIntent.getIntExtra("imageSizeLimit", 0);
    }
    this.o = paramIntent.getBooleanExtra("from_qzoneshare", false);
    Object localObject;
    int i2;
    int i1;
    String str;
    if (this.jdField_a_of_type_Int == 1)
    {
      localObject = this.mPhotoCommonData.selectedPhotoList.iterator();
      i2 = 0;
      i1 = 0;
      while (((Iterator)localObject).hasNext())
      {
        str = (String)((Iterator)localObject).next();
        if ((this.mPhotoCommonData.selectedMediaInfoHashMap.containsKey(str)) && (bdfa.getMediaType((LocalMediaInfo)this.mPhotoCommonData.selectedMediaInfoHashMap.get(str)) == 1))
        {
          ((Iterator)localObject).remove();
          i1 = 1;
        }
        else if ((!this.mPhotoCommonData.selectedMediaInfoHashMap.containsKey(str)) && (!str.startsWith("http://qzs.qq.com")) && (str.toLowerCase().endsWith(".gif")))
        {
          ((Iterator)localObject).remove();
          i2 = 1;
        }
      }
      localObject = null;
      if (this.mPhotoCommonData.selectedPhotoList.size() <= this.mPhotoCommonData.maxSelectNum) {
        break label824;
      }
      localObject = ((NewPhotoListActivity)this.mActivity).getResources().getString(2131695253, new Object[] { Integer.valueOf(this.mPhotoCommonData.maxSelectNum) });
      this.mPhotoCommonData.selectedPhotoList.subList(this.mPhotoCommonData.maxSelectNum, this.mPhotoCommonData.selectedPhotoList.size()).clear();
    }
    for (;;)
    {
      if (localObject != null) {
        QQToast.a(this.mActivity, (CharSequence)localObject, 0).b(((NewPhotoListActivity)this.mActivity).mTitleBarHeight);
      }
      if (!this.f) {
        break;
      }
      localObject = this.mPhotoCommonData.selectedPhotoList.iterator();
      while (((Iterator)localObject).hasNext())
      {
        str = (String)((Iterator)localObject).next();
        if (bdfa.getMediaType((LocalMediaInfo)this.mPhotoCommonData.selectedMediaInfoHashMap.get(str)) == 1) {
          ((Iterator)localObject).remove();
        }
      }
      label824:
      if (i1 != 0) {
        localObject = ((NewPhotoListActivity)this.mActivity).getResources().getString(2131695258);
      } else if (i2 != 0) {
        localObject = ((NewPhotoListActivity)this.mActivity).getResources().getString(2131695257);
      }
    }
    this.jdField_b_of_type_JavaLangString = paramIntent.getStringExtra("report_from");
    if ((this.mPhotoCommonData.a()) && (((NewPhotoListActivity)this.mActivity).getIntent().getIntExtra("qq_sub_business_id", -1) == 3))
    {
      xna.a().c(22);
      xna.a().b(14);
      xna.a().e();
      ((NewPhotoListActivity)this.mActivity).getIntent().removeExtra("qq_sub_business_id");
    }
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if ((this.n) && (paramInt2 == -1) && (paramInt1 != 24747))
    {
      ((NewPhotoListActivity)this.mActivity).setResult(paramInt2, paramIntent);
      ((NewPhotoListActivity)this.mActivity).finish();
      return;
    }
    if ((paramInt2 != -1) && (paramInt1 == 10001) && (this.n) && (paramIntent != null))
    {
      String str = paramIntent.getStringExtra("PhotoConst.FROM_QQSTORY_SLIDESHOW_DATA");
      if (!TextUtils.isEmpty(str)) {
        bdhb.a(new File(str).getParent());
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
      if ((!this.jdField_a_of_type_Aiqz.isSupportVideoCheckbox) || (arrayOfString == null) || (!"video".equals(arrayOfString[0])) || (bdfa.a(this.mActivity, this.mPhotoCommonData.getSelectedVideoNum(), localLocalMediaInfo, this.jdField_b_of_type_Boolean))) {
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
      azqs.b(null, "CliOper", "", "", "0x8004B39", "0x8004B39", 0, 0, "", "", "", "");
      paramView = new HashMap(1);
      if ((this.mPhotoCommonData.selectedMediaInfoHashMap != null) && (this.mPhotoCommonData.selectedMediaInfoHashMap.get(this.mPhotoCommonData.selectedPhotoList.get(0)) != null)) {
        paramView.put("param_localmediainfo", this.mPhotoCommonData.selectedMediaInfoHashMap.get(this.mPhotoCommonData.selectedPhotoList.get(0)));
      }
      paramView = a(EditPicActivity.a(this.mActivity, (String)this.mPhotoCommonData.selectedPhotoList.get(0), true, true, true, true, true, 3, 99, 5, paramView), (String)this.mPhotoCommonData.selectedPhotoList.get(0));
      a(paramView);
      ((NewPhotoListActivity)this.mActivity).startActivity(paramView);
      ((NewPhotoListActivity)this.mActivity).a.setClickable(false);
    }
  }
  
  public void onPreviewBtnClick(View paramView)
  {
    b(paramView.getId());
    super.onPreviewBtnClick(paramView);
  }
  
  public void onSendBtnClick(View paramView)
  {
    b(paramView.getId());
    ((NewPhotoListActivity)this.mActivity).sendBtn.setClickable(false);
    if (!this.mPhotoCommonData.selectedPhotoList.isEmpty()) {
      ((NewPhotoListActivity)this.mActivity).recordLastPos((String)this.mPhotoCommonData.selectedPhotoList.get(this.mPhotoCommonData.selectedPhotoList.size() - 1));
    }
    bdfa.a();
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
      for (long l1 = 0L; paramView.hasNext(); l1 = bdhb.a((String)paramView.next()) + l1) {}
      if (arrr.a())
      {
        arre.a(this.mActivity, 2131692754, 2131692759, new aist(this));
        return;
      }
    }
    if (this.o)
    {
      String str = localIntent.getStringExtra("PhotoConst.DEST_ACTIVITY_CLASS_NAME");
      paramView = str;
      if (TextUtils.isEmpty(str)) {
        paramView = localIntent.getStringExtra("PhotoConst.INIT_ACTIVITY_CLASS_NAME");
      }
      localIntent.addFlags(603979776);
      QzonePluginProxyActivity.a(localIntent, paramView);
      paramView = bjea.a();
      bjdt.a(this.mActivity, paramView, localIntent, -1, null);
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
    bdfa.clearSelectItemInfo();
    bdfa.a();
    Object localObject = PresendPicMgr.a();
    if (localObject != null) {
      ((PresendPicMgr)localObject).a(1006);
    }
    if (this.mPhotoCommonData.selectedPhotoList != null) {}
    for (int i1 = this.mPhotoCommonData.selectedPhotoList.size();; i1 = 0)
    {
      aips.b(paramView, i1);
      if (this.jdField_a_of_type_Aiqz.i) {
        break;
      }
      ((NewPhotoListActivity)this.mActivity).finish();
      bdfa.anim(this.mActivity, false, false);
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
      bdfa.anim(this.mActivity, false, false);
      return;
      paramView.getStringExtra("PhotoConst.PLUGIN_NAME");
      str1 = paramView.getStringExtra("PhotoConst.PLUGIN_APK");
      String str2 = paramView.getStringExtra("PhotoConst.UIN");
      if ("qzone_plugin.apk".equals(str1))
      {
        QzonePluginProxyActivity.a(paramView, (String)localObject);
        bjdt.a(this.mActivity, str2, paramView, 2);
      }
      else if ("qqfav.apk".equals(str1))
      {
        bivc.a(this.mActivity, str2, paramView, 2);
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
    ((NewPhotoListActivity)this.mActivity).mGridView.setOnScrollListener(new aisr(this));
    if ((TextUtils.isEmpty(this.jdField_a_of_type_Aiqz.customSendBtnText)) && (1 == this.jdField_a_of_type_Int))
    {
      String str = ((NewPhotoListActivity)this.mActivity).getString(2131695267);
      ((NewPhotoListActivity)this.mActivity).c.setVisibility(0);
      ((NewPhotoListActivity)this.mActivity).c.setText(((NewPhotoListActivity)this.mActivity).getString(2131695279));
      ((NewPhotoListActivity)this.mActivity).sendBtn.setText(str);
    }
  }
  
  public void startPhotoPreviewActivity(Intent paramIntent)
  {
    if (this.jdField_a_of_type_Int == 1)
    {
      adpn.a(this.mActivity, paramIntent, PublicFragmentActivityForPeak.class, QzonePhotoPreviewActivity.class);
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
    if (this.jdField_a_of_type_Aiqz.customSendBtnText != null)
    {
      str = this.jdField_a_of_type_Aiqz.customSendBtnText;
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
        str = ((NewPhotoListActivity)this.mActivity).getString(2131695267);
        break;
      }
      str = ((NewPhotoListActivity)this.mActivity).getString(2131695245);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aisq
 * JD-Core Version:    0.7.0.1
 */