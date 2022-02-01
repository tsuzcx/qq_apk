package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.media.AudioManager;
import android.media.AudioManager.OnAudioFocusChangeListener;
import android.os.Looper;
import android.support.v4.content.d;
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
import com.tencent.mm.br.c;
import com.tencent.mm.g.a.pb;
import com.tencent.mm.plugin.sns.data.j;
import com.tencent.mm.plugin.sns.data.k;
import com.tencent.mm.plugin.sns.model.AdLandingPagesProxy;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.ai;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.v;
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
import com.tencent.mm.pluginsdk.ui.tools.j.c;
import com.tencent.mm.pointers.PString;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MD5Util;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.NetStatusUtil;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.vfs.s;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

public final class ah
  extends com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.a
  implements GestureDetector.OnDoubleTapListener, GestureDetector.OnGestureListener, View.OnClickListener, View.OnTouchListener
{
  private long AhP;
  private int Aiv;
  public int DvS;
  public int DvT;
  public int DvU;
  private int Dzs;
  private VideoPlayerSeekBar EeP;
  ImageView EeQ;
  private boolean EeR;
  private TextView EeT;
  private Runnable EeU;
  boolean EeY;
  OfflineVideoView EfZ;
  private boolean Efa;
  private boolean Efb;
  private boolean Efc;
  boolean Efd;
  boolean Efe;
  private volatile int Eff;
  private int Efg;
  private int Efh;
  private int Efi;
  int Efj;
  private ao Efk;
  private View.OnClickListener Efl;
  private int Ega;
  int Egb;
  int Egc;
  private ImageView Egd;
  private View Ege;
  private volatile boolean Egf;
  private Runnable Egg;
  private int Egh;
  private int Egi;
  private c Egj;
  private long Egk;
  private a Egl;
  public boolean Egm;
  private View Egn;
  private View Ego;
  private Context context;
  int gRE;
  private MMHandler hAk;
  private boolean hki;
  private boolean isAutoPlay;
  private GestureDetector jKk;
  private String lPw;
  private int length;
  private View maskView;
  private com.tencent.mm.plugin.sight.decode.ui.b tni;
  private boolean vbV;
  
  public ah(final Context paramContext, v paramv, ViewGroup paramViewGroup)
  {
    super(paramContext, paramv, paramViewGroup);
    AppMethodBeat.i(96717);
    this.AhP = 0L;
    this.Efg = 0;
    this.Aiv = 0;
    this.Efh = 0;
    this.Ega = 0;
    this.DvS = 0;
    this.DvT = 0;
    this.DvU = 0;
    this.Efj = 0;
    this.Egb = 0;
    this.EeY = true;
    this.Egc = 0;
    this.gRE = 0;
    this.Eff = 0;
    this.Efa = false;
    this.Efb = true;
    this.isAutoPlay = false;
    this.Efd = true;
    this.Efe = true;
    this.Efc = false;
    this.Egf = false;
    this.Efk = null;
    this.Efl = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(203024);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bm(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/AdLandingPageSightVideoComponent$10", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
        for (;;)
        {
          try
          {
            Log.i("MicroMsg.Sns.AdLandingPageSightVideoComponent.VideoOptimize", "play btn onclick isPlaying[%b]", new Object[] { Boolean.valueOf(ah.this.EfZ.isPlaying()) });
            ah.a(ah.this, ah.e(ah.this));
            if (!ah.this.EfZ.isPlaying()) {
              continue;
            }
            ah.t(ah.this);
            ah.c(ah.this, 4);
            if (ah.v(ah.this)) {
              ah.w(ah.this);
            }
          }
          catch (Throwable paramAnonymousView)
          {
            Log.e("MicroMsg.Sns.AdLandingPageSightVideoComponent.VideoOptimize", paramAnonymousView.toString());
            continue;
            ah.this.fcL();
            ah.this.fcK();
            continue;
          }
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/AdLandingPageSightVideoComponent$10", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(203024);
          return;
          if (!ah.this.EeY) {
            continue;
          }
          ah.this.fcJ();
          ah.u(ah.this);
          ah.c(ah.this, 3);
        }
      }
    };
    this.tni = new com.tencent.mm.plugin.sight.decode.ui.b()
    {
      public final void aJq()
      {
        AppMethodBeat.i(203025);
        try
        {
          ah.a(ah.this, ah.e(ah.this));
          if (ah.d(ah.this) != null) {
            ah.d(ah.this).fgd();
          }
          AppMethodBeat.o(203025);
          return;
        }
        catch (Throwable localThrowable)
        {
          Log.e("MicroMsg.Sns.AdLandingPageSightVideoComponent.VideoOptimize", localThrowable.toString());
          AppMethodBeat.o(203025);
        }
      }
      
      public final void rk(int paramAnonymousInt)
      {
        AppMethodBeat.i(203026);
        try
        {
          Log.i("MicroMsg.Sns.AdLandingPageSightVideoComponent.VideoOptimize", "onSeek time ".concat(String.valueOf(paramAnonymousInt)));
          if (ah.this.EeY) {
            ah.this.fcJ();
          }
          for (;;)
          {
            ah.d(ah.this).aU(paramAnonymousInt * 1000, true);
            ah.c(ah.this, 3);
            ah.b(ah.this, true);
            ah.y(ah.this).removeCallbacks(ah.x(ah.this));
            ah.b(ah.this).setVisibility(8);
            AppMethodBeat.o(203026);
            return;
            ah.this.fcK();
          }
          return;
        }
        catch (Throwable localThrowable)
        {
          Log.e("MicroMsg.Sns.AdLandingPageSightVideoComponent.VideoOptimize", localThrowable.toString());
          AppMethodBeat.o(203026);
        }
      }
    };
    this.Efi = 0;
    this.Egh = 0;
    this.Egi = 0;
    this.Egk = 0L;
    this.Egm = false;
    this.context = paramContext;
    this.hAk = new MMHandler(Looper.getMainLooper());
    try
    {
      this.jKk = new GestureDetector(this);
      this.EeU = new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(203023);
          ah.a(ah.this);
          AppMethodBeat.o(203023);
        }
      };
      this.Egg = new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(203030);
          ah.b(ah.this).setVisibility(8);
          AppMethodBeat.o(203030);
        }
      };
      this.Efk = new ao()
      {
        public final void vg(boolean paramAnonymousBoolean)
        {
          AppMethodBeat.i(203031);
          try
          {
            Intent localIntent = new Intent("com.tencent.mm.adlanding.video_progressbar_change");
            if (paramAnonymousBoolean) {}
            for (int i = 1;; i = 0)
            {
              localIntent.putExtra("show", i);
              localIntent.putExtra("activity_code", ah.c(ah.this));
              d.W(paramContext).b(localIntent);
              AppMethodBeat.o(203031);
              return;
            }
            return;
          }
          catch (Throwable localThrowable)
          {
            Log.e("MicroMsg.Sns.AdLandingPageSightVideoComponent", localThrowable.toString());
            AppMethodBeat.o(203031);
          }
        }
      };
      AppMethodBeat.o(96717);
      return;
    }
    catch (Throwable paramContext)
    {
      Log.e("MicroMsg.Sns.AdLandingPageSightVideoComponent.VideoOptimize", paramContext.toString());
      AppMethodBeat.o(96717);
    }
  }
  
  private void YY(final int paramInt)
  {
    AppMethodBeat.i(203049);
    try
    {
      this.hAk.post(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(203045);
          ah.n(ah.this).seek(paramInt);
          ah.b(ah.this, ah.this.EfZ.isPlaying());
          AppMethodBeat.o(203045);
        }
      });
      AppMethodBeat.o(203049);
      return;
    }
    catch (Throwable localThrowable)
    {
      Log.e("MicroMsg.Sns.AdLandingPageSightVideoComponent.VideoOptimize", localThrowable.toString());
      AppMethodBeat.o(203049);
    }
  }
  
  public static void aPY(String paramString)
  {
    int i = 1;
    AppMethodBeat.i(203052);
    Object localObject = "0";
    for (;;)
    {
      try
      {
        if (s.YS(paramString))
        {
          String str = "1";
          localObject = str;
          if (s.deleteFile(paramString))
          {
            localObject = str;
            paramString = NetStatusUtil.getFormatedNetType(MMApplicationContext.getContext());
            j.b(j.DEa, (String)localObject, 1, i, "http|".concat(String.valueOf(paramString)));
            AppMethodBeat.o(203052);
            return;
          }
        }
      }
      catch (Throwable paramString)
      {
        Log.e("MicroMsg.Sns.AdLandingPageSightVideoComponent", "delErrorFile exp=" + paramString.toString());
        AppMethodBeat.o(203052);
        return;
      }
      i = 0;
    }
  }
  
  private void abandonAudioFocus()
  {
    AppMethodBeat.i(203063);
    try
    {
      if (this.Egl != null)
      {
        AudioManager localAudioManager = (AudioManager)this.context.getSystemService("audio");
        if (localAudioManager != null)
        {
          localAudioManager.abandonAudioFocus(this.Egl);
          this.Egl = null;
        }
      }
      AppMethodBeat.o(203063);
      return;
    }
    catch (Throwable localThrowable)
    {
      Log.e("MicroMsg.Sns.AdLandingPageSightVideoComponent", "abandonAudioFocus has something wrong!");
      AppMethodBeat.o(203063);
    }
  }
  
  private void ay(Runnable paramRunnable)
  {
    AppMethodBeat.i(203053);
    try
    {
      this.hAk.removeCallbacks(paramRunnable);
      this.hAk.postDelayed(paramRunnable, 4000L);
      AppMethodBeat.o(203053);
      return;
    }
    catch (Throwable paramRunnable)
    {
      Log.e("MicroMsg.Sns.AdLandingPageSightVideoComponent.VideoOptimize", paramRunnable.toString());
      AppMethodBeat.o(203053);
    }
  }
  
  private void czw()
  {
    AppMethodBeat.i(96721);
    if (this.Efc)
    {
      Log.i("MicroMsg.Sns.AdLandingPageSightVideoComponent", "last download fail ,try again");
      this.EfZ.cWZ();
      AppMethodBeat.o(96721);
      return;
    }
    Log.d("MicroMsg.Sns.AdLandingPageSightVideoComponent", "starting play");
    if ((!this.vbV) && (!TextUtils.isEmpty(this.lPw)))
    {
      this.EfZ.asy(this.lPw);
      this.vbV = true;
    }
    this.hAk.post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(203027);
        ah.d(ah.this).fge();
        ah.z(ah.this);
        try
        {
          ah.b(ah.this, true);
          ah.y(ah.this).removeCallbacks(ah.x(ah.this));
          ah.b(ah.this).setVisibility(8);
          AppMethodBeat.o(203027);
          return;
        }
        catch (Throwable localThrowable)
        {
          Log.e("MicroMsg.Sns.AdLandingPageSightVideoComponent", localThrowable.toString());
          AppMethodBeat.o(203027);
        }
      }
    });
    this.AhP = System.currentTimeMillis();
    this.Aiv += 1;
    AppMethodBeat.o(96721);
  }
  
  private boolean fdG()
  {
    AppMethodBeat.i(96720);
    if (!Util.isNullOrNil(((v)this.EcX).DYd))
    {
      Intent localIntent = new Intent();
      localIntent.putExtra("sns_landig_pages_from_source", 14);
      localIntent.putExtra("sns_landig_pages_origin_from_source", fds().DZU);
      localIntent.putExtra("sns_landing_pages_ux_info", fds().uxInfo);
      localIntent.putExtra("sns_landing_pages_xml", "");
      localIntent.putExtra("sns_landing_pages_canvasid", ((v)this.EcX).DYd);
      localIntent.putExtra("sns_landing_pages_canvas_ext", ((v)this.EcX).DYe);
      localIntent.putExtra("sns_landing_pages_no_store", ((v)this.EcX).DYf);
      localIntent.putExtra("sns_landing_pages_need_enter_and_exit_animation", true);
      String str3;
      String str1;
      String str2;
      JSONObject localJSONObject;
      if (((this.context instanceof Activity)) && (fds().bizId == 2))
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
          localJSONObject.put("cid", ((v)this.EcX).DZi);
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
        this.EfZ.getLocationOnScreen((int[])localObject);
        localIntent.putExtra("img_gallery_top", localObject[1]);
        localIntent.putExtra("img_gallery_left", localObject[0]);
        localIntent.putExtra("img_gallery_width", this.EfZ.getWidth());
        localIntent.putExtra("img_gallery_height", this.EfZ.getHeight());
        c.b(this.context, "sns", ".ui.SnsAdNativeLandingPagesPreviewUI", localIntent);
        AppMethodBeat.o(96720);
        return true;
        localObject = "";
      }
    }
    AppMethodBeat.o(96720);
    return false;
  }
  
  private void vh(boolean paramBoolean)
  {
    AppMethodBeat.i(203048);
    try
    {
      this.EeP.setIsPlay(paramBoolean);
      this.EeP.getPlayBtn().getLayoutParams().width = this.length;
      this.EeP.getPlayBtn().getLayoutParams().height = this.length;
      if (paramBoolean)
      {
        Log.i("MicroMsg.Sns.AdLandingPageSightVideoComponent.VideoOptimize", "startPlay");
        this.EeP.getPlayBtn().setImageDrawable(com.tencent.mm.cb.a.l(this.context, 2131691079));
        AppMethodBeat.o(203048);
        return;
      }
      Log.i("MicroMsg.Sns.AdLandingPageSightVideoComponent.VideoOptimize", "pausePlay");
      this.EeP.getPlayBtn().setImageDrawable(com.tencent.mm.cb.a.l(this.context, 2131691078));
      AppMethodBeat.o(203048);
      return;
    }
    catch (Throwable localThrowable)
    {
      Log.e("MicroMsg.Sns.AdLandingPageSightVideoComponent.VideoOptimize", localThrowable.toString());
      AppMethodBeat.o(203048);
    }
  }
  
  private void vi(final boolean paramBoolean)
  {
    AppMethodBeat.i(203050);
    Log.d("MicroMsg.Sns.AdLandingPageSightVideoComponent", "pause play");
    this.hAk.post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(203028);
        ah.d(ah.this).fgd();
        try
        {
          ah.b(ah.this, false);
          if ((ah.r(ah.this)) && (paramBoolean))
          {
            ah.b(ah.this).setVisibility(0);
            ah.a(ah.this, ah.x(ah.this));
          }
          AppMethodBeat.o(203028);
          return;
        }
        catch (Throwable localThrowable)
        {
          Log.e("MicroMsg.Sns.AdLandingPageSightVideoComponent", localThrowable.toString());
          AppMethodBeat.o(203028);
        }
      }
    });
    if (this.AhP != 0L)
    {
      this.Efg = ((int)(this.Efg + (System.currentTimeMillis() - this.AhP)));
      this.AhP = 0L;
    }
    AppMethodBeat.o(203050);
  }
  
  public final void a(int paramInt1, boolean paramBoolean1, boolean paramBoolean2, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, long paramLong1, String paramString, long paramLong2)
  {
    AppMethodBeat.i(203060);
    for (;;)
    {
      try
      {
        this.Eff = 6;
        this.Egk += paramLong2;
        this.Egf = paramBoolean2;
        this.Egi += 1;
        this.Efi += paramInt2;
        this.Egh += paramInt3;
        this.Efj += paramInt4;
        this.Efh += paramInt5;
        this.Aiv += paramInt6;
        this.Efg = ((int)(this.Efg + paramLong1));
        if (paramBoolean2) {
          this.AhP = System.currentTimeMillis();
        }
        boolean bool = Util.isNullOrNil(paramString);
        if (!bool) {}
        try
        {
          paramString = new JSONObject(paramString);
          if (this.Egj == null) {
            this.Egj = new c();
          }
          c localc = this.Egj;
          localc.Dzo += paramString.optInt("exposureCount");
          localc = this.Egj;
          localc.dUy += paramString.optLong("stayTime");
          localc = this.Egj;
          localc.clickCount += paramString.optInt("clickCount");
          paramString = paramString.optJSONObject("btnInfo");
          this.Egj.Egw = paramString.optString("cid");
          localc = this.Egj;
          localc.Egx += paramString.optInt("exposureCount");
          localc = this.Egj;
          localc.Egy += paramString.optLong("stayTime");
          localc = this.Egj;
          paramInt2 = localc.Egz;
          localc.Egz = (paramString.optInt("clickCount") + paramInt2);
        }
        catch (Throwable paramString)
        {
          this.Egj = null;
          Log.e("MicroMsg.Sns.AdLandingPageSightVideoComponent", paramString.toString());
          continue;
        }
        this.hAk.removeCallbacks(this.Egg);
        this.Ege.setVisibility(8);
        Log.i("VideoFullScreenActivity", "currPosSec = " + paramInt1 + ", isPlaying = " + paramBoolean2 + ", bNoVoice = " + paramBoolean1);
        paramInt2 = paramInt1 / 1000;
        if ((paramInt2 >= this.Dzs) || (paramInt1 < 0))
        {
          this.EeP.seek(0);
          this.EfZ.aU(0, paramBoolean2);
          vh(paramBoolean2);
          if (!paramBoolean1) {
            break;
          }
          fcJ();
          AppMethodBeat.o(203060);
          return;
        }
      }
      catch (Throwable paramString)
      {
        Log.e("VideoFullScreenActivity", paramString.toString());
        AppMethodBeat.o(203060);
        return;
      }
      this.EeP.seek(paramInt2);
      this.EfZ.aU(paramInt1, paramBoolean2);
    }
    fcK();
    AppMethodBeat.o(203060);
  }
  
  public final boolean bp(JSONObject paramJSONObject)
  {
    AppMethodBeat.i(96729);
    if (!super.bp(paramJSONObject))
    {
      AppMethodBeat.o(96729);
      return false;
    }
    try
    {
      paramJSONObject.put("sightDuration", this.Dzs * 1000);
      paramJSONObject.put("playTimeInterval", this.Efg);
      paramJSONObject.put("playCount", this.Aiv);
      paramJSONObject.put("playCompletedCount", this.Efh);
      paramJSONObject.put("clickPlayControlCount", this.Efi);
      paramJSONObject.put("doubleClickCount", this.Egh);
      paramJSONObject.put("clickFullscreenBtnCount", this.Egi);
      paramJSONObject.put("clickVoiceControlCount", this.Efj);
      if (this.isAutoPlay) {}
      for (Object localObject = "1";; localObject = "0")
      {
        paramJSONObject.put("isAutoPlay", localObject);
        if (((v)this.EcX).type == 61) {
          paramJSONObject.put("clickSightCount", this.Egb);
        }
        JSONObject localJSONObject;
        if (!this.Efe)
        {
          localObject = MD5Util.getMD5String(((v)this.EcX).DYQ);
          localJSONObject = new JSONObject();
          localJSONObject.put("urlMd5", localObject);
          localJSONObject.put("needDownload", 1);
          paramJSONObject.put("sightUrlInfo", localJSONObject);
        }
        if (!this.Efd)
        {
          localObject = MD5Util.getMD5String(((v)this.EcX).DYR);
          localJSONObject = new JSONObject();
          localJSONObject.put("urlMd5", localObject);
          localJSONObject.put("needDownload", 1);
          paramJSONObject.put("thumbUrlInfo", localJSONObject);
        }
        paramJSONObject.put("streamVideoEnterCount", this.Ega);
        paramJSONObject.put("streamVideoPlayCount", this.DvS);
        paramJSONObject.put("streamVideoPlayCompleteCount", this.DvT);
        paramJSONObject.put("streamVideoTotalPlayTimeInMs", this.DvU);
        if (this.Egj != null)
        {
          localObject = new JSONObject();
          ((JSONObject)localObject).put("cid", this.Egj.Egw);
          ((JSONObject)localObject).put("exposureCount", this.Egj.Egx);
          ((JSONObject)localObject).put("stayTime", this.Egj.Egy);
          ((JSONObject)localObject).put("clickCount", this.Egj.Egz);
          localJSONObject = new JSONObject();
          localJSONObject.put("exposureCount", this.Egj.Dzo);
          localJSONObject.put("stayTime", this.Egj.dUy);
          localJSONObject.put("clickCount", this.Egj.clickCount);
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
  
  public final void cWX()
  {
    AppMethodBeat.i(203061);
    vi(false);
    this.Eff = 4;
    AppMethodBeat.o(203061);
  }
  
  public final void cWY()
  {
    AppMethodBeat.i(203062);
    this.Eff = 3;
    czw();
    AppMethodBeat.o(203062);
  }
  
  protected final void eWT()
  {
    AppMethodBeat.i(96730);
    Log.i("MicroMsg.Sns.AdLandingPageSightVideoComponent", getClass().getName() + "not support update now");
    AppMethodBeat.o(96730);
  }
  
  public final void eWZ()
  {
    AppMethodBeat.i(96725);
    super.eWZ();
    AppMethodBeat.o(96725);
  }
  
  public final void eXa()
  {
    AppMethodBeat.i(96726);
    super.eXa();
    abandonAudioFocus();
    vi(false);
    if ((!this.Efa) && (!this.Efb))
    {
      AppMethodBeat.o(96726);
      return;
    }
    this.Efb = false;
    this.Efa = false;
    if (this.Eff == 1) {
      this.Eff = 2;
    }
    int i = this.Eff;
    Log.d("MicroMsg.Sns.AdLandingPageSightVideoComponent", "disappear handleType %d", new Object[] { Integer.valueOf(this.Eff) });
    AppMethodBeat.o(96726);
  }
  
  public final void eXb()
  {
    AppMethodBeat.i(96728);
    super.eXb();
    int i = fdl();
    int j = getView().getHeight();
    Log.d("MicroMsg.Sns.AdLandingPageSightVideoComponent", "inScreenHeight %d, height %d", new Object[] { Integer.valueOf(i), Integer.valueOf(j) });
    if ((i == 0) || (j == 0))
    {
      AppMethodBeat.o(96728);
      return;
    }
    this.Egc = i;
    this.gRE = j;
    if (i < 0)
    {
      AppMethodBeat.o(96728);
      return;
    }
    Log.d("MicroMsg.Sns.AdLandingPageSightVideoComponent", "appeared handleType %d", new Object[] { Integer.valueOf(this.Eff) });
    if (i >= j * 0.5F)
    {
      if ((this.Efa) && (!this.Efb))
      {
        AppMethodBeat.o(96728);
        return;
      }
      this.Efb = false;
      this.Efa = true;
      if (this.Eff == 6)
      {
        if (this.Egf)
        {
          this.Eff = 1;
          AppMethodBeat.o(96728);
          return;
        }
        this.Eff = 4;
        AppMethodBeat.o(96728);
        return;
      }
      if (this.Eff == 0)
      {
        if (this.EeY) {
          fcJ();
        }
        for (;;)
        {
          this.Eff = 1;
          czw();
          AppMethodBeat.o(96728);
          return;
          fcK();
        }
      }
      if (this.Eff == 2)
      {
        if (this.EeY) {
          fcJ();
        }
        for (;;)
        {
          czw();
          this.Eff = 1;
          AppMethodBeat.o(96728);
          return;
          fcK();
        }
      }
      if (this.Eff == 3)
      {
        if (this.EeY) {
          fcJ();
        }
        for (;;)
        {
          czw();
          AppMethodBeat.o(96728);
          return;
          fcK();
        }
      }
    }
    else
    {
      this.Efb = false;
      this.Efa = false;
      vi(false);
      if (this.Eff == 1) {
        this.Eff = 2;
      }
      i = this.Eff;
    }
    AppMethodBeat.o(96728);
  }
  
  public final void eXd()
  {
    AppMethodBeat.i(96727);
    super.eXd();
    try
    {
      this.hAk.removeCallbacks(this.EeU);
      this.hAk.removeCallbacks(this.Egg);
      abandonAudioFocus();
      this.EfZ.onDestroy();
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
  
  public final void eXe()
  {
    AppMethodBeat.i(96718);
    if (!s.YS(h.kz("adId", ((v)this.EcX).DYR))) {
      this.Efd = false;
    }
    if (!s.YS(com.tencent.mm.loader.j.b.aKJ() + "/sns_ad_landingpages/adId_stream_" + MD5Util.getMD5String(((v)this.EcX).DYQ))) {
      this.Efe = false;
    }
    View localView = this.contentView.findViewById(2131308050);
    this.Egn = localView;
    Object localObject1 = (ViewGroup)localView.findViewById(2131308043);
    this.EfZ = new OfflineVideoView(this.context);
    this.Ego = ((View)localObject1);
    ((ViewGroup)localObject1).addView(this.EfZ, new LinearLayout.LayoutParams(-1, -1));
    int i;
    Object localObject2;
    if (((v)this.EcX).DYW == 0) {
      if ((int)((v)this.EcX).width > 0)
      {
        i = this.mEX;
        localObject2 = new RelativeLayout.LayoutParams(i, (int)(i * ((v)this.EcX).height / ((v)this.EcX).width));
        ((ViewGroup)localObject1).setLayoutParams((ViewGroup.LayoutParams)localObject2);
        localView.setLayoutParams((ViewGroup.LayoutParams)localObject2);
        if (((v)this.EcX).DYY) {
          break label1168;
        }
        Log.e("MicroMsg.Sns.AdLandingPageSightVideoComponent", "fixVideoBlackline, enable=false");
        label255:
        Log.i("MicroMsg.Sns.AdLandingPageSightVideoComponent", "createView, displayType=" + ((v)this.EcX).DYW);
        localObject1 = h.kz("adId", ((v)this.EcX).DYR);
        if (!s.YS((String)localObject1)) {
          break label1522;
        }
        this.EfZ.aQV((String)localObject1);
      }
    }
    for (;;)
    {
      this.EeT = ((TextView)localView.findViewById(2131300154));
      this.EeT.setText(this.context.getString(2131758370));
      this.maskView = localView.findViewById(2131308056);
      if (this.maskView != null)
      {
        localObject1 = new RelativeLayout.LayoutParams(-1, -1);
        localObject2 = this.maskView.getParent();
        if ((localObject2 instanceof ViewGroup)) {
          ((ViewGroup)localObject2).removeView(this.maskView);
        }
        ((ViewGroup)localView).addView(this.maskView, (ViewGroup.LayoutParams)localObject1);
      }
      this.EeQ = ((ImageView)localView.findViewById(2131308058));
      this.EeQ.setVisibility(0);
      this.EeQ.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(96714);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bm(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/AdLandingPageSightVideoComponent$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
          paramAnonymousView = ah.this;
          paramAnonymousView.Efj += 1;
          ah.a(ah.this, ah.e(ah.this));
          if (ah.this.EeY)
          {
            ah.this.fcL();
            ah.this.fcK();
          }
          for (;;)
          {
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/AdLandingPageSightVideoComponent$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(96714);
            return;
            ah.this.fcJ();
          }
        }
      });
      try
      {
        localObject1 = this.EeQ.getParent();
        if ((localObject1 instanceof ViewGroup)) {
          ((ViewGroup)localObject1).removeView(this.EeQ);
        }
        localObject1 = (RelativeLayout.LayoutParams)this.EeQ.getLayoutParams();
        ((RelativeLayout.LayoutParams)localObject1).bottomMargin = com.tencent.mm.cb.a.fromDPToPix(this.context, 8);
        ((RelativeLayout.LayoutParams)localObject1).rightMargin = com.tencent.mm.cb.a.fromDPToPix(this.context, 10);
        ((ViewGroup)localView).addView(this.EeQ, (ViewGroup.LayoutParams)localObject1);
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
      this.EfZ.setVideoCallback(new OfflineVideoView.a()
      {
        public final boolean a(PString paramAnonymousPString)
        {
          AppMethodBeat.i(203039);
          final long l = System.currentTimeMillis();
          final String str1 = ah.f(ah.this).DYQ;
          final String str2 = h.kA("adId", str1);
          if (s.YS(str2))
          {
            paramAnonymousPString.value = str2;
            ah.g(ah.this);
            AppMethodBeat.o(203039);
            return true;
          }
          if (!ah.f(ah.this).DYZ) {
            h.b("adId", str1, false, 62, new f.a()
            {
              public final void aNH(String paramAnonymous2String)
              {
                AppMethodBeat.i(203034);
                Log.i("MicroMsg.Sns.AdLandingPageSightVideoComponent", "downloadSightForAdLandingPages succ, video view height " + ah.this.contentView.getHeight() + ", player height " + ah.d(ah.this).getHeight() + ", timeCost=" + (System.currentTimeMillis() - l));
                ah.a(ah.this, false);
                ah.a(ah.this, paramAnonymous2String);
                ah.d(ah.this).asy(paramAnonymous2String);
                ah.g(ah.this);
                AppMethodBeat.o(203034);
              }
              
              public final void eWN() {}
              
              public final void eWO()
              {
                AppMethodBeat.i(203033);
                Log.e("MicroMsg.Sns.AdLandingPageSightVideoComponent", "downloadSightForAdLandingPages fail:" + str1);
                ah.a(ah.this, true);
                ah.aPY(str2);
                AppMethodBeat.o(203033);
              }
            });
          }
          for (;;)
          {
            AppMethodBeat.o(203039);
            return false;
            h.b("adId", str1, new f.a()
            {
              public final void aNH(String paramAnonymous2String)
              {
                AppMethodBeat.i(203036);
                Log.i("MicroMsg.Sns.AdLandingPageSightVideoComponent", "downloadSightForAdLandingPagesByCdn succ, video view height " + ah.this.contentView.getHeight() + ", player height " + ah.d(ah.this).getHeight() + ", timeCost=" + (System.currentTimeMillis() - l));
                ah.a(ah.this, false);
                ah.a(ah.this, paramAnonymous2String);
                ah.d(ah.this).asy(paramAnonymous2String);
                ah.g(ah.this);
                AppMethodBeat.o(203036);
              }
              
              public final void eWN() {}
              
              public final void eWO()
              {
                AppMethodBeat.i(203035);
                Log.e("MicroMsg.Sns.AdLandingPageSightVideoComponent", "downloadSightForAdLandingPagesByCdn fail:" + str1);
                ah.a(ah.this, true);
                AppMethodBeat.o(203035);
              }
            });
          }
        }
        
        public final void onCompletion()
        {
          AppMethodBeat.i(203040);
          MMHandlerThread.postToMainThread(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(203037);
              if ((ah.f(ah.this).DYX != null) && (!ah.h(ah.this)))
              {
                int i = ah.d(ah.this).getDurationMs();
                int j = ah.f(ah.this).DYX.Eab;
                Log.i("MicroMsg.Sns.AdLandingPageSightVideoComponent", "OpenSnsAdFloatPageEvent, onCompletion totalMs=" + i + ", floatStartTime=" + j + ", hasShowFloat=" + ah.h(ah.this));
                if (i < j)
                {
                  ah.i(ah.this);
                  pb localpb = new pb();
                  localpb.dVd.dVe = ah.f(ah.this).DYX.dVe;
                  EventCenter.instance.publish(localpb);
                }
              }
              AppMethodBeat.o(203037);
            }
          });
          ah.j(ah.this);
          ah.k(ah.this).Duo = true;
          ah.l(ah.this);
          AppMethodBeat.o(203040);
        }
        
        public final void onStart(int paramAnonymousInt)
        {
          AppMethodBeat.i(203041);
          ah.m(ah.this);
          ah.a(ah.this, paramAnonymousInt);
          ah.this.EeQ.setVisibility(0);
          try
          {
            if (ah.n(ah.this).getVideoTotalTime() != paramAnonymousInt) {
              ah.n(ah.this).setVideoTotalTime(ah.o(ah.this));
            }
            Log.i("MicroMsg.Sns.AdLandingPageSightVideoComponent.VideoOptimize", "onStart");
            int i = (int)ah.this.fds().DZZ;
            if ((ah.p(ah.this) instanceof SnsAdNativeLandingPagesUI))
            {
              SnsAdNativeLandingPagesUI localSnsAdNativeLandingPagesUI = (SnsAdNativeLandingPagesUI)ah.p(ah.this);
              Object localObject = localSnsAdNativeLandingPagesUI.getAllComp();
              if ((localObject != null) && (((List)localObject).size() > 0))
              {
                localObject = (m)((List)localObject).get(0);
                if ((localObject instanceof ah))
                {
                  ((ah)localObject).Egm = true;
                  Log.i("MicroMsg.SnsAdNativeLandingPagesUI", "snsId = " + localSnsAdNativeLandingPagesUI.dRS + ", adSightVideoSeekTime = " + localSnsAdNativeLandingPagesUI.DZZ + ", isFirstSightVideoComp = true");
                }
              }
              Log.i("MicroMsg.Sns.AdLandingPageSightVideoComponent", "snsId = " + ah.this.fds().getSnsId() + ", adSightVideoSeekTime = " + i + ", isFirstSightVideoComp = " + ah.this.Egm);
              if ((ah.this.Egm) && (ah.iA(i, paramAnonymousInt * 1000))) {
                ah.d(ah.this).aU(i, true);
              }
            }
            AppMethodBeat.o(203041);
            return;
          }
          catch (Throwable localThrowable)
          {
            Log.i("MicroMsg.Sns.AdLandingPageSightVideoComponent.VideoOptimize", localThrowable.toString());
            AppMethodBeat.o(203041);
          }
        }
        
        public final void xv(int paramAnonymousInt)
        {
          AppMethodBeat.i(203042);
          ah.q(ah.this).sendMessage();
          MMHandlerThread.postToMainThread(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(203038);
              Log.d("MicroMsg.Sns.AdLandingPageSightVideoComponent", "play time " + this.Dpf + " video time " + ah.o(ah.this));
              ah.b(ah.this, this.Dpf);
              if ((ah.f(ah.this).DYX != null) && (!ah.h(ah.this)))
              {
                int i = ah.f(ah.this).DYX.Eab / 1000;
                Log.i("MicroMsg.Sns.AdLandingPageSightVideoComponent", "OpenSnsAdFloatPageEvent, updateTime seconds=" + this.Dpf + ", floatSeconds=" + i + ", hasShowFloat=" + ah.h(ah.this));
                if (this.Dpf >= i)
                {
                  ah.i(ah.this);
                  pb localpb = new pb();
                  localpb.dVd.dVe = ah.f(ah.this).DYX.dVe;
                  EventCenter.instance.publish(localpb);
                }
              }
              AppMethodBeat.o(203038);
            }
          });
          AppMethodBeat.o(203042);
        }
      });
      this.EfZ.setOnSeekCompleteCallback(new d());
      this.EeQ.setVisibility(8);
      this.EfZ.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(203043);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bm(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/AdLandingPageSightVideoComponent$7", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
          if (ah.r(ah.this))
          {
            paramAnonymousView = ah.this;
            paramAnonymousView.Egb += 1;
            if (ah.s(ah.this))
            {
              com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/AdLandingPageSightVideoComponent$7", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
              AppMethodBeat.o(203043);
              return;
            }
          }
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/AdLandingPageSightVideoComponent$7", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(203043);
        }
      });
      localObject1 = (v)this.EcX;
      if ((((v)localObject1).subType != 1) || (((v)localObject1).DYT.length() <= 0) || (((v)localObject1).DYS.length() <= 0)) {
        break label1568;
      }
      i = 1;
      if (i != 0)
      {
        localObject1 = this.contentView.findViewById(2131308044);
        ((View)localObject1).setVisibility(0);
        localObject2 = (Button)((View)localObject1).findViewById(2131308045);
        ((Button)localObject2).setTextColor(((v)this.EcX).DYU);
        ((Button)localObject2).setText(((v)this.EcX).DYT);
        ((Button)localObject2).setOnClickListener(new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            AppMethodBeat.i(203044);
            com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
            localb.bm(paramAnonymousView);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/AdLandingPageSightVideoComponent$8", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
            ah.this.fdF();
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/AdLandingPageSightVideoComponent$8", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(203044);
          }
        });
        ((View)localObject1).findViewById(2131308046).setBackgroundColor(((v)this.EcX).DYV);
      }
      try
      {
        this.length = com.tencent.mm.cb.a.fromDPToPix(this.context, 32);
        this.EfZ.setOnTouchListener(this);
        this.Egd = ((ImageView)localView.findViewById(2131308057));
        localObject1 = this.Egd.getParent();
        if ((localObject1 instanceof ViewGroup)) {
          ((ViewGroup)localObject1).removeView(this.Egd);
        }
        localObject1 = (RelativeLayout.LayoutParams)this.Egd.getLayoutParams();
        ((RelativeLayout.LayoutParams)localObject1).bottomMargin = com.tencent.mm.cb.a.fromDPToPix(this.context, 8);
        ((RelativeLayout.LayoutParams)localObject1).rightMargin = com.tencent.mm.cb.a.fromDPToPix(this.context, 10);
        ((ViewGroup)localView).addView(this.Egd, (ViewGroup.LayoutParams)localObject1);
        this.Egd.setOnClickListener(this);
        this.Egd.setVisibility(8);
        Log.i("MicroMsg.Sns.AdLandingPageSightVideoComponent.VideoOptimize", "init fullScreenBtn and visible");
      }
      catch (Throwable localThrowable3)
      {
        for (;;)
        {
          label1097:
          int j;
          label1168:
          label1522:
          Log.e("MicroMsg.Sns.AdLandingPageSightVideoComponent.VideoOptimize", localThrowable3.toString());
          continue;
          boolean bool = false;
        }
      }
      try
      {
        this.EeP = new VideoPlayerSeekBar(this.context);
        localObject1 = this.EeP.getParent();
        if ((localObject1 instanceof ViewGroup)) {
          ((ViewGroup)localObject1).removeView(this.EeP);
        }
        localObject1 = new RelativeLayout.LayoutParams(this.Ego.getLayoutParams().width - com.tencent.mm.cb.a.fromDPToPix(this.context, 75), -2);
        ((RelativeLayout.LayoutParams)localObject1).addRule(12);
        ((RelativeLayout.LayoutParams)localObject1).bottomMargin = com.tencent.mm.cb.a.fromDPToPix(this.context, 3);
        this.EeP.setLayoutParams((ViewGroup.LayoutParams)localObject1);
        ((ViewGroup)this.contentView.findViewById(2131299214)).addView(this.EeP, (ViewGroup.LayoutParams)localObject1);
        YY(0);
        this.EeP.setOnPlayButtonClickListener(this.Efl);
        this.EeP.setIplaySeekCallback(this.tni);
        this.EeP.setVisibility(4);
        if (this.Efk != null)
        {
          localObject1 = this.Efk;
          if (this.EeP.getVisibility() == 0)
          {
            bool = true;
            ((ao)localObject1).vg(bool);
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
        break label1097;
      }
      try
      {
        this.Ege = localView.findViewById(2131305803);
        this.Ege.setVisibility(8);
        AppMethodBeat.o(96718);
        return;
      }
      catch (Throwable localThrowable1)
      {
        Log.e("MicroMsg.Sns.AdLandingPageSightVideoComponent.VideoOptimize", localThrowable1.toString());
        AppMethodBeat.o(96718);
      }
      ((ViewGroup)localObject1).setLayoutParams(new RelativeLayout.LayoutParams(this.mEX, this.mEY));
      localView.setLayoutParams(new RelativeLayout.LayoutParams(this.mEX, this.mEY));
      break;
      localObject1 = this.EfZ.getInnerVideoView();
      if ((localObject1 instanceof VideoPlayerTextureView))
      {
        ((View)localObject1).addOnLayoutChangeListener(new View.OnLayoutChangeListener()
        {
          public final void onLayoutChange(View paramAnonymousView, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3, int paramAnonymousInt4, int paramAnonymousInt5, int paramAnonymousInt6, int paramAnonymousInt7, int paramAnonymousInt8)
          {
            AppMethodBeat.i(203029);
            try
            {
              paramAnonymousInt1 = paramAnonymousView.getHeight();
              paramAnonymousInt2 = paramAnonymousView.getWidth();
              paramAnonymousInt3 = ah.A(ah.this).getWidth();
              paramAnonymousInt4 = ah.A(ah.this).getHeight();
              if ((paramAnonymousInt2 <= 1) || (paramAnonymousInt1 <= 1) || (paramAnonymousInt3 == 0) || (paramAnonymousInt4 == 0))
              {
                AppMethodBeat.o(203029);
                return;
              }
              Log.i("MicroMsg.Sns.AdLandingPageSightVideoComponent", "onLayoutChange, video.w=" + paramAnonymousView.getWidth() + ", h=" + paramAnonymousView.getHeight() + ", container.w=" + paramAnonymousInt3 + ", h=" + paramAnonymousInt4 + ", container.padding=" + k.fg(ah.A(ah.this)));
              if (paramAnonymousInt1 == paramAnonymousInt4)
              {
                AppMethodBeat.o(203029);
                return;
              }
              if ((paramAnonymousInt1 >= paramAnonymousInt2) && (paramAnonymousInt4 >= paramAnonymousInt3) && (Math.abs(paramAnonymousInt1 - paramAnonymousInt4) < 2))
              {
                paramAnonymousView = ah.A(ah.this).getLayoutParams();
                paramAnonymousView.height = paramAnonymousInt1;
                ah.A(ah.this).setLayoutParams(paramAnonymousView);
                Log.i("MicroMsg.Sns.AdLandingPageSightVideoComponent", "onLayoutChange, reset VideoContainer.height");
              }
              AppMethodBeat.o(203029);
              return;
            }
            catch (Exception paramAnonymousView)
            {
              Log.e("MicroMsg.Sns.AdLandingPageSightVideoComponent", "onLayoutChange, exp=" + paramAnonymousView.toString());
              AppMethodBeat.o(203029);
            }
          }
        });
        break label255;
      }
      Log.e("MicroMsg.Sns.AdLandingPageSightVideoComponent", "onLayoutChange, innerVideoView=" + localObject1 + ", displayType=" + ((v)this.EcX).DYW);
      break label255;
      if (((v)this.EcX).DYW == 1)
      {
        if (((v)this.EcX).width / this.mEX > ((v)this.EcX).height / this.mEY)
        {
          j = this.mEX;
          i = (int)(j * ((v)this.EcX).height / ((v)this.EcX).width) + 1;
        }
        for (;;)
        {
          localObject2 = new RelativeLayout.LayoutParams(j, i);
          ((RelativeLayout.LayoutParams)localObject2).leftMargin = ((this.mEX - j) / 2);
          ((RelativeLayout.LayoutParams)localObject2).rightMargin = ((RelativeLayout.LayoutParams)localObject2).leftMargin;
          ((RelativeLayout.LayoutParams)localObject2).topMargin = ((this.mEY - i) / 2);
          ((RelativeLayout.LayoutParams)localObject2).bottomMargin = ((RelativeLayout.LayoutParams)localObject2).topMargin;
          ((ViewGroup)localObject1).setLayoutParams((ViewGroup.LayoutParams)localObject2);
          localView.setLayoutParams(new RelativeLayout.LayoutParams(this.mEX, this.mEY));
          break;
          i = this.mEY;
          j = (int)(i * ((v)this.EcX).width / ((v)this.EcX).height) + 1;
        }
      }
      if (((v)this.EcX).DYW != 2) {
        break label255;
      }
      localObject2 = new RelativeLayout.LayoutParams((int)((v)this.EcX).width, (int)((v)this.EcX).height);
      ((ViewGroup)localObject1).setLayoutParams((ViewGroup.LayoutParams)localObject2);
      localView.setLayoutParams(new RelativeLayout.LayoutParams((RelativeLayout.LayoutParams)localObject2));
      break label255;
      h.a("adId", ((v)this.EcX).DYR, false, 1000000001, new f.a()
      {
        public final void aNH(String paramAnonymousString)
        {
          AppMethodBeat.i(203032);
          ah.d(ah.this).aQV(paramAnonymousString);
          AppMethodBeat.o(203032);
        }
        
        public final void eWN() {}
        
        public final void eWO() {}
      });
    }
    label1568:
  }
  
  public final void fcJ()
  {
    AppMethodBeat.i(96723);
    super.fcJ();
    this.EeQ.setImageDrawable(com.tencent.mm.cb.a.l(this.context, 2131690469));
    this.EfZ.setMute(true);
    this.EeY = true;
    AppMethodBeat.o(96723);
  }
  
  public final void fcK()
  {
    AppMethodBeat.i(96724);
    super.fcK();
    this.EeQ.setImageDrawable(com.tencent.mm.cb.a.l(this.context, 2131690470));
    this.EfZ.setMute(false);
    this.EeY = false;
    AppMethodBeat.o(96724);
  }
  
  public final void fdF()
  {
    AppMethodBeat.i(96719);
    v localv = (v)this.EcX;
    if (Util.isNullOrNil(localv.DYS))
    {
      Log.e("MicroMsg.Sns.AdLandingPageSightVideoComponent", "on long video button click without streamVideoUrl!");
      AppMethodBeat.o(96719);
      return;
    }
    if (!(this.context instanceof Activity))
    {
      Log.e("MicroMsg.Sns.AdLandingPageSightVideoComponent", "on long video button click but context not activity!");
      AppMethodBeat.o(96719);
      return;
    }
    Log.v("MicroMsg.Sns.AdLandingPageSightVideoComponent", "on long video button click, jumpto [%s]", new Object[] { localv.DYS });
    Intent localIntent = new Intent();
    if (AdLandingPagesProxy.getInstance().getStreamVideoPlayerConfig() > 0)
    {
      localIntent.setClass(this.context, SnsAdStreamVideoPlayUI.class);
      Log.i("MicroMsg.Sns.AdLandingPageSightVideoComponent", "use new stream video play UI");
    }
    for (;;)
    {
      localIntent.putExtra("KFromTimeLine", true);
      localIntent.putExtra("KMediaId", MD5Util.getMD5String(localv.DYS));
      localIntent.putExtra("KThumUrl", localv.DYR);
      localIntent.putExtra("KStremVideoUrl", localv.DYS);
      localIntent.putExtra("ForceLandscape", true);
      localIntent.putExtra("ShareBtnHidden", 1);
      localIntent.putExtra("KComponentCid", fdn());
      ((Activity)this.context).startActivityForResult(localIntent, 2004);
      this.Ega += 1;
      AppMethodBeat.o(96719);
      return;
      localIntent.setClass(this.context, VideoAdPlayerUI.class);
    }
  }
  
  public final long fdo()
  {
    AppMethodBeat.i(203064);
    long l1 = super.fdo();
    long l2 = this.Egk;
    AppMethodBeat.o(203064);
    return l1 + l2;
  }
  
  public final void fdq()
  {
    AppMethodBeat.i(96731);
    super.fdq();
    String str = h.kz("adId", ((v)this.EcX).DYR);
    vi(false);
    if (s.YS(str))
    {
      this.EfZ.aQV(str);
      this.EfZ.d(false, 0.0F);
    }
    AppMethodBeat.o(96731);
  }
  
  protected final int getLayout()
  {
    return 2131496394;
  }
  
  public final boolean isPlaying()
  {
    AppMethodBeat.i(203051);
    boolean bool = this.EfZ.isPlaying();
    AppMethodBeat.o(203051);
    return bool;
  }
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(203055);
    Object localObject = new com.tencent.mm.hellhoundlib.b.b();
    ((com.tencent.mm.hellhoundlib.b.b)localObject).bm(paramView);
    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/AdLandingPageSightVideoComponent", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).axR());
    if (paramView.getId() == 2131308057) {
      Log.i("MicroMsg.Sns.AdLandingPageSightVideoComponent.VideoOptimize", "click full screen btn");
    }
    try
    {
      if ((this.context instanceof SnsAdNativeLandingPagesUI))
      {
        this.Egi += 1;
        this.hAk.removeCallbacks(this.Egg);
        this.Ege.setVisibility(8);
        paramView = (SnsAdNativeLandingPagesUI)this.context;
        b.Egv = (v)this.EcX;
        com.tencent.mm.plugin.sns.model.ae.DJT = fds();
        localObject = new Intent(paramView, VideoFullScreenActivity.class);
        ((Intent)localObject).putExtra("KComponentVideoType", 0);
        ((Intent)localObject).putExtra("KComponentCid", fdn());
        ((Intent)localObject).putExtra("KComponentCurrentTime", this.EfZ.getCurrentPositionMs());
        ((Intent)localObject).putExtra("KComponentTotalTime", this.EfZ.getDurationMs());
        ((Intent)localObject).putExtra("KComponentVoiceType", this.EeY);
        ((Intent)localObject).putExtra("KComponentProgressType", this.EfZ.isPlaying());
        ((Intent)localObject).putExtra("KComponentVideoSightThumbUrl", ((v)this.EcX).DYR);
        ((Intent)localObject).putExtra("KComponentStreamVideoUrlPath", ((v)this.EcX).DYQ);
        paramView.startActivityForResult((Intent)localObject, 2000);
      }
      for (;;)
      {
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/AdLandingPageSightVideoComponent", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(203055);
        return;
        this.Egd.setVisibility(8);
      }
    }
    catch (Throwable paramView)
    {
      for (;;)
      {
        this.Egd.setVisibility(8);
        Log.e("VideoFullScreenActivity", paramView.toString());
      }
    }
  }
  
  public final boolean onDoubleTap(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(203057);
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.bm(paramMotionEvent);
    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/AdLandingPageSightVideoComponent", "android/view/GestureDetector$OnDoubleTapListener", "onDoubleTap", "(Landroid/view/MotionEvent;)Z", this, localb.axR());
    for (;;)
    {
      try
      {
        Log.i("MicroMsg.Sns.AdLandingPageSightVideoComponent.VideoOptimize", "onDoubleTap");
        ay(this.EeU);
        if (this.hki) {
          this.Egh += 1;
        }
        if (!this.EfZ.isPlaying()) {
          continue;
        }
        vi(true);
        this.Eff = 4;
      }
      catch (Throwable paramMotionEvent)
      {
        Log.e("MicroMsg.Sns.AdLandingPageSightVideoComponent.VideoOptimize", paramMotionEvent.toString());
        continue;
        fcL();
        fcK();
        continue;
      }
      com.tencent.mm.hellhoundlib.a.a.a(false, this, "com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/AdLandingPageSightVideoComponent", "android/view/GestureDetector$OnDoubleTapListener", "onDoubleTap", "(Landroid/view/MotionEvent;)Z");
      AppMethodBeat.o(203057);
      return false;
      if (!this.EeY) {
        continue;
      }
      fcJ();
      czw();
      this.Eff = 3;
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
    AppMethodBeat.i(203059);
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.bm(paramMotionEvent);
    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/AdLandingPageSightVideoComponent", "android/view/GestureDetector$OnGestureListener", "onLongPress", "(Landroid/view/MotionEvent;)V", this, localb.axR());
    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/AdLandingPageSightVideoComponent", "android/view/GestureDetector$OnGestureListener", "onLongPress", "(Landroid/view/MotionEvent;)V");
    AppMethodBeat.o(203059);
  }
  
  public final boolean onScroll(MotionEvent paramMotionEvent1, MotionEvent paramMotionEvent2, float paramFloat1, float paramFloat2)
  {
    return false;
  }
  
  public final void onShowPress(MotionEvent paramMotionEvent) {}
  
  public final boolean onSingleTapConfirmed(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(203056);
    for (;;)
    {
      try
      {
        Log.i("MicroMsg.Sns.AdLandingPageSightVideoComponent.VideoOptimize", "onSingleTapConfirmed");
        bool = ((v)this.EcX).DZa;
        if (bool)
        {
          AppMethodBeat.o(203056);
          return false;
        }
        if (!this.hki) {
          continue;
        }
        if (this.EeP.getVisibility() != 0) {
          continue;
        }
        i = 1;
        if (i == 0) {
          continue;
        }
        this.EeP.setVisibility(4);
        this.Egd.setVisibility(4);
        this.hAk.removeCallbacks(this.EeU);
        if (this.Efk == null) {
          continue;
        }
        paramMotionEvent = this.Efk;
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
      paramMotionEvent.vg(bool);
      AppMethodBeat.o(203056);
      return false;
      i = 0;
      continue;
      this.EeP.setVisibility(0);
      this.Egd.setVisibility(0);
      ay(this.EeU);
    }
  }
  
  public final boolean onSingleTapUp(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(203058);
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.bm(paramMotionEvent);
    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/AdLandingPageSightVideoComponent", "android/view/GestureDetector$OnGestureListener", "onSingleTapUp", "(Landroid/view/MotionEvent;)Z", this, localb.axR());
    com.tencent.mm.hellhoundlib.a.a.a(false, this, "com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/AdLandingPageSightVideoComponent", "android/view/GestureDetector$OnGestureListener", "onSingleTapUp", "(Landroid/view/MotionEvent;)Z");
    AppMethodBeat.o(203058);
    return false;
  }
  
  @SuppressLint({"ClickableViewAccessibility"})
  public final boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(203054);
    paramView = this.jKk;
    paramMotionEvent = new com.tencent.mm.hellhoundlib.b.a().bl(paramMotionEvent);
    com.tencent.mm.hellhoundlib.a.a.a(paramView, paramMotionEvent.axQ(), "com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/AdLandingPageSightVideoComponent", "onTouch", "(Landroid/view/View;Landroid/view/MotionEvent;)Z", "android/view/GestureDetector_EXEC_", "onTouchEvent", "(Landroid/view/MotionEvent;)Z");
    boolean bool = com.tencent.mm.hellhoundlib.a.a.a(paramView, paramView.onTouchEvent((MotionEvent)paramMotionEvent.pG(0)), "com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/AdLandingPageSightVideoComponent", "onTouch", "(Landroid/view/View;Landroid/view/MotionEvent;)Z", "android/view/GestureDetector_EXEC_", "onTouchEvent", "(Landroid/view/MotionEvent;)Z");
    AppMethodBeat.o(203054);
    return bool;
  }
  
  final class a
    implements AudioManager.OnAudioFocusChangeListener
  {
    a() {}
    
    public final void onAudioFocusChange(int paramInt)
    {
      AppMethodBeat.i(203046);
      try
      {
        ah.YZ(paramInt);
        AppMethodBeat.o(203046);
        return;
      }
      catch (Throwable localThrowable)
      {
        Log.e("MicroMsg.Sns.AdLandingPageSightVideoComponent", "onAudioFocusChanged has something wrong!");
        AppMethodBeat.o(203046);
      }
    }
  }
  
  public static final class b
  {
    public static v Egv;
  }
  
  static final class c
  {
    int Dzo;
    String Egw;
    int Egx;
    long Egy;
    int Egz;
    int clickCount;
    long dUy;
  }
  
  final class d
    implements j.c
  {
    d() {}
    
    public final void fN(boolean paramBoolean)
    {
      AppMethodBeat.i(203047);
      Log.i("MicroMsg.Sns.AdLandingPageSightVideoComponent", "onSeekComplete is called");
      ah.B(ah.this).sendMessage();
      AppMethodBeat.o(203047);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.ah
 * JD-Core Version:    0.7.0.1
 */