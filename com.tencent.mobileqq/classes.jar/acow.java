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

public class acow
  implements acou, amtu, Handler.Callback, View.OnClickListener
{
  public int a;
  private long jdField_a_of_type_Long;
  private acno jdField_a_of_type_Acno;
  private acnr jdField_a_of_type_Acnr;
  private acoe jdField_a_of_type_Acoe;
  private acoq jdField_a_of_type_Acoq;
  public final acot a;
  private acpe jdField_a_of_type_Acpe;
  private acpf jdField_a_of_type_Acpf;
  private acpg jdField_a_of_type_Acpg;
  private actv jdField_a_of_type_Actv;
  private amtv jdField_a_of_type_Amtv;
  private Context jdField_a_of_type_AndroidContentContext;
  private AudioManager jdField_a_of_type_AndroidMediaAudioManager;
  private View jdField_a_of_type_AndroidViewView;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private RelativeLayout jdField_a_of_type_AndroidWidgetRelativeLayout;
  private bgpa jdField_a_of_type_Bgpa;
  private bkgm jdField_a_of_type_Bkgm = new bkgm(Looper.getMainLooper(), this);
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
  
  public acow(acpf paramacpf, acoe paramacoe, boolean paramBoolean)
  {
    this.jdField_a_of_type_Boolean = false;
    this.jdField_a_of_type_Int = 0;
    this.jdField_a_of_type_Acot = new acot();
    this.jdField_a_of_type_Acpf = paramacpf;
    this.jdField_a_of_type_Acoe = paramacoe;
    this.l = paramBoolean;
    paramacpf = this.jdField_a_of_type_Acoe.a();
    paramacpf.style = 0;
    paramBoolean = bool;
    if (paramacpf.screenOrientation == 1) {
      paramBoolean = true;
    }
    this.jdField_b_of_type_Boolean = paramBoolean;
    int n = paramacpf.getVideoCountDown();
    this.jdField_b_of_type_Long = n;
    this.jdField_a_of_type_JavaLangString = paramacpf.getRewardText();
    paramBoolean = this.jdField_a_of_type_Acoe.a().exp_info.video_countdown_style.has();
    QLog.i("GdtMvViewController", 1, "GdtMvViewController: video_countdown = " + n + ", video_countdown_style has = " + paramBoolean + ", rewardText = " + this.jdField_a_of_type_JavaLangString);
  }
  
  private void A()
  {
    if ((this.jdField_a_of_type_Amtv == null) || (this.jdField_a_of_type_AndroidWidgetRelativeLayout == null)) {
      return;
    }
    GdtMotiveVideoPageData localGdtMotiveVideoPageData = this.jdField_a_of_type_Acoe.a();
    this.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(0);
    a(this.jdField_a_of_type_AndroidWidgetRelativeLayout);
    RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)this.jdField_a_of_type_AndroidWidgetRelativeLayout.getLayoutParams();
    int i2 = this.jdField_a_of_type_Amtv.a();
    int i3 = this.jdField_a_of_type_Amtv.b();
    int n;
    if (this.jdField_b_of_type_Boolean)
    {
      n = acsj.f(this.jdField_a_of_type_AndroidContentContext);
      label88:
      if (!this.jdField_b_of_type_Boolean) {
        break label289;
      }
    }
    label289:
    for (int i1 = acsj.e(this.jdField_a_of_type_AndroidContentContext);; i1 = acsj.f(this.jdField_a_of_type_AndroidContentContext))
    {
      QLog.i("GdtMvViewController", 1, "[VIDEO_PREPARED] mVideoSize " + this.jdField_b_of_type_Boolean + " vW-" + i2 + " vH-" + i3 + " sW-" + n + " sH-" + i1);
      if ((this.jdField_a_of_type_Acno != null) || (!this.jdField_b_of_type_Boolean) || (localGdtMotiveVideoPageData.vSize == 585)) {
        break;
      }
      i2 = (int)(1.0F * n * i3 / i2);
      i1 = (int)(i1 * 150.0F / 1334.0F);
      localLayoutParams.height = i2;
      localLayoutParams.width = n;
      localLayoutParams.topMargin = i1;
      QLog.i("GdtMvViewController", 1, "[VIDEO_PREPARED] newHeight " + i2 + " newWidth-" + n + " newTop-" + i1);
      return;
      n = acsj.e(this.jdField_a_of_type_AndroidContentContext);
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
    if (this.jdField_a_of_type_Acoq != null) {
      this.jdField_a_of_type_Acoq.b();
    }
  }
  
  private void D()
  {
    if (this.jdField_a_of_type_Bkgm != null) {
      this.jdField_a_of_type_Bkgm.post(new GdtMvViewController.8(this));
    }
  }
  
  private void a(int paramInt)
  {
    if (SystemClock.uptimeMillis() - this.jdField_c_of_type_Long < 800L) {}
    while ((paramInt == this.jdField_a_of_type_Int) || (this.jdField_a_of_type_Acoq == null)) {
      return;
    }
    this.jdField_a_of_type_Int = paramInt;
    this.jdField_c_of_type_Long = SystemClock.uptimeMillis();
    this.jdField_a_of_type_Acoq.a(paramInt);
  }
  
  private void a(int paramInt, boolean paramBoolean1, boolean paramBoolean2)
  {
    boolean bool = true;
    QLog.i("GdtMvViewController", 1, "setVoiceIconState volume =" + paramInt + " mVideoPlayer " + this.jdField_a_of_type_Amtv + " isFromVolumeChanged = " + paramBoolean2 + ", mIsMute = " + this.jdField_a_of_type_Boolean + ", viewResumed = " + paramBoolean1 + ", mIsVideoPlayCompleted = " + this.f);
    if ((!paramBoolean1) || (this.jdField_a_of_type_Amtv == null)) {}
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
    GdtVideoData localGdtVideoData = this.jdField_a_of_type_Acoe.a();
    if ((this.m) && (paramView != null))
    {
      this.m = false;
      paramView.setTag(2131380927, localGdtVideoData.getAd());
      paramView.setTag(2131380926, new acpc(this));
      QLog.i("GdtMvViewController", 1, "initExpoReport");
      acrh.a().a(paramView);
    }
  }
  
  private void a(GdtMotiveVideoPageData paramGdtMotiveVideoPageData, String paramString1, String paramString2, String paramString3)
  {
    acqv localacqv = (acqv)acpo.a().a(16);
    if (localacqv != null) {
      localacqv.a(paramGdtMotiveVideoPageData, paramString1, paramString2, paramString3);
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
        GdtMotiveVideoPageData localGdtMotiveVideoPageData = this.jdField_a_of_type_Acoe.a();
        if (e()) {
          return c(paramLayoutInflater, paramViewGroup);
        }
        if (this.jdField_b_of_type_Boolean)
        {
          if (localGdtMotiveVideoPageData.vSize == 585)
          {
            this.jdField_a_of_type_AndroidViewView = paramLayoutInflater.inflate(2131559226, paramViewGroup, false);
            if (this.jdField_a_of_type_AndroidViewView != null) {
              break;
            }
            return null;
          }
          this.jdField_a_of_type_AndroidViewView = paramLayoutInflater.inflate(2131559225, paramViewGroup, false);
          continue;
        }
        this.jdField_a_of_type_AndroidViewView = paramLayoutInflater.inflate(2131559224, paramViewGroup, false);
      }
      catch (Exception paramLayoutInflater)
      {
        QLog.e("GdtMvViewController", 1, " viewcontr initViews error", paramLayoutInflater);
        return null;
      }
    }
    this.jdField_a_of_type_Acoq = new acoq(this, this.jdField_a_of_type_AndroidViewView, this.jdField_a_of_type_Acoe);
    acsj.a(this.jdField_a_of_type_AndroidViewView.findViewById(2131371728));
    this.jdField_a_of_type_Acoq.a();
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131362097));
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)this.jdField_a_of_type_AndroidViewView.findViewById(2131380682));
    this.jdField_a_of_type_AndroidWidgetRelativeLayout.setOnClickListener(this);
    return this.jdField_a_of_type_AndroidViewView;
  }
  
  private void b(boolean paramBoolean)
  {
    if ((this.jdField_a_of_type_Acoq != null) && (paramBoolean)) {
      this.jdField_a_of_type_Acoq.c();
    }
  }
  
  private View c(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup)
  {
    this.jdField_a_of_type_AndroidViewView = paramLayoutInflater.inflate(2131559228, paramViewGroup, false);
    if (this.jdField_a_of_type_AndroidViewView == null) {
      return null;
    }
    this.jdField_a_of_type_Acno = new acno(this, this.jdField_a_of_type_AndroidViewView, this.jdField_a_of_type_Acoe);
    this.jdField_a_of_type_Acno.a(this.jdField_a_of_type_Acpf.a(), this.jdField_a_of_type_Acot);
    acsj.a(this.jdField_a_of_type_AndroidViewView.findViewById(2131371728));
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131362097));
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)this.jdField_a_of_type_AndroidViewView.findViewById(2131380682));
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
        if ((this.jdField_a_of_type_Acoe == null) || (this.jdField_a_of_type_Acoe.a() == null) || (this.jdField_a_of_type_Acoe.a() == null))
        {
          QLog.i("GdtMvViewController", 1, "isCellingStyle null");
          return false;
        }
        bool2 = this.jdField_a_of_type_Acoe.a().isMvCellingStyle();
        bool3 = this.jdField_a_of_type_Acoe.a().isXiJinDestType();
        i1 = this.jdField_a_of_type_Acoe.a().vSize;
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
      this.jdField_a_of_type_Acpe = new acpe(this, null);
      IntentFilter localIntentFilter = new IntentFilter();
      localIntentFilter.addAction("android.media.RINGER_MODE_CHANGED");
      this.jdField_a_of_type_AndroidContentContext.registerReceiver(this.jdField_a_of_type_Acpe, localIntentFilter);
      this.jdField_a_of_type_Acpg = new acpg(this.jdField_a_of_type_AndroidContentContext);
      this.jdField_a_of_type_Acpg.a();
      this.jdField_a_of_type_Acpg.a(new acox(this));
      return;
    }
  }
  
  private void q()
  {
    if ((this.jdField_a_of_type_Acoq != null) || (this.jdField_a_of_type_Acno != null))
    {
      this.jdField_a_of_type_Actv = new actv(11);
      return;
    }
    QLog.i("GdtMvViewController", 1, " initReports error");
  }
  
  private void r()
  {
    this.jdField_a_of_type_Acnr = new acnr();
    this.jdField_a_of_type_Acnr.a(this.jdField_a_of_type_Acoe, this.jdField_a_of_type_AndroidViewView, this.jdField_a_of_type_Acpf.a(), this.jdField_b_of_type_Boolean);
  }
  
  private void s()
  {
    this.jdField_a_of_type_Bgpa = bglp.a(this.jdField_a_of_type_AndroidViewView.getContext(), 0, null, "", anni.a(2131704005), anni.a(2131704002), new acoy(this), new acoz(this));
    this.jdField_a_of_type_Bgpa.setOnKeyListener(new acpa(this));
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
    this.jdField_a_of_type_Acot.a(this.jdField_a_of_type_AndroidViewView.getContext(), this.jdField_a_of_type_Boolean);
  }
  
  private void v()
  {
    Object localObject = this.jdField_a_of_type_Acoe.a();
    URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
    localURLDrawableOptions.mLoadingDrawable = this.jdField_a_of_type_AndroidViewView.getResources().getDrawable(2130850664);
    localURLDrawableOptions.mFailedDrawable = this.jdField_a_of_type_AndroidViewView.getResources().getDrawable(2130850664);
    localObject = URLDrawable.getDrawable(((GdtMotiveVideoPageData)localObject).previewImgUrl, localURLDrawableOptions);
    ((URLDrawable)localObject).setDecodeHandler(bgey.n);
    ((URLDrawable)localObject).setTag(new int[] { 50 });
    if (this.jdField_a_of_type_AndroidWidgetImageView != null) {
      this.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable((Drawable)localObject);
    }
  }
  
  private void w()
  {
    QLog.i("VideoGdtGdtMvViewController", 1, "initVideoView");
    GdtMotiveVideoPageData localGdtMotiveVideoPageData = this.jdField_a_of_type_Acoe.a();
    this.jdField_a_of_type_Amtv = new amtk();
    this.jdField_a_of_type_Amtv.a(this.jdField_a_of_type_AndroidViewView.getContext(), ampj.a());
    this.jdField_a_of_type_Amtv.a(this, 100L);
    View localView = this.jdField_a_of_type_Amtv.a();
    if ((localView == null) || (this.jdField_a_of_type_AndroidWidgetRelativeLayout == null))
    {
      QLog.i("VideoGdtGdtMvViewController", 1, "[setViewStatus], videoView is null." + this.jdField_a_of_type_AndroidWidgetRelativeLayout);
      return;
    }
    RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-1, -1);
    this.jdField_a_of_type_AndroidWidgetRelativeLayout.addView(localView, localLayoutParams);
    this.jdField_a_of_type_Amtv.a(localGdtMotiveVideoPageData.url, "sd", 0);
  }
  
  private void x()
  {
    if (azwq.a())
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
      azwq.a(BaseApplicationImpl.getApplication(), new acpb(this));
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
    GdtVideoData localGdtVideoData = this.jdField_a_of_type_Acoe.a();
    a(false);
    if ((!this.f) && (this.jdField_a_of_type_Amtv != null))
    {
      this.h = false;
      this.jdField_a_of_type_Amtv.b();
      if ((this.jdField_a_of_type_Actv != null) && (localGdtVideoData != null)) {
        this.jdField_a_of_type_Actv.b(localGdtVideoData, this.jdField_a_of_type_Amtv.b());
      }
    }
    if (this.jdField_a_of_type_Acnr != null) {
      this.jdField_a_of_type_Acnr.c();
    }
    acqr.a();
  }
  
  long a()
  {
    if (this.jdField_a_of_type_Amtv != null)
    {
      if (this.f) {
        return this.jdField_a_of_type_Long;
      }
      return this.jdField_a_of_type_Amtv.b();
    }
    return 0L;
  }
  
  public acpf a()
  {
    return this.jdField_a_of_type_Acpf;
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
    return paramLayoutInflater;
  }
  
  public void a()
  {
    QLog.i("GdtMvViewController", 1, " onClick close_ads");
    if (!d()) {
      this.jdField_a_of_type_Acpf.a();
    }
  }
  
  public void a(int paramInt1, int paramInt2, String paramString)
  {
    QLog.i("GdtMvViewController", 1, "[onVideoError], result:" + paramInt1 + ",code:" + paramInt2 + ",msg:" + paramString);
    paramString = this.jdField_a_of_type_Acoe.a();
    if ((this.jdField_a_of_type_Actv != null) && (paramString != null)) {
      this.jdField_a_of_type_Actv.a(paramString);
    }
  }
  
  public void a(long paramLong1, long paramLong2)
  {
    GdtVideoData localGdtVideoData = this.jdField_a_of_type_Acoe.a();
    if (Looper.myLooper() != Looper.getMainLooper()) {
      this.jdField_a_of_type_Bkgm.post(new GdtMvViewController.6(this, paramLong1, paramLong2));
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
      if ((!this.h) && (this.jdField_a_of_type_Actv != null) && (this.jdField_a_of_type_Amtv != null) && (localGdtVideoData != null))
      {
        this.h = true;
        this.jdField_a_of_type_Actv.a(localGdtVideoData, this.jdField_a_of_type_Amtv.b());
      }
      if ((this.jdField_a_of_type_Acnr == null) || (this.jdField_a_of_type_Amtv == null)) {
        break;
      }
      this.jdField_a_of_type_Acnr.a(this.jdField_a_of_type_Amtv.a() - this.jdField_a_of_type_Amtv.b());
      return;
      bool = false;
      break label60;
    }
  }
  
  public void a(String paramString)
  {
    GdtMotiveVideoPageData localGdtMotiveVideoPageData = this.jdField_a_of_type_Acoe.a();
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
      this.jdField_a_of_type_Acpf.a(-1, localIntent);
      B();
      return;
      if (this.jdField_a_of_type_Amtv != null)
      {
        localIntent.putExtra("elapsed_time", this.jdField_a_of_type_Amtv.b());
        a(localGdtMotiveVideoPageData, String.valueOf(this.jdField_a_of_type_Amtv.b()), String.valueOf(this.jdField_a_of_type_Long), String.valueOf(this.f));
        QLog.i("GdtMvViewController", 1, this.jdField_c_of_type_Boolean + "[beforeFinish] " + this.jdField_a_of_type_Amtv.b() + " /" + this.jdField_a_of_type_Long);
      }
    }
  }
  
  boolean a()
  {
    return this.jdField_a_of_type_Acot.a();
  }
  
  public void b()
  {
    if (this.jdField_a_of_type_Amtv == null) {
      return;
    }
    boolean bool2 = this.jdField_a_of_type_Amtv.a();
    boolean bool1;
    if (!bool2)
    {
      bool1 = true;
      this.jdField_a_of_type_Boolean = bool1;
      QLog.i("GdtMvViewController", 1, "audioSwitch click is called isSilentMode = " + this.j + ", isMute = " + bool2);
      this.jdField_a_of_type_Amtv.a(this.jdField_a_of_type_Boolean);
      if (!this.jdField_a_of_type_Boolean) {
        break label103;
      }
    }
    label103:
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
    this.jdField_a_of_type_Acot.a(paramLong1, paramLong2);
  }
  
  boolean b()
  {
    return this.f;
  }
  
  public void c()
  {
    this.jdField_a_of_type_Acot.a(this.jdField_a_of_type_AndroidViewView, this, this.jdField_a_of_type_Acoe);
    if (this.jdField_a_of_type_Acno != null)
    {
      this.jdField_a_of_type_Acno.a(this.jdField_a_of_type_Acpf.a(), this.jdField_b_of_type_Boolean);
      return;
    }
    this.jdField_a_of_type_Acot.a(this.jdField_a_of_type_Acpf.a(), this.jdField_b_of_type_Boolean);
  }
  
  public boolean c()
  {
    if ((this.jdField_a_of_type_Acno != null) && (this.jdField_a_of_type_Acno.a())) {}
    while ((this.jdField_a_of_type_Acnr != null) && (this.jdField_a_of_type_Acnr.b())) {
      return true;
    }
    return d();
  }
  
  protected void d()
  {
    if ((this.jdField_a_of_type_Amtv != null) && (!this.jdField_a_of_type_Amtv.d()))
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
        if ((this.jdField_a_of_type_Bgpa == null) || (this.jdField_a_of_type_Bgpa.isShowing())) {
          break;
        }
        QLog.i("GdtMvViewController", 1, "showDialog mVideoDuration " + this.jdField_a_of_type_Long + " mShotSeconds " + this.jdField_b_of_type_Long + " mRewardText " + this.jdField_a_of_type_JavaLangString);
        Object localObject = new StringBuffer(anni.a(2131692605));
        if (TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString))
        {
          ((StringBuffer)localObject).append(anni.a(2131692601));
          bgpa localbgpa = this.jdField_a_of_type_Bgpa;
          if (this.jdField_a_of_type_Long > this.jdField_b_of_type_Long * 1000L)
          {
            localObject = anni.a(2131704000) + this.jdField_b_of_type_Long + ((StringBuffer)localObject).toString();
            localbgpa.setMessage((CharSequence)localObject);
            this.jdField_a_of_type_Bgpa.show();
            localObject = this.jdField_a_of_type_Bgpa.getWindow();
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
        String str = anni.a(2131704001);
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
      if (this.jdField_a_of_type_Bkgm != null)
      {
        QLog.i("GdtMvViewController", 1, "[onVideoPrepared] send PREPARED msg");
        this.jdField_a_of_type_Bkgm.obtainMessage(1).sendToTarget();
      }
    }
    while ((this.d) || (this.jdField_a_of_type_Amtv == null) || (this.jdField_a_of_type_Amtv.c())) {
      return;
    }
    QLog.i("GdtMvViewController", 1, "[onVideoPrepared] resume VideoPlayer again");
    f();
  }
  
  public void f()
  {
    if ((this.i) && (this.jdField_a_of_type_Amtv != null))
    {
      this.jdField_a_of_type_Amtv.a();
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
    GdtVideoData localGdtVideoData = this.jdField_a_of_type_Acoe.a();
    this.e = false;
    this.f = true;
    this.jdField_c_of_type_Boolean = true;
    if (this.jdField_a_of_type_Bkgm != null) {
      this.jdField_a_of_type_Bkgm.obtainMessage(2).sendToTarget();
    }
    if ((this.jdField_a_of_type_Actv != null) && (localGdtVideoData != null)) {
      this.jdField_a_of_type_Actv.b(localGdtVideoData);
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
        } while (this.jdField_a_of_type_Amtv == null);
        A();
      } while (this.jdField_a_of_type_Amtv == null);
      paramMessage = this.jdField_a_of_type_Amtv;
      if ((this.jdField_a_of_type_Boolean) || (this.j)) {}
      for (boolean bool = true;; bool = false)
      {
        paramMessage.a(bool);
        this.jdField_a_of_type_Long = this.jdField_a_of_type_Amtv.a();
        QLog.i("GdtMvViewController", 1, "[mDuration]" + this.jdField_a_of_type_Long + ", mIsMute = " + this.jdField_a_of_type_Boolean + ", isSilentMode = " + this.j);
        this.jdField_a_of_type_Acoe.a().setDurationMillis(this.jdField_a_of_type_Long);
        f();
        return false;
      }
    case 2: 
      QLog.i("GdtMvViewController", 1, "[onVideoCompletion]");
      if (this.jdField_a_of_type_Amtv != null) {
        this.jdField_a_of_type_Amtv.b(this);
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
    if (this.jdField_a_of_type_Acoq != null) {
      this.jdField_a_of_type_Acoq.g();
    }
    if (this.jdField_a_of_type_Acnr != null) {
      this.jdField_a_of_type_Acnr.b();
    }
    acqr.a(new acpd(this, null));
  }
  
  public void l()
  {
    QLog.i("GdtMvViewController", 1, "[onDestroy]");
    if (this.jdField_a_of_type_Bkgm != null) {
      this.jdField_a_of_type_Bkgm.removeCallbacksAndMessages(null);
    }
    if (this.jdField_a_of_type_Acpg != null) {
      this.jdField_a_of_type_Acpg.b();
    }
    if (this.jdField_a_of_type_Amtv != null)
    {
      this.jdField_a_of_type_Amtv.b(this);
      this.jdField_a_of_type_Amtv.b();
      this.jdField_a_of_type_Amtv = null;
    }
    if (this.jdField_a_of_type_Acoq != null)
    {
      this.jdField_a_of_type_Acoq.e();
      this.jdField_a_of_type_Acoq = null;
    }
    if (this.jdField_a_of_type_Acnr != null) {
      this.jdField_a_of_type_Acnr.d();
    }
    if (this.jdField_a_of_type_Actv != null) {
      this.jdField_a_of_type_Actv = null;
    }
    if ((this.jdField_a_of_type_AndroidContentContext != null) && (this.jdField_a_of_type_Acpe != null)) {
      this.jdField_a_of_type_AndroidContentContext.unregisterReceiver(this.jdField_a_of_type_Acpe);
    }
    this.jdField_a_of_type_AndroidContentContext = null;
    acrh.a().a();
    bies.a(BaseApplicationImpl.getApplication().getApplicationContext(), true, 55);
  }
  
  public void m()
  {
    QLog.i("GdtMvViewController", 1, "[onCreate]");
    bies.a(BaseApplicationImpl.getApplication().getApplicationContext(), false, 55);
  }
  
  protected void n()
  {
    if (this.jdField_a_of_type_Acno != null) {
      this.jdField_a_of_type_Acno.b();
    }
    do
    {
      return;
      a(1);
    } while (this.jdField_a_of_type_Acnr == null);
    this.jdField_a_of_type_Acnr.a();
  }
  
  public void o()
  {
    a("");
  }
  
  public void onClick(View paramView) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     acow
 * JD-Core Version:    0.7.0.1
 */