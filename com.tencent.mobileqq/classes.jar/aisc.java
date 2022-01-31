import android.app.Dialog;
import android.content.Intent;
import android.media.MediaMetadataRetriever;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Pair;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.activity.photo.album.AbstractPhotoListActivity.PhotoListAdapter;
import com.tencent.mobileqq.activity.photo.album.NewPhotoListActivity;
import com.tencent.mobileqq.pic.PresendPicMgr;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.AdapterView;
import com.tencent.widget.GestureSelectGridView;
import cooperation.qzone.QzonePluginProxyActivity;
import dov.com.qq.im.ae.camera.core.AECircleBroadcastReceiver;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;

public class aisc
  extends aira
  implements bksu
{
  private static final String[] jdField_a_of_type_ArrayOfJavaLangString = { "video/mp4", "video/3gpp" };
  private int jdField_a_of_type_Int = 0;
  private Dialog jdField_a_of_type_AndroidAppDialog;
  private AECircleBroadcastReceiver jdField_a_of_type_DovComQqImAeCameraCoreAECircleBroadcastReceiver = new AECircleBroadcastReceiver(this);
  private String jdField_a_of_type_JavaLangString;
  private boolean jdField_a_of_type_Boolean;
  private int jdField_b_of_type_Int = 3000;
  private boolean jdField_b_of_type_Boolean = true;
  private int c = 3000;
  private int d = 3600000;
  
  public aisc(NewPhotoListActivity paramNewPhotoListActivity)
  {
    super(paramNewPhotoListActivity);
    bljn.a("PhotoListLogicAECircle", "[AE Profiler] PhotoListLogicAECircle new");
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
      int j = Integer.parseInt(localMediaMetadataRetriever.extractMetadata(19));
      int i = Integer.parseInt(localMediaMetadataRetriever.extractMetadata(18));
      paramLocalMediaInfo = localMediaMetadataRetriever.extractMetadata(12);
      if (j <= this.c)
      {
        j = this.jdField_b_of_type_Int;
        if (i <= j) {}
      }
      else
      {
        return 2;
      }
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
        this.jdField_a_of_type_AndroidAppDialog = new Dialog(this.mActivity, 2131755801);
        this.jdField_a_of_type_AndroidAppDialog.setCancelable(false);
        this.jdField_a_of_type_AndroidAppDialog.setCanceledOnTouchOutside(false);
        this.jdField_a_of_type_AndroidAppDialog.setContentView(2131559437);
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
    if ((this.jdField_a_of_type_JavaLangString == null) && (Build.VERSION.SDK_INT >= 21) && (this.jdField_b_of_type_Boolean))
    {
      if (!bdin.a())
      {
        QQToast.a(this.mActivity, alud.a(2131689825), 0).b(((NewPhotoListActivity)this.mActivity).mTitleBarHeight);
        return;
      }
      this.jdField_a_of_type_Boolean = true;
      a(true);
      return;
    }
    blpw.a(this.jdField_a_of_type_Int, this.mActivity, this.mPhotoCommonData, this.jdField_a_of_type_JavaLangString, this.jdField_b_of_type_Boolean);
    ((NewPhotoListActivity)this.mActivity).finish();
    this.jdField_a_of_type_DovComQqImAeCameraCoreAECircleBroadcastReceiver.b(this.mActivity);
    a(false);
  }
  
  public void a(String paramString)
  {
    this.jdField_a_of_type_JavaLangString = azkt.c(this.mActivity);
    if (this.jdField_a_of_type_Boolean) {
      g();
    }
  }
  
  public boolean addAndRemovePhotoByGesture(LocalMediaInfo paramLocalMediaInfo, boolean paramBoolean)
  {
    if (((NewPhotoListActivity)this.mActivity).isGif(paramLocalMediaInfo))
    {
      QQToast.a(this.mActivity, alud.a(2131689826), 0).b(((NewPhotoListActivity)this.mActivity).mTitleBarHeight);
      return false;
    }
    return super.addAndRemovePhotoByGesture(paramLocalMediaInfo, paramBoolean);
  }
  
  public Intent caseNoSingModeImage(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    paramAdapterView = super.caseNoSingModeImage(paramAdapterView, paramView, paramInt, paramLong);
    paramAdapterView.putExtra("choosed_num", this.mPhotoCommonData.selectedPhotoList.size());
    paramAdapterView.putExtra("res_path", this.jdField_a_of_type_JavaLangString);
    paramAdapterView.putExtra("isneed_edit", this.jdField_b_of_type_Boolean);
    paramView = ((NewPhotoListActivity)this.mActivity).photoListAdapter.getItem(paramInt);
    ArrayList localArrayList1 = new ArrayList();
    ArrayList localArrayList2 = new ArrayList();
    int j = 0;
    int m = this.mPhotoCommonData.mediaPathsList.size();
    int k = 0;
    int i = paramInt;
    if (k < m)
    {
      String str = (String)this.mPhotoCommonData.mediaPathsList.get(k);
      LocalMediaInfo localLocalMediaInfo = (LocalMediaInfo)this.mPhotoCommonData.allMediaInfoHashMap.get(str);
      if (bdfa.getMediaType(localLocalMediaInfo) != 0) {
        break label293;
      }
      localArrayList1.add(str);
      if ((this.mPhotoCommonData.selectedPhotoList != null) && (this.mPhotoCommonData.selectedPhotoList.contains(str))) {
        localArrayList2.add(Integer.valueOf(j));
      }
      if (localLocalMediaInfo.position.intValue() != paramInt) {
        break label290;
      }
      i = j;
      label212:
      j += 1;
    }
    label290:
    label293:
    for (;;)
    {
      k += 1;
      break;
      this.mPhotoCommonData.mediaPathsList = localArrayList1;
      paramAdapterView.putStringArrayListExtra("PhotoConst.PHOTO_PATHS", localArrayList1);
      paramAdapterView.putStringArrayListExtra("PhotoConst.SELECTED_PATHS", this.mPhotoCommonData.selectedPhotoList);
      paramAdapterView.putIntegerArrayListExtra("PhotoConst.SELECTED_INDEXS", localArrayList2);
      if (bdfa.getMediaType(paramView) == 0) {
        paramAdapterView.putExtra("PhotoConst.CURRENT_SELECTED_INDEX", i);
      }
      return paramAdapterView;
      break label212;
    }
  }
  
  public void caseVideo(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    if (this.mPhotoCommonData.selectedPhotoList.size() == 0)
    {
      paramView = ((NewPhotoListActivity)this.mActivity).photoListAdapter.getItem(paramInt);
      switch (a(paramView))
      {
      default: 
        return;
      case 0: 
        this.jdField_a_of_type_Int = 1;
        this.mPhotoCommonData.selectedPhotoList.add(paramView.path);
        this.mPhotoCommonData.selectedIndex.add(Integer.valueOf(paramInt));
        this.mPhotoCommonData.selectedMediaInfoHashMap.put(paramView.path, paramView);
        paramAdapterView = (LinkedHashMap)bdfa.sSelectItemPosMap.get(this.mPhotoCommonData.albumId);
        if (paramAdapterView == null)
        {
          paramAdapterView = new LinkedHashMap();
          bdfa.sSelectItemPosMap.put(this.mPhotoCommonData.albumId, paramAdapterView);
        }
        break;
      }
    }
    for (;;)
    {
      paramAdapterView.put(paramView.path, Integer.valueOf(((NewPhotoListActivity)this.mActivity).mGridView.getFirstVisiblePosition()));
      paramAdapterView = bdfa.sSelectItemAlbum;
      if (!paramAdapterView.containsKey(paramView.path))
      {
        Pair localPair = new Pair(this.mPhotoCommonData.albumId, this.mPhotoCommonData.albumName);
        paramAdapterView.put(paramView.path, localPair);
      }
      g();
      return;
      QQToast.a(this.mActivity, String.format(alud.a(2131689822), new Object[] { Integer.valueOf(2) }), 0).b(((NewPhotoListActivity)this.mActivity).mTitleBarHeight);
      return;
      QQToast.a(this.mActivity, alud.a(2131689831), 0).b(((NewPhotoListActivity)this.mActivity).mTitleBarHeight);
      return;
      QQToast.a(this.mActivity, alud.a(2131689832), 0).b(((NewPhotoListActivity)this.mActivity).mTitleBarHeight);
      return;
      QQToast.a(this.mActivity, alud.a(2131689830), 0).b(((NewPhotoListActivity)this.mActivity).mTitleBarHeight);
      return;
      QQToast.a(this.mActivity, alud.a(2131689833), 0).b(((NewPhotoListActivity)this.mActivity).mTitleBarHeight);
      return;
      QQToast.a(this.mActivity, alud.a(2131689828), 0).b(((NewPhotoListActivity)this.mActivity).mTitleBarHeight);
      return;
    }
  }
  
  public void initData(Intent paramIntent)
  {
    this.jdField_a_of_type_DovComQqImAeCameraCoreAECircleBroadcastReceiver.a(this.mActivity);
    azjs.a().a("CMD_DOWNLOAD_PTU_BASE_RES", new Bundle());
    this.mPhotoCommonData.needMediaInfo = true;
    super.initData(paramIntent);
    int i = blat.y.a();
    if (blat.j(((NewPhotoListActivity)this.mActivity).getIntent())) {
      i = blat.A.a();
    }
    for (;;)
    {
      bliy.a().a(i, null);
      String str = ((NewPhotoListActivity)this.mActivity).getIntent().getStringExtra("intent_key_uid_for_report");
      paramIntent = str;
      if (TextUtils.isEmpty(str))
      {
        paramIntent = blqh.a().getCurrentAccountUin();
        ((NewPhotoListActivity)this.mActivity).getIntent().putExtra("intent_key_uid_for_report", paramIntent);
      }
      bliy.a().a(paramIntent);
      bliy.a().b();
      bliy.a().a();
      bliy.a().b(bkzr.a(null));
      paramIntent = ((NewPhotoListActivity)this.mActivity).getIntent().getStringExtra("albumName");
      str = ((NewPhotoListActivity)this.mActivity).getIntent().getStringExtra("albumId");
      if ((!TextUtils.isEmpty(str)) && (!TextUtils.isEmpty(paramIntent)))
      {
        this.mPhotoCommonData.albumName = paramIntent;
        this.mPhotoCommonData.albumId = str;
      }
      this.jdField_b_of_type_Boolean = ((NewPhotoListActivity)this.mActivity).getIntent().getBooleanExtra("isneed_edit", this.jdField_b_of_type_Boolean);
      this.jdField_b_of_type_Int = 3000;
      this.c = 3000;
      this.d = 60000;
      return;
    }
  }
  
  public void onCheckBoxClick(View paramView, int paramInt, CheckBox paramCheckBox)
  {
    LocalMediaInfo localLocalMediaInfo = ((NewPhotoListActivity)this.mActivity).photoListAdapter.getItem(paramInt);
    int i = bdfa.getMediaType(localLocalMediaInfo);
    if (localLocalMediaInfo.selectStatus != 1) {
      if (this.jdField_a_of_type_Int == 1)
      {
        if (this.mPhotoCommonData.selectedPhotoList.size() == 1)
        {
          if (i == 0) {
            QQToast.a(this.mActivity, alud.a(2131689828), 0).b(((NewPhotoListActivity)this.mActivity).mTitleBarHeight);
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
      bljn.d("PhotoListLogicAECircle", "[error] size > 1 && mDataType = video");
      continue;
      if (this.jdField_a_of_type_Int == 0)
      {
        if (i == 0)
        {
          if (((NewPhotoListActivity)this.mActivity).isGif(localLocalMediaInfo))
          {
            QQToast.a(this.mActivity, alud.a(2131689826), 0).b(((NewPhotoListActivity)this.mActivity).mTitleBarHeight);
            return;
          }
          if ((localLocalMediaInfo.mediaWidth < 20) || (localLocalMediaInfo.mediaHeight < 20))
          {
            QQToast.a(this.mActivity, alud.a(2131689823), 0).b(((NewPhotoListActivity)this.mActivity).mTitleBarHeight);
            return;
          }
          if (this.mPhotoCommonData.selectedPhotoList.size() >= 9) {
            QQToast.a(this.mActivity, alud.a(2131689827), 0).b(((NewPhotoListActivity)this.mActivity).mTitleBarHeight);
          }
        }
      }
      else
      {
        bljn.d("PhotoListLogicAECircle", "[error] no know mDataType~");
        continue;
        if (this.jdField_a_of_type_Int == 1) {
          this.jdField_a_of_type_Int = 0;
        } else if (this.jdField_a_of_type_Int != 0) {
          bljn.d("PhotoListLogicAECircle", "[error] no know mDataType~");
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
    this.jdField_a_of_type_DovComQqImAeCameraCoreAECircleBroadcastReceiver.b(this.mActivity);
    bdfa.clearSelectItemInfo();
    bdfa.a();
    paramView = PresendPicMgr.a();
    if (paramView != null) {
      paramView.a(1006);
    }
    paramView = ((NewPhotoListActivity)this.mActivity).getIntent();
    if (this.mPhotoCommonData.selectedPhotoList != null) {}
    for (int i = this.mPhotoCommonData.selectedPhotoList.size();; i = 0)
    {
      aips.b(paramView, i);
      if (this.jdField_a_of_type_Aiqz.i) {
        break;
      }
      if (this.mPhotoCommonData.a()) {
        xna.a().a(xna.a().c());
      }
      ((NewPhotoListActivity)this.mActivity).finish();
      bdfa.anim(this.mActivity, false, false);
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
      bdfa.anim(this.mActivity, false, false);
      return;
      paramView.getStringExtra("PhotoConst.PLUGIN_NAME");
      str2 = paramView.getStringExtra("PhotoConst.PLUGIN_APK");
      String str3 = paramView.getStringExtra("PhotoConst.UIN");
      if ("qzone_plugin.apk".equals(str2))
      {
        QzonePluginProxyActivity.a(paramView, str1);
        bjdt.a(this.mActivity, str3, paramView, 2);
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
    String str = ((NewPhotoListActivity)this.mActivity).getString(2131717497);
    int i = this.mPhotoCommonData.selectedPhotoList.size();
    str = str + " " + i + "/" + this.mPhotoCommonData.maxSelectNum;
    ((NewPhotoListActivity)this.mActivity).sendBtn.setText(str);
    if (i == 0)
    {
      ((NewPhotoListActivity)this.mActivity).sendBtn.setBackgroundResource(2130849207);
      ((NewPhotoListActivity)this.mActivity).sendBtn.setEnabled(false);
      return;
    }
    ((NewPhotoListActivity)this.mActivity).sendBtn.setBackgroundResource(2130837724);
    ((NewPhotoListActivity)this.mActivity).sendBtn.setEnabled(true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aisc
 * JD-Core Version:    0.7.0.1
 */