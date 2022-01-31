import NS_MOBILE_OPERATION.PicInfo;
import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Resources;
import android.graphics.Rect;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.Window;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.biz.qqstory.takevideo.slideshow.SlideItemInfo;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.component.media.image.ImageManager;
import com.tencent.component.network.utils.NetworkUtils;
import com.tencent.image.QQLiveImage;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.photo.DragGallery;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.activity.photo.PhotoSendParams;
import com.tencent.mobileqq.activity.photo.PhotoUtils;
import com.tencent.mobileqq.activity.photo.album.NewPhotoListActivity;
import com.tencent.mobileqq.activity.photo.album.NewPhotoPreviewActivity;
import com.tencent.mobileqq.activity.photo.album.PhotoPreviewLogicDefault.5;
import com.tencent.mobileqq.activity.photo.album.PhotoPreviewLogicDefault.9;
import com.tencent.mobileqq.activity.shortvideo.SendVideoActivity.SendVideoInfo;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.pic.PresendPicMgr;
import com.tencent.mobileqq.widget.NumberCheckBox;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.AdapterView;
import com.tencent.widget.BubblePopupWindow;
import com.tencent.widget.DragView;
import com.tencent.widget.HorizontalListView;
import cooperation.qzone.report.lp.LpReportInfo_pf00064;
import dov.com.tencent.biz.qqstory.takevideo.EditPicActivity;
import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import mqq.app.AppRuntime;
import mqq.util.WeakReference;

public class agtc
  extends agsw
  implements agst, agsu, vui
{
  public agsr a;
  
  protected agtc(NewPhotoPreviewActivity paramNewPhotoPreviewActivity)
  {
    super(paramNewPhotoPreviewActivity);
    this.jdField_a_of_type_Agst = this;
    this.jdField_a_of_type_Agsu = this;
    this.a = new agsr();
    this.jdField_a_of_type_Agsr = ((agsr)this.a);
  }
  
  public static agss a(NewPhotoPreviewActivity paramNewPhotoPreviewActivity)
  {
    if ((jdField_a_of_type_Agss == null) || (jdField_a_of_type_Agss.jdField_a_of_type_MqqUtilWeakReference.get() != paramNewPhotoPreviewActivity)) {}
    try
    {
      if ((jdField_a_of_type_Agss == null) || (jdField_a_of_type_Agss.jdField_a_of_type_MqqUtilWeakReference.get() != paramNewPhotoPreviewActivity)) {
        jdField_a_of_type_Agss = new agtc(paramNewPhotoPreviewActivity);
      }
      return jdField_a_of_type_Agss;
    }
    finally {}
  }
  
  private void i()
  {
    ((NewPhotoPreviewActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).jdField_a_of_type_Boolean = false;
    ((NewPhotoPreviewActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)((NewPhotoPreviewActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).findViewById(2131363297));
    ((NewPhotoPreviewActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)((NewPhotoPreviewActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).findViewById(2131363295));
    if (this.jdField_a_of_type_Agsb.a()) {
      ((NewPhotoPreviewActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).jdField_a_of_type_Boolean = bkur.a(((NewPhotoPreviewActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).jdField_a_of_type_AndroidWidgetLinearLayout, ((NewPhotoPreviewActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).jdField_a_of_type_AndroidWidgetRelativeLayout, 0);
    }
    while (((NewPhotoPreviewActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).jdField_a_of_type_AndroidWidgetLinearLayout == null) {
      return;
    }
    ViewGroup.LayoutParams localLayoutParams = ((NewPhotoPreviewActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).jdField_a_of_type_AndroidWidgetLinearLayout.getLayoutParams();
    localLayoutParams.height = bkur.jdField_a_of_type_Int;
    ((NewPhotoPreviewActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).jdField_a_of_type_AndroidWidgetLinearLayout.setLayoutParams(localLayoutParams);
    ((NewPhotoPreviewActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(0);
    ((NewPhotoPreviewActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).jdField_a_of_type_Boolean = true;
  }
  
  public View a(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    if (QLog.isColorLevel()) {
      QLog.d("PhotoPreviewActivity", 2, " getView position=" + paramInt);
    }
    paramView = super.a(paramInt, paramView, paramViewGroup);
    paramViewGroup = ((NewPhotoPreviewActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).jdField_a_of_type_Agry.a(paramInt);
    if (((NewPhotoPreviewActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).a(paramViewGroup) == 1) {}
    for (int i = 1; i != 0; i = 0)
    {
      paramView.setContentDescription("视频" + paramInt);
      return paramView;
    }
    paramView.setContentDescription("照片" + paramInt);
    return paramView;
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_Agsv != null) {
      this.jdField_a_of_type_Agsv.aq_();
    }
    String str = "";
    if (((NewPhotoPreviewActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).a() != -1)
    {
      str = (String)this.jdField_a_of_type_Agsr.jdField_a_of_type_JavaUtilArrayList.get(((NewPhotoPreviewActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).a());
      this.jdField_a_of_type_Agsb.jdField_a_of_type_JavaUtilArrayList.add(str);
      this.jdField_a_of_type_Agsb.jdField_b_of_type_JavaUtilArrayList.add(Integer.valueOf(((NewPhotoPreviewActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).a()));
      if (this.jdField_a_of_type_Agsb.a())
      {
        if (this.jdField_a_of_type_Agsb.jdField_a_of_type_JavaUtilHashMap == null) {
          this.jdField_a_of_type_Agsb.jdField_a_of_type_JavaUtilHashMap = new HashMap();
        }
        LocalMediaInfo localLocalMediaInfo = ((NewPhotoPreviewActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).b(str);
        this.jdField_a_of_type_Agsb.jdField_a_of_type_JavaUtilHashMap.put(str, localLocalMediaInfo);
      }
    }
    ((NewPhotoPreviewActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).a(str);
    d();
    b((String)this.jdField_a_of_type_Agsr.jdField_a_of_type_JavaUtilArrayList.get(((NewPhotoPreviewActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).a()));
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    if ((paramInt1 >= 0) && (paramInt1 < this.jdField_a_of_type_Agsb.jdField_a_of_type_JavaUtilArrayList.size()) && (paramInt2 >= 0) && (paramInt2 < this.jdField_a_of_type_Agsb.jdField_a_of_type_JavaUtilArrayList.size()))
    {
      Collections.swap(this.jdField_a_of_type_Agsb.jdField_a_of_type_JavaUtilArrayList, paramInt1, paramInt2);
      if (this.jdField_a_of_type_Agsr.jdField_a_of_type_Vug != null)
      {
        String str = this.jdField_a_of_type_Agsr.jdField_a_of_type_Vug.a();
        if (!TextUtils.isEmpty(str)) {
          ((NewPhotoPreviewActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).a(str);
        }
      }
      vuc.a().b(this.jdField_a_of_type_Agsb.jdField_a_of_type_JavaUtilArrayList, this.jdField_a_of_type_Agsb.jdField_b_of_type_JavaUtilHashMap);
    }
  }
  
  protected void a(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if (paramInt1 == 24747)
    {
      vuc.a().a(paramIntent, this.jdField_a_of_type_Agsb.jdField_a_of_type_JavaUtilHashMap);
      return;
    }
    if (paramInt1 == 18001)
    {
      ((NewPhotoPreviewActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).c(paramInt1, paramInt2, paramIntent);
      return;
    }
    if (paramInt1 == 18002)
    {
      ((NewPhotoPreviewActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).b(paramInt1, paramInt2, paramIntent);
      return;
    }
    if (paramInt1 == 18003)
    {
      ((NewPhotoPreviewActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).a(paramInt1, paramInt2, paramIntent);
      return;
    }
    if (paramInt1 == 10000)
    {
      b(paramInt1, paramInt2, paramIntent);
      return;
    }
    PhotoUtils.a((Activity)this.jdField_a_of_type_MqqUtilWeakReference.get(), paramInt1, paramInt2, paramIntent, this.jdField_a_of_type_Agsr.jdField_j_of_type_Boolean, this.jdField_a_of_type_Agsb.jdField_a_of_type_JavaLangString);
  }
  
  protected void a(Intent paramIntent)
  {
    super.a(paramIntent);
    ahvz.a("preview create");
    this.jdField_a_of_type_Agsr.n = BaseApplicationImpl.getApplication().getSharedPreferences(BaseApplicationImpl.getApplication().getRuntime().getAccount(), 4).getBoolean("showFlashPic", true);
    this.jdField_a_of_type_Agsr.l = paramIntent.getBooleanExtra("showFlashPic", false);
    this.jdField_a_of_type_Agsr.jdField_f_of_type_Int = paramIntent.getIntExtra("PhotoConst.SEND_BUSINESS_TYPE", -1);
    this.jdField_a_of_type_Agsr.jdField_g_of_type_Int = paramIntent.getIntExtra("camera_front_back", 0);
    this.jdField_a_of_type_Agsr.jdField_h_of_type_Int = paramIntent.getIntExtra("camera_filter_id", -1);
    this.jdField_a_of_type_Agsr.jdField_k_of_type_Int = paramIntent.getIntExtra("camera_capture_method", -1);
    this.jdField_a_of_type_Agsr.jdField_h_of_type_Boolean = paramIntent.getBooleanExtra("PhotoConst.IS_FROM_EDIT", false);
    this.jdField_a_of_type_Agsr.p = paramIntent.getBooleanExtra("ReceiptMsgManager.EXTRA_KEY_IS_RECEIPT", false);
    this.jdField_a_of_type_Agsr.jdField_d_of_type_Boolean = paramIntent.getBooleanExtra("PhotoConst.USE_URL_PATH", false);
    this.jdField_a_of_type_Agsr.jdField_b_of_type_JavaUtilHashMap = ((HashMap)paramIntent.getSerializableExtra("PhotoConst.PHOTO_PATHS_FROM_QZONEALBUM"));
    this.jdField_a_of_type_Agsr.jdField_d_of_type_JavaUtilHashMap = ((HashMap)paramIntent.getSerializableExtra("PhotoConst.PHOTO_INFOS"));
    this.jdField_a_of_type_Agsr.jdField_a_of_type_JavaUtilHashMap = ((HashMap)paramIntent.getSerializableExtra("PhotoConst.editPathMap"));
    if (this.jdField_a_of_type_Agsr.jdField_a_of_type_JavaUtilHashMap == null) {
      this.jdField_a_of_type_Agsr.jdField_a_of_type_JavaUtilHashMap = new HashMap();
    }
    this.jdField_a_of_type_Agsr.jdField_e_of_type_JavaUtilHashMap = new HashMap(1);
    if (this.jdField_a_of_type_Agsr.jdField_d_of_type_JavaUtilHashMap != null) {
      this.jdField_a_of_type_Agsr.jdField_e_of_type_JavaUtilHashMap.putAll(this.jdField_a_of_type_Agsr.jdField_d_of_type_JavaUtilHashMap);
    }
    this.jdField_a_of_type_Agsr.jdField_c_of_type_JavaUtilHashMap = new HashMap(1);
    if (this.jdField_a_of_type_Agsr.jdField_b_of_type_JavaUtilHashMap != null) {
      this.jdField_a_of_type_Agsr.jdField_c_of_type_JavaUtilHashMap.putAll(this.jdField_a_of_type_Agsr.jdField_b_of_type_JavaUtilHashMap);
    }
    if (QLog.isColorLevel()) {
      QLog.d("aioSendPhotos", 2, "mCanUseURL:" + this.jdField_a_of_type_Agsr.jdField_d_of_type_Boolean + " mSelectedSendParams size:" + this.jdField_a_of_type_Agsr.jdField_c_of_type_JavaUtilHashMap.size());
    }
    this.jdField_a_of_type_Agsb.jdField_b_of_type_Long = paramIntent.getLongExtra("PhotoConst.PHOTOLIST_KEY_VIDEO_SIZE", 1048576000L);
    this.jdField_a_of_type_Agsr.jdField_e_of_type_Boolean = paramIntent.getBooleanExtra("PhotoConst.HANDLE_DEST_RESULT", false);
    this.jdField_a_of_type_Agsr.jdField_f_of_type_Boolean = paramIntent.getBooleanExtra("PhotoConst.SHOULD_SEND_RAW_PHOTO", false);
    if (!this.jdField_a_of_type_Agsr.jdField_g_of_type_Boolean) {
      this.jdField_a_of_type_Agsr.jdField_g_of_type_Boolean = paramIntent.getBooleanExtra("PhotoConst.SHOW_MAGIC_USE_PASTER", false);
    }
    if ("FROM_QZONE_PHOTO_LIST".equals(this.jdField_a_of_type_Agsr.jdField_a_of_type_JavaLangString)) {
      this.jdField_a_of_type_Agsr.jdField_g_of_type_Boolean = false;
    }
    if (this.jdField_a_of_type_Agsr.jdField_g_of_type_Boolean)
    {
      this.jdField_a_of_type_Agsr.jdField_f_of_type_JavaUtilHashMap = ((HashMap)paramIntent.getSerializableExtra("PasterConstants.pasters_data"));
      this.jdField_a_of_type_Agsr.jdField_e_of_type_JavaLangString = paramIntent.getStringExtra("PasterConstants.paster_id");
      this.jdField_a_of_type_Agsr.jdField_f_of_type_JavaLangString = paramIntent.getStringExtra("PasterConstants.paster_cate_id");
    }
    this.jdField_a_of_type_Agsr.jdField_e_of_type_Int = paramIntent.getIntExtra("uintype", -1);
    this.jdField_a_of_type_Agsr.jdField_j_of_type_Boolean = paramIntent.getBooleanExtra("PhotoConst.IS_CALL_IN_PLUGIN", false);
    this.jdField_a_of_type_Agsr.jdField_k_of_type_Boolean = paramIntent.getBooleanExtra("PhotoConst.IS_SINGLE_DERECTBACK_MODE", false);
    this.jdField_a_of_type_Agsb.c = paramIntent.getIntExtra("PhotoConst.CURRENT_QUALITY_TYPE", 0);
    this.jdField_a_of_type_Agsr.q = paramIntent.getBooleanExtra("PhotoConst.SEND_FLAG", false);
    if (this.jdField_a_of_type_Agsr.q)
    {
      paramIntent.removeExtra("PhotoConst.SEND_FLAG");
      PresendPicMgr localPresendPicMgr = PresendPicMgr.a(null);
      if (localPresendPicMgr != null)
      {
        if (QLog.isColorLevel()) {
          QLog.d("PhotoPreviewActivity", 2, "Photo+ send pic,cancel presend!");
        }
        localPresendPicMgr.a(1003);
      }
      PhotoUtils.a((Activity)this.jdField_a_of_type_MqqUtilWeakReference.get(), paramIntent, this.jdField_a_of_type_Agsb.jdField_a_of_type_JavaUtilArrayList, this.jdField_a_of_type_Agsb.c, true);
    }
    this.jdField_a_of_type_Agsr.jdField_i_of_type_Int = paramIntent.getIntExtra("key_pic_to_edit_from", 0);
  }
  
  public void a(Intent paramIntent, boolean paramBoolean, ArrayList<String> paramArrayList)
  {
    i2 = 0;
    i = -1;
    int j;
    int k;
    int i1;
    try
    {
      m = PhotoUtils.b((SessionInfo)paramIntent.getParcelableExtra("session_info"));
      HashMap localHashMap = new HashMap();
      j = 0;
      i = 0;
      int n = 0;
      k = 0;
      for (;;)
      {
        if (n >= paramArrayList.size()) {
          break label344;
        }
        localObject1 = (String)paramArrayList.get(n);
        if (!ImageManager.isNetworkUrl((String)localObject1)) {
          break;
        }
        i1 = k;
        k = i;
        i = i1;
        n += 1;
        i1 = k;
        k = i;
        i = i1;
      }
    }
    catch (Exception localException1)
    {
      for (;;)
      {
        m = i;
        if (QLog.isColorLevel())
        {
          QLog.e("PhotoPreviewActivity", 2, "submit", localException1);
          m = i;
        }
      }
    }
    if (((NewPhotoPreviewActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).a((String)localObject1) == 1)
    {
      localObject1 = ((NewPhotoPreviewActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).b((String)localObject1);
      localObject2 = new SendVideoActivity.SendVideoInfo();
      i += 1;
      if (((((LocalMediaInfo)localObject1).mDuration > 1200000L) || (((LocalMediaInfo)localObject1).fileSize > 1048576000L)) && (b()))
      {
        bcpw.a((Context)this.jdField_a_of_type_MqqUtilWeakReference.get(), ((NewPhotoPreviewActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).getResources().getString(2131719556), 0).b(((NewPhotoPreviewActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).getResources().getDimensionPixelSize(2131298865));
        ((NewPhotoPreviewActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).finish();
      }
    }
    label344:
    do
    {
      return;
      ((SendVideoActivity.SendVideoInfo)localObject2).fileSize = ((LocalMediaInfo)localObject1).fileSize;
      ((SendVideoActivity.SendVideoInfo)localObject2).duration = ((LocalMediaInfo)localObject1).mDuration;
      localException1.put(Integer.valueOf(k), localObject2);
      for (;;)
      {
        i1 = k + 1;
        k = i;
        i = i1;
        break;
        j += 1;
      }
      localObject1 = String.valueOf(j);
      localObject2 = String.valueOf(i);
      try
      {
        paramIntent.setExtrasClassLoader(SessionInfo.class.getClassLoader());
        if (localException1.isEmpty()) {
          break label761;
        }
        paramIntent.putExtra("PhotoConst.VIDEO_INFOS", localException1);
        i = 1;
      }
      catch (Exception localException2)
      {
        for (;;)
        {
          boolean bool;
          String str;
          i = i2;
          if (QLog.isColorLevel())
          {
            QLog.d("PhotoPreviewActivity", 2, "put extra Exception");
            i = i2;
            continue;
            bool = false;
            continue;
            if (paramBoolean)
            {
              PhotoUtils.a((Activity)this.jdField_a_of_type_MqqUtilWeakReference.get(), paramIntent, paramArrayList, this.jdField_a_of_type_Agsr.jdField_c_of_type_JavaUtilHashMap, this.jdField_a_of_type_Agsb.c, true);
              ((NewPhotoPreviewActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).setResult(-1);
              ((NewPhotoPreviewActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).finish();
            }
            for (;;)
            {
              axqw.b(null, "CliOper", "", "", "0X8009AB1", "0X8009AB1", m, 0, (String)localObject1, (String)localObject2, "", "");
              return;
              PhotoUtils.a((Activity)this.jdField_a_of_type_MqqUtilWeakReference.get(), paramIntent, paramArrayList, this.jdField_a_of_type_Agsb.c, this.jdField_a_of_type_Agsr.jdField_e_of_type_Boolean);
            }
            i = 0;
          }
        }
      }
      if ((axdo.jdField_b_of_type_Long == 0L) || (System.currentTimeMillis() - axdo.jdField_b_of_type_Long >= 300000L)) {
        break label633;
      }
      bool = true;
      if (QLog.isColorLevel()) {
        QLog.d("PhotoPreviewActivity", 2, "upload video isConfirmed=" + bool + " allowUploadInXGTime=" + axdo.jdField_b_of_type_Long);
      }
      if ((!bbev.b(BaseApplicationImpl.getContext())) || (bool) || (i == 0) || (!b())) {
        break label639;
      }
      str = ((NewPhotoPreviewActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).getResources().getString(2131719246);
      paramIntent = new PhotoPreviewLogicDefault.5(this, paramBoolean, paramIntent, paramArrayList, m, (String)localObject1, (String)localObject2);
      if (bcvm.a((Activity)this.jdField_a_of_type_MqqUtilWeakReference.get(), 4, new agti(this, paramIntent))) {
        bbcv.a((Context)this.jdField_a_of_type_MqqUtilWeakReference.get(), 232, null, str, new agtj(this, paramIntent), new agtk(this)).show();
      }
    } while (!QLog.isColorLevel());
    QLog.i("PhotoPreviewActivity", 2, "show shortvideo_mobile_send_confirm dialog");
  }
  
  protected void a(View paramView)
  {
    ((NewPhotoPreviewActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).getResources();
    paramView = PresendPicMgr.a(null);
    int i = ((NewPhotoPreviewActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).a();
    if (this.jdField_a_of_type_Agsb.jdField_b_of_type_JavaUtilArrayList.contains(Integer.valueOf(i)))
    {
      ((NewPhotoPreviewActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).jdField_a_of_type_ComTencentMobileqqWidgetNumberCheckBox.setChecked(false);
      int j = this.jdField_a_of_type_Agsb.jdField_b_of_type_JavaUtilArrayList.indexOf(Integer.valueOf(i));
      if (j >= 0)
      {
        this.jdField_a_of_type_Agsb.jdField_b_of_type_JavaUtilArrayList.remove(j);
        if (i != -1)
        {
          this.jdField_a_of_type_Agsb.jdField_a_of_type_JavaUtilArrayList.remove(this.jdField_a_of_type_Agsr.jdField_a_of_type_JavaUtilArrayList.get(i));
          if (this.jdField_a_of_type_Agsr.jdField_e_of_type_JavaUtilHashMap != null) {
            this.jdField_a_of_type_Agsr.jdField_e_of_type_JavaUtilHashMap.remove(this.jdField_a_of_type_Agsr.jdField_a_of_type_JavaUtilArrayList.get(i));
          }
          if (this.jdField_a_of_type_Agsr.jdField_c_of_type_JavaUtilHashMap != null) {
            this.jdField_a_of_type_Agsr.jdField_c_of_type_JavaUtilHashMap.remove(this.jdField_a_of_type_Agsr.jdField_a_of_type_JavaUtilArrayList.get(i));
          }
          if (paramView != null) {
            paramView.b((String)this.jdField_a_of_type_Agsr.jdField_a_of_type_JavaUtilArrayList.get(i), 1014);
          }
        }
      }
      d();
      if ((this.jdField_a_of_type_Agsb.jdField_b_of_type_JavaUtilArrayList.size() == 0) && (!this.jdField_a_of_type_Agsr.m)) {
        this.jdField_a_of_type_Agsr.o = false;
      }
    }
    for (;;)
    {
      if ((this.jdField_a_of_type_Agsb.a()) && (i != -1)) {
        b((String)this.jdField_a_of_type_Agsr.jdField_a_of_type_JavaUtilArrayList.get(i));
      }
      LpReportInfo_pf00064.allReport(603, 2);
      Object localObject;
      LocalMediaInfo localLocalMediaInfo;
      do
      {
        return;
        if (this.jdField_a_of_type_Agsb.jdField_a_of_type_JavaUtilArrayList.size() >= this.jdField_a_of_type_Agsb.jdField_a_of_type_Int)
        {
          long l = System.currentTimeMillis();
          if (l - this.jdField_a_of_type_Agsr.jdField_a_of_type_Long >= 700L)
          {
            bcpw.a((Context)this.jdField_a_of_type_MqqUtilWeakReference.get(), ((NewPhotoPreviewActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).a(), 1000).b(this.jdField_a_of_type_Agsr.jdField_a_of_type_Int);
            this.jdField_a_of_type_Agsr.jdField_a_of_type_Long = l;
            if (this.jdField_a_of_type_Agsr.p) {
              axqw.b(null, "CliOper", "", "", "0x80083EC", "0x80083EC", 0, 0, "", "", "", "");
            }
          }
          ((NewPhotoPreviewActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).jdField_a_of_type_ComTencentMobileqqWidgetNumberCheckBox.setChecked(false);
          return;
        }
        if (i == -1) {
          break;
        }
        localObject = (String)this.jdField_a_of_type_Agsr.jdField_a_of_type_JavaUtilArrayList.get(i);
        localLocalMediaInfo = ((NewPhotoPreviewActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).b((String)localObject);
      } while ((this.jdField_a_of_type_Agsb.c == 2) && (c()));
      if ((this.jdField_a_of_type_Agsb.a()) && (!bkpe.a((Activity)this.jdField_a_of_type_MqqUtilWeakReference.get(), localLocalMediaInfo)))
      {
        ((NewPhotoPreviewActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).jdField_a_of_type_ComTencentMobileqqWidgetNumberCheckBox.setChecked(false);
        return;
      }
      if ((((NewPhotoPreviewActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).getIntent().getBooleanExtra("PhotoConst.IS_SEND_GIF_SIZE_LIMIT", false)) && (auoy.a((String)localObject)) && (bbdj.a((String)localObject) > 3145728L))
      {
        bcpw.a((Context)this.jdField_a_of_type_MqqUtilWeakReference.get(), "图片文件过大", 0).b(this.jdField_a_of_type_Agsr.jdField_a_of_type_Int);
        ((NewPhotoPreviewActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).jdField_a_of_type_ComTencentMobileqqWidgetNumberCheckBox.setChecked(false);
        return;
      }
      if ((paramView != null) && (!this.jdField_a_of_type_Agsr.m) && (((NewPhotoPreviewActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).a((String)this.jdField_a_of_type_Agsr.jdField_a_of_type_JavaUtilArrayList.get(i)) != 1)) {
        paramView.a((String)this.jdField_a_of_type_Agsr.jdField_a_of_type_JavaUtilArrayList.get(i), this.jdField_a_of_type_Agsr.jdField_j_of_type_Int);
      }
      paramView = (String)this.jdField_a_of_type_Agsr.jdField_a_of_type_JavaUtilArrayList.get(i);
      this.jdField_a_of_type_Agsb.jdField_a_of_type_JavaUtilArrayList.add(paramView);
      if (this.jdField_a_of_type_Agsr.jdField_b_of_type_JavaUtilHashMap != null)
      {
        localObject = (PhotoSendParams)this.jdField_a_of_type_Agsr.jdField_b_of_type_JavaUtilHashMap.get(paramView);
        if ((this.jdField_a_of_type_Agsr.jdField_c_of_type_JavaUtilHashMap != null) && (localObject != null)) {
          this.jdField_a_of_type_Agsr.jdField_c_of_type_JavaUtilHashMap.put(paramView, localObject);
        }
      }
      if (this.jdField_a_of_type_Agsr.jdField_d_of_type_JavaUtilHashMap != null)
      {
        localObject = (PicInfo)this.jdField_a_of_type_Agsr.jdField_d_of_type_JavaUtilHashMap.get(paramView);
        if ((this.jdField_a_of_type_Agsr.jdField_e_of_type_JavaUtilHashMap != null) && (localObject != null)) {
          this.jdField_a_of_type_Agsr.jdField_e_of_type_JavaUtilHashMap.put(paramView, localObject);
        }
      }
      this.jdField_a_of_type_Agsb.jdField_b_of_type_JavaUtilArrayList.add(Integer.valueOf(i));
      if (this.jdField_a_of_type_Agsb.a())
      {
        if (this.jdField_a_of_type_Agsb.jdField_a_of_type_JavaUtilHashMap == null) {
          this.jdField_a_of_type_Agsb.jdField_a_of_type_JavaUtilHashMap = new HashMap();
        }
        localObject = ((NewPhotoPreviewActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).b(paramView);
        this.jdField_a_of_type_Agsb.jdField_a_of_type_JavaUtilHashMap.put(paramView, localObject);
      }
      ((NewPhotoPreviewActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).a(paramView);
      d();
    }
  }
  
  protected void a(View paramView, int paramInt1, Bundle paramBundle, int paramInt2, Intent paramIntent)
  {
    int i = ((NewPhotoPreviewActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).a();
    if (i != -1) {
      this.jdField_a_of_type_Agsr.jdField_d_of_type_JavaLangString = ((String)this.jdField_a_of_type_Agsr.jdField_a_of_type_JavaUtilArrayList.get(i));
    }
    if (this.jdField_a_of_type_Agsr.jdField_d_of_type_JavaLangString != null)
    {
      axqw.b(null, "CliOper", "", "", "0x8004B39", "0x8004B39", 0, 0, "", "", "", "");
      if (this.jdField_a_of_type_Agsr.jdField_g_of_type_Boolean)
      {
        paramView = paramIntent;
        if (paramIntent == null) {
          paramView = EditPicActivity.a((Activity)this.jdField_a_of_type_MqqUtilWeakReference.get(), this.jdField_a_of_type_Agsr.jdField_d_of_type_JavaLangString, true, true, true, true, true, paramInt2, 99, 4, paramBundle);
        }
        paramView.putExtra("PhotoConst.CURRENT_QUALITY_TYPE", this.jdField_a_of_type_Agsb.c);
        if (!this.jdField_a_of_type_Agsr.m) {
          break label368;
        }
        paramView.putExtra("PhotoConst.SEND_BUSINESS_TYPE", 1040);
        if (paramInt1 != -1) {
          break label386;
        }
        ((NewPhotoPreviewActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).startActivity(paramView);
        label185:
        ((NewPhotoPreviewActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).jdField_a_of_type_AndroidWidgetButton.setClickable(false);
        paramView = ((NewPhotoPreviewActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).getIntent();
        if ((paramView != null) && (paramView.hasExtra("custom_photopreview_editbtn_reportActionName")))
        {
          paramView = paramView.getStringExtra("custom_photopreview_editbtn_reportActionName");
          if (paramView != null) {
            axqw.b(null, "CliOper", "", "", paramView, paramView, 0, 0, "", "", "", "");
          }
        }
        if ((a()) && (this.jdField_a_of_type_Agsr.jdField_i_of_type_Int > 0))
        {
          paramInt2 = this.jdField_a_of_type_Agsr.jdField_i_of_type_Int;
          paramView = new StringBuilder();
          if (this.jdField_a_of_type_Agsb.jdField_a_of_type_JavaUtilArrayList == null) {
            break label404;
          }
        }
      }
    }
    label386:
    label404:
    for (paramInt1 = this.jdField_a_of_type_Agsb.jdField_a_of_type_JavaUtilArrayList.size();; paramInt1 = 0)
    {
      axqw.b(null, "dc00898", "", "", "0X800A06D", "0X800A06D", paramInt2, 0, paramInt1 + "", "", "", "");
      LpReportInfo_pf00064.allReport(603, 4, 1);
      return;
      label368:
      paramView.putExtra("PhotoConst.SEND_BUSINESS_TYPE", this.jdField_a_of_type_Agsr.jdField_f_of_type_Int);
      break;
      ((NewPhotoPreviewActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).startActivityForResult(paramView, paramInt1);
      break label185;
    }
  }
  
  public void a(CompoundButton paramCompoundButton, boolean paramBoolean)
  {
    if (paramBoolean)
    {
      paramCompoundButton = ((NewPhotoPreviewActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).jdField_a_of_type_AndroidWidgetCheckBox;
      if (!paramBoolean)
      {
        paramBoolean = true;
        paramCompoundButton.setChecked(paramBoolean);
        ((NewPhotoPreviewActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).jdField_a_of_type_AndroidWidgetTextView.setTextColor(2147483647);
        if (bbbj.a(this.jdField_a_of_type_Agsb.jdField_a_of_type_JavaUtilArrayList, this.jdField_a_of_type_Agsb.jdField_b_of_type_Int, this.jdField_a_of_type_Agsb.jdField_b_of_type_JavaUtilHashMap, true, this.jdField_a_of_type_Agsb.jdField_a_of_type_JavaUtilHashMap) <= 0) {
          break label202;
        }
        bcpw.a((Context)this.jdField_a_of_type_MqqUtilWeakReference.get(), ((NewPhotoPreviewActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).getResources().getString(2131695112), 0).b(((NewPhotoPreviewActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).getResources().getDimensionPixelSize(2131298865));
        this.jdField_a_of_type_Agsb.c = 0;
        ((NewPhotoPreviewActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).jdField_b_of_type_AndroidWidgetTextView.setText(((NewPhotoPreviewActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).getString(2131695116));
        ((NewPhotoPreviewActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).jdField_b_of_type_AndroidWidgetCheckBox.setChecked(false);
      }
      label202:
      label744:
      do
      {
        do
        {
          do
          {
            do
            {
              int j;
              do
              {
                return;
                paramBoolean = false;
                break;
                if (!this.jdField_a_of_type_Agsb.jdField_a_of_type_JavaUtilArrayList.isEmpty()) {
                  break label744;
                }
                j = ((NewPhotoPreviewActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).jdField_a_of_type_ComTencentMobileqqActivityPhotoDragGallery.getFirstVisiblePosition();
              } while (j >= this.jdField_a_of_type_Agsr.jdField_a_of_type_JavaUtilArrayList.size());
              long l = new File((String)this.jdField_a_of_type_Agsr.jdField_a_of_type_JavaUtilArrayList.get(j)).length();
              if (((NewPhotoPreviewActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).a((String)this.jdField_a_of_type_Agsr.jdField_a_of_type_JavaUtilArrayList.get(j)) == 1) {}
              for (int i = 1; (i == 0) && (l > ayxc.a()); i = 0)
              {
                bcpw.a((Context)this.jdField_a_of_type_MqqUtilWeakReference.get(), ((NewPhotoPreviewActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).getResources().getString(2131695112), 0).b(((NewPhotoPreviewActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).getResources().getDimensionPixelSize(2131298865));
                this.jdField_a_of_type_Agsb.c = 0;
                ((NewPhotoPreviewActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).jdField_b_of_type_AndroidWidgetTextView.setText(((NewPhotoPreviewActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).getString(2131695116));
                ((NewPhotoPreviewActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).jdField_b_of_type_AndroidWidgetCheckBox.setChecked(false);
                return;
              }
              if ((i != 0) && (l > 104345600L))
              {
                bcpw.a((Context)this.jdField_a_of_type_MqqUtilWeakReference.get(), ((NewPhotoPreviewActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).getResources().getString(2131719578), 0).b(((NewPhotoPreviewActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).getResources().getDimensionPixelSize(2131298865));
                bbbj.d();
              }
              ((NewPhotoPreviewActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).a("", 1);
              this.jdField_a_of_type_Agsb.jdField_a_of_type_JavaUtilArrayList.add(this.jdField_a_of_type_Agsr.jdField_a_of_type_JavaUtilArrayList.get(j));
              this.jdField_a_of_type_Agsb.jdField_b_of_type_JavaUtilArrayList.add(Integer.valueOf(j));
              ((NewPhotoPreviewActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).jdField_b_of_type_AndroidWidgetCheckBox.setChecked(true);
              this.jdField_a_of_type_Agsb.c = 2;
              a(((NewPhotoPreviewActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).jdField_b_of_type_AndroidWidgetTextView);
              d();
              paramCompoundButton = PresendPicMgr.a();
              if ((paramCompoundButton != null) && (((NewPhotoPreviewActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).a((String)this.jdField_a_of_type_Agsr.jdField_a_of_type_JavaUtilArrayList.get(j)) != 1)) {
                paramCompoundButton.a((String)this.jdField_a_of_type_Agsr.jdField_a_of_type_JavaUtilArrayList.get(j), this.jdField_a_of_type_Agsr.jdField_j_of_type_Int);
              }
              paramCompoundButton = ((NewPhotoPreviewActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).getIntent();
            } while ((paramCompoundButton == null) || (!paramCompoundButton.hasExtra("custom_photopreview_rawcheckbox_reportActionName")));
            paramCompoundButton = paramCompoundButton.getStringExtra("custom_photopreview_rawcheckbox_reportActionName");
          } while (paramCompoundButton == null);
          axqw.b(null, "CliOper", "", "", paramCompoundButton, paramCompoundButton, 0, 0, "", "", "", "");
          return;
          if (bbbj.a(this.jdField_a_of_type_Agsb.jdField_a_of_type_JavaUtilArrayList, 104345600L, this.jdField_a_of_type_Agsb.jdField_b_of_type_JavaUtilHashMap, true, this.jdField_a_of_type_Agsb.jdField_a_of_type_JavaUtilHashMap) > 0)
          {
            bcpw.a((Context)this.jdField_a_of_type_MqqUtilWeakReference.get(), ((NewPhotoPreviewActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).getResources().getString(2131719578), 0).b(((NewPhotoPreviewActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).getResources().getDimensionPixelSize(2131298865));
            bbbj.d();
          }
          ((NewPhotoPreviewActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).jdField_b_of_type_AndroidWidgetCheckBox.setChecked(true);
          this.jdField_a_of_type_Agsb.c = 2;
          a(((NewPhotoPreviewActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).jdField_b_of_type_AndroidWidgetTextView);
          paramCompoundButton = ((NewPhotoPreviewActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).getIntent();
        } while ((paramCompoundButton == null) || (!paramCompoundButton.hasExtra("custom_photopreview_rawcheckbox_reportActionName")));
        paramCompoundButton = paramCompoundButton.getStringExtra("custom_photopreview_rawcheckbox_reportActionName");
      } while (paramCompoundButton == null);
      axqw.b(null, "CliOper", "", "", paramCompoundButton, paramCompoundButton, 0, 0, "", "", "", "");
      return;
    }
    ((NewPhotoPreviewActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).jdField_b_of_type_AndroidWidgetCheckBox.setChecked(false);
    this.jdField_a_of_type_Agsb.c = 0;
    ((NewPhotoPreviewActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).jdField_b_of_type_AndroidWidgetTextView.setText(((NewPhotoPreviewActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).getString(2131695116));
    ((NewPhotoPreviewActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).jdField_a_of_type_AndroidWidgetTextView.setTextColor(-1);
  }
  
  protected void a(TextView paramTextView)
  {
    Object localObject1 = ((NewPhotoPreviewActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).getResources();
    Object localObject2 = this.jdField_a_of_type_Agsb.jdField_a_of_type_JavaUtilArrayList.iterator();
    while (((Iterator)localObject2).hasNext())
    {
      String str = (String)((Iterator)localObject2).next();
      if ((!NetworkUtils.isNetworkUrl(str)) && (((NewPhotoPreviewActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).a(str) == 1)) {
        paramTextView.setText(((Resources)localObject1).getString(2131695116));
      }
    }
    int i = bbbj.a(this.jdField_a_of_type_Agsb.jdField_a_of_type_JavaUtilArrayList, this.jdField_a_of_type_Agsb.jdField_b_of_type_JavaUtilHashMap, false, this.jdField_a_of_type_Agsr.jdField_c_of_type_JavaUtilHashMap, this.jdField_a_of_type_Agsb.jdField_a_of_type_JavaUtilHashMap);
    localObject2 = PhotoUtils.a((Context)this.jdField_a_of_type_MqqUtilWeakReference.get(), i);
    if ((this.jdField_a_of_type_Agsb.jdField_a_of_type_JavaUtilArrayList.size() == 0) || (((String)localObject2).equals("0"))) {}
    for (localObject1 = ((Resources)localObject1).getString(2131695116);; localObject1 = ((Resources)localObject1).getString(2131695116) + "(共" + (String)localObject2 + ")")
    {
      paramTextView.setText((CharSequence)localObject1);
      return;
    }
  }
  
  public void a(SlideItemInfo paramSlideItemInfo)
  {
    if (paramSlideItemInfo == null) {
      return;
    }
    if (this.jdField_a_of_type_Agsv != null) {
      this.jdField_a_of_type_Agsv.a_(paramSlideItemInfo);
    }
    int i = 0;
    label24:
    if (i < this.jdField_a_of_type_Agsr.jdField_a_of_type_JavaUtilArrayList.size()) {
      if (!((String)this.jdField_a_of_type_Agsr.jdField_a_of_type_JavaUtilArrayList.get(i)).equals(paramSlideItemInfo.jdField_b_of_type_JavaLangString)) {}
    }
    for (;;)
    {
      if (i >= 0)
      {
        if (!this.jdField_a_of_type_Agsb.jdField_b_of_type_JavaUtilArrayList.contains(Integer.valueOf(i))) {
          break;
        }
        ((NewPhotoPreviewActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).jdField_a_of_type_ComTencentMobileqqWidgetNumberCheckBox.setChecked(false);
        int j = this.jdField_a_of_type_Agsb.jdField_b_of_type_JavaUtilArrayList.indexOf(Integer.valueOf(i));
        if (j >= 0)
        {
          this.jdField_a_of_type_Agsb.jdField_a_of_type_JavaUtilArrayList.remove(this.jdField_a_of_type_Agsr.jdField_a_of_type_JavaUtilArrayList.get(i));
          this.jdField_a_of_type_Agsb.jdField_b_of_type_JavaUtilArrayList.remove(j);
          if (this.jdField_a_of_type_Agsr.jdField_e_of_type_JavaUtilHashMap != null) {
            this.jdField_a_of_type_Agsr.jdField_e_of_type_JavaUtilHashMap.remove(this.jdField_a_of_type_Agsr.jdField_a_of_type_JavaUtilArrayList.get(i));
          }
          if (this.jdField_a_of_type_Agsr.jdField_c_of_type_JavaUtilHashMap != null) {
            this.jdField_a_of_type_Agsr.jdField_c_of_type_JavaUtilHashMap.remove(this.jdField_a_of_type_Agsr.jdField_a_of_type_JavaUtilArrayList.get(i));
          }
        }
        d();
        b((String)this.jdField_a_of_type_Agsr.jdField_a_of_type_JavaUtilArrayList.get(i));
        return;
        i += 1;
        break label24;
      }
      this.jdField_a_of_type_Agsb.jdField_a_of_type_JavaUtilArrayList.remove(paramSlideItemInfo.jdField_b_of_type_JavaLangString);
      d();
      ((NewPhotoPreviewActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).a(paramSlideItemInfo.jdField_b_of_type_JavaLangString);
      b(paramSlideItemInfo.jdField_b_of_type_JavaLangString);
      return;
      i = -1;
    }
  }
  
  protected void a(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    if (QLog.isColorLevel()) {
      QLog.d("PhotoPreviewActivity", 2, " onItemSelected position=" + paramInt);
    }
    super.a(paramAdapterView, paramView, paramInt, paramLong);
    paramAdapterView = ((NewPhotoPreviewActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).jdField_a_of_type_Agry.a(paramInt);
    try
    {
      ((NewPhotoPreviewActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).jdField_a_of_type_ComTencentWidgetDragView.setOriginRect(((NewPhotoPreviewActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).b((String)this.jdField_a_of_type_Agsr.jdField_a_of_type_JavaUtilArrayList.get(paramInt)).thumbRect);
      if (this.jdField_a_of_type_Agsb.a())
      {
        if (paramAdapterView != null) {
          ((NewPhotoPreviewActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).a(paramAdapterView);
        }
        b((String)this.jdField_a_of_type_Agsr.jdField_a_of_type_JavaUtilArrayList.get(paramInt));
      }
      return;
    }
    catch (Exception paramView)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.d("PhotoPreviewActivity", 2, bfnd.a(paramView));
        }
      }
    }
  }
  
  public void a(String paramString)
  {
    int j = 0;
    if ((this.jdField_a_of_type_Agsb.a()) && (!this.jdField_a_of_type_Agsr.jdField_i_of_type_Boolean))
    {
      this.jdField_a_of_type_Agsr.jdField_a_of_type_JavaUtilArrayList.clear();
      this.jdField_a_of_type_Agsr.jdField_a_of_type_JavaUtilArrayList.addAll(this.jdField_a_of_type_Agsb.jdField_a_of_type_JavaUtilArrayList);
      this.jdField_a_of_type_Agsb.jdField_b_of_type_JavaUtilArrayList.clear();
      i = 0;
      while (i < this.jdField_a_of_type_Agsb.jdField_a_of_type_JavaUtilArrayList.size())
      {
        this.jdField_a_of_type_Agsb.jdField_b_of_type_JavaUtilArrayList.add(Integer.valueOf(i));
        i += 1;
      }
      ((NewPhotoPreviewActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).jdField_a_of_type_Agry.notifyDataSetChanged();
      this.jdField_a_of_type_Agsr.jdField_i_of_type_Boolean = true;
    }
    int i = this.jdField_a_of_type_Agsr.jdField_a_of_type_JavaUtilArrayList.indexOf(paramString);
    if (i < 0) {
      i = j;
    }
    for (;;)
    {
      ((NewPhotoPreviewActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).jdField_a_of_type_ComTencentMobileqqActivityPhotoDragGallery.setSelection(i);
      return;
    }
  }
  
  public void a(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_Agsr.jdField_h_of_type_Boolean) {
      vuc.a().a(vuc.a().c());
    }
    Intent localIntent1 = ((NewPhotoPreviewActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).getIntent();
    localIntent1.putExtra("PhotoConst.SEND_BUSINESS_TYPE", this.jdField_a_of_type_Agsr.jdField_f_of_type_Int);
    if ("FROM_PHOTO_LIST".equals(this.jdField_a_of_type_Agsr.jdField_a_of_type_JavaLangString))
    {
      localIntent1.setClass((Context)this.jdField_a_of_type_MqqUtilWeakReference.get(), NewPhotoListActivity.class);
      localIntent1.putExtra("PhotoConst.CURRENT_QUALITY_TYPE", this.jdField_a_of_type_Agsb.c);
      if (this.jdField_a_of_type_Agsr.jdField_c_of_type_Boolean) {
        localIntent1.removeExtra("PhotoConst.PHOTO_PATHS");
      }
    }
    for (;;)
    {
      localIntent1.putExtra("PhotoConst.PHOTO_PATHS_FROM_QZONEALBUM", this.jdField_a_of_type_Agsr.jdField_c_of_type_JavaUtilHashMap);
      localIntent1.putExtra("PhotoConst.PHOTO_INFOS", this.jdField_a_of_type_Agsr.jdField_e_of_type_JavaUtilHashMap);
      ((NewPhotoPreviewActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).startActivity(localIntent1);
      label161:
      if (localIntent1.getBooleanExtra("keep_selected_status_after_finish", false))
      {
        localIntent1 = new Intent();
        localIntent1.putStringArrayListExtra("PhotoConst.SELECTED_PATHS", this.jdField_a_of_type_Agsb.jdField_a_of_type_JavaUtilArrayList);
        localIntent1.putIntegerArrayListExtra("PhotoConst.SELECTED_INDEXS", this.jdField_a_of_type_Agsb.jdField_b_of_type_JavaUtilArrayList);
        localIntent1.putExtra("PhotoConst.CURRENT_QUALITY_TYPE", this.jdField_a_of_type_Agsb.c);
        localIntent1.putExtra("PhotoConst.editPathMap", this.jdField_a_of_type_Agsr.jdField_a_of_type_JavaUtilHashMap);
        ((NewPhotoPreviewActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).setResult(-1, localIntent1);
      }
      ((NewPhotoPreviewActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).finish();
      if (paramBoolean) {
        try
        {
          ((NewPhotoPreviewActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).overridePendingTransition(2130772036, 2130772038);
          return;
          localIntent1.putStringArrayListExtra("PhotoConst.PHOTO_PATHS", this.jdField_a_of_type_Agsb.jdField_a_of_type_JavaUtilArrayList);
          localIntent1.putExtra("PhotoConst.editPathMap", this.jdField_a_of_type_Agsr.jdField_a_of_type_JavaUtilHashMap);
          continue;
          if (!"FROM_QZONE_PHOTO_LIST".equals(this.jdField_a_of_type_Agsr.jdField_a_of_type_JavaLangString)) {
            break label161;
          }
          Intent localIntent2 = new Intent();
          localIntent2.putStringArrayListExtra("PhotoConst.PHOTO_PATHS", this.jdField_a_of_type_Agsb.jdField_a_of_type_JavaUtilArrayList);
          localIntent2.putExtra("PhotoConst.PHOTO_PATHS_FROM_QZONEALBUM", this.jdField_a_of_type_Agsr.jdField_c_of_type_JavaUtilHashMap);
          localIntent2.putExtra("PhotoConst.CURRENT_QUALITY_TYPE", this.jdField_a_of_type_Agsb.c);
          localIntent2.putExtra("PeakConstants.selectedMediaInfoHashMap", this.jdField_a_of_type_Agsb.jdField_a_of_type_JavaUtilHashMap);
          ((NewPhotoPreviewActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).setResult(-1, localIntent2);
        }
        catch (Exception localException)
        {
          while (!QLog.isColorLevel()) {}
          QLog.d("PhotoPreviewActivity", 2, "[PhotoPreviewActivity] overridePendingTransition=" + localException);
          return;
        }
      }
    }
    bbbj.a((Activity)this.jdField_a_of_type_MqqUtilWeakReference.get(), true, false);
  }
  
  public boolean a()
  {
    return false;
  }
  
  void b(int paramInt1, int paramInt2, Intent paramIntent)
  {
    boolean bool = false;
    if ((paramInt2 == -1) && (paramIntent != null))
    {
      if (!paramIntent.getBooleanExtra("PhotoConst.SEND_ORIGIN", false)) {
        bool = true;
      }
      if (bool) {
        break label32;
      }
    }
    label32:
    String str2;
    String str1;
    do
    {
      do
      {
        return;
        str2 = paramIntent.getStringExtra("PhotoConst.SINGLE_PHOTO_PATH");
      } while (str2 == null);
      ThreadManager.excute(new PhotoPreviewLogicDefault.9(this, str2), 64, null, true);
      if (QLog.isColorLevel()) {
        QLog.i("PhotoPreviewActivity", 2, "onActivityResultForMultiEdit hasEdit:" + bool + ", picPath:" + str2);
      }
      str1 = paramIntent.getStringExtra("key_multi_edit_source_path");
      paramInt1 = this.jdField_a_of_type_Agsr.jdField_a_of_type_JavaUtilArrayList.indexOf(str1);
    } while (paramInt1 < 0);
    if (this.jdField_a_of_type_Agsr.jdField_a_of_type_JavaUtilHashMap.containsValue(str1)) {}
    for (paramIntent = agpm.a(this.jdField_a_of_type_Agsr.jdField_a_of_type_JavaUtilHashMap, str1);; paramIntent = str1)
    {
      this.jdField_a_of_type_Agsr.jdField_a_of_type_JavaUtilHashMap.put(paramIntent, str2);
      this.jdField_a_of_type_Agsr.jdField_a_of_type_JavaUtilArrayList.add(paramInt1, str2);
      this.jdField_a_of_type_Agsr.jdField_a_of_type_JavaUtilArrayList.remove(paramInt1 + 1);
      paramInt2 = this.jdField_a_of_type_Agsb.jdField_a_of_type_JavaUtilArrayList.indexOf(str1);
      if (paramInt2 >= 0)
      {
        this.jdField_a_of_type_Agsb.jdField_a_of_type_JavaUtilArrayList.add(paramInt2, str2);
        this.jdField_a_of_type_Agsb.jdField_a_of_type_JavaUtilArrayList.remove(paramInt2 + 1);
      }
      ((NewPhotoPreviewActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).jdField_a_of_type_Agry.notifyDataSetChanged();
      ((NewPhotoPreviewActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).jdField_a_of_type_Agrz.notifyDataSetChanged();
      ((NewPhotoPreviewActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).jdField_a_of_type_ComTencentMobileqqActivityPhotoDragGallery.setSelection(paramInt1);
      paramIntent = PresendPicMgr.a();
      if (paramIntent == null) {
        break;
      }
      paramIntent.b(str1, 1003);
      paramIntent.a(str2, this.jdField_a_of_type_Agsr.jdField_j_of_type_Int);
      return;
    }
  }
  
  void b(String paramString)
  {
    if (this.jdField_a_of_type_Agsb.a())
    {
      if (this.jdField_a_of_type_Agsr.jdField_a_of_type_Vug == null) {
        this.jdField_a_of_type_Agsr.jdField_a_of_type_Vug = new vug((Activity)this.jdField_a_of_type_MqqUtilWeakReference.get(), this);
      }
      vuc.a().a(this.jdField_a_of_type_Agsr.jdField_a_of_type_Vug);
      vuc.a().b(this.jdField_a_of_type_Agsb.jdField_a_of_type_JavaUtilArrayList, this.jdField_a_of_type_Agsb.jdField_b_of_type_JavaUtilHashMap);
      vuc.a().a((Activity)this.jdField_a_of_type_MqqUtilWeakReference.get());
      this.jdField_a_of_type_Agsr.jdField_a_of_type_Vug.a(this.jdField_a_of_type_Agsb.jdField_a_of_type_JavaUtilArrayList.indexOf(paramString));
      if (((NewPhotoPreviewActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).jdField_a_of_type_Boolean)
      {
        paramString = (RelativeLayout)((NewPhotoPreviewActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).findViewById(2131377333);
        ((ViewGroup)paramString.getParent()).removeView(paramString);
        Object localObject = paramString.getLayoutParams();
        localObject = new RelativeLayout.LayoutParams(((ViewGroup.LayoutParams)localObject).width, ((ViewGroup.LayoutParams)localObject).height);
        ((RelativeLayout.LayoutParams)localObject).addRule(10, -1);
        ((RelativeLayout.LayoutParams)localObject).topMargin = bbkx.a(8.0F);
        ((NewPhotoPreviewActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).jdField_a_of_type_AndroidWidgetRelativeLayout.addView(paramString, (ViewGroup.LayoutParams)localObject);
      }
      ((NewPhotoPreviewActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).jdField_b_of_type_AndroidWidgetRelativeLayout.setVisibility(4);
    }
  }
  
  public void b(boolean paramBoolean)
  {
    this.jdField_a_of_type_Agsr.m = paramBoolean;
    if (paramBoolean)
    {
      this.jdField_a_of_type_Agsr.o = true;
      Object localObject = ((NewPhotoPreviewActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).jdField_b_of_type_AndroidWidgetCheckBox;
      if (!paramBoolean)
      {
        paramBoolean = true;
        ((CheckBox)localObject).setChecked(paramBoolean);
        ((NewPhotoPreviewActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).jdField_b_of_type_AndroidWidgetTextView.setTextColor(2147483647);
        if ((this.jdField_a_of_type_Agsb.jdField_a_of_type_JavaUtilArrayList.isEmpty()) && (((NewPhotoPreviewActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).jdField_a_of_type_ComTencentMobileqqActivityPhotoDragGallery.getFirstVisiblePosition() < this.jdField_a_of_type_Agsr.jdField_a_of_type_JavaUtilArrayList.size()))
        {
          ((NewPhotoPreviewActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).jdField_b_of_type_AndroidViewView.performClick();
          d();
        }
        if ((this.jdField_a_of_type_Agsr.n) && (((NewPhotoPreviewActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).jdField_a_of_type_ComTencentWidgetBubblePopupWindow == null))
        {
          this.jdField_a_of_type_Agsr.n = false;
          BaseApplicationImpl.getApplication().getSharedPreferences(BaseApplicationImpl.getApplication().getRuntime().getAccount(), 4).edit().putBoolean("showFlashPic", false).commit();
          ((NewPhotoPreviewActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).jdField_a_of_type_ComTencentWidgetBubblePopupWindow = new BubblePopupWindow(-2, -2);
          localObject = new TextView((Context)this.jdField_a_of_type_MqqUtilWeakReference.get());
          int i = actn.a(10.0F, ((NewPhotoPreviewActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).getResources());
          ((TextView)localObject).setPadding(i, 0, i, 0);
          ((TextView)localObject).setTextColor(-1);
          ((TextView)localObject).setText("选中的图片每人只能查看一次");
          ((TextView)localObject).setTextSize(14.0F);
          ((NewPhotoPreviewActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).jdField_a_of_type_ComTencentWidgetBubblePopupWindow.a((View)localObject);
          ((NewPhotoPreviewActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).jdField_a_of_type_ComTencentWidgetBubblePopupWindow.a(false);
          ((NewPhotoPreviewActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).jdField_a_of_type_ComTencentWidgetBubblePopupWindow.b(((NewPhotoPreviewActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).jdField_a_of_type_AndroidWidgetTextView);
        }
        if (this.jdField_a_of_type_Agsr.jdField_e_of_type_Int != 0) {
          break label392;
        }
        axqw.b(null, "dc00898", "", "", "0X8006997", "0X8006997", 0, 0, "", "", "", "");
      }
    }
    label392:
    do
    {
      do
      {
        return;
        paramBoolean = false;
        break;
        if (this.jdField_a_of_type_Agsr.jdField_e_of_type_Int == 3000)
        {
          axqw.b(null, "dc00898", "", "", "0X8006998", "0X8006998", 0, 0, "", "", "", "");
          return;
        }
      } while (this.jdField_a_of_type_Agsr.jdField_e_of_type_Int != 1);
      axqw.b(null, "dc00898", "", "", "0X8006999", "0X8006999", 0, 0, "", "", "", "");
      return;
      ((NewPhotoPreviewActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).jdField_b_of_type_AndroidWidgetTextView.setTextColor(-1);
    } while (((NewPhotoPreviewActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).jdField_a_of_type_ComTencentWidgetBubblePopupWindow == null);
    ((NewPhotoPreviewActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).jdField_a_of_type_ComTencentWidgetBubblePopupWindow.b();
  }
  
  protected boolean b()
  {
    return true;
  }
  
  protected void c()
  {
    int j = 1;
    int k = 0;
    i();
    if (Build.VERSION.SDK_INT == 19)
    {
      localObject1 = ((NewPhotoPreviewActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).getWindow().getDecorView();
      ((View)localObject1).setSystemUiVisibility(((View)localObject1).getSystemUiVisibility() | 0x4 | 0x100 | 0x1000);
    }
    super.c();
    Object localObject1 = ((NewPhotoPreviewActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).getResources();
    ((NewPhotoPreviewActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).jdField_a_of_type_Int = ((Resources)localObject1).getDisplayMetrics().widthPixels;
    ((NewPhotoPreviewActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).jdField_b_of_type_Int = ((Resources)localObject1).getDisplayMetrics().heightPixels;
    ((NewPhotoPreviewActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).ac = true;
    ((NewPhotoPreviewActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).ad = false;
    ((NewPhotoPreviewActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).jdField_a_of_type_ComTencentWidgetDragView.setGestureChangeListener((bfqd)this.jdField_a_of_type_MqqUtilWeakReference.get());
    ((NewPhotoPreviewActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).jdField_a_of_type_ComTencentWidgetDragView.setRatioModify(true);
    localObject1 = (Rect)((NewPhotoPreviewActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).getIntent().getParcelableExtra("KEY_THUMBNAL_BOUND");
    int i;
    Object localObject2;
    label366:
    label635:
    float f;
    if (localObject1 != null) {
      if (((NewPhotoPreviewActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).jdField_a_of_type_Boolean)
      {
        i = bkur.jdField_a_of_type_Int;
        ((Rect)localObject1).top -= i;
        ((Rect)localObject1).bottom -= i;
        if ((this.jdField_a_of_type_Agsr.jdField_a_of_type_JavaUtilArrayList != null) && (-1 != this.jdField_a_of_type_Agsr.jdField_d_of_type_Int) && (this.jdField_a_of_type_Agsr.jdField_a_of_type_JavaUtilArrayList.get(this.jdField_a_of_type_Agsr.jdField_d_of_type_Int) != null))
        {
          localObject2 = ((NewPhotoPreviewActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).b((String)this.jdField_a_of_type_Agsr.jdField_a_of_type_JavaUtilArrayList.get(this.jdField_a_of_type_Agsr.jdField_d_of_type_Int));
          if (localObject2 != null) {
            ((LocalMediaInfo)localObject2).thumbRect = ((Rect)localObject1);
          }
        }
        ((NewPhotoPreviewActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).jdField_a_of_type_ComTencentWidgetDragView.setOriginRect((Rect)localObject1);
        if (this.jdField_a_of_type_Agsr.jdField_a_of_type_Boolean)
        {
          ((NewPhotoPreviewActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).jdField_a_of_type_AndroidViewView.setVisibility(0);
          if (!this.jdField_a_of_type_Agsb.a()) {
            break label1196;
          }
          ((NewPhotoPreviewActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).jdField_b_of_type_AndroidWidgetRelativeLayout.setVisibility(4);
        }
        label420:
        if ((this.jdField_a_of_type_Agsr.l) && (this.jdField_a_of_type_Agsr.jdField_e_of_type_JavaUtilHashMap.size() == 0))
        {
          ((NewPhotoPreviewActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).jdField_a_of_type_AndroidWidgetCheckBox.setVisibility(0);
          ((NewPhotoPreviewActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
          ((NewPhotoPreviewActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).jdField_a_of_type_AndroidWidgetCheckBox.setOnCheckedChangeListener((CompoundButton.OnCheckedChangeListener)this.jdField_a_of_type_MqqUtilWeakReference.get());
          ((NewPhotoPreviewActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).jdField_a_of_type_AndroidWidgetTextView.setOnClickListener(new agtd(this));
          ((NewPhotoPreviewActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).jdField_a_of_type_AndroidWidgetCheckBox.setContentDescription("闪照");
          ((NewPhotoPreviewActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).jdField_a_of_type_AndroidWidgetTextView.setContentDescription("闪照");
        }
        ((NewPhotoPreviewActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).jdField_b_of_type_AndroidWidgetCheckBox.setOnCheckedChangeListener((CompoundButton.OnCheckedChangeListener)this.jdField_a_of_type_MqqUtilWeakReference.get());
        if (!this.jdField_a_of_type_Agsr.jdField_f_of_type_Boolean) {
          break label1216;
        }
        ((NewPhotoPreviewActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).jdField_b_of_type_AndroidWidgetCheckBox.setVisibility(0);
        ((NewPhotoPreviewActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
        if (!this.jdField_a_of_type_Agsr.jdField_g_of_type_Boolean) {
          break label1255;
        }
        ((NewPhotoPreviewActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).jdField_a_of_type_AndroidWidgetButton.setVisibility(0);
        label662:
        if (this.jdField_a_of_type_Agsb.a()) {
          ((NewPhotoPreviewActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).d.setVisibility(8);
        }
        ((NewPhotoPreviewActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).jdField_a_of_type_AndroidWidgetButton.setOnClickListener(new agte(this));
        ((NewPhotoPreviewActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).jdField_b_of_type_AndroidWidgetButton.setOnClickListener(new agtf(this));
        d();
        if ((this.jdField_a_of_type_Agsr.jdField_k_of_type_Boolean) || (this.jdField_a_of_type_Agsr.jdField_c_of_type_Boolean))
        {
          ((NewPhotoPreviewActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).jdField_a_of_type_ComTencentMobileqqWidgetNumberCheckBox.setVisibility(8);
          ((NewPhotoPreviewActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).jdField_b_of_type_AndroidViewView.setVisibility(8);
          ((NewPhotoPreviewActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).jdField_b_of_type_AndroidWidgetCheckBox.setVisibility(8);
          ((NewPhotoPreviewActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
        }
        ((NewPhotoPreviewActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).jdField_a_of_type_ComTencentMobileqqActivityPhotoDragGallery.setOnItemClickListener(new agth(this));
        if (this.jdField_a_of_type_Agsb.a()) {
          ((NewPhotoPreviewActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).jdField_c_of_type_AndroidWidgetTextView.setText("");
        }
        if (this.jdField_a_of_type_Agsr.jdField_e_of_type_Int == 1001)
        {
          ((NewPhotoPreviewActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).jdField_b_of_type_AndroidWidgetCheckBox.setVisibility(8);
          ((NewPhotoPreviewActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
        }
        f = 16.0F / ajwe.a();
        i = j;
        if (((NewPhotoPreviewActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).getResources().getDisplayMetrics().densityDpi >= 400)
        {
          if (Build.VERSION.SDK_INT > 21) {
            break label1276;
          }
          i = j;
        }
        label980:
        if ((f >= 1.0F) && (i == 0)) {
          break label1322;
        }
        if (i == 0) {
          break label1439;
        }
        f = 0.7F * f;
      }
    }
    label1439:
    for (;;)
    {
      j = k;
      if (QLog.isColorLevel())
      {
        QLog.d("PhotoPreviewActivity", 2, "need scale,reqWidth:" + ((NewPhotoPreviewActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).jdField_a_of_type_Int + " scale:" + f);
        j = k;
      }
      label1060:
      if (j < ((NewPhotoPreviewActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).jdField_b_of_type_AndroidWidgetRelativeLayout.getChildCount())
      {
        localObject1 = ((NewPhotoPreviewActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).jdField_b_of_type_AndroidWidgetRelativeLayout.getChildAt(j);
        ((View)localObject1).setScaleX(f);
        ((View)localObject1).setScaleY(f);
        localObject2 = (RelativeLayout.LayoutParams)((View)localObject1).getLayoutParams();
        if (j == ((NewPhotoPreviewActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).jdField_b_of_type_AndroidWidgetRelativeLayout.getChildCount() - 1) {
          ((RelativeLayout.LayoutParams)localObject2).rightMargin = ((int)(((RelativeLayout.LayoutParams)localObject2).rightMargin * f));
        }
        for (;;)
        {
          ((View)localObject1).setLayoutParams((ViewGroup.LayoutParams)localObject2);
          j += 1;
          break label1060;
          i = 0;
          break;
          ((NewPhotoPreviewActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).jdField_a_of_type_ComTencentWidgetDragView.setEnableDrag(false);
          break label366;
          label1196:
          ((NewPhotoPreviewActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).jdField_b_of_type_AndroidWidgetRelativeLayout.setVisibility(0);
          break label420;
          label1216:
          ((NewPhotoPreviewActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).jdField_b_of_type_AndroidWidgetCheckBox.setVisibility(8);
          ((NewPhotoPreviewActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
          break label635;
          label1255:
          ((NewPhotoPreviewActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).jdField_a_of_type_AndroidWidgetButton.setVisibility(8);
          break label662;
          label1276:
          i = 0;
          break label980;
          ((RelativeLayout.LayoutParams)localObject2).leftMargin = ((int)(((RelativeLayout.LayoutParams)localObject2).leftMargin * f));
          if ((i != 0) && (f < 1.0F)) {
            ((RelativeLayout.LayoutParams)localObject2).leftMargin = ((int)(((RelativeLayout.LayoutParams)localObject2).leftMargin * f));
          }
        }
      }
      label1322:
      if (this.jdField_a_of_type_Agsb.a()) {
        b((String)this.jdField_a_of_type_Agsr.jdField_a_of_type_JavaUtilArrayList.get(((NewPhotoPreviewActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).a()));
      }
      f = ((NewPhotoPreviewActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).getResources().getDisplayMetrics().density;
      actn.a(((NewPhotoPreviewActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).jdField_a_of_type_AndroidWidgetButton, (int)(10.0F * f + 0.5F), (int)(10.0F * f + 0.5F), (int)(10.0F * f + 0.5F), (int)(f * 10.0F + 0.5F));
      return;
    }
  }
  
  protected boolean c()
  {
    int i = ((NewPhotoPreviewActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).a();
    if ((this.jdField_a_of_type_Agsb.a()) && (i != -1) && (new File((String)this.jdField_a_of_type_Agsr.jdField_a_of_type_JavaUtilArrayList.get(i)).length() > ayxc.a()))
    {
      bcpw.a((Context)this.jdField_a_of_type_MqqUtilWeakReference.get(), ((NewPhotoPreviewActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).getResources().getString(2131695112), 0).b(((NewPhotoPreviewActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).getResources().getDimensionPixelSize(2131298865));
      ((NewPhotoPreviewActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).jdField_a_of_type_ComTencentMobileqqWidgetNumberCheckBox.setChecked(false);
      return true;
    }
    return false;
  }
  
  protected void d()
  {
    Object localObject = ((NewPhotoPreviewActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).getResources();
    if (this.jdField_a_of_type_Agsr.jdField_f_of_type_Boolean)
    {
      localObject = ((Resources)localObject).getString(2131695146);
      if (this.jdField_a_of_type_Agsr.jdField_b_of_type_JavaLangString == null) {
        break label864;
      }
      localObject = this.jdField_a_of_type_Agsr.jdField_b_of_type_JavaLangString;
    }
    label79:
    label468:
    label600:
    label864:
    for (;;)
    {
      int i;
      boolean bool1;
      int j;
      if ((this.jdField_a_of_type_Agsb.jdField_a_of_type_JavaUtilArrayList != null) && (this.jdField_a_of_type_Agsb.jdField_a_of_type_JavaUtilArrayList.size() > 0))
      {
        i = 1;
        if (i == 0) {
          break label600;
        }
        if ((!this.jdField_a_of_type_Agsr.jdField_k_of_type_Boolean) && (!this.jdField_a_of_type_Agsr.jdField_c_of_type_Boolean)) {
          break label468;
        }
        ((NewPhotoPreviewActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).jdField_b_of_type_AndroidWidgetButton.setEnabled(true);
        ((NewPhotoPreviewActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).jdField_b_of_type_AndroidWidgetButton.setText((CharSequence)localObject);
        bool1 = this.jdField_a_of_type_Agsb.jdField_b_of_type_JavaUtilArrayList.contains(Integer.valueOf(((NewPhotoPreviewActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).a()));
        if (((NewPhotoPreviewActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).a() == -1) {
          break label789;
        }
        if (((NewPhotoPreviewActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).a((String)this.jdField_a_of_type_Agsr.jdField_a_of_type_JavaUtilArrayList.get(((NewPhotoPreviewActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).a())) == 1) {
          break label764;
        }
        j = 1;
        label227:
        boolean bool2 = bbbj.a((String)this.jdField_a_of_type_Agsr.jdField_a_of_type_JavaUtilArrayList.get(((NewPhotoPreviewActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).a()));
        if (((i != 0) && (!bool1)) || (j == 0) || (bool2)) {
          break label769;
        }
        ((NewPhotoPreviewActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).jdField_a_of_type_AndroidWidgetButton.setEnabled(true);
        if (((NewPhotoPreviewActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).jdField_a_of_type_Agrz != null)
        {
          if (!a()) {
            break label809;
          }
          if (((NewPhotoPreviewActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).jdField_a_of_type_ComTencentWidgetHorizontalListView.getVisibility() == 4)
          {
            ((NewPhotoPreviewActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).jdField_c_of_type_AndroidViewView.setVisibility(0);
            ((NewPhotoPreviewActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).jdField_a_of_type_ComTencentWidgetHorizontalListView.setVisibility(0);
          }
          ((NewPhotoPreviewActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).jdField_a_of_type_Agrz.notifyDataSetChanged();
        }
      }
      for (;;)
      {
        if ((bool1) || (this.jdField_a_of_type_Agsb.jdField_a_of_type_JavaUtilArrayList.size() < this.jdField_a_of_type_Agsb.jdField_a_of_type_Int)) {
          break label846;
        }
        ((NewPhotoPreviewActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).jdField_a_of_type_ComTencentMobileqqWidgetNumberCheckBox.setActivated(true);
        return;
        if (this.jdField_a_of_type_Agsb.a())
        {
          localObject = ((Resources)localObject).getString(2131699533);
          break;
        }
        localObject = ((Resources)localObject).getString(2131695084);
        break;
        i = 0;
        break label79;
        ((NewPhotoPreviewActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).jdField_b_of_type_AndroidWidgetButton.setEnabled(true);
        g();
        Button localButton;
        if (this.jdField_a_of_type_Agsb.a())
        {
          localButton = ((NewPhotoPreviewActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).jdField_b_of_type_AndroidWidgetButton;
          if (this.jdField_a_of_type_Agsb.jdField_a_of_type_JavaUtilArrayList.size() < 2) {
            break label595;
          }
        }
        for (bool1 = true;; bool1 = false)
        {
          localButton.setEnabled(bool1);
          ((NewPhotoPreviewActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).jdField_b_of_type_AndroidWidgetButton.setText((String)localObject + "(" + this.jdField_a_of_type_Agsb.jdField_a_of_type_JavaUtilArrayList.size() + ")");
          break;
        }
        ((NewPhotoPreviewActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).jdField_b_of_type_AndroidWidgetButton.setText((CharSequence)localObject);
        if (this.jdField_a_of_type_Agsb.a()) {
          ((NewPhotoPreviewActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).jdField_b_of_type_AndroidWidgetButton.setEnabled(false);
        }
        ((NewPhotoPreviewActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).jdField_b_of_type_AndroidWidgetCheckBox.setOnCheckedChangeListener(null);
        localObject = ((NewPhotoPreviewActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).jdField_b_of_type_AndroidWidgetCheckBox;
        if (this.jdField_a_of_type_Agsb.c == 2) {}
        for (bool1 = true;; bool1 = false)
        {
          ((CheckBox)localObject).setChecked(bool1);
          ((NewPhotoPreviewActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).jdField_b_of_type_AndroidWidgetCheckBox.setOnCheckedChangeListener((CompoundButton.OnCheckedChangeListener)this.jdField_a_of_type_MqqUtilWeakReference.get());
          if (this.jdField_a_of_type_Agsb.c == 2) {
            ((NewPhotoPreviewActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).jdField_b_of_type_AndroidWidgetTextView.setTextColor(-16734752);
          }
          g();
          break;
        }
        label764:
        j = 0;
        break label227;
        ((NewPhotoPreviewActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).jdField_a_of_type_AndroidWidgetButton.setEnabled(false);
        break label292;
        ((NewPhotoPreviewActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).jdField_a_of_type_AndroidWidgetButton.setEnabled(false);
        break label292;
        ((NewPhotoPreviewActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).jdField_c_of_type_AndroidViewView.setVisibility(4);
        ((NewPhotoPreviewActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).jdField_a_of_type_ComTencentWidgetHorizontalListView.setVisibility(4);
      }
      ((NewPhotoPreviewActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).jdField_a_of_type_ComTencentMobileqqWidgetNumberCheckBox.setActivated(false);
      return;
    }
  }
  
  void e()
  {
    if (this.jdField_a_of_type_Agsb.a()) {
      vuc.a().f();
    }
    super.e();
  }
  
  void f()
  {
    super.f();
    QQLiveImage.onForeground((Activity)this.jdField_a_of_type_MqqUtilWeakReference.get());
    lzj.a(BaseApplicationImpl.getContext(), true);
    bctn.a(BaseApplicationImpl.getContext(), false);
    amkg.a(BaseApplicationImpl.getContext(), 2, false);
    if (((NewPhotoPreviewActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).jdField_a_of_type_AndroidWidgetButton != null) {
      ((NewPhotoPreviewActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).jdField_a_of_type_AndroidWidgetButton.setClickable(true);
    }
    if (this.jdField_a_of_type_Agsb.a())
    {
      vuc.a().c();
      vuc.a().a(this.jdField_a_of_type_Agsr.jdField_a_of_type_Vug);
      vuc.a().b(this.jdField_a_of_type_Agsb.jdField_a_of_type_JavaUtilArrayList, this.jdField_a_of_type_Agsb.jdField_b_of_type_JavaUtilHashMap);
    }
  }
  
  public void g()
  {
    switch (this.jdField_a_of_type_Agsb.c)
    {
    case 1: 
    default: 
      return;
    case 0: 
      ((NewPhotoPreviewActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).jdField_b_of_type_AndroidWidgetTextView.setText(((NewPhotoPreviewActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).getString(2131695116));
      ((NewPhotoPreviewActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).jdField_b_of_type_AndroidWidgetCheckBox.setChecked(false);
      return;
    }
    a(((NewPhotoPreviewActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).jdField_b_of_type_AndroidWidgetTextView);
    ((NewPhotoPreviewActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).jdField_b_of_type_AndroidWidgetCheckBox.setChecked(true);
  }
  
  protected void h()
  {
    if ((this.jdField_a_of_type_Agsr.jdField_g_of_type_Boolean) && ((!TextUtils.isEmpty(this.jdField_a_of_type_Agsr.jdField_e_of_type_JavaLangString)) || (!TextUtils.isEmpty(this.jdField_a_of_type_Agsr.jdField_f_of_type_JavaLangString)))) {
      ((NewPhotoPreviewActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).jdField_a_of_type_AndroidWidgetButton.performClick();
    }
    Object localObject3 = ((NewPhotoPreviewActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).a();
    Intent localIntent = ((NewPhotoPreviewActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).getIntent();
    if (localObject3 != null)
    {
      agqf.a(((ArrayList)localObject3).size(), this.jdField_a_of_type_Agsr.jdField_b_of_type_Int);
      agqf.a(localIntent, ((ArrayList)localObject3).size(), this.jdField_a_of_type_Agsb.c);
    }
    Object localObject1 = PresendPicMgr.a(null);
    label379:
    String str;
    Object localObject2;
    int i;
    if (this.jdField_a_of_type_Agsb.c == 2)
    {
      if ((this.jdField_a_of_type_Agsb.jdField_a_of_type_JavaUtilArrayList.size() == 0) && (((ArrayList)localObject3).size() == 1) && (bbdj.a((String)((ArrayList)localObject3).get(0)) > ayxc.a()))
      {
        bcpw.a((Context)this.jdField_a_of_type_MqqUtilWeakReference.get(), ((NewPhotoPreviewActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).getResources().getString(2131695112), 0).b(((NewPhotoPreviewActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).getResources().getDimensionPixelSize(2131298865));
        ((NewPhotoPreviewActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).jdField_b_of_type_AndroidWidgetButton.setClickable(true);
      }
      do
      {
        return;
        if (localObject1 != null)
        {
          ((PresendPicMgr)localObject1).a(1010);
          ((PresendPicMgr)localObject1).a();
        }
        axqw.b(null, "CliOper", "", "", "0X800515C", "0X800515C", 0, 0, "", "", "", "");
        if (this.jdField_a_of_type_Agsr.m)
        {
          localIntent.putExtra("PhotoConst.SEND_BUSINESS_TYPE", 1040);
          if (this.jdField_a_of_type_Agsr.jdField_e_of_type_Int != 0) {
            break;
          }
          axqw.b(null, "dc00898", "", "", "0X80069A6", "0X80069A6", 0, 0, "", "", "", "");
          axqw.b(null, "dc00898", "", "", "0X800699A", "0X800699A", 0, 0, "", "", "", "");
        }
        if (this.jdField_a_of_type_Agsr.jdField_e_of_type_Boolean) {
          ((NewPhotoPreviewActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).jdField_a_of_type_AndroidViewView.setVisibility(4);
        }
        if (localObject3 != null) {
          ahvz.a((List)localObject3);
        }
        if (this.jdField_a_of_type_Agsb.a()) {
          localIntent.putExtra("PeakConstants.selectedMediaInfoHashMap", this.jdField_a_of_type_Agsb.jdField_a_of_type_JavaUtilHashMap);
        }
        if (this.jdField_a_of_type_Agsr.p)
        {
          localIntent.putExtra("ReceiptMsgManager.EXTRA_KEY_IS_RECEIPT", true);
          localIntent.putExtra("session_info", localIntent.getParcelableExtra("session_info"));
        }
        a(localIntent, this.jdField_a_of_type_Agsb.b(), ((NewPhotoPreviewActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).a());
        if ((localIntent != null) && (localIntent.getBooleanExtra("custom_photopreview_sendbtn_report", false)))
        {
          str = localIntent.getStringExtra("custom_photopreview_sendbtn_reportActionName");
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
          if ((str != null) && (localObject1 != null)) {
            axqw.b(null, "CliOper", "", "", str, str, 0, 0, (String)localObject1, "", "", "");
          }
        }
      } while ((!a()) || (this.jdField_a_of_type_Agsr.jdField_i_of_type_Int <= 0));
      localObject1 = ((ArrayList)localObject3).iterator();
      i = 0;
    }
    for (;;)
    {
      if (!((Iterator)localObject1).hasNext()) {
        break label946;
      }
      localObject2 = (String)((Iterator)localObject1).next();
      localObject3 = this.jdField_a_of_type_Agsr.jdField_a_of_type_JavaUtilHashMap.values().iterator();
      for (;;)
      {
        if (((Iterator)localObject3).hasNext())
        {
          str = (String)((Iterator)localObject3).next();
          if ((!TextUtils.isEmpty((CharSequence)localObject2)) && (!TextUtils.isEmpty(str)) && (((String)localObject2).equals(str)))
          {
            i += 1;
            continue;
            if ((localObject1 == null) || (this.jdField_a_of_type_Agsb.jdField_a_of_type_JavaUtilArrayList.size() <= 0) || (this.jdField_a_of_type_Agsr.m) || (this.jdField_a_of_type_Agsr.o) || (this.jdField_a_of_type_Agsr.p) || (localIntent.getBooleanExtra("PhotoConst.SEND_NO_PRESEND", false))) {
              break;
            }
            ((PresendPicMgr)localObject1).a(localIntent);
            break;
            if (this.jdField_a_of_type_Agsr.jdField_e_of_type_Int == 3000)
            {
              axqw.b(null, "dc00898", "", "", "0X80069A7", "0X80069A7", 0, 0, "", "", "", "");
              axqw.b(null, "dc00898", "", "", "0X800699B", "0X800699B", 0, 0, "", "", "", "");
              break label379;
            }
            if (this.jdField_a_of_type_Agsr.jdField_e_of_type_Int != 1) {
              break label379;
            }
            axqw.b(null, "dc00898", "", "", "0X80069A8", "0X80069A8", 0, 0, "", "", "", "");
            axqw.b(null, "dc00898", "", "", "0X800699C", "0X800699C", 0, 0, "", "", "", "");
            break label379;
          }
        }
      }
    }
    label946:
    localObject1 = new StringBuilder();
    if (this.jdField_a_of_type_Agsb.jdField_a_of_type_JavaUtilArrayList != null) {}
    for (int j = this.jdField_a_of_type_Agsb.jdField_a_of_type_JavaUtilArrayList.size();; j = 0)
    {
      axqw.b(null, "dc00898", "", "", "0X800A070", "0X800A070", 0, 0, j + "", i + "", "", "");
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     agtc
 * JD-Core Version:    0.7.0.1
 */