package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component;

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
import android.widget.ImageView;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.a.rl;
import com.tencent.mm.plugin.sns.ad.d.e;
import com.tencent.mm.plugin.sns.b.f;
import com.tencent.mm.plugin.sns.b.g;
import com.tencent.mm.plugin.sns.b.i;
import com.tencent.mm.plugin.sns.data.l;
import com.tencent.mm.plugin.sns.data.m;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.aa;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.ai;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.ak;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.w;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.g.a;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.k;
import com.tencent.mm.plugin.sns.ui.OfflineVideoView;
import com.tencent.mm.plugin.sns.ui.OfflineVideoView.a;
import com.tencent.mm.plugin.sns.ui.SnsAdNativeLandingPagesUI;
import com.tencent.mm.plugin.sns.ui.SnsAdStreamVideoPlayUI;
import com.tencent.mm.plugin.sns.ui.VideoFullScreenActivity;
import com.tencent.mm.pluginsdk.ui.tools.VideoPlayerSeekBar;
import com.tencent.mm.pluginsdk.ui.tools.i.c;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MD5Util;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.NetStatusUtil;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.vfs.y;
import org.json.JSONException;
import org.json.JSONObject;

public final class aj
  extends com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.a
  implements GestureDetector.OnDoubleTapListener, GestureDetector.OnGestureListener, View.OnClickListener, View.OnTouchListener
{
  private com.tencent.mm.plugin.sight.decode.ui.b Aqj;
  private boolean Fey;
  private long LJG;
  private int LKo;
  private boolean PQA;
  boolean PQB;
  private boolean PQC;
  private int PQE;
  private int PQF;
  int PQG;
  private int PQH;
  private int PQI;
  int PQJ;
  private aq PQL;
  private Runnable PQR;
  private volatile int PQr;
  private View PQs;
  boolean PQx;
  boolean PQy;
  private boolean PQz;
  private int PSW;
  public int PWr;
  public int PWs;
  public int PWt;
  private OfflineVideoView QRB;
  private TextView QRC;
  int QRD;
  ImageView QRE;
  int QRF;
  private boolean QRG;
  private VideoPlayerSeekBar QRH;
  private ImageView QRI;
  private View QRJ;
  private volatile boolean QRK;
  private Runnable QRL;
  private View.OnClickListener QRM;
  private c QRN;
  private long QRO;
  private a QRP;
  public boolean QRQ;
  private View QRR;
  private int Qbs;
  Context context;
  private boolean isAutoPlay;
  private int length;
  private MMHandler mRi;
  private View maskView;
  int mbN;
  private boolean mvL;
  private GestureDetector nwZ;
  private String rPL;
  
  public aj(final Context paramContext, w paramw, ViewGroup paramViewGroup)
  {
    super(paramContext, paramw, paramViewGroup);
    AppMethodBeat.i(96717);
    this.LJG = 0L;
    this.PSW = 0;
    this.LKo = 0;
    this.PQE = 0;
    this.QRD = 0;
    this.PWr = 0;
    this.PWs = 0;
    this.PWt = 0;
    this.PQG = 0;
    this.PQJ = 0;
    this.PQB = true;
    this.QRF = 0;
    this.mbN = 0;
    this.PQr = 0;
    this.PQz = false;
    this.PQA = true;
    this.isAutoPlay = false;
    this.PQx = true;
    this.PQy = true;
    this.QRG = false;
    this.QRK = false;
    this.PQL = null;
    this.QRM = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(306883);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.cH(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/AdLandingPageSightVideoComponent$10", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
        for (;;)
        {
          try
          {
            Log.i("MicroMsg.Sns.AdLandingPageSightVideoComponent.VideoOptimize", "play btn onclick isPlaying[%b]", new Object[] { Boolean.valueOf(aj.this.isPlaying()) });
            aj.a(aj.this, aj.e(aj.this));
            if (!aj.this.isPlaying()) {
              continue;
            }
            aj.t(aj.this);
            aj.c(aj.this, 4);
            if (aj.v(aj.this)) {
              aj.w(aj.this);
            }
          }
          finally
          {
            Log.e("MicroMsg.Sns.AdLandingPageSightVideoComponent.VideoOptimize", paramAnonymousView.toString());
            continue;
            aj.this.hiA();
            aj.this.hax();
            continue;
          }
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/AdLandingPageSightVideoComponent$10", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(306883);
          return;
          if (!aj.this.PQB) {
            continue;
          }
          aj.this.haw();
          aj.u(aj.this);
          aj.c(aj.this, 3);
        }
      }
    };
    this.Aqj = new com.tencent.mm.plugin.sight.decode.ui.b()
    {
      public final void blc()
      {
        AppMethodBeat.i(306884);
        try
        {
          aj.a(aj.this, aj.e(aj.this));
          if (aj.d(aj.this) != null) {
            aj.d(aj.this).hmu();
          }
          AppMethodBeat.o(306884);
          return;
        }
        finally
        {
          Log.e("MicroMsg.Sns.AdLandingPageSightVideoComponent.VideoOptimize", localObject.toString());
          AppMethodBeat.o(306884);
        }
      }
      
      public final void tS(int paramAnonymousInt)
      {
        AppMethodBeat.i(306888);
        try
        {
          Log.i("MicroMsg.Sns.AdLandingPageSightVideoComponent.VideoOptimize", "onSeek time ".concat(String.valueOf(paramAnonymousInt)));
          if (aj.this.PQB) {
            aj.this.haw();
          }
          for (;;)
          {
            aj.d(aj.this).bK(paramAnonymousInt * 1000, true);
            aj.c(aj.this, 3);
            aj.b(aj.this, true);
            aj.y(aj.this).removeCallbacks(aj.x(aj.this));
            aj.b(aj.this).setVisibility(8);
            AppMethodBeat.o(306888);
            return;
            aj.this.hax();
          }
          return;
        }
        finally
        {
          Log.e("MicroMsg.Sns.AdLandingPageSightVideoComponent.VideoOptimize", localObject.toString());
          AppMethodBeat.o(306888);
        }
      }
      
      public final void tT(int paramAnonymousInt) {}
    };
    this.PQF = 0;
    this.PQH = 0;
    this.PQI = 0;
    this.QRO = 0L;
    this.QRQ = false;
    this.context = paramContext;
    this.mRi = new MMHandler(Looper.getMainLooper());
    try
    {
      this.nwZ = new GestureDetector(this);
      this.PQR = new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(306885);
          aj.a(aj.this);
          AppMethodBeat.o(306885);
        }
      };
      this.QRL = new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(306896);
          aj.b(aj.this).setVisibility(8);
          AppMethodBeat.o(306896);
        }
      };
      this.PQL = new aq()
      {
        public final void Do(boolean paramAnonymousBoolean)
        {
          AppMethodBeat.i(306901);
          try
          {
            Intent localIntent = new Intent("com.tencent.mm.adlanding.video_progressbar_change");
            if (paramAnonymousBoolean) {}
            for (int i = 1;; i = 0)
            {
              localIntent.putExtra("show", i);
              localIntent.putExtra("activity_code", aj.c(aj.this));
              androidx.i.a.a.al(paramContext).d(localIntent);
              AppMethodBeat.o(306901);
              return;
            }
            return;
          }
          finally
          {
            Log.e("MicroMsg.Sns.AdLandingPageSightVideoComponent", localObject.toString());
            AppMethodBeat.o(306901);
          }
        }
      };
      com.tencent.mm.plugin.report.service.h.OAn.kJ(1720, 4);
      e.a(paramw, false);
      AppMethodBeat.o(96717);
      return;
    }
    finally
    {
      for (;;)
      {
        Log.e("MicroMsg.Sns.AdLandingPageSightVideoComponent.VideoOptimize", paramContext.toString());
      }
    }
  }
  
  private void DV(boolean paramBoolean)
  {
    AppMethodBeat.i(306954);
    try
    {
      this.QRH.setIsPlay(paramBoolean);
      this.QRH.getPlayBtn().getLayoutParams().width = this.length;
      this.QRH.getPlayBtn().getLayoutParams().height = this.length;
      if (paramBoolean)
      {
        Log.i("MicroMsg.Sns.AdLandingPageSightVideoComponent.VideoOptimize", "startPlay");
        this.QRH.getPlayBtn().setImageDrawable(com.tencent.mm.cd.a.m(this.context, b.i.media_player_btn_cur_status_on));
        AppMethodBeat.o(306954);
        return;
      }
      Log.i("MicroMsg.Sns.AdLandingPageSightVideoComponent.VideoOptimize", "pausePlay");
      this.QRH.getPlayBtn().setImageDrawable(com.tencent.mm.cd.a.m(this.context, b.i.media_player_btn_cur_status_off));
      AppMethodBeat.o(306954);
      return;
    }
    finally
    {
      Log.e("MicroMsg.Sns.AdLandingPageSightVideoComponent.VideoOptimize", localObject.toString());
      AppMethodBeat.o(306954);
    }
  }
  
  private void Dt(final boolean paramBoolean)
  {
    AppMethodBeat.i(306978);
    Log.d("MicroMsg.Sns.AdLandingPageSightVideoComponent", "pause play");
    this.mRi.post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(306895);
        aj.d(aj.this).hmu();
        try
        {
          aj.b(aj.this, false);
          if ((aj.r(aj.this)) && (paramBoolean))
          {
            aj.b(aj.this).setVisibility(0);
            aj.a(aj.this, aj.x(aj.this));
          }
          AppMethodBeat.o(306895);
          return;
        }
        finally
        {
          Log.e("MicroMsg.Sns.AdLandingPageSightVideoComponent", localObject.toString());
          AppMethodBeat.o(306895);
        }
      }
    });
    if (this.LJG != 0L)
    {
      this.PSW = ((int)(this.PSW + (System.currentTimeMillis() - this.LJG)));
      this.LJG = 0L;
    }
    AppMethodBeat.o(306978);
  }
  
  private void aN(Runnable paramRunnable)
  {
    AppMethodBeat.i(306986);
    try
    {
      this.mRi.removeCallbacks(paramRunnable);
      this.mRi.postDelayed(paramRunnable, 4000L);
      AppMethodBeat.o(306986);
      return;
    }
    finally
    {
      Log.e("MicroMsg.Sns.AdLandingPageSightVideoComponent.VideoOptimize", paramRunnable.toString());
      AppMethodBeat.o(306986);
    }
  }
  
  public static void aZy(String paramString)
  {
    int i = 1;
    AppMethodBeat.i(306982);
    Object localObject = "0";
    for (;;)
    {
      try
      {
        if (y.ZC(paramString))
        {
          String str = "1";
          localObject = str;
          if (y.deleteFile(paramString))
          {
            localObject = str;
            paramString = NetStatusUtil.getFormatedNetType(MMApplicationContext.getContext());
            l.a(l.Qno, (String)localObject, 1, i, "http|".concat(String.valueOf(paramString)));
            AppMethodBeat.o(306982);
            return;
          }
        }
      }
      finally
      {
        Log.e("MicroMsg.Sns.AdLandingPageSightVideoComponent", "delErrorFile exp=" + paramString.toString());
        AppMethodBeat.o(306982);
        return;
      }
      i = 0;
    }
  }
  
  private void abandonAudioFocus()
  {
    AppMethodBeat.i(306996);
    try
    {
      if (this.QRP != null)
      {
        AudioManager localAudioManager = (AudioManager)this.context.getSystemService("audio");
        if (localAudioManager != null)
        {
          localAudioManager.abandonAudioFocus(this.QRP);
          this.QRP = null;
        }
      }
      AppMethodBeat.o(306996);
      return;
    }
    finally
    {
      Log.e("MicroMsg.Sns.AdLandingPageSightVideoComponent", "abandonAudioFocus has something wrong!");
      AppMethodBeat.o(306996);
    }
  }
  
  private void alg(final int paramInt)
  {
    AppMethodBeat.i(306958);
    try
    {
      this.mRi.post(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(306956);
          if (aj.n(aj.this) != null)
          {
            aj.n(aj.this).seek(paramInt);
            aj.b(aj.this, aj.this.isPlaying());
          }
          AppMethodBeat.o(306956);
        }
      });
      AppMethodBeat.o(306958);
      return;
    }
    finally
    {
      Log.e("MicroMsg.Sns.AdLandingPageSightVideoComponent.VideoOptimize", localObject.toString());
      AppMethodBeat.o(306958);
    }
  }
  
  private void bUf()
  {
    AppMethodBeat.i(306989);
    try
    {
      if (this.QRP == null)
      {
        this.QRP = new a();
        AudioManager localAudioManager = (AudioManager)this.context.getSystemService("audio");
        if (localAudioManager != null)
        {
          int i = localAudioManager.requestAudioFocus(this.QRP, 3, 2);
          if (i == 1) {
            return;
          }
          Log.i("MicroMsg.Sns.AdLandingPageSightVideoComponent", "requestAudioFocus is not granted. value = ".concat(String.valueOf(i)));
        }
      }
      AppMethodBeat.o(306989);
      return;
    }
    finally
    {
      Log.e("MicroMsg.Sns.AdLandingPageSightVideoComponent", "requestAudioFocus has something wrong!");
      AppMethodBeat.o(306989);
    }
  }
  
  private void drB()
  {
    AppMethodBeat.i(96721);
    if (this.QRG)
    {
      Log.i("MicroMsg.Sns.AdLandingPageSightVideoComponent", "last download fail ,try again");
      this.QRB.dSY();
      AppMethodBeat.o(96721);
      return;
    }
    Log.d("MicroMsg.Sns.AdLandingPageSightVideoComponent", "starting play");
    if ((!this.Fey) && (!TextUtils.isEmpty(this.rPL)))
    {
      this.QRB.auJ(this.rPL);
      this.Fey = true;
    }
    this.mRi.post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(306899);
        aj.d(aj.this).hmv();
        aj.z(aj.this);
        try
        {
          aj.b(aj.this, true);
          aj.y(aj.this).removeCallbacks(aj.x(aj.this));
          aj.b(aj.this).setVisibility(8);
          AppMethodBeat.o(306899);
          return;
        }
        finally
        {
          Log.e("MicroMsg.Sns.AdLandingPageSightVideoComponent", localObject.toString());
          AppMethodBeat.o(306899);
        }
      }
    });
    this.LJG = System.currentTimeMillis();
    this.LKo += 1;
    AppMethodBeat.o(96721);
  }
  
  private boolean hjA()
  {
    AppMethodBeat.i(96720);
    if (!Util.isNullOrNil(((w)this.QOV).QJD))
    {
      Intent localIntent = new Intent();
      localIntent.putExtra("sns_landig_pages_from_source", 14);
      localIntent.putExtra("sns_landig_pages_origin_from_source", hjn().QLu);
      localIntent.putExtra("sns_landing_pages_ux_info", hjn().uxInfo);
      localIntent.putExtra("sns_landing_pages_xml", "");
      localIntent.putExtra("sns_landing_pages_canvasid", ((w)this.QOV).QJD);
      localIntent.putExtra("sns_landing_pages_canvas_ext", ((w)this.QOV).QJE);
      localIntent.putExtra("sns_landing_pages_no_store", ((w)this.QOV).QJF);
      localIntent.putExtra("sns_landing_pages_need_enter_and_exit_animation", true);
      String str3;
      String str1;
      String str2;
      JSONObject localJSONObject;
      if (((this.context instanceof Activity)) && (hjn().bizId == 2))
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
          localJSONObject.put("cid", ((w)this.QOV).QKG);
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
        this.QRB.getLocationOnScreen((int[])localObject);
        localIntent.putExtra("img_gallery_top", localObject[1]);
        localIntent.putExtra("img_gallery_left", localObject[0]);
        localIntent.putExtra("img_gallery_width", this.QRB.getWidth());
        localIntent.putExtra("img_gallery_height", this.QRB.getHeight());
        com.tencent.mm.br.c.b(this.context, "sns", ".ui.SnsAdNativeLandingPagesPreviewUI", localIntent);
        AppMethodBeat.o(96720);
        return true;
        localObject = "";
      }
    }
    AppMethodBeat.o(96720);
    return false;
  }
  
  /* Error */
  public final void Gs()
  {
    // Byte code:
    //   0: ldc_w 727
    //   3: invokestatic 143	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: ldc_w 729
    //   9: aload_0
    //   10: getfield 545	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/aj:QOV	Lcom/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/aa;
    //   13: checkcast 547	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/w
    //   16: getfield 732	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/w:QKq	Ljava/lang/String;
    //   19: invokestatic 738	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/k:mC	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   22: invokestatic 406	com/tencent/mm/vfs/y:ZC	(Ljava/lang/String;)Z
    //   25: ifne +8 -> 33
    //   28: aload_0
    //   29: iconst_0
    //   30: putfield 179	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/aj:PQx	Z
    //   33: new 445	java/lang/StringBuilder
    //   36: dup
    //   37: invokespecial 739	java/lang/StringBuilder:<init>	()V
    //   40: invokestatic 744	com/tencent/mm/loader/i/b:bmz	()Ljava/lang/String;
    //   43: invokevirtual 453	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   46: ldc_w 746
    //   49: invokevirtual 453	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   52: aload_0
    //   53: getfield 545	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/aj:QOV	Lcom/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/aa;
    //   56: checkcast 547	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/w
    //   59: getfield 749	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/w:QKp	Ljava/lang/String;
    //   62: invokestatic 754	com/tencent/mm/sdk/platformtools/MD5Util:getMD5String	(Ljava/lang/String;)Ljava/lang/String;
    //   65: invokevirtual 453	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   68: invokevirtual 454	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   71: invokestatic 406	com/tencent/mm/vfs/y:ZC	(Ljava/lang/String;)Z
    //   74: ifne +8 -> 82
    //   77: aload_0
    //   78: iconst_0
    //   79: putfield 181	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/aj:PQy	Z
    //   82: aload_0
    //   83: getfield 757	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/aj:contentView	Landroid/view/View;
    //   86: getstatic 762	com/tencent/mm/plugin/sns/b$f:sns_ad_native_landing_pages_item_video_container	I
    //   89: invokevirtual 768	android/view/View:findViewById	(I)Landroid/view/View;
    //   92: astore 4
    //   94: aload_0
    //   95: aload 4
    //   97: putfield 273	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/aj:PQs	Landroid/view/View;
    //   100: aload 4
    //   102: getstatic 771	com/tencent/mm/plugin/sns/b$f:sns_ad_native_landing_pages_item_sight_container	I
    //   105: invokevirtual 768	android/view/View:findViewById	(I)Landroid/view/View;
    //   108: checkcast 773	android/view/ViewGroup
    //   111: astore 5
    //   113: aload_0
    //   114: new 521	com/tencent/mm/plugin/sns/ui/OfflineVideoView
    //   117: dup
    //   118: aload_0
    //   119: getfield 207	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/aj:context	Landroid/content/Context;
    //   122: invokespecial 776	com/tencent/mm/plugin/sns/ui/OfflineVideoView:<init>	(Landroid/content/Context;)V
    //   125: putfield 515	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/aj:QRB	Lcom/tencent/mm/plugin/sns/ui/OfflineVideoView;
    //   128: aload_0
    //   129: getfield 515	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/aj:QRB	Lcom/tencent/mm/plugin/sns/ui/OfflineVideoView;
    //   132: iconst_1
    //   133: invokevirtual 779	com/tencent/mm/plugin/sns/ui/OfflineVideoView:setSource	(I)V
    //   136: aload_0
    //   137: aload 5
    //   139: putfield 781	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/aj:QRR	Landroid/view/View;
    //   142: aload 5
    //   144: aload_0
    //   145: getfield 515	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/aj:QRB	Lcom/tencent/mm/plugin/sns/ui/OfflineVideoView;
    //   148: new 783	android/widget/LinearLayout$LayoutParams
    //   151: dup
    //   152: iconst_m1
    //   153: iconst_m1
    //   154: invokespecial 785	android/widget/LinearLayout$LayoutParams:<init>	(II)V
    //   157: invokevirtual 789	android/view/ViewGroup:addView	(Landroid/view/View;Landroid/view/ViewGroup$LayoutParams;)V
    //   160: aload_0
    //   161: getfield 545	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/aj:QOV	Lcom/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/aa;
    //   164: checkcast 547	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/w
    //   167: getfield 792	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/w:QKu	I
    //   170: ifne +1219 -> 1389
    //   173: aload_0
    //   174: getfield 545	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/aj:QOV	Lcom/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/aa;
    //   177: checkcast 547	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/w
    //   180: getfield 795	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/w:width	F
    //   183: f2i
    //   184: ifle +1083 -> 1267
    //   187: aload_0
    //   188: getfield 798	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/aj:sJv	I
    //   191: istore_1
    //   192: new 800	android/widget/RelativeLayout$LayoutParams
    //   195: dup
    //   196: iload_1
    //   197: iload_1
    //   198: i2f
    //   199: aload_0
    //   200: getfield 545	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/aj:QOV	Lcom/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/aa;
    //   203: checkcast 547	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/w
    //   206: getfield 802	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/w:height	F
    //   209: fmul
    //   210: aload_0
    //   211: getfield 545	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/aj:QOV	Lcom/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/aa;
    //   214: checkcast 547	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/w
    //   217: getfield 795	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/w:width	F
    //   220: fdiv
    //   221: f2i
    //   222: invokespecial 803	android/widget/RelativeLayout$LayoutParams:<init>	(II)V
    //   225: astore 6
    //   227: aload 5
    //   229: aload 6
    //   231: invokevirtual 807	android/view/ViewGroup:setLayoutParams	(Landroid/view/ViewGroup$LayoutParams;)V
    //   234: aload 4
    //   236: aload 6
    //   238: invokevirtual 808	android/view/View:setLayoutParams	(Landroid/view/ViewGroup$LayoutParams;)V
    //   241: aload_0
    //   242: getfield 545	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/aj:QOV	Lcom/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/aa;
    //   245: checkcast 547	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/w
    //   248: getfield 811	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/w:QKv	Z
    //   251: ifne +1059 -> 1310
    //   254: ldc_w 337
    //   257: ldc_w 813
    //   260: invokestatic 268	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   263: aload_0
    //   264: getfield 515	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/aj:QRB	Lcom/tencent/mm/plugin/sns/ui/OfflineVideoView;
    //   267: invokevirtual 817	com/tencent/mm/plugin/sns/ui/OfflineVideoView:getInnerVideoView	()Landroid/view/View;
    //   270: astore 5
    //   272: aload 5
    //   274: instanceof 819
    //   277: ifeq +18 -> 295
    //   280: aload 5
    //   282: new 46	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/aj$7
    //   285: dup
    //   286: aload_0
    //   287: aload 5
    //   289: invokespecial 822	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/aj$7:<init>	(Lcom/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/aj;Landroid/view/View;)V
    //   292: invokevirtual 826	android/view/View:addOnLayoutChangeListener	(Landroid/view/View$OnLayoutChangeListener;)V
    //   295: ldc_w 337
    //   298: new 445	java/lang/StringBuilder
    //   301: dup
    //   302: ldc_w 828
    //   305: invokespecial 449	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   308: aload_0
    //   309: getfield 545	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/aj:QOV	Lcom/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/aa;
    //   312: checkcast 547	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/w
    //   315: getfield 792	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/w:QKu	I
    //   318: invokevirtual 831	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   321: invokevirtual 454	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   324: invokestatic 313	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   327: ldc_w 729
    //   330: aload_0
    //   331: getfield 545	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/aj:QOV	Lcom/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/aa;
    //   334: checkcast 547	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/w
    //   337: getfield 732	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/w:QKq	Ljava/lang/String;
    //   340: invokestatic 738	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/k:mC	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   343: astore 5
    //   345: aload 5
    //   347: invokestatic 406	com/tencent/mm/vfs/y:ZC	(Ljava/lang/String;)Z
    //   350: ifeq +1314 -> 1664
    //   353: aload_0
    //   354: getfield 515	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/aj:QRB	Lcom/tencent/mm/plugin/sns/ui/OfflineVideoView;
    //   357: aload 5
    //   359: invokevirtual 834	com/tencent/mm/plugin/sns/ui/OfflineVideoView:bax	(Ljava/lang/String;)V
    //   362: aload_0
    //   363: aload 4
    //   365: getstatic 837	com/tencent/mm/plugin/sns/b$f:errorTv	I
    //   368: invokevirtual 768	android/view/View:findViewById	(I)Landroid/view/View;
    //   371: checkcast 839	android/widget/TextView
    //   374: putfield 841	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/aj:QRC	Landroid/widget/TextView;
    //   377: aload_0
    //   378: getfield 841	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/aj:QRC	Landroid/widget/TextView;
    //   381: aload_0
    //   382: getfield 207	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/aj:context	Landroid/content/Context;
    //   385: getstatic 846	com/tencent/mm/plugin/sns/b$j:download_fail	I
    //   388: invokevirtual 849	android/content/Context:getString	(I)Ljava/lang/String;
    //   391: invokevirtual 853	android/widget/TextView:setText	(Ljava/lang/CharSequence;)V
    //   394: aload_0
    //   395: aload 4
    //   397: getstatic 856	com/tencent/mm/plugin/sns/b$f:sns_ad_native_landing_pages_sight_background	I
    //   400: invokevirtual 768	android/view/View:findViewById	(I)Landroid/view/View;
    //   403: putfield 858	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/aj:maskView	Landroid/view/View;
    //   406: aload_0
    //   407: getfield 858	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/aj:maskView	Landroid/view/View;
    //   410: ifnull +57 -> 467
    //   413: new 800	android/widget/RelativeLayout$LayoutParams
    //   416: dup
    //   417: iconst_m1
    //   418: iconst_m1
    //   419: invokespecial 803	android/widget/RelativeLayout$LayoutParams:<init>	(II)V
    //   422: astore 5
    //   424: aload_0
    //   425: getfield 858	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/aj:maskView	Landroid/view/View;
    //   428: invokevirtual 862	android/view/View:getParent	()Landroid/view/ViewParent;
    //   431: astore 6
    //   433: aload 6
    //   435: instanceof 773
    //   438: ifeq +15 -> 453
    //   441: aload 6
    //   443: checkcast 773	android/view/ViewGroup
    //   446: aload_0
    //   447: getfield 858	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/aj:maskView	Landroid/view/View;
    //   450: invokevirtual 866	android/view/ViewGroup:removeView	(Landroid/view/View;)V
    //   453: aload 4
    //   455: checkcast 773	android/view/ViewGroup
    //   458: aload_0
    //   459: getfield 858	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/aj:maskView	Landroid/view/View;
    //   462: aload 5
    //   464: invokevirtual 789	android/view/ViewGroup:addView	(Landroid/view/View;Landroid/view/ViewGroup$LayoutParams;)V
    //   467: aload_0
    //   468: aload 4
    //   470: getstatic 869	com/tencent/mm/plugin/sns/b$f:sns_ad_native_landing_pages_sight_voice_btn	I
    //   473: invokevirtual 768	android/view/View:findViewById	(I)Landroid/view/View;
    //   476: checkcast 295	android/widget/ImageView
    //   479: putfield 871	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/aj:QRE	Landroid/widget/ImageView;
    //   482: aload_0
    //   483: getfield 871	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/aj:QRE	Landroid/widget/ImageView;
    //   486: iconst_0
    //   487: invokevirtual 373	android/widget/ImageView:setVisibility	(I)V
    //   490: aload_0
    //   491: getfield 871	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/aj:QRE	Landroid/widget/ImageView;
    //   494: new 18	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/aj$11
    //   497: dup
    //   498: aload_0
    //   499: invokespecial 872	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/aj$11:<init>	(Lcom/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/aj;)V
    //   502: invokevirtual 876	android/widget/ImageView:setOnClickListener	(Landroid/view/View$OnClickListener;)V
    //   505: aload_0
    //   506: getfield 871	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/aj:QRE	Landroid/widget/ImageView;
    //   509: invokevirtual 877	android/widget/ImageView:getParent	()Landroid/view/ViewParent;
    //   512: astore 5
    //   514: aload 5
    //   516: instanceof 773
    //   519: ifeq +15 -> 534
    //   522: aload 5
    //   524: checkcast 773	android/view/ViewGroup
    //   527: aload_0
    //   528: getfield 871	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/aj:QRE	Landroid/widget/ImageView;
    //   531: invokevirtual 866	android/view/ViewGroup:removeView	(Landroid/view/View;)V
    //   534: aload_0
    //   535: getfield 871	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/aj:QRE	Landroid/widget/ImageView;
    //   538: invokevirtual 299	android/widget/ImageView:getLayoutParams	()Landroid/view/ViewGroup$LayoutParams;
    //   541: checkcast 800	android/widget/RelativeLayout$LayoutParams
    //   544: astore 5
    //   546: aload 5
    //   548: aload_0
    //   549: getfield 207	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/aj:context	Landroid/content/Context;
    //   552: bipush 8
    //   554: invokestatic 881	com/tencent/mm/cd/a:fromDPToPix	(Landroid/content/Context;I)I
    //   557: putfield 884	android/widget/RelativeLayout$LayoutParams:bottomMargin	I
    //   560: aload 5
    //   562: aload_0
    //   563: getfield 207	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/aj:context	Landroid/content/Context;
    //   566: bipush 10
    //   568: invokestatic 881	com/tencent/mm/cd/a:fromDPToPix	(Landroid/content/Context;I)I
    //   571: putfield 887	android/widget/RelativeLayout$LayoutParams:rightMargin	I
    //   574: aload 4
    //   576: checkcast 773	android/view/ViewGroup
    //   579: aload_0
    //   580: getfield 871	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/aj:QRE	Landroid/widget/ImageView;
    //   583: aload 5
    //   585: invokevirtual 789	android/view/ViewGroup:addView	(Landroid/view/View;Landroid/view/ViewGroup$LayoutParams;)V
    //   588: ldc_w 256
    //   591: ldc_w 889
    //   594: invokestatic 313	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   597: aload_0
    //   598: getfield 515	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/aj:QRB	Lcom/tencent/mm/plugin/sns/ui/OfflineVideoView;
    //   601: new 20	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/aj$12
    //   604: dup
    //   605: aload_0
    //   606: invokespecial 890	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/aj$12:<init>	(Lcom/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/aj;)V
    //   609: invokevirtual 894	com/tencent/mm/plugin/sns/ui/OfflineVideoView:setVideoCallback	(Lcom/tencent/mm/plugin/sns/ui/OfflineVideoView$a;)V
    //   612: aload_0
    //   613: getfield 515	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/aj:QRB	Lcom/tencent/mm/plugin/sns/ui/OfflineVideoView;
    //   616: new 61	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/aj$d
    //   619: dup
    //   620: aload_0
    //   621: invokespecial 895	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/aj$d:<init>	(Lcom/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/aj;)V
    //   624: invokevirtual 899	com/tencent/mm/plugin/sns/ui/OfflineVideoView:setOnSeekCompleteCallback	(Lcom/tencent/mm/pluginsdk/ui/tools/i$c;)V
    //   627: aload_0
    //   628: getfield 871	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/aj:QRE	Landroid/widget/ImageView;
    //   631: bipush 8
    //   633: invokevirtual 373	android/widget/ImageView:setVisibility	(I)V
    //   636: aload_0
    //   637: getfield 515	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/aj:QRB	Lcom/tencent/mm/plugin/sns/ui/OfflineVideoView;
    //   640: new 30	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/aj$13
    //   643: dup
    //   644: aload_0
    //   645: invokespecial 900	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/aj$13:<init>	(Lcom/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/aj;)V
    //   648: invokevirtual 901	android/view/View:setOnClickListener	(Landroid/view/View$OnClickListener;)V
    //   651: aload_0
    //   652: getfield 545	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/aj:QOV	Lcom/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/aa;
    //   655: checkcast 547	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/w
    //   658: astore 5
    //   660: aload 5
    //   662: getfield 904	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/w:subType	I
    //   665: iconst_1
    //   666: if_icmpne +1041 -> 1707
    //   669: aload 5
    //   671: getfield 907	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/w:QKr	Ljava/lang/String;
    //   674: invokevirtual 909	java/lang/String:length	()I
    //   677: ifle +1030 -> 1707
    //   680: aload 5
    //   682: getfield 912	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/w:PSB	Ljava/lang/String;
    //   685: invokevirtual 909	java/lang/String:length	()I
    //   688: ifle +1019 -> 1707
    //   691: iconst_1
    //   692: istore_1
    //   693: iload_1
    //   694: ifeq +98 -> 792
    //   697: aload_0
    //   698: getfield 757	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/aj:contentView	Landroid/view/View;
    //   701: getstatic 915	com/tencent/mm/plugin/sns/b$f:sns_ad_native_landing_pages_item_stream_video_click_area	I
    //   704: invokevirtual 768	android/view/View:findViewById	(I)Landroid/view/View;
    //   707: astore 5
    //   709: aload 5
    //   711: iconst_0
    //   712: invokevirtual 916	android/view/View:setVisibility	(I)V
    //   715: aload 5
    //   717: getstatic 919	com/tencent/mm/plugin/sns/b$f:sns_ad_native_landing_pages_item_stream_video_click_area_button	I
    //   720: invokevirtual 768	android/view/View:findViewById	(I)Landroid/view/View;
    //   723: checkcast 921	android/widget/Button
    //   726: astore 6
    //   728: aload 6
    //   730: aload_0
    //   731: getfield 545	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/aj:QOV	Lcom/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/aa;
    //   734: checkcast 547	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/w
    //   737: getfield 924	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/w:QKs	I
    //   740: invokevirtual 927	android/widget/Button:setTextColor	(I)V
    //   743: aload 6
    //   745: aload_0
    //   746: getfield 545	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/aj:QOV	Lcom/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/aa;
    //   749: checkcast 547	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/w
    //   752: getfield 907	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/w:QKr	Ljava/lang/String;
    //   755: invokevirtual 928	android/widget/Button:setText	(Ljava/lang/CharSequence;)V
    //   758: aload 6
    //   760: new 32	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/aj$14
    //   763: dup
    //   764: aload_0
    //   765: invokespecial 929	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/aj$14:<init>	(Lcom/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/aj;)V
    //   768: invokevirtual 930	android/widget/Button:setOnClickListener	(Landroid/view/View$OnClickListener;)V
    //   771: aload 5
    //   773: getstatic 933	com/tencent/mm/plugin/sns/b$f:sns_ad_native_landing_pages_item_stream_video_click_area_separator	I
    //   776: invokevirtual 768	android/view/View:findViewById	(I)Landroid/view/View;
    //   779: aload_0
    //   780: getfield 545	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/aj:QOV	Lcom/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/aa;
    //   783: checkcast 547	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/w
    //   786: getfield 936	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/w:QKt	I
    //   789: invokevirtual 939	android/view/View:setBackgroundColor	(I)V
    //   792: aload_0
    //   793: aload_0
    //   794: getfield 207	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/aj:context	Landroid/content/Context;
    //   797: bipush 32
    //   799: invokestatic 881	com/tencent/mm/cd/a:fromDPToPix	(Landroid/content/Context;I)I
    //   802: putfield 301	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/aj:length	I
    //   805: aload_0
    //   806: getfield 515	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/aj:QRB	Lcom/tencent/mm/plugin/sns/ui/OfflineVideoView;
    //   809: aload_0
    //   810: invokevirtual 943	com/tencent/mm/plugin/sns/ui/OfflineVideoView:setOnTouchListener	(Landroid/view/View$OnTouchListener;)V
    //   813: aload_0
    //   814: aload 4
    //   816: getstatic 946	com/tencent/mm/plugin/sns/b$f:sns_ad_native_landing_pages_sight_video_full_screen_btn	I
    //   819: invokevirtual 768	android/view/View:findViewById	(I)Landroid/view/View;
    //   822: checkcast 295	android/widget/ImageView
    //   825: putfield 372	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/aj:QRI	Landroid/widget/ImageView;
    //   828: aload_0
    //   829: getfield 372	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/aj:QRI	Landroid/widget/ImageView;
    //   832: invokevirtual 877	android/widget/ImageView:getParent	()Landroid/view/ViewParent;
    //   835: astore 5
    //   837: aload 5
    //   839: instanceof 773
    //   842: ifeq +15 -> 857
    //   845: aload 5
    //   847: checkcast 773	android/view/ViewGroup
    //   850: aload_0
    //   851: getfield 372	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/aj:QRI	Landroid/widget/ImageView;
    //   854: invokevirtual 866	android/view/ViewGroup:removeView	(Landroid/view/View;)V
    //   857: aload_0
    //   858: getfield 372	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/aj:QRI	Landroid/widget/ImageView;
    //   861: invokevirtual 299	android/widget/ImageView:getLayoutParams	()Landroid/view/ViewGroup$LayoutParams;
    //   864: checkcast 800	android/widget/RelativeLayout$LayoutParams
    //   867: astore 5
    //   869: aload 5
    //   871: aload_0
    //   872: getfield 207	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/aj:context	Landroid/content/Context;
    //   875: bipush 8
    //   877: invokestatic 881	com/tencent/mm/cd/a:fromDPToPix	(Landroid/content/Context;I)I
    //   880: putfield 884	android/widget/RelativeLayout$LayoutParams:bottomMargin	I
    //   883: aload 5
    //   885: aload_0
    //   886: getfield 207	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/aj:context	Landroid/content/Context;
    //   889: bipush 10
    //   891: invokestatic 881	com/tencent/mm/cd/a:fromDPToPix	(Landroid/content/Context;I)I
    //   894: putfield 887	android/widget/RelativeLayout$LayoutParams:rightMargin	I
    //   897: aload 4
    //   899: checkcast 773	android/view/ViewGroup
    //   902: aload_0
    //   903: getfield 372	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/aj:QRI	Landroid/widget/ImageView;
    //   906: aload 5
    //   908: invokevirtual 789	android/view/ViewGroup:addView	(Landroid/view/View;Landroid/view/ViewGroup$LayoutParams;)V
    //   911: aload_0
    //   912: getfield 372	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/aj:QRI	Landroid/widget/ImageView;
    //   915: aload_0
    //   916: invokevirtual 876	android/widget/ImageView:setOnClickListener	(Landroid/view/View$OnClickListener;)V
    //   919: aload_0
    //   920: getfield 372	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/aj:QRI	Landroid/widget/ImageView;
    //   923: bipush 8
    //   925: invokevirtual 373	android/widget/ImageView:setVisibility	(I)V
    //   928: ldc_w 256
    //   931: ldc_w 948
    //   934: invokestatic 313	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   937: aload_0
    //   938: new 286	com/tencent/mm/pluginsdk/ui/tools/VideoPlayerSeekBar
    //   941: dup
    //   942: aload_0
    //   943: getfield 207	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/aj:context	Landroid/content/Context;
    //   946: invokespecial 949	com/tencent/mm/pluginsdk/ui/tools/VideoPlayerSeekBar:<init>	(Landroid/content/Context;)V
    //   949: putfield 284	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/aj:QRH	Lcom/tencent/mm/pluginsdk/ui/tools/VideoPlayerSeekBar;
    //   952: aload_0
    //   953: getfield 284	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/aj:QRH	Lcom/tencent/mm/pluginsdk/ui/tools/VideoPlayerSeekBar;
    //   956: invokevirtual 950	com/tencent/mm/pluginsdk/ui/tools/VideoPlayerSeekBar:getParent	()Landroid/view/ViewParent;
    //   959: astore 5
    //   961: aload 5
    //   963: instanceof 773
    //   966: ifeq +15 -> 981
    //   969: aload 5
    //   971: checkcast 773	android/view/ViewGroup
    //   974: aload_0
    //   975: getfield 284	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/aj:QRH	Lcom/tencent/mm/pluginsdk/ui/tools/VideoPlayerSeekBar;
    //   978: invokevirtual 866	android/view/ViewGroup:removeView	(Landroid/view/View;)V
    //   981: new 800	android/widget/RelativeLayout$LayoutParams
    //   984: dup
    //   985: aload_0
    //   986: getfield 781	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/aj:QRR	Landroid/view/View;
    //   989: invokevirtual 951	android/view/View:getLayoutParams	()Landroid/view/ViewGroup$LayoutParams;
    //   992: getfield 306	android/view/ViewGroup$LayoutParams:width	I
    //   995: aload_0
    //   996: getfield 207	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/aj:context	Landroid/content/Context;
    //   999: bipush 75
    //   1001: invokestatic 881	com/tencent/mm/cd/a:fromDPToPix	(Landroid/content/Context;I)I
    //   1004: isub
    //   1005: bipush 254
    //   1007: invokespecial 803	android/widget/RelativeLayout$LayoutParams:<init>	(II)V
    //   1010: astore 5
    //   1012: aload 5
    //   1014: bipush 12
    //   1016: invokevirtual 954	android/widget/RelativeLayout$LayoutParams:addRule	(I)V
    //   1019: aload 5
    //   1021: aload_0
    //   1022: getfield 207	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/aj:context	Landroid/content/Context;
    //   1025: iconst_3
    //   1026: invokestatic 881	com/tencent/mm/cd/a:fromDPToPix	(Landroid/content/Context;I)I
    //   1029: putfield 884	android/widget/RelativeLayout$LayoutParams:bottomMargin	I
    //   1032: aload_0
    //   1033: getfield 284	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/aj:QRH	Lcom/tencent/mm/pluginsdk/ui/tools/VideoPlayerSeekBar;
    //   1036: aload 5
    //   1038: invokevirtual 955	com/tencent/mm/pluginsdk/ui/tools/VideoPlayerSeekBar:setLayoutParams	(Landroid/view/ViewGroup$LayoutParams;)V
    //   1041: aload_0
    //   1042: getfield 757	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/aj:contentView	Landroid/view/View;
    //   1045: getstatic 958	com/tencent/mm/plugin/sns/b$f:content_root	I
    //   1048: invokevirtual 768	android/view/View:findViewById	(I)Landroid/view/View;
    //   1051: checkcast 773	android/view/ViewGroup
    //   1054: aload_0
    //   1055: getfield 284	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/aj:QRH	Lcom/tencent/mm/pluginsdk/ui/tools/VideoPlayerSeekBar;
    //   1058: aload 5
    //   1060: invokevirtual 789	android/view/ViewGroup:addView	(Landroid/view/View;Landroid/view/ViewGroup$LayoutParams;)V
    //   1063: aload_0
    //   1064: iconst_0
    //   1065: invokespecial 491	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/aj:alg	(I)V
    //   1068: aload_0
    //   1069: getfield 284	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/aj:QRH	Lcom/tencent/mm/pluginsdk/ui/tools/VideoPlayerSeekBar;
    //   1072: aload_0
    //   1073: getfield 192	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/aj:QRM	Landroid/view/View$OnClickListener;
    //   1076: invokevirtual 961	com/tencent/mm/pluginsdk/ui/tools/VideoPlayerSeekBar:setOnPlayButtonClickListener	(Landroid/view/View$OnClickListener;)V
    //   1079: aload_0
    //   1080: getfield 284	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/aj:QRH	Lcom/tencent/mm/pluginsdk/ui/tools/VideoPlayerSeekBar;
    //   1083: aload_0
    //   1084: getfield 195	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/aj:Aqj	Lcom/tencent/mm/plugin/sight/decode/ui/b;
    //   1087: invokevirtual 965	com/tencent/mm/pluginsdk/ui/tools/VideoPlayerSeekBar:setIplaySeekCallback	(Lcom/tencent/mm/plugin/sight/decode/ui/b;)V
    //   1090: aload_0
    //   1091: getfield 284	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/aj:QRH	Lcom/tencent/mm/pluginsdk/ui/tools/VideoPlayerSeekBar;
    //   1094: iconst_4
    //   1095: invokevirtual 370	com/tencent/mm/pluginsdk/ui/tools/VideoPlayerSeekBar:setVisibility	(I)V
    //   1098: aload_0
    //   1099: getfield 187	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/aj:PQL	Lcom/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/aq;
    //   1102: ifnull +29 -> 1131
    //   1105: aload_0
    //   1106: getfield 187	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/aj:PQL	Lcom/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/aq;
    //   1109: astore 5
    //   1111: aload_0
    //   1112: getfield 284	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/aj:QRH	Lcom/tencent/mm/pluginsdk/ui/tools/VideoPlayerSeekBar;
    //   1115: invokevirtual 367	com/tencent/mm/pluginsdk/ui/tools/VideoPlayerSeekBar:getVisibility	()I
    //   1118: ifne +610 -> 1728
    //   1121: iconst_1
    //   1122: istore_3
    //   1123: aload 5
    //   1125: iload_3
    //   1126: invokeinterface 378 2 0
    //   1131: ldc_w 256
    //   1134: ldc_w 967
    //   1137: invokestatic 313	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   1140: aload_0
    //   1141: aload 4
    //   1143: getstatic 970	com/tencent/mm/plugin/sns/b$f:pause_video_container	I
    //   1146: invokevirtual 768	android/view/View:findViewById	(I)Landroid/view/View;
    //   1149: putfield 488	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/aj:QRJ	Landroid/view/View;
    //   1152: aload_0
    //   1153: getfield 488	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/aj:QRJ	Landroid/view/View;
    //   1156: bipush 8
    //   1158: invokevirtual 916	android/view/View:setVisibility	(I)V
    //   1161: ldc_w 337
    //   1164: new 445	java/lang/StringBuilder
    //   1167: dup
    //   1168: ldc_w 972
    //   1171: invokespecial 449	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   1174: aload_0
    //   1175: getfield 545	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/aj:QOV	Lcom/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/aa;
    //   1178: checkcast 547	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/w
    //   1181: getfield 975	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/w:QKw	Z
    //   1184: invokevirtual 978	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   1187: ldc_w 980
    //   1190: invokevirtual 453	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1193: aload_0
    //   1194: getfield 545	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/aj:QOV	Lcom/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/aa;
    //   1197: checkcast 547	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/w
    //   1200: getfield 983	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/w:QKx	Z
    //   1203: invokevirtual 978	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   1206: invokevirtual 454	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1209: invokestatic 313	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   1212: aload_0
    //   1213: getfield 545	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/aj:QOV	Lcom/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/aa;
    //   1216: checkcast 547	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/w
    //   1219: getfield 975	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/w:QKw	Z
    //   1222: ifeq +543 -> 1765
    //   1225: getstatic 242	com/tencent/mm/plugin/report/service/h:OAn	Lcom/tencent/mm/plugin/report/service/h;
    //   1228: sipush 1720
    //   1231: bipush 20
    //   1233: invokevirtual 246	com/tencent/mm/plugin/report/service/h:kJ	(II)V
    //   1236: aload_0
    //   1237: getfield 545	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/aj:QOV	Lcom/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/aa;
    //   1240: checkcast 547	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/w
    //   1243: getfield 983	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/w:QKx	Z
    //   1246: ifeq +14 -> 1260
    //   1249: getstatic 242	com/tencent/mm/plugin/report/service/h:OAn	Lcom/tencent/mm/plugin/report/service/h;
    //   1252: sipush 1720
    //   1255: bipush 22
    //   1257: invokevirtual 246	com/tencent/mm/plugin/report/service/h:kJ	(II)V
    //   1260: ldc_w 727
    //   1263: invokestatic 254	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   1266: return
    //   1267: aload 5
    //   1269: new 800	android/widget/RelativeLayout$LayoutParams
    //   1272: dup
    //   1273: aload_0
    //   1274: getfield 798	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/aj:sJv	I
    //   1277: aload_0
    //   1278: getfield 986	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/aj:pvg	I
    //   1281: invokespecial 803	android/widget/RelativeLayout$LayoutParams:<init>	(II)V
    //   1284: invokevirtual 807	android/view/ViewGroup:setLayoutParams	(Landroid/view/ViewGroup$LayoutParams;)V
    //   1287: aload 4
    //   1289: new 800	android/widget/RelativeLayout$LayoutParams
    //   1292: dup
    //   1293: aload_0
    //   1294: getfield 798	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/aj:sJv	I
    //   1297: aload_0
    //   1298: getfield 986	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/aj:pvg	I
    //   1301: invokespecial 803	android/widget/RelativeLayout$LayoutParams:<init>	(II)V
    //   1304: invokevirtual 808	android/view/View:setLayoutParams	(Landroid/view/ViewGroup$LayoutParams;)V
    //   1307: goto -1066 -> 241
    //   1310: aload_0
    //   1311: getfield 515	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/aj:QRB	Lcom/tencent/mm/plugin/sns/ui/OfflineVideoView;
    //   1314: invokevirtual 817	com/tencent/mm/plugin/sns/ui/OfflineVideoView:getInnerVideoView	()Landroid/view/View;
    //   1317: astore 5
    //   1319: aload 5
    //   1321: instanceof 819
    //   1324: ifeq +19 -> 1343
    //   1327: aload 5
    //   1329: new 44	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/aj$6
    //   1332: dup
    //   1333: aload_0
    //   1334: invokespecial 987	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/aj$6:<init>	(Lcom/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/aj;)V
    //   1337: invokevirtual 826	android/view/View:addOnLayoutChangeListener	(Landroid/view/View$OnLayoutChangeListener;)V
    //   1340: goto -1077 -> 263
    //   1343: ldc_w 337
    //   1346: new 445	java/lang/StringBuilder
    //   1349: dup
    //   1350: ldc_w 989
    //   1353: invokespecial 449	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   1356: aload 5
    //   1358: invokevirtual 992	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   1361: ldc_w 994
    //   1364: invokevirtual 453	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1367: aload_0
    //   1368: getfield 545	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/aj:QOV	Lcom/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/aa;
    //   1371: checkcast 547	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/w
    //   1374: getfield 792	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/w:QKu	I
    //   1377: invokevirtual 831	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1380: invokevirtual 454	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1383: invokestatic 268	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   1386: goto -1123 -> 263
    //   1389: aload_0
    //   1390: getfield 545	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/aj:QOV	Lcom/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/aa;
    //   1393: checkcast 547	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/w
    //   1396: getfield 792	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/w:QKu	I
    //   1399: iconst_1
    //   1400: if_icmpne +195 -> 1595
    //   1403: aload_0
    //   1404: getfield 545	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/aj:QOV	Lcom/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/aa;
    //   1407: checkcast 547	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/w
    //   1410: getfield 795	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/w:width	F
    //   1413: aload_0
    //   1414: getfield 798	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/aj:sJv	I
    //   1417: i2f
    //   1418: fdiv
    //   1419: aload_0
    //   1420: getfield 545	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/aj:QOV	Lcom/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/aa;
    //   1423: checkcast 547	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/w
    //   1426: getfield 802	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/w:height	F
    //   1429: aload_0
    //   1430: getfield 986	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/aj:pvg	I
    //   1433: i2f
    //   1434: fdiv
    //   1435: fcmpl
    //   1436: ifle +123 -> 1559
    //   1439: aload_0
    //   1440: getfield 798	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/aj:sJv	I
    //   1443: istore_2
    //   1444: iload_2
    //   1445: i2f
    //   1446: aload_0
    //   1447: getfield 545	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/aj:QOV	Lcom/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/aa;
    //   1450: checkcast 547	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/w
    //   1453: getfield 802	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/w:height	F
    //   1456: fmul
    //   1457: aload_0
    //   1458: getfield 545	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/aj:QOV	Lcom/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/aa;
    //   1461: checkcast 547	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/w
    //   1464: getfield 795	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/w:width	F
    //   1467: fdiv
    //   1468: f2i
    //   1469: iconst_1
    //   1470: iadd
    //   1471: istore_1
    //   1472: new 800	android/widget/RelativeLayout$LayoutParams
    //   1475: dup
    //   1476: iload_2
    //   1477: iload_1
    //   1478: invokespecial 803	android/widget/RelativeLayout$LayoutParams:<init>	(II)V
    //   1481: astore 6
    //   1483: aload 6
    //   1485: aload_0
    //   1486: getfield 798	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/aj:sJv	I
    //   1489: iload_2
    //   1490: isub
    //   1491: iconst_2
    //   1492: idiv
    //   1493: putfield 997	android/widget/RelativeLayout$LayoutParams:leftMargin	I
    //   1496: aload 6
    //   1498: aload 6
    //   1500: getfield 997	android/widget/RelativeLayout$LayoutParams:leftMargin	I
    //   1503: putfield 887	android/widget/RelativeLayout$LayoutParams:rightMargin	I
    //   1506: aload 6
    //   1508: aload_0
    //   1509: getfield 986	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/aj:pvg	I
    //   1512: iload_1
    //   1513: isub
    //   1514: iconst_2
    //   1515: idiv
    //   1516: putfield 1000	android/widget/RelativeLayout$LayoutParams:topMargin	I
    //   1519: aload 6
    //   1521: aload 6
    //   1523: getfield 1000	android/widget/RelativeLayout$LayoutParams:topMargin	I
    //   1526: putfield 884	android/widget/RelativeLayout$LayoutParams:bottomMargin	I
    //   1529: aload 5
    //   1531: aload 6
    //   1533: invokevirtual 807	android/view/ViewGroup:setLayoutParams	(Landroid/view/ViewGroup$LayoutParams;)V
    //   1536: aload 4
    //   1538: new 800	android/widget/RelativeLayout$LayoutParams
    //   1541: dup
    //   1542: aload_0
    //   1543: getfield 798	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/aj:sJv	I
    //   1546: aload_0
    //   1547: getfield 986	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/aj:pvg	I
    //   1550: invokespecial 803	android/widget/RelativeLayout$LayoutParams:<init>	(II)V
    //   1553: invokevirtual 808	android/view/View:setLayoutParams	(Landroid/view/ViewGroup$LayoutParams;)V
    //   1556: goto -1261 -> 295
    //   1559: aload_0
    //   1560: getfield 986	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/aj:pvg	I
    //   1563: istore_1
    //   1564: iload_1
    //   1565: i2f
    //   1566: aload_0
    //   1567: getfield 545	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/aj:QOV	Lcom/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/aa;
    //   1570: checkcast 547	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/w
    //   1573: getfield 795	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/w:width	F
    //   1576: fmul
    //   1577: aload_0
    //   1578: getfield 545	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/aj:QOV	Lcom/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/aa;
    //   1581: checkcast 547	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/w
    //   1584: getfield 802	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/w:height	F
    //   1587: fdiv
    //   1588: f2i
    //   1589: iconst_1
    //   1590: iadd
    //   1591: istore_2
    //   1592: goto -120 -> 1472
    //   1595: aload_0
    //   1596: getfield 545	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/aj:QOV	Lcom/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/aa;
    //   1599: checkcast 547	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/w
    //   1602: getfield 792	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/w:QKu	I
    //   1605: iconst_2
    //   1606: if_icmpne -1311 -> 295
    //   1609: new 800	android/widget/RelativeLayout$LayoutParams
    //   1612: dup
    //   1613: aload_0
    //   1614: getfield 545	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/aj:QOV	Lcom/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/aa;
    //   1617: checkcast 547	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/w
    //   1620: getfield 795	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/w:width	F
    //   1623: f2i
    //   1624: aload_0
    //   1625: getfield 545	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/aj:QOV	Lcom/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/aa;
    //   1628: checkcast 547	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/w
    //   1631: getfield 802	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/w:height	F
    //   1634: f2i
    //   1635: invokespecial 803	android/widget/RelativeLayout$LayoutParams:<init>	(II)V
    //   1638: astore 6
    //   1640: aload 5
    //   1642: aload 6
    //   1644: invokevirtual 807	android/view/ViewGroup:setLayoutParams	(Landroid/view/ViewGroup$LayoutParams;)V
    //   1647: aload 4
    //   1649: new 800	android/widget/RelativeLayout$LayoutParams
    //   1652: dup
    //   1653: aload 6
    //   1655: invokespecial 1003	android/widget/RelativeLayout$LayoutParams:<init>	(Landroid/widget/RelativeLayout$LayoutParams;)V
    //   1658: invokevirtual 808	android/view/View:setLayoutParams	(Landroid/view/ViewGroup$LayoutParams;)V
    //   1661: goto -1366 -> 295
    //   1664: ldc_w 729
    //   1667: aload_0
    //   1668: getfield 545	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/aj:QOV	Lcom/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/aa;
    //   1671: checkcast 547	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/w
    //   1674: getfield 732	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/w:QKq	Ljava/lang/String;
    //   1677: new 16	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/aj$10
    //   1680: dup
    //   1681: aload_0
    //   1682: invokespecial 1004	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/aj$10:<init>	(Lcom/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/aj;)V
    //   1685: invokestatic 1007	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/k:b	(Ljava/lang/String;Ljava/lang/String;Lcom/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/g$a;)V
    //   1688: goto -1326 -> 362
    //   1691: astore 5
    //   1693: ldc_w 256
    //   1696: aload 5
    //   1698: invokevirtual 262	java/lang/Throwable:toString	()Ljava/lang/String;
    //   1701: invokestatic 268	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   1704: goto -1107 -> 597
    //   1707: iconst_0
    //   1708: istore_1
    //   1709: goto -1016 -> 693
    //   1712: astore 5
    //   1714: ldc_w 256
    //   1717: aload 5
    //   1719: invokevirtual 262	java/lang/Throwable:toString	()Ljava/lang/String;
    //   1722: invokestatic 268	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   1725: goto -788 -> 937
    //   1728: iconst_0
    //   1729: istore_3
    //   1730: goto -607 -> 1123
    //   1733: astore 5
    //   1735: ldc_w 256
    //   1738: aload 5
    //   1740: invokevirtual 262	java/lang/Throwable:toString	()Ljava/lang/String;
    //   1743: invokestatic 268	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   1746: goto -606 -> 1140
    //   1749: astore 4
    //   1751: ldc_w 256
    //   1754: aload 4
    //   1756: invokevirtual 262	java/lang/Throwable:toString	()Ljava/lang/String;
    //   1759: invokestatic 268	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   1762: goto -601 -> 1161
    //   1765: getstatic 242	com/tencent/mm/plugin/report/service/h:OAn	Lcom/tencent/mm/plugin/report/service/h;
    //   1768: sipush 1720
    //   1771: bipush 21
    //   1773: invokevirtual 246	com/tencent/mm/plugin/report/service/h:kJ	(II)V
    //   1776: goto -540 -> 1236
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1779	0	this	aj
    //   191	1518	1	i	int
    //   1443	149	2	j	int
    //   1122	608	3	bool	boolean
    //   92	1556	4	localView	View
    //   1749	6	4	localObject1	Object
    //   111	1530	5	localObject2	Object
    //   1691	6	5	localObject3	Object
    //   1712	6	5	localObject4	Object
    //   1733	6	5	localObject5	Object
    //   225	1429	6	localObject6	Object
    // Exception table:
    //   from	to	target	type
    //   505	534	1691	finally
    //   534	597	1691	finally
    //   792	857	1712	finally
    //   857	937	1712	finally
    //   937	981	1733	finally
    //   981	1121	1733	finally
    //   1123	1131	1733	finally
    //   1131	1140	1733	finally
    //   1140	1161	1749	finally
  }
  
  public final void a(int paramInt1, boolean paramBoolean1, boolean paramBoolean2, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, long paramLong1, String paramString, long paramLong2)
  {
    AppMethodBeat.i(307224);
    for (;;)
    {
      try
      {
        this.PQr = 6;
        this.QRO += paramLong2;
        this.QRK = paramBoolean2;
        this.PQI += 1;
        this.PQF += paramInt2;
        this.PQH += paramInt3;
        this.PQG += paramInt4;
        this.PQE += paramInt5;
        this.LKo += paramInt6;
        this.PSW = ((int)(this.PSW + paramLong1));
        if (paramBoolean2) {
          this.LJG = System.currentTimeMillis();
        }
        boolean bool = Util.isNullOrNil(paramString);
        if (!bool) {}
        try
        {
          paramString = new JSONObject(paramString);
          if (this.QRN == null) {
            this.QRN = new c();
          }
          c localc = this.QRN;
          localc.PXy += paramString.optInt("exposureCount");
          localc = this.QRN;
          localc.hTS += paramString.optLong("stayTime");
          localc = this.QRN;
          localc.clickCount += paramString.optInt("clickCount");
          paramString = paramString.optJSONObject("btnInfo");
          this.QRN.PXz = paramString.optString("cid");
          localc = this.QRN;
          localc.PXA += paramString.optInt("exposureCount");
          localc = this.QRN;
          localc.PXB += paramString.optLong("stayTime");
          localc = this.QRN;
          paramInt2 = localc.PXC;
          localc.PXC = (paramString.optInt("clickCount") + paramInt2);
        }
        finally
        {
          this.QRN = null;
          Log.e("MicroMsg.Sns.AdLandingPageSightVideoComponent", paramString.toString());
          continue;
        }
        this.mRi.removeCallbacks(this.QRL);
        this.QRJ.setVisibility(8);
        Log.i("VideoFullScreenActivity", "currPosSec = " + paramInt1 + ", isPlaying = " + paramBoolean2 + ", bNoVoice = " + paramBoolean1);
        paramInt2 = paramInt1 / 1000;
        if ((paramInt2 >= this.Qbs) || (paramInt1 < 0))
        {
          this.QRH.seek(0);
          this.QRB.bK(0, paramBoolean2);
          DV(paramBoolean2);
          if (!paramBoolean1) {
            break label523;
          }
          haw();
          bUf();
          AppMethodBeat.o(307224);
          return;
        }
      }
      finally
      {
        Log.e("VideoFullScreenActivity", paramString.toString());
        AppMethodBeat.o(307224);
        return;
      }
      this.QRH.seek(paramInt2);
      this.QRB.bK(paramInt1, paramBoolean2);
      continue;
      label523:
      hax();
    }
  }
  
  public final boolean bP(JSONObject paramJSONObject)
  {
    AppMethodBeat.i(96729);
    if (!super.bP(paramJSONObject))
    {
      AppMethodBeat.o(96729);
      return false;
    }
    try
    {
      paramJSONObject.put("sightDuration", this.Qbs * 1000);
      paramJSONObject.put("playTimeInterval", this.PSW);
      paramJSONObject.put("playCount", this.LKo);
      paramJSONObject.put("playCompletedCount", this.PQE);
      paramJSONObject.put("clickPlayControlCount", this.PQF);
      paramJSONObject.put("doubleClickCount", this.PQH);
      paramJSONObject.put("clickFullscreenBtnCount", this.PQI);
      paramJSONObject.put("clickVoiceControlCount", this.PQG);
      if (this.isAutoPlay) {}
      for (Object localObject = "1";; localObject = "0")
      {
        paramJSONObject.put("isAutoPlay", localObject);
        if (((w)this.QOV).type == 61) {
          paramJSONObject.put("clickSightCount", this.PQJ);
        }
        JSONObject localJSONObject;
        if (!this.PQy)
        {
          localObject = MD5Util.getMD5String(((w)this.QOV).QKp);
          localJSONObject = new JSONObject();
          localJSONObject.put("urlMd5", localObject);
          localJSONObject.put("needDownload", 1);
          paramJSONObject.put("sightUrlInfo", localJSONObject);
        }
        if (!this.PQx)
        {
          localObject = MD5Util.getMD5String(((w)this.QOV).QKq);
          localJSONObject = new JSONObject();
          localJSONObject.put("urlMd5", localObject);
          localJSONObject.put("needDownload", 1);
          paramJSONObject.put("thumbUrlInfo", localJSONObject);
        }
        paramJSONObject.put("streamVideoEnterCount", this.QRD);
        paramJSONObject.put("streamVideoPlayCount", this.PWr);
        paramJSONObject.put("streamVideoPlayCompleteCount", this.PWs);
        paramJSONObject.put("streamVideoTotalPlayTimeInMs", this.PWt);
        if (this.QRN != null)
        {
          localObject = new JSONObject();
          ((JSONObject)localObject).put("cid", this.QRN.PXz);
          ((JSONObject)localObject).put("exposureCount", this.QRN.PXA);
          ((JSONObject)localObject).put("stayTime", this.QRN.PXB);
          ((JSONObject)localObject).put("clickCount", this.QRN.PXC);
          localJSONObject = new JSONObject();
          localJSONObject.put("exposureCount", this.QRN.PXy);
          localJSONObject.put("stayTime", this.QRN.hTS);
          localJSONObject.put("clickCount", this.QRN.clickCount);
          localJSONObject.put("btnInfo", localObject);
          paramJSONObject.put("fullVideoFloatBarInfo", localJSONObject);
        }
        long l = hjj();
        com.tencent.mm.plugin.sns.ad.d.h.a(61, hjn(), l, this.PSW, "MicroMsg.Sns.AdLandingPageSightVideoComponent");
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
  
  public final void dSW()
  {
    AppMethodBeat.i(307227);
    Dt(false);
    this.PQr = 4;
    AppMethodBeat.o(307227);
  }
  
  public final void dSX()
  {
    AppMethodBeat.i(307232);
    this.PQr = 3;
    drB();
    AppMethodBeat.o(307232);
  }
  
  protected final int getLayout()
  {
    return b.g.sns_ad_native_landing_pages_item_sight;
  }
  
  protected final void had()
  {
    AppMethodBeat.i(96730);
    Log.i("MicroMsg.Sns.AdLandingPageSightVideoComponent", getClass().getName() + "not support update now");
    AppMethodBeat.o(96730);
  }
  
  public final void hao()
  {
    AppMethodBeat.i(96725);
    super.hao();
    AppMethodBeat.o(96725);
  }
  
  public final void hap()
  {
    AppMethodBeat.i(96726);
    super.hap();
    abandonAudioFocus();
    Dt(false);
    if ((!this.PQz) && (!this.PQA))
    {
      AppMethodBeat.o(96726);
      return;
    }
    this.PQA = false;
    this.PQz = false;
    if (this.PQr == 1) {
      this.PQr = 2;
    }
    int i = this.PQr;
    Log.d("MicroMsg.Sns.AdLandingPageSightVideoComponent", "disappear handleType %d", new Object[] { Integer.valueOf(this.PQr) });
    AppMethodBeat.o(96726);
  }
  
  public final void haq()
  {
    AppMethodBeat.i(96728);
    super.haq();
    int i = hjh();
    int j = getView().getHeight();
    Log.d("MicroMsg.Sns.AdLandingPageSightVideoComponent", "inScreenHeight %d, height %d", new Object[] { Integer.valueOf(i), Integer.valueOf(j) });
    if ((i == 0) || (j == 0))
    {
      AppMethodBeat.o(96728);
      return;
    }
    this.QRF = i;
    this.mbN = j;
    if (i < 0)
    {
      AppMethodBeat.o(96728);
      return;
    }
    Log.d("MicroMsg.Sns.AdLandingPageSightVideoComponent", "appeared handleType %d", new Object[] { Integer.valueOf(this.PQr) });
    if (i >= j * 0.5F)
    {
      if ((this.PQz) && (!this.PQA))
      {
        AppMethodBeat.o(96728);
        return;
      }
      this.PQA = false;
      this.PQz = true;
      if (this.PQr == 6)
      {
        if (this.QRK)
        {
          this.PQr = 1;
          AppMethodBeat.o(96728);
          return;
        }
        this.PQr = 4;
        AppMethodBeat.o(96728);
        return;
      }
      if (this.PQr == 0)
      {
        if (this.PQB) {
          haw();
        }
        for (;;)
        {
          this.PQr = 1;
          drB();
          AppMethodBeat.o(96728);
          return;
          hax();
        }
      }
      if (this.PQr == 2)
      {
        if (this.PQB) {
          haw();
        }
        for (;;)
        {
          drB();
          this.PQr = 1;
          AppMethodBeat.o(96728);
          return;
          hax();
        }
      }
      if (this.PQr == 3)
      {
        if (this.PQB) {
          haw();
        }
        for (;;)
        {
          drB();
          AppMethodBeat.o(96728);
          return;
          hax();
        }
      }
    }
    else
    {
      this.PQA = false;
      this.PQz = false;
      Dt(false);
      if (this.PQr == 1) {
        this.PQr = 2;
      }
      i = this.PQr;
    }
    AppMethodBeat.o(96728);
  }
  
  public final void has()
  {
    AppMethodBeat.i(96727);
    super.has();
    try
    {
      this.mRi.removeCallbacks(this.PQR);
      this.mRi.removeCallbacks(this.QRL);
      abandonAudioFocus();
      this.QRB.onDestroy();
      AppMethodBeat.o(96727);
      return;
    }
    finally
    {
      for (;;)
      {
        Log.e("MicroMsg.Sns.AdLandingPageSightVideoComponent.VideoOptimize", localObject.toString());
      }
    }
  }
  
  public final void hav()
  {
    AppMethodBeat.i(307134);
    if (this.QRB != null) {
      this.QRB.bJ(0, false);
    }
    AppMethodBeat.o(307134);
  }
  
  public final void haw()
  {
    AppMethodBeat.i(96723);
    super.haw();
    this.QRE.setImageDrawable(com.tencent.mm.cd.a.m(this.context, b.i.icon_volume_off));
    this.QRB.setMute(true);
    this.PQB = true;
    AppMethodBeat.o(96723);
  }
  
  public final void hax()
  {
    AppMethodBeat.i(96724);
    super.hax();
    this.QRE.setImageDrawable(com.tencent.mm.cd.a.m(this.context, b.i.icon_volume_on));
    this.QRB.setMute(false);
    this.PQB = false;
    AppMethodBeat.o(96724);
  }
  
  public final long hjj()
  {
    AppMethodBeat.i(307237);
    long l1 = super.hjj();
    long l2 = this.QRO;
    AppMethodBeat.o(307237);
    return l1 + l2;
  }
  
  public final void hjl()
  {
    AppMethodBeat.i(96731);
    super.hjl();
    String str = k.mC("adId", ((w)this.QOV).QKq);
    Dt(false);
    if (y.ZC(str))
    {
      this.QRB.bax(str);
      this.QRB.d(false, 0.0F);
    }
    AppMethodBeat.o(96731);
  }
  
  public final boolean isPlaying()
  {
    AppMethodBeat.i(307138);
    boolean bool = this.QRB.isPlaying();
    AppMethodBeat.o(307138);
    return bool;
  }
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(307187);
    Object localObject = new com.tencent.mm.hellhoundlib.b.b();
    ((com.tencent.mm.hellhoundlib.b.b)localObject).cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/AdLandingPageSightVideoComponent", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).aYj());
    if (paramView.getId() == b.f.sns_ad_native_landing_pages_sight_video_full_screen_btn) {
      Log.i("MicroMsg.Sns.AdLandingPageSightVideoComponent.VideoOptimize", "click full screen btn");
    }
    try
    {
      if ((this.context instanceof SnsAdNativeLandingPagesUI))
      {
        this.PQI += 1;
        this.mRi.removeCallbacks(this.QRL);
        this.QRJ.setVisibility(8);
        paramView = (SnsAdNativeLandingPagesUI)this.context;
        b.QRY = (w)this.QOV;
        com.tencent.mm.plugin.sns.model.ag.Qud = hjn();
        localObject = new Intent(paramView, VideoFullScreenActivity.class);
        ((Intent)localObject).putExtra("KComponentVideoType", 0);
        ((Intent)localObject).putExtra("KComponentCid", this.QOV.QKG);
        ((Intent)localObject).putExtra("KComponentCurrentTime", this.QRB.getCurrentPositionMs());
        ((Intent)localObject).putExtra("KComponentTotalTime", this.QRB.getDurationMs());
        ((Intent)localObject).putExtra("KComponentVoiceType", this.PQB);
        ((Intent)localObject).putExtra("KComponentProgressType", this.QRB.isPlaying());
        ((Intent)localObject).putExtra("KComponentVideoSightThumbUrl", ((w)this.QOV).QKq);
        ((Intent)localObject).putExtra("KComponentStreamVideoUrlPath", ((w)this.QOV).QKp);
        com.tencent.mm.hellhoundlib.a.a.a(paramView, com.tencent.mm.hellhoundlib.b.c.a(2000, new com.tencent.mm.hellhoundlib.b.a()).cG(localObject).aYi(), "com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/AdLandingPageSightVideoComponent", "onClick", "(Landroid/view/View;)V", "android/app/Activity", "startActivityForResult", "(Landroid/content/Intent;I)V");
        com.tencent.mm.plugin.report.service.h.OAn.kJ(1720, 1);
      }
      for (;;)
      {
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/AdLandingPageSightVideoComponent", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(307187);
        return;
        this.QRI.setVisibility(8);
      }
    }
    finally
    {
      for (;;)
      {
        this.QRI.setVisibility(8);
        Log.e("VideoFullScreenActivity", paramView.toString());
      }
    }
  }
  
  public final boolean onDoubleTap(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(307197);
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(paramMotionEvent);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/AdLandingPageSightVideoComponent", "android/view/GestureDetector$OnDoubleTapListener", "onDoubleTap", "(Landroid/view/MotionEvent;)Z", this, localb.aYj());
    for (;;)
    {
      try
      {
        Log.i("MicroMsg.Sns.AdLandingPageSightVideoComponent.VideoOptimize", "onDoubleTap");
        aN(this.PQR);
        if (this.mvL) {
          this.PQH += 1;
        }
        if (!this.QRB.isPlaying()) {
          continue;
        }
        Dt(true);
        this.PQr = 4;
      }
      finally
      {
        Log.e("MicroMsg.Sns.AdLandingPageSightVideoComponent.VideoOptimize", paramMotionEvent.toString());
        continue;
        hiA();
        hax();
        continue;
      }
      com.tencent.mm.hellhoundlib.a.a.a(false, this, "com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/AdLandingPageSightVideoComponent", "android/view/GestureDetector$OnDoubleTapListener", "onDoubleTap", "(Landroid/view/MotionEvent;)Z");
      AppMethodBeat.o(307197);
      return false;
      if (!this.PQB) {
        continue;
      }
      haw();
      drB();
      this.PQr = 3;
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
    AppMethodBeat.i(307214);
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(paramMotionEvent);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/AdLandingPageSightVideoComponent", "android/view/GestureDetector$OnGestureListener", "onLongPress", "(Landroid/view/MotionEvent;)V", this, localb.aYj());
    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/AdLandingPageSightVideoComponent", "android/view/GestureDetector$OnGestureListener", "onLongPress", "(Landroid/view/MotionEvent;)V");
    AppMethodBeat.o(307214);
  }
  
  public final boolean onScroll(MotionEvent paramMotionEvent1, MotionEvent paramMotionEvent2, float paramFloat1, float paramFloat2)
  {
    return false;
  }
  
  public final void onShowPress(MotionEvent paramMotionEvent) {}
  
  public final boolean onSingleTapConfirmed(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(307194);
    for (;;)
    {
      try
      {
        Log.i("MicroMsg.Sns.AdLandingPageSightVideoComponent.VideoOptimize", "onSingleTapConfirmed");
        bool = ((w)this.QOV).QJt;
        if (bool)
        {
          AppMethodBeat.o(307194);
          return false;
        }
        if (!this.mvL) {
          continue;
        }
        if (this.QRH.getVisibility() != 0) {
          continue;
        }
        i = 1;
        if (i == 0) {
          continue;
        }
        this.QRH.setVisibility(4);
        this.QRI.setVisibility(4);
        this.mRi.removeCallbacks(this.PQR);
        if (this.PQL == null) {
          continue;
        }
        paramMotionEvent = this.PQL;
        if (i != 0) {
          continue;
        }
        bool = true;
      }
      finally
      {
        int i;
        Log.e("MicroMsg.Sns.AdLandingPageSightVideoComponent.VideoOptimize", paramMotionEvent.toString());
        continue;
        boolean bool = false;
        continue;
      }
      paramMotionEvent.Do(bool);
      AppMethodBeat.o(307194);
      return false;
      i = 0;
      continue;
      this.QRH.setVisibility(0);
      this.QRI.setVisibility(0);
      aN(this.PQR);
    }
  }
  
  public final boolean onSingleTapUp(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(307208);
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(paramMotionEvent);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/AdLandingPageSightVideoComponent", "android/view/GestureDetector$OnGestureListener", "onSingleTapUp", "(Landroid/view/MotionEvent;)Z", this, localb.aYj());
    com.tencent.mm.hellhoundlib.a.a.a(false, this, "com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/AdLandingPageSightVideoComponent", "android/view/GestureDetector$OnGestureListener", "onSingleTapUp", "(Landroid/view/MotionEvent;)Z");
    AppMethodBeat.o(307208);
    return false;
  }
  
  public final boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(307182);
    paramView = this.nwZ;
    paramMotionEvent = new com.tencent.mm.hellhoundlib.b.a().cG(paramMotionEvent);
    com.tencent.mm.hellhoundlib.a.a.b(paramView, paramMotionEvent.aYi(), "com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/AdLandingPageSightVideoComponent", "onTouch", "(Landroid/view/View;Landroid/view/MotionEvent;)Z", "android/view/GestureDetector_EXEC_", "onTouchEvent", "(Landroid/view/MotionEvent;)Z");
    boolean bool = com.tencent.mm.hellhoundlib.a.a.a(paramView, paramView.onTouchEvent((MotionEvent)paramMotionEvent.sb(0)), "com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/AdLandingPageSightVideoComponent", "onTouch", "(Landroid/view/View;Landroid/view/MotionEvent;)Z", "android/view/GestureDetector_EXEC_", "onTouchEvent", "(Landroid/view/MotionEvent;)Z");
    AppMethodBeat.o(307182);
    return bool;
  }
  
  final class a
    implements AudioManager.OnAudioFocusChangeListener
  {
    a() {}
    
    public final void onAudioFocusChange(int paramInt)
    {
      AppMethodBeat.i(307251);
      try
      {
        aj.alh(paramInt);
        AppMethodBeat.o(307251);
        return;
      }
      finally
      {
        Log.e("MicroMsg.Sns.AdLandingPageSightVideoComponent", "onAudioFocusChanged has something wrong!");
        AppMethodBeat.o(307251);
      }
    }
  }
  
  public static final class b
  {
    public static w QRY;
  }
  
  static final class c
  {
    int PXA;
    long PXB;
    int PXC;
    int PXy;
    String PXz;
    int clickCount;
    long hTS;
  }
  
  final class d
    implements i.c
  {
    d() {}
    
    public final void onSeekComplete(boolean paramBoolean)
    {
      AppMethodBeat.i(307255);
      Log.i("MicroMsg.Sns.AdLandingPageSightVideoComponent", "onSeekComplete is called");
      aj.B(aj.this).hbe();
      AppMethodBeat.o(307255);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.aj
 * JD-Core Version:    0.7.0.1
 */