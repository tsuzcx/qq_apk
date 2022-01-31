package com.tencent.mm.ui.chatting;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.res.Resources;
import android.media.ToneGenerator;
import android.os.Build.VERSION;
import android.os.Vibrator;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.widget.ListView;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.j.a;
import com.tencent.mm.ai.j.b;
import com.tencent.mm.aj.d.b;
import com.tencent.mm.aj.f;
import com.tencent.mm.compatible.util.e;
import com.tencent.mm.g.a.ob;
import com.tencent.mm.g.a.ux;
import com.tencent.mm.g.c.aq;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.aw;
import com.tencent.mm.model.bf;
import com.tencent.mm.model.r;
import com.tencent.mm.modelcontrol.VideoTransPara;
import com.tencent.mm.modelvoice.s;
import com.tencent.mm.platformtools.ae;
import com.tencent.mm.plugin.mmsight.SightParams;
import com.tencent.mm.plugin.recordvideo.jumper.CaptureDataManager;
import com.tencent.mm.plugin.recordvideo.jumper.CaptureDataManager.b;
import com.tencent.mm.plugin.recordvideo.jumper.RecordConfigProvider;
import com.tencent.mm.plugin.recordvideo.jumper.VideoCaptureReportInfo;
import com.tencent.mm.pluginsdk.ui.chat.AppPanel.a;
import com.tencent.mm.pluginsdk.ui.chat.ChatFooter;
import com.tencent.mm.pluginsdk.ui.tools.n;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.ap.a;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.bd;
import com.tencent.mm.storage.bi;
import com.tencent.mm.storage.z;
import com.tencent.mm.ui.MMFragment;
import com.tencent.mm.ui.base.n.d;
import com.tencent.mm.ui.chatting.c.b.af;
import com.tencent.mm.ui.tools.l;
import java.util.Iterator;
import java.util.List;
import org.json.JSONObject;

public final class p
  implements com.tencent.mm.pluginsdk.ui.chat.b
{
  public static boolean zyH = true;
  private com.tencent.mm.storage.ad contact;
  private final ap gcG;
  private Vibrator kqP;
  private Object lock;
  private final ap mwY;
  private final j.a oBB;
  private final j.b oBC;
  private ChatFooter oBw;
  private AppPanel.a oCi;
  private com.tencent.mm.ui.chatting.d.a zcV;
  private boolean zvB;
  private com.tencent.mm.ai.j zyI;
  private String zyJ;
  private String zyK;
  private ToneGenerator zyL;
  private boolean zyM;
  private boolean zyN;
  public boolean zyO;
  private boolean zyP;
  private volatile boolean zyQ;
  private volatile boolean zyR;
  private boolean zyS;
  
  public p(com.tencent.mm.ui.chatting.d.a parama, ChatFooter paramChatFooter, String paramString)
  {
    AppMethodBeat.i(30655);
    this.zyP = true;
    this.oBB = new p.1(this);
    this.oBC = new p.4(this);
    this.zyQ = false;
    this.zyR = false;
    this.lock = new Object();
    this.gcG = new ap(new ap.a()
    {
      public final boolean onTimerExpired()
      {
        AppMethodBeat.i(156112);
        p.d(p.this).Mj(p.a(p.this).getMaxAmplitude());
        AppMethodBeat.o(156112);
        return true;
      }
    }, true);
    this.zyS = false;
    this.mwY = new ap(new p.7(this), true);
    this.oCi = new p.8(this);
    this.zcV = parama;
    this.oBw = paramChatFooter;
    this.zyJ = paramString;
    aw.aaz();
    this.contact = com.tencent.mm.model.c.YA().arw(paramString);
    this.zyM = com.tencent.mm.model.t.lA(this.zcV.getTalkerUserName());
    this.zyN = com.tencent.mm.model.t.nO(this.zcV.getTalkerUserName());
    boolean bool;
    if ((this.zyM) || (this.zyN))
    {
      bool = true;
      this.zvB = bool;
      this.kqP = ((Vibrator)this.zcV.zJz.getContext().getSystemService("vibrator"));
      if (!com.tencent.mm.model.t.oq(this.zyJ)) {
        break label318;
      }
      this.zyI = new com.tencent.mm.plugin.subapp.c.i();
      com.tencent.mm.sdk.platformtools.ab.i("MicroMsg.ChattingFooterEventImpl", "initRecorder new VoiceRemindRecorder().");
    }
    for (;;)
    {
      this.zyI.a(this.oBC);
      this.zyI.a(this.oBB);
      paramChatFooter.setAppPanelListener(this.oCi);
      this.zyP = ((com.tencent.mm.plugin.expt.a.a)g.E(com.tencent.mm.plugin.expt.a.a.class)).a(com.tencent.mm.plugin.expt.a.a.a.lVQ, true);
      AppMethodBeat.o(30655);
      return;
      bool = false;
      break;
      label318:
      parama = this.zyJ;
      int i;
      if (com.tencent.mm.model.t.oB(parama)) {
        i = 1;
      }
      for (;;)
      {
        if (i == 0) {
          break label501;
        }
        this.zyI = new com.tencent.mm.audio.b.h(this.zcV.zJz.getContext(), true);
        com.tencent.mm.sdk.platformtools.ab.i("MicroMsg.ChattingFooterEventImpl", "initRecorder new SceneVoiceRecorder, use Speex");
        break;
        parama = ((com.tencent.mm.plugin.messenger.foundation.a.j)g.E(com.tencent.mm.plugin.messenger.foundation.a.j.class)).YA().arw(parama);
        if ((parama != null) && (parama.dwz()))
        {
          paramString = f.rS(parama.field_username);
          if (paramString != null)
          {
            paramString = paramString.cU(false);
            if (paramString != null)
            {
              if (paramString.fvc != null) {
                paramString.fvg = "1".equals(paramString.fvc.optString("CanReceiveSpeexVoice"));
              }
              if (paramString.fvg)
              {
                com.tencent.mm.sdk.platformtools.ab.i("MicroMsg.BizInfoStorageLogic", "bizinfo name=" + parama.field_username + " canReceiveSpeexVoice");
                i = 1;
                continue;
              }
            }
          }
        }
        i = 0;
      }
      label501:
      this.zyI = new com.tencent.mm.audio.b.h(this.zcV.zJz.getContext(), false);
      com.tencent.mm.sdk.platformtools.ab.i("MicroMsg.ChattingFooterEventImpl", "initRecorder new SceneVoiceRecorder, not use Speex");
    }
  }
  
  private static void Pp(int paramInt)
  {
    AppMethodBeat.i(30671);
    ob localob = new ob();
    localob.cEN.state = paramInt;
    com.tencent.mm.sdk.b.a.ymk.l(localob);
    AppMethodBeat.o(30671);
  }
  
  private boolean dGs()
  {
    boolean bool = false;
    int i = 1;
    AppMethodBeat.i(30664);
    this.zcV.zJz.enableOptionMenu(true);
    this.zcV.zJz.enableBackMenu(true);
    if (this.zyI != null) {
      if ((this.zyI.isRecording()) && (dGt()))
      {
        bool = this.zyI.Ez();
        this.gcG.stopTimer();
        this.mwY.stopTimer();
        if (i != 0) {
          dGu();
        }
        com.tencent.mm.sdk.platformtools.aj.apl("keep_app_silent");
      }
    }
    for (;;)
    {
      AppMethodBeat.o(30664);
      return bool;
      i = 0;
      break;
      com.tencent.mm.sdk.platformtools.ab.i("MicroMsg.ChattingFooterEventImpl", "stopRecording recorder == null");
    }
  }
  
  private boolean dGt()
  {
    AppMethodBeat.i(30668);
    if ((this.contact.field_username.equals("medianote")) && ((r.Zr() & 0x4000) == 0))
    {
      AppMethodBeat.o(30668);
      return true;
    }
    AppMethodBeat.o(30668);
    return false;
  }
  
  private void dGu()
  {
    AppMethodBeat.i(30669);
    bi localbi = new bi();
    localbi.kj("medianote");
    localbi.setType(34);
    localbi.hL(1);
    localbi.kk(this.zyK);
    localbi.setStatus(2);
    localbi.setContent(com.tencent.mm.modelvoice.p.d(r.Zn(), this.zyI.EK(), false));
    localbi.fQ(bf.py("medianote"));
    if (this.zyI.EQ() == 2) {
      localbi.jl("SOURCE_SILK_FILE");
    }
    aw.aaz();
    long l = com.tencent.mm.model.c.YC().Z(localbi);
    if (l <= 0L)
    {
      com.tencent.mm.sdk.platformtools.ab.e("MicroMsg.ChattingFooterEventImpl", "insertLocalMsg fail");
      AppMethodBeat.o(30669);
      return;
    }
    com.tencent.mm.sdk.platformtools.ab.i("MicroMsg.ChattingFooterEventImpl", "insertLocalMsg success, msgId = ".concat(String.valueOf(l)));
    AppMethodBeat.o(30669);
  }
  
  private void releaseWakeLock()
  {
    AppMethodBeat.i(30663);
    this.zcV.setKeepScreenOn(false);
    AppMethodBeat.o(30663);
  }
  
  public final long EN()
  {
    AppMethodBeat.i(155487);
    if (this.zyI != null)
    {
      long l = this.zyI.EN();
      AppMethodBeat.o(155487);
      return l;
    }
    AppMethodBeat.o(155487);
    return 0L;
  }
  
  public final void M(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(30662);
    if ((paramMotionEvent == null) || (paramMotionEvent.getAction() == 1))
    {
      this.zcV.dJJ();
      this.zcV.dGJ();
    }
    AppMethodBeat.o(30662);
  }
  
  public final void Pq(final int paramInt)
  {
    AppMethodBeat.i(30673);
    boolean bool = com.tencent.mm.pluginsdk.permission.b.a(this.zcV.zJz.getContext(), "android.permission.CAMERA", 18, "", "");
    com.tencent.mm.sdk.platformtools.ab.i("MicroMsg.ChattingFooterEventImpl", "summerper checkPermission checkCamera[%b], stack[%s], activity[%s]", new Object[] { Boolean.valueOf(bool), bo.dtY(), this.zcV.zJz.getContext() });
    if (!bool)
    {
      AppMethodBeat.o(30673);
      return;
    }
    bool = com.tencent.mm.pluginsdk.permission.b.a(this.zcV.zJz.getContext(), "android.permission.RECORD_AUDIO", 18, "", "");
    com.tencent.mm.sdk.platformtools.ab.i("MicroMsg.ChattingFooterEventImpl", "summerper checkPermission checkmicrophone[%b], stack[%s], activity[%s]", new Object[] { Boolean.valueOf(bool), bo.dtY(), this.zcV.zJz.getContext() });
    if (!bool)
    {
      AppMethodBeat.o(30673);
      return;
    }
    Object localObject1;
    if ((com.tencent.mm.sdk.a.b.dsf()) || (ae.glD))
    {
      localObject1 = new l(this.zcV.zJz.getContext());
      ((l)localObject1).sao = new p.10(this);
      ((l)localObject1).sap = new n.d()
      {
        public final void onMMMenuItemSelected(MenuItem paramAnonymousMenuItem, int paramAnonymousInt)
        {
          AppMethodBeat.i(156110);
          switch (paramAnonymousMenuItem.getItemId())
          {
          }
          for (;;)
          {
            AppMethodBeat.o(156110);
            return;
            com.tencent.mm.plugin.report.service.h.qsU.e(13822, new Object[] { Integer.valueOf(1), Integer.valueOf(1) });
            paramAnonymousMenuItem = new SightParams(1, paramInt);
            Object localObject = com.tencent.mm.modelvideo.t.ve(p.this.getTalkerUserName());
            com.tencent.mm.modelvideo.o.alE();
            String str = com.tencent.mm.modelvideo.t.vf((String)localObject);
            com.tencent.mm.modelvideo.o.alE();
            paramAnonymousMenuItem = RecordConfigProvider.a(str, com.tencent.mm.modelvideo.t.vg((String)localObject), paramAnonymousMenuItem.fcu, paramAnonymousMenuItem.fcu.duration * 1000, 1);
            if (((com.tencent.mm.plugin.expt.a.a)g.E(com.tencent.mm.plugin.expt.a.a.class)).a(com.tencent.mm.plugin.expt.a.a.a.lVR, false)) {
              paramAnonymousMenuItem.qbm = 2;
            }
            localObject = new VideoCaptureReportInfo();
            ((VideoCaptureReportInfo)localObject).mhr = 3;
            if (p.m(p.this)) {
              ((VideoCaptureReportInfo)localObject).mhr = 4;
            }
            paramAnonymousMenuItem.qbE = ((VideoCaptureReportInfo)localObject);
            localObject = new p.2.1(this);
            CaptureDataManager.qbh.qbg = ((CaptureDataManager.b)localObject);
            if (p.n(p.this))
            {
              localObject = com.tencent.mm.plugin.recordvideo.jumper.a.qbG;
              com.tencent.mm.plugin.recordvideo.jumper.a.a(p.e(p.this).zJz.getContext(), 226, paramAnonymousMenuItem);
              AppMethodBeat.o(156110);
              return;
            }
            n.a(p.e(p.this).zJz, new Intent(), p.this.getTalkerUserName(), paramInt);
            AppMethodBeat.o(156110);
            return;
            com.tencent.mm.bq.d.b(p.e(p.this).zJz.getContext(), "mmsight", ".ui.SightSettingsUI", new Intent());
          }
        }
      };
      ((l)localObject1).cwt();
      AppMethodBeat.o(30673);
      return;
    }
    if (!ae.glE)
    {
      com.tencent.mm.plugin.report.service.h.qsU.e(13822, new Object[] { Integer.valueOf(1), Integer.valueOf(1) });
      localObject1 = new SightParams(1, paramInt);
      Object localObject2 = com.tencent.mm.modelvideo.t.ve(getTalkerUserName());
      com.tencent.mm.modelvideo.o.alE();
      String str = com.tencent.mm.modelvideo.t.vf((String)localObject2);
      com.tencent.mm.modelvideo.o.alE();
      localObject1 = RecordConfigProvider.a(str, com.tencent.mm.modelvideo.t.vg((String)localObject2), ((SightParams)localObject1).fcu, ((SightParams)localObject1).fcu.duration * 1000, 1);
      if (((com.tencent.mm.plugin.expt.a.a)g.E(com.tencent.mm.plugin.expt.a.a.class)).a(com.tencent.mm.plugin.expt.a.a.a.lVR, false)) {
        ((RecordConfigProvider)localObject1).qbm = 2;
      }
      localObject2 = new VideoCaptureReportInfo();
      ((VideoCaptureReportInfo)localObject2).mhr = 3;
      if (this.zvB) {
        ((VideoCaptureReportInfo)localObject2).mhr = 4;
      }
      ((RecordConfigProvider)localObject1).qbE = ((VideoCaptureReportInfo)localObject2);
      localObject2 = new p.3(this);
      CaptureDataManager.qbh.qbg = ((CaptureDataManager.b)localObject2);
      if (this.zyP)
      {
        localObject2 = com.tencent.mm.plugin.recordvideo.jumper.a.qbG;
        com.tencent.mm.plugin.recordvideo.jumper.a.a(this.zcV.zJz.getContext(), 226, (RecordConfigProvider)localObject1);
        AppMethodBeat.o(30673);
        return;
      }
      n.a(this.zcV.zJz, new Intent(), getTalkerUserName(), paramInt);
    }
    AppMethodBeat.o(30673);
  }
  
  public final boolean SE(String paramString)
  {
    AppMethodBeat.i(30659);
    this.zcV.dJJ();
    this.zcV.dGJ();
    boolean bool = ((com.tencent.mm.ui.chatting.c.b.ad)this.zcV.ay(com.tencent.mm.ui.chatting.c.b.ad.class)).atY(paramString);
    AppMethodBeat.o(30659);
    return bool;
  }
  
  public final boolean SF(String paramString)
  {
    AppMethodBeat.i(155489);
    if (!bo.isNullOrNil(paramString))
    {
      s.vN(paramString);
      com.tencent.mm.modelvoice.o.amu().run();
      AppMethodBeat.o(155489);
      return true;
    }
    AppMethodBeat.o(155489);
    return false;
  }
  
  public final boolean bPe()
  {
    AppMethodBeat.i(30656);
    synchronized (this.lock)
    {
      this.zyQ = true;
      if (!this.zyR)
      {
        com.tencent.mm.sdk.platformtools.ab.i("MicroMsg.ChattingFooterEventImpl", "jacks in voice rcd stop but not begin.");
        AppMethodBeat.o(30656);
        return false;
      }
    }
    this.zyR = false;
    releaseWakeLock();
    if (!dGs())
    {
      this.oBw.dhO();
      com.tencent.mm.sdk.platformtools.ab.i("MicroMsg.ChattingFooterEventImpl", "record stop on stop request setRcdTooShort");
    }
    for (;;)
    {
      ((com.tencent.mm.ui.chatting.c.b.aj)this.zcV.ay(com.tencent.mm.ui.chatting.c.b.aj.class)).dJv().dFJ();
      ((com.tencent.mm.ui.chatting.c.b.ab)this.zcV.ay(com.tencent.mm.ui.chatting.c.b.ab.class)).PJ(4);
      ((com.tencent.mm.ui.chatting.c.b.ab)this.zcV.ay(com.tencent.mm.ui.chatting.c.b.ab.class)).stopSignalling();
      Pp(1);
      ((com.tencent.mm.ui.chatting.c.b.aj)this.zcV.ay(com.tencent.mm.ui.chatting.c.b.aj.class)).a(this.zcV.zJz, false);
      AppMethodBeat.o(30656);
      return true;
      ??? = com.tencent.mm.plugin.transvoice.a.c.tpD;
      com.tencent.mm.plugin.transvoice.a.c.cKY().GV(0);
      this.oBw.bxy();
      com.tencent.mm.sdk.platformtools.ab.i("MicroMsg.ChattingFooterEventImpl", "record stop on stop request resetRcdStatus");
    }
  }
  
  public final boolean bPf()
  {
    AppMethodBeat.i(155485);
    com.tencent.mm.sdk.platformtools.ab.v("MicroMsg.ChattingFooterEventImpl", "only stop recording.");
    synchronized (this.lock)
    {
      this.zyQ = true;
      if (!this.zyR)
      {
        com.tencent.mm.sdk.platformtools.ab.i("MicroMsg.ChattingFooterEventImpl", "ever never begin.");
        AppMethodBeat.o(155485);
        return false;
      }
    }
    this.zyR = false;
    releaseWakeLock();
    this.zcV.zJz.enableOptionMenu(true);
    this.zcV.zJz.enableBackMenu(true);
    if (this.zyI != null)
    {
      this.zyI.EL();
      this.gcG.stopTimer();
      this.mwY.stopTimer();
    }
    this.oBw.bxy();
    ((com.tencent.mm.ui.chatting.c.b.aj)this.zcV.ay(com.tencent.mm.ui.chatting.c.b.aj.class)).dJv().dFJ();
    ((com.tencent.mm.ui.chatting.c.b.ab)this.zcV.ay(com.tencent.mm.ui.chatting.c.b.ab.class)).PJ(4);
    ((com.tencent.mm.ui.chatting.c.b.ab)this.zcV.ay(com.tencent.mm.ui.chatting.c.b.ab.class)).stopSignalling();
    Pp(1);
    ((com.tencent.mm.ui.chatting.c.b.aj)this.zcV.ay(com.tencent.mm.ui.chatting.c.b.aj.class)).a(this.zcV.zJz, false);
    AppMethodBeat.o(155485);
    return true;
  }
  
  public final boolean bPh()
  {
    AppMethodBeat.i(30657);
    com.tencent.mm.sdk.platformtools.ab.v("MicroMsg.ChattingFooterEventImpl", "record cancel on cancel request");
    synchronized (this.lock)
    {
      this.zyQ = true;
      if (!this.zyR)
      {
        com.tencent.mm.sdk.platformtools.ab.i("MicroMsg.ChattingFooterEventImpl", "jacks in voice rcd stop but not begin.");
        AppMethodBeat.o(30657);
        return false;
      }
    }
    this.zyR = false;
    releaseWakeLock();
    this.zcV.zJz.enableOptionMenu(true);
    this.zcV.zJz.enableBackMenu(true);
    if (this.zyI != null)
    {
      this.zyI.cancel();
      this.gcG.stopTimer();
      this.mwY.stopTimer();
    }
    this.oBw.bxy();
    ((com.tencent.mm.ui.chatting.c.b.aj)this.zcV.ay(com.tencent.mm.ui.chatting.c.b.aj.class)).dJv().dFJ();
    ((com.tencent.mm.ui.chatting.c.b.ab)this.zcV.ay(com.tencent.mm.ui.chatting.c.b.ab.class)).PJ(4);
    ((com.tencent.mm.ui.chatting.c.b.ab)this.zcV.ay(com.tencent.mm.ui.chatting.c.b.ab.class)).stopSignalling();
    Pp(1);
    ((com.tencent.mm.ui.chatting.c.b.aj)this.zcV.ay(com.tencent.mm.ui.chatting.c.b.aj.class)).a(this.zcV.zJz, false);
    AppMethodBeat.o(30657);
    return true;
  }
  
  public final boolean bPi()
  {
    AppMethodBeat.i(30658);
    if ((com.tencent.mm.r.a.bO(this.zcV.zJz.getContext())) || (com.tencent.mm.r.a.bM(this.zcV.zJz.getContext())))
    {
      com.tencent.mm.sdk.platformtools.ab.d("MicroMsg.ChattingFooterEventImpl", "voip is running, cann't record voice");
      AppMethodBeat.o(30658);
      return false;
    }
    aw.aaz();
    if (!com.tencent.mm.model.c.isSDCardAvailable())
    {
      com.tencent.mm.ui.base.t.ii(this.zcV.zJz.getContext());
      com.tencent.mm.sdk.platformtools.ab.e("MicroMsg.ChattingFooterEventImpl", "onVoiceRcdStartRequest isSDCardAvailable() failed and return.");
      AppMethodBeat.o(30658);
      return false;
    }
    if (!com.tencent.mm.compatible.f.b.Md()) {
      com.tencent.mm.ui.base.h.a(this.zcV.zJz.getContext(), this.zcV.zJz.getMMResources().getString(2131297083), this.zcV.zJz.getMMResources().getString(2131297007), this.zcV.zJz.getMMResources().getString(2131297009), true, new DialogInterface.OnClickListener()
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(30627);
          com.tencent.mm.compatible.f.b.bJ(p.e(p.this).zJz.getContext());
          AppMethodBeat.o(30627);
        }
      });
    }
    synchronized (this.lock)
    {
      this.zyQ = false;
    }
    synchronized (this.lock)
    {
      if (this.zyQ)
      {
        com.tencent.mm.sdk.platformtools.ab.i("MicroMsg.ChattingFooterEventImpl", "jacks already stop before begin!!");
        AppMethodBeat.o(30658);
        return false;
        localObject2 = finally;
        AppMethodBeat.o(30658);
        throw localObject2;
      }
      if (this.zcV.zJz.getContext().isFinishing())
      {
        AppMethodBeat.o(30658);
        return false;
      }
    }
    if ((Build.VERSION.SDK_INT >= 17) && (this.zcV.zJz.getContext().isDestroyed()))
    {
      AppMethodBeat.o(30658);
      return false;
    }
    this.zyR = true;
    ??? = com.tencent.mm.plugin.transvoice.a.c.tpD;
    com.tencent.mm.plugin.transvoice.a.c.cKY().tpk = true;
    this.gcG.ag(100L, 100L);
    this.zyS = false;
    this.mwY.ag(200L, 200L);
    this.oBw.Mi(this.zcV.getListView().getHeight());
    ??? = ((com.tencent.mm.ui.chatting.c.b.aj)this.zcV.ay(com.tencent.mm.ui.chatting.c.b.aj.class)).dJv();
    ((d)???).isRecording = true;
    ((d)???).dFN();
    ((d)???).dFI();
    this.zcV.zJz.enableOptionMenu(false);
    this.zcV.zJz.enableBackMenu(false);
    if (this.zyI != null)
    {
      com.tencent.mm.sdk.platformtools.aj.apk("keep_app_silent");
      if (this.oBw.getTransVoiceOpener())
      {
        this.oBw.setVoice2txtCountDown(-1);
        this.zyI.eI(getTalkerUserName());
        this.zyK = this.zyI.getFileName();
        this.zyI.a(this.oBC);
        this.kqP.vibrate(50L);
        this.zcV.aWN();
        this.zcV.dJJ();
        this.zyI.a(this.oBB);
      }
    }
    for (;;)
    {
      this.zcV.setKeepScreenOn(true);
      ((com.tencent.mm.ui.chatting.c.b.ab)this.zcV.ay(com.tencent.mm.ui.chatting.c.b.ab.class)).PJ(3);
      ((com.tencent.mm.ui.chatting.c.b.ab)this.zcV.ay(com.tencent.mm.ui.chatting.c.b.ab.class)).keepSignalling();
      Pp(0);
      ((com.tencent.mm.ui.chatting.c.b.aj)this.zcV.ay(com.tencent.mm.ui.chatting.c.b.aj.class)).a(this.zcV.zJz, true);
      AppMethodBeat.o(30658);
      return true;
      this.oBw.setRecordNormalWording(this.zcV.zJz.getMMResources().getString(2131298110));
      break;
      com.tencent.mm.sdk.platformtools.ab.e("MicroMsg.ChattingFooterEventImpl", "startRecording recorder is null and stop recod");
    }
  }
  
  public final void bPj()
  {
    AppMethodBeat.i(30660);
    this.zcV.dJJ();
    this.zcV.dGJ();
    AppMethodBeat.o(30660);
  }
  
  public final void bPk()
  {
    AppMethodBeat.i(30661);
    this.zcV.dJJ();
    this.zcV.dGJ();
    AppMethodBeat.o(30661);
  }
  
  public final boolean cA(String paramString, int paramInt)
  {
    AppMethodBeat.i(155488);
    if ((!bo.isNullOrNil(paramString)) && (paramInt > 0) && (s.vT(paramString) != null))
    {
      s.ah(paramString, paramInt);
      com.tencent.mm.modelvoice.o.amu().run();
      AppMethodBeat.o(155488);
      return true;
    }
    AppMethodBeat.o(155488);
    return false;
  }
  
  public final void ccv()
  {
    AppMethodBeat.i(30676);
    boolean bool = com.tencent.mm.pluginsdk.permission.b.a(this.zcV.zJz.getContext(), "android.permission.RECORD_AUDIO", 82, "", "");
    com.tencent.mm.sdk.platformtools.ab.i("MicroMsg.ChattingFooterEventImpl", "summerper checkPermission checkmicrophone[%b], stack[%s], activity[%s]", new Object[] { Boolean.valueOf(bool), bo.dtY(), this.zcV.zJz.getContext() });
    if (!bool)
    {
      AppMethodBeat.o(30676);
      return;
    }
    ux localux = new ux();
    localux.cLs.cut = 5;
    localux.cLs.talker = getTalkerUserName();
    localux.cLs.context = this.zcV.zJz.getContext();
    localux.cLs.cLm = 4;
    if (this.oBw.doB()) {
      this.oBw.setBottomPanelVisibility(8);
    }
    com.tencent.mm.sdk.b.a.ymk.l(localux);
    AppMethodBeat.o(30676);
  }
  
  public final void ccw()
  {
    AppMethodBeat.i(30677);
    boolean bool = com.tencent.mm.pluginsdk.permission.b.a(this.zcV.zJz.getContext(), "android.permission.CAMERA", 19, "", "");
    com.tencent.mm.sdk.platformtools.ab.i("MicroMsg.ChattingFooterEventImpl", "summerper checkPermission checkCamera[%b], stack[%s], activity[%s]", new Object[] { Boolean.valueOf(bool), bo.dtY(), this.zcV.zJz.getContext() });
    if (!bool)
    {
      AppMethodBeat.o(30677);
      return;
    }
    bool = com.tencent.mm.pluginsdk.permission.b.a(this.zcV.zJz.getContext(), "android.permission.RECORD_AUDIO", 19, "", "");
    com.tencent.mm.sdk.platformtools.ab.i("MicroMsg.ChattingFooterEventImpl", "summerper checkPermission checkmicrophone[%b], stack[%s], activity[%s]", new Object[] { Boolean.valueOf(bool), bo.dtY(), this.zcV.zJz.getContext() });
    if (!bool)
    {
      AppMethodBeat.o(30677);
      return;
    }
    ux localux = new ux();
    localux.cLs.cut = 5;
    localux.cLs.talker = getTalkerUserName();
    localux.cLs.context = this.zcV.zJz.getContext();
    localux.cLs.cLm = 2;
    if (this.oBw.doB()) {
      this.oBw.setBottomPanelVisibility(8);
    }
    com.tencent.mm.sdk.b.a.ymk.l(localux);
    AppMethodBeat.o(30677);
  }
  
  public final void dGv()
  {
    AppMethodBeat.i(30672);
    boolean bool = com.tencent.mm.pluginsdk.permission.b.a(this.zcV.zJz.getContext(), "android.permission.CAMERA", 22, "", "");
    com.tencent.mm.sdk.platformtools.ab.i("MicroMsg.ChattingFooterEventImpl", "summerper checkPermission checkCamera[%b], stack[%s], activity[%s]", new Object[] { Boolean.valueOf(bool), bo.dtY(), this.zcV.zJz.getContext() });
    if (!bool)
    {
      AppMethodBeat.o(30672);
      return;
    }
    bool = com.tencent.mm.pluginsdk.permission.b.a(this.zcV.zJz.getContext(), "android.permission.RECORD_AUDIO", 22, "", "");
    com.tencent.mm.sdk.platformtools.ab.i("MicroMsg.ChattingFooterEventImpl", "summerper checkPermission checkmicrophone[%b], stack[%s], activity[%s]", new Object[] { Boolean.valueOf(bool), bo.dtY(), this.zcV.zJz.getContext() });
    if (!bool)
    {
      AppMethodBeat.o(30672);
      return;
    }
    com.tencent.mm.sdk.platformtools.ab.i("MicroMsg.ChattingFooterEventImpl", "onEnterMultiTalk");
    Intent localIntent = new Intent();
    if (com.tencent.mm.bh.d.fUO.uO(getTalkerUserName()))
    {
      com.tencent.mm.sdk.platformtools.ab.i("MicroMsg.ChattingFooterEventImpl", "onEnterMultiTalk, but now is in share location!");
      Toast.makeText(ah.getContext(), 2131300733, 0).show();
      AppMethodBeat.o(30672);
      return;
    }
    List localList;
    if (getTalkerUserName() != null)
    {
      localList = ((com.tencent.mm.plugin.multitalk.model.a)g.E(com.tencent.mm.plugin.multitalk.model.a.class)).Ul(getTalkerUserName());
      aw.aaz();
      String str1 = (String)com.tencent.mm.model.c.Ru().get(2, null);
      bool = ((com.tencent.mm.plugin.multitalk.model.a)g.E(com.tencent.mm.plugin.multitalk.model.a.class)).Ui(getTalkerUserName());
      Iterator localIterator = localList.iterator();
      String str2;
      do
      {
        if (!localIterator.hasNext()) {
          break;
        }
        str2 = (String)localIterator.next();
      } while ((str1 == null) || (!str1.equals(str2)));
    }
    for (int i = 1;; i = 0)
    {
      if ((localList.size() >= 9) && (i == 0))
      {
        com.tencent.mm.sdk.platformtools.ab.i("MicroMsg.ChattingFooterEventImpl", "onEnterMultiTalk, but > max 9 members!");
        Toast.makeText(ah.getContext(), ah.getContext().getString(2131301688, new Object[] { Integer.valueOf(9) }), 0).show();
        AppMethodBeat.o(30672);
        return;
      }
      if (i != 0)
      {
        if (((com.tencent.mm.plugin.multitalk.model.a)g.E(com.tencent.mm.plugin.multitalk.model.a.class)).bSD())
        {
          com.tencent.mm.sdk.platformtools.ab.i("MicroMsg.ChattingFooterEventImpl", "onEnterMultiTalk, but already in it!");
          Toast.makeText(ah.getContext(), ah.getContext().getString(2131301676), 0).show();
          AppMethodBeat.o(30672);
          return;
        }
        com.tencent.mm.sdk.platformtools.ab.i("MicroMsg.ChattingFooterEventImpl", "onEnterMultiTalk, already inlist, but in fact not multitalking now!");
      }
      if (((com.tencent.mm.plugin.multitalk.model.a)g.E(com.tencent.mm.plugin.multitalk.model.a.class)).bSB())
      {
        com.tencent.mm.sdk.platformtools.ab.i("MicroMsg.ChattingFooterEventImpl", "onEnterMultiTalk, but already in VoIP or multitalk!");
        Toast.makeText(ah.getContext(), ah.getContext().getString(2131301676), 0).show();
        AppMethodBeat.o(30672);
        return;
      }
      if (bool)
      {
        com.tencent.mm.sdk.platformtools.ab.i("MicroMsg.ChattingFooterEventImpl", "onEnterMultiTalk, but this group already in multitalk, alter take in or not tips!");
        com.tencent.mm.ui.base.h.d(this.zcV.zJz.getContext(), this.zcV.zJz.getMMResources().getString(2131301711), "", this.zcV.zJz.getMMResources().getString(2131301660), this.zcV.zJz.getMMResources().getString(2131301657), new p.9(this), null);
        AppMethodBeat.o(30672);
        return;
      }
      localIntent.putExtra("chatroomName", getTalkerUserName());
      localIntent.putExtra("key_need_gallery", true);
      localIntent.putExtra("titile", this.zcV.zJz.getMMResources().getString(2131301697));
      com.tencent.mm.bq.d.b(this.zcV.zJz.getContext(), "multitalk", ".ui.MultiTalkSelectContactUI", localIntent);
      AppMethodBeat.o(30672);
      return;
    }
  }
  
  public final void dGw()
  {
    AppMethodBeat.i(30674);
    boolean bool = com.tencent.mm.pluginsdk.permission.b.a(this.zcV.zJz.getContext(), "android.permission.RECORD_AUDIO", 83, "", "");
    com.tencent.mm.sdk.platformtools.ab.i("MicroMsg.ChattingFooterEventImpl", "summerper checkPermission checkmicrophone[%b], stack[%s], activity[%s]", new Object[] { Boolean.valueOf(bool), bo.dtY(), this.zcV.zJz.getContext() });
    if (!bool)
    {
      AppMethodBeat.o(30674);
      return;
    }
    if (this.oBw.doB()) {
      this.oBw.setBottomPanelVisibility(8);
    }
    ux localux = new ux();
    localux.cLs.cut = 5;
    localux.cLs.talker = getTalkerUserName();
    localux.cLs.context = this.zcV.zJz.getContext();
    localux.cLs.cLm = 3;
    com.tencent.mm.sdk.b.a.ymk.l(localux);
    com.tencent.mm.plugin.report.service.h.qsU.e(11033, new Object[] { Integer.valueOf(4), Integer.valueOf(2), Integer.valueOf(0) });
    AppMethodBeat.o(30674);
  }
  
  public final void dGx()
  {
    AppMethodBeat.i(30675);
    boolean bool = com.tencent.mm.pluginsdk.permission.b.a(this.zcV.zJz.getContext(), "android.permission.CAMERA", 21, "", "");
    com.tencent.mm.sdk.platformtools.ab.i("MicroMsg.ChattingFooterEventImpl", "summerper checkPermission checkCamera[%b], stack[%s], activity[%s]", new Object[] { Boolean.valueOf(bool), bo.dtY(), this.zcV.zJz.getContext() });
    if (!bool)
    {
      AppMethodBeat.o(30675);
      return;
    }
    bool = com.tencent.mm.pluginsdk.permission.b.a(this.zcV.zJz.getContext(), "android.permission.RECORD_AUDIO", 21, "", "");
    com.tencent.mm.sdk.platformtools.ab.i("MicroMsg.ChattingFooterEventImpl", "summerper checkPermission checkmicrophone[%b], stack[%s], activity[%s]", new Object[] { Boolean.valueOf(bool), bo.dtY(), this.zcV.zJz.getContext() });
    if (!bool)
    {
      AppMethodBeat.o(30675);
      return;
    }
    if (this.oBw.doB()) {
      this.oBw.setBottomPanelVisibility(8);
    }
    ux localux = new ux();
    localux.cLs.cut = 5;
    localux.cLs.talker = getTalkerUserName();
    localux.cLs.context = this.zcV.zJz.getContext();
    localux.cLs.cLm = 2;
    com.tencent.mm.sdk.b.a.ymk.l(localux);
    AppMethodBeat.o(30675);
  }
  
  public final void dGy()
  {
    AppMethodBeat.i(30678);
    ((af)this.zcV.ay(af.class)).qX(false);
    this.oBw.setBottomPanelVisibility(8);
    AppMethodBeat.o(30678);
  }
  
  public final void dGz()
  {
    AppMethodBeat.i(30679);
    if (!n.a(this.zcV.zJz, e.esr, "microMsg." + System.currentTimeMillis() + ".jpg")) {
      Toast.makeText(this.zcV.zJz.getContext(), this.zcV.zJz.getMMResources().getString(2131303074), 1).show();
    }
    AppMethodBeat.o(30679);
  }
  
  public final String getFileName()
  {
    AppMethodBeat.i(155486);
    if (this.zyI != null)
    {
      String str = this.zyI.getFileName();
      AppMethodBeat.o(155486);
      return str;
    }
    AppMethodBeat.o(155486);
    return "";
  }
  
  public final String getTalkerUserName()
  {
    AppMethodBeat.i(30665);
    if ((this.contact != null) && (com.tencent.mm.storage.ad.nM(this.contact.field_username)))
    {
      str = this.zyJ;
      AppMethodBeat.o(30665);
      return str;
    }
    if (this.contact == null)
    {
      AppMethodBeat.o(30665);
      return null;
    }
    String str = this.contact.field_username;
    AppMethodBeat.o(30665);
    return str;
  }
  
  public final void jj(boolean paramBoolean)
  {
    AppMethodBeat.i(30670);
    if (paramBoolean)
    {
      ((com.tencent.mm.ui.chatting.c.b.ab)this.zcV.ay(com.tencent.mm.ui.chatting.c.b.ab.class)).keepSignalling();
      AppMethodBeat.o(30670);
      return;
    }
    ((com.tencent.mm.ui.chatting.c.b.ab)this.zcV.ay(com.tencent.mm.ui.chatting.c.b.ab.class)).stopSignalling();
    AppMethodBeat.o(30670);
  }
  
  public final void onPause()
  {
    AppMethodBeat.i(30667);
    if (this.zyL != null)
    {
      com.tencent.mm.sdk.platformtools.ab.i("MicroMsg.ChattingFooterEventImpl", "release");
      this.zyL.release();
      this.zyL = null;
    }
    com.tencent.mm.cj.a.a locala = com.tencent.mm.cj.a.yTb;
    if (!com.tencent.mm.cj.a.a.atj(this.zyI.getFileName())) {
      dGs();
    }
    this.gcG.stopTimer();
    this.mwY.stopTimer();
    AppMethodBeat.o(30667);
  }
  
  public final void release()
  {
    AppMethodBeat.i(30666);
    if (this.zyL != null)
    {
      com.tencent.mm.sdk.platformtools.ab.i("MicroMsg.ChattingFooterEventImpl", "release");
      this.zyL.release();
      this.zyL = null;
    }
    AppMethodBeat.o(30666);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.p
 * JD-Core Version:    0.7.0.1
 */