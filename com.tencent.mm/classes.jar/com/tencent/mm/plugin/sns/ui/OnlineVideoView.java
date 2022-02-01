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
import com.tencent.mm.g.a.cs;
import com.tencent.mm.g.a.cs.b;
import com.tencent.mm.g.a.ng;
import com.tencent.mm.g.a.ng.a;
import com.tencent.mm.g.a.tf;
import com.tencent.mm.g.a.ti;
import com.tencent.mm.g.a.ti.a;
import com.tencent.mm.g.a.ug;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.d.a;
import com.tencent.mm.modelvideo.o;
import com.tencent.mm.modelvideo.u;
import com.tencent.mm.plugin.sns.model.af;
import com.tencent.mm.plugin.sns.model.an;
import com.tencent.mm.plugin.sns.model.at;
import com.tencent.mm.plugin.sns.model.b.b;
import com.tencent.mm.plugin.sns.model.f;
import com.tencent.mm.pluginsdk.ui.tools.VideoPlayerTextureView;
import com.tencent.mm.pluginsdk.ui.tools.VideoTextureView;
import com.tencent.mm.pluginsdk.ui.tools.h.a;
import com.tencent.mm.protocal.protobuf.bpi;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.av;
import com.tencent.mm.sdk.platformtools.av.a;
import com.tencent.mm.sdk.platformtools.ax;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.sdk.platformtools.m;
import com.tencent.mm.storage.ab;
import com.tencent.mm.storage.ae.a;
import com.tencent.mm.storage.bc;
import com.tencent.mm.ui.widget.MMPinProgressBtn;
import com.tencent.mm.ui.widget.a.f.a;
import com.tencent.mm.ui.widget.a.f.c;
import java.util.HashMap;

public class OnlineVideoView
  extends RelativeLayout
  implements d.a, ah.a, h.a
{
  private volatile boolean csX;
  private String diQ;
  private String dpC;
  private int duration;
  private bpi dyS;
  private int dzA;
  private int dzy;
  private boolean dzz;
  private String filePath;
  private boolean fqj;
  private int hgr;
  private TextView kuO;
  private ProgressBar kuP;
  private Context mContext;
  protected com.tencent.mm.pluginsdk.ui.tools.h nAZ;
  private av nBf;
  com.tencent.mm.model.d nnt;
  ap nzT;
  private RelativeLayout qiM;
  ImageView qir;
  private TextView qmi;
  private boolean qmn;
  private boolean qmo;
  private int qmp;
  private MMPinProgressBtn qms;
  private int scene;
  private String sessionId;
  boolean tib;
  private com.tencent.mm.plugin.o.b tzW;
  private bc wBg;
  private c wKr;
  private av xdT;
  private com.tencent.mm.pluginsdk.ui.tools.h.e xpA;
  private int xpD;
  String xpE;
  private boolean xpF;
  private a xpG;
  protected ah xpH;
  private boolean xpI;
  private boolean xpJ;
  private int xpK;
  private int xpL;
  private long xpM;
  private long xpN;
  protected boolean xpO;
  private long xpP;
  public volatile boolean xpQ;
  protected Activity xpR;
  protected boolean xpS;
  private b.b xpT;
  private c xpU;
  private c xpV;
  private long xpW;
  private int xpX;
  private long xpY;
  private int xpZ;
  private boolean xpw;
  private boolean xqa;
  
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
    AppMethodBeat.i(98060);
    this.xpD = 0;
    this.tib = false;
    this.qmn = false;
    this.fqj = false;
    this.dyS = null;
    this.xpF = false;
    this.xpH = null;
    this.xpJ = false;
    this.duration = 0;
    this.xpK = 0;
    this.xpL = 0;
    this.xpM = 0L;
    this.xpN = 0L;
    this.qmp = 0;
    this.nnt = null;
    this.xpO = true;
    this.nzT = new ap(Looper.getMainLooper());
    this.scene = 0;
    this.xpP = 0L;
    this.sessionId = "";
    this.dpC = "";
    this.filePath = "";
    this.csX = false;
    this.xpQ = false;
    this.xpS = false;
    this.xdT = new av(new av.a()
    {
      public final boolean onTimerExpired()
      {
        AppMethodBeat.i(98059);
        if ((OnlineVideoView.this.xpH == null) || (OnlineVideoView.this.nAZ == null))
        {
          AppMethodBeat.o(98059);
          return false;
        }
        if (((View)OnlineVideoView.this.nAZ).getAlpha() < 1.0F)
        {
          ad.i("MicroMsg.OnlineVideoView", "onlineVideoTimer switchVideoModel");
          OnlineVideoView.n(OnlineVideoView.this);
        }
        if (OnlineVideoView.this.nAZ.isPlaying()) {
          OnlineVideoView.o(OnlineVideoView.this);
        }
        try
        {
          boolean bool = bt.isNullOrNil(OnlineVideoView.this.xpH.hxP);
          if (!bool) {}
          for (int i = 1; i == 0; i = 0)
          {
            AppMethodBeat.o(98059);
            return false;
          }
          i = OnlineVideoView.this.nAZ.getCurrentPosition() / 1000;
          bool = OnlineVideoView.this.xpH.oR(i);
          AppMethodBeat.o(98059);
          return bool;
        }
        catch (Exception localException)
        {
          ad.e("MicroMsg.OnlineVideoView", "online video timer check error : " + localException.toString());
          AppMethodBeat.o(98059);
        }
        return false;
      }
    }, true);
    this.nBf = new av(new av.a()
    {
      public final boolean onTimerExpired()
      {
        AppMethodBeat.i(187568);
        if (OnlineVideoView.this.nAZ == null)
        {
          AppMethodBeat.o(187568);
          return false;
        }
        if (((View)OnlineVideoView.this.nAZ).getAlpha() < 1.0F)
        {
          ad.i("MicroMsg.OnlineVideoView", "offlineVideoTimer switchVideoModel");
          OnlineVideoView.n(OnlineVideoView.this);
        }
        if (OnlineVideoView.this.nAZ.isPlaying())
        {
          OnlineVideoView.o(OnlineVideoView.this);
          OnlineVideoView.this.nAZ.getCurrentPosition();
        }
        AppMethodBeat.o(187568);
        return true;
      }
    }, true);
    this.xpT = new b.b()
    {
      public final void aob(String paramAnonymousString) {}
      
      public final void by(String paramAnonymousString, boolean paramAnonymousBoolean) {}
      
      public final void bz(final String paramAnonymousString, final boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(187570);
        OnlineVideoView.f(OnlineVideoView.this).postDelayed(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(187569);
            ad.i("MicroMsg.OnlineVideoView", "%d weixin download finish[%b], go to prepare video", new Object[] { Integer.valueOf(OnlineVideoView.this.hashCode()), Boolean.valueOf(paramAnonymousBoolean) });
            if ((OnlineVideoView.c(OnlineVideoView.this) != null) && (paramAnonymousBoolean) && (bt.kU(OnlineVideoView.c(OnlineVideoView.this).Id, paramAnonymousString)))
            {
              at.iH(OnlineVideoView.a(OnlineVideoView.this), "");
              String str = at.a(OnlineVideoView.a(OnlineVideoView.this), OnlineVideoView.c(OnlineVideoView.this));
              if (!bt.isNullOrNil(str)) {
                OnlineVideoView.this.bG(str, false);
              }
            }
            AppMethodBeat.o(187569);
          }
        }, 100L);
        AppMethodBeat.o(187570);
      }
      
      public final void dsp() {}
    };
    this.xpU = new c() {};
    this.xpV = new c() {};
    this.wKr = new c()
    {
      private boolean a(ng paramAnonymousng)
      {
        AppMethodBeat.i(187573);
        if (OnlineVideoView.this.xpH == null)
        {
          ad.w("MicroMsg.OnlineVideoView", "%d online video helper is null.", new Object[] { Integer.valueOf(OnlineVideoView.this.hashCode()) });
          AppMethodBeat.o(187573);
          return false;
        }
        try
        {
          bool = OnlineVideoView.this.xpH.aqu(paramAnonymousng.dsm.mediaId);
          if (!bool)
          {
            AppMethodBeat.o(187573);
            return false;
          }
          if (paramAnonymousng.dsm.retCode == -21112)
          {
            paramAnonymousng = OnlineVideoView.this;
            com.tencent.mm.plugin.report.service.h.vKh.idkeyStat(354L, 218L, 1L, false);
            paramAnonymousng.nzT.post(new OnlineVideoView.10(paramAnonymousng));
            AppMethodBeat.o(187573);
            return false;
          }
          if ((paramAnonymousng.dsm.retCode != 0) && (paramAnonymousng.dsm.retCode != -21006))
          {
            ad.w("MicroMsg.OnlineVideoView", "%d stream download online video error. retCode %d ", new Object[] { Integer.valueOf(OnlineVideoView.this.hashCode()), Integer.valueOf(paramAnonymousng.dsm.retCode) });
            AppMethodBeat.o(187573);
            return false;
          }
          switch (paramAnonymousng.dsm.djq)
          {
          }
        }
        catch (Exception paramAnonymousng)
        {
          for (;;)
          {
            boolean bool;
            long l2;
            long l1;
            ad.e("MicroMsg.OnlineVideoView", "online video callback error: " + paramAnonymousng.toString());
            continue;
            if (l1 > localah.fnZ) {}
            for (;;)
            {
              for (;;)
              {
                localah.fnZ = l1;
                localah.xqo = bt.eGO();
                try
                {
                  if (localah.xqk != null) {
                    break label518;
                  }
                  ad.w("MicroMsg.OnlineVideoViewHelper", "parser is null, thread is error.");
                }
                catch (Exception paramAnonymousng)
                {
                  ad.e("MicroMsg.OnlineVideoViewHelper", "deal moov ready error: " + paramAnonymousng.toString());
                }
              }
              break;
              l1 = localah.fnZ;
            }
            if (localah.xqk.E(localah.hxQ, l2))
            {
              localah.hxV = localah.xqk.hXw;
              ad.i("MicroMsg.OnlineVideoViewHelper", "mp4 parse moov success. duration %d cdnMediaId %s isFastStart %b", new Object[] { Integer.valueOf(localah.hxV), localah.hxP, Boolean.valueOf(bool) });
              if (!bool) {
                aq.f(new ah.1(localah));
              }
              if (localah.hxW == -1) {}
              for (localah.hxT = 1;; localah.hxT = 2)
              {
                com.tencent.mm.plugin.report.service.h.vKh.idkeyStat(354L, 204L, 1L, false);
                break;
              }
            }
            ad.w("MicroMsg.OnlineVideoViewHelper", "mp4 parse moov error. cdnMediaId %s", new Object[] { localah.hxP });
            o.aCJ();
            com.tencent.mm.ao.e.q(localah.hxP, 0, -1);
            com.tencent.mm.plugin.report.service.h.vKh.idkeyStat(354L, 205L, 1L, false);
            com.tencent.mm.plugin.report.service.h.vKh.f(13836, new Object[] { Integer.valueOf(402), Long.valueOf(bt.aGK()), "" });
            continue;
            ah localah = OnlineVideoView.this.xpH;
            Object localObject = paramAnonymousng.dsm.mediaId;
            int i = paramAnonymousng.dsm.offset;
            int j = paramAnonymousng.dsm.length;
            localah.hyc = false;
            if ((i < 0) || (j < 0)) {
              ad.w("MicroMsg.OnlineVideoViewHelper", "deal data available error offset[%d], length[%d]", new Object[] { Integer.valueOf(i), Integer.valueOf(j) });
            }
            while (!localah.aqu((String)localObject))
            {
              if (paramAnonymousng.dsm.length <= 0) {
                break;
              }
              OnlineVideoView.this.ez(true);
              break;
            }
            localObject = localah.hxP + i + "_" + j;
            localObject = (Integer)localah.xqj.get(localObject);
            if ((localObject != null) && (((Integer)localObject).intValue() > 0)) {
              localah.hxZ = ((Integer)localObject).intValue();
            }
            for (;;)
            {
              ad.i("MicroMsg.OnlineVideoViewHelper", "deal data available. offset[%d] length[%d] cachePlayTime[%d]", new Object[] { Integer.valueOf(i), Integer.valueOf(j), Integer.valueOf(localah.hxZ) });
              break;
              try
              {
                localah.hxZ = localah.xqk.dw(i, j);
              }
              catch (Exception localException)
              {
                ad.e("MicroMsg.OnlineVideoViewHelper", "deal data available file pos to video time error: " + localException.toString());
              }
            }
            OnlineVideoView.this.ez(true);
            continue;
            ad.i("MicroMsg.OnlineVideoView", "%d download finish. cdnMediaId %s sendReqCode %d favFromScene %d", new Object[] { Integer.valueOf(OnlineVideoView.this.hashCode()), paramAnonymousng.dsm.mediaId, Integer.valueOf(OnlineVideoView.s(OnlineVideoView.this)), Integer.valueOf(OnlineVideoView.t(OnlineVideoView.this)) });
            paramAnonymousng = OnlineVideoView.this.xpH;
            ad.i("MicroMsg.OnlineVideoViewHelper", "deal stream finish. playStatus %d cdnMediaId %s", new Object[] { Integer.valueOf(paramAnonymousng.hxT), paramAnonymousng.hxP });
            paramAnonymousng.hyc = false;
            paramAnonymousng.hxS = 3;
            com.tencent.mm.plugin.report.service.h.vKh.idkeyStat(354L, 206L, 1L, false);
            if (paramAnonymousng.hxT == 0)
            {
              ad.w("MicroMsg.OnlineVideoViewHelper", "it had not moov callback and download finish start to play video.");
              paramAnonymousng.dzQ();
            }
            for (;;)
            {
              if (OnlineVideoView.s(OnlineVideoView.this) <= 0) {
                break label1225;
              }
              OnlineVideoView.o(OnlineVideoView.this);
              OnlineVideoView.b(OnlineVideoView.this, OnlineVideoView.s(OnlineVideoView.this));
              break;
              if (paramAnonymousng.hxT == 5)
              {
                ad.w("MicroMsg.OnlineVideoViewHelper", "it had play error, it request all video data finish, start to play." + paramAnonymousng.hxP);
                paramAnonymousng.dzQ();
              }
            }
            if (OnlineVideoView.t(OnlineVideoView.this) > 0)
            {
              OnlineVideoView.o(OnlineVideoView.this);
              OnlineVideoView.b(OnlineVideoView.this, OnlineVideoView.t(OnlineVideoView.this), OnlineVideoView.u(OnlineVideoView.this));
            }
            else if (OnlineVideoView.v(OnlineVideoView.this))
            {
              OnlineVideoView.o(OnlineVideoView.this);
              OnlineVideoView.w(OnlineVideoView.this);
            }
            else
            {
              OnlineVideoView.this.ez(true);
              continue;
              if (OnlineVideoView.l(OnlineVideoView.this) == 1)
              {
                localah = OnlineVideoView.this.xpH;
                String str = paramAnonymousng.dsm.mediaId;
                i = paramAnonymousng.dsm.offset;
                j = paramAnonymousng.dsm.length;
                if (localah.aqu(str))
                {
                  localah.progress = i;
                  localah.hlk = j;
                  localah.xqm = (localah.progress * 100 / localah.hlk);
                  ad.i("MicroMsg.OnlineVideoViewHelper", "deal video[%s] progress callback[%d, %d]. downloadedPercent[%d]", new Object[] { localah.hxP, Integer.valueOf(localah.progress), Integer.valueOf(localah.hlk), Integer.valueOf(localah.xqm) });
                }
                if (localah.xqm >= 100) {
                  localah.hxS = 3;
                }
              }
              else if (OnlineVideoView.l(OnlineVideoView.this) == 2)
              {
                OnlineVideoView.a(OnlineVideoView.this, paramAnonymousng.dsm.offset, paramAnonymousng.dsm.length);
                continue;
                paramAnonymousng = OnlineVideoView.this.xpH;
                ad.i("MicroMsg.OnlineVideoViewHelper", "deal had dup video. cdnMediaId %s", new Object[] { paramAnonymousng.hxP });
                paramAnonymousng.dzQ();
              }
            }
          }
        }
        ad.w("MicroMsg.OnlineVideoView", "%d unknown event opcode %d", new Object[] { Integer.valueOf(OnlineVideoView.this.hashCode()), Integer.valueOf(paramAnonymousng.dsm.djq) });
        for (;;)
        {
          AppMethodBeat.o(187573);
          return false;
          localah = OnlineVideoView.this.xpH;
          l2 = paramAnonymousng.dsm.offset;
          l1 = paramAnonymousng.dsm.dsn;
          bool = paramAnonymousng.dsm.dso;
          ad.i("MicroMsg.OnlineVideoViewHelper", "deal moov ready moovPos %d, timeDuration %d, cdnMediaId %s startDownload[%d %d]", new Object[] { Long.valueOf(l2), Integer.valueOf(localah.hxV), localah.hxP, Long.valueOf(l1), Long.valueOf(localah.fnZ) });
          if (localah.hxV == 0) {
            break;
          }
          ad.w("MicroMsg.OnlineVideoViewHelper", "moov had callback, do nothing.");
          OnlineVideoView.r(OnlineVideoView.this);
        }
      }
    };
    this.xpA = new com.tencent.mm.pluginsdk.ui.tools.h.e()
    {
      public final void beo()
      {
        AppMethodBeat.i(187575);
        ad.i("MicroMsg.OnlineVideoView", "%d on texture update.", new Object[] { Integer.valueOf(OnlineVideoView.this.hashCode()) });
        try
        {
          OnlineVideoView.n(OnlineVideoView.this);
          AppMethodBeat.o(187575);
          return;
        }
        catch (Exception localException)
        {
          ad.e("MicroMsg.OnlineVideoView", "texture view update. error " + localException.toString());
          AppMethodBeat.o(187575);
        }
      }
    };
    this.tzW = new com.tencent.mm.plugin.o.b()
    {
      public final long cPk()
      {
        AppMethodBeat.i(187576);
        ad.i("MicroMsg.OnlineVideoView", "%d sns video get online cache", new Object[] { Integer.valueOf(OnlineVideoView.this.hashCode()) });
        g.afC();
        g.afB().afk().set(ae.a.FnJ, Boolean.TRUE);
        try
        {
          if ((OnlineVideoView.x(OnlineVideoView.this)) && (OnlineVideoView.this.xpH != null))
          {
            int i = OnlineVideoView.this.xpH.hxZ;
            long l = i;
            AppMethodBeat.o(187576);
            return l;
          }
        }
        catch (Exception localException)
        {
          AppMethodBeat.o(187576);
        }
        return 0L;
      }
    };
    this.xqa = true;
    this.mContext = paramContext;
    ad.i("MicroMsg.OnlineVideoView", "%d ui init view.", new Object[] { Integer.valueOf(hashCode()) });
    LayoutInflater.from(paramContext).inflate(2131495624, this);
    this.qir = ((ImageView)findViewById(2131306398));
    this.qiM = ((RelativeLayout)findViewById(2131306392));
    this.kuO = ((TextView)findViewById(2131306332));
    this.kuO.setVisibility(8);
    this.qms = ((MMPinProgressBtn)findViewById(2131306379));
    this.kuP = ((ProgressBar)findViewById(2131306352));
    this.qmi = ((TextView)findViewById(2131306403));
    com.tencent.mm.modelcontrol.d.awT();
    if (com.tencent.mm.modelcontrol.d.axf())
    {
      this.qmo = true;
      this.nAZ = new VideoPlayerTextureView(paramContext);
      ((VideoPlayerTextureView)this.nAZ).setIOnlineCache(this.tzW);
      ((VideoPlayerTextureView)this.nAZ).setOpenWithNoneSurface(true);
      com.tencent.mm.plugin.report.service.h.vKh.idkeyStat(354L, 148L, 1L, false);
    }
    for (;;)
    {
      this.nAZ.setVideoCallback(this);
      paramContext = new RelativeLayout.LayoutParams(-1, -2);
      paramContext.addRule(13);
      this.qiM.addView((View)this.nAZ, paramContext);
      ad.i("MicroMsg.OnlineVideoView", "%d switch sync video model isVideoPlay %b %f", new Object[] { Integer.valueOf(hashCode()), Boolean.FALSE, Float.valueOf(0.0F) });
      paramContext = (View)this.nAZ;
      this.qiM.setVisibility(8);
      paramContext.setVisibility(8);
      if (this.xqa) {
        this.qir.setVisibility(0);
      }
      AppMethodBeat.o(98060);
      return;
      this.qmo = false;
      this.nAZ = new VideoTextureView(paramContext);
      com.tencent.mm.plugin.report.service.h.vKh.idkeyStat(354L, 149L, 1L, false);
    }
  }
  
  private void N(boolean paramBoolean, int paramInt)
  {
    boolean bool = true;
    AppMethodBeat.i(98076);
    if (this.dyS == null)
    {
      ad.w("MicroMsg.OnlineVideoView", "%d start download video but media is null.", new Object[] { Integer.valueOf(hashCode()) });
      AppMethodBeat.o(98076);
      return;
    }
    if (this.xpH == null)
    {
      ad.w("MicroMsg.OnlineVideoView", "%d start download video but helper is null.", new Object[] { Integer.valueOf(hashCode()) });
      AppMethodBeat.o(98076);
      return;
    }
    if (this.dyS.Dzl == 2)
    {
      ad.w("MicroMsg.OnlineVideoView", "%d it start download video, url type is weixin", new Object[] { Integer.valueOf(hashCode()) });
      this.xpD = 3;
      af.dtp().a(this.dyS, 4, null, this.wBg);
      AppMethodBeat.o(98076);
      return;
    }
    int i;
    if (!paramBoolean)
    {
      com.tencent.mm.modelcontrol.d.awT();
      if (com.tencent.mm.modelcontrol.d.axe())
      {
        ad.i("MicroMsg.OnlineVideoView", "%d it start online download video", new Object[] { Integer.valueOf(hashCode()) });
        this.xpD = 1;
        i = paramInt;
        if (paramInt == 0) {
          i = 30;
        }
        paramBoolean = bool;
        if (this.xpH == null) {
          break label276;
        }
        this.xpH.a(this.dyS, this.hgr, this.diQ, paramBoolean, i);
        AppMethodBeat.o(98076);
        return;
      }
    }
    ad.i("MicroMsg.OnlineVideoView", "%d it start offline download video", new Object[] { Integer.valueOf(hashCode()) });
    this.xpD = 2;
    if (paramInt != 0) {}
    for (;;)
    {
      paramBoolean = false;
      i = paramInt;
      break;
      paramInt = 31;
    }
    label276:
    ad.w("MicroMsg.OnlineVideoView", "onlineVideoHelper is null!!!");
    AppMethodBeat.o(98076);
  }
  
  /* Error */
  private void NX()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: ldc_w 461
    //   5: invokestatic 155	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   8: aload_0
    //   9: getfield 214	com/tencent/mm/plugin/sns/ui/OnlineVideoView:csX	Z
    //   12: ifne +12 -> 24
    //   15: ldc_w 461
    //   18: invokestatic 397	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   21: aload_0
    //   22: monitorexit
    //   23: return
    //   24: aload_0
    //   25: iconst_0
    //   26: putfield 214	com/tencent/mm/plugin/sns/ui/OnlineVideoView:csX	Z
    //   29: ldc 255
    //   31: ldc_w 463
    //   34: iconst_1
    //   35: anewarray 259	java/lang/Object
    //   38: dup
    //   39: iconst_0
    //   40: aload_0
    //   41: invokevirtual 263	java/lang/Object:hashCode	()I
    //   44: invokestatic 269	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   47: aastore
    //   48: invokestatic 274	com/tencent/mm/sdk/platformtools/ad:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   51: aload_0
    //   52: invokespecial 466	com/tencent/mm/plugin/sns/ui/OnlineVideoView:dzH	()V
    //   55: aload_0
    //   56: invokespecial 469	com/tencent/mm/plugin/sns/ui/OnlineVideoView:dzJ	()V
    //   59: aload_0
    //   60: getfield 336	com/tencent/mm/plugin/sns/ui/OnlineVideoView:nAZ	Lcom/tencent/mm/pluginsdk/ui/tools/h;
    //   63: invokeinterface 472 1 0
    //   68: getstatic 478	com/tencent/mm/sdk/b/a:ESL	Lcom/tencent/mm/sdk/b/a;
    //   71: aload_0
    //   72: getfield 243	com/tencent/mm/plugin/sns/ui/OnlineVideoView:wKr	Lcom/tencent/mm/sdk/b/c;
    //   75: invokevirtual 482	com/tencent/mm/sdk/b/a:d	(Lcom/tencent/mm/sdk/b/c;)Z
    //   78: pop
    //   79: getstatic 478	com/tencent/mm/sdk/b/a:ESL	Lcom/tencent/mm/sdk/b/a;
    //   82: aload_0
    //   83: getfield 237	com/tencent/mm/plugin/sns/ui/OnlineVideoView:xpU	Lcom/tencent/mm/sdk/b/c;
    //   86: invokevirtual 482	com/tencent/mm/sdk/b/a:d	(Lcom/tencent/mm/sdk/b/c;)Z
    //   89: pop
    //   90: invokestatic 431	com/tencent/mm/plugin/sns/model/af:dtp	()Lcom/tencent/mm/plugin/sns/model/b;
    //   93: aload_0
    //   94: getfield 234	com/tencent/mm/plugin/sns/ui/OnlineVideoView:xpT	Lcom/tencent/mm/plugin/sns/model/b$b;
    //   97: invokevirtual 486	com/tencent/mm/plugin/sns/model/b:b	(Lcom/tencent/mm/plugin/sns/model/b$b;)V
    //   100: aload_0
    //   101: invokevirtual 489	com/tencent/mm/plugin/sns/ui/OnlineVideoView:dzu	()V
    //   104: aload_0
    //   105: getfield 200	com/tencent/mm/plugin/sns/ui/OnlineVideoView:nzT	Lcom/tencent/mm/sdk/platformtools/ap;
    //   108: aconst_null
    //   109: invokevirtual 493	com/tencent/mm/sdk/platformtools/ap:removeCallbacksAndMessages	(Ljava/lang/Object;)V
    //   112: aload_0
    //   113: getfield 169	com/tencent/mm/plugin/sns/ui/OnlineVideoView:xpH	Lcom/tencent/mm/plugin/sns/ui/ah;
    //   116: ifnull +18 -> 134
    //   119: aload_0
    //   120: getfield 169	com/tencent/mm/plugin/sns/ui/OnlineVideoView:xpH	Lcom/tencent/mm/plugin/sns/ui/ah;
    //   123: invokevirtual 496	com/tencent/mm/plugin/sns/ui/ah:dzO	()Z
    //   126: pop
    //   127: aload_0
    //   128: getfield 169	com/tencent/mm/plugin/sns/ui/OnlineVideoView:xpH	Lcom/tencent/mm/plugin/sns/ui/ah;
    //   131: invokevirtual 499	com/tencent/mm/plugin/sns/ui/ah:clear	()V
    //   134: invokestatic 505	com/tencent/mm/r/a:Lv	()Lcom/tencent/mm/model/ah;
    //   137: ifnull +11 -> 148
    //   140: invokestatic 505	com/tencent/mm/r/a:Lv	()Lcom/tencent/mm/model/ah;
    //   143: invokeinterface 510 1 0
    //   148: aload_0
    //   149: getfield 185	com/tencent/mm/plugin/sns/ui/OnlineVideoView:nnt	Lcom/tencent/mm/model/d;
    //   152: ifnull +12 -> 164
    //   155: aload_0
    //   156: getfield 185	com/tencent/mm/plugin/sns/ui/OnlineVideoView:nnt	Lcom/tencent/mm/model/d;
    //   159: iconst_0
    //   160: invokevirtual 516	com/tencent/mm/model/d:ea	(Z)Z
    //   163: pop
    //   164: aload_0
    //   165: aconst_null
    //   166: putfield 185	com/tencent/mm/plugin/sns/ui/OnlineVideoView:nnt	Lcom/tencent/mm/model/d;
    //   169: aload_0
    //   170: aconst_null
    //   171: putfield 165	com/tencent/mm/plugin/sns/ui/OnlineVideoView:dyS	Lcom/tencent/mm/protocal/protobuf/bpi;
    //   174: aload_0
    //   175: aconst_null
    //   176: putfield 447	com/tencent/mm/plugin/sns/ui/OnlineVideoView:diQ	Ljava/lang/String;
    //   179: aload_0
    //   180: aconst_null
    //   181: putfield 169	com/tencent/mm/plugin/sns/ui/OnlineVideoView:xpH	Lcom/tencent/mm/plugin/sns/ui/ah;
    //   184: aload_0
    //   185: iconst_0
    //   186: putfield 177	com/tencent/mm/plugin/sns/ui/OnlineVideoView:xpL	I
    //   189: ldc_w 461
    //   192: invokestatic 397	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   195: goto -174 -> 21
    //   198: astore_1
    //   199: aload_0
    //   200: monitorexit
    //   201: aload_1
    //   202: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	203	0	this	OnlineVideoView
    //   198	4	1	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	21	198	finally
    //   24	134	198	finally
    //   134	148	198	finally
    //   148	164	198	finally
    //   164	195	198	finally
  }
  
  private void Nm(int paramInt)
  {
    AppMethodBeat.i(98071);
    String str = an.iF(af.getAccSnsPath(), this.dyS.Id) + com.tencent.mm.plugin.sns.data.q.d(this.dyS);
    Intent localIntent = new Intent();
    localIntent.putExtra("Select_Conv_Type", 3);
    localIntent.putExtra("select_is_ret", true);
    localIntent.putExtra("mutil_select_is_ret", true);
    localIntent.putExtra("image_path", str);
    localIntent.putExtra("Retr_Msg_Type", 11);
    ad.i("MicroMsg.OnlineVideoView", "send video path %s reqCode %d", new Object[] { str, Integer.valueOf(paramInt) });
    com.tencent.mm.bs.d.c(getActivityContext(), ".ui.transmit.SelectConversationUI", localIntent, paramInt);
    this.dzA = 0;
    AppMethodBeat.o(98071);
  }
  
  private void av(final int paramInt, final boolean paramBoolean)
  {
    AppMethodBeat.i(98072);
    this.nzT.post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(98040);
        Object localObject1 = af.dtu().apK(OnlineVideoView.a(OnlineVideoView.this));
        if (localObject1 == null)
        {
          AppMethodBeat.o(98040);
          return;
        }
        ad.i("MicroMsg.OnlineVideoView", "fav download video[%s] farFromScene %d isFromMain %b", new Object[] { OnlineVideoView.a(OnlineVideoView.this), Integer.valueOf(paramInt), Boolean.valueOf(paramBoolean) });
        Object localObject2 = new cs();
        ((cs)localObject2).deQ.deW = paramInt;
        ((cs)localObject2).deQ.activity = ((Activity)OnlineVideoView.this.getActivityContext());
        com.tencent.mm.plugin.sns.l.a.a((cs)localObject2, (com.tencent.mm.plugin.sns.storage.p)localObject1);
        com.tencent.mm.sdk.b.a.ESL.l((com.tencent.mm.sdk.b.b)localObject2);
        if (((cs)localObject2).deR.ret == 0) {
          OnlineVideoView.dzK();
        }
        for (;;)
        {
          if (paramBoolean)
          {
            localObject2 = new tf();
            ((tf)localObject2).dyH.dgg = ((com.tencent.mm.plugin.sns.storage.p)localObject1).dxX();
            ((tf)localObject2).dyH.dpC = com.tencent.mm.plugin.sns.data.q.l((com.tencent.mm.plugin.sns.storage.p)localObject1);
            com.tencent.mm.sdk.b.a.ESL.l((com.tencent.mm.sdk.b.b)localObject2);
          }
          OnlineVideoView.b(OnlineVideoView.this);
          if (OnlineVideoView.this.nAZ == null) {
            break label318;
          }
          if (!bt.isNullOrNil(OnlineVideoView.this.nAZ.getVideoPath())) {
            break;
          }
          ad.i("MicroMsg.OnlineVideoView", "%d had not set video path to play", new Object[] { Integer.valueOf(OnlineVideoView.this.hashCode()) });
          localObject1 = at.a(OnlineVideoView.a(OnlineVideoView.this), OnlineVideoView.c(OnlineVideoView.this));
          if (!bt.isNullOrNil((String)localObject1)) {
            OnlineVideoView.this.bG((String)localObject1, false);
          }
          AppMethodBeat.o(98040);
          return;
          OnlineVideoView.dzL();
        }
        if (!OnlineVideoView.this.nAZ.isPlaying())
        {
          OnlineVideoView.this.nAZ.start();
          AppMethodBeat.o(98040);
          return;
        }
        label318:
        AppMethodBeat.o(98040);
      }
    });
    AppMethodBeat.o(98072);
  }
  
  private void b(final boolean paramBoolean, final float paramFloat)
  {
    AppMethodBeat.i(98074);
    this.nzT.post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(98054);
        ad.i("MicroMsg.OnlineVideoView", "%d switch video model isVideoPlay %b %f", new Object[] { Integer.valueOf(OnlineVideoView.this.hashCode()), Boolean.valueOf(paramBoolean), Float.valueOf(paramFloat) });
        View localView = (View)OnlineVideoView.this.nAZ;
        if (paramBoolean)
        {
          OnlineVideoView.g(OnlineVideoView.this).setAlpha(paramFloat);
          OnlineVideoView.g(OnlineVideoView.this).setVisibility(0);
          localView.setAlpha(paramFloat);
          localView.setVisibility(0);
          if (paramFloat >= 1.0D)
          {
            OnlineVideoView.h(OnlineVideoView.this).setVisibility(8);
            AppMethodBeat.o(98054);
          }
        }
        else
        {
          OnlineVideoView.g(OnlineVideoView.this).setVisibility(8);
          localView.setVisibility(8);
          if (OnlineVideoView.i(OnlineVideoView.this)) {
            OnlineVideoView.h(OnlineVideoView.this).setVisibility(0);
          }
        }
        AppMethodBeat.o(98054);
      }
    });
    AppMethodBeat.o(98074);
  }
  
  private void ckc()
  {
    AppMethodBeat.i(98075);
    if (!this.tib) {}
    for (String str = at.a(this.diQ, this.dyS);; str = this.xpE)
    {
      ad.i("MicroMsg.OnlineVideoView", "%d toggleVideo local id %s finish path %s isPreview %b", new Object[] { Integer.valueOf(hashCode()), this.diQ, str, Boolean.valueOf(this.tib) });
      if (bt.isNullOrNil(str)) {
        break;
      }
      ad.i("MicroMsg.OnlineVideoView", "%d sns video already download finish, play now", new Object[] { Integer.valueOf(hashCode()) });
      b(true, 0.0F);
      bG(str, false);
      AppMethodBeat.o(98075);
      return;
    }
    b(false, 0.0F);
    N(false, 0);
    showLoading();
    AppMethodBeat.o(98075);
  }
  
  private boolean ckf()
  {
    AppMethodBeat.i(98086);
    if (!this.xpI)
    {
      AppMethodBeat.o(98086);
      return false;
    }
    g.afC();
    boolean bool = g.afB().afk().getBoolean(ae.a.FnJ, false);
    AppMethodBeat.o(98086);
    return bool;
  }
  
  private void dzD()
  {
    AppMethodBeat.i(98073);
    com.tencent.mm.platformtools.p.a(getContext(), new Runnable()new Runnable
    {
      public final void run()
      {
        AppMethodBeat.i(98052);
        long l = bt.GC();
        String str1 = at.a(OnlineVideoView.a(OnlineVideoView.this), OnlineVideoView.c(OnlineVideoView.this));
        String str2 = u.Af(str1);
        if (bt.isNullOrNil(str2))
        {
          Toast.makeText(OnlineVideoView.d(OnlineVideoView.this), OnlineVideoView.d(OnlineVideoView.this).getString(2131764682), 1).show();
          OnlineVideoView.dzM();
        }
        for (;;)
        {
          OnlineVideoView.e(OnlineVideoView.this);
          ad.i("MicroMsg.OnlineVideoView", "%d save downloaded video finish %d %s", new Object[] { Integer.valueOf(hashCode()), Long.valueOf(bt.aS(l)), str1 });
          OnlineVideoView.f(OnlineVideoView.this).post(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(187578);
              if (OnlineVideoView.this.nAZ != null)
              {
                if (bt.isNullOrNil(OnlineVideoView.this.nAZ.getVideoPath()))
                {
                  ad.i("MicroMsg.OnlineVideoView", "%d had not set video path to play", new Object[] { Integer.valueOf(OnlineVideoView.this.hashCode()) });
                  String str = at.a(OnlineVideoView.a(OnlineVideoView.this), OnlineVideoView.c(OnlineVideoView.this));
                  if (!bt.isNullOrNil(str)) {
                    OnlineVideoView.this.bG(str, false);
                  }
                  AppMethodBeat.o(187578);
                  return;
                }
                if (!OnlineVideoView.this.nAZ.isPlaying())
                {
                  OnlineVideoView.this.nAZ.start();
                  AppMethodBeat.o(187578);
                  return;
                }
              }
              AppMethodBeat.o(187578);
            }
          });
          AppMethodBeat.o(98052);
          return;
          Toast.makeText(OnlineVideoView.d(OnlineVideoView.this), OnlineVideoView.d(OnlineVideoView.this).getString(2131764683, new Object[] { str2 }), 1).show();
          com.tencent.mm.sdk.f.b.k(str2, OnlineVideoView.d(OnlineVideoView.this));
          OnlineVideoView.dzN();
        }
      }
    }, new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(98053);
        Toast.makeText(OnlineVideoView.d(OnlineVideoView.this), OnlineVideoView.d(OnlineVideoView.this).getString(2131764682), 1).show();
        OnlineVideoView.dzM();
        AppMethodBeat.o(98053);
      }
    });
    AppMethodBeat.o(98073);
  }
  
  private void dzG()
  {
    AppMethodBeat.i(98092);
    this.xpW = bt.eGO();
    ad.d("MicroMsg.OnlineVideoView", "%d notePlayVideo notePlayVideo %d ", new Object[] { Integer.valueOf(hashCode()), Long.valueOf(this.xpW) });
    AppMethodBeat.o(98092);
  }
  
  private void dzH()
  {
    AppMethodBeat.i(98093);
    if (this.xpW > 0L) {
      this.xpX = ((int)(this.xpX + (bt.eGO() - this.xpW) / 1000L));
    }
    ad.i("MicroMsg.OnlineVideoView", "%d notePauseVideo playVideoDuration %d ", new Object[] { Integer.valueOf(hashCode()), Integer.valueOf(this.xpX) });
    this.xpW = 0L;
    AppMethodBeat.o(98093);
  }
  
  private void dzI()
  {
    AppMethodBeat.i(98095);
    this.xpY = bt.eGO();
    ad.d("MicroMsg.OnlineVideoView", "%d noteResumeVideo noteResumeVideo %d ", new Object[] { Integer.valueOf(hashCode()), Long.valueOf(this.xpY) });
    AppMethodBeat.o(98095);
  }
  
  private void dzJ()
  {
    AppMethodBeat.i(98096);
    if (this.xpY > 0L)
    {
      this.xpZ = 0;
      this.xpZ = ((int)(this.xpZ + (bt.eGO() - this.xpY) / 1000L));
    }
    ad.i("MicroMsg.OnlineVideoView", "%d notePauseVideoByResume playVideoDuration %d ", new Object[] { Integer.valueOf(hashCode()), Integer.valueOf(this.xpZ) });
    this.xpY = 0L;
    AppMethodBeat.o(98096);
  }
  
  private void hideLoading()
  {
    AppMethodBeat.i(98080);
    this.nzT.post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(98057);
        if ((OnlineVideoView.j(OnlineVideoView.this) != null) && (OnlineVideoView.j(OnlineVideoView.this).getVisibility() != 8))
        {
          ad.i("MicroMsg.OnlineVideoView", "%d hide loading.", new Object[] { Integer.valueOf(OnlineVideoView.this.hashCode()) });
          OnlineVideoView.j(OnlineVideoView.this).setVisibility(8);
        }
        if ((OnlineVideoView.k(OnlineVideoView.this) != null) && (OnlineVideoView.k(OnlineVideoView.this).getVisibility() != 8))
        {
          ad.i("MicroMsg.OnlineVideoView", "%d hide progress.", new Object[] { Integer.valueOf(OnlineVideoView.this.hashCode()) });
          OnlineVideoView.k(OnlineVideoView.this).setVisibility(8);
        }
        AppMethodBeat.o(98057);
      }
    });
    AppMethodBeat.o(98080);
  }
  
  private void showLoading()
  {
    AppMethodBeat.i(98079);
    this.nzT.post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(98056);
        ad.i("MicroMsg.OnlineVideoView", "%d show loading. downloadMode %d", new Object[] { Integer.valueOf(OnlineVideoView.this.hashCode()), Integer.valueOf(OnlineVideoView.l(OnlineVideoView.this)) });
        if (OnlineVideoView.l(OnlineVideoView.this) == 1)
        {
          if ((OnlineVideoView.j(OnlineVideoView.this) != null) && (OnlineVideoView.j(OnlineVideoView.this).getVisibility() != 0)) {
            OnlineVideoView.j(OnlineVideoView.this).setVisibility(0);
          }
          if ((OnlineVideoView.k(OnlineVideoView.this) != null) && (OnlineVideoView.k(OnlineVideoView.this).getVisibility() != 8)) {
            OnlineVideoView.k(OnlineVideoView.this).setVisibility(8);
          }
        }
        if (OnlineVideoView.l(OnlineVideoView.this) == 2)
        {
          if ((OnlineVideoView.k(OnlineVideoView.this) != null) && (OnlineVideoView.k(OnlineVideoView.this).getVisibility() != 0)) {
            OnlineVideoView.k(OnlineVideoView.this).setVisibility(0);
          }
          if ((OnlineVideoView.j(OnlineVideoView.this) != null) && (OnlineVideoView.j(OnlineVideoView.this).getVisibility() != 8)) {
            OnlineVideoView.j(OnlineVideoView.this).setVisibility(8);
          }
        }
        if (OnlineVideoView.l(OnlineVideoView.this) == 3)
        {
          if ((OnlineVideoView.k(OnlineVideoView.this) != null) && (OnlineVideoView.k(OnlineVideoView.this).getVisibility() != 0))
          {
            OnlineVideoView.k(OnlineVideoView.this).setVisibility(0);
            OnlineVideoView.k(OnlineVideoView.this).feJ();
          }
          if ((OnlineVideoView.j(OnlineVideoView.this) != null) && (OnlineVideoView.j(OnlineVideoView.this).getVisibility() != 8)) {
            OnlineVideoView.j(OnlineVideoView.this).setVisibility(8);
          }
        }
        AppMethodBeat.o(98056);
      }
    });
    AppMethodBeat.o(98079);
  }
  
  public final void GI(int paramInt)
  {
    AppMethodBeat.i(98091);
    ad.i("MicroMsg.OnlineVideoView", "%d seek second %d afterSeekPlay %b", new Object[] { Integer.valueOf(hashCode()), Integer.valueOf(paramInt), Boolean.TRUE });
    this.xpL = 0;
    hideLoading();
    this.nAZ.d(paramInt * 1000, true);
    ez(false);
    AppMethodBeat.o(98091);
  }
  
  public final void a(bpi parambpi, String paramString, int paramInt)
  {
    AppMethodBeat.i(98065);
    this.diQ = paramString;
    this.hgr = paramInt;
    paramString = bc.eLL();
    paramString.tGD = this.hgr;
    this.wBg = paramString;
    if (this.dyS != parambpi)
    {
      this.dyS = parambpi;
      boolean bool = af.dtr().b(this.dyS, this.qir, 2131231318, this.mContext.hashCode(), this.wBg);
      ad.i("MicroMsg.OnlineVideoView", "%d fresh thumb image %b", new Object[] { Integer.valueOf(hashCode()), Boolean.valueOf(bool) });
    }
    this.tib = false;
    ad.i("MicroMsg.OnlineVideoView", "%d set video data[%s, %d] isPreview %b self %s", new Object[] { Integer.valueOf(hashCode()), this.diQ, Integer.valueOf(this.hgr), Boolean.valueOf(this.tib), this });
    AppMethodBeat.o(98065);
  }
  
  public final void aCv()
  {
    AppMethodBeat.i(98090);
    ad.i("MicroMsg.OnlineVideoView", "%d pauseByDataBlock", new Object[] { Integer.valueOf(hashCode()) });
    dzH();
    showLoading();
    ckd();
    AppMethodBeat.o(98090);
  }
  
  public final void aD(Activity paramActivity)
  {
    this.xpR = paramActivity;
    this.xpS = true;
  }
  
  public final void abandonAudioFocus()
  {
    AppMethodBeat.i(98062);
    if (this.nnt != null) {
      this.nnt.ea(false);
    }
    AppMethodBeat.o(98062);
  }
  
  public final void aqt() {}
  
  public final void aqu() {}
  
  public final void aqv() {}
  
  public final void aqw() {}
  
  public final void bG(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(98087);
    ad.i("MicroMsg.OnlineVideoView", "%d prepare video isOnlinePlay %b filePath %s", new Object[] { Integer.valueOf(hashCode()), Boolean.valueOf(paramBoolean), paramString });
    if (bt.isNullOrNil(paramString))
    {
      ad.w("MicroMsg.OnlineVideoView", "%d prepare video but filepath is null.", new Object[] { Integer.valueOf(hashCode()) });
      AppMethodBeat.o(98087);
      return;
    }
    this.xpI = paramBoolean;
    String str;
    if (this.nAZ != null)
    {
      if (this.xpL == -3) {
        break label314;
      }
      if ((this.nAZ instanceof VideoPlayerTextureView))
      {
        ((VideoPlayerTextureView)this.nAZ).setNeedResetExtractor(ckf());
        ((VideoPlayerTextureView)this.nAZ).setIsOnlineVideoType(paramBoolean);
      }
      this.nAZ.setOneTimeVideoTextureUpdateCallback(this.xpA);
      ax localax = ax.aFC("TrackDataSource");
      if (this.dyS != null) {
        break label292;
      }
      str = "";
      localax.putString("media-url", str);
      if (this.dyS != null) {
        break label303;
      }
      str = "";
      label182:
      localax.putString("thumb-url", str);
      localax.putLong("prepare-ts", System.currentTimeMillis());
      localax.putString("prepare-path", paramString);
      localax.commit();
      this.nAZ.setVideoPath(paramString);
      b(true, 0.0F);
    }
    for (;;)
    {
      g.afC();
      if (((Integer)g.afB().afk().get(ae.a.Fmr, Integer.valueOf(0))).intValue() == 1)
      {
        this.qmi.setText(com.tencent.mm.plugin.sight.base.e.ahc(paramString));
        this.qmi.setVisibility(0);
      }
      AppMethodBeat.o(98087);
      return;
      label292:
      str = this.dyS.Url;
      break;
      label303:
      str = this.dyS.DMQ;
      break label182;
      label314:
      ad.i("MicroMsg.OnlineVideoView", "%d prepare video reset source", new Object[] { Integer.valueOf(hashCode()) });
      if ((this.nAZ instanceof VideoPlayerTextureView)) {
        ((VideoPlayerTextureView)this.nAZ).eAV();
      }
      GI(this.xpK);
    }
  }
  
  public final void ckd()
  {
    AppMethodBeat.i(98078);
    if (this.nAZ.isPlaying())
    {
      ad.i("MicroMsg.OnlineVideoView", "%d pause play", new Object[] { Integer.valueOf(hashCode()) });
      dzH();
      dzJ();
      this.nAZ.pause();
    }
    AppMethodBeat.o(98078);
  }
  
  public final void dY(int paramInt1, int paramInt2) {}
  
  public final void dzA()
  {
    AppMethodBeat.i(98064);
    ad.d("MicroMsg.OnlineVideoView", "%d unRegister sns ui event", new Object[] { Integer.valueOf(hashCode()) });
    com.tencent.mm.sdk.b.a.ESL.d(this.xpV);
    AppMethodBeat.o(98064);
  }
  
  public final String dzB()
  {
    AppMethodBeat.i(98066);
    Object localObject = new StringBuffer();
    try
    {
      if (this.dyS != null) {
        ((StringBuffer)localObject).append("media: " + this.dyS.Id);
      }
      if (this.diQ != null) {
        ((StringBuffer)localObject).append("localId: " + this.diQ);
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        ad.printErrStackTrace("MicroMsg.OnlineVideoView", localException, "", new Object[0]);
      }
    }
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(98066);
    return localObject;
  }
  
  public final void dzC()
  {
    this.xpR = null;
    this.xpS = false;
  }
  
  public final boolean dzE()
  {
    boolean bool = true;
    AppMethodBeat.i(98088);
    ad.i("MicroMsg.OnlineVideoView", "%d resumeByDataGain", new Object[] { Integer.valueOf(hashCode()) });
    if (!this.nAZ.isPlaying())
    {
      dzG();
      dzI();
      bool = this.nAZ.start();
      hideLoading();
    }
    AppMethodBeat.o(98088);
    return bool;
  }
  
  public void dzF()
  {
    AppMethodBeat.i(98089);
    if (!this.nAZ.isPlaying())
    {
      dzI();
      this.nAZ.start();
    }
    AppMethodBeat.o(98089);
  }
  
  public final void dzu()
  {
    AppMethodBeat.i(98082);
    this.xdT.stopTimer();
    this.nBf.stopTimer();
    AppMethodBeat.o(98082);
  }
  
  public final void dzy()
  {
    this.xpO = false;
  }
  
  public final void dzz()
  {
    AppMethodBeat.i(98063);
    ad.d("MicroMsg.OnlineVideoView", "%d register sns ui event", new Object[] { Integer.valueOf(hashCode()) });
    com.tencent.mm.sdk.b.a.ESL.c(this.xpV);
    AppMethodBeat.o(98063);
  }
  
  public final int eM(int paramInt1, int paramInt2)
  {
    return 0;
  }
  
  protected final void ez(boolean paramBoolean)
  {
    AppMethodBeat.i(98081);
    if (this.xpI)
    {
      if (paramBoolean)
      {
        aq.f(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(187579);
            if ((OnlineVideoView.this.nAZ != null) && (OnlineVideoView.this.xpH != null))
            {
              int i = OnlineVideoView.this.nAZ.getCurrentPosition() / 1000;
              OnlineVideoView.this.xpH.oR(i);
            }
            OnlineVideoView.m(OnlineVideoView.this).av(500L, 500L);
            AppMethodBeat.o(187579);
          }
        });
        AppMethodBeat.o(98081);
        return;
      }
      this.xdT.av(500L, 500L);
      AppMethodBeat.o(98081);
      return;
    }
    this.nBf.av(500L, 500L);
    AppMethodBeat.o(98081);
  }
  
  protected Context getActivityContext()
  {
    if (this.xpR == null) {
      return this.mContext;
    }
    return this.xpR;
  }
  
  public int getCurrentPosition()
  {
    AppMethodBeat.i(98100);
    int i = this.nAZ.getCurrentPosition();
    AppMethodBeat.o(98100);
    return i;
  }
  
  public int getDuration()
  {
    AppMethodBeat.i(98077);
    if (this.nAZ == null)
    {
      AppMethodBeat.o(98077);
      return 0;
    }
    int i = this.nAZ.getDuration();
    AppMethodBeat.o(98077);
    return i;
  }
  
  public String getFilePath()
  {
    return this.filePath;
  }
  
  public int getPlayErrorCode()
  {
    return this.qmp;
  }
  
  public int getPlayVideoDuration()
  {
    AppMethodBeat.i(98094);
    if (this.xpX < 0) {
      this.xpX = 0;
    }
    ad.i("MicroMsg.OnlineVideoView", "%d get play video duration [%d]", new Object[] { Integer.valueOf(hashCode()), Integer.valueOf(this.xpX) });
    int i = this.xpX;
    AppMethodBeat.o(98094);
    return i;
  }
  
  public int getPlayVideoDurationByResume()
  {
    AppMethodBeat.i(98097);
    if (this.xpZ < 0) {
      this.xpZ = 0;
    }
    ad.i("MicroMsg.OnlineVideoView", "%d get play video duration by resume [%d]", new Object[] { Integer.valueOf(hashCode()), Integer.valueOf(this.xpZ) });
    int i = this.xpZ;
    AppMethodBeat.o(98097);
    return i;
  }
  
  public ah.c getRptStruct()
  {
    AppMethodBeat.i(98099);
    ah.c localc = new ah.c();
    localc.scene = this.scene;
    localc.sessionId = this.sessionId;
    localc.xpP = this.xpP;
    localc.dpC = this.dpC;
    localc.filePath = this.filePath;
    AppMethodBeat.o(98099);
    return localc;
  }
  
  public int getScene()
  {
    return this.scene;
  }
  
  public String getSessionId()
  {
    return this.sessionId;
  }
  
  public long getSessionTimestamp()
  {
    return this.xpP;
  }
  
  public String getSnsId()
  {
    return this.dpC;
  }
  
  public int getUiStayTime()
  {
    if ((this.xpN > 0L) && (this.xpM > 0L)) {}
    for (int i = (int)(this.xpN - this.xpM);; i = 0)
    {
      if (i < 0) {
        return 0;
      }
      return i;
    }
  }
  
  public final boolean isPlaying()
  {
    AppMethodBeat.i(98098);
    boolean bool = this.nAZ.isPlaying();
    AppMethodBeat.o(98098);
    return bool;
  }
  
  public final void onCompletion()
  {
    AppMethodBeat.i(98085);
    ad.i("MicroMsg.OnlineVideoView", "%d on completion", new Object[] { Integer.valueOf(hashCode()) });
    if (this.xpG == null)
    {
      if ((com.tencent.mm.compatible.util.d.lh(18)) || (!this.qmo))
      {
        GI(0);
        AppMethodBeat.o(98085);
        return;
      }
      if (this.nAZ != null)
      {
        String str = this.nAZ.getVideoPath();
        this.nAZ.stop();
        bG(str, this.xpI);
      }
    }
    AppMethodBeat.o(98085);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(98070);
    ad.d("MicroMsg.OnlineVideoView", "%d on destroy %s", new Object[] { Integer.valueOf(hashCode()), bt.eGN() });
    this.xpN = bt.eGO();
    NX();
    AppMethodBeat.o(98070);
  }
  
  public final void onError(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(98083);
    ad.e("MicroMsg.OnlineVideoView", "%d on play video error what %d extra %d. isOnlinePlay %b isMMVideoPlayer[%b]", new Object[] { Integer.valueOf(hashCode()), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Boolean.valueOf(this.xpI), Boolean.valueOf(this.qmo) });
    Object localObject;
    if (this.xpI)
    {
      com.tencent.mm.plugin.report.service.h.vKh.idkeyStat(354L, 230L, 1L, false);
      this.qmp = paramInt2;
      dzH();
      localObject = this.nAZ.getVideoPath();
      this.xpK = (this.nAZ.getCurrentPosition() / 1000);
      if (!this.xpI) {
        break label386;
      }
      if (paramInt1 != -2) {
        break label339;
      }
      this.nAZ.stop();
    }
    for (;;)
    {
      try
      {
        showLoading();
        if (this.xpH != null)
        {
          localObject = this.xpH;
          String str = ((ah)localObject).hxP + 0 + "_-1";
          if (!((ah)localObject).xqj.containsKey(str))
          {
            ad.i("MicroMsg.OnlineVideoViewHelper", "request all data. [%s]", new Object[] { ((ah)localObject).hxP });
            o.aCJ();
            com.tencent.mm.ao.e.q(((ah)localObject).hxP, 0, -1);
            ((ah)localObject).xqj.put(str, Integer.valueOf(0));
            com.tencent.mm.plugin.report.service.h.vKh.idkeyStat(354L, 207L, 1L, false);
            com.tencent.mm.plugin.report.service.h.vKh.f(13836, new Object[] { Integer.valueOf(403), Long.valueOf(bt.aGK()), "" });
          }
          ((ah)localObject).hxT = 5;
          ((ah)localObject).hxY = true;
          ((ah)localObject).hyb = false;
        }
        dzH();
        AppMethodBeat.o(98083);
        return;
      }
      catch (Exception localException)
      {
        label339:
        AppMethodBeat.o(98083);
        return;
      }
      com.tencent.mm.plugin.report.service.h.vKh.idkeyStat(354L, 231L, 1L, false);
      break;
      if (paramInt1 == -3)
      {
        this.xpL = paramInt1;
        this.nAZ.pause();
      }
      else
      {
        dzu();
        this.nAZ.stop();
      }
    }
    label386:
    this.nAZ.stop();
    this.qmn = true;
    b(false, 0.0F);
    ad.w("MicroMsg.OnlineVideoView", "error %s, %s", new Object[] { Boolean.valueOf(this.xpS), localException });
    if ((!bt.isNullOrNil(localException)) && (this.xpS))
    {
      ad.w("MicroMsg.OnlineVideoView", "%d start third player to play", new Object[] { Integer.valueOf(hashCode()) });
      this.nzT.post(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(98051);
          Object localObject = new Intent();
          ((Intent)localObject).setAction("android.intent.action.VIEW");
          m.a(OnlineVideoView.this.getContext(), (Intent)localObject, new com.tencent.mm.vfs.e(localException), "video/*");
          try
          {
            Context localContext = OnlineVideoView.this.getContext();
            localObject = new com.tencent.mm.hellhoundlib.b.a().bd(localObject);
            com.tencent.mm.hellhoundlib.a.a.a(localContext, ((com.tencent.mm.hellhoundlib.b.a)localObject).adn(), "com/tencent/mm/plugin/sns/ui/OnlineVideoView$17", "run", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            localContext.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).lS(0));
            com.tencent.mm.hellhoundlib.a.a.a(localContext, "com/tencent/mm/plugin/sns/ui/OnlineVideoView$17", "run", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            AppMethodBeat.o(98051);
            return;
          }
          catch (Exception localException)
          {
            ad.e("MicroMsg.OnlineVideoView", "startActivity fail, activity not found");
            try
            {
              f.a locala = new f.a(OnlineVideoView.this.getContext());
              locala.aMo(OnlineVideoView.this.getContext().getString(2131758931));
              locala.au(OnlineVideoView.this.getContext().getString(2131758932)).c(new f.c()
              {
                public final void d(boolean paramAnonymous2Boolean, String paramAnonymous2String) {}
              }).show();
              AppMethodBeat.o(98051);
              return;
            }
            catch (Throwable localThrowable)
            {
              ad.e("MicroMsg.OnlineVideoView", "showAlert fail");
              AppMethodBeat.o(98051);
            }
          }
        }
      });
    }
    AppMethodBeat.o(98083);
  }
  
  public final void onPause()
  {
    AppMethodBeat.i(98069);
    ad.d("MicroMsg.OnlineVideoView", "%d on pause %s ", new Object[] { Integer.valueOf(hashCode()), bt.eGN() });
    dzu();
    if (this.nAZ != null) {
      this.nAZ.stop();
    }
    AppMethodBeat.o(98069);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(98068);
    ad.d("MicroMsg.OnlineVideoView", "%d on resume %s", new Object[] { Integer.valueOf(hashCode()), bt.eGN() });
    this.xpM = bt.eGO();
    if (this.xpQ)
    {
      ad.e("MicroMsg.OnlineVideoView", "what are you doing guys!!! Would you like to invite everyone to eat pizza??? %s", new Object[] { bt.eGN() });
      com.tencent.mm.plugin.report.service.h.vKh.m(31L, 3L, 1L);
    }
    for (;;)
    {
      if (!this.qmn) {
        ckc();
      }
      this.xpw = true;
      AppMethodBeat.o(98068);
      return;
      if (this.xpH == null)
      {
        this.csX = true;
        ad.i("MicroMsg.OnlineVideoView", "%d logic init, create new helper and add listener.", new Object[] { Integer.valueOf(hashCode()) });
        this.xpH = new ah(this);
        com.tencent.mm.sdk.b.a.ESL.c(this.wKr);
        com.tencent.mm.sdk.b.a.ESL.c(this.xpU);
        af.dtp().a(this.xpT);
        if (this.xpO)
        {
          this.nnt = new com.tencent.mm.model.d();
          this.nnt.a(this);
        }
        if (com.tencent.mm.r.a.Lv() != null) {
          com.tencent.mm.r.a.Lv().Tk();
        }
      }
    }
  }
  
  public final void rq()
  {
    AppMethodBeat.i(98084);
    ad.i("MicroMsg.OnlineVideoView", "%d onPrepared playErrorCode[%d] onErrorPlayTimeSec[%d]", new Object[] { Integer.valueOf(hashCode()), Integer.valueOf(this.qmp), Integer.valueOf(this.xpK) });
    this.qmp = 0;
    if (this.xpK > 0)
    {
      GI(this.xpK);
      this.xpK = 0;
      AppMethodBeat.o(98084);
      return;
    }
    this.xpL = 0;
    hideLoading();
    dzG();
    dzI();
    this.nAZ.start();
    this.duration = (this.nAZ.getDuration() / 1000);
    ad.i("MicroMsg.OnlineVideoView", "%d start play duration %d sns local id %s ", new Object[] { Integer.valueOf(hashCode()), Integer.valueOf(this.duration), this.diQ });
    ez(false);
    AppMethodBeat.o(98084);
  }
  
  public void setFilePath(String paramString)
  {
    this.filePath = paramString;
  }
  
  public void setMute(boolean paramBoolean)
  {
    AppMethodBeat.i(98067);
    this.fqj = paramBoolean;
    this.nAZ.setMute(this.fqj);
    AppMethodBeat.o(98067);
  }
  
  public void setScene(int paramInt)
  {
    this.scene = paramInt;
  }
  
  public void setSessionId(String paramString)
  {
    this.sessionId = paramString;
  }
  
  public void setSessionTimestamp(long paramLong)
  {
    this.xpP = paramLong;
  }
  
  public void setSnsId(String paramString)
  {
    this.dpC = paramString;
  }
  
  public void setThumbViewScaleType(ImageView.ScaleType paramScaleType)
  {
    AppMethodBeat.i(98101);
    this.qir.setScaleType(paramScaleType);
    AppMethodBeat.o(98101);
  }
  
  public void setVideoCallback(a parama)
  {
    this.xpG = parama;
  }
  
  public void setVideoScaleType(com.tencent.mm.pluginsdk.ui.h.e parame)
  {
    AppMethodBeat.i(98102);
    if (this.nAZ != null)
    {
      if ((this.nAZ instanceof VideoPlayerTextureView))
      {
        ((VideoPlayerTextureView)this.nAZ).setScaleType(parame);
        AppMethodBeat.o(98102);
        return;
      }
      if ((this.nAZ instanceof VideoTextureView)) {
        ((VideoTextureView)this.nAZ).setScaleType(parame);
      }
    }
    AppMethodBeat.o(98102);
  }
  
  public static abstract interface a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.OnlineVideoView
 * JD-Core Version:    0.7.0.1
 */