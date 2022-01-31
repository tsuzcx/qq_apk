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
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.AbsListView;
import com.tencent.widget.GestureSelectGridView;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class agji
  extends zis
  implements aghw, DialogInterface.OnCancelListener, bhtv
{
  long jdField_a_of_type_Long;
  public agjh a;
  agjq jdField_a_of_type_Agjq;
  agki jdField_a_of_type_Agki;
  String jdField_a_of_type_JavaLangString;
  public ArrayList<agkf> a;
  int jdField_b_of_type_Int = 1;
  String jdField_b_of_type_JavaLangString;
  int jdField_c_of_type_Int;
  String jdField_c_of_type_JavaLangString;
  boolean jdField_c_of_type_Boolean = false;
  private int jdField_d_of_type_Int;
  String jdField_d_of_type_JavaLangString;
  
  public agji(Activity paramActivity, zir paramzir, agki paramagki, String paramString)
  {
    super(paramActivity, paramzir);
    this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
    this.jdField_a_of_type_Agjh = ((agjh)paramzir);
    this.jdField_a_of_type_Agki = paramagki;
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
    localIntent = aepi.a(localIntent, null);
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
    AIORichMediaData localAIORichMediaData = ((agkf)this.jdField_a_of_type_JavaUtilArrayList.get(0)).jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData;
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
    int j = this.jdField_a_of_type_Agjh.f();
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
    return new agjp(this);
  }
  
  protected bhuw a()
  {
    return new agjn(this);
  }
  
  protected bhxl a()
  {
    return new agjo(this);
  }
  
  protected AbstractImageAdapter a(Activity paramActivity, int paramInt)
  {
    this.jdField_a_of_type_ComTencentCommonGalleryactivityAbstractImageAdapter = new agjx(this.jdField_a_of_type_AndroidAppActivity, paramInt, this.jdField_a_of_type_Agjh, this.jdField_a_of_type_Agki, this.jdField_a_of_type_ComTencentWidgetGestureSelectGridView);
    this.jdField_a_of_type_ComTencentCommonGalleryactivityAbstractImageAdapter.a(this.jdField_a_of_type_Agjh);
    return this.jdField_a_of_type_ComTencentCommonGalleryactivityAbstractImageAdapter;
  }
  
  void a(int paramInt1, int paramInt2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("AIOImageListScene", 2, "showDownloadResult type = " + paramInt1);
    }
    if (this.jdField_a_of_type_Bdjz != null) {
      this.jdField_a_of_type_Bdjz.dismiss();
    }
    this.jdField_a_of_type_Bdjz = bdgm.a(this.jdField_a_of_type_AndroidAppActivity, 230);
    this.jdField_a_of_type_Bdjz.setOnDismissListener(new agjl(this));
    Object localObject;
    switch (paramInt1)
    {
    case 2: 
    default: 
      this.jdField_a_of_type_Bdjz = null;
      return;
    case 1: 
      this.jdField_a_of_type_Bdjz.setTitle(String.format(this.jdField_a_of_type_AndroidAppActivity.getResources().getString(2131689980), new Object[] { Integer.valueOf(paramInt2) }));
      this.jdField_a_of_type_Bdjz.setPositiveButton(2131694953, new bdgx());
      this.jdField_a_of_type_Bdjz.show();
      return;
    case 0: 
      this.jdField_a_of_type_Bdjz.setTitle(2131689948);
      localObject = new agjm(this, paramInt2);
      this.jdField_a_of_type_Bdjz.setNegativeButton(2131690648, (DialogInterface.OnClickListener)localObject);
      this.jdField_a_of_type_Bdjz.setPositiveButton(2131719931, (DialogInterface.OnClickListener)localObject);
      this.jdField_a_of_type_Bdjz.show();
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("AIOImageListScene", 2, "showSDCardResult type = " + paramInt2);
    }
    String str;
    if (paramInt2 == 22)
    {
      localObject = this.jdField_a_of_type_AndroidAppActivity.getString(2131719554);
      str = this.jdField_a_of_type_AndroidAppActivity.getString(2131719553);
    }
    for (;;)
    {
      this.jdField_a_of_type_Bdjz = bdgm.a(this.jdField_a_of_type_AndroidAppActivity, 230, (String)localObject, str, null, null);
      this.jdField_a_of_type_Bdjz.setTitle((String)localObject);
      this.jdField_a_of_type_Bdjz.setMessage(str);
      this.jdField_a_of_type_Bdjz.setPositiveButton(2131694953, new bdgx());
      this.jdField_a_of_type_Bdjz.show();
      return;
      if (paramInt2 == 24)
      {
        localObject = this.jdField_a_of_type_AndroidAppActivity.getString(2131719559);
        str = this.jdField_a_of_type_AndroidAppActivity.getString(2131719558);
      }
      else if (paramInt2 == 23)
      {
        localObject = this.jdField_a_of_type_AndroidAppActivity.getString(2131719556);
        str = this.jdField_a_of_type_AndroidAppActivity.getString(2131719555);
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
          ((zjd)paramIntent.next()).a(2);
        }
        this.jdField_a_of_type_JavaUtilArrayList.clear();
      }
      if (this.jdField_a_of_type_ComTencentCommonGalleryactivityAbstractImageAdapter != null) {
        this.jdField_a_of_type_ComTencentCommonGalleryactivityAbstractImageAdapter.notifyDataSetChanged();
      }
      this.jdField_b_of_type_Boolean = false;
      if (this.jdField_c_of_type_AndroidWidgetTextView != null) {
        this.jdField_c_of_type_AndroidWidgetTextView.setText(2131690047);
      }
    } while (this.jdField_a_of_type_AndroidViewView == null);
    this.jdField_a_of_type_AndroidViewView.setVisibility(8);
  }
  
  public void a(long paramLong)
  {
    if ((this.jdField_a_of_type_Zje != null) && (this.jdField_a_of_type_Zje.a() == this)) {}
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
    if (this.jdField_a_of_type_Agjh == null) {}
    Object localObject1;
    label24:
    int i;
    int j;
    int k;
    label109:
    do
    {
      return;
      localObject4 = this.jdField_a_of_type_Agjh;
      if (paramInt3 != 1) {
        break;
      }
      localObject1 = ???;
      i = ((agjh)localObject4).a(paramLong, paramInt1, paramInt2, (String)localObject1, true);
      if (paramInt2 != 1) {
        break label240;
      }
      j = this.jdField_a_of_type_ComTencentWidgetGestureSelectGridView.getFirstVisiblePosition();
      k = this.jdField_a_of_type_ComTencentWidgetGestureSelectGridView.getChildCount();
      if ((i >= j) && (i <= k + j - 1))
      {
        localObject1 = this.jdField_a_of_type_ComTencentWidgetGestureSelectGridView.getChildAt(i - j);
        ((agjx)this.jdField_a_of_type_ComTencentCommonGalleryactivityAbstractImageAdapter).a(i, (View)localObject1);
      }
      if ((paramInt2 != 2) || (this.jdField_a_of_type_Agjq == null)) {
        break label313;
      }
      localObject1 = this.jdField_a_of_type_Agjq;
    } while ((((agjq)localObject1).jdField_a_of_type_Agkf == null) || (((agjq)localObject1).jdField_a_of_type_Agkf.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData.jdField_f_of_type_Long != paramLong) || (((agjq)localObject1).jdField_a_of_type_Agkf.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData.jdField_f_of_type_Int != paramInt1));
    Object localObject4 = (AIOImageData)((agjq)localObject1).jdField_a_of_type_Agkf.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData;
    if (paramInt3 == 1) {}
    for (;;)
    {
      ((AIOImageData)localObject4).jdField_b_of_type_JavaLangString = ???;
      ((agjq)localObject1).jdField_a_of_type_Agkf.jdField_a_of_type_Boolean = false;
      synchronized (((agjq)localObject1).jdField_a_of_type_Agkf)
      {
        ((agjq)localObject1).jdField_a_of_type_Agkf.notifyAll();
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
      ((agjx)this.jdField_a_of_type_ComTencentCommonGalleryactivityAbstractImageAdapter).a(i, (View)localObject3);
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
    if (paramString.equalsIgnoreCase(this.jdField_a_of_type_AndroidAppActivity.getResources().getString(2131690047)))
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
    this.jdField_a_of_type_Agjq = new agjq(this, this.jdField_a_of_type_JavaUtilArrayList);
    this.jdField_a_of_type_Agjq.execute(paramVarArgs);
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
  
  boolean a(agkf paramagkf, boolean paramBoolean1, boolean paramBoolean2)
  {
    int i = a();
    if (paramBoolean2)
    {
      if (AIOShortVideoData.class.isInstance(paramagkf.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData)) {
        return false;
      }
      if (i == 2) {
        return false;
      }
    }
    int j = paramagkf.b();
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
        QQToast.a(this.jdField_a_of_type_AndroidAppActivity, 1, alud.a(2131700479) + 20 + alud.a(2131700474), 0).b(this.jdField_a_of_type_AndroidAppActivity.getResources().getDimensionPixelSize(2131298914));
      }
      for (;;)
      {
        this.jdField_a_of_type_Long = l;
        return false;
        label174:
        QQToast.a(this.jdField_a_of_type_AndroidAppActivity, 1, alud.a(2131700469) + 20 + alud.a(2131700473), 0).b(this.jdField_a_of_type_AndroidAppActivity.getResources().getDimensionPixelSize(2131298914));
      }
    }
    if ((AIOFilePicData.class.isInstance(paramagkf.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData)) && (paramagkf.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData.a(20) == null) && (paramagkf.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData.a(18) == null) && (paramagkf.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData.a(16) == null))
    {
      if (QLog.isColorLevel()) {
        QLog.d("AIOImageListScene", 2, "AIOFilePicData has null path!");
      }
      return false;
    }
    if (paramBoolean1)
    {
      paramagkf.a(1);
      this.jdField_a_of_type_JavaUtilArrayList.add(paramagkf);
    }
    for (;;)
    {
      return true;
      paramagkf.a(2);
      this.jdField_a_of_type_JavaUtilArrayList.remove(paramagkf);
    }
  }
  
  boolean a(View paramView, zjd paramzjd)
  {
    Object localObject = (agjz)paramView.getTag();
    if (localObject != null)
    {
      paramView = ((agjz)localObject).jdField_a_of_type_AndroidWidgetImageView;
      localObject = ((agjz)localObject).jdField_b_of_type_AndroidWidgetImageView;
      switch (paramzjd.b())
      {
      default: 
        paramView.setVisibility(4);
        ((ImageView)localObject).setVisibility(4);
      }
      for (;;)
      {
        return true;
        paramView.setVisibility(0);
        ((ImageView)localObject).setImageResource(2130845298);
        ((ImageView)localObject).setVisibility(0);
        continue;
        paramView.setVisibility(4);
        ((ImageView)localObject).setImageResource(2130845295);
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
      QQToast.a(this.jdField_a_of_type_AndroidAppActivity, 2, this.jdField_a_of_type_AndroidAppActivity.getResources().getString(2131689978) + alof.bd, 0).b(this.jdField_a_of_type_AndroidAppActivity.getResources().getDimensionPixelSize(2131298914));
      return;
    case 21: 
      QQToast.a(this.jdField_a_of_type_AndroidAppActivity, 1, this.jdField_a_of_type_AndroidAppActivity.getResources().getString(2131689977) + alof.bd, 0).b(this.jdField_a_of_type_AndroidAppActivity.getResources().getDimensionPixelSize(2131298914));
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
      this.jdField_a_of_type_AndroidAppDialog = new Dialog(this.jdField_a_of_type_AndroidAppActivity, 2131755801);
      this.jdField_a_of_type_AndroidAppDialog.setCancelable(true);
      this.jdField_a_of_type_AndroidAppDialog.show();
      this.jdField_a_of_type_AndroidAppDialog.setContentView(2131559437);
      this.jdField_a_of_type_AndroidAppDialog.setOnCancelListener(this);
    }
    String str = paramInt2 + "%";
    TextView localTextView = (TextView)this.jdField_a_of_type_AndroidAppDialog.findViewById(2131371894);
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
      str = localTextView.getResources().getText(2131689981) + str;
      continue;
      str = localTextView.getResources().getText(2131689979) + str;
    }
  }
  
  public void f()
  {
    super.f();
    this.jdField_a_of_type_JavaUtilArrayList.clear();
    this.jdField_a_of_type_JavaUtilArrayList = null;
    this.jdField_a_of_type_Agjh = null;
    aghu.a().b(this);
  }
  
  public void h()
  {
    if (this.jdField_a_of_type_ComTencentCommonGalleryactivityAbstractImageAdapter != null)
    {
      this.jdField_a_of_type_ComTencentWidgetGestureSelectGridView.post(new AIOImageListScene.7(this));
      this.jdField_a_of_type_AndroidWidgetTextView.setText(2131720329);
    }
  }
  
  protected void i()
  {
    int k = 0;
    bhuf localbhuf = (bhuf)bhus.a(this.jdField_a_of_type_AndroidAppActivity, null);
    localbhuf.a(2131689982);
    localbhuf.a(2131689983, 5);
    int m = a();
    int i = 0;
    for (;;)
    {
      int j = k;
      if (i < this.jdField_a_of_type_JavaUtilArrayList.size())
      {
        if (((((agkf)this.jdField_a_of_type_JavaUtilArrayList.get(i)).jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData instanceof AIOImageData)) && (((AIOImageData)((agkf)this.jdField_a_of_type_JavaUtilArrayList.get(i)).jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData).e == null)) {
          j = 1;
        }
      }
      else
      {
        if ((m == 1) && (j == 0)) {
          localbhuf.b(2131693500);
        }
        if ((this.jdField_c_of_type_Boolean) && (m == 1) && (j == 0)) {
          localbhuf.a(2131693488, 5);
        }
        localbhuf.c(2131690648);
        localbhuf.a(new agjj(this, localbhuf));
        localbhuf.show();
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
    agkf localagkf;
    do
    {
      if (!((Iterator)localObject).hasNext()) {
        break label213;
      }
      localagkf = (agkf)((Iterator)localObject).next();
      if (!AIOImageData.class.isInstance(localagkf.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData)) {
        break;
      }
    } while (((AIOImageData)localagkf.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData).a(2) != null);
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
        if (!AIOShortVideoData.class.isInstance(localagkf.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData)) {
          break;
        }
        break;
        localObject = BaseApplication.getContext();
        boolean bool = SettingCloneUtil.readValue((Context)localObject, null, ((Context)localObject).getString(2131695482), "qqsetting_auto_receive_pic_key", true);
        i = bdin.b((Context)localObject);
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
    if (this.jdField_a_of_type_Agjh != null)
    {
      j = this.jdField_a_of_type_Agjh.f();
      k = this.jdField_a_of_type_Agjh.e();
      i = this.jdField_a_of_type_Agjh.d();
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
          this.jdField_a_of_type_Agjh.b(this.jdField_a_of_type_ComTencentWidgetGestureSelectGridView.getFirstVisiblePosition());
          this.jdField_a_of_type_Agjh.c(this.jdField_a_of_type_ComTencentWidgetGestureSelectGridView.getLastVisiblePosition());
        }
      }
      else if (QLog.isColorLevel())
      {
        i = this.jdField_a_of_type_Agjh.b();
        j = this.jdField_a_of_type_Agjh.e();
        k = this.jdField_a_of_type_Agjh.d();
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
      if ((this.jdField_a_of_type_JavaUtilArrayList.get(i) != null) && (((agkf)this.jdField_a_of_type_JavaUtilArrayList.get(i)).jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData != null)) {
        arrayOfLong[i] = ((agkf)this.jdField_a_of_type_JavaUtilArrayList.get(i)).jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData.jdField_f_of_type_Long;
      }
      i += 1;
    }
    if (this.jdField_a_of_type_Agki.asBinder().pingBinder())
    {
      this.jdField_a_of_type_Agki.a(arrayOfLong);
      QQToast.a(this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_AndroidAppActivity.getString(2131692914), 0).a();
    }
  }
  
  public void n()
  {
    if (this.jdField_a_of_type_Agki != null) {
      this.jdField_a_of_type_Agki.a(0);
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
    this.jdField_a_of_type_Agjh.b();
    this.jdField_a_of_type_Agjh.b();
    aghu.a().a(this);
  }
  
  public void onCancel(DialogInterface paramDialogInterface)
  {
    this.jdField_a_of_type_AndroidAppDialog = null;
    paramDialogInterface = this.jdField_a_of_type_Agjq;
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
      int i = this.jdField_a_of_type_Agjh.g();
      if (((paramInt >= i - 28) || (paramInt == i)) && (this.jdField_d_of_type_Int != i))
      {
        if (QLog.isColorLevel()) {
          QLog.d("AIOImageListScene", 2, "[onScroll] loadMedias: mLastLoadingCount=" + this.jdField_d_of_type_Int);
        }
        this.jdField_d_of_type_Int = i;
        ((agjx)this.jdField_a_of_type_ComTencentCommonGalleryactivityAbstractImageAdapter).a(true);
        this.jdField_a_of_type_Agki.a(0);
      }
    }
  }
  
  void q()
  {
    if (QLog.isColorLevel()) {
      QLog.d("AIOImageListScene", 2, "forwardAllImage");
    }
    Object localObject = BaseApplication.getContext();
    boolean bool = SettingCloneUtil.readValue((Context)localObject, null, ((Context)localObject).getString(2131695482), "qqsetting_auto_receive_pic_key", true);
    int i;
    int j;
    if (bdin.b(BaseApplication.getContext()) == 1)
    {
      i = 1;
      if (bdin.b(BaseApplication.getContext()) != -1) {
        break label137;
      }
      j = 1;
      label65:
      localObject = this.jdField_a_of_type_JavaUtilArrayList.iterator();
      agkf localagkf;
      do
      {
        if (!((Iterator)localObject).hasNext()) {
          break;
        }
        localagkf = (agkf)((Iterator)localObject).next();
      } while ((!AIOImageData.class.isInstance(localagkf.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData)) || (localagkf.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData.a(2) != null));
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
      Object localObject = (agkf)localIterator.next();
      if (AIOImageData.class.isInstance(((agkf)localObject).jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData))
      {
        localObject = (AIOImageData)((agkf)localObject).jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData;
        localArrayList1.add(((AIOImageData)localObject).jdField_a_of_type_JavaLangString);
        localArrayList2.add(((AIOImageData)localObject).e);
        localArrayList3.add(Long.valueOf(((AIOImageData)localObject).c));
      }
    }
    agjb.a(this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_JavaLangString, this.jdField_b_of_type_JavaLangString, this.jdField_c_of_type_JavaLangString, localArrayList1, localArrayList2, localArrayList3, 2, null, null);
  }
  
  void u()
  {
    if (QLog.isColorLevel()) {
      QLog.d("AIOImageListScene", 2, "forwardToQZoneAlbum()");
    }
    agjb.a(this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_JavaLangString, this.jdField_c_of_type_JavaLangString, this.jdField_b_of_type_Int, (List)this.jdField_a_of_type_JavaUtilArrayList.clone(), this.jdField_c_of_type_Boolean, this.jdField_b_of_type_JavaLangString);
  }
  
  void v()
  {
    if ((this.jdField_a_of_type_JavaUtilArrayList != null) && (this.jdField_a_of_type_JavaUtilArrayList.get(0) != null))
    {
      localObject1 = (agkf)this.jdField_a_of_type_JavaUtilArrayList.get(0);
      if (AIOImageData.class.isInstance(((agkf)localObject1).jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData))
      {
        localObject2 = (AIOImageData)((agkf)localObject1).jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData;
        localObject1 = new Bundle();
        ((Bundle)localObject1).putInt("forward_type", 12);
        localObject3 = ((AIOImageData)localObject2).a(2);
        ((Bundle)localObject1).putString("forward_urldrawable_thumb_url", ((AIOImageData)localObject2).a(1));
        ((Bundle)localObject1).putString("forward_urldrawable_big_url", (String)localObject3);
        ((Bundle)localObject1).putBoolean("forward_urldrawable", true);
        if (this.jdField_a_of_type_JavaUtilArrayList.size() > 1) {
          ((Bundle)localObject1).putString("forward_text", this.jdField_a_of_type_JavaUtilArrayList.size() + alud.a(2131700471));
        }
        ((Bundle)localObject1).putBoolean("sendMultiple", true);
        ((Bundle)localObject1).putBoolean("key_allow_forward_photo_preview_edit", true);
        localObject2 = new ArrayList();
        localObject3 = this.jdField_a_of_type_JavaUtilArrayList.iterator();
        while (((Iterator)localObject3).hasNext())
        {
          localagkf = (agkf)((Iterator)localObject3).next();
          if (AIOImageData.class.isInstance(localagkf.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData)) {
            ((ArrayList)localObject2).add(((AIOImageData)localagkf.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData).jdField_b_of_type_JavaLangString);
          } else if (AIOFilePicData.class.isInstance(localagkf.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData)) {
            if (((AIOFilePicData)localagkf.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData).a(20) != null) {
              ((ArrayList)localObject2).add(((AIOFilePicData)localagkf.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData).jdField_d_of_type_JavaLangString);
            } else if (((AIOFilePicData)localagkf.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData).a(18) != null) {
              ((ArrayList)localObject2).add(((AIOFilePicData)localagkf.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData).jdField_c_of_type_JavaLangString);
            } else if (((AIOFilePicData)localagkf.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData).a(16) != null) {
              ((ArrayList)localObject2).add(((AIOFilePicData)localagkf.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData).jdField_b_of_type_JavaLangString);
            }
          }
        }
        ((Bundle)localObject1).putStringArrayList("PhotoConst.PHOTO_PATHS", (ArrayList)localObject2);
        localObject2 = new Intent();
        ((Intent)localObject2).putExtras((Bundle)localObject1);
        aryv.a(this.jdField_a_of_type_AndroidAppActivity, (Intent)localObject2, 1);
      }
    }
    while (!QLog.isColorLevel())
    {
      agkf localagkf;
      do
      {
        return;
      } while (!AIOFilePicData.class.isInstance(((agkf)localObject1).jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData));
      Object localObject2 = (AIOFilePicData)((agkf)localObject1).jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData;
      Object localObject1 = new Bundle();
      ((Bundle)localObject1).putInt("forward_type", 12);
      Object localObject3 = ((AIOFilePicData)localObject2).a(18);
      ((Bundle)localObject1).putString("forward_urldrawable_thumb_url", ((AIOFilePicData)localObject2).a(16));
      ((Bundle)localObject1).putString("forward_urldrawable_big_url", (String)localObject3);
      ((Bundle)localObject1).putBoolean("forward_urldrawable", true);
      if (this.jdField_a_of_type_JavaUtilArrayList.size() > 1) {
        ((Bundle)localObject1).putString("forward_text", this.jdField_a_of_type_JavaUtilArrayList.size() + alud.a(2131700472));
      }
      ((Bundle)localObject1).putBoolean("sendMultiple", true);
      localObject2 = new ArrayList();
      localObject3 = this.jdField_a_of_type_JavaUtilArrayList.iterator();
      while (((Iterator)localObject3).hasNext())
      {
        localagkf = (agkf)((Iterator)localObject3).next();
        if (AIOImageData.class.isInstance(localagkf.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData)) {
          ((ArrayList)localObject2).add(((AIOImageData)localagkf.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData).jdField_b_of_type_JavaLangString);
        } else if (AIOFilePicData.class.isInstance(localagkf.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData)) {
          if (((AIOFilePicData)localagkf.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData).a(20) != null) {
            ((ArrayList)localObject2).add(((AIOFilePicData)localagkf.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData).jdField_d_of_type_JavaLangString);
          } else if (((AIOFilePicData)localagkf.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData).a(18) != null) {
            ((ArrayList)localObject2).add(((AIOFilePicData)localagkf.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData).jdField_c_of_type_JavaLangString);
          } else if (((AIOFilePicData)localagkf.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData).a(16) != null) {
            ((ArrayList)localObject2).add(((AIOFilePicData)localagkf.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData).jdField_b_of_type_JavaLangString);
          }
        }
      }
      ((Bundle)localObject1).putStringArrayList("PhotoConst.PHOTO_PATHS", (ArrayList)localObject2);
      localObject2 = new Intent();
      ((Intent)localObject2).putExtras((Bundle)localObject1);
      aryv.a(this.jdField_a_of_type_AndroidAppActivity, (Intent)localObject2, 1);
      return;
    }
    QLog.d("AIOImageListScene", 2, "callForwardRecentActivity error! mSelectedPhotoList ==null || mSelectedPhotoList.get(0) == null || !mSelectedPhotoList.get(0) instanceof AIOImageInfo");
  }
  
  void w()
  {
    ((agjx)this.jdField_a_of_type_ComTencentCommonGalleryactivityAbstractImageAdapter).jdField_a_of_type_Boolean = this.jdField_b_of_type_Boolean;
    int i;
    if (this.jdField_b_of_type_Boolean)
    {
      this.jdField_c_of_type_AndroidWidgetTextView.setText(2131689927);
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
      this.jdField_c_of_type_AndroidWidgetTextView.setText(2131690047);
      this.jdField_a_of_type_AndroidViewView.setVisibility(8);
      Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
      while (localIterator.hasNext()) {
        ((zjd)localIterator.next()).a(2);
      }
      this.jdField_a_of_type_JavaUtilArrayList.clear();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     agji
 * JD-Core Version:    0.7.0.1
 */