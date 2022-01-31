import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Pair;
import android.view.View;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.activity.photo.PhotoUtils;
import com.tencent.mobileqq.activity.photo.album.NewPhotoListActivity;
import com.tencent.mobileqq.activity.photo.album.NewPhotoPreviewActivity;
import com.tencent.mobileqq.activity.shortvideo.ShortVideoPreviewActivity;
import com.tencent.mobileqq.troop.activity.TroopBarPublishActivity;
import com.tencent.mobileqq.troop.activity.TroopBarReplyActivity;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.AdapterView;
import com.tencent.widget.GestureSelectGridView;
import java.io.File;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import mqq.util.WeakReference;

public class agid
  extends aggm
{
  private String jdField_a_of_type_JavaLangString = "";
  private boolean jdField_a_of_type_Boolean;
  private boolean b;
  private boolean c;
  
  private agid(NewPhotoListActivity paramNewPhotoListActivity)
  {
    super(paramNewPhotoListActivity);
  }
  
  public static aggh b(NewPhotoListActivity paramNewPhotoListActivity)
  {
    if ((jdField_a_of_type_Aggh == null) || (jdField_a_of_type_Aggh.jdField_a_of_type_MqqUtilWeakReference.get() != paramNewPhotoListActivity)) {}
    try
    {
      if ((jdField_a_of_type_Aggh == null) || (jdField_a_of_type_Aggh.jdField_a_of_type_MqqUtilWeakReference.get() != paramNewPhotoListActivity)) {
        jdField_a_of_type_Aggh = new agid(paramNewPhotoListActivity);
      }
      return jdField_a_of_type_Aggh;
    }
    finally {}
  }
  
  protected void a(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if ((!this.jdField_a_of_type_Boolean) && (!this.b))
    {
      super.a(paramInt1, paramInt2, paramIntent);
      return;
    }
    Object localObject = this.jdField_a_of_type_Aggf.jdField_a_of_type_JavaUtilArrayList;
    if ((QLog.isDevelopLevel()) && (localObject != null) && (((ArrayList)localObject).size() != 0)) {
      QLog.d("PhotoListActivity", 4, "[NewPhotoListActivity] [onActivityResult] selectedPhotoList = " + ((ArrayList)localObject).size());
    }
    if (paramInt2 == -1)
    {
      if ((paramInt1 == 10012) && (this.b))
      {
        ((NewPhotoListActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).setResult(-1, paramIntent);
        ((NewPhotoListActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).finish();
      }
      if (this.jdField_a_of_type_Boolean)
      {
        ((NewPhotoListActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).setResult(-1, paramIntent);
        ((NewPhotoListActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).finish();
      }
    }
    else if ((paramInt1 == 10012) && (this.b) && (paramIntent != null))
    {
      localObject = paramIntent.getStringExtra("PhotoConst.FROM_QQSTORY_SLIDESHOW_DATA");
      if (!TextUtils.isEmpty((CharSequence)localObject)) {
        bace.a(new File((String)localObject).getParent());
      }
    }
    PhotoUtils.a((Activity)this.jdField_a_of_type_MqqUtilWeakReference.get(), paramInt1, paramInt2, paramIntent, this.jdField_a_of_type_Aggg.k, this.jdField_a_of_type_Aggf.jdField_a_of_type_JavaLangString);
  }
  
  protected void a(Intent paramIntent)
  {
    super.a(paramIntent);
    this.jdField_a_of_type_JavaLangString = paramIntent.getStringExtra("from_tribe_class_name");
    this.jdField_a_of_type_Boolean = "tribe".equals(paramIntent.getStringExtra("video_refer"));
    this.b = paramIntent.getBooleanExtra("from_tribe_slideshow", false);
    this.c = paramIntent.getBooleanExtra("PhotoConst.IS_FROM_TROOP_BAR", false);
    this.jdField_a_of_type_Aggf.a(this.b);
  }
  
  protected void a(View paramView, Bundle paramBundle, int paramInt, Intent paramIntent)
  {
    super.a(paramView, paramBundle, paramInt, paramIntent);
    if ((this.jdField_a_of_type_Aggf.jdField_a_of_type_JavaUtilArrayList.size() > 0) && (!TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)))
    {
      if (!TroopBarPublishActivity.class.getSimpleName().equals(this.jdField_a_of_type_JavaLangString)) {
        break label61;
      }
      azhe.a("pub_page_new", "clk_photo_edit", 0, 0, new String[0]);
    }
    label61:
    while (!TroopBarReplyActivity.class.getSimpleName().equals(this.jdField_a_of_type_JavaLangString)) {
      return;
    }
    azhe.a("reply", "clk_photo_edit", 0, 0, new String[0]);
  }
  
  public void b(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    if (!azzz.b()) {
      bbmy.a((Context)this.jdField_a_of_type_MqqUtilWeakReference.get(), ((NewPhotoListActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).getResources().getString(2131653216), 0).a();
    }
    do
    {
      do
      {
        do
        {
          return;
          paramView = ((NewPhotoListActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).jdField_a_of_type_Agfv.a(paramInt);
        } while (paramView == null);
        paramAdapterView = ((NewPhotoListActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).getIntent();
        if (paramView.fileSize <= this.jdField_a_of_type_Aggg.jdField_a_of_type_Long) {
          break;
        }
        paramAdapterView = babr.a((Activity)this.jdField_a_of_type_MqqUtilWeakReference.get(), "你选择的视频文件过大，无法发送。");
        paramAdapterView.setPositiveButton(2131629116, new baca());
        paramAdapterView.show();
      } while (!this.c);
      paramAdapterView = ((NewPhotoListActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).getIntent().getStringExtra("PhotoConst.INIT_ACTIVITY_CLASS_NAME");
      paramView = new Intent("key_video_size_overflow");
      paramView.putExtra("className", paramAdapterView);
      ((NewPhotoListActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).sendBroadcast(paramView);
      return;
      if ((!this.c) || (paramView.mDuration - this.jdField_a_of_type_Aggg.jdField_b_of_type_Long <= 999L)) {
        break;
      }
      paramAdapterView = babr.a((Activity)this.jdField_a_of_type_MqqUtilWeakReference.get(), ajjy.a(2131642323));
      paramAdapterView.setPositiveButton(2131629116, new baca());
      paramAdapterView.show();
      paramAdapterView = ((NewPhotoListActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).getIntent().getStringExtra("PhotoConst.INIT_ACTIVITY_CLASS_NAME");
    } while (!this.c);
    paramView = new Intent("key_video_time_overflow");
    paramView.putExtra("className", paramAdapterView);
    ((NewPhotoListActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).sendBroadcast(paramView);
    return;
    Object localObject1 = baaf.c;
    Object localObject2;
    if (!((HashMap)localObject1).containsKey(paramView.path))
    {
      localObject2 = new Pair(this.jdField_a_of_type_Aggf.c, this.jdField_a_of_type_Aggf.jdField_b_of_type_JavaLangString);
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
        agak.a(BaseApplicationImpl.getContext()).a(new agie(this, paramAdapterView, (ArrayList)localObject1), paramView);
        return;
      }
      PhotoUtils.a((Activity)this.jdField_a_of_type_MqqUtilWeakReference.get(), paramAdapterView, (ArrayList)localObject1, 2, false);
      return;
    }
    if (!this.jdField_a_of_type_Aggg.jdField_e_of_type_Boolean)
    {
      paramView = ((NewPhotoListActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).getIntent();
      paramView.putExtra("ALBUM_NAME", this.jdField_a_of_type_Aggf.jdField_b_of_type_JavaLangString);
      paramView.putExtra("ALBUM_ID", this.jdField_a_of_type_Aggf.c);
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
    ((Intent)localObject1).putExtra("PhotoConst.IS_FROM_TROOP_BAR", this.c);
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
      ((NewPhotoListActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).startActivityForResult(paramIntent, 10012);
      return;
    }
    super.c(paramIntent);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     agid
 * JD-Core Version:    0.7.0.1
 */