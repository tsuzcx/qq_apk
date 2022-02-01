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
import com.tencent.mm.g.a.oi;
import com.tencent.mm.plugin.sns.data.j;
import com.tencent.mm.plugin.sns.model.AdLandingPagesProxy;
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
import com.tencent.mm.pluginsdk.ui.tools.h.c;
import com.tencent.mm.pointers.PString;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.ay;
import com.tencent.mm.sdk.platformtools.bt;
import org.json.JSONException;
import org.json.JSONObject;

public final class ae
  extends com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.a
  implements GestureDetector.OnDoubleTapListener, GestureDetector.OnGestureListener, View.OnClickListener, View.OnTouchListener
{
  public static int zGQ = 999;
  private Context context;
  private ap gIf;
  private View gZU;
  int gfU;
  private boolean guO;
  private GestureDetector iKD;
  private boolean isAutoPlay;
  private String kHA;
  private int length;
  private com.tencent.mm.plugin.sight.decode.ui.b rFm;
  private long wiC;
  private int wji;
  public int yZi;
  public int yZj;
  public int yZk;
  private VideoPlayerSeekBar zFA;
  ImageView zFB;
  private boolean zFC;
  private TextView zFE;
  private Runnable zFF;
  boolean zFJ;
  private boolean zFL;
  private boolean zFM;
  private boolean zFN;
  boolean zFO;
  boolean zFP;
  private volatile int zFQ;
  private int zFR;
  private int zFS;
  private int zFT;
  int zFU;
  private al zFV;
  private View.OnClickListener zFW;
  OfflineVideoView zGA;
  private int zGB;
  private int zGC;
  int zGD;
  int zGE;
  private boolean zGF;
  private ImageView zGG;
  private View zGH;
  private volatile boolean zGI;
  private Runnable zGJ;
  private int zGK;
  private int zGL;
  private c zGM;
  private a zGN;
  private View zGO;
  private View zGP;
  
  public ae(final Context paramContext, u paramu, ViewGroup paramViewGroup)
  {
    super(paramContext, paramu, paramViewGroup);
    AppMethodBeat.i(96717);
    this.wiC = 0L;
    this.zFR = 0;
    this.wji = 0;
    this.zFS = 0;
    this.zGC = 0;
    this.yZi = 0;
    this.yZj = 0;
    this.yZk = 0;
    this.zFU = 0;
    this.zGD = 0;
    this.zFJ = true;
    this.zGE = 0;
    this.gfU = 0;
    this.zFQ = 0;
    this.zFL = false;
    this.zFM = true;
    this.isAutoPlay = false;
    this.zFO = true;
    this.zFP = true;
    this.zFN = false;
    this.zGI = false;
    this.zFV = null;
    this.zFW = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(197998);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/AdLandingPageSightVideoComponent$10", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
        for (;;)
        {
          try
          {
            ad.i("MicroMsg.Sns.AdLandingPageSightVideoComponent.VideoOptimize", "play btn onclick isPlaying[%b]", new Object[] { Boolean.valueOf(ae.this.zGA.isPlaying()) });
            ae.a(ae.this, ae.e(ae.this));
            if (!ae.this.zGA.isPlaying()) {
              continue;
            }
            ae.s(ae.this);
            ae.c(ae.this, 4);
            if (ae.u(ae.this)) {
              ae.v(ae.this);
            }
          }
          catch (Throwable paramAnonymousView)
          {
            ad.e("MicroMsg.Sns.AdLandingPageSightVideoComponent.VideoOptimize", paramAnonymousView.toString());
            continue;
            ae.this.dWo();
            ae.this.dWn();
            continue;
          }
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/AdLandingPageSightVideoComponent$10", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(197998);
          return;
          if (!ae.this.zFJ) {
            continue;
          }
          ae.this.dWl();
          ae.t(ae.this);
          ae.c(ae.this, 3);
        }
      }
    };
    this.rFm = new com.tencent.mm.plugin.sight.decode.ui.b()
    {
      public final void aqD()
      {
        AppMethodBeat.i(197999);
        try
        {
          ae.a(ae.this, ae.e(ae.this));
          if (ae.d(ae.this) != null) {
            ae.d(ae.this).eaf();
          }
          AppMethodBeat.o(197999);
          return;
        }
        catch (Throwable localThrowable)
        {
          ad.e("MicroMsg.Sns.AdLandingPageSightVideoComponent.VideoOptimize", localThrowable.toString());
          AppMethodBeat.o(197999);
        }
      }
      
      public final void nM(int paramAnonymousInt)
      {
        AppMethodBeat.i(198000);
        try
        {
          ad.i("MicroMsg.Sns.AdLandingPageSightVideoComponent.VideoOptimize", "onSeek time ".concat(String.valueOf(paramAnonymousInt)));
          if (ae.this.zFJ) {
            ae.this.dWl();
          }
          for (;;)
          {
            ae.d(ae.this).aC(paramAnonymousInt * 1000, true);
            ae.c(ae.this, 3);
            ae.b(ae.this, true);
            ae.x(ae.this).removeCallbacks(ae.w(ae.this));
            ae.b(ae.this).setVisibility(8);
            AppMethodBeat.o(198000);
            return;
            ae.this.dWn();
          }
          return;
        }
        catch (Throwable localThrowable)
        {
          ad.e("MicroMsg.Sns.AdLandingPageSightVideoComponent.VideoOptimize", localThrowable.toString());
          AppMethodBeat.o(198000);
        }
      }
    };
    this.zFT = 0;
    this.zGK = 0;
    this.zGL = 0;
    this.context = paramContext;
    this.gIf = new ap(Looper.getMainLooper());
    try
    {
      this.iKD = new GestureDetector(this);
      this.zFF = new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(197997);
          ae.a(ae.this);
          AppMethodBeat.o(197997);
        }
      };
      this.zGJ = new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(198004);
          ae.b(ae.this).setVisibility(8);
          AppMethodBeat.o(198004);
        }
      };
      this.zFV = new al()
      {
        public final void rD(boolean paramAnonymousBoolean)
        {
          AppMethodBeat.i(198005);
          try
          {
            Intent localIntent = new Intent("com.tencent.mm.adlanding.video_progressbar_change");
            if (paramAnonymousBoolean) {}
            for (int i = 1;; i = 0)
            {
              localIntent.putExtra("show", i);
              localIntent.putExtra("activity_code", ae.c(ae.this));
              android.support.v4.content.d.U(paramContext).b(localIntent);
              AppMethodBeat.o(198005);
              return;
            }
            return;
          }
          catch (Throwable localThrowable)
          {
            ad.e("MicroMsg.Sns.AdLandingPageSightVideoComponent", localThrowable.toString());
            AppMethodBeat.o(198005);
          }
        }
      };
      AppMethodBeat.o(96717);
      return;
    }
    catch (Throwable paramContext)
    {
      ad.e("MicroMsg.Sns.AdLandingPageSightVideoComponent.VideoOptimize", paramContext.toString());
      AppMethodBeat.o(96717);
    }
  }
  
  private void Qt(final int paramInt)
  {
    AppMethodBeat.i(198023);
    try
    {
      this.gIf.post(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(198019);
          ae.n(ae.this).seek(paramInt);
          ae.b(ae.this, ae.this.zGA.isPlaying());
          AppMethodBeat.o(198019);
        }
      });
      AppMethodBeat.o(198023);
      return;
    }
    catch (Throwable localThrowable)
    {
      ad.e("MicroMsg.Sns.AdLandingPageSightVideoComponent.VideoOptimize", localThrowable.toString());
      AppMethodBeat.o(198023);
    }
  }
  
  private void abandonAudioFocus()
  {
    AppMethodBeat.i(198037);
    try
    {
      if (this.zGN != null)
      {
        AudioManager localAudioManager = (AudioManager)this.context.getSystemService("audio");
        if (localAudioManager != null)
        {
          localAudioManager.abandonAudioFocus(this.zGN);
          this.zGN = null;
        }
      }
      AppMethodBeat.o(198037);
      return;
    }
    catch (Throwable localThrowable)
    {
      ad.e("MicroMsg.Sns.AdLandingPageSightVideoComponent", "abandonAudioFocus has something wrong!");
      AppMethodBeat.o(198037);
    }
  }
  
  private void aq(Runnable paramRunnable)
  {
    AppMethodBeat.i(198027);
    try
    {
      this.gIf.removeCallbacks(paramRunnable);
      this.gIf.postDelayed(paramRunnable, 4000L);
      AppMethodBeat.o(198027);
      return;
    }
    catch (Throwable paramRunnable)
    {
      ad.e("MicroMsg.Sns.AdLandingPageSightVideoComponent.VideoOptimize", paramRunnable.toString());
      AppMethodBeat.o(198027);
    }
  }
  
  public static void azN(String paramString)
  {
    int i = 1;
    AppMethodBeat.i(198026);
    Object localObject = "0";
    for (;;)
    {
      try
      {
        if (com.tencent.mm.vfs.i.fv(paramString))
        {
          String str = "1";
          localObject = str;
          if (com.tencent.mm.vfs.i.deleteFile(paramString))
          {
            localObject = str;
            paramString = ay.iR(aj.getContext());
            com.tencent.mm.plugin.sns.data.i.b(com.tencent.mm.plugin.sns.data.i.zda, (String)localObject, 1, i, "http|".concat(String.valueOf(paramString)));
            AppMethodBeat.o(198026);
            return;
          }
        }
      }
      catch (Throwable paramString)
      {
        ad.e("MicroMsg.Sns.AdLandingPageSightVideoComponent", "delErrorFile exp=" + paramString.toString());
        AppMethodBeat.o(198026);
        return;
      }
      i = 0;
    }
  }
  
  private void can()
  {
    AppMethodBeat.i(96721);
    if (this.zFN)
    {
      ad.i("MicroMsg.Sns.AdLandingPageSightVideoComponent", "last download fail ,try again");
      this.zGA.cxv();
      AppMethodBeat.o(96721);
      return;
    }
    ad.d("MicroMsg.Sns.AdLandingPageSightVideoComponent", "starting play");
    if ((!this.zGF) && (!TextUtils.isEmpty(this.kHA)))
    {
      this.zGA.agT(this.kHA);
      this.zGF = true;
    }
    this.gIf.post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(198001);
        ae.d(ae.this).eag();
        ae.y(ae.this);
        try
        {
          ae.b(ae.this, true);
          ae.x(ae.this).removeCallbacks(ae.w(ae.this));
          ae.b(ae.this).setVisibility(8);
          AppMethodBeat.o(198001);
          return;
        }
        catch (Throwable localThrowable)
        {
          ad.e("MicroMsg.Sns.AdLandingPageSightVideoComponent", localThrowable.toString());
          AppMethodBeat.o(198001);
        }
      }
    });
    this.wiC = System.currentTimeMillis();
    this.wji += 1;
    AppMethodBeat.o(96721);
  }
  
  private boolean dXn()
  {
    AppMethodBeat.i(96720);
    if (!bt.isNullOrNil(((u)this.zDK).zyG))
    {
      Intent localIntent = new Intent();
      localIntent.putExtra("sns_landig_pages_from_source", 14);
      localIntent.putExtra("sns_landig_pages_origin_from_source", dWZ().zAN);
      localIntent.putExtra("sns_landing_pages_ux_info", dWZ().dFy);
      localIntent.putExtra("sns_landing_pages_xml", "");
      localIntent.putExtra("sns_landing_pages_canvasid", ((u)this.zDK).zyG);
      localIntent.putExtra("sns_landing_pages_canvas_ext", ((u)this.zDK).zyH);
      localIntent.putExtra("sns_landing_pages_no_store", ((u)this.zDK).zyI);
      localIntent.putExtra("sns_landing_pages_need_enter_and_exit_animation", true);
      String str3;
      String str1;
      String str2;
      JSONObject localJSONObject;
      if (((this.context instanceof Activity)) && (dWZ().bizId == 2))
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
          localJSONObject.put("cid", ((u)this.zDK).zAg);
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
        this.zGA.getLocationOnScreen((int[])localObject);
        localIntent.putExtra("img_gallery_top", localObject[1]);
        localIntent.putExtra("img_gallery_left", localObject[0]);
        localIntent.putExtra("img_gallery_width", this.zGA.getWidth());
        localIntent.putExtra("img_gallery_height", this.zGA.getHeight());
        com.tencent.mm.bs.d.b(this.context, "sns", ".ui.SnsAdNativeLandingPagesPreviewUI", localIntent);
        AppMethodBeat.o(96720);
        return true;
        localObject = "";
      }
    }
    AppMethodBeat.o(96720);
    return false;
  }
  
  private void rE(boolean paramBoolean)
  {
    AppMethodBeat.i(198022);
    try
    {
      this.zFA.setIsPlay(paramBoolean);
      this.zFA.getPlayBtn().getLayoutParams().width = this.length;
      this.zFA.getPlayBtn().getLayoutParams().height = this.length;
      if (paramBoolean)
      {
        ad.i("MicroMsg.Sns.AdLandingPageSightVideoComponent.VideoOptimize", "startPlay");
        this.zFA.getPlayBtn().setImageDrawable(com.tencent.mm.cc.a.l(this.context, 2131691470));
        AppMethodBeat.o(198022);
        return;
      }
      ad.i("MicroMsg.Sns.AdLandingPageSightVideoComponent.VideoOptimize", "pausePlay");
      this.zFA.getPlayBtn().setImageDrawable(com.tencent.mm.cc.a.l(this.context, 2131691469));
      AppMethodBeat.o(198022);
      return;
    }
    catch (Throwable localThrowable)
    {
      ad.e("MicroMsg.Sns.AdLandingPageSightVideoComponent.VideoOptimize", localThrowable.toString());
      AppMethodBeat.o(198022);
    }
  }
  
  private void rF(final boolean paramBoolean)
  {
    AppMethodBeat.i(198024);
    ad.d("MicroMsg.Sns.AdLandingPageSightVideoComponent", "pause play");
    this.gIf.post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(198002);
        ae.d(ae.this).eaf();
        try
        {
          ae.b(ae.this, false);
          if ((ae.q(ae.this)) && (paramBoolean))
          {
            ae.b(ae.this).setVisibility(0);
            ae.a(ae.this, ae.w(ae.this));
          }
          AppMethodBeat.o(198002);
          return;
        }
        catch (Throwable localThrowable)
        {
          ad.e("MicroMsg.Sns.AdLandingPageSightVideoComponent", localThrowable.toString());
          AppMethodBeat.o(198002);
        }
      }
    });
    if (this.wiC != 0L)
    {
      this.zFR = ((int)(this.zFR + (System.currentTimeMillis() - this.wiC)));
      this.wiC = 0L;
    }
    AppMethodBeat.o(198024);
  }
  
  public final void a(int paramInt1, boolean paramBoolean1, boolean paramBoolean2, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, long paramLong, String paramString)
  {
    AppMethodBeat.i(198034);
    for (;;)
    {
      try
      {
        this.zFQ = 6;
        this.zGI = paramBoolean2;
        this.zGL += 1;
        this.zFT += paramInt2;
        this.zGK += paramInt3;
        this.zFU += paramInt4;
        this.zFS += paramInt5;
        this.wji += paramInt6;
        this.zFR = ((int)(this.zFR + paramLong));
        if (paramBoolean2) {
          this.wiC = System.currentTimeMillis();
        }
        boolean bool = bt.isNullOrNil(paramString);
        if (!bool) {}
        try
        {
          paramString = new JSONObject(paramString);
          if (this.zGM == null) {
            this.zGM = new c();
          }
          c localc = this.zGM;
          localc.zDL += paramString.optInt("exposureCount");
          localc = this.zGM;
          localc.dBD += paramString.optLong("stayTime");
          localc = this.zGM;
          localc.clickCount += paramString.optInt("clickCount");
          paramString = paramString.optJSONObject("btnInfo");
          this.zGM.zGY = paramString.optString("cid");
          localc = this.zGM;
          localc.zGZ += paramString.optInt("exposureCount");
          localc = this.zGM;
          localc.zHa += paramString.optLong("stayTime");
          localc = this.zGM;
          paramInt2 = localc.zHb;
          localc.zHb = (paramString.optInt("clickCount") + paramInt2);
        }
        catch (Throwable paramString)
        {
          this.zGM = null;
          ad.e("MicroMsg.Sns.AdLandingPageSightVideoComponent", paramString.toString());
          continue;
        }
        this.gIf.removeCallbacks(this.zGJ);
        this.zGH.setVisibility(8);
        ad.i("NonFullOrFullVideoType", "currPosSec = " + paramInt1 + ", isPlaying = " + paramBoolean2 + ", bNoVoice = " + paramBoolean1);
        paramInt2 = paramInt1 / 1000;
        if ((paramInt2 >= this.zGB) || (paramInt1 < 0))
        {
          this.zFA.seek(0);
          this.zGA.aC(0, paramBoolean2);
          rE(paramBoolean2);
          if (!paramBoolean1) {
            break;
          }
          dWl();
          AppMethodBeat.o(198034);
          return;
        }
      }
      catch (Throwable paramString)
      {
        ad.e("NonFullOrFullVideoType", paramString.toString());
        AppMethodBeat.o(198034);
        return;
      }
      this.zFA.seek(paramInt2);
      this.zGA.aC(paramInt1, paramBoolean2);
    }
    dWn();
    AppMethodBeat.o(198034);
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
      paramJSONObject.put("sightDuration", this.zGB * 1000);
      paramJSONObject.put("playTimeInterval", this.zFR);
      paramJSONObject.put("playCount", this.wji);
      paramJSONObject.put("playCompletedCount", this.zFS);
      paramJSONObject.put("clickPlayControlCount", this.zFT);
      paramJSONObject.put("doubleClickCount", this.zGK);
      paramJSONObject.put("clickFullscreenBtnCount", this.zGL);
      paramJSONObject.put("clickVoiceControlCount", this.zFU);
      if (this.isAutoPlay) {}
      for (Object localObject = "1";; localObject = "0")
      {
        paramJSONObject.put("isAutoPlay", localObject);
        if (((u)this.zDK).type == 61) {
          paramJSONObject.put("clickSightCount", this.zGD);
        }
        JSONObject localJSONObject;
        if (!this.zFP)
        {
          localObject = ai.ee(((u)this.zDK).zzQ);
          localJSONObject = new JSONObject();
          localJSONObject.put("urlMd5", localObject);
          localJSONObject.put("needDownload", 1);
          paramJSONObject.put("sightUrlInfo", localJSONObject);
        }
        if (!this.zFO)
        {
          localObject = ai.ee(((u)this.zDK).zzR);
          localJSONObject = new JSONObject();
          localJSONObject.put("urlMd5", localObject);
          localJSONObject.put("needDownload", 1);
          paramJSONObject.put("thumbUrlInfo", localJSONObject);
        }
        paramJSONObject.put("streamVideoEnterCount", this.zGC);
        paramJSONObject.put("streamVideoPlayCount", this.yZi);
        paramJSONObject.put("streamVideoPlayCompleteCount", this.yZj);
        paramJSONObject.put("streamVideoTotalPlayTimeInMs", this.yZk);
        if (this.zGM != null)
        {
          localObject = new JSONObject();
          ((JSONObject)localObject).put("cid", this.zGM.zGY);
          ((JSONObject)localObject).put("exposureCount", this.zGM.zGZ);
          ((JSONObject)localObject).put("stayTime", this.zGM.zHa);
          ((JSONObject)localObject).put("clickCount", this.zGM.zHb);
          localJSONObject = new JSONObject();
          localJSONObject.put("exposureCount", this.zGM.zDL);
          localJSONObject.put("stayTime", this.zGM.dBD);
          localJSONObject.put("clickCount", this.zGM.clickCount);
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
      ad.printErrStackTrace("MicroMsg.Sns.AdLandingPageSightVideoComponent", paramJSONObject, "", new Object[0]);
      AppMethodBeat.o(96729);
    }
  }
  
  public final void cxt()
  {
    AppMethodBeat.i(198035);
    rF(false);
    this.zFQ = 4;
    AppMethodBeat.o(198035);
  }
  
  public final void cxu()
  {
    AppMethodBeat.i(198036);
    this.zFQ = 3;
    can();
    AppMethodBeat.o(198036);
  }
  
  public final void dRk()
  {
    AppMethodBeat.i(96718);
    if (!com.tencent.mm.vfs.i.fv(h.jF("adId", ((u)this.zDK).zzR))) {
      this.zFO = false;
    }
    if (!com.tencent.mm.vfs.i.fv(com.tencent.mm.loader.j.b.arU() + "/sns_ad_landingpages/adId_stream_" + ai.ee(((u)this.zDK).zzQ))) {
      this.zFP = false;
    }
    View localView = this.contentView.findViewById(2131304914);
    this.zGO = localView;
    Object localObject1 = (ViewGroup)localView.findViewById(2131304907);
    this.zGA = new OfflineVideoView(this.context);
    this.zGP = ((View)localObject1);
    ((ViewGroup)localObject1).addView(this.zGA, new LinearLayout.LayoutParams(-1, -1));
    int i;
    Object localObject2;
    if (((u)this.zDK).zzW == 0) {
      if ((int)((u)this.zDK).width > 0)
      {
        i = this.ltA;
        localObject2 = new RelativeLayout.LayoutParams(i, (int)(i * ((u)this.zDK).height / ((u)this.zDK).width));
        ((ViewGroup)localObject1).setLayoutParams((ViewGroup.LayoutParams)localObject2);
        localView.setLayoutParams((ViewGroup.LayoutParams)localObject2);
        if (((u)this.zDK).zzY) {
          break label1168;
        }
        ad.e("MicroMsg.Sns.AdLandingPageSightVideoComponent", "fixVideoBlackline, enable=false");
        label255:
        ad.i("MicroMsg.Sns.AdLandingPageSightVideoComponent", "createView, displayType=" + ((u)this.zDK).zzW);
        localObject1 = h.jF("adId", ((u)this.zDK).zzR);
        if (!com.tencent.mm.vfs.i.fv((String)localObject1)) {
          break label1522;
        }
        this.zGA.aAJ((String)localObject1);
      }
    }
    for (;;)
    {
      this.zFE = ((TextView)localView.findViewById(2131299517));
      this.zFE.setText(this.context.getString(2131758104));
      this.gZU = localView.findViewById(2131304920);
      if (this.gZU != null)
      {
        localObject1 = new RelativeLayout.LayoutParams(-1, -1);
        localObject2 = this.gZU.getParent();
        if ((localObject2 instanceof ViewGroup)) {
          ((ViewGroup)localObject2).removeView(this.gZU);
        }
        ((ViewGroup)localView).addView(this.gZU, (ViewGroup.LayoutParams)localObject1);
      }
      this.zFB = ((ImageView)localView.findViewById(2131304921));
      this.zFB.setVisibility(0);
      this.zFB.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(96714);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bd(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/AdLandingPageSightVideoComponent$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
          paramAnonymousView = ae.this;
          paramAnonymousView.zFU += 1;
          ae.a(ae.this, ae.e(ae.this));
          if (ae.this.zFJ)
          {
            ae.this.dWo();
            ae.this.dWn();
          }
          for (;;)
          {
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/AdLandingPageSightVideoComponent$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(96714);
            return;
            ae.this.dWl();
          }
        }
      });
      try
      {
        localObject1 = this.zFB.getParent();
        if ((localObject1 instanceof ViewGroup)) {
          ((ViewGroup)localObject1).removeView(this.zFB);
        }
        localObject1 = (RelativeLayout.LayoutParams)this.zFB.getLayoutParams();
        ((RelativeLayout.LayoutParams)localObject1).bottomMargin = com.tencent.mm.cc.a.fromDPToPix(this.context, 8);
        ((RelativeLayout.LayoutParams)localObject1).rightMargin = com.tencent.mm.cc.a.fromDPToPix(this.context, 10);
        ((ViewGroup)localView).addView(this.zFB, (ViewGroup.LayoutParams)localObject1);
        ad.i("MicroMsg.Sns.AdLandingPageSightVideoComponent.VideoOptimize", "init voiceTypeBtn and visible");
      }
      catch (Throwable localThrowable2)
      {
        for (;;)
        {
          ad.e("MicroMsg.Sns.AdLandingPageSightVideoComponent.VideoOptimize", localThrowable2.toString());
          continue;
          i = 0;
        }
      }
      this.zGA.setVideoCallback(new OfflineVideoView.a()
      {
        public final boolean a(PString paramAnonymousPString)
        {
          AppMethodBeat.i(198013);
          final long l = System.currentTimeMillis();
          final String str1 = ae.f(ae.this).zzQ;
          final String str2 = h.jG("adId", str1);
          if (com.tencent.mm.vfs.i.fv(str2))
          {
            paramAnonymousPString.value = str2;
            ae.g(ae.this);
            AppMethodBeat.o(198013);
            return true;
          }
          if (!ae.f(ae.this).zzZ) {
            h.d("adId", str1, false, 62, new f.a()
            {
              public final void axG(String paramAnonymous2String)
              {
                AppMethodBeat.i(198008);
                ad.i("MicroMsg.Sns.AdLandingPageSightVideoComponent", "downloadSightForAdLandingPages succ, video view height " + ae.this.contentView.getHeight() + ", player height " + ae.d(ae.this).getHeight() + ", timeCost=" + (System.currentTimeMillis() - l));
                ae.a(ae.this, false);
                ae.a(ae.this, paramAnonymous2String);
                ae.d(ae.this).agT(paramAnonymous2String);
                ae.g(ae.this);
                AppMethodBeat.o(198008);
              }
              
              public final void dRW() {}
              
              public final void dRX()
              {
                AppMethodBeat.i(198007);
                ad.e("MicroMsg.Sns.AdLandingPageSightVideoComponent", "downloadSightForAdLandingPages fail:" + str1);
                ae.a(ae.this, true);
                ae.azN(str2);
                AppMethodBeat.o(198007);
              }
            });
          }
          for (;;)
          {
            AppMethodBeat.o(198013);
            return false;
            h.b("adId", str1, new f.a()
            {
              public final void axG(String paramAnonymous2String)
              {
                AppMethodBeat.i(198010);
                ad.i("MicroMsg.Sns.AdLandingPageSightVideoComponent", "downloadSightForAdLandingPagesByCdn succ, video view height " + ae.this.contentView.getHeight() + ", player height " + ae.d(ae.this).getHeight() + ", timeCost=" + (System.currentTimeMillis() - l));
                ae.a(ae.this, false);
                ae.a(ae.this, paramAnonymous2String);
                ae.d(ae.this).agT(paramAnonymous2String);
                ae.g(ae.this);
                AppMethodBeat.o(198010);
              }
              
              public final void dRW() {}
              
              public final void dRX()
              {
                AppMethodBeat.i(198009);
                ad.e("MicroMsg.Sns.AdLandingPageSightVideoComponent", "downloadSightForAdLandingPagesByCdn fail:" + str1);
                ae.a(ae.this, true);
                AppMethodBeat.o(198009);
              }
            });
          }
        }
        
        public final void onCompletion()
        {
          AppMethodBeat.i(198014);
          aq.f(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(198011);
              if ((ae.f(ae.this).zzX != null) && (!ae.h(ae.this)))
              {
                int i = ae.d(ae.this).getDurationMs();
                int j = ae.f(ae.this).zzX.zAT;
                ad.i("MicroMsg.Sns.AdLandingPageSightVideoComponent", "OpenSnsAdFloatPageEvent, onCompletion totalMs=" + i + ", floatStartTime=" + j + ", hasShowFloat=" + ae.h(ae.this));
                if (i < j)
                {
                  ae.i(ae.this);
                  oi localoi = new oi();
                  localoi.dCj.dCk = ae.f(ae.this).zzX.dCk;
                  com.tencent.mm.sdk.b.a.IbL.l(localoi);
                }
              }
              AppMethodBeat.o(198011);
            }
          });
          ae.j(ae.this);
          ae.k(ae.this).yXA = true;
          ae.l(ae.this);
          AppMethodBeat.o(198014);
        }
        
        public final void onStart(int paramAnonymousInt)
        {
          AppMethodBeat.i(198015);
          ae.m(ae.this);
          ae.a(ae.this, paramAnonymousInt);
          ae.this.zFB.setVisibility(0);
          try
          {
            if (ae.n(ae.this).getVideoTotalTime() != paramAnonymousInt) {
              ae.n(ae.this).setVideoTotalTime(ae.o(ae.this));
            }
            ad.i("MicroMsg.Sns.AdLandingPageSightVideoComponent.VideoOptimize", "onStart");
            AppMethodBeat.o(198015);
            return;
          }
          catch (Throwable localThrowable)
          {
            ad.i("MicroMsg.Sns.AdLandingPageSightVideoComponent.VideoOptimize", localThrowable.toString());
            AppMethodBeat.o(198015);
          }
        }
        
        public final void tt(int paramAnonymousInt)
        {
          AppMethodBeat.i(198016);
          ae.p(ae.this).sendMessage();
          aq.f(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(198012);
              ad.d("MicroMsg.Sns.AdLandingPageSightVideoComponent", "play time " + this.yUf + " video time " + ae.o(ae.this));
              ae.b(ae.this, this.yUf);
              if ((ae.f(ae.this).zzX != null) && (!ae.h(ae.this)))
              {
                int i = ae.f(ae.this).zzX.zAT / 1000;
                ad.i("MicroMsg.Sns.AdLandingPageSightVideoComponent", "OpenSnsAdFloatPageEvent, updateTime seconds=" + this.yUf + ", floatSeconds=" + i + ", hasShowFloat=" + ae.h(ae.this));
                if (this.yUf >= i)
                {
                  ae.i(ae.this);
                  oi localoi = new oi();
                  localoi.dCj.dCk = ae.f(ae.this).zzX.dCk;
                  com.tencent.mm.sdk.b.a.IbL.l(localoi);
                }
              }
              AppMethodBeat.o(198012);
            }
          });
          AppMethodBeat.o(198016);
        }
      });
      this.zGA.setOnSeekCompleteCallback(new d());
      this.zFB.setVisibility(8);
      this.zGA.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(198017);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bd(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/AdLandingPageSightVideoComponent$7", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
          if (ae.q(ae.this))
          {
            paramAnonymousView = ae.this;
            paramAnonymousView.zGD += 1;
            if (ae.r(ae.this))
            {
              com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/AdLandingPageSightVideoComponent$7", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
              AppMethodBeat.o(198017);
              return;
            }
          }
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/AdLandingPageSightVideoComponent$7", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(198017);
        }
      });
      localObject1 = (u)this.zDK;
      if ((((u)localObject1).subType != 1) || (((u)localObject1).zzT.length() <= 0) || (((u)localObject1).zzS.length() <= 0)) {
        break label1568;
      }
      i = 1;
      if (i != 0)
      {
        localObject1 = this.contentView.findViewById(2131304908);
        ((View)localObject1).setVisibility(0);
        localObject2 = (Button)((View)localObject1).findViewById(2131304909);
        ((Button)localObject2).setTextColor(((u)this.zDK).zzU);
        ((Button)localObject2).setText(((u)this.zDK).zzT);
        ((Button)localObject2).setOnClickListener(new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            AppMethodBeat.i(198018);
            com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
            localb.bd(paramAnonymousView);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/AdLandingPageSightVideoComponent$8", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
            ae.this.dXm();
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/AdLandingPageSightVideoComponent$8", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(198018);
          }
        });
        ((View)localObject1).findViewById(2131304910).setBackgroundColor(((u)this.zDK).zzV);
      }
      try
      {
        this.length = com.tencent.mm.cc.a.fromDPToPix(this.context, 32);
        this.zGA.setOnTouchListener(this);
        this.zGG = ((ImageView)localView.findViewById(2131307246));
        localObject1 = this.zGG.getParent();
        if ((localObject1 instanceof ViewGroup)) {
          ((ViewGroup)localObject1).removeView(this.zGG);
        }
        localObject1 = (RelativeLayout.LayoutParams)this.zGG.getLayoutParams();
        ((RelativeLayout.LayoutParams)localObject1).bottomMargin = com.tencent.mm.cc.a.fromDPToPix(this.context, 8);
        ((RelativeLayout.LayoutParams)localObject1).rightMargin = com.tencent.mm.cc.a.fromDPToPix(this.context, 10);
        ((ViewGroup)localView).addView(this.zGG, (ViewGroup.LayoutParams)localObject1);
        this.zGG.setOnClickListener(this);
        this.zGG.setVisibility(8);
        ad.i("MicroMsg.Sns.AdLandingPageSightVideoComponent.VideoOptimize", "init fullScreenBtn and visible");
      }
      catch (Throwable localThrowable3)
      {
        for (;;)
        {
          label1097:
          int j;
          label1168:
          label1522:
          ad.e("MicroMsg.Sns.AdLandingPageSightVideoComponent.VideoOptimize", localThrowable3.toString());
          continue;
          boolean bool = false;
        }
      }
      try
      {
        this.zFA = new VideoPlayerSeekBar(this.context);
        localObject1 = this.zFA.getParent();
        if ((localObject1 instanceof ViewGroup)) {
          ((ViewGroup)localObject1).removeView(this.zFA);
        }
        localObject1 = new RelativeLayout.LayoutParams(this.zGP.getLayoutParams().width - com.tencent.mm.cc.a.fromDPToPix(this.context, 75), -2);
        ((RelativeLayout.LayoutParams)localObject1).addRule(12);
        ((RelativeLayout.LayoutParams)localObject1).bottomMargin = com.tencent.mm.cc.a.fromDPToPix(this.context, 3);
        this.zFA.setLayoutParams((ViewGroup.LayoutParams)localObject1);
        ((ViewGroup)this.contentView.findViewById(2131298770)).addView(this.zFA, (ViewGroup.LayoutParams)localObject1);
        Qt(0);
        this.zFA.setOnPlayButtonClickListener(this.zFW);
        this.zFA.setIplaySeekCallback(this.rFm);
        this.zFA.setVisibility(4);
        if (this.zFV != null)
        {
          localObject1 = this.zFV;
          if (this.zFA.getVisibility() == 0)
          {
            bool = true;
            ((al)localObject1).rD(bool);
          }
        }
        else
        {
          ad.i("MicroMsg.Sns.AdLandingPageSightVideoComponent.VideoOptimize", "init progressBar and visible");
        }
      }
      catch (Throwable localThrowable4)
      {
        ad.e("MicroMsg.Sns.AdLandingPageSightVideoComponent.VideoOptimize", localThrowable4.toString());
        break label1097;
      }
      try
      {
        this.zGH = localView.findViewById(2131307220);
        this.zGH.setVisibility(8);
        AppMethodBeat.o(96718);
        return;
      }
      catch (Throwable localThrowable1)
      {
        ad.e("MicroMsg.Sns.AdLandingPageSightVideoComponent.VideoOptimize", localThrowable1.toString());
        AppMethodBeat.o(96718);
      }
      ((ViewGroup)localObject1).setLayoutParams(new RelativeLayout.LayoutParams(this.ltA, this.ltB));
      localView.setLayoutParams(new RelativeLayout.LayoutParams(this.ltA, this.ltB));
      break;
      localObject1 = this.zGA.getInnerVideoView();
      if ((localObject1 instanceof VideoPlayerTextureView))
      {
        ((View)localObject1).addOnLayoutChangeListener(new View.OnLayoutChangeListener()
        {
          public final void onLayoutChange(View paramAnonymousView, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3, int paramAnonymousInt4, int paramAnonymousInt5, int paramAnonymousInt6, int paramAnonymousInt7, int paramAnonymousInt8)
          {
            AppMethodBeat.i(198003);
            try
            {
              paramAnonymousInt1 = paramAnonymousView.getHeight();
              paramAnonymousInt2 = paramAnonymousView.getWidth();
              paramAnonymousInt3 = ae.z(ae.this).getWidth();
              paramAnonymousInt4 = ae.z(ae.this).getHeight();
              if ((paramAnonymousInt2 <= 1) || (paramAnonymousInt1 <= 1) || (paramAnonymousInt3 == 0) || (paramAnonymousInt4 == 0))
              {
                AppMethodBeat.o(198003);
                return;
              }
              ad.i("MicroMsg.Sns.AdLandingPageSightVideoComponent", "onLayoutChange, video.w=" + paramAnonymousView.getWidth() + ", h=" + paramAnonymousView.getHeight() + ", container.w=" + paramAnonymousInt3 + ", h=" + paramAnonymousInt4 + ", container.padding=" + j.eS(ae.z(ae.this)));
              if (paramAnonymousInt1 == paramAnonymousInt4)
              {
                AppMethodBeat.o(198003);
                return;
              }
              if ((paramAnonymousInt1 >= paramAnonymousInt2) && (paramAnonymousInt4 >= paramAnonymousInt3) && (Math.abs(paramAnonymousInt1 - paramAnonymousInt4) < 2))
              {
                paramAnonymousView = ae.z(ae.this).getLayoutParams();
                paramAnonymousView.height = paramAnonymousInt1;
                ae.z(ae.this).setLayoutParams(paramAnonymousView);
                ad.i("MicroMsg.Sns.AdLandingPageSightVideoComponent", "onLayoutChange, reset VideoContainer.height");
              }
              AppMethodBeat.o(198003);
              return;
            }
            catch (Exception paramAnonymousView)
            {
              ad.e("MicroMsg.Sns.AdLandingPageSightVideoComponent", "onLayoutChange, exp=" + paramAnonymousView.toString());
              AppMethodBeat.o(198003);
            }
          }
        });
        break label255;
      }
      ad.e("MicroMsg.Sns.AdLandingPageSightVideoComponent", "onLayoutChange, innerVideoView=" + localObject1 + ", displayType=" + ((u)this.zDK).zzW);
      break label255;
      if (((u)this.zDK).zzW == 1)
      {
        if (((u)this.zDK).width / this.ltA > ((u)this.zDK).height / this.ltB)
        {
          j = this.ltA;
          i = (int)(j * ((u)this.zDK).height / ((u)this.zDK).width) + 1;
        }
        for (;;)
        {
          localObject2 = new RelativeLayout.LayoutParams(j, i);
          ((RelativeLayout.LayoutParams)localObject2).leftMargin = ((this.ltA - j) / 2);
          ((RelativeLayout.LayoutParams)localObject2).rightMargin = ((RelativeLayout.LayoutParams)localObject2).leftMargin;
          ((RelativeLayout.LayoutParams)localObject2).topMargin = ((this.ltB - i) / 2);
          ((RelativeLayout.LayoutParams)localObject2).bottomMargin = ((RelativeLayout.LayoutParams)localObject2).topMargin;
          ((ViewGroup)localObject1).setLayoutParams((ViewGroup.LayoutParams)localObject2);
          localView.setLayoutParams(new RelativeLayout.LayoutParams(this.ltA, this.ltB));
          break;
          i = this.ltB;
          j = (int)(i * ((u)this.zDK).width / ((u)this.zDK).height) + 1;
        }
      }
      if (((u)this.zDK).zzW != 2) {
        break label255;
      }
      localObject2 = new RelativeLayout.LayoutParams((int)((u)this.zDK).width, (int)((u)this.zDK).height);
      ((ViewGroup)localObject1).setLayoutParams((ViewGroup.LayoutParams)localObject2);
      localView.setLayoutParams(new RelativeLayout.LayoutParams((RelativeLayout.LayoutParams)localObject2));
      break label255;
      h.c("adId", ((u)this.zDK).zzR, false, 1000000001, new f.a()
      {
        public final void axG(String paramAnonymousString)
        {
          AppMethodBeat.i(198006);
          ae.d(ae.this).aAJ(paramAnonymousString);
          AppMethodBeat.o(198006);
        }
        
        public final void dRW() {}
        
        public final void dRX() {}
      });
    }
    label1568:
  }
  
  protected final void dRl()
  {
    AppMethodBeat.i(96730);
    ad.i("MicroMsg.Sns.AdLandingPageSightVideoComponent", getClass().getName() + "not support update now");
    AppMethodBeat.o(96730);
  }
  
  public final void dRm()
  {
    AppMethodBeat.i(96725);
    super.dRm();
    AppMethodBeat.o(96725);
  }
  
  public final void dRn()
  {
    AppMethodBeat.i(96726);
    super.dRn();
    abandonAudioFocus();
    rF(false);
    if ((!this.zFL) && (!this.zFM))
    {
      AppMethodBeat.o(96726);
      return;
    }
    this.zFM = false;
    this.zFL = false;
    if (this.zFQ == 1) {
      this.zFQ = 2;
    }
    int i = this.zFQ;
    ad.d("MicroMsg.Sns.AdLandingPageSightVideoComponent", "disappear handleType %d", new Object[] { Integer.valueOf(this.zFQ) });
    AppMethodBeat.o(96726);
  }
  
  public final void dRo()
  {
    AppMethodBeat.i(96727);
    super.dRo();
    try
    {
      this.gIf.removeCallbacks(this.zFF);
      this.gIf.removeCallbacks(this.zGJ);
      abandonAudioFocus();
      this.zGA.onDestroy();
      AppMethodBeat.o(96727);
      return;
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        ad.e("MicroMsg.Sns.AdLandingPageSightVideoComponent.VideoOptimize", localThrowable.toString());
      }
    }
  }
  
  public final void dWX()
  {
    AppMethodBeat.i(96731);
    super.dWX();
    String str = h.jF("adId", ((u)this.zDK).zzR);
    rF(false);
    if (com.tencent.mm.vfs.i.fv(str))
    {
      this.zGA.aAJ(str);
      this.zGA.c(false, 0.0F);
    }
    AppMethodBeat.o(96731);
  }
  
  public final void dWl()
  {
    AppMethodBeat.i(96723);
    super.dWl();
    this.zFB.setImageDrawable(com.tencent.mm.cc.a.l(this.context, 2131690341));
    this.zGA.setMute(true);
    this.zFJ = true;
    AppMethodBeat.o(96723);
  }
  
  public final void dWm()
  {
    AppMethodBeat.i(96728);
    super.dWm();
    int i = dWT();
    int j = getView().getHeight();
    ad.d("MicroMsg.Sns.AdLandingPageSightVideoComponent", "inScreenHeight %d, height %d", new Object[] { Integer.valueOf(i), Integer.valueOf(j) });
    if ((i == 0) || (j == 0))
    {
      AppMethodBeat.o(96728);
      return;
    }
    this.zGE = i;
    this.gfU = j;
    if (i < 0)
    {
      AppMethodBeat.o(96728);
      return;
    }
    ad.d("MicroMsg.Sns.AdLandingPageSightVideoComponent", "appeared handleType %d", new Object[] { Integer.valueOf(this.zFQ) });
    if (i >= j * 0.5F)
    {
      if ((this.zFL) && (!this.zFM))
      {
        AppMethodBeat.o(96728);
        return;
      }
      this.zFM = false;
      this.zFL = true;
      if (this.zFQ == 6)
      {
        if (this.zGI)
        {
          this.zFQ = 1;
          AppMethodBeat.o(96728);
          return;
        }
        this.zFQ = 4;
        AppMethodBeat.o(96728);
        return;
      }
      if (this.zFQ == 0)
      {
        if (this.zFJ) {
          dWl();
        }
        for (;;)
        {
          this.zFQ = 1;
          can();
          AppMethodBeat.o(96728);
          return;
          dWn();
        }
      }
      if (this.zFQ == 2)
      {
        if (this.zFJ) {
          dWl();
        }
        for (;;)
        {
          can();
          this.zFQ = 1;
          AppMethodBeat.o(96728);
          return;
          dWn();
        }
      }
      if (this.zFQ == 3)
      {
        if (this.zFJ) {
          dWl();
        }
        for (;;)
        {
          can();
          AppMethodBeat.o(96728);
          return;
          dWn();
        }
      }
    }
    else
    {
      this.zFM = false;
      this.zFL = false;
      rF(false);
      if (this.zFQ == 1) {
        this.zFQ = 2;
      }
      i = this.zFQ;
    }
    AppMethodBeat.o(96728);
  }
  
  public final void dWn()
  {
    AppMethodBeat.i(96724);
    super.dWn();
    this.zFB.setImageDrawable(com.tencent.mm.cc.a.l(this.context, 2131690342));
    this.zGA.setMute(false);
    this.zFJ = false;
    AppMethodBeat.o(96724);
  }
  
  public final void dXm()
  {
    AppMethodBeat.i(96719);
    u localu = (u)this.zDK;
    if (bt.isNullOrNil(localu.zzS))
    {
      ad.e("MicroMsg.Sns.AdLandingPageSightVideoComponent", "on long video button click without streamVideoUrl!");
      AppMethodBeat.o(96719);
      return;
    }
    if (!(this.context instanceof Activity))
    {
      ad.e("MicroMsg.Sns.AdLandingPageSightVideoComponent", "on long video button click but context not activity!");
      AppMethodBeat.o(96719);
      return;
    }
    ad.v("MicroMsg.Sns.AdLandingPageSightVideoComponent", "on long video button click, jumpto [%s]", new Object[] { localu.zzS });
    Intent localIntent = new Intent();
    if (AdLandingPagesProxy.getInstance().getStreamVideoPlayerConfig() > 0)
    {
      localIntent.setClass(this.context, SnsAdStreamVideoPlayUI.class);
      ad.i("MicroMsg.Sns.AdLandingPageSightVideoComponent", "use new stream video play UI");
    }
    for (;;)
    {
      localIntent.putExtra("KFromTimeLine", true);
      localIntent.putExtra("KMediaId", ai.ee(localu.zzS));
      localIntent.putExtra("KThumUrl", localu.zzR);
      localIntent.putExtra("KStremVideoUrl", localu.zzS);
      localIntent.putExtra("ForceLandscape", true);
      localIntent.putExtra("ShareBtnHidden", 1);
      localIntent.putExtra("KComponentCid", dWV());
      ((Activity)this.context).startActivityForResult(localIntent, zGQ);
      this.zGC += 1;
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
    AppMethodBeat.i(198025);
    boolean bool = this.zGA.isPlaying();
    AppMethodBeat.o(198025);
    return bool;
  }
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(198029);
    Object localObject = new com.tencent.mm.hellhoundlib.b.b();
    ((com.tencent.mm.hellhoundlib.b.b)localObject).bd(paramView);
    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/AdLandingPageSightVideoComponent", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).ahq());
    if (paramView.getId() == 2131307246) {
      ad.i("MicroMsg.Sns.AdLandingPageSightVideoComponent.VideoOptimize", "click full screen btn");
    }
    try
    {
      if ((this.context instanceof SnsAdNativeLandingPagesUI))
      {
        this.zGL += 1;
        this.gIf.removeCallbacks(this.zGJ);
        this.zGH.setVisibility(8);
        paramView = (SnsAdNativeLandingPagesUI)this.context;
        b.zGX = (u)this.zDK;
        com.tencent.mm.plugin.sns.model.ac.ziT = dWZ();
        localObject = new Intent(paramView, VideoFullScreenActivity.class);
        ((Intent)localObject).putExtra("KComponentVideoType", 0);
        ((Intent)localObject).putExtra("KComponentCid", dWV());
        ((Intent)localObject).putExtra("KComponentCurrentTime", this.zGA.getCurrentPositionMs());
        ((Intent)localObject).putExtra("KComponentTotalTime", this.zGA.getDurationMs());
        ((Intent)localObject).putExtra("KComponentVoiceType", this.zFJ);
        ((Intent)localObject).putExtra("KComponentProgressType", this.zGA.isPlaying());
        ((Intent)localObject).putExtra("KComponentVideoSightThumbUrl", ((u)this.zDK).zzR);
        ((Intent)localObject).putExtra("KComponentStreamVideoUrlPath", ((u)this.zDK).zzQ);
        paramView.startActivityForResult((Intent)localObject, SnsAdNativeLandingPagesUI.zYt);
      }
      for (;;)
      {
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/AdLandingPageSightVideoComponent", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(198029);
        return;
        this.zGG.setVisibility(8);
      }
    }
    catch (Throwable paramView)
    {
      for (;;)
      {
        this.zGG.setVisibility(8);
        ad.e("NonFullOrFullVideoType", paramView.toString());
      }
    }
  }
  
  public final boolean onDoubleTap(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(198031);
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.bd(paramMotionEvent);
    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/AdLandingPageSightVideoComponent", "android/view/GestureDetector$OnDoubleTapListener", "onDoubleTap", "(Landroid/view/MotionEvent;)Z", this, localb.ahq());
    for (;;)
    {
      try
      {
        ad.i("MicroMsg.Sns.AdLandingPageSightVideoComponent.VideoOptimize", "onDoubleTap");
        aq(this.zFF);
        if (this.guO) {
          this.zGK += 1;
        }
        if (!this.zGA.isPlaying()) {
          continue;
        }
        rF(true);
        this.zFQ = 4;
      }
      catch (Throwable paramMotionEvent)
      {
        ad.e("MicroMsg.Sns.AdLandingPageSightVideoComponent.VideoOptimize", paramMotionEvent.toString());
        continue;
        dWo();
        dWn();
        continue;
      }
      com.tencent.mm.hellhoundlib.a.a.a(false, this, "com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/AdLandingPageSightVideoComponent", "android/view/GestureDetector$OnDoubleTapListener", "onDoubleTap", "(Landroid/view/MotionEvent;)Z");
      AppMethodBeat.o(198031);
      return false;
      if (!this.zFJ) {
        continue;
      }
      dWl();
      can();
      this.zFQ = 3;
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
    AppMethodBeat.i(198033);
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.bd(paramMotionEvent);
    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/AdLandingPageSightVideoComponent", "android/view/GestureDetector$OnGestureListener", "onLongPress", "(Landroid/view/MotionEvent;)V", this, localb.ahq());
    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/AdLandingPageSightVideoComponent", "android/view/GestureDetector$OnGestureListener", "onLongPress", "(Landroid/view/MotionEvent;)V");
    AppMethodBeat.o(198033);
  }
  
  public final boolean onScroll(MotionEvent paramMotionEvent1, MotionEvent paramMotionEvent2, float paramFloat1, float paramFloat2)
  {
    return false;
  }
  
  public final void onShowPress(MotionEvent paramMotionEvent) {}
  
  public final boolean onSingleTapConfirmed(MotionEvent paramMotionEvent)
  {
    bool = true;
    AppMethodBeat.i(198030);
    for (;;)
    {
      try
      {
        ad.i("MicroMsg.Sns.AdLandingPageSightVideoComponent.VideoOptimize", "onSingleTapConfirmed");
        if (!this.guO) {
          continue;
        }
        if (this.zFA.getVisibility() != 0) {
          continue;
        }
        i = 1;
        if (i == 0) {
          continue;
        }
        this.zFA.setVisibility(4);
        this.zGG.setVisibility(4);
        this.gIf.removeCallbacks(this.zFF);
        if (this.zFV == null) {
          continue;
        }
        paramMotionEvent = this.zFV;
        if (i != 0) {
          continue;
        }
      }
      catch (Throwable paramMotionEvent)
      {
        int i;
        ad.e("MicroMsg.Sns.AdLandingPageSightVideoComponent.VideoOptimize", paramMotionEvent.toString());
        continue;
        bool = false;
        continue;
      }
      paramMotionEvent.rD(bool);
      AppMethodBeat.o(198030);
      return false;
      i = 0;
      continue;
      this.zFA.setVisibility(0);
      this.zGG.setVisibility(0);
      aq(this.zFF);
    }
  }
  
  public final boolean onSingleTapUp(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(198032);
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.bd(paramMotionEvent);
    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/AdLandingPageSightVideoComponent", "android/view/GestureDetector$OnGestureListener", "onSingleTapUp", "(Landroid/view/MotionEvent;)Z", this, localb.ahq());
    com.tencent.mm.hellhoundlib.a.a.a(false, this, "com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/AdLandingPageSightVideoComponent", "android/view/GestureDetector$OnGestureListener", "onSingleTapUp", "(Landroid/view/MotionEvent;)Z");
    AppMethodBeat.o(198032);
    return false;
  }
  
  @SuppressLint({"ClickableViewAccessibility"})
  public final boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(198028);
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.bd(paramView);
    localb.bd(paramMotionEvent);
    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/AdLandingPageSightVideoComponent", "android/view/View$OnTouchListener", "onTouch", "(Landroid/view/View;Landroid/view/MotionEvent;)Z", this, localb.ahq());
    paramView = this.iKD;
    paramMotionEvent = new com.tencent.mm.hellhoundlib.b.a().bc(paramMotionEvent);
    com.tencent.mm.hellhoundlib.a.a.a(paramView, paramMotionEvent.ahp(), "com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/AdLandingPageSightVideoComponent", "onTouch", "(Landroid/view/View;Landroid/view/MotionEvent;)Z", "android/view/GestureDetector_EXEC_", "onTouchEvent", "(Landroid/view/MotionEvent;)Z");
    boolean bool = com.tencent.mm.hellhoundlib.a.a.a(paramView, paramView.onTouchEvent((MotionEvent)paramMotionEvent.mq(0)), "com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/AdLandingPageSightVideoComponent", "onTouch", "(Landroid/view/View;Landroid/view/MotionEvent;)Z", "android/view/GestureDetector_EXEC_", "onTouchEvent", "(Landroid/view/MotionEvent;)Z");
    com.tencent.mm.hellhoundlib.a.a.a(bool, this, "com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/AdLandingPageSightVideoComponent", "android/view/View$OnTouchListener", "onTouch", "(Landroid/view/View;Landroid/view/MotionEvent;)Z");
    AppMethodBeat.o(198028);
    return bool;
  }
  
  final class a
    implements AudioManager.OnAudioFocusChangeListener
  {
    a() {}
    
    public final void onAudioFocusChange(int paramInt)
    {
      AppMethodBeat.i(198020);
      try
      {
        ae.Qu(paramInt);
        AppMethodBeat.o(198020);
        return;
      }
      catch (Throwable localThrowable)
      {
        ad.e("MicroMsg.Sns.AdLandingPageSightVideoComponent", "onAudioFocusChanged has something wrong!");
        AppMethodBeat.o(198020);
      }
    }
  }
  
  public static final class b
  {
    public static u zGX;
  }
  
  static final class c
  {
    int clickCount;
    long dBD;
    int zDL;
    String zGY;
    int zGZ;
    long zHa;
    int zHb;
  }
  
  final class d
    implements h.c
  {
    d() {}
    
    public final void eU(boolean paramBoolean)
    {
      AppMethodBeat.i(198021);
      ad.i("MicroMsg.Sns.AdLandingPageSightVideoComponent", "onSeekComplete is called");
      ae.A(ae.this).sendMessage();
      AppMethodBeat.o(198021);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.ae
 * JD-Core Version:    0.7.0.1
 */