package com.tencent.mm.plugin.record.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.k.b;
import com.tencent.mm.al.b.a;
import com.tencent.mm.al.b.b;
import com.tencent.mm.al.b.c;
import com.tencent.mm.al.n;
import com.tencent.mm.al.n.b;
import com.tencent.mm.g.c.du;
import com.tencent.mm.i.g.a;
import com.tencent.mm.model.bi;
import com.tencent.mm.model.u;
import com.tencent.mm.model.w;
import com.tencent.mm.network.q;
import com.tencent.mm.platformtools.z;
import com.tencent.mm.plugin.messenger.foundation.a.a.h.c;
import com.tencent.mm.protocal.protobuf.acd;
import com.tencent.mm.protocal.protobuf.ace;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.bl;
import com.tencent.mm.vfs.i;
import java.io.ByteArrayOutputStream;

public final class e
  extends n
  implements com.tencent.mm.network.k
{
  private com.tencent.mm.al.g callback;
  bl drF;
  com.tencent.mm.al.h hhI;
  String hhN;
  private g.a hhW;
  private String mediaId;
  public long msgId;
  private long muT;
  public boolean ofM;
  public int retCode;
  private com.tencent.mm.al.b rr;
  long startTime;
  private int type;
  com.tencent.mm.pluginsdk.model.app.c uZZ;
  public long vab;
  private int vac;
  String vad;
  private boolean vae;
  private boolean vaf;
  private boolean vag;
  
  public e(long paramLong1, long paramLong2, com.tencent.mm.al.h paramh)
  {
    AppMethodBeat.i(9475);
    this.uZZ = null;
    this.vab = -1L;
    this.mediaId = "";
    this.msgId = 0L;
    this.drF = null;
    this.hhN = "";
    this.startTime = 0L;
    this.vac = -1;
    this.vad = "";
    this.type = 0;
    this.retCode = 0;
    this.vae = false;
    this.vaf = false;
    this.muT = 0L;
    this.ofM = false;
    this.vag = false;
    this.hhW = new g.a()
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
          ad.i("MicroMsg.NetSceneDownloadAppAttach", "summerbig callback cdntra  ERR_CNDCOM_MEDIA_IS_DOWNLOADING clientid:%s", new Object[] { e.this.hhN });
          AppMethodBeat.o(9473);
          return 0;
        }
        if (paramAnonymousInt != 0)
        {
          a.rO(e.this.uZZ.systemRowid);
          new com.tencent.mm.g.b.a.h(com.tencent.mm.plugin.report.a.s(new Object[] { Integer.valueOf(paramAnonymousInt), Integer.valueOf(2), Long.valueOf(e.this.startTime), Long.valueOf(bt.eGO()), Integer.valueOf(com.tencent.mm.ao.c.cu(aj.getContext())), Integer.valueOf(com.tencent.mm.i.a.MediaType_FILE), Integer.valueOf(0), "" })).aBj();
          aq.f(new Runnable()
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
        e.this.uZZ = a.q(paramAnonymousString, e.this.msgId);
        if (e.this.uZZ == null)
        {
          ad.e("MicroMsg.NetSceneDownloadAppAttach", "summerbig attachInfo is null");
          aq.f(new Runnable()
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
        if (e.this.uZZ.field_status == 102L)
        {
          ad.i("MicroMsg.NetSceneDownloadAppAttach", "summerbig dancy attach download has paused, status:%d", new Object[] { Long.valueOf(e.this.uZZ.field_status) });
          com.tencent.mm.ao.f.awL().xK(e.this.hhN);
          aq.f(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(9467);
              e.a(e.this, 3, paramAnonymousInt, "attach  has paused, status=" + e.this.uZZ.field_status, e.this);
              AppMethodBeat.o(9467);
            }
          });
          AppMethodBeat.o(9473);
          return 0;
        }
        if (paramAnonymousc != null)
        {
          if (paramAnonymousc.field_finishedLength == e.this.uZZ.field_totalLen)
          {
            ad.i("MicroMsg.NetSceneDownloadAppAttach", "summerbig callback cdntra ignore progress 100%");
            AppMethodBeat.o(9473);
            return 0;
          }
          if (e.this.uZZ.field_offset > paramAnonymousc.field_finishedLength)
          {
            ad.e("MicroMsg.NetSceneDownloadAppAttach", "summerbig callback cdnEndProc error oldpos:%d newpos:%d", new Object[] { Long.valueOf(e.this.uZZ.field_offset), Long.valueOf(paramAnonymousc.field_finishedLength) });
            a.rO(e.this.uZZ.systemRowid);
            aq.f(new Runnable()
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
          e.this.uZZ.field_offset = paramAnonymousc.field_finishedLength;
          com.tencent.mm.plugin.s.a.bxS().a(e.this.uZZ, new String[0]);
          if (e.this.hhI != null) {
            aq.f(new Runnable()
            {
              public final void run()
              {
                AppMethodBeat.i(9469);
                e.this.hhI.a((int)e.this.uZZ.field_offset, (int)e.this.uZZ.field_totalLen, e.this);
                AppMethodBeat.o(9469);
              }
            });
          }
          ad.d("MicroMsg.NetSceneDownloadAppAttach", "summerbig callback cdntra progresscallback id:%s finish:%d total:%d", new Object[] { e.this.hhN, Long.valueOf(paramAnonymousc.field_finishedLength), Long.valueOf(paramAnonymousc.field_toltalLength) });
          AppMethodBeat.o(9473);
          return 0;
        }
        if (paramAnonymousd != null)
        {
          if (paramAnonymousd.field_retCode == 0) {
            break label1001;
          }
          a.rO(e.this.uZZ.systemRowid);
          ad.e("MicroMsg.NetSceneDownloadAppAttach", "summerbig callback cdntra sceneResult.retCode :%d", new Object[] { Integer.valueOf(paramAnonymousd.field_retCode) });
          new com.tencent.mm.g.b.a.h(com.tencent.mm.plugin.report.a.s(new Object[] { Integer.valueOf(paramAnonymousd.field_retCode), Integer.valueOf(2), Long.valueOf(e.this.startTime), Long.valueOf(bt.eGO()), Integer.valueOf(com.tencent.mm.ao.c.cu(aj.getContext())), Integer.valueOf(com.tencent.mm.i.a.MediaType_FILE), Long.valueOf(e.this.uZZ.field_totalLen), paramAnonymousd.field_transInfo, "", "", "", "", "", "", "", paramAnonymousd.fns })).aBj();
          if (paramAnonymousd.field_retCode != 0) {
            new com.tencent.mm.g.b.a.f(com.tencent.mm.plugin.report.a.s(new Object[] { Integer.valueOf(paramAnonymousd.field_retCode), Integer.valueOf(2), Long.valueOf(e.this.startTime), Long.valueOf(bt.eGO()), Integer.valueOf(com.tencent.mm.ao.c.cu(aj.getContext())), Integer.valueOf(com.tencent.mm.i.a.MediaType_FILE), Long.valueOf(e.this.uZZ.field_totalLen), paramAnonymousd.field_transInfo, "", "", "", "", "", "", "", paramAnonymousd.fns })).aBj();
          }
          if (e.this.hhI != null) {
            aq.f(new Runnable()
            {
              public final void run()
              {
                AppMethodBeat.i(9470);
                e.this.hhI.a((int)e.this.uZZ.field_offset, (int)e.this.uZZ.field_totalLen, e.this);
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
          new com.tencent.mm.vfs.e(e.this.vad).af(new com.tencent.mm.vfs.e(e.this.uZZ.field_fileFullPath));
          e.this.uZZ.field_status = 199L;
          e.this.uZZ.field_offset = e.this.uZZ.field_totalLen;
          com.tencent.mm.plugin.s.a.bxS().a(e.this.uZZ, new String[0]);
          com.tencent.mm.plugin.report.service.h.vKh.idkeyStat(198L, 45L, e.this.uZZ.field_totalLen, false);
          com.tencent.mm.plugin.report.service.h.vKh.idkeyStat(198L, 46L, 1L, false);
          paramAnonymousc = com.tencent.mm.plugin.report.service.h.vKh;
          if (e.this.drF == null)
          {
            paramAnonymousString = "";
            label1141:
            if (!w.pF(paramAnonymousString)) {
              break label1248;
            }
          }
          label1248:
          for (long l = 48L;; l = 47L)
          {
            paramAnonymousc.idkeyStat(198L, l, 1L, false);
            paramAnonymousString = ((com.tencent.mm.plugin.messenger.foundation.a.k)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).cOI().rm(e.this.uZZ.field_msgInfoId);
            if (paramAnonymousString.field_status != 5) {
              break label1256;
            }
            paramAnonymousString.setStatus(3);
            ((com.tencent.mm.plugin.messenger.foundation.a.k)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).cOI().a(paramAnonymousString.field_msgId, paramAnonymousString);
            break;
            paramAnonymousString = e.this.drF.field_talker;
            break label1141;
          }
          label1256:
          ((com.tencent.mm.plugin.messenger.foundation.a.k)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).cOI().a(new h.c(paramAnonymousString.field_talker, "update", paramAnonymousString));
          break;
          label1293:
          aq.f(new Runnable()
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
    this.muT = paramLong2;
    this.msgId = paramLong1;
    this.uZZ = com.tencent.mm.plugin.s.a.bxS().vj(paramLong1);
    this.hhI = paramh;
    this.vaf = true;
    if (this.uZZ == null)
    {
      ad.e("MicroMsg.NetSceneDownloadAppAttach", "big appMsg, info is null, msgid = , svrId".concat(String.valueOf(paramLong1)), new Object[] { Long.valueOf(paramLong2) });
      AppMethodBeat.o(9475);
      return;
    }
    paramh = new b.a();
    paramh.gUU = new acd();
    paramh.gUV = new ace();
    paramh.uri = "/cgi-bin/micromsg-bin/downloadappattach";
    paramh.funcId = 221;
    paramh.reqCmdId = 106;
    paramh.respCmdId = 1000000106;
    this.rr = paramh.atI();
    AppMethodBeat.o(9475);
  }
  
  public e(long paramLong, String paramString, com.tencent.mm.al.h paramh)
  {
    this(paramString, paramLong, paramh);
    this.msgId = paramLong;
  }
  
  public e(com.tencent.mm.pluginsdk.model.app.c paramc)
  {
    AppMethodBeat.i(9476);
    this.uZZ = null;
    this.vab = -1L;
    this.mediaId = "";
    this.msgId = 0L;
    this.drF = null;
    this.hhN = "";
    this.startTime = 0L;
    this.vac = -1;
    this.vad = "";
    this.type = 0;
    this.retCode = 0;
    this.vae = false;
    this.vaf = false;
    this.muT = 0L;
    this.ofM = false;
    this.vag = false;
    this.hhW = new g.a()
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
          ad.i("MicroMsg.NetSceneDownloadAppAttach", "summerbig callback cdntra  ERR_CNDCOM_MEDIA_IS_DOWNLOADING clientid:%s", new Object[] { e.this.hhN });
          AppMethodBeat.o(9473);
          return 0;
        }
        if (paramAnonymousInt != 0)
        {
          a.rO(e.this.uZZ.systemRowid);
          new com.tencent.mm.g.b.a.h(com.tencent.mm.plugin.report.a.s(new Object[] { Integer.valueOf(paramAnonymousInt), Integer.valueOf(2), Long.valueOf(e.this.startTime), Long.valueOf(bt.eGO()), Integer.valueOf(com.tencent.mm.ao.c.cu(aj.getContext())), Integer.valueOf(com.tencent.mm.i.a.MediaType_FILE), Integer.valueOf(0), "" })).aBj();
          aq.f(new Runnable()
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
        e.this.uZZ = a.q(paramAnonymousString, e.this.msgId);
        if (e.this.uZZ == null)
        {
          ad.e("MicroMsg.NetSceneDownloadAppAttach", "summerbig attachInfo is null");
          aq.f(new Runnable()
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
        if (e.this.uZZ.field_status == 102L)
        {
          ad.i("MicroMsg.NetSceneDownloadAppAttach", "summerbig dancy attach download has paused, status:%d", new Object[] { Long.valueOf(e.this.uZZ.field_status) });
          com.tencent.mm.ao.f.awL().xK(e.this.hhN);
          aq.f(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(9467);
              e.a(e.this, 3, paramAnonymousInt, "attach  has paused, status=" + e.this.uZZ.field_status, e.this);
              AppMethodBeat.o(9467);
            }
          });
          AppMethodBeat.o(9473);
          return 0;
        }
        if (paramAnonymousc != null)
        {
          if (paramAnonymousc.field_finishedLength == e.this.uZZ.field_totalLen)
          {
            ad.i("MicroMsg.NetSceneDownloadAppAttach", "summerbig callback cdntra ignore progress 100%");
            AppMethodBeat.o(9473);
            return 0;
          }
          if (e.this.uZZ.field_offset > paramAnonymousc.field_finishedLength)
          {
            ad.e("MicroMsg.NetSceneDownloadAppAttach", "summerbig callback cdnEndProc error oldpos:%d newpos:%d", new Object[] { Long.valueOf(e.this.uZZ.field_offset), Long.valueOf(paramAnonymousc.field_finishedLength) });
            a.rO(e.this.uZZ.systemRowid);
            aq.f(new Runnable()
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
          e.this.uZZ.field_offset = paramAnonymousc.field_finishedLength;
          com.tencent.mm.plugin.s.a.bxS().a(e.this.uZZ, new String[0]);
          if (e.this.hhI != null) {
            aq.f(new Runnable()
            {
              public final void run()
              {
                AppMethodBeat.i(9469);
                e.this.hhI.a((int)e.this.uZZ.field_offset, (int)e.this.uZZ.field_totalLen, e.this);
                AppMethodBeat.o(9469);
              }
            });
          }
          ad.d("MicroMsg.NetSceneDownloadAppAttach", "summerbig callback cdntra progresscallback id:%s finish:%d total:%d", new Object[] { e.this.hhN, Long.valueOf(paramAnonymousc.field_finishedLength), Long.valueOf(paramAnonymousc.field_toltalLength) });
          AppMethodBeat.o(9473);
          return 0;
        }
        if (paramAnonymousd != null)
        {
          if (paramAnonymousd.field_retCode == 0) {
            break label1001;
          }
          a.rO(e.this.uZZ.systemRowid);
          ad.e("MicroMsg.NetSceneDownloadAppAttach", "summerbig callback cdntra sceneResult.retCode :%d", new Object[] { Integer.valueOf(paramAnonymousd.field_retCode) });
          new com.tencent.mm.g.b.a.h(com.tencent.mm.plugin.report.a.s(new Object[] { Integer.valueOf(paramAnonymousd.field_retCode), Integer.valueOf(2), Long.valueOf(e.this.startTime), Long.valueOf(bt.eGO()), Integer.valueOf(com.tencent.mm.ao.c.cu(aj.getContext())), Integer.valueOf(com.tencent.mm.i.a.MediaType_FILE), Long.valueOf(e.this.uZZ.field_totalLen), paramAnonymousd.field_transInfo, "", "", "", "", "", "", "", paramAnonymousd.fns })).aBj();
          if (paramAnonymousd.field_retCode != 0) {
            new com.tencent.mm.g.b.a.f(com.tencent.mm.plugin.report.a.s(new Object[] { Integer.valueOf(paramAnonymousd.field_retCode), Integer.valueOf(2), Long.valueOf(e.this.startTime), Long.valueOf(bt.eGO()), Integer.valueOf(com.tencent.mm.ao.c.cu(aj.getContext())), Integer.valueOf(com.tencent.mm.i.a.MediaType_FILE), Long.valueOf(e.this.uZZ.field_totalLen), paramAnonymousd.field_transInfo, "", "", "", "", "", "", "", paramAnonymousd.fns })).aBj();
          }
          if (e.this.hhI != null) {
            aq.f(new Runnable()
            {
              public final void run()
              {
                AppMethodBeat.i(9470);
                e.this.hhI.a((int)e.this.uZZ.field_offset, (int)e.this.uZZ.field_totalLen, e.this);
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
          new com.tencent.mm.vfs.e(e.this.vad).af(new com.tencent.mm.vfs.e(e.this.uZZ.field_fileFullPath));
          e.this.uZZ.field_status = 199L;
          e.this.uZZ.field_offset = e.this.uZZ.field_totalLen;
          com.tencent.mm.plugin.s.a.bxS().a(e.this.uZZ, new String[0]);
          com.tencent.mm.plugin.report.service.h.vKh.idkeyStat(198L, 45L, e.this.uZZ.field_totalLen, false);
          com.tencent.mm.plugin.report.service.h.vKh.idkeyStat(198L, 46L, 1L, false);
          paramAnonymousc = com.tencent.mm.plugin.report.service.h.vKh;
          if (e.this.drF == null)
          {
            paramAnonymousString = "";
            label1141:
            if (!w.pF(paramAnonymousString)) {
              break label1248;
            }
          }
          label1248:
          for (long l = 48L;; l = 47L)
          {
            paramAnonymousc.idkeyStat(198L, l, 1L, false);
            paramAnonymousString = ((com.tencent.mm.plugin.messenger.foundation.a.k)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).cOI().rm(e.this.uZZ.field_msgInfoId);
            if (paramAnonymousString.field_status != 5) {
              break label1256;
            }
            paramAnonymousString.setStatus(3);
            ((com.tencent.mm.plugin.messenger.foundation.a.k)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).cOI().a(paramAnonymousString.field_msgId, paramAnonymousString);
            break;
            paramAnonymousString = e.this.drF.field_talker;
            break label1141;
          }
          label1256:
          ((com.tencent.mm.plugin.messenger.foundation.a.k)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).cOI().a(new h.c(paramAnonymousString.field_talker, "update", paramAnonymousString));
          break;
          label1293:
          aq.f(new Runnable()
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
    this.uZZ = paramc;
    this.vae = true;
    this.mediaId = this.uZZ.field_mediaId;
    this.hhI = null;
    this.type = 0;
    if (paramc == null)
    {
      ad.e("MicroMsg.NetSceneDownloadAppAttach", "summerbig <init>, info is null, mediaId = " + this.mediaId);
      AppMethodBeat.o(9476);
      return;
    }
    b.a locala = new b.a();
    locala.gUU = new acd();
    locala.gUV = new ace();
    locala.uri = "/cgi-bin/micromsg-bin/downloadappattach";
    locala.funcId = 221;
    locala.reqCmdId = 106;
    locala.respCmdId = 1000000106;
    this.rr = locala.atI();
    ad.i("MicroMsg.NetSceneDownloadAppAttach", "summerbig NetSceneDownloadAppAttach info fullpath[%s], justSaveFile[%b], stack[%s]", new Object[] { paramc.field_fileFullPath, Boolean.TRUE, bt.eGN() });
    AppMethodBeat.o(9476);
  }
  
  public e(String paramString)
  {
    this(paramString, 0L, null);
  }
  
  private e(String paramString, long paramLong, com.tencent.mm.al.h paramh)
  {
    AppMethodBeat.i(9477);
    this.uZZ = null;
    this.vab = -1L;
    this.mediaId = "";
    this.msgId = 0L;
    this.drF = null;
    this.hhN = "";
    this.startTime = 0L;
    this.vac = -1;
    this.vad = "";
    this.type = 0;
    this.retCode = 0;
    this.vae = false;
    this.vaf = false;
    this.muT = 0L;
    this.ofM = false;
    this.vag = false;
    this.hhW = new g.a()
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
          ad.i("MicroMsg.NetSceneDownloadAppAttach", "summerbig callback cdntra  ERR_CNDCOM_MEDIA_IS_DOWNLOADING clientid:%s", new Object[] { e.this.hhN });
          AppMethodBeat.o(9473);
          return 0;
        }
        if (paramAnonymousInt != 0)
        {
          a.rO(e.this.uZZ.systemRowid);
          new com.tencent.mm.g.b.a.h(com.tencent.mm.plugin.report.a.s(new Object[] { Integer.valueOf(paramAnonymousInt), Integer.valueOf(2), Long.valueOf(e.this.startTime), Long.valueOf(bt.eGO()), Integer.valueOf(com.tencent.mm.ao.c.cu(aj.getContext())), Integer.valueOf(com.tencent.mm.i.a.MediaType_FILE), Integer.valueOf(0), "" })).aBj();
          aq.f(new Runnable()
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
        e.this.uZZ = a.q(paramAnonymousString, e.this.msgId);
        if (e.this.uZZ == null)
        {
          ad.e("MicroMsg.NetSceneDownloadAppAttach", "summerbig attachInfo is null");
          aq.f(new Runnable()
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
        if (e.this.uZZ.field_status == 102L)
        {
          ad.i("MicroMsg.NetSceneDownloadAppAttach", "summerbig dancy attach download has paused, status:%d", new Object[] { Long.valueOf(e.this.uZZ.field_status) });
          com.tencent.mm.ao.f.awL().xK(e.this.hhN);
          aq.f(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(9467);
              e.a(e.this, 3, paramAnonymousInt, "attach  has paused, status=" + e.this.uZZ.field_status, e.this);
              AppMethodBeat.o(9467);
            }
          });
          AppMethodBeat.o(9473);
          return 0;
        }
        if (paramAnonymousc != null)
        {
          if (paramAnonymousc.field_finishedLength == e.this.uZZ.field_totalLen)
          {
            ad.i("MicroMsg.NetSceneDownloadAppAttach", "summerbig callback cdntra ignore progress 100%");
            AppMethodBeat.o(9473);
            return 0;
          }
          if (e.this.uZZ.field_offset > paramAnonymousc.field_finishedLength)
          {
            ad.e("MicroMsg.NetSceneDownloadAppAttach", "summerbig callback cdnEndProc error oldpos:%d newpos:%d", new Object[] { Long.valueOf(e.this.uZZ.field_offset), Long.valueOf(paramAnonymousc.field_finishedLength) });
            a.rO(e.this.uZZ.systemRowid);
            aq.f(new Runnable()
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
          e.this.uZZ.field_offset = paramAnonymousc.field_finishedLength;
          com.tencent.mm.plugin.s.a.bxS().a(e.this.uZZ, new String[0]);
          if (e.this.hhI != null) {
            aq.f(new Runnable()
            {
              public final void run()
              {
                AppMethodBeat.i(9469);
                e.this.hhI.a((int)e.this.uZZ.field_offset, (int)e.this.uZZ.field_totalLen, e.this);
                AppMethodBeat.o(9469);
              }
            });
          }
          ad.d("MicroMsg.NetSceneDownloadAppAttach", "summerbig callback cdntra progresscallback id:%s finish:%d total:%d", new Object[] { e.this.hhN, Long.valueOf(paramAnonymousc.field_finishedLength), Long.valueOf(paramAnonymousc.field_toltalLength) });
          AppMethodBeat.o(9473);
          return 0;
        }
        if (paramAnonymousd != null)
        {
          if (paramAnonymousd.field_retCode == 0) {
            break label1001;
          }
          a.rO(e.this.uZZ.systemRowid);
          ad.e("MicroMsg.NetSceneDownloadAppAttach", "summerbig callback cdntra sceneResult.retCode :%d", new Object[] { Integer.valueOf(paramAnonymousd.field_retCode) });
          new com.tencent.mm.g.b.a.h(com.tencent.mm.plugin.report.a.s(new Object[] { Integer.valueOf(paramAnonymousd.field_retCode), Integer.valueOf(2), Long.valueOf(e.this.startTime), Long.valueOf(bt.eGO()), Integer.valueOf(com.tencent.mm.ao.c.cu(aj.getContext())), Integer.valueOf(com.tencent.mm.i.a.MediaType_FILE), Long.valueOf(e.this.uZZ.field_totalLen), paramAnonymousd.field_transInfo, "", "", "", "", "", "", "", paramAnonymousd.fns })).aBj();
          if (paramAnonymousd.field_retCode != 0) {
            new com.tencent.mm.g.b.a.f(com.tencent.mm.plugin.report.a.s(new Object[] { Integer.valueOf(paramAnonymousd.field_retCode), Integer.valueOf(2), Long.valueOf(e.this.startTime), Long.valueOf(bt.eGO()), Integer.valueOf(com.tencent.mm.ao.c.cu(aj.getContext())), Integer.valueOf(com.tencent.mm.i.a.MediaType_FILE), Long.valueOf(e.this.uZZ.field_totalLen), paramAnonymousd.field_transInfo, "", "", "", "", "", "", "", paramAnonymousd.fns })).aBj();
          }
          if (e.this.hhI != null) {
            aq.f(new Runnable()
            {
              public final void run()
              {
                AppMethodBeat.i(9470);
                e.this.hhI.a((int)e.this.uZZ.field_offset, (int)e.this.uZZ.field_totalLen, e.this);
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
          new com.tencent.mm.vfs.e(e.this.vad).af(new com.tencent.mm.vfs.e(e.this.uZZ.field_fileFullPath));
          e.this.uZZ.field_status = 199L;
          e.this.uZZ.field_offset = e.this.uZZ.field_totalLen;
          com.tencent.mm.plugin.s.a.bxS().a(e.this.uZZ, new String[0]);
          com.tencent.mm.plugin.report.service.h.vKh.idkeyStat(198L, 45L, e.this.uZZ.field_totalLen, false);
          com.tencent.mm.plugin.report.service.h.vKh.idkeyStat(198L, 46L, 1L, false);
          paramAnonymousc = com.tencent.mm.plugin.report.service.h.vKh;
          if (e.this.drF == null)
          {
            paramAnonymousString = "";
            label1141:
            if (!w.pF(paramAnonymousString)) {
              break label1248;
            }
          }
          label1248:
          for (long l = 48L;; l = 47L)
          {
            paramAnonymousc.idkeyStat(198L, l, 1L, false);
            paramAnonymousString = ((com.tencent.mm.plugin.messenger.foundation.a.k)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).cOI().rm(e.this.uZZ.field_msgInfoId);
            if (paramAnonymousString.field_status != 5) {
              break label1256;
            }
            paramAnonymousString.setStatus(3);
            ((com.tencent.mm.plugin.messenger.foundation.a.k)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).cOI().a(paramAnonymousString.field_msgId, paramAnonymousString);
            break;
            paramAnonymousString = e.this.drF.field_talker;
            break label1141;
          }
          label1256:
          ((com.tencent.mm.plugin.messenger.foundation.a.k)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).cOI().a(new h.c(paramAnonymousString.field_talker, "update", paramAnonymousString));
          break;
          label1293:
          aq.f(new Runnable()
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
    this.hhI = paramh;
    this.type = 0;
    this.uZZ = com.tencent.mm.plugin.s.a.bxS().aAL(paramString);
    if (this.uZZ == null) {
      this.uZZ = com.tencent.mm.plugin.s.a.bxS().vj(paramLong);
    }
    if (this.uZZ == null)
    {
      ad.e("MicroMsg.NetSceneDownloadAppAttach", "summerbig <init>, info is null, mediaId = ".concat(String.valueOf(paramString)));
      AppMethodBeat.o(9477);
      return;
    }
    paramString = new b.a();
    paramString.gUU = new acd();
    paramString.gUV = new ace();
    paramString.uri = "/cgi-bin/micromsg-bin/downloadappattach";
    paramString.funcId = 221;
    paramString.reqCmdId = 106;
    paramString.respCmdId = 1000000106;
    this.rr = paramString.atI();
    ad.d("MicroMsg.NetSceneDownloadAppAttach", "summerbig NetSceneDownloadAppAttach , type[%d], info fullpath[%s], field_type[%d], signature[%s], stack[%s]", new Object[] { Integer.valueOf(0), this.uZZ.field_fileFullPath, Long.valueOf(this.uZZ.field_type), this.uZZ.field_signature, bt.eGN() });
    AppMethodBeat.o(9477);
  }
  
  private void h(int paramInt1, int paramInt2, String paramString, n paramn)
  {
    AppMethodBeat.i(9482);
    if (this.callback != null)
    {
      this.callback.onSceneEnd(paramInt1, paramInt2, paramString, paramn);
      if (this.uZZ != null)
      {
        long l = this.uZZ.field_msgInfoId;
        paramString = ((com.tencent.mm.plugin.messenger.foundation.a.k)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).cOI().rm(l);
        if ((paramInt1 == 0) && (paramInt2 == 0))
        {
          ((com.tencent.mm.plugin.comm.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.comm.a.b.class)).a(this.ofM, String.valueOf(l), paramString.field_msgSvrId, true);
          AppMethodBeat.o(9482);
          return;
        }
        ((com.tencent.mm.plugin.comm.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.comm.a.b.class)).a(this.ofM, String.valueOf(l), paramString.field_msgSvrId, false);
      }
    }
    AppMethodBeat.o(9482);
  }
  
  public final void a(a parama)
  {
    AppMethodBeat.i(9479);
    if (!this.vae)
    {
      com.tencent.mm.ao.f.awL().xL(this.hhN);
      this.uZZ = com.tencent.mm.plugin.s.a.bxS().vj(this.msgId);
      if (this.uZZ == null)
      {
        ad.i("MicroMsg.NetSceneDownloadAppAttach", "pause get by msgid  %是is null then get by mediaId %s", new Object[] { Long.valueOf(this.msgId), this.mediaId });
        this.uZZ = com.tencent.mm.plugin.s.a.bxS().aAL(this.mediaId);
      }
    }
    ad.i("MicroMsg.NetSceneDownloadAppAttach", "summerbig pause listener[%s], info[%s], justSaveFile[%b], stack[%s]", new Object[] { parama, this.uZZ, Boolean.valueOf(this.vae), bt.eGN() });
    if (this.uZZ == null)
    {
      AppMethodBeat.o(9479);
      return;
    }
    if ((this.uZZ.field_status == 101L) && (parama != null)) {
      parama.dgf();
    }
    this.uZZ.field_status = 102L;
    if (!this.vae) {
      ad.i("MicroMsg.NetSceneDownloadAppAttach", "pause done %s", new Object[] { Boolean.valueOf(com.tencent.mm.plugin.s.a.bxS().a(this.uZZ, new String[0])) });
    }
    AppMethodBeat.o(9479);
  }
  
  public final void dge()
  {
    AppMethodBeat.i(9478);
    this.vag = true;
    if (this.vag)
    {
      String str = this.uZZ.field_fileFullPath;
      byte[] arrayOfByte = "#!AMR\n".getBytes();
      i.e(str, arrayOfByte, arrayOfByte.length);
    }
    AppMethodBeat.o(9478);
  }
  
  public final int doScene(com.tencent.mm.network.e parame, com.tencent.mm.al.g paramg)
  {
    AppMethodBeat.i(9480);
    this.callback = paramg;
    if (this.uZZ == null)
    {
      ad.e("MicroMsg.NetSceneDownloadAppAttach", com.tencent.mm.compatible.util.f.XJ() + " get info failed mediaId:" + this.mediaId);
      this.retCode = (-10000 - com.tencent.mm.compatible.util.f.getLine());
      AppMethodBeat.o(9480);
      return -1;
    }
    this.drF = ((com.tencent.mm.plugin.messenger.foundation.a.k)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).cOI().rm(this.msgId);
    if ((this.drF == null) || (this.drF.field_msgId != this.msgId))
    {
      ad.e("MicroMsg.NetSceneDownloadAppAttach", com.tencent.mm.compatible.util.f.XJ() + " get msginfo failed mediaId:%s  msgId:%d", new Object[] { this.mediaId, Long.valueOf(this.msgId) });
      this.retCode = (-10000 - com.tencent.mm.compatible.util.f.getLine());
      AppMethodBeat.o(9480);
      return -1;
    }
    if (this.startTime == 0L)
    {
      this.startTime = bt.eGO();
      this.vac = ((int)this.uZZ.field_offset);
    }
    if (this.muT != 0L)
    {
      paramg = (acd)this.rr.gUS.gUX;
      paramg.mAQ = u.aqG();
      paramg.uKQ = ((int)this.uZZ.field_totalLen);
      paramg.uKR = ((int)this.uZZ.field_offset);
      paramg.uKS = 0;
      paramg.mBH = 40;
      paramg.uKZ = this.muT;
      i = dispatch(parame, this.rr, this);
      AppMethodBeat.o(9480);
      return i;
    }
    Object localObject = this.drF.field_content;
    paramg = (com.tencent.mm.al.g)localObject;
    if (w.pF(this.drF.field_talker))
    {
      i = bi.uc(this.drF.field_content);
      paramg = (com.tencent.mm.al.g)localObject;
      if (i != -1) {
        paramg = (this.drF.field_content + " ").substring(i + 2).trim();
      }
    }
    paramg = k.b.rx(bt.aGg(paramg));
    if (paramg == null)
    {
      ad.e("MicroMsg.NetSceneDownloadAppAttach", "summerbig checkUseCdn cdntra parse content xml failed: mediaId:%s", new Object[] { this.mediaId });
      i = 0;
    }
    while (i != 0)
    {
      ad.d("MicroMsg.NetSceneDownloadAppAttach", "cdntra use cdn return -1 for onGYNetEnd mediaid:%s", new Object[] { this.mediaId });
      AppMethodBeat.o(9480);
      return 0;
      ad.i("MicroMsg.NetSceneDownloadAppAttach", "summerbig cdntra checkUseCdn msgid:%d total:%d fullpath:%s fileid:%s aeskey:%s ", new Object[] { Long.valueOf(this.msgId), Long.valueOf(this.uZZ.field_totalLen), this.uZZ.field_fileFullPath, paramg.gHt, bt.aGs(paramg.fMw) });
      if (((bt.isNullOrNil(paramg.gHt)) && (bt.isNullOrNil(paramg.gHk))) || (bt.isNullOrNil(paramg.fMw)))
      {
        ad.w("MicroMsg.NetSceneDownloadAppAttach", "summerbig cdntra checkUseCdn msgId:%d Not use CDN  cdnAttachUrl:%s aes:%s ", new Object[] { Long.valueOf(this.msgId), paramg.gHt, bt.aGs(paramg.fMw) });
        i = 0;
      }
      else
      {
        this.hhN = com.tencent.mm.ao.c.a("downattach", this.uZZ.field_createTime, this.drF.field_talker, this.vab);
        if (bt.isNullOrNil(this.hhN))
        {
          ad.w("MicroMsg.NetSceneDownloadAppAttach", "summerbig cdntra genClientId failed not use cdn rowid:%d", new Object[] { Long.valueOf(this.vab) });
          i = 0;
        }
        else
        {
          i.aMF(i.aMQ(this.uZZ.field_fileFullPath));
          this.vad = (this.uZZ.field_fileFullPath + "_tmp");
          localObject = new com.tencent.mm.i.g();
          ((com.tencent.mm.i.g)localObject).field_mediaId = this.hhN;
          ((com.tencent.mm.i.g)localObject).field_fullpath = this.vad;
          if ((paramg.gHi != 0) || (paramg.gHe > 26214400))
          {
            i = com.tencent.mm.i.a.fmX;
            label757:
            ((com.tencent.mm.i.g)localObject).field_fileType = i;
            ((com.tencent.mm.i.g)localObject).field_totalLen = ((int)this.uZZ.field_totalLen);
            ((com.tencent.mm.i.g)localObject).field_aesKey = paramg.fMw;
            ((com.tencent.mm.i.g)localObject).field_fileId = paramg.gHt;
            ((com.tencent.mm.i.g)localObject).field_svr_signature = this.uZZ.field_signature;
            ((com.tencent.mm.i.g)localObject).field_fake_bigfile_signature_aeskey = this.uZZ.field_fakeAeskey;
            ((com.tencent.mm.i.g)localObject).field_fake_bigfile_signature = this.uZZ.field_fakeSignature;
            ((com.tencent.mm.i.g)localObject).field_onlycheckexist = false;
            ((com.tencent.mm.i.g)localObject).field_priority = com.tencent.mm.i.a.fmV;
            ((com.tencent.mm.i.g)localObject).fnH = this.hhW;
            if (!w.pF(this.drF.field_talker)) {
              break label1042;
            }
          }
          label1042:
          for (i = 1;; i = 0)
          {
            ((com.tencent.mm.i.g)localObject).field_chattype = i;
            if (!bt.isNullOrNil(paramg.gHk))
            {
              ((com.tencent.mm.i.g)localObject).field_fileType = 19;
              ((com.tencent.mm.i.g)localObject).field_authKey = paramg.gHq;
              ((com.tencent.mm.i.g)localObject).fnK = paramg.gHk;
              ((com.tencent.mm.i.g)localObject).field_fileId = "";
            }
            ad.i("MicroMsg.NetSceneDownloadAppAttach", "summerbig checkUseCdn addRecvTask taskInfo field_fileType[%d], fileFullPath[%s], aeskey[%s], signature[%s], faeskey[%s], fsignature[%s], onlycheckexist[%s]", new Object[] { Integer.valueOf(((com.tencent.mm.i.g)localObject).field_fileType), ((com.tencent.mm.i.g)localObject).field_fullpath, bt.aGs(((com.tencent.mm.i.g)localObject).field_aesKey), bt.aGs(((com.tencent.mm.i.g)localObject).field_svr_signature), bt.aGs(((com.tencent.mm.i.g)localObject).field_fake_bigfile_signature_aeskey), bt.aGs(((com.tencent.mm.i.g)localObject).field_fake_bigfile_signature), Boolean.valueOf(((com.tencent.mm.i.g)localObject).field_onlycheckexist) });
            if (com.tencent.mm.ao.f.awL().b((com.tencent.mm.i.g)localObject, -1)) {
              break label1047;
            }
            ad.e("MicroMsg.NetSceneDownloadAppAttach", "summerbig cdntra addSendTask failed.");
            this.hhN = "";
            i = 0;
            break;
            i = com.tencent.mm.i.a.MediaType_FILE;
            break label757;
          }
          label1047:
          if (this.uZZ.field_isUseCdn != 1)
          {
            this.uZZ.field_isUseCdn = 1;
            boolean bool = com.tencent.mm.plugin.s.a.bxS().a(this.uZZ, new String[0]);
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
    if (this.uZZ.field_status == 102L)
    {
      this.uZZ.field_status = 101L;
      if (!this.vae) {
        com.tencent.mm.plugin.s.a.bxS().a(this.uZZ, new String[0]);
      }
    }
    this.vab = this.uZZ.systemRowid;
    if ((bt.isNullOrNil(this.uZZ.field_mediaSvrId)) && (this.muT == 0L))
    {
      ad.e("MicroMsg.NetSceneDownloadAppAttach", "checkArgs : mediaId is null");
      this.retCode = (-10000 - com.tencent.mm.compatible.util.f.getLine());
      AppMethodBeat.o(9480);
      return -1;
    }
    if ((this.uZZ.field_totalLen <= 0L) || (this.uZZ.field_totalLen > 26214400L))
    {
      ad.e("MicroMsg.NetSceneDownloadAppAttach", "checkArgs : totalLen is invalid, totalLen = " + this.uZZ.field_totalLen);
      this.retCode = (-10000 - com.tencent.mm.compatible.util.f.getLine());
      AppMethodBeat.o(9480);
      return -1;
    }
    if ((bt.isNullOrNil(this.uZZ.field_fileFullPath)) && (this.muT == 0L))
    {
      ad.e("MicroMsg.NetSceneDownloadAppAttach", "checkArgs : fileFullPath is null");
      this.retCode = (-10000 - com.tencent.mm.compatible.util.f.getLine());
      AppMethodBeat.o(9480);
      return -1;
    }
    int j = (int)i.aMN(this.uZZ.field_fileFullPath);
    int i = j;
    if (this.vag)
    {
      i = j - 6;
      if (i <= 0) {
        break label1464;
      }
    }
    while (i != this.uZZ.field_offset)
    {
      ad.e("MicroMsg.NetSceneDownloadAppAttach", "checkArgs : fileFullPath is invalid, fileLength = " + i + ", info.field_offset = " + this.uZZ.field_offset);
      this.retCode = (-10000 - com.tencent.mm.compatible.util.f.getLine());
      AppMethodBeat.o(9480);
      return -1;
      label1464:
      i = 0;
    }
    ad.i("MicroMsg.NetSceneDownloadAppAttach", "downing attach by non cdn, appId: %s,  mediaId: %s, sdkVer: %d", new Object[] { this.uZZ.field_appId, this.uZZ.field_mediaSvrId, Long.valueOf(this.uZZ.field_sdkVer) });
    paramg = (acd)this.rr.gUS.gUX;
    paramg.hnC = this.uZZ.field_appId;
    paramg.hnF = this.uZZ.field_mediaSvrId;
    paramg.CyE = ((int)this.uZZ.field_sdkVer);
    paramg.mAQ = u.aqG();
    paramg.uKQ = ((int)this.uZZ.field_totalLen);
    paramg.uKR = ((int)this.uZZ.field_offset);
    paramg.uKS = 0;
    if (this.muT != 0L) {
      paramg.uKZ = this.muT;
    }
    if (this.type != 0) {}
    for (paramg.mBH = this.type;; paramg.mBH = ((int)this.uZZ.field_type))
    {
      i = dispatch(parame, this.rr, this);
      AppMethodBeat.o(9480);
      return i;
    }
  }
  
  public final String getMediaId()
  {
    if (this.uZZ == null) {
      return "";
    }
    return this.uZZ.field_mediaSvrId;
  }
  
  public final int getType()
  {
    return 221;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(9481);
    ad.d("MicroMsg.NetSceneDownloadAppAttach", "onGYNetEnd : errType = " + paramInt2 + ", errCode = " + paramInt3);
    if ((paramInt2 == 3) && (paramInt3 == -1) && (!bt.isNullOrNil(this.hhN)))
    {
      ad.w("MicroMsg.NetSceneDownloadAppAttach", "cdntra using cdn trans,  wait cdn service callback! clientid:%s", new Object[] { this.hhN });
      AppMethodBeat.o(9481);
      return;
    }
    if ((paramInt2 != 0) || (paramInt3 != 0))
    {
      ad.e("MicroMsg.NetSceneDownloadAppAttach", "onGYNetEnd : errType = " + paramInt2 + ", errCode = " + paramInt3);
      this.retCode = (-10000 - com.tencent.mm.compatible.util.f.getLine());
      if (paramInt2 == 4) {
        com.tencent.mm.plugin.report.service.h.vKh.f(10420, new Object[] { Integer.valueOf(paramInt3), Integer.valueOf(2), Long.valueOf(this.startTime), Long.valueOf(bt.eGO()), Integer.valueOf(com.tencent.mm.ao.c.cu(aj.getContext())), Integer.valueOf(com.tencent.mm.i.a.MediaType_FILE), Integer.valueOf(0) });
      }
      h(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(9481);
      return;
    }
    paramString = (ace)((com.tencent.mm.al.b)paramq).gUT.gUX;
    this.uZZ.field_totalLen = paramString.uKQ;
    if ((paramString.hnF != null) && (!paramString.hnF.equals(this.uZZ.field_mediaSvrId)))
    {
      ad.e("MicroMsg.NetSceneDownloadAppAttach", "argument is not consistent");
      this.retCode = (-10000 - com.tencent.mm.compatible.util.f.getLine());
      h(3, -1, "", this);
      AppMethodBeat.o(9481);
      return;
    }
    if (paramString.uKR != this.uZZ.field_offset)
    {
      ad.e("MicroMsg.NetSceneDownloadAppAttach", "startPos, totalLen is incorrect startpos:" + paramString.uKR);
      this.retCode = (-10000 - com.tencent.mm.compatible.util.f.getLine());
      h(3, -1, "", this);
      AppMethodBeat.o(9481);
      return;
    }
    if (paramString.uKS + this.uZZ.field_offset > this.uZZ.field_totalLen)
    {
      ad.e("MicroMsg.NetSceneDownloadAppAttach", "data buffer is incorrect datalen:" + paramString.uKS + " off:" + this.uZZ.field_offset + " total?:" + this.uZZ.field_totalLen);
      this.retCode = (-10000 - com.tencent.mm.compatible.util.f.getLine());
      h(3, -1, "", this);
      AppMethodBeat.o(9481);
      return;
    }
    paramArrayOfByte = z.a(paramString.uKT);
    if ((paramArrayOfByte == null) || (paramArrayOfByte.length == 0) || (paramArrayOfByte.length != paramString.uKS))
    {
      ad.e("MicroMsg.NetSceneDownloadAppAttach", "data buffer is incorrect");
      this.retCode = (-10000 - com.tencent.mm.compatible.util.f.getLine());
      h(3, -1, "", this);
      AppMethodBeat.o(9481);
      return;
    }
    if (a.q(this.mediaId, this.msgId) == null)
    {
      ad.e("MicroMsg.NetSceneDownloadAppAttach", "append to file failed, msg maybe revoked or deleted. msgId:%d", new Object[] { Long.valueOf(this.uZZ.field_msgInfoId) });
      this.retCode = (-10000 - com.tencent.mm.compatible.util.f.getLine());
      h(3, -1, "", this);
      AppMethodBeat.o(9481);
      return;
    }
    paramq = new String(paramArrayOfByte);
    ad.d("MicroMsg.NetSceneDownloadAppAttach", "dancy download big appmsg : %s", new Object[] { Boolean.valueOf(this.vaf) });
    bl localbl;
    StringBuffer localStringBuffer;
    if ((this.uZZ.field_offset < this.uZZ.field_totalLen) && (this.vaf))
    {
      localbl = ((com.tencent.mm.plugin.messenger.foundation.a.k)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).cOI().rm(this.uZZ.field_msgInfoId);
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
      if (!w.pF(localbl.field_talker)) {
        break label1032;
      }
      if (!bt.isNullOrNil(localbl.field_content))
      {
        paramq = localbl.field_content.split("\n", 2)[0];
        localStringBuffer = new StringBuffer();
        this.uZZ.field_fullXml = (paramq + "\n");
        paramq = new StringBuffer();
        paramq.append(this.uZZ.field_fullXml).append(paramString);
        this.uZZ.field_fullXml = paramq.toString();
      }
    }
    for (;;)
    {
      localbl.setContent(this.uZZ.field_fullXml);
      ((com.tencent.mm.plugin.messenger.foundation.a.k)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).cOI().a(this.uZZ.field_msgInfoId, localbl);
      ad.d("MicroMsg.NetSceneDownloadAppAttach", "dancy download full xml succed! xml: [%s]", new Object[] { paramString });
      paramInt1 = i.e(this.uZZ.field_fileFullPath, paramArrayOfByte, paramArrayOfByte.length);
      if ((bt.isNullOrNil(this.uZZ.field_fileFullPath)) || (paramInt1 == 0)) {
        break;
      }
      ad.e("MicroMsg.NetSceneDownloadAppAttach", "append to file failed:".concat(String.valueOf(paramInt1)));
      this.retCode = (-10000 - com.tencent.mm.compatible.util.f.getLine());
      h(3, -1, "", this);
      AppMethodBeat.o(9481);
      return;
      label1032:
      this.uZZ.field_fullXml = paramString;
      continue;
      label1044:
      if (!localbl.field_content.startsWith("<msg>"))
      {
        paramq = new StringBuffer();
        paramq.append(localbl.field_content).append(paramString);
        this.uZZ.field_fullXml = paramq.toString();
      }
      if ((paramString.endsWith("</appmsg>")) || (this.uZZ.field_offset + paramArrayOfByte.length == this.uZZ.field_totalLen))
      {
        if (w.pF(localbl.field_talker))
        {
          paramq = localbl.field_content.split("\n", 2);
          Object localObject = paramq[0];
          localStringBuffer = new StringBuffer();
          localObject = localStringBuffer.append((String)localObject).append("\n<msg>");
          if (paramq.length > 1) {}
          for (paramq = paramq[1];; paramq = "")
          {
            ((StringBuffer)localObject).append(paramq).append(paramString).append("</msg>");
            this.uZZ.field_fullXml = localStringBuffer.toString();
            break;
          }
        }
        paramq = new StringBuffer();
        paramq.append("<msg>").append(this.uZZ.field_fullXml).append("</msg>");
        this.uZZ.field_fullXml = paramq.toString();
      }
    }
    paramString = this.uZZ;
    long l = paramString.field_offset;
    paramString.field_offset = (paramArrayOfByte.length + l);
    if (this.uZZ.field_offset == this.uZZ.field_totalLen) {
      this.uZZ.field_status = 199L;
    }
    if (this.hhI != null) {
      aq.f(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(9474);
          e.this.hhI.a((int)e.this.uZZ.field_offset, (int)e.this.uZZ.field_totalLen, e.this);
          AppMethodBeat.o(9474);
        }
      });
    }
    if (this.vae) {}
    for (boolean bool = true; !bool; bool = com.tencent.mm.plugin.s.a.bxS().a(this.uZZ, new String[0]))
    {
      ad.e("MicroMsg.NetSceneDownloadAppAttach", "onGYNetEnd update info ret:".concat(String.valueOf(paramInt1)));
      this.retCode = (-10000 - com.tencent.mm.compatible.util.f.getLine());
      h(3, -1, "", this);
      AppMethodBeat.o(9481);
      return;
    }
    if (this.uZZ.field_status == 199L)
    {
      com.tencent.mm.plugin.report.service.h.vKh.f(10420, new Object[] { Integer.valueOf(0), Integer.valueOf(2), Long.valueOf(this.startTime), Long.valueOf(bt.eGO()), Integer.valueOf(com.tencent.mm.ao.c.cu(aj.getContext())), Integer.valueOf(com.tencent.mm.i.a.MediaType_FILE), Long.valueOf(this.uZZ.field_totalLen - this.vac) });
      paramString = ((com.tencent.mm.plugin.messenger.foundation.a.k)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).cOI().rm(this.uZZ.field_msgInfoId);
      ((com.tencent.mm.plugin.messenger.foundation.a.k)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).cOI().a(new h.c(paramString.field_talker, "update", paramString));
      h(0, 0, "", this);
      AppMethodBeat.o(9481);
      return;
    }
    if (this.uZZ.field_status == 102L)
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
    return n.b.gVB;
  }
  
  public static abstract interface a
  {
    public abstract void dgf();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.record.b.e
 * JD-Core Version:    0.7.0.1
 */