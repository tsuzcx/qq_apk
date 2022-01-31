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
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.modelappbrand.a.b;
import com.tencent.mm.plugin.websearch.ui.WebSearchDotPercentIndicator;
import com.tencent.mm.plugin.websearch.ui.WebSearchWebVideoViewControlBar;
import com.tencent.mm.plugin.websearch.ui.WebSearchWebVideoViewControlBar.2;
import com.tencent.mm.plugin.webview.fts.c.b.a;
import com.tencent.mm.plugin.webview.fts.c.c;
import com.tencent.mm.plugin.webview.fts.c.d;
import com.tencent.mm.pluginsdk.ui.h.d;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.at;
import com.tencent.mm.sdk.platformtools.bo;
import java.math.BigDecimal;

public class FtsWebVideoView
  extends RelativeLayout
{
  public boolean efg;
  private String icA;
  private int icB;
  private boolean icD;
  private boolean icF;
  private boolean icJ;
  private boolean icK;
  private String icM;
  private TextView icm;
  private LinearLayout ics;
  private TextView icu;
  private ImageView icv;
  private ImageView icw;
  private boolean isLoading;
  private String mAppId;
  private boolean mAutoPlay;
  private ImageView thR;
  private ImageView uLw;
  private View uQA;
  private View uQB;
  private FtsWebVideoView.c uQC;
  public BroadcastReceiver uQD;
  private FtsWebVideoView.b uQh;
  public FtsVideoWrapper uQi;
  public WebSearchWebVideoViewControlBar uQj;
  private View uQk;
  private View uQl;
  private WebSearchDotPercentIndicator uQm;
  private View uQn;
  private Button uQo;
  private TextView uQp;
  private TextView uQq;
  private boolean uQr;
  private a uQs;
  private FtsWebVideoView.a uQt;
  private int uQu;
  private d uQv;
  private b.a uQw;
  private int uQx;
  private boolean uQy;
  private long uQz;
  private String url;
  
  public FtsWebVideoView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(5864);
    this.uQh = FtsWebVideoView.b.uQF;
    this.uQC = FtsWebVideoView.c.uQJ;
    this.uQD = new FtsWebVideoView.10(this);
    init(paramContext);
    AppMethodBeat.o(5864);
  }
  
  public FtsWebVideoView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(5865);
    this.uQh = FtsWebVideoView.b.uQF;
    this.uQC = FtsWebVideoView.c.uQJ;
    this.uQD = new FtsWebVideoView.10(this);
    init(paramContext);
    AppMethodBeat.o(5865);
  }
  
  public FtsWebVideoView(Context paramContext, boolean paramBoolean)
  {
    super(paramContext);
    AppMethodBeat.i(5863);
    this.uQh = FtsWebVideoView.b.uQF;
    this.uQC = FtsWebVideoView.c.uQJ;
    this.uQD = new FtsWebVideoView.10(this);
    setAutoPlay(paramBoolean);
    init(paramContext);
    AppMethodBeat.o(5863);
  }
  
  private void aEN()
  {
    AppMethodBeat.i(5893);
    this.uQs = new a(getContext(), this, new FtsWebVideoView.12(this));
    AppMethodBeat.o(5893);
  }
  
  private void aEP()
  {
    AppMethodBeat.i(5894);
    this.uQi.setIMMVideoViewCallback(new FtsWebVideoView.13(this));
    AppMethodBeat.o(5894);
  }
  
  private void daH()
  {
    AppMethodBeat.i(5871);
    if (aEQ())
    {
      this.uLw.setVisibility(0);
      AppMethodBeat.o(5871);
      return;
    }
    this.uLw.setVisibility(8);
    AppMethodBeat.o(5871);
  }
  
  private void daI()
  {
    AppMethodBeat.i(5877);
    this.uQk.setVisibility(8);
    AppMethodBeat.o(5877);
  }
  
  private boolean daJ()
  {
    AppMethodBeat.i(5897);
    if ((this.icD) && (!daK()))
    {
      AppMethodBeat.o(5897);
      return true;
    }
    AppMethodBeat.o(5897);
    return false;
  }
  
  private boolean daK()
  {
    AppMethodBeat.i(5898);
    if (this.uQk.getVisibility() == 0)
    {
      AppMethodBeat.o(5898);
      return true;
    }
    AppMethodBeat.o(5898);
    return false;
  }
  
  private void daL()
  {
    AppMethodBeat.i(5901);
    this.uQj = new WebSearchWebVideoViewControlBar(getContext());
    this.uQj.setVisibility(8);
    this.uQj.setEnterFullScreenBtnClickListener(new FtsWebVideoView.14(this));
    this.uQj.setExitFullScreenBtnClickListener(new FtsWebVideoView.2(this));
    this.uQj.setMuteBtnOnClickListener(new FtsWebVideoView.3(this));
    this.uQj.setIplaySeekCallback(new FtsWebVideoView.4(this));
    this.uQj.setOnPlayButtonClickListener(new FtsWebVideoView.5(this));
    this.uQj.setStatePorter(new FtsWebVideoView.6(this));
    this.uQi.setVideoFooterView(this.uQj);
    AppMethodBeat.o(5901);
  }
  
  private boolean fu(final Context paramContext)
  {
    AppMethodBeat.i(5867);
    Object localObject = this.uQC;
    if (at.isConnected(paramContext))
    {
      if ((!this.uQy) && (!at.isWifi(paramContext)))
      {
        pause();
        this.uQC = FtsWebVideoView.c.uQK;
        this.uQj.setVisibility(8);
        localObject = getNetUnavailableTip();
        String str = paramContext.getString(2131304508);
        paramContext.getString(2131304505);
        ho((String)localObject, str);
        AppMethodBeat.o(5867);
        return false;
      }
    }
    else
    {
      if (localObject == FtsWebVideoView.c.uQL)
      {
        this.uQA.setVisibility(0);
        this.uQB.setVisibility(8);
        this.uQk.setVisibility(0);
        postDelayed(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(5836);
            FtsWebVideoView.b(FtsWebVideoView.this, paramContext);
            AppMethodBeat.o(5836);
          }
        }, 200L);
      }
      for (;;)
      {
        AppMethodBeat.o(5867);
        return false;
        fv(paramContext);
      }
    }
    AppMethodBeat.o(5867);
    return true;
  }
  
  private void fv(Context paramContext)
  {
    AppMethodBeat.i(5868);
    this.uQC = FtsWebVideoView.c.uQL;
    pause();
    ho(paramContext.getString(2131304523), paramContext.getString(2131304536));
    AppMethodBeat.o(5868);
  }
  
  private String getNetUnavailableTip()
  {
    AppMethodBeat.i(5869);
    Object localObject;
    if (this.uQx == 0)
    {
      localObject = getContext().getString(2131304525);
      AppMethodBeat.o(5869);
      return localObject;
    }
    Context localContext = getContext();
    long l = this.uQx;
    if (l < 0L) {
      localObject = "";
    }
    for (;;)
    {
      localObject = localContext.getString(2131304524, new Object[] { localObject });
      AppMethodBeat.o(5869);
      return localObject;
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
  
  private void ho(String paramString1, String paramString2)
  {
    AppMethodBeat.i(5870);
    daI();
    this.uQA.setVisibility(8);
    this.uQB.setVisibility(0);
    this.uQj.setVisibility(8);
    this.uQk.setVisibility(0);
    if (!TextUtils.isEmpty(paramString1))
    {
      this.uQq.setText(paramString1);
      this.uQq.setVisibility(0);
      if (TextUtils.isEmpty(paramString2)) {
        break label139;
      }
      this.uQo.setText(paramString2);
      this.uQo.setVisibility(0);
    }
    for (;;)
    {
      this.uQl.setVisibility(0);
      this.uQn.setVisibility(8);
      this.uQp.setVisibility(8);
      daH();
      AppMethodBeat.o(5870);
      return;
      this.uQq.setVisibility(8);
      break;
      label139:
      this.uQo.setVisibility(8);
    }
  }
  
  private void init(Context paramContext)
  {
    AppMethodBeat.i(5866);
    LayoutInflater.from(paramContext).inflate(2130969680, this);
    this.uQi = ((FtsVideoWrapper)findViewById(2131821436));
    this.icm = ((TextView)findViewById(2131821404));
    this.uQk = findViewById(2131824406);
    this.uQl = findViewById(2131824409);
    this.ics = ((LinearLayout)findViewById(2131821443));
    this.uQm = ((WebSearchDotPercentIndicator)findViewById(2131821446));
    this.icu = ((TextView)findViewById(2131821445));
    this.icv = ((ImageView)findViewById(2131821444));
    this.icw = ((ImageView)findViewById(2131821438));
    this.uQA = findViewById(2131821842);
    this.uQB = findViewById(2131824410);
    this.uQm.setDotsNum(8);
    this.thR = ((ImageView)findViewById(2131824408));
    this.uQn = findViewById(2131824407);
    this.uQp = ((TextView)findViewById(2131824413));
    this.uQo = ((Button)findViewById(2131824412));
    this.uQq = ((TextView)findViewById(2131824411));
    this.uLw = ((ImageView)findViewById(2131821456));
    this.uQp.setOnClickListener(new FtsWebVideoView.1(this));
    this.uLw.setOnClickListener(new FtsWebVideoView.7(this));
    this.uQo.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(5833);
        if (FtsWebVideoView.a(FtsWebVideoView.this) == FtsWebVideoView.c.uQK) {
          FtsWebVideoView.b(FtsWebVideoView.this);
        }
        FtsWebVideoView.this.start(true);
        AppMethodBeat.o(5833);
      }
    });
    this.uQn.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(5834);
        FtsWebVideoView.this.start(true);
        FtsWebVideoView.c(FtsWebVideoView.this).aFn();
        AppMethodBeat.o(5834);
      }
    });
    aEN();
    aEP();
    daL();
    paramContext.registerReceiver(this.uQD, new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE"));
    daI();
    AppMethodBeat.o(5866);
  }
  
  private boolean isLive()
  {
    AppMethodBeat.i(5903);
    ab.i("MicroMsg.FtsWebVideoView", "isLive %b %b", new Object[] { Boolean.valueOf(this.icJ), Boolean.valueOf(this.uQi.isLive()) });
    if ((this.icJ) || (this.uQi.isLive()))
    {
      AppMethodBeat.o(5903);
      return true;
    }
    AppMethodBeat.o(5903);
    return false;
  }
  
  private void setCover(String paramString)
  {
    AppMethodBeat.i(5884);
    if (bo.isNullOrNil(paramString))
    {
      AppMethodBeat.o(5884);
      return;
    }
    if (!bo.isNullOrNil(this.icM))
    {
      ab.i("MicroMsg.FtsWebVideoView", "setCover mCoverUrl not null");
      AppMethodBeat.o(5884);
      return;
    }
    AppMethodBeat.o(5884);
  }
  
  public final boolean aEQ()
  {
    AppMethodBeat.i(5900);
    if (this.uQt == null)
    {
      ab.w("MicroMsg.FtsWebVideoView", "isInFullScreen mFullScreenDelegate null");
      AppMethodBeat.o(5900);
      return false;
    }
    boolean bool = this.uQt.isFullScreen();
    AppMethodBeat.o(5900);
    return bool;
  }
  
  public final void at(int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(5881);
    ab.i("MicroMsg.FtsWebVideoView", "seek to position=%d current=%d isLive=%b", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(this.uQi.getCurrPosSec()), Boolean.valueOf(this.icJ) });
    if (isLive())
    {
      AppMethodBeat.o(5881);
      return;
    }
    if (paramBoolean)
    {
      this.uQi.d(paramInt, paramBoolean);
      AppMethodBeat.o(5881);
      return;
    }
    this.uQi.r(paramInt);
    AppMethodBeat.o(5881);
  }
  
  public final void dM(String paramString, int paramInt)
  {
    AppMethodBeat.i(5880);
    ab.i("MicroMsg.FtsWebVideoView", "setVideoPath path=%s isLive=%s", new Object[] { paramString, Boolean.FALSE });
    this.url = paramString;
    if (bo.isNullOrNil(paramString))
    {
      ab.v("MicroMsg.FtsWebVideoView", "setVideoPath videoPath empty");
      AppMethodBeat.o(5880);
      return;
    }
    stop();
    this.icJ = false;
    this.uQi.c(false, paramString, paramInt);
    if (this.uQj != null) {
      this.uQj.setVideoTotalTime(paramInt);
    }
    if (this.uQu > 0) {
      this.uQi.r(this.uQu);
    }
    if (this.mAutoPlay)
    {
      ab.i("MicroMsg.FtsWebVideoView", "setVideoPath autoPlay");
      start(false);
    }
    if (paramString.startsWith("wxfile://")) {
      setCover(paramString);
    }
    AppMethodBeat.o(5880);
  }
  
  public final void ey(boolean paramBoolean)
  {
    AppMethodBeat.i(5902);
    if (this.uQv == null)
    {
      AppMethodBeat.o(5902);
      return;
    }
    if (this.uQh == FtsWebVideoView.b.uQH) {}
    for (String str = "vertical";; str = "horizontal")
    {
      this.uQv.b(this.icB, paramBoolean, str);
      daH();
      AppMethodBeat.o(5902);
      return;
    }
  }
  
  public d getCallback()
  {
    return this.uQv;
  }
  
  public String getCookieData()
  {
    return this.icA;
  }
  
  public int getCurrPosMs()
  {
    AppMethodBeat.i(5888);
    int i = this.uQi.getCurrPosMs();
    AppMethodBeat.o(5888);
    return i;
  }
  
  public int getCurrPosSec()
  {
    AppMethodBeat.i(5887);
    int i = this.uQi.getCurrPosSec();
    AppMethodBeat.o(5887);
    return i;
  }
  
  public int getSystemVolume()
  {
    AppMethodBeat.i(5896);
    int i = ((AudioManager)getContext().getSystemService("audio")).getStreamVolume(3);
    AppMethodBeat.o(5896);
    return i;
  }
  
  public b.a getUiLifecycleListener()
  {
    return this.uQw;
  }
  
  public int getVideoSizeByte()
  {
    return this.uQx;
  }
  
  public int getmVideoPlayerId()
  {
    return this.icB;
  }
  
  public final void ok(boolean paramBoolean)
  {
    boolean bool = false;
    AppMethodBeat.i(5899);
    ab.i("MicroMsg.FtsWebVideoView", "operateFullScreen toFullScreen=%b", new Object[] { Boolean.valueOf(paramBoolean) });
    if (this.uQt == null)
    {
      ab.w("MicroMsg.FtsWebVideoView", "operateFullScreen mFullScreenDelegate null");
      AppMethodBeat.o(5899);
      return;
    }
    if (paramBoolean == aEQ())
    {
      ab.i("MicroMsg.FtsWebVideoView", "operateFullScreen current same");
      AppMethodBeat.o(5899);
      return;
    }
    if (paramBoolean)
    {
      Object localObject = this.uQt;
      paramBoolean = bool;
      if (this.uQh != FtsWebVideoView.b.uQH) {
        paramBoolean = true;
      }
      ((FtsWebVideoView.a)localObject).ol(paramBoolean);
      localObject = this.uQj;
      ((WebSearchWebVideoViewControlBar)localObject).idm = true;
      ((WebSearchWebVideoViewControlBar)localObject).aFr();
      ey(true);
      AppMethodBeat.o(5899);
      return;
    }
    this.uQt.aDh();
    this.uQj.aDh();
    AppMethodBeat.o(5899);
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(5895);
    if ((this.icF) || (aEQ()))
    {
      a locala;
      if (this.uQs != null)
      {
        locala = this.uQs;
        if (locala.uQa.cJx())
        {
          int i = paramMotionEvent.getActionMasked();
          if (i == 0)
          {
            locala.iea = paramMotionEvent.getRawX();
            locala.De = ((AudioManager)locala.mContext.getSystemService("audio")).getStreamVolume(3);
            locala.iaW = c.cP(locala.mContext);
          }
          locala.idY.onTouchEvent(paramMotionEvent);
          if ((i != 1) && (i != 3)) {
            break label182;
          }
          if (locala.uPZ != a.a.uQf) {
            break label190;
          }
          locala.uQa.i(locala.iec, paramMotionEvent.getRawX() - locala.iea);
          locala.ieb = -1;
          locala.iec = 0;
          locala.iea = 0.0F;
        }
      }
      for (;;)
      {
        locala.uPZ = a.a.uQc;
        label182:
        AppMethodBeat.o(5895);
        return true;
        label190:
        if (locala.uPZ == a.a.uQd)
        {
          ((AudioManager)locala.mContext.getSystemService("audio")).getStreamMaxVolume(3);
          locala.uQa.aFa();
        }
        else if (locala.uPZ == a.a.uQe)
        {
          locala.uQa.aFb();
        }
      }
    }
    if ((paramMotionEvent.getAction() == 0) && (daJ())) {
      this.uQj.oj(this.isLoading);
    }
    boolean bool = super.onTouchEvent(paramMotionEvent);
    AppMethodBeat.o(5895);
    return bool;
  }
  
  public final void pause()
  {
    AppMethodBeat.i(5878);
    ab.i("MicroMsg.FtsWebVideoView", "pause");
    daI();
    if (!this.uQi.isPlaying())
    {
      AppMethodBeat.o(5878);
      return;
    }
    this.uQi.pause();
    AppMethodBeat.o(5878);
  }
  
  public void setAllowMobileNetPlay(boolean paramBoolean)
  {
    this.uQy = paramBoolean;
  }
  
  public void setAppId(String paramString)
  {
    AppMethodBeat.i(5872);
    ab.i("MicroMsg.FtsWebVideoView", "setAppId appid=%s", new Object[] { paramString });
    this.mAppId = paramString;
    AppMethodBeat.o(5872);
  }
  
  public void setAutoPlay(boolean paramBoolean)
  {
    AppMethodBeat.i(5873);
    ab.i("MicroMsg.FtsWebVideoView", "setAutoPlay =%b", new Object[] { Boolean.valueOf(paramBoolean) });
    this.mAutoPlay = paramBoolean;
    AppMethodBeat.o(5873);
  }
  
  public void setCallback(d paramd)
  {
    this.uQv = paramd;
  }
  
  public void setCookieData(String paramString)
  {
    this.icA = paramString;
  }
  
  public final void setCover$16da05f7(String paramString)
  {
    AppMethodBeat.i(5883);
    ab.i("MicroMsg.FtsWebVideoView", "setCover coverUrl=%s", new Object[] { paramString });
    if (bo.isNullOrNil(paramString))
    {
      AppMethodBeat.o(5883);
      return;
    }
    this.icM = paramString;
    b.acD().a(this.icw, paramString, null, null);
    AppMethodBeat.o(5883);
  }
  
  public void setDisableScroll(boolean paramBoolean)
  {
    AppMethodBeat.i(5890);
    ab.i("MicroMsg.FtsWebVideoView", "setDisableScroll isDisableScroll=%b", new Object[] { Boolean.valueOf(paramBoolean) });
    this.uQr = paramBoolean;
    AppMethodBeat.o(5890);
  }
  
  public void setDuration(int paramInt)
  {
    AppMethodBeat.i(5874);
    if (paramInt <= 0)
    {
      ab.i("MicroMsg.FtsWebVideoView", "setDuration error duration=%d", new Object[] { Integer.valueOf(paramInt) });
      AppMethodBeat.o(5874);
      return;
    }
    AppMethodBeat.o(5874);
  }
  
  public void setFullScreenDelegate(FtsWebVideoView.a parama)
  {
    this.uQt = parama;
  }
  
  public void setFullScreenDirection(String paramString)
  {
    AppMethodBeat.i(5889);
    ab.i("MicroMsg.FtsWebVideoView", "setFullScreenDirection %s", new Object[] { paramString });
    if ("horizontal".equalsIgnoreCase(paramString))
    {
      this.uQh = FtsWebVideoView.b.uQG;
      AppMethodBeat.o(5889);
      return;
    }
    if ("vertical".equalsIgnoreCase(paramString))
    {
      this.uQh = FtsWebVideoView.b.uQH;
      AppMethodBeat.o(5889);
      return;
    }
    this.uQh = FtsWebVideoView.b.uQF;
    AppMethodBeat.o(5889);
  }
  
  public void setInitialTime(int paramInt)
  {
    AppMethodBeat.i(5892);
    ab.i("MicroMsg.FtsWebVideoView", "setInitialTime initialTime=%d", new Object[] { Integer.valueOf(paramInt) });
    this.uQu = paramInt;
    AppMethodBeat.o(5892);
  }
  
  public void setIsShowBasicControls(boolean paramBoolean)
  {
    AppMethodBeat.i(5882);
    ab.i("MicroMsg.FtsWebVideoView", "setIsShowBasicControls isShowBasicControls=%b", new Object[] { Boolean.valueOf(paramBoolean) });
    this.icD = paramBoolean;
    AppMethodBeat.o(5882);
  }
  
  public void setLoop(boolean paramBoolean)
  {
    AppMethodBeat.i(5875);
    ab.i("MicroMsg.FtsWebVideoView", "setLoop loop=%b", new Object[] { Boolean.valueOf(paramBoolean) });
    this.icK = paramBoolean;
    AppMethodBeat.o(5875);
  }
  
  public void setMute(boolean paramBoolean)
  {
    AppMethodBeat.i(5886);
    ab.i("MicroMsg.FtsWebVideoView", "setMute isMute=%b", new Object[] { Boolean.valueOf(paramBoolean) });
    this.efg = paramBoolean;
    this.uQi.setMute(paramBoolean);
    if (paramBoolean)
    {
      this.uQj.NK();
      AppMethodBeat.o(5886);
      return;
    }
    this.uQj.cZY();
    AppMethodBeat.o(5886);
  }
  
  public void setObjectFit(String paramString)
  {
    AppMethodBeat.i(5885);
    ab.i("MicroMsg.FtsWebVideoView", "setObjectFit objectFit=%s", new Object[] { paramString });
    if ("fill".equalsIgnoreCase(paramString))
    {
      this.uQi.setScaleType(h.d.vQJ);
      this.icw.setScaleType(ImageView.ScaleType.FIT_XY);
      AppMethodBeat.o(5885);
      return;
    }
    if ("cover".equalsIgnoreCase(paramString))
    {
      this.uQi.setScaleType(h.d.vQL);
      this.icw.setScaleType(ImageView.ScaleType.CENTER_CROP);
      AppMethodBeat.o(5885);
      return;
    }
    this.uQi.setScaleType(h.d.vQK);
    this.icw.setScaleType(ImageView.ScaleType.FIT_CENTER);
    AppMethodBeat.o(5885);
  }
  
  public void setPageGesture(boolean paramBoolean)
  {
    AppMethodBeat.i(5891);
    ab.i("MicroMsg.FtsWebVideoView", "setPageGesture pageGesture=%b", new Object[] { Boolean.valueOf(paramBoolean) });
    this.icF = paramBoolean;
    AppMethodBeat.o(5891);
  }
  
  public void setUiLifecycleListener(b.a parama)
  {
    this.uQw = parama;
  }
  
  public void setVideoPlayerId(int paramInt)
  {
    this.icB = paramInt;
  }
  
  public void setVideoSizeByte(int paramInt)
  {
    this.uQx = paramInt;
  }
  
  public final void start(boolean paramBoolean)
  {
    AppMethodBeat.i(5876);
    ab.i("MicroMsg.FtsWebVideoView", "start");
    daI();
    if ((paramBoolean) && (!fu(getContext())))
    {
      ab.i("MicroMsg.FtsWebVideoView", "start network is not wifi");
      AppMethodBeat.o(5876);
      return;
    }
    this.uQC = FtsWebVideoView.c.uQJ;
    if (this.uQi.isPlaying())
    {
      AppMethodBeat.o(5876);
      return;
    }
    if (this.icD)
    {
      WebSearchWebVideoViewControlBar localWebSearchWebVideoViewControlBar = this.uQj;
      if (localWebSearchWebVideoViewControlBar.idl == null) {
        localWebSearchWebVideoViewControlBar.idl = new ap(new WebSearchWebVideoViewControlBar.2(localWebSearchWebVideoViewControlBar), true);
      }
      localWebSearchWebVideoViewControlBar.aFx();
      localWebSearchWebVideoViewControlBar.idl.stopTimer();
      localWebSearchWebVideoViewControlBar.idl.ag(500L, 500L);
    }
    this.uQi.start();
    if (this.uQz == 0L)
    {
      this.uQz = System.currentTimeMillis();
      AppMethodBeat.o(5876);
      return;
    }
    this.uQz = 9223372036854775807L;
    AppMethodBeat.o(5876);
  }
  
  public final void stop()
  {
    AppMethodBeat.i(5879);
    ab.i("MicroMsg.FtsWebVideoView", "stop");
    if (!this.uQi.isPlaying())
    {
      AppMethodBeat.o(5879);
      return;
    }
    this.uQi.stop();
    WebSearchWebVideoViewControlBar localWebSearchWebVideoViewControlBar = this.uQj;
    if (localWebSearchWebVideoViewControlBar.idl != null) {
      localWebSearchWebVideoViewControlBar.idl.stopTimer();
    }
    AppMethodBeat.o(5879);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.fts.ui.FtsWebVideoView
 * JD-Core Version:    0.7.0.1
 */