import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Message;
import android.text.TextUtils;
import android.util.Pair;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.ListAdapter;
import android.widget.TextView;
import com.tencent.biz.qqstory.app.QQStoryContext;
import com.tencent.biz.qqstory.takevideo.slideshow.SlideItemInfo;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.component.media.image.ImageManager;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.activity.photo.PhotoCropActivity;
import com.tencent.mobileqq.activity.photo.PhotoCropForPortraitActivity;
import com.tencent.mobileqq.activity.photo.PhotoUtils;
import com.tencent.mobileqq.activity.photo.album.NewPhotoListActivity;
import com.tencent.mobileqq.activity.photo.album.NewPhotoPreviewActivity;
import com.tencent.mobileqq.activity.photo.album.PhotoListLogicDefault.1;
import com.tencent.mobileqq.activity.photo.album.PhotoListLogicDefault.5;
import com.tencent.mobileqq.activity.photo.album.PhotoListLogicDefault.7;
import com.tencent.mobileqq.activity.photo.album.PhotoListLogicDefault.8;
import com.tencent.mobileqq.activity.shortvideo.SendVideoActivity.SendVideoInfo;
import com.tencent.mobileqq.activity.shortvideo.ShortVideoPreviewActivity;
import com.tencent.mobileqq.pic.PresendPicMgr;
import com.tencent.mobileqq.widget.NumberCheckBox;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.AdapterView;
import com.tencent.widget.GestureSelectGridView;
import cooperation.qzone.util.QZLog;
import dov.com.tencent.biz.qqstory.takevideo.EditPicActivity;
import java.io.File;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import mqq.app.AppRuntime;
import mqq.app.NewIntent;
import mqq.util.WeakReference;

public class agsj
  extends agsh
  implements agsd, agse, agsf, vuf
{
  public agsb a;
  
  protected agsj(NewPhotoListActivity paramNewPhotoListActivity)
  {
    super(paramNewPhotoListActivity);
    this.jdField_a_of_type_Agsf = this;
    this.jdField_a_of_type_Agsd = this;
    this.jdField_a_of_type_Agse = this;
    this.a = new agsb();
    this.jdField_a_of_type_Agsb = ((agsb)this.a);
  }
  
  public static agsc a(NewPhotoListActivity paramNewPhotoListActivity)
  {
    if ((jdField_a_of_type_Agsc == null) || (jdField_a_of_type_Agsc.jdField_a_of_type_MqqUtilWeakReference.get() != paramNewPhotoListActivity)) {}
    try
    {
      if ((jdField_a_of_type_Agsc == null) || (jdField_a_of_type_Agsc.jdField_a_of_type_MqqUtilWeakReference.get() != paramNewPhotoListActivity))
      {
        if (jdField_a_of_type_Agsc != null) {
          jdField_a_of_type_Agsc.b();
        }
        jdField_a_of_type_Agsc = new agsj(paramNewPhotoListActivity);
      }
      return jdField_a_of_type_Agsc;
    }
    finally {}
  }
  
  public Intent a(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    paramAdapterView = super.a(paramAdapterView, paramView, paramInt, paramLong);
    paramAdapterView.putExtra("PhotoConst.MY_UIN", this.jdField_a_of_type_Agrz.jdField_a_of_type_JavaLangString);
    paramAdapterView.putExtra("PhotoConst.CURRENT_QUALITY_TYPE", this.jdField_a_of_type_Agrz.jdField_c_of_type_Int);
    paramAdapterView.putExtra("PhotoConst.SHOW_MAGIC_USE_PASTER", this.jdField_a_of_type_Agsb.p);
    paramAdapterView.putExtra("PhotoConst.editPathMap", agpk.a(this.jdField_a_of_type_Agsb.jdField_a_of_type_JavaUtilHashMap));
    paramAdapterView.putExtra("p_e_s_type", 6);
    paramAdapterView.putExtra("PasterConstants.paster_id", this.jdField_a_of_type_Agsb.jdField_c_of_type_JavaLangString);
    paramAdapterView.putExtra("PasterConstants.paster_cate_id", this.jdField_a_of_type_Agsb.jdField_d_of_type_JavaLangString);
    paramAdapterView.putExtra("PasterConstants.pasters_data", this.jdField_a_of_type_Agsb.jdField_c_of_type_JavaUtilHashMap);
    if ((this.jdField_a_of_type_Agrz.jdField_a_of_type_JavaUtilArrayList != null) && (this.jdField_a_of_type_Agrz.jdField_a_of_type_JavaUtilArrayList.size() > 0)) {
      axqy.b(null, "CliOper", "", this.jdField_a_of_type_Agrz.jdField_a_of_type_JavaLangString, "0X8005674", "0X8005674", 0, this.jdField_a_of_type_Agrz.jdField_a_of_type_JavaUtilArrayList.size(), 0, "", "", "", "");
    }
    return paramAdapterView;
  }
  
  public View a(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    return super.a(paramInt, paramView, paramViewGroup);
  }
  
  public View a(int paramInt, View paramView, ViewGroup paramViewGroup, agrt paramagrt, agrq paramagrq)
  {
    return super.a(paramInt, paramView, paramViewGroup, paramagrt, paramagrq);
  }
  
  protected String a(LocalMediaInfo paramLocalMediaInfo)
  {
    int i = this.jdField_a_of_type_Agrz.jdField_a_of_type_Int;
    String str2 = super.a(paramLocalMediaInfo);
    String str1 = str2;
    if (paramLocalMediaInfo != null)
    {
      paramLocalMediaInfo = agmm.a(paramLocalMediaInfo.mMimeType);
      if ((!this.jdField_a_of_type_Agrz.a()) || (this.jdField_a_of_type_Agsb.jdField_h_of_type_Boolean)) {
        break label82;
      }
      str1 = ((NewPhotoListActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).getResources().getString(2131695101, new Object[] { Integer.valueOf(i) });
    }
    label82:
    do
    {
      do
      {
        do
        {
          return str1;
          str1 = str2;
        } while (!this.jdField_a_of_type_Agsb.jdField_h_of_type_Boolean);
        str1 = str2;
      } while (paramLocalMediaInfo == null);
      str1 = str2;
    } while (!"video".equals(paramLocalMediaInfo[0]));
    if (this.jdField_a_of_type_Agrz.a()) {
      return ((NewPhotoListActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).getResources().getString(2131695102, new Object[] { Integer.valueOf(i) });
    }
    return ((NewPhotoListActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).getResources().getString(2131695100, new Object[] { Integer.valueOf(i) });
  }
  
  protected List<LocalMediaInfo> a()
  {
    int i = -1;
    if (this.jdField_a_of_type_Agrz.jdField_c_of_type_JavaLangString.equals("$RecentAlbumId")) {
      i = 100;
    }
    Object localObject1;
    if (this.jdField_a_of_type_Agrz.a()) {
      if ((!TextUtils.isEmpty(this.jdField_a_of_type_Agrz.jdField_c_of_type_JavaLangString)) && (this.jdField_a_of_type_Agrz.jdField_c_of_type_JavaLangString.equals("$CustomAlbumId")))
      {
        localObject1 = new ArrayList();
        ((List)localObject1).addAll(vtz.a().b());
        bbfb.a("PEAK", "getAlbumMedias");
        if (localObject1 != null) {
          break label208;
        }
        if (QLog.isColorLevel()) {
          QLog.d("SelectPhotoTrace", 2, "photoList is null");
        }
        localObject2 = null;
      }
    }
    label208:
    do
    {
      do
      {
        do
        {
          return localObject2;
          localObject1 = bbbx.a((Context)this.jdField_a_of_type_MqqUtilWeakReference.get(), this.jdField_a_of_type_Agrz.jdField_c_of_type_JavaLangString, this.jdField_a_of_type_Agrz.jdField_b_of_type_JavaLangString, i, this.jdField_a_of_type_Agsb.jdField_a_of_type_Aglv, 0, 0, true, null, false, this.jdField_a_of_type_Agsb.jdField_a_of_type_Long, 1);
          break;
          localObject1 = bbbx.b((Context)this.jdField_a_of_type_MqqUtilWeakReference.get(), this.jdField_a_of_type_Agrz.jdField_c_of_type_JavaLangString, this.jdField_a_of_type_Agrz.jdField_b_of_type_JavaLangString, i, this.jdField_a_of_type_Agsb.jdField_a_of_type_Aglv, this.jdField_a_of_type_Agsb.jdField_a_of_type_Long);
          break;
          localObject2 = localObject1;
        } while (this.jdField_a_of_type_Agrz.jdField_a_of_type_JavaUtilArrayList == null);
        localObject2 = localObject1;
      } while (this.jdField_a_of_type_Agrz.jdField_a_of_type_JavaUtilArrayList.size() == 0);
      i = 0;
      localObject2 = localObject1;
    } while (i >= this.jdField_a_of_type_Agrz.jdField_a_of_type_JavaUtilArrayList.size());
    Object localObject2 = (String)this.jdField_a_of_type_Agrz.jdField_a_of_type_JavaUtilArrayList.get(i);
    int j;
    if (TextUtils.isEmpty((CharSequence)localObject2))
    {
      QZLog.e("PhotoListActivity:QueryPhotoTask", "doInBackground: filter photo error, tempPath null");
      j = i;
    }
    for (;;)
    {
      i = j + 1;
      break;
      j = i;
      if (!new File((String)localObject2).exists()) {
        if ((((String)localObject2).startsWith("http")) && (this.jdField_a_of_type_Agrz.jdField_c_of_type_JavaUtilHashMap != null))
        {
          j = i;
          if (this.jdField_a_of_type_Agrz.jdField_c_of_type_JavaUtilHashMap.containsKey(localObject2)) {}
        }
        else
        {
          this.jdField_a_of_type_Agrz.jdField_a_of_type_JavaUtilArrayList.remove(i);
          i -= 1;
          j = i;
          if (this.jdField_a_of_type_Agrz.jdField_d_of_type_Boolean)
          {
            j = i;
            if (this.jdField_a_of_type_Agrz.jdField_a_of_type_JavaUtilHashMap != null)
            {
              j = i;
              if (this.jdField_a_of_type_Agrz.jdField_a_of_type_JavaUtilHashMap.containsKey(localObject2))
              {
                this.jdField_a_of_type_Agrz.jdField_a_of_type_JavaUtilHashMap.remove(localObject2);
                j = i;
              }
            }
          }
        }
      }
    }
  }
  
  public void a() {}
  
  public void a(int paramInt1, int paramInt2)
  {
    ArrayList localArrayList = this.jdField_a_of_type_Agrz.jdField_a_of_type_JavaUtilArrayList;
    GestureSelectGridView localGestureSelectGridView = ((NewPhotoListActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).jdField_a_of_type_ComTencentWidgetGestureSelectGridView;
    agrs localagrs = ((NewPhotoListActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).jdField_a_of_type_Agrs;
    if ((paramInt1 >= 0) && (paramInt1 < localArrayList.size()) && (paramInt2 >= 0) && (paramInt2 < localArrayList.size()))
    {
      Collections.swap(localArrayList, paramInt1, paramInt2);
      paramInt2 = localGestureSelectGridView.getFirstVisiblePosition();
      int i = localGestureSelectGridView.getLastVisiblePosition();
      paramInt1 = paramInt2;
      while (paramInt1 <= i)
      {
        Object localObject = localagrs.a(paramInt1);
        int j = localArrayList.indexOf(((LocalMediaInfo)localObject).path);
        if (j >= 0)
        {
          localObject = (agrt)localGestureSelectGridView.getChildAt(((LocalMediaInfo)localObject).position.intValue() - paramInt2).getTag();
          if ((localObject != null) && (((agrt)localObject).a != null)) {
            ((agrt)localObject).a.setCheckedNumber(j + 1);
          }
        }
        paramInt1 += 1;
      }
      vtz.a().b(localArrayList, this.jdField_a_of_type_Agrz.jdField_b_of_type_JavaUtilHashMap);
    }
    ((NewPhotoListActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).b(true);
  }
  
  protected void a(int paramInt1, int paramInt2, Intent paramIntent)
  {
    ArrayList localArrayList = this.jdField_a_of_type_Agrz.jdField_a_of_type_JavaUtilArrayList;
    if ((QLog.isDevelopLevel()) && (localArrayList != null) && (localArrayList.size() != 0)) {
      QLog.d("PhotoListActivity", 4, "[NewPhotoListActivity] [onActivityResult] selectedPhotoList = " + localArrayList.size());
    }
    this.jdField_a_of_type_Agsb.g = paramInt1;
    if (paramInt2 == -1) {
      switch (paramInt1)
      {
      }
    }
    for (;;)
    {
      PhotoUtils.a((Activity)this.jdField_a_of_type_MqqUtilWeakReference.get(), paramInt1, paramInt2, paramIntent, this.jdField_a_of_type_Agsb.s, this.jdField_a_of_type_Agrz.jdField_a_of_type_JavaLangString);
      do
      {
        return;
        ((NewPhotoListActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).setResult(-1, paramIntent);
        ((NewPhotoListActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).finish();
        break;
        paramIntent = PresendPicMgr.a();
        if (paramIntent != null) {
          paramIntent.a(this.jdField_a_of_type_Agsb.jdField_b_of_type_JavaLangString, 1008);
        }
        a(true, ((NewPhotoListActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).getIntent());
        return;
        paramIntent = new Intent();
        paramIntent.putStringArrayListExtra("PhotoConst.SELECTED_PATHS", localArrayList);
        paramIntent.putExtra("PhotoConst.CURRENT_QUALITY_TYPE", this.jdField_a_of_type_Agrz.jdField_c_of_type_Int);
        ((NewPhotoListActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).setResult(-1, paramIntent);
        ((NewPhotoListActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).finish();
        return;
      } while (paramIntent == null);
      this.jdField_a_of_type_Agrz.jdField_a_of_type_JavaUtilArrayList = paramIntent.getStringArrayListExtra("img_list");
      continue;
      vtz.a().a(paramIntent, this.jdField_a_of_type_Agrz.jdField_a_of_type_JavaUtilHashMap);
      continue;
      if (paramInt1 == 17)
      {
        bbbx.jdField_a_of_type_Long = 0L;
        return;
      }
      if ((paramInt1 == 100010) && (this.jdField_a_of_type_Agrz.a())) {
        if (this.jdField_a_of_type_Agsb.i) {
          ((NewPhotoListActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).runOnUiThread(new PhotoListLogicDefault.5(this));
        } else {
          this.jdField_a_of_type_Agsb.i = true;
        }
      }
    }
  }
  
  public void a(int paramInt, LocalMediaInfo paramLocalMediaInfo)
  {
    super.a(paramInt, paramLocalMediaInfo);
  }
  
  protected void a(Intent paramIntent)
  {
    if (QLog.isColorLevel()) {
      QLog.d("SelectPhotoTrace", 2, "PhotoListActivity initData(),intent extras is:" + paramIntent.getExtras());
    }
    super.a(paramIntent);
    this.jdField_a_of_type_Agsb.x = paramIntent.getBooleanExtra("PhotoConst.IS_FROM_EDIT", false);
    agpk.a((Context)this.jdField_a_of_type_MqqUtilWeakReference.get(), paramIntent, false, this.jdField_a_of_type_Agsb.jdField_a_of_type_JavaUtilHashMap);
    this.jdField_a_of_type_Agsb.jdField_b_of_type_JavaUtilHashMap = ((HashMap)paramIntent.getSerializableExtra("PhotoConst.PHOTO_PATHS_FROM_QZONEALBUM"));
    if (this.jdField_a_of_type_Agsb.jdField_b_of_type_JavaUtilHashMap == null) {
      this.jdField_a_of_type_Agsb.jdField_b_of_type_JavaUtilHashMap = new HashMap(1);
    }
    this.jdField_a_of_type_Agrz.jdField_c_of_type_Boolean = paramIntent.getBooleanExtra("PhotoConst.IS_SHOW_QZONE_ALBUM", false);
    this.jdField_a_of_type_Agrz.jdField_c_of_type_JavaUtilHashMap = ((HashMap)paramIntent.getSerializableExtra("PhotoConst.PHOTO_INFOS"));
    this.jdField_a_of_type_Agsb.n = paramIntent.getBooleanExtra("PhotoConst.original_button", false);
    this.jdField_a_of_type_Agsb.o = paramIntent.getBooleanExtra("PhotoConst.quality_count_tv", true);
    this.jdField_a_of_type_Agrz.jdField_a_of_type_JavaLangString = paramIntent.getStringExtra("PhotoConst.MY_UIN");
    this.jdField_a_of_type_Agsb.l = paramIntent.getBooleanExtra("PhotoConst.HANDLE_DEST_RESULT", false);
    this.jdField_a_of_type_Agsb.q = paramIntent.getBooleanExtra("PhotoConst.IS_SINGLE_DERECTBACK_MODE", false);
    this.jdField_a_of_type_Agsb.r = paramIntent.getBooleanExtra("PhotoConst.IS_SINGLE_NEED_EDIT", false);
    this.jdField_a_of_type_Agsb.s = paramIntent.getBooleanExtra("PhotoConst.IS_CALL_IN_PLUGIN", false);
    this.jdField_a_of_type_Agsb.jdField_h_of_type_Int = paramIntent.getIntExtra("uintype", -1);
    this.jdField_a_of_type_Agrz.jdField_c_of_type_Int = paramIntent.getIntExtra("PhotoConst.CURRENT_QUALITY_TYPE", 0);
    if (paramIntent.getBooleanExtra("PhotoConst.ALWAYS_SHOW_NUMBER_WHEN_ONLY_ONE_IMAGE", false)) {
      this.jdField_a_of_type_Agsb.jdField_c_of_type_Boolean = false;
    }
    this.jdField_a_of_type_Agsb.t = paramIntent.getBooleanExtra("PhotoConst.IS_FINISH_RESTART_INIT_ACTIVITY", false);
    this.jdField_a_of_type_Agsb.u = paramIntent.getBooleanExtra("PhotoConst.SEND_FLAG", false);
    this.jdField_a_of_type_Agsb.jdField_e_of_type_JavaLangString = paramIntent.getStringExtra("uinname");
    this.jdField_a_of_type_Agsb.jdField_f_of_type_JavaLangString = paramIntent.getStringExtra("uin");
    this.jdField_a_of_type_Agrz.jdField_b_of_type_Long = paramIntent.getLongExtra("PhotoConst.PHOTOLIST_KEY_VIDEO_SIZE", 1048576000L);
    this.jdField_a_of_type_Agsb.m = paramIntent.getBooleanExtra("PhotoConst.IS_PREVIEW_VIDEO", true);
    this.jdField_a_of_type_Agrz.jdField_c_of_type_Long = paramIntent.getLongExtra("PhotoConst.PHOTOLIST_KEY_VIDEO_DURATION", 9223372036854775807L);
    try
    {
      this.jdField_a_of_type_Agsb.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo = ((SessionInfo)paramIntent.getParcelableExtra("session_info"));
      if (this.jdField_a_of_type_Agsb.u)
      {
        paramIntent.removeExtra("PhotoConst.SEND_FLAG");
        PresendPicMgr localPresendPicMgr = PresendPicMgr.a();
        if (localPresendPicMgr != null)
        {
          if (QLog.isColorLevel()) {
            QLog.d("PhotoListActivity", 2, "Photo+ send pic,cancel presend!");
          }
          localPresendPicMgr.a(1004);
        }
        PhotoUtils.a((Activity)this.jdField_a_of_type_MqqUtilWeakReference.get(), paramIntent, this.jdField_a_of_type_Agrz.jdField_a_of_type_JavaUtilArrayList, this.jdField_a_of_type_Agrz.jdField_c_of_type_Int, true);
      }
      if (!this.jdField_a_of_type_Agsb.p) {
        this.jdField_a_of_type_Agsb.p = paramIntent.getBooleanExtra("PhotoConst.SHOW_MAGIC_USE_PASTER", false);
      }
      if (this.jdField_a_of_type_Agsb.p)
      {
        this.jdField_a_of_type_Agsb.jdField_c_of_type_JavaUtilHashMap = ((HashMap)paramIntent.getSerializableExtra("PasterConstants.pasters_data"));
        this.jdField_a_of_type_Agsb.jdField_c_of_type_JavaLangString = paramIntent.getStringExtra("PasterConstants.paster_id");
        this.jdField_a_of_type_Agsb.jdField_d_of_type_JavaLangString = paramIntent.getStringExtra("PasterConstants.paster_cate_id");
      }
      this.jdField_a_of_type_Agsb.w = paramIntent.getBooleanExtra("ReceiptMsgManager.EXTRA_KEY_IS_RECEIPT", false);
      this.jdField_a_of_type_Agsb.jdField_c_of_type_Long = paramIntent.getLongExtra("PhotoConst.PHOTOLIST_KEY_MAX_MEDIA_SIZE", -1L);
      if (this.jdField_a_of_type_Agrz.jdField_c_of_type_Boolean)
      {
        paramIntent = new NewIntent(BaseApplicationImpl.getApplication(), axch.class);
        paramIntent.putExtra("selfuin", Long.valueOf(BaseApplicationImpl.getApplication().getRuntime().getAccount()));
        BaseApplicationImpl.getApplication().getRuntime().registObserver(NewPhotoListActivity.jdField_a_of_type_Agru);
        BaseApplicationImpl.getApplication().getRuntime().startServlet(paramIntent);
      }
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.e("PhotoListActivity", 2, "submit", localException);
        }
      }
    }
  }
  
  protected void a(Intent paramIntent, boolean paramBoolean, ArrayList<String> paramArrayList)
  {
    int i2 = PhotoUtils.b(this.jdField_a_of_type_Agsb.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo);
    Object localObject1 = new HashMap();
    int j = 0;
    int i = 0;
    int i1 = 0;
    int k = 0;
    while (i1 < paramArrayList.size())
    {
      localObject2 = (String)paramArrayList.get(i1);
      int m;
      if (ImageManager.isNetworkUrl((String)localObject2))
      {
        m = k;
        k = i;
        i = m;
        i1 += 1;
        m = k;
        k = i;
        i = m;
      }
      else
      {
        int n;
        if (((NewPhotoListActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).a((String)localObject2) == 1)
        {
          localObject2 = ((NewPhotoListActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).a((String)localObject2);
          n = j;
          m = i;
          if (localObject2 != null)
          {
            localObject3 = new SendVideoActivity.SendVideoInfo();
            ((SendVideoActivity.SendVideoInfo)localObject3).fileSize = ((LocalMediaInfo)localObject2).fileSize;
            ((SendVideoActivity.SendVideoInfo)localObject3).duration = ((LocalMediaInfo)localObject2).mDuration;
            ((HashMap)localObject1).put(Integer.valueOf(k), localObject3);
            m = i + 1;
            n = j;
          }
        }
        for (;;)
        {
          i = k + 1;
          j = n;
          k = m;
          break;
          n = j + 1;
          m = i;
        }
      }
    }
    Object localObject2 = String.valueOf(j);
    Object localObject3 = String.valueOf(i);
    if (!((HashMap)localObject1).isEmpty()) {
      paramIntent.putExtra("PhotoConst.VIDEO_INFOS", (Serializable)localObject1);
    }
    for (i = 1;; i = 0)
    {
      if ((axdq.jdField_b_of_type_Long != 0L) && (System.currentTimeMillis() - axdq.jdField_b_of_type_Long < 300000L)) {}
      for (boolean bool = true;; bool = false)
      {
        if (QLog.isColorLevel()) {
          QLog.d("PhotoListActivity", 2, "upload video isConfirmed=" + bool + " allowUploadInXGTime=" + axdq.jdField_b_of_type_Long);
        }
        if ((!bbfj.b(BaseApplicationImpl.getContext())) || (bool) || (i == 0)) {
          break;
        }
        localObject1 = ((NewPhotoListActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).getResources().getString(2131719257);
        paramIntent = new PhotoListLogicDefault.1(this, paramBoolean, paramIntent, paramArrayList, i2, (String)localObject2, (String)localObject3);
        if (bcwb.a((Activity)this.jdField_a_of_type_MqqUtilWeakReference.get(), 4, new agsk(this, paramIntent))) {
          bbdj.a((Context)this.jdField_a_of_type_MqqUtilWeakReference.get(), 232, null, (String)localObject1, new agsl(this, paramIntent), new agsm(this)).show();
        }
        if (QLog.isColorLevel()) {
          QLog.i("PhotoListActivity", 2, "show shortvideo_mobile_send_confirm dialog");
        }
        return;
      }
      if (paramBoolean) {
        PhotoUtils.a((Activity)this.jdField_a_of_type_MqqUtilWeakReference.get(), paramIntent, paramArrayList, this.jdField_a_of_type_Agsb.jdField_b_of_type_JavaUtilHashMap, this.jdField_a_of_type_Agrz.jdField_c_of_type_Int, false);
      }
      for (;;)
      {
        axqy.b(null, "CliOper", "", "", "0X8009AB0", "0X8009AB0", i2, 0, (String)localObject2, (String)localObject3, "", "");
        return;
        PhotoUtils.a((Activity)this.jdField_a_of_type_MqqUtilWeakReference.get(), paramIntent, paramArrayList, this.jdField_a_of_type_Agrz.jdField_c_of_type_Int, this.jdField_a_of_type_Agsb.l);
      }
    }
  }
  
  protected void a(Message paramMessage)
  {
    super.a(paramMessage);
  }
  
  protected void a(View paramView)
  {
    bbbx.c();
    bbbx.a();
    paramView = PresendPicMgr.a();
    if (paramView != null) {
      paramView.a(1006);
    }
    paramView = ((NewPhotoListActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).getIntent();
    if (this.jdField_a_of_type_Agrz.jdField_a_of_type_JavaUtilArrayList != null) {}
    for (int i = this.jdField_a_of_type_Agrz.jdField_a_of_type_JavaUtilArrayList.size();; i = 0)
    {
      agqd.b(paramView, i);
      if (this.jdField_a_of_type_Agsb.t) {
        break;
      }
      if (this.jdField_a_of_type_Agrz.a()) {
        vtz.a().a(vtz.a().c());
      }
      ((NewPhotoListActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).finish();
      bbbx.a((Activity)this.jdField_a_of_type_MqqUtilWeakReference.get(), false, false);
      return;
    }
    paramView = ((NewPhotoListActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).getIntent();
    String str1 = paramView.getStringExtra("PhotoConst.INIT_ACTIVITY_CLASS_NAME");
    String str2 = paramView.getStringExtra("PhotoConst.INIT_ACTIVITY_PACKAGE_NAME");
    if (str1 == null)
    {
      bcql.a((Context)this.jdField_a_of_type_MqqUtilWeakReference.get(), "请设置INIT_ACTIVITY_CLASS_NAME ", 0).a();
      return;
    }
    paramView.setClassName(str2, str1);
    paramView.removeExtra("PhotoConst.PHOTO_PATHS");
    paramView.removeExtra("PhotoConst.SINGLE_PHOTO_PATH");
    paramView.addFlags(603979776);
    ((NewPhotoListActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).startActivity(paramView);
    ((NewPhotoListActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).finish();
    bbbx.a((Activity)this.jdField_a_of_type_MqqUtilWeakReference.get(), false, false);
  }
  
  public void a(View paramView, int paramInt, CheckBox paramCheckBox)
  {
    boolean bool2 = true;
    paramView = this.jdField_a_of_type_Agrz.jdField_a_of_type_JavaUtilArrayList;
    if (this.jdField_a_of_type_Agsb.jdField_c_of_type_Boolean) {}
    LocalMediaInfo localLocalMediaInfo;
    int i;
    Object localObject1;
    do
    {
      long l;
      do
      {
        return;
        if (QLog.isColorLevel()) {
          QLog.d("PhotoListActivity", 2, "current select count:" + paramView.size());
        }
        localLocalMediaInfo = ((NewPhotoListActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).jdField_a_of_type_Agrs.a(paramInt);
        i = localLocalMediaInfo.selectStatus;
        if ((i == 1) || (paramView.size() < this.jdField_a_of_type_Agrz.jdField_a_of_type_Int)) {
          break;
        }
        l = System.currentTimeMillis();
      } while (l - this.jdField_a_of_type_Agsb.jdField_b_of_type_Long < 1000L);
      bcql.a((Context)this.jdField_a_of_type_MqqUtilWeakReference.get(), a(localLocalMediaInfo), 0).b(((NewPhotoListActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).g);
      paramCheckBox.setChecked(false);
      this.jdField_a_of_type_Agsb.jdField_b_of_type_Long = l;
      k();
      return;
      if ((this.jdField_a_of_type_Agsb.jdField_h_of_type_Int == 9501) && (((NewPhotoListActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).getIntent().getBooleanExtra("PhotoConst.IS_SEND_FILESIZE_LIMIT", false)) && (i != 1))
      {
        localObject1 = paramView.iterator();
        for (l = 0L; ((Iterator)localObject1).hasNext(); l = bbdx.a((String)((Iterator)localObject1).next()) + l) {}
        if (bbdx.a(localLocalMediaInfo.path) + l > 52428800L)
        {
          bcql.a((Context)this.jdField_a_of_type_MqqUtilWeakReference.get(), "选择图片总大小不能超过50M", 0).b(((NewPhotoListActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).g);
          paramCheckBox.setChecked(false);
          return;
        }
      }
      if ((((NewPhotoListActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).getIntent().getBooleanExtra("PhotoConst.IS_SEND_GIF_SIZE_LIMIT", false)) && (((NewPhotoListActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).a(localLocalMediaInfo)) && (bbdx.a(localLocalMediaInfo.path) > 3145728L))
      {
        bcql.a((Context)this.jdField_a_of_type_MqqUtilWeakReference.get(), "图片文件过大", 0).b(((NewPhotoListActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).g);
        paramCheckBox.setChecked(false);
        return;
      }
    } while ((this.jdField_a_of_type_Agrz.a()) && (!bkpv.a((Activity)this.jdField_a_of_type_MqqUtilWeakReference.get(), localLocalMediaInfo)));
    label455:
    boolean bool1;
    label474:
    Object localObject2;
    if (i == 1)
    {
      i = 2;
      localLocalMediaInfo.selectStatus = i;
      if (localLocalMediaInfo.selectStatus != 1) {
        break label1096;
      }
      bool1 = true;
      paramCheckBox = localLocalMediaInfo.path;
      localObject1 = PresendPicMgr.a();
      if (!bool1) {
        break label1102;
      }
      localObject2 = agmm.a(localLocalMediaInfo.mMimeType);
      agsb localagsb;
      if ((this.jdField_a_of_type_Agsb.jdField_h_of_type_Boolean) && (localObject2 != null) && ("video".equals(localObject2[0])))
      {
        localagsb = this.jdField_a_of_type_Agsb;
        localagsb.jdField_d_of_type_Int += 1;
        if (this.jdField_a_of_type_Agsb.jdField_d_of_type_Int == 1) {
          this.jdField_a_of_type_Agsb.jdField_a_of_type_ComTencentMobileqqActivityPhotoLocalMediaInfo = localLocalMediaInfo;
        }
      }
      if ((!TextUtils.isEmpty(localLocalMediaInfo.mMimeType)) && ("image/gif".equals(localLocalMediaInfo.mMimeType)))
      {
        localagsb = this.jdField_a_of_type_Agsb;
        localagsb.jdField_e_of_type_Int += 1;
      }
      paramView.add(paramCheckBox);
      this.jdField_a_of_type_Agrz.jdField_b_of_type_JavaUtilArrayList.add(localLocalMediaInfo.position);
      if (this.jdField_a_of_type_Agrz.jdField_d_of_type_Boolean) {
        this.jdField_a_of_type_Agrz.jdField_a_of_type_JavaUtilHashMap.put(paramCheckBox, localLocalMediaInfo);
      }
      if ((localObject1 != null) && (localObject2 != null) && (localObject2[0] != null) && (!"video".equals(localObject2[0]))) {
        ((PresendPicMgr)localObject1).a(paramCheckBox, 1052, ((NewPhotoListActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).getIntent().getIntExtra("entrance", 0));
      }
      agqd.a(((NewPhotoListActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).getIntent(), "param_totalSelNum");
      paramView = ((NewPhotoListActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).getIntent();
      if (!paramView.hasExtra("param_initTime")) {
        paramView.putExtra("param_initTime", System.currentTimeMillis());
      }
      paramView = (LinkedHashMap)bbbx.jdField_b_of_type_JavaUtilHashMap.get(this.jdField_a_of_type_Agrz.jdField_c_of_type_JavaLangString);
      if (paramView != null) {
        break label1351;
      }
      paramView = new LinkedHashMap();
      bbbx.jdField_b_of_type_JavaUtilHashMap.put(this.jdField_a_of_type_Agrz.jdField_c_of_type_JavaLangString, paramView);
    }
    label1351:
    for (;;)
    {
      paramView.put(paramCheckBox, Integer.valueOf(((NewPhotoListActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).jdField_a_of_type_ComTencentWidgetGestureSelectGridView.getFirstVisiblePosition()));
      paramView = bbbx.jdField_c_of_type_JavaUtilHashMap;
      if (!paramView.containsKey(paramCheckBox)) {
        paramView.put(paramCheckBox, new Pair(this.jdField_a_of_type_Agrz.jdField_c_of_type_JavaLangString, this.jdField_a_of_type_Agrz.jdField_b_of_type_JavaLangString));
      }
      label874:
      if (this.jdField_a_of_type_Agsg != null) {
        this.jdField_a_of_type_Agsg.a(bool1, localLocalMediaInfo);
      }
      ((NewPhotoListActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).a(paramInt, bool1);
      paramView = (NewPhotoListActivity)this.jdField_a_of_type_MqqUtilWeakReference.get();
      if (!bool1) {}
      for (bool1 = bool2;; bool1 = false)
      {
        paramView.b(bool1);
        d();
        if (!this.jdField_a_of_type_Agrz.a()) {
          break;
        }
        if (vtz.a().a().isEmpty())
        {
          i = ((NewPhotoListActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).jdField_a_of_type_ComTencentWidgetGestureSelectGridView.getFirstVisiblePosition();
          paramView = ((NewPhotoListActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).jdField_a_of_type_ComTencentWidgetGestureSelectGridView.getChildAt(paramInt - i);
          if ((paramView != null) && (((NewPhotoListActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).jdField_a_of_type_ComTencentWidgetGestureSelectGridView.getHeight() - paramView.getY() < ((NewPhotoListActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).jdField_b_of_type_Int)) {
            ((NewPhotoListActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).jdField_a_of_type_ComTencentWidgetGestureSelectGridView.smoothScrollBy(vtz.jdField_a_of_type_Int, 500);
          }
        }
        vtz.a().b(this.jdField_a_of_type_Agrz.jdField_a_of_type_JavaUtilArrayList, this.jdField_a_of_type_Agrz.jdField_b_of_type_JavaUtilHashMap);
        return;
        i = 1;
        break label455;
        label1096:
        bool1 = false;
        break label474;
        label1102:
        localObject2 = agmm.a(localLocalMediaInfo.mMimeType);
        if ((this.jdField_a_of_type_Agsb.jdField_h_of_type_Boolean) && (localObject2 != null) && ("video".equals(localObject2[0])))
        {
          localObject2 = this.jdField_a_of_type_Agsb;
          ((agsb)localObject2).jdField_d_of_type_Int -= 1;
          if (this.jdField_a_of_type_Agsb.jdField_d_of_type_Int == 1) {
            this.jdField_a_of_type_Agsb.jdField_a_of_type_ComTencentMobileqqActivityPhotoLocalMediaInfo = localLocalMediaInfo;
          }
        }
        if ((!TextUtils.isEmpty(localLocalMediaInfo.mMimeType)) && ("image/gif".equals(localLocalMediaInfo.mMimeType)))
        {
          localObject2 = this.jdField_a_of_type_Agsb;
          ((agsb)localObject2).jdField_e_of_type_Int -= 1;
        }
        paramView.remove(paramCheckBox);
        this.jdField_a_of_type_Agrz.jdField_b_of_type_JavaUtilArrayList.remove(localLocalMediaInfo.position);
        if (this.jdField_a_of_type_Agrz.jdField_d_of_type_Boolean) {
          this.jdField_a_of_type_Agrz.jdField_a_of_type_JavaUtilHashMap.remove(paramCheckBox);
        }
        if (localObject1 != null) {
          ((PresendPicMgr)localObject1).b(paramCheckBox, 1013);
        }
        agqd.a(((NewPhotoListActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).getIntent(), "param_cancelSelNum");
        paramView = (HashMap)bbbx.jdField_b_of_type_JavaUtilHashMap.get(this.jdField_a_of_type_Agrz.jdField_c_of_type_JavaLangString);
        if (paramView != null) {
          paramView.remove(paramCheckBox);
        }
        paramView = bbbx.jdField_c_of_type_JavaUtilHashMap;
        if (!paramView.containsKey(paramCheckBox)) {
          break label874;
        }
        paramView.remove(paramCheckBox);
        break label874;
      }
    }
  }
  
  protected void a(View paramView, Bundle paramBundle, int paramInt, Intent paramIntent)
  {
    if (this.jdField_a_of_type_Agrz.jdField_a_of_type_JavaUtilArrayList.size() > 0)
    {
      paramView = ((NewPhotoListActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).getIntent();
      paramView.removeExtra("param_initTime");
      paramView.putStringArrayListExtra("PhotoConst.PHOTO_PATHS", this.jdField_a_of_type_Agrz.jdField_a_of_type_JavaUtilArrayList);
      axqy.b(null, "CliOper", "", "", "0x8004B39", "0x8004B39", 0, 0, "", "", "", "");
      paramView = paramIntent;
      if (paramIntent == null) {
        paramView = EditPicActivity.a((Activity)this.jdField_a_of_type_MqqUtilWeakReference.get(), (String)this.jdField_a_of_type_Agrz.jdField_a_of_type_JavaUtilArrayList.get(0), true, true, true, true, true, paramInt, 99, 5, paramBundle);
      }
      paramView.putExtra("key_enable_edit_title_bar", true);
      f(paramView);
      ((NewPhotoListActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).startActivity(paramView);
      ((NewPhotoListActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).jdField_a_of_type_AndroidWidgetButton.setClickable(false);
    }
  }
  
  protected void a(CompoundButton paramCompoundButton, boolean paramBoolean)
  {
    if (paramBoolean) {
      if (bbbx.a(this.jdField_a_of_type_Agrz.jdField_a_of_type_JavaUtilArrayList, this.jdField_a_of_type_Agrz.jdField_b_of_type_Int, this.jdField_a_of_type_Agrz.jdField_b_of_type_JavaUtilHashMap, this.jdField_a_of_type_Agsb.v, this.jdField_a_of_type_Agrz.jdField_a_of_type_JavaUtilHashMap) > 0)
      {
        bcql.a((Context)this.jdField_a_of_type_MqqUtilWeakReference.get(), ((NewPhotoListActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).getResources().getString(2131695113), 0).b(((NewPhotoListActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).getResources().getDimensionPixelSize(2131298865));
        this.jdField_a_of_type_Agrz.jdField_c_of_type_Int = 0;
        ((NewPhotoListActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).jdField_a_of_type_AndroidWidgetCheckBox.setChecked(false);
        ((NewPhotoListActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).jdField_b_of_type_AndroidWidgetTextView.setVisibility(4);
      }
    }
    for (;;)
    {
      if (!this.jdField_a_of_type_Agsb.o) {
        ((NewPhotoListActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
      }
      return;
      if (bbbx.a(this.jdField_a_of_type_Agrz.jdField_a_of_type_JavaUtilArrayList, this.jdField_a_of_type_Agrz.jdField_b_of_type_Long, this.jdField_a_of_type_Agrz.jdField_b_of_type_JavaUtilHashMap, this.jdField_a_of_type_Agsb.v, this.jdField_a_of_type_Agrz.jdField_a_of_type_JavaUtilHashMap) > 0)
      {
        bcql.a((Context)this.jdField_a_of_type_MqqUtilWeakReference.get(), ((NewPhotoListActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).getResources().getString(2131719589), 0).b(((NewPhotoListActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).getResources().getDimensionPixelSize(2131298865));
        bbbx.d();
      }
      ((NewPhotoListActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).jdField_a_of_type_AndroidWidgetCheckBox.setChecked(true);
      this.jdField_a_of_type_Agrz.jdField_c_of_type_Int = 2;
      bbbx.a(((NewPhotoListActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).jdField_b_of_type_AndroidWidgetTextView, this.jdField_a_of_type_Agrz.jdField_a_of_type_JavaUtilArrayList, this.jdField_a_of_type_Agrz.jdField_b_of_type_JavaUtilHashMap, this.jdField_a_of_type_Agsb.v, (Activity)this.jdField_a_of_type_MqqUtilWeakReference.get(), this.jdField_a_of_type_Agsb.jdField_b_of_type_JavaUtilHashMap, this.jdField_a_of_type_Agrz.jdField_a_of_type_JavaUtilHashMap);
      continue;
      this.jdField_a_of_type_Agrz.jdField_c_of_type_Int = 0;
      ((NewPhotoListActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).jdField_a_of_type_AndroidWidgetCheckBox.setChecked(false);
      ((NewPhotoListActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).jdField_b_of_type_AndroidWidgetTextView.setVisibility(4);
    }
  }
  
  public void a(SlideItemInfo paramSlideItemInfo)
  {
    Object localObject1 = ((NewPhotoListActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).jdField_a_of_type_Agrs;
    ArrayList localArrayList = this.jdField_a_of_type_Agrz.jdField_a_of_type_JavaUtilArrayList;
    Object localObject2;
    int i;
    if ((localObject1 != null) && (paramSlideItemInfo != null))
    {
      localObject2 = ((agrs)localObject1).a();
      i = 0;
      if (i >= ((List)localObject2).size()) {
        break label556;
      }
      if (!((LocalMediaInfo)((List)localObject2).get(i)).path.equals(paramSlideItemInfo.jdField_b_of_type_JavaLangString)) {
        break label399;
      }
    }
    for (;;)
    {
      if ((i >= 0) && (i < ((List)localObject2).size()))
      {
        paramSlideItemInfo = ((agrs)localObject1).a(i);
        paramSlideItemInfo.selectStatus = 2;
        localObject1 = paramSlideItemInfo.path;
        localObject2 = agmm.a(paramSlideItemInfo.mMimeType);
        if ((this.jdField_a_of_type_Agsb.jdField_h_of_type_Boolean) && (localObject2 != null) && ("video".equals(localObject2[0])))
        {
          localObject2 = this.jdField_a_of_type_Agsb;
          ((agsb)localObject2).jdField_d_of_type_Int -= 1;
          if (this.jdField_a_of_type_Agsb.jdField_d_of_type_Int == 1) {
            this.jdField_a_of_type_Agsb.jdField_a_of_type_ComTencentMobileqqActivityPhotoLocalMediaInfo = paramSlideItemInfo;
          }
        }
        if ((!TextUtils.isEmpty(paramSlideItemInfo.mMimeType)) && ("image/gif".equals(paramSlideItemInfo.mMimeType)))
        {
          localObject2 = this.jdField_a_of_type_Agsb;
          ((agsb)localObject2).jdField_e_of_type_Int -= 1;
        }
        this.jdField_a_of_type_Agrz.jdField_a_of_type_JavaUtilArrayList.remove(localObject1);
        this.jdField_a_of_type_Agrz.jdField_b_of_type_JavaUtilArrayList.remove(paramSlideItemInfo.position);
        if (this.jdField_a_of_type_Agrz.jdField_d_of_type_Boolean) {
          this.jdField_a_of_type_Agrz.jdField_a_of_type_JavaUtilHashMap.remove(localObject1);
        }
        agqd.a(((NewPhotoListActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).getIntent(), "param_cancelSelNum");
        localObject2 = (HashMap)bbbx.jdField_b_of_type_JavaUtilHashMap.get(this.jdField_a_of_type_Agrz.jdField_c_of_type_JavaLangString);
        if (localObject2 != null) {
          ((HashMap)localObject2).remove(localObject1);
        }
        localObject2 = bbbx.jdField_c_of_type_JavaUtilHashMap;
        if (((HashMap)localObject2).containsKey(localObject1)) {
          ((HashMap)localObject2).remove(localObject1);
        }
        if (this.jdField_a_of_type_Agsg != null) {
          this.jdField_a_of_type_Agsg.a(false, paramSlideItemInfo);
        }
        ((NewPhotoListActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).a(i, false);
        d();
        vtz.a().b(localArrayList, this.jdField_a_of_type_Agrz.jdField_b_of_type_JavaUtilHashMap);
      }
      label399:
      while (i != -1)
      {
        return;
        i += 1;
        break;
      }
      localArrayList.remove(paramSlideItemInfo.jdField_b_of_type_JavaLangString);
      if (this.jdField_a_of_type_Agrz.jdField_d_of_type_Boolean) {
        this.jdField_a_of_type_Agrz.jdField_a_of_type_JavaUtilHashMap.remove(paramSlideItemInfo.jdField_b_of_type_JavaLangString);
      }
      agqd.a(((NewPhotoListActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).getIntent(), "param_cancelSelNum");
      localObject1 = (HashMap)bbbx.jdField_b_of_type_JavaUtilHashMap.get(this.jdField_a_of_type_Agrz.jdField_c_of_type_JavaLangString);
      if (localObject1 != null) {
        ((HashMap)localObject1).remove(paramSlideItemInfo.jdField_b_of_type_JavaLangString);
      }
      localObject1 = bbbx.jdField_c_of_type_JavaUtilHashMap;
      if (((HashMap)localObject1).containsKey(paramSlideItemInfo.jdField_b_of_type_JavaLangString)) {
        ((HashMap)localObject1).remove(paramSlideItemInfo.jdField_b_of_type_JavaLangString);
      }
      ((NewPhotoListActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).g();
      d();
      vtz.a().b(localArrayList, this.jdField_a_of_type_Agrz.jdField_b_of_type_JavaUtilHashMap);
      return;
      label556:
      i = -1;
    }
  }
  
  protected void a(LocalMediaInfo paramLocalMediaInfo, int paramInt)
  {
    bbbx.a();
    String str = paramLocalMediaInfo.path;
    Intent localIntent = ((NewPhotoListActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).getIntent();
    localIntent.putExtra("ALBUM_NAME", this.jdField_a_of_type_Agrz.jdField_b_of_type_JavaLangString);
    localIntent.putExtra("ALBUM_ID", this.jdField_a_of_type_Agrz.jdField_c_of_type_JavaLangString);
    localIntent.putExtra("PhotoConst.IS_SINGLE_MODE", true);
    localIntent.putStringArrayListExtra("PhotoConst.PHOTO_PATHS", this.jdField_a_of_type_Agrz.jdField_a_of_type_JavaUtilArrayList);
    localIntent.putExtra("PhotoConst.SINGLE_PHOTO_PATH", str);
    localIntent.putExtra("media_info", paramLocalMediaInfo);
    if (localIntent.getBooleanExtra("PhotoConst.MULTI_PREVIEW_IN_SINGLE_MODE", false))
    {
      localIntent.putStringArrayListExtra("PhotoConst.PHOTO_PATHS", this.jdField_a_of_type_Agrz.jdField_c_of_type_JavaUtilArrayList);
      localIntent.putExtra("PhotoConst.CURRENT_SELECTED_INDEX", paramLocalMediaInfo.position);
    }
    if (this.jdField_a_of_type_Agsb.q)
    {
      paramLocalMediaInfo = bbbx.jdField_c_of_type_JavaUtilHashMap;
      if (!paramLocalMediaInfo.containsKey(str)) {
        paramLocalMediaInfo.put(str, new Pair(this.jdField_a_of_type_Agrz.jdField_c_of_type_JavaLangString, this.jdField_a_of_type_Agrz.jdField_b_of_type_JavaLangString));
      }
      ((NewPhotoListActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).b(str);
      PhotoUtils.a((Activity)this.jdField_a_of_type_MqqUtilWeakReference.get(), localIntent, this.jdField_a_of_type_Agrz.jdField_a_of_type_JavaUtilArrayList, 0, this.jdField_a_of_type_Agsb.l);
      return;
    }
    if (!this.jdField_a_of_type_Agsb.r)
    {
      localIntent.putExtra("PhotoConst.ALLOW_LOCK", false);
      localIntent.setClass((Context)this.jdField_a_of_type_MqqUtilWeakReference.get(), NewPhotoPreviewActivity.class);
      localIntent.putExtra("PasterConstants.pasters_data", this.jdField_a_of_type_Agsb.jdField_c_of_type_JavaUtilHashMap);
      localIntent.putExtra("FROM_WHERE", "FROM_PHOTO_LIST");
      localIntent.putExtra("PhotoConst.SOURCE_FROM", "FROM_SELECT_PHOTO");
      localIntent.addFlags(603979776);
      ((NewPhotoListActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).startActivity(localIntent);
      ((NewPhotoListActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).finish();
      bbbx.a((Activity)this.jdField_a_of_type_MqqUtilWeakReference.get(), true, true);
      return;
    }
    paramInt = localIntent.getIntExtra("Business_Origin", 0);
    if ((100 == paramInt) || (102 == paramInt) || (103 == paramInt)) {
      if (100 == paramInt)
      {
        int i = bbac.b((Activity)this.jdField_a_of_type_MqqUtilWeakReference.get());
        localIntent.putExtra("PhotoConst.CLIP_WIDTH", i);
        localIntent.putExtra("PhotoConst.CLIP_HEIGHT", i);
        localIntent.putExtra("PhotoConst.TARGET_WIDTH", 1080);
        localIntent.putExtra("PhotoConst.TARGET_HEIGHT", 1080);
        localIntent.putExtra("PhotoConst.TARGET_SAMPLE_SIZE", 1620);
        label476:
        localIntent.setClass((Context)this.jdField_a_of_type_MqqUtilWeakReference.get(), PhotoCropForPortraitActivity.class);
        localIntent.putExtra("PhotoConst.EDIT_MASK_SHAPE_TYPE", agqq.c(paramInt));
      }
    }
    for (;;)
    {
      bbbx.a(localIntent, this.jdField_a_of_type_Agrz.jdField_c_of_type_JavaLangString, str, this.jdField_a_of_type_Agsb.jdField_d_of_type_Boolean);
      localIntent.putExtra("PHOTOLIST_START_POSITION", ((NewPhotoListActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).jdField_a_of_type_ComTencentWidgetGestureSelectGridView.getFirstVisiblePosition());
      break;
      localIntent.putExtra("PhotoConst.IS_WITH_PENDANT", false);
      localIntent.putExtra("PhotoConst.TARGET_WIDTH", 640);
      localIntent.putExtra("PhotoConst.TARGET_HEIGHT", 640);
      break label476;
      localIntent.setClass((Context)this.jdField_a_of_type_MqqUtilWeakReference.get(), PhotoCropActivity.class);
    }
  }
  
  public void a(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    a(((NewPhotoListActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).jdField_a_of_type_Agrs.a(paramInt), paramInt);
  }
  
  public void a(String paramString)
  {
    Intent localIntent = ((NewPhotoListActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).getIntent();
    ArrayList localArrayList = this.jdField_a_of_type_Agrz.jdField_a_of_type_JavaUtilArrayList;
    HashMap localHashMap = this.jdField_a_of_type_Agrz.jdField_a_of_type_JavaUtilHashMap;
    localIntent.putExtra("ALBUM_NAME", this.jdField_a_of_type_Agrz.jdField_b_of_type_JavaLangString);
    localIntent.putExtra("ALBUM_ID", this.jdField_a_of_type_Agrz.jdField_c_of_type_JavaLangString);
    localIntent.putStringArrayListExtra("PhotoConst.PHOTO_PATHS", localArrayList);
    localIntent.putStringArrayListExtra("PhotoConst.SELECTED_PATHS", localArrayList);
    int j = localArrayList.size();
    Object localObject = new ArrayList(j);
    int i = 0;
    while (i < j)
    {
      ((ArrayList)localObject).add(Integer.valueOf(i));
      i += 1;
    }
    localIntent.putIntegerArrayListExtra("PhotoConst.SELECTED_INDEXS", (ArrayList)localObject);
    i = localArrayList.indexOf(paramString);
    if ((i > 0) && (i < ((NewPhotoListActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).jdField_a_of_type_Agrs.getCount()))
    {
      localObject = ((NewPhotoListActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).jdField_a_of_type_Agrs.a(i);
      if ((localObject != null) && (!localHashMap.containsKey(((LocalMediaInfo)localObject).path))) {
        localHashMap.put(((LocalMediaInfo)localObject).path, localObject);
      }
    }
    localIntent.putExtra("PeakConstants.selectedMediaInfoHashMap", localHashMap);
    localIntent.putExtra("PhotoConst.SHOW_ALBUM", false);
    localIntent.putExtra("FROM_WHERE", "FROM_PHOTO_LIST");
    agsb.jdField_a_of_type_Int = ((NewPhotoListActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).jdField_a_of_type_ComTencentWidgetGestureSelectGridView.getFirstVisiblePosition();
    localIntent.putExtra("PhotoConst.CURRENT_SELECTED_INDEX", localArrayList.indexOf(paramString));
    localIntent.setClass((Context)this.jdField_a_of_type_MqqUtilWeakReference.get(), NewPhotoPreviewActivity.class);
    localIntent.addFlags(603979776);
    c(localIntent);
    bbbx.a((Activity)this.jdField_a_of_type_MqqUtilWeakReference.get(), true, true);
  }
  
  protected void a(boolean paramBoolean, int paramInt1, int paramInt2)
  {
    if (this.jdField_a_of_type_Agsb.jdField_c_of_type_Boolean) {
      return;
    }
    if (this.jdField_a_of_type_Agrz.a())
    {
      if (vtz.a().a().isEmpty())
      {
        paramInt2 = ((NewPhotoListActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).jdField_a_of_type_ComTencentWidgetGestureSelectGridView.getFirstVisiblePosition();
        localObject = ((NewPhotoListActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).jdField_a_of_type_ComTencentWidgetGestureSelectGridView.getChildAt(paramInt1 - paramInt2);
        if ((localObject != null) && (((NewPhotoListActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).jdField_a_of_type_ComTencentWidgetGestureSelectGridView.getHeight() - ((View)localObject).getY() < ((NewPhotoListActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).jdField_b_of_type_Int)) {
          ((NewPhotoListActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).jdField_a_of_type_ComTencentWidgetGestureSelectGridView.smoothScrollBy(vtz.jdField_a_of_type_Int, 500);
        }
      }
      vtz.a().b(this.jdField_a_of_type_Agrz.jdField_a_of_type_JavaUtilArrayList, this.jdField_a_of_type_Agrz.jdField_b_of_type_JavaUtilHashMap);
    }
    Object localObject = PresendPicMgr.a();
    if (localObject != null)
    {
      Iterator localIterator = this.jdField_a_of_type_Agsb.jdField_a_of_type_JavaUtilHashSet.iterator();
      while (localIterator.hasNext())
      {
        String str = (String)localIterator.next();
        if (((NewPhotoListActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).a(str) != 1) {
          ((PresendPicMgr)localObject).a(str, 1052);
        }
      }
      localIterator = this.jdField_a_of_type_Agsb.jdField_b_of_type_JavaUtilHashSet.iterator();
      while (localIterator.hasNext()) {
        ((PresendPicMgr)localObject).b((String)localIterator.next(), 1013);
      }
    }
    this.jdField_a_of_type_Agsb.jdField_a_of_type_JavaUtilHashSet.clear();
    this.jdField_a_of_type_Agsb.jdField_b_of_type_JavaUtilHashSet.clear();
  }
  
  protected void a(boolean paramBoolean, Intent paramIntent)
  {
    bbbx.a();
    paramIntent.putExtra("PhotoConst.SHOW_ALBUM", false);
    ArrayList localArrayList = this.jdField_a_of_type_Agrz.jdField_a_of_type_JavaUtilArrayList;
    if (!paramBoolean)
    {
      paramIntent.putStringArrayListExtra("PhotoConst.PHOTO_PATHS", localArrayList);
      if ((localArrayList != null) && (localArrayList.size() > 0)) {
        axqy.b(null, "CliOper", "", this.jdField_a_of_type_Agrz.jdField_a_of_type_JavaLangString, "0X8004072", "0X8004072", 0, localArrayList.size(), 0, "", "", "", "");
      }
      if ((this.jdField_a_of_type_Agrz.jdField_c_of_type_JavaUtilHashMap == null) || (this.jdField_a_of_type_Agrz.jdField_c_of_type_JavaUtilHashMap.size() <= 0)) {
        break label353;
      }
      paramIntent.putExtra("PhotoConst.PHOTO_INFOS", this.jdField_a_of_type_Agrz.jdField_c_of_type_JavaUtilHashMap);
      paramIntent.putExtra("PhotoConst.PHOTO_PATHS_FROM_QZONEALBUM", paramIntent.getSerializableExtra("PhotoConst.PHOTO_PATHS_FROM_QZONEALBUM"));
      paramIntent.putExtra("PhotoConst.CURRENT_SELECTED_INDEX", 0);
      paramIntent.putExtra("PhotoConst.USE_URL_PATH", true);
      paramIntent.putExtra("PhotoConst.QZONE_ALBUM_FROM_AIO", paramIntent.getBooleanExtra("PhotoConst.QZONE_ALBUM_FROM_AIO", false));
    }
    for (;;)
    {
      if (this.jdField_a_of_type_Agrz.jdField_d_of_type_Boolean)
      {
        paramIntent.putExtra("PeakConstants.selectedMediaInfoHashMap", this.jdField_a_of_type_Agrz.jdField_a_of_type_JavaUtilHashMap);
        paramIntent.putExtra("PhotoConst.CURRENT_SELECTED_INDEX", 0);
      }
      paramIntent.putExtra("ALBUM_NAME", this.jdField_a_of_type_Agrz.jdField_b_of_type_JavaLangString);
      paramIntent.putExtra("ALBUM_ID", this.jdField_a_of_type_Agrz.jdField_c_of_type_JavaLangString);
      paramIntent.putExtra("FROM_WHERE", "FROM_PHOTO_LIST");
      paramIntent.putExtra("PhotoConst.CURRENT_QUALITY_TYPE", this.jdField_a_of_type_Agrz.jdField_c_of_type_Int);
      paramIntent.putExtra("PasterConstants.pasters_data", this.jdField_a_of_type_Agsb.jdField_c_of_type_JavaUtilHashMap);
      agsb.jdField_a_of_type_Int = ((NewPhotoListActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).jdField_a_of_type_ComTencentWidgetGestureSelectGridView.getFirstVisiblePosition();
      paramIntent.setClass((Context)this.jdField_a_of_type_MqqUtilWeakReference.get(), NewPhotoPreviewActivity.class);
      paramIntent.addFlags(603979776);
      c(paramIntent);
      bbbx.a((Activity)this.jdField_a_of_type_MqqUtilWeakReference.get(), true, true);
      return;
      paramIntent.putExtra("PhotoConst.SINGLE_PHOTO_PATH", this.jdField_a_of_type_Agsb.jdField_b_of_type_JavaLangString);
      break;
      label353:
      paramIntent.putExtra("PhotoConst.USE_URL_PATH", false);
    }
  }
  
  public boolean a()
  {
    return super.a();
  }
  
  protected boolean a(LocalMediaInfo paramLocalMediaInfo, boolean paramBoolean)
  {
    Object localObject1 = this.jdField_a_of_type_Agrz;
    Object localObject2 = agmm.a(paramLocalMediaInfo.mMimeType);
    if ((!this.jdField_a_of_type_Agsb.jdField_h_of_type_Boolean) && (localObject2 != null) && (!"image".equals(localObject2[0]))) {}
    long l;
    do
    {
      int i;
      do
      {
        return false;
        i = paramLocalMediaInfo.selectStatus;
      } while (((i == 1) && (paramBoolean)) || ((i == 2) && (!paramBoolean)));
      if ((i != 2) || (!paramBoolean) || (((agrz)localObject1).jdField_a_of_type_JavaUtilArrayList.size() < ((agrz)localObject1).jdField_a_of_type_Int)) {
        break;
      }
      l = System.currentTimeMillis();
    } while (l - this.jdField_a_of_type_Agsb.jdField_b_of_type_Long < 700L);
    bcql.a((Context)this.jdField_a_of_type_MqqUtilWeakReference.get(), a(paramLocalMediaInfo), 1000).b(((NewPhotoListActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).g);
    this.jdField_a_of_type_Agsb.jdField_b_of_type_Long = l;
    this.jdField_a_of_type_Agsb.k = true;
    k();
    return false;
    this.jdField_a_of_type_Agsb.k = false;
    String str = paramLocalMediaInfo.path;
    if (paramBoolean)
    {
      if ((this.jdField_a_of_type_Agsb.jdField_h_of_type_Boolean) && (localObject2 != null) && ("video".equals(localObject2[0])))
      {
        localObject2 = this.jdField_a_of_type_Agsb;
        ((agsb)localObject2).jdField_d_of_type_Int += 1;
        if (this.jdField_a_of_type_Agsb.jdField_d_of_type_Int == 1) {
          this.jdField_a_of_type_Agsb.jdField_a_of_type_ComTencentMobileqqActivityPhotoLocalMediaInfo = paramLocalMediaInfo;
        }
      }
      if ((!TextUtils.isEmpty(paramLocalMediaInfo.mMimeType)) && ("image/gif".equals(paramLocalMediaInfo.mMimeType)))
      {
        localObject2 = this.jdField_a_of_type_Agsb;
        ((agsb)localObject2).jdField_e_of_type_Int += 1;
      }
      ((agrz)localObject1).jdField_a_of_type_JavaUtilArrayList.add(str);
      ((agrz)localObject1).jdField_b_of_type_JavaUtilArrayList.add(paramLocalMediaInfo.position);
      if (this.jdField_a_of_type_Agrz.jdField_d_of_type_Boolean) {
        ((agrz)localObject1).jdField_a_of_type_JavaUtilHashMap.put(str, paramLocalMediaInfo);
      }
      if (this.jdField_a_of_type_Agsb.jdField_b_of_type_JavaUtilHashSet.contains(str)) {
        this.jdField_a_of_type_Agsb.jdField_b_of_type_JavaUtilHashSet.remove(str);
      }
      this.jdField_a_of_type_Agsb.jdField_a_of_type_JavaUtilHashSet.add(str);
      agqd.a(((NewPhotoListActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).getIntent(), "param_totalSelNum");
      localObject1 = ((NewPhotoListActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).getIntent();
      if (!((Intent)localObject1).hasExtra("param_initTime")) {
        ((Intent)localObject1).putExtra("param_initTime", System.currentTimeMillis());
      }
      paramLocalMediaInfo.selectStatus = 1;
      paramLocalMediaInfo = (LinkedHashMap)bbbx.jdField_b_of_type_JavaUtilHashMap.get(this.jdField_a_of_type_Agrz.jdField_c_of_type_JavaLangString);
      if (paramLocalMediaInfo != null) {
        break label865;
      }
      paramLocalMediaInfo = new LinkedHashMap();
      bbbx.jdField_b_of_type_JavaUtilHashMap.put(this.jdField_a_of_type_Agrz.jdField_c_of_type_JavaLangString, paramLocalMediaInfo);
    }
    label865:
    for (;;)
    {
      paramLocalMediaInfo.put(str, Integer.valueOf(((NewPhotoListActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).jdField_a_of_type_ComTencentWidgetGestureSelectGridView.getFirstVisiblePosition()));
      paramLocalMediaInfo = bbbx.jdField_c_of_type_JavaUtilHashMap;
      if (!paramLocalMediaInfo.containsKey(str)) {
        paramLocalMediaInfo.put(str, new Pair(this.jdField_a_of_type_Agrz.jdField_c_of_type_JavaLangString, this.jdField_a_of_type_Agrz.jdField_b_of_type_JavaLangString));
      }
      paramLocalMediaInfo = (NewPhotoListActivity)this.jdField_a_of_type_MqqUtilWeakReference.get();
      if (!paramBoolean) {}
      for (paramBoolean = true;; paramBoolean = false)
      {
        paramLocalMediaInfo.b(paramBoolean);
        return true;
        if ((this.jdField_a_of_type_Agsb.jdField_h_of_type_Boolean) && (localObject2 != null) && ("video".equals(localObject2[0])))
        {
          localObject2 = this.jdField_a_of_type_Agsb;
          ((agsb)localObject2).jdField_d_of_type_Int -= 1;
          if (this.jdField_a_of_type_Agsb.jdField_d_of_type_Int == 1) {
            this.jdField_a_of_type_Agsb.jdField_a_of_type_ComTencentMobileqqActivityPhotoLocalMediaInfo = paramLocalMediaInfo;
          }
        }
        if ((!TextUtils.isEmpty(paramLocalMediaInfo.mMimeType)) && ("image/gif".equals(paramLocalMediaInfo.mMimeType)))
        {
          localObject2 = this.jdField_a_of_type_Agsb;
          ((agsb)localObject2).jdField_e_of_type_Int -= 1;
        }
        ((agrz)localObject1).jdField_a_of_type_JavaUtilArrayList.remove(paramLocalMediaInfo.path);
        ((agrz)localObject1).jdField_b_of_type_JavaUtilArrayList.remove(paramLocalMediaInfo.position);
        if (this.jdField_a_of_type_Agrz.jdField_d_of_type_Boolean) {
          ((agrz)localObject1).jdField_a_of_type_JavaUtilHashMap.remove(str);
        }
        if (this.jdField_a_of_type_Agsb.jdField_a_of_type_JavaUtilHashSet.contains(paramLocalMediaInfo.path)) {
          this.jdField_a_of_type_Agsb.jdField_a_of_type_JavaUtilHashSet.remove(paramLocalMediaInfo.path);
        }
        for (;;)
        {
          paramLocalMediaInfo.selectStatus = 2;
          agqd.a(((NewPhotoListActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).getIntent(), "param_cancelSelNum");
          paramLocalMediaInfo = (HashMap)bbbx.jdField_b_of_type_JavaUtilHashMap.get(this.jdField_a_of_type_Agrz.jdField_c_of_type_JavaLangString);
          if (paramLocalMediaInfo != null) {
            paramLocalMediaInfo.remove(str);
          }
          paramLocalMediaInfo = bbbx.jdField_c_of_type_JavaUtilHashMap;
          if (!paramLocalMediaInfo.containsKey(str)) {
            break;
          }
          paramLocalMediaInfo.remove(str);
          break;
          this.jdField_a_of_type_Agsb.jdField_b_of_type_JavaUtilHashSet.add(paramLocalMediaInfo.path);
        }
      }
    }
  }
  
  boolean a(List<LocalMediaInfo> paramList)
  {
    boolean bool = false;
    int m = 0;
    int i;
    int k;
    int j;
    if (super.a(paramList)) {
      if (this.jdField_a_of_type_Agsb.jdField_b_of_type_Boolean)
      {
        this.jdField_a_of_type_Agsb.jdField_b_of_type_Boolean = false;
        if (this.jdField_a_of_type_Agsb.jdField_f_of_type_Int != -1) {
          break label500;
        }
        i = agsb.jdField_a_of_type_Int;
        if (i != -1) {
          break label527;
        }
        Object localObject = (LinkedHashMap)bbbx.jdField_b_of_type_JavaUtilHashMap.get(this.jdField_a_of_type_Agrz.jdField_c_of_type_JavaLangString);
        k = i;
        if (localObject != null)
        {
          j = ((LinkedHashMap)localObject).size();
          k = i;
          if (j > 0) {
            k = ((Integer)((LinkedHashMap)localObject).get(localObject.keySet().toArray()[(j - 1)])).intValue();
          }
        }
        j = k;
        if (k == -1)
        {
          j = k;
          if (this.jdField_a_of_type_Agsb.jdField_d_of_type_Boolean)
          {
            localObject = paramList.iterator();
            i = 0;
            label150:
            j = k;
            if (((Iterator)localObject).hasNext())
            {
              if (((LocalMediaInfo)((Iterator)localObject).next()).selectStatus != 3) {
                break label511;
              }
              j = i;
            }
          }
        }
        localObject = this.jdField_a_of_type_Agrz.jdField_a_of_type_JavaUtilArrayList;
        i = j;
        if (j == -1)
        {
          i = j;
          if (this.jdField_a_of_type_Agrz.jdField_c_of_type_JavaLangString.equals("$RecentAlbumId"))
          {
            i = j;
            if (!((ArrayList)localObject).isEmpty())
            {
              int n = paramList.size();
              localObject = (String)((ArrayList)localObject).get(((ArrayList)localObject).size() - 1);
              k = 0;
              label253:
              i = j;
              if (k < n)
              {
                if (!((String)localObject).equals(((LocalMediaInfo)paramList.get(k)).path)) {
                  break label518;
                }
                i = k;
              }
            }
          }
        }
        label287:
        j = ((NewPhotoListActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).jdField_a_of_type_Agrs.getCount();
        if (j != 0) {
          break label534;
        }
        j = m;
        label311:
        if (!this.jdField_a_of_type_Agrz.a()) {
          break label560;
        }
        if ((this.jdField_a_of_type_Agrz.jdField_a_of_type_JavaUtilArrayList != null) && (this.jdField_a_of_type_Agrz.jdField_a_of_type_JavaUtilArrayList.size() > 0))
        {
          paramList = (String)this.jdField_a_of_type_Agrz.jdField_a_of_type_JavaUtilArrayList.get(this.jdField_a_of_type_Agrz.jdField_a_of_type_JavaUtilArrayList.size() - 1);
          i = this.jdField_a_of_type_Agrz.jdField_c_of_type_JavaUtilArrayList.indexOf(paramList);
          if ((i >= 0) && (i < ((NewPhotoListActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).jdField_a_of_type_ComTencentWidgetGestureSelectGridView.a().getCount())) {
            ((NewPhotoListActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).jdField_a_of_type_ComTencentWidgetGestureSelectGridView.post(new PhotoListLogicDefault.7(this, j));
          }
        }
      }
    }
    for (;;)
    {
      if (this.jdField_a_of_type_Agrz.a())
      {
        ((NewPhotoListActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).a(this.jdField_a_of_type_Agrz.jdField_a_of_type_JavaUtilArrayList, this.jdField_a_of_type_Agrz.jdField_a_of_type_JavaUtilHashMap);
        vtz.a().b(this.jdField_a_of_type_Agrz.jdField_a_of_type_JavaUtilArrayList, this.jdField_a_of_type_Agrz.jdField_b_of_type_JavaUtilHashMap);
      }
      bool = true;
      return bool;
      label500:
      i = this.jdField_a_of_type_Agsb.jdField_f_of_type_Int;
      break;
      label511:
      i += 1;
      break label150;
      label518:
      k += 1;
      break label253;
      label527:
      agsb.jdField_a_of_type_Int = -1;
      break label287;
      label534:
      if (i > j - 1)
      {
        j -= 1;
        break label311;
      }
      j = m;
      if (i < 0) {
        break label311;
      }
      j = i;
      break label311;
      label560:
      ((NewPhotoListActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).jdField_a_of_type_ComTencentWidgetGestureSelectGridView.post(new PhotoListLogicDefault.8(this, j));
    }
  }
  
  public View b(int paramInt, View paramView, ViewGroup paramViewGroup, agrt paramagrt, agrq paramagrq)
  {
    return super.b(paramInt, paramView, paramViewGroup, paramagrt, paramagrq);
  }
  
  protected void b(Intent paramIntent)
  {
    super.b(paramIntent);
    paramIntent.putExtra("PhotoConst.CURRENT_QUALITY_TYPE", this.jdField_a_of_type_Agrz.jdField_c_of_type_Int);
    paramIntent.putExtra("PhotoConst.IS_SHOW_QZONE_ALBUM", this.jdField_a_of_type_Agrz.jdField_c_of_type_Boolean);
    paramIntent.putExtra("PhotoConst.PHOTO_INFOS", this.jdField_a_of_type_Agrz.jdField_c_of_type_JavaUtilHashMap);
    paramIntent.putExtra("peak.myUin", this.jdField_a_of_type_Agrz.jdField_a_of_type_JavaLangString);
  }
  
  protected void b(View paramView)
  {
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
    if (paramView.fileSize > this.jdField_a_of_type_Agrz.jdField_b_of_type_Long)
    {
      paramAdapterView = bbdj.a((Activity)this.jdField_a_of_type_MqqUtilWeakReference.get(), "你选择的视频文件过大，无法发送。");
      paramAdapterView.setPositiveButton(2131694794, new bbdt());
      paramAdapterView.show();
      return;
    }
    Object localObject1 = bbbx.jdField_c_of_type_JavaUtilHashMap;
    Object localObject2;
    if (!((HashMap)localObject1).containsKey(paramView.path))
    {
      localObject2 = new Pair(this.jdField_a_of_type_Agrz.jdField_c_of_type_JavaLangString, this.jdField_a_of_type_Agrz.jdField_b_of_type_JavaLangString);
      ((HashMap)localObject1).put(paramView.path, localObject2);
    }
    ((NewPhotoListActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).b(paramView.path);
    if (!this.jdField_a_of_type_Agsb.m)
    {
      paramAdapterView.putExtra("file_send_path", paramView.path);
      paramAdapterView.putExtra("PhotoConst.IS_VIDEO_SELECTED", true);
      paramAdapterView.putExtra("PhotoConst.VIDEO_SIZE", paramView.fileSize);
      paramAdapterView.putExtra("file_send_duration", paramView.mDuration);
      paramAdapterView.putExtra("file_width", paramView.mediaWidth);
      paramAdapterView.putExtra("file_height", paramView.mediaHeight);
      paramAdapterView.putExtra("media_info", paramView);
      localObject1 = new ArrayList();
      ((ArrayList)localObject1).add(paramView.path);
      PhotoUtils.a((Activity)this.jdField_a_of_type_MqqUtilWeakReference.get(), paramAdapterView, (ArrayList)localObject1, 2, false);
      return;
    }
    if (!this.jdField_a_of_type_Agsb.jdField_c_of_type_Boolean)
    {
      paramView = ((NewPhotoListActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).getIntent();
      paramView.putExtra("ALBUM_NAME", this.jdField_a_of_type_Agrz.jdField_b_of_type_JavaLangString);
      paramView.putExtra("ALBUM_ID", this.jdField_a_of_type_Agrz.jdField_c_of_type_JavaLangString);
      localObject1 = ((NewPhotoListActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).jdField_a_of_type_Agrs.a(paramInt);
      paramView.putExtra("PhotoConst.CURRENT_SELECTED_INDEX", ((LocalMediaInfo)localObject1).position);
      paramView.putStringArrayListExtra("PhotoConst.SELECTED_PATHS", this.jdField_a_of_type_Agrz.jdField_a_of_type_JavaUtilArrayList);
      paramView.putIntegerArrayListExtra("PhotoConst.SELECTED_INDEXS", this.jdField_a_of_type_Agrz.jdField_b_of_type_JavaUtilArrayList);
      paramView.putExtra("FROM_WHERE", "FROM_PHOTO_LIST");
      paramView.putExtra("PhotoConst.CURRENT_QUALITY_TYPE", this.jdField_a_of_type_Agrz.jdField_c_of_type_Int);
      paramView.putExtra("PhotoConst.SHOW_ALBUM", true);
      paramView.putExtra("PhotoConst.SHOW_MAGIC_USE_PASTER", this.jdField_a_of_type_Agsb.p);
      paramView.putExtra("PasterConstants.paster_id", this.jdField_a_of_type_Agsb.jdField_c_of_type_JavaLangString);
      paramView.putExtra("PasterConstants.paster_cate_id", this.jdField_a_of_type_Agsb.jdField_d_of_type_JavaLangString);
      agsb.jdField_a_of_type_Int = ((NewPhotoListActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).jdField_a_of_type_ComTencentWidgetGestureSelectGridView.getFirstVisiblePosition();
      localObject2 = this.jdField_a_of_type_Agrz.jdField_a_of_type_JavaUtilHashMap;
      if (!((HashMap)localObject2).containsKey(((LocalMediaInfo)localObject1).path)) {
        ((HashMap)localObject2).put(((LocalMediaInfo)localObject1).path, localObject1);
      }
      paramView.putExtra("PeakConstants.selectedMediaInfoHashMap", (Serializable)localObject2);
      paramView.putExtra("PasterConstants.pasters_data", this.jdField_a_of_type_Agsb.jdField_c_of_type_JavaUtilHashMap);
      paramView.setClass((Context)this.jdField_a_of_type_MqqUtilWeakReference.get(), NewPhotoPreviewActivity.class);
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
        ((NewPhotoListActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).startActivity(paramView);
        ((NewPhotoListActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).finish();
      }
    }
    localObject1 = new Intent((Context)this.jdField_a_of_type_MqqUtilWeakReference.get(), ShortVideoPreviewActivity.class);
    ((Intent)localObject1).putExtras(paramAdapterView);
    ((Intent)localObject1).putExtra("file_send_path", paramView.path);
    ((Intent)localObject1).putExtra("file_send_size", paramView.fileSize);
    ((Intent)localObject1).putExtra("file_send_duration", paramView.mDuration);
    ((Intent)localObject1).putExtra("file_width", paramView.mediaWidth);
    ((Intent)localObject1).putExtra("file_height", paramView.mediaHeight);
    ((Intent)localObject1).putExtra("uin", this.jdField_a_of_type_Agsb.jdField_f_of_type_JavaLangString);
    ((Intent)localObject1).putExtra("uintype", this.jdField_a_of_type_Agsb.jdField_h_of_type_Int);
    ((Intent)localObject1).putExtra("file_source", "album");
    ((Intent)localObject1).putExtra("is_from_system_media", paramView.isSystemMeidaStore);
    if (this.jdField_a_of_type_Agsb.jdField_h_of_type_Boolean)
    {
      ((Intent)localObject1).putExtra("PhotoConst.IS_SUPPORT_VIDEO_CHECKBOX", true);
      ((Intent)localObject1).putExtra("PhotoConst.PHOTO_PATHS", this.jdField_a_of_type_Agrz.jdField_a_of_type_JavaUtilArrayList);
    }
    ((NewPhotoListActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).startActivityForResult((Intent)localObject1, 17);
  }
  
  protected void c()
  {
    Object localObject = ((NewPhotoListActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).jdField_a_of_type_AndroidViewView;
    int i;
    if ((this.jdField_a_of_type_Agsb.jdField_c_of_type_Boolean) || (this.jdField_a_of_type_Agsb.jdField_b_of_type_Int == 2) || (this.jdField_a_of_type_Agrz.a()))
    {
      i = 8;
      ((View)localObject).setVisibility(i);
      ((NewPhotoListActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).jdField_b_of_type_AndroidWidgetButton.setOnClickListener((View.OnClickListener)this.jdField_a_of_type_MqqUtilWeakReference.get());
      ((NewPhotoListActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).c.setOnClickListener((View.OnClickListener)this.jdField_a_of_type_MqqUtilWeakReference.get());
      if (!this.jdField_a_of_type_Agsb.p) {
        break label335;
      }
      ((NewPhotoListActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).jdField_a_of_type_AndroidWidgetButton.setVisibility(0);
      ((NewPhotoListActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).jdField_a_of_type_AndroidWidgetButton.setOnClickListener((View.OnClickListener)this.jdField_a_of_type_MqqUtilWeakReference.get());
    }
    for (;;)
    {
      if (this.jdField_a_of_type_Agsb.n) {
        ((NewPhotoListActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).jdField_a_of_type_AndroidWidgetCheckBox.setOnCheckedChangeListener((CompoundButton.OnCheckedChangeListener)this.jdField_a_of_type_MqqUtilWeakReference.get());
      }
      d();
      if (this.jdField_a_of_type_Agrz.a())
      {
        this.jdField_a_of_type_Agsb.jdField_a_of_type_Vud = new vud((Activity)this.jdField_a_of_type_MqqUtilWeakReference.get(), this);
        vtz.a().a(this.jdField_a_of_type_Agsb.jdField_a_of_type_Vud);
        vtz.a().a((Activity)this.jdField_a_of_type_MqqUtilWeakReference.get());
        l();
        if (((NewPhotoListActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).getIntent().getBooleanExtra("report_first_exposure", true))
        {
          localObject = (vug)QQStoryContext.a().getBusinessHandler(1);
          if (localObject != null) {
            ((vug)localObject).a();
          }
          ((NewPhotoListActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).getIntent().putExtra("report_first_exposure", false);
        }
      }
      return;
      i = 0;
      break;
      label335:
      ((NewPhotoListActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).jdField_a_of_type_AndroidWidgetButton.setVisibility(8);
    }
  }
  
  protected void c(Intent paramIntent)
  {
    super.c(paramIntent);
  }
  
  protected void c(View paramView)
  {
    ((NewPhotoListActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).c.setClickable(false);
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
    if (((NewPhotoListActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).getIntent().getBooleanExtra("PhotoConst.IS_SEND_FILESIZE_LIMIT", false))
    {
      paramView = this.jdField_a_of_type_Agrz.jdField_a_of_type_JavaUtilArrayList.iterator();
      for (long l = 0L; paramView.hasNext(); l = bbdx.a((String)paramView.next()) + l) {}
      if (apug.a())
      {
        aptt.a((Context)this.jdField_a_of_type_MqqUtilWeakReference.get(), 2131692673, 2131692678, new agsn(this));
        return;
      }
    }
    h();
  }
  
  public void c(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    super.c(paramAdapterView, paramView, paramInt, paramLong);
  }
  
  protected void d()
  {
    super.d();
    ArrayList localArrayList = this.jdField_a_of_type_Agrz.jdField_a_of_type_JavaUtilArrayList;
    int i;
    if (localArrayList.size() > 0)
    {
      i = 1;
      if (QLog.isColorLevel()) {
        QLog.d("_photo", 2, "updateButton selectedPhotoList.size()=" + localArrayList.size());
      }
      if (i == 0)
      {
        ((NewPhotoListActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).jdField_a_of_type_AndroidWidgetCheckBox.setChecked(false);
        ((NewPhotoListActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).jdField_a_of_type_AndroidWidgetCheckBox.setEnabled(false);
        ((NewPhotoListActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).jdField_a_of_type_AndroidWidgetTextView.setEnabled(false);
        ((NewPhotoListActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).jdField_b_of_type_AndroidWidgetTextView.setEnabled(false);
      }
      if (!this.jdField_a_of_type_Agsb.p) {
        break label422;
      }
      if ((localArrayList.size() != 1) || ((this.jdField_a_of_type_Agrz.jdField_c_of_type_JavaUtilHashMap != null) && (this.jdField_a_of_type_Agrz.jdField_c_of_type_JavaUtilHashMap.size() > 0)) || (((NewPhotoListActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).a((String)localArrayList.get(0)) != 0)) {
        break label402;
      }
      ((NewPhotoListActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).jdField_a_of_type_AndroidWidgetButton.setEnabled(true);
    }
    for (;;)
    {
      ((NewPhotoListActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).jdField_a_of_type_AndroidWidgetCheckBox.setVisibility(8);
      ((NewPhotoListActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
      ((NewPhotoListActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
      if (this.jdField_a_of_type_Agsb.n)
      {
        ((NewPhotoListActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).jdField_a_of_type_AndroidWidgetCheckBox.setVisibility(0);
        ((NewPhotoListActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
        if (i != 0)
        {
          ((NewPhotoListActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).jdField_a_of_type_AndroidWidgetCheckBox.setEnabled(true);
          ((NewPhotoListActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).jdField_a_of_type_AndroidWidgetTextView.setEnabled(true);
          ((NewPhotoListActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).jdField_b_of_type_AndroidWidgetTextView.setEnabled(true);
        }
      }
      j();
      if (!this.jdField_a_of_type_Agsb.o) {
        ((NewPhotoListActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
      }
      return;
      i = 0;
      break;
      label402:
      ((NewPhotoListActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).jdField_a_of_type_AndroidWidgetButton.setEnabled(false);
      continue;
      label422:
      ((NewPhotoListActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).jdField_a_of_type_AndroidWidgetButton.setVisibility(8);
    }
  }
  
  protected void d(Intent paramIntent)
  {
    super.d(paramIntent);
  }
  
  protected void e()
  {
    super.e();
  }
  
  protected void e(Intent paramIntent)
  {
    super.e(paramIntent);
  }
  
  protected void f()
  {
    super.f();
    amkf.a(BaseApplicationImpl.getContext(), 2, false);
    if (this.jdField_a_of_type_Agsb.g == 100016) {
      if (!((NewPhotoListActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).getIntent().getBooleanExtra("FROM_QZONR_NO_FINISH", false)) {
        ((NewPhotoListActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).finish();
      }
    }
    do
    {
      return;
      ((NewPhotoListActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).getIntent().removeExtra("FROM_QZONR_NO_FINISH");
      this.jdField_a_of_type_Agsb.g = 0;
      if (((NewPhotoListActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).jdField_a_of_type_AndroidWidgetButton != null) {
        ((NewPhotoListActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).jdField_a_of_type_AndroidWidgetButton.setClickable(true);
      }
    } while (!this.jdField_a_of_type_Agrz.a());
    vtz.a().c();
    vtz.a().a(this.jdField_a_of_type_Agsb.jdField_a_of_type_Vud);
  }
  
  public void f(Intent paramIntent)
  {
    if (this.jdField_a_of_type_Agsb.w)
    {
      paramIntent.putExtra("ReceiptMsgManager.EXTRA_KEY_IS_RECEIPT", true);
      paramIntent.putExtra("session_info", ((NewPhotoListActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).getIntent().getParcelableExtra("session_info"));
    }
  }
  
  void g()
  {
    if (this.jdField_a_of_type_Agrz.jdField_c_of_type_Boolean) {
      BaseApplicationImpl.getApplication().getRuntime().unRegistObserver(NewPhotoListActivity.jdField_a_of_type_Agru);
    }
    if (this.jdField_a_of_type_Agrz.a()) {
      vtz.a().f();
    }
    super.g();
  }
  
  protected void h()
  {
    if (this.jdField_a_of_type_Agrz.jdField_c_of_type_JavaLangString.equals("$RecentAlbumId")) {
      axrn.a((Context)this.jdField_a_of_type_MqqUtilWeakReference.get()).a(null, "sendAlbumRecent", true, 0L, 0L, null, "");
    }
    PresendPicMgr localPresendPicMgr;
    for (;;)
    {
      localPresendPicMgr = PresendPicMgr.a();
      if ((!this.jdField_a_of_type_Agsb.p) || ((TextUtils.isEmpty(this.jdField_a_of_type_Agsb.jdField_c_of_type_JavaLangString)) && (TextUtils.isEmpty(this.jdField_a_of_type_Agsb.jdField_d_of_type_JavaLangString)))) {
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
      agqd.a(((NewPhotoListActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).getIntent(), this.jdField_a_of_type_Agrz.jdField_a_of_type_JavaUtilArrayList.size());
      agqd.a(((NewPhotoListActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).getIntent(), this.jdField_a_of_type_Agrz.jdField_a_of_type_JavaUtilArrayList.size(), this.jdField_a_of_type_Agrz.jdField_c_of_type_Int);
    }
    Intent localIntent = ((NewPhotoListActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).getIntent();
    if (this.jdField_a_of_type_Agrz.jdField_c_of_type_Int == 2)
    {
      if (localPresendPicMgr != null)
      {
        localPresendPicMgr.a(1008);
        localPresendPicMgr.a();
      }
      axqy.b(null, "CliOper", "", "", "0X8005148", "0X8005148", 0, 0, "", "", "", "");
    }
    for (;;)
    {
      localIntent.getStringExtra("PhotoConst.PLUGIN_APK");
      localIntent.getStringExtra("PhotoConst.INIT_ACTIVITY_CLASS_NAME");
      if (this.jdField_a_of_type_Agrz.jdField_d_of_type_Boolean) {
        localIntent.putExtra("PeakConstants.selectedMediaInfoHashMap", this.jdField_a_of_type_Agrz.jdField_a_of_type_JavaUtilHashMap);
      }
      if (this.jdField_a_of_type_Agrz.jdField_a_of_type_JavaUtilArrayList != null) {
        ahvx.a(this.jdField_a_of_type_Agrz.jdField_a_of_type_JavaUtilArrayList);
      }
      f(localIntent);
      a(localIntent, false, this.jdField_a_of_type_Agrz.jdField_a_of_type_JavaUtilArrayList);
      return;
      if ((localPresendPicMgr != null) && (!this.jdField_a_of_type_Agsb.w) && (!localIntent.getBooleanExtra("PhotoConst.SEND_NO_PRESEND", false))) {
        localPresendPicMgr.a(localIntent);
      }
    }
  }
  
  protected void i()
  {
    PhotoUtils.a((Activity)this.jdField_a_of_type_MqqUtilWeakReference.get(), ((NewPhotoListActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).getIntent(), this.jdField_a_of_type_Agrz.jdField_a_of_type_JavaUtilArrayList, this.jdField_a_of_type_Agrz.jdField_c_of_type_Int, this.jdField_a_of_type_Agsb.l);
  }
  
  public void j()
  {
    agrz localagrz = this.jdField_a_of_type_Agrz;
    switch (localagrz.jdField_c_of_type_Int)
    {
    case 1: 
    default: 
      return;
    case 0: 
      ((NewPhotoListActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).jdField_a_of_type_AndroidWidgetCheckBox.setChecked(false);
      return;
    }
    bbbx.a(((NewPhotoListActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).jdField_b_of_type_AndroidWidgetTextView, localagrz.jdField_a_of_type_JavaUtilArrayList, localagrz.jdField_b_of_type_JavaUtilHashMap, this.jdField_a_of_type_Agsb.v, (Activity)this.jdField_a_of_type_MqqUtilWeakReference.get(), this.jdField_a_of_type_Agsb.jdField_b_of_type_JavaUtilHashMap, localagrz.jdField_a_of_type_JavaUtilHashMap);
    ((NewPhotoListActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).jdField_a_of_type_AndroidWidgetCheckBox.setChecked(true);
  }
  
  public void k()
  {
    if (this.jdField_a_of_type_Agsb.w) {
      axqy.b(null, "CliOper", "", "", "0x80083EC", "0x80083EC", 0, 0, "", "", "", "");
    }
  }
  
  void l()
  {
    Object localObject = vtz.a().a();
    if (this.jdField_a_of_type_Agsb.x) {
      vtz.a().b((List)localObject);
    }
    localObject = ((List)localObject).iterator();
    while (((Iterator)localObject).hasNext())
    {
      SlideItemInfo localSlideItemInfo = (SlideItemInfo)((Iterator)localObject).next();
      if (localSlideItemInfo != null)
      {
        if (!this.jdField_a_of_type_Agrz.jdField_a_of_type_JavaUtilArrayList.contains(localSlideItemInfo.jdField_b_of_type_JavaLangString)) {
          this.jdField_a_of_type_Agrz.jdField_a_of_type_JavaUtilArrayList.add(localSlideItemInfo.jdField_b_of_type_JavaLangString);
        }
        if (!this.jdField_a_of_type_Agrz.jdField_b_of_type_JavaUtilArrayList.contains(localSlideItemInfo.jdField_a_of_type_ComTencentMobileqqActivityPhotoLocalMediaInfo.position)) {
          this.jdField_a_of_type_Agrz.jdField_b_of_type_JavaUtilArrayList.add(localSlideItemInfo.jdField_a_of_type_ComTencentMobileqqActivityPhotoLocalMediaInfo.position);
        }
        this.jdField_a_of_type_Agrz.jdField_a_of_type_JavaUtilHashMap.put(localSlideItemInfo.jdField_b_of_type_JavaLangString, localSlideItemInfo.jdField_a_of_type_ComTencentMobileqqActivityPhotoLocalMediaInfo);
      }
    }
    if (this.jdField_a_of_type_Agrz.jdField_a_of_type_JavaUtilArrayList.size() > 0) {
      vtz.a().a(this.jdField_a_of_type_Agrz.jdField_a_of_type_JavaUtilArrayList, this.jdField_a_of_type_Agrz.jdField_b_of_type_JavaUtilHashMap, false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     agsj
 * JD-Core Version:    0.7.0.1
 */