import android.app.Dialog;
import android.content.Intent;
import android.content.res.Resources;
import android.media.MediaMetadataRetriever;
import android.support.v7.widget.GridLayoutManager;
import android.text.TextUtils;
import android.util.Pair;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.activity.photo.MimeHelper;
import com.tencent.mobileqq.activity.photo.album.AbstractPhotoListActivity.PhotoListAdapter;
import com.tencent.mobileqq.activity.photo.album.NewPhotoListActivity;
import com.tencent.mobileqq.activity.photo.album.PhotoCommonBaseData;
import com.tencent.mobileqq.pic.PresendPicMgr;
import com.tencent.mobileqq.utils.AlbumUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.inject.dialog.ReportDialog;
import cooperation.qzone.QZoneHelper;
import cooperation.qzone.QzonePluginProxyActivity;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;

public class akno
  extends akmj
{
  private static final String[] jdField_a_of_type_ArrayOfJavaLangString = { "video/mp4", "video/3gpp" };
  private int jdField_a_of_type_Int = 0;
  private Dialog jdField_a_of_type_AndroidAppDialog;
  private boolean jdField_a_of_type_Boolean;
  private int b = 3000;
  private int c = 3000;
  private int d = 3600000;
  private int e;
  
  public akno(NewPhotoListActivity paramNewPhotoListActivity)
  {
    super(paramNewPhotoListActivity);
    bnrh.a("PhotoListLogicAECircle", "[AE Profiler] PhotoListLogicAECircle new");
  }
  
  private int a(LocalMediaInfo paramLocalMediaInfo)
  {
    long l = paramLocalMediaInfo.mDuration;
    if ((l > this.d) || (l < 2000L)) {
      return 1;
    }
    MediaMetadataRetriever localMediaMetadataRetriever = new MediaMetadataRetriever();
    try
    {
      localMediaMetadataRetriever.setDataSource(paramLocalMediaInfo.path);
      paramLocalMediaInfo = localMediaMetadataRetriever.extractMetadata(12);
      if (!paramLocalMediaInfo.equals(jdField_a_of_type_ArrayOfJavaLangString[0]))
      {
        boolean bool = paramLocalMediaInfo.equals(jdField_a_of_type_ArrayOfJavaLangString[1]);
        if (!bool) {
          return 3;
        }
      }
      return 0;
    }
    catch (Exception paramLocalMediaInfo)
    {
      if (QLog.isColorLevel()) {
        paramLocalMediaInfo.printStackTrace();
      }
      return 5;
    }
    finally
    {
      localMediaMetadataRetriever.release();
    }
  }
  
  private void a(boolean paramBoolean)
  {
    if ((this.mActivity != null) && (!((NewPhotoListActivity)this.mActivity).isFinishing()))
    {
      if (!paramBoolean) {
        break label81;
      }
      if (this.jdField_a_of_type_AndroidAppDialog == null)
      {
        this.jdField_a_of_type_AndroidAppDialog = new ReportDialog(this.mActivity, 2131755829);
        this.jdField_a_of_type_AndroidAppDialog.setCancelable(false);
        this.jdField_a_of_type_AndroidAppDialog.setCanceledOnTouchOutside(false);
        this.jdField_a_of_type_AndroidAppDialog.setContentView(2131559607);
      }
      this.jdField_a_of_type_AndroidAppDialog.show();
    }
    label81:
    while ((this.jdField_a_of_type_AndroidAppDialog == null) || (!this.jdField_a_of_type_AndroidAppDialog.isShowing())) {
      return;
    }
    this.jdField_a_of_type_AndroidAppDialog.dismiss();
  }
  
  private void g()
  {
    bode.a(this.jdField_a_of_type_Int, this.mActivity, this.mPhotoCommonData, false);
    ((NewPhotoListActivity)this.mActivity).finish();
    a(false);
  }
  
  public boolean addAndRemovePhotoByGesture(LocalMediaInfo paramLocalMediaInfo, boolean paramBoolean)
  {
    boolean bool = false;
    if (((NewPhotoListActivity)this.mActivity).isGif(paramLocalMediaInfo)) {
      QQToast.a(this.mActivity, anvx.a(2131689757), 0).b(((NewPhotoListActivity)this.mActivity).mTitleBarHeight);
    }
    long l;
    do
    {
      int i;
      do
      {
        String[] arrayOfString;
        do
        {
          return false;
          arrayOfString = MimeHelper.getMimeType(paramLocalMediaInfo.mMimeType);
        } while ((!this.jdField_a_of_type_Akmi.isSupportVideoCheckbox) && (arrayOfString != null) && (!"image".equals(arrayOfString[0])));
        i = paramLocalMediaInfo.selectStatus;
      } while (((i == 1) && (paramBoolean)) || ((i == 2) && (!paramBoolean)));
      if ((i != 2) || (!paramBoolean) || (this.mPhotoCommonData.selectedPhotoList.size() + this.e < 9)) {
        break;
      }
      l = System.currentTimeMillis();
    } while (l - this.jdField_a_of_type_Akmi.lastTimeShowToast < 700L);
    paramLocalMediaInfo = BaseApplicationImpl.sApplication.getResources().getString(2131689758, new Object[] { Integer.valueOf(9 - this.e) });
    QQToast.a(this.mActivity, paramLocalMediaInfo, 0).b(((NewPhotoListActivity)this.mActivity).mTitleBarHeight);
    this.jdField_a_of_type_Akmi.lastTimeShowToast = l;
    this.jdField_a_of_type_Akmi.hasShownMaxSelectToast = true;
    return false;
    this.jdField_a_of_type_Akmi.hasShownMaxSelectToast = false;
    if (paramBoolean) {
      a(paramLocalMediaInfo);
    }
    for (;;)
    {
      paramLocalMediaInfo = (NewPhotoListActivity)this.mActivity;
      if (!paramBoolean) {
        bool = true;
      }
      paramLocalMediaInfo.selectLimitRemind(bool);
      return true;
      b(paramLocalMediaInfo);
    }
  }
  
  public Intent caseNoSingModeImage(View paramView, int paramInt)
  {
    paramView = super.caseNoSingModeImage(paramView, paramInt);
    paramView.putExtra("choosed_num", this.mPhotoCommonData.selectedPhotoList.size());
    paramView.putExtra("BUNDLE_KEY_INITIAL_PICKED_NUM", this.e);
    LocalMediaInfo localLocalMediaInfo1 = ((NewPhotoListActivity)this.mActivity).photoListAdapter.getItem(paramInt);
    ArrayList localArrayList1 = new ArrayList();
    ArrayList localArrayList2 = new ArrayList();
    int m = this.mPhotoCommonData.mediaPathsList.size();
    int k = 0;
    int j = 0;
    int i = paramInt;
    if (k < m)
    {
      String str = (String)this.mPhotoCommonData.mediaPathsList.get(k);
      LocalMediaInfo localLocalMediaInfo2 = (LocalMediaInfo)this.mPhotoCommonData.allMediaInfoHashMap.get(str);
      if (AlbumUtil.getMediaType(localLocalMediaInfo2) != 0) {
        break label279;
      }
      localArrayList1.add(str);
      if ((this.mPhotoCommonData.selectedPhotoList != null) && (this.mPhotoCommonData.selectedPhotoList.contains(str))) {
        localArrayList2.add(Integer.valueOf(j));
      }
      if (localLocalMediaInfo2.position.intValue() != paramInt) {
        break label276;
      }
      i = j;
      label198:
      j += 1;
    }
    label276:
    label279:
    for (;;)
    {
      k += 1;
      break;
      this.mPhotoCommonData.mediaPathsList = localArrayList1;
      paramView.putStringArrayListExtra("PhotoConst.PHOTO_PATHS", localArrayList1);
      paramView.putStringArrayListExtra("PhotoConst.SELECTED_PATHS", this.mPhotoCommonData.selectedPhotoList);
      paramView.putIntegerArrayListExtra("PhotoConst.SELECTED_INDEXS", localArrayList2);
      if (AlbumUtil.getMediaType(localLocalMediaInfo1) == 0) {
        paramView.putExtra("PhotoConst.CURRENT_SELECTED_INDEX", i);
      }
      return paramView;
      break label198;
    }
  }
  
  public void caseVideo(View paramView, int paramInt)
  {
    LocalMediaInfo localLocalMediaInfo;
    if ((this.mPhotoCommonData.selectedPhotoList.size() == 0) && (this.jdField_a_of_type_Boolean))
    {
      localLocalMediaInfo = ((NewPhotoListActivity)this.mActivity).photoListAdapter.getItem(paramInt);
      switch (a(localLocalMediaInfo))
      {
      default: 
        return;
      case 0: 
        this.jdField_a_of_type_Int = 1;
        this.mPhotoCommonData.selectedPhotoList.add(localLocalMediaInfo.path);
        this.mPhotoCommonData.selectedIndex.add(Integer.valueOf(paramInt));
        this.mPhotoCommonData.selectedMediaInfoHashMap.put(localLocalMediaInfo.path, localLocalMediaInfo);
        paramView = (LinkedHashMap)AlbumUtil.sSelectItemPosMap.get(this.mPhotoCommonData.albumId);
        if (paramView == null)
        {
          paramView = new LinkedHashMap();
          AlbumUtil.sSelectItemPosMap.put(this.mPhotoCommonData.albumId, paramView);
        }
        break;
      }
    }
    for (;;)
    {
      paramView.put(localLocalMediaInfo.path, Integer.valueOf(((NewPhotoListActivity)this.mActivity).gridLayoutManager.findFirstVisibleItemPosition()));
      paramView = AlbumUtil.sSelectItemAlbum;
      if (!paramView.containsKey(localLocalMediaInfo.path))
      {
        Pair localPair = new Pair(this.mPhotoCommonData.albumId, this.mPhotoCommonData.albumName);
        paramView.put(localLocalMediaInfo.path, localPair);
      }
      g();
      return;
      QQToast.a(this.mActivity, String.format(anvx.a(2131689750), new Object[] { Integer.valueOf(2) }), 0).b(((NewPhotoListActivity)this.mActivity).mTitleBarHeight);
      return;
      QQToast.a(this.mActivity, anvx.a(2131689761), 0).b(((NewPhotoListActivity)this.mActivity).mTitleBarHeight);
      return;
      QQToast.a(this.mActivity, anvx.a(2131689762), 0).b(((NewPhotoListActivity)this.mActivity).mTitleBarHeight);
      return;
      QQToast.a(this.mActivity, anvx.a(2131689760), 0).b(((NewPhotoListActivity)this.mActivity).mTitleBarHeight);
      return;
      QQToast.a(this.mActivity, anvx.a(2131689763), 0).b(((NewPhotoListActivity)this.mActivity).mTitleBarHeight);
      return;
      QQToast.a(this.mActivity, anvx.a(2131689759), 0).b(((NewPhotoListActivity)this.mActivity).mTitleBarHeight);
      return;
    }
  }
  
  public void initData(Intent paramIntent)
  {
    bnky.b();
    this.mPhotoCommonData.needMediaInfo = true;
    super.initData(paramIntent);
    int i = bnlb.y.a();
    if (bnlb.k(((NewPhotoListActivity)this.mActivity).getIntent())) {
      i = bnlb.A.a();
    }
    for (;;)
    {
      bnqq.a().a(i, null);
      String str2 = ((NewPhotoListActivity)this.mActivity).getIntent().getStringExtra("intent_key_uid_for_report");
      String str1 = str2;
      if (TextUtils.isEmpty(str2))
      {
        str1 = bofz.a().getCurrentAccountUin();
        ((NewPhotoListActivity)this.mActivity).getIntent().putExtra("intent_key_uid_for_report", str1);
      }
      bnqq.a().a(str1);
      bnqq.a().b();
      bnqq.a().a();
      bnqq.a().b(bnjq.a(null));
      str1 = ((NewPhotoListActivity)this.mActivity).getIntent().getStringExtra("albumName");
      str2 = ((NewPhotoListActivity)this.mActivity).getIntent().getStringExtra("albumId");
      if ((!TextUtils.isEmpty(str2)) && (!TextUtils.isEmpty(str1)))
      {
        this.mPhotoCommonData.albumName = str1;
        this.mPhotoCommonData.albumId = str2;
      }
      this.e = ((NewPhotoListActivity)this.mActivity).getIntent().getIntExtra("BUNDLE_KEY_CIRCLE_HAS_PICKED_NUM", 0);
      this.jdField_a_of_type_Boolean = ((NewPhotoListActivity)this.mActivity).getIntent().getBooleanExtra("BUNDLE_KEY_CIRCLE_CAN_PICK_VIDEO", false);
      bnrh.a("PhotoListLogicAECircle", "[AdditionalPick] initData---initialHasPickedNum=" + this.e + ", canPickVideo=" + this.jdField_a_of_type_Boolean);
      this.b = 3000;
      this.c = 3000;
      this.d = 60000;
      if (!TextUtils.isEmpty(paramIntent.getStringExtra("qq_camera_from_qcircle_scheme"))) {
        QQToast.a(this.mActivity, 0, anvx.a(2131689669), 1).a();
      }
      return;
    }
  }
  
  public void onCheckBoxClick(View paramView, int paramInt, CheckBox paramCheckBox)
  {
    LocalMediaInfo localLocalMediaInfo = ((NewPhotoListActivity)this.mActivity).photoListAdapter.getItem(paramInt);
    int i = AlbumUtil.getMediaType(localLocalMediaInfo);
    if (localLocalMediaInfo.selectStatus != 1) {
      if (this.jdField_a_of_type_Int == 1)
      {
        if (this.mPhotoCommonData.selectedPhotoList.size() == 1)
        {
          if (i == 0) {
            QQToast.a(this.mActivity, anvx.a(2131689759), 0).b(((NewPhotoListActivity)this.mActivity).mTitleBarHeight);
          }
          return;
        }
        if (this.mPhotoCommonData.selectedPhotoList.size() == 0) {
          if (i == 0) {
            this.jdField_a_of_type_Int = 0;
          }
        }
      }
    }
    for (;;)
    {
      super.onCheckBoxClick(paramView, paramInt, paramCheckBox);
      return;
      bnrh.d("PhotoListLogicAECircle", "[error] size > 1 && mDataType = video");
      continue;
      if (this.jdField_a_of_type_Int == 0)
      {
        if (i == 0)
        {
          if (((NewPhotoListActivity)this.mActivity).isGif(localLocalMediaInfo))
          {
            QQToast.a(this.mActivity, anvx.a(2131689757), 0).b(((NewPhotoListActivity)this.mActivity).mTitleBarHeight);
            return;
          }
          if ((localLocalMediaInfo.mediaWidth < 20) || (localLocalMediaInfo.mediaHeight < 20))
          {
            QQToast.a(this.mActivity, anvx.a(2131689751), 0).b(((NewPhotoListActivity)this.mActivity).mTitleBarHeight);
            return;
          }
          if (this.mPhotoCommonData.selectedPhotoList.size() + this.e >= 9)
          {
            paramView = BaseApplicationImpl.sApplication.getResources().getString(2131689758, new Object[] { Integer.valueOf(9 - this.e) });
            QQToast.a(this.mActivity, paramView, 0).b(((NewPhotoListActivity)this.mActivity).mTitleBarHeight);
          }
        }
      }
      else
      {
        bnrh.d("PhotoListLogicAECircle", "[error] no know mDataType~");
        continue;
        if (this.jdField_a_of_type_Int == 1) {
          this.jdField_a_of_type_Int = 0;
        } else if (this.jdField_a_of_type_Int != 0) {
          bnrh.d("PhotoListLogicAECircle", "[error] no know mDataType~");
        }
      }
    }
  }
  
  public boolean onQueryPhoto(List<LocalMediaInfo> paramList)
  {
    return super.onQueryPhoto(paramList);
  }
  
  public void onSendBtnClick(View paramView)
  {
    ((NewPhotoListActivity)this.mActivity).sendBtn.setClickable(false);
    g();
  }
  
  public void onTitleBtnCancelClick(View paramView)
  {
    AlbumUtil.clearSelectItemInfo();
    AlbumUtil.clearCache();
    paramView = PresendPicMgr.a();
    if (paramView != null) {
      paramView.a(1006);
    }
    paramView = ((NewPhotoListActivity)this.mActivity).getIntent();
    int i;
    if (this.mPhotoCommonData.selectedPhotoList != null)
    {
      i = this.mPhotoCommonData.selectedPhotoList.size();
      aklj.b(paramView, i);
      if (this.jdField_a_of_type_Akmi.i) {
        break label118;
      }
      if (((akmq)this.mOtherCommonData).a()) {
        yzz.a().a(yzz.a().c());
      }
      ((NewPhotoListActivity)this.mActivity).finish();
      AlbumUtil.anim(this.mActivity, false, false);
    }
    label118:
    String str1;
    String str2;
    do
    {
      return;
      i = 0;
      break;
      paramView = ((NewPhotoListActivity)this.mActivity).getIntent();
      str1 = paramView.getStringExtra("PhotoConst.INIT_ACTIVITY_CLASS_NAME");
      str2 = paramView.getStringExtra("PhotoConst.INIT_ACTIVITY_PACKAGE_NAME");
    } while (str1 == null);
    paramView.setClassName(str2, str1);
    paramView.removeExtra("PhotoConst.PHOTO_PATHS");
    paramView.removeExtra("PhotoConst.SINGLE_PHOTO_PATH");
    paramView.addFlags(603979776);
    if (!paramView.getBooleanExtra("PhotoConst.IS_CALL_IN_PLUGIN", false)) {
      ((NewPhotoListActivity)this.mActivity).startActivity(paramView);
    }
    for (;;)
    {
      ((NewPhotoListActivity)this.mActivity).finish();
      AlbumUtil.anim(this.mActivity, false, false);
      return;
      paramView.getStringExtra("PhotoConst.PLUGIN_NAME");
      str2 = paramView.getStringExtra("PhotoConst.PLUGIN_APK");
      String str3 = paramView.getStringExtra("PhotoConst.UIN");
      if ("qzone_plugin.apk".equals(str2))
      {
        QzonePluginProxyActivity.setActivityNameToIntent(paramView, str1);
        QZoneHelper.launchQZone(this.mActivity, str3, paramView, 2);
      }
    }
  }
  
  public void postInitUI()
  {
    super.postInitUI();
  }
  
  public void updateButton()
  {
    super.updateButton();
    String str = ((NewPhotoListActivity)this.mActivity).getString(2131716437);
    int i = this.mPhotoCommonData.selectedPhotoList.size();
    str = str + " " + i + "/" + (this.mPhotoCommonData.maxSelectNum - this.e);
    ((NewPhotoListActivity)this.mActivity).sendBtn.setText(str);
    if (i == 0)
    {
      ((NewPhotoListActivity)this.mActivity).sendBtn.setBackgroundResource(2130849779);
      ((NewPhotoListActivity)this.mActivity).sendBtn.setEnabled(false);
      return;
    }
    ((NewPhotoListActivity)this.mActivity).sendBtn.setBackgroundResource(2130837999);
    ((NewPhotoListActivity)this.mActivity).sendBtn.setEnabled(true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     akno
 * JD-Core Version:    0.7.0.1
 */