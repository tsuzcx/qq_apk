import NS_MOBILE_OPERATION.PicInfo;
import android.app.Dialog;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.component.media.image.ImageManager;
import com.tencent.component.network.utils.NetworkUtils;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.activity.photo.PhotoSendParams;
import com.tencent.mobileqq.activity.photo.PhotoUtils;
import com.tencent.mobileqq.activity.photo.SendPhotoActivity;
import com.tencent.mobileqq.activity.photo.album.AbstractPhotoPreviewActivity;
import com.tencent.mobileqq.activity.photo.album.AbstractPhotoPreviewActivity.ImageAdapter;
import com.tencent.mobileqq.activity.photo.album.NewPhotoPreviewActivity;
import com.tencent.mobileqq.activity.photo.album.logicImp.PhotoPreviewLogicAIO.2;
import com.tencent.mobileqq.activity.shortvideo.SendVideoActivity.SendVideoInfo;
import com.tencent.mobileqq.pic.PresendPicMgr;
import com.tencent.mobileqq.widget.NumberCheckBox;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.BinderWarpper;
import com.tencent.util.Pair;
import com.tencent.widget.AdapterView;
import cooperation.qzone.report.lp.LpReportInfo_pf00064;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;

public class aitg
  extends airj
{
  private bdmu a;
  public boolean a;
  boolean b;
  boolean c;
  
  protected aitg(NewPhotoPreviewActivity paramNewPhotoPreviewActivity)
  {
    super(paramNewPhotoPreviewActivity);
    this.jdField_b_of_type_Boolean = false;
    this.jdField_c_of_type_Boolean = false;
  }
  
  void a(int paramInt)
  {
    ((NewPhotoPreviewActivity)this.mActivity).magicStickBtn.setVisibility(paramInt);
    ((NewPhotoPreviewActivity)this.mActivity).qualityCheckBox.setVisibility(paramInt);
    ((NewPhotoPreviewActivity)this.mActivity).qualityTv.setVisibility(paramInt);
    if (paramInt == 0)
    {
      if (!this.jdField_a_of_type_Airg.jdField_b_of_type_Boolean)
      {
        ((NewPhotoPreviewActivity)this.mActivity).qualityCheckBox.setVisibility(8);
        ((NewPhotoPreviewActivity)this.mActivity).qualityTv.setVisibility(8);
      }
      if (!this.jdField_a_of_type_Airg.jdField_c_of_type_Boolean) {
        ((NewPhotoPreviewActivity)this.mActivity).magicStickBtn.setVisibility(8);
      }
      if ((this.jdField_a_of_type_Airg.h) && (this.jdField_a_of_type_Airg.d.size() == 0))
      {
        ((NewPhotoPreviewActivity)this.mActivity).flashPicCb.setVisibility(0);
        ((NewPhotoPreviewActivity)this.mActivity).flashTv.setVisibility(0);
        ((NewPhotoPreviewActivity)this.mActivity).flashPicCb.setOnCheckedChangeListener(this.mActivity);
        ((NewPhotoPreviewActivity)this.mActivity).flashTv.setOnClickListener(new aith(this));
        ((NewPhotoPreviewActivity)this.mActivity).flashPicCb.setContentDescription("闪照");
        ((NewPhotoPreviewActivity)this.mActivity).flashTv.setContentDescription("闪照");
      }
    }
    while (((NewPhotoPreviewActivity)this.mActivity).flashPicCb.getVisibility() != 0) {
      return;
    }
    ((NewPhotoPreviewActivity)this.mActivity).flashPicCb.setVisibility(paramInt);
    ((NewPhotoPreviewActivity)this.mActivity).flashTv.setVisibility(paramInt);
  }
  
  public void a(Intent paramIntent, boolean paramBoolean, ArrayList<String> paramArrayList)
  {
    localPair = new Pair(new ArrayList(), new ArrayList());
    if (this.jdField_a_of_type_Bdmu != null)
    {
      localObject1 = this.jdField_a_of_type_Bdmu;
      if (this.mPhotoCommonData.currentQualityType == 2) {
        bool = true;
      }
    }
    for (;;)
    {
      paramArrayList = ((bdmu)localObject1).a(paramArrayList, bool, this.mPhotoCommonData.selectedMediaInfoHashMap, this.mPhotoCommonData.allMediaInfoHashMap);
      ((ArrayList)localPair.first).addAll((Collection)paramArrayList.first);
      ((ArrayList)localPair.second).addAll((Collection)paramArrayList.second);
      paramIntent.putStringArrayListExtra("PhotoConst.PHOTO_PATHS_BY_FILE", (ArrayList)localPair.second);
      i2 = 0;
      i = -1;
      try
      {
        m = PhotoUtils.b((SessionInfo)paramIntent.getParcelableExtra("session_info"));
        paramArrayList = new HashMap();
        j = 0;
        i = 0;
        int n = 0;
        k = 0;
        for (;;)
        {
          if (n < ((ArrayList)localPair.first).size())
          {
            localObject1 = (String)((ArrayList)localPair.first).get(n);
            if (ImageManager.isNetworkUrl((String)localObject1))
            {
              i1 = k;
              k = i;
              i = i1;
              n += 1;
              i1 = k;
              k = i;
              i = i1;
              continue;
              bool = false;
              break;
              ((ArrayList)localPair.first).addAll(paramArrayList);
            }
          }
        }
      }
      catch (Exception paramArrayList)
      {
        int j;
        int k;
        int i1;
        for (;;)
        {
          m = i;
          if (QLog.isColorLevel())
          {
            QLog.e("PhotoPreviewActivity", 2, "submit", paramArrayList);
            m = i;
          }
        }
        if (((NewPhotoPreviewActivity)this.mActivity).getMediaType((String)localObject1) == 1)
        {
          localObject1 = ((NewPhotoPreviewActivity)this.mActivity).getMediaInfo((String)localObject1);
          localObject2 = new SendVideoActivity.SendVideoInfo();
          i += 1;
          ((SendVideoActivity.SendVideoInfo)localObject2).fileSize = ((LocalMediaInfo)localObject1).fileSize;
          ((SendVideoActivity.SendVideoInfo)localObject2).duration = ((LocalMediaInfo)localObject1).mDuration;
          paramArrayList.put(Integer.valueOf(k), localObject2);
        }
        for (;;)
        {
          i1 = k + 1;
          k = i;
          i = i1;
          break;
          j += 1;
        }
        localObject1 = String.valueOf(j);
        localObject2 = String.valueOf(i);
      }
    }
    try
    {
      paramIntent.setExtrasClassLoader(SessionInfo.class.getClassLoader());
      if (paramArrayList.isEmpty()) {
        break label789;
      }
      paramIntent.putExtra("PhotoConst.VIDEO_INFOS", paramArrayList);
      i = 1;
    }
    catch (Exception paramArrayList)
    {
      for (;;)
      {
        i = i2;
        if (QLog.isColorLevel())
        {
          QLog.d("PhotoPreviewActivity", 2, "put extra Exception");
          i = i2;
          continue;
          bool = false;
          continue;
          if (paramBoolean)
          {
            PhotoUtils.a(this.mActivity, paramIntent, (ArrayList)localPair.first, this.jdField_a_of_type_Airg.jdField_b_of_type_JavaUtilHashMap, this.mPhotoCommonData.currentQualityType, true);
            ((NewPhotoPreviewActivity)this.mActivity).setResult(-1);
            ((NewPhotoPreviewActivity)this.mActivity).finish();
          }
          for (;;)
          {
            azqs.b(null, "CliOper", "", "", "0X8009AB1", "0X8009AB1", m, 0, (String)localObject1, (String)localObject2, "", "");
            return;
            PhotoUtils.a(this.mActivity, paramIntent, (ArrayList)localPair.first, this.mPhotoCommonData.currentQualityType, this.jdField_a_of_type_Airg.jdField_a_of_type_Boolean);
          }
          i = 0;
        }
      }
    }
    if ((azdd.b != 0L) && (System.currentTimeMillis() - azdd.b < 300000L))
    {
      bool = true;
      if (QLog.isColorLevel()) {
        QLog.d("PhotoPreviewActivity", 2, "upload video isConfirmed=" + bool + " allowUploadInXGTime=" + azdd.b);
      }
      if ((!bdin.b(BaseApplicationImpl.getContext())) || (bool) || (i == 0) || (!a())) {
        break label667;
      }
      paramArrayList = ((NewPhotoPreviewActivity)this.mActivity).getResources().getString(2131719750);
      paramIntent = new PhotoPreviewLogicAIO.2(this, paramBoolean, paramIntent, localPair, m, (String)localObject1, (String)localObject2);
      if (bezm.a(this.mActivity, 4, new aiti(this, paramIntent))) {
        bdgm.a(this.mActivity, 232, null, paramArrayList, new aitj(this, paramIntent), new aitk(this)).show();
      }
      if (QLog.isColorLevel()) {
        QLog.i("PhotoPreviewActivity", 2, "show shortvideo_mobile_send_confirm dialog");
      }
    }
  }
  
  protected void a(TextView paramTextView)
  {
    Object localObject = this.mPhotoCommonData.selectedPhotoList.iterator();
    while (((Iterator)localObject).hasNext())
    {
      String str = (String)((Iterator)localObject).next();
      if ((!NetworkUtils.isNetworkUrl(str)) && (((NewPhotoPreviewActivity)this.mActivity).getMediaType(str) == 1)) {
        paramTextView.setText(((NewPhotoPreviewActivity)this.mActivity).getString(2131695277));
      }
    }
    int i = bdfa.a(this.mPhotoCommonData.selectedPhotoList, this.mPhotoCommonData.allMediaInfoHashMap, true, this.jdField_a_of_type_Airg.jdField_b_of_type_JavaUtilHashMap, this.mPhotoCommonData.selectedMediaInfoHashMap);
    if (i == 0)
    {
      paramTextView.setText(((NewPhotoPreviewActivity)this.mActivity).getString(2131695277));
      return;
    }
    localObject = PhotoUtils.a(this.mActivity, i);
    if ((this.mPhotoCommonData.selectedPhotoList.size() == 0) || (((String)localObject).equals("0"))) {}
    for (localObject = ((NewPhotoPreviewActivity)this.mActivity).getString(2131695277);; localObject = ((NewPhotoPreviewActivity)this.mActivity).getString(2131695277) + "(共" + (String)localObject + ")")
    {
      paramTextView.setText((CharSequence)localObject);
      return;
    }
  }
  
  void b(int paramInt)
  {
    ((NewPhotoPreviewActivity)this.mActivity).magicStickBtn.setVisibility(paramInt);
    ((NewPhotoPreviewActivity)this.mActivity).qualityCheckBox.setVisibility(0);
    ((NewPhotoPreviewActivity)this.mActivity).qualityTv.setVisibility(0);
    if (((NewPhotoPreviewActivity)this.mActivity).flashPicCb.getVisibility() == 0)
    {
      ((NewPhotoPreviewActivity)this.mActivity).flashPicCb.setVisibility(paramInt);
      ((NewPhotoPreviewActivity)this.mActivity).flashTv.setVisibility(paramInt);
    }
  }
  
  protected boolean b()
  {
    Object localObject = (String)this.jdField_a_of_type_Airg.paths.get(((NewPhotoPreviewActivity)this.mActivity).getCurrentSelectedPostion());
    if (((NewPhotoPreviewActivity)this.mActivity).getMediaType((String)localObject) == 1)
    {
      localObject = ((NewPhotoPreviewActivity)this.mActivity).getMediaInfo((String)localObject);
      if ((localObject != null) && (((LocalMediaInfo)localObject).fileSize > 104345600L))
      {
        QQToast.a(this.mActivity, ((NewPhotoPreviewActivity)this.mActivity).getResources().getString(2131720133), 0).b(((NewPhotoPreviewActivity)this.mActivity).getResources().getDimensionPixelSize(2131298914));
        bdfa.c();
      }
      return false;
    }
    return super.b();
  }
  
  protected void c()
  {
    if ("FROM_QZONE_PHOTO_LIST".equals(this.jdField_a_of_type_Airg.from))
    {
      Object localObject = ((NewPhotoPreviewActivity)this.mActivity).getSubmitPhotoList();
      if ((localObject != null) && (((ArrayList)localObject).size() == 1))
      {
        localObject = (String)((ArrayList)localObject).get(0);
        if ((localObject != null) && (((String)localObject).startsWith("http")))
        {
          PhotoSendParams localPhotoSendParams = (PhotoSendParams)this.jdField_a_of_type_Airg.jdField_a_of_type_JavaUtilHashMap.get(localObject);
          if (localPhotoSendParams != null) {
            this.jdField_a_of_type_Airg.jdField_b_of_type_JavaUtilHashMap.put(localObject, localPhotoSendParams);
          }
        }
      }
      if (this.mPhotoCommonData.selectedPhotoList.size() != 0) {
        if (((NewPhotoPreviewActivity)this.mActivity).getIntent().getParcelableExtra("PhotoConst.sendToAIOIntent") == null) {
          break label212;
        }
      }
      label212:
      for (localObject = (Intent)((NewPhotoPreviewActivity)this.mActivity).getIntent().getParcelableExtra("PhotoConst.sendToAIOIntent");; localObject = ((NewPhotoPreviewActivity)this.mActivity).getIntent())
      {
        ((Intent)localObject).setExtrasClassLoader(biqd.class.getClassLoader());
        ((Intent)localObject).putExtra("PhotoConst.SEND_BUSINESS_TYPE", 1052);
        ((Intent)localObject).putExtra("PhotoConst.DEST_ACTIVITY_PACKAGE_NAME", "com.tencent.mobileqq");
        ((Intent)localObject).putExtra("PhotoConst.DEST_ACTIVITY_CLASS_NAME", SendPhotoActivity.class.getName());
        a((Intent)localObject, true, ((NewPhotoPreviewActivity)this.mActivity).getSubmitPhotoList());
        return;
      }
    }
    super.c();
  }
  
  public void initData(Intent paramIntent)
  {
    this.jdField_a_of_type_Airg.jdField_c_of_type_Boolean = true;
    this.jdField_a_of_type_Boolean = paramIntent.getBooleanExtra("PhotoConst.QZONE_ALBUM_FROM_AIO", false);
    this.jdField_b_of_type_Boolean = paramIntent.getBooleanExtra("KEY_IS_ANONYMOUS", false);
    super.initData(paramIntent);
    if (!this.jdField_a_of_type_Airg.isSingleMode)
    {
      Object localObject = (BinderWarpper)paramIntent.getParcelableExtra("binder_presendService");
      if (localObject != null)
      {
        if (PresendPicMgr.a(null) != null) {
          PresendPicMgr.a(null).b();
        }
        localObject = PresendPicMgr.b(awit.a(((BinderWarpper)localObject).a));
        this.jdField_a_of_type_Airg.f = 1037;
        paramIntent = (String)paramIntent.getStringArrayListExtra("PhotoConst.PHOTO_PATHS").get(0);
        if (((NewPhotoPreviewActivity)this.mActivity).getMediaType(paramIntent) != 1) {
          ((PresendPicMgr)localObject).a(paramIntent, this.jdField_a_of_type_Airg.f);
        }
      }
    }
    this.jdField_a_of_type_Airg.customSendBtnText = ((NewPhotoPreviewActivity)this.mActivity).getResources().getString(2131695307);
    aips.c();
    if (this.mPhotoCommonData.currentQualityType == 2) {
      this.jdField_c_of_type_Boolean = true;
    }
    paramIntent = new bdmu().a(this.mPhotoCommonData.jdField_a_of_type_Int).b(this.mPhotoCommonData.videoSizeLimit);
    if ((!this.jdField_b_of_type_Boolean) && (!this.jdField_a_of_type_Airg.l)) {}
    for (boolean bool = true;; bool = false)
    {
      this.jdField_a_of_type_Bdmu = paramIntent.a(bool);
      return;
    }
  }
  
  public void initUI()
  {
    super.initUI();
    if ((this.jdField_a_of_type_Boolean) && (this.jdField_a_of_type_Airg.jdField_b_of_type_JavaUtilHashMap.size() != 0)) {
      ((NewPhotoPreviewActivity)this.mActivity).magicStickBtn.setVisibility(8);
    }
  }
  
  public boolean needShowMultiPhoto()
  {
    return (this.mPhotoCommonData.selectedPhotoList != null) && (!this.mPhotoCommonData.selectedPhotoList.isEmpty());
  }
  
  public void onGalleryItemSelected(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    LocalMediaInfo localLocalMediaInfo = ((NewPhotoPreviewActivity)this.mActivity).getMediaInfo(((NewPhotoPreviewActivity)this.mActivity).adapter.getItem(paramInt));
    if ((localLocalMediaInfo != null) && (((NewPhotoPreviewActivity)this.mActivity).getMediaType(localLocalMediaInfo.path) == 1)) {
      if ((this.jdField_a_of_type_Airg.jdField_a_of_type_Int == 0) || (this.jdField_a_of_type_Airg.jdField_a_of_type_Int == 1) || (this.jdField_a_of_type_Airg.jdField_a_of_type_Int == 3000)) {
        b(8);
      }
    }
    for (;;)
    {
      super.onGalleryItemSelected(paramAdapterView, paramView, paramInt, paramLong);
      return;
      a(8);
      continue;
      a(0);
    }
  }
  
  public void onMagicStickClick(View paramView, int paramInt1, Bundle paramBundle, int paramInt2, Intent paramIntent)
  {
    paramBundle.putBoolean("key_multi_edit_pic", true);
    paramBundle.putBoolean("key_enable_edit_title_bar", true);
    super.onMagicStickClick(paramView, 10000, paramBundle, 2, null);
  }
  
  public void onQualityBtnClick(CompoundButton paramCompoundButton, boolean paramBoolean)
  {
    if (paramBoolean)
    {
      ((NewPhotoPreviewActivity)this.mActivity).flashPicCb.setChecked(false);
      ((NewPhotoPreviewActivity)this.mActivity).flashTv.setTextColor(2147483647);
      if (this.jdField_a_of_type_Bdmu != null)
      {
        if (this.jdField_c_of_type_Boolean) {
          break label175;
        }
        this.jdField_a_of_type_Bdmu.a(this.mActivity, this.mPhotoCommonData.selectedPhotoList, paramBoolean, this.mPhotoCommonData.selectedMediaInfoHashMap, this.mPhotoCommonData.allMediaInfoHashMap);
      }
      for (;;)
      {
        this.mPhotoCommonData.currentQualityType = 2;
        ((NewPhotoPreviewActivity)this.mActivity).qualityCheckBox.setChecked(true);
        updateButton();
        paramCompoundButton = ((NewPhotoPreviewActivity)this.mActivity).getIntent();
        if ((paramCompoundButton != null) && (paramCompoundButton.hasExtra("custom_photopreview_rawcheckbox_reportActionName")))
        {
          paramCompoundButton = paramCompoundButton.getStringExtra("custom_photopreview_rawcheckbox_reportActionName");
          if (paramCompoundButton != null) {
            azqs.b(null, "CliOper", "", "", paramCompoundButton, paramCompoundButton, 0, 0, "", "", "", "");
          }
        }
        return;
        label175:
        this.jdField_c_of_type_Boolean = false;
      }
    }
    ((NewPhotoPreviewActivity)this.mActivity).flashTv.setTextColor(-1);
    this.mPhotoCommonData.currentQualityType = 0;
    b();
  }
  
  public void onSelectClick(View paramView)
  {
    ((NewPhotoPreviewActivity)this.mActivity).getResources();
    paramView = PresendPicMgr.a(null);
    int k = ((NewPhotoPreviewActivity)this.mActivity).getCurrentSelectedPostion();
    int i;
    if (this.mPhotoCommonData.selectedIndex.contains(Integer.valueOf(k)))
    {
      ((NewPhotoPreviewActivity)this.mActivity).selectedBox.setChecked(false);
      i = this.mPhotoCommonData.selectedIndex.indexOf(Integer.valueOf(k));
      if (i >= 0)
      {
        this.mPhotoCommonData.selectedIndex.remove(i);
        if (k != -1)
        {
          this.mPhotoCommonData.selectedPhotoList.remove(this.jdField_a_of_type_Airg.paths.get(k));
          if (this.jdField_a_of_type_Airg.d != null) {
            this.jdField_a_of_type_Airg.d.remove(this.jdField_a_of_type_Airg.paths.get(k));
          }
          if (this.jdField_a_of_type_Airg.jdField_b_of_type_JavaUtilHashMap != null) {
            this.jdField_a_of_type_Airg.jdField_b_of_type_JavaUtilHashMap.remove(this.jdField_a_of_type_Airg.paths.get(k));
          }
          if (paramView != null) {
            paramView.b((String)this.jdField_a_of_type_Airg.paths.get(k), 1014);
          }
        }
      }
      updateButton();
      if ((this.mPhotoCommonData.selectedIndex.size() == 0) && (!this.jdField_a_of_type_Airg.i)) {
        this.jdField_a_of_type_Airg.k = false;
      }
      LpReportInfo_pf00064.allReport(603, 2);
      return;
    }
    if (this.mPhotoCommonData.selectedPhotoList.size() >= this.mPhotoCommonData.maxSelectNum)
    {
      i = 1;
      if (i == 0) {
        break label446;
      }
    }
    label446:
    for (int j = 2;; j = 1)
    {
      azqs.b(null, "dc00898", "", "", "0X800AB6E", "0X800AB6E", j, 0, "", "", "", "");
      if (i == 0) {
        break label451;
      }
      long l = System.currentTimeMillis();
      if (l - this.jdField_a_of_type_Airg.lastTimeShowToast >= 700L)
      {
        QQToast.a(this.mActivity, ((NewPhotoPreviewActivity)this.mActivity).getExceedMaxSelectNumStr(), 1000).b(this.jdField_a_of_type_Airg.titleBarHeight);
        this.jdField_a_of_type_Airg.lastTimeShowToast = l;
        if (this.jdField_a_of_type_Airg.l) {
          azqs.b(null, "CliOper", "", "", "0x80083EC", "0x80083EC", 0, 0, "", "", "", "");
        }
      }
      ((NewPhotoPreviewActivity)this.mActivity).selectedBox.setChecked(false);
      return;
      i = 0;
      break;
    }
    label451:
    Object localObject;
    AbstractPhotoPreviewActivity localAbstractPhotoPreviewActivity;
    if (k != -1)
    {
      localObject = (String)this.jdField_a_of_type_Airg.paths.get(k);
      ((NewPhotoPreviewActivity)this.mActivity).getMediaInfo((String)localObject);
      if ((paramView != null) && (!this.jdField_a_of_type_Airg.i) && (((NewPhotoPreviewActivity)this.mActivity).getMediaType((String)this.jdField_a_of_type_Airg.paths.get(k)) != 1)) {
        paramView.a((String)this.jdField_a_of_type_Airg.paths.get(k), this.jdField_a_of_type_Airg.f);
      }
      paramView = (String)this.jdField_a_of_type_Airg.paths.get(k);
      this.mPhotoCommonData.selectedPhotoList.add(paramView);
      if (this.jdField_a_of_type_Airg.jdField_a_of_type_JavaUtilHashMap != null)
      {
        localObject = (PhotoSendParams)this.jdField_a_of_type_Airg.jdField_a_of_type_JavaUtilHashMap.get(paramView);
        if ((this.jdField_a_of_type_Airg.jdField_b_of_type_JavaUtilHashMap != null) && (localObject != null)) {
          this.jdField_a_of_type_Airg.jdField_b_of_type_JavaUtilHashMap.put(paramView, localObject);
        }
      }
      if (this.jdField_a_of_type_Airg.jdField_c_of_type_JavaUtilHashMap != null)
      {
        localObject = (PicInfo)this.jdField_a_of_type_Airg.jdField_c_of_type_JavaUtilHashMap.get(paramView);
        if ((this.jdField_a_of_type_Airg.d != null) && (localObject != null)) {
          this.jdField_a_of_type_Airg.d.put(paramView, localObject);
        }
      }
      this.mPhotoCommonData.selectedIndex.add(Integer.valueOf(k));
      ((NewPhotoPreviewActivity)this.mActivity).setCheckedNumber(paramView);
      if (this.jdField_a_of_type_Bdmu != null)
      {
        localObject = this.jdField_a_of_type_Bdmu;
        localAbstractPhotoPreviewActivity = this.mActivity;
        if (this.mPhotoCommonData.currentQualityType != 2) {
          break label787;
        }
      }
    }
    label787:
    for (boolean bool = true;; bool = false)
    {
      ((bdmu)localObject).a(localAbstractPhotoPreviewActivity, paramView, bool, this.mPhotoCommonData.selectedMediaInfoHashMap, this.mPhotoCommonData.allMediaInfoHashMap, true);
      updateButton();
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aitg
 * JD-Core Version:    0.7.0.1
 */