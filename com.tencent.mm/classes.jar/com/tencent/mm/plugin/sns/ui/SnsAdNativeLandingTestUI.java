package com.tencent.mm.plugin.sns.ui;

import android.content.res.Resources;
import android.os.Bundle;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.mm.plugin.sight.decode.ui.SnsAdNativeLandingPagesVideoPlayerLoadingBar;
import com.tencent.mm.plugin.sns.i.d;
import com.tencent.mm.plugin.sns.i.f;
import com.tencent.mm.plugin.sns.i.g;
import com.tencent.mm.plugin.sns.model.af;
import com.tencent.mm.pluginsdk.ui.tools.VideoSightView;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.b;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.s;
import java.io.File;

public class SnsAdNativeLandingTestUI
  extends MMActivity
{
  private ah dPi = new ah();
  private int duration = 0;
  private int oHM;
  private VideoSightView oVe;
  SnsAdNativeLandingPagesVideoPlayerLoadingBar oVf;
  private double ogg = 0.0D;
  private int videoHeight;
  private int videoWidth;
  
  protected final int getLayoutId()
  {
    return i.g.sns_ad_native_landing_pages_test_ui;
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    this.mController.hideTitleView();
    getWindow().setFlags(1024, 1024);
    ((Button)findViewById(i.f.sns_ad_native_landing_pages_test_share_btn)).setOnClickListener(new SnsAdNativeLandingTestUI.1(this));
    paramBundle = (ViewGroup)findViewById(i.f.sns_ad_native_landing_pages_test_root);
    Object localObject2 = (LayoutInflater)this.mController.uMN.getSystemService("layout_inflater");
    Object localObject1 = (WindowManager)this.mController.uMN.getSystemService("window");
    int i = ((WindowManager)localObject1).getDefaultDisplay().getWidth();
    int j = ((WindowManager)localObject1).getDefaultDisplay().getHeight();
    localObject1 = Environment.getExternalStorageDirectory().toString() + "/tencent/MicroMsg/sns_ad_landingpages";
    String str1 = "adId" + "_image_" + ad.bB("http://mmsns.qpic.cn/mmsns/pUBe8EmICSCsszwvTNz7XO46mx3SDurmV95hHIeQvib0AEVBGYU02Mg/150");
    String str2 = "adId" + "_stream_" + ad.bB("http://wxsnsdy.tc.qq.com/105/20210/snsdyvideodownload?filekey=30280201010421301f0201690402534804105d999cf2831eae6ca6e65b177800230f0204009297fd0400&amp;bizid=1023&amp;hy=SH&amp;fileparam=302c020101042530230204136ffd9302045719f85d02024ef202031e8d7f02030f42400204045a320a0201000400");
    localObject2 = ((LayoutInflater)localObject2).inflate(i.g.sns_ad_native_landing_pages_item_sight, null);
    ((View)localObject2).setMinimumHeight(j);
    Object localObject3 = (ViewGroup)((View)localObject2).findViewById(i.f.sns_ad_native_landing_pages_item_sight_container);
    this.oVe = new VideoSightView(this.mController.uMN);
    this.oVe.setLoop(false);
    LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(-1, -1);
    ((ViewGroup)localObject3).addView(this.oVe, 0, localLayoutParams);
    localObject3 = new RelativeLayout.LayoutParams(-1, -2);
    ((RelativeLayout.LayoutParams)localObject3).addRule(12);
    ((RelativeLayout.LayoutParams)localObject3).bottomMargin = BackwardSupportUtil.b.b(this.mController.uMN, this.mController.uMN.getResources().getDimension(i.d.NoPadding));
    this.oVf = new SnsAdNativeLandingPagesVideoPlayerLoadingBar(this.mController.uMN);
    this.oVf.setVisibility(0);
    this.oVe.setPlayProgressCallback(true);
    ((ViewGroup)localObject2).addView(this.oVf, (ViewGroup.LayoutParams)localObject3);
    this.oVf.setIplaySeekCallback(new SnsAdNativeLandingTestUI.3(this));
    this.oVf.setOnPlayButtonClickListener(new SnsAdNativeLandingTestUI.4(this));
    this.oVf.setIsPlay(this.oVe.isPlaying());
    this.oVf.setVisibility(0);
    this.oVf.seek(0);
    this.oVe.setVideoCallback(new SnsAdNativeLandingTestUI.5(this));
    this.oVe.setEnableConfigChanged(false);
    this.oVe.setOnClickListener(new SnsAdNativeLandingTestUI.6(this));
    paramBundle.addView((View)localObject2, new LinearLayout.LayoutParams(i, j));
    this.oVe.post(new SnsAdNativeLandingTestUI.7(this));
    new SnsAdNativeLandingTestUI.a((String)localObject1, str1, af.aXq(), new SnsAdNativeLandingTestUI.8(this)).execute(new String[] { "http://mmsns.qpic.cn/mmsns/pUBe8EmICSCsszwvTNz7XO46mx3SDurmV95hHIeQvib0AEVBGYU02Mg/150" });
    new SnsAdNativeLandingTestUI.a((String)localObject1, str2, af.aXq(), new SnsAdNativeLandingTestUI.9(this), 409600).execute(new String[] { "http://wxsnsdy.tc.qq.com/105/20210/snsdyvideodownload?filekey=30280201010421301f0201690402534804105d999cf2831eae6ca6e65b177800230f0204009297fd0400&amp;bizid=1023&amp;hy=SH&amp;fileparam=302c020101042530230204136ffd9302045719f85d02024ef202031e8d7f02030f42400204045a320a0201000400" });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.SnsAdNativeLandingTestUI
 * JD-Core Version:    0.7.0.1
 */