import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.TextView;
import com.tencent.component.network.utils.NetworkUtils;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.activity.photo.PhotoSendParams;
import com.tencent.mobileqq.activity.photo.PhotoUtils;
import com.tencent.mobileqq.activity.photo.album.NewPhotoPreviewActivity;
import com.tencent.mobileqq.pic.PresendPicMgr;
import com.tencent.mobileqq.widget.NumberCheckBox;
import com.tencent.util.BinderWarpper;
import com.tencent.widget.AdapterView;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import mqq.util.WeakReference;

public class agiq
  extends aggx
{
  public boolean a;
  
  protected agiq(NewPhotoPreviewActivity paramNewPhotoPreviewActivity)
  {
    super(paramNewPhotoPreviewActivity);
  }
  
  public static aggt b(NewPhotoPreviewActivity paramNewPhotoPreviewActivity)
  {
    if ((jdField_a_of_type_Aggt == null) || (jdField_a_of_type_Aggt.jdField_a_of_type_MqqUtilWeakReference.get() != paramNewPhotoPreviewActivity)) {}
    try
    {
      if ((jdField_a_of_type_Aggt == null) || (jdField_a_of_type_Aggt.jdField_a_of_type_MqqUtilWeakReference.get() != paramNewPhotoPreviewActivity)) {
        jdField_a_of_type_Aggt = new agiq(paramNewPhotoPreviewActivity);
      }
      return jdField_a_of_type_Aggt;
    }
    finally {}
  }
  
  void a(int paramInt)
  {
    ((NewPhotoPreviewActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).jdField_a_of_type_AndroidWidgetButton.setVisibility(paramInt);
    ((NewPhotoPreviewActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).jdField_b_of_type_AndroidWidgetCheckBox.setVisibility(paramInt);
    ((NewPhotoPreviewActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).jdField_b_of_type_AndroidWidgetTextView.setVisibility(paramInt);
    if (paramInt == 0)
    {
      if (!this.jdField_a_of_type_Aggs.jdField_c_of_type_Boolean)
      {
        ((NewPhotoPreviewActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).jdField_b_of_type_AndroidWidgetCheckBox.setVisibility(8);
        ((NewPhotoPreviewActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
      }
      if (!this.jdField_a_of_type_Aggs.d) {
        ((NewPhotoPreviewActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).jdField_a_of_type_AndroidWidgetButton.setVisibility(8);
      }
      if ((this.jdField_a_of_type_Aggs.jdField_j_of_type_Boolean) && (this.jdField_a_of_type_Aggs.e.size() == 0))
      {
        ((NewPhotoPreviewActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).jdField_a_of_type_AndroidWidgetCheckBox.setVisibility(0);
        ((NewPhotoPreviewActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
        ((NewPhotoPreviewActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).jdField_a_of_type_AndroidWidgetCheckBox.setOnCheckedChangeListener((CompoundButton.OnCheckedChangeListener)this.jdField_a_of_type_MqqUtilWeakReference.get());
        ((NewPhotoPreviewActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).jdField_a_of_type_AndroidWidgetTextView.setOnClickListener(new agir(this));
        ((NewPhotoPreviewActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).jdField_a_of_type_AndroidWidgetCheckBox.setContentDescription("闪照");
        ((NewPhotoPreviewActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).jdField_a_of_type_AndroidWidgetTextView.setContentDescription("闪照");
      }
    }
    while (((NewPhotoPreviewActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).jdField_a_of_type_AndroidWidgetCheckBox.getVisibility() != 0) {
      return;
    }
    ((NewPhotoPreviewActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).jdField_a_of_type_AndroidWidgetCheckBox.setVisibility(paramInt);
    ((NewPhotoPreviewActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).jdField_a_of_type_AndroidWidgetTextView.setVisibility(paramInt);
  }
  
  protected void a(Intent paramIntent)
  {
    this.jdField_a_of_type_Aggs.d = true;
    this.jdField_a_of_type_Boolean = paramIntent.getBooleanExtra("PhotoConst.QZONE_ALBUM_FROM_AIO", false);
    super.a(paramIntent);
    if (!this.jdField_a_of_type_Aggs.o)
    {
      Object localObject = (BinderWarpper)paramIntent.getParcelableExtra("binder_presendService");
      if (localObject != null)
      {
        if (PresendPicMgr.a(null) != null) {
          PresendPicMgr.a(null).b();
        }
        localObject = PresendPicMgr.b(atpd.a(((BinderWarpper)localObject).a));
        this.jdField_a_of_type_Aggs.jdField_j_of_type_Int = 1037;
        paramIntent = (String)paramIntent.getStringArrayListExtra("PhotoConst.PHOTO_PATHS").get(0);
        if (((NewPhotoPreviewActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).a(paramIntent) != 1) {
          ((PresendPicMgr)localObject).a(paramIntent, this.jdField_a_of_type_Aggs.jdField_j_of_type_Int);
        }
      }
    }
    this.jdField_a_of_type_Aggs.jdField_c_of_type_JavaLangString = ((NewPhotoPreviewActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).getResources().getString(2131629465);
    ageh.c();
  }
  
  protected void a(View paramView)
  {
    int i = ((NewPhotoPreviewActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).a();
    if ((!this.jdField_a_of_type_Aggf.jdField_b_of_type_JavaUtilArrayList.contains(Integer.valueOf(i))) && (i != -1))
    {
      Object localObject = (String)this.jdField_a_of_type_Aggs.jdField_a_of_type_JavaUtilArrayList.get(i);
      localObject = ((NewPhotoPreviewActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).b((String)localObject);
      if ((localObject != null) && ((((LocalMediaInfo)localObject).mDuration > 1200000L) || (((LocalMediaInfo)localObject).fileSize > 1048576000L)))
      {
        bbmy.a((Context)this.jdField_a_of_type_MqqUtilWeakReference.get(), ((NewPhotoPreviewActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).getResources().getString(2131653672), 0).b(((NewPhotoPreviewActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).getResources().getDimensionPixelSize(2131167766));
        ((NewPhotoPreviewActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).jdField_a_of_type_ComTencentMobileqqWidgetNumberCheckBox.setChecked(((LocalMediaInfo)localObject).mChecked);
        return;
      }
    }
    super.a(paramView);
  }
  
  protected void a(View paramView, int paramInt1, Bundle paramBundle, int paramInt2, Intent paramIntent)
  {
    paramBundle.putBoolean("key_multi_edit_pic", true);
    paramBundle.putBoolean("key_enable_edit_title_bar", true);
    super.a(paramView, 10000, paramBundle, 2, null);
  }
  
  protected void a(TextView paramTextView)
  {
    Object localObject = this.jdField_a_of_type_Aggf.jdField_a_of_type_JavaUtilArrayList.iterator();
    while (((Iterator)localObject).hasNext())
    {
      String str = (String)((Iterator)localObject).next();
      if ((!NetworkUtils.isNetworkUrl(str)) && (((NewPhotoPreviewActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).a(str) == 1)) {
        paramTextView.setText(((NewPhotoPreviewActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).getString(2131629435));
      }
    }
    int i = baaf.a(this.jdField_a_of_type_Aggf.jdField_a_of_type_JavaUtilArrayList, this.jdField_a_of_type_Aggf.jdField_b_of_type_JavaUtilHashMap, true, this.jdField_a_of_type_Aggs.jdField_c_of_type_JavaUtilHashMap, this.jdField_a_of_type_Aggf.jdField_a_of_type_JavaUtilHashMap);
    if (i == 0)
    {
      paramTextView.setText(((NewPhotoPreviewActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).getString(2131629435));
      return;
    }
    localObject = PhotoUtils.a((Context)this.jdField_a_of_type_MqqUtilWeakReference.get(), i);
    if ((this.jdField_a_of_type_Aggf.jdField_a_of_type_JavaUtilArrayList.size() == 0) || (((String)localObject).equals("0"))) {}
    for (localObject = ((NewPhotoPreviewActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).getString(2131629435);; localObject = ((NewPhotoPreviewActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).getString(2131629435) + "(共" + (String)localObject + ")")
    {
      paramTextView.setText((CharSequence)localObject);
      return;
    }
  }
  
  protected void a(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    LocalMediaInfo localLocalMediaInfo = ((NewPhotoPreviewActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).b(((NewPhotoPreviewActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).jdField_a_of_type_Aggc.a(paramInt));
    if ((localLocalMediaInfo != null) && (((NewPhotoPreviewActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).a(localLocalMediaInfo.path) == 1)) {
      if ((this.jdField_a_of_type_Aggs.jdField_a_of_type_Int == 0) || (this.jdField_a_of_type_Aggs.jdField_a_of_type_Int == 1) || (this.jdField_a_of_type_Aggs.jdField_a_of_type_Int == 3000)) {
        b(8);
      }
    }
    for (;;)
    {
      super.a(paramAdapterView, paramView, paramInt, paramLong);
      return;
      a(8);
      continue;
      a(0);
    }
  }
  
  public boolean a()
  {
    return (this.jdField_a_of_type_Aggf.jdField_a_of_type_JavaUtilArrayList != null) && (!this.jdField_a_of_type_Aggf.jdField_a_of_type_JavaUtilArrayList.isEmpty());
  }
  
  protected void b()
  {
    super.b();
    if ((this.jdField_a_of_type_Boolean) && (this.jdField_a_of_type_Aggs.jdField_c_of_type_JavaUtilHashMap.size() != 0)) {
      ((NewPhotoPreviewActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).jdField_a_of_type_AndroidWidgetButton.setVisibility(8);
    }
  }
  
  void b(int paramInt)
  {
    ((NewPhotoPreviewActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).jdField_a_of_type_AndroidWidgetButton.setVisibility(paramInt);
    ((NewPhotoPreviewActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).jdField_b_of_type_AndroidWidgetCheckBox.setVisibility(0);
    ((NewPhotoPreviewActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
    if (((NewPhotoPreviewActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).jdField_a_of_type_AndroidWidgetCheckBox.getVisibility() == 0)
    {
      ((NewPhotoPreviewActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).jdField_a_of_type_AndroidWidgetCheckBox.setVisibility(paramInt);
      ((NewPhotoPreviewActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).jdField_a_of_type_AndroidWidgetTextView.setVisibility(paramInt);
    }
  }
  
  protected boolean c()
  {
    Object localObject = (String)this.jdField_a_of_type_Aggs.jdField_a_of_type_JavaUtilArrayList.get(((NewPhotoPreviewActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).a());
    if (((NewPhotoPreviewActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).a((String)localObject) == 1)
    {
      localObject = ((NewPhotoPreviewActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).b((String)localObject);
      if ((localObject != null) && (((LocalMediaInfo)localObject).fileSize > 104345600L))
      {
        bbmy.a((Context)this.jdField_a_of_type_MqqUtilWeakReference.get(), ((NewPhotoPreviewActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).getResources().getString(2131653694), 0).b(((NewPhotoPreviewActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).getResources().getDimensionPixelSize(2131167766));
        baaf.d();
      }
      return false;
    }
    return super.c();
  }
  
  protected void d()
  {
    if ("FROM_QZONE_PHOTO_LIST".equals(this.jdField_a_of_type_Aggs.jdField_a_of_type_JavaLangString))
    {
      Object localObject = ((NewPhotoPreviewActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).a();
      if ((localObject != null) && (((ArrayList)localObject).size() == 1))
      {
        localObject = (String)((ArrayList)localObject).get(0);
        if ((localObject != null) && (((String)localObject).startsWith("http")))
        {
          PhotoSendParams localPhotoSendParams = (PhotoSendParams)this.jdField_a_of_type_Aggs.jdField_b_of_type_JavaUtilHashMap.get(localObject);
          if (localPhotoSendParams != null) {
            this.jdField_a_of_type_Aggs.jdField_c_of_type_JavaUtilHashMap.put(localObject, localPhotoSendParams);
          }
        }
      }
      if (this.jdField_a_of_type_Aggf.jdField_a_of_type_JavaUtilArrayList.size() != 0) {
        if (((NewPhotoPreviewActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).getIntent().getParcelableExtra("PhotoConst.sendToAIOIntent") == null) {
          break label174;
        }
      }
      label174:
      for (localObject = (Intent)((NewPhotoPreviewActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).getIntent().getParcelableExtra("PhotoConst.sendToAIOIntent");; localObject = ((NewPhotoPreviewActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).getIntent())
      {
        ((NewPhotoPreviewActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).a((Intent)localObject, true);
        return;
      }
    }
    super.d();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     agiq
 * JD-Core Version:    0.7.0.1
 */