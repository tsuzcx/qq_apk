import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.media.AudioManager;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.gdtad.aditem.GdtAd;
import com.tencent.gdtad.api.motivevideo.GdtMotiveVideoPageData;
import com.tencent.gdtad.api.motivevideo.GdtMvViewController.6;
import com.tencent.gdtad.api.motivevideo.GdtMvViewController.8;
import com.tencent.gdtad.views.video.GdtVideoData;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.qphone.base.util.QLog;
import tencent.gdt.qq_ad_get.QQAdGetRsp.AdInfo;
import tencent.gdt.qq_ad_get.QQAdGetRsp.AdInfo.ExpInfo;

public class acsz
  implements acsx, Handler.Callback, View.OnClickListener, anfo
{
  public int a;
  private long jdField_a_of_type_Long;
  private acrq jdField_a_of_type_Acrq;
  private acrt jdField_a_of_type_Acrt;
  private acsg jdField_a_of_type_Acsg;
  private acss jdField_a_of_type_Acss;
  public final acsv a;
  public final acsw a;
  private acth jdField_a_of_type_Acth;
  private acti jdField_a_of_type_Acti;
  private actj jdField_a_of_type_Actj;
  private acxz jdField_a_of_type_Acxz;
  private Context jdField_a_of_type_AndroidContentContext;
  private AudioManager jdField_a_of_type_AndroidMediaAudioManager;
  private View jdField_a_of_type_AndroidViewView;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private RelativeLayout jdField_a_of_type_AndroidWidgetRelativeLayout;
  private anfp jdField_a_of_type_Anfp;
  private bhpc jdField_a_of_type_Bhpc;
  private blhq jdField_a_of_type_Blhq = new blhq(Looper.getMainLooper(), this);
  private String jdField_a_of_type_JavaLangString;
  public boolean a;
  private long jdField_b_of_type_Long = 15L;
  private boolean jdField_b_of_type_Boolean;
  private long jdField_c_of_type_Long;
  private boolean jdField_c_of_type_Boolean;
  private boolean d;
  private boolean e;
  private boolean f;
  private boolean g;
  private boolean h;
  private boolean i;
  private boolean j;
  private boolean k = true;
  private boolean l;
  private boolean m = true;
  
  public acsz(acti paramacti, acsg paramacsg, boolean paramBoolean)
  {
    this.jdField_a_of_type_Boolean = false;
    this.jdField_a_of_type_Int = 0;
    this.jdField_a_of_type_Acsw = new acsw();
    this.jdField_a_of_type_Acsv = new acsv();
    this.jdField_a_of_type_Acti = paramacti;
    this.jdField_a_of_type_Acsg = paramacsg;
    this.l = paramBoolean;
    paramacti = this.jdField_a_of_type_Acsg.a();
    paramacti.style = 0;
    paramBoolean = bool;
    if (paramacti.screenOrientation == 1) {
      paramBoolean = true;
    }
    this.jdField_b_of_type_Boolean = paramBoolean;
    int n = paramacti.getVideoCountDown();
    this.jdField_b_of_type_Long = n;
    this.jdField_a_of_type_JavaLangString = paramacti.getRewardText();
    paramBoolean = this.jdField_a_of_type_Acsg.a().exp_info.video_countdown_style.has();
    QLog.i("GdtMvViewController", 1, "GdtMvViewController: video_countdown = " + n + ", video_countdown_style has = " + paramBoolean + ", rewardText = " + this.jdField_a_of_type_JavaLangString);
  }
  
  private void A()
  {
    if ((this.jdField_a_of_type_Anfp == null) || (this.jdField_a_of_type_AndroidWidgetRelativeLayout == null)) {
      return;
    }
    GdtMotiveVideoPageData localGdtMotiveVideoPageData = this.jdField_a_of_type_Acsg.a();
    this.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(0);
    a(this.jdField_a_of_type_AndroidWidgetRelativeLayout);
    RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)this.jdField_a_of_type_AndroidWidgetRelativeLayout.getLayoutParams();
    int i2 = this.jdField_a_of_type_Anfp.a();
    int i3 = this.jdField_a_of_type_Anfp.b();
    int n;
    if (this.jdField_b_of_type_Boolean)
    {
      n = acwn.f(this.jdField_a_of_type_AndroidContentContext);
      label88:
      if (!this.jdField_b_of_type_Boolean) {
        break label289;
      }
    }
    label289:
    for (int i1 = acwn.e(this.jdField_a_of_type_AndroidContentContext);; i1 = acwn.f(this.jdField_a_of_type_AndroidContentContext))
    {
      QLog.i("GdtMvViewController", 1, "[VIDEO_PREPARED] mVideoSize " + this.jdField_b_of_type_Boolean + " vW-" + i2 + " vH-" + i3 + " sW-" + n + " sH-" + i1);
      if ((this.jdField_a_of_type_Acrq != null) || (!this.jdField_b_of_type_Boolean) || (localGdtMotiveVideoPageData.vSize == 585)) {
        break;
      }
      i2 = (int)(1.0F * n * i3 / i2);
      i1 = (int)(i1 * 150.0F / 1334.0F);
      localLayoutParams.height = i2;
      localLayoutParams.width = n;
      localLayoutParams.topMargin = i1;
      QLog.i("GdtMvViewController", 1, "[VIDEO_PREPARED] newHeight " + i2 + " newWidth-" + n + " newTop-" + i1);
      return;
      n = acwn.e(this.jdField_a_of_type_AndroidContentContext);
      break label88;
    }
  }
  
  private void B()
  {
    if (this.l)
    {
      j();
      l();
    }
  }
  
  private void C()
  {
    if (this.jdField_a_of_type_Acss != null) {
      this.jdField_a_of_type_Acss.b();
    }
  }
  
  private void D()
  {
    if (this.jdField_a_of_type_Blhq != null) {
      this.jdField_a_of_type_Blhq.post(new GdtMvViewController.8(this));
    }
  }
  
  private void a(int paramInt)
  {
    if (SystemClock.uptimeMillis() - this.jdField_c_of_type_Long < 800L) {}
    while ((paramInt == this.jdField_a_of_type_Int) || (this.jdField_a_of_type_Acss == null)) {
      return;
    }
    this.jdField_a_of_type_Int = paramInt;
    this.jdField_c_of_type_Long = SystemClock.uptimeMillis();
    this.jdField_a_of_type_Acss.a(paramInt);
  }
  
  private void a(int paramInt, boolean paramBoolean1, boolean paramBoolean2)
  {
    boolean bool = true;
    QLog.i("GdtMvViewController", 1, "setVoiceIconState volume =" + paramInt + " mVideoPlayer " + this.jdField_a_of_type_Anfp + " isFromVolumeChanged = " + paramBoolean2 + ", mIsMute = " + this.jdField_a_of_type_Boolean + ", viewResumed = " + paramBoolean1 + ", mIsVideoPlayCompleted = " + this.f);
    if ((!paramBoolean1) || (this.jdField_a_of_type_Anfp == null)) {}
    do
    {
      return;
      u();
    } while (this.f);
    if (!this.jdField_a_of_type_Boolean) {}
    for (paramBoolean1 = bool;; paramBoolean1 = false)
    {
      a(paramBoolean1);
      return;
    }
  }
  
  private void a(View paramView)
  {
    GdtVideoData localGdtVideoData = this.jdField_a_of_type_Acsg.a();
    if ((this.m) && (paramView != null))
    {
      this.m = false;
      paramView.setTag(2131381107, localGdtVideoData.getAd());
      paramView.setTag(2131381106, new actf(this));
      QLog.i("GdtMvViewController", 1, "initExpoReport");
      acvl.a().a(paramView);
      this.jdField_a_of_type_Acsv.a();
    }
  }
  
  private void a(GdtMotiveVideoPageData paramGdtMotiveVideoPageData, String paramString1, String paramString2, String paramString3)
  {
    acuz localacuz = (acuz)actr.a().a(16);
    if (localacuz != null) {
      localacuz.a(paramGdtMotiveVideoPageData, paramString1, paramString2, paramString3);
    }
  }
  
  private void a(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_AndroidMediaAudioManager != null)
    {
      if (paramBoolean)
      {
        QLog.i("GdtMvViewController", 1, "[requestSystemAudioFocus] gain is called!");
        this.jdField_a_of_type_AndroidMediaAudioManager.requestAudioFocus(null, 3, 2);
      }
    }
    else {
      return;
    }
    QLog.i("GdtMvViewController", 1, "[requestSystemAudioFocus] release is called!");
    this.jdField_a_of_type_AndroidMediaAudioManager.abandonAudioFocus(null);
  }
  
  private View b(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup)
  {
    for (;;)
    {
      try
      {
        GdtMotiveVideoPageData localGdtMotiveVideoPageData = this.jdField_a_of_type_Acsg.a();
        if (e()) {
          return c(paramLayoutInflater, paramViewGroup);
        }
        if (this.jdField_b_of_type_Boolean)
        {
          if (localGdtMotiveVideoPageData.vSize == 585)
          {
            this.jdField_a_of_type_AndroidViewView = paramLayoutInflater.inflate(2131559225, paramViewGroup, false);
            if (this.jdField_a_of_type_AndroidViewView != null) {
              break;
            }
            return null;
          }
          this.jdField_a_of_type_AndroidViewView = paramLayoutInflater.inflate(2131559224, paramViewGroup, false);
          continue;
        }
        this.jdField_a_of_type_AndroidViewView = paramLayoutInflater.inflate(2131559223, paramViewGroup, false);
      }
      catch (Exception paramLayoutInflater)
      {
        QLog.e("GdtMvViewController", 1, " viewcontr initViews error", paramLayoutInflater);
        return null;
      }
    }
    this.jdField_a_of_type_Acss = new acss(this, this.jdField_a_of_type_AndroidViewView, this.jdField_a_of_type_Acsg);
    this.jdField_a_of_type_Acss.a(this.jdField_a_of_type_Acsv);
    acwn.a(this.jdField_a_of_type_AndroidViewView.findViewById(2131371835));
    this.jdField_a_of_type_Acss.a();
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131362102));
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)this.jdField_a_of_type_AndroidViewView.findViewById(2131380860));
    this.jdField_a_of_type_AndroidWidgetRelativeLayout.setOnClickListener(this);
    return this.jdField_a_of_type_AndroidViewView;
  }
  
  private void b(boolean paramBoolean)
  {
    if ((this.jdField_a_of_type_Acss != null) && (paramBoolean)) {
      this.jdField_a_of_type_Acss.c();
    }
  }
  
  private View c(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup)
  {
    this.jdField_a_of_type_AndroidViewView = paramLayoutInflater.inflate(2131559227, paramViewGroup, false);
    if (this.jdField_a_of_type_AndroidViewView == null) {
      return null;
    }
    this.jdField_a_of_type_Acrq = new acrq(this, this.jdField_a_of_type_AndroidViewView, this.jdField_a_of_type_Acsg);
    this.jdField_a_of_type_Acrq.a(this.jdField_a_of_type_Acti.a(), this.jdField_a_of_type_Acsw);
    this.jdField_a_of_type_Acrq.a(this.jdField_a_of_type_Acsv);
    acwn.a(this.jdField_a_of_type_AndroidViewView.findViewById(2131371835));
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131362102));
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)this.jdField_a_of_type_AndroidViewView.findViewById(2131380860));
    return this.jdField_a_of_type_AndroidViewView;
  }
  
  private boolean e()
  {
    for (;;)
    {
      int n;
      boolean bool1;
      try
      {
        if ((this.jdField_a_of_type_Acsg == null) || (this.jdField_a_of_type_Acsg.a() == null) || (this.jdField_a_of_type_Acsg.a() == null))
        {
          QLog.i("GdtMvViewController", 1, "isCellingStyle null");
          return false;
        }
        bool2 = this.jdField_a_of_type_Acsg.a().isMvCellingStyle();
        bool3 = this.jdField_a_of_type_Acsg.a().isXiJinDestType();
        i1 = this.jdField_a_of_type_Acsg.a().vSize;
        if (i1 == 585) {
          break label201;
        }
        if (i1 != 185) {
          break label191;
        }
      }
      catch (Exception localException)
      {
        boolean bool2;
        boolean bool3;
        int i1;
        QLog.i("GdtMvViewController", 1, "isCellingStyle", localException);
        return false;
      }
      if ((this.jdField_b_of_type_Boolean) && (bool2) && (bool3) && (n != 0))
      {
        bool1 = true;
        QLog.i("GdtMvViewController", 1, "isCellingStyle" + " result=" + bool1 + ",isMvCellingStyle=" + bool2 + ",isXiJinDestType=" + bool3 + ",vSize=" + i1);
        return bool1;
        label191:
        n = 0;
      }
      else
      {
        bool1 = false;
        continue;
        label201:
        n = 1;
      }
    }
  }
  
  private void p()
  {
    if (this.jdField_a_of_type_AndroidMediaAudioManager != null) {
      if (this.jdField_a_of_type_AndroidMediaAudioManager.getRingerMode() == 2) {
        break label104;
      }
    }
    label104:
    for (boolean bool = true;; bool = false)
    {
      this.j = bool;
      this.jdField_a_of_type_Acth = new acth(this, null);
      IntentFilter localIntentFilter = new IntentFilter();
      localIntentFilter.addAction("android.media.RINGER_MODE_CHANGED");
      this.jdField_a_of_type_AndroidContentContext.registerReceiver(this.jdField_a_of_type_Acth, localIntentFilter);
      this.jdField_a_of_type_Actj = new actj(this.jdField_a_of_type_AndroidContentContext);
      this.jdField_a_of_type_Actj.a();
      this.jdField_a_of_type_Actj.a(new acta(this));
      return;
    }
  }
  
  private void q()
  {
    if ((this.jdField_a_of_type_Acss != null) || (this.jdField_a_of_type_Acrq != null))
    {
      this.jdField_a_of_type_Acxz = new acxz(11);
      return;
    }
    QLog.i("GdtMvViewController", 1, " initReports error");
  }
  
  private void r()
  {
    this.jdField_a_of_type_Acrt = new acrt();
    this.jdField_a_of_type_Acrt.a(this.jdField_a_of_type_Acsg, this.jdField_a_of_type_AndroidViewView, this.jdField_a_of_type_Acti.a(), this.jdField_b_of_type_Boolean);
  }
  
  private void s()
  {
    this.jdField_a_of_type_Bhpc = bhlq.a(this.jdField_a_of_type_AndroidViewView.getContext(), 0, null, "", anzj.a(2131704112), anzj.a(2131704109), new actb(this), new actc(this));
    this.jdField_a_of_type_Bhpc.setOnKeyListener(new actd(this));
  }
  
  private void t()
  {
    if (this.j)
    {
      QLog.i("GdtMvViewController", 1, "refreshVoiceIconDrawable isSilentMode is true");
      this.jdField_a_of_type_Boolean = true;
    }
    u();
  }
  
  private void u()
  {
    this.jdField_a_of_type_Acsw.a(this.jdField_a_of_type_AndroidViewView.getContext(), this.jdField_a_of_type_Boolean);
  }
  
  private void v()
  {
    Object localObject = this.jdField_a_of_type_Acsg.a();
    URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
    localURLDrawableOptions.mLoadingDrawable = this.jdField_a_of_type_AndroidViewView.getResources().getDrawable(2130850680);
    localURLDrawableOptions.mFailedDrawable = this.jdField_a_of_type_AndroidViewView.getResources().getDrawable(2130850680);
    localObject = URLDrawable.getDrawable(((GdtMotiveVideoPageData)localObject).previewImgUrl, localURLDrawableOptions);
    ((URLDrawable)localObject).setDecodeHandler(bhez.n);
    ((URLDrawable)localObject).setTag(new int[] { 50 });
    if (this.jdField_a_of_type_AndroidWidgetImageView != null) {
      this.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable((Drawable)localObject);
    }
  }
  
  private void w()
  {
    QLog.i("VideoGdtGdtMvViewController", 1, "initVideoView");
    GdtMotiveVideoPageData localGdtMotiveVideoPageData = this.jdField_a_of_type_Acsg.a();
    this.jdField_a_of_type_Anfp = new anfe();
    this.jdField_a_of_type_Anfp.a(this.jdField_a_of_type_AndroidViewView.getContext(), anbd.a());
    this.jdField_a_of_type_Anfp.a(this, 100L);
    View localView = this.jdField_a_of_type_Anfp.a();
    if ((localView == null) || (this.jdField_a_of_type_AndroidWidgetRelativeLayout == null))
    {
      QLog.i("VideoGdtGdtMvViewController", 1, "[setViewStatus], videoView is null." + this.jdField_a_of_type_AndroidWidgetRelativeLayout);
      return;
    }
    RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-1, -1);
    this.jdField_a_of_type_AndroidWidgetRelativeLayout.addView(localView, localLayoutParams);
    this.jdField_a_of_type_Anfp.a(localGdtMotiveVideoPageData.url, "sd", 0);
  }
  
  private void x()
  {
    if (bapg.a())
    {
      w();
      return;
    }
    y();
  }
  
  private void y()
  {
    try
    {
      QLog.i("VideoGdtGdtMvViewController", 1, "installSDK");
      bapg.a(BaseApplicationImpl.getApplication(), new acte(this));
      return;
    }
    catch (Throwable localThrowable)
    {
      QLog.e("VideoGdtGdtMvViewController", 1, "installSDK", localThrowable);
    }
  }
  
  private void z()
  {
    QLog.i("GdtMvViewController", 1, "[doPauseAction] mIsVideoPlayCompleted:" + this.f);
    GdtVideoData localGdtVideoData = this.jdField_a_of_type_Acsg.a();
    a(false);
    if ((!this.f) && (this.jdField_a_of_type_Anfp != null))
    {
      this.h = false;
      this.jdField_a_of_type_Anfp.b();
      if ((this.jdField_a_of_type_Acxz != null) && (localGdtVideoData != null)) {
        this.jdField_a_of_type_Acxz.b(localGdtVideoData, this.jdField_a_of_type_Anfp.b());
      }
    }
    if (this.jdField_a_of_type_Acrt != null) {
      this.jdField_a_of_type_Acrt.c();
    }
    acuv.a();
  }
  
  long a()
  {
    if (this.jdField_a_of_type_Anfp != null)
    {
      if (this.f) {
        return this.jdField_a_of_type_Long;
      }
      return this.jdField_a_of_type_Anfp.b();
    }
    return 0L;
  }
  
  public acti a()
  {
    return this.jdField_a_of_type_Acti;
  }
  
  public View a(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup)
  {
    paramLayoutInflater = b(paramLayoutInflater, paramViewGroup);
    if (paramLayoutInflater == null)
    {
      QLog.i("GdtMvViewController", 1, "GdtMvViewController init:rootView==null error");
      return null;
    }
    this.jdField_a_of_type_AndroidContentContext = paramLayoutInflater.getContext();
    QLog.i("GdtMvViewController", 1, "GdtMvViewController: init = " + this.l + ", mContext = " + this.jdField_a_of_type_AndroidContentContext);
    this.jdField_a_of_type_AndroidMediaAudioManager = ((AudioManager)this.jdField_a_of_type_AndroidContentContext.getSystemService("audio"));
    if (((this.jdField_a_of_type_AndroidContentContext instanceof Activity)) && (!this.l)) {
      ((Activity)this.jdField_a_of_type_AndroidContentContext).setVolumeControlStream(3);
    }
    p();
    t();
    c();
    v();
    x();
    C();
    s();
    q();
    r();
    this.jdField_a_of_type_Acsv.a(this.jdField_a_of_type_Acsg);
    return paramLayoutInflater;
  }
  
  public void a()
  {
    QLog.i("GdtMvViewController", 1, " onClick close_ads");
    if (!d())
    {
      this.jdField_a_of_type_Acsv.a(4, a());
      this.jdField_a_of_type_Acti.a();
    }
  }
  
  public void a(int paramInt1, int paramInt2, String paramString)
  {
    QLog.i("GdtMvViewController", 1, "[onVideoError], result:" + paramInt1 + ",code:" + paramInt2 + ",msg:" + paramString);
    paramString = this.jdField_a_of_type_Acsg.a();
    if ((this.jdField_a_of_type_Acxz != null) && (paramString != null)) {
      this.jdField_a_of_type_Acxz.a(paramString);
    }
  }
  
  public void a(long paramLong1, long paramLong2)
  {
    GdtVideoData localGdtVideoData = this.jdField_a_of_type_Acsg.a();
    if (Looper.myLooper() != Looper.getMainLooper()) {
      this.jdField_a_of_type_Blhq.post(new GdtMvViewController.6(this, paramLong1, paramLong2));
    }
    while (this.f) {
      return;
    }
    boolean bool;
    label60:
    long l3;
    if (paramLong2 < this.jdField_b_of_type_Long * 1000L)
    {
      bool = true;
      this.g = bool;
      l3 = paramLong2 - paramLong1;
      if (!this.g) {
        break label258;
      }
    }
    label258:
    for (paramLong2 = paramLong1;; paramLong2 = this.jdField_b_of_type_Long * 1000L - l3)
    {
      long l2 = paramLong2 / 1000L + 1L;
      long l1 = l2;
      if (l2 > this.jdField_b_of_type_Long) {
        l1 = this.jdField_b_of_type_Long;
      }
      b(paramLong2, l1);
      if (paramLong2 <= 0L) {
        this.jdField_c_of_type_Boolean = true;
      }
      if (l3 / 1000L == 2L) {
        b(true);
      }
      if (paramLong1 / 1000L == 3L) {
        b(false);
      }
      if ((!this.h) && (this.jdField_a_of_type_Acxz != null) && (this.jdField_a_of_type_Anfp != null) && (localGdtVideoData != null))
      {
        this.h = true;
        this.jdField_a_of_type_Acxz.a(localGdtVideoData, this.jdField_a_of_type_Anfp.b());
      }
      if ((this.jdField_a_of_type_Acrt == null) || (this.jdField_a_of_type_Anfp == null)) {
        break;
      }
      this.jdField_a_of_type_Acrt.a(this.jdField_a_of_type_Anfp.a() - this.jdField_a_of_type_Anfp.b());
      return;
      bool = false;
      break label60;
    }
  }
  
  public void a(String paramString)
  {
    GdtMotiveVideoPageData localGdtMotiveVideoPageData = this.jdField_a_of_type_Acsg.a();
    QLog.i("GdtMvViewController", 1, "GDT beforeFinish call stack:", new Throwable());
    Intent localIntent = new Intent();
    localIntent.putExtra("duration_time", this.jdField_a_of_type_Long);
    localIntent.putExtra("elapsed_time", this.jdField_a_of_type_Long);
    localIntent.putExtra("profitable_flag", this.jdField_c_of_type_Boolean);
    localIntent.putExtra("is_end", this.f);
    if (this.f)
    {
      a(localGdtMotiveVideoPageData, String.valueOf(this.jdField_a_of_type_Long), String.valueOf(this.jdField_a_of_type_Long), String.valueOf(this.f));
      QLog.i("GdtMvViewController", 1, "true[beforeFinish] " + this.jdField_a_of_type_Long + " /" + this.jdField_a_of_type_Long);
    }
    for (;;)
    {
      if (!TextUtils.isEmpty(paramString)) {
        localIntent.putExtra("arg_callback", paramString);
      }
      this.jdField_a_of_type_Acti.a(-1, localIntent);
      B();
      return;
      if (this.jdField_a_of_type_Anfp != null)
      {
        localIntent.putExtra("elapsed_time", this.jdField_a_of_type_Anfp.b());
        a(localGdtMotiveVideoPageData, String.valueOf(this.jdField_a_of_type_Anfp.b()), String.valueOf(this.jdField_a_of_type_Long), String.valueOf(this.f));
        QLog.i("GdtMvViewController", 1, this.jdField_c_of_type_Boolean + "[beforeFinish] " + this.jdField_a_of_type_Anfp.b() + " /" + this.jdField_a_of_type_Long);
      }
    }
  }
  
  boolean a()
  {
    return this.jdField_a_of_type_Acsw.a();
  }
  
  public void b()
  {
    if (this.jdField_a_of_type_Anfp == null) {
      return;
    }
    this.jdField_a_of_type_Acsv.a(7, a());
    boolean bool2 = this.jdField_a_of_type_Anfp.a();
    boolean bool1;
    if (!bool2)
    {
      bool1 = true;
      this.jdField_a_of_type_Boolean = bool1;
      QLog.i("GdtMvViewController", 1, "audioSwitch click is called isSilentMode = " + this.j + ", isMute = " + bool2);
      this.jdField_a_of_type_Anfp.a(this.jdField_a_of_type_Boolean);
      if (!this.jdField_a_of_type_Boolean) {
        break label116;
      }
    }
    label116:
    for (int n = 0;; n = 1)
    {
      a(n, true, false);
      return;
      bool1 = false;
      break;
    }
  }
  
  protected void b(long paramLong1, long paramLong2)
  {
    this.jdField_a_of_type_Acsw.a(paramLong1, paramLong2);
  }
  
  boolean b()
  {
    return this.f;
  }
  
  public void c()
  {
    this.jdField_a_of_type_Acsw.a(this.jdField_a_of_type_AndroidViewView, this, this.jdField_a_of_type_Acsg, this.jdField_a_of_type_Acsv);
    if (this.jdField_a_of_type_Acrq != null)
    {
      this.jdField_a_of_type_Acrq.a(this.jdField_a_of_type_Acti.a(), this.jdField_b_of_type_Boolean);
      return;
    }
    this.jdField_a_of_type_Acsw.a(this.jdField_a_of_type_Acti.a(), this.jdField_b_of_type_Boolean);
  }
  
  public boolean c()
  {
    if ((this.jdField_a_of_type_Acrq != null) && (this.jdField_a_of_type_Acrq.a())) {}
    while ((this.jdField_a_of_type_Acrt != null) && (this.jdField_a_of_type_Acrt.a())) {
      return true;
    }
    return d();
  }
  
  protected void d()
  {
    if ((this.jdField_a_of_type_Anfp != null) && (!this.jdField_a_of_type_Anfp.d()))
    {
      this.d = true;
      z();
    }
  }
  
  public boolean d()
  {
    QLog.i("GdtMvViewController", 1, "[onBackEvent] mHasWatchAds " + this.jdField_c_of_type_Boolean);
    for (;;)
    {
      try
      {
        if (this.jdField_c_of_type_Boolean) {
          return false;
        }
        d();
        if ((this.jdField_a_of_type_Bhpc == null) || (this.jdField_a_of_type_Bhpc.isShowing())) {
          break;
        }
        QLog.i("GdtMvViewController", 1, "showDialog mVideoDuration " + this.jdField_a_of_type_Long + " mShotSeconds " + this.jdField_b_of_type_Long + " mRewardText " + this.jdField_a_of_type_JavaLangString);
        Object localObject = new StringBuffer(anzj.a(2131692611));
        if (TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString))
        {
          ((StringBuffer)localObject).append(anzj.a(2131692607));
          bhpc localbhpc = this.jdField_a_of_type_Bhpc;
          if (this.jdField_a_of_type_Long > this.jdField_b_of_type_Long * 1000L)
          {
            localObject = anzj.a(2131704107) + this.jdField_b_of_type_Long + ((StringBuffer)localObject).toString();
            localbhpc.setMessage((CharSequence)localObject);
            this.jdField_a_of_type_Bhpc.show();
            localObject = this.jdField_a_of_type_Bhpc.getWindow();
            if (localObject == null) {
              break;
            }
            ((Window)localObject).getDecorView().setSystemUiVisibility(7942);
            break;
          }
        }
        else
        {
          ((StringBuffer)localObject).append(this.jdField_a_of_type_JavaLangString);
          continue;
        }
        String str = anzj.a(2131704108);
      }
      catch (Throwable localThrowable)
      {
        QLog.e("GdtMvViewController", 1, "show dialog err, errInfo->" + localThrowable.getMessage());
        return false;
      }
    }
    return true;
  }
  
  public void e()
  {
    QLog.i("GdtMvViewController", 1, "[onVideoPrepared]");
    if (!this.e)
    {
      this.e = true;
      if (this.jdField_a_of_type_Blhq != null)
      {
        QLog.i("GdtMvViewController", 1, "[onVideoPrepared] send PREPARED msg");
        this.jdField_a_of_type_Blhq.obtainMessage(1).sendToTarget();
      }
    }
    while ((this.d) || (this.jdField_a_of_type_Anfp == null) || (this.jdField_a_of_type_Anfp.c())) {
      return;
    }
    QLog.i("GdtMvViewController", 1, "[onVideoPrepared] resume VideoPlayer again");
    f();
  }
  
  public void f()
  {
    if ((this.i) && (this.jdField_a_of_type_Anfp != null))
    {
      this.jdField_a_of_type_Anfp.a();
      if (this.jdField_a_of_type_Boolean) {
        break label42;
      }
    }
    label42:
    for (boolean bool = true;; bool = false)
    {
      a(bool);
      u();
      return;
    }
  }
  
  public void g()
  {
    QLog.i("GdtMvViewController", 1, "[onVideoCompletion]");
    GdtVideoData localGdtVideoData = this.jdField_a_of_type_Acsg.a();
    this.e = false;
    this.f = true;
    this.jdField_c_of_type_Boolean = true;
    if (this.jdField_a_of_type_Blhq != null) {
      this.jdField_a_of_type_Blhq.obtainMessage(2).sendToTarget();
    }
    if ((this.jdField_a_of_type_Acxz != null) && (localGdtVideoData != null)) {
      this.jdField_a_of_type_Acxz.b(localGdtVideoData);
    }
  }
  
  public void h()
  {
    QLog.i("GdtMvViewController", 1, "[onVideoBufferStart]");
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    default: 
    case 1: 
      do
      {
        do
        {
          return false;
        } while (this.jdField_a_of_type_Anfp == null);
        A();
      } while (this.jdField_a_of_type_Anfp == null);
      paramMessage = this.jdField_a_of_type_Anfp;
      if ((this.jdField_a_of_type_Boolean) || (this.j)) {}
      for (boolean bool = true;; bool = false)
      {
        paramMessage.a(bool);
        this.jdField_a_of_type_Long = this.jdField_a_of_type_Anfp.a();
        QLog.i("GdtMvViewController", 1, "[mDuration]" + this.jdField_a_of_type_Long + ", mIsMute = " + this.jdField_a_of_type_Boolean + ", isSilentMode = " + this.j);
        this.jdField_a_of_type_Acsg.a().setDurationMillis(this.jdField_a_of_type_Long);
        f();
        return false;
      }
    case 2: 
      QLog.i("GdtMvViewController", 1, "[onVideoCompletion]");
      if (this.jdField_a_of_type_Anfp != null) {
        this.jdField_a_of_type_Anfp.b(this);
      }
      b(0L, 0L);
      a(false);
      n();
      return false;
    }
    QLog.i("GdtMvViewController", 1, "[VIDEO_SDK_INSTALLED] initVideoView");
    w();
    return false;
  }
  
  public void i()
  {
    QLog.i("GdtMvViewController", 1, "[onVideoBufferEnd]");
  }
  
  public void j()
  {
    this.i = false;
    z();
  }
  
  public void k()
  {
    this.i = true;
    QLog.i("GdtMvViewController", 1, "[onResume]" + this.d + " mIsVideoPlayCompleted " + this.f);
    if ((!this.d) && (!this.f) && (this.e)) {
      f();
    }
    if (this.jdField_a_of_type_Acss != null) {
      this.jdField_a_of_type_Acss.g();
    }
    if (this.jdField_a_of_type_Acrt != null) {
      this.jdField_a_of_type_Acrt.b();
    }
    acuv.a(new actg(this, null));
  }
  
  public void l()
  {
    QLog.i("GdtMvViewController", 1, "[onDestroy]");
    if (this.jdField_a_of_type_Blhq != null) {
      this.jdField_a_of_type_Blhq.removeCallbacksAndMessages(null);
    }
    if (this.jdField_a_of_type_Actj != null) {
      this.jdField_a_of_type_Actj.b();
    }
    if (this.jdField_a_of_type_Anfp != null)
    {
      this.jdField_a_of_type_Anfp.b(this);
      this.jdField_a_of_type_Anfp.b();
      this.jdField_a_of_type_Anfp = null;
    }
    if (this.jdField_a_of_type_Acss != null)
    {
      this.jdField_a_of_type_Acss.e();
      this.jdField_a_of_type_Acss = null;
    }
    if (this.jdField_a_of_type_Acrt != null) {
      this.jdField_a_of_type_Acrt.a(this.jdField_a_of_type_Acti.a(), this.l);
    }
    if (this.jdField_a_of_type_Acxz != null) {
      this.jdField_a_of_type_Acxz = null;
    }
    if ((this.jdField_a_of_type_AndroidContentContext != null) && (this.jdField_a_of_type_Acth != null)) {
      this.jdField_a_of_type_AndroidContentContext.unregisterReceiver(this.jdField_a_of_type_Acth);
    }
    this.jdField_a_of_type_AndroidContentContext = null;
    acvl.a().a();
    bjfr.a(BaseApplicationImpl.getApplication().getApplicationContext(), true, 55);
  }
  
  public void m()
  {
    QLog.i("GdtMvViewController", 1, "[onCreate]");
    bjfr.a(BaseApplicationImpl.getApplication().getApplicationContext(), false, 55);
  }
  
  protected void n()
  {
    if (this.jdField_a_of_type_Acrq != null) {
      this.jdField_a_of_type_Acrq.b();
    }
    do
    {
      return;
      a(1);
    } while (this.jdField_a_of_type_Acrt == null);
    this.jdField_a_of_type_Acrt.a(this.jdField_a_of_type_Acti.a(), this.jdField_a_of_type_Acsg, this.jdField_b_of_type_Boolean);
  }
  
  public void o()
  {
    a("");
  }
  
  public void onClick(View paramView) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     acsz
 * JD-Core Version:    0.7.0.1
 */