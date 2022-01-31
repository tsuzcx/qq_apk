package com.tencent.mm.plugin.webview.fts.ui;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.IntentFilter;
import android.media.AudioManager;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.mm.R.g;
import com.tencent.mm.R.h;
import com.tencent.mm.R.i;
import com.tencent.mm.R.l;
import com.tencent.mm.modelappbrand.a.b;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.websearch.ui.WebSearchDotPercentIndicator;
import com.tencent.mm.plugin.websearch.ui.WebSearchWebVideoViewControlBar;
import com.tencent.mm.plugin.websearch.ui.WebSearchWebVideoViewControlBar.2;
import com.tencent.mm.plugin.webview.fts.c.b.a;
import com.tencent.mm.plugin.webview.fts.c.c;
import com.tencent.mm.plugin.webview.fts.c.d;
import com.tencent.mm.plugin.webview.fts.c.d.1;
import com.tencent.mm.pluginsdk.ui.h.b;
import com.tencent.mm.pluginsdk.ui.h.d;
import com.tencent.mm.sdk.platformtools.am;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import java.math.BigDecimal;
import org.json.JSONException;
import org.json.JSONObject;

public class FtsWebVideoView
  extends RelativeLayout
{
  public boolean dnJ;
  private boolean gDB;
  private boolean gDD;
  private boolean gDG;
  private boolean gDH;
  private int gDI;
  private String gDJ;
  private TextView gDk;
  private LinearLayout gDq;
  private TextView gDs;
  private ImageView gDt;
  private ImageView gDu;
  private String gDy;
  private int gDz;
  private boolean isLoading;
  private String mAppId;
  private boolean mAutoPlay;
  private ImageView pEw;
  private ImageView qWl;
  private FtsWebVideoView.b raA = FtsWebVideoView.b.raX;
  public FtsVideoWrapper raB;
  public WebSearchWebVideoViewControlBar raC;
  private View raD;
  private View raE;
  private WebSearchDotPercentIndicator raF;
  private View raG;
  private Button raH;
  private TextView raI;
  private TextView raJ;
  private boolean raK;
  private a raL;
  private FtsWebVideoView.a raM;
  private d raN;
  private b.a raO;
  private int raP;
  private boolean raQ;
  private long raR;
  private View raS;
  private View raT;
  private FtsWebVideoView.c raU = FtsWebVideoView.c.rbb;
  public BroadcastReceiver raV = new FtsWebVideoView.10(this);
  private String url;
  
  public FtsWebVideoView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    init(paramContext);
  }
  
  public FtsWebVideoView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    init(paramContext);
  }
  
  public FtsWebVideoView(Context paramContext, boolean paramBoolean)
  {
    super(paramContext);
    setAutoPlay(paramBoolean);
    init(paramContext);
  }
  
  private void caI()
  {
    if (ake())
    {
      this.qWl.setVisibility(0);
      return;
    }
    this.qWl.setVisibility(8);
  }
  
  private void caJ()
  {
    this.raD.setVisibility(8);
  }
  
  private boolean caK()
  {
    return (this.gDB) && (!caL());
  }
  
  private boolean caL()
  {
    return this.raD.getVisibility() == 0;
  }
  
  private boolean ex(Context paramContext)
  {
    Object localObject = this.raU;
    if (aq.isConnected(paramContext))
    {
      if ((!this.raQ) && (!aq.isWifi(paramContext)))
      {
        pause();
        this.raU = FtsWebVideoView.c.rbc;
        this.raC.setVisibility(8);
        localObject = getNetUnavailableTip();
        String str = paramContext.getString(R.l.video_continue_play);
        paramContext.getString(R.l.video_cancel);
        ft((String)localObject, str);
        return false;
      }
    }
    else
    {
      if (localObject == FtsWebVideoView.c.rbd)
      {
        this.raS.setVisibility(0);
        this.raT.setVisibility(8);
        this.raD.setVisibility(0);
        postDelayed(new FtsWebVideoView.11(this, paramContext), 200L);
        return false;
      }
      ey(paramContext);
      return false;
    }
    return true;
  }
  
  private void ey(Context paramContext)
  {
    this.raU = FtsWebVideoView.c.rbd;
    pause();
    ft(paramContext.getString(R.l.video_net_disable_warnning), paramContext.getString(R.l.video_retry_play));
  }
  
  private void ft(String paramString1, String paramString2)
  {
    caJ();
    this.raS.setVisibility(8);
    this.raT.setVisibility(0);
    this.raC.setVisibility(8);
    this.raD.setVisibility(0);
    if (!TextUtils.isEmpty(paramString1))
    {
      this.raJ.setText(paramString1);
      this.raJ.setVisibility(0);
      if (TextUtils.isEmpty(paramString2)) {
        break label127;
      }
      this.raH.setText(paramString2);
      this.raH.setVisibility(0);
    }
    for (;;)
    {
      this.raE.setVisibility(0);
      this.raG.setVisibility(8);
      this.raI.setVisibility(8);
      caI();
      return;
      this.raJ.setVisibility(8);
      break;
      label127:
      this.raH.setVisibility(8);
    }
  }
  
  private String getNetUnavailableTip()
  {
    if (this.raP == 0) {
      return getContext().getString(R.l.video_net_warnning_no_size);
    }
    Context localContext = getContext();
    int i = R.l.video_net_warnning;
    long l = this.raP;
    Object localObject;
    if (l < 0L) {
      localObject = "";
    }
    for (;;)
    {
      return localContext.getString(i, new Object[] { localObject });
      localObject = new BigDecimal(l);
      float f = ((BigDecimal)localObject).divide(new BigDecimal(1048576), 2, 0).floatValue();
      if (f > 1.0F)
      {
        localObject = (int)f + "M";
      }
      else
      {
        f = ((BigDecimal)localObject).divide(new BigDecimal(1024), 2, 0).floatValue();
        localObject = (int)f + "K";
      }
    }
  }
  
  private void init(Context paramContext)
  {
    LayoutInflater.from(paramContext).inflate(R.i.fts_web_video_container, this);
    this.raB = ((FtsVideoWrapper)findViewById(R.h.video_view));
    this.gDk = ((TextView)findViewById(R.h.progress));
    this.raD = findViewById(R.h.tip_cover_area);
    this.raE = findViewById(R.h.tips_container);
    this.gDq = ((LinearLayout)findViewById(R.h.adjust_info_layout));
    this.raF = ((WebSearchDotPercentIndicator)findViewById(R.h.adjust_percent_indicator));
    this.gDs = ((TextView)findViewById(R.h.adjust_content));
    this.gDt = ((ImageView)findViewById(R.h.adjust_icon));
    this.gDu = ((ImageView)findViewById(R.h.cover));
    this.raS = findViewById(R.h.video_loading);
    this.raT = findViewById(R.h.tips_container_op);
    this.raF.setDotsNum(8);
    this.pEw = ((ImageView)findViewById(R.h.cover_area_play_btn));
    this.raG = findViewById(R.h.cover_replay);
    this.raI = ((TextView)findViewById(R.h.tip_cover_cancel));
    this.raH = ((Button)findViewById(R.h.tip_cover_paly));
    this.raJ = ((TextView)findViewById(R.h.tip_cover_warning));
    this.qWl = ((ImageView)findViewById(R.h.exit_fullscreen_btn));
    this.raI.setOnClickListener(new FtsWebVideoView.1(this));
    this.qWl.setOnClickListener(new FtsWebVideoView.7(this));
    this.raH.setOnClickListener(new FtsWebVideoView.8(this));
    this.raG.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        FtsWebVideoView.this.eg(true);
        FtsWebVideoView.c(FtsWebVideoView.this).akG();
      }
    });
    this.raL = new a(getContext(), this, new FtsWebVideoView.12(this));
    this.raB.setIMMVideoViewCallback(new h.b()
    {
      public final void bH(String paramAnonymousString1, String paramAnonymousString2)
      {
        y.i("MicroMsg.FtsWebVideoView", "onPrepared");
        paramAnonymousString1 = FtsWebVideoView.o(FtsWebVideoView.this);
        paramAnonymousString1.gEX = -1;
        paramAnonymousString1.gEY = 0;
        paramAnonymousString1.gEW = 0.0F;
        FtsWebVideoView.c(FtsWebVideoView.this).la(FtsWebVideoView.f(FtsWebVideoView.this));
      }
      
      public final void bI(String paramAnonymousString1, String paramAnonymousString2)
      {
        y.i("MicroMsg.FtsWebVideoView", "onVideoEnded");
        if (FtsWebVideoView.h(FtsWebVideoView.this) != null)
        {
          paramAnonymousString1 = FtsWebVideoView.h(FtsWebVideoView.this);
          y.d("MicroMsg.JsApiVideoCallback", "onVideoEnded %s", new Object[] { paramAnonymousString1.toString() });
          paramAnonymousString1.akV();
        }
        try
        {
          paramAnonymousString1.ay(paramAnonymousString1.a(3, null));
          if (FtsWebVideoView.p(FtsWebVideoView.this))
          {
            FtsWebVideoView.this.D(0, true);
            return;
          }
        }
        catch (JSONException paramAnonymousString1)
        {
          for (;;)
          {
            y.printErrStackTrace("MicroMsg.JsApiVideoCallback", paramAnonymousString1, null, new Object[0]);
          }
          FtsWebVideoView.this.D(0, false);
          FtsWebVideoView.this.pause();
          FtsWebVideoView.q(FtsWebVideoView.this);
          FtsWebVideoView.r(FtsWebVideoView.this).setImageResource(R.g.fts_video_replay_btn);
          FtsWebVideoView.c(FtsWebVideoView.this).setVisibility(8);
        }
      }
      
      public final void bJ(String paramAnonymousString1, String paramAnonymousString2)
      {
        y.i("MicroMsg.FtsWebVideoView", "onVideoPause");
        if ((FtsWebVideoView.h(FtsWebVideoView.this) != null) && (FtsWebVideoView.h(FtsWebVideoView.this) != null))
        {
          paramAnonymousString1 = FtsWebVideoView.h(FtsWebVideoView.this);
          y.d("MicroMsg.JsApiVideoCallback", "onVideoPause %s", new Object[] { paramAnonymousString1.toString() });
          paramAnonymousString1.akV();
        }
        try
        {
          paramAnonymousString1.ay(paramAnonymousString1.a(2, null));
          return;
        }
        catch (JSONException paramAnonymousString1)
        {
          y.printErrStackTrace("MicroMsg.JsApiVideoCallback", paramAnonymousString1, null, new Object[0]);
        }
      }
      
      public final void bK(String paramAnonymousString1, String paramAnonymousString2)
      {
        y.i("MicroMsg.FtsWebVideoView", "onVideoPlay, isLive:%b", new Object[] { Boolean.valueOf(FtsWebVideoView.t(FtsWebVideoView.this)) });
        if (FtsWebVideoView.h(FtsWebVideoView.this) != null)
        {
          paramAnonymousString1 = FtsWebVideoView.h(FtsWebVideoView.this);
          y.d("MicroMsg.JsApiVideoCallback", "onVideoPlay %s", new Object[] { paramAnonymousString1.toString() });
          paramAnonymousString1.gEP = 0;
          if (paramAnonymousString1.gEO == null) {
            paramAnonymousString1.gEO = new am(new d.1(paramAnonymousString1), true);
          }
          paramAnonymousString1.gEO.S(250L, 250L);
        }
        try
        {
          paramAnonymousString1.ay(paramAnonymousString1.a(1, null));
          if ((FtsWebVideoView.u(FtsWebVideoView.this) > 0L) && (FtsWebVideoView.u(FtsWebVideoView.this) != 9223372036854775807L))
          {
            long l = System.currentTimeMillis() - FtsWebVideoView.u(FtsWebVideoView.this);
            h.nFQ.f(14909, new Object[] { Long.valueOf(l), Long.valueOf(System.currentTimeMillis()), Long.valueOf(l), aq.fH(FtsWebVideoView.this.getContext()), FtsWebVideoView.n(FtsWebVideoView.this) });
          }
          return;
        }
        catch (JSONException paramAnonymousString1)
        {
          for (;;)
          {
            y.printErrStackTrace("MicroMsg.JsApiVideoCallback", paramAnonymousString1, null, new Object[0]);
          }
        }
      }
      
      public final void bL(String paramAnonymousString1, String paramAnonymousString2)
      {
        y.i("MicroMsg.FtsWebVideoView", "onVideoWaiting");
        FtsWebVideoView.c(FtsWebVideoView.this).cac();
        FtsWebVideoView.a(FtsWebVideoView.this, true);
      }
      
      public final void bM(String paramAnonymousString1, String paramAnonymousString2)
      {
        y.i("MicroMsg.FtsWebVideoView", "onVideoWaitingEnd");
        FtsWebVideoView.a(FtsWebVideoView.this, false);
        FtsWebVideoView.c(FtsWebVideoView.this).bOz();
        FtsWebVideoView.c(FtsWebVideoView.this).akG();
      }
      
      public final void c(String paramAnonymousString1, String paramAnonymousString2, String paramAnonymousString3, int paramAnonymousInt1, int paramAnonymousInt2)
      {
        y.i("MicroMsg.FtsWebVideoView", "onError errorMsg=%s what=%d extra=%d", new Object[] { paramAnonymousString3, Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousInt2) });
        h.nFQ.f(14911, new Object[] { Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousInt2), FtsWebVideoView.n(FtsWebVideoView.this), aq.fH(FtsWebVideoView.this.getContext()) });
        if (FtsWebVideoView.h(FtsWebVideoView.this) != null)
        {
          paramAnonymousString1 = FtsWebVideoView.h(FtsWebVideoView.this);
          y.e("MicroMsg.JsApiVideoCallback", "onError what %d, extra %d", new Object[] { Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousInt2) });
          paramAnonymousString1.clean();
        }
        try
        {
          paramAnonymousString2 = new JSONObject();
          paramAnonymousString2.put("errCode", paramAnonymousInt1);
          paramAnonymousString2.put("errMsg", String.valueOf(paramAnonymousInt2));
          paramAnonymousString1.ay(paramAnonymousString1.a(7, paramAnonymousString2));
          FtsWebVideoView.this.pause();
          FtsWebVideoView.a(FtsWebVideoView.this, FtsWebVideoView.this.getContext().getString(R.l.video_error_warnning, new Object[] { paramAnonymousInt1 + ":" + paramAnonymousInt2 }), FtsWebVideoView.this.getContext().getString(R.l.video_retry_play));
          return;
        }
        catch (JSONException paramAnonymousString1)
        {
          for (;;)
          {
            y.printErrStackTrace("MicroMsg.JsApiVideoCallback", paramAnonymousString1, null, new Object[0]);
          }
        }
      }
      
      public final void d(String paramAnonymousString1, String paramAnonymousString2, int paramAnonymousInt1, int paramAnonymousInt2)
      {
        y.i("MicroMsg.FtsWebVideoView", "onGetVideoSize width=%d height=%d", new Object[] { Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousInt2) });
        if (FtsWebVideoView.s(FtsWebVideoView.this) == FtsWebVideoView.b.raX)
        {
          paramAnonymousString2 = FtsWebVideoView.this;
          if (paramAnonymousInt1 >= paramAnonymousInt2) {
            break label84;
          }
        }
        label84:
        for (paramAnonymousString1 = FtsWebVideoView.b.raZ;; paramAnonymousString1 = FtsWebVideoView.b.raY)
        {
          FtsWebVideoView.a(paramAnonymousString2, paramAnonymousString1);
          y.i("MicroMsg.FtsWebVideoView", "onGetVideoSize adjust direction from AUTO to %s", new Object[] { FtsWebVideoView.s(FtsWebVideoView.this) });
          return;
        }
      }
    });
    this.raC = new WebSearchWebVideoViewControlBar(getContext());
    this.raC.setVisibility(8);
    this.raC.setEnterFullScreenBtnClickListener(new FtsWebVideoView.14(this));
    this.raC.setExitFullScreenBtnClickListener(new FtsWebVideoView.2(this));
    this.raC.setMuteBtnOnClickListener(new FtsWebVideoView.3(this));
    this.raC.setIplaySeekCallback(new FtsWebVideoView.4(this));
    this.raC.setOnPlayButtonClickListener(new FtsWebVideoView.5(this));
    this.raC.setStatePorter(new FtsWebVideoView.6(this));
    this.raB.setVideoFooterView(this.raC);
    paramContext.registerReceiver(this.raV, new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE"));
    caJ();
  }
  
  private boolean isLive()
  {
    boolean bool = false;
    y.i("MicroMsg.FtsWebVideoView", "isLive %b %b", new Object[] { Boolean.valueOf(this.gDG), Boolean.valueOf(this.raB.isLive()) });
    if ((this.gDG) || (this.raB.isLive())) {
      bool = true;
    }
    return bool;
  }
  
  private void setCover(String paramString)
  {
    if (bk.bl(paramString)) {}
    while (bk.bl(this.gDJ)) {
      return;
    }
    y.i("MicroMsg.FtsWebVideoView", "setCover mCoverUrl not null");
  }
  
  public final void D(int paramInt, boolean paramBoolean)
  {
    y.i("MicroMsg.FtsWebVideoView", "seek to position=%d current=%d isLive=%b", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(this.raB.getCurrPosSec()), Boolean.valueOf(this.gDG) });
    if (isLive()) {
      return;
    }
    if (paramBoolean)
    {
      this.raB.y(paramInt, paramBoolean);
      return;
    }
    this.raB.lF(paramInt);
  }
  
  public final boolean ake()
  {
    if (this.raM == null)
    {
      y.w("MicroMsg.FtsWebVideoView", "isInFullScreen mFullScreenDelegate null");
      return false;
    }
    return this.raM.isFullScreen();
  }
  
  public final void cM(String paramString, int paramInt)
  {
    y.i("MicroMsg.FtsWebVideoView", "setVideoPath path=%s isLive=%s", new Object[] { paramString, Boolean.valueOf(false) });
    this.url = paramString;
    if (bk.bl(paramString)) {
      y.v("MicroMsg.FtsWebVideoView", "setVideoPath videoPath empty");
    }
    do
    {
      return;
      stop();
      this.gDG = false;
      this.raB.c(false, paramString, paramInt);
      if (this.raC != null) {
        this.raC.setVideoTotalTime(paramInt);
      }
      if (this.gDI > 0) {
        this.raB.lF(this.gDI);
      }
      if (this.mAutoPlay)
      {
        y.i("MicroMsg.FtsWebVideoView", "setVideoPath autoPlay");
        eg(false);
      }
    } while (!paramString.startsWith("wxfile://"));
    setCover(paramString);
  }
  
  public final void dt(boolean paramBoolean)
  {
    if (this.raN == null) {
      return;
    }
    String str;
    if (this.raA == FtsWebVideoView.b.raZ) {
      str = "vertical";
    }
    for (;;)
    {
      d locald = this.raN;
      int i = this.gDz;
      try
      {
        y.i("MicroMsg.JsApiVideoCallback", "onVideoFullScreenChange videoPlayerId=%d isFullScreen=%b direction:%s", new Object[] { Integer.valueOf(i), Boolean.valueOf(paramBoolean), str });
        JSONObject localJSONObject = locald.akU();
        localJSONObject.put("fullScreen", paramBoolean);
        localJSONObject.put("direction", str);
        locald.ay(locald.a(5, localJSONObject));
        caI();
        return;
        str = "horizontal";
      }
      catch (JSONException localJSONException)
      {
        for (;;)
        {
          y.e("MicroMsg.JsApiVideoCallback", "onVideoFullScreenChange e=%s", new Object[] { localJSONException });
        }
      }
    }
  }
  
  public final void eg(boolean paramBoolean)
  {
    y.i("MicroMsg.FtsWebVideoView", "start");
    caJ();
    if ((paramBoolean) && (!ex(getContext()))) {
      y.i("MicroMsg.FtsWebVideoView", "start network is not wifi");
    }
    do
    {
      return;
      this.raU = FtsWebVideoView.c.rbb;
    } while (this.raB.isPlaying());
    if (this.gDB)
    {
      WebSearchWebVideoViewControlBar localWebSearchWebVideoViewControlBar = this.raC;
      if (localWebSearchWebVideoViewControlBar.gEg == null) {
        localWebSearchWebVideoViewControlBar.gEg = new am(new WebSearchWebVideoViewControlBar.2(localWebSearchWebVideoViewControlBar), true);
      }
      localWebSearchWebVideoViewControlBar.akO();
      localWebSearchWebVideoViewControlBar.gEg.stopTimer();
      localWebSearchWebVideoViewControlBar.gEg.S(500L, 500L);
    }
    this.raB.start();
    if (this.raR == 0L)
    {
      this.raR = System.currentTimeMillis();
      return;
    }
    this.raR = 9223372036854775807L;
  }
  
  public d getCallback()
  {
    return this.raN;
  }
  
  public String getCookieData()
  {
    return this.gDy;
  }
  
  public int getCurrPosMs()
  {
    return this.raB.getCurrPosMs();
  }
  
  public int getCurrPosSec()
  {
    return this.raB.getCurrPosSec();
  }
  
  public int getSystemVolume()
  {
    return ((AudioManager)getContext().getSystemService("audio")).getStreamVolume(3);
  }
  
  public b.a getUiLifecycleListener()
  {
    return this.raO;
  }
  
  public int getVideoSizeByte()
  {
    return this.raP;
  }
  
  public int getmVideoPlayerId()
  {
    return this.gDz;
  }
  
  public final void lb(boolean paramBoolean)
  {
    boolean bool = false;
    y.i("MicroMsg.FtsWebVideoView", "operateFullScreen toFullScreen=%b", new Object[] { Boolean.valueOf(paramBoolean) });
    if (this.raM == null)
    {
      y.w("MicroMsg.FtsWebVideoView", "operateFullScreen mFullScreenDelegate null");
      return;
    }
    if (paramBoolean == ake())
    {
      y.i("MicroMsg.FtsWebVideoView", "operateFullScreen current same");
      return;
    }
    if (paramBoolean)
    {
      Object localObject = this.raM;
      paramBoolean = bool;
      if (this.raA != FtsWebVideoView.b.raZ) {
        paramBoolean = true;
      }
      ((FtsWebVideoView.a)localObject).lc(paramBoolean);
      localObject = this.raC;
      ((WebSearchWebVideoViewControlBar)localObject).gEh = true;
      ((WebSearchWebVideoViewControlBar)localObject).akL();
      dt(true);
      return;
    }
    this.raM.aiZ();
    this.raC.aiZ();
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    if ((this.gDD) || (ake()))
    {
      a locala;
      if (this.raL != null)
      {
        locala = this.raL;
        if (locala.rat.bNK())
        {
          int i = paramMotionEvent.getActionMasked();
          if (i == 0)
          {
            locala.gEW = paramMotionEvent.getRawX();
            locala.Cv = ((AudioManager)locala.mContext.getSystemService("audio")).getStreamVolume(3);
            locala.gCn = c.cn(locala.mContext);
          }
          locala.gEU.onTouchEvent(paramMotionEvent);
          if ((i != 1) && (i != 3)) {
            break label160;
          }
          if (locala.ras != a.a.ray) {
            break label162;
          }
          locala.rat.g(locala.gEY, paramMotionEvent.getRawX() - locala.gEW);
          locala.gEX = -1;
          locala.gEY = 0;
          locala.gEW = 0.0F;
        }
      }
      for (;;)
      {
        locala.ras = a.a.rav;
        label160:
        return true;
        label162:
        if (locala.ras == a.a.raw)
        {
          ((AudioManager)locala.mContext.getSystemService("audio")).getStreamMaxVolume(3);
          locala.rat.ako();
        }
        else if (locala.ras == a.a.rax)
        {
          locala.rat.akp();
        }
      }
    }
    if ((paramMotionEvent.getAction() == 0) && (caK())) {
      this.raC.la(this.isLoading);
    }
    return super.onTouchEvent(paramMotionEvent);
  }
  
  public final void pause()
  {
    y.i("MicroMsg.FtsWebVideoView", "pause");
    caJ();
    if (!this.raB.isPlaying()) {
      return;
    }
    this.raB.pause();
  }
  
  public void setAllowMobileNetPlay(boolean paramBoolean)
  {
    this.raQ = paramBoolean;
  }
  
  public void setAppId(String paramString)
  {
    y.i("MicroMsg.FtsWebVideoView", "setAppId appid=%s", new Object[] { paramString });
    this.mAppId = paramString;
  }
  
  public void setAutoPlay(boolean paramBoolean)
  {
    y.i("MicroMsg.FtsWebVideoView", "setAutoPlay =%b", new Object[] { Boolean.valueOf(paramBoolean) });
    this.mAutoPlay = paramBoolean;
  }
  
  public void setCallback(d paramd)
  {
    this.raN = paramd;
  }
  
  public void setCookieData(String paramString)
  {
    this.gDy = paramString;
  }
  
  public final void setCover$16da05f7(String paramString)
  {
    y.i("MicroMsg.FtsWebVideoView", "setCover coverUrl=%s", new Object[] { paramString });
    if (bk.bl(paramString)) {
      return;
    }
    this.gDJ = paramString;
    b.JD().a(this.gDu, paramString, null, null);
  }
  
  public void setDisableScroll(boolean paramBoolean)
  {
    y.i("MicroMsg.FtsWebVideoView", "setDisableScroll isDisableScroll=%b", new Object[] { Boolean.valueOf(paramBoolean) });
    this.raK = paramBoolean;
  }
  
  public void setDuration(int paramInt)
  {
    if (paramInt <= 0) {
      y.i("MicroMsg.FtsWebVideoView", "setDuration error duration=%d", new Object[] { Integer.valueOf(paramInt) });
    }
  }
  
  public void setFullScreenDelegate(FtsWebVideoView.a parama)
  {
    this.raM = parama;
  }
  
  public void setFullScreenDirection(String paramString)
  {
    y.i("MicroMsg.FtsWebVideoView", "setFullScreenDirection %s", new Object[] { paramString });
    if ("horizontal".equalsIgnoreCase(paramString))
    {
      this.raA = FtsWebVideoView.b.raY;
      return;
    }
    if ("vertical".equalsIgnoreCase(paramString))
    {
      this.raA = FtsWebVideoView.b.raZ;
      return;
    }
    this.raA = FtsWebVideoView.b.raX;
  }
  
  public void setInitialTime(int paramInt)
  {
    y.i("MicroMsg.FtsWebVideoView", "setInitialTime initialTime=%d", new Object[] { Integer.valueOf(paramInt) });
    this.gDI = paramInt;
  }
  
  public void setIsShowBasicControls(boolean paramBoolean)
  {
    y.i("MicroMsg.FtsWebVideoView", "setIsShowBasicControls isShowBasicControls=%b", new Object[] { Boolean.valueOf(paramBoolean) });
    this.gDB = paramBoolean;
  }
  
  public void setLoop(boolean paramBoolean)
  {
    y.i("MicroMsg.FtsWebVideoView", "setLoop loop=%b", new Object[] { Boolean.valueOf(paramBoolean) });
    this.gDH = paramBoolean;
  }
  
  public void setMute(boolean paramBoolean)
  {
    y.i("MicroMsg.FtsWebVideoView", "setMute isMute=%b", new Object[] { Boolean.valueOf(paramBoolean) });
    this.dnJ = paramBoolean;
    this.raB.setMute(paramBoolean);
    if (paramBoolean)
    {
      this.raC.AU();
      return;
    }
    this.raC.cab();
  }
  
  public void setObjectFit(String paramString)
  {
    y.i("MicroMsg.FtsWebVideoView", "setObjectFit objectFit=%s", new Object[] { paramString });
    if ("fill".equalsIgnoreCase(paramString))
    {
      this.raB.setScaleType(h.d.rZR);
      this.gDu.setScaleType(ImageView.ScaleType.FIT_XY);
      return;
    }
    if ("cover".equalsIgnoreCase(paramString))
    {
      this.raB.setScaleType(h.d.rZT);
      this.gDu.setScaleType(ImageView.ScaleType.CENTER_CROP);
      return;
    }
    this.raB.setScaleType(h.d.rZS);
    this.gDu.setScaleType(ImageView.ScaleType.FIT_CENTER);
  }
  
  public void setPageGesture(boolean paramBoolean)
  {
    y.i("MicroMsg.FtsWebVideoView", "setPageGesture pageGesture=%b", new Object[] { Boolean.valueOf(paramBoolean) });
    this.gDD = paramBoolean;
  }
  
  public void setUiLifecycleListener(b.a parama)
  {
    this.raO = parama;
  }
  
  public void setVideoPlayerId(int paramInt)
  {
    this.gDz = paramInt;
  }
  
  public void setVideoSizeByte(int paramInt)
  {
    this.raP = paramInt;
  }
  
  public final void stop()
  {
    y.i("MicroMsg.FtsWebVideoView", "stop");
    if (!this.raB.isPlaying()) {}
    WebSearchWebVideoViewControlBar localWebSearchWebVideoViewControlBar;
    do
    {
      return;
      this.raB.stop();
      localWebSearchWebVideoViewControlBar = this.raC;
    } while (localWebSearchWebVideoViewControlBar.gEg == null);
    localWebSearchWebVideoViewControlBar.gEg.stopTimer();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.fts.ui.FtsWebVideoView
 * JD-Core Version:    0.7.0.1
 */