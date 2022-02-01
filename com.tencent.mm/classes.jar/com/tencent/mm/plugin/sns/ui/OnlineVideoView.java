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
import com.tencent.mm.app.j.a;
import com.tencent.mm.app.j.b;
import com.tencent.mm.g.a.cw;
import com.tencent.mm.g.a.cw.b;
import com.tencent.mm.g.a.ny;
import com.tencent.mm.g.a.ny.a;
import com.tencent.mm.g.a.ul;
import com.tencent.mm.g.a.uo;
import com.tencent.mm.g.a.uo.a;
import com.tencent.mm.g.a.vn;
import com.tencent.mm.model.d.a;
import com.tencent.mm.modelvideo.u;
import com.tencent.mm.plugin.sns.data.r;
import com.tencent.mm.plugin.sns.model.ah;
import com.tencent.mm.plugin.sns.model.ap;
import com.tencent.mm.plugin.sns.model.c.b;
import com.tencent.mm.plugin.sns.storage.q;
import com.tencent.mm.pluginsdk.ui.i.e;
import com.tencent.mm.pluginsdk.ui.tools.VideoPlayerTextureView;
import com.tencent.mm.pluginsdk.ui.tools.VideoTextureView;
import com.tencent.mm.pluginsdk.ui.tools.h;
import com.tencent.mm.pluginsdk.ui.tools.h.a;
import com.tencent.mm.pluginsdk.ui.tools.h.e;
import com.tencent.mm.protocal.protobuf.bzh;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.ar;
import com.tencent.mm.sdk.platformtools.aw.a;
import com.tencent.mm.sdk.platformtools.ay;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.storage.am.a;
import com.tencent.mm.storage.bk;
import com.tencent.mm.ui.widget.MMPinProgressBtn;
import com.tencent.mm.ui.widget.a.f.a;
import com.tencent.mm.ui.widget.a.f.c;
import com.tencent.mm.vfs.k;
import java.util.HashMap;

public class OnlineVideoView
  extends RelativeLayout
  implements d.a, ak.a, h.a
{
  private boolean AkN;
  private h.e AkS;
  private int AkV;
  String AkW;
  private boolean AkX;
  private a AkY;
  protected ak AkZ;
  private boolean Ala;
  private boolean Alb;
  private int Alc;
  private int Ald;
  private long Ale;
  private long Alf;
  protected boolean Alg;
  private long Alh;
  public volatile boolean Ali;
  protected Activity Alj;
  protected boolean Alk;
  private c.b Alm;
  private com.tencent.mm.sdk.b.c Aln;
  private com.tencent.mm.sdk.b.c Alo;
  private long Alp;
  private int Alq;
  private long Alr;
  private int Als;
  private boolean Alt;
  private volatile boolean cBE;
  private String dAg;
  private int dKK;
  private boolean dKL;
  private int dKM;
  private bzh dKe;
  private String dsN;
  private int duration;
  private boolean fOX;
  private String filePath;
  private TextView gWL;
  private int icw;
  private ProgressBar lxB;
  private Context mContext;
  aq oMO;
  protected h oNV;
  private com.tencent.mm.sdk.platformtools.aw oOb;
  com.tencent.mm.model.d ozB;
  ImageView rJe;
  private RelativeLayout rJz;
  private TextView rNj;
  private boolean rNo;
  private boolean rNp;
  private int rNq;
  private MMPinProgressBtn rNt;
  private int scene;
  private String sessionId;
  boolean vFb;
  private com.tencent.mm.plugin.o.b vXD;
  private int videoHeight;
  private int videoWidth;
  private com.tencent.mm.sdk.b.c zEl;
  private com.tencent.mm.sdk.platformtools.aw zYZ;
  private bk zul;
  
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
    this.AkV = 0;
    this.vFb = false;
    this.rNo = false;
    this.fOX = false;
    this.dKe = null;
    this.AkX = false;
    this.AkZ = null;
    this.Alb = false;
    this.duration = 0;
    this.Alc = 0;
    this.Ald = 0;
    this.Ale = 0L;
    this.Alf = 0L;
    this.rNq = 0;
    this.ozB = null;
    this.Alg = true;
    this.oMO = new aq(Looper.getMainLooper());
    this.scene = 0;
    this.Alh = 0L;
    this.sessionId = "";
    this.dAg = "";
    this.filePath = "";
    this.videoWidth = 0;
    this.videoHeight = 0;
    this.cBE = false;
    this.Ali = false;
    this.Alk = false;
    this.zYZ = new com.tencent.mm.sdk.platformtools.aw(new aw.a()
    {
      public final boolean onTimerExpired()
      {
        AppMethodBeat.i(219710);
        if ((OnlineVideoView.this.AkZ == null) || (OnlineVideoView.this.oNV == null))
        {
          AppMethodBeat.o(219710);
          return false;
        }
        if (((View)OnlineVideoView.this.oNV).getAlpha() < 1.0F)
        {
          ae.i("MicroMsg.OnlineVideoView", "onlineVideoTimer switchVideoModel");
          OnlineVideoView.q(OnlineVideoView.this);
        }
        if (OnlineVideoView.this.oNV.isPlaying()) {
          OnlineVideoView.r(OnlineVideoView.this);
        }
        try
        {
          boolean bool = bu.isNullOrNil(OnlineVideoView.this.AkZ.iuG);
          if (!bool) {}
          for (int i = 1; i == 0; i = 0)
          {
            AppMethodBeat.o(219710);
            return false;
          }
          i = OnlineVideoView.this.oNV.getCurrentPosition() / 1000;
          OnlineVideoView.this.RD(i);
          bool = OnlineVideoView.this.AkZ.ql(i);
          AppMethodBeat.o(219710);
          return bool;
        }
        catch (Exception localException)
        {
          ae.e("MicroMsg.OnlineVideoView", "online video timer check error : " + localException.toString());
          AppMethodBeat.o(219710);
        }
        return false;
      }
    }, true);
    this.oOb = new com.tencent.mm.sdk.platformtools.aw(new aw.a()
    {
      public final boolean onTimerExpired()
      {
        AppMethodBeat.i(219711);
        if (OnlineVideoView.this.oNV == null)
        {
          AppMethodBeat.o(219711);
          return false;
        }
        if (((View)OnlineVideoView.this.oNV).getAlpha() < 1.0F)
        {
          ae.i("MicroMsg.OnlineVideoView", "offlineVideoTimer switchVideoModel");
          OnlineVideoView.q(OnlineVideoView.this);
        }
        if (OnlineVideoView.this.oNV.isPlaying())
        {
          OnlineVideoView.r(OnlineVideoView.this);
          OnlineVideoView.this.RD(OnlineVideoView.this.oNV.getCurrentPosition() / 1000);
        }
        AppMethodBeat.o(219711);
        return true;
      }
    }, true);
    this.Alm = new c.b()
    {
      public final void azJ(String paramAnonymousString) {}
      
      public final void bQ(String paramAnonymousString, boolean paramAnonymousBoolean) {}
      
      public final void bR(final String paramAnonymousString, final boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(219712);
        OnlineVideoView.g(OnlineVideoView.this).postDelayed(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(98044);
            ae.i("MicroMsg.OnlineVideoView", "%d weixin download finish[%b], go to prepare video", new Object[] { Integer.valueOf(OnlineVideoView.this.hashCode()), Boolean.valueOf(paramAnonymousBoolean) });
            if ((OnlineVideoView.c(OnlineVideoView.this) != null) && (paramAnonymousBoolean) && (bu.lX(OnlineVideoView.c(OnlineVideoView.this).Id, paramAnonymousString)))
            {
              com.tencent.mm.plugin.sns.model.aw.jx(OnlineVideoView.a(OnlineVideoView.this), "");
              String str = com.tencent.mm.plugin.sns.model.aw.a(OnlineVideoView.a(OnlineVideoView.this), OnlineVideoView.c(OnlineVideoView.this));
              if (!bu.isNullOrNil(str)) {
                OnlineVideoView.this.bY(str, false);
              }
            }
            AppMethodBeat.o(98044);
          }
        }, 100L);
        AppMethodBeat.o(219712);
      }
      
      public final void dWB() {}
    };
    this.Aln = new com.tencent.mm.sdk.b.c() {};
    this.Alo = new com.tencent.mm.sdk.b.c() {};
    this.zEl = new com.tencent.mm.sdk.b.c()
    {
      private boolean a(ny paramAnonymousny)
      {
        AppMethodBeat.i(219717);
        if (OnlineVideoView.this.AkZ == null)
        {
          ae.w("MicroMsg.OnlineVideoView", "%d online video helper is null.", new Object[] { Integer.valueOf(OnlineVideoView.this.hashCode()) });
          AppMethodBeat.o(219717);
          return false;
        }
        ae.w("MicroMsg.OnlineVideoView", "OnlineVideoEvent is received, the OnlineVideoEvent opcode is " + paramAnonymousny.dCP.dto);
        ae.w("MicroMsg.OnlineVideoView", "OnlineVideoEvent is received, the OnlineVideoEvent length is " + paramAnonymousny.dCP.length);
        ae.w("MicroMsg.OnlineVideoView", "OnlineVideoEvent is received, the OnlineVideoEvent offset is " + paramAnonymousny.dCP.offset);
        ae.w("MicroMsg.OnlineVideoView", "OnlineVideoEvent is received, the OnlineVideoEvent mediaId is " + paramAnonymousny.dCP.mediaId);
        ae.w("MicroMsg.OnlineVideoView", "OnlineVideoEvent is received, the OnlineVideoEvent retCode is " + paramAnonymousny.dCP.retCode);
        ae.w("MicroMsg.OnlineVideoView", "OnlineVideoEvent is received, the OnlineVideoEvent startDownload is " + paramAnonymousny.dCP.dCQ);
        try
        {
          bool = OnlineVideoView.this.AkZ.aCb(paramAnonymousny.dCP.mediaId);
          if (!bool)
          {
            AppMethodBeat.o(219717);
            return false;
          }
          if (paramAnonymousny.dCP.retCode == -21112)
          {
            paramAnonymousny = OnlineVideoView.this;
            com.tencent.mm.plugin.report.service.g.yxI.idkeyStat(354L, 218L, 1L, false);
            paramAnonymousny.oMO.post(new OnlineVideoView.11(paramAnonymousny));
            AppMethodBeat.o(219717);
            return false;
          }
          if ((paramAnonymousny.dCP.retCode != 0) && (paramAnonymousny.dCP.retCode != -21006))
          {
            ae.w("MicroMsg.OnlineVideoView", "%d stream download online video error. retCode %d ", new Object[] { Integer.valueOf(OnlineVideoView.this.hashCode()), Integer.valueOf(paramAnonymousny.dCP.retCode) });
            AppMethodBeat.o(219717);
            return false;
          }
          switch (paramAnonymousny.dCP.dto)
          {
          }
        }
        catch (Exception paramAnonymousny)
        {
          for (;;)
          {
            boolean bool;
            long l2;
            long l1;
            ae.e("MicroMsg.OnlineVideoView", "online video callback error: " + paramAnonymousny.toString());
            continue;
            if (l1 > localak.fLF) {}
            for (;;)
            {
              for (;;)
              {
                localak.fLF = l1;
                localak.AlH = bu.fpO();
                try
                {
                  if (localak.AlD != null) {
                    break label682;
                  }
                  ae.w("MicroMsg.OnlineVideoViewHelper", "parser is null, thread is error.");
                }
                catch (Exception paramAnonymousny)
                {
                  ae.e("MicroMsg.OnlineVideoViewHelper", "deal moov ready error: " + paramAnonymousny.toString());
                }
              }
              break;
              l1 = localak.fLF;
            }
            if (localak.AlD.L(localak.iuH, l2))
            {
              localak.iuM = localak.AlD.iTC;
              ae.i("MicroMsg.OnlineVideoViewHelper", "mp4 parse moov success. duration %d cdnMediaId %s isFastStart %b", new Object[] { Integer.valueOf(localak.iuM), localak.iuG, Boolean.valueOf(bool) });
              if (!bool) {
                ar.f(new ak.1(localak));
              }
              if (localak.iuN == -1) {}
              for (localak.iuK = 1;; localak.iuK = 2)
              {
                com.tencent.mm.plugin.report.service.g.yxI.idkeyStat(354L, 204L, 1L, false);
                break;
              }
            }
            ae.w("MicroMsg.OnlineVideoViewHelper", "mp4 parse moov error. cdnMediaId %s", new Object[] { localak.iuG });
            com.tencent.mm.modelvideo.o.aNi();
            com.tencent.mm.an.e.r(localak.iuG, 0, -1);
            com.tencent.mm.plugin.report.service.g.yxI.idkeyStat(354L, 205L, 1L, false);
            com.tencent.mm.plugin.report.service.g.yxI.f(13836, new Object[] { Integer.valueOf(402), Long.valueOf(bu.aRi()), "" });
            continue;
            ak localak = OnlineVideoView.this.AkZ;
            Object localObject = paramAnonymousny.dCP.mediaId;
            int i = paramAnonymousny.dCP.offset;
            int j = paramAnonymousny.dCP.length;
            localak.iuT = false;
            if ((i < 0) || (j < 0)) {
              ae.w("MicroMsg.OnlineVideoViewHelper", "deal data available error offset[%d], length[%d]", new Object[] { Integer.valueOf(i), Integer.valueOf(j) });
            }
            while (!localak.aCb((String)localObject))
            {
              if (paramAnonymousny.dCP.length <= 0) {
                break;
              }
              OnlineVideoView.this.eY(true);
              break;
            }
            localObject = localak.iuG + i + "_" + j;
            localObject = (Integer)localak.AlC.get(localObject);
            if ((localObject != null) && (((Integer)localObject).intValue() > 0)) {
              localak.iuQ = ((Integer)localObject).intValue();
            }
            for (;;)
            {
              ae.i("MicroMsg.OnlineVideoViewHelper", "deal data available. offset[%d] length[%d] cachePlayTime[%d]", new Object[] { Integer.valueOf(i), Integer.valueOf(j), Integer.valueOf(localak.iuQ) });
              break;
              try
              {
                localak.iuQ = localak.AlD.dy(i, j);
              }
              catch (Exception localException)
              {
                ae.e("MicroMsg.OnlineVideoViewHelper", "deal data available file pos to video time error: " + localException.toString());
              }
            }
            OnlineVideoView.this.eY(true);
            continue;
            ae.i("MicroMsg.OnlineVideoView", "%d download finish. cdnMediaId %s sendReqCode %d favFromScene %d", new Object[] { Integer.valueOf(OnlineVideoView.this.hashCode()), paramAnonymousny.dCP.mediaId, Integer.valueOf(OnlineVideoView.v(OnlineVideoView.this)), Integer.valueOf(OnlineVideoView.w(OnlineVideoView.this)) });
            paramAnonymousny = OnlineVideoView.this.AkZ;
            ae.i("MicroMsg.OnlineVideoViewHelper", "deal stream finish. playStatus %d cdnMediaId %s", new Object[] { Integer.valueOf(paramAnonymousny.iuK), paramAnonymousny.iuG });
            paramAnonymousny.iuT = false;
            paramAnonymousny.iuJ = 3;
            com.tencent.mm.plugin.report.service.g.yxI.idkeyStat(354L, 206L, 1L, false);
            if (paramAnonymousny.iuK == 0)
            {
              ae.w("MicroMsg.OnlineVideoViewHelper", "it had not moov callback and download finish start to play video.");
              paramAnonymousny.eeh();
            }
            for (;;)
            {
              if (OnlineVideoView.v(OnlineVideoView.this) <= 0) {
                break label1390;
              }
              OnlineVideoView.r(OnlineVideoView.this);
              OnlineVideoView.b(OnlineVideoView.this, OnlineVideoView.v(OnlineVideoView.this));
              break;
              if (paramAnonymousny.iuK == 5)
              {
                ae.w("MicroMsg.OnlineVideoViewHelper", "it had play error, it request all video data finish, start to play." + paramAnonymousny.iuG);
                paramAnonymousny.eeh();
              }
            }
            if (OnlineVideoView.w(OnlineVideoView.this) > 0)
            {
              OnlineVideoView.r(OnlineVideoView.this);
              OnlineVideoView.b(OnlineVideoView.this, OnlineVideoView.w(OnlineVideoView.this), OnlineVideoView.x(OnlineVideoView.this));
            }
            else if (OnlineVideoView.y(OnlineVideoView.this))
            {
              OnlineVideoView.r(OnlineVideoView.this);
              OnlineVideoView.z(OnlineVideoView.this);
            }
            else
            {
              OnlineVideoView.this.eY(true);
              continue;
              if (OnlineVideoView.o(OnlineVideoView.this) == 1)
              {
                localak = OnlineVideoView.this.AkZ;
                String str = paramAnonymousny.dCP.mediaId;
                i = paramAnonymousny.dCP.offset;
                j = paramAnonymousny.dCP.length;
                if (localak.aCb(str))
                {
                  localak.progress = i;
                  localak.ihz = j;
                  localak.AlF = (localak.progress * 100 / localak.ihz);
                  ae.i("MicroMsg.OnlineVideoViewHelper", "deal video[%s] progress callback[%d, %d]. downloadedPercent[%d]", new Object[] { localak.iuG, Integer.valueOf(localak.progress), Integer.valueOf(localak.ihz), Integer.valueOf(localak.AlF) });
                }
                if (localak.AlF >= 100) {
                  localak.iuJ = 3;
                }
              }
              else if (OnlineVideoView.o(OnlineVideoView.this) == 2)
              {
                OnlineVideoView.a(OnlineVideoView.this, paramAnonymousny.dCP.offset, paramAnonymousny.dCP.length);
                continue;
                paramAnonymousny = OnlineVideoView.this.AkZ;
                ae.i("MicroMsg.OnlineVideoViewHelper", "deal had dup video. cdnMediaId %s", new Object[] { paramAnonymousny.iuG });
                paramAnonymousny.eeh();
              }
            }
          }
        }
        ae.w("MicroMsg.OnlineVideoView", "%d unknown event opcode %d", new Object[] { Integer.valueOf(OnlineVideoView.this.hashCode()), Integer.valueOf(paramAnonymousny.dCP.dto) });
        for (;;)
        {
          AppMethodBeat.o(219717);
          return false;
          localak = OnlineVideoView.this.AkZ;
          l2 = paramAnonymousny.dCP.offset;
          l1 = paramAnonymousny.dCP.dCQ;
          bool = paramAnonymousny.dCP.dCR;
          ae.i("MicroMsg.OnlineVideoViewHelper", "deal moov ready moovPos %d, timeDuration %d, cdnMediaId %s startDownload[%d %d]", new Object[] { Long.valueOf(l2), Integer.valueOf(localak.iuM), localak.iuG, Long.valueOf(l1), Long.valueOf(localak.fLF) });
          if (localak.iuM == 0) {
            break;
          }
          ae.w("MicroMsg.OnlineVideoViewHelper", "moov had callback, do nothing.");
          OnlineVideoView.u(OnlineVideoView.this);
        }
      }
    };
    this.AkS = new h.e()
    {
      public final void bpD()
      {
        AppMethodBeat.i(219719);
        ae.i("MicroMsg.OnlineVideoView", "%d on texture update.", new Object[] { Integer.valueOf(OnlineVideoView.this.hashCode()) });
        try
        {
          OnlineVideoView.q(OnlineVideoView.this);
          AppMethodBeat.o(219719);
          return;
        }
        catch (Exception localException)
        {
          ae.e("MicroMsg.OnlineVideoView", "texture view update. error " + localException.toString());
          AppMethodBeat.o(219719);
        }
      }
    };
    this.vXD = new com.tencent.mm.plugin.o.b()
    {
      public final long dpl()
      {
        AppMethodBeat.i(219720);
        ae.i("MicroMsg.OnlineVideoView", "%d sns video get online cache", new Object[] { Integer.valueOf(OnlineVideoView.this.hashCode()) });
        com.tencent.mm.kernel.g.ajS();
        com.tencent.mm.kernel.g.ajR().ajA().set(am.a.ISo, Boolean.TRUE);
        try
        {
          if ((OnlineVideoView.A(OnlineVideoView.this)) && (OnlineVideoView.this.AkZ != null))
          {
            int i = OnlineVideoView.this.AkZ.iuQ;
            long l = i;
            AppMethodBeat.o(219720);
            return l;
          }
        }
        catch (Exception localException)
        {
          AppMethodBeat.o(219720);
        }
        return 0L;
      }
    };
    this.Alt = true;
    this.mContext = paramContext;
    ae.i("MicroMsg.OnlineVideoView", "%d ui init view.", new Object[] { Integer.valueOf(hashCode()) });
    LayoutInflater.from(paramContext).inflate(2131495624, this);
    this.rJe = ((ImageView)findViewById(2131306398));
    this.rJz = ((RelativeLayout)findViewById(2131306392));
    this.gWL = ((TextView)findViewById(2131306332));
    this.gWL.setVisibility(8);
    this.rNt = ((MMPinProgressBtn)findViewById(2131306379));
    this.lxB = ((ProgressBar)findViewById(2131306352));
    this.rNj = ((TextView)findViewById(2131306403));
    com.tencent.mm.modelcontrol.d.aHh();
    if (com.tencent.mm.modelcontrol.d.aHt())
    {
      this.rNp = true;
      this.oNV = new VideoPlayerTextureView(paramContext);
      ((VideoPlayerTextureView)this.oNV).setIOnlineCache(this.vXD);
      ((VideoPlayerTextureView)this.oNV).setOpenWithNoneSurface(true);
      com.tencent.mm.plugin.report.service.g.yxI.idkeyStat(354L, 148L, 1L, false);
    }
    for (;;)
    {
      this.oNV.setVideoCallback(this);
      paramContext = new RelativeLayout.LayoutParams(-1, -2);
      paramContext.addRule(13);
      this.rJz.addView((View)this.oNV, paramContext);
      ae.i("MicroMsg.OnlineVideoView", "%d switch sync video model isVideoPlay %b %f", new Object[] { Integer.valueOf(hashCode()), Boolean.FALSE, Float.valueOf(0.0F) });
      paramContext = (View)this.oNV;
      this.rJz.setVisibility(8);
      paramContext.setVisibility(8);
      if (this.Alt) {
        this.rJe.setVisibility(0);
      }
      AppMethodBeat.o(98060);
      return;
      this.rNp = false;
      this.oNV = new VideoTextureView(paramContext);
      com.tencent.mm.plugin.report.service.g.yxI.idkeyStat(354L, 149L, 1L, false);
    }
  }
  
  private void RE(int paramInt)
  {
    AppMethodBeat.i(98071);
    String str = ap.jv(ah.getAccSnsPath(), this.dKe.Id) + r.d(this.dKe);
    Intent localIntent = new Intent();
    localIntent.putExtra("Select_Conv_Type", 3);
    localIntent.putExtra("select_is_ret", true);
    localIntent.putExtra("mutil_select_is_ret", true);
    localIntent.putExtra("image_path", str);
    localIntent.putExtra("Retr_Msg_Type", 11);
    ae.i("MicroMsg.OnlineVideoView", "send video path %s reqCode %d", new Object[] { str, Integer.valueOf(paramInt) });
    com.tencent.mm.br.d.c(getActivityContext(), ".ui.transmit.SelectConversationUI", localIntent, paramInt);
    this.dKM = 0;
    AppMethodBeat.o(98071);
  }
  
  private void T(boolean paramBoolean, int paramInt)
  {
    boolean bool = true;
    AppMethodBeat.i(98076);
    if (this.dKe == null)
    {
      ae.w("MicroMsg.OnlineVideoView", "%d start download video but media is null.", new Object[] { Integer.valueOf(hashCode()) });
      AppMethodBeat.o(98076);
      return;
    }
    if (this.AkZ == null)
    {
      ae.w("MicroMsg.OnlineVideoView", "%d start download video but helper is null.", new Object[] { Integer.valueOf(hashCode()) });
      AppMethodBeat.o(98076);
      return;
    }
    if (this.dKe.GXH == 2)
    {
      ae.w("MicroMsg.OnlineVideoView", "%d it start download video, url type is weixin", new Object[] { Integer.valueOf(hashCode()) });
      this.AkV = 3;
      ah.dXz().a(this.dKe, 4, null, this.zul);
      AppMethodBeat.o(98076);
      return;
    }
    int i;
    if (!paramBoolean)
    {
      com.tencent.mm.modelcontrol.d.aHh();
      if (com.tencent.mm.modelcontrol.d.aHs())
      {
        ae.i("MicroMsg.OnlineVideoView", "%d it start online download video", new Object[] { Integer.valueOf(hashCode()) });
        this.AkV = 1;
        i = paramInt;
        if (paramInt == 0) {
          i = 30;
        }
        paramBoolean = bool;
        if (this.AkZ == null) {
          break label281;
        }
        this.AkZ.a(this.dKe, this.icw, this.dsN, paramBoolean, i);
        AppMethodBeat.o(98076);
        return;
      }
    }
    ae.i("MicroMsg.OnlineVideoView", "%d it start offline download video", new Object[] { Integer.valueOf(hashCode()) });
    this.AkV = 2;
    if (paramInt != 0) {}
    for (;;)
    {
      paramBoolean = false;
      i = paramInt;
      break;
      paramInt = 31;
    }
    label281:
    ae.w("MicroMsg.OnlineVideoView", "onlineVideoHelper is null!!!");
    AppMethodBeat.o(98076);
  }
  
  private void aG(final int paramInt, final boolean paramBoolean)
  {
    AppMethodBeat.i(98072);
    this.oMO.post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(98040);
        Object localObject1 = ah.dXE().aBr(OnlineVideoView.a(OnlineVideoView.this));
        if (localObject1 == null)
        {
          AppMethodBeat.o(98040);
          return;
        }
        ae.i("MicroMsg.OnlineVideoView", "fav download video[%s] farFromScene %d isFromMain %b", new Object[] { OnlineVideoView.a(OnlineVideoView.this), Integer.valueOf(paramInt), Boolean.valueOf(paramBoolean) });
        Object localObject2 = new cw();
        ((cw)localObject2).doL.doR = paramInt;
        ((cw)localObject2).doL.activity = ((Activity)OnlineVideoView.this.getActivityContext());
        com.tencent.mm.plugin.sns.k.a.a((cw)localObject2, (com.tencent.mm.plugin.sns.storage.p)localObject1);
        com.tencent.mm.sdk.b.a.IvT.l((com.tencent.mm.sdk.b.b)localObject2);
        if (((cw)localObject2).doM.ret == 0) {
          OnlineVideoView.eeb();
        }
        for (;;)
        {
          if (paramBoolean)
          {
            localObject2 = new ul();
            ((ul)localObject2).dJT.dqc = ((com.tencent.mm.plugin.sns.storage.p)localObject1).eco();
            ((ul)localObject2).dJT.dAg = r.o((com.tencent.mm.plugin.sns.storage.p)localObject1);
            com.tencent.mm.sdk.b.a.IvT.l((com.tencent.mm.sdk.b.b)localObject2);
          }
          OnlineVideoView.b(OnlineVideoView.this);
          if (OnlineVideoView.this.oNV == null) {
            break label318;
          }
          if (!bu.isNullOrNil(OnlineVideoView.this.oNV.getVideoPath())) {
            break;
          }
          ae.i("MicroMsg.OnlineVideoView", "%d had not set video path to play", new Object[] { Integer.valueOf(OnlineVideoView.this.hashCode()) });
          localObject1 = com.tencent.mm.plugin.sns.model.aw.a(OnlineVideoView.a(OnlineVideoView.this), OnlineVideoView.c(OnlineVideoView.this));
          if (!bu.isNullOrNil((String)localObject1)) {
            OnlineVideoView.this.bY((String)localObject1, false);
          }
          AppMethodBeat.o(98040);
          return;
          OnlineVideoView.eec();
        }
        if (!OnlineVideoView.this.oNV.isPlaying())
        {
          OnlineVideoView.this.oNV.start();
          AppMethodBeat.o(98040);
          return;
        }
        label318:
        AppMethodBeat.o(98040);
      }
    });
    AppMethodBeat.o(98072);
  }
  
  private void c(final boolean paramBoolean, final float paramFloat)
  {
    AppMethodBeat.i(98074);
    this.oMO.post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(98055);
        ae.i("MicroMsg.OnlineVideoView", "%d switch video model isVideoPlay %b %f", new Object[] { Integer.valueOf(OnlineVideoView.this.hashCode()), Boolean.valueOf(paramBoolean), Float.valueOf(paramFloat) });
        View localView = (View)OnlineVideoView.this.oNV;
        if (paramBoolean)
        {
          OnlineVideoView.j(OnlineVideoView.this).setAlpha(paramFloat);
          OnlineVideoView.j(OnlineVideoView.this).setVisibility(0);
          localView.setAlpha(paramFloat);
          localView.setVisibility(0);
          if (paramFloat >= 1.0D)
          {
            OnlineVideoView.k(OnlineVideoView.this).setVisibility(8);
            AppMethodBeat.o(98055);
          }
        }
        else
        {
          OnlineVideoView.j(OnlineVideoView.this).setVisibility(8);
          localView.setVisibility(8);
          if (OnlineVideoView.l(OnlineVideoView.this)) {
            OnlineVideoView.k(OnlineVideoView.this).setVisibility(0);
          }
        }
        AppMethodBeat.o(98055);
      }
    });
    AppMethodBeat.o(98074);
  }
  
  private void cyW()
  {
    AppMethodBeat.i(98075);
    if (!this.vFb) {}
    for (String str = com.tencent.mm.plugin.sns.model.aw.a(this.dsN, this.dKe);; str = this.AkW)
    {
      ae.i("MicroMsg.OnlineVideoView", "%d toggleVideo local id %s finish path %s isPreview %b", new Object[] { Integer.valueOf(hashCode()), this.dsN, str, Boolean.valueOf(this.vFb) });
      if (bu.isNullOrNil(str)) {
        break;
      }
      ae.i("MicroMsg.OnlineVideoView", "%d sns video already download finish, play now", new Object[] { Integer.valueOf(hashCode()) });
      c(true, 0.0F);
      bY(str, false);
      AppMethodBeat.o(98075);
      return;
    }
    c(false, 0.0F);
    T(false, 0);
    showLoading();
    AppMethodBeat.o(98075);
  }
  
  private boolean cyZ()
  {
    AppMethodBeat.i(98086);
    if (!this.Ala)
    {
      AppMethodBeat.o(98086);
      return false;
    }
    com.tencent.mm.kernel.g.ajS();
    boolean bool = com.tencent.mm.kernel.g.ajR().ajA().getBoolean(am.a.ISo, false);
    AppMethodBeat.o(98086);
    return bool;
  }
  
  private void edS()
  {
    AppMethodBeat.i(219726);
    int j = 2131231318;
    int i = j;
    if (this.dKe != null)
    {
      i = j;
      if (this.dKe.isAd)
      {
        ae.i("MicroMsg.OnlineVideoView", "the media is ad, the background should be transparent");
        i = 2131234429;
      }
    }
    boolean bool = ah.dXB().b(this.dKe, this.rJe, i, this.mContext.hashCode(), this.zul);
    ae.i("MicroMsg.OnlineVideoView", "%d fresh thumb image %b", new Object[] { Integer.valueOf(hashCode()), Boolean.valueOf(bool) });
    AppMethodBeat.o(219726);
  }
  
  private void edU()
  {
    AppMethodBeat.i(98073);
    com.tencent.mm.platformtools.p.a(getContext(), new Runnable()new Runnable
    {
      public final void run()
      {
        AppMethodBeat.i(98052);
        long l = bu.HQ();
        String str1 = com.tencent.mm.plugin.sns.model.aw.a(OnlineVideoView.a(OnlineVideoView.this), OnlineVideoView.c(OnlineVideoView.this));
        String str2 = u.Ib(str1);
        if (bu.isNullOrNil(str2))
        {
          Toast.makeText(OnlineVideoView.d(OnlineVideoView.this), OnlineVideoView.d(OnlineVideoView.this).getString(2131764682), 1).show();
          OnlineVideoView.eed();
        }
        for (;;)
        {
          OnlineVideoView.f(OnlineVideoView.this);
          ae.i("MicroMsg.OnlineVideoView", "%d save downloaded video finish %d %s", new Object[] { Integer.valueOf(hashCode()), Long.valueOf(bu.aO(l)), str1 });
          OnlineVideoView.g(OnlineVideoView.this).post(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(219723);
              if (OnlineVideoView.this.oNV != null)
              {
                if (bu.isNullOrNil(OnlineVideoView.this.oNV.getVideoPath()))
                {
                  ae.i("MicroMsg.OnlineVideoView", "%d had not set video path to play", new Object[] { Integer.valueOf(OnlineVideoView.this.hashCode()) });
                  String str = com.tencent.mm.plugin.sns.model.aw.a(OnlineVideoView.a(OnlineVideoView.this), OnlineVideoView.c(OnlineVideoView.this));
                  if (!bu.isNullOrNil(str)) {
                    OnlineVideoView.this.bY(str, false);
                  }
                  AppMethodBeat.o(219723);
                  return;
                }
                if (!OnlineVideoView.this.oNV.isPlaying())
                {
                  OnlineVideoView.this.oNV.start();
                  AppMethodBeat.o(219723);
                  return;
                }
              }
              AppMethodBeat.o(219723);
            }
          });
          AppMethodBeat.o(98052);
          return;
          Toast.makeText(OnlineVideoView.d(OnlineVideoView.this), OnlineVideoView.d(OnlineVideoView.this).getString(2131764683, new Object[] { com.tencent.mm.sdk.f.b.aSY(str2) }), 1).show();
          com.tencent.mm.sdk.f.b.k(str2, OnlineVideoView.d(OnlineVideoView.this));
          OnlineVideoView.eee();
          OnlineVideoView.e(OnlineVideoView.this);
        }
      }
    }, new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(98053);
        Toast.makeText(OnlineVideoView.d(OnlineVideoView.this), OnlineVideoView.d(OnlineVideoView.this).getString(2131764682), 1).show();
        OnlineVideoView.eed();
        AppMethodBeat.o(98053);
      }
    });
    AppMethodBeat.o(98073);
  }
  
  private void edX()
  {
    AppMethodBeat.i(98092);
    this.Alp = bu.fpO();
    ae.d("MicroMsg.OnlineVideoView", "%d notePlayVideo notePlayVideo %d ", new Object[] { Integer.valueOf(hashCode()), Long.valueOf(this.Alp) });
    AppMethodBeat.o(98092);
  }
  
  private void edY()
  {
    AppMethodBeat.i(98093);
    if (this.Alp > 0L) {
      this.Alq = ((int)(this.Alq + (bu.fpO() - this.Alp) / 1000L));
    }
    ae.i("MicroMsg.OnlineVideoView", "%d notePauseVideo playVideoDuration %d ", new Object[] { Integer.valueOf(hashCode()), Integer.valueOf(this.Alq) });
    this.Alp = 0L;
    AppMethodBeat.o(98093);
  }
  
  private void edZ()
  {
    AppMethodBeat.i(98095);
    this.Alr = bu.fpO();
    ae.d("MicroMsg.OnlineVideoView", "%d noteResumeVideo noteResumeVideo %d ", new Object[] { Integer.valueOf(hashCode()), Long.valueOf(this.Alr) });
    AppMethodBeat.o(98095);
  }
  
  private void eea()
  {
    AppMethodBeat.i(98096);
    if (this.Alr > 0L)
    {
      this.Als = 0;
      this.Als = ((int)(this.Als + (bu.fpO() - this.Alr) / 1000L));
    }
    ae.i("MicroMsg.OnlineVideoView", "%d notePauseVideoByResume playVideoDuration %d ", new Object[] { Integer.valueOf(hashCode()), Integer.valueOf(this.Als) });
    this.Alr = 0L;
    AppMethodBeat.o(98096);
  }
  
  private void hideLoading()
  {
    AppMethodBeat.i(98080);
    this.oMO.post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(219724);
        if ((OnlineVideoView.m(OnlineVideoView.this) != null) && (OnlineVideoView.m(OnlineVideoView.this).getVisibility() != 8))
        {
          ae.i("MicroMsg.OnlineVideoView", "%d hide loading.", new Object[] { Integer.valueOf(OnlineVideoView.this.hashCode()) });
          OnlineVideoView.m(OnlineVideoView.this).setVisibility(8);
        }
        if ((OnlineVideoView.n(OnlineVideoView.this) != null) && (OnlineVideoView.n(OnlineVideoView.this).getVisibility() != 8))
        {
          ae.i("MicroMsg.OnlineVideoView", "%d hide progress.", new Object[] { Integer.valueOf(OnlineVideoView.this.hashCode()) });
          OnlineVideoView.n(OnlineVideoView.this).setVisibility(8);
        }
        AppMethodBeat.o(219724);
      }
    });
    AppMethodBeat.o(98080);
  }
  
  private void showLoading()
  {
    AppMethodBeat.i(98079);
    this.oMO.post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(98057);
        ae.i("MicroMsg.OnlineVideoView", "%d show loading. downloadMode %d", new Object[] { Integer.valueOf(OnlineVideoView.this.hashCode()), Integer.valueOf(OnlineVideoView.o(OnlineVideoView.this)) });
        if (OnlineVideoView.o(OnlineVideoView.this) == 1)
        {
          if ((OnlineVideoView.m(OnlineVideoView.this) != null) && (OnlineVideoView.m(OnlineVideoView.this).getVisibility() != 0)) {
            OnlineVideoView.m(OnlineVideoView.this).setVisibility(0);
          }
          if ((OnlineVideoView.n(OnlineVideoView.this) != null) && (OnlineVideoView.n(OnlineVideoView.this).getVisibility() != 8)) {
            OnlineVideoView.n(OnlineVideoView.this).setVisibility(8);
          }
        }
        if (OnlineVideoView.o(OnlineVideoView.this) == 2)
        {
          if ((OnlineVideoView.n(OnlineVideoView.this) != null) && (OnlineVideoView.n(OnlineVideoView.this).getVisibility() != 0)) {
            OnlineVideoView.n(OnlineVideoView.this).setVisibility(0);
          }
          if ((OnlineVideoView.m(OnlineVideoView.this) != null) && (OnlineVideoView.m(OnlineVideoView.this).getVisibility() != 8)) {
            OnlineVideoView.m(OnlineVideoView.this).setVisibility(8);
          }
        }
        if (OnlineVideoView.o(OnlineVideoView.this) == 3)
        {
          if ((OnlineVideoView.n(OnlineVideoView.this) != null) && (OnlineVideoView.n(OnlineVideoView.this).getVisibility() != 0))
          {
            OnlineVideoView.n(OnlineVideoView.this).setVisibility(0);
            OnlineVideoView.n(OnlineVideoView.this).fPL();
          }
          if ((OnlineVideoView.m(OnlineVideoView.this) != null) && (OnlineVideoView.m(OnlineVideoView.this).getVisibility() != 8)) {
            OnlineVideoView.m(OnlineVideoView.this).setVisibility(8);
          }
        }
        AppMethodBeat.o(98057);
      }
    });
    AppMethodBeat.o(98079);
  }
  
  /* Error */
  private void unInit()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: ldc_w 800
    //   5: invokestatic 159	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   8: aload_0
    //   9: getfield 222	com/tencent/mm/plugin/sns/ui/OnlineVideoView:cBE	Z
    //   12: ifne +12 -> 24
    //   15: ldc_w 800
    //   18: invokestatic 405	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   21: aload_0
    //   22: monitorexit
    //   23: return
    //   24: aload_0
    //   25: iconst_0
    //   26: putfield 222	com/tencent/mm/plugin/sns/ui/OnlineVideoView:cBE	Z
    //   29: ldc_w 263
    //   32: ldc_w 802
    //   35: iconst_1
    //   36: anewarray 267	java/lang/Object
    //   39: dup
    //   40: iconst_0
    //   41: aload_0
    //   42: invokevirtual 271	java/lang/Object:hashCode	()I
    //   45: invokestatic 277	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   48: aastore
    //   49: invokestatic 282	com/tencent/mm/sdk/platformtools/ae:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   52: aload_0
    //   53: invokespecial 420	com/tencent/mm/plugin/sns/ui/OnlineVideoView:edY	()V
    //   56: aload_0
    //   57: invokespecial 804	com/tencent/mm/plugin/sns/ui/OnlineVideoView:eea	()V
    //   60: aload_0
    //   61: getfield 344	com/tencent/mm/plugin/sns/ui/OnlineVideoView:oNV	Lcom/tencent/mm/pluginsdk/ui/tools/h;
    //   64: invokeinterface 807 1 0
    //   69: getstatic 813	com/tencent/mm/sdk/b/a:IvT	Lcom/tencent/mm/sdk/b/a;
    //   72: aload_0
    //   73: getfield 251	com/tencent/mm/plugin/sns/ui/OnlineVideoView:zEl	Lcom/tencent/mm/sdk/b/c;
    //   76: invokevirtual 816	com/tencent/mm/sdk/b/a:d	(Lcom/tencent/mm/sdk/b/c;)Z
    //   79: pop
    //   80: getstatic 813	com/tencent/mm/sdk/b/a:IvT	Lcom/tencent/mm/sdk/b/a;
    //   83: aload_0
    //   84: getfield 245	com/tencent/mm/plugin/sns/ui/OnlineVideoView:Aln	Lcom/tencent/mm/sdk/b/c;
    //   87: invokevirtual 816	com/tencent/mm/sdk/b/a:d	(Lcom/tencent/mm/sdk/b/c;)Z
    //   90: pop
    //   91: invokestatic 521	com/tencent/mm/plugin/sns/model/ah:dXz	()Lcom/tencent/mm/plugin/sns/model/c;
    //   94: aload_0
    //   95: getfield 242	com/tencent/mm/plugin/sns/ui/OnlineVideoView:Alm	Lcom/tencent/mm/plugin/sns/model/c$b;
    //   98: invokevirtual 819	com/tencent/mm/plugin/sns/model/c:b	(Lcom/tencent/mm/plugin/sns/model/c$b;)V
    //   101: aload_0
    //   102: invokevirtual 822	com/tencent/mm/plugin/sns/ui/OnlineVideoView:edK	()V
    //   105: aload_0
    //   106: getfield 204	com/tencent/mm/plugin/sns/ui/OnlineVideoView:oMO	Lcom/tencent/mm/sdk/platformtools/aq;
    //   109: aconst_null
    //   110: invokevirtual 826	com/tencent/mm/sdk/platformtools/aq:removeCallbacksAndMessages	(Ljava/lang/Object;)V
    //   113: aload_0
    //   114: getfield 173	com/tencent/mm/plugin/sns/ui/OnlineVideoView:AkZ	Lcom/tencent/mm/plugin/sns/ui/ak;
    //   117: ifnull +18 -> 135
    //   120: aload_0
    //   121: getfield 173	com/tencent/mm/plugin/sns/ui/OnlineVideoView:AkZ	Lcom/tencent/mm/plugin/sns/ui/ak;
    //   124: invokevirtual 829	com/tencent/mm/plugin/sns/ui/ak:eef	()Z
    //   127: pop
    //   128: aload_0
    //   129: getfield 173	com/tencent/mm/plugin/sns/ui/OnlineVideoView:AkZ	Lcom/tencent/mm/plugin/sns/ui/ak;
    //   132: invokevirtual 832	com/tencent/mm/plugin/sns/ui/ak:clear	()V
    //   135: invokestatic 838	com/tencent/mm/r/a:MW	()Lcom/tencent/mm/model/aj;
    //   138: ifnull +11 -> 149
    //   141: invokestatic 838	com/tencent/mm/r/a:MW	()Lcom/tencent/mm/model/aj;
    //   144: invokeinterface 843 1 0
    //   149: aload_0
    //   150: getfield 189	com/tencent/mm/plugin/sns/ui/OnlineVideoView:ozB	Lcom/tencent/mm/model/d;
    //   153: ifnull +12 -> 165
    //   156: aload_0
    //   157: getfield 189	com/tencent/mm/plugin/sns/ui/OnlineVideoView:ozB	Lcom/tencent/mm/model/d;
    //   160: iconst_0
    //   161: invokevirtual 849	com/tencent/mm/model/d:ez	(Z)Z
    //   164: pop
    //   165: aload_0
    //   166: aconst_null
    //   167: putfield 189	com/tencent/mm/plugin/sns/ui/OnlineVideoView:ozB	Lcom/tencent/mm/model/d;
    //   170: aload_0
    //   171: aconst_null
    //   172: putfield 169	com/tencent/mm/plugin/sns/ui/OnlineVideoView:dKe	Lcom/tencent/mm/protocal/protobuf/bzh;
    //   175: aload_0
    //   176: aconst_null
    //   177: putfield 537	com/tencent/mm/plugin/sns/ui/OnlineVideoView:dsN	Ljava/lang/String;
    //   180: aload_0
    //   181: aconst_null
    //   182: putfield 173	com/tencent/mm/plugin/sns/ui/OnlineVideoView:AkZ	Lcom/tencent/mm/plugin/sns/ui/ak;
    //   185: aload_0
    //   186: iconst_0
    //   187: putfield 181	com/tencent/mm/plugin/sns/ui/OnlineVideoView:Ald	I
    //   190: ldc_w 800
    //   193: invokestatic 405	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   196: goto -175 -> 21
    //   199: astore_1
    //   200: aload_0
    //   201: monitorexit
    //   202: aload_1
    //   203: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	204	0	this	OnlineVideoView
    //   199	4	1	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	21	199	finally
    //   24	135	199	finally
    //   135	149	199	finally
    //   149	165	199	finally
    //   165	196	199	finally
  }
  
  public final void RD(int paramInt)
  {
    AppMethodBeat.i(219728);
    if (this.AkY != null) {
      this.AkY.tx(paramInt);
    }
    AppMethodBeat.o(219728);
  }
  
  public final void a(bzh parambzh, String paramString, int paramInt)
  {
    AppMethodBeat.i(98065);
    this.dsN = paramString;
    this.icw = paramInt;
    paramString = bk.fvs();
    paramString.heF = this.icw;
    this.zul = paramString;
    if (this.dKe != parambzh)
    {
      this.dKe = parambzh;
      edS();
    }
    this.vFb = false;
    ae.i("MicroMsg.OnlineVideoView", "%d set video data[%s, %d] isPreview %b self %s", new Object[] { Integer.valueOf(hashCode()), this.dsN, Integer.valueOf(this.icw), Boolean.valueOf(this.vFb), this });
    AppMethodBeat.o(98065);
  }
  
  public final void aAo() {}
  
  public final void aAp() {}
  
  public final void aAq() {}
  
  public final void aAr() {}
  
  public final void aE(int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(219727);
    ae.i("MicroMsg.OnlineVideoView", "%d seek second %d afterSeekPlay %b", new Object[] { Integer.valueOf(hashCode()), Integer.valueOf(paramInt), Boolean.valueOf(paramBoolean) });
    this.Ald = 0;
    hideLoading();
    this.oNV.d(paramInt * 1000, paramBoolean);
    eY(false);
    AppMethodBeat.o(219727);
  }
  
  public final void aI(Activity paramActivity)
  {
    this.Alj = paramActivity;
    this.Alk = true;
  }
  
  public final void aMU()
  {
    AppMethodBeat.i(98090);
    ae.i("MicroMsg.OnlineVideoView", "%d pauseByDataBlock", new Object[] { Integer.valueOf(hashCode()) });
    edY();
    showLoading();
    cyX();
    AppMethodBeat.o(98090);
  }
  
  public final void abandonAudioFocus()
  {
    AppMethodBeat.i(98062);
    if (this.ozB != null) {
      this.ozB.ez(false);
    }
    AppMethodBeat.o(98062);
  }
  
  public final void bY(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(98087);
    ae.i("MicroMsg.OnlineVideoView", "%d prepare video isOnlinePlay %b filePath %s", new Object[] { Integer.valueOf(hashCode()), Boolean.valueOf(paramBoolean), paramString });
    if (bu.isNullOrNil(paramString))
    {
      ae.w("MicroMsg.OnlineVideoView", "%d prepare video but filepath is null.", new Object[] { Integer.valueOf(hashCode()) });
      AppMethodBeat.o(98087);
      return;
    }
    this.Ala = paramBoolean;
    String str;
    if (this.oNV != null)
    {
      if (this.Ald == -3) {
        break label316;
      }
      if ((this.oNV instanceof VideoPlayerTextureView))
      {
        ((VideoPlayerTextureView)this.oNV).setNeedResetExtractor(cyZ());
        ((VideoPlayerTextureView)this.oNV).setIsOnlineVideoType(paramBoolean);
      }
      this.oNV.setOneTimeVideoTextureUpdateCallback(this.AkS);
      ay localay = ay.aRW("TrackDataSource");
      if (this.dKe != null) {
        break label294;
      }
      str = "";
      localay.putString("media-url", str);
      if (this.dKe != null) {
        break label305;
      }
      str = "";
      label184:
      localay.putString("thumb-url", str);
      localay.putLong("prepare-ts", System.currentTimeMillis());
      localay.putString("prepare-path", paramString);
      localay.commit();
      this.oNV.setVideoPath(paramString);
      c(true, 0.0F);
    }
    for (;;)
    {
      com.tencent.mm.kernel.g.ajS();
      if (((Integer)com.tencent.mm.kernel.g.ajR().ajA().get(am.a.IQW, Integer.valueOf(0))).intValue() == 1)
      {
        this.rNj.setText(com.tencent.mm.plugin.sight.base.e.arR(paramString));
        this.rNj.setVisibility(0);
      }
      AppMethodBeat.o(98087);
      return;
      label294:
      str = this.dKe.Url;
      break;
      label305:
      str = this.dKe.Hmj;
      break label184;
      label316:
      ae.i("MicroMsg.OnlineVideoView", "%d prepare video reset source", new Object[] { Integer.valueOf(hashCode()) });
      if ((this.oNV instanceof VideoPlayerTextureView)) {
        ((VideoPlayerTextureView)this.oNV).fjh();
      }
      aE(this.Alc, true);
    }
  }
  
  public final void cyX()
  {
    AppMethodBeat.i(98078);
    if (this.oNV.isPlaying())
    {
      ae.i("MicroMsg.OnlineVideoView", "%d pause play", new Object[] { Integer.valueOf(hashCode()) });
      edY();
      eea();
      this.oNV.pause();
    }
    AppMethodBeat.o(98078);
  }
  
  public final int eU(int paramInt1, int paramInt2)
  {
    return 0;
  }
  
  protected final void eY(boolean paramBoolean)
  {
    AppMethodBeat.i(98081);
    if (this.Ala)
    {
      if (paramBoolean)
      {
        ar.f(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(219725);
            if ((OnlineVideoView.this.oNV != null) && (OnlineVideoView.this.AkZ != null))
            {
              int i = OnlineVideoView.this.oNV.getCurrentPosition() / 1000;
              OnlineVideoView.this.AkZ.ql(i);
            }
            OnlineVideoView.p(OnlineVideoView.this).ay(500L, 500L);
            AppMethodBeat.o(219725);
          }
        });
        AppMethodBeat.o(98081);
        return;
      }
      this.zYZ.ay(500L, 500L);
      AppMethodBeat.o(98081);
      return;
    }
    this.oOb.ay(500L, 500L);
    AppMethodBeat.o(98081);
  }
  
  public final void eb(int paramInt1, int paramInt2)
  {
    this.videoWidth = paramInt1;
    this.videoHeight = paramInt2;
  }
  
  public final void edK()
  {
    AppMethodBeat.i(98082);
    this.zYZ.stopTimer();
    this.oOb.stopTimer();
    AppMethodBeat.o(98082);
  }
  
  public final void edO()
  {
    this.Alg = false;
  }
  
  public final void edP()
  {
    AppMethodBeat.i(98063);
    ae.d("MicroMsg.OnlineVideoView", "%d register sns ui event", new Object[] { Integer.valueOf(hashCode()) });
    com.tencent.mm.sdk.b.a.IvT.c(this.Alo);
    AppMethodBeat.o(98063);
  }
  
  public final void edQ()
  {
    AppMethodBeat.i(98064);
    ae.d("MicroMsg.OnlineVideoView", "%d unRegister sns ui event", new Object[] { Integer.valueOf(hashCode()) });
    com.tencent.mm.sdk.b.a.IvT.d(this.Alo);
    AppMethodBeat.o(98064);
  }
  
  public final String edR()
  {
    AppMethodBeat.i(98066);
    Object localObject = new StringBuffer();
    try
    {
      if (this.dKe != null) {
        ((StringBuffer)localObject).append("media: " + this.dKe.Id);
      }
      if (this.dsN != null) {
        ((StringBuffer)localObject).append("localId: " + this.dsN);
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        ae.printErrStackTrace("MicroMsg.OnlineVideoView", localException, "", new Object[0]);
      }
    }
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(98066);
    return localObject;
  }
  
  public final void edT()
  {
    this.Alj = null;
    this.Alk = false;
  }
  
  public final boolean edV()
  {
    boolean bool = true;
    AppMethodBeat.i(98088);
    ae.i("MicroMsg.OnlineVideoView", "%d resumeByDataGain", new Object[] { Integer.valueOf(hashCode()) });
    if (!this.oNV.isPlaying())
    {
      edX();
      edZ();
      bool = this.oNV.start();
      hideLoading();
    }
    AppMethodBeat.o(98088);
    return bool;
  }
  
  public void edW()
  {
    AppMethodBeat.i(98089);
    if (!this.oNV.isPlaying())
    {
      edZ();
      int i = this.oNV.getDuration();
      int j = this.oNV.getCurrentPosition();
      if (j >= i) {
        ae.e("MicroMsg.OnlineVideoView", "the current position is more than duration, current = %d, duration = %d !!!", new Object[] { Integer.valueOf(j), Integer.valueOf(i) });
      }
      this.oNV.start();
    }
    AppMethodBeat.o(98089);
  }
  
  protected Context getActivityContext()
  {
    if (this.Alj == null) {
      return this.mContext;
    }
    return this.Alj;
  }
  
  public int getCurrentPosition()
  {
    AppMethodBeat.i(98100);
    int i = this.oNV.getCurrentPosition();
    AppMethodBeat.o(98100);
    return i;
  }
  
  public int getDuration()
  {
    AppMethodBeat.i(98077);
    if (this.oNV == null)
    {
      AppMethodBeat.o(98077);
      return 0;
    }
    int i = this.oNV.getDuration();
    AppMethodBeat.o(98077);
    return i;
  }
  
  public String getFilePath()
  {
    return this.filePath;
  }
  
  public int getPlayErrorCode()
  {
    return this.rNq;
  }
  
  public int getPlayVideoDuration()
  {
    AppMethodBeat.i(98094);
    if (this.Alq < 0) {
      this.Alq = 0;
    }
    ae.i("MicroMsg.OnlineVideoView", "%d get play video duration [%d]", new Object[] { Integer.valueOf(hashCode()), Integer.valueOf(this.Alq) });
    int i = this.Alq;
    AppMethodBeat.o(98094);
    return i;
  }
  
  public int getPlayVideoDurationByResume()
  {
    AppMethodBeat.i(98097);
    if (this.Als < 0) {
      this.Als = 0;
    }
    ae.i("MicroMsg.OnlineVideoView", "%d get play video duration by resume [%d]", new Object[] { Integer.valueOf(hashCode()), Integer.valueOf(this.Als) });
    int i = this.Als;
    AppMethodBeat.o(98097);
    return i;
  }
  
  public ak.c getRptStruct()
  {
    AppMethodBeat.i(98099);
    ak.c localc = new ak.c();
    localc.scene = this.scene;
    localc.sessionId = this.sessionId;
    localc.Alh = this.Alh;
    localc.dAg = this.dAg;
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
    return this.Alh;
  }
  
  public String getSnsId()
  {
    return this.dAg;
  }
  
  public int getUiStayTime()
  {
    if ((this.Alf > 0L) && (this.Ale > 0L)) {}
    for (int i = (int)(this.Alf - this.Ale);; i = 0)
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
    boolean bool = this.oNV.isPlaying();
    AppMethodBeat.o(98098);
    return bool;
  }
  
  public final void onCompletion()
  {
    AppMethodBeat.i(98085);
    ae.i("MicroMsg.OnlineVideoView", "%d on completion", new Object[] { Integer.valueOf(hashCode()) });
    if (this.AkY == null)
    {
      if ((com.tencent.mm.compatible.util.d.lC(18)) || (!this.rNp))
      {
        aE(0, true);
        AppMethodBeat.o(98085);
        return;
      }
      if (this.oNV != null)
      {
        String str = this.oNV.getVideoPath();
        this.oNV.stop();
        bY(str, this.Ala);
        AppMethodBeat.o(98085);
      }
    }
    else
    {
      this.AkY.onCompletion();
    }
    AppMethodBeat.o(98085);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(98070);
    ae.d("MicroMsg.OnlineVideoView", "%d on destroy %s", new Object[] { Integer.valueOf(hashCode()), bu.fpN() });
    this.Alf = bu.fpO();
    unInit();
    AppMethodBeat.o(98070);
  }
  
  public final void onError(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(98083);
    ae.e("MicroMsg.OnlineVideoView", "%d on play video error what %d extra %d. isOnlinePlay %b isMMVideoPlayer[%b]", new Object[] { Integer.valueOf(hashCode()), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Boolean.valueOf(this.Ala), Boolean.valueOf(this.rNp) });
    Object localObject;
    if (this.Ala)
    {
      com.tencent.mm.plugin.report.service.g.yxI.idkeyStat(354L, 230L, 1L, false);
      this.rNq = paramInt2;
      edY();
      localObject = this.oNV.getVideoPath();
      this.Alc = (this.oNV.getCurrentPosition() / 1000);
      if (!this.Ala) {
        break label387;
      }
      if (paramInt1 != -2) {
        break label340;
      }
      this.oNV.stop();
    }
    for (;;)
    {
      try
      {
        showLoading();
        if (this.AkZ != null)
        {
          localObject = this.AkZ;
          String str = ((ak)localObject).iuG + 0 + "_-1";
          if (!((ak)localObject).AlC.containsKey(str))
          {
            ae.i("MicroMsg.OnlineVideoViewHelper", "request all data. [%s]", new Object[] { ((ak)localObject).iuG });
            com.tencent.mm.modelvideo.o.aNi();
            com.tencent.mm.an.e.r(((ak)localObject).iuG, 0, -1);
            ((ak)localObject).AlC.put(str, Integer.valueOf(0));
            com.tencent.mm.plugin.report.service.g.yxI.idkeyStat(354L, 207L, 1L, false);
            com.tencent.mm.plugin.report.service.g.yxI.f(13836, new Object[] { Integer.valueOf(403), Long.valueOf(bu.aRi()), "" });
          }
          ((ak)localObject).iuK = 5;
          ((ak)localObject).iuP = true;
          ((ak)localObject).iuS = false;
        }
        edY();
        AppMethodBeat.o(98083);
        return;
      }
      catch (Exception localException)
      {
        label340:
        AppMethodBeat.o(98083);
        return;
      }
      com.tencent.mm.plugin.report.service.g.yxI.idkeyStat(354L, 231L, 1L, false);
      break;
      if (paramInt1 == -3)
      {
        this.Ald = paramInt1;
        this.oNV.pause();
      }
      else
      {
        edK();
        this.oNV.stop();
      }
    }
    label387:
    this.oNV.stop();
    this.rNo = true;
    c(false, 0.0F);
    ae.w("MicroMsg.OnlineVideoView", "error %s, %s", new Object[] { Boolean.valueOf(this.Alk), localException });
    if ((!bu.isNullOrNil(localException)) && (this.Alk))
    {
      ae.w("MicroMsg.OnlineVideoView", "%d start third player to play", new Object[] { Integer.valueOf(hashCode()) });
      this.oMO.post(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(219721);
          Object localObject = new Intent();
          ((Intent)localObject).setAction("android.intent.action.VIEW");
          com.tencent.mm.sdk.platformtools.o.a(OnlineVideoView.this.getContext(), (Intent)localObject, new k(localException), "video/*");
          try
          {
            Context localContext = OnlineVideoView.this.getContext();
            localObject = new com.tencent.mm.hellhoundlib.b.a().bc(localObject);
            com.tencent.mm.hellhoundlib.a.a.a(localContext, ((com.tencent.mm.hellhoundlib.b.a)localObject).ahE(), "com/tencent/mm/plugin/sns/ui/OnlineVideoView$18", "run", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            localContext.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).mt(0));
            com.tencent.mm.hellhoundlib.a.a.a(localContext, "com/tencent/mm/plugin/sns/ui/OnlineVideoView$18", "run", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            AppMethodBeat.o(219721);
            return;
          }
          catch (Exception localException)
          {
            ae.e("MicroMsg.OnlineVideoView", "startActivity fail, activity not found");
            try
            {
              f.a locala = new f.a(OnlineVideoView.this.getContext());
              locala.aZq(OnlineVideoView.this.getContext().getString(2131758931));
              locala.au(OnlineVideoView.this.getContext().getString(2131758932)).c(new f.c()
              {
                public final void d(boolean paramAnonymous2Boolean, String paramAnonymous2String) {}
              }).show();
              AppMethodBeat.o(219721);
              return;
            }
            catch (Throwable localThrowable)
            {
              ae.e("MicroMsg.OnlineVideoView", "showAlert fail");
              AppMethodBeat.o(219721);
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
    ae.d("MicroMsg.OnlineVideoView", "%d on pause %s ", new Object[] { Integer.valueOf(hashCode()), bu.fpN() });
    edK();
    if (this.oNV != null) {
      this.oNV.stop();
    }
    AppMethodBeat.o(98069);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(98068);
    ae.d("MicroMsg.OnlineVideoView", "%d on resume %s", new Object[] { Integer.valueOf(hashCode()), bu.fpN() });
    this.Ale = bu.fpO();
    if (this.Ali)
    {
      ae.e("MicroMsg.OnlineVideoView", "what are you doing guys!!! Would you like to invite everyone to eat pizza??? %s", new Object[] { bu.fpN() });
      com.tencent.mm.plugin.report.service.g.yxI.n(31L, 3L, 1L);
    }
    for (;;)
    {
      if (!this.rNo) {
        cyW();
      }
      this.AkN = true;
      AppMethodBeat.o(98068);
      return;
      if (this.AkZ == null)
      {
        this.cBE = true;
        ae.i("MicroMsg.OnlineVideoView", "%d logic init, create new helper and add listener.", new Object[] { Integer.valueOf(hashCode()) });
        this.AkZ = new ak(this);
        com.tencent.mm.sdk.b.a.IvT.c(this.zEl);
        com.tencent.mm.sdk.b.a.IvT.c(this.Aln);
        ah.dXz().a(this.Alm);
        if (this.Alg)
        {
          this.ozB = new com.tencent.mm.model.d();
          this.ozB.a(this);
        }
        if (com.tencent.mm.r.a.MW() != null) {
          com.tencent.mm.r.a.MW().WD();
        }
      }
    }
  }
  
  public void setFilePath(String paramString)
  {
    this.filePath = paramString;
  }
  
  public void setMute(boolean paramBoolean)
  {
    AppMethodBeat.i(98067);
    this.fOX = paramBoolean;
    this.oNV.setMute(this.fOX);
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
    this.Alh = paramLong;
  }
  
  public void setSnsId(String paramString)
  {
    this.dAg = paramString;
  }
  
  public void setThumbViewScaleType(ImageView.ScaleType paramScaleType)
  {
    AppMethodBeat.i(98101);
    this.rJe.setScaleType(paramScaleType);
    AppMethodBeat.o(98101);
  }
  
  public void setVideoCallback(a parama)
  {
    this.AkY = parama;
  }
  
  public void setVideoScaleType(i.e parame)
  {
    AppMethodBeat.i(98102);
    if (this.oNV != null)
    {
      if ((this.oNV instanceof VideoPlayerTextureView))
      {
        ((VideoPlayerTextureView)this.oNV).setScaleType(parame);
        AppMethodBeat.o(98102);
        return;
      }
      if ((this.oNV instanceof VideoTextureView)) {
        ((VideoTextureView)this.oNV).setScaleType(parame);
      }
    }
    AppMethodBeat.o(98102);
  }
  
  public final void ta()
  {
    AppMethodBeat.i(98084);
    ae.i("MicroMsg.OnlineVideoView", "%d onPrepared playErrorCode[%d] onErrorPlayTimeSec[%d]", new Object[] { Integer.valueOf(hashCode()), Integer.valueOf(this.rNq), Integer.valueOf(this.Alc) });
    this.rNq = 0;
    if (this.Alc > 0)
    {
      aE(this.Alc, true);
      this.Alc = 0;
      AppMethodBeat.o(98084);
      return;
    }
    this.Ald = 0;
    hideLoading();
    edX();
    edZ();
    this.oNV.start();
    this.duration = (this.oNV.getDuration() / 1000);
    ae.i("MicroMsg.OnlineVideoView", "%d start play duration %d sns local id %s ", new Object[] { Integer.valueOf(hashCode()), Integer.valueOf(this.duration), this.dsN });
    eY(false);
    if (this.AkY != null) {
      this.AkY.onStart(this.duration);
    }
    AppMethodBeat.o(98084);
  }
  
  public static abstract interface a
  {
    public abstract void onCompletion();
    
    public abstract void onStart(int paramInt);
    
    public abstract void tx(int paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.OnlineVideoView
 * JD-Core Version:    0.7.0.1
 */