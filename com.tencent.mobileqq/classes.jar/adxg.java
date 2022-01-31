import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Point;
import android.graphics.Rect;
import android.os.Bundle;
import android.os.IBinder;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.common.galleryactivity.AbstractImageAdapter;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.activity.aio.photo.AIOFilePicData;
import com.tencent.mobileqq.activity.aio.photo.AIOImageData;
import com.tencent.mobileqq.activity.aio.photo.AIOImageListScene.7;
import com.tencent.mobileqq.activity.aio.photo.AIOImageListScene.8;
import com.tencent.mobileqq.activity.aio.photo.AIORichMediaData;
import com.tencent.mobileqq.activity.aio.photo.AIOShortVideoData;
import com.tencent.mobileqq.activity.photo.SendPhotoActivity;
import com.tencent.mobileqq.msf.sdk.SettingCloneUtil;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.AbsListView;
import com.tencent.widget.GestureSelectGridView;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class adxg
  extends xgn
  implements advu, DialogInterface.OnCancelListener, begh
{
  long jdField_a_of_type_Long;
  public adxf a;
  adxo jdField_a_of_type_Adxo;
  adye jdField_a_of_type_Adye;
  String jdField_a_of_type_JavaLangString;
  public ArrayList<adyb> a;
  int jdField_b_of_type_Int = 1;
  String jdField_b_of_type_JavaLangString;
  int jdField_c_of_type_Int;
  String jdField_c_of_type_JavaLangString;
  boolean jdField_c_of_type_Boolean = false;
  private int jdField_d_of_type_Int;
  String jdField_d_of_type_JavaLangString;
  
  public adxg(Activity paramActivity, xgm paramxgm, adye paramadye, String paramString)
  {
    super(paramActivity, paramxgm);
    this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
    this.jdField_a_of_type_Adxf = ((adxf)paramxgm);
    this.jdField_a_of_type_Adye = paramadye;
    this.jdField_a_of_type_JavaLangString = paramString;
    if (TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)) {
      this.jdField_a_of_type_JavaLangString = "0";
    }
  }
  
  public static void a(Context paramContext, Intent paramIntent)
  {
    Intent localIntent = new Intent(paramContext, SendPhotoActivity.class);
    paramIntent = new Bundle(paramIntent.getExtras());
    if (QLog.isColorLevel()) {
      QLog.d("forward", 2, "AIOListGallerysence startChatAndSendMsg IS_WAIT_DEST_RESULT=true");
    }
    paramIntent.putBoolean("PhotoConst.HANDLE_DEST_RESULT", true);
    paramIntent.putInt("PhotoConst.SEND_BUSINESS_TYPE", 1031);
    localIntent.putExtra("PhotoConst.INIT_ACTIVITY_CLASS_NAME", SplashActivity.class.getName());
    localIntent = aciy.a(localIntent, null);
    localIntent.putExtra("PhotoConst.INIT_ACTIVITY_PACKAGE_NAME", "com.tencent.mobileqq");
    paramIntent.putBoolean("PicContants.NEED_COMPRESS", false);
    paramIntent.putBoolean("send_in_background", false);
    localIntent.putExtras(paramIntent);
    paramContext.startActivity(localIntent);
  }
  
  public int a()
  {
    if ((this.jdField_a_of_type_JavaUtilArrayList == null) || (this.jdField_a_of_type_JavaUtilArrayList.isEmpty())) {
      return 0;
    }
    AIORichMediaData localAIORichMediaData = ((adyb)this.jdField_a_of_type_JavaUtilArrayList.get(0)).jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData;
    if ((AIOImageData.class.isInstance(localAIORichMediaData)) || (AIOFilePicData.class.isInstance(localAIORichMediaData))) {
      return 1;
    }
    if (AIOShortVideoData.class.isInstance(localAIORichMediaData)) {
      return 2;
    }
    return 0;
  }
  
  public Rect a()
  {
    int i = this.jdField_a_of_type_ComTencentWidgetGestureSelectGridView.getFirstVisiblePosition();
    int j = this.jdField_a_of_type_Adxf.f();
    View localView = this.jdField_a_of_type_ComTencentWidgetGestureSelectGridView.getChildAt(j - i);
    if (localView != null)
    {
      Rect localRect = new Rect(localView.getPaddingLeft(), localView.getPaddingTop(), localView.getWidth() - localView.getPaddingRight(), localView.getHeight() - localView.getPaddingBottom());
      i = localView.getWidth();
      j = localView.getHeight();
      ViewGroup localViewGroup = (ViewGroup)localView.getParent();
      Point localPoint = new Point();
      if ((i > 0) && (j > 0))
      {
        localPoint.set(-localView.getScrollX(), -localView.getScrollY());
        if (localViewGroup != null) {
          localViewGroup.getChildVisibleRect(localView, localRect, localPoint);
        }
      }
      return localRect;
    }
    return null;
  }
  
  protected View.OnClickListener a()
  {
    return new adxn(this);
  }
  
  protected behi a()
  {
    return new adxl(this);
  }
  
  protected bejw a()
  {
    return new adxm(this);
  }
  
  protected AbstractImageAdapter a(Activity paramActivity, int paramInt)
  {
    this.jdField_a_of_type_ComTencentCommonGalleryactivityAbstractImageAdapter = new adxv(this.jdField_a_of_type_AndroidAppActivity, paramInt, this.jdField_a_of_type_Adxf, this.jdField_a_of_type_Adye, this.jdField_a_of_type_ComTencentWidgetGestureSelectGridView);
    this.jdField_a_of_type_ComTencentCommonGalleryactivityAbstractImageAdapter.a(this.jdField_a_of_type_Adxf);
    return this.jdField_a_of_type_ComTencentCommonGalleryactivityAbstractImageAdapter;
  }
  
  void a(int paramInt1, int paramInt2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("AIOImageListScene", 2, "showDownloadResult type = " + paramInt1);
    }
    if (this.jdField_a_of_type_Bafb != null) {
      this.jdField_a_of_type_Bafb.dismiss();
    }
    this.jdField_a_of_type_Bafb = babr.a(this.jdField_a_of_type_AndroidAppActivity, 230);
    this.jdField_a_of_type_Bafb.setOnDismissListener(new adxj(this));
    Object localObject;
    switch (paramInt1)
    {
    case 2: 
    default: 
      this.jdField_a_of_type_Bafb = null;
      return;
    case 1: 
      this.jdField_a_of_type_Bafb.setTitle(String.format(this.jdField_a_of_type_AndroidAppActivity.getResources().getString(2131624385), new Object[] { Integer.valueOf(paramInt2) }));
      this.jdField_a_of_type_Bafb.setPositiveButton(2131629116, new baca());
      this.jdField_a_of_type_Bafb.show();
      return;
    case 0: 
      this.jdField_a_of_type_Bafb.setTitle(2131624354);
      localObject = new adxk(this, paramInt2);
      this.jdField_a_of_type_Bafb.setNegativeButton(2131625035, (DialogInterface.OnClickListener)localObject);
      this.jdField_a_of_type_Bafb.setPositiveButton(2131653589, (DialogInterface.OnClickListener)localObject);
      this.jdField_a_of_type_Bafb.show();
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("AIOImageListScene", 2, "showSDCardResult type = " + paramInt2);
    }
    String str;
    if (paramInt2 == 22)
    {
      localObject = this.jdField_a_of_type_AndroidAppActivity.getString(2131653223);
      str = this.jdField_a_of_type_AndroidAppActivity.getString(2131653222);
    }
    for (;;)
    {
      this.jdField_a_of_type_Bafb = babr.a(this.jdField_a_of_type_AndroidAppActivity, 230, (String)localObject, str, null, null);
      this.jdField_a_of_type_Bafb.setTitle((String)localObject);
      this.jdField_a_of_type_Bafb.setMessage(str);
      this.jdField_a_of_type_Bafb.setPositiveButton(2131629116, new baca());
      this.jdField_a_of_type_Bafb.show();
      return;
      if (paramInt2 == 24)
      {
        localObject = this.jdField_a_of_type_AndroidAppActivity.getString(2131653228);
        str = this.jdField_a_of_type_AndroidAppActivity.getString(2131653227);
      }
      else if (paramInt2 == 23)
      {
        localObject = this.jdField_a_of_type_AndroidAppActivity.getString(2131653225);
        str = this.jdField_a_of_type_AndroidAppActivity.getString(2131653224);
      }
      else
      {
        localObject = null;
        str = null;
      }
    }
  }
  
  public void a(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.a(paramInt1, paramInt2, paramIntent);
    if (paramInt2 == -1)
    {
      if (paramInt1 != 1) {
        break label26;
      }
      a(this.jdField_a_of_type_AndroidAppActivity, paramIntent);
    }
    label26:
    do
    {
      do
      {
        return;
      } while ((99 != paramInt1) && (98 != paramInt1));
      if (this.jdField_a_of_type_JavaUtilArrayList != null)
      {
        paramIntent = this.jdField_a_of_type_JavaUtilArrayList.iterator();
        while (paramIntent.hasNext()) {
          ((xgy)paramIntent.next()).a(2);
        }
        this.jdField_a_of_type_JavaUtilArrayList.clear();
      }
      if (this.jdField_a_of_type_ComTencentCommonGalleryactivityAbstractImageAdapter != null) {
        this.jdField_a_of_type_ComTencentCommonGalleryactivityAbstractImageAdapter.notifyDataSetChanged();
      }
      this.jdField_b_of_type_Boolean = false;
      if (this.jdField_c_of_type_AndroidWidgetTextView != null) {
        this.jdField_c_of_type_AndroidWidgetTextView.setText(2131624448);
      }
    } while (this.jdField_a_of_type_AndroidViewView == null);
    this.jdField_a_of_type_AndroidViewView.setVisibility(8);
  }
  
  public void a(long paramLong)
  {
    if ((this.jdField_a_of_type_Xgz != null) && (this.jdField_a_of_type_Xgz.a() == this)) {}
    for (boolean bool = true;; bool = false)
    {
      if (QLog.isColorLevel()) {
        QLog.d("AIOImageListScene", 2, "onRevokeMsg seq:" + paramLong + ", current:" + bool);
      }
      this.jdField_a_of_type_AndroidAppActivity.runOnUiThread(new AIOImageListScene.8(this, paramLong, bool));
      return;
    }
  }
  
  public void a(long paramLong, int paramInt1, int paramInt2, int paramInt3, String arg6)
  {
    if (this.jdField_a_of_type_Adxf == null) {}
    Object localObject1;
    label24:
    int i;
    int j;
    int k;
    label109:
    do
    {
      return;
      localObject4 = this.jdField_a_of_type_Adxf;
      if (paramInt3 != 1) {
        break;
      }
      localObject1 = ???;
      i = ((adxf)localObject4).a(paramLong, paramInt1, paramInt2, (String)localObject1, true);
      if (paramInt2 != 1) {
        break label240;
      }
      j = this.jdField_a_of_type_ComTencentWidgetGestureSelectGridView.getFirstVisiblePosition();
      k = this.jdField_a_of_type_ComTencentWidgetGestureSelectGridView.getChildCount();
      if ((i >= j) && (i <= k + j - 1))
      {
        localObject1 = this.jdField_a_of_type_ComTencentWidgetGestureSelectGridView.getChildAt(i - j);
        ((adxv)this.jdField_a_of_type_ComTencentCommonGalleryactivityAbstractImageAdapter).a(i, (View)localObject1);
      }
      if ((paramInt2 != 2) || (this.jdField_a_of_type_Adxo == null)) {
        break label313;
      }
      localObject1 = this.jdField_a_of_type_Adxo;
    } while ((((adxo)localObject1).jdField_a_of_type_Adyb == null) || (((adxo)localObject1).jdField_a_of_type_Adyb.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData.jdField_f_of_type_Long != paramLong) || (((adxo)localObject1).jdField_a_of_type_Adyb.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData.jdField_f_of_type_Int != paramInt1));
    Object localObject4 = (AIOImageData)((adxo)localObject1).jdField_a_of_type_Adyb.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData;
    if (paramInt3 == 1) {}
    for (;;)
    {
      ((AIOImageData)localObject4).jdField_b_of_type_JavaLangString = ???;
      ((adxo)localObject1).jdField_a_of_type_Adyb.jdField_a_of_type_Boolean = false;
      synchronized (((adxo)localObject1).jdField_a_of_type_Adyb)
      {
        ((adxo)localObject1).jdField_a_of_type_Adyb.notifyAll();
        return;
      }
      Object localObject3 = "I:E";
      break label24;
      label240:
      if (paramInt2 != 16) {
        break label109;
      }
      j = this.jdField_a_of_type_ComTencentWidgetGestureSelectGridView.getFirstVisiblePosition();
      k = this.jdField_a_of_type_ComTencentWidgetGestureSelectGridView.getChildCount();
      if ((i < j) || (i > k + j - 1)) {
        break label109;
      }
      localObject3 = this.jdField_a_of_type_ComTencentWidgetGestureSelectGridView.getChildAt(i - j);
      ((adxv)this.jdField_a_of_type_ComTencentCommonGalleryactivityAbstractImageAdapter).a(i, (View)localObject3);
      break label109;
      label313:
      break;
      ??? = "I:E";
    }
  }
  
  public void a(ViewGroup paramViewGroup)
  {
    o();
    super.a(paramViewGroup);
    this.jdField_a_of_type_ComTencentWidgetGestureSelectGridView.setOnScrollListener(this);
  }
  
  void a(String paramString)
  {
    if (paramString.equalsIgnoreCase(this.jdField_a_of_type_AndroidAppActivity.getResources().getString(2131624448)))
    {
      this.jdField_b_of_type_Boolean = true;
      a("Multi_Pic_choose", 0);
      return;
    }
    this.jdField_b_of_type_Boolean = false;
  }
  
  void a(String paramString, int paramInt) {}
  
  void a(Integer... paramVarArgs)
  {
    c(paramVarArgs[0].intValue(), 0);
    this.jdField_a_of_type_Adxo = new adxo(this, this.jdField_a_of_type_JavaUtilArrayList);
    this.jdField_a_of_type_Adxo.execute(paramVarArgs);
  }
  
  public boolean a(int paramInt, KeyEvent paramKeyEvent)
  {
    if ((paramInt == 4) && (this.jdField_c_of_type_AndroidWidgetTextView != null))
    {
      a(this.jdField_c_of_type_AndroidWidgetTextView.getText().toString());
      if (!this.jdField_b_of_type_Boolean)
      {
        w();
        return true;
      }
    }
    return super.a(paramInt, paramKeyEvent);
  }
  
  boolean a(adyb paramadyb, boolean paramBoolean1, boolean paramBoolean2)
  {
    int i = a();
    if (paramBoolean2)
    {
      if (AIOShortVideoData.class.isInstance(paramadyb.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData)) {
        return false;
      }
      if (i == 2) {
        return false;
      }
    }
    int j = paramadyb.b();
    if (((j == 1) && (paramBoolean1)) || ((j == 2) && (!paramBoolean1))) {
      return false;
    }
    if ((j == 2) && (paramBoolean1) && (this.jdField_a_of_type_JavaUtilArrayList.size() >= 20))
    {
      long l = System.currentTimeMillis();
      if (l - this.jdField_a_of_type_Long >= 700L)
      {
        if (i != 2) {
          break label174;
        }
        bbmy.a(this.jdField_a_of_type_AndroidAppActivity, 1, ajjy.a(2131634299) + 20 + ajjy.a(2131634294), 0).b(this.jdField_a_of_type_AndroidAppActivity.getResources().getDimensionPixelSize(2131167766));
      }
      for (;;)
      {
        this.jdField_a_of_type_Long = l;
        return false;
        label174:
        bbmy.a(this.jdField_a_of_type_AndroidAppActivity, 1, ajjy.a(2131634289) + 20 + ajjy.a(2131634293), 0).b(this.jdField_a_of_type_AndroidAppActivity.getResources().getDimensionPixelSize(2131167766));
      }
    }
    if ((AIOFilePicData.class.isInstance(paramadyb.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData)) && (paramadyb.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData.a(20) == null) && (paramadyb.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData.a(18) == null) && (paramadyb.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData.a(16) == null))
    {
      if (QLog.isColorLevel()) {
        QLog.d("AIOImageListScene", 2, "AIOFilePicData has null path!");
      }
      return false;
    }
    if (paramBoolean1)
    {
      paramadyb.a(1);
      this.jdField_a_of_type_JavaUtilArrayList.add(paramadyb);
    }
    for (;;)
    {
      return true;
      paramadyb.a(2);
      this.jdField_a_of_type_JavaUtilArrayList.remove(paramadyb);
    }
  }
  
  boolean a(View paramView, xgy paramxgy)
  {
    Object localObject = (adxw)paramView.getTag();
    if (localObject != null)
    {
      paramView = ((adxw)localObject).jdField_a_of_type_AndroidWidgetImageView;
      localObject = ((adxw)localObject).jdField_b_of_type_AndroidWidgetImageView;
      switch (paramxgy.b())
      {
      default: 
        paramView.setVisibility(4);
        ((ImageView)localObject).setVisibility(4);
      }
      for (;;)
      {
        return true;
        paramView.setVisibility(0);
        ((ImageView)localObject).setImageResource(2130844780);
        ((ImageView)localObject).setVisibility(0);
        continue;
        paramView.setVisibility(4);
        ((ImageView)localObject).setImageResource(2130844778);
        ((ImageView)localObject).setVisibility(0);
      }
    }
    return false;
  }
  
  void b(int paramInt1, int paramInt2)
  {
    if (this.jdField_a_of_type_AndroidAppDialog != null)
    {
      this.jdField_a_of_type_AndroidAppDialog.dismiss();
      this.jdField_a_of_type_AndroidAppDialog = null;
    }
    switch (paramInt1)
    {
    case 10: 
    default: 
      return;
    case 20: 
      bbmy.a(this.jdField_a_of_type_AndroidAppActivity, 2, this.jdField_a_of_type_AndroidAppActivity.getResources().getString(2131624383) + ajed.ba, 0).b(this.jdField_a_of_type_AndroidAppActivity.getResources().getDimensionPixelSize(2131167766));
      return;
    case 21: 
      bbmy.a(this.jdField_a_of_type_AndroidAppActivity, 1, this.jdField_a_of_type_AndroidAppActivity.getResources().getString(2131624382) + ajed.ba, 0).b(this.jdField_a_of_type_AndroidAppActivity.getResources().getDimensionPixelSize(2131167766));
      return;
    case 22: 
    case 23: 
    case 24: 
      a(3, 0);
      return;
    case 11: 
      a(1, paramInt2);
      return;
    }
    v();
  }
  
  void c(int paramInt1, int paramInt2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("AIOImageListScene", 2, "showProgressDialog step = " + paramInt1);
    }
    if (this.jdField_a_of_type_AndroidAppDialog == null)
    {
      this.jdField_a_of_type_AndroidAppDialog = new Dialog(this.jdField_a_of_type_AndroidAppActivity, 2131690181);
      this.jdField_a_of_type_AndroidAppDialog.setCancelable(true);
      this.jdField_a_of_type_AndroidAppDialog.show();
      this.jdField_a_of_type_AndroidAppDialog.setContentView(2131493818);
      this.jdField_a_of_type_AndroidAppDialog.setOnCancelListener(this);
    }
    String str = paramInt2 + "%";
    TextView localTextView = (TextView)this.jdField_a_of_type_AndroidAppDialog.findViewById(2131305861);
    switch (paramInt1)
    {
    }
    for (;;)
    {
      localTextView.setText(str);
      if (!this.jdField_a_of_type_AndroidAppDialog.isShowing()) {
        this.jdField_a_of_type_AndroidAppDialog.show();
      }
      return;
      str = localTextView.getResources().getText(2131624386) + str;
      continue;
      str = localTextView.getResources().getText(2131624384) + str;
    }
  }
  
  public void f()
  {
    super.f();
    this.jdField_a_of_type_JavaUtilArrayList.clear();
    this.jdField_a_of_type_JavaUtilArrayList = null;
    this.jdField_a_of_type_Adxf = null;
    advs.a().b(this);
  }
  
  public void h()
  {
    if (this.jdField_a_of_type_ComTencentCommonGalleryactivityAbstractImageAdapter != null)
    {
      this.jdField_a_of_type_ComTencentWidgetGestureSelectGridView.post(new AIOImageListScene.7(this));
      this.jdField_a_of_type_AndroidWidgetTextView.setText(2131653896);
    }
  }
  
  protected void i()
  {
    int k = 0;
    begr localbegr = (begr)behe.a(this.jdField_a_of_type_AndroidAppActivity, null);
    localbegr.a(2131624387);
    localbegr.a(2131624388, 5);
    int m = a();
    int i = 0;
    for (;;)
    {
      int j = k;
      if (i < this.jdField_a_of_type_JavaUtilArrayList.size())
      {
        if (((((adyb)this.jdField_a_of_type_JavaUtilArrayList.get(i)).jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData instanceof AIOImageData)) && (((AIOImageData)((adyb)this.jdField_a_of_type_JavaUtilArrayList.get(i)).jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData).e == null)) {
          j = 1;
        }
      }
      else
      {
        if ((m == 1) && (j == 0)) {
          localbegr.b(2131627755);
        }
        if ((this.jdField_c_of_type_Boolean) && (m == 1) && (j == 0)) {
          localbegr.a(2131627743, 5);
        }
        localbegr.c(2131625035);
        localbegr.a(new adxh(this, localbegr));
        localbegr.show();
        a("Multi_Pic_Forward", this.jdField_a_of_type_JavaUtilArrayList.size());
        return;
      }
      i += 1;
    }
  }
  
  protected void j()
  {
    if (QLog.isColorLevel()) {
      QLog.d("AIOImageListScene", 2, "saveAllImage");
    }
    Object localObject = this.jdField_a_of_type_JavaUtilArrayList.iterator();
    adyb localadyb;
    do
    {
      if (!((Iterator)localObject).hasNext()) {
        break label213;
      }
      localadyb = (adyb)((Iterator)localObject).next();
      if (!AIOImageData.class.isInstance(localadyb.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData)) {
        break;
      }
    } while (((AIOImageData)localadyb.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData).a(2) != null);
    label213:
    for (int i = 0;; i = 1)
    {
      if (i != 0) {
        a(new Integer[] { Integer.valueOf(1) });
      }
      for (;;)
      {
        a("Multi_Pic_Save", this.jdField_a_of_type_JavaUtilArrayList.size());
        return;
        if (!AIOShortVideoData.class.isInstance(localadyb.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData)) {
          break;
        }
        break;
        localObject = BaseApplication.getContext();
        boolean bool = SettingCloneUtil.readValue((Context)localObject, null, ((Context)localObject).getString(2131629640), "qqsetting_auto_receive_pic_key", true);
        i = badq.b((Context)localObject);
        if (i == -1) {
          a(1, this.jdField_a_of_type_JavaUtilArrayList.size());
        } else if ((bool) || (i == 1)) {
          a(new Integer[] { Integer.valueOf(0), Integer.valueOf(1) });
        } else {
          a(0, 0);
        }
      }
    }
  }
  
  public void k()
  {
    super.k();
    if (this.jdField_a_of_type_Adxf != null)
    {
      j = this.jdField_a_of_type_Adxf.f();
      k = this.jdField_a_of_type_Adxf.e();
      i = this.jdField_a_of_type_Adxf.d();
      if (QLog.isColorLevel()) {
        QLog.d("AIOImageListScene", 2, "onStart start FirstVisiblePosition " + i + " LastVisiblePosition " + k + " SelectedIndex = " + j);
      }
      if ((j > k) || (j < i) || (j - i < 4))
      {
        if ((k <= 0) || (j <= k)) {
          break label292;
        }
        j -= k;
        if ((j > 4) && (j % 4 == 0))
        {
          i = j + i + 4;
          if (QLog.isColorLevel()) {
            QLog.d("AIOImageListScene", 2, "onStart selectedIndex > lastPosition n " + i);
          }
          this.jdField_a_of_type_ComTencentWidgetGestureSelectGridView.setSelection(i);
          this.jdField_a_of_type_Adxf.b(this.jdField_a_of_type_ComTencentWidgetGestureSelectGridView.getFirstVisiblePosition());
          this.jdField_a_of_type_Adxf.c(this.jdField_a_of_type_ComTencentWidgetGestureSelectGridView.getLastVisiblePosition());
        }
      }
      else if (QLog.isColorLevel())
      {
        i = this.jdField_a_of_type_Adxf.b();
        j = this.jdField_a_of_type_Adxf.e();
        k = this.jdField_a_of_type_Adxf.d();
        QLog.d("AIOImageListScene", 2, "onStart end FirstVisiblePosition " + k + " LastVisiblePosition " + j + " SelectedIndex = " + i);
      }
    }
    label292:
    while (!QLog.isColorLevel()) {
      for (;;)
      {
        int j;
        int k;
        return;
        int i = j + i + 8;
        continue;
        this.jdField_a_of_type_ComTencentWidgetGestureSelectGridView.setSelection(j);
      }
    }
    QLog.d("AIOImageListScene", 2, "onStart error!! mAIOModel == null ");
  }
  
  protected void m()
  {
    long[] arrayOfLong = new long[this.jdField_a_of_type_JavaUtilArrayList.size()];
    int i = 0;
    while (i < this.jdField_a_of_type_JavaUtilArrayList.size())
    {
      if ((this.jdField_a_of_type_JavaUtilArrayList.get(i) != null) && (((adyb)this.jdField_a_of_type_JavaUtilArrayList.get(i)).jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData != null)) {
        arrayOfLong[i] = ((adyb)this.jdField_a_of_type_JavaUtilArrayList.get(i)).jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData.jdField_f_of_type_Long;
      }
      i += 1;
    }
    if (this.jdField_a_of_type_Adye.asBinder().pingBinder())
    {
      this.jdField_a_of_type_Adye.a(arrayOfLong);
      bbmy.a(this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_AndroidAppActivity.getString(2131627191), 0).a();
    }
  }
  
  public void n()
  {
    if (this.jdField_a_of_type_Adye != null) {
      this.jdField_a_of_type_Adye.a(0);
    }
  }
  
  void o()
  {
    this.jdField_b_of_type_Boolean = false;
    this.jdField_a_of_type_Long = 0L;
    Bundle localBundle = this.jdField_a_of_type_AndroidAppActivity.getIntent().getExtras();
    this.jdField_c_of_type_Boolean = localBundle.getBoolean("extra.CAN_FORWARD_TO_GROUP_ALBUM", false);
    this.jdField_a_of_type_Boolean = localBundle.getBoolean("extra.RIGHT_EXIT_TRANSITION", false);
    this.jdField_d_of_type_JavaLangString = localBundle.getString("extra.GROUP_UIN");
    if (this.jdField_c_of_type_Boolean)
    {
      this.jdField_b_of_type_JavaLangString = localBundle.getString("extra.GROUP_UIN");
      this.jdField_c_of_type_JavaLangString = localBundle.getString("extra.GROUP_CODE");
      if (((this.jdField_b_of_type_JavaLangString == null) || (this.jdField_c_of_type_JavaLangString == null) || (this.jdField_a_of_type_JavaLangString == null)) && (QLog.isColorLevel())) {
        QLog.i("AIOImageListScene", 2, "mGroupUin=" + this.jdField_b_of_type_JavaLangString + ", mGroupCode=" + this.jdField_c_of_type_JavaLangString + ", mMyUin=" + this.jdField_a_of_type_JavaLangString);
      }
    }
    this.jdField_b_of_type_Int = localBundle.getInt("extra.EXTRA_FORWARD_TO_QZONE_SRC");
    this.jdField_c_of_type_Int = localBundle.getInt("forward_source_uin_type", -1);
    this.jdField_a_of_type_Adxf.a();
    this.jdField_a_of_type_Adxf.b();
    advs.a().a(this);
  }
  
  public void onCancel(DialogInterface paramDialogInterface)
  {
    this.jdField_a_of_type_AndroidAppDialog = null;
    paramDialogInterface = this.jdField_a_of_type_Adxo;
    if (paramDialogInterface != null) {
      paramDialogInterface.jdField_a_of_type_Boolean = false;
    }
  }
  
  public void onScroll(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3) {}
  
  public void onScrollStateChanged(AbsListView paramAbsListView, int paramInt)
  {
    if (paramInt == 0)
    {
      paramInt = this.jdField_a_of_type_ComTencentWidgetGestureSelectGridView.getLastVisiblePosition();
      int i = this.jdField_a_of_type_Adxf.g();
      if (((paramInt >= i - 28) || (paramInt == i)) && (this.jdField_d_of_type_Int != i))
      {
        if (QLog.isColorLevel()) {
          QLog.d("AIOImageListScene", 2, "[onScroll] loadMedias: mLastLoadingCount=" + this.jdField_d_of_type_Int);
        }
        this.jdField_d_of_type_Int = i;
        ((adxv)this.jdField_a_of_type_ComTencentCommonGalleryactivityAbstractImageAdapter).a(true);
        this.jdField_a_of_type_Adye.a(0);
      }
    }
  }
  
  void q()
  {
    if (QLog.isColorLevel()) {
      QLog.d("AIOImageListScene", 2, "forwardAllImage");
    }
    Object localObject = BaseApplication.getContext();
    boolean bool = SettingCloneUtil.readValue((Context)localObject, null, ((Context)localObject).getString(2131629640), "qqsetting_auto_receive_pic_key", true);
    int i;
    int j;
    if (badq.b(BaseApplication.getContext()) == 1)
    {
      i = 1;
      if (badq.b(BaseApplication.getContext()) != -1) {
        break label137;
      }
      j = 1;
      label65:
      localObject = this.jdField_a_of_type_JavaUtilArrayList.iterator();
      adyb localadyb;
      do
      {
        if (!((Iterator)localObject).hasNext()) {
          break;
        }
        localadyb = (adyb)((Iterator)localObject).next();
      } while ((!AIOImageData.class.isInstance(localadyb.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData)) || (localadyb.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData.a(2) != null));
    }
    for (int k = 0;; k = 1)
    {
      if (k != 0)
      {
        v();
        return;
        i = 0;
        break;
        label137:
        j = 0;
        break label65;
      }
      if (j != 0)
      {
        a(1, this.jdField_a_of_type_JavaUtilArrayList.size());
        return;
      }
      if ((bool) || (i != 0))
      {
        a(new Integer[] { Integer.valueOf(0), Integer.valueOf(2) });
        return;
      }
      a(0, 1);
      return;
    }
  }
  
  void r()
  {
    if (QLog.isColorLevel()) {
      QLog.d("AIOImageListScene", 2, "forwardToGroupAlbum()");
    }
    ArrayList localArrayList1 = new ArrayList();
    ArrayList localArrayList2 = new ArrayList();
    ArrayList localArrayList3 = new ArrayList();
    Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
    while (localIterator.hasNext())
    {
      Object localObject = (adyb)localIterator.next();
      if (AIOImageData.class.isInstance(((adyb)localObject).jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData))
      {
        localObject = (AIOImageData)((adyb)localObject).jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData;
        localArrayList1.add(((AIOImageData)localObject).jdField_a_of_type_JavaLangString);
        localArrayList2.add(((AIOImageData)localObject).e);
        localArrayList3.add(Long.valueOf(((AIOImageData)localObject).c));
      }
    }
    adwz.a(this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_JavaLangString, this.jdField_b_of_type_JavaLangString, this.jdField_c_of_type_JavaLangString, localArrayList1, localArrayList2, localArrayList3, 2, null, null);
  }
  
  void u()
  {
    if (QLog.isColorLevel()) {
      QLog.d("AIOImageListScene", 2, "forwardToQZoneAlbum()");
    }
    adwz.a(this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_JavaLangString, this.jdField_c_of_type_JavaLangString, this.jdField_b_of_type_Int, (List)this.jdField_a_of_type_JavaUtilArrayList.clone(), this.jdField_c_of_type_Boolean, this.jdField_b_of_type_JavaLangString);
  }
  
  void v()
  {
    if ((this.jdField_a_of_type_JavaUtilArrayList != null) && (this.jdField_a_of_type_JavaUtilArrayList.get(0) != null))
    {
      localObject1 = (adyb)this.jdField_a_of_type_JavaUtilArrayList.get(0);
      if (AIOImageData.class.isInstance(((adyb)localObject1).jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData))
      {
        localObject2 = (AIOImageData)((adyb)localObject1).jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData;
        localObject1 = new Bundle();
        ((Bundle)localObject1).putInt("forward_type", 12);
        localObject3 = ((AIOImageData)localObject2).a(2);
        ((Bundle)localObject1).putString("forward_urldrawable_thumb_url", ((AIOImageData)localObject2).a(1));
        ((Bundle)localObject1).putString("forward_urldrawable_big_url", (String)localObject3);
        ((Bundle)localObject1).putBoolean("forward_urldrawable", true);
        if (this.jdField_a_of_type_JavaUtilArrayList.size() > 1) {
          ((Bundle)localObject1).putString("forward_text", this.jdField_a_of_type_JavaUtilArrayList.size() + ajjy.a(2131634291));
        }
        ((Bundle)localObject1).putBoolean("sendMultiple", true);
        ((Bundle)localObject1).putBoolean("key_allow_forward_photo_preview_edit", true);
        localObject2 = new ArrayList();
        localObject3 = this.jdField_a_of_type_JavaUtilArrayList.iterator();
        while (((Iterator)localObject3).hasNext())
        {
          localadyb = (adyb)((Iterator)localObject3).next();
          if (AIOImageData.class.isInstance(localadyb.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData)) {
            ((ArrayList)localObject2).add(((AIOImageData)localadyb.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData).jdField_b_of_type_JavaLangString);
          } else if (AIOFilePicData.class.isInstance(localadyb.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData)) {
            if (((AIOFilePicData)localadyb.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData).a(20) != null) {
              ((ArrayList)localObject2).add(((AIOFilePicData)localadyb.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData).jdField_d_of_type_JavaLangString);
            } else if (((AIOFilePicData)localadyb.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData).a(18) != null) {
              ((ArrayList)localObject2).add(((AIOFilePicData)localadyb.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData).jdField_c_of_type_JavaLangString);
            } else if (((AIOFilePicData)localadyb.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData).a(16) != null) {
              ((ArrayList)localObject2).add(((AIOFilePicData)localadyb.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData).jdField_b_of_type_JavaLangString);
            }
          }
        }
        ((Bundle)localObject1).putStringArrayList("PhotoConst.PHOTO_PATHS", (ArrayList)localObject2);
        localObject2 = new Intent();
        ((Intent)localObject2).putExtras((Bundle)localObject1);
        aphp.a(this.jdField_a_of_type_AndroidAppActivity, (Intent)localObject2, 1);
      }
    }
    while (!QLog.isColorLevel())
    {
      adyb localadyb;
      do
      {
        return;
      } while (!AIOFilePicData.class.isInstance(((adyb)localObject1).jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData));
      Object localObject2 = (AIOFilePicData)((adyb)localObject1).jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData;
      Object localObject1 = new Bundle();
      ((Bundle)localObject1).putInt("forward_type", 12);
      Object localObject3 = ((AIOFilePicData)localObject2).a(18);
      ((Bundle)localObject1).putString("forward_urldrawable_thumb_url", ((AIOFilePicData)localObject2).a(16));
      ((Bundle)localObject1).putString("forward_urldrawable_big_url", (String)localObject3);
      ((Bundle)localObject1).putBoolean("forward_urldrawable", true);
      if (this.jdField_a_of_type_JavaUtilArrayList.size() > 1) {
        ((Bundle)localObject1).putString("forward_text", this.jdField_a_of_type_JavaUtilArrayList.size() + ajjy.a(2131634292));
      }
      ((Bundle)localObject1).putBoolean("sendMultiple", true);
      localObject2 = new ArrayList();
      localObject3 = this.jdField_a_of_type_JavaUtilArrayList.iterator();
      while (((Iterator)localObject3).hasNext())
      {
        localadyb = (adyb)((Iterator)localObject3).next();
        if (AIOImageData.class.isInstance(localadyb.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData)) {
          ((ArrayList)localObject2).add(((AIOImageData)localadyb.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData).jdField_b_of_type_JavaLangString);
        } else if (AIOFilePicData.class.isInstance(localadyb.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData)) {
          if (((AIOFilePicData)localadyb.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData).a(20) != null) {
            ((ArrayList)localObject2).add(((AIOFilePicData)localadyb.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData).jdField_d_of_type_JavaLangString);
          } else if (((AIOFilePicData)localadyb.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData).a(18) != null) {
            ((ArrayList)localObject2).add(((AIOFilePicData)localadyb.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData).jdField_c_of_type_JavaLangString);
          } else if (((AIOFilePicData)localadyb.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData).a(16) != null) {
            ((ArrayList)localObject2).add(((AIOFilePicData)localadyb.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData).jdField_b_of_type_JavaLangString);
          }
        }
      }
      ((Bundle)localObject1).putStringArrayList("PhotoConst.PHOTO_PATHS", (ArrayList)localObject2);
      localObject2 = new Intent();
      ((Intent)localObject2).putExtras((Bundle)localObject1);
      aphp.a(this.jdField_a_of_type_AndroidAppActivity, (Intent)localObject2, 1);
      return;
    }
    QLog.d("AIOImageListScene", 2, "callForwardRecentActivity error! mSelectedPhotoList ==null || mSelectedPhotoList.get(0) == null || !mSelectedPhotoList.get(0) instanceof AIOImageInfo");
  }
  
  void w()
  {
    ((adxv)this.jdField_a_of_type_ComTencentCommonGalleryactivityAbstractImageAdapter).jdField_a_of_type_Boolean = this.jdField_b_of_type_Boolean;
    int i;
    if (this.jdField_b_of_type_Boolean)
    {
      this.jdField_c_of_type_AndroidWidgetTextView.setText(2131624335);
      this.jdField_a_of_type_AndroidViewView.setVisibility(0);
      i = a();
      if (i == 1)
      {
        this.jdField_a_of_type_AndroidWidgetImageView.setEnabled(true);
        this.jdField_a_of_type_AndroidWidgetImageView.setClickable(true);
        this.jdField_b_of_type_AndroidWidgetImageView.setEnabled(true);
        this.jdField_b_of_type_AndroidWidgetImageView.setClickable(true);
        this.jdField_c_of_type_AndroidWidgetImageView.setEnabled(true);
        this.jdField_c_of_type_AndroidWidgetImageView.setClickable(true);
      }
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentCommonGalleryactivityAbstractImageAdapter.notifyDataSetChanged();
      return;
      if (i == 2)
      {
        if (this.jdField_a_of_type_JavaUtilArrayList.size() > 1)
        {
          this.jdField_a_of_type_AndroidWidgetImageView.setEnabled(false);
          this.jdField_a_of_type_AndroidWidgetImageView.setClickable(false);
          this.jdField_b_of_type_AndroidWidgetImageView.setEnabled(false);
          this.jdField_b_of_type_AndroidWidgetImageView.setClickable(false);
        }
        for (;;)
        {
          this.jdField_c_of_type_AndroidWidgetImageView.setEnabled(true);
          this.jdField_c_of_type_AndroidWidgetImageView.setClickable(true);
          break;
          this.jdField_a_of_type_AndroidWidgetImageView.setEnabled(true);
          this.jdField_a_of_type_AndroidWidgetImageView.setClickable(true);
          this.jdField_b_of_type_AndroidWidgetImageView.setEnabled(false);
          this.jdField_b_of_type_AndroidWidgetImageView.setClickable(false);
        }
      }
      this.jdField_a_of_type_AndroidWidgetImageView.setEnabled(false);
      this.jdField_a_of_type_AndroidWidgetImageView.setClickable(false);
      this.jdField_b_of_type_AndroidWidgetImageView.setEnabled(false);
      this.jdField_b_of_type_AndroidWidgetImageView.setClickable(false);
      this.jdField_c_of_type_AndroidWidgetImageView.setEnabled(false);
      this.jdField_c_of_type_AndroidWidgetImageView.setClickable(false);
      continue;
      this.jdField_c_of_type_AndroidWidgetTextView.setText(2131624448);
      this.jdField_a_of_type_AndroidViewView.setVisibility(8);
      Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
      while (localIterator.hasNext()) {
        ((xgy)localIterator.next()).a(2);
      }
      this.jdField_a_of_type_JavaUtilArrayList.clear();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     adxg
 * JD-Core Version:    0.7.0.1
 */