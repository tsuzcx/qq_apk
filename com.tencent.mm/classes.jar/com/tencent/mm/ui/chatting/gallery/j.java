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
import com.tencent.mm.ai.k.b;
import com.tencent.mm.al.b.a;
import com.tencent.mm.al.b.c;
import com.tencent.mm.aw.a.a.c.a;
import com.tencent.mm.g.a.ng;
import com.tencent.mm.g.a.ng.a;
import com.tencent.mm.g.c.du;
import com.tencent.mm.ipcinvoker.wx_extension.IPCRunCgi;
import com.tencent.mm.ipcinvoker.wx_extension.IPCRunCgi.a;
import com.tencent.mm.model.az;
import com.tencent.mm.model.d.a;
import com.tencent.mm.model.q;
import com.tencent.mm.model.w;
import com.tencent.mm.model.y.b;
import com.tencent.mm.modelsimple.aa;
import com.tencent.mm.modelvideo.s;
import com.tencent.mm.modelvideo.t.a;
import com.tencent.mm.modelvideo.t.a.a;
import com.tencent.mm.modelvideo.y.a;
import com.tencent.mm.pluginsdk.ui.tools.RedesignVideoPlayerSeekBar;
import com.tencent.mm.pluginsdk.ui.tools.VideoPlayerTextureView;
import com.tencent.mm.pluginsdk.ui.tools.VideoTextureView;
import com.tencent.mm.protocal.protobuf.ayi;
import com.tencent.mm.protocal.protobuf.ayj;
import com.tencent.mm.protocal.protobuf.boj;
import com.tencent.mm.protocal.protobuf.bsg;
import com.tencent.mm.protocal.protobuf.czj;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.b;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.ap.a;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.av;
import com.tencent.mm.sdk.platformtools.av.a;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.ab;
import com.tencent.mm.storage.ae.a;
import com.tencent.mm.storage.bl;
import com.tencent.mm.ui.ai;
import com.tencent.mm.ui.chatting.ak;
import com.tencent.mm.ui.chatting.ak.a;
import com.tencent.mm.ui.widget.MMPinProgressBtn;
import d.g.b.v.e;
import java.io.IOException;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;

public final class j
  extends a
  implements d.a, t.a
{
  private static com.tencent.mm.ai.y GDm = null;
  public static boolean GDn = false;
  private HashMap<String, a> GBZ;
  private com.tencent.mm.sdk.b.c GDd;
  final SparseArray<s> GDe;
  private n GDf;
  private boolean GDg;
  private boolean GDh;
  private boolean GDi;
  private int GDj;
  private int GDk;
  private boolean GDl;
  ap GDo;
  private int GDp;
  private com.tencent.mm.sdk.b.c<ng> GDq;
  private boolean GDr;
  private int GDs;
  private int[] GDt;
  private String filename;
  private long kvd;
  private long lastCheckTime;
  private av nBf;
  private com.tencent.mm.model.d nnt;
  int qmp;
  private int qmq;
  private com.tencent.mm.plugin.sight.decode.ui.b qmw;
  private com.tencent.mm.plugin.o.b tzW;
  private av xdT;
  private com.tencent.mm.pluginsdk.ui.tools.h.e xpA;
  private boolean xpI;
  private long xpM;
  private long xpN;
  private long xpW;
  private int xpX;
  private PowerManager.WakeLock zqF;
  
  public j(b paramb)
  {
    super(paramb);
    AppMethodBeat.i(36261);
    this.GDe = new SparseArray();
    this.GDg = false;
    this.GDh = false;
    this.GDi = false;
    this.qmq = 0;
    this.kvd = 0L;
    this.lastCheckTime = 0L;
    this.GDj = 0;
    this.GDk = 0;
    this.xpM = 0L;
    this.xpN = 0L;
    this.qmp = 0;
    this.GDl = false;
    this.GDo = new ap(Looper.getMainLooper(), new ap.a()
    {
      public final boolean handleMessage(Message paramAnonymousMessage)
      {
        AppMethodBeat.i(36254);
        if (paramAnonymousMessage.what == 1)
        {
          paramAnonymousMessage = j.this.GzZ.eZs();
          if ((paramAnonymousMessage != null) && (!bt.isNullOrNil(j.b(j.this))))
          {
            ad.i("MicroMsg.Imagegallery.handler.video", "%d ui on pause, pause video now. %s", new Object[] { Integer.valueOf(hashCode()), j.b(j.this) });
            if (!j.c(j.this)) {
              com.tencent.mm.modelvideo.u.e(j.b(j.this), paramAnonymousMessage.fac().GDN.getCurrentPosition(), j.d(j.this));
            }
            j.g(paramAnonymousMessage);
            j.b(j.this, paramAnonymousMessage);
            j.e(j.this).ea(false);
            if (j.d(j.this))
            {
              com.tencent.mm.sdk.b.a.ESL.d(j.f(j.this));
              j.g(j.this).fag();
              j.a(j.this, false);
            }
          }
          j.h(j.this);
        }
        AppMethodBeat.o(36254);
        return false;
      }
    });
    this.GDp = 0;
    this.xdT = new av(new av.a()
    {
      public final boolean onTimerExpired()
      {
        AppMethodBeat.i(36258);
        if (!j.g(j.this).isStreaming())
        {
          AppMethodBeat.o(36258);
          return false;
        }
        k localk = j.this.GzZ.eZs();
        if (localk == null)
        {
          AppMethodBeat.o(36258);
          return false;
        }
        if (localk.GDK == null)
        {
          AppMethodBeat.o(36258);
          return false;
        }
        if (localk.fac().GDK.getVisibility() != 0)
        {
          AppMethodBeat.o(36258);
          return false;
        }
        boolean bool = true;
        if (localk.fac().GDN.isPlaying()) {
          bool = j.c(j.this, localk);
        }
        if (bool)
        {
          int i = localk.fac().GDN.getCurrentPosition() / 1000;
          bool = j.g(j.this).oR(i);
          AppMethodBeat.o(36258);
          return bool;
        }
        AppMethodBeat.o(36258);
        return false;
      }
    }, true);
    this.nBf = new av(new av.a()
    {
      public final boolean onTimerExpired()
      {
        AppMethodBeat.i(36259);
        if (j.this.GzZ == null)
        {
          ad.w("MicroMsg.Imagegallery.handler.video", "[onTimerExpired] null == adapter");
          AppMethodBeat.o(36259);
          return false;
        }
        k localk = j.this.GzZ.eZs();
        if (localk == null)
        {
          AppMethodBeat.o(36259);
          return false;
        }
        if (localk.GDK == null)
        {
          AppMethodBeat.o(36259);
          return false;
        }
        if (localk.fac().GDK.getVisibility() != 0)
        {
          AppMethodBeat.o(36259);
          return false;
        }
        int i = j.this.GzZ.GAa.getCurrentItem();
        if ((s)j.this.GDe.get(i) == null)
        {
          j.this.Zu(i);
          AppMethodBeat.o(36259);
          return false;
        }
        if (!localk.fac().GDN.isPlaying())
        {
          ad.i("MicroMsg.Imagegallery.handler.video", "it is not playing, stop offline timer");
          AppMethodBeat.o(36259);
          return false;
        }
        j.a(j.this, localk.fac().GDN.getCurrentPosition());
        j.this.Zv(j.o(j.this) / 1000);
        AppMethodBeat.o(36259);
        return true;
      }
    }, true);
    this.qmw = new com.tencent.mm.plugin.sight.decode.ui.b()
    {
      public final void bcv()
      {
        AppMethodBeat.i(36244);
        if (j.this.GzZ.eZs() != null) {
          j.b(j.this, j.this.GzZ.eZs());
        }
        j.this.GzZ.GAa.qmv.stopTimer();
        AppMethodBeat.o(36244);
      }
      
      public final void rZ(int paramAnonymousInt)
      {
        AppMethodBeat.i(36245);
        localObject = null;
        try
        {
          String str = j.this.GzZ.eZs().fac().GDN.getVideoPath();
          localObject = str;
        }
        catch (Exception localException)
        {
          for (;;)
          {
            ad.printErrStackTrace("MicroMsg.Imagegallery.handler.video", localException, "", new Object[0]);
            ad.e("MicroMsg.Imagegallery.handler.video", "on seek get video path error: " + localException.toString());
            continue;
            boolean bool = j.g(j.this).aW(paramAnonymousInt, true);
            continue;
            localObject = j.this.GzZ.eZr();
            if ((localObject != null) && (((bl)localObject).cjM())) {
              com.tencent.mm.modelvideo.u.e(((du)localObject).field_imgPath, paramAnonymousInt * 1000, j.d(j.this));
            }
            j.this.GzZ.Zc(j.this.GzZ.GAa.getCurrentItem());
          }
        }
        ad.i("MicroMsg.Imagegallery.handler.video", "on seek to time[%d] isOnlinePlay[%b] videoPath[%s]", new Object[] { Integer.valueOf(paramAnonymousInt), Boolean.valueOf(j.d(j.this)), localObject });
        j.this.GzZ.eZs().fac().GDM.setVisibility(8);
        if (!bt.isNullOrNil((String)localObject)) {
          if (!j.d(j.this))
          {
            j.this.at(paramAnonymousInt, true);
            bool = true;
            if (bool) {
              j.this.ez(false);
            }
            j.this.GzZ.GAa.eZN();
            localObject = j.this.GzZ.eZr();
            if ((localObject != null) && (((bl)localObject).cjN())) {
              j.this.GzZ.GAa.GCg.i((bl)localObject, 13);
            }
            AppMethodBeat.o(36245);
            return;
          }
        }
      }
    };
    this.GDq = new com.tencent.mm.sdk.b.c()
    {
      private boolean a(ng paramAnonymousng)
      {
        AppMethodBeat.i(36246);
        if (!j.g(j.this).aqu(paramAnonymousng.dsm.mediaId))
        {
          AppMethodBeat.o(36246);
          return false;
        }
        if ((paramAnonymousng.dsm.retCode != 0) && (paramAnonymousng.dsm.retCode != -21006))
        {
          ad.w("MicroMsg.Imagegallery.handler.video", "stream download online video error. retCode: " + paramAnonymousng.dsm.retCode);
          j.a(j.this, paramAnonymousng.dsm.mediaId, paramAnonymousng.dsm.retCode);
          AppMethodBeat.o(36246);
          return false;
        }
        switch (paramAnonymousng.dsm.djq)
        {
        default: 
          ad.w("MicroMsg.Imagegallery.handler.video", "unknown event opcode " + paramAnonymousng.dsm.djq);
        }
        for (;;)
        {
          AppMethodBeat.o(36246);
          return false;
          n localn = j.g(j.this);
          long l2 = paramAnonymousng.dsm.offset;
          long l1 = paramAnonymousng.dsm.dsn;
          boolean bool = paramAnonymousng.dsm.dso;
          ad.i("MicroMsg.OnlineVideoUIHelper", "deal moov ready moovPos[%d] needSeekTime[%d] timeDuration[%d] startDownload[%d %d]", new Object[] { Long.valueOf(l2), Integer.valueOf(localn.hxW), Integer.valueOf(localn.hxV), Long.valueOf(l1), Long.valueOf(localn.fnZ) });
          if (localn.hxV != 0) {
            ad.w("MicroMsg.OnlineVideoUIHelper", "moov had callback, do nothing.");
          }
          for (;;)
          {
            j.a(j.this, true);
            break;
            if (l1 > localn.fnZ) {}
            for (;;)
            {
              for (;;)
              {
                localn.fnZ = l1;
                com.tencent.mm.plugin.report.service.h.vKh.idkeyStat(354L, 5L, 1L, false);
                localn.xqo = bt.eGO();
                com.tencent.mm.modelvideo.o.aCI();
                paramAnonymousng = com.tencent.mm.modelvideo.t.zQ(localn.filename);
                try
                {
                  if (localn.xqk != null) {
                    break label435;
                  }
                  ad.w("MicroMsg.OnlineVideoUIHelper", "parser is null, thread is error.");
                }
                catch (Exception paramAnonymousng)
                {
                  ad.printErrStackTrace("MicroMsg.OnlineVideoUIHelper", paramAnonymousng, "", new Object[0]);
                  ad.e("MicroMsg.OnlineVideoUIHelper", "deal moov ready error: " + paramAnonymousng.toString());
                }
              }
              break;
              l1 = localn.fnZ;
            }
            label435:
            if (localn.xqk.E(paramAnonymousng, l2))
            {
              localn.hxV = localn.xqk.hXw;
              ad.i("MicroMsg.OnlineVideoUIHelper", "mp4 parse moov success. duration %d filename %s isFastStart %b", new Object[] { Integer.valueOf(localn.hxV), localn.filename, Boolean.valueOf(bool) });
              if (!bool) {
                aq.f(new n.1(localn));
              }
              if (localn.hxW == -1) {}
              for (localn.hxT = 1;; localn.hxT = 2)
              {
                com.tencent.mm.plugin.report.service.h.vKh.idkeyStat(354L, 7L, 1L, false);
                break;
              }
            }
            ad.w("MicroMsg.OnlineVideoUIHelper", "mp4 parse moov error.");
            com.tencent.mm.modelvideo.o.aCJ();
            com.tencent.mm.ao.e.q(localn.mediaId, 0, -1);
            com.tencent.mm.modelvideo.u.ao(localn.filename, 15);
            com.tencent.mm.plugin.report.service.h.vKh.idkeyStat(354L, 8L, 1L, false);
            ad.w("MicroMsg.OnlineVideoUIHelper", "%d rpt parse moov fail %s ", new Object[] { Integer.valueOf(localn.hashCode()), localn.filename });
            com.tencent.mm.plugin.report.service.h.vKh.f(13836, new Object[] { Integer.valueOf(302), Long.valueOf(bt.aGK()), "" });
          }
          localn = j.g(j.this);
          Object localObject = paramAnonymousng.dsm.mediaId;
          int i = paramAnonymousng.dsm.offset;
          int j = paramAnonymousng.dsm.length;
          localn.hyc = false;
          if ((i < 0) || (j < 0)) {
            ad.w("MicroMsg.OnlineVideoUIHelper", "deal data available error offset[%d], length[%d]", new Object[] { Integer.valueOf(i), Integer.valueOf(j) });
          }
          while (!localn.aqu((String)localObject))
          {
            if (paramAnonymousng.dsm.length <= 0) {
              break;
            }
            j.this.ez(true);
            break;
          }
          localObject = localn.mediaId + i + "_" + j;
          localObject = (Integer)localn.xqj.get(localObject);
          if ((localObject != null) && (((Integer)localObject).intValue() > 0)) {
            localn.hxZ = ((Integer)localObject).intValue();
          }
          for (;;)
          {
            ad.i("MicroMsg.OnlineVideoUIHelper", "deal data available. offset[%d] length[%d] cachePlayTime[%d]", new Object[] { Integer.valueOf(i), Integer.valueOf(j), Integer.valueOf(localn.hxZ) });
            break;
            try
            {
              localn.hxZ = localn.xqk.dw(i, j);
            }
            catch (Exception localException)
            {
              ad.printErrStackTrace("MicroMsg.OnlineVideoUIHelper", localException, "", new Object[0]);
              ad.e("MicroMsg.OnlineVideoUIHelper", "deal data available file pos to video time error: " + localException.toString());
            }
          }
          j.this.ez(true);
          continue;
          paramAnonymousng = j.g(j.this);
          ad.i("MicroMsg.OnlineVideoUIHelper", "deal stream finish. playStatus %d ", new Object[] { Integer.valueOf(paramAnonymousng.hxT) });
          paramAnonymousng.hyc = false;
          paramAnonymousng.hxS = 3;
          if (paramAnonymousng.hxT == 0)
          {
            ad.w("MicroMsg.OnlineVideoUIHelper", "it had not moov callback and download finish start to play video.");
            paramAnonymousng.dzQ();
            com.tencent.mm.plugin.report.service.h.vKh.idkeyStat(354L, 6L, 1L, false);
          }
          for (;;)
          {
            paramAnonymousng.fai();
            com.tencent.mm.plugin.report.service.h.vKh.idkeyStat(354L, 26L, 1L, false);
            j.this.ez(true);
            break;
            if (paramAnonymousng.hxT == 5)
            {
              ad.w("MicroMsg.OnlineVideoUIHelper", "it had play error, it request all video data finish, start to play." + paramAnonymousng.mediaId);
              paramAnonymousng.dzQ();
            }
          }
          localn = j.g(j.this);
          String str = paramAnonymousng.dsm.mediaId;
          i = paramAnonymousng.dsm.offset;
          if (localn.aqu(str))
          {
            if (localn.iLS != 0) {
              localn.xqm = (i * 100 / localn.iLS);
            }
            ad.i("MicroMsg.OnlineVideoUIHelper", "deal progress callback. downloadedPercent : " + localn.xqm);
          }
          if (localn.xqm >= 100)
          {
            localn.hxS = 3;
            continue;
            paramAnonymousng = j.g(j.this);
            ad.i("MicroMsg.OnlineVideoUIHelper", "deal had dup video.");
            paramAnonymousng.fai();
            paramAnonymousng.dzQ();
          }
        }
      }
    };
    this.GDr = false;
    this.GDs = 0;
    this.GDt = new int[] { -1000, -2000, 3400 };
    this.xpA = new com.tencent.mm.pluginsdk.ui.tools.h.e()
    {
      public final void beo()
      {
        AppMethodBeat.i(36250);
        ad.i("MicroMsg.Imagegallery.handler.video", "%d on texture update.", new Object[] { Integer.valueOf(j.this.hashCode()) });
        try
        {
          j.this.GzZ.eZs().b(true, 1.0F);
          AppMethodBeat.o(36250);
          return;
        }
        catch (Exception localException)
        {
          ad.e("MicroMsg.Imagegallery.handler.video", "texture view update. error " + localException.toString());
          AppMethodBeat.o(36250);
        }
      }
    };
    this.tzW = new com.tencent.mm.plugin.o.b()
    {
      public final long cPk()
      {
        AppMethodBeat.i(36251);
        ad.i("MicroMsg.Imagegallery.handler.video", "%d video get online cache sec", new Object[] { Integer.valueOf(j.this.hashCode()) });
        az.arV();
        com.tencent.mm.model.c.afk().set(ae.a.FnJ, Boolean.TRUE);
        try
        {
          if ((j.d(j.this)) && (j.g(j.this) != null))
          {
            int i = j.g(j.this).hxZ;
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
    GDm = null;
    this.GBZ = new HashMap();
    this.GDf = new n(this);
    com.tencent.mm.sdk.b.a locala = com.tencent.mm.sdk.b.a.ESL;
    paramb = new ak(ak.a.GqB, paramb.GAa);
    this.GDd = paramb;
    locala.c(paramb);
    com.tencent.mm.sdk.b.a.ESL.c(this.GDq);
    this.nnt = new com.tencent.mm.model.d();
    AppMethodBeat.o(36261);
  }
  
  private void a(bl parambl, s params)
  {
    AppMethodBeat.i(36275);
    if ((!com.tencent.mm.network.ae.cJ(this.GzZ.GAa.getContext())) && (!GDn)) {
      GDn = true;
    }
    b(parambl, params);
    AppMethodBeat.o(36275);
  }
  
  private void a(bl parambl, s params, int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(36274);
    if ((parambl == null) || (params == null))
    {
      AppMethodBeat.o(36274);
      return;
    }
    if ((!parambl.cjN()) && (parambl.eMl()))
    {
      Toast.makeText(this.GzZ.GAa, 2131764677, 0).show();
      AppMethodBeat.o(36274);
      return;
    }
    Object localObject3;
    Object localObject1;
    if (params.hAo == -1)
    {
      localObject3 = params.aCS();
      localObject1 = localObject3;
      if (!com.tencent.mm.vfs.i.eK((String)localObject3))
      {
        com.tencent.mm.modelvideo.o.aCI();
        localObject1 = com.tencent.mm.modelvideo.t.zQ(parambl.field_imgPath);
        if ((localObject1 != null) && (com.tencent.mm.vfs.i.eK((String)localObject1))) {
          break label336;
        }
        Toast.makeText(this.GzZ.GAa, 2131764677, 0).show();
        AppMethodBeat.o(36274);
      }
    }
    else
    {
      com.tencent.mm.modelvideo.o.aCI();
      localObject3 = com.tencent.mm.modelvideo.t.zQ(parambl.field_imgPath);
      localObject1 = localObject3;
      if (parambl.field_isSend == 1)
      {
        localObject1 = localObject3;
        if (params.hAr != null)
        {
          localObject1 = localObject3;
          if (!params.hAr.DLK) {}
        }
      }
    }
    for (;;)
    {
      try
      {
        String str = com.tencent.mm.vfs.i.aMQ((String)localObject3);
        localObject1 = str;
        if (!str.endsWith("/")) {
          localObject1 = str + "/";
        }
        str = com.tencent.mm.vfs.i.aMS((String)localObject3);
        localObject1 = (String)localObject1 + str + "_hd.mp4";
        bool = com.tencent.mm.vfs.i.eK((String)localObject1);
        ad.i("MicroMsg.Imagegallery.handler.video", "local capture video, hdFilePath: %s, exist: %s", new Object[] { localObject1, Boolean.valueOf(bool) });
        if (!bool) {
          break label1074;
        }
      }
      catch (Exception localException)
      {
        ad.e("MicroMsg.Imagegallery.handler.video", "try to get hd filePath error: %s", new Object[] { localException.getMessage() });
        localObject2 = localObject3;
      }
      break;
      label336:
      localObject3 = YW(paramInt);
      if (localObject3 == null)
      {
        AppMethodBeat.o(36274);
        return;
      }
      int i = 0;
      if (w.pF(params.getUser())) {
        i = q.rY(params.getUser());
      }
      boolean bool = com.tencent.mm.modelvideo.r.zK(localObject2);
      int j = this.GzZ.GAa.wO(parambl.field_msgId);
      ad.i("MicroMsg.Imagegallery.handler.video", "play video pos[%d], isOnlinePlay[%b] opcode[%d] resetByCompletion[%b]", new Object[] { Integer.valueOf(paramInt), Boolean.valueOf(paramBoolean), Integer.valueOf(j), Boolean.valueOf(this.GDl) });
      if (!bool)
      {
        if ((com.tencent.mm.compatible.deviceinfo.ae.fFH.fCm == 1) && (com.tencent.mm.pluginsdk.i.b.a.a.b(params.getFileName(), this.GzZ.GAa.getContext(), bool)))
        {
          AppMethodBeat.o(36274);
          return;
        }
        az.arV();
        if ((((Integer)com.tencent.mm.model.c.afk().get(ae.a.Fmr, Integer.valueOf(0))).intValue() == 1) && (((k)localObject3).GDP != null))
        {
          ((k)localObject3).GDP.setVisibility(0);
          ((k)localObject3).GDP.setText(com.tencent.mm.plugin.sight.base.e.ahc(localObject2));
        }
        ((k)localObject3).a(params.gOY, params.gTY, i, params.getUser(), s.zM(params.aCT()), params.createTime);
        this.xpI = paramBoolean;
        this.GDg = true;
        this.filename = params.getFileName();
        if (j == 3)
        {
          ((k)localObject3).fac().GDN.setMute(true);
          if ((((k)localObject3).fac().GDN.getVideoPath() == null) || (!((k)localObject3).fac().GDN.getVideoPath().equals(localObject2)) || (((k)localObject3).fac().GDN.isPlaying()) || (this.GDl)) {
            break label822;
          }
          ((k)localObject3).b(true, 1.0F);
          ((k)localObject3).fac().GDN.start();
          dzG();
          if (!paramBoolean) {
            aKW(this.filename);
          }
          Zv(((k)localObject3).fac().GDN.getCurrentPosition() / 1000);
          ez(false);
          label740:
          b(paramInt, params);
          this.GzZ.GAa.setVideoStateIv(false);
          this.GzZ.GAa.getContext().getWindow().addFlags(128);
          this.nnt.a(this);
        }
      }
      for (;;)
      {
        ((k)localObject3).fac().GDO.setVisibility(8);
        AppMethodBeat.o(36274);
        return;
        ((k)localObject3).fac().GDN.setMute(false);
        break;
        label822:
        this.GDi = false;
        this.GDl = false;
        ((k)localObject3).fac().GDN.setVideoPath(localObject2);
        if ((((k)localObject3).fac().GDN instanceof VideoPlayerTextureView))
        {
          ((VideoPlayerTextureView)((k)localObject3).fac().GDN).setIOnlineCache(this.tzW);
          ((VideoPlayerTextureView)((k)localObject3).fac().GDN).setNeedResetExtractor(ckf());
          ((VideoPlayerTextureView)((k)localObject3).fac().GDN).setIsOnlineVideoType(paramBoolean);
        }
        ((k)localObject3).b(true, 0.0F);
        break label740;
        com.tencent.mm.plugin.report.service.h.vKh.f(12084, new Object[] { Integer.valueOf(params.gTY), Integer.valueOf(params.gOY * 1000), Integer.valueOf(0), Integer.valueOf(3), params.getUser(), Integer.valueOf(i), s.zM(params.aCT()), Long.valueOf(params.createTime) });
        if (!com.tencent.mm.pluginsdk.i.b.a.a.c(localObject2, this.GzZ.GAa.getContext(), bool)) {
          Toast.makeText(this.GzZ.GAa.getContext(), this.GzZ.GAa.getString(2131764691), 0).show();
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
      paramk.fac();
      paramk.fac().GDQ.setVisibility(0);
      paramk.fac().GDR.setText(bt.by(paramString, this.GzZ.GAa.getString(2131764692)));
      paramk.fac().GDL.setVisibility(0);
      paramk.fac().GDM.setVisibility(8);
      c(paramk);
      AppMethodBeat.o(36271);
      return;
    }
    AppMethodBeat.o(36271);
  }
  
  public static bl b(String paramString, Activity paramActivity)
  {
    AppMethodBeat.i(36266);
    bl localbl = new bl();
    localbl.setType(486539313);
    localbl.nY(paramString);
    localbl.FzP = true;
    localbl.FzO = bg(paramActivity);
    localbl.nZ(paramActivity.getIntent().getStringExtra("img_gallery_path"));
    AppMethodBeat.o(36266);
    return localbl;
  }
  
  private void b(int paramInt, s params)
  {
    AppMethodBeat.i(36290);
    this.GDe.put(paramInt, params);
    AppMethodBeat.o(36290);
  }
  
  private void b(bl parambl, s params)
  {
    AppMethodBeat.i(36276);
    ad.i("MicroMsg.Imagegallery.handler.video", "startDownloading [%d]", new Object[] { Integer.valueOf(hashCode()) });
    if ((parambl == null) || (params == null))
    {
      AppMethodBeat.o(36276);
      return;
    }
    k localk = this.GzZ.eZs();
    if (localk == null)
    {
      AppMethodBeat.o(36276);
      return;
    }
    aa.O(parambl);
    int i = this.GzZ.GAa.wO(parambl.field_msgId);
    ad.d("MicroMsg.Imagegallery.handler.video", "enterVideoOpCode : ".concat(String.valueOf(i)));
    switch (i)
    {
    default: 
      ad.w("MicroMsg.Imagegallery.handler.video", "enterVideoOpCode[%d] is error", new Object[] { Integer.valueOf(i) });
      AppMethodBeat.o(36276);
      return;
    case 3: 
      ad.i("MicroMsg.Imagegallery.handler.video", "%d mute play video [%d]", new Object[] { Integer.valueOf(hashCode()), Integer.valueOf(i) });
    case 0: 
      if ((this.GDf.aKY(parambl.field_imgPath)) || (this.GDf.c(parambl, params)))
      {
        ad.i("MicroMsg.Imagegallery.handler.video", "start online play video.");
        this.xpI = true;
        com.tencent.mm.modelvideo.o.aCI().a(this);
        localk.fac().GDM.setVisibility(8);
        localk.fac().GDO.setVisibility(8);
        localk.fac().GDX.setVisibility(0);
        AppMethodBeat.o(36276);
        return;
      }
      ad.i("MicroMsg.Imagegallery.handler.video", "start offline play video.");
      this.xpI = false;
      com.tencent.mm.modelvideo.o.aCI().a(this, Looper.getMainLooper());
      com.tencent.mm.modelvideo.u.zZ(parambl.field_imgPath);
      localk.fac().GDM.setVisibility(8);
      localk.fac().GDO.setVisibility(0);
      localk.fac().GDO.setProgress(com.tencent.mm.modelvideo.u.g(params));
      AppMethodBeat.o(36276);
      return;
    }
    if (params.aCV())
    {
      ad.i("MicroMsg.Imagegallery.handler.video", "start complete online video");
      com.tencent.mm.modelvideo.u.Al(parambl.field_imgPath);
    }
    for (;;)
    {
      com.tencent.mm.modelvideo.o.aCI().a(this, Looper.getMainLooper());
      localk.fac().GDM.setVisibility(8);
      localk.fac().GDO.setVisibility(0);
      localk.fac().GDO.setProgress(com.tencent.mm.modelvideo.u.g(params));
      if (i != 2) {
        break;
      }
      eZY();
      AppMethodBeat.o(36276);
      return;
      ad.i("MicroMsg.Imagegallery.handler.video", "start complete offline video");
      gb(parambl.field_imgPath, 10);
      com.tencent.mm.modelvideo.u.zZ(parambl.field_imgPath);
    }
    eZX();
    AppMethodBeat.o(36276);
  }
  
  private static void b(k paramk)
  {
    AppMethodBeat.i(36272);
    if (paramk != null)
    {
      paramk.fac();
      paramk.fac().GDQ.setVisibility(8);
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
    com.tencent.mm.modelvideo.o.aCI().a(this);
    if (this.GzZ.GAa.getCurrentItem() == parama.pos)
    {
      parama = YW(parama.pos);
      if (parama != null)
      {
        parama.fac().GDX.setVisibility(8);
        parama.fac().GDO.setVisibility(8);
        parama.fac().GDM.setVisibility(8);
      }
      this.GDr = true;
      this.GzZ.GAa.eZH();
      AppMethodBeat.o(36278);
      return true;
    }
    this.GzZ.Ze(parama.pos);
    AppMethodBeat.o(36278);
    return false;
  }
  
  private static com.tencent.mm.ai.y bg(Activity paramActivity)
  {
    AppMethodBeat.i(36264);
    byte[] arrayOfByte;
    if (GDm == null)
    {
      arrayOfByte = paramActivity.getIntent().getByteArrayExtra("img_gallery_mp_share_video_info");
      if (bt.cw(arrayOfByte))
      {
        ad.e("MicroMsg.Imagegallery.handler.video", "initMPShareVideoInfo data is null");
        paramActivity.finish();
        AppMethodBeat.o(36264);
        return null;
      }
    }
    try
    {
      com.tencent.mm.ai.y localy = new com.tencent.mm.ai.y();
      localy.parseFrom(arrayOfByte);
      GDm = localy;
      paramActivity = GDm;
      AppMethodBeat.o(36264);
      return paramActivity;
    }
    catch (IOException localIOException)
    {
      for (;;)
      {
        ad.e("MicroMsg.Imagegallery.handler.video", "initMPShareVideoInfo ex %s", new Object[] { localIOException.getMessage() });
        paramActivity.finish();
      }
    }
  }
  
  private void c(k paramk)
  {
    AppMethodBeat.i(36280);
    ad.i("MicroMsg.Imagegallery.handler.video", "stop");
    dzu();
    if (paramk == null)
    {
      AppMethodBeat.o(36280);
      return;
    }
    dzH();
    if (this.xpI) {
      this.GDf.fag();
    }
    if (!this.GDh) {
      com.tencent.mm.modelvideo.u.e(this.filename, this.qmq - 1000, this.xpI);
    }
    paramk.fac().GDO.setVisibility(8);
    paramk.fac().GDX.setVisibility(8);
    paramk.fac().GDN.stop();
    Zv(0);
    paramk.b(false, 0.0F);
    this.xpI = false;
    this.GDr = false;
    this.GDl = false;
    this.filename = null;
    this.xpX = 0;
    this.xpW = 0L;
    this.GDs = 0;
    this.GDp = 0;
    this.GDk = 0;
    this.GDj = 0;
    this.kvd = 0L;
    this.lastCheckTime = 0L;
    AppMethodBeat.o(36280);
  }
  
  public static s ch(bl parambl)
  {
    AppMethodBeat.i(36263);
    if (!b.m(parambl))
    {
      AppMethodBeat.o(36263);
      return null;
    }
    parambl = com.tencent.mm.modelvideo.u.Ae(parambl.field_imgPath);
    AppMethodBeat.o(36263);
    return parambl;
  }
  
  public static com.tencent.mm.ai.y ci(bl parambl)
  {
    AppMethodBeat.i(36265);
    if (parambl.eLP())
    {
      parambl = new com.tencent.mm.ai.y().a(parambl.FzO);
      AppMethodBeat.o(36265);
      return parambl;
    }
    parambl = k.b.ar(parambl.field_content, parambl.field_reserved);
    if (parambl == null)
    {
      ad.w("MicroMsg.Imagegallery.handler.video", "getVideoInfo content is null");
      AppMethodBeat.o(36265);
      return null;
    }
    parambl = (com.tencent.mm.ai.e)parambl.ao(com.tencent.mm.ai.e.class);
    if ((parambl != null) && (parambl.gGE != null)) {}
    for (parambl = parambl.gGE;; parambl = null)
    {
      AppMethodBeat.o(36265);
      return parambl;
    }
  }
  
  private static s cj(bl parambl)
  {
    AppMethodBeat.i(36269);
    s locals = ch(parambl);
    if (locals != null)
    {
      AppMethodBeat.o(36269);
      return locals;
    }
    ad.i("MicroMsg.Imagegallery.handler.video", "insert video info:" + parambl.toString());
    locals = new s();
    locals.dtV = parambl.field_talker;
    locals.fileName = parambl.field_imgPath;
    if (parambl.field_createTime <= 0L) {}
    for (long l = System.currentTimeMillis();; l = parambl.field_createTime)
    {
      locals.createTime = l;
      locals.drA = parambl.field_msgSvrId;
      locals.hAn = parambl.field_content;
      locals.hAi = ((int)parambl.field_msgId);
      com.tencent.mm.ai.y localy = ci(parambl);
      if (localy != null)
      {
        if (TextUtils.isEmpty(parambl.field_imgPath))
        {
          parambl.nZ(com.tencent.mm.modelvideo.t.zP(parambl.field_talker));
          az.arV();
          com.tencent.mm.model.c.apO().a(parambl.field_msgId, parambl);
        }
        locals.fileName = parambl.field_imgPath;
        m localm = m.GED;
        locals.a(bt.by(m.aiG(localy.rD(parambl.field_imgPath)), localy.videoUrl), localy.videoDuration, localy.title, localy.CEf, "", "", "");
        locals.status = 111;
      }
      com.tencent.mm.modelvideo.o.aCI().b(locals);
      AppMethodBeat.o(36269);
      return locals;
    }
  }
  
  private boolean ckf()
  {
    AppMethodBeat.i(36307);
    if (!this.xpI)
    {
      AppMethodBeat.o(36307);
      return false;
    }
    az.arV();
    boolean bool = com.tencent.mm.model.c.afk().getBoolean(ae.a.FnJ, false);
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
    dzu();
    ad.d("MicroMsg.Imagegallery.handler.video", "pause video.");
    if (paramk.fac().GDN.isPlaying())
    {
      paramk.fac().GDN.pause();
      dzH();
    }
    AppMethodBeat.o(36281);
  }
  
  private void dzG()
  {
    AppMethodBeat.i(36300);
    this.xpW = bt.eGO();
    ad.d("MicroMsg.Imagegallery.handler.video", "notePlayVideo filename %s notePlayVideo %d ", new Object[] { this.filename, Long.valueOf(this.xpW) });
    if ((this.GzZ != null) && (this.GzZ.GAa != null)) {
      this.GzZ.GAa.GCg.cc(this.GzZ.eZr());
    }
    AppMethodBeat.o(36300);
  }
  
  private void dzH()
  {
    AppMethodBeat.i(36301);
    if (this.xpW > 0L) {
      this.xpX = ((int)(this.xpX + (bt.eGO() - this.xpW) / 1000L));
    }
    ad.i("MicroMsg.Imagegallery.handler.video", "notePauseVideo filename %s playVideoDuration %d ", new Object[] { this.filename, Integer.valueOf(this.xpX) });
    this.xpW = 0L;
    if ((this.GzZ != null) && (this.GzZ.GAa != null)) {
      this.GzZ.GAa.GCg.cb(this.GzZ.eZr());
    }
    AppMethodBeat.o(36301);
  }
  
  private void dzu()
  {
    AppMethodBeat.i(36288);
    ad.i("MicroMsg.Imagegallery.handler.video", "clear timer");
    this.xdT.stopTimer();
    this.nBf.stopTimer();
    AppMethodBeat.o(36288);
  }
  
  private static void e(k paramk)
  {
    AppMethodBeat.i(36283);
    if (paramk != null)
    {
      paramk.fac();
      if (paramk.fac().GDN.isPlaying()) {
        k.aD(paramk.fac().GDM, 0);
      }
      AppMethodBeat.o(36283);
      return;
    }
    AppMethodBeat.o(36283);
  }
  
  private void eZW()
  {
    AppMethodBeat.i(36293);
    try
    {
      this.GzZ.GAa.eZC().yEw.setIplaySeekCallback(this.qmw);
      AppMethodBeat.o(36293);
      return;
    }
    catch (Exception localException)
    {
      AppMethodBeat.o(36293);
    }
  }
  
  private static void eZX()
  {
    AppMethodBeat.i(36305);
    com.tencent.mm.plugin.report.service.h.vKh.idkeyStat(354L, 11L, 1L, false);
    AppMethodBeat.o(36305);
  }
  
  private static void eZY()
  {
    AppMethodBeat.i(36306);
    com.tencent.mm.plugin.report.service.h.vKh.idkeyStat(354L, 14L, 1L, false);
    AppMethodBeat.o(36306);
  }
  
  private boolean f(k paramk)
  {
    AppMethodBeat.i(36304);
    int i = this.qmq;
    this.qmq = paramk.fac().GDN.getCurrentPosition();
    int j;
    if (i != this.qmq)
    {
      this.lastCheckTime = bt.eGO();
      long l = paramk.fac().GDN.getLastSurfaceUpdateTime();
      if ((l > 0L) && (l != this.kvd))
      {
        this.kvd = l;
        j = this.GDj;
        switch (j)
        {
        default: 
          this.GDj = 0;
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
          ad.w("MicroMsg.Imagegallery.handler.video", "%d rpt rptRepairEffect idKey %d errorTime %d filename %s", new Object[] { Integer.valueOf(hashCode()), Integer.valueOf(i), Integer.valueOf(j), this.filename });
          com.tencent.mm.plugin.report.service.h.vKh.idkeyStat(354L, i, 1L, false);
          com.tencent.mm.plugin.report.service.h.vKh.f(13836, new Object[] { Integer.valueOf(301), Long.valueOf(bt.aGK()), "" });
          break;
          i = 22;
          continue;
          i = 23;
        }
        if (this.GDj != -1)
        {
          this.GDj += 1;
          ad.w("MicroMsg.Imagegallery.handler.video", "media play is playing[%d], but surface is not update!! repair time[%d]", new Object[] { Integer.valueOf(this.GDj), Integer.valueOf(this.GDk) });
          if (this.GDk >= 2) {
            this.GDf.fah();
          }
          switch (this.GDj)
          {
          case 0: 
          case 1: 
          default: 
            ad.w("MicroMsg.Imagegallery.handler.video", "rpt surface not update!!");
            ad.w("MicroMsg.Imagegallery.handler.video", "%d rpt rptSurfaceNotUpdate %s", new Object[] { Integer.valueOf(hashCode()), this.filename });
            com.tencent.mm.plugin.report.service.h.vKh.f(13836, new Object[] { Integer.valueOf(300), Long.valueOf(bt.aGK()), "" });
            com.tencent.mm.plugin.report.service.h.vKh.idkeyStat(354L, 20L, 1L, false);
            this.GDj = -1;
          }
        }
      }
      i = this.qmq / 1000;
      ad.w("MicroMsg.Imagegallery.handler.video", "surface not update, it try seek time[%d] to repair.", new Object[] { Integer.valueOf(i) });
      at(i, true);
      this.GDk += 1;
      AppMethodBeat.o(36304);
      return false;
      j = (this.qmq - 2000) / 1000;
      i = j;
      if (j < 0) {
        i = 0;
      }
      ad.w("MicroMsg.Imagegallery.handler.video", "surface not update, it try seek time[%d] to repair.", new Object[] { Integer.valueOf(i) });
      at(i, true);
      this.GDk += 1;
      AppMethodBeat.o(36304);
      return false;
      j = (this.qmq - 4000) / 1000;
      i = j;
      if (j < 0) {
        i = 0;
      }
      ad.w("MicroMsg.Imagegallery.handler.video", "surface not update, it try seek time[%d] to repair.", new Object[] { Integer.valueOf(i) });
      at(i, true);
      this.GDk += 1;
      AppMethodBeat.o(36304);
      return false;
      ad.i("MicroMsg.Imagegallery.handler.video", "check time[%d, %d], play time[%d, %d]", new Object[] { Long.valueOf(this.lastCheckTime), Long.valueOf(bt.eGO()), Integer.valueOf(i), Integer.valueOf(this.qmq) });
    } while ((this.lastCheckTime <= 0L) || (bt.vM(this.lastCheckTime) < 1500L));
    ad.w("MicroMsg.Imagegallery.handler.video", "play time not update! request all video data to play. ");
    i = this.GzZ.eZs().GDN.getCurrentPosition();
    dzu();
    com.tencent.mm.modelvideo.u.e(this.filename, i, this.xpI);
    this.GzZ.eZs().GDN.stop();
    this.GDf.fah();
    paramk = (a)this.GBZ.get(this.filename);
    if ((paramk == null) || (paramk.dbD == null))
    {
      AppMethodBeat.o(36304);
      return false;
    }
    s locals = ch(paramk.dbD);
    a(paramk.dbD, locals, paramk.pos, this.xpI);
    this.lastCheckTime = 0L;
    AppMethodBeat.o(36304);
    return false;
  }
  
  private void gb(final String paramString, final int paramInt)
  {
    AppMethodBeat.i(36277);
    az.afE().ax(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(36253);
        com.tencent.mm.modelvideo.u.ap(paramString, paramInt);
        AppMethodBeat.o(36253);
      }
    });
    AppMethodBeat.o(36277);
  }
  
  private void releaseWakeLock()
  {
    AppMethodBeat.i(36268);
    if ((this.zqF != null) && (this.zqF.isHeld()))
    {
      ad.i("MicroMsg.Imagegallery.handler.video", "release waklock");
      this.zqF.release();
    }
    AppMethodBeat.o(36268);
  }
  
  public final void MV()
  {
    AppMethodBeat.i(36279);
    ad.i("MicroMsg.Imagegallery.handler.video", "stopAll. video handler hash code : " + hashCode());
    this.xpN = bt.eGO();
    SparseArray localSparseArray = this.GzZ.Gbm;
    int j = 0;
    int i = 0;
    if (j < localSparseArray.size())
    {
      int k = localSparseArray.keyAt(j);
      if ((localSparseArray.get(k) == null) || (((View)localSparseArray.get(k)).getTag() == null)) {
        break label253;
      }
      k localk = (k)((View)localSparseArray.get(k)).getTag();
      if ((localk.GDK == null) || (localk.fac().GDK.getVisibility() != 0) || ((((View)localk.fac().GDN).getVisibility() != 0) && (bt.isNullOrNil(localk.fac().GDN.getVideoPath())) && ((!this.xpI) || (!this.GDf.isStreaming())))) {
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
      this.nnt.ea(false);
      if ((i == 0) && (this.xpI))
      {
        this.GDf.fag();
        this.xpI = false;
      }
      dzu();
      this.GDe.clear();
      releaseWakeLock();
      AppMethodBeat.o(36279);
      return;
    }
  }
  
  public final void Zu(int paramInt)
  {
    AppMethodBeat.i(36291);
    this.GDe.remove(paramInt);
    AppMethodBeat.o(36291);
  }
  
  protected final void Zv(int paramInt)
  {
    AppMethodBeat.i(36298);
    paramInt = Math.max(0, paramInt);
    this.GzZ.GAa.eZC().yEw.seek(paramInt);
    if ((this.GDf != null) && (this.GDf.hxZ > 0L)) {
      this.GzZ.GAa.eZC().yEw.Vr((int)this.GDf.hxZ);
    }
    AppMethodBeat.o(36298);
  }
  
  public final void a(t.a.a parama)
  {
    AppMethodBeat.i(36292);
    Object localObject = parama.fileName;
    if ((bt.isNullOrNil((String)localObject)) || (this.GBZ == null))
    {
      AppMethodBeat.o(36292);
      return;
    }
    parama = (a)this.GBZ.get(localObject);
    if (parama == null)
    {
      AppMethodBeat.o(36292);
      return;
    }
    bl localbl = parama.dbD;
    if ((localbl == null) || (localbl.field_imgPath == null) || (!localbl.field_imgPath.equals(localObject)))
    {
      AppMethodBeat.o(36292);
      return;
    }
    localObject = ch(localbl);
    if (localObject == null)
    {
      AppMethodBeat.o(36292);
      return;
    }
    if (((!localbl.cjN()) && (localbl.eMl())) || (((s)localObject).status == 198))
    {
      if (b(parama)) {
        Toast.makeText(this.GzZ.GAa, 2131764677, 0).show();
      }
      AppMethodBeat.o(36292);
      return;
    }
    int i = com.tencent.mm.modelvideo.u.g((s)localObject);
    k localk = YW(parama.pos);
    if ((this.GzZ.GAa.getCurrentItem() == parama.pos) && (localk != null))
    {
      localk.fac().GDO.setVisibility(0);
      localk.fac().GDO.setProgress(i);
    }
    while (i < localk.fac().GDO.getMax())
    {
      AppMethodBeat.o(36292);
      return;
      if (localk == null)
      {
        AppMethodBeat.o(36292);
        return;
      }
    }
    ad.d("MicroMsg.Imagegallery.handler.video", "onNotifyChange, status:%d", new Object[] { Integer.valueOf(((s)localObject).status) });
    if (((((s)localObject).status == 199) || (((s)localObject).status == 199)) && (b(parama))) {
      i = this.GzZ.GAa.wO(localbl.field_msgId);
    }
    switch (i)
    {
    default: 
      ad.w("MicroMsg.Imagegallery.handler.video", "enterVideoOpCode[%d] is error", new Object[] { Integer.valueOf(i) });
      AppMethodBeat.o(36292);
      return;
    case 0: 
    case 3: 
      a(localbl, (s)localObject, this.GzZ.GAa.getCurrentItem(), false);
      AppMethodBeat.o(36292);
      return;
    case 1: 
      ad.d("MicroMsg.Imagegallery.handler.video", "do restransmit video");
      com.tencent.mm.plugin.report.service.h.vKh.idkeyStat(354L, 15L, 1L, false);
      this.GzZ.bU(localbl);
      this.GzZ.GAa.wP(-1L);
      if (this.xpI)
      {
        i = this.GzZ.eZs().GDN.getCurrentPosition();
        com.tencent.mm.modelvideo.u.e(this.filename, i, this.xpI);
        this.GDl = true;
      }
      this.xpI = false;
      AppMethodBeat.o(36292);
      return;
    }
    com.tencent.mm.plugin.report.service.h.vKh.idkeyStat(354L, 16L, 1L, false);
    b.a(this.GzZ.GAa, localbl);
    this.GzZ.GAa.wP(-1L);
    if (this.xpI)
    {
      i = this.GzZ.eZs().GDN.getCurrentPosition();
      com.tencent.mm.modelvideo.u.e(this.filename, i, this.xpI);
      this.GDl = true;
    }
    this.xpI = false;
    AppMethodBeat.o(36292);
  }
  
  public final boolean a(k paramk, bl parambl, int paramInt)
  {
    AppMethodBeat.i(36262);
    super.a(paramk, parambl, paramInt);
    Object localObject1 = cj(parambl);
    if (parambl == null)
    {
      ad.e("MicroMsg.Imagegallery.handler.video", "msg is null!!");
      AppMethodBeat.o(36262);
      return false;
    }
    if (this.GBZ != null) {
      this.GBZ.put(parambl.field_imgPath, new a(parambl, paramInt));
    }
    while (localObject1 == null)
    {
      AppMethodBeat.o(36262);
      return false;
      ad.e("MicroMsg.Imagegallery.handler.video", "mCacheMap is null!");
    }
    if (parambl.cjN())
    {
      localObject1 = ci(parambl);
      if (localObject1 != null)
      {
        Object localObject2 = com.tencent.mm.pluginsdk.model.r.aAK(((com.tencent.mm.ai.y)localObject1).gKD);
        com.tencent.mm.aw.a.a locala = com.tencent.mm.aw.o.ayJ();
        String str = ((com.tencent.mm.ai.y)localObject1).gKD;
        ImageView localImageView = paramk.fac().GDL;
        c.a locala1 = new c.a();
        locala1.gjt = ((String)localObject2);
        locala1.hjU = true;
        locala.a(str, localImageView, locala1.azc());
        localObject2 = m.GED;
        parambl = m.aKX(((com.tencent.mm.ai.y)localObject1).rD(parambl.field_imgPath));
        if (parambl.DwQ == 1) {
          a(paramk, parambl.DwR);
        }
      }
      else
      {
        if (paramk.fac().GDN.isPlaying()) {
          paramk.fac().GDN.stop();
        }
        if ((paramk.fac().GDN instanceof VideoPlayerTextureView))
        {
          if (!ai.eRQ()) {
            break label376;
          }
          ((VideoPlayerTextureView)paramk.fac().GDN).setScaleType(com.tencent.mm.pluginsdk.ui.h.e.BVs);
        }
      }
    }
    for (;;)
    {
      paramk.GDP.setVisibility(8);
      paramk.fac().GDO.setVisibility(8);
      paramk.fac().GDX.setVisibility(8);
      paramk.b(false, 0.0F);
      this.GDj = 0;
      this.xpM = bt.eGO();
      AppMethodBeat.o(36262);
      return true;
      b(paramk);
      break;
      com.tencent.mm.modelvideo.o.aCI();
      parambl = BackwardSupportUtil.b.n(com.tencent.mm.modelvideo.t.zR(parambl.field_imgPath), 1.0F);
      paramk.fac().GDL.setImageBitmap(parambl);
      b(paramk);
      break;
      label376:
      ((VideoPlayerTextureView)paramk.fac().GDN).setScaleType(com.tencent.mm.pluginsdk.ui.h.e.BVq);
    }
  }
  
  protected final void aCv()
  {
    AppMethodBeat.i(36296);
    k localk = this.GzZ.eZs();
    if (localk == null)
    {
      AppMethodBeat.o(36296);
      return;
    }
    ad.i("MicroMsg.Imagegallery.handler.video", "start to pause");
    this.GzZ.GAa.setVideoStateIv(true);
    localk.fac().GDX.setVisibility(0);
    localk.fac().GDN.pause();
    dzH();
    AppMethodBeat.o(36296);
  }
  
  protected final void aKW(String paramString)
  {
    AppMethodBeat.i(36299);
    if ((!this.GDr) && (!b((a)this.GBZ.get(paramString)))) {
      ad.w("MicroMsg.Imagegallery.handler.video", "show tool bar error.");
    }
    AppMethodBeat.o(36299);
  }
  
  public final void aqt() {}
  
  public final void aqu() {}
  
  public final void aqv() {}
  
  public final void aqw() {}
  
  protected final void at(int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(36295);
    k localk = this.GzZ.eZs();
    if (localk == null)
    {
      AppMethodBeat.o(36295);
      return;
    }
    dzG();
    localk.fac().GDX.setVisibility(8);
    localk.fac().GDN.d(paramInt * 1000, paramBoolean);
    this.GzZ.GAa.setVideoStateIv(false);
    ez(false);
    AppMethodBeat.o(36295);
  }
  
  protected final void bG(final String paramString, final boolean paramBoolean)
  {
    AppMethodBeat.i(36294);
    aq.f(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(36248);
        ad.i("MicroMsg.Imagegallery.handler.video", "prepare video filename %s isOnlinePlay %b ", new Object[] { paramString, Boolean.valueOf(paramBoolean) });
        if (j.m(j.this) == null)
        {
          ad.w("MicroMsg.Imagegallery.handler.video", "prepare video but cache map is null.");
          AppMethodBeat.o(36248);
          return;
        }
        j.a locala = (j.a)j.m(j.this).get(paramString);
        if ((locala == null) || (locala.dbD == null))
        {
          AppMethodBeat.o(36248);
          return;
        }
        s locals = j.ch(locala.dbD);
        if (j.this.GzZ.GAa.getCurrentItem() == locala.pos)
        {
          j.a(j.this, locala.dbD, locals, locala.pos, paramBoolean);
          j.this.aKW(paramString);
          AppMethodBeat.o(36248);
          return;
        }
        ad.w("MicroMsg.Imagegallery.handler.video", "playVideo, but currentItem is not correct.[%d, %d]", new Object[] { Integer.valueOf(j.this.GzZ.GAa.getCurrentItem()), Integer.valueOf(locala.pos) });
        AppMethodBeat.o(36248);
      }
    });
    AppMethodBeat.o(36294);
  }
  
  public final void detach()
  {
    AppMethodBeat.i(36284);
    ad.i("MicroMsg.Imagegallery.handler.video", "detach.[%d]", new Object[] { Integer.valueOf(hashCode()) });
    this.xpN = bt.eGO();
    this.GDo.removeMessages(1);
    dzu();
    com.tencent.mm.sdk.b.a.ESL.d(this.GDd);
    com.tencent.mm.sdk.b.a.ESL.d(this.GDq);
    MV();
    this.GzZ.GAa.getContext().getWindow().clearFlags(128);
    this.GzZ.GAa.eZC().yEw.setIplaySeekCallback(null);
    super.detach();
    this.GBZ.clear();
    this.GBZ = null;
    com.tencent.mm.modelvideo.o.aCI().a(this);
    this.GDe.clear();
    n localn = this.GDf;
    localn.reset();
    localn.xqk = null;
    localn.GEH = null;
    localn.GEI = null;
    if (com.tencent.mm.plugin.o.f.cPm()) {
      az.afE().ax(new j.9(this));
    }
    com.tencent.mm.modelvideo.o.aCN().aDe();
    com.tencent.mm.modelvideo.o.aCN().run();
    AppMethodBeat.o(36284);
  }
  
  protected final boolean dzE()
  {
    AppMethodBeat.i(36297);
    k localk = this.GzZ.eZs();
    if (localk == null)
    {
      AppMethodBeat.o(36297);
      return false;
    }
    boolean bool = true;
    if (!localk.fac().GDN.isPlaying())
    {
      ad.i("MicroMsg.Imagegallery.handler.video", "start to play");
      this.GzZ.GAa.setVideoStateIv(false);
      localk.fac().GDX.setVisibility(8);
      bool = localk.fac().GDN.start();
      dzG();
    }
    if (localk.fac().GDX.getVisibility() != 8) {
      localk.fac().GDX.setVisibility(8);
    }
    AppMethodBeat.o(36297);
    return bool;
  }
  
  public final void eZU()
  {
    AppMethodBeat.i(36285);
    this.GDh = false;
    this.qmp = 0;
    if (this.GzZ != null) {}
    for (Object localObject = this.GzZ.eZs(); localObject == null; localObject = null)
    {
      ad.w("MicroMsg.Imagegallery.handler.video", "notify video prepared, but holder is null.");
      AppMethodBeat.o(36285);
      return;
    }
    final int i = bt.vN(((k)localObject).fac().GDN.getDuration());
    int j = this.GzZ.GAa.eZC().yEw.getVideoTotalTime();
    ad.i("MicroMsg.Imagegallery.handler.video", "%d videoDuration %d hadSetTotalTime %d", new Object[] { Integer.valueOf(hashCode()), Integer.valueOf(i), Integer.valueOf(j) });
    if ((j <= 0) || (Math.abs(j - i) >= 2)) {
      this.GzZ.GAa.eZC().yEw.setVideoTotalTime(i);
    }
    eZW();
    if ((i == 0) || (i >= 1800))
    {
      ad.w("MicroMsg.Imagegallery.handler.video", "%d repair video duration[%d] error. filename[%s]", new Object[] { Integer.valueOf(hashCode()), Integer.valueOf(i), this.filename });
      i = com.tencent.mm.modelvideo.u.L(i, this.filename);
      ad.i("MicroMsg.Imagegallery.handler.video", "notify video prepared. isOnlinePlay[%b] playDuration[%d] playVideoWhenNotify[%b] hadPlayError[%b].", new Object[] { Boolean.valueOf(this.xpI), Integer.valueOf(i), Boolean.valueOf(this.GDg), Boolean.valueOf(this.GDh) });
      ((k)localObject).fac().GDN.setOneTimeVideoTextureUpdateCallback(this.xpA);
      if (!this.GDg) {
        break label399;
      }
      if (this.xpI) {
        break label347;
      }
      this.GDf.reset();
      dzG();
      at(i, true);
    }
    for (;;)
    {
      ez(false);
      AppMethodBeat.o(36285);
      return;
      az.afE().ax(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(36249);
          Object localObject = j.b(j.this);
          int i = i;
          localObject = com.tencent.mm.modelvideo.u.Ae((String)localObject);
          if (localObject != null)
          {
            int j = ((s)localObject).gOY;
            if ((j <= 0) || (Math.abs(j - i) > 2))
            {
              ((s)localObject).gOY = i;
              ((s)localObject).dtM = 4096;
              ad.i("MicroMsg.VideoLogic", "repair video duration ret %b, duration[%d, %d]", new Object[] { Boolean.valueOf(com.tencent.mm.modelvideo.u.f((s)localObject)), Integer.valueOf(j), Integer.valueOf(i) });
            }
          }
          AppMethodBeat.o(36249);
        }
      });
      break;
      label347:
      localObject = this.GDf;
      if (i > 0)
      {
        ad.i("MicroMsg.OnlineVideoUIHelper", "seek to last duration : ".concat(String.valueOf(i)));
        ((n)localObject).hxW = i;
        ((n)localObject).hxY = true;
        ((n)localObject).hxT = 2;
      }
      this.GDf.oR(0);
    }
    label399:
    if (!this.xpI) {
      at(i, false);
    }
    for (;;)
    {
      Zv(i);
      this.GzZ.GAa.setVideoStateIv(true);
      dzu();
      AppMethodBeat.o(36285);
      return;
      this.GDf.aW(i, false);
    }
  }
  
  public final void eZV()
  {
    AppMethodBeat.i(36286);
    ad.i("MicroMsg.Imagegallery.handler.video", "notify video completion. isOnlinePlay : " + this.xpI);
    dzu();
    releaseWakeLock();
    dzH();
    Object localObject1;
    if ((this.xpI) && (this.GzZ != null) && (this.GzZ.eZs() != null))
    {
      localObject1 = this.GzZ.eZs().fac().GDN;
      if ((localObject1 != null) && (((com.tencent.mm.pluginsdk.ui.tools.h)localObject1).getCurrentPosition() + 2000 < ((com.tencent.mm.pluginsdk.ui.tools.h)localObject1).getDuration())) {
        ad.e("MicroMsg.Imagegallery.handler.video", "notify video completion, but cur pos[%d] is less than duration[%d]", new Object[] { Integer.valueOf(((com.tencent.mm.pluginsdk.ui.tools.h)localObject1).getCurrentPosition()), Integer.valueOf(((com.tencent.mm.pluginsdk.ui.tools.h)localObject1).getDuration()) });
      }
    }
    for (int i = 0;; i = 1)
    {
      if (i != 0)
      {
        aq.f(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(36255);
            j.i(j.this);
            j.a(j.this, j.j(j.this));
            j.e(j.this).ea(false);
            j.k(j.this);
            if (j.d(j.this))
            {
              j.b(j.this, bt.eGO());
              j.g(j.this).fag();
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
                k localk = j.this.GzZ.eZs();
                localk.fac().GDN.stop();
                j.a(j.this, 0);
                j.this.a(localk, locala.dbD, locala.pos);
                j.this.Zv(0);
                if (localk.fac().GDX.getVisibility() != 8) {
                  localk.fac().GDX.setVisibility(8);
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
        i = this.GzZ.eZs().GDN.getCurrentPosition();
        com.tencent.mm.modelvideo.u.e(this.filename, i, this.xpI);
        this.GzZ.eZs().GDN.stop();
        this.GDf.fah();
        i = this.GDp + 1;
        this.GDp = i;
        if (i <= 3)
        {
          localObject1 = (a)this.GBZ.get(this.filename);
          if (localObject1 != null)
          {
            localObject2 = ((a)localObject1).dbD;
            if (localObject2 != null) {}
          }
          else
          {
            AppMethodBeat.o(36286);
            return;
          }
          Object localObject2 = ch(((a)localObject1).dbD);
          a(((a)localObject1).dbD, (s)localObject2, ((a)localObject1).pos, this.xpI);
        }
        AppMethodBeat.o(36286);
        return;
      }
      catch (Exception localException)
      {
        ad.printErrStackTrace("MicroMsg.Imagegallery.handler.video", localException, "notify video completion error[%s]", new Object[] { localException.toString() });
        AppMethodBeat.o(36286);
        return;
      }
    }
  }
  
  protected final void ez(boolean paramBoolean)
  {
    AppMethodBeat.i(36289);
    if (!this.GDh)
    {
      if (this.xpI)
      {
        if (paramBoolean)
        {
          aq.f(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(36257);
              for (;;)
              {
                try
                {
                  if (!bt.isNullOrNil(j.this.GzZ.eZs().fac().GDN.getVideoPath())) {
                    continue;
                  }
                  i = com.tencent.mm.modelvideo.u.L(j.g(j.this).hxV, j.b(j.this));
                  j.g(j.this).oR(i);
                }
                catch (Exception localException)
                {
                  int i;
                  ad.printErrStackTrace("MicroMsg.Imagegallery.handler.video", localException, "start timer error[%s]", new Object[] { localException.toString() });
                  continue;
                }
                j.n(j.this).av(500L, 500L);
                AppMethodBeat.o(36257);
                return;
                i = j.this.GzZ.eZs().fac().GDN.getCurrentPosition() / 1000;
              }
            }
          });
          AppMethodBeat.o(36289);
          return;
        }
        this.xdT.av(500L, 500L);
        AppMethodBeat.o(36289);
        return;
      }
      this.nBf.av(500L, 500L);
    }
    AppMethodBeat.o(36289);
  }
  
  protected final int getPlayVideoDuration()
  {
    AppMethodBeat.i(36302);
    if (this.xpX < 0) {
      this.xpX = 0;
    }
    ad.i("MicroMsg.Imagegallery.handler.video", "get[%s] play video duration [%d]", new Object[] { this.filename, Integer.valueOf(this.xpX) });
    int i = this.xpX;
    AppMethodBeat.o(36302);
    return i;
  }
  
  protected final int getUiStayTime()
  {
    AppMethodBeat.i(36303);
    if ((this.xpN > 0L) && (this.xpM > 0L)) {}
    for (int i = (int)(this.xpN - this.xpM);; i = 0)
    {
      int j = i;
      if (i < 0) {
        j = 0;
      }
      ad.i("MicroMsg.Imagegallery.handler.video", "%d filename[%s] get ui stay time[%d %d %d]", new Object[] { Integer.valueOf(hashCode()), this.filename, Integer.valueOf(j), Long.valueOf(this.xpN), Long.valueOf(this.xpM) });
      AppMethodBeat.o(36303);
      return j;
    }
  }
  
  public final void j(final bl parambl, final int paramInt)
  {
    AppMethodBeat.i(36270);
    ad.i("MicroMsg.Imagegallery.handler.video", "toggle video");
    if (parambl == null)
    {
      AppMethodBeat.o(36270);
      return;
    }
    if ((!b.m(parambl)) && (!b.bO(parambl)))
    {
      AppMethodBeat.o(36270);
      return;
    }
    final s locals = cj(parambl);
    this.filename = locals.getFileName();
    if ((locals.status == 199) || (locals.status == 123)) {}
    final boolean bool2;
    Object localObject1;
    for (boolean bool1 = true;; bool1 = false)
    {
      bool2 = bool1;
      if (parambl.cjN())
      {
        ad.i("MicroMsg.Imagegallery.handler.video", "MP_VIDEO toggle mp video,status : %d", new Object[] { Integer.valueOf(locals.status) });
        com.tencent.mm.modelvideo.o.aCI();
        localObject1 = com.tencent.mm.modelvideo.t.zQ(parambl.field_imgPath);
        bool2 = bool1;
        if (bool1)
        {
          bool2 = bool1;
          if (!com.tencent.mm.vfs.i.eK((String)localObject1))
          {
            bool2 = false;
            locals.status = 111;
            com.tencent.mm.modelvideo.o.aCI().c(locals);
            ad.i("MicroMsg.Imagegallery.handler.video", "MP_VIDEO_WARN user delete local file,reset video info status");
          }
        }
      }
      if (!parambl.cjN()) {
        break label894;
      }
      localObject1 = ci(parambl);
      if (localObject1 != null) {
        break;
      }
      ad.w("MicroMsg.Imagegallery.handler.video", "MP_VIDEO_ERROR mpShareVideoInfo is null");
      AppMethodBeat.o(36270);
      return;
    }
    ad.i("MicroMsg.Imagegallery.handler.video", "mpVideo videoDownload %b, playKey %s", new Object[] { Boolean.valueOf(bool2), ((com.tencent.mm.ai.y)localObject1).rD(parambl.field_imgPath) });
    Object localObject2 = m.GED;
    localObject2 = m.aiG(((com.tencent.mm.ai.y)localObject1).rD(parambl.field_imgPath));
    Object localObject3 = m.GED;
    localObject3 = m.aKX(((com.tencent.mm.ai.y)localObject1).rD(parambl.field_imgPath));
    if (((bsg)localObject3).DwQ == 1)
    {
      ad.i("MicroMsg.Imagegallery.handler.video", "MP_VIDEO block video");
      a(YW(paramInt), ((bsg)localObject3).DwR);
      AppMethodBeat.o(36270);
      return;
    }
    b(YW(paramInt));
    if ((!bt.isNullOrNil((String)localObject2)) && ((locals.gTY <= 0) || (!((String)localObject2).equals(locals.hAq.gJv))))
    {
      ad.i("MicroMsg.Imagegallery.handler.video", "MP_VIDEO  update video info. playUrl:%s, length:%d", new Object[] { localObject2, Integer.valueOf(((bsg)localObject3).CVe) });
      locals.hAq.gJv = ((String)localObject2);
      locals.gTY = ((bsg)localObject3).CVe;
      com.tencent.mm.modelvideo.o.aCI().c(locals);
    }
    localObject2 = new WeakReference(this);
    localObject3 = m.GED;
    Object localObject4 = parambl.field_imgPath;
    localObject3 = new IPCRunCgi.a()
    {
      public final void a(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, com.tencent.mm.al.b paramAnonymousb)
      {
        AppMethodBeat.i(36239);
        if ((paramAnonymousInt1 == 0) && (paramAnonymousInt2 == 0))
        {
          ad.i("MicroMsg.Imagegallery.handler.video", "MP_VIDEO  end do exchange video link success");
          paramAnonymousString = (ayj)paramAnonymousb.gUT.gUX;
          paramAnonymousb = m.GED;
          m.a(this.GCZ.rD(parambl.field_imgPath), paramAnonymousString);
          if ((this.GDu.get() == null) || (j.a((j)this.GDu.get())))
          {
            AppMethodBeat.o(36239);
            return;
          }
          paramAnonymousb = (j)this.GDu.get();
          k localk = paramAnonymousb.YW(paramInt);
          if (paramAnonymousString.DwQ == 1)
          {
            ad.w("MicroMsg.Imagegallery.handler.video", "doGetPlayUrl block %s", new Object[] { paramAnonymousString.DwR });
            j.a(paramAnonymousb, paramAnonymousb.YW(paramInt));
            com.tencent.mm.modelvideo.o.aCI();
            com.tencent.mm.vfs.i.deleteFile(com.tencent.mm.modelvideo.t.zQ(parambl.field_imgPath));
            locals.status = 111;
            com.tencent.mm.modelvideo.o.aCI().c(locals);
            if (paramAnonymousb.GzZ.eZs() == localk) {
              j.a(paramAnonymousb, localk, paramAnonymousString.DwR);
            }
            AppMethodBeat.o(36239);
            return;
          }
          if (!bool2)
          {
            locals.gOY = paramAnonymousString.CVe;
            locals.hAq.gJv = paramAnonymousString.vNV;
            com.tencent.mm.modelvideo.o.aCI().c(locals);
          }
          if ((!bool2) && (paramAnonymousb.GzZ.eZs() == localk) && (!paramAnonymousb.GzZ.GAa.dPO())) {
            paramAnonymousb.j(parambl, paramInt);
          }
          AppMethodBeat.o(36239);
          return;
        }
        ad.w("MicroMsg.Imagegallery.handler.video", "MP_VIDEO_ERROR  end do exchange video link fail %d/%d %s", new Object[] { Integer.valueOf(paramAnonymousInt2), Integer.valueOf(paramAnonymousInt1), paramAnonymousString });
        AppMethodBeat.o(36239);
      }
    };
    d.g.b.k.h(localObject1, "mPShareVideoInfo");
    d.g.b.k.h(localObject4, "imgPath");
    d.g.b.k.h(localObject3, "callBack");
    localObject2 = ((com.tencent.mm.ai.y)localObject1).rD((String)localObject4);
    long l = com.tencent.mm.model.y.arz().E((String)localObject2, true).aa(m.GEz);
    int i;
    if (Math.abs(System.currentTimeMillis() - l) < 300000L)
    {
      d.g.b.k.g(localObject2, "key");
      if (!bt.isNullOrNil(m.aiG((String)localObject2)))
      {
        ad.i(m.TAG, "not do cgi in 5 min");
        i = 0;
      }
    }
    while ((i != 0) && (!bool2))
    {
      parambl = YW(paramInt);
      if (parambl != null)
      {
        parambl.fac();
        parambl.fac().GDM.setVisibility(8);
        parambl.fac().GDX.setVisibility(0);
      }
      AppMethodBeat.o(36270);
      return;
      if ((m.GEC.containsKey(localObject2)) && (m.GEC.get(localObject2) != null))
      {
        localObject4 = m.GEC.get(localObject2);
        if (localObject4 == null) {
          d.g.b.k.fvU();
        }
        if (((Boolean)localObject4).booleanValue())
        {
          ad.w(m.TAG, (String)localObject2 + " is doing");
          i = 0;
          continue;
        }
      }
      ad.i(m.TAG, "MP_VIDEO  start do exchange video link");
      localObject4 = (Map)m.GEC;
      d.g.b.k.g(localObject2, "key");
      ((Map)localObject4).put(localObject2, Boolean.TRUE);
      localObject4 = new v.e();
      ((v.e)localObject4).Jhw = new WeakReference(localObject3);
      localObject3 = new ayi();
      ((ayi)localObject3).gGC = ((com.tencent.mm.ai.y)localObject1).CEg;
      ((ayi)localObject3).DwO = ((com.tencent.mm.ai.y)localObject1).CEf;
      ((ayi)localObject3).DwP = ((com.tencent.mm.ai.y)localObject1).videoUrl;
      localObject1 = new b.a();
      ((b.a)localObject1).gUU = ((com.tencent.mm.bx.a)localObject3);
      ((b.a)localObject1).gUV = ((com.tencent.mm.bx.a)new ayj());
      ((b.a)localObject1).uri = "/cgi-bin/mmbiz-bin/appmsg/getplayurl";
      ((b.a)localObject1).funcId = 2962;
      ((b.a)localObject1).reqCmdId = 0;
      ((b.a)localObject1).respCmdId = 0;
      IPCRunCgi.a(((b.a)localObject1).atI(), (IPCRunCgi.a)new m.a((String)localObject2, (v.e)localObject4));
      i = 1;
    }
    label894:
    b(YW(paramInt));
    if ((this.xpI) && (this.GDf != null) && (this.GDf.hxY))
    {
      ad.i("MicroMsg.Imagegallery.handler.video", "%d it loading video data, do not response button click.", new Object[] { Integer.valueOf(hashCode()) });
      AppMethodBeat.o(36270);
      return;
    }
    if (this.GzZ.GAa.dPO())
    {
      e(YW(paramInt));
      d(YW(paramInt));
      this.GzZ.GAa.setVideoStateIv(true);
      this.GzZ.GAa.qmv.stopTimer();
      this.nnt.ea(false);
      releaseWakeLock();
      ad.i("MicroMsg.Imagegallery.handler.video", "toggle pause video.");
      AppMethodBeat.o(36270);
      return;
    }
    az.arV();
    if (!com.tencent.mm.model.c.isSDCardAvailable())
    {
      com.tencent.mm.ui.base.t.g(this.GzZ.GAa.getContext(), null);
      AppMethodBeat.o(36270);
      return;
    }
    int j;
    if (this.xpI)
    {
      j = 0;
      i = j;
    }
    for (;;)
    {
      try
      {
        if (this.GzZ.eZs().GDN != null) {
          i = this.GzZ.eZs().GDN.getCurrentPosition() / 1000;
        }
        if (this.GDf != null) {
          if (this.GDf.oS(i))
          {
            ad.i("MicroMsg.Imagegallery.handler.video", "toggle play video");
            a(parambl, locals, paramInt, this.xpI);
            if (this.GzZ.GAa.GCP) {
              this.GzZ.GAa.eZN();
            }
            eZW();
            this.zqF = ((PowerManager)aj.getContext().getSystemService("power")).newWakeLock(536870922, "MicroMsg.Imagegallery.handler.video");
            this.zqF.acquire();
            ad.i("MicroMsg.Imagegallery.handler.video", "acquire wakelock");
            AppMethodBeat.o(36270);
            return;
          }
        }
      }
      catch (Exception localException)
      {
        ad.printErrStackTrace("MicroMsg.Imagegallery.handler.video", localException, "", new Object[0]);
        i = j;
        continue;
        ad.i("MicroMsg.Imagegallery.handler.video", "toggle start timer.");
        ez(false);
        continue;
        ad.w("MicroMsg.Imagegallery.handler.video", "%d toggle video but online video helper is null.", new Object[] { Integer.valueOf(hashCode()) });
        continue;
      }
      if (parambl.field_isSend == 0)
      {
        if ((locals.status != 113) && (locals.status != 198)) {
          break label1412;
        }
        a(parambl, locals);
      }
      for (;;)
      {
        if (parambl.field_isSend != 1) {
          break label1513;
        }
        i = locals.status;
        if ((i != 111) && (i != 113) && (i != 112) && (i != 121) && (i != 122)) {
          break label1515;
        }
        ad.i("MicroMsg.Imagegallery.handler.video", "download video. msg talker[%s], info status[%d]", new Object[] { parambl.field_talker, Integer.valueOf(i) });
        a(parambl, locals);
        break;
        label1412:
        if (locals.status == 199) {
          a(parambl, locals, paramInt, false);
        }
        if (locals.status == 111) {
          a(parambl, locals);
        }
        if (locals.status == 112) {
          a(parambl, locals);
        }
        if ((locals.status == 121) || (locals.status == 122)) {
          a(parambl, locals);
        }
        if (locals.status == 123) {
          a(parambl, locals, paramInt, false);
        }
      }
      label1513:
      continue;
      label1515:
      a(parambl, locals, paramInt, false);
    }
  }
  
  public final void ju(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(36287);
    boolean bool2 = this.xpI;
    Object localObject = this.GDf;
    boolean bool1;
    if ((!bt.isNullOrNil(((n)localObject).mediaId)) && (((n)localObject).hxS == 1))
    {
      bool1 = true;
      ad.e("MicroMsg.Imagegallery.handler.video", "notify video error, what %d, extras %d isOnlinePlay %b isLoading %b ", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Boolean.valueOf(bool2), Boolean.valueOf(bool1) });
      this.GDh = true;
      this.qmp = paramInt2;
      if (!this.xpI) {
        break label281;
      }
      if (paramInt1 != -1) {
        break label193;
      }
      dzu();
      this.GzZ.eZs().GDN.stop();
      this.GDf.fah();
    }
    label193:
    do
    {
      for (;;)
      {
        this.GDr = false;
        this.GzZ.GAa.setVideoStateIv(true);
        this.GzZ.eZs().fac().GDX.setVisibility(0);
        dzH();
        com.tencent.mm.plugin.report.service.h.vKh.idkeyStat(354L, 18L, 1L, false);
        AppMethodBeat.o(36287);
        return;
        bool1 = false;
        break;
        if (paramInt1 != -2) {
          break label256;
        }
        dzu();
        paramInt1 = this.GzZ.eZs().GDN.getCurrentPosition();
        com.tencent.mm.modelvideo.u.e(this.filename, paramInt1, this.xpI);
        this.GzZ.eZs().GDN.stop();
        this.GDf.fah();
      }
    } while (paramInt1 != -3);
    label256:
    this.GDh = false;
    this.GDf.fah();
    AppMethodBeat.o(36287);
    return;
    label281:
    com.tencent.mm.modelvideo.u.Ah(this.filename);
    dzH();
    if ((this.GzZ != null) && (this.GzZ.eZs() != null) && (this.GzZ.eZs().GDN != null))
    {
      localObject = this.GzZ.eZs().GDN.getVideoPath();
      this.GzZ.eZs().GDN.stop();
    }
    while (this.GDi)
    {
      ad.i("MicroMsg.Imagegallery.handler.video", "%d had play completion don't show error tips", new Object[] { Integer.valueOf(hashCode()) });
      AppMethodBeat.o(36287);
      return;
      localObject = "";
    }
    aq.f(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(36256);
        if ((j.this.GzZ == null) || (j.this.GzZ.eZs() == null) || (j.m(j.this) == null))
        {
          ad.w("MicroMsg.Imagegallery.handler.video", "show error alert but adapter is null.");
          AppMethodBeat.o(36256);
          return;
        }
        j.this.GzZ.eZs().b(false, 0.0F);
        if (!bt.isNullOrNil(this.qmz)) {
          ad.e("MicroMsg.Imagegallery.handler.video", "mediaplay play video error, use third player.[%s]", new Object[] { this.qmz });
        }
        try
        {
          Object localObject2 = new Intent();
          ((Intent)localObject2).setAction("android.intent.action.VIEW");
          com.tencent.mm.sdk.platformtools.m.a(j.this.GzZ.GAa, (Intent)localObject2, new com.tencent.mm.vfs.e(this.qmz), "video/*");
          Object localObject1 = j.this.GzZ.GAa;
          localObject2 = new com.tencent.mm.hellhoundlib.b.a().bd(localObject2);
          com.tencent.mm.hellhoundlib.a.a.a(localObject1, ((com.tencent.mm.hellhoundlib.b.a)localObject2).adn(), "com/tencent/mm/ui/chatting/gallery/ImageGalleryVideoHandler$5", "run", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          ((ImageGalleryUI)localObject1).startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject2).lS(0));
          com.tencent.mm.hellhoundlib.a.a.a(localObject1, "com/tencent/mm/ui/chatting/gallery/ImageGalleryVideoHandler$5", "run", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          localObject1 = (j.a)j.m(j.this).get(j.b(j.this));
          if ((localObject1 == null) || (((j.a)localObject1).dbD == null))
          {
            AppMethodBeat.o(36256);
            return;
          }
        }
        catch (Exception localException)
        {
          for (;;)
          {
            ad.e("MicroMsg.Imagegallery.handler.video", "startActivity fail, activity not found");
            com.tencent.mm.ui.base.h.j(j.this.GzZ.GAa, 2131758931, 2131758932);
          }
          j.this.Zu(localException.pos);
          AppMethodBeat.o(36256);
        }
      }
    });
    com.tencent.mm.plugin.report.service.h.vKh.idkeyStat(354L, 25L, 1L, false);
    AppMethodBeat.o(36287);
  }
  
  public final void k(bl parambl, int paramInt)
  {
    AppMethodBeat.i(36273);
    ad.i("MicroMsg.Imagegallery.handler.video", "toggleVideoMenu pos ");
    s locals = com.tencent.mm.modelvideo.u.Ae(parambl.field_imgPath);
    if ((locals != null) && (!locals.aCW()))
    {
      d(YW(paramInt));
      this.GzZ.GAa.setVideoStateIv(true);
      if (this.xpI)
      {
        this.GDf.fag();
        this.GDf.reset();
      }
      a(parambl, locals);
      if (this.GzZ.GAa.wO(parambl.field_msgId) == 2)
      {
        gb(parambl.field_imgPath, 8);
        AppMethodBeat.o(36273);
        return;
      }
      gb(parambl.field_imgPath, 5);
    }
    AppMethodBeat.o(36273);
  }
  
  protected final void onResume()
  {
    AppMethodBeat.i(36282);
    ad.i("MicroMsg.Imagegallery.handler.video", "ui on resume, add online video event.");
    this.GDo.removeMessages(1);
    com.tencent.mm.sdk.b.a.ESL.c(this.GDq);
    if ((this.GzZ != null) && (com.tencent.mm.compatible.util.d.lf(21)))
    {
      k localk = this.GzZ.eZs();
      if ((localk != null) && (localk.GDN != null))
      {
        if ((localk.GDN instanceof VideoPlayerTextureView))
        {
          ((VideoPlayerTextureView)localk.GDN).bej();
          AppMethodBeat.o(36282);
          return;
        }
        if ((localk.GDN instanceof VideoTextureView)) {
          ((VideoTextureView)localk.GDN).bej();
        }
      }
    }
    AppMethodBeat.o(36282);
  }
  
  public final void pause(int paramInt)
  {
    AppMethodBeat.i(36267);
    d(YW(paramInt));
    this.nnt.ea(false);
    this.GzZ.GAa.setVideoStateIv(true);
    AppMethodBeat.o(36267);
  }
  
  public static final class a
  {
    public bl dbD;
    public int pos;
    
    public a(bl parambl, int paramInt)
    {
      this.dbD = parambl;
      this.pos = paramInt;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.gallery.j
 * JD-Core Version:    0.7.0.1
 */