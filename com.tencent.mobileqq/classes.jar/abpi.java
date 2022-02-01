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
import com.tencent.gdtad.api.motivevideo.GdtMvViewController.6;
import com.tencent.gdtad.api.motivevideo.GdtMvViewController.9;
import com.tencent.gdtad.views.video.GdtVideoData;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import tencent.gdt.qq_ad_get.QQAdGetRsp.AdInfo;
import tencent.gdt.qq_ad_get.QQAdGetRsp.AdInfo.ExpInfo;

public class abpi
  implements abpg, amai, Handler.Callback, View.OnClickListener
{
  public int a;
  private long jdField_a_of_type_Long;
  private abnz jdField_a_of_type_Abnz;
  private aboc jdField_a_of_type_Aboc;
  private abop jdField_a_of_type_Abop;
  private abpb jdField_a_of_type_Abpb;
  public final abpe a;
  public final abpf a;
  private abpr jdField_a_of_type_Abpr;
  private abps jdField_a_of_type_Abps;
  private abpt jdField_a_of_type_Abpt;
  private final abry jdField_a_of_type_Abry = new abry();
  private abui jdField_a_of_type_Abui;
  private amaj jdField_a_of_type_Amaj;
  private Context jdField_a_of_type_AndroidContentContext;
  private AudioManager jdField_a_of_type_AndroidMediaAudioManager;
  private View jdField_a_of_type_AndroidViewView;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private RelativeLayout jdField_a_of_type_AndroidWidgetRelativeLayout;
  private bjng jdField_a_of_type_Bjng = new bjng(Looper.getMainLooper(), this);
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
  
  public abpi(abps paramabps, abop paramabop, boolean paramBoolean)
  {
    this.jdField_a_of_type_Boolean = false;
    this.jdField_a_of_type_Int = 0;
    this.jdField_a_of_type_Abpf = new abpf();
    this.jdField_a_of_type_Abpe = new abpe();
    this.jdField_a_of_type_Abps = paramabps;
    this.jdField_a_of_type_Abop = paramabop;
    this.l = paramBoolean;
    paramabps = this.jdField_a_of_type_Abop.a();
    paramabps.style = 0;
    paramBoolean = bool;
    if (paramabps.screenOrientation == 1) {
      paramBoolean = true;
    }
    this.jdField_b_of_type_Boolean = paramBoolean;
    int n = paramabps.getVideoCountDown();
    this.jdField_b_of_type_Long = n;
    this.jdField_a_of_type_JavaLangString = paramabps.getRewardText();
    paramBoolean = this.jdField_a_of_type_Abop.a().exp_info.video_countdown_style.has();
    QLog.i("GdtMvViewController", 1, "GdtMvViewController: video_countdown = " + n + ", video_countdown_style has = " + paramBoolean + ", rewardText = " + this.jdField_a_of_type_JavaLangString);
  }
  
  private void A()
  {
    try
    {
      QLog.i("VideoGdtGdtMvViewController", 1, "installSDK");
      azjl.a(BaseApplicationImpl.getApplication(), new abpn(this));
      return;
    }
    catch (Throwable localThrowable)
    {
      QLog.e("VideoGdtGdtMvViewController", 1, "installSDK", localThrowable);
    }
  }
  
  private void B()
  {
    QLog.i("GdtMvViewController", 1, "[doPauseAction] mIsVideoPlayCompleted:" + this.f);
    GdtVideoData localGdtVideoData = this.jdField_a_of_type_Abop.a();
    a(false);
    if ((!this.f) && (this.jdField_a_of_type_Amaj != null))
    {
      this.h = false;
      this.jdField_a_of_type_Amaj.b();
      if ((this.jdField_a_of_type_Abui != null) && (localGdtVideoData != null)) {
        this.jdField_a_of_type_Abui.b(localGdtVideoData, this.jdField_a_of_type_Amaj.b(), this.jdField_a_of_type_Abry);
      }
    }
    if (this.jdField_a_of_type_Aboc != null) {
      this.jdField_a_of_type_Aboc.c();
    }
    abre.a();
  }
  
  private void C()
  {
    if ((this.jdField_a_of_type_Amaj == null) || (this.jdField_a_of_type_AndroidWidgetRelativeLayout == null)) {
      return;
    }
    GdtMotiveVideoPageData localGdtMotiveVideoPageData = this.jdField_a_of_type_Abop.a();
    this.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(0);
    a(this.jdField_a_of_type_AndroidWidgetRelativeLayout);
    RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)this.jdField_a_of_type_AndroidWidgetRelativeLayout.getLayoutParams();
    int i2 = this.jdField_a_of_type_Amaj.a();
    int i3 = this.jdField_a_of_type_Amaj.b();
    int n;
    if (this.jdField_b_of_type_Boolean)
    {
      n = absw.f(this.jdField_a_of_type_AndroidContentContext);
      label88:
      if (!this.jdField_b_of_type_Boolean) {
        break label299;
      }
    }
    label299:
    for (int i1 = absw.e(this.jdField_a_of_type_AndroidContentContext);; i1 = absw.f(this.jdField_a_of_type_AndroidContentContext))
    {
      QLog.i("GdtMvViewController", 1, "[VIDEO_PREPARED] mVideoSize " + this.jdField_b_of_type_Boolean + " vW-" + i2 + " vH-" + i3 + " sW-" + n + " sH-" + i1);
      if ((this.jdField_a_of_type_Abnz != null) || (!this.jdField_b_of_type_Boolean) || (localGdtMotiveVideoPageData.vSize == 585)) {
        break;
      }
      i2 = (int)(1.0F * n * i3 / i2);
      i1 = (int)(i1 * 150.0F / 1334.0F);
      localLayoutParams.height = i2;
      localLayoutParams.width = n;
      localLayoutParams.topMargin = i1;
      QLog.i("GdtMvViewController", 1, "[VIDEO_PREPARED] newHeight " + i2 + " newWidth-" + n + " newTop-" + i1);
      return;
      n = absw.e(this.jdField_a_of_type_AndroidContentContext);
      break label88;
    }
  }
  
  private void D()
  {
    if (this.l)
    {
      j();
      l();
    }
  }
  
  private void E()
  {
    if (this.jdField_a_of_type_Abpb != null) {
      this.jdField_a_of_type_Abpb.b();
    }
  }
  
  private void F()
  {
    if (this.jdField_a_of_type_Bjng != null) {
      this.jdField_a_of_type_Bjng.post(new GdtMvViewController.9(this));
    }
  }
  
  private void a(int paramInt)
  {
    if (SystemClock.uptimeMillis() - this.jdField_c_of_type_Long < 800L) {}
    while ((paramInt == this.jdField_a_of_type_Int) || (this.jdField_a_of_type_Abpb == null)) {
      return;
    }
    this.jdField_a_of_type_Int = paramInt;
    this.jdField_c_of_type_Long = SystemClock.uptimeMillis();
    this.jdField_a_of_type_Abpb.a(paramInt);
  }
  
  private void a(int paramInt, boolean paramBoolean1, boolean paramBoolean2)
  {
    boolean bool = true;
    QLog.i("GdtMvViewController", 1, "setVoiceIconState volume =" + paramInt + " mVideoPlayer " + this.jdField_a_of_type_Amaj + " isFromVolumeChanged = " + paramBoolean2 + ", mIsMute = " + this.jdField_a_of_type_Boolean + ", viewResumed = " + paramBoolean1 + ", mIsVideoPlayCompleted = " + this.f);
    if ((!paramBoolean1) || (this.jdField_a_of_type_Amaj == null)) {}
    do
    {
      return;
      w();
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
    QLog.d("GdtMvViewController", 1, new Object[] { "initExpoReport isFirst=", Boolean.valueOf(this.m) });
    GdtVideoData localGdtVideoData = this.jdField_a_of_type_Abop.a();
    if ((this.m) && (paramView != null))
    {
      this.m = false;
      if (!f()) {
        break label128;
      }
      this.jdField_a_of_type_ComTencentAdTangramUtilAdExposureChecker = new AdExposureChecker(this.jdField_a_of_type_Abop.a(), new WeakReference(paramView));
      this.jdField_a_of_type_ComTencentAdTangramUtilAdExposureChecker$ExposureCallback = new abpo(this);
      this.jdField_a_of_type_ComTencentAdTangramUtilAdExposureChecker.setCallback(new WeakReference(this.jdField_a_of_type_ComTencentAdTangramUtilAdExposureChecker$ExposureCallback));
      this.jdField_a_of_type_ComTencentAdTangramUtilAdExposureChecker.startCheck();
    }
    for (;;)
    {
      this.jdField_a_of_type_Abpe.a();
      return;
      label128:
      paramView.setTag(2131380829, localGdtVideoData.getAd());
      paramView.setTag(2131380828, new abpp(this));
      abrv.a().a(paramView);
    }
  }
  
  private void a(GdtMotiveVideoPageData paramGdtMotiveVideoPageData, String paramString1, String paramString2, String paramString3)
  {
    abri localabri = (abri)abqb.a().a(16);
    if (localabri != null) {
      localabri.a(paramGdtMotiveVideoPageData, paramString1, paramString2, paramString3);
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
        GdtMotiveVideoPageData localGdtMotiveVideoPageData = this.jdField_a_of_type_Abop.a();
        if (e()) {
          return c(paramLayoutInflater, paramViewGroup);
        }
        if (this.jdField_b_of_type_Boolean)
        {
          if (localGdtMotiveVideoPageData.vSize == 585)
          {
            this.jdField_a_of_type_AndroidViewView = paramLayoutInflater.inflate(2131559232, paramViewGroup, false);
            if (this.jdField_a_of_type_AndroidViewView != null) {
              break;
            }
            return null;
          }
          this.jdField_a_of_type_AndroidViewView = paramLayoutInflater.inflate(2131559231, paramViewGroup, false);
          continue;
        }
        this.jdField_a_of_type_AndroidViewView = paramLayoutInflater.inflate(2131559230, paramViewGroup, false);
      }
      catch (Exception paramLayoutInflater)
      {
        QLog.e("GdtMvViewController", 1, " viewcontr initViews error", paramLayoutInflater);
        return null;
      }
    }
    this.jdField_a_of_type_Abpb = new abpb(this, this.jdField_a_of_type_AndroidViewView, this.jdField_a_of_type_Abop);
    this.jdField_a_of_type_Abpb.a(this.jdField_a_of_type_Abpe);
    absw.a(this.jdField_a_of_type_AndroidViewView.findViewById(2131371801));
    this.jdField_a_of_type_Abpb.a();
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131362102));
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)this.jdField_a_of_type_AndroidViewView.findViewById(2131380586));
    this.jdField_a_of_type_AndroidWidgetRelativeLayout.setOnClickListener(this);
    return this.jdField_a_of_type_AndroidViewView;
  }
  
  private void b(boolean paramBoolean)
  {
    if ((this.jdField_a_of_type_Abpb != null) && (paramBoolean)) {
      this.jdField_a_of_type_Abpb.c();
    }
  }
  
  private View c(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup)
  {
    this.jdField_a_of_type_AndroidViewView = paramLayoutInflater.inflate(2131559234, paramViewGroup, false);
    if (this.jdField_a_of_type_AndroidViewView == null) {
      return null;
    }
    this.jdField_a_of_type_Abnz = new abnz(this, this.jdField_a_of_type_AndroidViewView, this.jdField_a_of_type_Abop);
    this.jdField_a_of_type_Abnz.a(this.jdField_a_of_type_Abps.a(), this.jdField_a_of_type_Abpf);
    this.jdField_a_of_type_Abnz.a(this.jdField_a_of_type_Abpe);
    absw.a(this.jdField_a_of_type_AndroidViewView.findViewById(2131371801));
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131362102));
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)this.jdField_a_of_type_AndroidViewView.findViewById(2131380586));
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
        if ((this.jdField_a_of_type_Abop == null) || (this.jdField_a_of_type_Abop.a() == null) || (this.jdField_a_of_type_Abop.a() == null))
        {
          QLog.i("GdtMvViewController", 1, "isCellingStyle null");
          return false;
        }
        bool2 = this.jdField_a_of_type_Abop.a().isMvCellingStyle();
        bool3 = this.jdField_a_of_type_Abop.a().isXiJinDestType();
        i1 = this.jdField_a_of_type_Abop.a().vSize;
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
    boolean bool = this.jdField_a_of_type_Abop.a().useExposureChecker();
    QLog.d("GdtMvViewController", 1, new Object[] { "useExposureChecker=", Boolean.valueOf(bool) });
    return bool;
  }
  
  private void p()
  {
    if ((this.jdField_a_of_type_Abop == null) || (this.jdField_a_of_type_Abop.a() == null) || (!this.jdField_a_of_type_Abop.a().isValid()))
    {
      QLog.e("GdtMvViewController", 1, "doAdPreload error");
      return;
    }
    GdtAd localGdtAd = this.jdField_a_of_type_Abop.a();
    if (!localGdtAd.isHitPreloadCanvasJsonExp())
    {
      QLog.i("GdtMvViewController", 1, "not hitPreloadCanvasJsonExp");
      return;
    }
    abkw.a().a(localGdtAd);
  }
  
  private void q()
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
      this.jdField_a_of_type_Abpr = new abpr(this, null);
      IntentFilter localIntentFilter = new IntentFilter();
      localIntentFilter.addAction("android.media.RINGER_MODE_CHANGED");
      this.jdField_a_of_type_AndroidContentContext.registerReceiver(this.jdField_a_of_type_Abpr, localIntentFilter);
      this.jdField_a_of_type_Abpt = new abpt(this.jdField_a_of_type_AndroidContentContext);
      this.jdField_a_of_type_Abpt.a();
      this.jdField_a_of_type_Abpt.a(new abpj(this));
      return;
    }
  }
  
  private void r()
  {
    if ((this.jdField_a_of_type_Abpb != null) || (this.jdField_a_of_type_Abnz != null))
    {
      this.jdField_a_of_type_Abui = new abui(11);
      return;
    }
    QLog.i("GdtMvViewController", 1, " initReports error");
  }
  
  private void s()
  {
    this.jdField_a_of_type_Aboc = new aboc();
    this.jdField_a_of_type_Aboc.a(this.jdField_a_of_type_Abop, this.jdField_a_of_type_AndroidViewView, this.jdField_a_of_type_Abps.a(), this.jdField_b_of_type_Boolean);
  }
  
  private void t()
  {
    this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog = bfur.a(this.jdField_a_of_type_AndroidViewView.getContext(), 0, null, "", amtj.a(2131704341), amtj.a(2131704338), new abpk(this), new abpl(this));
    this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.setOnKeyListener(new abpm(this));
  }
  
  private void u()
  {
    boolean bool1 = true;
    qq_ad_get.QQAdGetRsp.AdInfo localAdInfo = this.jdField_a_of_type_Abop.a();
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
  
  private void v()
  {
    if (this.j)
    {
      QLog.i("GdtMvViewController", 1, "refreshVoiceIconDrawable isSilentMode is true");
      this.jdField_a_of_type_Boolean = true;
    }
    w();
  }
  
  private void w()
  {
    this.jdField_a_of_type_Abpf.a(this.jdField_a_of_type_AndroidViewView.getContext(), this.jdField_a_of_type_Boolean);
  }
  
  private void x()
  {
    Object localObject = this.jdField_a_of_type_Abop.a();
    URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
    localURLDrawableOptions.mLoadingDrawable = this.jdField_a_of_type_AndroidViewView.getResources().getDrawable(2130850605);
    localURLDrawableOptions.mFailedDrawable = this.jdField_a_of_type_AndroidViewView.getResources().getDrawable(2130850605);
    localObject = URLDrawable.getDrawable(((GdtMotiveVideoPageData)localObject).previewImgUrl, localURLDrawableOptions);
    ((URLDrawable)localObject).setDecodeHandler(bfol.n);
    ((URLDrawable)localObject).setTag(new int[] { 50 });
    if (this.jdField_a_of_type_AndroidWidgetImageView != null) {
      this.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable((Drawable)localObject);
    }
  }
  
  private void y()
  {
    QLog.i("VideoGdtGdtMvViewController", 1, "initVideoView");
    GdtMotiveVideoPageData localGdtMotiveVideoPageData = this.jdField_a_of_type_Abop.a();
    this.jdField_a_of_type_Abry.a(11);
    this.jdField_a_of_type_Amaj = new alzy();
    this.jdField_a_of_type_Amaj.a(this.jdField_a_of_type_AndroidViewView.getContext(), alvx.a());
    this.jdField_a_of_type_Amaj.a(this, 100L);
    View localView = this.jdField_a_of_type_Amaj.a();
    if ((localView == null) || (this.jdField_a_of_type_AndroidWidgetRelativeLayout == null))
    {
      QLog.i("VideoGdtGdtMvViewController", 1, "[setViewStatus], videoView is null." + this.jdField_a_of_type_AndroidWidgetRelativeLayout);
      return;
    }
    RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-1, -1);
    this.jdField_a_of_type_AndroidWidgetRelativeLayout.addView(localView, localLayoutParams);
    this.jdField_a_of_type_Amaj.a(localGdtMotiveVideoPageData.url, "sd", 0);
  }
  
  private void z()
  {
    if (azjl.a())
    {
      y();
      return;
    }
    A();
  }
  
  long a()
  {
    if (this.jdField_a_of_type_Amaj != null)
    {
      if (this.f) {
        return this.jdField_a_of_type_Long;
      }
      return this.jdField_a_of_type_Amaj.b();
    }
    return 0L;
  }
  
  public abps a()
  {
    return this.jdField_a_of_type_Abps;
  }
  
  public abry a()
  {
    return this.jdField_a_of_type_Abry;
  }
  
  public View a(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup)
  {
    u();
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
    q();
    v();
    c();
    x();
    z();
    E();
    t();
    r();
    s();
    this.jdField_a_of_type_Abpe.a(this.jdField_a_of_type_Abop);
    return paramLayoutInflater;
  }
  
  public void a()
  {
    QLog.i("GdtMvViewController", 1, " onClick close_ads");
    if (!d())
    {
      this.jdField_a_of_type_Abpe.a(4, a());
      this.jdField_a_of_type_Abps.a();
    }
  }
  
  public void a(int paramInt1, int paramInt2, int paramInt3, String paramString)
  {
    QLog.i("GdtMvViewController", 1, "[onVideoError], module:" + paramInt1 + ",errorType:" + paramInt2 + ",errorCode:" + paramInt3 + ",msg:" + paramString);
    paramString = this.jdField_a_of_type_Abop.a();
    if ((this.jdField_a_of_type_Abui != null) && (paramString != null))
    {
      this.jdField_a_of_type_Abry.a(paramInt2, paramInt3);
      this.jdField_a_of_type_Abui.a(paramString, this.jdField_a_of_type_Amaj.b(), this.jdField_a_of_type_Abry);
    }
  }
  
  public void a(long paramLong1, long paramLong2)
  {
    GdtVideoData localGdtVideoData = this.jdField_a_of_type_Abop.a();
    if (Looper.myLooper() != Looper.getMainLooper()) {
      this.jdField_a_of_type_Bjng.post(new GdtMvViewController.6(this, paramLong1, paramLong2));
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
      if ((!this.h) && (this.jdField_a_of_type_Abui != null) && (this.jdField_a_of_type_Amaj != null) && (localGdtVideoData != null))
      {
        this.h = true;
        this.jdField_a_of_type_Abui.a(localGdtVideoData, this.jdField_a_of_type_Amaj.b());
      }
      if ((this.jdField_a_of_type_Aboc == null) || (this.jdField_a_of_type_Amaj == null)) {
        break;
      }
      this.jdField_a_of_type_Aboc.a(this.jdField_a_of_type_Amaj.a() - this.jdField_a_of_type_Amaj.b());
      return;
      bool = false;
      break label60;
    }
  }
  
  public void a(String paramString)
  {
    GdtMotiveVideoPageData localGdtMotiveVideoPageData = this.jdField_a_of_type_Abop.a();
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
      this.jdField_a_of_type_Abps.a(-1, localIntent);
      D();
      return;
      if (this.jdField_a_of_type_Amaj != null)
      {
        localIntent.putExtra("elapsed_time", this.jdField_a_of_type_Amaj.b());
        a(localGdtMotiveVideoPageData, String.valueOf(this.jdField_a_of_type_Amaj.b()), String.valueOf(this.jdField_a_of_type_Long), String.valueOf(this.f));
        QLog.i("GdtMvViewController", 1, this.jdField_c_of_type_Boolean + "[beforeFinish] " + this.jdField_a_of_type_Amaj.b() + " /" + this.jdField_a_of_type_Long);
      }
    }
  }
  
  boolean a()
  {
    return this.jdField_a_of_type_Abpf.a();
  }
  
  public void b()
  {
    if (this.jdField_a_of_type_Amaj == null) {
      return;
    }
    this.jdField_a_of_type_Abpe.a(7, a());
    boolean bool2 = this.jdField_a_of_type_Amaj.a();
    boolean bool1;
    if (!bool2)
    {
      bool1 = true;
      this.jdField_a_of_type_Boolean = bool1;
      QLog.i("GdtMvViewController", 1, "audioSwitch click is called isSilentMode = " + this.j + ", isMute = " + bool2);
      this.jdField_a_of_type_Amaj.a(this.jdField_a_of_type_Boolean);
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
    this.jdField_a_of_type_Abpf.a(paramLong1, paramLong2);
  }
  
  boolean b()
  {
    return this.f;
  }
  
  public void c()
  {
    this.jdField_a_of_type_Abpf.a(this.jdField_a_of_type_AndroidViewView, this, this.jdField_a_of_type_Abop, this.jdField_a_of_type_Abpe);
    if (this.jdField_a_of_type_Abnz != null)
    {
      this.jdField_a_of_type_Abnz.a(this.jdField_a_of_type_Abps.a(), this.jdField_b_of_type_Boolean);
      return;
    }
    this.jdField_a_of_type_Abpf.a(this.jdField_a_of_type_Abps.a(), this.jdField_b_of_type_Boolean);
  }
  
  public boolean c()
  {
    if ((this.jdField_a_of_type_Abnz != null) && (this.jdField_a_of_type_Abnz.a())) {}
    while ((this.jdField_a_of_type_Aboc != null) && (this.jdField_a_of_type_Aboc.a())) {
      return true;
    }
    return d();
  }
  
  protected void d()
  {
    if ((this.jdField_a_of_type_Amaj != null) && (!this.jdField_a_of_type_Amaj.d()))
    {
      this.d = true;
      B();
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
        if ((this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog == null) || (this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.isShowing())) {
          break;
        }
        QLog.i("GdtMvViewController", 1, "showDialog mVideoDuration " + this.jdField_a_of_type_Long + " mShotSeconds " + this.jdField_b_of_type_Long + " mRewardText " + this.jdField_a_of_type_JavaLangString);
        Object localObject = new StringBuffer(amtj.a(2131692659));
        if (TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString))
        {
          ((StringBuffer)localObject).append(amtj.a(2131692655));
          QQCustomDialog localQQCustomDialog = this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog;
          if (this.jdField_a_of_type_Long > this.jdField_b_of_type_Long * 1000L)
          {
            localObject = amtj.a(2131704336) + this.jdField_b_of_type_Long + ((StringBuffer)localObject).toString();
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
        String str = amtj.a(2131704337);
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
      if (this.jdField_a_of_type_Bjng != null)
      {
        QLog.i("GdtMvViewController", 1, "[onVideoPrepared] send PREPARED msg");
        this.jdField_a_of_type_Bjng.obtainMessage(1).sendToTarget();
      }
    }
    while ((this.d) || (this.jdField_a_of_type_Amaj == null) || (this.jdField_a_of_type_Amaj.c())) {
      return;
    }
    QLog.i("GdtMvViewController", 1, "[onVideoPrepared] resume VideoPlayer again");
    f();
  }
  
  public void f()
  {
    if ((this.i) && (this.jdField_a_of_type_Amaj != null))
    {
      this.jdField_a_of_type_Amaj.a();
      if (this.jdField_a_of_type_Boolean) {
        break label42;
      }
    }
    label42:
    for (boolean bool = true;; bool = false)
    {
      a(bool);
      w();
      return;
    }
  }
  
  public void g()
  {
    QLog.i("GdtMvViewController", 1, "[onVideoCompletion]");
    GdtVideoData localGdtVideoData = this.jdField_a_of_type_Abop.a();
    this.e = false;
    this.f = true;
    this.jdField_c_of_type_Boolean = true;
    if (this.jdField_a_of_type_Bjng != null) {
      this.jdField_a_of_type_Bjng.obtainMessage(2).sendToTarget();
    }
    if ((this.jdField_a_of_type_Abui != null) && (localGdtVideoData != null)) {
      this.jdField_a_of_type_Abui.a(localGdtVideoData, this.jdField_a_of_type_Abry);
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
        } while (this.jdField_a_of_type_Amaj == null);
        C();
      } while (this.jdField_a_of_type_Amaj == null);
      paramMessage = this.jdField_a_of_type_Amaj;
      if ((this.jdField_a_of_type_Boolean) || (this.j)) {}
      for (boolean bool = true;; bool = false)
      {
        paramMessage.a(bool);
        this.jdField_a_of_type_Long = this.jdField_a_of_type_Amaj.a();
        QLog.i("GdtMvViewController", 1, "[mDuration]" + this.jdField_a_of_type_Long + ", mIsMute = " + this.jdField_a_of_type_Boolean + ", isSilentMode = " + this.j);
        this.jdField_a_of_type_Abop.a().setDurationMillis(this.jdField_a_of_type_Long);
        f();
        return false;
      }
    case 2: 
      QLog.i("GdtMvViewController", 1, "[onVideoCompletion]");
      if (this.jdField_a_of_type_Amaj != null) {
        this.jdField_a_of_type_Amaj.b(this);
      }
      b(0L, 0L);
      a(false);
      n();
      return false;
    }
    QLog.i("GdtMvViewController", 1, "[VIDEO_SDK_INSTALLED] initVideoView");
    y();
    return false;
  }
  
  public void i()
  {
    QLog.i("GdtMvViewController", 1, "[onVideoBufferEnd]");
  }
  
  public void j()
  {
    this.i = false;
    B();
    if (this.jdField_a_of_type_ComTencentAdTangramUtilAdExposureChecker != null) {
      this.jdField_a_of_type_ComTencentAdTangramUtilAdExposureChecker.onActivityPause();
    }
  }
  
  public void k()
  {
    this.i = true;
    QLog.i("GdtMvViewController", 1, "[onResume]" + this.d + " mIsVideoPlayCompleted " + this.f);
    if ((!this.d) && (!this.f) && (this.e)) {
      f();
    }
    if (this.jdField_a_of_type_Abpb != null) {
      this.jdField_a_of_type_Abpb.g();
    }
    if (this.jdField_a_of_type_Aboc != null) {
      this.jdField_a_of_type_Aboc.b();
    }
    abre.a(new abpq(this, null));
    if (this.jdField_a_of_type_ComTencentAdTangramUtilAdExposureChecker != null) {
      this.jdField_a_of_type_ComTencentAdTangramUtilAdExposureChecker.onActivityResume();
    }
  }
  
  public void l()
  {
    QLog.i("GdtMvViewController", 1, "[onDestroy]");
    if (this.jdField_a_of_type_Bjng != null) {
      this.jdField_a_of_type_Bjng.removeCallbacksAndMessages(null);
    }
    if (this.jdField_a_of_type_Abpt != null) {
      this.jdField_a_of_type_Abpt.b();
    }
    if (this.jdField_a_of_type_Amaj != null)
    {
      this.jdField_a_of_type_Amaj.b(this);
      this.jdField_a_of_type_Amaj.b();
      this.jdField_a_of_type_Amaj = null;
    }
    if (this.jdField_a_of_type_Abpb != null)
    {
      this.jdField_a_of_type_Abpb.e();
      this.jdField_a_of_type_Abpb = null;
    }
    if (this.jdField_a_of_type_Aboc != null) {
      this.jdField_a_of_type_Aboc.a(this.jdField_a_of_type_Abps.a(), this.l);
    }
    if (this.jdField_a_of_type_Abui != null) {
      this.jdField_a_of_type_Abui = null;
    }
    if ((this.jdField_a_of_type_AndroidContentContext != null) && (this.jdField_a_of_type_Abpr != null)) {
      this.jdField_a_of_type_AndroidContentContext.unregisterReceiver(this.jdField_a_of_type_Abpr);
    }
    this.jdField_a_of_type_AndroidContentContext = null;
    abrv.a().a();
    bhlx.a(BaseApplicationImpl.getApplication().getApplicationContext(), true, 55);
    if (this.jdField_a_of_type_ComTencentAdTangramUtilAdExposureChecker != null)
    {
      this.jdField_a_of_type_ComTencentAdTangramUtilAdExposureChecker.onActivityDestroy();
      this.jdField_a_of_type_ComTencentAdTangramUtilAdExposureChecker.setCallback(null);
    }
  }
  
  public void m()
  {
    QLog.i("GdtMvViewController", 1, "[onCreate]");
    bhlx.a(BaseApplicationImpl.getApplication().getApplicationContext(), false, 55);
  }
  
  protected void n()
  {
    if (this.jdField_a_of_type_Abnz != null) {
      this.jdField_a_of_type_Abnz.b();
    }
    do
    {
      return;
      a(1);
    } while (this.jdField_a_of_type_Aboc == null);
    this.jdField_a_of_type_Aboc.a(this.jdField_a_of_type_Abps.a(), this.jdField_a_of_type_Abop, this.jdField_b_of_type_Boolean);
  }
  
  public void o()
  {
    a("");
  }
  
  public void onClick(View paramView) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     abpi
 * JD-Core Version:    0.7.0.1
 */