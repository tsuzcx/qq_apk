package com.tencent.mm.ui.chatting.gallery;

import android.content.Context;
import android.os.Looper;
import android.os.PowerManager;
import android.os.PowerManager.WakeLock;
import android.support.v7.app.AppCompatActivity;
import android.util.SparseArray;
import android.view.View;
import android.view.Window;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.lu;
import com.tencent.mm.g.c.dd;
import com.tencent.mm.model.aw;
import com.tencent.mm.model.d.a;
import com.tencent.mm.model.n;
import com.tencent.mm.modelsimple.aa;
import com.tencent.mm.modelvideo.o;
import com.tencent.mm.modelvideo.r;
import com.tencent.mm.modelvideo.s;
import com.tencent.mm.modelvideo.t.a;
import com.tencent.mm.modelvideo.t.a.a;
import com.tencent.mm.modelvideo.y.a;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.pluginsdk.ui.tools.VideoPlayerSeekBar;
import com.tencent.mm.pluginsdk.ui.tools.VideoPlayerTextureView;
import com.tencent.mm.pluginsdk.ui.tools.VideoTextureView;
import com.tencent.mm.pluginsdk.ui.tools.e.e;
import com.tencent.mm.protocal.protobuf.bby;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.b;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.ac.a;
import com.tencent.mm.storage.bi;
import com.tencent.mm.storage.z;
import com.tencent.mm.ui.chatting.ak.a;
import com.tencent.mm.ui.widget.MMPinProgressBtn;
import java.util.HashMap;

public final class j
  extends a
  implements d.a, t.a
{
  public static boolean zMW = false;
  private String filename;
  private com.tencent.mm.model.d idF;
  private ap kvM;
  private long lastCheckTime;
  int mEx;
  private com.tencent.mm.plugin.n.b oEQ;
  private e.e rIZ;
  private boolean rJj;
  private long rJn;
  private long rJo;
  private long rJw;
  private int rJx;
  private ap ryl;
  private PowerManager.WakeLock tDZ;
  private long vPB;
  private com.tencent.mm.plugin.sight.decode.ui.b vPG;
  private HashMap<String, j.a> zLG;
  private com.tencent.mm.sdk.b.c zMM;
  final SparseArray<s> zMN;
  private m zMO;
  private boolean zMP;
  private boolean zMQ;
  private boolean zMR;
  private int zMS;
  private int zMT;
  private int zMU;
  private boolean zMV;
  com.tencent.mm.sdk.platformtools.ak zMX;
  private int zMY;
  private com.tencent.mm.sdk.b.c<lu> zMZ;
  private boolean zNa;
  private int zNb;
  private int[] zNc;
  
  public j(c paramc)
  {
    super(paramc);
    AppMethodBeat.i(32335);
    this.zMN = new SparseArray();
    this.zMP = false;
    this.zMQ = false;
    this.zMR = false;
    this.zMS = 0;
    this.vPB = 0L;
    this.lastCheckTime = 0L;
    this.zMT = 0;
    this.zMU = 0;
    this.rJn = 0L;
    this.rJo = 0L;
    this.mEx = 0;
    this.zMV = false;
    this.zMX = new com.tencent.mm.sdk.platformtools.ak(Looper.getMainLooper(), new j.9(this));
    this.zMY = 0;
    this.ryl = new ap(new j.13(this), true);
    this.kvM = new ap(new j.14(this), true);
    this.vPG = new j.2(this);
    this.zMZ = new j.3(this);
    this.zNa = false;
    this.zNb = 0;
    this.zNc = new int[] { -1000, -2000, 3400 };
    this.rIZ = new j.6(this);
    this.oEQ = new j.7(this);
    this.zLG = new HashMap();
    this.zMO = new m(this);
    com.tencent.mm.sdk.b.a locala = com.tencent.mm.sdk.b.a.ymk;
    paramc = new com.tencent.mm.ui.chatting.ak(ak.a.zCj, paramc.zJK);
    this.zMM = paramc;
    locala.c(paramc);
    com.tencent.mm.sdk.b.a.ymk.c(this.zMZ);
    this.idF = new com.tencent.mm.model.d();
    AppMethodBeat.o(32335);
  }
  
  private void a(bi parambi, s params)
  {
    AppMethodBeat.i(32342);
    if ((!com.tencent.mm.network.ac.cm(this.zJI.zJK.getContext())) && (!zMW)) {
      zMW = true;
    }
    b(parambi, params);
    AppMethodBeat.o(32342);
  }
  
  private void a(bi parambi, s params, int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(32341);
    if ((parambi == null) || (params == null))
    {
      AppMethodBeat.o(32341);
      return;
    }
    if (parambi.dyc())
    {
      Toast.makeText(this.zJI.zJK, 2131304516, 0).show();
      AppMethodBeat.o(32341);
      return;
    }
    Object localObject3;
    Object localObject1;
    if (params.fXE == -1)
    {
      localObject3 = params.alO();
      localObject1 = localObject3;
      if (!com.tencent.mm.vfs.e.cN((String)localObject3))
      {
        o.alE();
        localObject1 = com.tencent.mm.modelvideo.t.vf(parambi.field_imgPath);
        if ((localObject1 != null) && (com.tencent.mm.vfs.e.cN((String)localObject1))) {
          break label327;
        }
        Toast.makeText(this.zJI.zJK, 2131304516, 0).show();
        AppMethodBeat.o(32341);
      }
    }
    else
    {
      o.alE();
      localObject3 = com.tencent.mm.modelvideo.t.vf(parambi.field_imgPath);
      localObject1 = localObject3;
      if (parambi.field_isSend == 1)
      {
        localObject1 = localObject3;
        if (params.fXH != null)
        {
          localObject1 = localObject3;
          if (!params.fXH.xra) {}
        }
      }
    }
    for (;;)
    {
      try
      {
        String str = com.tencent.mm.vfs.e.avK((String)localObject3);
        localObject1 = str;
        if (!str.endsWith("/")) {
          localObject1 = str + "/";
        }
        str = com.tencent.mm.vfs.e.avM((String)localObject3);
        localObject1 = (String)localObject1 + str + "_hd.mp4";
        bool = com.tencent.mm.vfs.e.cN((String)localObject1);
        ab.i("MicroMsg.Imagegallery.handler.video", "local capture video, hdFilePath: %s, exist: %s", new Object[] { localObject1, Boolean.valueOf(bool) });
        if (!bool) {
          break label1081;
        }
      }
      catch (Exception localException)
      {
        ab.e("MicroMsg.Imagegallery.handler.video", "try to get hd filePath error: %s", new Object[] { localException.getMessage() });
        localObject2 = localObject3;
      }
      break;
      label327:
      localObject3 = PP(paramInt);
      if (localObject3 == null)
      {
        AppMethodBeat.o(32341);
        return;
      }
      int i = 0;
      if (com.tencent.mm.model.t.lA(params.getUser())) {
        i = n.nv(params.getUser());
      }
      boolean bool = r.uY(localObject2);
      int j = this.zJI.zJK.oM(parambi.field_msgId);
      ab.i("MicroMsg.Imagegallery.handler.video", "play video pos[%d], isOnlinePlay[%b] opcode[%d] resetByCompletion[%b]", new Object[] { Integer.valueOf(paramInt), Boolean.valueOf(paramBoolean), Integer.valueOf(j), Boolean.valueOf(this.zMV) });
      if (!bool)
      {
        if ((com.tencent.mm.compatible.e.ac.erF.eph == 1) && (com.tencent.mm.pluginsdk.h.b.a.a.b(params.getFileName(), this.zJI.zJK.getContext(), bool)))
        {
          AppMethodBeat.o(32341);
          return;
        }
        aw.aaz();
        if ((((Integer)com.tencent.mm.model.c.Ru().get(ac.a.yDR, Integer.valueOf(0))).intValue() == 1) && (((k)localObject3).zNv != null))
        {
          ((k)localObject3).zNv.setVisibility(0);
          ((k)localObject3).zNv.setText(com.tencent.mm.plugin.sight.base.d.TX(localObject2));
        }
        ((k)localObject3).a(params.fXx, params.fsd, i, params.getUser(), s.vc(params.alP()), params.createTime);
        this.rJj = paramBoolean;
        this.zMP = true;
        this.filename = params.getFileName();
        if (j == 3)
        {
          ((k)localObject3).dKP().zNt.setMute(true);
          if ((((k)localObject3).dKP().zNt.getVideoPath() == null) || (!((k)localObject3).dKP().zNt.getVideoPath().equals(localObject2)) || (((k)localObject3).dKP().zNt.isPlaying()) || (this.zMV)) {
            break label829;
          }
          ((k)localObject3).a(true, 1.0F);
          ((k)localObject3).dKP().zNt.start();
          ctZ();
          if (!paramBoolean) {
            aui(this.filename);
          }
          Qm(((k)localObject3).dKP().zNt.getCurrentPosition() / 1000);
          dh(false);
          label731:
          b(paramInt, params);
          this.zJI.zJK.rb(false);
          this.zJI.zJK.getContext().getWindow().addFlags(128);
          if (com.tencent.mm.compatible.util.d.fw(18)) {
            aui(this.filename);
          }
          this.idF.a(this);
        }
      }
      for (;;)
      {
        ((k)localObject3).dKP().zNu.setVisibility(8);
        AppMethodBeat.o(32341);
        return;
        ((k)localObject3).dKP().zNt.setMute(false);
        break;
        label829:
        this.zMR = false;
        this.zMV = false;
        ((k)localObject3).dKP().zNt.setVideoPath(localObject2);
        if ((((k)localObject3).dKP().zNt instanceof VideoPlayerTextureView))
        {
          ((VideoPlayerTextureView)((k)localObject3).dKP().zNt).setIOnlineCache(this.oEQ);
          ((VideoPlayerTextureView)((k)localObject3).dKP().zNt).setNeedResetExtractor(byv());
          ((VideoPlayerTextureView)((k)localObject3).dKP().zNt).setIsOnlineVideoType(paramBoolean);
        }
        ((k)localObject3).a(true, 0.0F);
        break label731;
        h.qsU.e(12084, new Object[] { Integer.valueOf(params.fsd), Integer.valueOf(params.fXx * 1000), Integer.valueOf(0), Integer.valueOf(3), params.getUser(), Integer.valueOf(i), s.vc(params.alP()), Long.valueOf(params.createTime) });
        if (!com.tencent.mm.pluginsdk.h.b.a.a.c(localObject2, this.zJI.zJK.getContext(), bool)) {
          Toast.makeText(this.zJI.zJK.getContext(), this.zJI.zJK.getString(2131304529), 0).show();
        }
      }
      label1081:
      Object localObject2 = localObject3;
    }
  }
  
  private void b(int paramInt, s params)
  {
    AppMethodBeat.i(32355);
    this.zMN.put(paramInt, params);
    AppMethodBeat.o(32355);
  }
  
  private void b(bi parambi, s params)
  {
    AppMethodBeat.i(32343);
    ab.i("MicroMsg.Imagegallery.handler.video", "startDownloading [%d]", new Object[] { Integer.valueOf(hashCode()) });
    if ((parambi == null) || (params == null))
    {
      AppMethodBeat.o(32343);
      return;
    }
    k localk = this.zJI.dJY();
    if (localk == null)
    {
      AppMethodBeat.o(32343);
      return;
    }
    aa.C(parambi);
    int i = this.zJI.zJK.oM(parambi.field_msgId);
    ab.d("MicroMsg.Imagegallery.handler.video", "enterVideoOpCode : ".concat(String.valueOf(i)));
    switch (i)
    {
    default: 
      ab.w("MicroMsg.Imagegallery.handler.video", "enterVideoOpCode[%d] is error", new Object[] { Integer.valueOf(i) });
      AppMethodBeat.o(32343);
      return;
    case 3: 
      ab.i("MicroMsg.Imagegallery.handler.video", "%d mute play video [%d]", new Object[] { Integer.valueOf(hashCode()), Integer.valueOf(i) });
    case 0: 
      if (this.zMO.auj(parambi.field_imgPath))
      {
        ab.i("MicroMsg.Imagegallery.handler.video", "start online play video.");
        this.rJj = true;
        o.alE().a(this);
        this.zJI.zJK.dKu();
        this.zNa = false;
        localk.dKP().zNs.setVisibility(8);
        localk.dKP().zNu.setVisibility(8);
        localk.dKP().zNB.setVisibility(0);
        AppMethodBeat.o(32343);
        return;
      }
      ab.i("MicroMsg.Imagegallery.handler.video", "start offline play video.");
      this.rJj = false;
      o.alE().a(this, Looper.getMainLooper());
      com.tencent.mm.modelvideo.u.vn(parambi.field_imgPath);
      this.zJI.zJK.dKu();
      this.zNa = false;
      localk.dKP().zNs.setVisibility(8);
      localk.dKP().zNu.setVisibility(0);
      localk.dKP().zNu.setProgress(com.tencent.mm.modelvideo.u.g(params));
      AppMethodBeat.o(32343);
      return;
    }
    if (params.alR())
    {
      ab.i("MicroMsg.Imagegallery.handler.video", "start complete online video");
      com.tencent.mm.modelvideo.u.vy(parambi.field_imgPath);
    }
    for (;;)
    {
      o.alE().a(this, Looper.getMainLooper());
      this.zJI.zJK.dKu();
      this.zNa = false;
      localk.dKP().zNs.setVisibility(8);
      localk.dKP().zNu.setVisibility(0);
      localk.dKP().zNu.setProgress(com.tencent.mm.modelvideo.u.g(params));
      if (i != 2) {
        break;
      }
      dKL();
      AppMethodBeat.o(32343);
      return;
      ab.i("MicroMsg.Imagegallery.handler.video", "start complete offline video");
      eR(parambi.field_imgPath, 10);
      com.tencent.mm.modelvideo.u.vn(parambi.field_imgPath);
    }
    dKK();
    AppMethodBeat.o(32343);
  }
  
  private void b(k paramk)
  {
    AppMethodBeat.i(32347);
    if (paramk == null)
    {
      AppMethodBeat.o(32347);
      return;
    }
    releaseWakeLock();
    ctW();
    ab.d("MicroMsg.Imagegallery.handler.video", "pause video.");
    if (paramk.dKP().zNt.isPlaying())
    {
      paramk.dKP().zNt.pause();
      cua();
    }
    AppMethodBeat.o(32347);
  }
  
  private boolean b(j.a parama)
  {
    AppMethodBeat.i(32345);
    if (parama == null)
    {
      AppMethodBeat.o(32345);
      return false;
    }
    o.alE().a(this);
    if (this.zJI.zJK.getCurrentItem() == parama.pos)
    {
      parama = PP(parama.pos);
      if (parama != null)
      {
        parama.dKP().zNB.setVisibility(8);
        parama.dKP().zNu.setVisibility(8);
        parama.dKP().zNs.setVisibility(8);
      }
      this.zNa = true;
      this.zJI.zJK.dKt();
      AppMethodBeat.o(32345);
      return true;
    }
    this.zJI.PX(parama.pos);
    AppMethodBeat.o(32345);
    return false;
  }
  
  public static s bH(bi parambi)
  {
    AppMethodBeat.i(32337);
    if (!c.f(parambi))
    {
      AppMethodBeat.o(32337);
      return null;
    }
    parambi = com.tencent.mm.modelvideo.u.vr(parambi.field_imgPath);
    AppMethodBeat.o(32337);
    return parambi;
  }
  
  private boolean byv()
  {
    AppMethodBeat.i(32372);
    if (!this.rJj)
    {
      AppMethodBeat.o(32372);
      return false;
    }
    aw.aaz();
    boolean bool = com.tencent.mm.model.c.Ru().getBoolean(ac.a.yFa, false);
    AppMethodBeat.o(32372);
    return bool;
  }
  
  private boolean c(k paramk)
  {
    AppMethodBeat.i(32369);
    int i = this.zMS;
    this.zMS = paramk.dKP().zNt.getCurrentPosition();
    int j;
    if (i != this.zMS)
    {
      this.lastCheckTime = bo.aoy();
      long l = paramk.dKP().zNt.getLastSurfaceUpdateTime();
      if ((l > 0L) && (l != this.vPB))
      {
        this.vPB = l;
        j = this.zMT;
        switch (j)
        {
        default: 
          this.zMT = 0;
        }
      }
    }
    do
    {
      for (;;)
      {
        AppMethodBeat.o(32369);
        return true;
        i = 21;
        for (;;)
        {
          ab.w("MicroMsg.Imagegallery.handler.video", "%d rpt rptRepairEffect idKey %d errorTime %d filename %s", new Object[] { Integer.valueOf(hashCode()), Integer.valueOf(i), Integer.valueOf(j), this.filename });
          h.qsU.idkeyStat(354L, i, 1L, false);
          h.qsU.e(13836, new Object[] { Integer.valueOf(301), Long.valueOf(bo.aox()), "" });
          break;
          i = 22;
          continue;
          i = 23;
        }
        if (this.zMT != -1)
        {
          this.zMT += 1;
          ab.w("MicroMsg.Imagegallery.handler.video", "media play is playing[%d], but surface is not update!! repair time[%d]", new Object[] { Integer.valueOf(this.zMT), Integer.valueOf(this.zMU) });
          if (this.zMU >= 2) {
            this.zMO.dKS();
          }
          switch (this.zMT)
          {
          case 0: 
          case 1: 
          default: 
            ab.w("MicroMsg.Imagegallery.handler.video", "rpt surface not update!!");
            ab.w("MicroMsg.Imagegallery.handler.video", "%d rpt rptSurfaceNotUpdate %s", new Object[] { Integer.valueOf(hashCode()), this.filename });
            h.qsU.e(13836, new Object[] { Integer.valueOf(300), Long.valueOf(bo.aox()), "" });
            h.qsU.idkeyStat(354L, 20L, 1L, false);
            this.zMT = -1;
          }
        }
      }
      i = this.zMS / 1000;
      ab.w("MicroMsg.Imagegallery.handler.video", "surface not update, it try seek time[%d] to repair.", new Object[] { Integer.valueOf(i) });
      ag(i, true);
      this.zMU += 1;
      AppMethodBeat.o(32369);
      return false;
      j = (this.zMS - 2000) / 1000;
      i = j;
      if (j < 0) {
        i = 0;
      }
      ab.w("MicroMsg.Imagegallery.handler.video", "surface not update, it try seek time[%d] to repair.", new Object[] { Integer.valueOf(i) });
      ag(i, true);
      this.zMU += 1;
      AppMethodBeat.o(32369);
      return false;
      j = (this.zMS - 4000) / 1000;
      i = j;
      if (j < 0) {
        i = 0;
      }
      ab.w("MicroMsg.Imagegallery.handler.video", "surface not update, it try seek time[%d] to repair.", new Object[] { Integer.valueOf(i) });
      ag(i, true);
      this.zMU += 1;
      AppMethodBeat.o(32369);
      return false;
      ab.i("MicroMsg.Imagegallery.handler.video", "check time[%d, %d], play time[%d, %d]", new Object[] { Long.valueOf(this.lastCheckTime), Long.valueOf(bo.aoy()), Integer.valueOf(i), Integer.valueOf(this.zMS) });
    } while ((this.lastCheckTime <= 0L) || (bo.hl(this.lastCheckTime) < 1500L));
    ab.w("MicroMsg.Imagegallery.handler.video", "play time not update! request all video data to play. ");
    i = this.zJI.dJY().zNt.getCurrentPosition();
    ctW();
    com.tencent.mm.modelvideo.u.f(this.filename, i, this.rJj);
    this.zJI.dJY().zNt.stop();
    this.zMO.dKS();
    paramk = (j.a)this.zLG.get(this.filename);
    if ((paramk == null) || (paramk.cmQ == null))
    {
      AppMethodBeat.o(32369);
      return false;
    }
    s locals = bH(paramk.cmQ);
    a(paramk.cmQ, locals, paramk.pos, this.rJj);
    this.lastCheckTime = 0L;
    AppMethodBeat.o(32369);
    return false;
  }
  
  private void ctW()
  {
    AppMethodBeat.i(32353);
    ab.i("MicroMsg.Imagegallery.handler.video", "clear timer");
    this.ryl.stopTimer();
    this.kvM.stopTimer();
    AppMethodBeat.o(32353);
  }
  
  private void ctZ()
  {
    AppMethodBeat.i(32365);
    this.rJw = bo.aoy();
    ab.d("MicroMsg.Imagegallery.handler.video", "notePlayVideo filename %s notePlayVideo %d ", new Object[] { this.filename, Long.valueOf(this.rJw) });
    AppMethodBeat.o(32365);
  }
  
  private void cua()
  {
    AppMethodBeat.i(32366);
    if (this.rJw > 0L) {
      this.rJx = ((int)(this.rJx + (bo.aoy() - this.rJw) / 1000L));
    }
    ab.i("MicroMsg.Imagegallery.handler.video", "notePauseVideo filename %s playVideoDuration %d ", new Object[] { this.filename, Integer.valueOf(this.rJx) });
    this.rJw = 0L;
    AppMethodBeat.o(32366);
  }
  
  private void dKJ()
  {
    AppMethodBeat.i(32358);
    try
    {
      this.zJI.zJK.dKi().zLW.setIplaySeekCallback(this.vPG);
      AppMethodBeat.o(32358);
      return;
    }
    catch (Exception localException)
    {
      AppMethodBeat.o(32358);
    }
  }
  
  private static void dKK()
  {
    AppMethodBeat.i(32370);
    h.qsU.idkeyStat(354L, 11L, 1L, false);
    AppMethodBeat.o(32370);
  }
  
  private static void dKL()
  {
    AppMethodBeat.i(32371);
    h.qsU.idkeyStat(354L, 14L, 1L, false);
    AppMethodBeat.o(32371);
  }
  
  private void eR(String paramString, int paramInt)
  {
    AppMethodBeat.i(32344);
    aw.RO().ac(new j.1(this, paramString, paramInt));
    AppMethodBeat.o(32344);
  }
  
  private void releaseWakeLock()
  {
    AppMethodBeat.i(153908);
    if ((this.tDZ != null) && (this.tDZ.isHeld()))
    {
      ab.i("MicroMsg.Imagegallery.handler.video", "release waklock");
      this.tDZ.release();
    }
    AppMethodBeat.o(153908);
  }
  
  public final void Dm()
  {
    AppMethodBeat.i(32346);
    ab.i("MicroMsg.Imagegallery.handler.video", "stopAll. video handler hash code : " + hashCode());
    this.rJo = bo.aoy();
    SparseArray localSparseArray = this.zJI.znN;
    int j = 0;
    int i = 0;
    if (j < localSparseArray.size())
    {
      int k = localSparseArray.keyAt(j);
      if ((localSparseArray.get(k) == null) || (((View)localSparseArray.get(k)).getTag() == null)) {
        break label420;
      }
      k localk = (k)((View)localSparseArray.get(k)).getTag();
      if ((localk.zNq == null) || (localk.dKP().zNq.getVisibility() != 0) || ((((View)localk.dKP().zNt).getVisibility() != 0) && (bo.isNullOrNil(localk.dKP().zNt.getVideoPath())) && ((!this.rJj) || (!this.zMO.isStreaming())))) {
        break label420;
      }
      ab.i("MicroMsg.Imagegallery.handler.video", "stop");
      ctW();
      if (localk != null)
      {
        cua();
        if (this.rJj) {
          this.zMO.dKR();
        }
        if (!this.zMQ) {
          com.tencent.mm.modelvideo.u.f(this.filename, this.zMS - 1000, this.rJj);
        }
        localk.dKP().zNu.setVisibility(8);
        localk.dKP().zNB.setVisibility(8);
        localk.dKP().zNt.stop();
        Qm(0);
        localk.a(false, 0.0F);
        this.rJj = false;
        this.zNa = false;
        this.zMV = false;
        this.filename = null;
        this.rJx = 0;
        this.rJw = 0L;
        this.zNb = 0;
        this.zMY = 0;
        this.zMU = 0;
        this.zMT = 0;
        this.vPB = 0L;
        this.lastCheckTime = 0L;
      }
      i = 1;
    }
    label420:
    for (;;)
    {
      j += 1;
      break;
      this.idF.cJ(false);
      if ((i == 0) && (this.rJj))
      {
        this.zMO.dKR();
        this.rJj = false;
      }
      ctW();
      this.zMN.clear();
      releaseWakeLock();
      AppMethodBeat.o(32346);
      return;
    }
  }
  
  public final void Ql(int paramInt)
  {
    AppMethodBeat.i(32356);
    this.zMN.remove(paramInt);
    AppMethodBeat.o(32356);
  }
  
  protected final void Qm(int paramInt)
  {
    AppMethodBeat.i(32363);
    paramInt = Math.max(0, paramInt);
    this.zJI.zJK.dKi().zLW.seek(paramInt);
    AppMethodBeat.o(32363);
  }
  
  public final void a(t.a.a parama)
  {
    AppMethodBeat.i(32357);
    Object localObject = parama.fileName;
    if ((bo.isNullOrNil((String)localObject)) || (this.zLG == null))
    {
      AppMethodBeat.o(32357);
      return;
    }
    parama = (j.a)this.zLG.get(localObject);
    if (parama == null)
    {
      AppMethodBeat.o(32357);
      return;
    }
    bi localbi = parama.cmQ;
    if ((localbi == null) || (localbi.field_imgPath == null) || (!localbi.field_imgPath.equals(localObject)))
    {
      AppMethodBeat.o(32357);
      return;
    }
    localObject = bH(localbi);
    if (localObject == null)
    {
      AppMethodBeat.o(32357);
      return;
    }
    if ((localbi.dyc()) || (((s)localObject).status == 198))
    {
      if (b(parama)) {
        Toast.makeText(this.zJI.zJK, 2131304516, 0).show();
      }
      AppMethodBeat.o(32357);
      return;
    }
    int i = com.tencent.mm.modelvideo.u.g((s)localObject);
    k localk = PP(parama.pos);
    if ((this.zJI.zJK.getCurrentItem() == parama.pos) && (localk != null))
    {
      this.zJI.zJK.dKu();
      this.zNa = false;
      localk.dKP().zNu.setVisibility(0);
      localk.dKP().zNu.setProgress(i);
    }
    while (i < localk.dKP().zNu.getMax())
    {
      AppMethodBeat.o(32357);
      return;
      if (localk == null)
      {
        AppMethodBeat.o(32357);
        return;
      }
    }
    ab.d("MicroMsg.Imagegallery.handler.video", "onNotifyChange, status:%d", new Object[] { Integer.valueOf(((s)localObject).status) });
    if (((((s)localObject).status == 199) || (((s)localObject).status == 199)) && (b(parama)))
    {
      this.zJI.zJK.hX(true);
      i = this.zJI.zJK.oM(localbi.field_msgId);
    }
    switch (i)
    {
    default: 
      ab.w("MicroMsg.Imagegallery.handler.video", "enterVideoOpCode[%d] is error", new Object[] { Integer.valueOf(i) });
      AppMethodBeat.o(32357);
      return;
    case 0: 
    case 3: 
      a(localbi, (s)localObject, this.zJI.zJK.getCurrentItem(), false);
      AppMethodBeat.o(32357);
      return;
    case 1: 
      ab.d("MicroMsg.Imagegallery.handler.video", "do restransmit video");
      h.qsU.idkeyStat(354L, 15L, 1L, false);
      this.zJI.bw(localbi);
      this.zJI.zJK.oN(-1L);
      if (this.rJj)
      {
        i = this.zJI.dJY().zNt.getCurrentPosition();
        com.tencent.mm.modelvideo.u.f(this.filename, i, this.rJj);
        this.zMV = true;
      }
      this.rJj = false;
      AppMethodBeat.o(32357);
      return;
    }
    h.qsU.idkeyStat(354L, 16L, 1L, false);
    c.a(this.zJI.zJK, localbi, true);
    this.zJI.zJK.oN(-1L);
    if (this.rJj)
    {
      i = this.zJI.dJY().zNt.getCurrentPosition();
      com.tencent.mm.modelvideo.u.f(this.filename, i, this.rJj);
      this.zMV = true;
    }
    this.rJj = false;
    AppMethodBeat.o(32357);
  }
  
  public final boolean a(k paramk, bi parambi, int paramInt)
  {
    AppMethodBeat.i(32336);
    super.a(paramk, parambi, paramInt);
    s locals = bH(parambi);
    if (parambi == null)
    {
      ab.e("MicroMsg.Imagegallery.handler.video", "msg is null!!");
      AppMethodBeat.o(32336);
      return false;
    }
    if (this.zLG != null) {
      this.zLG.put(parambi.field_imgPath, new j.a(parambi, paramInt));
    }
    while (locals == null)
    {
      AppMethodBeat.o(32336);
      return false;
      ab.e("MicroMsg.Imagegallery.handler.video", "mCacheMap is null!");
    }
    o.alE();
    parambi = BackwardSupportUtil.b.k(com.tencent.mm.modelvideo.t.vg(parambi.field_imgPath), 1.0F);
    paramk.dKP().zNr.setImageBitmap(parambi);
    if (paramk.dKP().zNt.isPlaying()) {
      paramk.dKP().zNt.stop();
    }
    paramk.zNv.setVisibility(8);
    paramk.dKP().zNu.setVisibility(8);
    paramk.dKP().zNB.setVisibility(8);
    paramk.a(false, 0.0F);
    this.zMT = 0;
    this.rJn = bo.aoy();
    AppMethodBeat.o(32336);
    return true;
  }
  
  protected final void ag(int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(32360);
    k localk = this.zJI.dJY();
    if (localk == null)
    {
      AppMethodBeat.o(32360);
      return;
    }
    ctZ();
    localk.dKP().zNB.setVisibility(8);
    localk.dKP().zNt.e(paramInt * 1000, paramBoolean);
    this.zJI.zJK.rb(false);
    dh(false);
    AppMethodBeat.o(32360);
  }
  
  protected final void alq()
  {
    AppMethodBeat.i(32361);
    k localk = this.zJI.dJY();
    if (localk == null)
    {
      AppMethodBeat.o(32361);
      return;
    }
    ab.i("MicroMsg.Imagegallery.handler.video", "start to pause");
    this.zJI.zJK.rb(true);
    localk.dKP().zNB.setVisibility(0);
    localk.dKP().zNt.pause();
    cua();
    AppMethodBeat.o(32361);
  }
  
  protected final void aui(String paramString)
  {
    AppMethodBeat.i(32364);
    if ((!this.zNa) && (!b((j.a)this.zLG.get(paramString)))) {
      ab.w("MicroMsg.Imagegallery.handler.video", "show tool bar error.");
    }
    AppMethodBeat.o(32364);
  }
  
  protected final void bw(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(32359);
    al.d(new j.4(this, paramString, paramBoolean));
    AppMethodBeat.o(32359);
  }
  
  protected final boolean ctX()
  {
    AppMethodBeat.i(32362);
    k localk = this.zJI.dJY();
    if (localk == null)
    {
      AppMethodBeat.o(32362);
      return false;
    }
    boolean bool = true;
    if (!localk.dKP().zNt.isPlaying())
    {
      ab.i("MicroMsg.Imagegallery.handler.video", "start to play");
      this.zJI.zJK.rb(false);
      localk.dKP().zNB.setVisibility(8);
      bool = localk.dKP().zNt.start();
      ctZ();
    }
    if (localk.dKP().zNB.getVisibility() != 8) {
      localk.dKP().zNB.setVisibility(8);
    }
    AppMethodBeat.o(32362);
    return bool;
  }
  
  public final void dKH()
  {
    AppMethodBeat.i(32350);
    this.zMQ = false;
    this.mEx = 0;
    if (this.zJI != null) {}
    for (Object localObject = this.zJI.dJY(); localObject == null; localObject = null)
    {
      ab.w("MicroMsg.Imagegallery.handler.video", "notify video prepared, but holder is null.");
      AppMethodBeat.o(32350);
      return;
    }
    int i = bo.nX(((k)localObject).dKP().zNt.getDuration());
    int j = this.zJI.zJK.dKi().zLW.getVideoTotalTime();
    ab.i("MicroMsg.Imagegallery.handler.video", "%d videoDuration %d hadSetTotalTime %d", new Object[] { Integer.valueOf(hashCode()), Integer.valueOf(i), Integer.valueOf(j) });
    if ((j <= 0) || (Math.abs(j - i) >= 2)) {
      this.zJI.zJK.dKi().zLW.setVideoTotalTime(i);
    }
    dKJ();
    if ((i == 0) || (i >= 1800))
    {
      ab.w("MicroMsg.Imagegallery.handler.video", "%d repair video duration[%d] error. filename[%s]", new Object[] { Integer.valueOf(hashCode()), Integer.valueOf(i), this.filename });
      i = com.tencent.mm.modelvideo.u.D(i, this.filename);
      ab.i("MicroMsg.Imagegallery.handler.video", "notify video prepared. isOnlinePlay[%b] playDuration[%d] playVideoWhenNotify[%b] hadPlayError[%b].", new Object[] { Boolean.valueOf(this.rJj), Integer.valueOf(i), Boolean.valueOf(this.zMP), Boolean.valueOf(this.zMQ) });
      ((k)localObject).dKP().zNt.setOneTimeVideoTextureUpdateCallback(this.rIZ);
      if (!this.zMP) {
        break label399;
      }
      if (this.rJj) {
        break label347;
      }
      this.zMO.reset();
      ctZ();
      ag(i, true);
    }
    for (;;)
    {
      dh(false);
      AppMethodBeat.o(32350);
      return;
      aw.RO().ac(new j.5(this, i));
      break;
      label347:
      localObject = this.zMO;
      if (i > 0)
      {
        ab.i("MicroMsg.OnlineVideoUIHelper", "seek to last duration : ".concat(String.valueOf(i)));
        ((m)localObject).fVm = i;
        ((m)localObject).fVo = true;
        ((m)localObject).fVj = 2;
      }
      this.zMO.mj(0);
    }
    label399:
    if (!this.rJj) {
      ag(i, false);
    }
    for (;;)
    {
      Qm(i);
      this.zJI.zJK.rb(true);
      ctW();
      AppMethodBeat.o(32350);
      return;
      this.zMO.aJ(i, false);
    }
  }
  
  public final void dKI()
  {
    AppMethodBeat.i(32351);
    ab.i("MicroMsg.Imagegallery.handler.video", "notify video completion. isOnlinePlay : " + this.rJj);
    ctW();
    releaseWakeLock();
    cua();
    Object localObject1;
    if ((this.rJj) && (this.zJI != null) && (this.zJI.dJY() != null))
    {
      localObject1 = this.zJI.dJY().dKP().zNt;
      if ((localObject1 != null) && (((com.tencent.mm.pluginsdk.ui.tools.e)localObject1).getCurrentPosition() + 2000 < ((com.tencent.mm.pluginsdk.ui.tools.e)localObject1).getDuration())) {
        ab.e("MicroMsg.Imagegallery.handler.video", "notify video completion, but cur pos[%d] is less than duration[%d]", new Object[] { Integer.valueOf(((com.tencent.mm.pluginsdk.ui.tools.e)localObject1).getCurrentPosition()), Integer.valueOf(((com.tencent.mm.pluginsdk.ui.tools.e)localObject1).getDuration()) });
      }
    }
    for (int i = 0;; i = 1)
    {
      if (i != 0)
      {
        al.d(new j.10(this));
        AppMethodBeat.o(32351);
        return;
      }
      try
      {
        i = this.zJI.dJY().zNt.getCurrentPosition();
        com.tencent.mm.modelvideo.u.f(this.filename, i, this.rJj);
        this.zJI.dJY().zNt.stop();
        this.zMO.dKS();
        i = this.zMY + 1;
        this.zMY = i;
        if (i <= 3)
        {
          localObject1 = (j.a)this.zLG.get(this.filename);
          if (localObject1 != null)
          {
            localObject2 = ((j.a)localObject1).cmQ;
            if (localObject2 != null) {}
          }
          else
          {
            AppMethodBeat.o(32351);
            return;
          }
          Object localObject2 = bH(((j.a)localObject1).cmQ);
          a(((j.a)localObject1).cmQ, (s)localObject2, ((j.a)localObject1).pos, this.rJj);
        }
        AppMethodBeat.o(32351);
        return;
      }
      catch (Exception localException)
      {
        ab.printErrStackTrace("MicroMsg.Imagegallery.handler.video", localException, "notify video completion error[%s]", new Object[] { localException.toString() });
        AppMethodBeat.o(32351);
        return;
      }
    }
  }
  
  public final void detach()
  {
    AppMethodBeat.i(32349);
    ab.i("MicroMsg.Imagegallery.handler.video", "detach.[%d]", new Object[] { Integer.valueOf(hashCode()) });
    this.rJo = bo.aoy();
    this.zMX.removeMessages(1);
    ctW();
    com.tencent.mm.sdk.b.a.ymk.d(this.zMM);
    com.tencent.mm.sdk.b.a.ymk.d(this.zMZ);
    Dm();
    this.zJI.zJK.getContext().getWindow().clearFlags(128);
    this.zJI.zJK.dKi().zLW.setIplaySeekCallback(null);
    super.detach();
    this.zLG.clear();
    this.zLG = null;
    o.alE().a(this);
    this.zMN.clear();
    m localm = this.zMO;
    localm.reset();
    localm.fVk = null;
    localm.zOb = null;
    localm.zOc = null;
    if (com.tencent.mm.plugin.n.e.bQr()) {
      aw.RO().ac(new j.8(this));
    }
    o.alJ().alZ();
    o.alJ().run();
    AppMethodBeat.o(32349);
  }
  
  protected final void dh(boolean paramBoolean)
  {
    AppMethodBeat.i(32354);
    if (!this.zMQ)
    {
      if (this.rJj)
      {
        if (paramBoolean)
        {
          al.d(new j.12(this));
          AppMethodBeat.o(32354);
          return;
        }
        this.ryl.ag(500L, 500L);
        AppMethodBeat.o(32354);
        return;
      }
      this.kvM.ag(500L, 500L);
    }
    AppMethodBeat.o(32354);
  }
  
  protected final int getPlayVideoDuration()
  {
    AppMethodBeat.i(32367);
    if (this.rJx < 0) {
      this.rJx = 0;
    }
    ab.i("MicroMsg.Imagegallery.handler.video", "get[%s] play video duration [%d]", new Object[] { this.filename, Integer.valueOf(this.rJx) });
    int i = this.rJx;
    AppMethodBeat.o(32367);
    return i;
  }
  
  protected final int getUiStayTime()
  {
    AppMethodBeat.i(32368);
    if ((this.rJo > 0L) && (this.rJn > 0L)) {}
    for (int i = (int)(this.rJo - this.rJn);; i = 0)
    {
      int j = i;
      if (i < 0) {
        j = 0;
      }
      ab.i("MicroMsg.Imagegallery.handler.video", "%d filename[%s] get ui stay time[%d %d %d]", new Object[] { Integer.valueOf(hashCode()), this.filename, Integer.valueOf(j), Long.valueOf(this.rJo), Long.valueOf(this.rJn) });
      AppMethodBeat.o(32368);
      return j;
    }
  }
  
  public final void hG(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(32352);
    boolean bool2 = this.rJj;
    Object localObject = this.zMO;
    boolean bool1;
    if ((!bo.isNullOrNil(((m)localObject).cBO)) && (((m)localObject).fVi == 1))
    {
      bool1 = true;
      ab.e("MicroMsg.Imagegallery.handler.video", "notify video error, what %d, extras %d isOnlinePlay %b isLoading %b ", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Boolean.valueOf(bool2), Boolean.valueOf(bool1) });
      this.zMQ = true;
      this.mEx = paramInt2;
      if (!this.rJj) {
        break label281;
      }
      if (paramInt1 != -1) {
        break label193;
      }
      ctW();
      this.zJI.dJY().zNt.stop();
      this.zMO.dKS();
    }
    label193:
    do
    {
      for (;;)
      {
        this.zNa = false;
        this.zJI.zJK.rb(true);
        this.zJI.dJY().dKP().zNB.setVisibility(0);
        cua();
        h.qsU.idkeyStat(354L, 18L, 1L, false);
        AppMethodBeat.o(32352);
        return;
        bool1 = false;
        break;
        if (paramInt1 != -2) {
          break label256;
        }
        ctW();
        paramInt1 = this.zJI.dJY().zNt.getCurrentPosition();
        com.tencent.mm.modelvideo.u.f(this.filename, paramInt1, this.rJj);
        this.zJI.dJY().zNt.stop();
        this.zMO.dKS();
      }
    } while (paramInt1 != -3);
    label256:
    this.zMQ = false;
    this.zMO.dKS();
    AppMethodBeat.o(32352);
    return;
    label281:
    com.tencent.mm.modelvideo.u.vu(this.filename);
    cua();
    if ((this.zJI != null) && (this.zJI.dJY() != null) && (this.zJI.dJY().zNt != null))
    {
      localObject = this.zJI.dJY().zNt.getVideoPath();
      this.zJI.dJY().zNt.stop();
    }
    while (this.zMR)
    {
      ab.i("MicroMsg.Imagegallery.handler.video", "%d had play completion don't show error tips", new Object[] { Integer.valueOf(hashCode()) });
      AppMethodBeat.o(32352);
      return;
      localObject = "";
    }
    al.d(new j.11(this, (String)localObject));
    h.qsU.idkeyStat(354L, 25L, 1L, false);
    AppMethodBeat.o(32352);
  }
  
  public final void i(bi parambi, int paramInt)
  {
    AppMethodBeat.i(32339);
    ab.i("MicroMsg.Imagegallery.handler.video", "toggle video");
    if (parambi == null)
    {
      AppMethodBeat.o(32339);
      return;
    }
    if ((!c.f(parambi)) && (!c.bq(parambi)))
    {
      AppMethodBeat.o(32339);
      return;
    }
    s locals = bH(parambi);
    if (locals == null)
    {
      AppMethodBeat.o(32339);
      return;
    }
    if ((this.rJj) && (this.zMO != null) && (this.zMO.fVo))
    {
      ab.i("MicroMsg.Imagegallery.handler.video", "%d it loading video data, do not response button click.", new Object[] { Integer.valueOf(hashCode()) });
      AppMethodBeat.o(32339);
      return;
    }
    if (this.zJI.zJK.cKj())
    {
      b(PP(paramInt));
      this.zJI.zJK.rb(true);
      this.zJI.zJK.zMx.stopTimer();
      this.idF.cJ(false);
      releaseWakeLock();
      ab.i("MicroMsg.Imagegallery.handler.video", "toggle pause video.");
      AppMethodBeat.o(32339);
      return;
    }
    aw.aaz();
    if (!com.tencent.mm.model.c.isSDCardAvailable())
    {
      com.tencent.mm.ui.base.t.ii(this.zJI.zJK.getContext());
      AppMethodBeat.o(32339);
      return;
    }
    if (this.rJj) {}
    for (;;)
    {
      int i;
      try
      {
        if (this.zJI.dJY().zNt != null)
        {
          i = this.zJI.dJY().zNt.getCurrentPosition() / 1000;
          if (this.zMO == null) {
            continue;
          }
          if (!this.zMO.mk(i)) {
            continue;
          }
          ab.i("MicroMsg.Imagegallery.handler.video", "toggle play video");
          a(parambi, locals, paramInt, this.rJj);
          if (this.zJI.zJK.zMw) {
            this.zJI.zJK.dKs();
          }
          dKJ();
          this.tDZ = ((PowerManager)ah.getContext().getSystemService("power")).newWakeLock(536870922, "MicroMsg.Imagegallery.handler.video");
          this.tDZ.acquire();
          ab.i("MicroMsg.Imagegallery.handler.video", "acquire wakelock");
          AppMethodBeat.o(32339);
        }
      }
      catch (Exception localException)
      {
        ab.printErrStackTrace("MicroMsg.Imagegallery.handler.video", localException, "", new Object[0]);
        i = 0;
        continue;
        ab.i("MicroMsg.Imagegallery.handler.video", "toggle start timer.");
        dh(false);
        continue;
        ab.w("MicroMsg.Imagegallery.handler.video", "%d toggle video but online video helper is null.", new Object[] { Integer.valueOf(hashCode()) });
        continue;
      }
      if (parambi.field_isSend == 0)
      {
        if ((locals.status != 113) && (locals.status != 198)) {
          break label559;
        }
        a(parambi, locals);
      }
      for (;;)
      {
        if (parambi.field_isSend != 1) {
          break label660;
        }
        i = locals.status;
        if ((i != 111) && (i != 113) && (i != 112) && (i != 121) && (i != 122)) {
          break label662;
        }
        ab.i("MicroMsg.Imagegallery.handler.video", "download video. msg talker[%s], info status[%d]", new Object[] { parambi.field_talker, Integer.valueOf(i) });
        a(parambi, locals);
        break;
        label559:
        if (locals.status == 199) {
          a(parambi, locals, paramInt, false);
        }
        if (locals.status == 111) {
          a(parambi, locals);
        }
        if (locals.status == 112) {
          a(parambi, locals);
        }
        if ((locals.status == 121) || (locals.status == 122)) {
          a(parambi, locals);
        }
        if (locals.status == 123) {
          a(parambi, locals, paramInt, false);
        }
      }
      label660:
      continue;
      label662:
      a(parambi, locals, paramInt, false);
    }
  }
  
  public final void j(bi parambi, int paramInt)
  {
    AppMethodBeat.i(32340);
    ab.i("MicroMsg.Imagegallery.handler.video", "toggleVideoMenu pos ");
    s locals = com.tencent.mm.modelvideo.u.vr(parambi.field_imgPath);
    if ((locals != null) && (!locals.alS()))
    {
      b(PP(paramInt));
      this.zJI.zJK.rb(true);
      if (this.rJj)
      {
        this.zMO.dKR();
        this.zMO.reset();
      }
      a(parambi, locals);
      if (this.zJI.zJK.oM(parambi.field_msgId) == 2)
      {
        eR(parambi.field_imgPath, 8);
        AppMethodBeat.o(32340);
        return;
      }
      eR(parambi.field_imgPath, 5);
    }
    AppMethodBeat.o(32340);
  }
  
  protected final void onResume()
  {
    AppMethodBeat.i(32348);
    ab.i("MicroMsg.Imagegallery.handler.video", "ui on resume, add online video event.");
    this.zMX.removeMessages(1);
    com.tencent.mm.sdk.b.a.ymk.c(this.zMZ);
    if ((this.zJI != null) && (com.tencent.mm.compatible.util.d.fv(21)))
    {
      k localk = this.zJI.dJY();
      if ((localk != null) && (localk.zNt != null))
      {
        if ((localk.zNt instanceof VideoPlayerTextureView))
        {
          ((VideoPlayerTextureView)localk.zNt).bQB();
          AppMethodBeat.o(32348);
          return;
        }
        if ((localk.zNt instanceof VideoTextureView)) {
          ((VideoTextureView)localk.zNt).bQB();
        }
      }
    }
    AppMethodBeat.o(32348);
  }
  
  public final void pause(int paramInt)
  {
    AppMethodBeat.i(32338);
    b(PP(paramInt));
    this.idF.cJ(false);
    this.zJI.zJK.rb(true);
    AppMethodBeat.o(32338);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.gallery.j
 * JD-Core Version:    0.7.0.1
 */