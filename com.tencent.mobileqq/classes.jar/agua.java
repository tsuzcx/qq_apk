import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.text.TextUtils;
import android.util.Pair;
import android.view.View;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.activity.photo.PhotoUtils;
import com.tencent.mobileqq.activity.photo.album.NewPhotoListActivity;
import com.tencent.mobileqq.activity.photo.album.NewPhotoPreviewActivity;
import com.tencent.mobileqq.activity.shortvideo.ShortVideoPreviewActivity;
import com.tencent.mobileqq.pic.PresendPicMgr;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.AdapterView;
import com.tencent.widget.GestureSelectGridView;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import mqq.util.WeakReference;

public class agua
  extends agsj
{
  protected agua(NewPhotoListActivity paramNewPhotoListActivity)
  {
    super(paramNewPhotoListActivity);
  }
  
  public static agsc b(NewPhotoListActivity paramNewPhotoListActivity)
  {
    if ((jdField_a_of_type_Agsc == null) || (jdField_a_of_type_Agsc.jdField_a_of_type_MqqUtilWeakReference.get() != paramNewPhotoListActivity)) {}
    try
    {
      if ((jdField_a_of_type_Agsc == null) || (jdField_a_of_type_Agsc.jdField_a_of_type_MqqUtilWeakReference.get() != paramNewPhotoListActivity)) {
        jdField_a_of_type_Agsc = new agua(paramNewPhotoListActivity);
      }
      return jdField_a_of_type_Agsc;
    }
    finally {}
  }
  
  protected String a(LocalMediaInfo paramLocalMediaInfo)
  {
    int i = this.jdField_a_of_type_Agrz.jdField_a_of_type_Int;
    if (this.jdField_a_of_type_Agsb.b == 6) {
      return ((NewPhotoListActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).getResources().getString(2131695099, new Object[] { Integer.valueOf(i) });
    }
    if (this.jdField_a_of_type_Agsb.b == 2) {
      return ((NewPhotoListActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).getResources().getString(2131695103, new Object[] { Integer.valueOf(i) });
    }
    return super.a(paramLocalMediaInfo);
  }
  
  protected void a(Intent paramIntent)
  {
    super.a(paramIntent);
  }
  
  protected void a(View paramView)
  {
    paramView = ((NewPhotoListActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).getIntent();
    bbbx.c();
    bbbx.a();
    Object localObject = PresendPicMgr.a();
    if (localObject != null) {
      ((PresendPicMgr)localObject).a(1006);
    }
    int i;
    if (this.jdField_a_of_type_Agrz.jdField_a_of_type_JavaUtilArrayList != null)
    {
      i = this.jdField_a_of_type_Agrz.jdField_a_of_type_JavaUtilArrayList.size();
      agqd.b(paramView, i);
      if (this.jdField_a_of_type_Agsb.t) {
        break label105;
      }
      ((NewPhotoListActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).finish();
      bbbx.a((Activity)this.jdField_a_of_type_MqqUtilWeakReference.get(), false, false);
    }
    label105:
    String str;
    do
    {
      return;
      i = 0;
      break;
      QLog.e("PhotoListLogicMiniApp", 2, "onTitleBtnRightClick");
      localObject = new Intent();
      str = paramView.getStringExtra("PhotoConst.DEST_BROADCAST_ACTION_NAME");
      if (QLog.isColorLevel()) {
        QLog.d("PhotoListLogicMiniApp", 2, String.format("sendPhoto action=%s", new Object[] { str }));
      }
    } while (TextUtils.isEmpty(str));
    if (QLog.isColorLevel()) {
      QLog.d("PhotoListLogicMiniApp", 2, String.format("sendPhoto extras=%s", new Object[] { paramView.getExtras() }));
    }
    ((Intent)localObject).setComponent(null);
    ((Intent)localObject).setAction(str);
    ((Intent)localObject).setFlags(paramView.getFlags() & 0xDFFFFFFF & 0xFBFFFFFF);
    ((NewPhotoListActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).sendBroadcast((Intent)localObject);
    ((NewPhotoListActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).finish();
    bbbx.a((Activity)this.jdField_a_of_type_MqqUtilWeakReference.get(), false, false);
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
      paramAdapterView = bbdj.a((Activity)this.jdField_a_of_type_MqqUtilWeakReference.get(), "请选择不超过" + (float)this.jdField_a_of_type_Agrz.jdField_b_of_type_Long / 1024.0F / 1024.0F / 1024.0F + "G的视频");
      paramAdapterView.setPositiveButton(2131694794, new bbdt());
      paramAdapterView.show();
      return;
    }
    if (paramView.mDuration > this.jdField_a_of_type_Agrz.jdField_c_of_type_Long)
    {
      paramAdapterView = bbdj.a((Activity)this.jdField_a_of_type_MqqUtilWeakReference.get(), "请选择不超过" + this.jdField_a_of_type_Agrz.jdField_c_of_type_Long / 60L / 1000L + "分钟的视频");
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
      paramView.putExtra("PasterConstants.paster_cate_id", this.jdField_a_of_type_Agsb.d);
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
    ((Intent)localObject1).putExtra("uin", this.jdField_a_of_type_Agsb.f);
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
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     agua
 * JD-Core Version:    0.7.0.1
 */