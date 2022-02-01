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
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.oj;
import com.tencent.mm.plugin.sns.data.j;
import com.tencent.mm.plugin.sns.model.AdLandingPagesProxy;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.ag;
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
import com.tencent.mm.pluginsdk.ui.tools.h.c;
import com.tencent.mm.pointers.PString;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.ar;
import com.tencent.mm.sdk.platformtools.az;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.vfs.o;
import org.json.JSONException;
import org.json.JSONObject;

public final class af
  extends com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.a
  implements GestureDetector.OnDoubleTapListener, GestureDetector.OnGestureListener, View.OnClickListener, View.OnTouchListener
{
  private Context context;
  private aq gKO;
  int gim;
  private boolean gxv;
  private View hcH;
  private GestureDetector iNw;
  private boolean isAutoPlay;
  private String kKP;
  private int length;
  private com.tencent.mm.plugin.sight.decode.ui.b rNx;
  private int wyN;
  private long wyh;
  private VideoPlayerSeekBar zWG;
  ImageView zWH;
  private boolean zWI;
  private TextView zWK;
  private Runnable zWL;
  boolean zWP;
  private boolean zWR;
  private boolean zWS;
  private boolean zWT;
  boolean zWU;
  boolean zWV;
  private volatile int zWW;
  private int zWX;
  private int zWY;
  private int zWZ;
  OfflineVideoView zXI;
  private int zXJ;
  private int zXK;
  int zXL;
  int zXM;
  private boolean zXN;
  private ImageView zXO;
  private View zXP;
  private volatile boolean zXQ;
  private Runnable zXR;
  private int zXS;
  private int zXT;
  private c zXU;
  private a zXV;
  private View zXW;
  private View zXX;
  int zXa;
  private am zXb;
  private View.OnClickListener zXc;
  public int zpJ;
  public int zpK;
  public int zpL;
  
  public af(final Context paramContext, u paramu, ViewGroup paramViewGroup)
  {
    super(paramContext, paramu, paramViewGroup);
    AppMethodBeat.i(96717);
    this.wyh = 0L;
    this.zWX = 0;
    this.wyN = 0;
    this.zWY = 0;
    this.zXK = 0;
    this.zpJ = 0;
    this.zpK = 0;
    this.zpL = 0;
    this.zXa = 0;
    this.zXL = 0;
    this.zWP = true;
    this.zXM = 0;
    this.gim = 0;
    this.zWW = 0;
    this.zWR = false;
    this.zWS = true;
    this.isAutoPlay = false;
    this.zWU = true;
    this.zWV = true;
    this.zWT = false;
    this.zXQ = false;
    this.zXb = null;
    this.zXc = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(219510);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/AdLandingPageSightVideoComponent$10", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
        for (;;)
        {
          try
          {
            ae.i("MicroMsg.Sns.AdLandingPageSightVideoComponent.VideoOptimize", "play btn onclick isPlaying[%b]", new Object[] { Boolean.valueOf(af.this.zXI.isPlaying()) });
            af.a(af.this, af.e(af.this));
            if (!af.this.zXI.isPlaying()) {
              continue;
            }
            af.s(af.this);
            af.c(af.this, 4);
            if (af.u(af.this)) {
              af.v(af.this);
            }
          }
          catch (Throwable paramAnonymousView)
          {
            ae.e("MicroMsg.Sns.AdLandingPageSightVideoComponent.VideoOptimize", paramAnonymousView.toString());
            continue;
            af.this.dZQ();
            af.this.dZP();
            continue;
          }
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/AdLandingPageSightVideoComponent$10", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(219510);
          return;
          if (!af.this.zWP) {
            continue;
          }
          af.this.dZN();
          af.t(af.this);
          af.c(af.this, 3);
        }
      }
    };
    this.rNx = new com.tencent.mm.plugin.sight.decode.ui.b()
    {
      public final void aqS()
      {
        AppMethodBeat.i(219511);
        try
        {
          af.a(af.this, af.e(af.this));
          if (af.d(af.this) != null) {
            af.d(af.this).edL();
          }
          AppMethodBeat.o(219511);
          return;
        }
        catch (Throwable localThrowable)
        {
          ae.e("MicroMsg.Sns.AdLandingPageSightVideoComponent.VideoOptimize", localThrowable.toString());
          AppMethodBeat.o(219511);
        }
      }
      
      public final void nP(int paramAnonymousInt)
      {
        AppMethodBeat.i(219512);
        try
        {
          ae.i("MicroMsg.Sns.AdLandingPageSightVideoComponent.VideoOptimize", "onSeek time ".concat(String.valueOf(paramAnonymousInt)));
          if (af.this.zWP) {
            af.this.dZN();
          }
          for (;;)
          {
            af.d(af.this).aF(paramAnonymousInt * 1000, true);
            af.c(af.this, 3);
            af.b(af.this, true);
            af.x(af.this).removeCallbacks(af.w(af.this));
            af.b(af.this).setVisibility(8);
            AppMethodBeat.o(219512);
            return;
            af.this.dZP();
          }
          return;
        }
        catch (Throwable localThrowable)
        {
          ae.e("MicroMsg.Sns.AdLandingPageSightVideoComponent.VideoOptimize", localThrowable.toString());
          AppMethodBeat.o(219512);
        }
      }
    };
    this.zWZ = 0;
    this.zXS = 0;
    this.zXT = 0;
    this.context = paramContext;
    this.gKO = new aq(Looper.getMainLooper());
    try
    {
      this.iNw = new GestureDetector(this);
      this.zWL = new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(219509);
          af.a(af.this);
          AppMethodBeat.o(219509);
        }
      };
      this.zXR = new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(219516);
          af.b(af.this).setVisibility(8);
          AppMethodBeat.o(219516);
        }
      };
      this.zXb = new am()
      {
        public final void rK(boolean paramAnonymousBoolean)
        {
          AppMethodBeat.i(219517);
          try
          {
            Intent localIntent = new Intent("com.tencent.mm.adlanding.video_progressbar_change");
            if (paramAnonymousBoolean) {}
            for (int i = 1;; i = 0)
            {
              localIntent.putExtra("show", i);
              localIntent.putExtra("activity_code", af.c(af.this));
              android.support.v4.content.d.V(paramContext).b(localIntent);
              AppMethodBeat.o(219517);
              return;
            }
            return;
          }
          catch (Throwable localThrowable)
          {
            ae.e("MicroMsg.Sns.AdLandingPageSightVideoComponent", localThrowable.toString());
            AppMethodBeat.o(219517);
          }
        }
      };
      AppMethodBeat.o(96717);
      return;
    }
    catch (Throwable paramContext)
    {
      ae.e("MicroMsg.Sns.AdLandingPageSightVideoComponent.VideoOptimize", paramContext.toString());
      AppMethodBeat.o(96717);
    }
  }
  
  private void Ra(final int paramInt)
  {
    AppMethodBeat.i(219535);
    try
    {
      this.gKO.post(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(219531);
          af.n(af.this).seek(paramInt);
          af.b(af.this, af.this.zXI.isPlaying());
          AppMethodBeat.o(219531);
        }
      });
      AppMethodBeat.o(219535);
      return;
    }
    catch (Throwable localThrowable)
    {
      ae.e("MicroMsg.Sns.AdLandingPageSightVideoComponent.VideoOptimize", localThrowable.toString());
      AppMethodBeat.o(219535);
    }
  }
  
  public static void aBe(String paramString)
  {
    int i = 1;
    AppMethodBeat.i(219538);
    Object localObject = "0";
    for (;;)
    {
      try
      {
        if (o.fB(paramString))
        {
          String str = "1";
          localObject = str;
          if (o.deleteFile(paramString))
          {
            localObject = str;
            paramString = az.iW(ak.getContext());
            j.b(j.ztQ, (String)localObject, 1, i, "http|".concat(String.valueOf(paramString)));
            AppMethodBeat.o(219538);
            return;
          }
        }
      }
      catch (Throwable paramString)
      {
        ae.e("MicroMsg.Sns.AdLandingPageSightVideoComponent", "delErrorFile exp=" + paramString.toString());
        AppMethodBeat.o(219538);
        return;
      }
      i = 0;
    }
  }
  
  private void abandonAudioFocus()
  {
    AppMethodBeat.i(219549);
    try
    {
      if (this.zXV != null)
      {
        AudioManager localAudioManager = (AudioManager)this.context.getSystemService("audio");
        if (localAudioManager != null)
        {
          localAudioManager.abandonAudioFocus(this.zXV);
          this.zXV = null;
        }
      }
      AppMethodBeat.o(219549);
      return;
    }
    catch (Throwable localThrowable)
    {
      ae.e("MicroMsg.Sns.AdLandingPageSightVideoComponent", "abandonAudioFocus has something wrong!");
      AppMethodBeat.o(219549);
    }
  }
  
  private void ao(Runnable paramRunnable)
  {
    AppMethodBeat.i(219539);
    try
    {
      this.gKO.removeCallbacks(paramRunnable);
      this.gKO.postDelayed(paramRunnable, 4000L);
      AppMethodBeat.o(219539);
      return;
    }
    catch (Throwable paramRunnable)
    {
      ae.e("MicroMsg.Sns.AdLandingPageSightVideoComponent.VideoOptimize", paramRunnable.toString());
      AppMethodBeat.o(219539);
    }
  }
  
  private void cbC()
  {
    AppMethodBeat.i(96721);
    if (this.zWT)
    {
      ae.i("MicroMsg.Sns.AdLandingPageSightVideoComponent", "last download fail ,try again");
      this.zXI.cyW();
      AppMethodBeat.o(96721);
      return;
    }
    ae.d("MicroMsg.Sns.AdLandingPageSightVideoComponent", "starting play");
    if ((!this.zXN) && (!TextUtils.isEmpty(this.kKP)))
    {
      this.zXI.ahQ(this.kKP);
      this.zXN = true;
    }
    this.gKO.post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(219513);
        af.d(af.this).edM();
        af.y(af.this);
        try
        {
          af.b(af.this, true);
          af.x(af.this).removeCallbacks(af.w(af.this));
          af.b(af.this).setVisibility(8);
          AppMethodBeat.o(219513);
          return;
        }
        catch (Throwable localThrowable)
        {
          ae.e("MicroMsg.Sns.AdLandingPageSightVideoComponent", localThrowable.toString());
          AppMethodBeat.o(219513);
        }
      }
    });
    this.wyh = System.currentTimeMillis();
    this.wyN += 1;
    AppMethodBeat.o(96721);
  }
  
  private boolean eaQ()
  {
    AppMethodBeat.i(96720);
    if (!bu.isNullOrNil(((u)this.zUP).zQf))
    {
      Intent localIntent = new Intent();
      localIntent.putExtra("sns_landig_pages_from_source", 14);
      localIntent.putExtra("sns_landig_pages_origin_from_source", eaD().zRN);
      localIntent.putExtra("sns_landing_pages_ux_info", eaD().dGD);
      localIntent.putExtra("sns_landing_pages_xml", "");
      localIntent.putExtra("sns_landing_pages_canvasid", ((u)this.zUP).zQf);
      localIntent.putExtra("sns_landing_pages_canvas_ext", ((u)this.zUP).zQg);
      localIntent.putExtra("sns_landing_pages_no_store", ((u)this.zUP).zQh);
      localIntent.putExtra("sns_landing_pages_need_enter_and_exit_animation", true);
      String str3;
      String str1;
      String str2;
      JSONObject localJSONObject;
      if (((this.context instanceof Activity)) && (eaD().bizId == 2))
      {
        str3 = ((Activity)this.context).getIntent().getStringExtra("sns_landing_pages_sessionId");
        str1 = ((Activity)this.context).getIntent().getStringExtra("sns_landing_pages_ad_buffer");
        if (!bu.isNullOrNil(str3))
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
          localJSONObject.put("cid", ((u)this.zUP).zRg);
          if (bu.isNullOrNil(str1)) {
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
        this.zXI.getLocationOnScreen((int[])localObject);
        localIntent.putExtra("img_gallery_top", localObject[1]);
        localIntent.putExtra("img_gallery_left", localObject[0]);
        localIntent.putExtra("img_gallery_width", this.zXI.getWidth());
        localIntent.putExtra("img_gallery_height", this.zXI.getHeight());
        com.tencent.mm.br.d.b(this.context, "sns", ".ui.SnsAdNativeLandingPagesPreviewUI", localIntent);
        AppMethodBeat.o(96720);
        return true;
        localObject = "";
      }
    }
    AppMethodBeat.o(96720);
    return false;
  }
  
  private void rL(boolean paramBoolean)
  {
    AppMethodBeat.i(219534);
    try
    {
      this.zWG.setIsPlay(paramBoolean);
      this.zWG.getPlayBtn().getLayoutParams().width = this.length;
      this.zWG.getPlayBtn().getLayoutParams().height = this.length;
      if (paramBoolean)
      {
        ae.i("MicroMsg.Sns.AdLandingPageSightVideoComponent.VideoOptimize", "startPlay");
        this.zWG.getPlayBtn().setImageDrawable(com.tencent.mm.cb.a.l(this.context, 2131691470));
        AppMethodBeat.o(219534);
        return;
      }
      ae.i("MicroMsg.Sns.AdLandingPageSightVideoComponent.VideoOptimize", "pausePlay");
      this.zWG.getPlayBtn().setImageDrawable(com.tencent.mm.cb.a.l(this.context, 2131691469));
      AppMethodBeat.o(219534);
      return;
    }
    catch (Throwable localThrowable)
    {
      ae.e("MicroMsg.Sns.AdLandingPageSightVideoComponent.VideoOptimize", localThrowable.toString());
      AppMethodBeat.o(219534);
    }
  }
  
  private void rM(final boolean paramBoolean)
  {
    AppMethodBeat.i(219536);
    ae.d("MicroMsg.Sns.AdLandingPageSightVideoComponent", "pause play");
    this.gKO.post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(219514);
        af.d(af.this).edL();
        try
        {
          af.b(af.this, false);
          if ((af.q(af.this)) && (paramBoolean))
          {
            af.b(af.this).setVisibility(0);
            af.a(af.this, af.w(af.this));
          }
          AppMethodBeat.o(219514);
          return;
        }
        catch (Throwable localThrowable)
        {
          ae.e("MicroMsg.Sns.AdLandingPageSightVideoComponent", localThrowable.toString());
          AppMethodBeat.o(219514);
        }
      }
    });
    if (this.wyh != 0L)
    {
      this.zWX = ((int)(this.zWX + (System.currentTimeMillis() - this.wyh)));
      this.wyh = 0L;
    }
    AppMethodBeat.o(219536);
  }
  
  public final void a(int paramInt1, boolean paramBoolean1, boolean paramBoolean2, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, long paramLong, String paramString)
  {
    AppMethodBeat.i(219546);
    for (;;)
    {
      try
      {
        this.zWW = 6;
        this.zXQ = paramBoolean2;
        this.zXT += 1;
        this.zWZ += paramInt2;
        this.zXS += paramInt3;
        this.zXa += paramInt4;
        this.zWY += paramInt5;
        this.wyN += paramInt6;
        this.zWX = ((int)(this.zWX + paramLong));
        if (paramBoolean2) {
          this.wyh = System.currentTimeMillis();
        }
        boolean bool = bu.isNullOrNil(paramString);
        if (!bool) {}
        try
        {
          paramString = new JSONObject(paramString);
          if (this.zXU == null) {
            this.zXU = new c();
          }
          c localc = this.zXU;
          localc.zUQ += paramString.optInt("exposureCount");
          localc = this.zXU;
          localc.dCI += paramString.optLong("stayTime");
          localc = this.zXU;
          localc.clickCount += paramString.optInt("clickCount");
          paramString = paramString.optJSONObject("btnInfo");
          this.zXU.zYf = paramString.optString("cid");
          localc = this.zXU;
          localc.zYg += paramString.optInt("exposureCount");
          localc = this.zXU;
          localc.zYh += paramString.optLong("stayTime");
          localc = this.zXU;
          paramInt2 = localc.zYi;
          localc.zYi = (paramString.optInt("clickCount") + paramInt2);
        }
        catch (Throwable paramString)
        {
          this.zXU = null;
          ae.e("MicroMsg.Sns.AdLandingPageSightVideoComponent", paramString.toString());
          continue;
        }
        this.gKO.removeCallbacks(this.zXR);
        this.zXP.setVisibility(8);
        ae.i("NonFullOrFullVideoType", "currPosSec = " + paramInt1 + ", isPlaying = " + paramBoolean2 + ", bNoVoice = " + paramBoolean1);
        paramInt2 = paramInt1 / 1000;
        if ((paramInt2 >= this.zXJ) || (paramInt1 < 0))
        {
          this.zWG.seek(0);
          this.zXI.aF(0, paramBoolean2);
          rL(paramBoolean2);
          if (!paramBoolean1) {
            break;
          }
          dZN();
          AppMethodBeat.o(219546);
          return;
        }
      }
      catch (Throwable paramString)
      {
        ae.e("NonFullOrFullVideoType", paramString.toString());
        AppMethodBeat.o(219546);
        return;
      }
      this.zWG.seek(paramInt2);
      this.zXI.aF(paramInt1, paramBoolean2);
    }
    dZP();
    AppMethodBeat.o(219546);
  }
  
  public final boolean aQ(JSONObject paramJSONObject)
  {
    AppMethodBeat.i(96729);
    if (!super.aQ(paramJSONObject))
    {
      AppMethodBeat.o(96729);
      return false;
    }
    try
    {
      paramJSONObject.put("sightDuration", this.zXJ * 1000);
      paramJSONObject.put("playTimeInterval", this.zWX);
      paramJSONObject.put("playCount", this.wyN);
      paramJSONObject.put("playCompletedCount", this.zWY);
      paramJSONObject.put("clickPlayControlCount", this.zWZ);
      paramJSONObject.put("doubleClickCount", this.zXS);
      paramJSONObject.put("clickFullscreenBtnCount", this.zXT);
      paramJSONObject.put("clickVoiceControlCount", this.zXa);
      if (this.isAutoPlay) {}
      for (Object localObject = "1";; localObject = "0")
      {
        paramJSONObject.put("isAutoPlay", localObject);
        if (((u)this.zUP).type == 61) {
          paramJSONObject.put("clickSightCount", this.zXL);
        }
        JSONObject localJSONObject;
        if (!this.zWV)
        {
          localObject = aj.ej(((u)this.zUP).zQP);
          localJSONObject = new JSONObject();
          localJSONObject.put("urlMd5", localObject);
          localJSONObject.put("needDownload", 1);
          paramJSONObject.put("sightUrlInfo", localJSONObject);
        }
        if (!this.zWU)
        {
          localObject = aj.ej(((u)this.zUP).zQQ);
          localJSONObject = new JSONObject();
          localJSONObject.put("urlMd5", localObject);
          localJSONObject.put("needDownload", 1);
          paramJSONObject.put("thumbUrlInfo", localJSONObject);
        }
        paramJSONObject.put("streamVideoEnterCount", this.zXK);
        paramJSONObject.put("streamVideoPlayCount", this.zpJ);
        paramJSONObject.put("streamVideoPlayCompleteCount", this.zpK);
        paramJSONObject.put("streamVideoTotalPlayTimeInMs", this.zpL);
        if (this.zXU != null)
        {
          localObject = new JSONObject();
          ((JSONObject)localObject).put("cid", this.zXU.zYf);
          ((JSONObject)localObject).put("exposureCount", this.zXU.zYg);
          ((JSONObject)localObject).put("stayTime", this.zXU.zYh);
          ((JSONObject)localObject).put("clickCount", this.zXU.zYi);
          localJSONObject = new JSONObject();
          localJSONObject.put("exposureCount", this.zXU.zUQ);
          localJSONObject.put("stayTime", this.zXU.dCI);
          localJSONObject.put("clickCount", this.zXU.clickCount);
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
      ae.printErrStackTrace("MicroMsg.Sns.AdLandingPageSightVideoComponent", paramJSONObject, "", new Object[0]);
      AppMethodBeat.o(96729);
    }
  }
  
  public final void cyU()
  {
    AppMethodBeat.i(219547);
    rM(false);
    this.zWW = 4;
    AppMethodBeat.o(219547);
  }
  
  public final void cyV()
  {
    AppMethodBeat.i(219548);
    this.zWW = 3;
    cbC();
    AppMethodBeat.o(219548);
  }
  
  public final void dUI()
  {
    AppMethodBeat.i(96718);
    if (!o.fB(h.jL("adId", ((u)this.zUP).zQQ))) {
      this.zWU = false;
    }
    if (!o.fB(com.tencent.mm.loader.j.b.asj() + "/sns_ad_landingpages/adId_stream_" + aj.ej(((u)this.zUP).zQP))) {
      this.zWV = false;
    }
    View localView = this.contentView.findViewById(2131304914);
    this.zXW = localView;
    Object localObject1 = (ViewGroup)localView.findViewById(2131304907);
    this.zXI = new OfflineVideoView(this.context);
    this.zXX = ((View)localObject1);
    ((ViewGroup)localObject1).addView(this.zXI, new LinearLayout.LayoutParams(-1, -1));
    int i;
    Object localObject2;
    if (((u)this.zUP).zQV == 0) {
      if ((int)((u)this.zUP).width > 0)
      {
        i = this.lxZ;
        localObject2 = new RelativeLayout.LayoutParams(i, (int)(i * ((u)this.zUP).height / ((u)this.zUP).width));
        ((ViewGroup)localObject1).setLayoutParams((ViewGroup.LayoutParams)localObject2);
        localView.setLayoutParams((ViewGroup.LayoutParams)localObject2);
        if (((u)this.zUP).zQX) {
          break label1168;
        }
        ae.e("MicroMsg.Sns.AdLandingPageSightVideoComponent", "fixVideoBlackline, enable=false");
        label255:
        ae.i("MicroMsg.Sns.AdLandingPageSightVideoComponent", "createView, displayType=" + ((u)this.zUP).zQV);
        localObject1 = h.jL("adId", ((u)this.zUP).zQQ);
        if (!o.fB((String)localObject1)) {
          break label1522;
        }
        this.zXI.aCa((String)localObject1);
      }
    }
    for (;;)
    {
      this.zWK = ((TextView)localView.findViewById(2131299517));
      this.zWK.setText(this.context.getString(2131758104));
      this.hcH = localView.findViewById(2131304920);
      if (this.hcH != null)
      {
        localObject1 = new RelativeLayout.LayoutParams(-1, -1);
        localObject2 = this.hcH.getParent();
        if ((localObject2 instanceof ViewGroup)) {
          ((ViewGroup)localObject2).removeView(this.hcH);
        }
        ((ViewGroup)localView).addView(this.hcH, (ViewGroup.LayoutParams)localObject1);
      }
      this.zWH = ((ImageView)localView.findViewById(2131304921));
      this.zWH.setVisibility(0);
      this.zWH.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(96714);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bd(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/AdLandingPageSightVideoComponent$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
          paramAnonymousView = af.this;
          paramAnonymousView.zXa += 1;
          af.a(af.this, af.e(af.this));
          if (af.this.zWP)
          {
            af.this.dZQ();
            af.this.dZP();
          }
          for (;;)
          {
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/AdLandingPageSightVideoComponent$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(96714);
            return;
            af.this.dZN();
          }
        }
      });
      try
      {
        localObject1 = this.zWH.getParent();
        if ((localObject1 instanceof ViewGroup)) {
          ((ViewGroup)localObject1).removeView(this.zWH);
        }
        localObject1 = (RelativeLayout.LayoutParams)this.zWH.getLayoutParams();
        ((RelativeLayout.LayoutParams)localObject1).bottomMargin = com.tencent.mm.cb.a.fromDPToPix(this.context, 8);
        ((RelativeLayout.LayoutParams)localObject1).rightMargin = com.tencent.mm.cb.a.fromDPToPix(this.context, 10);
        ((ViewGroup)localView).addView(this.zWH, (ViewGroup.LayoutParams)localObject1);
        ae.i("MicroMsg.Sns.AdLandingPageSightVideoComponent.VideoOptimize", "init voiceTypeBtn and visible");
      }
      catch (Throwable localThrowable2)
      {
        for (;;)
        {
          ae.e("MicroMsg.Sns.AdLandingPageSightVideoComponent.VideoOptimize", localThrowable2.toString());
          continue;
          i = 0;
        }
      }
      this.zXI.setVideoCallback(new OfflineVideoView.a()
      {
        public final boolean a(PString paramAnonymousPString)
        {
          AppMethodBeat.i(219525);
          final long l = System.currentTimeMillis();
          final String str1 = af.f(af.this).zQP;
          final String str2 = h.jM("adId", str1);
          if (o.fB(str2))
          {
            paramAnonymousPString.value = str2;
            af.g(af.this);
            AppMethodBeat.o(219525);
            return true;
          }
          if (!af.f(af.this).zQY) {
            h.d("adId", str1, false, 62, new f.a()
            {
              public final void ayY(String paramAnonymous2String)
              {
                AppMethodBeat.i(219520);
                ae.i("MicroMsg.Sns.AdLandingPageSightVideoComponent", "downloadSightForAdLandingPages succ, video view height " + af.this.contentView.getHeight() + ", player height " + af.d(af.this).getHeight() + ", timeCost=" + (System.currentTimeMillis() - l));
                af.a(af.this, false);
                af.a(af.this, paramAnonymous2String);
                af.d(af.this).ahQ(paramAnonymous2String);
                af.g(af.this);
                AppMethodBeat.o(219520);
              }
              
              public final void dVu() {}
              
              public final void dVv()
              {
                AppMethodBeat.i(219519);
                ae.e("MicroMsg.Sns.AdLandingPageSightVideoComponent", "downloadSightForAdLandingPages fail:" + str1);
                af.a(af.this, true);
                af.aBe(str2);
                AppMethodBeat.o(219519);
              }
            });
          }
          for (;;)
          {
            AppMethodBeat.o(219525);
            return false;
            h.b("adId", str1, new f.a()
            {
              public final void ayY(String paramAnonymous2String)
              {
                AppMethodBeat.i(219522);
                ae.i("MicroMsg.Sns.AdLandingPageSightVideoComponent", "downloadSightForAdLandingPagesByCdn succ, video view height " + af.this.contentView.getHeight() + ", player height " + af.d(af.this).getHeight() + ", timeCost=" + (System.currentTimeMillis() - l));
                af.a(af.this, false);
                af.a(af.this, paramAnonymous2String);
                af.d(af.this).ahQ(paramAnonymous2String);
                af.g(af.this);
                AppMethodBeat.o(219522);
              }
              
              public final void dVu() {}
              
              public final void dVv()
              {
                AppMethodBeat.i(219521);
                ae.e("MicroMsg.Sns.AdLandingPageSightVideoComponent", "downloadSightForAdLandingPagesByCdn fail:" + str1);
                af.a(af.this, true);
                AppMethodBeat.o(219521);
              }
            });
          }
        }
        
        public final void onCompletion()
        {
          AppMethodBeat.i(219526);
          ar.f(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(219523);
              if ((af.f(af.this).zQW != null) && (!af.h(af.this)))
              {
                int i = af.d(af.this).getDurationMs();
                int j = af.f(af.this).zQW.zRT;
                ae.i("MicroMsg.Sns.AdLandingPageSightVideoComponent", "OpenSnsAdFloatPageEvent, onCompletion totalMs=" + i + ", floatStartTime=" + j + ", hasShowFloat=" + af.h(af.this));
                if (i < j)
                {
                  af.i(af.this);
                  oj localoj = new oj();
                  localoj.dDo.dDp = af.f(af.this).zQW.dDp;
                  com.tencent.mm.sdk.b.a.IvT.l(localoj);
                }
              }
              AppMethodBeat.o(219523);
            }
          });
          af.j(af.this);
          af.k(af.this).zoc = true;
          af.l(af.this);
          AppMethodBeat.o(219526);
        }
        
        public final void onStart(int paramAnonymousInt)
        {
          AppMethodBeat.i(219527);
          af.m(af.this);
          af.a(af.this, paramAnonymousInt);
          af.this.zWH.setVisibility(0);
          try
          {
            if (af.n(af.this).getVideoTotalTime() != paramAnonymousInt) {
              af.n(af.this).setVideoTotalTime(af.o(af.this));
            }
            ae.i("MicroMsg.Sns.AdLandingPageSightVideoComponent.VideoOptimize", "onStart");
            AppMethodBeat.o(219527);
            return;
          }
          catch (Throwable localThrowable)
          {
            ae.i("MicroMsg.Sns.AdLandingPageSightVideoComponent.VideoOptimize", localThrowable.toString());
            AppMethodBeat.o(219527);
          }
        }
        
        public final void tx(int paramAnonymousInt)
        {
          AppMethodBeat.i(219528);
          af.p(af.this).sendMessage();
          ar.f(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(219524);
              ae.d("MicroMsg.Sns.AdLandingPageSightVideoComponent", "play time " + this.zkp + " video time " + af.o(af.this));
              af.b(af.this, this.zkp);
              if ((af.f(af.this).zQW != null) && (!af.h(af.this)))
              {
                int i = af.f(af.this).zQW.zRT / 1000;
                ae.i("MicroMsg.Sns.AdLandingPageSightVideoComponent", "OpenSnsAdFloatPageEvent, updateTime seconds=" + this.zkp + ", floatSeconds=" + i + ", hasShowFloat=" + af.h(af.this));
                if (this.zkp >= i)
                {
                  af.i(af.this);
                  oj localoj = new oj();
                  localoj.dDo.dDp = af.f(af.this).zQW.dDp;
                  com.tencent.mm.sdk.b.a.IvT.l(localoj);
                }
              }
              AppMethodBeat.o(219524);
            }
          });
          AppMethodBeat.o(219528);
        }
      });
      this.zXI.setOnSeekCompleteCallback(new d());
      this.zWH.setVisibility(8);
      this.zXI.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(219529);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bd(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/AdLandingPageSightVideoComponent$7", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
          if (af.q(af.this))
          {
            paramAnonymousView = af.this;
            paramAnonymousView.zXL += 1;
            if (af.r(af.this))
            {
              com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/AdLandingPageSightVideoComponent$7", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
              AppMethodBeat.o(219529);
              return;
            }
          }
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/AdLandingPageSightVideoComponent$7", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(219529);
        }
      });
      localObject1 = (u)this.zUP;
      if ((((u)localObject1).subType != 1) || (((u)localObject1).zQS.length() <= 0) || (((u)localObject1).zQR.length() <= 0)) {
        break label1568;
      }
      i = 1;
      if (i != 0)
      {
        localObject1 = this.contentView.findViewById(2131304908);
        ((View)localObject1).setVisibility(0);
        localObject2 = (Button)((View)localObject1).findViewById(2131304909);
        ((Button)localObject2).setTextColor(((u)this.zUP).zQT);
        ((Button)localObject2).setText(((u)this.zUP).zQS);
        ((Button)localObject2).setOnClickListener(new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            AppMethodBeat.i(219530);
            com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
            localb.bd(paramAnonymousView);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/AdLandingPageSightVideoComponent$8", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
            af.this.eaP();
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/AdLandingPageSightVideoComponent$8", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(219530);
          }
        });
        ((View)localObject1).findViewById(2131304910).setBackgroundColor(((u)this.zUP).zQU);
      }
      try
      {
        this.length = com.tencent.mm.cb.a.fromDPToPix(this.context, 32);
        this.zXI.setOnTouchListener(this);
        this.zXO = ((ImageView)localView.findViewById(2131307246));
        localObject1 = this.zXO.getParent();
        if ((localObject1 instanceof ViewGroup)) {
          ((ViewGroup)localObject1).removeView(this.zXO);
        }
        localObject1 = (RelativeLayout.LayoutParams)this.zXO.getLayoutParams();
        ((RelativeLayout.LayoutParams)localObject1).bottomMargin = com.tencent.mm.cb.a.fromDPToPix(this.context, 8);
        ((RelativeLayout.LayoutParams)localObject1).rightMargin = com.tencent.mm.cb.a.fromDPToPix(this.context, 10);
        ((ViewGroup)localView).addView(this.zXO, (ViewGroup.LayoutParams)localObject1);
        this.zXO.setOnClickListener(this);
        this.zXO.setVisibility(8);
        ae.i("MicroMsg.Sns.AdLandingPageSightVideoComponent.VideoOptimize", "init fullScreenBtn and visible");
      }
      catch (Throwable localThrowable3)
      {
        for (;;)
        {
          label1097:
          int j;
          label1168:
          label1522:
          ae.e("MicroMsg.Sns.AdLandingPageSightVideoComponent.VideoOptimize", localThrowable3.toString());
          continue;
          boolean bool = false;
        }
      }
      try
      {
        this.zWG = new VideoPlayerSeekBar(this.context);
        localObject1 = this.zWG.getParent();
        if ((localObject1 instanceof ViewGroup)) {
          ((ViewGroup)localObject1).removeView(this.zWG);
        }
        localObject1 = new RelativeLayout.LayoutParams(this.zXX.getLayoutParams().width - com.tencent.mm.cb.a.fromDPToPix(this.context, 75), -2);
        ((RelativeLayout.LayoutParams)localObject1).addRule(12);
        ((RelativeLayout.LayoutParams)localObject1).bottomMargin = com.tencent.mm.cb.a.fromDPToPix(this.context, 3);
        this.zWG.setLayoutParams((ViewGroup.LayoutParams)localObject1);
        ((ViewGroup)this.contentView.findViewById(2131298770)).addView(this.zWG, (ViewGroup.LayoutParams)localObject1);
        Ra(0);
        this.zWG.setOnPlayButtonClickListener(this.zXc);
        this.zWG.setIplaySeekCallback(this.rNx);
        this.zWG.setVisibility(4);
        if (this.zXb != null)
        {
          localObject1 = this.zXb;
          if (this.zWG.getVisibility() == 0)
          {
            bool = true;
            ((am)localObject1).rK(bool);
          }
        }
        else
        {
          ae.i("MicroMsg.Sns.AdLandingPageSightVideoComponent.VideoOptimize", "init progressBar and visible");
        }
      }
      catch (Throwable localThrowable4)
      {
        ae.e("MicroMsg.Sns.AdLandingPageSightVideoComponent.VideoOptimize", localThrowable4.toString());
        break label1097;
      }
      try
      {
        this.zXP = localView.findViewById(2131307220);
        this.zXP.setVisibility(8);
        AppMethodBeat.o(96718);
        return;
      }
      catch (Throwable localThrowable1)
      {
        ae.e("MicroMsg.Sns.AdLandingPageSightVideoComponent.VideoOptimize", localThrowable1.toString());
        AppMethodBeat.o(96718);
      }
      ((ViewGroup)localObject1).setLayoutParams(new RelativeLayout.LayoutParams(this.lxZ, this.lya));
      localView.setLayoutParams(new RelativeLayout.LayoutParams(this.lxZ, this.lya));
      break;
      localObject1 = this.zXI.getInnerVideoView();
      if ((localObject1 instanceof VideoPlayerTextureView))
      {
        ((View)localObject1).addOnLayoutChangeListener(new af.6(this));
        break label255;
      }
      ae.e("MicroMsg.Sns.AdLandingPageSightVideoComponent", "onLayoutChange, innerVideoView=" + localObject1 + ", displayType=" + ((u)this.zUP).zQV);
      break label255;
      if (((u)this.zUP).zQV == 1)
      {
        if (((u)this.zUP).width / this.lxZ > ((u)this.zUP).height / this.lya)
        {
          j = this.lxZ;
          i = (int)(j * ((u)this.zUP).height / ((u)this.zUP).width) + 1;
        }
        for (;;)
        {
          localObject2 = new RelativeLayout.LayoutParams(j, i);
          ((RelativeLayout.LayoutParams)localObject2).leftMargin = ((this.lxZ - j) / 2);
          ((RelativeLayout.LayoutParams)localObject2).rightMargin = ((RelativeLayout.LayoutParams)localObject2).leftMargin;
          ((RelativeLayout.LayoutParams)localObject2).topMargin = ((this.lya - i) / 2);
          ((RelativeLayout.LayoutParams)localObject2).bottomMargin = ((RelativeLayout.LayoutParams)localObject2).topMargin;
          ((ViewGroup)localObject1).setLayoutParams((ViewGroup.LayoutParams)localObject2);
          localView.setLayoutParams(new RelativeLayout.LayoutParams(this.lxZ, this.lya));
          break;
          i = this.lya;
          j = (int)(i * ((u)this.zUP).width / ((u)this.zUP).height) + 1;
        }
      }
      if (((u)this.zUP).zQV != 2) {
        break label255;
      }
      localObject2 = new RelativeLayout.LayoutParams((int)((u)this.zUP).width, (int)((u)this.zUP).height);
      ((ViewGroup)localObject1).setLayoutParams((ViewGroup.LayoutParams)localObject2);
      localView.setLayoutParams(new RelativeLayout.LayoutParams((RelativeLayout.LayoutParams)localObject2));
      break label255;
      h.c("adId", ((u)this.zUP).zQQ, false, 1000000001, new f.a()
      {
        public final void ayY(String paramAnonymousString)
        {
          AppMethodBeat.i(219518);
          af.d(af.this).aCa(paramAnonymousString);
          AppMethodBeat.o(219518);
        }
        
        public final void dVu() {}
        
        public final void dVv() {}
      });
    }
    label1568:
  }
  
  protected final void dUJ()
  {
    AppMethodBeat.i(96730);
    ae.i("MicroMsg.Sns.AdLandingPageSightVideoComponent", getClass().getName() + "not support update now");
    AppMethodBeat.o(96730);
  }
  
  public final void dUK()
  {
    AppMethodBeat.i(96725);
    super.dUK();
    AppMethodBeat.o(96725);
  }
  
  public final void dUL()
  {
    AppMethodBeat.i(96726);
    super.dUL();
    abandonAudioFocus();
    rM(false);
    if ((!this.zWR) && (!this.zWS))
    {
      AppMethodBeat.o(96726);
      return;
    }
    this.zWS = false;
    this.zWR = false;
    if (this.zWW == 1) {
      this.zWW = 2;
    }
    int i = this.zWW;
    ae.d("MicroMsg.Sns.AdLandingPageSightVideoComponent", "disappear handleType %d", new Object[] { Integer.valueOf(this.zWW) });
    AppMethodBeat.o(96726);
  }
  
  public final void dUM()
  {
    AppMethodBeat.i(96727);
    super.dUM();
    try
    {
      this.gKO.removeCallbacks(this.zWL);
      this.gKO.removeCallbacks(this.zXR);
      abandonAudioFocus();
      this.zXI.onDestroy();
      AppMethodBeat.o(96727);
      return;
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        ae.e("MicroMsg.Sns.AdLandingPageSightVideoComponent.VideoOptimize", localThrowable.toString());
      }
    }
  }
  
  public final void dZN()
  {
    AppMethodBeat.i(96723);
    super.dZN();
    this.zWH.setImageDrawable(com.tencent.mm.cb.a.l(this.context, 2131690341));
    this.zXI.setMute(true);
    this.zWP = true;
    AppMethodBeat.o(96723);
  }
  
  public final void dZO()
  {
    AppMethodBeat.i(96728);
    super.dZO();
    int i = eax();
    int j = getView().getHeight();
    ae.d("MicroMsg.Sns.AdLandingPageSightVideoComponent", "inScreenHeight %d, height %d", new Object[] { Integer.valueOf(i), Integer.valueOf(j) });
    if ((i == 0) || (j == 0))
    {
      AppMethodBeat.o(96728);
      return;
    }
    this.zXM = i;
    this.gim = j;
    if (i < 0)
    {
      AppMethodBeat.o(96728);
      return;
    }
    ae.d("MicroMsg.Sns.AdLandingPageSightVideoComponent", "appeared handleType %d", new Object[] { Integer.valueOf(this.zWW) });
    if (i >= j * 0.5F)
    {
      if ((this.zWR) && (!this.zWS))
      {
        AppMethodBeat.o(96728);
        return;
      }
      this.zWS = false;
      this.zWR = true;
      if (this.zWW == 6)
      {
        if (this.zXQ)
        {
          this.zWW = 1;
          AppMethodBeat.o(96728);
          return;
        }
        this.zWW = 4;
        AppMethodBeat.o(96728);
        return;
      }
      if (this.zWW == 0)
      {
        if (this.zWP) {
          dZN();
        }
        for (;;)
        {
          this.zWW = 1;
          cbC();
          AppMethodBeat.o(96728);
          return;
          dZP();
        }
      }
      if (this.zWW == 2)
      {
        if (this.zWP) {
          dZN();
        }
        for (;;)
        {
          cbC();
          this.zWW = 1;
          AppMethodBeat.o(96728);
          return;
          dZP();
        }
      }
      if (this.zWW == 3)
      {
        if (this.zWP) {
          dZN();
        }
        for (;;)
        {
          cbC();
          AppMethodBeat.o(96728);
          return;
          dZP();
        }
      }
    }
    else
    {
      this.zWS = false;
      this.zWR = false;
      rM(false);
      if (this.zWW == 1) {
        this.zWW = 2;
      }
      i = this.zWW;
    }
    AppMethodBeat.o(96728);
  }
  
  public final void dZP()
  {
    AppMethodBeat.i(96724);
    super.dZP();
    this.zWH.setImageDrawable(com.tencent.mm.cb.a.l(this.context, 2131690342));
    this.zXI.setMute(false);
    this.zWP = false;
    AppMethodBeat.o(96724);
  }
  
  public final void eaB()
  {
    AppMethodBeat.i(96731);
    super.eaB();
    String str = h.jL("adId", ((u)this.zUP).zQQ);
    rM(false);
    if (o.fB(str))
    {
      this.zXI.aCa(str);
      this.zXI.c(false, 0.0F);
    }
    AppMethodBeat.o(96731);
  }
  
  public final void eaP()
  {
    AppMethodBeat.i(96719);
    u localu = (u)this.zUP;
    if (bu.isNullOrNil(localu.zQR))
    {
      ae.e("MicroMsg.Sns.AdLandingPageSightVideoComponent", "on long video button click without streamVideoUrl!");
      AppMethodBeat.o(96719);
      return;
    }
    if (!(this.context instanceof Activity))
    {
      ae.e("MicroMsg.Sns.AdLandingPageSightVideoComponent", "on long video button click but context not activity!");
      AppMethodBeat.o(96719);
      return;
    }
    ae.v("MicroMsg.Sns.AdLandingPageSightVideoComponent", "on long video button click, jumpto [%s]", new Object[] { localu.zQR });
    Intent localIntent = new Intent();
    if (AdLandingPagesProxy.getInstance().getStreamVideoPlayerConfig() > 0)
    {
      localIntent.setClass(this.context, SnsAdStreamVideoPlayUI.class);
      ae.i("MicroMsg.Sns.AdLandingPageSightVideoComponent", "use new stream video play UI");
    }
    for (;;)
    {
      localIntent.putExtra("KFromTimeLine", true);
      localIntent.putExtra("KMediaId", aj.ej(localu.zQR));
      localIntent.putExtra("KThumUrl", localu.zQQ);
      localIntent.putExtra("KStremVideoUrl", localu.zQR);
      localIntent.putExtra("ForceLandscape", true);
      localIntent.putExtra("ShareBtnHidden", 1);
      localIntent.putExtra("KComponentCid", eaz());
      ((Activity)this.context).startActivityForResult(localIntent, 2004);
      this.zXK += 1;
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
    AppMethodBeat.i(219537);
    boolean bool = this.zXI.isPlaying();
    AppMethodBeat.o(219537);
    return bool;
  }
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(219541);
    Object localObject = new com.tencent.mm.hellhoundlib.b.b();
    ((com.tencent.mm.hellhoundlib.b.b)localObject).bd(paramView);
    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/AdLandingPageSightVideoComponent", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).ahF());
    if (paramView.getId() == 2131307246) {
      ae.i("MicroMsg.Sns.AdLandingPageSightVideoComponent.VideoOptimize", "click full screen btn");
    }
    try
    {
      if ((this.context instanceof SnsAdNativeLandingPagesUI))
      {
        this.zXT += 1;
        this.gKO.removeCallbacks(this.zXR);
        this.zXP.setVisibility(8);
        paramView = (SnsAdNativeLandingPagesUI)this.context;
        b.zYe = (u)this.zUP;
        com.tencent.mm.plugin.sns.model.ad.zAi = eaD();
        localObject = new Intent(paramView, VideoFullScreenActivity.class);
        ((Intent)localObject).putExtra("KComponentVideoType", 0);
        ((Intent)localObject).putExtra("KComponentCid", eaz());
        ((Intent)localObject).putExtra("KComponentCurrentTime", this.zXI.getCurrentPositionMs());
        ((Intent)localObject).putExtra("KComponentTotalTime", this.zXI.getDurationMs());
        ((Intent)localObject).putExtra("KComponentVoiceType", this.zWP);
        ((Intent)localObject).putExtra("KComponentProgressType", this.zXI.isPlaying());
        ((Intent)localObject).putExtra("KComponentVideoSightThumbUrl", ((u)this.zUP).zQQ);
        ((Intent)localObject).putExtra("KComponentStreamVideoUrlPath", ((u)this.zUP).zQP);
        paramView.startActivityForResult((Intent)localObject, 2000);
      }
      for (;;)
      {
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/AdLandingPageSightVideoComponent", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(219541);
        return;
        this.zXO.setVisibility(8);
      }
    }
    catch (Throwable paramView)
    {
      for (;;)
      {
        this.zXO.setVisibility(8);
        ae.e("NonFullOrFullVideoType", paramView.toString());
      }
    }
  }
  
  public final boolean onDoubleTap(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(219543);
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.bd(paramMotionEvent);
    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/AdLandingPageSightVideoComponent", "android/view/GestureDetector$OnDoubleTapListener", "onDoubleTap", "(Landroid/view/MotionEvent;)Z", this, localb.ahF());
    for (;;)
    {
      try
      {
        ae.i("MicroMsg.Sns.AdLandingPageSightVideoComponent.VideoOptimize", "onDoubleTap");
        ao(this.zWL);
        if (this.gxv) {
          this.zXS += 1;
        }
        if (!this.zXI.isPlaying()) {
          continue;
        }
        rM(true);
        this.zWW = 4;
      }
      catch (Throwable paramMotionEvent)
      {
        ae.e("MicroMsg.Sns.AdLandingPageSightVideoComponent.VideoOptimize", paramMotionEvent.toString());
        continue;
        dZQ();
        dZP();
        continue;
      }
      com.tencent.mm.hellhoundlib.a.a.a(false, this, "com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/AdLandingPageSightVideoComponent", "android/view/GestureDetector$OnDoubleTapListener", "onDoubleTap", "(Landroid/view/MotionEvent;)Z");
      AppMethodBeat.o(219543);
      return false;
      if (!this.zWP) {
        continue;
      }
      dZN();
      cbC();
      this.zWW = 3;
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
    AppMethodBeat.i(219545);
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.bd(paramMotionEvent);
    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/AdLandingPageSightVideoComponent", "android/view/GestureDetector$OnGestureListener", "onLongPress", "(Landroid/view/MotionEvent;)V", this, localb.ahF());
    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/AdLandingPageSightVideoComponent", "android/view/GestureDetector$OnGestureListener", "onLongPress", "(Landroid/view/MotionEvent;)V");
    AppMethodBeat.o(219545);
  }
  
  public final boolean onScroll(MotionEvent paramMotionEvent1, MotionEvent paramMotionEvent2, float paramFloat1, float paramFloat2)
  {
    return false;
  }
  
  public final void onShowPress(MotionEvent paramMotionEvent) {}
  
  public final boolean onSingleTapConfirmed(MotionEvent paramMotionEvent)
  {
    bool = true;
    AppMethodBeat.i(219542);
    for (;;)
    {
      try
      {
        ae.i("MicroMsg.Sns.AdLandingPageSightVideoComponent.VideoOptimize", "onSingleTapConfirmed");
        if (!this.gxv) {
          continue;
        }
        if (this.zWG.getVisibility() != 0) {
          continue;
        }
        i = 1;
        if (i == 0) {
          continue;
        }
        this.zWG.setVisibility(4);
        this.zXO.setVisibility(4);
        this.gKO.removeCallbacks(this.zWL);
        if (this.zXb == null) {
          continue;
        }
        paramMotionEvent = this.zXb;
        if (i != 0) {
          continue;
        }
      }
      catch (Throwable paramMotionEvent)
      {
        int i;
        ae.e("MicroMsg.Sns.AdLandingPageSightVideoComponent.VideoOptimize", paramMotionEvent.toString());
        continue;
        bool = false;
        continue;
      }
      paramMotionEvent.rK(bool);
      AppMethodBeat.o(219542);
      return false;
      i = 0;
      continue;
      this.zWG.setVisibility(0);
      this.zXO.setVisibility(0);
      ao(this.zWL);
    }
  }
  
  public final boolean onSingleTapUp(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(219544);
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.bd(paramMotionEvent);
    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/AdLandingPageSightVideoComponent", "android/view/GestureDetector$OnGestureListener", "onSingleTapUp", "(Landroid/view/MotionEvent;)Z", this, localb.ahF());
    com.tencent.mm.hellhoundlib.a.a.a(false, this, "com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/AdLandingPageSightVideoComponent", "android/view/GestureDetector$OnGestureListener", "onSingleTapUp", "(Landroid/view/MotionEvent;)Z");
    AppMethodBeat.o(219544);
    return false;
  }
  
  @SuppressLint({"ClickableViewAccessibility"})
  public final boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(219540);
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.bd(paramView);
    localb.bd(paramMotionEvent);
    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/AdLandingPageSightVideoComponent", "android/view/View$OnTouchListener", "onTouch", "(Landroid/view/View;Landroid/view/MotionEvent;)Z", this, localb.ahF());
    paramView = this.iNw;
    paramMotionEvent = new com.tencent.mm.hellhoundlib.b.a().bc(paramMotionEvent);
    com.tencent.mm.hellhoundlib.a.a.a(paramView, paramMotionEvent.ahE(), "com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/AdLandingPageSightVideoComponent", "onTouch", "(Landroid/view/View;Landroid/view/MotionEvent;)Z", "android/view/GestureDetector_EXEC_", "onTouchEvent", "(Landroid/view/MotionEvent;)Z");
    boolean bool = com.tencent.mm.hellhoundlib.a.a.a(paramView, paramView.onTouchEvent((MotionEvent)paramMotionEvent.mt(0)), "com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/AdLandingPageSightVideoComponent", "onTouch", "(Landroid/view/View;Landroid/view/MotionEvent;)Z", "android/view/GestureDetector_EXEC_", "onTouchEvent", "(Landroid/view/MotionEvent;)Z");
    com.tencent.mm.hellhoundlib.a.a.a(bool, this, "com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/AdLandingPageSightVideoComponent", "android/view/View$OnTouchListener", "onTouch", "(Landroid/view/View;Landroid/view/MotionEvent;)Z");
    AppMethodBeat.o(219540);
    return bool;
  }
  
  final class a
    implements AudioManager.OnAudioFocusChangeListener
  {
    a() {}
    
    public final void onAudioFocusChange(int paramInt)
    {
      AppMethodBeat.i(219532);
      try
      {
        af.Rb(paramInt);
        AppMethodBeat.o(219532);
        return;
      }
      catch (Throwable localThrowable)
      {
        ae.e("MicroMsg.Sns.AdLandingPageSightVideoComponent", "onAudioFocusChanged has something wrong!");
        AppMethodBeat.o(219532);
      }
    }
  }
  
  public static final class b
  {
    public static u zYe;
  }
  
  static final class c
  {
    int clickCount;
    long dCI;
    int zUQ;
    String zYf;
    int zYg;
    long zYh;
    int zYi;
  }
  
  final class d
    implements h.c
  {
    d() {}
    
    public final void eX(boolean paramBoolean)
    {
      AppMethodBeat.i(219533);
      ae.i("MicroMsg.Sns.AdLandingPageSightVideoComponent", "onSeekComplete is called");
      af.A(af.this).sendMessage();
      AppMethodBeat.o(219533);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.af
 * JD-Core Version:    0.7.0.1
 */