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
import com.tencent.mm.g.a.nx;
import com.tencent.mm.g.a.nx.a;
import com.tencent.mm.g.c.ei;
import com.tencent.mm.ipcinvoker.wx_extension.IPCRunCgi;
import com.tencent.mm.ipcinvoker.wx_extension.IPCRunCgi.a;
import com.tencent.mm.model.ba;
import com.tencent.mm.model.d.a;
import com.tencent.mm.model.w;
import com.tencent.mm.model.y.b;
import com.tencent.mm.modelsimple.aa;
import com.tencent.mm.modelvideo.s;
import com.tencent.mm.modelvideo.t.a;
import com.tencent.mm.modelvideo.t.a.a;
import com.tencent.mm.modelvideo.y.a;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.pluginsdk.ui.i.e;
import com.tencent.mm.pluginsdk.ui.tools.RedesignVideoPlayerSeekBar;
import com.tencent.mm.pluginsdk.ui.tools.VideoPlayerTextureView;
import com.tencent.mm.pluginsdk.ui.tools.VideoTextureView;
import com.tencent.mm.pluginsdk.ui.tools.h.e;
import com.tencent.mm.protocal.protobuf.bge;
import com.tencent.mm.protocal.protobuf.bgf;
import com.tencent.mm.protocal.protobuf.bxm;
import com.tencent.mm.protocal.protobuf.cbn;
import com.tencent.mm.protocal.protobuf.dki;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.b;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.ap.a;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.av;
import com.tencent.mm.sdk.platformtools.av.a;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.sdk.platformtools.n;
import com.tencent.mm.storage.ai;
import com.tencent.mm.storage.al.a;
import com.tencent.mm.storage.bu;
import com.tencent.mm.ui.al;
import com.tencent.mm.ui.chatting.ak;
import com.tencent.mm.ui.chatting.ak.a;
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
  private static com.tencent.mm.ai.y JSL = null;
  public static boolean JSM = false;
  private HashMap<String, a> JRl;
  private com.tencent.mm.sdk.b.c JSC;
  final SparseArray<s> JSD;
  private o JSE;
  private boolean JSF;
  private boolean JSG;
  private boolean JSH;
  private int JSI;
  private int JSJ;
  private boolean JSK;
  ap JSN;
  private int JSO;
  private com.tencent.mm.sdk.b.c<nx> JSP;
  private boolean JSQ;
  private int JSR;
  private int[] JSS;
  private String filename;
  private PowerManager.WakeLock gKs;
  private long lastCheckTime;
  private long ltq;
  private av oHz;
  private com.tencent.mm.model.d ota;
  int rFf;
  private int rFg;
  private com.tencent.mm.plugin.sight.decode.ui.b rFm;
  private com.tencent.mm.plugin.o.b vLz;
  private av zHS;
  private h.e zTL;
  private boolean zTT;
  private long zTX;
  private long zTY;
  private long zUh;
  private int zUi;
  
  public j(b paramb)
  {
    super(paramb);
    AppMethodBeat.i(36261);
    this.JSD = new SparseArray();
    this.JSF = false;
    this.JSG = false;
    this.JSH = false;
    this.rFg = 0;
    this.ltq = 0L;
    this.lastCheckTime = 0L;
    this.JSI = 0;
    this.JSJ = 0;
    this.zTX = 0L;
    this.zTY = 0L;
    this.rFf = 0;
    this.JSK = false;
    this.JSN = new ap(Looper.getMainLooper(), new ap.a()
    {
      public final boolean handleMessage(Message paramAnonymousMessage)
      {
        AppMethodBeat.i(36254);
        if (paramAnonymousMessage.what == 1)
        {
          paramAnonymousMessage = j.this.JPj.fFM();
          if ((paramAnonymousMessage != null) && (!bt.isNullOrNil(j.b(j.this))))
          {
            ad.i("MicroMsg.Imagegallery.handler.video", "%d ui on pause, pause video now. %s", new Object[] { Integer.valueOf(hashCode()), j.b(j.this) });
            if (!j.c(j.this)) {
              com.tencent.mm.modelvideo.u.e(j.b(j.this), paramAnonymousMessage.fGB().JTl.getCurrentPosition(), j.d(j.this));
            }
            j.g(paramAnonymousMessage);
            j.b(j.this, paramAnonymousMessage);
            j.e(j.this).ex(false);
            if (j.d(j.this))
            {
              com.tencent.mm.sdk.b.a.IbL.d(j.f(j.this));
              j.g(j.this).fGF();
              j.a(j.this, false);
            }
          }
          j.h(j.this);
        }
        AppMethodBeat.o(36254);
        return false;
      }
    });
    this.JSO = 0;
    this.zHS = new av(new av.a()
    {
      public final boolean onTimerExpired()
      {
        AppMethodBeat.i(36258);
        if (!j.g(j.this).isStreaming())
        {
          AppMethodBeat.o(36258);
          return false;
        }
        k localk = j.this.JPj.fFM();
        if (localk == null)
        {
          AppMethodBeat.o(36258);
          return false;
        }
        if (localk.JTi == null)
        {
          AppMethodBeat.o(36258);
          return false;
        }
        if (localk.fGB().JTi.getVisibility() != 0)
        {
          AppMethodBeat.o(36258);
          return false;
        }
        boolean bool = true;
        if (localk.fGB().JTl.isPlaying()) {
          bool = j.c(j.this, localk);
        }
        if (bool)
        {
          int i = localk.fGB().JTl.getCurrentPosition() / 1000;
          bool = j.g(j.this).qi(i);
          AppMethodBeat.o(36258);
          return bool;
        }
        AppMethodBeat.o(36258);
        return false;
      }
    }, true);
    this.oHz = new av(new av.a()
    {
      public final boolean onTimerExpired()
      {
        AppMethodBeat.i(36259);
        if (j.this.JPj == null)
        {
          ad.w("MicroMsg.Imagegallery.handler.video", "[onTimerExpired] null == adapter");
          AppMethodBeat.o(36259);
          return false;
        }
        k localk = j.this.JPj.fFM();
        if (localk == null)
        {
          AppMethodBeat.o(36259);
          return false;
        }
        if (localk.JTi == null)
        {
          AppMethodBeat.o(36259);
          return false;
        }
        if (localk.fGB().JTi.getVisibility() != 0)
        {
          AppMethodBeat.o(36259);
          return false;
        }
        int i = j.this.JPj.JPk.getCurrentItem();
        if ((s)j.this.JSD.get(i) == null)
        {
          j.this.adS(i);
          AppMethodBeat.o(36259);
          return false;
        }
        if (!localk.fGB().JTl.isPlaying())
        {
          ad.i("MicroMsg.Imagegallery.handler.video", "it is not playing, stop offline timer");
          AppMethodBeat.o(36259);
          return false;
        }
        j.a(j.this, localk.fGB().JTl.getCurrentPosition());
        j.this.adT(j.o(j.this) / 1000);
        AppMethodBeat.o(36259);
        return true;
      }
    }, true);
    this.rFm = new com.tencent.mm.plugin.sight.decode.ui.b()
    {
      public final void aqD()
      {
        AppMethodBeat.i(36244);
        if (j.this.JPj.fFM() != null) {
          j.b(j.this, j.this.JPj.fFM());
        }
        j.this.JPj.JPk.rFl.stopTimer();
        AppMethodBeat.o(36244);
      }
      
      public final void nM(int paramAnonymousInt)
      {
        AppMethodBeat.i(36245);
        localObject = null;
        try
        {
          String str = j.this.JPj.fFM().fGB().JTl.getVideoPath();
          localObject = str;
        }
        catch (Exception localException)
        {
          for (;;)
          {
            ad.printErrStackTrace("MicroMsg.Imagegallery.handler.video", localException, "", new Object[0]);
            ad.e("MicroMsg.Imagegallery.handler.video", "on seek get video path error: " + localException.toString());
            continue;
            boolean bool = j.g(j.this).bh(paramAnonymousInt, true);
            continue;
            localObject = j.this.JPj.fFL();
            if ((localObject != null) && (((bu)localObject).cxf())) {
              com.tencent.mm.modelvideo.u.e(((ei)localObject).field_imgPath, paramAnonymousInt * 1000, j.d(j.this));
            }
            j.this.JPj.adA(j.this.JPj.JPk.getCurrentItem());
          }
        }
        ad.i("MicroMsg.Imagegallery.handler.video", "on seek to time[%d] isOnlinePlay[%b] videoPath[%s]", new Object[] { Integer.valueOf(paramAnonymousInt), Boolean.valueOf(j.d(j.this)), localObject });
        j.this.JPj.fFM().fGB().JTk.setVisibility(8);
        if (!bt.isNullOrNil((String)localObject)) {
          if (!j.d(j.this))
          {
            j.this.aB(paramAnonymousInt, true);
            bool = true;
            if (bool) {
              j.this.eV(false);
            }
            j.this.JPj.JPk.fGn();
            localObject = j.this.JPj.fFL();
            if ((localObject != null) && (((bu)localObject).cxg())) {
              j.this.JPj.JPk.JRs.i((bu)localObject, 13);
            }
            AppMethodBeat.o(36245);
            return;
          }
        }
      }
    };
    this.JSP = new com.tencent.mm.sdk.b.c()
    {
      private boolean a(nx paramAnonymousnx)
      {
        AppMethodBeat.i(36246);
        if (!j.g(j.this).aAK(paramAnonymousnx.dBK.mediaId))
        {
          AppMethodBeat.o(36246);
          return false;
        }
        if ((paramAnonymousnx.dBK.retCode != 0) && (paramAnonymousnx.dBK.retCode != -21006))
        {
          ad.w("MicroMsg.Imagegallery.handler.video", "stream download online video error. retCode: " + paramAnonymousnx.dBK.retCode);
          j.a(j.this, paramAnonymousnx.dBK.mediaId, paramAnonymousnx.dBK.retCode);
          AppMethodBeat.o(36246);
          return false;
        }
        switch (paramAnonymousnx.dBK.dsi)
        {
        default: 
          ad.w("MicroMsg.Imagegallery.handler.video", "unknown event opcode " + paramAnonymousnx.dBK.dsi);
        }
        for (;;)
        {
          AppMethodBeat.o(36246);
          return false;
          o localo = j.g(j.this);
          long l2 = paramAnonymousnx.dBK.offset;
          long l1 = paramAnonymousnx.dBK.dBL;
          boolean bool = paramAnonymousnx.dBK.dBM;
          ad.i("MicroMsg.OnlineVideoUIHelper", "deal moov ready moovPos[%d] needSeekTime[%d] timeDuration[%d] startDownload[%d %d]", new Object[] { Long.valueOf(l2), Integer.valueOf(localo.irT), Integer.valueOf(localo.irS), Long.valueOf(l1), Long.valueOf(localo.fJC) });
          if (localo.irS != 0) {
            ad.w("MicroMsg.OnlineVideoUIHelper", "moov had callback, do nothing.");
          }
          for (;;)
          {
            j.a(j.this, true);
            break;
            if (l1 > localo.fJC) {}
            for (;;)
            {
              for (;;)
              {
                localo.fJC = l1;
                g.yhR.idkeyStat(354L, 5L, 1L, false);
                localo.zUz = bt.flT();
                com.tencent.mm.modelvideo.o.aMJ();
                paramAnonymousnx = com.tencent.mm.modelvideo.t.Hh(localo.filename);
                try
                {
                  if (localo.zUv != null) {
                    break label435;
                  }
                  ad.w("MicroMsg.OnlineVideoUIHelper", "parser is null, thread is error.");
                }
                catch (Exception paramAnonymousnx)
                {
                  ad.printErrStackTrace("MicroMsg.OnlineVideoUIHelper", paramAnonymousnx, "", new Object[0]);
                  ad.e("MicroMsg.OnlineVideoUIHelper", "deal moov ready error: " + paramAnonymousnx.toString());
                }
              }
              break;
              l1 = localo.fJC;
            }
            label435:
            if (localo.zUv.L(paramAnonymousnx, l2))
            {
              localo.irS = localo.zUv.iQJ;
              ad.i("MicroMsg.OnlineVideoUIHelper", "mp4 parse moov success. duration %d filename %s isFastStart %b", new Object[] { Integer.valueOf(localo.irS), localo.filename, Boolean.valueOf(bool) });
              if (!bool) {
                aq.f(new o.1(localo));
              }
              if (localo.irT == -1) {}
              for (localo.irQ = 1;; localo.irQ = 2)
              {
                g.yhR.idkeyStat(354L, 7L, 1L, false);
                break;
              }
            }
            ad.w("MicroMsg.OnlineVideoUIHelper", "mp4 parse moov error.");
            com.tencent.mm.modelvideo.o.aMK();
            com.tencent.mm.ao.e.r(localo.mediaId, 0, -1);
            com.tencent.mm.modelvideo.u.au(localo.filename, 15);
            g.yhR.idkeyStat(354L, 8L, 1L, false);
            ad.w("MicroMsg.OnlineVideoUIHelper", "%d rpt parse moov fail %s ", new Object[] { Integer.valueOf(localo.hashCode()), localo.filename });
            g.yhR.f(13836, new Object[] { Integer.valueOf(302), Long.valueOf(bt.aQJ()), "" });
          }
          localo = j.g(j.this);
          Object localObject = paramAnonymousnx.dBK.mediaId;
          int i = paramAnonymousnx.dBK.offset;
          int j = paramAnonymousnx.dBK.length;
          localo.irZ = false;
          if ((i < 0) || (j < 0)) {
            ad.w("MicroMsg.OnlineVideoUIHelper", "deal data available error offset[%d], length[%d]", new Object[] { Integer.valueOf(i), Integer.valueOf(j) });
          }
          while (!localo.aAK((String)localObject))
          {
            if (paramAnonymousnx.dBK.length <= 0) {
              break;
            }
            j.this.eV(true);
            break;
          }
          localObject = localo.mediaId + i + "_" + j;
          localObject = (Integer)localo.zUu.get(localObject);
          if ((localObject != null) && (((Integer)localObject).intValue() > 0)) {
            localo.irW = ((Integer)localObject).intValue();
          }
          for (;;)
          {
            ad.i("MicroMsg.OnlineVideoUIHelper", "deal data available. offset[%d] length[%d] cachePlayTime[%d]", new Object[] { Integer.valueOf(i), Integer.valueOf(j), Integer.valueOf(localo.irW) });
            break;
            try
            {
              localo.irW = localo.zUv.dy(i, j);
            }
            catch (Exception localException)
            {
              ad.printErrStackTrace("MicroMsg.OnlineVideoUIHelper", localException, "", new Object[0]);
              ad.e("MicroMsg.OnlineVideoUIHelper", "deal data available file pos to video time error: " + localException.toString());
            }
          }
          j.this.eV(true);
          continue;
          paramAnonymousnx = j.g(j.this);
          ad.i("MicroMsg.OnlineVideoUIHelper", "deal stream finish. playStatus %d ", new Object[] { Integer.valueOf(paramAnonymousnx.irQ) });
          paramAnonymousnx.irZ = false;
          paramAnonymousnx.irP = 3;
          if (paramAnonymousnx.irQ == 0)
          {
            ad.w("MicroMsg.OnlineVideoUIHelper", "it had not moov callback and download finish start to play video.");
            paramAnonymousnx.eaB();
            g.yhR.idkeyStat(354L, 6L, 1L, false);
          }
          for (;;)
          {
            paramAnonymousnx.fGH();
            g.yhR.idkeyStat(354L, 26L, 1L, false);
            j.this.eV(true);
            break;
            if (paramAnonymousnx.irQ == 5)
            {
              ad.w("MicroMsg.OnlineVideoUIHelper", "it had play error, it request all video data finish, start to play." + paramAnonymousnx.mediaId);
              paramAnonymousnx.eaB();
            }
          }
          localo = j.g(j.this);
          String str = paramAnonymousnx.dBK.mediaId;
          i = paramAnonymousnx.dBK.offset;
          if (localo.aAK(str))
          {
            if (localo.jFP != 0) {
              localo.zUx = (i * 100 / localo.jFP);
            }
            ad.i("MicroMsg.OnlineVideoUIHelper", "deal progress callback. downloadedPercent : " + localo.zUx);
          }
          if (localo.zUx >= 100)
          {
            localo.irP = 3;
            continue;
            paramAnonymousnx = j.g(j.this);
            ad.i("MicroMsg.OnlineVideoUIHelper", "deal had dup video.");
            paramAnonymousnx.fGH();
            paramAnonymousnx.eaB();
          }
        }
      }
    };
    this.JSQ = false;
    this.JSR = 0;
    this.JSS = new int[] { -1000, -2000, 3400 };
    this.zTL = new h.e()
    {
      public final void boT()
      {
        AppMethodBeat.i(36250);
        ad.i("MicroMsg.Imagegallery.handler.video", "%d on texture update.", new Object[] { Integer.valueOf(j.this.hashCode()) });
        try
        {
          j.this.JPj.fFM().c(true, 1.0F);
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
    this.vLz = new com.tencent.mm.plugin.o.b()
    {
      public final long dmn()
      {
        AppMethodBeat.i(36251);
        ad.i("MicroMsg.Imagegallery.handler.video", "%d video get online cache sec", new Object[] { Integer.valueOf(j.this.hashCode()) });
        ba.aBQ();
        com.tencent.mm.model.c.ajl().set(al.a.IxQ, Boolean.TRUE);
        try
        {
          if ((j.d(j.this)) && (j.g(j.this) != null))
          {
            int i = j.g(j.this).irW;
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
    JSL = null;
    this.JRl = new HashMap();
    this.JSE = new o(this);
    com.tencent.mm.sdk.b.a locala = com.tencent.mm.sdk.b.a.IbL;
    paramb = new ak(ak.a.JEi, paramb.JPk);
    this.JSC = paramb;
    locala.c(paramb);
    com.tencent.mm.sdk.b.a.IbL.c(this.JSP);
    this.ota = new com.tencent.mm.model.d();
    AppMethodBeat.o(36261);
  }
  
  private void a(bu parambu, s params)
  {
    AppMethodBeat.i(36275);
    if ((!com.tencent.mm.network.ae.cP(this.JPj.JPk.getContext())) && (!JSM)) {
      JSM = true;
    }
    b(parambu, params);
    AppMethodBeat.o(36275);
  }
  
  private void a(bu parambu, s params, int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(36274);
    if ((parambu == null) || (params == null))
    {
      AppMethodBeat.o(36274);
      return;
    }
    if ((!parambu.cxg()) && (parambu.frT()))
    {
      Toast.makeText(this.JPj.JPk, 2131764677, 0).show();
      AppMethodBeat.o(36274);
      return;
    }
    Object localObject3;
    Object localObject1;
    if (params.iul == -1)
    {
      localObject3 = params.aMU();
      localObject1 = localObject3;
      if (!com.tencent.mm.vfs.i.fv((String)localObject3))
      {
        com.tencent.mm.modelvideo.o.aMJ();
        localObject1 = com.tencent.mm.modelvideo.t.Hh(parambu.field_imgPath);
        if ((localObject1 != null) && (com.tencent.mm.vfs.i.fv((String)localObject1))) {
          break label336;
        }
        Toast.makeText(this.JPj.JPk, 2131764677, 0).show();
        AppMethodBeat.o(36274);
      }
    }
    else
    {
      com.tencent.mm.modelvideo.o.aMJ();
      localObject3 = com.tencent.mm.modelvideo.t.Hh(parambu.field_imgPath);
      localObject1 = localObject3;
      if (parambu.field_isSend == 1)
      {
        localObject1 = localObject3;
        if (params.iuo != null)
        {
          localObject1 = localObject3;
          if (!params.iuo.GRA) {}
        }
      }
    }
    for (;;)
    {
      try
      {
        String str = com.tencent.mm.vfs.i.aYr((String)localObject3);
        localObject1 = str;
        if (!str.endsWith("/")) {
          localObject1 = str + "/";
        }
        str = com.tencent.mm.vfs.i.aYt((String)localObject3);
        localObject1 = (String)localObject1 + str + "_hd.mp4";
        bool = com.tencent.mm.vfs.i.fv((String)localObject1);
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
      localObject3 = adu(paramInt);
      if (localObject3 == null)
      {
        AppMethodBeat.o(36274);
        return;
      }
      int i = 0;
      if (w.vF(params.getUser())) {
        i = com.tencent.mm.model.q.yS(params.getUser());
      }
      boolean bool = com.tencent.mm.modelvideo.r.GW(localObject2);
      int j = this.JPj.JPk.Ej(parambu.field_msgId);
      ad.i("MicroMsg.Imagegallery.handler.video", "play video pos[%d], isOnlinePlay[%b] opcode[%d] resetByCompletion[%b]", new Object[] { Integer.valueOf(paramInt), Boolean.valueOf(paramBoolean), Integer.valueOf(j), Boolean.valueOf(this.JSK) });
      if (!bool)
      {
        if ((com.tencent.mm.compatible.deviceinfo.ae.gcP.fZs == 1) && (com.tencent.mm.pluginsdk.k.b.a.a.b(params.getFileName(), this.JPj.JPk.getContext(), bool)))
        {
          AppMethodBeat.o(36274);
          return;
        }
        ba.aBQ();
        if ((((Integer)com.tencent.mm.model.c.ajl().get(al.a.Iwy, Integer.valueOf(0))).intValue() == 1) && (((k)localObject3).JTn != null))
        {
          ((k)localObject3).JTn.setVisibility(0);
          ((k)localObject3).JTn.setText(com.tencent.mm.plugin.sight.base.e.aqM(localObject2));
        }
        ((k)localObject3).a(params.hHQ, params.hMP, i, params.getUser(), s.GY(params.aMV()), params.createTime);
        this.zTT = paramBoolean;
        this.JSF = true;
        this.filename = params.getFileName();
        if (j == 3)
        {
          ((k)localObject3).fGB().JTl.setMute(true);
          if ((((k)localObject3).fGB().JTl.getVideoPath() == null) || (!((k)localObject3).fGB().JTl.getVideoPath().equals(localObject2)) || (((k)localObject3).fGB().JTl.isPlaying()) || (this.JSK)) {
            break label822;
          }
          ((k)localObject3).c(true, 1.0F);
          ((k)localObject3).fGB().JTl.start();
          ear();
          if (!paramBoolean) {
            aWt(this.filename);
          }
          adT(((k)localObject3).fGB().JTl.getCurrentPosition() / 1000);
          eV(false);
          label740:
          b(paramInt, params);
          this.JPj.JPk.setVideoStateIv(false);
          this.JPj.JPk.getContext().getWindow().addFlags(128);
          this.ota.a(this);
        }
      }
      for (;;)
      {
        ((k)localObject3).fGB().JTm.setVisibility(8);
        AppMethodBeat.o(36274);
        return;
        ((k)localObject3).fGB().JTl.setMute(false);
        break;
        label822:
        this.JSH = false;
        this.JSK = false;
        ((k)localObject3).fGB().JTl.setVideoPath(localObject2);
        if ((((k)localObject3).fGB().JTl instanceof VideoPlayerTextureView))
        {
          ((VideoPlayerTextureView)((k)localObject3).fGB().JTl).setIOnlineCache(this.vLz);
          ((VideoPlayerTextureView)((k)localObject3).fGB().JTl).setNeedResetExtractor(cxy());
          ((VideoPlayerTextureView)((k)localObject3).fGB().JTl).setIsOnlineVideoType(paramBoolean);
        }
        ((k)localObject3).c(true, 0.0F);
        break label740;
        g.yhR.f(12084, new Object[] { Integer.valueOf(params.hMP), Integer.valueOf(params.hHQ * 1000), Integer.valueOf(0), Integer.valueOf(3), params.getUser(), Integer.valueOf(i), s.GY(params.aMV()), Long.valueOf(params.createTime) });
        if (!com.tencent.mm.pluginsdk.k.b.a.a.c(localObject2, this.JPj.JPk.getContext(), bool)) {
          Toast.makeText(this.JPj.JPk.getContext(), this.JPj.JPk.getString(2131764691), 0).show();
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
      paramk.fGB();
      paramk.fGB().JTo.setVisibility(0);
      paramk.fGB().JTp.setText(bt.bI(paramString, this.JPj.JPk.getString(2131764692)));
      paramk.fGB().JTj.setVisibility(0);
      paramk.fGB().JTk.setVisibility(8);
      c(paramk);
      AppMethodBeat.o(36271);
      return;
    }
    AppMethodBeat.o(36271);
  }
  
  private void b(int paramInt, s params)
  {
    AppMethodBeat.i(36290);
    this.JSD.put(paramInt, params);
    AppMethodBeat.o(36290);
  }
  
  private void b(bu parambu, s params)
  {
    AppMethodBeat.i(36276);
    ad.i("MicroMsg.Imagegallery.handler.video", "startDownloading [%d]", new Object[] { Integer.valueOf(hashCode()) });
    if ((parambu == null) || (params == null))
    {
      AppMethodBeat.o(36276);
      return;
    }
    k localk = this.JPj.fFM();
    if (localk == null)
    {
      AppMethodBeat.o(36276);
      return;
    }
    aa.R(parambu);
    int i = this.JPj.JPk.Ej(parambu.field_msgId);
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
      if ((this.JSE.aWv(parambu.field_imgPath)) || (this.JSE.c(parambu, params)))
      {
        ad.i("MicroMsg.Imagegallery.handler.video", "start online play video.");
        this.zTT = true;
        com.tencent.mm.modelvideo.o.aMJ().a(this);
        localk.fGB().JTk.setVisibility(8);
        localk.fGB().JTm.setVisibility(8);
        localk.fGB().JTv.setVisibility(0);
        AppMethodBeat.o(36276);
        return;
      }
      ad.i("MicroMsg.Imagegallery.handler.video", "start offline play video.");
      this.zTT = false;
      com.tencent.mm.modelvideo.o.aMJ().a(this, Looper.getMainLooper());
      com.tencent.mm.modelvideo.u.Ht(parambu.field_imgPath);
      localk.fGB().JTk.setVisibility(8);
      localk.fGB().JTm.setVisibility(0);
      localk.fGB().JTm.setProgress(com.tencent.mm.modelvideo.u.g(params));
      AppMethodBeat.o(36276);
      return;
    }
    if (params.aMX())
    {
      ad.i("MicroMsg.Imagegallery.handler.video", "start complete online video");
      com.tencent.mm.modelvideo.u.HF(parambu.field_imgPath);
    }
    for (;;)
    {
      com.tencent.mm.modelvideo.o.aMJ().a(this, Looper.getMainLooper());
      localk.fGB().JTk.setVisibility(8);
      localk.fGB().JTm.setVisibility(0);
      localk.fGB().JTm.setProgress(com.tencent.mm.modelvideo.u.g(params));
      if (i != 2) {
        break;
      }
      fGx();
      AppMethodBeat.o(36276);
      return;
      ad.i("MicroMsg.Imagegallery.handler.video", "start complete offline video");
      gC(parambu.field_imgPath, 10);
      com.tencent.mm.modelvideo.u.Ht(parambu.field_imgPath);
    }
    fGw();
    AppMethodBeat.o(36276);
  }
  
  private static void b(k paramk)
  {
    AppMethodBeat.i(36272);
    if (paramk != null)
    {
      paramk.fGB();
      paramk.fGB().JTo.setVisibility(8);
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
    com.tencent.mm.modelvideo.o.aMJ().a(this);
    if (this.JPj.JPk.getCurrentItem() == parama.pos)
    {
      parama = adu(parama.pos);
      if (parama != null)
      {
        parama.fGB().JTv.setVisibility(8);
        parama.fGB().JTm.setVisibility(8);
        parama.fGB().JTk.setVisibility(8);
      }
      this.JSQ = true;
      this.JPj.JPk.fGe();
      AppMethodBeat.o(36278);
      return true;
    }
    this.JPj.adC(parama.pos);
    AppMethodBeat.o(36278);
    return false;
  }
  
  private static com.tencent.mm.ai.y bk(Activity paramActivity)
  {
    AppMethodBeat.i(36264);
    byte[] arrayOfByte;
    if (JSL == null)
    {
      arrayOfByte = paramActivity.getIntent().getByteArrayExtra("img_gallery_mp_share_video_info");
      if (bt.cC(arrayOfByte))
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
      JSL = localy;
      paramActivity = JSL;
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
    eae();
    if (paramk == null)
    {
      AppMethodBeat.o(36280);
      return;
    }
    eas();
    if (this.zTT) {
      this.JSE.fGF();
    }
    if (!this.JSG) {
      com.tencent.mm.modelvideo.u.e(this.filename, this.rFg - 1000, this.zTT);
    }
    paramk.fGB().JTm.setVisibility(8);
    paramk.fGB().JTv.setVisibility(8);
    paramk.fGB().JTl.stop();
    adT(0);
    paramk.c(false, 0.0F);
    this.zTT = false;
    this.JSQ = false;
    this.JSK = false;
    this.filename = null;
    this.zUi = 0;
    this.zUh = 0L;
    this.JSR = 0;
    this.JSO = 0;
    this.JSJ = 0;
    this.JSI = 0;
    this.ltq = 0L;
    this.lastCheckTime = 0L;
    AppMethodBeat.o(36280);
  }
  
  public static s cq(bu parambu)
  {
    AppMethodBeat.i(36263);
    if (!b.m(parambu))
    {
      AppMethodBeat.o(36263);
      return null;
    }
    parambu = com.tencent.mm.modelvideo.u.Hy(parambu.field_imgPath);
    AppMethodBeat.o(36263);
    return parambu;
  }
  
  public static com.tencent.mm.ai.y cr(bu parambu)
  {
    AppMethodBeat.i(36265);
    if (parambu.frw())
    {
      parambu = new com.tencent.mm.ai.y().a(parambu.IMf);
      AppMethodBeat.o(36265);
      return parambu;
    }
    parambu = k.b.aA(parambu.field_content, parambu.field_reserved);
    if (parambu == null)
    {
      ad.w("MicroMsg.Imagegallery.handler.video", "getVideoInfo content is null");
      AppMethodBeat.o(36265);
      return null;
    }
    parambu = (com.tencent.mm.ai.e)parambu.ao(com.tencent.mm.ai.e.class);
    if ((parambu != null) && (parambu.hzo != null)) {}
    for (parambu = parambu.hzo;; parambu = null)
    {
      AppMethodBeat.o(36265);
      return parambu;
    }
  }
  
  private static s cs(bu parambu)
  {
    AppMethodBeat.i(36269);
    s locals = cq(parambu);
    if (locals != null)
    {
      AppMethodBeat.o(36269);
      return locals;
    }
    ad.i("MicroMsg.Imagegallery.handler.video", "insert video info:" + parambu.toString());
    locals = new s();
    locals.dDy = parambu.field_talker;
    locals.fileName = parambu.field_imgPath;
    if (parambu.field_createTime <= 0L) {}
    for (long l = System.currentTimeMillis();; l = parambu.field_createTime)
    {
      locals.createTime = l;
      locals.dAY = parambu.field_msgSvrId;
      locals.iuk = parambu.field_content;
      locals.iuf = ((int)parambu.field_msgId);
      com.tencent.mm.ai.y localy = cr(parambu);
      if (localy != null)
      {
        if (TextUtils.isEmpty(parambu.field_imgPath))
        {
          parambu.tO(com.tencent.mm.modelvideo.t.Hg(parambu.field_talker));
          ba.aBQ();
          com.tencent.mm.model.c.azs().a(parambu.field_msgId, parambu);
        }
        locals.fileName = parambu.field_imgPath;
        m localm = m.JUb;
        locals.a(bt.bI(m.asA(localy.yx(parambu.field_imgPath)), localy.videoUrl), localy.videoDuration, localy.title, localy.FCb, "", "", "");
        locals.status = 111;
      }
      com.tencent.mm.modelvideo.o.aMJ().b(locals);
      AppMethodBeat.o(36269);
      return locals;
    }
  }
  
  private boolean cxy()
  {
    AppMethodBeat.i(36307);
    if (!this.zTT)
    {
      AppMethodBeat.o(36307);
      return false;
    }
    ba.aBQ();
    boolean bool = com.tencent.mm.model.c.ajl().getBoolean(al.a.IxQ, false);
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
    eae();
    ad.d("MicroMsg.Imagegallery.handler.video", "pause video.");
    if (paramk.fGB().JTl.isPlaying())
    {
      paramk.fGB().JTl.pause();
      eas();
    }
    AppMethodBeat.o(36281);
  }
  
  private static void e(k paramk)
  {
    AppMethodBeat.i(36283);
    if (paramk != null)
    {
      paramk.fGB();
      if (paramk.fGB().JTl.isPlaying()) {
        k.aH(paramk.fGB().JTk, 0);
      }
      AppMethodBeat.o(36283);
      return;
    }
    AppMethodBeat.o(36283);
  }
  
  private void eae()
  {
    AppMethodBeat.i(36288);
    ad.i("MicroMsg.Imagegallery.handler.video", "clear timer");
    this.zHS.stopTimer();
    this.oHz.stopTimer();
    AppMethodBeat.o(36288);
  }
  
  private void ear()
  {
    AppMethodBeat.i(36300);
    this.zUh = bt.flT();
    ad.d("MicroMsg.Imagegallery.handler.video", "notePlayVideo filename %s notePlayVideo %d ", new Object[] { this.filename, Long.valueOf(this.zUh) });
    if ((this.JPj != null) && (this.JPj.JPk != null)) {
      this.JPj.JPk.JRs.cl(this.JPj.fFL());
    }
    AppMethodBeat.o(36300);
  }
  
  private void eas()
  {
    AppMethodBeat.i(36301);
    if (this.zUh > 0L) {
      this.zUi = ((int)(this.zUi + (bt.flT() - this.zUh) / 1000L));
    }
    ad.i("MicroMsg.Imagegallery.handler.video", "notePauseVideo filename %s playVideoDuration %d ", new Object[] { this.filename, Integer.valueOf(this.zUi) });
    this.zUh = 0L;
    if ((this.JPj != null) && (this.JPj.JPk != null)) {
      this.JPj.JPk.JRs.ck(this.JPj.fFL());
    }
    AppMethodBeat.o(36301);
  }
  
  public static bu f(String paramString, Activity paramActivity)
  {
    AppMethodBeat.i(36266);
    bu localbu = new bu();
    localbu.setType(486539313);
    localbu.tN(paramString);
    localbu.IMg = true;
    localbu.IMf = bk(paramActivity);
    localbu.tO(paramActivity.getIntent().getStringExtra("img_gallery_path"));
    AppMethodBeat.o(36266);
    return localbu;
  }
  
  private boolean f(k paramk)
  {
    AppMethodBeat.i(36304);
    int i = this.rFg;
    this.rFg = paramk.fGB().JTl.getCurrentPosition();
    int j;
    if (i != this.rFg)
    {
      this.lastCheckTime = bt.flT();
      long l = paramk.fGB().JTl.getLastSurfaceUpdateTime();
      if ((l > 0L) && (l != this.ltq))
      {
        this.ltq = l;
        j = this.JSI;
        switch (j)
        {
        default: 
          this.JSI = 0;
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
          g.yhR.idkeyStat(354L, i, 1L, false);
          g.yhR.f(13836, new Object[] { Integer.valueOf(301), Long.valueOf(bt.aQJ()), "" });
          break;
          i = 22;
          continue;
          i = 23;
        }
        if (this.JSI != -1)
        {
          this.JSI += 1;
          ad.w("MicroMsg.Imagegallery.handler.video", "media play is playing[%d], but surface is not update!! repair time[%d]", new Object[] { Integer.valueOf(this.JSI), Integer.valueOf(this.JSJ) });
          if (this.JSJ >= 2) {
            this.JSE.fGG();
          }
          switch (this.JSI)
          {
          case 0: 
          case 1: 
          default: 
            ad.w("MicroMsg.Imagegallery.handler.video", "rpt surface not update!!");
            ad.w("MicroMsg.Imagegallery.handler.video", "%d rpt rptSurfaceNotUpdate %s", new Object[] { Integer.valueOf(hashCode()), this.filename });
            g.yhR.f(13836, new Object[] { Integer.valueOf(300), Long.valueOf(bt.aQJ()), "" });
            g.yhR.idkeyStat(354L, 20L, 1L, false);
            this.JSI = -1;
          }
        }
      }
      i = this.rFg / 1000;
      ad.w("MicroMsg.Imagegallery.handler.video", "surface not update, it try seek time[%d] to repair.", new Object[] { Integer.valueOf(i) });
      aB(i, true);
      this.JSJ += 1;
      AppMethodBeat.o(36304);
      return false;
      j = (this.rFg - 2000) / 1000;
      i = j;
      if (j < 0) {
        i = 0;
      }
      ad.w("MicroMsg.Imagegallery.handler.video", "surface not update, it try seek time[%d] to repair.", new Object[] { Integer.valueOf(i) });
      aB(i, true);
      this.JSJ += 1;
      AppMethodBeat.o(36304);
      return false;
      j = (this.rFg - 4000) / 1000;
      i = j;
      if (j < 0) {
        i = 0;
      }
      ad.w("MicroMsg.Imagegallery.handler.video", "surface not update, it try seek time[%d] to repair.", new Object[] { Integer.valueOf(i) });
      aB(i, true);
      this.JSJ += 1;
      AppMethodBeat.o(36304);
      return false;
      ad.i("MicroMsg.Imagegallery.handler.video", "check time[%d, %d], play time[%d, %d]", new Object[] { Long.valueOf(this.lastCheckTime), Long.valueOf(bt.flT()), Integer.valueOf(i), Integer.valueOf(this.rFg) });
    } while ((this.lastCheckTime <= 0L) || (bt.Df(this.lastCheckTime) < 1500L));
    ad.w("MicroMsg.Imagegallery.handler.video", "play time not update! request all video data to play. ");
    i = this.JPj.fFM().JTl.getCurrentPosition();
    eae();
    com.tencent.mm.modelvideo.u.e(this.filename, i, this.zTT);
    this.JPj.fFM().JTl.stop();
    this.JSE.fGG();
    paramk = (a)this.JRl.get(this.filename);
    if ((paramk == null) || (paramk.dku == null))
    {
      AppMethodBeat.o(36304);
      return false;
    }
    s locals = cq(paramk.dku);
    a(paramk.dku, locals, paramk.pos, this.zTT);
    this.lastCheckTime = 0L;
    AppMethodBeat.o(36304);
    return false;
  }
  
  private void fGv()
  {
    AppMethodBeat.i(36293);
    try
    {
      this.JPj.JPk.fFW().Bjp.setIplaySeekCallback(this.rFm);
      AppMethodBeat.o(36293);
      return;
    }
    catch (Exception localException)
    {
      AppMethodBeat.o(36293);
    }
  }
  
  private static void fGw()
  {
    AppMethodBeat.i(36305);
    g.yhR.idkeyStat(354L, 11L, 1L, false);
    AppMethodBeat.o(36305);
  }
  
  private static void fGx()
  {
    AppMethodBeat.i(36306);
    g.yhR.idkeyStat(354L, 14L, 1L, false);
    AppMethodBeat.o(36306);
  }
  
  private void gC(final String paramString, final int paramInt)
  {
    AppMethodBeat.i(36277);
    ba.ajF().ay(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(36253);
        com.tencent.mm.modelvideo.u.av(paramString, paramInt);
        AppMethodBeat.o(36253);
      }
    });
    AppMethodBeat.o(36277);
  }
  
  private void releaseWakeLock()
  {
    AppMethodBeat.i(36268);
    if ((this.gKs != null) && (this.gKs.isHeld()))
    {
      ad.i("MicroMsg.Imagegallery.handler.video", "release waklock");
      this.gKs.release();
    }
    AppMethodBeat.o(36268);
  }
  
  public final void OC()
  {
    AppMethodBeat.i(36279);
    ad.i("MicroMsg.Imagegallery.handler.video", "stopAll. video handler hash code : " + hashCode());
    this.zTY = bt.flT();
    SparseArray localSparseArray = this.JPj.JoS;
    int j = 0;
    int i = 0;
    if (j < localSparseArray.size())
    {
      int k = localSparseArray.keyAt(j);
      if ((localSparseArray.get(k) == null) || (((View)localSparseArray.get(k)).getTag() == null)) {
        break label253;
      }
      k localk = (k)((View)localSparseArray.get(k)).getTag();
      if ((localk.JTi == null) || (localk.fGB().JTi.getVisibility() != 0) || ((((View)localk.fGB().JTl).getVisibility() != 0) && (bt.isNullOrNil(localk.fGB().JTl.getVideoPath())) && ((!this.zTT) || (!this.JSE.isStreaming())))) {
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
      this.ota.ex(false);
      if ((i == 0) && (this.zTT))
      {
        this.JSE.fGF();
        this.zTT = false;
      }
      eae();
      this.JSD.clear();
      releaseWakeLock();
      AppMethodBeat.o(36279);
      return;
    }
  }
  
  public final void a(t.a.a parama)
  {
    AppMethodBeat.i(36292);
    Object localObject = parama.fileName;
    if ((bt.isNullOrNil((String)localObject)) || (this.JRl == null))
    {
      AppMethodBeat.o(36292);
      return;
    }
    parama = (a)this.JRl.get(localObject);
    if (parama == null)
    {
      AppMethodBeat.o(36292);
      return;
    }
    bu localbu = parama.dku;
    if ((localbu == null) || (localbu.field_imgPath == null) || (!localbu.field_imgPath.equals(localObject)))
    {
      AppMethodBeat.o(36292);
      return;
    }
    localObject = cq(localbu);
    if (localObject == null)
    {
      AppMethodBeat.o(36292);
      return;
    }
    if (((!localbu.cxg()) && (localbu.frT())) || (((s)localObject).status == 198))
    {
      if (b(parama)) {
        Toast.makeText(this.JPj.JPk, 2131764677, 0).show();
      }
      AppMethodBeat.o(36292);
      return;
    }
    int i = com.tencent.mm.modelvideo.u.g((s)localObject);
    k localk = adu(parama.pos);
    if ((this.JPj.JPk.getCurrentItem() == parama.pos) && (localk != null))
    {
      localk.fGB().JTm.setVisibility(0);
      localk.fGB().JTm.setProgress(i);
    }
    while (i < localk.fGB().JTm.getMax())
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
      i = this.JPj.JPk.Ej(localbu.field_msgId);
    }
    switch (i)
    {
    default: 
      ad.w("MicroMsg.Imagegallery.handler.video", "enterVideoOpCode[%d] is error", new Object[] { Integer.valueOf(i) });
      AppMethodBeat.o(36292);
      return;
    case 0: 
    case 3: 
      a(localbu, (s)localObject, this.JPj.JPk.getCurrentItem(), false);
      AppMethodBeat.o(36292);
      return;
    case 1: 
      ad.d("MicroMsg.Imagegallery.handler.video", "do restransmit video");
      g.yhR.idkeyStat(354L, 15L, 1L, false);
      this.JPj.cd(localbu);
      this.JPj.JPk.Ek(-1L);
      if (this.zTT)
      {
        i = this.JPj.fFM().JTl.getCurrentPosition();
        com.tencent.mm.modelvideo.u.e(this.filename, i, this.zTT);
        this.JSK = true;
      }
      this.zTT = false;
      AppMethodBeat.o(36292);
      return;
    }
    g.yhR.idkeyStat(354L, 16L, 1L, false);
    b.a(this.JPj.JPk, localbu);
    this.JPj.JPk.Ek(-1L);
    if (this.zTT)
    {
      i = this.JPj.fFM().JTl.getCurrentPosition();
      com.tencent.mm.modelvideo.u.e(this.filename, i, this.zTT);
      this.JSK = true;
    }
    this.zTT = false;
    AppMethodBeat.o(36292);
  }
  
  public final boolean a(k paramk, bu parambu, int paramInt)
  {
    AppMethodBeat.i(36262);
    super.a(paramk, parambu, paramInt);
    Object localObject1 = cs(parambu);
    if (parambu == null)
    {
      ad.e("MicroMsg.Imagegallery.handler.video", "msg is null!!");
      AppMethodBeat.o(36262);
      return false;
    }
    if (this.JRl != null) {
      this.JRl.put(parambu.field_imgPath, new a(parambu, paramInt));
    }
    while (localObject1 == null)
    {
      AppMethodBeat.o(36262);
      return false;
      ad.e("MicroMsg.Imagegallery.handler.video", "mCacheMap is null!");
    }
    if (parambu.cxg())
    {
      localObject1 = cr(parambu);
      if (localObject1 != null)
      {
        Object localObject2 = com.tencent.mm.pluginsdk.model.r.aLC(((com.tencent.mm.ai.y)localObject1).hDm);
        com.tencent.mm.aw.a.a locala = com.tencent.mm.aw.q.aIJ();
        String str = ((com.tencent.mm.ai.y)localObject1).hDm;
        ImageView localImageView = paramk.fGB().JTj;
        c.a locala1 = new c.a();
        locala1.hdP = ((String)localObject2);
        locala1.idr = true;
        locala.a(str, localImageView, locala1.aJc());
        localObject2 = m.JUb;
        parambu = m.aWu(((com.tencent.mm.ai.y)localObject1).yx(parambu.field_imgPath));
        if (parambu.GBD == 1) {
          a(paramk, parambu.GBE);
        }
      }
      else
      {
        if (paramk.fGB().JTl.isPlaying()) {
          paramk.fGB().JTl.stop();
        }
        if ((paramk.fGB().JTl instanceof VideoPlayerTextureView))
        {
          if (!al.fxN()) {
            break label376;
          }
          ((VideoPlayerTextureView)paramk.fGB().JTl).setScaleType(i.e.ESO);
        }
      }
    }
    for (;;)
    {
      paramk.JTn.setVisibility(8);
      paramk.fGB().JTm.setVisibility(8);
      paramk.fGB().JTv.setVisibility(8);
      paramk.c(false, 0.0F);
      this.JSI = 0;
      this.zTX = bt.flT();
      AppMethodBeat.o(36262);
      return true;
      b(paramk);
      break;
      com.tencent.mm.modelvideo.o.aMJ();
      parambu = BackwardSupportUtil.b.o(com.tencent.mm.modelvideo.t.Hi(parambu.field_imgPath), 1.0F);
      paramk.fGB().JTj.setImageBitmap(parambu);
      b(paramk);
      break;
      label376:
      ((VideoPlayerTextureView)paramk.fGB().JTl).setScaleType(i.e.ESM);
    }
  }
  
  public final void aAa() {}
  
  public final void aAb() {}
  
  protected final void aB(int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(36295);
    k localk = this.JPj.fFM();
    if (localk == null)
    {
      AppMethodBeat.o(36295);
      return;
    }
    ear();
    localk.fGB().JTv.setVisibility(8);
    localk.fGB().JTl.d(paramInt * 1000, paramBoolean);
    this.JPj.JPk.setVideoStateIv(false);
    eV(false);
    AppMethodBeat.o(36295);
  }
  
  protected final void aMw()
  {
    AppMethodBeat.i(36296);
    k localk = this.JPj.fFM();
    if (localk == null)
    {
      AppMethodBeat.o(36296);
      return;
    }
    ad.i("MicroMsg.Imagegallery.handler.video", "start to pause");
    this.JPj.JPk.setVideoStateIv(true);
    localk.fGB().JTv.setVisibility(0);
    localk.fGB().JTl.pause();
    eas();
    AppMethodBeat.o(36296);
  }
  
  protected final void aWt(String paramString)
  {
    AppMethodBeat.i(36299);
    if ((!this.JSQ) && (!b((a)this.JRl.get(paramString)))) {
      ad.w("MicroMsg.Imagegallery.handler.video", "show tool bar error.");
    }
    AppMethodBeat.o(36299);
  }
  
  public final void adS(int paramInt)
  {
    AppMethodBeat.i(36291);
    this.JSD.remove(paramInt);
    AppMethodBeat.o(36291);
  }
  
  protected final void adT(int paramInt)
  {
    AppMethodBeat.i(36298);
    paramInt = Math.max(0, paramInt);
    this.JPj.JPk.fFW().Bjp.seek(paramInt);
    if ((this.JSE != null) && (this.JSE.irW > 0L)) {
      this.JPj.JPk.fFW().Bjp.Zw((int)this.JSE.irW);
    }
    AppMethodBeat.o(36298);
  }
  
  public final void azY() {}
  
  public final void azZ() {}
  
  protected final void bU(final String paramString, final boolean paramBoolean)
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
        if ((locala == null) || (locala.dku == null))
        {
          AppMethodBeat.o(36248);
          return;
        }
        s locals = j.cq(locala.dku);
        if (j.this.JPj.JPk.getCurrentItem() == locala.pos)
        {
          j.a(j.this, locala.dku, locals, locala.pos, paramBoolean);
          j.this.aWt(paramString);
          AppMethodBeat.o(36248);
          return;
        }
        ad.w("MicroMsg.Imagegallery.handler.video", "playVideo, but currentItem is not correct.[%d, %d]", new Object[] { Integer.valueOf(j.this.JPj.JPk.getCurrentItem()), Integer.valueOf(locala.pos) });
        AppMethodBeat.o(36248);
      }
    });
    AppMethodBeat.o(36294);
  }
  
  public final void detach()
  {
    AppMethodBeat.i(36284);
    ad.i("MicroMsg.Imagegallery.handler.video", "detach.[%d]", new Object[] { Integer.valueOf(hashCode()) });
    this.zTY = bt.flT();
    this.JSN.removeMessages(1);
    eae();
    com.tencent.mm.sdk.b.a.IbL.d(this.JSC);
    com.tencent.mm.sdk.b.a.IbL.d(this.JSP);
    OC();
    this.JPj.JPk.getContext().getWindow().clearFlags(128);
    this.JPj.JPk.fFW().Bjp.setIplaySeekCallback(null);
    super.detach();
    this.JRl.clear();
    this.JRl = null;
    com.tencent.mm.modelvideo.o.aMJ().a(this);
    this.JSD.clear();
    o localo = this.JSE;
    localo.reset();
    localo.zUv = null;
    localo.JUe = null;
    localo.JUf = null;
    if (com.tencent.mm.plugin.o.f.dmp()) {
      ba.ajF().ay(new j.9(this));
    }
    com.tencent.mm.modelvideo.o.aMO().aNf();
    com.tencent.mm.modelvideo.o.aMO().run();
    AppMethodBeat.o(36284);
  }
  
  protected final void eV(boolean paramBoolean)
  {
    AppMethodBeat.i(36289);
    if (!this.JSG)
    {
      if (this.zTT)
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
                  if (!bt.isNullOrNil(j.this.JPj.fFM().fGB().JTl.getVideoPath())) {
                    continue;
                  }
                  i = com.tencent.mm.modelvideo.u.N(j.g(j.this).irS, j.b(j.this));
                  j.g(j.this).qi(i);
                }
                catch (Exception localException)
                {
                  int i;
                  ad.printErrStackTrace("MicroMsg.Imagegallery.handler.video", localException, "start timer error[%s]", new Object[] { localException.toString() });
                  continue;
                }
                j.n(j.this).az(500L, 500L);
                AppMethodBeat.o(36257);
                return;
                i = j.this.JPj.fFM().fGB().JTl.getCurrentPosition() / 1000;
              }
            }
          });
          AppMethodBeat.o(36289);
          return;
        }
        this.zHS.az(500L, 500L);
        AppMethodBeat.o(36289);
        return;
      }
      this.oHz.az(500L, 500L);
    }
    AppMethodBeat.o(36289);
  }
  
  protected final boolean eap()
  {
    AppMethodBeat.i(36297);
    k localk = this.JPj.fFM();
    if (localk == null)
    {
      AppMethodBeat.o(36297);
      return false;
    }
    boolean bool = true;
    if (!localk.fGB().JTl.isPlaying())
    {
      ad.i("MicroMsg.Imagegallery.handler.video", "start to play");
      this.JPj.JPk.setVideoStateIv(false);
      localk.fGB().JTv.setVisibility(8);
      bool = localk.fGB().JTl.start();
      ear();
    }
    if (localk.fGB().JTv.getVisibility() != 8) {
      localk.fGB().JTv.setVisibility(8);
    }
    AppMethodBeat.o(36297);
    return bool;
  }
  
  public final void fGt()
  {
    AppMethodBeat.i(36285);
    this.JSG = false;
    this.rFf = 0;
    if (this.JPj != null) {}
    for (Object localObject = this.JPj.fFM(); localObject == null; localObject = null)
    {
      ad.w("MicroMsg.Imagegallery.handler.video", "notify video prepared, but holder is null.");
      AppMethodBeat.o(36285);
      return;
    }
    final int i = bt.Dg(((k)localObject).fGB().JTl.getDuration());
    int j = this.JPj.JPk.fFW().Bjp.getVideoTotalTime();
    ad.i("MicroMsg.Imagegallery.handler.video", "%d videoDuration %d hadSetTotalTime %d", new Object[] { Integer.valueOf(hashCode()), Integer.valueOf(i), Integer.valueOf(j) });
    if ((j <= 0) || (Math.abs(j - i) >= 2)) {
      this.JPj.JPk.fFW().Bjp.setVideoTotalTime(i);
    }
    fGv();
    if ((i == 0) || (i >= 1800))
    {
      ad.w("MicroMsg.Imagegallery.handler.video", "%d repair video duration[%d] error. filename[%s]", new Object[] { Integer.valueOf(hashCode()), Integer.valueOf(i), this.filename });
      i = com.tencent.mm.modelvideo.u.N(i, this.filename);
      ad.i("MicroMsg.Imagegallery.handler.video", "notify video prepared. isOnlinePlay[%b] playDuration[%d] playVideoWhenNotify[%b] hadPlayError[%b].", new Object[] { Boolean.valueOf(this.zTT), Integer.valueOf(i), Boolean.valueOf(this.JSF), Boolean.valueOf(this.JSG) });
      ((k)localObject).fGB().JTl.setOneTimeVideoTextureUpdateCallback(this.zTL);
      if (!this.JSF) {
        break label399;
      }
      if (this.zTT) {
        break label347;
      }
      this.JSE.reset();
      ear();
      aB(i, true);
    }
    for (;;)
    {
      eV(false);
      AppMethodBeat.o(36285);
      return;
      ba.ajF().ay(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(36249);
          Object localObject = j.b(j.this);
          int i = i;
          localObject = com.tencent.mm.modelvideo.u.Hy((String)localObject);
          if (localObject != null)
          {
            int j = ((s)localObject).hHQ;
            if ((j <= 0) || (Math.abs(j - i) > 2))
            {
              ((s)localObject).hHQ = i;
              ((s)localObject).dDp = 4096;
              ad.i("MicroMsg.VideoLogic", "repair video duration ret %b, duration[%d, %d]", new Object[] { Boolean.valueOf(com.tencent.mm.modelvideo.u.f((s)localObject)), Integer.valueOf(j), Integer.valueOf(i) });
            }
          }
          AppMethodBeat.o(36249);
        }
      });
      break;
      label347:
      localObject = this.JSE;
      if (i > 0)
      {
        ad.i("MicroMsg.OnlineVideoUIHelper", "seek to last duration : ".concat(String.valueOf(i)));
        ((o)localObject).irT = i;
        ((o)localObject).irV = true;
        ((o)localObject).irQ = 2;
      }
      this.JSE.qi(0);
    }
    label399:
    if (!this.zTT) {
      aB(i, false);
    }
    for (;;)
    {
      adT(i);
      this.JPj.JPk.setVideoStateIv(true);
      eae();
      AppMethodBeat.o(36285);
      return;
      this.JSE.bh(i, false);
    }
  }
  
  public final void fGu()
  {
    AppMethodBeat.i(36286);
    ad.i("MicroMsg.Imagegallery.handler.video", "notify video completion. isOnlinePlay : " + this.zTT);
    eae();
    releaseWakeLock();
    eas();
    Object localObject1;
    if ((this.zTT) && (this.JPj != null) && (this.JPj.fFM() != null))
    {
      localObject1 = this.JPj.fFM().fGB().JTl;
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
            j.e(j.this).ex(false);
            j.k(j.this);
            if (j.d(j.this))
            {
              j.b(j.this, bt.flT());
              j.g(j.this).fGF();
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
                k localk = j.this.JPj.fFM();
                localk.fGB().JTl.stop();
                j.a(j.this, 0);
                j.this.a(localk, locala.dku, locala.pos);
                j.this.adT(0);
                if (localk.fGB().JTv.getVisibility() != 8) {
                  localk.fGB().JTv.setVisibility(8);
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
        i = this.JPj.fFM().JTl.getCurrentPosition();
        com.tencent.mm.modelvideo.u.e(this.filename, i, this.zTT);
        this.JPj.fFM().JTl.stop();
        this.JSE.fGG();
        i = this.JSO + 1;
        this.JSO = i;
        if (i <= 3)
        {
          localObject1 = (a)this.JRl.get(this.filename);
          if (localObject1 != null)
          {
            localObject2 = ((a)localObject1).dku;
            if (localObject2 != null) {}
          }
          else
          {
            AppMethodBeat.o(36286);
            return;
          }
          Object localObject2 = cq(((a)localObject1).dku);
          a(((a)localObject1).dku, (s)localObject2, ((a)localObject1).pos, this.zTT);
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
  
  protected final int getPlayVideoDuration()
  {
    AppMethodBeat.i(36302);
    if (this.zUi < 0) {
      this.zUi = 0;
    }
    ad.i("MicroMsg.Imagegallery.handler.video", "get[%s] play video duration [%d]", new Object[] { this.filename, Integer.valueOf(this.zUi) });
    int i = this.zUi;
    AppMethodBeat.o(36302);
    return i;
  }
  
  protected final int getUiStayTime()
  {
    AppMethodBeat.i(36303);
    if ((this.zTY > 0L) && (this.zTX > 0L)) {}
    for (int i = (int)(this.zTY - this.zTX);; i = 0)
    {
      int j = i;
      if (i < 0) {
        j = 0;
      }
      ad.i("MicroMsg.Imagegallery.handler.video", "%d filename[%s] get ui stay time[%d %d %d]", new Object[] { Integer.valueOf(hashCode()), this.filename, Integer.valueOf(j), Long.valueOf(this.zTY), Long.valueOf(this.zTX) });
      AppMethodBeat.o(36303);
      return j;
    }
  }
  
  public final void j(final bu parambu, final int paramInt)
  {
    AppMethodBeat.i(36270);
    ad.i("MicroMsg.Imagegallery.handler.video", "toggle video");
    if (parambu == null)
    {
      AppMethodBeat.o(36270);
      return;
    }
    if ((!b.m(parambu)) && (!b.bX(parambu)))
    {
      AppMethodBeat.o(36270);
      return;
    }
    final s locals = cs(parambu);
    this.filename = locals.getFileName();
    if ((locals.status == 199) || (locals.status == 123)) {}
    final boolean bool2;
    Object localObject1;
    for (boolean bool1 = true;; bool1 = false)
    {
      bool2 = bool1;
      if (parambu.cxg())
      {
        ad.i("MicroMsg.Imagegallery.handler.video", "MP_VIDEO toggle mp video,status : %d", new Object[] { Integer.valueOf(locals.status) });
        com.tencent.mm.modelvideo.o.aMJ();
        localObject1 = com.tencent.mm.modelvideo.t.Hh(parambu.field_imgPath);
        bool2 = bool1;
        if (bool1)
        {
          bool2 = bool1;
          if (!com.tencent.mm.vfs.i.fv((String)localObject1))
          {
            bool2 = false;
            locals.status = 111;
            com.tencent.mm.modelvideo.o.aMJ().c(locals);
            ad.i("MicroMsg.Imagegallery.handler.video", "MP_VIDEO_WARN user delete local file,reset video info status");
          }
        }
      }
      if (!parambu.cxg()) {
        break label894;
      }
      localObject1 = cr(parambu);
      if (localObject1 != null) {
        break;
      }
      ad.w("MicroMsg.Imagegallery.handler.video", "MP_VIDEO_ERROR mpShareVideoInfo is null");
      AppMethodBeat.o(36270);
      return;
    }
    ad.i("MicroMsg.Imagegallery.handler.video", "mpVideo videoDownload %b, playKey %s", new Object[] { Boolean.valueOf(bool2), ((com.tencent.mm.ai.y)localObject1).yx(parambu.field_imgPath) });
    Object localObject2 = m.JUb;
    localObject2 = m.asA(((com.tencent.mm.ai.y)localObject1).yx(parambu.field_imgPath));
    Object localObject3 = m.JUb;
    localObject3 = m.aWu(((com.tencent.mm.ai.y)localObject1).yx(parambu.field_imgPath));
    if (((cbn)localObject3).GBD == 1)
    {
      ad.i("MicroMsg.Imagegallery.handler.video", "MP_VIDEO block video");
      a(adu(paramInt), ((cbn)localObject3).GBE);
      AppMethodBeat.o(36270);
      return;
    }
    b(adu(paramInt));
    if ((!bt.isNullOrNil((String)localObject2)) && ((locals.hMP <= 0) || (!((String)localObject2).equals(locals.iun.hCe))))
    {
      ad.i("MicroMsg.Imagegallery.handler.video", "MP_VIDEO  update video info. playUrl:%s, length:%d", new Object[] { localObject2, Integer.valueOf(((cbn)localObject3).FUX) });
      locals.iun.hCe = ((String)localObject2);
      locals.hMP = ((cbn)localObject3).FUX;
      com.tencent.mm.modelvideo.o.aMJ().c(locals);
    }
    localObject2 = new WeakReference(this);
    localObject3 = m.JUb;
    Object localObject4 = parambu.field_imgPath;
    localObject3 = new IPCRunCgi.a()
    {
      public final void a(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, com.tencent.mm.al.b paramAnonymousb)
      {
        AppMethodBeat.i(36239);
        if ((paramAnonymousInt1 == 0) && (paramAnonymousInt2 == 0))
        {
          ad.i("MicroMsg.Imagegallery.handler.video", "MP_VIDEO  end do exchange video link success");
          paramAnonymousString = (bgf)paramAnonymousb.hNL.hNQ;
          paramAnonymousb = m.JUb;
          m.a(this.JSy.yx(parambu.field_imgPath), paramAnonymousString);
          if ((this.JST.get() == null) || (j.a((j)this.JST.get())))
          {
            AppMethodBeat.o(36239);
            return;
          }
          paramAnonymousb = (j)this.JST.get();
          k localk = paramAnonymousb.adu(paramInt);
          if (paramAnonymousString.GBD == 1)
          {
            ad.w("MicroMsg.Imagegallery.handler.video", "doGetPlayUrl block %s", new Object[] { paramAnonymousString.GBE });
            j.a(paramAnonymousb, paramAnonymousb.adu(paramInt));
            com.tencent.mm.modelvideo.o.aMJ();
            com.tencent.mm.vfs.i.deleteFile(com.tencent.mm.modelvideo.t.Hh(parambu.field_imgPath));
            locals.status = 111;
            com.tencent.mm.modelvideo.o.aMJ().c(locals);
            if (paramAnonymousb.JPj.fFM() == localk) {
              j.a(paramAnonymousb, localk, paramAnonymousString.GBE);
            }
            AppMethodBeat.o(36239);
            return;
          }
          if (!bool2)
          {
            locals.hHQ = paramAnonymousString.FUX;
            locals.iun.hCe = paramAnonymousString.yma;
            com.tencent.mm.modelvideo.o.aMJ().c(locals);
          }
          if ((!bool2) && (paramAnonymousb.JPj.fFM() == localk) && (!paramAnonymousb.JPj.JPk.eqE())) {
            paramAnonymousb.j(parambu, paramInt);
          }
          AppMethodBeat.o(36239);
          return;
        }
        ad.w("MicroMsg.Imagegallery.handler.video", "MP_VIDEO_ERROR  end do exchange video link fail %d/%d %s", new Object[] { Integer.valueOf(paramAnonymousInt2), Integer.valueOf(paramAnonymousInt1), paramAnonymousString });
        AppMethodBeat.o(36239);
      }
    };
    p.h(localObject1, "mPShareVideoInfo");
    p.h(localObject4, "imgPath");
    p.h(localObject3, "callBack");
    localObject2 = ((com.tencent.mm.ai.y)localObject1).yx((String)localObject4);
    long l = com.tencent.mm.model.y.aBq().F((String)localObject2, true).wn(m.JTX);
    int i;
    if (Math.abs(System.currentTimeMillis() - l) < 300000L)
    {
      p.g(localObject2, "key");
      if (!bt.isNullOrNil(m.asA((String)localObject2)))
      {
        ad.i(m.TAG, "not do cgi in 5 min");
        i = 0;
      }
    }
    while ((i != 0) && (!bool2))
    {
      parambu = adu(paramInt);
      if (parambu != null)
      {
        parambu.fGB();
        parambu.fGB().JTk.setVisibility(8);
        parambu.fGB().JTv.setVisibility(0);
      }
      AppMethodBeat.o(36270);
      return;
      if ((m.JUa.containsKey(localObject2)) && (m.JUa.get(localObject2) != null))
      {
        localObject4 = m.JUa.get(localObject2);
        if (localObject4 == null) {
          p.gfZ();
        }
        if (((Boolean)localObject4).booleanValue())
        {
          ad.w(m.TAG, (String)localObject2 + " is doing");
          i = 0;
          continue;
        }
      }
      ad.i(m.TAG, "MP_VIDEO  start do exchange video link");
      localObject4 = (Map)m.JUa;
      p.g(localObject2, "key");
      ((Map)localObject4).put(localObject2, Boolean.TRUE);
      localObject4 = new y.f();
      ((y.f)localObject4).MLV = new WeakReference(localObject3);
      localObject3 = new bge();
      ((bge)localObject3).hzm = ((com.tencent.mm.ai.y)localObject1).FCc;
      ((bge)localObject3).GBB = ((com.tencent.mm.ai.y)localObject1).FCb;
      ((bge)localObject3).GBC = ((com.tencent.mm.ai.y)localObject1).videoUrl;
      localObject1 = new b.a();
      ((b.a)localObject1).hNM = ((com.tencent.mm.bx.a)localObject3);
      ((b.a)localObject1).hNN = ((com.tencent.mm.bx.a)new bgf());
      ((b.a)localObject1).uri = "/cgi-bin/mmbiz-bin/appmsg/getplayurl";
      ((b.a)localObject1).funcId = 2962;
      ((b.a)localObject1).hNO = 0;
      ((b.a)localObject1).respCmdId = 0;
      IPCRunCgi.a(((b.a)localObject1).aDC(), (IPCRunCgi.a)new m.a((String)localObject2, (y.f)localObject4));
      i = 1;
    }
    label894:
    b(adu(paramInt));
    if ((this.zTT) && (this.JSE != null) && (this.JSE.irV))
    {
      ad.i("MicroMsg.Imagegallery.handler.video", "%d it loading video data, do not response button click.", new Object[] { Integer.valueOf(hashCode()) });
      AppMethodBeat.o(36270);
      return;
    }
    if (this.JPj.JPk.eqE())
    {
      e(adu(paramInt));
      d(adu(paramInt));
      this.JPj.JPk.setVideoStateIv(true);
      this.JPj.JPk.rFl.stopTimer();
      this.ota.ex(false);
      releaseWakeLock();
      ad.i("MicroMsg.Imagegallery.handler.video", "toggle pause video.");
      AppMethodBeat.o(36270);
      return;
    }
    ba.aBQ();
    if (!com.tencent.mm.model.c.isSDCardAvailable())
    {
      com.tencent.mm.ui.base.t.g(this.JPj.JPk.getContext(), null);
      AppMethodBeat.o(36270);
      return;
    }
    int j;
    if (this.zTT)
    {
      j = 0;
      i = j;
    }
    for (;;)
    {
      try
      {
        if (this.JPj.fFM().JTl != null) {
          i = this.JPj.fFM().JTl.getCurrentPosition() / 1000;
        }
        if (this.JSE != null) {
          if (this.JSE.qj(i))
          {
            ad.i("MicroMsg.Imagegallery.handler.video", "toggle play video");
            a(parambu, locals, paramInt, this.zTT);
            if (this.JPj.JPk.JSm) {
              this.JPj.JPk.fGn();
            }
            fGv();
            this.gKs = ((PowerManager)aj.getContext().getSystemService("power")).newWakeLock(536870922, "MicroMsg.Imagegallery.handler.video");
            this.gKs.acquire();
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
        eV(false);
        continue;
        ad.w("MicroMsg.Imagegallery.handler.video", "%d toggle video but online video helper is null.", new Object[] { Integer.valueOf(hashCode()) });
        continue;
      }
      if (parambu.field_isSend == 0)
      {
        if ((locals.status != 113) && (locals.status != 198)) {
          break label1412;
        }
        a(parambu, locals);
      }
      for (;;)
      {
        if (parambu.field_isSend != 1) {
          break label1513;
        }
        i = locals.status;
        if ((i != 111) && (i != 113) && (i != 112) && (i != 121) && (i != 122)) {
          break label1515;
        }
        ad.i("MicroMsg.Imagegallery.handler.video", "download video. msg talker[%s], info status[%d]", new Object[] { parambu.field_talker, Integer.valueOf(i) });
        a(parambu, locals);
        break;
        label1412:
        if (locals.status == 199) {
          a(parambu, locals, paramInt, false);
        }
        if (locals.status == 111) {
          a(parambu, locals);
        }
        if (locals.status == 112) {
          a(parambu, locals);
        }
        if ((locals.status == 121) || (locals.status == 122)) {
          a(parambu, locals);
        }
        if (locals.status == 123) {
          a(parambu, locals, paramInt, false);
        }
      }
      label1513:
      continue;
      label1515:
      a(parambu, locals, paramInt, false);
    }
  }
  
  public final void jS(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(36287);
    boolean bool2 = this.zTT;
    Object localObject = this.JSE;
    boolean bool1;
    if ((!bt.isNullOrNil(((o)localObject).mediaId)) && (((o)localObject).irP == 1))
    {
      bool1 = true;
      ad.e("MicroMsg.Imagegallery.handler.video", "notify video error, what %d, extras %d isOnlinePlay %b isLoading %b ", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Boolean.valueOf(bool2), Boolean.valueOf(bool1) });
      this.JSG = true;
      this.rFf = paramInt2;
      if (!this.zTT) {
        break label281;
      }
      if (paramInt1 != -1) {
        break label193;
      }
      eae();
      this.JPj.fFM().JTl.stop();
      this.JSE.fGG();
    }
    label193:
    do
    {
      for (;;)
      {
        this.JSQ = false;
        this.JPj.JPk.setVideoStateIv(true);
        this.JPj.fFM().fGB().JTv.setVisibility(0);
        eas();
        g.yhR.idkeyStat(354L, 18L, 1L, false);
        AppMethodBeat.o(36287);
        return;
        bool1 = false;
        break;
        if (paramInt1 != -2) {
          break label256;
        }
        eae();
        paramInt1 = this.JPj.fFM().JTl.getCurrentPosition();
        com.tencent.mm.modelvideo.u.e(this.filename, paramInt1, this.zTT);
        this.JPj.fFM().JTl.stop();
        this.JSE.fGG();
      }
    } while (paramInt1 != -3);
    label256:
    this.JSG = false;
    this.JSE.fGG();
    AppMethodBeat.o(36287);
    return;
    label281:
    com.tencent.mm.modelvideo.u.HB(this.filename);
    eas();
    if ((this.JPj != null) && (this.JPj.fFM() != null) && (this.JPj.fFM().JTl != null))
    {
      localObject = this.JPj.fFM().JTl.getVideoPath();
      this.JPj.fFM().JTl.stop();
    }
    while (this.JSH)
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
        if ((j.this.JPj == null) || (j.this.JPj.fFM() == null) || (j.m(j.this) == null))
        {
          ad.w("MicroMsg.Imagegallery.handler.video", "show error alert but adapter is null.");
          AppMethodBeat.o(36256);
          return;
        }
        j.this.JPj.fFM().c(false, 0.0F);
        if (!bt.isNullOrNil(this.rFp)) {
          ad.e("MicroMsg.Imagegallery.handler.video", "mediaplay play video error, use third player.[%s]", new Object[] { this.rFp });
        }
        try
        {
          Object localObject2 = new Intent();
          ((Intent)localObject2).setAction("android.intent.action.VIEW");
          n.a(j.this.JPj.JPk, (Intent)localObject2, new com.tencent.mm.vfs.e(this.rFp), "video/*");
          Object localObject1 = j.this.JPj.JPk;
          localObject2 = new com.tencent.mm.hellhoundlib.b.a().bc(localObject2);
          com.tencent.mm.hellhoundlib.a.a.a(localObject1, ((com.tencent.mm.hellhoundlib.b.a)localObject2).ahp(), "com/tencent/mm/ui/chatting/gallery/ImageGalleryVideoHandler$5", "run", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          ((ImageGalleryUI)localObject1).startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject2).mq(0));
          com.tencent.mm.hellhoundlib.a.a.a(localObject1, "com/tencent/mm/ui/chatting/gallery/ImageGalleryVideoHandler$5", "run", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          localObject1 = (j.a)j.m(j.this).get(j.b(j.this));
          if ((localObject1 == null) || (((j.a)localObject1).dku == null))
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
            com.tencent.mm.ui.base.h.l(j.this.JPj.JPk, 2131758931, 2131758932);
          }
          j.this.adS(localException.pos);
          AppMethodBeat.o(36256);
        }
      }
    });
    g.yhR.idkeyStat(354L, 25L, 1L, false);
    AppMethodBeat.o(36287);
  }
  
  public final void k(bu parambu, int paramInt)
  {
    AppMethodBeat.i(36273);
    ad.i("MicroMsg.Imagegallery.handler.video", "toggleVideoMenu pos ");
    s locals = com.tencent.mm.modelvideo.u.Hy(parambu.field_imgPath);
    if ((locals != null) && (!locals.aMY()))
    {
      d(adu(paramInt));
      this.JPj.JPk.setVideoStateIv(true);
      if (this.zTT)
      {
        this.JSE.fGF();
        this.JSE.reset();
      }
      a(parambu, locals);
      if (this.JPj.JPk.Ej(parambu.field_msgId) == 2)
      {
        gC(parambu.field_imgPath, 8);
        AppMethodBeat.o(36273);
        return;
      }
      gC(parambu.field_imgPath, 5);
    }
    AppMethodBeat.o(36273);
  }
  
  protected final void onResume()
  {
    AppMethodBeat.i(36282);
    ad.i("MicroMsg.Imagegallery.handler.video", "ui on resume, add online video event.");
    this.JSN.removeMessages(1);
    com.tencent.mm.sdk.b.a.IbL.c(this.JSP);
    if ((this.JPj != null) && (com.tencent.mm.compatible.util.d.ly(21)))
    {
      k localk = this.JPj.fFM();
      if ((localk != null) && (localk.JTl != null))
      {
        if ((localk.JTl instanceof VideoPlayerTextureView))
        {
          ((VideoPlayerTextureView)localk.JTl).boO();
          AppMethodBeat.o(36282);
          return;
        }
        if ((localk.JTl instanceof VideoTextureView)) {
          ((VideoTextureView)localk.JTl).boO();
        }
      }
    }
    AppMethodBeat.o(36282);
  }
  
  public final void pause(int paramInt)
  {
    AppMethodBeat.i(36267);
    d(adu(paramInt));
    this.ota.ex(false);
    this.JPj.JPk.setVideoStateIv(true);
    AppMethodBeat.o(36267);
  }
  
  public static final class a
  {
    public bu dku;
    public int pos;
    
    public a(bu parambu, int paramInt)
    {
      this.dku = parambu;
      this.pos = paramInt;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.gallery.j
 * JD-Core Version:    0.7.0.1
 */