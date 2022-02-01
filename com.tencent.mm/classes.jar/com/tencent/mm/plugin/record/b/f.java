package com.tencent.mm.plugin.record.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.aj.k.b;
import com.tencent.mm.an.d.a;
import com.tencent.mm.an.d.b;
import com.tencent.mm.an.d.c;
import com.tencent.mm.an.j;
import com.tencent.mm.an.q.b;
import com.tencent.mm.f.b.a.ac;
import com.tencent.mm.f.b.a.ae;
import com.tencent.mm.f.c.et;
import com.tencent.mm.i.g.a;
import com.tencent.mm.model.ab;
import com.tencent.mm.model.bq;
import com.tencent.mm.model.cm;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.plugin.messenger.foundation.a.a.i.c;
import com.tencent.mm.plugin.messenger.foundation.a.n;
import com.tencent.mm.protocal.protobuf.aie;
import com.tencent.mm.protocal.protobuf.aif;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ca;
import com.tencent.mm.vfs.u;
import java.io.ByteArrayOutputStream;

public final class f
  extends com.tencent.mm.an.q
  implements m
{
  private static a HCB = null;
  public long HCC;
  private int HCD;
  private String HCE;
  private boolean HCF;
  private boolean HCG;
  private boolean HCH;
  private com.tencent.mm.pluginsdk.model.app.c HCz;
  private com.tencent.mm.an.i callback;
  private ca fNz;
  public j lPi;
  private String lPn;
  private g.a lPx;
  private String mediaId;
  public long msgId;
  private long rPF;
  public int retCode;
  private com.tencent.mm.an.d rr;
  private long startTime;
  private int type;
  public boolean uii;
  
  public f(long paramLong1, long paramLong2, j paramj)
  {
    AppMethodBeat.i(9475);
    this.HCz = null;
    this.HCC = -1L;
    this.mediaId = "";
    this.msgId = 0L;
    this.fNz = null;
    this.lPn = "";
    this.startTime = 0L;
    this.HCD = -1;
    this.HCE = "";
    this.type = 0;
    this.retCode = 0;
    this.HCF = false;
    this.HCG = false;
    this.rPF = 0L;
    this.uii = false;
    this.HCH = false;
    this.lPx = new g.a()
    {
      public final int a(String paramAnonymousString, final int paramAnonymousInt, com.tencent.mm.i.c paramAnonymousc, final com.tencent.mm.i.d paramAnonymousd, boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(9473);
        if (paramAnonymousc == null) {}
        for (paramAnonymousBoolean = true;; paramAnonymousBoolean = false)
        {
          Log.d("MicroMsg.NetSceneDownloadAppAttach", "summerbig callback mediaId[%s], startRet[%d], progressInfo[%s], sceneResult[%s], finish[%b]", new Object[] { paramAnonymousString, Integer.valueOf(paramAnonymousInt), paramAnonymousc, paramAnonymousd, Boolean.valueOf(paramAnonymousBoolean) });
          if (paramAnonymousInt != -21006) {
            break;
          }
          Log.i("MicroMsg.NetSceneDownloadAppAttach", "summerbig callback cdntra  ERR_CNDCOM_MEDIA_IS_DOWNLOADING clientid:%s", new Object[] { f.a(f.this) });
          AppMethodBeat.o(9473);
          return 0;
        }
        if (paramAnonymousInt != 0)
        {
          a.Pn(f.b(f.this).systemRowid);
          new ae(com.tencent.mm.plugin.report.a.t(new Object[] { Integer.valueOf(paramAnonymousInt), Integer.valueOf(2), Long.valueOf(f.c(f.this)), Long.valueOf(Util.nowMilliSecond()), Integer.valueOf(com.tencent.mm.aq.c.cV(MMApplicationContext.getContext())), Integer.valueOf(com.tencent.mm.i.a.MediaType_FILE), Integer.valueOf(0), "" })).bpa();
          MMHandlerThread.postToMainThread(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(9465);
              f.a(f.this, 3, paramAnonymousInt, "", f.this);
              AppMethodBeat.o(9465);
            }
          });
          AppMethodBeat.o(9473);
          return 0;
        }
        f.a(f.this, a.p(paramAnonymousString, f.d(f.this)));
        if (f.b(f.this) == null)
        {
          Log.e("MicroMsg.NetSceneDownloadAppAttach", "summerbig attachInfo is null");
          MMHandlerThread.postToMainThread(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(9466);
              f.a(f.this, 3, paramAnonymousInt, "", f.this);
              AppMethodBeat.o(9466);
            }
          });
          AppMethodBeat.o(9473);
          return 0;
        }
        if (f.b(f.this).field_status == 102L)
        {
          Log.i("MicroMsg.NetSceneDownloadAppAttach", "summerbig dancy attach download has paused, status:%d", new Object[] { Long.valueOf(f.b(f.this).field_status) });
          com.tencent.mm.aq.f.bkg().Vy(f.a(f.this));
          MMHandlerThread.postToMainThread(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(9467);
              f.a(f.this, 3, paramAnonymousInt, "attach  has paused, status=" + f.b(f.this).field_status, f.this);
              AppMethodBeat.o(9467);
            }
          });
          AppMethodBeat.o(9473);
          return 0;
        }
        if (paramAnonymousc != null)
        {
          if (paramAnonymousc.field_finishedLength == f.b(f.this).field_totalLen)
          {
            Log.i("MicroMsg.NetSceneDownloadAppAttach", "summerbig callback cdntra ignore progress 100%");
            AppMethodBeat.o(9473);
            return 0;
          }
          if (f.b(f.this).field_offset > paramAnonymousc.field_finishedLength)
          {
            if (f.b(f.this).field_status == 199L)
            {
              com.tencent.mm.aq.f.bkg().Vz(f.a(f.this));
              Log.i("MicroMsg.NetSceneDownloadAppAttach", "summerbig callback  lan has succes, result:%s", new Object[] { Boolean.TRUE });
              AppMethodBeat.o(9473);
              return 0;
            }
            Log.e("MicroMsg.NetSceneDownloadAppAttach", "summerbig callback cdnEndProc error oldpos:%d newpos:%d", new Object[] { Long.valueOf(f.b(f.this).field_offset), Long.valueOf(paramAnonymousc.field_finishedLength) });
            a.Pn(f.b(f.this).systemRowid);
            MMHandlerThread.postToMainThread(new Runnable()
            {
              public final void run()
              {
                AppMethodBeat.i(9468);
                f.a(f.this, 3, paramAnonymousInt, "", f.this);
                AppMethodBeat.o(9468);
              }
            });
            AppMethodBeat.o(9473);
            return 0;
          }
          f.b(f.this).field_offset = paramAnonymousc.field_finishedLength;
          com.tencent.mm.plugin.ab.a.ctZ().a(f.b(f.this), new String[0]);
          if (f.e(f.this) != null) {
            MMHandlerThread.postToMainThread(new Runnable()
            {
              public final void run()
              {
                AppMethodBeat.i(9469);
                if (f.e(f.this) != null) {
                  f.e(f.this).a((int)f.b(f.this).field_offset, (int)f.b(f.this).field_totalLen, f.this);
                }
                AppMethodBeat.o(9469);
              }
            });
          }
          Log.d("MicroMsg.NetSceneDownloadAppAttach", "summerbig callback cdntra progresscallback id:%s finish:%d total:%d", new Object[] { f.a(f.this), Long.valueOf(paramAnonymousc.field_finishedLength), Long.valueOf(paramAnonymousc.field_toltalLength) });
          AppMethodBeat.o(9473);
          return 0;
        }
        if (paramAnonymousd != null)
        {
          if (paramAnonymousd.field_retCode == 0) {
            break label1058;
          }
          a.Pn(f.b(f.this).systemRowid);
          Log.e("MicroMsg.NetSceneDownloadAppAttach", "summerbig callback cdntra sceneResult.retCode :%d", new Object[] { Integer.valueOf(paramAnonymousd.field_retCode) });
          new ae(com.tencent.mm.plugin.report.a.t(new Object[] { Integer.valueOf(paramAnonymousd.field_retCode), Integer.valueOf(2), Long.valueOf(f.c(f.this)), Long.valueOf(Util.nowMilliSecond()), Integer.valueOf(com.tencent.mm.aq.c.cV(MMApplicationContext.getContext())), Integer.valueOf(com.tencent.mm.i.a.MediaType_FILE), Long.valueOf(f.b(f.this).field_totalLen), paramAnonymousd.field_transInfo, "", "", "", "", "", "", "", paramAnonymousd.iUs })).bpa();
          if (paramAnonymousd.field_retCode != 0) {
            new ac(com.tencent.mm.plugin.report.a.t(new Object[] { Integer.valueOf(paramAnonymousd.field_retCode), Integer.valueOf(2), Long.valueOf(f.c(f.this)), Long.valueOf(Util.nowMilliSecond()), Integer.valueOf(com.tencent.mm.aq.c.cV(MMApplicationContext.getContext())), Integer.valueOf(com.tencent.mm.i.a.MediaType_FILE), Long.valueOf(f.b(f.this).field_totalLen), paramAnonymousd.field_transInfo, "", "", "", "", "", "", "", paramAnonymousd.iUs })).bpa();
          }
          if (f.e(f.this) != null) {
            MMHandlerThread.postToMainThread(new Runnable()
            {
              public final void run()
              {
                AppMethodBeat.i(9470);
                if (f.e(f.this) != null) {
                  f.e(f.this).a((int)f.b(f.this).field_offset, (int)f.b(f.this).field_totalLen, f.this);
                }
                AppMethodBeat.o(9470);
              }
            });
          }
          if (paramAnonymousd.field_retCode == 0) {
            break label1350;
          }
          MMHandlerThread.postToMainThread(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(9471);
              f.a(f.this, 3, paramAnonymousd.field_retCode, "", f.this);
              AppMethodBeat.o(9471);
            }
          });
        }
        for (;;)
        {
          AppMethodBeat.o(9473);
          return 0;
          label1058:
          new com.tencent.mm.vfs.q(f.f(f.this)).aj(new com.tencent.mm.vfs.q(f.b(f.this).field_fileFullPath));
          f.b(f.this).field_status = 199L;
          f.b(f.this).field_offset = f.b(f.this).field_totalLen;
          com.tencent.mm.plugin.ab.a.ctZ().a(f.b(f.this), new String[0]);
          com.tencent.mm.plugin.report.service.h.IzE.idkeyStat(198L, 45L, f.b(f.this).field_totalLen, false);
          com.tencent.mm.plugin.report.service.h.IzE.idkeyStat(198L, 46L, 1L, false);
          paramAnonymousc = com.tencent.mm.plugin.report.service.h.IzE;
          if (f.g(f.this) == null)
          {
            paramAnonymousString = "";
            label1198:
            if (!ab.Lj(paramAnonymousString)) {
              break label1305;
            }
          }
          label1305:
          for (long l = 48L;; l = 47L)
          {
            paramAnonymousc.idkeyStat(198L, l, 1L, false);
            paramAnonymousString = ((n)com.tencent.mm.kernel.h.ae(n.class)).eSe().Oq(f.b(f.this).field_msgInfoId);
            if (paramAnonymousString.field_status != 5) {
              break label1313;
            }
            paramAnonymousString.setStatus(3);
            ((n)com.tencent.mm.kernel.h.ae(n.class)).eSe().a(paramAnonymousString.field_msgId, paramAnonymousString);
            break;
            paramAnonymousString = f.g(f.this).field_talker;
            break label1198;
          }
          label1313:
          ((n)com.tencent.mm.kernel.h.ae(n.class)).eSe().a(new i.c(paramAnonymousString.field_talker, "update", paramAnonymousString));
          break;
          label1350:
          MMHandlerThread.postToMainThread(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(9472);
              f.a(f.this, 0, 0, "", f.this);
              AppMethodBeat.o(9472);
            }
          });
        }
      }
      
      public final void a(String paramAnonymousString, ByteArrayOutputStream paramAnonymousByteArrayOutputStream) {}
      
      public final byte[] f(String paramAnonymousString, byte[] paramAnonymousArrayOfByte)
      {
        return null;
      }
    };
    this.rPF = paramLong2;
    this.msgId = paramLong1;
    this.HCz = com.tencent.mm.plugin.ab.a.ctZ().TR(paramLong1);
    this.lPi = paramj;
    this.HCG = true;
    if (this.HCz == null)
    {
      Log.e("MicroMsg.NetSceneDownloadAppAttach", "big appMsg, info is null, msgid = , svrId".concat(String.valueOf(paramLong1)), new Object[] { Long.valueOf(paramLong2) });
      AppMethodBeat.o(9475);
      return;
    }
    paramj = new d.a();
    paramj.lBU = new aie();
    paramj.lBV = new aif();
    paramj.uri = "/cgi-bin/micromsg-bin/downloadappattach";
    paramj.funcId = 221;
    paramj.lBW = 106;
    paramj.respCmdId = 1000000106;
    this.rr = paramj.bgN();
    AppMethodBeat.o(9475);
  }
  
  public f(long paramLong, String paramString, j paramj)
  {
    this(paramString, paramLong, paramj);
    this.msgId = paramLong;
  }
  
  public f(com.tencent.mm.pluginsdk.model.app.c paramc)
  {
    AppMethodBeat.i(9476);
    this.HCz = null;
    this.HCC = -1L;
    this.mediaId = "";
    this.msgId = 0L;
    this.fNz = null;
    this.lPn = "";
    this.startTime = 0L;
    this.HCD = -1;
    this.HCE = "";
    this.type = 0;
    this.retCode = 0;
    this.HCF = false;
    this.HCG = false;
    this.rPF = 0L;
    this.uii = false;
    this.HCH = false;
    this.lPx = new g.a()
    {
      public final int a(String paramAnonymousString, final int paramAnonymousInt, com.tencent.mm.i.c paramAnonymousc, final com.tencent.mm.i.d paramAnonymousd, boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(9473);
        if (paramAnonymousc == null) {}
        for (paramAnonymousBoolean = true;; paramAnonymousBoolean = false)
        {
          Log.d("MicroMsg.NetSceneDownloadAppAttach", "summerbig callback mediaId[%s], startRet[%d], progressInfo[%s], sceneResult[%s], finish[%b]", new Object[] { paramAnonymousString, Integer.valueOf(paramAnonymousInt), paramAnonymousc, paramAnonymousd, Boolean.valueOf(paramAnonymousBoolean) });
          if (paramAnonymousInt != -21006) {
            break;
          }
          Log.i("MicroMsg.NetSceneDownloadAppAttach", "summerbig callback cdntra  ERR_CNDCOM_MEDIA_IS_DOWNLOADING clientid:%s", new Object[] { f.a(f.this) });
          AppMethodBeat.o(9473);
          return 0;
        }
        if (paramAnonymousInt != 0)
        {
          a.Pn(f.b(f.this).systemRowid);
          new ae(com.tencent.mm.plugin.report.a.t(new Object[] { Integer.valueOf(paramAnonymousInt), Integer.valueOf(2), Long.valueOf(f.c(f.this)), Long.valueOf(Util.nowMilliSecond()), Integer.valueOf(com.tencent.mm.aq.c.cV(MMApplicationContext.getContext())), Integer.valueOf(com.tencent.mm.i.a.MediaType_FILE), Integer.valueOf(0), "" })).bpa();
          MMHandlerThread.postToMainThread(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(9465);
              f.a(f.this, 3, paramAnonymousInt, "", f.this);
              AppMethodBeat.o(9465);
            }
          });
          AppMethodBeat.o(9473);
          return 0;
        }
        f.a(f.this, a.p(paramAnonymousString, f.d(f.this)));
        if (f.b(f.this) == null)
        {
          Log.e("MicroMsg.NetSceneDownloadAppAttach", "summerbig attachInfo is null");
          MMHandlerThread.postToMainThread(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(9466);
              f.a(f.this, 3, paramAnonymousInt, "", f.this);
              AppMethodBeat.o(9466);
            }
          });
          AppMethodBeat.o(9473);
          return 0;
        }
        if (f.b(f.this).field_status == 102L)
        {
          Log.i("MicroMsg.NetSceneDownloadAppAttach", "summerbig dancy attach download has paused, status:%d", new Object[] { Long.valueOf(f.b(f.this).field_status) });
          com.tencent.mm.aq.f.bkg().Vy(f.a(f.this));
          MMHandlerThread.postToMainThread(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(9467);
              f.a(f.this, 3, paramAnonymousInt, "attach  has paused, status=" + f.b(f.this).field_status, f.this);
              AppMethodBeat.o(9467);
            }
          });
          AppMethodBeat.o(9473);
          return 0;
        }
        if (paramAnonymousc != null)
        {
          if (paramAnonymousc.field_finishedLength == f.b(f.this).field_totalLen)
          {
            Log.i("MicroMsg.NetSceneDownloadAppAttach", "summerbig callback cdntra ignore progress 100%");
            AppMethodBeat.o(9473);
            return 0;
          }
          if (f.b(f.this).field_offset > paramAnonymousc.field_finishedLength)
          {
            if (f.b(f.this).field_status == 199L)
            {
              com.tencent.mm.aq.f.bkg().Vz(f.a(f.this));
              Log.i("MicroMsg.NetSceneDownloadAppAttach", "summerbig callback  lan has succes, result:%s", new Object[] { Boolean.TRUE });
              AppMethodBeat.o(9473);
              return 0;
            }
            Log.e("MicroMsg.NetSceneDownloadAppAttach", "summerbig callback cdnEndProc error oldpos:%d newpos:%d", new Object[] { Long.valueOf(f.b(f.this).field_offset), Long.valueOf(paramAnonymousc.field_finishedLength) });
            a.Pn(f.b(f.this).systemRowid);
            MMHandlerThread.postToMainThread(new Runnable()
            {
              public final void run()
              {
                AppMethodBeat.i(9468);
                f.a(f.this, 3, paramAnonymousInt, "", f.this);
                AppMethodBeat.o(9468);
              }
            });
            AppMethodBeat.o(9473);
            return 0;
          }
          f.b(f.this).field_offset = paramAnonymousc.field_finishedLength;
          com.tencent.mm.plugin.ab.a.ctZ().a(f.b(f.this), new String[0]);
          if (f.e(f.this) != null) {
            MMHandlerThread.postToMainThread(new Runnable()
            {
              public final void run()
              {
                AppMethodBeat.i(9469);
                if (f.e(f.this) != null) {
                  f.e(f.this).a((int)f.b(f.this).field_offset, (int)f.b(f.this).field_totalLen, f.this);
                }
                AppMethodBeat.o(9469);
              }
            });
          }
          Log.d("MicroMsg.NetSceneDownloadAppAttach", "summerbig callback cdntra progresscallback id:%s finish:%d total:%d", new Object[] { f.a(f.this), Long.valueOf(paramAnonymousc.field_finishedLength), Long.valueOf(paramAnonymousc.field_toltalLength) });
          AppMethodBeat.o(9473);
          return 0;
        }
        if (paramAnonymousd != null)
        {
          if (paramAnonymousd.field_retCode == 0) {
            break label1058;
          }
          a.Pn(f.b(f.this).systemRowid);
          Log.e("MicroMsg.NetSceneDownloadAppAttach", "summerbig callback cdntra sceneResult.retCode :%d", new Object[] { Integer.valueOf(paramAnonymousd.field_retCode) });
          new ae(com.tencent.mm.plugin.report.a.t(new Object[] { Integer.valueOf(paramAnonymousd.field_retCode), Integer.valueOf(2), Long.valueOf(f.c(f.this)), Long.valueOf(Util.nowMilliSecond()), Integer.valueOf(com.tencent.mm.aq.c.cV(MMApplicationContext.getContext())), Integer.valueOf(com.tencent.mm.i.a.MediaType_FILE), Long.valueOf(f.b(f.this).field_totalLen), paramAnonymousd.field_transInfo, "", "", "", "", "", "", "", paramAnonymousd.iUs })).bpa();
          if (paramAnonymousd.field_retCode != 0) {
            new ac(com.tencent.mm.plugin.report.a.t(new Object[] { Integer.valueOf(paramAnonymousd.field_retCode), Integer.valueOf(2), Long.valueOf(f.c(f.this)), Long.valueOf(Util.nowMilliSecond()), Integer.valueOf(com.tencent.mm.aq.c.cV(MMApplicationContext.getContext())), Integer.valueOf(com.tencent.mm.i.a.MediaType_FILE), Long.valueOf(f.b(f.this).field_totalLen), paramAnonymousd.field_transInfo, "", "", "", "", "", "", "", paramAnonymousd.iUs })).bpa();
          }
          if (f.e(f.this) != null) {
            MMHandlerThread.postToMainThread(new Runnable()
            {
              public final void run()
              {
                AppMethodBeat.i(9470);
                if (f.e(f.this) != null) {
                  f.e(f.this).a((int)f.b(f.this).field_offset, (int)f.b(f.this).field_totalLen, f.this);
                }
                AppMethodBeat.o(9470);
              }
            });
          }
          if (paramAnonymousd.field_retCode == 0) {
            break label1350;
          }
          MMHandlerThread.postToMainThread(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(9471);
              f.a(f.this, 3, paramAnonymousd.field_retCode, "", f.this);
              AppMethodBeat.o(9471);
            }
          });
        }
        for (;;)
        {
          AppMethodBeat.o(9473);
          return 0;
          label1058:
          new com.tencent.mm.vfs.q(f.f(f.this)).aj(new com.tencent.mm.vfs.q(f.b(f.this).field_fileFullPath));
          f.b(f.this).field_status = 199L;
          f.b(f.this).field_offset = f.b(f.this).field_totalLen;
          com.tencent.mm.plugin.ab.a.ctZ().a(f.b(f.this), new String[0]);
          com.tencent.mm.plugin.report.service.h.IzE.idkeyStat(198L, 45L, f.b(f.this).field_totalLen, false);
          com.tencent.mm.plugin.report.service.h.IzE.idkeyStat(198L, 46L, 1L, false);
          paramAnonymousc = com.tencent.mm.plugin.report.service.h.IzE;
          if (f.g(f.this) == null)
          {
            paramAnonymousString = "";
            label1198:
            if (!ab.Lj(paramAnonymousString)) {
              break label1305;
            }
          }
          label1305:
          for (long l = 48L;; l = 47L)
          {
            paramAnonymousc.idkeyStat(198L, l, 1L, false);
            paramAnonymousString = ((n)com.tencent.mm.kernel.h.ae(n.class)).eSe().Oq(f.b(f.this).field_msgInfoId);
            if (paramAnonymousString.field_status != 5) {
              break label1313;
            }
            paramAnonymousString.setStatus(3);
            ((n)com.tencent.mm.kernel.h.ae(n.class)).eSe().a(paramAnonymousString.field_msgId, paramAnonymousString);
            break;
            paramAnonymousString = f.g(f.this).field_talker;
            break label1198;
          }
          label1313:
          ((n)com.tencent.mm.kernel.h.ae(n.class)).eSe().a(new i.c(paramAnonymousString.field_talker, "update", paramAnonymousString));
          break;
          label1350:
          MMHandlerThread.postToMainThread(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(9472);
              f.a(f.this, 0, 0, "", f.this);
              AppMethodBeat.o(9472);
            }
          });
        }
      }
      
      public final void a(String paramAnonymousString, ByteArrayOutputStream paramAnonymousByteArrayOutputStream) {}
      
      public final byte[] f(String paramAnonymousString, byte[] paramAnonymousArrayOfByte)
      {
        return null;
      }
    };
    this.HCz = paramc;
    this.HCF = true;
    this.mediaId = this.HCz.field_mediaId;
    this.lPi = null;
    this.type = 0;
    if (paramc == null)
    {
      Log.e("MicroMsg.NetSceneDownloadAppAttach", "summerbig <init>, info is null, mediaId = " + this.mediaId);
      AppMethodBeat.o(9476);
      return;
    }
    d.a locala = new d.a();
    locala.lBU = new aie();
    locala.lBV = new aif();
    locala.uri = "/cgi-bin/micromsg-bin/downloadappattach";
    locala.funcId = 221;
    locala.lBW = 106;
    locala.respCmdId = 1000000106;
    this.rr = locala.bgN();
    Log.i("MicroMsg.NetSceneDownloadAppAttach", "summerbig NetSceneDownloadAppAttach info fullpath[%s], justSaveFile[%b], stack[%s]", new Object[] { paramc.field_fileFullPath, Boolean.TRUE, Util.getStack() });
    AppMethodBeat.o(9476);
  }
  
  public f(String paramString)
  {
    this(paramString, 0L, null);
  }
  
  private f(String paramString, long paramLong, j paramj)
  {
    AppMethodBeat.i(9477);
    this.HCz = null;
    this.HCC = -1L;
    this.mediaId = "";
    this.msgId = 0L;
    this.fNz = null;
    this.lPn = "";
    this.startTime = 0L;
    this.HCD = -1;
    this.HCE = "";
    this.type = 0;
    this.retCode = 0;
    this.HCF = false;
    this.HCG = false;
    this.rPF = 0L;
    this.uii = false;
    this.HCH = false;
    this.lPx = new g.a()
    {
      public final int a(String paramAnonymousString, final int paramAnonymousInt, com.tencent.mm.i.c paramAnonymousc, final com.tencent.mm.i.d paramAnonymousd, boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(9473);
        if (paramAnonymousc == null) {}
        for (paramAnonymousBoolean = true;; paramAnonymousBoolean = false)
        {
          Log.d("MicroMsg.NetSceneDownloadAppAttach", "summerbig callback mediaId[%s], startRet[%d], progressInfo[%s], sceneResult[%s], finish[%b]", new Object[] { paramAnonymousString, Integer.valueOf(paramAnonymousInt), paramAnonymousc, paramAnonymousd, Boolean.valueOf(paramAnonymousBoolean) });
          if (paramAnonymousInt != -21006) {
            break;
          }
          Log.i("MicroMsg.NetSceneDownloadAppAttach", "summerbig callback cdntra  ERR_CNDCOM_MEDIA_IS_DOWNLOADING clientid:%s", new Object[] { f.a(f.this) });
          AppMethodBeat.o(9473);
          return 0;
        }
        if (paramAnonymousInt != 0)
        {
          a.Pn(f.b(f.this).systemRowid);
          new ae(com.tencent.mm.plugin.report.a.t(new Object[] { Integer.valueOf(paramAnonymousInt), Integer.valueOf(2), Long.valueOf(f.c(f.this)), Long.valueOf(Util.nowMilliSecond()), Integer.valueOf(com.tencent.mm.aq.c.cV(MMApplicationContext.getContext())), Integer.valueOf(com.tencent.mm.i.a.MediaType_FILE), Integer.valueOf(0), "" })).bpa();
          MMHandlerThread.postToMainThread(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(9465);
              f.a(f.this, 3, paramAnonymousInt, "", f.this);
              AppMethodBeat.o(9465);
            }
          });
          AppMethodBeat.o(9473);
          return 0;
        }
        f.a(f.this, a.p(paramAnonymousString, f.d(f.this)));
        if (f.b(f.this) == null)
        {
          Log.e("MicroMsg.NetSceneDownloadAppAttach", "summerbig attachInfo is null");
          MMHandlerThread.postToMainThread(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(9466);
              f.a(f.this, 3, paramAnonymousInt, "", f.this);
              AppMethodBeat.o(9466);
            }
          });
          AppMethodBeat.o(9473);
          return 0;
        }
        if (f.b(f.this).field_status == 102L)
        {
          Log.i("MicroMsg.NetSceneDownloadAppAttach", "summerbig dancy attach download has paused, status:%d", new Object[] { Long.valueOf(f.b(f.this).field_status) });
          com.tencent.mm.aq.f.bkg().Vy(f.a(f.this));
          MMHandlerThread.postToMainThread(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(9467);
              f.a(f.this, 3, paramAnonymousInt, "attach  has paused, status=" + f.b(f.this).field_status, f.this);
              AppMethodBeat.o(9467);
            }
          });
          AppMethodBeat.o(9473);
          return 0;
        }
        if (paramAnonymousc != null)
        {
          if (paramAnonymousc.field_finishedLength == f.b(f.this).field_totalLen)
          {
            Log.i("MicroMsg.NetSceneDownloadAppAttach", "summerbig callback cdntra ignore progress 100%");
            AppMethodBeat.o(9473);
            return 0;
          }
          if (f.b(f.this).field_offset > paramAnonymousc.field_finishedLength)
          {
            if (f.b(f.this).field_status == 199L)
            {
              com.tencent.mm.aq.f.bkg().Vz(f.a(f.this));
              Log.i("MicroMsg.NetSceneDownloadAppAttach", "summerbig callback  lan has succes, result:%s", new Object[] { Boolean.TRUE });
              AppMethodBeat.o(9473);
              return 0;
            }
            Log.e("MicroMsg.NetSceneDownloadAppAttach", "summerbig callback cdnEndProc error oldpos:%d newpos:%d", new Object[] { Long.valueOf(f.b(f.this).field_offset), Long.valueOf(paramAnonymousc.field_finishedLength) });
            a.Pn(f.b(f.this).systemRowid);
            MMHandlerThread.postToMainThread(new Runnable()
            {
              public final void run()
              {
                AppMethodBeat.i(9468);
                f.a(f.this, 3, paramAnonymousInt, "", f.this);
                AppMethodBeat.o(9468);
              }
            });
            AppMethodBeat.o(9473);
            return 0;
          }
          f.b(f.this).field_offset = paramAnonymousc.field_finishedLength;
          com.tencent.mm.plugin.ab.a.ctZ().a(f.b(f.this), new String[0]);
          if (f.e(f.this) != null) {
            MMHandlerThread.postToMainThread(new Runnable()
            {
              public final void run()
              {
                AppMethodBeat.i(9469);
                if (f.e(f.this) != null) {
                  f.e(f.this).a((int)f.b(f.this).field_offset, (int)f.b(f.this).field_totalLen, f.this);
                }
                AppMethodBeat.o(9469);
              }
            });
          }
          Log.d("MicroMsg.NetSceneDownloadAppAttach", "summerbig callback cdntra progresscallback id:%s finish:%d total:%d", new Object[] { f.a(f.this), Long.valueOf(paramAnonymousc.field_finishedLength), Long.valueOf(paramAnonymousc.field_toltalLength) });
          AppMethodBeat.o(9473);
          return 0;
        }
        if (paramAnonymousd != null)
        {
          if (paramAnonymousd.field_retCode == 0) {
            break label1058;
          }
          a.Pn(f.b(f.this).systemRowid);
          Log.e("MicroMsg.NetSceneDownloadAppAttach", "summerbig callback cdntra sceneResult.retCode :%d", new Object[] { Integer.valueOf(paramAnonymousd.field_retCode) });
          new ae(com.tencent.mm.plugin.report.a.t(new Object[] { Integer.valueOf(paramAnonymousd.field_retCode), Integer.valueOf(2), Long.valueOf(f.c(f.this)), Long.valueOf(Util.nowMilliSecond()), Integer.valueOf(com.tencent.mm.aq.c.cV(MMApplicationContext.getContext())), Integer.valueOf(com.tencent.mm.i.a.MediaType_FILE), Long.valueOf(f.b(f.this).field_totalLen), paramAnonymousd.field_transInfo, "", "", "", "", "", "", "", paramAnonymousd.iUs })).bpa();
          if (paramAnonymousd.field_retCode != 0) {
            new ac(com.tencent.mm.plugin.report.a.t(new Object[] { Integer.valueOf(paramAnonymousd.field_retCode), Integer.valueOf(2), Long.valueOf(f.c(f.this)), Long.valueOf(Util.nowMilliSecond()), Integer.valueOf(com.tencent.mm.aq.c.cV(MMApplicationContext.getContext())), Integer.valueOf(com.tencent.mm.i.a.MediaType_FILE), Long.valueOf(f.b(f.this).field_totalLen), paramAnonymousd.field_transInfo, "", "", "", "", "", "", "", paramAnonymousd.iUs })).bpa();
          }
          if (f.e(f.this) != null) {
            MMHandlerThread.postToMainThread(new Runnable()
            {
              public final void run()
              {
                AppMethodBeat.i(9470);
                if (f.e(f.this) != null) {
                  f.e(f.this).a((int)f.b(f.this).field_offset, (int)f.b(f.this).field_totalLen, f.this);
                }
                AppMethodBeat.o(9470);
              }
            });
          }
          if (paramAnonymousd.field_retCode == 0) {
            break label1350;
          }
          MMHandlerThread.postToMainThread(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(9471);
              f.a(f.this, 3, paramAnonymousd.field_retCode, "", f.this);
              AppMethodBeat.o(9471);
            }
          });
        }
        for (;;)
        {
          AppMethodBeat.o(9473);
          return 0;
          label1058:
          new com.tencent.mm.vfs.q(f.f(f.this)).aj(new com.tencent.mm.vfs.q(f.b(f.this).field_fileFullPath));
          f.b(f.this).field_status = 199L;
          f.b(f.this).field_offset = f.b(f.this).field_totalLen;
          com.tencent.mm.plugin.ab.a.ctZ().a(f.b(f.this), new String[0]);
          com.tencent.mm.plugin.report.service.h.IzE.idkeyStat(198L, 45L, f.b(f.this).field_totalLen, false);
          com.tencent.mm.plugin.report.service.h.IzE.idkeyStat(198L, 46L, 1L, false);
          paramAnonymousc = com.tencent.mm.plugin.report.service.h.IzE;
          if (f.g(f.this) == null)
          {
            paramAnonymousString = "";
            label1198:
            if (!ab.Lj(paramAnonymousString)) {
              break label1305;
            }
          }
          label1305:
          for (long l = 48L;; l = 47L)
          {
            paramAnonymousc.idkeyStat(198L, l, 1L, false);
            paramAnonymousString = ((n)com.tencent.mm.kernel.h.ae(n.class)).eSe().Oq(f.b(f.this).field_msgInfoId);
            if (paramAnonymousString.field_status != 5) {
              break label1313;
            }
            paramAnonymousString.setStatus(3);
            ((n)com.tencent.mm.kernel.h.ae(n.class)).eSe().a(paramAnonymousString.field_msgId, paramAnonymousString);
            break;
            paramAnonymousString = f.g(f.this).field_talker;
            break label1198;
          }
          label1313:
          ((n)com.tencent.mm.kernel.h.ae(n.class)).eSe().a(new i.c(paramAnonymousString.field_talker, "update", paramAnonymousString));
          break;
          label1350:
          MMHandlerThread.postToMainThread(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(9472);
              f.a(f.this, 0, 0, "", f.this);
              AppMethodBeat.o(9472);
            }
          });
        }
      }
      
      public final void a(String paramAnonymousString, ByteArrayOutputStream paramAnonymousByteArrayOutputStream) {}
      
      public final byte[] f(String paramAnonymousString, byte[] paramAnonymousArrayOfByte)
      {
        return null;
      }
    };
    this.mediaId = paramString;
    this.msgId = paramLong;
    this.lPi = paramj;
    this.type = 0;
    this.HCz = com.tencent.mm.plugin.ab.a.ctZ().bpR(paramString);
    if (this.HCz == null) {
      this.HCz = com.tencent.mm.plugin.ab.a.ctZ().TR(paramLong);
    }
    if (this.HCz == null)
    {
      Log.e("MicroMsg.NetSceneDownloadAppAttach", "summerbig <init>, info is null, mediaId = ".concat(String.valueOf(paramString)));
      AppMethodBeat.o(9477);
      return;
    }
    paramString = new d.a();
    paramString.lBU = new aie();
    paramString.lBV = new aif();
    paramString.uri = "/cgi-bin/micromsg-bin/downloadappattach";
    paramString.funcId = 221;
    paramString.lBW = 106;
    paramString.respCmdId = 1000000106;
    this.rr = paramString.bgN();
    Log.d("MicroMsg.NetSceneDownloadAppAttach", "summerbig NetSceneDownloadAppAttach , type[%d], info fullpath[%s], field_type[%d], signature[%s], stack[%s]", new Object[] { Integer.valueOf(0), this.HCz.field_fileFullPath, Long.valueOf(this.HCz.field_type), this.HCz.field_signature, Util.getStack() });
    AppMethodBeat.o(9477);
  }
  
  public static void a(a parama)
  {
    HCB = parama;
  }
  
  private static void aZ(ca paramca)
  {
    AppMethodBeat.i(210563);
    if (paramca == null)
    {
      AppMethodBeat.o(210563);
      return;
    }
    try
    {
      k.b localb = k.b.OQ(paramca.field_content);
      Object localObject;
      long l1;
      if (localb != null)
      {
        long l2 = paramca.field_msgSvrId;
        localObject = (com.tencent.mm.aj.a.b)localb.ar(com.tencent.mm.aj.a.b.class);
        l1 = l2;
        if (localObject != null)
        {
          l1 = l2;
          if (((com.tencent.mm.aj.a.b)localObject).lqB != 0L) {
            l1 = ((com.tencent.mm.aj.a.b)localObject).lqB;
          }
        }
        localObject = localb.lml;
        if (localb.lmb != 1) {
          break label262;
        }
      }
      label262:
      for (int i = 7;; i = 5)
      {
        paramca = String.format("%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s", new Object[] { localObject, Integer.valueOf(i), Integer.valueOf(localb.llX), Integer.valueOf(0), Long.valueOf((cm.bfD() - paramca.field_createTime) / 1000L), Util.nullAsNil(localb.llY).toLowerCase(), paramca.field_talker, Integer.valueOf(1), "", Long.valueOf(l1), Long.valueOf(paramca.field_createTime), Long.valueOf(cm.bfC()), Integer.valueOf(1) });
        Log.i("MicroMsg.NetSceneDownloadAppAttach", "reportKVStat 14665 %s", new Object[] { paramca });
        com.tencent.mm.plugin.report.service.h.IzE.kvStat(14665, paramca);
        AppMethodBeat.o(210563);
        return;
      }
      return;
    }
    catch (Exception paramca)
    {
      Log.e("MicroMsg.NetSceneDownloadAppAttach", "reportKVStat exception:%s", new Object[] { paramca.getMessage() });
      AppMethodBeat.o(210563);
    }
  }
  
  public static boolean d(ca paramca, String paramString)
  {
    AppMethodBeat.i(210558);
    if (paramca == null)
    {
      Log.i("MicroMsg.NetSceneDownloadAppAttach", "fileLanDownloadFinish msgInfo is null");
      AppMethodBeat.o(210558);
      return false;
    }
    Log.i("MicroMsg.NetSceneDownloadAppAttach", "fileLanDownloadFinish msgId:%s, msgSvrId:%s", new Object[] { Long.valueOf(paramca.field_msgId), Long.valueOf(paramca.field_msgSvrId) });
    com.tencent.mm.pluginsdk.model.app.c localc = com.tencent.mm.plugin.ab.a.ctZ().TR(paramca.field_msgId);
    if (localc == null)
    {
      AppMethodBeat.o(210558);
      return false;
    }
    String str = com.tencent.mm.aq.c.a("downattach", localc.field_createTime, paramca.field_talker, "");
    com.tencent.mm.aq.f.bkg().Vz(str);
    new com.tencent.mm.vfs.q(paramString).aj(new com.tencent.mm.vfs.q(localc.field_fileFullPath));
    localc.field_status = 199L;
    localc.field_offset = localc.field_totalLen;
    boolean bool = com.tencent.mm.plugin.ab.a.ctZ().a(localc, new String[0]);
    Log.i("MicroMsg.NetSceneDownloadAppAttach", "fileLanDownloadFinish mediaId:%s, result:%s, updateRsult:%s", new Object[] { Util.nullAs(str, ""), Boolean.TRUE, Boolean.valueOf(bool) });
    com.tencent.mm.plugin.report.service.h.IzE.idkeyStat(198L, 45L, localc.field_totalLen, false);
    com.tencent.mm.plugin.report.service.h.IzE.idkeyStat(198L, 46L, 1L, false);
    paramString = com.tencent.mm.plugin.report.service.h.IzE;
    long l;
    if (paramca == null)
    {
      paramca = "";
      if (!ab.Lj(paramca)) {
        break label355;
      }
      l = 48L;
      label255:
      paramString.idkeyStat(198L, l, 1L, false);
      paramca = ((n)com.tencent.mm.kernel.h.ae(n.class)).eSe().Oq(localc.field_msgInfoId);
      if ((paramca.field_status != 5) && (paramca.fileStatus == 0)) {
        break label362;
      }
      paramca.setStatus(3);
      paramca.setFileStatus(0);
      ((n)com.tencent.mm.kernel.h.ae(n.class)).eSe().a(paramca.field_msgId, paramca);
    }
    for (;;)
    {
      AppMethodBeat.o(210558);
      return true;
      paramca = paramca.field_talker;
      break;
      label355:
      l = 47L;
      break label255;
      label362:
      ((n)com.tencent.mm.kernel.h.ae(n.class)).eSe().a(new i.c(paramca.field_talker, "update", paramca));
    }
  }
  
  private void h(int paramInt1, int paramInt2, String paramString, com.tencent.mm.an.q paramq)
  {
    AppMethodBeat.i(9482);
    if (this.callback != null)
    {
      this.callback.onSceneEnd(paramInt1, paramInt2, paramString, paramq);
      if (this.HCz != null)
      {
        long l = this.HCz.field_msgInfoId;
        paramString = ((n)com.tencent.mm.kernel.h.ae(n.class)).eSe().Oq(l);
        if ((paramInt1 == 0) && (paramInt2 == 0))
        {
          ((com.tencent.mm.plugin.comm.a.b)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.comm.a.b.class)).a(this.uii, String.valueOf(l), paramString.field_msgSvrId, true);
          if ((paramString.hzJ()) && (this.lPi == null)) {
            aZ(paramString);
          }
          if (HCB != null)
          {
            HCB.ba(paramString);
            AppMethodBeat.o(9482);
          }
        }
        else
        {
          ((com.tencent.mm.plugin.comm.a.b)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.comm.a.b.class)).a(this.uii, String.valueOf(l), paramString.field_msgSvrId, false);
        }
      }
    }
    AppMethodBeat.o(9482);
  }
  
  public final void a(b paramb)
  {
    AppMethodBeat.i(9479);
    if (!this.HCF)
    {
      com.tencent.mm.aq.f.bkg().Vz(this.lPn);
      this.HCz = com.tencent.mm.plugin.ab.a.ctZ().TR(this.msgId);
      if (this.HCz == null)
      {
        Log.i("MicroMsg.NetSceneDownloadAppAttach", "pause get by msgid  %是is null then get by mediaId %s", new Object[] { Long.valueOf(this.msgId), this.mediaId });
        this.HCz = com.tencent.mm.plugin.ab.a.ctZ().bpR(this.mediaId);
      }
    }
    Log.i("MicroMsg.NetSceneDownloadAppAttach", "summerbig pause listener[%s], info[%s], justSaveFile[%b], stack[%s]", new Object[] { paramb, this.HCz, Boolean.valueOf(this.HCF), Util.getStack() });
    if (this.HCz == null)
    {
      AppMethodBeat.o(9479);
      return;
    }
    if ((this.HCz.field_status == 101L) && (paramb != null)) {
      paramb.fus();
    }
    this.HCz.field_status = 102L;
    if (!this.HCF) {
      Log.i("MicroMsg.NetSceneDownloadAppAttach", "pause done %s", new Object[] { Boolean.valueOf(com.tencent.mm.plugin.ab.a.ctZ().a(this.HCz, new String[0])) });
    }
    AppMethodBeat.o(9479);
  }
  
  public final int doScene(com.tencent.mm.network.g paramg, com.tencent.mm.an.i parami)
  {
    AppMethodBeat.i(9480);
    this.callback = parami;
    if (this.HCz == null)
    {
      Log.e("MicroMsg.NetSceneDownloadAppAttach", com.tencent.mm.compatible.util.f.avD() + " get info failed mediaId:" + this.mediaId);
      this.retCode = (-10000 - com.tencent.mm.compatible.util.f.getLine());
      AppMethodBeat.o(9480);
      return -1;
    }
    this.fNz = ((n)com.tencent.mm.kernel.h.ae(n.class)).eSe().Oq(this.msgId);
    if ((this.fNz == null) || (this.fNz.field_msgId != this.msgId))
    {
      Log.e("MicroMsg.NetSceneDownloadAppAttach", com.tencent.mm.compatible.util.f.avD() + " get msginfo failed mediaId:%s  msgId:%d", new Object[] { this.mediaId, Long.valueOf(this.msgId) });
      this.retCode = (-10000 - com.tencent.mm.compatible.util.f.getLine());
      AppMethodBeat.o(9480);
      return -1;
    }
    if (this.startTime == 0L)
    {
      this.startTime = Util.nowMilliSecond();
      this.HCD = ((int)this.HCz.field_offset);
    }
    if (this.rPF != 0L)
    {
      parami = (aie)d.b.b(this.rr.lBR);
      parami.UserName = com.tencent.mm.model.z.bcZ();
      parami.HmZ = ((int)this.HCz.field_totalLen);
      parami.Hna = ((int)this.HCz.field_offset);
      parami.Hnb = 0;
      parami.rWu = 40;
      parami.HlH = this.rPF;
      i = dispatch(paramg, this.rr, this);
      AppMethodBeat.o(9480);
      return i;
    }
    Object localObject = this.fNz.field_content;
    parami = (com.tencent.mm.an.i)localObject;
    if (ab.Lj(this.fNz.field_talker))
    {
      i = bq.RI(this.fNz.field_content);
      parami = (com.tencent.mm.an.i)localObject;
      if (i != -1) {
        parami = (this.fNz.field_content + " ").substring(i + 2).trim();
      }
    }
    parami = k.b.OQ(Util.processXml(parami));
    if (parami == null)
    {
      Log.e("MicroMsg.NetSceneDownloadAppAttach", "summerbig checkUseCdn cdntra parse content xml failed: mediaId:%s", new Object[] { this.mediaId });
      i = 0;
    }
    while (i != 0)
    {
      Log.d("MicroMsg.NetSceneDownloadAppAttach", "cdntra use cdn return -1 for onGYNetEnd mediaid:%s", new Object[] { this.mediaId });
      AppMethodBeat.o(9480);
      return 0;
      Log.i("MicroMsg.NetSceneDownloadAppAttach", "summerbig cdntra checkUseCdn msgid:%d total:%d fullpath:%s fileid:%s aeskey:%s ", new Object[] { Long.valueOf(this.msgId), Long.valueOf(this.HCz.field_totalLen), this.HCz.field_fileFullPath, parami.lml, Util.secPrint(parami.aesKey) });
      if (((Util.isNullOrNil(parami.lml)) && (Util.isNullOrNil(parami.lmc))) || (Util.isNullOrNil(parami.aesKey)))
      {
        Log.w("MicroMsg.NetSceneDownloadAppAttach", "summerbig cdntra checkUseCdn msgId:%d Not use CDN  cdnAttachUrl:%s aes:%s ", new Object[] { Long.valueOf(this.msgId), parami.lml, Util.secPrint(parami.aesKey) });
        i = 0;
      }
      else
      {
        this.lPn = com.tencent.mm.aq.c.a("downattach", this.HCz.field_createTime, this.fNz.field_talker, this.HCC);
        if (Util.isNullOrNil(this.lPn))
        {
          Log.w("MicroMsg.NetSceneDownloadAppAttach", "summerbig cdntra genClientId failed not use cdn rowid:%d", new Object[] { Long.valueOf(this.HCC) });
          i = 0;
        }
        else
        {
          u.bBD(u.bBT(this.HCz.field_fileFullPath));
          this.HCE = (this.HCz.field_fileFullPath + "_tmp");
          localObject = new com.tencent.mm.i.g();
          ((com.tencent.mm.i.g)localObject).taskName = "task_NetSceneDownloadAppAttach";
          ((com.tencent.mm.i.g)localObject).field_mediaId = this.lPn;
          ((com.tencent.mm.i.g)localObject).field_fullpath = this.HCE;
          if ((parami.lmb != 0) || (parami.llX > 26214400))
          {
            i = com.tencent.mm.i.a.iTW;
            label765:
            ((com.tencent.mm.i.g)localObject).field_fileType = i;
            ((com.tencent.mm.i.g)localObject).field_totalLen = ((int)this.HCz.field_totalLen);
            ((com.tencent.mm.i.g)localObject).field_aesKey = parami.aesKey;
            ((com.tencent.mm.i.g)localObject).field_fileId = parami.lml;
            ((com.tencent.mm.i.g)localObject).field_svr_signature = this.HCz.field_signature;
            ((com.tencent.mm.i.g)localObject).field_fake_bigfile_signature_aeskey = this.HCz.field_fakeAeskey;
            ((com.tencent.mm.i.g)localObject).field_fake_bigfile_signature = this.HCz.field_fakeSignature;
            ((com.tencent.mm.i.g)localObject).field_onlycheckexist = false;
            ((com.tencent.mm.i.g)localObject).field_priority = com.tencent.mm.i.a.iTU;
            ((com.tencent.mm.i.g)localObject).iUG = this.lPx;
            if (!ab.Lj(this.fNz.field_talker)) {
              break label1095;
            }
            i = 1;
            label876:
            ((com.tencent.mm.i.g)localObject).field_chattype = i;
            if ((!com.tencent.mm.aq.c.bka()) || ((parami.lmb == 0) && (parami.llX <= 26214400))) {
              break label1100;
            }
          }
          label1095:
          label1100:
          for (boolean bool = true;; bool = false)
          {
            ((com.tencent.mm.i.g)localObject).field_use_multithread = bool;
            if (!Util.isNullOrNil(parami.lmc))
            {
              ((com.tencent.mm.i.g)localObject).field_fileType = 19;
              ((com.tencent.mm.i.g)localObject).field_authKey = parami.lmi;
              ((com.tencent.mm.i.g)localObject).iUJ = parami.lmc;
              ((com.tencent.mm.i.g)localObject).field_fileId = "";
            }
            Log.i("MicroMsg.NetSceneDownloadAppAttach", "summerbig checkUseCdn addRecvTask taskInfo field_use_multithread[%s], field_fileType[%d], fileFullPath[%s], aeskey[%s], signature[%s], faeskey[%s], fsignature[%s], onlycheckexist[%s]", new Object[] { Boolean.valueOf(((com.tencent.mm.i.g)localObject).field_use_multithread), Integer.valueOf(((com.tencent.mm.i.g)localObject).field_fileType), ((com.tencent.mm.i.g)localObject).field_fullpath, Util.secPrint(((com.tencent.mm.i.g)localObject).field_aesKey), Util.secPrint(((com.tencent.mm.i.g)localObject).field_svr_signature), Util.secPrint(((com.tencent.mm.i.g)localObject).field_fake_bigfile_signature_aeskey), Util.secPrint(((com.tencent.mm.i.g)localObject).field_fake_bigfile_signature), Boolean.valueOf(((com.tencent.mm.i.g)localObject).field_onlycheckexist) });
            if (com.tencent.mm.aq.f.bkg().b((com.tencent.mm.i.g)localObject, -1)) {
              break label1106;
            }
            Log.e("MicroMsg.NetSceneDownloadAppAttach", "summerbig cdntra addSendTask failed.");
            this.lPn = "";
            i = 0;
            break;
            i = com.tencent.mm.i.a.MediaType_FILE;
            break label765;
            i = 0;
            break label876;
          }
          label1106:
          if (this.HCz.field_isUseCdn != 1)
          {
            this.HCz.field_isUseCdn = 1;
            bool = com.tencent.mm.plugin.ab.a.ctZ().a(this.HCz, new String[0]);
            if (!bool)
            {
              Log.e("MicroMsg.NetSceneDownloadAppAttach", "summerbig checkUseCdn update info ret:".concat(String.valueOf(bool)));
              this.retCode = (-10000 - com.tencent.mm.compatible.util.f.getLine());
              h(3, -1, "", this);
              i = 0;
              continue;
            }
          }
          i = 1;
        }
      }
    }
    if (this.HCz.field_status == 102L)
    {
      this.HCz.field_status = 101L;
      if (!this.HCF) {
        com.tencent.mm.plugin.ab.a.ctZ().a(this.HCz, new String[0]);
      }
    }
    this.HCC = this.HCz.systemRowid;
    if ((Util.isNullOrNil(this.HCz.field_mediaSvrId)) && (this.rPF == 0L))
    {
      Log.e("MicroMsg.NetSceneDownloadAppAttach", "checkArgs : mediaId is null");
      this.retCode = (-10000 - com.tencent.mm.compatible.util.f.getLine());
      AppMethodBeat.o(9480);
      return -1;
    }
    if ((this.HCz.field_totalLen <= 0L) || (this.HCz.field_totalLen > 26214400L))
    {
      Log.e("MicroMsg.NetSceneDownloadAppAttach", "checkArgs : totalLen is invalid, totalLen = " + this.HCz.field_totalLen);
      this.retCode = (-10000 - com.tencent.mm.compatible.util.f.getLine());
      AppMethodBeat.o(9480);
      return -1;
    }
    if ((Util.isNullOrNil(this.HCz.field_fileFullPath)) && (this.rPF == 0L))
    {
      Log.e("MicroMsg.NetSceneDownloadAppAttach", "checkArgs : fileFullPath is null");
      this.retCode = (-10000 - com.tencent.mm.compatible.util.f.getLine());
      AppMethodBeat.o(9480);
      return -1;
    }
    int j = (int)u.bBQ(this.HCz.field_fileFullPath);
    int i = j;
    if (this.HCH)
    {
      i = j - 6;
      if (i <= 0) {
        break label1523;
      }
    }
    while (i != this.HCz.field_offset)
    {
      Log.e("MicroMsg.NetSceneDownloadAppAttach", "checkArgs : fileFullPath is invalid, fileLength = " + i + ", info.field_offset = " + this.HCz.field_offset);
      this.retCode = (-10000 - com.tencent.mm.compatible.util.f.getLine());
      AppMethodBeat.o(9480);
      return -1;
      label1523:
      i = 0;
    }
    Log.i("MicroMsg.NetSceneDownloadAppAttach", "downing attach by non cdn, appId: %s,  mediaId: %s, sdkVer: %d", new Object[] { this.HCz.field_appId, this.HCz.field_mediaSvrId, Long.valueOf(this.HCz.field_sdkVer) });
    parami = (aie)d.b.b(this.rr.lBR);
    parami.lVG = this.HCz.field_appId;
    parami.lVJ = this.HCz.field_mediaSvrId;
    parami.RJP = ((int)this.HCz.field_sdkVer);
    parami.UserName = com.tencent.mm.model.z.bcZ();
    parami.HmZ = ((int)this.HCz.field_totalLen);
    parami.Hna = ((int)this.HCz.field_offset);
    parami.Hnb = 0;
    if (this.rPF != 0L) {
      parami.HlH = this.rPF;
    }
    if (this.type != 0) {}
    for (parami.rWu = this.type;; parami.rWu = ((int)this.HCz.field_type))
    {
      i = dispatch(paramg, this.rr, this);
      AppMethodBeat.o(9480);
      return i;
    }
  }
  
  public final void fur()
  {
    AppMethodBeat.i(9478);
    this.HCH = true;
    if (this.HCH) {
      u.F(this.HCz.field_fileFullPath, "#!AMR\n".getBytes());
    }
    AppMethodBeat.o(9478);
  }
  
  public final String getMediaId()
  {
    if (this.HCz == null) {
      return "";
    }
    return this.HCz.field_mediaSvrId;
  }
  
  public final int getType()
  {
    return 221;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, s params, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(9481);
    Log.d("MicroMsg.NetSceneDownloadAppAttach", "onGYNetEnd : errType = " + paramInt2 + ", errCode = " + paramInt3);
    if ((paramInt2 == 3) && (paramInt3 == -1) && (!Util.isNullOrNil(this.lPn)))
    {
      Log.w("MicroMsg.NetSceneDownloadAppAttach", "cdntra using cdn trans,  wait cdn service callback! clientid:%s", new Object[] { this.lPn });
      AppMethodBeat.o(9481);
      return;
    }
    if ((paramInt2 != 0) || (paramInt3 != 0))
    {
      Log.e("MicroMsg.NetSceneDownloadAppAttach", "onGYNetEnd : errType = " + paramInt2 + ", errCode = " + paramInt3);
      this.retCode = (-10000 - com.tencent.mm.compatible.util.f.getLine());
      if (paramInt2 == 4) {
        com.tencent.mm.plugin.report.service.h.IzE.a(10420, new Object[] { Integer.valueOf(paramInt3), Integer.valueOf(2), Long.valueOf(this.startTime), Long.valueOf(Util.nowMilliSecond()), Integer.valueOf(com.tencent.mm.aq.c.cV(MMApplicationContext.getContext())), Integer.valueOf(com.tencent.mm.i.a.MediaType_FILE), Integer.valueOf(0) });
      }
      h(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(9481);
      return;
    }
    paramString = (aif)d.c.b(((com.tencent.mm.an.d)params).lBS);
    this.HCz.field_totalLen = paramString.HmZ;
    if ((paramString.lVJ != null) && (!paramString.lVJ.equals(this.HCz.field_mediaSvrId)))
    {
      Log.e("MicroMsg.NetSceneDownloadAppAttach", "argument is not consistent");
      this.retCode = (-10000 - com.tencent.mm.compatible.util.f.getLine());
      h(3, -1, "", this);
      AppMethodBeat.o(9481);
      return;
    }
    if (paramString.Hna != this.HCz.field_offset)
    {
      Log.e("MicroMsg.NetSceneDownloadAppAttach", "startPos, totalLen is incorrect startpos:" + paramString.Hna);
      this.retCode = (-10000 - com.tencent.mm.compatible.util.f.getLine());
      h(3, -1, "", this);
      AppMethodBeat.o(9481);
      return;
    }
    if (paramString.Hnb + this.HCz.field_offset > this.HCz.field_totalLen)
    {
      Log.e("MicroMsg.NetSceneDownloadAppAttach", "data buffer is incorrect datalen:" + paramString.Hnb + " off:" + this.HCz.field_offset + " total?:" + this.HCz.field_totalLen);
      this.retCode = (-10000 - com.tencent.mm.compatible.util.f.getLine());
      h(3, -1, "", this);
      AppMethodBeat.o(9481);
      return;
    }
    paramArrayOfByte = com.tencent.mm.platformtools.z.a(paramString.Hnc);
    if ((paramArrayOfByte == null) || (paramArrayOfByte.length == 0) || (paramArrayOfByte.length != paramString.Hnb))
    {
      Log.e("MicroMsg.NetSceneDownloadAppAttach", "data buffer is incorrect");
      this.retCode = (-10000 - com.tencent.mm.compatible.util.f.getLine());
      h(3, -1, "", this);
      AppMethodBeat.o(9481);
      return;
    }
    if (a.p(this.mediaId, this.msgId) == null)
    {
      Log.e("MicroMsg.NetSceneDownloadAppAttach", "append to file failed, msg maybe revoked or deleted. msgId:%d", new Object[] { Long.valueOf(this.HCz.field_msgInfoId) });
      this.retCode = (-10000 - com.tencent.mm.compatible.util.f.getLine());
      h(3, -1, "", this);
      AppMethodBeat.o(9481);
      return;
    }
    params = new String(paramArrayOfByte);
    Log.d("MicroMsg.NetSceneDownloadAppAttach", "dancy download big appmsg : %s", new Object[] { Boolean.valueOf(this.HCG) });
    ca localca;
    StringBuffer localStringBuffer;
    if ((this.HCz.field_offset < this.HCz.field_totalLen) && (this.HCG))
    {
      localca = ((n)com.tencent.mm.kernel.h.ae(n.class)).eSe().Oq(this.HCz.field_msgInfoId);
      paramString = params;
      if (params.startsWith("<?xml version="))
      {
        paramInt1 = params.indexOf("<appmsg");
        Log.i("MicroMsg.NetSceneDownloadAppAttach", "inclued: <?xml version=  index:%s", new Object[] { Integer.valueOf(paramInt1) });
        paramString = params;
        if (paramInt1 > 0) {
          paramString = params.substring(paramInt1);
        }
      }
      if (!paramString.startsWith("<appmsg")) {
        break label1174;
      }
      if (!ab.Lj(localca.field_talker)) {
        break label1162;
      }
      if (!Util.isNullOrNil(localca.field_content))
      {
        params = localca.field_content.split("\n", 2)[0];
        localStringBuffer = new StringBuffer();
        this.HCz.field_fullXml = (params + "\n");
        params = new StringBuffer();
        params.append(this.HCz.field_fullXml).append(paramString);
        this.HCz.field_fullXml = params.toString();
      }
      if ((paramString.endsWith("</appmsg>")) || (this.HCz.field_offset + paramArrayOfByte.length == this.HCz.field_totalLen))
      {
        if (!ab.Lj(localca.field_talker)) {
          break label1235;
        }
        params = localca.field_content.split("\n", 2);
        Object localObject = params[0];
        localStringBuffer = new StringBuffer();
        localObject = localStringBuffer.append((String)localObject).append("\n<msg>");
        if (params.length <= 1) {
          break label1228;
        }
        params = params[1];
        label1002:
        ((StringBuffer)localObject).append(params).append(paramString).append("</msg>");
      }
    }
    for (this.HCz.field_fullXml = localStringBuffer.toString();; this.HCz.field_fullXml = params.toString())
    {
      localca.setContent(this.HCz.field_fullXml);
      ((n)com.tencent.mm.kernel.h.ae(n.class)).eSe().a(this.HCz.field_msgInfoId, localca);
      Log.d("MicroMsg.NetSceneDownloadAppAttach", "dancy download full xml succed! xml: [%s]", new Object[] { paramString });
      paramInt1 = u.F(this.HCz.field_fileFullPath, paramArrayOfByte);
      if ((Util.isNullOrNil(this.HCz.field_fileFullPath)) || (paramInt1 == 0)) {
        break label1284;
      }
      Log.e("MicroMsg.NetSceneDownloadAppAttach", "append to file failed:".concat(String.valueOf(paramInt1)));
      this.retCode = (-10000 - com.tencent.mm.compatible.util.f.getLine());
      h(3, -1, "", this);
      AppMethodBeat.o(9481);
      return;
      label1162:
      this.HCz.field_fullXml = paramString;
      break;
      label1174:
      if (localca.field_content.startsWith("<msg>")) {
        break;
      }
      params = new StringBuffer();
      params.append(localca.field_content).append(paramString);
      this.HCz.field_fullXml = params.toString();
      break;
      label1228:
      params = "";
      break label1002;
      label1235:
      params = new StringBuffer();
      params.append("<msg>").append(this.HCz.field_fullXml).append("</msg>");
    }
    label1284:
    paramString = this.HCz;
    long l = paramString.field_offset;
    paramString.field_offset = (paramArrayOfByte.length + l);
    if (this.HCz.field_offset == this.HCz.field_totalLen) {
      this.HCz.field_status = 199L;
    }
    if (this.lPi != null) {
      MMHandlerThread.postToMainThread(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(9474);
          if (f.e(f.this) != null) {
            f.e(f.this).a((int)f.b(f.this).field_offset, (int)f.b(f.this).field_totalLen, f.this);
          }
          AppMethodBeat.o(9474);
        }
      });
    }
    if (this.HCF) {}
    for (boolean bool = true; !bool; bool = com.tencent.mm.plugin.ab.a.ctZ().a(this.HCz, new String[0]))
    {
      Log.e("MicroMsg.NetSceneDownloadAppAttach", "onGYNetEnd update info ret:".concat(String.valueOf(paramInt1)));
      this.retCode = (-10000 - com.tencent.mm.compatible.util.f.getLine());
      h(3, -1, "", this);
      AppMethodBeat.o(9481);
      return;
    }
    if (this.HCz.field_status == 199L)
    {
      com.tencent.mm.plugin.report.service.h.IzE.a(10420, new Object[] { Integer.valueOf(0), Integer.valueOf(2), Long.valueOf(this.startTime), Long.valueOf(Util.nowMilliSecond()), Integer.valueOf(com.tencent.mm.aq.c.cV(MMApplicationContext.getContext())), Integer.valueOf(com.tencent.mm.i.a.MediaType_FILE), Long.valueOf(this.HCz.field_totalLen - this.HCD) });
      paramString = ((n)com.tencent.mm.kernel.h.ae(n.class)).eSe().Oq(this.HCz.field_msgInfoId);
      ((n)com.tencent.mm.kernel.h.ae(n.class)).eSe().a(new i.c(paramString.field_talker, "update", paramString));
      h(0, 0, "", this);
      AppMethodBeat.o(9481);
      return;
    }
    if (this.HCz.field_status == 102L)
    {
      h(3, -1, "", this);
      this.retCode = -20102;
      AppMethodBeat.o(9481);
      return;
    }
    if (doScene(dispatcher(), this.callback) < 0)
    {
      Log.e("MicroMsg.NetSceneDownloadAppAttach", "onGYNetEnd : doScene fail");
      h(3, -1, "", this);
    }
    AppMethodBeat.o(9481);
  }
  
  public final int securityLimitCount()
  {
    return 400;
  }
  
  public final q.b securityVerificationChecked(s params)
  {
    return q.b.lCx;
  }
  
  public static abstract interface a
  {
    public abstract void ba(ca paramca);
  }
  
  public static abstract interface b
  {
    public abstract void fus();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.record.b.f
 * JD-Core Version:    0.7.0.1
 */