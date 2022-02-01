package com.tencent.mm.plugin.sns.ui;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Looper;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.app.AppForegroundDelegate;
import com.tencent.mm.app.j.a;
import com.tencent.mm.app.j.b;
import com.tencent.mm.f.a.dd;
import com.tencent.mm.f.a.dd.b;
import com.tencent.mm.f.a.pn;
import com.tencent.mm.f.a.pn.a;
import com.tencent.mm.f.a.wo;
import com.tencent.mm.f.a.wr;
import com.tencent.mm.f.a.xt;
import com.tencent.mm.f.b.a.mj;
import com.tencent.mm.model.d.a;
import com.tencent.mm.modelvideo.s;
import com.tencent.mm.platformtools.p;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.plugin.sns.data.t;
import com.tencent.mm.plugin.sns.i.d;
import com.tencent.mm.plugin.sns.i.f;
import com.tencent.mm.plugin.sns.i.g;
import com.tencent.mm.plugin.sns.i.j;
import com.tencent.mm.plugin.sns.model.aj;
import com.tencent.mm.plugin.sns.model.aq;
import com.tencent.mm.plugin.sns.model.ax;
import com.tencent.mm.plugin.sns.storage.SnsInfo;
import com.tencent.mm.plugin.sns.storage.n;
import com.tencent.mm.plugin.thumbplayer.view.ThumbPlayerVideoView;
import com.tencent.mm.plugin.thumbplayer.view.ThumbPlayerVideoView.c;
import com.tencent.mm.plugin.thumbplayer.view.ThumbPlayerVideoView.d;
import com.tencent.mm.pluginsdk.ui.seekbar.HeroSeekBarView;
import com.tencent.mm.pluginsdk.ui.seekbar.HeroSeekBarView.b;
import com.tencent.mm.pluginsdk.ui.seekbar.HeroSeekBarView.c;
import com.tencent.mm.pluginsdk.ui.seekbar.HeroSeekBarView.f;
import com.tencent.mm.pluginsdk.ui.tools.VideoPlayerTextureView;
import com.tencent.mm.pluginsdk.ui.tools.VideoTextureView;
import com.tencent.mm.pluginsdk.ui.tools.k;
import com.tencent.mm.pluginsdk.ui.tools.k.a;
import com.tencent.mm.pluginsdk.ui.tools.k.b;
import com.tencent.mm.pluginsdk.ui.tools.k.e;
import com.tencent.mm.pointers.PInt;
import com.tencent.mm.protocal.protobuf.TimeLineObject;
import com.tencent.mm.protocal.protobuf.adw;
import com.tencent.mm.protocal.protobuf.cvt;
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
import com.tencent.mm.storage.ar.a;
import com.tencent.mm.storage.bp;
import com.tencent.mm.ui.widget.MMPinProgressBtn;
import com.tencent.mm.vfs.q;
import com.tencent.mm.vfs.u;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.concurrent.Future;
import kotlinx.coroutines.al;

public class OnlineVideoView
  extends RelativeLayout
  implements d.a, ap.a, k.a
{
  private com.tencent.mm.plugin.u.b EXe;
  private bp JRq;
  private boolean KGW;
  public volatile boolean KHA;
  protected Activity KHB;
  protected boolean KHC;
  private com.tencent.mm.plugin.sns.model.c.b KHD;
  private IListener KHE;
  private IListener KHF;
  private long KHG;
  private int KHH;
  private long KHI;
  private int KHJ;
  private boolean KHK;
  public boolean KHL;
  private int KHM;
  private int KHN;
  private int KHO;
  private k.e KHb;
  private int KHe;
  String KHf;
  private String KHg;
  private boolean KHh;
  private b KHi;
  protected ImageView KHj;
  protected volatile ap KHk;
  private boolean KHl;
  private boolean KHm;
  private int KHn;
  private int KHo;
  private long KHp;
  private long KHq;
  protected boolean KHr;
  private long KHs;
  private boolean KHt;
  protected com.tencent.mm.plugin.thumbplayer.c.i KHu;
  protected com.tencent.mm.plugin.sns.ui.video.c KHv;
  private com.tencent.mm.plugin.sns.ui.video.f KHw;
  private HeroSeekBarView KHx;
  private ImageView KHy;
  private final a KHz;
  private IListener Kbu;
  private MTimerHandler Kux;
  final String TAG;
  private int createTime;
  private int duration;
  private String fCM;
  private String fLp;
  private cvt fVT;
  private int fWD;
  private boolean fWE;
  private int fWF;
  private String filePath;
  private Future<?> fuk;
  private boolean iYs;
  private volatile boolean isInit;
  boolean isPreview;
  private TextView kEb;
  private Context mContext;
  private ProgressBar pDL;
  private int qoA;
  com.tencent.mm.model.d sUi;
  private int scene;
  private String sessionId;
  MMHandler twz;
  protected k txH;
  private MTimerHandler txN;
  private int videoHeight;
  private int videoWidth;
  private RelativeLayout wPB;
  ImageView wPh;
  private MMPinProgressBtn wTC;
  private TextView wTs;
  public boolean wTx;
  private boolean wTy;
  private int wTz;
  
  public OnlineVideoView(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(216052);
    this.TAG = ("MicroMsg.OnlineVideoView[" + hashCode() + ']');
    this.KHe = 0;
    this.isPreview = false;
    this.wTx = false;
    this.iYs = false;
    this.fVT = null;
    this.KHh = false;
    this.KHk = null;
    this.KHm = false;
    this.duration = 0;
    this.KHn = 0;
    this.KHo = 0;
    this.KHp = 0L;
    this.KHq = 0L;
    this.wTz = 0;
    this.sUi = null;
    this.KHr = true;
    this.twz = new MMHandler(Looper.getMainLooper());
    this.scene = 0;
    this.KHs = 0L;
    this.sessionId = "";
    this.fLp = "";
    this.filePath = "";
    this.videoWidth = 0;
    this.videoHeight = 0;
    this.KHt = true;
    this.KHz = new a((byte)0);
    this.isInit = false;
    this.KHA = false;
    this.KHC = false;
    this.Kux = new MTimerHandler(new MTimerHandler.CallBack()
    {
      public final boolean onTimerExpired()
      {
        AppMethodBeat.i(198145);
        if ((OnlineVideoView.this.KHk == null) || (OnlineVideoView.this.txH == null))
        {
          AppMethodBeat.o(198145);
          return false;
        }
        if (((View)OnlineVideoView.this.txH).getAlpha() < 1.0F)
        {
          Log.i(OnlineVideoView.c(OnlineVideoView.this), "onlineVideoTimer switchVideoModel");
          OnlineVideoView.G(OnlineVideoView.this);
        }
        if (OnlineVideoView.this.txH.isPlaying()) {
          OnlineVideoView.f(OnlineVideoView.this);
        }
        try
        {
          boolean bool = Util.isNullOrNil(OnlineVideoView.this.KHk.mfu);
          if (!bool) {}
          for (int i = 1; i == 0; i = 0)
          {
            AppMethodBeat.o(198145);
            return false;
          }
          i = OnlineVideoView.this.txH.getCurrentPosition();
          OnlineVideoView.this.agQ(i);
          bool = OnlineVideoView.this.KHk.xa(i / 1000);
          AppMethodBeat.o(198145);
          return bool;
        }
        catch (Exception localException)
        {
          Log.e(OnlineVideoView.c(OnlineVideoView.this), "online video timer check error : " + localException.toString());
          AppMethodBeat.o(198145);
        }
        return false;
      }
    }, true);
    this.txN = new MTimerHandler(new MTimerHandler.CallBack()
    {
      public final boolean onTimerExpired()
      {
        AppMethodBeat.i(293230);
        if (OnlineVideoView.this.txH == null)
        {
          AppMethodBeat.o(293230);
          return false;
        }
        if (((View)OnlineVideoView.this.txH).getAlpha() < 1.0F)
        {
          Log.i(OnlineVideoView.c(OnlineVideoView.this), "offlineVideoTimer switchVideoModel");
          OnlineVideoView.G(OnlineVideoView.this);
        }
        if (OnlineVideoView.this.txH.isPlaying())
        {
          OnlineVideoView.f(OnlineVideoView.this);
          OnlineVideoView.this.agQ(OnlineVideoView.this.txH.getCurrentPosition());
        }
        AppMethodBeat.o(293230);
        return true;
      }
    }, true);
    this.KHD = new com.tencent.mm.plugin.sns.model.c.b()
    {
      public final void aYK(String paramAnonymousString) {}
      
      public final void cq(String paramAnonymousString, boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(293088);
        OnlineVideoView.g(OnlineVideoView.this).postDelayed(new OnlineVideoView.11.1(this, paramAnonymousBoolean, paramAnonymousString), 100L);
        AppMethodBeat.o(293088);
      }
      
      public final void cr(String paramAnonymousString, boolean paramAnonymousBoolean) {}
      
      public final void fLL() {}
    };
    this.KHE = new IListener() {};
    this.KHF = new IListener() {};
    this.Kbu = new IListener()
    {
      private boolean a(pn paramAnonymouspn)
      {
        AppMethodBeat.i(292852);
        if (OnlineVideoView.this.KHk == null)
        {
          Log.w(OnlineVideoView.c(OnlineVideoView.this), "%d online video helper is null.", new Object[] { Integer.valueOf(OnlineVideoView.this.hashCode()) });
          AppMethodBeat.o(292852);
          return false;
        }
        Log.w(OnlineVideoView.c(OnlineVideoView.this), "OnlineVideoEvent is received, the OnlineVideoEvent opcode is " + paramAnonymouspn.fOh.fDn);
        Log.w(OnlineVideoView.c(OnlineVideoView.this), "OnlineVideoEvent is received, the OnlineVideoEvent length is " + paramAnonymouspn.fOh.length);
        Log.w(OnlineVideoView.c(OnlineVideoView.this), "OnlineVideoEvent is received, the OnlineVideoEvent offset is " + paramAnonymouspn.fOh.offset);
        Log.w(OnlineVideoView.c(OnlineVideoView.this), "OnlineVideoEvent is received, the OnlineVideoEvent mediaId is " + paramAnonymouspn.fOh.mediaId);
        Log.w(OnlineVideoView.c(OnlineVideoView.this), "OnlineVideoEvent is received, the OnlineVideoEvent retCode is " + paramAnonymouspn.fOh.retCode);
        Log.w(OnlineVideoView.c(OnlineVideoView.this), "OnlineVideoEvent is received, the OnlineVideoEvent startDownload is " + paramAnonymouspn.fOh.fOi);
        try
        {
          bool = OnlineVideoView.this.KHk.bbW(paramAnonymouspn.fOh.mediaId);
          if (!bool)
          {
            AppMethodBeat.o(292852);
            return false;
          }
          if (paramAnonymouspn.fOh.retCode == -21112)
          {
            paramAnonymouspn = OnlineVideoView.this;
            com.tencent.mm.plugin.report.service.h.IzE.idkeyStat(354L, 218L, 1L, false);
            paramAnonymouspn.twz.post(new OnlineVideoView.19(paramAnonymouspn));
            AppMethodBeat.o(292852);
            return false;
          }
          if ((paramAnonymouspn.fOh.retCode != 0) && (paramAnonymouspn.fOh.retCode != -21006))
          {
            Log.w(OnlineVideoView.c(OnlineVideoView.this), "%d stream download online video error. retCode %d ", new Object[] { Integer.valueOf(OnlineVideoView.this.hashCode()), Integer.valueOf(paramAnonymouspn.fOh.retCode) });
            AppMethodBeat.o(292852);
            return false;
          }
          switch (paramAnonymouspn.fOh.fDn)
          {
          }
        }
        catch (Exception paramAnonymouspn)
        {
          for (;;)
          {
            boolean bool;
            long l2;
            long l1;
            Log.e(OnlineVideoView.c(OnlineVideoView.this), "online video callback error: " + paramAnonymouspn.toString());
            continue;
            if (l1 > localap.iVa) {}
            for (;;)
            {
              for (;;)
              {
                localap.iVa = l1;
                localap.KIk = Util.nowMilliSecond();
                try
                {
                  if (localap.KIg != null) {
                    break label744;
                  }
                  Log.w(localap.TAG, "parser is null, thread is error.");
                }
                catch (Exception paramAnonymouspn)
                {
                  Log.e(localap.TAG, "deal moov ready error: " + paramAnonymouspn.toString());
                }
              }
              break;
              l1 = localap.iVa;
            }
            if (localap.KIg.K(localap.mfv, l2))
            {
              localap.mfz = localap.KIg.mHG;
              Log.i(localap.TAG, "mp4 parse moov success. duration %d cdnMediaId %s isFastStart %b", new Object[] { Integer.valueOf(localap.mfz), localap.mfu, Boolean.valueOf(bool) });
              if (!bool) {
                MMHandlerThread.postToMainThread(new ap.1(localap));
              }
              if (localap.mfA == -1) {}
              for (localap.mfx = 1;; localap.mfx = 2)
              {
                com.tencent.mm.plugin.report.service.h.IzE.idkeyStat(354L, 204L, 1L, false);
                break;
              }
            }
            Log.w(localap.TAG, "mp4 parse moov error. cdnMediaId %s", new Object[] { localap.mfu });
            s.bqC();
            com.tencent.mm.aq.e.s(localap.mfu, 0, -1);
            com.tencent.mm.plugin.report.service.h.IzE.idkeyStat(354L, 205L, 1L, false);
            com.tencent.mm.plugin.report.service.h.IzE.a(13836, new Object[] { Integer.valueOf(402), Long.valueOf(Util.nowSecond()), "" });
            continue;
            ap localap = OnlineVideoView.this.KHk;
            Object localObject = paramAnonymouspn.fOh.mediaId;
            int i = paramAnonymouspn.fOh.offset;
            int j = paramAnonymouspn.fOh.length;
            localap.mfG = false;
            if ((i < 0) || (j < 0)) {
              Log.w(localap.TAG, "deal data available error offset[%d], length[%d]", new Object[] { Integer.valueOf(i), Integer.valueOf(j) });
            }
            while (!localap.bbW((String)localObject))
            {
              if (paramAnonymouspn.fOh.length <= 0) {
                break;
              }
              OnlineVideoView.this.gA(true);
              break;
            }
            localObject = localap.mfu + i + "_" + j;
            localObject = (Integer)localap.KIf.get(localObject);
            if ((localObject != null) && (((Integer)localObject).intValue() > 0)) {
              localap.mfD = ((Integer)localObject).intValue();
            }
            for (;;)
            {
              Log.i(localap.TAG, "deal data available. offset[%d] length[%d] cachePlayTime[%d]", new Object[] { Integer.valueOf(i), Integer.valueOf(j), Integer.valueOf(localap.mfD) });
              break;
              try
              {
                localap.mfD = localap.KIg.ee(i, j);
              }
              catch (Exception localException)
              {
                Log.e(localap.TAG, "deal data available file pos to video time error: " + localException.toString());
              }
            }
            OnlineVideoView.this.gA(true);
            continue;
            Log.i(OnlineVideoView.c(OnlineVideoView.this), "%d download finish. cdnMediaId %s sendReqCode %d favFromScene %d", new Object[] { Integer.valueOf(OnlineVideoView.this.hashCode()), paramAnonymouspn.fOh.mediaId, Integer.valueOf(OnlineVideoView.j(OnlineVideoView.this)), Integer.valueOf(OnlineVideoView.k(OnlineVideoView.this)) });
            paramAnonymouspn = OnlineVideoView.this.KHk;
            Log.i(paramAnonymouspn.TAG, "deal stream finish. playStatus %d cdnMediaId %s", new Object[] { Integer.valueOf(paramAnonymouspn.mfx), paramAnonymouspn.mfu });
            paramAnonymouspn.mfG = false;
            paramAnonymouspn.mfw = 3;
            com.tencent.mm.plugin.report.service.h.IzE.idkeyStat(354L, 206L, 1L, false);
            if (paramAnonymouspn.mfx == 0)
            {
              Log.w(paramAnonymouspn.TAG, "it had not moov callback and download finish start to play video.");
              paramAnonymouspn.fUE();
            }
            for (;;)
            {
              if (OnlineVideoView.j(OnlineVideoView.this) <= 0) {
                break label1478;
              }
              OnlineVideoView.f(OnlineVideoView.this);
              OnlineVideoView.a(OnlineVideoView.this, OnlineVideoView.j(OnlineVideoView.this));
              break;
              if (paramAnonymouspn.mfx == 5)
              {
                Log.w(paramAnonymouspn.TAG, "it had play error, it request all video data finish, start to play." + paramAnonymouspn.mfu);
                paramAnonymouspn.fUE();
              }
            }
            if (OnlineVideoView.k(OnlineVideoView.this) > 0)
            {
              OnlineVideoView.f(OnlineVideoView.this);
              OnlineVideoView.a(OnlineVideoView.this, OnlineVideoView.k(OnlineVideoView.this), OnlineVideoView.l(OnlineVideoView.this));
            }
            else if (OnlineVideoView.m(OnlineVideoView.this))
            {
              OnlineVideoView.f(OnlineVideoView.this);
              OnlineVideoView.n(OnlineVideoView.this);
            }
            else
            {
              OnlineVideoView.this.gA(true);
              continue;
              if (OnlineVideoView.E(OnlineVideoView.this) == 1)
              {
                localap = OnlineVideoView.this.KHk;
                String str = paramAnonymouspn.fOh.mediaId;
                i = paramAnonymouspn.fOh.offset;
                j = paramAnonymouspn.fOh.length;
                if (localap.bbW(str))
                {
                  localap.progress = i;
                  localap.total = j;
                  localap.KIi = (localap.progress * 100 / localap.total);
                  Log.i(localap.TAG, "deal video[%s] progress callback[%d, %d]. downloadedPercent[%d]", new Object[] { localap.mfu, Integer.valueOf(localap.progress), Integer.valueOf(localap.total), Integer.valueOf(localap.KIi) });
                }
                if (localap.KIi >= 100) {
                  localap.mfw = 3;
                }
              }
              else if (OnlineVideoView.E(OnlineVideoView.this) == 2)
              {
                OnlineVideoView.a(OnlineVideoView.this, paramAnonymouspn.fOh.offset, paramAnonymouspn.fOh.length);
                continue;
                paramAnonymouspn = OnlineVideoView.this.KHk;
                Log.i(paramAnonymouspn.TAG, "deal had dup video. cdnMediaId %s", new Object[] { paramAnonymouspn.mfu });
                paramAnonymouspn.fUE();
              }
            }
          }
        }
        Log.w(OnlineVideoView.c(OnlineVideoView.this), "%d unknown event opcode %d", new Object[] { Integer.valueOf(OnlineVideoView.this.hashCode()), Integer.valueOf(paramAnonymouspn.fOh.fDn) });
        for (;;)
        {
          AppMethodBeat.o(292852);
          return false;
          localap = OnlineVideoView.this.KHk;
          l2 = paramAnonymouspn.fOh.offset;
          l1 = paramAnonymouspn.fOh.fOi;
          bool = paramAnonymouspn.fOh.fOj;
          Log.i(localap.TAG, "deal moov ready moovPos %d, timeDuration %d, cdnMediaId %s startDownload[%d %d]", new Object[] { Long.valueOf(l2), Integer.valueOf(localap.mfz), localap.mfu, Long.valueOf(l1), Long.valueOf(localap.iVa) });
          if (localap.mfz == 0) {
            break;
          }
          Log.w(localap.TAG, "moov had callback, do nothing.");
          OnlineVideoView.J(OnlineVideoView.this);
        }
      }
    };
    this.KHb = new k.e()
    {
      public final void bXh()
      {
        AppMethodBeat.i(293212);
        Log.i(OnlineVideoView.c(OnlineVideoView.this), "%d on texture update.", new Object[] { Integer.valueOf(OnlineVideoView.this.hashCode()) });
        try
        {
          if ((OnlineVideoView.this.txH instanceof ThumbPlayerVideoView))
          {
            OnlineVideoView.K(OnlineVideoView.this);
            AppMethodBeat.o(293212);
            return;
          }
          OnlineVideoView.G(OnlineVideoView.this);
          AppMethodBeat.o(293212);
          return;
        }
        catch (Exception localException)
        {
          Log.e(OnlineVideoView.c(OnlineVideoView.this), "texture view update. error " + localException.toString());
          AppMethodBeat.o(293212);
        }
      }
    };
    this.EXe = new com.tencent.mm.plugin.u.b()
    {
      public final long eSG()
      {
        AppMethodBeat.i(293211);
        Log.i(OnlineVideoView.c(OnlineVideoView.this), "%d sns video get online cache", new Object[] { Integer.valueOf(OnlineVideoView.this.hashCode()) });
        com.tencent.mm.kernel.h.aHH();
        com.tencent.mm.kernel.h.aHG().aHp().set(ar.a.Vos, Boolean.TRUE);
        try
        {
          if ((OnlineVideoView.L(OnlineVideoView.this)) && (OnlineVideoView.this.KHk != null))
          {
            int i = OnlineVideoView.this.KHk.mfD;
            long l = i;
            AppMethodBeat.o(293211);
            return l;
          }
        }
        catch (Exception localException)
        {
          AppMethodBeat.o(293211);
        }
        return 0L;
      }
    };
    this.KHK = true;
    this.KHL = false;
    this.KHN = 0;
    this.KHO = 0;
    this.qoA = 0;
    J(paramContext, true);
    AppMethodBeat.o(216052);
  }
  
  public OnlineVideoView(Context paramContext, byte paramByte)
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
    this.KHe = 0;
    this.isPreview = false;
    this.wTx = false;
    this.iYs = false;
    this.fVT = null;
    this.KHh = false;
    this.KHk = null;
    this.KHm = false;
    this.duration = 0;
    this.KHn = 0;
    this.KHo = 0;
    this.KHp = 0L;
    this.KHq = 0L;
    this.wTz = 0;
    this.sUi = null;
    this.KHr = true;
    this.twz = new MMHandler(Looper.getMainLooper());
    this.scene = 0;
    this.KHs = 0L;
    this.sessionId = "";
    this.fLp = "";
    this.filePath = "";
    this.videoWidth = 0;
    this.videoHeight = 0;
    this.KHt = true;
    this.KHz = new a((byte)0);
    this.isInit = false;
    this.KHA = false;
    this.KHC = false;
    this.Kux = new MTimerHandler(new MTimerHandler.CallBack()
    {
      public final boolean onTimerExpired()
      {
        AppMethodBeat.i(198145);
        if ((OnlineVideoView.this.KHk == null) || (OnlineVideoView.this.txH == null))
        {
          AppMethodBeat.o(198145);
          return false;
        }
        if (((View)OnlineVideoView.this.txH).getAlpha() < 1.0F)
        {
          Log.i(OnlineVideoView.c(OnlineVideoView.this), "onlineVideoTimer switchVideoModel");
          OnlineVideoView.G(OnlineVideoView.this);
        }
        if (OnlineVideoView.this.txH.isPlaying()) {
          OnlineVideoView.f(OnlineVideoView.this);
        }
        try
        {
          boolean bool = Util.isNullOrNil(OnlineVideoView.this.KHk.mfu);
          if (!bool) {}
          for (int i = 1; i == 0; i = 0)
          {
            AppMethodBeat.o(198145);
            return false;
          }
          i = OnlineVideoView.this.txH.getCurrentPosition();
          OnlineVideoView.this.agQ(i);
          bool = OnlineVideoView.this.KHk.xa(i / 1000);
          AppMethodBeat.o(198145);
          return bool;
        }
        catch (Exception localException)
        {
          Log.e(OnlineVideoView.c(OnlineVideoView.this), "online video timer check error : " + localException.toString());
          AppMethodBeat.o(198145);
        }
        return false;
      }
    }, true);
    this.txN = new MTimerHandler(new MTimerHandler.CallBack()
    {
      public final boolean onTimerExpired()
      {
        AppMethodBeat.i(293230);
        if (OnlineVideoView.this.txH == null)
        {
          AppMethodBeat.o(293230);
          return false;
        }
        if (((View)OnlineVideoView.this.txH).getAlpha() < 1.0F)
        {
          Log.i(OnlineVideoView.c(OnlineVideoView.this), "offlineVideoTimer switchVideoModel");
          OnlineVideoView.G(OnlineVideoView.this);
        }
        if (OnlineVideoView.this.txH.isPlaying())
        {
          OnlineVideoView.f(OnlineVideoView.this);
          OnlineVideoView.this.agQ(OnlineVideoView.this.txH.getCurrentPosition());
        }
        AppMethodBeat.o(293230);
        return true;
      }
    }, true);
    this.KHD = new com.tencent.mm.plugin.sns.model.c.b()
    {
      public final void aYK(String paramAnonymousString) {}
      
      public final void cq(String paramAnonymousString, boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(293088);
        OnlineVideoView.g(OnlineVideoView.this).postDelayed(new OnlineVideoView.11.1(this, paramAnonymousBoolean, paramAnonymousString), 100L);
        AppMethodBeat.o(293088);
      }
      
      public final void cr(String paramAnonymousString, boolean paramAnonymousBoolean) {}
      
      public final void fLL() {}
    };
    this.KHE = new IListener() {};
    this.KHF = new IListener() {};
    this.Kbu = new IListener()
    {
      private boolean a(pn paramAnonymouspn)
      {
        AppMethodBeat.i(292852);
        if (OnlineVideoView.this.KHk == null)
        {
          Log.w(OnlineVideoView.c(OnlineVideoView.this), "%d online video helper is null.", new Object[] { Integer.valueOf(OnlineVideoView.this.hashCode()) });
          AppMethodBeat.o(292852);
          return false;
        }
        Log.w(OnlineVideoView.c(OnlineVideoView.this), "OnlineVideoEvent is received, the OnlineVideoEvent opcode is " + paramAnonymouspn.fOh.fDn);
        Log.w(OnlineVideoView.c(OnlineVideoView.this), "OnlineVideoEvent is received, the OnlineVideoEvent length is " + paramAnonymouspn.fOh.length);
        Log.w(OnlineVideoView.c(OnlineVideoView.this), "OnlineVideoEvent is received, the OnlineVideoEvent offset is " + paramAnonymouspn.fOh.offset);
        Log.w(OnlineVideoView.c(OnlineVideoView.this), "OnlineVideoEvent is received, the OnlineVideoEvent mediaId is " + paramAnonymouspn.fOh.mediaId);
        Log.w(OnlineVideoView.c(OnlineVideoView.this), "OnlineVideoEvent is received, the OnlineVideoEvent retCode is " + paramAnonymouspn.fOh.retCode);
        Log.w(OnlineVideoView.c(OnlineVideoView.this), "OnlineVideoEvent is received, the OnlineVideoEvent startDownload is " + paramAnonymouspn.fOh.fOi);
        try
        {
          bool = OnlineVideoView.this.KHk.bbW(paramAnonymouspn.fOh.mediaId);
          if (!bool)
          {
            AppMethodBeat.o(292852);
            return false;
          }
          if (paramAnonymouspn.fOh.retCode == -21112)
          {
            paramAnonymouspn = OnlineVideoView.this;
            com.tencent.mm.plugin.report.service.h.IzE.idkeyStat(354L, 218L, 1L, false);
            paramAnonymouspn.twz.post(new OnlineVideoView.19(paramAnonymouspn));
            AppMethodBeat.o(292852);
            return false;
          }
          if ((paramAnonymouspn.fOh.retCode != 0) && (paramAnonymouspn.fOh.retCode != -21006))
          {
            Log.w(OnlineVideoView.c(OnlineVideoView.this), "%d stream download online video error. retCode %d ", new Object[] { Integer.valueOf(OnlineVideoView.this.hashCode()), Integer.valueOf(paramAnonymouspn.fOh.retCode) });
            AppMethodBeat.o(292852);
            return false;
          }
          switch (paramAnonymouspn.fOh.fDn)
          {
          }
        }
        catch (Exception paramAnonymouspn)
        {
          for (;;)
          {
            boolean bool;
            long l2;
            long l1;
            Log.e(OnlineVideoView.c(OnlineVideoView.this), "online video callback error: " + paramAnonymouspn.toString());
            continue;
            if (l1 > localap.iVa) {}
            for (;;)
            {
              for (;;)
              {
                localap.iVa = l1;
                localap.KIk = Util.nowMilliSecond();
                try
                {
                  if (localap.KIg != null) {
                    break label744;
                  }
                  Log.w(localap.TAG, "parser is null, thread is error.");
                }
                catch (Exception paramAnonymouspn)
                {
                  Log.e(localap.TAG, "deal moov ready error: " + paramAnonymouspn.toString());
                }
              }
              break;
              l1 = localap.iVa;
            }
            if (localap.KIg.K(localap.mfv, l2))
            {
              localap.mfz = localap.KIg.mHG;
              Log.i(localap.TAG, "mp4 parse moov success. duration %d cdnMediaId %s isFastStart %b", new Object[] { Integer.valueOf(localap.mfz), localap.mfu, Boolean.valueOf(bool) });
              if (!bool) {
                MMHandlerThread.postToMainThread(new ap.1(localap));
              }
              if (localap.mfA == -1) {}
              for (localap.mfx = 1;; localap.mfx = 2)
              {
                com.tencent.mm.plugin.report.service.h.IzE.idkeyStat(354L, 204L, 1L, false);
                break;
              }
            }
            Log.w(localap.TAG, "mp4 parse moov error. cdnMediaId %s", new Object[] { localap.mfu });
            s.bqC();
            com.tencent.mm.aq.e.s(localap.mfu, 0, -1);
            com.tencent.mm.plugin.report.service.h.IzE.idkeyStat(354L, 205L, 1L, false);
            com.tencent.mm.plugin.report.service.h.IzE.a(13836, new Object[] { Integer.valueOf(402), Long.valueOf(Util.nowSecond()), "" });
            continue;
            ap localap = OnlineVideoView.this.KHk;
            Object localObject = paramAnonymouspn.fOh.mediaId;
            int i = paramAnonymouspn.fOh.offset;
            int j = paramAnonymouspn.fOh.length;
            localap.mfG = false;
            if ((i < 0) || (j < 0)) {
              Log.w(localap.TAG, "deal data available error offset[%d], length[%d]", new Object[] { Integer.valueOf(i), Integer.valueOf(j) });
            }
            while (!localap.bbW((String)localObject))
            {
              if (paramAnonymouspn.fOh.length <= 0) {
                break;
              }
              OnlineVideoView.this.gA(true);
              break;
            }
            localObject = localap.mfu + i + "_" + j;
            localObject = (Integer)localap.KIf.get(localObject);
            if ((localObject != null) && (((Integer)localObject).intValue() > 0)) {
              localap.mfD = ((Integer)localObject).intValue();
            }
            for (;;)
            {
              Log.i(localap.TAG, "deal data available. offset[%d] length[%d] cachePlayTime[%d]", new Object[] { Integer.valueOf(i), Integer.valueOf(j), Integer.valueOf(localap.mfD) });
              break;
              try
              {
                localap.mfD = localap.KIg.ee(i, j);
              }
              catch (Exception localException)
              {
                Log.e(localap.TAG, "deal data available file pos to video time error: " + localException.toString());
              }
            }
            OnlineVideoView.this.gA(true);
            continue;
            Log.i(OnlineVideoView.c(OnlineVideoView.this), "%d download finish. cdnMediaId %s sendReqCode %d favFromScene %d", new Object[] { Integer.valueOf(OnlineVideoView.this.hashCode()), paramAnonymouspn.fOh.mediaId, Integer.valueOf(OnlineVideoView.j(OnlineVideoView.this)), Integer.valueOf(OnlineVideoView.k(OnlineVideoView.this)) });
            paramAnonymouspn = OnlineVideoView.this.KHk;
            Log.i(paramAnonymouspn.TAG, "deal stream finish. playStatus %d cdnMediaId %s", new Object[] { Integer.valueOf(paramAnonymouspn.mfx), paramAnonymouspn.mfu });
            paramAnonymouspn.mfG = false;
            paramAnonymouspn.mfw = 3;
            com.tencent.mm.plugin.report.service.h.IzE.idkeyStat(354L, 206L, 1L, false);
            if (paramAnonymouspn.mfx == 0)
            {
              Log.w(paramAnonymouspn.TAG, "it had not moov callback and download finish start to play video.");
              paramAnonymouspn.fUE();
            }
            for (;;)
            {
              if (OnlineVideoView.j(OnlineVideoView.this) <= 0) {
                break label1478;
              }
              OnlineVideoView.f(OnlineVideoView.this);
              OnlineVideoView.a(OnlineVideoView.this, OnlineVideoView.j(OnlineVideoView.this));
              break;
              if (paramAnonymouspn.mfx == 5)
              {
                Log.w(paramAnonymouspn.TAG, "it had play error, it request all video data finish, start to play." + paramAnonymouspn.mfu);
                paramAnonymouspn.fUE();
              }
            }
            if (OnlineVideoView.k(OnlineVideoView.this) > 0)
            {
              OnlineVideoView.f(OnlineVideoView.this);
              OnlineVideoView.a(OnlineVideoView.this, OnlineVideoView.k(OnlineVideoView.this), OnlineVideoView.l(OnlineVideoView.this));
            }
            else if (OnlineVideoView.m(OnlineVideoView.this))
            {
              OnlineVideoView.f(OnlineVideoView.this);
              OnlineVideoView.n(OnlineVideoView.this);
            }
            else
            {
              OnlineVideoView.this.gA(true);
              continue;
              if (OnlineVideoView.E(OnlineVideoView.this) == 1)
              {
                localap = OnlineVideoView.this.KHk;
                String str = paramAnonymouspn.fOh.mediaId;
                i = paramAnonymouspn.fOh.offset;
                j = paramAnonymouspn.fOh.length;
                if (localap.bbW(str))
                {
                  localap.progress = i;
                  localap.total = j;
                  localap.KIi = (localap.progress * 100 / localap.total);
                  Log.i(localap.TAG, "deal video[%s] progress callback[%d, %d]. downloadedPercent[%d]", new Object[] { localap.mfu, Integer.valueOf(localap.progress), Integer.valueOf(localap.total), Integer.valueOf(localap.KIi) });
                }
                if (localap.KIi >= 100) {
                  localap.mfw = 3;
                }
              }
              else if (OnlineVideoView.E(OnlineVideoView.this) == 2)
              {
                OnlineVideoView.a(OnlineVideoView.this, paramAnonymouspn.fOh.offset, paramAnonymouspn.fOh.length);
                continue;
                paramAnonymouspn = OnlineVideoView.this.KHk;
                Log.i(paramAnonymouspn.TAG, "deal had dup video. cdnMediaId %s", new Object[] { paramAnonymouspn.mfu });
                paramAnonymouspn.fUE();
              }
            }
          }
        }
        Log.w(OnlineVideoView.c(OnlineVideoView.this), "%d unknown event opcode %d", new Object[] { Integer.valueOf(OnlineVideoView.this.hashCode()), Integer.valueOf(paramAnonymouspn.fOh.fDn) });
        for (;;)
        {
          AppMethodBeat.o(292852);
          return false;
          localap = OnlineVideoView.this.KHk;
          l2 = paramAnonymouspn.fOh.offset;
          l1 = paramAnonymouspn.fOh.fOi;
          bool = paramAnonymouspn.fOh.fOj;
          Log.i(localap.TAG, "deal moov ready moovPos %d, timeDuration %d, cdnMediaId %s startDownload[%d %d]", new Object[] { Long.valueOf(l2), Integer.valueOf(localap.mfz), localap.mfu, Long.valueOf(l1), Long.valueOf(localap.iVa) });
          if (localap.mfz == 0) {
            break;
          }
          Log.w(localap.TAG, "moov had callback, do nothing.");
          OnlineVideoView.J(OnlineVideoView.this);
        }
      }
    };
    this.KHb = new k.e()
    {
      public final void bXh()
      {
        AppMethodBeat.i(293212);
        Log.i(OnlineVideoView.c(OnlineVideoView.this), "%d on texture update.", new Object[] { Integer.valueOf(OnlineVideoView.this.hashCode()) });
        try
        {
          if ((OnlineVideoView.this.txH instanceof ThumbPlayerVideoView))
          {
            OnlineVideoView.K(OnlineVideoView.this);
            AppMethodBeat.o(293212);
            return;
          }
          OnlineVideoView.G(OnlineVideoView.this);
          AppMethodBeat.o(293212);
          return;
        }
        catch (Exception localException)
        {
          Log.e(OnlineVideoView.c(OnlineVideoView.this), "texture view update. error " + localException.toString());
          AppMethodBeat.o(293212);
        }
      }
    };
    this.EXe = new com.tencent.mm.plugin.u.b()
    {
      public final long eSG()
      {
        AppMethodBeat.i(293211);
        Log.i(OnlineVideoView.c(OnlineVideoView.this), "%d sns video get online cache", new Object[] { Integer.valueOf(OnlineVideoView.this.hashCode()) });
        com.tencent.mm.kernel.h.aHH();
        com.tencent.mm.kernel.h.aHG().aHp().set(ar.a.Vos, Boolean.TRUE);
        try
        {
          if ((OnlineVideoView.L(OnlineVideoView.this)) && (OnlineVideoView.this.KHk != null))
          {
            int i = OnlineVideoView.this.KHk.mfD;
            long l = i;
            AppMethodBeat.o(293211);
            return l;
          }
        }
        catch (Exception localException)
        {
          AppMethodBeat.o(293211);
        }
        return 0L;
      }
    };
    this.KHK = true;
    this.KHL = false;
    this.KHN = 0;
    this.KHO = 0;
    this.qoA = 0;
    J(paramContext, false);
    AppMethodBeat.o(98060);
  }
  
  private void J(Context paramContext, boolean paramBoolean)
  {
    AppMethodBeat.i(216059);
    this.mContext = paramContext;
    Log.i(this.TAG, "%d ui init view, isAd=%s", new Object[] { Integer.valueOf(hashCode()), Boolean.toString(paramBoolean) });
    LayoutInflater.from(paramContext).inflate(i.g.sns_video_view, this);
    this.wPh = ((ImageView)findViewById(i.f.video_thumb));
    this.wPB = ((RelativeLayout)findViewById(i.f.video_root));
    this.kEb = ((TextView)findViewById(i.f.video_duration));
    this.kEb.setVisibility(8);
    this.wTC = ((MMPinProgressBtn)findViewById(i.f.video_progress));
    this.pDL = ((ProgressBar)findViewById(i.f.video_loading));
    this.wTs = ((TextView)findViewById(i.f.video_tips));
    fUd();
    if (yP(paramBoolean))
    {
      this.txH = new ThumbPlayerVideoView(paramContext);
      ((ThumbPlayerVideoView)this.txH).setLoopStartCallback(new ThumbPlayerVideoView.c()
      {
        public final void fUv()
        {
          AppMethodBeat.i(196897);
          Log.i(OnlineVideoView.c(OnlineVideoView.this), "onLoopStart");
          if (OnlineVideoView.d(OnlineVideoView.this) != null)
          {
            OnlineVideoView.d(OnlineVideoView.this).reset();
            OnlineVideoView.d(OnlineVideoView.this).setEnableDrag(true);
          }
          AppMethodBeat.o(196897);
        }
      });
      this.txH.setOnInfoCallback(new k.b()
      {
        public final void eN(int paramAnonymousInt1, int paramAnonymousInt2)
        {
          AppMethodBeat.i(269308);
          if (paramAnonymousInt1 == 701)
          {
            OnlineVideoView.e(OnlineVideoView.this);
            AppMethodBeat.o(269308);
            return;
          }
          if (paramAnonymousInt1 == 702) {
            OnlineVideoView.f(OnlineVideoView.this);
          }
          AppMethodBeat.o(269308);
        }
      });
      this.wTy = false;
    }
    for (;;)
    {
      this.txH.setVideoCallback(this);
      RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-1, -2);
      localLayoutParams.addRule(13);
      int i = View.generateViewId();
      ((View)this.txH).setId(i);
      this.wPB.addView((View)this.txH, localLayoutParams);
      this.KHj = new ImageView(paramContext);
      paramContext = new RelativeLayout.LayoutParams(-1, -2);
      paramContext.addRule(6, i);
      paramContext.addRule(8, i);
      this.wPB.addView(this.KHj, paramContext);
      this.KHj.setVisibility(8);
      e(false, 0.0F);
      AppMethodBeat.o(216059);
      return;
      com.tencent.mm.modelcontrol.e.bkp();
      if (com.tencent.mm.modelcontrol.e.bkB())
      {
        this.wTy = true;
        this.txH = new VideoPlayerTextureView(paramContext);
        ((VideoPlayerTextureView)this.txH).setIOnlineCache(this.EXe);
        ((VideoPlayerTextureView)this.txH).setOpenWithNoneSurface(true);
        com.tencent.mm.plugin.report.service.h.IzE.idkeyStat(354L, 148L, 1L, false);
      }
      else
      {
        this.wTy = false;
        this.txH = new VideoTextureView(paramContext);
        com.tencent.mm.plugin.report.service.h.IzE.idkeyStat(354L, 149L, 1L, false);
      }
    }
  }
  
  private void agR(int paramInt)
  {
    AppMethodBeat.i(98071);
    if (this.fVT == null)
    {
      AppMethodBeat.o(98071);
      return;
    }
    String str = aq.kD(aj.getAccSnsPath(), this.fVT.Id) + t.d(this.fVT);
    Intent localIntent = new Intent();
    localIntent.putExtra("Select_Conv_Type", 3);
    localIntent.putExtra("select_is_ret", true);
    localIntent.putExtra("mutil_select_is_ret", true);
    localIntent.putExtra("image_path", str);
    localIntent.putExtra("Retr_Msg_Type", 11);
    Log.i(this.TAG, "send video path %s reqCode %d", new Object[] { str, Integer.valueOf(paramInt) });
    com.tencent.mm.by.c.d(getActivityContext(), ".ui.transmit.SelectConversationUI", localIntent, paramInt);
    this.fWF = 0;
    AppMethodBeat.o(98071);
  }
  
  private void aj(boolean paramBoolean, int paramInt)
  {
    boolean bool = false;
    AppMethodBeat.i(98076);
    if (this.fVT == null)
    {
      Log.w(this.TAG, "%d start download video but media is null.", new Object[] { Integer.valueOf(hashCode()) });
      AppMethodBeat.o(98076);
      return;
    }
    if ((this.KHk == null) && (this.KHu == null))
    {
      Log.w(this.TAG, "%d start download video but helper is null.", new Object[] { Integer.valueOf(hashCode()) });
      AppMethodBeat.o(98076);
      return;
    }
    if (this.fVT.TlV == 2)
    {
      Log.w(this.TAG, "%d it start download video, url type is weixin", new Object[] { Integer.valueOf(hashCode()) });
      this.KHe = 3;
      aj.fOD().a(this.fVT, 4, null, this.JRq);
      AppMethodBeat.o(98076);
      return;
    }
    int i;
    if (!paramBoolean)
    {
      com.tencent.mm.modelcontrol.e.bkp();
      if (com.tencent.mm.modelcontrol.e.bkA())
      {
        Log.i(this.TAG, "%d it start online download video", new Object[] { Integer.valueOf(hashCode()) });
        this.KHe = 1;
        i = paramInt;
        if (paramInt == 0) {
          i = 30;
        }
        paramBoolean = true;
        if ((this.KHu == null) || (this.KHw == null)) {
          break label355;
        }
        if (this.KHv != null)
        {
          this.KHv.iVf = i;
          this.KHv.BCS = paramBoolean;
        }
        this.KHu.start();
        if (this.KHe != 1) {
          break label330;
        }
        this.KHw.fZj();
      }
    }
    for (;;)
    {
      showLoading();
      AppMethodBeat.o(98076);
      return;
      Log.i(this.TAG, "%d it start offline download video", new Object[] { Integer.valueOf(hashCode()) });
      this.KHe = 2;
      if (paramInt != 0) {}
      for (;;)
      {
        paramBoolean = bool;
        i = paramInt;
        break;
        paramInt = 31;
      }
      label330:
      if (this.KHe == 2)
      {
        this.KHw.fZk();
        this.KHw.fZl();
      }
    }
    label355:
    if (this.KHk != null)
    {
      this.KHk.a(this.fVT, this.createTime, this.fCM, paramBoolean, i);
      AppMethodBeat.o(98076);
      return;
    }
    Log.w(this.TAG, "onlineVideoHelper is null!!!");
    AppMethodBeat.o(98076);
  }
  
  private void be(final int paramInt, final boolean paramBoolean)
  {
    AppMethodBeat.i(98072);
    this.twz.post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(293116);
        Object localObject1 = aj.fOI().bbl(OnlineVideoView.r(OnlineVideoView.this));
        if (localObject1 == null)
        {
          AppMethodBeat.o(293116);
          return;
        }
        Log.i(OnlineVideoView.c(OnlineVideoView.this), "fav download video[%s] farFromScene %d isFromMain %b", new Object[] { OnlineVideoView.s(OnlineVideoView.this), Integer.valueOf(paramInt), Boolean.valueOf(paramBoolean) });
        Object localObject2 = new dd();
        ((dd)localObject2).fyI.fyP = paramInt;
        ((dd)localObject2).fyI.activity = ((Activity)OnlineVideoView.this.getActivityContext());
        com.tencent.mm.plugin.sns.l.a.a((dd)localObject2, (SnsInfo)localObject1);
        EventCenter.instance.publish((IEvent)localObject2);
        if (((dd)localObject2).fyJ.ret == 0) {
          OnlineVideoView.fUr();
        }
        for (;;)
        {
          if (paramBoolean)
          {
            localObject2 = new wo();
            ((wo)localObject2).fVI.fAg = ((SnsInfo)localObject1).getLocalid();
            ((wo)localObject2).fVI.fLp = t.w((SnsInfo)localObject1);
            EventCenter.instance.publish((IEvent)localObject2);
          }
          OnlineVideoView.t(OnlineVideoView.this);
          if (OnlineVideoView.this.txH == null) {
            break label328;
          }
          if (!Util.isNullOrNil(OnlineVideoView.this.txH.getVideoPath())) {
            break;
          }
          Log.i(OnlineVideoView.c(OnlineVideoView.this), "%d had not set video path to play", new Object[] { Integer.valueOf(OnlineVideoView.this.hashCode()) });
          localObject1 = ax.a(OnlineVideoView.s(OnlineVideoView.this), OnlineVideoView.u(OnlineVideoView.this));
          if (!Util.isNullOrNil((String)localObject1)) {
            OnlineVideoView.this.cD((String)localObject1, false);
          }
          AppMethodBeat.o(293116);
          return;
          OnlineVideoView.fUs();
        }
        if (!OnlineVideoView.this.txH.isPlaying())
        {
          OnlineVideoView.this.txH.start();
          AppMethodBeat.o(293116);
          return;
        }
        label328:
        AppMethodBeat.o(293116);
      }
    });
    AppMethodBeat.o(98072);
  }
  
  private void d(final boolean paramBoolean, final float paramFloat)
  {
    AppMethodBeat.i(98074);
    this.twz.post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(193770);
        Log.i(OnlineVideoView.c(OnlineVideoView.this), "%d switch video model isVideoPlay %b %f", new Object[] { Integer.valueOf(OnlineVideoView.this.hashCode()), Boolean.valueOf(paramBoolean), Float.valueOf(paramFloat) });
        View localView = (View)OnlineVideoView.this.txH;
        if (paramBoolean)
        {
          OnlineVideoView.A(OnlineVideoView.this).setAlpha(paramFloat);
          OnlineVideoView.A(OnlineVideoView.this).setVisibility(0);
          localView.setAlpha(paramFloat);
          localView.setVisibility(0);
          if ((paramFloat >= 1.0D) && (!OnlineVideoView.B(OnlineVideoView.this)))
          {
            OnlineVideoView.C(OnlineVideoView.this).setVisibility(8);
            AppMethodBeat.o(193770);
          }
        }
        else
        {
          OnlineVideoView.A(OnlineVideoView.this).setVisibility(8);
          localView.setVisibility(8);
          if (OnlineVideoView.D(OnlineVideoView.this)) {
            OnlineVideoView.C(OnlineVideoView.this).setVisibility(0);
          }
        }
        AppMethodBeat.o(193770);
      }
    });
    AppMethodBeat.o(98074);
  }
  
  private void dmh()
  {
    AppMethodBeat.i(98075);
    Object localObject1;
    if (!this.isPreview)
    {
      localObject1 = ax.a(this.fCM, this.fVT);
      Log.i(this.TAG, "%d toggleVideo local id %s finish path %s isPreview %b", new Object[] { Integer.valueOf(hashCode()), this.fCM, localObject1, Boolean.valueOf(this.isPreview) });
      if (Util.isNullOrNil((String)localObject1)) {
        break label180;
      }
      Log.i(this.TAG, "%d sns video already download finish, play now", new Object[] { Integer.valueOf(hashCode()) });
      if (!(this.txH instanceof ThumbPlayerVideoView)) {
        break label171;
      }
      Object localObject2 = localObject1;
      if (!u.agG((String)localObject1))
      {
        localObject2 = getRelocatedVideoPath();
        Log.w(this.TAG, "get relocated video path: ".concat(String.valueOf(localObject2)));
      }
      e(true, 0.0F);
      localObject1 = localObject2;
    }
    for (;;)
    {
      cD((String)localObject1, false);
      AppMethodBeat.o(98075);
      return;
      localObject1 = this.KHf;
      break;
      label171:
      d(true, 0.0F);
    }
    label180:
    if ((this.txH instanceof ThumbPlayerVideoView)) {
      e(false, 0.0F);
    }
    for (;;)
    {
      aj(false, 0);
      showLoading();
      AppMethodBeat.o(98075);
      return;
      d(false, 0.0F);
    }
  }
  
  private boolean dmk()
  {
    AppMethodBeat.i(98086);
    if (!this.KHl)
    {
      AppMethodBeat.o(98086);
      return false;
    }
    com.tencent.mm.kernel.h.aHH();
    boolean bool = com.tencent.mm.kernel.h.aHG().aHp().getBoolean(ar.a.Vos, false);
    AppMethodBeat.o(98086);
    return bool;
  }
  
  private void e(boolean paramBoolean, float paramFloat)
  {
    AppMethodBeat.i(216083);
    Log.i(this.TAG, "%d switch sync video model isVideoPlay %b %f", new Object[] { Integer.valueOf(hashCode()), Boolean.valueOf(paramBoolean), Float.valueOf(paramFloat) });
    View localView = (View)this.txH;
    if (paramBoolean)
    {
      this.wPB.setAlpha(paramFloat);
      this.wPB.setVisibility(0);
      localView.setAlpha(paramFloat);
      localView.setVisibility(0);
      if ((paramFloat >= 1.0D) && (!this.KHL))
      {
        this.wPh.setVisibility(8);
        AppMethodBeat.o(216083);
      }
    }
    else
    {
      this.wPB.setVisibility(8);
      localView.setVisibility(8);
      if (this.KHK) {
        this.wPh.setVisibility(0);
      }
    }
    AppMethodBeat.o(216083);
  }
  
  private void fUd()
  {
    AppMethodBeat.i(216060);
    this.KHy = ((ImageView)findViewById(i.f.hero_seekbar_bg));
    this.KHx = ((HeroSeekBarView)findViewById(i.f.sns_video_seek_bar));
    this.KHx.setHeroSeekBarChangeListener(new HeroSeekBarView.b()
    {
      public final void agT(int paramAnonymousInt)
      {
        AppMethodBeat.i(216564);
        OnlineVideoView.this.agS((int)(OnlineVideoView.d(OnlineVideoView.this).aqO(paramAnonymousInt) / 1000L));
        OnlineVideoView.i(OnlineVideoView.this);
        OnlineVideoView.a locala = OnlineVideoView.h(OnlineVideoView.this);
        OnlineVideoView.g(locala.KHP).removeCallbacks(locala);
        AppMethodBeat.o(216564);
      }
      
      public final void bg(int paramAnonymousInt, boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(216560);
        if (paramAnonymousBoolean)
        {
          paramAnonymousInt = (int)(OnlineVideoView.d(OnlineVideoView.this).aqO(paramAnonymousInt) / 1000L);
          OnlineVideoView.a locala = OnlineVideoView.h(OnlineVideoView.this);
          locala.KIc = paramAnonymousInt;
          if (SystemClock.uptimeMillis() - locala.KIe > 100L)
          {
            locala.run();
            AppMethodBeat.o(216560);
            return;
          }
          OnlineVideoView.g(locala.KHP).removeCallbacks(locala);
          OnlineVideoView.g(locala.KHP).postDelayed(locala, 100L);
        }
        AppMethodBeat.o(216560);
      }
      
      public final void fUw()
      {
        AppMethodBeat.i(216561);
        OnlineVideoView.this.dmi();
        AppMethodBeat.o(216561);
      }
    });
    AppMethodBeat.o(216060);
  }
  
  private void fUi()
  {
    AppMethodBeat.i(216077);
    int j = com.tencent.mm.plugin.sns.i.e.black;
    int i = j;
    if (this.fVT != null)
    {
      i = j;
      if (this.fVT.isAd)
      {
        Log.i(this.TAG, "the media is ad, the background should be transparent");
        i = com.tencent.mm.plugin.sns.i.e.transparent_background;
      }
    }
    boolean bool = aj.fOF().b(this.fVT, this.wPh, i, this.mContext.hashCode(), this.JRq);
    Log.i(this.TAG, "%d fresh thumb image %b", new Object[] { Integer.valueOf(hashCode()), Boolean.valueOf(bool) });
    AppMethodBeat.o(216077);
  }
  
  private void fUk()
  {
    AppMethodBeat.i(98073);
    p.a(getContext(), new androidx.core.f.a() {});
    AppMethodBeat.o(98073);
  }
  
  private void fUn()
  {
    AppMethodBeat.i(98092);
    this.KHG = Util.nowMilliSecond();
    Log.d(this.TAG, "%d notePlayVideo notePlayVideo %d ", new Object[] { Integer.valueOf(hashCode()), Long.valueOf(this.KHG) });
    AppMethodBeat.o(98092);
  }
  
  private void fUo()
  {
    AppMethodBeat.i(98093);
    if (this.KHG > 0L) {
      this.KHH = ((int)(this.KHH + (Util.nowMilliSecond() - this.KHG) / 1000L));
    }
    Log.i(this.TAG, "%d notePauseVideo playVideoDuration %d ", new Object[] { Integer.valueOf(hashCode()), Integer.valueOf(this.KHH) });
    this.KHG = 0L;
    AppMethodBeat.o(98093);
  }
  
  private void fUp()
  {
    AppMethodBeat.i(98095);
    this.KHI = Util.nowMilliSecond();
    Log.d(this.TAG, "%d noteResumeVideo noteResumeVideo %d ", new Object[] { Integer.valueOf(hashCode()), Long.valueOf(this.KHI) });
    AppMethodBeat.o(98095);
  }
  
  private void fUq()
  {
    AppMethodBeat.i(98096);
    if (this.KHI > 0L)
    {
      this.KHJ = 0;
      this.KHJ = ((int)(this.KHJ + (Util.nowMilliSecond() - this.KHI) / 1000L));
    }
    Log.i(this.TAG, "%d notePauseVideoByResume playVideoDuration %d ", new Object[] { Integer.valueOf(hashCode()), Integer.valueOf(this.KHJ) });
    this.KHI = 0L;
    AppMethodBeat.o(98096);
  }
  
  private String getRelocatedVideoPath()
  {
    AppMethodBeat.i(216087);
    Object localObject = aj.fOI().bbl(this.KHg);
    if (localObject == null)
    {
      AppMethodBeat.o(216087);
      return null;
    }
    localObject = ((SnsInfo)localObject).getTimeLine();
    if ((localObject == null) || (((TimeLineObject)localObject).ContentObj == null) || (((TimeLineObject)localObject).ContentObj.Sqr == null) || (((TimeLineObject)localObject).ContentObj.Sqr.isEmpty()))
    {
      Log.w(this.TAG, "getRelocatedVideoPath but no valid media found");
      AppMethodBeat.o(216087);
      return null;
    }
    localObject = (cvt)((TimeLineObject)localObject).ContentObj.Sqr.get(0);
    localObject = ax.a(this.fCM, (cvt)localObject);
    AppMethodBeat.o(216087);
    return localObject;
  }
  
  private void hideLoading()
  {
    AppMethodBeat.i(98080);
    this.twz.post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(222830);
        if ((OnlineVideoView.p(OnlineVideoView.this) != null) && (OnlineVideoView.p(OnlineVideoView.this).getVisibility() != 8))
        {
          Log.i(OnlineVideoView.c(OnlineVideoView.this), "%d hide loading.", new Object[] { Integer.valueOf(OnlineVideoView.this.hashCode()) });
          OnlineVideoView.p(OnlineVideoView.this).setVisibility(8);
        }
        if ((OnlineVideoView.q(OnlineVideoView.this) != null) && (OnlineVideoView.q(OnlineVideoView.this).getVisibility() != 8))
        {
          Log.i(OnlineVideoView.c(OnlineVideoView.this), "%d hide progress.", new Object[] { Integer.valueOf(OnlineVideoView.this.hashCode()) });
          OnlineVideoView.q(OnlineVideoView.this).setVisibility(8);
        }
        AppMethodBeat.o(222830);
      }
    });
    AppMethodBeat.o(98080);
  }
  
  private void showLoading()
  {
    AppMethodBeat.i(98079);
    this.twz.post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(252268);
        Log.i(OnlineVideoView.c(OnlineVideoView.this), "%d show loading. downloadMode %d", new Object[] { Integer.valueOf(OnlineVideoView.this.hashCode()), Integer.valueOf(OnlineVideoView.E(OnlineVideoView.this)) });
        if (OnlineVideoView.E(OnlineVideoView.this) == 1)
        {
          if ((OnlineVideoView.p(OnlineVideoView.this) != null) && (OnlineVideoView.p(OnlineVideoView.this).getVisibility() != 0)) {
            OnlineVideoView.p(OnlineVideoView.this).setVisibility(0);
          }
          if ((OnlineVideoView.q(OnlineVideoView.this) != null) && (OnlineVideoView.q(OnlineVideoView.this).getVisibility() != 8)) {
            OnlineVideoView.q(OnlineVideoView.this).setVisibility(8);
          }
        }
        if (OnlineVideoView.E(OnlineVideoView.this) == 2)
        {
          if ((OnlineVideoView.q(OnlineVideoView.this) != null) && (OnlineVideoView.q(OnlineVideoView.this).getVisibility() != 0)) {
            OnlineVideoView.q(OnlineVideoView.this).setVisibility(0);
          }
          if ((OnlineVideoView.p(OnlineVideoView.this) != null) && (OnlineVideoView.p(OnlineVideoView.this).getVisibility() != 8)) {
            OnlineVideoView.p(OnlineVideoView.this).setVisibility(8);
          }
        }
        if (OnlineVideoView.E(OnlineVideoView.this) == 3)
        {
          if ((OnlineVideoView.q(OnlineVideoView.this) != null) && (OnlineVideoView.q(OnlineVideoView.this).getVisibility() != 0))
          {
            OnlineVideoView.q(OnlineVideoView.this).setVisibility(0);
            OnlineVideoView.q(OnlineVideoView.this).hZF();
          }
          if ((OnlineVideoView.p(OnlineVideoView.this) != null) && (OnlineVideoView.p(OnlineVideoView.this).getVisibility() != 8)) {
            OnlineVideoView.p(OnlineVideoView.this).setVisibility(8);
          }
        }
        AppMethodBeat.o(252268);
      }
    });
    AppMethodBeat.o(98079);
  }
  
  private void unInit()
  {
    for (;;)
    {
      try
      {
        AppMethodBeat.i(98061);
        Object localObject1 = this.KHx;
        ((HeroSeekBarView)localObject1).Rrz = false;
        localObject1 = ((HeroSeekBarView)localObject1).BkJ;
        if (localObject1 != null) {
          ((com.tencent.e.i.d)localObject1).cancel(true);
        }
        if (this.fuk != null)
        {
          this.fuk.cancel(true);
          this.fuk = null;
        }
        this.fCM = null;
        if (!this.isInit)
        {
          AppMethodBeat.o(98061);
          return;
        }
        this.isInit = false;
        Log.i(this.TAG, "%d logic unInit", new Object[] { Integer.valueOf(hashCode()) });
        fUo();
        fUq();
        if (!(this.txH instanceof ThumbPlayerVideoView))
        {
          this.txH.stop();
          EventCenter.instance.removeListener(this.Kbu);
          EventCenter.instance.removeListener(this.KHE);
          aj.fOD().b(this.KHD);
          fTZ();
          this.twz.removeCallbacksAndMessages(null);
          if (this.KHk != null)
          {
            this.KHk.fUC();
            this.KHk.clear();
          }
          if (this.KHu != null)
          {
            this.KHu.stop();
            this.KHu = null;
          }
          if (this.KHw != null)
          {
            localObject1 = this.KHw;
            Log.i("MicroMsg.VideoResourceDownloaderDelegate", "release");
            al.a(((com.tencent.mm.plugin.sns.ui.video.f)localObject1).rcY, null);
          }
          if (com.tencent.mm.q.a.abL() != null) {
            com.tencent.mm.q.a.abL().aqm();
          }
          if (this.sUi != null) {
            this.sUi.fZ(false);
          }
          this.sUi = null;
          this.fVT = null;
          this.KHk = null;
          this.KHo = 0;
          AppMethodBeat.o(98061);
        }
        else
        {
          com.tencent.e.h.ZvG.bc(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(268814);
              OnlineVideoView.this.txH.stop();
              AppMethodBeat.o(268814);
            }
          });
        }
      }
      finally {}
    }
  }
  
  private static boolean yP(boolean paramBoolean)
  {
    AppMethodBeat.i(216068);
    com.tencent.mm.plugin.expt.b.b localb = (com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.expt.b.b.class);
    if (paramBoolean)
    {
      if (com.tencent.mm.plugin.sns.ad.c.Jxu == 1)
      {
        AppMethodBeat.o(216068);
        return false;
      }
      if (com.tencent.mm.plugin.sns.ad.c.Jxu == 2)
      {
        AppMethodBeat.o(216068);
        return true;
      }
      paramBoolean = localb.a(b.a.wbY, false);
      AppMethodBeat.o(216068);
      return paramBoolean;
    }
    paramBoolean = localb.a(b.a.wbX, false);
    AppMethodBeat.o(216068);
    return paramBoolean;
  }
  
  public final void a(cvt paramcvt, String paramString, int paramInt)
  {
    AppMethodBeat.i(98065);
    this.fCM = paramString;
    this.createTime = paramInt;
    paramString = bp.hzm();
    paramString.time = this.createTime;
    this.JRq = paramString;
    if (this.fVT != paramcvt)
    {
      this.fVT = paramcvt;
      fUi();
    }
    if (this.fVT != null) {
      this.KHg = com.tencent.mm.plugin.sns.data.m.kv(this.fCM, this.fVT.Id + "_");
    }
    this.isPreview = false;
    Log.i(this.TAG, "%d set video data[%s, %d] isPreview %b self %s", new Object[] { Integer.valueOf(hashCode()), this.fCM, Integer.valueOf(this.createTime), Boolean.valueOf(this.isPreview), this });
    AppMethodBeat.o(98065);
  }
  
  public final void aS(Activity paramActivity)
  {
    this.KHB = paramActivity;
    this.KHC = true;
  }
  
  public final void abandonAudioFocus()
  {
    AppMethodBeat.i(98062);
    if (this.sUi != null) {
      this.sUi.fZ(false);
    }
    AppMethodBeat.o(98062);
  }
  
  public final void agQ(int paramInt)
  {
    AppMethodBeat.i(216107);
    Log.i(this.TAG, "updateVideoUI: %d", new Object[] { Integer.valueOf(paramInt) });
    b localb = this.KHi;
    if (localb != null) {
      localb.AS(paramInt);
    }
    AppMethodBeat.o(216107);
  }
  
  public final void agS(int paramInt)
  {
    int i = 1;
    AppMethodBeat.i(216102);
    Log.i(this.TAG, "%d ui touch seek second %d afterSeekPlay %b", new Object[] { Integer.valueOf(hashCode()), Integer.valueOf(paramInt), Boolean.TRUE });
    if (!this.KHl) {
      bc(paramInt, true);
    }
    for (paramInt = i;; paramInt = i)
    {
      if (paramInt != 0) {
        gA(false);
      }
      AppMethodBeat.o(216102);
      return;
      if (!(this.txH instanceof ThumbPlayerVideoView)) {
        break;
      }
      ((ThumbPlayerVideoView)this.txH).b(paramInt * 1000, true);
    }
    ap localap = this.KHk;
    switch (localap.mfw)
    {
    }
    label144:
    for (i = 1;; i = 0)
    {
      Log.i(localap.TAG, "seek video time %d, download status %d playStatus %d", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(localap.mfw), Integer.valueOf(localap.mfx) });
      paramInt = i;
      break;
      localap.mfx = 2;
      PInt localPInt1 = new PInt();
      PInt localPInt2 = new PInt();
      localap.a(paramInt, localPInt1, localPInt2);
      if (localap.p(localPInt1.value, localPInt2.value, true))
      {
        localap.mfA = -1;
        localap.mfC = false;
        localap.mfD = localPInt2.value;
        localap.mfx = 3;
        localap.agU(paramInt);
        break label144;
      }
      localap.mfA = paramInt;
      localap.mfC = true;
      localap.KIh.bqn();
    }
  }
  
  public final void bc(int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(216104);
    Log.i(this.TAG, "%d seek second %d afterSeekPlay %b", new Object[] { Integer.valueOf(hashCode()), Integer.valueOf(paramInt), Boolean.valueOf(paramBoolean) });
    this.KHo = 0;
    hideLoading();
    this.txH.b(paramInt * 1000, paramBoolean);
    gA(false);
    AppMethodBeat.o(216104);
  }
  
  public final void bcu() {}
  
  public final void bcv() {}
  
  public final void bcw() {}
  
  public final void bcx() {}
  
  public final void bf(int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(216136);
    Log.i(this.TAG, "addVideoViewBottomMargin: %d", new Object[] { Integer.valueOf(paramInt) });
    if (paramBoolean)
    {
      this.qoA = paramInt;
      RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)this.KHx.getLayoutParams();
      localLayoutParams.addRule(12);
      localLayoutParams.bottomMargin = (com.tencent.mm.ci.a.aY(this.KHB, i.d.Edge_2A) + paramInt);
      this.KHx.setLayoutParams(localLayoutParams);
      AppMethodBeat.o(216136);
      return;
    }
    this.KHM += paramInt;
    AppMethodBeat.o(216136);
  }
  
  public final void bqn()
  {
    AppMethodBeat.i(98090);
    Log.i(this.TAG, "%d pauseByDataBlock", new Object[] { Integer.valueOf(hashCode()) });
    fUo();
    showLoading();
    dmi();
    if (AppForegroundDelegate.fby.cQt)
    {
      this.KHt = true;
      Log.i(this.TAG, "%d pauseByDataBlock and allowStart", new Object[] { Integer.valueOf(hashCode()) });
    }
    AppMethodBeat.o(98090);
  }
  
  public final void cD(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(98087);
    Log.i(this.TAG, "%d prepare video isOnlinePlay %b filePath %s", new Object[] { Integer.valueOf(hashCode()), Boolean.valueOf(paramBoolean), paramString });
    if (Util.isNullOrNil(paramString))
    {
      Log.w(this.TAG, "%d prepare video but filepath is null.", new Object[] { Integer.valueOf(hashCode()) });
      AppMethodBeat.o(98087);
      return;
    }
    this.KHl = paramBoolean;
    String str;
    if (this.txH != null)
    {
      if (this.KHo == -3) {
        break label370;
      }
      if ((this.txH instanceof VideoPlayerTextureView))
      {
        ((VideoPlayerTextureView)this.txH).setNeedResetExtractor(dmk());
        ((VideoPlayerTextureView)this.txH).setIsOnlineVideoType(paramBoolean);
      }
      this.txH.setOneTimeVideoTextureUpdateCallback(this.KHb);
      MultiProcessMMKV localMultiProcessMMKV = MultiProcessMMKV.getMMKV("TrackDataSource");
      if (this.fVT != null) {
        break label329;
      }
      str = "";
      localMultiProcessMMKV.putString("media-url", str);
      if (this.fVT != null) {
        break label340;
      }
      str = "";
      label188:
      localMultiProcessMMKV.putString("thumb-url", str);
      localMultiProcessMMKV.putLong("prepare-ts", System.currentTimeMillis());
      localMultiProcessMMKV.putString("prepare-path", paramString);
      localMultiProcessMMKV.commit();
      if (!(this.txH instanceof ThumbPlayerVideoView)) {
        break label351;
      }
      if (!((ThumbPlayerVideoView)this.txH).uXY) {
        this.txH.setVideoPath(paramString);
      }
      e(true, 0.0F);
    }
    for (;;)
    {
      this.KHx.setEnableDrag(true);
      com.tencent.mm.kernel.h.aHH();
      if (((Integer)com.tencent.mm.kernel.h.aHG().aHp().get(ar.a.VmY, Integer.valueOf(0))).intValue() == 1)
      {
        this.wTs.setText(com.tencent.mm.plugin.sight.base.f.aPw(paramString));
        this.wTs.setVisibility(0);
      }
      AppMethodBeat.o(98087);
      return;
      label329:
      str = this.fVT.Url;
      break;
      label340:
      str = this.fVT.TDF;
      break label188;
      label351:
      this.txH.setVideoPath(paramString);
      d(true, 0.0F);
      continue;
      label370:
      Log.i(this.TAG, "%d prepare video reset source", new Object[] { Integer.valueOf(hashCode()) });
      if ((this.txH instanceof VideoPlayerTextureView)) {
        ((VideoPlayerTextureView)this.txH).hnP();
      }
      bc(this.KHn, true);
    }
  }
  
  public void dmi()
  {
    AppMethodBeat.i(98078);
    this.KHt = false;
    if (this.txH.isPlaying())
    {
      Log.i(this.TAG, "%d pause play", new Object[] { Integer.valueOf(hashCode()) });
      fUo();
      fUq();
    }
    this.txH.pause();
    if ((this.KHi instanceof c)) {
      try
      {
        ((c)this.KHi).onPause();
        AppMethodBeat.o(98078);
        return;
      }
      catch (Throwable localThrowable)
      {
        Log.e(this.TAG, "the pause callback invalid!!");
      }
    }
    AppMethodBeat.o(98078);
  }
  
  public final void eM(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(216089);
    Log.i(this.TAG, "onGetVideoSize width:%d height:%d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    this.videoWidth = paramInt1;
    this.videoHeight = paramInt2;
    AppMethodBeat.o(216089);
  }
  
  public final int fE(int paramInt1, int paramInt2)
  {
    return 0;
  }
  
  public void fLJ()
  {
    AppMethodBeat.i(98089);
    this.KHt = true;
    if (!this.txH.isPlaying())
    {
      fUp();
      int i = this.txH.getDuration();
      int j = this.txH.getCurrentPosition();
      if (j >= i) {
        Log.e(this.TAG, "the current position is more than duration, current = %d, duration = %d !!!", new Object[] { Integer.valueOf(j), Integer.valueOf(i) });
      }
      this.txH.start();
    }
    AppMethodBeat.o(98089);
  }
  
  public final void fTZ()
  {
    AppMethodBeat.i(98082);
    if ((this.txH instanceof ThumbPlayerVideoView))
    {
      AppMethodBeat.o(98082);
      return;
    }
    this.Kux.stopTimer();
    this.txN.stopTimer();
    AppMethodBeat.o(98082);
  }
  
  public final void fUe()
  {
    this.KHr = false;
  }
  
  public final void fUf()
  {
    AppMethodBeat.i(98063);
    Log.d(this.TAG, "%d register sns ui event", new Object[] { Integer.valueOf(hashCode()) });
    EventCenter.instance.addListener(this.KHF);
    AppMethodBeat.o(98063);
  }
  
  public final void fUg()
  {
    AppMethodBeat.i(98064);
    Log.d(this.TAG, "%d unRegister sns ui event", new Object[] { Integer.valueOf(hashCode()) });
    EventCenter.instance.removeListener(this.KHF);
    AppMethodBeat.o(98064);
  }
  
  public final String fUh()
  {
    AppMethodBeat.i(98066);
    Object localObject = new StringBuffer();
    try
    {
      if (this.fVT != null) {
        ((StringBuffer)localObject).append("media: " + this.fVT.Id);
      }
      if (this.fCM != null) {
        ((StringBuffer)localObject).append("localId: " + this.fCM);
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
  
  public final void fUj()
  {
    this.KHB = null;
    this.KHC = false;
  }
  
  public final boolean fUl()
  {
    boolean bool = true;
    AppMethodBeat.i(98088);
    Log.i(this.TAG, "%d resumeByDataGain", new Object[] { Integer.valueOf(hashCode()) });
    if (!this.KHt)
    {
      AppMethodBeat.o(98088);
      return false;
    }
    if (!this.txH.isPlaying())
    {
      fUn();
      fUp();
      bool = this.txH.start();
      hideLoading();
    }
    AppMethodBeat.o(98088);
    return bool;
  }
  
  public final boolean fUm()
  {
    return this.KHt;
  }
  
  public final void fhw()
  {
    AppMethodBeat.i(216067);
    this.KHx.setVisibility(4);
    this.KHy.setVisibility(4);
    AppMethodBeat.o(216067);
  }
  
  protected final void gA(boolean paramBoolean)
  {
    AppMethodBeat.i(98081);
    if ((this.txH instanceof ThumbPlayerVideoView))
    {
      AppMethodBeat.o(98081);
      return;
    }
    if (this.KHl)
    {
      if (paramBoolean)
      {
        MMHandlerThread.postToMainThread(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(98050);
            if ((OnlineVideoView.this.txH != null) && (OnlineVideoView.this.KHk != null))
            {
              int i = OnlineVideoView.this.txH.getCurrentPosition() / 1000;
              OnlineVideoView.this.KHk.xa(i);
            }
            OnlineVideoView.F(OnlineVideoView.this).startTimer(500L);
            AppMethodBeat.o(98050);
          }
        });
        AppMethodBeat.o(98081);
        return;
      }
      this.Kux.startTimer(500L);
      AppMethodBeat.o(98081);
      return;
    }
    this.txN.startTimer(500L);
    AppMethodBeat.o(98081);
  }
  
  protected Context getActivityContext()
  {
    if (this.KHB == null) {
      return this.mContext;
    }
    return this.KHB;
  }
  
  public int getBottomSafeHeight()
  {
    AppMethodBeat.i(216139);
    int i;
    int j;
    int k;
    if (this.KHx.getVisibility() == 0)
    {
      i = this.KHM;
      j = com.tencent.mm.ci.a.aY(this.KHB, i.d.Edge_4_5_A);
      k = com.tencent.mm.ci.a.aY(this.KHB, i.d.Edge_2A);
      int m = this.qoA;
      AppMethodBeat.o(216139);
      return i + j + k + m;
    }
    if (this.KHM != 0)
    {
      i = this.KHM;
      j = com.tencent.mm.ci.a.aY(this.KHB, i.d.Edge_2A);
      k = this.qoA;
      AppMethodBeat.o(216139);
      return i + j + k;
    }
    AppMethodBeat.o(216139);
    return 0;
  }
  
  public int getCurrentPosition()
  {
    AppMethodBeat.i(98100);
    int i = this.txH.getCurrentPosition();
    AppMethodBeat.o(98100);
    return i;
  }
  
  public int getDuration()
  {
    AppMethodBeat.i(98077);
    if (this.txH == null)
    {
      AppMethodBeat.o(98077);
      return 0;
    }
    int i = this.txH.getDuration();
    AppMethodBeat.o(98077);
    return i;
  }
  
  public String getFilePath()
  {
    return this.filePath;
  }
  
  public int getPlayErrorCode()
  {
    return this.wTz;
  }
  
  public int getPlayVideoDuration()
  {
    AppMethodBeat.i(98094);
    if (this.KHH < 0) {
      this.KHH = 0;
    }
    Log.i(this.TAG, "%d get play video duration [%d]", new Object[] { Integer.valueOf(hashCode()), Integer.valueOf(this.KHH) });
    int i = this.KHH;
    AppMethodBeat.o(98094);
    return i;
  }
  
  public int getPlayVideoDurationByResume()
  {
    AppMethodBeat.i(98097);
    if (this.KHJ < 0) {
      this.KHJ = 0;
    }
    Log.i(this.TAG, "%d get play video duration by resume [%d]", new Object[] { Integer.valueOf(hashCode()), Integer.valueOf(this.KHJ) });
    int i = this.KHJ;
    AppMethodBeat.o(98097);
    return i;
  }
  
  public ap.c getRptStruct()
  {
    AppMethodBeat.i(98099);
    ap.c localc = new ap.c();
    localc.scene = this.scene;
    localc.sessionId = this.sessionId;
    localc.KHs = this.KHs;
    localc.fLp = this.fLp;
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
    return this.KHs;
  }
  
  public String getSnsId()
  {
    return this.fLp;
  }
  
  public int getUiStayTime()
  {
    if ((this.KHq > 0L) && (this.KHp > 0L)) {}
    for (int i = (int)(this.KHq - this.KHp);; i = 0)
    {
      if (i < 0) {
        return 0;
      }
      return i;
    }
  }
  
  public int getVideoVideoMoveMargin()
  {
    return this.KHO;
  }
  
  public int getVideoViewBottom()
  {
    return this.KHN;
  }
  
  public final boolean isPlaying()
  {
    AppMethodBeat.i(98098);
    boolean bool = this.txH.isPlaying();
    AppMethodBeat.o(98098);
    return bool;
  }
  
  public final void jS(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(216064);
    Log.i(this.TAG, "showSeekBarIfLessThanLimit limit:%d current:%d total:%d", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(this.txH.getDuration()), Integer.valueOf(paramInt1) });
    this.KHx.setTotalTimeMs(paramInt1);
    boolean bool;
    if (paramInt1 >= paramInt2)
    {
      bool = ((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.vwc, true);
      Log.i(this.TAG, "enableShowSeekBar:%b", new Object[] { Boolean.valueOf(bool) });
      if (bool)
      {
        this.KHx.setVisibility(0);
        this.KHy.setVisibility(0);
        this.KHx.setVideoPlayDurationProvider(new HeroSeekBarView.c()
        {
          public final long fUx()
          {
            AppMethodBeat.i(252722);
            long l = OnlineVideoView.this.txH.getCurrentPosition();
            AppMethodBeat.o(252722);
            return l;
          }
        });
        HeroSeekBarView localHeroSeekBarView = this.KHx;
        localHeroSeekBarView.Rrz = true;
        kotlinx.coroutines.g.b(localHeroSeekBarView.rcY, null, (kotlin.g.a.m)new HeroSeekBarView.f(localHeroSeekBarView, null), 3);
        localHeroSeekBarView = this.KHx;
        if (!TextUtils.isEmpty(this.txH.getVideoPath()))
        {
          bool = true;
          localHeroSeekBarView.setEnableDrag(bool);
        }
      }
    }
    for (;;)
    {
      if ((this.txH instanceof View)) {
        this.fuk = com.tencent.e.h.ZvG.bg(new OnlineVideoView.27(this));
      }
      AppMethodBeat.o(216064);
      return;
      bool = false;
      break;
      fhw();
    }
  }
  
  public final void onCompletion()
  {
    AppMethodBeat.i(98085);
    Log.i(this.TAG, "%d on completion", new Object[] { Integer.valueOf(hashCode()) });
    Object localObject = this.KHi;
    if (localObject == null) {
      if ((com.tencent.mm.compatible.util.d.qX(18)) || (!this.wTy)) {
        bc(0, true);
      }
    }
    for (;;)
    {
      if (this.KHx != null) {
        this.KHx.reset();
      }
      AppMethodBeat.o(98085);
      return;
      if (this.txH != null)
      {
        localObject = this.txH.getVideoPath();
        this.txH.stop();
        if (!u.agG((String)localObject))
        {
          String str = getRelocatedVideoPath();
          Log.w(this.TAG, "dealCompletion: file path is out of date, old path: %s, new path: %s", new Object[] { localObject, str });
          localObject = str;
          if (Util.isNullOrNil(str))
          {
            Log.e(this.TAG, "dealCompletion: invalid file");
            continue;
          }
        }
        cD((String)localObject, this.KHl);
        continue;
        ((b)localObject).onCompletion();
      }
    }
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(98070);
    Log.d(this.TAG, "%d on destroy %s", new Object[] { Integer.valueOf(hashCode()), Util.getStack() });
    this.KHq = Util.nowMilliSecond();
    unInit();
    this.KHt = false;
    AppMethodBeat.o(98070);
  }
  
  public final void onError(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(98083);
    Log.e(this.TAG, "%d on play video error what %d extra %d. isOnlinePlay %b isMMVideoPlayer[%b]", new Object[] { Integer.valueOf(hashCode()), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Boolean.valueOf(this.KHl), Boolean.valueOf(this.wTy) });
    Object localObject;
    if (this.KHl)
    {
      com.tencent.mm.plugin.report.service.h.IzE.idkeyStat(354L, 230L, 1L, false);
      this.wTz = paramInt2;
      fUo();
      localObject = this.txH.getVideoPath();
      this.KHn = (this.txH.getCurrentPosition() / 1000);
      if (!this.KHl) {
        break label426;
      }
      if (paramInt1 != -2) {
        break label387;
      }
      this.txH.stop();
    }
    for (;;)
    {
      try
      {
        showLoading();
        if (this.KHk != null)
        {
          localObject = this.KHk;
          str = ((ap)localObject).mfu + 0 + "_-1";
          if (!((ap)localObject).KIf.containsKey(str))
          {
            Log.i(((ap)localObject).TAG, "request all data. [%s]", new Object[] { ((ap)localObject).mfu });
            s.bqC();
            com.tencent.mm.aq.e.s(((ap)localObject).mfu, 0, -1);
            ((ap)localObject).KIf.put(str, Integer.valueOf(0));
            com.tencent.mm.plugin.report.service.h.IzE.idkeyStat(354L, 207L, 1L, false);
            com.tencent.mm.plugin.report.service.h.IzE.a(13836, new Object[] { Integer.valueOf(403), Long.valueOf(Util.nowSecond()), "" });
          }
          ((ap)localObject).mfx = 5;
          ((ap)localObject).mfC = true;
          ((ap)localObject).mfF = false;
        }
        if (this.KHu != null) {
          this.KHu.gnP();
        }
        fUo();
      }
      catch (Exception localException)
      {
        String str;
        label387:
        label426:
        continue;
      }
      if ((this.fVT != null) && (this.fVT.isAd)) {
        com.tencent.mm.plugin.report.service.h.IzE.el(1579, 8);
      }
      AppMethodBeat.o(98083);
      return;
      com.tencent.mm.plugin.report.service.h.IzE.idkeyStat(354L, 231L, 1L, false);
      break;
      if (paramInt1 == -3)
      {
        this.KHo = paramInt1;
        this.txH.pause();
      }
      else
      {
        fTZ();
        this.txH.stop();
        continue;
        this.txH.stop();
        this.wTx = true;
        if ((this.txH instanceof ThumbPlayerVideoView))
        {
          e(false, 0.0F);
          Log.w(this.TAG, "error %s, %s", new Object[] { Boolean.valueOf(this.KHC), localObject });
          if ((!Util.isNullOrNil((String)localObject)) && (this.KHC) && (u.agG((String)localObject)))
          {
            Log.w(this.TAG, "%d start third player to play", new Object[] { Integer.valueOf(hashCode()) });
            this.twz.post(new Runnable()
            {
              public final void run()
              {
                AppMethodBeat.i(204433);
                Object localObject = new Intent();
                ((Intent)localObject).setAction("android.intent.action.VIEW");
                FileProviderHelper.setIntentDataAndType(OnlineVideoView.this.getContext(), (Intent)localObject, new q(this.wTJ), "video/*", false);
                try
                {
                  Context localContext = OnlineVideoView.this.getContext();
                  localObject = new com.tencent.mm.hellhoundlib.b.a().bm(localObject);
                  com.tencent.mm.hellhoundlib.a.a.b(localContext, ((com.tencent.mm.hellhoundlib.b.a)localObject).aFh(), "com/tencent/mm/plugin/sns/ui/OnlineVideoView$25", "run", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                  localContext.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).sf(0));
                  com.tencent.mm.hellhoundlib.a.a.c(localContext, "com/tencent/mm/plugin/sns/ui/OnlineVideoView$25", "run", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                  AppMethodBeat.o(204433);
                  return;
                }
                catch (Exception localException)
                {
                  Log.e(OnlineVideoView.c(OnlineVideoView.this), "startActivity fail, activity not found");
                  try
                  {
                    com.tencent.mm.ui.widget.a.f.a locala = new com.tencent.mm.ui.widget.a.f.a(OnlineVideoView.this.getContext());
                    locala.bBl(OnlineVideoView.this.getContext().getString(i.j.favorite_no_match_msg));
                    locala.aR(OnlineVideoView.this.getContext().getString(i.j.favorite_no_match_title)).c(new OnlineVideoView.18.1(this)).show();
                    AppMethodBeat.o(204433);
                    return;
                  }
                  catch (Throwable localThrowable)
                  {
                    Log.e(OnlineVideoView.c(OnlineVideoView.this), "showAlert fail");
                    AppMethodBeat.o(204433);
                  }
                }
              }
            });
          }
        }
        else
        {
          d(false, 0.0F);
          continue;
        }
        if (!u.agG((String)localObject))
        {
          str = getRelocatedVideoPath();
          Log.w(this.TAG, "onError: file path is out of date, old path: %s, new path: %s", new Object[] { localObject, str });
          if (Util.isNullOrNil(str))
          {
            Log.e(this.TAG, "onError: invalid file");
            AppMethodBeat.o(98083);
            return;
          }
          cD(str, this.KHl);
        }
      }
    }
  }
  
  public final void onPause()
  {
    AppMethodBeat.i(98069);
    Log.d(this.TAG, "%d on pause %s ", new Object[] { Integer.valueOf(hashCode()), Util.getStack() });
    fTZ();
    if (this.txH != null) {
      this.txH.stop();
    }
    this.KHt = false;
    AppMethodBeat.o(98069);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(98068);
    Log.d(this.TAG, "%d on resume %s", new Object[] { Integer.valueOf(hashCode()), Util.getStack() });
    this.KHp = Util.nowMilliSecond();
    this.KHt = true;
    if (this.KHA)
    {
      Log.e(this.TAG, "what are you doing guys!!! Would you like to invite everyone to eat pizza??? %s", new Object[] { Util.getStack() });
      com.tencent.mm.plugin.report.service.h.IzE.p(31L, 3L, 1L);
    }
    while (this.isInit)
    {
      if (!this.wTx) {
        dmh();
      }
      this.KGW = true;
      AppMethodBeat.o(98068);
      return;
    }
    this.isInit = true;
    Log.i(this.TAG, "%d logic init, create new helper and add listener.", new Object[] { Integer.valueOf(hashCode()) });
    if ((this.txH instanceof ThumbPlayerVideoView))
    {
      com.tencent.mm.plugin.thumbplayer.g.d locald = new com.tencent.mm.plugin.thumbplayer.g.d(new mj(), this.KHp, 2);
      com.tencent.mm.plugin.thumbplayer.g.b localb = new com.tencent.mm.plugin.thumbplayer.g.b(this.KHp);
      final ThumbPlayerVideoView localThumbPlayerVideoView = (ThumbPlayerVideoView)this.txH;
      localThumbPlayerVideoView.a(localb);
      localThumbPlayerVideoView.a(locald);
      localThumbPlayerVideoView.setProgressListener(new ThumbPlayerVideoView.d()
      {
        public final void Np(long paramAnonymousLong)
        {
          AppMethodBeat.i(219314);
          OnlineVideoView.this.agQ((int)paramAnonymousLong);
          AppMethodBeat.o(219314);
        }
      });
      if ((this.fVT != null) && (this.fCM != null))
      {
        this.KHv = new com.tencent.mm.plugin.sns.ui.video.c(this.fVT, this.createTime, this.fCM, localb, new com.tencent.mm.plugin.sns.ui.video.c.b()
        {
          public final ap.c fUy()
          {
            AppMethodBeat.i(198053);
            ap.c localc = OnlineVideoView.this.getRptStruct();
            AppMethodBeat.o(198053);
            return localc;
          }
          
          public final long fUz()
          {
            AppMethodBeat.i(198055);
            long l = OnlineVideoView.this.getPlayVideoDurationByResume();
            AppMethodBeat.o(198055);
            return l;
          }
        });
        this.KHu = new com.tencent.mm.plugin.thumbplayer.c.d(this.KHv);
        this.KHu.a(locald);
        this.KHu.a(localb);
        this.KHw = new com.tencent.mm.plugin.sns.ui.video.f(this.KHu, new com.tencent.mm.plugin.sns.ui.video.f.a()
        {
          public final void cf(float paramAnonymousFloat)
          {
            AppMethodBeat.i(221043);
            Log.i(OnlineVideoView.c(OnlineVideoView.this), "onProgress: %f", new Object[] { Float.valueOf(paramAnonymousFloat) });
            if ((OnlineVideoView.p(OnlineVideoView.this) != null) && (OnlineVideoView.p(OnlineVideoView.this).getVisibility() != 8)) {
              OnlineVideoView.p(OnlineVideoView.this).setVisibility(8);
            }
            if (OnlineVideoView.q(OnlineVideoView.this) != null)
            {
              if (OnlineVideoView.q(OnlineVideoView.this).getVisibility() != 0) {
                OnlineVideoView.q(OnlineVideoView.this).setVisibility(0);
              }
              if ((OnlineVideoView.q(OnlineVideoView.this).getMax() != 100) && (paramAnonymousFloat > 0.0F)) {
                OnlineVideoView.q(OnlineVideoView.this).setMax(100);
              }
              OnlineVideoView.q(OnlineVideoView.this).setProgress((int)paramAnonymousFloat);
            }
            AppMethodBeat.o(221043);
          }
          
          public final void fUA()
          {
            AppMethodBeat.i(221029);
            Log.i(OnlineVideoView.c(OnlineVideoView.this), "onMoovReady");
            if (OnlineVideoView.this.KHu != null)
            {
              localThumbPlayerVideoView.setResourceDownloader(OnlineVideoView.this.KHu);
              localThumbPlayerVideoView.prepare();
              OnlineVideoView.this.cD(OnlineVideoView.this.KHu.gnQ(), true);
            }
            AppMethodBeat.o(221029);
          }
          
          public final void fUB()
          {
            AppMethodBeat.i(221034);
            Log.i(OnlineVideoView.c(OnlineVideoView.this), "onCompleted");
            if (OnlineVideoView.j(OnlineVideoView.this) > 0)
            {
              OnlineVideoView.f(OnlineVideoView.this);
              OnlineVideoView.a(OnlineVideoView.this, OnlineVideoView.j(OnlineVideoView.this));
            }
            for (;;)
            {
              OnlineVideoView.o(OnlineVideoView.this).fZm();
              OnlineVideoView.f(OnlineVideoView.this);
              AppMethodBeat.o(221034);
              return;
              if (OnlineVideoView.k(OnlineVideoView.this) > 0)
              {
                OnlineVideoView.f(OnlineVideoView.this);
                OnlineVideoView.a(OnlineVideoView.this, OnlineVideoView.k(OnlineVideoView.this), OnlineVideoView.l(OnlineVideoView.this));
              }
              else if (OnlineVideoView.m(OnlineVideoView.this))
              {
                OnlineVideoView.f(OnlineVideoView.this);
                OnlineVideoView.n(OnlineVideoView.this);
              }
              else if (OnlineVideoView.this.KHu != null)
              {
                OnlineVideoView.this.cD(OnlineVideoView.this.KHu.gnQ(), false);
              }
            }
          }
          
          public final void onError(Exception paramAnonymousException)
          {
            AppMethodBeat.i(221035);
            Log.printErrStackTrace(OnlineVideoView.c(OnlineVideoView.this), paramAnonymousException, "onError", new Object[0]);
            AppMethodBeat.o(221035);
          }
        });
      }
    }
    for (;;)
    {
      EventCenter.instance.addListener(this.KHE);
      aj.fOD().a(this.KHD);
      if (this.KHr)
      {
        this.sUi = com.tencent.mm.model.d.bcs();
        this.sUi.a(this);
      }
      if (com.tencent.mm.q.a.abL() == null) {
        break;
      }
      com.tencent.mm.q.a.abL().aqn();
      break;
      Log.e(this.TAG, "null check failed: media=%s, localId=%s", new Object[] { this.fVT, this.fCM });
      continue;
      this.KHk = new ap(this);
      Log.i(this.TAG, "onlineVideoHelper hash:%d", new Object[] { Integer.valueOf(this.KHk.hashCode()) });
      EventCenter.instance.addListener(this.Kbu);
    }
  }
  
  public final void qX()
  {
    AppMethodBeat.i(98084);
    Log.i(this.TAG, "%d onPrepared playErrorCode[%d] onErrorPlayTimeSec[%d] allowStart[%s]", new Object[] { Integer.valueOf(hashCode()), Integer.valueOf(this.wTz), Integer.valueOf(this.KHn), Boolean.toString(this.KHt) });
    this.wTz = 0;
    if ((this.txH instanceof ThumbPlayerVideoView))
    {
      this.txH.setOneTimeVideoTextureUpdateCallback(this.KHb);
      e(true, 0.0F);
      if (this.KHw != null) {
        this.KHw.fZm();
      }
    }
    if (this.KHt)
    {
      if (this.KHn > 0)
      {
        bc(this.KHn, true);
        this.KHn = 0;
        AppMethodBeat.o(98084);
        return;
      }
      this.KHo = 0;
      hideLoading();
      fUn();
      fUp();
      this.txH.start();
      this.duration = (this.txH.getDuration() / 1000);
      this.KHx.setTotalTimeMs(this.txH.getDuration());
      Log.i(this.TAG, "%d start play duration %d sns local id %s ", new Object[] { Integer.valueOf(hashCode()), Integer.valueOf(this.duration), this.fCM });
      gA(false);
      b localb = this.KHi;
      if (localb != null) {
        localb.onStart(this.duration);
      }
    }
    AppMethodBeat.o(98084);
  }
  
  public void setFilePath(String paramString)
  {
    this.filePath = paramString;
  }
  
  public void setMute(boolean paramBoolean)
  {
    AppMethodBeat.i(98067);
    this.iYs = paramBoolean;
    this.txH.setMute(this.iYs);
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
    this.KHs = paramLong;
  }
  
  public void setSnsId(String paramString)
  {
    this.fLp = paramString;
  }
  
  public void setThumbViewScaleType(ImageView.ScaleType paramScaleType)
  {
    AppMethodBeat.i(98101);
    this.wPh.setScaleType(paramScaleType);
    AppMethodBeat.o(98101);
  }
  
  public void setThumbViewVisibility(int paramInt)
  {
    AppMethodBeat.i(216131);
    this.wPh.setVisibility(paramInt);
    AppMethodBeat.o(216131);
  }
  
  public void setVideoCallback(b paramb)
  {
    this.KHi = paramb;
  }
  
  public void setVideoScaleType(com.tencent.mm.pluginsdk.ui.i.e parame)
  {
    AppMethodBeat.i(98102);
    if (this.txH != null)
    {
      if ((this.txH instanceof VideoPlayerTextureView))
      {
        ((VideoPlayerTextureView)this.txH).setScaleType(parame);
        AppMethodBeat.o(98102);
        return;
      }
      if ((this.txH instanceof VideoTextureView))
      {
        ((VideoTextureView)this.txH).setScaleType(parame);
        AppMethodBeat.o(98102);
        return;
      }
      if ((this.txH instanceof ThumbPlayerVideoView)) {
        ((ThumbPlayerVideoView)this.txH).setScaleType(parame);
      }
    }
    AppMethodBeat.o(98102);
  }
  
  final class a
    implements Runnable
  {
    int KIc = -1;
    long KIe = -1L;
    
    private a() {}
    
    public final void run()
    {
      AppMethodBeat.i(242878);
      this.KIe = SystemClock.uptimeMillis();
      OnlineVideoView.this.bc(this.KIc, false);
      AppMethodBeat.o(242878);
    }
  }
  
  public static abstract interface b
  {
    public abstract void AS(int paramInt);
    
    public abstract void onCompletion();
    
    public abstract void onStart(int paramInt);
  }
  
  public static abstract interface c
    extends OnlineVideoView.b
  {
    public abstract void onPause();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.OnlineVideoView
 * JD-Core Version:    0.7.0.1
 */