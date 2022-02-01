import android.app.Dialog;
import android.content.Intent;
import android.media.MediaMetadataRetriever;
import android.support.v7.widget.GridLayoutManager;
import android.text.TextUtils;
import android.util.Pair;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.activity.photo.album.AbstractPhotoListActivity.PhotoListAdapter;
import com.tencent.mobileqq.activity.photo.album.NewPhotoListActivity;
import com.tencent.mobileqq.activity.photo.album.PhotoCommonBaseData;
import com.tencent.mobileqq.pic.PresendPicMgr;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.inject.dialog.ReportDialog;
import cooperation.qzone.QzonePluginProxyActivity;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;

public class akiy
  extends akhu
{
  private static final String[] jdField_a_of_type_ArrayOfJavaLangString = { "video/mp4", "video/3gpp" };
  private int jdField_a_of_type_Int = 0;
  private Dialog jdField_a_of_type_AndroidAppDialog;
  private int b = 3000;
  private int c = 3000;
  private int d = 3600000;
  
  public akiy(NewPhotoListActivity paramNewPhotoListActivity)
  {
    super(paramNewPhotoListActivity);
    bnzb.a("PhotoListLogicAECircle", "[AE Profiler] PhotoListLogicAECircle new");
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
        this.jdField_a_of_type_AndroidAppDialog = new ReportDialog(this.mActivity, 2131755823);
        this.jdField_a_of_type_AndroidAppDialog.setCancelable(false);
        this.jdField_a_of_type_AndroidAppDialog.setCanceledOnTouchOutside(false);
        this.jdField_a_of_type_AndroidAppDialog.setContentView(2131559567);
      }
      this.jdField_a_of_type_AndroidAppDialog.show();
    }
    label81:
    while ((this.jdField_a_of_type_AndroidAppDialog == null) || (!this.jdField_a_of_type_AndroidAppDialog.isShowing())) {
      return;
    }
    this.jdField_a_of_type_AndroidAppDialog.dismiss();
  }
  
  private void f()
  {
    boiv.a(this.jdField_a_of_type_Int, this.mActivity, this.mPhotoCommonData, false);
    ((NewPhotoListActivity)this.mActivity).finish();
    a(false);
  }
  
  public boolean addAndRemovePhotoByGesture(LocalMediaInfo paramLocalMediaInfo, boolean paramBoolean)
  {
    if (((NewPhotoListActivity)this.mActivity).isGif(paramLocalMediaInfo))
    {
      QQToast.a(this.mActivity, anni.a(2131689731), 0).b(((NewPhotoListActivity)this.mActivity).mTitleBarHeight);
      return false;
    }
    return super.addAndRemovePhotoByGesture(paramLocalMediaInfo, paramBoolean);
  }
  
  public Intent caseNoSingModeImage(View paramView, int paramInt)
  {
    paramView = super.caseNoSingModeImage(paramView, paramInt);
    paramView.putExtra("choosed_num", this.mPhotoCommonData.selectedPhotoList.size());
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
      if (bgkc.getMediaType(localLocalMediaInfo2) != 0) {
        break label264;
      }
      localArrayList1.add(str);
      if ((this.mPhotoCommonData.selectedPhotoList != null) && (this.mPhotoCommonData.selectedPhotoList.contains(str))) {
        localArrayList2.add(Integer.valueOf(j));
      }
      if (localLocalMediaInfo2.position.intValue() != paramInt) {
        break label261;
      }
      i = j;
      label186:
      j += 1;
    }
    label261:
    label264:
    for (;;)
    {
      k += 1;
      break;
      this.mPhotoCommonData.mediaPathsList = localArrayList1;
      paramView.putStringArrayListExtra("PhotoConst.PHOTO_PATHS", localArrayList1);
      paramView.putStringArrayListExtra("PhotoConst.SELECTED_PATHS", this.mPhotoCommonData.selectedPhotoList);
      paramView.putIntegerArrayListExtra("PhotoConst.SELECTED_INDEXS", localArrayList2);
      if (bgkc.getMediaType(localLocalMediaInfo1) == 0) {
        paramView.putExtra("PhotoConst.CURRENT_SELECTED_INDEX", i);
      }
      return paramView;
      break label186;
    }
  }
  
  public void caseVideo(View paramView, int paramInt)
  {
    LocalMediaInfo localLocalMediaInfo;
    if (this.mPhotoCommonData.selectedPhotoList.size() == 0)
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
        paramView = (LinkedHashMap)bgkc.sSelectItemPosMap.get(this.mPhotoCommonData.albumId);
        if (paramView == null)
        {
          paramView = new LinkedHashMap();
          bgkc.sSelectItemPosMap.put(this.mPhotoCommonData.albumId, paramView);
        }
        break;
      }
    }
    for (;;)
    {
      paramView.put(localLocalMediaInfo.path, Integer.valueOf(((NewPhotoListActivity)this.mActivity).gridLayoutManager.findFirstVisibleItemPosition()));
      paramView = bgkc.sSelectItemAlbum;
      if (!paramView.containsKey(localLocalMediaInfo.path))
      {
        Pair localPair = new Pair(this.mPhotoCommonData.albumId, this.mPhotoCommonData.albumName);
        paramView.put(localLocalMediaInfo.path, localPair);
      }
      f();
      return;
      QQToast.a(this.mActivity, String.format(anni.a(2131689727), new Object[] { Integer.valueOf(2) }), 0).b(((NewPhotoListActivity)this.mActivity).mTitleBarHeight);
      return;
      QQToast.a(this.mActivity, anni.a(2131689736), 0).b(((NewPhotoListActivity)this.mActivity).mTitleBarHeight);
      return;
      QQToast.a(this.mActivity, anni.a(2131689737), 0).b(((NewPhotoListActivity)this.mActivity).mTitleBarHeight);
      return;
      QQToast.a(this.mActivity, anni.a(2131689735), 0).b(((NewPhotoListActivity)this.mActivity).mTitleBarHeight);
      return;
      QQToast.a(this.mActivity, anni.a(2131689738), 0).b(((NewPhotoListActivity)this.mActivity).mTitleBarHeight);
      return;
      QQToast.a(this.mActivity, anni.a(2131689733), 0).b(((NewPhotoListActivity)this.mActivity).mTitleBarHeight);
      return;
    }
  }
  
  public void initData(Intent paramIntent)
  {
    bnpy.b();
    this.mPhotoCommonData.needMediaInfo = true;
    super.initData(paramIntent);
    int i = bnqb.y.a();
    if (bnqb.k(((NewPhotoListActivity)this.mActivity).getIntent())) {
      i = bnqb.A.a();
    }
    for (;;)
    {
      bnyl.a().a(i, null);
      String str2 = ((NewPhotoListActivity)this.mActivity).getIntent().getStringExtra("intent_key_uid_for_report");
      String str1 = str2;
      if (TextUtils.isEmpty(str2))
      {
        str1 = bojl.a().getCurrentAccountUin();
        ((NewPhotoListActivity)this.mActivity).getIntent().putExtra("intent_key_uid_for_report", str1);
      }
      bnyl.a().a(str1);
      bnyl.a().b();
      bnyl.a().a();
      bnyl.a().b(bnov.a(null));
      str1 = ((NewPhotoListActivity)this.mActivity).getIntent().getStringExtra("albumName");
      str2 = ((NewPhotoListActivity)this.mActivity).getIntent().getStringExtra("albumId");
      if ((!TextUtils.isEmpty(str2)) && (!TextUtils.isEmpty(str1)))
      {
        this.mPhotoCommonData.albumName = str1;
        this.mPhotoCommonData.albumId = str2;
      }
      this.b = 3000;
      this.c = 3000;
      this.d = 60000;
      if (!TextUtils.isEmpty(paramIntent.getStringExtra("qq_camera_from_qcircle_scheme"))) {
        QQToast.a(this.mActivity, 0, anni.a(2131689668), 1).a();
      }
      return;
    }
  }
  
  public void onCheckBoxClick(View paramView, int paramInt, CheckBox paramCheckBox)
  {
    LocalMediaInfo localLocalMediaInfo = ((NewPhotoListActivity)this.mActivity).photoListAdapter.getItem(paramInt);
    int i = bgkc.getMediaType(localLocalMediaInfo);
    if (localLocalMediaInfo.selectStatus != 1) {
      if (this.jdField_a_of_type_Int == 1)
      {
        if (this.mPhotoCommonData.selectedPhotoList.size() == 1)
        {
          if (i == 0) {
            QQToast.a(this.mActivity, anni.a(2131689733), 0).b(((NewPhotoListActivity)this.mActivity).mTitleBarHeight);
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
      bnzb.d("PhotoListLogicAECircle", "[error] size > 1 && mDataType = video");
      continue;
      if (this.jdField_a_of_type_Int == 0)
      {
        if (i == 0)
        {
          if (((NewPhotoListActivity)this.mActivity).isGif(localLocalMediaInfo))
          {
            QQToast.a(this.mActivity, anni.a(2131689731), 0).b(((NewPhotoListActivity)this.mActivity).mTitleBarHeight);
            return;
          }
          if ((localLocalMediaInfo.mediaWidth < 20) || (localLocalMediaInfo.mediaHeight < 20))
          {
            QQToast.a(this.mActivity, anni.a(2131689728), 0).b(((NewPhotoListActivity)this.mActivity).mTitleBarHeight);
            return;
          }
          if (this.mPhotoCommonData.selectedPhotoList.size() >= 9) {
            QQToast.a(this.mActivity, anni.a(2131689732), 0).b(((NewPhotoListActivity)this.mActivity).mTitleBarHeight);
          }
        }
      }
      else
      {
        bnzb.d("PhotoListLogicAECircle", "[error] no know mDataType~");
        continue;
        if (this.jdField_a_of_type_Int == 1) {
          this.jdField_a_of_type_Int = 0;
        } else if (this.jdField_a_of_type_Int != 0) {
          bnzb.d("PhotoListLogicAECircle", "[error] no know mDataType~");
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
    f();
  }
  
  public void onTitleBtnCancelClick(View paramView)
  {
    bgkc.clearSelectItemInfo();
    bgkc.a();
    paramView = PresendPicMgr.a();
    if (paramView != null) {
      paramView.a(1006);
    }
    paramView = ((NewPhotoListActivity)this.mActivity).getIntent();
    if (this.mPhotoCommonData.selectedPhotoList != null) {}
    for (int i = this.mPhotoCommonData.selectedPhotoList.size();; i = 0)
    {
      akgm.b(paramView, i);
      if (this.jdField_a_of_type_Akht.i) {
        break;
      }
      if (((akib)this.mOtherCommonData).a()) {
        zgl.a().a(zgl.a().c());
      }
      ((NewPhotoListActivity)this.mActivity).finish();
      bgkc.anim(this.mActivity, false, false);
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
    if (!paramView.getBooleanExtra("PhotoConst.IS_CALL_IN_PLUGIN", false)) {
      ((NewPhotoListActivity)this.mActivity).startActivity(paramView);
    }
    for (;;)
    {
      ((NewPhotoListActivity)this.mActivity).finish();
      bgkc.anim(this.mActivity, false, false);
      return;
      paramView.getStringExtra("PhotoConst.PLUGIN_NAME");
      str2 = paramView.getStringExtra("PhotoConst.PLUGIN_APK");
      String str3 = paramView.getStringExtra("PhotoConst.UIN");
      if ("qzone_plugin.apk".equals(str2))
      {
        QzonePluginProxyActivity.a(paramView, str1);
        blsb.a(this.mActivity, str3, paramView, 2);
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
    String str = ((NewPhotoListActivity)this.mActivity).getString(2131715745);
    int i = this.mPhotoCommonData.selectedPhotoList.size();
    str = str + " " + i + "/" + this.mPhotoCommonData.maxSelectNum;
    ((NewPhotoListActivity)this.mActivity).sendBtn.setText(str);
    if (i == 0)
    {
      ((NewPhotoListActivity)this.mActivity).sendBtn.setBackgroundResource(2130849758);
      ((NewPhotoListActivity)this.mActivity).sendBtn.setEnabled(false);
      return;
    }
    ((NewPhotoListActivity)this.mActivity).sendBtn.setBackgroundResource(2130837953);
    ((NewPhotoListActivity)this.mActivity).sendBtn.setEnabled(true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     akiy
 * JD-Core Version:    0.7.0.1
 */