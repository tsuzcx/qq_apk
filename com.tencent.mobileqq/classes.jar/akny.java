import android.content.Intent;
import android.content.res.Resources;
import android.os.Parcelable;
import android.support.v7.widget.GridLayoutManager;
import android.text.TextUtils;
import android.util.Pair;
import android.view.View;
import android.widget.CompoundButton;
import com.tencent.component.media.image.ImageManager;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.activity.photo.PhotoUtils;
import com.tencent.mobileqq.activity.photo.album.AbstractPhotoListActivity.PhotoListAdapter;
import com.tencent.mobileqq.activity.photo.album.NewPhotoListActivity;
import com.tencent.mobileqq.activity.photo.album.NewPhotoPreviewActivity;
import com.tencent.mobileqq.activity.photo.album.PhotoCommonBaseData;
import com.tencent.mobileqq.activity.shortvideo.ShortVideoPreviewActivity;
import com.tencent.mobileqq.pic.PresendPicMgr;
import com.tencent.mobileqq.utils.AlbumUtil;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;

public class akny
  extends akmj
{
  private int jdField_a_of_type_Int;
  private boolean jdField_a_of_type_Boolean;
  
  akny(NewPhotoListActivity paramNewPhotoListActivity)
  {
    super(paramNewPhotoListActivity);
  }
  
  protected void a(Intent paramIntent, boolean paramBoolean, ArrayList<String> paramArrayList)
  {
    PhotoUtils.getTypeforReportSpcialDiscuss(this.jdField_a_of_type_Akmi.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo);
    HashMap localHashMap = new HashMap();
    int i1 = 0;
    int k = 0;
    int j = 0;
    int i = 0;
    while (i1 < paramArrayList.size())
    {
      Object localObject = (String)paramArrayList.get(i1);
      int m;
      if (ImageManager.isNetworkUrl((String)localObject))
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
        m = ((akmq)this.mOtherCommonData).a(this.mPhotoCommonData, (String)localObject);
        localObject = ((akmq)this.mOtherCommonData).a(this.mPhotoCommonData, (String)localObject);
        int n;
        if (m == 1)
        {
          n = j;
          m = i;
          if (localObject != null)
          {
            localHashMap.put(Integer.valueOf(k), localObject);
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
    if (!localHashMap.isEmpty()) {
      paramIntent.putExtra("PhotoConst.VIDEO_INFOS", localHashMap);
    }
    paramIntent.putStringArrayListExtra("PhotoConst.PHOTO_PATHS", paramArrayList);
    paramIntent.putExtra("PhotoConst.CURRENT_QUALITY_TYPE", this.mPhotoCommonData.currentQualityType);
    QLog.d("PhotoListLogicMiniApp", 2, "sendImage:" + j + "  sendVideo:" + i);
    paramIntent.setComponent(null);
    paramIntent.setAction(paramIntent.getStringExtra("PhotoConst.DEST_BROADCAST_ACTION_NAME"));
    paramIntent.setFlags(paramIntent.getFlags() & 0xDFFFFFFF & 0xFBFFFFFF);
    try
    {
      ((NewPhotoListActivity)this.mActivity).sendBroadcast(paramIntent);
      ((NewPhotoListActivity)this.mActivity).finish();
      return;
    }
    catch (Exception paramIntent)
    {
      QLog.d("PhotoListLogicMiniApp", 1, "sendPhoto fail!", paramIntent);
    }
  }
  
  public Intent caseNoSingModeImage(View paramView, int paramInt)
  {
    paramView = super.caseNoSingModeImage(paramView, paramInt);
    paramView.putExtra("PhotoConst.CURRENT_QUALITY_TYPE", this.mPhotoCommonData.currentQualityType);
    paramView.putExtra("from_miniapp_cur_sizetype", this.jdField_a_of_type_Int);
    return paramView;
  }
  
  public void caseVideo(View paramView, int paramInt)
  {
    if (!bhbx.a()) {
      QQToast.a(this.mActivity, ((NewPhotoListActivity)this.mActivity).getResources().getString(2131718340), 0).a();
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
      paramView = bhdj.a(this.mActivity, "请选择不超过" + (float)this.mPhotoCommonData.videoSizeLimit / 1024.0F / 1024.0F / 1024.0F + "G的视频");
      paramView.setPositiveButton(2131694399, new bhdx());
      paramView.show();
      return;
    }
    if (((LocalMediaInfo)localObject1).mDuration > this.mPhotoCommonData.videoDurationLimit)
    {
      paramView = bhdj.a(this.mActivity, "请选择不超过" + this.mPhotoCommonData.videoDurationLimit / 60L / 1000L + "分钟的视频");
      paramView.setPositiveButton(2131694399, new bhdx());
      paramView.show();
      return;
    }
    Object localObject2 = AlbumUtil.sSelectItemAlbum;
    Object localObject3;
    if (!((HashMap)localObject2).containsKey(((LocalMediaInfo)localObject1).path))
    {
      localObject3 = new Pair(this.mPhotoCommonData.albumId, this.mPhotoCommonData.albumName);
      ((HashMap)localObject2).put(((LocalMediaInfo)localObject1).path, localObject3);
    }
    ((NewPhotoListActivity)this.mActivity).recordLastPos(((LocalMediaInfo)localObject1).path);
    if (!this.jdField_a_of_type_Akmi.jdField_b_of_type_Boolean)
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
      PhotoUtils.sendPhoto(this.mActivity, paramView, (ArrayList)localObject2, 2, false);
      return;
    }
    if (!this.jdField_a_of_type_Akmi.isSingleMode)
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
      ((Intent)localObject1).putExtra("PhotoConst.SHOW_MAGIC_USE_PASTER", this.jdField_a_of_type_Akmi.e);
      ((Intent)localObject1).putExtra("PasterConstants.paster_id", this.jdField_a_of_type_Akmi.jdField_a_of_type_JavaLangString);
      ((Intent)localObject1).putExtra("PasterConstants.paster_cate_id", this.jdField_a_of_type_Akmi.jdField_b_of_type_JavaLangString);
      akmi.sPhotoListFirstPos = ((NewPhotoListActivity)this.mActivity).gridLayoutManager.findFirstVisibleItemPosition();
      localObject3 = this.mPhotoCommonData.selectedMediaInfoHashMap;
      if (!((HashMap)localObject3).containsKey(((LocalMediaInfo)localObject2).path)) {
        ((HashMap)localObject3).put(((LocalMediaInfo)localObject2).path, localObject2);
      }
      ((Intent)localObject1).putExtra("PeakConstants.selectedMediaInfoHashMap", (Serializable)localObject3);
      ((Intent)localObject1).putExtra("PasterConstants.pasters_data", this.jdField_a_of_type_Akmi.jdField_b_of_type_JavaUtilHashMap);
      ((Intent)localObject1).setClass(this.mActivity, NewPhotoPreviewActivity.class);
      ((Intent)localObject1).addFlags(603979776);
      if ((this.mPhotoCommonData.selectedPhotoList != null) && (this.mPhotoCommonData.selectedPhotoList.size() > 0)) {
        bdla.b(null, "CliOper", "", this.mPhotoCommonData.myUin, "0X8005674", "0X8005674", 0, this.mPhotoCommonData.selectedPhotoList.size(), 0, "", "", "", "");
      }
      if (((akmq)this.mOtherCommonData).a()) {
        ((NewPhotoListActivity)this.mActivity).startActivityForResult(paramView, 100010);
      }
      for (;;)
      {
        AlbumUtil.anim(this.mActivity, true, true);
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
    ((Intent)localObject2).putExtra("uin", this.jdField_a_of_type_Akmi.d);
    ((Intent)localObject2).putExtra("uintype", this.jdField_a_of_type_Akmi.jdField_a_of_type_Int);
    ((Intent)localObject2).putExtra("file_source", "album");
    ((Intent)localObject2).putExtra("is_from_system_media", ((LocalMediaInfo)localObject1).isSystemMeidaStore);
    if (this.jdField_a_of_type_Akmi.isSupportVideoCheckbox)
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
      return ((NewPhotoListActivity)this.mActivity).getResources().getString(2131694631, new Object[] { Integer.valueOf(i) });
    }
    if (this.mPhotoCommonData.showMediaType == 2) {
      return ((NewPhotoListActivity)this.mActivity).getResources().getString(2131694635, new Object[] { Integer.valueOf(i) });
    }
    return super.getExceedMaxSelectNumStr(paramLocalMediaInfo);
  }
  
  public void initData(Intent paramIntent)
  {
    super.initData(paramIntent);
    this.jdField_a_of_type_Boolean = paramIntent.getBooleanExtra("from_miniapp_enable_bottombar", false);
    this.jdField_a_of_type_Int = paramIntent.getIntExtra("from_miniapp_cur_sizetype", 0);
    this.mPhotoCommonData.videoDurationLimit = paramIntent.getLongExtra("PhotoConst.PHOTOLIST_KEY_FILTER_VIDEO_DURATION_LIMIT", 9223372036854775807L);
    this.mPhotoCommonData.filter.videoMaxDuration = this.mPhotoCommonData.videoDurationLimit;
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if ((paramInt2 != -1) && (paramInt1 == 10001) && (paramIntent != null))
    {
      String str = paramIntent.getStringExtra("PhotoConst.FROM_QQSTORY_SLIDESHOW_DATA");
      if (!TextUtils.isEmpty(str)) {
        FileUtils.deleteDirectory(new File(str).getParent());
      }
      ((NewPhotoListActivity)this.mActivity).setResult(0, paramIntent);
      ((NewPhotoListActivity)this.mActivity).finish();
    }
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
  }
  
  public void onQualityBtnClick(CompoundButton paramCompoundButton, boolean paramBoolean)
  {
    if (paramBoolean)
    {
      this.mPhotoCommonData.currentQualityType = 2;
      return;
    }
    this.mPhotoCommonData.currentQualityType = 0;
  }
  
  public void onTitleBtnCancelClick(View paramView)
  {
    paramView = ((NewPhotoListActivity)this.mActivity).getIntent();
    AlbumUtil.clearSelectItemInfo();
    AlbumUtil.clearCache();
    Object localObject = PresendPicMgr.a();
    if (localObject != null) {
      ((PresendPicMgr)localObject).a(1006);
    }
    int i;
    if (this.mPhotoCommonData.selectedPhotoList != null)
    {
      i = this.mPhotoCommonData.selectedPhotoList.size();
      aklj.b(paramView, i);
      if (this.jdField_a_of_type_Akmi.i) {
        break label93;
      }
      ((NewPhotoListActivity)this.mActivity).finish();
      AlbumUtil.anim(this.mActivity, false, false);
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
    AlbumUtil.anim(this.mActivity, false, false);
  }
  
  public void postInitUI()
  {
    super.postInitUI();
    if (this.jdField_a_of_type_Boolean) {
      ((NewPhotoListActivity)this.mActivity).bottomBar.setVisibility(0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     akny
 * JD-Core Version:    0.7.0.1
 */