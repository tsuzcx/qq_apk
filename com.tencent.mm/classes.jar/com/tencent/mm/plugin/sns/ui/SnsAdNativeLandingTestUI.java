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
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.plugin.sight.decode.ui.SnsAdNativeLandingPagesVideoPlayerLoadingBar;
import com.tencent.mm.plugin.sns.model.aj;
import com.tencent.mm.pluginsdk.ui.tools.VideoSightView;
import com.tencent.mm.pluginsdk.ui.tools.j.a;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.BitmapFactory;
import com.tencent.mm.sdk.platformtools.BitmapUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MD5Util;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.t;

public class SnsAdNativeLandingTestUI
  extends MMActivity
{
  private double DnV;
  private int Dzs;
  private VideoSightView Ezh;
  SnsAdNativeLandingPagesVideoPlayerLoadingBar Ezi;
  private int duration;
  private MMHandler hAk;
  private int videoHeight;
  private int videoWidth;
  
  public SnsAdNativeLandingTestUI()
  {
    AppMethodBeat.i(98446);
    this.DnV = 0.0D;
    this.duration = 0;
    this.hAk = new MMHandler();
    AppMethodBeat.o(98446);
  }
  
  public int getLayoutId()
  {
    return 2131496401;
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(98447);
    super.onCreate(paramBundle);
    this.mController.hideTitleView();
    getWindow().setFlags(1024, 1024);
    ((Button)findViewById(2131308061)).setOnClickListener(new SnsAdNativeLandingTestUI.1(this));
    paramBundle = (ViewGroup)findViewById(2131308060);
    Object localObject2 = (LayoutInflater)getContext().getSystemService("layout_inflater");
    Object localObject1 = (WindowManager)getContext().getSystemService("window");
    int i = ((WindowManager)localObject1).getDefaultDisplay().getWidth();
    int j = ((WindowManager)localObject1).getDefaultDisplay().getHeight();
    localObject1 = com.tencent.mm.loader.j.b.aKJ() + "/sns_ad_landingpages";
    String str1 = "adId" + "_image_" + MD5Util.getMD5String("http://mmsns.qpic.cn/mmsns/pUBe8EmICSCsszwvTNz7XO46mx3SDurmV95hHIeQvib0AEVBGYU02Mg/150");
    String str2 = "adId" + "_stream_" + MD5Util.getMD5String("http://wxsnsdy.tc.qq.com/105/20210/snsdyvideodownload?filekey=30280201010421301f0201690402534804105d999cf2831eae6ca6e65b177800230f0204009297fd0400&amp;bizid=1023&amp;hy=SH&amp;fileparam=302c020101042530230204136ffd9302045719f85d02024ef202031e8d7f02030f42400204045a320a0201000400");
    localObject2 = ((LayoutInflater)localObject2).inflate(2131496394, null);
    ((View)localObject2).setMinimumHeight(j);
    Object localObject3 = (ViewGroup)((View)localObject2).findViewById(2131308043);
    this.Ezh = new VideoSightView(getContext());
    this.Ezh.setLoop(false);
    LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(-1, -1);
    ((ViewGroup)localObject3).addView(this.Ezh, 0, localLayoutParams);
    localObject3 = new RelativeLayout.LayoutParams(-1, -2);
    ((RelativeLayout.LayoutParams)localObject3).addRule(12);
    ((RelativeLayout.LayoutParams)localObject3).bottomMargin = BackwardSupportUtil.BitmapFactory.fromDPToPix(getContext(), getContext().getResources().getDimension(2131165524));
    this.Ezi = new SnsAdNativeLandingPagesVideoPlayerLoadingBar(getContext());
    this.Ezi.setVisibility(0);
    this.Ezh.setPlayProgressCallback(true);
    ((ViewGroup)localObject2).addView(this.Ezi, (ViewGroup.LayoutParams)localObject3);
    this.Ezi.setIplaySeekCallback(new com.tencent.mm.plugin.sight.decode.ui.b()
    {
      public final void aJq() {}
      
      public final void rk(int paramAnonymousInt)
      {
        AppMethodBeat.i(98422);
        Log.i("MicroMsg.Sns.SnsAdNativieLandingTestUI", "onSeek time ".concat(String.valueOf(paramAnonymousInt)));
        SnsAdNativeLandingTestUI.a(SnsAdNativeLandingTestUI.this, paramAnonymousInt);
        SnsAdNativeLandingTestUI.a(SnsAdNativeLandingTestUI.this).q(paramAnonymousInt);
        AppMethodBeat.o(98422);
      }
    });
    this.Ezi.setOnPlayButtonClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(98423);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bm(paramAnonymousView);
        a.b("com/tencent/mm/plugin/sns/ui/SnsAdNativeLandingTestUI$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
        if (SnsAdNativeLandingTestUI.a(SnsAdNativeLandingTestUI.this).isPlaying()) {
          SnsAdNativeLandingTestUI.b(SnsAdNativeLandingTestUI.this);
        }
        for (;;)
        {
          a.a(this, "com/tencent/mm/plugin/sns/ui/SnsAdNativeLandingTestUI$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(98423);
          return;
          SnsAdNativeLandingTestUI.c(SnsAdNativeLandingTestUI.this);
        }
      }
    });
    this.Ezi.setIsPlay(this.Ezh.isPlaying());
    this.Ezi.setVisibility(0);
    this.Ezi.seek(0);
    this.Ezh.setVideoCallback(new j.a()
    {
      public final void eo(int paramAnonymousInt1, int paramAnonymousInt2)
      {
        AppMethodBeat.i(98428);
        SnsAdNativeLandingTestUI.c(SnsAdNativeLandingTestUI.this, paramAnonymousInt1);
        SnsAdNativeLandingTestUI.d(SnsAdNativeLandingTestUI.this, paramAnonymousInt2);
        AppMethodBeat.o(98428);
      }
      
      public final int fh(final int paramAnonymousInt1, final int paramAnonymousInt2)
      {
        AppMethodBeat.i(98427);
        MMHandlerThread.postToMainThread(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(98424);
            Log.i("MicroMsg.Sns.SnsAdNativieLandingTestUI", "play time " + paramAnonymousInt1 + " video time " + paramAnonymousInt2);
            if (paramAnonymousInt2 > 0)
            {
              SnsAdNativeLandingTestUI.a(SnsAdNativeLandingTestUI.this, paramAnonymousInt2);
              SnsAdNativeLandingTestUI.b(SnsAdNativeLandingTestUI.this, paramAnonymousInt2);
            }
            if (SnsAdNativeLandingTestUI.this.Ezi.getVideoTotalTime() != paramAnonymousInt2) {
              SnsAdNativeLandingTestUI.this.Ezi.setVideoTotalTime(paramAnonymousInt2);
            }
            SnsAdNativeLandingTestUI.this.Ezi.seek(paramAnonymousInt1);
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
      
      public final void tf()
      {
        AppMethodBeat.i(98425);
        if (SnsAdNativeLandingTestUI.this.Ezi.getIsPlay()) {
          SnsAdNativeLandingTestUI.c(SnsAdNativeLandingTestUI.this);
        }
        AppMethodBeat.o(98425);
      }
    });
    this.Ezh.setEnableConfigChanged(false);
    this.Ezh.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(98429);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bm(paramAnonymousView);
        a.b("com/tencent/mm/plugin/sns/ui/SnsAdNativeLandingTestUI$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
        if ((!"".equals(SnsAdNativeLandingTestUI.a(SnsAdNativeLandingTestUI.this).getVideoPath())) && (SnsAdNativeLandingTestUI.a(SnsAdNativeLandingTestUI.this).getVideoPath() != null))
        {
          if (SnsAdNativeLandingTestUI.this.Ezi.getVisibility() != 0) {
            break label107;
          }
          SnsAdNativeLandingTestUI.this.Ezi.setVisibility(4);
        }
        for (;;)
        {
          a.a(this, "com/tencent/mm/plugin/sns/ui/SnsAdNativeLandingTestUI$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(98429);
          return;
          label107:
          SnsAdNativeLandingTestUI.this.Ezi.setVisibility(0);
        }
      }
    });
    paramBundle.addView((View)localObject2, new LinearLayout.LayoutParams(i, j));
    this.Ezh.post(new Runnable()
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
    new SnsAdNativeLandingTestUI.a((String)localObject1, str1, aj.dRd(), new SnsAdNativeLandingTestUI.a.a()
    {
      public final void Hn(String paramAnonymousString)
      {
        AppMethodBeat.i(98431);
        SnsAdNativeLandingTestUI.a(SnsAdNativeLandingTestUI.this).setThumb(BitmapUtil.decodeFile(paramAnonymousString));
        AppMethodBeat.o(98431);
      }
      
      public final void aas(String paramAnonymousString) {}
      
      public final void dx(String paramAnonymousString, int paramAnonymousInt) {}
    }).execute(new String[] { "http://mmsns.qpic.cn/mmsns/pUBe8EmICSCsszwvTNz7XO46mx3SDurmV95hHIeQvib0AEVBGYU02Mg/150" });
    new SnsAdNativeLandingTestUI.a((String)localObject1, str2, aj.dRd(), new SnsAdNativeLandingTestUI.a.a()
    {
      public final void Hn(String paramAnonymousString)
      {
        AppMethodBeat.i(98434);
        SnsAdNativeLandingTestUI.a(SnsAdNativeLandingTestUI.this).setVideoPath(paramAnonymousString);
        SnsAdNativeLandingTestUI.a(SnsAdNativeLandingTestUI.this).setLoop(true);
        if (SnsAdNativeLandingTestUI.this.Ezi.getIsPlay())
        {
          SnsAdNativeLandingTestUI.a(SnsAdNativeLandingTestUI.this).q(SnsAdNativeLandingTestUI.d(SnsAdNativeLandingTestUI.this));
          SnsAdNativeLandingTestUI.a(SnsAdNativeLandingTestUI.this).start();
        }
        AppMethodBeat.o(98434);
      }
      
      public final void aas(String paramAnonymousString)
      {
        AppMethodBeat.i(98433);
        Log.e("MicroMsg.Sns.SnsAdNativieLandingTestUI", paramAnonymousString);
        AppMethodBeat.o(98433);
      }
      
      public final void dx(String paramAnonymousString, int paramAnonymousInt)
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
        if (SnsAdNativeLandingTestUI.this.Ezi.getIsPlay())
        {
          SnsAdNativeLandingTestUI.a(SnsAdNativeLandingTestUI.this).q(SnsAdNativeLandingTestUI.d(SnsAdNativeLandingTestUI.this));
          SnsAdNativeLandingTestUI.a(SnsAdNativeLandingTestUI.this).start();
        }
        AppMethodBeat.o(98432);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.SnsAdNativeLandingTestUI
 * JD-Core Version:    0.7.0.1
 */