import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.util.Pair;
import android.view.View;
import com.tencent.biz.pubaccount.readinjoy.activity.ReadInJoyUploadAvatarActivity;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.activity.photo.PhotoCropActivity;
import com.tencent.mobileqq.activity.photo.PhotoCropForPortraitActivity;
import com.tencent.mobileqq.activity.photo.PhotoUtils;
import com.tencent.mobileqq.activity.photo.album.NewPhotoListActivity;
import com.tencent.mobileqq.activity.photo.album.NewPhotoPreviewActivity;
import com.tencent.mobileqq.activity.shortvideo.ShortVideoPreviewActivity;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.AdapterView;
import com.tencent.widget.GestureSelectGridView;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import mqq.util.WeakReference;

public class agia
  extends aggm
{
  private boolean a;
  private boolean b;
  
  private agia(NewPhotoListActivity paramNewPhotoListActivity)
  {
    super(paramNewPhotoListActivity);
  }
  
  public static aggh b(NewPhotoListActivity paramNewPhotoListActivity)
  {
    if ((jdField_a_of_type_Aggh == null) || (jdField_a_of_type_Aggh.jdField_a_of_type_MqqUtilWeakReference.get() != paramNewPhotoListActivity)) {}
    try
    {
      if ((jdField_a_of_type_Aggh == null) || (jdField_a_of_type_Aggh.jdField_a_of_type_MqqUtilWeakReference.get() != paramNewPhotoListActivity)) {
        jdField_a_of_type_Aggh = new agia(paramNewPhotoListActivity);
      }
      return jdField_a_of_type_Aggh;
    }
    finally {}
  }
  
  protected List<LocalMediaInfo> a()
  {
    List localList = super.a();
    if (this.jdField_a_of_type_Boolean)
    {
      int i = localList.size() - 1;
      while (i >= 0)
      {
        if (!((LocalMediaInfo)localList.get(i)).path.endsWith(".mp4")) {
          localList.remove(i);
        }
        i -= 1;
      }
    }
    return localList;
  }
  
  protected void a(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if ((!this.jdField_a_of_type_Boolean) && (!this.b))
    {
      super.a(paramInt1, paramInt2, paramIntent);
      return;
    }
    ArrayList localArrayList = this.jdField_a_of_type_Aggf.jdField_a_of_type_JavaUtilArrayList;
    if ((QLog.isDevelopLevel()) && (localArrayList != null) && (localArrayList.size() != 0)) {
      QLog.d("PhotoListActivity", 4, "[NewPhotoListActivity] [onActivityResult] selectedPhotoList = " + localArrayList.size());
    }
    if (paramInt2 == -1)
    {
      if ((this.jdField_a_of_type_Boolean) || (this.b))
      {
        ((NewPhotoListActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).setResult(-1, paramIntent);
        ((NewPhotoListActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).finish();
      }
    }
    else if (paramInt1 == 17)
    {
      if ((this.jdField_a_of_type_Boolean) && (paramIntent != null))
      {
        ((NewPhotoListActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).setResult(0, paramIntent);
        ((NewPhotoListActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).finish();
      }
      baaf.jdField_a_of_type_Long = 0L;
      return;
    }
    PhotoUtils.a((Activity)this.jdField_a_of_type_MqqUtilWeakReference.get(), paramInt1, paramInt2, paramIntent, this.jdField_a_of_type_Aggg.k, this.jdField_a_of_type_Aggf.jdField_a_of_type_JavaLangString);
  }
  
  protected void a(Intent paramIntent)
  {
    super.a(paramIntent);
    this.jdField_a_of_type_Boolean = paramIntent.getBooleanExtra("readinjoy_video", false);
    this.b = paramIntent.getBooleanExtra("from_readinjoy_slideshow", false);
    this.jdField_a_of_type_Aggf.a(this.b);
  }
  
  protected void a(View paramView)
  {
    if (this.jdField_a_of_type_Boolean)
    {
      baaf.c();
      baaf.a();
      ((NewPhotoListActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).setResult(0, ((NewPhotoListActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).getIntent());
      ((NewPhotoListActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).finish();
      baaf.a((Activity)this.jdField_a_of_type_MqqUtilWeakReference.get(), false, false);
      return;
    }
    super.a(paramView);
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
      localIntent.putExtra("PhotoConst.CURRENT_SELECTED_INDEX", paramInt);
    }
    if (this.jdField_a_of_type_Aggg.i)
    {
      paramLocalMediaInfo = baaf.c;
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
      paramLocalMediaInfo = ((NewPhotoListActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).getIntent().getStringExtra("PhotoConst.INIT_ACTIVITY_CLASS_NAME");
      if (ReadInJoyUploadAvatarActivity.class.getName().equals(paramLocalMediaInfo)) {
        break label599;
      }
      ((NewPhotoListActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).startActivity(localIntent);
      ((NewPhotoListActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).finish();
    }
    for (;;)
    {
      baaf.a((Activity)this.jdField_a_of_type_MqqUtilWeakReference.get(), true, true);
      return;
      paramInt = localIntent.getIntExtra("Business_Origin", 0);
      if ((100 == paramInt) || (102 == paramInt) || (103 == paramInt)) {
        if (100 == paramInt)
        {
          int i = azyk.b((Activity)this.jdField_a_of_type_MqqUtilWeakReference.get());
          localIntent.putExtra("PhotoConst.CLIP_WIDTH", i);
          localIntent.putExtra("PhotoConst.CLIP_HEIGHT", i);
          label459:
          localIntent.setClass((Context)this.jdField_a_of_type_MqqUtilWeakReference.get(), PhotoCropForPortraitActivity.class);
          localIntent.putExtra("PhotoConst.EDIT_MASK_SHAPE_TYPE", ageu.c(paramInt));
          localIntent.putExtra("PhotoConst.TARGET_WIDTH", 640);
          localIntent.putExtra("PhotoConst.TARGET_HEIGHT", 640);
        }
      }
      for (;;)
      {
        baaf.a(localIntent, this.jdField_a_of_type_Aggf.jdField_c_of_type_JavaLangString, str, this.jdField_a_of_type_Aggg.m);
        localIntent.putExtra("PHOTOLIST_START_POSITION", ((NewPhotoListActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).jdField_a_of_type_ComTencentWidgetGestureSelectGridView.getFirstVisiblePosition());
        break;
        localIntent.putExtra("PhotoConst.IS_WITH_PENDANT", false);
        break label459;
        localIntent.setClass((Context)this.jdField_a_of_type_MqqUtilWeakReference.get(), PhotoCropActivity.class);
      }
      label599:
      ((NewPhotoListActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).startActivityForResult(localIntent, 100014);
    }
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
    if ((paramView.fileSize > this.jdField_a_of_type_Aggg.jdField_a_of_type_Long) && (!this.jdField_a_of_type_Boolean))
    {
      paramAdapterView = babr.a((Activity)this.jdField_a_of_type_MqqUtilWeakReference.get(), "你选择的视频文件过大，无法发送。");
      paramAdapterView.setPositiveButton(2131629116, new baca());
      paramAdapterView.show();
      return;
    }
    Object localObject1 = baaf.c;
    Object localObject2;
    if (!((HashMap)localObject1).containsKey(paramView.path))
    {
      localObject2 = new Pair(this.jdField_a_of_type_Aggf.jdField_c_of_type_JavaLangString, this.jdField_a_of_type_Aggf.jdField_b_of_type_JavaLangString);
      ((HashMap)localObject1).put(paramView.path, localObject2);
    }
    ((NewPhotoListActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).b(paramView.path);
    if (!this.jdField_a_of_type_Aggg.c)
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
      if (this.jdField_a_of_type_Boolean)
      {
        ((NewPhotoListActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).e();
        agak.a(BaseApplicationImpl.getContext()).a(new agib(this, paramAdapterView, (ArrayList)localObject1), paramView);
        return;
      }
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
      paramView.putExtra("PhotoConst.SHOW_MAGIC_USE_PASTER", this.jdField_a_of_type_Aggg.h);
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
    ((Intent)localObject1).putExtra("uintype", this.jdField_a_of_type_Aggg.d);
    ((Intent)localObject1).putExtra("file_source", "album");
    ((Intent)localObject1).putExtra("is_from_system_media", paramView.isSystemMeidaStore);
    if (this.jdField_a_of_type_Aggg.s)
    {
      ((Intent)localObject1).putExtra("PhotoConst.IS_SUPPORT_VIDEO_CHECKBOX", true);
      ((Intent)localObject1).putExtra("PhotoConst.PHOTO_PATHS", this.jdField_a_of_type_Aggf.jdField_a_of_type_JavaUtilArrayList);
    }
    ((NewPhotoListActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).startActivityForResult((Intent)localObject1, 17);
  }
  
  protected void c(Intent paramIntent)
  {
    if (this.b)
    {
      ((NewPhotoListActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).startActivityForResult(paramIntent, 10013);
      return;
    }
    super.c(paramIntent);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     agia
 * JD-Core Version:    0.7.0.1
 */