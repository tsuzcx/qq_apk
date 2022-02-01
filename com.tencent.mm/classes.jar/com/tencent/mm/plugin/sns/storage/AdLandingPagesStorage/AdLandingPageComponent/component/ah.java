package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Looper;
import android.support.v4.content.d;
import android.view.GestureDetector;
import android.view.GestureDetector.OnDoubleTapListener;
import android.view.GestureDetector.OnGestureListener;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLayoutChangeListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.nr;
import com.tencent.mm.plugin.sight.decode.ui.b;
import com.tencent.mm.plugin.sns.data.j;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.ae;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget.AdLandingVideoWrapper;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget.AdLandingVideoWrapper.a;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.f.a;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.h;
import com.tencent.mm.plugin.sns.ui.SnsAdNativeLandingPagesUI;
import com.tencent.mm.plugin.sns.ui.VideoFullScreenActivity;
import com.tencent.mm.pluginsdk.ui.h.b;
import com.tencent.mm.pluginsdk.ui.h.d;
import com.tencent.mm.pluginsdk.ui.tools.VideoPlayerSeekBar;
import com.tencent.mm.pluginsdk.ui.tools.VideoPlayerTextureView;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.av;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.sdk.platformtools.f;
import com.tencent.mm.vfs.i;
import org.json.JSONException;
import org.json.JSONObject;

public final class ah
  extends ag
  implements GestureDetector.OnDoubleTapListener, GestureDetector.OnGestureListener, View.OnClickListener, View.OnTouchListener, b, h.b, h.d
{
  private Context context;
  private ap gAC;
  private GestureDetector hRv;
  private ProgressBar iiH;
  private boolean isAutoPlay;
  private volatile boolean isWaiting;
  private View lRB;
  private int length;
  private ImageView rww;
  private long tUy;
  private int tVe;
  AdLandingVideoWrapper xbP;
  private VideoPlayerSeekBar xbQ;
  private ImageView xbR;
  private boolean xbS;
  private ImageView xbT;
  private TextView xbU;
  private Runnable xbV;
  private boolean xbW;
  private boolean xbX;
  private boolean xbY;
  private boolean xbZ;
  private ImageView xcQ;
  private View xcR;
  private volatile boolean xcS;
  private Runnable xcT;
  private int xcU;
  private int xcV;
  private View xcW;
  private boolean xca;
  private boolean xcb;
  private boolean xcc;
  private boolean xce;
  private boolean xcf;
  private boolean xcg;
  private int xch;
  private int xci;
  private int xcj;
  private int xck;
  private int xcl;
  private ak xcm;
  private View.OnClickListener xcn;
  private View.OnClickListener xco;
  private View.OnClickListener xcp;
  private View.OnClickListener xcq;
  private volatile int xdt;
  
  public ah(final Context paramContext, com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.ah paramah, ViewGroup paramViewGroup)
  {
    super(paramContext, paramah, paramViewGroup);
    AppMethodBeat.i(96774);
    this.xbW = false;
    this.xbX = false;
    this.xbY = false;
    this.xbZ = true;
    this.xca = true;
    this.xcb = false;
    this.xcc = true;
    this.isAutoPlay = false;
    this.xce = false;
    this.xcf = false;
    this.xcg = false;
    this.xch = 0;
    this.tUy = 0L;
    this.xci = 0;
    this.tVe = 0;
    this.xcj = 0;
    this.xck = 0;
    this.xcl = 0;
    this.xcm = null;
    this.xcn = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(96769);
        ad.i("MicroMsg.Sns.AdLandingPageStreamVideoPlayerComponent", "play btn onclick isPlaying[%b]", new Object[] { Boolean.valueOf(ah.this.xbP.isPlaying()) });
        ah.a(ah.this, ah.g(ah.this));
        if (ah.this.xbP.isPlaying())
        {
          ah.h(ah.this);
          ah.a(ah.this, 4);
          if (ah.k(ah.this)) {
            ah.l(ah.this);
          }
          AppMethodBeat.o(96769);
          return;
        }
        if (ah.i(ah.this)) {
          ah.this.dvw();
        }
        for (;;)
        {
          ah.j(ah.this);
          ah.a(ah.this, 3);
          break;
          ah.this.dvD();
          ah.this.dvC();
        }
      }
    };
    this.xco = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(96771);
        ah.m(ah.this);
        ah.a(ah.this, ah.g(ah.this));
        if (ah.i(ah.this))
        {
          ah.this.dvD();
          ah.this.dvC();
        }
        for (;;)
        {
          ah.n(ah.this);
          AppMethodBeat.o(96771);
          return;
          ah.this.dvw();
        }
      }
    };
    this.xcp = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(96772);
        ah.j(ah.this);
        ah.o(ah.this);
        ah.p(ah.this);
        ah.a(ah.this, 3);
        ah.this.dvC();
        ah.a(ah.this, true);
        aq.n(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(187471);
            if (ah.q(ah.this))
            {
              AppMethodBeat.o(187471);
              return;
            }
            ah.a(ah.this, false);
            AppMethodBeat.o(187471);
          }
        }, 10000L);
        AppMethodBeat.o(96772);
      }
    };
    this.xcq = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView) {}
    };
    this.xcS = false;
    this.isWaiting = false;
    this.xdt = 0;
    this.xcU = 0;
    this.xcV = 0;
    this.context = paramContext;
    this.gAC = new ap(Looper.getMainLooper());
    try
    {
      this.hRv = new GestureDetector(this);
      this.xcT = new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(96762);
          ah.a(ah.this).setVisibility(8);
          AppMethodBeat.o(96762);
        }
      };
      this.xbV = new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(187466);
          ah.a(ah.this, false);
          AppMethodBeat.o(187466);
        }
      };
      this.xcm = new ak()
      {
        public final void qa(boolean paramAnonymousBoolean)
        {
          AppMethodBeat.i(187467);
          Intent localIntent = new Intent("com.tencent.mm.adlanding.video_progressbar_change");
          if (paramAnonymousBoolean) {}
          for (int i = 1;; i = 0)
          {
            localIntent.putExtra("show", i);
            d.T(paramContext).b(localIntent);
            AppMethodBeat.o(187467);
            return;
          }
        }
      };
      AppMethodBeat.o(96774);
      return;
    }
    catch (Throwable paramah)
    {
      for (;;)
      {
        ad.e("MicroMsg.Sns.AdLandingPageStreamVideoPlayerComponent.VideoOptimize", paramah.toString());
      }
    }
  }
  
  private void MI(int paramInt)
  {
    AppMethodBeat.i(96779);
    if (this.xbP != null)
    {
      this.xbT.setVisibility(8);
      if (this.rww.getVisibility() == 0) {
        this.iiH.setVisibility(0);
      }
      this.xbP.c(paramInt, true);
    }
    AppMethodBeat.o(96779);
  }
  
  private void ap(Runnable paramRunnable)
  {
    AppMethodBeat.i(187473);
    try
    {
      this.gAC.removeCallbacks(paramRunnable);
      this.gAC.postDelayed(paramRunnable, 4000L);
      AppMethodBeat.o(187473);
      return;
    }
    catch (Throwable paramRunnable)
    {
      ad.e("MicroMsg.Sns.AdLandingPageStreamVideoPlayerComponent.VideoOptimize", paramRunnable.toString());
      AppMethodBeat.o(187473);
    }
  }
  
  private void bOu()
  {
    AppMethodBeat.i(96776);
    ad.i("MicroMsg.Sns.AdLandingPageStreamVideoPlayerComponent", "starting play, downFailed=" + this.xce);
    if (this.xce)
    {
      ad.e("MicroMsg.Sns.AdLandingPageStreamVideoPlayerComponent", "last download fail ,try again");
      if ((this.xbQ != null) && (this.xbQ.getParent() != null)) {
        ((ViewGroup)this.xbQ.getParent()).removeView(this.xbQ);
      }
      this.xbP.setFullScreen(false);
      this.xbP.c(false, ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.ah)this.xab).wWw, 0);
      try
      {
        int i = this.kvn;
        if ((this.xbQ != null) && (this.xbQ.getParent() != null)) {
          ((ViewGroup)this.xbQ.getParent()).removeView(this.xbQ);
        }
        RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(i - com.tencent.mm.cd.a.fromDPToPix(this.context, 75), -2);
        localLayoutParams.addRule(12);
        localLayoutParams.bottomMargin = com.tencent.mm.cd.a.fromDPToPix(this.context, 3);
        this.xbQ.setLayoutParams(localLayoutParams);
        ((ViewGroup)this.contentView.findViewById(2131298770)).addView(this.xbQ, localLayoutParams);
      }
      catch (Exception localException)
      {
        for (;;)
        {
          ad.e("MicroMsg.Sns.AdLandingPageStreamVideoPlayerComponent", "startPlay exp=" + bt.m(localException));
        }
      }
      MI(0);
      this.xbP.dwG();
      AppMethodBeat.o(96776);
      return;
    }
    this.gAC.post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(96763);
        if (!ah.this.xbP.isPlaying())
        {
          if (ah.r(ah.this).getCurrPosSec() != ah.r(ah.this).getVideoDurationSec()) {
            break label65;
          }
          ah.b(ah.this, 0);
        }
        for (;;)
        {
          ah.r(ah.this).dwG();
          AppMethodBeat.o(96763);
          return;
          label65:
          ah.b(ah.this, ah.r(ah.this).getCurrPosSec());
        }
      }
    });
    this.tUy = System.currentTimeMillis();
    this.tVe += 1;
    AppMethodBeat.o(96776);
  }
  
  private void qb(boolean paramBoolean)
  {
    AppMethodBeat.i(187472);
    try
    {
      this.xbQ.setIsPlay(paramBoolean);
      this.xbQ.getPlayBtn().getLayoutParams().width = this.length;
      this.xbQ.getPlayBtn().getLayoutParams().height = this.length;
      if (paramBoolean)
      {
        ad.i("MicroMsg.Sns.AdLandingPageStreamVideoPlayerComponent.VideoOptimize", "startPlay");
        this.xbQ.getPlayBtn().setImageDrawable(com.tencent.mm.cd.a.l(this.context, 2131691470));
        AppMethodBeat.o(187472);
        return;
      }
      ad.i("MicroMsg.Sns.AdLandingPageStreamVideoPlayerComponent.VideoOptimize", "pausePlay");
      this.xbQ.getPlayBtn().setImageDrawable(com.tencent.mm.cd.a.l(this.context, 2131691469));
      AppMethodBeat.o(187472);
      return;
    }
    catch (Throwable localThrowable)
    {
      ad.e("MicroMsg.Sns.AdLandingPageStreamVideoPlayerComponent.VideoOptimize", localThrowable.toString());
      AppMethodBeat.o(187472);
    }
  }
  
  private void qc(final boolean paramBoolean)
  {
    AppMethodBeat.i(187474);
    ad.d("MicroMsg.Sns.AdLandingPageStreamVideoPlayerComponent", "pause play");
    this.gAC.post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(96764);
        ah.r(ah.this).pause();
        try
        {
          if ((ah.s(ah.this).getVisibility() != 0) && (paramBoolean))
          {
            ah.a(ah.this).setVisibility(0);
            ah.a(ah.this, ah.t(ah.this));
          }
          ah.b(ah.this, false);
          AppMethodBeat.o(96764);
          return;
        }
        catch (Throwable localThrowable)
        {
          ad.e("MicroMsg.Sns.AdLandingPageStreamVideoPlayerComponent.VideoOptimize", localThrowable.toString());
          AppMethodBeat.o(96764);
        }
      }
    });
    if (this.tUy != 0L)
    {
      this.xci = ((int)(this.xci + (System.currentTimeMillis() - this.tUy)));
      this.tUy = 0L;
    }
    AppMethodBeat.o(187474);
  }
  
  private void setFocus(boolean paramBoolean)
  {
    AppMethodBeat.i(96778);
    if (paramBoolean)
    {
      this.xbQ.setVisibility(0);
      this.xbR.setVisibility(0);
      this.lRB.setVisibility(0);
      this.xcQ.setVisibility(0);
      if (this.xcm != null) {
        this.xcm.qa(true);
      }
      ap(this.xbV);
      AppMethodBeat.o(96778);
      return;
    }
    this.xbY = false;
    this.xbQ.setVisibility(4);
    this.xbR.setVisibility(8);
    this.lRB.setVisibility(4);
    this.xcQ.setVisibility(8);
    if (this.xcm != null) {
      this.xcm.qa(false);
    }
    this.gAC.removeCallbacks(this.xbV);
    AppMethodBeat.o(96778);
  }
  
  public final void a(int paramInt1, boolean paramBoolean1, boolean paramBoolean2, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, long paramLong, boolean paramBoolean3, int paramInt7)
  {
    AppMethodBeat.i(187482);
    try
    {
      this.xch = 6;
      this.xcS = paramBoolean2;
      this.xcV += 1;
      this.xck += paramInt2;
      this.xcU += paramInt3;
      this.xcl += paramInt4;
      this.xcj += paramInt5;
      this.tVe += paramInt6;
      this.xci = ((int)(this.xci + paramLong));
      if (paramBoolean2) {
        this.tUy = System.currentTimeMillis();
      }
      this.gAC.removeCallbacks(this.xcT);
      this.xcR.setVisibility(8);
      ad.i("NonFullOrFullVideoType", "currPosSec = " + paramInt1 + ", isPlaying = " + paramBoolean2 + ", bNoVoice = " + paramBoolean1);
      if (paramBoolean3)
      {
        if ((paramInt7 > 0) && (paramInt7 <= this.xbP.getVideoDurationSec()))
        {
          this.xbQ.seek(this.xbP.getCacheTimeSec());
          this.xbP.c(this.xbP.getCacheTimeSec(), true);
        }
        for (;;)
        {
          this.tUy = System.currentTimeMillis();
          qb(true);
          if (!paramBoolean1) {
            break;
          }
          dvw();
          AppMethodBeat.o(187482);
          return;
          this.xbQ.seek(0);
          this.xbP.c(0.0D, true);
        }
      }
      if (paramInt1 >= this.xbP.getVideoDurationSec()) {
        break label305;
      }
    }
    catch (Throwable localThrowable)
    {
      ad.e("NonFullOrFullVideoType", localThrowable.toString());
      AppMethodBeat.o(187482);
      return;
    }
    if (paramInt1 < 0)
    {
      label305:
      this.xbQ.seek(0);
      this.xbP.c(0.0D, paramBoolean2);
    }
    for (;;)
    {
      qb(paramBoolean2);
      break;
      this.xbQ.seek(paramInt1);
      this.xbP.c(paramInt1, paramBoolean2);
    }
    dvC();
    AppMethodBeat.o(187482);
  }
  
  public final boolean aG(JSONObject paramJSONObject)
  {
    AppMethodBeat.i(96786);
    if (!super.aG(paramJSONObject))
    {
      AppMethodBeat.o(96786);
      return false;
    }
    try
    {
      paramJSONObject.put("streamVideoDuraion", this.xbP.getVideoDurationSec() * 1000);
      paramJSONObject.put("playTimeInterval", this.xci);
      paramJSONObject.put("playCount", this.tVe);
      paramJSONObject.put("playCompletedCount", this.xcj);
      paramJSONObject.put("clickFullscreenBtnCount", this.xcV);
      paramJSONObject.put("doubleClickCount", this.xcU);
      paramJSONObject.put("clickPlayControlCount", this.xck);
      paramJSONObject.put("clickVoiceControlCount", this.xcl);
      if (this.isAutoPlay) {}
      for (String str = "1";; str = "0")
      {
        paramJSONObject.put("isAutoPlay", str);
        JSONObject localJSONObject;
        if (!this.xcf)
        {
          str = ai.du(((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.ah)this.xab).wXs);
          localJSONObject = new JSONObject();
          localJSONObject.put("urlMd5", str);
          localJSONObject.put("needDownload", 1);
          paramJSONObject.put("thumbUrlInfo", localJSONObject);
        }
        if (!this.xcg)
        {
          str = ai.du(((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.ah)this.xab).wWw);
          localJSONObject = new JSONObject();
          localJSONObject.put("urlMd5", str);
          localJSONObject.put("needDownload", 1);
          paramJSONObject.put("streamVideoUrlInfo", localJSONObject);
        }
        AppMethodBeat.o(96786);
        return true;
      }
      return false;
    }
    catch (JSONException paramJSONObject)
    {
      ad.printErrStackTrace("MicroMsg.Sns.AdLandingPageStreamVideoPlayerComponent", paramJSONObject, "", new Object[0]);
      AppMethodBeat.o(96786);
    }
  }
  
  public final void bcv()
  {
    AppMethodBeat.i(187476);
    this.xbY = true;
    ap(this.xbV);
    AppMethodBeat.o(187476);
  }
  
  public final void c(String paramString1, String paramString2, String paramString3, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(96790);
    ad.e("MicroMsg.Sns.AdLandingPageStreamVideoPlayerComponent", "online play error, %s", new Object[] { paramString3 });
    this.xce = true;
    AppMethodBeat.o(96790);
  }
  
  public final void cka()
  {
    AppMethodBeat.i(187483);
    qc(false);
    this.xch = 4;
    AppMethodBeat.o(187483);
  }
  
  public final void ckb()
  {
    AppMethodBeat.i(187484);
    this.xch = 3;
    bOu();
    AppMethodBeat.o(187484);
  }
  
  public final void d(String paramString1, String paramString2, int paramInt1, int paramInt2) {}
  
  public final void db(String paramString1, String paramString2)
  {
    this.xce = false;
  }
  
  public final void dc(String paramString1, String paramString2)
  {
    AppMethodBeat.i(96788);
    this.xcj += 1;
    setFocus(true);
    this.xbP.xdT.stopTimer();
    if (this.tUy != 0L)
    {
      this.xci = ((int)(this.xci + (System.currentTimeMillis() - this.tUy)));
      this.tUy = 0L;
    }
    this.xch = 5;
    this.xbP.onUIPause();
    AppMethodBeat.o(96788);
  }
  
  public final void dd(String paramString1, String paramString2) {}
  
  public final void de(String paramString1, String paramString2)
  {
    AppMethodBeat.i(96789);
    this.rww.setVisibility(8);
    this.iiH.setVisibility(8);
    try
    {
      this.gAC.removeCallbacks(this.xcT);
      this.xcR.setVisibility(8);
      qb(true);
      AppMethodBeat.o(96789);
      return;
    }
    catch (Throwable paramString1)
    {
      ad.e("MicroMsg.Sns.AdLandingPageStreamVideoPlayerComponent.VideoOptimize", paramString1.toString());
      AppMethodBeat.o(96789);
    }
  }
  
  public final void dg(String paramString1, String paramString2)
  {
    this.isWaiting = true;
  }
  
  public final void dh(String paramString1, String paramString2)
  {
    this.isWaiting = false;
    this.xdt = 0;
  }
  
  public final void dvA()
  {
    AppMethodBeat.i(96783);
    super.dvA();
    qc(false);
    if ((!this.xcb) && (!this.xcc))
    {
      AppMethodBeat.o(96783);
      return;
    }
    this.xcc = false;
    this.xcb = false;
    if (this.xch == 1) {
      this.xch = 2;
    }
    AppMethodBeat.o(96783);
  }
  
  public final void dvB()
  {
    AppMethodBeat.i(96785);
    super.dvB();
    int i = dwc();
    int j = getView().getHeight();
    ad.d("MicroMsg.Sns.AdLandingPageStreamVideoPlayerComponent", "inScreenHeight %d, height %d", new Object[] { Integer.valueOf(i), Integer.valueOf(j) });
    if ((i == 0) || (j == 0))
    {
      AppMethodBeat.o(96785);
      return;
    }
    if (i < 0)
    {
      AppMethodBeat.o(96785);
      return;
    }
    if (i >= j * 0.5F)
    {
      if ((this.xcb) && (!this.xcc))
      {
        AppMethodBeat.o(96785);
        return;
      }
      this.xcc = false;
      this.xcb = true;
      if (this.xch == 6)
      {
        if (this.xcS)
        {
          this.xch = 1;
          AppMethodBeat.o(96785);
          return;
        }
        this.xch = 4;
        AppMethodBeat.o(96785);
        return;
      }
      this.rww.setVisibility(0);
      NetworkInfo localNetworkInfo = ((ConnectivityManager)aj.getContext().getSystemService("connectivity")).getActiveNetworkInfo();
      if ((!this.xca) || ((this.xca) && (localNetworkInfo != null) && (localNetworkInfo.getType() == 1)))
      {
        setFocus(true);
        aq.n(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(187464);
            if (ah.q(ah.this))
            {
              AppMethodBeat.o(187464);
              return;
            }
            ah.a(ah.this, false);
            AppMethodBeat.o(187464);
          }
        }, 3000L);
      }
      if (this.xca)
      {
        if ((localNetworkInfo == null) || ((localNetworkInfo != null) && (localNetworkInfo.getType() != 1)))
        {
          this.xbT.setVisibility(0);
          this.isAutoPlay = false;
          this.xca = false;
          AppMethodBeat.o(96785);
          return;
        }
        this.isAutoPlay = true;
        this.xca = false;
      }
      if (this.xch == 0) {
        if ((localNetworkInfo != null) && (localNetworkInfo.getType() == 1))
        {
          if (!this.xbZ) {
            break label332;
          }
          dvw();
          this.xch = 1;
        }
      }
      for (;;)
      {
        bOu();
        label332:
        do
        {
          AppMethodBeat.o(96785);
          return;
          dvC();
          break;
          if (this.xch == 2)
          {
            if (this.xbZ) {
              dvw();
            }
            for (;;)
            {
              bOu();
              this.xch = 1;
              AppMethodBeat.o(96785);
              return;
              dvC();
            }
          }
        } while (this.xch != 3);
        if (this.xbZ) {
          dvw();
        } else {
          dvC();
        }
      }
    }
    this.xcc = false;
    this.xcb = false;
    qc(false);
    if (this.xch == 1) {
      this.xch = 2;
    }
    AppMethodBeat.o(96785);
  }
  
  public final void dvC()
  {
    AppMethodBeat.i(96781);
    super.dvC();
    this.xbR.setImageDrawable(com.tencent.mm.cd.a.l(this.context, 2131690342));
    this.xbP.setMute(false);
    this.xbZ = false;
    AppMethodBeat.o(96781);
  }
  
  protected final void dvN() {}
  
  public final void dvw()
  {
    AppMethodBeat.i(96780);
    super.dvw();
    this.xbR.setImageDrawable(com.tencent.mm.cd.a.l(this.context, 2131690341));
    this.xbP.setMute(true);
    this.xbZ = true;
    AppMethodBeat.o(96780);
  }
  
  public final void dvx()
  {
    boolean bool2 = true;
    AppMethodBeat.i(96775);
    Object localObject1 = this.contentView.findViewById(2131298770);
    this.xcW = ((View)localObject1);
    ((View)localObject1).setBackgroundColor(-16777216);
    int k = this.kvn;
    int j = this.kvo;
    int i = j;
    if (((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.ah)this.xab).wXt == 1)
    {
      i = j;
      if ((int)((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.ah)this.xab).width > 0) {
        i = k * (int)((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.ah)this.xab).height / (int)((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.ah)this.xab).width;
      }
    }
    else
    {
      ((View)localObject1).setPadding((int)((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.ah)this.xab).paddingLeft, (int)((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.ah)this.xab).paddingTop, (int)((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.ah)this.xab).paddingRight, (int)((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.ah)this.xab).paddingBottom);
    }
    ((View)localObject1).setLayoutParams(new RelativeLayout.LayoutParams(k, i));
    ((View)localObject1).setMinimumHeight(i);
    ad.i("MicroMsg.Sns.AdLandingPageStreamVideoPlayerComponent", "createView, displayType=" + ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.ah)this.xab).wXt + ", containerW=" + k + ", vH=" + i + ", padding=" + j.ep((View)localObject1));
    this.xbP = ((AdLandingVideoWrapper)((View)localObject1).findViewById(2131306410));
    this.xbP.setIMMVideoViewCallback(this);
    this.xbP.setOnClickListener(this.xcq);
    this.xbP.setFullScreen(false);
    this.xbP.c(false, ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.ah)this.xab).wWw, 0);
    this.xbP.setIsShowBasicControls(true);
    Object localObject2;
    if (!((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.ah)this.xab).wWC)
    {
      ad.e("MicroMsg.Sns.AdLandingPageStreamVideoPlayerComponent", "fixVideoBlackline, enable=false");
      this.iiH = ((ProgressBar)((View)localObject1).findViewById(2131303535));
      this.rww = ((ImageView)((View)localObject1).findViewById(2131305798));
      localObject2 = h.iU("adId", ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.ah)this.xab).wXs);
      if (!i.eK((String)localObject2)) {
        this.xcf = false;
      }
      if (!this.xcf) {
        break label1351;
      }
      this.rww.setImageBitmap(f.decodeFile((String)localObject2));
      label409:
      this.xbU = ((TextView)((View)localObject1).findViewById(2131299517));
      this.xbU.setText(this.context.getString(2131758104));
      this.lRB = ((View)localObject1).findViewById(2131304920);
      this.lRB.setVisibility(4);
      this.xbQ = new VideoPlayerSeekBar(this.context);
      this.xbQ.setVisibility(4);
      if (this.xcm != null)
      {
        localObject2 = this.xcm;
        if (this.xbQ.getVisibility() != 0) {
          break label1382;
        }
      }
    }
    label1294:
    label1351:
    label1382:
    for (boolean bool1 = true;; bool1 = false)
    {
      ((ak)localObject2).qa(bool1);
      this.xbQ.setIplaySeekCallback(this);
      this.xbQ.setOnPlayButtonClickListener(this.xcn);
      localObject2 = new RelativeLayout.LayoutParams(k - com.tencent.mm.cd.a.fromDPToPix(this.context, 75), -2);
      ((RelativeLayout.LayoutParams)localObject2).addRule(12);
      this.xbQ.setLayoutParams((ViewGroup.LayoutParams)localObject2);
      this.xbP.setVideoFooterView(this.xbQ);
      this.xbR = ((ImageView)((View)localObject1).findViewById(2131304921));
      this.xbR.setVisibility(4);
      this.xbR.setOnClickListener(this.xco);
      try
      {
        localObject3 = this.xbR.getParent();
        if ((localObject3 instanceof ViewGroup)) {
          ((ViewGroup)localObject3).removeView(this.xbR);
        }
        localObject3 = (RelativeLayout.LayoutParams)this.xbR.getLayoutParams();
        ((RelativeLayout.LayoutParams)localObject3).bottomMargin = com.tencent.mm.cd.a.fromDPToPix(this.context, 8);
        ((RelativeLayout.LayoutParams)localObject3).rightMargin = com.tencent.mm.cd.a.fromDPToPix(this.context, 10);
        ((ViewGroup)localObject1).addView(this.xbR, (ViewGroup.LayoutParams)localObject3);
        ad.i("MicroMsg.Sns.AdLandingPageStreamVideoPlayerComponent.VideoOptimize", "init voiceTypeBtn and visible");
      }
      catch (Throwable localThrowable4)
      {
        for (;;)
        {
          Object localObject3;
          ad.e("MicroMsg.Sns.AdLandingPageStreamVideoPlayerComponent.VideoOptimize", localThrowable4.toString());
        }
      }
      this.xbT = ((ImageView)((View)localObject1).findViewById(2131305196));
      this.xbT.setImageDrawable(com.tencent.mm.cd.a.l(this.context, 2131691166));
      this.xbT.setVisibility(8);
      this.xbT.setOnClickListener(this.xcp);
      ((ViewGroup)this.xbQ.getParent()).removeView(this.xbQ);
      ((RelativeLayout.LayoutParams)localObject2).bottomMargin = 0;
      ((ViewGroup)localObject1).addView(this.xbQ, (ViewGroup.LayoutParams)localObject2);
      this.xbP.setVideoPlayCallback(new AdLandingVideoWrapper.a()
      {
        public final void sa(int paramAnonymousInt)
        {
          AppMethodBeat.i(187470);
          ah.c(ah.this).post(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(187469);
              ah.b(ah.this, ah.this.xbP.isPlaying());
              AppMethodBeat.o(187469);
            }
          });
          if ((ah.d(ah.this).wWB != null) && (paramAnonymousInt * 1000 >= ah.d(ah.this).wWB.wXq) && (!ah.e(ah.this)))
          {
            ah.f(ah.this);
            nr localnr = new nr();
            localnr.dsM.dsN = ah.d(ah.this).wWB.dsN;
            com.tencent.mm.sdk.b.a.ESL.l(localnr);
          }
          AppMethodBeat.o(187470);
        }
      });
      localObject1 = this.xcW;
      try
      {
        this.length = com.tencent.mm.cd.a.fromDPToPix(this.context, 32);
        this.xbP.setOnTouchListener(this);
        this.xcQ = ((ImageView)((View)localObject1).findViewById(2131307246));
        localObject2 = this.xcQ.getParent();
        if ((localObject2 instanceof ViewGroup)) {
          ((ViewGroup)localObject2).removeView(this.xcQ);
        }
        localObject2 = (RelativeLayout.LayoutParams)this.xcQ.getLayoutParams();
        ((RelativeLayout.LayoutParams)localObject2).bottomMargin = com.tencent.mm.cd.a.fromDPToPix(this.context, 8);
        ((RelativeLayout.LayoutParams)localObject2).rightMargin = com.tencent.mm.cd.a.fromDPToPix(this.context, 10);
        ((ViewGroup)localObject1).addView(this.xcQ, (ViewGroup.LayoutParams)localObject2);
        this.xcQ.setOnClickListener(this);
        this.xcQ.setVisibility(8);
        ad.i("MicroMsg.Sns.AdLandingPageStreamVideoPlayerComponent.VideoOptimize", "init fullScreenBtn and visible");
      }
      catch (Throwable localThrowable1)
      {
        for (;;)
        {
          label1150:
          ad.e("MicroMsg.Sns.AdLandingPageStreamVideoPlayerComponent.VideoOptimize", localThrowable1.toString());
          continue;
          bool1 = false;
        }
      }
      try
      {
        this.xbP.setLoop(true);
        this.xbP.setLoopCompletionCallback(this);
        localObject1 = this.xbQ.getParent();
        if ((localObject1 instanceof ViewGroup)) {
          ((ViewGroup)localObject1).removeView(this.xbQ);
        }
        localObject1 = new RelativeLayout.LayoutParams(this.xcW.getLayoutParams().width - com.tencent.mm.cd.a.fromDPToPix(this.context, 75), -2);
        ((RelativeLayout.LayoutParams)localObject1).addRule(12);
        ((RelativeLayout.LayoutParams)localObject1).bottomMargin = com.tencent.mm.cd.a.fromDPToPix(this.context, 3);
        this.xbQ.setLayoutParams((ViewGroup.LayoutParams)localObject1);
        ((ViewGroup)this.contentView.findViewById(2131298770)).addView(this.xbQ, (ViewGroup.LayoutParams)localObject1);
        this.xbQ.setVisibility(4);
        qb(false);
        if (this.xcm != null)
        {
          localObject1 = this.xcm;
          if (this.xbQ.getVisibility() != 0) {
            break label1418;
          }
          bool1 = bool2;
          ((ak)localObject1).qa(bool1);
        }
        ad.i("MicroMsg.Sns.AdLandingPageStreamVideoPlayerComponent.VideoOptimize", "init progressBar and visible");
      }
      catch (Throwable localThrowable2)
      {
        ad.e("MicroMsg.Sns.AdLandingPageStreamVideoPlayerComponent.VideoOptimize", localThrowable2.toString());
        break label1150;
      }
      localObject1 = this.xcW;
      try
      {
        this.xcR = ((View)localObject1).findViewById(2131307220);
        this.xcR.setVisibility(8);
        AppMethodBeat.o(96775);
        return;
      }
      catch (Throwable localThrowable3)
      {
        ad.e("MicroMsg.Sns.AdLandingPageStreamVideoPlayerComponent.VideoOptimize", localThrowable3.toString());
        AppMethodBeat.o(96775);
      }
      localObject2 = this.xbP.getInnerVideoView();
      localObject3 = (com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.ah)this.xab;
      if ((((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.ah)localObject3).paddingLeft != 0.0F) || (((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.ah)localObject3).paddingTop != 0.0F) || (((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.ah)localObject3).paddingRight != 0.0F) || (((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.ah)localObject3).paddingBottom != 0.0F)) {}
      for (bool1 = true;; bool1 = false)
      {
        if ((!(localObject2 instanceof VideoPlayerTextureView)) || (((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.ah)this.xab).wXt != 1) || (bool1)) {
          break label1294;
        }
        ((View)localObject2).addOnLayoutChangeListener(new View.OnLayoutChangeListener()
        {
          public final void onLayoutChange(View paramAnonymousView, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3, int paramAnonymousInt4, int paramAnonymousInt5, int paramAnonymousInt6, int paramAnonymousInt7, int paramAnonymousInt8)
          {
            AppMethodBeat.i(187465);
            try
            {
              paramAnonymousInt1 = paramAnonymousView.getWidth();
              paramAnonymousInt2 = paramAnonymousView.getHeight();
              paramAnonymousInt3 = ah.u(ah.this).getWidth();
              paramAnonymousInt4 = ah.u(ah.this).getHeight();
              if ((paramAnonymousInt2 <= 1) || (paramAnonymousInt1 <= 1) || (paramAnonymousInt3 == 0) || (paramAnonymousInt4 == 0))
              {
                AppMethodBeat.o(187465);
                return;
              }
              ad.i("MicroMsg.Sns.AdLandingPageStreamVideoPlayerComponent", "onLayoutChange, videoW=" + paramAnonymousInt1 + ", videoH=" + paramAnonymousInt2 + ", containerW=" + paramAnonymousInt3 + ", containH=" + paramAnonymousInt4 + ", container.padding=" + j.ep(ah.u(ah.this)));
              if (paramAnonymousInt2 == paramAnonymousInt4)
              {
                AppMethodBeat.o(187465);
                return;
              }
              if ((paramAnonymousInt2 >= paramAnonymousInt1) && (paramAnonymousInt4 >= paramAnonymousInt3) && (Math.abs(paramAnonymousInt2 - paramAnonymousInt4) < 2))
              {
                paramAnonymousView = ah.u(ah.this).getLayoutParams();
                paramAnonymousView.height = paramAnonymousInt2;
                ah.u(ah.this).setLayoutParams(paramAnonymousView);
                ad.i("MicroMsg.Sns.AdLandingPageStreamVideoPlayerComponent", "onLayoutChange, reset VideoContainer.height");
              }
              AppMethodBeat.o(187465);
              return;
            }
            catch (Exception paramAnonymousView)
            {
              ad.e("MicroMsg.Sns.AdLandingPageStreamVideoPlayerComponent", "onLayoutChange, exp=" + paramAnonymousView.toString());
              AppMethodBeat.o(187465);
            }
          }
        });
        break;
      }
      ad.e("MicroMsg.Sns.AdLandingPageStreamVideoPlayerComponent", "onLayoutChange, innerVideoView=" + localObject2 + ", displayType=" + ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.ah)this.xab).wXt + ", hasPadding=" + bool1);
      break;
      h.c("adId", ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.ah)this.xab).wXs, false, 1000000001, new f.a()
      {
        public final void apm(String paramAnonymousString)
        {
          AppMethodBeat.i(187468);
          if (ah.b(ah.this).getVisibility() == 0) {
            ah.b(ah.this).setImageBitmap(f.decodeFile(paramAnonymousString));
          }
          AppMethodBeat.o(187468);
        }
        
        public final void dsA() {}
        
        public final void duP() {}
      });
      break label409;
    }
    label1418:
  }
  
  public final void dvy()
  {
    AppMethodBeat.i(96784);
    super.dvy();
    try
    {
      this.gAC.removeCallbacks(this.xbV);
      this.gAC.removeCallbacks(this.xcT);
      this.xbP.onUIDestroy();
      AppMethodBeat.o(96784);
      return;
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        ad.e("MicroMsg.Sns.AdLandingPageStreamVideoPlayerComponent.VideoOptimize", localThrowable.toString());
      }
    }
  }
  
  public final void dvz()
  {
    AppMethodBeat.i(96782);
    super.dvz();
    AppMethodBeat.o(96782);
  }
  
  public final void dwE()
  {
    AppMethodBeat.i(187477);
    ad.i("MicroMsg.Sns.AdLandingPageStreamVideoPlayerComponent", "onLoopCompletion");
    this.xcj += 1;
    AppMethodBeat.o(187477);
  }
  
  public final void dwg()
  {
    AppMethodBeat.i(96791);
    super.dwg();
    qc(false);
    String str = h.iU("adId", ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.ah)this.xab).wXs);
    if (i.eK(str))
    {
      this.rww.setImageBitmap(f.decodeFile(str));
      this.rww.setVisibility(0);
    }
    AppMethodBeat.o(96791);
  }
  
  protected final int getLayout()
  {
    return 2131495505;
  }
  
  public final boolean isPlaying()
  {
    AppMethodBeat.i(187475);
    boolean bool = this.xbP.isPlaying();
    AppMethodBeat.o(187475);
    return bool;
  }
  
  public final void jw(String paramString1, String paramString2) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(187479);
    if (paramView.getId() == 2131307246)
    {
      ad.i("MicroMsg.Sns.AdLandingPageStreamVideoPlayerComponent.VideoOptimize", "click full screen btn");
      try
      {
        if ((this.context instanceof SnsAdNativeLandingPagesUI))
        {
          this.xcV += 1;
          this.gAC.removeCallbacks(this.xcT);
          this.xcR.setVisibility(8);
          paramView = (SnsAdNativeLandingPagesUI)this.context;
          Intent localIntent = new Intent(paramView, VideoFullScreenActivity.class);
          localIntent.putExtra("KComponentVideoType", 1);
          localIntent.putExtra("KComponentCid", dwe());
          localIntent.putExtra("KComponentCurrentTime", this.xbP.getCurrPosSec());
          localIntent.putExtra("KComponentTotalTime", this.xbP.getVideoDurationSec());
          localIntent.putExtra("KComponentVoiceType", this.xbZ);
          localIntent.putExtra("KComponentProgressType", this.xbP.isPlaying());
          localIntent.putExtra("KComponentStreamVideoUrlPath", ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.ah)this.xab).wWw);
          localIntent.putExtra("KComponentIsWaiting", this.isWaiting);
          localIntent.putExtra("KComponentSeekTimeDueWaiting", this.xdt);
          localIntent.putExtra("KComponentKComponentCacheTime", this.xbP.getCacheTimeSec());
          paramView.startActivityForResult(localIntent, SnsAdNativeLandingPagesUI.xuk);
          AppMethodBeat.o(187479);
          return;
        }
        this.xcQ.setVisibility(8);
        AppMethodBeat.o(187479);
        return;
      }
      catch (Throwable paramView)
      {
        this.xcQ.setVisibility(8);
        ad.e("NonFullOrFullVideoType", paramView.toString());
      }
    }
    AppMethodBeat.o(187479);
  }
  
  public final boolean onDoubleTap(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(187481);
    for (;;)
    {
      try
      {
        ad.i("MicroMsg.Sns.AdLandingPageStreamVideoPlayerComponent.VideoOptimize", "onDoubleTap");
        ap(this.xbV);
        if (!this.xce) {
          this.xcU += 1;
        }
        if (!this.xbP.isPlaying()) {
          continue;
        }
        qc(true);
        this.xch = 4;
      }
      catch (Throwable paramMotionEvent)
      {
        ad.e("MicroMsg.Sns.AdLandingPageStreamVideoPlayerComponent.VideoOptimize", paramMotionEvent.toString());
        continue;
        dvD();
        dvC();
        continue;
      }
      AppMethodBeat.o(187481);
      return false;
      if (!this.xbZ) {
        continue;
      }
      dvw();
      bOu();
      this.xch = 3;
    }
  }
  
  public final boolean onDoubleTapEvent(MotionEvent paramMotionEvent)
  {
    return false;
  }
  
  public final boolean onDown(MotionEvent paramMotionEvent)
  {
    return false;
  }
  
  public final boolean onFling(MotionEvent paramMotionEvent1, MotionEvent paramMotionEvent2, float paramFloat1, float paramFloat2)
  {
    return false;
  }
  
  public final void onLongPress(MotionEvent paramMotionEvent) {}
  
  public final boolean onScroll(MotionEvent paramMotionEvent1, MotionEvent paramMotionEvent2, float paramFloat1, float paramFloat2)
  {
    return false;
  }
  
  public final void onShowPress(MotionEvent paramMotionEvent) {}
  
  public final boolean onSingleTapConfirmed(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(187480);
    try
    {
      ad.i("MicroMsg.Sns.AdLandingPageStreamVideoPlayerComponent.VideoOptimize", "onSingleTapConfirmed");
      if (!this.xbY)
      {
        this.xbY = true;
        setFocus(true);
      }
      for (;;)
      {
        AppMethodBeat.o(187480);
        return false;
        this.xbY = false;
        setFocus(false);
      }
    }
    catch (Throwable paramMotionEvent)
    {
      for (;;)
      {
        ad.e("MicroMsg.Sns.AdLandingPageStreamVideoPlayerComponent.VideoOptimize", paramMotionEvent.toString());
      }
    }
  }
  
  public final boolean onSingleTapUp(MotionEvent paramMotionEvent)
  {
    return false;
  }
  
  @SuppressLint({"ClickableViewAccessibility"})
  public final boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(187478);
    boolean bool = this.hRv.onTouchEvent(paramMotionEvent);
    AppMethodBeat.o(187478);
    return bool;
  }
  
  public final void rZ(int paramInt)
  {
    AppMethodBeat.i(96787);
    ad.i("MicroMsg.Sns.AdLandingPageStreamVideoPlayerComponent", "onSeek time ".concat(String.valueOf(paramInt)));
    this.xdt = paramInt;
    if (this.xbZ) {
      dvw();
    }
    for (;;)
    {
      this.gAC.removeCallbacks(this.xcT);
      this.xcR.setVisibility(8);
      MI(paramInt);
      this.xch = 3;
      AppMethodBeat.o(96787);
      return;
      dvD();
      dvC();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.ah
 * JD-Core Version:    0.7.0.1
 */