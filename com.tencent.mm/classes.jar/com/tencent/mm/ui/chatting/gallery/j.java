package com.tencent.mm.ui.chatting.gallery;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
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
import com.tencent.mm.ah.k.b;
import com.tencent.mm.ah.y;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.b.c;
import com.tencent.mm.av.a.a.c.a;
import com.tencent.mm.av.q;
import com.tencent.mm.g.a.ny;
import com.tencent.mm.g.a.ny.a;
import com.tencent.mm.g.c.ei;
import com.tencent.mm.ipcinvoker.wx_extension.IPCRunCgi;
import com.tencent.mm.ipcinvoker.wx_extension.IPCRunCgi.a;
import com.tencent.mm.model.bc;
import com.tencent.mm.model.d.a;
import com.tencent.mm.model.x;
import com.tencent.mm.model.z;
import com.tencent.mm.model.z.b;
import com.tencent.mm.modelsimple.ab;
import com.tencent.mm.modelvideo.s;
import com.tencent.mm.modelvideo.t.a;
import com.tencent.mm.modelvideo.t.a.a;
import com.tencent.mm.modelvideo.y.a;
import com.tencent.mm.plugin.messenger.foundation.a.a.i;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.pluginsdk.ui.i.e;
import com.tencent.mm.pluginsdk.ui.tools.RedesignVideoPlayerSeekBar;
import com.tencent.mm.pluginsdk.ui.tools.VideoPlayerTextureView;
import com.tencent.mm.pluginsdk.ui.tools.VideoTextureView;
import com.tencent.mm.pluginsdk.ui.tools.h.e;
import com.tencent.mm.protocal.protobuf.bgu;
import com.tencent.mm.protocal.protobuf.bgv;
import com.tencent.mm.protocal.protobuf.byg;
import com.tencent.mm.protocal.protobuf.cch;
import com.tencent.mm.protocal.protobuf.dld;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.b;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.aq.a;
import com.tencent.mm.sdk.platformtools.ar;
import com.tencent.mm.sdk.platformtools.aw;
import com.tencent.mm.sdk.platformtools.aw.a;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.storage.aj;
import com.tencent.mm.storage.am.a;
import com.tencent.mm.storage.bv;
import com.tencent.mm.ui.chatting.al.a;
import com.tencent.mm.ui.widget.MMPinProgressBtn;
import d.g.b.p;
import d.g.b.y.f;
import java.io.IOException;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;

public final class j
  extends a
  implements d.a, t.a
{
  private static y Kol = null;
  public static boolean Kom = false;
  private h.e AkS;
  private boolean Ala;
  private long Ale;
  private long Alf;
  private long Alp;
  private int Alq;
  private HashMap<String, a> Kmw;
  private com.tencent.mm.sdk.b.c Koc;
  final SparseArray<s> Kod;
  private o Koe;
  private boolean Kof;
  private boolean Kog;
  private boolean Koh;
  private int Koi;
  private int Koj;
  private boolean Kok;
  aq Kon;
  private int Koo;
  private com.tencent.mm.sdk.b.c<ny> Kop;
  private boolean Koq;
  private int Kor;
  private int[] Kos;
  private String filename;
  private PowerManager.WakeLock gNb;
  private long lastCheckTime;
  private long lxP;
  private aw oOb;
  private com.tencent.mm.model.d ozB;
  int rNq;
  private int rNr;
  private com.tencent.mm.plugin.sight.decode.ui.b rNx;
  private com.tencent.mm.plugin.o.b vXD;
  private aw zYZ;
  
  public j(b paramb)
  {
    super(paramb);
    AppMethodBeat.i(36261);
    this.Kod = new SparseArray();
    this.Kof = false;
    this.Kog = false;
    this.Koh = false;
    this.rNr = 0;
    this.lxP = 0L;
    this.lastCheckTime = 0L;
    this.Koi = 0;
    this.Koj = 0;
    this.Ale = 0L;
    this.Alf = 0L;
    this.rNq = 0;
    this.Kok = false;
    this.Kon = new aq(Looper.getMainLooper(), new aq.a()
    {
      public final boolean handleMessage(Message paramAnonymousMessage)
      {
        AppMethodBeat.i(36254);
        if (paramAnonymousMessage.what == 1)
        {
          paramAnonymousMessage = j.this.Kkv.fJT();
          if ((paramAnonymousMessage != null) && (!bu.isNullOrNil(j.b(j.this))))
          {
            com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.Imagegallery.handler.video", "%d ui on pause, pause video now. %s", new Object[] { Integer.valueOf(hashCode()), j.b(j.this) });
            if (!j.c(j.this)) {
              com.tencent.mm.modelvideo.u.e(j.b(j.this), paramAnonymousMessage.fKM().KoL.getCurrentPosition(), j.d(j.this));
            }
            j.g(paramAnonymousMessage);
            j.b(j.this, paramAnonymousMessage);
            j.e(j.this).ez(false);
            if (j.d(j.this))
            {
              com.tencent.mm.sdk.b.a.IvT.d(j.f(j.this));
              j.g(j.this).fKQ();
              j.a(j.this, false);
            }
          }
          j.h(j.this);
        }
        AppMethodBeat.o(36254);
        return false;
      }
    });
    this.Koo = 0;
    this.zYZ = new aw(new aw.a()
    {
      public final boolean onTimerExpired()
      {
        AppMethodBeat.i(36258);
        if (!j.g(j.this).isStreaming())
        {
          AppMethodBeat.o(36258);
          return false;
        }
        k localk = j.this.Kkv.fJT();
        if (localk == null)
        {
          AppMethodBeat.o(36258);
          return false;
        }
        if (localk.KoI == null)
        {
          AppMethodBeat.o(36258);
          return false;
        }
        if (localk.fKM().KoI.getVisibility() != 0)
        {
          AppMethodBeat.o(36258);
          return false;
        }
        boolean bool = true;
        if (localk.fKM().KoL.isPlaying()) {
          bool = j.c(j.this, localk);
        }
        if (bool)
        {
          int i = localk.fKM().KoL.getCurrentPosition() / 1000;
          bool = j.g(j.this).ql(i);
          AppMethodBeat.o(36258);
          return bool;
        }
        AppMethodBeat.o(36258);
        return false;
      }
    }, true);
    this.oOb = new aw(new aw.a()
    {
      public final boolean onTimerExpired()
      {
        AppMethodBeat.i(36259);
        if (j.this.Kkv == null)
        {
          com.tencent.mm.sdk.platformtools.ae.w("MicroMsg.Imagegallery.handler.video", "[onTimerExpired] null == adapter");
          AppMethodBeat.o(36259);
          return false;
        }
        k localk = j.this.Kkv.fJT();
        if (localk == null)
        {
          AppMethodBeat.o(36259);
          return false;
        }
        if (localk.KoI == null)
        {
          AppMethodBeat.o(36259);
          return false;
        }
        if (localk.fKM().KoI.getVisibility() != 0)
        {
          AppMethodBeat.o(36259);
          return false;
        }
        int i = j.this.Kkv.Kkw.getCurrentItem();
        if ((s)j.this.Kod.get(i) == null)
        {
          j.this.aeA(i);
          AppMethodBeat.o(36259);
          return false;
        }
        if (!localk.fKM().KoL.isPlaying())
        {
          com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.Imagegallery.handler.video", "it is not playing, stop offline timer");
          AppMethodBeat.o(36259);
          return false;
        }
        j.a(j.this, localk.fKM().KoL.getCurrentPosition());
        j.this.aeB(j.o(j.this) / 1000);
        AppMethodBeat.o(36259);
        return true;
      }
    }, true);
    this.rNx = new com.tencent.mm.plugin.sight.decode.ui.b()
    {
      public final void aqS()
      {
        AppMethodBeat.i(36244);
        if (j.this.Kkv.fJT() != null) {
          j.b(j.this, j.this.Kkv.fJT());
        }
        j.this.Kkv.Kkw.rNw.stopTimer();
        AppMethodBeat.o(36244);
      }
      
      public final void nP(int paramAnonymousInt)
      {
        AppMethodBeat.i(36245);
        localObject = null;
        try
        {
          String str = j.this.Kkv.fJT().fKM().KoL.getVideoPath();
          localObject = str;
        }
        catch (Exception localException)
        {
          for (;;)
          {
            com.tencent.mm.sdk.platformtools.ae.printErrStackTrace("MicroMsg.Imagegallery.handler.video", localException, "", new Object[0]);
            com.tencent.mm.sdk.platformtools.ae.e("MicroMsg.Imagegallery.handler.video", "on seek get video path error: " + localException.toString());
            continue;
            boolean bool = j.g(j.this).bq(paramAnonymousInt, true);
            continue;
            localObject = j.this.Kkv.fJS();
            if ((localObject != null) && (((bv)localObject).cyG())) {
              com.tencent.mm.modelvideo.u.e(((ei)localObject).field_imgPath, paramAnonymousInt * 1000, j.d(j.this));
            }
            j.this.Kkv.aeh(j.this.Kkv.Kkw.getCurrentItem());
          }
        }
        com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.Imagegallery.handler.video", "on seek to time[%d] isOnlinePlay[%b] videoPath[%s]", new Object[] { Integer.valueOf(paramAnonymousInt), Boolean.valueOf(j.d(j.this)), localObject });
        j.this.Kkv.fJT().fKM().KoK.setVisibility(8);
        if (!bu.isNullOrNil((String)localObject)) {
          if (!j.d(j.this))
          {
            j.this.aE(paramAnonymousInt, true);
            bool = true;
            if (bool) {
              j.this.eY(false);
            }
            j.this.Kkv.Kkw.fKy();
            localObject = j.this.Kkv.fJS();
            if ((localObject != null) && (((bv)localObject).cyH())) {
              j.this.Kkv.Kkw.KmD.i((bv)localObject, 13);
            }
            AppMethodBeat.o(36245);
            return;
          }
        }
      }
    };
    this.Kop = new com.tencent.mm.sdk.b.c()
    {
      private boolean a(ny paramAnonymousny)
      {
        AppMethodBeat.i(36246);
        if (!j.g(j.this).aCb(paramAnonymousny.dCP.mediaId))
        {
          AppMethodBeat.o(36246);
          return false;
        }
        if ((paramAnonymousny.dCP.retCode != 0) && (paramAnonymousny.dCP.retCode != -21006))
        {
          com.tencent.mm.sdk.platformtools.ae.w("MicroMsg.Imagegallery.handler.video", "stream download online video error. retCode: " + paramAnonymousny.dCP.retCode);
          j.a(j.this, paramAnonymousny.dCP.mediaId, paramAnonymousny.dCP.retCode);
          AppMethodBeat.o(36246);
          return false;
        }
        switch (paramAnonymousny.dCP.dto)
        {
        default: 
          com.tencent.mm.sdk.platformtools.ae.w("MicroMsg.Imagegallery.handler.video", "unknown event opcode " + paramAnonymousny.dCP.dto);
        }
        for (;;)
        {
          AppMethodBeat.o(36246);
          return false;
          o localo = j.g(j.this);
          long l2 = paramAnonymousny.dCP.offset;
          long l1 = paramAnonymousny.dCP.dCQ;
          boolean bool = paramAnonymousny.dCP.dCR;
          com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.OnlineVideoUIHelper", "deal moov ready moovPos[%d] needSeekTime[%d] timeDuration[%d] startDownload[%d %d]", new Object[] { Long.valueOf(l2), Integer.valueOf(localo.iuN), Integer.valueOf(localo.iuM), Long.valueOf(l1), Long.valueOf(localo.fLF) });
          if (localo.iuM != 0) {
            com.tencent.mm.sdk.platformtools.ae.w("MicroMsg.OnlineVideoUIHelper", "moov had callback, do nothing.");
          }
          for (;;)
          {
            j.a(j.this, true);
            break;
            if (l1 > localo.fLF) {}
            for (;;)
            {
              for (;;)
              {
                localo.fLF = l1;
                g.yxI.idkeyStat(354L, 5L, 1L, false);
                localo.AlH = bu.fpO();
                com.tencent.mm.modelvideo.o.aNh();
                paramAnonymousny = com.tencent.mm.modelvideo.t.HJ(localo.filename);
                try
                {
                  if (localo.AlD != null) {
                    break label435;
                  }
                  com.tencent.mm.sdk.platformtools.ae.w("MicroMsg.OnlineVideoUIHelper", "parser is null, thread is error.");
                }
                catch (Exception paramAnonymousny)
                {
                  com.tencent.mm.sdk.platformtools.ae.printErrStackTrace("MicroMsg.OnlineVideoUIHelper", paramAnonymousny, "", new Object[0]);
                  com.tencent.mm.sdk.platformtools.ae.e("MicroMsg.OnlineVideoUIHelper", "deal moov ready error: " + paramAnonymousny.toString());
                }
              }
              break;
              l1 = localo.fLF;
            }
            label435:
            if (localo.AlD.L(paramAnonymousny, l2))
            {
              localo.iuM = localo.AlD.iTC;
              com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.OnlineVideoUIHelper", "mp4 parse moov success. duration %d filename %s isFastStart %b", new Object[] { Integer.valueOf(localo.iuM), localo.filename, Boolean.valueOf(bool) });
              if (!bool) {
                ar.f(new o.1(localo));
              }
              if (localo.iuN == -1) {}
              for (localo.iuK = 1;; localo.iuK = 2)
              {
                g.yxI.idkeyStat(354L, 7L, 1L, false);
                break;
              }
            }
            com.tencent.mm.sdk.platformtools.ae.w("MicroMsg.OnlineVideoUIHelper", "mp4 parse moov error.");
            com.tencent.mm.modelvideo.o.aNi();
            com.tencent.mm.an.e.r(localo.mediaId, 0, -1);
            com.tencent.mm.modelvideo.u.av(localo.filename, 15);
            g.yxI.idkeyStat(354L, 8L, 1L, false);
            com.tencent.mm.sdk.platformtools.ae.w("MicroMsg.OnlineVideoUIHelper", "%d rpt parse moov fail %s ", new Object[] { Integer.valueOf(localo.hashCode()), localo.filename });
            g.yxI.f(13836, new Object[] { Integer.valueOf(302), Long.valueOf(bu.aRi()), "" });
          }
          localo = j.g(j.this);
          Object localObject = paramAnonymousny.dCP.mediaId;
          int i = paramAnonymousny.dCP.offset;
          int j = paramAnonymousny.dCP.length;
          localo.iuT = false;
          if ((i < 0) || (j < 0)) {
            com.tencent.mm.sdk.platformtools.ae.w("MicroMsg.OnlineVideoUIHelper", "deal data available error offset[%d], length[%d]", new Object[] { Integer.valueOf(i), Integer.valueOf(j) });
          }
          while (!localo.aCb((String)localObject))
          {
            if (paramAnonymousny.dCP.length <= 0) {
              break;
            }
            j.this.eY(true);
            break;
          }
          localObject = localo.mediaId + i + "_" + j;
          localObject = (Integer)localo.AlC.get(localObject);
          if ((localObject != null) && (((Integer)localObject).intValue() > 0)) {
            localo.iuQ = ((Integer)localObject).intValue();
          }
          for (;;)
          {
            com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.OnlineVideoUIHelper", "deal data available. offset[%d] length[%d] cachePlayTime[%d]", new Object[] { Integer.valueOf(i), Integer.valueOf(j), Integer.valueOf(localo.iuQ) });
            break;
            try
            {
              localo.iuQ = localo.AlD.dy(i, j);
            }
            catch (Exception localException)
            {
              com.tencent.mm.sdk.platformtools.ae.printErrStackTrace("MicroMsg.OnlineVideoUIHelper", localException, "", new Object[0]);
              com.tencent.mm.sdk.platformtools.ae.e("MicroMsg.OnlineVideoUIHelper", "deal data available file pos to video time error: " + localException.toString());
            }
          }
          j.this.eY(true);
          continue;
          paramAnonymousny = j.g(j.this);
          com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.OnlineVideoUIHelper", "deal stream finish. playStatus %d ", new Object[] { Integer.valueOf(paramAnonymousny.iuK) });
          paramAnonymousny.iuT = false;
          paramAnonymousny.iuJ = 3;
          if (paramAnonymousny.iuK == 0)
          {
            com.tencent.mm.sdk.platformtools.ae.w("MicroMsg.OnlineVideoUIHelper", "it had not moov callback and download finish start to play video.");
            paramAnonymousny.eeh();
            g.yxI.idkeyStat(354L, 6L, 1L, false);
          }
          for (;;)
          {
            paramAnonymousny.fKS();
            g.yxI.idkeyStat(354L, 26L, 1L, false);
            j.this.eY(true);
            break;
            if (paramAnonymousny.iuK == 5)
            {
              com.tencent.mm.sdk.platformtools.ae.w("MicroMsg.OnlineVideoUIHelper", "it had play error, it request all video data finish, start to play." + paramAnonymousny.mediaId);
              paramAnonymousny.eeh();
            }
          }
          localo = j.g(j.this);
          String str = paramAnonymousny.dCP.mediaId;
          i = paramAnonymousny.dCP.offset;
          if (localo.aCb(str))
          {
            if (localo.jIO != 0) {
              localo.AlF = (i * 100 / localo.jIO);
            }
            com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.OnlineVideoUIHelper", "deal progress callback. downloadedPercent : " + localo.AlF);
          }
          if (localo.AlF >= 100)
          {
            localo.iuJ = 3;
            continue;
            paramAnonymousny = j.g(j.this);
            com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.OnlineVideoUIHelper", "deal had dup video.");
            paramAnonymousny.fKS();
            paramAnonymousny.eeh();
          }
        }
      }
    };
    this.Koq = false;
    this.Kor = 0;
    this.Kos = new int[] { -1000, -2000, 3400 };
    this.AkS = new h.e()
    {
      public final void bpD()
      {
        AppMethodBeat.i(36250);
        com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.Imagegallery.handler.video", "%d on texture update.", new Object[] { Integer.valueOf(j.this.hashCode()) });
        try
        {
          j.this.Kkv.fJT().c(true, 1.0F);
          AppMethodBeat.o(36250);
          return;
        }
        catch (Exception localException)
        {
          com.tencent.mm.sdk.platformtools.ae.e("MicroMsg.Imagegallery.handler.video", "texture view update. error " + localException.toString());
          AppMethodBeat.o(36250);
        }
      }
    };
    this.vXD = new com.tencent.mm.plugin.o.b()
    {
      public final long dpl()
      {
        AppMethodBeat.i(36251);
        com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.Imagegallery.handler.video", "%d video get online cache sec", new Object[] { Integer.valueOf(j.this.hashCode()) });
        bc.aCg();
        com.tencent.mm.model.c.ajA().set(am.a.ISo, Boolean.TRUE);
        try
        {
          if ((j.d(j.this)) && (j.g(j.this) != null))
          {
            int i = j.g(j.this).iuQ;
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
    Kol = null;
    this.Kmw = new HashMap();
    this.Koe = new o(this);
    com.tencent.mm.sdk.b.a locala = com.tencent.mm.sdk.b.a.IvT;
    paramb = new com.tencent.mm.ui.chatting.al(al.a.JYZ, paramb.Kkw);
    this.Koc = paramb;
    locala.c(paramb);
    com.tencent.mm.sdk.b.a.IvT.c(this.Kop);
    this.ozB = new com.tencent.mm.model.d();
    AppMethodBeat.o(36261);
  }
  
  private void a(bv parambv, s params)
  {
    AppMethodBeat.i(36275);
    if ((!com.tencent.mm.network.ae.cR(this.Kkv.Kkw.getContext())) && (!Kom)) {
      Kom = true;
    }
    b(parambv, params);
    AppMethodBeat.o(36275);
  }
  
  private void a(bv parambv, s params, int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(36274);
    if ((parambv == null) || (params == null))
    {
      AppMethodBeat.o(36274);
      return;
    }
    if ((!parambv.cyH()) && (parambv.fvU()))
    {
      Toast.makeText(this.Kkv.Kkw, 2131764677, 0).show();
      AppMethodBeat.o(36274);
      return;
    }
    Object localObject3;
    Object localObject1;
    if (params.ixf == -1)
    {
      localObject3 = params.aNs();
      localObject1 = localObject3;
      if (!com.tencent.mm.vfs.o.fB((String)localObject3))
      {
        com.tencent.mm.modelvideo.o.aNh();
        localObject1 = com.tencent.mm.modelvideo.t.HJ(parambv.field_imgPath);
        if ((localObject1 != null) && (com.tencent.mm.vfs.o.fB((String)localObject1))) {
          break label336;
        }
        Toast.makeText(this.Kkv.Kkw, 2131764677, 0).show();
        AppMethodBeat.o(36274);
      }
    }
    else
    {
      com.tencent.mm.modelvideo.o.aNh();
      localObject3 = com.tencent.mm.modelvideo.t.HJ(parambv.field_imgPath);
      localObject1 = localObject3;
      if (parambv.field_isSend == 1)
      {
        localObject1 = localObject3;
        if (params.ixi != null)
        {
          localObject1 = localObject3;
          if (!params.ixi.Hlb) {}
        }
      }
    }
    for (;;)
    {
      try
      {
        String str = com.tencent.mm.vfs.o.aZU((String)localObject3);
        localObject1 = str;
        if (!str.endsWith("/")) {
          localObject1 = str + "/";
        }
        str = com.tencent.mm.vfs.o.aZW((String)localObject3);
        localObject1 = (String)localObject1 + str + "_hd.mp4";
        bool = com.tencent.mm.vfs.o.fB((String)localObject1);
        com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.Imagegallery.handler.video", "local capture video, hdFilePath: %s, exist: %s", new Object[] { localObject1, Boolean.valueOf(bool) });
        if (!bool) {
          break label1074;
        }
      }
      catch (Exception localException)
      {
        com.tencent.mm.sdk.platformtools.ae.e("MicroMsg.Imagegallery.handler.video", "try to get hd filePath error: %s", new Object[] { localException.getMessage() });
        localObject2 = localObject3;
      }
      break;
      label336:
      localObject3 = aeb(paramInt);
      if (localObject3 == null)
      {
        AppMethodBeat.o(36274);
        return;
      }
      int i = 0;
      if (x.wb(params.getUser())) {
        i = com.tencent.mm.model.r.zC(params.getUser());
      }
      boolean bool = com.tencent.mm.modelvideo.r.Hy(localObject2);
      int j = this.Kkv.Kkw.EL(parambv.field_msgId);
      com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.Imagegallery.handler.video", "play video pos[%d], isOnlinePlay[%b] opcode[%d] resetByCompletion[%b]", new Object[] { Integer.valueOf(paramInt), Boolean.valueOf(paramBoolean), Integer.valueOf(j), Boolean.valueOf(this.Kok) });
      if (!bool)
      {
        if ((com.tencent.mm.compatible.deviceinfo.ae.geX.gbz == 1) && (com.tencent.mm.pluginsdk.k.b.a.a.b(params.getFileName(), this.Kkv.Kkw.getContext(), bool)))
        {
          AppMethodBeat.o(36274);
          return;
        }
        bc.aCg();
        if ((((Integer)com.tencent.mm.model.c.ajA().get(am.a.IQW, Integer.valueOf(0))).intValue() == 1) && (((k)localObject3).KoN != null))
        {
          ((k)localObject3).KoN.setVisibility(0);
          ((k)localObject3).KoN.setText(com.tencent.mm.plugin.sight.base.e.arR(localObject2));
        }
        ((k)localObject3).a(params.hKI, params.hPI, i, params.getUser(), s.HA(params.aNt()), params.createTime);
        this.Ala = paramBoolean;
        this.Kof = true;
        this.filename = params.getFileName();
        if (j == 3)
        {
          ((k)localObject3).fKM().KoL.setMute(true);
          if ((((k)localObject3).fKM().KoL.getVideoPath() == null) || (!((k)localObject3).fKM().KoL.getVideoPath().equals(localObject2)) || (((k)localObject3).fKM().KoL.isPlaying()) || (this.Kok)) {
            break label822;
          }
          ((k)localObject3).c(true, 1.0F);
          ((k)localObject3).fKM().KoL.start();
          edX();
          if (!paramBoolean) {
            aXV(this.filename);
          }
          aeB(((k)localObject3).fKM().KoL.getCurrentPosition() / 1000);
          eY(false);
          label740:
          b(paramInt, params);
          this.Kkv.Kkw.setVideoStateIv(false);
          this.Kkv.Kkw.getContext().getWindow().addFlags(128);
          this.ozB.a(this);
        }
      }
      for (;;)
      {
        ((k)localObject3).fKM().KoM.setVisibility(8);
        AppMethodBeat.o(36274);
        return;
        ((k)localObject3).fKM().KoL.setMute(false);
        break;
        label822:
        this.Koh = false;
        this.Kok = false;
        ((k)localObject3).fKM().KoL.setVideoPath(localObject2);
        if ((((k)localObject3).fKM().KoL instanceof VideoPlayerTextureView))
        {
          ((VideoPlayerTextureView)((k)localObject3).fKM().KoL).setIOnlineCache(this.vXD);
          ((VideoPlayerTextureView)((k)localObject3).fKM().KoL).setNeedResetExtractor(cyZ());
          ((VideoPlayerTextureView)((k)localObject3).fKM().KoL).setIsOnlineVideoType(paramBoolean);
        }
        ((k)localObject3).c(true, 0.0F);
        break label740;
        g.yxI.f(12084, new Object[] { Integer.valueOf(params.hPI), Integer.valueOf(params.hKI * 1000), Integer.valueOf(0), Integer.valueOf(3), params.getUser(), Integer.valueOf(i), s.HA(params.aNt()), Long.valueOf(params.createTime) });
        if (!com.tencent.mm.pluginsdk.k.b.a.a.c(localObject2, this.Kkv.Kkw.getContext(), bool)) {
          Toast.makeText(this.Kkv.Kkw.getContext(), this.Kkv.Kkw.getString(2131764691), 0).show();
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
      paramk.fKM();
      paramk.fKM().KoO.setVisibility(0);
      paramk.fKM().KoP.setText(bu.bI(paramString, this.Kkv.Kkw.getString(2131764692)));
      paramk.fKM().KoJ.setVisibility(0);
      paramk.fKM().KoK.setVisibility(8);
      c(paramk);
      AppMethodBeat.o(36271);
      return;
    }
    AppMethodBeat.o(36271);
  }
  
  private void b(int paramInt, s params)
  {
    AppMethodBeat.i(36290);
    this.Kod.put(paramInt, params);
    AppMethodBeat.o(36290);
  }
  
  private void b(bv parambv, s params)
  {
    AppMethodBeat.i(36276);
    com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.Imagegallery.handler.video", "startDownloading [%d]", new Object[] { Integer.valueOf(hashCode()) });
    if ((parambv == null) || (params == null))
    {
      AppMethodBeat.o(36276);
      return;
    }
    k localk = this.Kkv.fJT();
    if (localk == null)
    {
      AppMethodBeat.o(36276);
      return;
    }
    ab.R(parambv);
    int i = this.Kkv.Kkw.EL(parambv.field_msgId);
    com.tencent.mm.sdk.platformtools.ae.d("MicroMsg.Imagegallery.handler.video", "enterVideoOpCode : ".concat(String.valueOf(i)));
    switch (i)
    {
    default: 
      com.tencent.mm.sdk.platformtools.ae.w("MicroMsg.Imagegallery.handler.video", "enterVideoOpCode[%d] is error", new Object[] { Integer.valueOf(i) });
      AppMethodBeat.o(36276);
      return;
    case 3: 
      com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.Imagegallery.handler.video", "%d mute play video [%d]", new Object[] { Integer.valueOf(hashCode()), Integer.valueOf(i) });
    case 0: 
      if ((this.Koe.aXX(parambv.field_imgPath)) || (this.Koe.c(parambv, params)))
      {
        com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.Imagegallery.handler.video", "start online play video.");
        this.Ala = true;
        com.tencent.mm.modelvideo.o.aNh().a(this);
        localk.fKM().KoK.setVisibility(8);
        localk.fKM().KoM.setVisibility(8);
        localk.fKM().KoV.setVisibility(0);
        AppMethodBeat.o(36276);
        return;
      }
      com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.Imagegallery.handler.video", "start offline play video.");
      this.Ala = false;
      com.tencent.mm.modelvideo.o.aNh().a(this, Looper.getMainLooper());
      com.tencent.mm.modelvideo.u.HV(parambv.field_imgPath);
      localk.fKM().KoK.setVisibility(8);
      localk.fKM().KoM.setVisibility(0);
      localk.fKM().KoM.setProgress(com.tencent.mm.modelvideo.u.g(params));
      AppMethodBeat.o(36276);
      return;
    }
    if (params.aNv())
    {
      com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.Imagegallery.handler.video", "start complete online video");
      com.tencent.mm.modelvideo.u.Ih(parambv.field_imgPath);
    }
    for (;;)
    {
      com.tencent.mm.modelvideo.o.aNh().a(this, Looper.getMainLooper());
      localk.fKM().KoK.setVisibility(8);
      localk.fKM().KoM.setVisibility(0);
      localk.fKM().KoM.setProgress(com.tencent.mm.modelvideo.u.g(params));
      if (i != 2) {
        break;
      }
      fKI();
      AppMethodBeat.o(36276);
      return;
      com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.Imagegallery.handler.video", "start complete offline video");
      gL(parambv.field_imgPath, 10);
      com.tencent.mm.modelvideo.u.HV(parambv.field_imgPath);
    }
    fKH();
    AppMethodBeat.o(36276);
  }
  
  private static void b(k paramk)
  {
    AppMethodBeat.i(36272);
    if (paramk != null)
    {
      paramk.fKM();
      paramk.fKM().KoO.setVisibility(8);
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
    com.tencent.mm.modelvideo.o.aNh().a(this);
    if (this.Kkv.Kkw.getCurrentItem() == parama.pos)
    {
      parama = aeb(parama.pos);
      if (parama != null)
      {
        parama.fKM().KoV.setVisibility(8);
        parama.fKM().KoM.setVisibility(8);
        parama.fKM().KoK.setVisibility(8);
      }
      this.Koq = true;
      this.Kkv.Kkw.fKn();
      AppMethodBeat.o(36278);
      return true;
    }
    this.Kkv.aej(parama.pos);
    AppMethodBeat.o(36278);
    return false;
  }
  
  private static y bl(Activity paramActivity)
  {
    AppMethodBeat.i(36264);
    byte[] arrayOfByte;
    if (Kol == null)
    {
      arrayOfByte = paramActivity.getIntent().getByteArrayExtra("img_gallery_mp_share_video_info");
      if (bu.cF(arrayOfByte))
      {
        com.tencent.mm.sdk.platformtools.ae.e("MicroMsg.Imagegallery.handler.video", "initMPShareVideoInfo data is null");
        paramActivity.finish();
        AppMethodBeat.o(36264);
        return null;
      }
    }
    try
    {
      y localy = new y();
      localy.parseFrom(arrayOfByte);
      Kol = localy;
      paramActivity = Kol;
      AppMethodBeat.o(36264);
      return paramActivity;
    }
    catch (IOException localIOException)
    {
      for (;;)
      {
        com.tencent.mm.sdk.platformtools.ae.e("MicroMsg.Imagegallery.handler.video", "initMPShareVideoInfo ex %s", new Object[] { localIOException.getMessage() });
        paramActivity.finish();
      }
    }
  }
  
  private void c(k paramk)
  {
    AppMethodBeat.i(36280);
    com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.Imagegallery.handler.video", "stop");
    edK();
    if (paramk == null)
    {
      AppMethodBeat.o(36280);
      return;
    }
    edY();
    if (this.Ala) {
      this.Koe.fKQ();
    }
    if (!this.Kog) {
      com.tencent.mm.modelvideo.u.e(this.filename, this.rNr - 1000, this.Ala);
    }
    paramk.fKM().KoM.setVisibility(8);
    paramk.fKM().KoV.setVisibility(8);
    paramk.fKM().KoL.stop();
    aeB(0);
    paramk.c(false, 0.0F);
    this.Ala = false;
    this.Koq = false;
    this.Kok = false;
    this.filename = null;
    this.Alq = 0;
    this.Alp = 0L;
    this.Kor = 0;
    this.Koo = 0;
    this.Koj = 0;
    this.Koi = 0;
    this.lxP = 0L;
    this.lastCheckTime = 0L;
    AppMethodBeat.o(36280);
  }
  
  public static s cp(bv parambv)
  {
    AppMethodBeat.i(36263);
    if (!b.m(parambv))
    {
      AppMethodBeat.o(36263);
      return null;
    }
    parambv = com.tencent.mm.modelvideo.u.Ia(parambv.field_imgPath);
    AppMethodBeat.o(36263);
    return parambv;
  }
  
  public static y cq(bv parambv)
  {
    AppMethodBeat.i(36265);
    if (parambv.fvw())
    {
      parambv = new y().a(parambv.JgM);
      AppMethodBeat.o(36265);
      return parambv;
    }
    parambv = k.b.aB(parambv.field_content, parambv.field_reserved);
    if (parambv == null)
    {
      com.tencent.mm.sdk.platformtools.ae.w("MicroMsg.Imagegallery.handler.video", "getVideoInfo content is null");
      AppMethodBeat.o(36265);
      return null;
    }
    parambv = (com.tencent.mm.ah.e)parambv.ao(com.tencent.mm.ah.e.class);
    if ((parambv != null) && (parambv.hCc != null)) {}
    for (parambv = parambv.hCc;; parambv = null)
    {
      AppMethodBeat.o(36265);
      return parambv;
    }
  }
  
  private static s cr(bv parambv)
  {
    AppMethodBeat.i(36269);
    s locals = cp(parambv);
    if (locals != null)
    {
      AppMethodBeat.o(36269);
      return locals;
    }
    com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.Imagegallery.handler.video", "insert video info:" + parambv.toString());
    locals = new s();
    locals.dED = parambv.field_talker;
    locals.fileName = parambv.field_imgPath;
    if (parambv.field_createTime <= 0L) {}
    for (long l = System.currentTimeMillis();; l = parambv.field_createTime)
    {
      locals.createTime = l;
      locals.dCd = parambv.field_msgSvrId;
      locals.ixe = parambv.field_content;
      locals.iwZ = ((int)parambv.field_msgId);
      y localy = cq(parambv);
      if (localy != null)
      {
        if (TextUtils.isEmpty(parambv.field_imgPath))
        {
          parambv.uj(com.tencent.mm.modelvideo.t.HI(parambv.field_talker));
          bc.aCg();
          com.tencent.mm.model.c.azI().a(parambv.field_msgId, parambv);
        }
        locals.fileName = parambv.field_imgPath;
        m localm = m.KpB;
        locals.a(bu.bI(m.YI(localy.zh(parambv.field_imgPath)), localy.videoUrl), localy.videoDuration, localy.title, localy.FUw, "", "", "");
        locals.status = 111;
      }
      com.tencent.mm.modelvideo.o.aNh().b(locals);
      AppMethodBeat.o(36269);
      return locals;
    }
  }
  
  private boolean cyZ()
  {
    AppMethodBeat.i(36307);
    if (!this.Ala)
    {
      AppMethodBeat.o(36307);
      return false;
    }
    bc.aCg();
    boolean bool = com.tencent.mm.model.c.ajA().getBoolean(am.a.ISo, false);
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
    edK();
    com.tencent.mm.sdk.platformtools.ae.d("MicroMsg.Imagegallery.handler.video", "pause video.");
    if (paramk.fKM().KoL.isPlaying())
    {
      paramk.fKM().KoL.pause();
      edY();
    }
    AppMethodBeat.o(36281);
  }
  
  private static void e(k paramk)
  {
    AppMethodBeat.i(36283);
    if (paramk != null)
    {
      paramk.fKM();
      if (paramk.fKM().KoL.isPlaying()) {
        k.aH(paramk.fKM().KoK, 0);
      }
      AppMethodBeat.o(36283);
      return;
    }
    AppMethodBeat.o(36283);
  }
  
  private void edK()
  {
    AppMethodBeat.i(36288);
    com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.Imagegallery.handler.video", "clear timer");
    this.zYZ.stopTimer();
    this.oOb.stopTimer();
    AppMethodBeat.o(36288);
  }
  
  private void edX()
  {
    AppMethodBeat.i(36300);
    this.Alp = bu.fpO();
    com.tencent.mm.sdk.platformtools.ae.d("MicroMsg.Imagegallery.handler.video", "notePlayVideo filename %s notePlayVideo %d ", new Object[] { this.filename, Long.valueOf(this.Alp) });
    if ((this.Kkv != null) && (this.Kkv.Kkw != null)) {
      this.Kkv.Kkw.KmD.cl(this.Kkv.fJS());
    }
    AppMethodBeat.o(36300);
  }
  
  private void edY()
  {
    AppMethodBeat.i(36301);
    if (this.Alp > 0L) {
      this.Alq = ((int)(this.Alq + (bu.fpO() - this.Alp) / 1000L));
    }
    com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.Imagegallery.handler.video", "notePauseVideo filename %s playVideoDuration %d ", new Object[] { this.filename, Integer.valueOf(this.Alq) });
    this.Alp = 0L;
    if ((this.Kkv != null) && (this.Kkv.Kkw != null)) {
      this.Kkv.Kkw.KmD.ck(this.Kkv.fJS());
    }
    AppMethodBeat.o(36301);
  }
  
  public static bv f(String paramString, Activity paramActivity)
  {
    AppMethodBeat.i(36266);
    bv localbv = new bv();
    localbv.setType(486539313);
    localbv.ui(paramString);
    localbv.JgN = true;
    localbv.JgM = bl(paramActivity);
    localbv.uj(paramActivity.getIntent().getStringExtra("img_gallery_path"));
    AppMethodBeat.o(36266);
    return localbv;
  }
  
  private boolean f(k paramk)
  {
    AppMethodBeat.i(36304);
    int i = this.rNr;
    this.rNr = paramk.fKM().KoL.getCurrentPosition();
    int j;
    if (i != this.rNr)
    {
      this.lastCheckTime = bu.fpO();
      long l = paramk.fKM().KoL.getLastSurfaceUpdateTime();
      if ((l > 0L) && (l != this.lxP))
      {
        this.lxP = l;
        j = this.Koi;
        switch (j)
        {
        default: 
          this.Koi = 0;
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
          com.tencent.mm.sdk.platformtools.ae.w("MicroMsg.Imagegallery.handler.video", "%d rpt rptRepairEffect idKey %d errorTime %d filename %s", new Object[] { Integer.valueOf(hashCode()), Integer.valueOf(i), Integer.valueOf(j), this.filename });
          g.yxI.idkeyStat(354L, i, 1L, false);
          g.yxI.f(13836, new Object[] { Integer.valueOf(301), Long.valueOf(bu.aRi()), "" });
          break;
          i = 22;
          continue;
          i = 23;
        }
        if (this.Koi != -1)
        {
          this.Koi += 1;
          com.tencent.mm.sdk.platformtools.ae.w("MicroMsg.Imagegallery.handler.video", "media play is playing[%d], but surface is not update!! repair time[%d]", new Object[] { Integer.valueOf(this.Koi), Integer.valueOf(this.Koj) });
          if (this.Koj >= 2) {
            this.Koe.fKR();
          }
          switch (this.Koi)
          {
          case 0: 
          case 1: 
          default: 
            com.tencent.mm.sdk.platformtools.ae.w("MicroMsg.Imagegallery.handler.video", "rpt surface not update!!");
            com.tencent.mm.sdk.platformtools.ae.w("MicroMsg.Imagegallery.handler.video", "%d rpt rptSurfaceNotUpdate %s", new Object[] { Integer.valueOf(hashCode()), this.filename });
            g.yxI.f(13836, new Object[] { Integer.valueOf(300), Long.valueOf(bu.aRi()), "" });
            g.yxI.idkeyStat(354L, 20L, 1L, false);
            this.Koi = -1;
          }
        }
      }
      i = this.rNr / 1000;
      com.tencent.mm.sdk.platformtools.ae.w("MicroMsg.Imagegallery.handler.video", "surface not update, it try seek time[%d] to repair.", new Object[] { Integer.valueOf(i) });
      aE(i, true);
      this.Koj += 1;
      AppMethodBeat.o(36304);
      return false;
      j = (this.rNr - 2000) / 1000;
      i = j;
      if (j < 0) {
        i = 0;
      }
      com.tencent.mm.sdk.platformtools.ae.w("MicroMsg.Imagegallery.handler.video", "surface not update, it try seek time[%d] to repair.", new Object[] { Integer.valueOf(i) });
      aE(i, true);
      this.Koj += 1;
      AppMethodBeat.o(36304);
      return false;
      j = (this.rNr - 4000) / 1000;
      i = j;
      if (j < 0) {
        i = 0;
      }
      com.tencent.mm.sdk.platformtools.ae.w("MicroMsg.Imagegallery.handler.video", "surface not update, it try seek time[%d] to repair.", new Object[] { Integer.valueOf(i) });
      aE(i, true);
      this.Koj += 1;
      AppMethodBeat.o(36304);
      return false;
      com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.Imagegallery.handler.video", "check time[%d, %d], play time[%d, %d]", new Object[] { Long.valueOf(this.lastCheckTime), Long.valueOf(bu.fpO()), Integer.valueOf(i), Integer.valueOf(this.rNr) });
    } while ((this.lastCheckTime <= 0L) || (bu.DD(this.lastCheckTime) < 1500L));
    com.tencent.mm.sdk.platformtools.ae.w("MicroMsg.Imagegallery.handler.video", "play time not update! request all video data to play. ");
    i = this.Kkv.fJT().KoL.getCurrentPosition();
    edK();
    com.tencent.mm.modelvideo.u.e(this.filename, i, this.Ala);
    this.Kkv.fJT().KoL.stop();
    this.Koe.fKR();
    paramk = (a)this.Kmw.get(this.filename);
    if ((paramk == null) || (paramk.dlw == null))
    {
      AppMethodBeat.o(36304);
      return false;
    }
    s locals = cp(paramk.dlw);
    a(paramk.dlw, locals, paramk.pos, this.Ala);
    this.lastCheckTime = 0L;
    AppMethodBeat.o(36304);
    return false;
  }
  
  private void fKG()
  {
    AppMethodBeat.i(36293);
    try
    {
      this.Kkv.Kkw.fKd().BAO.setIplaySeekCallback(this.rNx);
      AppMethodBeat.o(36293);
      return;
    }
    catch (Exception localException)
    {
      AppMethodBeat.o(36293);
    }
  }
  
  private static void fKH()
  {
    AppMethodBeat.i(36305);
    g.yxI.idkeyStat(354L, 11L, 1L, false);
    AppMethodBeat.o(36305);
  }
  
  private static void fKI()
  {
    AppMethodBeat.i(36306);
    g.yxI.idkeyStat(354L, 14L, 1L, false);
    AppMethodBeat.o(36306);
  }
  
  private void gL(final String paramString, final int paramInt)
  {
    AppMethodBeat.i(36277);
    bc.ajU().aw(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(36253);
        com.tencent.mm.modelvideo.u.aw(paramString, paramInt);
        AppMethodBeat.o(36253);
      }
    });
    AppMethodBeat.o(36277);
  }
  
  private void releaseWakeLock()
  {
    AppMethodBeat.i(36268);
    if ((this.gNb != null) && (this.gNb.isHeld()))
    {
      com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.Imagegallery.handler.video", "release waklock");
      this.gNb.release();
    }
    AppMethodBeat.o(36268);
  }
  
  public final void OA()
  {
    AppMethodBeat.i(36279);
    com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.Imagegallery.handler.video", "stopAll. video handler hash code : " + hashCode());
    this.Alf = bu.fpO();
    SparseArray localSparseArray = this.Kkv.JJH;
    int j = 0;
    int i = 0;
    if (j < localSparseArray.size())
    {
      int k = localSparseArray.keyAt(j);
      if ((localSparseArray.get(k) == null) || (((View)localSparseArray.get(k)).getTag() == null)) {
        break label253;
      }
      k localk = (k)((View)localSparseArray.get(k)).getTag();
      if ((localk.KoI == null) || (localk.fKM().KoI.getVisibility() != 0) || ((((View)localk.fKM().KoL).getVisibility() != 0) && (bu.isNullOrNil(localk.fKM().KoL.getVideoPath())) && ((!this.Ala) || (!this.Koe.isStreaming())))) {
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
      this.ozB.ez(false);
      if ((i == 0) && (this.Ala))
      {
        this.Koe.fKQ();
        this.Ala = false;
      }
      edK();
      this.Kod.clear();
      releaseWakeLock();
      AppMethodBeat.o(36279);
      return;
    }
  }
  
  public final void a(t.a.a parama)
  {
    AppMethodBeat.i(36292);
    Object localObject = parama.fileName;
    if ((bu.isNullOrNil((String)localObject)) || (this.Kmw == null))
    {
      AppMethodBeat.o(36292);
      return;
    }
    parama = (a)this.Kmw.get(localObject);
    if (parama == null)
    {
      AppMethodBeat.o(36292);
      return;
    }
    bv localbv = parama.dlw;
    if ((localbv == null) || (localbv.field_imgPath == null) || (!localbv.field_imgPath.equals(localObject)))
    {
      AppMethodBeat.o(36292);
      return;
    }
    localObject = cp(localbv);
    if (localObject == null)
    {
      AppMethodBeat.o(36292);
      return;
    }
    if (((!localbv.cyH()) && (localbv.fvU())) || (((s)localObject).status == 198))
    {
      if (b(parama)) {
        Toast.makeText(this.Kkv.Kkw, 2131764677, 0).show();
      }
      AppMethodBeat.o(36292);
      return;
    }
    int i = com.tencent.mm.modelvideo.u.g((s)localObject);
    k localk = aeb(parama.pos);
    if ((this.Kkv.Kkw.getCurrentItem() == parama.pos) && (localk != null))
    {
      localk.fKM().KoM.setVisibility(0);
      localk.fKM().KoM.setProgress(i);
    }
    while (i < localk.fKM().KoM.getMax())
    {
      AppMethodBeat.o(36292);
      return;
      if (localk == null)
      {
        AppMethodBeat.o(36292);
        return;
      }
    }
    com.tencent.mm.sdk.platformtools.ae.d("MicroMsg.Imagegallery.handler.video", "onNotifyChange, status:%d", new Object[] { Integer.valueOf(((s)localObject).status) });
    if (((((s)localObject).status == 199) || (((s)localObject).status == 199)) && (b(parama))) {
      i = this.Kkv.Kkw.EL(localbv.field_msgId);
    }
    switch (i)
    {
    default: 
      com.tencent.mm.sdk.platformtools.ae.w("MicroMsg.Imagegallery.handler.video", "enterVideoOpCode[%d] is error", new Object[] { Integer.valueOf(i) });
      AppMethodBeat.o(36292);
      return;
    case 0: 
    case 3: 
      a(localbv, (s)localObject, this.Kkv.Kkw.getCurrentItem(), false);
      AppMethodBeat.o(36292);
      return;
    case 1: 
      com.tencent.mm.sdk.platformtools.ae.d("MicroMsg.Imagegallery.handler.video", "do restransmit video");
      g.yxI.idkeyStat(354L, 15L, 1L, false);
      this.Kkv.cd(localbv);
      this.Kkv.Kkw.EM(-1L);
      if (this.Ala)
      {
        i = this.Kkv.fJT().KoL.getCurrentPosition();
        com.tencent.mm.modelvideo.u.e(this.filename, i, this.Ala);
        this.Kok = true;
      }
      this.Ala = false;
      AppMethodBeat.o(36292);
      return;
    }
    g.yxI.idkeyStat(354L, 16L, 1L, false);
    b.a(this.Kkv.Kkw, localbv);
    this.Kkv.Kkw.EM(-1L);
    if (this.Ala)
    {
      i = this.Kkv.fJT().KoL.getCurrentPosition();
      com.tencent.mm.modelvideo.u.e(this.filename, i, this.Ala);
      this.Kok = true;
    }
    this.Ala = false;
    AppMethodBeat.o(36292);
  }
  
  public final boolean a(k paramk, bv parambv, int paramInt)
  {
    AppMethodBeat.i(36262);
    super.a(paramk, parambv, paramInt);
    Object localObject1 = cr(parambv);
    if (parambv == null)
    {
      com.tencent.mm.sdk.platformtools.ae.e("MicroMsg.Imagegallery.handler.video", "msg is null!!");
      AppMethodBeat.o(36262);
      return false;
    }
    if (this.Kmw != null) {
      this.Kmw.put(parambv.field_imgPath, new a(parambv, paramInt));
    }
    while (localObject1 == null)
    {
      AppMethodBeat.o(36262);
      return false;
      com.tencent.mm.sdk.platformtools.ae.e("MicroMsg.Imagegallery.handler.video", "mCacheMap is null!");
    }
    if (parambv.cyH())
    {
      localObject1 = cq(parambv);
      if (localObject1 != null)
      {
        Object localObject2 = com.tencent.mm.pluginsdk.model.r.aMY(((y)localObject1).hGe);
        com.tencent.mm.av.a.a locala = q.aJb();
        String str = ((y)localObject1).hGe;
        ImageView localImageView = paramk.fKM().KoJ;
        c.a locala1 = new c.a();
        locala1.hgD = ((String)localObject2);
        locala1.igk = true;
        locala.a(str, localImageView, locala1.aJu());
        localObject2 = m.KpB;
        parambv = m.aXW(((y)localObject1).zh(parambv.field_imgPath));
        if (parambv.GVd == 1) {
          a(paramk, parambv.GVe);
        }
      }
      else
      {
        if (paramk.fKM().KoL.isPlaying()) {
          paramk.fKM().KoL.stop();
        }
        if ((paramk.fKM().KoL instanceof VideoPlayerTextureView))
        {
          if (!com.tencent.mm.ui.al.fBP()) {
            break label376;
          }
          ((VideoPlayerTextureView)paramk.fKM().KoL).setScaleType(i.e.Flj);
        }
      }
    }
    for (;;)
    {
      paramk.KoN.setVisibility(8);
      paramk.fKM().KoM.setVisibility(8);
      paramk.fKM().KoV.setVisibility(8);
      paramk.c(false, 0.0F);
      this.Koi = 0;
      this.Ale = bu.fpO();
      AppMethodBeat.o(36262);
      return true;
      b(paramk);
      break;
      com.tencent.mm.modelvideo.o.aNh();
      parambv = BackwardSupportUtil.b.p(com.tencent.mm.modelvideo.t.HK(parambv.field_imgPath), 1.0F);
      paramk.fKM().KoJ.setImageBitmap(parambv);
      b(paramk);
      break;
      label376:
      ((VideoPlayerTextureView)paramk.fKM().KoL).setScaleType(i.e.Flh);
    }
  }
  
  public final void aAo() {}
  
  public final void aAp() {}
  
  public final void aAq() {}
  
  public final void aAr() {}
  
  protected final void aE(int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(36295);
    k localk = this.Kkv.fJT();
    if (localk == null)
    {
      AppMethodBeat.o(36295);
      return;
    }
    edX();
    localk.fKM().KoV.setVisibility(8);
    localk.fKM().KoL.d(paramInt * 1000, paramBoolean);
    this.Kkv.Kkw.setVideoStateIv(false);
    eY(false);
    AppMethodBeat.o(36295);
  }
  
  protected final void aMU()
  {
    AppMethodBeat.i(36296);
    k localk = this.Kkv.fJT();
    if (localk == null)
    {
      AppMethodBeat.o(36296);
      return;
    }
    com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.Imagegallery.handler.video", "start to pause");
    this.Kkv.Kkw.setVideoStateIv(true);
    localk.fKM().KoV.setVisibility(0);
    localk.fKM().KoL.pause();
    edY();
    AppMethodBeat.o(36296);
  }
  
  protected final void aXV(String paramString)
  {
    AppMethodBeat.i(36299);
    if ((!this.Koq) && (!b((a)this.Kmw.get(paramString)))) {
      com.tencent.mm.sdk.platformtools.ae.w("MicroMsg.Imagegallery.handler.video", "show tool bar error.");
    }
    AppMethodBeat.o(36299);
  }
  
  public final void aeA(int paramInt)
  {
    AppMethodBeat.i(36291);
    this.Kod.remove(paramInt);
    AppMethodBeat.o(36291);
  }
  
  protected final void aeB(int paramInt)
  {
    AppMethodBeat.i(36298);
    paramInt = Math.max(0, paramInt);
    this.Kkv.Kkw.fKd().BAO.seek(paramInt);
    if ((this.Koe != null) && (this.Koe.iuQ > 0L)) {
      this.Kkv.Kkw.fKd().BAO.aac((int)this.Koe.iuQ);
    }
    AppMethodBeat.o(36298);
  }
  
  protected final void bY(final String paramString, final boolean paramBoolean)
  {
    AppMethodBeat.i(36294);
    ar.f(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(36248);
        com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.Imagegallery.handler.video", "prepare video filename %s isOnlinePlay %b ", new Object[] { paramString, Boolean.valueOf(paramBoolean) });
        if (j.m(j.this) == null)
        {
          com.tencent.mm.sdk.platformtools.ae.w("MicroMsg.Imagegallery.handler.video", "prepare video but cache map is null.");
          AppMethodBeat.o(36248);
          return;
        }
        j.a locala = (j.a)j.m(j.this).get(paramString);
        if ((locala == null) || (locala.dlw == null))
        {
          AppMethodBeat.o(36248);
          return;
        }
        s locals = j.cp(locala.dlw);
        if (j.this.Kkv.Kkw.getCurrentItem() == locala.pos)
        {
          j.a(j.this, locala.dlw, locals, locala.pos, paramBoolean);
          j.this.aXV(paramString);
          AppMethodBeat.o(36248);
          return;
        }
        com.tencent.mm.sdk.platformtools.ae.w("MicroMsg.Imagegallery.handler.video", "playVideo, but currentItem is not correct.[%d, %d]", new Object[] { Integer.valueOf(j.this.Kkv.Kkw.getCurrentItem()), Integer.valueOf(locala.pos) });
        AppMethodBeat.o(36248);
      }
    });
    AppMethodBeat.o(36294);
  }
  
  public final void detach()
  {
    AppMethodBeat.i(36284);
    com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.Imagegallery.handler.video", "detach.[%d]", new Object[] { Integer.valueOf(hashCode()) });
    this.Alf = bu.fpO();
    this.Kon.removeMessages(1);
    edK();
    com.tencent.mm.sdk.b.a.IvT.d(this.Koc);
    com.tencent.mm.sdk.b.a.IvT.d(this.Kop);
    OA();
    this.Kkv.Kkw.getContext().getWindow().clearFlags(128);
    this.Kkv.Kkw.fKd().BAO.setIplaySeekCallback(null);
    super.detach();
    this.Kmw.clear();
    this.Kmw = null;
    com.tencent.mm.modelvideo.o.aNh().a(this);
    this.Kod.clear();
    o localo = this.Koe;
    localo.reset();
    localo.AlD = null;
    localo.KpE = null;
    localo.KpF = null;
    if (com.tencent.mm.plugin.o.f.dpn()) {
      bc.ajU().aw(new j.9(this));
    }
    com.tencent.mm.modelvideo.o.aNm().aND();
    com.tencent.mm.modelvideo.o.aNm().run();
    AppMethodBeat.o(36284);
  }
  
  protected final void eY(boolean paramBoolean)
  {
    AppMethodBeat.i(36289);
    if (!this.Kog)
    {
      if (this.Ala)
      {
        if (paramBoolean)
        {
          ar.f(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(36257);
              for (;;)
              {
                try
                {
                  if (!bu.isNullOrNil(j.this.Kkv.fJT().fKM().KoL.getVideoPath())) {
                    continue;
                  }
                  i = com.tencent.mm.modelvideo.u.N(j.g(j.this).iuM, j.b(j.this));
                  j.g(j.this).ql(i);
                }
                catch (Exception localException)
                {
                  int i;
                  com.tencent.mm.sdk.platformtools.ae.printErrStackTrace("MicroMsg.Imagegallery.handler.video", localException, "start timer error[%s]", new Object[] { localException.toString() });
                  continue;
                }
                j.n(j.this).ay(500L, 500L);
                AppMethodBeat.o(36257);
                return;
                i = j.this.Kkv.fJT().fKM().KoL.getCurrentPosition() / 1000;
              }
            }
          });
          AppMethodBeat.o(36289);
          return;
        }
        this.zYZ.ay(500L, 500L);
        AppMethodBeat.o(36289);
        return;
      }
      this.oOb.ay(500L, 500L);
    }
    AppMethodBeat.o(36289);
  }
  
  protected final boolean edV()
  {
    AppMethodBeat.i(36297);
    k localk = this.Kkv.fJT();
    if (localk == null)
    {
      AppMethodBeat.o(36297);
      return false;
    }
    boolean bool = true;
    if (!localk.fKM().KoL.isPlaying())
    {
      com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.Imagegallery.handler.video", "start to play");
      this.Kkv.Kkw.setVideoStateIv(false);
      localk.fKM().KoV.setVisibility(8);
      bool = localk.fKM().KoL.start();
      edX();
    }
    if (localk.fKM().KoV.getVisibility() != 8) {
      localk.fKM().KoV.setVisibility(8);
    }
    AppMethodBeat.o(36297);
    return bool;
  }
  
  public final void fKE()
  {
    AppMethodBeat.i(36285);
    this.Kog = false;
    this.rNq = 0;
    if (this.Kkv != null) {}
    for (Object localObject = this.Kkv.fJT(); localObject == null; localObject = null)
    {
      com.tencent.mm.sdk.platformtools.ae.w("MicroMsg.Imagegallery.handler.video", "notify video prepared, but holder is null.");
      AppMethodBeat.o(36285);
      return;
    }
    final int i = bu.DE(((k)localObject).fKM().KoL.getDuration());
    int j = this.Kkv.Kkw.fKd().BAO.getVideoTotalTime();
    com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.Imagegallery.handler.video", "%d videoDuration %d hadSetTotalTime %d", new Object[] { Integer.valueOf(hashCode()), Integer.valueOf(i), Integer.valueOf(j) });
    if ((j <= 0) || (Math.abs(j - i) >= 2)) {
      this.Kkv.Kkw.fKd().BAO.setVideoTotalTime(i);
    }
    fKG();
    if ((i == 0) || (i >= 1800))
    {
      com.tencent.mm.sdk.platformtools.ae.w("MicroMsg.Imagegallery.handler.video", "%d repair video duration[%d] error. filename[%s]", new Object[] { Integer.valueOf(hashCode()), Integer.valueOf(i), this.filename });
      i = com.tencent.mm.modelvideo.u.N(i, this.filename);
      com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.Imagegallery.handler.video", "notify video prepared. isOnlinePlay[%b] playDuration[%d] playVideoWhenNotify[%b] hadPlayError[%b].", new Object[] { Boolean.valueOf(this.Ala), Integer.valueOf(i), Boolean.valueOf(this.Kof), Boolean.valueOf(this.Kog) });
      ((k)localObject).fKM().KoL.setOneTimeVideoTextureUpdateCallback(this.AkS);
      if (!this.Kof) {
        break label399;
      }
      if (this.Ala) {
        break label347;
      }
      this.Koe.reset();
      edX();
      aE(i, true);
    }
    for (;;)
    {
      eY(false);
      AppMethodBeat.o(36285);
      return;
      bc.ajU().aw(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(36249);
          Object localObject = j.b(j.this);
          int i = i;
          localObject = com.tencent.mm.modelvideo.u.Ia((String)localObject);
          if (localObject != null)
          {
            int j = ((s)localObject).hKI;
            if ((j <= 0) || (Math.abs(j - i) > 2))
            {
              ((s)localObject).hKI = i;
              ((s)localObject).dEu = 4096;
              com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.VideoLogic", "repair video duration ret %b, duration[%d, %d]", new Object[] { Boolean.valueOf(com.tencent.mm.modelvideo.u.f((s)localObject)), Integer.valueOf(j), Integer.valueOf(i) });
            }
          }
          AppMethodBeat.o(36249);
        }
      });
      break;
      label347:
      localObject = this.Koe;
      if (i > 0)
      {
        com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.OnlineVideoUIHelper", "seek to last duration : ".concat(String.valueOf(i)));
        ((o)localObject).iuN = i;
        ((o)localObject).iuP = true;
        ((o)localObject).iuK = 2;
      }
      this.Koe.ql(0);
    }
    label399:
    if (!this.Ala) {
      aE(i, false);
    }
    for (;;)
    {
      aeB(i);
      this.Kkv.Kkw.setVideoStateIv(true);
      edK();
      AppMethodBeat.o(36285);
      return;
      this.Koe.bq(i, false);
    }
  }
  
  public final void fKF()
  {
    AppMethodBeat.i(36286);
    com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.Imagegallery.handler.video", "notify video completion. isOnlinePlay : " + this.Ala);
    edK();
    releaseWakeLock();
    edY();
    Object localObject1;
    if ((this.Ala) && (this.Kkv != null) && (this.Kkv.fJT() != null))
    {
      localObject1 = this.Kkv.fJT().fKM().KoL;
      if ((localObject1 != null) && (((com.tencent.mm.pluginsdk.ui.tools.h)localObject1).getCurrentPosition() + 2000 < ((com.tencent.mm.pluginsdk.ui.tools.h)localObject1).getDuration())) {
        com.tencent.mm.sdk.platformtools.ae.e("MicroMsg.Imagegallery.handler.video", "notify video completion, but cur pos[%d] is less than duration[%d]", new Object[] { Integer.valueOf(((com.tencent.mm.pluginsdk.ui.tools.h)localObject1).getCurrentPosition()), Integer.valueOf(((com.tencent.mm.pluginsdk.ui.tools.h)localObject1).getDuration()) });
      }
    }
    for (int i = 0;; i = 1)
    {
      if (i != 0)
      {
        ar.f(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(36255);
            j.i(j.this);
            j.a(j.this, j.j(j.this));
            j.e(j.this).ez(false);
            j.k(j.this);
            if (j.d(j.this))
            {
              j.b(j.this, bu.fpO());
              j.g(j.this).fKQ();
              j.g(j.this).reset();
              j.a(j.this, false);
              j.l(j.this);
            }
            com.tencent.mm.modelvideo.u.e(j.b(j.this), 0, j.d(j.this));
            if (j.m(j.this) != null)
            {
              j.a locala = (j.a)j.m(j.this).get(j.b(j.this));
              if (locala != null)
              {
                k localk = j.this.Kkv.fJT();
                localk.fKM().KoL.stop();
                j.a(j.this, 0);
                j.this.a(localk, locala.dlw, locala.pos);
                j.this.aeB(0);
                if (localk.fKM().KoV.getVisibility() != 8) {
                  localk.fKM().KoV.setVisibility(8);
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
        i = this.Kkv.fJT().KoL.getCurrentPosition();
        com.tencent.mm.modelvideo.u.e(this.filename, i, this.Ala);
        this.Kkv.fJT().KoL.stop();
        this.Koe.fKR();
        i = this.Koo + 1;
        this.Koo = i;
        if (i <= 3)
        {
          localObject1 = (a)this.Kmw.get(this.filename);
          if (localObject1 != null)
          {
            localObject2 = ((a)localObject1).dlw;
            if (localObject2 != null) {}
          }
          else
          {
            AppMethodBeat.o(36286);
            return;
          }
          Object localObject2 = cp(((a)localObject1).dlw);
          a(((a)localObject1).dlw, (s)localObject2, ((a)localObject1).pos, this.Ala);
        }
        AppMethodBeat.o(36286);
        return;
      }
      catch (Exception localException)
      {
        com.tencent.mm.sdk.platformtools.ae.printErrStackTrace("MicroMsg.Imagegallery.handler.video", localException, "notify video completion error[%s]", new Object[] { localException.toString() });
        AppMethodBeat.o(36286);
        return;
      }
    }
  }
  
  protected final int getPlayVideoDuration()
  {
    AppMethodBeat.i(36302);
    if (this.Alq < 0) {
      this.Alq = 0;
    }
    com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.Imagegallery.handler.video", "get[%s] play video duration [%d]", new Object[] { this.filename, Integer.valueOf(this.Alq) });
    int i = this.Alq;
    AppMethodBeat.o(36302);
    return i;
  }
  
  protected final int getUiStayTime()
  {
    AppMethodBeat.i(36303);
    if ((this.Alf > 0L) && (this.Ale > 0L)) {}
    for (int i = (int)(this.Alf - this.Ale);; i = 0)
    {
      int j = i;
      if (i < 0) {
        j = 0;
      }
      com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.Imagegallery.handler.video", "%d filename[%s] get ui stay time[%d %d %d]", new Object[] { Integer.valueOf(hashCode()), this.filename, Integer.valueOf(j), Long.valueOf(this.Alf), Long.valueOf(this.Ale) });
      AppMethodBeat.o(36303);
      return j;
    }
  }
  
  public final void j(final bv parambv, final int paramInt)
  {
    AppMethodBeat.i(36270);
    com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.Imagegallery.handler.video", "toggle video");
    if (parambv == null)
    {
      AppMethodBeat.o(36270);
      return;
    }
    if ((!b.m(parambv)) && (!b.bX(parambv)))
    {
      AppMethodBeat.o(36270);
      return;
    }
    final s locals = cr(parambv);
    this.filename = locals.getFileName();
    if ((locals.status == 199) || (locals.status == 123)) {}
    final boolean bool2;
    Object localObject1;
    for (boolean bool1 = true;; bool1 = false)
    {
      bool2 = bool1;
      if (parambv.cyH())
      {
        com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.Imagegallery.handler.video", "MP_VIDEO toggle mp video,status : %d", new Object[] { Integer.valueOf(locals.status) });
        com.tencent.mm.modelvideo.o.aNh();
        localObject1 = com.tencent.mm.modelvideo.t.HJ(parambv.field_imgPath);
        bool2 = bool1;
        if (bool1)
        {
          bool2 = bool1;
          if (!com.tencent.mm.vfs.o.fB((String)localObject1))
          {
            bool2 = false;
            locals.status = 111;
            com.tencent.mm.modelvideo.o.aNh().c(locals);
            com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.Imagegallery.handler.video", "MP_VIDEO_WARN user delete local file,reset video info status");
          }
        }
      }
      if (!parambv.cyH()) {
        break label894;
      }
      localObject1 = cq(parambv);
      if (localObject1 != null) {
        break;
      }
      com.tencent.mm.sdk.platformtools.ae.w("MicroMsg.Imagegallery.handler.video", "MP_VIDEO_ERROR mpShareVideoInfo is null");
      AppMethodBeat.o(36270);
      return;
    }
    com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.Imagegallery.handler.video", "mpVideo videoDownload %b, playKey %s", new Object[] { Boolean.valueOf(bool2), ((y)localObject1).zh(parambv.field_imgPath) });
    Object localObject2 = m.KpB;
    localObject2 = m.YI(((y)localObject1).zh(parambv.field_imgPath));
    Object localObject3 = m.KpB;
    localObject3 = m.aXW(((y)localObject1).zh(parambv.field_imgPath));
    if (((cch)localObject3).GVd == 1)
    {
      com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.Imagegallery.handler.video", "MP_VIDEO block video");
      a(aeb(paramInt), ((cch)localObject3).GVe);
      AppMethodBeat.o(36270);
      return;
    }
    b(aeb(paramInt));
    if ((!bu.isNullOrNil((String)localObject2)) && ((locals.hPI <= 0) || (!((String)localObject2).equals(locals.ixh.hET))))
    {
      com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.Imagegallery.handler.video", "MP_VIDEO  update video info. playUrl:%s, length:%d", new Object[] { localObject2, Integer.valueOf(((cch)localObject3).Gnw) });
      locals.ixh.hET = ((String)localObject2);
      locals.hPI = ((cch)localObject3).Gnw;
      com.tencent.mm.modelvideo.o.aNh().c(locals);
    }
    localObject2 = new WeakReference(this);
    localObject3 = m.KpB;
    Object localObject4 = parambv.field_imgPath;
    localObject3 = new IPCRunCgi.a()
    {
      public final void a(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, com.tencent.mm.ak.b paramAnonymousb)
      {
        AppMethodBeat.i(36239);
        if ((paramAnonymousInt1 == 0) && (paramAnonymousInt2 == 0))
        {
          com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.Imagegallery.handler.video", "MP_VIDEO  end do exchange video link success");
          paramAnonymousString = (bgv)paramAnonymousb.hQE.hQJ;
          paramAnonymousb = m.KpB;
          m.a(this.KnX.zh(parambv.field_imgPath), paramAnonymousString);
          if ((this.Kot.get() == null) || (j.a((j)this.Kot.get())))
          {
            AppMethodBeat.o(36239);
            return;
          }
          paramAnonymousb = (j)this.Kot.get();
          k localk = paramAnonymousb.aeb(paramInt);
          if (paramAnonymousString.GVd == 1)
          {
            com.tencent.mm.sdk.platformtools.ae.w("MicroMsg.Imagegallery.handler.video", "doGetPlayUrl block %s", new Object[] { paramAnonymousString.GVe });
            j.a(paramAnonymousb, paramAnonymousb.aeb(paramInt));
            com.tencent.mm.modelvideo.o.aNh();
            com.tencent.mm.vfs.o.deleteFile(com.tencent.mm.modelvideo.t.HJ(parambv.field_imgPath));
            locals.status = 111;
            com.tencent.mm.modelvideo.o.aNh().c(locals);
            if (paramAnonymousb.Kkv.fJT() == localk) {
              j.a(paramAnonymousb, localk, paramAnonymousString.GVe);
            }
            AppMethodBeat.o(36239);
            return;
          }
          if (!bool2)
          {
            locals.hKI = paramAnonymousString.Gnw;
            locals.ixh.hET = paramAnonymousString.yBZ;
            com.tencent.mm.modelvideo.o.aNh().c(locals);
          }
          if ((!bool2) && (paramAnonymousb.Kkv.fJT() == localk) && (!paramAnonymousb.Kkv.Kkw.eul())) {
            paramAnonymousb.j(parambv, paramInt);
          }
          AppMethodBeat.o(36239);
          return;
        }
        com.tencent.mm.sdk.platformtools.ae.w("MicroMsg.Imagegallery.handler.video", "MP_VIDEO_ERROR  end do exchange video link fail %d/%d %s", new Object[] { Integer.valueOf(paramAnonymousInt2), Integer.valueOf(paramAnonymousInt1), paramAnonymousString });
        AppMethodBeat.o(36239);
      }
    };
    p.h(localObject1, "mPShareVideoInfo");
    p.h(localObject4, "imgPath");
    p.h(localObject3, "callBack");
    localObject2 = ((y)localObject1).zh((String)localObject4);
    long l = z.aBG().F((String)localObject2, true).wW(m.Kpx);
    int i;
    if (Math.abs(System.currentTimeMillis() - l) < 300000L)
    {
      p.g(localObject2, "key");
      if (!bu.isNullOrNil(m.YI((String)localObject2)))
      {
        com.tencent.mm.sdk.platformtools.ae.i(m.TAG, "not do cgi in 5 min");
        i = 0;
      }
    }
    while ((i != 0) && (!bool2))
    {
      parambv = aeb(paramInt);
      if (parambv != null)
      {
        parambv.fKM();
        parambv.fKM().KoK.setVisibility(8);
        parambv.fKM().KoV.setVisibility(0);
      }
      AppMethodBeat.o(36270);
      return;
      if ((m.KpA.containsKey(localObject2)) && (m.KpA.get(localObject2) != null))
      {
        localObject4 = m.KpA.get(localObject2);
        if (localObject4 == null) {
          p.gkB();
        }
        if (((Boolean)localObject4).booleanValue())
        {
          com.tencent.mm.sdk.platformtools.ae.w(m.TAG, (String)localObject2 + " is doing");
          i = 0;
          continue;
        }
      }
      com.tencent.mm.sdk.platformtools.ae.i(m.TAG, "MP_VIDEO  start do exchange video link");
      localObject4 = (Map)m.KpA;
      p.g(localObject2, "key");
      ((Map)localObject4).put(localObject2, Boolean.TRUE);
      localObject4 = new y.f();
      ((y.f)localObject4).NiY = new WeakReference(localObject3);
      localObject3 = new bgu();
      ((bgu)localObject3).hCa = ((y)localObject1).FUx;
      ((bgu)localObject3).GVb = ((y)localObject1).FUw;
      ((bgu)localObject3).GVc = ((y)localObject1).videoUrl;
      localObject1 = new b.a();
      ((b.a)localObject1).hQF = ((com.tencent.mm.bw.a)localObject3);
      ((b.a)localObject1).hQG = ((com.tencent.mm.bw.a)new bgv());
      ((b.a)localObject1).uri = "/cgi-bin/mmbiz-bin/appmsg/getplayurl";
      ((b.a)localObject1).funcId = 2962;
      ((b.a)localObject1).hQH = 0;
      ((b.a)localObject1).respCmdId = 0;
      IPCRunCgi.a(((b.a)localObject1).aDS(), (IPCRunCgi.a)new m.a((String)localObject2, (y.f)localObject4));
      i = 1;
    }
    label894:
    b(aeb(paramInt));
    if ((this.Ala) && (this.Koe != null) && (this.Koe.iuP))
    {
      com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.Imagegallery.handler.video", "%d it loading video data, do not response button click.", new Object[] { Integer.valueOf(hashCode()) });
      AppMethodBeat.o(36270);
      return;
    }
    if (this.Kkv.Kkw.eul())
    {
      e(aeb(paramInt));
      d(aeb(paramInt));
      this.Kkv.Kkw.setVideoStateIv(true);
      this.Kkv.Kkw.rNw.stopTimer();
      this.ozB.ez(false);
      releaseWakeLock();
      com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.Imagegallery.handler.video", "toggle pause video.");
      AppMethodBeat.o(36270);
      return;
    }
    bc.aCg();
    if (!com.tencent.mm.model.c.isSDCardAvailable())
    {
      com.tencent.mm.ui.base.t.g(this.Kkv.Kkw.getContext(), null);
      AppMethodBeat.o(36270);
      return;
    }
    int j;
    if (this.Ala)
    {
      j = 0;
      i = j;
    }
    for (;;)
    {
      try
      {
        if (this.Kkv.fJT().KoL != null) {
          i = this.Kkv.fJT().KoL.getCurrentPosition() / 1000;
        }
        if (this.Koe != null) {
          if (this.Koe.qm(i))
          {
            com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.Imagegallery.handler.video", "toggle play video");
            a(parambv, locals, paramInt, this.Ala);
            if (this.Kkv.Kkw.KnL) {
              this.Kkv.Kkw.fKy();
            }
            fKG();
            this.gNb = ((PowerManager)ak.getContext().getSystemService("power")).newWakeLock(536870922, "MicroMsg.Imagegallery.handler.video");
            this.gNb.acquire();
            com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.Imagegallery.handler.video", "acquire wakelock");
            AppMethodBeat.o(36270);
            return;
          }
        }
      }
      catch (Exception localException)
      {
        com.tencent.mm.sdk.platformtools.ae.printErrStackTrace("MicroMsg.Imagegallery.handler.video", localException, "", new Object[0]);
        i = j;
        continue;
        com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.Imagegallery.handler.video", "toggle start timer.");
        eY(false);
        continue;
        com.tencent.mm.sdk.platformtools.ae.w("MicroMsg.Imagegallery.handler.video", "%d toggle video but online video helper is null.", new Object[] { Integer.valueOf(hashCode()) });
        continue;
      }
      if (parambv.field_isSend == 0)
      {
        if ((locals.status != 113) && (locals.status != 198)) {
          break label1412;
        }
        a(parambv, locals);
      }
      for (;;)
      {
        if (parambv.field_isSend != 1) {
          break label1513;
        }
        i = locals.status;
        if ((i != 111) && (i != 113) && (i != 112) && (i != 121) && (i != 122)) {
          break label1515;
        }
        com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.Imagegallery.handler.video", "download video. msg talker[%s], info status[%d]", new Object[] { parambv.field_talker, Integer.valueOf(i) });
        a(parambv, locals);
        break;
        label1412:
        if (locals.status == 199) {
          a(parambv, locals, paramInt, false);
        }
        if (locals.status == 111) {
          a(parambv, locals);
        }
        if (locals.status == 112) {
          a(parambv, locals);
        }
        if ((locals.status == 121) || (locals.status == 122)) {
          a(parambv, locals);
        }
        if (locals.status == 123) {
          a(parambv, locals, paramInt, false);
        }
      }
      label1513:
      continue;
      label1515:
      a(parambv, locals, paramInt, false);
    }
  }
  
  public final void jW(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(36287);
    boolean bool2 = this.Ala;
    Object localObject = this.Koe;
    boolean bool1;
    if ((!bu.isNullOrNil(((o)localObject).mediaId)) && (((o)localObject).iuJ == 1))
    {
      bool1 = true;
      com.tencent.mm.sdk.platformtools.ae.e("MicroMsg.Imagegallery.handler.video", "notify video error, what %d, extras %d isOnlinePlay %b isLoading %b ", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Boolean.valueOf(bool2), Boolean.valueOf(bool1) });
      this.Kog = true;
      this.rNq = paramInt2;
      if (!this.Ala) {
        break label281;
      }
      if (paramInt1 != -1) {
        break label193;
      }
      edK();
      this.Kkv.fJT().KoL.stop();
      this.Koe.fKR();
    }
    label193:
    do
    {
      for (;;)
      {
        this.Koq = false;
        this.Kkv.Kkw.setVideoStateIv(true);
        this.Kkv.fJT().fKM().KoV.setVisibility(0);
        edY();
        g.yxI.idkeyStat(354L, 18L, 1L, false);
        AppMethodBeat.o(36287);
        return;
        bool1 = false;
        break;
        if (paramInt1 != -2) {
          break label256;
        }
        edK();
        paramInt1 = this.Kkv.fJT().KoL.getCurrentPosition();
        com.tencent.mm.modelvideo.u.e(this.filename, paramInt1, this.Ala);
        this.Kkv.fJT().KoL.stop();
        this.Koe.fKR();
      }
    } while (paramInt1 != -3);
    label256:
    this.Kog = false;
    this.Koe.fKR();
    AppMethodBeat.o(36287);
    return;
    label281:
    com.tencent.mm.modelvideo.u.Id(this.filename);
    edY();
    if ((this.Kkv != null) && (this.Kkv.fJT() != null) && (this.Kkv.fJT().KoL != null))
    {
      localObject = this.Kkv.fJT().KoL.getVideoPath();
      this.Kkv.fJT().KoL.stop();
    }
    while (this.Koh)
    {
      com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.Imagegallery.handler.video", "%d had play completion don't show error tips", new Object[] { Integer.valueOf(hashCode()) });
      AppMethodBeat.o(36287);
      return;
      localObject = "";
    }
    ar.f(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(36256);
        if ((j.this.Kkv == null) || (j.this.Kkv.fJT() == null) || (j.m(j.this) == null))
        {
          com.tencent.mm.sdk.platformtools.ae.w("MicroMsg.Imagegallery.handler.video", "show error alert but adapter is null.");
          AppMethodBeat.o(36256);
          return;
        }
        j.this.Kkv.fJT().c(false, 0.0F);
        if (!bu.isNullOrNil(this.rNA)) {
          com.tencent.mm.sdk.platformtools.ae.e("MicroMsg.Imagegallery.handler.video", "mediaplay play video error, use third player.[%s]", new Object[] { this.rNA });
        }
        try
        {
          Object localObject2 = new Intent();
          ((Intent)localObject2).setAction("android.intent.action.VIEW");
          com.tencent.mm.sdk.platformtools.o.a(j.this.Kkv.Kkw, (Intent)localObject2, new com.tencent.mm.vfs.k(this.rNA), "video/*");
          Object localObject1 = j.this.Kkv.Kkw;
          localObject2 = new com.tencent.mm.hellhoundlib.b.a().bc(localObject2);
          com.tencent.mm.hellhoundlib.a.a.a(localObject1, ((com.tencent.mm.hellhoundlib.b.a)localObject2).ahE(), "com/tencent/mm/ui/chatting/gallery/ImageGalleryVideoHandler$5", "run", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          ((ImageGalleryUI)localObject1).startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject2).mt(0));
          com.tencent.mm.hellhoundlib.a.a.a(localObject1, "com/tencent/mm/ui/chatting/gallery/ImageGalleryVideoHandler$5", "run", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          localObject1 = (j.a)j.m(j.this).get(j.b(j.this));
          if ((localObject1 == null) || (((j.a)localObject1).dlw == null))
          {
            AppMethodBeat.o(36256);
            return;
          }
        }
        catch (Exception localException)
        {
          for (;;)
          {
            com.tencent.mm.sdk.platformtools.ae.e("MicroMsg.Imagegallery.handler.video", "startActivity fail, activity not found");
            com.tencent.mm.ui.base.h.l(j.this.Kkv.Kkw, 2131758931, 2131758932);
          }
          j.this.aeA(localException.pos);
          AppMethodBeat.o(36256);
        }
      }
    });
    g.yxI.idkeyStat(354L, 25L, 1L, false);
    AppMethodBeat.o(36287);
  }
  
  public final void k(bv parambv, int paramInt)
  {
    AppMethodBeat.i(36273);
    com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.Imagegallery.handler.video", "toggleVideoMenu pos ");
    s locals = com.tencent.mm.modelvideo.u.Ia(parambv.field_imgPath);
    if ((locals != null) && (!locals.aNw()))
    {
      d(aeb(paramInt));
      this.Kkv.Kkw.setVideoStateIv(true);
      if (this.Ala)
      {
        this.Koe.fKQ();
        this.Koe.reset();
      }
      a(parambv, locals);
      if (this.Kkv.Kkw.EL(parambv.field_msgId) == 2)
      {
        gL(parambv.field_imgPath, 8);
        AppMethodBeat.o(36273);
        return;
      }
      gL(parambv.field_imgPath, 5);
    }
    AppMethodBeat.o(36273);
  }
  
  protected final void onResume()
  {
    AppMethodBeat.i(36282);
    com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.Imagegallery.handler.video", "ui on resume, add online video event.");
    this.Kon.removeMessages(1);
    com.tencent.mm.sdk.b.a.IvT.c(this.Kop);
    if ((this.Kkv != null) && (com.tencent.mm.compatible.util.d.lA(21)))
    {
      k localk = this.Kkv.fJT();
      if ((localk != null) && (localk.KoL != null))
      {
        if ((localk.KoL instanceof VideoPlayerTextureView))
        {
          ((VideoPlayerTextureView)localk.KoL).bpy();
          AppMethodBeat.o(36282);
          return;
        }
        if ((localk.KoL instanceof VideoTextureView)) {
          ((VideoTextureView)localk.KoL).bpy();
        }
      }
    }
    AppMethodBeat.o(36282);
  }
  
  public final void pause(int paramInt)
  {
    AppMethodBeat.i(36267);
    d(aeb(paramInt));
    this.ozB.ez(false);
    this.Kkv.Kkw.setVideoStateIv(true);
    AppMethodBeat.o(36267);
  }
  
  public static final class a
  {
    public bv dlw;
    public int pos;
    
    public a(bv parambv, int paramInt)
    {
      this.dlw = parambv;
      this.pos = paramInt;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.gallery.j
 * JD-Core Version:    0.7.0.1
 */