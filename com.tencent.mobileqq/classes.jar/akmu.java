import NS_MOBILE_OPERATION.PicInfo;
import android.app.Dialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.support.v4.util.MQLruCache;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.Window;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.biz.qqstory.takevideo.slideshow.SlideItemInfo;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.component.media.image.ImageManager;
import com.tencent.component.network.utils.NetworkUtils;
import com.tencent.image.QQLiveImage;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.photo.DragGallery;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.activity.photo.PhotoSendParams;
import com.tencent.mobileqq.activity.photo.PhotoUtils;
import com.tencent.mobileqq.activity.photo.album.NewPhotoListActivity;
import com.tencent.mobileqq.activity.photo.album.NewPhotoPreviewActivity;
import com.tencent.mobileqq.activity.photo.album.PhotoCommonBaseData;
import com.tencent.mobileqq.activity.photo.album.PhotoPreviewLogic.IonCheckedChangedCallback;
import com.tencent.mobileqq.activity.photo.album.PhotoPreviewLogicBase;
import com.tencent.mobileqq.activity.photo.album.PhotoPreviewLogicDefault.5;
import com.tencent.mobileqq.activity.photo.album.PhotoPreviewLogicDefault.9;
import com.tencent.mobileqq.activity.photo.album.preview.BasePreviewAdapter;
import com.tencent.mobileqq.activity.shortvideo.SendVideoActivity.SendVideoInfo;
import com.tencent.mobileqq.app.FontSettingManager;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.pic.PresendPicMgr;
import com.tencent.mobileqq.transfile.chatpic.PicUploadFileSizeLimit;
import com.tencent.mobileqq.utils.AlbumUtil;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.widget.NumberCheckBox;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.AdapterView;
import com.tencent.widget.BubblePopupWindow;
import com.tencent.widget.DragView;
import com.tencent.widget.HorizontalListView;
import cooperation.qzone.report.lp.LpReportInfo_pf00064;
import dov.com.tencent.biz.qqstory.takevideo.EditPicActivity;
import dov.com.tencent.mobileqq.richmedia.capture.util.LiuHaiUtils;
import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import mqq.app.AppRuntime;

public class akmu
  extends PhotoPreviewLogicBase<NewPhotoPreviewActivity, akmq>
  implements PhotoPreviewLogic.IonCheckedChangedCallback, zaf
{
  public akmr a;
  aknd a;
  
  public akmu(NewPhotoPreviewActivity paramNewPhotoPreviewActivity)
  {
    super(paramNewPhotoPreviewActivity);
    this.jdField_a_of_type_Aknd = null;
    this.mOnCheckedChangedCallback = this;
    this.mPhotoPreviewData = new akmr();
    this.jdField_a_of_type_Akmr = ((akmr)this.mPhotoPreviewData);
  }
  
  private void e()
  {
    ((NewPhotoPreviewActivity)this.mActivity).mEnableLiuHai = false;
    ((NewPhotoPreviewActivity)this.mActivity).top_blackLH = ((LinearLayout)((NewPhotoPreviewActivity)this.mActivity).findViewById(2131363645));
    ((NewPhotoPreviewActivity)this.mActivity).bottom_blackLH = ((RelativeLayout)((NewPhotoPreviewActivity)this.mActivity).findViewById(2131363643));
    if (((akmq)this.mOtherCommonData).a()) {
      ((NewPhotoPreviewActivity)this.mActivity).mEnableLiuHai = LiuHaiUtils.a(((NewPhotoPreviewActivity)this.mActivity).top_blackLH, ((NewPhotoPreviewActivity)this.mActivity).bottom_blackLH, 0);
    }
    while (((NewPhotoPreviewActivity)this.mActivity).top_blackLH == null) {
      return;
    }
    ViewGroup.LayoutParams localLayoutParams = ((NewPhotoPreviewActivity)this.mActivity).top_blackLH.getLayoutParams();
    localLayoutParams.height = LiuHaiUtils.jdField_a_of_type_Int;
    ((NewPhotoPreviewActivity)this.mActivity).top_blackLH.setLayoutParams(localLayoutParams);
    ((NewPhotoPreviewActivity)this.mActivity).top_blackLH.setVisibility(0);
    ((NewPhotoPreviewActivity)this.mActivity).mEnableLiuHai = true;
  }
  
  protected int a()
  {
    if (this.jdField_a_of_type_Akmr.jdField_e_of_type_Int == 1) {
      return 141;
    }
    if ((this.jdField_a_of_type_Akmr.jdField_e_of_type_Int == 2) || (this.jdField_a_of_type_Akmr.jdField_e_of_type_Int == 3)) {
      return 143;
    }
    return 99;
  }
  
  protected akmq a()
  {
    return new akmv(this);
  }
  
  protected akpq a()
  {
    return new akpq(this);
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_Aknd != null) {
      this.jdField_a_of_type_Aknd.ak_();
    }
    String str = "";
    if (((NewPhotoPreviewActivity)this.mActivity).getCurrentSelectedPostion() != -1)
    {
      str = (String)this.jdField_a_of_type_Akmr.paths.get(((NewPhotoPreviewActivity)this.mActivity).getCurrentSelectedPostion());
      this.mPhotoCommonData.selectedPhotoList.add(str);
      this.mPhotoCommonData.selectedIndex.add(Integer.valueOf(((NewPhotoPreviewActivity)this.mActivity).getCurrentSelectedPostion()));
      if (((akmq)this.mOtherCommonData).a())
      {
        if (this.mPhotoCommonData.selectedMediaInfoHashMap == null) {
          this.mPhotoCommonData.selectedMediaInfoHashMap = new HashMap();
        }
        LocalMediaInfo localLocalMediaInfo = ((NewPhotoPreviewActivity)this.mActivity).getMediaInfo(str);
        this.mPhotoCommonData.selectedMediaInfoHashMap.put(str, localLocalMediaInfo);
      }
    }
    ((NewPhotoPreviewActivity)this.mActivity).setCheckedNumber(str);
    updateButton();
    b((String)this.jdField_a_of_type_Akmr.paths.get(((NewPhotoPreviewActivity)this.mActivity).getCurrentSelectedPostion()));
  }
  
  protected void a(int paramInt)
  {
    Object localObject1 = PresendPicMgr.a(null);
    if (this.mPhotoCommonData.selectedPhotoList.size() >= this.mPhotoCommonData.maxSelectNum)
    {
      long l = System.currentTimeMillis();
      if (l - this.jdField_a_of_type_Akmr.lastTimeShowToast >= 700L)
      {
        QQToast.a(this.mActivity, ((NewPhotoPreviewActivity)this.mActivity).getExceedMaxSelectNumStr(), 1000).b(this.jdField_a_of_type_Akmr.titleBarHeight);
        this.jdField_a_of_type_Akmr.lastTimeShowToast = l;
        if (this.jdField_a_of_type_Akmr.l) {
          bdla.b(null, "CliOper", "", "", "0x80083EC", "0x80083EC", 0, 0, "", "", "", "");
        }
      }
      ((NewPhotoPreviewActivity)this.mActivity).selectedBox.setChecked(false);
    }
    Object localObject2;
    LocalMediaInfo localLocalMediaInfo;
    do
    {
      return;
      if (paramInt == -1) {
        break;
      }
      localObject2 = (String)this.jdField_a_of_type_Akmr.paths.get(paramInt);
      localLocalMediaInfo = ((NewPhotoPreviewActivity)this.mActivity).getMediaInfo((String)localObject2);
    } while ((this.mPhotoCommonData.currentQualityType == 2) && (b()));
    if ((((akmq)this.mOtherCommonData).a()) && (!bpij.a(this.mActivity, localLocalMediaInfo)))
    {
      ((NewPhotoPreviewActivity)this.mActivity).selectedBox.setChecked(false);
      return;
    }
    if ((((NewPhotoPreviewActivity)this.mActivity).getIntent().getBooleanExtra("PhotoConst.IS_SEND_GIF_SIZE_LIMIT", false)) && (azlo.a((String)localObject2)) && (FileUtils.getFileSizes((String)localObject2) > 3145728L))
    {
      QQToast.a(this.mActivity, "图片文件过大", 0).b(this.jdField_a_of_type_Akmr.titleBarHeight);
      ((NewPhotoPreviewActivity)this.mActivity).selectedBox.setChecked(false);
      return;
    }
    if ((localObject1 != null) && (!this.jdField_a_of_type_Akmr.i) && (((NewPhotoPreviewActivity)this.mActivity).getMediaType((String)this.jdField_a_of_type_Akmr.paths.get(paramInt)) != 1)) {
      ((PresendPicMgr)localObject1).a((String)this.jdField_a_of_type_Akmr.paths.get(paramInt), this.jdField_a_of_type_Akmr.jdField_f_of_type_Int);
    }
    localObject1 = (String)this.jdField_a_of_type_Akmr.paths.get(paramInt);
    this.mPhotoCommonData.selectedPhotoList.add(localObject1);
    if (this.jdField_a_of_type_Akmr.jdField_a_of_type_JavaUtilHashMap != null)
    {
      localObject2 = (PhotoSendParams)this.jdField_a_of_type_Akmr.jdField_a_of_type_JavaUtilHashMap.get(localObject1);
      if ((this.jdField_a_of_type_Akmr.jdField_b_of_type_JavaUtilHashMap != null) && (localObject2 != null)) {
        this.jdField_a_of_type_Akmr.jdField_b_of_type_JavaUtilHashMap.put(localObject1, localObject2);
      }
    }
    if (this.jdField_a_of_type_Akmr.jdField_c_of_type_JavaUtilHashMap != null)
    {
      localObject2 = (PicInfo)this.jdField_a_of_type_Akmr.jdField_c_of_type_JavaUtilHashMap.get(localObject1);
      if ((this.jdField_a_of_type_Akmr.jdField_d_of_type_JavaUtilHashMap != null) && (localObject2 != null)) {
        this.jdField_a_of_type_Akmr.jdField_d_of_type_JavaUtilHashMap.put(localObject1, localObject2);
      }
    }
    this.mPhotoCommonData.selectedIndex.add(Integer.valueOf(paramInt));
    if (((akmq)this.mOtherCommonData).a())
    {
      if (this.mPhotoCommonData.selectedMediaInfoHashMap == null) {
        this.mPhotoCommonData.selectedMediaInfoHashMap = new HashMap();
      }
      localObject2 = ((NewPhotoPreviewActivity)this.mActivity).getMediaInfo((String)localObject1);
      this.mPhotoCommonData.selectedMediaInfoHashMap.put(localObject1, localObject2);
    }
    ((NewPhotoPreviewActivity)this.mActivity).setCheckedNumber((String)localObject1);
    updateButton();
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    if ((paramInt1 >= 0) && (paramInt1 < this.mPhotoCommonData.selectedPhotoList.size()) && (paramInt2 >= 0) && (paramInt2 < this.mPhotoCommonData.selectedPhotoList.size()))
    {
      Collections.swap(this.mPhotoCommonData.selectedPhotoList, paramInt1, paramInt2);
      if (this.jdField_a_of_type_Akmr.jdField_a_of_type_Zad != null)
      {
        String str = this.jdField_a_of_type_Akmr.jdField_a_of_type_Zad.a();
        if (!TextUtils.isEmpty(str)) {
          ((NewPhotoPreviewActivity)this.mActivity).setCheckedNumber(str);
        }
      }
      yzz.a().b(this.mPhotoCommonData.selectedPhotoList, this.mPhotoCommonData.allMediaInfoHashMap);
    }
  }
  
  void a(int paramInt1, int paramInt2, Intent paramIntent)
  {
    boolean bool = false;
    if ((paramInt2 == -1) && (paramIntent != null))
    {
      if (!paramIntent.getBooleanExtra("PhotoConst.SEND_ORIGIN", false)) {
        bool = true;
      }
      if (bool) {
        break label32;
      }
    }
    label32:
    String str2;
    String str1;
    do
    {
      do
      {
        return;
        str2 = paramIntent.getStringExtra("PhotoConst.SINGLE_PHOTO_PATH");
      } while (str2 == null);
      ThreadManager.excute(new PhotoPreviewLogicDefault.9(this, str2), 64, null, true);
      if (QLog.isColorLevel()) {
        QLog.i("PhotoPreviewActivity", 2, "onActivityResultForMultiEdit hasEdit:" + bool + ", picPath:" + str2);
      }
      str1 = paramIntent.getStringExtra("key_multi_edit_source_path");
      paramInt1 = this.jdField_a_of_type_Akmr.paths.indexOf(str1);
    } while (paramInt1 < 0);
    if (this.jdField_a_of_type_Akmr.editPathMap.containsValue(str1)) {}
    for (paramIntent = akkq.a(this.jdField_a_of_type_Akmr.editPathMap, str1);; paramIntent = str1)
    {
      this.jdField_a_of_type_Akmr.editPathMap.put(paramIntent, str2);
      this.jdField_a_of_type_Akmr.paths.add(paramInt1, str2);
      this.jdField_a_of_type_Akmr.paths.remove(paramInt1 + 1);
      paramInt2 = this.mPhotoCommonData.selectedPhotoList.indexOf(str1);
      if (paramInt2 >= 0)
      {
        this.mPhotoCommonData.selectedPhotoList.add(paramInt2, str2);
        this.mPhotoCommonData.selectedPhotoList.remove(paramInt2 + 1);
      }
      ((NewPhotoPreviewActivity)this.mActivity).adapter.notifyDataSetChanged();
      ((NewPhotoPreviewActivity)this.mActivity).jdField_a_of_type_Akmg.notifyDataSetChanged();
      ((NewPhotoPreviewActivity)this.mActivity).gallery.setSelection(paramInt1);
      paramIntent = PresendPicMgr.a();
      if (paramIntent == null) {
        break;
      }
      paramIntent.b(str1, 1003);
      paramIntent.a(str2, this.jdField_a_of_type_Akmr.jdField_f_of_type_Int);
      return;
    }
  }
  
  public void a(Intent paramIntent, boolean paramBoolean, ArrayList<String> paramArrayList)
  {
    i2 = 0;
    i = -1;
    int j;
    int k;
    int i1;
    try
    {
      m = PhotoUtils.getTypeforReportSpcialDiscuss((SessionInfo)paramIntent.getParcelableExtra("session_info"));
      HashMap localHashMap = new HashMap();
      j = 0;
      i = 0;
      int n = 0;
      k = 0;
      for (;;)
      {
        if (n >= paramArrayList.size()) {
          break label324;
        }
        localObject1 = (String)paramArrayList.get(n);
        if (!ImageManager.isNetworkUrl((String)localObject1)) {
          break;
        }
        i1 = k;
        k = i;
        i = i1;
        n += 1;
        i1 = k;
        k = i;
        i = i1;
      }
    }
    catch (Exception localException1)
    {
      for (;;)
      {
        m = i;
        if (QLog.isColorLevel())
        {
          QLog.e("PhotoPreviewActivity", 2, "submit", localException1);
          m = i;
        }
      }
    }
    if (((NewPhotoPreviewActivity)this.mActivity).getMediaType((String)localObject1) == 1)
    {
      localObject1 = ((NewPhotoPreviewActivity)this.mActivity).getMediaInfo((String)localObject1);
      localObject2 = new SendVideoActivity.SendVideoInfo();
      i += 1;
      if (((((LocalMediaInfo)localObject1).mDuration > 1200000L) || (((LocalMediaInfo)localObject1).fileSize > 1048576000L)) && (a()))
      {
        QQToast.a(this.mActivity, ((NewPhotoPreviewActivity)this.mActivity).getResources().getString(2131718834), 0).b(((NewPhotoPreviewActivity)this.mActivity).getResources().getDimensionPixelSize(2131299080));
        ((NewPhotoPreviewActivity)this.mActivity).finish();
      }
    }
    label324:
    do
    {
      return;
      ((SendVideoActivity.SendVideoInfo)localObject2).fileSize = ((LocalMediaInfo)localObject1).fileSize;
      ((SendVideoActivity.SendVideoInfo)localObject2).duration = ((LocalMediaInfo)localObject1).mDuration;
      localException1.put(Integer.valueOf(k), localObject2);
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
      try
      {
        paramIntent.setExtrasClassLoader(SessionInfo.class.getClassLoader());
        if (localException1.isEmpty()) {
          break label710;
        }
        paramIntent.putExtra("PhotoConst.VIDEO_INFOS", localException1);
        i = 1;
      }
      catch (Exception localException2)
      {
        for (;;)
        {
          boolean bool;
          String str;
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
              PhotoUtils.sendPhoto(this.mActivity, paramIntent, paramArrayList, this.jdField_a_of_type_Akmr.jdField_b_of_type_JavaUtilHashMap, this.mPhotoCommonData.currentQualityType, true);
              ((NewPhotoPreviewActivity)this.mActivity).setResult(-1);
              ((NewPhotoPreviewActivity)this.mActivity).finish();
            }
            for (;;)
            {
              bdla.b(null, "CliOper", "", "", "0X8009AB1", "0X8009AB1", m, 0, (String)localObject1, (String)localObject2, "", "");
              return;
              PhotoUtils.sendPhoto(this.mActivity, paramIntent, paramArrayList, this.mPhotoCommonData.currentQualityType, this.jdField_a_of_type_Akmr.jdField_a_of_type_Boolean);
            }
            i = 0;
          }
        }
      }
      if ((bcwz.b == 0L) || (System.currentTimeMillis() - bcwz.b >= 300000L)) {
        break label601;
      }
      bool = true;
      if (QLog.isColorLevel()) {
        QLog.d("PhotoPreviewActivity", 2, "upload video isConfirmed=" + bool + " allowUploadInXGTime=" + bcwz.b);
      }
      if ((!NetworkUtil.isMobileNetWork(BaseApplicationImpl.getContext())) || (bool) || (i == 0) || (!a())) {
        break label607;
      }
      str = ((NewPhotoPreviewActivity)this.mActivity).getResources().getString(2131718496);
      paramIntent = new PhotoPreviewLogicDefault.5(this, paramBoolean, paramIntent, paramArrayList, m, (String)localObject1, (String)localObject2);
      if (bixr.a(this.mActivity, 4, new akna(this, paramIntent))) {
        bhdj.a(this.mActivity, 232, null, str, new aknb(this, paramIntent), new aknc(this)).show();
      }
    } while (!QLog.isColorLevel());
    QLog.i("PhotoPreviewActivity", 2, "show shortvideo_mobile_send_confirm dialog");
  }
  
  protected void a(TextView paramTextView)
  {
    Object localObject1 = ((NewPhotoPreviewActivity)this.mActivity).getResources();
    Object localObject2 = this.mPhotoCommonData.selectedPhotoList.iterator();
    while (((Iterator)localObject2).hasNext())
    {
      String str = (String)((Iterator)localObject2).next();
      if ((!NetworkUtils.isNetworkUrl(str)) && (((NewPhotoPreviewActivity)this.mActivity).getMediaType(str) == 1)) {
        paramTextView.setText(((Resources)localObject1).getString(2131694645));
      }
    }
    int i = AlbumUtil.getSelectFileTotolLen(this.mPhotoCommonData.selectedPhotoList, this.mPhotoCommonData.allMediaInfoHashMap, false, this.jdField_a_of_type_Akmr.jdField_b_of_type_JavaUtilHashMap, this.mPhotoCommonData.selectedMediaInfoHashMap);
    localObject2 = PhotoUtils.getRawPhotoSize(this.mActivity, i);
    if ((this.mPhotoCommonData.selectedPhotoList.size() == 0) || (((String)localObject2).equals("0"))) {}
    for (localObject1 = ((Resources)localObject1).getString(2131694645);; localObject1 = ((Resources)localObject1).getString(2131694645) + "(共" + (String)localObject2 + ")")
    {
      paramTextView.setText((CharSequence)localObject1);
      return;
    }
  }
  
  public void a(SlideItemInfo paramSlideItemInfo)
  {
    if (paramSlideItemInfo == null) {
      return;
    }
    if (this.jdField_a_of_type_Aknd != null) {
      this.jdField_a_of_type_Aknd.a_(paramSlideItemInfo);
    }
    int i = 0;
    label24:
    if (i < this.jdField_a_of_type_Akmr.paths.size()) {
      if (!((String)this.jdField_a_of_type_Akmr.paths.get(i)).equals(paramSlideItemInfo.jdField_b_of_type_JavaLangString)) {}
    }
    for (;;)
    {
      if (i >= 0)
      {
        if (!this.mPhotoCommonData.selectedIndex.contains(Integer.valueOf(i))) {
          break;
        }
        ((NewPhotoPreviewActivity)this.mActivity).selectedBox.setChecked(false);
        int j = this.mPhotoCommonData.selectedIndex.indexOf(Integer.valueOf(i));
        if (j >= 0)
        {
          this.mPhotoCommonData.selectedPhotoList.remove(this.jdField_a_of_type_Akmr.paths.get(i));
          this.mPhotoCommonData.selectedIndex.remove(j);
          if (this.jdField_a_of_type_Akmr.jdField_d_of_type_JavaUtilHashMap != null) {
            this.jdField_a_of_type_Akmr.jdField_d_of_type_JavaUtilHashMap.remove(this.jdField_a_of_type_Akmr.paths.get(i));
          }
          if (this.jdField_a_of_type_Akmr.jdField_b_of_type_JavaUtilHashMap != null) {
            this.jdField_a_of_type_Akmr.jdField_b_of_type_JavaUtilHashMap.remove(this.jdField_a_of_type_Akmr.paths.get(i));
          }
        }
        updateButton();
        b((String)this.jdField_a_of_type_Akmr.paths.get(i));
        return;
        i += 1;
        break label24;
      }
      this.mPhotoCommonData.selectedPhotoList.remove(paramSlideItemInfo.jdField_b_of_type_JavaLangString);
      updateButton();
      ((NewPhotoPreviewActivity)this.mActivity).setCheckedNumber(paramSlideItemInfo.jdField_b_of_type_JavaLangString);
      b(paramSlideItemInfo.jdField_b_of_type_JavaLangString);
      return;
      i = -1;
    }
  }
  
  public void a(String paramString)
  {
    int j = 0;
    if ((((akmq)this.mOtherCommonData).a()) && (!this.jdField_a_of_type_Akmr.jdField_e_of_type_Boolean))
    {
      this.jdField_a_of_type_Akmr.paths.clear();
      this.jdField_a_of_type_Akmr.paths.addAll(this.mPhotoCommonData.selectedPhotoList);
      this.mPhotoCommonData.selectedIndex.clear();
      i = 0;
      while (i < this.mPhotoCommonData.selectedPhotoList.size())
      {
        this.mPhotoCommonData.selectedIndex.add(Integer.valueOf(i));
        i += 1;
      }
      ((NewPhotoPreviewActivity)this.mActivity).adapter.notifyDataSetChanged();
      this.jdField_a_of_type_Akmr.jdField_e_of_type_Boolean = true;
    }
    int i = this.jdField_a_of_type_Akmr.paths.indexOf(paramString);
    if (i < 0) {
      i = j;
    }
    for (;;)
    {
      ((NewPhotoPreviewActivity)this.mActivity).gallery.setSelection(i);
      return;
    }
  }
  
  protected boolean a()
  {
    return true;
  }
  
  protected void b()
  {
    int k = 0;
    float f = 16.0F / FontSettingManager.getFontLevel();
    int i;
    if ((((NewPhotoPreviewActivity)this.mActivity).getResources().getDisplayMetrics().densityDpi < 400) || (Build.VERSION.SDK_INT <= 21))
    {
      i = 1;
      if ((f >= 1.0F) && (i == 0)) {
        break label269;
      }
      if (i == 0) {
        break label270;
      }
      f = 0.7F * f;
    }
    label269:
    label270:
    for (;;)
    {
      int j = k;
      if (QLog.isColorLevel())
      {
        QLog.d("PhotoPreviewActivity", 2, "need scale,reqWidth:" + ((NewPhotoPreviewActivity)this.mActivity).reqWidth + " scale:" + f);
        j = k;
      }
      label121:
      if (j < ((NewPhotoPreviewActivity)this.mActivity).bottomBar.getChildCount())
      {
        View localView = ((NewPhotoPreviewActivity)this.mActivity).bottomBar.getChildAt(j);
        localView.setScaleX(f);
        localView.setScaleY(f);
        RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)localView.getLayoutParams();
        if (j == ((NewPhotoPreviewActivity)this.mActivity).bottomBar.getChildCount() - 1) {
          localLayoutParams.rightMargin = ((int)(localLayoutParams.rightMargin * f));
        }
        for (;;)
        {
          localView.setLayoutParams(localLayoutParams);
          j += 1;
          break label121;
          i = 0;
          break;
          localLayoutParams.leftMargin = ((int)(localLayoutParams.leftMargin * f));
          if ((i != 0) && (f < 1.0F)) {
            localLayoutParams.leftMargin = ((int)(localLayoutParams.leftMargin * f));
          }
        }
      }
      return;
    }
  }
  
  protected void b(int paramInt)
  {
    PresendPicMgr localPresendPicMgr = PresendPicMgr.a(null);
    ((NewPhotoPreviewActivity)this.mActivity).selectedBox.setChecked(false);
    int i = this.mPhotoCommonData.selectedIndex.indexOf(Integer.valueOf(paramInt));
    if (i >= 0)
    {
      this.mPhotoCommonData.selectedIndex.remove(i);
      if (paramInt != -1)
      {
        this.mPhotoCommonData.selectedPhotoList.remove(this.jdField_a_of_type_Akmr.paths.get(paramInt));
        if (this.jdField_a_of_type_Akmr.jdField_d_of_type_JavaUtilHashMap != null) {
          this.jdField_a_of_type_Akmr.jdField_d_of_type_JavaUtilHashMap.remove(this.jdField_a_of_type_Akmr.paths.get(paramInt));
        }
        if (this.jdField_a_of_type_Akmr.jdField_b_of_type_JavaUtilHashMap != null) {
          this.jdField_a_of_type_Akmr.jdField_b_of_type_JavaUtilHashMap.remove(this.jdField_a_of_type_Akmr.paths.get(paramInt));
        }
        if (localPresendPicMgr != null) {
          localPresendPicMgr.b((String)this.jdField_a_of_type_Akmr.paths.get(paramInt), 1014);
        }
      }
    }
    updateButton();
    if ((this.mPhotoCommonData.selectedIndex.size() == 0) && (!this.jdField_a_of_type_Akmr.i)) {
      this.jdField_a_of_type_Akmr.k = false;
    }
  }
  
  void b(String paramString)
  {
    if (((akmq)this.mOtherCommonData).a())
    {
      if (this.jdField_a_of_type_Akmr.jdField_a_of_type_Zad == null) {
        this.jdField_a_of_type_Akmr.jdField_a_of_type_Zad = new zad(this.mActivity, this);
      }
      yzz.a().a(this.jdField_a_of_type_Akmr.jdField_a_of_type_Zad);
      yzz.a().b(this.mPhotoCommonData.selectedPhotoList, this.mPhotoCommonData.allMediaInfoHashMap);
      yzz.a().a(this.mActivity);
      this.jdField_a_of_type_Akmr.jdField_a_of_type_Zad.a(this.mPhotoCommonData.selectedPhotoList.indexOf(paramString));
      if (((NewPhotoPreviewActivity)this.mActivity).mEnableLiuHai)
      {
        paramString = (RelativeLayout)((NewPhotoPreviewActivity)this.mActivity).findViewById(2131378982);
        ((ViewGroup)paramString.getParent()).removeView(paramString);
        Object localObject = paramString.getLayoutParams();
        localObject = new RelativeLayout.LayoutParams(((ViewGroup.LayoutParams)localObject).width, ((ViewGroup.LayoutParams)localObject).height);
        ((RelativeLayout.LayoutParams)localObject).addRule(10, -1);
        ((RelativeLayout.LayoutParams)localObject).topMargin = ViewUtils.dip2px(8.0F);
        ((NewPhotoPreviewActivity)this.mActivity).bottom_blackLH.addView(paramString, (ViewGroup.LayoutParams)localObject);
      }
      ((NewPhotoPreviewActivity)this.mActivity).bottomBar.setVisibility(4);
    }
  }
  
  protected boolean b()
  {
    int i = ((NewPhotoPreviewActivity)this.mActivity).getCurrentSelectedPostion();
    if ((((akmq)this.mOtherCommonData).a()) && (i != -1) && (new File((String)this.jdField_a_of_type_Akmr.paths.get(i)).length() > PicUploadFileSizeLimit.getLimitC2C()))
    {
      QQToast.a(this.mActivity, ((NewPhotoPreviewActivity)this.mActivity).getResources().getString(2131694641), 0).b(((NewPhotoPreviewActivity)this.mActivity).getResources().getDimensionPixelSize(2131299080));
      ((NewPhotoPreviewActivity)this.mActivity).selectedBox.setChecked(false);
      return true;
    }
    return false;
  }
  
  public void c()
  {
    switch (this.mPhotoCommonData.currentQualityType)
    {
    case 1: 
    default: 
      return;
    case 0: 
      ((NewPhotoPreviewActivity)this.mActivity).qualityTv.setText(((NewPhotoPreviewActivity)this.mActivity).getString(2131694645));
      ((NewPhotoPreviewActivity)this.mActivity).qualityCheckBox.setChecked(false);
      return;
    }
    a(((NewPhotoPreviewActivity)this.mActivity).qualityTv);
    ((NewPhotoPreviewActivity)this.mActivity).qualityCheckBox.setChecked(true);
  }
  
  public void c(int paramInt)
  {
    ((NewPhotoPreviewActivity)this.mActivity).bottomBar.setVisibility(paramInt);
  }
  
  protected void d()
  {
    if (this.jdField_a_of_type_Akmr.i) {
      ((NewPhotoPreviewActivity)this.mActivity).getIntent().putExtra("PhotoConst.SEND_BUSINESS_TYPE", 1040);
    }
    if ((this.jdField_a_of_type_Akmr.jdField_c_of_type_Boolean) && ((!TextUtils.isEmpty(this.jdField_a_of_type_Akmr.jdField_b_of_type_JavaLangString)) || (!TextUtils.isEmpty(this.jdField_a_of_type_Akmr.jdField_c_of_type_JavaLangString)))) {
      ((NewPhotoPreviewActivity)this.mActivity).magicStickBtn.performClick();
    }
    ArrayList localArrayList = ((NewPhotoPreviewActivity)this.mActivity).getSubmitPhotoList();
    Intent localIntent = ((NewPhotoPreviewActivity)this.mActivity).getIntent();
    aklj.a(localArrayList.size(), this.jdField_a_of_type_Akmr.totalPicCount);
    aklj.a(localIntent, localArrayList.size(), this.mPhotoCommonData.currentQualityType);
    PresendPicMgr localPresendPicMgr = PresendPicMgr.a(null);
    if (this.mPhotoCommonData.currentQualityType == 2)
    {
      if ((this.mPhotoCommonData.selectedPhotoList.size() == 0) && (localArrayList.size() == 1) && (FileUtils.getFileSizes((String)localArrayList.get(0)) > PicUploadFileSizeLimit.getLimitC2C()))
      {
        QQToast.a(this.mActivity, ((NewPhotoPreviewActivity)this.mActivity).getResources().getString(2131694641), 0).b(((NewPhotoPreviewActivity)this.mActivity).getResources().getDimensionPixelSize(2131299080));
        ((NewPhotoPreviewActivity)this.mActivity).sendBtn.setClickable(true);
        return;
      }
      if (localPresendPicMgr != null)
      {
        localPresendPicMgr.a(1010);
        localPresendPicMgr.a();
      }
      bdla.b(null, "CliOper", "", "", "0X800515C", "0X800515C", 0, 0, "", "", "", "");
    }
    for (;;)
    {
      if (this.jdField_a_of_type_Akmr.jdField_a_of_type_Boolean) {
        ((NewPhotoPreviewActivity)this.mActivity).topBar.setVisibility(4);
      }
      alrr.a(localArrayList);
      if (((akmq)this.mOtherCommonData).a()) {
        localIntent.putExtra("PeakConstants.selectedMediaInfoHashMap", this.mPhotoCommonData.selectedMediaInfoHashMap);
      }
      if (this.jdField_a_of_type_Akmr.l)
      {
        localIntent.putExtra("ReceiptMsgManager.EXTRA_KEY_IS_RECEIPT", true);
        localIntent.putExtra("session_info", localIntent.getParcelableExtra("session_info"));
      }
      a(localIntent, this.mPhotoCommonData.containNetImage(), ((NewPhotoPreviewActivity)this.mActivity).getSubmitPhotoList());
      return;
      if ((localPresendPicMgr != null) && (this.mPhotoCommonData.selectedPhotoList.size() > 0) && (!this.jdField_a_of_type_Akmr.i) && (!this.jdField_a_of_type_Akmr.k) && (!this.jdField_a_of_type_Akmr.l) && (!localIntent.getBooleanExtra("PhotoConst.SEND_NO_PRESEND", false)) && (((akmq)this.mOtherCommonData).a(this.mPhotoCommonData))) {
        localPresendPicMgr.a(localIntent);
      }
    }
  }
  
  public void doOnDestroy()
  {
    if (((akmq)this.mOtherCommonData).a()) {
      yzz.a().f();
    }
    if ((this.jdField_a_of_type_Akmr.cameraType == 103) && (this.jdField_a_of_type_Akmr.paths != null)) {}
    try
    {
      Object localObject = (String)this.jdField_a_of_type_Akmr.paths.get(0);
      if (!TextUtils.isEmpty((CharSequence)localObject))
      {
        localObject = BaseApplicationImpl.sImageCache.remove((String)localObject + "#short_video_camera_preview_cache");
        if ((localObject instanceof Bitmap))
        {
          if (QLog.isColorLevel()) {
            QLog.d("PhotoPreviewActivity", 2, "recycle short video preview cache");
          }
          aqmy.a((Bitmap)localObject);
        }
      }
    }
    catch (Throwable localThrowable)
    {
      label121:
      break label121;
    }
    super.doOnDestroy();
  }
  
  public void doOnResume()
  {
    super.doOnResume();
    QQLiveImage.onForeground(this.mActivity);
    lzr.a(BaseApplicationImpl.getContext(), true);
    biwn.a(BaseApplicationImpl.getContext(), false);
    aqrl.a(BaseApplicationImpl.getContext(), 2, false);
    if (((NewPhotoPreviewActivity)this.mActivity).magicStickBtn != null) {
      ((NewPhotoPreviewActivity)this.mActivity).magicStickBtn.setClickable(true);
    }
    if (((akmq)this.mOtherCommonData).a())
    {
      yzz.a().c();
      yzz.a().a(this.jdField_a_of_type_Akmr.jdField_a_of_type_Zad);
      yzz.a().b(this.mPhotoCommonData.selectedPhotoList, this.mPhotoCommonData.allMediaInfoHashMap);
    }
  }
  
  public void flashPicCheckedChanged(boolean paramBoolean)
  {
    this.jdField_a_of_type_Akmr.i = paramBoolean;
    int i;
    if (paramBoolean)
    {
      this.jdField_a_of_type_Akmr.k = true;
      Object localObject = ((NewPhotoPreviewActivity)this.mActivity).qualityCheckBox;
      if (!paramBoolean)
      {
        paramBoolean = true;
        ((CheckBox)localObject).setChecked(paramBoolean);
        ((NewPhotoPreviewActivity)this.mActivity).qualityTv.setTextColor(2147483647);
        if ((this.mPhotoCommonData.selectedPhotoList.isEmpty()) && (((NewPhotoPreviewActivity)this.mActivity).gallery.getFirstVisiblePosition() < this.jdField_a_of_type_Akmr.paths.size()))
        {
          ((NewPhotoPreviewActivity)this.mActivity).selectLayout.performClick();
          updateButton();
        }
        if ((((NewPhotoPreviewActivity)this.mActivity).getCurrentSelectedPostion() != -1) && (this.jdField_a_of_type_Akmr.paths.size() > ((NewPhotoPreviewActivity)this.mActivity).getCurrentSelectedPostion()))
        {
          if (((NewPhotoPreviewActivity)this.mActivity).getMediaType((String)this.jdField_a_of_type_Akmr.paths.get(((NewPhotoPreviewActivity)this.mActivity).getCurrentSelectedPostion())) == 1) {
            break label433;
          }
          i = 1;
          label191:
          if ((this.jdField_a_of_type_Akmr.j) && (((NewPhotoPreviewActivity)this.mActivity).jdField_a_of_type_ComTencentWidgetBubblePopupWindow == null) && (i != 0))
          {
            this.jdField_a_of_type_Akmr.j = false;
            BaseApplicationImpl.getApplication().getSharedPreferences(BaseApplicationImpl.getApplication().getRuntime().getAccount(), 4).edit().putBoolean("showFlashPic", false).commit();
            ((NewPhotoPreviewActivity)this.mActivity).jdField_a_of_type_ComTencentWidgetBubblePopupWindow = new BubblePopupWindow(-2, -2);
            localObject = new TextView(this.mActivity);
            i = AIOUtils.dp2px(10.0F, ((NewPhotoPreviewActivity)this.mActivity).getResources());
            ((TextView)localObject).setPadding(i, 0, i, 0);
            ((TextView)localObject).setTextColor(-1);
            ((TextView)localObject).setText("选中的图片每人只能查看一次");
            ((TextView)localObject).setTextSize(14.0F);
            ((NewPhotoPreviewActivity)this.mActivity).jdField_a_of_type_ComTencentWidgetBubblePopupWindow.a((View)localObject);
            ((NewPhotoPreviewActivity)this.mActivity).jdField_a_of_type_ComTencentWidgetBubblePopupWindow.a(false);
            ((NewPhotoPreviewActivity)this.mActivity).jdField_a_of_type_ComTencentWidgetBubblePopupWindow.b(((NewPhotoPreviewActivity)this.mActivity).flashTv);
          }
        }
        if (this.jdField_a_of_type_Akmr.jdField_a_of_type_Int != 0) {
          break label438;
        }
        bdla.b(null, "dc00898", "", "", "0X8006997", "0X8006997", 0, 0, "", "", "", "");
      }
    }
    label433:
    label438:
    do
    {
      do
      {
        return;
        paramBoolean = false;
        break;
        i = 0;
        break label191;
        if (this.jdField_a_of_type_Akmr.jdField_a_of_type_Int == 3000)
        {
          bdla.b(null, "dc00898", "", "", "0X8006998", "0X8006998", 0, 0, "", "", "", "");
          return;
        }
      } while (this.jdField_a_of_type_Akmr.jdField_a_of_type_Int != 1);
      bdla.b(null, "dc00898", "", "", "0X8006999", "0X8006999", 0, 0, "", "", "", "");
      return;
      ((NewPhotoPreviewActivity)this.mActivity).qualityTv.setTextColor(-1);
    } while (((NewPhotoPreviewActivity)this.mActivity).jdField_a_of_type_ComTencentWidgetBubblePopupWindow == null);
    ((NewPhotoPreviewActivity)this.mActivity).jdField_a_of_type_ComTencentWidgetBubblePopupWindow.a();
  }
  
  public void initData(Intent paramIntent)
  {
    this.jdField_a_of_type_Akmr.canUseURL = paramIntent.getBooleanExtra("PhotoConst.USE_URL_PATH", false);
    super.initData(paramIntent);
    alrr.a("preview create");
    this.jdField_a_of_type_Akmr.j = BaseApplicationImpl.getApplication().getSharedPreferences(BaseApplicationImpl.getApplication().getRuntime().getAccount(), 4).getBoolean("showFlashPic", true);
    this.jdField_a_of_type_Akmr.cameraType = paramIntent.getIntExtra("camera_type", 1);
    this.jdField_a_of_type_Akmr.h = paramIntent.getBooleanExtra("showFlashPic", false);
    this.jdField_a_of_type_Akmr.jdField_b_of_type_Int = paramIntent.getIntExtra("PhotoConst.SEND_BUSINESS_TYPE", -1);
    this.jdField_a_of_type_Akmr.jdField_c_of_type_Int = paramIntent.getIntExtra("camera_front_back", 0);
    this.jdField_a_of_type_Akmr.jdField_d_of_type_Int = paramIntent.getIntExtra("camera_filter_id", -1);
    this.jdField_a_of_type_Akmr.jdField_g_of_type_Int = paramIntent.getIntExtra("camera_capture_method", -1);
    this.jdField_a_of_type_Akmr.jdField_d_of_type_Boolean = paramIntent.getBooleanExtra("PhotoConst.IS_FROM_EDIT", false);
    this.jdField_a_of_type_Akmr.l = paramIntent.getBooleanExtra("ReceiptMsgManager.EXTRA_KEY_IS_RECEIPT", false);
    this.jdField_a_of_type_Akmr.jdField_a_of_type_JavaUtilHashMap = ((HashMap)paramIntent.getSerializableExtra("PhotoConst.PHOTO_PATHS_FROM_QZONEALBUM"));
    this.jdField_a_of_type_Akmr.jdField_c_of_type_JavaUtilHashMap = ((HashMap)paramIntent.getSerializableExtra("PhotoConst.PHOTO_INFOS"));
    this.jdField_a_of_type_Akmr.editPathMap = ((HashMap)paramIntent.getSerializableExtra("PhotoConst.editPathMap"));
    if (this.jdField_a_of_type_Akmr.editPathMap == null) {
      this.jdField_a_of_type_Akmr.editPathMap = new HashMap();
    }
    this.jdField_a_of_type_Akmr.jdField_d_of_type_JavaUtilHashMap = new HashMap(1);
    if (this.jdField_a_of_type_Akmr.jdField_c_of_type_JavaUtilHashMap != null) {
      this.jdField_a_of_type_Akmr.jdField_d_of_type_JavaUtilHashMap.putAll(this.jdField_a_of_type_Akmr.jdField_c_of_type_JavaUtilHashMap);
    }
    this.jdField_a_of_type_Akmr.jdField_b_of_type_JavaUtilHashMap = new HashMap(1);
    if (this.jdField_a_of_type_Akmr.jdField_a_of_type_JavaUtilHashMap != null) {
      this.jdField_a_of_type_Akmr.jdField_b_of_type_JavaUtilHashMap.putAll(this.jdField_a_of_type_Akmr.jdField_a_of_type_JavaUtilHashMap);
    }
    if (QLog.isColorLevel()) {
      QLog.d("aioSendPhotos", 2, "mCanUseURL:" + this.jdField_a_of_type_Akmr.canUseURL + " mSelectedSendParams size:" + this.jdField_a_of_type_Akmr.jdField_b_of_type_JavaUtilHashMap.size());
    }
    this.mPhotoCommonData.videoSizeLimit = paramIntent.getLongExtra("PhotoConst.PHOTOLIST_KEY_VIDEO_SIZE", 1048576000L);
    this.jdField_a_of_type_Akmr.jdField_a_of_type_Boolean = paramIntent.getBooleanExtra("PhotoConst.HANDLE_DEST_RESULT", false);
    this.jdField_a_of_type_Akmr.jdField_b_of_type_Boolean = paramIntent.getBooleanExtra("PhotoConst.SHOULD_SEND_RAW_PHOTO", false);
    if (!this.jdField_a_of_type_Akmr.jdField_c_of_type_Boolean) {
      this.jdField_a_of_type_Akmr.jdField_c_of_type_Boolean = paramIntent.getBooleanExtra("PhotoConst.SHOW_MAGIC_USE_PASTER", false);
    }
    if ("FROM_QZONE_PHOTO_LIST".equals(this.jdField_a_of_type_Akmr.from)) {
      this.jdField_a_of_type_Akmr.jdField_c_of_type_Boolean = false;
    }
    if (this.jdField_a_of_type_Akmr.jdField_c_of_type_Boolean)
    {
      this.jdField_a_of_type_Akmr.jdField_e_of_type_JavaUtilHashMap = ((HashMap)paramIntent.getSerializableExtra("PasterConstants.pasters_data"));
      this.jdField_a_of_type_Akmr.jdField_b_of_type_JavaLangString = paramIntent.getStringExtra("PasterConstants.paster_id");
      this.jdField_a_of_type_Akmr.jdField_c_of_type_JavaLangString = paramIntent.getStringExtra("PasterConstants.paster_cate_id");
    }
    this.jdField_a_of_type_Akmr.jdField_a_of_type_Int = paramIntent.getIntExtra("uintype", -1);
    this.jdField_a_of_type_Akmr.jdField_f_of_type_Boolean = paramIntent.getBooleanExtra("PhotoConst.IS_CALL_IN_PLUGIN", false);
    this.jdField_a_of_type_Akmr.jdField_g_of_type_Boolean = paramIntent.getBooleanExtra("PhotoConst.IS_SINGLE_DERECTBACK_MODE", false);
    this.mPhotoCommonData.currentQualityType = paramIntent.getIntExtra("PhotoConst.CURRENT_QUALITY_TYPE", 0);
    this.jdField_a_of_type_Akmr.m = paramIntent.getBooleanExtra("PhotoConst.SEND_FLAG", false);
    if (this.jdField_a_of_type_Akmr.m)
    {
      paramIntent.removeExtra("PhotoConst.SEND_FLAG");
      PresendPicMgr localPresendPicMgr = PresendPicMgr.a(null);
      if (localPresendPicMgr != null)
      {
        if (QLog.isColorLevel()) {
          QLog.d("PhotoPreviewActivity", 2, "Photo+ send pic,cancel presend!");
        }
        localPresendPicMgr.a(1003);
      }
      PhotoUtils.sendPhoto(this.mActivity, paramIntent, this.mPhotoCommonData.selectedPhotoList, this.mPhotoCommonData.currentQualityType, true);
    }
    this.jdField_a_of_type_Akmr.jdField_e_of_type_Int = paramIntent.getIntExtra("key_pic_to_edit_from", 0);
  }
  
  public void initUI()
  {
    e();
    if (Build.VERSION.SDK_INT == 19)
    {
      localObject = ((NewPhotoPreviewActivity)this.mActivity).getWindow().getDecorView();
      ((View)localObject).setSystemUiVisibility(((View)localObject).getSystemUiVisibility() | 0x4 | 0x100 | 0x1000);
    }
    super.initUI();
    Object localObject = ((NewPhotoPreviewActivity)this.mActivity).getResources();
    ((NewPhotoPreviewActivity)this.mActivity).reqWidth = ((Resources)localObject).getDisplayMetrics().widthPixels;
    ((NewPhotoPreviewActivity)this.mActivity).reqHeight = ((Resources)localObject).getDisplayMetrics().heightPixels;
    ((NewPhotoPreviewActivity)this.mActivity).mNeedStatusTrans = true;
    ((NewPhotoPreviewActivity)this.mActivity).mActNeedImmersive = false;
    ((NewPhotoPreviewActivity)this.mActivity).jdField_a_of_type_ComTencentWidgetHorizontalListView = ((HorizontalListView)((NewPhotoPreviewActivity)this.mActivity).findViewById(2131367060));
    ((NewPhotoPreviewActivity)this.mActivity).jdField_a_of_type_AndroidViewView = ((NewPhotoPreviewActivity)this.mActivity).findViewById(2131367058);
    ((NewPhotoPreviewActivity)this.mActivity).jdField_a_of_type_Akmg = new akmg((NewPhotoPreviewActivity)this.mActivity);
    ((NewPhotoPreviewActivity)this.mActivity).jdField_a_of_type_Akmg.a(this.mPhotoCommonData.selectedPhotoList);
    ((NewPhotoPreviewActivity)this.mActivity).jdField_a_of_type_ComTencentWidgetHorizontalListView.setAdapter(((NewPhotoPreviewActivity)this.mActivity).jdField_a_of_type_Akmg);
    ((NewPhotoPreviewActivity)this.mActivity).jdField_a_of_type_ComTencentWidgetHorizontalListView.setOnItemClickListener(((NewPhotoPreviewActivity)this.mActivity).jdField_a_of_type_Akmg);
    if (needShowMultiPhoto())
    {
      ((NewPhotoPreviewActivity)this.mActivity).jdField_a_of_type_ComTencentWidgetHorizontalListView.setVisibility(0);
      ((NewPhotoPreviewActivity)this.mActivity).jdField_a_of_type_AndroidViewView.setVisibility(0);
    }
    if (this.jdField_a_of_type_Akmr.showBar)
    {
      ((NewPhotoPreviewActivity)this.mActivity).topBar.setVisibility(0);
      if (((akmq)this.mOtherCommonData).a()) {
        ((NewPhotoPreviewActivity)this.mActivity).bottomBar.setVisibility(4);
      }
    }
    else
    {
      if ((this.jdField_a_of_type_Akmr.h) && (this.jdField_a_of_type_Akmr.jdField_d_of_type_JavaUtilHashMap.size() == 0))
      {
        ((NewPhotoPreviewActivity)this.mActivity).flashPicCb.setVisibility(0);
        ((NewPhotoPreviewActivity)this.mActivity).flashTv.setVisibility(0);
        ((NewPhotoPreviewActivity)this.mActivity).flashPicCb.setOnCheckedChangeListener(this.mActivity);
        ((NewPhotoPreviewActivity)this.mActivity).flashTv.setOnClickListener(new akmw(this));
        ((NewPhotoPreviewActivity)this.mActivity).flashPicCb.setContentDescription("闪照");
        ((NewPhotoPreviewActivity)this.mActivity).flashTv.setContentDescription("闪照");
      }
      ((NewPhotoPreviewActivity)this.mActivity).qualityCheckBox.setOnCheckedChangeListener(this.mActivity);
      if (!this.jdField_a_of_type_Akmr.jdField_b_of_type_Boolean) {
        break label885;
      }
      ((NewPhotoPreviewActivity)this.mActivity).qualityCheckBox.setVisibility(0);
      ((NewPhotoPreviewActivity)this.mActivity).qualityTv.setVisibility(0);
      label516:
      if (!this.jdField_a_of_type_Akmr.jdField_c_of_type_Boolean) {
        break label918;
      }
      ((NewPhotoPreviewActivity)this.mActivity).magicStickBtn.setVisibility(0);
    }
    for (;;)
    {
      ((NewPhotoPreviewActivity)this.mActivity).magicStickBtn.setOnClickListener(new akmx(this));
      ((NewPhotoPreviewActivity)this.mActivity).sendBtn.setOnClickListener(new akmy(this));
      updateButton();
      if ((this.jdField_a_of_type_Akmr.jdField_g_of_type_Boolean) || (this.jdField_a_of_type_Akmr.isSingleMode))
      {
        ((NewPhotoPreviewActivity)this.mActivity).selectedBox.setVisibility(8);
        ((NewPhotoPreviewActivity)this.mActivity).selectLayout.setVisibility(8);
        ((NewPhotoPreviewActivity)this.mActivity).qualityCheckBox.setVisibility(8);
        ((NewPhotoPreviewActivity)this.mActivity).qualityTv.setVisibility(8);
      }
      if (this.jdField_a_of_type_Akmr.jdField_a_of_type_Int == 1001)
      {
        ((NewPhotoPreviewActivity)this.mActivity).qualityCheckBox.setVisibility(8);
        ((NewPhotoPreviewActivity)this.mActivity).qualityTv.setVisibility(8);
      }
      b();
      if (((akmq)this.mOtherCommonData).a())
      {
        ((NewPhotoPreviewActivity)this.mActivity).backToPhotoListBtn.setText("");
        ((NewPhotoPreviewActivity)this.mActivity).titleView.setVisibility(8);
        if (((NewPhotoPreviewActivity)this.mActivity).getCurrentSelectedPostion() != -1) {
          b((String)this.jdField_a_of_type_Akmr.paths.get(((NewPhotoPreviewActivity)this.mActivity).getCurrentSelectedPostion()));
        }
      }
      float f = ((NewPhotoPreviewActivity)this.mActivity).getResources().getDisplayMetrics().density;
      AIOUtils.expandViewTouchDelegate(((NewPhotoPreviewActivity)this.mActivity).magicStickBtn, (int)(10.0F * f + 0.5F), (int)(10.0F * f + 0.5F), (int)(10.0F * f + 0.5F), (int)(f * 10.0F + 0.5F));
      return;
      ((NewPhotoPreviewActivity)this.mActivity).bottomBar.setVisibility(0);
      break;
      label885:
      ((NewPhotoPreviewActivity)this.mActivity).qualityCheckBox.setVisibility(8);
      ((NewPhotoPreviewActivity)this.mActivity).qualityTv.setVisibility(8);
      break label516;
      label918:
      ((NewPhotoPreviewActivity)this.mActivity).magicStickBtn.setVisibility(8);
    }
  }
  
  public boolean needShowMultiPhoto()
  {
    return false;
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if (paramInt1 == 24747)
    {
      yzz.a().a(paramIntent, this.mPhotoCommonData.selectedMediaInfoHashMap);
      return;
    }
    if (paramInt1 == 18001)
    {
      ((NewPhotoPreviewActivity)this.mActivity).c(paramInt1, paramInt2, paramIntent);
      return;
    }
    if (paramInt1 == 18002)
    {
      ((NewPhotoPreviewActivity)this.mActivity).b(paramInt1, paramInt2, paramIntent);
      return;
    }
    if (paramInt1 == 18003)
    {
      ((NewPhotoPreviewActivity)this.mActivity).a(paramInt1, paramInt2, paramIntent);
      return;
    }
    if (paramInt1 == 10000)
    {
      a(paramInt1, paramInt2, paramIntent);
      return;
    }
    PhotoUtils.onSendResult(this.mActivity, paramInt1, paramInt2, paramIntent, this.jdField_a_of_type_Akmr.jdField_f_of_type_Boolean, this.mPhotoCommonData.myUin);
  }
  
  public void onBackPressed(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_Akmr.jdField_d_of_type_Boolean) {
      yzz.a().a(yzz.a().c());
    }
    Intent localIntent1 = ((NewPhotoPreviewActivity)this.mActivity).getIntent();
    localIntent1.putExtra("PhotoConst.SEND_BUSINESS_TYPE", this.jdField_a_of_type_Akmr.jdField_b_of_type_Int);
    if ("FROM_PHOTO_LIST".equals(this.jdField_a_of_type_Akmr.from))
    {
      localIntent1.setClass(this.mActivity, NewPhotoListActivity.class);
      localIntent1.putExtra("PhotoConst.CURRENT_QUALITY_TYPE", this.mPhotoCommonData.currentQualityType);
      if (this.jdField_a_of_type_Akmr.isSingleMode) {
        localIntent1.removeExtra("PhotoConst.PHOTO_PATHS");
      }
    }
    for (;;)
    {
      localIntent1.putExtra("PhotoConst.PHOTO_PATHS_FROM_QZONEALBUM", this.jdField_a_of_type_Akmr.jdField_b_of_type_JavaUtilHashMap);
      localIntent1.putExtra("PhotoConst.PHOTO_INFOS", this.jdField_a_of_type_Akmr.jdField_d_of_type_JavaUtilHashMap);
      ((NewPhotoPreviewActivity)this.mActivity).startActivity(localIntent1);
      label149:
      if (localIntent1.getBooleanExtra("keep_selected_status_after_finish", false))
      {
        localIntent1 = new Intent();
        localIntent1.putStringArrayListExtra("PhotoConst.SELECTED_PATHS", this.mPhotoCommonData.selectedPhotoList);
        localIntent1.putIntegerArrayListExtra("PhotoConst.SELECTED_INDEXS", this.mPhotoCommonData.selectedIndex);
        localIntent1.putExtra("PhotoConst.CURRENT_QUALITY_TYPE", this.mPhotoCommonData.currentQualityType);
        localIntent1.putExtra("PhotoConst.editPathMap", this.jdField_a_of_type_Akmr.editPathMap);
        ((NewPhotoPreviewActivity)this.mActivity).setResult(-1, localIntent1);
      }
      ((NewPhotoPreviewActivity)this.mActivity).finish();
      if (paramBoolean) {
        try
        {
          ((NewPhotoPreviewActivity)this.mActivity).overridePendingTransition(2130772039, 2130772041);
          return;
          localIntent1.putStringArrayListExtra("PhotoConst.PHOTO_PATHS", this.mPhotoCommonData.selectedPhotoList);
          localIntent1.putExtra("PhotoConst.editPathMap", this.jdField_a_of_type_Akmr.editPathMap);
          continue;
          if (!"FROM_QZONE_PHOTO_LIST".equals(this.jdField_a_of_type_Akmr.from)) {
            break label149;
          }
          Intent localIntent2 = new Intent();
          localIntent2.putStringArrayListExtra("PhotoConst.PHOTO_PATHS", this.mPhotoCommonData.selectedPhotoList);
          localIntent2.putExtra("PhotoConst.PHOTO_PATHS_FROM_QZONEALBUM", this.jdField_a_of_type_Akmr.jdField_b_of_type_JavaUtilHashMap);
          localIntent2.putExtra("PhotoConst.CURRENT_QUALITY_TYPE", this.mPhotoCommonData.currentQualityType);
          localIntent2.putExtra("PeakConstants.selectedMediaInfoHashMap", this.mPhotoCommonData.selectedMediaInfoHashMap);
          ((NewPhotoPreviewActivity)this.mActivity).setResult(-1, localIntent2);
        }
        catch (Exception localException)
        {
          while (!QLog.isColorLevel()) {}
          QLog.d("PhotoPreviewActivity", 2, "[PhotoPreviewActivity] overridePendingTransition=" + localException);
          return;
        }
      }
    }
    AlbumUtil.anim(this.mActivity, true, false);
  }
  
  public void onGalleryItemSelected(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    if (QLog.isColorLevel()) {
      QLog.d("PhotoPreviewActivity", 2, " onItemSelected position=" + paramInt);
    }
    super.onGalleryItemSelected(paramAdapterView, paramView, paramInt, paramLong);
    paramAdapterView = ((NewPhotoPreviewActivity)this.mActivity).adapter.getItem(paramInt);
    int i;
    if (((NewPhotoPreviewActivity)this.mActivity).getMediaType(paramAdapterView) == 1) {
      i = 1;
    }
    for (;;)
    {
      if (i != 0)
      {
        paramView.setContentDescription("视频" + paramInt);
        if (((NewPhotoPreviewActivity)this.mActivity).jdField_a_of_type_ComTencentWidgetBubblePopupWindow != null) {
          ((NewPhotoPreviewActivity)this.mActivity).jdField_a_of_type_ComTencentWidgetBubblePopupWindow.a();
        }
      }
      try
      {
        for (;;)
        {
          ((NewPhotoPreviewActivity)this.mActivity).jdField_a_of_type_ComTencentWidgetDragView.setOriginRect(((NewPhotoPreviewActivity)this.mActivity).getMediaInfo((String)this.jdField_a_of_type_Akmr.paths.get(paramInt)).thumbRect);
          if (((akmq)this.mOtherCommonData).a())
          {
            if (paramAdapterView != null) {
              ((NewPhotoPreviewActivity)this.mActivity).setCheckedNumber(paramAdapterView);
            }
            b((String)this.jdField_a_of_type_Akmr.paths.get(paramInt));
          }
          return;
          i = 0;
          break;
          paramView.setContentDescription("照片" + paramInt);
        }
      }
      catch (Exception paramView)
      {
        for (;;)
        {
          if (QLog.isColorLevel()) {
            QLog.d("PhotoPreviewActivity", 2, bkym.a(paramView));
          }
        }
      }
    }
  }
  
  public void onMagicStickClick(View paramView, int paramInt1, Bundle paramBundle, int paramInt2, Intent paramIntent)
  {
    int i = ((NewPhotoPreviewActivity)this.mActivity).getCurrentSelectedPostion();
    if ((i != -1) && (this.jdField_a_of_type_Akmr.paths.size() > i))
    {
      this.jdField_a_of_type_Akmr.jdField_a_of_type_JavaLangString = ((String)this.jdField_a_of_type_Akmr.paths.get(i));
      if (this.jdField_a_of_type_Akmr.jdField_a_of_type_JavaLangString != null)
      {
        bdla.b(null, "CliOper", "", "", "0x8004B39", "0x8004B39", 0, 0, "", "", "", "");
        if (this.jdField_a_of_type_Akmr.jdField_c_of_type_Boolean)
        {
          paramView = paramIntent;
          if (paramIntent == null) {
            paramView = EditPicActivity.a(this.mActivity, this.jdField_a_of_type_Akmr.jdField_a_of_type_JavaLangString, true, true, true, true, true, paramInt2, a(), 4, paramBundle);
          }
          paramView.putExtra("PhotoConst.CURRENT_QUALITY_TYPE", this.mPhotoCommonData.currentQualityType);
          if (!this.jdField_a_of_type_Akmr.i) {
            break label365;
          }
          paramView.putExtra("PhotoConst.SEND_BUSINESS_TYPE", 1040);
          if (paramInt1 != -1) {
            break label383;
          }
          ((NewPhotoPreviewActivity)this.mActivity).startActivity(paramView);
          label189:
          ((NewPhotoPreviewActivity)this.mActivity).magicStickBtn.setClickable(false);
          paramView = ((NewPhotoPreviewActivity)this.mActivity).getIntent();
          if ((paramView != null) && (paramView.hasExtra("custom_photopreview_editbtn_reportActionName")))
          {
            paramView = paramView.getStringExtra("custom_photopreview_editbtn_reportActionName");
            if (paramView != null) {
              bdla.b(null, "CliOper", "", "", paramView, paramView, 0, 0, "", "", "", "");
            }
          }
          if ((needShowMultiPhoto()) && (this.jdField_a_of_type_Akmr.jdField_e_of_type_Int > 0))
          {
            paramInt2 = this.jdField_a_of_type_Akmr.jdField_e_of_type_Int;
            paramView = new StringBuilder();
            if (this.mPhotoCommonData.selectedPhotoList == null) {
              break label398;
            }
          }
        }
      }
    }
    label398:
    for (paramInt1 = this.mPhotoCommonData.selectedPhotoList.size();; paramInt1 = 0)
    {
      bdla.b(null, "dc00898", "", "", "0X800A06D", "0X800A06D", paramInt2, 0, paramInt1 + "", "", "", "");
      LpReportInfo_pf00064.allReport(603, 4, 1);
      return;
      label365:
      paramView.putExtra("PhotoConst.SEND_BUSINESS_TYPE", this.jdField_a_of_type_Akmr.jdField_b_of_type_Int);
      break;
      label383:
      ((NewPhotoPreviewActivity)this.mActivity).startActivityForResult(paramView, paramInt1);
      break label189;
    }
  }
  
  public void onQualityBtnClick(CompoundButton paramCompoundButton, boolean paramBoolean)
  {
    if (paramBoolean)
    {
      paramCompoundButton = ((NewPhotoPreviewActivity)this.mActivity).flashPicCb;
      if (!paramBoolean)
      {
        paramBoolean = true;
        paramCompoundButton.setChecked(paramBoolean);
        ((NewPhotoPreviewActivity)this.mActivity).flashTv.setTextColor(2147483647);
        if (AlbumUtil.getCountOfOverSizeLimit(this.mPhotoCommonData.selectedPhotoList, ((akmq)this.mOtherCommonData).jdField_a_of_type_Int, this.mPhotoCommonData.allMediaInfoHashMap, true, this.mPhotoCommonData.selectedMediaInfoHashMap) <= 0) {
          break label178;
        }
        QQToast.a(this.mActivity, ((NewPhotoPreviewActivity)this.mActivity).getResources().getString(2131694641), 0).b(((NewPhotoPreviewActivity)this.mActivity).getResources().getDimensionPixelSize(2131299080));
        this.mPhotoCommonData.currentQualityType = 0;
        ((NewPhotoPreviewActivity)this.mActivity).qualityTv.setText(((NewPhotoPreviewActivity)this.mActivity).getString(2131694645));
        ((NewPhotoPreviewActivity)this.mActivity).qualityCheckBox.setChecked(false);
      }
      label178:
      do
      {
        do
        {
          do
          {
            do
            {
              int j;
              do
              {
                return;
                paramBoolean = false;
                break;
                if (!this.mPhotoCommonData.selectedPhotoList.isEmpty()) {
                  break label665;
                }
                j = ((NewPhotoPreviewActivity)this.mActivity).gallery.getFirstVisiblePosition();
              } while (j >= this.jdField_a_of_type_Akmr.paths.size());
              long l = new File((String)this.jdField_a_of_type_Akmr.paths.get(j)).length();
              if (((NewPhotoPreviewActivity)this.mActivity).getMediaType((String)this.jdField_a_of_type_Akmr.paths.get(j)) == 1) {}
              for (int i = 1; (i == 0) && (l > PicUploadFileSizeLimit.getLimitC2C()); i = 0)
              {
                QQToast.a(this.mActivity, ((NewPhotoPreviewActivity)this.mActivity).getResources().getString(2131694641), 0).b(((NewPhotoPreviewActivity)this.mActivity).getResources().getDimensionPixelSize(2131299080));
                this.mPhotoCommonData.currentQualityType = 0;
                ((NewPhotoPreviewActivity)this.mActivity).qualityTv.setText(((NewPhotoPreviewActivity)this.mActivity).getString(2131694645));
                ((NewPhotoPreviewActivity)this.mActivity).qualityCheckBox.setChecked(false);
                return;
              }
              if ((i != 0) && (l > 104345600L))
              {
                QQToast.a(this.mActivity, ((NewPhotoPreviewActivity)this.mActivity).getResources().getString(2131718856), 0).b(((NewPhotoPreviewActivity)this.mActivity).getResources().getDimensionPixelSize(2131299080));
                AlbumUtil.reportRawVideo();
              }
              ((NewPhotoPreviewActivity)this.mActivity).setCheckedNumber("", 1);
              this.mPhotoCommonData.selectedPhotoList.add(this.jdField_a_of_type_Akmr.paths.get(j));
              this.mPhotoCommonData.selectedIndex.add(Integer.valueOf(j));
              ((NewPhotoPreviewActivity)this.mActivity).qualityCheckBox.setChecked(true);
              this.mPhotoCommonData.currentQualityType = 2;
              a(((NewPhotoPreviewActivity)this.mActivity).qualityTv);
              updateButton();
              paramCompoundButton = PresendPicMgr.a();
              if ((paramCompoundButton != null) && (((NewPhotoPreviewActivity)this.mActivity).getMediaType((String)this.jdField_a_of_type_Akmr.paths.get(j)) != 1)) {
                paramCompoundButton.a((String)this.jdField_a_of_type_Akmr.paths.get(j), this.jdField_a_of_type_Akmr.jdField_f_of_type_Int);
              }
              paramCompoundButton = ((NewPhotoPreviewActivity)this.mActivity).getIntent();
            } while ((paramCompoundButton == null) || (!paramCompoundButton.hasExtra("custom_photopreview_rawcheckbox_reportActionName")));
            paramCompoundButton = paramCompoundButton.getStringExtra("custom_photopreview_rawcheckbox_reportActionName");
          } while (paramCompoundButton == null);
          bdla.b(null, "CliOper", "", "", paramCompoundButton, paramCompoundButton, 0, 0, "", "", "", "");
          return;
          if (AlbumUtil.getCountOfRawVideoOverSize(this.mPhotoCommonData.selectedPhotoList, 104345600L, this.mPhotoCommonData.allMediaInfoHashMap, true, this.mPhotoCommonData.selectedMediaInfoHashMap) > 0)
          {
            QQToast.a(this.mActivity, ((NewPhotoPreviewActivity)this.mActivity).getResources().getString(2131718856), 0).b(((NewPhotoPreviewActivity)this.mActivity).getResources().getDimensionPixelSize(2131299080));
            AlbumUtil.reportRawVideo();
          }
          ((NewPhotoPreviewActivity)this.mActivity).qualityCheckBox.setChecked(true);
          this.mPhotoCommonData.currentQualityType = 2;
          a(((NewPhotoPreviewActivity)this.mActivity).qualityTv);
          paramCompoundButton = ((NewPhotoPreviewActivity)this.mActivity).getIntent();
        } while ((paramCompoundButton == null) || (!paramCompoundButton.hasExtra("custom_photopreview_rawcheckbox_reportActionName")));
        paramCompoundButton = paramCompoundButton.getStringExtra("custom_photopreview_rawcheckbox_reportActionName");
      } while (paramCompoundButton == null);
      label665:
      bdla.b(null, "CliOper", "", "", paramCompoundButton, paramCompoundButton, 0, 0, "", "", "", "");
      return;
    }
    ((NewPhotoPreviewActivity)this.mActivity).qualityCheckBox.setChecked(false);
    this.mPhotoCommonData.currentQualityType = 0;
    ((NewPhotoPreviewActivity)this.mActivity).qualityTv.setText(((NewPhotoPreviewActivity)this.mActivity).getString(2131694645));
    ((NewPhotoPreviewActivity)this.mActivity).flashTv.setTextColor(-1);
  }
  
  public void onSelectClick(View paramView)
  {
    ((NewPhotoPreviewActivity)this.mActivity).getResources();
    int i = ((NewPhotoPreviewActivity)this.mActivity).getCurrentSelectedPostion();
    if (this.mPhotoCommonData.selectedIndex.contains(Integer.valueOf(i))) {
      b(i);
    }
    for (;;)
    {
      if ((((akmq)this.mOtherCommonData).a()) && (i != -1)) {
        b((String)this.jdField_a_of_type_Akmr.paths.get(i));
      }
      LpReportInfo_pf00064.allReport(603, 2);
      return;
      a(i);
    }
  }
  
  public void updateButton()
  {
    Object localObject = ((NewPhotoPreviewActivity)this.mActivity).getResources();
    if (this.jdField_a_of_type_Akmr.jdField_b_of_type_Boolean)
    {
      localObject = ((Resources)localObject).getString(2131694659);
      if (this.jdField_a_of_type_Akmr.customSendBtnText == null) {
        break label803;
      }
      localObject = this.jdField_a_of_type_Akmr.customSendBtnText;
    }
    label288:
    label803:
    for (;;)
    {
      int i;
      label76:
      boolean bool1;
      int j;
      if ((this.mPhotoCommonData.selectedPhotoList != null) && (this.mPhotoCommonData.selectedPhotoList.size() > 0))
      {
        i = 1;
        if (i == 0) {
          break label575;
        }
        if ((!this.jdField_a_of_type_Akmr.jdField_g_of_type_Boolean) && (!this.jdField_a_of_type_Akmr.isSingleMode)) {
          break label449;
        }
        ((NewPhotoPreviewActivity)this.mActivity).sendBtn.setEnabled(true);
        ((NewPhotoPreviewActivity)this.mActivity).sendBtn.setText((CharSequence)localObject);
        bool1 = this.mPhotoCommonData.selectedIndex.contains(Integer.valueOf(((NewPhotoPreviewActivity)this.mActivity).getCurrentSelectedPostion()));
        if ((((NewPhotoPreviewActivity)this.mActivity).getCurrentSelectedPostion() == -1) || (this.jdField_a_of_type_Akmr.paths.size() <= ((NewPhotoPreviewActivity)this.mActivity).getCurrentSelectedPostion())) {
          break label740;
        }
        if (((NewPhotoPreviewActivity)this.mActivity).getMediaType((String)this.jdField_a_of_type_Akmr.paths.get(((NewPhotoPreviewActivity)this.mActivity).getCurrentSelectedPostion())) == 1) {
          break label718;
        }
        j = 1;
        label229:
        boolean bool2 = AlbumUtil.isNetUrl((String)this.jdField_a_of_type_Akmr.paths.get(((NewPhotoPreviewActivity)this.mActivity).getCurrentSelectedPostion()));
        if (((i != 0) && (!bool1)) || (j == 0) || (bool2)) {
          break label723;
        }
        ((NewPhotoPreviewActivity)this.mActivity).magicStickBtn.setEnabled(true);
        if (((NewPhotoPreviewActivity)this.mActivity).jdField_a_of_type_Akmg != null)
        {
          if (!needShowMultiPhoto()) {
            break label757;
          }
          if (((NewPhotoPreviewActivity)this.mActivity).jdField_a_of_type_ComTencentWidgetHorizontalListView.getVisibility() == 4)
          {
            ((NewPhotoPreviewActivity)this.mActivity).jdField_a_of_type_AndroidViewView.setVisibility(0);
            ((NewPhotoPreviewActivity)this.mActivity).jdField_a_of_type_ComTencentWidgetHorizontalListView.setVisibility(0);
          }
          ((NewPhotoPreviewActivity)this.mActivity).jdField_a_of_type_Akmg.notifyDataSetChanged();
        }
      }
      for (;;)
      {
        if ((bool1) || (this.mPhotoCommonData.selectedPhotoList.size() < this.mPhotoCommonData.maxSelectNum)) {
          break label788;
        }
        ((NewPhotoPreviewActivity)this.mActivity).selectedBox.setActivated(true);
        return;
        if (((akmq)this.mOtherCommonData).a())
        {
          localObject = ((Resources)localObject).getString(2131698924);
          break;
        }
        localObject = ((Resources)localObject).getString(2131694617);
        break;
        i = 0;
        break label76;
        label449:
        ((NewPhotoPreviewActivity)this.mActivity).sendBtn.setEnabled(true);
        c();
        Button localButton;
        if (((akmq)this.mOtherCommonData).a())
        {
          localButton = ((NewPhotoPreviewActivity)this.mActivity).sendBtn;
          if (this.mPhotoCommonData.selectedPhotoList.size() < 2) {
            break label570;
          }
        }
        label570:
        for (bool1 = true;; bool1 = false)
        {
          localButton.setEnabled(bool1);
          ((NewPhotoPreviewActivity)this.mActivity).sendBtn.setText((String)localObject + "(" + this.mPhotoCommonData.selectedPhotoList.size() + ")");
          break;
        }
        label575:
        ((NewPhotoPreviewActivity)this.mActivity).sendBtn.setText((CharSequence)localObject);
        if (((akmq)this.mOtherCommonData).a()) {
          ((NewPhotoPreviewActivity)this.mActivity).sendBtn.setEnabled(false);
        }
        ((NewPhotoPreviewActivity)this.mActivity).qualityCheckBox.setOnCheckedChangeListener(null);
        localObject = ((NewPhotoPreviewActivity)this.mActivity).qualityCheckBox;
        if (this.mPhotoCommonData.currentQualityType == 2) {}
        for (bool1 = true;; bool1 = false)
        {
          ((CheckBox)localObject).setChecked(bool1);
          ((NewPhotoPreviewActivity)this.mActivity).qualityCheckBox.setOnCheckedChangeListener(this.mActivity);
          if (this.mPhotoCommonData.currentQualityType == 2) {
            ((NewPhotoPreviewActivity)this.mActivity).qualityTv.setTextColor(-16734752);
          }
          c();
          break;
        }
        label718:
        j = 0;
        break label229;
        label723:
        ((NewPhotoPreviewActivity)this.mActivity).magicStickBtn.setEnabled(false);
        break label288;
        label740:
        ((NewPhotoPreviewActivity)this.mActivity).magicStickBtn.setEnabled(false);
        break label288;
        label757:
        ((NewPhotoPreviewActivity)this.mActivity).jdField_a_of_type_AndroidViewView.setVisibility(4);
        ((NewPhotoPreviewActivity)this.mActivity).jdField_a_of_type_ComTencentWidgetHorizontalListView.setVisibility(4);
      }
      ((NewPhotoPreviewActivity)this.mActivity).selectedBox.setActivated(false);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     akmu
 * JD-Core Version:    0.7.0.1
 */