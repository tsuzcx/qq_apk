import android.content.Intent;
import android.content.res.Resources;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.activity.photo.MediaFileFilter;
import com.tencent.mobileqq.activity.photo.MimeHelper;
import com.tencent.mobileqq.activity.photo.PhotoUtils;
import com.tencent.mobileqq.activity.photo.album.AbstractPhotoListActivity;
import com.tencent.mobileqq.activity.photo.album.AbstractPhotoListActivity.PhotoListAdapter;
import com.tencent.mobileqq.activity.photo.album.NewPhotoListActivity;
import com.tencent.mobileqq.pic.PresendPicMgr;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.AdapterView;
import com.tencent.widget.GestureSelectGridView;
import java.util.ArrayList;
import java.util.ArrayList<Ljava.lang.String;>;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;

public class ainp
  extends aiml
{
  private bdil jdField_a_of_type_Bdil;
  boolean jdField_a_of_type_Boolean = false;
  boolean b = false;
  boolean c = false;
  
  ainp(NewPhotoListActivity paramNewPhotoListActivity)
  {
    super(paramNewPhotoListActivity);
  }
  
  private boolean a()
  {
    if (this.mPhotoCommonData.selectedPhotoList.size() > 0)
    {
      Iterator localIterator = this.mPhotoCommonData.selectedPhotoList.iterator();
      while (localIterator.hasNext())
      {
        String str = (String)localIterator.next();
        if (((NewPhotoListActivity)this.mActivity).a(str) == 0) {
          return false;
        }
      }
    }
    return true;
  }
  
  protected void a(Intent paramIntent, boolean paramBoolean, ArrayList<String> paramArrayList)
  {
    Object localObject = new com.tencent.util.Pair(new ArrayList(), new ArrayList());
    boolean bool;
    if (this.jdField_a_of_type_Bdil != null)
    {
      localObject = this.jdField_a_of_type_Bdil;
      if (this.mPhotoCommonData.currentQualityType == 2)
      {
        bool = true;
        paramArrayList = ((bdil)localObject).a(paramArrayList, bool, this.mPhotoCommonData.selectedMediaInfoHashMap, this.mPhotoCommonData.allMediaInfoHashMap);
        paramIntent.putStringArrayListExtra("PhotoConst.PHOTO_PATHS_BY_FILE", (ArrayList)paramArrayList.second);
      }
    }
    for (;;)
    {
      super.a(paramIntent, paramBoolean, (ArrayList)paramArrayList.first);
      return;
      bool = false;
      break;
      ((ArrayList)((com.tencent.util.Pair)localObject).first).addAll(paramArrayList);
      paramArrayList = (ArrayList<String>)localObject;
    }
  }
  
  public boolean addAndRemovePhotoByGesture(LocalMediaInfo paramLocalMediaInfo, boolean paramBoolean)
  {
    boolean bool = super.addAndRemovePhotoByGesture(paramLocalMediaInfo, paramBoolean);
    bdil localbdil;
    AbstractPhotoListActivity localAbstractPhotoListActivity;
    if ((paramBoolean) && (bool) && (this.jdField_a_of_type_Bdil != null))
    {
      localbdil = this.jdField_a_of_type_Bdil;
      localAbstractPhotoListActivity = this.mActivity;
      paramLocalMediaInfo = paramLocalMediaInfo.path;
      if (this.mPhotoCommonData.currentQualityType != 2) {
        break label79;
      }
    }
    label79:
    for (paramBoolean = true;; paramBoolean = false)
    {
      localbdil.a(localAbstractPhotoListActivity, paramLocalMediaInfo, paramBoolean, this.mPhotoCommonData.selectedMediaInfoHashMap, this.mPhotoCommonData.allMediaInfoHashMap, true);
      return bool;
    }
  }
  
  protected void b()
  {
    Intent localIntent = ((NewPhotoListActivity)this.mActivity).getIntent();
    if ((this.jdField_a_of_type_Boolean) && (this.mPhotoCommonData.jdField_a_of_type_JavaUtilHashMap != null) && (this.mPhotoCommonData.jdField_a_of_type_JavaUtilHashMap.size() > 0))
    {
      if (this.mPhotoCommonData.albumId.equals("$RecentAlbumId")) {
        azmz.a(this.mActivity).a(null, "sendAlbumRecent", true, 0L, 0L, null, "");
      }
      for (;;)
      {
        a(localIntent, true, this.mPhotoCommonData.selectedPhotoList);
        return;
        if ((this.mPhotoCommonData.albumName.equalsIgnoreCase("Camera")) || (this.mPhotoCommonData.albumName.equalsIgnoreCase("camera")) || (this.mPhotoCommonData.albumName.contains("Camera")) || (this.mPhotoCommonData.albumName.contains("camera"))) {
          azmz.a(this.mActivity).a(null, "sendAlbumRecent", false, 0L, 0L, null, "");
        } else {
          azmz.a(this.mActivity).a(null, "sendAlbumOther", true, 0L, 0L, null, "");
        }
      }
    }
    super.b();
  }
  
  public Intent caseNoSingModeImage(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    ((NewPhotoListActivity)this.mActivity).getIntent().putExtra("key_pic_to_edit_from", 3);
    azmj.b(null, "dc00898", "", "", "0X800A06C", "0X800A06C", 3, 0, this.mPhotoCommonData.selectedPhotoList.size() + "", "", "", "");
    if (((NewPhotoListActivity)this.mActivity).photoListAdapter.getItem(paramInt).selectStatus != 1) {
      if (this.mPhotoCommonData.selectedPhotoList.size() < this.mPhotoCommonData.maxSelectNum) {
        break label146;
      }
    }
    label146:
    for (int i = 2;; i = 1)
    {
      azmj.b(null, "dc00898", "", "", "0X800AB6D", "0X800AB6D", i, 0, "", "", "", "");
      return super.caseNoSingModeImage(paramAdapterView, paramView, paramInt, paramLong);
    }
  }
  
  public void caseVideo(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    if (((NewPhotoListActivity)this.mActivity).photoListAdapter.getItem(paramInt).selectStatus != 1) {
      if (this.mPhotoCommonData.selectedPhotoList.size() < this.mPhotoCommonData.maxSelectNum) {
        break label79;
      }
    }
    label79:
    for (int i = 2;; i = 1)
    {
      azmj.b(null, "dc00898", "", "", "0X800AB6D", "0X800AB6D", i, 0, "", "", "", "");
      super.caseVideo(paramAdapterView, paramView, paramInt, paramLong);
      return;
    }
  }
  
  public void enterAlbumListFragment(Intent paramIntent)
  {
    if (this.jdField_a_of_type_Aimk.a != null)
    {
      int i = PhotoUtils.c(this.jdField_a_of_type_Aimk.a);
      azmj.b(null, "CliOper", "", this.mPhotoCommonData.myUin, "0X800A915", "0X800A915", i, 0, "", "", "", "");
    }
    super.enterAlbumListFragment(paramIntent);
  }
  
  public void enterPhotoPreviewActivity(boolean paramBoolean, Intent paramIntent)
  {
    paramIntent.putExtra("key_pic_to_edit_from", 2);
    super.enterPhotoPreviewActivity(paramBoolean, paramIntent);
  }
  
  public String getExceedMaxSelectNumStr(LocalMediaInfo paramLocalMediaInfo)
  {
    int i = this.mPhotoCommonData.maxSelectNum;
    return ((NewPhotoListActivity)this.mActivity).getResources().getString(2131695258, new Object[] { Integer.valueOf(i) });
  }
  
  public void initData(Intent paramIntent)
  {
    this.mPhotoCommonData.needMediaInfo = true;
    this.b = paramIntent.getBooleanExtra("KEY_IS_ANONYMOUS", false);
    super.initData(paramIntent);
    this.jdField_a_of_type_Aimk.isSupportVideoCheckbox = true;
    this.jdField_a_of_type_Aimk.isSingleMode = false;
    this.jdField_a_of_type_Aimk.e = true;
    this.jdField_a_of_type_Aimk.c = true;
    this.jdField_a_of_type_Aimk.filter.setSupportWebp(true);
    this.jdField_a_of_type_Boolean = paramIntent.getBooleanExtra("PhotoConst.QZONE_ALBUM_FROM_AIO", false);
    this.jdField_a_of_type_Aimk.customSendBtnText = ((NewPhotoListActivity)this.mActivity).getResources().getString(2131695305);
    if (this.mPhotoCommonData.currentQualityType == 2) {
      this.c = true;
    }
    paramIntent = new bdil().a(this.mPhotoCommonData.jdField_a_of_type_Int).b(this.mPhotoCommonData.videoSizeLimit);
    if ((!this.b) && (!this.jdField_a_of_type_Aimk.l)) {}
    for (boolean bool = true;; bool = false)
    {
      this.jdField_a_of_type_Bdil = paramIntent.a(bool);
      return;
    }
  }
  
  public void onCheckBoxClick(View paramView, int paramInt, CheckBox paramCheckBox)
  {
    paramView = ((NewPhotoListActivity)this.mActivity).photoListAdapter.getItem(paramInt);
    ArrayList localArrayList = this.mPhotoCommonData.selectedPhotoList;
    if (QLog.isColorLevel()) {
      QLog.d("PhotoListActivity", 2, "current select count:" + localArrayList.size());
    }
    int k = paramView.selectStatus;
    int i;
    if ((k != 1) && (localArrayList.size() >= this.mPhotoCommonData.maxSelectNum))
    {
      i = 1;
      if (i == 0) {
        break label205;
      }
    }
    label205:
    for (int j = 2;; j = 1)
    {
      azmj.b(null, "dc00898", "", "", "0X800AB6C", "0X800AB6C", j, 0, "", "", "", "");
      if (i == 0) {
        break label211;
      }
      long l = System.currentTimeMillis();
      if (l - this.jdField_a_of_type_Aimk.lastTimeShowToast >= 1000L)
      {
        QQToast.a(this.mActivity, getExceedMaxSelectNumStr(paramView), 0).b(((NewPhotoListActivity)this.mActivity).mTitleBarHeight);
        paramCheckBox.setChecked(false);
        this.jdField_a_of_type_Aimk.lastTimeShowToast = l;
        e();
      }
      return;
      i = 0;
      break;
    }
    label211:
    boolean bool1;
    label237:
    PresendPicMgr localPresendPicMgr;
    Object localObject1;
    boolean bool2;
    if (k == 1)
    {
      i = 2;
      paramView.selectStatus = i;
      if (paramView.selectStatus != 1) {
        break label726;
      }
      bool1 = true;
      paramCheckBox = paramView.path;
      localPresendPicMgr = PresendPicMgr.a();
      localObject1 = MimeHelper.getMimeType(paramView.mMimeType);
      if (!bool1) {
        break label738;
      }
      Object localObject2;
      if (this.jdField_a_of_type_Bdil != null)
      {
        localObject2 = this.jdField_a_of_type_Bdil;
        AbstractPhotoListActivity localAbstractPhotoListActivity = this.mActivity;
        if (this.mPhotoCommonData.currentQualityType != 2) {
          break label732;
        }
        bool2 = true;
        label294:
        ((bdil)localObject2).a(localAbstractPhotoListActivity, paramCheckBox, bool2, this.mPhotoCommonData.selectedMediaInfoHashMap, this.mPhotoCommonData.allMediaInfoHashMap, true);
      }
      if ((this.jdField_a_of_type_Aimk.isSupportVideoCheckbox) && (localObject1 != null) && ("video".equals(localObject1[0])))
      {
        localObject2 = this.jdField_a_of_type_Aimk;
        ((aimk)localObject2).videoSelectedCnt += 1;
        if (this.jdField_a_of_type_Aimk.videoSelectedCnt == 1) {
          this.jdField_a_of_type_Aimk.selectedVideoInfo = paramView;
        }
      }
      if ((!TextUtils.isEmpty(paramView.mMimeType)) && ("image/gif".equals(paramView.mMimeType)))
      {
        localObject2 = this.jdField_a_of_type_Aimk;
        ((aimk)localObject2).gifSelectedCount += 1;
      }
      localArrayList.add(paramCheckBox);
      this.mPhotoCommonData.selectedIndex.add(paramView.position);
      if (this.mPhotoCommonData.needMediaInfo) {
        this.mPhotoCommonData.selectedMediaInfoHashMap.put(paramCheckBox, paramView);
      }
      if ((localPresendPicMgr != null) && (localObject1 != null) && (localObject1[0] != null) && (!"video".equals(localObject1[0]))) {
        localPresendPicMgr.a(paramCheckBox, 1052, ((NewPhotoListActivity)this.mActivity).getIntent().getIntExtra("entrance", 0));
      }
      aild.a(((NewPhotoListActivity)this.mActivity).getIntent(), "param_totalSelNum");
      paramView = ((NewPhotoListActivity)this.mActivity).getIntent();
      if (!paramView.hasExtra("param_initTime")) {
        paramView.putExtra("param_initTime", System.currentTimeMillis());
      }
      paramView = (LinkedHashMap)bdar.sSelectItemPosMap.get(this.mPhotoCommonData.albumId);
      if (paramView != null) {
        break label972;
      }
      paramView = new LinkedHashMap();
      bdar.sSelectItemPosMap.put(this.mPhotoCommonData.albumId, paramView);
    }
    label680:
    label972:
    for (;;)
    {
      paramView.put(paramCheckBox, Integer.valueOf(((NewPhotoListActivity)this.mActivity).mGridView.getFirstVisiblePosition()));
      paramView = bdar.sSelectItemAlbum;
      if (!paramView.containsKey(paramCheckBox)) {
        paramView.put(paramCheckBox, new android.util.Pair(this.mPhotoCommonData.albumId, this.mPhotoCommonData.albumName));
      }
      ((NewPhotoListActivity)this.mActivity).updateCheckbox(paramInt, bool1);
      paramView = (NewPhotoListActivity)this.mActivity;
      if (!bool1) {}
      for (bool1 = true;; bool1 = false)
      {
        paramView.selectLimitRemind(bool1);
        updateButton();
        return;
        i = 1;
        break;
        label726:
        bool1 = false;
        break label237;
        label732:
        bool2 = false;
        break label294;
        label738:
        if ((this.jdField_a_of_type_Aimk.isSupportVideoCheckbox) && (localObject1 != null) && ("video".equals(localObject1[0])))
        {
          localObject1 = this.jdField_a_of_type_Aimk;
          ((aimk)localObject1).videoSelectedCnt -= 1;
          if (this.jdField_a_of_type_Aimk.videoSelectedCnt == 1) {
            this.jdField_a_of_type_Aimk.selectedVideoInfo = paramView;
          }
        }
        if ((!TextUtils.isEmpty(paramView.mMimeType)) && ("image/gif".equals(paramView.mMimeType)))
        {
          localObject1 = this.jdField_a_of_type_Aimk;
          ((aimk)localObject1).gifSelectedCount -= 1;
        }
        localArrayList.remove(paramCheckBox);
        this.mPhotoCommonData.selectedIndex.remove(paramView.position);
        if (this.mPhotoCommonData.needMediaInfo) {
          this.mPhotoCommonData.selectedMediaInfoHashMap.remove(paramCheckBox);
        }
        if (localPresendPicMgr != null) {
          localPresendPicMgr.b(paramCheckBox, 1013);
        }
        aild.a(((NewPhotoListActivity)this.mActivity).getIntent(), "param_cancelSelNum");
        paramView = (HashMap)bdar.sSelectItemPosMap.get(this.mPhotoCommonData.albumId);
        if (paramView != null) {
          paramView.remove(paramCheckBox);
        }
        paramView = bdar.sSelectItemAlbum;
        if (!paramView.containsKey(paramCheckBox)) {
          break label680;
        }
        paramView.remove(paramCheckBox);
        break label680;
      }
    }
  }
  
  public void onPreviewBtnClick(View paramView)
  {
    super.onPreviewBtnClick(paramView);
    azmj.b(null, "dc00898", "", "", "0X800A06C", "0X800A06C", 2, 0, this.mPhotoCommonData.selectedPhotoList.size() + "", "", "", "");
  }
  
  public void onQualityBtnClick(CompoundButton paramCompoundButton, boolean paramBoolean)
  {
    if (paramBoolean) {
      if (this.jdField_a_of_type_Bdil != null)
      {
        if (!this.c) {
          this.jdField_a_of_type_Bdil.a(this.mActivity, this.mPhotoCommonData.selectedPhotoList, paramBoolean, this.mPhotoCommonData.selectedMediaInfoHashMap, this.mPhotoCommonData.allMediaInfoHashMap);
        }
      }
      else
      {
        this.mPhotoCommonData.currentQualityType = 2;
        ((NewPhotoListActivity)this.mActivity).jdField_a_of_type_AndroidWidgetCheckBox.setChecked(true);
        ((NewPhotoListActivity)this.mActivity).b.setVisibility(0);
        d();
      }
    }
    for (;;)
    {
      if (!this.jdField_a_of_type_Aimk.d) {
        ((NewPhotoListActivity)this.mActivity).b.setVisibility(8);
      }
      return;
      this.c = false;
      break;
      this.mPhotoCommonData.currentQualityType = 0;
      ((NewPhotoListActivity)this.mActivity).jdField_a_of_type_AndroidWidgetCheckBox.setChecked(false);
      ((NewPhotoListActivity)this.mActivity).b.setVisibility(4);
    }
  }
  
  public void onTitleBtnCancelClick(View paramView)
  {
    if (this.jdField_a_of_type_Aimk.a != null)
    {
      int i = PhotoUtils.c(this.jdField_a_of_type_Aimk.a);
      azmj.b(null, "CliOper", "", this.mPhotoCommonData.myUin, "0X800A916", "0X800A916", i, 0, "", "", "", "");
    }
    super.onTitleBtnCancelClick(paramView);
  }
  
  public void updateButton()
  {
    super.updateButton();
    if (this.mPhotoCommonData.selectedPhotoList.size() > 0) {}
    for (int i = 1;; i = 0)
    {
      if (i != 0)
      {
        if ((this.mPhotoCommonData.jdField_a_of_type_JavaUtilHashMap == null) || (this.mPhotoCommonData.jdField_a_of_type_JavaUtilHashMap.size() <= 0) || (this.mPhotoCommonData.selectedPhotoList.size() != this.mPhotoCommonData.jdField_a_of_type_JavaUtilHashMap.size())) {
          break;
        }
        ((NewPhotoListActivity)this.mActivity).jdField_a_of_type_AndroidWidgetButton.setEnabled(false);
      }
      return;
    }
    if (a())
    {
      ((NewPhotoListActivity)this.mActivity).jdField_a_of_type_AndroidWidgetButton.setEnabled(false);
      return;
    }
    Button localButton = ((NewPhotoListActivity)this.mActivity).jdField_a_of_type_AndroidWidgetButton;
    if (this.mPhotoCommonData.selectedPhotoList.size() == 1) {}
    for (boolean bool = true;; bool = false)
    {
      localButton.setEnabled(bool);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ainp
 * JD-Core Version:    0.7.0.1
 */