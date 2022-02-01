package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Looper;
import android.text.TextUtils;
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
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.nr;
import com.tencent.mm.plugin.sns.data.j;
import com.tencent.mm.plugin.sns.model.AdLandingPagesProxy;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.ae;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.u;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.f.a;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.h;
import com.tencent.mm.plugin.sns.ui.OfflineVideoView;
import com.tencent.mm.plugin.sns.ui.OfflineVideoView.a;
import com.tencent.mm.plugin.sns.ui.SnsAdNativeLandingPagesUI;
import com.tencent.mm.plugin.sns.ui.SnsAdStreamVideoPlayUI;
import com.tencent.mm.plugin.sns.ui.VideoAdPlayerUI;
import com.tencent.mm.plugin.sns.ui.VideoFullScreenActivity;
import com.tencent.mm.pluginsdk.ui.tools.VideoPlayerSeekBar;
import com.tencent.mm.pluginsdk.ui.tools.VideoPlayerTextureView;
import com.tencent.mm.pointers.PString;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.bt;
import java.io.File;
import org.json.JSONException;
import org.json.JSONObject;

public final class ad
  extends com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.a
  implements GestureDetector.OnDoubleTapListener, GestureDetector.OnGestureListener, View.OnClickListener, View.OnTouchListener
{
  public static int xcY = 999;
  private Context context;
  int fIO;
  private boolean fWx;
  private ap gAC;
  private GestureDetector hRv;
  private boolean isAutoPlay;
  private String jLZ;
  private View lRB;
  private int length;
  private com.tencent.mm.plugin.sight.decode.ui.b qmw;
  private long tUy;
  private int tVe;
  public int wys;
  public int wyt;
  public int wyu;
  private VideoPlayerSeekBar xbQ;
  ImageView xbR;
  private boolean xbS;
  private TextView xbU;
  private Runnable xbV;
  boolean xbZ;
  OfflineVideoView xcK;
  private int xcL;
  private int xcM;
  int xcN;
  int xcO;
  private boolean xcP;
  private ImageView xcQ;
  private View xcR;
  private volatile boolean xcS;
  private Runnable xcT;
  private int xcU;
  private int xcV;
  private View xcW;
  private View xcX;
  private boolean xcb;
  private boolean xcc;
  private boolean xce;
  boolean xcf;
  boolean xcg;
  private volatile int xch;
  private int xci;
  private int xcj;
  private int xck;
  int xcl;
  private ak xcm;
  private View.OnClickListener xcn;
  
  public ad(final Context paramContext, u paramu, ViewGroup paramViewGroup)
  {
    super(paramContext, paramu, paramViewGroup);
    AppMethodBeat.i(96717);
    this.tUy = 0L;
    this.xci = 0;
    this.tVe = 0;
    this.xcj = 0;
    this.xcM = 0;
    this.wys = 0;
    this.wyt = 0;
    this.wyu = 0;
    this.xcl = 0;
    this.xcN = 0;
    this.xbZ = true;
    this.xcO = 0;
    this.fIO = 0;
    this.xch = 0;
    this.xcb = false;
    this.xcc = true;
    this.isAutoPlay = false;
    this.xcf = true;
    this.xcg = true;
    this.xce = false;
    this.xcS = false;
    this.xcm = null;
    this.xcn = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(187421);
        for (;;)
        {
          try
          {
            com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.Sns.AdLandingPageSightVideoComponent.VideoOptimize", "play btn onclick isPlaying[%b]", new Object[] { Boolean.valueOf(ad.this.xcK.isPlaying()) });
            ad.a(ad.this, ad.d(ad.this));
            if (ad.this.xcK.isPlaying())
            {
              ad.p(ad.this);
              ad.c(ad.this, 4);
              if (ad.r(ad.this)) {
                ad.s(ad.this);
              }
              AppMethodBeat.o(187421);
              return;
            }
            if (ad.this.xbZ)
            {
              ad.this.dvw();
              ad.q(ad.this);
              ad.c(ad.this, 3);
              continue;
            }
            ad.this.dvD();
          }
          catch (Throwable paramAnonymousView)
          {
            com.tencent.mm.sdk.platformtools.ad.e("MicroMsg.Sns.AdLandingPageSightVideoComponent.VideoOptimize", paramAnonymousView.toString());
            AppMethodBeat.o(187421);
            return;
          }
          ad.this.dvC();
        }
      }
    };
    this.qmw = new com.tencent.mm.plugin.sight.decode.ui.b()
    {
      public final void bcv()
      {
        AppMethodBeat.i(187422);
        try
        {
          ad.a(ad.this, ad.d(ad.this));
          if (ad.c(ad.this) != null) {
            ad.c(ad.this).dzv();
          }
          AppMethodBeat.o(187422);
          return;
        }
        catch (Throwable localThrowable)
        {
          com.tencent.mm.sdk.platformtools.ad.e("MicroMsg.Sns.AdLandingPageSightVideoComponent.VideoOptimize", localThrowable.toString());
          AppMethodBeat.o(187422);
        }
      }
      
      public final void rZ(int paramAnonymousInt)
      {
        AppMethodBeat.i(187423);
        try
        {
          com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.Sns.AdLandingPageSightVideoComponent.VideoOptimize", "onSeek time ".concat(String.valueOf(paramAnonymousInt)));
          if (ad.this.xbZ) {
            ad.this.dvw();
          }
          for (;;)
          {
            ad.c(ad.this).au(paramAnonymousInt * 1000, true);
            ad.c(ad.this, 3);
            ad.b(ad.this, true);
            ad.u(ad.this).removeCallbacks(ad.t(ad.this));
            ad.b(ad.this).setVisibility(8);
            AppMethodBeat.o(187423);
            return;
            ad.this.dvC();
          }
          return;
        }
        catch (Throwable localThrowable)
        {
          com.tencent.mm.sdk.platformtools.ad.e("MicroMsg.Sns.AdLandingPageSightVideoComponent.VideoOptimize", localThrowable.toString());
          AppMethodBeat.o(187423);
        }
      }
    };
    this.xck = 0;
    this.xcU = 0;
    this.xcV = 0;
    this.context = paramContext;
    this.gAC = new ap(Looper.getMainLooper());
    try
    {
      this.hRv = new GestureDetector(this);
      this.xbV = new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(187420);
          ad.a(ad.this);
          AppMethodBeat.o(187420);
        }
      };
      this.xcT = new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(187427);
          ad.b(ad.this).setVisibility(8);
          AppMethodBeat.o(187427);
        }
      };
      this.xcm = new ak()
      {
        public final void qa(boolean paramAnonymousBoolean)
        {
          AppMethodBeat.i(187428);
          try
          {
            Intent localIntent = new Intent("com.tencent.mm.adlanding.video_progressbar_change");
            if (paramAnonymousBoolean) {}
            for (int i = 1;; i = 0)
            {
              localIntent.putExtra("show", i);
              android.support.v4.content.d.T(paramContext).b(localIntent);
              AppMethodBeat.o(187428);
              return;
            }
            return;
          }
          catch (Throwable localThrowable)
          {
            com.tencent.mm.sdk.platformtools.ad.e("MicroMsg.Sns.AdLandingPageSightVideoComponent", localThrowable.toString());
            AppMethodBeat.o(187428);
          }
        }
      };
      AppMethodBeat.o(96717);
      return;
    }
    catch (Throwable paramContext)
    {
      com.tencent.mm.sdk.platformtools.ad.e("MicroMsg.Sns.AdLandingPageSightVideoComponent.VideoOptimize", paramContext.toString());
      AppMethodBeat.o(96717);
    }
  }
  
  private void MJ(final int paramInt)
  {
    AppMethodBeat.i(187444);
    try
    {
      this.gAC.post(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(187442);
          ad.l(ad.this).seek(paramInt);
          ad.b(ad.this, ad.this.xcK.isPlaying());
          AppMethodBeat.o(187442);
        }
      });
      AppMethodBeat.o(187444);
      return;
    }
    catch (Throwable localThrowable)
    {
      com.tencent.mm.sdk.platformtools.ad.e("MicroMsg.Sns.AdLandingPageSightVideoComponent.VideoOptimize", localThrowable.toString());
      AppMethodBeat.o(187444);
    }
  }
  
  private void ap(Runnable paramRunnable)
  {
    AppMethodBeat.i(187448);
    try
    {
      this.gAC.removeCallbacks(paramRunnable);
      this.gAC.postDelayed(paramRunnable, 4000L);
      AppMethodBeat.o(187448);
      return;
    }
    catch (Throwable paramRunnable)
    {
      com.tencent.mm.sdk.platformtools.ad.e("MicroMsg.Sns.AdLandingPageSightVideoComponent.VideoOptimize", paramRunnable.toString());
      AppMethodBeat.o(187448);
    }
  }
  
  public static void apw(String paramString)
  {
    AppMethodBeat.i(187447);
    File localFile = new File(paramString);
    int j = 0;
    String str = "0";
    paramString = str;
    int i = j;
    if (localFile.isFile())
    {
      paramString = str;
      i = j;
      if (localFile.exists())
      {
        str = "1";
        paramString = str;
        i = j;
        if (localFile.delete())
        {
          i = 1;
          paramString = str;
        }
      }
    }
    com.tencent.mm.plugin.sns.data.i.b(com.tencent.mm.plugin.sns.data.i.wAN, paramString, 1, i, "http");
    AppMethodBeat.o(187447);
  }
  
  private void bOu()
  {
    AppMethodBeat.i(96721);
    if (this.xce)
    {
      com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.Sns.AdLandingPageSightVideoComponent", "last download fail ,try again");
      this.xcK.ckc();
      AppMethodBeat.o(96721);
      return;
    }
    com.tencent.mm.sdk.platformtools.ad.d("MicroMsg.Sns.AdLandingPageSightVideoComponent", "starting play");
    if ((!this.xcP) && (!TextUtils.isEmpty(this.jLZ)))
    {
      this.xcK.YI(this.jLZ);
      this.xcP = true;
    }
    this.gAC.post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(187424);
        ad.c(ad.this).dzw();
        try
        {
          ad.b(ad.this, true);
          ad.u(ad.this).removeCallbacks(ad.t(ad.this));
          ad.b(ad.this).setVisibility(8);
          AppMethodBeat.o(187424);
          return;
        }
        catch (Throwable localThrowable)
        {
          com.tencent.mm.sdk.platformtools.ad.e("MicroMsg.Sns.AdLandingPageSightVideoComponent", localThrowable.toString());
          AppMethodBeat.o(187424);
        }
      }
    });
    this.tUy = System.currentTimeMillis();
    this.tVe += 1;
    AppMethodBeat.o(96721);
  }
  
  private boolean dwx()
  {
    AppMethodBeat.i(96720);
    if (!bt.isNullOrNil(((u)this.xab).wVK))
    {
      Intent localIntent = new Intent();
      localIntent.putExtra("sns_landig_pages_from_source", 14);
      localIntent.putExtra("sns_landig_pages_origin_from_source", dwi().wXj);
      localIntent.putExtra("sns_landing_pages_ux_info", dwi().dvK);
      localIntent.putExtra("sns_landing_pages_xml", "");
      localIntent.putExtra("sns_landing_pages_canvasid", ((u)this.xab).wVK);
      localIntent.putExtra("sns_landing_pages_canvas_ext", ((u)this.xab).wVL);
      localIntent.putExtra("sns_landing_pages_no_store", ((u)this.xab).wVM);
      localIntent.putExtra("sns_landing_pages_need_enter_and_exit_animation", true);
      String str3;
      String str1;
      String str2;
      JSONObject localJSONObject;
      if (((this.context instanceof Activity)) && (dwi().bizId == 2))
      {
        str3 = ((Activity)this.context).getIntent().getStringExtra("sns_landing_pages_sessionId");
        str1 = ((Activity)this.context).getIntent().getStringExtra("sns_landing_pages_ad_buffer");
        if (!bt.isNullOrNil(str3))
        {
          str2 = String.valueOf(System.currentTimeMillis() / 1000L);
          localJSONObject = new JSONObject();
        }
      }
      for (;;)
      {
        try
        {
          localJSONObject.put("sessionId", str2);
          localJSONObject.put("cid", ((u)this.xab).wWE);
          if (bt.isNullOrNil(str1)) {
            continue;
          }
          localObject = str1;
          localJSONObject.put("adBuffer", localObject);
          localJSONObject.put("preSessionId", str3);
        }
        catch (Exception localException)
        {
          Object localObject;
          continue;
        }
        localIntent.putExtra("sns_landing_pages_search_extra", localJSONObject.toString());
        localIntent.putExtra("sns_landing_pages_sessionId", str2);
        localIntent.putExtra("sns_landing_pages_ad_buffer", str1);
        localObject = new int[2];
        this.xcK.getLocationOnScreen((int[])localObject);
        localIntent.putExtra("img_gallery_top", localObject[1]);
        localIntent.putExtra("img_gallery_left", localObject[0]);
        localIntent.putExtra("img_gallery_width", this.xcK.getWidth());
        localIntent.putExtra("img_gallery_height", this.xcK.getHeight());
        com.tencent.mm.bs.d.b(this.context, "sns", ".ui.SnsAdNativeLandingPagesPreviewUI", localIntent);
        AppMethodBeat.o(96720);
        return true;
        localObject = "";
      }
    }
    AppMethodBeat.o(96720);
    return false;
  }
  
  private void qb(boolean paramBoolean)
  {
    AppMethodBeat.i(187443);
    try
    {
      this.xbQ.setIsPlay(paramBoolean);
      this.xbQ.getPlayBtn().getLayoutParams().width = this.length;
      this.xbQ.getPlayBtn().getLayoutParams().height = this.length;
      if (paramBoolean)
      {
        com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.Sns.AdLandingPageSightVideoComponent.VideoOptimize", "startPlay");
        this.xbQ.getPlayBtn().setImageDrawable(com.tencent.mm.cd.a.l(this.context, 2131691470));
        AppMethodBeat.o(187443);
        return;
      }
      com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.Sns.AdLandingPageSightVideoComponent.VideoOptimize", "pausePlay");
      this.xbQ.getPlayBtn().setImageDrawable(com.tencent.mm.cd.a.l(this.context, 2131691469));
      AppMethodBeat.o(187443);
      return;
    }
    catch (Throwable localThrowable)
    {
      com.tencent.mm.sdk.platformtools.ad.e("MicroMsg.Sns.AdLandingPageSightVideoComponent.VideoOptimize", localThrowable.toString());
      AppMethodBeat.o(187443);
    }
  }
  
  private void qc(final boolean paramBoolean)
  {
    AppMethodBeat.i(187445);
    com.tencent.mm.sdk.platformtools.ad.d("MicroMsg.Sns.AdLandingPageSightVideoComponent", "pause play");
    this.gAC.post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(187425);
        ad.c(ad.this).dzv();
        try
        {
          ad.b(ad.this, false);
          if ((ad.n(ad.this)) && (paramBoolean))
          {
            ad.b(ad.this).setVisibility(0);
            ad.a(ad.this, ad.t(ad.this));
          }
          AppMethodBeat.o(187425);
          return;
        }
        catch (Throwable localThrowable)
        {
          com.tencent.mm.sdk.platformtools.ad.e("MicroMsg.Sns.AdLandingPageSightVideoComponent", localThrowable.toString());
          AppMethodBeat.o(187425);
        }
      }
    });
    if (this.tUy != 0L)
    {
      this.xci = ((int)(this.xci + (System.currentTimeMillis() - this.tUy)));
      this.tUy = 0L;
    }
    AppMethodBeat.o(187445);
  }
  
  public final void a(int paramInt1, boolean paramBoolean1, boolean paramBoolean2, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, long paramLong)
  {
    AppMethodBeat.i(187453);
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
      com.tencent.mm.sdk.platformtools.ad.i("NonFullOrFullVideoType", "currPosSec = " + paramInt1 + ", isPlaying = " + paramBoolean2 + ", bNoVoice = " + paramBoolean1);
      paramInt2 = paramInt1 / 1000;
      if ((paramInt2 >= this.xcL) || (paramInt1 < 0))
      {
        this.xbQ.seek(0);
        this.xcK.au(0, paramBoolean2);
      }
      for (;;)
      {
        qb(paramBoolean2);
        if (!paramBoolean1) {
          break;
        }
        dvw();
        AppMethodBeat.o(187453);
        return;
        this.xbQ.seek(paramInt2);
        this.xcK.au(paramInt1, paramBoolean2);
      }
      dvC();
    }
    catch (Throwable localThrowable)
    {
      com.tencent.mm.sdk.platformtools.ad.e("NonFullOrFullVideoType", localThrowable.toString());
      AppMethodBeat.o(187453);
      return;
    }
    AppMethodBeat.o(187453);
  }
  
  public final boolean aG(JSONObject paramJSONObject)
  {
    AppMethodBeat.i(96729);
    if (!super.aG(paramJSONObject))
    {
      AppMethodBeat.o(96729);
      return false;
    }
    try
    {
      paramJSONObject.put("sightDuration", this.xcL * 1000);
      paramJSONObject.put("playTimeInterval", this.xci);
      paramJSONObject.put("playCount", this.tVe);
      paramJSONObject.put("playCompletedCount", this.xcj);
      paramJSONObject.put("clickPlayControlCount", this.xck);
      paramJSONObject.put("doubleClickCount", this.xcU);
      paramJSONObject.put("clickFullscreenBtnCount", this.xcV);
      paramJSONObject.put("clickVoiceControlCount", this.xcl);
      if (this.isAutoPlay) {}
      for (String str = "1";; str = "0")
      {
        paramJSONObject.put("isAutoPlay", str);
        if (((u)this.xab).type == 61) {
          paramJSONObject.put("clickSightCount", this.xcN);
        }
        JSONObject localJSONObject;
        if (!this.xcg)
        {
          str = ai.du(((u)this.xab).wWu);
          localJSONObject = new JSONObject();
          localJSONObject.put("urlMd5", str);
          localJSONObject.put("needDownload", 1);
          paramJSONObject.put("sightUrlInfo", localJSONObject);
        }
        if (!this.xcf)
        {
          str = ai.du(((u)this.xab).wWv);
          localJSONObject = new JSONObject();
          localJSONObject.put("urlMd5", str);
          localJSONObject.put("needDownload", 1);
          paramJSONObject.put("thumbUrlInfo", localJSONObject);
        }
        paramJSONObject.put("streamVideoEnterCount", this.xcM);
        paramJSONObject.put("streamVideoPlayCount", this.wys);
        paramJSONObject.put("streamVideoPlayCompleteCount", this.wyt);
        paramJSONObject.put("streamVideoTotalPlayTimeInMs", this.wyu);
        AppMethodBeat.o(96729);
        return true;
      }
      return false;
    }
    catch (JSONException paramJSONObject)
    {
      com.tencent.mm.sdk.platformtools.ad.printErrStackTrace("MicroMsg.Sns.AdLandingPageSightVideoComponent", paramJSONObject, "", new Object[0]);
      AppMethodBeat.o(96729);
    }
  }
  
  public final void cka()
  {
    AppMethodBeat.i(187454);
    qc(false);
    this.xch = 4;
    AppMethodBeat.o(187454);
  }
  
  public final void ckb()
  {
    AppMethodBeat.i(187455);
    this.xch = 3;
    bOu();
    AppMethodBeat.o(187455);
  }
  
  public final void dvA()
  {
    AppMethodBeat.i(96726);
    super.dvA();
    qc(false);
    if ((!this.xcb) && (!this.xcc))
    {
      AppMethodBeat.o(96726);
      return;
    }
    this.xcc = false;
    this.xcb = false;
    if (this.xch == 1) {
      this.xch = 2;
    }
    int i = this.xch;
    com.tencent.mm.sdk.platformtools.ad.d("MicroMsg.Sns.AdLandingPageSightVideoComponent", "disappear handleType %d", new Object[] { Integer.valueOf(this.xch) });
    AppMethodBeat.o(96726);
  }
  
  public final void dvB()
  {
    AppMethodBeat.i(96728);
    super.dvB();
    int i = dwc();
    int j = getView().getHeight();
    com.tencent.mm.sdk.platformtools.ad.d("MicroMsg.Sns.AdLandingPageSightVideoComponent", "inScreenHeight %d, height %d", new Object[] { Integer.valueOf(i), Integer.valueOf(j) });
    if ((i == 0) || (j == 0))
    {
      AppMethodBeat.o(96728);
      return;
    }
    this.xcO = i;
    this.fIO = j;
    if (i < 0)
    {
      AppMethodBeat.o(96728);
      return;
    }
    com.tencent.mm.sdk.platformtools.ad.d("MicroMsg.Sns.AdLandingPageSightVideoComponent", "appeared handleType %d", new Object[] { Integer.valueOf(this.xch) });
    if (i >= j * 0.5F)
    {
      if ((this.xcb) && (!this.xcc))
      {
        AppMethodBeat.o(96728);
        return;
      }
      this.xcc = false;
      this.xcb = true;
      if (this.xch == 6)
      {
        if (this.xcS)
        {
          this.xch = 1;
          AppMethodBeat.o(96728);
          return;
        }
        this.xch = 4;
        AppMethodBeat.o(96728);
        return;
      }
      if (this.xch == 0)
      {
        if (this.xbZ) {
          dvw();
        }
        for (;;)
        {
          this.xch = 1;
          bOu();
          AppMethodBeat.o(96728);
          return;
          dvC();
        }
      }
      if (this.xch == 2)
      {
        if (this.xbZ) {
          dvw();
        }
        for (;;)
        {
          bOu();
          this.xch = 1;
          AppMethodBeat.o(96728);
          return;
          dvC();
        }
      }
      if (this.xch == 3)
      {
        if (this.xbZ) {
          dvw();
        }
        for (;;)
        {
          bOu();
          AppMethodBeat.o(96728);
          return;
          dvC();
        }
      }
    }
    else
    {
      this.xcc = false;
      this.xcb = false;
      qc(false);
      if (this.xch == 1) {
        this.xch = 2;
      }
      i = this.xch;
    }
    AppMethodBeat.o(96728);
  }
  
  public final void dvC()
  {
    AppMethodBeat.i(96724);
    super.dvC();
    this.xbR.setImageDrawable(com.tencent.mm.cd.a.l(this.context, 2131690342));
    this.xcK.setMute(false);
    this.xbZ = false;
    AppMethodBeat.o(96724);
  }
  
  protected final void dvN()
  {
    AppMethodBeat.i(96730);
    com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.Sns.AdLandingPageSightVideoComponent", getClass().getName() + "not support update now");
    AppMethodBeat.o(96730);
  }
  
  public final void dvw()
  {
    AppMethodBeat.i(96723);
    super.dvw();
    this.xbR.setImageDrawable(com.tencent.mm.cd.a.l(this.context, 2131690341));
    this.xcK.setMute(true);
    this.xbZ = true;
    AppMethodBeat.o(96723);
  }
  
  public final void dvx()
  {
    AppMethodBeat.i(96718);
    if (!com.tencent.mm.vfs.i.eK(h.iU("adId", ((u)this.xab).wWv))) {
      this.xcf = false;
    }
    if (!com.tencent.mm.vfs.i.eK(com.tencent.mm.loader.j.b.aih() + "/sns_ad_landingpages/adId_stream_" + ai.du(((u)this.xab).wWu))) {
      this.xcg = false;
    }
    View localView = this.contentView.findViewById(2131304914);
    this.xcW = localView;
    Object localObject1 = (ViewGroup)localView.findViewById(2131304907);
    this.xcK = new OfflineVideoView(this.context);
    this.xcX = ((View)localObject1);
    ((ViewGroup)localObject1).addView(this.xcK, new LinearLayout.LayoutParams(-1, -1));
    int i;
    Object localObject2;
    if (((u)this.xab).wWA == 0) {
      if ((int)((u)this.xab).width > 0)
      {
        i = this.kvn;
        localObject2 = new RelativeLayout.LayoutParams(i, (int)(i * ((u)this.xab).height / ((u)this.xab).width));
        ((ViewGroup)localObject1).setLayoutParams((ViewGroup.LayoutParams)localObject2);
        localView.setLayoutParams((ViewGroup.LayoutParams)localObject2);
        if (((u)this.xab).wWC) {
          break label1153;
        }
        com.tencent.mm.sdk.platformtools.ad.e("MicroMsg.Sns.AdLandingPageSightVideoComponent", "fixVideoBlackline, enable=false");
        label255:
        com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.Sns.AdLandingPageSightVideoComponent", "createView, displayType=" + ((u)this.xab).wWA);
        localObject1 = h.iU("adId", ((u)this.xab).wWv);
        if (!com.tencent.mm.vfs.i.eK((String)localObject1)) {
          break label1507;
        }
        this.xcK.aqt((String)localObject1);
      }
    }
    for (;;)
    {
      this.xbU = ((TextView)localView.findViewById(2131299517));
      this.xbU.setText(this.context.getString(2131758104));
      this.lRB = localView.findViewById(2131304920);
      if (this.lRB != null)
      {
        localObject1 = new RelativeLayout.LayoutParams(-1, -1);
        localObject2 = this.lRB.getParent();
        if ((localObject2 instanceof ViewGroup)) {
          ((ViewGroup)localObject2).removeView(this.lRB);
        }
        ((ViewGroup)localView).addView(this.lRB, (ViewGroup.LayoutParams)localObject1);
      }
      this.xbR = ((ImageView)localView.findViewById(2131304921));
      this.xbR.setVisibility(0);
      this.xbR.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(96714);
          paramAnonymousView = ad.this;
          paramAnonymousView.xcl += 1;
          ad.a(ad.this, ad.d(ad.this));
          if (ad.this.xbZ)
          {
            ad.this.dvD();
            ad.this.dvC();
            AppMethodBeat.o(96714);
            return;
          }
          ad.this.dvw();
          AppMethodBeat.o(96714);
        }
      });
      try
      {
        localObject1 = this.xbR.getParent();
        if ((localObject1 instanceof ViewGroup)) {
          ((ViewGroup)localObject1).removeView(this.xbR);
        }
        localObject1 = (RelativeLayout.LayoutParams)this.xbR.getLayoutParams();
        ((RelativeLayout.LayoutParams)localObject1).bottomMargin = com.tencent.mm.cd.a.fromDPToPix(this.context, 8);
        ((RelativeLayout.LayoutParams)localObject1).rightMargin = com.tencent.mm.cd.a.fromDPToPix(this.context, 10);
        ((ViewGroup)localView).addView(this.xbR, (ViewGroup.LayoutParams)localObject1);
        com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.Sns.AdLandingPageSightVideoComponent.VideoOptimize", "init voiceTypeBtn and visible");
      }
      catch (Throwable localThrowable2)
      {
        for (;;)
        {
          com.tencent.mm.sdk.platformtools.ad.e("MicroMsg.Sns.AdLandingPageSightVideoComponent.VideoOptimize", localThrowable2.toString());
          continue;
          i = 0;
        }
      }
      this.xcK.setVideoCallback(new OfflineVideoView.a()
      {
        public final boolean a(PString paramAnonymousPString)
        {
          AppMethodBeat.i(187436);
          final long l = System.currentTimeMillis();
          final String str1 = ad.e(ad.this).wWu;
          final String str2 = h.iV("adId", str1);
          if (com.tencent.mm.vfs.i.eK(str2))
          {
            paramAnonymousPString.value = str2;
            ad.f(ad.this);
            AppMethodBeat.o(187436);
            return true;
          }
          if (!ad.e(ad.this).wWD) {
            h.d("adId", str1, false, 62, new f.a()
            {
              public final void apm(String paramAnonymous2String)
              {
                AppMethodBeat.i(187431);
                com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.Sns.AdLandingPageSightVideoComponent", "downloadSightForAdLandingPages succ, video view height " + ad.this.contentView.getHeight() + ", player height " + ad.c(ad.this).getHeight() + ", timeCost=" + (System.currentTimeMillis() - l));
                ad.a(ad.this, false);
                ad.a(ad.this, paramAnonymous2String);
                ad.c(ad.this).YI(paramAnonymous2String);
                ad.f(ad.this);
                AppMethodBeat.o(187431);
              }
              
              public final void dsA()
              {
                AppMethodBeat.i(187430);
                com.tencent.mm.sdk.platformtools.ad.e("MicroMsg.Sns.AdLandingPageSightVideoComponent", "downloadSightForAdLandingPages fail:" + str1);
                ad.a(ad.this, true);
                ad.apw(str2);
                AppMethodBeat.o(187430);
              }
              
              public final void duP() {}
            });
          }
          for (;;)
          {
            AppMethodBeat.o(187436);
            return false;
            h.b("adId", str1, new f.a()
            {
              public final void apm(String paramAnonymous2String)
              {
                AppMethodBeat.i(187433);
                com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.Sns.AdLandingPageSightVideoComponent", "downloadSightForAdLandingPagesByCdn succ, video view height " + ad.this.contentView.getHeight() + ", player height " + ad.c(ad.this).getHeight() + ", timeCost=" + (System.currentTimeMillis() - l));
                ad.a(ad.this, false);
                ad.a(ad.this, paramAnonymous2String);
                ad.c(ad.this).YI(paramAnonymous2String);
                ad.f(ad.this);
                AppMethodBeat.o(187433);
              }
              
              public final void dsA()
              {
                AppMethodBeat.i(187432);
                com.tencent.mm.sdk.platformtools.ad.e("MicroMsg.Sns.AdLandingPageSightVideoComponent", "downloadSightForAdLandingPagesByCdn fail:" + str1);
                ad.a(ad.this, true);
                AppMethodBeat.o(187432);
              }
              
              public final void duP() {}
            });
          }
        }
        
        public final void onCompletion()
        {
          AppMethodBeat.i(187437);
          aq.f(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(187434);
              if ((ad.e(ad.this).wWB != null) && (!ad.g(ad.this)))
              {
                int i = ad.c(ad.this).getDurationMs();
                int j = ad.e(ad.this).wWB.wXq;
                com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.Sns.AdLandingPageSightVideoComponent", "OpenSnsAdFloatPageEvent, onCompletion totalMs=" + i + ", floatStartTime=" + j + ", hasShowFloat=" + ad.g(ad.this));
                if (i < j)
                {
                  ad.h(ad.this);
                  nr localnr = new nr();
                  localnr.dsM.dsN = ad.e(ad.this).wWB.dsN;
                  com.tencent.mm.sdk.b.a.ESL.l(localnr);
                }
              }
              AppMethodBeat.o(187434);
            }
          });
          ad.i(ad.this);
          ad.j(ad.this);
          AppMethodBeat.o(187437);
        }
        
        public final void onStart(int paramAnonymousInt)
        {
          AppMethodBeat.i(187438);
          ad.k(ad.this);
          ad.a(ad.this, paramAnonymousInt);
          ad.this.xbR.setVisibility(0);
          try
          {
            if (ad.l(ad.this).getVideoTotalTime() != paramAnonymousInt) {
              ad.l(ad.this).setVideoTotalTime(ad.m(ad.this));
            }
            com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.Sns.AdLandingPageSightVideoComponent.VideoOptimize", "onStart");
            AppMethodBeat.o(187438);
            return;
          }
          catch (Throwable localThrowable)
          {
            com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.Sns.AdLandingPageSightVideoComponent.VideoOptimize", localThrowable.toString());
            AppMethodBeat.o(187438);
          }
        }
        
        public final void sa(int paramAnonymousInt)
        {
          AppMethodBeat.i(187439);
          aq.f(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(187435);
              com.tencent.mm.sdk.platformtools.ad.d("MicroMsg.Sns.AdLandingPageSightVideoComponent", "play time " + this.wuf + " video time " + ad.m(ad.this));
              ad.b(ad.this, this.wuf);
              if ((ad.e(ad.this).wWB != null) && (!ad.g(ad.this)))
              {
                int i = ad.e(ad.this).wWB.wXq / 1000;
                com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.Sns.AdLandingPageSightVideoComponent", "OpenSnsAdFloatPageEvent, updateTime seconds=" + this.wuf + ", floatSeconds=" + i + ", hasShowFloat=" + ad.g(ad.this));
                if (this.wuf >= i)
                {
                  ad.h(ad.this);
                  nr localnr = new nr();
                  localnr.dsM.dsN = ad.e(ad.this).wWB.dsN;
                  com.tencent.mm.sdk.b.a.ESL.l(localnr);
                }
              }
              AppMethodBeat.o(187435);
            }
          });
          AppMethodBeat.o(187439);
        }
      });
      this.xbR.setVisibility(8);
      this.xcK.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(187440);
          if (ad.n(ad.this))
          {
            paramAnonymousView = ad.this;
            paramAnonymousView.xcN += 1;
            if (ad.o(ad.this))
            {
              AppMethodBeat.o(187440);
              return;
            }
          }
          AppMethodBeat.o(187440);
        }
      });
      localObject1 = (u)this.xab;
      if ((((u)localObject1).subType != 1) || (((u)localObject1).wWx.length() <= 0) || (((u)localObject1).wWw.length() <= 0)) {
        break label1553;
      }
      i = 1;
      if (i != 0)
      {
        localObject1 = this.contentView.findViewById(2131304908);
        ((View)localObject1).setVisibility(0);
        localObject2 = (Button)((View)localObject1).findViewById(2131304909);
        ((Button)localObject2).setTextColor(((u)this.xab).wWy);
        ((Button)localObject2).setText(((u)this.xab).wWx);
        ((Button)localObject2).setOnClickListener(new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            AppMethodBeat.i(187441);
            ad.this.dww();
            AppMethodBeat.o(187441);
          }
        });
        ((View)localObject1).findViewById(2131304910).setBackgroundColor(((u)this.xab).wWz);
      }
      try
      {
        this.length = com.tencent.mm.cd.a.fromDPToPix(this.context, 32);
        this.xcK.setOnTouchListener(this);
        this.xcQ = ((ImageView)localView.findViewById(2131307246));
        localObject1 = this.xcQ.getParent();
        if ((localObject1 instanceof ViewGroup)) {
          ((ViewGroup)localObject1).removeView(this.xcQ);
        }
        localObject1 = (RelativeLayout.LayoutParams)this.xcQ.getLayoutParams();
        ((RelativeLayout.LayoutParams)localObject1).bottomMargin = com.tencent.mm.cd.a.fromDPToPix(this.context, 8);
        ((RelativeLayout.LayoutParams)localObject1).rightMargin = com.tencent.mm.cd.a.fromDPToPix(this.context, 10);
        ((ViewGroup)localView).addView(this.xcQ, (ViewGroup.LayoutParams)localObject1);
        this.xcQ.setOnClickListener(this);
        this.xcQ.setVisibility(8);
        com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.Sns.AdLandingPageSightVideoComponent.VideoOptimize", "init fullScreenBtn and visible");
      }
      catch (Throwable localThrowable3)
      {
        for (;;)
        {
          label1082:
          int j;
          label1153:
          label1507:
          com.tencent.mm.sdk.platformtools.ad.e("MicroMsg.Sns.AdLandingPageSightVideoComponent.VideoOptimize", localThrowable3.toString());
          continue;
          boolean bool = false;
        }
      }
      try
      {
        this.xbQ = new VideoPlayerSeekBar(this.context);
        localObject1 = this.xbQ.getParent();
        if ((localObject1 instanceof ViewGroup)) {
          ((ViewGroup)localObject1).removeView(this.xbQ);
        }
        localObject1 = new RelativeLayout.LayoutParams(this.xcX.getLayoutParams().width - com.tencent.mm.cd.a.fromDPToPix(this.context, 75), -2);
        ((RelativeLayout.LayoutParams)localObject1).addRule(12);
        ((RelativeLayout.LayoutParams)localObject1).bottomMargin = com.tencent.mm.cd.a.fromDPToPix(this.context, 3);
        this.xbQ.setLayoutParams((ViewGroup.LayoutParams)localObject1);
        ((ViewGroup)this.contentView.findViewById(2131298770)).addView(this.xbQ, (ViewGroup.LayoutParams)localObject1);
        MJ(0);
        this.xbQ.setOnPlayButtonClickListener(this.xcn);
        this.xbQ.setIplaySeekCallback(this.qmw);
        this.xbQ.setVisibility(4);
        if (this.xcm != null)
        {
          localObject1 = this.xcm;
          if (this.xbQ.getVisibility() == 0)
          {
            bool = true;
            ((ak)localObject1).qa(bool);
          }
        }
        else
        {
          com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.Sns.AdLandingPageSightVideoComponent.VideoOptimize", "init progressBar and visible");
        }
      }
      catch (Throwable localThrowable4)
      {
        com.tencent.mm.sdk.platformtools.ad.e("MicroMsg.Sns.AdLandingPageSightVideoComponent.VideoOptimize", localThrowable4.toString());
        break label1082;
      }
      try
      {
        this.xcR = localView.findViewById(2131307220);
        this.xcR.setVisibility(8);
        AppMethodBeat.o(96718);
        return;
      }
      catch (Throwable localThrowable1)
      {
        com.tencent.mm.sdk.platformtools.ad.e("MicroMsg.Sns.AdLandingPageSightVideoComponent.VideoOptimize", localThrowable1.toString());
        AppMethodBeat.o(96718);
      }
      ((ViewGroup)localObject1).setLayoutParams(new RelativeLayout.LayoutParams(this.kvn, this.kvo));
      localView.setLayoutParams(new RelativeLayout.LayoutParams(this.kvn, this.kvo));
      break;
      localObject1 = this.xcK.getInnerVideoView();
      if ((localObject1 instanceof VideoPlayerTextureView))
      {
        ((View)localObject1).addOnLayoutChangeListener(new View.OnLayoutChangeListener()
        {
          public final void onLayoutChange(View paramAnonymousView, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3, int paramAnonymousInt4, int paramAnonymousInt5, int paramAnonymousInt6, int paramAnonymousInt7, int paramAnonymousInt8)
          {
            AppMethodBeat.i(187426);
            try
            {
              paramAnonymousInt1 = paramAnonymousView.getHeight();
              paramAnonymousInt2 = paramAnonymousView.getWidth();
              paramAnonymousInt3 = ad.v(ad.this).getWidth();
              paramAnonymousInt4 = ad.v(ad.this).getHeight();
              if ((paramAnonymousInt2 <= 1) || (paramAnonymousInt1 <= 1) || (paramAnonymousInt3 == 0) || (paramAnonymousInt4 == 0))
              {
                AppMethodBeat.o(187426);
                return;
              }
              com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.Sns.AdLandingPageSightVideoComponent", "onLayoutChange, video.w=" + paramAnonymousView.getWidth() + ", h=" + paramAnonymousView.getHeight() + ", container.w=" + paramAnonymousInt3 + ", h=" + paramAnonymousInt4 + ", container.padding=" + j.ep(ad.v(ad.this)));
              if (paramAnonymousInt1 == paramAnonymousInt4)
              {
                AppMethodBeat.o(187426);
                return;
              }
              if ((paramAnonymousInt1 >= paramAnonymousInt2) && (paramAnonymousInt4 >= paramAnonymousInt3) && (Math.abs(paramAnonymousInt1 - paramAnonymousInt4) < 2))
              {
                paramAnonymousView = ad.v(ad.this).getLayoutParams();
                paramAnonymousView.height = paramAnonymousInt1;
                ad.v(ad.this).setLayoutParams(paramAnonymousView);
                com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.Sns.AdLandingPageSightVideoComponent", "onLayoutChange, reset VideoContainer.height");
              }
              AppMethodBeat.o(187426);
              return;
            }
            catch (Exception paramAnonymousView)
            {
              com.tencent.mm.sdk.platformtools.ad.e("MicroMsg.Sns.AdLandingPageSightVideoComponent", "onLayoutChange, exp=" + paramAnonymousView.toString());
              AppMethodBeat.o(187426);
            }
          }
        });
        break label255;
      }
      com.tencent.mm.sdk.platformtools.ad.e("MicroMsg.Sns.AdLandingPageSightVideoComponent", "onLayoutChange, innerVideoView=" + localObject1 + ", displayType=" + ((u)this.xab).wWA);
      break label255;
      if (((u)this.xab).wWA == 1)
      {
        if (((u)this.xab).width / this.kvn > ((u)this.xab).height / this.kvo)
        {
          j = this.kvn;
          i = (int)(j * ((u)this.xab).height / ((u)this.xab).width) + 1;
        }
        for (;;)
        {
          localObject2 = new RelativeLayout.LayoutParams(j, i);
          ((RelativeLayout.LayoutParams)localObject2).leftMargin = ((this.kvn - j) / 2);
          ((RelativeLayout.LayoutParams)localObject2).rightMargin = ((RelativeLayout.LayoutParams)localObject2).leftMargin;
          ((RelativeLayout.LayoutParams)localObject2).topMargin = ((this.kvo - i) / 2);
          ((RelativeLayout.LayoutParams)localObject2).bottomMargin = ((RelativeLayout.LayoutParams)localObject2).topMargin;
          ((ViewGroup)localObject1).setLayoutParams((ViewGroup.LayoutParams)localObject2);
          localView.setLayoutParams(new RelativeLayout.LayoutParams(this.kvn, this.kvo));
          break;
          i = this.kvo;
          j = (int)(i * ((u)this.xab).width / ((u)this.xab).height) + 1;
        }
      }
      if (((u)this.xab).wWA != 2) {
        break label255;
      }
      localObject2 = new RelativeLayout.LayoutParams((int)((u)this.xab).width, (int)((u)this.xab).height);
      ((ViewGroup)localObject1).setLayoutParams((ViewGroup.LayoutParams)localObject2);
      localView.setLayoutParams(new RelativeLayout.LayoutParams((RelativeLayout.LayoutParams)localObject2));
      break label255;
      h.c("adId", ((u)this.xab).wWv, false, 1000000001, new f.a()
      {
        public final void apm(String paramAnonymousString)
        {
          AppMethodBeat.i(187429);
          ad.c(ad.this).aqt(paramAnonymousString);
          AppMethodBeat.o(187429);
        }
        
        public final void dsA() {}
        
        public final void duP() {}
      });
    }
    label1553:
  }
  
  public final void dvy()
  {
    AppMethodBeat.i(96727);
    super.dvy();
    try
    {
      this.gAC.removeCallbacks(this.xbV);
      this.gAC.removeCallbacks(this.xcT);
      this.xcK.onDestroy();
      AppMethodBeat.o(96727);
      return;
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        com.tencent.mm.sdk.platformtools.ad.e("MicroMsg.Sns.AdLandingPageSightVideoComponent.VideoOptimize", localThrowable.toString());
      }
    }
  }
  
  public final void dvz()
  {
    AppMethodBeat.i(96725);
    super.dvz();
    AppMethodBeat.o(96725);
  }
  
  public final void dwg()
  {
    AppMethodBeat.i(96731);
    super.dwg();
    String str = h.iU("adId", ((u)this.xab).wWv);
    qc(false);
    if (com.tencent.mm.vfs.i.eK(str))
    {
      this.xcK.aqt(str);
      this.xcK.b(false, 0.0F);
    }
    AppMethodBeat.o(96731);
  }
  
  public final void dww()
  {
    AppMethodBeat.i(96719);
    u localu = (u)this.xab;
    if (bt.isNullOrNil(localu.wWw))
    {
      com.tencent.mm.sdk.platformtools.ad.e("MicroMsg.Sns.AdLandingPageSightVideoComponent", "on long video button click without streamVideoUrl!");
      AppMethodBeat.o(96719);
      return;
    }
    if (!(this.context instanceof Activity))
    {
      com.tencent.mm.sdk.platformtools.ad.e("MicroMsg.Sns.AdLandingPageSightVideoComponent", "on long video button click but context not activity!");
      AppMethodBeat.o(96719);
      return;
    }
    com.tencent.mm.sdk.platformtools.ad.v("MicroMsg.Sns.AdLandingPageSightVideoComponent", "on long video button click, jumpto [%s]", new Object[] { localu.wWw });
    Intent localIntent = new Intent();
    if (AdLandingPagesProxy.getInstance().getStreamVideoPlayerConfig() > 0)
    {
      localIntent.setClass(this.context, SnsAdStreamVideoPlayUI.class);
      com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.Sns.AdLandingPageSightVideoComponent", "use new stream video play UI");
    }
    for (;;)
    {
      localIntent.putExtra("KFromTimeLine", true);
      localIntent.putExtra("KMediaId", ai.du(localu.wWw));
      localIntent.putExtra("KThumUrl", localu.wWv);
      localIntent.putExtra("KStremVideoUrl", localu.wWw);
      localIntent.putExtra("ForceLandscape", true);
      localIntent.putExtra("ShareBtnHidden", 1);
      localIntent.putExtra("KComponentCid", dwe());
      ((Activity)this.context).startActivityForResult(localIntent, xcY);
      this.xcM += 1;
      AppMethodBeat.o(96719);
      return;
      localIntent.setClass(this.context, VideoAdPlayerUI.class);
    }
  }
  
  protected final int getLayout()
  {
    return 2131495508;
  }
  
  public final boolean isPlaying()
  {
    AppMethodBeat.i(187446);
    boolean bool = this.xcK.isPlaying();
    AppMethodBeat.o(187446);
    return bool;
  }
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(187450);
    if (paramView.getId() == 2131307246)
    {
      com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.Sns.AdLandingPageSightVideoComponent.VideoOptimize", "click full screen btn");
      try
      {
        if ((this.context instanceof SnsAdNativeLandingPagesUI))
        {
          this.xcV += 1;
          this.gAC.removeCallbacks(this.xcT);
          this.xcR.setVisibility(8);
          paramView = (SnsAdNativeLandingPagesUI)this.context;
          Intent localIntent = new Intent(paramView, VideoFullScreenActivity.class);
          localIntent.putExtra("KComponentVideoType", 0);
          localIntent.putExtra("KComponentCid", dwe());
          localIntent.putExtra("KComponentCurrentTime", this.xcK.getCurrentPositionMs());
          localIntent.putExtra("KComponentTotalTime", this.xcK.getDurationMs());
          localIntent.putExtra("KComponentVoiceType", this.xbZ);
          localIntent.putExtra("KComponentProgressType", this.xcK.isPlaying());
          localIntent.putExtra("KComponentVideoSightThumbUrl", ((u)this.xab).wWv);
          localIntent.putExtra("KComponentStreamVideoUrlPath", ((u)this.xab).wWu);
          paramView.startActivityForResult(localIntent, SnsAdNativeLandingPagesUI.xuk);
          AppMethodBeat.o(187450);
          return;
        }
        this.xcQ.setVisibility(8);
        AppMethodBeat.o(187450);
        return;
      }
      catch (Throwable paramView)
      {
        this.xcQ.setVisibility(8);
        com.tencent.mm.sdk.platformtools.ad.e("NonFullOrFullVideoType", paramView.toString());
      }
    }
    AppMethodBeat.o(187450);
  }
  
  public final boolean onDoubleTap(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(187452);
    for (;;)
    {
      try
      {
        com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.Sns.AdLandingPageSightVideoComponent.VideoOptimize", "onDoubleTap");
        ap(this.xbV);
        if (this.fWx) {
          this.xcU += 1;
        }
        if (!this.xcK.isPlaying()) {
          continue;
        }
        qc(true);
        this.xch = 4;
      }
      catch (Throwable paramMotionEvent)
      {
        com.tencent.mm.sdk.platformtools.ad.e("MicroMsg.Sns.AdLandingPageSightVideoComponent.VideoOptimize", paramMotionEvent.toString());
        continue;
        dvD();
        dvC();
        continue;
      }
      AppMethodBeat.o(187452);
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
    bool = true;
    AppMethodBeat.i(187451);
    for (;;)
    {
      try
      {
        com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.Sns.AdLandingPageSightVideoComponent.VideoOptimize", "onSingleTapConfirmed");
        if (!this.fWx) {
          continue;
        }
        if (this.xbQ.getVisibility() != 0) {
          continue;
        }
        i = 1;
        if (i == 0) {
          continue;
        }
        this.xbQ.setVisibility(4);
        this.xcQ.setVisibility(4);
        this.gAC.removeCallbacks(this.xbV);
        if (this.xcm == null) {
          continue;
        }
        paramMotionEvent = this.xcm;
        if (i != 0) {
          continue;
        }
      }
      catch (Throwable paramMotionEvent)
      {
        int i;
        com.tencent.mm.sdk.platformtools.ad.e("MicroMsg.Sns.AdLandingPageSightVideoComponent.VideoOptimize", paramMotionEvent.toString());
        continue;
        bool = false;
        continue;
      }
      paramMotionEvent.qa(bool);
      AppMethodBeat.o(187451);
      return false;
      i = 0;
      continue;
      this.xbQ.setVisibility(0);
      this.xcQ.setVisibility(0);
      ap(this.xbV);
    }
  }
  
  public final boolean onSingleTapUp(MotionEvent paramMotionEvent)
  {
    return false;
  }
  
  @SuppressLint({"ClickableViewAccessibility"})
  public final boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(187449);
    boolean bool = this.hRv.onTouchEvent(paramMotionEvent);
    AppMethodBeat.o(187449);
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.ad
 * JD-Core Version:    0.7.0.1
 */