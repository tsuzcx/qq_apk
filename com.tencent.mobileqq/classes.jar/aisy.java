import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Pair;
import android.view.View;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.activity.photo.MediaScanner;
import com.tencent.mobileqq.activity.photo.PhotoUtils;
import com.tencent.mobileqq.activity.photo.album.AbstractPhotoListActivity.PhotoListAdapter;
import com.tencent.mobileqq.activity.photo.album.NewPhotoListActivity;
import com.tencent.mobileqq.activity.photo.album.NewPhotoPreviewActivity;
import com.tencent.mobileqq.activity.shortvideo.ShortVideoPreviewActivity;
import com.tencent.mobileqq.troop.activity.TroopBarPublishActivity;
import com.tencent.mobileqq.troop.activity.TroopBarReplyActivity;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.AdapterView;
import com.tencent.widget.GestureSelectGridView;
import java.io.File;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;

public class aisy
  extends aira
{
  private String jdField_a_of_type_JavaLangString = "";
  private boolean jdField_a_of_type_Boolean;
  private boolean b;
  private boolean c;
  
  aisy(NewPhotoListActivity paramNewPhotoListActivity)
  {
    super(paramNewPhotoListActivity);
  }
  
  public void caseVideo(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    if (!bdeu.a()) {
      QQToast.a(this.mActivity, ((NewPhotoListActivity)this.mActivity).getResources().getString(2131719547), 0).a();
    }
    do
    {
      do
      {
        do
        {
          return;
          paramView = ((NewPhotoListActivity)this.mActivity).photoListAdapter.getItem(paramInt);
        } while (paramView == null);
        paramAdapterView = ((NewPhotoListActivity)this.mActivity).getIntent();
        if (paramView.fileSize <= this.mPhotoCommonData.videoSizeLimit) {
          break;
        }
        paramAdapterView = bdgm.a(this.mActivity, "你选择的视频文件过大，无法发送。");
        paramAdapterView.setPositiveButton(2131694953, new bdgx());
        paramAdapterView.show();
      } while (!this.c);
      paramAdapterView = ((NewPhotoListActivity)this.mActivity).getIntent().getStringExtra("PhotoConst.INIT_ACTIVITY_CLASS_NAME");
      paramView = new Intent("key_video_size_overflow");
      paramView.putExtra("className", paramAdapterView);
      ((NewPhotoListActivity)this.mActivity).sendBroadcast(paramView);
      return;
      if ((!this.c) || (paramView.mDuration - this.mPhotoCommonData.videoDurationLimit <= 999L)) {
        break;
      }
      paramAdapterView = bdgm.a(this.mActivity, alud.a(2131708503));
      paramAdapterView.setPositiveButton(2131694953, new bdgx());
      paramAdapterView.show();
      paramAdapterView = ((NewPhotoListActivity)this.mActivity).getIntent().getStringExtra("PhotoConst.INIT_ACTIVITY_CLASS_NAME");
    } while (!this.c);
    paramView = new Intent("key_video_time_overflow");
    paramView.putExtra("className", paramAdapterView);
    ((NewPhotoListActivity)this.mActivity).sendBroadcast(paramView);
    return;
    Object localObject1 = bdfa.sSelectItemAlbum;
    Object localObject2;
    if (!((HashMap)localObject1).containsKey(paramView.path))
    {
      localObject2 = new Pair(this.mPhotoCommonData.albumId, this.mPhotoCommonData.albumName);
      ((HashMap)localObject1).put(paramView.path, localObject2);
    }
    ((NewPhotoListActivity)this.mActivity).recordLastPos(paramView.path);
    if (!this.jdField_a_of_type_Aiqz.jdField_b_of_type_Boolean)
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
        ((NewPhotoListActivity)this.mActivity).showProgressDialog();
        MediaScanner.getInstance(BaseApplicationImpl.getContext()).queryMediaInfoAsync(new aisz(this, paramAdapterView, (ArrayList)localObject1), paramView);
        return;
      }
      PhotoUtils.a(this.mActivity, paramAdapterView, (ArrayList)localObject1, 2, false);
      return;
    }
    if (!this.jdField_a_of_type_Aiqz.isSingleMode)
    {
      paramView = ((NewPhotoListActivity)this.mActivity).getIntent();
      paramView.putExtra("ALBUM_NAME", this.mPhotoCommonData.albumName);
      paramView.putExtra("ALBUM_ID", this.mPhotoCommonData.albumId);
      localObject1 = ((NewPhotoListActivity)this.mActivity).photoListAdapter.getItem(paramInt);
      paramView.putExtra("PhotoConst.CURRENT_SELECTED_INDEX", ((LocalMediaInfo)localObject1).position);
      paramView.putStringArrayListExtra("PhotoConst.SELECTED_PATHS", this.mPhotoCommonData.selectedPhotoList);
      paramView.putIntegerArrayListExtra("PhotoConst.SELECTED_INDEXS", this.mPhotoCommonData.selectedIndex);
      paramView.putExtra("FROM_WHERE", "FROM_PHOTO_LIST");
      paramView.putExtra("PhotoConst.CURRENT_QUALITY_TYPE", this.mPhotoCommonData.currentQualityType);
      paramView.putExtra("PhotoConst.SHOW_ALBUM", true);
      paramView.putExtra("PhotoConst.SHOW_MAGIC_USE_PASTER", this.jdField_a_of_type_Aiqz.e);
      paramView.putExtra("PasterConstants.paster_id", this.jdField_a_of_type_Aiqz.jdField_a_of_type_JavaLangString);
      paramView.putExtra("PasterConstants.paster_cate_id", this.jdField_a_of_type_Aiqz.jdField_b_of_type_JavaLangString);
      aiqz.sPhotoListFirstPos = ((NewPhotoListActivity)this.mActivity).mGridView.getFirstVisiblePosition();
      localObject2 = this.mPhotoCommonData.selectedMediaInfoHashMap;
      if (!((HashMap)localObject2).containsKey(((LocalMediaInfo)localObject1).path)) {
        ((HashMap)localObject2).put(((LocalMediaInfo)localObject1).path, localObject1);
      }
      paramView.putExtra("PeakConstants.selectedMediaInfoHashMap", (Serializable)localObject2);
      paramView.putExtra("PasterConstants.pasters_data", this.jdField_a_of_type_Aiqz.jdField_b_of_type_JavaUtilHashMap);
      paramView.setClass(this.mActivity, NewPhotoPreviewActivity.class);
      paramView.addFlags(603979776);
      if ((this.mPhotoCommonData.selectedPhotoList != null) && (this.mPhotoCommonData.selectedPhotoList.size() > 0)) {
        azqs.b(null, "CliOper", "", this.mPhotoCommonData.myUin, "0X8005674", "0X8005674", 0, this.mPhotoCommonData.selectedPhotoList.size(), 0, "", "", "", "");
      }
      if (this.mPhotoCommonData.a()) {
        ((NewPhotoListActivity)this.mActivity).startActivityForResult(paramAdapterView, 100010);
      }
      for (;;)
      {
        bdfa.anim(this.mActivity, true, true);
        return;
        ((NewPhotoListActivity)this.mActivity).startActivity(paramView);
        ((NewPhotoListActivity)this.mActivity).finish();
      }
    }
    localObject1 = new Intent(this.mActivity, ShortVideoPreviewActivity.class);
    ((Intent)localObject1).putExtras(paramAdapterView);
    ((Intent)localObject1).putExtra("file_send_path", paramView.path);
    ((Intent)localObject1).putExtra("file_send_size", paramView.fileSize);
    ((Intent)localObject1).putExtra("file_send_duration", paramView.mDuration);
    ((Intent)localObject1).putExtra("file_width", paramView.mediaWidth);
    ((Intent)localObject1).putExtra("file_height", paramView.mediaHeight);
    ((Intent)localObject1).putExtra("uin", this.jdField_a_of_type_Aiqz.d);
    ((Intent)localObject1).putExtra("uintype", this.jdField_a_of_type_Aiqz.jdField_a_of_type_Int);
    ((Intent)localObject1).putExtra("file_source", "album");
    ((Intent)localObject1).putExtra("is_from_system_media", paramView.isSystemMeidaStore);
    ((Intent)localObject1).putExtra("PhotoConst.IS_FROM_TROOP_BAR", this.c);
    if (this.jdField_a_of_type_Aiqz.isSupportVideoCheckbox)
    {
      ((Intent)localObject1).putExtra("PhotoConst.IS_SUPPORT_VIDEO_CHECKBOX", true);
      ((Intent)localObject1).putExtra("PhotoConst.PHOTO_PATHS", this.mPhotoCommonData.selectedPhotoList);
    }
    ((NewPhotoListActivity)this.mActivity).startActivityForResult((Intent)localObject1, 17);
  }
  
  public void initData(Intent paramIntent)
  {
    super.initData(paramIntent);
    this.jdField_a_of_type_JavaLangString = paramIntent.getStringExtra("from_tribe_class_name");
    this.jdField_a_of_type_Boolean = "tribe".equals(paramIntent.getStringExtra("video_refer"));
    this.jdField_b_of_type_Boolean = paramIntent.getBooleanExtra("from_tribe_slideshow", false);
    this.c = paramIntent.getBooleanExtra("PhotoConst.IS_FROM_TROOP_BAR", false);
    this.mPhotoCommonData.a(this.jdField_b_of_type_Boolean);
    if (this.mPhotoCommonData.a())
    {
      xna.a().c(21);
      xna.a().b(13);
      xna.a().e();
    }
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if ((!this.jdField_a_of_type_Boolean) && (!this.jdField_b_of_type_Boolean))
    {
      super.onActivityResult(paramInt1, paramInt2, paramIntent);
      return;
    }
    Object localObject = this.mPhotoCommonData.selectedPhotoList;
    if ((QLog.isDevelopLevel()) && (localObject != null) && (((ArrayList)localObject).size() != 0)) {
      QLog.d("PhotoListActivity", 4, "[NewPhotoListActivity] [onActivityResult] selectedPhotoList = " + ((ArrayList)localObject).size());
    }
    if (paramInt2 == -1)
    {
      if ((paramInt1 == 10012) && (this.jdField_b_of_type_Boolean))
      {
        ((NewPhotoListActivity)this.mActivity).setResult(-1, paramIntent);
        ((NewPhotoListActivity)this.mActivity).finish();
      }
      if (this.jdField_a_of_type_Boolean)
      {
        ((NewPhotoListActivity)this.mActivity).setResult(-1, paramIntent);
        ((NewPhotoListActivity)this.mActivity).finish();
      }
    }
    else if ((paramInt1 == 10012) && (this.jdField_b_of_type_Boolean) && (paramIntent != null))
    {
      localObject = paramIntent.getStringExtra("PhotoConst.FROM_QQSTORY_SLIDESHOW_DATA");
      if (!TextUtils.isEmpty((CharSequence)localObject)) {
        bdhb.a(new File((String)localObject).getParent());
      }
    }
    PhotoUtils.a(this.mActivity, paramInt1, paramInt2, paramIntent, this.jdField_a_of_type_Aiqz.h, this.mPhotoCommonData.myUin);
  }
  
  public void onMagicStickClick(View paramView, Bundle paramBundle, int paramInt, Intent paramIntent)
  {
    super.onMagicStickClick(paramView, paramBundle, paramInt, paramIntent);
    if ((this.mPhotoCommonData.selectedPhotoList.size() > 0) && (!TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)))
    {
      if (!TroopBarPublishActivity.class.getSimpleName().equals(this.jdField_a_of_type_JavaLangString)) {
        break label64;
      }
      bclq.a("pub_page_new", "clk_photo_edit", 0, 0, new String[0]);
    }
    label64:
    while (!TroopBarReplyActivity.class.getSimpleName().equals(this.jdField_a_of_type_JavaLangString)) {
      return;
    }
    bclq.a("reply", "clk_photo_edit", 0, 0, new String[0]);
  }
  
  public void startPhotoPreviewActivity(Intent paramIntent)
  {
    if (this.jdField_b_of_type_Boolean)
    {
      ((NewPhotoListActivity)this.mActivity).startActivityForResult(paramIntent, 10012);
      return;
    }
    super.startPhotoPreviewActivity(paramIntent);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aisy
 * JD-Core Version:    0.7.0.1
 */