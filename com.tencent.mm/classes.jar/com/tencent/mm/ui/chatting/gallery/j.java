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
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.b.c;
import com.tencent.mm.av.a.a.c.a;
import com.tencent.mm.g.a.np;
import com.tencent.mm.g.a.np.a;
import com.tencent.mm.g.c.dy;
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
import com.tencent.mm.protocal.protobuf.bca;
import com.tencent.mm.protocal.protobuf.bcb;
import com.tencent.mm.protocal.protobuf.bsz;
import com.tencent.mm.protocal.protobuf.bwx;
import com.tencent.mm.protocal.protobuf.dev;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.b;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.ao;
import com.tencent.mm.sdk.platformtools.ao.a;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.au;
import com.tencent.mm.sdk.platformtools.au.a;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.storage.ah.a;
import com.tencent.mm.storage.bo;
import com.tencent.mm.ui.aj;
import com.tencent.mm.ui.chatting.ak;
import com.tencent.mm.ui.chatting.ak.a;
import com.tencent.mm.ui.widget.MMPinProgressBtn;
import com.tencent.mm.vfs.i;
import d.g.b.v.f;
import java.io.IOException;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;

public final class j
  extends a
  implements d.a, t.a
{
  private static com.tencent.mm.ah.y Idj = null;
  public static boolean Idk = false;
  private HashMap<String, a> IbT;
  private com.tencent.mm.sdk.b.c Ida;
  final SparseArray<s> Idb;
  private n Idc;
  private boolean Idd;
  private boolean Ide;
  private boolean Idf;
  private int Idg;
  private int Idh;
  private boolean Idi;
  ao Idl;
  private int Idm;
  private com.tencent.mm.sdk.b.c<np> Idn;
  private boolean Ido;
  private int Idp;
  private int[] Idq;
  private String filename;
  private PowerManager.WakeLock gqI;
  private long kWr;
  private long lastCheckTime;
  private com.tencent.mm.model.d nQt;
  private au oef;
  int qUR;
  private int qUS;
  private com.tencent.mm.plugin.sight.decode.ui.b qUY;
  private com.tencent.mm.plugin.o.b uIt;
  private long yCC;
  private long yCD;
  private long yCM;
  private int yCN;
  private com.tencent.mm.pluginsdk.ui.tools.h.e yCq;
  private boolean yCy;
  private au yqI;
  
  public j(b paramb)
  {
    super(paramb);
    AppMethodBeat.i(36261);
    this.Idb = new SparseArray();
    this.Idd = false;
    this.Ide = false;
    this.Idf = false;
    this.qUS = 0;
    this.kWr = 0L;
    this.lastCheckTime = 0L;
    this.Idg = 0;
    this.Idh = 0;
    this.yCC = 0L;
    this.yCD = 0L;
    this.qUR = 0;
    this.Idi = false;
    this.Idl = new ao(Looper.getMainLooper(), new ao.a()
    {
      public final boolean handleMessage(Message paramAnonymousMessage)
      {
        AppMethodBeat.i(36254);
        if (paramAnonymousMessage.what == 1)
        {
          paramAnonymousMessage = j.this.HZU.fph();
          if ((paramAnonymousMessage != null) && (!bs.isNullOrNil(j.b(j.this))))
          {
            ac.i("MicroMsg.Imagegallery.handler.video", "%d ui on pause, pause video now. %s", new Object[] { Integer.valueOf(hashCode()), j.b(j.this) });
            if (!j.c(j.this)) {
              com.tencent.mm.modelvideo.u.e(j.b(j.this), paramAnonymousMessage.fpS().IdK.getCurrentPosition(), j.d(j.this));
            }
            j.g(paramAnonymousMessage);
            j.b(j.this, paramAnonymousMessage);
            j.e(j.this).ev(false);
            if (j.d(j.this))
            {
              com.tencent.mm.sdk.b.a.GpY.d(j.f(j.this));
              j.g(j.this).fpW();
              j.a(j.this, false);
            }
          }
          j.h(j.this);
        }
        AppMethodBeat.o(36254);
        return false;
      }
    });
    this.Idm = 0;
    this.yqI = new au(new au.a()
    {
      public final boolean onTimerExpired()
      {
        AppMethodBeat.i(36258);
        if (!j.g(j.this).isStreaming())
        {
          AppMethodBeat.o(36258);
          return false;
        }
        k localk = j.this.HZU.fph();
        if (localk == null)
        {
          AppMethodBeat.o(36258);
          return false;
        }
        if (localk.IdH == null)
        {
          AppMethodBeat.o(36258);
          return false;
        }
        if (localk.fpS().IdH.getVisibility() != 0)
        {
          AppMethodBeat.o(36258);
          return false;
        }
        boolean bool = true;
        if (localk.fpS().IdK.isPlaying()) {
          bool = j.c(j.this, localk);
        }
        if (bool)
        {
          int i = localk.fpS().IdK.getCurrentPosition() / 1000;
          bool = j.g(j.this).pG(i);
          AppMethodBeat.o(36258);
          return bool;
        }
        AppMethodBeat.o(36258);
        return false;
      }
    }, true);
    this.oef = new au(new au.a()
    {
      public final boolean onTimerExpired()
      {
        AppMethodBeat.i(36259);
        if (j.this.HZU == null)
        {
          ac.w("MicroMsg.Imagegallery.handler.video", "[onTimerExpired] null == adapter");
          AppMethodBeat.o(36259);
          return false;
        }
        k localk = j.this.HZU.fph();
        if (localk == null)
        {
          AppMethodBeat.o(36259);
          return false;
        }
        if (localk.IdH == null)
        {
          AppMethodBeat.o(36259);
          return false;
        }
        if (localk.fpS().IdH.getVisibility() != 0)
        {
          AppMethodBeat.o(36259);
          return false;
        }
        int i = j.this.HZU.HZV.getCurrentItem();
        if ((s)j.this.Idb.get(i) == null)
        {
          j.this.abG(i);
          AppMethodBeat.o(36259);
          return false;
        }
        if (!localk.fpS().IdK.isPlaying())
        {
          ac.i("MicroMsg.Imagegallery.handler.video", "it is not playing, stop offline timer");
          AppMethodBeat.o(36259);
          return false;
        }
        j.a(j.this, localk.fpS().IdK.getCurrentPosition());
        j.this.abH(j.o(j.this) / 1000);
        AppMethodBeat.o(36259);
        return true;
      }
    }, true);
    this.qUY = new com.tencent.mm.plugin.sight.decode.ui.b()
    {
      public final void anR()
      {
        AppMethodBeat.i(36244);
        if (j.this.HZU.fph() != null) {
          j.b(j.this, j.this.HZU.fph());
        }
        j.this.HZU.HZV.qUX.stopTimer();
        AppMethodBeat.o(36244);
      }
      
      public final void nn(int paramAnonymousInt)
      {
        AppMethodBeat.i(36245);
        localObject = null;
        try
        {
          String str = j.this.HZU.fph().fpS().IdK.getVideoPath();
          localObject = str;
        }
        catch (Exception localException)
        {
          for (;;)
          {
            ac.printErrStackTrace("MicroMsg.Imagegallery.handler.video", localException, "", new Object[0]);
            ac.e("MicroMsg.Imagegallery.handler.video", "on seek get video path error: " + localException.toString());
            continue;
            boolean bool = j.g(j.this).ba(paramAnonymousInt, true);
            continue;
            localObject = j.this.HZU.fpg();
            if ((localObject != null) && (((bo)localObject).crt())) {
              com.tencent.mm.modelvideo.u.e(((dy)localObject).field_imgPath, paramAnonymousInt * 1000, j.d(j.this));
            }
            j.this.HZU.abo(j.this.HZU.HZV.getCurrentItem());
          }
        }
        ac.i("MicroMsg.Imagegallery.handler.video", "on seek to time[%d] isOnlinePlay[%b] videoPath[%s]", new Object[] { Integer.valueOf(paramAnonymousInt), Boolean.valueOf(j.d(j.this)), localObject });
        j.this.HZU.fph().fpS().IdJ.setVisibility(8);
        if (!bs.isNullOrNil((String)localObject)) {
          if (!j.d(j.this))
          {
            j.this.aw(paramAnonymousInt, true);
            bool = true;
            if (bool) {
              j.this.eT(false);
            }
            j.this.HZU.HZV.fpD();
            localObject = j.this.HZU.fpg();
            if ((localObject != null) && (((bo)localObject).cru())) {
              j.this.HZU.HZV.Ica.i((bo)localObject, 13);
            }
            AppMethodBeat.o(36245);
            return;
          }
        }
      }
    };
    this.Idn = new com.tencent.mm.sdk.b.c()
    {
      private boolean a(np paramAnonymousnp)
      {
        AppMethodBeat.i(36246);
        if (!j.g(j.this).avD(paramAnonymousnp.dpX.mediaId))
        {
          AppMethodBeat.o(36246);
          return false;
        }
        if ((paramAnonymousnp.dpX.retCode != 0) && (paramAnonymousnp.dpX.retCode != -21006))
        {
          ac.w("MicroMsg.Imagegallery.handler.video", "stream download online video error. retCode: " + paramAnonymousnp.dpX.retCode);
          j.a(j.this, paramAnonymousnp.dpX.mediaId, paramAnonymousnp.dpX.retCode);
          AppMethodBeat.o(36246);
          return false;
        }
        switch (paramAnonymousnp.dpX.dgL)
        {
        default: 
          ac.w("MicroMsg.Imagegallery.handler.video", "unknown event opcode " + paramAnonymousnp.dpX.dgL);
        }
        for (;;)
        {
          AppMethodBeat.o(36246);
          return false;
          n localn = j.g(j.this);
          long l2 = paramAnonymousnp.dpX.offset;
          long l1 = paramAnonymousnp.dpX.dpY;
          boolean bool = paramAnonymousnp.dpX.dpZ;
          ac.i("MicroMsg.OnlineVideoUIHelper", "deal moov ready moovPos[%d] needSeekTime[%d] timeDuration[%d] startDownload[%d %d]", new Object[] { Long.valueOf(l2), Integer.valueOf(localn.hYx), Integer.valueOf(localn.hYw), Long.valueOf(l1), Long.valueOf(localn.frt) });
          if (localn.hYw != 0) {
            ac.w("MicroMsg.OnlineVideoUIHelper", "moov had callback, do nothing.");
          }
          for (;;)
          {
            j.a(j.this, true);
            break;
            if (l1 > localn.frt) {}
            for (;;)
            {
              for (;;)
              {
                localn.frt = l1;
                com.tencent.mm.plugin.report.service.h.wUl.idkeyStat(354L, 5L, 1L, false);
                localn.yDe = bs.eWj();
                com.tencent.mm.modelvideo.o.aJy();
                paramAnonymousnp = com.tencent.mm.modelvideo.t.DV(localn.filename);
                try
                {
                  if (localn.yDa != null) {
                    break label435;
                  }
                  ac.w("MicroMsg.OnlineVideoUIHelper", "parser is null, thread is error.");
                }
                catch (Exception paramAnonymousnp)
                {
                  ac.printErrStackTrace("MicroMsg.OnlineVideoUIHelper", paramAnonymousnp, "", new Object[0]);
                  ac.e("MicroMsg.OnlineVideoUIHelper", "deal moov ready error: " + paramAnonymousnp.toString());
                }
              }
              break;
              l1 = localn.frt;
            }
            label435:
            if (localn.yDa.F(paramAnonymousnp, l2))
            {
              localn.hYw = localn.yDa.ixA;
              ac.i("MicroMsg.OnlineVideoUIHelper", "mp4 parse moov success. duration %d filename %s isFastStart %b", new Object[] { Integer.valueOf(localn.hYw), localn.filename, Boolean.valueOf(bool) });
              if (!bool) {
                ap.f(new n.1(localn));
              }
              if (localn.hYx == -1) {}
              for (localn.hYu = 1;; localn.hYu = 2)
              {
                com.tencent.mm.plugin.report.service.h.wUl.idkeyStat(354L, 7L, 1L, false);
                break;
              }
            }
            ac.w("MicroMsg.OnlineVideoUIHelper", "mp4 parse moov error.");
            com.tencent.mm.modelvideo.o.aJz();
            com.tencent.mm.an.e.p(localn.mediaId, 0, -1);
            com.tencent.mm.modelvideo.u.as(localn.filename, 15);
            com.tencent.mm.plugin.report.service.h.wUl.idkeyStat(354L, 8L, 1L, false);
            ac.w("MicroMsg.OnlineVideoUIHelper", "%d rpt parse moov fail %s ", new Object[] { Integer.valueOf(localn.hashCode()), localn.filename });
            com.tencent.mm.plugin.report.service.h.wUl.f(13836, new Object[] { Integer.valueOf(302), Long.valueOf(bs.aNx()), "" });
          }
          localn = j.g(j.this);
          Object localObject = paramAnonymousnp.dpX.mediaId;
          int i = paramAnonymousnp.dpX.offset;
          int j = paramAnonymousnp.dpX.length;
          localn.hYD = false;
          if ((i < 0) || (j < 0)) {
            ac.w("MicroMsg.OnlineVideoUIHelper", "deal data available error offset[%d], length[%d]", new Object[] { Integer.valueOf(i), Integer.valueOf(j) });
          }
          while (!localn.avD((String)localObject))
          {
            if (paramAnonymousnp.dpX.length <= 0) {
              break;
            }
            j.this.eT(true);
            break;
          }
          localObject = localn.mediaId + i + "_" + j;
          localObject = (Integer)localn.yCZ.get(localObject);
          if ((localObject != null) && (((Integer)localObject).intValue() > 0)) {
            localn.hYA = ((Integer)localObject).intValue();
          }
          for (;;)
          {
            ac.i("MicroMsg.OnlineVideoUIHelper", "deal data available. offset[%d] length[%d] cachePlayTime[%d]", new Object[] { Integer.valueOf(i), Integer.valueOf(j), Integer.valueOf(localn.hYA) });
            break;
            try
            {
              localn.hYA = localn.yDa.dw(i, j);
            }
            catch (Exception localException)
            {
              ac.printErrStackTrace("MicroMsg.OnlineVideoUIHelper", localException, "", new Object[0]);
              ac.e("MicroMsg.OnlineVideoUIHelper", "deal data available file pos to video time error: " + localException.toString());
            }
          }
          j.this.eT(true);
          continue;
          paramAnonymousnp = j.g(j.this);
          ac.i("MicroMsg.OnlineVideoUIHelper", "deal stream finish. playStatus %d ", new Object[] { Integer.valueOf(paramAnonymousnp.hYu) });
          paramAnonymousnp.hYD = false;
          paramAnonymousnp.hYt = 3;
          if (paramAnonymousnp.hYu == 0)
          {
            ac.w("MicroMsg.OnlineVideoUIHelper", "it had not moov callback and download finish start to play video.");
            paramAnonymousnp.dOn();
            com.tencent.mm.plugin.report.service.h.wUl.idkeyStat(354L, 6L, 1L, false);
          }
          for (;;)
          {
            paramAnonymousnp.fpY();
            com.tencent.mm.plugin.report.service.h.wUl.idkeyStat(354L, 26L, 1L, false);
            j.this.eT(true);
            break;
            if (paramAnonymousnp.hYu == 5)
            {
              ac.w("MicroMsg.OnlineVideoUIHelper", "it had play error, it request all video data finish, start to play." + paramAnonymousnp.mediaId);
              paramAnonymousnp.dOn();
            }
          }
          localn = j.g(j.this);
          String str = paramAnonymousnp.dpX.mediaId;
          i = paramAnonymousnp.dpX.offset;
          if (localn.avD(str))
          {
            if (localn.jlZ != 0) {
              localn.yDc = (i * 100 / localn.jlZ);
            }
            ac.i("MicroMsg.OnlineVideoUIHelper", "deal progress callback. downloadedPercent : " + localn.yDc);
          }
          if (localn.yDc >= 100)
          {
            localn.hYt = 3;
            continue;
            paramAnonymousnp = j.g(j.this);
            ac.i("MicroMsg.OnlineVideoUIHelper", "deal had dup video.");
            paramAnonymousnp.fpY();
            paramAnonymousnp.dOn();
          }
        }
      }
    };
    this.Ido = false;
    this.Idp = 0;
    this.Idq = new int[] { -1000, -2000, 3400 };
    this.yCq = new com.tencent.mm.pluginsdk.ui.tools.h.e()
    {
      public final void bli()
      {
        AppMethodBeat.i(36250);
        ac.i("MicroMsg.Imagegallery.handler.video", "%d on texture update.", new Object[] { Integer.valueOf(j.this.hashCode()) });
        try
        {
          j.this.HZU.fph().c(true, 1.0F);
          AppMethodBeat.o(36250);
          return;
        }
        catch (Exception localException)
        {
          ac.e("MicroMsg.Imagegallery.handler.video", "texture view update. error " + localException.toString());
          AppMethodBeat.o(36250);
        }
      }
    };
    this.uIt = new com.tencent.mm.plugin.o.b()
    {
      public final long dcT()
      {
        AppMethodBeat.i(36251);
        ac.i("MicroMsg.Imagegallery.handler.video", "%d video get online cache sec", new Object[] { Integer.valueOf(j.this.hashCode()) });
        az.ayM();
        com.tencent.mm.model.c.agA().set(ah.a.GLy, Boolean.TRUE);
        try
        {
          if ((j.d(j.this)) && (j.g(j.this) != null))
          {
            int i = j.g(j.this).hYA;
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
    Idj = null;
    this.IbT = new HashMap();
    this.Idc = new n(this);
    com.tencent.mm.sdk.b.a locala = com.tencent.mm.sdk.b.a.GpY;
    paramb = new ak(ak.a.HQt, paramb.HZV);
    this.Ida = paramb;
    locala.c(paramb);
    com.tencent.mm.sdk.b.a.GpY.c(this.Idn);
    this.nQt = new com.tencent.mm.model.d();
    AppMethodBeat.o(36261);
  }
  
  private void a(bo parambo, s params)
  {
    AppMethodBeat.i(36275);
    if ((!com.tencent.mm.network.ae.cS(this.HZU.HZV.getContext())) && (!Idk)) {
      Idk = true;
    }
    b(parambo, params);
    AppMethodBeat.o(36275);
  }
  
  private void a(bo parambo, s params, int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(36274);
    if ((parambo == null) || (params == null))
    {
      AppMethodBeat.o(36274);
      return;
    }
    if ((!parambo.cru()) && (parambo.fbQ()))
    {
      Toast.makeText(this.HZU.HZV, 2131764677, 0).show();
      AppMethodBeat.o(36274);
      return;
    }
    Object localObject3;
    Object localObject1;
    if (params.iaP == -1)
    {
      localObject3 = params.aJJ();
      localObject1 = localObject3;
      if (!i.eA((String)localObject3))
      {
        com.tencent.mm.modelvideo.o.aJy();
        localObject1 = com.tencent.mm.modelvideo.t.DV(parambo.field_imgPath);
        if ((localObject1 != null) && (i.eA((String)localObject1))) {
          break label336;
        }
        Toast.makeText(this.HZU.HZV, 2131764677, 0).show();
        AppMethodBeat.o(36274);
      }
    }
    else
    {
      com.tencent.mm.modelvideo.o.aJy();
      localObject3 = com.tencent.mm.modelvideo.t.DV(parambo.field_imgPath);
      localObject1 = localObject3;
      if (parambo.field_isSend == 1)
      {
        localObject1 = localObject3;
        if (params.iaS != null)
        {
          localObject1 = localObject3;
          if (!params.iaS.FhZ) {}
        }
      }
    }
    for (;;)
    {
      try
      {
        String str = i.aSs((String)localObject3);
        localObject1 = str;
        if (!str.endsWith("/")) {
          localObject1 = str + "/";
        }
        str = i.aSu((String)localObject3);
        localObject1 = (String)localObject1 + str + "_hd.mp4";
        bool = i.eA((String)localObject1);
        ac.i("MicroMsg.Imagegallery.handler.video", "local capture video, hdFilePath: %s, exist: %s", new Object[] { localObject1, Boolean.valueOf(bool) });
        if (!bool) {
          break label1074;
        }
      }
      catch (Exception localException)
      {
        ac.e("MicroMsg.Imagegallery.handler.video", "try to get hd filePath error: %s", new Object[] { localException.getMessage() });
        localObject2 = localObject3;
      }
      break;
      label336:
      localObject3 = abi(paramInt);
      if (localObject3 == null)
      {
        AppMethodBeat.o(36274);
        return;
      }
      int i = 0;
      if (w.sQ(params.getUser())) {
        i = q.wb(params.getUser());
      }
      boolean bool = com.tencent.mm.modelvideo.r.DP(localObject2);
      int j = this.HZU.HZV.Br(parambo.field_msgId);
      ac.i("MicroMsg.Imagegallery.handler.video", "play video pos[%d], isOnlinePlay[%b] opcode[%d] resetByCompletion[%b]", new Object[] { Integer.valueOf(paramInt), Boolean.valueOf(paramBoolean), Integer.valueOf(j), Boolean.valueOf(this.Idi) });
      if (!bool)
      {
        if ((com.tencent.mm.compatible.deviceinfo.ae.fJo.fFT == 1) && (com.tencent.mm.pluginsdk.i.b.a.a.b(params.getFileName(), this.HZU.HZV.getContext(), bool)))
        {
          AppMethodBeat.o(36274);
          return;
        }
        az.ayM();
        if ((((Integer)com.tencent.mm.model.c.agA().get(ah.a.GKg, Integer.valueOf(0))).intValue() == 1) && (((k)localObject3).IdM != null))
        {
          ((k)localObject3).IdM.setVisibility(0);
          ((k)localObject3).IdM.setText(com.tencent.mm.plugin.sight.base.e.alX(localObject2));
        }
        ((k)localObject3).a(params.hpy, params.hux, i, params.getUser(), s.DR(params.aJK()), params.createTime);
        this.yCy = paramBoolean;
        this.Idd = true;
        this.filename = params.getFileName();
        if (j == 3)
        {
          ((k)localObject3).fpS().IdK.setMute(true);
          if ((((k)localObject3).fpS().IdK.getVideoPath() == null) || (!((k)localObject3).fpS().IdK.getVideoPath().equals(localObject2)) || (((k)localObject3).fpS().IdK.isPlaying()) || (this.Idi)) {
            break label822;
          }
          ((k)localObject3).c(true, 1.0F);
          ((k)localObject3).fpS().IdK.start();
          dOd();
          if (!paramBoolean) {
            aQB(this.filename);
          }
          abH(((k)localObject3).fpS().IdK.getCurrentPosition() / 1000);
          eT(false);
          label740:
          b(paramInt, params);
          this.HZU.HZV.setVideoStateIv(false);
          this.HZU.HZV.getContext().getWindow().addFlags(128);
          this.nQt.a(this);
        }
      }
      for (;;)
      {
        ((k)localObject3).fpS().IdL.setVisibility(8);
        AppMethodBeat.o(36274);
        return;
        ((k)localObject3).fpS().IdK.setMute(false);
        break;
        label822:
        this.Idf = false;
        this.Idi = false;
        ((k)localObject3).fpS().IdK.setVideoPath(localObject2);
        if ((((k)localObject3).fpS().IdK instanceof VideoPlayerTextureView))
        {
          ((VideoPlayerTextureView)((k)localObject3).fpS().IdK).setIOnlineCache(this.uIt);
          ((VideoPlayerTextureView)((k)localObject3).fpS().IdK).setNeedResetExtractor(crM());
          ((VideoPlayerTextureView)((k)localObject3).fpS().IdK).setIsOnlineVideoType(paramBoolean);
        }
        ((k)localObject3).c(true, 0.0F);
        break label740;
        com.tencent.mm.plugin.report.service.h.wUl.f(12084, new Object[] { Integer.valueOf(params.hux), Integer.valueOf(params.hpy * 1000), Integer.valueOf(0), Integer.valueOf(3), params.getUser(), Integer.valueOf(i), s.DR(params.aJK()), Long.valueOf(params.createTime) });
        if (!com.tencent.mm.pluginsdk.i.b.a.a.c(localObject2, this.HZU.HZV.getContext(), bool)) {
          Toast.makeText(this.HZU.HZV.getContext(), this.HZU.HZV.getString(2131764691), 0).show();
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
      paramk.fpS();
      paramk.fpS().IdN.setVisibility(0);
      paramk.fpS().IdO.setText(bs.bG(paramString, this.HZU.HZV.getString(2131764692)));
      paramk.fpS().IdI.setVisibility(0);
      paramk.fpS().IdJ.setVisibility(8);
      c(paramk);
      AppMethodBeat.o(36271);
      return;
    }
    AppMethodBeat.o(36271);
  }
  
  private void b(int paramInt, s params)
  {
    AppMethodBeat.i(36290);
    this.Idb.put(paramInt, params);
    AppMethodBeat.o(36290);
  }
  
  private void b(bo parambo, s params)
  {
    AppMethodBeat.i(36276);
    ac.i("MicroMsg.Imagegallery.handler.video", "startDownloading [%d]", new Object[] { Integer.valueOf(hashCode()) });
    if ((parambo == null) || (params == null))
    {
      AppMethodBeat.o(36276);
      return;
    }
    k localk = this.HZU.fph();
    if (localk == null)
    {
      AppMethodBeat.o(36276);
      return;
    }
    aa.O(parambo);
    int i = this.HZU.HZV.Br(parambo.field_msgId);
    ac.d("MicroMsg.Imagegallery.handler.video", "enterVideoOpCode : ".concat(String.valueOf(i)));
    switch (i)
    {
    default: 
      ac.w("MicroMsg.Imagegallery.handler.video", "enterVideoOpCode[%d] is error", new Object[] { Integer.valueOf(i) });
      AppMethodBeat.o(36276);
      return;
    case 3: 
      ac.i("MicroMsg.Imagegallery.handler.video", "%d mute play video [%d]", new Object[] { Integer.valueOf(hashCode()), Integer.valueOf(i) });
    case 0: 
      if ((this.Idc.aQD(parambo.field_imgPath)) || (this.Idc.c(parambo, params)))
      {
        ac.i("MicroMsg.Imagegallery.handler.video", "start online play video.");
        this.yCy = true;
        com.tencent.mm.modelvideo.o.aJy().a(this);
        localk.fpS().IdJ.setVisibility(8);
        localk.fpS().IdL.setVisibility(8);
        localk.fpS().IdU.setVisibility(0);
        AppMethodBeat.o(36276);
        return;
      }
      ac.i("MicroMsg.Imagegallery.handler.video", "start offline play video.");
      this.yCy = false;
      com.tencent.mm.modelvideo.o.aJy().a(this, Looper.getMainLooper());
      com.tencent.mm.modelvideo.u.Ee(parambo.field_imgPath);
      localk.fpS().IdJ.setVisibility(8);
      localk.fpS().IdL.setVisibility(0);
      localk.fpS().IdL.setProgress(com.tencent.mm.modelvideo.u.g(params));
      AppMethodBeat.o(36276);
      return;
    }
    if (params.aJM())
    {
      ac.i("MicroMsg.Imagegallery.handler.video", "start complete online video");
      com.tencent.mm.modelvideo.u.Eq(parambo.field_imgPath);
    }
    for (;;)
    {
      com.tencent.mm.modelvideo.o.aJy().a(this, Looper.getMainLooper());
      localk.fpS().IdJ.setVisibility(8);
      localk.fpS().IdL.setVisibility(0);
      localk.fpS().IdL.setProgress(com.tencent.mm.modelvideo.u.g(params));
      if (i != 2) {
        break;
      }
      fpO();
      AppMethodBeat.o(36276);
      return;
      ac.i("MicroMsg.Imagegallery.handler.video", "start complete offline video");
      gf(parambo.field_imgPath, 10);
      com.tencent.mm.modelvideo.u.Ee(parambo.field_imgPath);
    }
    fpN();
    AppMethodBeat.o(36276);
  }
  
  private static void b(k paramk)
  {
    AppMethodBeat.i(36272);
    if (paramk != null)
    {
      paramk.fpS();
      paramk.fpS().IdN.setVisibility(8);
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
    com.tencent.mm.modelvideo.o.aJy().a(this);
    if (this.HZU.HZV.getCurrentItem() == parama.pos)
    {
      parama = abi(parama.pos);
      if (parama != null)
      {
        parama.fpS().IdU.setVisibility(8);
        parama.fpS().IdL.setVisibility(8);
        parama.fpS().IdJ.setVisibility(8);
      }
      this.Ido = true;
      this.HZU.HZV.fpx();
      AppMethodBeat.o(36278);
      return true;
    }
    this.HZU.abq(parama.pos);
    AppMethodBeat.o(36278);
    return false;
  }
  
  private static com.tencent.mm.ah.y bk(Activity paramActivity)
  {
    AppMethodBeat.i(36264);
    byte[] arrayOfByte;
    if (Idj == null)
    {
      arrayOfByte = paramActivity.getIntent().getByteArrayExtra("img_gallery_mp_share_video_info");
      if (bs.cv(arrayOfByte))
      {
        ac.e("MicroMsg.Imagegallery.handler.video", "initMPShareVideoInfo data is null");
        paramActivity.finish();
        AppMethodBeat.o(36264);
        return null;
      }
    }
    try
    {
      com.tencent.mm.ah.y localy = new com.tencent.mm.ah.y();
      localy.parseFrom(arrayOfByte);
      Idj = localy;
      paramActivity = Idj;
      AppMethodBeat.o(36264);
      return paramActivity;
    }
    catch (IOException localIOException)
    {
      for (;;)
      {
        ac.e("MicroMsg.Imagegallery.handler.video", "initMPShareVideoInfo ex %s", new Object[] { localIOException.getMessage() });
        paramActivity.finish();
      }
    }
  }
  
  private void c(k paramk)
  {
    AppMethodBeat.i(36280);
    ac.i("MicroMsg.Imagegallery.handler.video", "stop");
    dNR();
    if (paramk == null)
    {
      AppMethodBeat.o(36280);
      return;
    }
    dOe();
    if (this.yCy) {
      this.Idc.fpW();
    }
    if (!this.Ide) {
      com.tencent.mm.modelvideo.u.e(this.filename, this.qUS - 1000, this.yCy);
    }
    paramk.fpS().IdL.setVisibility(8);
    paramk.fpS().IdU.setVisibility(8);
    paramk.fpS().IdK.stop();
    abH(0);
    paramk.c(false, 0.0F);
    this.yCy = false;
    this.Ido = false;
    this.Idi = false;
    this.filename = null;
    this.yCN = 0;
    this.yCM = 0L;
    this.Idp = 0;
    this.Idm = 0;
    this.Idh = 0;
    this.Idg = 0;
    this.kWr = 0L;
    this.lastCheckTime = 0L;
    AppMethodBeat.o(36280);
  }
  
  public static s ck(bo parambo)
  {
    AppMethodBeat.i(36263);
    if (!b.m(parambo))
    {
      AppMethodBeat.o(36263);
      return null;
    }
    parambo = com.tencent.mm.modelvideo.u.Ej(parambo.field_imgPath);
    AppMethodBeat.o(36263);
    return parambo;
  }
  
  public static com.tencent.mm.ah.y cl(bo parambo)
  {
    AppMethodBeat.i(36265);
    if (parambo.fbt())
    {
      parambo = new com.tencent.mm.ah.y().a(parambo.GYQ);
      AppMethodBeat.o(36265);
      return parambo;
    }
    parambo = k.b.az(parambo.field_content, parambo.field_reserved);
    if (parambo == null)
    {
      ac.w("MicroMsg.Imagegallery.handler.video", "getVideoInfo content is null");
      AppMethodBeat.o(36265);
      return null;
    }
    parambo = (com.tencent.mm.ah.e)parambo.ao(com.tencent.mm.ah.e.class);
    if ((parambo != null) && (parambo.hhf != null)) {}
    for (parambo = parambo.hhf;; parambo = null)
    {
      AppMethodBeat.o(36265);
      return parambo;
    }
  }
  
  private static s cm(bo parambo)
  {
    AppMethodBeat.i(36269);
    s locals = ck(parambo);
    if (locals != null)
    {
      AppMethodBeat.o(36269);
      return locals;
    }
    ac.i("MicroMsg.Imagegallery.handler.video", "insert video info:" + parambo.toString());
    locals = new s();
    locals.drG = parambo.field_talker;
    locals.fileName = parambo.field_imgPath;
    if (parambo.field_createTime <= 0L) {}
    for (long l = System.currentTimeMillis();; l = parambo.field_createTime)
    {
      locals.createTime = l;
      locals.dpl = parambo.field_msgSvrId;
      locals.iaO = parambo.field_content;
      locals.iaJ = ((int)parambo.field_msgId);
      com.tencent.mm.ah.y localy = cl(parambo);
      if (localy != null)
      {
        if (TextUtils.isEmpty(parambo.field_imgPath))
        {
          parambo.rf(com.tencent.mm.modelvideo.t.DU(parambo.field_talker));
          az.ayM();
          com.tencent.mm.model.c.awD().a(parambo.field_msgId, parambo);
        }
        locals.fileName = parambo.field_imgPath;
        m localm = m.IeA;
        locals.a(bs.bG(m.anB(localy.vG(parambo.field_imgPath)), localy.videoUrl), localy.videoDuration, localy.title, localy.DWF, "", "", "");
        locals.status = 111;
      }
      com.tencent.mm.modelvideo.o.aJy().b(locals);
      AppMethodBeat.o(36269);
      return locals;
    }
  }
  
  private boolean crM()
  {
    AppMethodBeat.i(36307);
    if (!this.yCy)
    {
      AppMethodBeat.o(36307);
      return false;
    }
    az.ayM();
    boolean bool = com.tencent.mm.model.c.agA().getBoolean(ah.a.GLy, false);
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
    dNR();
    ac.d("MicroMsg.Imagegallery.handler.video", "pause video.");
    if (paramk.fpS().IdK.isPlaying())
    {
      paramk.fpS().IdK.pause();
      dOe();
    }
    AppMethodBeat.o(36281);
  }
  
  private void dNR()
  {
    AppMethodBeat.i(36288);
    ac.i("MicroMsg.Imagegallery.handler.video", "clear timer");
    this.yqI.stopTimer();
    this.oef.stopTimer();
    AppMethodBeat.o(36288);
  }
  
  private void dOd()
  {
    AppMethodBeat.i(36300);
    this.yCM = bs.eWj();
    ac.d("MicroMsg.Imagegallery.handler.video", "notePlayVideo filename %s notePlayVideo %d ", new Object[] { this.filename, Long.valueOf(this.yCM) });
    if ((this.HZU != null) && (this.HZU.HZV != null)) {
      this.HZU.HZV.Ica.cf(this.HZU.fpg());
    }
    AppMethodBeat.o(36300);
  }
  
  private void dOe()
  {
    AppMethodBeat.i(36301);
    if (this.yCM > 0L) {
      this.yCN = ((int)(this.yCN + (bs.eWj() - this.yCM) / 1000L));
    }
    ac.i("MicroMsg.Imagegallery.handler.video", "notePauseVideo filename %s playVideoDuration %d ", new Object[] { this.filename, Integer.valueOf(this.yCN) });
    this.yCM = 0L;
    if ((this.HZU != null) && (this.HZU.HZV != null)) {
      this.HZU.HZV.Ica.ce(this.HZU.fpg());
    }
    AppMethodBeat.o(36301);
  }
  
  public static bo e(String paramString, Activity paramActivity)
  {
    AppMethodBeat.i(36266);
    bo localbo = new bo();
    localbo.setType(486539313);
    localbo.re(paramString);
    localbo.GYR = true;
    localbo.GYQ = bk(paramActivity);
    localbo.rf(paramActivity.getIntent().getStringExtra("img_gallery_path"));
    AppMethodBeat.o(36266);
    return localbo;
  }
  
  private static void e(k paramk)
  {
    AppMethodBeat.i(36283);
    if (paramk != null)
    {
      paramk.fpS();
      if (paramk.fpS().IdK.isPlaying()) {
        k.aF(paramk.fpS().IdJ, 0);
      }
      AppMethodBeat.o(36283);
      return;
    }
    AppMethodBeat.o(36283);
  }
  
  private boolean f(k paramk)
  {
    AppMethodBeat.i(36304);
    int i = this.qUS;
    this.qUS = paramk.fpS().IdK.getCurrentPosition();
    int j;
    if (i != this.qUS)
    {
      this.lastCheckTime = bs.eWj();
      long l = paramk.fpS().IdK.getLastSurfaceUpdateTime();
      if ((l > 0L) && (l != this.kWr))
      {
        this.kWr = l;
        j = this.Idg;
        switch (j)
        {
        default: 
          this.Idg = 0;
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
          ac.w("MicroMsg.Imagegallery.handler.video", "%d rpt rptRepairEffect idKey %d errorTime %d filename %s", new Object[] { Integer.valueOf(hashCode()), Integer.valueOf(i), Integer.valueOf(j), this.filename });
          com.tencent.mm.plugin.report.service.h.wUl.idkeyStat(354L, i, 1L, false);
          com.tencent.mm.plugin.report.service.h.wUl.f(13836, new Object[] { Integer.valueOf(301), Long.valueOf(bs.aNx()), "" });
          break;
          i = 22;
          continue;
          i = 23;
        }
        if (this.Idg != -1)
        {
          this.Idg += 1;
          ac.w("MicroMsg.Imagegallery.handler.video", "media play is playing[%d], but surface is not update!! repair time[%d]", new Object[] { Integer.valueOf(this.Idg), Integer.valueOf(this.Idh) });
          if (this.Idh >= 2) {
            this.Idc.fpX();
          }
          switch (this.Idg)
          {
          case 0: 
          case 1: 
          default: 
            ac.w("MicroMsg.Imagegallery.handler.video", "rpt surface not update!!");
            ac.w("MicroMsg.Imagegallery.handler.video", "%d rpt rptSurfaceNotUpdate %s", new Object[] { Integer.valueOf(hashCode()), this.filename });
            com.tencent.mm.plugin.report.service.h.wUl.f(13836, new Object[] { Integer.valueOf(300), Long.valueOf(bs.aNx()), "" });
            com.tencent.mm.plugin.report.service.h.wUl.idkeyStat(354L, 20L, 1L, false);
            this.Idg = -1;
          }
        }
      }
      i = this.qUS / 1000;
      ac.w("MicroMsg.Imagegallery.handler.video", "surface not update, it try seek time[%d] to repair.", new Object[] { Integer.valueOf(i) });
      aw(i, true);
      this.Idh += 1;
      AppMethodBeat.o(36304);
      return false;
      j = (this.qUS - 2000) / 1000;
      i = j;
      if (j < 0) {
        i = 0;
      }
      ac.w("MicroMsg.Imagegallery.handler.video", "surface not update, it try seek time[%d] to repair.", new Object[] { Integer.valueOf(i) });
      aw(i, true);
      this.Idh += 1;
      AppMethodBeat.o(36304);
      return false;
      j = (this.qUS - 4000) / 1000;
      i = j;
      if (j < 0) {
        i = 0;
      }
      ac.w("MicroMsg.Imagegallery.handler.video", "surface not update, it try seek time[%d] to repair.", new Object[] { Integer.valueOf(i) });
      aw(i, true);
      this.Idh += 1;
      AppMethodBeat.o(36304);
      return false;
      ac.i("MicroMsg.Imagegallery.handler.video", "check time[%d, %d], play time[%d, %d]", new Object[] { Long.valueOf(this.lastCheckTime), Long.valueOf(bs.eWj()), Integer.valueOf(i), Integer.valueOf(this.qUS) });
    } while ((this.lastCheckTime <= 0L) || (bs.Ap(this.lastCheckTime) < 1500L));
    ac.w("MicroMsg.Imagegallery.handler.video", "play time not update! request all video data to play. ");
    i = this.HZU.fph().IdK.getCurrentPosition();
    dNR();
    com.tencent.mm.modelvideo.u.e(this.filename, i, this.yCy);
    this.HZU.fph().IdK.stop();
    this.Idc.fpX();
    paramk = (a)this.IbT.get(this.filename);
    if ((paramk == null) || (paramk.cZc == null))
    {
      AppMethodBeat.o(36304);
      return false;
    }
    s locals = ck(paramk.cZc);
    a(paramk.cZc, locals, paramk.pos, this.yCy);
    this.lastCheckTime = 0L;
    AppMethodBeat.o(36304);
    return false;
  }
  
  private void fpM()
  {
    AppMethodBeat.i(36293);
    try
    {
      this.HZU.HZV.fpr().zRK.setIplaySeekCallback(this.qUY);
      AppMethodBeat.o(36293);
      return;
    }
    catch (Exception localException)
    {
      AppMethodBeat.o(36293);
    }
  }
  
  private static void fpN()
  {
    AppMethodBeat.i(36305);
    com.tencent.mm.plugin.report.service.h.wUl.idkeyStat(354L, 11L, 1L, false);
    AppMethodBeat.o(36305);
  }
  
  private static void fpO()
  {
    AppMethodBeat.i(36306);
    com.tencent.mm.plugin.report.service.h.wUl.idkeyStat(354L, 14L, 1L, false);
    AppMethodBeat.o(36306);
  }
  
  private void gf(final String paramString, final int paramInt)
  {
    AppMethodBeat.i(36277);
    az.agU().az(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(36253);
        com.tencent.mm.modelvideo.u.at(paramString, paramInt);
        AppMethodBeat.o(36253);
      }
    });
    AppMethodBeat.o(36277);
  }
  
  private void releaseWakeLock()
  {
    AppMethodBeat.i(36268);
    if ((this.gqI != null) && (this.gqI.isHeld()))
    {
      ac.i("MicroMsg.Imagegallery.handler.video", "release waklock");
      this.gqI.release();
    }
    AppMethodBeat.o(36268);
  }
  
  public final void MT()
  {
    AppMethodBeat.i(36279);
    ac.i("MicroMsg.Imagegallery.handler.video", "stopAll. video handler hash code : " + hashCode());
    this.yCD = bs.eWj();
    SparseArray localSparseArray = this.HZU.HBb;
    int j = 0;
    int i = 0;
    if (j < localSparseArray.size())
    {
      int k = localSparseArray.keyAt(j);
      if ((localSparseArray.get(k) == null) || (((View)localSparseArray.get(k)).getTag() == null)) {
        break label253;
      }
      k localk = (k)((View)localSparseArray.get(k)).getTag();
      if ((localk.IdH == null) || (localk.fpS().IdH.getVisibility() != 0) || ((((View)localk.fpS().IdK).getVisibility() != 0) && (bs.isNullOrNil(localk.fpS().IdK.getVideoPath())) && ((!this.yCy) || (!this.Idc.isStreaming())))) {
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
      this.nQt.ev(false);
      if ((i == 0) && (this.yCy))
      {
        this.Idc.fpW();
        this.yCy = false;
      }
      dNR();
      this.Idb.clear();
      releaseWakeLock();
      AppMethodBeat.o(36279);
      return;
    }
  }
  
  public final void a(t.a.a parama)
  {
    AppMethodBeat.i(36292);
    Object localObject = parama.fileName;
    if ((bs.isNullOrNil((String)localObject)) || (this.IbT == null))
    {
      AppMethodBeat.o(36292);
      return;
    }
    parama = (a)this.IbT.get(localObject);
    if (parama == null)
    {
      AppMethodBeat.o(36292);
      return;
    }
    bo localbo = parama.cZc;
    if ((localbo == null) || (localbo.field_imgPath == null) || (!localbo.field_imgPath.equals(localObject)))
    {
      AppMethodBeat.o(36292);
      return;
    }
    localObject = ck(localbo);
    if (localObject == null)
    {
      AppMethodBeat.o(36292);
      return;
    }
    if (((!localbo.cru()) && (localbo.fbQ())) || (((s)localObject).status == 198))
    {
      if (b(parama)) {
        Toast.makeText(this.HZU.HZV, 2131764677, 0).show();
      }
      AppMethodBeat.o(36292);
      return;
    }
    int i = com.tencent.mm.modelvideo.u.g((s)localObject);
    k localk = abi(parama.pos);
    if ((this.HZU.HZV.getCurrentItem() == parama.pos) && (localk != null))
    {
      localk.fpS().IdL.setVisibility(0);
      localk.fpS().IdL.setProgress(i);
    }
    while (i < localk.fpS().IdL.getMax())
    {
      AppMethodBeat.o(36292);
      return;
      if (localk == null)
      {
        AppMethodBeat.o(36292);
        return;
      }
    }
    ac.d("MicroMsg.Imagegallery.handler.video", "onNotifyChange, status:%d", new Object[] { Integer.valueOf(((s)localObject).status) });
    if (((((s)localObject).status == 199) || (((s)localObject).status == 199)) && (b(parama))) {
      i = this.HZU.HZV.Br(localbo.field_msgId);
    }
    switch (i)
    {
    default: 
      ac.w("MicroMsg.Imagegallery.handler.video", "enterVideoOpCode[%d] is error", new Object[] { Integer.valueOf(i) });
      AppMethodBeat.o(36292);
      return;
    case 0: 
    case 3: 
      a(localbo, (s)localObject, this.HZU.HZV.getCurrentItem(), false);
      AppMethodBeat.o(36292);
      return;
    case 1: 
      ac.d("MicroMsg.Imagegallery.handler.video", "do restransmit video");
      com.tencent.mm.plugin.report.service.h.wUl.idkeyStat(354L, 15L, 1L, false);
      this.HZU.bX(localbo);
      this.HZU.HZV.Bs(-1L);
      if (this.yCy)
      {
        i = this.HZU.fph().IdK.getCurrentPosition();
        com.tencent.mm.modelvideo.u.e(this.filename, i, this.yCy);
        this.Idi = true;
      }
      this.yCy = false;
      AppMethodBeat.o(36292);
      return;
    }
    com.tencent.mm.plugin.report.service.h.wUl.idkeyStat(354L, 16L, 1L, false);
    b.a(this.HZU.HZV, localbo);
    this.HZU.HZV.Bs(-1L);
    if (this.yCy)
    {
      i = this.HZU.fph().IdK.getCurrentPosition();
      com.tencent.mm.modelvideo.u.e(this.filename, i, this.yCy);
      this.Idi = true;
    }
    this.yCy = false;
    AppMethodBeat.o(36292);
  }
  
  public final boolean a(k paramk, bo parambo, int paramInt)
  {
    AppMethodBeat.i(36262);
    super.a(paramk, parambo, paramInt);
    Object localObject1 = cm(parambo);
    if (parambo == null)
    {
      ac.e("MicroMsg.Imagegallery.handler.video", "msg is null!!");
      AppMethodBeat.o(36262);
      return false;
    }
    if (this.IbT != null) {
      this.IbT.put(parambo.field_imgPath, new a(parambo, paramInt));
    }
    while (localObject1 == null)
    {
      AppMethodBeat.o(36262);
      return false;
      ac.e("MicroMsg.Imagegallery.handler.video", "mCacheMap is null!");
    }
    if (parambo.cru())
    {
      localObject1 = cl(parambo);
      if (localObject1 != null)
      {
        Object localObject2 = com.tencent.mm.pluginsdk.model.r.aGc(((com.tencent.mm.ah.y)localObject1).hld);
        com.tencent.mm.av.a.a locala = com.tencent.mm.av.o.aFB();
        String str = ((com.tencent.mm.ah.y)localObject1).hld;
        ImageView localImageView = paramk.fpS().IdI;
        c.a locala1 = new c.a();
        locala1.gKe = ((String)localObject2);
        locala1.hKx = true;
        locala.a(str, localImageView, locala1.aFT());
        localObject2 = m.IeA;
        parambo = m.aQC(((com.tencent.mm.ah.y)localObject1).vG(parambo.field_imgPath));
        if (parambo.ESl == 1) {
          a(paramk, parambo.ESm);
        }
      }
      else
      {
        if (paramk.fpS().IdK.isPlaying()) {
          paramk.fpS().IdK.stop();
        }
        if ((paramk.fpS().IdK instanceof VideoPlayerTextureView))
        {
          if (!aj.fhA()) {
            break label376;
          }
          ((VideoPlayerTextureView)paramk.fpS().IdK).setScaleType(com.tencent.mm.pluginsdk.ui.h.e.DnJ);
        }
      }
    }
    for (;;)
    {
      paramk.IdM.setVisibility(8);
      paramk.fpS().IdL.setVisibility(8);
      paramk.fpS().IdU.setVisibility(8);
      paramk.c(false, 0.0F);
      this.Idg = 0;
      this.yCC = bs.eWj();
      AppMethodBeat.o(36262);
      return true;
      b(paramk);
      break;
      com.tencent.mm.modelvideo.o.aJy();
      parambo = BackwardSupportUtil.b.n(com.tencent.mm.modelvideo.t.DW(parambo.field_imgPath), 1.0F);
      paramk.fpS().IdI.setImageBitmap(parambo);
      b(paramk);
      break;
      label376:
      ((VideoPlayerTextureView)paramk.fpS().IdK).setScaleType(com.tencent.mm.pluginsdk.ui.h.e.DnH);
    }
  }
  
  protected final void aJm()
  {
    AppMethodBeat.i(36296);
    k localk = this.HZU.fph();
    if (localk == null)
    {
      AppMethodBeat.o(36296);
      return;
    }
    ac.i("MicroMsg.Imagegallery.handler.video", "start to pause");
    this.HZU.HZV.setVideoStateIv(true);
    localk.fpS().IdU.setVisibility(0);
    localk.fpS().IdK.pause();
    dOe();
    AppMethodBeat.o(36296);
  }
  
  protected final void aQB(String paramString)
  {
    AppMethodBeat.i(36299);
    if ((!this.Ido) && (!b((a)this.IbT.get(paramString)))) {
      ac.w("MicroMsg.Imagegallery.handler.video", "show tool bar error.");
    }
    AppMethodBeat.o(36299);
  }
  
  public final void abG(int paramInt)
  {
    AppMethodBeat.i(36291);
    this.Idb.remove(paramInt);
    AppMethodBeat.o(36291);
  }
  
  protected final void abH(int paramInt)
  {
    AppMethodBeat.i(36298);
    paramInt = Math.max(0, paramInt);
    this.HZU.HZV.fpr().zRK.seek(paramInt);
    if ((this.Idc != null) && (this.Idc.hYA > 0L)) {
      this.HZU.HZV.fpr().zRK.XA((int)this.Idc.hYA);
    }
    AppMethodBeat.o(36298);
  }
  
  protected final void aw(int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(36295);
    k localk = this.HZU.fph();
    if (localk == null)
    {
      AppMethodBeat.o(36295);
      return;
    }
    dOd();
    localk.fpS().IdU.setVisibility(8);
    localk.fpS().IdK.d(paramInt * 1000, paramBoolean);
    this.HZU.HZV.setVideoStateIv(false);
    eT(false);
    AppMethodBeat.o(36295);
  }
  
  public final void axj() {}
  
  public final void axk() {}
  
  public final void axl() {}
  
  public final void axm() {}
  
  protected final void bN(final String paramString, final boolean paramBoolean)
  {
    AppMethodBeat.i(36294);
    ap.f(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(36248);
        ac.i("MicroMsg.Imagegallery.handler.video", "prepare video filename %s isOnlinePlay %b ", new Object[] { paramString, Boolean.valueOf(paramBoolean) });
        if (j.m(j.this) == null)
        {
          ac.w("MicroMsg.Imagegallery.handler.video", "prepare video but cache map is null.");
          AppMethodBeat.o(36248);
          return;
        }
        j.a locala = (j.a)j.m(j.this).get(paramString);
        if ((locala == null) || (locala.cZc == null))
        {
          AppMethodBeat.o(36248);
          return;
        }
        s locals = j.ck(locala.cZc);
        if (j.this.HZU.HZV.getCurrentItem() == locala.pos)
        {
          j.a(j.this, locala.cZc, locals, locala.pos, paramBoolean);
          j.this.aQB(paramString);
          AppMethodBeat.o(36248);
          return;
        }
        ac.w("MicroMsg.Imagegallery.handler.video", "playVideo, but currentItem is not correct.[%d, %d]", new Object[] { Integer.valueOf(j.this.HZU.HZV.getCurrentItem()), Integer.valueOf(locala.pos) });
        AppMethodBeat.o(36248);
      }
    });
    AppMethodBeat.o(36294);
  }
  
  protected final boolean dOb()
  {
    AppMethodBeat.i(36297);
    k localk = this.HZU.fph();
    if (localk == null)
    {
      AppMethodBeat.o(36297);
      return false;
    }
    boolean bool = true;
    if (!localk.fpS().IdK.isPlaying())
    {
      ac.i("MicroMsg.Imagegallery.handler.video", "start to play");
      this.HZU.HZV.setVideoStateIv(false);
      localk.fpS().IdU.setVisibility(8);
      bool = localk.fpS().IdK.start();
      dOd();
    }
    if (localk.fpS().IdU.getVisibility() != 8) {
      localk.fpS().IdU.setVisibility(8);
    }
    AppMethodBeat.o(36297);
    return bool;
  }
  
  public final void detach()
  {
    AppMethodBeat.i(36284);
    ac.i("MicroMsg.Imagegallery.handler.video", "detach.[%d]", new Object[] { Integer.valueOf(hashCode()) });
    this.yCD = bs.eWj();
    this.Idl.removeMessages(1);
    dNR();
    com.tencent.mm.sdk.b.a.GpY.d(this.Ida);
    com.tencent.mm.sdk.b.a.GpY.d(this.Idn);
    MT();
    this.HZU.HZV.getContext().getWindow().clearFlags(128);
    this.HZU.HZV.fpr().zRK.setIplaySeekCallback(null);
    super.detach();
    this.IbT.clear();
    this.IbT = null;
    com.tencent.mm.modelvideo.o.aJy().a(this);
    this.Idb.clear();
    n localn = this.Idc;
    localn.reset();
    localn.yDa = null;
    localn.IeE = null;
    localn.IeF = null;
    if (com.tencent.mm.plugin.o.f.dcV()) {
      az.agU().az(new j.9(this));
    }
    com.tencent.mm.modelvideo.o.aJD().aJV();
    com.tencent.mm.modelvideo.o.aJD().run();
    AppMethodBeat.o(36284);
  }
  
  protected final void eT(boolean paramBoolean)
  {
    AppMethodBeat.i(36289);
    if (!this.Ide)
    {
      if (this.yCy)
      {
        if (paramBoolean)
        {
          ap.f(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(36257);
              for (;;)
              {
                try
                {
                  if (!bs.isNullOrNil(j.this.HZU.fph().fpS().IdK.getVideoPath())) {
                    continue;
                  }
                  i = com.tencent.mm.modelvideo.u.M(j.g(j.this).hYw, j.b(j.this));
                  j.g(j.this).pG(i);
                }
                catch (Exception localException)
                {
                  int i;
                  ac.printErrStackTrace("MicroMsg.Imagegallery.handler.video", localException, "start timer error[%s]", new Object[] { localException.toString() });
                  continue;
                }
                j.n(j.this).au(500L, 500L);
                AppMethodBeat.o(36257);
                return;
                i = j.this.HZU.fph().fpS().IdK.getCurrentPosition() / 1000;
              }
            }
          });
          AppMethodBeat.o(36289);
          return;
        }
        this.yqI.au(500L, 500L);
        AppMethodBeat.o(36289);
        return;
      }
      this.oef.au(500L, 500L);
    }
    AppMethodBeat.o(36289);
  }
  
  public final void fpK()
  {
    AppMethodBeat.i(36285);
    this.Ide = false;
    this.qUR = 0;
    if (this.HZU != null) {}
    for (Object localObject = this.HZU.fph(); localObject == null; localObject = null)
    {
      ac.w("MicroMsg.Imagegallery.handler.video", "notify video prepared, but holder is null.");
      AppMethodBeat.o(36285);
      return;
    }
    final int i = bs.Aq(((k)localObject).fpS().IdK.getDuration());
    int j = this.HZU.HZV.fpr().zRK.getVideoTotalTime();
    ac.i("MicroMsg.Imagegallery.handler.video", "%d videoDuration %d hadSetTotalTime %d", new Object[] { Integer.valueOf(hashCode()), Integer.valueOf(i), Integer.valueOf(j) });
    if ((j <= 0) || (Math.abs(j - i) >= 2)) {
      this.HZU.HZV.fpr().zRK.setVideoTotalTime(i);
    }
    fpM();
    if ((i == 0) || (i >= 1800))
    {
      ac.w("MicroMsg.Imagegallery.handler.video", "%d repair video duration[%d] error. filename[%s]", new Object[] { Integer.valueOf(hashCode()), Integer.valueOf(i), this.filename });
      i = com.tencent.mm.modelvideo.u.M(i, this.filename);
      ac.i("MicroMsg.Imagegallery.handler.video", "notify video prepared. isOnlinePlay[%b] playDuration[%d] playVideoWhenNotify[%b] hadPlayError[%b].", new Object[] { Boolean.valueOf(this.yCy), Integer.valueOf(i), Boolean.valueOf(this.Idd), Boolean.valueOf(this.Ide) });
      ((k)localObject).fpS().IdK.setOneTimeVideoTextureUpdateCallback(this.yCq);
      if (!this.Idd) {
        break label399;
      }
      if (this.yCy) {
        break label347;
      }
      this.Idc.reset();
      dOd();
      aw(i, true);
    }
    for (;;)
    {
      eT(false);
      AppMethodBeat.o(36285);
      return;
      az.agU().az(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(36249);
          Object localObject = j.b(j.this);
          int i = i;
          localObject = com.tencent.mm.modelvideo.u.Ej((String)localObject);
          if (localObject != null)
          {
            int j = ((s)localObject).hpy;
            if ((j <= 0) || (Math.abs(j - i) > 2))
            {
              ((s)localObject).hpy = i;
              ((s)localObject).drx = 4096;
              ac.i("MicroMsg.VideoLogic", "repair video duration ret %b, duration[%d, %d]", new Object[] { Boolean.valueOf(com.tencent.mm.modelvideo.u.f((s)localObject)), Integer.valueOf(j), Integer.valueOf(i) });
            }
          }
          AppMethodBeat.o(36249);
        }
      });
      break;
      label347:
      localObject = this.Idc;
      if (i > 0)
      {
        ac.i("MicroMsg.OnlineVideoUIHelper", "seek to last duration : ".concat(String.valueOf(i)));
        ((n)localObject).hYx = i;
        ((n)localObject).hYz = true;
        ((n)localObject).hYu = 2;
      }
      this.Idc.pG(0);
    }
    label399:
    if (!this.yCy) {
      aw(i, false);
    }
    for (;;)
    {
      abH(i);
      this.HZU.HZV.setVideoStateIv(true);
      dNR();
      AppMethodBeat.o(36285);
      return;
      this.Idc.ba(i, false);
    }
  }
  
  public final void fpL()
  {
    AppMethodBeat.i(36286);
    ac.i("MicroMsg.Imagegallery.handler.video", "notify video completion. isOnlinePlay : " + this.yCy);
    dNR();
    releaseWakeLock();
    dOe();
    Object localObject1;
    if ((this.yCy) && (this.HZU != null) && (this.HZU.fph() != null))
    {
      localObject1 = this.HZU.fph().fpS().IdK;
      if ((localObject1 != null) && (((com.tencent.mm.pluginsdk.ui.tools.h)localObject1).getCurrentPosition() + 2000 < ((com.tencent.mm.pluginsdk.ui.tools.h)localObject1).getDuration())) {
        ac.e("MicroMsg.Imagegallery.handler.video", "notify video completion, but cur pos[%d] is less than duration[%d]", new Object[] { Integer.valueOf(((com.tencent.mm.pluginsdk.ui.tools.h)localObject1).getCurrentPosition()), Integer.valueOf(((com.tencent.mm.pluginsdk.ui.tools.h)localObject1).getDuration()) });
      }
    }
    for (int i = 0;; i = 1)
    {
      if (i != 0)
      {
        ap.f(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(36255);
            j.i(j.this);
            j.a(j.this, j.j(j.this));
            j.e(j.this).ev(false);
            j.k(j.this);
            if (j.d(j.this))
            {
              j.b(j.this, bs.eWj());
              j.g(j.this).fpW();
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
                k localk = j.this.HZU.fph();
                localk.fpS().IdK.stop();
                j.a(j.this, 0);
                j.this.a(localk, locala.cZc, locala.pos);
                j.this.abH(0);
                if (localk.fpS().IdU.getVisibility() != 8) {
                  localk.fpS().IdU.setVisibility(8);
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
        i = this.HZU.fph().IdK.getCurrentPosition();
        com.tencent.mm.modelvideo.u.e(this.filename, i, this.yCy);
        this.HZU.fph().IdK.stop();
        this.Idc.fpX();
        i = this.Idm + 1;
        this.Idm = i;
        if (i <= 3)
        {
          localObject1 = (a)this.IbT.get(this.filename);
          if (localObject1 != null)
          {
            localObject2 = ((a)localObject1).cZc;
            if (localObject2 != null) {}
          }
          else
          {
            AppMethodBeat.o(36286);
            return;
          }
          Object localObject2 = ck(((a)localObject1).cZc);
          a(((a)localObject1).cZc, (s)localObject2, ((a)localObject1).pos, this.yCy);
        }
        AppMethodBeat.o(36286);
        return;
      }
      catch (Exception localException)
      {
        ac.printErrStackTrace("MicroMsg.Imagegallery.handler.video", localException, "notify video completion error[%s]", new Object[] { localException.toString() });
        AppMethodBeat.o(36286);
        return;
      }
    }
  }
  
  protected final int getPlayVideoDuration()
  {
    AppMethodBeat.i(36302);
    if (this.yCN < 0) {
      this.yCN = 0;
    }
    ac.i("MicroMsg.Imagegallery.handler.video", "get[%s] play video duration [%d]", new Object[] { this.filename, Integer.valueOf(this.yCN) });
    int i = this.yCN;
    AppMethodBeat.o(36302);
    return i;
  }
  
  protected final int getUiStayTime()
  {
    AppMethodBeat.i(36303);
    if ((this.yCD > 0L) && (this.yCC > 0L)) {}
    for (int i = (int)(this.yCD - this.yCC);; i = 0)
    {
      int j = i;
      if (i < 0) {
        j = 0;
      }
      ac.i("MicroMsg.Imagegallery.handler.video", "%d filename[%s] get ui stay time[%d %d %d]", new Object[] { Integer.valueOf(hashCode()), this.filename, Integer.valueOf(j), Long.valueOf(this.yCD), Long.valueOf(this.yCC) });
      AppMethodBeat.o(36303);
      return j;
    }
  }
  
  public final void j(final bo parambo, final int paramInt)
  {
    AppMethodBeat.i(36270);
    ac.i("MicroMsg.Imagegallery.handler.video", "toggle video");
    if (parambo == null)
    {
      AppMethodBeat.o(36270);
      return;
    }
    if ((!b.m(parambo)) && (!b.bR(parambo)))
    {
      AppMethodBeat.o(36270);
      return;
    }
    final s locals = cm(parambo);
    this.filename = locals.getFileName();
    if ((locals.status == 199) || (locals.status == 123)) {}
    final boolean bool2;
    Object localObject1;
    for (boolean bool1 = true;; bool1 = false)
    {
      bool2 = bool1;
      if (parambo.cru())
      {
        ac.i("MicroMsg.Imagegallery.handler.video", "MP_VIDEO toggle mp video,status : %d", new Object[] { Integer.valueOf(locals.status) });
        com.tencent.mm.modelvideo.o.aJy();
        localObject1 = com.tencent.mm.modelvideo.t.DV(parambo.field_imgPath);
        bool2 = bool1;
        if (bool1)
        {
          bool2 = bool1;
          if (!i.eA((String)localObject1))
          {
            bool2 = false;
            locals.status = 111;
            com.tencent.mm.modelvideo.o.aJy().c(locals);
            ac.i("MicroMsg.Imagegallery.handler.video", "MP_VIDEO_WARN user delete local file,reset video info status");
          }
        }
      }
      if (!parambo.cru()) {
        break label894;
      }
      localObject1 = cl(parambo);
      if (localObject1 != null) {
        break;
      }
      ac.w("MicroMsg.Imagegallery.handler.video", "MP_VIDEO_ERROR mpShareVideoInfo is null");
      AppMethodBeat.o(36270);
      return;
    }
    ac.i("MicroMsg.Imagegallery.handler.video", "mpVideo videoDownload %b, playKey %s", new Object[] { Boolean.valueOf(bool2), ((com.tencent.mm.ah.y)localObject1).vG(parambo.field_imgPath) });
    Object localObject2 = m.IeA;
    localObject2 = m.anB(((com.tencent.mm.ah.y)localObject1).vG(parambo.field_imgPath));
    Object localObject3 = m.IeA;
    localObject3 = m.aQC(((com.tencent.mm.ah.y)localObject1).vG(parambo.field_imgPath));
    if (((bwx)localObject3).ESl == 1)
    {
      ac.i("MicroMsg.Imagegallery.handler.video", "MP_VIDEO block video");
      a(abi(paramInt), ((bwx)localObject3).ESm);
      AppMethodBeat.o(36270);
      return;
    }
    b(abi(paramInt));
    if ((!bs.isNullOrNil((String)localObject2)) && ((locals.hux <= 0) || (!((String)localObject2).equals(locals.iaR.hjV))))
    {
      ac.i("MicroMsg.Imagegallery.handler.video", "MP_VIDEO  update video info. playUrl:%s, length:%d", new Object[] { localObject2, Integer.valueOf(((bwx)localObject3).EnO) });
      locals.iaR.hjV = ((String)localObject2);
      locals.hux = ((bwx)localObject3).EnO;
      com.tencent.mm.modelvideo.o.aJy().c(locals);
    }
    localObject2 = new WeakReference(this);
    localObject3 = m.IeA;
    Object localObject4 = parambo.field_imgPath;
    localObject3 = new IPCRunCgi.a()
    {
      public final void a(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, com.tencent.mm.ak.b paramAnonymousb)
      {
        AppMethodBeat.i(36239);
        if ((paramAnonymousInt1 == 0) && (paramAnonymousInt2 == 0))
        {
          ac.i("MicroMsg.Imagegallery.handler.video", "MP_VIDEO  end do exchange video link success");
          paramAnonymousString = (bcb)paramAnonymousb.hvs.hvw;
          paramAnonymousb = m.IeA;
          m.a(this.IcX.vG(parambo.field_imgPath), paramAnonymousString);
          if ((this.Idr.get() == null) || (j.a((j)this.Idr.get())))
          {
            AppMethodBeat.o(36239);
            return;
          }
          paramAnonymousb = (j)this.Idr.get();
          k localk = paramAnonymousb.abi(paramInt);
          if (paramAnonymousString.ESl == 1)
          {
            ac.w("MicroMsg.Imagegallery.handler.video", "doGetPlayUrl block %s", new Object[] { paramAnonymousString.ESm });
            j.a(paramAnonymousb, paramAnonymousb.abi(paramInt));
            com.tencent.mm.modelvideo.o.aJy();
            i.deleteFile(com.tencent.mm.modelvideo.t.DV(parambo.field_imgPath));
            locals.status = 111;
            com.tencent.mm.modelvideo.o.aJy().c(locals);
            if (paramAnonymousb.HZU.fph() == localk) {
              j.a(paramAnonymousb, localk, paramAnonymousString.ESm);
            }
            AppMethodBeat.o(36239);
            return;
          }
          if (!bool2)
          {
            locals.hpy = paramAnonymousString.EnO;
            locals.iaR.hjV = paramAnonymousString.wYr;
            com.tencent.mm.modelvideo.o.aJy().c(locals);
          }
          if ((!bool2) && (paramAnonymousb.HZU.fph() == localk) && (!paramAnonymousb.HZU.HZV.een())) {
            paramAnonymousb.j(parambo, paramInt);
          }
          AppMethodBeat.o(36239);
          return;
        }
        ac.w("MicroMsg.Imagegallery.handler.video", "MP_VIDEO_ERROR  end do exchange video link fail %d/%d %s", new Object[] { Integer.valueOf(paramAnonymousInt2), Integer.valueOf(paramAnonymousInt1), paramAnonymousString });
        AppMethodBeat.o(36239);
      }
    };
    d.g.b.k.h(localObject1, "mPShareVideoInfo");
    d.g.b.k.h(localObject4, "imgPath");
    d.g.b.k.h(localObject3, "callBack");
    localObject2 = ((com.tencent.mm.ah.y)localObject1).vG((String)localObject4);
    long l = com.tencent.mm.model.y.ayq().F((String)localObject2, true).tx(m.Iew);
    int i;
    if (Math.abs(System.currentTimeMillis() - l) < 300000L)
    {
      d.g.b.k.g(localObject2, "key");
      if (!bs.isNullOrNil(m.anB((String)localObject2)))
      {
        ac.i(m.TAG, "not do cgi in 5 min");
        i = 0;
      }
    }
    while ((i != 0) && (!bool2))
    {
      parambo = abi(paramInt);
      if (parambo != null)
      {
        parambo.fpS();
        parambo.fpS().IdJ.setVisibility(8);
        parambo.fpS().IdU.setVisibility(0);
      }
      AppMethodBeat.o(36270);
      return;
      if ((m.Iez.containsKey(localObject2)) && (m.Iez.get(localObject2) != null))
      {
        localObject4 = m.Iez.get(localObject2);
        if (localObject4 == null) {
          d.g.b.k.fOy();
        }
        if (((Boolean)localObject4).booleanValue())
        {
          ac.w(m.TAG, (String)localObject2 + " is doing");
          i = 0;
          continue;
        }
      }
      ac.i(m.TAG, "MP_VIDEO  start do exchange video link");
      localObject4 = (Map)m.Iez;
      d.g.b.k.g(localObject2, "key");
      ((Map)localObject4).put(localObject2, Boolean.TRUE);
      localObject4 = new v.f();
      ((v.f)localObject4).KUQ = new WeakReference(localObject3);
      localObject3 = new bca();
      ((bca)localObject3).hhd = ((com.tencent.mm.ah.y)localObject1).DWG;
      ((bca)localObject3).ESj = ((com.tencent.mm.ah.y)localObject1).DWF;
      ((bca)localObject3).ESk = ((com.tencent.mm.ah.y)localObject1).videoUrl;
      localObject1 = new b.a();
      ((b.a)localObject1).hvt = ((com.tencent.mm.bw.a)localObject3);
      ((b.a)localObject1).hvu = ((com.tencent.mm.bw.a)new bcb());
      ((b.a)localObject1).uri = "/cgi-bin/mmbiz-bin/appmsg/getplayurl";
      ((b.a)localObject1).funcId = 2962;
      ((b.a)localObject1).reqCmdId = 0;
      ((b.a)localObject1).respCmdId = 0;
      IPCRunCgi.a(((b.a)localObject1).aAz(), (IPCRunCgi.a)new m.a((String)localObject2, (v.f)localObject4));
      i = 1;
    }
    label894:
    b(abi(paramInt));
    if ((this.yCy) && (this.Idc != null) && (this.Idc.hYz))
    {
      ac.i("MicroMsg.Imagegallery.handler.video", "%d it loading video data, do not response button click.", new Object[] { Integer.valueOf(hashCode()) });
      AppMethodBeat.o(36270);
      return;
    }
    if (this.HZU.HZV.een())
    {
      e(abi(paramInt));
      d(abi(paramInt));
      this.HZU.HZV.setVideoStateIv(true);
      this.HZU.HZV.qUX.stopTimer();
      this.nQt.ev(false);
      releaseWakeLock();
      ac.i("MicroMsg.Imagegallery.handler.video", "toggle pause video.");
      AppMethodBeat.o(36270);
      return;
    }
    az.ayM();
    if (!com.tencent.mm.model.c.isSDCardAvailable())
    {
      com.tencent.mm.ui.base.t.g(this.HZU.HZV.getContext(), null);
      AppMethodBeat.o(36270);
      return;
    }
    int j;
    if (this.yCy)
    {
      j = 0;
      i = j;
    }
    for (;;)
    {
      try
      {
        if (this.HZU.fph().IdK != null) {
          i = this.HZU.fph().IdK.getCurrentPosition() / 1000;
        }
        if (this.Idc != null) {
          if (this.Idc.pH(i))
          {
            ac.i("MicroMsg.Imagegallery.handler.video", "toggle play video");
            a(parambo, locals, paramInt, this.yCy);
            if (this.HZU.HZV.IcL) {
              this.HZU.HZV.fpD();
            }
            fpM();
            this.gqI = ((PowerManager)ai.getContext().getSystemService("power")).newWakeLock(536870922, "MicroMsg.Imagegallery.handler.video");
            this.gqI.acquire();
            ac.i("MicroMsg.Imagegallery.handler.video", "acquire wakelock");
            AppMethodBeat.o(36270);
            return;
          }
        }
      }
      catch (Exception localException)
      {
        ac.printErrStackTrace("MicroMsg.Imagegallery.handler.video", localException, "", new Object[0]);
        i = j;
        continue;
        ac.i("MicroMsg.Imagegallery.handler.video", "toggle start timer.");
        eT(false);
        continue;
        ac.w("MicroMsg.Imagegallery.handler.video", "%d toggle video but online video helper is null.", new Object[] { Integer.valueOf(hashCode()) });
        continue;
      }
      if (parambo.field_isSend == 0)
      {
        if ((locals.status != 113) && (locals.status != 198)) {
          break label1412;
        }
        a(parambo, locals);
      }
      for (;;)
      {
        if (parambo.field_isSend != 1) {
          break label1513;
        }
        i = locals.status;
        if ((i != 111) && (i != 113) && (i != 112) && (i != 121) && (i != 122)) {
          break label1515;
        }
        ac.i("MicroMsg.Imagegallery.handler.video", "download video. msg talker[%s], info status[%d]", new Object[] { parambo.field_talker, Integer.valueOf(i) });
        a(parambo, locals);
        break;
        label1412:
        if (locals.status == 199) {
          a(parambo, locals, paramInt, false);
        }
        if (locals.status == 111) {
          a(parambo, locals);
        }
        if (locals.status == 112) {
          a(parambo, locals);
        }
        if ((locals.status == 121) || (locals.status == 122)) {
          a(parambo, locals);
        }
        if (locals.status == 123) {
          a(parambo, locals, paramInt, false);
        }
      }
      label1513:
      continue;
      label1515:
      a(parambo, locals, paramInt, false);
    }
  }
  
  public final void jG(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(36287);
    boolean bool2 = this.yCy;
    Object localObject = this.Idc;
    boolean bool1;
    if ((!bs.isNullOrNil(((n)localObject).mediaId)) && (((n)localObject).hYt == 1))
    {
      bool1 = true;
      ac.e("MicroMsg.Imagegallery.handler.video", "notify video error, what %d, extras %d isOnlinePlay %b isLoading %b ", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Boolean.valueOf(bool2), Boolean.valueOf(bool1) });
      this.Ide = true;
      this.qUR = paramInt2;
      if (!this.yCy) {
        break label281;
      }
      if (paramInt1 != -1) {
        break label193;
      }
      dNR();
      this.HZU.fph().IdK.stop();
      this.Idc.fpX();
    }
    label193:
    do
    {
      for (;;)
      {
        this.Ido = false;
        this.HZU.HZV.setVideoStateIv(true);
        this.HZU.fph().fpS().IdU.setVisibility(0);
        dOe();
        com.tencent.mm.plugin.report.service.h.wUl.idkeyStat(354L, 18L, 1L, false);
        AppMethodBeat.o(36287);
        return;
        bool1 = false;
        break;
        if (paramInt1 != -2) {
          break label256;
        }
        dNR();
        paramInt1 = this.HZU.fph().IdK.getCurrentPosition();
        com.tencent.mm.modelvideo.u.e(this.filename, paramInt1, this.yCy);
        this.HZU.fph().IdK.stop();
        this.Idc.fpX();
      }
    } while (paramInt1 != -3);
    label256:
    this.Ide = false;
    this.Idc.fpX();
    AppMethodBeat.o(36287);
    return;
    label281:
    com.tencent.mm.modelvideo.u.Em(this.filename);
    dOe();
    if ((this.HZU != null) && (this.HZU.fph() != null) && (this.HZU.fph().IdK != null))
    {
      localObject = this.HZU.fph().IdK.getVideoPath();
      this.HZU.fph().IdK.stop();
    }
    while (this.Idf)
    {
      ac.i("MicroMsg.Imagegallery.handler.video", "%d had play completion don't show error tips", new Object[] { Integer.valueOf(hashCode()) });
      AppMethodBeat.o(36287);
      return;
      localObject = "";
    }
    ap.f(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(36256);
        if ((j.this.HZU == null) || (j.this.HZU.fph() == null) || (j.m(j.this) == null))
        {
          ac.w("MicroMsg.Imagegallery.handler.video", "show error alert but adapter is null.");
          AppMethodBeat.o(36256);
          return;
        }
        j.this.HZU.fph().c(false, 0.0F);
        if (!bs.isNullOrNil(this.qVb)) {
          ac.e("MicroMsg.Imagegallery.handler.video", "mediaplay play video error, use third player.[%s]", new Object[] { this.qVb });
        }
        try
        {
          Object localObject2 = new Intent();
          ((Intent)localObject2).setAction("android.intent.action.VIEW");
          com.tencent.mm.sdk.platformtools.m.a(j.this.HZU.HZV, (Intent)localObject2, new com.tencent.mm.vfs.e(this.qVb), "video/*");
          Object localObject1 = j.this.HZU.HZV;
          localObject2 = new com.tencent.mm.hellhoundlib.b.a().ba(localObject2);
          com.tencent.mm.hellhoundlib.a.a.a(localObject1, ((com.tencent.mm.hellhoundlib.b.a)localObject2).aeD(), "com/tencent/mm/ui/chatting/gallery/ImageGalleryVideoHandler$5", "run", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          ((ImageGalleryUI)localObject1).startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject2).lR(0));
          com.tencent.mm.hellhoundlib.a.a.a(localObject1, "com/tencent/mm/ui/chatting/gallery/ImageGalleryVideoHandler$5", "run", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          localObject1 = (j.a)j.m(j.this).get(j.b(j.this));
          if ((localObject1 == null) || (((j.a)localObject1).cZc == null))
          {
            AppMethodBeat.o(36256);
            return;
          }
        }
        catch (Exception localException)
        {
          for (;;)
          {
            ac.e("MicroMsg.Imagegallery.handler.video", "startActivity fail, activity not found");
            com.tencent.mm.ui.base.h.l(j.this.HZU.HZV, 2131758931, 2131758932);
          }
          j.this.abG(localException.pos);
          AppMethodBeat.o(36256);
        }
      }
    });
    com.tencent.mm.plugin.report.service.h.wUl.idkeyStat(354L, 25L, 1L, false);
    AppMethodBeat.o(36287);
  }
  
  public final void k(bo parambo, int paramInt)
  {
    AppMethodBeat.i(36273);
    ac.i("MicroMsg.Imagegallery.handler.video", "toggleVideoMenu pos ");
    s locals = com.tencent.mm.modelvideo.u.Ej(parambo.field_imgPath);
    if ((locals != null) && (!locals.aJN()))
    {
      d(abi(paramInt));
      this.HZU.HZV.setVideoStateIv(true);
      if (this.yCy)
      {
        this.Idc.fpW();
        this.Idc.reset();
      }
      a(parambo, locals);
      if (this.HZU.HZV.Br(parambo.field_msgId) == 2)
      {
        gf(parambo.field_imgPath, 8);
        AppMethodBeat.o(36273);
        return;
      }
      gf(parambo.field_imgPath, 5);
    }
    AppMethodBeat.o(36273);
  }
  
  protected final void onResume()
  {
    AppMethodBeat.i(36282);
    ac.i("MicroMsg.Imagegallery.handler.video", "ui on resume, add online video event.");
    this.Idl.removeMessages(1);
    com.tencent.mm.sdk.b.a.GpY.c(this.Idn);
    if ((this.HZU != null) && (com.tencent.mm.compatible.util.d.kZ(21)))
    {
      k localk = this.HZU.fph();
      if ((localk != null) && (localk.IdK != null))
      {
        if ((localk.IdK instanceof VideoPlayerTextureView))
        {
          ((VideoPlayerTextureView)localk.IdK).bld();
          AppMethodBeat.o(36282);
          return;
        }
        if ((localk.IdK instanceof VideoTextureView)) {
          ((VideoTextureView)localk.IdK).bld();
        }
      }
    }
    AppMethodBeat.o(36282);
  }
  
  public final void pause(int paramInt)
  {
    AppMethodBeat.i(36267);
    d(abi(paramInt));
    this.nQt.ev(false);
    this.HZU.HZV.setVideoStateIv(true);
    AppMethodBeat.o(36267);
  }
  
  public static final class a
  {
    public bo cZc;
    public int pos;
    
    public a(bo parambo, int paramInt)
    {
      this.cZc = parambo;
      this.pos = paramInt;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.gallery.j
 * JD-Core Version:    0.7.0.1
 */