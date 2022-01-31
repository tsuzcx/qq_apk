import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.AsyncTask;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.Pair;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.biz.qqstory.database.PublishVideoEntry;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.config.AppSetting;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.activity.photo.PhotoUtils;
import com.tencent.mobileqq.activity.photo.album.NewPhotoListActivity;
import com.tencent.mobileqq.activity.photo.album.NewPhotoPreviewActivity;
import com.tencent.mobileqq.activity.photo.album.PhotoListLogicBase.1;
import com.tencent.mobileqq.activity.photo.album.PhotoListLogicBase.3;
import com.tencent.mobileqq.activity.photo.album.PhotoListLogicBase.4;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.widget.NumberCheckBox;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.AbsListView.LayoutParams;
import com.tencent.widget.AdapterView;
import com.tencent.widget.GestureSelectGridView;
import cooperation.qzone.util.QZLog;
import java.io.File;
import java.io.Serializable;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import mqq.util.WeakReference;

public class agsh
  extends agsc
  implements agsd, agse, agsf
{
  protected agsh(NewPhotoListActivity paramNewPhotoListActivity)
  {
    super(paramNewPhotoListActivity);
    this.jdField_a_of_type_Agsf = this;
    this.jdField_a_of_type_Agsd = this;
    this.jdField_a_of_type_Agse = this;
  }
  
  public Intent a(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    bbbx.a();
    paramAdapterView = ((NewPhotoListActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).jdField_a_of_type_Agrs.a(paramInt);
    paramView = ((NewPhotoListActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).getIntent();
    paramView.putExtra("ALBUM_NAME", this.jdField_a_of_type_Agrz.jdField_b_of_type_JavaLangString);
    paramView.putExtra("ALBUM_ID", this.jdField_a_of_type_Agrz.jdField_c_of_type_JavaLangString);
    paramView.putStringArrayListExtra("PhotoConst.SELECTED_PATHS", this.jdField_a_of_type_Agrz.jdField_a_of_type_JavaUtilArrayList);
    paramView.putIntegerArrayListExtra("PhotoConst.SELECTED_INDEXS", this.jdField_a_of_type_Agrz.jdField_b_of_type_JavaUtilArrayList);
    if (bbbx.a(paramAdapterView) == 0) {
      paramView.putExtra("PhotoConst.CURRENT_SELECTED_INDEX", paramAdapterView.position);
    }
    paramView.putExtra("FROM_WHERE", "FROM_PHOTO_LIST");
    paramView.putExtra("PhotoConst.SHOW_ALBUM", true);
    agsb.jdField_a_of_type_Int = ((NewPhotoListActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).jdField_a_of_type_ComTencentWidgetGestureSelectGridView.getFirstVisiblePosition();
    if (this.jdField_a_of_type_Agrz.jdField_d_of_type_Boolean)
    {
      if (!this.jdField_a_of_type_Agrz.jdField_a_of_type_JavaUtilHashMap.containsKey(paramAdapterView.path)) {
        this.jdField_a_of_type_Agrz.jdField_a_of_type_JavaUtilHashMap.put(paramAdapterView.path, paramAdapterView);
      }
      paramView.putExtra("PeakConstants.selectedMediaInfoHashMap", this.jdField_a_of_type_Agrz.jdField_a_of_type_JavaUtilHashMap);
    }
    paramView.setClass((Context)this.jdField_a_of_type_MqqUtilWeakReference.get(), NewPhotoPreviewActivity.class);
    paramView.addFlags(603979776);
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
      paramViewGroup.setImageResource(2130841050);
      paramViewGroup.setScaleType(ImageView.ScaleType.CENTER);
      return paramView;
    }
  }
  
  public View a(int paramInt, View paramView, ViewGroup paramViewGroup, agrt paramagrt, agrq paramagrq)
  {
    if (paramView == null)
    {
      paramViewGroup = ((NewPhotoListActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).jdField_a_of_type_Agrs.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2131560955, null);
      paramViewGroup.setLayoutParams(new AbsListView.LayoutParams(((NewPhotoListActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).jdField_a_of_type_Int, ((NewPhotoListActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).jdField_b_of_type_Int));
      paramagrt.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)paramViewGroup.findViewById(2131371559));
      paramagrt.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramViewGroup.findViewById(2131371520));
      paramagrt.c = ((ImageView)paramViewGroup.findViewById(2131368351));
      paramagrt.d = ((ImageView)paramViewGroup.findViewById(2131371564));
      paramagrt.jdField_a_of_type_AndroidViewView = paramViewGroup.findViewById(2131371561);
      paramagrt.jdField_a_of_type_ComTencentMobileqqWidgetNumberCheckBox = ((NumberCheckBox)paramViewGroup.findViewById(2131371562));
      paramagrt.e = ((ImageView)paramViewGroup.findViewById(2131371491));
      paramagrt.e.setVisibility(8);
      if (this.jdField_a_of_type_Agrz.jdField_a_of_type_Int > 100) {
        paramagrt.jdField_a_of_type_ComTencentMobileqqWidgetNumberCheckBox.setTextSize(10.0F);
      }
      paramagrt.jdField_a_of_type_Agrq = paramagrq;
      if (paramagrt.jdField_a_of_type_AndroidViewView != null) {
        paramagrt.jdField_a_of_type_AndroidViewView.setOnClickListener(paramagrt.jdField_a_of_type_Agrq);
      }
      paramViewGroup.setTag(paramagrt);
      paramView = paramViewGroup;
      if (!this.jdField_a_of_type_Agsa.jdField_c_of_type_Boolean)
      {
        paramagrt.jdField_a_of_type_AndroidViewView.setVisibility(0);
        paramView = paramViewGroup;
      }
    }
    for (;;)
    {
      paramagrt.jdField_a_of_type_Agrq.a(paramInt);
      paramagrt.jdField_a_of_type_Agrq.a(paramagrt.jdField_a_of_type_ComTencentMobileqqWidgetNumberCheckBox);
      paramagrq = paramagrt.jdField_b_of_type_AndroidWidgetImageView;
      paramagrq.setAdjustViewBounds(false);
      paramViewGroup = ((NewPhotoListActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).jdField_a_of_type_Agrs.a(paramInt);
      paramView.setContentDescription(PhotoUtils.a(0, paramViewGroup, paramInt));
      int i;
      if (paramViewGroup != null)
      {
        paramagrt.jdField_a_of_type_AndroidWidgetImageView.setVisibility(4);
        if ((!this.jdField_a_of_type_Agsa.j) || (!((NewPhotoListActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).a(paramViewGroup))) {
          break label842;
        }
        if (paramagrt.jdField_b_of_type_AndroidWidgetTextView == null)
        {
          paramagrt.jdField_b_of_type_AndroidWidgetTextView = ((NewPhotoListActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).jdField_a_of_type_Agrs.a();
          paramagrt.jdField_b_of_type_AndroidWidgetTextView.setText("GIF");
          localObject = new RelativeLayout.LayoutParams(-2, -2);
          ((RelativeLayout.LayoutParams)localObject).addRule(11);
          ((RelativeLayout.LayoutParams)localObject).addRule(12);
          ((RelativeLayout)paramView).addView(paramagrt.jdField_b_of_type_AndroidWidgetTextView, (ViewGroup.LayoutParams)localObject);
        }
        paramagrt.jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
        i = ayop.jdField_a_of_type_Int;
        paramViewGroup.thumbHeight = i;
        paramViewGroup.thumbWidth = i;
        Object localObject = paramagrt.jdField_a_of_type_ComTencentImageURLDrawable;
        StringBuilder localStringBuilder = new StringBuilder("albumthumb");
        localStringBuilder.append("://");
        localStringBuilder.append(paramViewGroup.path);
        if ((localObject == null) || (!((URLDrawable)localObject).getURL().toString().equals(localStringBuilder.toString())))
        {
          localObject = bbbx.a(paramViewGroup);
          if (QLog.isColorLevel()) {
            QLog.d("PhotoListActivity", 2, "PhotoListAdapter,getView(),image url :" + ((URL)localObject).toString());
          }
          localObject = aywm.a((URL)localObject, ((NewPhotoListActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).jdField_a_of_type_Agrs.jdField_a_of_type_AndroidGraphicsDrawableColorDrawable, ((NewPhotoListActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).jdField_a_of_type_Agrs.jdField_a_of_type_AndroidGraphicsDrawableDrawable);
          ((URLDrawable)localObject).setTag(paramViewGroup);
          paramagrq.setImageDrawable((Drawable)localObject);
          ((URLImageView)paramagrq).setURLDrawableDownListener(((NewPhotoListActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).jdField_a_of_type_Agrs);
          paramagrt.jdField_a_of_type_ComTencentImageURLDrawable = ((URLDrawable)localObject);
        }
        i = paramViewGroup.selectStatus;
        if (i != 1) {
          break label863;
        }
        paramagrt.jdField_a_of_type_ComTencentMobileqqWidgetNumberCheckBox.setCheckedNumber(this.jdField_a_of_type_Agrz.jdField_a_of_type_JavaUtilArrayList.indexOf(paramViewGroup.path) + 1);
        if (paramView.getBackground() != null) {
          paramView.setBackgroundDrawable(null);
        }
        label691:
        if (AppSetting.jdField_d_of_type_Boolean)
        {
          paramagrq = PhotoUtils.a(0, paramViewGroup, paramInt, paramagrt.jdField_a_of_type_ComTencentMobileqqWidgetNumberCheckBox.isChecked());
          paramagrt.jdField_a_of_type_ComTencentMobileqqWidgetNumberCheckBox.setContentDescription(paramagrq);
        }
        paramViewGroup.visableTime = SystemClock.uptimeMillis();
        paramViewGroup.listViewPosition = paramInt;
        if (!agpk.a(paramViewGroup.path, this.jdField_a_of_type_Agsa.jdField_a_of_type_JavaUtilHashMap)) {
          break label919;
        }
        if (Build.VERSION.SDK_INT < 21) {
          break label905;
        }
        paramagrt.e.setImageDrawable(((NewPhotoListActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).getDrawable(2130839096));
        label784:
        paramagrt.e.setVisibility(0);
      }
      for (;;)
      {
        if ((this.jdField_a_of_type_Agrz.jdField_a_of_type_JavaUtilArrayList.size() < this.jdField_a_of_type_Agrz.jdField_a_of_type_Int) || (i == 1) || (this.jdField_a_of_type_Agsa.jdField_c_of_type_Boolean)) {
          break label932;
        }
        paramagrt.jdField_b_of_type_AndroidWidgetImageView.setAlpha(0.3F);
        return paramView;
        label842:
        if (paramagrt.jdField_b_of_type_AndroidWidgetTextView == null) {
          break;
        }
        paramagrt.jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
        break;
        label863:
        if (i == 3)
        {
          paramagrt.jdField_a_of_type_ComTencentMobileqqWidgetNumberCheckBox.setChecked(false);
          break label691;
        }
        paramagrt.jdField_a_of_type_ComTencentMobileqqWidgetNumberCheckBox.setChecked(false);
        if (paramView.getBackground() == null) {
          break label691;
        }
        paramView.setBackgroundDrawable(null);
        break label691;
        label905:
        paramagrt.e.setImageResource(2130839096);
        break label784;
        label919:
        paramagrt.e.setVisibility(8);
      }
      label932:
      paramagrt.jdField_b_of_type_AndroidWidgetImageView.setAlpha(1.0F);
      return paramView;
    }
  }
  
  String a(LocalMediaInfo paramLocalMediaInfo)
  {
    int i = this.jdField_a_of_type_Agrz.jdField_a_of_type_Int;
    return ((NewPhotoListActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).getResources().getString(2131695100, new Object[] { Integer.valueOf(i) });
  }
  
  protected List<LocalMediaInfo> a()
  {
    int i = -1;
    if (this.jdField_a_of_type_Agrz.jdField_c_of_type_JavaLangString.equals("$RecentAlbumId")) {
      i = 100;
    }
    List localList = bbbx.b((Context)this.jdField_a_of_type_MqqUtilWeakReference.get(), this.jdField_a_of_type_Agrz.jdField_c_of_type_JavaLangString, this.jdField_a_of_type_Agrz.jdField_b_of_type_JavaLangString, i, this.jdField_a_of_type_Agsa.jdField_a_of_type_Aglv, this.jdField_a_of_type_Agsa.jdField_a_of_type_Long);
    bbfb.a("PEAK", "getAlbumMedias");
    if (localList == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("SelectPhotoTrace", 2, "photoList is null");
      }
      return null;
    }
    if ((this.jdField_a_of_type_Agrz.jdField_a_of_type_JavaUtilArrayList != null) && (this.jdField_a_of_type_Agrz.jdField_a_of_type_JavaUtilArrayList.size() != 0))
    {
      i = 0;
      if (i < this.jdField_a_of_type_Agrz.jdField_a_of_type_JavaUtilArrayList.size())
      {
        String str = (String)this.jdField_a_of_type_Agrz.jdField_a_of_type_JavaUtilArrayList.get(i);
        int j;
        if (TextUtils.isEmpty(str))
        {
          QZLog.e("PhotoListActivity:QueryPhotoTask", "doInBackground: filter photo error, tempPath null");
          j = i;
        }
        for (;;)
        {
          i = j + 1;
          break;
          j = i;
          if (!new File(str).exists()) {
            if ((str.startsWith("http")) && (this.jdField_a_of_type_Agrz.jdField_c_of_type_JavaUtilHashMap != null))
            {
              j = i;
              if (this.jdField_a_of_type_Agrz.jdField_c_of_type_JavaUtilHashMap.containsKey(str)) {}
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
                  if (this.jdField_a_of_type_Agrz.jdField_a_of_type_JavaUtilHashMap.containsKey(str))
                  {
                    this.jdField_a_of_type_Agrz.jdField_a_of_type_JavaUtilHashMap.remove(str);
                    j = i;
                  }
                }
              }
            }
          }
        }
      }
    }
    return localList;
  }
  
  protected void a(int paramInt1, int paramInt2, Intent paramIntent)
  {
    this.jdField_a_of_type_Agsa.jdField_g_of_type_Int = paramInt1;
    if (paramInt2 == -1) {}
    switch (paramInt1)
    {
    default: 
      return;
    }
    a(true, ((NewPhotoListActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).getIntent());
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
        localObject = ((NewPhotoListActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).jdField_a_of_type_Agrs;
      } while ((localObject == null) || (((agrs)localObject).jdField_a_of_type_JavaUtilArrayList == null));
      localObject = (LocalMediaInfo)((agrs)localObject).jdField_a_of_type_JavaUtilArrayList.get(paramInt);
    } while ((localObject == null) || (paramLocalMediaInfo == null) || (((LocalMediaInfo)localObject).path == null) || (paramLocalMediaInfo.path == null) || (!((LocalMediaInfo)localObject).path.equals(paramLocalMediaInfo.path)));
    Object localObject = localHandler.obtainMessage();
    ((Message)localObject).what = 0;
    Bundle localBundle = new Bundle();
    localBundle.putInt("ALBUMLIST_POSITION", paramInt);
    localBundle.putLong("ALBUMLIST_ITEM_DURATION", paramLocalMediaInfo.mDuration);
    ((Message)localObject).setData(localBundle);
    localHandler.sendMessage((Message)localObject);
  }
  
  void a(Intent paramIntent)
  {
    this.jdField_a_of_type_Agsa.jdField_d_of_type_Boolean = paramIntent.getBooleanExtra("PhotoConst.IS_RECODE_LAST_ALBUMPATH", true);
    if (paramIntent.getBooleanExtra("album_enter_directly", false))
    {
      long l1 = System.currentTimeMillis();
      long l2 = bbbx.jdField_a_of_type_Long;
      if ((this.jdField_a_of_type_Agsa.jdField_d_of_type_Boolean) && (l1 - l2 < 60000L)) {
        this.jdField_a_of_type_Agrz.jdField_b_of_type_JavaLangString = bbbx.jdField_c_of_type_JavaLangString;
      }
    }
    for (this.jdField_a_of_type_Agrz.jdField_c_of_type_JavaLangString = bbbx.jdField_b_of_type_JavaLangString;; this.jdField_a_of_type_Agrz.jdField_c_of_type_JavaLangString = paramIntent.getStringExtra("ALBUM_ID"))
    {
      if (this.jdField_a_of_type_Agrz.jdField_c_of_type_JavaLangString == null)
      {
        this.jdField_a_of_type_Agrz.jdField_c_of_type_JavaLangString = "$RecentAlbumId";
        this.jdField_a_of_type_Agrz.jdField_b_of_type_JavaLangString = null;
      }
      this.jdField_a_of_type_Agsa.h = paramIntent.getBooleanExtra("PhotoConst.IS_SUPPORT_VIDEO_CHECKBOX", false);
      this.jdField_a_of_type_Agsa.j = paramIntent.getBooleanExtra("PeakConstants.showGifTypeIcon", false);
      Object localObject = paramIntent.getStringArrayListExtra("PhotoConst.PHOTO_PATHS");
      if ((localObject != null) && (!((ArrayList)localObject).isEmpty())) {
        this.jdField_a_of_type_Agrz.jdField_a_of_type_JavaUtilArrayList = ((ArrayList)localObject);
      }
      if (this.jdField_a_of_type_Agrz.jdField_a_of_type_JavaUtilArrayList == null) {
        this.jdField_a_of_type_Agrz.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
      }
      if (this.jdField_a_of_type_Agrz.jdField_a_of_type_JavaUtilHashMap == null) {
        this.jdField_a_of_type_Agrz.jdField_a_of_type_JavaUtilHashMap = new HashMap();
      }
      localObject = (HashMap)paramIntent.getSerializableExtra("PeakConstants.selectedMediaInfoHashMap");
      if ((localObject != null) && (!((HashMap)localObject).isEmpty()) && (this.jdField_a_of_type_Agrz.jdField_a_of_type_JavaUtilArrayList.size() == ((HashMap)localObject).size()))
      {
        this.jdField_a_of_type_Agrz.jdField_a_of_type_JavaUtilHashMap.clear();
        this.jdField_a_of_type_Agrz.jdField_a_of_type_JavaUtilHashMap.putAll((Map)localObject);
      }
      this.jdField_a_of_type_Agrz.jdField_b_of_type_JavaUtilArrayList = new ArrayList();
      this.jdField_a_of_type_Agrz.jdField_a_of_type_Int = paramIntent.getIntExtra("PhotoConst.MAXUM_SELECTED_NUM", 1);
      this.jdField_a_of_type_Agsa.jdField_c_of_type_Int = paramIntent.getIntExtra("PhotoConst.MAXUM_SELECTED_NUM_VIDEO", 1);
      this.jdField_a_of_type_Agsa.jdField_c_of_type_Boolean = paramIntent.getBooleanExtra("PhotoConst.IS_SINGLE_MODE", true);
      if (this.jdField_a_of_type_Agrz.jdField_a_of_type_Int > 1) {
        this.jdField_a_of_type_Agsa.jdField_c_of_type_Boolean = false;
      }
      this.jdField_a_of_type_Agsa.jdField_b_of_type_Int = paramIntent.getIntExtra("PhotoConst.PHOTOLIST_KEY_SHOW_MEDIA", 1);
      this.jdField_a_of_type_Agsa.jdField_a_of_type_Aglv = aglv.a(this.jdField_a_of_type_Agsa.jdField_b_of_type_Int);
      this.jdField_a_of_type_Agsa.jdField_a_of_type_Boolean = paramIntent.getBooleanExtra("PhotoConst.PHOTOLIST_KEY_FILTER_GIF_VIDEO", false);
      if (this.jdField_a_of_type_Agsa.jdField_a_of_type_Boolean)
      {
        this.jdField_a_of_type_Agsa.jdField_a_of_type_Aglv = new aglo(aglv.d);
        this.jdField_a_of_type_Agsa.jdField_b_of_type_Int = 1;
      }
      this.jdField_a_of_type_Agsa.jdField_a_of_type_JavaLangString = paramIntent.getStringExtra("PhotoConst.CUSTOM_SENDBTN_TEXT");
      this.jdField_a_of_type_Agsa.jdField_f_of_type_Boolean = paramIntent.getBooleanExtra("PhotoConst.IS_SHOW_CAMERA", false);
      if (this.jdField_a_of_type_Agsa.jdField_f_of_type_Boolean) {
        this.jdField_a_of_type_Agsa.jdField_g_of_type_Boolean = paramIntent.getBooleanExtra("PhotoConst.SHOW_CAMERA_IN_VIDEO", false);
      }
      this.jdField_a_of_type_Agsa.jdField_f_of_type_Int = paramIntent.getIntExtra("PHOTOLIST_START_POSITION", -1);
      paramIntent.removeExtra("PHOTOLIST_START_POSITION");
      if (!this.jdField_a_of_type_Agrz.jdField_d_of_type_Boolean) {
        this.jdField_a_of_type_Agrz.jdField_d_of_type_Boolean = paramIntent.getBooleanExtra("PhotoConst.PHOTOLIST_IS_NEED_MEDIA_INFO", false);
      }
      this.jdField_a_of_type_Agsa.jdField_a_of_type_Long = paramIntent.getLongExtra("PhotoConst.PHOTOLIST_KEY_FILTER_VIDEO_DURATION_LIMIT", 9223372036854775807L);
      return;
      this.jdField_a_of_type_Agrz.jdField_b_of_type_JavaLangString = paramIntent.getStringExtra("ALBUM_NAME");
    }
  }
  
  protected void a(Message paramMessage)
  {
    ((NewPhotoListActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).d();
    ArrayList localArrayList = this.jdField_a_of_type_Agrz.jdField_a_of_type_JavaUtilArrayList;
    String str;
    if ((paramMessage.obj instanceof String))
    {
      str = (String)paramMessage.obj;
      QZLog.d("PhotoListActivity", 2, new Object[] { "onEncodeSuccess = ", str });
      paramMessage = localArrayList;
      if (localArrayList == null) {
        paramMessage = new ArrayList();
      }
      if (paramMessage.size() < agrz.a().jdField_a_of_type_Int) {
        break label158;
      }
      bcql.a((Context)this.jdField_a_of_type_MqqUtilWeakReference.get(), String.format(((NewPhotoListActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).getResources().getString(2131695100), new Object[] { Integer.valueOf(agrz.a().jdField_a_of_type_Int) }), 0).a();
    }
    for (;;)
    {
      ((NewPhotoListActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).a(str);
      return;
      label158:
      agrz.a().jdField_a_of_type_JavaUtilArrayList.add(str);
      ((NewPhotoListActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).f();
    }
  }
  
  protected void a(View paramView)
  {
    bbbx.c();
    bbbx.a();
    ((NewPhotoListActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).finish();
    bbbx.a((Activity)this.jdField_a_of_type_MqqUtilWeakReference.get(), false, false);
  }
  
  public void a(View paramView, int paramInt, CheckBox paramCheckBox)
  {
    boolean bool2 = true;
    paramView = this.jdField_a_of_type_Agrz.jdField_a_of_type_JavaUtilArrayList;
    if (this.jdField_a_of_type_Agsa.jdField_c_of_type_Boolean) {}
    LocalMediaInfo localLocalMediaInfo;
    int i;
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
    } while (l - this.jdField_a_of_type_Agsa.jdField_b_of_type_Long < 1000L);
    bcql.a((Context)this.jdField_a_of_type_MqqUtilWeakReference.get(), a(localLocalMediaInfo), 0).b(((NewPhotoListActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).jdField_g_of_type_Int);
    paramCheckBox.setChecked(false);
    this.jdField_a_of_type_Agsa.jdField_b_of_type_Long = l;
    return;
    boolean bool1;
    label206:
    Object localObject;
    if (i == 1)
    {
      i = 2;
      localLocalMediaInfo.selectStatus = i;
      if (localLocalMediaInfo.selectStatus != 1) {
        break label594;
      }
      bool1 = true;
      paramCheckBox = localLocalMediaInfo.path;
      if (!bool1) {
        break label600;
      }
      localObject = agmm.a(localLocalMediaInfo.mMimeType);
      if ((this.jdField_a_of_type_Agsa.h) && (localObject != null) && ("video".equals(localObject[0])))
      {
        localObject = this.jdField_a_of_type_Agsa;
        ((agsa)localObject).jdField_d_of_type_Int += 1;
        if (this.jdField_a_of_type_Agsa.jdField_d_of_type_Int == 1) {
          this.jdField_a_of_type_Agsa.jdField_a_of_type_ComTencentMobileqqActivityPhotoLocalMediaInfo = localLocalMediaInfo;
        }
      }
      if ((!TextUtils.isEmpty(localLocalMediaInfo.mMimeType)) && ("image/gif".equals(localLocalMediaInfo.mMimeType)))
      {
        localObject = this.jdField_a_of_type_Agsa;
        ((agsa)localObject).jdField_e_of_type_Int += 1;
      }
      paramView.add(paramCheckBox);
      this.jdField_a_of_type_Agrz.jdField_b_of_type_JavaUtilArrayList.add(localLocalMediaInfo.position);
      if (this.jdField_a_of_type_Agrz.jdField_d_of_type_Boolean) {
        this.jdField_a_of_type_Agrz.jdField_a_of_type_JavaUtilHashMap.put(paramCheckBox, localLocalMediaInfo);
      }
      paramView = ((NewPhotoListActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).getIntent();
      if (!paramView.hasExtra("param_initTime")) {
        paramView.putExtra("param_initTime", System.currentTimeMillis());
      }
      paramView = (LinkedHashMap)bbbx.jdField_b_of_type_JavaUtilHashMap.get(this.jdField_a_of_type_Agrz.jdField_c_of_type_JavaLangString);
      if (paramView != null) {
        break label817;
      }
      paramView = new LinkedHashMap();
      bbbx.jdField_b_of_type_JavaUtilHashMap.put(this.jdField_a_of_type_Agrz.jdField_c_of_type_JavaLangString, paramView);
    }
    label525:
    label817:
    for (;;)
    {
      paramView.put(paramCheckBox, Integer.valueOf(((NewPhotoListActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).jdField_a_of_type_ComTencentWidgetGestureSelectGridView.getFirstVisiblePosition()));
      paramView = bbbx.jdField_c_of_type_JavaUtilHashMap;
      if (!paramView.containsKey(paramCheckBox)) {
        paramView.put(paramCheckBox, new Pair(this.jdField_a_of_type_Agrz.jdField_c_of_type_JavaLangString, this.jdField_a_of_type_Agrz.jdField_b_of_type_JavaLangString));
      }
      if (this.jdField_a_of_type_Agsg != null) {
        this.jdField_a_of_type_Agsg.a(bool1, localLocalMediaInfo);
      }
      ((NewPhotoListActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).a(paramInt, bool1);
      paramView = (NewPhotoListActivity)this.jdField_a_of_type_MqqUtilWeakReference.get();
      if (!bool1) {}
      for (bool1 = bool2;; bool1 = false)
      {
        paramView.b(bool1);
        return;
        i = 1;
        break;
        label594:
        bool1 = false;
        break label206;
        label600:
        localObject = agmm.a(localLocalMediaInfo.mMimeType);
        if ((this.jdField_a_of_type_Agsa.h) && (localObject != null) && ("video".equals(localObject[0])))
        {
          localObject = this.jdField_a_of_type_Agsa;
          ((agsa)localObject).jdField_d_of_type_Int -= 1;
          if (this.jdField_a_of_type_Agsa.jdField_d_of_type_Int == 1) {
            this.jdField_a_of_type_Agsa.jdField_a_of_type_ComTencentMobileqqActivityPhotoLocalMediaInfo = localLocalMediaInfo;
          }
        }
        if ((!TextUtils.isEmpty(localLocalMediaInfo.mMimeType)) && ("image/gif".equals(localLocalMediaInfo.mMimeType)))
        {
          localObject = this.jdField_a_of_type_Agsa;
          ((agsa)localObject).jdField_e_of_type_Int -= 1;
        }
        paramView.remove(paramCheckBox);
        this.jdField_a_of_type_Agrz.jdField_b_of_type_JavaUtilArrayList.remove(localLocalMediaInfo.position);
        if (this.jdField_a_of_type_Agrz.jdField_d_of_type_Boolean) {
          this.jdField_a_of_type_Agrz.jdField_a_of_type_JavaUtilHashMap.remove(paramCheckBox);
        }
        paramView = (HashMap)bbbx.jdField_b_of_type_JavaUtilHashMap.get(this.jdField_a_of_type_Agrz.jdField_c_of_type_JavaLangString);
        if (paramView != null) {
          paramView.remove(paramCheckBox);
        }
        paramView = bbbx.jdField_c_of_type_JavaUtilHashMap;
        if (!paramView.containsKey(paramCheckBox)) {
          break label525;
        }
        paramView.remove(paramCheckBox);
        break label525;
      }
    }
  }
  
  void a(View paramView, Bundle paramBundle, int paramInt, Intent paramIntent) {}
  
  protected void a(CompoundButton paramCompoundButton, boolean paramBoolean) {}
  
  public void a(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong) {}
  
  protected void a(boolean paramBoolean, int paramInt1, int paramInt2) {}
  
  void a(boolean paramBoolean, Intent paramIntent)
  {
    bbbx.a();
    paramIntent.putExtra("PhotoConst.SHOW_ALBUM", false);
    ArrayList localArrayList = this.jdField_a_of_type_Agrz.jdField_a_of_type_JavaUtilArrayList;
    if (!paramBoolean) {
      paramIntent.putStringArrayListExtra("PhotoConst.PHOTO_PATHS", localArrayList);
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
      agsb.jdField_a_of_type_Int = ((NewPhotoListActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).jdField_a_of_type_ComTencentWidgetGestureSelectGridView.getFirstVisiblePosition();
      paramIntent.setClass((Context)this.jdField_a_of_type_MqqUtilWeakReference.get(), NewPhotoPreviewActivity.class);
      paramIntent.addFlags(603979776);
      c(paramIntent);
      bbbx.a((Activity)this.jdField_a_of_type_MqqUtilWeakReference.get(), true, true);
      return;
      paramIntent.putExtra("PhotoConst.SINGLE_PHOTO_PATH", this.jdField_a_of_type_Agsa.jdField_b_of_type_JavaLangString);
    }
  }
  
  protected boolean a()
  {
    return true;
  }
  
  boolean a(LocalMediaInfo paramLocalMediaInfo, boolean paramBoolean)
  {
    Object localObject1 = this.jdField_a_of_type_Agrz;
    Object localObject2 = agmm.a(paramLocalMediaInfo.mMimeType);
    if ((!this.jdField_a_of_type_Agsa.h) && (localObject2 != null) && (!"image".equals(localObject2[0]))) {}
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
    } while (l - this.jdField_a_of_type_Agsa.jdField_b_of_type_Long < 700L);
    bcql.a((Context)this.jdField_a_of_type_MqqUtilWeakReference.get(), a(paramLocalMediaInfo), 1000).b(((NewPhotoListActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).jdField_g_of_type_Int);
    this.jdField_a_of_type_Agsa.jdField_b_of_type_Long = l;
    this.jdField_a_of_type_Agsa.k = true;
    return false;
    this.jdField_a_of_type_Agsa.k = false;
    String str = paramLocalMediaInfo.path;
    if (paramBoolean)
    {
      if ((this.jdField_a_of_type_Agsa.h) && (localObject2 != null) && ("video".equals(localObject2[0])))
      {
        localObject2 = this.jdField_a_of_type_Agsa;
        ((agsa)localObject2).jdField_d_of_type_Int += 1;
        if (this.jdField_a_of_type_Agsa.jdField_d_of_type_Int == 1) {
          this.jdField_a_of_type_Agsa.jdField_a_of_type_ComTencentMobileqqActivityPhotoLocalMediaInfo = paramLocalMediaInfo;
        }
      }
      if ((!TextUtils.isEmpty(paramLocalMediaInfo.mMimeType)) && ("image/gif".equals(paramLocalMediaInfo.mMimeType)))
      {
        localObject2 = this.jdField_a_of_type_Agsa;
        ((agsa)localObject2).jdField_e_of_type_Int += 1;
      }
      ((agrz)localObject1).jdField_a_of_type_JavaUtilArrayList.add(str);
      ((agrz)localObject1).jdField_b_of_type_JavaUtilArrayList.add(paramLocalMediaInfo.position);
      if (((agrz)localObject1).jdField_d_of_type_Boolean) {
        ((agrz)localObject1).jdField_a_of_type_JavaUtilHashMap.put(str, paramLocalMediaInfo);
      }
      if (this.jdField_a_of_type_Agsa.jdField_b_of_type_JavaUtilHashSet.contains(str)) {
        this.jdField_a_of_type_Agsa.jdField_b_of_type_JavaUtilHashSet.remove(str);
      }
      this.jdField_a_of_type_Agsa.jdField_a_of_type_JavaUtilHashSet.add(str);
      localObject1 = ((NewPhotoListActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).getIntent();
      if (!((Intent)localObject1).hasExtra("param_initTime")) {
        ((Intent)localObject1).putExtra("param_initTime", System.currentTimeMillis());
      }
      paramLocalMediaInfo.selectStatus = 1;
      paramLocalMediaInfo = (LinkedHashMap)bbbx.jdField_b_of_type_JavaUtilHashMap.get(this.jdField_a_of_type_Agrz.jdField_c_of_type_JavaLangString);
      if (paramLocalMediaInfo != null) {
        break label821;
      }
      paramLocalMediaInfo = new LinkedHashMap();
      bbbx.jdField_b_of_type_JavaUtilHashMap.put(this.jdField_a_of_type_Agrz.jdField_c_of_type_JavaLangString, paramLocalMediaInfo);
    }
    label821:
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
        if ((this.jdField_a_of_type_Agsa.h) && (localObject2 != null) && ("video".equals(localObject2[0])))
        {
          localObject2 = this.jdField_a_of_type_Agsa;
          ((agsa)localObject2).jdField_d_of_type_Int -= 1;
          if (this.jdField_a_of_type_Agsa.jdField_d_of_type_Int == 1) {
            this.jdField_a_of_type_Agsa.jdField_a_of_type_ComTencentMobileqqActivityPhotoLocalMediaInfo = paramLocalMediaInfo;
          }
        }
        if ((!TextUtils.isEmpty(paramLocalMediaInfo.mMimeType)) && ("image/gif".equals(paramLocalMediaInfo.mMimeType)))
        {
          localObject2 = this.jdField_a_of_type_Agsa;
          ((agsa)localObject2).jdField_e_of_type_Int -= 1;
        }
        ((agrz)localObject1).jdField_a_of_type_JavaUtilArrayList.remove(paramLocalMediaInfo.path);
        ((agrz)localObject1).jdField_b_of_type_JavaUtilArrayList.remove(paramLocalMediaInfo.position);
        if (((agrz)localObject1).jdField_d_of_type_Boolean) {
          ((agrz)localObject1).jdField_a_of_type_JavaUtilHashMap.remove(str);
        }
        if (this.jdField_a_of_type_Agsa.jdField_a_of_type_JavaUtilHashSet.contains(paramLocalMediaInfo.path)) {
          this.jdField_a_of_type_Agsa.jdField_a_of_type_JavaUtilHashSet.remove(paramLocalMediaInfo.path);
        }
        for (;;)
        {
          paramLocalMediaInfo.selectStatus = 2;
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
          this.jdField_a_of_type_Agsa.jdField_b_of_type_JavaUtilHashSet.add(paramLocalMediaInfo.path);
        }
      }
    }
  }
  
  boolean a(List<LocalMediaInfo> paramList)
  {
    ((NewPhotoListActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).runOnUiThread(new PhotoListLogicBase.3(this));
    Object localObject;
    if (paramList == null)
    {
      if ((!this.jdField_a_of_type_Agsa.jdField_f_of_type_Boolean) || (!this.jdField_a_of_type_Agrz.jdField_c_of_type_JavaLangString.equals("$RecentAlbumId")))
      {
        localObject = paramList;
        if (this.jdField_a_of_type_Agsa.jdField_g_of_type_Boolean)
        {
          localObject = paramList;
          if (!this.jdField_a_of_type_Agrz.jdField_c_of_type_JavaLangString.equals("$VideoAlbumId")) {}
        }
      }
      else
      {
        paramList = new LocalMediaInfo();
        paramList.mMimeType = "mobileqq/camera";
        localObject = new ArrayList();
        ((List)localObject).add(0, paramList);
      }
      ((NewPhotoListActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).jdField_a_of_type_Agrs.a((List)localObject);
      ((NewPhotoListActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).jdField_a_of_type_Agrs.notifyDataSetChanged();
      d();
      bcql.a((Context)this.jdField_a_of_type_MqqUtilWeakReference.get(), "暂无媒体文件", 1000).a();
      return false;
    }
    if (((this.jdField_a_of_type_Agsa.jdField_f_of_type_Boolean) && (this.jdField_a_of_type_Agrz.jdField_c_of_type_JavaLangString.equals("$RecentAlbumId"))) || ((this.jdField_a_of_type_Agsa.jdField_g_of_type_Boolean) && (this.jdField_a_of_type_Agrz.jdField_c_of_type_JavaLangString.equals("$VideoAlbumId"))))
    {
      localObject = new LocalMediaInfo();
      ((LocalMediaInfo)localObject).mMimeType = "mobileqq/camera";
      paramList.add(0, localObject);
    }
    ((NewPhotoListActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).jdField_a_of_type_Agrs.a(paramList);
    if (paramList.isEmpty()) {
      bcql.a((Context)this.jdField_a_of_type_MqqUtilWeakReference.get(), "暂无媒体文件", 1000).a();
    }
    ((NewPhotoListActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).jdField_a_of_type_Agrs.notifyDataSetChanged();
    ((NewPhotoListActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).jdField_a_of_type_Agsc.d();
    return true;
  }
  
  public View b(int paramInt, View paramView, ViewGroup paramViewGroup, agrt paramagrt, agrq paramagrq)
  {
    paramViewGroup = paramView;
    if (paramView == null)
    {
      paramView = ((NewPhotoListActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).jdField_a_of_type_Agrs.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2131561187, null);
      paramView.setLayoutParams(new AbsListView.LayoutParams(((NewPhotoListActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).jdField_a_of_type_Int, ((NewPhotoListActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).jdField_b_of_type_Int));
      paramagrt.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131371559));
      paramagrt.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131371565));
      paramagrt.c = ((ImageView)paramView.findViewById(2131368351));
      paramagrt.d = ((ImageView)paramView.findViewById(2131371564));
      paramagrt.jdField_a_of_type_AndroidViewView = paramView.findViewById(2131371561);
      paramagrt.jdField_a_of_type_ComTencentMobileqqWidgetNumberCheckBox = ((NumberCheckBox)paramView.findViewById(2131371562));
      if (this.jdField_a_of_type_Agrz.jdField_a_of_type_Int > 100) {
        paramagrt.jdField_a_of_type_ComTencentMobileqqWidgetNumberCheckBox.setTextSize(10.0F);
      }
      paramagrt.jdField_a_of_type_Agrq = paramagrq;
      if (paramagrt.jdField_a_of_type_AndroidViewView != null) {
        paramagrt.jdField_a_of_type_AndroidViewView.setOnClickListener(paramagrt.jdField_a_of_type_Agrq);
      }
      paramView.setTag(paramagrt);
      paramViewGroup = paramView;
      if (!this.jdField_a_of_type_Agsa.jdField_c_of_type_Boolean)
      {
        paramViewGroup = paramView;
        if (this.jdField_a_of_type_Agsa.h)
        {
          paramagrt.jdField_a_of_type_AndroidViewView.setVisibility(0);
          paramViewGroup = paramView;
        }
      }
    }
    paramagrt.jdField_a_of_type_Agrq.a(paramInt);
    paramagrt.jdField_a_of_type_Agrq.a(paramagrt.jdField_a_of_type_ComTencentMobileqqWidgetNumberCheckBox);
    ImageView localImageView = paramagrt.jdField_b_of_type_AndroidWidgetImageView;
    localImageView.setAdjustViewBounds(false);
    paramagrq = ((NewPhotoListActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).jdField_a_of_type_Agrs.a(paramInt);
    paramViewGroup.setContentDescription(PhotoUtils.a(1, paramagrq, paramInt));
    int i;
    if (paramagrq.isSystemMeidaStore)
    {
      paramView = bbbx.a(paramagrq, "VIDEO");
      i = ayop.jdField_a_of_type_Int;
      paramagrq.thumbHeight = i;
      paramagrq.thumbWidth = i;
      URLDrawable localURLDrawable = paramagrt.jdField_a_of_type_ComTencentImageURLDrawable;
      if ((localURLDrawable == null) || (!localURLDrawable.getURL().equals(paramView)))
      {
        if (QLog.isColorLevel()) {
          QLog.d("PhotoListActivity", 2, "PhotoListAdapter,getView(),vedio url :" + paramView.toString());
        }
        paramView = aywm.a(paramView, ((NewPhotoListActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).jdField_a_of_type_Agrs.jdField_a_of_type_AndroidGraphicsDrawableColorDrawable, ((NewPhotoListActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).jdField_a_of_type_Agrs.jdField_a_of_type_AndroidGraphicsDrawableDrawable);
        paramView.setTag(paramagrq);
        localImageView.setImageDrawable(paramView);
        ((URLImageView)localImageView).setURLDrawableDownListener(((NewPhotoListActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).jdField_a_of_type_Agrs);
        paramagrt.jdField_a_of_type_ComTencentImageURLDrawable = paramView;
        if (localURLDrawable != null) {
          localURLDrawable.cancelDownload();
        }
      }
      paramView = paramagrt.jdField_a_of_type_AndroidWidgetTextView;
      if ((paramagrq.isSystemMeidaStore) || (paramagrq.mDuration > 0L)) {
        break label661;
      }
      paramView.setVisibility(8);
      paramView = agmg.a(BaseApplicationImpl.getContext());
      if (paramView != null) {
        paramView.a(this, paramagrq, paramInt);
      }
      label536:
      i = paramagrq.selectStatus;
      if (i != 1) {
        break label681;
      }
      paramagrt.jdField_a_of_type_ComTencentMobileqqWidgetNumberCheckBox.setCheckedNumber(this.jdField_a_of_type_Agrz.jdField_a_of_type_JavaUtilArrayList.indexOf(paramagrq.path) + 1);
      if (paramViewGroup.getBackground() != null) {
        paramViewGroup.setBackgroundDrawable(null);
      }
    }
    for (;;)
    {
      paramagrq.visableTime = SystemClock.uptimeMillis();
      paramagrq.listViewPosition = paramInt;
      if ((this.jdField_a_of_type_Agrz.jdField_a_of_type_JavaUtilArrayList.size() < this.jdField_a_of_type_Agrz.jdField_a_of_type_Int) || (i == 1) || (this.jdField_a_of_type_Agsa.jdField_c_of_type_Boolean)) {
        break label723;
      }
      paramagrt.jdField_b_of_type_AndroidWidgetImageView.setAlpha(0.3F);
      return paramViewGroup;
      paramView = bbbx.a(paramagrq, "APP_VIDEO");
      break;
      label661:
      paramView.setVisibility(0);
      paramView.setText(NewPhotoListActivity.a(paramagrq.mDuration));
      break label536;
      label681:
      if (i == 3)
      {
        paramagrt.jdField_a_of_type_ComTencentMobileqqWidgetNumberCheckBox.setChecked(false);
      }
      else
      {
        paramagrt.jdField_a_of_type_ComTencentMobileqqWidgetNumberCheckBox.setChecked(false);
        if (paramViewGroup.getBackground() != null) {
          paramViewGroup.setBackgroundDrawable(null);
        }
      }
    }
    label723:
    paramagrt.jdField_b_of_type_AndroidWidgetImageView.setAlpha(1.0F);
    return paramViewGroup;
  }
  
  void b(Intent paramIntent)
  {
    Object localObject = this.jdField_a_of_type_Agrz.jdField_a_of_type_JavaUtilArrayList;
    HashMap localHashMap1 = this.jdField_a_of_type_Agrz.jdField_a_of_type_JavaUtilHashMap;
    paramIntent.putStringArrayListExtra("PhotoConst.PHOTO_PATHS", (ArrayList)localObject);
    if (this.jdField_a_of_type_Agrz.jdField_d_of_type_Boolean)
    {
      HashMap localHashMap2 = new HashMap(localHashMap1);
      Iterator localIterator = ((ArrayList)localObject).iterator();
      while (localIterator.hasNext())
      {
        String str = (String)localIterator.next();
        localObject = null;
        if (this.jdField_a_of_type_Agrz.jdField_b_of_type_JavaUtilHashMap != null) {
          localObject = (LocalMediaInfo)this.jdField_a_of_type_Agrz.jdField_b_of_type_JavaUtilHashMap.get(str);
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
  }
  
  protected void b(View paramView)
  {
    a(false, ((NewPhotoListActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).getIntent());
  }
  
  public void b(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    if (!bbbr.a()) {
      bcql.a((Context)this.jdField_a_of_type_MqqUtilWeakReference.get(), ((NewPhotoListActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).getResources().getString(2131719055), 0).a();
    }
    do
    {
      do
      {
        return;
        paramAdapterView = ((NewPhotoListActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).jdField_a_of_type_Agrs.a(paramInt);
      } while (paramAdapterView == null);
      ((NewPhotoListActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).getIntent();
      paramView = bbbx.jdField_c_of_type_JavaUtilHashMap;
      if (!paramView.containsKey(paramAdapterView.path))
      {
        localObject = new Pair(this.jdField_a_of_type_Agrz.jdField_c_of_type_JavaLangString, this.jdField_a_of_type_Agrz.jdField_b_of_type_JavaLangString);
        paramView.put(paramAdapterView.path, localObject);
      }
      ((NewPhotoListActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).b(paramAdapterView.path);
    } while (this.jdField_a_of_type_Agsa.jdField_c_of_type_Boolean);
    paramAdapterView = ((NewPhotoListActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).getIntent();
    paramAdapterView.putExtra("ALBUM_NAME", this.jdField_a_of_type_Agrz.jdField_b_of_type_JavaLangString);
    paramAdapterView.putExtra("ALBUM_ID", this.jdField_a_of_type_Agrz.jdField_c_of_type_JavaLangString);
    paramView = ((NewPhotoListActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).jdField_a_of_type_Agrs.a(paramInt);
    paramAdapterView.putExtra("PhotoConst.CURRENT_SELECTED_INDEX", paramView.position);
    paramAdapterView.putStringArrayListExtra("PhotoConst.SELECTED_PATHS", this.jdField_a_of_type_Agrz.jdField_a_of_type_JavaUtilArrayList);
    paramAdapterView.putIntegerArrayListExtra("PhotoConst.SELECTED_INDEXS", this.jdField_a_of_type_Agrz.jdField_b_of_type_JavaUtilArrayList);
    paramAdapterView.putExtra("FROM_WHERE", "FROM_PHOTO_LIST");
    paramAdapterView.putExtra("PhotoConst.SHOW_ALBUM", true);
    agsb.jdField_a_of_type_Int = ((NewPhotoListActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).jdField_a_of_type_ComTencentWidgetGestureSelectGridView.getFirstVisiblePosition();
    Object localObject = this.jdField_a_of_type_Agrz.jdField_a_of_type_JavaUtilHashMap;
    if (!((HashMap)localObject).containsKey(paramView.path)) {
      ((HashMap)localObject).put(paramView.path, paramView);
    }
    paramAdapterView.putExtra("PeakConstants.selectedMediaInfoHashMap", (Serializable)localObject);
    paramAdapterView.setClass((Context)this.jdField_a_of_type_MqqUtilWeakReference.get(), NewPhotoPreviewActivity.class);
    paramAdapterView.addFlags(603979776);
    ((NewPhotoListActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).startActivity(paramAdapterView);
    ((NewPhotoListActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).finish();
    bbbx.a((Activity)this.jdField_a_of_type_MqqUtilWeakReference.get(), true, true);
  }
  
  void c()
  {
    View localView = ((NewPhotoListActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).jdField_a_of_type_AndroidViewView;
    if (this.jdField_a_of_type_Agsa.jdField_c_of_type_Boolean) {}
    for (int i = 8;; i = 0)
    {
      localView.setVisibility(i);
      ((NewPhotoListActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).c.setOnClickListener((View.OnClickListener)this.jdField_a_of_type_MqqUtilWeakReference.get());
      return;
    }
  }
  
  void c(Intent paramIntent)
  {
    ((NewPhotoListActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).startActivity(paramIntent);
    ((NewPhotoListActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).finish();
  }
  
  protected void c(View paramView) {}
  
  public void c(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    if (!bbbr.a())
    {
      bcql.a((Context)this.jdField_a_of_type_MqqUtilWeakReference.get(), ((NewPhotoListActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).getResources().getString(2131719055), 0).a();
      return;
    }
    ((NewPhotoListActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).h();
  }
  
  void d()
  {
    ArrayList localArrayList = this.jdField_a_of_type_Agrz.jdField_a_of_type_JavaUtilArrayList;
    String str;
    boolean bool;
    if (this.jdField_a_of_type_Agsa.jdField_a_of_type_JavaLangString != null)
    {
      str = this.jdField_a_of_type_Agsa.jdField_a_of_type_JavaLangString;
      if (localArrayList.size() <= 0) {
        break label145;
      }
      bool = true;
      label35:
      if (!bool) {
        break label150;
      }
      str = str + "(" + localArrayList.size() + ")";
    }
    label145:
    label150:
    for (;;)
    {
      ((NewPhotoListActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).c.setText(str);
      ((NewPhotoListActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).c.setEnabled(bool);
      ((NewPhotoListActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).jdField_b_of_type_AndroidWidgetButton.setEnabled(bool);
      return;
      str = ((NewPhotoListActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).getString(2131695085);
      break;
      bool = false;
      break label35;
    }
  }
  
  protected void d(Intent paramIntent)
  {
    paramIntent = paramIntent.getStringArrayListExtra("PhotoConst.PHOTO_PATHS");
    if ((paramIntent != null) && (paramIntent.size() > 0) && (!TextUtils.isEmpty((CharSequence)paramIntent.get(0)))) {
      ThreadManager.postImmediately(new PhotoListLogicBase.1(this, (String)paramIntent.get(0)), null, true);
    }
  }
  
  protected void e()
  {
    this.jdField_a_of_type_Agsa.jdField_e_of_type_Boolean = true;
    a(null);
  }
  
  protected void e(Intent paramIntent)
  {
    ((NewPhotoListActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).c();
    long l = System.currentTimeMillis();
    Object localObject = paramIntent.getStringExtra("video_new_fake_vid");
    paramIntent = paramIntent.getStringExtra("file_video_source_dir");
    swc localswc = new swc();
    localswc.a(true);
    localObject = swc.a((String)localObject);
    String str = aigr.a(((PublishVideoEntry)localObject).mLocalRawVideoDir);
    if (TextUtils.isEmpty(str))
    {
      QZLog.i("PhotoListActivity", 1, "get target path fail");
      return;
    }
    localswc.a((PublishVideoEntry)localObject, str, false, true, new agsi(this, l, str, (PublishVideoEntry)localObject, paramIntent));
  }
  
  void f()
  {
    if (this.jdField_a_of_type_Agsa.i)
    {
      ((NewPhotoListActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).runOnUiThread(new PhotoListLogicBase.4(this));
      return;
    }
    this.jdField_a_of_type_Agsa.i = true;
  }
  
  void g()
  {
    if (!this.jdField_a_of_type_Agsa.jdField_e_of_type_Boolean) {
      aglb.a((Context)this.jdField_a_of_type_MqqUtilWeakReference.get()).a();
    }
    if (((NewPhotoListActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).jdField_a_of_type_Agrs != null)
    {
      int i = ((NewPhotoListActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).jdField_a_of_type_Agrs.getCount();
      bbbx.jdField_a_of_type_JavaUtilHashMap.put(this.jdField_a_of_type_Agrz.jdField_c_of_type_JavaLangString, Integer.valueOf(i));
    }
    if (((NewPhotoListActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).jdField_a_of_type_AndroidOsAsyncTask != null) {
      ((NewPhotoListActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).jdField_a_of_type_AndroidOsAsyncTask.cancel(true);
    }
    b();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     agsh
 * JD-Core Version:    0.7.0.1
 */