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
import android.widget.Toast;
import androidx.lifecycle.q;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.app.AppForegroundDelegate;
import com.tencent.mm.app.l;
import com.tencent.mm.app.l.a;
import com.tencent.mm.app.l.b;
import com.tencent.mm.autogen.a.dn;
import com.tencent.mm.autogen.a.dn.b;
import com.tencent.mm.autogen.a.ra;
import com.tencent.mm.autogen.a.ra.a;
import com.tencent.mm.autogen.a.yh;
import com.tencent.mm.autogen.a.yk;
import com.tencent.mm.autogen.a.yk.a;
import com.tencent.mm.autogen.a.zm;
import com.tencent.mm.autogen.mmdata.rpt.pm;
import com.tencent.mm.model.ap;
import com.tencent.mm.model.d.a;
import com.tencent.mm.modelcontrol.e;
import com.tencent.mm.modelvideo.v;
import com.tencent.mm.platformtools.ExportFileUtil;
import com.tencent.mm.platformtools.ExportFileUtil.a;
import com.tencent.mm.plugin.expt.b.c.a;
import com.tencent.mm.plugin.sight.base.SightVideoJNI;
import com.tencent.mm.plugin.sns.b.d;
import com.tencent.mm.plugin.sns.b.e;
import com.tencent.mm.plugin.sns.b.f;
import com.tencent.mm.plugin.sns.b.g;
import com.tencent.mm.plugin.sns.b.j;
import com.tencent.mm.plugin.sns.data.t;
import com.tencent.mm.plugin.sns.model.al;
import com.tencent.mm.plugin.sns.model.as;
import com.tencent.mm.plugin.sns.model.az;
import com.tencent.mm.plugin.sns.model.g;
import com.tencent.mm.plugin.sns.storage.SnsInfo;
import com.tencent.mm.plugin.sns.storage.w;
import com.tencent.mm.plugin.sns.ui.video.f.a;
import com.tencent.mm.plugin.thumbplayer.view.ThumbPlayerVideoView;
import com.tencent.mm.plugin.thumbplayer.view.ThumbPlayerVideoView.c;
import com.tencent.mm.plugin.thumbplayer.view.ThumbPlayerVideoView.d;
import com.tencent.mm.pluginsdk.ui.seekbar.HeroSeekBarView;
import com.tencent.mm.pluginsdk.ui.seekbar.HeroSeekBarView.b;
import com.tencent.mm.pluginsdk.ui.seekbar.HeroSeekBarView.c;
import com.tencent.mm.pluginsdk.ui.seekbar.HeroSeekBarView.f;
import com.tencent.mm.pluginsdk.ui.tools.VideoPlayerTextureView;
import com.tencent.mm.pluginsdk.ui.tools.VideoTextureView;
import com.tencent.mm.pluginsdk.ui.tools.i.a;
import com.tencent.mm.pluginsdk.ui.tools.i.b;
import com.tencent.mm.pointers.PInt;
import com.tencent.mm.protocal.protobuf.TimeLineObject;
import com.tencent.mm.protocal.protobuf.agh;
import com.tencent.mm.protocal.protobuf.dmz;
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
import com.tencent.mm.storage.at.a;
import com.tencent.mm.storage.br;
import com.tencent.mm.ui.widget.MMPinProgressBtn;
import com.tencent.mm.ui.widget.a.g.a;
import com.tencent.mm.ui.widget.a.g.c;
import com.tencent.mm.vfs.u;
import com.tencent.mm.vfs.y;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.concurrent.Future;

public class OnlineVideoView
  extends RelativeLayout
  implements d.a, aq.a, i.a
{
  ImageView AlJ;
  private RelativeLayout Amd;
  private TextView ApV;
  public boolean Aqa;
  private boolean Aqb;
  private int Aqc;
  private MMPinProgressBtn Aqf;
  private com.tencent.mm.plugin.u.b KSQ;
  private MTimerHandler QTh;
  private br Qob;
  private IListener QyK;
  private com.tencent.mm.pluginsdk.ui.tools.i.e RgB;
  private int RgE;
  String RgF;
  private String RgG;
  private boolean RgH;
  private b RgI;
  protected ImageView RgJ;
  protected volatile aq RgK;
  private boolean RgL;
  private boolean RgM;
  private int RgN;
  private int RgO;
  private long RgP;
  private long RgQ;
  protected boolean RgR;
  private long RgS;
  private boolean RgT;
  protected com.tencent.mm.plugin.thumbplayer.downloader.i RgU;
  protected com.tencent.mm.plugin.sns.ui.video.c RgV;
  private com.tencent.mm.plugin.sns.ui.video.f RgW;
  private HeroSeekBarView RgX;
  private ImageView RgY;
  private final a RgZ;
  private boolean Rgw;
  public volatile boolean Rha;
  protected Activity Rhb;
  protected boolean Rhc;
  private Runnable Rhd;
  private com.tencent.mm.plugin.sns.model.c.b Rhe;
  private IListener Rhf;
  private IListener Rhg;
  private long Rhh;
  private int Rhi;
  private long Rhj;
  private int Rhk;
  private boolean Rhl;
  public boolean Rhm;
  private int Rhn;
  private int Rho;
  private int Rhp;
  final String TAG;
  boolean cFq;
  private int createTime;
  private Future<?> dBj;
  private int duration;
  private String filePath;
  private String hHB;
  private String hQX;
  private dmz ibT;
  private int icC;
  private boolean icD;
  private int icE;
  private volatile boolean isInit;
  boolean isPreview;
  private boolean lAj;
  private Context mContext;
  private TextView nhp;
  private int pvk;
  private ProgressBar sIX;
  private int scene;
  private String sessionId;
  com.tencent.mm.model.d vZw;
  private int videoHeight;
  private int videoWidth;
  MMHandler wAW;
  protected com.tencent.mm.pluginsdk.ui.tools.i wCd;
  private MTimerHandler wCj;
  
  public OnlineVideoView(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(307837);
    this.TAG = ("MicroMsg.OnlineVideoView[" + hashCode() + ']');
    this.RgE = 0;
    this.isPreview = false;
    this.Aqa = false;
    this.lAj = false;
    this.ibT = null;
    this.RgH = false;
    this.RgK = null;
    this.RgM = false;
    this.duration = 0;
    this.RgN = 0;
    this.RgO = 0;
    this.RgP = 0L;
    this.RgQ = 0L;
    this.Aqc = 0;
    this.vZw = null;
    this.RgR = true;
    this.wAW = new MMHandler(Looper.getMainLooper());
    this.scene = 0;
    this.RgS = 0L;
    this.sessionId = "";
    this.hQX = "";
    this.filePath = "";
    this.videoWidth = 0;
    this.videoHeight = 0;
    this.RgT = true;
    this.cFq = false;
    this.RgZ = new a((byte)0);
    this.isInit = false;
    this.Rha = false;
    this.Rhc = false;
    this.Rhd = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(308112);
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
            OnlineVideoView.q(OnlineVideoView.this).jEN();
          }
          if ((OnlineVideoView.p(OnlineVideoView.this) != null) && (OnlineVideoView.p(OnlineVideoView.this).getVisibility() != 8)) {
            OnlineVideoView.p(OnlineVideoView.this).setVisibility(8);
          }
        }
        AppMethodBeat.o(308112);
      }
    };
    this.QTh = new MTimerHandler(new MTimerHandler.CallBack()
    {
      public final boolean onTimerExpired()
      {
        AppMethodBeat.i(308226);
        if ((OnlineVideoView.this.RgK == null) || (OnlineVideoView.this.wCd == null))
        {
          AppMethodBeat.o(308226);
          return false;
        }
        if (((View)OnlineVideoView.this.wCd).getAlpha() < 1.0F)
        {
          Log.i(OnlineVideoView.c(OnlineVideoView.this), "onlineVideoTimer switchVideoModel");
          OnlineVideoView.G(OnlineVideoView.this);
        }
        if (OnlineVideoView.this.wCd.isPlaying()) {
          OnlineVideoView.f(OnlineVideoView.this);
        }
        try
        {
          boolean bool = Util.isNullOrNil(OnlineVideoView.this.RgK.oYq);
          if (!bool) {}
          for (int i = 1; i == 0; i = 0)
          {
            AppMethodBeat.o(308226);
            return false;
          }
          i = OnlineVideoView.this.wCd.getCurrentPosition();
          OnlineVideoView.this.alJ(i);
          bool = OnlineVideoView.this.RgK.xa(i / 1000);
          AppMethodBeat.o(308226);
          return bool;
        }
        catch (Exception localException)
        {
          Log.e(OnlineVideoView.c(OnlineVideoView.this), "online video timer check error : " + localException.toString());
          AppMethodBeat.o(308226);
        }
        return false;
      }
    }, true);
    this.wCj = new MTimerHandler(new MTimerHandler.CallBack()
    {
      public final boolean onTimerExpired()
      {
        AppMethodBeat.i(308225);
        if (OnlineVideoView.this.wCd == null)
        {
          AppMethodBeat.o(308225);
          return false;
        }
        if (((View)OnlineVideoView.this.wCd).getAlpha() < 1.0F)
        {
          Log.i(OnlineVideoView.c(OnlineVideoView.this), "offlineVideoTimer switchVideoModel");
          OnlineVideoView.G(OnlineVideoView.this);
        }
        if (OnlineVideoView.this.wCd.isPlaying())
        {
          OnlineVideoView.f(OnlineVideoView.this);
          OnlineVideoView.this.alJ(OnlineVideoView.this.wCd.getCurrentPosition());
        }
        AppMethodBeat.o(308225);
        return true;
      }
    }, true);
    this.Rhe = new com.tencent.mm.plugin.sns.model.c.b()
    {
      public final void EE(String paramAnonymousString) {}
      
      public final void aXr() {}
      
      public final void w(String paramAnonymousString, boolean paramAnonymousBoolean) {}
      
      public final void x(final String paramAnonymousString, final boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(307706);
        OnlineVideoView.g(OnlineVideoView.this).postDelayed(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(98041);
            Log.i(OnlineVideoView.c(OnlineVideoView.this), "%d weixin download finish[%b], go to prepare video", new Object[] { Integer.valueOf(OnlineVideoView.this.hashCode()), Boolean.valueOf(paramAnonymousBoolean) });
            if ((OnlineVideoView.u(OnlineVideoView.this) != null) && (paramAnonymousBoolean) && (Util.isEqual(OnlineVideoView.u(OnlineVideoView.this).Id, paramAnonymousString)))
            {
              az.mk(OnlineVideoView.s(OnlineVideoView.this), "");
              String str = az.a(OnlineVideoView.s(OnlineVideoView.this), OnlineVideoView.u(OnlineVideoView.this));
              if (!Util.isNullOrNil(str)) {
                OnlineVideoView.this.di(str, false);
              }
            }
            AppMethodBeat.o(98041);
          }
        }, 100L);
        AppMethodBeat.o(307706);
      }
    };
    this.Rhf = new IListener(com.tencent.mm.app.f.hfK) {};
    this.Rhg = new IListener(com.tencent.mm.app.f.hfK) {};
    this.QyK = new IListener(com.tencent.mm.app.f.hfK)
    {
      private boolean a(ra paramAnonymousra)
      {
        AppMethodBeat.i(308454);
        if (OnlineVideoView.this.RgK == null)
        {
          Log.w(OnlineVideoView.c(OnlineVideoView.this), "%d online video helper is null.", new Object[] { Integer.valueOf(OnlineVideoView.this.hashCode()) });
          AppMethodBeat.o(308454);
          return false;
        }
        Log.w(OnlineVideoView.c(OnlineVideoView.this), "OnlineVideoEvent is received, the OnlineVideoEvent opcode is " + paramAnonymousra.hTZ.hId);
        Log.w(OnlineVideoView.c(OnlineVideoView.this), "OnlineVideoEvent is received, the OnlineVideoEvent length is " + paramAnonymousra.hTZ.length);
        Log.w(OnlineVideoView.c(OnlineVideoView.this), "OnlineVideoEvent is received, the OnlineVideoEvent offset is " + paramAnonymousra.hTZ.offset);
        Log.w(OnlineVideoView.c(OnlineVideoView.this), "OnlineVideoEvent is received, the OnlineVideoEvent mediaId is " + paramAnonymousra.hTZ.mediaId);
        Log.w(OnlineVideoView.c(OnlineVideoView.this), "OnlineVideoEvent is received, the OnlineVideoEvent retCode is " + paramAnonymousra.hTZ.retCode);
        Log.w(OnlineVideoView.c(OnlineVideoView.this), "OnlineVideoEvent is received, the OnlineVideoEvent startDownload is " + paramAnonymousra.hTZ.hUa);
        try
        {
          bool = OnlineVideoView.this.RgK.bay(paramAnonymousra.hTZ.mediaId);
          if (!bool)
          {
            AppMethodBeat.o(308454);
            return false;
          }
          if (paramAnonymousra.hTZ.retCode == -21112)
          {
            paramAnonymousra = OnlineVideoView.this;
            com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(354L, 218L, 1L, false);
            paramAnonymousra.wAW.post(new OnlineVideoView.15(paramAnonymousra));
            AppMethodBeat.o(308454);
            return false;
          }
          if ((paramAnonymousra.hTZ.retCode != 0) && (paramAnonymousra.hTZ.retCode != -21006))
          {
            Log.w(OnlineVideoView.c(OnlineVideoView.this), "%d stream download online video error. retCode %d ", new Object[] { Integer.valueOf(OnlineVideoView.this.hashCode()), Integer.valueOf(paramAnonymousra.hTZ.retCode) });
            AppMethodBeat.o(308454);
            return false;
          }
          switch (paramAnonymousra.hTZ.hId)
          {
          }
        }
        catch (Exception paramAnonymousra)
        {
          for (;;)
          {
            boolean bool;
            long l2;
            long l1;
            Log.e(OnlineVideoView.c(OnlineVideoView.this), "online video callback error: " + paramAnonymousra.toString());
            continue;
            if (l1 > localaq.lxf) {}
            for (;;)
            {
              for (;;)
              {
                localaq.lxf = l1;
                localaq.RhK = Util.nowMilliSecond();
                try
                {
                  if (localaq.RhG != null) {
                    break label744;
                  }
                  Log.w(localaq.TAG, "parser is null, thread is error.");
                }
                catch (Exception paramAnonymousra)
                {
                  Log.e(localaq.TAG, "deal moov ready error: " + paramAnonymousra.toString());
                }
              }
              break;
              l1 = localaq.lxf;
            }
            if (localaq.RhG.O(localaq.oYr, l2))
            {
              localaq.oYv = localaq.RhG.pEg;
              Log.i(localaq.TAG, "mp4 parse moov success. duration %d cdnMediaId %s isFastStart %b", new Object[] { Integer.valueOf(localaq.oYv), localaq.oYq, Boolean.valueOf(bool) });
              if (!bool) {
                MMHandlerThread.postToMainThread(new aq.1(localaq));
              }
              if (localaq.oYw == -1) {}
              for (localaq.oYt = 1;; localaq.oYt = 2)
              {
                com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(354L, 204L, 1L, false);
                break;
              }
            }
            Log.w(localaq.TAG, "mp4 parse moov error. cdnMediaId %s", new Object[] { localaq.oYq });
            v.bOi();
            com.tencent.mm.modelcdntran.j.v(localaq.oYq, 0, -1);
            com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(354L, 205L, 1L, false);
            com.tencent.mm.plugin.report.service.h.OAn.b(13836, new Object[] { Integer.valueOf(402), Long.valueOf(Util.nowSecond()), "" });
            continue;
            aq localaq = OnlineVideoView.this.RgK;
            Object localObject = paramAnonymousra.hTZ.mediaId;
            int i = paramAnonymousra.hTZ.offset;
            int j = paramAnonymousra.hTZ.length;
            localaq.oYC = false;
            if ((i < 0) || (j < 0)) {
              Log.w(localaq.TAG, "deal data available error offset[%d], length[%d]", new Object[] { Integer.valueOf(i), Integer.valueOf(j) });
            }
            while (!localaq.bay((String)localObject))
            {
              if (paramAnonymousra.hTZ.length <= 0) {
                break;
              }
              OnlineVideoView.this.ho(true);
              break;
            }
            localObject = localaq.oYq + i + "_" + j;
            localObject = (Integer)localaq.RhF.get(localObject);
            if ((localObject != null) && (((Integer)localObject).intValue() > 0)) {
              localaq.oYz = ((Integer)localObject).intValue();
            }
            for (;;)
            {
              Log.i(localaq.TAG, "deal data available. offset[%d] length[%d] cachePlayTime[%d]", new Object[] { Integer.valueOf(i), Integer.valueOf(j), Integer.valueOf(localaq.oYz) });
              break;
              try
              {
                localaq.oYz = localaq.RhG.eX(i, j);
              }
              catch (Exception localException)
              {
                Log.e(localaq.TAG, "deal data available file pos to video time error: " + localException.toString());
              }
            }
            OnlineVideoView.this.ho(true);
            continue;
            Log.i(OnlineVideoView.c(OnlineVideoView.this), "%d download finish. cdnMediaId %s sendReqCode %d favFromScene %d", new Object[] { Integer.valueOf(OnlineVideoView.this.hashCode()), paramAnonymousra.hTZ.mediaId, Integer.valueOf(OnlineVideoView.j(OnlineVideoView.this)), Integer.valueOf(OnlineVideoView.k(OnlineVideoView.this)) });
            paramAnonymousra = OnlineVideoView.this.RgK;
            Log.i(paramAnonymousra.TAG, "deal stream finish. playStatus %d cdnMediaId %s", new Object[] { Integer.valueOf(paramAnonymousra.oYt), paramAnonymousra.oYq });
            paramAnonymousra.oYC = false;
            paramAnonymousra.oYs = 3;
            com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(354L, 206L, 1L, false);
            if (paramAnonymousra.oYt == 0)
            {
              Log.w(paramAnonymousra.TAG, "it had not moov callback and download finish start to play video.");
              paramAnonymousra.hmV();
            }
            for (;;)
            {
              if (OnlineVideoView.j(OnlineVideoView.this) <= 0) {
                break label1478;
              }
              OnlineVideoView.f(OnlineVideoView.this);
              OnlineVideoView.a(OnlineVideoView.this, OnlineVideoView.j(OnlineVideoView.this));
              break;
              if (paramAnonymousra.oYt == 5)
              {
                Log.w(paramAnonymousra.TAG, "it had play error, it request all video data finish, start to play." + paramAnonymousra.oYq);
                paramAnonymousra.hmV();
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
              OnlineVideoView.this.ho(true);
              continue;
              if (OnlineVideoView.E(OnlineVideoView.this) == 1)
              {
                localaq = OnlineVideoView.this.RgK;
                String str = paramAnonymousra.hTZ.mediaId;
                i = paramAnonymousra.hTZ.offset;
                j = paramAnonymousra.hTZ.length;
                if (localaq.bay(str))
                {
                  localaq.progress = i;
                  localaq.total = j;
                  localaq.RhI = (localaq.progress * 100 / localaq.total);
                  Log.i(localaq.TAG, "deal video[%s] progress callback[%d, %d]. downloadedPercent[%d]", new Object[] { localaq.oYq, Integer.valueOf(localaq.progress), Integer.valueOf(localaq.total), Integer.valueOf(localaq.RhI) });
                }
                if (localaq.RhI >= 100) {
                  localaq.oYs = 3;
                }
              }
              else if (OnlineVideoView.E(OnlineVideoView.this) == 2)
              {
                OnlineVideoView.a(OnlineVideoView.this, paramAnonymousra.hTZ.offset, paramAnonymousra.hTZ.length);
                continue;
                paramAnonymousra = OnlineVideoView.this.RgK;
                Log.i(paramAnonymousra.TAG, "deal had dup video. cdnMediaId %s", new Object[] { paramAnonymousra.oYq });
                paramAnonymousra.hmV();
              }
            }
          }
        }
        Log.w(OnlineVideoView.c(OnlineVideoView.this), "%d unknown event opcode %d", new Object[] { Integer.valueOf(OnlineVideoView.this.hashCode()), Integer.valueOf(paramAnonymousra.hTZ.hId) });
        for (;;)
        {
          AppMethodBeat.o(308454);
          return false;
          localaq = OnlineVideoView.this.RgK;
          l2 = paramAnonymousra.hTZ.offset;
          l1 = paramAnonymousra.hTZ.hUa;
          bool = paramAnonymousra.hTZ.hUb;
          Log.i(localaq.TAG, "deal moov ready moovPos %d, timeDuration %d, cdnMediaId %s startDownload[%d %d]", new Object[] { Long.valueOf(l2), Integer.valueOf(localaq.oYv), localaq.oYq, Long.valueOf(l1), Long.valueOf(localaq.lxf) });
          if (localaq.oYv == 0) {
            break;
          }
          Log.w(localaq.TAG, "moov had callback, do nothing.");
          OnlineVideoView.J(OnlineVideoView.this);
        }
      }
    };
    this.RgB = new com.tencent.mm.pluginsdk.ui.tools.i.e()
    {
      public final void onTextureUpdate()
      {
        AppMethodBeat.i(307767);
        Log.i(OnlineVideoView.c(OnlineVideoView.this), "%d on texture update.", new Object[] { Integer.valueOf(OnlineVideoView.this.hashCode()) });
        try
        {
          if ((OnlineVideoView.this.wCd instanceof ThumbPlayerVideoView))
          {
            OnlineVideoView.K(OnlineVideoView.this);
            AppMethodBeat.o(307767);
            return;
          }
          OnlineVideoView.G(OnlineVideoView.this);
          AppMethodBeat.o(307767);
          return;
        }
        catch (Exception localException)
        {
          Log.e(OnlineVideoView.c(OnlineVideoView.this), "texture view update. error " + localException.toString());
          AppMethodBeat.o(307767);
        }
      }
    };
    this.KSQ = new com.tencent.mm.plugin.u.b()
    {
      public final long gbz()
      {
        AppMethodBeat.i(307784);
        Log.i(OnlineVideoView.c(OnlineVideoView.this), "%d sns video get online cache", new Object[] { Integer.valueOf(OnlineVideoView.this.hashCode()) });
        com.tencent.mm.kernel.h.baF();
        com.tencent.mm.kernel.h.baE().ban().set(at.a.acPO, Boolean.TRUE);
        try
        {
          if ((OnlineVideoView.L(OnlineVideoView.this)) && (OnlineVideoView.this.RgK != null))
          {
            int i = OnlineVideoView.this.RgK.oYz;
            long l = i;
            AppMethodBeat.o(307784);
            return l;
          }
        }
        catch (Exception localException)
        {
          AppMethodBeat.o(307784);
        }
        return 0L;
      }
    };
    this.Rhl = true;
    this.Rhm = false;
    this.Rho = 0;
    this.Rhp = 0;
    this.pvk = 0;
    L(paramContext, true);
    AppMethodBeat.o(307837);
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
    this.RgE = 0;
    this.isPreview = false;
    this.Aqa = false;
    this.lAj = false;
    this.ibT = null;
    this.RgH = false;
    this.RgK = null;
    this.RgM = false;
    this.duration = 0;
    this.RgN = 0;
    this.RgO = 0;
    this.RgP = 0L;
    this.RgQ = 0L;
    this.Aqc = 0;
    this.vZw = null;
    this.RgR = true;
    this.wAW = new MMHandler(Looper.getMainLooper());
    this.scene = 0;
    this.RgS = 0L;
    this.sessionId = "";
    this.hQX = "";
    this.filePath = "";
    this.videoWidth = 0;
    this.videoHeight = 0;
    this.RgT = true;
    this.cFq = false;
    this.RgZ = new a((byte)0);
    this.isInit = false;
    this.Rha = false;
    this.Rhc = false;
    this.Rhd = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(308112);
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
            OnlineVideoView.q(OnlineVideoView.this).jEN();
          }
          if ((OnlineVideoView.p(OnlineVideoView.this) != null) && (OnlineVideoView.p(OnlineVideoView.this).getVisibility() != 8)) {
            OnlineVideoView.p(OnlineVideoView.this).setVisibility(8);
          }
        }
        AppMethodBeat.o(308112);
      }
    };
    this.QTh = new MTimerHandler(new MTimerHandler.CallBack()
    {
      public final boolean onTimerExpired()
      {
        AppMethodBeat.i(308226);
        if ((OnlineVideoView.this.RgK == null) || (OnlineVideoView.this.wCd == null))
        {
          AppMethodBeat.o(308226);
          return false;
        }
        if (((View)OnlineVideoView.this.wCd).getAlpha() < 1.0F)
        {
          Log.i(OnlineVideoView.c(OnlineVideoView.this), "onlineVideoTimer switchVideoModel");
          OnlineVideoView.G(OnlineVideoView.this);
        }
        if (OnlineVideoView.this.wCd.isPlaying()) {
          OnlineVideoView.f(OnlineVideoView.this);
        }
        try
        {
          boolean bool = Util.isNullOrNil(OnlineVideoView.this.RgK.oYq);
          if (!bool) {}
          for (int i = 1; i == 0; i = 0)
          {
            AppMethodBeat.o(308226);
            return false;
          }
          i = OnlineVideoView.this.wCd.getCurrentPosition();
          OnlineVideoView.this.alJ(i);
          bool = OnlineVideoView.this.RgK.xa(i / 1000);
          AppMethodBeat.o(308226);
          return bool;
        }
        catch (Exception localException)
        {
          Log.e(OnlineVideoView.c(OnlineVideoView.this), "online video timer check error : " + localException.toString());
          AppMethodBeat.o(308226);
        }
        return false;
      }
    }, true);
    this.wCj = new MTimerHandler(new MTimerHandler.CallBack()
    {
      public final boolean onTimerExpired()
      {
        AppMethodBeat.i(308225);
        if (OnlineVideoView.this.wCd == null)
        {
          AppMethodBeat.o(308225);
          return false;
        }
        if (((View)OnlineVideoView.this.wCd).getAlpha() < 1.0F)
        {
          Log.i(OnlineVideoView.c(OnlineVideoView.this), "offlineVideoTimer switchVideoModel");
          OnlineVideoView.G(OnlineVideoView.this);
        }
        if (OnlineVideoView.this.wCd.isPlaying())
        {
          OnlineVideoView.f(OnlineVideoView.this);
          OnlineVideoView.this.alJ(OnlineVideoView.this.wCd.getCurrentPosition());
        }
        AppMethodBeat.o(308225);
        return true;
      }
    }, true);
    this.Rhe = new com.tencent.mm.plugin.sns.model.c.b()
    {
      public final void EE(String paramAnonymousString) {}
      
      public final void aXr() {}
      
      public final void w(String paramAnonymousString, boolean paramAnonymousBoolean) {}
      
      public final void x(final String paramAnonymousString, final boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(307706);
        OnlineVideoView.g(OnlineVideoView.this).postDelayed(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(98041);
            Log.i(OnlineVideoView.c(OnlineVideoView.this), "%d weixin download finish[%b], go to prepare video", new Object[] { Integer.valueOf(OnlineVideoView.this.hashCode()), Boolean.valueOf(paramAnonymousBoolean) });
            if ((OnlineVideoView.u(OnlineVideoView.this) != null) && (paramAnonymousBoolean) && (Util.isEqual(OnlineVideoView.u(OnlineVideoView.this).Id, paramAnonymousString)))
            {
              az.mk(OnlineVideoView.s(OnlineVideoView.this), "");
              String str = az.a(OnlineVideoView.s(OnlineVideoView.this), OnlineVideoView.u(OnlineVideoView.this));
              if (!Util.isNullOrNil(str)) {
                OnlineVideoView.this.di(str, false);
              }
            }
            AppMethodBeat.o(98041);
          }
        }, 100L);
        AppMethodBeat.o(307706);
      }
    };
    this.Rhf = new IListener(com.tencent.mm.app.f.hfK) {};
    this.Rhg = new IListener(com.tencent.mm.app.f.hfK) {};
    this.QyK = new IListener(com.tencent.mm.app.f.hfK)
    {
      private boolean a(ra paramAnonymousra)
      {
        AppMethodBeat.i(308454);
        if (OnlineVideoView.this.RgK == null)
        {
          Log.w(OnlineVideoView.c(OnlineVideoView.this), "%d online video helper is null.", new Object[] { Integer.valueOf(OnlineVideoView.this.hashCode()) });
          AppMethodBeat.o(308454);
          return false;
        }
        Log.w(OnlineVideoView.c(OnlineVideoView.this), "OnlineVideoEvent is received, the OnlineVideoEvent opcode is " + paramAnonymousra.hTZ.hId);
        Log.w(OnlineVideoView.c(OnlineVideoView.this), "OnlineVideoEvent is received, the OnlineVideoEvent length is " + paramAnonymousra.hTZ.length);
        Log.w(OnlineVideoView.c(OnlineVideoView.this), "OnlineVideoEvent is received, the OnlineVideoEvent offset is " + paramAnonymousra.hTZ.offset);
        Log.w(OnlineVideoView.c(OnlineVideoView.this), "OnlineVideoEvent is received, the OnlineVideoEvent mediaId is " + paramAnonymousra.hTZ.mediaId);
        Log.w(OnlineVideoView.c(OnlineVideoView.this), "OnlineVideoEvent is received, the OnlineVideoEvent retCode is " + paramAnonymousra.hTZ.retCode);
        Log.w(OnlineVideoView.c(OnlineVideoView.this), "OnlineVideoEvent is received, the OnlineVideoEvent startDownload is " + paramAnonymousra.hTZ.hUa);
        try
        {
          bool = OnlineVideoView.this.RgK.bay(paramAnonymousra.hTZ.mediaId);
          if (!bool)
          {
            AppMethodBeat.o(308454);
            return false;
          }
          if (paramAnonymousra.hTZ.retCode == -21112)
          {
            paramAnonymousra = OnlineVideoView.this;
            com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(354L, 218L, 1L, false);
            paramAnonymousra.wAW.post(new OnlineVideoView.15(paramAnonymousra));
            AppMethodBeat.o(308454);
            return false;
          }
          if ((paramAnonymousra.hTZ.retCode != 0) && (paramAnonymousra.hTZ.retCode != -21006))
          {
            Log.w(OnlineVideoView.c(OnlineVideoView.this), "%d stream download online video error. retCode %d ", new Object[] { Integer.valueOf(OnlineVideoView.this.hashCode()), Integer.valueOf(paramAnonymousra.hTZ.retCode) });
            AppMethodBeat.o(308454);
            return false;
          }
          switch (paramAnonymousra.hTZ.hId)
          {
          }
        }
        catch (Exception paramAnonymousra)
        {
          for (;;)
          {
            boolean bool;
            long l2;
            long l1;
            Log.e(OnlineVideoView.c(OnlineVideoView.this), "online video callback error: " + paramAnonymousra.toString());
            continue;
            if (l1 > localaq.lxf) {}
            for (;;)
            {
              for (;;)
              {
                localaq.lxf = l1;
                localaq.RhK = Util.nowMilliSecond();
                try
                {
                  if (localaq.RhG != null) {
                    break label744;
                  }
                  Log.w(localaq.TAG, "parser is null, thread is error.");
                }
                catch (Exception paramAnonymousra)
                {
                  Log.e(localaq.TAG, "deal moov ready error: " + paramAnonymousra.toString());
                }
              }
              break;
              l1 = localaq.lxf;
            }
            if (localaq.RhG.O(localaq.oYr, l2))
            {
              localaq.oYv = localaq.RhG.pEg;
              Log.i(localaq.TAG, "mp4 parse moov success. duration %d cdnMediaId %s isFastStart %b", new Object[] { Integer.valueOf(localaq.oYv), localaq.oYq, Boolean.valueOf(bool) });
              if (!bool) {
                MMHandlerThread.postToMainThread(new aq.1(localaq));
              }
              if (localaq.oYw == -1) {}
              for (localaq.oYt = 1;; localaq.oYt = 2)
              {
                com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(354L, 204L, 1L, false);
                break;
              }
            }
            Log.w(localaq.TAG, "mp4 parse moov error. cdnMediaId %s", new Object[] { localaq.oYq });
            v.bOi();
            com.tencent.mm.modelcdntran.j.v(localaq.oYq, 0, -1);
            com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(354L, 205L, 1L, false);
            com.tencent.mm.plugin.report.service.h.OAn.b(13836, new Object[] { Integer.valueOf(402), Long.valueOf(Util.nowSecond()), "" });
            continue;
            aq localaq = OnlineVideoView.this.RgK;
            Object localObject = paramAnonymousra.hTZ.mediaId;
            int i = paramAnonymousra.hTZ.offset;
            int j = paramAnonymousra.hTZ.length;
            localaq.oYC = false;
            if ((i < 0) || (j < 0)) {
              Log.w(localaq.TAG, "deal data available error offset[%d], length[%d]", new Object[] { Integer.valueOf(i), Integer.valueOf(j) });
            }
            while (!localaq.bay((String)localObject))
            {
              if (paramAnonymousra.hTZ.length <= 0) {
                break;
              }
              OnlineVideoView.this.ho(true);
              break;
            }
            localObject = localaq.oYq + i + "_" + j;
            localObject = (Integer)localaq.RhF.get(localObject);
            if ((localObject != null) && (((Integer)localObject).intValue() > 0)) {
              localaq.oYz = ((Integer)localObject).intValue();
            }
            for (;;)
            {
              Log.i(localaq.TAG, "deal data available. offset[%d] length[%d] cachePlayTime[%d]", new Object[] { Integer.valueOf(i), Integer.valueOf(j), Integer.valueOf(localaq.oYz) });
              break;
              try
              {
                localaq.oYz = localaq.RhG.eX(i, j);
              }
              catch (Exception localException)
              {
                Log.e(localaq.TAG, "deal data available file pos to video time error: " + localException.toString());
              }
            }
            OnlineVideoView.this.ho(true);
            continue;
            Log.i(OnlineVideoView.c(OnlineVideoView.this), "%d download finish. cdnMediaId %s sendReqCode %d favFromScene %d", new Object[] { Integer.valueOf(OnlineVideoView.this.hashCode()), paramAnonymousra.hTZ.mediaId, Integer.valueOf(OnlineVideoView.j(OnlineVideoView.this)), Integer.valueOf(OnlineVideoView.k(OnlineVideoView.this)) });
            paramAnonymousra = OnlineVideoView.this.RgK;
            Log.i(paramAnonymousra.TAG, "deal stream finish. playStatus %d cdnMediaId %s", new Object[] { Integer.valueOf(paramAnonymousra.oYt), paramAnonymousra.oYq });
            paramAnonymousra.oYC = false;
            paramAnonymousra.oYs = 3;
            com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(354L, 206L, 1L, false);
            if (paramAnonymousra.oYt == 0)
            {
              Log.w(paramAnonymousra.TAG, "it had not moov callback and download finish start to play video.");
              paramAnonymousra.hmV();
            }
            for (;;)
            {
              if (OnlineVideoView.j(OnlineVideoView.this) <= 0) {
                break label1478;
              }
              OnlineVideoView.f(OnlineVideoView.this);
              OnlineVideoView.a(OnlineVideoView.this, OnlineVideoView.j(OnlineVideoView.this));
              break;
              if (paramAnonymousra.oYt == 5)
              {
                Log.w(paramAnonymousra.TAG, "it had play error, it request all video data finish, start to play." + paramAnonymousra.oYq);
                paramAnonymousra.hmV();
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
              OnlineVideoView.this.ho(true);
              continue;
              if (OnlineVideoView.E(OnlineVideoView.this) == 1)
              {
                localaq = OnlineVideoView.this.RgK;
                String str = paramAnonymousra.hTZ.mediaId;
                i = paramAnonymousra.hTZ.offset;
                j = paramAnonymousra.hTZ.length;
                if (localaq.bay(str))
                {
                  localaq.progress = i;
                  localaq.total = j;
                  localaq.RhI = (localaq.progress * 100 / localaq.total);
                  Log.i(localaq.TAG, "deal video[%s] progress callback[%d, %d]. downloadedPercent[%d]", new Object[] { localaq.oYq, Integer.valueOf(localaq.progress), Integer.valueOf(localaq.total), Integer.valueOf(localaq.RhI) });
                }
                if (localaq.RhI >= 100) {
                  localaq.oYs = 3;
                }
              }
              else if (OnlineVideoView.E(OnlineVideoView.this) == 2)
              {
                OnlineVideoView.a(OnlineVideoView.this, paramAnonymousra.hTZ.offset, paramAnonymousra.hTZ.length);
                continue;
                paramAnonymousra = OnlineVideoView.this.RgK;
                Log.i(paramAnonymousra.TAG, "deal had dup video. cdnMediaId %s", new Object[] { paramAnonymousra.oYq });
                paramAnonymousra.hmV();
              }
            }
          }
        }
        Log.w(OnlineVideoView.c(OnlineVideoView.this), "%d unknown event opcode %d", new Object[] { Integer.valueOf(OnlineVideoView.this.hashCode()), Integer.valueOf(paramAnonymousra.hTZ.hId) });
        for (;;)
        {
          AppMethodBeat.o(308454);
          return false;
          localaq = OnlineVideoView.this.RgK;
          l2 = paramAnonymousra.hTZ.offset;
          l1 = paramAnonymousra.hTZ.hUa;
          bool = paramAnonymousra.hTZ.hUb;
          Log.i(localaq.TAG, "deal moov ready moovPos %d, timeDuration %d, cdnMediaId %s startDownload[%d %d]", new Object[] { Long.valueOf(l2), Integer.valueOf(localaq.oYv), localaq.oYq, Long.valueOf(l1), Long.valueOf(localaq.lxf) });
          if (localaq.oYv == 0) {
            break;
          }
          Log.w(localaq.TAG, "moov had callback, do nothing.");
          OnlineVideoView.J(OnlineVideoView.this);
        }
      }
    };
    this.RgB = new com.tencent.mm.pluginsdk.ui.tools.i.e()
    {
      public final void onTextureUpdate()
      {
        AppMethodBeat.i(307767);
        Log.i(OnlineVideoView.c(OnlineVideoView.this), "%d on texture update.", new Object[] { Integer.valueOf(OnlineVideoView.this.hashCode()) });
        try
        {
          if ((OnlineVideoView.this.wCd instanceof ThumbPlayerVideoView))
          {
            OnlineVideoView.K(OnlineVideoView.this);
            AppMethodBeat.o(307767);
            return;
          }
          OnlineVideoView.G(OnlineVideoView.this);
          AppMethodBeat.o(307767);
          return;
        }
        catch (Exception localException)
        {
          Log.e(OnlineVideoView.c(OnlineVideoView.this), "texture view update. error " + localException.toString());
          AppMethodBeat.o(307767);
        }
      }
    };
    this.KSQ = new com.tencent.mm.plugin.u.b()
    {
      public final long gbz()
      {
        AppMethodBeat.i(307784);
        Log.i(OnlineVideoView.c(OnlineVideoView.this), "%d sns video get online cache", new Object[] { Integer.valueOf(OnlineVideoView.this.hashCode()) });
        com.tencent.mm.kernel.h.baF();
        com.tencent.mm.kernel.h.baE().ban().set(at.a.acPO, Boolean.TRUE);
        try
        {
          if ((OnlineVideoView.L(OnlineVideoView.this)) && (OnlineVideoView.this.RgK != null))
          {
            int i = OnlineVideoView.this.RgK.oYz;
            long l = i;
            AppMethodBeat.o(307784);
            return l;
          }
        }
        catch (Exception localException)
        {
          AppMethodBeat.o(307784);
        }
        return 0L;
      }
    };
    this.Rhl = true;
    this.Rhm = false;
    this.Rho = 0;
    this.Rhp = 0;
    this.pvk = 0;
    L(paramContext, false);
    AppMethodBeat.o(98060);
  }
  
  private static boolean DZ(boolean paramBoolean)
  {
    AppMethodBeat.i(307866);
    com.tencent.mm.plugin.expt.b.c localc = (com.tencent.mm.plugin.expt.b.c)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.expt.b.c.class);
    if (paramBoolean)
    {
      if (com.tencent.mm.plugin.sns.ad.d.PKX == 1)
      {
        AppMethodBeat.o(307866);
        return false;
      }
      if (com.tencent.mm.plugin.sns.ad.d.PKX == 2)
      {
        AppMethodBeat.o(307866);
        return true;
      }
      paramBoolean = localc.a(c.a.zvw, false);
      AppMethodBeat.o(307866);
      return paramBoolean;
    }
    paramBoolean = localc.a(c.a.zvv, false);
    AppMethodBeat.o(307866);
    return paramBoolean;
  }
  
  private void L(Context paramContext, boolean paramBoolean)
  {
    AppMethodBeat.i(307858);
    this.mContext = paramContext;
    Log.i(this.TAG, "%d ui init view, isAd=%s", new Object[] { Integer.valueOf(hashCode()), Boolean.toString(paramBoolean) });
    LayoutInflater.from(paramContext).inflate(b.g.sns_video_view, this);
    this.AlJ = ((ImageView)findViewById(b.f.video_thumb));
    this.Amd = ((RelativeLayout)findViewById(b.f.video_root));
    this.nhp = ((TextView)findViewById(b.f.video_duration));
    this.nhp.setVisibility(8);
    this.Aqf = ((MMPinProgressBtn)findViewById(b.f.video_progress));
    this.sIX = ((ProgressBar)findViewById(b.f.video_loading));
    this.ApV = ((TextView)findViewById(b.f.video_tips));
    hmx();
    if (DZ(paramBoolean))
    {
      this.wCd = new ThumbPlayerVideoView(paramContext);
      ((ThumbPlayerVideoView)this.wCd).setLoopStartCallback(new ThumbPlayerVideoView.c()
      {
        public final void hmP()
        {
          AppMethodBeat.i(308127);
          Log.i(OnlineVideoView.c(OnlineVideoView.this), "onLoopStart");
          if (OnlineVideoView.d(OnlineVideoView.this) != null)
          {
            OnlineVideoView.d(OnlineVideoView.this).reset();
            OnlineVideoView.d(OnlineVideoView.this).setEnableDrag(true);
          }
          AppMethodBeat.o(308127);
        }
      });
      this.wCd.setOnInfoCallback(new i.b()
      {
        public final void onInfo(int paramAnonymousInt1, int paramAnonymousInt2)
        {
          AppMethodBeat.i(307763);
          if (paramAnonymousInt1 == 701)
          {
            OnlineVideoView.this.cFq = true;
            OnlineVideoView.e(OnlineVideoView.this);
            AppMethodBeat.o(307763);
            return;
          }
          if (paramAnonymousInt1 == 702)
          {
            OnlineVideoView.this.cFq = false;
            OnlineVideoView.f(OnlineVideoView.this);
          }
          AppMethodBeat.o(307763);
        }
      });
      this.Aqb = false;
      Log.i(this.TAG, "initView, use ThumbPlayerVideoView");
    }
    for (;;)
    {
      this.wCd.setVideoCallback(this);
      RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-1, -2);
      localLayoutParams.addRule(13);
      int i = View.generateViewId();
      ((View)this.wCd).setId(i);
      this.Amd.addView((View)this.wCd, localLayoutParams);
      this.RgJ = new ImageView(paramContext);
      paramContext = new RelativeLayout.LayoutParams(-1, -2);
      paramContext.addRule(6, i);
      paramContext.addRule(8, i);
      this.Amd.addView(this.RgJ, paramContext);
      this.RgJ.setVisibility(8);
      e(false, 0.0F);
      AppMethodBeat.o(307858);
      return;
      e.bIg();
      if (e.bIv())
      {
        this.Aqb = true;
        this.wCd = new VideoPlayerTextureView(paramContext);
        ((VideoPlayerTextureView)this.wCd).setIOnlineCache(this.KSQ);
        ((VideoPlayerTextureView)this.wCd).setOpenWithNoneSurface(true);
        com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(354L, 148L, 1L, false);
        Log.i(this.TAG, "initView, use VideoPlayerTextureView");
      }
      else
      {
        this.Aqb = false;
        this.wCd = new VideoTextureView(paramContext);
        com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(354L, 149L, 1L, false);
        Log.i(this.TAG, "initView, use VideoTextureView");
      }
    }
  }
  
  private void al(boolean paramBoolean, int paramInt)
  {
    boolean bool = false;
    AppMethodBeat.i(98076);
    if (this.ibT == null)
    {
      Log.w(this.TAG, "%d start download video but media is null.", new Object[] { Integer.valueOf(hashCode()) });
      AppMethodBeat.o(98076);
      return;
    }
    if ((this.RgK == null) && (this.RgU == null))
    {
      Log.w(this.TAG, "%d start download video but helper is null.", new Object[] { Integer.valueOf(hashCode()) });
      AppMethodBeat.o(98076);
      return;
    }
    if (this.ibT.aazR == 2)
    {
      Log.w(this.TAG, "%d it start download video, url type is weixin", new Object[] { Integer.valueOf(hashCode()) });
      this.RgE = 3;
      al.hgw().a(this.ibT, 4, null, this.Qob);
      AppMethodBeat.o(98076);
      return;
    }
    int i;
    if (!paramBoolean)
    {
      e.bIg();
      if (e.bIu())
      {
        Log.i(this.TAG, "%d it start online download video", new Object[] { Integer.valueOf(hashCode()) });
        this.RgE = 1;
        i = paramInt;
        if (paramInt == 0) {
          i = 30;
        }
        paramBoolean = true;
        if ((this.RgU == null) || (this.RgW == null)) {
          break label355;
        }
        if (this.RgV != null)
        {
          this.RgV.lxk = i;
          this.RgV.HlA = paramBoolean;
        }
        this.RgU.start();
        if (this.RgE != 1) {
          break label330;
        }
        this.RgW.hsx();
      }
    }
    for (;;)
    {
      showLoading();
      AppMethodBeat.o(98076);
      return;
      Log.i(this.TAG, "%d it start offline download video", new Object[] { Integer.valueOf(hashCode()) });
      this.RgE = 2;
      if (paramInt != 0) {}
      for (;;)
      {
        paramBoolean = bool;
        i = paramInt;
        break;
        paramInt = 31;
      }
      label330:
      if (this.RgE == 2)
      {
        this.RgW.hsy();
        this.RgW.hsz();
      }
    }
    label355:
    if (this.RgK != null)
    {
      this.RgK.a(this.ibT, this.createTime, this.hHB, paramBoolean, i);
      AppMethodBeat.o(98076);
      return;
    }
    Log.w(this.TAG, "onlineVideoHelper is null!!!");
    AppMethodBeat.o(98076);
  }
  
  private void alK(int paramInt)
  {
    AppMethodBeat.i(98071);
    if (this.ibT == null)
    {
      AppMethodBeat.o(98071);
      return;
    }
    String str = as.mg(al.getAccSnsPath(), this.ibT.Id) + t.d(this.ibT);
    Intent localIntent = new Intent();
    localIntent.putExtra("Select_Conv_Type", 3);
    localIntent.putExtra("select_is_ret", true);
    localIntent.putExtra("mutil_select_is_ret", true);
    localIntent.putExtra("image_path", str);
    localIntent.putExtra("Retr_Msg_Type", 11);
    Log.i(this.TAG, "send video path %s reqCode %d", new Object[] { str, Integer.valueOf(paramInt) });
    com.tencent.mm.br.c.d(getActivityContext(), ".ui.transmit.SelectConversationUI", localIntent, paramInt);
    this.icE = 0;
    AppMethodBeat.o(98071);
  }
  
  private void bL(final int paramInt, final boolean paramBoolean)
  {
    AppMethodBeat.i(98072);
    this.wAW.post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(308497);
        Object localObject1 = al.hgB().aZL(OnlineVideoView.r(OnlineVideoView.this));
        if (localObject1 == null)
        {
          AppMethodBeat.o(308497);
          return;
        }
        Log.i(OnlineVideoView.c(OnlineVideoView.this), "fav download video[%s] farFromScene %d isFromMain %b", new Object[] { OnlineVideoView.s(OnlineVideoView.this), Integer.valueOf(paramInt), Boolean.valueOf(paramBoolean) });
        Object localObject2 = new dn();
        ((dn)localObject2).hDr.hDy = paramInt;
        ((dn)localObject2).hDr.activity = ((Activity)OnlineVideoView.this.getActivityContext());
        com.tencent.mm.plugin.sns.n.a.a((dn)localObject2, (SnsInfo)localObject1);
        ((dn)localObject2).publish();
        if (((dn)localObject2).hDs.ret == 0) {
          OnlineVideoView.hmL();
        }
        for (;;)
        {
          if (paramBoolean)
          {
            localObject2 = new yh();
            ((yh)localObject2).ibI.hES = ((SnsInfo)localObject1).getLocalid();
            ((yh)localObject2).ibI.hQX = t.x((SnsInfo)localObject1);
            ((yh)localObject2).publish();
          }
          OnlineVideoView.t(OnlineVideoView.this);
          if (OnlineVideoView.this.wCd == null) {
            break label322;
          }
          if (!Util.isNullOrNil(OnlineVideoView.this.wCd.getVideoPath())) {
            break;
          }
          Log.i(OnlineVideoView.c(OnlineVideoView.this), "%d had not set video path to play", new Object[] { Integer.valueOf(OnlineVideoView.this.hashCode()) });
          localObject1 = az.a(OnlineVideoView.s(OnlineVideoView.this), OnlineVideoView.u(OnlineVideoView.this));
          if (!Util.isNullOrNil((String)localObject1)) {
            OnlineVideoView.this.di((String)localObject1, false);
          }
          AppMethodBeat.o(308497);
          return;
          OnlineVideoView.hmM();
        }
        if (!OnlineVideoView.this.wCd.isPlaying())
        {
          OnlineVideoView.this.wCd.start();
          AppMethodBeat.o(308497);
          return;
        }
        label322:
        AppMethodBeat.o(308497);
      }
    });
    AppMethodBeat.o(98072);
  }
  
  private void d(final boolean paramBoolean, final float paramFloat)
  {
    AppMethodBeat.i(98074);
    this.wAW.post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(308118);
        Log.i(OnlineVideoView.c(OnlineVideoView.this), "%d switch video model isVideoPlay %b %f", new Object[] { Integer.valueOf(OnlineVideoView.this.hashCode()), Boolean.valueOf(paramBoolean), Float.valueOf(paramFloat) });
        View localView = (View)OnlineVideoView.this.wCd;
        if (paramBoolean)
        {
          OnlineVideoView.A(OnlineVideoView.this).setAlpha(paramFloat);
          OnlineVideoView.A(OnlineVideoView.this).setVisibility(0);
          localView.setAlpha(paramFloat);
          localView.setVisibility(0);
          if ((paramFloat >= 1.0D) && (!OnlineVideoView.B(OnlineVideoView.this)))
          {
            OnlineVideoView.C(OnlineVideoView.this).setVisibility(8);
            AppMethodBeat.o(308118);
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
        AppMethodBeat.o(308118);
      }
    });
    AppMethodBeat.o(98074);
  }
  
  private void dSY()
  {
    AppMethodBeat.i(98075);
    Object localObject1;
    if (!this.isPreview)
    {
      localObject1 = az.a(this.hHB, this.ibT);
      Log.i(this.TAG, "%d toggleVideo local id %s finish path %s isPreview %b", new Object[] { Integer.valueOf(hashCode()), this.hHB, localObject1, Boolean.valueOf(this.isPreview) });
      if (Util.isNullOrNil((String)localObject1)) {
        break label180;
      }
      Log.i(this.TAG, "%d sns video already download finish, play now", new Object[] { Integer.valueOf(hashCode()) });
      if (!(this.wCd instanceof ThumbPlayerVideoView)) {
        break label171;
      }
      Object localObject2 = localObject1;
      if (!y.ZC((String)localObject1))
      {
        localObject2 = getRelocatedVideoPath();
        Log.w(this.TAG, "get relocated video path: ".concat(String.valueOf(localObject2)));
      }
      e(true, 0.0F);
      localObject1 = localObject2;
    }
    for (;;)
    {
      di((String)localObject1, false);
      AppMethodBeat.o(98075);
      return;
      localObject1 = this.RgF;
      break;
      label171:
      d(true, 0.0F);
    }
    label180:
    if ((this.wCd instanceof ThumbPlayerVideoView)) {
      e(false, 0.0F);
    }
    for (;;)
    {
      al(false, 0);
      showLoading();
      AppMethodBeat.o(98075);
      return;
      d(false, 0.0F);
    }
  }
  
  private boolean dTa()
  {
    AppMethodBeat.i(98086);
    if (!this.RgL)
    {
      AppMethodBeat.o(98086);
      return false;
    }
    com.tencent.mm.kernel.h.baF();
    boolean bool = com.tencent.mm.kernel.h.baE().ban().getBoolean(at.a.acPO, false);
    AppMethodBeat.o(98086);
    return bool;
  }
  
  private void e(boolean paramBoolean, float paramFloat)
  {
    AppMethodBeat.i(307900);
    Log.i(this.TAG, "%d switch sync video model isVideoPlay %b %f", new Object[] { Integer.valueOf(hashCode()), Boolean.valueOf(paramBoolean), Float.valueOf(paramFloat) });
    View localView = (View)this.wCd;
    if (paramBoolean)
    {
      this.Amd.setAlpha(paramFloat);
      this.Amd.setVisibility(0);
      localView.setAlpha(paramFloat);
      localView.setVisibility(0);
      if ((paramFloat >= 1.0D) && (!this.Rhm))
      {
        this.AlJ.setVisibility(8);
        AppMethodBeat.o(307900);
      }
    }
    else
    {
      this.Amd.setVisibility(8);
      localView.setVisibility(8);
      if (this.Rhl) {
        this.AlJ.setVisibility(0);
      }
    }
    AppMethodBeat.o(307900);
  }
  
  private String getRelocatedVideoPath()
  {
    AppMethodBeat.i(307925);
    Object localObject = al.hgB().aZL(this.RgG);
    if (localObject == null)
    {
      AppMethodBeat.o(307925);
      return null;
    }
    localObject = ((SnsInfo)localObject).getTimeLine();
    if ((localObject == null) || (((TimeLineObject)localObject).ContentObj == null) || (((TimeLineObject)localObject).ContentObj.Zpr == null) || (((TimeLineObject)localObject).ContentObj.Zpr.isEmpty()))
    {
      Log.w(this.TAG, "getRelocatedVideoPath but no valid media found");
      AppMethodBeat.o(307925);
      return null;
    }
    localObject = (dmz)((TimeLineObject)localObject).ContentObj.Zpr.get(0);
    localObject = az.a(this.hHB, (dmz)localObject);
    AppMethodBeat.o(307925);
    return localObject;
  }
  
  private void hideLoading()
  {
    AppMethodBeat.i(98080);
    Log.i(this.TAG, "hideLoading()");
    this.RgJ.setImageBitmap(null);
    this.RgJ.setVisibility(8);
    this.wAW.removeCallbacks(this.Rhd);
    this.wAW.post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(308233);
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
        AppMethodBeat.o(308233);
      }
    });
    AppMethodBeat.o(98080);
  }
  
  private void hmC()
  {
    AppMethodBeat.i(307880);
    int j = b.e.black;
    int i = j;
    if (this.ibT != null)
    {
      i = j;
      if (this.ibT.isAd)
      {
        Log.i(this.TAG, "the media is ad, the background should be transparent");
        i = b.e.sns_ad_online_video_default_bg;
      }
    }
    boolean bool = al.hgy().b(this.ibT, this.AlJ, i, this.mContext.hashCode(), this.Qob);
    Log.i(this.TAG, "%d fresh thumb image %b", new Object[] { Integer.valueOf(hashCode()), Boolean.valueOf(bool) });
    AppMethodBeat.o(307880);
  }
  
  private void hmE()
  {
    AppMethodBeat.i(98073);
    ExportFileUtil.a(getContext(), new androidx.core.f.a() {});
    AppMethodBeat.o(98073);
  }
  
  private void hmH()
  {
    AppMethodBeat.i(98092);
    this.Rhh = Util.nowMilliSecond();
    Log.d(this.TAG, "%d notePlayVideo notePlayVideo %d ", new Object[] { Integer.valueOf(hashCode()), Long.valueOf(this.Rhh) });
    AppMethodBeat.o(98092);
  }
  
  private void hmI()
  {
    AppMethodBeat.i(98093);
    if (this.Rhh > 0L) {
      this.Rhi = ((int)(this.Rhi + (Util.nowMilliSecond() - this.Rhh) / 1000L));
    }
    Log.i(this.TAG, "%d notePauseVideo playVideoDuration %d ", new Object[] { Integer.valueOf(hashCode()), Integer.valueOf(this.Rhi) });
    this.Rhh = 0L;
    AppMethodBeat.o(98093);
  }
  
  private void hmJ()
  {
    AppMethodBeat.i(98095);
    this.Rhj = Util.nowMilliSecond();
    Log.d(this.TAG, "%d noteResumeVideo noteResumeVideo %d ", new Object[] { Integer.valueOf(hashCode()), Long.valueOf(this.Rhj) });
    AppMethodBeat.o(98095);
  }
  
  private void hmK()
  {
    AppMethodBeat.i(98096);
    if (this.Rhj > 0L)
    {
      this.Rhk = 0;
      this.Rhk = ((int)(this.Rhk + (Util.nowMilliSecond() - this.Rhj) / 1000L));
    }
    Log.i(this.TAG, "%d notePauseVideoByResume playVideoDuration %d ", new Object[] { Integer.valueOf(hashCode()), Integer.valueOf(this.Rhk) });
    this.Rhj = 0L;
    AppMethodBeat.o(98096);
  }
  
  private void hmx()
  {
    AppMethodBeat.i(307860);
    this.RgY = ((ImageView)findViewById(b.f.hero_seekbar_bg));
    this.RgX = ((HeroSeekBarView)findViewById(b.f.sns_video_seek_bar));
    this.RgX.setHeroSeekBarChangeListener(new HeroSeekBarView.b()
    {
      public final void alM(int paramAnonymousInt)
      {
        AppMethodBeat.i(307754);
        OnlineVideoView.this.alL((int)(OnlineVideoView.d(OnlineVideoView.this).awU(paramAnonymousInt) / 1000L));
        OnlineVideoView.i(OnlineVideoView.this);
        OnlineVideoView.a locala = OnlineVideoView.h(OnlineVideoView.this);
        OnlineVideoView.g(locala.Rhq).removeCallbacks(locala);
        AppMethodBeat.o(307754);
      }
      
      public final void bN(int paramAnonymousInt, boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(307746);
        if (paramAnonymousBoolean)
        {
          paramAnonymousInt = (int)(OnlineVideoView.d(OnlineVideoView.this).awU(paramAnonymousInt) / 1000L);
          OnlineVideoView.a locala = OnlineVideoView.h(OnlineVideoView.this);
          locala.RhD = paramAnonymousInt;
          if (SystemClock.uptimeMillis() - locala.RhE > 100L)
          {
            locala.run();
            AppMethodBeat.o(307746);
            return;
          }
          OnlineVideoView.g(locala.Rhq).removeCallbacks(locala);
          OnlineVideoView.g(locala.Rhq).postDelayed(locala, 100L);
        }
        AppMethodBeat.o(307746);
      }
      
      public final void hmQ()
      {
        AppMethodBeat.i(307751);
        OnlineVideoView.this.bck();
        AppMethodBeat.o(307751);
      }
    });
    AppMethodBeat.o(307860);
  }
  
  private void showLoading()
  {
    AppMethodBeat.i(98079);
    Log.i(this.TAG, "showLoading()");
    this.wAW.post(this.Rhd);
    AppMethodBeat.o(98079);
  }
  
  /* Error */
  private void unInit()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: ldc_w 1106
    //   5: invokestatic 203	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   8: aload_0
    //   9: getfield 859	com/tencent/mm/plugin/sns/ui/OnlineVideoView:RgX	Lcom/tencent/mm/pluginsdk/ui/seekbar/HeroSeekBarView;
    //   12: astore_1
    //   13: aload_1
    //   14: iconst_0
    //   15: putfield 1109	com/tencent/mm/pluginsdk/ui/seekbar/HeroSeekBarView:YnQ	Z
    //   18: aload_1
    //   19: getfield 1113	com/tencent/mm/pluginsdk/ui/seekbar/HeroSeekBarView:GQB	Lcom/tencent/threadpool/i/d;
    //   22: astore_1
    //   23: aload_1
    //   24: ifnull +11 -> 35
    //   27: aload_1
    //   28: iconst_1
    //   29: invokeinterface 1118 2 0
    //   34: pop
    //   35: aload_0
    //   36: getfield 1120	com/tencent/mm/plugin/sns/ui/OnlineVideoView:dBj	Ljava/util/concurrent/Future;
    //   39: ifnull +19 -> 58
    //   42: aload_0
    //   43: getfield 1120	com/tencent/mm/plugin/sns/ui/OnlineVideoView:dBj	Ljava/util/concurrent/Future;
    //   46: iconst_1
    //   47: invokeinterface 1123 2 0
    //   52: pop
    //   53: aload_0
    //   54: aconst_null
    //   55: putfield 1120	com/tencent/mm/plugin/sns/ui/OnlineVideoView:dBj	Ljava/util/concurrent/Future;
    //   58: aload_0
    //   59: aconst_null
    //   60: putfield 427	com/tencent/mm/plugin/sns/ui/OnlineVideoView:hHB	Ljava/lang/String;
    //   63: aload_0
    //   64: getfield 301	com/tencent/mm/plugin/sns/ui/OnlineVideoView:isInit	Z
    //   67: ifne +12 -> 79
    //   70: ldc_w 1106
    //   73: invokestatic 364	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   76: aload_0
    //   77: monitorexit
    //   78: return
    //   79: aload_0
    //   80: iconst_0
    //   81: putfield 301	com/tencent/mm/plugin/sns/ui/OnlineVideoView:isInit	Z
    //   84: aload_0
    //   85: getfield 229	com/tencent/mm/plugin/sns/ui/OnlineVideoView:TAG	Ljava/lang/String;
    //   88: ldc_w 1125
    //   91: iconst_1
    //   92: anewarray 212	java/lang/Object
    //   95: dup
    //   96: iconst_0
    //   97: aload_0
    //   98: invokevirtual 216	java/lang/Object:hashCode	()I
    //   101: invokestatic 440	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   104: aastore
    //   105: invokestatic 445	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   108: aload_0
    //   109: invokespecial 647	com/tencent/mm/plugin/sns/ui/OnlineVideoView:hmI	()V
    //   112: aload_0
    //   113: invokespecial 1127	com/tencent/mm/plugin/sns/ui/OnlineVideoView:hmK	()V
    //   116: aload_0
    //   117: getfield 561	com/tencent/mm/plugin/sns/ui/OnlineVideoView:wCd	Lcom/tencent/mm/pluginsdk/ui/tools/i;
    //   120: invokeinterface 1130 1 0
    //   125: aload_0
    //   126: getfield 561	com/tencent/mm/plugin/sns/ui/OnlineVideoView:wCd	Lcom/tencent/mm/pluginsdk/ui/tools/i;
    //   129: instanceof 558
    //   132: ifne +10 -> 142
    //   135: aload_0
    //   136: getfield 341	com/tencent/mm/plugin/sns/ui/OnlineVideoView:QyK	Lcom/tencent/mm/sdk/event/IListener;
    //   139: invokevirtual 1135	com/tencent/mm/sdk/event/IListener:dead	()V
    //   142: aload_0
    //   143: getfield 335	com/tencent/mm/plugin/sns/ui/OnlineVideoView:Rhf	Lcom/tencent/mm/sdk/event/IListener;
    //   146: invokevirtual 1135	com/tencent/mm/sdk/event/IListener:dead	()V
    //   149: invokestatic 698	com/tencent/mm/plugin/sns/model/al:hgw	()Lcom/tencent/mm/plugin/sns/model/c;
    //   152: aload_0
    //   153: getfield 324	com/tencent/mm/plugin/sns/ui/OnlineVideoView:Rhe	Lcom/tencent/mm/plugin/sns/model/c$b;
    //   156: invokevirtual 1138	com/tencent/mm/plugin/sns/model/c:b	(Lcom/tencent/mm/plugin/sns/model/c$b;)V
    //   159: aload_0
    //   160: invokevirtual 1141	com/tencent/mm/plugin/sns/ui/OnlineVideoView:hmt	()V
    //   163: aload_0
    //   164: getfield 274	com/tencent/mm/plugin/sns/ui/OnlineVideoView:wAW	Lcom/tencent/mm/sdk/platformtools/MMHandler;
    //   167: aconst_null
    //   168: invokevirtual 1145	com/tencent/mm/sdk/platformtools/MMHandler:removeCallbacksAndMessages	(Ljava/lang/Object;)V
    //   171: aload_0
    //   172: getfield 243	com/tencent/mm/plugin/sns/ui/OnlineVideoView:RgK	Lcom/tencent/mm/plugin/sns/ui/aq;
    //   175: ifnull +18 -> 193
    //   178: aload_0
    //   179: getfield 243	com/tencent/mm/plugin/sns/ui/OnlineVideoView:RgK	Lcom/tencent/mm/plugin/sns/ui/aq;
    //   182: invokevirtual 1148	com/tencent/mm/plugin/sns/ui/aq:hmT	()Z
    //   185: pop
    //   186: aload_0
    //   187: getfield 243	com/tencent/mm/plugin/sns/ui/OnlineVideoView:RgK	Lcom/tencent/mm/plugin/sns/ui/aq;
    //   190: invokevirtual 1151	com/tencent/mm/plugin/sns/ui/aq:clear	()V
    //   193: aload_0
    //   194: getfield 683	com/tencent/mm/plugin/sns/ui/OnlineVideoView:RgU	Lcom/tencent/mm/plugin/thumbplayer/downloader/i;
    //   197: ifnull +17 -> 214
    //   200: aload_0
    //   201: getfield 683	com/tencent/mm/plugin/sns/ui/OnlineVideoView:RgU	Lcom/tencent/mm/plugin/thumbplayer/downloader/i;
    //   204: invokeinterface 1152 1 0
    //   209: aload_0
    //   210: aconst_null
    //   211: putfield 683	com/tencent/mm/plugin/sns/ui/OnlineVideoView:RgU	Lcom/tencent/mm/plugin/thumbplayer/downloader/i;
    //   214: aload_0
    //   215: getfield 712	com/tencent/mm/plugin/sns/ui/OnlineVideoView:RgW	Lcom/tencent/mm/plugin/sns/ui/video/f;
    //   218: ifnull +25 -> 243
    //   221: aload_0
    //   222: getfield 712	com/tencent/mm/plugin/sns/ui/OnlineVideoView:RgW	Lcom/tencent/mm/plugin/sns/ui/video/f;
    //   225: astore_1
    //   226: ldc_w 1154
    //   229: ldc_w 1156
    //   232: invokestatic 580	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   235: aload_1
    //   236: getfield 1160	com/tencent/mm/plugin/sns/ui/video/f:scope	Lkotlinx/coroutines/aq;
    //   239: aconst_null
    //   240: invokestatic 1165	kotlinx/coroutines/ar:a	(Lkotlinx/coroutines/aq;Ljava/util/concurrent/CancellationException;)V
    //   243: invokestatic 1171	com/tencent/mm/n/a:aDI	()Lcom/tencent/mm/model/ap;
    //   246: ifnull +11 -> 257
    //   249: invokestatic 1171	com/tencent/mm/n/a:aDI	()Lcom/tencent/mm/model/ap;
    //   252: invokeinterface 1176 1 0
    //   257: aload_0
    //   258: getfield 259	com/tencent/mm/plugin/sns/ui/OnlineVideoView:vZw	Lcom/tencent/mm/model/d;
    //   261: ifnull +12 -> 273
    //   264: aload_0
    //   265: getfield 259	com/tencent/mm/plugin/sns/ui/OnlineVideoView:vZw	Lcom/tencent/mm/model/d;
    //   268: iconst_0
    //   269: invokevirtual 1181	com/tencent/mm/model/d:gR	(Z)Z
    //   272: pop
    //   273: aload_0
    //   274: aconst_null
    //   275: putfield 259	com/tencent/mm/plugin/sns/ui/OnlineVideoView:vZw	Lcom/tencent/mm/model/d;
    //   278: aload_0
    //   279: aconst_null
    //   280: putfield 239	com/tencent/mm/plugin/sns/ui/OnlineVideoView:ibT	Lcom/tencent/mm/protocal/protobuf/dmz;
    //   283: aload_0
    //   284: aconst_null
    //   285: putfield 243	com/tencent/mm/plugin/sns/ui/OnlineVideoView:RgK	Lcom/tencent/mm/plugin/sns/ui/aq;
    //   288: aload_0
    //   289: iconst_0
    //   290: putfield 251	com/tencent/mm/plugin/sns/ui/OnlineVideoView:RgO	I
    //   293: aload_0
    //   294: iconst_0
    //   295: putfield 294	com/tencent/mm/plugin/sns/ui/OnlineVideoView:cFq	Z
    //   298: ldc_w 1106
    //   301: invokestatic 364	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   304: goto -228 -> 76
    //   307: astore_1
    //   308: aload_0
    //   309: monitorexit
    //   310: aload_1
    //   311: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	312	0	this	OnlineVideoView
    //   12	224	1	localObject1	Object
    //   307	4	1	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   2	23	307	finally
    //   27	35	307	finally
    //   35	58	307	finally
    //   58	76	307	finally
    //   79	142	307	finally
    //   142	193	307	finally
    //   193	214	307	finally
    //   214	243	307	finally
    //   243	257	307	finally
    //   257	273	307	finally
    //   273	304	307	finally
  }
  
  public final void Qz()
  {
    AppMethodBeat.i(98084);
    Log.i(this.TAG, "%d onPrepared playErrorCode[%d] onErrorPlayTimeSec[%d] allowStart[%s]", new Object[] { Integer.valueOf(hashCode()), Integer.valueOf(this.Aqc), Integer.valueOf(this.RgN), Boolean.toString(this.RgT) });
    this.Aqc = 0;
    if ((this.wCd instanceof ThumbPlayerVideoView))
    {
      this.wCd.setOneTimeVideoTextureUpdateCallback(this.RgB);
      e(true, 0.0F);
      if (this.RgW != null) {
        this.RgW.hsA();
      }
    }
    if (this.RgT)
    {
      if (this.RgN <= 0) {
        break label148;
      }
      bJ(this.RgN, true);
      this.RgN = 0;
    }
    for (;;)
    {
      this.cFq = false;
      AppMethodBeat.o(98084);
      return;
      label148:
      this.RgO = 0;
      hideLoading();
      hmH();
      hmJ();
      this.wCd.start();
      this.duration = (this.wCd.getDuration() / 1000);
      this.RgX.setTotalTimeMs(this.wCd.getDuration());
      Log.i(this.TAG, "%d start play duration %d sns local id %s ", new Object[] { Integer.valueOf(hashCode()), Integer.valueOf(this.duration), this.hHB });
      ho(false);
      b localb = this.RgI;
      if (localb != null) {
        localb.onStart(this.duration);
      }
    }
  }
  
  public final void a(dmz paramdmz, String paramString, int paramInt)
  {
    AppMethodBeat.i(98065);
    this.hHB = paramString;
    this.createTime = paramInt;
    paramString = br.jbm();
    paramString.time = this.createTime;
    this.Qob = paramString;
    if (this.ibT != paramdmz)
    {
      this.ibT = paramdmz;
      hmC();
    }
    if (this.ibT != null) {
      this.RgG = com.tencent.mm.plugin.sns.data.m.lX(this.hHB, this.ibT.Id + "_");
    }
    this.isPreview = false;
    Log.i(this.TAG, "%d set video data[%s, %d] isPreview %b self %s", new Object[] { Integer.valueOf(hashCode()), this.hHB, Integer.valueOf(this.createTime), Boolean.valueOf(this.isPreview), this });
    AppMethodBeat.o(98065);
  }
  
  public final void abandonAudioFocus()
  {
    AppMethodBeat.i(98062);
    if (this.vZw != null) {
      this.vZw.gR(false);
    }
    AppMethodBeat.o(98062);
  }
  
  public final void alJ(int paramInt)
  {
    AppMethodBeat.i(308248);
    Log.i(this.TAG, "updateVideoUI: %d", new Object[] { Integer.valueOf(paramInt) });
    b localb = this.RgI;
    if (localb != null) {
      localb.Bh(paramInt);
    }
    AppMethodBeat.o(308248);
  }
  
  public final void alL(int paramInt)
  {
    int i = 1;
    AppMethodBeat.i(308239);
    Log.i(this.TAG, "%d ui touch seek second %d afterSeekPlay %b", new Object[] { Integer.valueOf(hashCode()), Integer.valueOf(paramInt), Boolean.TRUE });
    if (!this.RgL) {
      bJ(paramInt, true);
    }
    for (paramInt = i;; paramInt = i)
    {
      if (paramInt != 0) {
        ho(false);
      }
      AppMethodBeat.o(308239);
      return;
      if (!(this.wCd instanceof ThumbPlayerVideoView)) {
        break;
      }
      ((ThumbPlayerVideoView)this.wCd).c(paramInt * 1000, true);
    }
    aq localaq = this.RgK;
    switch (localaq.oYs)
    {
    }
    label144:
    for (i = 1;; i = 0)
    {
      Log.i(localaq.TAG, "seek video time %d, download status %d playStatus %d", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(localaq.oYs), Integer.valueOf(localaq.oYt) });
      paramInt = i;
      break;
      localaq.oYt = 2;
      PInt localPInt1 = new PInt();
      PInt localPInt2 = new PInt();
      localaq.a(paramInt, localPInt1, localPInt2);
      if (localaq.p(localPInt1.value, localPInt2.value, true))
      {
        localaq.oYw = -1;
        localaq.oYy = false;
        localaq.oYz = localPInt2.value;
        localaq.oYt = 3;
        localaq.alN(paramInt);
        break label144;
      }
      localaq.oYw = paramInt;
      localaq.oYy = true;
      localaq.RhH.bNT();
    }
  }
  
  public final void bAi() {}
  
  public final void bAj() {}
  
  public final void bAk() {}
  
  public final void bAl() {}
  
  public final void bJ(int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(308243);
    Log.i(this.TAG, "%d seek second %d afterSeekPlay %b", new Object[] { Integer.valueOf(hashCode()), Integer.valueOf(paramInt), Boolean.valueOf(paramBoolean) });
    this.RgO = 0;
    hideLoading();
    this.wCd.c(paramInt * 1000, paramBoolean);
    ho(false);
    AppMethodBeat.o(308243);
  }
  
  public final void bM(int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(308315);
    Log.i(this.TAG, "addVideoViewBottomMargin: %d", new Object[] { Integer.valueOf(paramInt) });
    if (paramBoolean)
    {
      this.pvk = paramInt;
      RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)this.RgX.getLayoutParams();
      localLayoutParams.addRule(12);
      localLayoutParams.bottomMargin = (com.tencent.mm.cd.a.br(this.Rhb, b.d.Edge_2A) + paramInt);
      this.RgX.setLayoutParams(localLayoutParams);
      AppMethodBeat.o(308315);
      return;
    }
    this.Rhn += paramInt;
    AppMethodBeat.o(308315);
  }
  
  public final void bNT()
  {
    AppMethodBeat.i(98090);
    Log.i(this.TAG, "%d pauseByDataBlock", new Object[] { Integer.valueOf(hashCode()) });
    hmI();
    showLoading();
    bck();
    if (AppForegroundDelegate.heY.eLx)
    {
      this.RgT = true;
      Log.i(this.TAG, "%d pauseByDataBlock and allowStart", new Object[] { Integer.valueOf(hashCode()) });
    }
    AppMethodBeat.o(98090);
  }
  
  public void bck()
  {
    AppMethodBeat.i(98078);
    this.RgT = false;
    if (this.wCd.isPlaying())
    {
      Log.i(this.TAG, "%d pause play", new Object[] { Integer.valueOf(hashCode()) });
      hmI();
      hmK();
    }
    this.wCd.pause();
    if ((this.RgI instanceof c)) {
      try
      {
        ((c)this.RgI).onPause();
        AppMethodBeat.o(98078);
        return;
      }
      finally
      {
        Log.e(this.TAG, "the pause callback invalid!!");
      }
    }
    AppMethodBeat.o(98078);
  }
  
  public void bcl()
  {
    AppMethodBeat.i(98089);
    Log.i(this.TAG, "resumePlay()");
    this.RgT = true;
    if (!this.wCd.isPlaying())
    {
      hmJ();
      int i = this.wCd.getDuration();
      int j = this.wCd.getCurrentPosition();
      if (j >= i) {
        Log.e(this.TAG, "the current position is more than duration, current = %d, duration = %d !!!", new Object[] { Integer.valueOf(j), Integer.valueOf(i) });
      }
      if ((this.RgU != null) && (!this.RgU.aVB()) && (!this.RgU.isDownloading()))
      {
        Log.w(this.TAG, "the downloader has been stopped by another instance, restart it");
        this.RgU.start();
      }
      this.wCd.start();
    }
    AppMethodBeat.o(98089);
  }
  
  public final void bu(Activity paramActivity)
  {
    this.Rhb = paramActivity;
    this.Rhc = true;
  }
  
  public final void di(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(98087);
    Log.i(this.TAG, "%d prepare video isOnlinePlay %b filePath %s", new Object[] { Integer.valueOf(hashCode()), Boolean.valueOf(paramBoolean), paramString });
    if (Util.isNullOrNil(paramString))
    {
      Log.w(this.TAG, "%d prepare video but filepath is null.", new Object[] { Integer.valueOf(hashCode()) });
      AppMethodBeat.o(98087);
      return;
    }
    this.RgL = paramBoolean;
    String str;
    if (this.wCd != null)
    {
      if (this.RgO == -3) {
        break label361;
      }
      if ((this.wCd instanceof VideoPlayerTextureView))
      {
        ((VideoPlayerTextureView)this.wCd).setNeedResetExtractor(dTa());
        ((VideoPlayerTextureView)this.wCd).setIsOnlineVideoType(paramBoolean);
      }
      this.wCd.setOneTimeVideoTextureUpdateCallback(this.RgB);
      MultiProcessMMKV localMultiProcessMMKV = MultiProcessMMKV.getMMKV("TrackDataSource");
      if (this.ibT != null) {
        break label320;
      }
      str = "";
      localMultiProcessMMKV.putString("media-url", str);
      if (this.ibT != null) {
        break label331;
      }
      str = "";
      label188:
      localMultiProcessMMKV.putString("thumb-url", str);
      localMultiProcessMMKV.putLong("prepare-ts", System.currentTimeMillis());
      localMultiProcessMMKV.putString("prepare-path", paramString);
      localMultiProcessMMKV.commit();
      if (!(this.wCd instanceof ThumbPlayerVideoView)) {
        break label342;
      }
      if (!paramBoolean) {
        this.wCd.setVideoPath(paramString);
      }
      e(true, 0.0F);
    }
    for (;;)
    {
      this.RgX.setEnableDrag(true);
      com.tencent.mm.kernel.h.baF();
      if (((Integer)com.tencent.mm.kernel.h.baE().ban().get(at.a.acOt, Integer.valueOf(0))).intValue() == 1)
      {
        this.ApV.setText(com.tencent.mm.plugin.sight.base.f.aMu(paramString));
        this.ApV.setVisibility(0);
      }
      AppMethodBeat.o(98087);
      return;
      label320:
      str = this.ibT.Url;
      break;
      label331:
      str = this.ibT.aaTl;
      break label188;
      label342:
      this.wCd.setVideoPath(paramString);
      d(true, 0.0F);
      continue;
      label361:
      Log.i(this.TAG, "%d prepare video reset source", new Object[] { Integer.valueOf(hashCode()) });
      if ((this.wCd instanceof VideoPlayerTextureView)) {
        ((VideoPlayerTextureView)this.wCd).iOI();
      }
      bJ(this.RgN, true);
    }
  }
  
  public final void fG(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(308221);
    Log.i(this.TAG, "onGetVideoSize width:%d height:%d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    this.videoWidth = paramInt1;
    this.videoHeight = paramInt2;
    AppMethodBeat.o(308221);
  }
  
  protected Context getActivityContext()
  {
    if (this.Rhb == null) {
      return this.mContext;
    }
    return this.Rhb;
  }
  
  public int getBottomSafeHeight()
  {
    AppMethodBeat.i(308318);
    int i;
    int j;
    int k;
    if (this.RgX.getVisibility() == 0)
    {
      i = this.Rhn;
      j = com.tencent.mm.cd.a.br(this.Rhb, b.d.Edge_4_5_A);
      k = com.tencent.mm.cd.a.br(this.Rhb, b.d.Edge_2A);
      int m = this.pvk;
      AppMethodBeat.o(308318);
      return i + j + k + m;
    }
    if (this.Rhn != 0)
    {
      i = this.Rhn;
      j = com.tencent.mm.cd.a.br(this.Rhb, b.d.Edge_2A);
      k = this.pvk;
      AppMethodBeat.o(308318);
      return i + j + k;
    }
    AppMethodBeat.o(308318);
    return 0;
  }
  
  public int getCurrentPosition()
  {
    AppMethodBeat.i(98100);
    int i = this.wCd.getCurrentPosition();
    AppMethodBeat.o(98100);
    return i;
  }
  
  public int getDuration()
  {
    AppMethodBeat.i(98077);
    if (this.wCd == null)
    {
      AppMethodBeat.o(98077);
      return 0;
    }
    int i = this.wCd.getDuration();
    AppMethodBeat.o(98077);
    return i;
  }
  
  public String getFilePath()
  {
    return this.filePath;
  }
  
  public int getPlayErrorCode()
  {
    return this.Aqc;
  }
  
  public int getPlayVideoDuration()
  {
    AppMethodBeat.i(98094);
    if (this.Rhi < 0) {
      this.Rhi = 0;
    }
    Log.i(this.TAG, "%d get play video duration [%d]", new Object[] { Integer.valueOf(hashCode()), Integer.valueOf(this.Rhi) });
    int i = this.Rhi;
    AppMethodBeat.o(98094);
    return i;
  }
  
  public int getPlayVideoDurationByResume()
  {
    AppMethodBeat.i(98097);
    if (this.Rhk < 0) {
      this.Rhk = 0;
    }
    Log.i(this.TAG, "%d get play video duration by resume [%d]", new Object[] { Integer.valueOf(hashCode()), Integer.valueOf(this.Rhk) });
    int i = this.Rhk;
    AppMethodBeat.o(98097);
    return i;
  }
  
  public aq.c getRptStruct()
  {
    AppMethodBeat.i(98099);
    aq.c localc = new aq.c();
    localc.scene = this.scene;
    localc.sessionId = this.sessionId;
    localc.RgS = this.RgS;
    localc.hQX = this.hQX;
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
    return this.RgS;
  }
  
  public String getSnsId()
  {
    return this.hQX;
  }
  
  public int getUiStayTime()
  {
    if ((this.RgQ > 0L) && (this.RgP > 0L)) {}
    for (int i = (int)(this.RgQ - this.RgP);; i = 0)
    {
      if (i < 0) {
        return 0;
      }
      return i;
    }
  }
  
  public int getVideoVideoMoveMargin()
  {
    return this.Rhp;
  }
  
  public int getVideoViewBottom()
  {
    return this.Rho;
  }
  
  public final void grj()
  {
    AppMethodBeat.i(308146);
    this.RgX.setVisibility(4);
    this.RgY.setVisibility(4);
    AppMethodBeat.o(308146);
  }
  
  public final int gw(int paramInt1, int paramInt2)
  {
    return 0;
  }
  
  public final void hmA()
  {
    AppMethodBeat.i(98064);
    Log.d(this.TAG, "%d unRegister sns ui event", new Object[] { Integer.valueOf(hashCode()) });
    this.Rhg.dead();
    AppMethodBeat.o(98064);
  }
  
  public final String hmB()
  {
    AppMethodBeat.i(98066);
    Object localObject = new StringBuffer();
    try
    {
      if (this.ibT != null) {
        ((StringBuffer)localObject).append("media: " + this.ibT.Id);
      }
      if (this.hHB != null) {
        ((StringBuffer)localObject).append("localId: " + this.hHB);
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
  
  public final void hmD()
  {
    this.Rhb = null;
    this.Rhc = false;
  }
  
  public final boolean hmF()
  {
    boolean bool = true;
    AppMethodBeat.i(98088);
    Log.i(this.TAG, "%d resumeByDataGain", new Object[] { Integer.valueOf(hashCode()) });
    if (!this.RgT)
    {
      AppMethodBeat.o(98088);
      return false;
    }
    if (!this.wCd.isPlaying())
    {
      hmH();
      hmJ();
      bool = this.wCd.start();
      hideLoading();
    }
    AppMethodBeat.o(98088);
    return bool;
  }
  
  public final boolean hmG()
  {
    return this.RgT;
  }
  
  public final void hmt()
  {
    AppMethodBeat.i(98082);
    if ((this.wCd instanceof ThumbPlayerVideoView))
    {
      AppMethodBeat.o(98082);
      return;
    }
    this.QTh.stopTimer();
    this.wCj.stopTimer();
    AppMethodBeat.o(98082);
  }
  
  public final void hmy()
  {
    this.RgR = false;
  }
  
  public final void hmz()
  {
    AppMethodBeat.i(98063);
    Log.d(this.TAG, "%d register sns ui event", new Object[] { Integer.valueOf(hashCode()) });
    this.Rhg.alive();
    AppMethodBeat.o(98063);
  }
  
  protected final void ho(boolean paramBoolean)
  {
    AppMethodBeat.i(98081);
    if ((this.wCd instanceof ThumbPlayerVideoView))
    {
      AppMethodBeat.o(98081);
      return;
    }
    if (this.RgL)
    {
      if (paramBoolean)
      {
        MMHandlerThread.postToMainThread(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(308228);
            if ((OnlineVideoView.this.wCd != null) && (OnlineVideoView.this.RgK != null))
            {
              int i = OnlineVideoView.this.wCd.getCurrentPosition() / 1000;
              OnlineVideoView.this.RgK.xa(i);
            }
            OnlineVideoView.F(OnlineVideoView.this).startTimer(500L);
            AppMethodBeat.o(308228);
          }
        });
        AppMethodBeat.o(98081);
        return;
      }
      this.QTh.startTimer(500L);
      AppMethodBeat.o(98081);
      return;
    }
    this.wCj.startTimer(500L);
    AppMethodBeat.o(98081);
  }
  
  public final boolean isPlaying()
  {
    AppMethodBeat.i(98098);
    boolean bool = this.wCd.isPlaying();
    AppMethodBeat.o(98098);
    return bool;
  }
  
  public final void lE(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(308145);
    Log.i(this.TAG, "showSeekBarIfLessThanLimit limit:%d current:%d total:%d", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(this.wCd.getDuration()), Integer.valueOf(paramInt1) });
    this.RgX.setTotalTimeMs(paramInt1);
    boolean bool;
    if (paramInt1 >= paramInt2)
    {
      bool = ((com.tencent.mm.plugin.expt.b.c)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.expt.b.c.class)).a(c.a.yJd, true);
      Log.i(this.TAG, "enableShowSeekBar:%b", new Object[] { Boolean.valueOf(bool) });
      if (bool)
      {
        this.RgX.setVisibility(0);
        this.RgY.setVisibility(0);
        this.RgX.setVideoPlayDurationProvider(new HeroSeekBarView.c()
        {
          public final long hmR()
          {
            AppMethodBeat.i(307738);
            long l = OnlineVideoView.this.wCd.getCurrentPosition();
            AppMethodBeat.o(307738);
            return l;
          }
        });
        HeroSeekBarView localHeroSeekBarView = this.RgX;
        localHeroSeekBarView.YnQ = true;
        kotlinx.coroutines.j.a(localHeroSeekBarView.scope, null, null, (kotlin.g.a.m)new HeroSeekBarView.f(localHeroSeekBarView, null), 3);
        localHeroSeekBarView = this.RgX;
        if (!TextUtils.isEmpty(this.wCd.getVideoPath()))
        {
          bool = true;
          localHeroSeekBarView.setEnableDrag(bool);
        }
      }
    }
    for (;;)
    {
      if ((this.wCd instanceof View)) {
        this.dBj = com.tencent.threadpool.h.ahAA.bo(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(307724);
            Object localObject = com.tencent.mm.plugin.sight.base.f.aVX(OnlineVideoView.P(OnlineVideoView.this));
            if ((localObject == null) || (((com.tencent.mm.plugin.sight.base.b)localObject).height == 0) || (((com.tencent.mm.plugin.sight.base.b)localObject).width == 0))
            {
              AppMethodBeat.o(307724);
              return;
            }
            int i = SightVideoJNI.getMp4RotateVFS(OnlineVideoView.P(OnlineVideoView.this));
            if ((i == 90) || (i == 270)) {
              i = ((com.tencent.mm.plugin.sight.base.b)localObject).width;
            }
            int k;
            for (int j = ((com.tencent.mm.plugin.sight.base.b)localObject).height;; j = ((com.tencent.mm.plugin.sight.base.b)localObject).width)
            {
              localObject = com.tencent.mm.plugin.recordvideo.model.a.NIt;
              float f = com.tencent.mm.plugin.recordvideo.model.a.gHH() * 1.0F / j;
              i = (int)(i * f);
              localObject = com.tencent.mm.plugin.recordvideo.model.a.NIt;
              k = com.tencent.mm.plugin.recordvideo.model.a.getDisplayHeight();
              j = (k - i) / 2;
              if (j > 0) {
                break;
              }
              OnlineVideoView.c(OnlineVideoView.this, k);
              AppMethodBeat.o(307724);
              return;
              i = ((com.tencent.mm.plugin.sight.base.b)localObject).height;
            }
            if (j < OnlineVideoView.this.getBottomSafeHeight())
            {
              i = OnlineVideoView.this.getBottomSafeHeight() - j;
              if (i <= j) {
                break label320;
              }
              i = j;
            }
            label320:
            for (;;)
            {
              OnlineVideoView.d(OnlineVideoView.this, i);
              localObject = (RelativeLayout.LayoutParams)((View)OnlineVideoView.this.wCd).getLayoutParams();
              ((RelativeLayout.LayoutParams)localObject).addRule(12);
              ((RelativeLayout.LayoutParams)localObject).bottomMargin = (i + j);
              OnlineVideoView.c(OnlineVideoView.this, k - (i + j));
              final RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)OnlineVideoView.C(OnlineVideoView.this).getLayoutParams();
              localLayoutParams.addRule(12);
              localLayoutParams.bottomMargin = (i + j);
              localLayoutParams.topMargin = (j - i);
              com.tencent.threadpool.h.ahAA.bk(new Runnable()
              {
                public final void run()
                {
                  AppMethodBeat.i(308011);
                  ((View)OnlineVideoView.this.wCd).setLayoutParams(this.Rhv);
                  OnlineVideoView.C(OnlineVideoView.this).setLayoutParams(localLayoutParams);
                  OnlineVideoView.C(OnlineVideoView.this).setScaleType(ImageView.ScaleType.CENTER_CROP);
                  AppMethodBeat.o(308011);
                }
              });
              AppMethodBeat.o(307724);
              return;
              OnlineVideoView.c(OnlineVideoView.this, k - j);
              AppMethodBeat.o(307724);
              return;
            }
          }
        });
      }
      AppMethodBeat.o(308145);
      return;
      bool = false;
      break;
      grj();
    }
  }
  
  public final void onCompletion()
  {
    AppMethodBeat.i(98085);
    Log.i(this.TAG, "%d on completion", new Object[] { Integer.valueOf(hashCode()) });
    Object localObject = this.RgI;
    if (localObject == null) {
      if ((com.tencent.mm.compatible.util.d.rd(18)) || (!this.Aqb)) {
        bJ(0, true);
      }
    }
    for (;;)
    {
      if (this.RgX != null) {
        this.RgX.reset();
      }
      this.cFq = false;
      AppMethodBeat.o(98085);
      return;
      if (this.wCd != null)
      {
        localObject = this.wCd.getVideoPath();
        this.wCd.stop();
        if (!y.ZC((String)localObject))
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
        di((String)localObject, this.RgL);
        continue;
        ((b)localObject).onCompletion();
      }
    }
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(98070);
    Log.d(this.TAG, "%d on destroy %s", new Object[] { Integer.valueOf(hashCode()), Util.getStack() });
    this.RgQ = Util.nowMilliSecond();
    unInit();
    this.RgT = false;
    AppMethodBeat.o(98070);
  }
  
  public final void onError(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(98083);
    Log.e(this.TAG, "%d on play video error what %d extra %d. isOnlinePlay %b isMMVideoPlayer[%b]", new Object[] { Integer.valueOf(hashCode()), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Boolean.valueOf(this.RgL), Boolean.valueOf(this.Aqb) });
    Object localObject;
    if (this.RgL)
    {
      com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(354L, 230L, 1L, false);
      this.Aqc = paramInt2;
      hmI();
      localObject = this.wCd.getVideoPath();
      this.RgN = (this.wCd.getCurrentPosition() / 1000);
      if (!this.RgL) {
        break label426;
      }
      if (paramInt1 != -2) {
        break label387;
      }
      this.wCd.stop();
    }
    for (;;)
    {
      try
      {
        showLoading();
        if (this.RgK != null)
        {
          localObject = this.RgK;
          str = ((aq)localObject).oYq + 0 + "_-1";
          if (!((aq)localObject).RhF.containsKey(str))
          {
            Log.i(((aq)localObject).TAG, "request all data. [%s]", new Object[] { ((aq)localObject).oYq });
            v.bOi();
            com.tencent.mm.modelcdntran.j.v(((aq)localObject).oYq, 0, -1);
            ((aq)localObject).RhF.put(str, Integer.valueOf(0));
            com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(354L, 207L, 1L, false);
            com.tencent.mm.plugin.report.service.h.OAn.b(13836, new Object[] { Integer.valueOf(403), Long.valueOf(Util.nowSecond()), "" });
          }
          ((aq)localObject).oYt = 5;
          ((aq)localObject).oYy = true;
          ((aq)localObject).oYB = false;
        }
        if (this.RgU != null) {
          this.RgU.hKC();
        }
        hmI();
      }
      catch (Exception localException)
      {
        String str;
        label387:
        label426:
        continue;
      }
      if ((this.ibT != null) && (this.ibT.isAd)) {
        com.tencent.mm.plugin.report.service.h.OAn.kJ(1579, 8);
      }
      AppMethodBeat.o(98083);
      return;
      com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(354L, 231L, 1L, false);
      break;
      if (paramInt1 == -3)
      {
        this.RgO = paramInt1;
        this.wCd.pause();
      }
      else
      {
        hmt();
        this.wCd.stop();
        continue;
        this.wCd.stop();
        this.Aqa = true;
        if ((this.wCd instanceof ThumbPlayerVideoView))
        {
          e(false, 0.0F);
          Log.w(this.TAG, "error %s, %s", new Object[] { Boolean.valueOf(this.Rhc), localObject });
          if ((!Util.isNullOrNil((String)localObject)) && (this.Rhc) && (y.ZC((String)localObject)))
          {
            Log.w(this.TAG, "%d start third player to play", new Object[] { Integer.valueOf(hashCode()) });
            this.wAW.post(new Runnable()
            {
              public final void run()
              {
                AppMethodBeat.i(307777);
                Object localObject2 = new Intent();
                ((Intent)localObject2).setAction("android.intent.action.VIEW");
                FileProviderHelper.setIntentDataAndType(OnlineVideoView.this.getContext(), (Intent)localObject2, new u(this.Aqm), "video/*", false);
                try
                {
                  Context localContext = OnlineVideoView.this.getContext();
                  localObject2 = new com.tencent.mm.hellhoundlib.b.a().cG(localObject2);
                  com.tencent.mm.hellhoundlib.a.a.b(localContext, ((com.tencent.mm.hellhoundlib.b.a)localObject2).aYi(), "com/tencent/mm/plugin/sns/ui/OnlineVideoView$24", "run", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                  localContext.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject2).sb(0));
                  com.tencent.mm.hellhoundlib.a.a.c(localContext, "com/tencent/mm/plugin/sns/ui/OnlineVideoView$24", "run", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                  AppMethodBeat.o(307777);
                  return;
                }
                catch (Exception localException)
                {
                  Log.e(OnlineVideoView.c(OnlineVideoView.this), "startActivity fail, activity not found");
                  try
                  {
                    g.a locala = new g.a(OnlineVideoView.this.getContext());
                    locala.bDE(OnlineVideoView.this.getContext().getString(b.j.favorite_no_match_msg));
                    locala.bf(OnlineVideoView.this.getContext().getString(b.j.favorite_no_match_title)).c(new g.c()
                    {
                      public final void onDialogClick(boolean paramAnonymous2Boolean, String paramAnonymous2String) {}
                    }).show();
                    AppMethodBeat.o(307777);
                    return;
                  }
                  finally
                  {
                    Log.e(OnlineVideoView.c(OnlineVideoView.this), "showAlert fail");
                    AppMethodBeat.o(307777);
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
        if (!y.ZC((String)localObject))
        {
          str = getRelocatedVideoPath();
          Log.w(this.TAG, "onError: file path is out of date, old path: %s, new path: %s", new Object[] { localObject, str });
          if (Util.isNullOrNil(str))
          {
            Log.e(this.TAG, "onError: invalid file");
            AppMethodBeat.o(98083);
            return;
          }
          di(str, this.RgL);
        }
      }
    }
  }
  
  public final void onPause()
  {
    AppMethodBeat.i(98069);
    Log.d(this.TAG, "%d on pause %s ", new Object[] { Integer.valueOf(hashCode()), Util.getStack() });
    hmt();
    if (this.wCd != null) {
      this.wCd.stop();
    }
    this.RgT = false;
    AppMethodBeat.o(98069);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(98068);
    Log.d(this.TAG, "%d on resume %s", new Object[] { Integer.valueOf(hashCode()), Util.getStack() });
    this.RgP = Util.nowMilliSecond();
    this.RgT = true;
    if (this.Rha)
    {
      Log.e(this.TAG, "what are you doing guys!!! Would you like to invite everyone to eat pizza??? %s", new Object[] { Util.getStack() });
      com.tencent.mm.plugin.report.service.h.OAn.p(31L, 3L, 1L);
    }
    while (this.isInit)
    {
      if (!this.Aqa) {
        dSY();
      }
      this.Rgw = true;
      AppMethodBeat.o(98068);
      return;
    }
    this.isInit = true;
    Log.i(this.TAG, "%d logic init, create new helper and add listener.", new Object[] { Integer.valueOf(hashCode()) });
    this.RgT = true;
    if ((this.wCd instanceof ThumbPlayerVideoView))
    {
      com.tencent.mm.plugin.thumbplayer.f.d locald = new com.tencent.mm.plugin.thumbplayer.f.d(new pm(), this.RgP, 2);
      com.tencent.mm.plugin.thumbplayer.f.b localb = new com.tencent.mm.plugin.thumbplayer.f.b(this.RgP);
      final ThumbPlayerVideoView localThumbPlayerVideoView = (ThumbPlayerVideoView)this.wCd;
      if (localThumbPlayerVideoView.isInitialized())
      {
        Log.w(this.TAG, "init tp player but the previous stop operation seems not success");
        this.wCd.stop();
      }
      localThumbPlayerVideoView.a(localb);
      localThumbPlayerVideoView.a(locald);
      localThumbPlayerVideoView.setProgressListener(new ThumbPlayerVideoView.d()
      {
        public final void qT(long paramAnonymousLong)
        {
          AppMethodBeat.i(308475);
          OnlineVideoView.this.alJ((int)paramAnonymousLong);
          AppMethodBeat.o(308475);
        }
      });
      if ((this.ibT != null) && (this.hHB != null))
      {
        this.RgV = new com.tencent.mm.plugin.sns.ui.video.c(this.ibT, this.createTime, this.hHB, localb, new com.tencent.mm.plugin.sns.ui.video.c.b()
        {
          public final aq.c hhZ()
          {
            AppMethodBeat.i(308448);
            aq.c localc = OnlineVideoView.this.getRptStruct();
            AppMethodBeat.o(308448);
            return localc;
          }
          
          public final long hia()
          {
            AppMethodBeat.i(308450);
            long l = OnlineVideoView.this.getPlayVideoDurationByResume();
            AppMethodBeat.o(308450);
            return l;
          }
        });
        this.RgU = new com.tencent.mm.plugin.thumbplayer.downloader.d(this.RgV);
        this.RgU.a(locald);
        this.RgU.a(localb);
        this.RgW = new com.tencent.mm.plugin.sns.ui.video.f(this.RgU, new f.a()
        {
          public final void f(Exception paramAnonymousException)
          {
            AppMethodBeat.i(308503);
            Log.printErrStackTrace(OnlineVideoView.c(OnlineVideoView.this), paramAnonymousException, "onError", new Object[0]);
            AppMethodBeat.o(308503);
          }
          
          public final void fvq()
          {
            AppMethodBeat.i(308501);
            Log.i(OnlineVideoView.c(OnlineVideoView.this), "onCompleted");
            if (OnlineVideoView.j(OnlineVideoView.this) > 0)
            {
              OnlineVideoView.f(OnlineVideoView.this);
              OnlineVideoView.a(OnlineVideoView.this, OnlineVideoView.j(OnlineVideoView.this));
            }
            for (;;)
            {
              OnlineVideoView.o(OnlineVideoView.this).hsA();
              OnlineVideoView.f(OnlineVideoView.this);
              AppMethodBeat.o(308501);
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
              else if (OnlineVideoView.this.RgU != null)
              {
                OnlineVideoView.this.di(OnlineVideoView.this.RgU.hKD(), false);
              }
            }
          }
          
          public final void hmS()
          {
            AppMethodBeat.i(308498);
            Log.i(OnlineVideoView.c(OnlineVideoView.this), "onMoovReady: downloader=" + OnlineVideoView.this.RgU);
            if (OnlineVideoView.this.RgU != null)
            {
              localThumbPlayerVideoView.setResourceDownloader(OnlineVideoView.this.RgU);
              localThumbPlayerVideoView.prepare();
              OnlineVideoView.this.di(localThumbPlayerVideoView.getVideoPath(), true);
            }
            AppMethodBeat.o(308498);
          }
          
          public final void onProgress(float paramAnonymousFloat)
          {
            AppMethodBeat.i(308506);
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
            AppMethodBeat.o(308506);
          }
        });
      }
    }
    for (;;)
    {
      this.Rhf.alive();
      al.hgw().a(this.Rhe);
      if (this.RgR)
      {
        this.vZw = new com.tencent.mm.model.d();
        this.vZw.a(this);
      }
      if (com.tencent.mm.n.a.aDI() == null) {
        break;
      }
      com.tencent.mm.n.a.aDI().aKl();
      break;
      Log.e(this.TAG, "null check failed: media=%s, localId=%s", new Object[] { this.ibT, this.hHB });
      continue;
      this.RgK = new aq(this);
      Log.i(this.TAG, "onlineVideoHelper hash:%d", new Object[] { Integer.valueOf(this.RgK.hashCode()) });
      this.QyK.alive();
    }
  }
  
  public void setFilePath(String paramString)
  {
    this.filePath = paramString;
  }
  
  public void setMute(boolean paramBoolean)
  {
    AppMethodBeat.i(98067);
    this.lAj = paramBoolean;
    this.wCd.setMute(this.lAj);
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
    this.RgS = paramLong;
  }
  
  public void setSnsId(String paramString)
  {
    this.hQX = paramString;
  }
  
  public void setThumbViewScaleType(ImageView.ScaleType paramScaleType)
  {
    AppMethodBeat.i(98101);
    this.AlJ.setScaleType(paramScaleType);
    AppMethodBeat.o(98101);
  }
  
  public void setThumbViewVisibility(int paramInt)
  {
    AppMethodBeat.i(308278);
    this.AlJ.setVisibility(paramInt);
    AppMethodBeat.o(308278);
  }
  
  public void setVideoCallback(b paramb)
  {
    this.RgI = paramb;
  }
  
  public void setVideoScaleType(com.tencent.mm.pluginsdk.ui.i.e parame)
  {
    AppMethodBeat.i(98102);
    if (this.wCd != null)
    {
      if ((this.wCd instanceof VideoPlayerTextureView))
      {
        ((VideoPlayerTextureView)this.wCd).setScaleType(parame);
        AppMethodBeat.o(98102);
        return;
      }
      if ((this.wCd instanceof VideoTextureView))
      {
        ((VideoTextureView)this.wCd).setScaleType(parame);
        AppMethodBeat.o(98102);
        return;
      }
      if ((this.wCd instanceof ThumbPlayerVideoView)) {
        ((ThumbPlayerVideoView)this.wCd).setScaleType(parame);
      }
    }
    AppMethodBeat.o(98102);
  }
  
  final class a
    implements Runnable
  {
    int RhD = -1;
    long RhE = -1L;
    
    private a() {}
    
    public final void run()
    {
      AppMethodBeat.i(308037);
      this.RhE = SystemClock.uptimeMillis();
      OnlineVideoView.this.bJ(this.RhD, false);
      AppMethodBeat.o(308037);
    }
  }
  
  public static abstract interface b
  {
    public abstract void Bh(int paramInt);
    
    public abstract void onCompletion();
    
    public abstract void onStart(int paramInt);
  }
  
  public static abstract interface c
    extends OnlineVideoView.b
  {
    public abstract void onPause();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.OnlineVideoView
 * JD-Core Version:    0.7.0.1
 */