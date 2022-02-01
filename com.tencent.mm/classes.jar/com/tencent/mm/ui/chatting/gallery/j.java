package com.tencent.mm.ui.chatting.gallery;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Looper;
import android.os.Message;
import android.os.PowerManager;
import android.os.PowerManager.WakeLock;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.util.SparseArray;
import android.view.View;
import android.view.Window;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ag.k.b;
import com.tencent.mm.ag.y;
import com.tencent.mm.ak.d.c;
import com.tencent.mm.av.a.a.c.a;
import com.tencent.mm.av.q;
import com.tencent.mm.compatible.deviceinfo.ae;
import com.tencent.mm.g.a.oq;
import com.tencent.mm.g.a.oq.a;
import com.tencent.mm.g.c.eo;
import com.tencent.mm.ipcinvoker.wx_extension.IPCRunCgi;
import com.tencent.mm.ipcinvoker.wx_extension.IPCRunCgi.a;
import com.tencent.mm.model.ad;
import com.tencent.mm.model.ad.b;
import com.tencent.mm.model.bg;
import com.tencent.mm.model.c;
import com.tencent.mm.modelvideo.r;
import com.tencent.mm.modelvideo.t;
import com.tencent.mm.modelvideo.t.a;
import com.tencent.mm.modelvideo.t.a.a;
import com.tencent.mm.modelvideo.y.a;
import com.tencent.mm.network.ag;
import com.tencent.mm.plugin.messenger.foundation.a.a.i;
import com.tencent.mm.pluginsdk.ui.i.e;
import com.tencent.mm.pluginsdk.ui.tools.RedesignVideoPlayerSeekBar;
import com.tencent.mm.pluginsdk.ui.tools.VideoPlayerTextureView;
import com.tencent.mm.pluginsdk.ui.tools.VideoTextureView;
import com.tencent.mm.pluginsdk.ui.tools.j.e;
import com.tencent.mm.protocal.protobuf.bsq;
import com.tencent.mm.protocal.protobuf.bsr;
import com.tencent.mm.protocal.protobuf.cly;
import com.tencent.mm.protocal.protobuf.crj;
import com.tencent.mm.protocal.protobuf.eeq;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.BitmapFactory;
import com.tencent.mm.sdk.platformtools.FileProviderHelper;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.MMHandler.Callback;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.MTimerHandler;
import com.tencent.mm.sdk.platformtools.MTimerHandler.CallBack;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ar.a;
import com.tencent.mm.storage.ca;
import com.tencent.mm.ui.chatting.al;
import com.tencent.mm.ui.chatting.al.a;
import com.tencent.mm.ui.widget.MMPinProgressBtn;
import java.io.IOException;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;
import kotlin.g.b.z.f;

public final class j
  extends a
  implements com.tencent.mm.model.d.a, t.a
{
  private static y PAo = null;
  public static boolean PAp = false;
  private MTimerHandler Ehq;
  private j.e EtE;
  private boolean EtM;
  private long EtQ;
  private long EtR;
  private long Eua;
  private int Eub;
  private IListener PAf;
  final SparseArray<com.tencent.mm.modelvideo.s> PAg;
  private o PAh;
  private boolean PAi;
  private boolean PAj;
  private boolean PAk;
  private int PAl;
  private int PAm;
  private boolean PAn;
  MMHandler PAq;
  private int PAr;
  private IListener<oq> PAs;
  private boolean PAt;
  private int PAu;
  private int[] PAv;
  private HashMap<String, a> Pyt;
  private String filename;
  private PowerManager.WakeLock hCN;
  private long lastCheckTime;
  private long mEN;
  private com.tencent.mm.model.d pNk;
  private MTimerHandler qbP;
  int tnb;
  private int tnc;
  private com.tencent.mm.plugin.sight.decode.ui.b tni;
  private com.tencent.mm.plugin.n.b zrF;
  
  public j(b paramb)
  {
    super(paramb);
    AppMethodBeat.i(36261);
    this.PAg = new SparseArray();
    this.PAi = false;
    this.PAj = false;
    this.PAk = false;
    this.tnc = 0;
    this.mEN = 0L;
    this.lastCheckTime = 0L;
    this.PAl = 0;
    this.PAm = 0;
    this.EtQ = 0L;
    this.EtR = 0L;
    this.tnb = 0;
    this.PAn = false;
    this.PAq = new MMHandler(Looper.getMainLooper(), new MMHandler.Callback()
    {
      public final boolean handleMessage(Message paramAnonymousMessage)
      {
        AppMethodBeat.i(36254);
        if (paramAnonymousMessage.what == 1)
        {
          paramAnonymousMessage = j.this.Pwu.gSh();
          if ((paramAnonymousMessage != null) && (!Util.isNullOrNil(j.b(j.this))))
          {
            Log.i("MicroMsg.Imagegallery.handler.video", "%d ui on pause, pause video now. %s", new Object[] { Integer.valueOf(hashCode()), j.b(j.this) });
            if (!j.c(j.this)) {
              com.tencent.mm.modelvideo.u.f(j.b(j.this), paramAnonymousMessage.gTe().PAO.getCurrentPosition(), j.d(j.this));
            }
            j.g(paramAnonymousMessage);
            j.b(j.this, paramAnonymousMessage);
            j.e(j.this).fp(false);
            if (j.d(j.this))
            {
              EventCenter.instance.removeListener(j.f(j.this));
              j.g(j.this).gTi();
              j.a(j.this, false);
            }
          }
          j.h(j.this);
        }
        AppMethodBeat.o(36254);
        return false;
      }
    });
    this.PAr = 0;
    this.Ehq = new MTimerHandler(new MTimerHandler.CallBack()
    {
      public final boolean onTimerExpired()
      {
        AppMethodBeat.i(36258);
        if (!j.g(j.this).isStreaming())
        {
          AppMethodBeat.o(36258);
          return false;
        }
        k localk = j.this.Pwu.gSh();
        if (localk == null)
        {
          AppMethodBeat.o(36258);
          return false;
        }
        if (localk.PAL == null)
        {
          AppMethodBeat.o(36258);
          return false;
        }
        if (localk.gTe().PAL.getVisibility() != 0)
        {
          AppMethodBeat.o(36258);
          return false;
        }
        boolean bool = true;
        if (localk.gTe().PAO.isPlaying()) {
          bool = j.c(j.this, localk);
        }
        if (bool)
        {
          int i = localk.gTe().PAO.getCurrentPosition() / 1000;
          bool = j.g(j.this).ub(i);
          AppMethodBeat.o(36258);
          return bool;
        }
        AppMethodBeat.o(36258);
        return false;
      }
    }, true);
    this.qbP = new MTimerHandler(new MTimerHandler.CallBack()
    {
      public final boolean onTimerExpired()
      {
        AppMethodBeat.i(36259);
        if (j.this.Pwu == null)
        {
          Log.w("MicroMsg.Imagegallery.handler.video", "[onTimerExpired] null == adapter");
          AppMethodBeat.o(36259);
          return false;
        }
        k localk = j.this.Pwu.gSh();
        if (localk == null)
        {
          AppMethodBeat.o(36259);
          return false;
        }
        if (localk.PAL == null)
        {
          AppMethodBeat.o(36259);
          return false;
        }
        if (localk.gTe().PAL.getVisibility() != 0)
        {
          AppMethodBeat.o(36259);
          return false;
        }
        int i = j.this.Pwu.Pwv.getCurrentItem();
        if ((com.tencent.mm.modelvideo.s)j.this.PAg.get(i) == null)
        {
          j.this.ank(i);
          AppMethodBeat.o(36259);
          return false;
        }
        if (!localk.gTe().PAO.isPlaying())
        {
          Log.i("MicroMsg.Imagegallery.handler.video", "it is not playing, stop offline timer");
          AppMethodBeat.o(36259);
          return false;
        }
        j.a(j.this, localk.gTe().PAO.getCurrentPosition());
        j.this.anl(j.o(j.this) / 1000);
        AppMethodBeat.o(36259);
        return true;
      }
    }, true);
    this.tni = new com.tencent.mm.plugin.sight.decode.ui.b()
    {
      public final void aJq()
      {
        AppMethodBeat.i(36244);
        if (j.this.Pwu.gSh() != null) {
          j.b(j.this, j.this.Pwu.gSh());
        }
        j.this.Pwu.Pwv.tnh.stopTimer();
        AppMethodBeat.o(36244);
      }
      
      public final void rk(int paramAnonymousInt)
      {
        AppMethodBeat.i(36245);
        localObject = null;
        try
        {
          String str = j.this.Pwu.gSh().gTe().PAO.getVideoPath();
          localObject = str;
        }
        catch (Exception localException)
        {
          for (;;)
          {
            Log.printErrStackTrace("MicroMsg.Imagegallery.handler.video", localException, "", new Object[0]);
            Log.e("MicroMsg.Imagegallery.handler.video", "on seek get video path error: " + localException.toString());
            continue;
            boolean bool = j.g(j.this).bL(paramAnonymousInt, true);
            continue;
            localObject = j.this.Pwu.gSg();
            if ((localObject != null) && (((ca)localObject).cWJ())) {
              com.tencent.mm.modelvideo.u.f(((eo)localObject).field_imgPath, paramAnonymousInt * 1000, j.d(j.this));
            }
            j.this.Pwu.amS(j.this.Pwu.Pwv.getCurrentItem());
          }
        }
        Log.i("MicroMsg.Imagegallery.handler.video", "on seek to time[%d] isOnlinePlay[%b] videoPath[%s]", new Object[] { Integer.valueOf(paramAnonymousInt), Boolean.valueOf(j.d(j.this)), localObject });
        j.this.Pwu.gSh().gTe().PAN.setVisibility(8);
        if (!Util.isNullOrNil((String)localObject)) {
          if (!j.d(j.this))
          {
            j.this.aT(paramAnonymousInt, true);
            bool = true;
            if (bool) {
              j.this.fO(false);
            }
            j.this.Pwu.Pwv.gSQ();
            localObject = j.this.Pwu.gSg();
            if ((localObject != null) && (((ca)localObject).cWK())) {
              j.this.Pwu.Pwv.PyB.i((ca)localObject, 13);
            }
            AppMethodBeat.o(36245);
            return;
          }
        }
      }
    };
    this.PAs = new IListener()
    {
      private boolean a(oq paramAnonymousoq)
      {
        AppMethodBeat.i(36246);
        if (!j.g(j.this).aQW(paramAnonymousoq.dUF.mediaId))
        {
          AppMethodBeat.o(36246);
          return false;
        }
        if ((paramAnonymousoq.dUF.retCode != 0) && (paramAnonymousoq.dUF.retCode != -21006))
        {
          Log.w("MicroMsg.Imagegallery.handler.video", "stream download online video error. retCode: " + paramAnonymousoq.dUF.retCode);
          j.a(j.this, paramAnonymousoq.dUF.mediaId, paramAnonymousoq.dUF.retCode);
          AppMethodBeat.o(36246);
          return false;
        }
        switch (paramAnonymousoq.dUF.dKy)
        {
        default: 
          Log.w("MicroMsg.Imagegallery.handler.video", "unknown event opcode " + paramAnonymousoq.dUF.dKy);
        }
        for (;;)
        {
          AppMethodBeat.o(36246);
          return false;
          o localo = j.g(j.this);
          long l2 = paramAnonymousoq.dUF.offset;
          long l1 = paramAnonymousoq.dUF.dUG;
          boolean bool = paramAnonymousoq.dUF.dUH;
          Log.i("MicroMsg.OnlineVideoUIHelper", "deal moov ready moovPos[%d] needSeekTime[%d] timeDuration[%d] startDownload[%d %d]", new Object[] { Long.valueOf(l2), Integer.valueOf(localo.jpZ), Integer.valueOf(localo.jpY), Long.valueOf(l1), Long.valueOf(localo.gqR) });
          if (localo.jpY != 0) {
            Log.w("MicroMsg.OnlineVideoUIHelper", "moov had callback, do nothing.");
          }
          for (;;)
          {
            j.a(j.this, true);
            break;
            if (l1 > localo.gqR) {}
            for (;;)
            {
              for (;;)
              {
                localo.gqR = l1;
                com.tencent.mm.plugin.report.service.h.CyF.idkeyStat(354L, 5L, 1L, false);
                localo.Eut = Util.nowMilliSecond();
                com.tencent.mm.modelvideo.o.bhj();
                paramAnonymousoq = t.Qw(localo.filename);
                try
                {
                  if (localo.Eup != null) {
                    break label435;
                  }
                  Log.w("MicroMsg.OnlineVideoUIHelper", "parser is null, thread is error.");
                }
                catch (Exception paramAnonymousoq)
                {
                  Log.printErrStackTrace("MicroMsg.OnlineVideoUIHelper", paramAnonymousoq, "", new Object[0]);
                  Log.e("MicroMsg.OnlineVideoUIHelper", "deal moov ready error: " + paramAnonymousoq.toString());
                }
              }
              break;
              l1 = localo.gqR;
            }
            label435:
            if (localo.Eup.L(paramAnonymousoq, l2))
            {
              localo.jpY = localo.Eup.jQw;
              Log.i("MicroMsg.OnlineVideoUIHelper", "mp4 parse moov success. duration %d filename %s isFastStart %b", new Object[] { Integer.valueOf(localo.jpY), localo.filename, Boolean.valueOf(bool) });
              if (!bool) {
                MMHandlerThread.postToMainThread(new o.1(localo));
              }
              if (localo.jpZ == -1) {}
              for (localo.jpW = 1;; localo.jpW = 2)
              {
                com.tencent.mm.plugin.report.service.h.CyF.idkeyStat(354L, 7L, 1L, false);
                break;
              }
            }
            Log.w("MicroMsg.OnlineVideoUIHelper", "mp4 parse moov error.");
            com.tencent.mm.modelvideo.o.bhk();
            com.tencent.mm.an.e.r(localo.mediaId, 0, -1);
            com.tencent.mm.modelvideo.u.az(localo.filename, 15);
            com.tencent.mm.plugin.report.service.h.CyF.idkeyStat(354L, 8L, 1L, false);
            Log.w("MicroMsg.OnlineVideoUIHelper", "%d rpt parse moov fail %s ", new Object[] { Integer.valueOf(localo.hashCode()), localo.filename });
            com.tencent.mm.plugin.report.service.h.CyF.a(13836, new Object[] { Integer.valueOf(302), Long.valueOf(Util.nowSecond()), "" });
          }
          localo = j.g(j.this);
          Object localObject = paramAnonymousoq.dUF.mediaId;
          int i = paramAnonymousoq.dUF.offset;
          int j = paramAnonymousoq.dUF.length;
          localo.jqf = false;
          if ((i < 0) || (j < 0)) {
            Log.w("MicroMsg.OnlineVideoUIHelper", "deal data available error offset[%d], length[%d]", new Object[] { Integer.valueOf(i), Integer.valueOf(j) });
          }
          while (!localo.aQW((String)localObject))
          {
            if (paramAnonymousoq.dUF.length <= 0) {
              break;
            }
            j.this.fO(true);
            break;
          }
          localObject = localo.mediaId + i + "_" + j;
          localObject = (Integer)localo.Euo.get(localObject);
          if ((localObject != null) && (((Integer)localObject).intValue() > 0)) {
            localo.jqc = ((Integer)localObject).intValue();
          }
          for (;;)
          {
            Log.i("MicroMsg.OnlineVideoUIHelper", "deal data available. offset[%d] length[%d] cachePlayTime[%d]", new Object[] { Integer.valueOf(i), Integer.valueOf(j), Integer.valueOf(localo.jqc) });
            break;
            try
            {
              localo.jqc = localo.Eup.dG(i, j);
            }
            catch (Exception localException)
            {
              Log.printErrStackTrace("MicroMsg.OnlineVideoUIHelper", localException, "", new Object[0]);
              Log.e("MicroMsg.OnlineVideoUIHelper", "deal data available file pos to video time error: " + localException.toString());
            }
          }
          j.this.fO(true);
          continue;
          paramAnonymousoq = j.g(j.this);
          Log.i("MicroMsg.OnlineVideoUIHelper", "deal stream finish. playStatus %d ", new Object[] { Integer.valueOf(paramAnonymousoq.jpW) });
          paramAnonymousoq.jqf = false;
          paramAnonymousoq.jpV = 3;
          if (paramAnonymousoq.jpW == 0)
          {
            Log.w("MicroMsg.OnlineVideoUIHelper", "it had not moov callback and download finish start to play video.");
            paramAnonymousoq.fgy();
            com.tencent.mm.plugin.report.service.h.CyF.idkeyStat(354L, 6L, 1L, false);
          }
          for (;;)
          {
            paramAnonymousoq.gTk();
            com.tencent.mm.plugin.report.service.h.CyF.idkeyStat(354L, 26L, 1L, false);
            j.this.fO(true);
            break;
            if (paramAnonymousoq.jpW == 5)
            {
              Log.w("MicroMsg.OnlineVideoUIHelper", "it had play error, it request all video data finish, start to play." + paramAnonymousoq.mediaId);
              paramAnonymousoq.fgy();
            }
          }
          localo = j.g(j.this);
          String str = paramAnonymousoq.dUF.mediaId;
          i = paramAnonymousoq.dUF.offset;
          if (localo.aQW(str))
          {
            if (localo.kKK != 0) {
              localo.Eur = (i * 100 / localo.kKK);
            }
            Log.i("MicroMsg.OnlineVideoUIHelper", "deal progress callback. downloadedPercent : " + localo.Eur);
          }
          if (localo.Eur >= 100)
          {
            localo.jpV = 3;
            continue;
            paramAnonymousoq = j.g(j.this);
            Log.i("MicroMsg.OnlineVideoUIHelper", "deal had dup video.");
            paramAnonymousoq.gTk();
            paramAnonymousoq.fgy();
          }
        }
      }
    };
    this.PAt = false;
    this.PAu = 0;
    this.PAv = new int[] { -1000, -2000, 3400 };
    this.EtE = new j.e()
    {
      public final void bLh()
      {
        AppMethodBeat.i(36250);
        Log.i("MicroMsg.Imagegallery.handler.video", "%d on texture update.", new Object[] { Integer.valueOf(j.this.hashCode()) });
        try
        {
          j.this.Pwu.gSh().d(true, 1.0F);
          AppMethodBeat.o(36250);
          return;
        }
        catch (Exception localException)
        {
          Log.e("MicroMsg.Imagegallery.handler.video", "texture view update. error " + localException.toString());
          AppMethodBeat.o(36250);
        }
      }
    };
    this.zrF = new com.tencent.mm.plugin.n.b()
    {
      public final long eja()
      {
        AppMethodBeat.i(36251);
        Log.i("MicroMsg.Imagegallery.handler.video", "%d video get online cache sec", new Object[] { Integer.valueOf(j.this.hashCode()) });
        bg.aVF();
        c.azQ().set(ar.a.Oaq, Boolean.TRUE);
        try
        {
          if ((j.d(j.this)) && (j.g(j.this) != null))
          {
            int i = j.g(j.this).jqc;
            long l = i;
            AppMethodBeat.o(36251);
            return l;
          }
        }
        catch (Exception localException)
        {
          AppMethodBeat.o(36251);
        }
        return 0L;
      }
    };
    PAo = null;
    this.Pyt = new HashMap();
    this.PAh = new o(this);
    EventCenter localEventCenter = EventCenter.instance;
    paramb = new al(al.a.Pkm, paramb.Pwv);
    this.PAf = paramb;
    localEventCenter.addListener(paramb);
    EventCenter.instance.addListener(this.PAs);
    this.pNk = new com.tencent.mm.model.d();
    AppMethodBeat.o(36261);
  }
  
  private void a(ca paramca, com.tencent.mm.modelvideo.s params)
  {
    AppMethodBeat.i(36275);
    if ((!ag.dm(this.Pwu.Pwv.getContext())) && (!PAp)) {
      PAp = true;
    }
    b(paramca, params);
    AppMethodBeat.o(36275);
  }
  
  private void a(ca paramca, com.tencent.mm.modelvideo.s params, int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(36274);
    if ((paramca == null) || (params == null))
    {
      AppMethodBeat.o(36274);
      return;
    }
    if ((!paramca.cWK()) && (paramca.gDB()))
    {
      Toast.makeText(this.Pwu.Pwv, 2131767070, 0).show();
      AppMethodBeat.o(36274);
      return;
    }
    Object localObject3;
    Object localObject1;
    if (params.jsu == -1)
    {
      localObject3 = params.bhu();
      localObject1 = localObject3;
      if (!com.tencent.mm.vfs.s.YS((String)localObject3))
      {
        com.tencent.mm.modelvideo.o.bhj();
        localObject1 = t.Qw(paramca.field_imgPath);
        if ((localObject1 != null) && (com.tencent.mm.vfs.s.YS((String)localObject1))) {
          break label336;
        }
        Toast.makeText(this.Pwu.Pwv, 2131767070, 0).show();
        AppMethodBeat.o(36274);
      }
    }
    else
    {
      com.tencent.mm.modelvideo.o.bhj();
      localObject3 = t.Qw(paramca.field_imgPath);
      localObject1 = localObject3;
      if (paramca.field_isSend == 1)
      {
        localObject1 = localObject3;
        if (params.jsx != null)
        {
          localObject1 = localObject3;
          if (!params.jsx.Mrn) {}
        }
      }
    }
    for (;;)
    {
      try
      {
        String str = com.tencent.mm.vfs.s.boZ((String)localObject3);
        localObject1 = str;
        if (!str.endsWith("/")) {
          localObject1 = str + "/";
        }
        str = com.tencent.mm.vfs.s.bpb((String)localObject3);
        localObject1 = (String)localObject1 + str + "_hd.mp4";
        bool = com.tencent.mm.vfs.s.YS((String)localObject1);
        Log.i("MicroMsg.Imagegallery.handler.video", "local capture video, hdFilePath: %s, exist: %s", new Object[] { localObject1, Boolean.valueOf(bool) });
        if (!bool) {
          break label1074;
        }
      }
      catch (Exception localException)
      {
        Log.e("MicroMsg.Imagegallery.handler.video", "try to get hd filePath error: %s", new Object[] { localException.getMessage() });
        localObject2 = localObject3;
      }
      break;
      label336:
      localObject3 = amM(paramInt);
      if (localObject3 == null)
      {
        AppMethodBeat.o(36274);
        return;
      }
      int i = 0;
      if (com.tencent.mm.model.ab.Eq(params.getUser())) {
        i = com.tencent.mm.model.v.Ie(params.getUser());
      }
      boolean bool = r.Ql(localObject2);
      int j = this.Pwu.Pwv.NQ(paramca.field_msgId);
      Log.i("MicroMsg.Imagegallery.handler.video", "play video pos[%d], isOnlinePlay[%b] opcode[%d] resetByCompletion[%b]", new Object[] { Integer.valueOf(paramInt), Boolean.valueOf(paramBoolean), Integer.valueOf(j), Boolean.valueOf(this.PAn) });
      if (!bool)
      {
        if ((ae.gKE.gGR == 1) && (com.tencent.mm.pluginsdk.k.b.a.a.b(params.getFileName(), this.Pwu.Pwv.getContext(), bool)))
        {
          AppMethodBeat.o(36274);
          return;
        }
        bg.aVF();
        if ((((Integer)c.azQ().get(ar.a.NYY, Integer.valueOf(0))).intValue() == 1) && (((k)localObject3).PAQ != null))
        {
          ((k)localObject3).PAQ.setVisibility(0);
          ((k)localObject3).PAQ.setText(com.tencent.mm.plugin.sight.base.e.aFm(localObject2));
        }
        ((k)localObject3).a(params.iFw, params.iKP, i, params.getUser(), com.tencent.mm.modelvideo.s.Qn(params.bhv()), params.createTime);
        this.EtM = paramBoolean;
        this.PAi = true;
        this.filename = params.getFileName();
        if (j == 3)
        {
          ((k)localObject3).gTe().PAO.setMute(true);
          if ((((k)localObject3).gTe().PAO.getVideoPath() == null) || (!((k)localObject3).gTe().PAO.getVideoPath().equals(localObject2)) || (((k)localObject3).gTe().PAO.isPlaying()) || (this.PAn)) {
            break label822;
          }
          ((k)localObject3).d(true, 1.0F);
          ((k)localObject3).gTe().PAO.start();
          fgo();
          if (!paramBoolean) {
            bna(this.filename);
          }
          anl(((k)localObject3).gTe().PAO.getCurrentPosition() / 1000);
          fO(false);
          label740:
          b(paramInt, params);
          this.Pwu.Pwv.setVideoStateIv(false);
          this.Pwu.Pwv.getContext().getWindow().addFlags(128);
          this.pNk.a(this);
        }
      }
      for (;;)
      {
        ((k)localObject3).gTe().PAP.setVisibility(8);
        AppMethodBeat.o(36274);
        return;
        ((k)localObject3).gTe().PAO.setMute(false);
        break;
        label822:
        this.PAk = false;
        this.PAn = false;
        ((k)localObject3).gTe().PAO.setVideoPath(localObject2);
        if ((((k)localObject3).gTe().PAO instanceof VideoPlayerTextureView))
        {
          ((VideoPlayerTextureView)((k)localObject3).gTe().PAO).setIOnlineCache(this.zrF);
          ((VideoPlayerTextureView)((k)localObject3).gTe().PAO).setNeedResetExtractor(cXc());
          ((VideoPlayerTextureView)((k)localObject3).gTe().PAO).setIsOnlineVideoType(paramBoolean);
        }
        ((k)localObject3).d(true, 0.0F);
        break label740;
        com.tencent.mm.plugin.report.service.h.CyF.a(12084, new Object[] { Integer.valueOf(params.iKP), Integer.valueOf(params.iFw * 1000), Integer.valueOf(0), Integer.valueOf(3), params.getUser(), Integer.valueOf(i), com.tencent.mm.modelvideo.s.Qn(params.bhv()), Long.valueOf(params.createTime) });
        if (!com.tencent.mm.pluginsdk.k.b.a.a.c(localObject2, this.Pwu.Pwv.getContext(), bool)) {
          Toast.makeText(this.Pwu.Pwv.getContext(), this.Pwu.Pwv.getString(2131767098), 0).show();
        }
      }
      label1074:
      Object localObject2 = localObject3;
    }
  }
  
  private void a(k paramk, String paramString)
  {
    AppMethodBeat.i(36271);
    if (paramk != null)
    {
      paramk.gTe();
      paramk.gTe().PAR.setVisibility(0);
      paramk.gTe().PAS.setText(Util.nullAs(paramString, this.Pwu.Pwv.getString(2131767099)));
      paramk.gTe().PAM.setVisibility(0);
      paramk.gTe().PAN.setVisibility(8);
      c(paramk);
      AppMethodBeat.o(36271);
      return;
    }
    AppMethodBeat.o(36271);
  }
  
  private void b(int paramInt, com.tencent.mm.modelvideo.s params)
  {
    AppMethodBeat.i(36290);
    this.PAg.put(paramInt, params);
    AppMethodBeat.o(36290);
  }
  
  private void b(ca paramca, com.tencent.mm.modelvideo.s params)
  {
    AppMethodBeat.i(36276);
    Log.i("MicroMsg.Imagegallery.handler.video", "startDownloading [%d]", new Object[] { Integer.valueOf(hashCode()) });
    if ((paramca == null) || (params == null))
    {
      AppMethodBeat.o(36276);
      return;
    }
    k localk = this.Pwu.gSh();
    if (localk == null)
    {
      AppMethodBeat.o(36276);
      return;
    }
    com.tencent.mm.modelsimple.ab.ab(paramca);
    int i = this.Pwu.Pwv.NQ(paramca.field_msgId);
    Log.d("MicroMsg.Imagegallery.handler.video", "enterVideoOpCode : ".concat(String.valueOf(i)));
    switch (i)
    {
    default: 
      Log.w("MicroMsg.Imagegallery.handler.video", "enterVideoOpCode[%d] is error", new Object[] { Integer.valueOf(i) });
      AppMethodBeat.o(36276);
      return;
    case 3: 
      Log.i("MicroMsg.Imagegallery.handler.video", "%d mute play video [%d]", new Object[] { Integer.valueOf(hashCode()), Integer.valueOf(i) });
    case 0: 
      if ((this.PAh.bnc(paramca.field_imgPath)) || (this.PAh.c(paramca, params)))
      {
        Log.i("MicroMsg.Imagegallery.handler.video", "start online play video.");
        this.EtM = true;
        com.tencent.mm.modelvideo.o.bhj().a(this);
        localk.gTe().PAN.setVisibility(8);
        localk.gTe().PAP.setVisibility(8);
        localk.gTe().PAY.setVisibility(0);
        AppMethodBeat.o(36276);
        return;
      }
      Log.i("MicroMsg.Imagegallery.handler.video", "start offline play video.");
      this.EtM = false;
      com.tencent.mm.modelvideo.o.bhj().a(this, Looper.getMainLooper());
      com.tencent.mm.modelvideo.u.QI(paramca.field_imgPath);
      localk.gTe().PAN.setVisibility(8);
      localk.gTe().PAP.setVisibility(0);
      localk.gTe().PAP.setProgress(com.tencent.mm.modelvideo.u.g(params));
      AppMethodBeat.o(36276);
      return;
    }
    if (params.bhx())
    {
      Log.i("MicroMsg.Imagegallery.handler.video", "start complete online video");
      com.tencent.mm.modelvideo.u.QT(paramca.field_imgPath);
    }
    for (;;)
    {
      com.tencent.mm.modelvideo.o.bhj().a(this, Looper.getMainLooper());
      localk.gTe().PAN.setVisibility(8);
      localk.gTe().PAP.setVisibility(0);
      localk.gTe().PAP.setProgress(com.tencent.mm.modelvideo.u.g(params));
      if (i != 2) {
        break;
      }
      gTa();
      AppMethodBeat.o(36276);
      return;
      Log.i("MicroMsg.Imagegallery.handler.video", "start complete offline video");
      he(paramca.field_imgPath, 10);
      com.tencent.mm.modelvideo.u.QI(paramca.field_imgPath);
    }
    gSZ();
    AppMethodBeat.o(36276);
  }
  
  private static void b(k paramk)
  {
    AppMethodBeat.i(36272);
    if (paramk != null)
    {
      paramk.gTe();
      paramk.gTe().PAR.setVisibility(8);
      AppMethodBeat.o(36272);
      return;
    }
    AppMethodBeat.o(36272);
  }
  
  private boolean b(a parama)
  {
    AppMethodBeat.i(36278);
    if (parama == null)
    {
      AppMethodBeat.o(36278);
      return false;
    }
    com.tencent.mm.modelvideo.o.bhj().a(this);
    if (this.Pwu.Pwv.getCurrentItem() == parama.pos)
    {
      parama = amM(parama.pos);
      if (parama != null)
      {
        parama.gTe().PAY.setVisibility(8);
        parama.gTe().PAP.setVisibility(8);
        parama.gTe().PAN.setVisibility(8);
      }
      this.PAt = true;
      this.Pwu.Pwv.gSF();
      AppMethodBeat.o(36278);
      return true;
    }
    this.Pwu.amU(parama.pos);
    AppMethodBeat.o(36278);
    return false;
  }
  
  private static y br(Activity paramActivity)
  {
    AppMethodBeat.i(36264);
    byte[] arrayOfByte;
    if (PAo == null)
    {
      arrayOfByte = paramActivity.getIntent().getByteArrayExtra("img_gallery_mp_share_video_info");
      if (Util.isNullOrNil(arrayOfByte))
      {
        Log.e("MicroMsg.Imagegallery.handler.video", "initMPShareVideoInfo data is null");
        paramActivity.finish();
        AppMethodBeat.o(36264);
        return null;
      }
    }
    try
    {
      y localy = new y();
      localy.parseFrom(arrayOfByte);
      PAo = localy;
      paramActivity = PAo;
      AppMethodBeat.o(36264);
      return paramActivity;
    }
    catch (IOException localIOException)
    {
      for (;;)
      {
        Log.e("MicroMsg.Imagegallery.handler.video", "initMPShareVideoInfo ex %s", new Object[] { localIOException.getMessage() });
        paramActivity.finish();
      }
    }
  }
  
  private void c(k paramk)
  {
    AppMethodBeat.i(36280);
    Log.i("MicroMsg.Imagegallery.handler.video", "stop");
    fgc();
    if (paramk == null)
    {
      AppMethodBeat.o(36280);
      return;
    }
    fgp();
    if (this.EtM) {
      this.PAh.gTi();
    }
    if (!this.PAj) {
      com.tencent.mm.modelvideo.u.f(this.filename, this.tnc - 1000, this.EtM);
    }
    paramk.gTe().PAP.setVisibility(8);
    paramk.gTe().PAY.setVisibility(8);
    paramk.gTe().PAO.stop();
    anl(0);
    paramk.d(false, 0.0F);
    this.EtM = false;
    this.PAt = false;
    this.PAn = false;
    this.filename = null;
    this.Eub = 0;
    this.Eua = 0L;
    this.PAu = 0;
    this.PAr = 0;
    this.PAm = 0;
    this.PAl = 0;
    this.mEN = 0L;
    this.lastCheckTime = 0L;
    AppMethodBeat.o(36280);
  }
  
  public static com.tencent.mm.modelvideo.s cF(ca paramca)
  {
    AppMethodBeat.i(36263);
    if (!b.m(paramca))
    {
      AppMethodBeat.o(36263);
      return null;
    }
    paramca = com.tencent.mm.modelvideo.u.QN(paramca.field_imgPath);
    AppMethodBeat.o(36263);
    return paramca;
  }
  
  public static y cG(ca paramca)
  {
    AppMethodBeat.i(36265);
    if (paramca.gDd())
    {
      paramca = new y().a(paramca.OqD);
      AppMethodBeat.o(36265);
      return paramca;
    }
    paramca = k.b.aD(paramca.field_content, paramca.field_reserved);
    if (paramca == null)
    {
      Log.w("MicroMsg.Imagegallery.handler.video", "getVideoInfo content is null");
      AppMethodBeat.o(36265);
      return null;
    }
    paramca = (com.tencent.mm.ag.e)paramca.as(com.tencent.mm.ag.e.class);
    if ((paramca != null) && (paramca.iwi != null)) {}
    for (paramca = paramca.iwi;; paramca = null)
    {
      AppMethodBeat.o(36265);
      return paramca;
    }
  }
  
  private static com.tencent.mm.modelvideo.s cH(ca paramca)
  {
    AppMethodBeat.i(36269);
    com.tencent.mm.modelvideo.s locals = cF(paramca);
    if (locals != null)
    {
      AppMethodBeat.o(36269);
      return locals;
    }
    Log.i("MicroMsg.Imagegallery.handler.video", "insert video info:" + paramca.toString());
    locals = new com.tencent.mm.modelvideo.s();
    locals.dWq = paramca.field_talker;
    locals.fileName = paramca.field_imgPath;
    if (paramca.field_createTime <= 0L) {}
    for (long l = System.currentTimeMillis();; l = paramca.field_createTime)
    {
      locals.createTime = l;
      locals.dTS = paramca.field_msgSvrId;
      locals.jst = paramca.field_content;
      locals.jso = ((int)paramca.field_msgId);
      y localy = cG(paramca);
      if (localy != null)
      {
        if (TextUtils.isEmpty(paramca.field_imgPath))
        {
          paramca.Cz(t.Qv(paramca.field_talker));
          bg.aVF();
          c.aSQ().a(paramca.field_msgId, paramca);
        }
        locals.fileName = paramca.field_imgPath;
        m localm = m.PBF;
        locals.a(Util.nullAs(m.aiK(localy.HJ(paramca.field_imgPath)), localy.videoUrl), localy.videoDuration, localy.title, localy.KOe, "", "", "");
        locals.status = 111;
      }
      com.tencent.mm.modelvideo.o.bhj().b(locals);
      AppMethodBeat.o(36269);
      return locals;
    }
  }
  
  private boolean cXc()
  {
    AppMethodBeat.i(36307);
    if (!this.EtM)
    {
      AppMethodBeat.o(36307);
      return false;
    }
    bg.aVF();
    boolean bool = c.azQ().getBoolean(ar.a.Oaq, false);
    AppMethodBeat.o(36307);
    return bool;
  }
  
  private void d(k paramk)
  {
    AppMethodBeat.i(36281);
    if (paramk == null)
    {
      AppMethodBeat.o(36281);
      return;
    }
    releaseWakeLock();
    fgc();
    Log.d("MicroMsg.Imagegallery.handler.video", "pause video.");
    if (paramk.gTe().PAO.isPlaying())
    {
      paramk.gTe().PAO.pause();
      fgp();
    }
    AppMethodBeat.o(36281);
  }
  
  private static void e(k paramk)
  {
    AppMethodBeat.i(36283);
    if (paramk != null)
    {
      paramk.gTe();
      if (paramk.gTe().PAO.isPlaying()) {
        k.ai(paramk.gTe().PAN, 0);
      }
      AppMethodBeat.o(36283);
      return;
    }
    AppMethodBeat.o(36283);
  }
  
  public static ca f(String paramString, Activity paramActivity)
  {
    AppMethodBeat.i(36266);
    ca localca = new ca();
    localca.setType(486539313);
    localca.Cy(paramString);
    localca.OqE = true;
    localca.OqD = br(paramActivity);
    localca.Cz(paramActivity.getIntent().getStringExtra("img_gallery_path"));
    AppMethodBeat.o(36266);
    return localca;
  }
  
  private boolean f(k paramk)
  {
    AppMethodBeat.i(36304);
    int i = this.tnc;
    this.tnc = paramk.gTe().PAO.getCurrentPosition();
    int j;
    if (i != this.tnc)
    {
      this.lastCheckTime = Util.nowMilliSecond();
      long l = paramk.gTe().PAO.getLastSurfaceUpdateTime();
      if ((l > 0L) && (l != this.mEN))
      {
        this.mEN = l;
        j = this.PAl;
        switch (j)
        {
        default: 
          this.PAl = 0;
        }
      }
    }
    do
    {
      for (;;)
      {
        AppMethodBeat.o(36304);
        return true;
        i = 21;
        for (;;)
        {
          Log.w("MicroMsg.Imagegallery.handler.video", "%d rpt rptRepairEffect idKey %d errorTime %d filename %s", new Object[] { Integer.valueOf(hashCode()), Integer.valueOf(i), Integer.valueOf(j), this.filename });
          com.tencent.mm.plugin.report.service.h.CyF.idkeyStat(354L, i, 1L, false);
          com.tencent.mm.plugin.report.service.h.CyF.a(13836, new Object[] { Integer.valueOf(301), Long.valueOf(Util.nowSecond()), "" });
          break;
          i = 22;
          continue;
          i = 23;
        }
        if (this.PAl != -1)
        {
          this.PAl += 1;
          Log.w("MicroMsg.Imagegallery.handler.video", "media play is playing[%d], but surface is not update!! repair time[%d]", new Object[] { Integer.valueOf(this.PAl), Integer.valueOf(this.PAm) });
          if (this.PAm >= 2) {
            this.PAh.gTj();
          }
          switch (this.PAl)
          {
          case 0: 
          case 1: 
          default: 
            Log.w("MicroMsg.Imagegallery.handler.video", "rpt surface not update!!");
            Log.w("MicroMsg.Imagegallery.handler.video", "%d rpt rptSurfaceNotUpdate %s", new Object[] { Integer.valueOf(hashCode()), this.filename });
            com.tencent.mm.plugin.report.service.h.CyF.a(13836, new Object[] { Integer.valueOf(300), Long.valueOf(Util.nowSecond()), "" });
            com.tencent.mm.plugin.report.service.h.CyF.idkeyStat(354L, 20L, 1L, false);
            this.PAl = -1;
          }
        }
      }
      i = this.tnc / 1000;
      Log.w("MicroMsg.Imagegallery.handler.video", "surface not update, it try seek time[%d] to repair.", new Object[] { Integer.valueOf(i) });
      aT(i, true);
      this.PAm += 1;
      AppMethodBeat.o(36304);
      return false;
      j = (this.tnc - 2000) / 1000;
      i = j;
      if (j < 0) {
        i = 0;
      }
      Log.w("MicroMsg.Imagegallery.handler.video", "surface not update, it try seek time[%d] to repair.", new Object[] { Integer.valueOf(i) });
      aT(i, true);
      this.PAm += 1;
      AppMethodBeat.o(36304);
      return false;
      j = (this.tnc - 4000) / 1000;
      i = j;
      if (j < 0) {
        i = 0;
      }
      Log.w("MicroMsg.Imagegallery.handler.video", "surface not update, it try seek time[%d] to repair.", new Object[] { Integer.valueOf(i) });
      aT(i, true);
      this.PAm += 1;
      AppMethodBeat.o(36304);
      return false;
      Log.i("MicroMsg.Imagegallery.handler.video", "check time[%d, %d], play time[%d, %d]", new Object[] { Long.valueOf(this.lastCheckTime), Long.valueOf(Util.nowMilliSecond()), Integer.valueOf(i), Integer.valueOf(this.tnc) });
    } while ((this.lastCheckTime <= 0L) || (Util.milliSecondsToNow(this.lastCheckTime) < 1500L));
    Log.w("MicroMsg.Imagegallery.handler.video", "play time not update! request all video data to play. ");
    i = this.Pwu.gSh().PAO.getCurrentPosition();
    fgc();
    com.tencent.mm.modelvideo.u.f(this.filename, i, this.EtM);
    this.Pwu.gSh().PAO.stop();
    this.PAh.gTj();
    paramk = (a)this.Pyt.get(this.filename);
    if ((paramk == null) || (paramk.dCM == null))
    {
      AppMethodBeat.o(36304);
      return false;
    }
    com.tencent.mm.modelvideo.s locals = cF(paramk.dCM);
    a(paramk.dCM, locals, paramk.pos, this.EtM);
    this.lastCheckTime = 0L;
    AppMethodBeat.o(36304);
    return false;
  }
  
  private void fgc()
  {
    AppMethodBeat.i(36288);
    Log.i("MicroMsg.Imagegallery.handler.video", "clear timer");
    this.Ehq.stopTimer();
    this.qbP.stopTimer();
    AppMethodBeat.o(36288);
  }
  
  private void fgo()
  {
    AppMethodBeat.i(36300);
    this.Eua = Util.nowMilliSecond();
    Log.d("MicroMsg.Imagegallery.handler.video", "notePlayVideo filename %s notePlayVideo %d ", new Object[] { this.filename, Long.valueOf(this.Eua) });
    if ((this.Pwu != null) && (this.Pwu.Pwv != null)) {
      this.Pwu.Pwv.PyB.cB(this.Pwu.gSg());
    }
    AppMethodBeat.o(36300);
  }
  
  private void fgp()
  {
    AppMethodBeat.i(36301);
    if (this.Eua > 0L) {
      this.Eub = ((int)(this.Eub + (Util.nowMilliSecond() - this.Eua) / 1000L));
    }
    Log.i("MicroMsg.Imagegallery.handler.video", "notePauseVideo filename %s playVideoDuration %d ", new Object[] { this.filename, Integer.valueOf(this.Eub) });
    this.Eua = 0L;
    if ((this.Pwu != null) && (this.Pwu.Pwv != null)) {
      this.Pwu.Pwv.PyB.cA(this.Pwu.gSg());
    }
    AppMethodBeat.o(36301);
  }
  
  private void gSY()
  {
    AppMethodBeat.i(36293);
    try
    {
      this.Pwu.Pwv.gSr().FLz.setIplaySeekCallback(this.tni);
      AppMethodBeat.o(36293);
      return;
    }
    catch (Exception localException)
    {
      AppMethodBeat.o(36293);
    }
  }
  
  private static void gSZ()
  {
    AppMethodBeat.i(36305);
    com.tencent.mm.plugin.report.service.h.CyF.idkeyStat(354L, 11L, 1L, false);
    AppMethodBeat.o(36305);
  }
  
  private static void gTa()
  {
    AppMethodBeat.i(36306);
    com.tencent.mm.plugin.report.service.h.CyF.idkeyStat(354L, 14L, 1L, false);
    AppMethodBeat.o(36306);
  }
  
  private void he(final String paramString, final int paramInt)
  {
    AppMethodBeat.i(36277);
    bg.aAk().postToWorker(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(36253);
        com.tencent.mm.modelvideo.u.aA(paramString, paramInt);
        AppMethodBeat.o(36253);
      }
    });
    AppMethodBeat.o(36277);
  }
  
  private void releaseWakeLock()
  {
    AppMethodBeat.i(36268);
    if ((this.hCN != null) && (this.hCN.isHeld()))
    {
      Log.i("MicroMsg.Imagegallery.handler.video", "release waklock");
      this.hCN.release();
    }
    AppMethodBeat.o(36268);
  }
  
  public final void a(t.a.a parama)
  {
    AppMethodBeat.i(36292);
    Object localObject = parama.fileName;
    if ((Util.isNullOrNil((String)localObject)) || (this.Pyt == null))
    {
      AppMethodBeat.o(36292);
      return;
    }
    parama = (a)this.Pyt.get(localObject);
    if (parama == null)
    {
      AppMethodBeat.o(36292);
      return;
    }
    ca localca = parama.dCM;
    if ((localca == null) || (localca.field_imgPath == null) || (!localca.field_imgPath.equals(localObject)))
    {
      AppMethodBeat.o(36292);
      return;
    }
    localObject = cF(localca);
    if (localObject == null)
    {
      AppMethodBeat.o(36292);
      return;
    }
    if (((!localca.cWK()) && (localca.gDB())) || (((com.tencent.mm.modelvideo.s)localObject).status == 198))
    {
      if (b(parama)) {
        Toast.makeText(this.Pwu.Pwv, 2131767070, 0).show();
      }
      AppMethodBeat.o(36292);
      return;
    }
    int i = com.tencent.mm.modelvideo.u.g((com.tencent.mm.modelvideo.s)localObject);
    k localk = amM(parama.pos);
    if ((this.Pwu.Pwv.getCurrentItem() == parama.pos) && (localk != null))
    {
      localk.gTe().PAP.setVisibility(0);
      localk.gTe().PAP.setProgress(i);
    }
    while (i < localk.gTe().PAP.getMax())
    {
      AppMethodBeat.o(36292);
      return;
      if (localk == null)
      {
        AppMethodBeat.o(36292);
        return;
      }
    }
    Log.d("MicroMsg.Imagegallery.handler.video", "onNotifyChange, status:%d", new Object[] { Integer.valueOf(((com.tencent.mm.modelvideo.s)localObject).status) });
    if (((((com.tencent.mm.modelvideo.s)localObject).status == 199) || (((com.tencent.mm.modelvideo.s)localObject).status == 199)) && (b(parama))) {
      i = this.Pwu.Pwv.NQ(localca.field_msgId);
    }
    switch (i)
    {
    default: 
      Log.w("MicroMsg.Imagegallery.handler.video", "enterVideoOpCode[%d] is error", new Object[] { Integer.valueOf(i) });
      AppMethodBeat.o(36292);
      return;
    case 0: 
    case 3: 
      a(localca, (com.tencent.mm.modelvideo.s)localObject, this.Pwu.Pwv.getCurrentItem(), false);
      AppMethodBeat.o(36292);
      return;
    case 1: 
      Log.d("MicroMsg.Imagegallery.handler.video", "do restransmit video");
      com.tencent.mm.plugin.report.service.h.CyF.idkeyStat(354L, 15L, 1L, false);
      this.Pwu.ct(localca);
      this.Pwu.Pwv.NR(-1L);
      if (this.EtM)
      {
        i = this.Pwu.gSh().PAO.getCurrentPosition();
        com.tencent.mm.modelvideo.u.f(this.filename, i, this.EtM);
        this.PAn = true;
      }
      this.EtM = false;
      AppMethodBeat.o(36292);
      return;
    case 2: 
      com.tencent.mm.plugin.report.service.h.CyF.idkeyStat(354L, 16L, 1L, false);
      b.a(this.Pwu.Pwv, localca);
      this.Pwu.Pwv.NR(-1L);
      if (this.EtM)
      {
        i = this.Pwu.gSh().PAO.getCurrentPosition();
        com.tencent.mm.modelvideo.u.f(this.filename, i, this.EtM);
        this.PAn = true;
      }
      this.EtM = false;
      AppMethodBeat.o(36292);
      return;
    }
    this.Pwu.Pwv.NR(-1L);
    parama = this.Pwu.Pwv;
    Log.i("MicroMsg.ImageGalleryUI", "launchAppBrandIfNeed");
    if (parama.PzD != null)
    {
      parama = parama.PzD;
      Log.i("MicroMsg.ImageGalleryUI", "executePendingLaunchAppBrandTaskIfNeed");
      if ((parama.PAd != null) && (parama.PAe != null) && (parama.PAe.equals(parama.PzQ.Pwu.gSg())))
      {
        Log.i("MicroMsg.ImageGalleryUI", "executePendingLaunchAppBrandTask");
        com.tencent.mm.plugin.appbrand.openmaterial.j.nlj.ae(parama.PAd);
      }
      parama.PAd = null;
      parama.PAe = null;
    }
    AppMethodBeat.o(36292);
  }
  
  public final boolean a(k paramk, ca paramca, int paramInt)
  {
    AppMethodBeat.i(36262);
    super.a(paramk, paramca, paramInt);
    Object localObject1 = cH(paramca);
    if (paramca == null)
    {
      Log.e("MicroMsg.Imagegallery.handler.video", "msg is null!!");
      AppMethodBeat.o(36262);
      return false;
    }
    if (this.Pyt != null) {
      this.Pyt.put(paramca.field_imgPath, new a(paramca, paramInt));
    }
    while (localObject1 == null)
    {
      AppMethodBeat.o(36262);
      return false;
      Log.e("MicroMsg.Imagegallery.handler.video", "mCacheMap is null!");
    }
    Object localObject2;
    if (paramca.cWK())
    {
      localObject1 = cG(paramca);
      if (localObject1 != null)
      {
        localObject2 = com.tencent.mm.pluginsdk.model.s.bdu(((y)localObject1).iAo);
        com.tencent.mm.av.a.a locala = q.bcV();
        String str = ((y)localObject1).iAo;
        ImageView localImageView = paramk.gTe().PAM;
        c.a locala1 = new c.a();
        locala1.fullPath = ((String)localObject2);
        locala1.jbf = true;
        locala.a(str, localImageView, locala1.bdv());
        localObject2 = m.PBF;
        paramca = m.bnb(((y)localObject1).HJ(paramca.field_imgPath));
        if (paramca.LZv == 1) {
          a(paramk, paramca.LZw);
        }
      }
      else
      {
        if (paramk.gTe().PAO.isPlaying()) {
          paramk.gTe().PAO.stop();
        }
        if ((paramk.gTe().PAO instanceof VideoPlayerTextureView))
        {
          if (!com.tencent.mm.ui.ao.gJK()) {
            break label459;
          }
          ((VideoPlayerTextureView)paramk.gTe().PAO).setScaleType(i.e.Kcb);
        }
      }
    }
    for (;;)
    {
      paramk.PAQ.setVisibility(8);
      paramk.gTe().PAP.setVisibility(8);
      paramk.gTe().PAY.setVisibility(8);
      paramk.d(false, 0.0F);
      this.PAl = 0;
      this.EtQ = Util.nowMilliSecond();
      AppMethodBeat.o(36262);
      return true;
      b(paramk);
      break;
      localObject1 = paramk.gTe().PAM;
      Log.i("MicroMsg.Imagegallery.handler.video", "[+] [tomys] Easy crash pos, bitmap will be down sample to reduce mem cost.");
      com.tencent.mm.modelvideo.o.bhj();
      paramca = t.Qx(paramca.field_imgPath);
      localObject2 = BackwardSupportUtil.BitmapFactory.decodeFileWithMemLimit(paramca, 4194304);
      if (localObject2 != null) {
        Log.i("MicroMsg.Imagegallery.handler.video", "[+] [tomys] Bitmap decoded, file: %s, w: %s, h: %s", new Object[] { paramca, Integer.valueOf(((Bitmap)localObject2).getWidth()), Integer.valueOf(((Bitmap)localObject2).getHeight()) });
      }
      for (;;)
      {
        ((ImageView)localObject1).setImageBitmap((Bitmap)localObject2);
        b(paramk);
        break;
        Log.e("MicroMsg.Imagegallery.handler.video", "[-] [tomys] Fail to decode file: %s", new Object[] { paramca });
      }
      label459:
      ((VideoPlayerTextureView)paramk.gTe().PAO).setScaleType(i.e.KbZ);
    }
  }
  
  protected final void aT(int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(36295);
    k localk = this.Pwu.gSh();
    if (localk == null)
    {
      AppMethodBeat.o(36295);
      return;
    }
    fgo();
    localk.gTe().PAY.setVisibility(8);
    localk.gTe().PAO.d(paramInt * 1000, paramBoolean);
    this.Pwu.Pwv.setVideoStateIv(false);
    fO(false);
    AppMethodBeat.o(36295);
  }
  
  public final void aTw() {}
  
  public final void aTx() {}
  
  public final void aTy() {}
  
  public final void aTz() {}
  
  public final void ank(int paramInt)
  {
    AppMethodBeat.i(36291);
    this.PAg.remove(paramInt);
    AppMethodBeat.o(36291);
  }
  
  protected final void anl(int paramInt)
  {
    AppMethodBeat.i(36298);
    paramInt = Math.max(0, paramInt);
    this.Pwu.Pwv.gSr().FLz.seek(paramInt);
    if ((this.PAh != null) && (this.PAh.jqc > 0L)) {
      this.Pwu.Pwv.gSr().FLz.aiS((int)this.PAh.jqc);
    }
    AppMethodBeat.o(36298);
  }
  
  protected final void bgW()
  {
    AppMethodBeat.i(36296);
    k localk = this.Pwu.gSh();
    if (localk == null)
    {
      AppMethodBeat.o(36296);
      return;
    }
    Log.i("MicroMsg.Imagegallery.handler.video", "start to pause");
    this.Pwu.Pwv.setVideoStateIv(true);
    localk.gTe().PAY.setVisibility(0);
    localk.gTe().PAO.pause();
    fgp();
    AppMethodBeat.o(36296);
  }
  
  protected final void bna(String paramString)
  {
    AppMethodBeat.i(36299);
    if ((!this.PAt) && (!b((a)this.Pyt.get(paramString)))) {
      Log.w("MicroMsg.Imagegallery.handler.video", "show tool bar error.");
    }
    AppMethodBeat.o(36299);
  }
  
  protected final void cq(final String paramString, final boolean paramBoolean)
  {
    AppMethodBeat.i(36294);
    MMHandlerThread.postToMainThread(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(36248);
        Log.i("MicroMsg.Imagegallery.handler.video", "prepare video filename %s isOnlinePlay %b ", new Object[] { paramString, Boolean.valueOf(paramBoolean) });
        if (j.m(j.this) == null)
        {
          Log.w("MicroMsg.Imagegallery.handler.video", "prepare video but cache map is null.");
          AppMethodBeat.o(36248);
          return;
        }
        j.a locala = (j.a)j.m(j.this).get(paramString);
        if ((locala == null) || (locala.dCM == null))
        {
          AppMethodBeat.o(36248);
          return;
        }
        com.tencent.mm.modelvideo.s locals = j.cF(locala.dCM);
        if (j.this.Pwu.Pwv.getCurrentItem() == locala.pos)
        {
          j.a(j.this, locala.dCM, locals, locala.pos, paramBoolean);
          j.this.bna(paramString);
          AppMethodBeat.o(36248);
          return;
        }
        Log.w("MicroMsg.Imagegallery.handler.video", "playVideo, but currentItem is not correct.[%d, %d]", new Object[] { Integer.valueOf(j.this.Pwu.Pwv.getCurrentItem()), Integer.valueOf(locala.pos) });
        AppMethodBeat.o(36248);
      }
    });
    AppMethodBeat.o(36294);
  }
  
  public final void detach()
  {
    AppMethodBeat.i(36284);
    Log.i("MicroMsg.Imagegallery.handler.video", "detach.[%d]", new Object[] { Integer.valueOf(hashCode()) });
    this.EtR = Util.nowMilliSecond();
    this.PAq.removeMessages(1);
    fgc();
    EventCenter.instance.removeListener(this.PAf);
    EventCenter.instance.removeListener(this.PAs);
    stopAll();
    this.Pwu.Pwv.getContext().getWindow().clearFlags(128);
    this.Pwu.Pwv.gSr().FLz.setIplaySeekCallback(null);
    super.detach();
    this.Pyt.clear();
    this.Pyt = null;
    com.tencent.mm.modelvideo.o.bhj().a(this);
    this.PAg.clear();
    o localo = this.PAh;
    localo.reset();
    localo.Eup = null;
    localo.PBI = null;
    localo.PBJ = null;
    if (com.tencent.mm.plugin.n.f.ejc()) {
      bg.aAk().postToWorker(new j.9(this));
    }
    com.tencent.mm.modelvideo.o.bho().bhG();
    com.tencent.mm.modelvideo.o.bho().run();
    AppMethodBeat.o(36284);
  }
  
  protected final void fO(boolean paramBoolean)
  {
    AppMethodBeat.i(36289);
    if (!this.PAj)
    {
      if (this.EtM)
      {
        if (paramBoolean)
        {
          MMHandlerThread.postToMainThread(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(36257);
              for (;;)
              {
                try
                {
                  if (!Util.isNullOrNil(j.this.Pwu.gSh().gTe().PAO.getVideoPath())) {
                    continue;
                  }
                  i = com.tencent.mm.modelvideo.u.Q(j.g(j.this).jpY, j.b(j.this));
                  j.g(j.this).ub(i);
                }
                catch (Exception localException)
                {
                  int i;
                  Log.printErrStackTrace("MicroMsg.Imagegallery.handler.video", localException, "start timer error[%s]", new Object[] { localException.toString() });
                  continue;
                }
                j.n(j.this).startTimer(500L);
                AppMethodBeat.o(36257);
                return;
                i = j.this.Pwu.gSh().gTe().PAO.getCurrentPosition() / 1000;
              }
            }
          });
          AppMethodBeat.o(36289);
          return;
        }
        this.Ehq.startTimer(500L);
        AppMethodBeat.o(36289);
        return;
      }
      this.qbP.startTimer(500L);
    }
    AppMethodBeat.o(36289);
  }
  
  protected final boolean fgn()
  {
    AppMethodBeat.i(36297);
    k localk = this.Pwu.gSh();
    if (localk == null)
    {
      AppMethodBeat.o(36297);
      return false;
    }
    boolean bool = true;
    if (!localk.gTe().PAO.isPlaying())
    {
      Log.i("MicroMsg.Imagegallery.handler.video", "start to play");
      this.Pwu.Pwv.setVideoStateIv(false);
      localk.gTe().PAY.setVisibility(8);
      bool = localk.gTe().PAO.start();
      fgo();
    }
    if (localk.gTe().PAY.getVisibility() != 8) {
      localk.gTe().PAY.setVisibility(8);
    }
    AppMethodBeat.o(36297);
    return bool;
  }
  
  public final void gSW()
  {
    AppMethodBeat.i(36285);
    this.PAj = false;
    this.tnb = 0;
    if (this.Pwu != null) {}
    for (Object localObject = this.Pwu.gSh(); localObject == null; localObject = null)
    {
      Log.w("MicroMsg.Imagegallery.handler.video", "notify video prepared, but holder is null.");
      AppMethodBeat.o(36285);
      return;
    }
    final int i = Util.videoMsToSec(((k)localObject).gTe().PAO.getDuration());
    int j = this.Pwu.Pwv.gSr().FLz.getVideoTotalTime();
    Log.i("MicroMsg.Imagegallery.handler.video", "%d videoDuration %d hadSetTotalTime %d", new Object[] { Integer.valueOf(hashCode()), Integer.valueOf(i), Integer.valueOf(j) });
    if ((j <= 0) || (Math.abs(j - i) >= 2)) {
      this.Pwu.Pwv.gSr().FLz.setVideoTotalTime(i);
    }
    gSY();
    if ((i == 0) || (i >= 1800))
    {
      Log.w("MicroMsg.Imagegallery.handler.video", "%d repair video duration[%d] error. filename[%s]", new Object[] { Integer.valueOf(hashCode()), Integer.valueOf(i), this.filename });
      i = com.tencent.mm.modelvideo.u.Q(i, this.filename);
      Log.i("MicroMsg.Imagegallery.handler.video", "notify video prepared. isOnlinePlay[%b] playDuration[%d] playVideoWhenNotify[%b] hadPlayError[%b].", new Object[] { Boolean.valueOf(this.EtM), Integer.valueOf(i), Boolean.valueOf(this.PAi), Boolean.valueOf(this.PAj) });
      ((k)localObject).gTe().PAO.setOneTimeVideoTextureUpdateCallback(this.EtE);
      if (!this.PAi) {
        break label399;
      }
      if (this.EtM) {
        break label347;
      }
      this.PAh.reset();
      fgo();
      aT(i, true);
    }
    for (;;)
    {
      fO(false);
      AppMethodBeat.o(36285);
      return;
      bg.aAk().postToWorker(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(36249);
          Object localObject = j.b(j.this);
          int i = i;
          localObject = com.tencent.mm.modelvideo.u.QN((String)localObject);
          if (localObject != null)
          {
            int j = ((com.tencent.mm.modelvideo.s)localObject).iFw;
            if ((j <= 0) || (Math.abs(j - i) > 2))
            {
              ((com.tencent.mm.modelvideo.s)localObject).iFw = i;
              ((com.tencent.mm.modelvideo.s)localObject).cSx = 4096;
              Log.i("MicroMsg.VideoLogic", "repair video duration ret %b, duration[%d, %d]", new Object[] { Boolean.valueOf(com.tencent.mm.modelvideo.u.f((com.tencent.mm.modelvideo.s)localObject)), Integer.valueOf(j), Integer.valueOf(i) });
            }
          }
          AppMethodBeat.o(36249);
        }
      });
      break;
      label347:
      localObject = this.PAh;
      if (i > 0)
      {
        Log.i("MicroMsg.OnlineVideoUIHelper", "seek to last duration : ".concat(String.valueOf(i)));
        ((o)localObject).jpZ = i;
        ((o)localObject).jqb = true;
        ((o)localObject).jpW = 2;
      }
      this.PAh.ub(0);
    }
    label399:
    if (!this.EtM) {
      aT(i, false);
    }
    for (;;)
    {
      anl(i);
      this.Pwu.Pwv.setVideoStateIv(true);
      fgc();
      AppMethodBeat.o(36285);
      return;
      this.PAh.bL(i, false);
    }
  }
  
  public final void gSX()
  {
    AppMethodBeat.i(36286);
    Log.i("MicroMsg.Imagegallery.handler.video", "notify video completion. isOnlinePlay : " + this.EtM);
    fgc();
    releaseWakeLock();
    fgp();
    Object localObject1;
    if ((this.EtM) && (this.Pwu != null) && (this.Pwu.gSh() != null))
    {
      localObject1 = this.Pwu.gSh().gTe().PAO;
      if ((localObject1 != null) && (((com.tencent.mm.pluginsdk.ui.tools.j)localObject1).getCurrentPosition() + 2000 < ((com.tencent.mm.pluginsdk.ui.tools.j)localObject1).getDuration())) {
        Log.e("MicroMsg.Imagegallery.handler.video", "notify video completion, but cur pos[%d] is less than duration[%d]", new Object[] { Integer.valueOf(((com.tencent.mm.pluginsdk.ui.tools.j)localObject1).getCurrentPosition()), Integer.valueOf(((com.tencent.mm.pluginsdk.ui.tools.j)localObject1).getDuration()) });
      }
    }
    for (int i = 0;; i = 1)
    {
      if (i != 0)
      {
        MMHandlerThread.postToMainThread(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(36255);
            j.i(j.this);
            j.a(j.this, j.j(j.this));
            j.e(j.this).fp(false);
            j.k(j.this);
            if (j.d(j.this))
            {
              j.b(j.this, Util.nowMilliSecond());
              j.g(j.this).gTi();
              j.g(j.this).reset();
              j.a(j.this, false);
              j.l(j.this);
            }
            com.tencent.mm.modelvideo.u.f(j.b(j.this), 0, j.d(j.this));
            if (j.m(j.this) != null)
            {
              j.a locala = (j.a)j.m(j.this).get(j.b(j.this));
              if (locala != null)
              {
                k localk = j.this.Pwu.gSh();
                localk.gTe().PAO.stop();
                j.a(j.this, 0);
                j.this.a(localk, locala.dCM, locala.pos);
                j.this.anl(0);
                if (localk.gTe().PAY.getVisibility() != 8) {
                  localk.gTe().PAY.setVisibility(8);
                }
              }
            }
            AppMethodBeat.o(36255);
          }
        });
        AppMethodBeat.o(36286);
        return;
      }
      try
      {
        i = this.Pwu.gSh().PAO.getCurrentPosition();
        com.tencent.mm.modelvideo.u.f(this.filename, i, this.EtM);
        this.Pwu.gSh().PAO.stop();
        this.PAh.gTj();
        i = this.PAr + 1;
        this.PAr = i;
        if (i <= 3)
        {
          localObject1 = (a)this.Pyt.get(this.filename);
          if (localObject1 != null)
          {
            localObject2 = ((a)localObject1).dCM;
            if (localObject2 != null) {}
          }
          else
          {
            AppMethodBeat.o(36286);
            return;
          }
          Object localObject2 = cF(((a)localObject1).dCM);
          a(((a)localObject1).dCM, (com.tencent.mm.modelvideo.s)localObject2, ((a)localObject1).pos, this.EtM);
        }
        AppMethodBeat.o(36286);
        return;
      }
      catch (Exception localException)
      {
        Log.printErrStackTrace("MicroMsg.Imagegallery.handler.video", localException, "notify video completion error[%s]", new Object[] { localException.toString() });
        AppMethodBeat.o(36286);
        return;
      }
    }
  }
  
  public final p gSe()
  {
    AppMethodBeat.i(233453);
    Object localObject = this.Pwu.gSg();
    if (localObject == null)
    {
      Log.i("MicroMsg.Imagegallery.handler.video", "getCurResourceState, msgInfo is null");
      AppMethodBeat.o(233453);
      return null;
    }
    if ((!((ca)localObject).cWK()) && (((ca)localObject).gDB()))
    {
      Log.i("MicroMsg.Imagegallery.handler.video", "getCurResourceState, msgInfo is cleaned");
      localObject = p.PBM;
      AppMethodBeat.o(233453);
      return localObject;
    }
    localObject = cF((ca)localObject);
    if ((localObject == null) || (((com.tencent.mm.modelvideo.s)localObject).status == 198))
    {
      Log.i("MicroMsg.Imagegallery.handler.video", "getCurResourceState, videoInfo is null or failed");
      localObject = p.PBM;
      AppMethodBeat.o(233453);
      return localObject;
    }
    if (((com.tencent.mm.modelvideo.s)localObject).bhy())
    {
      Log.i("MicroMsg.Imagegallery.handler.video", "getCurResourceState, downloaded");
      localObject = p.PBO;
      AppMethodBeat.o(233453);
      return localObject;
    }
    Log.i("MicroMsg.Imagegallery.handler.video", "getCurResourceState, not downloaded");
    localObject = p.PBN;
    AppMethodBeat.o(233453);
    return localObject;
  }
  
  protected final int getPlayVideoDuration()
  {
    AppMethodBeat.i(36302);
    if (this.Eub < 0) {
      this.Eub = 0;
    }
    Log.i("MicroMsg.Imagegallery.handler.video", "get[%s] play video duration [%d]", new Object[] { this.filename, Integer.valueOf(this.Eub) });
    int i = this.Eub;
    AppMethodBeat.o(36302);
    return i;
  }
  
  protected final int getUiStayTime()
  {
    AppMethodBeat.i(36303);
    if ((this.EtR > 0L) && (this.EtQ > 0L)) {}
    for (int i = (int)(this.EtR - this.EtQ);; i = 0)
    {
      int j = i;
      if (i < 0) {
        j = 0;
      }
      Log.i("MicroMsg.Imagegallery.handler.video", "%d filename[%s] get ui stay time[%d %d %d]", new Object[] { Integer.valueOf(hashCode()), this.filename, Integer.valueOf(j), Long.valueOf(this.EtR), Long.valueOf(this.EtQ) });
      AppMethodBeat.o(36303);
      return j;
    }
  }
  
  public final void j(final ca paramca, final int paramInt)
  {
    AppMethodBeat.i(36270);
    Log.i("MicroMsg.Imagegallery.handler.video", "toggle video");
    if (paramca == null)
    {
      AppMethodBeat.o(36270);
      return;
    }
    if ((!b.m(paramca)) && (!b.cn(paramca)))
    {
      AppMethodBeat.o(36270);
      return;
    }
    final com.tencent.mm.modelvideo.s locals = cH(paramca);
    this.filename = locals.getFileName();
    if ((locals.status == 199) || (locals.status == 123)) {}
    final boolean bool2;
    Object localObject1;
    for (boolean bool1 = true;; bool1 = false)
    {
      bool2 = bool1;
      if (paramca.cWK())
      {
        Log.i("MicroMsg.Imagegallery.handler.video", "MP_VIDEO toggle mp video,status : %d", new Object[] { Integer.valueOf(locals.status) });
        com.tencent.mm.modelvideo.o.bhj();
        localObject1 = t.Qw(paramca.field_imgPath);
        bool2 = bool1;
        if (bool1)
        {
          bool2 = bool1;
          if (!com.tencent.mm.vfs.s.YS((String)localObject1))
          {
            bool2 = false;
            locals.status = 111;
            com.tencent.mm.modelvideo.o.bhj().c(locals);
            Log.i("MicroMsg.Imagegallery.handler.video", "MP_VIDEO_WARN user delete local file,reset video info status");
          }
        }
      }
      if (!paramca.cWK()) {
        break label894;
      }
      localObject1 = cG(paramca);
      if (localObject1 != null) {
        break;
      }
      Log.w("MicroMsg.Imagegallery.handler.video", "MP_VIDEO_ERROR mpShareVideoInfo is null");
      AppMethodBeat.o(36270);
      return;
    }
    Log.i("MicroMsg.Imagegallery.handler.video", "mpVideo videoDownload %b, playKey %s", new Object[] { Boolean.valueOf(bool2), ((y)localObject1).HJ(paramca.field_imgPath) });
    Object localObject2 = m.PBF;
    localObject2 = m.aiK(((y)localObject1).HJ(paramca.field_imgPath));
    Object localObject3 = m.PBF;
    localObject3 = m.bnb(((y)localObject1).HJ(paramca.field_imgPath));
    if (((crj)localObject3).LZv == 1)
    {
      Log.i("MicroMsg.Imagegallery.handler.video", "MP_VIDEO block video");
      a(amM(paramInt), ((crj)localObject3).LZw);
      AppMethodBeat.o(36270);
      return;
    }
    b(amM(paramInt));
    if ((!Util.isNullOrNil((String)localObject2)) && ((locals.iKP <= 0) || (!((String)localObject2).equals(locals.jsw.iyZ))))
    {
      Log.i("MicroMsg.Imagegallery.handler.video", "MP_VIDEO  update video info. playUrl:%s, length:%d", new Object[] { localObject2, Integer.valueOf(((crj)localObject3).Lia) });
      locals.jsw.iyZ = ((String)localObject2);
      locals.iKP = ((crj)localObject3).Lia;
      com.tencent.mm.modelvideo.o.bhj().c(locals);
    }
    localObject2 = new WeakReference(this);
    localObject3 = m.PBF;
    Object localObject4 = paramca.field_imgPath;
    localObject3 = new IPCRunCgi.a()
    {
      public final void a(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, com.tencent.mm.ak.d paramAnonymousd)
      {
        AppMethodBeat.i(36239);
        if ((paramAnonymousInt1 == 0) && (paramAnonymousInt2 == 0))
        {
          Log.i("MicroMsg.Imagegallery.handler.video", "MP_VIDEO  end do exchange video link success");
          paramAnonymousString = (bsr)paramAnonymousd.iLL.iLR;
          paramAnonymousd = m.PBF;
          m.a(this.PzY.HJ(paramca.field_imgPath), paramAnonymousString);
          if ((this.PAw.get() == null) || (j.a((j)this.PAw.get())))
          {
            AppMethodBeat.o(36239);
            return;
          }
          paramAnonymousd = (j)this.PAw.get();
          k localk = paramAnonymousd.amM(paramInt);
          if (paramAnonymousString.LZv == 1)
          {
            Log.w("MicroMsg.Imagegallery.handler.video", "doGetPlayUrl block %s", new Object[] { paramAnonymousString.LZw });
            j.a(paramAnonymousd, paramAnonymousd.amM(paramInt));
            com.tencent.mm.modelvideo.o.bhj();
            com.tencent.mm.vfs.s.deleteFile(t.Qw(paramca.field_imgPath));
            locals.status = 111;
            com.tencent.mm.modelvideo.o.bhj().c(locals);
            if (paramAnonymousd.Pwu.gSh() == localk) {
              j.a(paramAnonymousd, localk, paramAnonymousString.LZw);
            }
            AppMethodBeat.o(36239);
            return;
          }
          if (!bool2)
          {
            locals.iFw = paramAnonymousString.Lia;
            locals.jsw.iyZ = paramAnonymousString.CEI;
            com.tencent.mm.modelvideo.o.bhj().c(locals);
          }
          if ((!bool2) && (paramAnonymousd.Pwu.gSh() == localk) && (!paramAnonymousd.Pwu.Pwv.dFG())) {
            paramAnonymousd.j(paramca, paramInt);
          }
          AppMethodBeat.o(36239);
          return;
        }
        Log.w("MicroMsg.Imagegallery.handler.video", "MP_VIDEO_ERROR  end do exchange video link fail %d/%d %s", new Object[] { Integer.valueOf(paramAnonymousInt2), Integer.valueOf(paramAnonymousInt1), paramAnonymousString });
        AppMethodBeat.o(36239);
      }
    };
    kotlin.g.b.p.h(localObject1, "mPShareVideoInfo");
    kotlin.g.b.p.h(localObject4, "imgPath");
    kotlin.g.b.p.h(localObject3, "callBack");
    localObject2 = ((y)localObject1).HJ((String)localObject4);
    long l = ad.aVe().G((String)localObject2, true).Fk(m.PBB);
    int i;
    if (Math.abs(System.currentTimeMillis() - l) < 300000L)
    {
      kotlin.g.b.p.g(localObject2, "key");
      if (!Util.isNullOrNil(m.aiK((String)localObject2)))
      {
        Log.i(m.TAG, "not do cgi in 5 min");
        i = 0;
      }
    }
    while ((i != 0) && (!bool2))
    {
      paramca = amM(paramInt);
      if (paramca != null)
      {
        paramca.gTe();
        paramca.gTe().PAN.setVisibility(8);
        paramca.gTe().PAY.setVisibility(0);
      }
      AppMethodBeat.o(36270);
      return;
      if ((m.PBE.containsKey(localObject2)) && (m.PBE.get(localObject2) != null))
      {
        localObject4 = m.PBE.get(localObject2);
        if (localObject4 == null) {
          kotlin.g.b.p.hyc();
        }
        if (((Boolean)localObject4).booleanValue())
        {
          Log.w(m.TAG, (String)localObject2 + " is doing");
          i = 0;
          continue;
        }
      }
      Log.i(m.TAG, "MP_VIDEO  start do exchange video link");
      localObject4 = (Map)m.PBE;
      kotlin.g.b.p.g(localObject2, "key");
      ((Map)localObject4).put(localObject2, Boolean.TRUE);
      localObject4 = new z.f();
      ((z.f)localObject4).SYG = new WeakReference(localObject3);
      localObject3 = new bsq();
      ((bsq)localObject3).vid = ((y)localObject1).KOf;
      ((bsq)localObject3).LZt = ((y)localObject1).KOe;
      ((bsq)localObject3).LZu = ((y)localObject1).videoUrl;
      localObject1 = new com.tencent.mm.ak.d.a();
      ((com.tencent.mm.ak.d.a)localObject1).iLN = ((com.tencent.mm.bw.a)localObject3);
      ((com.tencent.mm.ak.d.a)localObject1).iLO = ((com.tencent.mm.bw.a)new bsr());
      ((com.tencent.mm.ak.d.a)localObject1).uri = "/cgi-bin/mmbiz-bin/appmsg/getplayurl";
      ((com.tencent.mm.ak.d.a)localObject1).funcId = 2962;
      ((com.tencent.mm.ak.d.a)localObject1).iLP = 0;
      ((com.tencent.mm.ak.d.a)localObject1).respCmdId = 0;
      IPCRunCgi.a(((com.tencent.mm.ak.d.a)localObject1).aXF(), (IPCRunCgi.a)new m.a((String)localObject2, (z.f)localObject4));
      i = 1;
    }
    label894:
    b(amM(paramInt));
    if ((this.EtM) && (this.PAh != null) && (this.PAh.jqb))
    {
      Log.i("MicroMsg.Imagegallery.handler.video", "%d it loading video data, do not response button click.", new Object[] { Integer.valueOf(hashCode()) });
      AppMethodBeat.o(36270);
      return;
    }
    if (this.Pwu.Pwv.dFG())
    {
      e(amM(paramInt));
      d(amM(paramInt));
      this.Pwu.Pwv.setVideoStateIv(true);
      this.Pwu.Pwv.tnh.stopTimer();
      this.pNk.fp(false);
      releaseWakeLock();
      Log.i("MicroMsg.Imagegallery.handler.video", "toggle pause video.");
      AppMethodBeat.o(36270);
      return;
    }
    bg.aVF();
    if (!c.isSDCardAvailable())
    {
      com.tencent.mm.ui.base.u.g(this.Pwu.Pwv.getContext(), null);
      AppMethodBeat.o(36270);
      return;
    }
    int j;
    if (this.EtM)
    {
      j = 0;
      i = j;
    }
    for (;;)
    {
      try
      {
        if (this.Pwu.gSh().PAO != null) {
          i = this.Pwu.gSh().PAO.getCurrentPosition() / 1000;
        }
        if (this.PAh != null) {
          if (this.PAh.uc(i))
          {
            Log.i("MicroMsg.Imagegallery.handler.video", "toggle play video");
            a(paramca, locals, paramInt, this.EtM);
            if (this.Pwu.Pwv.PzM) {
              this.Pwu.Pwv.gSQ();
            }
            gSY();
            this.hCN = ((PowerManager)MMApplicationContext.getContext().getSystemService("power")).newWakeLock(536870922, "MicroMsg.Imagegallery.handler.video");
            this.hCN.acquire();
            Log.i("MicroMsg.Imagegallery.handler.video", "acquire wakelock");
            AppMethodBeat.o(36270);
            return;
          }
        }
      }
      catch (Exception localException)
      {
        Log.printErrStackTrace("MicroMsg.Imagegallery.handler.video", localException, "", new Object[0]);
        i = j;
        continue;
        Log.i("MicroMsg.Imagegallery.handler.video", "toggle start timer.");
        fO(false);
        continue;
        Log.w("MicroMsg.Imagegallery.handler.video", "%d toggle video but online video helper is null.", new Object[] { Integer.valueOf(hashCode()) });
        continue;
      }
      if (paramca.field_isSend == 0)
      {
        if ((locals.status != 113) && (locals.status != 198)) {
          break label1412;
        }
        a(paramca, locals);
      }
      for (;;)
      {
        if (paramca.field_isSend != 1) {
          break label1513;
        }
        i = locals.status;
        if ((i != 111) && (i != 113) && (i != 112) && (i != 121) && (i != 122)) {
          break label1515;
        }
        Log.i("MicroMsg.Imagegallery.handler.video", "download video. msg talker[%s], info status[%d]", new Object[] { paramca.field_talker, Integer.valueOf(i) });
        a(paramca, locals);
        break;
        label1412:
        if (locals.status == 199) {
          a(paramca, locals, paramInt, false);
        }
        if (locals.status == 111) {
          a(paramca, locals);
        }
        if (locals.status == 112) {
          a(paramca, locals);
        }
        if ((locals.status == 121) || (locals.status == 122)) {
          a(paramca, locals);
        }
        if (locals.status == 123) {
          a(paramca, locals, paramInt, false);
        }
      }
      label1513:
      continue;
      label1515:
      a(paramca, locals, paramInt, false);
    }
  }
  
  public final void k(ca paramca, int paramInt)
  {
    AppMethodBeat.i(36273);
    Log.i("MicroMsg.Imagegallery.handler.video", "toggleVideoMenu pos ");
    com.tencent.mm.modelvideo.s locals = com.tencent.mm.modelvideo.u.QN(paramca.field_imgPath);
    if ((locals != null) && (!locals.bhy()))
    {
      d(amM(paramInt));
      this.Pwu.Pwv.setVideoStateIv(true);
      if (this.EtM)
      {
        this.PAh.gTi();
        this.PAh.reset();
      }
      a(paramca, locals);
      if (this.Pwu.Pwv.NQ(paramca.field_msgId) == 2)
      {
        he(paramca.field_imgPath, 8);
        AppMethodBeat.o(36273);
        return;
      }
      he(paramca.field_imgPath, 5);
    }
    AppMethodBeat.o(36273);
  }
  
  public final void lh(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(36287);
    boolean bool2 = this.EtM;
    Object localObject = this.PAh;
    boolean bool1;
    if ((!Util.isNullOrNil(((o)localObject).mediaId)) && (((o)localObject).jpV == 1))
    {
      bool1 = true;
      Log.e("MicroMsg.Imagegallery.handler.video", "notify video error, what %d, extras %d isOnlinePlay %b isLoading %b ", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Boolean.valueOf(bool2), Boolean.valueOf(bool1) });
      this.PAj = true;
      this.tnb = paramInt2;
      if (!this.EtM) {
        break label281;
      }
      if (paramInt1 != -1) {
        break label193;
      }
      fgc();
      this.Pwu.gSh().PAO.stop();
      this.PAh.gTj();
    }
    label193:
    do
    {
      for (;;)
      {
        this.PAt = false;
        this.Pwu.Pwv.setVideoStateIv(true);
        this.Pwu.gSh().gTe().PAY.setVisibility(0);
        fgp();
        com.tencent.mm.plugin.report.service.h.CyF.idkeyStat(354L, 18L, 1L, false);
        AppMethodBeat.o(36287);
        return;
        bool1 = false;
        break;
        if (paramInt1 != -2) {
          break label256;
        }
        fgc();
        paramInt1 = this.Pwu.gSh().PAO.getCurrentPosition();
        com.tencent.mm.modelvideo.u.f(this.filename, paramInt1, this.EtM);
        this.Pwu.gSh().PAO.stop();
        this.PAh.gTj();
      }
    } while (paramInt1 != -3);
    label256:
    this.PAj = false;
    this.PAh.gTj();
    AppMethodBeat.o(36287);
    return;
    label281:
    com.tencent.mm.modelvideo.u.QP(this.filename);
    fgp();
    if ((this.Pwu != null) && (this.Pwu.gSh() != null) && (this.Pwu.gSh().PAO != null))
    {
      localObject = this.Pwu.gSh().PAO.getVideoPath();
      this.Pwu.gSh().PAO.stop();
    }
    while (this.PAk)
    {
      Log.i("MicroMsg.Imagegallery.handler.video", "%d had play completion don't show error tips", new Object[] { Integer.valueOf(hashCode()) });
      AppMethodBeat.o(36287);
      return;
      localObject = "";
    }
    MMHandlerThread.postToMainThread(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(36256);
        if ((j.this.Pwu == null) || (j.this.Pwu.gSh() == null) || (j.m(j.this) == null))
        {
          Log.w("MicroMsg.Imagegallery.handler.video", "show error alert but adapter is null.");
          AppMethodBeat.o(36256);
          return;
        }
        j.this.Pwu.gSh().d(false, 0.0F);
        if (!Util.isNullOrNil(this.tnl)) {
          Log.e("MicroMsg.Imagegallery.handler.video", "mediaplay play video error, use third player.[%s]", new Object[] { this.tnl });
        }
        try
        {
          Object localObject2 = new Intent();
          ((Intent)localObject2).setAction("android.intent.action.VIEW");
          FileProviderHelper.setIntentDataAndType(j.this.Pwu.Pwv, (Intent)localObject2, new com.tencent.mm.vfs.o(this.tnl), "video/*", false);
          Object localObject1 = j.this.Pwu.Pwv;
          localObject2 = new com.tencent.mm.hellhoundlib.b.a().bl(localObject2);
          com.tencent.mm.hellhoundlib.a.a.a(localObject1, ((com.tencent.mm.hellhoundlib.b.a)localObject2).axQ(), "com/tencent/mm/ui/chatting/gallery/ImageGalleryVideoHandler$5", "run", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          ((ImageGalleryUI)localObject1).startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject2).pG(0));
          com.tencent.mm.hellhoundlib.a.a.a(localObject1, "com/tencent/mm/ui/chatting/gallery/ImageGalleryVideoHandler$5", "run", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          localObject1 = (j.a)j.m(j.this).get(j.b(j.this));
          if ((localObject1 == null) || (((j.a)localObject1).dCM == null))
          {
            AppMethodBeat.o(36256);
            return;
          }
        }
        catch (Exception localException)
        {
          for (;;)
          {
            Log.e("MicroMsg.Imagegallery.handler.video", "startActivity fail, activity not found");
            com.tencent.mm.ui.base.h.n(j.this.Pwu.Pwv, 2131759255, 2131759256);
          }
          j.this.ank(localException.pos);
          AppMethodBeat.o(36256);
        }
      }
    });
    com.tencent.mm.plugin.report.service.h.CyF.idkeyStat(354L, 25L, 1L, false);
    AppMethodBeat.o(36287);
  }
  
  protected final void onResume()
  {
    AppMethodBeat.i(36282);
    Log.i("MicroMsg.Imagegallery.handler.video", "ui on resume, add online video event.");
    this.PAq.removeMessages(1);
    EventCenter.instance.addListener(this.PAs);
    if ((this.Pwu != null) && (com.tencent.mm.compatible.util.d.oD(21)))
    {
      k localk = this.Pwu.gSh();
      if ((localk != null) && (localk.PAO != null))
      {
        if ((localk.PAO instanceof VideoPlayerTextureView))
        {
          ((VideoPlayerTextureView)localk.PAO).bLe();
          AppMethodBeat.o(36282);
          return;
        }
        if ((localk.PAO instanceof VideoTextureView)) {
          ((VideoTextureView)localk.PAO).bLe();
        }
      }
    }
    AppMethodBeat.o(36282);
  }
  
  public final void pause(int paramInt)
  {
    AppMethodBeat.i(36267);
    d(amM(paramInt));
    this.pNk.fp(false);
    this.Pwu.Pwv.setVideoStateIv(true);
    AppMethodBeat.o(36267);
  }
  
  public final void stopAll()
  {
    AppMethodBeat.i(36279);
    Log.i("MicroMsg.Imagegallery.handler.video", "stopAll. video handler hash code : " + hashCode());
    this.EtR = Util.nowMilliSecond();
    SparseArray localSparseArray = this.Pwu.OUA;
    int j = 0;
    int i = 0;
    if (j < localSparseArray.size())
    {
      int k = localSparseArray.keyAt(j);
      if ((localSparseArray.get(k) == null) || (((View)localSparseArray.get(k)).getTag() == null)) {
        break label253;
      }
      k localk = (k)((View)localSparseArray.get(k)).getTag();
      if ((localk.PAL == null) || (localk.gTe().PAL.getVisibility() != 0) || ((((View)localk.gTe().PAO).getVisibility() != 0) && (Util.isNullOrNil(localk.gTe().PAO.getVideoPath())) && ((!this.EtM) || (!this.PAh.isStreaming())))) {
        break label253;
      }
      c(localk);
      i = 1;
    }
    label253:
    for (;;)
    {
      j += 1;
      break;
      this.pNk.fp(false);
      if ((i == 0) && (this.EtM))
      {
        this.PAh.gTi();
        this.EtM = false;
      }
      fgc();
      this.PAg.clear();
      releaseWakeLock();
      AppMethodBeat.o(36279);
      return;
    }
  }
  
  public static final class a
  {
    public ca dCM;
    public int pos;
    
    public a(ca paramca, int paramInt)
    {
      this.dCM = paramca;
      this.pos = paramInt;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.gallery.j
 * JD-Core Version:    0.7.0.1
 */