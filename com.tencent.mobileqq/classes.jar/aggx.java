import NS_MOBILE_OPERATION.PicInfo;
import android.app.Activity;
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
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.SurfaceView;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.galleryactivity.AbstractImageAdapter.URLImageView2;
import com.tencent.component.network.utils.NetworkUtils;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.activity.photo.DragGallery;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.activity.photo.PhotoSendParams;
import com.tencent.mobileqq.activity.photo.PhotoUtils;
import com.tencent.mobileqq.activity.photo.album.NewPhotoListActivity;
import com.tencent.mobileqq.activity.photo.album.NewPhotoPreviewActivity;
import com.tencent.mobileqq.pic.PresendPicMgr;
import com.tencent.mobileqq.widget.NumberCheckBox;
import com.tencent.qphone.base.util.QLog;
import com.tencent.sharpP.SharpPUtils;
import com.tencent.widget.AdapterView;
import com.tencent.widget.BubblePopupWindow;
import com.tencent.widget.DragView;
import com.tencent.widget.Gallery.LayoutParams;
import com.tencent.widget.HorizontalListView;
import cooperation.qzone.report.lp.LpReportInfo_pf00064;
import dov.com.tencent.biz.qqstory.takevideo.EditPicActivity;
import java.io.File;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import mqq.app.AppRuntime;
import mqq.util.WeakReference;

public class aggx
  extends aggt
  implements aggu, aggv
{
  protected aggx(NewPhotoPreviewActivity paramNewPhotoPreviewActivity)
  {
    super(paramNewPhotoPreviewActivity);
    this.jdField_a_of_type_Aggu = this;
    this.jdField_a_of_type_Aggv = this;
  }
  
  public static aggt a(NewPhotoPreviewActivity paramNewPhotoPreviewActivity)
  {
    if ((jdField_a_of_type_Aggt == null) || (jdField_a_of_type_Aggt.jdField_a_of_type_MqqUtilWeakReference.get() != paramNewPhotoPreviewActivity)) {}
    try
    {
      if ((jdField_a_of_type_Aggt == null) || (jdField_a_of_type_Aggt.jdField_a_of_type_MqqUtilWeakReference.get() != paramNewPhotoPreviewActivity)) {
        jdField_a_of_type_Aggt = new aggx(paramNewPhotoPreviewActivity);
      }
      return jdField_a_of_type_Aggt;
    }
    finally {}
  }
  
  public View a(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    Object localObject2 = null;
    if (QLog.isColorLevel()) {
      QLog.d("PhotoPreviewActivity", 2, " getView position=" + paramInt);
    }
    if (paramView != null) {}
    Object localObject3;
    int i;
    Object localObject1;
    label260:
    label279:
    do
    {
      return paramView;
      localObject3 = ((NewPhotoPreviewActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).jdField_a_of_type_Aggc.a(paramInt);
      URLDrawable localURLDrawable;
      View localView;
      if (((NewPhotoPreviewActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).a((String)localObject3) == 1)
      {
        i = 1;
        localURLDrawable = (URLDrawable)this.jdField_a_of_type_Aggs.jdField_a_of_type_AndroidUtilSparseArray.get(paramInt);
        if (i == 0) {
          break label260;
        }
        localView = ((NewPhotoPreviewActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).getLayoutInflater().inflate(2131495376, null);
        localView.setTag(2131296400, Boolean.valueOf(true));
        localView.setLayoutParams(new Gallery.LayoutParams(-1, -1));
        localObject1 = (ImageView)localView.findViewById(2131306224);
      }
      for (;;)
      {
        Object localObject4 = new File((String)localObject3);
        localObject4 = ((NewPhotoPreviewActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).a((File)localObject4);
        if ((localURLDrawable == null) || (localURLDrawable.getStatus() != 1) || (!localURLDrawable.getURL().equals(localObject4))) {
          break label279;
        }
        ((ImageView)localObject1).setImageDrawable(localURLDrawable);
        if (i == 0) {
          break label635;
        }
        ((ImageView)localObject1).setContentDescription("视频" + paramInt);
        return localView;
        i = 0;
        break;
        localObject1 = new AbstractImageAdapter.URLImageView2(paramViewGroup.getContext());
        localView = null;
      }
    } while (localObject3 == null);
    paramView = new File((String)localObject3);
    int j;
    int k;
    if (paramView.exists()) {
      if (i != 0)
      {
        paramView = ((NewPhotoPreviewActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).b((String)localObject3);
        j = paramViewGroup.getWidth();
        k = paramViewGroup.getHeight();
        if (paramView.mediaWidth <= paramView.mediaHeight) {
          break label663;
        }
        j = paramViewGroup.getHeight();
        k = paramViewGroup.getWidth();
      }
    }
    label663:
    for (;;)
    {
      paramViewGroup = baaf.a(paramView, "FLOW_THUMB");
      if (paramViewGroup != null)
      {
        ((ImageView)localObject1).setImageDrawable(((NewPhotoPreviewActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).a(paramViewGroup.toString(), j, k, paramView));
        paramView = localObject2;
      }
      for (;;)
      {
        if (paramView == null) {
          break label555;
        }
        ((ImageView)localObject1).setImageDrawable(paramView);
        this.jdField_a_of_type_Aggs.jdField_a_of_type_AndroidUtilSparseArray.put(paramInt, paramView);
        break;
        QLog.d("PhotoPreviewActivity", 2, "url  is null ");
        paramView = localObject2;
        continue;
        localObject3 = URLDrawable.URLDrawableOptions.obtain();
        ((URLDrawable.URLDrawableOptions)localObject3).mRequestWidth = paramViewGroup.getWidth();
        ((URLDrawable.URLDrawableOptions)localObject3).mRequestHeight = paramViewGroup.getHeight();
        ((URLDrawable.URLDrawableOptions)localObject3).mLoadingDrawable = axwd.a;
        ((URLDrawable.URLDrawableOptions)localObject3).mPlayGifImage = true;
        paramViewGroup = ((NewPhotoPreviewActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).a(paramView);
        paramView = localObject2;
        if (paramViewGroup != null)
        {
          paramViewGroup = URLDrawable.getDrawable(paramViewGroup, (URLDrawable.URLDrawableOptions)localObject3);
          paramView = paramViewGroup;
          if (paramViewGroup != null)
          {
            paramView = paramViewGroup;
            switch (paramViewGroup.getStatus())
            {
            }
            paramViewGroup.setTag(Integer.valueOf(1));
            paramViewGroup.startDownload();
            paramView = paramViewGroup;
          }
        }
      }
      label555:
      break;
      if ((!this.jdField_a_of_type_Aggs.q) || (!NewPhotoPreviewActivity.a((String)localObject3))) {
        break;
      }
      paramView = URLDrawable.URLDrawableOptions.obtain();
      paramView.mRequestWidth = paramViewGroup.getWidth();
      paramView.mRequestHeight = paramViewGroup.getHeight();
      paramView.mLoadingDrawable = axwd.a;
      paramView = URLDrawable.getDrawable(SharpPUtils.getWebpUrl((String)localObject3), paramView);
      if (paramView == null) {
        QLog.w("PEAK", 2, "drawable == null");
      }
      ((ImageView)localObject1).setImageDrawable(paramView);
      break;
      label635:
      ((ImageView)localObject1).setContentDescription("照片" + paramInt);
      return localObject1;
    }
  }
  
  protected void a(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if (paramInt1 == 24747)
    {
      vhg.a().a(paramIntent, this.jdField_a_of_type_Aggf.jdField_a_of_type_JavaUtilHashMap);
      return;
    }
    if (paramInt1 == 18001)
    {
      ((NewPhotoPreviewActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).d(paramInt1, paramInt2, paramIntent);
      return;
    }
    if (paramInt1 == 18002)
    {
      ((NewPhotoPreviewActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).c(paramInt1, paramInt2, paramIntent);
      return;
    }
    if (paramInt1 == 18003)
    {
      ((NewPhotoPreviewActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).b(paramInt1, paramInt2, paramIntent);
      return;
    }
    if (paramInt1 == 10000)
    {
      ((NewPhotoPreviewActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).a(paramInt1, paramInt2, paramIntent);
      return;
    }
    PhotoUtils.a((Activity)this.jdField_a_of_type_MqqUtilWeakReference.get(), paramInt1, paramInt2, paramIntent, this.jdField_a_of_type_Aggs.jdField_g_of_type_Boolean, this.jdField_a_of_type_Aggf.jdField_a_of_type_JavaLangString);
  }
  
  protected void a(Intent paramIntent)
  {
    afzu.a = ((NewPhotoPreviewActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).getResources().getDimension(2131165887);
    ((NewPhotoPreviewActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).jdField_a_of_type_Agew = new agfd();
    ahji.a("preview create");
    this.jdField_a_of_type_Aggs.jdField_l_of_type_Boolean = BaseApplicationImpl.getApplication().getSharedPreferences(BaseApplicationImpl.getApplication().getRuntime().getAccount(), 4).getBoolean("showFlashPic", true);
    this.jdField_a_of_type_Aggs.jdField_a_of_type_JavaLangString = paramIntent.getStringExtra("FROM_WHERE");
    this.jdField_a_of_type_Aggs.o = paramIntent.getBooleanExtra("PhotoConst.IS_SINGLE_MODE", false);
    this.jdField_a_of_type_Aggs.jdField_j_of_type_Boolean = paramIntent.getBooleanExtra("showFlashPic", false);
    this.jdField_a_of_type_Aggs.jdField_e_of_type_Int = paramIntent.getIntExtra("PhotoConst.SEND_BUSINESS_TYPE", -1);
    this.jdField_a_of_type_Aggs.jdField_f_of_type_Int = paramIntent.getIntExtra("camera_type", 1);
    this.jdField_a_of_type_Aggs.jdField_g_of_type_Int = paramIntent.getIntExtra("camera_front_back", 0);
    this.jdField_a_of_type_Aggs.jdField_h_of_type_Int = paramIntent.getIntExtra("camera_filter_id", -1);
    this.jdField_a_of_type_Aggs.jdField_l_of_type_Int = paramIntent.getIntExtra("camera_capture_method", -1);
    this.jdField_a_of_type_Aggs.jdField_e_of_type_Boolean = paramIntent.getBooleanExtra("PhotoConst.IS_FROM_EDIT", false);
    if (this.jdField_a_of_type_Aggf.jdField_a_of_type_JavaUtilHashMap == null) {
      this.jdField_a_of_type_Aggf.jdField_a_of_type_JavaUtilHashMap = new HashMap();
    }
    Object localObject = (HashMap)paramIntent.getSerializableExtra("PeakConstants.selectedMediaInfoHashMap");
    if ((localObject != null) && (!((HashMap)localObject).isEmpty())) {
      this.jdField_a_of_type_Aggf.jdField_a_of_type_JavaUtilHashMap.putAll((Map)localObject);
    }
    this.jdField_a_of_type_Aggs.n = paramIntent.getBooleanExtra("ReceiptMsgManager.EXTRA_KEY_IS_RECEIPT", false);
    this.jdField_a_of_type_Aggs.q = paramIntent.getBooleanExtra("PhotoConst.USE_URL_PATH", false);
    this.jdField_a_of_type_Aggs.jdField_b_of_type_JavaUtilHashMap = ((HashMap)paramIntent.getSerializableExtra("PhotoConst.PHOTO_PATHS_FROM_QZONEALBUM"));
    this.jdField_a_of_type_Aggs.jdField_d_of_type_JavaUtilHashMap = ((HashMap)paramIntent.getSerializableExtra("PhotoConst.PHOTO_INFOS"));
    localObject = (HashMap)paramIntent.getSerializableExtra("PhotoConst.ALL_MEDIA_PATHS");
    if (localObject != null) {
      this.jdField_a_of_type_Aggf.jdField_b_of_type_JavaUtilHashMap = ((HashMap)localObject);
    }
    this.jdField_a_of_type_Aggs.jdField_a_of_type_JavaUtilHashMap = ((HashMap)paramIntent.getSerializableExtra("PhotoConst.editPathMap"));
    if (this.jdField_a_of_type_Aggs.jdField_a_of_type_JavaUtilHashMap == null) {
      this.jdField_a_of_type_Aggs.jdField_a_of_type_JavaUtilHashMap = new HashMap();
    }
    this.jdField_a_of_type_Aggs.jdField_e_of_type_JavaUtilHashMap = new HashMap(1);
    if (this.jdField_a_of_type_Aggs.jdField_d_of_type_JavaUtilHashMap != null) {
      this.jdField_a_of_type_Aggs.jdField_e_of_type_JavaUtilHashMap.putAll(this.jdField_a_of_type_Aggs.jdField_d_of_type_JavaUtilHashMap);
    }
    this.jdField_a_of_type_Aggs.jdField_c_of_type_JavaUtilHashMap = new HashMap(1);
    if (this.jdField_a_of_type_Aggs.jdField_b_of_type_JavaUtilHashMap != null) {
      this.jdField_a_of_type_Aggs.jdField_c_of_type_JavaUtilHashMap.putAll(this.jdField_a_of_type_Aggs.jdField_b_of_type_JavaUtilHashMap);
    }
    if (QLog.isColorLevel()) {
      QLog.d("aioSendPhotos", 2, "mCanUseURL:" + this.jdField_a_of_type_Aggs.q + " mSelectedSendParams size:" + this.jdField_a_of_type_Aggs.jdField_c_of_type_JavaUtilHashMap.size());
    }
    paramIntent.removeExtra("FROM_WHERE");
    this.jdField_a_of_type_Aggf.jdField_a_of_type_Int = paramIntent.getIntExtra("PhotoConst.MAXUM_SELECTED_NUM", 1);
    this.jdField_a_of_type_Aggs.jdField_i_of_type_Boolean = paramIntent.getBooleanExtra("PhotoConst.SHOW_ALBUM", false);
    this.jdField_a_of_type_Aggs.jdField_d_of_type_JavaLangString = paramIntent.getStringExtra("back_btn_text");
    if (this.jdField_a_of_type_Aggs.jdField_i_of_type_Boolean)
    {
      this.jdField_a_of_type_Aggs.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
      this.jdField_a_of_type_Aggs.jdField_a_of_type_JavaUtilArrayList.addAll(this.jdField_a_of_type_Aggf.c);
      if (this.jdField_a_of_type_Aggs.jdField_a_of_type_JavaUtilArrayList.isEmpty()) {
        this.jdField_a_of_type_Aggs.jdField_a_of_type_JavaUtilArrayList = paramIntent.getStringArrayListExtra("PhotoConst.PHOTO_PATHS");
      }
      if (this.jdField_a_of_type_Aggs.jdField_a_of_type_JavaUtilArrayList == null) {
        this.jdField_a_of_type_Aggs.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
      }
      this.jdField_a_of_type_Aggf.jdField_a_of_type_JavaUtilArrayList = paramIntent.getStringArrayListExtra("PhotoConst.SELECTED_PATHS");
      localObject = paramIntent.getIntegerArrayListExtra("PhotoConst.SELECTED_INDEXS");
      if ((localObject != null) && (!((ArrayList)localObject).isEmpty())) {
        this.jdField_a_of_type_Aggf.jdField_b_of_type_JavaUtilArrayList = ((ArrayList)localObject);
      }
      if ((this.jdField_a_of_type_Aggf.jdField_b_of_type_JavaUtilArrayList != null) && (this.jdField_a_of_type_Aggs.jdField_a_of_type_JavaUtilArrayList != null)) {
        break label1472;
      }
      if (QLog.isColorLevel()) {
        QLog.d("PhotoPreviewActivity", 2, "initData(): Error! selectedItem or sSelectedIndex is null");
      }
      ((NewPhotoPreviewActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).finish();
    }
    label1472:
    for (int i = 0;; i = 1)
    {
      if (i != 0)
      {
        this.jdField_a_of_type_Aggs.jdField_d_of_type_Int = this.jdField_a_of_type_Aggs.jdField_a_of_type_JavaUtilArrayList.size();
        this.jdField_a_of_type_Aggs.jdField_k_of_type_Int = ((NewPhotoPreviewActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).getIntent().getIntExtra("PhotoConst.CURRENT_SELECTED_INDEX", -1);
        if (this.jdField_a_of_type_Aggs.jdField_k_of_type_Int >= this.jdField_a_of_type_Aggs.jdField_d_of_type_Int) {
          this.jdField_a_of_type_Aggs.jdField_k_of_type_Int = -1;
        }
        paramIntent.removeExtra("PhotoConst.CURRENT_SELECTED_INDEX");
        this.jdField_a_of_type_Aggs.jdField_b_of_type_Boolean = paramIntent.getBooleanExtra("PhotoConst.HANDLE_DEST_RESULT", false);
        this.jdField_a_of_type_Aggs.jdField_c_of_type_Boolean = paramIntent.getBooleanExtra("PhotoConst.SHOULD_SEND_RAW_PHOTO", false);
        if (!this.jdField_a_of_type_Aggs.jdField_d_of_type_Boolean) {
          this.jdField_a_of_type_Aggs.jdField_d_of_type_Boolean = paramIntent.getBooleanExtra("PhotoConst.SHOW_MAGIC_USE_PASTER", false);
        }
        if ("FROM_QZONE_PHOTO_LIST".equals(this.jdField_a_of_type_Aggs.jdField_a_of_type_JavaLangString)) {
          this.jdField_a_of_type_Aggs.jdField_d_of_type_Boolean = false;
        }
        if (this.jdField_a_of_type_Aggs.jdField_d_of_type_Boolean)
        {
          this.jdField_a_of_type_Aggs.jdField_f_of_type_JavaUtilHashMap = ((HashMap)paramIntent.getSerializableExtra("PasterConstants.pasters_data"));
          this.jdField_a_of_type_Aggs.jdField_e_of_type_JavaLangString = paramIntent.getStringExtra("PasterConstants.paster_id");
          this.jdField_a_of_type_Aggs.jdField_f_of_type_JavaLangString = paramIntent.getStringExtra("PasterConstants.paster_cate_id");
        }
        this.jdField_a_of_type_Aggs.jdField_a_of_type_Int = paramIntent.getIntExtra("uintype", -1);
        this.jdField_a_of_type_Aggs.jdField_g_of_type_Boolean = paramIntent.getBooleanExtra("PhotoConst.IS_CALL_IN_PLUGIN", false);
        this.jdField_a_of_type_Aggs.jdField_h_of_type_Boolean = paramIntent.getBooleanExtra("PhotoConst.IS_SINGLE_DERECTBACK_MODE", false);
        this.jdField_a_of_type_Aggs.jdField_c_of_type_Int = paramIntent.getIntExtra("PhotoConst.CURRENT_QUALITY_TYPE", 0);
        this.jdField_a_of_type_Aggs.p = paramIntent.getBooleanExtra("PhotoConst.SEND_FLAG", false);
        if (this.jdField_a_of_type_Aggs.p)
        {
          paramIntent.removeExtra("PhotoConst.SEND_FLAG");
          localObject = PresendPicMgr.a(null);
          if (localObject != null)
          {
            if (QLog.isColorLevel()) {
              QLog.d("PhotoPreviewActivity", 2, "Photo+ send pic,cancel presend!");
            }
            ((PresendPicMgr)localObject).a(1003);
          }
          PhotoUtils.a((Activity)this.jdField_a_of_type_MqqUtilWeakReference.get(), paramIntent, this.jdField_a_of_type_Aggf.jdField_a_of_type_JavaUtilArrayList, this.jdField_a_of_type_Aggs.jdField_c_of_type_Int, true);
        }
        this.jdField_a_of_type_Aggs.jdField_c_of_type_JavaLangString = paramIntent.getStringExtra("PhotoConst.CUSTOM_SENDBTN_TEXT");
      }
      this.jdField_a_of_type_Aggs.jdField_i_of_type_Int = paramIntent.getIntExtra("key_pic_to_edit_from", 0);
      return;
      this.jdField_a_of_type_Aggs.jdField_a_of_type_JavaUtilArrayList = paramIntent.getStringArrayListExtra("PhotoConst.PHOTO_PATHS");
      if (this.jdField_a_of_type_Aggs.jdField_a_of_type_JavaUtilArrayList == null)
      {
        this.jdField_a_of_type_Aggs.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
        this.jdField_a_of_type_Aggs.jdField_a_of_type_JavaUtilArrayList.addAll(this.jdField_a_of_type_Aggf.jdField_a_of_type_JavaUtilArrayList);
      }
      localObject = paramIntent.getStringExtra("PhotoConst.SINGLE_PHOTO_PATH");
      if ((localObject != null) && (!((String)localObject).equals("")))
      {
        this.jdField_a_of_type_Aggs.jdField_a_of_type_JavaUtilArrayList.clear();
        this.jdField_a_of_type_Aggs.jdField_a_of_type_JavaUtilArrayList.add(localObject);
      }
      localObject = this.jdField_a_of_type_Aggs.jdField_a_of_type_JavaUtilArrayList.iterator();
      while (((Iterator)localObject).hasNext())
      {
        String str = (String)((Iterator)localObject).next();
        if ((!this.jdField_a_of_type_Aggs.q) || (!NewPhotoPreviewActivity.a(str))) {
          if (str != null)
          {
            if (!new File(str).exists()) {
              ((Iterator)localObject).remove();
            }
          }
          else {
            ((Iterator)localObject).remove();
          }
        }
      }
      if (this.jdField_a_of_type_Aggf.jdField_a_of_type_JavaUtilArrayList == null) {
        this.jdField_a_of_type_Aggf.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
      }
      for (;;)
      {
        this.jdField_a_of_type_Aggf.jdField_a_of_type_JavaUtilArrayList.addAll(this.jdField_a_of_type_Aggs.jdField_a_of_type_JavaUtilArrayList);
        this.jdField_a_of_type_Aggf.jdField_b_of_type_JavaUtilArrayList.clear();
        if (this.jdField_a_of_type_Aggs.o) {
          break;
        }
        i = 0;
        while (i < this.jdField_a_of_type_Aggs.jdField_a_of_type_JavaUtilArrayList.size())
        {
          this.jdField_a_of_type_Aggf.jdField_b_of_type_JavaUtilArrayList.add(Integer.valueOf(i));
          i += 1;
        }
        this.jdField_a_of_type_Aggf.jdField_a_of_type_JavaUtilArrayList.clear();
      }
    }
  }
  
  protected void a(View paramView)
  {
    ((NewPhotoPreviewActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).getResources();
    paramView = PresendPicMgr.a(null);
    int i = ((NewPhotoPreviewActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).a();
    if (this.jdField_a_of_type_Aggf.jdField_b_of_type_JavaUtilArrayList.contains(Integer.valueOf(i)))
    {
      ((NewPhotoPreviewActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).jdField_a_of_type_ComTencentMobileqqWidgetNumberCheckBox.setChecked(false);
      int j = this.jdField_a_of_type_Aggf.jdField_b_of_type_JavaUtilArrayList.indexOf(Integer.valueOf(i));
      if (j >= 0)
      {
        this.jdField_a_of_type_Aggf.jdField_b_of_type_JavaUtilArrayList.remove(j);
        if (i != -1)
        {
          this.jdField_a_of_type_Aggf.jdField_a_of_type_JavaUtilArrayList.remove(this.jdField_a_of_type_Aggs.jdField_a_of_type_JavaUtilArrayList.get(i));
          if (this.jdField_a_of_type_Aggs.jdField_e_of_type_JavaUtilHashMap != null) {
            this.jdField_a_of_type_Aggs.jdField_e_of_type_JavaUtilHashMap.remove(this.jdField_a_of_type_Aggs.jdField_a_of_type_JavaUtilArrayList.get(i));
          }
          if (this.jdField_a_of_type_Aggs.jdField_c_of_type_JavaUtilHashMap != null) {
            this.jdField_a_of_type_Aggs.jdField_c_of_type_JavaUtilHashMap.remove(this.jdField_a_of_type_Aggs.jdField_a_of_type_JavaUtilArrayList.get(i));
          }
          if (paramView != null) {
            paramView.b((String)this.jdField_a_of_type_Aggs.jdField_a_of_type_JavaUtilArrayList.get(i), 1014);
          }
        }
      }
      c();
      if ((this.jdField_a_of_type_Aggf.jdField_b_of_type_JavaUtilArrayList.size() == 0) && (!this.jdField_a_of_type_Aggs.jdField_k_of_type_Boolean)) {
        this.jdField_a_of_type_Aggs.m = false;
      }
    }
    for (;;)
    {
      if ((this.jdField_a_of_type_Aggf.a()) && (i != -1)) {
        ((NewPhotoPreviewActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).b((String)this.jdField_a_of_type_Aggs.jdField_a_of_type_JavaUtilArrayList.get(i));
      }
      LpReportInfo_pf00064.allReport(603, 2);
      Object localObject;
      LocalMediaInfo localLocalMediaInfo;
      do
      {
        return;
        if (this.jdField_a_of_type_Aggf.jdField_a_of_type_JavaUtilArrayList.size() >= this.jdField_a_of_type_Aggf.jdField_a_of_type_Int)
        {
          long l = System.currentTimeMillis();
          if (l - this.jdField_a_of_type_Aggs.jdField_a_of_type_Long >= 700L)
          {
            bbmy.a((Context)this.jdField_a_of_type_MqqUtilWeakReference.get(), ((NewPhotoPreviewActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).a(), 1000).b(this.jdField_a_of_type_Aggs.jdField_b_of_type_Int);
            this.jdField_a_of_type_Aggs.jdField_a_of_type_Long = l;
            if (this.jdField_a_of_type_Aggs.n) {
              awqx.b(null, "CliOper", "", "", "0x80083EC", "0x80083EC", 0, 0, "", "", "", "");
            }
          }
          ((NewPhotoPreviewActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).jdField_a_of_type_ComTencentMobileqqWidgetNumberCheckBox.setChecked(false);
          return;
        }
        if (i == -1) {
          break;
        }
        localObject = (String)this.jdField_a_of_type_Aggs.jdField_a_of_type_JavaUtilArrayList.get(i);
        localLocalMediaInfo = ((NewPhotoPreviewActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).b((String)localObject);
      } while ((this.jdField_a_of_type_Aggs.jdField_c_of_type_Int == 2) && (c()));
      if ((this.jdField_a_of_type_Aggf.a()) && (!biys.a((Activity)this.jdField_a_of_type_MqqUtilWeakReference.get(), localLocalMediaInfo)))
      {
        ((NewPhotoPreviewActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).jdField_a_of_type_ComTencentMobileqqWidgetNumberCheckBox.setChecked(false);
        return;
      }
      if ((((NewPhotoPreviewActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).getIntent().getBooleanExtra("PhotoConst.IS_SEND_GIF_SIZE_LIMIT", false)) && (atra.a((String)localObject)) && (bace.a((String)localObject) > 3145728L))
      {
        bbmy.a((Context)this.jdField_a_of_type_MqqUtilWeakReference.get(), "图片文件过大", 0).b(this.jdField_a_of_type_Aggs.jdField_b_of_type_Int);
        ((NewPhotoPreviewActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).jdField_a_of_type_ComTencentMobileqqWidgetNumberCheckBox.setChecked(false);
        return;
      }
      if ((paramView != null) && (!this.jdField_a_of_type_Aggs.jdField_k_of_type_Boolean) && (((NewPhotoPreviewActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).a((String)this.jdField_a_of_type_Aggs.jdField_a_of_type_JavaUtilArrayList.get(i)) != 1)) {
        paramView.a((String)this.jdField_a_of_type_Aggs.jdField_a_of_type_JavaUtilArrayList.get(i), this.jdField_a_of_type_Aggs.jdField_j_of_type_Int);
      }
      paramView = (String)this.jdField_a_of_type_Aggs.jdField_a_of_type_JavaUtilArrayList.get(i);
      this.jdField_a_of_type_Aggf.jdField_a_of_type_JavaUtilArrayList.add(paramView);
      if (this.jdField_a_of_type_Aggs.jdField_b_of_type_JavaUtilHashMap != null)
      {
        localObject = (PhotoSendParams)this.jdField_a_of_type_Aggs.jdField_b_of_type_JavaUtilHashMap.get(paramView);
        if ((this.jdField_a_of_type_Aggs.jdField_c_of_type_JavaUtilHashMap != null) && (localObject != null)) {
          this.jdField_a_of_type_Aggs.jdField_c_of_type_JavaUtilHashMap.put(paramView, localObject);
        }
      }
      if (this.jdField_a_of_type_Aggs.jdField_d_of_type_JavaUtilHashMap != null)
      {
        localObject = (PicInfo)this.jdField_a_of_type_Aggs.jdField_d_of_type_JavaUtilHashMap.get(paramView);
        if ((this.jdField_a_of_type_Aggs.jdField_e_of_type_JavaUtilHashMap != null) && (localObject != null)) {
          this.jdField_a_of_type_Aggs.jdField_e_of_type_JavaUtilHashMap.put(paramView, localObject);
        }
      }
      this.jdField_a_of_type_Aggf.jdField_b_of_type_JavaUtilArrayList.add(Integer.valueOf(i));
      if (this.jdField_a_of_type_Aggf.a())
      {
        if (this.jdField_a_of_type_Aggf.jdField_a_of_type_JavaUtilHashMap == null) {
          this.jdField_a_of_type_Aggf.jdField_a_of_type_JavaUtilHashMap = new HashMap();
        }
        localObject = ((NewPhotoPreviewActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).b(paramView);
        this.jdField_a_of_type_Aggf.jdField_a_of_type_JavaUtilHashMap.put(paramView, localObject);
      }
      ((NewPhotoPreviewActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).c(paramView);
      c();
    }
  }
  
  protected void a(View paramView, int paramInt1, Bundle paramBundle, int paramInt2, Intent paramIntent)
  {
    int i = ((NewPhotoPreviewActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).a();
    if (i != -1) {
      this.jdField_a_of_type_Aggs.jdField_b_of_type_JavaLangString = ((String)this.jdField_a_of_type_Aggs.jdField_a_of_type_JavaUtilArrayList.get(i));
    }
    if (this.jdField_a_of_type_Aggs.jdField_b_of_type_JavaLangString != null)
    {
      awqx.b(null, "CliOper", "", "", "0x8004B39", "0x8004B39", 0, 0, "", "", "", "");
      if (this.jdField_a_of_type_Aggs.jdField_d_of_type_Boolean)
      {
        paramView = paramIntent;
        if (paramIntent == null) {
          paramView = EditPicActivity.a((Activity)this.jdField_a_of_type_MqqUtilWeakReference.get(), this.jdField_a_of_type_Aggs.jdField_b_of_type_JavaLangString, true, true, true, true, true, paramInt2, 99, 4, paramBundle);
        }
        paramView.putExtra("PhotoConst.CURRENT_QUALITY_TYPE", this.jdField_a_of_type_Aggs.jdField_c_of_type_Int);
        if (!this.jdField_a_of_type_Aggs.jdField_k_of_type_Boolean) {
          break label386;
        }
        paramView.putExtra("PhotoConst.SEND_BUSINESS_TYPE", 1040);
        if (paramInt1 != -1) {
          break label404;
        }
        ((NewPhotoPreviewActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).startActivity(paramView);
        label191:
        ((NewPhotoPreviewActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).jdField_a_of_type_AndroidWidgetButton.setClickable(false);
        paramView = ((NewPhotoPreviewActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).getIntent();
        if ((paramView != null) && (paramView.hasExtra("custom_photopreview_editbtn_reportActionName")))
        {
          paramView = paramView.getStringExtra("custom_photopreview_editbtn_reportActionName");
          if (paramView != null) {
            awqx.b(null, "CliOper", "", "", paramView, paramView, 0, 0, "", "", "", "");
          }
        }
        if ((a()) && (this.jdField_a_of_type_Aggs.jdField_i_of_type_Int > 0))
        {
          paramInt2 = this.jdField_a_of_type_Aggs.jdField_i_of_type_Int;
          paramView = new StringBuilder();
          if (this.jdField_a_of_type_Aggf.jdField_a_of_type_JavaUtilArrayList == null) {
            break label422;
          }
        }
      }
    }
    label386:
    label404:
    label422:
    for (paramInt1 = this.jdField_a_of_type_Aggf.jdField_a_of_type_JavaUtilArrayList.size();; paramInt1 = 0)
    {
      awqx.b(null, "dc00898", "", "", "0X800A06D", "0X800A06D", paramInt2, 0, paramInt1 + "", "", "", "");
      LpReportInfo_pf00064.allReport(603, 4, 1);
      return;
      paramView.putExtra("PhotoConst.SEND_BUSINESS_TYPE", this.jdField_a_of_type_Aggs.jdField_e_of_type_Int);
      break;
      ((NewPhotoPreviewActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).startActivityForResult(paramView, paramInt1);
      break label191;
    }
  }
  
  protected void a(TextView paramTextView)
  {
    Object localObject1 = ((NewPhotoPreviewActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).getResources();
    Object localObject2 = this.jdField_a_of_type_Aggf.jdField_a_of_type_JavaUtilArrayList.iterator();
    while (((Iterator)localObject2).hasNext())
    {
      String str = (String)((Iterator)localObject2).next();
      if ((!NetworkUtils.isNetworkUrl(str)) && (((NewPhotoPreviewActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).a(str) == 1)) {
        paramTextView.setText(((Resources)localObject1).getString(2131629435));
      }
    }
    int i = baaf.a(this.jdField_a_of_type_Aggf.jdField_a_of_type_JavaUtilArrayList, this.jdField_a_of_type_Aggf.jdField_b_of_type_JavaUtilHashMap, false, this.jdField_a_of_type_Aggs.jdField_c_of_type_JavaUtilHashMap, this.jdField_a_of_type_Aggf.jdField_a_of_type_JavaUtilHashMap);
    localObject2 = PhotoUtils.a((Context)this.jdField_a_of_type_MqqUtilWeakReference.get(), i);
    if ((this.jdField_a_of_type_Aggf.jdField_a_of_type_JavaUtilArrayList.size() == 0) || (((String)localObject2).equals("0"))) {}
    for (localObject1 = ((Resources)localObject1).getString(2131629435);; localObject1 = ((Resources)localObject1).getString(2131629435) + "(共" + (String)localObject2 + ")")
    {
      paramTextView.setText((CharSequence)localObject1);
      return;
    }
  }
  
  protected void a(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    if (QLog.isColorLevel()) {
      QLog.d("PhotoPreviewActivity", 2, " onItemSelected position=" + paramInt);
    }
    String str = ((NewPhotoPreviewActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).jdField_a_of_type_Aggc.a(paramInt);
    if (((NewPhotoPreviewActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).a(str) == 1)
    {
      if (((NewPhotoPreviewActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).jdField_a_of_type_Agew != null)
      {
        agfe localagfe = new agfe();
        localagfe.jdField_a_of_type_Boolean = false;
        localagfe.jdField_a_of_type_JavaLangString = str;
        ((NewPhotoPreviewActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).jdField_a_of_type_Agew.a(paramAdapterView, localagfe);
      }
      if (paramView != null)
      {
        ((NewPhotoPreviewActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131306223));
        ((NewPhotoPreviewActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
      }
    }
    try
    {
      for (;;)
      {
        ((NewPhotoPreviewActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).jdField_a_of_type_ComTencentWidgetDragView.setOriginRect(((NewPhotoPreviewActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).b((String)this.jdField_a_of_type_Aggs.jdField_a_of_type_JavaUtilArrayList.get(paramInt)).thumbRect);
        if (!this.jdField_a_of_type_Aggf.a()) {
          break;
        }
        if (str != null) {
          ((NewPhotoPreviewActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).c(str);
        }
        c();
        if (!this.jdField_a_of_type_Aggs.jdField_i_of_type_Boolean)
        {
          if (this.jdField_a_of_type_Aggs.jdField_a_of_type_JavaUtilArrayList.size() <= 1) {
            break label543;
          }
          ((NewPhotoPreviewActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).d.setText(paramInt + 1 + " / " + this.jdField_a_of_type_Aggs.jdField_a_of_type_JavaUtilArrayList.size());
        }
        if ((((NewPhotoPreviewActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).a(str) == 1) && (!this.jdField_a_of_type_Aggs.jdField_a_of_type_Boolean)) {
          ((NewPhotoPreviewActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).d();
        }
        if (this.jdField_a_of_type_Aggf.a()) {
          ((NewPhotoPreviewActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).b((String)this.jdField_a_of_type_Aggs.jdField_a_of_type_JavaUtilArrayList.get(paramInt));
        }
        return;
        if (((NewPhotoPreviewActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).jdField_a_of_type_Agew != null) {
          ((NewPhotoPreviewActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).jdField_a_of_type_Agew.a(null, null);
        }
      }
    }
    catch (Exception paramAdapterView)
    {
      for (;;)
      {
        if (QLog.isColorLevel())
        {
          QLog.d("PhotoPreviewActivity", 2, befj.a(paramAdapterView));
          continue;
          if (this.jdField_a_of_type_Aggf.jdField_b_of_type_JavaUtilArrayList.contains(Integer.valueOf(paramInt)))
          {
            if (str != null) {
              ((NewPhotoPreviewActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).c(str);
            } else {
              ((NewPhotoPreviewActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).jdField_a_of_type_ComTencentMobileqqWidgetNumberCheckBox.setChecked(false);
            }
          }
          else
          {
            ((NewPhotoPreviewActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).jdField_a_of_type_ComTencentMobileqqWidgetNumberCheckBox.setChecked(false);
            continue;
            label543:
            ((NewPhotoPreviewActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).d.setText(((NewPhotoPreviewActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).getResources().getString(2131629655));
          }
        }
      }
    }
  }
  
  public void a(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_Aggs.jdField_e_of_type_Boolean) {
      vhg.a().a(vhg.a().c());
    }
    Intent localIntent1 = ((NewPhotoPreviewActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).getIntent();
    localIntent1.putExtra("PhotoConst.SEND_BUSINESS_TYPE", this.jdField_a_of_type_Aggs.jdField_e_of_type_Int);
    if ("FROM_PHOTO_LIST".equals(this.jdField_a_of_type_Aggs.jdField_a_of_type_JavaLangString))
    {
      localIntent1.setClass((Context)this.jdField_a_of_type_MqqUtilWeakReference.get(), NewPhotoListActivity.class);
      localIntent1.putExtra("PhotoConst.CURRENT_QUALITY_TYPE", this.jdField_a_of_type_Aggs.jdField_c_of_type_Int);
      if (this.jdField_a_of_type_Aggs.o) {
        localIntent1.removeExtra("PhotoConst.PHOTO_PATHS");
      }
    }
    for (;;)
    {
      localIntent1.putExtra("PhotoConst.PHOTO_PATHS_FROM_QZONEALBUM", this.jdField_a_of_type_Aggs.jdField_c_of_type_JavaUtilHashMap);
      localIntent1.putExtra("PhotoConst.PHOTO_INFOS", this.jdField_a_of_type_Aggs.jdField_e_of_type_JavaUtilHashMap);
      ((NewPhotoPreviewActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).startActivity(localIntent1);
      label161:
      if (localIntent1.getBooleanExtra("keep_selected_status_after_finish", false))
      {
        localIntent1 = new Intent();
        localIntent1.putStringArrayListExtra("PhotoConst.SELECTED_PATHS", this.jdField_a_of_type_Aggf.jdField_a_of_type_JavaUtilArrayList);
        localIntent1.putIntegerArrayListExtra("PhotoConst.SELECTED_INDEXS", this.jdField_a_of_type_Aggf.jdField_b_of_type_JavaUtilArrayList);
        localIntent1.putExtra("PhotoConst.CURRENT_QUALITY_TYPE", this.jdField_a_of_type_Aggs.jdField_c_of_type_Int);
        localIntent1.putExtra("PhotoConst.editPathMap", this.jdField_a_of_type_Aggs.jdField_a_of_type_JavaUtilHashMap);
        ((NewPhotoPreviewActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).setResult(-1, localIntent1);
      }
      ((NewPhotoPreviewActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).finish();
      if (paramBoolean) {
        try
        {
          ((NewPhotoPreviewActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).overridePendingTransition(2130772036, 2130772038);
          return;
          localIntent1.putStringArrayListExtra("PhotoConst.PHOTO_PATHS", this.jdField_a_of_type_Aggf.jdField_a_of_type_JavaUtilArrayList);
          localIntent1.putExtra("PhotoConst.editPathMap", this.jdField_a_of_type_Aggs.jdField_a_of_type_JavaUtilHashMap);
          continue;
          if (!"FROM_QZONE_PHOTO_LIST".equals(this.jdField_a_of_type_Aggs.jdField_a_of_type_JavaLangString)) {
            break label161;
          }
          Intent localIntent2 = new Intent();
          localIntent2.putStringArrayListExtra("PhotoConst.PHOTO_PATHS", this.jdField_a_of_type_Aggf.jdField_a_of_type_JavaUtilArrayList);
          localIntent2.putExtra("PhotoConst.PHOTO_PATHS_FROM_QZONEALBUM", this.jdField_a_of_type_Aggs.jdField_c_of_type_JavaUtilHashMap);
          localIntent2.putExtra("PhotoConst.CURRENT_QUALITY_TYPE", this.jdField_a_of_type_Aggs.jdField_c_of_type_Int);
          localIntent2.putExtra("PeakConstants.selectedMediaInfoHashMap", this.jdField_a_of_type_Aggf.jdField_a_of_type_JavaUtilHashMap);
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
    baaf.a((Activity)this.jdField_a_of_type_MqqUtilWeakReference.get(), true, false);
  }
  
  public boolean a()
  {
    return false;
  }
  
  protected void b()
  {
    int j = 1;
    int k = 0;
    Object localObject1 = ((NewPhotoPreviewActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).getResources();
    ((NewPhotoPreviewActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).jdField_a_of_type_Int = ((Resources)localObject1).getDisplayMetrics().widthPixels;
    ((NewPhotoPreviewActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).jdField_b_of_type_Int = ((Resources)localObject1).getDisplayMetrics().heightPixels;
    ((NewPhotoPreviewActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).jdField_a_of_type_AndroidViewSurfaceView = ((SurfaceView)((NewPhotoPreviewActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).findViewById(2131301293));
    ((NewPhotoPreviewActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).jdField_a_of_type_AndroidViewSurfaceView.setVisibility(8);
    ((NewPhotoPreviewActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).ac = true;
    ((NewPhotoPreviewActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).ad = false;
    ((NewPhotoPreviewActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).jdField_c_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)((NewPhotoPreviewActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).findViewById(2131309737));
    ((NewPhotoPreviewActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).jdField_a_of_type_ComTencentWidgetDragView = ((DragView)((NewPhotoPreviewActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).findViewById(2131299824));
    ((NewPhotoPreviewActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).jdField_a_of_type_ComTencentWidgetDragView.setGestureChangeListener((beij)this.jdField_a_of_type_MqqUtilWeakReference.get());
    ((NewPhotoPreviewActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).jdField_a_of_type_ComTencentWidgetDragView.setRatioModify(true);
    Object localObject2 = (Rect)((NewPhotoPreviewActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).getIntent().getParcelableExtra("KEY_THUMBNAL_BOUND");
    int i;
    label426:
    label942:
    label969:
    float f;
    if (localObject2 != null) {
      if (((NewPhotoPreviewActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).jdField_a_of_type_Boolean)
      {
        i = bjeh.jdField_a_of_type_Int;
        ((Rect)localObject2).top -= i;
        ((Rect)localObject2).bottom -= i;
        if ((this.jdField_a_of_type_Aggs.jdField_a_of_type_JavaUtilArrayList != null) && (-1 != this.jdField_a_of_type_Aggs.jdField_k_of_type_Int) && (this.jdField_a_of_type_Aggs.jdField_a_of_type_JavaUtilArrayList.get(this.jdField_a_of_type_Aggs.jdField_k_of_type_Int) != null))
        {
          LocalMediaInfo localLocalMediaInfo = ((NewPhotoPreviewActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).b((String)this.jdField_a_of_type_Aggs.jdField_a_of_type_JavaUtilArrayList.get(this.jdField_a_of_type_Aggs.jdField_k_of_type_Int));
          if (localLocalMediaInfo != null) {
            localLocalMediaInfo.thumbRect = ((Rect)localObject2);
          }
        }
        ((NewPhotoPreviewActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).jdField_a_of_type_ComTencentWidgetDragView.setOriginRect((Rect)localObject2);
        ((NewPhotoPreviewActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).jdField_a_of_type_AndroidViewView = ((NewPhotoPreviewActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).findViewById(2131311739);
        ((NewPhotoPreviewActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).jdField_b_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)((NewPhotoPreviewActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).findViewById(2131297793));
        if (this.jdField_a_of_type_Aggs.jdField_a_of_type_Boolean)
        {
          ((NewPhotoPreviewActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).jdField_a_of_type_AndroidViewView.setVisibility(0);
          if (!this.jdField_a_of_type_Aggf.a()) {
            break label2233;
          }
          ((NewPhotoPreviewActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).jdField_b_of_type_AndroidWidgetRelativeLayout.setVisibility(4);
        }
        label541:
        ((NewPhotoPreviewActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).jdField_a_of_type_AndroidWidgetButton = ((Button)((NewPhotoPreviewActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).findViewById(2131304039));
        ((NewPhotoPreviewActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).jdField_a_of_type_AndroidWidgetCheckBox = ((CheckBox)((NewPhotoPreviewActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).findViewById(2131300753));
        ((NewPhotoPreviewActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).jdField_a_of_type_AndroidWidgetTextView = ((TextView)((NewPhotoPreviewActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).findViewById(2131300754));
        ((NewPhotoPreviewActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).jdField_b_of_type_AndroidWidgetCheckBox = ((CheckBox)((NewPhotoPreviewActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).findViewById(2131307749));
        ((NewPhotoPreviewActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).jdField_b_of_type_AndroidWidgetTextView = ((TextView)((NewPhotoPreviewActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).findViewById(2131307755));
        if ((this.jdField_a_of_type_Aggs.jdField_j_of_type_Boolean) && (this.jdField_a_of_type_Aggs.jdField_e_of_type_JavaUtilHashMap.size() == 0))
        {
          ((NewPhotoPreviewActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).jdField_a_of_type_AndroidWidgetCheckBox.setVisibility(0);
          ((NewPhotoPreviewActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
          ((NewPhotoPreviewActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).jdField_a_of_type_AndroidWidgetCheckBox.setOnCheckedChangeListener((CompoundButton.OnCheckedChangeListener)this.jdField_a_of_type_MqqUtilWeakReference.get());
          ((NewPhotoPreviewActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).jdField_a_of_type_AndroidWidgetTextView.setOnClickListener(new aggy(this));
          ((NewPhotoPreviewActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).jdField_a_of_type_AndroidWidgetCheckBox.setContentDescription("闪照");
          ((NewPhotoPreviewActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).jdField_a_of_type_AndroidWidgetTextView.setContentDescription("闪照");
        }
        ((NewPhotoPreviewActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).jdField_b_of_type_AndroidWidgetCheckBox.setOnCheckedChangeListener((CompoundButton.OnCheckedChangeListener)this.jdField_a_of_type_MqqUtilWeakReference.get());
        ((NewPhotoPreviewActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).jdField_b_of_type_AndroidWidgetTextView.setOnClickListener(new aggz(this, (Resources)localObject1));
        if (!this.jdField_a_of_type_Aggs.jdField_c_of_type_Boolean) {
          break label2253;
        }
        ((NewPhotoPreviewActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).jdField_b_of_type_AndroidWidgetCheckBox.setVisibility(0);
        ((NewPhotoPreviewActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
        if (!this.jdField_a_of_type_Aggs.jdField_d_of_type_Boolean) {
          break label2292;
        }
        ((NewPhotoPreviewActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).jdField_a_of_type_AndroidWidgetButton.setVisibility(0);
        ((NewPhotoPreviewActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).e = ((TextView)((NewPhotoPreviewActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).findViewById(2131305859));
        ((NewPhotoPreviewActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).jdField_b_of_type_AndroidWidgetButton = ((Button)((NewPhotoPreviewActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).findViewById(2131310076));
        ((NewPhotoPreviewActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).jdField_a_of_type_ComTencentMobileqqWidgetNumberCheckBox = ((NumberCheckBox)((NewPhotoPreviewActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).findViewById(2131310053));
        ((NewPhotoPreviewActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).jdField_b_of_type_AndroidViewView = ((NewPhotoPreviewActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).findViewById(2131310035);
        ((NewPhotoPreviewActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).d = ((TextView)((NewPhotoPreviewActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).findViewById(2131311534));
        if (this.jdField_a_of_type_Aggf.a()) {
          ((NewPhotoPreviewActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).d.setVisibility(8);
        }
        if (this.jdField_a_of_type_Aggs.jdField_i_of_type_Boolean) {
          ((NewPhotoPreviewActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).d.setVisibility(8);
        }
        ((NewPhotoPreviewActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).jdField_b_of_type_AndroidViewView.setOnClickListener(new agha(this));
        ((NewPhotoPreviewActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).jdField_c_of_type_AndroidWidgetTextView = ((TextView)((NewPhotoPreviewActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).findViewById(2131297456));
        ((NewPhotoPreviewActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).jdField_c_of_type_AndroidWidgetTextView.setOnClickListener(new aghb(this));
        ((NewPhotoPreviewActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).jdField_a_of_type_AndroidWidgetButton.setOnClickListener(new aghc(this));
        ((NewPhotoPreviewActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).jdField_b_of_type_AndroidWidgetButton.setOnClickListener(new aghd(this));
        ((NewPhotoPreviewActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).jdField_a_of_type_ComTencentMobileqqActivityPhotoDragGallery = ((DragGallery)((NewPhotoPreviewActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).findViewById(2131301286));
        ((NewPhotoPreviewActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).jdField_a_of_type_ComTencentMobileqqActivityPhotoDragGallery.setSupportMatchParent(true);
        ((NewPhotoPreviewActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).jdField_a_of_type_ComTencentMobileqqActivityPhotoDragGallery.setAdapter(((NewPhotoPreviewActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).jdField_a_of_type_Aggc);
        ((NewPhotoPreviewActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).jdField_a_of_type_ComTencentMobileqqActivityPhotoDragGallery.setOnNoBlankListener(((NewPhotoPreviewActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).jdField_a_of_type_Aggc);
        ((NewPhotoPreviewActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).jdField_a_of_type_ComTencentMobileqqActivityPhotoDragGallery.setOnItemSelectedListener(new aghf(this));
        ((NewPhotoPreviewActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).jdField_a_of_type_ComTencentMobileqqActivityPhotoDragGallery.setSpacing(((NewPhotoPreviewActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).getResources().getDimensionPixelSize(2131165934));
        if (this.jdField_a_of_type_Aggs.jdField_k_of_type_Int != -1) {
          ((NewPhotoPreviewActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).jdField_a_of_type_ComTencentMobileqqActivityPhotoDragGallery.setSelection(this.jdField_a_of_type_Aggs.jdField_k_of_type_Int);
        }
        c();
        if ((this.jdField_a_of_type_Aggs.jdField_h_of_type_Boolean) || (this.jdField_a_of_type_Aggs.o))
        {
          ((NewPhotoPreviewActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).jdField_a_of_type_ComTencentMobileqqWidgetNumberCheckBox.setVisibility(8);
          ((NewPhotoPreviewActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).jdField_b_of_type_AndroidViewView.setVisibility(8);
          ((NewPhotoPreviewActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).jdField_b_of_type_AndroidWidgetCheckBox.setVisibility(8);
          ((NewPhotoPreviewActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
        }
        ((NewPhotoPreviewActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).jdField_a_of_type_ComTencentMobileqqActivityPhotoDragGallery.setOnItemClickListener(new aghg(this));
        ((NewPhotoPreviewActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).e.setOnClickListener(new aghh(this));
        if (this.jdField_a_of_type_Aggs.o) {
          ((NewPhotoPreviewActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).e.setVisibility(0);
        }
        if (!this.jdField_a_of_type_Aggf.a()) {
          break label2313;
        }
        ((NewPhotoPreviewActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).jdField_c_of_type_AndroidWidgetTextView.setText("");
        label1710:
        if (this.jdField_a_of_type_Aggs.jdField_a_of_type_Int == 1001)
        {
          ((NewPhotoPreviewActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).jdField_b_of_type_AndroidWidgetCheckBox.setVisibility(8);
          ((NewPhotoPreviewActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
        }
        ((NewPhotoPreviewActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).jdField_a_of_type_ComTencentWidgetHorizontalListView = ((HorizontalListView)((NewPhotoPreviewActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).findViewById(2131300881));
        ((NewPhotoPreviewActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).jdField_c_of_type_AndroidViewView = ((NewPhotoPreviewActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).findViewById(2131300879);
        ((NewPhotoPreviewActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).jdField_a_of_type_Aggd = new aggd((NewPhotoPreviewActivity)this.jdField_a_of_type_MqqUtilWeakReference.get());
        ((NewPhotoPreviewActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).jdField_a_of_type_Aggd.a(this.jdField_a_of_type_Aggf.jdField_a_of_type_JavaUtilArrayList);
        ((NewPhotoPreviewActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).jdField_a_of_type_ComTencentWidgetHorizontalListView.setAdapter(((NewPhotoPreviewActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).jdField_a_of_type_Aggd);
        ((NewPhotoPreviewActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).jdField_a_of_type_ComTencentWidgetHorizontalListView.setOnItemClickListener(((NewPhotoPreviewActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).jdField_a_of_type_Aggd);
        if (a())
        {
          ((NewPhotoPreviewActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).jdField_a_of_type_ComTencentWidgetHorizontalListView.setVisibility(0);
          ((NewPhotoPreviewActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).jdField_c_of_type_AndroidViewView.setVisibility(0);
        }
        f = 16.0F / ajia.a();
        i = j;
        if (((NewPhotoPreviewActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).getResources().getDisplayMetrics().densityDpi >= 400)
        {
          if (Build.VERSION.SDK_INT > 21) {
            break label2352;
          }
          i = j;
        }
        label2017:
        if ((f >= 1.0F) && (i == 0)) {
          break label2398;
        }
        if (i == 0) {
          break label2524;
        }
        f = 0.7F * f;
      }
    }
    label2097:
    label2233:
    label2253:
    label2524:
    for (;;)
    {
      j = k;
      if (QLog.isColorLevel())
      {
        QLog.d("PhotoPreviewActivity", 2, "need scale,reqWidth:" + ((NewPhotoPreviewActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).jdField_a_of_type_Int + " scale:" + f);
        j = k;
      }
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
          break label2097;
          i = 0;
          break;
          ((NewPhotoPreviewActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).jdField_a_of_type_ComTencentWidgetDragView.setEnableDrag(false);
          break label426;
          ((NewPhotoPreviewActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).jdField_b_of_type_AndroidWidgetRelativeLayout.setVisibility(0);
          break label541;
          ((NewPhotoPreviewActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).jdField_b_of_type_AndroidWidgetCheckBox.setVisibility(8);
          ((NewPhotoPreviewActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
          break label942;
          label2292:
          ((NewPhotoPreviewActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).jdField_a_of_type_AndroidWidgetButton.setVisibility(8);
          break label969;
          if (TextUtils.isEmpty(this.jdField_a_of_type_Aggs.jdField_d_of_type_JavaLangString)) {
            break label1710;
          }
          ((NewPhotoPreviewActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).jdField_c_of_type_AndroidWidgetTextView.setText(this.jdField_a_of_type_Aggs.jdField_d_of_type_JavaLangString);
          break label1710;
          i = 0;
          break label2017;
          ((RelativeLayout.LayoutParams)localObject2).leftMargin = ((int)(((RelativeLayout.LayoutParams)localObject2).leftMargin * f));
          if ((i != 0) && (f < 1.0F)) {
            ((RelativeLayout.LayoutParams)localObject2).leftMargin = ((int)(((RelativeLayout.LayoutParams)localObject2).leftMargin * f));
          }
        }
      }
      label2398:
      if (this.jdField_a_of_type_Aggf.a()) {
        ((NewPhotoPreviewActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).b((String)this.jdField_a_of_type_Aggs.jdField_a_of_type_JavaUtilArrayList.get(((NewPhotoPreviewActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).a()));
      }
      f = ((NewPhotoPreviewActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).getResources().getDisplayMetrics().density;
      aciy.a(((NewPhotoPreviewActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).jdField_a_of_type_AndroidWidgetButton, (int)(10.0F * f + 0.5F), (int)(10.0F * f + 0.5F), (int)(10.0F * f + 0.5F), (int)(f * 10.0F + 0.5F));
      return;
    }
  }
  
  public void b(boolean paramBoolean)
  {
    this.jdField_a_of_type_Aggs.jdField_k_of_type_Boolean = paramBoolean;
    if (paramBoolean)
    {
      this.jdField_a_of_type_Aggs.m = true;
      Object localObject = ((NewPhotoPreviewActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).jdField_b_of_type_AndroidWidgetCheckBox;
      if (!paramBoolean)
      {
        paramBoolean = true;
        ((CheckBox)localObject).setChecked(paramBoolean);
        ((NewPhotoPreviewActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).jdField_b_of_type_AndroidWidgetTextView.setTextColor(2147483647);
        if ((this.jdField_a_of_type_Aggf.jdField_a_of_type_JavaUtilArrayList.isEmpty()) && (((NewPhotoPreviewActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).jdField_a_of_type_ComTencentMobileqqActivityPhotoDragGallery.getFirstVisiblePosition() < this.jdField_a_of_type_Aggs.jdField_a_of_type_JavaUtilArrayList.size()))
        {
          ((NewPhotoPreviewActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).jdField_b_of_type_AndroidViewView.performClick();
          c();
        }
        if ((this.jdField_a_of_type_Aggs.jdField_l_of_type_Boolean) && (((NewPhotoPreviewActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).jdField_a_of_type_ComTencentWidgetBubblePopupWindow == null))
        {
          this.jdField_a_of_type_Aggs.jdField_l_of_type_Boolean = false;
          BaseApplicationImpl.getApplication().getSharedPreferences(BaseApplicationImpl.getApplication().getRuntime().getAccount(), 4).edit().putBoolean("showFlashPic", false).commit();
          ((NewPhotoPreviewActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).jdField_a_of_type_ComTencentWidgetBubblePopupWindow = new BubblePopupWindow(-2, -2);
          localObject = new TextView((Context)this.jdField_a_of_type_MqqUtilWeakReference.get());
          int i = aciy.a(10.0F, ((NewPhotoPreviewActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).getResources());
          ((TextView)localObject).setPadding(i, 0, i, 0);
          ((TextView)localObject).setTextColor(-1);
          ((TextView)localObject).setText("选中的图片每人只能查看一次");
          ((TextView)localObject).setTextSize(14.0F);
          ((NewPhotoPreviewActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).jdField_a_of_type_ComTencentWidgetBubblePopupWindow.a((View)localObject);
          ((NewPhotoPreviewActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).jdField_a_of_type_ComTencentWidgetBubblePopupWindow.a(false);
          ((NewPhotoPreviewActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).jdField_a_of_type_ComTencentWidgetBubblePopupWindow.b(((NewPhotoPreviewActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).jdField_a_of_type_AndroidWidgetTextView);
        }
        if (this.jdField_a_of_type_Aggs.jdField_a_of_type_Int != 0) {
          break label398;
        }
        awqx.b(null, "dc00898", "", "", "0X8006997", "0X8006997", 0, 0, "", "", "", "");
      }
    }
    label398:
    do
    {
      do
      {
        return;
        paramBoolean = false;
        break;
        if (this.jdField_a_of_type_Aggs.jdField_a_of_type_Int == 3000)
        {
          awqx.b(null, "dc00898", "", "", "0X8006998", "0X8006998", 0, 0, "", "", "", "");
          return;
        }
      } while (this.jdField_a_of_type_Aggs.jdField_a_of_type_Int != 1);
      awqx.b(null, "dc00898", "", "", "0X8006999", "0X8006999", 0, 0, "", "", "", "");
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
    Object localObject = ((NewPhotoPreviewActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).getResources();
    if (this.jdField_a_of_type_Aggs.jdField_c_of_type_Boolean)
    {
      localObject = ((Resources)localObject).getString(2131629465);
      if (this.jdField_a_of_type_Aggs.jdField_c_of_type_JavaLangString == null) {
        break label748;
      }
      localObject = this.jdField_a_of_type_Aggs.jdField_c_of_type_JavaLangString;
    }
    label79:
    label210:
    label748:
    for (;;)
    {
      int i;
      boolean bool;
      int j;
      if ((this.jdField_a_of_type_Aggf.jdField_a_of_type_JavaUtilArrayList != null) && (this.jdField_a_of_type_Aggf.jdField_a_of_type_JavaUtilArrayList.size() > 0))
      {
        i = 1;
        if (i == 0) {
          break label515;
        }
        if ((!this.jdField_a_of_type_Aggs.jdField_h_of_type_Boolean) && (!this.jdField_a_of_type_Aggs.o)) {
          break label374;
        }
        ((NewPhotoPreviewActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).jdField_b_of_type_AndroidWidgetButton.setEnabled(true);
        ((NewPhotoPreviewActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).jdField_b_of_type_AndroidWidgetButton.setText((CharSequence)localObject);
        bool = this.jdField_a_of_type_Aggf.jdField_b_of_type_JavaUtilArrayList.contains(Integer.valueOf(((NewPhotoPreviewActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).a()));
        if (((NewPhotoPreviewActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).a((String)this.jdField_a_of_type_Aggs.jdField_a_of_type_JavaUtilArrayList.get(((NewPhotoPreviewActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).a())) == 1) {
          break label688;
        }
        j = 1;
        if (((i != 0) && (!bool)) || (j == 0)) {
          break label693;
        }
        ((NewPhotoPreviewActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).jdField_a_of_type_AndroidWidgetButton.setEnabled(true);
      }
      for (;;)
      {
        if (((NewPhotoPreviewActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).jdField_a_of_type_Aggd != null)
        {
          if (!a()) {
            break label713;
          }
          if (((NewPhotoPreviewActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).jdField_a_of_type_ComTencentWidgetHorizontalListView.getVisibility() == 4)
          {
            ((NewPhotoPreviewActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).jdField_c_of_type_AndroidViewView.setVisibility(0);
            ((NewPhotoPreviewActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).jdField_a_of_type_ComTencentWidgetHorizontalListView.setVisibility(0);
          }
          ((NewPhotoPreviewActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).jdField_a_of_type_Aggd.notifyDataSetChanged();
        }
        return;
        if (this.jdField_a_of_type_Aggf.a())
        {
          localObject = ((Resources)localObject).getString(2131633751);
          break;
        }
        localObject = ((Resources)localObject).getString(2131629407);
        break;
        i = 0;
        break label79;
        label374:
        ((NewPhotoPreviewActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).jdField_b_of_type_AndroidWidgetButton.setEnabled(true);
        ((NewPhotoPreviewActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).e();
        Button localButton;
        if (this.jdField_a_of_type_Aggf.a())
        {
          localButton = ((NewPhotoPreviewActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).jdField_b_of_type_AndroidWidgetButton;
          if (this.jdField_a_of_type_Aggf.jdField_a_of_type_JavaUtilArrayList.size() < 2) {
            break label510;
          }
        }
        label510:
        for (bool = true;; bool = false)
        {
          localButton.setEnabled(bool);
          ((NewPhotoPreviewActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).jdField_b_of_type_AndroidWidgetButton.setText((String)localObject + "(" + this.jdField_a_of_type_Aggf.jdField_a_of_type_JavaUtilArrayList.size() + ")");
          break;
        }
        ((NewPhotoPreviewActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).jdField_b_of_type_AndroidWidgetButton.setText((CharSequence)localObject);
        if (this.jdField_a_of_type_Aggf.a()) {
          ((NewPhotoPreviewActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).jdField_b_of_type_AndroidWidgetButton.setEnabled(false);
        }
        ((NewPhotoPreviewActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).jdField_b_of_type_AndroidWidgetCheckBox.setOnCheckedChangeListener(null);
        localObject = ((NewPhotoPreviewActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).jdField_b_of_type_AndroidWidgetCheckBox;
        if (this.jdField_a_of_type_Aggs.jdField_c_of_type_Int == 2) {}
        for (bool = true;; bool = false)
        {
          ((CheckBox)localObject).setChecked(bool);
          ((NewPhotoPreviewActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).jdField_b_of_type_AndroidWidgetCheckBox.setOnCheckedChangeListener((CompoundButton.OnCheckedChangeListener)this.jdField_a_of_type_MqqUtilWeakReference.get());
          if (this.jdField_a_of_type_Aggs.jdField_c_of_type_Int == 2) {
            ((NewPhotoPreviewActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).jdField_b_of_type_AndroidWidgetTextView.setTextColor(-16734752);
          }
          ((NewPhotoPreviewActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).e();
          break;
        }
        j = 0;
        break label210;
        ((NewPhotoPreviewActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).jdField_a_of_type_AndroidWidgetButton.setEnabled(false);
      }
      ((NewPhotoPreviewActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).jdField_c_of_type_AndroidViewView.setVisibility(4);
      ((NewPhotoPreviewActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).jdField_a_of_type_ComTencentWidgetHorizontalListView.setVisibility(4);
      return;
    }
  }
  
  protected boolean c()
  {
    int i = ((NewPhotoPreviewActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).a();
    if ((this.jdField_a_of_type_Aggf.a()) && (i != -1) && (new File((String)this.jdField_a_of_type_Aggs.jdField_a_of_type_JavaUtilArrayList.get(i)).length() > axwv.a()))
    {
      bbmy.a((Context)this.jdField_a_of_type_MqqUtilWeakReference.get(), ((NewPhotoPreviewActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).getResources().getString(2131629431), 0).b(((NewPhotoPreviewActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).getResources().getDimensionPixelSize(2131167766));
      ((NewPhotoPreviewActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).jdField_a_of_type_ComTencentMobileqqWidgetNumberCheckBox.setChecked(false);
      return true;
    }
    return false;
  }
  
  protected void d()
  {
    if ((this.jdField_a_of_type_Aggs.jdField_d_of_type_Boolean) && ((!TextUtils.isEmpty(this.jdField_a_of_type_Aggs.jdField_e_of_type_JavaLangString)) || (!TextUtils.isEmpty(this.jdField_a_of_type_Aggs.jdField_f_of_type_JavaLangString)))) {
      ((NewPhotoPreviewActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).jdField_a_of_type_AndroidWidgetButton.performClick();
    }
    Object localObject3 = ((NewPhotoPreviewActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).a();
    Intent localIntent = ((NewPhotoPreviewActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).getIntent();
    if (localObject3 != null)
    {
      ageh.a(((ArrayList)localObject3).size(), this.jdField_a_of_type_Aggs.jdField_d_of_type_Int);
      ageh.a(localIntent, ((ArrayList)localObject3).size(), this.jdField_a_of_type_Aggs.jdField_c_of_type_Int);
    }
    Object localObject1 = PresendPicMgr.a(null);
    label397:
    String str;
    Object localObject2;
    int i;
    if (this.jdField_a_of_type_Aggs.jdField_c_of_type_Int == 2)
    {
      if ((this.jdField_a_of_type_Aggf.jdField_a_of_type_JavaUtilArrayList.size() == 0) && (((ArrayList)localObject3).size() == 1) && (bace.a((String)((ArrayList)localObject3).get(0)) > axwv.a()))
      {
        bbmy.a((Context)this.jdField_a_of_type_MqqUtilWeakReference.get(), ((NewPhotoPreviewActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).getResources().getString(2131629431), 0).b(((NewPhotoPreviewActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).getResources().getDimensionPixelSize(2131167766));
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
        awqx.b(null, "CliOper", "", "", "0X800515C", "0X800515C", 0, 0, "", "", "", "");
        if (this.jdField_a_of_type_Aggs.jdField_k_of_type_Boolean)
        {
          localIntent.putExtra("PhotoConst.SEND_BUSINESS_TYPE", 1040);
          if (this.jdField_a_of_type_Aggs.jdField_a_of_type_Int != 0) {
            break;
          }
          awqx.b(null, "dc00898", "", "", "0X80069A6", "0X80069A6", 0, 0, "", "", "", "");
          awqx.b(null, "dc00898", "", "", "0X800699A", "0X800699A", 0, 0, "", "", "", "");
        }
        if (this.jdField_a_of_type_Aggs.jdField_b_of_type_Boolean) {
          ((NewPhotoPreviewActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).jdField_a_of_type_AndroidViewView.setVisibility(4);
        }
        if (localObject3 != null) {
          ahji.a((List)localObject3);
        }
        if (this.jdField_a_of_type_Aggf.a()) {
          localIntent.putExtra("PeakConstants.selectedMediaInfoHashMap", this.jdField_a_of_type_Aggf.jdField_a_of_type_JavaUtilHashMap);
        }
        if (this.jdField_a_of_type_Aggs.n)
        {
          localIntent.putExtra("ReceiptMsgManager.EXTRA_KEY_IS_RECEIPT", true);
          localIntent.putExtra("session_info", localIntent.getParcelableExtra("session_info"));
        }
        ((NewPhotoPreviewActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).a(localIntent, false);
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
            awqx.b(null, "CliOper", "", "", str, str, 0, 0, (String)localObject1, "", "", "");
          }
        }
      } while ((!a()) || (this.jdField_a_of_type_Aggs.jdField_i_of_type_Int <= 0));
      localObject1 = ((ArrayList)localObject3).iterator();
      i = 0;
    }
    for (;;)
    {
      if (!((Iterator)localObject1).hasNext()) {
        break label972;
      }
      localObject2 = (String)((Iterator)localObject1).next();
      localObject3 = this.jdField_a_of_type_Aggs.jdField_a_of_type_JavaUtilHashMap.values().iterator();
      for (;;)
      {
        if (((Iterator)localObject3).hasNext())
        {
          str = (String)((Iterator)localObject3).next();
          if ((!TextUtils.isEmpty((CharSequence)localObject2)) && (!TextUtils.isEmpty(str)) && (((String)localObject2).equals(str)))
          {
            i += 1;
            continue;
            if ((localObject1 == null) || (this.jdField_a_of_type_Aggf.jdField_a_of_type_JavaUtilArrayList.size() <= 0) || (this.jdField_a_of_type_Aggs.jdField_k_of_type_Boolean) || (this.jdField_a_of_type_Aggs.m) || (this.jdField_a_of_type_Aggs.n)) {
              break;
            }
            ((PresendPicMgr)localObject1).a(localIntent);
            break;
            if (this.jdField_a_of_type_Aggs.jdField_a_of_type_Int == 3000)
            {
              awqx.b(null, "dc00898", "", "", "0X80069A7", "0X80069A7", 0, 0, "", "", "", "");
              awqx.b(null, "dc00898", "", "", "0X800699B", "0X800699B", 0, 0, "", "", "", "");
              break label397;
            }
            if (this.jdField_a_of_type_Aggs.jdField_a_of_type_Int != 1) {
              break label397;
            }
            awqx.b(null, "dc00898", "", "", "0X80069A8", "0X80069A8", 0, 0, "", "", "", "");
            awqx.b(null, "dc00898", "", "", "0X800699C", "0X800699C", 0, 0, "", "", "", "");
            break label397;
          }
        }
      }
    }
    label972:
    localObject1 = new StringBuilder();
    if (this.jdField_a_of_type_Aggf.jdField_a_of_type_JavaUtilArrayList != null) {}
    for (int j = this.jdField_a_of_type_Aggf.jdField_a_of_type_JavaUtilArrayList.size();; j = 0)
    {
      awqx.b(null, "dc00898", "", "", "0X800A070", "0X800A070", 0, 0, j + "", i + "", "", "");
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     aggx
 * JD-Core Version:    0.7.0.1
 */