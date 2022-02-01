package com.tencent.mm.plugin.record.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ah.k.b;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.b.b;
import com.tencent.mm.ak.b.c;
import com.tencent.mm.ak.n;
import com.tencent.mm.ak.n.b;
import com.tencent.mm.g.b.a.h;
import com.tencent.mm.g.b.a.j;
import com.tencent.mm.g.c.ei;
import com.tencent.mm.i.g.a;
import com.tencent.mm.model.bl;
import com.tencent.mm.model.v;
import com.tencent.mm.model.x;
import com.tencent.mm.network.e;
import com.tencent.mm.network.q;
import com.tencent.mm.platformtools.z;
import com.tencent.mm.plugin.messenger.foundation.a.a.i;
import com.tencent.mm.plugin.messenger.foundation.a.a.i.c;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.protocal.protobuf.afm;
import com.tencent.mm.protocal.protobuf.afn;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.ar;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.storage.bv;
import com.tencent.mm.vfs.o;
import java.io.ByteArrayOutputStream;

public final class f
  extends n
  implements com.tencent.mm.network.k
{
  private com.tencent.mm.ak.f callback;
  bv dCi;
  com.tencent.mm.ak.g idS;
  String idX;
  private g.a ieg;
  private String mediaId;
  public long msgId;
  private long nCM;
  public boolean ptB;
  public int retCode;
  private com.tencent.mm.ak.b rr;
  long startTime;
  private int type;
  private boolean xGA;
  private boolean xGB;
  private boolean xGC;
  com.tencent.mm.pluginsdk.model.app.c xGv;
  public long xGx;
  private int xGy;
  String xGz;
  
  public f(long paramLong1, long paramLong2, com.tencent.mm.ak.g paramg)
  {
    AppMethodBeat.i(9475);
    this.xGv = null;
    this.xGx = -1L;
    this.mediaId = "";
    this.msgId = 0L;
    this.dCi = null;
    this.idX = "";
    this.startTime = 0L;
    this.xGy = -1;
    this.xGz = "";
    this.type = 0;
    this.retCode = 0;
    this.xGA = false;
    this.xGB = false;
    this.nCM = 0L;
    this.ptB = false;
    this.xGC = false;
    this.ieg = new g.a()
    {
      public final int a(String paramAnonymousString, final int paramAnonymousInt, com.tencent.mm.i.c paramAnonymousc, final com.tencent.mm.i.d paramAnonymousd, boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(9473);
        if (paramAnonymousc == null) {}
        for (paramAnonymousBoolean = true;; paramAnonymousBoolean = false)
        {
          ae.d("MicroMsg.NetSceneDownloadAppAttach", "summerbig callback mediaId[%s], startRet[%d], progressInfo[%s], sceneResult[%s], finish[%b]", new Object[] { paramAnonymousString, Integer.valueOf(paramAnonymousInt), paramAnonymousc, paramAnonymousd, Boolean.valueOf(paramAnonymousBoolean) });
          if (paramAnonymousInt != -21006) {
            break;
          }
          ae.i("MicroMsg.NetSceneDownloadAppAttach", "summerbig callback cdntra  ERR_CNDCOM_MEDIA_IS_DOWNLOADING clientid:%s", new Object[] { f.this.idX });
          AppMethodBeat.o(9473);
          return 0;
        }
        if (paramAnonymousInt != 0)
        {
          a.zc(f.this.xGv.systemRowid);
          new j(com.tencent.mm.plugin.report.a.t(new Object[] { Integer.valueOf(paramAnonymousInt), Integer.valueOf(2), Long.valueOf(f.this.startTime), Long.valueOf(bu.fpO()), Integer.valueOf(com.tencent.mm.an.c.cC(ak.getContext())), Integer.valueOf(com.tencent.mm.i.a.MediaType_FILE), Integer.valueOf(0), "" })).aLH();
          ar.f(new Runnable()
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
        f.this.xGv = a.r(paramAnonymousString, f.this.msgId);
        if (f.this.xGv == null)
        {
          ae.e("MicroMsg.NetSceneDownloadAppAttach", "summerbig attachInfo is null");
          ar.f(new Runnable()
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
        if (f.this.xGv.field_status == 102L)
        {
          ae.i("MicroMsg.NetSceneDownloadAppAttach", "summerbig dancy attach download has paused, status:%d", new Object[] { Long.valueOf(f.this.xGv.field_status) });
          com.tencent.mm.an.f.aGZ().Fr(f.this.idX);
          ar.f(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(9467);
              f.a(f.this, 3, paramAnonymousInt, "attach  has paused, status=" + f.this.xGv.field_status, f.this);
              AppMethodBeat.o(9467);
            }
          });
          AppMethodBeat.o(9473);
          return 0;
        }
        if (paramAnonymousc != null)
        {
          if (paramAnonymousc.field_finishedLength == f.this.xGv.field_totalLen)
          {
            ae.i("MicroMsg.NetSceneDownloadAppAttach", "summerbig callback cdntra ignore progress 100%");
            AppMethodBeat.o(9473);
            return 0;
          }
          if (f.this.xGv.field_offset > paramAnonymousc.field_finishedLength)
          {
            ae.e("MicroMsg.NetSceneDownloadAppAttach", "summerbig callback cdnEndProc error oldpos:%d newpos:%d", new Object[] { Long.valueOf(f.this.xGv.field_offset), Long.valueOf(paramAnonymousc.field_finishedLength) });
            a.zc(f.this.xGv.systemRowid);
            ar.f(new Runnable()
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
          f.this.xGv.field_offset = paramAnonymousc.field_finishedLength;
          com.tencent.mm.plugin.s.a.bJV().a(f.this.xGv, new String[0]);
          if (f.this.idS != null) {
            ar.f(new Runnable()
            {
              public final void run()
              {
                AppMethodBeat.i(9469);
                f.this.idS.a((int)f.this.xGv.field_offset, (int)f.this.xGv.field_totalLen, f.this);
                AppMethodBeat.o(9469);
              }
            });
          }
          ae.d("MicroMsg.NetSceneDownloadAppAttach", "summerbig callback cdntra progresscallback id:%s finish:%d total:%d", new Object[] { f.this.idX, Long.valueOf(paramAnonymousc.field_finishedLength), Long.valueOf(paramAnonymousc.field_toltalLength) });
          AppMethodBeat.o(9473);
          return 0;
        }
        if (paramAnonymousd != null)
        {
          if (paramAnonymousd.field_retCode == 0) {
            break label1001;
          }
          a.zc(f.this.xGv.systemRowid);
          ae.e("MicroMsg.NetSceneDownloadAppAttach", "summerbig callback cdntra sceneResult.retCode :%d", new Object[] { Integer.valueOf(paramAnonymousd.field_retCode) });
          new j(com.tencent.mm.plugin.report.a.t(new Object[] { Integer.valueOf(paramAnonymousd.field_retCode), Integer.valueOf(2), Long.valueOf(f.this.startTime), Long.valueOf(bu.fpO()), Integer.valueOf(com.tencent.mm.an.c.cC(ak.getContext())), Integer.valueOf(com.tencent.mm.i.a.MediaType_FILE), Long.valueOf(f.this.xGv.field_totalLen), paramAnonymousd.field_transInfo, "", "", "", "", "", "", "", paramAnonymousd.fKX })).aLH();
          if (paramAnonymousd.field_retCode != 0) {
            new h(com.tencent.mm.plugin.report.a.t(new Object[] { Integer.valueOf(paramAnonymousd.field_retCode), Integer.valueOf(2), Long.valueOf(f.this.startTime), Long.valueOf(bu.fpO()), Integer.valueOf(com.tencent.mm.an.c.cC(ak.getContext())), Integer.valueOf(com.tencent.mm.i.a.MediaType_FILE), Long.valueOf(f.this.xGv.field_totalLen), paramAnonymousd.field_transInfo, "", "", "", "", "", "", "", paramAnonymousd.fKX })).aLH();
          }
          if (f.this.idS != null) {
            ar.f(new Runnable()
            {
              public final void run()
              {
                AppMethodBeat.i(9470);
                f.this.idS.a((int)f.this.xGv.field_offset, (int)f.this.xGv.field_totalLen, f.this);
                AppMethodBeat.o(9470);
              }
            });
          }
          if (paramAnonymousd.field_retCode == 0) {
            break label1293;
          }
          ar.f(new Runnable()
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
          label1001:
          new com.tencent.mm.vfs.k(f.this.xGz).ag(new com.tencent.mm.vfs.k(f.this.xGv.field_fileFullPath));
          f.this.xGv.field_status = 199L;
          f.this.xGv.field_offset = f.this.xGv.field_totalLen;
          com.tencent.mm.plugin.s.a.bJV().a(f.this.xGv, new String[0]);
          com.tencent.mm.plugin.report.service.g.yxI.idkeyStat(198L, 45L, f.this.xGv.field_totalLen, false);
          com.tencent.mm.plugin.report.service.g.yxI.idkeyStat(198L, 46L, 1L, false);
          paramAnonymousc = com.tencent.mm.plugin.report.service.g.yxI;
          if (f.this.dCi == null)
          {
            paramAnonymousString = "";
            label1141:
            if (!x.wb(paramAnonymousString)) {
              break label1248;
            }
          }
          label1248:
          for (long l = 48L;; l = 47L)
          {
            paramAnonymousc.idkeyStat(198L, l, 1L, false);
            paramAnonymousString = ((l)com.tencent.mm.kernel.g.ab(l.class)).doJ().ys(f.this.xGv.field_msgInfoId);
            if (paramAnonymousString.field_status != 5) {
              break label1256;
            }
            paramAnonymousString.setStatus(3);
            ((l)com.tencent.mm.kernel.g.ab(l.class)).doJ().a(paramAnonymousString.field_msgId, paramAnonymousString);
            break;
            paramAnonymousString = f.this.dCi.field_talker;
            break label1141;
          }
          label1256:
          ((l)com.tencent.mm.kernel.g.ab(l.class)).doJ().a(new i.c(paramAnonymousString.field_talker, "update", paramAnonymousString));
          break;
          label1293:
          ar.f(new Runnable()
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
    this.nCM = paramLong2;
    this.msgId = paramLong1;
    this.xGv = com.tencent.mm.plugin.s.a.bJV().CZ(paramLong1);
    this.idS = paramg;
    this.xGB = true;
    if (this.xGv == null)
    {
      ae.e("MicroMsg.NetSceneDownloadAppAttach", "big appMsg, info is null, msgid = , svrId".concat(String.valueOf(paramLong1)), new Object[] { Long.valueOf(paramLong2) });
      AppMethodBeat.o(9475);
      return;
    }
    paramg = new b.a();
    paramg.hQF = new afm();
    paramg.hQG = new afn();
    paramg.uri = "/cgi-bin/micromsg-bin/downloadappattach";
    paramg.funcId = 221;
    paramg.hQH = 106;
    paramg.respCmdId = 1000000106;
    this.rr = paramg.aDS();
    AppMethodBeat.o(9475);
  }
  
  public f(long paramLong, String paramString, com.tencent.mm.ak.g paramg)
  {
    this(paramString, paramLong, paramg);
    this.msgId = paramLong;
  }
  
  public f(com.tencent.mm.pluginsdk.model.app.c paramc)
  {
    AppMethodBeat.i(9476);
    this.xGv = null;
    this.xGx = -1L;
    this.mediaId = "";
    this.msgId = 0L;
    this.dCi = null;
    this.idX = "";
    this.startTime = 0L;
    this.xGy = -1;
    this.xGz = "";
    this.type = 0;
    this.retCode = 0;
    this.xGA = false;
    this.xGB = false;
    this.nCM = 0L;
    this.ptB = false;
    this.xGC = false;
    this.ieg = new g.a()
    {
      public final int a(String paramAnonymousString, final int paramAnonymousInt, com.tencent.mm.i.c paramAnonymousc, final com.tencent.mm.i.d paramAnonymousd, boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(9473);
        if (paramAnonymousc == null) {}
        for (paramAnonymousBoolean = true;; paramAnonymousBoolean = false)
        {
          ae.d("MicroMsg.NetSceneDownloadAppAttach", "summerbig callback mediaId[%s], startRet[%d], progressInfo[%s], sceneResult[%s], finish[%b]", new Object[] { paramAnonymousString, Integer.valueOf(paramAnonymousInt), paramAnonymousc, paramAnonymousd, Boolean.valueOf(paramAnonymousBoolean) });
          if (paramAnonymousInt != -21006) {
            break;
          }
          ae.i("MicroMsg.NetSceneDownloadAppAttach", "summerbig callback cdntra  ERR_CNDCOM_MEDIA_IS_DOWNLOADING clientid:%s", new Object[] { f.this.idX });
          AppMethodBeat.o(9473);
          return 0;
        }
        if (paramAnonymousInt != 0)
        {
          a.zc(f.this.xGv.systemRowid);
          new j(com.tencent.mm.plugin.report.a.t(new Object[] { Integer.valueOf(paramAnonymousInt), Integer.valueOf(2), Long.valueOf(f.this.startTime), Long.valueOf(bu.fpO()), Integer.valueOf(com.tencent.mm.an.c.cC(ak.getContext())), Integer.valueOf(com.tencent.mm.i.a.MediaType_FILE), Integer.valueOf(0), "" })).aLH();
          ar.f(new Runnable()
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
        f.this.xGv = a.r(paramAnonymousString, f.this.msgId);
        if (f.this.xGv == null)
        {
          ae.e("MicroMsg.NetSceneDownloadAppAttach", "summerbig attachInfo is null");
          ar.f(new Runnable()
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
        if (f.this.xGv.field_status == 102L)
        {
          ae.i("MicroMsg.NetSceneDownloadAppAttach", "summerbig dancy attach download has paused, status:%d", new Object[] { Long.valueOf(f.this.xGv.field_status) });
          com.tencent.mm.an.f.aGZ().Fr(f.this.idX);
          ar.f(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(9467);
              f.a(f.this, 3, paramAnonymousInt, "attach  has paused, status=" + f.this.xGv.field_status, f.this);
              AppMethodBeat.o(9467);
            }
          });
          AppMethodBeat.o(9473);
          return 0;
        }
        if (paramAnonymousc != null)
        {
          if (paramAnonymousc.field_finishedLength == f.this.xGv.field_totalLen)
          {
            ae.i("MicroMsg.NetSceneDownloadAppAttach", "summerbig callback cdntra ignore progress 100%");
            AppMethodBeat.o(9473);
            return 0;
          }
          if (f.this.xGv.field_offset > paramAnonymousc.field_finishedLength)
          {
            ae.e("MicroMsg.NetSceneDownloadAppAttach", "summerbig callback cdnEndProc error oldpos:%d newpos:%d", new Object[] { Long.valueOf(f.this.xGv.field_offset), Long.valueOf(paramAnonymousc.field_finishedLength) });
            a.zc(f.this.xGv.systemRowid);
            ar.f(new Runnable()
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
          f.this.xGv.field_offset = paramAnonymousc.field_finishedLength;
          com.tencent.mm.plugin.s.a.bJV().a(f.this.xGv, new String[0]);
          if (f.this.idS != null) {
            ar.f(new Runnable()
            {
              public final void run()
              {
                AppMethodBeat.i(9469);
                f.this.idS.a((int)f.this.xGv.field_offset, (int)f.this.xGv.field_totalLen, f.this);
                AppMethodBeat.o(9469);
              }
            });
          }
          ae.d("MicroMsg.NetSceneDownloadAppAttach", "summerbig callback cdntra progresscallback id:%s finish:%d total:%d", new Object[] { f.this.idX, Long.valueOf(paramAnonymousc.field_finishedLength), Long.valueOf(paramAnonymousc.field_toltalLength) });
          AppMethodBeat.o(9473);
          return 0;
        }
        if (paramAnonymousd != null)
        {
          if (paramAnonymousd.field_retCode == 0) {
            break label1001;
          }
          a.zc(f.this.xGv.systemRowid);
          ae.e("MicroMsg.NetSceneDownloadAppAttach", "summerbig callback cdntra sceneResult.retCode :%d", new Object[] { Integer.valueOf(paramAnonymousd.field_retCode) });
          new j(com.tencent.mm.plugin.report.a.t(new Object[] { Integer.valueOf(paramAnonymousd.field_retCode), Integer.valueOf(2), Long.valueOf(f.this.startTime), Long.valueOf(bu.fpO()), Integer.valueOf(com.tencent.mm.an.c.cC(ak.getContext())), Integer.valueOf(com.tencent.mm.i.a.MediaType_FILE), Long.valueOf(f.this.xGv.field_totalLen), paramAnonymousd.field_transInfo, "", "", "", "", "", "", "", paramAnonymousd.fKX })).aLH();
          if (paramAnonymousd.field_retCode != 0) {
            new h(com.tencent.mm.plugin.report.a.t(new Object[] { Integer.valueOf(paramAnonymousd.field_retCode), Integer.valueOf(2), Long.valueOf(f.this.startTime), Long.valueOf(bu.fpO()), Integer.valueOf(com.tencent.mm.an.c.cC(ak.getContext())), Integer.valueOf(com.tencent.mm.i.a.MediaType_FILE), Long.valueOf(f.this.xGv.field_totalLen), paramAnonymousd.field_transInfo, "", "", "", "", "", "", "", paramAnonymousd.fKX })).aLH();
          }
          if (f.this.idS != null) {
            ar.f(new Runnable()
            {
              public final void run()
              {
                AppMethodBeat.i(9470);
                f.this.idS.a((int)f.this.xGv.field_offset, (int)f.this.xGv.field_totalLen, f.this);
                AppMethodBeat.o(9470);
              }
            });
          }
          if (paramAnonymousd.field_retCode == 0) {
            break label1293;
          }
          ar.f(new Runnable()
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
          label1001:
          new com.tencent.mm.vfs.k(f.this.xGz).ag(new com.tencent.mm.vfs.k(f.this.xGv.field_fileFullPath));
          f.this.xGv.field_status = 199L;
          f.this.xGv.field_offset = f.this.xGv.field_totalLen;
          com.tencent.mm.plugin.s.a.bJV().a(f.this.xGv, new String[0]);
          com.tencent.mm.plugin.report.service.g.yxI.idkeyStat(198L, 45L, f.this.xGv.field_totalLen, false);
          com.tencent.mm.plugin.report.service.g.yxI.idkeyStat(198L, 46L, 1L, false);
          paramAnonymousc = com.tencent.mm.plugin.report.service.g.yxI;
          if (f.this.dCi == null)
          {
            paramAnonymousString = "";
            label1141:
            if (!x.wb(paramAnonymousString)) {
              break label1248;
            }
          }
          label1248:
          for (long l = 48L;; l = 47L)
          {
            paramAnonymousc.idkeyStat(198L, l, 1L, false);
            paramAnonymousString = ((l)com.tencent.mm.kernel.g.ab(l.class)).doJ().ys(f.this.xGv.field_msgInfoId);
            if (paramAnonymousString.field_status != 5) {
              break label1256;
            }
            paramAnonymousString.setStatus(3);
            ((l)com.tencent.mm.kernel.g.ab(l.class)).doJ().a(paramAnonymousString.field_msgId, paramAnonymousString);
            break;
            paramAnonymousString = f.this.dCi.field_talker;
            break label1141;
          }
          label1256:
          ((l)com.tencent.mm.kernel.g.ab(l.class)).doJ().a(new i.c(paramAnonymousString.field_talker, "update", paramAnonymousString));
          break;
          label1293:
          ar.f(new Runnable()
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
    this.xGv = paramc;
    this.xGA = true;
    this.mediaId = this.xGv.field_mediaId;
    this.idS = null;
    this.type = 0;
    if (paramc == null)
    {
      ae.e("MicroMsg.NetSceneDownloadAppAttach", "summerbig <init>, info is null, mediaId = " + this.mediaId);
      AppMethodBeat.o(9476);
      return;
    }
    b.a locala = new b.a();
    locala.hQF = new afm();
    locala.hQG = new afn();
    locala.uri = "/cgi-bin/micromsg-bin/downloadappattach";
    locala.funcId = 221;
    locala.hQH = 106;
    locala.respCmdId = 1000000106;
    this.rr = locala.aDS();
    ae.i("MicroMsg.NetSceneDownloadAppAttach", "summerbig NetSceneDownloadAppAttach info fullpath[%s], justSaveFile[%b], stack[%s]", new Object[] { paramc.field_fileFullPath, Boolean.TRUE, bu.fpN() });
    AppMethodBeat.o(9476);
  }
  
  public f(String paramString)
  {
    this(paramString, 0L, null);
  }
  
  private f(String paramString, long paramLong, com.tencent.mm.ak.g paramg)
  {
    AppMethodBeat.i(9477);
    this.xGv = null;
    this.xGx = -1L;
    this.mediaId = "";
    this.msgId = 0L;
    this.dCi = null;
    this.idX = "";
    this.startTime = 0L;
    this.xGy = -1;
    this.xGz = "";
    this.type = 0;
    this.retCode = 0;
    this.xGA = false;
    this.xGB = false;
    this.nCM = 0L;
    this.ptB = false;
    this.xGC = false;
    this.ieg = new g.a()
    {
      public final int a(String paramAnonymousString, final int paramAnonymousInt, com.tencent.mm.i.c paramAnonymousc, final com.tencent.mm.i.d paramAnonymousd, boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(9473);
        if (paramAnonymousc == null) {}
        for (paramAnonymousBoolean = true;; paramAnonymousBoolean = false)
        {
          ae.d("MicroMsg.NetSceneDownloadAppAttach", "summerbig callback mediaId[%s], startRet[%d], progressInfo[%s], sceneResult[%s], finish[%b]", new Object[] { paramAnonymousString, Integer.valueOf(paramAnonymousInt), paramAnonymousc, paramAnonymousd, Boolean.valueOf(paramAnonymousBoolean) });
          if (paramAnonymousInt != -21006) {
            break;
          }
          ae.i("MicroMsg.NetSceneDownloadAppAttach", "summerbig callback cdntra  ERR_CNDCOM_MEDIA_IS_DOWNLOADING clientid:%s", new Object[] { f.this.idX });
          AppMethodBeat.o(9473);
          return 0;
        }
        if (paramAnonymousInt != 0)
        {
          a.zc(f.this.xGv.systemRowid);
          new j(com.tencent.mm.plugin.report.a.t(new Object[] { Integer.valueOf(paramAnonymousInt), Integer.valueOf(2), Long.valueOf(f.this.startTime), Long.valueOf(bu.fpO()), Integer.valueOf(com.tencent.mm.an.c.cC(ak.getContext())), Integer.valueOf(com.tencent.mm.i.a.MediaType_FILE), Integer.valueOf(0), "" })).aLH();
          ar.f(new Runnable()
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
        f.this.xGv = a.r(paramAnonymousString, f.this.msgId);
        if (f.this.xGv == null)
        {
          ae.e("MicroMsg.NetSceneDownloadAppAttach", "summerbig attachInfo is null");
          ar.f(new Runnable()
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
        if (f.this.xGv.field_status == 102L)
        {
          ae.i("MicroMsg.NetSceneDownloadAppAttach", "summerbig dancy attach download has paused, status:%d", new Object[] { Long.valueOf(f.this.xGv.field_status) });
          com.tencent.mm.an.f.aGZ().Fr(f.this.idX);
          ar.f(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(9467);
              f.a(f.this, 3, paramAnonymousInt, "attach  has paused, status=" + f.this.xGv.field_status, f.this);
              AppMethodBeat.o(9467);
            }
          });
          AppMethodBeat.o(9473);
          return 0;
        }
        if (paramAnonymousc != null)
        {
          if (paramAnonymousc.field_finishedLength == f.this.xGv.field_totalLen)
          {
            ae.i("MicroMsg.NetSceneDownloadAppAttach", "summerbig callback cdntra ignore progress 100%");
            AppMethodBeat.o(9473);
            return 0;
          }
          if (f.this.xGv.field_offset > paramAnonymousc.field_finishedLength)
          {
            ae.e("MicroMsg.NetSceneDownloadAppAttach", "summerbig callback cdnEndProc error oldpos:%d newpos:%d", new Object[] { Long.valueOf(f.this.xGv.field_offset), Long.valueOf(paramAnonymousc.field_finishedLength) });
            a.zc(f.this.xGv.systemRowid);
            ar.f(new Runnable()
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
          f.this.xGv.field_offset = paramAnonymousc.field_finishedLength;
          com.tencent.mm.plugin.s.a.bJV().a(f.this.xGv, new String[0]);
          if (f.this.idS != null) {
            ar.f(new Runnable()
            {
              public final void run()
              {
                AppMethodBeat.i(9469);
                f.this.idS.a((int)f.this.xGv.field_offset, (int)f.this.xGv.field_totalLen, f.this);
                AppMethodBeat.o(9469);
              }
            });
          }
          ae.d("MicroMsg.NetSceneDownloadAppAttach", "summerbig callback cdntra progresscallback id:%s finish:%d total:%d", new Object[] { f.this.idX, Long.valueOf(paramAnonymousc.field_finishedLength), Long.valueOf(paramAnonymousc.field_toltalLength) });
          AppMethodBeat.o(9473);
          return 0;
        }
        if (paramAnonymousd != null)
        {
          if (paramAnonymousd.field_retCode == 0) {
            break label1001;
          }
          a.zc(f.this.xGv.systemRowid);
          ae.e("MicroMsg.NetSceneDownloadAppAttach", "summerbig callback cdntra sceneResult.retCode :%d", new Object[] { Integer.valueOf(paramAnonymousd.field_retCode) });
          new j(com.tencent.mm.plugin.report.a.t(new Object[] { Integer.valueOf(paramAnonymousd.field_retCode), Integer.valueOf(2), Long.valueOf(f.this.startTime), Long.valueOf(bu.fpO()), Integer.valueOf(com.tencent.mm.an.c.cC(ak.getContext())), Integer.valueOf(com.tencent.mm.i.a.MediaType_FILE), Long.valueOf(f.this.xGv.field_totalLen), paramAnonymousd.field_transInfo, "", "", "", "", "", "", "", paramAnonymousd.fKX })).aLH();
          if (paramAnonymousd.field_retCode != 0) {
            new h(com.tencent.mm.plugin.report.a.t(new Object[] { Integer.valueOf(paramAnonymousd.field_retCode), Integer.valueOf(2), Long.valueOf(f.this.startTime), Long.valueOf(bu.fpO()), Integer.valueOf(com.tencent.mm.an.c.cC(ak.getContext())), Integer.valueOf(com.tencent.mm.i.a.MediaType_FILE), Long.valueOf(f.this.xGv.field_totalLen), paramAnonymousd.field_transInfo, "", "", "", "", "", "", "", paramAnonymousd.fKX })).aLH();
          }
          if (f.this.idS != null) {
            ar.f(new Runnable()
            {
              public final void run()
              {
                AppMethodBeat.i(9470);
                f.this.idS.a((int)f.this.xGv.field_offset, (int)f.this.xGv.field_totalLen, f.this);
                AppMethodBeat.o(9470);
              }
            });
          }
          if (paramAnonymousd.field_retCode == 0) {
            break label1293;
          }
          ar.f(new Runnable()
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
          label1001:
          new com.tencent.mm.vfs.k(f.this.xGz).ag(new com.tencent.mm.vfs.k(f.this.xGv.field_fileFullPath));
          f.this.xGv.field_status = 199L;
          f.this.xGv.field_offset = f.this.xGv.field_totalLen;
          com.tencent.mm.plugin.s.a.bJV().a(f.this.xGv, new String[0]);
          com.tencent.mm.plugin.report.service.g.yxI.idkeyStat(198L, 45L, f.this.xGv.field_totalLen, false);
          com.tencent.mm.plugin.report.service.g.yxI.idkeyStat(198L, 46L, 1L, false);
          paramAnonymousc = com.tencent.mm.plugin.report.service.g.yxI;
          if (f.this.dCi == null)
          {
            paramAnonymousString = "";
            label1141:
            if (!x.wb(paramAnonymousString)) {
              break label1248;
            }
          }
          label1248:
          for (long l = 48L;; l = 47L)
          {
            paramAnonymousc.idkeyStat(198L, l, 1L, false);
            paramAnonymousString = ((l)com.tencent.mm.kernel.g.ab(l.class)).doJ().ys(f.this.xGv.field_msgInfoId);
            if (paramAnonymousString.field_status != 5) {
              break label1256;
            }
            paramAnonymousString.setStatus(3);
            ((l)com.tencent.mm.kernel.g.ab(l.class)).doJ().a(paramAnonymousString.field_msgId, paramAnonymousString);
            break;
            paramAnonymousString = f.this.dCi.field_talker;
            break label1141;
          }
          label1256:
          ((l)com.tencent.mm.kernel.g.ab(l.class)).doJ().a(new i.c(paramAnonymousString.field_talker, "update", paramAnonymousString));
          break;
          label1293:
          ar.f(new Runnable()
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
    this.idS = paramg;
    this.type = 0;
    this.xGv = com.tencent.mm.plugin.s.a.bJV().aMZ(paramString);
    if (this.xGv == null) {
      this.xGv = com.tencent.mm.plugin.s.a.bJV().CZ(paramLong);
    }
    if (this.xGv == null)
    {
      ae.e("MicroMsg.NetSceneDownloadAppAttach", "summerbig <init>, info is null, mediaId = ".concat(String.valueOf(paramString)));
      AppMethodBeat.o(9477);
      return;
    }
    paramString = new b.a();
    paramString.hQF = new afm();
    paramString.hQG = new afn();
    paramString.uri = "/cgi-bin/micromsg-bin/downloadappattach";
    paramString.funcId = 221;
    paramString.hQH = 106;
    paramString.respCmdId = 1000000106;
    this.rr = paramString.aDS();
    ae.d("MicroMsg.NetSceneDownloadAppAttach", "summerbig NetSceneDownloadAppAttach , type[%d], info fullpath[%s], field_type[%d], signature[%s], stack[%s]", new Object[] { Integer.valueOf(0), this.xGv.field_fileFullPath, Long.valueOf(this.xGv.field_type), this.xGv.field_signature, bu.fpN() });
    AppMethodBeat.o(9477);
  }
  
  private void h(int paramInt1, int paramInt2, String paramString, n paramn)
  {
    AppMethodBeat.i(9482);
    if (this.callback != null)
    {
      this.callback.onSceneEnd(paramInt1, paramInt2, paramString, paramn);
      if (this.xGv != null)
      {
        long l = this.xGv.field_msgInfoId;
        paramString = ((l)com.tencent.mm.kernel.g.ab(l.class)).doJ().ys(l);
        if ((paramInt1 == 0) && (paramInt2 == 0))
        {
          ((com.tencent.mm.plugin.comm.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.comm.a.b.class)).a(this.ptB, String.valueOf(l), paramString.field_msgSvrId, true);
          AppMethodBeat.o(9482);
          return;
        }
        ((com.tencent.mm.plugin.comm.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.comm.a.b.class)).a(this.ptB, String.valueOf(l), paramString.field_msgSvrId, false);
      }
    }
    AppMethodBeat.o(9482);
  }
  
  public final void a(a parama)
  {
    AppMethodBeat.i(9479);
    if (!this.xGA)
    {
      com.tencent.mm.an.f.aGZ().Fs(this.idX);
      this.xGv = com.tencent.mm.plugin.s.a.bJV().CZ(this.msgId);
      if (this.xGv == null)
      {
        ae.i("MicroMsg.NetSceneDownloadAppAttach", "pause get by msgid  %是is null then get by mediaId %s", new Object[] { Long.valueOf(this.msgId), this.mediaId });
        this.xGv = com.tencent.mm.plugin.s.a.bJV().aMZ(this.mediaId);
      }
    }
    ae.i("MicroMsg.NetSceneDownloadAppAttach", "summerbig pause listener[%s], info[%s], justSaveFile[%b], stack[%s]", new Object[] { parama, this.xGv, Boolean.valueOf(this.xGA), bu.fpN() });
    if (this.xGv == null)
    {
      AppMethodBeat.o(9479);
      return;
    }
    if ((this.xGv.field_status == 101L) && (parama != null)) {
      parama.dHA();
    }
    this.xGv.field_status = 102L;
    if (!this.xGA) {
      ae.i("MicroMsg.NetSceneDownloadAppAttach", "pause done %s", new Object[] { Boolean.valueOf(com.tencent.mm.plugin.s.a.bJV().a(this.xGv, new String[0])) });
    }
    AppMethodBeat.o(9479);
  }
  
  public final void dHz()
  {
    AppMethodBeat.i(9478);
    this.xGC = true;
    if (this.xGC)
    {
      String str = this.xGv.field_fileFullPath;
      byte[] arrayOfByte = "#!AMR\n".getBytes();
      o.e(str, arrayOfByte, arrayOfByte.length);
    }
    AppMethodBeat.o(9478);
  }
  
  public final int doScene(e parame, com.tencent.mm.ak.f paramf)
  {
    AppMethodBeat.i(9480);
    this.callback = paramf;
    if (this.xGv == null)
    {
      ae.e("MicroMsg.NetSceneDownloadAppAttach", com.tencent.mm.compatible.util.f.abr() + " get info failed mediaId:" + this.mediaId);
      this.retCode = (-10000 - com.tencent.mm.compatible.util.f.getLine());
      AppMethodBeat.o(9480);
      return -1;
    }
    this.dCi = ((l)com.tencent.mm.kernel.g.ab(l.class)).doJ().ys(this.msgId);
    if ((this.dCi == null) || (this.dCi.field_msgId != this.msgId))
    {
      ae.e("MicroMsg.NetSceneDownloadAppAttach", com.tencent.mm.compatible.util.f.abr() + " get msginfo failed mediaId:%s  msgId:%d", new Object[] { this.mediaId, Long.valueOf(this.msgId) });
      this.retCode = (-10000 - com.tencent.mm.compatible.util.f.getLine());
      AppMethodBeat.o(9480);
      return -1;
    }
    if (this.startTime == 0L)
    {
      this.startTime = bu.fpO();
      this.xGy = ((int)this.xGv.field_offset);
    }
    if (this.nCM != 0L)
    {
      paramf = (afm)this.rr.hQD.hQJ;
      paramf.nIJ = v.aAC();
      paramf.xsB = ((int)this.xGv.field_totalLen);
      paramf.xsC = ((int)this.xGv.field_offset);
      paramf.xsD = 0;
      paramf.nJA = 40;
      paramf.xrk = this.nCM;
      i = dispatch(parame, this.rr, this);
      AppMethodBeat.o(9480);
      return i;
    }
    Object localObject = this.dCi.field_content;
    paramf = (com.tencent.mm.ak.f)localObject;
    if (x.wb(this.dCi.field_talker))
    {
      i = bl.BJ(this.dCi.field_content);
      paramf = (com.tencent.mm.ak.f)localObject;
      if (i != -1) {
        paramf = (this.dCi.field_content + " ").substring(i + 2).trim();
      }
    }
    paramf = k.b.zb(bu.aSA(paramf));
    if (paramf == null)
    {
      ae.e("MicroMsg.NetSceneDownloadAppAttach", "summerbig checkUseCdn cdntra parse content xml failed: mediaId:%s", new Object[] { this.mediaId });
      i = 0;
    }
    while (i != 0)
    {
      ae.d("MicroMsg.NetSceneDownloadAppAttach", "cdntra use cdn return -1 for onGYNetEnd mediaid:%s", new Object[] { this.mediaId });
      AppMethodBeat.o(9480);
      return 0;
      ae.i("MicroMsg.NetSceneDownloadAppAttach", "summerbig cdntra checkUseCdn msgid:%d total:%d fullpath:%s fileid:%s aeskey:%s ", new Object[] { Long.valueOf(this.msgId), Long.valueOf(this.xGv.field_totalLen), this.xGv.field_fileFullPath, paramf.hCR, bu.aSM(paramf.gmb) });
      if (((bu.isNullOrNil(paramf.hCR)) && (bu.isNullOrNil(paramf.hCI))) || (bu.isNullOrNil(paramf.gmb)))
      {
        ae.w("MicroMsg.NetSceneDownloadAppAttach", "summerbig cdntra checkUseCdn msgId:%d Not use CDN  cdnAttachUrl:%s aes:%s ", new Object[] { Long.valueOf(this.msgId), paramf.hCR, bu.aSM(paramf.gmb) });
        i = 0;
      }
      else
      {
        this.idX = com.tencent.mm.an.c.a("downattach", this.xGv.field_createTime, this.dCi.field_talker, this.xGx);
        if (bu.isNullOrNil(this.idX))
        {
          ae.w("MicroMsg.NetSceneDownloadAppAttach", "summerbig cdntra genClientId failed not use cdn rowid:%d", new Object[] { Long.valueOf(this.xGx) });
          i = 0;
        }
        else
        {
          o.aZI(o.aZU(this.xGv.field_fileFullPath));
          this.xGz = (this.xGv.field_fileFullPath + "_tmp");
          localObject = new com.tencent.mm.i.g();
          ((com.tencent.mm.i.g)localObject).fLl = "task_NetSceneDownloadAppAttach";
          ((com.tencent.mm.i.g)localObject).field_mediaId = this.idX;
          ((com.tencent.mm.i.g)localObject).field_fullpath = this.xGz;
          if ((paramf.hCG != 0) || (paramf.hCC > 26214400))
          {
            i = com.tencent.mm.i.a.fKC;
            label765:
            ((com.tencent.mm.i.g)localObject).field_fileType = i;
            ((com.tencent.mm.i.g)localObject).field_totalLen = ((int)this.xGv.field_totalLen);
            ((com.tencent.mm.i.g)localObject).field_aesKey = paramf.gmb;
            ((com.tencent.mm.i.g)localObject).field_fileId = paramf.hCR;
            ((com.tencent.mm.i.g)localObject).field_svr_signature = this.xGv.field_signature;
            ((com.tencent.mm.i.g)localObject).field_fake_bigfile_signature_aeskey = this.xGv.field_fakeAeskey;
            ((com.tencent.mm.i.g)localObject).field_fake_bigfile_signature = this.xGv.field_fakeSignature;
            ((com.tencent.mm.i.g)localObject).field_onlycheckexist = false;
            ((com.tencent.mm.i.g)localObject).field_priority = com.tencent.mm.i.a.fKA;
            ((com.tencent.mm.i.g)localObject).fLm = this.ieg;
            if (!x.wb(this.dCi.field_talker)) {
              break label1095;
            }
            i = 1;
            label876:
            ((com.tencent.mm.i.g)localObject).field_chattype = i;
            if ((!com.tencent.mm.an.c.aGU()) || ((paramf.hCG == 0) && (paramf.hCC <= 26214400))) {
              break label1100;
            }
          }
          label1095:
          label1100:
          for (boolean bool = true;; bool = false)
          {
            ((com.tencent.mm.i.g)localObject).field_use_multithread = bool;
            if (!bu.isNullOrNil(paramf.hCI))
            {
              ((com.tencent.mm.i.g)localObject).field_fileType = 19;
              ((com.tencent.mm.i.g)localObject).field_authKey = paramf.hCO;
              ((com.tencent.mm.i.g)localObject).fLp = paramf.hCI;
              ((com.tencent.mm.i.g)localObject).field_fileId = "";
            }
            ae.i("MicroMsg.NetSceneDownloadAppAttach", "summerbig checkUseCdn addRecvTask taskInfo field_use_multithread[%s], field_fileType[%d], fileFullPath[%s], aeskey[%s], signature[%s], faeskey[%s], fsignature[%s], onlycheckexist[%s]", new Object[] { Boolean.valueOf(((com.tencent.mm.i.g)localObject).field_use_multithread), Integer.valueOf(((com.tencent.mm.i.g)localObject).field_fileType), ((com.tencent.mm.i.g)localObject).field_fullpath, bu.aSM(((com.tencent.mm.i.g)localObject).field_aesKey), bu.aSM(((com.tencent.mm.i.g)localObject).field_svr_signature), bu.aSM(((com.tencent.mm.i.g)localObject).field_fake_bigfile_signature_aeskey), bu.aSM(((com.tencent.mm.i.g)localObject).field_fake_bigfile_signature), Boolean.valueOf(((com.tencent.mm.i.g)localObject).field_onlycheckexist) });
            if (com.tencent.mm.an.f.aGZ().b((com.tencent.mm.i.g)localObject, -1)) {
              break label1106;
            }
            ae.e("MicroMsg.NetSceneDownloadAppAttach", "summerbig cdntra addSendTask failed.");
            this.idX = "";
            i = 0;
            break;
            i = com.tencent.mm.i.a.MediaType_FILE;
            break label765;
            i = 0;
            break label876;
          }
          label1106:
          if (this.xGv.field_isUseCdn != 1)
          {
            this.xGv.field_isUseCdn = 1;
            bool = com.tencent.mm.plugin.s.a.bJV().a(this.xGv, new String[0]);
            if (!bool)
            {
              ae.e("MicroMsg.NetSceneDownloadAppAttach", "summerbig checkUseCdn update info ret:".concat(String.valueOf(bool)));
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
    if (this.xGv.field_status == 102L)
    {
      this.xGv.field_status = 101L;
      if (!this.xGA) {
        com.tencent.mm.plugin.s.a.bJV().a(this.xGv, new String[0]);
      }
    }
    this.xGx = this.xGv.systemRowid;
    if ((bu.isNullOrNil(this.xGv.field_mediaSvrId)) && (this.nCM == 0L))
    {
      ae.e("MicroMsg.NetSceneDownloadAppAttach", "checkArgs : mediaId is null");
      this.retCode = (-10000 - com.tencent.mm.compatible.util.f.getLine());
      AppMethodBeat.o(9480);
      return -1;
    }
    if ((this.xGv.field_totalLen <= 0L) || (this.xGv.field_totalLen > 26214400L))
    {
      ae.e("MicroMsg.NetSceneDownloadAppAttach", "checkArgs : totalLen is invalid, totalLen = " + this.xGv.field_totalLen);
      this.retCode = (-10000 - com.tencent.mm.compatible.util.f.getLine());
      AppMethodBeat.o(9480);
      return -1;
    }
    if ((bu.isNullOrNil(this.xGv.field_fileFullPath)) && (this.nCM == 0L))
    {
      ae.e("MicroMsg.NetSceneDownloadAppAttach", "checkArgs : fileFullPath is null");
      this.retCode = (-10000 - com.tencent.mm.compatible.util.f.getLine());
      AppMethodBeat.o(9480);
      return -1;
    }
    int j = (int)o.aZR(this.xGv.field_fileFullPath);
    int i = j;
    if (this.xGC)
    {
      i = j - 6;
      if (i <= 0) {
        break label1523;
      }
    }
    while (i != this.xGv.field_offset)
    {
      ae.e("MicroMsg.NetSceneDownloadAppAttach", "checkArgs : fileFullPath is invalid, fileLength = " + i + ", info.field_offset = " + this.xGv.field_offset);
      this.retCode = (-10000 - com.tencent.mm.compatible.util.f.getLine());
      AppMethodBeat.o(9480);
      return -1;
      label1523:
      i = 0;
    }
    ae.i("MicroMsg.NetSceneDownloadAppAttach", "downing attach by non cdn, appId: %s,  mediaId: %s, sdkVer: %d", new Object[] { this.xGv.field_appId, this.xGv.field_mediaSvrId, Long.valueOf(this.xGv.field_sdkVer) });
    paramf = (afm)this.rr.hQD.hQJ;
    paramf.ikm = this.xGv.field_appId;
    paramf.ikp = this.xGv.field_mediaSvrId;
    paramf.FOQ = ((int)this.xGv.field_sdkVer);
    paramf.nIJ = v.aAC();
    paramf.xsB = ((int)this.xGv.field_totalLen);
    paramf.xsC = ((int)this.xGv.field_offset);
    paramf.xsD = 0;
    if (this.nCM != 0L) {
      paramf.xrk = this.nCM;
    }
    if (this.type != 0) {}
    for (paramf.nJA = this.type;; paramf.nJA = ((int)this.xGv.field_type))
    {
      i = dispatch(parame, this.rr, this);
      AppMethodBeat.o(9480);
      return i;
    }
  }
  
  public final String getMediaId()
  {
    if (this.xGv == null) {
      return "";
    }
    return this.xGv.field_mediaSvrId;
  }
  
  public final int getType()
  {
    return 221;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(9481);
    ae.d("MicroMsg.NetSceneDownloadAppAttach", "onGYNetEnd : errType = " + paramInt2 + ", errCode = " + paramInt3);
    if ((paramInt2 == 3) && (paramInt3 == -1) && (!bu.isNullOrNil(this.idX)))
    {
      ae.w("MicroMsg.NetSceneDownloadAppAttach", "cdntra using cdn trans,  wait cdn service callback! clientid:%s", new Object[] { this.idX });
      AppMethodBeat.o(9481);
      return;
    }
    if ((paramInt2 != 0) || (paramInt3 != 0))
    {
      ae.e("MicroMsg.NetSceneDownloadAppAttach", "onGYNetEnd : errType = " + paramInt2 + ", errCode = " + paramInt3);
      this.retCode = (-10000 - com.tencent.mm.compatible.util.f.getLine());
      if (paramInt2 == 4) {
        com.tencent.mm.plugin.report.service.g.yxI.f(10420, new Object[] { Integer.valueOf(paramInt3), Integer.valueOf(2), Long.valueOf(this.startTime), Long.valueOf(bu.fpO()), Integer.valueOf(com.tencent.mm.an.c.cC(ak.getContext())), Integer.valueOf(com.tencent.mm.i.a.MediaType_FILE), Integer.valueOf(0) });
      }
      h(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(9481);
      return;
    }
    paramString = (afn)((com.tencent.mm.ak.b)paramq).hQE.hQJ;
    this.xGv.field_totalLen = paramString.xsB;
    if ((paramString.ikp != null) && (!paramString.ikp.equals(this.xGv.field_mediaSvrId)))
    {
      ae.e("MicroMsg.NetSceneDownloadAppAttach", "argument is not consistent");
      this.retCode = (-10000 - com.tencent.mm.compatible.util.f.getLine());
      h(3, -1, "", this);
      AppMethodBeat.o(9481);
      return;
    }
    if (paramString.xsC != this.xGv.field_offset)
    {
      ae.e("MicroMsg.NetSceneDownloadAppAttach", "startPos, totalLen is incorrect startpos:" + paramString.xsC);
      this.retCode = (-10000 - com.tencent.mm.compatible.util.f.getLine());
      h(3, -1, "", this);
      AppMethodBeat.o(9481);
      return;
    }
    if (paramString.xsD + this.xGv.field_offset > this.xGv.field_totalLen)
    {
      ae.e("MicroMsg.NetSceneDownloadAppAttach", "data buffer is incorrect datalen:" + paramString.xsD + " off:" + this.xGv.field_offset + " total?:" + this.xGv.field_totalLen);
      this.retCode = (-10000 - com.tencent.mm.compatible.util.f.getLine());
      h(3, -1, "", this);
      AppMethodBeat.o(9481);
      return;
    }
    paramArrayOfByte = z.a(paramString.xsE);
    if ((paramArrayOfByte == null) || (paramArrayOfByte.length == 0) || (paramArrayOfByte.length != paramString.xsD))
    {
      ae.e("MicroMsg.NetSceneDownloadAppAttach", "data buffer is incorrect");
      this.retCode = (-10000 - com.tencent.mm.compatible.util.f.getLine());
      h(3, -1, "", this);
      AppMethodBeat.o(9481);
      return;
    }
    if (a.r(this.mediaId, this.msgId) == null)
    {
      ae.e("MicroMsg.NetSceneDownloadAppAttach", "append to file failed, msg maybe revoked or deleted. msgId:%d", new Object[] { Long.valueOf(this.xGv.field_msgInfoId) });
      this.retCode = (-10000 - com.tencent.mm.compatible.util.f.getLine());
      h(3, -1, "", this);
      AppMethodBeat.o(9481);
      return;
    }
    paramq = new String(paramArrayOfByte);
    ae.d("MicroMsg.NetSceneDownloadAppAttach", "dancy download big appmsg : %s", new Object[] { Boolean.valueOf(this.xGB) });
    bv localbv;
    StringBuffer localStringBuffer;
    if ((this.xGv.field_offset < this.xGv.field_totalLen) && (this.xGB))
    {
      localbv = ((l)com.tencent.mm.kernel.g.ab(l.class)).doJ().ys(this.xGv.field_msgInfoId);
      paramString = paramq;
      if (paramq.startsWith("<?xml version="))
      {
        paramInt1 = paramq.indexOf("<appmsg");
        ae.i("MicroMsg.NetSceneDownloadAppAttach", "inclued: <?xml version=  index:%s", new Object[] { Integer.valueOf(paramInt1) });
        paramString = paramq;
        if (paramInt1 > 0) {
          paramString = paramq.substring(paramInt1);
        }
      }
      if (!paramString.startsWith("<appmsg")) {
        break label1044;
      }
      if (!x.wb(localbv.field_talker)) {
        break label1032;
      }
      if (!bu.isNullOrNil(localbv.field_content))
      {
        paramq = localbv.field_content.split("\n", 2)[0];
        localStringBuffer = new StringBuffer();
        this.xGv.field_fullXml = (paramq + "\n");
        paramq = new StringBuffer();
        paramq.append(this.xGv.field_fullXml).append(paramString);
        this.xGv.field_fullXml = paramq.toString();
      }
    }
    for (;;)
    {
      localbv.setContent(this.xGv.field_fullXml);
      ((l)com.tencent.mm.kernel.g.ab(l.class)).doJ().a(this.xGv.field_msgInfoId, localbv);
      ae.d("MicroMsg.NetSceneDownloadAppAttach", "dancy download full xml succed! xml: [%s]", new Object[] { paramString });
      paramInt1 = o.e(this.xGv.field_fileFullPath, paramArrayOfByte, paramArrayOfByte.length);
      if ((bu.isNullOrNil(this.xGv.field_fileFullPath)) || (paramInt1 == 0)) {
        break;
      }
      ae.e("MicroMsg.NetSceneDownloadAppAttach", "append to file failed:".concat(String.valueOf(paramInt1)));
      this.retCode = (-10000 - com.tencent.mm.compatible.util.f.getLine());
      h(3, -1, "", this);
      AppMethodBeat.o(9481);
      return;
      label1032:
      this.xGv.field_fullXml = paramString;
      continue;
      label1044:
      if (!localbv.field_content.startsWith("<msg>"))
      {
        paramq = new StringBuffer();
        paramq.append(localbv.field_content).append(paramString);
        this.xGv.field_fullXml = paramq.toString();
      }
      if ((paramString.endsWith("</appmsg>")) || (this.xGv.field_offset + paramArrayOfByte.length == this.xGv.field_totalLen))
      {
        if (x.wb(localbv.field_talker))
        {
          paramq = localbv.field_content.split("\n", 2);
          Object localObject = paramq[0];
          localStringBuffer = new StringBuffer();
          localObject = localStringBuffer.append((String)localObject).append("\n<msg>");
          if (paramq.length > 1) {}
          for (paramq = paramq[1];; paramq = "")
          {
            ((StringBuffer)localObject).append(paramq).append(paramString).append("</msg>");
            this.xGv.field_fullXml = localStringBuffer.toString();
            break;
          }
        }
        paramq = new StringBuffer();
        paramq.append("<msg>").append(this.xGv.field_fullXml).append("</msg>");
        this.xGv.field_fullXml = paramq.toString();
      }
    }
    paramString = this.xGv;
    long l = paramString.field_offset;
    paramString.field_offset = (paramArrayOfByte.length + l);
    if (this.xGv.field_offset == this.xGv.field_totalLen) {
      this.xGv.field_status = 199L;
    }
    if (this.idS != null) {
      ar.f(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(9474);
          f.this.idS.a((int)f.this.xGv.field_offset, (int)f.this.xGv.field_totalLen, f.this);
          AppMethodBeat.o(9474);
        }
      });
    }
    if (this.xGA) {}
    for (boolean bool = true; !bool; bool = com.tencent.mm.plugin.s.a.bJV().a(this.xGv, new String[0]))
    {
      ae.e("MicroMsg.NetSceneDownloadAppAttach", "onGYNetEnd update info ret:".concat(String.valueOf(paramInt1)));
      this.retCode = (-10000 - com.tencent.mm.compatible.util.f.getLine());
      h(3, -1, "", this);
      AppMethodBeat.o(9481);
      return;
    }
    if (this.xGv.field_status == 199L)
    {
      com.tencent.mm.plugin.report.service.g.yxI.f(10420, new Object[] { Integer.valueOf(0), Integer.valueOf(2), Long.valueOf(this.startTime), Long.valueOf(bu.fpO()), Integer.valueOf(com.tencent.mm.an.c.cC(ak.getContext())), Integer.valueOf(com.tencent.mm.i.a.MediaType_FILE), Long.valueOf(this.xGv.field_totalLen - this.xGy) });
      paramString = ((l)com.tencent.mm.kernel.g.ab(l.class)).doJ().ys(this.xGv.field_msgInfoId);
      ((l)com.tencent.mm.kernel.g.ab(l.class)).doJ().a(new i.c(paramString.field_talker, "update", paramString));
      h(0, 0, "", this);
      AppMethodBeat.o(9481);
      return;
    }
    if (this.xGv.field_status == 102L)
    {
      h(3, -1, "", this);
      this.retCode = -20102;
      AppMethodBeat.o(9481);
      return;
    }
    if (doScene(dispatcher(), this.callback) < 0)
    {
      ae.e("MicroMsg.NetSceneDownloadAppAttach", "onGYNetEnd : doScene fail");
      h(3, -1, "", this);
    }
    AppMethodBeat.o(9481);
  }
  
  public final int securityLimitCount()
  {
    return 400;
  }
  
  public final n.b securityVerificationChecked(q paramq)
  {
    return n.b.hRi;
  }
  
  public static abstract interface a
  {
    public abstract void dHA();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.record.b.f
 * JD-Core Version:    0.7.0.1
 */