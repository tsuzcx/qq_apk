import android.content.Intent;
import android.content.res.Resources;
import android.os.Parcelable;
import android.support.v7.widget.GridLayoutManager;
import android.text.TextUtils;
import android.util.Pair;
import android.view.View;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.activity.photo.PhotoUtils;
import com.tencent.mobileqq.activity.photo.album.AbstractPhotoListActivity.PhotoListAdapter;
import com.tencent.mobileqq.activity.photo.album.NewPhotoListActivity;
import com.tencent.mobileqq.activity.photo.album.NewPhotoPreviewActivity;
import com.tencent.mobileqq.activity.photo.album.PhotoCommonBaseData;
import com.tencent.mobileqq.activity.shortvideo.ShortVideoPreviewActivity;
import com.tencent.mobileqq.pic.PresendPicMgr;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;

public class akut
  extends aktf
{
  akut(NewPhotoListActivity paramNewPhotoListActivity)
  {
    super(paramNewPhotoListActivity);
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
    if (((LocalMediaInfo)localObject1).fileSize > this.mPhotoCommonData.videoSizeLimit)
    {
      paramView = bhlq.a(this.mActivity, "请选择不超过" + (float)this.mPhotoCommonData.videoSizeLimit / 1024.0F / 1024.0F / 1024.0F + "G的视频");
      paramView.setPositiveButton(2131694098, new bhme());
      paramView.show();
      return;
    }
    if (((LocalMediaInfo)localObject1).mDuration > this.mPhotoCommonData.videoDurationLimit)
    {
      paramView = bhlq.a(this.mActivity, "请选择不超过" + this.mPhotoCommonData.videoDurationLimit / 60L / 1000L + "分钟的视频");
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
    if (!this.a.jdField_b_of_type_Boolean)
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
      PhotoUtils.a(this.mActivity, paramView, (ArrayList)localObject2, 2, false);
      return;
    }
    if (!this.a.isSingleMode)
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
      ((Intent)localObject1).putExtra("PhotoConst.SHOW_MAGIC_USE_PASTER", this.a.e);
      ((Intent)localObject1).putExtra("PasterConstants.paster_id", this.a.jdField_a_of_type_JavaLangString);
      ((Intent)localObject1).putExtra("PasterConstants.paster_cate_id", this.a.jdField_b_of_type_JavaLangString);
      akte.sPhotoListFirstPos = ((NewPhotoListActivity)this.mActivity).gridLayoutManager.findFirstVisibleItemPosition();
      localObject3 = this.mPhotoCommonData.selectedMediaInfoHashMap;
      if (!((HashMap)localObject3).containsKey(((LocalMediaInfo)localObject2).path)) {
        ((HashMap)localObject3).put(((LocalMediaInfo)localObject2).path, localObject2);
      }
      ((Intent)localObject1).putExtra("PeakConstants.selectedMediaInfoHashMap", (Serializable)localObject3);
      ((Intent)localObject1).putExtra("PasterConstants.pasters_data", this.a.jdField_b_of_type_JavaUtilHashMap);
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
    ((Intent)localObject2).putExtra("uin", this.a.d);
    ((Intent)localObject2).putExtra("uintype", this.a.jdField_a_of_type_Int);
    ((Intent)localObject2).putExtra("file_source", "album");
    ((Intent)localObject2).putExtra("is_from_system_media", ((LocalMediaInfo)localObject1).isSystemMeidaStore);
    if (this.a.isSupportVideoCheckbox)
    {
      ((Intent)localObject2).putExtra("PhotoConst.IS_SUPPORT_VIDEO_CHECKBOX", true);
      ((Intent)localObject2).putExtra("PhotoConst.PHOTO_PATHS", this.mPhotoCommonData.selectedPhotoList);
    }
    ((NewPhotoListActivity)this.mActivity).startActivityForResult((Intent)localObject2, 17);
  }
  
  public String getExceedMaxSelectNumStr(LocalMediaInfo paramLocalMediaInfo)
  {
    int i = this.mPhotoCommonData.maxSelectNum;
    if (this.mPhotoCommonData.showMediaType == 6) {
      return ((NewPhotoListActivity)this.mActivity).getResources().getString(2131694316, new Object[] { Integer.valueOf(i) });
    }
    if (this.mPhotoCommonData.showMediaType == 2) {
      return ((NewPhotoListActivity)this.mActivity).getResources().getString(2131694320, new Object[] { Integer.valueOf(i) });
    }
    return super.getExceedMaxSelectNumStr(paramLocalMediaInfo);
  }
  
  public void initData(Intent paramIntent)
  {
    super.initData(paramIntent);
  }
  
  public void onTitleBtnCancelClick(View paramView)
  {
    paramView = ((NewPhotoListActivity)this.mActivity).getIntent();
    bhkd.clearSelectItemInfo();
    bhkd.a();
    Object localObject = PresendPicMgr.a();
    if (localObject != null) {
      ((PresendPicMgr)localObject).a(1006);
    }
    int i;
    if (this.mPhotoCommonData.selectedPhotoList != null)
    {
      i = this.mPhotoCommonData.selectedPhotoList.size();
      akrx.b(paramView, i);
      if (this.a.i) {
        break label93;
      }
      ((NewPhotoListActivity)this.mActivity).finish();
      bhkd.anim(this.mActivity, false, false);
    }
    label93:
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
    ((NewPhotoListActivity)this.mActivity).sendBroadcast((Intent)localObject);
    ((NewPhotoListActivity)this.mActivity).finish();
    bhkd.anim(this.mActivity, false, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     akut
 * JD-Core Version:    0.7.0.1
 */