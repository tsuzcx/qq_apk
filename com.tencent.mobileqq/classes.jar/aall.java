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
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.gdtad.api.motivevideo.GdtMotiveVideoPageData;
import com.tencent.gdtad.api.motivevideo.GdtMvViewController.6;
import com.tencent.gdtad.api.motivevideo.GdtMvViewController.8;
import com.tencent.gdtad.views.video.GdtVideoData;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.mediaplayer.api.TVK_SDKMgr;
import tencent.gdt.qq_ad_get.QQAdGetRsp.AdInfo;
import tencent.gdt.qq_ad_get.QQAdGetRsp.AdInfo.ExpInfo;

public class aall
  implements akvz, Handler.Callback, View.OnClickListener
{
  public int a;
  private long jdField_a_of_type_Long;
  private aakx jdField_a_of_type_Aakx;
  private aalj jdField_a_of_type_Aalj;
  private aals jdField_a_of_type_Aals;
  private aalt jdField_a_of_type_Aalt;
  private aalu jdField_a_of_type_Aalu;
  private aaqi jdField_a_of_type_Aaqi;
  private akwa jdField_a_of_type_Akwa;
  private Context jdField_a_of_type_AndroidContentContext;
  private AudioManager jdField_a_of_type_AndroidMediaAudioManager;
  private View jdField_a_of_type_AndroidViewView;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private LinearLayout jdField_a_of_type_AndroidWidgetLinearLayout;
  private RelativeLayout jdField_a_of_type_AndroidWidgetRelativeLayout;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private bdfq jdField_a_of_type_Bdfq;
  private bhow jdField_a_of_type_Bhow = new bhow(Looper.getMainLooper(), this);
  public boolean a;
  private int jdField_b_of_type_Int;
  private long jdField_b_of_type_Long = 15L;
  private ImageView jdField_b_of_type_AndroidWidgetImageView;
  private LinearLayout jdField_b_of_type_AndroidWidgetLinearLayout;
  private RelativeLayout jdField_b_of_type_AndroidWidgetRelativeLayout;
  private TextView jdField_b_of_type_AndroidWidgetTextView;
  private boolean jdField_b_of_type_Boolean;
  private long jdField_c_of_type_Long;
  private ImageView jdField_c_of_type_AndroidWidgetImageView;
  private TextView jdField_c_of_type_AndroidWidgetTextView;
  private boolean jdField_c_of_type_Boolean;
  private ImageView jdField_d_of_type_AndroidWidgetImageView;
  private boolean jdField_d_of_type_Boolean;
  private boolean e;
  private boolean f;
  private boolean g;
  private boolean h;
  private boolean i;
  private boolean j;
  private boolean k = true;
  private boolean l;
  private boolean m = true;
  
  public aall(aalt paramaalt, aakx paramaakx, boolean paramBoolean)
  {
    this.jdField_a_of_type_Boolean = false;
    this.jdField_a_of_type_Int = 0;
    this.jdField_a_of_type_Aalt = paramaalt;
    this.jdField_a_of_type_Aakx = paramaakx;
    this.l = paramBoolean;
    paramaalt = this.jdField_a_of_type_Aakx.a();
    paramaalt.style = 0;
    if (paramaalt.screenOrientation == 1) {}
    for (paramBoolean = bool;; paramBoolean = false)
    {
      this.jdField_b_of_type_Boolean = paramBoolean;
      int n = paramaalt.getVideoCountDown();
      this.jdField_b_of_type_Long = n;
      paramBoolean = this.jdField_a_of_type_Aakx.a().exp_info.video_countdown_style.has();
      this.jdField_b_of_type_Int = this.jdField_a_of_type_Aakx.a().exp_info.video_countdown_style.get();
      aanp.a("GdtMvViewController", "GdtMvViewController: video_countdown = " + n + ", countDownStyle = " + this.jdField_b_of_type_Int + ", video_countdown_style has = " + paramBoolean);
      return;
    }
  }
  
  private void a(int paramInt)
  {
    if (SystemClock.uptimeMillis() - this.jdField_c_of_type_Long < 800L) {}
    while ((paramInt == this.jdField_a_of_type_Int) || (this.jdField_a_of_type_Aalj == null)) {
      return;
    }
    this.jdField_a_of_type_Int = paramInt;
    this.jdField_c_of_type_Long = SystemClock.uptimeMillis();
    this.jdField_a_of_type_Aalj.a(paramInt);
  }
  
  private void a(int paramInt, boolean paramBoolean1, boolean paramBoolean2)
  {
    boolean bool = true;
    aanp.a("GdtMvViewController", "setVoiceIconState volume =" + paramInt + " mVideoPlayer " + this.jdField_a_of_type_Akwa + " isFromVolumeChanged = " + paramBoolean2 + ", mIsMute = " + this.jdField_a_of_type_Boolean + ", viewResumed = " + paramBoolean1 + ", mIsVideoPlayCompleted = " + this.f);
    if ((!paramBoolean1) || (this.jdField_a_of_type_Akwa == null)) {}
    do
    {
      return;
      if ((paramInt <= 0) || ((this.jdField_a_of_type_Akwa.a()) && (!paramBoolean2))) {
        break;
      }
      this.jdField_a_of_type_Boolean = false;
      q();
      this.jdField_a_of_type_Akwa.a(this.jdField_a_of_type_Boolean);
    } while (this.f);
    if (!this.jdField_a_of_type_Boolean) {}
    for (paramBoolean1 = bool;; paramBoolean1 = false)
    {
      a(paramBoolean1);
      return;
      this.jdField_a_of_type_Boolean = true;
      p();
      break;
    }
  }
  
  private void a(Context paramContext)
  {
    try
    {
      TVK_SDKMgr.installPlugin(paramContext, new aalq(this));
      return;
    }
    catch (Throwable paramContext)
    {
      aanp.d("GdtMvViewController", "installSDK t==" + paramContext.toString());
    }
  }
  
  private void a(View paramView)
  {
    GdtVideoData localGdtVideoData = this.jdField_a_of_type_Aakx.a();
    if ((this.m) && (paramView != null))
    {
      this.m = false;
      paramView.setTag(2131379911, localGdtVideoData.getAd());
      paramView.setTag(2131379910, new aalr(this));
      aanp.a("GdtMvViewController", "initExpoReport");
      aany.a().a(paramView);
    }
  }
  
  private void a(GdtMotiveVideoPageData paramGdtMotiveVideoPageData, String paramString1, String paramString2, String paramString3)
  {
    aanm localaanm = (aanm)aaml.a().a(16);
    if (localaanm != null) {
      localaanm.a(paramGdtMotiveVideoPageData, paramString1, paramString2, paramString3);
    }
  }
  
  private void a(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_AndroidMediaAudioManager != null)
    {
      if (paramBoolean)
      {
        aanp.a("GdtMvViewController", "[requestSystemAudioFocus] gain is called!");
        this.jdField_a_of_type_AndroidMediaAudioManager.requestAudioFocus(null, 3, 2);
      }
    }
    else {
      return;
    }
    aanp.a("GdtMvViewController", "[requestSystemAudioFocus] release is called!");
    this.jdField_a_of_type_AndroidMediaAudioManager.abandonAudioFocus(null);
  }
  
  private View b(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup)
  {
    for (;;)
    {
      try
      {
        GdtMotiveVideoPageData localGdtMotiveVideoPageData = this.jdField_a_of_type_Aakx.a();
        if (this.jdField_b_of_type_Boolean)
        {
          if (localGdtMotiveVideoPageData.vSize == 585)
          {
            this.jdField_a_of_type_AndroidViewView = paramLayoutInflater.inflate(2131559149, paramViewGroup, false);
            if (this.jdField_a_of_type_AndroidViewView != null) {
              break;
            }
            return null;
          }
          this.jdField_a_of_type_AndroidViewView = paramLayoutInflater.inflate(2131559148, paramViewGroup, false);
          continue;
        }
        this.jdField_a_of_type_AndroidViewView = paramLayoutInflater.inflate(2131559147, paramViewGroup, false);
      }
      catch (Exception paramLayoutInflater)
      {
        aanp.d("GdtMvViewController", " viewcontr initViews error", paramLayoutInflater);
        return null;
      }
    }
    this.jdField_a_of_type_Aalj = new aalj(this, this.jdField_a_of_type_AndroidViewView, this.jdField_a_of_type_Aakx);
    aapa.a(this.jdField_a_of_type_AndroidViewView.findViewById(2131371150));
    this.jdField_a_of_type_Aalj.a();
    if (this.jdField_b_of_type_Int == 0)
    {
      this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131364330));
      this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131362141));
      this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)this.jdField_a_of_type_AndroidViewView.findViewById(2131364332));
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(0);
      o();
      this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131362881));
      this.jdField_a_of_type_AndroidWidgetTextView.setOnClickListener(this);
      this.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(this);
    }
    for (;;)
    {
      this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131362040));
      this.jdField_b_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)this.jdField_a_of_type_AndroidViewView.findViewById(2131379668));
      this.jdField_b_of_type_AndroidWidgetRelativeLayout.setOnClickListener(this);
      return this.jdField_a_of_type_AndroidViewView;
      if (this.jdField_b_of_type_Int == 1)
      {
        this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)this.jdField_a_of_type_AndroidViewView.findViewById(2131367083));
        this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131364873));
        this.jdField_b_of_type_AndroidWidgetLinearLayout = ((LinearLayout)this.jdField_a_of_type_AndroidViewView.findViewById(2131367088));
        this.jdField_b_of_type_AndroidWidgetLinearLayout.setVisibility(0);
        o();
        this.jdField_c_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131362882));
        this.jdField_d_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131364331));
        this.jdField_d_of_type_AndroidWidgetImageView.setOnClickListener(this);
        this.jdField_c_of_type_AndroidWidgetImageView.setOnClickListener(this);
      }
    }
  }
  
  private void b(boolean paramBoolean)
  {
    if ((this.jdField_a_of_type_Aalj != null) && (paramBoolean)) {
      this.jdField_a_of_type_Aalj.c();
    }
  }
  
  private void j()
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
      this.jdField_a_of_type_Aals = new aals(this, null);
      IntentFilter localIntentFilter = new IntentFilter();
      localIntentFilter.addAction("android.media.RINGER_MODE_CHANGED");
      this.jdField_a_of_type_AndroidContentContext.registerReceiver(this.jdField_a_of_type_Aals, localIntentFilter);
      this.jdField_a_of_type_Aalu = new aalu(this.jdField_a_of_type_AndroidContentContext);
      this.jdField_a_of_type_Aalu.a();
      this.jdField_a_of_type_Aalu.a(new aalm(this));
      return;
    }
  }
  
  private void k()
  {
    if (this.jdField_a_of_type_Aalj != null)
    {
      this.jdField_a_of_type_Aaqi = new aaqi(11);
      return;
    }
    aanp.d("GdtMvViewController", " initReports error");
  }
  
  private void l()
  {
    Context localContext = this.jdField_a_of_type_AndroidViewView.getContext();
    if (this.jdField_a_of_type_Long > this.jdField_b_of_type_Long * 1000L) {}
    for (String str = alpo.a(2131705590) + this.jdField_b_of_type_Long + alpo.a(2131705591);; str = alpo.a(2131705595))
    {
      this.jdField_a_of_type_Bdfq = bdcd.a(localContext, 0, null, str, alpo.a(2131705597), alpo.a(2131705594), new aaln(this), new aalo(this));
      this.jdField_a_of_type_Bdfq.setOnKeyListener(new aalp(this));
      return;
    }
  }
  
  private void m()
  {
    if (this.j)
    {
      aanp.d("GdtMvViewController", "refreshVoiceIconDrawable isSilentMode is true");
      this.jdField_a_of_type_Boolean = true;
    }
    n();
  }
  
  private void n()
  {
    if (this.jdField_b_of_type_Int == 0) {
      if (this.jdField_a_of_type_Boolean) {
        this.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(this.jdField_a_of_type_AndroidViewView.getContext().getResources().getDrawable(2130838374));
      }
    }
    while (this.jdField_b_of_type_Int != 1)
    {
      return;
      this.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(this.jdField_a_of_type_AndroidViewView.getContext().getResources().getDrawable(2130838375));
      return;
    }
    if (this.jdField_a_of_type_Boolean)
    {
      this.jdField_c_of_type_AndroidWidgetImageView.setImageDrawable(this.jdField_a_of_type_AndroidViewView.getContext().getResources().getDrawable(2130838374));
      this.jdField_c_of_type_AndroidWidgetImageView.setContentDescription(this.jdField_a_of_type_AndroidViewView.getContext().getResources().getString(2131693072));
      return;
    }
    this.jdField_c_of_type_AndroidWidgetImageView.setImageDrawable(this.jdField_a_of_type_AndroidViewView.getContext().getResources().getDrawable(2130838375));
    this.jdField_c_of_type_AndroidWidgetImageView.setContentDescription(this.jdField_a_of_type_AndroidViewView.getContext().getResources().getString(2131693071));
  }
  
  private void o()
  {
    if (this.jdField_b_of_type_Boolean)
    {
      if (this.jdField_b_of_type_Int != 0) {
        break label57;
      }
      localLayoutParams = (RelativeLayout.LayoutParams)this.jdField_a_of_type_AndroidWidgetRelativeLayout.getLayoutParams();
      localLayoutParams.topMargin += 0;
      localLayoutParams = (RelativeLayout.LayoutParams)this.jdField_b_of_type_AndroidWidgetTextView.getLayoutParams();
      localLayoutParams.topMargin += 0;
    }
    label57:
    while (this.jdField_b_of_type_Int != 1) {
      return;
    }
    RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)this.jdField_b_of_type_AndroidWidgetLinearLayout.getLayoutParams();
    localLayoutParams.topMargin += 0;
    localLayoutParams = (RelativeLayout.LayoutParams)this.jdField_a_of_type_AndroidWidgetLinearLayout.getLayoutParams();
    localLayoutParams.topMargin += 0;
  }
  
  private void p()
  {
    if (this.jdField_b_of_type_Int == 0)
    {
      this.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(this.jdField_a_of_type_AndroidViewView.getContext().getResources().getDrawable(2130838374));
      return;
    }
    this.jdField_c_of_type_AndroidWidgetImageView.setImageDrawable(this.jdField_a_of_type_AndroidViewView.getContext().getResources().getDrawable(2130838374));
    this.jdField_c_of_type_AndroidWidgetImageView.setContentDescription(this.jdField_a_of_type_AndroidViewView.getContext().getResources().getString(2131693072));
  }
  
  private void q()
  {
    if (this.jdField_b_of_type_Int == 0)
    {
      this.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(this.jdField_a_of_type_AndroidViewView.getContext().getResources().getDrawable(2130838375));
      return;
    }
    this.jdField_c_of_type_AndroidWidgetImageView.setImageDrawable(this.jdField_a_of_type_AndroidViewView.getContext().getResources().getDrawable(2130838375));
    this.jdField_c_of_type_AndroidWidgetImageView.setContentDescription(this.jdField_a_of_type_AndroidViewView.getContext().getResources().getString(2131693071));
  }
  
  private void r()
  {
    Object localObject = this.jdField_a_of_type_Aakx.a();
    URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
    localURLDrawableOptions.mLoadingDrawable = this.jdField_a_of_type_AndroidViewView.getResources().getDrawable(2130849999);
    localURLDrawableOptions.mFailedDrawable = this.jdField_a_of_type_AndroidViewView.getResources().getDrawable(2130849999);
    localObject = URLDrawable.getDrawable(((GdtMotiveVideoPageData)localObject).previewImgUrl, localURLDrawableOptions);
    ((URLDrawable)localObject).setDecodeHandler(bcuq.m);
    ((URLDrawable)localObject).setTag(new int[] { 50 });
    this.jdField_b_of_type_AndroidWidgetImageView.setImageDrawable((Drawable)localObject);
  }
  
  private void s()
  {
    aanp.b("GdtMvViewController", "initVideoView");
    GdtMotiveVideoPageData localGdtMotiveVideoPageData = this.jdField_a_of_type_Aakx.a();
    this.jdField_a_of_type_Akwa = new akvr();
    this.jdField_a_of_type_Akwa.a(this.jdField_a_of_type_AndroidViewView.getContext(), akro.a());
    this.jdField_a_of_type_Akwa.a(this, 100L);
    View localView = this.jdField_a_of_type_Akwa.a();
    if ((localView == null) || (this.jdField_b_of_type_AndroidWidgetRelativeLayout == null))
    {
      aanp.d("GdtMvViewController", "[setViewStatus], videoView is null." + this.jdField_b_of_type_AndroidWidgetRelativeLayout);
      return;
    }
    RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-1, -1);
    this.jdField_b_of_type_AndroidWidgetRelativeLayout.addView(localView, localLayoutParams);
    this.jdField_a_of_type_Akwa.a(localGdtMotiveVideoPageData.url, "sd", 0);
  }
  
  private void t()
  {
    TVK_SDKMgr.initSdk(this.jdField_a_of_type_AndroidViewView.getContext(), "qlZy1cUgJFUcdIxwLCxe2Bwl2Iy1G1W1Scj0JYW0q2gNAn3XAYvu6kgSaMFDI+caBVR6jDCu/2+MMP/ 5+bNIv+d+bn4ihMBUKcpWIDySGIAv7rlarJXCev4i7a0qQD2f3s6vtdD9YdQ81ZyeA+nD0MenBGrPPd GeDBvIFQSGz4jB4m6G4fa2abCqy1JQc+r+OGk6hVJQXMGpROgPiIGlF3o/sHuBblmfwvIDtYviSIKD4 UGd0IeJn/IqVI3vUZ3ETgea6FkqDoA00SrTlTYfJUJk/h2lk1rkibIkQMPZhVjI2HYDxV4y501Xj2vD fjFPoNJImVtMjdE2BIIEawxYKA==", "");
    if (TVK_SDKMgr.isInstalled(this.jdField_a_of_type_AndroidViewView.getContext()))
    {
      s();
      return;
    }
    a(this.jdField_a_of_type_AndroidViewView.getContext());
  }
  
  private void u()
  {
    if ((this.i) && (this.jdField_a_of_type_Akwa != null))
    {
      this.jdField_a_of_type_Akwa.a();
      if (this.jdField_a_of_type_Boolean) {
        break label42;
      }
    }
    label42:
    for (boolean bool = true;; bool = false)
    {
      a(bool);
      n();
      return;
    }
  }
  
  private void v()
  {
    aanp.b("GdtMvViewController", "[doPauseAction] mIsVideoPlayCompleted:" + this.f);
    GdtVideoData localGdtVideoData = this.jdField_a_of_type_Aakx.a();
    a(false);
    if ((!this.f) && (this.jdField_a_of_type_Akwa != null))
    {
      this.h = false;
      this.jdField_a_of_type_Akwa.b();
      if ((this.jdField_a_of_type_Aaqi != null) && (localGdtVideoData != null)) {
        this.jdField_a_of_type_Aaqi.b(localGdtVideoData, this.jdField_a_of_type_Akwa.b());
      }
    }
  }
  
  private void w()
  {
    if ((this.jdField_a_of_type_Akwa == null) || (this.jdField_b_of_type_AndroidWidgetRelativeLayout == null)) {
      return;
    }
    GdtMotiveVideoPageData localGdtMotiveVideoPageData = this.jdField_a_of_type_Aakx.a();
    this.jdField_b_of_type_AndroidWidgetRelativeLayout.setVisibility(0);
    a(this.jdField_b_of_type_AndroidWidgetRelativeLayout);
    RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)this.jdField_b_of_type_AndroidWidgetRelativeLayout.getLayoutParams();
    int i2 = this.jdField_a_of_type_Akwa.a();
    int i3 = this.jdField_a_of_type_Akwa.b();
    int n;
    if (this.jdField_b_of_type_Boolean)
    {
      n = aapa.f(this.jdField_a_of_type_AndroidContentContext);
      label88:
      if (!this.jdField_b_of_type_Boolean) {
        break label318;
      }
    }
    label318:
    for (int i1 = aapa.e(this.jdField_a_of_type_AndroidContentContext);; i1 = aapa.f(this.jdField_a_of_type_AndroidContentContext))
    {
      aanp.b("GdtMvViewController", "[VIDEO_PREPARED] mVideoSize " + this.jdField_b_of_type_Boolean + " vW-" + i2 + " vH-" + i3);
      aanp.b("GdtMvViewController", "[VIDEO_PREPARED] mIsPortait " + this.jdField_b_of_type_Boolean + " sW-" + n + " sH-" + i1);
      if ((!this.jdField_b_of_type_Boolean) || (localGdtMotiveVideoPageData.vSize == 585)) {
        break;
      }
      i2 = (int)(1.0F * n * i3 / i2);
      i1 = (int)(i1 * 150.0F / 1334.0F);
      localLayoutParams.height = i2;
      localLayoutParams.width = n;
      localLayoutParams.topMargin = i1;
      aanp.b("GdtMvViewController", "[VIDEO_PREPARED] newHeight " + i2 + " newWidth-" + n + " newTop-" + i1);
      return;
      n = aapa.e(this.jdField_a_of_type_AndroidContentContext);
      break label88;
    }
  }
  
  private void x()
  {
    if (this.l)
    {
      e();
      g();
    }
  }
  
  private void y()
  {
    if (this.jdField_a_of_type_Aalj != null) {
      this.jdField_a_of_type_Aalj.b();
    }
  }
  
  private void z()
  {
    if (this.jdField_a_of_type_Bhow != null) {
      this.jdField_a_of_type_Bhow.post(new GdtMvViewController.8(this));
    }
  }
  
  long a()
  {
    if (this.jdField_a_of_type_Akwa != null)
    {
      if (this.f) {
        return this.jdField_a_of_type_Long;
      }
      return this.jdField_a_of_type_Akwa.b();
    }
    return 0L;
  }
  
  public aalt a()
  {
    return this.jdField_a_of_type_Aalt;
  }
  
  public View a(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup)
  {
    paramLayoutInflater = b(paramLayoutInflater, paramViewGroup);
    if (paramLayoutInflater == null)
    {
      aanp.d("GdtMvViewController", "GdtMvViewController init:rootView==null error");
      return null;
    }
    this.jdField_a_of_type_AndroidContentContext = paramLayoutInflater.getContext();
    aanp.a("GdtMvViewController", "GdtMvViewController: init = " + this.l + ", mContext = " + this.jdField_a_of_type_AndroidContentContext);
    this.jdField_a_of_type_AndroidMediaAudioManager = ((AudioManager)this.jdField_a_of_type_AndroidContentContext.getSystemService("audio"));
    if (((this.jdField_a_of_type_AndroidContentContext instanceof Activity)) && (!this.l)) {
      ((Activity)this.jdField_a_of_type_AndroidContentContext).setVolumeControlStream(3);
    }
    j();
    m();
    r();
    t();
    y();
    l();
    k();
    return paramLayoutInflater;
  }
  
  public void a()
  {
    aanp.a("GdtMvViewController", "[onVideoPrepared]");
    if (!this.e)
    {
      this.e = true;
      if (this.jdField_a_of_type_Bhow != null)
      {
        aanp.a("GdtMvViewController", "[onVideoPrepared] send PREPARED msg");
        this.jdField_a_of_type_Bhow.obtainMessage(1).sendToTarget();
      }
    }
    while ((this.jdField_d_of_type_Boolean) || (this.jdField_a_of_type_Akwa == null) || (this.jdField_a_of_type_Akwa.c())) {
      return;
    }
    aanp.a("GdtMvViewController", "[onVideoPrepared] resume VideoPlayer again");
    u();
  }
  
  public void a(int paramInt1, int paramInt2, String paramString)
  {
    QLog.w("GdtMvViewController", 1, "[onVideoError], result:" + paramInt1 + ",code:" + paramInt2 + ",msg:" + paramString);
    paramString = this.jdField_a_of_type_Aakx.a();
    if ((this.jdField_a_of_type_Aaqi != null) && (paramString != null)) {
      this.jdField_a_of_type_Aaqi.a(paramString);
    }
  }
  
  public void a(long paramLong1, long paramLong2)
  {
    GdtVideoData localGdtVideoData = this.jdField_a_of_type_Aakx.a();
    if (Looper.myLooper() != Looper.getMainLooper()) {
      this.jdField_a_of_type_Bhow.post(new GdtMvViewController.6(this, paramLong1, paramLong2));
    }
    while (this.f) {
      return;
    }
    boolean bool;
    label60:
    long l3;
    label80:
    long l1;
    if (paramLong2 < this.jdField_b_of_type_Long * 1000L)
    {
      bool = true;
      this.g = bool;
      l3 = paramLong2 - paramLong1;
      if (!this.g) {
        break label269;
      }
      paramLong2 = paramLong1;
      long l2 = paramLong2 / 1000L + 1L;
      l1 = l2;
      if (l2 > this.jdField_b_of_type_Long) {
        l1 = this.jdField_b_of_type_Long;
      }
      if (paramLong2 <= 0L) {
        break label331;
      }
      if (this.jdField_b_of_type_Int != 0) {
        break label284;
      }
      this.jdField_b_of_type_AndroidWidgetTextView.setText(alpo.a(2131705598) + l1 + "s");
      this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
    }
    for (;;)
    {
      if (paramLong2 <= 0L) {
        this.jdField_c_of_type_Boolean = true;
      }
      if (l3 / 1000L == 2L) {
        b(true);
      }
      if (paramLong1 / 1000L == 3L) {
        b(false);
      }
      if ((this.h) || (this.jdField_a_of_type_Aaqi == null) || (this.jdField_a_of_type_Akwa == null) || (localGdtVideoData == null)) {
        break;
      }
      this.h = true;
      this.jdField_a_of_type_Aaqi.a(localGdtVideoData, this.jdField_a_of_type_Akwa.b());
      return;
      bool = false;
      break label60;
      label269:
      paramLong2 = this.jdField_b_of_type_Long * 1000L - l3;
      break label80;
      label284:
      if (this.jdField_b_of_type_Int == 1)
      {
        this.jdField_c_of_type_AndroidWidgetTextView.setText(String.format(alpo.a(2131693070), new Object[] { Long.valueOf(l1) }));
        this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(0);
        continue;
        label331:
        if (this.jdField_b_of_type_Int == 0)
        {
          this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(4);
        }
        else if (this.jdField_b_of_type_Int == 1)
        {
          this.jdField_c_of_type_AndroidWidgetTextView.setText(alpo.a(2131693069));
          this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(0);
        }
      }
    }
  }
  
  public void a(String paramString)
  {
    GdtMotiveVideoPageData localGdtMotiveVideoPageData = this.jdField_a_of_type_Aakx.a();
    aanp.a("GdtMvViewController", "GDT beforeFinish call stack:", new Throwable());
    Intent localIntent = new Intent();
    localIntent.putExtra("duration_time", this.jdField_a_of_type_Long);
    localIntent.putExtra("elapsed_time", this.jdField_a_of_type_Long);
    localIntent.putExtra("profitable_flag", this.jdField_c_of_type_Boolean);
    localIntent.putExtra("is_end", this.f);
    if (this.f)
    {
      a(localGdtMotiveVideoPageData, String.valueOf(this.jdField_a_of_type_Long), String.valueOf(this.jdField_a_of_type_Long), String.valueOf(this.f));
      aanp.b("GdtMvViewController", "true[beforeFinish] " + this.jdField_a_of_type_Long + " /" + this.jdField_a_of_type_Long);
    }
    for (;;)
    {
      if (!TextUtils.isEmpty(paramString)) {
        localIntent.putExtra("arg_callback", paramString);
      }
      this.jdField_a_of_type_Aalt.a(-1, localIntent);
      x();
      return;
      if (this.jdField_a_of_type_Akwa != null)
      {
        localIntent.putExtra("elapsed_time", this.jdField_a_of_type_Akwa.b());
        a(localGdtMotiveVideoPageData, String.valueOf(this.jdField_a_of_type_Akwa.b()), String.valueOf(this.jdField_a_of_type_Long), String.valueOf(this.f));
        aanp.b("GdtMvViewController", this.jdField_c_of_type_Boolean + "[beforeFinish] " + this.jdField_a_of_type_Akwa.b() + " /" + this.jdField_a_of_type_Long);
      }
    }
  }
  
  boolean a()
  {
    return ((this.jdField_a_of_type_AndroidWidgetRelativeLayout != null) && (this.jdField_a_of_type_AndroidWidgetRelativeLayout.getVisibility() == 0)) || ((this.jdField_d_of_type_AndroidWidgetImageView != null) && (this.jdField_d_of_type_AndroidWidgetImageView.getVisibility() == 0));
  }
  
  public void b()
  {
    GdtVideoData localGdtVideoData = this.jdField_a_of_type_Aakx.a();
    this.e = false;
    this.f = true;
    this.jdField_c_of_type_Boolean = true;
    if (this.jdField_a_of_type_Bhow != null) {
      this.jdField_a_of_type_Bhow.obtainMessage(2).sendToTarget();
    }
    if ((this.jdField_a_of_type_Aaqi != null) && (localGdtVideoData != null)) {
      this.jdField_a_of_type_Aaqi.b(localGdtVideoData);
    }
  }
  
  boolean b()
  {
    return this.f;
  }
  
  public void c()
  {
    if (QLog.isColorLevel()) {
      QLog.d("GdtMvViewController", 2, "[onVideoBufferStart]");
    }
  }
  
  public boolean c()
  {
    aanp.a("GdtMvViewController", "[onBackEvent] mHasWatchAds " + this.jdField_c_of_type_Boolean);
    try
    {
      if (this.jdField_c_of_type_Boolean) {
        return false;
      }
      if ((this.jdField_a_of_type_Akwa != null) && (!this.jdField_a_of_type_Akwa.d()))
      {
        this.jdField_d_of_type_Boolean = true;
        v();
      }
      if ((this.jdField_a_of_type_Bdfq != null) && (!this.jdField_a_of_type_Bdfq.isShowing()))
      {
        aanp.a("GdtMvViewController", "mVideoDuration " + this.jdField_a_of_type_Long + " mShotSeconds " + this.jdField_b_of_type_Long);
        bdfq localbdfq = this.jdField_a_of_type_Bdfq;
        if (this.jdField_a_of_type_Long > this.jdField_b_of_type_Long * 1000L) {}
        for (Object localObject = alpo.a(2131705592) + this.jdField_b_of_type_Long + alpo.a(2131705596);; localObject = alpo.a(2131705593))
        {
          localbdfq.setMessage((CharSequence)localObject);
          this.jdField_a_of_type_Bdfq.show();
          localObject = this.jdField_a_of_type_Bdfq.getWindow();
          if (localObject == null) {
            break;
          }
          ((Window)localObject).getDecorView().setSystemUiVisibility(7942);
          break;
        }
      }
      return true;
    }
    catch (Throwable localThrowable)
    {
      aanp.d("GdtMvViewController", "show dialog err, errInfo->" + localThrowable.getMessage());
      return false;
    }
  }
  
  public void d()
  {
    if (QLog.isColorLevel()) {
      QLog.d("GdtMvViewController", 2, "[onVideoBufferEnd]");
    }
  }
  
  public void e()
  {
    this.i = false;
    v();
  }
  
  public void f()
  {
    this.i = true;
    aanp.b("GdtMvViewController", "[onResume]" + this.jdField_d_of_type_Boolean + " mIsVideoPlayCompleted " + this.f);
    if ((!this.jdField_d_of_type_Boolean) && (!this.f) && (this.e)) {
      u();
    }
    if (this.jdField_a_of_type_Aalj != null) {
      this.jdField_a_of_type_Aalj.g();
    }
  }
  
  public void g()
  {
    aanp.b("GdtMvViewController", "[onDestroy]");
    if (this.jdField_a_of_type_Bhow != null) {
      this.jdField_a_of_type_Bhow.removeCallbacksAndMessages(null);
    }
    if (this.jdField_a_of_type_Aalu != null) {
      this.jdField_a_of_type_Aalu.b();
    }
    if (this.jdField_a_of_type_Akwa != null)
    {
      this.jdField_a_of_type_Akwa.b(this);
      this.jdField_a_of_type_Akwa.b();
      this.jdField_a_of_type_Akwa = null;
    }
    if (this.jdField_a_of_type_Aalj != null)
    {
      this.jdField_a_of_type_Aalj.e();
      this.jdField_a_of_type_Aalj = null;
    }
    if (this.jdField_a_of_type_Aaqi != null) {
      this.jdField_a_of_type_Aaqi = null;
    }
    if ((this.jdField_a_of_type_AndroidContentContext != null) && (this.jdField_a_of_type_Aals != null)) {
      this.jdField_a_of_type_AndroidContentContext.unregisterReceiver(this.jdField_a_of_type_Aals);
    }
    this.jdField_a_of_type_AndroidContentContext = null;
    aany.a().a();
    betl.a(BaseApplicationImpl.getApplication().getApplicationContext(), true, 55);
  }
  
  public void h()
  {
    betl.a(BaseApplicationImpl.getApplication().getApplicationContext(), false, 55);
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    boolean bool2 = true;
    switch (paramMessage.what)
    {
    default: 
    case 1: 
      do
      {
        do
        {
          return false;
        } while (this.jdField_a_of_type_Akwa == null);
        w();
      } while (this.jdField_a_of_type_Akwa == null);
      paramMessage = this.jdField_a_of_type_Akwa;
      boolean bool1 = bool2;
      if (!this.jdField_a_of_type_Boolean) {
        if (!this.j) {
          break label168;
        }
      }
      for (bool1 = bool2;; bool1 = false)
      {
        paramMessage.a(bool1);
        this.jdField_a_of_type_Long = this.jdField_a_of_type_Akwa.a();
        aanp.a("GdtMvViewController", "[mDuration]" + this.jdField_a_of_type_Long + ", mIsMute = " + this.jdField_a_of_type_Boolean + ", isSilentMode = " + this.j);
        this.jdField_a_of_type_Aakx.a().setDurationMillis(this.jdField_a_of_type_Long);
        u();
        return false;
      }
    case 2: 
      label168:
      aanp.b("GdtMvViewController", "[onVideoCompletion]");
      if (this.jdField_a_of_type_Akwa != null) {
        this.jdField_a_of_type_Akwa.b(this);
      }
      if (this.jdField_b_of_type_Int == 0) {
        this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(4);
      }
      for (;;)
      {
        a(false);
        a(1);
        return false;
        this.jdField_c_of_type_AndroidWidgetTextView.setText(alpo.a(2131693069));
        this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(0);
      }
    }
    aanp.b("GdtMvViewController", "[VIDEO_SDK_INSTALLED] initVideoView");
    s();
    return false;
  }
  
  public void i()
  {
    a("");
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    }
    do
    {
      do
      {
        return;
        aanp.b("GdtMvViewController", " onClick close_ads");
      } while (c());
      this.jdField_a_of_type_Aalt.a();
      return;
    } while (this.jdField_a_of_type_Akwa == null);
    boolean bool2 = this.jdField_a_of_type_Akwa.a();
    boolean bool1;
    if (!bool2)
    {
      bool1 = true;
      this.jdField_a_of_type_Boolean = bool1;
      aanp.a("GdtMvViewController", "audioSwitch click is called isSilentMode = " + this.j + ", isMute = " + bool2);
      this.jdField_a_of_type_Akwa.a(this.jdField_a_of_type_Boolean);
      if (!this.jdField_a_of_type_Boolean) {
        break label178;
      }
    }
    label178:
    for (int n = 0;; n = 1)
    {
      a(n, true, false);
      return;
      bool1 = false;
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aall
 * JD-Core Version:    0.7.0.1
 */