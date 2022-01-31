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

public class aget
  extends zed
  implements agdh, DialogInterface.OnCancelListener, bhpo
{
  long jdField_a_of_type_Long;
  public ages a;
  agfb jdField_a_of_type_Agfb;
  agft jdField_a_of_type_Agft;
  String jdField_a_of_type_JavaLangString;
  public ArrayList<agfq> a;
  int jdField_b_of_type_Int = 1;
  String jdField_b_of_type_JavaLangString;
  int jdField_c_of_type_Int;
  String jdField_c_of_type_JavaLangString;
  boolean jdField_c_of_type_Boolean = false;
  private int jdField_d_of_type_Int;
  String jdField_d_of_type_JavaLangString;
  
  public aget(Activity paramActivity, zec paramzec, agft paramagft, String paramString)
  {
    super(paramActivity, paramzec);
    this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
    this.jdField_a_of_type_Ages = ((ages)paramzec);
    this.jdField_a_of_type_Agft = paramagft;
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
    localIntent = aekt.a(localIntent, null);
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
    AIORichMediaData localAIORichMediaData = ((agfq)this.jdField_a_of_type_JavaUtilArrayList.get(0)).jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData;
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
    int j = this.jdField_a_of_type_Ages.f();
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
    return new agfa(this);
  }
  
  protected bhqp a()
  {
    return new agey(this);
  }
  
  protected bhte a()
  {
    return new agez(this);
  }
  
  protected AbstractImageAdapter a(Activity paramActivity, int paramInt)
  {
    this.jdField_a_of_type_ComTencentCommonGalleryactivityAbstractImageAdapter = new agfi(this.jdField_a_of_type_AndroidAppActivity, paramInt, this.jdField_a_of_type_Ages, this.jdField_a_of_type_Agft, this.jdField_a_of_type_ComTencentWidgetGestureSelectGridView);
    this.jdField_a_of_type_ComTencentCommonGalleryactivityAbstractImageAdapter.a(this.jdField_a_of_type_Ages);
    return this.jdField_a_of_type_ComTencentCommonGalleryactivityAbstractImageAdapter;
  }
  
  void a(int paramInt1, int paramInt2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("AIOImageListScene", 2, "showDownloadResult type = " + paramInt1);
    }
    if (this.jdField_a_of_type_Bdfq != null) {
      this.jdField_a_of_type_Bdfq.dismiss();
    }
    this.jdField_a_of_type_Bdfq = bdcd.a(this.jdField_a_of_type_AndroidAppActivity, 230);
    this.jdField_a_of_type_Bdfq.setOnDismissListener(new agew(this));
    Object localObject;
    switch (paramInt1)
    {
    case 2: 
    default: 
      this.jdField_a_of_type_Bdfq = null;
      return;
    case 1: 
      this.jdField_a_of_type_Bdfq.setTitle(String.format(this.jdField_a_of_type_AndroidAppActivity.getResources().getString(2131689980), new Object[] { Integer.valueOf(paramInt2) }));
      this.jdField_a_of_type_Bdfq.setPositiveButton(2131694951, new bdco());
      this.jdField_a_of_type_Bdfq.show();
      return;
    case 0: 
      this.jdField_a_of_type_Bdfq.setTitle(2131689948);
      localObject = new agex(this, paramInt2);
      this.jdField_a_of_type_Bdfq.setNegativeButton(2131690648, (DialogInterface.OnClickListener)localObject);
      this.jdField_a_of_type_Bdfq.setPositiveButton(2131719919, (DialogInterface.OnClickListener)localObject);
      this.jdField_a_of_type_Bdfq.show();
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("AIOImageListScene", 2, "showSDCardResult type = " + paramInt2);
    }
    String str;
    if (paramInt2 == 22)
    {
      localObject = this.jdField_a_of_type_AndroidAppActivity.getString(2131719542);
      str = this.jdField_a_of_type_AndroidAppActivity.getString(2131719541);
    }
    for (;;)
    {
      this.jdField_a_of_type_Bdfq = bdcd.a(this.jdField_a_of_type_AndroidAppActivity, 230, (String)localObject, str, null, null);
      this.jdField_a_of_type_Bdfq.setTitle((String)localObject);
      this.jdField_a_of_type_Bdfq.setMessage(str);
      this.jdField_a_of_type_Bdfq.setPositiveButton(2131694951, new bdco());
      this.jdField_a_of_type_Bdfq.show();
      return;
      if (paramInt2 == 24)
      {
        localObject = this.jdField_a_of_type_AndroidAppActivity.getString(2131719547);
        str = this.jdField_a_of_type_AndroidAppActivity.getString(2131719546);
      }
      else if (paramInt2 == 23)
      {
        localObject = this.jdField_a_of_type_AndroidAppActivity.getString(2131719544);
        str = this.jdField_a_of_type_AndroidAppActivity.getString(2131719543);
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
          ((zeo)paramIntent.next()).a(2);
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
    if ((this.jdField_a_of_type_Zep != null) && (this.jdField_a_of_type_Zep.a() == this)) {}
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
    if (this.jdField_a_of_type_Ages == null) {}
    Object localObject1;
    label24:
    int i;
    int j;
    int k;
    label109:
    do
    {
      return;
      localObject4 = this.jdField_a_of_type_Ages;
      if (paramInt3 != 1) {
        break;
      }
      localObject1 = ???;
      i = ((ages)localObject4).a(paramLong, paramInt1, paramInt2, (String)localObject1, true);
      if (paramInt2 != 1) {
        break label240;
      }
      j = this.jdField_a_of_type_ComTencentWidgetGestureSelectGridView.getFirstVisiblePosition();
      k = this.jdField_a_of_type_ComTencentWidgetGestureSelectGridView.getChildCount();
      if ((i >= j) && (i <= k + j - 1))
      {
        localObject1 = this.jdField_a_of_type_ComTencentWidgetGestureSelectGridView.getChildAt(i - j);
        ((agfi)this.jdField_a_of_type_ComTencentCommonGalleryactivityAbstractImageAdapter).a(i, (View)localObject1);
      }
      if ((paramInt2 != 2) || (this.jdField_a_of_type_Agfb == null)) {
        break label313;
      }
      localObject1 = this.jdField_a_of_type_Agfb;
    } while ((((agfb)localObject1).jdField_a_of_type_Agfq == null) || (((agfb)localObject1).jdField_a_of_type_Agfq.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData.jdField_f_of_type_Long != paramLong) || (((agfb)localObject1).jdField_a_of_type_Agfq.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData.jdField_f_of_type_Int != paramInt1));
    Object localObject4 = (AIOImageData)((agfb)localObject1).jdField_a_of_type_Agfq.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData;
    if (paramInt3 == 1) {}
    for (;;)
    {
      ((AIOImageData)localObject4).jdField_b_of_type_JavaLangString = ???;
      ((agfb)localObject1).jdField_a_of_type_Agfq.jdField_a_of_type_Boolean = false;
      synchronized (((agfb)localObject1).jdField_a_of_type_Agfq)
      {
        ((agfb)localObject1).jdField_a_of_type_Agfq.notifyAll();
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
      ((agfi)this.jdField_a_of_type_ComTencentCommonGalleryactivityAbstractImageAdapter).a(i, (View)localObject3);
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
    this.jdField_a_of_type_Agfb = new agfb(this, this.jdField_a_of_type_JavaUtilArrayList);
    this.jdField_a_of_type_Agfb.execute(paramVarArgs);
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
  
  boolean a(agfq paramagfq, boolean paramBoolean1, boolean paramBoolean2)
  {
    int i = a();
    if (paramBoolean2)
    {
      if (AIOShortVideoData.class.isInstance(paramagfq.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData)) {
        return false;
      }
      if (i == 2) {
        return false;
      }
    }
    int j = paramagfq.b();
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
        QQToast.a(this.jdField_a_of_type_AndroidAppActivity, 1, alpo.a(2131700467) + 20 + alpo.a(2131700462), 0).b(this.jdField_a_of_type_AndroidAppActivity.getResources().getDimensionPixelSize(2131298914));
      }
      for (;;)
      {
        this.jdField_a_of_type_Long = l;
        return false;
        label174:
        QQToast.a(this.jdField_a_of_type_AndroidAppActivity, 1, alpo.a(2131700457) + 20 + alpo.a(2131700461), 0).b(this.jdField_a_of_type_AndroidAppActivity.getResources().getDimensionPixelSize(2131298914));
      }
    }
    if ((AIOFilePicData.class.isInstance(paramagfq.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData)) && (paramagfq.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData.a(20) == null) && (paramagfq.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData.a(18) == null) && (paramagfq.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData.a(16) == null))
    {
      if (QLog.isColorLevel()) {
        QLog.d("AIOImageListScene", 2, "AIOFilePicData has null path!");
      }
      return false;
    }
    if (paramBoolean1)
    {
      paramagfq.a(1);
      this.jdField_a_of_type_JavaUtilArrayList.add(paramagfq);
    }
    for (;;)
    {
      return true;
      paramagfq.a(2);
      this.jdField_a_of_type_JavaUtilArrayList.remove(paramagfq);
    }
  }
  
  boolean a(View paramView, zeo paramzeo)
  {
    Object localObject = (agfk)paramView.getTag();
    if (localObject != null)
    {
      paramView = ((agfk)localObject).jdField_a_of_type_AndroidWidgetImageView;
      localObject = ((agfk)localObject).jdField_b_of_type_AndroidWidgetImageView;
      switch (paramzeo.b())
      {
      default: 
        paramView.setVisibility(4);
        ((ImageView)localObject).setVisibility(4);
      }
      for (;;)
      {
        return true;
        paramView.setVisibility(0);
        ((ImageView)localObject).setImageResource(2130845226);
        ((ImageView)localObject).setVisibility(0);
        continue;
        paramView.setVisibility(4);
        ((ImageView)localObject).setImageResource(2130845223);
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
      QQToast.a(this.jdField_a_of_type_AndroidAppActivity, 2, this.jdField_a_of_type_AndroidAppActivity.getResources().getString(2131689978) + aljq.bd, 0).b(this.jdField_a_of_type_AndroidAppActivity.getResources().getDimensionPixelSize(2131298914));
      return;
    case 21: 
      QQToast.a(this.jdField_a_of_type_AndroidAppActivity, 1, this.jdField_a_of_type_AndroidAppActivity.getResources().getString(2131689977) + aljq.bd, 0).b(this.jdField_a_of_type_AndroidAppActivity.getResources().getDimensionPixelSize(2131298914));
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
      this.jdField_a_of_type_AndroidAppDialog.setContentView(2131559438);
      this.jdField_a_of_type_AndroidAppDialog.setOnCancelListener(this);
    }
    String str = paramInt2 + "%";
    TextView localTextView = (TextView)this.jdField_a_of_type_AndroidAppDialog.findViewById(2131371874);
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
    this.jdField_a_of_type_Ages = null;
    agdf.a().b(this);
  }
  
  public void h()
  {
    if (this.jdField_a_of_type_ComTencentCommonGalleryactivityAbstractImageAdapter != null)
    {
      this.jdField_a_of_type_ComTencentWidgetGestureSelectGridView.post(new AIOImageListScene.7(this));
      this.jdField_a_of_type_AndroidWidgetTextView.setText(2131720317);
    }
  }
  
  protected void i()
  {
    int k = 0;
    bhpy localbhpy = (bhpy)bhql.a(this.jdField_a_of_type_AndroidAppActivity, null);
    localbhpy.a(2131689982);
    localbhpy.a(2131689983, 5);
    int m = a();
    int i = 0;
    for (;;)
    {
      int j = k;
      if (i < this.jdField_a_of_type_JavaUtilArrayList.size())
      {
        if (((((agfq)this.jdField_a_of_type_JavaUtilArrayList.get(i)).jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData instanceof AIOImageData)) && (((AIOImageData)((agfq)this.jdField_a_of_type_JavaUtilArrayList.get(i)).jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData).e == null)) {
          j = 1;
        }
      }
      else
      {
        if ((m == 1) && (j == 0)) {
          localbhpy.b(2131693498);
        }
        if ((this.jdField_c_of_type_Boolean) && (m == 1) && (j == 0)) {
          localbhpy.a(2131693486, 5);
        }
        localbhpy.c(2131690648);
        localbhpy.a(new ageu(this, localbhpy));
        localbhpy.show();
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
    agfq localagfq;
    do
    {
      if (!((Iterator)localObject).hasNext()) {
        break label213;
      }
      localagfq = (agfq)((Iterator)localObject).next();
      if (!AIOImageData.class.isInstance(localagfq.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData)) {
        break;
      }
    } while (((AIOImageData)localagfq.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData).a(2) != null);
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
        if (!AIOShortVideoData.class.isInstance(localagfq.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData)) {
          break;
        }
        break;
        localObject = BaseApplication.getContext();
        boolean bool = SettingCloneUtil.readValue((Context)localObject, null, ((Context)localObject).getString(2131695480), "qqsetting_auto_receive_pic_key", true);
        i = bdee.b((Context)localObject);
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
    if (this.jdField_a_of_type_Ages != null)
    {
      j = this.jdField_a_of_type_Ages.f();
      k = this.jdField_a_of_type_Ages.e();
      i = this.jdField_a_of_type_Ages.d();
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
          this.jdField_a_of_type_Ages.b(this.jdField_a_of_type_ComTencentWidgetGestureSelectGridView.getFirstVisiblePosition());
          this.jdField_a_of_type_Ages.c(this.jdField_a_of_type_ComTencentWidgetGestureSelectGridView.getLastVisiblePosition());
        }
      }
      else if (QLog.isColorLevel())
      {
        i = this.jdField_a_of_type_Ages.b();
        j = this.jdField_a_of_type_Ages.e();
        k = this.jdField_a_of_type_Ages.d();
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
      if ((this.jdField_a_of_type_JavaUtilArrayList.get(i) != null) && (((agfq)this.jdField_a_of_type_JavaUtilArrayList.get(i)).jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData != null)) {
        arrayOfLong[i] = ((agfq)this.jdField_a_of_type_JavaUtilArrayList.get(i)).jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData.jdField_f_of_type_Long;
      }
      i += 1;
    }
    if (this.jdField_a_of_type_Agft.asBinder().pingBinder())
    {
      this.jdField_a_of_type_Agft.a(arrayOfLong);
      QQToast.a(this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_AndroidAppActivity.getString(2131692912), 0).a();
    }
  }
  
  public void n()
  {
    if (this.jdField_a_of_type_Agft != null) {
      this.jdField_a_of_type_Agft.a(0);
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
    this.jdField_a_of_type_Ages.b();
    this.jdField_a_of_type_Ages.b();
    agdf.a().a(this);
  }
  
  public void onCancel(DialogInterface paramDialogInterface)
  {
    this.jdField_a_of_type_AndroidAppDialog = null;
    paramDialogInterface = this.jdField_a_of_type_Agfb;
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
      int i = this.jdField_a_of_type_Ages.g();
      if (((paramInt >= i - 28) || (paramInt == i)) && (this.jdField_d_of_type_Int != i))
      {
        if (QLog.isColorLevel()) {
          QLog.d("AIOImageListScene", 2, "[onScroll] loadMedias: mLastLoadingCount=" + this.jdField_d_of_type_Int);
        }
        this.jdField_d_of_type_Int = i;
        ((agfi)this.jdField_a_of_type_ComTencentCommonGalleryactivityAbstractImageAdapter).a(true);
        this.jdField_a_of_type_Agft.a(0);
      }
    }
  }
  
  void q()
  {
    if (QLog.isColorLevel()) {
      QLog.d("AIOImageListScene", 2, "forwardAllImage");
    }
    Object localObject = BaseApplication.getContext();
    boolean bool = SettingCloneUtil.readValue((Context)localObject, null, ((Context)localObject).getString(2131695480), "qqsetting_auto_receive_pic_key", true);
    int i;
    int j;
    if (bdee.b(BaseApplication.getContext()) == 1)
    {
      i = 1;
      if (bdee.b(BaseApplication.getContext()) != -1) {
        break label137;
      }
      j = 1;
      label65:
      localObject = this.jdField_a_of_type_JavaUtilArrayList.iterator();
      agfq localagfq;
      do
      {
        if (!((Iterator)localObject).hasNext()) {
          break;
        }
        localagfq = (agfq)((Iterator)localObject).next();
      } while ((!AIOImageData.class.isInstance(localagfq.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData)) || (localagfq.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData.a(2) != null));
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
      Object localObject = (agfq)localIterator.next();
      if (AIOImageData.class.isInstance(((agfq)localObject).jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData))
      {
        localObject = (AIOImageData)((agfq)localObject).jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData;
        localArrayList1.add(((AIOImageData)localObject).jdField_a_of_type_JavaLangString);
        localArrayList2.add(((AIOImageData)localObject).e);
        localArrayList3.add(Long.valueOf(((AIOImageData)localObject).c));
      }
    }
    agem.a(this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_JavaLangString, this.jdField_b_of_type_JavaLangString, this.jdField_c_of_type_JavaLangString, localArrayList1, localArrayList2, localArrayList3, 2, null, null);
  }
  
  void u()
  {
    if (QLog.isColorLevel()) {
      QLog.d("AIOImageListScene", 2, "forwardToQZoneAlbum()");
    }
    agem.a(this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_JavaLangString, this.jdField_c_of_type_JavaLangString, this.jdField_b_of_type_Int, (List)this.jdField_a_of_type_JavaUtilArrayList.clone(), this.jdField_c_of_type_Boolean, this.jdField_b_of_type_JavaLangString);
  }
  
  void v()
  {
    if ((this.jdField_a_of_type_JavaUtilArrayList != null) && (this.jdField_a_of_type_JavaUtilArrayList.get(0) != null))
    {
      localObject1 = (agfq)this.jdField_a_of_type_JavaUtilArrayList.get(0);
      if (AIOImageData.class.isInstance(((agfq)localObject1).jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData))
      {
        localObject2 = (AIOImageData)((agfq)localObject1).jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData;
        localObject1 = new Bundle();
        ((Bundle)localObject1).putInt("forward_type", 12);
        localObject3 = ((AIOImageData)localObject2).a(2);
        ((Bundle)localObject1).putString("forward_urldrawable_thumb_url", ((AIOImageData)localObject2).a(1));
        ((Bundle)localObject1).putString("forward_urldrawable_big_url", (String)localObject3);
        ((Bundle)localObject1).putBoolean("forward_urldrawable", true);
        if (this.jdField_a_of_type_JavaUtilArrayList.size() > 1) {
          ((Bundle)localObject1).putString("forward_text", this.jdField_a_of_type_JavaUtilArrayList.size() + alpo.a(2131700459));
        }
        ((Bundle)localObject1).putBoolean("sendMultiple", true);
        ((Bundle)localObject1).putBoolean("key_allow_forward_photo_preview_edit", true);
        localObject2 = new ArrayList();
        localObject3 = this.jdField_a_of_type_JavaUtilArrayList.iterator();
        while (((Iterator)localObject3).hasNext())
        {
          localagfq = (agfq)((Iterator)localObject3).next();
          if (AIOImageData.class.isInstance(localagfq.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData)) {
            ((ArrayList)localObject2).add(((AIOImageData)localagfq.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData).jdField_b_of_type_JavaLangString);
          } else if (AIOFilePicData.class.isInstance(localagfq.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData)) {
            if (((AIOFilePicData)localagfq.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData).a(20) != null) {
              ((ArrayList)localObject2).add(((AIOFilePicData)localagfq.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData).jdField_d_of_type_JavaLangString);
            } else if (((AIOFilePicData)localagfq.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData).a(18) != null) {
              ((ArrayList)localObject2).add(((AIOFilePicData)localagfq.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData).jdField_c_of_type_JavaLangString);
            } else if (((AIOFilePicData)localagfq.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData).a(16) != null) {
              ((ArrayList)localObject2).add(((AIOFilePicData)localagfq.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData).jdField_b_of_type_JavaLangString);
            }
          }
        }
        ((Bundle)localObject1).putStringArrayList("PhotoConst.PHOTO_PATHS", (ArrayList)localObject2);
        localObject2 = new Intent();
        ((Intent)localObject2).putExtras((Bundle)localObject1);
        arum.a(this.jdField_a_of_type_AndroidAppActivity, (Intent)localObject2, 1);
      }
    }
    while (!QLog.isColorLevel())
    {
      agfq localagfq;
      do
      {
        return;
      } while (!AIOFilePicData.class.isInstance(((agfq)localObject1).jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData));
      Object localObject2 = (AIOFilePicData)((agfq)localObject1).jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData;
      Object localObject1 = new Bundle();
      ((Bundle)localObject1).putInt("forward_type", 12);
      Object localObject3 = ((AIOFilePicData)localObject2).a(18);
      ((Bundle)localObject1).putString("forward_urldrawable_thumb_url", ((AIOFilePicData)localObject2).a(16));
      ((Bundle)localObject1).putString("forward_urldrawable_big_url", (String)localObject3);
      ((Bundle)localObject1).putBoolean("forward_urldrawable", true);
      if (this.jdField_a_of_type_JavaUtilArrayList.size() > 1) {
        ((Bundle)localObject1).putString("forward_text", this.jdField_a_of_type_JavaUtilArrayList.size() + alpo.a(2131700460));
      }
      ((Bundle)localObject1).putBoolean("sendMultiple", true);
      localObject2 = new ArrayList();
      localObject3 = this.jdField_a_of_type_JavaUtilArrayList.iterator();
      while (((Iterator)localObject3).hasNext())
      {
        localagfq = (agfq)((Iterator)localObject3).next();
        if (AIOImageData.class.isInstance(localagfq.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData)) {
          ((ArrayList)localObject2).add(((AIOImageData)localagfq.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData).jdField_b_of_type_JavaLangString);
        } else if (AIOFilePicData.class.isInstance(localagfq.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData)) {
          if (((AIOFilePicData)localagfq.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData).a(20) != null) {
            ((ArrayList)localObject2).add(((AIOFilePicData)localagfq.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData).jdField_d_of_type_JavaLangString);
          } else if (((AIOFilePicData)localagfq.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData).a(18) != null) {
            ((ArrayList)localObject2).add(((AIOFilePicData)localagfq.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData).jdField_c_of_type_JavaLangString);
          } else if (((AIOFilePicData)localagfq.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData).a(16) != null) {
            ((ArrayList)localObject2).add(((AIOFilePicData)localagfq.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData).jdField_b_of_type_JavaLangString);
          }
        }
      }
      ((Bundle)localObject1).putStringArrayList("PhotoConst.PHOTO_PATHS", (ArrayList)localObject2);
      localObject2 = new Intent();
      ((Intent)localObject2).putExtras((Bundle)localObject1);
      arum.a(this.jdField_a_of_type_AndroidAppActivity, (Intent)localObject2, 1);
      return;
    }
    QLog.d("AIOImageListScene", 2, "callForwardRecentActivity error! mSelectedPhotoList ==null || mSelectedPhotoList.get(0) == null || !mSelectedPhotoList.get(0) instanceof AIOImageInfo");
  }
  
  void w()
  {
    ((agfi)this.jdField_a_of_type_ComTencentCommonGalleryactivityAbstractImageAdapter).jdField_a_of_type_Boolean = this.jdField_b_of_type_Boolean;
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
        ((zeo)localIterator.next()).a(2);
      }
      this.jdField_a_of_type_JavaUtilArrayList.clear();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aget
 * JD-Core Version:    0.7.0.1
 */