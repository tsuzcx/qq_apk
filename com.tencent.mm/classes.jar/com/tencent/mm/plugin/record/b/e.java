package com.tencent.mm.plugin.record.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ah.k.b;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.b.b;
import com.tencent.mm.ak.b.c;
import com.tencent.mm.ak.n;
import com.tencent.mm.ak.n.b;
import com.tencent.mm.g.c.dy;
import com.tencent.mm.i.g.a;
import com.tencent.mm.model.bi;
import com.tencent.mm.model.u;
import com.tencent.mm.model.w;
import com.tencent.mm.network.q;
import com.tencent.mm.platformtools.z;
import com.tencent.mm.plugin.messenger.foundation.a.a.h.c;
import com.tencent.mm.protocal.protobuf.adc;
import com.tencent.mm.protocal.protobuf.add;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.storage.bo;
import com.tencent.mm.vfs.i;
import java.io.ByteArrayOutputStream;

public final class e
  extends n
  implements com.tencent.mm.network.k
{
  private com.tencent.mm.ak.g callback;
  bo dpq;
  com.tencent.mm.ak.h hIl;
  String hIq;
  private g.a hIz;
  private long mWU;
  private String mediaId;
  public long msgId;
  public boolean oJn;
  public int retCode;
  private com.tencent.mm.ak.b rr;
  long startTime;
  private int type;
  com.tencent.mm.pluginsdk.model.app.c wiN;
  public long wiP;
  private int wiQ;
  String wiR;
  private boolean wiS;
  private boolean wiT;
  private boolean wiU;
  
  public e(long paramLong1, long paramLong2, com.tencent.mm.ak.h paramh)
  {
    AppMethodBeat.i(9475);
    this.wiN = null;
    this.wiP = -1L;
    this.mediaId = "";
    this.msgId = 0L;
    this.dpq = null;
    this.hIq = "";
    this.startTime = 0L;
    this.wiQ = -1;
    this.wiR = "";
    this.type = 0;
    this.retCode = 0;
    this.wiS = false;
    this.wiT = false;
    this.mWU = 0L;
    this.oJn = false;
    this.wiU = false;
    this.hIz = new g.a()
    {
      public final int a(String paramAnonymousString, final int paramAnonymousInt, com.tencent.mm.i.c paramAnonymousc, final com.tencent.mm.i.d paramAnonymousd, boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(9473);
        if (paramAnonymousc == null) {}
        for (paramAnonymousBoolean = true;; paramAnonymousBoolean = false)
        {
          ac.d("MicroMsg.NetSceneDownloadAppAttach", "summerbig callback mediaId[%s], startRet[%d], progressInfo[%s], sceneResult[%s], finish[%b]", new Object[] { paramAnonymousString, Integer.valueOf(paramAnonymousInt), paramAnonymousc, paramAnonymousd, Boolean.valueOf(paramAnonymousBoolean) });
          if (paramAnonymousInt != -21006) {
            break;
          }
          ac.i("MicroMsg.NetSceneDownloadAppAttach", "summerbig callback cdntra  ERR_CNDCOM_MEDIA_IS_DOWNLOADING clientid:%s", new Object[] { e.this.hIq });
          AppMethodBeat.o(9473);
          return 0;
        }
        if (paramAnonymousInt != 0)
        {
          a.wr(e.this.wiN.systemRowid);
          new com.tencent.mm.g.b.a.h(com.tencent.mm.plugin.report.a.u(new Object[] { Integer.valueOf(paramAnonymousInt), Integer.valueOf(2), Long.valueOf(e.this.startTime), Long.valueOf(bs.eWj()), Integer.valueOf(com.tencent.mm.an.c.cD(ai.getContext())), Integer.valueOf(com.tencent.mm.i.a.MediaType_FILE), Integer.valueOf(0), "" })).aHZ();
          ap.f(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(9465);
              e.a(e.this, 3, paramAnonymousInt, "", e.this);
              AppMethodBeat.o(9465);
            }
          });
          AppMethodBeat.o(9473);
          return 0;
        }
        e.this.wiN = a.q(paramAnonymousString, e.this.msgId);
        if (e.this.wiN == null)
        {
          ac.e("MicroMsg.NetSceneDownloadAppAttach", "summerbig attachInfo is null");
          ap.f(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(9466);
              e.a(e.this, 3, paramAnonymousInt, "", e.this);
              AppMethodBeat.o(9466);
            }
          });
          AppMethodBeat.o(9473);
          return 0;
        }
        if (e.this.wiN.field_status == 102L)
        {
          ac.i("MicroMsg.NetSceneDownloadAppAttach", "summerbig dancy attach download has paused, status:%d", new Object[] { Long.valueOf(e.this.wiN.field_status) });
          com.tencent.mm.an.f.aDD().BQ(e.this.hIq);
          ap.f(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(9467);
              e.a(e.this, 3, paramAnonymousInt, "attach  has paused, status=" + e.this.wiN.field_status, e.this);
              AppMethodBeat.o(9467);
            }
          });
          AppMethodBeat.o(9473);
          return 0;
        }
        if (paramAnonymousc != null)
        {
          if (paramAnonymousc.field_finishedLength == e.this.wiN.field_totalLen)
          {
            ac.i("MicroMsg.NetSceneDownloadAppAttach", "summerbig callback cdntra ignore progress 100%");
            AppMethodBeat.o(9473);
            return 0;
          }
          if (e.this.wiN.field_offset > paramAnonymousc.field_finishedLength)
          {
            ac.e("MicroMsg.NetSceneDownloadAppAttach", "summerbig callback cdnEndProc error oldpos:%d newpos:%d", new Object[] { Long.valueOf(e.this.wiN.field_offset), Long.valueOf(paramAnonymousc.field_finishedLength) });
            a.wr(e.this.wiN.systemRowid);
            ap.f(new Runnable()
            {
              public final void run()
              {
                AppMethodBeat.i(9468);
                e.a(e.this, 3, paramAnonymousInt, "", e.this);
                AppMethodBeat.o(9468);
              }
            });
            AppMethodBeat.o(9473);
            return 0;
          }
          e.this.wiN.field_offset = paramAnonymousc.field_finishedLength;
          com.tencent.mm.plugin.s.a.bEO().a(e.this.wiN, new String[0]);
          if (e.this.hIl != null) {
            ap.f(new Runnable()
            {
              public final void run()
              {
                AppMethodBeat.i(9469);
                e.this.hIl.a((int)e.this.wiN.field_offset, (int)e.this.wiN.field_totalLen, e.this);
                AppMethodBeat.o(9469);
              }
            });
          }
          ac.d("MicroMsg.NetSceneDownloadAppAttach", "summerbig callback cdntra progresscallback id:%s finish:%d total:%d", new Object[] { e.this.hIq, Long.valueOf(paramAnonymousc.field_finishedLength), Long.valueOf(paramAnonymousc.field_toltalLength) });
          AppMethodBeat.o(9473);
          return 0;
        }
        if (paramAnonymousd != null)
        {
          if (paramAnonymousd.field_retCode == 0) {
            break label1001;
          }
          a.wr(e.this.wiN.systemRowid);
          ac.e("MicroMsg.NetSceneDownloadAppAttach", "summerbig callback cdntra sceneResult.retCode :%d", new Object[] { Integer.valueOf(paramAnonymousd.field_retCode) });
          new com.tencent.mm.g.b.a.h(com.tencent.mm.plugin.report.a.u(new Object[] { Integer.valueOf(paramAnonymousd.field_retCode), Integer.valueOf(2), Long.valueOf(e.this.startTime), Long.valueOf(bs.eWj()), Integer.valueOf(com.tencent.mm.an.c.cD(ai.getContext())), Integer.valueOf(com.tencent.mm.i.a.MediaType_FILE), Long.valueOf(e.this.wiN.field_totalLen), paramAnonymousd.field_transInfo, "", "", "", "", "", "", "", paramAnonymousd.fqM })).aHZ();
          if (paramAnonymousd.field_retCode != 0) {
            new com.tencent.mm.g.b.a.f(com.tencent.mm.plugin.report.a.u(new Object[] { Integer.valueOf(paramAnonymousd.field_retCode), Integer.valueOf(2), Long.valueOf(e.this.startTime), Long.valueOf(bs.eWj()), Integer.valueOf(com.tencent.mm.an.c.cD(ai.getContext())), Integer.valueOf(com.tencent.mm.i.a.MediaType_FILE), Long.valueOf(e.this.wiN.field_totalLen), paramAnonymousd.field_transInfo, "", "", "", "", "", "", "", paramAnonymousd.fqM })).aHZ();
          }
          if (e.this.hIl != null) {
            ap.f(new Runnable()
            {
              public final void run()
              {
                AppMethodBeat.i(9470);
                e.this.hIl.a((int)e.this.wiN.field_offset, (int)e.this.wiN.field_totalLen, e.this);
                AppMethodBeat.o(9470);
              }
            });
          }
          if (paramAnonymousd.field_retCode == 0) {
            break label1293;
          }
          ap.f(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(9471);
              e.a(e.this, 3, paramAnonymousd.field_retCode, "", e.this);
              AppMethodBeat.o(9471);
            }
          });
        }
        for (;;)
        {
          AppMethodBeat.o(9473);
          return 0;
          label1001:
          new com.tencent.mm.vfs.e(e.this.wiR).ae(new com.tencent.mm.vfs.e(e.this.wiN.field_fileFullPath));
          e.this.wiN.field_status = 199L;
          e.this.wiN.field_offset = e.this.wiN.field_totalLen;
          com.tencent.mm.plugin.s.a.bEO().a(e.this.wiN, new String[0]);
          com.tencent.mm.plugin.report.service.h.wUl.idkeyStat(198L, 45L, e.this.wiN.field_totalLen, false);
          com.tencent.mm.plugin.report.service.h.wUl.idkeyStat(198L, 46L, 1L, false);
          paramAnonymousc = com.tencent.mm.plugin.report.service.h.wUl;
          if (e.this.dpq == null)
          {
            paramAnonymousString = "";
            label1141:
            if (!w.sQ(paramAnonymousString)) {
              break label1248;
            }
          }
          label1248:
          for (long l = 48L;; l = 47L)
          {
            paramAnonymousc.idkeyStat(198L, l, 1L, false);
            paramAnonymousString = ((com.tencent.mm.plugin.messenger.foundation.a.k)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).dcr().vP(e.this.wiN.field_msgInfoId);
            if (paramAnonymousString.field_status != 5) {
              break label1256;
            }
            paramAnonymousString.setStatus(3);
            ((com.tencent.mm.plugin.messenger.foundation.a.k)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).dcr().a(paramAnonymousString.field_msgId, paramAnonymousString);
            break;
            paramAnonymousString = e.this.dpq.field_talker;
            break label1141;
          }
          label1256:
          ((com.tencent.mm.plugin.messenger.foundation.a.k)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).dcr().a(new h.c(paramAnonymousString.field_talker, "update", paramAnonymousString));
          break;
          label1293:
          ap.f(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(9472);
              e.a(e.this, 0, 0, "", e.this);
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
    this.mWU = paramLong2;
    this.msgId = paramLong1;
    this.wiN = com.tencent.mm.plugin.s.a.bEO().zM(paramLong1);
    this.hIl = paramh;
    this.wiT = true;
    if (this.wiN == null)
    {
      ac.e("MicroMsg.NetSceneDownloadAppAttach", "big appMsg, info is null, msgid = , svrId".concat(String.valueOf(paramLong1)), new Object[] { Long.valueOf(paramLong2) });
      AppMethodBeat.o(9475);
      return;
    }
    paramh = new b.a();
    paramh.hvt = new adc();
    paramh.hvu = new add();
    paramh.uri = "/cgi-bin/micromsg-bin/downloadappattach";
    paramh.funcId = 221;
    paramh.reqCmdId = 106;
    paramh.respCmdId = 1000000106;
    this.rr = paramh.aAz();
    AppMethodBeat.o(9475);
  }
  
  public e(long paramLong, String paramString, com.tencent.mm.ak.h paramh)
  {
    this(paramString, paramLong, paramh);
    this.msgId = paramLong;
  }
  
  public e(com.tencent.mm.pluginsdk.model.app.c paramc)
  {
    AppMethodBeat.i(9476);
    this.wiN = null;
    this.wiP = -1L;
    this.mediaId = "";
    this.msgId = 0L;
    this.dpq = null;
    this.hIq = "";
    this.startTime = 0L;
    this.wiQ = -1;
    this.wiR = "";
    this.type = 0;
    this.retCode = 0;
    this.wiS = false;
    this.wiT = false;
    this.mWU = 0L;
    this.oJn = false;
    this.wiU = false;
    this.hIz = new g.a()
    {
      public final int a(String paramAnonymousString, final int paramAnonymousInt, com.tencent.mm.i.c paramAnonymousc, final com.tencent.mm.i.d paramAnonymousd, boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(9473);
        if (paramAnonymousc == null) {}
        for (paramAnonymousBoolean = true;; paramAnonymousBoolean = false)
        {
          ac.d("MicroMsg.NetSceneDownloadAppAttach", "summerbig callback mediaId[%s], startRet[%d], progressInfo[%s], sceneResult[%s], finish[%b]", new Object[] { paramAnonymousString, Integer.valueOf(paramAnonymousInt), paramAnonymousc, paramAnonymousd, Boolean.valueOf(paramAnonymousBoolean) });
          if (paramAnonymousInt != -21006) {
            break;
          }
          ac.i("MicroMsg.NetSceneDownloadAppAttach", "summerbig callback cdntra  ERR_CNDCOM_MEDIA_IS_DOWNLOADING clientid:%s", new Object[] { e.this.hIq });
          AppMethodBeat.o(9473);
          return 0;
        }
        if (paramAnonymousInt != 0)
        {
          a.wr(e.this.wiN.systemRowid);
          new com.tencent.mm.g.b.a.h(com.tencent.mm.plugin.report.a.u(new Object[] { Integer.valueOf(paramAnonymousInt), Integer.valueOf(2), Long.valueOf(e.this.startTime), Long.valueOf(bs.eWj()), Integer.valueOf(com.tencent.mm.an.c.cD(ai.getContext())), Integer.valueOf(com.tencent.mm.i.a.MediaType_FILE), Integer.valueOf(0), "" })).aHZ();
          ap.f(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(9465);
              e.a(e.this, 3, paramAnonymousInt, "", e.this);
              AppMethodBeat.o(9465);
            }
          });
          AppMethodBeat.o(9473);
          return 0;
        }
        e.this.wiN = a.q(paramAnonymousString, e.this.msgId);
        if (e.this.wiN == null)
        {
          ac.e("MicroMsg.NetSceneDownloadAppAttach", "summerbig attachInfo is null");
          ap.f(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(9466);
              e.a(e.this, 3, paramAnonymousInt, "", e.this);
              AppMethodBeat.o(9466);
            }
          });
          AppMethodBeat.o(9473);
          return 0;
        }
        if (e.this.wiN.field_status == 102L)
        {
          ac.i("MicroMsg.NetSceneDownloadAppAttach", "summerbig dancy attach download has paused, status:%d", new Object[] { Long.valueOf(e.this.wiN.field_status) });
          com.tencent.mm.an.f.aDD().BQ(e.this.hIq);
          ap.f(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(9467);
              e.a(e.this, 3, paramAnonymousInt, "attach  has paused, status=" + e.this.wiN.field_status, e.this);
              AppMethodBeat.o(9467);
            }
          });
          AppMethodBeat.o(9473);
          return 0;
        }
        if (paramAnonymousc != null)
        {
          if (paramAnonymousc.field_finishedLength == e.this.wiN.field_totalLen)
          {
            ac.i("MicroMsg.NetSceneDownloadAppAttach", "summerbig callback cdntra ignore progress 100%");
            AppMethodBeat.o(9473);
            return 0;
          }
          if (e.this.wiN.field_offset > paramAnonymousc.field_finishedLength)
          {
            ac.e("MicroMsg.NetSceneDownloadAppAttach", "summerbig callback cdnEndProc error oldpos:%d newpos:%d", new Object[] { Long.valueOf(e.this.wiN.field_offset), Long.valueOf(paramAnonymousc.field_finishedLength) });
            a.wr(e.this.wiN.systemRowid);
            ap.f(new Runnable()
            {
              public final void run()
              {
                AppMethodBeat.i(9468);
                e.a(e.this, 3, paramAnonymousInt, "", e.this);
                AppMethodBeat.o(9468);
              }
            });
            AppMethodBeat.o(9473);
            return 0;
          }
          e.this.wiN.field_offset = paramAnonymousc.field_finishedLength;
          com.tencent.mm.plugin.s.a.bEO().a(e.this.wiN, new String[0]);
          if (e.this.hIl != null) {
            ap.f(new Runnable()
            {
              public final void run()
              {
                AppMethodBeat.i(9469);
                e.this.hIl.a((int)e.this.wiN.field_offset, (int)e.this.wiN.field_totalLen, e.this);
                AppMethodBeat.o(9469);
              }
            });
          }
          ac.d("MicroMsg.NetSceneDownloadAppAttach", "summerbig callback cdntra progresscallback id:%s finish:%d total:%d", new Object[] { e.this.hIq, Long.valueOf(paramAnonymousc.field_finishedLength), Long.valueOf(paramAnonymousc.field_toltalLength) });
          AppMethodBeat.o(9473);
          return 0;
        }
        if (paramAnonymousd != null)
        {
          if (paramAnonymousd.field_retCode == 0) {
            break label1001;
          }
          a.wr(e.this.wiN.systemRowid);
          ac.e("MicroMsg.NetSceneDownloadAppAttach", "summerbig callback cdntra sceneResult.retCode :%d", new Object[] { Integer.valueOf(paramAnonymousd.field_retCode) });
          new com.tencent.mm.g.b.a.h(com.tencent.mm.plugin.report.a.u(new Object[] { Integer.valueOf(paramAnonymousd.field_retCode), Integer.valueOf(2), Long.valueOf(e.this.startTime), Long.valueOf(bs.eWj()), Integer.valueOf(com.tencent.mm.an.c.cD(ai.getContext())), Integer.valueOf(com.tencent.mm.i.a.MediaType_FILE), Long.valueOf(e.this.wiN.field_totalLen), paramAnonymousd.field_transInfo, "", "", "", "", "", "", "", paramAnonymousd.fqM })).aHZ();
          if (paramAnonymousd.field_retCode != 0) {
            new com.tencent.mm.g.b.a.f(com.tencent.mm.plugin.report.a.u(new Object[] { Integer.valueOf(paramAnonymousd.field_retCode), Integer.valueOf(2), Long.valueOf(e.this.startTime), Long.valueOf(bs.eWj()), Integer.valueOf(com.tencent.mm.an.c.cD(ai.getContext())), Integer.valueOf(com.tencent.mm.i.a.MediaType_FILE), Long.valueOf(e.this.wiN.field_totalLen), paramAnonymousd.field_transInfo, "", "", "", "", "", "", "", paramAnonymousd.fqM })).aHZ();
          }
          if (e.this.hIl != null) {
            ap.f(new Runnable()
            {
              public final void run()
              {
                AppMethodBeat.i(9470);
                e.this.hIl.a((int)e.this.wiN.field_offset, (int)e.this.wiN.field_totalLen, e.this);
                AppMethodBeat.o(9470);
              }
            });
          }
          if (paramAnonymousd.field_retCode == 0) {
            break label1293;
          }
          ap.f(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(9471);
              e.a(e.this, 3, paramAnonymousd.field_retCode, "", e.this);
              AppMethodBeat.o(9471);
            }
          });
        }
        for (;;)
        {
          AppMethodBeat.o(9473);
          return 0;
          label1001:
          new com.tencent.mm.vfs.e(e.this.wiR).ae(new com.tencent.mm.vfs.e(e.this.wiN.field_fileFullPath));
          e.this.wiN.field_status = 199L;
          e.this.wiN.field_offset = e.this.wiN.field_totalLen;
          com.tencent.mm.plugin.s.a.bEO().a(e.this.wiN, new String[0]);
          com.tencent.mm.plugin.report.service.h.wUl.idkeyStat(198L, 45L, e.this.wiN.field_totalLen, false);
          com.tencent.mm.plugin.report.service.h.wUl.idkeyStat(198L, 46L, 1L, false);
          paramAnonymousc = com.tencent.mm.plugin.report.service.h.wUl;
          if (e.this.dpq == null)
          {
            paramAnonymousString = "";
            label1141:
            if (!w.sQ(paramAnonymousString)) {
              break label1248;
            }
          }
          label1248:
          for (long l = 48L;; l = 47L)
          {
            paramAnonymousc.idkeyStat(198L, l, 1L, false);
            paramAnonymousString = ((com.tencent.mm.plugin.messenger.foundation.a.k)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).dcr().vP(e.this.wiN.field_msgInfoId);
            if (paramAnonymousString.field_status != 5) {
              break label1256;
            }
            paramAnonymousString.setStatus(3);
            ((com.tencent.mm.plugin.messenger.foundation.a.k)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).dcr().a(paramAnonymousString.field_msgId, paramAnonymousString);
            break;
            paramAnonymousString = e.this.dpq.field_talker;
            break label1141;
          }
          label1256:
          ((com.tencent.mm.plugin.messenger.foundation.a.k)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).dcr().a(new h.c(paramAnonymousString.field_talker, "update", paramAnonymousString));
          break;
          label1293:
          ap.f(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(9472);
              e.a(e.this, 0, 0, "", e.this);
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
    this.wiN = paramc;
    this.wiS = true;
    this.mediaId = this.wiN.field_mediaId;
    this.hIl = null;
    this.type = 0;
    if (paramc == null)
    {
      ac.e("MicroMsg.NetSceneDownloadAppAttach", "summerbig <init>, info is null, mediaId = " + this.mediaId);
      AppMethodBeat.o(9476);
      return;
    }
    b.a locala = new b.a();
    locala.hvt = new adc();
    locala.hvu = new add();
    locala.uri = "/cgi-bin/micromsg-bin/downloadappattach";
    locala.funcId = 221;
    locala.reqCmdId = 106;
    locala.respCmdId = 1000000106;
    this.rr = locala.aAz();
    ac.i("MicroMsg.NetSceneDownloadAppAttach", "summerbig NetSceneDownloadAppAttach info fullpath[%s], justSaveFile[%b], stack[%s]", new Object[] { paramc.field_fileFullPath, Boolean.TRUE, bs.eWi() });
    AppMethodBeat.o(9476);
  }
  
  public e(String paramString)
  {
    this(paramString, 0L, null);
  }
  
  private e(String paramString, long paramLong, com.tencent.mm.ak.h paramh)
  {
    AppMethodBeat.i(9477);
    this.wiN = null;
    this.wiP = -1L;
    this.mediaId = "";
    this.msgId = 0L;
    this.dpq = null;
    this.hIq = "";
    this.startTime = 0L;
    this.wiQ = -1;
    this.wiR = "";
    this.type = 0;
    this.retCode = 0;
    this.wiS = false;
    this.wiT = false;
    this.mWU = 0L;
    this.oJn = false;
    this.wiU = false;
    this.hIz = new g.a()
    {
      public final int a(String paramAnonymousString, final int paramAnonymousInt, com.tencent.mm.i.c paramAnonymousc, final com.tencent.mm.i.d paramAnonymousd, boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(9473);
        if (paramAnonymousc == null) {}
        for (paramAnonymousBoolean = true;; paramAnonymousBoolean = false)
        {
          ac.d("MicroMsg.NetSceneDownloadAppAttach", "summerbig callback mediaId[%s], startRet[%d], progressInfo[%s], sceneResult[%s], finish[%b]", new Object[] { paramAnonymousString, Integer.valueOf(paramAnonymousInt), paramAnonymousc, paramAnonymousd, Boolean.valueOf(paramAnonymousBoolean) });
          if (paramAnonymousInt != -21006) {
            break;
          }
          ac.i("MicroMsg.NetSceneDownloadAppAttach", "summerbig callback cdntra  ERR_CNDCOM_MEDIA_IS_DOWNLOADING clientid:%s", new Object[] { e.this.hIq });
          AppMethodBeat.o(9473);
          return 0;
        }
        if (paramAnonymousInt != 0)
        {
          a.wr(e.this.wiN.systemRowid);
          new com.tencent.mm.g.b.a.h(com.tencent.mm.plugin.report.a.u(new Object[] { Integer.valueOf(paramAnonymousInt), Integer.valueOf(2), Long.valueOf(e.this.startTime), Long.valueOf(bs.eWj()), Integer.valueOf(com.tencent.mm.an.c.cD(ai.getContext())), Integer.valueOf(com.tencent.mm.i.a.MediaType_FILE), Integer.valueOf(0), "" })).aHZ();
          ap.f(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(9465);
              e.a(e.this, 3, paramAnonymousInt, "", e.this);
              AppMethodBeat.o(9465);
            }
          });
          AppMethodBeat.o(9473);
          return 0;
        }
        e.this.wiN = a.q(paramAnonymousString, e.this.msgId);
        if (e.this.wiN == null)
        {
          ac.e("MicroMsg.NetSceneDownloadAppAttach", "summerbig attachInfo is null");
          ap.f(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(9466);
              e.a(e.this, 3, paramAnonymousInt, "", e.this);
              AppMethodBeat.o(9466);
            }
          });
          AppMethodBeat.o(9473);
          return 0;
        }
        if (e.this.wiN.field_status == 102L)
        {
          ac.i("MicroMsg.NetSceneDownloadAppAttach", "summerbig dancy attach download has paused, status:%d", new Object[] { Long.valueOf(e.this.wiN.field_status) });
          com.tencent.mm.an.f.aDD().BQ(e.this.hIq);
          ap.f(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(9467);
              e.a(e.this, 3, paramAnonymousInt, "attach  has paused, status=" + e.this.wiN.field_status, e.this);
              AppMethodBeat.o(9467);
            }
          });
          AppMethodBeat.o(9473);
          return 0;
        }
        if (paramAnonymousc != null)
        {
          if (paramAnonymousc.field_finishedLength == e.this.wiN.field_totalLen)
          {
            ac.i("MicroMsg.NetSceneDownloadAppAttach", "summerbig callback cdntra ignore progress 100%");
            AppMethodBeat.o(9473);
            return 0;
          }
          if (e.this.wiN.field_offset > paramAnonymousc.field_finishedLength)
          {
            ac.e("MicroMsg.NetSceneDownloadAppAttach", "summerbig callback cdnEndProc error oldpos:%d newpos:%d", new Object[] { Long.valueOf(e.this.wiN.field_offset), Long.valueOf(paramAnonymousc.field_finishedLength) });
            a.wr(e.this.wiN.systemRowid);
            ap.f(new Runnable()
            {
              public final void run()
              {
                AppMethodBeat.i(9468);
                e.a(e.this, 3, paramAnonymousInt, "", e.this);
                AppMethodBeat.o(9468);
              }
            });
            AppMethodBeat.o(9473);
            return 0;
          }
          e.this.wiN.field_offset = paramAnonymousc.field_finishedLength;
          com.tencent.mm.plugin.s.a.bEO().a(e.this.wiN, new String[0]);
          if (e.this.hIl != null) {
            ap.f(new Runnable()
            {
              public final void run()
              {
                AppMethodBeat.i(9469);
                e.this.hIl.a((int)e.this.wiN.field_offset, (int)e.this.wiN.field_totalLen, e.this);
                AppMethodBeat.o(9469);
              }
            });
          }
          ac.d("MicroMsg.NetSceneDownloadAppAttach", "summerbig callback cdntra progresscallback id:%s finish:%d total:%d", new Object[] { e.this.hIq, Long.valueOf(paramAnonymousc.field_finishedLength), Long.valueOf(paramAnonymousc.field_toltalLength) });
          AppMethodBeat.o(9473);
          return 0;
        }
        if (paramAnonymousd != null)
        {
          if (paramAnonymousd.field_retCode == 0) {
            break label1001;
          }
          a.wr(e.this.wiN.systemRowid);
          ac.e("MicroMsg.NetSceneDownloadAppAttach", "summerbig callback cdntra sceneResult.retCode :%d", new Object[] { Integer.valueOf(paramAnonymousd.field_retCode) });
          new com.tencent.mm.g.b.a.h(com.tencent.mm.plugin.report.a.u(new Object[] { Integer.valueOf(paramAnonymousd.field_retCode), Integer.valueOf(2), Long.valueOf(e.this.startTime), Long.valueOf(bs.eWj()), Integer.valueOf(com.tencent.mm.an.c.cD(ai.getContext())), Integer.valueOf(com.tencent.mm.i.a.MediaType_FILE), Long.valueOf(e.this.wiN.field_totalLen), paramAnonymousd.field_transInfo, "", "", "", "", "", "", "", paramAnonymousd.fqM })).aHZ();
          if (paramAnonymousd.field_retCode != 0) {
            new com.tencent.mm.g.b.a.f(com.tencent.mm.plugin.report.a.u(new Object[] { Integer.valueOf(paramAnonymousd.field_retCode), Integer.valueOf(2), Long.valueOf(e.this.startTime), Long.valueOf(bs.eWj()), Integer.valueOf(com.tencent.mm.an.c.cD(ai.getContext())), Integer.valueOf(com.tencent.mm.i.a.MediaType_FILE), Long.valueOf(e.this.wiN.field_totalLen), paramAnonymousd.field_transInfo, "", "", "", "", "", "", "", paramAnonymousd.fqM })).aHZ();
          }
          if (e.this.hIl != null) {
            ap.f(new Runnable()
            {
              public final void run()
              {
                AppMethodBeat.i(9470);
                e.this.hIl.a((int)e.this.wiN.field_offset, (int)e.this.wiN.field_totalLen, e.this);
                AppMethodBeat.o(9470);
              }
            });
          }
          if (paramAnonymousd.field_retCode == 0) {
            break label1293;
          }
          ap.f(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(9471);
              e.a(e.this, 3, paramAnonymousd.field_retCode, "", e.this);
              AppMethodBeat.o(9471);
            }
          });
        }
        for (;;)
        {
          AppMethodBeat.o(9473);
          return 0;
          label1001:
          new com.tencent.mm.vfs.e(e.this.wiR).ae(new com.tencent.mm.vfs.e(e.this.wiN.field_fileFullPath));
          e.this.wiN.field_status = 199L;
          e.this.wiN.field_offset = e.this.wiN.field_totalLen;
          com.tencent.mm.plugin.s.a.bEO().a(e.this.wiN, new String[0]);
          com.tencent.mm.plugin.report.service.h.wUl.idkeyStat(198L, 45L, e.this.wiN.field_totalLen, false);
          com.tencent.mm.plugin.report.service.h.wUl.idkeyStat(198L, 46L, 1L, false);
          paramAnonymousc = com.tencent.mm.plugin.report.service.h.wUl;
          if (e.this.dpq == null)
          {
            paramAnonymousString = "";
            label1141:
            if (!w.sQ(paramAnonymousString)) {
              break label1248;
            }
          }
          label1248:
          for (long l = 48L;; l = 47L)
          {
            paramAnonymousc.idkeyStat(198L, l, 1L, false);
            paramAnonymousString = ((com.tencent.mm.plugin.messenger.foundation.a.k)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).dcr().vP(e.this.wiN.field_msgInfoId);
            if (paramAnonymousString.field_status != 5) {
              break label1256;
            }
            paramAnonymousString.setStatus(3);
            ((com.tencent.mm.plugin.messenger.foundation.a.k)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).dcr().a(paramAnonymousString.field_msgId, paramAnonymousString);
            break;
            paramAnonymousString = e.this.dpq.field_talker;
            break label1141;
          }
          label1256:
          ((com.tencent.mm.plugin.messenger.foundation.a.k)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).dcr().a(new h.c(paramAnonymousString.field_talker, "update", paramAnonymousString));
          break;
          label1293:
          ap.f(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(9472);
              e.a(e.this, 0, 0, "", e.this);
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
    this.hIl = paramh;
    this.type = 0;
    this.wiN = com.tencent.mm.plugin.s.a.bEO().aGd(paramString);
    if (this.wiN == null) {
      this.wiN = com.tencent.mm.plugin.s.a.bEO().zM(paramLong);
    }
    if (this.wiN == null)
    {
      ac.e("MicroMsg.NetSceneDownloadAppAttach", "summerbig <init>, info is null, mediaId = ".concat(String.valueOf(paramString)));
      AppMethodBeat.o(9477);
      return;
    }
    paramString = new b.a();
    paramString.hvt = new adc();
    paramString.hvu = new add();
    paramString.uri = "/cgi-bin/micromsg-bin/downloadappattach";
    paramString.funcId = 221;
    paramString.reqCmdId = 106;
    paramString.respCmdId = 1000000106;
    this.rr = paramString.aAz();
    ac.d("MicroMsg.NetSceneDownloadAppAttach", "summerbig NetSceneDownloadAppAttach , type[%d], info fullpath[%s], field_type[%d], signature[%s], stack[%s]", new Object[] { Integer.valueOf(0), this.wiN.field_fileFullPath, Long.valueOf(this.wiN.field_type), this.wiN.field_signature, bs.eWi() });
    AppMethodBeat.o(9477);
  }
  
  private void h(int paramInt1, int paramInt2, String paramString, n paramn)
  {
    AppMethodBeat.i(9482);
    if (this.callback != null)
    {
      this.callback.onSceneEnd(paramInt1, paramInt2, paramString, paramn);
      if (this.wiN != null)
      {
        long l = this.wiN.field_msgInfoId;
        paramString = ((com.tencent.mm.plugin.messenger.foundation.a.k)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).dcr().vP(l);
        if ((paramInt1 == 0) && (paramInt2 == 0))
        {
          ((com.tencent.mm.plugin.comm.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.comm.a.b.class)).a(this.oJn, String.valueOf(l), paramString.field_msgSvrId, true);
          AppMethodBeat.o(9482);
          return;
        }
        ((com.tencent.mm.plugin.comm.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.comm.a.b.class)).a(this.oJn, String.valueOf(l), paramString.field_msgSvrId, false);
      }
    }
    AppMethodBeat.o(9482);
  }
  
  public final void a(a parama)
  {
    AppMethodBeat.i(9479);
    if (!this.wiS)
    {
      com.tencent.mm.an.f.aDD().BR(this.hIq);
      this.wiN = com.tencent.mm.plugin.s.a.bEO().zM(this.msgId);
      if (this.wiN == null)
      {
        ac.i("MicroMsg.NetSceneDownloadAppAttach", "pause get by msgid  %是is null then get by mediaId %s", new Object[] { Long.valueOf(this.msgId), this.mediaId });
        this.wiN = com.tencent.mm.plugin.s.a.bEO().aGd(this.mediaId);
      }
    }
    ac.i("MicroMsg.NetSceneDownloadAppAttach", "summerbig pause listener[%s], info[%s], justSaveFile[%b], stack[%s]", new Object[] { parama, this.wiN, Boolean.valueOf(this.wiS), bs.eWi() });
    if (this.wiN == null)
    {
      AppMethodBeat.o(9479);
      return;
    }
    if ((this.wiN.field_status == 101L) && (parama != null)) {
      parama.dtM();
    }
    this.wiN.field_status = 102L;
    if (!this.wiS) {
      ac.i("MicroMsg.NetSceneDownloadAppAttach", "pause done %s", new Object[] { Boolean.valueOf(com.tencent.mm.plugin.s.a.bEO().a(this.wiN, new String[0])) });
    }
    AppMethodBeat.o(9479);
  }
  
  public final int doScene(com.tencent.mm.network.e parame, com.tencent.mm.ak.g paramg)
  {
    AppMethodBeat.i(9480);
    this.callback = paramg;
    if (this.wiN == null)
    {
      ac.e("MicroMsg.NetSceneDownloadAppAttach", com.tencent.mm.compatible.util.f.YG() + " get info failed mediaId:" + this.mediaId);
      this.retCode = (-10000 - com.tencent.mm.compatible.util.f.getLine());
      AppMethodBeat.o(9480);
      return -1;
    }
    this.dpq = ((com.tencent.mm.plugin.messenger.foundation.a.k)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).dcr().vP(this.msgId);
    if ((this.dpq == null) || (this.dpq.field_msgId != this.msgId))
    {
      ac.e("MicroMsg.NetSceneDownloadAppAttach", com.tencent.mm.compatible.util.f.YG() + " get msginfo failed mediaId:%s  msgId:%d", new Object[] { this.mediaId, Long.valueOf(this.msgId) });
      this.retCode = (-10000 - com.tencent.mm.compatible.util.f.getLine());
      AppMethodBeat.o(9480);
      return -1;
    }
    if (this.startTime == 0L)
    {
      this.startTime = bs.eWj();
      this.wiQ = ((int)this.wiN.field_offset);
    }
    if (this.mWU != 0L)
    {
      paramg = (adc)this.rr.hvr.hvw;
      paramg.ncR = u.axw();
      paramg.vTH = ((int)this.wiN.field_totalLen);
      paramg.vTI = ((int)this.wiN.field_offset);
      paramg.vTJ = 0;
      paramg.ndI = 40;
      paramg.vTQ = this.mWU;
      i = dispatch(parame, this.rr, this);
      AppMethodBeat.o(9480);
      return i;
    }
    Object localObject = this.dpq.field_content;
    paramg = (com.tencent.mm.ak.g)localObject;
    if (w.sQ(this.dpq.field_talker))
    {
      i = bi.yi(this.dpq.field_content);
      paramg = (com.tencent.mm.ak.g)localObject;
      if (i != -1) {
        paramg = (this.dpq.field_content + " ").substring(i + 2).trim();
      }
    }
    paramg = k.b.vA(bs.aLx(paramg));
    if (paramg == null)
    {
      ac.e("MicroMsg.NetSceneDownloadAppAttach", "summerbig checkUseCdn cdntra parse content xml failed: mediaId:%s", new Object[] { this.mediaId });
      i = 0;
    }
    while (i != 0)
    {
      ac.d("MicroMsg.NetSceneDownloadAppAttach", "cdntra use cdn return -1 for onGYNetEnd mediaid:%s", new Object[] { this.mediaId });
      AppMethodBeat.o(9480);
      return 0;
      ac.i("MicroMsg.NetSceneDownloadAppAttach", "summerbig cdntra checkUseCdn msgid:%d total:%d fullpath:%s fileid:%s aeskey:%s ", new Object[] { Long.valueOf(this.msgId), Long.valueOf(this.wiN.field_totalLen), this.wiN.field_fileFullPath, paramg.hhU, bs.aLJ(paramg.fQi) });
      if (((bs.isNullOrNil(paramg.hhU)) && (bs.isNullOrNil(paramg.hhL))) || (bs.isNullOrNil(paramg.fQi)))
      {
        ac.w("MicroMsg.NetSceneDownloadAppAttach", "summerbig cdntra checkUseCdn msgId:%d Not use CDN  cdnAttachUrl:%s aes:%s ", new Object[] { Long.valueOf(this.msgId), paramg.hhU, bs.aLJ(paramg.fQi) });
        i = 0;
      }
      else
      {
        this.hIq = com.tencent.mm.an.c.a("downattach", this.wiN.field_createTime, this.dpq.field_talker, this.wiP);
        if (bs.isNullOrNil(this.hIq))
        {
          ac.w("MicroMsg.NetSceneDownloadAppAttach", "summerbig cdntra genClientId failed not use cdn rowid:%d", new Object[] { Long.valueOf(this.wiP) });
          i = 0;
        }
        else
        {
          i.aSh(i.aSs(this.wiN.field_fileFullPath));
          this.wiR = (this.wiN.field_fileFullPath + "_tmp");
          localObject = new com.tencent.mm.i.g();
          ((com.tencent.mm.i.g)localObject).field_mediaId = this.hIq;
          ((com.tencent.mm.i.g)localObject).field_fullpath = this.wiR;
          if ((paramg.hhJ != 0) || (paramg.hhF > 26214400))
          {
            i = com.tencent.mm.i.a.fqr;
            label757:
            ((com.tencent.mm.i.g)localObject).field_fileType = i;
            ((com.tencent.mm.i.g)localObject).field_totalLen = ((int)this.wiN.field_totalLen);
            ((com.tencent.mm.i.g)localObject).field_aesKey = paramg.fQi;
            ((com.tencent.mm.i.g)localObject).field_fileId = paramg.hhU;
            ((com.tencent.mm.i.g)localObject).field_svr_signature = this.wiN.field_signature;
            ((com.tencent.mm.i.g)localObject).field_fake_bigfile_signature_aeskey = this.wiN.field_fakeAeskey;
            ((com.tencent.mm.i.g)localObject).field_fake_bigfile_signature = this.wiN.field_fakeSignature;
            ((com.tencent.mm.i.g)localObject).field_onlycheckexist = false;
            ((com.tencent.mm.i.g)localObject).field_priority = com.tencent.mm.i.a.fqp;
            ((com.tencent.mm.i.g)localObject).frb = this.hIz;
            if (!w.sQ(this.dpq.field_talker)) {
              break label1042;
            }
          }
          label1042:
          for (i = 1;; i = 0)
          {
            ((com.tencent.mm.i.g)localObject).field_chattype = i;
            if (!bs.isNullOrNil(paramg.hhL))
            {
              ((com.tencent.mm.i.g)localObject).field_fileType = 19;
              ((com.tencent.mm.i.g)localObject).field_authKey = paramg.hhR;
              ((com.tencent.mm.i.g)localObject).fre = paramg.hhL;
              ((com.tencent.mm.i.g)localObject).field_fileId = "";
            }
            ac.i("MicroMsg.NetSceneDownloadAppAttach", "summerbig checkUseCdn addRecvTask taskInfo field_fileType[%d], fileFullPath[%s], aeskey[%s], signature[%s], faeskey[%s], fsignature[%s], onlycheckexist[%s]", new Object[] { Integer.valueOf(((com.tencent.mm.i.g)localObject).field_fileType), ((com.tencent.mm.i.g)localObject).field_fullpath, bs.aLJ(((com.tencent.mm.i.g)localObject).field_aesKey), bs.aLJ(((com.tencent.mm.i.g)localObject).field_svr_signature), bs.aLJ(((com.tencent.mm.i.g)localObject).field_fake_bigfile_signature_aeskey), bs.aLJ(((com.tencent.mm.i.g)localObject).field_fake_bigfile_signature), Boolean.valueOf(((com.tencent.mm.i.g)localObject).field_onlycheckexist) });
            if (com.tencent.mm.an.f.aDD().b((com.tencent.mm.i.g)localObject, -1)) {
              break label1047;
            }
            ac.e("MicroMsg.NetSceneDownloadAppAttach", "summerbig cdntra addSendTask failed.");
            this.hIq = "";
            i = 0;
            break;
            i = com.tencent.mm.i.a.MediaType_FILE;
            break label757;
          }
          label1047:
          if (this.wiN.field_isUseCdn != 1)
          {
            this.wiN.field_isUseCdn = 1;
            boolean bool = com.tencent.mm.plugin.s.a.bEO().a(this.wiN, new String[0]);
            if (!bool)
            {
              ac.e("MicroMsg.NetSceneDownloadAppAttach", "summerbig checkUseCdn update info ret:".concat(String.valueOf(bool)));
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
    if (this.wiN.field_status == 102L)
    {
      this.wiN.field_status = 101L;
      if (!this.wiS) {
        com.tencent.mm.plugin.s.a.bEO().a(this.wiN, new String[0]);
      }
    }
    this.wiP = this.wiN.systemRowid;
    if ((bs.isNullOrNil(this.wiN.field_mediaSvrId)) && (this.mWU == 0L))
    {
      ac.e("MicroMsg.NetSceneDownloadAppAttach", "checkArgs : mediaId is null");
      this.retCode = (-10000 - com.tencent.mm.compatible.util.f.getLine());
      AppMethodBeat.o(9480);
      return -1;
    }
    if ((this.wiN.field_totalLen <= 0L) || (this.wiN.field_totalLen > 26214400L))
    {
      ac.e("MicroMsg.NetSceneDownloadAppAttach", "checkArgs : totalLen is invalid, totalLen = " + this.wiN.field_totalLen);
      this.retCode = (-10000 - com.tencent.mm.compatible.util.f.getLine());
      AppMethodBeat.o(9480);
      return -1;
    }
    if ((bs.isNullOrNil(this.wiN.field_fileFullPath)) && (this.mWU == 0L))
    {
      ac.e("MicroMsg.NetSceneDownloadAppAttach", "checkArgs : fileFullPath is null");
      this.retCode = (-10000 - com.tencent.mm.compatible.util.f.getLine());
      AppMethodBeat.o(9480);
      return -1;
    }
    int j = (int)i.aSp(this.wiN.field_fileFullPath);
    int i = j;
    if (this.wiU)
    {
      i = j - 6;
      if (i <= 0) {
        break label1464;
      }
    }
    while (i != this.wiN.field_offset)
    {
      ac.e("MicroMsg.NetSceneDownloadAppAttach", "checkArgs : fileFullPath is invalid, fileLength = " + i + ", info.field_offset = " + this.wiN.field_offset);
      this.retCode = (-10000 - com.tencent.mm.compatible.util.f.getLine());
      AppMethodBeat.o(9480);
      return -1;
      label1464:
      i = 0;
    }
    ac.i("MicroMsg.NetSceneDownloadAppAttach", "downing attach by non cdn, appId: %s,  mediaId: %s, sdkVer: %d", new Object[] { this.wiN.field_appId, this.wiN.field_mediaSvrId, Long.valueOf(this.wiN.field_sdkVer) });
    paramg = (adc)this.rr.hvr.hvw;
    paramg.hOf = this.wiN.field_appId;
    paramg.hOi = this.wiN.field_mediaSvrId;
    paramg.DRa = ((int)this.wiN.field_sdkVer);
    paramg.ncR = u.axw();
    paramg.vTH = ((int)this.wiN.field_totalLen);
    paramg.vTI = ((int)this.wiN.field_offset);
    paramg.vTJ = 0;
    if (this.mWU != 0L) {
      paramg.vTQ = this.mWU;
    }
    if (this.type != 0) {}
    for (paramg.ndI = this.type;; paramg.ndI = ((int)this.wiN.field_type))
    {
      i = dispatch(parame, this.rr, this);
      AppMethodBeat.o(9480);
      return i;
    }
  }
  
  public final void dtL()
  {
    AppMethodBeat.i(9478);
    this.wiU = true;
    if (this.wiU)
    {
      String str = this.wiN.field_fileFullPath;
      byte[] arrayOfByte = "#!AMR\n".getBytes();
      i.e(str, arrayOfByte, arrayOfByte.length);
    }
    AppMethodBeat.o(9478);
  }
  
  public final String getMediaId()
  {
    if (this.wiN == null) {
      return "";
    }
    return this.wiN.field_mediaSvrId;
  }
  
  public final int getType()
  {
    return 221;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(9481);
    ac.d("MicroMsg.NetSceneDownloadAppAttach", "onGYNetEnd : errType = " + paramInt2 + ", errCode = " + paramInt3);
    if ((paramInt2 == 3) && (paramInt3 == -1) && (!bs.isNullOrNil(this.hIq)))
    {
      ac.w("MicroMsg.NetSceneDownloadAppAttach", "cdntra using cdn trans,  wait cdn service callback! clientid:%s", new Object[] { this.hIq });
      AppMethodBeat.o(9481);
      return;
    }
    if ((paramInt2 != 0) || (paramInt3 != 0))
    {
      ac.e("MicroMsg.NetSceneDownloadAppAttach", "onGYNetEnd : errType = " + paramInt2 + ", errCode = " + paramInt3);
      this.retCode = (-10000 - com.tencent.mm.compatible.util.f.getLine());
      if (paramInt2 == 4) {
        com.tencent.mm.plugin.report.service.h.wUl.f(10420, new Object[] { Integer.valueOf(paramInt3), Integer.valueOf(2), Long.valueOf(this.startTime), Long.valueOf(bs.eWj()), Integer.valueOf(com.tencent.mm.an.c.cD(ai.getContext())), Integer.valueOf(com.tencent.mm.i.a.MediaType_FILE), Integer.valueOf(0) });
      }
      h(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(9481);
      return;
    }
    paramString = (add)((com.tencent.mm.ak.b)paramq).hvs.hvw;
    this.wiN.field_totalLen = paramString.vTH;
    if ((paramString.hOi != null) && (!paramString.hOi.equals(this.wiN.field_mediaSvrId)))
    {
      ac.e("MicroMsg.NetSceneDownloadAppAttach", "argument is not consistent");
      this.retCode = (-10000 - com.tencent.mm.compatible.util.f.getLine());
      h(3, -1, "", this);
      AppMethodBeat.o(9481);
      return;
    }
    if (paramString.vTI != this.wiN.field_offset)
    {
      ac.e("MicroMsg.NetSceneDownloadAppAttach", "startPos, totalLen is incorrect startpos:" + paramString.vTI);
      this.retCode = (-10000 - com.tencent.mm.compatible.util.f.getLine());
      h(3, -1, "", this);
      AppMethodBeat.o(9481);
      return;
    }
    if (paramString.vTJ + this.wiN.field_offset > this.wiN.field_totalLen)
    {
      ac.e("MicroMsg.NetSceneDownloadAppAttach", "data buffer is incorrect datalen:" + paramString.vTJ + " off:" + this.wiN.field_offset + " total?:" + this.wiN.field_totalLen);
      this.retCode = (-10000 - com.tencent.mm.compatible.util.f.getLine());
      h(3, -1, "", this);
      AppMethodBeat.o(9481);
      return;
    }
    paramArrayOfByte = z.a(paramString.vTK);
    if ((paramArrayOfByte == null) || (paramArrayOfByte.length == 0) || (paramArrayOfByte.length != paramString.vTJ))
    {
      ac.e("MicroMsg.NetSceneDownloadAppAttach", "data buffer is incorrect");
      this.retCode = (-10000 - com.tencent.mm.compatible.util.f.getLine());
      h(3, -1, "", this);
      AppMethodBeat.o(9481);
      return;
    }
    if (a.q(this.mediaId, this.msgId) == null)
    {
      ac.e("MicroMsg.NetSceneDownloadAppAttach", "append to file failed, msg maybe revoked or deleted. msgId:%d", new Object[] { Long.valueOf(this.wiN.field_msgInfoId) });
      this.retCode = (-10000 - com.tencent.mm.compatible.util.f.getLine());
      h(3, -1, "", this);
      AppMethodBeat.o(9481);
      return;
    }
    paramq = new String(paramArrayOfByte);
    ac.d("MicroMsg.NetSceneDownloadAppAttach", "dancy download big appmsg : %s", new Object[] { Boolean.valueOf(this.wiT) });
    bo localbo;
    StringBuffer localStringBuffer;
    if ((this.wiN.field_offset < this.wiN.field_totalLen) && (this.wiT))
    {
      localbo = ((com.tencent.mm.plugin.messenger.foundation.a.k)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).dcr().vP(this.wiN.field_msgInfoId);
      paramString = paramq;
      if (paramq.startsWith("<?xml version="))
      {
        paramInt1 = paramq.indexOf("<appmsg");
        ac.i("MicroMsg.NetSceneDownloadAppAttach", "inclued: <?xml version=  index:%s", new Object[] { Integer.valueOf(paramInt1) });
        paramString = paramq;
        if (paramInt1 > 0) {
          paramString = paramq.substring(paramInt1);
        }
      }
      if (!paramString.startsWith("<appmsg")) {
        break label1044;
      }
      if (!w.sQ(localbo.field_talker)) {
        break label1032;
      }
      if (!bs.isNullOrNil(localbo.field_content))
      {
        paramq = localbo.field_content.split("\n", 2)[0];
        localStringBuffer = new StringBuffer();
        this.wiN.field_fullXml = (paramq + "\n");
        paramq = new StringBuffer();
        paramq.append(this.wiN.field_fullXml).append(paramString);
        this.wiN.field_fullXml = paramq.toString();
      }
    }
    for (;;)
    {
      localbo.setContent(this.wiN.field_fullXml);
      ((com.tencent.mm.plugin.messenger.foundation.a.k)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).dcr().a(this.wiN.field_msgInfoId, localbo);
      ac.d("MicroMsg.NetSceneDownloadAppAttach", "dancy download full xml succed! xml: [%s]", new Object[] { paramString });
      paramInt1 = i.e(this.wiN.field_fileFullPath, paramArrayOfByte, paramArrayOfByte.length);
      if ((bs.isNullOrNil(this.wiN.field_fileFullPath)) || (paramInt1 == 0)) {
        break;
      }
      ac.e("MicroMsg.NetSceneDownloadAppAttach", "append to file failed:".concat(String.valueOf(paramInt1)));
      this.retCode = (-10000 - com.tencent.mm.compatible.util.f.getLine());
      h(3, -1, "", this);
      AppMethodBeat.o(9481);
      return;
      label1032:
      this.wiN.field_fullXml = paramString;
      continue;
      label1044:
      if (!localbo.field_content.startsWith("<msg>"))
      {
        paramq = new StringBuffer();
        paramq.append(localbo.field_content).append(paramString);
        this.wiN.field_fullXml = paramq.toString();
      }
      if ((paramString.endsWith("</appmsg>")) || (this.wiN.field_offset + paramArrayOfByte.length == this.wiN.field_totalLen))
      {
        if (w.sQ(localbo.field_talker))
        {
          paramq = localbo.field_content.split("\n", 2);
          Object localObject = paramq[0];
          localStringBuffer = new StringBuffer();
          localObject = localStringBuffer.append((String)localObject).append("\n<msg>");
          if (paramq.length > 1) {}
          for (paramq = paramq[1];; paramq = "")
          {
            ((StringBuffer)localObject).append(paramq).append(paramString).append("</msg>");
            this.wiN.field_fullXml = localStringBuffer.toString();
            break;
          }
        }
        paramq = new StringBuffer();
        paramq.append("<msg>").append(this.wiN.field_fullXml).append("</msg>");
        this.wiN.field_fullXml = paramq.toString();
      }
    }
    paramString = this.wiN;
    long l = paramString.field_offset;
    paramString.field_offset = (paramArrayOfByte.length + l);
    if (this.wiN.field_offset == this.wiN.field_totalLen) {
      this.wiN.field_status = 199L;
    }
    if (this.hIl != null) {
      ap.f(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(9474);
          e.this.hIl.a((int)e.this.wiN.field_offset, (int)e.this.wiN.field_totalLen, e.this);
          AppMethodBeat.o(9474);
        }
      });
    }
    if (this.wiS) {}
    for (boolean bool = true; !bool; bool = com.tencent.mm.plugin.s.a.bEO().a(this.wiN, new String[0]))
    {
      ac.e("MicroMsg.NetSceneDownloadAppAttach", "onGYNetEnd update info ret:".concat(String.valueOf(paramInt1)));
      this.retCode = (-10000 - com.tencent.mm.compatible.util.f.getLine());
      h(3, -1, "", this);
      AppMethodBeat.o(9481);
      return;
    }
    if (this.wiN.field_status == 199L)
    {
      com.tencent.mm.plugin.report.service.h.wUl.f(10420, new Object[] { Integer.valueOf(0), Integer.valueOf(2), Long.valueOf(this.startTime), Long.valueOf(bs.eWj()), Integer.valueOf(com.tencent.mm.an.c.cD(ai.getContext())), Integer.valueOf(com.tencent.mm.i.a.MediaType_FILE), Long.valueOf(this.wiN.field_totalLen - this.wiQ) });
      paramString = ((com.tencent.mm.plugin.messenger.foundation.a.k)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).dcr().vP(this.wiN.field_msgInfoId);
      ((com.tencent.mm.plugin.messenger.foundation.a.k)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).dcr().a(new h.c(paramString.field_talker, "update", paramString));
      h(0, 0, "", this);
      AppMethodBeat.o(9481);
      return;
    }
    if (this.wiN.field_status == 102L)
    {
      h(3, -1, "", this);
      this.retCode = -20102;
      AppMethodBeat.o(9481);
      return;
    }
    if (doScene(dispatcher(), this.callback) < 0)
    {
      ac.e("MicroMsg.NetSceneDownloadAppAttach", "onGYNetEnd : doScene fail");
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
    return n.b.hwa;
  }
  
  public static abstract interface a
  {
    public abstract void dtM();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.record.b.e
 * JD-Core Version:    0.7.0.1
 */