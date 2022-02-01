package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.media.AudioManager;
import android.media.AudioManager.OnAudioFocusChangeListener;
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
import com.tencent.mm.br.d;
import com.tencent.mm.g.a.oa;
import com.tencent.mm.plugin.sns.data.j;
import com.tencent.mm.plugin.sns.model.AdLandingPagesProxy;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.ae;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.af;
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
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.ao;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.ax;
import com.tencent.mm.sdk.platformtools.bs;
import org.json.JSONException;
import org.json.JSONObject;

public final class ad
  extends com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.a
  implements GestureDetector.OnDoubleTapListener, GestureDetector.OnGestureListener, View.OnClickListener, View.OnTouchListener
{
  public static int ypN = 999;
  private Context context;
  int fMu;
  private View gGk;
  private boolean gbe;
  private ao gox;
  private GestureDetector irA;
  private boolean isAutoPlay;
  private String kmA;
  private int length;
  private com.tencent.mm.plugin.sight.decode.ui.b qUY;
  private int vdM;
  private long vdg;
  public int xJT;
  public int xJU;
  public int xJV;
  private VideoPlayerSeekBar yoF;
  ImageView yoG;
  private boolean yoH;
  private TextView yoJ;
  private Runnable yoK;
  boolean yoO;
  private boolean yoQ;
  private boolean yoR;
  private boolean yoS;
  boolean yoT;
  boolean yoU;
  private volatile int yoV;
  private int yoW;
  private int yoX;
  private int yoY;
  int yoZ;
  private int ypA;
  int ypB;
  int ypC;
  private boolean ypD;
  private ImageView ypE;
  private View ypF;
  private volatile boolean ypG;
  private Runnable ypH;
  private int ypI;
  private int ypJ;
  private a ypK;
  private View ypL;
  private View ypM;
  private ak ypa;
  private View.OnClickListener ypb;
  OfflineVideoView ypy;
  private int ypz;
  
  public ad(Context paramContext, u paramu, ViewGroup paramViewGroup)
  {
    super(paramContext, paramu, paramViewGroup);
    AppMethodBeat.i(96717);
    this.vdg = 0L;
    this.yoW = 0;
    this.vdM = 0;
    this.yoX = 0;
    this.ypA = 0;
    this.xJT = 0;
    this.xJU = 0;
    this.xJV = 0;
    this.yoZ = 0;
    this.ypB = 0;
    this.yoO = true;
    this.ypC = 0;
    this.fMu = 0;
    this.yoV = 0;
    this.yoQ = false;
    this.yoR = true;
    this.isAutoPlay = false;
    this.yoT = true;
    this.yoU = true;
    this.yoS = false;
    this.ypG = false;
    this.ypa = null;
    this.ypb = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(200221);
        for (;;)
        {
          try
          {
            ac.i("MicroMsg.Sns.AdLandingPageSightVideoComponent.VideoOptimize", "play btn onclick isPlaying[%b]", new Object[] { Boolean.valueOf(ad.this.ypy.isPlaying()) });
            ad.a(ad.this, ad.d(ad.this));
            if (ad.this.ypy.isPlaying())
            {
              ad.p(ad.this);
              ad.c(ad.this, 4);
              if (ad.r(ad.this)) {
                ad.s(ad.this);
              }
              AppMethodBeat.o(200221);
              return;
            }
            if (ad.this.yoO)
            {
              ad.this.dJV();
              ad.q(ad.this);
              ad.c(ad.this, 3);
              continue;
            }
            ad.this.dKc();
          }
          catch (Throwable paramAnonymousView)
          {
            ac.e("MicroMsg.Sns.AdLandingPageSightVideoComponent.VideoOptimize", paramAnonymousView.toString());
            AppMethodBeat.o(200221);
            return;
          }
          ad.this.dKb();
        }
      }
    };
    this.qUY = new com.tencent.mm.plugin.sight.decode.ui.b()
    {
      public final void anR()
      {
        AppMethodBeat.i(200222);
        try
        {
          ad.a(ad.this, ad.d(ad.this));
          if (ad.c(ad.this) != null) {
            ad.c(ad.this).dNS();
          }
          AppMethodBeat.o(200222);
          return;
        }
        catch (Throwable localThrowable)
        {
          ac.e("MicroMsg.Sns.AdLandingPageSightVideoComponent.VideoOptimize", localThrowable.toString());
          AppMethodBeat.o(200222);
        }
      }
      
      public final void nn(int paramAnonymousInt)
      {
        AppMethodBeat.i(200223);
        try
        {
          ac.i("MicroMsg.Sns.AdLandingPageSightVideoComponent.VideoOptimize", "onSeek time ".concat(String.valueOf(paramAnonymousInt)));
          if (ad.this.yoO) {
            ad.this.dJV();
          }
          for (;;)
          {
            ad.c(ad.this).ax(paramAnonymousInt * 1000, true);
            ad.c(ad.this, 3);
            ad.b(ad.this, true);
            ad.u(ad.this).removeCallbacks(ad.t(ad.this));
            ad.b(ad.this).setVisibility(8);
            AppMethodBeat.o(200223);
            return;
            ad.this.dKb();
          }
          return;
        }
        catch (Throwable localThrowable)
        {
          ac.e("MicroMsg.Sns.AdLandingPageSightVideoComponent.VideoOptimize", localThrowable.toString());
          AppMethodBeat.o(200223);
        }
      }
    };
    this.yoY = 0;
    this.ypI = 0;
    this.ypJ = 0;
    this.context = paramContext;
    this.gox = new ao(Looper.getMainLooper());
    try
    {
      this.irA = new GestureDetector(this);
      this.yoK = new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(200220);
          ad.a(ad.this);
          AppMethodBeat.o(200220);
        }
      };
      this.ypH = new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(200227);
          ad.b(ad.this).setVisibility(8);
          AppMethodBeat.o(200227);
        }
      };
      this.ypa = new ad.8(this, paramContext);
      AppMethodBeat.o(96717);
      return;
    }
    catch (Throwable paramContext)
    {
      ac.e("MicroMsg.Sns.AdLandingPageSightVideoComponent.VideoOptimize", paramContext.toString());
      AppMethodBeat.o(96717);
    }
  }
  
  private void OL(final int paramInt)
  {
    AppMethodBeat.i(200245);
    try
    {
      this.gox.post(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(200242);
          ad.l(ad.this).seek(paramInt);
          ad.b(ad.this, ad.this.ypy.isPlaying());
          AppMethodBeat.o(200242);
        }
      });
      AppMethodBeat.o(200245);
      return;
    }
    catch (Throwable localThrowable)
    {
      ac.e("MicroMsg.Sns.AdLandingPageSightVideoComponent.VideoOptimize", localThrowable.toString());
      AppMethodBeat.o(200245);
    }
  }
  
  private void abandonAudioFocus()
  {
    AppMethodBeat.i(200257);
    try
    {
      if (this.ypK != null)
      {
        AudioManager localAudioManager = (AudioManager)this.context.getSystemService("audio");
        if (localAudioManager != null)
        {
          localAudioManager.abandonAudioFocus(this.ypK);
          this.ypK = null;
        }
      }
      AppMethodBeat.o(200257);
      return;
    }
    catch (Throwable localThrowable)
    {
      ac.e("MicroMsg.Sns.AdLandingPageSightVideoComponent", "abandonAudioFocus has something wrong!");
      AppMethodBeat.o(200257);
    }
  }
  
  private void ar(Runnable paramRunnable)
  {
    AppMethodBeat.i(200249);
    try
    {
      this.gox.removeCallbacks(paramRunnable);
      this.gox.postDelayed(paramRunnable, 4000L);
      AppMethodBeat.o(200249);
      return;
    }
    catch (Throwable paramRunnable)
    {
      ac.e("MicroMsg.Sns.AdLandingPageSightVideoComponent.VideoOptimize", paramRunnable.toString());
      AppMethodBeat.o(200249);
    }
  }
  
  public static void auG(String paramString)
  {
    int i = 1;
    AppMethodBeat.i(200248);
    Object localObject = "0";
    for (;;)
    {
      try
      {
        if (com.tencent.mm.vfs.i.eA(paramString))
        {
          String str = "1";
          localObject = str;
          if (com.tencent.mm.vfs.i.deleteFile(paramString))
          {
            localObject = str;
            paramString = ax.iH(ai.getContext());
            com.tencent.mm.plugin.sns.data.i.b(com.tencent.mm.plugin.sns.data.i.xNh, (String)localObject, 1, i, "http|".concat(String.valueOf(paramString)));
            AppMethodBeat.o(200248);
            return;
          }
        }
      }
      catch (Throwable paramString)
      {
        ac.e("MicroMsg.Sns.AdLandingPageSightVideoComponent", "delErrorFile exp=" + paramString.toString());
        AppMethodBeat.o(200248);
        return;
      }
      i = 0;
    }
  }
  
  private void bVK()
  {
    AppMethodBeat.i(96721);
    if (this.yoS)
    {
      ac.i("MicroMsg.Sns.AdLandingPageSightVideoComponent", "last download fail ,try again");
      this.ypy.crJ();
      AppMethodBeat.o(96721);
      return;
    }
    ac.d("MicroMsg.Sns.AdLandingPageSightVideoComponent", "starting play");
    if ((!this.ypD) && (!TextUtils.isEmpty(this.kmA)))
    {
      this.ypy.ade(this.kmA);
      this.ypD = true;
    }
    this.gox.post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(200224);
        ad.c(ad.this).dNT();
        ad.v(ad.this);
        try
        {
          ad.b(ad.this, true);
          ad.u(ad.this).removeCallbacks(ad.t(ad.this));
          ad.b(ad.this).setVisibility(8);
          AppMethodBeat.o(200224);
          return;
        }
        catch (Throwable localThrowable)
        {
          ac.e("MicroMsg.Sns.AdLandingPageSightVideoComponent", localThrowable.toString());
          AppMethodBeat.o(200224);
        }
      }
    });
    this.vdg = System.currentTimeMillis();
    this.vdM += 1;
    AppMethodBeat.o(96721);
  }
  
  private boolean dKW()
  {
    AppMethodBeat.i(96720);
    if (!bs.isNullOrNil(((u)this.ymQ).yiy))
    {
      Intent localIntent = new Intent();
      localIntent.putExtra("sns_landig_pages_from_source", 14);
      localIntent.putExtra("sns_landig_pages_origin_from_source", dKH().yjY);
      localIntent.putExtra("sns_landing_pages_ux_info", dKH().dtx);
      localIntent.putExtra("sns_landing_pages_xml", "");
      localIntent.putExtra("sns_landing_pages_canvasid", ((u)this.ymQ).yiy);
      localIntent.putExtra("sns_landing_pages_canvas_ext", ((u)this.ymQ).yiz);
      localIntent.putExtra("sns_landing_pages_no_store", ((u)this.ymQ).yiA);
      localIntent.putExtra("sns_landing_pages_need_enter_and_exit_animation", true);
      String str3;
      String str1;
      String str2;
      JSONObject localJSONObject;
      if (((this.context instanceof Activity)) && (dKH().bizId == 2))
      {
        str3 = ((Activity)this.context).getIntent().getStringExtra("sns_landing_pages_sessionId");
        str1 = ((Activity)this.context).getIntent().getStringExtra("sns_landing_pages_ad_buffer");
        if (!bs.isNullOrNil(str3))
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
          localJSONObject.put("cid", ((u)this.ymQ).yjs);
          if (bs.isNullOrNil(str1)) {
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
        this.ypy.getLocationOnScreen((int[])localObject);
        localIntent.putExtra("img_gallery_top", localObject[1]);
        localIntent.putExtra("img_gallery_left", localObject[0]);
        localIntent.putExtra("img_gallery_width", this.ypy.getWidth());
        localIntent.putExtra("img_gallery_height", this.ypy.getHeight());
        d.b(this.context, "sns", ".ui.SnsAdNativeLandingPagesPreviewUI", localIntent);
        AppMethodBeat.o(96720);
        return true;
        localObject = "";
      }
    }
    AppMethodBeat.o(96720);
    return false;
  }
  
  private void ra(boolean paramBoolean)
  {
    AppMethodBeat.i(200244);
    try
    {
      this.yoF.setIsPlay(paramBoolean);
      this.yoF.getPlayBtn().getLayoutParams().width = this.length;
      this.yoF.getPlayBtn().getLayoutParams().height = this.length;
      if (paramBoolean)
      {
        ac.i("MicroMsg.Sns.AdLandingPageSightVideoComponent.VideoOptimize", "startPlay");
        this.yoF.getPlayBtn().setImageDrawable(com.tencent.mm.cc.a.l(this.context, 2131691470));
        AppMethodBeat.o(200244);
        return;
      }
      ac.i("MicroMsg.Sns.AdLandingPageSightVideoComponent.VideoOptimize", "pausePlay");
      this.yoF.getPlayBtn().setImageDrawable(com.tencent.mm.cc.a.l(this.context, 2131691469));
      AppMethodBeat.o(200244);
      return;
    }
    catch (Throwable localThrowable)
    {
      ac.e("MicroMsg.Sns.AdLandingPageSightVideoComponent.VideoOptimize", localThrowable.toString());
      AppMethodBeat.o(200244);
    }
  }
  
  private void rb(final boolean paramBoolean)
  {
    AppMethodBeat.i(200246);
    ac.d("MicroMsg.Sns.AdLandingPageSightVideoComponent", "pause play");
    this.gox.post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(200225);
        ad.c(ad.this).dNS();
        try
        {
          ad.b(ad.this, false);
          if ((ad.n(ad.this)) && (paramBoolean))
          {
            ad.b(ad.this).setVisibility(0);
            ad.a(ad.this, ad.t(ad.this));
          }
          AppMethodBeat.o(200225);
          return;
        }
        catch (Throwable localThrowable)
        {
          ac.e("MicroMsg.Sns.AdLandingPageSightVideoComponent", localThrowable.toString());
          AppMethodBeat.o(200225);
        }
      }
    });
    if (this.vdg != 0L)
    {
      this.yoW = ((int)(this.yoW + (System.currentTimeMillis() - this.vdg)));
      this.vdg = 0L;
    }
    AppMethodBeat.o(200246);
  }
  
  public final void a(int paramInt1, boolean paramBoolean1, boolean paramBoolean2, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, long paramLong)
  {
    AppMethodBeat.i(200254);
    try
    {
      this.yoV = 6;
      this.ypG = paramBoolean2;
      this.ypJ += 1;
      this.yoY += paramInt2;
      this.ypI += paramInt3;
      this.yoZ += paramInt4;
      this.yoX += paramInt5;
      this.vdM += paramInt6;
      this.yoW = ((int)(this.yoW + paramLong));
      if (paramBoolean2) {
        this.vdg = System.currentTimeMillis();
      }
      this.gox.removeCallbacks(this.ypH);
      this.ypF.setVisibility(8);
      ac.i("NonFullOrFullVideoType", "currPosSec = " + paramInt1 + ", isPlaying = " + paramBoolean2 + ", bNoVoice = " + paramBoolean1);
      paramInt2 = paramInt1 / 1000;
      if ((paramInt2 >= this.ypz) || (paramInt1 < 0))
      {
        this.yoF.seek(0);
        this.ypy.ax(0, paramBoolean2);
      }
      for (;;)
      {
        ra(paramBoolean2);
        if (!paramBoolean1) {
          break;
        }
        dJV();
        AppMethodBeat.o(200254);
        return;
        this.yoF.seek(paramInt2);
        this.ypy.ax(paramInt1, paramBoolean2);
      }
      dKb();
    }
    catch (Throwable localThrowable)
    {
      ac.e("NonFullOrFullVideoType", localThrowable.toString());
      AppMethodBeat.o(200254);
      return;
    }
    AppMethodBeat.o(200254);
  }
  
  public final boolean aH(JSONObject paramJSONObject)
  {
    AppMethodBeat.i(96729);
    if (!super.aH(paramJSONObject))
    {
      AppMethodBeat.o(96729);
      return false;
    }
    try
    {
      paramJSONObject.put("sightDuration", this.ypz * 1000);
      paramJSONObject.put("playTimeInterval", this.yoW);
      paramJSONObject.put("playCount", this.vdM);
      paramJSONObject.put("playCompletedCount", this.yoX);
      paramJSONObject.put("clickPlayControlCount", this.yoY);
      paramJSONObject.put("doubleClickCount", this.ypI);
      paramJSONObject.put("clickFullscreenBtnCount", this.ypJ);
      paramJSONObject.put("clickVoiceControlCount", this.yoZ);
      if (this.isAutoPlay) {}
      for (String str = "1";; str = "0")
      {
        paramJSONObject.put("isAutoPlay", str);
        if (((u)this.ymQ).type == 61) {
          paramJSONObject.put("clickSightCount", this.ypB);
        }
        JSONObject localJSONObject;
        if (!this.yoU)
        {
          str = ah.dg(((u)this.ymQ).yji);
          localJSONObject = new JSONObject();
          localJSONObject.put("urlMd5", str);
          localJSONObject.put("needDownload", 1);
          paramJSONObject.put("sightUrlInfo", localJSONObject);
        }
        if (!this.yoT)
        {
          str = ah.dg(((u)this.ymQ).yjj);
          localJSONObject = new JSONObject();
          localJSONObject.put("urlMd5", str);
          localJSONObject.put("needDownload", 1);
          paramJSONObject.put("thumbUrlInfo", localJSONObject);
        }
        paramJSONObject.put("streamVideoEnterCount", this.ypA);
        paramJSONObject.put("streamVideoPlayCount", this.xJT);
        paramJSONObject.put("streamVideoPlayCompleteCount", this.xJU);
        paramJSONObject.put("streamVideoTotalPlayTimeInMs", this.xJV);
        AppMethodBeat.o(96729);
        return true;
      }
      return false;
    }
    catch (JSONException paramJSONObject)
    {
      ac.printErrStackTrace("MicroMsg.Sns.AdLandingPageSightVideoComponent", paramJSONObject, "", new Object[0]);
      AppMethodBeat.o(96729);
    }
  }
  
  public final void crH()
  {
    AppMethodBeat.i(200255);
    rb(false);
    this.yoV = 4;
    AppMethodBeat.o(200255);
  }
  
  public final void crI()
  {
    AppMethodBeat.i(200256);
    this.yoV = 3;
    bVK();
    AppMethodBeat.o(200256);
  }
  
  public final void dJV()
  {
    AppMethodBeat.i(96723);
    super.dJV();
    this.yoG.setImageDrawable(com.tencent.mm.cc.a.l(this.context, 2131690341));
    this.ypy.setMute(true);
    this.yoO = true;
    AppMethodBeat.o(96723);
  }
  
  public final void dJW()
  {
    AppMethodBeat.i(96718);
    if (!com.tencent.mm.vfs.i.eA(h.js("adId", ((u)this.ymQ).yjj))) {
      this.yoT = false;
    }
    if (!com.tencent.mm.vfs.i.eA(com.tencent.mm.loader.j.b.aph() + "/sns_ad_landingpages/adId_stream_" + ah.dg(((u)this.ymQ).yji))) {
      this.yoU = false;
    }
    View localView = this.contentView.findViewById(2131304914);
    this.ypL = localView;
    Object localObject1 = (ViewGroup)localView.findViewById(2131304907);
    this.ypy = new OfflineVideoView(this.context);
    this.ypM = ((View)localObject1);
    ((ViewGroup)localObject1).addView(this.ypy, new LinearLayout.LayoutParams(-1, -1));
    int i;
    Object localObject2;
    if (((u)this.ymQ).yjo == 0) {
      if ((int)((u)this.ymQ).width > 0)
      {
        i = this.kWB;
        localObject2 = new RelativeLayout.LayoutParams(i, (int)(i * ((u)this.ymQ).height / ((u)this.ymQ).width));
        ((ViewGroup)localObject1).setLayoutParams((ViewGroup.LayoutParams)localObject2);
        localView.setLayoutParams((ViewGroup.LayoutParams)localObject2);
        if (((u)this.ymQ).yjq) {
          break label1151;
        }
        ac.e("MicroMsg.Sns.AdLandingPageSightVideoComponent", "fixVideoBlackline, enable=false");
        label254:
        ac.i("MicroMsg.Sns.AdLandingPageSightVideoComponent", "createView, displayType=" + ((u)this.ymQ).yjo);
        localObject1 = h.js("adId", ((u)this.ymQ).yjj);
        if (!com.tencent.mm.vfs.i.eA((String)localObject1)) {
          break label1504;
        }
        this.ypy.avC((String)localObject1);
      }
    }
    for (;;)
    {
      this.yoJ = ((TextView)localView.findViewById(2131299517));
      this.yoJ.setText(this.context.getString(2131758104));
      this.gGk = localView.findViewById(2131304920);
      if (this.gGk != null)
      {
        localObject1 = new RelativeLayout.LayoutParams(-1, -1);
        localObject2 = this.gGk.getParent();
        if ((localObject2 instanceof ViewGroup)) {
          ((ViewGroup)localObject2).removeView(this.gGk);
        }
        ((ViewGroup)localView).addView(this.gGk, (ViewGroup.LayoutParams)localObject1);
      }
      this.yoG = ((ImageView)localView.findViewById(2131304921));
      this.yoG.setVisibility(0);
      this.yoG.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(96714);
          paramAnonymousView = ad.this;
          paramAnonymousView.yoZ += 1;
          ad.a(ad.this, ad.d(ad.this));
          if (ad.this.yoO)
          {
            ad.this.dKc();
            ad.this.dKb();
            AppMethodBeat.o(96714);
            return;
          }
          ad.this.dJV();
          AppMethodBeat.o(96714);
        }
      });
      try
      {
        localObject1 = this.yoG.getParent();
        if ((localObject1 instanceof ViewGroup)) {
          ((ViewGroup)localObject1).removeView(this.yoG);
        }
        localObject1 = (RelativeLayout.LayoutParams)this.yoG.getLayoutParams();
        ((RelativeLayout.LayoutParams)localObject1).bottomMargin = com.tencent.mm.cc.a.fromDPToPix(this.context, 8);
        ((RelativeLayout.LayoutParams)localObject1).rightMargin = com.tencent.mm.cc.a.fromDPToPix(this.context, 10);
        ((ViewGroup)localView).addView(this.yoG, (ViewGroup.LayoutParams)localObject1);
        ac.i("MicroMsg.Sns.AdLandingPageSightVideoComponent.VideoOptimize", "init voiceTypeBtn and visible");
      }
      catch (Throwable localThrowable2)
      {
        for (;;)
        {
          ac.e("MicroMsg.Sns.AdLandingPageSightVideoComponent.VideoOptimize", localThrowable2.toString());
          continue;
          i = 0;
        }
      }
      this.ypy.setVideoCallback(new OfflineVideoView.a()
      {
        public final boolean a(PString paramAnonymousPString)
        {
          AppMethodBeat.i(200236);
          final long l = System.currentTimeMillis();
          final String str1 = ad.e(ad.this).yji;
          final String str2 = h.jt("adId", str1);
          if (com.tencent.mm.vfs.i.eA(str2))
          {
            paramAnonymousPString.value = str2;
            ad.f(ad.this);
            AppMethodBeat.o(200236);
            return true;
          }
          if (!ad.e(ad.this).yjr) {
            h.d("adId", str1, false, 62, new f.a()
            {
              public final void asD(String paramAnonymous2String)
              {
                AppMethodBeat.i(200231);
                ac.i("MicroMsg.Sns.AdLandingPageSightVideoComponent", "downloadSightForAdLandingPages succ, video view height " + ad.this.contentView.getHeight() + ", player height " + ad.c(ad.this).getHeight() + ", timeCost=" + (System.currentTimeMillis() - l));
                ad.a(ad.this, false);
                ad.a(ad.this, paramAnonymous2String);
                ad.c(ad.this).ade(paramAnonymous2String);
                ad.f(ad.this);
                AppMethodBeat.o(200231);
              }
              
              public final void dFC() {}
              
              public final void dFD()
              {
                AppMethodBeat.i(200230);
                ac.e("MicroMsg.Sns.AdLandingPageSightVideoComponent", "downloadSightForAdLandingPages fail:" + str1);
                ad.a(ad.this, true);
                ad.auG(str2);
                AppMethodBeat.o(200230);
              }
            });
          }
          for (;;)
          {
            AppMethodBeat.o(200236);
            return false;
            h.b("adId", str1, new f.a()
            {
              public final void asD(String paramAnonymous2String)
              {
                AppMethodBeat.i(200233);
                ac.i("MicroMsg.Sns.AdLandingPageSightVideoComponent", "downloadSightForAdLandingPagesByCdn succ, video view height " + ad.this.contentView.getHeight() + ", player height " + ad.c(ad.this).getHeight() + ", timeCost=" + (System.currentTimeMillis() - l));
                ad.a(ad.this, false);
                ad.a(ad.this, paramAnonymous2String);
                ad.c(ad.this).ade(paramAnonymous2String);
                ad.f(ad.this);
                AppMethodBeat.o(200233);
              }
              
              public final void dFC() {}
              
              public final void dFD()
              {
                AppMethodBeat.i(200232);
                ac.e("MicroMsg.Sns.AdLandingPageSightVideoComponent", "downloadSightForAdLandingPagesByCdn fail:" + str1);
                ad.a(ad.this, true);
                AppMethodBeat.o(200232);
              }
            });
          }
        }
        
        public final void onCompletion()
        {
          AppMethodBeat.i(200237);
          ap.f(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(200234);
              if ((ad.e(ad.this).yjp != null) && (!ad.g(ad.this)))
              {
                int i = ad.c(ad.this).getDurationMs();
                int j = ad.e(ad.this).yjp.yke;
                ac.i("MicroMsg.Sns.AdLandingPageSightVideoComponent", "OpenSnsAdFloatPageEvent, onCompletion totalMs=" + i + ", floatStartTime=" + j + ", hasShowFloat=" + ad.g(ad.this));
                if (i < j)
                {
                  ad.h(ad.this);
                  oa localoa = new oa();
                  localoa.dqw.dqx = ad.e(ad.this).yjp.dqx;
                  com.tencent.mm.sdk.b.a.GpY.l(localoa);
                }
              }
              AppMethodBeat.o(200234);
            }
          });
          ad.i(ad.this);
          ad.j(ad.this);
          AppMethodBeat.o(200237);
        }
        
        public final void onStart(int paramAnonymousInt)
        {
          AppMethodBeat.i(200238);
          ad.k(ad.this);
          ad.a(ad.this, paramAnonymousInt);
          ad.this.yoG.setVisibility(0);
          try
          {
            if (ad.l(ad.this).getVideoTotalTime() != paramAnonymousInt) {
              ad.l(ad.this).setVideoTotalTime(ad.m(ad.this));
            }
            ac.i("MicroMsg.Sns.AdLandingPageSightVideoComponent.VideoOptimize", "onStart");
            AppMethodBeat.o(200238);
            return;
          }
          catch (Throwable localThrowable)
          {
            ac.i("MicroMsg.Sns.AdLandingPageSightVideoComponent.VideoOptimize", localThrowable.toString());
            AppMethodBeat.o(200238);
          }
        }
        
        public final void sQ(int paramAnonymousInt)
        {
          AppMethodBeat.i(200239);
          ap.f(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(200235);
              ac.d("MicroMsg.Sns.AdLandingPageSightVideoComponent", "play time " + this.xFv + " video time " + ad.m(ad.this));
              ad.b(ad.this, this.xFv);
              if ((ad.e(ad.this).yjp != null) && (!ad.g(ad.this)))
              {
                int i = ad.e(ad.this).yjp.yke / 1000;
                ac.i("MicroMsg.Sns.AdLandingPageSightVideoComponent", "OpenSnsAdFloatPageEvent, updateTime seconds=" + this.xFv + ", floatSeconds=" + i + ", hasShowFloat=" + ad.g(ad.this));
                if (this.xFv >= i)
                {
                  ad.h(ad.this);
                  oa localoa = new oa();
                  localoa.dqw.dqx = ad.e(ad.this).yjp.dqx;
                  com.tencent.mm.sdk.b.a.GpY.l(localoa);
                }
              }
              AppMethodBeat.o(200235);
            }
          });
          AppMethodBeat.o(200239);
        }
      });
      this.yoG.setVisibility(8);
      this.ypy.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(200240);
          if (ad.n(ad.this))
          {
            paramAnonymousView = ad.this;
            paramAnonymousView.ypB += 1;
            if (ad.o(ad.this))
            {
              AppMethodBeat.o(200240);
              return;
            }
          }
          AppMethodBeat.o(200240);
        }
      });
      localObject1 = (u)this.ymQ;
      if ((((u)localObject1).subType != 1) || (((u)localObject1).yjl.length() <= 0) || (((u)localObject1).yjk.length() <= 0)) {
        break label1550;
      }
      i = 1;
      if (i != 0)
      {
        localObject1 = this.contentView.findViewById(2131304908);
        ((View)localObject1).setVisibility(0);
        localObject2 = (Button)((View)localObject1).findViewById(2131304909);
        ((Button)localObject2).setTextColor(((u)this.ymQ).yjm);
        ((Button)localObject2).setText(((u)this.ymQ).yjl);
        ((Button)localObject2).setOnClickListener(new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            AppMethodBeat.i(200241);
            ad.this.dKV();
            AppMethodBeat.o(200241);
          }
        });
        ((View)localObject1).findViewById(2131304910).setBackgroundColor(((u)this.ymQ).yjn);
      }
      try
      {
        this.length = com.tencent.mm.cc.a.fromDPToPix(this.context, 32);
        this.ypy.setOnTouchListener(this);
        this.ypE = ((ImageView)localView.findViewById(2131307246));
        localObject1 = this.ypE.getParent();
        if ((localObject1 instanceof ViewGroup)) {
          ((ViewGroup)localObject1).removeView(this.ypE);
        }
        localObject1 = (RelativeLayout.LayoutParams)this.ypE.getLayoutParams();
        ((RelativeLayout.LayoutParams)localObject1).bottomMargin = com.tencent.mm.cc.a.fromDPToPix(this.context, 8);
        ((RelativeLayout.LayoutParams)localObject1).rightMargin = com.tencent.mm.cc.a.fromDPToPix(this.context, 10);
        ((ViewGroup)localView).addView(this.ypE, (ViewGroup.LayoutParams)localObject1);
        this.ypE.setOnClickListener(this);
        this.ypE.setVisibility(8);
        ac.i("MicroMsg.Sns.AdLandingPageSightVideoComponent.VideoOptimize", "init fullScreenBtn and visible");
      }
      catch (Throwable localThrowable3)
      {
        for (;;)
        {
          label1080:
          label1151:
          int j;
          label1504:
          ac.e("MicroMsg.Sns.AdLandingPageSightVideoComponent.VideoOptimize", localThrowable3.toString());
          continue;
          boolean bool = false;
        }
      }
      try
      {
        this.yoF = new VideoPlayerSeekBar(this.context);
        localObject1 = this.yoF.getParent();
        if ((localObject1 instanceof ViewGroup)) {
          ((ViewGroup)localObject1).removeView(this.yoF);
        }
        localObject1 = new RelativeLayout.LayoutParams(this.ypM.getLayoutParams().width - com.tencent.mm.cc.a.fromDPToPix(this.context, 75), -2);
        ((RelativeLayout.LayoutParams)localObject1).addRule(12);
        ((RelativeLayout.LayoutParams)localObject1).bottomMargin = com.tencent.mm.cc.a.fromDPToPix(this.context, 3);
        this.yoF.setLayoutParams((ViewGroup.LayoutParams)localObject1);
        ((ViewGroup)this.contentView.findViewById(2131298770)).addView(this.yoF, (ViewGroup.LayoutParams)localObject1);
        OL(0);
        this.yoF.setOnPlayButtonClickListener(this.ypb);
        this.yoF.setIplaySeekCallback(this.qUY);
        this.yoF.setVisibility(4);
        if (this.ypa != null)
        {
          localObject1 = this.ypa;
          if (this.yoF.getVisibility() == 0)
          {
            bool = true;
            ((ak)localObject1).qZ(bool);
          }
        }
        else
        {
          ac.i("MicroMsg.Sns.AdLandingPageSightVideoComponent.VideoOptimize", "init progressBar and visible");
        }
      }
      catch (Throwable localThrowable4)
      {
        ac.e("MicroMsg.Sns.AdLandingPageSightVideoComponent.VideoOptimize", localThrowable4.toString());
        break label1080;
      }
      try
      {
        this.ypF = localView.findViewById(2131307220);
        this.ypF.setVisibility(8);
        AppMethodBeat.o(96718);
        return;
      }
      catch (Throwable localThrowable1)
      {
        ac.e("MicroMsg.Sns.AdLandingPageSightVideoComponent.VideoOptimize", localThrowable1.toString());
        AppMethodBeat.o(96718);
      }
      ((ViewGroup)localObject1).setLayoutParams(new RelativeLayout.LayoutParams(this.kWB, this.kWC));
      localView.setLayoutParams(new RelativeLayout.LayoutParams(this.kWB, this.kWC));
      break;
      localObject1 = this.ypy.getInnerVideoView();
      if ((localObject1 instanceof VideoPlayerTextureView))
      {
        ((View)localObject1).addOnLayoutChangeListener(new View.OnLayoutChangeListener()
        {
          public final void onLayoutChange(View paramAnonymousView, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3, int paramAnonymousInt4, int paramAnonymousInt5, int paramAnonymousInt6, int paramAnonymousInt7, int paramAnonymousInt8)
          {
            AppMethodBeat.i(200226);
            try
            {
              paramAnonymousInt1 = paramAnonymousView.getHeight();
              paramAnonymousInt2 = paramAnonymousView.getWidth();
              paramAnonymousInt3 = ad.w(ad.this).getWidth();
              paramAnonymousInt4 = ad.w(ad.this).getHeight();
              if ((paramAnonymousInt2 <= 1) || (paramAnonymousInt1 <= 1) || (paramAnonymousInt3 == 0) || (paramAnonymousInt4 == 0))
              {
                AppMethodBeat.o(200226);
                return;
              }
              ac.i("MicroMsg.Sns.AdLandingPageSightVideoComponent", "onLayoutChange, video.w=" + paramAnonymousView.getWidth() + ", h=" + paramAnonymousView.getHeight() + ", container.w=" + paramAnonymousInt3 + ", h=" + paramAnonymousInt4 + ", container.padding=" + j.eC(ad.w(ad.this)));
              if (paramAnonymousInt1 == paramAnonymousInt4)
              {
                AppMethodBeat.o(200226);
                return;
              }
              if ((paramAnonymousInt1 >= paramAnonymousInt2) && (paramAnonymousInt4 >= paramAnonymousInt3) && (Math.abs(paramAnonymousInt1 - paramAnonymousInt4) < 2))
              {
                paramAnonymousView = ad.w(ad.this).getLayoutParams();
                paramAnonymousView.height = paramAnonymousInt1;
                ad.w(ad.this).setLayoutParams(paramAnonymousView);
                ac.i("MicroMsg.Sns.AdLandingPageSightVideoComponent", "onLayoutChange, reset VideoContainer.height");
              }
              AppMethodBeat.o(200226);
              return;
            }
            catch (Exception paramAnonymousView)
            {
              ac.e("MicroMsg.Sns.AdLandingPageSightVideoComponent", "onLayoutChange, exp=" + paramAnonymousView.toString());
              AppMethodBeat.o(200226);
            }
          }
        });
        break label254;
      }
      ac.e("MicroMsg.Sns.AdLandingPageSightVideoComponent", "onLayoutChange, innerVideoView=" + localObject1 + ", displayType=" + ((u)this.ymQ).yjo);
      break label254;
      if (((u)this.ymQ).yjo == 1)
      {
        if (((u)this.ymQ).width / this.kWB > ((u)this.ymQ).height / this.kWC)
        {
          j = this.kWB;
          i = (int)(j * ((u)this.ymQ).height / ((u)this.ymQ).width) + 1;
        }
        for (;;)
        {
          localObject2 = new RelativeLayout.LayoutParams(j, i);
          ((RelativeLayout.LayoutParams)localObject2).leftMargin = ((this.kWB - j) / 2);
          ((RelativeLayout.LayoutParams)localObject2).rightMargin = ((RelativeLayout.LayoutParams)localObject2).leftMargin;
          ((RelativeLayout.LayoutParams)localObject2).topMargin = ((this.kWC - i) / 2);
          ((RelativeLayout.LayoutParams)localObject2).bottomMargin = ((RelativeLayout.LayoutParams)localObject2).topMargin;
          ((ViewGroup)localObject1).setLayoutParams((ViewGroup.LayoutParams)localObject2);
          localView.setLayoutParams(new RelativeLayout.LayoutParams(this.kWB, this.kWC));
          break;
          i = this.kWC;
          j = (int)(i * ((u)this.ymQ).width / ((u)this.ymQ).height) + 1;
        }
      }
      if (((u)this.ymQ).yjo != 2) {
        break label254;
      }
      localObject2 = new RelativeLayout.LayoutParams((int)((u)this.ymQ).width, (int)((u)this.ymQ).height);
      ((ViewGroup)localObject1).setLayoutParams((ViewGroup.LayoutParams)localObject2);
      localView.setLayoutParams(new RelativeLayout.LayoutParams((RelativeLayout.LayoutParams)localObject2));
      break label254;
      h.c("adId", ((u)this.ymQ).yjj, false, 1000000001, new f.a()
      {
        public final void asD(String paramAnonymousString)
        {
          AppMethodBeat.i(200229);
          ad.c(ad.this).avC(paramAnonymousString);
          AppMethodBeat.o(200229);
        }
        
        public final void dFC() {}
        
        public final void dFD() {}
      });
    }
    label1550:
  }
  
  public final void dJX()
  {
    AppMethodBeat.i(96727);
    super.dJX();
    try
    {
      this.gox.removeCallbacks(this.yoK);
      this.gox.removeCallbacks(this.ypH);
      abandonAudioFocus();
      this.ypy.onDestroy();
      AppMethodBeat.o(96727);
      return;
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        ac.e("MicroMsg.Sns.AdLandingPageSightVideoComponent.VideoOptimize", localThrowable.toString());
      }
    }
  }
  
  public final void dJY()
  {
    AppMethodBeat.i(96725);
    super.dJY();
    AppMethodBeat.o(96725);
  }
  
  public final void dJZ()
  {
    AppMethodBeat.i(96726);
    super.dJZ();
    abandonAudioFocus();
    rb(false);
    if ((!this.yoQ) && (!this.yoR))
    {
      AppMethodBeat.o(96726);
      return;
    }
    this.yoR = false;
    this.yoQ = false;
    if (this.yoV == 1) {
      this.yoV = 2;
    }
    int i = this.yoV;
    ac.d("MicroMsg.Sns.AdLandingPageSightVideoComponent", "disappear handleType %d", new Object[] { Integer.valueOf(this.yoV) });
    AppMethodBeat.o(96726);
  }
  
  public final void dKF()
  {
    AppMethodBeat.i(96731);
    super.dKF();
    String str = h.js("adId", ((u)this.ymQ).yjj);
    rb(false);
    if (com.tencent.mm.vfs.i.eA(str))
    {
      this.ypy.avC(str);
      this.ypy.c(false, 0.0F);
    }
    AppMethodBeat.o(96731);
  }
  
  public final void dKV()
  {
    AppMethodBeat.i(96719);
    u localu = (u)this.ymQ;
    if (bs.isNullOrNil(localu.yjk))
    {
      ac.e("MicroMsg.Sns.AdLandingPageSightVideoComponent", "on long video button click without streamVideoUrl!");
      AppMethodBeat.o(96719);
      return;
    }
    if (!(this.context instanceof Activity))
    {
      ac.e("MicroMsg.Sns.AdLandingPageSightVideoComponent", "on long video button click but context not activity!");
      AppMethodBeat.o(96719);
      return;
    }
    ac.v("MicroMsg.Sns.AdLandingPageSightVideoComponent", "on long video button click, jumpto [%s]", new Object[] { localu.yjk });
    Intent localIntent = new Intent();
    if (AdLandingPagesProxy.getInstance().getStreamVideoPlayerConfig() > 0)
    {
      localIntent.setClass(this.context, SnsAdStreamVideoPlayUI.class);
      ac.i("MicroMsg.Sns.AdLandingPageSightVideoComponent", "use new stream video play UI");
    }
    for (;;)
    {
      localIntent.putExtra("KFromTimeLine", true);
      localIntent.putExtra("KMediaId", ah.dg(localu.yjk));
      localIntent.putExtra("KThumUrl", localu.yjj);
      localIntent.putExtra("KStremVideoUrl", localu.yjk);
      localIntent.putExtra("ForceLandscape", true);
      localIntent.putExtra("ShareBtnHidden", 1);
      localIntent.putExtra("KComponentCid", dKD());
      ((Activity)this.context).startActivityForResult(localIntent, ypN);
      this.ypA += 1;
      AppMethodBeat.o(96719);
      return;
      localIntent.setClass(this.context, VideoAdPlayerUI.class);
    }
  }
  
  public final void dKa()
  {
    AppMethodBeat.i(96728);
    super.dKa();
    int i = dKB();
    int j = getView().getHeight();
    ac.d("MicroMsg.Sns.AdLandingPageSightVideoComponent", "inScreenHeight %d, height %d", new Object[] { Integer.valueOf(i), Integer.valueOf(j) });
    if ((i == 0) || (j == 0))
    {
      AppMethodBeat.o(96728);
      return;
    }
    this.ypC = i;
    this.fMu = j;
    if (i < 0)
    {
      AppMethodBeat.o(96728);
      return;
    }
    ac.d("MicroMsg.Sns.AdLandingPageSightVideoComponent", "appeared handleType %d", new Object[] { Integer.valueOf(this.yoV) });
    if (i >= j * 0.5F)
    {
      if ((this.yoQ) && (!this.yoR))
      {
        AppMethodBeat.o(96728);
        return;
      }
      this.yoR = false;
      this.yoQ = true;
      if (this.yoV == 6)
      {
        if (this.ypG)
        {
          this.yoV = 1;
          AppMethodBeat.o(96728);
          return;
        }
        this.yoV = 4;
        AppMethodBeat.o(96728);
        return;
      }
      if (this.yoV == 0)
      {
        if (this.yoO) {
          dJV();
        }
        for (;;)
        {
          this.yoV = 1;
          bVK();
          AppMethodBeat.o(96728);
          return;
          dKb();
        }
      }
      if (this.yoV == 2)
      {
        if (this.yoO) {
          dJV();
        }
        for (;;)
        {
          bVK();
          this.yoV = 1;
          AppMethodBeat.o(96728);
          return;
          dKb();
        }
      }
      if (this.yoV == 3)
      {
        if (this.yoO) {
          dJV();
        }
        for (;;)
        {
          bVK();
          AppMethodBeat.o(96728);
          return;
          dKb();
        }
      }
    }
    else
    {
      this.yoR = false;
      this.yoQ = false;
      rb(false);
      if (this.yoV == 1) {
        this.yoV = 2;
      }
      i = this.yoV;
    }
    AppMethodBeat.o(96728);
  }
  
  public final void dKb()
  {
    AppMethodBeat.i(96724);
    super.dKb();
    this.yoG.setImageDrawable(com.tencent.mm.cc.a.l(this.context, 2131690342));
    this.ypy.setMute(false);
    this.yoO = false;
    AppMethodBeat.o(96724);
  }
  
  protected final void dKm()
  {
    AppMethodBeat.i(96730);
    ac.i("MicroMsg.Sns.AdLandingPageSightVideoComponent", getClass().getName() + "not support update now");
    AppMethodBeat.o(96730);
  }
  
  protected final int getLayout()
  {
    return 2131495508;
  }
  
  public final boolean isPlaying()
  {
    AppMethodBeat.i(200247);
    boolean bool = this.ypy.isPlaying();
    AppMethodBeat.o(200247);
    return bool;
  }
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(200251);
    if (paramView.getId() == 2131307246)
    {
      ac.i("MicroMsg.Sns.AdLandingPageSightVideoComponent.VideoOptimize", "click full screen btn");
      try
      {
        if ((this.context instanceof SnsAdNativeLandingPagesUI))
        {
          this.ypJ += 1;
          this.gox.removeCallbacks(this.ypH);
          this.ypF.setVisibility(8);
          paramView = (SnsAdNativeLandingPagesUI)this.context;
          Intent localIntent = new Intent(paramView, VideoFullScreenActivity.class);
          localIntent.putExtra("KComponentVideoType", 0);
          localIntent.putExtra("KComponentCid", dKD());
          localIntent.putExtra("KComponentCurrentTime", this.ypy.getCurrentPositionMs());
          localIntent.putExtra("KComponentTotalTime", this.ypy.getDurationMs());
          localIntent.putExtra("KComponentVoiceType", this.yoO);
          localIntent.putExtra("KComponentProgressType", this.ypy.isPlaying());
          localIntent.putExtra("KComponentVideoSightThumbUrl", ((u)this.ymQ).yjj);
          localIntent.putExtra("KComponentStreamVideoUrlPath", ((u)this.ymQ).yji);
          paramView.startActivityForResult(localIntent, SnsAdNativeLandingPagesUI.yHa);
          AppMethodBeat.o(200251);
          return;
        }
        this.ypE.setVisibility(8);
        AppMethodBeat.o(200251);
        return;
      }
      catch (Throwable paramView)
      {
        this.ypE.setVisibility(8);
        ac.e("NonFullOrFullVideoType", paramView.toString());
      }
    }
    AppMethodBeat.o(200251);
  }
  
  public final boolean onDoubleTap(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(200253);
    for (;;)
    {
      try
      {
        ac.i("MicroMsg.Sns.AdLandingPageSightVideoComponent.VideoOptimize", "onDoubleTap");
        ar(this.yoK);
        if (this.gbe) {
          this.ypI += 1;
        }
        if (!this.ypy.isPlaying()) {
          continue;
        }
        rb(true);
        this.yoV = 4;
      }
      catch (Throwable paramMotionEvent)
      {
        ac.e("MicroMsg.Sns.AdLandingPageSightVideoComponent.VideoOptimize", paramMotionEvent.toString());
        continue;
        dKc();
        dKb();
        continue;
      }
      AppMethodBeat.o(200253);
      return false;
      if (!this.yoO) {
        continue;
      }
      dJV();
      bVK();
      this.yoV = 3;
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
    AppMethodBeat.i(200252);
    for (;;)
    {
      try
      {
        ac.i("MicroMsg.Sns.AdLandingPageSightVideoComponent.VideoOptimize", "onSingleTapConfirmed");
        if (!this.gbe) {
          continue;
        }
        if (this.yoF.getVisibility() != 0) {
          continue;
        }
        i = 1;
        if (i == 0) {
          continue;
        }
        this.yoF.setVisibility(4);
        this.ypE.setVisibility(4);
        this.gox.removeCallbacks(this.yoK);
        if (this.ypa == null) {
          continue;
        }
        paramMotionEvent = this.ypa;
        if (i != 0) {
          continue;
        }
      }
      catch (Throwable paramMotionEvent)
      {
        int i;
        ac.e("MicroMsg.Sns.AdLandingPageSightVideoComponent.VideoOptimize", paramMotionEvent.toString());
        continue;
        bool = false;
        continue;
      }
      paramMotionEvent.qZ(bool);
      AppMethodBeat.o(200252);
      return false;
      i = 0;
      continue;
      this.yoF.setVisibility(0);
      this.ypE.setVisibility(0);
      ar(this.yoK);
    }
  }
  
  public final boolean onSingleTapUp(MotionEvent paramMotionEvent)
  {
    return false;
  }
  
  @SuppressLint({"ClickableViewAccessibility"})
  public final boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(200250);
    boolean bool = this.irA.onTouchEvent(paramMotionEvent);
    AppMethodBeat.o(200250);
    return bool;
  }
  
  final class a
    implements AudioManager.OnAudioFocusChangeListener
  {
    a() {}
    
    public final void onAudioFocusChange(int paramInt)
    {
      AppMethodBeat.i(200243);
      try
      {
        ad.OM(paramInt);
        AppMethodBeat.o(200243);
        return;
      }
      catch (Throwable localThrowable)
      {
        ac.e("MicroMsg.Sns.AdLandingPageSightVideoComponent", "onAudioFocusChanged has something wrong!");
        AppMethodBeat.o(200243);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.ad
 * JD-Core Version:    0.7.0.1
 */