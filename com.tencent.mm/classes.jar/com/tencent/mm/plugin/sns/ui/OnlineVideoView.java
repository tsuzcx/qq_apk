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
import com.tencent.mm.g.a.cv;
import com.tencent.mm.g.a.cv.b;
import com.tencent.mm.g.a.nx;
import com.tencent.mm.g.a.nx.a;
import com.tencent.mm.g.a.uh;
import com.tencent.mm.g.a.uk;
import com.tencent.mm.g.a.uk.a;
import com.tencent.mm.g.a.vj;
import com.tencent.mm.model.d.a;
import com.tencent.mm.modelvideo.o;
import com.tencent.mm.modelvideo.u;
import com.tencent.mm.plugin.a.j;
import com.tencent.mm.plugin.sns.model.ag;
import com.tencent.mm.plugin.sns.model.ao;
import com.tencent.mm.plugin.sns.model.b.b;
import com.tencent.mm.plugin.sns.model.f;
import com.tencent.mm.pluginsdk.ui.i.e;
import com.tencent.mm.pluginsdk.ui.tools.VideoPlayerTextureView;
import com.tencent.mm.pluginsdk.ui.tools.VideoTextureView;
import com.tencent.mm.pluginsdk.ui.tools.h;
import com.tencent.mm.pluginsdk.ui.tools.h.a;
import com.tencent.mm.pluginsdk.ui.tools.h.e;
import com.tencent.mm.protocal.protobuf.byn;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.av.a;
import com.tencent.mm.sdk.platformtools.ax;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.sdk.platformtools.n;
import com.tencent.mm.storage.al.a;
import com.tencent.mm.storage.bj;
import com.tencent.mm.ui.widget.MMPinProgressBtn;
import com.tencent.mm.ui.widget.a.f.a;
import com.tencent.mm.ui.widget.a.f.c;
import com.tencent.mm.vfs.i;
import java.util.HashMap;

public class OnlineVideoView
  extends RelativeLayout
  implements d.a, ak.a, h.a
{
  private volatile boolean cAX;
  private byn dIQ;
  private int dJw;
  private boolean dJx;
  private int dJy;
  private String drH;
  private int duration;
  private String dzb;
  private boolean fMP;
  private String filePath;
  private TextView gUc;
  private int hZE;
  private ProgressBar ltc;
  private Context mContext;
  ap oGm;
  protected h oHt;
  private com.tencent.mm.sdk.platformtools.av oHz;
  com.tencent.mm.model.d ota;
  ImageView rAT;
  private RelativeLayout rBo;
  private TextView rEY;
  private boolean rFd;
  private boolean rFe;
  private int rFf;
  private MMPinProgressBtn rFi;
  private int scene;
  private String sessionId;
  private com.tencent.mm.plugin.o.b vLz;
  boolean vsW;
  private com.tencent.mm.sdk.platformtools.av zHS;
  private boolean zTG;
  private h.e zTL;
  private int zTO;
  String zTP;
  private boolean zTQ;
  private a zTR;
  protected ak zTS;
  private boolean zTT;
  private boolean zTU;
  private int zTV;
  private int zTW;
  private long zTX;
  private long zTY;
  protected boolean zTZ;
  private long zUa;
  public volatile boolean zUb;
  protected Activity zUc;
  protected boolean zUd;
  private b.b zUe;
  private c zUf;
  private c zUg;
  private long zUh;
  private int zUi;
  private long zUj;
  private int zUk;
  private boolean zUl;
  private bj zdv;
  private c zmW;
  
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
    this.zTO = 0;
    this.vsW = false;
    this.rFd = false;
    this.fMP = false;
    this.dIQ = null;
    this.zTQ = false;
    this.zTS = null;
    this.zTU = false;
    this.duration = 0;
    this.zTV = 0;
    this.zTW = 0;
    this.zTX = 0L;
    this.zTY = 0L;
    this.rFf = 0;
    this.ota = null;
    this.zTZ = true;
    this.oGm = new ap(Looper.getMainLooper());
    this.scene = 0;
    this.zUa = 0L;
    this.sessionId = "";
    this.dzb = "";
    this.filePath = "";
    this.cAX = false;
    this.zUb = false;
    this.zUd = false;
    this.zHS = new com.tencent.mm.sdk.platformtools.av(new av.a()
    {
      public final boolean onTimerExpired()
      {
        AppMethodBeat.i(98059);
        if ((OnlineVideoView.this.zTS == null) || (OnlineVideoView.this.oHt == null))
        {
          AppMethodBeat.o(98059);
          return false;
        }
        if (((View)OnlineVideoView.this.oHt).getAlpha() < 1.0F)
        {
          ad.i("MicroMsg.OnlineVideoView", "onlineVideoTimer switchVideoModel");
          OnlineVideoView.n(OnlineVideoView.this);
        }
        if (OnlineVideoView.this.oHt.isPlaying()) {
          OnlineVideoView.o(OnlineVideoView.this);
        }
        try
        {
          boolean bool = bt.isNullOrNil(OnlineVideoView.this.zTS.irM);
          if (!bool) {}
          for (int i = 1; i == 0; i = 0)
          {
            AppMethodBeat.o(98059);
            return false;
          }
          i = OnlineVideoView.this.oHt.getCurrentPosition() / 1000;
          OnlineVideoView.this.QW(i);
          bool = OnlineVideoView.this.zTS.qi(i);
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
    this.oHz = new com.tencent.mm.sdk.platformtools.av(new av.a()
    {
      public final boolean onTimerExpired()
      {
        AppMethodBeat.i(198188);
        if (OnlineVideoView.this.oHt == null)
        {
          AppMethodBeat.o(198188);
          return false;
        }
        if (((View)OnlineVideoView.this.oHt).getAlpha() < 1.0F)
        {
          ad.i("MicroMsg.OnlineVideoView", "offlineVideoTimer switchVideoModel");
          OnlineVideoView.n(OnlineVideoView.this);
        }
        if (OnlineVideoView.this.oHt.isPlaying())
        {
          OnlineVideoView.o(OnlineVideoView.this);
          OnlineVideoView.this.QW(OnlineVideoView.this.oHt.getCurrentPosition() / 1000);
        }
        AppMethodBeat.o(198188);
        return true;
      }
    }, true);
    this.zUe = new b.b()
    {
      public final void ays(String paramAnonymousString) {}
      
      public final void bM(String paramAnonymousString, boolean paramAnonymousBoolean) {}
      
      public final void bN(final String paramAnonymousString, final boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(198190);
        OnlineVideoView.f(OnlineVideoView.this).postDelayed(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(198189);
            ad.i("MicroMsg.OnlineVideoView", "%d weixin download finish[%b], go to prepare video", new Object[] { Integer.valueOf(OnlineVideoView.this.hashCode()), Boolean.valueOf(paramAnonymousBoolean) });
            if ((OnlineVideoView.c(OnlineVideoView.this) != null) && (paramAnonymousBoolean) && (bt.lQ(OnlineVideoView.c(OnlineVideoView.this).Id, paramAnonymousString)))
            {
              com.tencent.mm.plugin.sns.model.av.jq(OnlineVideoView.a(OnlineVideoView.this), "");
              String str = com.tencent.mm.plugin.sns.model.av.a(OnlineVideoView.a(OnlineVideoView.this), OnlineVideoView.c(OnlineVideoView.this));
              if (!bt.isNullOrNil(str)) {
                OnlineVideoView.this.bU(str, false);
              }
            }
            AppMethodBeat.o(198189);
          }
        }, 100L);
        AppMethodBeat.o(198190);
      }
      
      public final void dTb() {}
    };
    this.zUf = new c() {};
    this.zUg = new c() {};
    this.zmW = new c()
    {
      private boolean a(nx paramAnonymousnx)
      {
        AppMethodBeat.i(198193);
        if (OnlineVideoView.this.zTS == null)
        {
          ad.w("MicroMsg.OnlineVideoView", "%d online video helper is null.", new Object[] { Integer.valueOf(OnlineVideoView.this.hashCode()) });
          AppMethodBeat.o(198193);
          return false;
        }
        ad.w("MicroMsg.OnlineVideoView", "OnlineVideoEvent is received, the OnlineVideoEvent opcode is " + paramAnonymousnx.dBK.dsi);
        ad.w("MicroMsg.OnlineVideoView", "OnlineVideoEvent is received, the OnlineVideoEvent length is " + paramAnonymousnx.dBK.length);
        ad.w("MicroMsg.OnlineVideoView", "OnlineVideoEvent is received, the OnlineVideoEvent offset is " + paramAnonymousnx.dBK.offset);
        ad.w("MicroMsg.OnlineVideoView", "OnlineVideoEvent is received, the OnlineVideoEvent mediaId is " + paramAnonymousnx.dBK.mediaId);
        ad.w("MicroMsg.OnlineVideoView", "OnlineVideoEvent is received, the OnlineVideoEvent retCode is " + paramAnonymousnx.dBK.retCode);
        ad.w("MicroMsg.OnlineVideoView", "OnlineVideoEvent is received, the OnlineVideoEvent startDownload is " + paramAnonymousnx.dBK.dBL);
        try
        {
          bool = OnlineVideoView.this.zTS.aAK(paramAnonymousnx.dBK.mediaId);
          if (!bool)
          {
            AppMethodBeat.o(198193);
            return false;
          }
          if (paramAnonymousnx.dBK.retCode == -21112)
          {
            paramAnonymousnx = OnlineVideoView.this;
            com.tencent.mm.plugin.report.service.g.yhR.idkeyStat(354L, 218L, 1L, false);
            paramAnonymousnx.oGm.post(new OnlineVideoView.10(paramAnonymousnx));
            AppMethodBeat.o(198193);
            return false;
          }
          if ((paramAnonymousnx.dBK.retCode != 0) && (paramAnonymousnx.dBK.retCode != -21006))
          {
            ad.w("MicroMsg.OnlineVideoView", "%d stream download online video error. retCode %d ", new Object[] { Integer.valueOf(OnlineVideoView.this.hashCode()), Integer.valueOf(paramAnonymousnx.dBK.retCode) });
            AppMethodBeat.o(198193);
            return false;
          }
          switch (paramAnonymousnx.dBK.dsi)
          {
          }
        }
        catch (Exception paramAnonymousnx)
        {
          for (;;)
          {
            boolean bool;
            long l2;
            long l1;
            ad.e("MicroMsg.OnlineVideoView", "online video callback error: " + paramAnonymousnx.toString());
            continue;
            if (l1 > localak.fJC) {}
            for (;;)
            {
              for (;;)
              {
                localak.fJC = l1;
                localak.zUz = bt.flT();
                try
                {
                  if (localak.zUv != null) {
                    break label682;
                  }
                  ad.w("MicroMsg.OnlineVideoViewHelper", "parser is null, thread is error.");
                }
                catch (Exception paramAnonymousnx)
                {
                  ad.e("MicroMsg.OnlineVideoViewHelper", "deal moov ready error: " + paramAnonymousnx.toString());
                }
              }
              break;
              l1 = localak.fJC;
            }
            if (localak.zUv.L(localak.irN, l2))
            {
              localak.irS = localak.zUv.iQJ;
              ad.i("MicroMsg.OnlineVideoViewHelper", "mp4 parse moov success. duration %d cdnMediaId %s isFastStart %b", new Object[] { Integer.valueOf(localak.irS), localak.irM, Boolean.valueOf(bool) });
              if (!bool) {
                aq.f(new ak.1(localak));
              }
              if (localak.irT == -1) {}
              for (localak.irQ = 1;; localak.irQ = 2)
              {
                com.tencent.mm.plugin.report.service.g.yhR.idkeyStat(354L, 204L, 1L, false);
                break;
              }
            }
            ad.w("MicroMsg.OnlineVideoViewHelper", "mp4 parse moov error. cdnMediaId %s", new Object[] { localak.irM });
            o.aMK();
            com.tencent.mm.ao.e.r(localak.irM, 0, -1);
            com.tencent.mm.plugin.report.service.g.yhR.idkeyStat(354L, 205L, 1L, false);
            com.tencent.mm.plugin.report.service.g.yhR.f(13836, new Object[] { Integer.valueOf(402), Long.valueOf(bt.aQJ()), "" });
            continue;
            ak localak = OnlineVideoView.this.zTS;
            Object localObject = paramAnonymousnx.dBK.mediaId;
            int i = paramAnonymousnx.dBK.offset;
            int j = paramAnonymousnx.dBK.length;
            localak.irZ = false;
            if ((i < 0) || (j < 0)) {
              ad.w("MicroMsg.OnlineVideoViewHelper", "deal data available error offset[%d], length[%d]", new Object[] { Integer.valueOf(i), Integer.valueOf(j) });
            }
            while (!localak.aAK((String)localObject))
            {
              if (paramAnonymousnx.dBK.length <= 0) {
                break;
              }
              OnlineVideoView.this.eV(true);
              break;
            }
            localObject = localak.irM + i + "_" + j;
            localObject = (Integer)localak.zUu.get(localObject);
            if ((localObject != null) && (((Integer)localObject).intValue() > 0)) {
              localak.irW = ((Integer)localObject).intValue();
            }
            for (;;)
            {
              ad.i("MicroMsg.OnlineVideoViewHelper", "deal data available. offset[%d] length[%d] cachePlayTime[%d]", new Object[] { Integer.valueOf(i), Integer.valueOf(j), Integer.valueOf(localak.irW) });
              break;
              try
              {
                localak.irW = localak.zUv.dy(i, j);
              }
              catch (Exception localException)
              {
                ad.e("MicroMsg.OnlineVideoViewHelper", "deal data available file pos to video time error: " + localException.toString());
              }
            }
            OnlineVideoView.this.eV(true);
            continue;
            ad.i("MicroMsg.OnlineVideoView", "%d download finish. cdnMediaId %s sendReqCode %d favFromScene %d", new Object[] { Integer.valueOf(OnlineVideoView.this.hashCode()), paramAnonymousnx.dBK.mediaId, Integer.valueOf(OnlineVideoView.s(OnlineVideoView.this)), Integer.valueOf(OnlineVideoView.t(OnlineVideoView.this)) });
            paramAnonymousnx = OnlineVideoView.this.zTS;
            ad.i("MicroMsg.OnlineVideoViewHelper", "deal stream finish. playStatus %d cdnMediaId %s", new Object[] { Integer.valueOf(paramAnonymousnx.irQ), paramAnonymousnx.irM });
            paramAnonymousnx.irZ = false;
            paramAnonymousnx.irP = 3;
            com.tencent.mm.plugin.report.service.g.yhR.idkeyStat(354L, 206L, 1L, false);
            if (paramAnonymousnx.irQ == 0)
            {
              ad.w("MicroMsg.OnlineVideoViewHelper", "it had not moov callback and download finish start to play video.");
              paramAnonymousnx.eaB();
            }
            for (;;)
            {
              if (OnlineVideoView.s(OnlineVideoView.this) <= 0) {
                break label1390;
              }
              OnlineVideoView.o(OnlineVideoView.this);
              OnlineVideoView.b(OnlineVideoView.this, OnlineVideoView.s(OnlineVideoView.this));
              break;
              if (paramAnonymousnx.irQ == 5)
              {
                ad.w("MicroMsg.OnlineVideoViewHelper", "it had play error, it request all video data finish, start to play." + paramAnonymousnx.irM);
                paramAnonymousnx.eaB();
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
              OnlineVideoView.this.eV(true);
              continue;
              if (OnlineVideoView.l(OnlineVideoView.this) == 1)
              {
                localak = OnlineVideoView.this.zTS;
                String str = paramAnonymousnx.dBK.mediaId;
                i = paramAnonymousnx.dBK.offset;
                j = paramAnonymousnx.dBK.length;
                if (localak.aAK(str))
                {
                  localak.progress = i;
                  localak.ieH = j;
                  localak.zUx = (localak.progress * 100 / localak.ieH);
                  ad.i("MicroMsg.OnlineVideoViewHelper", "deal video[%s] progress callback[%d, %d]. downloadedPercent[%d]", new Object[] { localak.irM, Integer.valueOf(localak.progress), Integer.valueOf(localak.ieH), Integer.valueOf(localak.zUx) });
                }
                if (localak.zUx >= 100) {
                  localak.irP = 3;
                }
              }
              else if (OnlineVideoView.l(OnlineVideoView.this) == 2)
              {
                OnlineVideoView.a(OnlineVideoView.this, paramAnonymousnx.dBK.offset, paramAnonymousnx.dBK.length);
                continue;
                paramAnonymousnx = OnlineVideoView.this.zTS;
                ad.i("MicroMsg.OnlineVideoViewHelper", "deal had dup video. cdnMediaId %s", new Object[] { paramAnonymousnx.irM });
                paramAnonymousnx.eaB();
              }
            }
          }
        }
        ad.w("MicroMsg.OnlineVideoView", "%d unknown event opcode %d", new Object[] { Integer.valueOf(OnlineVideoView.this.hashCode()), Integer.valueOf(paramAnonymousnx.dBK.dsi) });
        for (;;)
        {
          AppMethodBeat.o(198193);
          return false;
          localak = OnlineVideoView.this.zTS;
          l2 = paramAnonymousnx.dBK.offset;
          l1 = paramAnonymousnx.dBK.dBL;
          bool = paramAnonymousnx.dBK.dBM;
          ad.i("MicroMsg.OnlineVideoViewHelper", "deal moov ready moovPos %d, timeDuration %d, cdnMediaId %s startDownload[%d %d]", new Object[] { Long.valueOf(l2), Integer.valueOf(localak.irS), localak.irM, Long.valueOf(l1), Long.valueOf(localak.fJC) });
          if (localak.irS == 0) {
            break;
          }
          ad.w("MicroMsg.OnlineVideoViewHelper", "moov had callback, do nothing.");
          OnlineVideoView.r(OnlineVideoView.this);
        }
      }
    };
    this.zTL = new h.e()
    {
      public final void boT()
      {
        AppMethodBeat.i(198195);
        ad.i("MicroMsg.OnlineVideoView", "%d on texture update.", new Object[] { Integer.valueOf(OnlineVideoView.this.hashCode()) });
        try
        {
          OnlineVideoView.n(OnlineVideoView.this);
          AppMethodBeat.o(198195);
          return;
        }
        catch (Exception localException)
        {
          ad.e("MicroMsg.OnlineVideoView", "texture view update. error " + localException.toString());
          AppMethodBeat.o(198195);
        }
      }
    };
    this.vLz = new com.tencent.mm.plugin.o.b()
    {
      public final long dmn()
      {
        AppMethodBeat.i(198196);
        ad.i("MicroMsg.OnlineVideoView", "%d sns video get online cache", new Object[] { Integer.valueOf(OnlineVideoView.this.hashCode()) });
        com.tencent.mm.kernel.g.ajD();
        com.tencent.mm.kernel.g.ajC().ajl().set(al.a.IxQ, Boolean.TRUE);
        try
        {
          if ((OnlineVideoView.x(OnlineVideoView.this)) && (OnlineVideoView.this.zTS != null))
          {
            int i = OnlineVideoView.this.zTS.irW;
            long l = i;
            AppMethodBeat.o(198196);
            return l;
          }
        }
        catch (Exception localException)
        {
          AppMethodBeat.o(198196);
        }
        return 0L;
      }
    };
    this.zUl = true;
    this.mContext = paramContext;
    ad.i("MicroMsg.OnlineVideoView", "%d ui init view.", new Object[] { Integer.valueOf(hashCode()) });
    LayoutInflater.from(paramContext).inflate(2131495624, this);
    this.rAT = ((ImageView)findViewById(2131306398));
    this.rBo = ((RelativeLayout)findViewById(2131306392));
    this.gUc = ((TextView)findViewById(2131306332));
    this.gUc.setVisibility(8);
    this.rFi = ((MMPinProgressBtn)findViewById(2131306379));
    this.ltc = ((ProgressBar)findViewById(2131306352));
    this.rEY = ((TextView)findViewById(2131306403));
    com.tencent.mm.modelcontrol.d.aGQ();
    if (com.tencent.mm.modelcontrol.d.aHc())
    {
      this.rFe = true;
      this.oHt = new VideoPlayerTextureView(paramContext);
      ((VideoPlayerTextureView)this.oHt).setIOnlineCache(this.vLz);
      ((VideoPlayerTextureView)this.oHt).setOpenWithNoneSurface(true);
      com.tencent.mm.plugin.report.service.g.yhR.idkeyStat(354L, 148L, 1L, false);
    }
    for (;;)
    {
      this.oHt.setVideoCallback(this);
      paramContext = new RelativeLayout.LayoutParams(-1, -2);
      paramContext.addRule(13);
      this.rBo.addView((View)this.oHt, paramContext);
      ad.i("MicroMsg.OnlineVideoView", "%d switch sync video model isVideoPlay %b %f", new Object[] { Integer.valueOf(hashCode()), Boolean.FALSE, Float.valueOf(0.0F) });
      paramContext = (View)this.oHt;
      this.rBo.setVisibility(8);
      paramContext.setVisibility(8);
      if (this.zUl) {
        this.rAT.setVisibility(0);
      }
      AppMethodBeat.o(98060);
      return;
      this.rFe = false;
      this.oHt = new VideoTextureView(paramContext);
      com.tencent.mm.plugin.report.service.g.yhR.idkeyStat(354L, 149L, 1L, false);
    }
  }
  
  private void Q(boolean paramBoolean, int paramInt)
  {
    boolean bool = true;
    AppMethodBeat.i(98076);
    if (this.dIQ == null)
    {
      ad.w("MicroMsg.OnlineVideoView", "%d start download video but media is null.", new Object[] { Integer.valueOf(hashCode()) });
      AppMethodBeat.o(98076);
      return;
    }
    if (this.zTS == null)
    {
      ad.w("MicroMsg.OnlineVideoView", "%d start download video but helper is null.", new Object[] { Integer.valueOf(hashCode()) });
      AppMethodBeat.o(98076);
      return;
    }
    if (this.dIQ.GEe == 2)
    {
      ad.w("MicroMsg.OnlineVideoView", "%d it start download video, url type is weixin", new Object[] { Integer.valueOf(hashCode()) });
      this.zTO = 3;
      ag.dTZ().a(this.dIQ, 4, null, this.zdv);
      AppMethodBeat.o(98076);
      return;
    }
    int i;
    if (!paramBoolean)
    {
      com.tencent.mm.modelcontrol.d.aGQ();
      if (com.tencent.mm.modelcontrol.d.aHb())
      {
        ad.i("MicroMsg.OnlineVideoView", "%d it start online download video", new Object[] { Integer.valueOf(hashCode()) });
        this.zTO = 1;
        i = paramInt;
        if (paramInt == 0) {
          i = 30;
        }
        paramBoolean = bool;
        if (this.zTS == null) {
          break label276;
        }
        this.zTS.a(this.dIQ, this.hZE, this.drH, paramBoolean, i);
        AppMethodBeat.o(98076);
        return;
      }
    }
    ad.i("MicroMsg.OnlineVideoView", "%d it start offline download video", new Object[] { Integer.valueOf(hashCode()) });
    this.zTO = 2;
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
  
  private void QX(int paramInt)
  {
    AppMethodBeat.i(98071);
    String str = ao.jo(ag.getAccSnsPath(), this.dIQ.Id) + com.tencent.mm.plugin.sns.data.q.d(this.dIQ);
    Intent localIntent = new Intent();
    localIntent.putExtra("Select_Conv_Type", 3);
    localIntent.putExtra("select_is_ret", true);
    localIntent.putExtra("mutil_select_is_ret", true);
    localIntent.putExtra("image_path", str);
    localIntent.putExtra("Retr_Msg_Type", 11);
    ad.i("MicroMsg.OnlineVideoView", "send video path %s reqCode %d", new Object[] { str, Integer.valueOf(paramInt) });
    com.tencent.mm.bs.d.c(getActivityContext(), ".ui.transmit.SelectConversationUI", localIntent, paramInt);
    this.dJy = 0;
    AppMethodBeat.o(98071);
  }
  
  private void aD(final int paramInt, final boolean paramBoolean)
  {
    AppMethodBeat.i(98072);
    this.oGm.post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(98040);
        Object localObject1 = ag.dUe().aAa(OnlineVideoView.a(OnlineVideoView.this));
        if (localObject1 == null)
        {
          AppMethodBeat.o(98040);
          return;
        }
        ad.i("MicroMsg.OnlineVideoView", "fav download video[%s] farFromScene %d isFromMain %b", new Object[] { OnlineVideoView.a(OnlineVideoView.this), Integer.valueOf(paramInt), Boolean.valueOf(paramBoolean) });
        Object localObject2 = new cv();
        ((cv)localObject2).dnG.dnM = paramInt;
        ((cv)localObject2).dnG.activity = ((Activity)OnlineVideoView.this.getActivityContext());
        com.tencent.mm.plugin.sns.k.a.a((cv)localObject2, (com.tencent.mm.plugin.sns.storage.p)localObject1);
        com.tencent.mm.sdk.b.a.IbL.l((com.tencent.mm.sdk.b.b)localObject2);
        if (((cv)localObject2).dnH.ret == 0) {
          OnlineVideoView.eav();
        }
        for (;;)
        {
          if (paramBoolean)
          {
            localObject2 = new uh();
            ((uh)localObject2).dIF.doX = ((com.tencent.mm.plugin.sns.storage.p)localObject1).dYK();
            ((uh)localObject2).dIF.dzb = com.tencent.mm.plugin.sns.data.q.n((com.tencent.mm.plugin.sns.storage.p)localObject1);
            com.tencent.mm.sdk.b.a.IbL.l((com.tencent.mm.sdk.b.b)localObject2);
          }
          OnlineVideoView.b(OnlineVideoView.this);
          if (OnlineVideoView.this.oHt == null) {
            break label318;
          }
          if (!bt.isNullOrNil(OnlineVideoView.this.oHt.getVideoPath())) {
            break;
          }
          ad.i("MicroMsg.OnlineVideoView", "%d had not set video path to play", new Object[] { Integer.valueOf(OnlineVideoView.this.hashCode()) });
          localObject1 = com.tencent.mm.plugin.sns.model.av.a(OnlineVideoView.a(OnlineVideoView.this), OnlineVideoView.c(OnlineVideoView.this));
          if (!bt.isNullOrNil((String)localObject1)) {
            OnlineVideoView.this.bU((String)localObject1, false);
          }
          AppMethodBeat.o(98040);
          return;
          OnlineVideoView.eaw();
        }
        if (!OnlineVideoView.this.oHt.isPlaying())
        {
          OnlineVideoView.this.oHt.start();
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
    this.oGm.post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(98054);
        ad.i("MicroMsg.OnlineVideoView", "%d switch video model isVideoPlay %b %f", new Object[] { Integer.valueOf(OnlineVideoView.this.hashCode()), Boolean.valueOf(paramBoolean), Float.valueOf(paramFloat) });
        View localView = (View)OnlineVideoView.this.oHt;
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
  
  private void cxv()
  {
    AppMethodBeat.i(98075);
    if (!this.vsW) {}
    for (String str = com.tencent.mm.plugin.sns.model.av.a(this.drH, this.dIQ);; str = this.zTP)
    {
      ad.i("MicroMsg.OnlineVideoView", "%d toggleVideo local id %s finish path %s isPreview %b", new Object[] { Integer.valueOf(hashCode()), this.drH, str, Boolean.valueOf(this.vsW) });
      if (bt.isNullOrNil(str)) {
        break;
      }
      ad.i("MicroMsg.OnlineVideoView", "%d sns video already download finish, play now", new Object[] { Integer.valueOf(hashCode()) });
      c(true, 0.0F);
      bU(str, false);
      AppMethodBeat.o(98075);
      return;
    }
    c(false, 0.0F);
    Q(false, 0);
    showLoading();
    AppMethodBeat.o(98075);
  }
  
  private boolean cxy()
  {
    AppMethodBeat.i(98086);
    if (!this.zTT)
    {
      AppMethodBeat.o(98086);
      return false;
    }
    com.tencent.mm.kernel.g.ajD();
    boolean bool = com.tencent.mm.kernel.g.ajC().ajl().getBoolean(al.a.IxQ, false);
    AppMethodBeat.o(98086);
    return bool;
  }
  
  private void eam()
  {
    AppMethodBeat.i(198200);
    int j = 2131231318;
    int i = j;
    if (this.dIQ != null)
    {
      i = j;
      if (this.dIQ.isAd)
      {
        ad.i("MicroMsg.OnlineVideoView", "the media is ad, the background should be transparent");
        i = 2131234429;
      }
    }
    boolean bool = ag.dUb().b(this.dIQ, this.rAT, i, this.mContext.hashCode(), this.zdv);
    ad.i("MicroMsg.OnlineVideoView", "%d fresh thumb image %b", new Object[] { Integer.valueOf(hashCode()), Boolean.valueOf(bool) });
    AppMethodBeat.o(198200);
  }
  
  private void eao()
  {
    AppMethodBeat.i(98073);
    com.tencent.mm.platformtools.p.a(getContext(), new Runnable()new Runnable
    {
      public final void run()
      {
        AppMethodBeat.i(98052);
        long l = bt.HI();
        String str1 = com.tencent.mm.plugin.sns.model.av.a(OnlineVideoView.a(OnlineVideoView.this), OnlineVideoView.c(OnlineVideoView.this));
        String str2 = u.Hz(str1);
        if (bt.isNullOrNil(str2))
        {
          Toast.makeText(OnlineVideoView.d(OnlineVideoView.this), OnlineVideoView.d(OnlineVideoView.this).getString(2131764682), 1).show();
          OnlineVideoView.eax();
        }
        for (;;)
        {
          OnlineVideoView.e(OnlineVideoView.this);
          ad.i("MicroMsg.OnlineVideoView", "%d save downloaded video finish %d %s", new Object[] { Integer.valueOf(hashCode()), Long.valueOf(bt.aO(l)), str1 });
          OnlineVideoView.f(OnlineVideoView.this).post(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(198198);
              if (OnlineVideoView.this.oHt != null)
              {
                if (bt.isNullOrNil(OnlineVideoView.this.oHt.getVideoPath()))
                {
                  ad.i("MicroMsg.OnlineVideoView", "%d had not set video path to play", new Object[] { Integer.valueOf(OnlineVideoView.this.hashCode()) });
                  String str = com.tencent.mm.plugin.sns.model.av.a(OnlineVideoView.a(OnlineVideoView.this), OnlineVideoView.c(OnlineVideoView.this));
                  if (!bt.isNullOrNil(str)) {
                    OnlineVideoView.this.bU(str, false);
                  }
                  AppMethodBeat.o(198198);
                  return;
                }
                if (!OnlineVideoView.this.oHt.isPlaying())
                {
                  OnlineVideoView.this.oHt.start();
                  AppMethodBeat.o(198198);
                  return;
                }
              }
              AppMethodBeat.o(198198);
            }
          });
          AppMethodBeat.o(98052);
          return;
          Toast.makeText(OnlineVideoView.d(OnlineVideoView.this), OnlineVideoView.d(OnlineVideoView.this).getString(2131764683, new Object[] { com.tencent.mm.sdk.f.b.aRB(str2) }), 1).show();
          com.tencent.mm.sdk.f.b.k(str2, OnlineVideoView.d(OnlineVideoView.this));
          OnlineVideoView.eay();
        }
      }
    }, new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(98053);
        Toast.makeText(OnlineVideoView.d(OnlineVideoView.this), OnlineVideoView.d(OnlineVideoView.this).getString(2131764682), 1).show();
        OnlineVideoView.eax();
        AppMethodBeat.o(98053);
      }
    });
    AppMethodBeat.o(98073);
  }
  
  private void ear()
  {
    AppMethodBeat.i(98092);
    this.zUh = bt.flT();
    ad.d("MicroMsg.OnlineVideoView", "%d notePlayVideo notePlayVideo %d ", new Object[] { Integer.valueOf(hashCode()), Long.valueOf(this.zUh) });
    AppMethodBeat.o(98092);
  }
  
  private void eas()
  {
    AppMethodBeat.i(98093);
    if (this.zUh > 0L) {
      this.zUi = ((int)(this.zUi + (bt.flT() - this.zUh) / 1000L));
    }
    ad.i("MicroMsg.OnlineVideoView", "%d notePauseVideo playVideoDuration %d ", new Object[] { Integer.valueOf(hashCode()), Integer.valueOf(this.zUi) });
    this.zUh = 0L;
    AppMethodBeat.o(98093);
  }
  
  private void eat()
  {
    AppMethodBeat.i(98095);
    this.zUj = bt.flT();
    ad.d("MicroMsg.OnlineVideoView", "%d noteResumeVideo noteResumeVideo %d ", new Object[] { Integer.valueOf(hashCode()), Long.valueOf(this.zUj) });
    AppMethodBeat.o(98095);
  }
  
  private void eau()
  {
    AppMethodBeat.i(98096);
    if (this.zUj > 0L)
    {
      this.zUk = 0;
      this.zUk = ((int)(this.zUk + (bt.flT() - this.zUj) / 1000L));
    }
    ad.i("MicroMsg.OnlineVideoView", "%d notePauseVideoByResume playVideoDuration %d ", new Object[] { Integer.valueOf(hashCode()), Integer.valueOf(this.zUk) });
    this.zUj = 0L;
    AppMethodBeat.o(98096);
  }
  
  private void hideLoading()
  {
    AppMethodBeat.i(98080);
    this.oGm.post(new Runnable()
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
    this.oGm.post(new Runnable()
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
            OnlineVideoView.k(OnlineVideoView.this).fLr();
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
    //   2: ldc_w 771
    //   5: invokestatic 155	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   8: aload_0
    //   9: getfield 214	com/tencent/mm/plugin/sns/ui/OnlineVideoView:cAX	Z
    //   12: ifne +12 -> 24
    //   15: ldc_w 771
    //   18: invokestatic 397	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   21: aload_0
    //   22: monitorexit
    //   23: return
    //   24: aload_0
    //   25: iconst_0
    //   26: putfield 214	com/tencent/mm/plugin/sns/ui/OnlineVideoView:cAX	Z
    //   29: ldc 255
    //   31: ldc_w 773
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
    //   52: invokespecial 775	com/tencent/mm/plugin/sns/ui/OnlineVideoView:eas	()V
    //   55: aload_0
    //   56: invokespecial 777	com/tencent/mm/plugin/sns/ui/OnlineVideoView:eau	()V
    //   59: aload_0
    //   60: getfield 336	com/tencent/mm/plugin/sns/ui/OnlineVideoView:oHt	Lcom/tencent/mm/pluginsdk/ui/tools/h;
    //   63: invokeinterface 780 1 0
    //   68: getstatic 786	com/tencent/mm/sdk/b/a:IbL	Lcom/tencent/mm/sdk/b/a;
    //   71: aload_0
    //   72: getfield 243	com/tencent/mm/plugin/sns/ui/OnlineVideoView:zmW	Lcom/tencent/mm/sdk/b/c;
    //   75: invokevirtual 789	com/tencent/mm/sdk/b/a:d	(Lcom/tencent/mm/sdk/b/c;)Z
    //   78: pop
    //   79: getstatic 786	com/tencent/mm/sdk/b/a:IbL	Lcom/tencent/mm/sdk/b/a;
    //   82: aload_0
    //   83: getfield 237	com/tencent/mm/plugin/sns/ui/OnlineVideoView:zUf	Lcom/tencent/mm/sdk/b/c;
    //   86: invokevirtual 789	com/tencent/mm/sdk/b/a:d	(Lcom/tencent/mm/sdk/b/c;)Z
    //   89: pop
    //   90: invokestatic 431	com/tencent/mm/plugin/sns/model/ag:dTZ	()Lcom/tencent/mm/plugin/sns/model/b;
    //   93: aload_0
    //   94: getfield 234	com/tencent/mm/plugin/sns/ui/OnlineVideoView:zUe	Lcom/tencent/mm/plugin/sns/model/b$b;
    //   97: invokevirtual 792	com/tencent/mm/plugin/sns/model/b:b	(Lcom/tencent/mm/plugin/sns/model/b$b;)V
    //   100: aload_0
    //   101: invokevirtual 795	com/tencent/mm/plugin/sns/ui/OnlineVideoView:eae	()V
    //   104: aload_0
    //   105: getfield 200	com/tencent/mm/plugin/sns/ui/OnlineVideoView:oGm	Lcom/tencent/mm/sdk/platformtools/ap;
    //   108: aconst_null
    //   109: invokevirtual 799	com/tencent/mm/sdk/platformtools/ap:removeCallbacksAndMessages	(Ljava/lang/Object;)V
    //   112: aload_0
    //   113: getfield 169	com/tencent/mm/plugin/sns/ui/OnlineVideoView:zTS	Lcom/tencent/mm/plugin/sns/ui/ak;
    //   116: ifnull +18 -> 134
    //   119: aload_0
    //   120: getfield 169	com/tencent/mm/plugin/sns/ui/OnlineVideoView:zTS	Lcom/tencent/mm/plugin/sns/ui/ak;
    //   123: invokevirtual 802	com/tencent/mm/plugin/sns/ui/ak:eaz	()Z
    //   126: pop
    //   127: aload_0
    //   128: getfield 169	com/tencent/mm/plugin/sns/ui/OnlineVideoView:zTS	Lcom/tencent/mm/plugin/sns/ui/ak;
    //   131: invokevirtual 805	com/tencent/mm/plugin/sns/ui/ak:clear	()V
    //   134: invokestatic 811	com/tencent/mm/s/a:Nb	()Lcom/tencent/mm/model/ai;
    //   137: ifnull +11 -> 148
    //   140: invokestatic 811	com/tencent/mm/s/a:Nb	()Lcom/tencent/mm/model/ai;
    //   143: invokeinterface 816 1 0
    //   148: aload_0
    //   149: getfield 185	com/tencent/mm/plugin/sns/ui/OnlineVideoView:ota	Lcom/tencent/mm/model/d;
    //   152: ifnull +12 -> 164
    //   155: aload_0
    //   156: getfield 185	com/tencent/mm/plugin/sns/ui/OnlineVideoView:ota	Lcom/tencent/mm/model/d;
    //   159: iconst_0
    //   160: invokevirtual 822	com/tencent/mm/model/d:ex	(Z)Z
    //   163: pop
    //   164: aload_0
    //   165: aconst_null
    //   166: putfield 185	com/tencent/mm/plugin/sns/ui/OnlineVideoView:ota	Lcom/tencent/mm/model/d;
    //   169: aload_0
    //   170: aconst_null
    //   171: putfield 165	com/tencent/mm/plugin/sns/ui/OnlineVideoView:dIQ	Lcom/tencent/mm/protocal/protobuf/byn;
    //   174: aload_0
    //   175: aconst_null
    //   176: putfield 447	com/tencent/mm/plugin/sns/ui/OnlineVideoView:drH	Ljava/lang/String;
    //   179: aload_0
    //   180: aconst_null
    //   181: putfield 169	com/tencent/mm/plugin/sns/ui/OnlineVideoView:zTS	Lcom/tencent/mm/plugin/sns/ui/ak;
    //   184: aload_0
    //   185: iconst_0
    //   186: putfield 177	com/tencent/mm/plugin/sns/ui/OnlineVideoView:zTW	I
    //   189: ldc_w 771
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
  
  public final void QW(int paramInt)
  {
    AppMethodBeat.i(198202);
    if (this.zTR != null) {
      this.zTR.tt(paramInt);
    }
    AppMethodBeat.o(198202);
  }
  
  public final void a(byn parambyn, String paramString, int paramInt)
  {
    AppMethodBeat.i(98065);
    this.drH = paramString;
    this.hZE = paramInt;
    paramString = bj.frs();
    paramString.hbR = this.hZE;
    this.zdv = paramString;
    if (this.dIQ != parambyn)
    {
      this.dIQ = parambyn;
      eam();
    }
    this.vsW = false;
    ad.i("MicroMsg.OnlineVideoView", "%d set video data[%s, %d] isPreview %b self %s", new Object[] { Integer.valueOf(hashCode()), this.drH, Integer.valueOf(this.hZE), Boolean.valueOf(this.vsW), this });
    AppMethodBeat.o(98065);
  }
  
  public final void aAa() {}
  
  public final void aAb() {}
  
  public final void aB(int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(198201);
    ad.i("MicroMsg.OnlineVideoView", "%d seek second %d afterSeekPlay %b", new Object[] { Integer.valueOf(hashCode()), Integer.valueOf(paramInt), Boolean.valueOf(paramBoolean) });
    this.zTW = 0;
    hideLoading();
    this.oHt.d(paramInt * 1000, paramBoolean);
    eV(false);
    AppMethodBeat.o(198201);
  }
  
  public final void aH(Activity paramActivity)
  {
    this.zUc = paramActivity;
    this.zUd = true;
  }
  
  public final void aMw()
  {
    AppMethodBeat.i(98090);
    ad.i("MicroMsg.OnlineVideoView", "%d pauseByDataBlock", new Object[] { Integer.valueOf(hashCode()) });
    eas();
    showLoading();
    cxw();
    AppMethodBeat.o(98090);
  }
  
  public final void abandonAudioFocus()
  {
    AppMethodBeat.i(98062);
    if (this.ota != null) {
      this.ota.ex(false);
    }
    AppMethodBeat.o(98062);
  }
  
  public final void azY() {}
  
  public final void azZ() {}
  
  public final void bU(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(98087);
    ad.i("MicroMsg.OnlineVideoView", "%d prepare video isOnlinePlay %b filePath %s", new Object[] { Integer.valueOf(hashCode()), Boolean.valueOf(paramBoolean), paramString });
    if (bt.isNullOrNil(paramString))
    {
      ad.w("MicroMsg.OnlineVideoView", "%d prepare video but filepath is null.", new Object[] { Integer.valueOf(hashCode()) });
      AppMethodBeat.o(98087);
      return;
    }
    this.zTT = paramBoolean;
    String str;
    if (this.oHt != null)
    {
      if (this.zTW == -3) {
        break label314;
      }
      if ((this.oHt instanceof VideoPlayerTextureView))
      {
        ((VideoPlayerTextureView)this.oHt).setNeedResetExtractor(cxy());
        ((VideoPlayerTextureView)this.oHt).setIsOnlineVideoType(paramBoolean);
      }
      this.oHt.setOneTimeVideoTextureUpdateCallback(this.zTL);
      ax localax = ax.aQz("TrackDataSource");
      if (this.dIQ != null) {
        break label292;
      }
      str = "";
      localax.putString("media-url", str);
      if (this.dIQ != null) {
        break label303;
      }
      str = "";
      label182:
      localax.putString("thumb-url", str);
      localax.putLong("prepare-ts", System.currentTimeMillis());
      localax.putString("prepare-path", paramString);
      localax.commit();
      this.oHt.setVideoPath(paramString);
      c(true, 0.0F);
    }
    for (;;)
    {
      com.tencent.mm.kernel.g.ajD();
      if (((Integer)com.tencent.mm.kernel.g.ajC().ajl().get(al.a.Iwy, Integer.valueOf(0))).intValue() == 1)
      {
        this.rEY.setText(com.tencent.mm.plugin.sight.base.e.aqM(paramString));
        this.rEY.setVisibility(0);
      }
      AppMethodBeat.o(98087);
      return;
      label292:
      str = this.dIQ.Url;
      break;
      label303:
      str = this.dIQ.GSI;
      break label182;
      label314:
      ad.i("MicroMsg.OnlineVideoView", "%d prepare video reset source", new Object[] { Integer.valueOf(hashCode()) });
      if ((this.oHt instanceof VideoPlayerTextureView)) {
        ((VideoPlayerTextureView)this.oHt).ffr();
      }
      aB(this.zTV, true);
    }
  }
  
  public final void cxw()
  {
    AppMethodBeat.i(98078);
    if (this.oHt.isPlaying())
    {
      ad.i("MicroMsg.OnlineVideoView", "%d pause play", new Object[] { Integer.valueOf(hashCode()) });
      eas();
      eau();
      this.oHt.pause();
    }
    AppMethodBeat.o(98078);
  }
  
  public final int eT(int paramInt1, int paramInt2)
  {
    return 0;
  }
  
  protected final void eV(boolean paramBoolean)
  {
    AppMethodBeat.i(98081);
    if (this.zTT)
    {
      if (paramBoolean)
      {
        aq.f(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(198199);
            if ((OnlineVideoView.this.oHt != null) && (OnlineVideoView.this.zTS != null))
            {
              int i = OnlineVideoView.this.oHt.getCurrentPosition() / 1000;
              OnlineVideoView.this.zTS.qi(i);
            }
            OnlineVideoView.m(OnlineVideoView.this).az(500L, 500L);
            AppMethodBeat.o(198199);
          }
        });
        AppMethodBeat.o(98081);
        return;
      }
      this.zHS.az(500L, 500L);
      AppMethodBeat.o(98081);
      return;
    }
    this.oHz.az(500L, 500L);
    AppMethodBeat.o(98081);
  }
  
  public final void eae()
  {
    AppMethodBeat.i(98082);
    this.zHS.stopTimer();
    this.oHz.stopTimer();
    AppMethodBeat.o(98082);
  }
  
  public final void eai()
  {
    this.zTZ = false;
  }
  
  public final void eaj()
  {
    AppMethodBeat.i(98063);
    ad.d("MicroMsg.OnlineVideoView", "%d register sns ui event", new Object[] { Integer.valueOf(hashCode()) });
    com.tencent.mm.sdk.b.a.IbL.c(this.zUg);
    AppMethodBeat.o(98063);
  }
  
  public final void eak()
  {
    AppMethodBeat.i(98064);
    ad.d("MicroMsg.OnlineVideoView", "%d unRegister sns ui event", new Object[] { Integer.valueOf(hashCode()) });
    com.tencent.mm.sdk.b.a.IbL.d(this.zUg);
    AppMethodBeat.o(98064);
  }
  
  public final String eal()
  {
    AppMethodBeat.i(98066);
    Object localObject = new StringBuffer();
    try
    {
      if (this.dIQ != null) {
        ((StringBuffer)localObject).append("media: " + this.dIQ.Id);
      }
      if (this.drH != null) {
        ((StringBuffer)localObject).append("localId: " + this.drH);
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
  
  public final void ean()
  {
    this.zUc = null;
    this.zUd = false;
  }
  
  public final boolean eap()
  {
    boolean bool = true;
    AppMethodBeat.i(98088);
    ad.i("MicroMsg.OnlineVideoView", "%d resumeByDataGain", new Object[] { Integer.valueOf(hashCode()) });
    if (!this.oHt.isPlaying())
    {
      ear();
      eat();
      bool = this.oHt.start();
      hideLoading();
    }
    AppMethodBeat.o(98088);
    return bool;
  }
  
  public void eaq()
  {
    AppMethodBeat.i(98089);
    if (!this.oHt.isPlaying())
    {
      eat();
      int i = this.oHt.getDuration();
      int j = this.oHt.getCurrentPosition();
      if (j >= i) {
        ad.e("MicroMsg.OnlineVideoView", "the current position is more than duration, current = %d, duration = %d !!!", new Object[] { Integer.valueOf(j), Integer.valueOf(i) });
      }
      this.oHt.start();
    }
    AppMethodBeat.o(98089);
  }
  
  public final void eb(int paramInt1, int paramInt2) {}
  
  protected Context getActivityContext()
  {
    if (this.zUc == null) {
      return this.mContext;
    }
    return this.zUc;
  }
  
  public int getCurrentPosition()
  {
    AppMethodBeat.i(98100);
    int i = this.oHt.getCurrentPosition();
    AppMethodBeat.o(98100);
    return i;
  }
  
  public int getDuration()
  {
    AppMethodBeat.i(98077);
    if (this.oHt == null)
    {
      AppMethodBeat.o(98077);
      return 0;
    }
    int i = this.oHt.getDuration();
    AppMethodBeat.o(98077);
    return i;
  }
  
  public String getFilePath()
  {
    return this.filePath;
  }
  
  public int getPlayErrorCode()
  {
    return this.rFf;
  }
  
  public int getPlayVideoDuration()
  {
    AppMethodBeat.i(98094);
    if (this.zUi < 0) {
      this.zUi = 0;
    }
    ad.i("MicroMsg.OnlineVideoView", "%d get play video duration [%d]", new Object[] { Integer.valueOf(hashCode()), Integer.valueOf(this.zUi) });
    int i = this.zUi;
    AppMethodBeat.o(98094);
    return i;
  }
  
  public int getPlayVideoDurationByResume()
  {
    AppMethodBeat.i(98097);
    if (this.zUk < 0) {
      this.zUk = 0;
    }
    ad.i("MicroMsg.OnlineVideoView", "%d get play video duration by resume [%d]", new Object[] { Integer.valueOf(hashCode()), Integer.valueOf(this.zUk) });
    int i = this.zUk;
    AppMethodBeat.o(98097);
    return i;
  }
  
  public ak.c getRptStruct()
  {
    AppMethodBeat.i(98099);
    ak.c localc = new ak.c();
    localc.scene = this.scene;
    localc.sessionId = this.sessionId;
    localc.zUa = this.zUa;
    localc.dzb = this.dzb;
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
    return this.zUa;
  }
  
  public String getSnsId()
  {
    return this.dzb;
  }
  
  public int getUiStayTime()
  {
    if ((this.zTY > 0L) && (this.zTX > 0L)) {}
    for (int i = (int)(this.zTY - this.zTX);; i = 0)
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
    boolean bool = this.oHt.isPlaying();
    AppMethodBeat.o(98098);
    return bool;
  }
  
  public final void onCompletion()
  {
    AppMethodBeat.i(98085);
    ad.i("MicroMsg.OnlineVideoView", "%d on completion", new Object[] { Integer.valueOf(hashCode()) });
    if (this.zTR == null)
    {
      if ((com.tencent.mm.compatible.util.d.lA(18)) || (!this.rFe))
      {
        aB(0, true);
        AppMethodBeat.o(98085);
        return;
      }
      if (this.oHt != null)
      {
        String str = this.oHt.getVideoPath();
        this.oHt.stop();
        bU(str, this.zTT);
        AppMethodBeat.o(98085);
      }
    }
    else
    {
      this.zTR.onCompletion();
    }
    AppMethodBeat.o(98085);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(98070);
    ad.d("MicroMsg.OnlineVideoView", "%d on destroy %s", new Object[] { Integer.valueOf(hashCode()), bt.flS() });
    this.zTY = bt.flT();
    unInit();
    AppMethodBeat.o(98070);
  }
  
  public final void onError(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(98083);
    ad.e("MicroMsg.OnlineVideoView", "%d on play video error what %d extra %d. isOnlinePlay %b isMMVideoPlayer[%b]", new Object[] { Integer.valueOf(hashCode()), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Boolean.valueOf(this.zTT), Boolean.valueOf(this.rFe) });
    Object localObject;
    if (this.zTT)
    {
      com.tencent.mm.plugin.report.service.g.yhR.idkeyStat(354L, 230L, 1L, false);
      this.rFf = paramInt2;
      eas();
      localObject = this.oHt.getVideoPath();
      this.zTV = (this.oHt.getCurrentPosition() / 1000);
      if (!this.zTT) {
        break label386;
      }
      if (paramInt1 != -2) {
        break label339;
      }
      this.oHt.stop();
    }
    for (;;)
    {
      try
      {
        showLoading();
        if (this.zTS != null)
        {
          localObject = this.zTS;
          String str = ((ak)localObject).irM + 0 + "_-1";
          if (!((ak)localObject).zUu.containsKey(str))
          {
            ad.i("MicroMsg.OnlineVideoViewHelper", "request all data. [%s]", new Object[] { ((ak)localObject).irM });
            o.aMK();
            com.tencent.mm.ao.e.r(((ak)localObject).irM, 0, -1);
            ((ak)localObject).zUu.put(str, Integer.valueOf(0));
            com.tencent.mm.plugin.report.service.g.yhR.idkeyStat(354L, 207L, 1L, false);
            com.tencent.mm.plugin.report.service.g.yhR.f(13836, new Object[] { Integer.valueOf(403), Long.valueOf(bt.aQJ()), "" });
          }
          ((ak)localObject).irQ = 5;
          ((ak)localObject).irV = true;
          ((ak)localObject).irY = false;
        }
        eas();
        AppMethodBeat.o(98083);
        return;
      }
      catch (Exception localException)
      {
        label339:
        AppMethodBeat.o(98083);
        return;
      }
      com.tencent.mm.plugin.report.service.g.yhR.idkeyStat(354L, 231L, 1L, false);
      break;
      if (paramInt1 == -3)
      {
        this.zTW = paramInt1;
        this.oHt.pause();
      }
      else
      {
        eae();
        this.oHt.stop();
      }
    }
    label386:
    this.oHt.stop();
    this.rFd = true;
    c(false, 0.0F);
    ad.w("MicroMsg.OnlineVideoView", "error %s, %s", new Object[] { Boolean.valueOf(this.zUd), localException });
    if ((!bt.isNullOrNil(localException)) && (this.zUd))
    {
      ad.w("MicroMsg.OnlineVideoView", "%d start third player to play", new Object[] { Integer.valueOf(hashCode()) });
      this.oGm.post(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(98051);
          Object localObject = new Intent();
          ((Intent)localObject).setAction("android.intent.action.VIEW");
          n.a(OnlineVideoView.this.getContext(), (Intent)localObject, new com.tencent.mm.vfs.e(localException), "video/*");
          try
          {
            Context localContext = OnlineVideoView.this.getContext();
            localObject = new com.tencent.mm.hellhoundlib.b.a().bc(localObject);
            com.tencent.mm.hellhoundlib.a.a.a(localContext, ((com.tencent.mm.hellhoundlib.b.a)localObject).ahp(), "com/tencent/mm/plugin/sns/ui/OnlineVideoView$17", "run", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            localContext.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).mq(0));
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
              locala.aXO(OnlineVideoView.this.getContext().getString(2131758931));
              locala.av(OnlineVideoView.this.getContext().getString(2131758932)).c(new f.c()
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
    ad.d("MicroMsg.OnlineVideoView", "%d on pause %s ", new Object[] { Integer.valueOf(hashCode()), bt.flS() });
    eae();
    if (this.oHt != null) {
      this.oHt.stop();
    }
    AppMethodBeat.o(98069);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(98068);
    ad.d("MicroMsg.OnlineVideoView", "%d on resume %s", new Object[] { Integer.valueOf(hashCode()), bt.flS() });
    this.zTX = bt.flT();
    if (this.zUb)
    {
      ad.e("MicroMsg.OnlineVideoView", "what are you doing guys!!! Would you like to invite everyone to eat pizza??? %s", new Object[] { bt.flS() });
      com.tencent.mm.plugin.report.service.g.yhR.n(31L, 3L, 1L);
    }
    for (;;)
    {
      if (!this.rFd) {
        cxv();
      }
      this.zTG = true;
      AppMethodBeat.o(98068);
      return;
      if (this.zTS == null)
      {
        this.cAX = true;
        ad.i("MicroMsg.OnlineVideoView", "%d logic init, create new helper and add listener.", new Object[] { Integer.valueOf(hashCode()) });
        this.zTS = new ak(this);
        com.tencent.mm.sdk.b.a.IbL.c(this.zmW);
        com.tencent.mm.sdk.b.a.IbL.c(this.zUf);
        ag.dTZ().a(this.zUe);
        if (this.zTZ)
        {
          this.ota = new com.tencent.mm.model.d();
          this.ota.a(this);
        }
        if (com.tencent.mm.s.a.Nb() != null) {
          com.tencent.mm.s.a.Nb().Wv();
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
    this.fMP = paramBoolean;
    this.oHt.setMute(this.fMP);
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
    this.zUa = paramLong;
  }
  
  public void setSnsId(String paramString)
  {
    this.dzb = paramString;
  }
  
  public void setThumbViewScaleType(ImageView.ScaleType paramScaleType)
  {
    AppMethodBeat.i(98101);
    this.rAT.setScaleType(paramScaleType);
    AppMethodBeat.o(98101);
  }
  
  public void setVideoCallback(a parama)
  {
    this.zTR = parama;
  }
  
  public void setVideoScaleType(i.e parame)
  {
    AppMethodBeat.i(98102);
    if (this.oHt != null)
    {
      if ((this.oHt instanceof VideoPlayerTextureView))
      {
        ((VideoPlayerTextureView)this.oHt).setScaleType(parame);
        AppMethodBeat.o(98102);
        return;
      }
      if ((this.oHt instanceof VideoTextureView)) {
        ((VideoTextureView)this.oHt).setScaleType(parame);
      }
    }
    AppMethodBeat.o(98102);
  }
  
  public final void ta()
  {
    AppMethodBeat.i(98084);
    ad.i("MicroMsg.OnlineVideoView", "%d onPrepared playErrorCode[%d] onErrorPlayTimeSec[%d]", new Object[] { Integer.valueOf(hashCode()), Integer.valueOf(this.rFf), Integer.valueOf(this.zTV) });
    this.rFf = 0;
    if (this.zTV > 0)
    {
      aB(this.zTV, true);
      this.zTV = 0;
      AppMethodBeat.o(98084);
      return;
    }
    this.zTW = 0;
    hideLoading();
    ear();
    eat();
    this.oHt.start();
    this.duration = (this.oHt.getDuration() / 1000);
    ad.i("MicroMsg.OnlineVideoView", "%d start play duration %d sns local id %s ", new Object[] { Integer.valueOf(hashCode()), Integer.valueOf(this.duration), this.drH });
    eV(false);
    if (this.zTR != null) {
      this.zTR.onStart(this.duration);
    }
    AppMethodBeat.o(98084);
  }
  
  public static abstract interface a
  {
    public abstract void onCompletion();
    
    public abstract void onStart(int paramInt);
    
    public abstract void tt(int paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.OnlineVideoView
 * JD-Core Version:    0.7.0.1
 */