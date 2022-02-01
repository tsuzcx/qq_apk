import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.v7.widget.GridLayoutManager;
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
import com.tencent.mobileqq.activity.photo.album.PhotoCommonBaseData;
import com.tencent.mobileqq.activity.shortvideo.ShortVideoPreviewActivity;
import com.tencent.mobileqq.troop.activity.TroopBarPublishActivity;
import com.tencent.mobileqq.troop.activity.TroopBarReplyActivity;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;

public class akvf
  extends aktf
{
  private String jdField_a_of_type_JavaLangString = "";
  private boolean jdField_a_of_type_Boolean;
  private boolean b;
  private boolean c;
  
  akvf(NewPhotoListActivity paramNewPhotoListActivity)
  {
    super(paramNewPhotoListActivity);
  }
  
  public void caseVideo(View paramView, int paramInt)
  {
    if (!bhjx.a()) {
      QQToast.a(this.mActivity, ((NewPhotoListActivity)this.mActivity).getResources().getString(2131717719), 0).a();
    }
    do
    {
      do
      {
        do
        {
          return;
          localObject1 = ((NewPhotoListActivity)this.mActivity).photoListAdapter.getItem(paramInt);
        } while (localObject1 == null);
        paramView = ((NewPhotoListActivity)this.mActivity).getIntent();
        if (((LocalMediaInfo)localObject1).fileSize <= this.mPhotoCommonData.videoSizeLimit) {
          break;
        }
        paramView = bhlq.a(this.mActivity, "你选择的视频文件过大，无法发送。");
        paramView.setPositiveButton(2131694098, new bhme());
        paramView.show();
      } while (!this.c);
      paramView = ((NewPhotoListActivity)this.mActivity).getIntent().getStringExtra("PhotoConst.INIT_ACTIVITY_CLASS_NAME");
      localObject1 = new Intent("key_video_size_overflow");
      ((Intent)localObject1).putExtra("className", paramView);
      ((NewPhotoListActivity)this.mActivity).sendBroadcast((Intent)localObject1);
      return;
      if ((!this.c) || (((LocalMediaInfo)localObject1).mDuration - this.mPhotoCommonData.videoDurationLimit <= 999L)) {
        break;
      }
      paramView = bhlq.a(this.mActivity, anzj.a(2131706989));
      paramView.setPositiveButton(2131694098, new bhme());
      paramView.show();
      paramView = ((NewPhotoListActivity)this.mActivity).getIntent().getStringExtra("PhotoConst.INIT_ACTIVITY_CLASS_NAME");
    } while (!this.c);
    Object localObject1 = new Intent("key_video_time_overflow");
    ((Intent)localObject1).putExtra("className", paramView);
    ((NewPhotoListActivity)this.mActivity).sendBroadcast((Intent)localObject1);
    return;
    Object localObject2 = bhkd.sSelectItemAlbum;
    Object localObject3;
    if (!((HashMap)localObject2).containsKey(((LocalMediaInfo)localObject1).path))
    {
      localObject3 = new Pair(this.mPhotoCommonData.albumId, this.mPhotoCommonData.albumName);
      ((HashMap)localObject2).put(((LocalMediaInfo)localObject1).path, localObject3);
    }
    ((NewPhotoListActivity)this.mActivity).recordLastPos(((LocalMediaInfo)localObject1).path);
    if (!this.jdField_a_of_type_Akte.jdField_b_of_type_Boolean)
    {
      paramView.putExtra("file_send_path", ((LocalMediaInfo)localObject1).path);
      paramView.putExtra("PhotoConst.IS_VIDEO_SELECTED", true);
      paramView.putExtra("PhotoConst.VIDEO_SIZE", ((LocalMediaInfo)localObject1).fileSize);
      paramView.putExtra("file_send_duration", ((LocalMediaInfo)localObject1).mDuration);
      paramView.putExtra("file_width", ((LocalMediaInfo)localObject1).mediaWidth);
      paramView.putExtra("file_height", ((LocalMediaInfo)localObject1).mediaHeight);
      paramView.putExtra("media_info", (Parcelable)localObject1);
      localObject2 = new ArrayList();
      ((ArrayList)localObject2).add(((LocalMediaInfo)localObject1).path);
      if (this.jdField_a_of_type_Boolean)
      {
        ((NewPhotoListActivity)this.mActivity).showProgressDialog();
        MediaScanner.getInstance(BaseApplicationImpl.getContext()).queryMediaInfoAsync(new akvg(this, paramView, (ArrayList)localObject2), (LocalMediaInfo)localObject1);
        return;
      }
      PhotoUtils.a(this.mActivity, paramView, (ArrayList)localObject2, 2, false);
      return;
    }
    if (!this.jdField_a_of_type_Akte.isSingleMode)
    {
      localObject1 = ((NewPhotoListActivity)this.mActivity).getIntent();
      ((Intent)localObject1).putExtra("ALBUM_NAME", this.mPhotoCommonData.albumName);
      ((Intent)localObject1).putExtra("ALBUM_ID", this.mPhotoCommonData.albumId);
      localObject2 = ((NewPhotoListActivity)this.mActivity).photoListAdapter.getItem(paramInt);
      ((Intent)localObject1).putExtra("PhotoConst.CURRENT_SELECTED_INDEX", ((LocalMediaInfo)localObject2).position);
      ((Intent)localObject1).putStringArrayListExtra("PhotoConst.SELECTED_PATHS", this.mPhotoCommonData.selectedPhotoList);
      ((Intent)localObject1).putIntegerArrayListExtra("PhotoConst.SELECTED_INDEXS", this.mPhotoCommonData.selectedIndex);
      ((Intent)localObject1).putExtra("FROM_WHERE", "FROM_PHOTO_LIST");
      ((Intent)localObject1).putExtra("PhotoConst.CURRENT_QUALITY_TYPE", this.mPhotoCommonData.currentQualityType);
      ((Intent)localObject1).putExtra("PhotoConst.SHOW_ALBUM", true);
      ((Intent)localObject1).putExtra("PhotoConst.SHOW_MAGIC_USE_PASTER", this.jdField_a_of_type_Akte.e);
      ((Intent)localObject1).putExtra("PasterConstants.paster_id", this.jdField_a_of_type_Akte.jdField_a_of_type_JavaLangString);
      ((Intent)localObject1).putExtra("PasterConstants.paster_cate_id", this.jdField_a_of_type_Akte.jdField_b_of_type_JavaLangString);
      akte.sPhotoListFirstPos = ((NewPhotoListActivity)this.mActivity).gridLayoutManager.findFirstVisibleItemPosition();
      localObject3 = this.mPhotoCommonData.selectedMediaInfoHashMap;
      if (!((HashMap)localObject3).containsKey(((LocalMediaInfo)localObject2).path)) {
        ((HashMap)localObject3).put(((LocalMediaInfo)localObject2).path, localObject2);
      }
      ((Intent)localObject1).putExtra("PeakConstants.selectedMediaInfoHashMap", (Serializable)localObject3);
      ((Intent)localObject1).putExtra("PasterConstants.pasters_data", this.jdField_a_of_type_Akte.jdField_b_of_type_JavaUtilHashMap);
      ((Intent)localObject1).setClass(this.mActivity, NewPhotoPreviewActivity.class);
      ((Intent)localObject1).addFlags(603979776);
      if ((this.mPhotoCommonData.selectedPhotoList != null) && (this.mPhotoCommonData.selectedPhotoList.size() > 0)) {
        bdll.b(null, "CliOper", "", this.mPhotoCommonData.myUin, "0X8005674", "0X8005674", 0, this.mPhotoCommonData.selectedPhotoList.size(), 0, "", "", "", "");
      }
      if (((aktm)this.mOtherCommonData).a()) {
        ((NewPhotoListActivity)this.mActivity).startActivityForResult(paramView, 100010);
      }
      for (;;)
      {
        bhkd.anim(this.mActivity, true, true);
        return;
        ((NewPhotoListActivity)this.mActivity).startActivity((Intent)localObject1);
        ((NewPhotoListActivity)this.mActivity).finish();
      }
    }
    localObject2 = new Intent(this.mActivity, ShortVideoPreviewActivity.class);
    ((Intent)localObject2).putExtras(paramView);
    ((Intent)localObject2).putExtra("file_send_path", ((LocalMediaInfo)localObject1).path);
    ((Intent)localObject2).putExtra("file_send_size", ((LocalMediaInfo)localObject1).fileSize);
    ((Intent)localObject2).putExtra("file_send_duration", ((LocalMediaInfo)localObject1).mDuration);
    ((Intent)localObject2).putExtra("file_width", ((LocalMediaInfo)localObject1).mediaWidth);
    ((Intent)localObject2).putExtra("file_height", ((LocalMediaInfo)localObject1).mediaHeight);
    ((Intent)localObject2).putExtra("uin", this.jdField_a_of_type_Akte.d);
    ((Intent)localObject2).putExtra("uintype", this.jdField_a_of_type_Akte.jdField_a_of_type_Int);
    ((Intent)localObject2).putExtra("file_source", "album");
    ((Intent)localObject2).putExtra("is_from_system_media", ((LocalMediaInfo)localObject1).isSystemMeidaStore);
    ((Intent)localObject2).putExtra("PhotoConst.IS_FROM_TROOP_BAR", this.c);
    if (this.jdField_a_of_type_Akte.isSupportVideoCheckbox)
    {
      ((Intent)localObject2).putExtra("PhotoConst.IS_SUPPORT_VIDEO_CHECKBOX", true);
      ((Intent)localObject2).putExtra("PhotoConst.PHOTO_PATHS", this.mPhotoCommonData.selectedPhotoList);
    }
    ((NewPhotoListActivity)this.mActivity).startActivityForResult((Intent)localObject2, 17);
  }
  
  public void initData(Intent paramIntent)
  {
    super.initData(paramIntent);
    this.jdField_a_of_type_JavaLangString = paramIntent.getStringExtra("from_tribe_class_name");
    this.jdField_a_of_type_Boolean = "tribe".equals(paramIntent.getStringExtra("video_refer"));
    this.jdField_b_of_type_Boolean = paramIntent.getBooleanExtra("from_tribe_slideshow", false);
    this.c = paramIntent.getBooleanExtra("PhotoConst.IS_FROM_TROOP_BAR", false);
    ((aktm)this.mOtherCommonData).a(this.jdField_b_of_type_Boolean, this.mPhotoCommonData);
    if (((aktm)this.mOtherCommonData).a())
    {
      zkg.a().c(21);
      zkg.a().b(13);
      zkg.a().e();
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
        bhmi.a(new File((String)localObject).getParent());
      }
    }
    PhotoUtils.a(this.mActivity, paramInt1, paramInt2, paramIntent, this.jdField_a_of_type_Akte.h, this.mPhotoCommonData.myUin);
  }
  
  public void onMagicStickClick(View paramView, Bundle paramBundle, int paramInt, Intent paramIntent)
  {
    super.onMagicStickClick(paramView, paramBundle, paramInt, paramIntent);
    if ((this.mPhotoCommonData.selectedPhotoList.size() > 0) && (!TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)))
    {
      if (!TroopBarPublishActivity.class.getSimpleName().equals(this.jdField_a_of_type_JavaLangString)) {
        break label64;
      }
      bgqi.a("pub_page_new", "clk_photo_edit", 0, 0, new String[0]);
    }
    label64:
    while (!TroopBarReplyActivity.class.getSimpleName().equals(this.jdField_a_of_type_JavaLangString)) {
      return;
    }
    bgqi.a("reply", "clk_photo_edit", 0, 0, new String[0]);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     akvf
 * JD-Core Version:    0.7.0.1
 */