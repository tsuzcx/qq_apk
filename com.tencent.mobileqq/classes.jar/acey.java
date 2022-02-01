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
import com.tencent.ad.tangram.util.AdExposureChecker;
import com.tencent.ad.tangram.util.AdExposureChecker.ExposureCallback;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.gdtad.aditem.GdtAd;
import com.tencent.gdtad.api.motivevideo.GdtMotiveVideoPageData;
import com.tencent.gdtad.api.motivevideo.GdtMvViewController.11;
import com.tencent.gdtad.api.motivevideo.GdtMvViewController.7;
import com.tencent.gdtad.api.motivevideo.GdtMvViewController.8;
import com.tencent.gdtad.views.video.GdtVideoData;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import mqq.os.MqqHandler;
import tencent.gdt.qq_ad_get.QQAdGetRsp.AdInfo;
import tencent.gdt.qq_ad_get.QQAdGetRsp.AdInfo.ExpInfo;

public class acey
  implements acew, anay, Handler.Callback, View.OnClickListener
{
  public int a;
  private long jdField_a_of_type_Long;
  private acdn jdField_a_of_type_Acdn;
  private acdq jdField_a_of_type_Acdq;
  private aced jdField_a_of_type_Aced;
  private acep jdField_a_of_type_Acep;
  public final aceu a;
  public final acev a;
  private acfi jdField_a_of_type_Acfi;
  private acfj jdField_a_of_type_Acfj;
  private acfk jdField_a_of_type_Acfk;
  private acfo jdField_a_of_type_Acfo;
  private final acib jdField_a_of_type_Acib = new acib();
  private ackh jdField_a_of_type_Ackh;
  private anaz jdField_a_of_type_Anaz;
  private Context jdField_a_of_type_AndroidContentContext;
  private AudioManager jdField_a_of_type_AndroidMediaAudioManager;
  private View jdField_a_of_type_AndroidViewView;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private RelativeLayout jdField_a_of_type_AndroidWidgetRelativeLayout;
  private bkys jdField_a_of_type_Bkys = new bkys(Looper.getMainLooper(), this);
  private AdExposureChecker.ExposureCallback jdField_a_of_type_ComTencentAdTangramUtilAdExposureChecker$ExposureCallback;
  private AdExposureChecker jdField_a_of_type_ComTencentAdTangramUtilAdExposureChecker;
  private QQCustomDialog jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog;
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
  
  public acey(acfj paramacfj, aced paramaced, boolean paramBoolean)
  {
    this.jdField_a_of_type_Boolean = false;
    this.jdField_a_of_type_Int = 0;
    this.jdField_a_of_type_Acev = new acev();
    this.jdField_a_of_type_Aceu = new aceu();
    this.jdField_a_of_type_Acfj = paramacfj;
    this.jdField_a_of_type_Aced = paramaced;
    this.l = paramBoolean;
    paramacfj = this.jdField_a_of_type_Aced.a();
    paramacfj.style = 0;
    paramBoolean = bool;
    if (paramacfj.screenOrientation == 1) {
      paramBoolean = true;
    }
    this.jdField_b_of_type_Boolean = paramBoolean;
    int n = paramacfj.getVideoCountDown();
    this.jdField_b_of_type_Long = n;
    this.jdField_a_of_type_JavaLangString = paramacfj.getRewardText();
    paramBoolean = this.jdField_a_of_type_Aced.a().exp_info.video_countdown_style.has();
    QLog.i("GdtMvViewController", 1, "GdtMvViewController: video_countdown = " + n + ", video_countdown_style has = " + paramBoolean + ", rewardText = " + this.jdField_a_of_type_JavaLangString);
  }
  
  private void A()
  {
    if (bapt.a())
    {
      z();
      return;
    }
    B();
  }
  
  private void B()
  {
    try
    {
      QLog.i("VideoGdtGdtMvViewController", 1, "installSDK");
      bapt.a(BaseApplicationImpl.getApplication(), new acff(this));
      return;
    }
    catch (Throwable localThrowable)
    {
      QLog.e("VideoGdtGdtMvViewController", 1, "installSDK", localThrowable);
    }
  }
  
  private void C()
  {
    QLog.i("GdtMvViewController", 1, "[doPauseAction] mIsVideoPlayCompleted:" + this.f);
    GdtVideoData localGdtVideoData = this.jdField_a_of_type_Aced.a();
    c(false);
    if ((!this.f) && (this.jdField_a_of_type_Anaz != null))
    {
      this.h = false;
      this.jdField_a_of_type_Anaz.b();
      if ((this.jdField_a_of_type_Ackh != null) && (localGdtVideoData != null)) {
        this.jdField_a_of_type_Ackh.b(localGdtVideoData, this.jdField_a_of_type_Anaz.b(), this.jdField_a_of_type_Acib);
      }
    }
    if (this.jdField_a_of_type_Acdq != null) {
      this.jdField_a_of_type_Acdq.c();
    }
    if ((this.jdField_a_of_type_Acfo != null) && (this.jdField_a_of_type_Anaz != null)) {
      this.jdField_a_of_type_Acfo.a(this.jdField_a_of_type_Anaz.a(), this.jdField_a_of_type_Anaz.a(), this.jdField_a_of_type_Anaz.b(), this.jdField_b_of_type_Long, this.jdField_a_of_type_Acfo.a(this.jdField_a_of_type_Anaz));
    }
  }
  
  private void D()
  {
    if ((this.jdField_a_of_type_Anaz == null) || (this.jdField_a_of_type_AndroidWidgetRelativeLayout == null)) {
      return;
    }
    GdtMotiveVideoPageData localGdtMotiveVideoPageData = this.jdField_a_of_type_Aced.a();
    this.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(0);
    a(this.jdField_a_of_type_AndroidWidgetRelativeLayout);
    RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)this.jdField_a_of_type_AndroidWidgetRelativeLayout.getLayoutParams();
    int i2 = this.jdField_a_of_type_Anaz.a();
    int i3 = this.jdField_a_of_type_Anaz.b();
    int n;
    if (this.jdField_b_of_type_Boolean)
    {
      n = aciv.f(this.jdField_a_of_type_AndroidContentContext);
      label88:
      if (!this.jdField_b_of_type_Boolean) {
        break label299;
      }
    }
    label299:
    for (int i1 = aciv.e(this.jdField_a_of_type_AndroidContentContext);; i1 = aciv.f(this.jdField_a_of_type_AndroidContentContext))
    {
      QLog.i("GdtMvViewController", 1, "[VIDEO_PREPARED] mVideoSize " + this.jdField_b_of_type_Boolean + " vW-" + i2 + " vH-" + i3 + " sW-" + n + " sH-" + i1);
      if ((this.jdField_a_of_type_Acdn != null) || (!this.jdField_b_of_type_Boolean) || (localGdtMotiveVideoPageData.vSize == 585)) {
        break;
      }
      i2 = (int)(1.0F * n * i3 / i2);
      i1 = (int)(i1 * 150.0F / 1334.0F);
      localLayoutParams.height = i2;
      localLayoutParams.width = n;
      localLayoutParams.topMargin = i1;
      QLog.i("GdtMvViewController", 1, "[VIDEO_PREPARED] newHeight " + i2 + " newWidth-" + n + " newTop-" + i1);
      return;
      n = aciv.e(this.jdField_a_of_type_AndroidContentContext);
      break label88;
    }
  }
  
  private void E()
  {
    if (this.l)
    {
      h();
      j();
    }
  }
  
  private void F()
  {
    if (this.jdField_a_of_type_Acep != null) {
      this.jdField_a_of_type_Acep.b();
    }
  }
  
  private void G()
  {
    if (this.jdField_a_of_type_Bkys != null) {
      this.jdField_a_of_type_Bkys.post(new GdtMvViewController.11(this));
    }
  }
  
  private void a(int paramInt)
  {
    if (SystemClock.uptimeMillis() - this.jdField_c_of_type_Long < 800L) {}
    while ((paramInt == this.jdField_a_of_type_Int) || (this.jdField_a_of_type_Acep == null)) {
      return;
    }
    this.jdField_a_of_type_Int = paramInt;
    this.jdField_c_of_type_Long = SystemClock.uptimeMillis();
    this.jdField_a_of_type_Acep.a(paramInt);
  }
  
  private void a(int paramInt, boolean paramBoolean1, boolean paramBoolean2)
  {
    boolean bool = true;
    QLog.i("GdtMvViewController", 1, "setVoiceIconState volume =" + paramInt + " mVideoPlayer " + this.jdField_a_of_type_Anaz + " isFromVolumeChanged = " + paramBoolean2 + ", mIsMute = " + this.jdField_a_of_type_Boolean + ", viewResumed = " + paramBoolean1 + ", mIsVideoPlayCompleted = " + this.f);
    if ((!paramBoolean1) || (this.jdField_a_of_type_Anaz == null)) {}
    do
    {
      return;
      x();
    } while (this.f);
    if (!this.jdField_a_of_type_Boolean) {}
    for (paramBoolean1 = bool;; paramBoolean1 = false)
    {
      c(paramBoolean1);
      return;
    }
  }
  
  private void a(View paramView)
  {
    QLog.d("GdtMvViewController", 1, new Object[] { "initExpoReport isFirst=", Boolean.valueOf(this.m) });
    GdtVideoData localGdtVideoData = this.jdField_a_of_type_Aced.a();
    if ((this.m) && (paramView != null))
    {
      this.m = false;
      if (!f()) {
        break label128;
      }
      this.jdField_a_of_type_ComTencentAdTangramUtilAdExposureChecker = new AdExposureChecker(this.jdField_a_of_type_Aced.a(), new WeakReference(paramView));
      this.jdField_a_of_type_ComTencentAdTangramUtilAdExposureChecker$ExposureCallback = new acfg(this);
      this.jdField_a_of_type_ComTencentAdTangramUtilAdExposureChecker.setCallback(new WeakReference(this.jdField_a_of_type_ComTencentAdTangramUtilAdExposureChecker$ExposureCallback));
      this.jdField_a_of_type_ComTencentAdTangramUtilAdExposureChecker.startCheck();
    }
    for (;;)
    {
      this.jdField_a_of_type_Aceu.a();
      return;
      label128:
      paramView.setTag(2131381181, localGdtVideoData.getAd());
      paramView.setTag(2131381180, new acfa(this));
      achy.a().a(paramView);
    }
  }
  
  private void a(GdtMotiveVideoPageData paramGdtMotiveVideoPageData, String paramString1, String paramString2, String paramString3)
  {
    achl localachl = (achl)acfv.a().a(16);
    if (localachl != null) {
      localachl.a(paramGdtMotiveVideoPageData, paramString1, paramString2, paramString3);
    }
  }
  
  private View b(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup)
  {
    for (;;)
    {
      try
      {
        GdtMotiveVideoPageData localGdtMotiveVideoPageData = this.jdField_a_of_type_Aced.a();
        if (e()) {
          return c(paramLayoutInflater, paramViewGroup);
        }
        if (this.jdField_b_of_type_Boolean)
        {
          if (localGdtMotiveVideoPageData.vSize == 585)
          {
            this.jdField_a_of_type_AndroidViewView = paramLayoutInflater.inflate(2131559271, paramViewGroup, false);
            if (this.jdField_a_of_type_AndroidViewView != null) {
              break;
            }
            return null;
          }
          this.jdField_a_of_type_AndroidViewView = paramLayoutInflater.inflate(2131559270, paramViewGroup, false);
          continue;
        }
        this.jdField_a_of_type_AndroidViewView = paramLayoutInflater.inflate(2131559269, paramViewGroup, false);
      }
      catch (Exception paramLayoutInflater)
      {
        QLog.e("GdtMvViewController", 1, " viewcontr initViews error", paramLayoutInflater);
        return null;
      }
    }
    this.jdField_a_of_type_Acep = new acep(this, this.jdField_a_of_type_AndroidViewView, this.jdField_a_of_type_Aced);
    this.jdField_a_of_type_Acep.a(this.jdField_a_of_type_Aceu);
    aciv.a(this.jdField_a_of_type_AndroidViewView.findViewById(2131371991));
    this.jdField_a_of_type_Acep.a();
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131362106));
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)this.jdField_a_of_type_AndroidViewView.findViewById(2131380931));
    this.jdField_a_of_type_AndroidWidgetRelativeLayout.setOnClickListener(this);
    return this.jdField_a_of_type_AndroidViewView;
  }
  
  private View c(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup)
  {
    this.jdField_a_of_type_AndroidViewView = paramLayoutInflater.inflate(2131559273, paramViewGroup, false);
    if (this.jdField_a_of_type_AndroidViewView == null) {
      return null;
    }
    this.jdField_a_of_type_Acdn = new acdn(this, this.jdField_a_of_type_AndroidViewView, this.jdField_a_of_type_Aced);
    this.jdField_a_of_type_Acdn.a(this.jdField_a_of_type_Acfj.a(), this.jdField_a_of_type_Acev);
    this.jdField_a_of_type_Acdn.a(this.jdField_a_of_type_Aceu);
    aciv.a(this.jdField_a_of_type_AndroidViewView.findViewById(2131371991));
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131362106));
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)this.jdField_a_of_type_AndroidViewView.findViewById(2131380931));
    return this.jdField_a_of_type_AndroidViewView;
  }
  
  private void c(boolean paramBoolean)
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
  
  private void d(boolean paramBoolean)
  {
    if ((this.jdField_a_of_type_Acep != null) && (paramBoolean)) {
      this.jdField_a_of_type_Acep.c();
    }
  }
  
  private boolean e()
  {
    for (;;)
    {
      int n;
      boolean bool1;
      try
      {
        if ((this.jdField_a_of_type_Aced == null) || (this.jdField_a_of_type_Aced.a() == null) || (this.jdField_a_of_type_Aced.a() == null))
        {
          QLog.i("GdtMvViewController", 1, "isCellingStyle null");
          return false;
        }
        bool2 = this.jdField_a_of_type_Aced.a().isMvCellingStyle();
        bool3 = this.jdField_a_of_type_Aced.a().isXiJinDestType();
        i1 = this.jdField_a_of_type_Aced.a().vSize;
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
  
  private boolean f()
  {
    boolean bool = this.jdField_a_of_type_Aced.a().useExposureChecker();
    QLog.d("GdtMvViewController", 1, new Object[] { "useExposureChecker=", Boolean.valueOf(bool) });
    return bool;
  }
  
  private void n()
  {
    if ((this.jdField_a_of_type_Aced == null) || (this.jdField_a_of_type_Aced.a() == null) || (!this.jdField_a_of_type_Aced.a().isValid()))
    {
      QLog.e("GdtMvViewController", 1, "doAdPreload error");
      return;
    }
    GdtAd localGdtAd = this.jdField_a_of_type_Aced.a();
    if (!localGdtAd.isHitPreloadCanvasJsonExp())
    {
      QLog.i("GdtMvViewController", 1, "not hitPreloadCanvasJsonExp");
      return;
    }
    acam.a().a(localGdtAd);
  }
  
  private void o()
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
      this.jdField_a_of_type_Acfi = new acfi(this, null);
      IntentFilter localIntentFilter = new IntentFilter();
      localIntentFilter.addAction("android.media.RINGER_MODE_CHANGED");
      this.jdField_a_of_type_AndroidContentContext.registerReceiver(this.jdField_a_of_type_Acfi, localIntentFilter);
      this.jdField_a_of_type_Acfk = new acfk(this.jdField_a_of_type_AndroidContentContext);
      this.jdField_a_of_type_Acfk.a();
      this.jdField_a_of_type_Acfk.a(new acez(this));
      return;
    }
  }
  
  private void p()
  {
    if ((this.jdField_a_of_type_Acep != null) || (this.jdField_a_of_type_Acdn != null))
    {
      this.jdField_a_of_type_Ackh = new ackh(11);
      return;
    }
    QLog.i("GdtMvViewController", 1, " initReports error");
  }
  
  private void q()
  {
    this.jdField_a_of_type_Acdq = new acdq();
    this.jdField_a_of_type_Acdq.a(this.jdField_a_of_type_Aced, this.jdField_a_of_type_AndroidViewView, this.jdField_a_of_type_Acfj.a(), this.jdField_b_of_type_Boolean);
  }
  
  private void r()
  {
    this.jdField_a_of_type_Acfo = new acfo(new acfb(this), this.jdField_a_of_type_Bkys);
    boolean bool = this.jdField_a_of_type_Acfo.a(this.jdField_a_of_type_Aced, this.jdField_a_of_type_AndroidViewView, this.jdField_a_of_type_Acfj.a(), this.jdField_b_of_type_Boolean);
    QLog.i("GdtMvViewController", 1, "web bottom card result:" + bool);
    if (bool)
    {
      t();
      return;
    }
    this.jdField_a_of_type_Acfo.f();
    this.jdField_a_of_type_Acfo = null;
    s();
  }
  
  private void s()
  {
    this.jdField_a_of_type_Acev.a(0);
    if (this.jdField_a_of_type_Acfo != null) {
      this.jdField_a_of_type_Acfo.a();
    }
  }
  
  private void t()
  {
    this.jdField_a_of_type_Acev.a(4);
    if (this.jdField_a_of_type_Acfo != null)
    {
      this.jdField_a_of_type_Acfo.b();
      this.jdField_a_of_type_Acfo.g();
    }
  }
  
  private void u()
  {
    this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog = bhdj.a(this.jdField_a_of_type_AndroidViewView.getContext(), 0, null, "", anvx.a(2131704692), anvx.a(2131704689), new acfc(this), new acfd(this));
    this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.setOnKeyListener(new acfe(this));
  }
  
  private void v()
  {
    boolean bool1 = true;
    qq_ad_get.QQAdGetRsp.AdInfo localAdInfo = this.jdField_a_of_type_Aced.a();
    boolean bool2 = localAdInfo.exp_info.video_volume.has();
    int n = localAdInfo.exp_info.video_volume.get();
    QLog.i("GdtMvViewController", 1, "[initMute] videoVolume = " + n + ",isHasVideoVolume = " + bool2);
    if ((bool2) && (n == 0)) {}
    for (;;)
    {
      this.jdField_a_of_type_Boolean = bool1;
      return;
      bool1 = false;
    }
  }
  
  private void w()
  {
    if (this.j)
    {
      QLog.i("GdtMvViewController", 1, "refreshVoiceIconDrawable isSilentMode is true");
      this.jdField_a_of_type_Boolean = true;
    }
    x();
  }
  
  private void x()
  {
    this.jdField_a_of_type_Acev.a(this.jdField_a_of_type_AndroidViewView.getContext(), this.jdField_a_of_type_Boolean);
  }
  
  private void y()
  {
    Object localObject = this.jdField_a_of_type_Aced.a();
    URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
    localURLDrawableOptions.mLoadingDrawable = this.jdField_a_of_type_AndroidViewView.getResources().getDrawable(2130850736);
    localURLDrawableOptions.mFailedDrawable = this.jdField_a_of_type_AndroidViewView.getResources().getDrawable(2130850736);
    localObject = URLDrawable.getDrawable(((GdtMotiveVideoPageData)localObject).previewImgUrl, localURLDrawableOptions);
    ((URLDrawable)localObject).setDecodeHandler(bgxc.n);
    ((URLDrawable)localObject).setTag(new int[] { 50 });
    if (this.jdField_a_of_type_AndroidWidgetImageView != null) {
      this.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable((Drawable)localObject);
    }
  }
  
  private void z()
  {
    QLog.i("VideoGdtGdtMvViewController", 1, "initVideoView");
    GdtMotiveVideoPageData localGdtMotiveVideoPageData = this.jdField_a_of_type_Aced.a();
    this.jdField_a_of_type_Acib.a(11);
    this.jdField_a_of_type_Anaz = new anao();
    this.jdField_a_of_type_Anaz.a(this.jdField_a_of_type_AndroidViewView.getContext(), amwn.a());
    this.jdField_a_of_type_Anaz.a(this, 100L);
    View localView = this.jdField_a_of_type_Anaz.a();
    if ((localView == null) || (this.jdField_a_of_type_AndroidWidgetRelativeLayout == null))
    {
      QLog.i("VideoGdtGdtMvViewController", 1, "[setViewStatus], videoView is null." + this.jdField_a_of_type_AndroidWidgetRelativeLayout);
      return;
    }
    RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-1, -1);
    this.jdField_a_of_type_AndroidWidgetRelativeLayout.addView(localView, localLayoutParams);
    this.jdField_a_of_type_Anaz.a(localGdtMotiveVideoPageData.url, "sd", 0);
  }
  
  long a()
  {
    if (this.jdField_a_of_type_Anaz != null)
    {
      if (this.f) {
        return this.jdField_a_of_type_Long;
      }
      return this.jdField_a_of_type_Anaz.b();
    }
    return 0L;
  }
  
  public acfj a()
  {
    return this.jdField_a_of_type_Acfj;
  }
  
  public acib a()
  {
    return this.jdField_a_of_type_Acib;
  }
  
  public View a(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup)
  {
    v();
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
    n();
    o();
    w();
    a();
    y();
    A();
    F();
    u();
    p();
    q();
    r();
    this.jdField_a_of_type_Aceu.a(this.jdField_a_of_type_Aced);
    return paramLayoutInflater;
  }
  
  public void a()
  {
    this.jdField_a_of_type_Acev.a(this.jdField_a_of_type_AndroidViewView, this, this.jdField_a_of_type_Aced, this.jdField_a_of_type_Aceu);
    if (this.jdField_a_of_type_Acdn != null)
    {
      this.jdField_a_of_type_Acdn.a(this.jdField_a_of_type_Acfj.a(), this.jdField_b_of_type_Boolean);
      return;
    }
    this.jdField_a_of_type_Acev.a(this.jdField_a_of_type_Acfj.a(), this.jdField_b_of_type_Boolean);
  }
  
  public void a(int paramInt1, int paramInt2, int paramInt3, String paramString)
  {
    QLog.i("GdtMvViewController", 1, "[onVideoError], module:" + paramInt1 + ",errorType:" + paramInt2 + ",errorCode:" + paramInt3 + ",msg:" + paramString);
    paramString = this.jdField_a_of_type_Aced.a();
    if ((this.jdField_a_of_type_Ackh != null) && (paramString != null))
    {
      this.jdField_a_of_type_Acib.a(paramInt2, paramInt3);
      this.jdField_a_of_type_Ackh.a(paramString, this.jdField_a_of_type_Anaz.b(), this.jdField_a_of_type_Acib);
    }
  }
  
  public void a(long paramLong1, long paramLong2)
  {
    GdtVideoData localGdtVideoData = this.jdField_a_of_type_Aced.a();
    if (Looper.myLooper() != Looper.getMainLooper()) {
      this.jdField_a_of_type_Bkys.post(new GdtMvViewController.8(this, paramLong1, paramLong2));
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
        break label321;
      }
    }
    label321:
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
        d(true);
      }
      if (paramLong1 / 1000L == 3L) {
        d(false);
      }
      if ((!this.h) && (this.jdField_a_of_type_Ackh != null) && (this.jdField_a_of_type_Anaz != null) && (localGdtVideoData != null))
      {
        this.h = true;
        this.jdField_a_of_type_Ackh.a(localGdtVideoData, this.jdField_a_of_type_Anaz.b());
      }
      if ((this.jdField_a_of_type_Acdq != null) && (this.jdField_a_of_type_Anaz != null)) {
        this.jdField_a_of_type_Acdq.a(this.jdField_a_of_type_Anaz.a() - this.jdField_a_of_type_Anaz.b());
      }
      if ((this.jdField_a_of_type_Acfo == null) || (this.jdField_a_of_type_Anaz == null)) {
        break;
      }
      this.jdField_a_of_type_Acfo.a(this.jdField_a_of_type_Anaz.a(), this.jdField_a_of_type_Anaz.a(), this.jdField_a_of_type_Anaz.b(), this.jdField_b_of_type_Long, this.jdField_a_of_type_Acfo.a(this.jdField_a_of_type_Anaz));
      return;
      bool = false;
      break label60;
    }
  }
  
  public void a(String paramString)
  {
    GdtMotiveVideoPageData localGdtMotiveVideoPageData = this.jdField_a_of_type_Aced.a();
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
      this.jdField_a_of_type_Acfj.a(-1, localIntent);
      E();
      return;
      if (this.jdField_a_of_type_Anaz != null)
      {
        localIntent.putExtra("elapsed_time", this.jdField_a_of_type_Anaz.b());
        a(localGdtMotiveVideoPageData, String.valueOf(this.jdField_a_of_type_Anaz.b()), String.valueOf(this.jdField_a_of_type_Long), String.valueOf(this.f));
        QLog.i("GdtMvViewController", 1, this.jdField_c_of_type_Boolean + "[beforeFinish] " + this.jdField_a_of_type_Anaz.b() + " /" + this.jdField_a_of_type_Long);
      }
    }
  }
  
  public void a(boolean paramBoolean)
  {
    QLog.i("GdtMvViewController", 1, " onClick close_ads");
    if (!d())
    {
      if (paramBoolean) {
        this.jdField_a_of_type_Aceu.a(4, a());
      }
      this.jdField_a_of_type_Acfj.a();
    }
  }
  
  boolean a()
  {
    return this.jdField_a_of_type_Acev.a();
  }
  
  protected void b()
  {
    if ((this.jdField_a_of_type_Anaz != null) && (!this.jdField_a_of_type_Anaz.d()))
    {
      this.d = true;
      C();
    }
  }
  
  protected void b(long paramLong1, long paramLong2)
  {
    this.jdField_a_of_type_Acev.a(paramLong1, paramLong2);
  }
  
  public void b(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_Anaz == null) {
      return;
    }
    if (paramBoolean) {
      this.jdField_a_of_type_Aceu.a(7, a());
    }
    boolean bool = this.jdField_a_of_type_Anaz.a();
    if (!bool)
    {
      paramBoolean = true;
      this.jdField_a_of_type_Boolean = paramBoolean;
      QLog.i("GdtMvViewController", 1, "audioSwitch click is called isSilentMode = " + this.j + ", isMute = " + bool);
      this.jdField_a_of_type_Anaz.a(this.jdField_a_of_type_Boolean);
      if (!this.jdField_a_of_type_Boolean) {
        break label120;
      }
    }
    label120:
    for (int n = 0;; n = 1)
    {
      a(n, true, false);
      return;
      paramBoolean = false;
      break;
    }
  }
  
  boolean b()
  {
    return this.f;
  }
  
  public void c()
  {
    QLog.i("GdtMvViewController", 1, "[onVideoPrepared]");
    if (!this.e)
    {
      this.e = true;
      if (this.jdField_a_of_type_Bkys != null)
      {
        QLog.i("GdtMvViewController", 1, "[onVideoPrepared] send PREPARED msg");
        this.jdField_a_of_type_Bkys.obtainMessage(1).sendToTarget();
      }
    }
    while ((this.d) || (this.jdField_a_of_type_Anaz == null) || (this.jdField_a_of_type_Anaz.c())) {
      return;
    }
    QLog.i("GdtMvViewController", 1, "[onVideoPrepared] resume VideoPlayer again");
    d();
  }
  
  public boolean c()
  {
    if ((this.jdField_a_of_type_Acdn != null) && (this.jdField_a_of_type_Acdn.a())) {}
    while ((this.jdField_a_of_type_Acdq != null) && (this.jdField_a_of_type_Acdq.a())) {
      return true;
    }
    return d();
  }
  
  public void d()
  {
    if ((this.i) && (this.jdField_a_of_type_Anaz != null))
    {
      this.jdField_a_of_type_Anaz.a();
      if (this.jdField_a_of_type_Boolean) {
        break label42;
      }
    }
    label42:
    for (boolean bool = true;; bool = false)
    {
      c(bool);
      x();
      return;
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
        b();
        if ((this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog == null) || (this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.isShowing())) {
          break;
        }
        QLog.i("GdtMvViewController", 1, "showDialog mVideoDuration " + this.jdField_a_of_type_Long + " mShotSeconds " + this.jdField_b_of_type_Long + " mRewardText " + this.jdField_a_of_type_JavaLangString);
        Object localObject = new StringBuffer(anvx.a(2131692761));
        if (TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString))
        {
          ((StringBuffer)localObject).append(anvx.a(2131692757));
          QQCustomDialog localQQCustomDialog = this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog;
          if (this.jdField_a_of_type_Long > this.jdField_b_of_type_Long * 1000L)
          {
            localObject = anvx.a(2131704687) + this.jdField_b_of_type_Long + ((StringBuffer)localObject).toString();
            localQQCustomDialog.setMessage((CharSequence)localObject);
            this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.show();
            localObject = this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.getWindow();
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
        String str = anvx.a(2131704688);
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
    QLog.i("GdtMvViewController", 1, "[onVideoCompletion]");
    GdtVideoData localGdtVideoData = this.jdField_a_of_type_Aced.a();
    this.e = false;
    this.f = true;
    this.jdField_c_of_type_Boolean = true;
    if (this.jdField_a_of_type_Bkys != null) {
      this.jdField_a_of_type_Bkys.obtainMessage(2).sendToTarget();
    }
    if ((this.jdField_a_of_type_Ackh != null) && (localGdtVideoData != null)) {
      this.jdField_a_of_type_Ackh.a(localGdtVideoData, this.jdField_a_of_type_Acib);
    }
    if (this.jdField_a_of_type_Acfo != null)
    {
      if (this.jdField_a_of_type_Anaz != null) {
        this.jdField_a_of_type_Acfo.a(this.jdField_a_of_type_Anaz.a(), this.jdField_a_of_type_Anaz.a(), this.jdField_a_of_type_Anaz.b(), this.jdField_b_of_type_Long, this.jdField_a_of_type_Acfo.a(this.jdField_a_of_type_Anaz));
      }
      ThreadManager.getUIHandler().post(new GdtMvViewController.7(this));
    }
  }
  
  public void f()
  {
    QLog.i("GdtMvViewController", 1, "[onVideoBufferStart]");
  }
  
  public void g()
  {
    QLog.i("GdtMvViewController", 1, "[onVideoBufferEnd]");
  }
  
  public void h()
  {
    this.i = false;
    C();
    if (this.jdField_a_of_type_ComTencentAdTangramUtilAdExposureChecker != null) {
      this.jdField_a_of_type_ComTencentAdTangramUtilAdExposureChecker.onActivityPause();
    }
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
        } while (this.jdField_a_of_type_Anaz == null);
        D();
      } while (this.jdField_a_of_type_Anaz == null);
      paramMessage = this.jdField_a_of_type_Anaz;
      if ((this.jdField_a_of_type_Boolean) || (this.j)) {}
      for (boolean bool = true;; bool = false)
      {
        paramMessage.a(bool);
        this.jdField_a_of_type_Long = this.jdField_a_of_type_Anaz.a();
        QLog.i("GdtMvViewController", 1, "[mDuration]" + this.jdField_a_of_type_Long + ", mIsMute = " + this.jdField_a_of_type_Boolean + ", isSilentMode = " + this.j);
        this.jdField_a_of_type_Aced.a().setDurationMillis(this.jdField_a_of_type_Long);
        d();
        return false;
      }
    case 2: 
      QLog.i("GdtMvViewController", 1, "[onVideoCompletion]");
      if (this.jdField_a_of_type_Anaz != null) {
        this.jdField_a_of_type_Anaz.b(this);
      }
      b(0L, 0L);
      c(false);
      l();
      return false;
    }
    QLog.i("GdtMvViewController", 1, "[VIDEO_SDK_INSTALLED] initVideoView");
    z();
    return false;
  }
  
  public void i()
  {
    this.i = true;
    QLog.i("GdtMvViewController", 1, "[onResume]" + this.d + " mIsVideoPlayCompleted " + this.f);
    if ((!this.d) && (!this.f) && (this.e)) {
      d();
    }
    if (this.jdField_a_of_type_Acep != null) {
      this.jdField_a_of_type_Acep.g();
    }
    if (this.jdField_a_of_type_Acdq != null) {
      this.jdField_a_of_type_Acdq.b();
    }
    ache.a(new acfh(this, null));
    if (this.jdField_a_of_type_ComTencentAdTangramUtilAdExposureChecker != null) {
      this.jdField_a_of_type_ComTencentAdTangramUtilAdExposureChecker.onActivityResume();
    }
  }
  
  public void j()
  {
    QLog.i("GdtMvViewController", 1, "[onDestroy]");
    if (this.jdField_a_of_type_Bkys != null) {
      this.jdField_a_of_type_Bkys.removeCallbacksAndMessages(null);
    }
    if (this.jdField_a_of_type_Acfk != null) {
      this.jdField_a_of_type_Acfk.b();
    }
    if (this.jdField_a_of_type_Anaz != null)
    {
      this.jdField_a_of_type_Anaz.b(this);
      this.jdField_a_of_type_Anaz.b();
      this.jdField_a_of_type_Anaz = null;
    }
    if (this.jdField_a_of_type_Acep != null)
    {
      this.jdField_a_of_type_Acep.e();
      this.jdField_a_of_type_Acep = null;
    }
    if (this.jdField_a_of_type_Acdq != null) {
      this.jdField_a_of_type_Acdq.a(this.jdField_a_of_type_Acfj.a(), this.l);
    }
    if (this.jdField_a_of_type_Acfo != null) {
      this.jdField_a_of_type_Acfo.f();
    }
    if (this.jdField_a_of_type_Ackh != null) {
      this.jdField_a_of_type_Ackh = null;
    }
    if ((this.jdField_a_of_type_AndroidContentContext != null) && (this.jdField_a_of_type_Acfi != null)) {
      this.jdField_a_of_type_AndroidContentContext.unregisterReceiver(this.jdField_a_of_type_Acfi);
    }
    this.jdField_a_of_type_AndroidContentContext = null;
    achy.a().a();
    biwn.a(BaseApplicationImpl.getApplication().getApplicationContext(), true, 55);
    if (this.jdField_a_of_type_ComTencentAdTangramUtilAdExposureChecker != null)
    {
      this.jdField_a_of_type_ComTencentAdTangramUtilAdExposureChecker.onActivityDestroy();
      this.jdField_a_of_type_ComTencentAdTangramUtilAdExposureChecker.setCallback(null);
    }
    ache.c();
  }
  
  public void k()
  {
    QLog.i("GdtMvViewController", 1, "[onCreate]");
    biwn.a(BaseApplicationImpl.getApplication().getApplicationContext(), false, 55);
  }
  
  protected void l()
  {
    if (this.jdField_a_of_type_Acdn != null) {
      this.jdField_a_of_type_Acdn.b();
    }
    do
    {
      return;
      a(1);
    } while (this.jdField_a_of_type_Acdq == null);
    this.jdField_a_of_type_Acdq.a(this.jdField_a_of_type_Acfj.a(), this.jdField_a_of_type_Aced, this.jdField_b_of_type_Boolean);
  }
  
  public void m()
  {
    a("");
  }
  
  public void onClick(View paramView) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     acey
 * JD-Core Version:    0.7.0.1
 */