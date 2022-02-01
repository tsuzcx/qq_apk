package com.tencent.mm.plugin.record.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.k.b;
import com.tencent.mm.al.b.b;
import com.tencent.mm.al.b.c;
import com.tencent.mm.al.n;
import com.tencent.mm.al.n.b;
import com.tencent.mm.g.b.a.h;
import com.tencent.mm.g.b.a.j;
import com.tencent.mm.g.c.ei;
import com.tencent.mm.i.g.a;
import com.tencent.mm.model.bj;
import com.tencent.mm.model.u;
import com.tencent.mm.model.w;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.platformtools.z;
import com.tencent.mm.plugin.messenger.foundation.a.a.i.c;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.protocal.protobuf.afd;
import com.tencent.mm.protocal.protobuf.afe;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.bu;
import java.io.ByteArrayOutputStream;

public final class f
  extends n
  implements k
{
  private com.tencent.mm.al.f callback;
  bu dBd;
  com.tencent.mm.al.g iaZ;
  String ibe;
  private g.a ibn;
  private String mediaId;
  public long msgId;
  private long nxr;
  public boolean pmU;
  public int retCode;
  private com.tencent.mm.al.b rr;
  long startTime;
  private int type;
  public long xqA;
  private int xqB;
  String xqC;
  private boolean xqD;
  private boolean xqE;
  private boolean xqF;
  com.tencent.mm.pluginsdk.model.app.c xqy;
  
  public f(long paramLong1, long paramLong2, com.tencent.mm.al.g paramg)
  {
    AppMethodBeat.i(9475);
    this.xqy = null;
    this.xqA = -1L;
    this.mediaId = "";
    this.msgId = 0L;
    this.dBd = null;
    this.ibe = "";
    this.startTime = 0L;
    this.xqB = -1;
    this.xqC = "";
    this.type = 0;
    this.retCode = 0;
    this.xqD = false;
    this.xqE = false;
    this.nxr = 0L;
    this.pmU = false;
    this.xqF = false;
    this.ibn = new g.a()
    {
      public final int a(String paramAnonymousString, final int paramAnonymousInt, com.tencent.mm.i.c paramAnonymousc, final com.tencent.mm.i.d paramAnonymousd, boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(9473);
        if (paramAnonymousc == null) {}
        for (paramAnonymousBoolean = true;; paramAnonymousBoolean = false)
        {
          ad.d("MicroMsg.NetSceneDownloadAppAttach", "summerbig callback mediaId[%s], startRet[%d], progressInfo[%s], sceneResult[%s], finish[%b]", new Object[] { paramAnonymousString, Integer.valueOf(paramAnonymousInt), paramAnonymousc, paramAnonymousd, Boolean.valueOf(paramAnonymousBoolean) });
          if (paramAnonymousInt != -21006) {
            break;
          }
          ad.i("MicroMsg.NetSceneDownloadAppAttach", "summerbig callback cdntra  ERR_CNDCOM_MEDIA_IS_DOWNLOADING clientid:%s", new Object[] { f.this.ibe });
          AppMethodBeat.o(9473);
          return 0;
        }
        if (paramAnonymousInt != 0)
        {
          a.yD(f.this.xqy.systemRowid);
          new j(com.tencent.mm.plugin.report.a.u(new Object[] { Integer.valueOf(paramAnonymousInt), Integer.valueOf(2), Long.valueOf(f.this.startTime), Long.valueOf(bt.flT()), Integer.valueOf(com.tencent.mm.ao.c.cA(aj.getContext())), Integer.valueOf(com.tencent.mm.i.a.MediaType_FILE), Integer.valueOf(0), "" })).aLk();
          aq.f(new Runnable()
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
        f.this.xqy = a.r(paramAnonymousString, f.this.msgId);
        if (f.this.xqy == null)
        {
          ad.e("MicroMsg.NetSceneDownloadAppAttach", "summerbig attachInfo is null");
          aq.f(new Runnable()
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
        if (f.this.xqy.field_status == 102L)
        {
          ad.i("MicroMsg.NetSceneDownloadAppAttach", "summerbig dancy attach download has paused, status:%d", new Object[] { Long.valueOf(f.this.xqy.field_status) });
          com.tencent.mm.ao.f.aGI().EP(f.this.ibe);
          aq.f(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(9467);
              f.a(f.this, 3, paramAnonymousInt, "attach  has paused, status=" + f.this.xqy.field_status, f.this);
              AppMethodBeat.o(9467);
            }
          });
          AppMethodBeat.o(9473);
          return 0;
        }
        if (paramAnonymousc != null)
        {
          if (paramAnonymousc.field_finishedLength == f.this.xqy.field_totalLen)
          {
            ad.i("MicroMsg.NetSceneDownloadAppAttach", "summerbig callback cdntra ignore progress 100%");
            AppMethodBeat.o(9473);
            return 0;
          }
          if (f.this.xqy.field_offset > paramAnonymousc.field_finishedLength)
          {
            ad.e("MicroMsg.NetSceneDownloadAppAttach", "summerbig callback cdnEndProc error oldpos:%d newpos:%d", new Object[] { Long.valueOf(f.this.xqy.field_offset), Long.valueOf(paramAnonymousc.field_finishedLength) });
            a.yD(f.this.xqy.systemRowid);
            aq.f(new Runnable()
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
          f.this.xqy.field_offset = paramAnonymousc.field_finishedLength;
          com.tencent.mm.plugin.s.a.bIX().a(f.this.xqy, new String[0]);
          if (f.this.iaZ != null) {
            aq.f(new Runnable()
            {
              public final void run()
              {
                AppMethodBeat.i(9469);
                f.this.iaZ.a((int)f.this.xqy.field_offset, (int)f.this.xqy.field_totalLen, f.this);
                AppMethodBeat.o(9469);
              }
            });
          }
          ad.d("MicroMsg.NetSceneDownloadAppAttach", "summerbig callback cdntra progresscallback id:%s finish:%d total:%d", new Object[] { f.this.ibe, Long.valueOf(paramAnonymousc.field_finishedLength), Long.valueOf(paramAnonymousc.field_toltalLength) });
          AppMethodBeat.o(9473);
          return 0;
        }
        if (paramAnonymousd != null)
        {
          if (paramAnonymousd.field_retCode == 0) {
            break label1001;
          }
          a.yD(f.this.xqy.systemRowid);
          ad.e("MicroMsg.NetSceneDownloadAppAttach", "summerbig callback cdntra sceneResult.retCode :%d", new Object[] { Integer.valueOf(paramAnonymousd.field_retCode) });
          new j(com.tencent.mm.plugin.report.a.u(new Object[] { Integer.valueOf(paramAnonymousd.field_retCode), Integer.valueOf(2), Long.valueOf(f.this.startTime), Long.valueOf(bt.flT()), Integer.valueOf(com.tencent.mm.ao.c.cA(aj.getContext())), Integer.valueOf(com.tencent.mm.i.a.MediaType_FILE), Long.valueOf(f.this.xqy.field_totalLen), paramAnonymousd.field_transInfo, "", "", "", "", "", "", "", paramAnonymousd.fIT })).aLk();
          if (paramAnonymousd.field_retCode != 0) {
            new h(com.tencent.mm.plugin.report.a.u(new Object[] { Integer.valueOf(paramAnonymousd.field_retCode), Integer.valueOf(2), Long.valueOf(f.this.startTime), Long.valueOf(bt.flT()), Integer.valueOf(com.tencent.mm.ao.c.cA(aj.getContext())), Integer.valueOf(com.tencent.mm.i.a.MediaType_FILE), Long.valueOf(f.this.xqy.field_totalLen), paramAnonymousd.field_transInfo, "", "", "", "", "", "", "", paramAnonymousd.fIT })).aLk();
          }
          if (f.this.iaZ != null) {
            aq.f(new Runnable()
            {
              public final void run()
              {
                AppMethodBeat.i(9470);
                f.this.iaZ.a((int)f.this.xqy.field_offset, (int)f.this.xqy.field_totalLen, f.this);
                AppMethodBeat.o(9470);
              }
            });
          }
          if (paramAnonymousd.field_retCode == 0) {
            break label1293;
          }
          aq.f(new Runnable()
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
          new com.tencent.mm.vfs.e(f.this.xqC).ag(new com.tencent.mm.vfs.e(f.this.xqy.field_fileFullPath));
          f.this.xqy.field_status = 199L;
          f.this.xqy.field_offset = f.this.xqy.field_totalLen;
          com.tencent.mm.plugin.s.a.bIX().a(f.this.xqy, new String[0]);
          com.tencent.mm.plugin.report.service.g.yhR.idkeyStat(198L, 45L, f.this.xqy.field_totalLen, false);
          com.tencent.mm.plugin.report.service.g.yhR.idkeyStat(198L, 46L, 1L, false);
          paramAnonymousc = com.tencent.mm.plugin.report.service.g.yhR;
          if (f.this.dBd == null)
          {
            paramAnonymousString = "";
            label1141:
            if (!w.vF(paramAnonymousString)) {
              break label1248;
            }
          }
          label1248:
          for (long l = 48L;; l = 47L)
          {
            paramAnonymousc.idkeyStat(198L, l, 1L, false);
            paramAnonymousString = ((l)com.tencent.mm.kernel.g.ab(l.class)).dlK().xY(f.this.xqy.field_msgInfoId);
            if (paramAnonymousString.field_status != 5) {
              break label1256;
            }
            paramAnonymousString.setStatus(3);
            ((l)com.tencent.mm.kernel.g.ab(l.class)).dlK().a(paramAnonymousString.field_msgId, paramAnonymousString);
            break;
            paramAnonymousString = f.this.dBd.field_talker;
            break label1141;
          }
          label1256:
          ((l)com.tencent.mm.kernel.g.ab(l.class)).dlK().a(new i.c(paramAnonymousString.field_talker, "update", paramAnonymousString));
          break;
          label1293:
          aq.f(new Runnable()
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
    this.nxr = paramLong2;
    this.msgId = paramLong1;
    this.xqy = com.tencent.mm.plugin.s.a.bIX().CB(paramLong1);
    this.iaZ = paramg;
    this.xqE = true;
    if (this.xqy == null)
    {
      ad.e("MicroMsg.NetSceneDownloadAppAttach", "big appMsg, info is null, msgid = , svrId".concat(String.valueOf(paramLong1)), new Object[] { Long.valueOf(paramLong2) });
      AppMethodBeat.o(9475);
      return;
    }
    paramg = new com.tencent.mm.al.b.a();
    paramg.hNM = new afd();
    paramg.hNN = new afe();
    paramg.uri = "/cgi-bin/micromsg-bin/downloadappattach";
    paramg.funcId = 221;
    paramg.hNO = 106;
    paramg.respCmdId = 1000000106;
    this.rr = paramg.aDC();
    AppMethodBeat.o(9475);
  }
  
  public f(long paramLong, String paramString, com.tencent.mm.al.g paramg)
  {
    this(paramString, paramLong, paramg);
    this.msgId = paramLong;
  }
  
  public f(com.tencent.mm.pluginsdk.model.app.c paramc)
  {
    AppMethodBeat.i(9476);
    this.xqy = null;
    this.xqA = -1L;
    this.mediaId = "";
    this.msgId = 0L;
    this.dBd = null;
    this.ibe = "";
    this.startTime = 0L;
    this.xqB = -1;
    this.xqC = "";
    this.type = 0;
    this.retCode = 0;
    this.xqD = false;
    this.xqE = false;
    this.nxr = 0L;
    this.pmU = false;
    this.xqF = false;
    this.ibn = new g.a()
    {
      public final int a(String paramAnonymousString, final int paramAnonymousInt, com.tencent.mm.i.c paramAnonymousc, final com.tencent.mm.i.d paramAnonymousd, boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(9473);
        if (paramAnonymousc == null) {}
        for (paramAnonymousBoolean = true;; paramAnonymousBoolean = false)
        {
          ad.d("MicroMsg.NetSceneDownloadAppAttach", "summerbig callback mediaId[%s], startRet[%d], progressInfo[%s], sceneResult[%s], finish[%b]", new Object[] { paramAnonymousString, Integer.valueOf(paramAnonymousInt), paramAnonymousc, paramAnonymousd, Boolean.valueOf(paramAnonymousBoolean) });
          if (paramAnonymousInt != -21006) {
            break;
          }
          ad.i("MicroMsg.NetSceneDownloadAppAttach", "summerbig callback cdntra  ERR_CNDCOM_MEDIA_IS_DOWNLOADING clientid:%s", new Object[] { f.this.ibe });
          AppMethodBeat.o(9473);
          return 0;
        }
        if (paramAnonymousInt != 0)
        {
          a.yD(f.this.xqy.systemRowid);
          new j(com.tencent.mm.plugin.report.a.u(new Object[] { Integer.valueOf(paramAnonymousInt), Integer.valueOf(2), Long.valueOf(f.this.startTime), Long.valueOf(bt.flT()), Integer.valueOf(com.tencent.mm.ao.c.cA(aj.getContext())), Integer.valueOf(com.tencent.mm.i.a.MediaType_FILE), Integer.valueOf(0), "" })).aLk();
          aq.f(new Runnable()
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
        f.this.xqy = a.r(paramAnonymousString, f.this.msgId);
        if (f.this.xqy == null)
        {
          ad.e("MicroMsg.NetSceneDownloadAppAttach", "summerbig attachInfo is null");
          aq.f(new Runnable()
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
        if (f.this.xqy.field_status == 102L)
        {
          ad.i("MicroMsg.NetSceneDownloadAppAttach", "summerbig dancy attach download has paused, status:%d", new Object[] { Long.valueOf(f.this.xqy.field_status) });
          com.tencent.mm.ao.f.aGI().EP(f.this.ibe);
          aq.f(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(9467);
              f.a(f.this, 3, paramAnonymousInt, "attach  has paused, status=" + f.this.xqy.field_status, f.this);
              AppMethodBeat.o(9467);
            }
          });
          AppMethodBeat.o(9473);
          return 0;
        }
        if (paramAnonymousc != null)
        {
          if (paramAnonymousc.field_finishedLength == f.this.xqy.field_totalLen)
          {
            ad.i("MicroMsg.NetSceneDownloadAppAttach", "summerbig callback cdntra ignore progress 100%");
            AppMethodBeat.o(9473);
            return 0;
          }
          if (f.this.xqy.field_offset > paramAnonymousc.field_finishedLength)
          {
            ad.e("MicroMsg.NetSceneDownloadAppAttach", "summerbig callback cdnEndProc error oldpos:%d newpos:%d", new Object[] { Long.valueOf(f.this.xqy.field_offset), Long.valueOf(paramAnonymousc.field_finishedLength) });
            a.yD(f.this.xqy.systemRowid);
            aq.f(new Runnable()
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
          f.this.xqy.field_offset = paramAnonymousc.field_finishedLength;
          com.tencent.mm.plugin.s.a.bIX().a(f.this.xqy, new String[0]);
          if (f.this.iaZ != null) {
            aq.f(new Runnable()
            {
              public final void run()
              {
                AppMethodBeat.i(9469);
                f.this.iaZ.a((int)f.this.xqy.field_offset, (int)f.this.xqy.field_totalLen, f.this);
                AppMethodBeat.o(9469);
              }
            });
          }
          ad.d("MicroMsg.NetSceneDownloadAppAttach", "summerbig callback cdntra progresscallback id:%s finish:%d total:%d", new Object[] { f.this.ibe, Long.valueOf(paramAnonymousc.field_finishedLength), Long.valueOf(paramAnonymousc.field_toltalLength) });
          AppMethodBeat.o(9473);
          return 0;
        }
        if (paramAnonymousd != null)
        {
          if (paramAnonymousd.field_retCode == 0) {
            break label1001;
          }
          a.yD(f.this.xqy.systemRowid);
          ad.e("MicroMsg.NetSceneDownloadAppAttach", "summerbig callback cdntra sceneResult.retCode :%d", new Object[] { Integer.valueOf(paramAnonymousd.field_retCode) });
          new j(com.tencent.mm.plugin.report.a.u(new Object[] { Integer.valueOf(paramAnonymousd.field_retCode), Integer.valueOf(2), Long.valueOf(f.this.startTime), Long.valueOf(bt.flT()), Integer.valueOf(com.tencent.mm.ao.c.cA(aj.getContext())), Integer.valueOf(com.tencent.mm.i.a.MediaType_FILE), Long.valueOf(f.this.xqy.field_totalLen), paramAnonymousd.field_transInfo, "", "", "", "", "", "", "", paramAnonymousd.fIT })).aLk();
          if (paramAnonymousd.field_retCode != 0) {
            new h(com.tencent.mm.plugin.report.a.u(new Object[] { Integer.valueOf(paramAnonymousd.field_retCode), Integer.valueOf(2), Long.valueOf(f.this.startTime), Long.valueOf(bt.flT()), Integer.valueOf(com.tencent.mm.ao.c.cA(aj.getContext())), Integer.valueOf(com.tencent.mm.i.a.MediaType_FILE), Long.valueOf(f.this.xqy.field_totalLen), paramAnonymousd.field_transInfo, "", "", "", "", "", "", "", paramAnonymousd.fIT })).aLk();
          }
          if (f.this.iaZ != null) {
            aq.f(new Runnable()
            {
              public final void run()
              {
                AppMethodBeat.i(9470);
                f.this.iaZ.a((int)f.this.xqy.field_offset, (int)f.this.xqy.field_totalLen, f.this);
                AppMethodBeat.o(9470);
              }
            });
          }
          if (paramAnonymousd.field_retCode == 0) {
            break label1293;
          }
          aq.f(new Runnable()
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
          new com.tencent.mm.vfs.e(f.this.xqC).ag(new com.tencent.mm.vfs.e(f.this.xqy.field_fileFullPath));
          f.this.xqy.field_status = 199L;
          f.this.xqy.field_offset = f.this.xqy.field_totalLen;
          com.tencent.mm.plugin.s.a.bIX().a(f.this.xqy, new String[0]);
          com.tencent.mm.plugin.report.service.g.yhR.idkeyStat(198L, 45L, f.this.xqy.field_totalLen, false);
          com.tencent.mm.plugin.report.service.g.yhR.idkeyStat(198L, 46L, 1L, false);
          paramAnonymousc = com.tencent.mm.plugin.report.service.g.yhR;
          if (f.this.dBd == null)
          {
            paramAnonymousString = "";
            label1141:
            if (!w.vF(paramAnonymousString)) {
              break label1248;
            }
          }
          label1248:
          for (long l = 48L;; l = 47L)
          {
            paramAnonymousc.idkeyStat(198L, l, 1L, false);
            paramAnonymousString = ((l)com.tencent.mm.kernel.g.ab(l.class)).dlK().xY(f.this.xqy.field_msgInfoId);
            if (paramAnonymousString.field_status != 5) {
              break label1256;
            }
            paramAnonymousString.setStatus(3);
            ((l)com.tencent.mm.kernel.g.ab(l.class)).dlK().a(paramAnonymousString.field_msgId, paramAnonymousString);
            break;
            paramAnonymousString = f.this.dBd.field_talker;
            break label1141;
          }
          label1256:
          ((l)com.tencent.mm.kernel.g.ab(l.class)).dlK().a(new i.c(paramAnonymousString.field_talker, "update", paramAnonymousString));
          break;
          label1293:
          aq.f(new Runnable()
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
    this.xqy = paramc;
    this.xqD = true;
    this.mediaId = this.xqy.field_mediaId;
    this.iaZ = null;
    this.type = 0;
    if (paramc == null)
    {
      ad.e("MicroMsg.NetSceneDownloadAppAttach", "summerbig <init>, info is null, mediaId = " + this.mediaId);
      AppMethodBeat.o(9476);
      return;
    }
    com.tencent.mm.al.b.a locala = new com.tencent.mm.al.b.a();
    locala.hNM = new afd();
    locala.hNN = new afe();
    locala.uri = "/cgi-bin/micromsg-bin/downloadappattach";
    locala.funcId = 221;
    locala.hNO = 106;
    locala.respCmdId = 1000000106;
    this.rr = locala.aDC();
    ad.i("MicroMsg.NetSceneDownloadAppAttach", "summerbig NetSceneDownloadAppAttach info fullpath[%s], justSaveFile[%b], stack[%s]", new Object[] { paramc.field_fileFullPath, Boolean.TRUE, bt.flS() });
    AppMethodBeat.o(9476);
  }
  
  public f(String paramString)
  {
    this(paramString, 0L, null);
  }
  
  private f(String paramString, long paramLong, com.tencent.mm.al.g paramg)
  {
    AppMethodBeat.i(9477);
    this.xqy = null;
    this.xqA = -1L;
    this.mediaId = "";
    this.msgId = 0L;
    this.dBd = null;
    this.ibe = "";
    this.startTime = 0L;
    this.xqB = -1;
    this.xqC = "";
    this.type = 0;
    this.retCode = 0;
    this.xqD = false;
    this.xqE = false;
    this.nxr = 0L;
    this.pmU = false;
    this.xqF = false;
    this.ibn = new g.a()
    {
      public final int a(String paramAnonymousString, final int paramAnonymousInt, com.tencent.mm.i.c paramAnonymousc, final com.tencent.mm.i.d paramAnonymousd, boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(9473);
        if (paramAnonymousc == null) {}
        for (paramAnonymousBoolean = true;; paramAnonymousBoolean = false)
        {
          ad.d("MicroMsg.NetSceneDownloadAppAttach", "summerbig callback mediaId[%s], startRet[%d], progressInfo[%s], sceneResult[%s], finish[%b]", new Object[] { paramAnonymousString, Integer.valueOf(paramAnonymousInt), paramAnonymousc, paramAnonymousd, Boolean.valueOf(paramAnonymousBoolean) });
          if (paramAnonymousInt != -21006) {
            break;
          }
          ad.i("MicroMsg.NetSceneDownloadAppAttach", "summerbig callback cdntra  ERR_CNDCOM_MEDIA_IS_DOWNLOADING clientid:%s", new Object[] { f.this.ibe });
          AppMethodBeat.o(9473);
          return 0;
        }
        if (paramAnonymousInt != 0)
        {
          a.yD(f.this.xqy.systemRowid);
          new j(com.tencent.mm.plugin.report.a.u(new Object[] { Integer.valueOf(paramAnonymousInt), Integer.valueOf(2), Long.valueOf(f.this.startTime), Long.valueOf(bt.flT()), Integer.valueOf(com.tencent.mm.ao.c.cA(aj.getContext())), Integer.valueOf(com.tencent.mm.i.a.MediaType_FILE), Integer.valueOf(0), "" })).aLk();
          aq.f(new Runnable()
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
        f.this.xqy = a.r(paramAnonymousString, f.this.msgId);
        if (f.this.xqy == null)
        {
          ad.e("MicroMsg.NetSceneDownloadAppAttach", "summerbig attachInfo is null");
          aq.f(new Runnable()
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
        if (f.this.xqy.field_status == 102L)
        {
          ad.i("MicroMsg.NetSceneDownloadAppAttach", "summerbig dancy attach download has paused, status:%d", new Object[] { Long.valueOf(f.this.xqy.field_status) });
          com.tencent.mm.ao.f.aGI().EP(f.this.ibe);
          aq.f(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(9467);
              f.a(f.this, 3, paramAnonymousInt, "attach  has paused, status=" + f.this.xqy.field_status, f.this);
              AppMethodBeat.o(9467);
            }
          });
          AppMethodBeat.o(9473);
          return 0;
        }
        if (paramAnonymousc != null)
        {
          if (paramAnonymousc.field_finishedLength == f.this.xqy.field_totalLen)
          {
            ad.i("MicroMsg.NetSceneDownloadAppAttach", "summerbig callback cdntra ignore progress 100%");
            AppMethodBeat.o(9473);
            return 0;
          }
          if (f.this.xqy.field_offset > paramAnonymousc.field_finishedLength)
          {
            ad.e("MicroMsg.NetSceneDownloadAppAttach", "summerbig callback cdnEndProc error oldpos:%d newpos:%d", new Object[] { Long.valueOf(f.this.xqy.field_offset), Long.valueOf(paramAnonymousc.field_finishedLength) });
            a.yD(f.this.xqy.systemRowid);
            aq.f(new Runnable()
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
          f.this.xqy.field_offset = paramAnonymousc.field_finishedLength;
          com.tencent.mm.plugin.s.a.bIX().a(f.this.xqy, new String[0]);
          if (f.this.iaZ != null) {
            aq.f(new Runnable()
            {
              public final void run()
              {
                AppMethodBeat.i(9469);
                f.this.iaZ.a((int)f.this.xqy.field_offset, (int)f.this.xqy.field_totalLen, f.this);
                AppMethodBeat.o(9469);
              }
            });
          }
          ad.d("MicroMsg.NetSceneDownloadAppAttach", "summerbig callback cdntra progresscallback id:%s finish:%d total:%d", new Object[] { f.this.ibe, Long.valueOf(paramAnonymousc.field_finishedLength), Long.valueOf(paramAnonymousc.field_toltalLength) });
          AppMethodBeat.o(9473);
          return 0;
        }
        if (paramAnonymousd != null)
        {
          if (paramAnonymousd.field_retCode == 0) {
            break label1001;
          }
          a.yD(f.this.xqy.systemRowid);
          ad.e("MicroMsg.NetSceneDownloadAppAttach", "summerbig callback cdntra sceneResult.retCode :%d", new Object[] { Integer.valueOf(paramAnonymousd.field_retCode) });
          new j(com.tencent.mm.plugin.report.a.u(new Object[] { Integer.valueOf(paramAnonymousd.field_retCode), Integer.valueOf(2), Long.valueOf(f.this.startTime), Long.valueOf(bt.flT()), Integer.valueOf(com.tencent.mm.ao.c.cA(aj.getContext())), Integer.valueOf(com.tencent.mm.i.a.MediaType_FILE), Long.valueOf(f.this.xqy.field_totalLen), paramAnonymousd.field_transInfo, "", "", "", "", "", "", "", paramAnonymousd.fIT })).aLk();
          if (paramAnonymousd.field_retCode != 0) {
            new h(com.tencent.mm.plugin.report.a.u(new Object[] { Integer.valueOf(paramAnonymousd.field_retCode), Integer.valueOf(2), Long.valueOf(f.this.startTime), Long.valueOf(bt.flT()), Integer.valueOf(com.tencent.mm.ao.c.cA(aj.getContext())), Integer.valueOf(com.tencent.mm.i.a.MediaType_FILE), Long.valueOf(f.this.xqy.field_totalLen), paramAnonymousd.field_transInfo, "", "", "", "", "", "", "", paramAnonymousd.fIT })).aLk();
          }
          if (f.this.iaZ != null) {
            aq.f(new Runnable()
            {
              public final void run()
              {
                AppMethodBeat.i(9470);
                f.this.iaZ.a((int)f.this.xqy.field_offset, (int)f.this.xqy.field_totalLen, f.this);
                AppMethodBeat.o(9470);
              }
            });
          }
          if (paramAnonymousd.field_retCode == 0) {
            break label1293;
          }
          aq.f(new Runnable()
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
          new com.tencent.mm.vfs.e(f.this.xqC).ag(new com.tencent.mm.vfs.e(f.this.xqy.field_fileFullPath));
          f.this.xqy.field_status = 199L;
          f.this.xqy.field_offset = f.this.xqy.field_totalLen;
          com.tencent.mm.plugin.s.a.bIX().a(f.this.xqy, new String[0]);
          com.tencent.mm.plugin.report.service.g.yhR.idkeyStat(198L, 45L, f.this.xqy.field_totalLen, false);
          com.tencent.mm.plugin.report.service.g.yhR.idkeyStat(198L, 46L, 1L, false);
          paramAnonymousc = com.tencent.mm.plugin.report.service.g.yhR;
          if (f.this.dBd == null)
          {
            paramAnonymousString = "";
            label1141:
            if (!w.vF(paramAnonymousString)) {
              break label1248;
            }
          }
          label1248:
          for (long l = 48L;; l = 47L)
          {
            paramAnonymousc.idkeyStat(198L, l, 1L, false);
            paramAnonymousString = ((l)com.tencent.mm.kernel.g.ab(l.class)).dlK().xY(f.this.xqy.field_msgInfoId);
            if (paramAnonymousString.field_status != 5) {
              break label1256;
            }
            paramAnonymousString.setStatus(3);
            ((l)com.tencent.mm.kernel.g.ab(l.class)).dlK().a(paramAnonymousString.field_msgId, paramAnonymousString);
            break;
            paramAnonymousString = f.this.dBd.field_talker;
            break label1141;
          }
          label1256:
          ((l)com.tencent.mm.kernel.g.ab(l.class)).dlK().a(new i.c(paramAnonymousString.field_talker, "update", paramAnonymousString));
          break;
          label1293:
          aq.f(new Runnable()
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
    this.iaZ = paramg;
    this.type = 0;
    this.xqy = com.tencent.mm.plugin.s.a.bIX().aLD(paramString);
    if (this.xqy == null) {
      this.xqy = com.tencent.mm.plugin.s.a.bIX().CB(paramLong);
    }
    if (this.xqy == null)
    {
      ad.e("MicroMsg.NetSceneDownloadAppAttach", "summerbig <init>, info is null, mediaId = ".concat(String.valueOf(paramString)));
      AppMethodBeat.o(9477);
      return;
    }
    paramString = new com.tencent.mm.al.b.a();
    paramString.hNM = new afd();
    paramString.hNN = new afe();
    paramString.uri = "/cgi-bin/micromsg-bin/downloadappattach";
    paramString.funcId = 221;
    paramString.hNO = 106;
    paramString.respCmdId = 1000000106;
    this.rr = paramString.aDC();
    ad.d("MicroMsg.NetSceneDownloadAppAttach", "summerbig NetSceneDownloadAppAttach , type[%d], info fullpath[%s], field_type[%d], signature[%s], stack[%s]", new Object[] { Integer.valueOf(0), this.xqy.field_fileFullPath, Long.valueOf(this.xqy.field_type), this.xqy.field_signature, bt.flS() });
    AppMethodBeat.o(9477);
  }
  
  private void h(int paramInt1, int paramInt2, String paramString, n paramn)
  {
    AppMethodBeat.i(9482);
    if (this.callback != null)
    {
      this.callback.onSceneEnd(paramInt1, paramInt2, paramString, paramn);
      if (this.xqy != null)
      {
        long l = this.xqy.field_msgInfoId;
        paramString = ((l)com.tencent.mm.kernel.g.ab(l.class)).dlK().xY(l);
        if ((paramInt1 == 0) && (paramInt2 == 0))
        {
          ((com.tencent.mm.plugin.comm.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.comm.a.b.class)).a(this.pmU, String.valueOf(l), paramString.field_msgSvrId, true);
          AppMethodBeat.o(9482);
          return;
        }
        ((com.tencent.mm.plugin.comm.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.comm.a.b.class)).a(this.pmU, String.valueOf(l), paramString.field_msgSvrId, false);
      }
    }
    AppMethodBeat.o(9482);
  }
  
  public final void a(a parama)
  {
    AppMethodBeat.i(9479);
    if (!this.xqD)
    {
      com.tencent.mm.ao.f.aGI().EQ(this.ibe);
      this.xqy = com.tencent.mm.plugin.s.a.bIX().CB(this.msgId);
      if (this.xqy == null)
      {
        ad.i("MicroMsg.NetSceneDownloadAppAttach", "pause get by msgid  %是is null then get by mediaId %s", new Object[] { Long.valueOf(this.msgId), this.mediaId });
        this.xqy = com.tencent.mm.plugin.s.a.bIX().aLD(this.mediaId);
      }
    }
    ad.i("MicroMsg.NetSceneDownloadAppAttach", "summerbig pause listener[%s], info[%s], justSaveFile[%b], stack[%s]", new Object[] { parama, this.xqy, Boolean.valueOf(this.xqD), bt.flS() });
    if (this.xqy == null)
    {
      AppMethodBeat.o(9479);
      return;
    }
    if ((this.xqy.field_status == 101L) && (parama != null)) {
      parama.dEj();
    }
    this.xqy.field_status = 102L;
    if (!this.xqD) {
      ad.i("MicroMsg.NetSceneDownloadAppAttach", "pause done %s", new Object[] { Boolean.valueOf(com.tencent.mm.plugin.s.a.bIX().a(this.xqy, new String[0])) });
    }
    AppMethodBeat.o(9479);
  }
  
  public final void dEi()
  {
    AppMethodBeat.i(9478);
    this.xqF = true;
    if (this.xqF)
    {
      String str = this.xqy.field_fileFullPath;
      byte[] arrayOfByte = "#!AMR\n".getBytes();
      com.tencent.mm.vfs.i.e(str, arrayOfByte, arrayOfByte.length);
    }
    AppMethodBeat.o(9478);
  }
  
  public final int doScene(com.tencent.mm.network.e parame, com.tencent.mm.al.f paramf)
  {
    AppMethodBeat.i(9480);
    this.callback = paramf;
    if (this.xqy == null)
    {
      ad.e("MicroMsg.NetSceneDownloadAppAttach", com.tencent.mm.compatible.util.f.abi() + " get info failed mediaId:" + this.mediaId);
      this.retCode = (-10000 - com.tencent.mm.compatible.util.f.getLine());
      AppMethodBeat.o(9480);
      return -1;
    }
    this.dBd = ((l)com.tencent.mm.kernel.g.ab(l.class)).dlK().xY(this.msgId);
    if ((this.dBd == null) || (this.dBd.field_msgId != this.msgId))
    {
      ad.e("MicroMsg.NetSceneDownloadAppAttach", com.tencent.mm.compatible.util.f.abi() + " get msginfo failed mediaId:%s  msgId:%d", new Object[] { this.mediaId, Long.valueOf(this.msgId) });
      this.retCode = (-10000 - com.tencent.mm.compatible.util.f.getLine());
      AppMethodBeat.o(9480);
      return -1;
    }
    if (this.startTime == 0L)
    {
      this.startTime = bt.flT();
      this.xqB = ((int)this.xqy.field_offset);
    }
    if (this.nxr != 0L)
    {
      paramf = (afd)this.rr.hNK.hNQ;
      paramf.nDo = u.aAm();
      paramf.xcK = ((int)this.xqy.field_totalLen);
      paramf.xcL = ((int)this.xqy.field_offset);
      paramf.xcM = 0;
      paramf.nEf = 40;
      paramf.xbt = this.nxr;
      i = dispatch(parame, this.rr, this);
      AppMethodBeat.o(9480);
      return i;
    }
    Object localObject = this.dBd.field_content;
    paramf = (com.tencent.mm.al.f)localObject;
    if (w.vF(this.dBd.field_talker))
    {
      i = bj.Bh(this.dBd.field_content);
      paramf = (com.tencent.mm.al.f)localObject;
      if (i != -1) {
        paramf = (this.dBd.field_content + " ").substring(i + 2).trim();
      }
    }
    paramf = k.b.yr(bt.aRd(paramf));
    if (paramf == null)
    {
      ad.e("MicroMsg.NetSceneDownloadAppAttach", "summerbig checkUseCdn cdntra parse content xml failed: mediaId:%s", new Object[] { this.mediaId });
      i = 0;
    }
    while (i != 0)
    {
      ad.d("MicroMsg.NetSceneDownloadAppAttach", "cdntra use cdn return -1 for onGYNetEnd mediaid:%s", new Object[] { this.mediaId });
      AppMethodBeat.o(9480);
      return 0;
      ad.i("MicroMsg.NetSceneDownloadAppAttach", "summerbig cdntra checkUseCdn msgid:%d total:%d fullpath:%s fileid:%s aeskey:%s ", new Object[] { Long.valueOf(this.msgId), Long.valueOf(this.xqy.field_totalLen), this.xqy.field_fileFullPath, paramf.hAd, bt.aRp(paramf.gjI) });
      if (((bt.isNullOrNil(paramf.hAd)) && (bt.isNullOrNil(paramf.hzU))) || (bt.isNullOrNil(paramf.gjI)))
      {
        ad.w("MicroMsg.NetSceneDownloadAppAttach", "summerbig cdntra checkUseCdn msgId:%d Not use CDN  cdnAttachUrl:%s aes:%s ", new Object[] { Long.valueOf(this.msgId), paramf.hAd, bt.aRp(paramf.gjI) });
        i = 0;
      }
      else
      {
        this.ibe = com.tencent.mm.ao.c.a("downattach", this.xqy.field_createTime, this.dBd.field_talker, this.xqA);
        if (bt.isNullOrNil(this.ibe))
        {
          ad.w("MicroMsg.NetSceneDownloadAppAttach", "summerbig cdntra genClientId failed not use cdn rowid:%d", new Object[] { Long.valueOf(this.xqA) });
          i = 0;
        }
        else
        {
          com.tencent.mm.vfs.i.aYg(com.tencent.mm.vfs.i.aYr(this.xqy.field_fileFullPath));
          this.xqC = (this.xqy.field_fileFullPath + "_tmp");
          localObject = new com.tencent.mm.i.g();
          ((com.tencent.mm.i.g)localObject).fJi = "task_NetSceneDownloadAppAttach";
          ((com.tencent.mm.i.g)localObject).field_mediaId = this.ibe;
          ((com.tencent.mm.i.g)localObject).field_fullpath = this.xqC;
          if ((paramf.hzS != 0) || (paramf.hzO > 26214400))
          {
            i = com.tencent.mm.i.a.fIy;
            label765:
            ((com.tencent.mm.i.g)localObject).field_fileType = i;
            ((com.tencent.mm.i.g)localObject).field_totalLen = ((int)this.xqy.field_totalLen);
            ((com.tencent.mm.i.g)localObject).field_aesKey = paramf.gjI;
            ((com.tencent.mm.i.g)localObject).field_fileId = paramf.hAd;
            ((com.tencent.mm.i.g)localObject).field_svr_signature = this.xqy.field_signature;
            ((com.tencent.mm.i.g)localObject).field_fake_bigfile_signature_aeskey = this.xqy.field_fakeAeskey;
            ((com.tencent.mm.i.g)localObject).field_fake_bigfile_signature = this.xqy.field_fakeSignature;
            ((com.tencent.mm.i.g)localObject).field_onlycheckexist = false;
            ((com.tencent.mm.i.g)localObject).field_priority = com.tencent.mm.i.a.fIw;
            ((com.tencent.mm.i.g)localObject).fJj = this.ibn;
            if (!w.vF(this.dBd.field_talker)) {
              break label1139;
            }
            i = 1;
            label876:
            ((com.tencent.mm.i.g)localObject).field_chattype = i;
            if (1 != ((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.b.b.class)).a(com.tencent.mm.plugin.expt.b.b.a.qHs, 0)) {
              break label1144;
            }
            bool = true;
            label907:
            ad.i("MicroMsg.NetSceneDownloadAppAttach", "cdn download UseMultiSocket(X-Lab):%s", new Object[] { Boolean.valueOf(bool) });
            if ((!bool) || ((paramf.hzS == 0) && (paramf.hzO <= 26214400))) {
              break label1150;
            }
          }
          label1139:
          label1144:
          label1150:
          for (boolean bool = true;; bool = false)
          {
            ((com.tencent.mm.i.g)localObject).field_use_multithread = bool;
            if (!bt.isNullOrNil(paramf.hzU))
            {
              ((com.tencent.mm.i.g)localObject).field_fileType = 19;
              ((com.tencent.mm.i.g)localObject).field_authKey = paramf.hAa;
              ((com.tencent.mm.i.g)localObject).fJm = paramf.hzU;
              ((com.tencent.mm.i.g)localObject).field_fileId = "";
            }
            ad.i("MicroMsg.NetSceneDownloadAppAttach", "summerbig checkUseCdn addRecvTask taskInfo field_use_multithread[%s], field_fileType[%d], fileFullPath[%s], aeskey[%s], signature[%s], faeskey[%s], fsignature[%s], onlycheckexist[%s]", new Object[] { Boolean.valueOf(((com.tencent.mm.i.g)localObject).field_use_multithread), Integer.valueOf(((com.tencent.mm.i.g)localObject).field_fileType), ((com.tencent.mm.i.g)localObject).field_fullpath, bt.aRp(((com.tencent.mm.i.g)localObject).field_aesKey), bt.aRp(((com.tencent.mm.i.g)localObject).field_svr_signature), bt.aRp(((com.tencent.mm.i.g)localObject).field_fake_bigfile_signature_aeskey), bt.aRp(((com.tencent.mm.i.g)localObject).field_fake_bigfile_signature), Boolean.valueOf(((com.tencent.mm.i.g)localObject).field_onlycheckexist) });
            if (com.tencent.mm.ao.f.aGI().b((com.tencent.mm.i.g)localObject, -1)) {
              break label1156;
            }
            ad.e("MicroMsg.NetSceneDownloadAppAttach", "summerbig cdntra addSendTask failed.");
            this.ibe = "";
            i = 0;
            break;
            i = com.tencent.mm.i.a.MediaType_FILE;
            break label765;
            i = 0;
            break label876;
            bool = false;
            break label907;
          }
          label1156:
          if (this.xqy.field_isUseCdn != 1)
          {
            this.xqy.field_isUseCdn = 1;
            bool = com.tencent.mm.plugin.s.a.bIX().a(this.xqy, new String[0]);
            if (!bool)
            {
              ad.e("MicroMsg.NetSceneDownloadAppAttach", "summerbig checkUseCdn update info ret:".concat(String.valueOf(bool)));
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
    if (this.xqy.field_status == 102L)
    {
      this.xqy.field_status = 101L;
      if (!this.xqD) {
        com.tencent.mm.plugin.s.a.bIX().a(this.xqy, new String[0]);
      }
    }
    this.xqA = this.xqy.systemRowid;
    if ((bt.isNullOrNil(this.xqy.field_mediaSvrId)) && (this.nxr == 0L))
    {
      ad.e("MicroMsg.NetSceneDownloadAppAttach", "checkArgs : mediaId is null");
      this.retCode = (-10000 - com.tencent.mm.compatible.util.f.getLine());
      AppMethodBeat.o(9480);
      return -1;
    }
    if ((this.xqy.field_totalLen <= 0L) || (this.xqy.field_totalLen > 26214400L))
    {
      ad.e("MicroMsg.NetSceneDownloadAppAttach", "checkArgs : totalLen is invalid, totalLen = " + this.xqy.field_totalLen);
      this.retCode = (-10000 - com.tencent.mm.compatible.util.f.getLine());
      AppMethodBeat.o(9480);
      return -1;
    }
    if ((bt.isNullOrNil(this.xqy.field_fileFullPath)) && (this.nxr == 0L))
    {
      ad.e("MicroMsg.NetSceneDownloadAppAttach", "checkArgs : fileFullPath is null");
      this.retCode = (-10000 - com.tencent.mm.compatible.util.f.getLine());
      AppMethodBeat.o(9480);
      return -1;
    }
    int j = (int)com.tencent.mm.vfs.i.aYo(this.xqy.field_fileFullPath);
    int i = j;
    if (this.xqF)
    {
      i = j - 6;
      if (i <= 0) {
        break label1573;
      }
    }
    while (i != this.xqy.field_offset)
    {
      ad.e("MicroMsg.NetSceneDownloadAppAttach", "checkArgs : fileFullPath is invalid, fileLength = " + i + ", info.field_offset = " + this.xqy.field_offset);
      this.retCode = (-10000 - com.tencent.mm.compatible.util.f.getLine());
      AppMethodBeat.o(9480);
      return -1;
      label1573:
      i = 0;
    }
    ad.i("MicroMsg.NetSceneDownloadAppAttach", "downing attach by non cdn, appId: %s,  mediaId: %s, sdkVer: %d", new Object[] { this.xqy.field_appId, this.xqy.field_mediaSvrId, Long.valueOf(this.xqy.field_sdkVer) });
    paramf = (afd)this.rr.hNK.hNQ;
    paramf.iht = this.xqy.field_appId;
    paramf.ihw = this.xqy.field_mediaSvrId;
    paramf.Fws = ((int)this.xqy.field_sdkVer);
    paramf.nDo = u.aAm();
    paramf.xcK = ((int)this.xqy.field_totalLen);
    paramf.xcL = ((int)this.xqy.field_offset);
    paramf.xcM = 0;
    if (this.nxr != 0L) {
      paramf.xbt = this.nxr;
    }
    if (this.type != 0) {}
    for (paramf.nEf = this.type;; paramf.nEf = ((int)this.xqy.field_type))
    {
      i = dispatch(parame, this.rr, this);
      AppMethodBeat.o(9480);
      return i;
    }
  }
  
  public final String getMediaId()
  {
    if (this.xqy == null) {
      return "";
    }
    return this.xqy.field_mediaSvrId;
  }
  
  public final int getType()
  {
    return 221;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(9481);
    ad.d("MicroMsg.NetSceneDownloadAppAttach", "onGYNetEnd : errType = " + paramInt2 + ", errCode = " + paramInt3);
    if ((paramInt2 == 3) && (paramInt3 == -1) && (!bt.isNullOrNil(this.ibe)))
    {
      ad.w("MicroMsg.NetSceneDownloadAppAttach", "cdntra using cdn trans,  wait cdn service callback! clientid:%s", new Object[] { this.ibe });
      AppMethodBeat.o(9481);
      return;
    }
    if ((paramInt2 != 0) || (paramInt3 != 0))
    {
      ad.e("MicroMsg.NetSceneDownloadAppAttach", "onGYNetEnd : errType = " + paramInt2 + ", errCode = " + paramInt3);
      this.retCode = (-10000 - com.tencent.mm.compatible.util.f.getLine());
      if (paramInt2 == 4) {
        com.tencent.mm.plugin.report.service.g.yhR.f(10420, new Object[] { Integer.valueOf(paramInt3), Integer.valueOf(2), Long.valueOf(this.startTime), Long.valueOf(bt.flT()), Integer.valueOf(com.tencent.mm.ao.c.cA(aj.getContext())), Integer.valueOf(com.tencent.mm.i.a.MediaType_FILE), Integer.valueOf(0) });
      }
      h(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(9481);
      return;
    }
    paramString = (afe)((com.tencent.mm.al.b)paramq).hNL.hNQ;
    this.xqy.field_totalLen = paramString.xcK;
    if ((paramString.ihw != null) && (!paramString.ihw.equals(this.xqy.field_mediaSvrId)))
    {
      ad.e("MicroMsg.NetSceneDownloadAppAttach", "argument is not consistent");
      this.retCode = (-10000 - com.tencent.mm.compatible.util.f.getLine());
      h(3, -1, "", this);
      AppMethodBeat.o(9481);
      return;
    }
    if (paramString.xcL != this.xqy.field_offset)
    {
      ad.e("MicroMsg.NetSceneDownloadAppAttach", "startPos, totalLen is incorrect startpos:" + paramString.xcL);
      this.retCode = (-10000 - com.tencent.mm.compatible.util.f.getLine());
      h(3, -1, "", this);
      AppMethodBeat.o(9481);
      return;
    }
    if (paramString.xcM + this.xqy.field_offset > this.xqy.field_totalLen)
    {
      ad.e("MicroMsg.NetSceneDownloadAppAttach", "data buffer is incorrect datalen:" + paramString.xcM + " off:" + this.xqy.field_offset + " total?:" + this.xqy.field_totalLen);
      this.retCode = (-10000 - com.tencent.mm.compatible.util.f.getLine());
      h(3, -1, "", this);
      AppMethodBeat.o(9481);
      return;
    }
    paramArrayOfByte = z.a(paramString.xcN);
    if ((paramArrayOfByte == null) || (paramArrayOfByte.length == 0) || (paramArrayOfByte.length != paramString.xcM))
    {
      ad.e("MicroMsg.NetSceneDownloadAppAttach", "data buffer is incorrect");
      this.retCode = (-10000 - com.tencent.mm.compatible.util.f.getLine());
      h(3, -1, "", this);
      AppMethodBeat.o(9481);
      return;
    }
    if (a.r(this.mediaId, this.msgId) == null)
    {
      ad.e("MicroMsg.NetSceneDownloadAppAttach", "append to file failed, msg maybe revoked or deleted. msgId:%d", new Object[] { Long.valueOf(this.xqy.field_msgInfoId) });
      this.retCode = (-10000 - com.tencent.mm.compatible.util.f.getLine());
      h(3, -1, "", this);
      AppMethodBeat.o(9481);
      return;
    }
    paramq = new String(paramArrayOfByte);
    ad.d("MicroMsg.NetSceneDownloadAppAttach", "dancy download big appmsg : %s", new Object[] { Boolean.valueOf(this.xqE) });
    bu localbu;
    StringBuffer localStringBuffer;
    if ((this.xqy.field_offset < this.xqy.field_totalLen) && (this.xqE))
    {
      localbu = ((l)com.tencent.mm.kernel.g.ab(l.class)).dlK().xY(this.xqy.field_msgInfoId);
      paramString = paramq;
      if (paramq.startsWith("<?xml version="))
      {
        paramInt1 = paramq.indexOf("<appmsg");
        ad.i("MicroMsg.NetSceneDownloadAppAttach", "inclued: <?xml version=  index:%s", new Object[] { Integer.valueOf(paramInt1) });
        paramString = paramq;
        if (paramInt1 > 0) {
          paramString = paramq.substring(paramInt1);
        }
      }
      if (!paramString.startsWith("<appmsg")) {
        break label1044;
      }
      if (!w.vF(localbu.field_talker)) {
        break label1032;
      }
      if (!bt.isNullOrNil(localbu.field_content))
      {
        paramq = localbu.field_content.split("\n", 2)[0];
        localStringBuffer = new StringBuffer();
        this.xqy.field_fullXml = (paramq + "\n");
        paramq = new StringBuffer();
        paramq.append(this.xqy.field_fullXml).append(paramString);
        this.xqy.field_fullXml = paramq.toString();
      }
    }
    for (;;)
    {
      localbu.setContent(this.xqy.field_fullXml);
      ((l)com.tencent.mm.kernel.g.ab(l.class)).dlK().a(this.xqy.field_msgInfoId, localbu);
      ad.d("MicroMsg.NetSceneDownloadAppAttach", "dancy download full xml succed! xml: [%s]", new Object[] { paramString });
      paramInt1 = com.tencent.mm.vfs.i.e(this.xqy.field_fileFullPath, paramArrayOfByte, paramArrayOfByte.length);
      if ((bt.isNullOrNil(this.xqy.field_fileFullPath)) || (paramInt1 == 0)) {
        break;
      }
      ad.e("MicroMsg.NetSceneDownloadAppAttach", "append to file failed:".concat(String.valueOf(paramInt1)));
      this.retCode = (-10000 - com.tencent.mm.compatible.util.f.getLine());
      h(3, -1, "", this);
      AppMethodBeat.o(9481);
      return;
      label1032:
      this.xqy.field_fullXml = paramString;
      continue;
      label1044:
      if (!localbu.field_content.startsWith("<msg>"))
      {
        paramq = new StringBuffer();
        paramq.append(localbu.field_content).append(paramString);
        this.xqy.field_fullXml = paramq.toString();
      }
      if ((paramString.endsWith("</appmsg>")) || (this.xqy.field_offset + paramArrayOfByte.length == this.xqy.field_totalLen))
      {
        if (w.vF(localbu.field_talker))
        {
          paramq = localbu.field_content.split("\n", 2);
          Object localObject = paramq[0];
          localStringBuffer = new StringBuffer();
          localObject = localStringBuffer.append((String)localObject).append("\n<msg>");
          if (paramq.length > 1) {}
          for (paramq = paramq[1];; paramq = "")
          {
            ((StringBuffer)localObject).append(paramq).append(paramString).append("</msg>");
            this.xqy.field_fullXml = localStringBuffer.toString();
            break;
          }
        }
        paramq = new StringBuffer();
        paramq.append("<msg>").append(this.xqy.field_fullXml).append("</msg>");
        this.xqy.field_fullXml = paramq.toString();
      }
    }
    paramString = this.xqy;
    long l = paramString.field_offset;
    paramString.field_offset = (paramArrayOfByte.length + l);
    if (this.xqy.field_offset == this.xqy.field_totalLen) {
      this.xqy.field_status = 199L;
    }
    if (this.iaZ != null) {
      aq.f(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(9474);
          f.this.iaZ.a((int)f.this.xqy.field_offset, (int)f.this.xqy.field_totalLen, f.this);
          AppMethodBeat.o(9474);
        }
      });
    }
    if (this.xqD) {}
    for (boolean bool = true; !bool; bool = com.tencent.mm.plugin.s.a.bIX().a(this.xqy, new String[0]))
    {
      ad.e("MicroMsg.NetSceneDownloadAppAttach", "onGYNetEnd update info ret:".concat(String.valueOf(paramInt1)));
      this.retCode = (-10000 - com.tencent.mm.compatible.util.f.getLine());
      h(3, -1, "", this);
      AppMethodBeat.o(9481);
      return;
    }
    if (this.xqy.field_status == 199L)
    {
      com.tencent.mm.plugin.report.service.g.yhR.f(10420, new Object[] { Integer.valueOf(0), Integer.valueOf(2), Long.valueOf(this.startTime), Long.valueOf(bt.flT()), Integer.valueOf(com.tencent.mm.ao.c.cA(aj.getContext())), Integer.valueOf(com.tencent.mm.i.a.MediaType_FILE), Long.valueOf(this.xqy.field_totalLen - this.xqB) });
      paramString = ((l)com.tencent.mm.kernel.g.ab(l.class)).dlK().xY(this.xqy.field_msgInfoId);
      ((l)com.tencent.mm.kernel.g.ab(l.class)).dlK().a(new i.c(paramString.field_talker, "update", paramString));
      h(0, 0, "", this);
      AppMethodBeat.o(9481);
      return;
    }
    if (this.xqy.field_status == 102L)
    {
      h(3, -1, "", this);
      this.retCode = -20102;
      AppMethodBeat.o(9481);
      return;
    }
    if (doScene(dispatcher(), this.callback) < 0)
    {
      ad.e("MicroMsg.NetSceneDownloadAppAttach", "onGYNetEnd : doScene fail");
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
    return n.b.hOp;
  }
  
  public static abstract interface a
  {
    public abstract void dEj();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.record.b.f
 * JD-Core Version:    0.7.0.1
 */