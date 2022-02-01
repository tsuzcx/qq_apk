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
import com.tencent.mm.g.a.np;
import com.tencent.mm.g.a.np.a;
import com.tencent.mm.g.a.to;
import com.tencent.mm.g.a.tr;
import com.tencent.mm.g.a.tr.a;
import com.tencent.mm.g.a.uq;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.d.a;
import com.tencent.mm.modelvideo.o;
import com.tencent.mm.modelvideo.u;
import com.tencent.mm.plugin.a.j;
import com.tencent.mm.plugin.sns.model.af;
import com.tencent.mm.plugin.sns.model.an;
import com.tencent.mm.plugin.sns.model.b.b;
import com.tencent.mm.plugin.sns.model.f;
import com.tencent.mm.pluginsdk.ui.tools.VideoPlayerTextureView;
import com.tencent.mm.pluginsdk.ui.tools.VideoTextureView;
import com.tencent.mm.pluginsdk.ui.tools.h.a;
import com.tencent.mm.protocal.protobuf.btz;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ao;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.au.a;
import com.tencent.mm.sdk.platformtools.aw;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.sdk.platformtools.m;
import com.tencent.mm.storage.ae;
import com.tencent.mm.storage.bf;
import com.tencent.mm.ui.widget.MMPinProgressBtn;
import com.tencent.mm.ui.widget.a.f.a;
import com.tencent.mm.ui.widget.a.f.c;
import com.tencent.mm.vfs.i;
import java.util.HashMap;

public class OnlineVideoView
  extends RelativeLayout
  implements d.a, ah.a, h.a
{
  private volatile boolean cqf;
  private String dgl;
  private String dnn;
  private int duration;
  private btz dwE;
  private int dxk;
  private boolean dxl;
  private int dxm;
  private String filePath;
  private boolean ftN;
  private TextView gAs;
  private int hGU;
  private ProgressBar kWd;
  private Context mContext;
  com.tencent.mm.model.d nQt;
  ao ocT;
  protected com.tencent.mm.pluginsdk.ui.tools.h odZ;
  private com.tencent.mm.sdk.platformtools.au oef;
  ImageView qQT;
  private RelativeLayout qRo;
  private TextView qUK;
  private boolean qUP;
  private boolean qUQ;
  private int qUR;
  private MMPinProgressBtn qUU;
  private int scene;
  private String sessionId;
  private com.tencent.mm.plugin.o.b uIt;
  boolean uqr;
  private bf xNB;
  private c xWX;
  private int yCA;
  private int yCB;
  private long yCC;
  private long yCD;
  protected boolean yCE;
  private long yCF;
  public volatile boolean yCG;
  protected Activity yCH;
  protected boolean yCI;
  private b.b yCJ;
  private c yCK;
  private c yCL;
  private long yCM;
  private int yCN;
  private long yCO;
  private int yCP;
  private boolean yCQ;
  private boolean yCm;
  private com.tencent.mm.pluginsdk.ui.tools.h.e yCq;
  private int yCt;
  String yCu;
  private boolean yCv;
  private a yCw;
  protected ah yCx;
  private boolean yCy;
  private boolean yCz;
  private com.tencent.mm.sdk.platformtools.au yqI;
  
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
    this.yCt = 0;
    this.uqr = false;
    this.qUP = false;
    this.ftN = false;
    this.dwE = null;
    this.yCv = false;
    this.yCx = null;
    this.yCz = false;
    this.duration = 0;
    this.yCA = 0;
    this.yCB = 0;
    this.yCC = 0L;
    this.yCD = 0L;
    this.qUR = 0;
    this.nQt = null;
    this.yCE = true;
    this.ocT = new ao(Looper.getMainLooper());
    this.scene = 0;
    this.yCF = 0L;
    this.sessionId = "";
    this.dnn = "";
    this.filePath = "";
    this.cqf = false;
    this.yCG = false;
    this.yCI = false;
    this.yqI = new com.tencent.mm.sdk.platformtools.au(new au.a()
    {
      public final boolean onTimerExpired()
      {
        AppMethodBeat.i(98059);
        if ((OnlineVideoView.this.yCx == null) || (OnlineVideoView.this.odZ == null))
        {
          AppMethodBeat.o(98059);
          return false;
        }
        if (((View)OnlineVideoView.this.odZ).getAlpha() < 1.0F)
        {
          ac.i("MicroMsg.OnlineVideoView", "onlineVideoTimer switchVideoModel");
          OnlineVideoView.n(OnlineVideoView.this);
        }
        if (OnlineVideoView.this.odZ.isPlaying()) {
          OnlineVideoView.o(OnlineVideoView.this);
        }
        try
        {
          boolean bool = bs.isNullOrNil(OnlineVideoView.this.yCx.hYq);
          if (!bool) {}
          for (int i = 1; i == 0; i = 0)
          {
            AppMethodBeat.o(98059);
            return false;
          }
          i = OnlineVideoView.this.odZ.getCurrentPosition() / 1000;
          bool = OnlineVideoView.this.yCx.pG(i);
          AppMethodBeat.o(98059);
          return bool;
        }
        catch (Exception localException)
        {
          ac.e("MicroMsg.OnlineVideoView", "online video timer check error : " + localException.toString());
          AppMethodBeat.o(98059);
        }
        return false;
      }
    }, true);
    this.oef = new com.tencent.mm.sdk.platformtools.au(new au.a()
    {
      public final boolean onTimerExpired()
      {
        AppMethodBeat.i(200374);
        if (OnlineVideoView.this.odZ == null)
        {
          AppMethodBeat.o(200374);
          return false;
        }
        if (((View)OnlineVideoView.this.odZ).getAlpha() < 1.0F)
        {
          ac.i("MicroMsg.OnlineVideoView", "offlineVideoTimer switchVideoModel");
          OnlineVideoView.n(OnlineVideoView.this);
        }
        if (OnlineVideoView.this.odZ.isPlaying())
        {
          OnlineVideoView.o(OnlineVideoView.this);
          OnlineVideoView.this.odZ.getCurrentPosition();
        }
        AppMethodBeat.o(200374);
        return true;
      }
    }, true);
    this.yCJ = new b.b()
    {
      public final void atn(String paramAnonymousString) {}
      
      public final void bF(String paramAnonymousString, boolean paramAnonymousBoolean) {}
      
      public final void bG(final String paramAnonymousString, final boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(200376);
        OnlineVideoView.f(OnlineVideoView.this).postDelayed(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(200375);
            ac.i("MicroMsg.OnlineVideoView", "%d weixin download finish[%b], go to prepare video", new Object[] { Integer.valueOf(OnlineVideoView.this.hashCode()), Boolean.valueOf(paramAnonymousBoolean) });
            if ((OnlineVideoView.c(OnlineVideoView.this) != null) && (paramAnonymousBoolean) && (bs.lr(OnlineVideoView.c(OnlineVideoView.this).Id, paramAnonymousString)))
            {
              com.tencent.mm.plugin.sns.model.au.je(OnlineVideoView.a(OnlineVideoView.this), "");
              String str = com.tencent.mm.plugin.sns.model.au.a(OnlineVideoView.a(OnlineVideoView.this), OnlineVideoView.c(OnlineVideoView.this));
              if (!bs.isNullOrNil(str)) {
                OnlineVideoView.this.bN(str, false);
              }
            }
            AppMethodBeat.o(200375);
          }
        }, 100L);
        AppMethodBeat.o(200376);
      }
      
      public final void dGO() {}
    };
    this.yCK = new c() {};
    this.yCL = new c() {};
    this.xWX = new c()
    {
      private boolean a(np paramAnonymousnp)
      {
        AppMethodBeat.i(200379);
        if (OnlineVideoView.this.yCx == null)
        {
          ac.w("MicroMsg.OnlineVideoView", "%d online video helper is null.", new Object[] { Integer.valueOf(OnlineVideoView.this.hashCode()) });
          AppMethodBeat.o(200379);
          return false;
        }
        try
        {
          bool = OnlineVideoView.this.yCx.avD(paramAnonymousnp.dpX.mediaId);
          if (!bool)
          {
            AppMethodBeat.o(200379);
            return false;
          }
          if (paramAnonymousnp.dpX.retCode == -21112)
          {
            paramAnonymousnp = OnlineVideoView.this;
            com.tencent.mm.plugin.report.service.h.wUl.idkeyStat(354L, 218L, 1L, false);
            paramAnonymousnp.ocT.post(new OnlineVideoView.10(paramAnonymousnp));
            AppMethodBeat.o(200379);
            return false;
          }
          if ((paramAnonymousnp.dpX.retCode != 0) && (paramAnonymousnp.dpX.retCode != -21006))
          {
            ac.w("MicroMsg.OnlineVideoView", "%d stream download online video error. retCode %d ", new Object[] { Integer.valueOf(OnlineVideoView.this.hashCode()), Integer.valueOf(paramAnonymousnp.dpX.retCode) });
            AppMethodBeat.o(200379);
            return false;
          }
          switch (paramAnonymousnp.dpX.dgL)
          {
          }
        }
        catch (Exception paramAnonymousnp)
        {
          for (;;)
          {
            boolean bool;
            long l2;
            long l1;
            ac.e("MicroMsg.OnlineVideoView", "online video callback error: " + paramAnonymousnp.toString());
            continue;
            if (l1 > localah.frt) {}
            for (;;)
            {
              for (;;)
              {
                localah.frt = l1;
                localah.yDe = bs.eWj();
                try
                {
                  if (localah.yDa != null) {
                    break label518;
                  }
                  ac.w("MicroMsg.OnlineVideoViewHelper", "parser is null, thread is error.");
                }
                catch (Exception paramAnonymousnp)
                {
                  ac.e("MicroMsg.OnlineVideoViewHelper", "deal moov ready error: " + paramAnonymousnp.toString());
                }
              }
              break;
              l1 = localah.frt;
            }
            if (localah.yDa.F(localah.hYr, l2))
            {
              localah.hYw = localah.yDa.ixA;
              ac.i("MicroMsg.OnlineVideoViewHelper", "mp4 parse moov success. duration %d cdnMediaId %s isFastStart %b", new Object[] { Integer.valueOf(localah.hYw), localah.hYq, Boolean.valueOf(bool) });
              if (!bool) {
                ap.f(new ah.1(localah));
              }
              if (localah.hYx == -1) {}
              for (localah.hYu = 1;; localah.hYu = 2)
              {
                com.tencent.mm.plugin.report.service.h.wUl.idkeyStat(354L, 204L, 1L, false);
                break;
              }
            }
            ac.w("MicroMsg.OnlineVideoViewHelper", "mp4 parse moov error. cdnMediaId %s", new Object[] { localah.hYq });
            o.aJz();
            com.tencent.mm.an.e.p(localah.hYq, 0, -1);
            com.tencent.mm.plugin.report.service.h.wUl.idkeyStat(354L, 205L, 1L, false);
            com.tencent.mm.plugin.report.service.h.wUl.f(13836, new Object[] { Integer.valueOf(402), Long.valueOf(bs.aNx()), "" });
            continue;
            ah localah = OnlineVideoView.this.yCx;
            Object localObject = paramAnonymousnp.dpX.mediaId;
            int i = paramAnonymousnp.dpX.offset;
            int j = paramAnonymousnp.dpX.length;
            localah.hYD = false;
            if ((i < 0) || (j < 0)) {
              ac.w("MicroMsg.OnlineVideoViewHelper", "deal data available error offset[%d], length[%d]", new Object[] { Integer.valueOf(i), Integer.valueOf(j) });
            }
            while (!localah.avD((String)localObject))
            {
              if (paramAnonymousnp.dpX.length <= 0) {
                break;
              }
              OnlineVideoView.this.eT(true);
              break;
            }
            localObject = localah.hYq + i + "_" + j;
            localObject = (Integer)localah.yCZ.get(localObject);
            if ((localObject != null) && (((Integer)localObject).intValue() > 0)) {
              localah.hYA = ((Integer)localObject).intValue();
            }
            for (;;)
            {
              ac.i("MicroMsg.OnlineVideoViewHelper", "deal data available. offset[%d] length[%d] cachePlayTime[%d]", new Object[] { Integer.valueOf(i), Integer.valueOf(j), Integer.valueOf(localah.hYA) });
              break;
              try
              {
                localah.hYA = localah.yDa.dw(i, j);
              }
              catch (Exception localException)
              {
                ac.e("MicroMsg.OnlineVideoViewHelper", "deal data available file pos to video time error: " + localException.toString());
              }
            }
            OnlineVideoView.this.eT(true);
            continue;
            ac.i("MicroMsg.OnlineVideoView", "%d download finish. cdnMediaId %s sendReqCode %d favFromScene %d", new Object[] { Integer.valueOf(OnlineVideoView.this.hashCode()), paramAnonymousnp.dpX.mediaId, Integer.valueOf(OnlineVideoView.s(OnlineVideoView.this)), Integer.valueOf(OnlineVideoView.t(OnlineVideoView.this)) });
            paramAnonymousnp = OnlineVideoView.this.yCx;
            ac.i("MicroMsg.OnlineVideoViewHelper", "deal stream finish. playStatus %d cdnMediaId %s", new Object[] { Integer.valueOf(paramAnonymousnp.hYu), paramAnonymousnp.hYq });
            paramAnonymousnp.hYD = false;
            paramAnonymousnp.hYt = 3;
            com.tencent.mm.plugin.report.service.h.wUl.idkeyStat(354L, 206L, 1L, false);
            if (paramAnonymousnp.hYu == 0)
            {
              ac.w("MicroMsg.OnlineVideoViewHelper", "it had not moov callback and download finish start to play video.");
              paramAnonymousnp.dOn();
            }
            for (;;)
            {
              if (OnlineVideoView.s(OnlineVideoView.this) <= 0) {
                break label1225;
              }
              OnlineVideoView.o(OnlineVideoView.this);
              OnlineVideoView.b(OnlineVideoView.this, OnlineVideoView.s(OnlineVideoView.this));
              break;
              if (paramAnonymousnp.hYu == 5)
              {
                ac.w("MicroMsg.OnlineVideoViewHelper", "it had play error, it request all video data finish, start to play." + paramAnonymousnp.hYq);
                paramAnonymousnp.dOn();
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
              OnlineVideoView.this.eT(true);
              continue;
              if (OnlineVideoView.l(OnlineVideoView.this) == 1)
              {
                localah = OnlineVideoView.this.yCx;
                String str = paramAnonymousnp.dpX.mediaId;
                i = paramAnonymousnp.dpX.offset;
                j = paramAnonymousnp.dpX.length;
                if (localah.avD(str))
                {
                  localah.progress = i;
                  localah.hLN = j;
                  localah.yDc = (localah.progress * 100 / localah.hLN);
                  ac.i("MicroMsg.OnlineVideoViewHelper", "deal video[%s] progress callback[%d, %d]. downloadedPercent[%d]", new Object[] { localah.hYq, Integer.valueOf(localah.progress), Integer.valueOf(localah.hLN), Integer.valueOf(localah.yDc) });
                }
                if (localah.yDc >= 100) {
                  localah.hYt = 3;
                }
              }
              else if (OnlineVideoView.l(OnlineVideoView.this) == 2)
              {
                OnlineVideoView.a(OnlineVideoView.this, paramAnonymousnp.dpX.offset, paramAnonymousnp.dpX.length);
                continue;
                paramAnonymousnp = OnlineVideoView.this.yCx;
                ac.i("MicroMsg.OnlineVideoViewHelper", "deal had dup video. cdnMediaId %s", new Object[] { paramAnonymousnp.hYq });
                paramAnonymousnp.dOn();
              }
            }
          }
        }
        ac.w("MicroMsg.OnlineVideoView", "%d unknown event opcode %d", new Object[] { Integer.valueOf(OnlineVideoView.this.hashCode()), Integer.valueOf(paramAnonymousnp.dpX.dgL) });
        for (;;)
        {
          AppMethodBeat.o(200379);
          return false;
          localah = OnlineVideoView.this.yCx;
          l2 = paramAnonymousnp.dpX.offset;
          l1 = paramAnonymousnp.dpX.dpY;
          bool = paramAnonymousnp.dpX.dpZ;
          ac.i("MicroMsg.OnlineVideoViewHelper", "deal moov ready moovPos %d, timeDuration %d, cdnMediaId %s startDownload[%d %d]", new Object[] { Long.valueOf(l2), Integer.valueOf(localah.hYw), localah.hYq, Long.valueOf(l1), Long.valueOf(localah.frt) });
          if (localah.hYw == 0) {
            break;
          }
          ac.w("MicroMsg.OnlineVideoViewHelper", "moov had callback, do nothing.");
          OnlineVideoView.r(OnlineVideoView.this);
        }
      }
    };
    this.yCq = new com.tencent.mm.pluginsdk.ui.tools.h.e()
    {
      public final void bli()
      {
        AppMethodBeat.i(200381);
        ac.i("MicroMsg.OnlineVideoView", "%d on texture update.", new Object[] { Integer.valueOf(OnlineVideoView.this.hashCode()) });
        try
        {
          OnlineVideoView.n(OnlineVideoView.this);
          AppMethodBeat.o(200381);
          return;
        }
        catch (Exception localException)
        {
          ac.e("MicroMsg.OnlineVideoView", "texture view update. error " + localException.toString());
          AppMethodBeat.o(200381);
        }
      }
    };
    this.uIt = new com.tencent.mm.plugin.o.b()
    {
      public final long dcT()
      {
        AppMethodBeat.i(200382);
        ac.i("MicroMsg.OnlineVideoView", "%d sns video get online cache", new Object[] { Integer.valueOf(OnlineVideoView.this.hashCode()) });
        g.agS();
        g.agR().agA().set(com.tencent.mm.storage.ah.a.GLy, Boolean.TRUE);
        try
        {
          if ((OnlineVideoView.x(OnlineVideoView.this)) && (OnlineVideoView.this.yCx != null))
          {
            int i = OnlineVideoView.this.yCx.hYA;
            long l = i;
            AppMethodBeat.o(200382);
            return l;
          }
        }
        catch (Exception localException)
        {
          AppMethodBeat.o(200382);
        }
        return 0L;
      }
    };
    this.yCQ = true;
    this.mContext = paramContext;
    ac.i("MicroMsg.OnlineVideoView", "%d ui init view.", new Object[] { Integer.valueOf(hashCode()) });
    LayoutInflater.from(paramContext).inflate(2131495624, this);
    this.qQT = ((ImageView)findViewById(2131306398));
    this.qRo = ((RelativeLayout)findViewById(2131306392));
    this.gAs = ((TextView)findViewById(2131306332));
    this.gAs.setVisibility(8);
    this.qUU = ((MMPinProgressBtn)findViewById(2131306379));
    this.kWd = ((ProgressBar)findViewById(2131306352));
    this.qUK = ((TextView)findViewById(2131306403));
    com.tencent.mm.modelcontrol.d.aDL();
    if (com.tencent.mm.modelcontrol.d.aDX())
    {
      this.qUQ = true;
      this.odZ = new VideoPlayerTextureView(paramContext);
      ((VideoPlayerTextureView)this.odZ).setIOnlineCache(this.uIt);
      ((VideoPlayerTextureView)this.odZ).setOpenWithNoneSurface(true);
      com.tencent.mm.plugin.report.service.h.wUl.idkeyStat(354L, 148L, 1L, false);
    }
    for (;;)
    {
      this.odZ.setVideoCallback(this);
      paramContext = new RelativeLayout.LayoutParams(-1, -2);
      paramContext.addRule(13);
      this.qRo.addView((View)this.odZ, paramContext);
      ac.i("MicroMsg.OnlineVideoView", "%d switch sync video model isVideoPlay %b %f", new Object[] { Integer.valueOf(hashCode()), Boolean.FALSE, Float.valueOf(0.0F) });
      paramContext = (View)this.odZ;
      this.qRo.setVisibility(8);
      paramContext.setVisibility(8);
      if (this.yCQ) {
        this.qQT.setVisibility(0);
      }
      AppMethodBeat.o(98060);
      return;
      this.qUQ = false;
      this.odZ = new VideoTextureView(paramContext);
      com.tencent.mm.plugin.report.service.h.wUl.idkeyStat(354L, 149L, 1L, false);
    }
  }
  
  private void P(boolean paramBoolean, int paramInt)
  {
    boolean bool = true;
    AppMethodBeat.i(98076);
    if (this.dwE == null)
    {
      ac.w("MicroMsg.OnlineVideoView", "%d start download video but media is null.", new Object[] { Integer.valueOf(hashCode()) });
      AppMethodBeat.o(98076);
      return;
    }
    if (this.yCx == null)
    {
      ac.w("MicroMsg.OnlineVideoView", "%d start download video but helper is null.", new Object[] { Integer.valueOf(hashCode()) });
      AppMethodBeat.o(98076);
      return;
    }
    if (this.dwE.EUH == 2)
    {
      ac.w("MicroMsg.OnlineVideoView", "%d it start download video, url type is weixin", new Object[] { Integer.valueOf(hashCode()) });
      this.yCt = 3;
      af.dHM().a(this.dwE, 4, null, this.xNB);
      AppMethodBeat.o(98076);
      return;
    }
    int i;
    if (!paramBoolean)
    {
      com.tencent.mm.modelcontrol.d.aDL();
      if (com.tencent.mm.modelcontrol.d.aDW())
      {
        ac.i("MicroMsg.OnlineVideoView", "%d it start online download video", new Object[] { Integer.valueOf(hashCode()) });
        this.yCt = 1;
        i = paramInt;
        if (paramInt == 0) {
          i = 30;
        }
        paramBoolean = bool;
        if (this.yCx == null) {
          break label276;
        }
        this.yCx.a(this.dwE, this.hGU, this.dgl, paramBoolean, i);
        AppMethodBeat.o(98076);
        return;
      }
    }
    ac.i("MicroMsg.OnlineVideoView", "%d it start offline download video", new Object[] { Integer.valueOf(hashCode()) });
    this.yCt = 2;
    if (paramInt != 0) {}
    for (;;)
    {
      paramBoolean = false;
      i = paramInt;
      break;
      paramInt = 31;
    }
    label276:
    ac.w("MicroMsg.OnlineVideoView", "onlineVideoHelper is null!!!");
    AppMethodBeat.o(98076);
  }
  
  private void Pp(int paramInt)
  {
    AppMethodBeat.i(98071);
    String str = an.jc(af.getAccSnsPath(), this.dwE.Id) + com.tencent.mm.plugin.sns.data.q.d(this.dwE);
    Intent localIntent = new Intent();
    localIntent.putExtra("Select_Conv_Type", 3);
    localIntent.putExtra("select_is_ret", true);
    localIntent.putExtra("mutil_select_is_ret", true);
    localIntent.putExtra("image_path", str);
    localIntent.putExtra("Retr_Msg_Type", 11);
    ac.i("MicroMsg.OnlineVideoView", "send video path %s reqCode %d", new Object[] { str, Integer.valueOf(paramInt) });
    com.tencent.mm.br.d.c(getActivityContext(), ".ui.transmit.SelectConversationUI", localIntent, paramInt);
    this.dxm = 0;
    AppMethodBeat.o(98071);
  }
  
  private void ay(final int paramInt, final boolean paramBoolean)
  {
    AppMethodBeat.i(98072);
    this.ocT.post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(98040);
        Object localObject1 = af.dHR().auT(OnlineVideoView.a(OnlineVideoView.this));
        if (localObject1 == null)
        {
          AppMethodBeat.o(98040);
          return;
        }
        ac.i("MicroMsg.OnlineVideoView", "fav download video[%s] farFromScene %d isFromMain %b", new Object[] { OnlineVideoView.a(OnlineVideoView.this), Integer.valueOf(paramInt), Boolean.valueOf(paramBoolean) });
        Object localObject2 = new cs();
        ((cs)localObject2).dck.dcq = paramInt;
        ((cs)localObject2).dck.activity = ((Activity)OnlineVideoView.this.getActivityContext());
        com.tencent.mm.plugin.sns.k.a.a((cs)localObject2, (com.tencent.mm.plugin.sns.storage.p)localObject1);
        com.tencent.mm.sdk.b.a.GpY.l((com.tencent.mm.sdk.b.b)localObject2);
        if (((cs)localObject2).dcl.ret == 0) {
          OnlineVideoView.dOh();
        }
        for (;;)
        {
          if (paramBoolean)
          {
            localObject2 = new to();
            ((to)localObject2).dwt.ddB = ((com.tencent.mm.plugin.sns.storage.p)localObject1).dMu();
            ((to)localObject2).dwt.dnn = com.tencent.mm.plugin.sns.data.q.l((com.tencent.mm.plugin.sns.storage.p)localObject1);
            com.tencent.mm.sdk.b.a.GpY.l((com.tencent.mm.sdk.b.b)localObject2);
          }
          OnlineVideoView.b(OnlineVideoView.this);
          if (OnlineVideoView.this.odZ == null) {
            break label318;
          }
          if (!bs.isNullOrNil(OnlineVideoView.this.odZ.getVideoPath())) {
            break;
          }
          ac.i("MicroMsg.OnlineVideoView", "%d had not set video path to play", new Object[] { Integer.valueOf(OnlineVideoView.this.hashCode()) });
          localObject1 = com.tencent.mm.plugin.sns.model.au.a(OnlineVideoView.a(OnlineVideoView.this), OnlineVideoView.c(OnlineVideoView.this));
          if (!bs.isNullOrNil((String)localObject1)) {
            OnlineVideoView.this.bN((String)localObject1, false);
          }
          AppMethodBeat.o(98040);
          return;
          OnlineVideoView.dOi();
        }
        if (!OnlineVideoView.this.odZ.isPlaying())
        {
          OnlineVideoView.this.odZ.start();
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
    this.ocT.post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(98054);
        ac.i("MicroMsg.OnlineVideoView", "%d switch video model isVideoPlay %b %f", new Object[] { Integer.valueOf(OnlineVideoView.this.hashCode()), Boolean.valueOf(paramBoolean), Float.valueOf(paramFloat) });
        View localView = (View)OnlineVideoView.this.odZ;
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
  
  private void crJ()
  {
    AppMethodBeat.i(98075);
    if (!this.uqr) {}
    for (String str = com.tencent.mm.plugin.sns.model.au.a(this.dgl, this.dwE);; str = this.yCu)
    {
      ac.i("MicroMsg.OnlineVideoView", "%d toggleVideo local id %s finish path %s isPreview %b", new Object[] { Integer.valueOf(hashCode()), this.dgl, str, Boolean.valueOf(this.uqr) });
      if (bs.isNullOrNil(str)) {
        break;
      }
      ac.i("MicroMsg.OnlineVideoView", "%d sns video already download finish, play now", new Object[] { Integer.valueOf(hashCode()) });
      c(true, 0.0F);
      bN(str, false);
      AppMethodBeat.o(98075);
      return;
    }
    c(false, 0.0F);
    P(false, 0);
    showLoading();
    AppMethodBeat.o(98075);
  }
  
  private boolean crM()
  {
    AppMethodBeat.i(98086);
    if (!this.yCy)
    {
      AppMethodBeat.o(98086);
      return false;
    }
    g.agS();
    boolean bool = g.agR().agA().getBoolean(com.tencent.mm.storage.ah.a.GLy, false);
    AppMethodBeat.o(98086);
    return bool;
  }
  
  private void dOa()
  {
    AppMethodBeat.i(98073);
    com.tencent.mm.platformtools.p.a(getContext(), new Runnable()new Runnable
    {
      public final void run()
      {
        AppMethodBeat.i(98052);
        long l = bs.Gn();
        String str1 = com.tencent.mm.plugin.sns.model.au.a(OnlineVideoView.a(OnlineVideoView.this), OnlineVideoView.c(OnlineVideoView.this));
        String str2 = u.Ek(str1);
        if (bs.isNullOrNil(str2))
        {
          Toast.makeText(OnlineVideoView.d(OnlineVideoView.this), OnlineVideoView.d(OnlineVideoView.this).getString(2131764682), 1).show();
          OnlineVideoView.dOj();
        }
        for (;;)
        {
          OnlineVideoView.e(OnlineVideoView.this);
          ac.i("MicroMsg.OnlineVideoView", "%d save downloaded video finish %d %s", new Object[] { Integer.valueOf(hashCode()), Long.valueOf(bs.aO(l)), str1 });
          OnlineVideoView.f(OnlineVideoView.this).post(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(200384);
              if (OnlineVideoView.this.odZ != null)
              {
                if (bs.isNullOrNil(OnlineVideoView.this.odZ.getVideoPath()))
                {
                  ac.i("MicroMsg.OnlineVideoView", "%d had not set video path to play", new Object[] { Integer.valueOf(OnlineVideoView.this.hashCode()) });
                  String str = com.tencent.mm.plugin.sns.model.au.a(OnlineVideoView.a(OnlineVideoView.this), OnlineVideoView.c(OnlineVideoView.this));
                  if (!bs.isNullOrNil(str)) {
                    OnlineVideoView.this.bN(str, false);
                  }
                  AppMethodBeat.o(200384);
                  return;
                }
                if (!OnlineVideoView.this.odZ.isPlaying())
                {
                  OnlineVideoView.this.odZ.start();
                  AppMethodBeat.o(200384);
                  return;
                }
              }
              AppMethodBeat.o(200384);
            }
          });
          AppMethodBeat.o(98052);
          return;
          Toast.makeText(OnlineVideoView.d(OnlineVideoView.this), OnlineVideoView.d(OnlineVideoView.this).getString(2131764683, new Object[] { com.tencent.mm.sdk.f.b.aLU(str2) }), 1).show();
          com.tencent.mm.sdk.f.b.k(str2, OnlineVideoView.d(OnlineVideoView.this));
          OnlineVideoView.dOk();
        }
      }
    }, new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(98053);
        Toast.makeText(OnlineVideoView.d(OnlineVideoView.this), OnlineVideoView.d(OnlineVideoView.this).getString(2131764682), 1).show();
        OnlineVideoView.dOj();
        AppMethodBeat.o(98053);
      }
    });
    AppMethodBeat.o(98073);
  }
  
  private void dOd()
  {
    AppMethodBeat.i(98092);
    this.yCM = bs.eWj();
    ac.d("MicroMsg.OnlineVideoView", "%d notePlayVideo notePlayVideo %d ", new Object[] { Integer.valueOf(hashCode()), Long.valueOf(this.yCM) });
    AppMethodBeat.o(98092);
  }
  
  private void dOe()
  {
    AppMethodBeat.i(98093);
    if (this.yCM > 0L) {
      this.yCN = ((int)(this.yCN + (bs.eWj() - this.yCM) / 1000L));
    }
    ac.i("MicroMsg.OnlineVideoView", "%d notePauseVideo playVideoDuration %d ", new Object[] { Integer.valueOf(hashCode()), Integer.valueOf(this.yCN) });
    this.yCM = 0L;
    AppMethodBeat.o(98093);
  }
  
  private void dOf()
  {
    AppMethodBeat.i(98095);
    this.yCO = bs.eWj();
    ac.d("MicroMsg.OnlineVideoView", "%d noteResumeVideo noteResumeVideo %d ", new Object[] { Integer.valueOf(hashCode()), Long.valueOf(this.yCO) });
    AppMethodBeat.o(98095);
  }
  
  private void dOg()
  {
    AppMethodBeat.i(98096);
    if (this.yCO > 0L)
    {
      this.yCP = 0;
      this.yCP = ((int)(this.yCP + (bs.eWj() - this.yCO) / 1000L));
    }
    ac.i("MicroMsg.OnlineVideoView", "%d notePauseVideoByResume playVideoDuration %d ", new Object[] { Integer.valueOf(hashCode()), Integer.valueOf(this.yCP) });
    this.yCO = 0L;
    AppMethodBeat.o(98096);
  }
  
  private void hideLoading()
  {
    AppMethodBeat.i(98080);
    this.ocT.post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(98057);
        if ((OnlineVideoView.j(OnlineVideoView.this) != null) && (OnlineVideoView.j(OnlineVideoView.this).getVisibility() != 8))
        {
          ac.i("MicroMsg.OnlineVideoView", "%d hide loading.", new Object[] { Integer.valueOf(OnlineVideoView.this.hashCode()) });
          OnlineVideoView.j(OnlineVideoView.this).setVisibility(8);
        }
        if ((OnlineVideoView.k(OnlineVideoView.this) != null) && (OnlineVideoView.k(OnlineVideoView.this).getVisibility() != 8))
        {
          ac.i("MicroMsg.OnlineVideoView", "%d hide progress.", new Object[] { Integer.valueOf(OnlineVideoView.this.hashCode()) });
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
    this.ocT.post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(98056);
        ac.i("MicroMsg.OnlineVideoView", "%d show loading. downloadMode %d", new Object[] { Integer.valueOf(OnlineVideoView.this.hashCode()), Integer.valueOf(OnlineVideoView.l(OnlineVideoView.this)) });
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
            OnlineVideoView.k(OnlineVideoView.this).fuE();
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
  
  /* Error */
  private void unInit()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: ldc_w 749
    //   5: invokestatic 155	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   8: aload_0
    //   9: getfield 214	com/tencent/mm/plugin/sns/ui/OnlineVideoView:cqf	Z
    //   12: ifne +12 -> 24
    //   15: ldc_w 749
    //   18: invokestatic 397	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   21: aload_0
    //   22: monitorexit
    //   23: return
    //   24: aload_0
    //   25: iconst_0
    //   26: putfield 214	com/tencent/mm/plugin/sns/ui/OnlineVideoView:cqf	Z
    //   29: ldc 255
    //   31: ldc_w 751
    //   34: iconst_1
    //   35: anewarray 259	java/lang/Object
    //   38: dup
    //   39: iconst_0
    //   40: aload_0
    //   41: invokevirtual 263	java/lang/Object:hashCode	()I
    //   44: invokestatic 269	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   47: aastore
    //   48: invokestatic 274	com/tencent/mm/sdk/platformtools/ac:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   51: aload_0
    //   52: invokespecial 753	com/tencent/mm/plugin/sns/ui/OnlineVideoView:dOe	()V
    //   55: aload_0
    //   56: invokespecial 755	com/tencent/mm/plugin/sns/ui/OnlineVideoView:dOg	()V
    //   59: aload_0
    //   60: getfield 336	com/tencent/mm/plugin/sns/ui/OnlineVideoView:odZ	Lcom/tencent/mm/pluginsdk/ui/tools/h;
    //   63: invokeinterface 758 1 0
    //   68: getstatic 764	com/tencent/mm/sdk/b/a:GpY	Lcom/tencent/mm/sdk/b/a;
    //   71: aload_0
    //   72: getfield 243	com/tencent/mm/plugin/sns/ui/OnlineVideoView:xWX	Lcom/tencent/mm/sdk/b/c;
    //   75: invokevirtual 767	com/tencent/mm/sdk/b/a:d	(Lcom/tencent/mm/sdk/b/c;)Z
    //   78: pop
    //   79: getstatic 764	com/tencent/mm/sdk/b/a:GpY	Lcom/tencent/mm/sdk/b/a;
    //   82: aload_0
    //   83: getfield 237	com/tencent/mm/plugin/sns/ui/OnlineVideoView:yCK	Lcom/tencent/mm/sdk/b/c;
    //   86: invokevirtual 767	com/tencent/mm/sdk/b/a:d	(Lcom/tencent/mm/sdk/b/c;)Z
    //   89: pop
    //   90: invokestatic 431	com/tencent/mm/plugin/sns/model/af:dHM	()Lcom/tencent/mm/plugin/sns/model/b;
    //   93: aload_0
    //   94: getfield 234	com/tencent/mm/plugin/sns/ui/OnlineVideoView:yCJ	Lcom/tencent/mm/plugin/sns/model/b$b;
    //   97: invokevirtual 770	com/tencent/mm/plugin/sns/model/b:b	(Lcom/tencent/mm/plugin/sns/model/b$b;)V
    //   100: aload_0
    //   101: invokevirtual 773	com/tencent/mm/plugin/sns/ui/OnlineVideoView:dNR	()V
    //   104: aload_0
    //   105: getfield 200	com/tencent/mm/plugin/sns/ui/OnlineVideoView:ocT	Lcom/tencent/mm/sdk/platformtools/ao;
    //   108: aconst_null
    //   109: invokevirtual 777	com/tencent/mm/sdk/platformtools/ao:removeCallbacksAndMessages	(Ljava/lang/Object;)V
    //   112: aload_0
    //   113: getfield 169	com/tencent/mm/plugin/sns/ui/OnlineVideoView:yCx	Lcom/tencent/mm/plugin/sns/ui/ah;
    //   116: ifnull +18 -> 134
    //   119: aload_0
    //   120: getfield 169	com/tencent/mm/plugin/sns/ui/OnlineVideoView:yCx	Lcom/tencent/mm/plugin/sns/ui/ah;
    //   123: invokevirtual 780	com/tencent/mm/plugin/sns/ui/ah:dOl	()Z
    //   126: pop
    //   127: aload_0
    //   128: getfield 169	com/tencent/mm/plugin/sns/ui/OnlineVideoView:yCx	Lcom/tencent/mm/plugin/sns/ui/ah;
    //   131: invokevirtual 783	com/tencent/mm/plugin/sns/ui/ah:clear	()V
    //   134: invokestatic 789	com/tencent/mm/r/a:Lt	()Lcom/tencent/mm/model/ah;
    //   137: ifnull +11 -> 148
    //   140: invokestatic 789	com/tencent/mm/r/a:Lt	()Lcom/tencent/mm/model/ah;
    //   143: invokeinterface 794 1 0
    //   148: aload_0
    //   149: getfield 185	com/tencent/mm/plugin/sns/ui/OnlineVideoView:nQt	Lcom/tencent/mm/model/d;
    //   152: ifnull +12 -> 164
    //   155: aload_0
    //   156: getfield 185	com/tencent/mm/plugin/sns/ui/OnlineVideoView:nQt	Lcom/tencent/mm/model/d;
    //   159: iconst_0
    //   160: invokevirtual 800	com/tencent/mm/model/d:ev	(Z)Z
    //   163: pop
    //   164: aload_0
    //   165: aconst_null
    //   166: putfield 185	com/tencent/mm/plugin/sns/ui/OnlineVideoView:nQt	Lcom/tencent/mm/model/d;
    //   169: aload_0
    //   170: aconst_null
    //   171: putfield 165	com/tencent/mm/plugin/sns/ui/OnlineVideoView:dwE	Lcom/tencent/mm/protocal/protobuf/btz;
    //   174: aload_0
    //   175: aconst_null
    //   176: putfield 447	com/tencent/mm/plugin/sns/ui/OnlineVideoView:dgl	Ljava/lang/String;
    //   179: aload_0
    //   180: aconst_null
    //   181: putfield 169	com/tencent/mm/plugin/sns/ui/OnlineVideoView:yCx	Lcom/tencent/mm/plugin/sns/ui/ah;
    //   184: aload_0
    //   185: iconst_0
    //   186: putfield 177	com/tencent/mm/plugin/sns/ui/OnlineVideoView:yCB	I
    //   189: ldc_w 749
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
  
  public final void IE(int paramInt)
  {
    AppMethodBeat.i(98091);
    ac.i("MicroMsg.OnlineVideoView", "%d seek second %d afterSeekPlay %b", new Object[] { Integer.valueOf(hashCode()), Integer.valueOf(paramInt), Boolean.TRUE });
    this.yCB = 0;
    hideLoading();
    this.odZ.d(paramInt * 1000, true);
    eT(false);
    AppMethodBeat.o(98091);
  }
  
  public final void a(btz parambtz, String paramString, int paramInt)
  {
    AppMethodBeat.i(98065);
    this.dgl = paramString;
    this.hGU = paramInt;
    paramString = bf.fbp();
    paramString.gIh = this.hGU;
    this.xNB = paramString;
    if (this.dwE != parambtz)
    {
      this.dwE = parambtz;
      boolean bool = af.dHO().b(this.dwE, this.qQT, 2131231318, this.mContext.hashCode(), this.xNB);
      ac.i("MicroMsg.OnlineVideoView", "%d fresh thumb image %b", new Object[] { Integer.valueOf(hashCode()), Boolean.valueOf(bool) });
    }
    this.uqr = false;
    ac.i("MicroMsg.OnlineVideoView", "%d set video data[%s, %d] isPreview %b self %s", new Object[] { Integer.valueOf(hashCode()), this.dgl, Integer.valueOf(this.hGU), Boolean.valueOf(this.uqr), this });
    AppMethodBeat.o(98065);
  }
  
  public final void aH(Activity paramActivity)
  {
    this.yCH = paramActivity;
    this.yCI = true;
  }
  
  public final void aJm()
  {
    AppMethodBeat.i(98090);
    ac.i("MicroMsg.OnlineVideoView", "%d pauseByDataBlock", new Object[] { Integer.valueOf(hashCode()) });
    dOe();
    showLoading();
    crK();
    AppMethodBeat.o(98090);
  }
  
  public final void abandonAudioFocus()
  {
    AppMethodBeat.i(98062);
    if (this.nQt != null) {
      this.nQt.ev(false);
    }
    AppMethodBeat.o(98062);
  }
  
  public final void axj() {}
  
  public final void axk() {}
  
  public final void axl() {}
  
  public final void axm() {}
  
  public final void bN(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(98087);
    ac.i("MicroMsg.OnlineVideoView", "%d prepare video isOnlinePlay %b filePath %s", new Object[] { Integer.valueOf(hashCode()), Boolean.valueOf(paramBoolean), paramString });
    if (bs.isNullOrNil(paramString))
    {
      ac.w("MicroMsg.OnlineVideoView", "%d prepare video but filepath is null.", new Object[] { Integer.valueOf(hashCode()) });
      AppMethodBeat.o(98087);
      return;
    }
    this.yCy = paramBoolean;
    String str;
    if (this.odZ != null)
    {
      if (this.yCB == -3) {
        break label314;
      }
      if ((this.odZ instanceof VideoPlayerTextureView))
      {
        ((VideoPlayerTextureView)this.odZ).setNeedResetExtractor(crM());
        ((VideoPlayerTextureView)this.odZ).setIsOnlineVideoType(paramBoolean);
      }
      this.odZ.setOneTimeVideoTextureUpdateCallback(this.yCq);
      aw localaw = aw.aKT("TrackDataSource");
      if (this.dwE != null) {
        break label292;
      }
      str = "";
      localaw.putString("media-url", str);
      if (this.dwE != null) {
        break label303;
      }
      str = "";
      label182:
      localaw.putString("thumb-url", str);
      localaw.putLong("prepare-ts", System.currentTimeMillis());
      localaw.putString("prepare-path", paramString);
      localaw.commit();
      this.odZ.setVideoPath(paramString);
      c(true, 0.0F);
    }
    for (;;)
    {
      g.agS();
      if (((Integer)g.agR().agA().get(com.tencent.mm.storage.ah.a.GKg, Integer.valueOf(0))).intValue() == 1)
      {
        this.qUK.setText(com.tencent.mm.plugin.sight.base.e.alX(paramString));
        this.qUK.setVisibility(0);
      }
      AppMethodBeat.o(98087);
      return;
      label292:
      str = this.dwE.Url;
      break;
      label303:
      str = this.dwE.Fjh;
      break label182;
      label314:
      ac.i("MicroMsg.OnlineVideoView", "%d prepare video reset source", new Object[] { Integer.valueOf(hashCode()) });
      if ((this.odZ instanceof VideoPlayerTextureView)) {
        ((VideoPlayerTextureView)this.odZ).eQp();
      }
      IE(this.yCA);
    }
  }
  
  public final void crK()
  {
    AppMethodBeat.i(98078);
    if (this.odZ.isPlaying())
    {
      ac.i("MicroMsg.OnlineVideoView", "%d pause play", new Object[] { Integer.valueOf(hashCode()) });
      dOe();
      dOg();
      this.odZ.pause();
    }
    AppMethodBeat.o(98078);
  }
  
  public final void dNR()
  {
    AppMethodBeat.i(98082);
    this.yqI.stopTimer();
    this.oef.stopTimer();
    AppMethodBeat.o(98082);
  }
  
  public final void dNV()
  {
    this.yCE = false;
  }
  
  public final void dNW()
  {
    AppMethodBeat.i(98063);
    ac.d("MicroMsg.OnlineVideoView", "%d register sns ui event", new Object[] { Integer.valueOf(hashCode()) });
    com.tencent.mm.sdk.b.a.GpY.c(this.yCL);
    AppMethodBeat.o(98063);
  }
  
  public final void dNX()
  {
    AppMethodBeat.i(98064);
    ac.d("MicroMsg.OnlineVideoView", "%d unRegister sns ui event", new Object[] { Integer.valueOf(hashCode()) });
    com.tencent.mm.sdk.b.a.GpY.d(this.yCL);
    AppMethodBeat.o(98064);
  }
  
  public final String dNY()
  {
    AppMethodBeat.i(98066);
    Object localObject = new StringBuffer();
    try
    {
      if (this.dwE != null) {
        ((StringBuffer)localObject).append("media: " + this.dwE.Id);
      }
      if (this.dgl != null) {
        ((StringBuffer)localObject).append("localId: " + this.dgl);
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        ac.printErrStackTrace("MicroMsg.OnlineVideoView", localException, "", new Object[0]);
      }
    }
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(98066);
    return localObject;
  }
  
  public final void dNZ()
  {
    this.yCH = null;
    this.yCI = false;
  }
  
  public final boolean dOb()
  {
    boolean bool = true;
    AppMethodBeat.i(98088);
    ac.i("MicroMsg.OnlineVideoView", "%d resumeByDataGain", new Object[] { Integer.valueOf(hashCode()) });
    if (!this.odZ.isPlaying())
    {
      dOd();
      dOf();
      bool = this.odZ.start();
      hideLoading();
    }
    AppMethodBeat.o(98088);
    return bool;
  }
  
  public void dOc()
  {
    AppMethodBeat.i(98089);
    if (!this.odZ.isPlaying())
    {
      dOf();
      this.odZ.start();
    }
    AppMethodBeat.o(98089);
  }
  
  public final void dZ(int paramInt1, int paramInt2) {}
  
  public final int eP(int paramInt1, int paramInt2)
  {
    return 0;
  }
  
  protected final void eT(boolean paramBoolean)
  {
    AppMethodBeat.i(98081);
    if (this.yCy)
    {
      if (paramBoolean)
      {
        ap.f(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(200385);
            if ((OnlineVideoView.this.odZ != null) && (OnlineVideoView.this.yCx != null))
            {
              int i = OnlineVideoView.this.odZ.getCurrentPosition() / 1000;
              OnlineVideoView.this.yCx.pG(i);
            }
            OnlineVideoView.m(OnlineVideoView.this).au(500L, 500L);
            AppMethodBeat.o(200385);
          }
        });
        AppMethodBeat.o(98081);
        return;
      }
      this.yqI.au(500L, 500L);
      AppMethodBeat.o(98081);
      return;
    }
    this.oef.au(500L, 500L);
    AppMethodBeat.o(98081);
  }
  
  protected Context getActivityContext()
  {
    if (this.yCH == null) {
      return this.mContext;
    }
    return this.yCH;
  }
  
  public int getCurrentPosition()
  {
    AppMethodBeat.i(98100);
    int i = this.odZ.getCurrentPosition();
    AppMethodBeat.o(98100);
    return i;
  }
  
  public int getDuration()
  {
    AppMethodBeat.i(98077);
    if (this.odZ == null)
    {
      AppMethodBeat.o(98077);
      return 0;
    }
    int i = this.odZ.getDuration();
    AppMethodBeat.o(98077);
    return i;
  }
  
  public String getFilePath()
  {
    return this.filePath;
  }
  
  public int getPlayErrorCode()
  {
    return this.qUR;
  }
  
  public int getPlayVideoDuration()
  {
    AppMethodBeat.i(98094);
    if (this.yCN < 0) {
      this.yCN = 0;
    }
    ac.i("MicroMsg.OnlineVideoView", "%d get play video duration [%d]", new Object[] { Integer.valueOf(hashCode()), Integer.valueOf(this.yCN) });
    int i = this.yCN;
    AppMethodBeat.o(98094);
    return i;
  }
  
  public int getPlayVideoDurationByResume()
  {
    AppMethodBeat.i(98097);
    if (this.yCP < 0) {
      this.yCP = 0;
    }
    ac.i("MicroMsg.OnlineVideoView", "%d get play video duration by resume [%d]", new Object[] { Integer.valueOf(hashCode()), Integer.valueOf(this.yCP) });
    int i = this.yCP;
    AppMethodBeat.o(98097);
    return i;
  }
  
  public ah.c getRptStruct()
  {
    AppMethodBeat.i(98099);
    ah.c localc = new ah.c();
    localc.scene = this.scene;
    localc.sessionId = this.sessionId;
    localc.yCF = this.yCF;
    localc.dnn = this.dnn;
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
    return this.yCF;
  }
  
  public String getSnsId()
  {
    return this.dnn;
  }
  
  public int getUiStayTime()
  {
    if ((this.yCD > 0L) && (this.yCC > 0L)) {}
    for (int i = (int)(this.yCD - this.yCC);; i = 0)
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
    boolean bool = this.odZ.isPlaying();
    AppMethodBeat.o(98098);
    return bool;
  }
  
  public final void onCompletion()
  {
    AppMethodBeat.i(98085);
    ac.i("MicroMsg.OnlineVideoView", "%d on completion", new Object[] { Integer.valueOf(hashCode()) });
    if (this.yCw == null)
    {
      if ((com.tencent.mm.compatible.util.d.lb(18)) || (!this.qUQ))
      {
        IE(0);
        AppMethodBeat.o(98085);
        return;
      }
      if (this.odZ != null)
      {
        String str = this.odZ.getVideoPath();
        this.odZ.stop();
        bN(str, this.yCy);
      }
    }
    AppMethodBeat.o(98085);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(98070);
    ac.d("MicroMsg.OnlineVideoView", "%d on destroy %s", new Object[] { Integer.valueOf(hashCode()), bs.eWi() });
    this.yCD = bs.eWj();
    unInit();
    AppMethodBeat.o(98070);
  }
  
  public final void onError(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(98083);
    ac.e("MicroMsg.OnlineVideoView", "%d on play video error what %d extra %d. isOnlinePlay %b isMMVideoPlayer[%b]", new Object[] { Integer.valueOf(hashCode()), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Boolean.valueOf(this.yCy), Boolean.valueOf(this.qUQ) });
    Object localObject;
    if (this.yCy)
    {
      com.tencent.mm.plugin.report.service.h.wUl.idkeyStat(354L, 230L, 1L, false);
      this.qUR = paramInt2;
      dOe();
      localObject = this.odZ.getVideoPath();
      this.yCA = (this.odZ.getCurrentPosition() / 1000);
      if (!this.yCy) {
        break label386;
      }
      if (paramInt1 != -2) {
        break label339;
      }
      this.odZ.stop();
    }
    for (;;)
    {
      try
      {
        showLoading();
        if (this.yCx != null)
        {
          localObject = this.yCx;
          String str = ((ah)localObject).hYq + 0 + "_-1";
          if (!((ah)localObject).yCZ.containsKey(str))
          {
            ac.i("MicroMsg.OnlineVideoViewHelper", "request all data. [%s]", new Object[] { ((ah)localObject).hYq });
            o.aJz();
            com.tencent.mm.an.e.p(((ah)localObject).hYq, 0, -1);
            ((ah)localObject).yCZ.put(str, Integer.valueOf(0));
            com.tencent.mm.plugin.report.service.h.wUl.idkeyStat(354L, 207L, 1L, false);
            com.tencent.mm.plugin.report.service.h.wUl.f(13836, new Object[] { Integer.valueOf(403), Long.valueOf(bs.aNx()), "" });
          }
          ((ah)localObject).hYu = 5;
          ((ah)localObject).hYz = true;
          ((ah)localObject).hYC = false;
        }
        dOe();
        AppMethodBeat.o(98083);
        return;
      }
      catch (Exception localException)
      {
        label339:
        AppMethodBeat.o(98083);
        return;
      }
      com.tencent.mm.plugin.report.service.h.wUl.idkeyStat(354L, 231L, 1L, false);
      break;
      if (paramInt1 == -3)
      {
        this.yCB = paramInt1;
        this.odZ.pause();
      }
      else
      {
        dNR();
        this.odZ.stop();
      }
    }
    label386:
    this.odZ.stop();
    this.qUP = true;
    c(false, 0.0F);
    ac.w("MicroMsg.OnlineVideoView", "error %s, %s", new Object[] { Boolean.valueOf(this.yCI), localException });
    if ((!bs.isNullOrNil(localException)) && (this.yCI))
    {
      ac.w("MicroMsg.OnlineVideoView", "%d start third player to play", new Object[] { Integer.valueOf(hashCode()) });
      this.ocT.post(new Runnable()
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
            localObject = new com.tencent.mm.hellhoundlib.b.a().ba(localObject);
            com.tencent.mm.hellhoundlib.a.a.a(localContext, ((com.tencent.mm.hellhoundlib.b.a)localObject).aeD(), "com/tencent/mm/plugin/sns/ui/OnlineVideoView$17", "run", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            localContext.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).lR(0));
            com.tencent.mm.hellhoundlib.a.a.a(localContext, "com/tencent/mm/plugin/sns/ui/OnlineVideoView$17", "run", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            AppMethodBeat.o(98051);
            return;
          }
          catch (Exception localException)
          {
            ac.e("MicroMsg.OnlineVideoView", "startActivity fail, activity not found");
            try
            {
              f.a locala = new f.a(OnlineVideoView.this.getContext());
              locala.aRQ(OnlineVideoView.this.getContext().getString(2131758931));
              locala.av(OnlineVideoView.this.getContext().getString(2131758932)).c(new f.c()
              {
                public final void d(boolean paramAnonymous2Boolean, String paramAnonymous2String) {}
              }).show();
              AppMethodBeat.o(98051);
              return;
            }
            catch (Throwable localThrowable)
            {
              ac.e("MicroMsg.OnlineVideoView", "showAlert fail");
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
    ac.d("MicroMsg.OnlineVideoView", "%d on pause %s ", new Object[] { Integer.valueOf(hashCode()), bs.eWi() });
    dNR();
    if (this.odZ != null) {
      this.odZ.stop();
    }
    AppMethodBeat.o(98069);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(98068);
    ac.d("MicroMsg.OnlineVideoView", "%d on resume %s", new Object[] { Integer.valueOf(hashCode()), bs.eWi() });
    this.yCC = bs.eWj();
    if (this.yCG)
    {
      ac.e("MicroMsg.OnlineVideoView", "what are you doing guys!!! Would you like to invite everyone to eat pizza??? %s", new Object[] { bs.eWi() });
      com.tencent.mm.plugin.report.service.h.wUl.n(31L, 3L, 1L);
    }
    for (;;)
    {
      if (!this.qUP) {
        crJ();
      }
      this.yCm = true;
      AppMethodBeat.o(98068);
      return;
      if (this.yCx == null)
      {
        this.cqf = true;
        ac.i("MicroMsg.OnlineVideoView", "%d logic init, create new helper and add listener.", new Object[] { Integer.valueOf(hashCode()) });
        this.yCx = new ah(this);
        com.tencent.mm.sdk.b.a.GpY.c(this.xWX);
        com.tencent.mm.sdk.b.a.GpY.c(this.yCK);
        af.dHM().a(this.yCJ);
        if (this.yCE)
        {
          this.nQt = new com.tencent.mm.model.d();
          this.nQt.a(this);
        }
        if (com.tencent.mm.r.a.Lt() != null) {
          com.tencent.mm.r.a.Lt().Ue();
        }
      }
    }
  }
  
  public final void rB()
  {
    AppMethodBeat.i(98084);
    ac.i("MicroMsg.OnlineVideoView", "%d onPrepared playErrorCode[%d] onErrorPlayTimeSec[%d]", new Object[] { Integer.valueOf(hashCode()), Integer.valueOf(this.qUR), Integer.valueOf(this.yCA) });
    this.qUR = 0;
    if (this.yCA > 0)
    {
      IE(this.yCA);
      this.yCA = 0;
      AppMethodBeat.o(98084);
      return;
    }
    this.yCB = 0;
    hideLoading();
    dOd();
    dOf();
    this.odZ.start();
    this.duration = (this.odZ.getDuration() / 1000);
    ac.i("MicroMsg.OnlineVideoView", "%d start play duration %d sns local id %s ", new Object[] { Integer.valueOf(hashCode()), Integer.valueOf(this.duration), this.dgl });
    eT(false);
    AppMethodBeat.o(98084);
  }
  
  public void setFilePath(String paramString)
  {
    this.filePath = paramString;
  }
  
  public void setMute(boolean paramBoolean)
  {
    AppMethodBeat.i(98067);
    this.ftN = paramBoolean;
    this.odZ.setMute(this.ftN);
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
    this.yCF = paramLong;
  }
  
  public void setSnsId(String paramString)
  {
    this.dnn = paramString;
  }
  
  public void setThumbViewScaleType(ImageView.ScaleType paramScaleType)
  {
    AppMethodBeat.i(98101);
    this.qQT.setScaleType(paramScaleType);
    AppMethodBeat.o(98101);
  }
  
  public void setVideoCallback(a parama)
  {
    this.yCw = parama;
  }
  
  public void setVideoScaleType(com.tencent.mm.pluginsdk.ui.h.e parame)
  {
    AppMethodBeat.i(98102);
    if (this.odZ != null)
    {
      if ((this.odZ instanceof VideoPlayerTextureView))
      {
        ((VideoPlayerTextureView)this.odZ).setScaleType(parame);
        AppMethodBeat.o(98102);
        return;
      }
      if ((this.odZ instanceof VideoTextureView)) {
        ((VideoTextureView)this.odZ).setScaleType(parame);
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