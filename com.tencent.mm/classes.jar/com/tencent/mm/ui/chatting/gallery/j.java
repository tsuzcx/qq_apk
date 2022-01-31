package com.tencent.mm.ui.chatting.gallery;

import android.content.DialogInterface.OnClickListener;
import android.os.Looper;
import android.support.v7.app.AppCompatActivity;
import android.util.SparseArray;
import android.view.View;
import android.view.Window;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.mm.R.l;
import com.tencent.mm.compatible.e.q;
import com.tencent.mm.h.a.lf;
import com.tencent.mm.h.c.cs;
import com.tencent.mm.model.au;
import com.tencent.mm.model.bd;
import com.tencent.mm.model.bd.b;
import com.tencent.mm.model.d.a;
import com.tencent.mm.modelvideo.n;
import com.tencent.mm.modelvideo.o;
import com.tencent.mm.modelvideo.r;
import com.tencent.mm.modelvideo.t.a;
import com.tencent.mm.modelvideo.t.a.a;
import com.tencent.mm.modelvideo.u;
import com.tencent.mm.modelvideo.y.a;
import com.tencent.mm.network.ab;
import com.tencent.mm.pluginsdk.ui.tools.VideoPlayerSeekBar;
import com.tencent.mm.pluginsdk.ui.tools.VideoPlayerTextureView;
import com.tencent.mm.pluginsdk.ui.tools.VideoTextureView;
import com.tencent.mm.pluginsdk.ui.tools.f;
import com.tencent.mm.pluginsdk.ui.tools.f.e;
import com.tencent.mm.protocal.c.avn;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.b;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.am;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.bn;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.ac.a;
import com.tencent.mm.storage.bi;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.chatting.an;
import com.tencent.mm.ui.chatting.an.a;
import com.tencent.mm.ui.widget.MMPinProgressBtn;
import java.util.HashMap;
import java.util.Map;

public final class j
  extends a
  implements d.a, t.a
{
  public static boolean vwL = false;
  String filename;
  private com.tencent.mm.model.d gEB;
  private am iuI = new am(new j.16(this), true);
  int kjS = 0;
  private long lastCheckTime = 0L;
  private com.tencent.mm.plugin.s.b mes = new j.8(this);
  long oRC = 0L;
  long oRD = 0L;
  private am oRE = new am(new j.15(this), true);
  private long oRI;
  int oRJ;
  private f.e oRn = new j.7(this);
  private boolean oRy;
  private long rYM = 0L;
  private com.tencent.mm.plugin.sight.decode.ui.b rYR = new j.3(this);
  private HashMap<String, j.a> vvE = new HashMap();
  private com.tencent.mm.sdk.b.c vwB;
  final SparseArray<com.tencent.mm.modelvideo.s> vwC = new SparseArray();
  private m vwD = new m(this);
  private boolean vwE = false;
  private boolean vwF = false;
  private boolean vwG = false;
  private int vwH = 0;
  private int vwI = 0;
  private int vwJ = 0;
  private boolean vwK = false;
  ah vwM = new ah(Looper.getMainLooper(), new j.11(this));
  private int vwN = 0;
  private com.tencent.mm.sdk.b.c<lf> vwO = new j.4(this);
  private boolean vwP = false;
  private int vwQ = 0;
  private int[] vwR = { -1000, -2000, 3400 };
  
  public j(c paramc)
  {
    super(paramc);
    com.tencent.mm.sdk.b.a locala = com.tencent.mm.sdk.b.a.udP;
    paramc = new an(an.a.vmN, paramc.vtJ);
    this.vwB = paramc;
    locala.c(paramc);
    com.tencent.mm.sdk.b.a.udP.c(this.vwO);
    this.gEB = new com.tencent.mm.model.d();
  }
  
  private void a(bi parambi, com.tencent.mm.modelvideo.s params)
  {
    if ((!ab.bG(this.vtH.vtJ.mController.uMN)) && (!vwL))
    {
      com.tencent.mm.ui.base.h.a(this.vtH.vtJ.mController.uMN, R.l.video_export_file_warning, R.l.app_tip, new j.1(this, parambi, params), null);
      return;
    }
    b(parambi, params);
  }
  
  private void a(bi parambi, com.tencent.mm.modelvideo.s params, int paramInt, boolean paramBoolean)
  {
    if ((parambi == null) || (params == null)) {
      return;
    }
    if (parambi.cvx())
    {
      Toast.makeText(this.vtH.vtJ, R.l.video_fail_or_clean, 0).show();
      return;
    }
    Object localObject3;
    Object localObject1;
    if (params.eHO == -1)
    {
      localObject3 = params.SC();
      localObject1 = localObject3;
      if (!com.tencent.mm.vfs.e.bK((String)localObject3))
      {
        o.Sr();
        localObject1 = com.tencent.mm.modelvideo.t.nS(parambi.field_imgPath);
        label73:
        if ((localObject1 != null) && (com.tencent.mm.vfs.e.bK((String)localObject1))) {
          break label305;
        }
        Toast.makeText(this.vtH.vtJ, R.l.video_fail_or_clean, 0).show();
      }
    }
    else
    {
      o.Sr();
      localObject3 = com.tencent.mm.modelvideo.t.nS(parambi.field_imgPath);
      localObject1 = localObject3;
      if (parambi.field_isSend == 1)
      {
        localObject1 = localObject3;
        if (params.eHR != null)
        {
          localObject1 = localObject3;
          if (!params.eHR.tra) {}
        }
      }
    }
    for (;;)
    {
      String str;
      boolean bool;
      try
      {
        str = com.tencent.mm.vfs.e.aeS((String)localObject3);
        localObject1 = str;
        if (!str.endsWith("/")) {
          localObject1 = str + "/";
        }
        str = com.tencent.mm.vfs.e.aeV((String)localObject3);
        localObject1 = (String)localObject1 + str + "_hd.mp4";
        bool = com.tencent.mm.vfs.e.bK((String)localObject1);
        y.i("MicroMsg.Imagegallery.handler.video", "local capture video, hdFilePath: %s, exist: %s", new Object[] { localObject1, Boolean.valueOf(bool) });
        if (!bool) {
          break label1129;
        }
      }
      catch (Exception localException)
      {
        y.e("MicroMsg.Imagegallery.handler.video", "try to get hd filePath error: %s", new Object[] { localException.getMessage() });
        localObject2 = localObject3;
      }
      break label73;
      label305:
      localObject3 = Hi(paramInt);
      if (localObject3 == null) {
        break;
      }
      if (com.tencent.mm.model.s.fn(params.SA())) {}
      for (int i = com.tencent.mm.model.m.gM(params.SA());; i = 0)
      {
        bool = r.nL(localObject2);
        int j = this.vtH.vtJ.ia(parambi.field_msgId);
        y.i("MicroMsg.Imagegallery.handler.video", "play video pos[%d], isOnlinePlay[%b] opcode[%d] resetByCompletion[%b]", new Object[] { Integer.valueOf(paramInt), Boolean.valueOf(paramBoolean), Integer.valueOf(j), Boolean.valueOf(this.vwK) });
        if (!bool)
        {
          if ((q.dyn.dxj == 1) && (com.tencent.mm.pluginsdk.h.b.a.a.b(params.getFileName(), this.vtH.vtJ.mController.uMN, bool))) {
            break;
          }
          au.Hx();
          if ((((Integer)com.tencent.mm.model.c.Dz().get(ac.a.utO, Integer.valueOf(0))).intValue() == 1) && (((k)localObject3).vxl != null))
          {
            ((k)localObject3).vxl.setVisibility(0);
            ((k)localObject3).vxl.setText(com.tencent.mm.plugin.sight.base.d.Ik(localObject2));
          }
          int k = params.eHH;
          int m = params.ebK;
          parambi = params.SA();
          str = com.tencent.mm.modelvideo.s.nP(params.SD());
          long l = params.createTime;
          ((k)localObject3).oHM = k;
          ((k)localObject3).vxx = m;
          ((k)localObject3).vxy = i;
          ((k)localObject3).bRO = parambi;
          ((k)localObject3).fileId = str;
          ((k)localObject3).createTime = l;
          this.oRy = paramBoolean;
          this.vwE = true;
          this.filename = params.getFileName();
          if (j == 3)
          {
            ((k)localObject3).cGH().vxj.setMute(true);
            if ((((k)localObject3).cGH().vxj.getVideoPath() == null) || (!((k)localObject3).cGH().vxj.getVideoPath().equals(localObject2)) || (((k)localObject3).cGH().vxj.isPlaying()) || (this.vwK)) {
              break label836;
            }
            ((k)localObject3).a(true, 1.0F);
            ((k)localObject3).cGH().vxj.start();
            bHQ();
            if (!paramBoolean) {
              adF(this.filename);
            }
            HF(((k)localObject3).cGH().vxj.getCurrentPosition() / 1000);
            ce(false);
            this.vwC.put(paramInt, params);
            this.vtH.vtJ.ns(false);
            this.vtH.vtJ.mController.uMN.getWindow().addFlags(128);
            if (com.tencent.mm.compatible.util.d.gG(18)) {
              adF(this.filename);
            }
            this.gEB.a(this);
          }
        }
        for (;;)
        {
          ((k)localObject3).cGH().vxk.setVisibility(8);
          return;
          ((k)localObject3).cGH().vxj.setMute(false);
          break;
          label836:
          this.vwG = false;
          this.vwK = false;
          ((k)localObject3).cGH().vxj.setVideoPath(localObject2);
          if ((((k)localObject3).cGH().vxj instanceof VideoPlayerTextureView))
          {
            ((VideoPlayerTextureView)((k)localObject3).cGH().vxj).setIOnlineCache(this.mes);
            parambi = (VideoPlayerTextureView)((k)localObject3).cGH().vxj;
            if (this.oRy) {
              break label956;
            }
          }
          for (bool = false;; bool = com.tencent.mm.model.c.Dz().getBoolean(ac.a.uuT, false))
          {
            parambi.setNeedResetExtractor(bool);
            ((VideoPlayerTextureView)((k)localObject3).cGH().vxj).setIsOnlineVideoType(paramBoolean);
            ((k)localObject3).a(true, 0.0F);
            break;
            label956:
            au.Hx();
          }
          com.tencent.mm.plugin.report.service.h.nFQ.f(12084, new Object[] { Integer.valueOf(params.ebK), Integer.valueOf(params.eHH * 1000), Integer.valueOf(0), Integer.valueOf(3), params.SA(), Integer.valueOf(i), com.tencent.mm.modelvideo.s.nP(params.SD()), Long.valueOf(params.createTime) });
          if (!com.tencent.mm.pluginsdk.h.b.a.a.c(localObject2, this.vtH.vtJ.mController.uMN, bool)) {
            Toast.makeText(this.vtH.vtJ.mController.uMN, this.vtH.vtJ.getString(R.l.video_play_export_file_error), 0).show();
          }
        }
      }
      label1129:
      Object localObject2 = localObject3;
    }
  }
  
  private void b(bi parambi, com.tencent.mm.modelvideo.s params)
  {
    y.i("MicroMsg.Imagegallery.handler.video", "startDownloading [%d]", new Object[] { Integer.valueOf(hashCode()) });
    if ((parambi == null) || (params == null)) {}
    k localk;
    do
    {
      return;
      localk = this.vtH.cFV();
    } while (localk == null);
    com.tencent.mm.modelsimple.z.w(parambi);
    int i = this.vtH.vtJ.ia(parambi.field_msgId);
    y.d("MicroMsg.Imagegallery.handler.video", "enterVideoOpCode : " + i);
    switch (i)
    {
    default: 
      y.w("MicroMsg.Imagegallery.handler.video", "enterVideoOpCode[%d] is error", new Object[] { Integer.valueOf(i) });
      return;
    case 3: 
      y.i("MicroMsg.Imagegallery.handler.video", "%d mute play video [%d]", new Object[] { Integer.valueOf(hashCode()), Integer.valueOf(i) });
    case 0: 
      m localm = this.vwD;
      String str1 = parambi.field_imgPath;
      com.tencent.mm.modelcontrol.d.Nl();
      if (!com.tencent.mm.modelcontrol.d.Nq()) {
        i = 0;
      }
      while (i != 0)
      {
        y.i("MicroMsg.Imagegallery.handler.video", "start online play video.");
        this.oRy = true;
        o.Sr().a(this);
        this.vtH.vtJ.cGp();
        this.vwP = false;
        localk.cGH().vxi.setVisibility(8);
        localk.cGH().vxk.setVisibility(8);
        localk.cGH().vxr.setVisibility(0);
        return;
        localm.reset();
        Object localObject1 = u.oe(str1);
        if (localObject1 != null)
        {
          i = ((com.tencent.mm.modelvideo.s)localObject1).ebK;
          if (i < localm.vxQ.vxS)
          {
            y.i("MicroMsg.OnlineVideoUIHelper", "video size[%d] less than config size[%d], do not stream video", new Object[] { Integer.valueOf(i), Integer.valueOf(localm.vxQ.vxS) });
            u.b((com.tencent.mm.modelvideo.s)localObject1, 9);
            com.tencent.mm.plugin.report.service.h.nFQ.a(354L, 17L, 1L, false);
            i = 0;
            continue;
          }
        }
        u.Y(str1, 1);
        n.Sp();
        o.Ss();
        if (bk.bl(str1)) {
          localObject1 = null;
        }
        for (;;)
        {
          if (localObject1 == null)
          {
            i = 0;
            break;
            com.tencent.mm.modelvideo.s locals = u.oe(str1);
            if (locals == null)
            {
              localObject1 = null;
            }
            else
            {
              localObject1 = bn.s(locals.SD(), "msg");
              if (localObject1 == null)
              {
                y.w("MicroMsg.OnlineVideoService", "cdntra parse video recv xml failed");
                localObject1 = null;
              }
              else
              {
                Object localObject2 = (String)((Map)localObject1).get(".msg.videomsg.$cdnvideourl");
                if (bk.bl((String)localObject2))
                {
                  y.w("MicroMsg.OnlineVideoService", "cdntra parse video recv xml failed");
                  localObject1 = null;
                }
                else
                {
                  int j = Integer.valueOf((String)((Map)localObject1).get(".msg.videomsg.$length")).intValue();
                  Object localObject3 = (String)((Map)localObject1).get(".msg.videomsg.$md5");
                  String str2 = (String)((Map)localObject1).get(".msg.videomsg.$aeskey");
                  String str3 = (String)((Map)localObject1).get(".msg.videomsg.$fileparam");
                  String str4 = com.tencent.mm.ak.c.a("downvideo", locals.createTime, locals.SA(), locals.getFileName());
                  if (bk.bl(str4))
                  {
                    y.w("MicroMsg.OnlineVideoService", "cdntra genClientId failed not use cdn file:%s", new Object[] { locals.getFileName() });
                    localObject1 = null;
                  }
                  else
                  {
                    o.Sr();
                    String str5 = com.tencent.mm.modelvideo.t.nS(str1);
                    localObject1 = new com.tencent.mm.j.g();
                    ((com.tencent.mm.j.g)localObject1).filename = str1;
                    ((com.tencent.mm.j.g)localObject1).dme = ((String)localObject3);
                    ((com.tencent.mm.j.g)localObject1).dmf = j;
                    ((com.tencent.mm.j.g)localObject1).dmg = 1;
                    ((com.tencent.mm.j.g)localObject1).bRO = locals.SB();
                    ((com.tencent.mm.j.g)localObject1).dmh = locals.SA();
                    if (com.tencent.mm.model.s.fn(locals.SA()))
                    {
                      i = com.tencent.mm.model.m.gM(locals.SA());
                      label706:
                      ((com.tencent.mm.j.g)localObject1).bRQ = i;
                      ((com.tencent.mm.j.g)localObject1).field_mediaId = str4;
                      ((com.tencent.mm.j.g)localObject1).field_fullpath = str5;
                      ((com.tencent.mm.j.g)localObject1).field_fileType = com.tencent.mm.j.a.MediaType_VIDEO;
                      ((com.tencent.mm.j.g)localObject1).field_totalLen = j;
                      ((com.tencent.mm.j.g)localObject1).field_aesKey = str2;
                      ((com.tencent.mm.j.g)localObject1).field_fileId = ((String)localObject2);
                      ((com.tencent.mm.j.g)localObject1).field_priority = com.tencent.mm.j.a.dlk;
                      ((com.tencent.mm.j.g)localObject1).field_wxmsgparam = str3;
                      if (!com.tencent.mm.model.s.fn(locals.SA())) {
                        break label947;
                      }
                      i = 1;
                      label783:
                      ((com.tencent.mm.j.g)localObject1).field_chattype = i;
                      ((com.tencent.mm.j.g)localObject1).dmi = locals.dmi;
                      localObject2 = ((com.tencent.mm.plugin.messenger.foundation.a.j)com.tencent.mm.kernel.g.r(com.tencent.mm.plugin.messenger.foundation.a.j.class)).bhO().O(locals.SA(), locals.bXr);
                      localObject3 = bd.iM(((cs)localObject2).czr);
                      if (localObject3 == null) {
                        break label952;
                      }
                      i = ((bd.b)localObject3).dWL;
                      label851:
                      ((com.tencent.mm.j.g)localObject1).initialDownloadLength = i;
                      ((com.tencent.mm.j.g)localObject1).initialDownloadOffset = 0;
                      ((com.tencent.mm.j.g)localObject1).dmk = ((cs)localObject2).field_createTime;
                      ((com.tencent.mm.j.g)localObject1).bXr = ((cs)localObject2).field_msgSvrId;
                      if (localObject3 == null) {
                        break label957;
                      }
                    }
                    label947:
                    label952:
                    label957:
                    for (i = ((bd.b)localObject3).dWM;; i = 0)
                    {
                      ((com.tencent.mm.j.g)localObject1).dml = i;
                      if (((com.tencent.mm.j.g)localObject1).initialDownloadLength > 0) {
                        com.tencent.mm.plugin.report.service.h.nFQ.a(354L, 36L, 1L, false);
                      }
                      ((com.tencent.mm.j.g)localObject1).field_autostart = false;
                      ((com.tencent.mm.j.g)localObject1).field_requestVideoFormat = com.tencent.mm.modelcontrol.d.a(1, locals);
                      break;
                      i = 0;
                      break label706;
                      i = 0;
                      break label783;
                      i = 0;
                      break label851;
                    }
                  }
                }
              }
            }
          }
        }
        localm.bUi = ((com.tencent.mm.j.g)localObject1).field_mediaId;
        localm.fDG = ((com.tencent.mm.j.g)localObject1).dmf;
        localm.filename = str1;
        localm.eFr = 1;
        localm.eFu = 0;
        boolean bool = o.Sw().SN();
        o.Ss().a((com.tencent.mm.j.g)localObject1, bool);
        localm.dmd = bk.UY();
        com.tencent.mm.plugin.report.service.h.nFQ.a(354L, 1L, 1L, false);
        y.i("MicroMsg.OnlineVideoUIHelper", "download online video.[%s, %s] start time[%d]", new Object[] { localm.bUi, str1, Long.valueOf(localm.dmd) });
        i = 1;
      }
      y.i("MicroMsg.Imagegallery.handler.video", "start offline play video.");
      this.oRy = false;
      o.Sr().a(this, Looper.getMainLooper());
      u.oa(parambi.field_imgPath);
      this.vtH.vtJ.cGp();
      this.vwP = false;
      localk.cGH().vxi.setVisibility(8);
      localk.cGH().vxk.setVisibility(0);
      localk.cGH().vxk.setProgress(u.g(params));
      return;
    }
    if (params.SF())
    {
      y.i("MicroMsg.Imagegallery.handler.video", "start complete online video");
      u.oj(parambi.field_imgPath);
    }
    for (;;)
    {
      o.Sr().a(this, Looper.getMainLooper());
      this.vtH.vtJ.cGp();
      this.vwP = false;
      localk.cGH().vxi.setVisibility(8);
      localk.cGH().vxk.setVisibility(0);
      localk.cGH().vxk.setProgress(u.g(params));
      if (i != 2) {
        break;
      }
      com.tencent.mm.plugin.report.service.h.nFQ.a(354L, 14L, 1L, false);
      return;
      y.i("MicroMsg.Imagegallery.handler.video", "start complete offline video");
      dH(parambi.field_imgPath, 10);
      u.oa(parambi.field_imgPath);
    }
    com.tencent.mm.plugin.report.service.h.nFQ.a(354L, 11L, 1L, false);
  }
  
  private void b(k paramk)
  {
    if (paramk == null) {}
    do
    {
      return;
      bHO();
      y.d("MicroMsg.Imagegallery.handler.video", "pause video.");
    } while (!paramk.cGH().vxj.isPlaying());
    paramk.cGH().vxj.pause();
    bHR();
  }
  
  private boolean b(j.a parama)
  {
    if (parama == null) {
      return false;
    }
    o.Sr().a(this);
    if (this.vtH.vtJ.getCurrentItem() == parama.pos)
    {
      parama = Hi(parama.pos);
      if (parama != null)
      {
        parama.cGH().vxr.setVisibility(8);
        parama.cGH().vxk.setVisibility(8);
        parama.cGH().vxi.setVisibility(8);
      }
      this.vwP = true;
      this.vtH.vtJ.cGo();
      return true;
    }
    this.vtH.Hq(parama.pos);
    return false;
  }
  
  private void bHO()
  {
    y.i("MicroMsg.Imagegallery.handler.video", "clear timer");
    this.oRE.stopTimer();
    this.iuI.stopTimer();
  }
  
  private void bHQ()
  {
    this.oRI = bk.UY();
    y.d("MicroMsg.Imagegallery.handler.video", "notePlayVideo filename %s notePlayVideo %d ", new Object[] { this.filename, Long.valueOf(this.oRI) });
  }
  
  private void bHR()
  {
    if (this.oRI > 0L) {
      this.oRJ = ((int)(this.oRJ + (bk.UY() - this.oRI) / 1000L));
    }
    y.i("MicroMsg.Imagegallery.handler.video", "notePauseVideo filename %s playVideoDuration %d ", new Object[] { this.filename, Integer.valueOf(this.oRJ) });
    this.oRI = 0L;
  }
  
  public static com.tencent.mm.modelvideo.s bz(bi parambi)
  {
    if (!c.bf(parambi)) {
      return null;
    }
    return u.oe(parambi.field_imgPath);
  }
  
  private boolean c(k paramk)
  {
    boolean bool2 = false;
    int i = this.vwH;
    this.vwH = paramk.cGH().vxj.getCurrentPosition();
    int j;
    label113:
    boolean bool1;
    if (i != this.vwH)
    {
      this.lastCheckTime = bk.UY();
      long l = paramk.cGH().vxj.getLastSurfaceUpdateTime();
      if ((l > 0L) && (l != this.rYM))
      {
        this.rYM = l;
        j = this.vwI;
        switch (j)
        {
        default: 
          this.vwI = 0;
          bool1 = true;
        }
      }
    }
    do
    {
      do
      {
        return bool1;
        i = 21;
        for (;;)
        {
          y.w("MicroMsg.Imagegallery.handler.video", "%d rpt rptRepairEffect idKey %d errorTime %d filename %s", new Object[] { Integer.valueOf(hashCode()), Integer.valueOf(i), Integer.valueOf(j), this.filename });
          com.tencent.mm.plugin.report.service.h.nFQ.a(354L, i, 1L, false);
          com.tencent.mm.plugin.report.service.h.nFQ.f(13836, new Object[] { Integer.valueOf(301), Long.valueOf(bk.UX()), "" });
          break;
          i = 22;
          continue;
          i = 23;
        }
        if (this.vwI == -1) {
          break label113;
        }
        this.vwI += 1;
        y.w("MicroMsg.Imagegallery.handler.video", "media play is playing[%d], but surface is not update!! repair time[%d]", new Object[] { Integer.valueOf(this.vwI), Integer.valueOf(this.vwJ) });
        if (this.vwJ >= 2) {
          this.vwD.cGK();
        }
        switch (this.vwI)
        {
        case 0: 
        case 1: 
        default: 
          y.w("MicroMsg.Imagegallery.handler.video", "rpt surface not update!!");
          y.w("MicroMsg.Imagegallery.handler.video", "%d rpt rptSurfaceNotUpdate %s", new Object[] { Integer.valueOf(hashCode()), this.filename });
          com.tencent.mm.plugin.report.service.h.nFQ.f(13836, new Object[] { Integer.valueOf(300), Long.valueOf(bk.UX()), "" });
          com.tencent.mm.plugin.report.service.h.nFQ.a(354L, 20L, 1L, false);
          this.vwI = -1;
          break;
        case 2: 
          i = this.vwH / 1000;
          y.w("MicroMsg.Imagegallery.handler.video", "surface not update, it try seek time[%d] to repair.", new Object[] { Integer.valueOf(i) });
          X(i, true);
          this.vwJ += 1;
          return false;
        case 3: 
          j = (this.vwH - 2000) / 1000;
          i = j;
          if (j < 0) {
            i = 0;
          }
          y.w("MicroMsg.Imagegallery.handler.video", "surface not update, it try seek time[%d] to repair.", new Object[] { Integer.valueOf(i) });
          X(i, true);
          this.vwJ += 1;
          return false;
        case 4: 
          j = (this.vwH - 4000) / 1000;
          i = j;
          if (j < 0) {
            i = 0;
          }
          y.w("MicroMsg.Imagegallery.handler.video", "surface not update, it try seek time[%d] to repair.", new Object[] { Integer.valueOf(i) });
          X(i, true);
          this.vwJ += 1;
          return false;
          y.i("MicroMsg.Imagegallery.handler.video", "check time[%d, %d], play time[%d, %d]", new Object[] { Long.valueOf(this.lastCheckTime), Long.valueOf(bk.UY()), Integer.valueOf(i), Integer.valueOf(this.vwH) });
          if ((this.lastCheckTime <= 0L) || (bk.co(this.lastCheckTime) < 1500L)) {
            break;
          }
          y.w("MicroMsg.Imagegallery.handler.video", "play time not update! request all video data to play. ");
          i = this.vtH.cFV().vxj.getCurrentPosition();
          bHO();
          u.f(this.filename, i, this.oRy);
          this.vtH.cFV().vxj.stop();
          this.vwD.cGK();
          paramk = (j.a)this.vvE.get(this.filename);
          bool1 = bool2;
        }
      } while (paramk == null);
      bool1 = bool2;
    } while (paramk.bFH == null);
    com.tencent.mm.modelvideo.s locals = bz(paramk.bFH);
    a(paramk.bFH, locals, paramk.pos, this.oRy);
    this.lastCheckTime = 0L;
    return false;
  }
  
  private void cGD()
  {
    try
    {
      this.vtH.vtJ.cGf().vvV.setIplaySeekCallback(this.rYR);
      return;
    }
    catch (Exception localException) {}
  }
  
  private void dH(String paramString, int paramInt)
  {
    au.DS().O(new j.10(this, paramString, paramInt));
  }
  
  public final void HE(int paramInt)
  {
    this.vwC.remove(paramInt);
  }
  
  protected final void HF(int paramInt)
  {
    paramInt = Math.max(0, paramInt);
    this.vtH.vtJ.cGf().vvV.seek(paramInt);
  }
  
  protected final void Sg()
  {
    k localk = this.vtH.cFV();
    if (localk == null) {
      return;
    }
    y.i("MicroMsg.Imagegallery.handler.video", "start to pause");
    this.vtH.vtJ.ns(true);
    localk.cGH().vxr.setVisibility(0);
    localk.cGH().vxj.pause();
    bHR();
  }
  
  protected final void X(int paramInt, boolean paramBoolean)
  {
    k localk = this.vtH.cFV();
    if (localk == null) {
      return;
    }
    bHQ();
    localk.cGH().vxr.setVisibility(8);
    localk.cGH().vxj.d(paramInt * 1000, paramBoolean);
    this.vtH.vtJ.ns(false);
    ce(false);
  }
  
  public final void a(t.a.a parama)
  {
    Object localObject = parama.fileName;
    if ((bk.bl((String)localObject)) || (this.vvE == null)) {}
    bi localbi;
    do
    {
      do
      {
        do
        {
          do
          {
            return;
            parama = (j.a)this.vvE.get(localObject);
          } while (parama == null);
          localbi = parama.bFH;
        } while ((localbi == null) || (localbi.field_imgPath == null) || (!localbi.field_imgPath.equals(localObject)));
        localObject = bz(localbi);
      } while (localObject == null);
      if ((!localbi.cvx()) && (((com.tencent.mm.modelvideo.s)localObject).status != 198)) {
        break;
      }
    } while (!b(parama));
    Toast.makeText(this.vtH.vtJ, R.l.video_fail_or_clean, 0).show();
    return;
    int i = u.g((com.tencent.mm.modelvideo.s)localObject);
    k localk = Hi(parama.pos);
    if ((this.vtH.vtJ.getCurrentItem() == parama.pos) && (localk != null))
    {
      this.vtH.vtJ.cGp();
      this.vwP = false;
      localk.cGH().vxk.setVisibility(0);
      localk.cGH().vxk.setProgress(i);
    }
    while (localk != null)
    {
      if (i < localk.cGH().vxk.getMax()) {
        break;
      }
      y.d("MicroMsg.Imagegallery.handler.video", "onNotifyChange, status:%d", new Object[] { Integer.valueOf(((com.tencent.mm.modelvideo.s)localObject).status) });
      if (((((com.tencent.mm.modelvideo.s)localObject).status != 199) && (((com.tencent.mm.modelvideo.s)localObject).status != 199)) || (!b(parama))) {
        break;
      }
      this.vtH.vtJ.gs(true);
      i = this.vtH.vtJ.ia(localbi.field_msgId);
      switch (i)
      {
      default: 
        y.w("MicroMsg.Imagegallery.handler.video", "enterVideoOpCode[%d] is error", new Object[] { Integer.valueOf(i) });
        return;
      }
    }
    return;
    a(localbi, (com.tencent.mm.modelvideo.s)localObject, this.vtH.vtJ.getCurrentItem(), false);
    return;
    y.d("MicroMsg.Imagegallery.handler.video", "do restransmit video");
    com.tencent.mm.plugin.report.service.h.nFQ.a(354L, 15L, 1L, false);
    this.vtH.bm(localbi);
    this.vtH.vtJ.ib(-1L);
    if (this.oRy)
    {
      i = this.vtH.cFV().vxj.getCurrentPosition();
      u.f(this.filename, i, this.oRy);
      this.vwK = true;
    }
    this.oRy = false;
    return;
    com.tencent.mm.plugin.report.service.h.nFQ.a(354L, 16L, 1L, false);
    c.a(this.vtH.vtJ, localbi, true);
    this.vtH.vtJ.ib(-1L);
    if (this.oRy)
    {
      i = this.vtH.cFV().vxj.getCurrentPosition();
      u.f(this.filename, i, this.oRy);
      this.vwK = true;
    }
    this.oRy = false;
  }
  
  public final boolean a(k paramk, bi parambi, int paramInt)
  {
    super.a(paramk, parambi, paramInt);
    com.tencent.mm.modelvideo.s locals = bz(parambi);
    if (parambi == null) {
      y.e("MicroMsg.Imagegallery.handler.video", "msg is null!!");
    }
    for (;;)
    {
      return false;
      if (this.vvE != null) {
        this.vvE.put(parambi.field_imgPath, new j.a(parambi, paramInt));
      }
      while (locals != null)
      {
        o.Sr();
        parambi = BackwardSupportUtil.b.e(com.tencent.mm.modelvideo.t.nT(parambi.field_imgPath), 1.0F);
        paramk.cGH().vxh.setImageBitmap(parambi);
        if (paramk.cGH().vxj.isPlaying()) {
          paramk.cGH().vxj.stop();
        }
        paramk.vxl.setVisibility(8);
        paramk.cGH().vxk.setVisibility(8);
        paramk.cGH().vxr.setVisibility(8);
        paramk.a(false, 0.0F);
        this.vwI = 0;
        this.oRC = bk.UY();
        return true;
        y.e("MicroMsg.Imagegallery.handler.video", "mCacheMap is null!");
      }
    }
  }
  
  protected final void adF(String paramString)
  {
    if ((!this.vwP) && (!b((j.a)this.vvE.get(paramString)))) {
      y.w("MicroMsg.Imagegallery.handler.video", "show tool bar error.");
    }
  }
  
  protected final boolean bHP()
  {
    k localk = this.vtH.cFV();
    boolean bool2;
    if (localk == null) {
      bool2 = false;
    }
    boolean bool1;
    do
    {
      return bool2;
      bool1 = true;
      if (!localk.cGH().vxj.isPlaying())
      {
        y.i("MicroMsg.Imagegallery.handler.video", "start to play");
        this.vtH.vtJ.ns(false);
        localk.cGH().vxr.setVisibility(8);
        bool1 = localk.cGH().vxj.start();
        bHQ();
      }
      bool2 = bool1;
    } while (localk.cGH().vxr.getVisibility() == 8);
    localk.cGH().vxr.setVisibility(8);
    return bool1;
  }
  
  protected final void bg(String paramString, boolean paramBoolean)
  {
    ai.d(new j.5(this, paramString, paramBoolean));
  }
  
  public final void cGB()
  {
    this.vwF = false;
    this.kjS = 0;
    if (this.vtH != null) {}
    for (Object localObject = this.vtH.cFV(); localObject == null; localObject = null)
    {
      y.w("MicroMsg.Imagegallery.handler.video", "notify video prepared, but holder is null.");
      return;
    }
    int i = bk.hv(((k)localObject).cGH().vxj.getDuration());
    int j = this.vtH.vtJ.cGf().vvV.getVideoTotalTime();
    y.i("MicroMsg.Imagegallery.handler.video", "%d videoDuration %d hadSetTotalTime %d", new Object[] { Integer.valueOf(hashCode()), Integer.valueOf(i), Integer.valueOf(j) });
    if ((j <= 0) || (Math.abs(j - i) >= 2)) {
      this.vtH.vtJ.cGf().vvV.setVideoTotalTime(i);
    }
    cGD();
    if ((i == 0) || (i >= 1800))
    {
      y.w("MicroMsg.Imagegallery.handler.video", "%d repair video duration[%d] error. filename[%s]", new Object[] { Integer.valueOf(hashCode()), Integer.valueOf(i), this.filename });
      i = u.u(i, this.filename);
      y.i("MicroMsg.Imagegallery.handler.video", "notify video prepared. isOnlinePlay[%b] playDuration[%d] playVideoWhenNotify[%b] hadPlayError[%b].", new Object[] { Boolean.valueOf(this.oRy), Integer.valueOf(i), Boolean.valueOf(this.vwE), Boolean.valueOf(this.vwF) });
      ((k)localObject).cGH().vxj.setOneTimeVideoTextureUpdateCallback(this.oRn);
      if (!this.vwE) {
        break label388;
      }
      if (this.oRy) {
        break label329;
      }
      this.vwD.reset();
      bHQ();
      X(i, true);
    }
    for (;;)
    {
      ce(false);
      return;
      au.DS().O(new j.6(this, i));
      break;
      label329:
      localObject = this.vwD;
      if (i > 0)
      {
        y.i("MicroMsg.OnlineVideoUIHelper", "seek to last duration : " + i);
        ((m)localObject).eFv = i;
        ((m)localObject).eFx = true;
        ((m)localObject).eFs = 2;
      }
      this.vwD.jr(0);
    }
    label388:
    if (!this.oRy) {
      X(i, false);
    }
    for (;;)
    {
      HF(i);
      this.vtH.vtJ.ns(true);
      bHO();
      return;
      this.vwD.at(i, false);
    }
  }
  
  public final void cGC()
  {
    y.i("MicroMsg.Imagegallery.handler.video", "notify video completion. isOnlinePlay : " + this.oRy);
    bHO();
    bHR();
    Object localObject;
    if ((this.oRy) && (this.vtH != null) && (this.vtH.cFV() != null))
    {
      localObject = this.vtH.cFV().cGH().vxj;
      if ((localObject != null) && (((f)localObject).getCurrentPosition() + 2000 < ((f)localObject).getDuration())) {
        y.e("MicroMsg.Imagegallery.handler.video", "notify video completion, but cur pos[%d] is less than duration[%d]", new Object[] { Integer.valueOf(((f)localObject).getCurrentPosition()), Integer.valueOf(((f)localObject).getDuration()) });
      }
    }
    for (int i = 0;; i = 1)
    {
      if (i != 0) {
        ai.d(new j.12(this));
      }
      for (;;)
      {
        return;
        try
        {
          i = this.vtH.cFV().vxj.getCurrentPosition();
          u.f(this.filename, i, this.oRy);
          this.vtH.cFV().vxj.stop();
          this.vwD.cGK();
          i = this.vwN + 1;
          this.vwN = i;
          if (i <= 3)
          {
            localObject = (j.a)this.vvE.get(this.filename);
            if ((localObject != null) && (((j.a)localObject).bFH != null))
            {
              com.tencent.mm.modelvideo.s locals = bz(((j.a)localObject).bFH);
              a(((j.a)localObject).bFH, locals, ((j.a)localObject).pos, this.oRy);
              return;
            }
          }
        }
        catch (Exception localException)
        {
          y.printErrStackTrace("MicroMsg.Imagegallery.handler.video", localException, "notify video completion error[%s]", new Object[] { localException.toString() });
          return;
        }
      }
    }
  }
  
  public final void cGd()
  {
    y.i("MicroMsg.Imagegallery.handler.video", "stopAll. video handler hash code : " + hashCode());
    this.oRD = bk.UY();
    SparseArray localSparseArray = this.vtH.uZw;
    int j = 0;
    int i = 0;
    if (j < localSparseArray.size())
    {
      int k = localSparseArray.keyAt(j);
      if ((localSparseArray.get(k) == null) || (((View)localSparseArray.get(k)).getTag() == null)) {
        break label404;
      }
      k localk = (k)((View)localSparseArray.get(k)).getTag();
      if ((localk.vxg == null) || (localk.cGH().vxg.getVisibility() != 0) || ((((View)localk.cGH().vxj).getVisibility() != 0) && (bk.bl(localk.cGH().vxj.getVideoPath())) && ((!this.oRy) || (!this.vwD.isStreaming())))) {
        break label404;
      }
      y.i("MicroMsg.Imagegallery.handler.video", "stop");
      bHO();
      if (localk != null)
      {
        bHR();
        if (this.oRy) {
          this.vwD.cGJ();
        }
        if (!this.vwF) {
          u.f(this.filename, this.vwH - 1000, this.oRy);
        }
        localk.cGH().vxk.setVisibility(8);
        localk.cGH().vxr.setVisibility(8);
        localk.cGH().vxj.stop();
        HF(0);
        localk.a(false, 0.0F);
        this.oRy = false;
        this.vwP = false;
        this.vwK = false;
        this.filename = null;
        this.oRJ = 0;
        this.oRI = 0L;
        this.vwQ = 0;
        this.vwN = 0;
        this.vwJ = 0;
        this.vwI = 0;
        this.rYM = 0L;
        this.lastCheckTime = 0L;
      }
      i = 1;
    }
    label404:
    for (;;)
    {
      j += 1;
      break;
      this.gEB.bH(false);
      if ((i == 0) && (this.oRy))
      {
        this.vwD.cGJ();
        this.oRy = false;
      }
      bHO();
      this.vwC.clear();
      return;
    }
  }
  
  protected final void ce(boolean paramBoolean)
  {
    if (!this.vwF)
    {
      if (!this.oRy) {
        break label44;
      }
      if (paramBoolean) {
        ai.d(new j.14(this));
      }
    }
    else
    {
      return;
    }
    this.oRE.S(500L, 500L);
    return;
    label44:
    this.iuI.S(500L, 500L);
  }
  
  public final void detach()
  {
    y.i("MicroMsg.Imagegallery.handler.video", "detach.[%d]", new Object[] { Integer.valueOf(hashCode()) });
    this.oRD = bk.UY();
    this.vwM.removeMessages(1);
    bHO();
    com.tencent.mm.sdk.b.a.udP.d(this.vwB);
    com.tencent.mm.sdk.b.a.udP.d(this.vwO);
    cGd();
    this.vtH.vtJ.mController.uMN.getWindow().clearFlags(128);
    this.vtH.vtJ.cGf().vvV.setIplaySeekCallback(null);
    super.detach();
    this.vvE.clear();
    this.vvE = null;
    o.Sr().a(this);
    this.vwC.clear();
    m localm = this.vwD;
    localm.reset();
    localm.eFt = null;
    localm.vxP = null;
    localm.vxQ = null;
    if (com.tencent.mm.plugin.s.e.bip()) {
      au.DS().O(new Runnable()
      {
        public final void run()
        {
          String str = com.tencent.mm.plugin.s.e.biq();
          if (!bk.bl(str))
          {
            com.tencent.mm.plugin.report.service.h.nFQ.aC(14092, str);
            return;
          }
          com.tencent.mm.plugin.report.service.h.nFQ.aC(14092, "0");
        }
      });
    }
    o.Sw().SN();
    o.Sw().run();
  }
  
  public final void fy(int paramInt1, int paramInt2)
  {
    boolean bool2 = this.oRy;
    Object localObject = this.vwD;
    boolean bool1;
    if ((!bk.bl(((m)localObject).bUi)) && (((m)localObject).eFr == 1))
    {
      bool1 = true;
      y.e("MicroMsg.Imagegallery.handler.video", "notify video error, what %d, extras %d isOnlinePlay %b isLoading %b ", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Boolean.valueOf(bool2), Boolean.valueOf(bool1) });
      this.vwF = true;
      this.kjS = paramInt2;
      if (!this.oRy) {
        break label263;
      }
      if (paramInt1 != -1) {
        break label181;
      }
      bHO();
      this.vtH.cFV().vxj.stop();
      this.vwD.cGK();
    }
    label181:
    label244:
    do
    {
      for (;;)
      {
        this.vwP = false;
        this.vtH.vtJ.ns(true);
        this.vtH.cFV().cGH().vxr.setVisibility(0);
        bHR();
        com.tencent.mm.plugin.report.service.h.nFQ.a(354L, 18L, 1L, false);
        return;
        bool1 = false;
        break;
        if (paramInt1 != -2) {
          break label244;
        }
        bHO();
        paramInt1 = this.vtH.cFV().vxj.getCurrentPosition();
        u.f(this.filename, paramInt1, this.oRy);
        this.vtH.cFV().vxj.stop();
        this.vwD.cGK();
      }
    } while (paramInt1 != -3);
    this.vwF = false;
    this.vwD.cGK();
    return;
    label263:
    u.oh(this.filename);
    bHR();
    if ((this.vtH != null) && (this.vtH.cFV() != null) && (this.vtH.cFV().vxj != null))
    {
      localObject = this.vtH.cFV().vxj.getVideoPath();
      this.vtH.cFV().vxj.stop();
    }
    while (this.vwG)
    {
      y.i("MicroMsg.Imagegallery.handler.video", "%d had play completion don't show error tips", new Object[] { Integer.valueOf(hashCode()) });
      return;
      localObject = "";
    }
    ai.d(new j.13(this, (String)localObject));
    com.tencent.mm.plugin.report.service.h.nFQ.a(354L, 25L, 1L, false);
  }
  
  public final void g(bi parambi, int paramInt)
  {
    y.i("MicroMsg.Imagegallery.handler.video", "toggle video");
    if (parambi == null) {}
    com.tencent.mm.modelvideo.s locals;
    do
    {
      do
      {
        return;
      } while ((!c.bf(parambi)) && (!c.bg(parambi)));
      locals = bz(parambi);
    } while (locals == null);
    if ((this.oRy) && (this.vwD != null) && (this.vwD.eFx))
    {
      y.i("MicroMsg.Imagegallery.handler.video", "%d it loading video data, do not response button click.", new Object[] { Integer.valueOf(hashCode()) });
      return;
    }
    if (this.vtH.vtJ.bOu())
    {
      b(Hi(paramInt));
      this.vtH.vtJ.ns(true);
      this.vtH.vtJ.vwp.stopTimer();
      this.gEB.bH(false);
      y.i("MicroMsg.Imagegallery.handler.video", "toggle pause video.");
      return;
    }
    au.Hx();
    if (!com.tencent.mm.model.c.isSDCardAvailable())
    {
      com.tencent.mm.ui.base.s.gM(this.vtH.vtJ.mController.uMN);
      return;
    }
    if (this.oRy) {}
    for (;;)
    {
      int i;
      try
      {
        if (this.vtH.cFV().vxj != null)
        {
          i = this.vtH.cFV().vxj.getCurrentPosition() / 1000;
          if (this.vwD == null) {
            continue;
          }
          if (!this.vwD.js(i)) {
            continue;
          }
          y.i("MicroMsg.Imagegallery.handler.video", "toggle play video");
          a(parambi, locals, paramInt, this.oRy);
          if (this.vtH.vtJ.vwo) {
            this.vtH.vtJ.cGn();
          }
          cGD();
        }
      }
      catch (Exception localException)
      {
        y.printErrStackTrace("MicroMsg.Imagegallery.handler.video", localException, "", new Object[0]);
        i = 0;
        continue;
        y.i("MicroMsg.Imagegallery.handler.video", "toggle start timer.");
        ce(false);
        continue;
        y.w("MicroMsg.Imagegallery.handler.video", "%d toggle video but online video helper is null.", new Object[] { Integer.valueOf(hashCode()) });
        continue;
      }
      if (parambi.field_isSend == 0)
      {
        if ((locals.status != 113) && (locals.status != 198)) {
          break label467;
        }
        a(parambi, locals);
      }
      for (;;)
      {
        if (parambi.field_isSend != 1) {
          break label568;
        }
        i = locals.status;
        if ((i != 111) && (i != 113) && (i != 112) && (i != 121) && (i != 122)) {
          break label570;
        }
        y.i("MicroMsg.Imagegallery.handler.video", "download video. msg talker[%s], info status[%d]", new Object[] { parambi.field_talker, Integer.valueOf(i) });
        a(parambi, locals);
        break;
        label467:
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
      label568:
      continue;
      label570:
      a(parambi, locals, paramInt, false);
    }
  }
  
  public final void h(bi parambi, int paramInt)
  {
    y.i("MicroMsg.Imagegallery.handler.video", "toggleVideoMenu pos ");
    com.tencent.mm.modelvideo.s locals = u.oe(parambi.field_imgPath);
    if ((locals != null) && (!locals.SG()))
    {
      b(Hi(paramInt));
      this.vtH.vtJ.ns(true);
      if (this.oRy)
      {
        this.vwD.cGJ();
        this.vwD.reset();
      }
      a(parambi, locals);
      if (this.vtH.vtJ.ia(parambi.field_msgId) == 2) {
        dH(parambi.field_imgPath, 8);
      }
    }
    else
    {
      return;
    }
    dH(parambi.field_imgPath, 5);
  }
  
  protected final void onResume()
  {
    y.i("MicroMsg.Imagegallery.handler.video", "ui on resume, add online video event.");
    this.vwM.removeMessages(1);
    com.tencent.mm.sdk.b.a.udP.c(this.vwO);
    k localk;
    if ((this.vtH != null) && (com.tencent.mm.compatible.util.d.gF(21)))
    {
      localk = this.vtH.cFV();
      if ((localk != null) && (localk.vxj != null))
      {
        if (!(localk.vxj instanceof VideoPlayerTextureView)) {
          break label83;
        }
        ((VideoPlayerTextureView)localk.vxj).biz();
      }
    }
    label83:
    while (!(localk.vxj instanceof VideoTextureView)) {
      return;
    }
    ((VideoTextureView)localk.vxj).biz();
  }
  
  public final void pause(int paramInt)
  {
    b(Hi(paramInt));
    this.gEB.bH(false);
    this.vtH.vtJ.ns(true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.gallery.j
 * JD-Core Version:    0.7.0.1
 */