import android.app.Activity;
import android.content.Context;
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
import com.tencent.mobileqq.activity.photo.PhotoUtils;
import com.tencent.mobileqq.activity.photo.QzonePhotoPreviewActivity;
import com.tencent.mobileqq.activity.photo.album.NewPhotoListActivity;
import com.tencent.mobileqq.activity.photo.album.NewPhotoPreviewActivity;
import com.tencent.mobileqq.activity.photo.album.logicImp.PhotoListLogicQzone.2;
import com.tencent.mobileqq.activity.shortvideo.SendVideoActivity.SendVideoInfo;
import com.tencent.mobileqq.activity.shortvideo.ShortVideoPreviewActivity;
import com.tencent.mobileqq.pic.PresendPicMgr;
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
import mqq.util.WeakReference;

public class ague
  extends agsj
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
  boolean c = false;
  boolean d = false;
  protected boolean f;
  boolean h;
  boolean i = false;
  boolean j;
  private boolean k;
  private boolean l;
  private boolean m;
  private boolean n;
  private boolean o;
  private boolean p;
  
  protected ague(NewPhotoListActivity paramNewPhotoListActivity)
  {
    super(paramNewPhotoListActivity);
    this.jdField_a_of_type_JavaLangString = "";
    this.jdField_h_of_type_Boolean = false;
  }
  
  private Intent a(Intent paramIntent, String paramString)
  {
    if ((this.jdField_b_of_type_Boolean) || (this.jdField_a_of_type_Boolean) || (this.c) || (this.o) || (this.m)) {
      paramIntent = QzoneEditPictureActivity.a((Activity)this.jdField_a_of_type_MqqUtilWeakReference.get(), paramString);
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
          if (paramInt1 < ((NewPhotoListActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).jdField_a_of_type_Agrs.getCount())
          {
            LocalMediaInfo localLocalMediaInfo = ((NewPhotoListActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).jdField_a_of_type_Agrs.a(paramInt1);
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
      axrn.a(BaseApplication.getContext()).a(null, "qzoneChoosePhotoCamera", true, 0L, 0L, localHashMap, null, true);
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
    bhqa.a().a(new agug(this, paramLocalMediaInfo));
  }
  
  private void a(List<LocalMediaInfo> paramList)
  {
    QzoneHandlerThreadFactory.getHandlerThread("Normal_HandlerThread").post(new PhotoListLogicQzone.2(this, paramList));
  }
  
  public static agsc b(NewPhotoListActivity paramNewPhotoListActivity)
  {
    if ((jdField_a_of_type_Agsc == null) || (jdField_a_of_type_Agsc.jdField_a_of_type_MqqUtilWeakReference.get() != paramNewPhotoListActivity)) {}
    try
    {
      if ((jdField_a_of_type_Agsc == null) || (jdField_a_of_type_Agsc.jdField_a_of_type_MqqUtilWeakReference.get() != paramNewPhotoListActivity)) {
        jdField_a_of_type_Agsc = new ague(paramNewPhotoListActivity);
      }
      return jdField_a_of_type_Agsc;
    }
    finally {}
  }
  
  private void b(int paramInt)
  {
    int i1 = 2;
    if (TextUtils.isEmpty(this.jdField_b_of_type_JavaLangString)) {
      return;
    }
    int i4 = this.jdField_a_of_type_Agrz.jdField_a_of_type_JavaUtilArrayList.size();
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
      case 2131368429: 
        i1 = 3;
      }
    }
    for (;;)
    {
      if ((this.jdField_a_of_type_Int != 1) || (paramInt != 2131375842)) {
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
  
  private void g(Intent paramIntent)
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
  
  private void h(Intent paramIntent)
  {
    if ((this.jdField_a_of_type_Agrz.jdField_a_of_type_JavaUtilHashMap == null) || (this.jdField_a_of_type_JavaUtilLinkedHashMap == null)) {
      return;
    }
    for (;;)
    {
      try
      {
        if ((!this.p) && (((NewPhotoListActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).jdField_a_of_type_Agrs != null) && (((NewPhotoListActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).jdField_a_of_type_Agrs.getCount() > 0)) {
          m();
        }
        int i2 = QzoneConfig.getInstance().getConfig("PhotoAlbum", "MachineLearningExposedMediaUpperBound", 50) - this.jdField_a_of_type_Agrz.jdField_a_of_type_JavaUtilHashMap.size();
        if (i2 <= 0) {
          break;
        }
        int i1 = 0;
        ArrayList localArrayList = new ArrayList();
        Iterator localIterator = this.jdField_a_of_type_JavaUtilLinkedHashMap.entrySet().iterator();
        if ((localIterator.hasNext()) && (i1 < i2))
        {
          LocalMediaInfo localLocalMediaInfo = (LocalMediaInfo)((Map.Entry)localIterator.next()).getValue();
          if (!this.jdField_a_of_type_Agrz.jdField_a_of_type_JavaUtilHashMap.containsKey(localLocalMediaInfo.path))
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
  
  private void m()
  {
    if ((((NewPhotoListActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).jdField_a_of_type_ComTencentWidgetGestureSelectGridView == null) || (this.jdField_a_of_type_JavaUtilLinkedHashMap == null)) {
      return;
    }
    Object localObject = a(((NewPhotoListActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).jdField_a_of_type_ComTencentWidgetGestureSelectGridView.getFirstVisiblePosition(), ((NewPhotoListActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).jdField_a_of_type_ComTencentWidgetGestureSelectGridView.getLastVisiblePosition());
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
  
  private void n()
  {
    Object localObject = bgzt.a();
    if ((!((bgzu)localObject).a()) || (!avte.a()))
    {
      String str = QzoneConfig.getInstance().getConfig("QZoneTextSetting", "PhotoListCameraNotSupport", "当前不支持拍摄");
      if ((((bgzu)localObject).a() != null) && (((bgzu)localObject).b()))
      {
        str = QzoneConfig.getInstance().getConfig("QZoneTextSetting", "ToastStartLiveVideoFailForMemory", "SD卡不存在或手机内存不足");
        bcql.a((Context)this.jdField_a_of_type_MqqUtilWeakReference.get(), str, 0).a();
      }
      for (;;)
      {
        if (((bgzu)localObject).a() != null) {
          QZLog.e("PhotoListActivity", 2, new Object[] { "gotoCamera fail", ((bgzu)localObject).a() });
        }
        a(2);
        return;
        bcql.a((Context)this.jdField_a_of_type_MqqUtilWeakReference.get(), str, 0).a();
      }
    }
    localObject = new Intent((Context)this.jdField_a_of_type_MqqUtilWeakReference.get(), QZoneVideoDownloadActivity.class);
    ((Intent)localObject).putExtra("extra.busi_type", 3);
    ((Intent)localObject).putExtra("extra_directly_back", true);
    ((Intent)localObject).putExtra("PhotoConst.PLUGIN_APK", "qzone_plugin.apk");
    ((Intent)localObject).putExtra("DirectBackToQzone", true);
    ((Intent)localObject).putExtra("PhotoConst.PHOTO_SELECT_ACTIVITY_CLASS_NAME", NewPhotoListActivity.class.getName());
    ((Intent)localObject).putExtra("pic_confirm_text", ((NewPhotoListActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).getString(2131695085));
    ((Intent)localObject).putExtra("enable_edit_video", true);
    ((Intent)localObject).putExtra("enable_input_text", false);
    ((Intent)localObject).putExtra("enable_priv_list", false);
    ((Intent)localObject).putExtra("entry_source", 5);
    ((Intent)localObject).putExtra("support_record", true);
    ((Intent)localObject).putExtra("enable_local_video", false);
    ((Intent)localObject).putExtra("enable_local_button", false);
    ((Intent)localObject).putExtra("go_publish_activity", false);
    ((Intent)localObject).putExtra("enterPtu", false);
    if ("$VideoAlbumId".equals(this.jdField_a_of_type_Agrz.jdField_c_of_type_JavaLangString)) {
      ((Intent)localObject).putExtra("support_pic", false);
    }
    for (;;)
    {
      ((Intent)localObject).putExtra("key_latitude", ((NewPhotoListActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).getIntent().getDoubleExtra("key_latitude", 4.9E-324D));
      ((Intent)localObject).putExtra("key_longtitude", ((NewPhotoListActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).getIntent().getDoubleExtra("key_longtitude", 4.9E-324D));
      ((NewPhotoListActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).startActivity((Intent)localObject);
      a(3);
      return;
      ((Intent)localObject).putExtra("support_pic", true);
    }
  }
  
  public Intent a(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    paramAdapterView = super.a(paramAdapterView, paramView, paramInt, paramLong);
    paramView = ((NewPhotoListActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).jdField_a_of_type_Agrs.a(paramInt);
    ArrayList localArrayList1;
    ArrayList localArrayList2;
    int i1;
    int i3;
    if ((this.jdField_b_of_type_Boolean) && (!e) && (this.jdField_a_of_type_Agrz.jdField_b_of_type_JavaUtilHashMap != null))
    {
      localArrayList1 = new ArrayList();
      localArrayList2 = new ArrayList();
      i1 = paramInt - 1;
      int i2 = 0;
      int i4 = this.jdField_a_of_type_Agrz.jdField_c_of_type_JavaUtilArrayList.size();
      i3 = 0;
      if (i3 < i4)
      {
        String str = (String)this.jdField_a_of_type_Agrz.jdField_c_of_type_JavaUtilArrayList.get(i3);
        LocalMediaInfo localLocalMediaInfo = (LocalMediaInfo)this.jdField_a_of_type_Agrz.jdField_b_of_type_JavaUtilHashMap.get(str);
        if (bbbx.a(localLocalMediaInfo) != 0) {
          break label315;
        }
        localArrayList1.add(str);
        if ((this.jdField_a_of_type_Agrz.jdField_a_of_type_JavaUtilArrayList != null) && (this.jdField_a_of_type_Agrz.jdField_a_of_type_JavaUtilArrayList.contains(str))) {
          localArrayList2.add(Integer.valueOf(i2));
        }
        if (localLocalMediaInfo.position.intValue() != paramInt - 1) {
          break label312;
        }
        i1 = i2;
        label203:
        i2 += 1;
      }
    }
    label312:
    label315:
    for (;;)
    {
      i3 += 1;
      break;
      this.jdField_a_of_type_Agrz.jdField_c_of_type_JavaUtilArrayList = localArrayList1;
      paramAdapterView.putStringArrayListExtra("PhotoConst.PHOTO_PATHS", localArrayList1);
      paramAdapterView.putStringArrayListExtra("PhotoConst.SELECTED_PATHS", this.jdField_a_of_type_Agrz.jdField_a_of_type_JavaUtilArrayList);
      paramAdapterView.putIntegerArrayListExtra("PhotoConst.SELECTED_INDEXS", localArrayList2);
      if (bbbx.a(paramView) == 0) {
        paramAdapterView.putExtra("PhotoConst.CURRENT_SELECTED_INDEX", i1);
      }
      paramAdapterView.putExtra("from_qzone", this.m);
      if (this.jdField_b_of_type_Boolean) {
        paramAdapterView.putExtra("PhotoConst.IS_FROM_SHUOSHUO", this.jdField_b_of_type_Boolean);
      }
      return paramAdapterView;
      break label203;
    }
  }
  
  public View a(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    if ((this.jdField_b_of_type_Boolean) || (this.jdField_a_of_type_Boolean))
    {
      paramViewGroup = paramView;
      if (paramView == null)
      {
        paramViewGroup = ((NewPhotoListActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).jdField_a_of_type_Agrs.a.inflate(2131562055, null);
        paramViewGroup.setLayoutParams(new AbsListView.LayoutParams(((NewPhotoListActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).jdField_a_of_type_Int, ((NewPhotoListActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).jdField_b_of_type_Int));
        a(1);
      }
      return paramViewGroup;
    }
    return super.a(paramInt, paramView, paramViewGroup);
  }
  
  public View a(int paramInt, View paramView, ViewGroup paramViewGroup, agrt paramagrt, agrq paramagrq)
  {
    paramView = super.a(paramInt, paramView, paramViewGroup, paramagrt, paramagrq);
    paramViewGroup = ((NewPhotoListActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).jdField_a_of_type_Agrs.a(paramInt);
    if ((paramViewGroup != null) && (paramViewGroup.isPanoramaPhoto()) && ((this.jdField_b_of_type_Boolean) || (this.jdField_a_of_type_Boolean))) {
      paramagrt.a.setVisibility(0);
    }
    return paramView;
  }
  
  protected String a(LocalMediaInfo paramLocalMediaInfo)
  {
    String str2 = super.a(paramLocalMediaInfo);
    long l1 = this.jdField_a_of_type_Agrz.jdField_a_of_type_Int;
    String str1 = str2;
    if (paramLocalMediaInfo != null)
    {
      paramLocalMediaInfo = agmm.a(paramLocalMediaInfo.mMimeType);
      if ((this.jdField_a_of_type_Agrz.a() <= 0) && ((!this.jdField_a_of_type_Agsb.jdField_h_of_type_Boolean) || (paramLocalMediaInfo == null) || (!"video".equals(paramLocalMediaInfo[0])))) {
        break label214;
      }
      if ((this.jdField_a_of_type_Agrz.a() == l1) && (this.jdField_a_of_type_Agsb.jdField_h_of_type_Boolean) && (paramLocalMediaInfo != null) && ("video".equals(paramLocalMediaInfo[0]))) {
        ((NewPhotoListActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).getResources().getString(2131695103, new Object[] { Long.valueOf(l1) });
      }
      if (!this.jdField_a_of_type_Agrz.a()) {
        break label183;
      }
      str1 = ((NewPhotoListActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).getResources().getString(2131695102, new Object[] { Long.valueOf(l1) });
    }
    label183:
    label214:
    do
    {
      return str1;
      return ((NewPhotoListActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).getResources().getString(2131695100, new Object[] { Long.valueOf(l1) });
      str1 = str2;
    } while (this.jdField_a_of_type_Int != 1);
    return ((NewPhotoListActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).getResources().getString(2131695093, new Object[] { Long.valueOf(l1) });
  }
  
  protected List<LocalMediaInfo> a()
  {
    int i1 = -1;
    if (this.jdField_a_of_type_Agrz.jdField_c_of_type_JavaLangString.equals("$RecentAlbumId"))
    {
      i1 = 100;
      if (this.m) {
        i1 = QzoneConfig.getInstance().getConfig("PhotoAlbum", "MaxRecentPhotoNum", 200);
      }
    }
    int i2;
    Object localObject1;
    if (((this.m) && (this.jdField_a_of_type_Agrz.jdField_c_of_type_JavaLangString.equals("$RecentAlbumId"))) || ((this.jdField_h_of_type_Boolean) && (this.i)))
    {
      i2 = QzoneConfig.getInstance().getConfig("PhotoAlbum", "RecentPhotoLimitSize", 20480);
      int i3 = QzoneConfig.getInstance().getConfig("PhotoAlbum", "RecentPhotoLimitWidth", 100);
      localObject2 = QzoneConfig.getInstance().getConfig("PhotoAlbum", "RecentPhotoBlockPaths", "MagazineUnlock");
      localObject1 = null;
      if (localObject2 != null) {
        localObject1 = a((String)localObject2);
      }
      localObject1 = bbbx.a((Context)this.jdField_a_of_type_MqqUtilWeakReference.get(), this.jdField_a_of_type_Agrz.jdField_c_of_type_JavaLangString, this.jdField_a_of_type_Agrz.jdField_b_of_type_JavaLangString, i1, this.jdField_a_of_type_Agsb.jdField_a_of_type_Aglv, i2, i3, true, (ArrayList)localObject1, this.i, this.jdField_a_of_type_Agsb.jdField_a_of_type_Long);
      bbfb.a("PEAK", "getAlbumMedias");
      if (localObject1 != null) {
        break label399;
      }
      if (QLog.isColorLevel()) {
        QLog.d("SelectPhotoTrace", 2, "photoList is null");
      }
      localObject2 = null;
    }
    label399:
    label468:
    do
    {
      do
      {
        do
        {
          return localObject2;
          if (this.jdField_a_of_type_Agrz.a())
          {
            if ((!TextUtils.isEmpty(this.jdField_a_of_type_Agrz.jdField_c_of_type_JavaLangString)) && (this.jdField_a_of_type_Agrz.jdField_c_of_type_JavaLangString.equals("$CustomAlbumId")))
            {
              localObject1 = new ArrayList();
              ((List)localObject1).addAll(vtz.a().b());
              break;
            }
            localObject1 = bbbx.a((Context)this.jdField_a_of_type_MqqUtilWeakReference.get(), this.jdField_a_of_type_Agrz.jdField_c_of_type_JavaLangString, this.jdField_a_of_type_Agrz.jdField_b_of_type_JavaLangString, i1, this.jdField_a_of_type_Agsb.jdField_a_of_type_Aglv, 0, 0, true, null, false, this.jdField_a_of_type_Agsb.jdField_a_of_type_Long, 1);
            break;
          }
          localObject1 = bbbx.b((Context)this.jdField_a_of_type_MqqUtilWeakReference.get(), this.jdField_a_of_type_Agrz.jdField_c_of_type_JavaLangString, this.jdField_a_of_type_Agrz.jdField_b_of_type_JavaLangString, i1, this.jdField_a_of_type_Agsb.jdField_a_of_type_Aglv, this.jdField_a_of_type_Agsb.jdField_a_of_type_Long);
          break;
          if (((!this.jdField_b_of_type_Boolean) && (!this.jdField_a_of_type_Boolean)) || (QzoneConfig.getInstance().getConfig("PhotoAlbum", "paranoramaOpenCheck", 1) == 0)) {
            break label528;
          }
          a((List)localObject1);
          localObject2 = localObject1;
        } while (this.jdField_a_of_type_Agrz.jdField_a_of_type_JavaUtilArrayList == null);
        localObject2 = localObject1;
      } while (this.jdField_a_of_type_Agrz.jdField_a_of_type_JavaUtilArrayList.size() == 0);
      i1 = 0;
      localObject2 = localObject1;
    } while (i1 >= this.jdField_a_of_type_Agrz.jdField_a_of_type_JavaUtilArrayList.size());
    Object localObject2 = (String)this.jdField_a_of_type_Agrz.jdField_a_of_type_JavaUtilArrayList.get(i1);
    if (TextUtils.isEmpty((CharSequence)localObject2))
    {
      QZLog.e("PhotoListActivity:QueryPhotoTask", "doInBackground: filter photo error, tempPath null");
      i2 = i1;
    }
    for (;;)
    {
      i1 = i2 + 1;
      break label468;
      label528:
      QLog.i("PhotoListActivity", 2, "@panoramatest isnot fromqzone");
      break;
      i2 = i1;
      if (!new File((String)localObject2).exists()) {
        if ((((String)localObject2).startsWith("http")) && (this.jdField_a_of_type_Agrz.jdField_c_of_type_JavaUtilHashMap != null))
        {
          i2 = i1;
          if (this.jdField_a_of_type_Agrz.jdField_c_of_type_JavaUtilHashMap.containsKey(localObject2)) {}
        }
        else
        {
          this.jdField_a_of_type_Agrz.jdField_a_of_type_JavaUtilArrayList.remove(i1);
          i1 -= 1;
          i2 = i1;
          if (this.jdField_a_of_type_Agrz.d)
          {
            i2 = i1;
            if (this.jdField_a_of_type_Agrz.jdField_a_of_type_JavaUtilHashMap != null)
            {
              i2 = i1;
              if (this.jdField_a_of_type_Agrz.jdField_a_of_type_JavaUtilHashMap.containsKey(localObject2))
              {
                this.jdField_a_of_type_Agrz.jdField_a_of_type_JavaUtilHashMap.remove(localObject2);
                i2 = i1;
              }
            }
          }
        }
      }
    }
  }
  
  protected void a(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if ((this.n) && (paramInt2 == -1) && (paramInt1 != 24747))
    {
      ((NewPhotoListActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).setResult(paramInt2, paramIntent);
      ((NewPhotoListActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).finish();
      return;
    }
    if ((paramInt2 != -1) && (paramInt1 == 10001) && (this.n) && (paramIntent != null))
    {
      String str = paramIntent.getStringExtra("PhotoConst.FROM_QQSTORY_SLIDESHOW_DATA");
      if (!TextUtils.isEmpty(str)) {
        bbdx.a(new File(str).getParent());
      }
      ((NewPhotoListActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).setResult(0, paramIntent);
      ((NewPhotoListActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).finish();
    }
    super.a(paramInt1, paramInt2, paramIntent);
  }
  
  protected void a(Intent paramIntent)
  {
    this.jdField_a_of_type_JavaLangString = paramIntent.getStringExtra("PhotoConst.INIT_ACTIVITY_CLASS_NAME");
    this.n = paramIntent.getBooleanExtra("from_qzone_slideshow", false);
    this.jdField_a_of_type_Agrz.a(this.n);
    super.a(paramIntent);
    this.j = paramIntent.getBooleanExtra("PhotoConst.IS_TRIM_VIDEO_BLACK_LIST", false);
    this.jdField_h_of_type_Boolean = paramIntent.getBooleanExtra("PhotoConst.IS_FROM_DYNAMIC_ALBUM", false);
    if (!TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString))
    {
      if (this.jdField_a_of_type_JavaLangString.equals("com.qzone.publish.ui.activity.QZoneUploadPhotoRealActivity")) {
        this.jdField_a_of_type_Boolean = true;
      }
      if ((this.jdField_a_of_type_JavaLangString.equals("com.qzone.publish.ui.activity.QZonePublishMoodTabActivity")) || (this.jdField_a_of_type_JavaLangString.equals("com.qzone.publish.ui.activity.QZonePublishMoodRealActivity")) || ("com.tencent.pubaccount.publish.QQPublicAccountPublishFeedActivity".equals(this.jdField_a_of_type_JavaLangString))) {
        this.jdField_b_of_type_Boolean = true;
      }
      if (this.jdField_a_of_type_JavaLangString.equals("com.qzone.publish.ui.activity.QZonePublishVoiceMoodActivity")) {
        this.c = true;
      }
      if (paramIntent.getBooleanExtra("PhotoConst.IS_FROM_P2V", false))
      {
        this.d = true;
        this.jdField_b_of_type_Boolean = true;
      }
    }
    if ((this.jdField_a_of_type_Boolean) || (this.jdField_b_of_type_Boolean)) {
      this.jdField_a_of_type_Agrz.d = true;
    }
    this.l = paramIntent.getBooleanExtra("NEED_QZONE_MACHINE_LEARNING_REPORT", false);
    if (this.l)
    {
      this.jdField_a_of_type_JavaUtilLinkedHashMap = new LinkedHashMap();
      g(paramIntent);
    }
    e = paramIntent.getBooleanExtra("QZONE_SUPPORT_MIX_MOOD", false);
    this.f = paramIntent.getBooleanExtra("QZONE_PEAK_SUPPORT_VIDEO_EDIT_WHEN_PREVIEW", false);
    g = paramIntent.getBooleanExtra("upload_single_video", false);
    if (((!TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)) && ((this.jdField_a_of_type_JavaLangString.equals("com.qzone.publish.ui.activity.QZoneUploadPhotoRealActivity")) || (this.jdField_a_of_type_JavaLangString.equals("com.qzone.publish.ui.activity.QZonePublishMoodRealActivity")) || (this.jdField_a_of_type_JavaLangString.equals("com.qzone.publish.ui.activity.QZonePublishMoodTabActivity")) || (this.jdField_a_of_type_JavaLangString.equals("com.qzone.common.activities.FeedActionPanelActivity")) || ("com.tencent.pubaccount.publish.QQPublicAccountPublishFeedActivity".equals(this.jdField_a_of_type_JavaLangString)))) || (this.jdField_h_of_type_Boolean) || (this.d)) {
      this.m = true;
    }
    this.jdField_a_of_type_Int = paramIntent.getIntExtra("PhotoConst.KEY_SHOW_TYPE", 0);
    this.jdField_a_of_type_JavaUtilHashMap = ((HashMap)paramIntent.getSerializableExtra("PhotoConst.PANORAMA_IMAGES"));
    if (this.jdField_a_of_type_JavaUtilHashMap == null) {
      this.jdField_a_of_type_JavaUtilHashMap = new HashMap();
    }
    this.i = paramIntent.getBooleanExtra("PhotoConst.IS_NO_PANORAMA", false);
    this.jdField_a_of_type_Long = paramIntent.getLongExtra("PhotoConst.QZONE_COVER_PHOTOLIST_KEY_VIDEO_DURATION", 9223372036854775807L);
    if (this.c) {
      this.jdField_b_of_type_Int = paramIntent.getIntExtra("imageSizeLimit", 0);
    }
    this.o = paramIntent.getBooleanExtra("from_qzoneshare", false);
    Object localObject;
    int i2;
    int i1;
    String str;
    if (this.jdField_a_of_type_Int == 1)
    {
      localObject = this.jdField_a_of_type_Agrz.jdField_a_of_type_JavaUtilArrayList.iterator();
      i2 = 0;
      i1 = 0;
      while (((Iterator)localObject).hasNext())
      {
        str = (String)((Iterator)localObject).next();
        if ((this.jdField_a_of_type_Agrz.jdField_a_of_type_JavaUtilHashMap.containsKey(str)) && (bbbx.a((LocalMediaInfo)this.jdField_a_of_type_Agrz.jdField_a_of_type_JavaUtilHashMap.get(str)) == 1))
        {
          ((Iterator)localObject).remove();
          i1 = 1;
        }
        else if ((!this.jdField_a_of_type_Agrz.jdField_a_of_type_JavaUtilHashMap.containsKey(str)) && (!str.startsWith("http://qzs.qq.com")) && (str.toLowerCase().endsWith(".gif")))
        {
          ((Iterator)localObject).remove();
          i2 = 1;
        }
      }
      if (this.jdField_a_of_type_Agrz.jdField_a_of_type_JavaUtilArrayList.size() <= this.jdField_a_of_type_Agrz.jdField_a_of_type_Int) {
        break label808;
      }
      localObject = ((NewPhotoListActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).getResources().getString(2131695093, new Object[] { Integer.valueOf(this.jdField_a_of_type_Agrz.jdField_a_of_type_Int) });
      this.jdField_a_of_type_Agrz.jdField_a_of_type_JavaUtilArrayList.subList(this.jdField_a_of_type_Agrz.jdField_a_of_type_Int, this.jdField_a_of_type_Agrz.jdField_a_of_type_JavaUtilArrayList.size()).clear();
    }
    for (;;)
    {
      if (localObject != null) {
        bcql.a((Context)this.jdField_a_of_type_MqqUtilWeakReference.get(), (CharSequence)localObject, 0).b(((NewPhotoListActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).g);
      }
      if (this.f)
      {
        localObject = this.jdField_a_of_type_Agrz.jdField_a_of_type_JavaUtilArrayList.iterator();
        for (;;)
        {
          if (((Iterator)localObject).hasNext())
          {
            str = (String)((Iterator)localObject).next();
            if (bbbx.a((LocalMediaInfo)this.jdField_a_of_type_Agrz.jdField_a_of_type_JavaUtilHashMap.get(str)) == 1)
            {
              ((Iterator)localObject).remove();
              continue;
              label808:
              if (i1 != 0)
              {
                localObject = ((NewPhotoListActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).getResources().getString(2131695098);
                break;
              }
              if (i2 == 0) {
                break label951;
              }
              localObject = ((NewPhotoListActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).getResources().getString(2131695097);
              break;
            }
          }
        }
      }
      this.jdField_b_of_type_JavaLangString = paramIntent.getStringExtra("report_from");
      if ((this.jdField_a_of_type_Agrz.a()) && (((NewPhotoListActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).getIntent().getIntExtra("qq_sub_business_id", -1) == 3))
      {
        vtz.a().c(22);
        vtz.a().b(14);
        vtz.a().e();
        ((NewPhotoListActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).getIntent().removeExtra("qq_sub_business_id");
      }
      return;
      label951:
      localObject = null;
    }
  }
  
  protected void a(Intent paramIntent, boolean paramBoolean, ArrayList<String> paramArrayList)
  {
    int i7 = PhotoUtils.b(this.jdField_a_of_type_Agsb.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo);
    paramArrayList = new HashMap();
    int i2 = 0;
    int i1 = 0;
    int i6 = 0;
    int i3 = 0;
    while (i6 < this.jdField_a_of_type_Agrz.jdField_a_of_type_JavaUtilArrayList.size())
    {
      Object localObject = (String)this.jdField_a_of_type_Agrz.jdField_a_of_type_JavaUtilArrayList.get(i6);
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
        if (((NewPhotoListActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).a((String)localObject) == 1)
        {
          localObject = ((NewPhotoListActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).a((String)localObject);
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
      PhotoUtils.a((Activity)this.jdField_a_of_type_MqqUtilWeakReference.get(), paramIntent, this.jdField_a_of_type_Agrz.jdField_a_of_type_JavaUtilArrayList, this.jdField_a_of_type_Agsb.jdField_b_of_type_JavaUtilHashMap, this.jdField_a_of_type_Agrz.jdField_c_of_type_Int, false);
    }
    for (;;)
    {
      axqy.b(null, "CliOper", "", "", "0X8009AB0", "0X8009AB0", i7, 0, String.valueOf(i2), String.valueOf(i1), "", "");
      return;
      PhotoUtils.a((Activity)this.jdField_a_of_type_MqqUtilWeakReference.get(), paramIntent, this.jdField_a_of_type_Agrz.jdField_a_of_type_JavaUtilArrayList, this.jdField_a_of_type_Agrz.jdField_c_of_type_Int, this.jdField_a_of_type_Agsb.l);
    }
  }
  
  protected void a(Message paramMessage)
  {
    ((NewPhotoListActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).d();
    int i1;
    if ((paramMessage.obj instanceof String))
    {
      paramMessage = (String)paramMessage.obj;
      QZLog.d("PhotoListActivity", 2, new Object[] { "onEncodeSuccess = ", paramMessage });
      if (this.jdField_a_of_type_Agrz.jdField_a_of_type_JavaUtilArrayList == null) {
        this.jdField_a_of_type_Agrz.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
      }
      if (!this.jdField_b_of_type_Boolean) {
        break label178;
      }
      i1 = bbbx.b();
      if (this.jdField_a_of_type_Agrz.jdField_a_of_type_JavaUtilArrayList.size() < this.jdField_a_of_type_Agrz.jdField_a_of_type_Int) {
        break label185;
      }
      bcql.a((Context)this.jdField_a_of_type_MqqUtilWeakReference.get(), String.format(((NewPhotoListActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).getResources().getString(2131695100), new Object[] { Integer.valueOf(this.jdField_a_of_type_Agrz.jdField_a_of_type_Int) }), 0).a();
    }
    for (;;)
    {
      ((NewPhotoListActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).a(paramMessage);
      return;
      label178:
      i1 = bbbx.a();
      break;
      label185:
      if (this.jdField_a_of_type_Agrz.a() >= i1)
      {
        bcql.a((Context)this.jdField_a_of_type_MqqUtilWeakReference.get(), String.format(((NewPhotoListActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).getResources().getString(2131695105), new Object[] { Integer.valueOf(i1) }), 0).a();
      }
      else
      {
        this.jdField_a_of_type_Agrz.jdField_a_of_type_JavaUtilArrayList.add(paramMessage);
        ((NewPhotoListActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).f();
      }
    }
  }
  
  protected void a(View paramView)
  {
    if (paramView != null) {
      b(paramView.getId());
    }
    paramView = ((NewPhotoListActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).getIntent();
    bbbx.c();
    bbbx.a();
    Object localObject = PresendPicMgr.a();
    if (localObject != null) {
      ((PresendPicMgr)localObject).a(1006);
    }
    if (this.jdField_a_of_type_Agrz.jdField_a_of_type_JavaUtilArrayList != null) {}
    for (int i1 = this.jdField_a_of_type_Agrz.jdField_a_of_type_JavaUtilArrayList.size();; i1 = 0)
    {
      agqd.b(paramView, i1);
      if (this.jdField_a_of_type_Agsb.t) {
        break;
      }
      ((NewPhotoListActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).finish();
      bbbx.a((Activity)this.jdField_a_of_type_MqqUtilWeakReference.get(), false, false);
      return;
    }
    localObject = paramView.getStringExtra("PhotoConst.INIT_ACTIVITY_CLASS_NAME");
    String str1 = paramView.getStringExtra("PhotoConst.INIT_ACTIVITY_PACKAGE_NAME");
    if (localObject == null)
    {
      bcql.a((Context)this.jdField_a_of_type_MqqUtilWeakReference.get(), "请设置INIT_ACTIVITY_CLASS_NAME ", 0).a();
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
      ((NewPhotoListActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).startActivity(paramView);
    }
    for (;;)
    {
      ((NewPhotoListActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).finish();
      bbbx.a((Activity)this.jdField_a_of_type_MqqUtilWeakReference.get(), false, false);
      return;
      paramView.getStringExtra("PhotoConst.PLUGIN_NAME");
      str1 = paramView.getStringExtra("PhotoConst.PLUGIN_APK");
      String str2 = paramView.getStringExtra("PhotoConst.UIN");
      if ("qzone_plugin.apk".equals(str1))
      {
        QzonePluginProxyActivity.a(paramView, (String)localObject);
        bgyp.a((Activity)this.jdField_a_of_type_MqqUtilWeakReference.get(), str2, paramView, 2);
      }
      else if ("qqfav.apk".equals(str1))
      {
        bgpw.a((Activity)this.jdField_a_of_type_MqqUtilWeakReference.get(), str2, paramView, 2);
      }
      else
      {
        QLog.e("PhotoListActivity", 1, "Watermark has been deleted!");
      }
    }
  }
  
  public void a(View paramView, int paramInt, CheckBox paramCheckBox)
  {
    int i1 = 1;
    LocalMediaInfo localLocalMediaInfo = ((NewPhotoListActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).jdField_a_of_type_Agrs.a(paramInt);
    if (localLocalMediaInfo.selectStatus == 1) {}
    while (i1 == 0)
    {
      String[] arrayOfString = agmm.a(localLocalMediaInfo.mMimeType);
      if ((!this.jdField_a_of_type_Agsb.jdField_h_of_type_Boolean) || (arrayOfString == null) || (!"video".equals(arrayOfString[0])) || (bbbx.a((Context)this.jdField_a_of_type_MqqUtilWeakReference.get(), this.jdField_a_of_type_Agrz.a(), localLocalMediaInfo, this.jdField_b_of_type_Boolean))) {
        break;
      }
      localLocalMediaInfo.selectStatus = 2;
      return;
      i1 = 0;
    }
    super.a(paramView, paramInt, paramCheckBox);
    if (i1 == 0)
    {
      agmm.a(localLocalMediaInfo.mMimeType);
      this.jdField_a_of_type_JavaUtilHashMap.put(localLocalMediaInfo.path, Integer.valueOf(localLocalMediaInfo.panoramaPhotoType));
      return;
    }
    agmm.a(localLocalMediaInfo.mMimeType);
    this.jdField_a_of_type_JavaUtilHashMap.remove(localLocalMediaInfo.path);
  }
  
  protected void a(View paramView, Bundle paramBundle, int paramInt, Intent paramIntent)
  {
    b(paramView.getId());
    paramView = ((NewPhotoListActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).getIntent();
    if (this.jdField_a_of_type_Agrz.jdField_a_of_type_JavaUtilArrayList.size() > 0)
    {
      paramView.removeExtra("param_initTime");
      paramView.putStringArrayListExtra("PhotoConst.PHOTO_PATHS", this.jdField_a_of_type_Agrz.jdField_a_of_type_JavaUtilArrayList);
      axqy.b(null, "CliOper", "", "", "0x8004B39", "0x8004B39", 0, 0, "", "", "", "");
      paramView = new HashMap(1);
      if ((this.jdField_a_of_type_Agrz.jdField_a_of_type_JavaUtilHashMap != null) && (this.jdField_a_of_type_Agrz.jdField_a_of_type_JavaUtilHashMap.get(this.jdField_a_of_type_Agrz.jdField_a_of_type_JavaUtilArrayList.get(0)) != null)) {
        paramView.put("param_localmediainfo", this.jdField_a_of_type_Agrz.jdField_a_of_type_JavaUtilHashMap.get(this.jdField_a_of_type_Agrz.jdField_a_of_type_JavaUtilArrayList.get(0)));
      }
      paramView = a(EditPicActivity.a((Activity)this.jdField_a_of_type_MqqUtilWeakReference.get(), (String)this.jdField_a_of_type_Agrz.jdField_a_of_type_JavaUtilArrayList.get(0), true, true, true, true, true, 3, 99, 5, paramView), (String)this.jdField_a_of_type_Agrz.jdField_a_of_type_JavaUtilArrayList.get(0));
      f(paramView);
      ((NewPhotoListActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).startActivity(paramView);
      ((NewPhotoListActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).jdField_a_of_type_AndroidWidgetButton.setClickable(false);
    }
  }
  
  public void a(SlideItemInfo paramSlideItemInfo)
  {
    Object localObject = ((NewPhotoListActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).jdField_a_of_type_Agrs;
    int i1;
    if ((localObject != null) && (paramSlideItemInfo != null))
    {
      List localList = ((agrs)localObject).a();
      i1 = 0;
      if (i1 >= localList.size()) {
        break label100;
      }
      if (!((LocalMediaInfo)localList.get(i1)).path.equals(paramSlideItemInfo.jdField_b_of_type_JavaLangString)) {
        break label93;
      }
    }
    for (;;)
    {
      if (i1 >= 0)
      {
        localObject = ((agrs)localObject).a(i1);
        this.jdField_a_of_type_JavaUtilHashMap.remove(((LocalMediaInfo)localObject).path);
      }
      super.a(paramSlideItemInfo);
      return;
      label93:
      i1 += 1;
      break;
      label100:
      i1 = -1;
    }
  }
  
  protected void a(LocalMediaInfo paramLocalMediaInfo, int paramInt)
  {
    Intent localIntent = ((NewPhotoListActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).getIntent();
    if ((!this.jdField_a_of_type_Agsb.q) && (!this.jdField_a_of_type_Agsb.r) && (this.jdField_b_of_type_Boolean)) {
      localIntent.putExtra("PhotoConst.IS_FROM_SHUOSHUO", this.jdField_b_of_type_Boolean);
    }
    super.a(paramLocalMediaInfo, paramInt);
  }
  
  public void a(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    LocalMediaInfo localLocalMediaInfo = ((NewPhotoListActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).jdField_a_of_type_Agrs.a(paramInt);
    if ((this.c) && (localLocalMediaInfo.mediaWidth > 0) && (localLocalMediaInfo.mediaHeight > 0) && (this.jdField_b_of_type_Int > 0) && (localLocalMediaInfo.fileSize > this.jdField_b_of_type_Int))
    {
      bcql.a((Context)this.jdField_a_of_type_MqqUtilWeakReference.get(), ((NewPhotoListActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).getResources().getString(2131695172, new Object[] { Integer.valueOf(this.jdField_b_of_type_Int / 1048576) }), 0).b(((NewPhotoListActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).getResources().getDimensionPixelSize(2131298865));
      return;
    }
    super.a(paramAdapterView, paramView, paramInt, paramLong);
  }
  
  protected void a(boolean paramBoolean, Intent paramIntent)
  {
    paramIntent.putExtra("from_qzone", this.m);
    paramIntent.putExtra("readSource", this.jdField_b_of_type_JavaLangString);
    paramIntent.putExtra("p_e_s_type", 3);
    if (this.jdField_b_of_type_Boolean) {
      paramIntent.putExtra("PhotoConst.IS_FROM_SHUOSHUO", this.jdField_b_of_type_Boolean);
    }
    super.a(paramBoolean, paramIntent);
  }
  
  protected boolean a(LocalMediaInfo paramLocalMediaInfo, boolean paramBoolean)
  {
    boolean bool1;
    if (paramBoolean)
    {
      String[] arrayOfString = agmm.a(paramLocalMediaInfo.mMimeType);
      if ((this.jdField_a_of_type_Agsb.jdField_h_of_type_Boolean) && (arrayOfString != null) && ("video".equals(arrayOfString[0])) && (!bbbx.a((Context)this.jdField_a_of_type_MqqUtilWeakReference.get(), this.jdField_a_of_type_Agrz.a(), paramLocalMediaInfo, this.jdField_b_of_type_Boolean))) {
        bool1 = false;
      }
    }
    boolean bool2;
    do
    {
      return bool1;
      bool2 = super.a(paramLocalMediaInfo, paramBoolean);
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
  
  protected void b(Intent paramIntent)
  {
    if (this.l) {
      h(paramIntent);
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
    super.b(paramIntent);
  }
  
  protected void b(View paramView)
  {
    b(paramView.getId());
    super.b(paramView);
  }
  
  public void b(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    if (!bbbr.a()) {
      bcql.a((Context)this.jdField_a_of_type_MqqUtilWeakReference.get(), ((NewPhotoListActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).getResources().getString(2131719055), 0).a();
    }
    do
    {
      return;
      paramView = ((NewPhotoListActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).jdField_a_of_type_Agrs.a(paramInt);
    } while (paramView == null);
    paramAdapterView = ((NewPhotoListActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).getIntent();
    Object localObject = paramAdapterView.getStringExtra("PhotoConst.PLUGIN_APK");
    String str = paramAdapterView.getStringExtra("video_refer");
    int i1 = 0;
    if (!TextUtils.isEmpty(str))
    {
      if ((!str.contains("QZonePublishMoodTabActivity")) && (!str.contains("QZoneUploadPhotoRealActivity"))) {
        break label230;
      }
      i1 = 1;
    }
    while (i1 != 0)
    {
      paramLong = paramAdapterView.getLongExtra("PhotoConst.PHOTOLIST_KEY_VIDEO_CAN_UPLOAD_DURATION", 9223372036854775807L);
      if (paramView.mDuration > paramLong)
      {
        paramAdapterView = "请选择不超过" + paramLong / 60L / 1000L + "分钟的视频";
        bcql.a((Context)this.jdField_a_of_type_MqqUtilWeakReference.get(), paramAdapterView, 0).b(((NewPhotoListActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).getTitleBarHeight());
        return;
        label230:
        i1 = 0;
      }
      else
      {
        paramLong = bgyp.b();
        if (paramView.fileSize > paramLong)
        {
          bcql.a((Context)this.jdField_a_of_type_MqqUtilWeakReference.get(), "请选择不超过" + (float)paramLong / 1024.0F / 1024.0F / 1024.0F + "G的视频", 0).b(((NewPhotoListActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).getTitleBarHeight());
          return;
        }
      }
    }
    if ((i1 == 0) && (paramView.fileSize > this.jdField_a_of_type_Agrz.jdField_b_of_type_Long))
    {
      paramAdapterView = bbdj.a((Activity)this.jdField_a_of_type_MqqUtilWeakReference.get(), "你选择的视频文件过大，无法发送。");
      paramAdapterView.setPositiveButton(2131694794, new bbdt());
      paramAdapterView.show();
      return;
    }
    HashMap localHashMap = bbbx.jdField_c_of_type_JavaUtilHashMap;
    if (!localHashMap.containsKey(paramView.path))
    {
      Pair localPair = new Pair(this.jdField_a_of_type_Agrz.jdField_c_of_type_JavaLangString, this.jdField_a_of_type_Agrz.jdField_b_of_type_JavaLangString);
      localHashMap.put(paramView.path, localPair);
    }
    ((NewPhotoListActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).b(paramView.path);
    if (("cover_mall_record_video".equals(str)) && (paramView.mDuration / 1000L > this.jdField_a_of_type_Long / 1000L))
    {
      paramAdapterView = "视频时间不能超过" + this.jdField_a_of_type_Long / 1000L + "s，请重新选择";
      bcql.a((Context)this.jdField_a_of_type_MqqUtilWeakReference.get(), paramAdapterView, 0).b(((NewPhotoListActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).getTitleBarHeight());
      QLog.i("PhotoListActivity", 1, "QQToast:" + paramAdapterView);
      return;
    }
    if (this.f) {
      if ("qzone_plugin.apk".equals(localObject))
      {
        localObject = paramAdapterView.getStringExtra("PhotoConst.INIT_ACTIVITY_CLASS_NAME");
        if ((localObject == null) || (((String)localObject).contains("TrimVideoActivity"))) {
          break label953;
        }
        if ((this.jdField_a_of_type_Agrz.jdField_a_of_type_JavaUtilArrayList != null) && (this.jdField_a_of_type_Agrz.jdField_a_of_type_JavaUtilArrayList.size() > 0))
        {
          bcql.a((Context)this.jdField_a_of_type_MqqUtilWeakReference.get(), "不能同时选择照片和视频", 0).a();
          this.jdField_a_of_type_Agsb.m = false;
          return;
        }
        if (paramView.mDuration >= this.jdField_a_of_type_Agrz.jdField_c_of_type_Long) {
          break label818;
        }
        this.jdField_a_of_type_Agsb.m = true;
      }
    }
    while (!this.jdField_a_of_type_Agsb.m)
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
      PhotoUtils.a((Activity)this.jdField_a_of_type_MqqUtilWeakReference.get(), paramAdapterView, (ArrayList)localObject, 2, false);
      return;
      label818:
      this.jdField_a_of_type_Agsb.m = false;
      paramAdapterView = new StringBuilder();
      paramLong = this.jdField_a_of_type_Agrz.jdField_c_of_type_Long / 1000L;
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
        bcql.a((Context)this.jdField_a_of_type_MqqUtilWeakReference.get(), paramAdapterView.toString(), 0).a();
        return;
        paramAdapterView.append(paramLong).append("分钟");
        continue;
        paramAdapterView.append(paramLong).append("秒");
      }
      label953:
      if (this.jdField_a_of_type_Agrz.a())
      {
        this.jdField_a_of_type_Agsb.m = true;
      }
      else
      {
        localObject = this.jdField_a_of_type_Agsb;
        if (paramView.mDuration > this.jdField_a_of_type_Agrz.jdField_c_of_type_Long) {}
        for (boolean bool = true;; bool = false)
        {
          ((agsb)localObject).m = bool;
          paramAdapterView.putExtra("PhotoConst.IS_PREVIEW_VIDEO", this.jdField_a_of_type_Agsb.m);
          break;
        }
        if ("qzone_plugin.apk".equals(localObject))
        {
          localObject = paramAdapterView.getStringExtra("PhotoConst.INIT_ACTIVITY_CLASS_NAME");
          if ((localObject != null) && (!((String)localObject).contains("TrimVideoActivity")))
          {
            if ((this.j) || (paramView.mDuration > this.jdField_a_of_type_Agrz.jdField_c_of_type_Long) || (this.jdField_a_of_type_Boolean) || ((this.jdField_b_of_type_Boolean) && (e)))
            {
              this.jdField_a_of_type_Agsb.m = true;
            }
            else
            {
              this.jdField_a_of_type_Agsb.m = false;
              paramAdapterView.putExtra("support_record", false);
              paramAdapterView.putExtra("support_trim", true);
              paramAdapterView.putExtra("PhotoConst.IS_CALL_IN_PLUGIN", false);
              paramAdapterView.putExtra("PhotoConst.INIT_ACTIVITY_PACKAGE_NAME", "com.tencent.mobileqq");
              paramAdapterView.putExtra("PhotoConst.INIT_ACTIVITY_CLASS_NAME", "cooperation.qzone.QZoneVideoDownloadActivity");
              paramAdapterView.putExtra("PhotoConst.SHOW_MAGIC_USE_PASTER", this.jdField_a_of_type_Agsb.p);
            }
          }
          else if (this.jdField_a_of_type_Agrz.a())
          {
            this.jdField_a_of_type_Agsb.m = true;
          }
          else
          {
            localObject = this.jdField_a_of_type_Agsb;
            if (paramView.mDuration > this.jdField_a_of_type_Agrz.jdField_c_of_type_Long) {}
            for (bool = true;; bool = false)
            {
              ((agsb)localObject).m = bool;
              paramAdapterView.putExtra("PhotoConst.IS_PREVIEW_VIDEO", this.jdField_a_of_type_Agsb.m);
              break;
            }
          }
        }
      }
    }
    if (((this.jdField_a_of_type_Boolean) || (this.jdField_b_of_type_Boolean) || (this.d) || (this.jdField_a_of_type_Agrz.a())) && ((this.jdField_a_of_type_Agsb.jdField_h_of_type_Boolean) || (this.f)))
    {
      paramView = ((NewPhotoListActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).getIntent();
      paramView.putExtra("ALBUM_NAME", this.jdField_a_of_type_Agrz.jdField_b_of_type_JavaLangString);
      paramView.putExtra("ALBUM_ID", this.jdField_a_of_type_Agrz.jdField_c_of_type_JavaLangString);
      localObject = ((NewPhotoListActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).jdField_a_of_type_Agrs.a(paramInt);
      i1 = ((LocalMediaInfo)localObject).position.intValue();
      paramInt = i1;
      if (!e)
      {
        paramInt = i1;
        if (bbbx.a((LocalMediaInfo)localObject) == 1)
        {
          if (this.jdField_a_of_type_Agrz.jdField_c_of_type_JavaUtilArrayList == null) {
            break label1936;
          }
          this.jdField_a_of_type_Agrz.jdField_c_of_type_JavaUtilArrayList.clear();
          this.jdField_a_of_type_Agrz.jdField_c_of_type_JavaUtilArrayList.add(((LocalMediaInfo)localObject).path);
          if (this.jdField_a_of_type_Agrz.jdField_a_of_type_JavaUtilArrayList == null) {
            break label1953;
          }
          this.jdField_a_of_type_Agrz.jdField_a_of_type_JavaUtilArrayList.clear();
          label1467:
          this.jdField_a_of_type_Agrz.jdField_a_of_type_JavaUtilArrayList.add(((LocalMediaInfo)localObject).path);
          if (this.jdField_a_of_type_Agrz.jdField_b_of_type_JavaUtilArrayList == null) {
            break label1970;
          }
          this.jdField_a_of_type_Agrz.jdField_b_of_type_JavaUtilArrayList.clear();
          label1503:
          this.jdField_a_of_type_Agrz.jdField_b_of_type_JavaUtilArrayList.add(Integer.valueOf(0));
          if (this.jdField_a_of_type_Agrz.jdField_a_of_type_JavaUtilHashMap == null) {
            break label1987;
          }
          this.jdField_a_of_type_Agrz.jdField_a_of_type_JavaUtilHashMap.clear();
          label1538:
          this.jdField_a_of_type_Agrz.jdField_a_of_type_JavaUtilHashMap.put(((LocalMediaInfo)localObject).path, localObject);
          paramInt = 0;
          paramView.putExtra("PhotoConst.IS_SINGLE_MODE", true);
        }
      }
      paramView.putExtra("PhotoConst.CURRENT_SELECTED_INDEX", paramInt);
      paramView.putStringArrayListExtra("PhotoConst.SELECTED_PATHS", this.jdField_a_of_type_Agrz.jdField_a_of_type_JavaUtilArrayList);
      paramView.putIntegerArrayListExtra("PhotoConst.SELECTED_INDEXS", this.jdField_a_of_type_Agrz.jdField_b_of_type_JavaUtilArrayList);
      paramView.putExtra("FROM_WHERE", "FROM_PHOTO_LIST");
      paramView.putExtra("PhotoConst.CURRENT_QUALITY_TYPE", this.jdField_a_of_type_Agrz.jdField_c_of_type_Int);
      paramView.putExtra("PhotoConst.SHOW_ALBUM", true);
      paramView.putExtra("PhotoConst.SHOW_MAGIC_USE_PASTER", this.jdField_a_of_type_Agsb.p);
      paramView.putExtra("PasterConstants.paster_id", this.jdField_a_of_type_Agsb.jdField_c_of_type_JavaLangString);
      paramView.putExtra("PasterConstants.paster_cate_id", this.jdField_a_of_type_Agsb.d);
      agsb.jdField_a_of_type_Int = ((NewPhotoListActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).jdField_a_of_type_ComTencentWidgetGestureSelectGridView.getFirstVisiblePosition();
      if (!this.jdField_a_of_type_Agrz.jdField_a_of_type_JavaUtilHashMap.containsKey(((LocalMediaInfo)localObject).path)) {
        this.jdField_a_of_type_Agrz.jdField_a_of_type_JavaUtilHashMap.put(((LocalMediaInfo)localObject).path, localObject);
      }
      paramView.putExtra("PeakConstants.selectedMediaInfoHashMap", this.jdField_a_of_type_Agrz.jdField_a_of_type_JavaUtilHashMap);
      paramView.putExtra("PasterConstants.pasters_data", this.jdField_a_of_type_Agsb.jdField_c_of_type_JavaUtilHashMap);
      paramView.setClass((Context)this.jdField_a_of_type_MqqUtilWeakReference.get(), NewPhotoPreviewActivity.class);
      if (this.jdField_b_of_type_Boolean) {
        paramAdapterView.putExtra("PhotoConst.IS_FROM_SHUOSHUO", this.jdField_b_of_type_Boolean);
      }
      paramView.putExtra("from_qzone", this.m);
      paramView.addFlags(603979776);
      if ((this.jdField_a_of_type_Agrz.jdField_a_of_type_JavaUtilArrayList != null) && (this.jdField_a_of_type_Agrz.jdField_a_of_type_JavaUtilArrayList.size() > 0)) {
        axqy.b(null, "CliOper", "", this.jdField_a_of_type_Agrz.jdField_a_of_type_JavaLangString, "0X8005674", "0X8005674", 0, this.jdField_a_of_type_Agrz.jdField_a_of_type_JavaUtilArrayList.size(), 0, "", "", "", "");
      }
      if (this.jdField_a_of_type_Agrz.a()) {
        ((NewPhotoListActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).startActivityForResult(paramAdapterView, 100010);
      }
      for (;;)
      {
        bbbx.a((Activity)this.jdField_a_of_type_MqqUtilWeakReference.get(), true, true);
        return;
        label1936:
        this.jdField_a_of_type_Agrz.jdField_c_of_type_JavaUtilArrayList = new ArrayList();
        break;
        label1953:
        this.jdField_a_of_type_Agrz.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
        break label1467;
        label1970:
        this.jdField_a_of_type_Agrz.jdField_b_of_type_JavaUtilArrayList = new ArrayList();
        break label1503;
        label1987:
        this.jdField_a_of_type_Agrz.jdField_a_of_type_JavaUtilHashMap = new HashMap();
        break label1538;
        ((NewPhotoListActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).startActivity(paramView);
        ((NewPhotoListActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).finish();
      }
    }
    localObject = new Intent((Context)this.jdField_a_of_type_MqqUtilWeakReference.get(), ShortVideoPreviewActivity.class);
    ((Intent)localObject).putExtras(paramAdapterView);
    ((Intent)localObject).putExtra("file_send_path", paramView.path);
    ((Intent)localObject).putExtra("file_send_size", paramView.fileSize);
    ((Intent)localObject).putExtra("file_send_duration", paramView.mDuration);
    ((Intent)localObject).putExtra("file_width", paramView.mediaWidth);
    ((Intent)localObject).putExtra("file_height", paramView.mediaHeight);
    ((Intent)localObject).putExtra("uin", this.jdField_a_of_type_Agsb.f);
    ((Intent)localObject).putExtra("uintype", this.jdField_a_of_type_Agsb.jdField_h_of_type_Int);
    ((Intent)localObject).putExtra("file_source", "album");
    ((Intent)localObject).putExtra("is_from_system_media", paramView.isSystemMeidaStore);
    if (this.jdField_a_of_type_Agsb.jdField_h_of_type_Boolean)
    {
      ((Intent)localObject).putExtra("PhotoConst.IS_SUPPORT_VIDEO_CHECKBOX", true);
      ((Intent)localObject).putExtra("PhotoConst.PHOTO_PATHS", this.jdField_a_of_type_Agrz.jdField_a_of_type_JavaUtilArrayList);
    }
    if (((this.jdField_a_of_type_Boolean) || ((this.jdField_b_of_type_Boolean) && (e) && (!g))) && (this.jdField_a_of_type_Agsb.jdField_h_of_type_Boolean)) {
      ((Intent)localObject).putExtra("preview_only", true);
    }
    ((NewPhotoListActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).startActivityForResult((Intent)localObject, 17);
  }
  
  protected void c()
  {
    super.c();
    ((NewPhotoListActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).jdField_a_of_type_ComTencentWidgetGestureSelectGridView.setOnScrollListener(new aguf(this));
    if ((TextUtils.isEmpty(this.jdField_a_of_type_Agsb.jdField_a_of_type_JavaLangString)) && (1 == this.jdField_a_of_type_Int))
    {
      String str = ((NewPhotoListActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).getString(2131695107);
      ((NewPhotoListActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).jdField_c_of_type_AndroidWidgetTextView.setVisibility(0);
      ((NewPhotoListActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).jdField_c_of_type_AndroidWidgetTextView.setText(((NewPhotoListActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).getString(2131695119));
      ((NewPhotoListActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).jdField_c_of_type_AndroidWidgetButton.setText(str);
    }
  }
  
  protected void c(Intent paramIntent)
  {
    if (this.jdField_a_of_type_Int == 1)
    {
      abtq.a((Context)this.jdField_a_of_type_MqqUtilWeakReference.get(), paramIntent, PublicFragmentActivityForPeak.class, QzonePhotoPreviewActivity.class);
      return;
    }
    super.c(paramIntent);
  }
  
  protected void c(View paramView)
  {
    b(paramView.getId());
    ((NewPhotoListActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).jdField_c_of_type_AndroidWidgetButton.setClickable(false);
    if (!this.jdField_a_of_type_Agrz.jdField_a_of_type_JavaUtilArrayList.isEmpty()) {
      ((NewPhotoListActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).b((String)this.jdField_a_of_type_Agrz.jdField_a_of_type_JavaUtilArrayList.get(this.jdField_a_of_type_Agrz.jdField_a_of_type_JavaUtilArrayList.size() - 1));
    }
    bbbx.a();
    if (this.jdField_a_of_type_Agrz.jdField_a_of_type_JavaUtilArrayList.size() == 0)
    {
      if (QLog.isColorLevel()) {
        QLog.e("PhotoList", 2, "size == 0");
      }
      return;
    }
    Intent localIntent = ((NewPhotoListActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).getIntent();
    if (localIntent.getBooleanExtra("PhotoConst.IS_SEND_FILESIZE_LIMIT", false))
    {
      paramView = this.jdField_a_of_type_Agrz.jdField_a_of_type_JavaUtilArrayList.iterator();
      for (long l1 = 0L; paramView.hasNext(); l1 = bbdx.a((String)paramView.next()) + l1) {}
      if (apug.a())
      {
        aptt.a((Context)this.jdField_a_of_type_MqqUtilWeakReference.get(), 2131692673, 2131692678, new aguh(this));
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
      paramView = bgyw.a();
      bgyp.a((Activity)this.jdField_a_of_type_MqqUtilWeakReference.get(), paramView, localIntent, -1, null);
      return;
    }
    h();
  }
  
  public void c(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    if (!bbbr.a())
    {
      bcql.a((Context)this.jdField_a_of_type_MqqUtilWeakReference.get(), ((NewPhotoListActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).getResources().getString(2131719055), 0).a();
      return;
    }
    if ((this.jdField_b_of_type_Boolean) || (this.jdField_a_of_type_Boolean))
    {
      n();
      return;
    }
    ((NewPhotoListActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).h();
  }
  
  protected void d()
  {
    boolean bool2 = true;
    boolean bool1 = true;
    super.d();
    String str;
    if (this.jdField_a_of_type_Agsb.jdField_a_of_type_JavaLangString != null)
    {
      str = this.jdField_a_of_type_Agsb.jdField_a_of_type_JavaLangString;
      if (1 == this.jdField_a_of_type_Int) {
        break label221;
      }
      if (this.jdField_a_of_type_Agrz.jdField_a_of_type_JavaUtilArrayList.size() <= 0) {
        break label216;
      }
      label47:
      if (!bool1) {
        break label245;
      }
      str = str + "(" + this.jdField_a_of_type_Agrz.jdField_a_of_type_JavaUtilArrayList.size() + ")";
    }
    label216:
    label221:
    label245:
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("_photo", 2, "updateButton selectedPhotoList.size()=" + this.jdField_a_of_type_Agrz.jdField_a_of_type_JavaUtilArrayList.size());
      }
      ((NewPhotoListActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).jdField_c_of_type_AndroidWidgetButton.setText(str);
      ((NewPhotoListActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).jdField_c_of_type_AndroidWidgetButton.setEnabled(bool1);
      return;
      if (1 == this.jdField_a_of_type_Int)
      {
        str = ((NewPhotoListActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).getString(2131695107);
        break;
      }
      str = ((NewPhotoListActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).getString(2131695085);
      break;
      bool1 = false;
      break label47;
      if (this.jdField_a_of_type_Agrz.jdField_a_of_type_JavaUtilArrayList.size() >= 3) {}
      for (bool1 = bool2;; bool1 = false) {
        break;
      }
    }
  }
  
  protected void d(Intent paramIntent)
  {
    a(5);
    super.d(paramIntent);
  }
  
  protected void e(Intent paramIntent)
  {
    a(4);
    super.e(paramIntent);
  }
  
  protected void h()
  {
    Intent localIntent = ((NewPhotoListActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).getIntent();
    if (this.jdField_a_of_type_Agrz.jdField_c_of_type_JavaLangString.equals("$RecentAlbumId")) {
      axrn.a((Context)this.jdField_a_of_type_MqqUtilWeakReference.get()).a(null, "sendAlbumRecent", true, 0L, 0L, null, "");
    }
    Object localObject;
    for (;;)
    {
      localObject = PresendPicMgr.a();
      if ((!this.jdField_a_of_type_Agsb.p) || ((TextUtils.isEmpty(this.jdField_a_of_type_Agsb.jdField_c_of_type_JavaLangString)) && (TextUtils.isEmpty(this.jdField_a_of_type_Agsb.d)))) {
        break;
      }
      ((NewPhotoListActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).jdField_a_of_type_AndroidWidgetButton.performClick();
      return;
      if ((this.jdField_a_of_type_Agrz.jdField_b_of_type_JavaLangString.equalsIgnoreCase("Camera")) || (this.jdField_a_of_type_Agrz.jdField_b_of_type_JavaLangString.equalsIgnoreCase("camera")) || (this.jdField_a_of_type_Agrz.jdField_b_of_type_JavaLangString.contains("Camera")) || (this.jdField_a_of_type_Agrz.jdField_b_of_type_JavaLangString.contains("camera"))) {
        axrn.a((Context)this.jdField_a_of_type_MqqUtilWeakReference.get()).a(null, "sendAlbumRecent", false, 0L, 0L, null, "");
      } else {
        axrn.a((Context)this.jdField_a_of_type_MqqUtilWeakReference.get()).a(null, "sendAlbumOther", true, 0L, 0L, null, "");
      }
    }
    if (this.jdField_a_of_type_Agrz.jdField_a_of_type_JavaUtilArrayList != null)
    {
      agqd.a(localIntent, this.jdField_a_of_type_Agrz.jdField_a_of_type_JavaUtilArrayList.size());
      agqd.a(localIntent, this.jdField_a_of_type_Agrz.jdField_a_of_type_JavaUtilArrayList.size(), this.jdField_a_of_type_Agrz.jdField_c_of_type_Int);
    }
    if (this.jdField_a_of_type_Agrz.jdField_c_of_type_Int == 2)
    {
      if (localObject != null)
      {
        ((PresendPicMgr)localObject).a(1008);
        ((PresendPicMgr)localObject).a();
      }
      axqy.b(null, "CliOper", "", "", "0X8005148", "0X8005148", 0, 0, "", "", "", "");
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
        localIntent.putExtra("PeakConstants.selectedMediaInfoHashMap", this.jdField_a_of_type_Agrz.jdField_a_of_type_JavaUtilHashMap);
      }
      if (this.l) {
        h(localIntent);
      }
      if (this.jdField_a_of_type_Agrz.jdField_a_of_type_JavaUtilArrayList != null) {
        ahvx.a(this.jdField_a_of_type_Agrz.jdField_a_of_type_JavaUtilArrayList);
      }
      f(localIntent);
      localIntent.putExtra("PhotoConst.PANORAMA_IMAGES", this.jdField_a_of_type_JavaUtilHashMap);
      if (1 != this.jdField_a_of_type_Int) {
        break label593;
      }
      localIntent.putExtra("PhotoConst.KEY_SHOW_TYPE", 1);
      localIntent.putExtra("PhotoConst.KEY_SHOW_ORIGIN_TYPE", 1);
    }
    for (;;)
    {
      a(localIntent, false, this.jdField_a_of_type_Agrz.jdField_a_of_type_JavaUtilArrayList);
      return;
      if ((localObject == null) || (this.jdField_a_of_type_Agsb.w)) {
        break;
      }
      ((PresendPicMgr)localObject).a(localIntent);
      break;
      label593:
      localIntent.putExtra("PhotoConst.KEY_SHOW_TYPE", 0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     ague
 * JD-Core Version:    0.7.0.1
 */