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
import com.tencent.mm.app.j.b;
import com.tencent.mm.g.a.cz;
import com.tencent.mm.g.a.cz.b;
import com.tencent.mm.g.a.oq;
import com.tencent.mm.g.a.oq.a;
import com.tencent.mm.g.a.vj;
import com.tencent.mm.g.a.vm;
import com.tencent.mm.g.a.vm.a;
import com.tencent.mm.g.a.wn;
import com.tencent.mm.model.d.a;
import com.tencent.mm.platformtools.p;
import com.tencent.mm.platformtools.p.a;
import com.tencent.mm.plugin.n.b;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.sns.data.r;
import com.tencent.mm.plugin.sns.model.aj;
import com.tencent.mm.plugin.sns.model.ar;
import com.tencent.mm.plugin.sns.model.ay;
import com.tencent.mm.plugin.sns.model.c.b;
import com.tencent.mm.plugin.sns.storage.SnsInfo;
import com.tencent.mm.plugin.sns.storage.n;
import com.tencent.mm.pluginsdk.ui.i.e;
import com.tencent.mm.pluginsdk.ui.tools.VideoPlayerTextureView;
import com.tencent.mm.pluginsdk.ui.tools.VideoTextureView;
import com.tencent.mm.pluginsdk.ui.tools.j.e;
import com.tencent.mm.protocal.protobuf.cnb;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IEvent;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.FileProviderHelper;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.MTimerHandler;
import com.tencent.mm.sdk.platformtools.MTimerHandler.CallBack;
import com.tencent.mm.sdk.platformtools.MultiProcessMMKV;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.system.AndroidMediaUtil;
import com.tencent.mm.storage.ao;
import com.tencent.mm.storage.ar.a;
import com.tencent.mm.storage.bp;
import com.tencent.mm.ui.widget.MMPinProgressBtn;
import com.tencent.mm.ui.widget.a.f.a;
import com.tencent.mm.ui.widget.a.f.c;
import com.tencent.mm.vfs.s;
import java.util.HashMap;

public class OnlineVideoView
  extends RelativeLayout
  implements d.a, an.a, com.tencent.mm.pluginsdk.ui.tools.j.a
{
  private bp DEv;
  private IListener DOo;
  private MTimerHandler Ehq;
  private j.e EtE;
  private int EtH;
  String EtI;
  private boolean EtJ;
  private a EtK;
  protected volatile an EtL;
  private boolean EtM;
  private boolean EtN;
  private int EtO;
  private int EtP;
  private long EtQ;
  private long EtR;
  protected boolean EtS;
  private long EtT;
  public volatile boolean EtU;
  protected Activity EtV;
  protected boolean EtW;
  private c.b EtX;
  private IListener EtY;
  private IListener EtZ;
  private boolean Etz;
  private long Eua;
  private int Eub;
  private long Euc;
  private int Eud;
  private boolean Eue;
  final String TAG;
  private String dJX;
  private String dRS;
  private int duration;
  private cnb ebR;
  private boolean ecA;
  private int ecB;
  private int ecz;
  private String filePath;
  private boolean guh;
  private TextView hPF;
  private int iXu;
  private volatile boolean isInit;
  boolean isPreview;
  private Context mContext;
  private ProgressBar mEz;
  com.tencent.mm.model.d pNk;
  MMHandler qaC;
  protected com.tencent.mm.pluginsdk.ui.tools.j qbJ;
  private MTimerHandler qbP;
  private int scene;
  private String sessionId;
  ImageView tiQ;
  private RelativeLayout tjk;
  private TextView tmU;
  private boolean tmZ;
  private boolean tna;
  private int tnb;
  private MMPinProgressBtn tne;
  private int videoHeight;
  private int videoWidth;
  private b zrF;
  
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
    this.TAG = ("MicroMsg.OnlineVideoView[" + hashCode() + ']');
    this.EtH = 0;
    this.isPreview = false;
    this.tmZ = false;
    this.guh = false;
    this.ebR = null;
    this.EtJ = false;
    this.EtL = null;
    this.EtN = false;
    this.duration = 0;
    this.EtO = 0;
    this.EtP = 0;
    this.EtQ = 0L;
    this.EtR = 0L;
    this.tnb = 0;
    this.pNk = null;
    this.EtS = true;
    this.qaC = new MMHandler(Looper.getMainLooper());
    this.scene = 0;
    this.EtT = 0L;
    this.sessionId = "";
    this.dRS = "";
    this.filePath = "";
    this.videoWidth = 0;
    this.videoHeight = 0;
    this.isInit = false;
    this.EtU = false;
    this.EtW = false;
    this.Ehq = new MTimerHandler(new MTimerHandler.CallBack()
    {
      public final boolean onTimerExpired()
      {
        AppMethodBeat.i(98059);
        if ((OnlineVideoView.this.EtL == null) || (OnlineVideoView.this.qbJ == null))
        {
          AppMethodBeat.o(98059);
          return false;
        }
        if (((View)OnlineVideoView.this.qbJ).getAlpha() < 1.0F)
        {
          Log.i(OnlineVideoView.d(OnlineVideoView.this), "onlineVideoTimer switchVideoModel");
          OnlineVideoView.t(OnlineVideoView.this);
        }
        if (OnlineVideoView.this.qbJ.isPlaying()) {
          OnlineVideoView.u(OnlineVideoView.this);
        }
        try
        {
          boolean bool = Util.isNullOrNil(OnlineVideoView.this.EtL.jpT);
          if (!bool) {}
          for (int i = 1; i == 0; i = 0)
          {
            AppMethodBeat.o(98059);
            return false;
          }
          i = OnlineVideoView.this.qbJ.getCurrentPosition() / 1000;
          OnlineVideoView.this.Zz(i);
          bool = OnlineVideoView.this.EtL.ub(i);
          AppMethodBeat.o(98059);
          return bool;
        }
        catch (Exception localException)
        {
          Log.e(OnlineVideoView.d(OnlineVideoView.this), "online video timer check error : " + localException.toString());
          AppMethodBeat.o(98059);
        }
        return false;
      }
    }, true);
    this.qbP = new MTimerHandler(new MTimerHandler.CallBack()
    {
      public final boolean onTimerExpired()
      {
        AppMethodBeat.i(203320);
        if (OnlineVideoView.this.qbJ == null)
        {
          AppMethodBeat.o(203320);
          return false;
        }
        if (((View)OnlineVideoView.this.qbJ).getAlpha() < 1.0F)
        {
          Log.i(OnlineVideoView.d(OnlineVideoView.this), "offlineVideoTimer switchVideoModel");
          OnlineVideoView.t(OnlineVideoView.this);
        }
        if (OnlineVideoView.this.qbJ.isPlaying())
        {
          OnlineVideoView.u(OnlineVideoView.this);
          OnlineVideoView.this.Zz(OnlineVideoView.this.qbJ.getCurrentPosition() / 1000);
        }
        AppMethodBeat.o(203320);
        return true;
      }
    }, true);
    this.EtX = new c.b()
    {
      public final void aOG(String paramAnonymousString) {}
      
      public final void ci(String paramAnonymousString, boolean paramAnonymousBoolean) {}
      
      public final void cj(final String paramAnonymousString, final boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(203322);
        OnlineVideoView.j(OnlineVideoView.this).postDelayed(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(203321);
            Log.i(OnlineVideoView.d(OnlineVideoView.this), "%d weixin download finish[%b], go to prepare video", new Object[] { Integer.valueOf(OnlineVideoView.this.hashCode()), Boolean.valueOf(paramAnonymousBoolean) });
            if ((OnlineVideoView.f(OnlineVideoView.this) != null) && (paramAnonymousBoolean) && (Util.isEqual(OnlineVideoView.f(OnlineVideoView.this).Id, paramAnonymousString)))
            {
              ay.kk(OnlineVideoView.c(OnlineVideoView.this), "");
              String str = ay.a(OnlineVideoView.c(OnlineVideoView.this), OnlineVideoView.f(OnlineVideoView.this));
              if (!Util.isNullOrNil(str)) {
                OnlineVideoView.this.cq(str, false);
              }
            }
            AppMethodBeat.o(203321);
          }
        }, 100L);
        AppMethodBeat.o(203322);
      }
      
      public final void eZJ() {}
    };
    this.EtY = new IListener() {};
    this.EtZ = new IListener() {};
    this.DOo = new IListener()
    {
      private boolean a(oq paramAnonymousoq)
      {
        AppMethodBeat.i(203325);
        if (OnlineVideoView.this.EtL == null)
        {
          Log.w(OnlineVideoView.d(OnlineVideoView.this), "%d online video helper is null.", new Object[] { Integer.valueOf(OnlineVideoView.this.hashCode()) });
          AppMethodBeat.o(203325);
          return false;
        }
        Log.w(OnlineVideoView.d(OnlineVideoView.this), "OnlineVideoEvent is received, the OnlineVideoEvent opcode is " + paramAnonymousoq.dUF.dKy);
        Log.w(OnlineVideoView.d(OnlineVideoView.this), "OnlineVideoEvent is received, the OnlineVideoEvent length is " + paramAnonymousoq.dUF.length);
        Log.w(OnlineVideoView.d(OnlineVideoView.this), "OnlineVideoEvent is received, the OnlineVideoEvent offset is " + paramAnonymousoq.dUF.offset);
        Log.w(OnlineVideoView.d(OnlineVideoView.this), "OnlineVideoEvent is received, the OnlineVideoEvent mediaId is " + paramAnonymousoq.dUF.mediaId);
        Log.w(OnlineVideoView.d(OnlineVideoView.this), "OnlineVideoEvent is received, the OnlineVideoEvent retCode is " + paramAnonymousoq.dUF.retCode);
        Log.w(OnlineVideoView.d(OnlineVideoView.this), "OnlineVideoEvent is received, the OnlineVideoEvent startDownload is " + paramAnonymousoq.dUF.dUG);
        try
        {
          bool = OnlineVideoView.this.EtL.aQW(paramAnonymousoq.dUF.mediaId);
          if (!bool)
          {
            AppMethodBeat.o(203325);
            return false;
          }
          if (paramAnonymousoq.dUF.retCode == -21112)
          {
            paramAnonymousoq = OnlineVideoView.this;
            h.CyF.idkeyStat(354L, 218L, 1L, false);
            paramAnonymousoq.qaC.post(new OnlineVideoView.10(paramAnonymousoq));
            AppMethodBeat.o(203325);
            return false;
          }
          if ((paramAnonymousoq.dUF.retCode != 0) && (paramAnonymousoq.dUF.retCode != -21006))
          {
            Log.w(OnlineVideoView.d(OnlineVideoView.this), "%d stream download online video error. retCode %d ", new Object[] { Integer.valueOf(OnlineVideoView.this.hashCode()), Integer.valueOf(paramAnonymousoq.dUF.retCode) });
            AppMethodBeat.o(203325);
            return false;
          }
          switch (paramAnonymousoq.dUF.dKy)
          {
          }
        }
        catch (Exception paramAnonymousoq)
        {
          for (;;)
          {
            boolean bool;
            long l2;
            long l1;
            Log.e(OnlineVideoView.d(OnlineVideoView.this), "online video callback error: " + paramAnonymousoq.toString());
            continue;
            if (l1 > localan.gqR) {}
            for (;;)
            {
              for (;;)
              {
                localan.gqR = l1;
                localan.Eut = Util.nowMilliSecond();
                try
                {
                  if (localan.Eup != null) {
                    break label744;
                  }
                  Log.w(localan.TAG, "parser is null, thread is error.");
                }
                catch (Exception paramAnonymousoq)
                {
                  Log.e(localan.TAG, "deal moov ready error: " + paramAnonymousoq.toString());
                }
              }
              break;
              l1 = localan.gqR;
            }
            if (localan.Eup.L(localan.jpU, l2))
            {
              localan.jpY = localan.Eup.jQw;
              Log.i(localan.TAG, "mp4 parse moov success. duration %d cdnMediaId %s isFastStart %b", new Object[] { Integer.valueOf(localan.jpY), localan.jpT, Boolean.valueOf(bool) });
              if (!bool) {
                MMHandlerThread.postToMainThread(new an.1(localan));
              }
              if (localan.jpZ == -1) {}
              for (localan.jpW = 1;; localan.jpW = 2)
              {
                h.CyF.idkeyStat(354L, 204L, 1L, false);
                break;
              }
            }
            Log.w(localan.TAG, "mp4 parse moov error. cdnMediaId %s", new Object[] { localan.jpT });
            com.tencent.mm.modelvideo.o.bhk();
            com.tencent.mm.an.e.r(localan.jpT, 0, -1);
            h.CyF.idkeyStat(354L, 205L, 1L, false);
            h.CyF.a(13836, new Object[] { Integer.valueOf(402), Long.valueOf(Util.nowSecond()), "" });
            continue;
            an localan = OnlineVideoView.this.EtL;
            Object localObject = paramAnonymousoq.dUF.mediaId;
            int i = paramAnonymousoq.dUF.offset;
            int j = paramAnonymousoq.dUF.length;
            localan.jqf = false;
            if ((i < 0) || (j < 0)) {
              Log.w(localan.TAG, "deal data available error offset[%d], length[%d]", new Object[] { Integer.valueOf(i), Integer.valueOf(j) });
            }
            while (!localan.aQW((String)localObject))
            {
              if (paramAnonymousoq.dUF.length <= 0) {
                break;
              }
              OnlineVideoView.this.fO(true);
              break;
            }
            localObject = localan.jpT + i + "_" + j;
            localObject = (Integer)localan.Euo.get(localObject);
            if ((localObject != null) && (((Integer)localObject).intValue() > 0)) {
              localan.jqc = ((Integer)localObject).intValue();
            }
            for (;;)
            {
              Log.i(localan.TAG, "deal data available. offset[%d] length[%d] cachePlayTime[%d]", new Object[] { Integer.valueOf(i), Integer.valueOf(j), Integer.valueOf(localan.jqc) });
              break;
              try
              {
                localan.jqc = localan.Eup.dG(i, j);
              }
              catch (Exception localException)
              {
                Log.e(localan.TAG, "deal data available file pos to video time error: " + localException.toString());
              }
            }
            OnlineVideoView.this.fO(true);
            continue;
            Log.i(OnlineVideoView.d(OnlineVideoView.this), "%d download finish. cdnMediaId %s sendReqCode %d favFromScene %d", new Object[] { Integer.valueOf(OnlineVideoView.this.hashCode()), paramAnonymousoq.dUF.mediaId, Integer.valueOf(OnlineVideoView.y(OnlineVideoView.this)), Integer.valueOf(OnlineVideoView.z(OnlineVideoView.this)) });
            paramAnonymousoq = OnlineVideoView.this.EtL;
            Log.i(paramAnonymousoq.TAG, "deal stream finish. playStatus %d cdnMediaId %s", new Object[] { Integer.valueOf(paramAnonymousoq.jpW), paramAnonymousoq.jpT });
            paramAnonymousoq.jqf = false;
            paramAnonymousoq.jpV = 3;
            h.CyF.idkeyStat(354L, 206L, 1L, false);
            if (paramAnonymousoq.jpW == 0)
            {
              Log.w(paramAnonymousoq.TAG, "it had not moov callback and download finish start to play video.");
              paramAnonymousoq.fgy();
            }
            for (;;)
            {
              if (OnlineVideoView.y(OnlineVideoView.this) <= 0) {
                break label1478;
              }
              OnlineVideoView.u(OnlineVideoView.this);
              OnlineVideoView.b(OnlineVideoView.this, OnlineVideoView.y(OnlineVideoView.this));
              break;
              if (paramAnonymousoq.jpW == 5)
              {
                Log.w(paramAnonymousoq.TAG, "it had play error, it request all video data finish, start to play." + paramAnonymousoq.jpT);
                paramAnonymousoq.fgy();
              }
            }
            if (OnlineVideoView.z(OnlineVideoView.this) > 0)
            {
              OnlineVideoView.u(OnlineVideoView.this);
              OnlineVideoView.b(OnlineVideoView.this, OnlineVideoView.z(OnlineVideoView.this), OnlineVideoView.A(OnlineVideoView.this));
            }
            else if (OnlineVideoView.B(OnlineVideoView.this))
            {
              OnlineVideoView.u(OnlineVideoView.this);
              OnlineVideoView.C(OnlineVideoView.this);
            }
            else
            {
              OnlineVideoView.this.fO(true);
              continue;
              if (OnlineVideoView.r(OnlineVideoView.this) == 1)
              {
                localan = OnlineVideoView.this.EtL;
                String str = paramAnonymousoq.dUF.mediaId;
                i = paramAnonymousoq.dUF.offset;
                j = paramAnonymousoq.dUF.length;
                if (localan.aQW(str))
                {
                  localan.progress = i;
                  localan.jcu = j;
                  localan.Eur = (localan.progress * 100 / localan.jcu);
                  Log.i(localan.TAG, "deal video[%s] progress callback[%d, %d]. downloadedPercent[%d]", new Object[] { localan.jpT, Integer.valueOf(localan.progress), Integer.valueOf(localan.jcu), Integer.valueOf(localan.Eur) });
                }
                if (localan.Eur >= 100) {
                  localan.jpV = 3;
                }
              }
              else if (OnlineVideoView.r(OnlineVideoView.this) == 2)
              {
                OnlineVideoView.a(OnlineVideoView.this, paramAnonymousoq.dUF.offset, paramAnonymousoq.dUF.length);
                continue;
                paramAnonymousoq = OnlineVideoView.this.EtL;
                Log.i(paramAnonymousoq.TAG, "deal had dup video. cdnMediaId %s", new Object[] { paramAnonymousoq.jpT });
                paramAnonymousoq.fgy();
              }
            }
          }
        }
        Log.w(OnlineVideoView.d(OnlineVideoView.this), "%d unknown event opcode %d", new Object[] { Integer.valueOf(OnlineVideoView.this.hashCode()), Integer.valueOf(paramAnonymousoq.dUF.dKy) });
        for (;;)
        {
          AppMethodBeat.o(203325);
          return false;
          localan = OnlineVideoView.this.EtL;
          l2 = paramAnonymousoq.dUF.offset;
          l1 = paramAnonymousoq.dUF.dUG;
          bool = paramAnonymousoq.dUF.dUH;
          Log.i(localan.TAG, "deal moov ready moovPos %d, timeDuration %d, cdnMediaId %s startDownload[%d %d]", new Object[] { Long.valueOf(l2), Integer.valueOf(localan.jpY), localan.jpT, Long.valueOf(l1), Long.valueOf(localan.gqR) });
          if (localan.jpY == 0) {
            break;
          }
          Log.w(localan.TAG, "moov had callback, do nothing.");
          OnlineVideoView.x(OnlineVideoView.this);
        }
      }
    };
    this.EtE = new j.e()
    {
      public final void bLh()
      {
        AppMethodBeat.i(203327);
        Log.i(OnlineVideoView.d(OnlineVideoView.this), "%d on texture update.", new Object[] { Integer.valueOf(OnlineVideoView.this.hashCode()) });
        try
        {
          OnlineVideoView.t(OnlineVideoView.this);
          AppMethodBeat.o(203327);
          return;
        }
        catch (Exception localException)
        {
          Log.e(OnlineVideoView.d(OnlineVideoView.this), "texture view update. error " + localException.toString());
          AppMethodBeat.o(203327);
        }
      }
    };
    this.zrF = new b()
    {
      public final long eja()
      {
        AppMethodBeat.i(203328);
        Log.i(OnlineVideoView.d(OnlineVideoView.this), "%d sns video get online cache", new Object[] { Integer.valueOf(OnlineVideoView.this.hashCode()) });
        com.tencent.mm.kernel.g.aAi();
        com.tencent.mm.kernel.g.aAh().azQ().set(ar.a.Oaq, Boolean.TRUE);
        try
        {
          if ((OnlineVideoView.D(OnlineVideoView.this)) && (OnlineVideoView.this.EtL != null))
          {
            int i = OnlineVideoView.this.EtL.jqc;
            long l = i;
            AppMethodBeat.o(203328);
            return l;
          }
        }
        catch (Exception localException)
        {
          AppMethodBeat.o(203328);
        }
        return 0L;
      }
    };
    this.Eue = true;
    this.mContext = paramContext;
    Log.i(this.TAG, "%d ui init view.", new Object[] { Integer.valueOf(hashCode()) });
    LayoutInflater.from(paramContext).inflate(2131496523, this);
    this.tiQ = ((ImageView)findViewById(2131309829));
    this.tjk = ((RelativeLayout)findViewById(2131309821));
    this.hPF = ((TextView)findViewById(2131309754));
    this.hPF.setVisibility(8);
    this.tne = ((MMPinProgressBtn)findViewById(2131309808));
    this.mEz = ((ProgressBar)findViewById(2131309778));
    this.tmU = ((TextView)findViewById(2131309834));
    com.tencent.mm.modelcontrol.e.baZ();
    if (com.tencent.mm.modelcontrol.e.bbm())
    {
      this.tna = true;
      this.qbJ = new VideoPlayerTextureView(paramContext);
      ((VideoPlayerTextureView)this.qbJ).setIOnlineCache(this.zrF);
      ((VideoPlayerTextureView)this.qbJ).setOpenWithNoneSurface(true);
      h.CyF.idkeyStat(354L, 148L, 1L, false);
    }
    for (;;)
    {
      this.qbJ.setVideoCallback(this);
      paramContext = new RelativeLayout.LayoutParams(-1, -2);
      paramContext.addRule(13);
      this.tjk.addView((View)this.qbJ, paramContext);
      Log.i(this.TAG, "%d switch sync video model isVideoPlay %b %f", new Object[] { Integer.valueOf(hashCode()), Boolean.FALSE, Float.valueOf(0.0F) });
      paramContext = (View)this.qbJ;
      this.tjk.setVisibility(8);
      paramContext.setVisibility(8);
      if (this.Eue) {
        this.tiQ.setVisibility(0);
      }
      AppMethodBeat.o(98060);
      return;
      this.tna = false;
      this.qbJ = new VideoTextureView(paramContext);
      h.CyF.idkeyStat(354L, 149L, 1L, false);
    }
  }
  
  private void W(boolean paramBoolean, int paramInt)
  {
    boolean bool = true;
    AppMethodBeat.i(98076);
    if (this.ebR == null)
    {
      Log.w(this.TAG, "%d start download video but media is null.", new Object[] { Integer.valueOf(hashCode()) });
      AppMethodBeat.o(98076);
      return;
    }
    if (this.EtL == null)
    {
      Log.w(this.TAG, "%d start download video but helper is null.", new Object[] { Integer.valueOf(hashCode()) });
      AppMethodBeat.o(98076);
      return;
    }
    if (this.ebR.Mcw == 2)
    {
      Log.w(this.TAG, "%d it start download video, url type is weixin", new Object[] { Integer.valueOf(hashCode()) });
      this.EtH = 3;
      aj.faJ().a(this.ebR, 4, null, this.DEv);
      AppMethodBeat.o(98076);
      return;
    }
    int i;
    if (!paramBoolean)
    {
      com.tencent.mm.modelcontrol.e.baZ();
      if (com.tencent.mm.modelcontrol.e.bbl())
      {
        Log.i(this.TAG, "%d it start online download video", new Object[] { Integer.valueOf(hashCode()) });
        this.EtH = 1;
        i = paramInt;
        if (paramInt == 0) {
          i = 30;
        }
        paramBoolean = bool;
        if (this.EtL == null) {
          break label286;
        }
        this.EtL.a(this.ebR, this.iXu, this.dJX, paramBoolean, i);
        AppMethodBeat.o(98076);
        return;
      }
    }
    Log.i(this.TAG, "%d it start offline download video", new Object[] { Integer.valueOf(hashCode()) });
    this.EtH = 2;
    if (paramInt != 0) {}
    for (;;)
    {
      paramBoolean = false;
      i = paramInt;
      break;
      paramInt = 31;
    }
    label286:
    Log.w(this.TAG, "onlineVideoHelper is null!!!");
    AppMethodBeat.o(98076);
  }
  
  private void ZA(int paramInt)
  {
    AppMethodBeat.i(98071);
    String str = ar.ki(aj.getAccSnsPath(), this.ebR.Id) + r.e(this.ebR);
    Intent localIntent = new Intent();
    localIntent.putExtra("Select_Conv_Type", 3);
    localIntent.putExtra("select_is_ret", true);
    localIntent.putExtra("mutil_select_is_ret", true);
    localIntent.putExtra("image_path", str);
    localIntent.putExtra("Retr_Msg_Type", 11);
    Log.i(this.TAG, "send video path %s reqCode %d", new Object[] { str, Integer.valueOf(paramInt) });
    com.tencent.mm.br.c.c(getActivityContext(), ".ui.transmit.SelectConversationUI", localIntent, paramInt);
    this.ecB = 0;
    AppMethodBeat.o(98071);
  }
  
  private void aV(final int paramInt, final boolean paramBoolean)
  {
    AppMethodBeat.i(98072);
    this.qaC.post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(98040);
        Object localObject1 = aj.faO().aQm(OnlineVideoView.c(OnlineVideoView.this));
        if (localObject1 == null)
        {
          AppMethodBeat.o(98040);
          return;
        }
        Log.i(OnlineVideoView.d(OnlineVideoView.this), "fav download video[%s] farFromScene %d isFromMain %b", new Object[] { OnlineVideoView.c(OnlineVideoView.this), Integer.valueOf(paramInt), Boolean.valueOf(paramBoolean) });
        Object localObject2 = new cz();
        ((cz)localObject2).dFZ.dGf = paramInt;
        ((cz)localObject2).dFZ.activity = ((Activity)OnlineVideoView.this.getActivityContext());
        com.tencent.mm.plugin.sns.l.a.a((cz)localObject2, (SnsInfo)localObject1);
        EventCenter.instance.publish((IEvent)localObject2);
        if (((cz)localObject2).dGa.ret == 0) {
          OnlineVideoView.fgs();
        }
        for (;;)
        {
          if (paramBoolean)
          {
            localObject2 = new vj();
            ((vj)localObject2).ebG.dHp = ((SnsInfo)localObject1).getLocalid();
            ((vj)localObject2).ebG.dRS = r.v((SnsInfo)localObject1);
            EventCenter.instance.publish((IEvent)localObject2);
          }
          OnlineVideoView.e(OnlineVideoView.this);
          if (OnlineVideoView.this.qbJ == null) {
            break label328;
          }
          if (!Util.isNullOrNil(OnlineVideoView.this.qbJ.getVideoPath())) {
            break;
          }
          Log.i(OnlineVideoView.d(OnlineVideoView.this), "%d had not set video path to play", new Object[] { Integer.valueOf(OnlineVideoView.this.hashCode()) });
          localObject1 = ay.a(OnlineVideoView.c(OnlineVideoView.this), OnlineVideoView.f(OnlineVideoView.this));
          if (!Util.isNullOrNil((String)localObject1)) {
            OnlineVideoView.this.cq((String)localObject1, false);
          }
          AppMethodBeat.o(98040);
          return;
          OnlineVideoView.fgt();
        }
        if (!OnlineVideoView.this.qbJ.isPlaying())
        {
          OnlineVideoView.this.qbJ.start();
          AppMethodBeat.o(98040);
          return;
        }
        label328:
        AppMethodBeat.o(98040);
      }
    });
    AppMethodBeat.o(98072);
  }
  
  private void cWZ()
  {
    AppMethodBeat.i(98075);
    if (!this.isPreview) {}
    for (String str = ay.a(this.dJX, this.ebR);; str = this.EtI)
    {
      Log.i(this.TAG, "%d toggleVideo local id %s finish path %s isPreview %b", new Object[] { Integer.valueOf(hashCode()), this.dJX, str, Boolean.valueOf(this.isPreview) });
      if (Util.isNullOrNil(str)) {
        break;
      }
      Log.i(this.TAG, "%d sns video already download finish, play now", new Object[] { Integer.valueOf(hashCode()) });
      d(true, 0.0F);
      cq(str, false);
      AppMethodBeat.o(98075);
      return;
    }
    d(false, 0.0F);
    W(false, 0);
    showLoading();
    AppMethodBeat.o(98075);
  }
  
  private boolean cXc()
  {
    AppMethodBeat.i(98086);
    if (!this.EtM)
    {
      AppMethodBeat.o(98086);
      return false;
    }
    com.tencent.mm.kernel.g.aAi();
    boolean bool = com.tencent.mm.kernel.g.aAh().azQ().getBoolean(ar.a.Oaq, false);
    AppMethodBeat.o(98086);
    return bool;
  }
  
  private void d(final boolean paramBoolean, final float paramFloat)
  {
    AppMethodBeat.i(98074);
    this.qaC.post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(98054);
        Log.i(OnlineVideoView.d(OnlineVideoView.this), "%d switch video model isVideoPlay %b %f", new Object[] { Integer.valueOf(OnlineVideoView.this.hashCode()), Boolean.valueOf(paramBoolean), Float.valueOf(paramFloat) });
        View localView = (View)OnlineVideoView.this.qbJ;
        if (paramBoolean)
        {
          OnlineVideoView.m(OnlineVideoView.this).setAlpha(paramFloat);
          OnlineVideoView.m(OnlineVideoView.this).setVisibility(0);
          localView.setAlpha(paramFloat);
          localView.setVisibility(0);
          if (paramFloat >= 1.0D)
          {
            OnlineVideoView.n(OnlineVideoView.this).setVisibility(8);
            AppMethodBeat.o(98054);
          }
        }
        else
        {
          OnlineVideoView.m(OnlineVideoView.this).setVisibility(8);
          localView.setVisibility(8);
          if (OnlineVideoView.o(OnlineVideoView.this)) {
            OnlineVideoView.n(OnlineVideoView.this).setVisibility(0);
          }
        }
        AppMethodBeat.o(98054);
      }
    });
    AppMethodBeat.o(98074);
  }
  
  private void fgk()
  {
    AppMethodBeat.i(203335);
    int j = 2131231381;
    int i = j;
    if (this.ebR != null)
    {
      i = j;
      if (this.ebR.isAd)
      {
        Log.i(this.TAG, "the media is ad, the background should be transparent");
        i = 2131235359;
      }
    }
    boolean bool = aj.faL().b(this.ebR, this.tiQ, i, this.mContext.hashCode(), this.DEv);
    Log.i(this.TAG, "%d fresh thumb image %b", new Object[] { Integer.valueOf(hashCode()), Boolean.valueOf(bool) });
    AppMethodBeat.o(203335);
  }
  
  private void fgm()
  {
    AppMethodBeat.i(98073);
    p.a(getContext(), new android.support.v4.e.c() {});
    AppMethodBeat.o(98073);
  }
  
  private void fgo()
  {
    AppMethodBeat.i(98092);
    this.Eua = Util.nowMilliSecond();
    Log.d(this.TAG, "%d notePlayVideo notePlayVideo %d ", new Object[] { Integer.valueOf(hashCode()), Long.valueOf(this.Eua) });
    AppMethodBeat.o(98092);
  }
  
  private void fgp()
  {
    AppMethodBeat.i(98093);
    if (this.Eua > 0L) {
      this.Eub = ((int)(this.Eub + (Util.nowMilliSecond() - this.Eua) / 1000L));
    }
    Log.i(this.TAG, "%d notePauseVideo playVideoDuration %d ", new Object[] { Integer.valueOf(hashCode()), Integer.valueOf(this.Eub) });
    this.Eua = 0L;
    AppMethodBeat.o(98093);
  }
  
  private void fgq()
  {
    AppMethodBeat.i(98095);
    this.Euc = Util.nowMilliSecond();
    Log.d(this.TAG, "%d noteResumeVideo noteResumeVideo %d ", new Object[] { Integer.valueOf(hashCode()), Long.valueOf(this.Euc) });
    AppMethodBeat.o(98095);
  }
  
  private void fgr()
  {
    AppMethodBeat.i(98096);
    if (this.Euc > 0L)
    {
      this.Eud = 0;
      this.Eud = ((int)(this.Eud + (Util.nowMilliSecond() - this.Euc) / 1000L));
    }
    Log.i(this.TAG, "%d notePauseVideoByResume playVideoDuration %d ", new Object[] { Integer.valueOf(hashCode()), Integer.valueOf(this.Eud) });
    this.Euc = 0L;
    AppMethodBeat.o(98096);
  }
  
  private void hideLoading()
  {
    AppMethodBeat.i(98080);
    this.qaC.post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(98057);
        if ((OnlineVideoView.p(OnlineVideoView.this) != null) && (OnlineVideoView.p(OnlineVideoView.this).getVisibility() != 8))
        {
          Log.i(OnlineVideoView.d(OnlineVideoView.this), "%d hide loading.", new Object[] { Integer.valueOf(OnlineVideoView.this.hashCode()) });
          OnlineVideoView.p(OnlineVideoView.this).setVisibility(8);
        }
        if ((OnlineVideoView.q(OnlineVideoView.this) != null) && (OnlineVideoView.q(OnlineVideoView.this).getVisibility() != 8))
        {
          Log.i(OnlineVideoView.d(OnlineVideoView.this), "%d hide progress.", new Object[] { Integer.valueOf(OnlineVideoView.this.hashCode()) });
          OnlineVideoView.q(OnlineVideoView.this).setVisibility(8);
        }
        AppMethodBeat.o(98057);
      }
    });
    AppMethodBeat.o(98080);
  }
  
  private void showLoading()
  {
    AppMethodBeat.i(98079);
    this.qaC.post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(98056);
        Log.i(OnlineVideoView.d(OnlineVideoView.this), "%d show loading. downloadMode %d", new Object[] { Integer.valueOf(OnlineVideoView.this.hashCode()), Integer.valueOf(OnlineVideoView.r(OnlineVideoView.this)) });
        if (OnlineVideoView.r(OnlineVideoView.this) == 1)
        {
          if ((OnlineVideoView.p(OnlineVideoView.this) != null) && (OnlineVideoView.p(OnlineVideoView.this).getVisibility() != 0)) {
            OnlineVideoView.p(OnlineVideoView.this).setVisibility(0);
          }
          if ((OnlineVideoView.q(OnlineVideoView.this) != null) && (OnlineVideoView.q(OnlineVideoView.this).getVisibility() != 8)) {
            OnlineVideoView.q(OnlineVideoView.this).setVisibility(8);
          }
        }
        if (OnlineVideoView.r(OnlineVideoView.this) == 2)
        {
          if ((OnlineVideoView.q(OnlineVideoView.this) != null) && (OnlineVideoView.q(OnlineVideoView.this).getVisibility() != 0)) {
            OnlineVideoView.q(OnlineVideoView.this).setVisibility(0);
          }
          if ((OnlineVideoView.p(OnlineVideoView.this) != null) && (OnlineVideoView.p(OnlineVideoView.this).getVisibility() != 8)) {
            OnlineVideoView.p(OnlineVideoView.this).setVisibility(8);
          }
        }
        if (OnlineVideoView.r(OnlineVideoView.this) == 3)
        {
          if ((OnlineVideoView.q(OnlineVideoView.this) != null) && (OnlineVideoView.q(OnlineVideoView.this).getVisibility() != 0))
          {
            OnlineVideoView.q(OnlineVideoView.this).setVisibility(0);
            OnlineVideoView.q(OnlineVideoView.this).gYN();
          }
          if ((OnlineVideoView.p(OnlineVideoView.this) != null) && (OnlineVideoView.p(OnlineVideoView.this).getVisibility() != 8)) {
            OnlineVideoView.p(OnlineVideoView.this).setVisibility(8);
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
    //   2: ldc_w 810
    //   5: invokestatic 160	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   8: aload_0
    //   9: getfield 249	com/tencent/mm/plugin/sns/ui/OnlineVideoView:isInit	Z
    //   12: ifne +12 -> 24
    //   15: ldc_w 810
    //   18: invokestatic 424	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   21: aload_0
    //   22: monitorexit
    //   23: return
    //   24: aload_0
    //   25: iconst_0
    //   26: putfield 249	com/tencent/mm/plugin/sns/ui/OnlineVideoView:isInit	Z
    //   29: aload_0
    //   30: getfield 186	com/tencent/mm/plugin/sns/ui/OnlineVideoView:TAG	Ljava/lang/String;
    //   33: ldc_w 812
    //   36: iconst_1
    //   37: anewarray 169	java/lang/Object
    //   40: dup
    //   41: iconst_0
    //   42: aload_0
    //   43: invokevirtual 173	java/lang/Object:hashCode	()I
    //   46: invokestatic 296	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   49: aastore
    //   50: invokestatic 301	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   53: aload_0
    //   54: invokespecial 448	com/tencent/mm/plugin/sns/ui/OnlineVideoView:fgp	()V
    //   57: aload_0
    //   58: invokespecial 814	com/tencent/mm/plugin/sns/ui/OnlineVideoView:fgr	()V
    //   61: aload_0
    //   62: getfield 363	com/tencent/mm/plugin/sns/ui/OnlineVideoView:qbJ	Lcom/tencent/mm/pluginsdk/ui/tools/j;
    //   65: invokeinterface 817 1 0
    //   70: getstatic 823	com/tencent/mm/sdk/event/EventCenter:instance	Lcom/tencent/mm/sdk/event/EventCenter;
    //   73: aload_0
    //   74: getfield 278	com/tencent/mm/plugin/sns/ui/OnlineVideoView:DOo	Lcom/tencent/mm/sdk/event/IListener;
    //   77: invokevirtual 827	com/tencent/mm/sdk/event/EventCenter:removeListener	(Lcom/tencent/mm/sdk/event/IListener;)Z
    //   80: pop
    //   81: getstatic 823	com/tencent/mm/sdk/event/EventCenter:instance	Lcom/tencent/mm/sdk/event/EventCenter;
    //   84: aload_0
    //   85: getfield 272	com/tencent/mm/plugin/sns/ui/OnlineVideoView:EtY	Lcom/tencent/mm/sdk/event/IListener;
    //   88: invokevirtual 827	com/tencent/mm/sdk/event/EventCenter:removeListener	(Lcom/tencent/mm/sdk/event/IListener;)Z
    //   91: pop
    //   92: invokestatic 478	com/tencent/mm/plugin/sns/model/aj:faJ	()Lcom/tencent/mm/plugin/sns/model/c;
    //   95: aload_0
    //   96: getfield 269	com/tencent/mm/plugin/sns/ui/OnlineVideoView:EtX	Lcom/tencent/mm/plugin/sns/model/c$b;
    //   99: invokevirtual 830	com/tencent/mm/plugin/sns/model/c:b	(Lcom/tencent/mm/plugin/sns/model/c$b;)V
    //   102: aload_0
    //   103: invokevirtual 833	com/tencent/mm/plugin/sns/ui/OnlineVideoView:fgc	()V
    //   106: aload_0
    //   107: getfield 231	com/tencent/mm/plugin/sns/ui/OnlineVideoView:qaC	Lcom/tencent/mm/sdk/platformtools/MMHandler;
    //   110: aconst_null
    //   111: invokevirtual 837	com/tencent/mm/sdk/platformtools/MMHandler:removeCallbacksAndMessages	(Ljava/lang/Object;)V
    //   114: aload_0
    //   115: getfield 200	com/tencent/mm/plugin/sns/ui/OnlineVideoView:EtL	Lcom/tencent/mm/plugin/sns/ui/an;
    //   118: ifnull +18 -> 136
    //   121: aload_0
    //   122: getfield 200	com/tencent/mm/plugin/sns/ui/OnlineVideoView:EtL	Lcom/tencent/mm/plugin/sns/ui/an;
    //   125: invokevirtual 840	com/tencent/mm/plugin/sns/ui/an:fgw	()Z
    //   128: pop
    //   129: aload_0
    //   130: getfield 200	com/tencent/mm/plugin/sns/ui/OnlineVideoView:EtL	Lcom/tencent/mm/plugin/sns/ui/an;
    //   133: invokevirtual 843	com/tencent/mm/plugin/sns/ui/an:clear	()V
    //   136: invokestatic 849	com/tencent/mm/q/a:Xi	()Lcom/tencent/mm/model/an;
    //   139: ifnull +11 -> 150
    //   142: invokestatic 849	com/tencent/mm/q/a:Xi	()Lcom/tencent/mm/model/an;
    //   145: invokeinterface 854 1 0
    //   150: aload_0
    //   151: getfield 216	com/tencent/mm/plugin/sns/ui/OnlineVideoView:pNk	Lcom/tencent/mm/model/d;
    //   154: ifnull +12 -> 166
    //   157: aload_0
    //   158: getfield 216	com/tencent/mm/plugin/sns/ui/OnlineVideoView:pNk	Lcom/tencent/mm/model/d;
    //   161: iconst_0
    //   162: invokevirtual 860	com/tencent/mm/model/d:fp	(Z)Z
    //   165: pop
    //   166: aload_0
    //   167: aconst_null
    //   168: putfield 216	com/tencent/mm/plugin/sns/ui/OnlineVideoView:pNk	Lcom/tencent/mm/model/d;
    //   171: aload_0
    //   172: aconst_null
    //   173: putfield 196	com/tencent/mm/plugin/sns/ui/OnlineVideoView:ebR	Lcom/tencent/mm/protocal/protobuf/cnb;
    //   176: aload_0
    //   177: aconst_null
    //   178: putfield 494	com/tencent/mm/plugin/sns/ui/OnlineVideoView:dJX	Ljava/lang/String;
    //   181: aload_0
    //   182: aconst_null
    //   183: putfield 200	com/tencent/mm/plugin/sns/ui/OnlineVideoView:EtL	Lcom/tencent/mm/plugin/sns/ui/an;
    //   186: aload_0
    //   187: iconst_0
    //   188: putfield 208	com/tencent/mm/plugin/sns/ui/OnlineVideoView:EtP	I
    //   191: ldc_w 810
    //   194: invokestatic 424	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   197: goto -176 -> 21
    //   200: astore_1
    //   201: aload_0
    //   202: monitorexit
    //   203: aload_1
    //   204: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	205	0	this	OnlineVideoView
    //   200	4	1	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	21	200	finally
    //   24	136	200	finally
    //   136	150	200	finally
    //   150	166	200	finally
    //   166	197	200	finally
  }
  
  public final void Zz(int paramInt)
  {
    AppMethodBeat.i(203337);
    a locala = this.EtK;
    if (locala != null) {
      locala.xv(paramInt);
    }
    AppMethodBeat.o(203337);
  }
  
  public final void a(cnb paramcnb, String paramString, int paramInt)
  {
    AppMethodBeat.i(98065);
    this.dJX = paramString;
    this.iXu = paramInt;
    paramString = bp.gCZ();
    paramString.hXs = this.iXu;
    this.DEv = paramString;
    if (this.ebR != paramcnb)
    {
      this.ebR = paramcnb;
      fgk();
    }
    this.isPreview = false;
    Log.i(this.TAG, "%d set video data[%s, %d] isPreview %b self %s", new Object[] { Integer.valueOf(hashCode()), this.dJX, Integer.valueOf(this.iXu), Boolean.valueOf(this.isPreview), this });
    AppMethodBeat.o(98065);
  }
  
  public final void aM(Activity paramActivity)
  {
    this.EtV = paramActivity;
    this.EtW = true;
  }
  
  public final void aT(int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(203336);
    Log.i(this.TAG, "%d seek second %d afterSeekPlay %b", new Object[] { Integer.valueOf(hashCode()), Integer.valueOf(paramInt), Boolean.valueOf(paramBoolean) });
    this.EtP = 0;
    hideLoading();
    this.qbJ.d(paramInt * 1000, paramBoolean);
    fO(false);
    AppMethodBeat.o(203336);
  }
  
  public final void aTw() {}
  
  public final void aTx() {}
  
  public final void aTy() {}
  
  public final void aTz() {}
  
  public final void abandonAudioFocus()
  {
    AppMethodBeat.i(98062);
    if (this.pNk != null) {
      this.pNk.fp(false);
    }
    AppMethodBeat.o(98062);
  }
  
  public final void bgW()
  {
    AppMethodBeat.i(98090);
    Log.i(this.TAG, "%d pauseByDataBlock", new Object[] { Integer.valueOf(hashCode()) });
    fgp();
    showLoading();
    cXa();
    AppMethodBeat.o(98090);
  }
  
  public final void cXa()
  {
    AppMethodBeat.i(98078);
    if (this.qbJ.isPlaying())
    {
      Log.i(this.TAG, "%d pause play", new Object[] { Integer.valueOf(hashCode()) });
      fgp();
      fgr();
      this.qbJ.pause();
    }
    AppMethodBeat.o(98078);
  }
  
  public final void cq(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(98087);
    Log.i(this.TAG, "%d prepare video isOnlinePlay %b filePath %s", new Object[] { Integer.valueOf(hashCode()), Boolean.valueOf(paramBoolean), paramString });
    if (Util.isNullOrNil(paramString))
    {
      Log.w(this.TAG, "%d prepare video but filepath is null.", new Object[] { Integer.valueOf(hashCode()) });
      AppMethodBeat.o(98087);
      return;
    }
    this.EtM = paramBoolean;
    String str;
    if (this.qbJ != null)
    {
      if (this.EtP == -3) {
        break label318;
      }
      if ((this.qbJ instanceof VideoPlayerTextureView))
      {
        ((VideoPlayerTextureView)this.qbJ).setNeedResetExtractor(cXc());
        ((VideoPlayerTextureView)this.qbJ).setIsOnlineVideoType(paramBoolean);
      }
      this.qbJ.setOneTimeVideoTextureUpdateCallback(this.EtE);
      MultiProcessMMKV localMultiProcessMMKV = MultiProcessMMKV.getMMKV("TrackDataSource");
      if (this.ebR != null) {
        break label296;
      }
      str = "";
      localMultiProcessMMKV.putString("media-url", str);
      if (this.ebR != null) {
        break label307;
      }
      str = "";
      label186:
      localMultiProcessMMKV.putString("thumb-url", str);
      localMultiProcessMMKV.putLong("prepare-ts", System.currentTimeMillis());
      localMultiProcessMMKV.putString("prepare-path", paramString);
      localMultiProcessMMKV.commit();
      this.qbJ.setVideoPath(paramString);
      d(true, 0.0F);
    }
    for (;;)
    {
      com.tencent.mm.kernel.g.aAi();
      if (((Integer)com.tencent.mm.kernel.g.aAh().azQ().get(ar.a.NYY, Integer.valueOf(0))).intValue() == 1)
      {
        this.tmU.setText(com.tencent.mm.plugin.sight.base.e.aFm(paramString));
        this.tmU.setVisibility(0);
      }
      AppMethodBeat.o(98087);
      return;
      label296:
      str = this.ebR.Url;
      break;
      label307:
      str = this.ebR.Msz;
      break label186;
      label318:
      Log.i(this.TAG, "%d prepare video reset source", new Object[] { Integer.valueOf(hashCode()) });
      if ((this.qbJ instanceof VideoPlayerTextureView)) {
        ((VideoPlayerTextureView)this.qbJ).gsH();
      }
      aT(this.EtO, true);
    }
  }
  
  public void eYd()
  {
    AppMethodBeat.i(98089);
    if (!this.qbJ.isPlaying())
    {
      fgq();
      int i = this.qbJ.getDuration();
      int j = this.qbJ.getCurrentPosition();
      if (j >= i) {
        Log.e(this.TAG, "the current position is more than duration, current = %d, duration = %d !!!", new Object[] { Integer.valueOf(j), Integer.valueOf(i) });
      }
      this.qbJ.start();
    }
    AppMethodBeat.o(98089);
  }
  
  public final void eo(int paramInt1, int paramInt2)
  {
    this.videoWidth = paramInt1;
    this.videoHeight = paramInt2;
  }
  
  protected final void fO(boolean paramBoolean)
  {
    AppMethodBeat.i(98081);
    if (this.EtM)
    {
      if (paramBoolean)
      {
        MMHandlerThread.postToMainThread(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(203334);
            if ((OnlineVideoView.this.qbJ != null) && (OnlineVideoView.this.EtL != null))
            {
              int i = OnlineVideoView.this.qbJ.getCurrentPosition() / 1000;
              OnlineVideoView.this.EtL.ub(i);
            }
            OnlineVideoView.s(OnlineVideoView.this).startTimer(500L);
            AppMethodBeat.o(203334);
          }
        });
        AppMethodBeat.o(98081);
        return;
      }
      this.Ehq.startTimer(500L);
      AppMethodBeat.o(98081);
      return;
    }
    this.qbP.startTimer(500L);
    AppMethodBeat.o(98081);
  }
  
  public final void fgc()
  {
    AppMethodBeat.i(98082);
    this.Ehq.stopTimer();
    this.qbP.stopTimer();
    AppMethodBeat.o(98082);
  }
  
  public final void fgg()
  {
    this.EtS = false;
  }
  
  public final void fgh()
  {
    AppMethodBeat.i(98063);
    Log.d(this.TAG, "%d register sns ui event", new Object[] { Integer.valueOf(hashCode()) });
    EventCenter.instance.addListener(this.EtZ);
    AppMethodBeat.o(98063);
  }
  
  public final void fgi()
  {
    AppMethodBeat.i(98064);
    Log.d(this.TAG, "%d unRegister sns ui event", new Object[] { Integer.valueOf(hashCode()) });
    EventCenter.instance.removeListener(this.EtZ);
    AppMethodBeat.o(98064);
  }
  
  public final String fgj()
  {
    AppMethodBeat.i(98066);
    Object localObject = new StringBuffer();
    try
    {
      if (this.ebR != null) {
        ((StringBuffer)localObject).append("media: " + this.ebR.Id);
      }
      if (this.dJX != null) {
        ((StringBuffer)localObject).append("localId: " + this.dJX);
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        Log.printErrStackTrace(this.TAG, localException, "", new Object[0]);
      }
    }
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(98066);
    return localObject;
  }
  
  public final void fgl()
  {
    this.EtV = null;
    this.EtW = false;
  }
  
  public final boolean fgn()
  {
    boolean bool = true;
    AppMethodBeat.i(98088);
    Log.i(this.TAG, "%d resumeByDataGain", new Object[] { Integer.valueOf(hashCode()) });
    if (!this.qbJ.isPlaying())
    {
      fgo();
      fgq();
      bool = this.qbJ.start();
      hideLoading();
    }
    AppMethodBeat.o(98088);
    return bool;
  }
  
  public final int fh(int paramInt1, int paramInt2)
  {
    return 0;
  }
  
  protected Context getActivityContext()
  {
    if (this.EtV == null) {
      return this.mContext;
    }
    return this.EtV;
  }
  
  public int getCurrentPosition()
  {
    AppMethodBeat.i(98100);
    int i = this.qbJ.getCurrentPosition();
    AppMethodBeat.o(98100);
    return i;
  }
  
  public int getDuration()
  {
    AppMethodBeat.i(98077);
    if (this.qbJ == null)
    {
      AppMethodBeat.o(98077);
      return 0;
    }
    int i = this.qbJ.getDuration();
    AppMethodBeat.o(98077);
    return i;
  }
  
  public String getFilePath()
  {
    return this.filePath;
  }
  
  public int getPlayErrorCode()
  {
    return this.tnb;
  }
  
  public int getPlayVideoDuration()
  {
    AppMethodBeat.i(98094);
    if (this.Eub < 0) {
      this.Eub = 0;
    }
    Log.i(this.TAG, "%d get play video duration [%d]", new Object[] { Integer.valueOf(hashCode()), Integer.valueOf(this.Eub) });
    int i = this.Eub;
    AppMethodBeat.o(98094);
    return i;
  }
  
  public int getPlayVideoDurationByResume()
  {
    AppMethodBeat.i(98097);
    if (this.Eud < 0) {
      this.Eud = 0;
    }
    Log.i(this.TAG, "%d get play video duration by resume [%d]", new Object[] { Integer.valueOf(hashCode()), Integer.valueOf(this.Eud) });
    int i = this.Eud;
    AppMethodBeat.o(98097);
    return i;
  }
  
  public an.c getRptStruct()
  {
    AppMethodBeat.i(98099);
    an.c localc = new an.c();
    localc.scene = this.scene;
    localc.sessionId = this.sessionId;
    localc.EtT = this.EtT;
    localc.dRS = this.dRS;
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
    return this.EtT;
  }
  
  public String getSnsId()
  {
    return this.dRS;
  }
  
  public int getUiStayTime()
  {
    if ((this.EtR > 0L) && (this.EtQ > 0L)) {}
    for (int i = (int)(this.EtR - this.EtQ);; i = 0)
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
    boolean bool = this.qbJ.isPlaying();
    AppMethodBeat.o(98098);
    return bool;
  }
  
  public final void onCompletion()
  {
    AppMethodBeat.i(98085);
    Log.i(this.TAG, "%d on completion", new Object[] { Integer.valueOf(hashCode()) });
    Object localObject = this.EtK;
    if (localObject == null)
    {
      if ((com.tencent.mm.compatible.util.d.oF(18)) || (!this.tna))
      {
        aT(0, true);
        AppMethodBeat.o(98085);
        return;
      }
      if (this.qbJ != null)
      {
        localObject = this.qbJ.getVideoPath();
        this.qbJ.stop();
        cq((String)localObject, this.EtM);
        AppMethodBeat.o(98085);
      }
    }
    else
    {
      ((a)localObject).onCompletion();
    }
    AppMethodBeat.o(98085);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(98070);
    Log.d(this.TAG, "%d on destroy %s", new Object[] { Integer.valueOf(hashCode()), Util.getStack() });
    this.EtR = Util.nowMilliSecond();
    unInit();
    AppMethodBeat.o(98070);
  }
  
  public final void onError(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(98083);
    Log.e(this.TAG, "%d on play video error what %d extra %d. isOnlinePlay %b isMMVideoPlayer[%b]", new Object[] { Integer.valueOf(hashCode()), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Boolean.valueOf(this.EtM), Boolean.valueOf(this.tna) });
    Object localObject;
    if (this.EtM)
    {
      h.CyF.idkeyStat(354L, 230L, 1L, false);
      this.tnb = paramInt2;
      fgp();
      localObject = this.qbJ.getVideoPath();
      this.EtO = (this.qbJ.getCurrentPosition() / 1000);
      if (!this.EtM) {
        break label409;
      }
      if (paramInt1 != -2) {
        break label370;
      }
      this.qbJ.stop();
    }
    for (;;)
    {
      label409:
      try
      {
        showLoading();
        if (this.EtL != null)
        {
          localObject = this.EtL;
          String str = ((an)localObject).jpT + 0 + "_-1";
          if (!((an)localObject).Euo.containsKey(str))
          {
            Log.i(((an)localObject).TAG, "request all data. [%s]", new Object[] { ((an)localObject).jpT });
            com.tencent.mm.modelvideo.o.bhk();
            com.tencent.mm.an.e.r(((an)localObject).jpT, 0, -1);
            ((an)localObject).Euo.put(str, Integer.valueOf(0));
            h.CyF.idkeyStat(354L, 207L, 1L, false);
            h.CyF.a(13836, new Object[] { Integer.valueOf(403), Long.valueOf(Util.nowSecond()), "" });
          }
          ((an)localObject).jpW = 5;
          ((an)localObject).jqb = true;
          ((an)localObject).jqe = false;
        }
        fgp();
      }
      catch (Exception localException)
      {
        label370:
        continue;
      }
      if ((this.ebR != null) && (this.ebR.isAd)) {
        h.CyF.dN(1579, 8);
      }
      AppMethodBeat.o(98083);
      return;
      h.CyF.idkeyStat(354L, 231L, 1L, false);
      break;
      if (paramInt1 == -3)
      {
        this.EtP = paramInt1;
        this.qbJ.pause();
      }
      else
      {
        fgc();
        this.qbJ.stop();
        continue;
        this.qbJ.stop();
        this.tmZ = true;
        d(false, 0.0F);
        Log.w(this.TAG, "error %s, %s", new Object[] { Boolean.valueOf(this.EtW), localObject });
        if ((!Util.isNullOrNil((String)localObject)) && (this.EtW))
        {
          Log.w(this.TAG, "%d start third player to play", new Object[] { Integer.valueOf(hashCode()) });
          this.qaC.post(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(98051);
              Object localObject = new Intent();
              ((Intent)localObject).setAction("android.intent.action.VIEW");
              FileProviderHelper.setIntentDataAndType(OnlineVideoView.this.getContext(), (Intent)localObject, new com.tencent.mm.vfs.o(this.tnl), "video/*", false);
              try
              {
                Context localContext = OnlineVideoView.this.getContext();
                localObject = new com.tencent.mm.hellhoundlib.b.a().bl(localObject);
                com.tencent.mm.hellhoundlib.a.a.a(localContext, ((com.tencent.mm.hellhoundlib.b.a)localObject).axQ(), "com/tencent/mm/plugin/sns/ui/OnlineVideoView$17", "run", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                localContext.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).pG(0));
                com.tencent.mm.hellhoundlib.a.a.a(localContext, "com/tencent/mm/plugin/sns/ui/OnlineVideoView$17", "run", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                AppMethodBeat.o(98051);
                return;
              }
              catch (Exception localException)
              {
                Log.e(OnlineVideoView.d(OnlineVideoView.this), "startActivity fail, activity not found");
                try
                {
                  f.a locala = new f.a(OnlineVideoView.this.getContext());
                  locala.bow(OnlineVideoView.this.getContext().getString(2131759255));
                  locala.aC(OnlineVideoView.this.getContext().getString(2131759256)).c(new f.c()
                  {
                    public final void e(boolean paramAnonymous2Boolean, String paramAnonymous2String) {}
                  }).show();
                  AppMethodBeat.o(98051);
                  return;
                }
                catch (Throwable localThrowable)
                {
                  Log.e(OnlineVideoView.d(OnlineVideoView.this), "showAlert fail");
                  AppMethodBeat.o(98051);
                }
              }
            }
          });
        }
      }
    }
  }
  
  public final void onPause()
  {
    AppMethodBeat.i(98069);
    Log.d(this.TAG, "%d on pause %s ", new Object[] { Integer.valueOf(hashCode()), Util.getStack() });
    fgc();
    if (this.qbJ != null) {
      this.qbJ.stop();
    }
    AppMethodBeat.o(98069);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(98068);
    Log.d(this.TAG, "%d on resume %s", new Object[] { Integer.valueOf(hashCode()), Util.getStack() });
    this.EtQ = Util.nowMilliSecond();
    if (this.EtU)
    {
      Log.e(this.TAG, "what are you doing guys!!! Would you like to invite everyone to eat pizza??? %s", new Object[] { Util.getStack() });
      h.CyF.n(31L, 3L, 1L);
    }
    for (;;)
    {
      if (!this.tmZ) {
        cWZ();
      }
      this.Etz = true;
      AppMethodBeat.o(98068);
      return;
      if (this.EtL == null)
      {
        this.isInit = true;
        Log.i(this.TAG, "%d logic init, create new helper and add listener.", new Object[] { Integer.valueOf(hashCode()) });
        this.EtL = new an(this);
        Log.i(this.TAG, "onlineVideoHelper hash:%d", new Object[] { Integer.valueOf(this.EtL.hashCode()) });
        EventCenter.instance.addListener(this.DOo);
        EventCenter.instance.addListener(this.EtY);
        aj.faJ().a(this.EtX);
        if (this.EtS)
        {
          this.pNk = new com.tencent.mm.model.d();
          this.pNk.a(this);
        }
        if (com.tencent.mm.q.a.Xi() != null) {
          com.tencent.mm.q.a.Xi().akr();
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
    this.guh = paramBoolean;
    this.qbJ.setMute(this.guh);
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
    this.EtT = paramLong;
  }
  
  public void setSnsId(String paramString)
  {
    this.dRS = paramString;
  }
  
  public void setThumbViewScaleType(ImageView.ScaleType paramScaleType)
  {
    AppMethodBeat.i(98101);
    this.tiQ.setScaleType(paramScaleType);
    AppMethodBeat.o(98101);
  }
  
  public void setVideoCallback(a parama)
  {
    this.EtK = parama;
  }
  
  public void setVideoScaleType(i.e parame)
  {
    AppMethodBeat.i(98102);
    if (this.qbJ != null)
    {
      if ((this.qbJ instanceof VideoPlayerTextureView))
      {
        ((VideoPlayerTextureView)this.qbJ).setScaleType(parame);
        AppMethodBeat.o(98102);
        return;
      }
      if ((this.qbJ instanceof VideoTextureView)) {
        ((VideoTextureView)this.qbJ).setScaleType(parame);
      }
    }
    AppMethodBeat.o(98102);
  }
  
  public final void tf()
  {
    AppMethodBeat.i(98084);
    Log.i(this.TAG, "%d onPrepared playErrorCode[%d] onErrorPlayTimeSec[%d]", new Object[] { Integer.valueOf(hashCode()), Integer.valueOf(this.tnb), Integer.valueOf(this.EtO) });
    this.tnb = 0;
    if (this.EtO > 0)
    {
      aT(this.EtO, true);
      this.EtO = 0;
      AppMethodBeat.o(98084);
      return;
    }
    this.EtP = 0;
    hideLoading();
    fgo();
    fgq();
    this.qbJ.start();
    this.duration = (this.qbJ.getDuration() / 1000);
    Log.i(this.TAG, "%d start play duration %d sns local id %s ", new Object[] { Integer.valueOf(hashCode()), Integer.valueOf(this.duration), this.dJX });
    fO(false);
    a locala = this.EtK;
    if (locala != null) {
      locala.onStart(this.duration);
    }
    AppMethodBeat.o(98084);
  }
  
  public static abstract interface a
  {
    public abstract void onCompletion();
    
    public abstract void onStart(int paramInt);
    
    public abstract void xv(int paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.OnlineVideoView
 * JD-Core Version:    0.7.0.1
 */