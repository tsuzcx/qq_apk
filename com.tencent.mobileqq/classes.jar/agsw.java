import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.v4.util.MQLruCache;
import android.text.TextUtils;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.SurfaceView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.galleryactivity.AbstractImageAdapter.URLImageView2;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.activity.photo.DragGallery;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.activity.photo.album.NewPhotoListActivity;
import com.tencent.mobileqq.activity.photo.album.NewPhotoPreviewActivity;
import com.tencent.mobileqq.widget.NumberCheckBox;
import com.tencent.qphone.base.util.QLog;
import com.tencent.sharpP.SharpPUtils;
import com.tencent.widget.AdapterView;
import com.tencent.widget.DragView;
import com.tencent.widget.Gallery.LayoutParams;
import com.tencent.widget.HorizontalListView;
import java.io.File;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import mqq.util.WeakReference;

public class agsw
  extends agss
  implements agst, agsu
{
  protected agsw(NewPhotoPreviewActivity paramNewPhotoPreviewActivity)
  {
    super(paramNewPhotoPreviewActivity);
    this.jdField_a_of_type_Agst = this;
    this.jdField_a_of_type_Agsu = this;
  }
  
  public View a(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    Object localObject2 = null;
    if (paramView != null) {}
    Object localObject3;
    int i;
    Object localObject1;
    label205:
    label224:
    do
    {
      return paramView;
      localObject3 = ((NewPhotoPreviewActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).jdField_a_of_type_Agry.a(paramInt);
      URLDrawable localURLDrawable;
      View localView;
      if (((NewPhotoPreviewActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).a((String)localObject3) == 1)
      {
        i = 1;
        localURLDrawable = (URLDrawable)this.jdField_a_of_type_Agsq.jdField_a_of_type_AndroidUtilSparseArray.get(paramInt);
        if (i == 0) {
          break label205;
        }
        localView = ((NewPhotoPreviewActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).getLayoutInflater().inflate(2131560955, null);
        localView.setTag(2131296400, Boolean.valueOf(true));
        localView.setLayoutParams(new Gallery.LayoutParams(-1, -1));
        localObject1 = (ImageView)localView.findViewById(2131371919);
      }
      for (;;)
      {
        Object localObject4 = new File((String)localObject3);
        localObject4 = ((NewPhotoPreviewActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).a((File)localObject4);
        if ((localURLDrawable == null) || (localURLDrawable.getStatus() != 1) || (!localURLDrawable.getURL().equals(localObject4))) {
          break label224;
        }
        ((ImageView)localObject1).setImageDrawable(localURLDrawable);
        if (i == 0) {
          break label581;
        }
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
          break label584;
        }
        j = paramViewGroup.getHeight();
        k = paramViewGroup.getWidth();
      }
    }
    label581:
    label584:
    for (;;)
    {
      paramViewGroup = bbbj.a(paramView, "FLOW_THUMB");
      if (paramViewGroup != null)
      {
        ((ImageView)localObject1).setImageDrawable(((NewPhotoPreviewActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).a(paramViewGroup.toString(), j, k, paramView));
        paramView = localObject2;
      }
      for (;;)
      {
        if (paramView == null) {
          break label503;
        }
        ((ImageView)localObject1).setImageDrawable(paramView);
        this.jdField_a_of_type_Agsq.jdField_a_of_type_AndroidUtilSparseArray.put(paramInt, paramView);
        break;
        QLog.d("PhotoPreviewActivity", 2, "url  is null ");
        paramView = localObject2;
        continue;
        localObject3 = URLDrawable.URLDrawableOptions.obtain();
        ((URLDrawable.URLDrawableOptions)localObject3).mRequestWidth = paramViewGroup.getWidth();
        ((URLDrawable.URLDrawableOptions)localObject3).mRequestHeight = paramViewGroup.getHeight();
        ((URLDrawable.URLDrawableOptions)localObject3).mLoadingDrawable = aywk.a;
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
      label503:
      break;
      if ((!this.jdField_a_of_type_Agsq.jdField_d_of_type_Boolean) || (!bbbj.a((String)localObject3))) {
        break;
      }
      paramView = URLDrawable.URLDrawableOptions.obtain();
      paramView.mRequestWidth = paramViewGroup.getWidth();
      paramView.mRequestHeight = paramViewGroup.getHeight();
      paramView.mLoadingDrawable = aywk.a;
      paramView = URLDrawable.getDrawable(SharpPUtils.getWebpUrl((String)localObject3), paramView);
      if (paramView == null) {
        QLog.w("PEAK", 2, "drawable == null");
      }
      ((ImageView)localObject1).setImageDrawable(paramView);
      break;
      return localObject1;
    }
  }
  
  void a(int paramInt1, int paramInt2, Intent paramIntent) {}
  
  void a(Intent paramIntent)
  {
    agls.a = ((NewPhotoPreviewActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).getResources().getDimension(2131296962);
    ((NewPhotoPreviewActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).jdField_a_of_type_Agqu = new agrb();
    this.jdField_a_of_type_Agsq.jdField_a_of_type_JavaLangString = paramIntent.getStringExtra("FROM_WHERE");
    paramIntent.removeExtra("FROM_WHERE");
    this.jdField_a_of_type_Agsq.jdField_c_of_type_Boolean = paramIntent.getBooleanExtra("PhotoConst.IS_SINGLE_MODE", false);
    this.jdField_a_of_type_Agsq.jdField_c_of_type_Int = paramIntent.getIntExtra("camera_type", 1);
    if (this.jdField_a_of_type_Agsb.jdField_a_of_type_JavaUtilHashMap == null) {
      this.jdField_a_of_type_Agsb.jdField_a_of_type_JavaUtilHashMap = new HashMap();
    }
    Object localObject = (HashMap)paramIntent.getSerializableExtra("PeakConstants.selectedMediaInfoHashMap");
    if ((localObject != null) && (!((HashMap)localObject).isEmpty())) {
      this.jdField_a_of_type_Agsb.jdField_a_of_type_JavaUtilHashMap.putAll((Map)localObject);
    }
    localObject = (HashMap)paramIntent.getSerializableExtra("PhotoConst.ALL_MEDIA_PATHS");
    if (localObject != null) {
      this.jdField_a_of_type_Agsb.jdField_b_of_type_JavaUtilHashMap = ((HashMap)localObject);
    }
    this.jdField_a_of_type_Agsb.jdField_a_of_type_Int = paramIntent.getIntExtra("PhotoConst.MAXUM_SELECTED_NUM", 1);
    this.jdField_a_of_type_Agsq.jdField_b_of_type_Boolean = paramIntent.getBooleanExtra("PhotoConst.SHOW_ALBUM", false);
    this.jdField_a_of_type_Agsq.jdField_c_of_type_JavaLangString = paramIntent.getStringExtra("back_btn_text");
    if (this.jdField_a_of_type_Agsq.jdField_b_of_type_Boolean)
    {
      this.jdField_a_of_type_Agsq.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
      this.jdField_a_of_type_Agsq.jdField_a_of_type_JavaUtilArrayList.addAll(this.jdField_a_of_type_Agsb.jdField_c_of_type_JavaUtilArrayList);
      if (this.jdField_a_of_type_Agsq.jdField_a_of_type_JavaUtilArrayList.isEmpty()) {
        this.jdField_a_of_type_Agsq.jdField_a_of_type_JavaUtilArrayList = paramIntent.getStringArrayListExtra("PhotoConst.PHOTO_PATHS");
      }
      if (this.jdField_a_of_type_Agsq.jdField_a_of_type_JavaUtilArrayList == null) {
        this.jdField_a_of_type_Agsq.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
      }
      this.jdField_a_of_type_Agsb.jdField_a_of_type_JavaUtilArrayList = paramIntent.getStringArrayListExtra("PhotoConst.SELECTED_PATHS");
      localObject = paramIntent.getIntegerArrayListExtra("PhotoConst.SELECTED_INDEXS");
      if ((localObject != null) && (!((ArrayList)localObject).isEmpty())) {
        this.jdField_a_of_type_Agsb.jdField_b_of_type_JavaUtilArrayList = ((ArrayList)localObject);
      }
      if ((this.jdField_a_of_type_Agsb.jdField_b_of_type_JavaUtilArrayList == null) || (this.jdField_a_of_type_Agsq.jdField_a_of_type_JavaUtilArrayList == null))
      {
        if (QLog.isColorLevel()) {
          QLog.d("PhotoPreviewActivity", 2, "initData(): Error! selectedItem or sSelectedIndex is null");
        }
        ((NewPhotoPreviewActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).finish();
      }
      this.jdField_a_of_type_Agsq.jdField_b_of_type_Int = this.jdField_a_of_type_Agsq.jdField_a_of_type_JavaUtilArrayList.size();
      this.jdField_a_of_type_Agsq.jdField_d_of_type_Int = ((NewPhotoPreviewActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).getIntent().getIntExtra("PhotoConst.CURRENT_SELECTED_INDEX", -1);
      if (this.jdField_a_of_type_Agsq.jdField_d_of_type_Int >= this.jdField_a_of_type_Agsq.jdField_b_of_type_Int) {
        this.jdField_a_of_type_Agsq.jdField_d_of_type_Int = -1;
      }
      paramIntent.removeExtra("PhotoConst.CURRENT_SELECTED_INDEX");
      this.jdField_a_of_type_Agsq.jdField_b_of_type_JavaLangString = paramIntent.getStringExtra("PhotoConst.CUSTOM_SENDBTN_TEXT");
      return;
    }
    this.jdField_a_of_type_Agsq.jdField_a_of_type_JavaUtilArrayList = paramIntent.getStringArrayListExtra("PhotoConst.PHOTO_PATHS");
    if (this.jdField_a_of_type_Agsq.jdField_a_of_type_JavaUtilArrayList == null)
    {
      this.jdField_a_of_type_Agsq.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
      this.jdField_a_of_type_Agsq.jdField_a_of_type_JavaUtilArrayList.addAll(this.jdField_a_of_type_Agsb.jdField_a_of_type_JavaUtilArrayList);
    }
    localObject = paramIntent.getStringExtra("PhotoConst.SINGLE_PHOTO_PATH");
    if ((localObject != null) && (!((String)localObject).equals("")))
    {
      this.jdField_a_of_type_Agsq.jdField_a_of_type_JavaUtilArrayList.clear();
      this.jdField_a_of_type_Agsq.jdField_a_of_type_JavaUtilArrayList.add(localObject);
    }
    localObject = this.jdField_a_of_type_Agsq.jdField_a_of_type_JavaUtilArrayList.iterator();
    while (((Iterator)localObject).hasNext())
    {
      String str = (String)((Iterator)localObject).next();
      if ((!this.jdField_a_of_type_Agsq.jdField_d_of_type_Boolean) || (!bbbj.a(str))) {
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
    if (this.jdField_a_of_type_Agsb.jdField_a_of_type_JavaUtilArrayList == null) {
      this.jdField_a_of_type_Agsb.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
    }
    for (;;)
    {
      this.jdField_a_of_type_Agsb.jdField_a_of_type_JavaUtilArrayList.addAll(this.jdField_a_of_type_Agsq.jdField_a_of_type_JavaUtilArrayList);
      this.jdField_a_of_type_Agsb.jdField_b_of_type_JavaUtilArrayList.clear();
      if (this.jdField_a_of_type_Agsq.jdField_c_of_type_Boolean) {
        break;
      }
      int i = 0;
      while (i < this.jdField_a_of_type_Agsq.jdField_a_of_type_JavaUtilArrayList.size())
      {
        this.jdField_a_of_type_Agsb.jdField_b_of_type_JavaUtilArrayList.add(Integer.valueOf(i));
        i += 1;
      }
      break;
      this.jdField_a_of_type_Agsb.jdField_a_of_type_JavaUtilArrayList.clear();
    }
  }
  
  void a(View paramView)
  {
    ((NewPhotoPreviewActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).getResources();
    int i = ((NewPhotoPreviewActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).a();
    if (this.jdField_a_of_type_Agsb.jdField_b_of_type_JavaUtilArrayList.contains(Integer.valueOf(i)))
    {
      ((NewPhotoPreviewActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).jdField_a_of_type_ComTencentMobileqqWidgetNumberCheckBox.setChecked(false);
      int j = this.jdField_a_of_type_Agsb.jdField_b_of_type_JavaUtilArrayList.indexOf(Integer.valueOf(i));
      if (j >= 0)
      {
        this.jdField_a_of_type_Agsb.jdField_b_of_type_JavaUtilArrayList.remove(j);
        if (i != -1) {
          this.jdField_a_of_type_Agsb.jdField_a_of_type_JavaUtilArrayList.remove(this.jdField_a_of_type_Agsq.jdField_a_of_type_JavaUtilArrayList.get(i));
        }
      }
    }
    for (;;)
    {
      d();
      return;
      if (this.jdField_a_of_type_Agsb.jdField_a_of_type_JavaUtilArrayList.size() >= this.jdField_a_of_type_Agsb.jdField_a_of_type_Int)
      {
        long l = System.currentTimeMillis();
        if (l - this.jdField_a_of_type_Agsq.jdField_a_of_type_Long >= 700L)
        {
          bcpw.a((Context)this.jdField_a_of_type_MqqUtilWeakReference.get(), ((NewPhotoPreviewActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).a(), 1000).b(this.jdField_a_of_type_Agsq.jdField_a_of_type_Int);
          this.jdField_a_of_type_Agsq.jdField_a_of_type_Long = l;
        }
        ((NewPhotoPreviewActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).jdField_a_of_type_ComTencentMobileqqWidgetNumberCheckBox.setChecked(false);
        return;
      }
      if (i != -1)
      {
        paramView = (String)this.jdField_a_of_type_Agsq.jdField_a_of_type_JavaUtilArrayList.get(i);
        this.jdField_a_of_type_Agsb.jdField_a_of_type_JavaUtilArrayList.add(paramView);
        this.jdField_a_of_type_Agsb.jdField_b_of_type_JavaUtilArrayList.add(Integer.valueOf(i));
        ((NewPhotoPreviewActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).a(paramView);
      }
    }
  }
  
  void a(View paramView, int paramInt1, Bundle paramBundle, int paramInt2, Intent paramIntent) {}
  
  protected void a(CompoundButton paramCompoundButton, boolean paramBoolean) {}
  
  void a(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    String str = ((NewPhotoPreviewActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).jdField_a_of_type_Agry.a(paramInt);
    if (((NewPhotoPreviewActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).a(str) == 1)
    {
      if (((NewPhotoPreviewActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).jdField_a_of_type_Agqu != null)
      {
        agrc localagrc = new agrc();
        localagrc.jdField_a_of_type_Boolean = false;
        localagrc.jdField_a_of_type_JavaLangString = str;
        ((NewPhotoPreviewActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).jdField_a_of_type_Agqu.a(paramAdapterView, localagrc);
      }
      if (paramView != null)
      {
        ((NewPhotoPreviewActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131371918));
        ((NewPhotoPreviewActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
      }
      if (!this.jdField_a_of_type_Agsb.jdField_b_of_type_JavaUtilArrayList.contains(Integer.valueOf(paramInt))) {
        break label355;
      }
      if (str == null) {
        break label335;
      }
      ((NewPhotoPreviewActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).a(str);
      label176:
      d();
      if (!this.jdField_a_of_type_Agsq.jdField_b_of_type_Boolean)
      {
        if (this.jdField_a_of_type_Agsq.jdField_a_of_type_JavaUtilArrayList.size() <= 1) {
          break label375;
        }
        ((NewPhotoPreviewActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).d.setText(paramInt + 1 + " / " + this.jdField_a_of_type_Agsq.jdField_a_of_type_JavaUtilArrayList.size());
      }
    }
    for (;;)
    {
      if ((((NewPhotoPreviewActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).a(str) == 1) && (!this.jdField_a_of_type_Agsq.jdField_a_of_type_Boolean)) {
        ((NewPhotoPreviewActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).b();
      }
      return;
      if (((NewPhotoPreviewActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).jdField_a_of_type_Agqu == null) {
        break;
      }
      ((NewPhotoPreviewActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).jdField_a_of_type_Agqu.a(null, null);
      break;
      label335:
      ((NewPhotoPreviewActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).jdField_a_of_type_ComTencentMobileqqWidgetNumberCheckBox.setChecked(false);
      break label176;
      label355:
      ((NewPhotoPreviewActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).jdField_a_of_type_ComTencentMobileqqWidgetNumberCheckBox.setChecked(false);
      break label176;
      label375:
      ((NewPhotoPreviewActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).d.setText(((NewPhotoPreviewActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).getResources().getString(2131695336));
    }
  }
  
  void a(boolean paramBoolean)
  {
    Intent localIntent = ((NewPhotoPreviewActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).getIntent();
    if ("FROM_PHOTO_LIST".equals(this.jdField_a_of_type_Agsq.jdField_a_of_type_JavaLangString))
    {
      localIntent.setClass((Context)this.jdField_a_of_type_MqqUtilWeakReference.get(), NewPhotoListActivity.class);
      localIntent.putExtra("PhotoConst.CURRENT_QUALITY_TYPE", this.jdField_a_of_type_Agsb.jdField_c_of_type_Int);
      if (!this.jdField_a_of_type_Agsq.jdField_c_of_type_Boolean) {
        break label202;
      }
      localIntent.removeExtra("PhotoConst.PHOTO_PATHS");
    }
    for (;;)
    {
      ((NewPhotoPreviewActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).startActivity(localIntent);
      if (localIntent.getBooleanExtra("keep_selected_status_after_finish", false))
      {
        localIntent = new Intent();
        localIntent.putStringArrayListExtra("PhotoConst.SELECTED_PATHS", this.jdField_a_of_type_Agsb.jdField_a_of_type_JavaUtilArrayList);
        localIntent.putIntegerArrayListExtra("PhotoConst.SELECTED_INDEXS", this.jdField_a_of_type_Agsb.jdField_b_of_type_JavaUtilArrayList);
        localIntent.putExtra("PhotoConst.CURRENT_QUALITY_TYPE", this.jdField_a_of_type_Agsb.jdField_c_of_type_Int);
        localIntent.putExtra("PhotoConst.editPathMap", this.jdField_a_of_type_Agsq.jdField_a_of_type_JavaUtilHashMap);
        ((NewPhotoPreviewActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).setResult(-1, localIntent);
      }
      ((NewPhotoPreviewActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).finish();
      return;
      label202:
      localIntent.putStringArrayListExtra("PhotoConst.PHOTO_PATHS", this.jdField_a_of_type_Agsb.jdField_a_of_type_JavaUtilArrayList);
      localIntent.putExtra("PhotoConst.editPathMap", this.jdField_a_of_type_Agsq.jdField_a_of_type_JavaUtilHashMap);
    }
  }
  
  boolean a()
  {
    return false;
  }
  
  public void b(boolean paramBoolean) {}
  
  void c()
  {
    ((NewPhotoPreviewActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).jdField_a_of_type_AndroidViewSurfaceView = ((SurfaceView)((NewPhotoPreviewActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).findViewById(2131366904));
    ((NewPhotoPreviewActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).jdField_a_of_type_AndroidViewSurfaceView.setVisibility(8);
    ((NewPhotoPreviewActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).jdField_c_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)((NewPhotoPreviewActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).findViewById(2131375492));
    ((NewPhotoPreviewActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).jdField_a_of_type_ComTencentWidgetDragView = ((DragView)((NewPhotoPreviewActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).findViewById(2131365404));
    ((NewPhotoPreviewActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).jdField_a_of_type_AndroidViewView = ((NewPhotoPreviewActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).findViewById(2131377553);
    ((NewPhotoPreviewActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).jdField_b_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)((NewPhotoPreviewActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).findViewById(2131363340));
    ((NewPhotoPreviewActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).jdField_a_of_type_AndroidWidgetButton = ((Button)((NewPhotoPreviewActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).findViewById(2131369712));
    ((NewPhotoPreviewActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).jdField_a_of_type_AndroidWidgetCheckBox = ((CheckBox)((NewPhotoPreviewActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).findViewById(2131366364));
    ((NewPhotoPreviewActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).jdField_a_of_type_AndroidWidgetTextView = ((TextView)((NewPhotoPreviewActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).findViewById(2131366365));
    ((NewPhotoPreviewActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).jdField_b_of_type_AndroidWidgetCheckBox = ((CheckBox)((NewPhotoPreviewActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).findViewById(2131373463));
    ((NewPhotoPreviewActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).jdField_b_of_type_AndroidWidgetTextView = ((TextView)((NewPhotoPreviewActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).findViewById(2131373469));
    ((NewPhotoPreviewActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).e = ((TextView)((NewPhotoPreviewActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).findViewById(2131371555));
    ((NewPhotoPreviewActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).jdField_b_of_type_AndroidWidgetButton = ((Button)((NewPhotoPreviewActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).findViewById(2131375840));
    ((NewPhotoPreviewActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).jdField_a_of_type_ComTencentMobileqqWidgetNumberCheckBox = ((NumberCheckBox)((NewPhotoPreviewActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).findViewById(2131375817));
    ((NewPhotoPreviewActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).jdField_b_of_type_AndroidViewView = ((NewPhotoPreviewActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).findViewById(2131375799);
    ((NewPhotoPreviewActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).d = ((TextView)((NewPhotoPreviewActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).findViewById(2131377350));
    ((NewPhotoPreviewActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).jdField_c_of_type_AndroidWidgetTextView = ((TextView)((NewPhotoPreviewActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).findViewById(2131362996));
    ((NewPhotoPreviewActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).jdField_a_of_type_ComTencentMobileqqActivityPhotoDragGallery = ((DragGallery)((NewPhotoPreviewActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).findViewById(2131366897));
    if (this.jdField_a_of_type_Agsq.jdField_a_of_type_Boolean)
    {
      ((NewPhotoPreviewActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).jdField_a_of_type_AndroidViewView.setVisibility(0);
      ((NewPhotoPreviewActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).jdField_b_of_type_AndroidWidgetRelativeLayout.setVisibility(0);
    }
    for (;;)
    {
      ((NewPhotoPreviewActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).jdField_a_of_type_AndroidWidgetCheckBox.setVisibility(8);
      ((NewPhotoPreviewActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
      ((NewPhotoPreviewActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).jdField_b_of_type_AndroidWidgetCheckBox.setVisibility(8);
      ((NewPhotoPreviewActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
      ((NewPhotoPreviewActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).jdField_a_of_type_AndroidWidgetButton.setVisibility(8);
      if (this.jdField_a_of_type_Agsq.jdField_b_of_type_Boolean) {
        ((NewPhotoPreviewActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).d.setVisibility(8);
      }
      ((NewPhotoPreviewActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).jdField_b_of_type_AndroidViewView.setOnClickListener(new agsx(this));
      ((NewPhotoPreviewActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).jdField_c_of_type_AndroidWidgetTextView.setOnClickListener(new agsy(this));
      ((NewPhotoPreviewActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).jdField_a_of_type_ComTencentMobileqqActivityPhotoDragGallery.setSupportMatchParent(true);
      ((NewPhotoPreviewActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).jdField_a_of_type_ComTencentMobileqqActivityPhotoDragGallery.setAdapter(((NewPhotoPreviewActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).jdField_a_of_type_Agry);
      ((NewPhotoPreviewActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).jdField_a_of_type_ComTencentMobileqqActivityPhotoDragGallery.setOnNoBlankListener(((NewPhotoPreviewActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).jdField_a_of_type_Agry);
      ((NewPhotoPreviewActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).jdField_a_of_type_ComTencentMobileqqActivityPhotoDragGallery.setOnItemSelectedListener(new agsz(this));
      ((NewPhotoPreviewActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).jdField_a_of_type_ComTencentMobileqqActivityPhotoDragGallery.setSpacing(((NewPhotoPreviewActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).getResources().getDimensionPixelSize(2131297009));
      if (this.jdField_a_of_type_Agsq.jdField_d_of_type_Int != -1) {
        ((NewPhotoPreviewActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).jdField_a_of_type_ComTencentMobileqqActivityPhotoDragGallery.setSelection(this.jdField_a_of_type_Agsq.jdField_d_of_type_Int);
      }
      ((NewPhotoPreviewActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).jdField_a_of_type_ComTencentMobileqqActivityPhotoDragGallery.setOnItemClickListener(new agta(this));
      d();
      if (this.jdField_a_of_type_Agsq.jdField_c_of_type_Boolean)
      {
        ((NewPhotoPreviewActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).jdField_a_of_type_ComTencentMobileqqWidgetNumberCheckBox.setVisibility(8);
        ((NewPhotoPreviewActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).jdField_b_of_type_AndroidViewView.setVisibility(8);
        ((NewPhotoPreviewActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).e.setVisibility(0);
      }
      ((NewPhotoPreviewActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).e.setOnClickListener(new agtb(this));
      if (!TextUtils.isEmpty(this.jdField_a_of_type_Agsq.jdField_c_of_type_JavaLangString)) {
        ((NewPhotoPreviewActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).jdField_c_of_type_AndroidWidgetTextView.setText(this.jdField_a_of_type_Agsq.jdField_c_of_type_JavaLangString);
      }
      ((NewPhotoPreviewActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).jdField_a_of_type_ComTencentWidgetHorizontalListView = ((HorizontalListView)((NewPhotoPreviewActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).findViewById(2131366490));
      ((NewPhotoPreviewActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).jdField_c_of_type_AndroidViewView = ((NewPhotoPreviewActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).findViewById(2131366488);
      ((NewPhotoPreviewActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).jdField_a_of_type_Agrz = new agrz((NewPhotoPreviewActivity)this.jdField_a_of_type_MqqUtilWeakReference.get());
      ((NewPhotoPreviewActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).jdField_a_of_type_Agrz.a(this.jdField_a_of_type_Agsb.jdField_a_of_type_JavaUtilArrayList);
      ((NewPhotoPreviewActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).jdField_a_of_type_ComTencentWidgetHorizontalListView.setAdapter(((NewPhotoPreviewActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).jdField_a_of_type_Agrz);
      ((NewPhotoPreviewActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).jdField_a_of_type_ComTencentWidgetHorizontalListView.setOnItemClickListener(((NewPhotoPreviewActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).jdField_a_of_type_Agrz);
      if (a())
      {
        ((NewPhotoPreviewActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).jdField_a_of_type_ComTencentWidgetHorizontalListView.setVisibility(0);
        ((NewPhotoPreviewActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).jdField_c_of_type_AndroidViewView.setVisibility(0);
      }
      return;
      ((NewPhotoPreviewActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).jdField_a_of_type_AndroidViewView.setVisibility(4);
      ((NewPhotoPreviewActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).jdField_b_of_type_AndroidWidgetRelativeLayout.setVisibility(4);
    }
  }
  
  void d()
  {
    String str = ((NewPhotoPreviewActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).getResources().getString(2131695084);
    if (this.jdField_a_of_type_Agsq.jdField_b_of_type_JavaLangString != null) {
      str = this.jdField_a_of_type_Agsq.jdField_b_of_type_JavaLangString;
    }
    for (;;)
    {
      int i;
      label111:
      boolean bool;
      if ((this.jdField_a_of_type_Agsb.jdField_a_of_type_JavaUtilArrayList != null) && (this.jdField_a_of_type_Agsb.jdField_a_of_type_JavaUtilArrayList.size() > 0))
      {
        i = 1;
        if (i == 0) {
          break label336;
        }
        ((NewPhotoPreviewActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).jdField_b_of_type_AndroidWidgetButton.setEnabled(true);
        if (!this.jdField_a_of_type_Agsq.jdField_c_of_type_Boolean) {
          break label278;
        }
        ((NewPhotoPreviewActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).jdField_b_of_type_AndroidWidgetButton.setText(str);
        bool = this.jdField_a_of_type_Agsb.jdField_b_of_type_JavaUtilArrayList.contains(Integer.valueOf(((NewPhotoPreviewActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).a()));
        if (((NewPhotoPreviewActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).jdField_a_of_type_Agrz != null)
        {
          if (!a()) {
            break label356;
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
        if ((bool) || (this.jdField_a_of_type_Agsb.jdField_a_of_type_JavaUtilArrayList.size() < this.jdField_a_of_type_Agsb.jdField_a_of_type_Int)) {
          break label393;
        }
        ((NewPhotoPreviewActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).jdField_a_of_type_ComTencentMobileqqWidgetNumberCheckBox.setActivated(true);
        return;
        i = 0;
        break;
        label278:
        ((NewPhotoPreviewActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).jdField_b_of_type_AndroidWidgetButton.setText(str + "(" + this.jdField_a_of_type_Agsb.jdField_a_of_type_JavaUtilArrayList.size() + ")");
        break label111;
        label336:
        ((NewPhotoPreviewActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).jdField_b_of_type_AndroidWidgetButton.setText(str);
        break label111;
        label356:
        ((NewPhotoPreviewActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).jdField_c_of_type_AndroidViewView.setVisibility(4);
        ((NewPhotoPreviewActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).jdField_a_of_type_ComTencentWidgetHorizontalListView.setVisibility(4);
      }
      label393:
      ((NewPhotoPreviewActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).jdField_a_of_type_ComTencentMobileqqWidgetNumberCheckBox.setActivated(false);
      return;
    }
  }
  
  void e()
  {
    try
    {
      Iterator localIterator = this.jdField_a_of_type_Agsb.jdField_a_of_type_JavaUtilArrayList.iterator();
      while (localIterator.hasNext())
      {
        Object localObject2 = (String)localIterator.next();
        if (localObject2 != null)
        {
          localObject2 = new File((String)localObject2);
          URLDrawable.removeMemoryCacheByUrl(((File)localObject2).toURL().toString());
          URLDrawable.removeMemoryCacheByUrl(((File)localObject2).toURL().toString() + "#NOSAMPLE");
        }
      }
      try
      {
        Object localObject1 = (String)this.jdField_a_of_type_Agsq.jdField_a_of_type_JavaUtilArrayList.get(0);
        if (!TextUtils.isEmpty((CharSequence)localObject1))
        {
          localObject1 = BaseApplicationImpl.sImageCache.remove((String)localObject1 + "#short_video_camera_preview_cache");
          if ((localObject1 instanceof Bitmap))
          {
            if (QLog.isColorLevel()) {
              QLog.d("PhotoPreviewActivity", 2, "recycle short video preview cache");
            }
            amfw.a((Bitmap)localObject1);
          }
        }
      }
      catch (Throwable localThrowable)
      {
        break label202;
      }
    }
    catch (Exception localException)
    {
      if (QLog.isColorLevel()) {
        QLog.e("PhotoPreviewActivity", 2, "remove file error");
      }
      if ((this.jdField_a_of_type_Agsq.jdField_c_of_type_Int != 103) || (this.jdField_a_of_type_Agsq.jdField_a_of_type_JavaUtilArrayList == null)) {}
    }
    label202:
    if (((NewPhotoPreviewActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).jdField_a_of_type_Agqu != null) {
      ((NewPhotoPreviewActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).jdField_a_of_type_Agqu.k();
    }
    ((NewPhotoPreviewActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).jdField_a_of_type_Agqu = null;
    b();
  }
  
  void f()
  {
    if ((this.jdField_a_of_type_Agsq.jdField_a_of_type_Boolean) && (((NewPhotoPreviewActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).jdField_a_of_type_AndroidViewView != null)) {
      ((NewPhotoPreviewActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).jdField_a_of_type_AndroidViewView.setVisibility(0);
    }
    if (((NewPhotoPreviewActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).jdField_a_of_type_Agqu != null) {
      ((NewPhotoPreviewActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).jdField_a_of_type_Agqu.j();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     agsw
 * JD-Core Version:    0.7.0.1
 */