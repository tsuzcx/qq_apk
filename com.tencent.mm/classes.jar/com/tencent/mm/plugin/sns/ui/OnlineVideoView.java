package com.tencent.mm.plugin.sns.ui;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Looper;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.cm;
import com.tencent.mm.g.a.cm.b;
import com.tencent.mm.g.a.rl;
import com.tencent.mm.g.a.sl;
import com.tencent.mm.model.d.a;
import com.tencent.mm.modelvideo.u;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.sns.data.i;
import com.tencent.mm.plugin.sns.model.ag;
import com.tencent.mm.plugin.sns.model.ao;
import com.tencent.mm.plugin.sns.model.ar;
import com.tencent.mm.plugin.sns.model.b.b;
import com.tencent.mm.plugin.sns.storage.n;
import com.tencent.mm.pluginsdk.ui.h.d;
import com.tencent.mm.pluginsdk.ui.tools.VideoPlayerTextureView;
import com.tencent.mm.pluginsdk.ui.tools.VideoTextureView;
import com.tencent.mm.pluginsdk.ui.tools.e.a;
import com.tencent.mm.pluginsdk.ui.tools.e.e;
import com.tencent.mm.protocal.protobuf.bcs;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.ap.a;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.ac.a;
import com.tencent.mm.storage.az;
import com.tencent.mm.storage.z;
import com.tencent.mm.ui.widget.MMPinProgressBtn;
import java.util.HashMap;

public class OnlineVideoView
  extends RelativeLayout
  implements d.a, ae.a, e.a
{
  private int cIH;
  private boolean cII;
  private int cIJ;
  private bcs cIc;
  private String cpW;
  private String ctV;
  private String czw;
  private int duration;
  private boolean efg;
  private int fDT;
  private String filePath;
  com.tencent.mm.model.d idF;
  ak kuE;
  protected com.tencent.mm.pluginsdk.ui.tools.e kvG;
  private ap kvM;
  ImageView mAM;
  private RelativeLayout mBh;
  private Context mContext;
  private TextView mEu;
  private boolean mEv;
  private boolean mEw;
  private int mEx;
  private ProgressBar mEy;
  private MMPinProgressBtn mEz;
  boolean ndT;
  private com.tencent.mm.plugin.n.b oEQ;
  private boolean rIW;
  private e.e rIZ;
  private boolean rJA;
  private int rJd;
  String rJe;
  private boolean rJf;
  private a rJg;
  private TextView rJh;
  protected ae rJi;
  private boolean rJj;
  private boolean rJk;
  private int rJl;
  private int rJm;
  private long rJn;
  private long rJo;
  protected boolean rJp;
  private long rJq;
  protected Activity rJr;
  protected boolean rJs;
  private b.b rJt;
  private c rJu;
  private c rJv;
  private long rJw;
  private int rJx;
  private long rJy;
  private int rJz;
  private az rbm;
  private c riF;
  private ap ryl;
  private int scene;
  
  public OnlineVideoView(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public OnlineVideoView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public OnlineVideoView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(38407);
    this.rJd = 0;
    this.ndT = false;
    this.mEv = false;
    this.efg = false;
    this.cIc = null;
    this.rJf = false;
    this.rJi = null;
    this.rJk = false;
    this.duration = 0;
    this.rJl = 0;
    this.rJm = 0;
    this.rJn = 0L;
    this.rJo = 0L;
    this.mEx = 0;
    this.idF = null;
    this.rJp = true;
    this.kuE = new ak(Looper.getMainLooper());
    this.scene = 0;
    this.rJq = 0L;
    this.cpW = "";
    this.czw = "";
    this.filePath = "";
    this.rJs = false;
    this.ryl = new ap(new OnlineVideoView.16(this), true);
    this.kvM = new ap(new ap.a()
    {
      public final boolean onTimerExpired()
      {
        AppMethodBeat.i(38406);
        if (OnlineVideoView.this.kvG == null)
        {
          AppMethodBeat.o(38406);
          return false;
        }
        if (((View)OnlineVideoView.this.kvG).getAlpha() < 1.0F)
        {
          ab.i("MicroMsg.OnlineVideoView", "offlineVideoTimer switchVideoModel");
          OnlineVideoView.k(OnlineVideoView.this);
        }
        if (OnlineVideoView.this.kvG.isPlaying())
        {
          OnlineVideoView.l(OnlineVideoView.this);
          OnlineVideoView.this.kvG.getCurrentPosition();
        }
        AppMethodBeat.o(38406);
        return true;
      }
    }, true);
    this.rJt = new b.b()
    {
      public final void ZU(String paramAnonymousString) {}
      
      public final void bp(String paramAnonymousString, boolean paramAnonymousBoolean) {}
      
      public final void bq(String paramAnonymousString, boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(38386);
        OnlineVideoView.m(OnlineVideoView.this).postDelayed(new OnlineVideoView.2.1(this, paramAnonymousBoolean, paramAnonymousString), 100L);
        AppMethodBeat.o(38386);
      }
      
      public final void cnV() {}
    };
    this.rJu = new c() {};
    this.rJv = new OnlineVideoView.4(this);
    this.riF = new OnlineVideoView.5(this);
    this.rIZ = new OnlineVideoView.6(this);
    this.oEQ = new OnlineVideoView.7(this);
    this.rJA = true;
    this.mContext = paramContext;
    ab.i("MicroMsg.OnlineVideoView", "%d ui init view.", new Object[] { Integer.valueOf(hashCode()) });
    LayoutInflater.from(paramContext).inflate(2130970897, this);
    this.mAM = ((ImageView)findViewById(2131822189));
    this.mBh = ((RelativeLayout)findViewById(2131822190));
    this.rJh = ((TextView)findViewById(2131822191));
    this.rJh.setVisibility(8);
    this.mEz = ((MMPinProgressBtn)findViewById(2131822192));
    this.mEy = ((ProgressBar)findViewById(2131821842));
    this.mEu = ((TextView)findViewById(2131822194));
    com.tencent.mm.modelcontrol.d.afW();
    if (com.tencent.mm.modelcontrol.d.agf())
    {
      this.mEw = true;
      this.kvG = new VideoPlayerTextureView(paramContext);
      ((VideoPlayerTextureView)this.kvG).setIOnlineCache(this.oEQ);
      ((VideoPlayerTextureView)this.kvG).setOpenWithNoneSurface(true);
      h.qsU.idkeyStat(354L, 148L, 1L, false);
    }
    for (;;)
    {
      this.kvG.setVideoCallback(this);
      paramContext = new RelativeLayout.LayoutParams(-1, -2);
      paramContext.addRule(13);
      this.mBh.addView((View)this.kvG, paramContext);
      ab.i("MicroMsg.OnlineVideoView", "%d switch sync video model isVideoPlay %b %f", new Object[] { Integer.valueOf(hashCode()), Boolean.FALSE, Float.valueOf(0.0F) });
      paramContext = (View)this.kvG;
      this.mBh.setVisibility(8);
      paramContext.setVisibility(8);
      if (this.rJA) {
        this.mAM.setVisibility(0);
      }
      AppMethodBeat.o(38407);
      return;
      this.mEw = false;
      this.kvG = new VideoTextureView(paramContext);
      h.qsU.idkeyStat(354L, 149L, 1L, false);
    }
  }
  
  private void D(boolean paramBoolean, int paramInt)
  {
    boolean bool = true;
    AppMethodBeat.i(38420);
    if (this.cIc == null)
    {
      ab.w("MicroMsg.OnlineVideoView", "%d start download video but media is null.", new Object[] { Integer.valueOf(hashCode()) });
      AppMethodBeat.o(38420);
      return;
    }
    if (this.rJi == null)
    {
      ab.w("MicroMsg.OnlineVideoView", "%d start download video but helper is null.", new Object[] { Integer.valueOf(hashCode()) });
      AppMethodBeat.o(38420);
      return;
    }
    if (this.cIc.xrR == 2)
    {
      ab.w("MicroMsg.OnlineVideoView", "%d it start download video, url type is weixin", new Object[] { Integer.valueOf(hashCode()) });
      this.rJd = 3;
      ag.cpa().a(this.cIc, 4, null, this.rbm);
      AppMethodBeat.o(38420);
      return;
    }
    int i;
    if (!paramBoolean)
    {
      com.tencent.mm.modelcontrol.d.afW();
      if (com.tencent.mm.modelcontrol.d.age())
      {
        ab.i("MicroMsg.OnlineVideoView", "%d it start online download video", new Object[] { Integer.valueOf(hashCode()) });
        this.rJd = 1;
        i = paramInt;
        if (paramInt == 0) {
          i = 30;
        }
        paramBoolean = bool;
        this.rJi.a(this.cIc, this.fDT, this.ctV, paramBoolean, i);
        AppMethodBeat.o(38420);
        return;
      }
    }
    ab.i("MicroMsg.OnlineVideoView", "%d it start offline download video", new Object[] { Integer.valueOf(hashCode()) });
    this.rJd = 2;
    if (paramInt != 0) {}
    for (;;)
    {
      paramBoolean = false;
      i = paramInt;
      break;
      paramInt = 31;
    }
  }
  
  private void EH(int paramInt)
  {
    AppMethodBeat.i(38415);
    String str = ao.gl(ag.getAccSnsPath(), this.cIc.Id) + i.e(this.cIc);
    Intent localIntent = new Intent();
    localIntent.putExtra("Select_Conv_Type", 3);
    localIntent.putExtra("select_is_ret", true);
    localIntent.putExtra("mutil_select_is_ret", true);
    localIntent.putExtra("image_path", str);
    localIntent.putExtra("Retr_Msg_Type", 11);
    ab.i("MicroMsg.OnlineVideoView", "send video path %s reqCode %d", new Object[] { str, Integer.valueOf(paramInt) });
    com.tencent.mm.bq.d.b(getActivityContext(), ".ui.transmit.SelectConversationUI", localIntent, paramInt);
    this.cIJ = 0;
    AppMethodBeat.o(38415);
  }
  
  private void a(boolean paramBoolean, float paramFloat)
  {
    AppMethodBeat.i(38418);
    this.kuE.post(new OnlineVideoView.11(this, paramBoolean, paramFloat));
    AppMethodBeat.o(38418);
  }
  
  private void ah(final int paramInt, final boolean paramBoolean)
  {
    AppMethodBeat.i(38416);
    this.kuE.post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(38384);
        Object localObject1 = ag.cpf().abv(OnlineVideoView.a(OnlineVideoView.this));
        if (localObject1 == null)
        {
          AppMethodBeat.o(38384);
          return;
        }
        ab.i("MicroMsg.OnlineVideoView", "fav download video[%s] farFromScene %d isFromMain %b", new Object[] { OnlineVideoView.a(OnlineVideoView.this), Integer.valueOf(paramInt), Boolean.valueOf(paramBoolean) });
        Object localObject2 = new cm();
        ((cm)localObject2).cpR.cpY = paramInt;
        ((cm)localObject2).cpR.activity = ((Activity)OnlineVideoView.this.getActivityContext());
        com.tencent.mm.plugin.sns.j.a.a((cm)localObject2, (n)localObject1);
        com.tencent.mm.sdk.b.a.ymk.l((com.tencent.mm.sdk.b.b)localObject2);
        if (((cm)localObject2).cpS.ret == 0) {
          OnlineVideoView.cud();
        }
        for (;;)
        {
          if (paramBoolean)
          {
            localObject2 = new rl();
            ((rl)localObject2).cHR.crk = ((n)localObject1).csH();
            ((rl)localObject2).cHR.czw = i.j((n)localObject1);
            com.tencent.mm.sdk.b.a.ymk.l((com.tencent.mm.sdk.b.b)localObject2);
          }
          OnlineVideoView.b(OnlineVideoView.this);
          if (OnlineVideoView.this.kvG == null) {
            break label318;
          }
          if (!bo.isNullOrNil(OnlineVideoView.this.kvG.getVideoPath())) {
            break;
          }
          ab.i("MicroMsg.OnlineVideoView", "%d had not set video path to play", new Object[] { Integer.valueOf(OnlineVideoView.this.hashCode()) });
          localObject1 = ar.a(OnlineVideoView.a(OnlineVideoView.this), OnlineVideoView.c(OnlineVideoView.this));
          if (!bo.isNullOrNil((String)localObject1)) {
            OnlineVideoView.this.bw((String)localObject1, false);
          }
          AppMethodBeat.o(38384);
          return;
          OnlineVideoView.cue();
        }
        if (!OnlineVideoView.this.kvG.isPlaying())
        {
          OnlineVideoView.this.kvG.start();
          AppMethodBeat.o(38384);
          return;
        }
        label318:
        AppMethodBeat.o(38384);
      }
    });
    AppMethodBeat.o(38416);
  }
  
  private void aoR()
  {
    try
    {
      AppMethodBeat.i(155724);
      ab.i("MicroMsg.OnlineVideoView", "%d logic unInit", new Object[] { Integer.valueOf(hashCode()) });
      cua();
      cuc();
      this.kvG.stop();
      com.tencent.mm.sdk.b.a.ymk.d(this.riF);
      com.tencent.mm.sdk.b.a.ymk.d(this.rJu);
      ag.cpa().b(this.rJt);
      ctW();
      this.kuE.removeCallbacksAndMessages(null);
      if (this.rJi != null)
      {
        this.rJi.cuf();
        this.rJi.clear();
      }
      if (com.tencent.mm.r.a.BY() != null) {
        com.tencent.mm.r.a.BY().Ib();
      }
      if (this.idF != null) {
        this.idF.cJ(false);
      }
      this.idF = null;
      this.cIc = null;
      this.ctV = null;
      this.rJi = null;
      this.rJm = 0;
      AppMethodBeat.o(155724);
      return;
    }
    finally {}
  }
  
  private void byu()
  {
    AppMethodBeat.i(38419);
    if (!this.ndT) {}
    for (String str = ar.a(this.ctV, this.cIc);; str = this.rJe)
    {
      ab.i("MicroMsg.OnlineVideoView", "%d toggleVideo local id %s finish path %s isPreview %b", new Object[] { Integer.valueOf(hashCode()), this.ctV, str, Boolean.valueOf(this.ndT) });
      if (bo.isNullOrNil(str)) {
        break;
      }
      ab.i("MicroMsg.OnlineVideoView", "%d sns video already download finish, play now", new Object[] { Integer.valueOf(hashCode()) });
      a(true, 0.0F);
      bw(str, false);
      AppMethodBeat.o(38419);
      return;
    }
    a(false, 0.0F);
    D(false, 0);
    showLoading();
    AppMethodBeat.o(38419);
  }
  
  private boolean byv()
  {
    AppMethodBeat.i(38428);
    if (!this.rJj)
    {
      AppMethodBeat.o(38428);
      return false;
    }
    com.tencent.mm.kernel.g.RM();
    boolean bool = com.tencent.mm.kernel.g.RL().Ru().getBoolean(ac.a.yFa, false);
    AppMethodBeat.o(38428);
    return bool;
  }
  
  private void ctV()
  {
    AppMethodBeat.i(38417);
    long l = bo.yB();
    String str1 = ar.a(this.ctV, this.cIc);
    String str2 = u.vs(str1);
    if (bo.isNullOrNil(str2))
    {
      Toast.makeText(this.mContext, this.mContext.getString(2131304521), 1).show();
      h.qsU.idkeyStat(354L, 222L, 1L, false);
    }
    for (;;)
    {
      this.rJf = false;
      ab.i("MicroMsg.OnlineVideoView", "%d save downloaded video finish %d %s", new Object[] { Integer.valueOf(hashCode()), Long.valueOf(bo.av(l)), str1 });
      this.kuE.post(new OnlineVideoView.10(this));
      AppMethodBeat.o(38417);
      return;
      Toast.makeText(this.mContext, this.mContext.getString(2131304522, new Object[] { str2 }), 1).show();
      com.tencent.mm.sdk.f.b.a(str2, this.mContext);
      h.qsU.idkeyStat(354L, 221L, 1L, false);
    }
  }
  
  private void ctZ()
  {
    AppMethodBeat.i(38433);
    this.rJw = bo.aoy();
    ab.d("MicroMsg.OnlineVideoView", "%d notePlayVideo notePlayVideo %d ", new Object[] { Integer.valueOf(hashCode()), Long.valueOf(this.rJw) });
    AppMethodBeat.o(38433);
  }
  
  private void cua()
  {
    AppMethodBeat.i(38434);
    if (this.rJw > 0L) {
      this.rJx = ((int)(this.rJx + (bo.aoy() - this.rJw) / 1000L));
    }
    ab.i("MicroMsg.OnlineVideoView", "%d notePauseVideo playVideoDuration %d ", new Object[] { Integer.valueOf(hashCode()), Integer.valueOf(this.rJx) });
    this.rJw = 0L;
    AppMethodBeat.o(38434);
  }
  
  private void cub()
  {
    AppMethodBeat.i(145470);
    this.rJy = bo.aoy();
    ab.d("MicroMsg.OnlineVideoView", "%d noteResumeVideo noteResumeVideo %d ", new Object[] { Integer.valueOf(hashCode()), Long.valueOf(this.rJy) });
    AppMethodBeat.o(145470);
  }
  
  private void cuc()
  {
    AppMethodBeat.i(145471);
    if (this.rJy > 0L)
    {
      this.rJz = 0;
      this.rJz = ((int)(this.rJz + (bo.aoy() - this.rJy) / 1000L));
    }
    ab.i("MicroMsg.OnlineVideoView", "%d notePauseVideoByResume playVideoDuration %d ", new Object[] { Integer.valueOf(hashCode()), Integer.valueOf(this.rJz) });
    this.rJy = 0L;
    AppMethodBeat.o(145471);
  }
  
  private void hideLoading()
  {
    AppMethodBeat.i(38422);
    this.kuE.post(new OnlineVideoView.14(this));
    AppMethodBeat.o(38422);
  }
  
  private void showLoading()
  {
    AppMethodBeat.i(38421);
    this.kuE.post(new OnlineVideoView.13(this));
    AppMethodBeat.o(38421);
  }
  
  public final void Es()
  {
    AppMethodBeat.i(38427);
    ab.i("MicroMsg.OnlineVideoView", "%d on completion", new Object[] { Integer.valueOf(hashCode()) });
    if (this.rJg == null)
    {
      if ((com.tencent.mm.compatible.util.d.iU(18)) || (!this.mEw))
      {
        zi(0);
        AppMethodBeat.o(38427);
        return;
      }
      if (this.kvG != null)
      {
        String str = this.kvG.getVideoPath();
        this.kvG.stop();
        bw(str, this.rJj);
      }
    }
    AppMethodBeat.o(38427);
  }
  
  public final void a(bcs parambcs, String paramString, int paramInt)
  {
    AppMethodBeat.i(38410);
    this.ctV = paramString;
    this.fDT = paramInt;
    paramString = az.dxG();
    paramString.oLs = this.fDT;
    this.rbm = paramString;
    if (this.cIc != parambcs)
    {
      this.cIc = parambcs;
      boolean bool = ag.cpc().b(this.cIc, this.mAM, 2130838011, this.mContext.hashCode(), this.rbm);
      ab.i("MicroMsg.OnlineVideoView", "%d fresh thumb image %b", new Object[] { Integer.valueOf(hashCode()), Boolean.valueOf(bool) });
    }
    this.ndT = false;
    ab.i("MicroMsg.OnlineVideoView", "%d set video data[%s, %d] isPreview %b self %s", new Object[] { Integer.valueOf(hashCode()), this.ctV, Integer.valueOf(this.fDT), Boolean.valueOf(this.ndT), this });
    AppMethodBeat.o(38410);
  }
  
  public final void aj(Activity paramActivity)
  {
    this.rJr = paramActivity;
    this.rJs = true;
  }
  
  public final void alq()
  {
    AppMethodBeat.i(38431);
    ab.i("MicroMsg.OnlineVideoView", "%d pauseByDataBlock", new Object[] { Integer.valueOf(hashCode()) });
    cua();
    showLoading();
    crn();
    AppMethodBeat.o(38431);
  }
  
  public final void bw(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(38429);
    ab.i("MicroMsg.OnlineVideoView", "%d prepare video isOnlinePlay %b filePath %s", new Object[] { Integer.valueOf(hashCode()), Boolean.valueOf(paramBoolean), paramString });
    if (bo.isNullOrNil(paramString))
    {
      ab.w("MicroMsg.OnlineVideoView", "%d prepare video but filepath is null.", new Object[] { Integer.valueOf(hashCode()) });
      AppMethodBeat.o(38429);
      return;
    }
    this.rJj = paramBoolean;
    if (this.kvG != null)
    {
      if (this.rJm == -3) {
        break label216;
      }
      if ((this.kvG instanceof VideoPlayerTextureView))
      {
        ((VideoPlayerTextureView)this.kvG).setNeedResetExtractor(byv());
        ((VideoPlayerTextureView)this.kvG).setIsOnlineVideoType(paramBoolean);
      }
      this.kvG.setOneTimeVideoTextureUpdateCallback(this.rIZ);
      this.kvG.setVideoPath(paramString);
      a(true, 0.0F);
    }
    for (;;)
    {
      com.tencent.mm.kernel.g.RM();
      if (((Integer)com.tencent.mm.kernel.g.RL().Ru().get(ac.a.yDR, Integer.valueOf(0))).intValue() == 1)
      {
        this.mEu.setText(com.tencent.mm.plugin.sight.base.d.TX(paramString));
        this.mEu.setVisibility(0);
      }
      AppMethodBeat.o(38429);
      return;
      label216:
      ab.i("MicroMsg.OnlineVideoView", "%d prepare video reset source", new Object[] { Integer.valueOf(hashCode()) });
      if ((this.kvG instanceof VideoPlayerTextureView)) {
        ((VideoPlayerTextureView)this.kvG).dpG();
      }
      zi(this.rJl);
    }
  }
  
  public final void crn()
  {
    AppMethodBeat.i(145468);
    if (this.kvG.isPlaying())
    {
      ab.i("MicroMsg.OnlineVideoView", "%d pause play", new Object[] { Integer.valueOf(hashCode()) });
      cua();
      cuc();
      this.kvG.pause();
    }
    AppMethodBeat.o(145468);
  }
  
  public final void ctP()
  {
    this.rJp = false;
  }
  
  public final void ctQ()
  {
    AppMethodBeat.i(145465);
    if (this.idF != null) {
      this.idF.cJ(false);
    }
    AppMethodBeat.o(145465);
  }
  
  public final void ctR()
  {
    AppMethodBeat.i(38408);
    ab.d("MicroMsg.OnlineVideoView", "%d register sns ui event", new Object[] { Integer.valueOf(hashCode()) });
    com.tencent.mm.sdk.b.a.ymk.c(this.rJv);
    AppMethodBeat.o(38408);
  }
  
  public final void ctS()
  {
    AppMethodBeat.i(38409);
    ab.d("MicroMsg.OnlineVideoView", "%d unRegister sns ui event", new Object[] { Integer.valueOf(hashCode()) });
    com.tencent.mm.sdk.b.a.ymk.d(this.rJv);
    AppMethodBeat.o(38409);
  }
  
  public final String ctT()
  {
    AppMethodBeat.i(145466);
    Object localObject = new StringBuffer();
    try
    {
      if (this.cIc != null) {
        ((StringBuffer)localObject).append("media: " + this.cIc.Id);
      }
      if (this.ctV != null) {
        ((StringBuffer)localObject).append("localId: " + this.ctV);
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        ab.printErrStackTrace("MicroMsg.OnlineVideoView", localException, "", new Object[0]);
      }
    }
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(145466);
    return localObject;
  }
  
  public final void ctU()
  {
    this.rJr = null;
    this.rJs = false;
  }
  
  protected final void ctW()
  {
    AppMethodBeat.i(38424);
    this.ryl.stopTimer();
    this.kvM.stopTimer();
    AppMethodBeat.o(38424);
  }
  
  public final boolean ctX()
  {
    boolean bool = true;
    AppMethodBeat.i(38430);
    ab.i("MicroMsg.OnlineVideoView", "%d resumeByDataGain", new Object[] { Integer.valueOf(hashCode()) });
    if (!this.kvG.isPlaying())
    {
      ctZ();
      cub();
      bool = this.kvG.start();
      hideLoading();
    }
    AppMethodBeat.o(38430);
    return bool;
  }
  
  public void ctY()
  {
    AppMethodBeat.i(145469);
    if (!this.kvG.isPlaying())
    {
      cub();
      this.kvG.start();
    }
    AppMethodBeat.o(145469);
  }
  
  public final int dP(int paramInt1, int paramInt2)
  {
    return 0;
  }
  
  public final void dQ(int paramInt1, int paramInt2) {}
  
  protected final void dh(boolean paramBoolean)
  {
    AppMethodBeat.i(38423);
    if (this.rJj)
    {
      if (paramBoolean)
      {
        al.d(new OnlineVideoView.15(this));
        AppMethodBeat.o(38423);
        return;
      }
      this.ryl.ag(500L, 500L);
      AppMethodBeat.o(38423);
      return;
    }
    this.kvM.ag(500L, 500L);
    AppMethodBeat.o(38423);
  }
  
  protected Context getActivityContext()
  {
    if (this.rJr == null) {
      return this.mContext;
    }
    return this.rJr;
  }
  
  public int getCurrentPosition()
  {
    AppMethodBeat.i(145475);
    int i = this.kvG.getCurrentPosition();
    AppMethodBeat.o(145475);
    return i;
  }
  
  public int getDuration()
  {
    AppMethodBeat.i(145467);
    if (this.kvG == null)
    {
      AppMethodBeat.o(145467);
      return 0;
    }
    int i = this.kvG.getDuration();
    AppMethodBeat.o(145467);
    return i;
  }
  
  public String getFilePath()
  {
    return this.filePath;
  }
  
  public int getPlayErrorCode()
  {
    return this.mEx;
  }
  
  public int getPlayVideoDuration()
  {
    AppMethodBeat.i(38435);
    if (this.rJx < 0) {
      this.rJx = 0;
    }
    ab.i("MicroMsg.OnlineVideoView", "%d get play video duration [%d]", new Object[] { Integer.valueOf(hashCode()), Integer.valueOf(this.rJx) });
    int i = this.rJx;
    AppMethodBeat.o(38435);
    return i;
  }
  
  public int getPlayVideoDurationByResume()
  {
    AppMethodBeat.i(145472);
    if (this.rJz < 0) {
      this.rJz = 0;
    }
    ab.i("MicroMsg.OnlineVideoView", "%d get play video duration by resume [%d]", new Object[] { Integer.valueOf(hashCode()), Integer.valueOf(this.rJz) });
    int i = this.rJz;
    AppMethodBeat.o(145472);
    return i;
  }
  
  public ae.c getRptStruct()
  {
    AppMethodBeat.i(145474);
    ae.c localc = new ae.c();
    localc.scene = this.scene;
    localc.cpW = this.cpW;
    localc.rJq = this.rJq;
    localc.czw = this.czw;
    localc.filePath = this.filePath;
    AppMethodBeat.o(145474);
    return localc;
  }
  
  public int getScene()
  {
    return this.scene;
  }
  
  public String getSessionId()
  {
    return this.cpW;
  }
  
  public long getSessionTimestamp()
  {
    return this.rJq;
  }
  
  public String getSnsId()
  {
    return this.czw;
  }
  
  public int getUiStayTime()
  {
    if ((this.rJo > 0L) && (this.rJn > 0L)) {}
    for (int i = (int)(this.rJo - this.rJn);; i = 0)
    {
      if (i < 0) {
        return 0;
      }
      return i;
    }
  }
  
  public final boolean isPlaying()
  {
    AppMethodBeat.i(145473);
    boolean bool = this.kvG.isPlaying();
    AppMethodBeat.o(145473);
    return bool;
  }
  
  public final void mG()
  {
    AppMethodBeat.i(38426);
    ab.i("MicroMsg.OnlineVideoView", "%d onPrepared playErrorCode[%d] onErrorPlayTimeSec[%d]", new Object[] { Integer.valueOf(hashCode()), Integer.valueOf(this.mEx), Integer.valueOf(this.rJl) });
    this.mEx = 0;
    if (this.rJl > 0)
    {
      zi(this.rJl);
      this.rJl = 0;
      AppMethodBeat.o(38426);
      return;
    }
    this.rJm = 0;
    hideLoading();
    ctZ();
    cub();
    this.kvG.start();
    this.duration = (this.kvG.getDuration() / 1000);
    ab.i("MicroMsg.OnlineVideoView", "%d start play duration %d sns local id %s ", new Object[] { Integer.valueOf(hashCode()), Integer.valueOf(this.duration), this.ctV });
    dh(false);
    AppMethodBeat.o(38426);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(38414);
    ab.d("MicroMsg.OnlineVideoView", "%d on destroy %s", new Object[] { Integer.valueOf(hashCode()), bo.dtY() });
    this.rJo = bo.aoy();
    aoR();
    AppMethodBeat.o(38414);
  }
  
  public final void onError(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(38425);
    ab.e("MicroMsg.OnlineVideoView", "%d on play video error what %d extra %d. isOnlinePlay %b isMMVideoPlayer[%b]", new Object[] { Integer.valueOf(hashCode()), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Boolean.valueOf(this.rJj), Boolean.valueOf(this.mEw) });
    Object localObject;
    if (this.rJj)
    {
      h.qsU.idkeyStat(354L, 230L, 1L, false);
      this.mEx = paramInt2;
      cua();
      localObject = this.kvG.getVideoPath();
      this.rJl = (this.kvG.getCurrentPosition() / 1000);
      if (!this.rJj) {
        break label386;
      }
      if (paramInt1 != -2) {
        break label339;
      }
      this.kvG.stop();
    }
    for (;;)
    {
      try
      {
        showLoading();
        if (this.rJi != null)
        {
          localObject = this.rJi;
          String str = ((ae)localObject).fVf + 0 + "_-1";
          if (!((ae)localObject).rJI.containsKey(str))
          {
            ab.i("MicroMsg.OnlineVideoViewHelper", "request all data. [%s]", new Object[] { ((ae)localObject).fVf });
            com.tencent.mm.modelvideo.o.alF();
            com.tencent.mm.al.e.r(((ae)localObject).fVf, 0, -1);
            ((ae)localObject).rJI.put(str, Integer.valueOf(0));
            h.qsU.idkeyStat(354L, 207L, 1L, false);
            h.qsU.e(13836, new Object[] { Integer.valueOf(403), Long.valueOf(bo.aox()), "" });
          }
          ((ae)localObject).fVj = 5;
          ((ae)localObject).fVo = true;
          ((ae)localObject).fVr = false;
        }
        cua();
        AppMethodBeat.o(38425);
        return;
      }
      catch (Exception localException)
      {
        label339:
        AppMethodBeat.o(38425);
        return;
      }
      h.qsU.idkeyStat(354L, 231L, 1L, false);
      break;
      if (paramInt1 == -3)
      {
        this.rJm = paramInt1;
        this.kvG.pause();
      }
      else
      {
        ctW();
        this.kvG.stop();
      }
    }
    label386:
    this.kvG.stop();
    this.mEv = true;
    a(false, 0.0F);
    ab.w("MicroMsg.OnlineVideoView", "error %s, %s", new Object[] { Boolean.valueOf(this.rJs), localException });
    if ((!bo.isNullOrNil(localException)) && (this.rJs))
    {
      ab.w("MicroMsg.OnlineVideoView", "%d start third player to play", new Object[] { Integer.valueOf(hashCode()) });
      this.kuE.post(new OnlineVideoView.8(this, localException));
    }
    AppMethodBeat.o(38425);
  }
  
  public final void onPause()
  {
    AppMethodBeat.i(38413);
    ab.d("MicroMsg.OnlineVideoView", "%d on pause %s ", new Object[] { Integer.valueOf(hashCode()), bo.dtY() });
    ctW();
    if (this.kvG != null) {
      this.kvG.stop();
    }
    AppMethodBeat.o(38413);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(38412);
    ab.d("MicroMsg.OnlineVideoView", "%d on resume %s", new Object[] { Integer.valueOf(hashCode()), bo.dtY() });
    this.rJn = bo.aoy();
    if (this.rJi == null)
    {
      ab.i("MicroMsg.OnlineVideoView", "%d logic init, create new helper and add listener.", new Object[] { Integer.valueOf(hashCode()) });
      this.rJi = new ae(this);
      com.tencent.mm.sdk.b.a.ymk.c(this.riF);
      com.tencent.mm.sdk.b.a.ymk.c(this.rJu);
      ag.cpa().a(this.rJt);
      if (this.rJp)
      {
        this.idF = new com.tencent.mm.model.d();
        this.idF.a(this);
      }
      if (com.tencent.mm.r.a.BY() != null) {
        com.tencent.mm.r.a.BY().Ic();
      }
    }
    if (!this.mEv) {
      byu();
    }
    this.rIW = true;
    AppMethodBeat.o(38412);
  }
  
  public void setFilePath(String paramString)
  {
    this.filePath = paramString;
  }
  
  public void setMute(boolean paramBoolean)
  {
    AppMethodBeat.i(38411);
    this.efg = paramBoolean;
    this.kvG.setMute(this.efg);
    AppMethodBeat.o(38411);
  }
  
  public void setScene(int paramInt)
  {
    this.scene = paramInt;
  }
  
  public void setSessionId(String paramString)
  {
    this.cpW = paramString;
  }
  
  public void setSessionTimestamp(long paramLong)
  {
    this.rJq = paramLong;
  }
  
  public void setSnsId(String paramString)
  {
    this.czw = paramString;
  }
  
  public void setThumbViewScaleType(ImageView.ScaleType paramScaleType)
  {
    AppMethodBeat.i(145476);
    this.mAM.setScaleType(paramScaleType);
    AppMethodBeat.o(145476);
  }
  
  public void setVideoCallback(a parama)
  {
    this.rJg = parama;
  }
  
  public void setVideoScaleType(h.d paramd)
  {
    AppMethodBeat.i(145477);
    if (this.kvG != null)
    {
      if ((this.kvG instanceof VideoPlayerTextureView))
      {
        ((VideoPlayerTextureView)this.kvG).setScaleType(paramd);
        AppMethodBeat.o(145477);
        return;
      }
      if ((this.kvG instanceof VideoTextureView)) {
        ((VideoTextureView)this.kvG).setScaleType(paramd);
      }
    }
    AppMethodBeat.o(145477);
  }
  
  public final void zi(int paramInt)
  {
    AppMethodBeat.i(38432);
    ab.i("MicroMsg.OnlineVideoView", "%d seek second %d afterSeekPlay %b", new Object[] { Integer.valueOf(hashCode()), Integer.valueOf(paramInt), Boolean.TRUE });
    this.rJm = 0;
    hideLoading();
    this.kvG.e(paramInt * 1000, true);
    dh(false);
    AppMethodBeat.o(38432);
  }
  
  public static abstract interface a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.OnlineVideoView
 * JD-Core Version:    0.7.0.1
 */