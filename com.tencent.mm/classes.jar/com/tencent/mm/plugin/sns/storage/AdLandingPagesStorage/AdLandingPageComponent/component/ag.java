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
import com.tencent.mm.by.c;
import com.tencent.mm.f.a.py;
import com.tencent.mm.plugin.sns.ad.d.d;
import com.tencent.mm.plugin.sns.ad.landingpage.helper.a.a;
import com.tencent.mm.plugin.sns.data.l;
import com.tencent.mm.plugin.sns.i.f;
import com.tencent.mm.plugin.sns.i.g;
import com.tencent.mm.plugin.sns.i.i;
import com.tencent.mm.plugin.sns.i.j;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.aa;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.ai;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.aj;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.w;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.f.a;
import com.tencent.mm.plugin.sns.ui.OfflineVideoView;
import com.tencent.mm.plugin.sns.ui.OfflineVideoView.a;
import com.tencent.mm.plugin.sns.ui.SnsAdNativeLandingPagesUI;
import com.tencent.mm.plugin.sns.ui.SnsAdStreamVideoPlayUI;
import com.tencent.mm.plugin.sns.ui.VideoFullScreenActivity;
import com.tencent.mm.pluginsdk.ui.tools.VideoPlayerSeekBar;
import com.tencent.mm.pluginsdk.ui.tools.VideoPlayerTextureView;
import com.tencent.mm.pluginsdk.ui.tools.k.c;
import com.tencent.mm.pointers.PString;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MD5Util;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.NetStatusUtil;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.vfs.u;
import org.json.JSONException;
import org.json.JSONObject;

public final class ag
  extends com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.a
  implements GestureDetector.OnDoubleTapListener, GestureDetector.OnGestureListener, View.OnClickListener, View.OnTouchListener
{
  private long FOL;
  private int FPs;
  private volatile int JAI;
  private View JAJ;
  boolean JAO;
  boolean JAP;
  private boolean JAQ;
  private boolean JAR;
  boolean JAS;
  private boolean JAT;
  private int JAW;
  private int JAX;
  int JAY;
  private int JAZ;
  private int JBa;
  int JBb;
  private an JBd;
  private Runnable JBl;
  private int JCy;
  public int JFq;
  public int JFr;
  public int JFs;
  private int JJO;
  private OfflineVideoView Ktb;
  private TextView Ktc;
  int Ktd;
  ImageView Kte;
  int Ktf;
  private boolean Ktg;
  private VideoPlayerSeekBar Kth;
  private ImageView Kti;
  private View Ktj;
  private volatile boolean Ktk;
  private Runnable Ktl;
  private View.OnClickListener Ktm;
  private c Ktn;
  private long Kto;
  private a Ktp;
  public boolean Ktq;
  private View Ktr;
  Context context;
  private boolean isAutoPlay;
  int jCa;
  private boolean jVR;
  private MMHandler knk;
  private int length;
  private GestureDetector mBn;
  private View maskView;
  private String oLQ;
  private com.tencent.mm.plugin.sight.decode.ui.b wTG;
  private boolean zSl;
  
  public ag(final Context paramContext, w paramw, ViewGroup paramViewGroup)
  {
    super(paramContext, paramw, paramViewGroup);
    AppMethodBeat.i(96717);
    this.FOL = 0L;
    this.JCy = 0;
    this.FPs = 0;
    this.JAW = 0;
    this.Ktd = 0;
    this.JFq = 0;
    this.JFr = 0;
    this.JFs = 0;
    this.JAY = 0;
    this.JBb = 0;
    this.JAS = true;
    this.Ktf = 0;
    this.jCa = 0;
    this.JAI = 0;
    this.JAQ = false;
    this.JAR = true;
    this.isAutoPlay = false;
    this.JAO = true;
    this.JAP = true;
    this.Ktg = false;
    this.Ktk = false;
    this.JBd = null;
    this.Ktm = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(196779);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bn(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/AdLandingPageSightVideoComponent$10", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
        for (;;)
        {
          try
          {
            Log.i("MicroMsg.Sns.AdLandingPageSightVideoComponent.VideoOptimize", "play btn onclick isPlaying[%b]", new Object[] { Boolean.valueOf(ag.this.isPlaying()) });
            ag.a(ag.this, ag.e(ag.this));
            if (!ag.this.isPlaying()) {
              continue;
            }
            ag.t(ag.this);
            ag.c(ag.this, 4);
            if (ag.v(ag.this)) {
              ag.w(ag.this);
            }
          }
          catch (Throwable paramAnonymousView)
          {
            Log.e("MicroMsg.Sns.AdLandingPageSightVideoComponent.VideoOptimize", paramAnonymousView.toString());
            continue;
            ag.this.fQC();
            ag.this.fKs();
            continue;
          }
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/AdLandingPageSightVideoComponent$10", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(196779);
          return;
          if (!ag.this.JAS) {
            continue;
          }
          ag.this.fKr();
          ag.u(ag.this);
          ag.c(ag.this, 3);
        }
      }
    };
    this.wTG = new com.tencent.mm.plugin.sight.decode.ui.b()
    {
      public final void aRo()
      {
        AppMethodBeat.i(267083);
        try
        {
          ag.a(ag.this, ag.e(ag.this));
          if (ag.d(ag.this) != null) {
            ag.d(ag.this).fUa();
          }
          AppMethodBeat.o(267083);
          return;
        }
        catch (Throwable localThrowable)
        {
          Log.e("MicroMsg.Sns.AdLandingPageSightVideoComponent.VideoOptimize", localThrowable.toString());
          AppMethodBeat.o(267083);
        }
      }
      
      public final void tY(int paramAnonymousInt)
      {
        AppMethodBeat.i(267085);
        try
        {
          Log.i("MicroMsg.Sns.AdLandingPageSightVideoComponent.VideoOptimize", "onSeek time ".concat(String.valueOf(paramAnonymousInt)));
          if (ag.this.JAS) {
            ag.this.fKr();
          }
          for (;;)
          {
            ag.d(ag.this).bd(paramAnonymousInt * 1000, true);
            ag.c(ag.this, 3);
            ag.b(ag.this, true);
            ag.y(ag.this).removeCallbacks(ag.x(ag.this));
            ag.b(ag.this).setVisibility(8);
            AppMethodBeat.o(267085);
            return;
            ag.this.fKs();
          }
          return;
        }
        catch (Throwable localThrowable)
        {
          Log.e("MicroMsg.Sns.AdLandingPageSightVideoComponent.VideoOptimize", localThrowable.toString());
          AppMethodBeat.o(267085);
        }
      }
    };
    this.JAX = 0;
    this.JAZ = 0;
    this.JBa = 0;
    this.Kto = 0L;
    this.Ktq = false;
    this.context = paramContext;
    this.knk = new MMHandler(Looper.getMainLooper());
    try
    {
      this.mBn = new GestureDetector(this);
      this.JBl = new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(266803);
          ag.a(ag.this);
          AppMethodBeat.o(266803);
        }
      };
      this.Ktl = new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(196297);
          ag.b(ag.this).setVisibility(8);
          AppMethodBeat.o(196297);
        }
      };
      this.JBd = new an()
      {
        public final void yj(boolean paramAnonymousBoolean)
        {
          AppMethodBeat.i(199296);
          try
          {
            Intent localIntent = new Intent("com.tencent.mm.adlanding.video_progressbar_change");
            if (paramAnonymousBoolean) {}
            for (int i = 1;; i = 0)
            {
              localIntent.putExtra("show", i);
              localIntent.putExtra("activity_code", ag.c(ag.this));
              androidx.h.a.a.V(paramContext).c(localIntent);
              AppMethodBeat.o(199296);
              return;
            }
            return;
          }
          catch (Throwable localThrowable)
          {
            Log.e("MicroMsg.Sns.AdLandingPageSightVideoComponent", localThrowable.toString());
            AppMethodBeat.o(199296);
          }
        }
      };
      d.a(paramw, false);
      AppMethodBeat.o(96717);
      return;
    }
    catch (Throwable paramContext)
    {
      for (;;)
      {
        Log.e("MicroMsg.Sns.AdLandingPageSightVideoComponent.VideoOptimize", paramContext.toString());
      }
    }
  }
  
  private void aE(Runnable paramRunnable)
  {
    AppMethodBeat.i(270072);
    try
    {
      this.knk.removeCallbacks(paramRunnable);
      this.knk.postDelayed(paramRunnable, 4000L);
      AppMethodBeat.o(270072);
      return;
    }
    catch (Throwable paramRunnable)
    {
      Log.e("MicroMsg.Sns.AdLandingPageSightVideoComponent.VideoOptimize", paramRunnable.toString());
      AppMethodBeat.o(270072);
    }
  }
  
  private void abandonAudioFocus()
  {
    AppMethodBeat.i(270083);
    try
    {
      if (this.Ktp != null)
      {
        AudioManager localAudioManager = (AudioManager)this.context.getSystemService("audio");
        if (localAudioManager != null)
        {
          localAudioManager.abandonAudioFocus(this.Ktp);
          this.Ktp = null;
        }
      }
      AppMethodBeat.o(270083);
      return;
    }
    catch (Throwable localThrowable)
    {
      Log.e("MicroMsg.Sns.AdLandingPageSightVideoComponent", "abandonAudioFocus has something wrong!");
      AppMethodBeat.o(270083);
    }
  }
  
  private void ago(final int paramInt)
  {
    AppMethodBeat.i(270064);
    try
    {
      this.knk.post(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(268463);
          ag.n(ag.this).seek(paramInt);
          ag.b(ag.this, ag.this.isPlaying());
          AppMethodBeat.o(268463);
        }
      });
      AppMethodBeat.o(270064);
      return;
    }
    catch (Throwable localThrowable)
    {
      Log.e("MicroMsg.Sns.AdLandingPageSightVideoComponent.VideoOptimize", localThrowable.toString());
      AppMethodBeat.o(270064);
    }
  }
  
  public static void baX(String paramString)
  {
    int i = 1;
    AppMethodBeat.i(270071);
    Object localObject = "0";
    for (;;)
    {
      try
      {
        if (u.agG(paramString))
        {
          String str = "1";
          localObject = str;
          if (u.deleteFile(paramString))
          {
            localObject = str;
            paramString = NetStatusUtil.getFormatedNetType(MMApplicationContext.getContext());
            l.a(l.JQJ, (String)localObject, 1, i, "http|".concat(String.valueOf(paramString)));
            AppMethodBeat.o(270071);
            return;
          }
        }
      }
      catch (Throwable paramString)
      {
        Log.e("MicroMsg.Sns.AdLandingPageSightVideoComponent", "delErrorFile exp=" + paramString.toString());
        AppMethodBeat.o(270071);
        return;
      }
      i = 0;
    }
  }
  
  private void cNW()
  {
    AppMethodBeat.i(96721);
    if (this.Ktg)
    {
      Log.i("MicroMsg.Sns.AdLandingPageSightVideoComponent", "last download fail ,try again");
      this.Ktb.dmh();
      AppMethodBeat.o(96721);
      return;
    }
    Log.d("MicroMsg.Sns.AdLandingPageSightVideoComponent", "starting play");
    if ((!this.zSl) && (!TextUtils.isEmpty(this.oLQ)))
    {
      this.Ktb.aAB(this.oLQ);
      this.zSl = true;
    }
    this.knk.post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(252377);
        ag.d(ag.this).fUb();
        ag.z(ag.this);
        try
        {
          ag.b(ag.this, true);
          ag.y(ag.this).removeCallbacks(ag.x(ag.this));
          ag.b(ag.this).setVisibility(8);
          AppMethodBeat.o(252377);
          return;
        }
        catch (Throwable localThrowable)
        {
          Log.e("MicroMsg.Sns.AdLandingPageSightVideoComponent", localThrowable.toString());
          AppMethodBeat.o(252377);
        }
      }
    });
    this.FOL = System.currentTimeMillis();
    this.FPs += 1;
    AppMethodBeat.o(96721);
  }
  
  private boolean fRA()
  {
    AppMethodBeat.i(96720);
    if (!Util.isNullOrNil(((w)this.KqB).Klw))
    {
      Intent localIntent = new Intent();
      localIntent.putExtra("sns_landig_pages_from_source", 14);
      localIntent.putExtra("sns_landig_pages_origin_from_source", fRp().Knp);
      localIntent.putExtra("sns_landing_pages_ux_info", fRp().uxInfo);
      localIntent.putExtra("sns_landing_pages_xml", "");
      localIntent.putExtra("sns_landing_pages_canvasid", ((w)this.KqB).Klw);
      localIntent.putExtra("sns_landing_pages_canvas_ext", ((w)this.KqB).Klx);
      localIntent.putExtra("sns_landing_pages_no_store", ((w)this.KqB).Kly);
      localIntent.putExtra("sns_landing_pages_need_enter_and_exit_animation", true);
      String str3;
      String str1;
      String str2;
      JSONObject localJSONObject;
      if (((this.context instanceof Activity)) && (fRp().bizId == 2))
      {
        str3 = ((Activity)this.context).getIntent().getStringExtra("sns_landing_pages_sessionId");
        str1 = ((Activity)this.context).getIntent().getStringExtra("sns_landing_pages_ad_buffer");
        if (!Util.isNullOrNil(str3))
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
          localJSONObject.put("cid", ((w)this.KqB).KmB);
          if (Util.isNullOrNil(str1)) {
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
        this.Ktb.getLocationOnScreen((int[])localObject);
        localIntent.putExtra("img_gallery_top", localObject[1]);
        localIntent.putExtra("img_gallery_left", localObject[0]);
        localIntent.putExtra("img_gallery_width", this.Ktb.getWidth());
        localIntent.putExtra("img_gallery_height", this.Ktb.getHeight());
        c.b(this.context, "sns", ".ui.SnsAdNativeLandingPagesPreviewUI", localIntent);
        AppMethodBeat.o(96720);
        return true;
        localObject = "";
      }
    }
    AppMethodBeat.o(96720);
    return false;
  }
  
  private void requestAudioFocus()
  {
    AppMethodBeat.i(270082);
    try
    {
      if (this.Ktp == null)
      {
        this.Ktp = new a();
        AudioManager localAudioManager = (AudioManager)this.context.getSystemService("audio");
        if (localAudioManager != null)
        {
          int i = localAudioManager.requestAudioFocus(this.Ktp, 3, 2);
          if (i == 1)
          {
            Log.i("MicroMsg.Sns.AdLandingPageSightVideoComponent", "requestAudioFocus successfully!");
            AppMethodBeat.o(270082);
            return;
          }
          Log.i("MicroMsg.Sns.AdLandingPageSightVideoComponent", "requestAudioFocus is not granted. value = ".concat(String.valueOf(i)));
        }
      }
      AppMethodBeat.o(270082);
      return;
    }
    catch (Throwable localThrowable)
    {
      Log.e("MicroMsg.Sns.AdLandingPageSightVideoComponent", "requestAudioFocus has something wrong!");
      AppMethodBeat.o(270082);
    }
  }
  
  private void yM(boolean paramBoolean)
  {
    AppMethodBeat.i(270063);
    try
    {
      this.Kth.setIsPlay(paramBoolean);
      this.Kth.getPlayBtn().getLayoutParams().width = this.length;
      this.Kth.getPlayBtn().getLayoutParams().height = this.length;
      if (paramBoolean)
      {
        Log.i("MicroMsg.Sns.AdLandingPageSightVideoComponent.VideoOptimize", "startPlay");
        this.Kth.getPlayBtn().setImageDrawable(com.tencent.mm.ci.a.m(this.context, i.i.media_player_btn_cur_status_on));
        AppMethodBeat.o(270063);
        return;
      }
      Log.i("MicroMsg.Sns.AdLandingPageSightVideoComponent.VideoOptimize", "pausePlay");
      this.Kth.getPlayBtn().setImageDrawable(com.tencent.mm.ci.a.m(this.context, i.i.media_player_btn_cur_status_off));
      AppMethodBeat.o(270063);
      return;
    }
    catch (Throwable localThrowable)
    {
      Log.e("MicroMsg.Sns.AdLandingPageSightVideoComponent.VideoOptimize", localThrowable.toString());
      AppMethodBeat.o(270063);
    }
  }
  
  private void yp(final boolean paramBoolean)
  {
    AppMethodBeat.i(270068);
    Log.d("MicroMsg.Sns.AdLandingPageSightVideoComponent", "pause play");
    this.knk.post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(268701);
        ag.d(ag.this).fUa();
        try
        {
          ag.b(ag.this, false);
          if ((ag.r(ag.this)) && (paramBoolean))
          {
            ag.b(ag.this).setVisibility(0);
            ag.a(ag.this, ag.x(ag.this));
          }
          AppMethodBeat.o(268701);
          return;
        }
        catch (Throwable localThrowable)
        {
          Log.e("MicroMsg.Sns.AdLandingPageSightVideoComponent", localThrowable.toString());
          AppMethodBeat.o(268701);
        }
      }
    });
    if (this.FOL != 0L)
    {
      this.JCy = ((int)(this.JCy + (System.currentTimeMillis() - this.FOL)));
      this.FOL = 0L;
    }
    AppMethodBeat.o(270068);
  }
  
  public final void a(int paramInt1, boolean paramBoolean1, boolean paramBoolean2, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, long paramLong1, String paramString, long paramLong2)
  {
    AppMethodBeat.i(270079);
    for (;;)
    {
      try
      {
        this.JAI = 6;
        this.Kto += paramLong2;
        this.Ktk = paramBoolean2;
        this.JBa += 1;
        this.JAX += paramInt2;
        this.JAZ += paramInt3;
        this.JAY += paramInt4;
        this.JAW += paramInt5;
        this.FPs += paramInt6;
        this.JCy = ((int)(this.JCy + paramLong1));
        if (paramBoolean2) {
          this.FOL = System.currentTimeMillis();
        }
        boolean bool = Util.isNullOrNil(paramString);
        if (!bool) {}
        try
        {
          paramString = new JSONObject(paramString);
          if (this.Ktn == null) {
            this.Ktn = new c();
          }
          c localc = this.Ktn;
          localc.JGy += paramString.optInt("exposureCount");
          localc = this.Ktn;
          localc.fOa += paramString.optLong("stayTime");
          localc = this.Ktn;
          localc.clickCount += paramString.optInt("clickCount");
          paramString = paramString.optJSONObject("btnInfo");
          this.Ktn.JGz = paramString.optString("cid");
          localc = this.Ktn;
          localc.JGA += paramString.optInt("exposureCount");
          localc = this.Ktn;
          localc.JGB += paramString.optLong("stayTime");
          localc = this.Ktn;
          paramInt2 = localc.JGC;
          localc.JGC = (paramString.optInt("clickCount") + paramInt2);
        }
        catch (Throwable paramString)
        {
          this.Ktn = null;
          Log.e("MicroMsg.Sns.AdLandingPageSightVideoComponent", paramString.toString());
          continue;
        }
        this.knk.removeCallbacks(this.Ktl);
        this.Ktj.setVisibility(8);
        Log.i("VideoFullScreenActivity", "currPosSec = " + paramInt1 + ", isPlaying = " + paramBoolean2 + ", bNoVoice = " + paramBoolean1);
        paramInt2 = paramInt1 / 1000;
        if ((paramInt2 >= this.JJO) || (paramInt1 < 0))
        {
          this.Kth.seek(0);
          this.Ktb.bd(0, paramBoolean2);
          yM(paramBoolean2);
          if (!paramBoolean1) {
            break label523;
          }
          fKr();
          requestAudioFocus();
          AppMethodBeat.o(270079);
          return;
        }
      }
      catch (Throwable paramString)
      {
        Log.e("VideoFullScreenActivity", paramString.toString());
        AppMethodBeat.o(270079);
        return;
      }
      this.Kth.seek(paramInt2);
      this.Ktb.bd(paramInt1, paramBoolean2);
      continue;
      label523:
      fKs();
    }
  }
  
  public final boolean by(JSONObject paramJSONObject)
  {
    AppMethodBeat.i(96729);
    if (!super.by(paramJSONObject))
    {
      AppMethodBeat.o(96729);
      return false;
    }
    try
    {
      paramJSONObject.put("sightDuration", this.JJO * 1000);
      paramJSONObject.put("playTimeInterval", this.JCy);
      paramJSONObject.put("playCount", this.FPs);
      paramJSONObject.put("playCompletedCount", this.JAW);
      paramJSONObject.put("clickPlayControlCount", this.JAX);
      paramJSONObject.put("doubleClickCount", this.JAZ);
      paramJSONObject.put("clickFullscreenBtnCount", this.JBa);
      paramJSONObject.put("clickVoiceControlCount", this.JAY);
      if (this.isAutoPlay) {}
      for (Object localObject = "1";; localObject = "0")
      {
        paramJSONObject.put("isAutoPlay", localObject);
        if (((w)this.KqB).type == 61) {
          paramJSONObject.put("clickSightCount", this.JBb);
        }
        JSONObject localJSONObject;
        if (!this.JAP)
        {
          localObject = MD5Util.getMD5String(((w)this.KqB).Kml);
          localJSONObject = new JSONObject();
          localJSONObject.put("urlMd5", localObject);
          localJSONObject.put("needDownload", 1);
          paramJSONObject.put("sightUrlInfo", localJSONObject);
        }
        if (!this.JAO)
        {
          localObject = MD5Util.getMD5String(((w)this.KqB).Kmm);
          localJSONObject = new JSONObject();
          localJSONObject.put("urlMd5", localObject);
          localJSONObject.put("needDownload", 1);
          paramJSONObject.put("thumbUrlInfo", localJSONObject);
        }
        paramJSONObject.put("streamVideoEnterCount", this.Ktd);
        paramJSONObject.put("streamVideoPlayCount", this.JFq);
        paramJSONObject.put("streamVideoPlayCompleteCount", this.JFr);
        paramJSONObject.put("streamVideoTotalPlayTimeInMs", this.JFs);
        if (this.Ktn != null)
        {
          localObject = new JSONObject();
          ((JSONObject)localObject).put("cid", this.Ktn.JGz);
          ((JSONObject)localObject).put("exposureCount", this.Ktn.JGA);
          ((JSONObject)localObject).put("stayTime", this.Ktn.JGB);
          ((JSONObject)localObject).put("clickCount", this.Ktn.JGC);
          localJSONObject = new JSONObject();
          localJSONObject.put("exposureCount", this.Ktn.JGy);
          localJSONObject.put("stayTime", this.Ktn.fOa);
          localJSONObject.put("clickCount", this.Ktn.clickCount);
          localJSONObject.put("btnInfo", localObject);
          paramJSONObject.put("fullVideoFloatBarInfo", localJSONObject);
        }
        AppMethodBeat.o(96729);
        return true;
      }
      return false;
    }
    catch (JSONException paramJSONObject)
    {
      Log.printErrStackTrace("MicroMsg.Sns.AdLandingPageSightVideoComponent", paramJSONObject, "", new Object[0]);
      AppMethodBeat.o(96729);
    }
  }
  
  public final void dmf()
  {
    AppMethodBeat.i(270080);
    yp(false);
    this.JAI = 4;
    AppMethodBeat.o(270080);
  }
  
  public final void dmg()
  {
    AppMethodBeat.i(270081);
    this.JAI = 3;
    cNW();
    AppMethodBeat.o(270081);
  }
  
  protected final void fKe()
  {
    AppMethodBeat.i(96730);
    Log.i("MicroMsg.Sns.AdLandingPageSightVideoComponent", getClass().getName() + "not support update now");
    AppMethodBeat.o(96730);
  }
  
  public final void fKk()
  {
    AppMethodBeat.i(96725);
    super.fKk();
    AppMethodBeat.o(96725);
  }
  
  public final void fKl()
  {
    AppMethodBeat.i(96726);
    super.fKl();
    abandonAudioFocus();
    yp(false);
    if ((!this.JAQ) && (!this.JAR))
    {
      AppMethodBeat.o(96726);
      return;
    }
    this.JAR = false;
    this.JAQ = false;
    if (this.JAI == 1) {
      this.JAI = 2;
    }
    int i = this.JAI;
    Log.d("MicroMsg.Sns.AdLandingPageSightVideoComponent", "disappear handleType %d", new Object[] { Integer.valueOf(this.JAI) });
    AppMethodBeat.o(96726);
  }
  
  public final void fKm()
  {
    AppMethodBeat.i(96728);
    super.fKm();
    int i = fRi();
    int j = getView().getHeight();
    Log.d("MicroMsg.Sns.AdLandingPageSightVideoComponent", "inScreenHeight %d, height %d", new Object[] { Integer.valueOf(i), Integer.valueOf(j) });
    if ((i == 0) || (j == 0))
    {
      AppMethodBeat.o(96728);
      return;
    }
    this.Ktf = i;
    this.jCa = j;
    if (i < 0)
    {
      AppMethodBeat.o(96728);
      return;
    }
    Log.d("MicroMsg.Sns.AdLandingPageSightVideoComponent", "appeared handleType %d", new Object[] { Integer.valueOf(this.JAI) });
    if (i >= j * 0.5F)
    {
      if ((this.JAQ) && (!this.JAR))
      {
        AppMethodBeat.o(96728);
        return;
      }
      this.JAR = false;
      this.JAQ = true;
      if (this.JAI == 6)
      {
        if (this.Ktk)
        {
          this.JAI = 1;
          AppMethodBeat.o(96728);
          return;
        }
        this.JAI = 4;
        AppMethodBeat.o(96728);
        return;
      }
      if (this.JAI == 0)
      {
        if (this.JAS) {
          fKr();
        }
        for (;;)
        {
          this.JAI = 1;
          cNW();
          AppMethodBeat.o(96728);
          return;
          fKs();
        }
      }
      if (this.JAI == 2)
      {
        if (this.JAS) {
          fKr();
        }
        for (;;)
        {
          cNW();
          this.JAI = 1;
          AppMethodBeat.o(96728);
          return;
          fKs();
        }
      }
      if (this.JAI == 3)
      {
        if (this.JAS) {
          fKr();
        }
        for (;;)
        {
          cNW();
          AppMethodBeat.o(96728);
          return;
          fKs();
        }
      }
    }
    else
    {
      this.JAR = false;
      this.JAQ = false;
      yp(false);
      if (this.JAI == 1) {
        this.JAI = 2;
      }
      i = this.JAI;
    }
    AppMethodBeat.o(96728);
  }
  
  public final void fKo()
  {
    AppMethodBeat.i(96727);
    super.fKo();
    try
    {
      this.knk.removeCallbacks(this.JBl);
      this.knk.removeCallbacks(this.Ktl);
      abandonAudioFocus();
      this.Ktb.onDestroy();
      AppMethodBeat.o(96727);
      return;
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        Log.e("MicroMsg.Sns.AdLandingPageSightVideoComponent.VideoOptimize", localThrowable.toString());
      }
    }
  }
  
  public final void fKp()
  {
    AppMethodBeat.i(96718);
    if (!u.agG(com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.h.kU("adId", ((w)this.KqB).Kmm))) {
      this.JAO = false;
    }
    if (!u.agG(com.tencent.mm.loader.j.b.aSL() + "/sns_ad_landingpages/adId_stream_" + MD5Util.getMD5String(((w)this.KqB).Kml))) {
      this.JAP = false;
    }
    View localView = this.contentView.findViewById(i.f.sns_ad_native_landing_pages_item_video_container);
    this.JAJ = localView;
    Object localObject1 = (ViewGroup)localView.findViewById(i.f.sns_ad_native_landing_pages_item_sight_container);
    this.Ktb = new OfflineVideoView(this.context);
    this.Ktb.setSource(1);
    this.Ktr = ((View)localObject1);
    ((ViewGroup)localObject1).addView(this.Ktb, new LinearLayout.LayoutParams(-1, -1));
    int i;
    Object localObject2;
    if (((w)this.KqB).Kmq == 0) {
      if ((int)((w)this.KqB).width > 0)
      {
        i = this.pEj;
        localObject2 = new RelativeLayout.LayoutParams(i, (int)(i * ((w)this.KqB).height / ((w)this.KqB).width));
        ((ViewGroup)localObject1).setLayoutParams((ViewGroup.LayoutParams)localObject2);
        localView.setLayoutParams((ViewGroup.LayoutParams)localObject2);
        if (((w)this.KqB).Kmr) {
          break label1176;
        }
        Log.e("MicroMsg.Sns.AdLandingPageSightVideoComponent", "fixVideoBlackline, enable=false");
        label263:
        Log.i("MicroMsg.Sns.AdLandingPageSightVideoComponent", "createView, displayType=" + ((w)this.KqB).Kmq);
        localObject1 = com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.h.kU("adId", ((w)this.KqB).Kmm);
        if (!u.agG((String)localObject1)) {
          break label1530;
        }
        this.Ktb.bbV((String)localObject1);
      }
    }
    for (;;)
    {
      this.Ktc = ((TextView)localView.findViewById(i.f.errorTv));
      this.Ktc.setText(this.context.getString(i.j.download_fail));
      this.maskView = localView.findViewById(i.f.sns_ad_native_landing_pages_sight_background);
      if (this.maskView != null)
      {
        localObject1 = new RelativeLayout.LayoutParams(-1, -1);
        localObject2 = this.maskView.getParent();
        if ((localObject2 instanceof ViewGroup)) {
          ((ViewGroup)localObject2).removeView(this.maskView);
        }
        ((ViewGroup)localView).addView(this.maskView, (ViewGroup.LayoutParams)localObject1);
      }
      this.Kte = ((ImageView)localView.findViewById(i.f.sns_ad_native_landing_pages_sight_voice_btn));
      this.Kte.setVisibility(0);
      this.Kte.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(96714);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bn(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/AdLandingPageSightVideoComponent$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
          paramAnonymousView = ag.this;
          paramAnonymousView.JAY += 1;
          ag.a(ag.this, ag.e(ag.this));
          if (ag.this.JAS)
          {
            ag.this.fQC();
            ag.this.fKs();
          }
          for (;;)
          {
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/AdLandingPageSightVideoComponent$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(96714);
            return;
            ag.this.fKr();
          }
        }
      });
      try
      {
        localObject1 = this.Kte.getParent();
        if ((localObject1 instanceof ViewGroup)) {
          ((ViewGroup)localObject1).removeView(this.Kte);
        }
        localObject1 = (RelativeLayout.LayoutParams)this.Kte.getLayoutParams();
        ((RelativeLayout.LayoutParams)localObject1).bottomMargin = com.tencent.mm.ci.a.fromDPToPix(this.context, 8);
        ((RelativeLayout.LayoutParams)localObject1).rightMargin = com.tencent.mm.ci.a.fromDPToPix(this.context, 10);
        ((ViewGroup)localView).addView(this.Kte, (ViewGroup.LayoutParams)localObject1);
        Log.i("MicroMsg.Sns.AdLandingPageSightVideoComponent.VideoOptimize", "init voiceTypeBtn and visible");
      }
      catch (Throwable localThrowable2)
      {
        for (;;)
        {
          Log.e("MicroMsg.Sns.AdLandingPageSightVideoComponent.VideoOptimize", localThrowable2.toString());
          continue;
          i = 0;
        }
      }
      this.Ktb.setVideoCallback(new OfflineVideoView.a()
      {
        public final void AS(int paramAnonymousInt)
        {
          AppMethodBeat.i(206618);
          ag.q(ag.this).sendMessage();
          MMHandlerThread.postToMainThread(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(268963);
              Log.d("MicroMsg.Sns.AdLandingPageSightVideoComponent", "play time " + this.JuK + " video time " + ag.o(ag.this));
              ag.b(ag.this, this.JuK);
              if ((ag.f(ag.this).Klq != null) && (!ag.h(ag.this)))
              {
                int i = ag.f(ag.this).Klq.Knx / 1000;
                Log.i("MicroMsg.Sns.AdLandingPageSightVideoComponent", "OpenSnsAdFloatPageEvent, updateTime seconds=" + this.JuK + ", floatSeconds=" + i + ", hasShowFloat=" + ag.h(ag.this));
                if (this.JuK >= i)
                {
                  ag.i(ag.this);
                  py localpy = new py();
                  localpy.fOF.fOG = ag.f(ag.this).Klq.fOG;
                  EventCenter.instance.publish(localpy);
                }
              }
              AppMethodBeat.o(268963);
            }
          });
          AppMethodBeat.o(206618);
        }
        
        public final boolean a(PString paramAnonymousPString)
        {
          AppMethodBeat.i(206609);
          final long l = System.currentTimeMillis();
          final String str1 = ag.f(ag.this).Kml;
          final String str2 = com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.h.kV("adId", str1);
          if (u.agG(str2))
          {
            a.a.ym(true);
            paramAnonymousPString.value = str2;
            ag.g(ag.this);
            AppMethodBeat.o(206609);
            return true;
          }
          a.a.ym(false);
          if (!ag.f(ag.this).Kms) {
            com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.h.a("adId", str1, false, 62, new f.a()
            {
              public final void aYs(String paramAnonymous2String)
              {
                AppMethodBeat.i(219372);
                Log.i("MicroMsg.Sns.AdLandingPageSightVideoComponent", "downloadSightForAdLandingPages succ, video view height " + ag.this.contentView.getHeight() + ", player height " + ag.d(ag.this).getHeight() + ", timeCost=" + (System.currentTimeMillis() - l));
                ag.a(ag.this, false);
                ag.a(ag.this, paramAnonymous2String);
                ag.d(ag.this).aAB(paramAnonymous2String);
                ag.g(ag.this);
                AppMethodBeat.o(219372);
              }
              
              public final void fJU() {}
              
              public final void fJV()
              {
                AppMethodBeat.i(219370);
                Log.e("MicroMsg.Sns.AdLandingPageSightVideoComponent", "downloadSightForAdLandingPages fail:" + str1);
                ag.a(ag.this, true);
                ag.baX(str2);
                AppMethodBeat.o(219370);
              }
            });
          }
          for (;;)
          {
            AppMethodBeat.o(206609);
            return false;
            com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.h.c("adId", str1, new f.a()
            {
              public final void aYs(String paramAnonymous2String)
              {
                AppMethodBeat.i(268370);
                Log.i("MicroMsg.Sns.AdLandingPageSightVideoComponent", "downloadSightForAdLandingPagesByCdn succ, video view height " + ag.this.contentView.getHeight() + ", player height " + ag.d(ag.this).getHeight() + ", timeCost=" + (System.currentTimeMillis() - l));
                ag.a(ag.this, false);
                ag.a(ag.this, paramAnonymous2String);
                ag.d(ag.this).aAB(paramAnonymous2String);
                ag.g(ag.this);
                AppMethodBeat.o(268370);
              }
              
              public final void fJU() {}
              
              public final void fJV()
              {
                AppMethodBeat.i(268369);
                Log.e("MicroMsg.Sns.AdLandingPageSightVideoComponent", "downloadSightForAdLandingPagesByCdn fail:" + str1);
                ag.a(ag.this, true);
                AppMethodBeat.o(268369);
              }
            });
          }
        }
        
        public final void onCompletion()
        {
          AppMethodBeat.i(206611);
          MMHandlerThread.postToMainThread(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(255918);
              if ((ag.f(ag.this).Klq != null) && (!ag.h(ag.this)))
              {
                int i = ag.d(ag.this).getDurationMs();
                int j = ag.f(ag.this).Klq.Knx;
                Log.i("MicroMsg.Sns.AdLandingPageSightVideoComponent", "OpenSnsAdFloatPageEvent, onCompletion totalMs=" + i + ", floatStartTime=" + j + ", hasShowFloat=" + ag.h(ag.this));
                if (i < j)
                {
                  ag.i(ag.this);
                  py localpy = new py();
                  localpy.fOF.fOG = ag.f(ag.this).Klq.fOG;
                  EventCenter.instance.publish(localpy);
                }
              }
              AppMethodBeat.o(255918);
            }
          });
          ag.j(ag.this);
          ag.k(ag.this).JDG = true;
          ag.l(ag.this);
          AppMethodBeat.o(206611);
        }
        
        public final void onStart(int paramAnonymousInt)
        {
          AppMethodBeat.i(206615);
          ag.m(ag.this);
          ag.a(ag.this, paramAnonymousInt);
          ag.this.Kte.setVisibility(0);
          try
          {
            if (ag.n(ag.this).getVideoTotalTime() != paramAnonymousInt) {
              ag.n(ag.this).setVideoTotalTime(ag.o(ag.this));
            }
            Log.i("MicroMsg.Sns.AdLandingPageSightVideoComponent.VideoOptimize", "onStart");
            int i = (int)ag.this.fRp().Knu;
            if ((ag.p(ag.this) instanceof SnsAdNativeLandingPagesUI))
            {
              ((SnsAdNativeLandingPagesUI)ag.p(ag.this)).fVn();
              Log.i("MicroMsg.Sns.AdLandingPageSightVideoComponent", "snsId = " + ag.this.fRp().getSnsId() + ", adSightVideoSeekTime = " + i + ", isFirstSightVideoComp = " + ag.this.Ktq);
              if ((ag.this.Ktq) && (ag.jJ(i, paramAnonymousInt * 1000))) {
                ag.d(ag.this).bd(i, true);
              }
            }
            AppMethodBeat.o(206615);
            return;
          }
          catch (Throwable localThrowable)
          {
            Log.i("MicroMsg.Sns.AdLandingPageSightVideoComponent.VideoOptimize", localThrowable.toString());
            AppMethodBeat.o(206615);
          }
        }
      });
      this.Ktb.setOnSeekCompleteCallback(new d());
      this.Kte.setVisibility(8);
      this.Ktb.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(195913);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bn(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/AdLandingPageSightVideoComponent$7", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
          if (ag.r(ag.this))
          {
            paramAnonymousView = ag.this;
            paramAnonymousView.JBb += 1;
            if (ag.s(ag.this))
            {
              com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/AdLandingPageSightVideoComponent$7", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
              AppMethodBeat.o(195913);
              return;
            }
          }
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/AdLandingPageSightVideoComponent$7", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(195913);
        }
      });
      localObject1 = (w)this.KqB;
      if ((((w)localObject1).subType != 1) || (((w)localObject1).Kmn.length() <= 0) || (((w)localObject1).JCf.length() <= 0)) {
        break label1572;
      }
      i = 1;
      if (i != 0)
      {
        localObject1 = this.contentView.findViewById(i.f.sns_ad_native_landing_pages_item_stream_video_click_area);
        ((View)localObject1).setVisibility(0);
        localObject2 = (Button)((View)localObject1).findViewById(i.f.sns_ad_native_landing_pages_item_stream_video_click_area_button);
        ((Button)localObject2).setTextColor(((w)this.KqB).Kmo);
        ((Button)localObject2).setText(((w)this.KqB).Kmn);
        ((Button)localObject2).setOnClickListener(new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            AppMethodBeat.i(219625);
            Object localObject = new com.tencent.mm.hellhoundlib.b.b();
            ((com.tencent.mm.hellhoundlib.b.b)localObject).bn(paramAnonymousView);
            com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/AdLandingPageSightVideoComponent$8", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).aFi());
            paramAnonymousView = ag.this;
            localObject = (w)paramAnonymousView.KqB;
            if (Util.isNullOrNil(((w)localObject).JCf)) {
              Log.e("MicroMsg.Sns.AdLandingPageSightVideoComponent", "on long video button click without streamVideoUrl!");
            }
            for (;;)
            {
              com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/AdLandingPageSightVideoComponent$8", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
              AppMethodBeat.o(219625);
              return;
              if (!(paramAnonymousView.context instanceof Activity))
              {
                Log.e("MicroMsg.Sns.AdLandingPageSightVideoComponent", "on long video button click but context not activity!");
              }
              else
              {
                Log.v("MicroMsg.Sns.AdLandingPageSightVideoComponent", "on long video button click, jumpto [%s]", new Object[] { ((w)localObject).JCf });
                Intent localIntent = new Intent();
                localIntent.setClass(paramAnonymousView.context, SnsAdStreamVideoPlayUI.class);
                Log.i("MicroMsg.Sns.AdLandingPageSightVideoComponent", "use new stream video play UI");
                localIntent.putExtra("KFromTimeLine", true);
                localIntent.putExtra("KMediaId", MD5Util.getMD5String(((w)localObject).JCf));
                localIntent.putExtra("KThumUrl", ((w)localObject).Kmm);
                localIntent.putExtra("KStremVideoUrl", ((w)localObject).JCf);
                localIntent.putExtra("ForceLandscape", true);
                localIntent.putExtra("ShareBtnHidden", 1);
                localIntent.putExtra("KComponentCid", paramAnonymousView.KqB.KmB);
                ((Activity)paramAnonymousView.context).startActivityForResult(localIntent, 2004);
                paramAnonymousView.Ktd += 1;
              }
            }
          }
        });
        ((View)localObject1).findViewById(i.f.sns_ad_native_landing_pages_item_stream_video_click_area_separator).setBackgroundColor(((w)this.KqB).Kmp);
      }
      try
      {
        this.length = com.tencent.mm.ci.a.fromDPToPix(this.context, 32);
        this.Ktb.setOnTouchListener(this);
        this.Kti = ((ImageView)localView.findViewById(i.f.sns_ad_native_landing_pages_sight_video_full_screen_btn));
        localObject1 = this.Kti.getParent();
        if ((localObject1 instanceof ViewGroup)) {
          ((ViewGroup)localObject1).removeView(this.Kti);
        }
        localObject1 = (RelativeLayout.LayoutParams)this.Kti.getLayoutParams();
        ((RelativeLayout.LayoutParams)localObject1).bottomMargin = com.tencent.mm.ci.a.fromDPToPix(this.context, 8);
        ((RelativeLayout.LayoutParams)localObject1).rightMargin = com.tencent.mm.ci.a.fromDPToPix(this.context, 10);
        ((ViewGroup)localView).addView(this.Kti, (ViewGroup.LayoutParams)localObject1);
        this.Kti.setOnClickListener(this);
        this.Kti.setVisibility(8);
        Log.i("MicroMsg.Sns.AdLandingPageSightVideoComponent.VideoOptimize", "init fullScreenBtn and visible");
      }
      catch (Throwable localThrowable3)
      {
        for (;;)
        {
          label1105:
          int j;
          label1176:
          label1530:
          Log.e("MicroMsg.Sns.AdLandingPageSightVideoComponent.VideoOptimize", localThrowable3.toString());
          continue;
          boolean bool = false;
        }
      }
      try
      {
        this.Kth = new VideoPlayerSeekBar(this.context);
        localObject1 = this.Kth.getParent();
        if ((localObject1 instanceof ViewGroup)) {
          ((ViewGroup)localObject1).removeView(this.Kth);
        }
        localObject1 = new RelativeLayout.LayoutParams(this.Ktr.getLayoutParams().width - com.tencent.mm.ci.a.fromDPToPix(this.context, 75), -2);
        ((RelativeLayout.LayoutParams)localObject1).addRule(12);
        ((RelativeLayout.LayoutParams)localObject1).bottomMargin = com.tencent.mm.ci.a.fromDPToPix(this.context, 3);
        this.Kth.setLayoutParams((ViewGroup.LayoutParams)localObject1);
        ((ViewGroup)this.contentView.findViewById(i.f.content_root)).addView(this.Kth, (ViewGroup.LayoutParams)localObject1);
        ago(0);
        this.Kth.setOnPlayButtonClickListener(this.Ktm);
        this.Kth.setIplaySeekCallback(this.wTG);
        this.Kth.setVisibility(4);
        if (this.JBd != null)
        {
          localObject1 = this.JBd;
          if (this.Kth.getVisibility() == 0)
          {
            bool = true;
            ((an)localObject1).yj(bool);
          }
        }
        else
        {
          Log.i("MicroMsg.Sns.AdLandingPageSightVideoComponent.VideoOptimize", "init progressBar and visible");
        }
      }
      catch (Throwable localThrowable4)
      {
        Log.e("MicroMsg.Sns.AdLandingPageSightVideoComponent.VideoOptimize", localThrowable4.toString());
        break label1105;
      }
      try
      {
        this.Ktj = localView.findViewById(i.f.pause_video_container);
        this.Ktj.setVisibility(8);
        AppMethodBeat.o(96718);
        return;
      }
      catch (Throwable localThrowable1)
      {
        Log.e("MicroMsg.Sns.AdLandingPageSightVideoComponent.VideoOptimize", localThrowable1.toString());
        AppMethodBeat.o(96718);
      }
      ((ViewGroup)localObject1).setLayoutParams(new RelativeLayout.LayoutParams(this.pEj, this.pEk));
      localView.setLayoutParams(new RelativeLayout.LayoutParams(this.pEj, this.pEk));
      break;
      localObject1 = this.Ktb.getInnerVideoView();
      if ((localObject1 instanceof VideoPlayerTextureView))
      {
        ((View)localObject1).addOnLayoutChangeListener(new View.OnLayoutChangeListener()
        {
          public final void onLayoutChange(View paramAnonymousView, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3, int paramAnonymousInt4, int paramAnonymousInt5, int paramAnonymousInt6, int paramAnonymousInt7, int paramAnonymousInt8)
          {
            AppMethodBeat.i(220259);
            try
            {
              paramAnonymousInt1 = paramAnonymousView.getHeight();
              paramAnonymousInt2 = paramAnonymousView.getWidth();
              paramAnonymousInt3 = ag.A(ag.this).getWidth();
              paramAnonymousInt4 = ag.A(ag.this).getHeight();
              if ((paramAnonymousInt2 <= 1) || (paramAnonymousInt1 <= 1) || (paramAnonymousInt3 == 0) || (paramAnonymousInt4 == 0))
              {
                AppMethodBeat.o(220259);
                return;
              }
              Log.i("MicroMsg.Sns.AdLandingPageSightVideoComponent", "onLayoutChange, video.w=" + paramAnonymousView.getWidth() + ", h=" + paramAnonymousView.getHeight() + ", container.w=" + paramAnonymousInt3 + ", h=" + paramAnonymousInt4 + ", container.padding=" + com.tencent.mm.plugin.sns.data.m.gn(ag.A(ag.this)));
              if ((paramAnonymousInt1 != paramAnonymousInt4) || (paramAnonymousInt2 != paramAnonymousInt3))
              {
                paramAnonymousView = ag.A(ag.this).getLayoutParams();
                paramAnonymousView.height = paramAnonymousInt1;
                paramAnonymousView.width = paramAnonymousInt2;
                ag.A(ag.this).setLayoutParams(paramAnonymousView);
                Log.i("MicroMsg.Sns.AdLandingPageSightVideoComponent", "onLayoutChange, reset VideoContainer.height and width");
              }
              AppMethodBeat.o(220259);
              return;
            }
            catch (Exception paramAnonymousView)
            {
              Log.e("MicroMsg.Sns.AdLandingPageSightVideoComponent", "onLayoutChange, exp=" + paramAnonymousView.toString());
              AppMethodBeat.o(220259);
            }
          }
        });
        break label263;
      }
      Log.e("MicroMsg.Sns.AdLandingPageSightVideoComponent", "onLayoutChange, innerVideoView=" + localObject1 + ", displayType=" + ((w)this.KqB).Kmq);
      break label263;
      if (((w)this.KqB).Kmq == 1)
      {
        if (((w)this.KqB).width / this.pEj > ((w)this.KqB).height / this.pEk)
        {
          j = this.pEj;
          i = (int)(j * ((w)this.KqB).height / ((w)this.KqB).width) + 1;
        }
        for (;;)
        {
          localObject2 = new RelativeLayout.LayoutParams(j, i);
          ((RelativeLayout.LayoutParams)localObject2).leftMargin = ((this.pEj - j) / 2);
          ((RelativeLayout.LayoutParams)localObject2).rightMargin = ((RelativeLayout.LayoutParams)localObject2).leftMargin;
          ((RelativeLayout.LayoutParams)localObject2).topMargin = ((this.pEk - i) / 2);
          ((RelativeLayout.LayoutParams)localObject2).bottomMargin = ((RelativeLayout.LayoutParams)localObject2).topMargin;
          ((ViewGroup)localObject1).setLayoutParams((ViewGroup.LayoutParams)localObject2);
          localView.setLayoutParams(new RelativeLayout.LayoutParams(this.pEj, this.pEk));
          break;
          i = this.pEk;
          j = (int)(i * ((w)this.KqB).width / ((w)this.KqB).height) + 1;
        }
      }
      if (((w)this.KqB).Kmq != 2) {
        break label263;
      }
      localObject2 = new RelativeLayout.LayoutParams((int)((w)this.KqB).width, (int)((w)this.KqB).height);
      ((ViewGroup)localObject1).setLayoutParams((ViewGroup.LayoutParams)localObject2);
      localView.setLayoutParams(new RelativeLayout.LayoutParams((RelativeLayout.LayoutParams)localObject2));
      break label263;
      com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.h.a("adId", ((w)this.KqB).Kmm, new f.a()
      {
        public final void aYs(String paramAnonymousString)
        {
          AppMethodBeat.i(261017);
          ag.d(ag.this).bbV(paramAnonymousString);
          AppMethodBeat.o(261017);
        }
        
        public final void fJU() {}
        
        public final void fJV() {}
      });
    }
    label1572:
  }
  
  public final void fKr()
  {
    AppMethodBeat.i(96723);
    super.fKr();
    this.Kte.setImageDrawable(com.tencent.mm.ci.a.m(this.context, i.i.icon_volume_off));
    this.Ktb.setMute(true);
    this.JAS = true;
    AppMethodBeat.o(96723);
  }
  
  public final void fKs()
  {
    AppMethodBeat.i(96724);
    super.fKs();
    this.Kte.setImageDrawable(com.tencent.mm.ci.a.m(this.context, i.i.icon_volume_on));
    this.Ktb.setMute(false);
    this.JAS = false;
    AppMethodBeat.o(96724);
  }
  
  public final long fRk()
  {
    AppMethodBeat.i(270084);
    long l1 = super.fRk();
    long l2 = this.Kto;
    AppMethodBeat.o(270084);
    return l1 + l2;
  }
  
  public final void fRn()
  {
    AppMethodBeat.i(96731);
    super.fRn();
    String str = com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.h.kU("adId", ((w)this.KqB).Kmm);
    yp(false);
    if (u.agG(str))
    {
      this.Ktb.bbV(str);
      this.Ktb.d(false, 0.0F);
    }
    AppMethodBeat.o(96731);
  }
  
  protected final int getLayout()
  {
    return i.g.sns_ad_native_landing_pages_item_sight;
  }
  
  public final boolean isPlaying()
  {
    AppMethodBeat.i(270069);
    boolean bool = this.Ktb.isPlaying();
    AppMethodBeat.o(270069);
    return bool;
  }
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(270074);
    Object localObject = new com.tencent.mm.hellhoundlib.b.b();
    ((com.tencent.mm.hellhoundlib.b.b)localObject).bn(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/AdLandingPageSightVideoComponent", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).aFi());
    if (paramView.getId() == i.f.sns_ad_native_landing_pages_sight_video_full_screen_btn) {
      Log.i("MicroMsg.Sns.AdLandingPageSightVideoComponent.VideoOptimize", "click full screen btn");
    }
    try
    {
      if ((this.context instanceof SnsAdNativeLandingPagesUI))
      {
        this.JBa += 1;
        this.knk.removeCallbacks(this.Ktl);
        this.Ktj.setVisibility(8);
        paramView = (SnsAdNativeLandingPagesUI)this.context;
        b.Kty = (w)this.KqB;
        com.tencent.mm.plugin.sns.model.ae.JWV = fRp();
        localObject = new Intent(paramView, VideoFullScreenActivity.class);
        ((Intent)localObject).putExtra("KComponentVideoType", 0);
        ((Intent)localObject).putExtra("KComponentCid", this.KqB.KmB);
        ((Intent)localObject).putExtra("KComponentCurrentTime", this.Ktb.getCurrentPositionMs());
        ((Intent)localObject).putExtra("KComponentTotalTime", this.Ktb.getDurationMs());
        ((Intent)localObject).putExtra("KComponentVoiceType", this.JAS);
        ((Intent)localObject).putExtra("KComponentProgressType", this.Ktb.isPlaying());
        ((Intent)localObject).putExtra("KComponentVideoSightThumbUrl", ((w)this.KqB).Kmm);
        ((Intent)localObject).putExtra("KComponentStreamVideoUrlPath", ((w)this.KqB).Kml);
        paramView.startActivityForResult((Intent)localObject, 2000);
        com.tencent.mm.plugin.report.service.h.IzE.el(1720, 1);
      }
      for (;;)
      {
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/AdLandingPageSightVideoComponent", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(270074);
        return;
        this.Kti.setVisibility(8);
      }
    }
    catch (Throwable paramView)
    {
      for (;;)
      {
        this.Kti.setVisibility(8);
        Log.e("VideoFullScreenActivity", paramView.toString());
      }
    }
  }
  
  public final boolean onDoubleTap(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(270076);
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.bn(paramMotionEvent);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/AdLandingPageSightVideoComponent", "android/view/GestureDetector$OnDoubleTapListener", "onDoubleTap", "(Landroid/view/MotionEvent;)Z", this, localb.aFi());
    for (;;)
    {
      try
      {
        Log.i("MicroMsg.Sns.AdLandingPageSightVideoComponent.VideoOptimize", "onDoubleTap");
        aE(this.JBl);
        if (this.jVR) {
          this.JAZ += 1;
        }
        if (!this.Ktb.isPlaying()) {
          continue;
        }
        yp(true);
        this.JAI = 4;
      }
      catch (Throwable paramMotionEvent)
      {
        Log.e("MicroMsg.Sns.AdLandingPageSightVideoComponent.VideoOptimize", paramMotionEvent.toString());
        continue;
        fQC();
        fKs();
        continue;
      }
      com.tencent.mm.hellhoundlib.a.a.a(false, this, "com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/AdLandingPageSightVideoComponent", "android/view/GestureDetector$OnDoubleTapListener", "onDoubleTap", "(Landroid/view/MotionEvent;)Z");
      AppMethodBeat.o(270076);
      return false;
      if (!this.JAS) {
        continue;
      }
      fKr();
      cNW();
      this.JAI = 3;
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
  
  public final void onLongPress(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(270078);
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.bn(paramMotionEvent);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/AdLandingPageSightVideoComponent", "android/view/GestureDetector$OnGestureListener", "onLongPress", "(Landroid/view/MotionEvent;)V", this, localb.aFi());
    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/AdLandingPageSightVideoComponent", "android/view/GestureDetector$OnGestureListener", "onLongPress", "(Landroid/view/MotionEvent;)V");
    AppMethodBeat.o(270078);
  }
  
  public final boolean onScroll(MotionEvent paramMotionEvent1, MotionEvent paramMotionEvent2, float paramFloat1, float paramFloat2)
  {
    return false;
  }
  
  public final void onShowPress(MotionEvent paramMotionEvent) {}
  
  public final boolean onSingleTapConfirmed(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(270075);
    for (;;)
    {
      try
      {
        Log.i("MicroMsg.Sns.AdLandingPageSightVideoComponent.VideoOptimize", "onSingleTapConfirmed");
        bool = ((w)this.KqB).Klm;
        if (bool)
        {
          AppMethodBeat.o(270075);
          return false;
        }
        if (!this.jVR) {
          continue;
        }
        if (this.Kth.getVisibility() != 0) {
          continue;
        }
        i = 1;
        if (i == 0) {
          continue;
        }
        this.Kth.setVisibility(4);
        this.Kti.setVisibility(4);
        this.knk.removeCallbacks(this.JBl);
        if (this.JBd == null) {
          continue;
        }
        paramMotionEvent = this.JBd;
        if (i != 0) {
          continue;
        }
        bool = true;
      }
      catch (Throwable paramMotionEvent)
      {
        int i;
        Log.e("MicroMsg.Sns.AdLandingPageSightVideoComponent.VideoOptimize", paramMotionEvent.toString());
        continue;
        boolean bool = false;
        continue;
      }
      paramMotionEvent.yj(bool);
      AppMethodBeat.o(270075);
      return false;
      i = 0;
      continue;
      this.Kth.setVisibility(0);
      this.Kti.setVisibility(0);
      aE(this.JBl);
    }
  }
  
  public final boolean onSingleTapUp(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(270077);
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.bn(paramMotionEvent);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/AdLandingPageSightVideoComponent", "android/view/GestureDetector$OnGestureListener", "onSingleTapUp", "(Landroid/view/MotionEvent;)Z", this, localb.aFi());
    com.tencent.mm.hellhoundlib.a.a.a(false, this, "com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/AdLandingPageSightVideoComponent", "android/view/GestureDetector$OnGestureListener", "onSingleTapUp", "(Landroid/view/MotionEvent;)Z");
    AppMethodBeat.o(270077);
    return false;
  }
  
  @SuppressLint({"ClickableViewAccessibility"})
  public final boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(270073);
    paramView = this.mBn;
    paramMotionEvent = new com.tencent.mm.hellhoundlib.b.a().bm(paramMotionEvent);
    com.tencent.mm.hellhoundlib.a.a.b(paramView, paramMotionEvent.aFh(), "com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/AdLandingPageSightVideoComponent", "onTouch", "(Landroid/view/View;Landroid/view/MotionEvent;)Z", "android/view/GestureDetector_EXEC_", "onTouchEvent", "(Landroid/view/MotionEvent;)Z");
    boolean bool = com.tencent.mm.hellhoundlib.a.a.a(paramView, paramView.onTouchEvent((MotionEvent)paramMotionEvent.sf(0)), "com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/AdLandingPageSightVideoComponent", "onTouch", "(Landroid/view/View;Landroid/view/MotionEvent;)Z", "android/view/GestureDetector_EXEC_", "onTouchEvent", "(Landroid/view/MotionEvent;)Z");
    AppMethodBeat.o(270073);
    return bool;
  }
  
  final class a
    implements AudioManager.OnAudioFocusChangeListener
  {
    a() {}
    
    public final void onAudioFocusChange(int paramInt)
    {
      AppMethodBeat.i(270290);
      try
      {
        ag.agp(paramInt);
        AppMethodBeat.o(270290);
        return;
      }
      catch (Throwable localThrowable)
      {
        Log.e("MicroMsg.Sns.AdLandingPageSightVideoComponent", "onAudioFocusChanged has something wrong!");
        AppMethodBeat.o(270290);
      }
    }
  }
  
  public static final class b
  {
    public static w Kty;
  }
  
  static final class c
  {
    int JGA;
    long JGB;
    int JGC;
    int JGy;
    String JGz;
    int clickCount;
    long fOa;
  }
  
  final class d
    implements k.c
  {
    d() {}
    
    public final void gz(boolean paramBoolean)
    {
      AppMethodBeat.i(218957);
      Log.i("MicroMsg.Sns.AdLandingPageSightVideoComponent", "onSeekComplete is called");
      ag.B(ag.this).sendMessage();
      AppMethodBeat.o(218957);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.ag
 * JD-Core Version:    0.7.0.1
 */