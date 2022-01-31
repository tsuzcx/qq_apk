import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.Pair;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.biz.qqstory.database.PublishVideoEntry;
import com.tencent.biz.qqstory.takevideo.slideshow.SlideItemInfo;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.config.AppSetting;
import com.tencent.component.media.image.ImageManager;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLImageView;
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
import com.tencent.mobileqq.activity.shortvideo.SendVideoActivity.SendVideoInfo;
import com.tencent.mobileqq.activity.shortvideo.ShortVideoPreviewActivity;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.pic.PresendPicMgr;
import com.tencent.mobileqq.widget.NumberCheckBox;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.AbsListView.LayoutParams;
import com.tencent.widget.AdapterView;
import com.tencent.widget.GestureSelectGridView;
import cooperation.qzone.util.QZLog;
import dov.com.tencent.biz.qqstory.takevideo.EditPicActivity;
import java.io.File;
import java.io.Serializable;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import mqq.app.AppRuntime;
import mqq.app.NewIntent;
import mqq.util.WeakReference;

public class aggm
  extends aggh
  implements aggi, aggj, aggk
{
  protected aggm(NewPhotoListActivity paramNewPhotoListActivity)
  {
    super(paramNewPhotoListActivity);
    this.jdField_a_of_type_Aggk = this;
    this.jdField_a_of_type_Aggi = this;
    this.jdField_a_of_type_Aggj = this;
  }
  
  public static aggh a(NewPhotoListActivity paramNewPhotoListActivity)
  {
    if ((jdField_a_of_type_Aggh == null) || (jdField_a_of_type_Aggh.jdField_a_of_type_MqqUtilWeakReference.get() != paramNewPhotoListActivity)) {}
    try
    {
      if ((jdField_a_of_type_Aggh == null) || (jdField_a_of_type_Aggh.jdField_a_of_type_MqqUtilWeakReference.get() != paramNewPhotoListActivity))
      {
        if (jdField_a_of_type_Aggh != null) {
          jdField_a_of_type_Aggh.b();
        }
        jdField_a_of_type_Aggh = new aggm(paramNewPhotoListActivity);
      }
      return jdField_a_of_type_Aggh;
    }
    finally {}
  }
  
  public Intent a(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    baaf.a();
    paramAdapterView = ((NewPhotoListActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).jdField_a_of_type_Agfv.a(paramInt);
    paramView = ((NewPhotoListActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).getIntent();
    paramView.putExtra("ALBUM_NAME", this.jdField_a_of_type_Aggf.jdField_b_of_type_JavaLangString);
    paramView.putExtra("ALBUM_ID", this.jdField_a_of_type_Aggf.jdField_c_of_type_JavaLangString);
    paramView.putExtra("PhotoConst.MY_UIN", this.jdField_a_of_type_Aggf.jdField_a_of_type_JavaLangString);
    paramView.putStringArrayListExtra("PhotoConst.PHOTO_PATHS", this.jdField_a_of_type_Aggf.jdField_c_of_type_JavaUtilArrayList);
    paramView.putStringArrayListExtra("PhotoConst.SELECTED_PATHS", this.jdField_a_of_type_Aggf.jdField_a_of_type_JavaUtilArrayList);
    paramView.putIntegerArrayListExtra("PhotoConst.SELECTED_INDEXS", this.jdField_a_of_type_Aggf.jdField_b_of_type_JavaUtilArrayList);
    if (baaf.a(paramAdapterView) == 0) {
      paramView.putExtra("PhotoConst.CURRENT_SELECTED_INDEX", paramAdapterView.position);
    }
    paramView.putExtra("FROM_WHERE", "FROM_PHOTO_LIST");
    paramView.putExtra("PhotoConst.CURRENT_QUALITY_TYPE", this.jdField_a_of_type_Aggg.jdField_e_of_type_Int);
    paramView.putExtra("PhotoConst.SHOW_ALBUM", true);
    paramView.putExtra("PhotoConst.SHOW_MAGIC_USE_PASTER", this.jdField_a_of_type_Aggg.jdField_h_of_type_Boolean);
    paramView.putExtra("PhotoConst.editPathMap", agdo.a(this.jdField_a_of_type_Aggg.jdField_c_of_type_JavaUtilHashMap));
    paramView.putExtra("p_e_s_type", 6);
    paramView.putExtra("PasterConstants.paster_id", this.jdField_a_of_type_Aggg.jdField_a_of_type_JavaLangString);
    paramView.putExtra("PasterConstants.paster_cate_id", this.jdField_a_of_type_Aggg.jdField_b_of_type_JavaLangString);
    aggg.jdField_a_of_type_Int = ((NewPhotoListActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).jdField_a_of_type_ComTencentWidgetGestureSelectGridView.getFirstVisiblePosition();
    if ((this.jdField_a_of_type_Aggg.w) || (this.jdField_a_of_type_Aggf.a()))
    {
      if (!this.jdField_a_of_type_Aggf.jdField_a_of_type_JavaUtilHashMap.containsKey(paramAdapterView.path)) {
        this.jdField_a_of_type_Aggf.jdField_a_of_type_JavaUtilHashMap.put(paramAdapterView.path, paramAdapterView);
      }
      paramView.putExtra("PeakConstants.selectedMediaInfoHashMap", this.jdField_a_of_type_Aggf.jdField_a_of_type_JavaUtilHashMap);
    }
    paramView.putExtra("PasterConstants.pasters_data", this.jdField_a_of_type_Aggg.jdField_b_of_type_JavaUtilHashMap);
    paramView.setClass((Context)this.jdField_a_of_type_MqqUtilWeakReference.get(), NewPhotoPreviewActivity.class);
    paramView.addFlags(603979776);
    if ((this.jdField_a_of_type_Aggf.jdField_a_of_type_JavaUtilArrayList != null) && (this.jdField_a_of_type_Aggf.jdField_a_of_type_JavaUtilArrayList.size() > 0)) {
      awqx.b(null, "CliOper", "", this.jdField_a_of_type_Aggf.jdField_a_of_type_JavaLangString, "0X8005674", "0X8005674", 0, this.jdField_a_of_type_Aggf.jdField_a_of_type_JavaUtilArrayList.size(), 0, "", "", "", "");
    }
    return paramView;
  }
  
  public View a(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    if (paramView == null)
    {
      paramView = new ImageView((Context)this.jdField_a_of_type_MqqUtilWeakReference.get());
      paramView.setLayoutParams(new AbsListView.LayoutParams(((NewPhotoListActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).jdField_a_of_type_Int, ((NewPhotoListActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).jdField_b_of_type_Int));
    }
    for (;;)
    {
      paramViewGroup = (ImageView)paramView;
      paramView.setBackgroundColor(-16777216);
      paramViewGroup.setImageResource(2130840976);
      paramViewGroup.setScaleType(ImageView.ScaleType.CENTER);
      return paramView;
    }
  }
  
  public View a(int paramInt, View paramView, ViewGroup paramViewGroup, agfw paramagfw, agft paramagft)
  {
    if (paramView == null)
    {
      paramViewGroup = ((NewPhotoListActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).jdField_a_of_type_Agfv.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2131495377, null);
      paramViewGroup.setLayoutParams(new AbsListView.LayoutParams(((NewPhotoListActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).jdField_a_of_type_Int, ((NewPhotoListActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).jdField_b_of_type_Int));
      paramagfw.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)paramViewGroup.findViewById(2131305863));
      paramagfw.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramViewGroup.findViewById(2131305824));
      paramagfw.c = ((ImageView)paramViewGroup.findViewById(2131305867));
      paramagfw.d = ((ImageView)paramViewGroup.findViewById(2131305868));
      paramagfw.jdField_a_of_type_AndroidViewView = paramViewGroup.findViewById(2131305865);
      paramagfw.jdField_a_of_type_ComTencentMobileqqWidgetNumberCheckBox = ((NumberCheckBox)paramViewGroup.findViewById(2131305866));
      if (this.jdField_a_of_type_Aggf.jdField_a_of_type_Int > 100) {
        paramagfw.jdField_a_of_type_ComTencentMobileqqWidgetNumberCheckBox.setTextSize(10.0F);
      }
      paramagfw.jdField_a_of_type_Agft = paramagft;
      if (paramagfw.jdField_a_of_type_AndroidViewView != null) {
        paramagfw.jdField_a_of_type_AndroidViewView.setOnClickListener(paramagfw.jdField_a_of_type_Agft);
      }
      paramViewGroup.setTag(paramagfw);
      paramView = paramViewGroup;
      if (!this.jdField_a_of_type_Aggg.jdField_e_of_type_Boolean)
      {
        paramagfw.jdField_a_of_type_AndroidViewView.setVisibility(0);
        paramView = paramViewGroup;
      }
    }
    for (;;)
    {
      paramagfw.jdField_a_of_type_Agft.a(paramInt);
      paramagfw.jdField_a_of_type_Agft.a(paramagfw.jdField_a_of_type_ComTencentMobileqqWidgetNumberCheckBox);
      paramagft = paramagfw.jdField_b_of_type_AndroidWidgetImageView;
      paramagft.setAdjustViewBounds(false);
      paramViewGroup = ((NewPhotoListActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).jdField_a_of_type_Agfv.a(paramInt);
      paramView.setContentDescription(PhotoUtils.a(0, paramViewGroup, paramInt));
      if (paramViewGroup != null) {
        paramagfw.jdField_a_of_type_AndroidWidgetImageView.setVisibility(4);
      }
      int i;
      if ((this.jdField_a_of_type_Aggg.x) && (((NewPhotoListActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).a(paramViewGroup)))
      {
        if (paramagfw.jdField_b_of_type_AndroidWidgetTextView == null)
        {
          paramagfw.jdField_b_of_type_AndroidWidgetTextView = ((NewPhotoListActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).jdField_a_of_type_Agfv.a();
          paramagfw.jdField_b_of_type_AndroidWidgetTextView.setText("GIF");
          localObject = new RelativeLayout.LayoutParams(-2, -2);
          ((RelativeLayout.LayoutParams)localObject).addRule(11);
          ((RelativeLayout.LayoutParams)localObject).addRule(12);
          ((RelativeLayout)paramView).addView(paramagfw.jdField_b_of_type_AndroidWidgetTextView, (ViewGroup.LayoutParams)localObject);
        }
        paramagfw.jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
        i = axoh.jdField_a_of_type_Int;
        paramViewGroup.thumbHeight = i;
        paramViewGroup.thumbWidth = i;
        Object localObject = paramagfw.jdField_a_of_type_ComTencentImageURLDrawable;
        StringBuilder localStringBuilder = new StringBuilder("albumthumb");
        localStringBuilder.append("://");
        localStringBuilder.append(paramViewGroup.path);
        if ((localObject == null) || (!((URLDrawable)localObject).getURL().toString().equals(localStringBuilder.toString())))
        {
          localObject = baaf.a(paramViewGroup);
          if (QLog.isColorLevel()) {
            QLog.d("PhotoListActivity", 2, "PhotoListAdapter,getView(),image url :" + ((URL)localObject).toString());
          }
          localObject = axwd.a((URL)localObject, ((NewPhotoListActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).jdField_a_of_type_Agfv.jdField_a_of_type_AndroidGraphicsDrawableColorDrawable, ((NewPhotoListActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).jdField_a_of_type_Agfv.jdField_a_of_type_AndroidGraphicsDrawableDrawable);
          ((URLDrawable)localObject).setTag(paramViewGroup);
          paramagft.setImageDrawable((Drawable)localObject);
          ((URLImageView)paramagft).setURLDrawableDownListener(((NewPhotoListActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).jdField_a_of_type_Agfv);
          paramagfw.jdField_a_of_type_ComTencentImageURLDrawable = ((URLDrawable)localObject);
        }
        paramagft = paramagfw.c;
        i = paramViewGroup.selectStatus;
        if (i != 1) {
          break label755;
        }
        paramagft.setVisibility(0);
        paramagfw.jdField_a_of_type_ComTencentMobileqqWidgetNumberCheckBox.setCheckedNumber(this.jdField_a_of_type_Aggf.jdField_a_of_type_JavaUtilArrayList.indexOf(paramViewGroup.path) + 1);
        if (paramView.getBackground() != null) {
          paramView.setBackgroundDrawable(null);
        }
      }
      for (;;)
      {
        if (AppSetting.jdField_c_of_type_Boolean)
        {
          paramagft = PhotoUtils.a(0, paramViewGroup, paramInt, paramagfw.jdField_a_of_type_ComTencentMobileqqWidgetNumberCheckBox.isChecked());
          paramagfw.jdField_a_of_type_ComTencentMobileqqWidgetNumberCheckBox.setContentDescription(paramagft);
        }
        paramViewGroup.visableTime = SystemClock.uptimeMillis();
        paramViewGroup.listViewPosition = paramInt;
        return paramView;
        if (paramagfw.jdField_b_of_type_AndroidWidgetTextView == null) {
          break;
        }
        paramagfw.jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
        break;
        label755:
        if (i == 3)
        {
          paramagft.setVisibility(4);
          paramagfw.jdField_a_of_type_ComTencentMobileqqWidgetNumberCheckBox.setChecked(false);
        }
        else
        {
          paramagft.setVisibility(4);
          paramagfw.jdField_a_of_type_ComTencentMobileqqWidgetNumberCheckBox.setChecked(false);
          if (paramView.getBackground() != null) {
            paramView.setBackgroundDrawable(null);
          }
        }
      }
    }
  }
  
  protected String a(LocalMediaInfo paramLocalMediaInfo)
  {
    int i = this.jdField_a_of_type_Aggf.jdField_a_of_type_Int;
    String str2 = "最多只能选择" + i + "张图片\\视频";
    String str1 = str2;
    if (paramLocalMediaInfo != null)
    {
      paramLocalMediaInfo = agaq.a(paramLocalMediaInfo.mMimeType);
      if ((!this.jdField_a_of_type_Aggf.a()) || (this.jdField_a_of_type_Aggg.s)) {
        break label100;
      }
      str1 = "已达" + i + "张上限";
    }
    label100:
    do
    {
      do
      {
        do
        {
          return str1;
          str1 = str2;
        } while (!this.jdField_a_of_type_Aggg.s);
        str1 = str2;
      } while (paramLocalMediaInfo == null);
      str1 = str2;
    } while (!"video".equals(paramLocalMediaInfo[0]));
    if (this.jdField_a_of_type_Aggf.a()) {
      return "最多只能选择" + i + "张照片\\视频";
    }
    return "最多只能选择" + i + "张图片\\视频";
  }
  
  protected List<LocalMediaInfo> a()
  {
    int i = -1;
    if (this.jdField_a_of_type_Aggf.jdField_c_of_type_JavaLangString.equals("$RecentAlbumId")) {
      i = 100;
    }
    Object localObject1;
    if (this.jdField_a_of_type_Aggf.a()) {
      if ((!TextUtils.isEmpty(this.jdField_a_of_type_Aggf.jdField_c_of_type_JavaLangString)) && (this.jdField_a_of_type_Aggf.jdField_c_of_type_JavaLangString.equals("$CustomAlbumId")))
      {
        localObject1 = new ArrayList();
        ((List)localObject1).addAll(vhg.a().b());
        badi.a("PEAK", "getAlbumMedias");
        if (localObject1 != null) {
          break label214;
        }
        if (QLog.isColorLevel()) {
          QLog.d("SelectPhotoTrace", 2, "photoList is null");
        }
        localObject2 = null;
      }
    }
    label214:
    do
    {
      do
      {
        do
        {
          return localObject2;
          localObject1 = baaf.a((Context)this.jdField_a_of_type_MqqUtilWeakReference.get(), this.jdField_a_of_type_Aggf.jdField_c_of_type_JavaLangString, this.jdField_a_of_type_Aggf.jdField_b_of_type_JavaLangString, i, this.jdField_a_of_type_Aggg.jdField_a_of_type_Afzz, 0, 0, true, null, false, this.jdField_a_of_type_Aggg.jdField_c_of_type_Long, 1);
          break;
          localObject1 = baaf.b((Context)this.jdField_a_of_type_MqqUtilWeakReference.get(), this.jdField_a_of_type_Aggf.jdField_c_of_type_JavaLangString, this.jdField_a_of_type_Aggf.jdField_b_of_type_JavaLangString, i, this.jdField_a_of_type_Aggg.jdField_a_of_type_Afzz, this.jdField_a_of_type_Aggg.jdField_c_of_type_Long);
          break;
          localObject2 = localObject1;
        } while (this.jdField_a_of_type_Aggf.jdField_a_of_type_JavaUtilArrayList == null);
        localObject2 = localObject1;
      } while (this.jdField_a_of_type_Aggf.jdField_a_of_type_JavaUtilArrayList.size() == 0);
      i = 0;
      localObject2 = localObject1;
    } while (i >= this.jdField_a_of_type_Aggf.jdField_a_of_type_JavaUtilArrayList.size());
    Object localObject2 = (String)this.jdField_a_of_type_Aggf.jdField_a_of_type_JavaUtilArrayList.get(i);
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
        if ((((String)localObject2).startsWith("http")) && (this.jdField_a_of_type_Aggf.jdField_c_of_type_JavaUtilHashMap != null))
        {
          j = i;
          if (this.jdField_a_of_type_Aggf.jdField_c_of_type_JavaUtilHashMap.containsKey(localObject2)) {}
        }
        else
        {
          this.jdField_a_of_type_Aggf.jdField_a_of_type_JavaUtilArrayList.remove(i);
          i -= 1;
          if (!this.jdField_a_of_type_Aggf.a())
          {
            j = i;
            if (this.jdField_a_of_type_Aggg.w)
            {
              j = i;
              if (this.jdField_a_of_type_Aggf.jdField_a_of_type_JavaUtilHashMap != null)
              {
                j = i;
                if (!this.jdField_a_of_type_Aggf.jdField_a_of_type_JavaUtilHashMap.containsKey(localObject2)) {}
              }
            }
          }
          else
          {
            this.jdField_a_of_type_Aggf.jdField_a_of_type_JavaUtilHashMap.remove(localObject2);
            j = i;
          }
        }
      }
    }
  }
  
  public void a() {}
  
  public void a(int paramInt1, int paramInt2)
  {
    ArrayList localArrayList = this.jdField_a_of_type_Aggf.jdField_a_of_type_JavaUtilArrayList;
    GestureSelectGridView localGestureSelectGridView = ((NewPhotoListActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).jdField_a_of_type_ComTencentWidgetGestureSelectGridView;
    agfv localagfv = ((NewPhotoListActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).jdField_a_of_type_Agfv;
    if ((paramInt1 >= 0) && (paramInt1 < localArrayList.size()) && (paramInt2 >= 0) && (paramInt2 < localArrayList.size()))
    {
      Collections.swap(localArrayList, paramInt1, paramInt2);
      paramInt2 = localGestureSelectGridView.getFirstVisiblePosition();
      int i = localGestureSelectGridView.getLastVisiblePosition();
      paramInt1 = paramInt2;
      while (paramInt1 <= i)
      {
        Object localObject = localagfv.a(paramInt1);
        int j = localArrayList.indexOf(((LocalMediaInfo)localObject).path);
        if (j >= 0)
        {
          localObject = (agfw)localGestureSelectGridView.getChildAt(((LocalMediaInfo)localObject).position.intValue() - paramInt2).getTag();
          if ((localObject != null) && (((agfw)localObject).jdField_a_of_type_ComTencentMobileqqWidgetNumberCheckBox != null)) {
            ((agfw)localObject).jdField_a_of_type_ComTencentMobileqqWidgetNumberCheckBox.setCheckedNumber(j + 1);
          }
        }
        paramInt1 += 1;
      }
      vhg.a().b(localArrayList, this.jdField_a_of_type_Aggf.jdField_b_of_type_JavaUtilHashMap);
    }
  }
  
  protected void a(int paramInt1, int paramInt2, Intent paramIntent)
  {
    ArrayList localArrayList = this.jdField_a_of_type_Aggf.jdField_a_of_type_JavaUtilArrayList;
    if ((QLog.isDevelopLevel()) && (localArrayList != null) && (localArrayList.size() != 0)) {
      QLog.d("PhotoListActivity", 4, "[NewPhotoListActivity] [onActivityResult] selectedPhotoList = " + localArrayList.size());
    }
    this.jdField_a_of_type_Aggg.jdField_i_of_type_Int = paramInt1;
    if (paramInt2 == -1) {
      switch (paramInt1)
      {
      }
    }
    for (;;)
    {
      PhotoUtils.a((Activity)this.jdField_a_of_type_MqqUtilWeakReference.get(), paramInt1, paramInt2, paramIntent, this.jdField_a_of_type_Aggg.k, this.jdField_a_of_type_Aggf.jdField_a_of_type_JavaLangString);
      do
      {
        return;
        ((NewPhotoListActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).setResult(-1, paramIntent);
        ((NewPhotoListActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).finish();
        break;
        paramIntent = PresendPicMgr.a();
        if (paramIntent != null) {
          paramIntent.a(this.jdField_a_of_type_Aggg.jdField_f_of_type_JavaLangString, 1008);
        }
        a(true, ((NewPhotoListActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).getIntent());
        return;
        paramIntent = new Intent();
        paramIntent.putStringArrayListExtra("PhotoConst.SELECTED_PATHS", localArrayList);
        paramIntent.putExtra("PhotoConst.CURRENT_QUALITY_TYPE", this.jdField_a_of_type_Aggg.jdField_e_of_type_Int);
        ((NewPhotoListActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).setResult(-1, paramIntent);
        ((NewPhotoListActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).finish();
        return;
      } while (paramIntent == null);
      this.jdField_a_of_type_Aggf.jdField_a_of_type_JavaUtilArrayList = paramIntent.getStringArrayListExtra("img_list");
      continue;
      vhg.a().a(paramIntent, this.jdField_a_of_type_Aggf.jdField_a_of_type_JavaUtilHashMap);
      continue;
      if (paramInt1 == 17)
      {
        baaf.jdField_a_of_type_Long = 0L;
        return;
      }
      if ((paramInt1 == 100010) && (this.jdField_a_of_type_Aggf.a())) {
        if (this.jdField_a_of_type_Aggg.u) {
          ((NewPhotoListActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).runOnUiThread(new PhotoListLogicDefault.5(this));
        } else {
          this.jdField_a_of_type_Aggg.u = true;
        }
      }
    }
  }
  
  public void a(int paramInt, LocalMediaInfo paramLocalMediaInfo)
  {
    Handler localHandler = ((NewPhotoListActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).jdField_a_of_type_AndroidOsHandler;
    if (localHandler == null) {}
    do
    {
      do
      {
        return;
        localObject = ((NewPhotoListActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).jdField_a_of_type_Agfv;
      } while ((localObject == null) || (((agfv)localObject).jdField_a_of_type_JavaUtilArrayList == null));
      localObject = (LocalMediaInfo)((agfv)localObject).jdField_a_of_type_JavaUtilArrayList.get(paramInt);
    } while ((localObject == null) || (paramLocalMediaInfo == null) || (((LocalMediaInfo)localObject).path == null) || (paramLocalMediaInfo.path == null) || (!((LocalMediaInfo)localObject).path.equals(paramLocalMediaInfo.path)));
    Object localObject = localHandler.obtainMessage();
    ((Message)localObject).what = 0;
    Bundle localBundle = new Bundle();
    localBundle.putInt("ALBUMLIST_POSITION", paramInt);
    localBundle.putLong("ALBUMLIST_ITEM_DURATION", paramLocalMediaInfo.mDuration);
    ((Message)localObject).setData(localBundle);
    localHandler.sendMessage((Message)localObject);
  }
  
  protected void a(Intent paramIntent)
  {
    if (QLog.isColorLevel()) {
      QLog.d("SelectPhotoTrace", 2, "PhotoListActivity initData(),intent extras is:" + paramIntent.getExtras());
    }
    this.jdField_a_of_type_Aggg.m = paramIntent.getBooleanExtra("PhotoConst.IS_RECODE_LAST_ALBUMPATH", true);
    if (paramIntent.getBooleanExtra("album_enter_directly", false))
    {
      long l1 = System.currentTimeMillis();
      long l2 = baaf.jdField_a_of_type_Long;
      if ((this.jdField_a_of_type_Aggg.m) && (l1 - l2 < 60000L))
      {
        this.jdField_a_of_type_Aggf.jdField_b_of_type_JavaLangString = baaf.jdField_c_of_type_JavaLangString;
        this.jdField_a_of_type_Aggf.jdField_c_of_type_JavaLangString = baaf.jdField_b_of_type_JavaLangString;
      }
    }
    for (;;)
    {
      if (this.jdField_a_of_type_Aggf.jdField_c_of_type_JavaLangString == null)
      {
        this.jdField_a_of_type_Aggf.jdField_c_of_type_JavaLangString = "$RecentAlbumId";
        this.jdField_a_of_type_Aggf.jdField_b_of_type_JavaLangString = null;
      }
      this.jdField_a_of_type_Aggg.v = paramIntent.getBooleanExtra("PhotoConst.IS_FROM_EDIT", false);
      this.jdField_a_of_type_Aggg.s = paramIntent.getBooleanExtra("PhotoConst.IS_SUPPORT_VIDEO_CHECKBOX", false);
      this.jdField_a_of_type_Aggg.jdField_g_of_type_JavaLangString = paramIntent.getStringExtra("PhotoConst.INIT_ACTIVITY_CLASS_NAME");
      this.jdField_a_of_type_Aggg.x = paramIntent.getBooleanExtra("PeakConstants.showGifTypeIcon", false);
      Object localObject = paramIntent.getStringArrayListExtra("PhotoConst.PHOTO_PATHS");
      if ((localObject != null) && (!((ArrayList)localObject).isEmpty())) {
        this.jdField_a_of_type_Aggf.jdField_a_of_type_JavaUtilArrayList = ((ArrayList)localObject);
      }
      if (this.jdField_a_of_type_Aggf.jdField_a_of_type_JavaUtilArrayList == null) {
        this.jdField_a_of_type_Aggf.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
      }
      agdo.a((Context)this.jdField_a_of_type_MqqUtilWeakReference.get(), paramIntent, false, this.jdField_a_of_type_Aggg.jdField_c_of_type_JavaUtilHashMap);
      if (this.jdField_a_of_type_Aggf.jdField_a_of_type_JavaUtilHashMap == null) {
        this.jdField_a_of_type_Aggf.jdField_a_of_type_JavaUtilHashMap = new HashMap();
      }
      localObject = (HashMap)paramIntent.getSerializableExtra("PeakConstants.selectedMediaInfoHashMap");
      if ((localObject != null) && (!((HashMap)localObject).isEmpty()) && (this.jdField_a_of_type_Aggf.jdField_a_of_type_JavaUtilArrayList.size() == ((HashMap)localObject).size()))
      {
        this.jdField_a_of_type_Aggf.jdField_a_of_type_JavaUtilHashMap.clear();
        this.jdField_a_of_type_Aggf.jdField_a_of_type_JavaUtilHashMap.putAll((Map)localObject);
      }
      this.jdField_a_of_type_Aggg.jdField_a_of_type_JavaUtilHashMap = ((HashMap)paramIntent.getSerializableExtra("PhotoConst.PHOTO_PATHS_FROM_QZONEALBUM"));
      if (this.jdField_a_of_type_Aggg.jdField_a_of_type_JavaUtilHashMap == null) {
        this.jdField_a_of_type_Aggg.jdField_a_of_type_JavaUtilHashMap = new HashMap(1);
      }
      this.jdField_a_of_type_Aggf.jdField_b_of_type_JavaUtilArrayList = new ArrayList();
      this.jdField_a_of_type_Aggf.jdField_a_of_type_Int = paramIntent.getIntExtra("PhotoConst.MAXUM_SELECTED_NUM", 1);
      this.jdField_a_of_type_Aggg.jdField_c_of_type_Int = paramIntent.getIntExtra("PhotoConst.MAXUM_SELECTED_NUM_VIDEO", 1);
      this.jdField_a_of_type_Aggg.jdField_e_of_type_Boolean = paramIntent.getBooleanExtra("PhotoConst.IS_SINGLE_MODE", true);
      this.jdField_a_of_type_Aggf.jdField_c_of_type_Boolean = paramIntent.getBooleanExtra("PhotoConst.IS_SHOW_QZONE_ALBUM", false);
      this.jdField_a_of_type_Aggf.jdField_c_of_type_JavaUtilHashMap = ((HashMap)paramIntent.getSerializableExtra("PhotoConst.PHOTO_INFOS"));
      this.jdField_a_of_type_Aggg.jdField_f_of_type_Boolean = paramIntent.getBooleanExtra("PhotoConst.original_button", false);
      this.jdField_a_of_type_Aggg.jdField_g_of_type_Boolean = paramIntent.getBooleanExtra("PhotoConst.quality_count_tv", true);
      this.jdField_a_of_type_Aggf.jdField_a_of_type_JavaLangString = paramIntent.getStringExtra("PhotoConst.MY_UIN");
      this.jdField_a_of_type_Aggg.jdField_a_of_type_Boolean = paramIntent.getBooleanExtra("PhotoConst.HANDLE_DEST_RESULT", false);
      this.jdField_a_of_type_Aggg.jdField_i_of_type_Boolean = paramIntent.getBooleanExtra("PhotoConst.IS_SINGLE_DERECTBACK_MODE", false);
      this.jdField_a_of_type_Aggg.j = paramIntent.getBooleanExtra("PhotoConst.IS_SINGLE_NEED_EDIT", false);
      this.jdField_a_of_type_Aggg.k = paramIntent.getBooleanExtra("PhotoConst.IS_CALL_IN_PLUGIN", false);
      this.jdField_a_of_type_Aggg.jdField_d_of_type_Int = paramIntent.getIntExtra("uintype", -1);
      this.jdField_a_of_type_Aggg.jdField_e_of_type_Int = paramIntent.getIntExtra("PhotoConst.CURRENT_QUALITY_TYPE", 0);
      if (this.jdField_a_of_type_Aggf.jdField_a_of_type_Int > 1) {
        this.jdField_a_of_type_Aggg.jdField_e_of_type_Boolean = false;
      }
      if (paramIntent.getBooleanExtra("PhotoConst.ALWAYS_SHOW_NUMBER_WHEN_ONLY_ONE_IMAGE", false)) {
        this.jdField_a_of_type_Aggg.jdField_e_of_type_Boolean = false;
      }
      this.jdField_a_of_type_Aggg.l = paramIntent.getBooleanExtra("PhotoConst.IS_FINISH_RESTART_INIT_ACTIVITY", false);
      this.jdField_a_of_type_Aggg.n = paramIntent.getBooleanExtra("PhotoConst.SEND_FLAG", false);
      this.jdField_a_of_type_Aggg.jdField_d_of_type_JavaLangString = paramIntent.getStringExtra("uinname");
      this.jdField_a_of_type_Aggg.jdField_e_of_type_JavaLangString = paramIntent.getStringExtra("uin");
      this.jdField_a_of_type_Aggg.jdField_b_of_type_Int = paramIntent.getIntExtra("PhotoConst.PHOTOLIST_KEY_SHOW_MEDIA", 1);
      this.jdField_a_of_type_Aggg.jdField_a_of_type_Afzz = afzz.a(this.jdField_a_of_type_Aggg.jdField_b_of_type_Int);
      this.jdField_a_of_type_Aggg.jdField_b_of_type_Boolean = paramIntent.getBooleanExtra("PhotoConst.PHOTOLIST_KEY_FILTER_GIF_VIDEO", false);
      if (this.jdField_a_of_type_Aggg.jdField_b_of_type_Boolean)
      {
        this.jdField_a_of_type_Aggg.jdField_a_of_type_Afzz = new afzs(afzz.d);
        this.jdField_a_of_type_Aggg.jdField_b_of_type_Int = 1;
      }
      this.jdField_a_of_type_Aggg.jdField_a_of_type_Long = paramIntent.getLongExtra("PhotoConst.PHOTOLIST_KEY_VIDEO_SIZE", 1048576000L);
      this.jdField_a_of_type_Aggg.jdField_c_of_type_Boolean = paramIntent.getBooleanExtra("PhotoConst.IS_PREVIEW_VIDEO", true);
      this.jdField_a_of_type_Aggg.jdField_b_of_type_Long = paramIntent.getLongExtra("PhotoConst.PHOTOLIST_KEY_VIDEO_DURATION", 9223372036854775807L);
      this.jdField_a_of_type_Aggg.jdField_c_of_type_Long = paramIntent.getLongExtra("PhotoConst.PHOTOLIST_KEY_FILTER_VIDEO_DURATION_LIMIT", 9223372036854775807L);
      try
      {
        this.jdField_a_of_type_Aggg.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo = ((SessionInfo)paramIntent.getParcelableExtra("session_info"));
        if (this.jdField_a_of_type_Aggg.n)
        {
          paramIntent.removeExtra("PhotoConst.SEND_FLAG");
          localObject = PresendPicMgr.a();
          if (localObject != null)
          {
            if (QLog.isColorLevel()) {
              QLog.d("PhotoListActivity", 2, "Photo+ send pic,cancel presend!");
            }
            ((PresendPicMgr)localObject).a(1004);
          }
          PhotoUtils.a((Activity)this.jdField_a_of_type_MqqUtilWeakReference.get(), paramIntent, this.jdField_a_of_type_Aggf.jdField_a_of_type_JavaUtilArrayList, this.jdField_a_of_type_Aggg.jdField_e_of_type_Int, true);
        }
        this.jdField_a_of_type_Aggg.jdField_c_of_type_JavaLangString = paramIntent.getStringExtra("PhotoConst.CUSTOM_SENDBTN_TEXT");
        this.jdField_a_of_type_Aggg.q = paramIntent.getBooleanExtra("PhotoConst.IS_SHOW_CAMERA", false);
        if (this.jdField_a_of_type_Aggg.q) {
          this.jdField_a_of_type_Aggg.r = paramIntent.getBooleanExtra("PhotoConst.SHOW_CAMERA_IN_VIDEO", false);
        }
        if (!this.jdField_a_of_type_Aggg.jdField_h_of_type_Boolean) {
          this.jdField_a_of_type_Aggg.jdField_h_of_type_Boolean = paramIntent.getBooleanExtra("PhotoConst.SHOW_MAGIC_USE_PASTER", false);
        }
        if (this.jdField_a_of_type_Aggg.jdField_h_of_type_Boolean)
        {
          this.jdField_a_of_type_Aggg.jdField_b_of_type_JavaUtilHashMap = ((HashMap)paramIntent.getSerializableExtra("PasterConstants.pasters_data"));
          this.jdField_a_of_type_Aggg.jdField_a_of_type_JavaLangString = paramIntent.getStringExtra("PasterConstants.paster_id");
          this.jdField_a_of_type_Aggg.jdField_b_of_type_JavaLangString = paramIntent.getStringExtra("PasterConstants.paster_cate_id");
        }
        this.jdField_a_of_type_Aggg.jdField_h_of_type_Int = paramIntent.getIntExtra("PHOTOLIST_START_POSITION", -1);
        paramIntent.removeExtra("PHOTOLIST_START_POSITION");
        this.jdField_a_of_type_Aggg.t = paramIntent.getBooleanExtra("ReceiptMsgManager.EXTRA_KEY_IS_RECEIPT", false);
        if (!this.jdField_a_of_type_Aggg.w) {
          this.jdField_a_of_type_Aggg.w = paramIntent.getBooleanExtra("PhotoConst.PHOTOLIST_IS_NEED_MEDIA_INFO", false);
        }
        this.jdField_a_of_type_Aggg.jdField_d_of_type_Long = paramIntent.getLongExtra("PhotoConst.PHOTOLIST_KEY_MAX_MEDIA_SIZE", -1L);
        if (this.jdField_a_of_type_Aggf.jdField_c_of_type_Boolean)
        {
          paramIntent = new NewIntent(BaseApplicationImpl.getApplication(), awcx.class);
          paramIntent.putExtra("selfuin", Long.valueOf(BaseApplicationImpl.getApplication().getRuntime().getAccount()));
          BaseApplicationImpl.getApplication().getRuntime().registObserver(NewPhotoListActivity.jdField_a_of_type_Agfx);
          BaseApplicationImpl.getApplication().getRuntime().startServlet(paramIntent);
        }
        return;
        this.jdField_a_of_type_Aggf.jdField_b_of_type_JavaLangString = paramIntent.getStringExtra("ALBUM_NAME");
        this.jdField_a_of_type_Aggf.jdField_c_of_type_JavaLangString = paramIntent.getStringExtra("ALBUM_ID");
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
  }
  
  protected void a(Intent paramIntent, boolean paramBoolean)
  {
    int i2 = PhotoUtils.b(this.jdField_a_of_type_Aggg.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo);
    Object localObject1 = new HashMap();
    int j = 0;
    int i = 0;
    int i1 = 0;
    int k = 0;
    while (i1 < this.jdField_a_of_type_Aggf.jdField_a_of_type_JavaUtilArrayList.size())
    {
      localObject2 = (String)this.jdField_a_of_type_Aggf.jdField_a_of_type_JavaUtilArrayList.get(i1);
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
      if ((aweg.jdField_b_of_type_Long != 0L) && (System.currentTimeMillis() - aweg.jdField_b_of_type_Long < 300000L)) {}
      for (boolean bool = true;; bool = false)
      {
        if (QLog.isColorLevel()) {
          QLog.d("PhotoListActivity", 2, "upload video isConfirmed=" + bool + " allowUploadInXGTime=" + aweg.jdField_b_of_type_Long);
        }
        if ((!badq.b(BaseApplicationImpl.getContext())) || (bool) || (i == 0)) {
          break;
        }
        localObject1 = ((NewPhotoListActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).getResources().getString(2131653417);
        paramIntent = new PhotoListLogicDefault.1(this, paramBoolean, paramIntent, i2, (String)localObject2, (String)localObject3);
        if (bbrm.a((Activity)this.jdField_a_of_type_MqqUtilWeakReference.get(), 4, new aggn(this, paramIntent))) {
          babr.a((Context)this.jdField_a_of_type_MqqUtilWeakReference.get(), 232, null, (String)localObject1, new aggo(this, paramIntent), new aggp(this)).show();
        }
        if (QLog.isColorLevel()) {
          QLog.i("PhotoListActivity", 2, "show shortvideo_mobile_send_confirm dialog");
        }
        return;
      }
      if (paramBoolean) {
        PhotoUtils.a((Activity)this.jdField_a_of_type_MqqUtilWeakReference.get(), paramIntent, this.jdField_a_of_type_Aggf.jdField_a_of_type_JavaUtilArrayList, this.jdField_a_of_type_Aggg.jdField_a_of_type_JavaUtilHashMap, this.jdField_a_of_type_Aggg.jdField_e_of_type_Int, false);
      }
      for (;;)
      {
        awqx.b(null, "CliOper", "", "", "0X8009AB0", "0X8009AB0", i2, 0, (String)localObject2, (String)localObject3, "", "");
        return;
        PhotoUtils.a((Activity)this.jdField_a_of_type_MqqUtilWeakReference.get(), paramIntent, this.jdField_a_of_type_Aggf.jdField_a_of_type_JavaUtilArrayList, this.jdField_a_of_type_Aggg.jdField_e_of_type_Int, this.jdField_a_of_type_Aggg.jdField_a_of_type_Boolean);
      }
    }
  }
  
  protected void a(Message paramMessage)
  {
    ((NewPhotoListActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).f();
    ArrayList localArrayList = this.jdField_a_of_type_Aggf.jdField_a_of_type_JavaUtilArrayList;
    String str;
    if ((paramMessage.obj instanceof String))
    {
      str = (String)paramMessage.obj;
      QZLog.d("PhotoListActivity", 2, new Object[] { "onEncodeSuccess = ", str });
      paramMessage = localArrayList;
      if (localArrayList == null) {
        paramMessage = new ArrayList();
      }
      if (paramMessage.size() < aggf.a().jdField_a_of_type_Int) {
        break label158;
      }
      bbmy.a((Context)this.jdField_a_of_type_MqqUtilWeakReference.get(), String.format(((NewPhotoListActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).getResources().getString(2131629421), new Object[] { Integer.valueOf(aggf.a().jdField_a_of_type_Int) }), 0).a();
    }
    for (;;)
    {
      ((NewPhotoListActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).a(str);
      return;
      label158:
      aggf.a().jdField_a_of_type_JavaUtilArrayList.add(str);
      ((NewPhotoListActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).h();
    }
  }
  
  protected void a(View paramView)
  {
    baaf.c();
    baaf.a();
    paramView = PresendPicMgr.a();
    if (paramView != null) {
      paramView.a(1006);
    }
    paramView = ((NewPhotoListActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).getIntent();
    if (this.jdField_a_of_type_Aggf.jdField_a_of_type_JavaUtilArrayList != null) {}
    for (int i = this.jdField_a_of_type_Aggf.jdField_a_of_type_JavaUtilArrayList.size();; i = 0)
    {
      ageh.b(paramView, i);
      if (this.jdField_a_of_type_Aggg.l) {
        break;
      }
      if (this.jdField_a_of_type_Aggf.a()) {
        vhg.a().a(vhg.a().c());
      }
      ((NewPhotoListActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).finish();
      baaf.a((Activity)this.jdField_a_of_type_MqqUtilWeakReference.get(), false, false);
      return;
    }
    paramView = ((NewPhotoListActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).getIntent();
    String str1 = paramView.getStringExtra("PhotoConst.INIT_ACTIVITY_CLASS_NAME");
    String str2 = paramView.getStringExtra("PhotoConst.INIT_ACTIVITY_PACKAGE_NAME");
    if (str1 == null)
    {
      bbmy.a((Context)this.jdField_a_of_type_MqqUtilWeakReference.get(), "请设置INIT_ACTIVITY_CLASS_NAME ", 0).a();
      return;
    }
    paramView.setClassName(str2, str1);
    paramView.removeExtra("PhotoConst.PHOTO_PATHS");
    paramView.removeExtra("PhotoConst.SINGLE_PHOTO_PATH");
    paramView.addFlags(603979776);
    ((NewPhotoListActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).startActivity(paramView);
    ((NewPhotoListActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).finish();
    baaf.a((Activity)this.jdField_a_of_type_MqqUtilWeakReference.get(), false, false);
  }
  
  public void a(View paramView, int paramInt, CheckBox paramCheckBox)
  {
    paramView = this.jdField_a_of_type_Aggf.jdField_a_of_type_JavaUtilArrayList;
    if (this.jdField_a_of_type_Aggg.jdField_e_of_type_Boolean) {}
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
        localLocalMediaInfo = ((NewPhotoListActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).jdField_a_of_type_Agfv.a(paramInt);
        i = localLocalMediaInfo.selectStatus;
        if ((i == 1) || (paramView.size() < this.jdField_a_of_type_Aggf.jdField_a_of_type_Int)) {
          break;
        }
        l = System.currentTimeMillis();
      } while (l - this.jdField_a_of_type_Aggg.jdField_e_of_type_Long < 1000L);
      bbmy.a((Context)this.jdField_a_of_type_MqqUtilWeakReference.get(), a(localLocalMediaInfo), 0).b(((NewPhotoListActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).jdField_g_of_type_Int);
      paramCheckBox.setChecked(false);
      this.jdField_a_of_type_Aggg.jdField_e_of_type_Long = l;
      ((NewPhotoListActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).b();
      return;
      if ((this.jdField_a_of_type_Aggg.jdField_d_of_type_Int == 9501) && (((NewPhotoListActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).getIntent().getBooleanExtra("PhotoConst.IS_SEND_FILESIZE_LIMIT", false)) && (i != 1))
      {
        localObject1 = paramView.iterator();
        for (l = 0L; ((Iterator)localObject1).hasNext(); l = bace.a((String)((Iterator)localObject1).next()) + l) {}
        if (bace.a(localLocalMediaInfo.path) + l > 52428800L)
        {
          bbmy.a((Context)this.jdField_a_of_type_MqqUtilWeakReference.get(), "选择图片总大小不能超过50M", 0).b(((NewPhotoListActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).jdField_g_of_type_Int);
          paramCheckBox.setChecked(false);
          return;
        }
      }
      if ((((NewPhotoListActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).getIntent().getBooleanExtra("PhotoConst.IS_SEND_GIF_SIZE_LIMIT", false)) && (((NewPhotoListActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).a(localLocalMediaInfo)) && (bace.a(localLocalMediaInfo.path) > 3145728L))
      {
        bbmy.a((Context)this.jdField_a_of_type_MqqUtilWeakReference.get(), "图片文件过大", 0).b(((NewPhotoListActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).jdField_g_of_type_Int);
        paramCheckBox.setChecked(false);
        return;
      }
    } while ((this.jdField_a_of_type_Aggf.a()) && (!biys.a((Activity)this.jdField_a_of_type_MqqUtilWeakReference.get(), localLocalMediaInfo)));
    label461:
    boolean bool;
    label480:
    Object localObject2;
    if (i == 1)
    {
      i = 2;
      localLocalMediaInfo.selectStatus = i;
      if (localLocalMediaInfo.selectStatus != 1) {
        break label1105;
      }
      bool = true;
      paramCheckBox = localLocalMediaInfo.path;
      localObject1 = PresendPicMgr.a();
      if (!bool) {
        break label1111;
      }
      localObject2 = agaq.a(localLocalMediaInfo.mMimeType);
      aggg localaggg;
      if ((this.jdField_a_of_type_Aggg.s) && (localObject2 != null) && ("video".equals(localObject2[0])))
      {
        localaggg = this.jdField_a_of_type_Aggg;
        localaggg.jdField_f_of_type_Int += 1;
        if (this.jdField_a_of_type_Aggg.jdField_f_of_type_Int == 1) {
          this.jdField_a_of_type_Aggg.jdField_a_of_type_ComTencentMobileqqActivityPhotoLocalMediaInfo = localLocalMediaInfo;
        }
      }
      if ((!TextUtils.isEmpty(localLocalMediaInfo.mMimeType)) && ("image/gif".equals(localLocalMediaInfo.mMimeType)))
      {
        localaggg = this.jdField_a_of_type_Aggg;
        localaggg.jdField_g_of_type_Int += 1;
      }
      paramView.add(paramCheckBox);
      this.jdField_a_of_type_Aggf.jdField_b_of_type_JavaUtilArrayList.add(localLocalMediaInfo.position);
      if ((this.jdField_a_of_type_Aggg.w) || (this.jdField_a_of_type_Aggf.a())) {
        this.jdField_a_of_type_Aggf.jdField_a_of_type_JavaUtilHashMap.put(paramCheckBox, localLocalMediaInfo);
      }
      if ((localObject1 != null) && (localObject2 != null) && (localObject2[0] != null) && (!"video".equals(localObject2[0]))) {
        ((PresendPicMgr)localObject1).a(paramCheckBox, 1052, ((NewPhotoListActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).getIntent().getIntExtra("entrance", 0));
      }
      ageh.a(((NewPhotoListActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).getIntent(), "param_totalSelNum");
      paramView = ((NewPhotoListActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).getIntent();
      if (!paramView.hasExtra("param_initTime")) {
        paramView.putExtra("param_initTime", System.currentTimeMillis());
      }
      paramView = (LinkedHashMap)baaf.jdField_b_of_type_JavaUtilHashMap.get(this.jdField_a_of_type_Aggf.jdField_c_of_type_JavaLangString);
      if (paramView != null) {
        break label1355;
      }
      paramView = new LinkedHashMap();
      baaf.jdField_b_of_type_JavaUtilHashMap.put(this.jdField_a_of_type_Aggf.jdField_c_of_type_JavaLangString, paramView);
    }
    label1355:
    for (;;)
    {
      paramView.put(paramCheckBox, Integer.valueOf(((NewPhotoListActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).jdField_a_of_type_ComTencentWidgetGestureSelectGridView.getFirstVisiblePosition()));
      paramView = baaf.jdField_c_of_type_JavaUtilHashMap;
      if (!paramView.containsKey(paramCheckBox)) {
        paramView.put(paramCheckBox, new Pair(this.jdField_a_of_type_Aggf.jdField_c_of_type_JavaLangString, this.jdField_a_of_type_Aggf.jdField_b_of_type_JavaLangString));
      }
      for (;;)
      {
        if (this.jdField_a_of_type_Aggl != null) {
          this.jdField_a_of_type_Aggl.a(bool, localLocalMediaInfo);
        }
        ((NewPhotoListActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).a(paramInt, bool);
        if (this.jdField_a_of_type_Aggg.jdField_e_of_type_Int == 2) {
          a(localLocalMediaInfo);
        }
        d();
        if (!this.jdField_a_of_type_Aggf.a()) {
          break;
        }
        if (vhg.a().a().isEmpty())
        {
          i = ((NewPhotoListActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).jdField_a_of_type_ComTencentWidgetGestureSelectGridView.getFirstVisiblePosition();
          paramView = ((NewPhotoListActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).jdField_a_of_type_ComTencentWidgetGestureSelectGridView.getChildAt(paramInt - i);
          if ((paramView != null) && (((NewPhotoListActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).jdField_a_of_type_ComTencentWidgetGestureSelectGridView.getHeight() - paramView.getY() < ((NewPhotoListActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).jdField_b_of_type_Int)) {
            ((NewPhotoListActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).jdField_a_of_type_ComTencentWidgetGestureSelectGridView.smoothScrollBy(vhg.jdField_a_of_type_Int, 500);
          }
        }
        vhg.a().b(this.jdField_a_of_type_Aggf.jdField_a_of_type_JavaUtilArrayList, this.jdField_a_of_type_Aggf.jdField_b_of_type_JavaUtilHashMap);
        return;
        i = 1;
        break label461;
        label1105:
        bool = false;
        break label480;
        label1111:
        localObject2 = agaq.a(localLocalMediaInfo.mMimeType);
        if ((this.jdField_a_of_type_Aggg.s) && (localObject2 != null) && ("video".equals(localObject2[0])))
        {
          localObject2 = this.jdField_a_of_type_Aggg;
          ((aggg)localObject2).jdField_f_of_type_Int -= 1;
          if (this.jdField_a_of_type_Aggg.jdField_f_of_type_Int == 1) {
            this.jdField_a_of_type_Aggg.jdField_a_of_type_ComTencentMobileqqActivityPhotoLocalMediaInfo = localLocalMediaInfo;
          }
        }
        if ((!TextUtils.isEmpty(localLocalMediaInfo.mMimeType)) && ("image/gif".equals(localLocalMediaInfo.mMimeType)))
        {
          localObject2 = this.jdField_a_of_type_Aggg;
          ((aggg)localObject2).jdField_g_of_type_Int -= 1;
        }
        paramView.remove(paramCheckBox);
        this.jdField_a_of_type_Aggf.jdField_b_of_type_JavaUtilArrayList.remove(localLocalMediaInfo.position);
        if (this.jdField_a_of_type_Aggg.w) {
          this.jdField_a_of_type_Aggf.jdField_a_of_type_JavaUtilHashMap.remove(paramCheckBox);
        }
        if (localObject1 != null) {
          ((PresendPicMgr)localObject1).b(paramCheckBox, 1013);
        }
        ageh.a(((NewPhotoListActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).getIntent(), "param_cancelSelNum");
        paramView = (HashMap)baaf.jdField_b_of_type_JavaUtilHashMap.get(this.jdField_a_of_type_Aggf.jdField_c_of_type_JavaLangString);
        if (paramView != null) {
          paramView.remove(paramCheckBox);
        }
        paramView = baaf.jdField_c_of_type_JavaUtilHashMap;
        if (paramView.containsKey(paramCheckBox)) {
          paramView.remove(paramCheckBox);
        }
      }
    }
  }
  
  protected void a(View paramView, Bundle paramBundle, int paramInt, Intent paramIntent)
  {
    if (this.jdField_a_of_type_Aggf.jdField_a_of_type_JavaUtilArrayList.size() > 0)
    {
      paramView = ((NewPhotoListActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).getIntent();
      paramView.removeExtra("param_initTime");
      paramView.putStringArrayListExtra("PhotoConst.PHOTO_PATHS", this.jdField_a_of_type_Aggf.jdField_a_of_type_JavaUtilArrayList);
      awqx.b(null, "CliOper", "", "", "0x8004B39", "0x8004B39", 0, 0, "", "", "", "");
      paramView = paramIntent;
      if (paramIntent == null) {
        paramView = EditPicActivity.a((Activity)this.jdField_a_of_type_MqqUtilWeakReference.get(), (String)this.jdField_a_of_type_Aggf.jdField_a_of_type_JavaUtilArrayList.get(0), true, true, true, true, true, paramInt, 99, 5, paramBundle);
      }
      paramView.putExtra("key_enable_edit_title_bar", true);
      ((NewPhotoListActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).a(paramView);
      ((NewPhotoListActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).startActivity(paramView);
      ((NewPhotoListActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).jdField_a_of_type_AndroidWidgetButton.setClickable(false);
    }
  }
  
  public void a(SlideItemInfo paramSlideItemInfo)
  {
    Object localObject1 = ((NewPhotoListActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).jdField_a_of_type_Agfv;
    ArrayList localArrayList = this.jdField_a_of_type_Aggf.jdField_a_of_type_JavaUtilArrayList;
    Object localObject2;
    int i;
    if ((localObject1 != null) && (paramSlideItemInfo != null))
    {
      localObject2 = ((agfv)localObject1).a();
      i = 0;
      if (i >= ((List)localObject2).size()) {
        break label577;
      }
      if (!((LocalMediaInfo)((List)localObject2).get(i)).path.equals(paramSlideItemInfo.jdField_b_of_type_JavaLangString)) {
        break label410;
      }
    }
    for (;;)
    {
      if ((i >= 0) && (i < ((List)localObject2).size()))
      {
        paramSlideItemInfo = ((agfv)localObject1).a(i);
        paramSlideItemInfo.selectStatus = 2;
        localObject1 = paramSlideItemInfo.path;
        localObject2 = agaq.a(paramSlideItemInfo.mMimeType);
        if ((this.jdField_a_of_type_Aggg.s) && (localObject2 != null) && ("video".equals(localObject2[0])))
        {
          localObject2 = this.jdField_a_of_type_Aggg;
          ((aggg)localObject2).jdField_f_of_type_Int -= 1;
          if (this.jdField_a_of_type_Aggg.jdField_f_of_type_Int == 1) {
            this.jdField_a_of_type_Aggg.jdField_a_of_type_ComTencentMobileqqActivityPhotoLocalMediaInfo = paramSlideItemInfo;
          }
        }
        if ((!TextUtils.isEmpty(paramSlideItemInfo.mMimeType)) && ("image/gif".equals(paramSlideItemInfo.mMimeType)))
        {
          localObject2 = this.jdField_a_of_type_Aggg;
          ((aggg)localObject2).jdField_g_of_type_Int -= 1;
        }
        this.jdField_a_of_type_Aggf.jdField_a_of_type_JavaUtilArrayList.remove(localObject1);
        this.jdField_a_of_type_Aggf.jdField_b_of_type_JavaUtilArrayList.remove(paramSlideItemInfo.position);
        if ((this.jdField_a_of_type_Aggg.w) || (this.jdField_a_of_type_Aggf.a())) {
          this.jdField_a_of_type_Aggf.jdField_a_of_type_JavaUtilHashMap.remove(localObject1);
        }
        ageh.a(((NewPhotoListActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).getIntent(), "param_cancelSelNum");
        localObject2 = (HashMap)baaf.jdField_b_of_type_JavaUtilHashMap.get(this.jdField_a_of_type_Aggf.jdField_c_of_type_JavaLangString);
        if (localObject2 != null) {
          ((HashMap)localObject2).remove(localObject1);
        }
        localObject2 = baaf.jdField_c_of_type_JavaUtilHashMap;
        if (((HashMap)localObject2).containsKey(localObject1)) {
          ((HashMap)localObject2).remove(localObject1);
        }
        if (this.jdField_a_of_type_Aggl != null) {
          this.jdField_a_of_type_Aggl.a(false, paramSlideItemInfo);
        }
        ((NewPhotoListActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).a(i, false);
        d();
        vhg.a().b(localArrayList, this.jdField_a_of_type_Aggf.jdField_b_of_type_JavaUtilHashMap);
      }
      label410:
      while (i != -1)
      {
        return;
        i += 1;
        break;
      }
      localArrayList.remove(paramSlideItemInfo.jdField_b_of_type_JavaLangString);
      if ((this.jdField_a_of_type_Aggg.w) || (this.jdField_a_of_type_Aggf.a())) {
        this.jdField_a_of_type_Aggf.jdField_a_of_type_JavaUtilHashMap.remove(paramSlideItemInfo.jdField_b_of_type_JavaLangString);
      }
      ageh.a(((NewPhotoListActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).getIntent(), "param_cancelSelNum");
      localObject1 = (HashMap)baaf.jdField_b_of_type_JavaUtilHashMap.get(this.jdField_a_of_type_Aggf.jdField_c_of_type_JavaLangString);
      if (localObject1 != null) {
        ((HashMap)localObject1).remove(paramSlideItemInfo.jdField_b_of_type_JavaLangString);
      }
      localObject1 = baaf.jdField_c_of_type_JavaUtilHashMap;
      if (((HashMap)localObject1).containsKey(paramSlideItemInfo.jdField_b_of_type_JavaLangString)) {
        ((HashMap)localObject1).remove(paramSlideItemInfo.jdField_b_of_type_JavaLangString);
      }
      ((NewPhotoListActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).i();
      d();
      vhg.a().b(localArrayList, this.jdField_a_of_type_Aggf.jdField_b_of_type_JavaUtilHashMap);
      return;
      label577:
      i = -1;
    }
  }
  
  protected void a(LocalMediaInfo paramLocalMediaInfo)
  {
    if (new File(paramLocalMediaInfo.path).length() > axwv.a())
    {
      bbmy.a((Context)this.jdField_a_of_type_MqqUtilWeakReference.get(), ((NewPhotoListActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).getResources().getString(2131629431), 0).b(((NewPhotoListActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).jdField_g_of_type_Int);
      this.jdField_a_of_type_Aggg.jdField_e_of_type_Int = 0;
      ((NewPhotoListActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).j();
    }
  }
  
  protected void a(LocalMediaInfo paramLocalMediaInfo, int paramInt)
  {
    baaf.a();
    String str = paramLocalMediaInfo.path;
    Intent localIntent = ((NewPhotoListActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).getIntent();
    localIntent.putExtra("ALBUM_NAME", this.jdField_a_of_type_Aggf.jdField_b_of_type_JavaLangString);
    localIntent.putExtra("ALBUM_ID", this.jdField_a_of_type_Aggf.jdField_c_of_type_JavaLangString);
    localIntent.putExtra("PhotoConst.IS_SINGLE_MODE", true);
    localIntent.putStringArrayListExtra("PhotoConst.PHOTO_PATHS", this.jdField_a_of_type_Aggf.jdField_a_of_type_JavaUtilArrayList);
    localIntent.putExtra("PhotoConst.SINGLE_PHOTO_PATH", str);
    localIntent.putExtra("media_info", paramLocalMediaInfo);
    if (localIntent.getBooleanExtra("PhotoConst.MULTI_PREVIEW_IN_SINGLE_MODE", false))
    {
      localIntent.putStringArrayListExtra("PhotoConst.PHOTO_PATHS", this.jdField_a_of_type_Aggf.jdField_c_of_type_JavaUtilArrayList);
      localIntent.putExtra("PhotoConst.CURRENT_SELECTED_INDEX", paramLocalMediaInfo.position);
    }
    if (this.jdField_a_of_type_Aggg.jdField_i_of_type_Boolean)
    {
      paramLocalMediaInfo = baaf.jdField_c_of_type_JavaUtilHashMap;
      if (!paramLocalMediaInfo.containsKey(str)) {
        paramLocalMediaInfo.put(str, new Pair(this.jdField_a_of_type_Aggf.jdField_c_of_type_JavaLangString, this.jdField_a_of_type_Aggf.jdField_b_of_type_JavaLangString));
      }
      ((NewPhotoListActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).b(str);
      PhotoUtils.a((Activity)this.jdField_a_of_type_MqqUtilWeakReference.get(), localIntent, this.jdField_a_of_type_Aggf.jdField_a_of_type_JavaUtilArrayList, 0, this.jdField_a_of_type_Aggg.jdField_a_of_type_Boolean);
      return;
    }
    if (!this.jdField_a_of_type_Aggg.j)
    {
      localIntent.putExtra("PhotoConst.ALLOW_LOCK", false);
      localIntent.setClass((Context)this.jdField_a_of_type_MqqUtilWeakReference.get(), NewPhotoPreviewActivity.class);
      localIntent.putExtra("PasterConstants.pasters_data", this.jdField_a_of_type_Aggg.jdField_b_of_type_JavaUtilHashMap);
      localIntent.putExtra("FROM_WHERE", "FROM_PHOTO_LIST");
      localIntent.putExtra("PhotoConst.SOURCE_FROM", "FROM_SELECT_PHOTO");
      localIntent.addFlags(603979776);
      ((NewPhotoListActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).startActivity(localIntent);
      ((NewPhotoListActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).finish();
      baaf.a((Activity)this.jdField_a_of_type_MqqUtilWeakReference.get(), true, true);
      return;
    }
    paramInt = localIntent.getIntExtra("Business_Origin", 0);
    if ((100 == paramInt) || (102 == paramInt) || (103 == paramInt)) {
      if (100 == paramInt)
      {
        int i = azyk.b((Activity)this.jdField_a_of_type_MqqUtilWeakReference.get());
        localIntent.putExtra("PhotoConst.CLIP_WIDTH", i);
        localIntent.putExtra("PhotoConst.CLIP_HEIGHT", i);
        localIntent.putExtra("PhotoConst.TARGET_WIDTH", 1080);
        localIntent.putExtra("PhotoConst.TARGET_HEIGHT", 1080);
        localIntent.putExtra("PhotoConst.TARGET_SAMPLE_SIZE", 1620);
        label467:
        localIntent.setClass((Context)this.jdField_a_of_type_MqqUtilWeakReference.get(), PhotoCropForPortraitActivity.class);
        localIntent.putExtra("PhotoConst.EDIT_MASK_SHAPE_TYPE", ageu.c(paramInt));
      }
    }
    for (;;)
    {
      baaf.a(localIntent, this.jdField_a_of_type_Aggf.jdField_c_of_type_JavaLangString, str, this.jdField_a_of_type_Aggg.m);
      localIntent.putExtra("PHOTOLIST_START_POSITION", ((NewPhotoListActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).jdField_a_of_type_ComTencentWidgetGestureSelectGridView.getFirstVisiblePosition());
      break;
      localIntent.putExtra("PhotoConst.IS_WITH_PENDANT", false);
      localIntent.putExtra("PhotoConst.TARGET_WIDTH", 640);
      localIntent.putExtra("PhotoConst.TARGET_HEIGHT", 640);
      break label467;
      localIntent.setClass((Context)this.jdField_a_of_type_MqqUtilWeakReference.get(), PhotoCropActivity.class);
    }
  }
  
  public void a(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    a(((NewPhotoListActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).jdField_a_of_type_Agfv.a(paramInt), paramInt);
  }
  
  public void a(String paramString)
  {
    Intent localIntent = ((NewPhotoListActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).getIntent();
    ArrayList localArrayList = this.jdField_a_of_type_Aggf.jdField_a_of_type_JavaUtilArrayList;
    HashMap localHashMap = this.jdField_a_of_type_Aggf.jdField_a_of_type_JavaUtilHashMap;
    localIntent.putExtra("ALBUM_NAME", this.jdField_a_of_type_Aggf.jdField_b_of_type_JavaLangString);
    localIntent.putExtra("ALBUM_ID", this.jdField_a_of_type_Aggf.jdField_c_of_type_JavaLangString);
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
    if ((i > 0) && (i < ((NewPhotoListActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).jdField_a_of_type_Agfv.getCount()))
    {
      localObject = ((NewPhotoListActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).jdField_a_of_type_Agfv.a(i);
      if ((localObject != null) && (!localHashMap.containsKey(((LocalMediaInfo)localObject).path))) {
        localHashMap.put(((LocalMediaInfo)localObject).path, localObject);
      }
    }
    localIntent.putExtra("PeakConstants.selectedMediaInfoHashMap", localHashMap);
    localIntent.putExtra("PhotoConst.SHOW_ALBUM", false);
    localIntent.putExtra("FROM_WHERE", "FROM_PHOTO_LIST");
    aggg.jdField_a_of_type_Int = ((NewPhotoListActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).jdField_a_of_type_ComTencentWidgetGestureSelectGridView.getFirstVisiblePosition();
    localIntent.putExtra("PhotoConst.CURRENT_SELECTED_INDEX", localArrayList.indexOf(paramString));
    localIntent.setClass((Context)this.jdField_a_of_type_MqqUtilWeakReference.get(), NewPhotoPreviewActivity.class);
    localIntent.addFlags(603979776);
    c(localIntent);
    baaf.a((Activity)this.jdField_a_of_type_MqqUtilWeakReference.get(), true, true);
  }
  
  protected void a(boolean paramBoolean, Intent paramIntent)
  {
    baaf.a();
    paramIntent.putExtra("PhotoConst.SHOW_ALBUM", false);
    ArrayList localArrayList = this.jdField_a_of_type_Aggf.jdField_a_of_type_JavaUtilArrayList;
    if (!paramBoolean)
    {
      paramIntent.putStringArrayListExtra("PhotoConst.PHOTO_PATHS", localArrayList);
      if ((localArrayList != null) && (localArrayList.size() > 0)) {
        awqx.b(null, "CliOper", "", this.jdField_a_of_type_Aggf.jdField_a_of_type_JavaLangString, "0X8004072", "0X8004072", 0, localArrayList.size(), 0, "", "", "", "");
      }
      if ((this.jdField_a_of_type_Aggf.jdField_c_of_type_JavaUtilHashMap == null) || (this.jdField_a_of_type_Aggf.jdField_c_of_type_JavaUtilHashMap.size() <= 0)) {
        break label342;
      }
      paramIntent.putExtra("PhotoConst.PHOTO_INFOS", this.jdField_a_of_type_Aggf.jdField_c_of_type_JavaUtilHashMap);
      paramIntent.putExtra("PhotoConst.PHOTO_PATHS_FROM_QZONEALBUM", paramIntent.getSerializableExtra("PhotoConst.PHOTO_PATHS_FROM_QZONEALBUM"));
      paramIntent.putExtra("PhotoConst.CURRENT_SELECTED_INDEX", 0);
      paramIntent.putExtra("PhotoConst.USE_URL_PATH", true);
      paramIntent.putExtra("PhotoConst.QZONE_ALBUM_FROM_AIO", paramIntent.getBooleanExtra("PhotoConst.QZONE_ALBUM_FROM_AIO", false));
    }
    for (;;)
    {
      if (this.jdField_a_of_type_Aggg.w)
      {
        paramIntent.putExtra("PeakConstants.selectedMediaInfoHashMap", this.jdField_a_of_type_Aggf.jdField_a_of_type_JavaUtilHashMap);
        paramIntent.putExtra("PhotoConst.CURRENT_SELECTED_INDEX", 0);
      }
      paramIntent.putExtra("ALBUM_NAME", this.jdField_a_of_type_Aggf.jdField_b_of_type_JavaLangString);
      paramIntent.putExtra("ALBUM_ID", this.jdField_a_of_type_Aggf.jdField_c_of_type_JavaLangString);
      paramIntent.putExtra("FROM_WHERE", "FROM_PHOTO_LIST");
      paramIntent.putExtra("PhotoConst.CURRENT_QUALITY_TYPE", this.jdField_a_of_type_Aggg.jdField_e_of_type_Int);
      paramIntent.putExtra("PasterConstants.pasters_data", this.jdField_a_of_type_Aggg.jdField_b_of_type_JavaUtilHashMap);
      aggg.jdField_a_of_type_Int = ((NewPhotoListActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).jdField_a_of_type_ComTencentWidgetGestureSelectGridView.getFirstVisiblePosition();
      paramIntent.setClass((Context)this.jdField_a_of_type_MqqUtilWeakReference.get(), NewPhotoPreviewActivity.class);
      paramIntent.addFlags(603979776);
      c(paramIntent);
      baaf.a((Activity)this.jdField_a_of_type_MqqUtilWeakReference.get(), true, true);
      return;
      paramIntent.putExtra("PhotoConst.SINGLE_PHOTO_PATH", this.jdField_a_of_type_Aggg.jdField_f_of_type_JavaLangString);
      break;
      label342:
      paramIntent.putExtra("PhotoConst.USE_URL_PATH", false);
    }
  }
  
  public boolean a()
  {
    return true;
  }
  
  protected boolean a(LocalMediaInfo paramLocalMediaInfo, boolean paramBoolean)
  {
    Object localObject1 = this.jdField_a_of_type_Aggf;
    Object localObject2 = agaq.a(paramLocalMediaInfo.mMimeType);
    if ((!this.jdField_a_of_type_Aggg.s) && (localObject2 != null) && (!"image".equals(localObject2[0]))) {
      return false;
    }
    int i = paramLocalMediaInfo.selectStatus;
    if (((i == 1) && (paramBoolean)) || ((i == 2) && (!paramBoolean))) {
      return false;
    }
    if ((i == 2) && (paramBoolean) && (((aggf)localObject1).jdField_a_of_type_JavaUtilArrayList.size() >= ((aggf)localObject1).jdField_a_of_type_Int))
    {
      long l = System.currentTimeMillis();
      if (l - this.jdField_a_of_type_Aggg.jdField_e_of_type_Long >= 700L)
      {
        bbmy.a((Context)this.jdField_a_of_type_MqqUtilWeakReference.get(), a(paramLocalMediaInfo), 1000).b(((NewPhotoListActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).jdField_g_of_type_Int);
        this.jdField_a_of_type_Aggg.jdField_e_of_type_Long = l;
        this.jdField_a_of_type_Aggg.y = true;
        ((NewPhotoListActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).b();
      }
      return false;
    }
    this.jdField_a_of_type_Aggg.y = false;
    String str = paramLocalMediaInfo.path;
    if (paramBoolean)
    {
      if ((this.jdField_a_of_type_Aggg.s) && (localObject2 != null) && ("video".equals(localObject2[0])))
      {
        localObject2 = this.jdField_a_of_type_Aggg;
        ((aggg)localObject2).jdField_f_of_type_Int += 1;
        if (this.jdField_a_of_type_Aggg.jdField_f_of_type_Int == 1) {
          this.jdField_a_of_type_Aggg.jdField_a_of_type_ComTencentMobileqqActivityPhotoLocalMediaInfo = paramLocalMediaInfo;
        }
      }
      if ((!TextUtils.isEmpty(paramLocalMediaInfo.mMimeType)) && ("image/gif".equals(paramLocalMediaInfo.mMimeType)))
      {
        localObject2 = this.jdField_a_of_type_Aggg;
        ((aggg)localObject2).jdField_g_of_type_Int += 1;
      }
      ((aggf)localObject1).jdField_a_of_type_JavaUtilArrayList.add(str);
      ((aggf)localObject1).jdField_b_of_type_JavaUtilArrayList.add(paramLocalMediaInfo.position);
      if ((this.jdField_a_of_type_Aggg.w) || (this.jdField_a_of_type_Aggf.a())) {
        ((aggf)localObject1).jdField_a_of_type_JavaUtilHashMap.put(str, paramLocalMediaInfo);
      }
      if (this.jdField_a_of_type_Aggg.jdField_b_of_type_JavaUtilHashSet.contains(str)) {
        this.jdField_a_of_type_Aggg.jdField_b_of_type_JavaUtilHashSet.remove(str);
      }
      this.jdField_a_of_type_Aggg.jdField_a_of_type_JavaUtilHashSet.add(str);
      ageh.a(((NewPhotoListActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).getIntent(), "param_totalSelNum");
      localObject1 = ((NewPhotoListActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).getIntent();
      if (!((Intent)localObject1).hasExtra("param_initTime")) {
        ((Intent)localObject1).putExtra("param_initTime", System.currentTimeMillis());
      }
      paramLocalMediaInfo.selectStatus = 1;
      paramLocalMediaInfo = (LinkedHashMap)baaf.jdField_b_of_type_JavaUtilHashMap.get(this.jdField_a_of_type_Aggf.jdField_c_of_type_JavaLangString);
      if (paramLocalMediaInfo != null) {
        break label871;
      }
      paramLocalMediaInfo = new LinkedHashMap();
      baaf.jdField_b_of_type_JavaUtilHashMap.put(this.jdField_a_of_type_Aggf.jdField_c_of_type_JavaLangString, paramLocalMediaInfo);
    }
    label871:
    for (;;)
    {
      paramLocalMediaInfo.put(str, Integer.valueOf(((NewPhotoListActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).jdField_a_of_type_ComTencentWidgetGestureSelectGridView.getFirstVisiblePosition()));
      paramLocalMediaInfo = baaf.jdField_c_of_type_JavaUtilHashMap;
      if (!paramLocalMediaInfo.containsKey(str)) {
        paramLocalMediaInfo.put(str, new Pair(this.jdField_a_of_type_Aggf.jdField_c_of_type_JavaLangString, this.jdField_a_of_type_Aggf.jdField_b_of_type_JavaLangString));
      }
      return true;
      if ((this.jdField_a_of_type_Aggg.s) && (localObject2 != null) && ("video".equals(localObject2[0])))
      {
        localObject2 = this.jdField_a_of_type_Aggg;
        ((aggg)localObject2).jdField_f_of_type_Int -= 1;
        if (this.jdField_a_of_type_Aggg.jdField_f_of_type_Int == 1) {
          this.jdField_a_of_type_Aggg.jdField_a_of_type_ComTencentMobileqqActivityPhotoLocalMediaInfo = paramLocalMediaInfo;
        }
      }
      if ((!TextUtils.isEmpty(paramLocalMediaInfo.mMimeType)) && ("image/gif".equals(paramLocalMediaInfo.mMimeType)))
      {
        localObject2 = this.jdField_a_of_type_Aggg;
        ((aggg)localObject2).jdField_g_of_type_Int -= 1;
      }
      ((aggf)localObject1).jdField_a_of_type_JavaUtilArrayList.remove(paramLocalMediaInfo.path);
      ((aggf)localObject1).jdField_b_of_type_JavaUtilArrayList.remove(paramLocalMediaInfo.position);
      if ((this.jdField_a_of_type_Aggg.w) || (this.jdField_a_of_type_Aggf.a())) {
        ((aggf)localObject1).jdField_a_of_type_JavaUtilHashMap.remove(str);
      }
      if (this.jdField_a_of_type_Aggg.jdField_a_of_type_JavaUtilHashSet.contains(paramLocalMediaInfo.path)) {
        this.jdField_a_of_type_Aggg.jdField_a_of_type_JavaUtilHashSet.remove(paramLocalMediaInfo.path);
      }
      for (;;)
      {
        paramLocalMediaInfo.selectStatus = 2;
        ageh.a(((NewPhotoListActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).getIntent(), "param_cancelSelNum");
        paramLocalMediaInfo = (HashMap)baaf.jdField_b_of_type_JavaUtilHashMap.get(this.jdField_a_of_type_Aggf.jdField_c_of_type_JavaLangString);
        if (paramLocalMediaInfo != null) {
          paramLocalMediaInfo.remove(str);
        }
        paramLocalMediaInfo = baaf.jdField_c_of_type_JavaUtilHashMap;
        if (!paramLocalMediaInfo.containsKey(str)) {
          break;
        }
        paramLocalMediaInfo.remove(str);
        break;
        this.jdField_a_of_type_Aggg.jdField_b_of_type_JavaUtilHashSet.add(paramLocalMediaInfo.path);
      }
    }
  }
  
  public View b(int paramInt, View paramView, ViewGroup paramViewGroup, agfw paramagfw, agft paramagft)
  {
    paramViewGroup = paramView;
    if (paramView == null)
    {
      paramView = ((NewPhotoListActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).jdField_a_of_type_Agfv.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2131495597, null);
      paramView.setLayoutParams(new AbsListView.LayoutParams(((NewPhotoListActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).jdField_a_of_type_Int, ((NewPhotoListActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).jdField_b_of_type_Int));
      paramagfw.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131305863));
      paramagfw.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131305869));
      paramagfw.c = ((ImageView)paramView.findViewById(2131305867));
      paramagfw.d = ((ImageView)paramView.findViewById(2131305868));
      paramagfw.jdField_a_of_type_AndroidViewView = paramView.findViewById(2131305865);
      paramagfw.jdField_a_of_type_ComTencentMobileqqWidgetNumberCheckBox = ((NumberCheckBox)paramView.findViewById(2131305866));
      if (this.jdField_a_of_type_Aggf.jdField_a_of_type_Int > 100) {
        paramagfw.jdField_a_of_type_ComTencentMobileqqWidgetNumberCheckBox.setTextSize(10.0F);
      }
      paramagfw.jdField_a_of_type_Agft = paramagft;
      if (paramagfw.jdField_a_of_type_AndroidViewView != null) {
        paramagfw.jdField_a_of_type_AndroidViewView.setOnClickListener(paramagfw.jdField_a_of_type_Agft);
      }
      paramView.setTag(paramagfw);
      paramViewGroup = paramView;
      if (!this.jdField_a_of_type_Aggg.jdField_e_of_type_Boolean)
      {
        paramViewGroup = paramView;
        if (this.jdField_a_of_type_Aggg.s)
        {
          paramagfw.jdField_a_of_type_AndroidViewView.setVisibility(0);
          paramViewGroup = paramView;
        }
      }
    }
    paramagfw.jdField_a_of_type_Agft.a(paramInt);
    paramagfw.jdField_a_of_type_Agft.a(paramagfw.jdField_a_of_type_ComTencentMobileqqWidgetNumberCheckBox);
    ImageView localImageView = paramagfw.jdField_b_of_type_AndroidWidgetImageView;
    localImageView.setAdjustViewBounds(false);
    paramagft = ((NewPhotoListActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).jdField_a_of_type_Agfv.a(paramInt);
    paramViewGroup.setContentDescription(PhotoUtils.a(1, paramagft, paramInt));
    int i;
    if (paramagft.isSystemMeidaStore)
    {
      paramView = baaf.a(paramagft, "VIDEO");
      i = axoh.jdField_a_of_type_Int;
      paramagft.thumbHeight = i;
      paramagft.thumbWidth = i;
      URLDrawable localURLDrawable = paramagfw.jdField_a_of_type_ComTencentImageURLDrawable;
      if ((localURLDrawable == null) || (!localURLDrawable.getURL().equals(paramView)))
      {
        if (QLog.isColorLevel()) {
          QLog.d("PhotoListActivity", 2, "PhotoListAdapter,getView(),vedio url :" + paramView.toString());
        }
        paramView = axwd.a(paramView, ((NewPhotoListActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).jdField_a_of_type_Agfv.jdField_a_of_type_AndroidGraphicsDrawableColorDrawable, ((NewPhotoListActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).jdField_a_of_type_Agfv.jdField_a_of_type_AndroidGraphicsDrawableDrawable);
        paramView.setTag(paramagft);
        localImageView.setImageDrawable(paramView);
        ((URLImageView)localImageView).setURLDrawableDownListener(((NewPhotoListActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).jdField_a_of_type_Agfv);
        paramagfw.jdField_a_of_type_ComTencentImageURLDrawable = paramView;
        if (localURLDrawable != null) {
          localURLDrawable.cancelDownload();
        }
      }
      paramView = paramagfw.jdField_a_of_type_AndroidWidgetTextView;
      if ((paramagft.isSystemMeidaStore) || (paramagft.mDuration > 0L)) {
        break label631;
      }
      paramView.setVisibility(8);
      paramView = agak.a(BaseApplicationImpl.getContext());
      if (paramView != null) {
        paramView.a(this, paramagft, paramInt);
      }
      label542:
      paramView = paramagfw.c;
      i = paramagft.selectStatus;
      if (i != 1) {
        break label651;
      }
      paramView.setVisibility(0);
      paramagfw.jdField_a_of_type_ComTencentMobileqqWidgetNumberCheckBox.setCheckedNumber(this.jdField_a_of_type_Aggf.jdField_a_of_type_JavaUtilArrayList.indexOf(paramagft.path) + 1);
      if (paramViewGroup.getBackground() != null) {
        paramViewGroup.setBackgroundDrawable(null);
      }
    }
    for (;;)
    {
      paramagft.visableTime = SystemClock.uptimeMillis();
      paramagft.listViewPosition = paramInt;
      return paramViewGroup;
      paramView = baaf.a(paramagft, "APP_VIDEO");
      break;
      label631:
      paramView.setVisibility(0);
      paramView.setText(NewPhotoListActivity.a(paramagft.mDuration));
      break label542;
      label651:
      if (i == 3)
      {
        paramView.setVisibility(4);
        paramagfw.jdField_a_of_type_ComTencentMobileqqWidgetNumberCheckBox.setChecked(false);
      }
      else
      {
        paramView.setVisibility(4);
        paramagfw.jdField_a_of_type_ComTencentMobileqqWidgetNumberCheckBox.setChecked(false);
        if (paramViewGroup.getBackground() != null) {
          paramViewGroup.setBackgroundDrawable(null);
        }
      }
    }
  }
  
  protected void b(Intent paramIntent)
  {
    Object localObject = this.jdField_a_of_type_Aggf.jdField_a_of_type_JavaUtilArrayList;
    HashMap localHashMap1 = this.jdField_a_of_type_Aggf.jdField_a_of_type_JavaUtilHashMap;
    paramIntent.putStringArrayListExtra("PhotoConst.PHOTO_PATHS", (ArrayList)localObject);
    if (this.jdField_a_of_type_Aggg.w)
    {
      HashMap localHashMap2 = new HashMap(localHashMap1);
      Iterator localIterator = ((ArrayList)localObject).iterator();
      while (localIterator.hasNext())
      {
        String str = (String)localIterator.next();
        localObject = null;
        if (this.jdField_a_of_type_Aggf.jdField_b_of_type_JavaUtilHashMap != null) {
          localObject = (LocalMediaInfo)this.jdField_a_of_type_Aggf.jdField_b_of_type_JavaUtilHashMap.get(str);
        }
        if (localObject != null)
        {
          localHashMap2.put(str, localObject);
        }
        else
        {
          localObject = (LocalMediaInfo)localHashMap1.get(str);
          if (localObject != null) {
            localHashMap2.put(str, localObject);
          }
        }
      }
      paramIntent.putExtra("PeakConstants.selectedMediaInfoHashMap", localHashMap2);
    }
    paramIntent.putExtra("PhotoConst.CURRENT_QUALITY_TYPE", this.jdField_a_of_type_Aggg.jdField_e_of_type_Int);
    paramIntent.putExtra("PhotoConst.IS_SHOW_QZONE_ALBUM", this.jdField_a_of_type_Aggf.jdField_c_of_type_Boolean);
    paramIntent.putExtra("PhotoConst.PHOTO_INFOS", this.jdField_a_of_type_Aggf.jdField_c_of_type_JavaUtilHashMap);
    paramIntent.putExtra("peak.myUin", this.jdField_a_of_type_Aggf.jdField_a_of_type_JavaLangString);
  }
  
  protected void b(View paramView)
  {
    if (!((NewPhotoListActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).jdField_a_of_type_AndroidWidgetCheckBox.isChecked())
    {
      if (baaf.a(this.jdField_a_of_type_Aggf.jdField_a_of_type_JavaUtilArrayList, this.jdField_a_of_type_Aggf.jdField_b_of_type_Int, this.jdField_a_of_type_Aggf.jdField_b_of_type_JavaUtilHashMap, false, this.jdField_a_of_type_Aggf.jdField_a_of_type_JavaUtilHashMap) > 0)
      {
        bbmy.a((Context)this.jdField_a_of_type_MqqUtilWeakReference.get(), ((NewPhotoListActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).getResources().getString(2131629431), 0).b(((NewPhotoListActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).getResources().getDimensionPixelSize(2131167766));
        return;
      }
      ((NewPhotoListActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).jdField_a_of_type_AndroidWidgetCheckBox.setChecked(true);
      return;
    }
    ((NewPhotoListActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).jdField_a_of_type_AndroidWidgetCheckBox.setChecked(false);
  }
  
  public void b(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    if (!azzz.b()) {
      bbmy.a((Context)this.jdField_a_of_type_MqqUtilWeakReference.get(), ((NewPhotoListActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).getResources().getString(2131653216), 0).a();
    }
    do
    {
      return;
      paramView = ((NewPhotoListActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).jdField_a_of_type_Agfv.a(paramInt);
    } while (paramView == null);
    paramAdapterView = ((NewPhotoListActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).getIntent();
    if (paramView.fileSize > this.jdField_a_of_type_Aggg.jdField_a_of_type_Long)
    {
      paramAdapterView = babr.a((Activity)this.jdField_a_of_type_MqqUtilWeakReference.get(), "你选择的视频文件过大，无法发送。");
      paramAdapterView.setPositiveButton(2131629116, new baca());
      paramAdapterView.show();
      return;
    }
    Object localObject1 = baaf.jdField_c_of_type_JavaUtilHashMap;
    Object localObject2;
    if (!((HashMap)localObject1).containsKey(paramView.path))
    {
      localObject2 = new Pair(this.jdField_a_of_type_Aggf.jdField_c_of_type_JavaLangString, this.jdField_a_of_type_Aggf.jdField_b_of_type_JavaLangString);
      ((HashMap)localObject1).put(paramView.path, localObject2);
    }
    ((NewPhotoListActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).b(paramView.path);
    if (!this.jdField_a_of_type_Aggg.jdField_c_of_type_Boolean)
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
    if (!this.jdField_a_of_type_Aggg.jdField_e_of_type_Boolean)
    {
      paramView = ((NewPhotoListActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).getIntent();
      paramView.putExtra("ALBUM_NAME", this.jdField_a_of_type_Aggf.jdField_b_of_type_JavaLangString);
      paramView.putExtra("ALBUM_ID", this.jdField_a_of_type_Aggf.jdField_c_of_type_JavaLangString);
      localObject1 = ((NewPhotoListActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).jdField_a_of_type_Agfv.a(paramInt);
      paramView.putExtra("PhotoConst.CURRENT_SELECTED_INDEX", ((LocalMediaInfo)localObject1).position);
      paramView.putStringArrayListExtra("PhotoConst.SELECTED_PATHS", this.jdField_a_of_type_Aggf.jdField_a_of_type_JavaUtilArrayList);
      paramView.putIntegerArrayListExtra("PhotoConst.SELECTED_INDEXS", this.jdField_a_of_type_Aggf.jdField_b_of_type_JavaUtilArrayList);
      paramView.putExtra("FROM_WHERE", "FROM_PHOTO_LIST");
      paramView.putExtra("PhotoConst.CURRENT_QUALITY_TYPE", this.jdField_a_of_type_Aggg.jdField_e_of_type_Int);
      paramView.putExtra("PhotoConst.SHOW_ALBUM", true);
      paramView.putExtra("PhotoConst.SHOW_MAGIC_USE_PASTER", this.jdField_a_of_type_Aggg.jdField_h_of_type_Boolean);
      paramView.putExtra("PasterConstants.paster_id", this.jdField_a_of_type_Aggg.jdField_a_of_type_JavaLangString);
      paramView.putExtra("PasterConstants.paster_cate_id", this.jdField_a_of_type_Aggg.jdField_b_of_type_JavaLangString);
      aggg.jdField_a_of_type_Int = ((NewPhotoListActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).jdField_a_of_type_ComTencentWidgetGestureSelectGridView.getFirstVisiblePosition();
      localObject2 = this.jdField_a_of_type_Aggf.jdField_a_of_type_JavaUtilHashMap;
      if (!((HashMap)localObject2).containsKey(((LocalMediaInfo)localObject1).path)) {
        ((HashMap)localObject2).put(((LocalMediaInfo)localObject1).path, localObject1);
      }
      paramView.putExtra("PeakConstants.selectedMediaInfoHashMap", (Serializable)localObject2);
      paramView.putExtra("PasterConstants.pasters_data", this.jdField_a_of_type_Aggg.jdField_b_of_type_JavaUtilHashMap);
      paramView.setClass((Context)this.jdField_a_of_type_MqqUtilWeakReference.get(), NewPhotoPreviewActivity.class);
      paramView.addFlags(603979776);
      if ((this.jdField_a_of_type_Aggf.jdField_a_of_type_JavaUtilArrayList != null) && (this.jdField_a_of_type_Aggf.jdField_a_of_type_JavaUtilArrayList.size() > 0)) {
        awqx.b(null, "CliOper", "", this.jdField_a_of_type_Aggf.jdField_a_of_type_JavaLangString, "0X8005674", "0X8005674", 0, this.jdField_a_of_type_Aggf.jdField_a_of_type_JavaUtilArrayList.size(), 0, "", "", "", "");
      }
      if (this.jdField_a_of_type_Aggf.a()) {
        ((NewPhotoListActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).startActivityForResult(paramAdapterView, 100010);
      }
      for (;;)
      {
        baaf.a((Activity)this.jdField_a_of_type_MqqUtilWeakReference.get(), true, true);
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
    ((Intent)localObject1).putExtra("uin", this.jdField_a_of_type_Aggg.jdField_e_of_type_JavaLangString);
    ((Intent)localObject1).putExtra("uintype", this.jdField_a_of_type_Aggg.jdField_d_of_type_Int);
    ((Intent)localObject1).putExtra("file_source", "album");
    ((Intent)localObject1).putExtra("is_from_system_media", paramView.isSystemMeidaStore);
    if (this.jdField_a_of_type_Aggg.s)
    {
      ((Intent)localObject1).putExtra("PhotoConst.IS_SUPPORT_VIDEO_CHECKBOX", true);
      ((Intent)localObject1).putExtra("PhotoConst.PHOTO_PATHS", this.jdField_a_of_type_Aggf.jdField_a_of_type_JavaUtilArrayList);
    }
    ((NewPhotoListActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).startActivityForResult((Intent)localObject1, 17);
  }
  
  protected void c() {}
  
  protected void c(Intent paramIntent)
  {
    ((NewPhotoListActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).startActivity(paramIntent);
    ((NewPhotoListActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).finish();
  }
  
  protected void c(View paramView)
  {
    a(false, ((NewPhotoListActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).getIntent());
  }
  
  public void c(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    if (!azzz.b())
    {
      bbmy.a((Context)this.jdField_a_of_type_MqqUtilWeakReference.get(), ((NewPhotoListActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).getResources().getString(2131653216), 0).a();
      return;
    }
    ((NewPhotoListActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).k();
  }
  
  protected void d()
  {
    ArrayList localArrayList = this.jdField_a_of_type_Aggf.jdField_a_of_type_JavaUtilArrayList;
    String str;
    boolean bool;
    if (this.jdField_a_of_type_Aggg.jdField_c_of_type_JavaLangString != null)
    {
      str = this.jdField_a_of_type_Aggg.jdField_c_of_type_JavaLangString;
      if (localArrayList.size() <= 0) {
        break label529;
      }
      bool = true;
      label35:
      if (!bool) {
        break label575;
      }
      str = str + "(" + localArrayList.size() + ")";
    }
    label529:
    label575:
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("_photo", 2, "updateButton selectedPhotoList.size()=" + localArrayList.size());
      }
      ((NewPhotoListActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).c.setText(str);
      ((NewPhotoListActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).c.setEnabled(bool);
      ((NewPhotoListActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).jdField_b_of_type_AndroidWidgetButton.setEnabled(bool);
      if (!bool)
      {
        ((NewPhotoListActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).jdField_a_of_type_AndroidWidgetCheckBox.setChecked(false);
        ((NewPhotoListActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).jdField_a_of_type_AndroidWidgetCheckBox.setEnabled(false);
        ((NewPhotoListActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).jdField_a_of_type_AndroidWidgetTextView.setEnabled(false);
        ((NewPhotoListActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).jdField_b_of_type_AndroidWidgetTextView.setEnabled(false);
      }
      if (this.jdField_a_of_type_Aggg.jdField_h_of_type_Boolean) {
        if ((localArrayList.size() == 1) && ((this.jdField_a_of_type_Aggf.jdField_c_of_type_JavaUtilHashMap == null) || (this.jdField_a_of_type_Aggf.jdField_c_of_type_JavaUtilHashMap.size() <= 0)) && (((NewPhotoListActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).a((String)localArrayList.get(0)) == 0)) {
          ((NewPhotoListActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).jdField_a_of_type_AndroidWidgetButton.setEnabled(true);
        }
      }
      for (;;)
      {
        ((NewPhotoListActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).jdField_a_of_type_AndroidWidgetCheckBox.setVisibility(8);
        ((NewPhotoListActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
        ((NewPhotoListActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
        if (this.jdField_a_of_type_Aggg.jdField_f_of_type_Boolean)
        {
          ((NewPhotoListActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).jdField_a_of_type_AndroidWidgetCheckBox.setVisibility(0);
          ((NewPhotoListActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
          if (bool)
          {
            ((NewPhotoListActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).jdField_a_of_type_AndroidWidgetCheckBox.setEnabled(true);
            ((NewPhotoListActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).jdField_a_of_type_AndroidWidgetTextView.setEnabled(true);
            ((NewPhotoListActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).jdField_b_of_type_AndroidWidgetTextView.setEnabled(true);
          }
        }
        ((NewPhotoListActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).j();
        if (!this.jdField_a_of_type_Aggg.jdField_g_of_type_Boolean) {
          ((NewPhotoListActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
        }
        return;
        str = ((NewPhotoListActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).getString(2131629407);
        break;
        bool = false;
        break label35;
        ((NewPhotoListActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).jdField_a_of_type_AndroidWidgetButton.setEnabled(false);
        continue;
        ((NewPhotoListActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).jdField_a_of_type_AndroidWidgetButton.setVisibility(8);
      }
    }
  }
  
  protected void d(Intent paramIntent)
  {
    paramIntent = paramIntent.getStringArrayListExtra("PhotoConst.PHOTO_PATHS");
    if ((paramIntent != null) && (paramIntent.size() > 0) && (!TextUtils.isEmpty((CharSequence)paramIntent.get(0)))) {
      ThreadManager.postImmediately(new PhotoListLogicDefault.7(this, (String)paramIntent.get(0)), null, true);
    }
  }
  
  protected void d(View paramView)
  {
    ((NewPhotoListActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).c.setClickable(false);
    if (!this.jdField_a_of_type_Aggf.jdField_a_of_type_JavaUtilArrayList.isEmpty()) {
      ((NewPhotoListActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).b((String)this.jdField_a_of_type_Aggf.jdField_a_of_type_JavaUtilArrayList.get(this.jdField_a_of_type_Aggf.jdField_a_of_type_JavaUtilArrayList.size() - 1));
    }
    baaf.a();
    if (this.jdField_a_of_type_Aggf.jdField_a_of_type_JavaUtilArrayList.size() == 0)
    {
      if (QLog.isColorLevel()) {
        QLog.e("PhotoList", 2, "size == 0");
      }
      return;
    }
    if (((NewPhotoListActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).getIntent().getBooleanExtra("PhotoConst.IS_SEND_FILESIZE_LIMIT", false))
    {
      paramView = this.jdField_a_of_type_Aggf.jdField_a_of_type_JavaUtilArrayList.iterator();
      for (long l = 0L; paramView.hasNext(); l = bace.a((String)paramView.next()) + l) {}
      if (apck.a())
      {
        apbx.a((Context)this.jdField_a_of_type_MqqUtilWeakReference.get(), 2131627035, 2131627040, new aggq(this));
        return;
      }
    }
    e();
  }
  
  protected void e()
  {
    if (this.jdField_a_of_type_Aggf.jdField_c_of_type_JavaLangString.equals("$RecentAlbumId")) {
      awrn.a((Context)this.jdField_a_of_type_MqqUtilWeakReference.get()).a(null, "sendAlbumRecent", true, 0L, 0L, null, "");
    }
    PresendPicMgr localPresendPicMgr;
    for (;;)
    {
      localPresendPicMgr = PresendPicMgr.a();
      if ((!this.jdField_a_of_type_Aggg.jdField_h_of_type_Boolean) || ((TextUtils.isEmpty(this.jdField_a_of_type_Aggg.jdField_a_of_type_JavaLangString)) && (TextUtils.isEmpty(this.jdField_a_of_type_Aggg.jdField_b_of_type_JavaLangString)))) {
        break;
      }
      ((NewPhotoListActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).jdField_a_of_type_AndroidWidgetButton.performClick();
      return;
      if ((this.jdField_a_of_type_Aggf.jdField_b_of_type_JavaLangString.equalsIgnoreCase("Camera")) || (this.jdField_a_of_type_Aggf.jdField_b_of_type_JavaLangString.equalsIgnoreCase("camera")) || (this.jdField_a_of_type_Aggf.jdField_b_of_type_JavaLangString.contains("Camera")) || (this.jdField_a_of_type_Aggf.jdField_b_of_type_JavaLangString.contains("camera"))) {
        awrn.a((Context)this.jdField_a_of_type_MqqUtilWeakReference.get()).a(null, "sendAlbumRecent", false, 0L, 0L, null, "");
      } else {
        awrn.a((Context)this.jdField_a_of_type_MqqUtilWeakReference.get()).a(null, "sendAlbumOther", true, 0L, 0L, null, "");
      }
    }
    if (this.jdField_a_of_type_Aggf.jdField_a_of_type_JavaUtilArrayList != null)
    {
      ageh.a(((NewPhotoListActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).getIntent(), this.jdField_a_of_type_Aggf.jdField_a_of_type_JavaUtilArrayList.size());
      ageh.a(((NewPhotoListActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).getIntent(), this.jdField_a_of_type_Aggf.jdField_a_of_type_JavaUtilArrayList.size(), this.jdField_a_of_type_Aggg.jdField_e_of_type_Int);
    }
    Intent localIntent = ((NewPhotoListActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).getIntent();
    if (this.jdField_a_of_type_Aggg.jdField_e_of_type_Int == 2)
    {
      if (localPresendPicMgr != null)
      {
        localPresendPicMgr.a(1008);
        localPresendPicMgr.a();
      }
      awqx.b(null, "CliOper", "", "", "0X8005148", "0X8005148", 0, 0, "", "", "", "");
    }
    for (;;)
    {
      localIntent.getStringExtra("PhotoConst.PLUGIN_APK");
      localIntent.getStringExtra("PhotoConst.INIT_ACTIVITY_CLASS_NAME");
      if (this.jdField_a_of_type_Aggg.w) {
        localIntent.putExtra("PeakConstants.selectedMediaInfoHashMap", this.jdField_a_of_type_Aggf.jdField_a_of_type_JavaUtilHashMap);
      }
      if (this.jdField_a_of_type_Aggf.jdField_a_of_type_JavaUtilArrayList != null) {
        ahji.a(this.jdField_a_of_type_Aggf.jdField_a_of_type_JavaUtilArrayList);
      }
      ((NewPhotoListActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).a(localIntent);
      a(localIntent, false);
      return;
      if ((localPresendPicMgr != null) && (!this.jdField_a_of_type_Aggg.t)) {
        localPresendPicMgr.a(localIntent);
      }
    }
  }
  
  protected void e(Intent paramIntent)
  {
    ((NewPhotoListActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).e();
    long l = System.currentTimeMillis();
    Object localObject = paramIntent.getStringExtra("video_new_fake_vid");
    paramIntent = paramIntent.getStringExtra("file_video_source_dir");
    sjj localsjj = new sjj();
    localsjj.a(true);
    localObject = sjj.a((String)localObject);
    String str = ahub.a(((PublishVideoEntry)localObject).mLocalRawVideoDir);
    if (TextUtils.isEmpty(str))
    {
      QZLog.i("PhotoListActivity", 1, "get target path fail");
      return;
    }
    localsjj.a((PublishVideoEntry)localObject, str, false, true, new aggr(this, l, str, (PublishVideoEntry)localObject, paramIntent));
  }
  
  protected void f()
  {
    PhotoUtils.a((Activity)this.jdField_a_of_type_MqqUtilWeakReference.get(), ((NewPhotoListActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).getIntent(), this.jdField_a_of_type_Aggf.jdField_a_of_type_JavaUtilArrayList, this.jdField_a_of_type_Aggg.jdField_e_of_type_Int, this.jdField_a_of_type_Aggg.jdField_a_of_type_Boolean);
  }
  
  protected void g()
  {
    this.jdField_a_of_type_Aggg.o = true;
    a(null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     aggm
 * JD-Core Version:    0.7.0.1
 */