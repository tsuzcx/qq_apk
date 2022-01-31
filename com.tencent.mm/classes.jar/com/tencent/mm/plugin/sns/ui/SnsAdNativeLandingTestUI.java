package com.tencent.mm.plugin.sns.ui;

import android.app.Activity;
import android.content.res.Resources;
import android.graphics.BitmapFactory;
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
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sight.decode.ui.SnsAdNativeLandingPagesVideoPlayerLoadingBar;
import com.tencent.mm.pluginsdk.ui.tools.VideoSightView;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.b;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.q;
import java.io.File;

public class SnsAdNativeLandingTestUI
  extends MMActivity
{
  private int duration;
  private ak faV;
  private double qUv;
  private VideoSightView rNg;
  SnsAdNativeLandingPagesVideoPlayerLoadingBar rNh;
  private int rxA;
  private int videoHeight;
  private int videoWidth;
  
  public SnsAdNativeLandingTestUI()
  {
    AppMethodBeat.i(38728);
    this.qUv = 0.0D;
    this.duration = 0;
    this.faV = new ak();
    AppMethodBeat.o(38728);
  }
  
  public int getLayoutId()
  {
    return 2130970795;
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(38729);
    super.onCreate(paramBundle);
    this.mController.hideTitleView();
    getWindow().setFlags(1024, 1024);
    ((Button)findViewById(2131827882)).setOnClickListener(new SnsAdNativeLandingTestUI.1(this));
    paramBundle = (ViewGroup)findViewById(2131827881);
    Object localObject2 = (LayoutInflater)getContext().getSystemService("layout_inflater");
    Object localObject1 = (WindowManager)getContext().getSystemService("window");
    int i = ((WindowManager)localObject1).getDefaultDisplay().getWidth();
    int j = ((WindowManager)localObject1).getDefaultDisplay().getHeight();
    localObject1 = Environment.getExternalStorageDirectory().toString() + "/tencent/MicroMsg/sns_ad_landingpages";
    String str1 = "adId" + "_image_" + com.tencent.mm.sdk.platformtools.ag.cE("http://mmsns.qpic.cn/mmsns/pUBe8EmICSCsszwvTNz7XO46mx3SDurmV95hHIeQvib0AEVBGYU02Mg/150");
    String str2 = "adId" + "_stream_" + com.tencent.mm.sdk.platformtools.ag.cE("http://wxsnsdy.tc.qq.com/105/20210/snsdyvideodownload?filekey=30280201010421301f0201690402534804105d999cf2831eae6ca6e65b177800230f0204009297fd0400&amp;bizid=1023&amp;hy=SH&amp;fileparam=302c020101042530230204136ffd9302045719f85d02024ef202031e8d7f02030f42400204045a320a0201000400");
    localObject2 = ((LayoutInflater)localObject2).inflate(2130970788, null);
    ((View)localObject2).setMinimumHeight(j);
    Object localObject3 = (ViewGroup)((View)localObject2).findViewById(2131827865);
    this.rNg = new VideoSightView(getContext());
    this.rNg.setLoop(false);
    LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(-1, -1);
    ((ViewGroup)localObject3).addView(this.rNg, 0, localLayoutParams);
    localObject3 = new RelativeLayout.LayoutParams(-1, -2);
    ((RelativeLayout.LayoutParams)localObject3).addRule(12);
    ((RelativeLayout.LayoutParams)localObject3).bottomMargin = BackwardSupportUtil.b.b(getContext(), getContext().getResources().getDimension(2131427798));
    this.rNh = new SnsAdNativeLandingPagesVideoPlayerLoadingBar(getContext());
    this.rNh.setVisibility(0);
    this.rNg.setPlayProgressCallback(true);
    ((ViewGroup)localObject2).addView(this.rNh, (ViewGroup.LayoutParams)localObject3);
    this.rNh.setIplaySeekCallback(new SnsAdNativeLandingTestUI.3(this));
    this.rNh.setOnPlayButtonClickListener(new SnsAdNativeLandingTestUI.4(this));
    this.rNh.setIsPlay(this.rNg.isPlaying());
    this.rNh.setVisibility(0);
    this.rNh.seek(0);
    this.rNg.setVideoCallback(new SnsAdNativeLandingTestUI.5(this));
    this.rNg.setEnableConfigChanged(false);
    this.rNg.setOnClickListener(new SnsAdNativeLandingTestUI.6(this));
    paramBundle.addView((View)localObject2, new LinearLayout.LayoutParams(i, j));
    this.rNg.post(new SnsAdNativeLandingTestUI.7(this));
    new SnsAdNativeLandingTestUI.a((String)localObject1, str1, com.tencent.mm.plugin.sns.model.ag.bEf(), new SnsAdNativeLandingTestUI.a.a()
    {
      public final void CF(String paramAnonymousString) {}
      
      public final void dq(String paramAnonymousString, int paramAnonymousInt) {}
      
      public final void mP(String paramAnonymousString)
      {
        AppMethodBeat.i(38713);
        SnsAdNativeLandingTestUI.a(SnsAdNativeLandingTestUI.this).setThumb(BitmapFactory.decodeFile(paramAnonymousString));
        AppMethodBeat.o(38713);
      }
    }).execute(new String[] { "http://mmsns.qpic.cn/mmsns/pUBe8EmICSCsszwvTNz7XO46mx3SDurmV95hHIeQvib0AEVBGYU02Mg/150" });
    new SnsAdNativeLandingTestUI.a((String)localObject1, str2, com.tencent.mm.plugin.sns.model.ag.bEf(), new SnsAdNativeLandingTestUI.9(this), 409600).execute(new String[] { "http://wxsnsdy.tc.qq.com/105/20210/snsdyvideodownload?filekey=30280201010421301f0201690402534804105d999cf2831eae6ca6e65b177800230f0204009297fd0400&amp;bizid=1023&amp;hy=SH&amp;fileparam=302c020101042530230204136ffd9302045719f85d02024ef202031e8d7f02030f42400204045a320a0201000400" });
    AppMethodBeat.o(38729);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.SnsAdNativeLandingTestUI
 * JD-Core Version:    0.7.0.1
 */