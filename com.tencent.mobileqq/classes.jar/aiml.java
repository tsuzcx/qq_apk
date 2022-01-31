import android.app.Dialog;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.util.Pair;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.TextView;
import com.tencent.biz.qqstory.app.QQStoryContext;
import com.tencent.biz.qqstory.database.PublishVideoEntry;
import com.tencent.biz.qqstory.takevideo.slideshow.SlideItemInfo;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.component.media.image.ImageManager;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.activity.photo.MimeHelper;
import com.tencent.mobileqq.activity.photo.PhotoCropActivity;
import com.tencent.mobileqq.activity.photo.PhotoCropForPortraitActivity;
import com.tencent.mobileqq.activity.photo.PhotoUtils;
import com.tencent.mobileqq.activity.photo.album.AbstractPhotoListActivity.PhotoListAdapter;
import com.tencent.mobileqq.activity.photo.album.AbstractPhotoListActivity.PhotoListAdapter.Holder;
import com.tencent.mobileqq.activity.photo.album.NewPhotoListActivity;
import com.tencent.mobileqq.activity.photo.album.NewPhotoPreviewActivity;
import com.tencent.mobileqq.activity.photo.album.PhotoListLogic.IadapterCallback;
import com.tencent.mobileqq.activity.photo.album.PhotoListLogic.IcheckBoxCallback;
import com.tencent.mobileqq.activity.photo.album.PhotoListLogic.IitemClickCallback;
import com.tencent.mobileqq.activity.photo.album.PhotoListLogic.IonSelectionChangeListener;
import com.tencent.mobileqq.activity.photo.album.PhotoListLogicBase;
import com.tencent.mobileqq.activity.photo.album.PhotoListLogicDefault.1;
import com.tencent.mobileqq.activity.photo.album.PhotoListLogicDefault.10;
import com.tencent.mobileqq.activity.photo.album.PhotoListLogicDefault.5;
import com.tencent.mobileqq.activity.photo.album.PhotoListLogicDefault.7;
import com.tencent.mobileqq.activity.photo.album.PhotoListLogicDefault.9;
import com.tencent.mobileqq.activity.shortvideo.SendVideoActivity.SendVideoInfo;
import com.tencent.mobileqq.activity.shortvideo.ShortVideoPreviewActivity;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.pic.PresendPicMgr;
import com.tencent.mobileqq.widget.NumberCheckBox;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.AdapterView;
import com.tencent.widget.GestureSelectGridView;
import cooperation.qzone.util.QZLog;
import dov.com.tencent.biz.qqstory.takevideo.EditPicActivity;
import java.io.File;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import mqq.app.AppRuntime;
import mqq.app.NewIntent;

public class aiml
  extends PhotoListLogicBase<NewPhotoListActivity>
  implements PhotoListLogic.IadapterCallback, PhotoListLogic.IcheckBoxCallback, PhotoListLogic.IitemClickCallback, xix
{
  public aimk a;
  
  public aiml(NewPhotoListActivity paramNewPhotoListActivity)
  {
    super(paramNewPhotoListActivity);
    this.mPhotoListData = new aimk();
    this.a = ((aimk)this.mPhotoListData);
  }
  
  public void a() {}
  
  public void a(int paramInt1, int paramInt2)
  {
    ArrayList localArrayList = this.mPhotoCommonData.selectedPhotoList;
    GestureSelectGridView localGestureSelectGridView = ((NewPhotoListActivity)this.mActivity).mGridView;
    AbstractPhotoListActivity.PhotoListAdapter localPhotoListAdapter = ((NewPhotoListActivity)this.mActivity).photoListAdapter;
    if ((paramInt1 >= 0) && (paramInt1 < localArrayList.size()) && (paramInt2 >= 0) && (paramInt2 < localArrayList.size()))
    {
      Collections.swap(localArrayList, paramInt1, paramInt2);
      paramInt2 = localGestureSelectGridView.getFirstVisiblePosition();
      int i = localGestureSelectGridView.getLastVisiblePosition();
      paramInt1 = paramInt2;
      while (paramInt1 <= i)
      {
        Object localObject = localPhotoListAdapter.getItem(paramInt1);
        int j = localArrayList.indexOf(((LocalMediaInfo)localObject).path);
        if (j >= 0)
        {
          localObject = (AbstractPhotoListActivity.PhotoListAdapter.Holder)localGestureSelectGridView.getChildAt(((LocalMediaInfo)localObject).position.intValue() - paramInt2).getTag();
          if ((localObject != null) && (((AbstractPhotoListActivity.PhotoListAdapter.Holder)localObject).mCheckBox != null)) {
            ((AbstractPhotoListActivity.PhotoListAdapter.Holder)localObject).mCheckBox.setCheckedNumber(j + 1);
          }
        }
        paramInt1 += 1;
      }
      xir.a().b(localArrayList, this.mPhotoCommonData.allMediaInfoHashMap);
    }
    ((NewPhotoListActivity)this.mActivity).selectLimitRemind(true);
  }
  
  public void a(Intent paramIntent)
  {
    if (this.a.l)
    {
      paramIntent.putExtra("ReceiptMsgManager.EXTRA_KEY_IS_RECEIPT", true);
      paramIntent.putExtra("session_info", ((NewPhotoListActivity)this.mActivity).getIntent().getParcelableExtra("session_info"));
    }
  }
  
  protected void a(Intent paramIntent, boolean paramBoolean, ArrayList<String> paramArrayList)
  {
    int i2 = PhotoUtils.b(this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo);
    Object localObject1 = new HashMap();
    int j = 0;
    int i = 0;
    int i1 = 0;
    int k = 0;
    while (i1 < paramArrayList.size())
    {
      localObject2 = (String)paramArrayList.get(i1);
      int m;
      if (ImageManager.isNetworkUrl((String)localObject2))
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
        int n;
        if (((NewPhotoListActivity)this.mActivity).a((String)localObject2) == 1)
        {
          localObject2 = ((NewPhotoListActivity)this.mActivity).a((String)localObject2);
          n = j;
          m = i;
          if (localObject2 != null)
          {
            localObject3 = new SendVideoActivity.SendVideoInfo();
            ((SendVideoActivity.SendVideoInfo)localObject3).fileSize = ((LocalMediaInfo)localObject2).fileSize;
            ((SendVideoActivity.SendVideoInfo)localObject3).duration = ((LocalMediaInfo)localObject2).mDuration;
            ((HashMap)localObject1).put(Integer.valueOf(k), localObject3);
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
    Object localObject2 = String.valueOf(j);
    Object localObject3 = String.valueOf(i);
    if (!((HashMap)localObject1).isEmpty()) {
      paramIntent.putExtra("PhotoConst.VIDEO_INFOS", (Serializable)localObject1);
    }
    for (i = 1;; i = 0)
    {
      if ((ayyu.b != 0L) && (System.currentTimeMillis() - ayyu.b < 300000L)) {}
      for (boolean bool = true;; bool = false)
      {
        if (QLog.isColorLevel()) {
          QLog.d("PhotoListActivity", 2, "upload video isConfirmed=" + bool + " allowUploadInXGTime=" + ayyu.b);
        }
        if ((!bdee.b(BaseApplicationImpl.getContext())) || (bool) || (i == 0)) {
          break;
        }
        localObject1 = ((NewPhotoListActivity)this.mActivity).getResources().getString(2131719738);
        paramIntent = new PhotoListLogicDefault.1(this, paramBoolean, paramIntent, paramArrayList, i2, (String)localObject2, (String)localObject3);
        if (bevd.a(this.mActivity, 4, new aimm(this, paramIntent))) {
          bdcd.a(this.mActivity, 232, null, (String)localObject1, new aimn(this, paramIntent), new aimo(this)).show();
        }
        if (QLog.isColorLevel()) {
          QLog.i("PhotoListActivity", 2, "show shortvideo_mobile_send_confirm dialog");
        }
        return;
      }
      if (paramBoolean) {
        PhotoUtils.a(this.mActivity, paramIntent, paramArrayList, this.a.jdField_a_of_type_JavaUtilHashMap, this.mPhotoCommonData.currentQualityType, false);
      }
      for (;;)
      {
        azmj.b(null, "CliOper", "", "", "0X8009AB0", "0X8009AB0", i2, 0, (String)localObject2, (String)localObject3, "", "");
        return;
        PhotoUtils.a(this.mActivity, paramIntent, paramArrayList, this.mPhotoCommonData.currentQualityType, this.a.jdField_a_of_type_Boolean);
      }
    }
  }
  
  public void a(SlideItemInfo paramSlideItemInfo)
  {
    Object localObject1 = ((NewPhotoListActivity)this.mActivity).photoListAdapter;
    ArrayList localArrayList = this.mPhotoCommonData.selectedPhotoList;
    Object localObject2;
    int i;
    if ((localObject1 != null) && (paramSlideItemInfo != null))
    {
      localObject2 = ((AbstractPhotoListActivity.PhotoListAdapter)localObject1).getPhotoList();
      i = 0;
      if (i >= ((List)localObject2).size()) {
        break label542;
      }
      if (!((LocalMediaInfo)((List)localObject2).get(i)).path.equals(paramSlideItemInfo.jdField_b_of_type_JavaLangString)) {
        break label391;
      }
    }
    for (;;)
    {
      if ((i >= 0) && (i < ((List)localObject2).size()))
      {
        paramSlideItemInfo = ((AbstractPhotoListActivity.PhotoListAdapter)localObject1).getItem(i);
        paramSlideItemInfo.selectStatus = 2;
        localObject1 = paramSlideItemInfo.path;
        localObject2 = MimeHelper.getMimeType(paramSlideItemInfo.mMimeType);
        if ((this.a.isSupportVideoCheckbox) && (localObject2 != null) && ("video".equals(localObject2[0])))
        {
          localObject2 = this.a;
          ((aimk)localObject2).videoSelectedCnt -= 1;
          if (this.a.videoSelectedCnt == 1) {
            this.a.selectedVideoInfo = paramSlideItemInfo;
          }
        }
        if ((!TextUtils.isEmpty(paramSlideItemInfo.mMimeType)) && ("image/gif".equals(paramSlideItemInfo.mMimeType)))
        {
          localObject2 = this.a;
          ((aimk)localObject2).gifSelectedCount -= 1;
        }
        this.mPhotoCommonData.selectedPhotoList.remove(localObject1);
        this.mPhotoCommonData.selectedIndex.remove(paramSlideItemInfo.position);
        if (this.mPhotoCommonData.needMediaInfo) {
          this.mPhotoCommonData.selectedMediaInfoHashMap.remove(localObject1);
        }
        aild.a(((NewPhotoListActivity)this.mActivity).getIntent(), "param_cancelSelNum");
        localObject2 = (HashMap)bdar.sSelectItemPosMap.get(this.mPhotoCommonData.albumId);
        if (localObject2 != null) {
          ((HashMap)localObject2).remove(localObject1);
        }
        localObject2 = bdar.sSelectItemAlbum;
        if (((HashMap)localObject2).containsKey(localObject1)) {
          ((HashMap)localObject2).remove(localObject1);
        }
        if (this.mSelectionListener != null) {
          this.mSelectionListener.onSelectionChange(false, paramSlideItemInfo);
        }
        ((NewPhotoListActivity)this.mActivity).updateCheckbox(i, false);
        updateButton();
        xir.a().b(localArrayList, this.mPhotoCommonData.allMediaInfoHashMap);
      }
      label391:
      while (i != -1)
      {
        return;
        i += 1;
        break;
      }
      localArrayList.remove(paramSlideItemInfo.jdField_b_of_type_JavaLangString);
      if (this.mPhotoCommonData.needMediaInfo) {
        this.mPhotoCommonData.selectedMediaInfoHashMap.remove(paramSlideItemInfo.jdField_b_of_type_JavaLangString);
      }
      aild.a(((NewPhotoListActivity)this.mActivity).getIntent(), "param_cancelSelNum");
      localObject1 = (HashMap)bdar.sSelectItemPosMap.get(this.mPhotoCommonData.albumId);
      if (localObject1 != null) {
        ((HashMap)localObject1).remove(paramSlideItemInfo.jdField_b_of_type_JavaLangString);
      }
      localObject1 = bdar.sSelectItemAlbum;
      if (((HashMap)localObject1).containsKey(paramSlideItemInfo.jdField_b_of_type_JavaLangString)) {
        ((HashMap)localObject1).remove(paramSlideItemInfo.jdField_b_of_type_JavaLangString);
      }
      ((NewPhotoListActivity)this.mActivity).updateCheckboxForDelete();
      updateButton();
      xir.a().b(localArrayList, this.mPhotoCommonData.allMediaInfoHashMap);
      return;
      label542:
      i = -1;
    }
  }
  
  protected void a(LocalMediaInfo paramLocalMediaInfo, int paramInt)
  {
    bdar.a();
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
      localIntent.putExtra("PhotoConst.CURRENT_SELECTED_INDEX", paramLocalMediaInfo.position);
    }
    if (this.a.f)
    {
      paramLocalMediaInfo = bdar.sSelectItemAlbum;
      if (!paramLocalMediaInfo.containsKey(str)) {
        paramLocalMediaInfo.put(str, new Pair(this.mPhotoCommonData.albumId, this.mPhotoCommonData.albumName));
      }
      ((NewPhotoListActivity)this.mActivity).recordLastPos(str);
      PhotoUtils.a(this.mActivity, localIntent, this.mPhotoCommonData.selectedPhotoList, 0, this.a.jdField_a_of_type_Boolean);
      return;
    }
    if (!this.a.g)
    {
      localIntent.putExtra("PhotoConst.ALLOW_LOCK", false);
      localIntent.setClass(this.mActivity, NewPhotoPreviewActivity.class);
      localIntent.putExtra("PasterConstants.pasters_data", this.a.jdField_b_of_type_JavaUtilHashMap);
      localIntent.putExtra("FROM_WHERE", "FROM_PHOTO_LIST");
      localIntent.putExtra("PhotoConst.SOURCE_FROM", "FROM_SELECT_PHOTO");
      localIntent.addFlags(603979776);
      ((NewPhotoListActivity)this.mActivity).startActivity(localIntent);
      ((NewPhotoListActivity)this.mActivity).finish();
      bdar.anim(this.mActivity, true, true);
      return;
    }
    paramInt = localIntent.getIntExtra("Business_Origin", 0);
    if ((100 == paramInt) || (102 == paramInt) || (103 == paramInt)) {
      if (100 == paramInt)
      {
        int i = bcyw.b(this.mActivity);
        localIntent.putExtra("PhotoConst.CLIP_WIDTH", i);
        localIntent.putExtra("PhotoConst.CLIP_HEIGHT", i);
        localIntent.putExtra("PhotoConst.TARGET_WIDTH", 1080);
        localIntent.putExtra("PhotoConst.TARGET_HEIGHT", 1080);
        localIntent.putExtra("PhotoConst.TARGET_SAMPLE_SIZE", 1620);
        label441:
        localIntent.setClass(this.mActivity, PhotoCropForPortraitActivity.class);
        localIntent.putExtra("PhotoConst.EDIT_MASK_SHAPE_TYPE", ailp.c(paramInt));
      }
    }
    for (;;)
    {
      bdar.a(localIntent, this.mPhotoCommonData.albumId, str, this.a.isRecodeLastAlbumPath);
      localIntent.putExtra("PHOTOLIST_START_POSITION", ((NewPhotoListActivity)this.mActivity).mGridView.getFirstVisiblePosition());
      break;
      localIntent.putExtra("PhotoConst.IS_WITH_PENDANT", false);
      localIntent.putExtra("PhotoConst.TARGET_WIDTH", 640);
      localIntent.putExtra("PhotoConst.TARGET_HEIGHT", 640);
      break label441;
      localIntent.setClass(this.mActivity, PhotoCropActivity.class);
    }
  }
  
  public boolean addAndRemovePhotoByGesture(LocalMediaInfo paramLocalMediaInfo, boolean paramBoolean)
  {
    Object localObject1 = this.mPhotoCommonData;
    Object localObject2 = MimeHelper.getMimeType(paramLocalMediaInfo.mMimeType);
    if ((!this.a.isSupportVideoCheckbox) && (localObject2 != null) && (!"image".equals(localObject2[0]))) {}
    long l;
    do
    {
      int i;
      do
      {
        return false;
        i = paramLocalMediaInfo.selectStatus;
      } while (((i == 1) && (paramBoolean)) || ((i == 2) && (!paramBoolean)));
      if ((i != 2) || (!paramBoolean) || (((aimj)localObject1).selectedPhotoList.size() < ((aimj)localObject1).maxSelectNum)) {
        break;
      }
      l = System.currentTimeMillis();
    } while (l - this.a.lastTimeShowToast < 700L);
    QQToast.a(this.mActivity, getExceedMaxSelectNumStr(paramLocalMediaInfo), 1000).b(((NewPhotoListActivity)this.mActivity).mTitleBarHeight);
    this.a.lastTimeShowToast = l;
    this.a.hasShownMaxSelectToast = true;
    e();
    return false;
    this.a.hasShownMaxSelectToast = false;
    String str = paramLocalMediaInfo.path;
    if (paramBoolean)
    {
      if ((this.a.isSupportVideoCheckbox) && (localObject2 != null) && ("video".equals(localObject2[0])))
      {
        localObject2 = this.a;
        ((aimk)localObject2).videoSelectedCnt += 1;
        if (this.a.videoSelectedCnt == 1) {
          this.a.selectedVideoInfo = paramLocalMediaInfo;
        }
      }
      if ((!TextUtils.isEmpty(paramLocalMediaInfo.mMimeType)) && ("image/gif".equals(paramLocalMediaInfo.mMimeType)))
      {
        localObject2 = this.a;
        ((aimk)localObject2).gifSelectedCount += 1;
      }
      ((aimj)localObject1).selectedPhotoList.add(str);
      ((aimj)localObject1).selectedIndex.add(paramLocalMediaInfo.position);
      if (this.mPhotoCommonData.needMediaInfo) {
        ((aimj)localObject1).selectedMediaInfoHashMap.put(str, paramLocalMediaInfo);
      }
      if (this.a.cancelPresendPathSet.contains(str)) {
        this.a.cancelPresendPathSet.remove(str);
      }
      this.a.presendPathSet.add(str);
      aild.a(((NewPhotoListActivity)this.mActivity).getIntent(), "param_totalSelNum");
      localObject1 = ((NewPhotoListActivity)this.mActivity).getIntent();
      if (!((Intent)localObject1).hasExtra("param_initTime")) {
        ((Intent)localObject1).putExtra("param_initTime", System.currentTimeMillis());
      }
      paramLocalMediaInfo.selectStatus = 1;
      paramLocalMediaInfo = (LinkedHashMap)bdar.sSelectItemPosMap.get(this.mPhotoCommonData.albumId);
      if (paramLocalMediaInfo != null) {
        break label843;
      }
      paramLocalMediaInfo = new LinkedHashMap();
      bdar.sSelectItemPosMap.put(this.mPhotoCommonData.albumId, paramLocalMediaInfo);
    }
    label843:
    for (;;)
    {
      paramLocalMediaInfo.put(str, Integer.valueOf(((NewPhotoListActivity)this.mActivity).mGridView.getFirstVisiblePosition()));
      paramLocalMediaInfo = bdar.sSelectItemAlbum;
      if (!paramLocalMediaInfo.containsKey(str)) {
        paramLocalMediaInfo.put(str, new Pair(this.mPhotoCommonData.albumId, this.mPhotoCommonData.albumName));
      }
      paramLocalMediaInfo = (NewPhotoListActivity)this.mActivity;
      if (!paramBoolean) {}
      for (paramBoolean = true;; paramBoolean = false)
      {
        paramLocalMediaInfo.selectLimitRemind(paramBoolean);
        return true;
        if ((this.a.isSupportVideoCheckbox) && (localObject2 != null) && ("video".equals(localObject2[0])))
        {
          localObject2 = this.a;
          ((aimk)localObject2).videoSelectedCnt -= 1;
          if (this.a.videoSelectedCnt == 1) {
            this.a.selectedVideoInfo = paramLocalMediaInfo;
          }
        }
        if ((!TextUtils.isEmpty(paramLocalMediaInfo.mMimeType)) && ("image/gif".equals(paramLocalMediaInfo.mMimeType)))
        {
          localObject2 = this.a;
          ((aimk)localObject2).gifSelectedCount -= 1;
        }
        ((aimj)localObject1).selectedPhotoList.remove(paramLocalMediaInfo.path);
        ((aimj)localObject1).selectedIndex.remove(paramLocalMediaInfo.position);
        if (this.mPhotoCommonData.needMediaInfo) {
          ((aimj)localObject1).selectedMediaInfoHashMap.remove(str);
        }
        if (this.a.presendPathSet.contains(paramLocalMediaInfo.path)) {
          this.a.presendPathSet.remove(paramLocalMediaInfo.path);
        }
        for (;;)
        {
          paramLocalMediaInfo.selectStatus = 2;
          aild.a(((NewPhotoListActivity)this.mActivity).getIntent(), "param_cancelSelNum");
          paramLocalMediaInfo = (HashMap)bdar.sSelectItemPosMap.get(this.mPhotoCommonData.albumId);
          if (paramLocalMediaInfo != null) {
            paramLocalMediaInfo.remove(str);
          }
          paramLocalMediaInfo = bdar.sSelectItemAlbum;
          if (!paramLocalMediaInfo.containsKey(str)) {
            break;
          }
          paramLocalMediaInfo.remove(str);
          break;
          this.a.cancelPresendPathSet.add(paramLocalMediaInfo.path);
        }
      }
    }
  }
  
  protected void b()
  {
    if (this.mPhotoCommonData.albumId.equals("$RecentAlbumId")) {
      azmz.a(this.mActivity).a(null, "sendAlbumRecent", true, 0L, 0L, null, "");
    }
    PresendPicMgr localPresendPicMgr;
    for (;;)
    {
      localPresendPicMgr = PresendPicMgr.a();
      if ((!this.a.e) || ((TextUtils.isEmpty(this.a.jdField_a_of_type_JavaLangString)) && (TextUtils.isEmpty(this.a.jdField_b_of_type_JavaLangString)))) {
        break;
      }
      ((NewPhotoListActivity)this.mActivity).jdField_a_of_type_AndroidWidgetButton.performClick();
      return;
      if ((this.mPhotoCommonData.albumName.equalsIgnoreCase("Camera")) || (this.mPhotoCommonData.albumName.equalsIgnoreCase("camera")) || (this.mPhotoCommonData.albumName.contains("Camera")) || (this.mPhotoCommonData.albumName.contains("camera"))) {
        azmz.a(this.mActivity).a(null, "sendAlbumRecent", false, 0L, 0L, null, "");
      } else {
        azmz.a(this.mActivity).a(null, "sendAlbumOther", true, 0L, 0L, null, "");
      }
    }
    if (this.mPhotoCommonData.selectedPhotoList != null)
    {
      aild.a(((NewPhotoListActivity)this.mActivity).getIntent(), this.mPhotoCommonData.selectedPhotoList.size());
      aild.a(((NewPhotoListActivity)this.mActivity).getIntent(), this.mPhotoCommonData.selectedPhotoList.size(), this.mPhotoCommonData.currentQualityType);
    }
    Intent localIntent = ((NewPhotoListActivity)this.mActivity).getIntent();
    if (this.mPhotoCommonData.currentQualityType == 2)
    {
      if (localPresendPicMgr != null)
      {
        localPresendPicMgr.a(1008);
        localPresendPicMgr.a();
      }
      azmj.b(null, "CliOper", "", "", "0X8005148", "0X8005148", 0, 0, "", "", "", "");
    }
    for (;;)
    {
      localIntent.getStringExtra("PhotoConst.PLUGIN_APK");
      localIntent.getStringExtra("PhotoConst.INIT_ACTIVITY_CLASS_NAME");
      if (this.mPhotoCommonData.needMediaInfo) {
        localIntent.putExtra("PeakConstants.selectedMediaInfoHashMap", this.mPhotoCommonData.selectedMediaInfoHashMap);
      }
      if (this.mPhotoCommonData.selectedPhotoList != null) {
        ajnh.a(this.mPhotoCommonData.selectedPhotoList);
      }
      a(localIntent);
      a(localIntent, false, this.mPhotoCommonData.selectedPhotoList);
      return;
      if ((localPresendPicMgr != null) && (!this.a.l) && (!localIntent.getBooleanExtra("PhotoConst.SEND_NO_PRESEND", false))) {
        localPresendPicMgr.a(localIntent);
      }
    }
  }
  
  protected void c()
  {
    PhotoUtils.a(this.mActivity, ((NewPhotoListActivity)this.mActivity).getIntent(), this.mPhotoCommonData.selectedPhotoList, this.mPhotoCommonData.currentQualityType, this.a.jdField_a_of_type_Boolean);
  }
  
  public void c_(String paramString)
  {
    Intent localIntent = ((NewPhotoListActivity)this.mActivity).getIntent();
    ArrayList localArrayList = this.mPhotoCommonData.selectedPhotoList;
    HashMap localHashMap = this.mPhotoCommonData.selectedMediaInfoHashMap;
    localIntent.putExtra("ALBUM_NAME", this.mPhotoCommonData.albumName);
    localIntent.putExtra("ALBUM_ID", this.mPhotoCommonData.albumId);
    localIntent.putStringArrayListExtra("PhotoConst.PHOTO_PATHS", localArrayList);
    localIntent.putStringArrayListExtra("PhotoConst.SELECTED_PATHS", localArrayList);
    int j = localArrayList.size();
    Object localObject = new ArrayList(j);
    int i = 0;
    while (i < j)
    {
      ((ArrayList)localObject).add(Integer.valueOf(i));
      i += 1;
    }
    localIntent.putIntegerArrayListExtra("PhotoConst.SELECTED_INDEXS", (ArrayList)localObject);
    i = localArrayList.indexOf(paramString);
    if ((i > 0) && (i < ((NewPhotoListActivity)this.mActivity).photoListAdapter.getCount()))
    {
      localObject = ((NewPhotoListActivity)this.mActivity).photoListAdapter.getItem(i);
      if ((localObject != null) && (!localHashMap.containsKey(((LocalMediaInfo)localObject).path))) {
        localHashMap.put(((LocalMediaInfo)localObject).path, localObject);
      }
    }
    localIntent.putExtra("PeakConstants.selectedMediaInfoHashMap", localHashMap);
    localIntent.putExtra("PhotoConst.SHOW_ALBUM", false);
    localIntent.putExtra("FROM_WHERE", "FROM_PHOTO_LIST");
    aimk.sPhotoListFirstPos = ((NewPhotoListActivity)this.mActivity).mGridView.getFirstVisiblePosition();
    localIntent.putExtra("PhotoConst.CURRENT_SELECTED_INDEX", localArrayList.indexOf(paramString));
    localIntent.setClass(this.mActivity, NewPhotoPreviewActivity.class);
    localIntent.addFlags(603979776);
    startPhotoPreviewActivity(localIntent);
    bdar.anim(this.mActivity, true, true);
  }
  
  public void caseCamera(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    if (!bdal.a())
    {
      QQToast.a(this.mActivity, ((NewPhotoListActivity)this.mActivity).getResources().getString(2131719535), 0).a();
      return;
    }
    ((NewPhotoListActivity)this.mActivity).a();
  }
  
  public Intent caseNoSingModeImage(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    paramAdapterView = super.caseNoSingModeImage(paramAdapterView, paramView, paramInt, paramLong);
    paramAdapterView.putExtra("PhotoConst.MY_UIN", this.mPhotoCommonData.myUin);
    paramAdapterView.putExtra("PhotoConst.CURRENT_QUALITY_TYPE", this.mPhotoCommonData.currentQualityType);
    paramAdapterView.putExtra("PhotoConst.SHOW_MAGIC_USE_PASTER", this.a.e);
    paramAdapterView.putExtra("PhotoConst.editPathMap", aikk.a(this.a.jdField_c_of_type_JavaUtilHashMap));
    paramAdapterView.putExtra("p_e_s_type", 6);
    paramAdapterView.putExtra("PasterConstants.paster_id", this.a.jdField_a_of_type_JavaLangString);
    paramAdapterView.putExtra("PasterConstants.paster_cate_id", this.a.jdField_b_of_type_JavaLangString);
    paramAdapterView.putExtra("PasterConstants.pasters_data", this.a.jdField_b_of_type_JavaUtilHashMap);
    if ((this.mPhotoCommonData.selectedPhotoList != null) && (this.mPhotoCommonData.selectedPhotoList.size() > 0)) {
      azmj.b(null, "CliOper", "", this.mPhotoCommonData.myUin, "0X8005674", "0X8005674", 0, this.mPhotoCommonData.selectedPhotoList.size(), 0, "", "", "", "");
    }
    return paramAdapterView;
  }
  
  public void caseSingleModeImage(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    a(((NewPhotoListActivity)this.mActivity).photoListAdapter.getItem(paramInt), paramInt);
  }
  
  public void caseVideo(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    if (!bdal.a()) {
      QQToast.a(this.mActivity, ((NewPhotoListActivity)this.mActivity).getResources().getString(2131719535), 0).a();
    }
    do
    {
      return;
      paramView = ((NewPhotoListActivity)this.mActivity).photoListAdapter.getItem(paramInt);
    } while (paramView == null);
    paramAdapterView = ((NewPhotoListActivity)this.mActivity).getIntent();
    if (paramView.fileSize > this.mPhotoCommonData.videoSizeLimit)
    {
      paramAdapterView = bdcd.a(this.mActivity, "你选择的视频文件过大，无法发送。");
      paramAdapterView.setPositiveButton(2131694951, new bdco());
      paramAdapterView.show();
      return;
    }
    Object localObject1 = bdar.sSelectItemAlbum;
    Object localObject2;
    if (!((HashMap)localObject1).containsKey(paramView.path))
    {
      localObject2 = new Pair(this.mPhotoCommonData.albumId, this.mPhotoCommonData.albumName);
      ((HashMap)localObject1).put(paramView.path, localObject2);
    }
    ((NewPhotoListActivity)this.mActivity).recordLastPos(paramView.path);
    if (!this.a.jdField_b_of_type_Boolean)
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
      PhotoUtils.a(this.mActivity, paramAdapterView, (ArrayList)localObject1, 2, false);
      return;
    }
    if (!this.a.isSingleMode)
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
      paramView.putExtra("PhotoConst.SHOW_MAGIC_USE_PASTER", this.a.e);
      paramView.putExtra("PasterConstants.paster_id", this.a.jdField_a_of_type_JavaLangString);
      paramView.putExtra("PasterConstants.paster_cate_id", this.a.jdField_b_of_type_JavaLangString);
      aimk.sPhotoListFirstPos = ((NewPhotoListActivity)this.mActivity).mGridView.getFirstVisiblePosition();
      localObject2 = this.mPhotoCommonData.selectedMediaInfoHashMap;
      if (!((HashMap)localObject2).containsKey(((LocalMediaInfo)localObject1).path)) {
        ((HashMap)localObject2).put(((LocalMediaInfo)localObject1).path, localObject1);
      }
      paramView.putExtra("PeakConstants.selectedMediaInfoHashMap", (Serializable)localObject2);
      paramView.putExtra("PasterConstants.pasters_data", this.a.jdField_b_of_type_JavaUtilHashMap);
      paramView.setClass(this.mActivity, NewPhotoPreviewActivity.class);
      paramView.addFlags(603979776);
      if ((this.mPhotoCommonData.selectedPhotoList != null) && (this.mPhotoCommonData.selectedPhotoList.size() > 0)) {
        azmj.b(null, "CliOper", "", this.mPhotoCommonData.myUin, "0X8005674", "0X8005674", 0, this.mPhotoCommonData.selectedPhotoList.size(), 0, "", "", "", "");
      }
      if (this.mPhotoCommonData.a()) {
        ((NewPhotoListActivity)this.mActivity).startActivityForResult(paramAdapterView, 100010);
      }
      for (;;)
      {
        bdar.anim(this.mActivity, true, true);
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
    ((Intent)localObject1).putExtra("uin", this.a.jdField_d_of_type_JavaLangString);
    ((Intent)localObject1).putExtra("uintype", this.a.jdField_a_of_type_Int);
    ((Intent)localObject1).putExtra("file_source", "album");
    ((Intent)localObject1).putExtra("is_from_system_media", paramView.isSystemMeidaStore);
    if (this.a.isSupportVideoCheckbox)
    {
      ((Intent)localObject1).putExtra("PhotoConst.IS_SUPPORT_VIDEO_CHECKBOX", true);
      ((Intent)localObject1).putExtra("PhotoConst.PHOTO_PATHS", this.mPhotoCommonData.selectedPhotoList);
    }
    ((NewPhotoListActivity)this.mActivity).startActivityForResult((Intent)localObject1, 17);
  }
  
  public void d()
  {
    aimj localaimj = this.mPhotoCommonData;
    switch (localaimj.currentQualityType)
    {
    case 1: 
    default: 
      return;
    case 0: 
      ((NewPhotoListActivity)this.mActivity).jdField_a_of_type_AndroidWidgetCheckBox.setChecked(false);
      return;
    }
    bdar.a(((NewPhotoListActivity)this.mActivity).b, localaimj.selectedPhotoList, localaimj.allMediaInfoHashMap, this.a.k, this.mActivity, this.a.jdField_a_of_type_JavaUtilHashMap, localaimj.selectedMediaInfoHashMap);
    ((NewPhotoListActivity)this.mActivity).jdField_a_of_type_AndroidWidgetCheckBox.setChecked(true);
  }
  
  public void doOnDestroy()
  {
    if (this.mPhotoCommonData.isShowQzoneAlbum) {
      BaseApplicationImpl.getApplication().getRuntime().unRegistObserver(NewPhotoListActivity.jdField_a_of_type_Aimg);
    }
    if (this.mPhotoCommonData.a()) {
      xir.a().f();
    }
    super.doOnDestroy();
  }
  
  public void doOnResume()
  {
    super.doOnResume();
    aobd.a(BaseApplicationImpl.getContext(), 2, false);
    if (this.a.requestCode == 100016) {
      if (!((NewPhotoListActivity)this.mActivity).getIntent().getBooleanExtra("FROM_QZONR_NO_FINISH", false)) {
        ((NewPhotoListActivity)this.mActivity).finish();
      }
    }
    do
    {
      return;
      ((NewPhotoListActivity)this.mActivity).getIntent().removeExtra("FROM_QZONR_NO_FINISH");
      this.a.requestCode = 0;
      if (((NewPhotoListActivity)this.mActivity).jdField_a_of_type_AndroidWidgetButton != null) {
        ((NewPhotoListActivity)this.mActivity).jdField_a_of_type_AndroidWidgetButton.setClickable(true);
      }
    } while (!this.mPhotoCommonData.a());
    xir.a().c();
    xir.a().a(this.a.jdField_a_of_type_Xiv);
  }
  
  public void e()
  {
    if (this.a.l) {
      azmj.b(null, "CliOper", "", "", "0x80083EC", "0x80083EC", 0, 0, "", "", "", "");
    }
  }
  
  public void enterAlbumListFragment(Intent paramIntent)
  {
    super.enterAlbumListFragment(paramIntent);
    paramIntent.putExtra("PhotoConst.CURRENT_QUALITY_TYPE", this.mPhotoCommonData.currentQualityType);
    paramIntent.putExtra("PhotoConst.IS_SHOW_QZONE_ALBUM", this.mPhotoCommonData.isShowQzoneAlbum);
    paramIntent.putExtra("PhotoConst.PHOTO_INFOS", this.mPhotoCommonData.jdField_a_of_type_JavaUtilHashMap);
    paramIntent.putExtra("peak.myUin", this.mPhotoCommonData.myUin);
  }
  
  public void enterPhotoPreviewActivity(boolean paramBoolean, Intent paramIntent)
  {
    bdar.a();
    paramIntent.putExtra("PhotoConst.SHOW_ALBUM", false);
    ArrayList localArrayList = this.mPhotoCommonData.selectedPhotoList;
    if (!paramBoolean)
    {
      paramIntent.putStringArrayListExtra("PhotoConst.PHOTO_PATHS", localArrayList);
      if ((localArrayList != null) && (localArrayList.size() > 0)) {
        azmj.b(null, "CliOper", "", this.mPhotoCommonData.myUin, "0X8004072", "0X8004072", 0, localArrayList.size(), 0, "", "", "", "");
      }
      if ((this.mPhotoCommonData.jdField_a_of_type_JavaUtilHashMap == null) || (this.mPhotoCommonData.jdField_a_of_type_JavaUtilHashMap.size() <= 0)) {
        break label346;
      }
      paramIntent.putExtra("PhotoConst.PHOTO_INFOS", this.mPhotoCommonData.jdField_a_of_type_JavaUtilHashMap);
      paramIntent.putExtra("PhotoConst.PHOTO_PATHS_FROM_QZONEALBUM", paramIntent.getSerializableExtra("PhotoConst.PHOTO_PATHS_FROM_QZONEALBUM"));
      paramIntent.putExtra("PhotoConst.CURRENT_SELECTED_INDEX", 0);
      paramIntent.putExtra("PhotoConst.USE_URL_PATH", true);
      paramIntent.putExtra("PhotoConst.QZONE_ALBUM_FROM_AIO", paramIntent.getBooleanExtra("PhotoConst.QZONE_ALBUM_FROM_AIO", false));
    }
    for (;;)
    {
      if (this.mPhotoCommonData.needMediaInfo)
      {
        paramIntent.putExtra("PeakConstants.selectedMediaInfoHashMap", this.mPhotoCommonData.selectedMediaInfoHashMap);
        paramIntent.putExtra("PhotoConst.CURRENT_SELECTED_INDEX", 0);
      }
      paramIntent.putExtra("ALBUM_NAME", this.mPhotoCommonData.albumName);
      paramIntent.putExtra("ALBUM_ID", this.mPhotoCommonData.albumId);
      paramIntent.putExtra("FROM_WHERE", "FROM_PHOTO_LIST");
      paramIntent.putExtra("PhotoConst.CURRENT_QUALITY_TYPE", this.mPhotoCommonData.currentQualityType);
      paramIntent.putExtra("PasterConstants.pasters_data", this.a.jdField_b_of_type_JavaUtilHashMap);
      aimk.sPhotoListFirstPos = ((NewPhotoListActivity)this.mActivity).mGridView.getFirstVisiblePosition();
      paramIntent.setClass(this.mActivity, NewPhotoPreviewActivity.class);
      paramIntent.addFlags(603979776);
      startPhotoPreviewActivity(paramIntent);
      bdar.anim(this.mActivity, true, true);
      return;
      paramIntent.putExtra("PhotoConst.SINGLE_PHOTO_PATH", this.a.currentPhotoPath);
      break;
      label346:
      paramIntent.putExtra("PhotoConst.USE_URL_PATH", false);
    }
  }
  
  void f()
  {
    Object localObject = xir.a().a();
    if (this.a.m) {
      xir.a().b((List)localObject);
    }
    localObject = ((List)localObject).iterator();
    while (((Iterator)localObject).hasNext())
    {
      SlideItemInfo localSlideItemInfo = (SlideItemInfo)((Iterator)localObject).next();
      if (localSlideItemInfo != null)
      {
        if (!this.mPhotoCommonData.selectedPhotoList.contains(localSlideItemInfo.jdField_b_of_type_JavaLangString)) {
          this.mPhotoCommonData.selectedPhotoList.add(localSlideItemInfo.jdField_b_of_type_JavaLangString);
        }
        if (!this.mPhotoCommonData.selectedIndex.contains(localSlideItemInfo.a.position)) {
          this.mPhotoCommonData.selectedIndex.add(localSlideItemInfo.a.position);
        }
        this.mPhotoCommonData.selectedMediaInfoHashMap.put(localSlideItemInfo.jdField_b_of_type_JavaLangString, localSlideItemInfo.a);
      }
    }
    if (this.mPhotoCommonData.selectedPhotoList.size() > 0) {
      xir.a().a(this.mPhotoCommonData.selectedPhotoList, this.mPhotoCommonData.allMediaInfoHashMap, false);
    }
  }
  
  public String getExceedMaxSelectNumStr(LocalMediaInfo paramLocalMediaInfo)
  {
    int i = this.mPhotoCommonData.maxSelectNum;
    String str2 = super.getExceedMaxSelectNumStr(paramLocalMediaInfo);
    String str1 = str2;
    if (paramLocalMediaInfo != null)
    {
      paramLocalMediaInfo = MimeHelper.getMimeType(paramLocalMediaInfo.mMimeType);
      if ((!this.mPhotoCommonData.a()) || (this.a.isSupportVideoCheckbox)) {
        break label80;
      }
      str1 = ((NewPhotoListActivity)this.mActivity).getResources().getString(2131695259, new Object[] { Integer.valueOf(i) });
    }
    label80:
    do
    {
      do
      {
        do
        {
          return str1;
          str1 = str2;
        } while (!this.a.isSupportVideoCheckbox);
        str1 = str2;
      } while (paramLocalMediaInfo == null);
      str1 = str2;
    } while (!"video".equals(paramLocalMediaInfo[0]));
    if (this.mPhotoCommonData.a()) {
      return ((NewPhotoListActivity)this.mActivity).getResources().getString(2131695260, new Object[] { Integer.valueOf(i) });
    }
    return ((NewPhotoListActivity)this.mActivity).getResources().getString(2131695258, new Object[] { Integer.valueOf(i) });
  }
  
  public List<LocalMediaInfo> getLocalMediaInfos()
  {
    int i = -1;
    if (this.mPhotoCommonData.albumId.equals("$RecentAlbumId")) {
      i = 100;
    }
    Object localObject1;
    if (this.mPhotoCommonData.a()) {
      if ((!TextUtils.isEmpty(this.mPhotoCommonData.albumId)) && (this.mPhotoCommonData.albumId.equals("$CustomAlbumId")))
      {
        localObject1 = new ArrayList();
        ((List)localObject1).addAll(xir.a().b());
        bddw.a("PEAK", "getAlbumMedias");
        if (localObject1 != null) {
          break label202;
        }
        if (QLog.isColorLevel()) {
          QLog.d("SelectPhotoTrace", 2, "photoList is null");
        }
        localObject2 = null;
      }
    }
    label202:
    do
    {
      do
      {
        do
        {
          return localObject2;
          localObject1 = bdar.getAlbumMedias(this.mActivity, this.mPhotoCommonData.albumId, this.mPhotoCommonData.albumName, i, this.a.filter, 0, 0, true, null, false, this.a.filterVideoDurationLimit, 1);
          break;
          localObject1 = bdar.getAlbumMedias(this.mActivity, this.mPhotoCommonData.albumId, this.mPhotoCommonData.albumName, i, this.a.filter, this.a.filterVideoDurationLimit);
          break;
          localObject2 = localObject1;
        } while (this.mPhotoCommonData.selectedPhotoList == null);
        localObject2 = localObject1;
      } while (this.mPhotoCommonData.selectedPhotoList.size() == 0);
      i = 0;
      localObject2 = localObject1;
    } while (i >= this.mPhotoCommonData.selectedPhotoList.size());
    Object localObject2 = (String)this.mPhotoCommonData.selectedPhotoList.get(i);
    int j;
    if (TextUtils.isEmpty((CharSequence)localObject2))
    {
      QZLog.e("PhotoListActivity:QueryPhotoTask", "doInBackground: filter photo error, tempPath null");
      j = i;
    }
    for (;;)
    {
      i = j + 1;
      break;
      j = i;
      if (!new File((String)localObject2).exists()) {
        if ((((String)localObject2).startsWith("http")) && (this.mPhotoCommonData.jdField_a_of_type_JavaUtilHashMap != null))
        {
          j = i;
          if (this.mPhotoCommonData.jdField_a_of_type_JavaUtilHashMap.containsKey(localObject2)) {}
        }
        else
        {
          this.mPhotoCommonData.selectedPhotoList.remove(i);
          i -= 1;
          j = i;
          if (this.mPhotoCommonData.needMediaInfo)
          {
            j = i;
            if (this.mPhotoCommonData.selectedMediaInfoHashMap != null)
            {
              j = i;
              if (this.mPhotoCommonData.selectedMediaInfoHashMap.containsKey(localObject2))
              {
                this.mPhotoCommonData.selectedMediaInfoHashMap.remove(localObject2);
                j = i;
              }
            }
          }
        }
      }
    }
  }
  
  public View getViewCaseCamera(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    return super.getViewCaseCamera(paramInt, paramView, paramViewGroup);
  }
  
  public void handlePicCapture(Intent paramIntent)
  {
    super.handlePicCapture(paramIntent);
    paramIntent = paramIntent.getStringArrayListExtra("PhotoConst.PHOTO_PATHS");
    if ((paramIntent != null) && (paramIntent.size() > 0) && (!TextUtils.isEmpty((CharSequence)paramIntent.get(0)))) {
      ThreadManager.postImmediately(new PhotoListLogicDefault.7(this, (String)paramIntent.get(0)), null, true);
    }
  }
  
  public void handleVideoCapture(Intent paramIntent)
  {
    super.handleVideoCapture(paramIntent);
    ((NewPhotoListActivity)this.mActivity).showProgressDialog();
    long l = System.currentTimeMillis();
    Object localObject = paramIntent.getStringExtra("video_new_fake_vid");
    paramIntent = paramIntent.getStringExtra("file_video_source_dir");
    uku localuku = new uku();
    localuku.a(true);
    localObject = uku.a((String)localObject);
    String str = ajyb.a(((PublishVideoEntry)localObject).mLocalRawVideoDir);
    if (TextUtils.isEmpty(str))
    {
      QZLog.i("PhotoListActivity", 1, "get target path fail");
      return;
    }
    localuku.a((PublishVideoEntry)localObject, str, false, true, new aimq(this, l, str, (PublishVideoEntry)localObject, paramIntent));
  }
  
  public void handleVideoEncodeSucceed(Message paramMessage)
  {
    super.handleVideoEncodeSucceed(paramMessage);
    ((NewPhotoListActivity)this.mActivity).cancleProgressDailog();
    ArrayList localArrayList = this.mPhotoCommonData.selectedPhotoList;
    String str;
    if ((paramMessage.obj instanceof String))
    {
      str = (String)paramMessage.obj;
      QZLog.d("PhotoListActivity", 2, new Object[] { "onEncodeSuccess = ", str });
      paramMessage = localArrayList;
      if (localArrayList == null) {
        paramMessage = new ArrayList();
      }
      if (paramMessage.size() < aimj.getInstance().maxSelectNum) {
        break label147;
      }
      QQToast.a(this.mActivity, String.format(((NewPhotoListActivity)this.mActivity).getResources().getString(2131695258), new Object[] { Integer.valueOf(aimj.getInstance().maxSelectNum) }), 0).a();
    }
    for (;;)
    {
      ((NewPhotoListActivity)this.mActivity).a(str);
      return;
      label147:
      aimj.getInstance().selectedPhotoList.add(str);
      ((NewPhotoListActivity)this.mActivity).b();
    }
  }
  
  public void initData(Intent paramIntent)
  {
    if (QLog.isColorLevel()) {
      QLog.d("SelectPhotoTrace", 2, "PhotoListActivity initData(),intent extras is:" + paramIntent.getExtras());
    }
    super.initData(paramIntent);
    this.a.m = paramIntent.getBooleanExtra("PhotoConst.IS_FROM_EDIT", false);
    aikk.a(this.mActivity, paramIntent, false, this.a.jdField_c_of_type_JavaUtilHashMap);
    this.a.jdField_a_of_type_JavaUtilHashMap = ((HashMap)paramIntent.getSerializableExtra("PhotoConst.PHOTO_PATHS_FROM_QZONEALBUM"));
    if (this.a.jdField_a_of_type_JavaUtilHashMap == null) {
      this.a.jdField_a_of_type_JavaUtilHashMap = new HashMap(1);
    }
    this.mPhotoCommonData.isShowQzoneAlbum = paramIntent.getBooleanExtra("PhotoConst.IS_SHOW_QZONE_ALBUM", false);
    this.mPhotoCommonData.jdField_a_of_type_JavaUtilHashMap = ((HashMap)paramIntent.getSerializableExtra("PhotoConst.PHOTO_INFOS"));
    this.a.jdField_c_of_type_Boolean = paramIntent.getBooleanExtra("PhotoConst.original_button", false);
    this.a.jdField_d_of_type_Boolean = paramIntent.getBooleanExtra("PhotoConst.quality_count_tv", true);
    this.mPhotoCommonData.myUin = paramIntent.getStringExtra("PhotoConst.MY_UIN");
    this.a.jdField_a_of_type_Boolean = paramIntent.getBooleanExtra("PhotoConst.HANDLE_DEST_RESULT", false);
    this.a.f = paramIntent.getBooleanExtra("PhotoConst.IS_SINGLE_DERECTBACK_MODE", false);
    this.a.g = paramIntent.getBooleanExtra("PhotoConst.IS_SINGLE_NEED_EDIT", false);
    this.a.h = paramIntent.getBooleanExtra("PhotoConst.IS_CALL_IN_PLUGIN", false);
    this.a.jdField_a_of_type_Int = paramIntent.getIntExtra("uintype", -1);
    this.mPhotoCommonData.currentQualityType = paramIntent.getIntExtra("PhotoConst.CURRENT_QUALITY_TYPE", 0);
    if (paramIntent.getBooleanExtra("PhotoConst.ALWAYS_SHOW_NUMBER_WHEN_ONLY_ONE_IMAGE", false)) {
      this.a.isSingleMode = false;
    }
    this.a.i = paramIntent.getBooleanExtra("PhotoConst.IS_FINISH_RESTART_INIT_ACTIVITY", false);
    this.a.j = paramIntent.getBooleanExtra("PhotoConst.SEND_FLAG", false);
    this.a.jdField_c_of_type_JavaLangString = paramIntent.getStringExtra("uinname");
    this.a.jdField_d_of_type_JavaLangString = paramIntent.getStringExtra("uin");
    this.mPhotoCommonData.videoSizeLimit = paramIntent.getLongExtra("PhotoConst.PHOTOLIST_KEY_VIDEO_SIZE", 1048576000L);
    this.a.jdField_b_of_type_Boolean = paramIntent.getBooleanExtra("PhotoConst.IS_PREVIEW_VIDEO", true);
    this.mPhotoCommonData.videoDurationLimit = paramIntent.getLongExtra("PhotoConst.PHOTOLIST_KEY_VIDEO_DURATION", 9223372036854775807L);
    try
    {
      this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo = ((SessionInfo)paramIntent.getParcelableExtra("session_info"));
      if (this.a.j)
      {
        paramIntent.removeExtra("PhotoConst.SEND_FLAG");
        PresendPicMgr localPresendPicMgr = PresendPicMgr.a();
        if (localPresendPicMgr != null)
        {
          if (QLog.isColorLevel()) {
            QLog.d("PhotoListActivity", 2, "Photo+ send pic,cancel presend!");
          }
          localPresendPicMgr.a(1004);
        }
        PhotoUtils.a(this.mActivity, paramIntent, this.mPhotoCommonData.selectedPhotoList, this.mPhotoCommonData.currentQualityType, true);
      }
      if (!this.a.e) {
        this.a.e = paramIntent.getBooleanExtra("PhotoConst.SHOW_MAGIC_USE_PASTER", false);
      }
      if (this.a.e)
      {
        this.a.jdField_b_of_type_JavaUtilHashMap = ((HashMap)paramIntent.getSerializableExtra("PasterConstants.pasters_data"));
        this.a.jdField_a_of_type_JavaLangString = paramIntent.getStringExtra("PasterConstants.paster_id");
        this.a.jdField_b_of_type_JavaLangString = paramIntent.getStringExtra("PasterConstants.paster_cate_id");
      }
      this.a.l = paramIntent.getBooleanExtra("ReceiptMsgManager.EXTRA_KEY_IS_RECEIPT", false);
      this.a.jdField_a_of_type_Long = paramIntent.getLongExtra("PhotoConst.PHOTOLIST_KEY_MAX_MEDIA_SIZE", -1L);
      if (this.mPhotoCommonData.isShowQzoneAlbum)
      {
        paramIntent = new NewIntent(BaseApplicationImpl.getApplication(), ayxl.class);
        paramIntent.putExtra("selfuin", Long.valueOf(BaseApplicationImpl.getApplication().getRuntime().getAccount()));
        BaseApplicationImpl.getApplication().getRuntime().registObserver(NewPhotoListActivity.jdField_a_of_type_Aimg);
        BaseApplicationImpl.getApplication().getRuntime().startServlet(paramIntent);
      }
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.e("PhotoListActivity", 2, "submit", localException);
        }
      }
    }
  }
  
  public boolean needVedio()
  {
    return super.needVedio();
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    ArrayList localArrayList = this.mPhotoCommonData.selectedPhotoList;
    if ((QLog.isDevelopLevel()) && (localArrayList != null) && (localArrayList.size() != 0)) {
      QLog.d("PhotoListActivity", 4, "[NewPhotoListActivity] [onActivityResult] selectedPhotoList = " + localArrayList.size());
    }
    this.a.requestCode = paramInt1;
    if (paramInt2 == -1) {
      switch (paramInt1)
      {
      }
    }
    for (;;)
    {
      PhotoUtils.a(this.mActivity, paramInt1, paramInt2, paramIntent, this.a.h, this.mPhotoCommonData.myUin);
      do
      {
        return;
        ((NewPhotoListActivity)this.mActivity).setResult(-1, paramIntent);
        ((NewPhotoListActivity)this.mActivity).finish();
        break;
        paramIntent = PresendPicMgr.a();
        if (paramIntent != null) {
          paramIntent.a(this.a.currentPhotoPath, 1008);
        }
        enterPhotoPreviewActivity(true, ((NewPhotoListActivity)this.mActivity).getIntent());
        return;
        paramIntent = new Intent();
        paramIntent.putStringArrayListExtra("PhotoConst.SELECTED_PATHS", localArrayList);
        paramIntent.putExtra("PhotoConst.CURRENT_QUALITY_TYPE", this.mPhotoCommonData.currentQualityType);
        ((NewPhotoListActivity)this.mActivity).setResult(-1, paramIntent);
        ((NewPhotoListActivity)this.mActivity).finish();
        return;
      } while (paramIntent == null);
      this.mPhotoCommonData.selectedPhotoList = paramIntent.getStringArrayListExtra("img_list");
      continue;
      xir.a().a(paramIntent, this.mPhotoCommonData.selectedMediaInfoHashMap);
      continue;
      if (paramInt1 == 17)
      {
        bdar.sLastAlbumRecordTime = 0L;
        return;
      }
      if ((paramInt1 == 100010) && (this.mPhotoCommonData.a())) {
        if (this.a.needQueryTask) {
          ((NewPhotoListActivity)this.mActivity).runOnUiThread(new PhotoListLogicDefault.5(this));
        } else {
          this.a.needQueryTask = true;
        }
      }
    }
  }
  
  public void onBackPressed()
  {
    super.onBackPressed();
  }
  
  public void onCheckBoxClick(View paramView, int paramInt, CheckBox paramCheckBox)
  {
    boolean bool2 = true;
    paramView = this.mPhotoCommonData.selectedPhotoList;
    if (this.a.isSingleMode) {}
    LocalMediaInfo localLocalMediaInfo;
    int i;
    Object localObject1;
    do
    {
      long l;
      do
      {
        return;
        if (QLog.isColorLevel()) {
          QLog.d("PhotoListActivity", 2, "current select count:" + paramView.size());
        }
        localLocalMediaInfo = ((NewPhotoListActivity)this.mActivity).photoListAdapter.getItem(paramInt);
        i = localLocalMediaInfo.selectStatus;
        if ((i == 1) || (paramView.size() < this.mPhotoCommonData.maxSelectNum)) {
          break;
        }
        l = System.currentTimeMillis();
      } while (l - this.a.lastTimeShowToast < 1000L);
      QQToast.a(this.mActivity, getExceedMaxSelectNumStr(localLocalMediaInfo), 0).b(((NewPhotoListActivity)this.mActivity).mTitleBarHeight);
      paramCheckBox.setChecked(false);
      this.a.lastTimeShowToast = l;
      e();
      return;
      if ((this.a.jdField_a_of_type_Int == 9501) && (((NewPhotoListActivity)this.mActivity).getIntent().getBooleanExtra("PhotoConst.IS_SEND_FILESIZE_LIMIT", false)) && (i != 1))
      {
        localObject1 = paramView.iterator();
        for (l = 0L; ((Iterator)localObject1).hasNext(); l = bdcs.a((String)((Iterator)localObject1).next()) + l) {}
        if (bdcs.a(localLocalMediaInfo.path) + l > 52428800L)
        {
          QQToast.a(this.mActivity, "选择图片总大小不能超过50M", 0).b(((NewPhotoListActivity)this.mActivity).mTitleBarHeight);
          paramCheckBox.setChecked(false);
          return;
        }
      }
      if ((((NewPhotoListActivity)this.mActivity).getIntent().getBooleanExtra("PhotoConst.IS_SEND_GIF_SIZE_LIMIT", false)) && (((NewPhotoListActivity)this.mActivity).isGif(localLocalMediaInfo)) && (bdcs.a(localLocalMediaInfo.path) > 3145728L))
      {
        QQToast.a(this.mActivity, "图片文件过大", 0).b(((NewPhotoListActivity)this.mActivity).mTitleBarHeight);
        paramCheckBox.setChecked(false);
        return;
      }
    } while ((this.mPhotoCommonData.a()) && (!bnbf.a(this.mActivity, localLocalMediaInfo)));
    label409:
    boolean bool1;
    label428:
    Object localObject2;
    if (i == 1)
    {
      i = 2;
      localLocalMediaInfo.selectStatus = i;
      if (localLocalMediaInfo.selectStatus != 1) {
        break label1019;
      }
      bool1 = true;
      paramCheckBox = localLocalMediaInfo.path;
      localObject1 = PresendPicMgr.a();
      if (!bool1) {
        break label1025;
      }
      localObject2 = MimeHelper.getMimeType(localLocalMediaInfo.mMimeType);
      aimk localaimk;
      if ((this.a.isSupportVideoCheckbox) && (localObject2 != null) && ("video".equals(localObject2[0])))
      {
        localaimk = this.a;
        localaimk.videoSelectedCnt += 1;
        if (this.a.videoSelectedCnt == 1) {
          this.a.selectedVideoInfo = localLocalMediaInfo;
        }
      }
      if ((!TextUtils.isEmpty(localLocalMediaInfo.mMimeType)) && ("image/gif".equals(localLocalMediaInfo.mMimeType)))
      {
        localaimk = this.a;
        localaimk.gifSelectedCount += 1;
      }
      paramView.add(paramCheckBox);
      this.mPhotoCommonData.selectedIndex.add(localLocalMediaInfo.position);
      if (this.mPhotoCommonData.needMediaInfo) {
        this.mPhotoCommonData.selectedMediaInfoHashMap.put(paramCheckBox, localLocalMediaInfo);
      }
      if ((localObject1 != null) && (localObject2 != null) && (localObject2[0] != null) && (!"video".equals(localObject2[0]))) {
        ((PresendPicMgr)localObject1).a(paramCheckBox, 1052, ((NewPhotoListActivity)this.mActivity).getIntent().getIntExtra("entrance", 0));
      }
      aild.a(((NewPhotoListActivity)this.mActivity).getIntent(), "param_totalSelNum");
      paramView = ((NewPhotoListActivity)this.mActivity).getIntent();
      if (!paramView.hasExtra("param_initTime")) {
        paramView.putExtra("param_initTime", System.currentTimeMillis());
      }
      paramView = (LinkedHashMap)bdar.sSelectItemPosMap.get(this.mPhotoCommonData.albumId);
      if (paramView != null) {
        break label1272;
      }
      paramView = new LinkedHashMap();
      bdar.sSelectItemPosMap.put(this.mPhotoCommonData.albumId, paramView);
    }
    label818:
    label1272:
    for (;;)
    {
      paramView.put(paramCheckBox, Integer.valueOf(((NewPhotoListActivity)this.mActivity).mGridView.getFirstVisiblePosition()));
      paramView = bdar.sSelectItemAlbum;
      if (!paramView.containsKey(paramCheckBox)) {
        paramView.put(paramCheckBox, new Pair(this.mPhotoCommonData.albumId, this.mPhotoCommonData.albumName));
      }
      if (this.mSelectionListener != null) {
        this.mSelectionListener.onSelectionChange(bool1, localLocalMediaInfo);
      }
      ((NewPhotoListActivity)this.mActivity).updateCheckbox(paramInt, bool1);
      paramView = (NewPhotoListActivity)this.mActivity;
      if (!bool1) {}
      for (bool1 = bool2;; bool1 = false)
      {
        paramView.selectLimitRemind(bool1);
        updateButton();
        if (!this.mPhotoCommonData.a()) {
          break;
        }
        if (xir.a().a().isEmpty())
        {
          i = ((NewPhotoListActivity)this.mActivity).mGridView.getFirstVisiblePosition();
          paramView = ((NewPhotoListActivity)this.mActivity).mGridView.getChildAt(paramInt - i);
          if ((paramView != null) && (((NewPhotoListActivity)this.mActivity).mGridView.getHeight() - paramView.getY() < ((NewPhotoListActivity)this.mActivity).mImageHeight)) {
            ((NewPhotoListActivity)this.mActivity).mGridView.smoothScrollBy(xir.jdField_a_of_type_Int, 500);
          }
        }
        xir.a().b(this.mPhotoCommonData.selectedPhotoList, this.mPhotoCommonData.allMediaInfoHashMap);
        return;
        i = 1;
        break label409;
        label1019:
        bool1 = false;
        break label428;
        localObject2 = MimeHelper.getMimeType(localLocalMediaInfo.mMimeType);
        if ((this.a.isSupportVideoCheckbox) && (localObject2 != null) && ("video".equals(localObject2[0])))
        {
          localObject2 = this.a;
          ((aimk)localObject2).videoSelectedCnt -= 1;
          if (this.a.videoSelectedCnt == 1) {
            this.a.selectedVideoInfo = localLocalMediaInfo;
          }
        }
        if ((!TextUtils.isEmpty(localLocalMediaInfo.mMimeType)) && ("image/gif".equals(localLocalMediaInfo.mMimeType)))
        {
          localObject2 = this.a;
          ((aimk)localObject2).gifSelectedCount -= 1;
        }
        paramView.remove(paramCheckBox);
        this.mPhotoCommonData.selectedIndex.remove(localLocalMediaInfo.position);
        if (this.mPhotoCommonData.needMediaInfo) {
          this.mPhotoCommonData.selectedMediaInfoHashMap.remove(paramCheckBox);
        }
        if (localObject1 != null) {
          ((PresendPicMgr)localObject1).b(paramCheckBox, 1013);
        }
        aild.a(((NewPhotoListActivity)this.mActivity).getIntent(), "param_cancelSelNum");
        paramView = (HashMap)bdar.sSelectItemPosMap.get(this.mPhotoCommonData.albumId);
        if (paramView != null) {
          paramView.remove(paramCheckBox);
        }
        paramView = bdar.sSelectItemAlbum;
        if (!paramView.containsKey(paramCheckBox)) {
          break label818;
        }
        paramView.remove(paramCheckBox);
        break label818;
      }
    }
  }
  
  public void onGestureSelectEnd(boolean paramBoolean, int paramInt1, int paramInt2)
  {
    if (this.a.isSingleMode) {
      return;
    }
    if (this.mPhotoCommonData.a())
    {
      if (xir.a().a().isEmpty())
      {
        paramInt2 = ((NewPhotoListActivity)this.mActivity).mGridView.getFirstVisiblePosition();
        localObject = ((NewPhotoListActivity)this.mActivity).mGridView.getChildAt(paramInt1 - paramInt2);
        if ((localObject != null) && (((NewPhotoListActivity)this.mActivity).mGridView.getHeight() - ((View)localObject).getY() < ((NewPhotoListActivity)this.mActivity).mImageHeight)) {
          ((NewPhotoListActivity)this.mActivity).mGridView.smoothScrollBy(xir.jdField_a_of_type_Int, 500);
        }
      }
      xir.a().b(this.mPhotoCommonData.selectedPhotoList, this.mPhotoCommonData.allMediaInfoHashMap);
    }
    Object localObject = PresendPicMgr.a();
    if (localObject != null)
    {
      Iterator localIterator = this.a.presendPathSet.iterator();
      while (localIterator.hasNext())
      {
        String str = (String)localIterator.next();
        if (((NewPhotoListActivity)this.mActivity).a(str) != 1) {
          ((PresendPicMgr)localObject).a(str, 1052);
        }
      }
      localIterator = this.a.cancelPresendPathSet.iterator();
      while (localIterator.hasNext()) {
        ((PresendPicMgr)localObject).b((String)localIterator.next(), 1013);
      }
    }
    this.a.presendPathSet.clear();
    this.a.cancelPresendPathSet.clear();
  }
  
  public void onMagicStickClick(View paramView, Bundle paramBundle, int paramInt, Intent paramIntent)
  {
    if (this.mPhotoCommonData.selectedPhotoList.size() > 0)
    {
      paramView = ((NewPhotoListActivity)this.mActivity).getIntent();
      paramView.removeExtra("param_initTime");
      paramView.putStringArrayListExtra("PhotoConst.PHOTO_PATHS", this.mPhotoCommonData.selectedPhotoList);
      azmj.b(null, "CliOper", "", "", "0x8004B39", "0x8004B39", 0, 0, "", "", "", "");
      paramView = paramIntent;
      if (paramIntent == null) {
        paramView = EditPicActivity.a(this.mActivity, (String)this.mPhotoCommonData.selectedPhotoList.get(0), true, true, true, true, true, paramInt, 99, 5, paramBundle);
      }
      paramView.putExtra("key_enable_edit_title_bar", true);
      a(paramView);
      ((NewPhotoListActivity)this.mActivity).startActivity(paramView);
      ((NewPhotoListActivity)this.mActivity).jdField_a_of_type_AndroidWidgetButton.setClickable(false);
    }
  }
  
  public void onPhotoListDatasetDurationChanged(int paramInt, LocalMediaInfo paramLocalMediaInfo)
  {
    Handler localHandler = ((NewPhotoListActivity)this.mActivity).jdField_a_of_type_AndroidOsHandler;
    if (localHandler == null) {}
    do
    {
      do
      {
        return;
        localObject = ((NewPhotoListActivity)this.mActivity).photoListAdapter;
      } while ((localObject == null) || (((AbstractPhotoListActivity.PhotoListAdapter)localObject).mAllImages == null));
      localObject = (LocalMediaInfo)((AbstractPhotoListActivity.PhotoListAdapter)localObject).mAllImages.get(paramInt);
    } while ((localObject == null) || (paramLocalMediaInfo == null) || (((LocalMediaInfo)localObject).path == null) || (paramLocalMediaInfo.path == null) || (!((LocalMediaInfo)localObject).path.equals(paramLocalMediaInfo.path)));
    Object localObject = localHandler.obtainMessage();
    ((Message)localObject).what = 0;
    Bundle localBundle = new Bundle();
    localBundle.putInt("ALBUMLIST_POSITION", paramInt);
    localBundle.putLong("ALBUMLIST_ITEM_DURATION", paramLocalMediaInfo.mDuration);
    ((Message)localObject).setData(localBundle);
    localHandler.sendMessage((Message)localObject);
  }
  
  public void onPreviewBtnClick(View paramView)
  {
    super.onPreviewBtnClick(paramView);
  }
  
  public void onQualityBtnClick(CompoundButton paramCompoundButton, boolean paramBoolean)
  {
    if (paramBoolean) {
      if (bdar.a(this.mPhotoCommonData.selectedPhotoList, this.mPhotoCommonData.jdField_a_of_type_Int, this.mPhotoCommonData.allMediaInfoHashMap, this.a.k, this.mPhotoCommonData.selectedMediaInfoHashMap) > 0)
      {
        QQToast.a(this.mActivity, ((NewPhotoListActivity)this.mActivity).getResources().getString(2131695271), 0).b(((NewPhotoListActivity)this.mActivity).getResources().getDimensionPixelSize(2131298914));
        this.mPhotoCommonData.currentQualityType = 0;
        ((NewPhotoListActivity)this.mActivity).jdField_a_of_type_AndroidWidgetCheckBox.setChecked(false);
        ((NewPhotoListActivity)this.mActivity).b.setVisibility(4);
      }
    }
    for (;;)
    {
      if (!this.a.jdField_d_of_type_Boolean) {
        ((NewPhotoListActivity)this.mActivity).b.setVisibility(8);
      }
      return;
      if (bdar.a(this.mPhotoCommonData.selectedPhotoList, this.mPhotoCommonData.videoSizeLimit, this.mPhotoCommonData.allMediaInfoHashMap, this.a.k, this.mPhotoCommonData.selectedMediaInfoHashMap) > 0)
      {
        QQToast.a(this.mActivity, ((NewPhotoListActivity)this.mActivity).getResources().getString(2131720121), 0).b(((NewPhotoListActivity)this.mActivity).getResources().getDimensionPixelSize(2131298914));
        bdar.c();
      }
      ((NewPhotoListActivity)this.mActivity).jdField_a_of_type_AndroidWidgetCheckBox.setChecked(true);
      this.mPhotoCommonData.currentQualityType = 2;
      bdar.a(((NewPhotoListActivity)this.mActivity).b, this.mPhotoCommonData.selectedPhotoList, this.mPhotoCommonData.allMediaInfoHashMap, this.a.k, this.mActivity, this.a.jdField_a_of_type_JavaUtilHashMap, this.mPhotoCommonData.selectedMediaInfoHashMap);
      continue;
      this.mPhotoCommonData.currentQualityType = 0;
      ((NewPhotoListActivity)this.mActivity).jdField_a_of_type_AndroidWidgetCheckBox.setChecked(false);
      ((NewPhotoListActivity)this.mActivity).b.setVisibility(4);
    }
  }
  
  public boolean onQueryPhoto(List<LocalMediaInfo> paramList)
  {
    int m = 0;
    if (this.mActivity == null) {}
    while (!super.onQueryPhoto(paramList)) {
      return false;
    }
    int i;
    int k;
    int j;
    if (this.a.firstResume)
    {
      this.a.firstResume = false;
      if (this.a.photoListStartPos != -1) {
        break label491;
      }
      i = aimk.sPhotoListFirstPos;
      if (i != -1) {
        break label518;
      }
      Object localObject = (LinkedHashMap)bdar.sSelectItemPosMap.get(this.mPhotoCommonData.albumId);
      k = i;
      if (localObject != null)
      {
        j = ((LinkedHashMap)localObject).size();
        k = i;
        if (j > 0) {
          k = ((Integer)((LinkedHashMap)localObject).get(localObject.keySet().toArray()[(j - 1)])).intValue();
        }
      }
      j = k;
      if (k == -1)
      {
        j = k;
        if (this.a.isRecodeLastAlbumPath)
        {
          localObject = paramList.iterator();
          i = 0;
          label156:
          j = k;
          if (((Iterator)localObject).hasNext())
          {
            if (((LocalMediaInfo)((Iterator)localObject).next()).selectStatus != 3) {
              break label502;
            }
            j = i;
          }
        }
      }
      localObject = this.mPhotoCommonData.selectedPhotoList;
      i = j;
      if (j == -1)
      {
        i = j;
        if (this.mPhotoCommonData.albumId.equals("$RecentAlbumId"))
        {
          i = j;
          if (!((ArrayList)localObject).isEmpty())
          {
            int n = paramList.size();
            localObject = (String)((ArrayList)localObject).get(((ArrayList)localObject).size() - 1);
            k = 0;
            label260:
            i = j;
            if (k < n)
            {
              if (!((String)localObject).equals(((LocalMediaInfo)paramList.get(k)).path)) {
                break label509;
              }
              i = k;
            }
          }
        }
      }
      label294:
      j = ((NewPhotoListActivity)this.mActivity).photoListAdapter.getCount();
      if (j != 0) {
        break label525;
      }
      j = m;
      label315:
      if (!this.mPhotoCommonData.a()) {
        break label551;
      }
      if ((this.mPhotoCommonData.selectedPhotoList != null) && (this.mPhotoCommonData.selectedPhotoList.size() > 0))
      {
        paramList = (String)this.mPhotoCommonData.selectedPhotoList.get(this.mPhotoCommonData.selectedPhotoList.size() - 1);
        i = this.mPhotoCommonData.mediaPathsList.indexOf(paramList);
        if ((i >= 0) && (i < ((NewPhotoListActivity)this.mActivity).mGridView.a().getCount())) {
          ((NewPhotoListActivity)this.mActivity).mGridView.post(new PhotoListLogicDefault.9(this, j));
        }
      }
    }
    for (;;)
    {
      if (this.mPhotoCommonData.a())
      {
        ((NewPhotoListActivity)this.mActivity).a(this.mPhotoCommonData.selectedPhotoList, this.mPhotoCommonData.selectedMediaInfoHashMap);
        xir.a().b(this.mPhotoCommonData.selectedPhotoList, this.mPhotoCommonData.allMediaInfoHashMap);
      }
      return true;
      label491:
      i = this.a.photoListStartPos;
      break;
      label502:
      i += 1;
      break label156;
      label509:
      k += 1;
      break label260;
      label518:
      aimk.sPhotoListFirstPos = -1;
      break label294;
      label525:
      if (i > j - 1)
      {
        j -= 1;
        break label315;
      }
      j = m;
      if (i < 0) {
        break label315;
      }
      j = i;
      break label315;
      label551:
      ((NewPhotoListActivity)this.mActivity).mGridView.post(new PhotoListLogicDefault.10(this, j));
    }
  }
  
  public void onSendBtnClick(View paramView)
  {
    ((NewPhotoListActivity)this.mActivity).sendBtn.setClickable(false);
    if (!this.mPhotoCommonData.selectedPhotoList.isEmpty()) {
      ((NewPhotoListActivity)this.mActivity).recordLastPos((String)this.mPhotoCommonData.selectedPhotoList.get(this.mPhotoCommonData.selectedPhotoList.size() - 1));
    }
    bdar.a();
    if (this.mPhotoCommonData.selectedPhotoList.size() == 0)
    {
      if (QLog.isColorLevel()) {
        QLog.e("PhotoList", 2, "size == 0");
      }
      return;
    }
    if (((NewPhotoListActivity)this.mActivity).getIntent().getBooleanExtra("PhotoConst.IS_SEND_FILESIZE_LIMIT", false))
    {
      paramView = this.mPhotoCommonData.selectedPhotoList.iterator();
      for (long l = 0L; paramView.hasNext(); l = bdcs.a((String)paramView.next()) + l) {}
      if (arni.a())
      {
        armv.a(this.mActivity, 2131692752, 2131692757, new aimp(this));
        return;
      }
    }
    b();
  }
  
  public void onTitleBtnCancelClick(View paramView)
  {
    bdar.clearSelectItemInfo();
    bdar.a();
    paramView = PresendPicMgr.a();
    if (paramView != null) {
      paramView.a(1006);
    }
    paramView = ((NewPhotoListActivity)this.mActivity).getIntent();
    if (this.mPhotoCommonData.selectedPhotoList != null) {}
    for (int i = this.mPhotoCommonData.selectedPhotoList.size();; i = 0)
    {
      aild.b(paramView, i);
      if (this.a.i) {
        break;
      }
      if (this.mPhotoCommonData.a()) {
        xir.a().a(xir.a().c());
      }
      ((NewPhotoListActivity)this.mActivity).finish();
      bdar.anim(this.mActivity, false, false);
      return;
    }
    paramView = ((NewPhotoListActivity)this.mActivity).getIntent();
    String str1 = paramView.getStringExtra("PhotoConst.INIT_ACTIVITY_CLASS_NAME");
    String str2 = paramView.getStringExtra("PhotoConst.INIT_ACTIVITY_PACKAGE_NAME");
    if (str1 == null)
    {
      QQToast.a(this.mActivity, "请设置INIT_ACTIVITY_CLASS_NAME ", 0).a();
      return;
    }
    paramView.setClassName(str2, str1);
    paramView.removeExtra("PhotoConst.PHOTO_PATHS");
    paramView.removeExtra("PhotoConst.SINGLE_PHOTO_PATH");
    paramView.addFlags(603979776);
    ((NewPhotoListActivity)this.mActivity).startActivity(paramView);
    ((NewPhotoListActivity)this.mActivity).finish();
    bdar.anim(this.mActivity, false, false);
  }
  
  public void postInitUI()
  {
    Object localObject = ((NewPhotoListActivity)this.mActivity).bottomBar;
    int i;
    if ((this.a.isSingleMode) || (this.a.showMediaType == 2) || (this.mPhotoCommonData.a()))
    {
      i = 8;
      ((View)localObject).setVisibility(i);
      ((NewPhotoListActivity)this.mActivity).previewBtn.setOnClickListener(this.mActivity);
      ((NewPhotoListActivity)this.mActivity).sendBtn.setOnClickListener(this.mActivity);
      if (!this.a.e) {
        break label275;
      }
      ((NewPhotoListActivity)this.mActivity).jdField_a_of_type_AndroidWidgetButton.setVisibility(0);
      ((NewPhotoListActivity)this.mActivity).jdField_a_of_type_AndroidWidgetButton.setOnClickListener(this.mActivity);
    }
    for (;;)
    {
      if (this.a.jdField_c_of_type_Boolean) {
        ((NewPhotoListActivity)this.mActivity).jdField_a_of_type_AndroidWidgetCheckBox.setOnCheckedChangeListener(this.mActivity);
      }
      updateButton();
      if (this.mPhotoCommonData.a())
      {
        this.a.jdField_a_of_type_Xiv = new xiv(this.mActivity, this);
        xir.a().a(this.a.jdField_a_of_type_Xiv);
        xir.a().a(this.mActivity);
        f();
        if (((NewPhotoListActivity)this.mActivity).getIntent().getBooleanExtra("report_first_exposure", true))
        {
          localObject = (xiy)QQStoryContext.a().getBusinessHandler(1);
          if (localObject != null) {
            ((xiy)localObject).a();
          }
          ((NewPhotoListActivity)this.mActivity).getIntent().putExtra("report_first_exposure", false);
        }
      }
      return;
      i = 0;
      break;
      label275:
      ((NewPhotoListActivity)this.mActivity).jdField_a_of_type_AndroidWidgetButton.setVisibility(8);
    }
  }
  
  public void processQueryResult(List<LocalMediaInfo> paramList)
  {
    aikk.a(paramList, null, this.a.jdField_c_of_type_JavaUtilHashMap);
  }
  
  public void processViewCaseImage(AbstractPhotoListActivity.PhotoListAdapter.Holder paramHolder, LocalMediaInfo paramLocalMediaInfo)
  {
    if (aikk.a(paramLocalMediaInfo.path, this.a.jdField_c_of_type_JavaUtilHashMap))
    {
      if (Build.VERSION.SDK_INT >= 21) {
        paramHolder.mPhotoFlagView.setImageDrawable(((NewPhotoListActivity)this.mActivity).getDrawable(2130839177));
      }
      for (;;)
      {
        paramHolder.mPhotoFlagView.setVisibility(0);
        return;
        paramHolder.mPhotoFlagView.setImageResource(2130839177);
      }
    }
    paramHolder.mPhotoFlagView.setVisibility(8);
  }
  
  public void startPhotoPreviewActivity(Intent paramIntent)
  {
    super.startPhotoPreviewActivity(paramIntent);
  }
  
  public void updateButton()
  {
    super.updateButton();
    ArrayList localArrayList = this.mPhotoCommonData.selectedPhotoList;
    int i;
    if (localArrayList.size() > 0)
    {
      i = 1;
      if (QLog.isColorLevel()) {
        QLog.d("_photo", 2, "updateButton selectedPhotoList.size()=" + localArrayList.size());
      }
      if (i == 0)
      {
        ((NewPhotoListActivity)this.mActivity).jdField_a_of_type_AndroidWidgetCheckBox.setChecked(false);
        ((NewPhotoListActivity)this.mActivity).jdField_a_of_type_AndroidWidgetCheckBox.setEnabled(false);
        ((NewPhotoListActivity)this.mActivity).jdField_a_of_type_AndroidWidgetTextView.setEnabled(false);
        ((NewPhotoListActivity)this.mActivity).b.setEnabled(false);
      }
      if (!this.a.e) {
        break label374;
      }
      if ((localArrayList.size() != 1) || ((this.mPhotoCommonData.jdField_a_of_type_JavaUtilHashMap != null) && (this.mPhotoCommonData.jdField_a_of_type_JavaUtilHashMap.size() > 0)) || (((NewPhotoListActivity)this.mActivity).a((String)localArrayList.get(0)) != 0)) {
        break label357;
      }
      ((NewPhotoListActivity)this.mActivity).jdField_a_of_type_AndroidWidgetButton.setEnabled(true);
    }
    for (;;)
    {
      ((NewPhotoListActivity)this.mActivity).jdField_a_of_type_AndroidWidgetCheckBox.setVisibility(8);
      ((NewPhotoListActivity)this.mActivity).jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
      ((NewPhotoListActivity)this.mActivity).b.setVisibility(8);
      if (this.a.jdField_c_of_type_Boolean)
      {
        ((NewPhotoListActivity)this.mActivity).jdField_a_of_type_AndroidWidgetCheckBox.setVisibility(0);
        ((NewPhotoListActivity)this.mActivity).jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
        if (i != 0)
        {
          ((NewPhotoListActivity)this.mActivity).jdField_a_of_type_AndroidWidgetCheckBox.setEnabled(true);
          ((NewPhotoListActivity)this.mActivity).jdField_a_of_type_AndroidWidgetTextView.setEnabled(true);
          ((NewPhotoListActivity)this.mActivity).b.setEnabled(true);
        }
      }
      d();
      if (!this.a.jdField_d_of_type_Boolean) {
        ((NewPhotoListActivity)this.mActivity).b.setVisibility(8);
      }
      return;
      i = 0;
      break;
      label357:
      ((NewPhotoListActivity)this.mActivity).jdField_a_of_type_AndroidWidgetButton.setEnabled(false);
      continue;
      label374:
      ((NewPhotoListActivity)this.mActivity).jdField_a_of_type_AndroidWidgetButton.setVisibility(8);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aiml
 * JD-Core Version:    0.7.0.1
 */