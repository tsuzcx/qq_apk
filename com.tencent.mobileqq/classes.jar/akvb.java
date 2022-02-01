import android.content.Intent;
import android.content.res.Resources;
import android.os.Parcelable;
import android.support.v7.widget.GridLayoutManager;
import android.util.Pair;
import android.view.View;
import com.tencent.biz.pubaccount.readinjoy.activity.ReadInJoyUploadAvatarFragment;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.activity.photo.MediaScanner;
import com.tencent.mobileqq.activity.photo.PhotoCropActivity;
import com.tencent.mobileqq.activity.photo.PhotoCropForPortraitActivity;
import com.tencent.mobileqq.activity.photo.PhotoUtils;
import com.tencent.mobileqq.activity.photo.album.AbstractPhotoListActivity.PhotoListAdapter;
import com.tencent.mobileqq.activity.photo.album.NewPhotoListActivity;
import com.tencent.mobileqq.activity.photo.album.NewPhotoPreviewActivity;
import com.tencent.mobileqq.activity.photo.album.PhotoCommonBaseData;
import com.tencent.mobileqq.activity.shortvideo.ShortVideoPreviewActivity;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class akvb
  extends aktf
{
  private boolean a;
  private boolean b;
  
  akvb(NewPhotoListActivity paramNewPhotoListActivity)
  {
    super(paramNewPhotoListActivity);
  }
  
  protected void a(LocalMediaInfo paramLocalMediaInfo, int paramInt)
  {
    bhkd.a();
    String str = paramLocalMediaInfo.path;
    Intent localIntent = ((NewPhotoListActivity)this.mActivity).getIntent();
    localIntent.putExtra("ALBUM_NAME", this.mPhotoCommonData.albumName);
    localIntent.putExtra("ALBUM_ID", this.mPhotoCommonData.albumId);
    localIntent.putExtra("PhotoConst.IS_SINGLE_MODE", true);
    localIntent.putStringArrayListExtra("PhotoConst.PHOTO_PATHS", this.mPhotoCommonData.selectedPhotoList);
    localIntent.putExtra("PhotoConst.SINGLE_PHOTO_PATH", str);
    localIntent.putExtra("media_info", paramLocalMediaInfo);
    if (localIntent.getBooleanExtra("PhotoConst.MULTI_PREVIEW_IN_SINGLE_MODE", false))
    {
      localIntent.putStringArrayListExtra("PhotoConst.PHOTO_PATHS", this.mPhotoCommonData.mediaPathsList);
      localIntent.putExtra("PhotoConst.CURRENT_SELECTED_INDEX", paramInt);
    }
    if (this.jdField_a_of_type_Akte.f)
    {
      paramLocalMediaInfo = bhkd.sSelectItemAlbum;
      if (!paramLocalMediaInfo.containsKey(str)) {
        paramLocalMediaInfo.put(str, new Pair(this.mPhotoCommonData.albumId, this.mPhotoCommonData.albumName));
      }
      ((NewPhotoListActivity)this.mActivity).recordLastPos(str);
      PhotoUtils.a(this.mActivity, localIntent, this.mPhotoCommonData.selectedPhotoList, 0, this.jdField_a_of_type_Akte.jdField_a_of_type_Boolean);
      return;
    }
    if (!this.jdField_a_of_type_Akte.g)
    {
      localIntent.putExtra("PhotoConst.ALLOW_LOCK", false);
      localIntent.setClass(this.mActivity, NewPhotoPreviewActivity.class);
      localIntent.putExtra("PasterConstants.pasters_data", this.jdField_a_of_type_Akte.jdField_b_of_type_JavaUtilHashMap);
      localIntent.putExtra("FROM_WHERE", "FROM_PHOTO_LIST");
      localIntent.putExtra("PhotoConst.SOURCE_FROM", "FROM_SELECT_PHOTO");
      localIntent.addFlags(603979776);
      paramLocalMediaInfo = ((NewPhotoListActivity)this.mActivity).getIntent().getStringExtra("PhotoConst.INIT_ACTIVITY_CLASS_NAME");
      if (ReadInJoyUploadAvatarFragment.class.getName().equals(paramLocalMediaInfo)) {
        break label528;
      }
      ((NewPhotoListActivity)this.mActivity).startActivity(localIntent);
      ((NewPhotoListActivity)this.mActivity).finish();
    }
    for (;;)
    {
      bhkd.anim(this.mActivity, true, true);
      return;
      paramInt = localIntent.getIntExtra("Business_Origin", 0);
      if ((100 == paramInt) || (102 == paramInt) || (103 == paramInt)) {
        if (100 == paramInt)
        {
          int i = bhhz.b(this.mActivity);
          localIntent.putExtra("PhotoConst.CLIP_WIDTH", i);
          localIntent.putExtra("PhotoConst.CLIP_HEIGHT", i);
          label410:
          localIntent.setClass(this.mActivity, PhotoCropForPortraitActivity.class);
          localIntent.putExtra("PhotoConst.EDIT_MASK_SHAPE_TYPE", aksj.c(paramInt));
          localIntent.putExtra("PhotoConst.TARGET_WIDTH", 640);
          localIntent.putExtra("PhotoConst.TARGET_HEIGHT", 640);
        }
      }
      for (;;)
      {
        bhkd.a(localIntent, this.mPhotoCommonData.albumId, str, this.jdField_a_of_type_Akte.isRecodeLastAlbumPath);
        localIntent.putExtra("PHOTOLIST_START_POSITION", ((NewPhotoListActivity)this.mActivity).gridLayoutManager.findFirstVisibleItemPosition());
        break;
        localIntent.putExtra("PhotoConst.IS_WITH_PENDANT", false);
        break label410;
        localIntent.setClass(this.mActivity, PhotoCropActivity.class);
      }
      label528:
      ((NewPhotoListActivity)this.mActivity).startActivityForResult(localIntent, 100014);
    }
  }
  
  public void caseVideo(View paramView, int paramInt)
  {
    if (!bhjx.a()) {
      QQToast.a(this.mActivity, ((NewPhotoListActivity)this.mActivity).getResources().getString(2131717719), 0).a();
    }
    Object localObject1;
    do
    {
      return;
      localObject1 = ((NewPhotoListActivity)this.mActivity).photoListAdapter.getItem(paramInt);
    } while (localObject1 == null);
    paramView = ((NewPhotoListActivity)this.mActivity).getIntent();
    if ((((LocalMediaInfo)localObject1).fileSize > this.mPhotoCommonData.videoSizeLimit) && (!this.jdField_a_of_type_Boolean))
    {
      paramView = bhlq.a(this.mActivity, "你选择的视频文件过大，无法发送。");
      paramView.setPositiveButton(2131694098, new bhme());
      paramView.show();
      return;
    }
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
        MediaScanner.getInstance(BaseApplicationImpl.getContext()).queryMediaInfoAsync(new akvc(this, paramView, (ArrayList)localObject2), (LocalMediaInfo)localObject1);
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
    this.jdField_a_of_type_Boolean = paramIntent.getBooleanExtra("readinjoy_video", false);
    this.jdField_b_of_type_Boolean = paramIntent.getBooleanExtra("from_readinjoy_slideshow", false);
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
    ArrayList localArrayList = this.mPhotoCommonData.selectedPhotoList;
    if ((QLog.isDevelopLevel()) && (localArrayList != null) && (localArrayList.size() != 0)) {
      QLog.d("PhotoListActivity", 4, "[NewPhotoListActivity] [onActivityResult] selectedPhotoList = " + localArrayList.size());
    }
    if (paramInt2 == -1)
    {
      if ((this.jdField_a_of_type_Boolean) || (this.jdField_b_of_type_Boolean))
      {
        ((NewPhotoListActivity)this.mActivity).setResult(-1, paramIntent);
        ((NewPhotoListActivity)this.mActivity).finish();
      }
    }
    else if (paramInt1 == 17)
    {
      if ((this.jdField_a_of_type_Boolean) && (paramIntent != null))
      {
        ((NewPhotoListActivity)this.mActivity).setResult(0, paramIntent);
        ((NewPhotoListActivity)this.mActivity).finish();
      }
      bhkd.sLastAlbumRecordTime = 0L;
      return;
    }
    PhotoUtils.a(this.mActivity, paramInt1, paramInt2, paramIntent, this.jdField_a_of_type_Akte.h, this.mPhotoCommonData.myUin);
  }
  
  public void onTitleBtnCancelClick(View paramView)
  {
    if (this.jdField_a_of_type_Boolean)
    {
      bhkd.clearSelectItemInfo();
      bhkd.a();
      ((NewPhotoListActivity)this.mActivity).setResult(0, ((NewPhotoListActivity)this.mActivity).getIntent());
      ((NewPhotoListActivity)this.mActivity).finish();
      bhkd.anim(this.mActivity, false, false);
      return;
    }
    super.onTitleBtnCancelClick(paramView);
  }
  
  public void startPhotoPreviewActivity(Intent paramIntent)
  {
    if (this.jdField_b_of_type_Boolean)
    {
      ((NewPhotoListActivity)this.mActivity).startActivityForResult(paramIntent, 10013);
      return;
    }
    super.startPhotoPreviewActivity(paramIntent);
  }
  
  public void updateAddData(List<LocalMediaInfo> paramList, int paramInt)
  {
    if ((this.jdField_a_of_type_Boolean) && (paramList != null))
    {
      int i = paramList.size() - 1;
      while (i >= paramInt)
      {
        if (!((LocalMediaInfo)paramList.get(i)).path.endsWith(".mp4")) {
          paramList.remove(i);
        }
        i -= 1;
      }
    }
    super.updateAddData(paramList, paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     akvb
 * JD-Core Version:    0.7.0.1
 */