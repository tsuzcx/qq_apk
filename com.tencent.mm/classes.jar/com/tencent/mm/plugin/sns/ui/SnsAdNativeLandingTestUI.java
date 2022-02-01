package com.tencent.mm.plugin.sns.ui;

import android.app.Activity;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sight.decode.ui.SnsAdNativeLandingPagesVideoPlayerLoadingBar;
import com.tencent.mm.plugin.sns.model.af;
import com.tencent.mm.pluginsdk.ui.tools.VideoSightView;
import com.tencent.mm.pluginsdk.ui.tools.h.a;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.b;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.ao;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.f;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.s;

public class SnsAdNativeLandingTestUI
  extends MMActivity
{
  private int duration;
  private ao gox;
  private int videoHeight;
  private int videoWidth;
  private double xEk;
  private VideoSightView yHB;
  SnsAdNativeLandingPagesVideoPlayerLoadingBar yHC;
  private int ypz;
  
  public SnsAdNativeLandingTestUI()
  {
    AppMethodBeat.i(98446);
    this.xEk = 0.0D;
    this.duration = 0;
    this.gox = new ao();
    AppMethodBeat.o(98446);
  }
  
  public int getLayoutId()
  {
    return 2131495515;
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(98447);
    super.onCreate(paramBundle);
    this.mController.hideTitleView();
    getWindow().setFlags(1024, 1024);
    ((Button)findViewById(2131304924)).setOnClickListener(new SnsAdNativeLandingTestUI.1(this));
    paramBundle = (ViewGroup)findViewById(2131304923);
    Object localObject2 = (LayoutInflater)getContext().getSystemService("layout_inflater");
    Object localObject1 = (WindowManager)getContext().getSystemService("window");
    int i = ((WindowManager)localObject1).getDefaultDisplay().getWidth();
    int j = ((WindowManager)localObject1).getDefaultDisplay().getHeight();
    localObject1 = com.tencent.mm.loader.j.b.aph() + "/sns_ad_landingpages";
    String str1 = "adId" + "_image_" + ah.dg("http://mmsns.qpic.cn/mmsns/pUBe8EmICSCsszwvTNz7XO46mx3SDurmV95hHIeQvib0AEVBGYU02Mg/150");
    String str2 = "adId" + "_stream_" + ah.dg("http://wxsnsdy.tc.qq.com/105/20210/snsdyvideodownload?filekey=30280201010421301f0201690402534804105d999cf2831eae6ca6e65b177800230f0204009297fd0400&amp;bizid=1023&amp;hy=SH&amp;fileparam=302c020101042530230204136ffd9302045719f85d02024ef202031e8d7f02030f42400204045a320a0201000400");
    localObject2 = ((LayoutInflater)localObject2).inflate(2131495508, null);
    ((View)localObject2).setMinimumHeight(j);
    Object localObject3 = (ViewGroup)((View)localObject2).findViewById(2131304907);
    this.yHB = new VideoSightView(getContext());
    this.yHB.setLoop(false);
    LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(-1, -1);
    ((ViewGroup)localObject3).addView(this.yHB, 0, localLayoutParams);
    localObject3 = new RelativeLayout.LayoutParams(-1, -2);
    ((RelativeLayout.LayoutParams)localObject3).addRule(12);
    ((RelativeLayout.LayoutParams)localObject3).bottomMargin = BackwardSupportUtil.b.g(getContext(), getContext().getResources().getDimension(2131165506));
    this.yHC = new SnsAdNativeLandingPagesVideoPlayerLoadingBar(getContext());
    this.yHC.setVisibility(0);
    this.yHB.setPlayProgressCallback(true);
    ((ViewGroup)localObject2).addView(this.yHC, (ViewGroup.LayoutParams)localObject3);
    this.yHC.setIplaySeekCallback(new com.tencent.mm.plugin.sight.decode.ui.b()
    {
      public final void anR() {}
      
      public final void nn(int paramAnonymousInt)
      {
        AppMethodBeat.i(98422);
        ac.i("MicroMsg.Sns.SnsAdNativieLandingTestUI", "onSeek time ".concat(String.valueOf(paramAnonymousInt)));
        SnsAdNativeLandingTestUI.a(SnsAdNativeLandingTestUI.this, paramAnonymousInt);
        SnsAdNativeLandingTestUI.a(SnsAdNativeLandingTestUI.this).p(paramAnonymousInt);
        AppMethodBeat.o(98422);
      }
    });
    this.yHC.setOnPlayButtonClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(98423);
        if (SnsAdNativeLandingTestUI.a(SnsAdNativeLandingTestUI.this).isPlaying())
        {
          SnsAdNativeLandingTestUI.b(SnsAdNativeLandingTestUI.this);
          AppMethodBeat.o(98423);
          return;
        }
        SnsAdNativeLandingTestUI.c(SnsAdNativeLandingTestUI.this);
        AppMethodBeat.o(98423);
      }
    });
    this.yHC.setIsPlay(this.yHB.isPlaying());
    this.yHC.setVisibility(0);
    this.yHC.seek(0);
    this.yHB.setVideoCallback(new h.a()
    {
      public final void dZ(int paramAnonymousInt1, int paramAnonymousInt2)
      {
        AppMethodBeat.i(98428);
        SnsAdNativeLandingTestUI.c(SnsAdNativeLandingTestUI.this, paramAnonymousInt1);
        SnsAdNativeLandingTestUI.d(SnsAdNativeLandingTestUI.this, paramAnonymousInt2);
        AppMethodBeat.o(98428);
      }
      
      public final int eP(final int paramAnonymousInt1, final int paramAnonymousInt2)
      {
        AppMethodBeat.i(98427);
        ap.f(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(98424);
            ac.i("MicroMsg.Sns.SnsAdNativieLandingTestUI", "play time " + paramAnonymousInt1 + " video time " + paramAnonymousInt2);
            if (paramAnonymousInt2 > 0)
            {
              SnsAdNativeLandingTestUI.a(SnsAdNativeLandingTestUI.this, paramAnonymousInt2);
              SnsAdNativeLandingTestUI.b(SnsAdNativeLandingTestUI.this, paramAnonymousInt2);
            }
            if (SnsAdNativeLandingTestUI.this.yHC.getVideoTotalTime() != paramAnonymousInt2) {
              SnsAdNativeLandingTestUI.this.yHC.setVideoTotalTime(paramAnonymousInt2);
            }
            SnsAdNativeLandingTestUI.this.yHC.seek(paramAnonymousInt1);
            AppMethodBeat.o(98424);
          }
        });
        AppMethodBeat.o(98427);
        return 0;
      }
      
      public final void onCompletion() {}
      
      public final void onError(int paramAnonymousInt1, int paramAnonymousInt2)
      {
        AppMethodBeat.i(98426);
        SnsAdNativeLandingTestUI.a(SnsAdNativeLandingTestUI.this).stop();
        AppMethodBeat.o(98426);
      }
      
      public final void rB()
      {
        AppMethodBeat.i(98425);
        if (SnsAdNativeLandingTestUI.this.yHC.getIsPlay()) {
          SnsAdNativeLandingTestUI.c(SnsAdNativeLandingTestUI.this);
        }
        AppMethodBeat.o(98425);
      }
    });
    this.yHB.setEnableConfigChanged(false);
    this.yHB.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(98429);
        if ((!"".equals(SnsAdNativeLandingTestUI.a(SnsAdNativeLandingTestUI.this).getVideoPath())) && (SnsAdNativeLandingTestUI.a(SnsAdNativeLandingTestUI.this).getVideoPath() != null))
        {
          if (SnsAdNativeLandingTestUI.this.yHC.getVisibility() == 0)
          {
            SnsAdNativeLandingTestUI.this.yHC.setVisibility(4);
            AppMethodBeat.o(98429);
            return;
          }
          SnsAdNativeLandingTestUI.this.yHC.setVisibility(0);
        }
        AppMethodBeat.o(98429);
      }
    });
    paramBundle.addView((View)localObject2, new LinearLayout.LayoutParams(i, j));
    this.yHB.post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(98430);
        DisplayMetrics localDisplayMetrics = new DisplayMetrics();
        if ((SnsAdNativeLandingTestUI.this.getContext() instanceof MMActivity))
        {
          ((MMActivity)SnsAdNativeLandingTestUI.this.getContext()).getWindowManager().getDefaultDisplay().getMetrics(localDisplayMetrics);
          SnsAdNativeLandingTestUI.a(SnsAdNativeLandingTestUI.this).setDrawableWidth(localDisplayMetrics.widthPixels);
        }
        SnsAdNativeLandingTestUI.a(SnsAdNativeLandingTestUI.this).requestLayout();
        SnsAdNativeLandingTestUI.a(SnsAdNativeLandingTestUI.this).postInvalidate();
        AppMethodBeat.o(98430);
      }
    });
    new SnsAdNativeLandingTestUI.a((String)localObject1, str1, af.cMM(), new SnsAdNativeLandingTestUI.a.a()
    {
      public final void ML(String paramAnonymousString) {}
      
      public final void cZ(String paramAnonymousString, int paramAnonymousInt) {}
      
      public final void vn(String paramAnonymousString)
      {
        AppMethodBeat.i(98431);
        SnsAdNativeLandingTestUI.a(SnsAdNativeLandingTestUI.this).setThumb(f.decodeFile(paramAnonymousString));
        AppMethodBeat.o(98431);
      }
    }).execute(new String[] { "http://mmsns.qpic.cn/mmsns/pUBe8EmICSCsszwvTNz7XO46mx3SDurmV95hHIeQvib0AEVBGYU02Mg/150" });
    new SnsAdNativeLandingTestUI.a((String)localObject1, str2, af.cMM(), new SnsAdNativeLandingTestUI.a.a()
    {
      public final void ML(String paramAnonymousString)
      {
        AppMethodBeat.i(98433);
        ac.e("MicroMsg.Sns.SnsAdNativieLandingTestUI", paramAnonymousString);
        AppMethodBeat.o(98433);
      }
      
      public final void cZ(String paramAnonymousString, int paramAnonymousInt)
      {
        AppMethodBeat.i(98432);
        if (SnsAdNativeLandingTestUI.a(SnsAdNativeLandingTestUI.this).isPlaying())
        {
          AppMethodBeat.o(98432);
          return;
        }
        SnsAdNativeLandingTestUI.a(SnsAdNativeLandingTestUI.this).setLoop(false);
        if (!paramAnonymousString.equals(SnsAdNativeLandingTestUI.a(SnsAdNativeLandingTestUI.this).getVideoPath())) {
          SnsAdNativeLandingTestUI.a(SnsAdNativeLandingTestUI.this).setVideoPath(paramAnonymousString);
        }
        if (SnsAdNativeLandingTestUI.this.yHC.getIsPlay())
        {
          SnsAdNativeLandingTestUI.a(SnsAdNativeLandingTestUI.this).p(SnsAdNativeLandingTestUI.d(SnsAdNativeLandingTestUI.this));
          SnsAdNativeLandingTestUI.a(SnsAdNativeLandingTestUI.this).start();
        }
        AppMethodBeat.o(98432);
      }
      
      public final void vn(String paramAnonymousString)
      {
        AppMethodBeat.i(98434);
        SnsAdNativeLandingTestUI.a(SnsAdNativeLandingTestUI.this).setVideoPath(paramAnonymousString);
        SnsAdNativeLandingTestUI.a(SnsAdNativeLandingTestUI.this).setLoop(true);
        if (SnsAdNativeLandingTestUI.this.yHC.getIsPlay())
        {
          SnsAdNativeLandingTestUI.a(SnsAdNativeLandingTestUI.this).p(SnsAdNativeLandingTestUI.d(SnsAdNativeLandingTestUI.this));
          SnsAdNativeLandingTestUI.a(SnsAdNativeLandingTestUI.this).start();
        }
        AppMethodBeat.o(98434);
      }
    }, 409600).execute(new String[] { "http://wxsnsdy.tc.qq.com/105/20210/snsdyvideodownload?filekey=30280201010421301f0201690402534804105d999cf2831eae6ca6e65b177800230f0204009297fd0400&amp;bizid=1023&amp;hy=SH&amp;fileparam=302c020101042530230204136ffd9302045719f85d02024ef202031e8d7f02030f42400204045a320a0201000400" });
    AppMethodBeat.o(98447);
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