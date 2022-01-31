import android.app.Activity;
import android.media.AudioManager;
import android.os.Build.VERSION;
import android.view.View;
import android.view.Window;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import com.tencent.mobileqq.activity.aio.photo.AIOShortVideoData;
import com.tencent.mobileqq.activity.photo.VideoPlayController.1;
import com.tencent.mobileqq.activity.photo.VideoPlayController.2;
import com.tencent.mobileqq.activity.photo.VideoPlayController.3;
import com.tencent.mobileqq.activity.photo.VideoPlayController.4;
import com.tencent.mobileqq.data.MessageForShortVideo;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.mediaplayer.view.IVideoViewBase;
import java.util.HashMap;

public abstract class aiqf
{
  private int jdField_a_of_type_Int = 0;
  protected agki a;
  aiob jdField_a_of_type_Aiob = new aiob();
  aiqg jdField_a_of_type_Aiqg = new aiqg(this, null);
  public aiqh a;
  public aiqo a;
  Activity jdField_a_of_type_AndroidAppActivity;
  View jdField_a_of_type_AndroidViewView;
  FrameLayout jdField_a_of_type_AndroidWidgetFrameLayout;
  private Runnable jdField_a_of_type_JavaLangRunnable = new VideoPlayController.1(this);
  private final String jdField_a_of_type_JavaLangString = "carverW VideoPlayController";
  protected boolean a;
  private boolean b;
  private boolean c;
  private boolean d;
  
  private void a(aiqo paramaiqo)
  {
    if (QLog.isColorLevel()) {
      QLog.d("carverW VideoPlayController", 2, "#initMediaPlayVideo  ");
    }
    if (this.jdField_a_of_type_AndroidWidgetFrameLayout != null) {
      this.jdField_a_of_type_AndroidWidgetFrameLayout.setVisibility(0);
    }
    if (this.jdField_a_of_type_Aiob != null)
    {
      this.jdField_a_of_type_AndroidViewView = this.jdField_a_of_type_Aiob.a(this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_Aiqg, paramaiqo, this.jdField_a_of_type_Agki);
      if (this.jdField_a_of_type_AndroidViewView != null)
      {
        a(this.jdField_a_of_type_AndroidAppActivity);
        paramaiqo = new HashMap();
        azri.a(BaseApplication.getContext()).a(null, "previewVideoViewCreateSuc", true, 0L, 0L, paramaiqo, null);
      }
    }
  }
  
  private void a(Activity paramActivity)
  {
    if (QLog.isColorLevel()) {
      QLog.d("carverW VideoPlayController", 2, "#setupVideoView  ");
    }
    if (this.jdField_a_of_type_AndroidWidgetFrameLayout == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("carverW VideoPlayController", 2, "#setupVideoView  layout is null#");
      }
      return;
    }
    if (Build.VERSION.SDK_INT >= 19) {
      paramActivity.getWindow().addFlags(67108864);
    }
    FrameLayout.LayoutParams localLayoutParams = new FrameLayout.LayoutParams(-1, -1);
    this.jdField_a_of_type_AndroidViewView.setLayoutParams(localLayoutParams);
    this.jdField_a_of_type_AndroidViewView.setVisibility(0);
    this.jdField_a_of_type_AndroidWidgetFrameLayout.addView(this.jdField_a_of_type_AndroidViewView);
    b(paramActivity);
  }
  
  private void b(Activity paramActivity)
  {
    if ((!this.jdField_b_of_type_Boolean) && (this.jdField_a_of_type_AndroidViewView != null) && (this.jdField_a_of_type_Aiob != null))
    {
      this.jdField_a_of_type_Aiob.a(paramActivity, (IVideoViewBase)this.jdField_a_of_type_AndroidViewView);
      this.jdField_b_of_type_Boolean = true;
    }
  }
  
  private void p()
  {
    if ((this.jdField_b_of_type_Boolean) && (this.jdField_a_of_type_Aiob != null)) {
      this.jdField_a_of_type_Aiob.b();
    }
    if ((bhtb.b()) && (this.jdField_a_of_type_AndroidAppActivity != null))
    {
      Activity localActivity1 = this.jdField_a_of_type_AndroidAppActivity;
      Activity localActivity2 = this.jdField_a_of_type_AndroidAppActivity;
      ((AudioManager)localActivity1.getSystemService("audio")).abandonAudioFocus(null);
    }
    if (this.jdField_a_of_type_AndroidAppActivity != null) {
      this.jdField_a_of_type_AndroidAppActivity.runOnUiThread(new VideoPlayController.2(this));
    }
  }
  
  public int a()
  {
    return this.jdField_a_of_type_Int;
  }
  
  public long a()
  {
    if (this.jdField_a_of_type_Aiob != null) {
      return this.jdField_a_of_type_Aiob.b();
    }
    return 0L;
  }
  
  public abstract void a();
  
  public abstract void a(int paramInt);
  
  void a(int paramInt1, int paramInt2)
  {
    String str1 = alud.a(2131716716);
    if (this.jdField_a_of_type_AndroidAppActivity != null) {
      str1 = this.jdField_a_of_type_AndroidAppActivity.getString(2131720129);
    }
    if ((paramInt1 == 101) && (this.jdField_a_of_type_Aiqo != null) && (this.jdField_a_of_type_Aiqo.jdField_a_of_type_ArrayOfJavaLangString != null) && (!bdnn.a(this.jdField_a_of_type_Aiqo.c)))
    {
      localObject = this.jdField_a_of_type_Aiqo.jdField_a_of_type_ArrayOfJavaLangString;
      int j = localObject.length;
      int i = 0;
      while (i < j)
      {
        String str2 = localObject[i];
        if (!bdnn.a(str2)) {
          bazo.a().a(this.jdField_a_of_type_Aiqo.c, bazo.a(str2), 1005);
        }
        i += 1;
      }
      agkr.a().a();
    }
    Object localObject = str1;
    if (paramInt1 == 122) {
      if (paramInt2 != 204)
      {
        localObject = str1;
        if (paramInt2 != 202) {}
      }
      else
      {
        localObject = str1;
        if (this.jdField_a_of_type_AndroidAppActivity != null) {
          localObject = this.jdField_a_of_type_AndroidAppActivity.getString(2131720126);
        }
      }
    }
    if (this.jdField_a_of_type_Aiqh != null) {
      this.jdField_a_of_type_Aiqh.a(this.jdField_a_of_type_Aiqo, paramInt1, paramInt2, (String)localObject);
    }
  }
  
  public abstract void a(int paramInt, String paramString);
  
  public void a(agki paramagki)
  {
    this.jdField_a_of_type_Agki = paramagki;
  }
  
  public void a(aiqh paramaiqh)
  {
    this.jdField_a_of_type_Aiqh = paramaiqh;
  }
  
  public abstract void a(View paramView);
  
  public void a(View paramView, aiqo paramaiqo)
  {
    if ((paramView == null) || (paramaiqo == null) || (this.jdField_a_of_type_Aiob == null)) {
      return;
    }
    h();
    if (this.jdField_a_of_type_AndroidWidgetFrameLayout != null) {
      this.jdField_a_of_type_AndroidWidgetFrameLayout.removeAllViews();
    }
    if (paramView == null)
    {
      a();
      this.jdField_a_of_type_AndroidWidgetFrameLayout = null;
      this.jdField_a_of_type_AndroidAppActivity = null;
    }
    for (;;)
    {
      if (this.jdField_a_of_type_AndroidViewView != null) {
        ((IVideoViewBase)this.jdField_a_of_type_AndroidViewView).removeViewCallBack(this.jdField_a_of_type_Aiob);
      }
      this.jdField_a_of_type_Aiqg.removeCallbacks(this.jdField_a_of_type_JavaLangRunnable);
      this.c = false;
      this.d = false;
      a(false);
      this.jdField_a_of_type_AndroidViewView = null;
      this.jdField_a_of_type_Boolean = false;
      this.jdField_a_of_type_Aiob.a();
      this.jdField_b_of_type_Boolean = false;
      this.jdField_a_of_type_Int = 0;
      this.jdField_a_of_type_Aiqo = paramaiqo;
      if ((this.jdField_a_of_type_Aiqo == null) || (paramView == null) || (paramView.getContext() == null)) {
        break;
      }
      if (QLog.isColorLevel()) {
        QLog.d("carverW VideoPlayController", 2, "onItemSelect no == " + this.jdField_a_of_type_Aiqo.hashCode() + " id=" + paramaiqo.jdField_a_of_type_Long);
      }
      this.jdField_a_of_type_AndroidAppActivity = ((Activity)paramView.getContext());
      a(this.jdField_a_of_type_Aiqo);
      return;
      a(paramView);
      this.jdField_a_of_type_AndroidWidgetFrameLayout = ((FrameLayout)paramView.findViewById(2131372260));
    }
  }
  
  public void a(AIOShortVideoData paramAIOShortVideoData, boolean paramBoolean1, boolean paramBoolean2)
  {
    if ((this.jdField_a_of_type_Aiqo != null) && (paramAIOShortVideoData.jdField_f_of_type_Long != this.jdField_a_of_type_Aiqo.jdField_a_of_type_Long)) {
      QLog.d("carverW VideoPlayController", 2, "onGetUrl data.id = " + paramAIOShortVideoData.jdField_f_of_type_Long + " mInfo,id=" + this.jdField_a_of_type_Aiqo.jdField_a_of_type_Long);
    }
    while (this.jdField_a_of_type_Aiqh == null) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("carverW VideoPlayController", 2, "onGetUrl data=" + paramAIOShortVideoData.jdField_f_of_type_Long + " isNeedShowCenterBtn=" + paramBoolean2 + " isStart=" + paramBoolean1);
    }
    aiqo localaiqo = new aiqo();
    localaiqo.jdField_a_of_type_Long = paramAIOShortVideoData.jdField_f_of_type_Long;
    localaiqo.jdField_b_of_type_Int = paramAIOShortVideoData.jdField_f_of_type_Int;
    this.jdField_a_of_type_Aiqh.a(localaiqo, paramBoolean1);
    if (paramBoolean2)
    {
      b(0);
      return;
    }
    b(8);
  }
  
  public abstract void a(boolean paramBoolean);
  
  public abstract boolean a();
  
  public long b()
  {
    return this.jdField_a_of_type_Aiob.c();
  }
  
  public void b()
  {
    if (this.jdField_a_of_type_Aiqo != null) {
      this.jdField_a_of_type_Aiqo.d = true;
    }
    b(8);
    a(8, "");
  }
  
  public abstract void b(int paramInt);
  
  public boolean b()
  {
    if (this.jdField_a_of_type_Int == 0) {
      g();
    }
    return this.jdField_a_of_type_Aiqo.jdField_a_of_type_Boolean;
  }
  
  public long c()
  {
    return this.jdField_a_of_type_Aiob.a();
  }
  
  public void c()
  {
    this.jdField_a_of_type_Boolean = true;
  }
  
  public void c(int paramInt)
  {
    this.jdField_a_of_type_Aiob.a(paramInt);
  }
  
  public boolean c()
  {
    if (this.jdField_a_of_type_Aiob != null) {
      return this.jdField_a_of_type_Aiob.b();
    }
    return false;
  }
  
  public long d()
  {
    return this.jdField_a_of_type_Aiob.d();
  }
  
  public void d() {}
  
  public void d(int paramInt)
  {
    if (this.jdField_a_of_type_Aiob != null) {
      this.jdField_a_of_type_Aiob.b(paramInt);
    }
  }
  
  public boolean d()
  {
    return (this.jdField_a_of_type_Aiob != null) && (this.jdField_a_of_type_Aiob.a());
  }
  
  public void e() {}
  
  public void f()
  {
    if (this.jdField_a_of_type_Aiqo == null) {
      if (QLog.isColorLevel()) {
        QLog.d("carverW VideoPlayController", 2, "onItemClick  onItemClick mCurInfo is null");
      }
    }
    do
    {
      return;
      this.c = true;
      if (QLog.isColorLevel()) {
        QLog.d("carverW VideoPlayController", 2, "onItemClick curState=" + this.jdField_a_of_type_Int + " no = " + this.jdField_a_of_type_Aiqo.hashCode() + " id=" + this.jdField_a_of_type_Aiqo.jdField_a_of_type_Long);
      }
      if (this.jdField_a_of_type_Int == 0)
      {
        if (QLog.isColorLevel()) {
          QLog.d("carverW VideoPlayController", 2, "onItemClick  isComplete=" + this.d);
        }
        if (this.d)
        {
          if (!this.jdField_a_of_type_Aiqo.jdField_b_of_type_Boolean) {
            g();
          }
          this.d = false;
        }
        a(true);
        return;
      }
      if (this.jdField_a_of_type_Int == 2)
      {
        a(true);
        return;
      }
      if (this.jdField_a_of_type_Int == 3)
      {
        m();
        return;
      }
      if (this.jdField_a_of_type_Int == 1)
      {
        h();
        this.jdField_a_of_type_Int = 4;
        return;
      }
    } while (this.jdField_a_of_type_Int != 4);
    m();
  }
  
  public void g()
  {
    if ((this.jdField_a_of_type_Aiob != null) && (this.jdField_a_of_type_Aiqo != null))
    {
      if (this.jdField_a_of_type_Aiqo.jdField_a_of_type_Boolean) {
        break label50;
      }
      if (this.jdField_a_of_type_Aiqo.jdField_a_of_type_JavaLangString != null) {
        this.jdField_a_of_type_Aiob.a(this.jdField_a_of_type_Aiqo.jdField_a_of_type_JavaLangString, 0L);
      }
    }
    return;
    label50:
    String str1;
    if (this.jdField_a_of_type_Aiqo.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo == null)
    {
      str1 = "0";
      if (this.jdField_a_of_type_Aiqo.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo != null) {
        break label124;
      }
    }
    label124:
    for (String str2 = "";; str2 = this.jdField_a_of_type_Aiqo.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo.md5)
    {
      this.jdField_a_of_type_Aiob.a(this.jdField_a_of_type_Aiqo.a(), str1, this.jdField_a_of_type_Aiqo.jdField_a_of_type_ArrayOfJavaLangString, 0L, str2, this.jdField_a_of_type_AndroidAppActivity);
      return;
      str1 = String.valueOf(this.jdField_a_of_type_Aiqo.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo.videoFileTime);
      break;
    }
  }
  
  public void h()
  {
    if (QLog.isColorLevel()) {
      QLog.d("carverW VideoPlayController", 2, "  play = Pasue ");
    }
    this.jdField_a_of_type_Int = 4;
    p();
  }
  
  public void i()
  {
    if (QLog.isColorLevel()) {
      QLog.d("carverW VideoPlayController", 2, " play = onPause ");
    }
    p();
  }
  
  public void j()
  {
    if (QLog.isColorLevel()) {
      QLog.d("carverW VideoPlayController", 2, "  play = onResume mVideoState=" + this.jdField_a_of_type_Int);
    }
    if ((this.jdField_b_of_type_Boolean) && (this.jdField_a_of_type_Int == 1))
    {
      a(true);
      if (this.jdField_a_of_type_AndroidAppActivity != null) {
        this.jdField_a_of_type_AndroidAppActivity.runOnUiThread(new VideoPlayController.3(this));
      }
    }
  }
  
  public void k()
  {
    if (QLog.isColorLevel()) {
      QLog.d("carverW VideoPlayController", 2, "  play = onDestory ");
    }
    this.jdField_a_of_type_Aiqo = null;
    if (this.jdField_a_of_type_Aiob != null)
    {
      this.jdField_a_of_type_Aiob.f();
      this.jdField_a_of_type_Aiob.a();
      this.jdField_a_of_type_Aiob = null;
    }
    this.jdField_b_of_type_Boolean = false;
    this.jdField_a_of_type_AndroidAppActivity = null;
    this.jdField_a_of_type_Aiqg.removeCallbacksAndMessages(null);
    this.jdField_a_of_type_Aiqg = null;
  }
  
  public void l() {}
  
  protected void m()
  {
    if ((bhtb.b()) && (!this.jdField_a_of_type_Aiqo.e) && (this.jdField_a_of_type_AndroidAppActivity != null))
    {
      Activity localActivity1 = this.jdField_a_of_type_AndroidAppActivity;
      Activity localActivity2 = this.jdField_a_of_type_AndroidAppActivity;
      ((AudioManager)localActivity1.getSystemService("audio")).requestAudioFocus(null, 3, 2);
    }
    this.jdField_a_of_type_Aiob.c();
    if (this.jdField_a_of_type_AndroidAppActivity != null) {
      this.jdField_a_of_type_AndroidAppActivity.runOnUiThread(new VideoPlayController.4(this));
    }
    this.jdField_a_of_type_Aiqg.postDelayed(this.jdField_a_of_type_JavaLangRunnable, 200L);
  }
  
  public void n()
  {
    if (this.jdField_a_of_type_Aiob != null) {
      this.jdField_a_of_type_Aiob.d();
    }
  }
  
  public void o()
  {
    if (this.jdField_a_of_type_Aiob != null) {
      this.jdField_a_of_type_Aiob.e();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aiqf
 * JD-Core Version:    0.7.0.1
 */