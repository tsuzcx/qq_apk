import NS_MOBILE_OPERATION.PicInfo;
import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.TextView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.component.media.image.ImageManager;
import com.tencent.component.network.utils.NetworkUtils;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.activity.photo.PhotoSendParams;
import com.tencent.mobileqq.activity.photo.PhotoUtils;
import com.tencent.mobileqq.activity.photo.album.NewPhotoPreviewActivity;
import com.tencent.mobileqq.activity.photo.album.logicImp.PhotoPreviewLogicAIO.2;
import com.tencent.mobileqq.activity.shortvideo.SendVideoActivity.SendVideoInfo;
import com.tencent.mobileqq.pic.PresendPicMgr;
import com.tencent.mobileqq.widget.NumberCheckBox;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.BinderWarpper;
import com.tencent.util.Pair;
import com.tencent.widget.AdapterView;
import cooperation.qzone.report.lp.LpReportInfo_pf00064;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import mqq.util.WeakReference;

public class agut
  extends agta
{
  private bbjp a;
  public boolean a;
  boolean b = false;
  boolean c;
  
  protected agut(NewPhotoPreviewActivity paramNewPhotoPreviewActivity)
  {
    super(paramNewPhotoPreviewActivity);
    this.jdField_c_of_type_Boolean = false;
  }
  
  public static agsq b(NewPhotoPreviewActivity paramNewPhotoPreviewActivity)
  {
    if ((jdField_a_of_type_Agsq == null) || (jdField_a_of_type_Agsq.jdField_a_of_type_MqqUtilWeakReference.get() != paramNewPhotoPreviewActivity)) {}
    try
    {
      if ((jdField_a_of_type_Agsq == null) || (jdField_a_of_type_Agsq.jdField_a_of_type_MqqUtilWeakReference.get() != paramNewPhotoPreviewActivity)) {
        jdField_a_of_type_Agsq = new agut(paramNewPhotoPreviewActivity);
      }
      return jdField_a_of_type_Agsq;
    }
    finally {}
  }
  
  void a(int paramInt)
  {
    ((NewPhotoPreviewActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).jdField_a_of_type_AndroidWidgetButton.setVisibility(paramInt);
    ((NewPhotoPreviewActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).jdField_b_of_type_AndroidWidgetCheckBox.setVisibility(paramInt);
    ((NewPhotoPreviewActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).jdField_b_of_type_AndroidWidgetTextView.setVisibility(paramInt);
    if (paramInt == 0)
    {
      if (!this.jdField_a_of_type_Agsp.f)
      {
        ((NewPhotoPreviewActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).jdField_b_of_type_AndroidWidgetCheckBox.setVisibility(8);
        ((NewPhotoPreviewActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
      }
      if (!this.jdField_a_of_type_Agsp.g) {
        ((NewPhotoPreviewActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).jdField_a_of_type_AndroidWidgetButton.setVisibility(8);
      }
      if ((this.jdField_a_of_type_Agsp.l) && (this.jdField_a_of_type_Agsp.jdField_e_of_type_JavaUtilHashMap.size() == 0))
      {
        ((NewPhotoPreviewActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).jdField_a_of_type_AndroidWidgetCheckBox.setVisibility(0);
        ((NewPhotoPreviewActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
        ((NewPhotoPreviewActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).jdField_a_of_type_AndroidWidgetCheckBox.setOnCheckedChangeListener((CompoundButton.OnCheckedChangeListener)this.jdField_a_of_type_MqqUtilWeakReference.get());
        ((NewPhotoPreviewActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).jdField_a_of_type_AndroidWidgetTextView.setOnClickListener(new aguu(this));
        ((NewPhotoPreviewActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).jdField_a_of_type_AndroidWidgetCheckBox.setContentDescription("闪照");
        ((NewPhotoPreviewActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).jdField_a_of_type_AndroidWidgetTextView.setContentDescription("闪照");
      }
    }
    while (((NewPhotoPreviewActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).jdField_a_of_type_AndroidWidgetCheckBox.getVisibility() != 0) {
      return;
    }
    ((NewPhotoPreviewActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).jdField_a_of_type_AndroidWidgetCheckBox.setVisibility(paramInt);
    ((NewPhotoPreviewActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).jdField_a_of_type_AndroidWidgetTextView.setVisibility(paramInt);
  }
  
  protected void a(Intent paramIntent)
  {
    this.jdField_a_of_type_Agsp.g = true;
    this.jdField_a_of_type_Boolean = paramIntent.getBooleanExtra("PhotoConst.QZONE_ALBUM_FROM_AIO", false);
    this.b = paramIntent.getBooleanExtra("KEY_IS_ANONYMOUS", false);
    super.a(paramIntent);
    if (!this.jdField_a_of_type_Agsp.jdField_c_of_type_Boolean)
    {
      Object localObject = (BinderWarpper)paramIntent.getParcelableExtra("binder_presendService");
      if (localObject != null)
      {
        if (PresendPicMgr.a(null) != null) {
          PresendPicMgr.a(null).b();
        }
        localObject = PresendPicMgr.b(aund.a(((BinderWarpper)localObject).a));
        this.jdField_a_of_type_Agsp.j = 1037;
        paramIntent = (String)paramIntent.getStringArrayListExtra("PhotoConst.PHOTO_PATHS").get(0);
        if (((NewPhotoPreviewActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).a(paramIntent) != 1) {
          ((PresendPicMgr)localObject).a(paramIntent, this.jdField_a_of_type_Agsp.j);
        }
      }
    }
    this.jdField_a_of_type_Agsp.jdField_b_of_type_JavaLangString = ((NewPhotoPreviewActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).getResources().getString(2131695147);
    agqd.c();
    if (this.jdField_a_of_type_Agrz.c == 2) {
      this.jdField_c_of_type_Boolean = true;
    }
    paramIntent = new bbjp().a(this.jdField_a_of_type_Agrz.jdField_b_of_type_Int).b(this.jdField_a_of_type_Agrz.jdField_b_of_type_Long);
    if ((!this.b) && (!this.jdField_a_of_type_Agsp.p)) {}
    for (boolean bool = true;; bool = false)
    {
      this.jdField_a_of_type_Bbjp = paramIntent.a(bool);
      return;
    }
  }
  
  public void a(Intent paramIntent, boolean paramBoolean, ArrayList<String> paramArrayList)
  {
    localPair = new Pair(new ArrayList(), new ArrayList());
    if (this.jdField_a_of_type_Bbjp != null)
    {
      localObject1 = this.jdField_a_of_type_Bbjp;
      if (this.jdField_a_of_type_Agrz.c == 2) {
        bool = true;
      }
    }
    for (;;)
    {
      paramArrayList = ((bbjp)localObject1).a(paramArrayList, bool, this.jdField_a_of_type_Agrz.jdField_a_of_type_JavaUtilHashMap, this.jdField_a_of_type_Agrz.jdField_b_of_type_JavaUtilHashMap);
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
        if (((NewPhotoPreviewActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).a((String)localObject1) == 1)
        {
          localObject1 = ((NewPhotoPreviewActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).b((String)localObject1);
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
        break label837;
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
            PhotoUtils.a((Activity)this.jdField_a_of_type_MqqUtilWeakReference.get(), paramIntent, (ArrayList)localPair.first, this.jdField_a_of_type_Agsp.jdField_c_of_type_JavaUtilHashMap, this.jdField_a_of_type_Agrz.c, true);
            ((NewPhotoPreviewActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).setResult(-1);
            ((NewPhotoPreviewActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).finish();
          }
          for (;;)
          {
            axqy.b(null, "CliOper", "", "", "0X8009AB1", "0X8009AB1", m, 0, (String)localObject1, (String)localObject2, "", "");
            return;
            PhotoUtils.a((Activity)this.jdField_a_of_type_MqqUtilWeakReference.get(), paramIntent, (ArrayList)localPair.first, this.jdField_a_of_type_Agrz.c, this.jdField_a_of_type_Agsp.jdField_e_of_type_Boolean);
          }
          i = 0;
        }
      }
    }
    if ((axdq.jdField_b_of_type_Long != 0L) && (System.currentTimeMillis() - axdq.jdField_b_of_type_Long < 300000L))
    {
      bool = true;
      if (QLog.isColorLevel()) {
        QLog.d("PhotoPreviewActivity", 2, "upload video isConfirmed=" + bool + " allowUploadInXGTime=" + axdq.jdField_b_of_type_Long);
      }
      if ((!bbfj.b(BaseApplicationImpl.getContext())) || (bool) || (i == 0) || (!b())) {
        break label697;
      }
      paramArrayList = ((NewPhotoPreviewActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).getResources().getString(2131719257);
      paramIntent = new PhotoPreviewLogicAIO.2(this, paramBoolean, paramIntent, localPair, m, (String)localObject1, (String)localObject2);
      if (bcwb.a((Activity)this.jdField_a_of_type_MqqUtilWeakReference.get(), 4, new aguv(this, paramIntent))) {
        bbdj.a((Context)this.jdField_a_of_type_MqqUtilWeakReference.get(), 232, null, paramArrayList, new aguw(this, paramIntent), new agux(this)).show();
      }
      if (QLog.isColorLevel()) {
        QLog.i("PhotoPreviewActivity", 2, "show shortvideo_mobile_send_confirm dialog");
      }
    }
  }
  
  protected void a(View paramView)
  {
    ((NewPhotoPreviewActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).getResources();
    paramView = PresendPicMgr.a(null);
    int k = ((NewPhotoPreviewActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).a();
    int i;
    if (this.jdField_a_of_type_Agrz.jdField_b_of_type_JavaUtilArrayList.contains(Integer.valueOf(k)))
    {
      ((NewPhotoPreviewActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).jdField_a_of_type_ComTencentMobileqqWidgetNumberCheckBox.setChecked(false);
      i = this.jdField_a_of_type_Agrz.jdField_b_of_type_JavaUtilArrayList.indexOf(Integer.valueOf(k));
      if (i >= 0)
      {
        this.jdField_a_of_type_Agrz.jdField_b_of_type_JavaUtilArrayList.remove(i);
        if (k != -1)
        {
          this.jdField_a_of_type_Agrz.jdField_a_of_type_JavaUtilArrayList.remove(this.jdField_a_of_type_Agsp.jdField_a_of_type_JavaUtilArrayList.get(k));
          if (this.jdField_a_of_type_Agsp.jdField_e_of_type_JavaUtilHashMap != null) {
            this.jdField_a_of_type_Agsp.jdField_e_of_type_JavaUtilHashMap.remove(this.jdField_a_of_type_Agsp.jdField_a_of_type_JavaUtilArrayList.get(k));
          }
          if (this.jdField_a_of_type_Agsp.jdField_c_of_type_JavaUtilHashMap != null) {
            this.jdField_a_of_type_Agsp.jdField_c_of_type_JavaUtilHashMap.remove(this.jdField_a_of_type_Agsp.jdField_a_of_type_JavaUtilArrayList.get(k));
          }
          if (paramView != null) {
            paramView.b((String)this.jdField_a_of_type_Agsp.jdField_a_of_type_JavaUtilArrayList.get(k), 1014);
          }
        }
      }
      d();
      if ((this.jdField_a_of_type_Agrz.jdField_b_of_type_JavaUtilArrayList.size() == 0) && (!this.jdField_a_of_type_Agsp.m)) {
        this.jdField_a_of_type_Agsp.o = false;
      }
      LpReportInfo_pf00064.allReport(603, 2);
      return;
    }
    if (this.jdField_a_of_type_Agrz.jdField_a_of_type_JavaUtilArrayList.size() >= this.jdField_a_of_type_Agrz.jdField_a_of_type_Int)
    {
      i = 1;
      if (i == 0) {
        break label467;
      }
    }
    label467:
    for (int j = 2;; j = 1)
    {
      axqy.b(null, "dc00898", "", "", "0X800AB6E", "0X800AB6E", j, 0, "", "", "", "");
      if (i == 0) {
        break label472;
      }
      long l = System.currentTimeMillis();
      if (l - this.jdField_a_of_type_Agsp.jdField_a_of_type_Long >= 700L)
      {
        bcql.a((Context)this.jdField_a_of_type_MqqUtilWeakReference.get(), ((NewPhotoPreviewActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).a(), 1000).b(this.jdField_a_of_type_Agsp.jdField_a_of_type_Int);
        this.jdField_a_of_type_Agsp.jdField_a_of_type_Long = l;
        if (this.jdField_a_of_type_Agsp.p) {
          axqy.b(null, "CliOper", "", "", "0x80083EC", "0x80083EC", 0, 0, "", "", "", "");
        }
      }
      ((NewPhotoPreviewActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).jdField_a_of_type_ComTencentMobileqqWidgetNumberCheckBox.setChecked(false);
      return;
      i = 0;
      break;
    }
    label472:
    Object localObject;
    Context localContext;
    if (k != -1)
    {
      localObject = (String)this.jdField_a_of_type_Agsp.jdField_a_of_type_JavaUtilArrayList.get(k);
      ((NewPhotoPreviewActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).b((String)localObject);
      if ((paramView != null) && (!this.jdField_a_of_type_Agsp.m) && (((NewPhotoPreviewActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).a((String)this.jdField_a_of_type_Agsp.jdField_a_of_type_JavaUtilArrayList.get(k)) != 1)) {
        paramView.a((String)this.jdField_a_of_type_Agsp.jdField_a_of_type_JavaUtilArrayList.get(k), this.jdField_a_of_type_Agsp.j);
      }
      paramView = (String)this.jdField_a_of_type_Agsp.jdField_a_of_type_JavaUtilArrayList.get(k);
      this.jdField_a_of_type_Agrz.jdField_a_of_type_JavaUtilArrayList.add(paramView);
      if (this.jdField_a_of_type_Agsp.jdField_b_of_type_JavaUtilHashMap != null)
      {
        localObject = (PhotoSendParams)this.jdField_a_of_type_Agsp.jdField_b_of_type_JavaUtilHashMap.get(paramView);
        if ((this.jdField_a_of_type_Agsp.jdField_c_of_type_JavaUtilHashMap != null) && (localObject != null)) {
          this.jdField_a_of_type_Agsp.jdField_c_of_type_JavaUtilHashMap.put(paramView, localObject);
        }
      }
      if (this.jdField_a_of_type_Agsp.d != null)
      {
        localObject = (PicInfo)this.jdField_a_of_type_Agsp.d.get(paramView);
        if ((this.jdField_a_of_type_Agsp.jdField_e_of_type_JavaUtilHashMap != null) && (localObject != null)) {
          this.jdField_a_of_type_Agsp.jdField_e_of_type_JavaUtilHashMap.put(paramView, localObject);
        }
      }
      this.jdField_a_of_type_Agrz.jdField_b_of_type_JavaUtilArrayList.add(Integer.valueOf(k));
      ((NewPhotoPreviewActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).a(paramView);
      if (this.jdField_a_of_type_Bbjp != null)
      {
        localObject = this.jdField_a_of_type_Bbjp;
        localContext = (Context)this.jdField_a_of_type_MqqUtilWeakReference.get();
        if (this.jdField_a_of_type_Agrz.c != 2) {
          break label823;
        }
      }
    }
    label823:
    for (boolean bool = true;; bool = false)
    {
      ((bbjp)localObject).a(localContext, paramView, bool, this.jdField_a_of_type_Agrz.jdField_a_of_type_JavaUtilHashMap, this.jdField_a_of_type_Agrz.jdField_b_of_type_JavaUtilHashMap, true);
      d();
      break;
    }
  }
  
  protected void a(View paramView, int paramInt1, Bundle paramBundle, int paramInt2, Intent paramIntent)
  {
    paramBundle.putBoolean("key_multi_edit_pic", true);
    paramBundle.putBoolean("key_enable_edit_title_bar", true);
    super.a(paramView, 10000, paramBundle, 2, null);
  }
  
  public void a(CompoundButton paramCompoundButton, boolean paramBoolean)
  {
    if (paramBoolean)
    {
      ((NewPhotoPreviewActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).jdField_a_of_type_AndroidWidgetCheckBox.setChecked(false);
      ((NewPhotoPreviewActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).jdField_a_of_type_AndroidWidgetTextView.setTextColor(2147483647);
      if (this.jdField_a_of_type_Bbjp != null)
      {
        if (this.jdField_c_of_type_Boolean) {
          break label193;
        }
        this.jdField_a_of_type_Bbjp.a((Context)this.jdField_a_of_type_MqqUtilWeakReference.get(), this.jdField_a_of_type_Agrz.jdField_a_of_type_JavaUtilArrayList, paramBoolean, this.jdField_a_of_type_Agrz.jdField_a_of_type_JavaUtilHashMap, this.jdField_a_of_type_Agrz.jdField_b_of_type_JavaUtilHashMap);
      }
      for (;;)
      {
        this.jdField_a_of_type_Agrz.c = 2;
        ((NewPhotoPreviewActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).jdField_b_of_type_AndroidWidgetCheckBox.setChecked(true);
        d();
        paramCompoundButton = ((NewPhotoPreviewActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).getIntent();
        if ((paramCompoundButton != null) && (paramCompoundButton.hasExtra("custom_photopreview_rawcheckbox_reportActionName")))
        {
          paramCompoundButton = paramCompoundButton.getStringExtra("custom_photopreview_rawcheckbox_reportActionName");
          if (paramCompoundButton != null) {
            axqy.b(null, "CliOper", "", "", paramCompoundButton, paramCompoundButton, 0, 0, "", "", "", "");
          }
        }
        return;
        label193:
        this.jdField_c_of_type_Boolean = false;
      }
    }
    ((NewPhotoPreviewActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).jdField_a_of_type_AndroidWidgetTextView.setTextColor(-1);
    this.jdField_a_of_type_Agrz.c = 0;
    ((NewPhotoPreviewActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).jdField_b_of_type_AndroidWidgetCheckBox.setChecked(false);
  }
  
  protected void a(TextView paramTextView)
  {
    Object localObject = this.jdField_a_of_type_Agrz.jdField_a_of_type_JavaUtilArrayList.iterator();
    while (((Iterator)localObject).hasNext())
    {
      String str = (String)((Iterator)localObject).next();
      if ((!NetworkUtils.isNetworkUrl(str)) && (((NewPhotoPreviewActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).a(str) == 1)) {
        paramTextView.setText(((NewPhotoPreviewActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).getString(2131695117));
      }
    }
    int i = bbbx.a(this.jdField_a_of_type_Agrz.jdField_a_of_type_JavaUtilArrayList, this.jdField_a_of_type_Agrz.jdField_b_of_type_JavaUtilHashMap, true, this.jdField_a_of_type_Agsp.jdField_c_of_type_JavaUtilHashMap, this.jdField_a_of_type_Agrz.jdField_a_of_type_JavaUtilHashMap);
    if (i == 0)
    {
      paramTextView.setText(((NewPhotoPreviewActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).getString(2131695117));
      return;
    }
    localObject = PhotoUtils.a((Context)this.jdField_a_of_type_MqqUtilWeakReference.get(), i);
    if ((this.jdField_a_of_type_Agrz.jdField_a_of_type_JavaUtilArrayList.size() == 0) || (((String)localObject).equals("0"))) {}
    for (localObject = ((NewPhotoPreviewActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).getString(2131695117);; localObject = ((NewPhotoPreviewActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).getString(2131695117) + "(共" + (String)localObject + ")")
    {
      paramTextView.setText((CharSequence)localObject);
      return;
    }
  }
  
  protected void a(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    LocalMediaInfo localLocalMediaInfo = ((NewPhotoPreviewActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).b(((NewPhotoPreviewActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).jdField_a_of_type_Agrw.a(paramInt));
    if ((localLocalMediaInfo != null) && (((NewPhotoPreviewActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).a(localLocalMediaInfo.path) == 1)) {
      if ((this.jdField_a_of_type_Agsp.jdField_e_of_type_Int == 0) || (this.jdField_a_of_type_Agsp.jdField_e_of_type_Int == 1) || (this.jdField_a_of_type_Agsp.jdField_e_of_type_Int == 3000)) {
        b(8);
      }
    }
    for (;;)
    {
      super.a(paramAdapterView, paramView, paramInt, paramLong);
      return;
      a(8);
      continue;
      a(0);
    }
  }
  
  public boolean a()
  {
    return (this.jdField_a_of_type_Agrz.jdField_a_of_type_JavaUtilArrayList != null) && (!this.jdField_a_of_type_Agrz.jdField_a_of_type_JavaUtilArrayList.isEmpty());
  }
  
  void b(int paramInt)
  {
    ((NewPhotoPreviewActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).jdField_a_of_type_AndroidWidgetButton.setVisibility(paramInt);
    ((NewPhotoPreviewActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).jdField_b_of_type_AndroidWidgetCheckBox.setVisibility(0);
    ((NewPhotoPreviewActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
    if (((NewPhotoPreviewActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).jdField_a_of_type_AndroidWidgetCheckBox.getVisibility() == 0)
    {
      ((NewPhotoPreviewActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).jdField_a_of_type_AndroidWidgetCheckBox.setVisibility(paramInt);
      ((NewPhotoPreviewActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).jdField_a_of_type_AndroidWidgetTextView.setVisibility(paramInt);
    }
  }
  
  protected void c()
  {
    super.c();
    if ((this.jdField_a_of_type_Boolean) && (this.jdField_a_of_type_Agsp.jdField_c_of_type_JavaUtilHashMap.size() != 0)) {
      ((NewPhotoPreviewActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).jdField_a_of_type_AndroidWidgetButton.setVisibility(8);
    }
  }
  
  protected boolean c()
  {
    Object localObject = (String)this.jdField_a_of_type_Agsp.jdField_a_of_type_JavaUtilArrayList.get(((NewPhotoPreviewActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).a());
    if (((NewPhotoPreviewActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).a((String)localObject) == 1)
    {
      localObject = ((NewPhotoPreviewActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).b((String)localObject);
      if ((localObject != null) && (((LocalMediaInfo)localObject).fileSize > 104345600L))
      {
        bcql.a((Context)this.jdField_a_of_type_MqqUtilWeakReference.get(), ((NewPhotoPreviewActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).getResources().getString(2131719589), 0).b(((NewPhotoPreviewActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).getResources().getDimensionPixelSize(2131298865));
        bbbx.d();
      }
      return false;
    }
    return super.c();
  }
  
  protected void h()
  {
    if ("FROM_QZONE_PHOTO_LIST".equals(this.jdField_a_of_type_Agsp.jdField_a_of_type_JavaLangString))
    {
      Object localObject = ((NewPhotoPreviewActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).a();
      if ((localObject != null) && (((ArrayList)localObject).size() == 1))
      {
        localObject = (String)((ArrayList)localObject).get(0);
        if ((localObject != null) && (((String)localObject).startsWith("http")))
        {
          PhotoSendParams localPhotoSendParams = (PhotoSendParams)this.jdField_a_of_type_Agsp.jdField_b_of_type_JavaUtilHashMap.get(localObject);
          if (localPhotoSendParams != null) {
            this.jdField_a_of_type_Agsp.jdField_c_of_type_JavaUtilHashMap.put(localObject, localPhotoSendParams);
          }
        }
      }
      if (this.jdField_a_of_type_Agrz.jdField_a_of_type_JavaUtilArrayList.size() != 0) {
        if (((NewPhotoPreviewActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).getIntent().getParcelableExtra("PhotoConst.sendToAIOIntent") == null) {
          break label178;
        }
      }
      label178:
      for (localObject = (Intent)((NewPhotoPreviewActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).getIntent().getParcelableExtra("PhotoConst.sendToAIOIntent");; localObject = ((NewPhotoPreviewActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).getIntent())
      {
        a((Intent)localObject, true, ((NewPhotoPreviewActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).a());
        return;
      }
    }
    super.h();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     agut
 * JD-Core Version:    0.7.0.1
 */