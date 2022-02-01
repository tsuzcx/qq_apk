package com.tencent.mm.plugin.record.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ag.k.b;
import com.tencent.mm.ak.d.a;
import com.tencent.mm.ak.d.b;
import com.tencent.mm.ak.d.c;
import com.tencent.mm.ak.j;
import com.tencent.mm.ak.q;
import com.tencent.mm.ak.q.b;
import com.tencent.mm.g.b.a.w;
import com.tencent.mm.g.b.a.y;
import com.tencent.mm.g.c.eo;
import com.tencent.mm.i.g.a;
import com.tencent.mm.model.ab;
import com.tencent.mm.model.bp;
import com.tencent.mm.network.m;
import com.tencent.mm.plugin.messenger.foundation.a.a.i.c;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.protocal.protobuf.aht;
import com.tencent.mm.protocal.protobuf.ahu;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ca;
import com.tencent.mm.vfs.o;
import java.io.ByteArrayOutputStream;

public final class f
  extends q
  implements m
{
  private boolean BGA;
  private boolean BGB;
  com.tencent.mm.pluginsdk.model.app.c BGu;
  public long BGw;
  private int BGx;
  String BGy;
  private boolean BGz;
  private com.tencent.mm.ak.i callback;
  ca dTX;
  j iYO;
  String iYT;
  private g.a iZc;
  private String mediaId;
  public long msgId;
  private long oNJ;
  public boolean qJf;
  public int retCode;
  private com.tencent.mm.ak.d rr;
  long startTime;
  private int type;
  
  public f(long paramLong1, long paramLong2, j paramj)
  {
    AppMethodBeat.i(9475);
    this.BGu = null;
    this.BGw = -1L;
    this.mediaId = "";
    this.msgId = 0L;
    this.dTX = null;
    this.iYT = "";
    this.startTime = 0L;
    this.BGx = -1;
    this.BGy = "";
    this.type = 0;
    this.retCode = 0;
    this.BGz = false;
    this.BGA = false;
    this.oNJ = 0L;
    this.qJf = false;
    this.BGB = false;
    this.iZc = new g.a()
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
          Log.i("MicroMsg.NetSceneDownloadAppAttach", "summerbig callback cdntra  ERR_CNDCOM_MEDIA_IS_DOWNLOADING clientid:%s", new Object[] { f.this.iYT });
          AppMethodBeat.o(9473);
          return 0;
        }
        if (paramAnonymousInt != 0)
        {
          a.HS(f.this.BGu.systemRowid);
          new y(com.tencent.mm.plugin.report.a.t(new Object[] { Integer.valueOf(paramAnonymousInt), Integer.valueOf(2), Long.valueOf(f.this.startTime), Long.valueOf(Util.nowMilliSecond()), Integer.valueOf(com.tencent.mm.an.c.cY(MMApplicationContext.getContext())), Integer.valueOf(com.tencent.mm.i.a.MediaType_FILE), Integer.valueOf(0), "" })).bfK();
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
        f.this.BGu = a.s(paramAnonymousString, f.this.msgId);
        if (f.this.BGu == null)
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
        if (f.this.BGu.field_status == 102L)
        {
          Log.i("MicroMsg.NetSceneDownloadAppAttach", "summerbig dancy attach download has paused, status:%d", new Object[] { Long.valueOf(f.this.BGu.field_status) });
          com.tencent.mm.an.f.baQ().Ob(f.this.iYT);
          MMHandlerThread.postToMainThread(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(9467);
              f.a(f.this, 3, paramAnonymousInt, "attach  has paused, status=" + f.this.BGu.field_status, f.this);
              AppMethodBeat.o(9467);
            }
          });
          AppMethodBeat.o(9473);
          return 0;
        }
        if (paramAnonymousc != null)
        {
          if (paramAnonymousc.field_finishedLength == f.this.BGu.field_totalLen)
          {
            Log.i("MicroMsg.NetSceneDownloadAppAttach", "summerbig callback cdntra ignore progress 100%");
            AppMethodBeat.o(9473);
            return 0;
          }
          if (f.this.BGu.field_offset > paramAnonymousc.field_finishedLength)
          {
            Log.e("MicroMsg.NetSceneDownloadAppAttach", "summerbig callback cdnEndProc error oldpos:%d newpos:%d", new Object[] { Long.valueOf(f.this.BGu.field_offset), Long.valueOf(paramAnonymousc.field_finishedLength) });
            a.HS(f.this.BGu.systemRowid);
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
          f.this.BGu.field_offset = paramAnonymousc.field_finishedLength;
          com.tencent.mm.plugin.r.a.cgO().a(f.this.BGu, new String[0]);
          if (f.this.iYO != null) {
            MMHandlerThread.postToMainThread(new Runnable()
            {
              public final void run()
              {
                AppMethodBeat.i(9469);
                f.this.iYO.a((int)f.this.BGu.field_offset, (int)f.this.BGu.field_totalLen, f.this);
                AppMethodBeat.o(9469);
              }
            });
          }
          Log.d("MicroMsg.NetSceneDownloadAppAttach", "summerbig callback cdntra progresscallback id:%s finish:%d total:%d", new Object[] { f.this.iYT, Long.valueOf(paramAnonymousc.field_finishedLength), Long.valueOf(paramAnonymousc.field_toltalLength) });
          AppMethodBeat.o(9473);
          return 0;
        }
        if (paramAnonymousd != null)
        {
          if (paramAnonymousd.field_retCode == 0) {
            break label1001;
          }
          a.HS(f.this.BGu.systemRowid);
          Log.e("MicroMsg.NetSceneDownloadAppAttach", "summerbig callback cdntra sceneResult.retCode :%d", new Object[] { Integer.valueOf(paramAnonymousd.field_retCode) });
          new y(com.tencent.mm.plugin.report.a.t(new Object[] { Integer.valueOf(paramAnonymousd.field_retCode), Integer.valueOf(2), Long.valueOf(f.this.startTime), Long.valueOf(Util.nowMilliSecond()), Integer.valueOf(com.tencent.mm.an.c.cY(MMApplicationContext.getContext())), Integer.valueOf(com.tencent.mm.i.a.MediaType_FILE), Long.valueOf(f.this.BGu.field_totalLen), paramAnonymousd.field_transInfo, "", "", "", "", "", "", "", paramAnonymousd.gqk })).bfK();
          if (paramAnonymousd.field_retCode != 0) {
            new w(com.tencent.mm.plugin.report.a.t(new Object[] { Integer.valueOf(paramAnonymousd.field_retCode), Integer.valueOf(2), Long.valueOf(f.this.startTime), Long.valueOf(Util.nowMilliSecond()), Integer.valueOf(com.tencent.mm.an.c.cY(MMApplicationContext.getContext())), Integer.valueOf(com.tencent.mm.i.a.MediaType_FILE), Long.valueOf(f.this.BGu.field_totalLen), paramAnonymousd.field_transInfo, "", "", "", "", "", "", "", paramAnonymousd.gqk })).bfK();
          }
          if (f.this.iYO != null) {
            MMHandlerThread.postToMainThread(new Runnable()
            {
              public final void run()
              {
                AppMethodBeat.i(9470);
                f.this.iYO.a((int)f.this.BGu.field_offset, (int)f.this.BGu.field_totalLen, f.this);
                AppMethodBeat.o(9470);
              }
            });
          }
          if (paramAnonymousd.field_retCode == 0) {
            break label1293;
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
          label1001:
          new o(f.this.BGy).am(new o(f.this.BGu.field_fileFullPath));
          f.this.BGu.field_status = 199L;
          f.this.BGu.field_offset = f.this.BGu.field_totalLen;
          com.tencent.mm.plugin.r.a.cgO().a(f.this.BGu, new String[0]);
          h.CyF.idkeyStat(198L, 45L, f.this.BGu.field_totalLen, false);
          h.CyF.idkeyStat(198L, 46L, 1L, false);
          paramAnonymousc = h.CyF;
          if (f.this.dTX == null)
          {
            paramAnonymousString = "";
            label1141:
            if (!ab.Eq(paramAnonymousString)) {
              break label1248;
            }
          }
          label1248:
          for (long l = 48L;; l = 47L)
          {
            paramAnonymousc.idkeyStat(198L, l, 1L, false);
            paramAnonymousString = ((l)com.tencent.mm.kernel.g.af(l.class)).eiy().Hb(f.this.BGu.field_msgInfoId);
            if (paramAnonymousString.field_status != 5) {
              break label1256;
            }
            paramAnonymousString.setStatus(3);
            ((l)com.tencent.mm.kernel.g.af(l.class)).eiy().a(paramAnonymousString.field_msgId, paramAnonymousString);
            break;
            paramAnonymousString = f.this.dTX.field_talker;
            break label1141;
          }
          label1256:
          ((l)com.tencent.mm.kernel.g.af(l.class)).eiy().a(new i.c(paramAnonymousString.field_talker, "update", paramAnonymousString));
          break;
          label1293:
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
    this.oNJ = paramLong2;
    this.msgId = paramLong1;
    this.BGu = com.tencent.mm.plugin.r.a.cgO().Mp(paramLong1);
    this.iYO = paramj;
    this.BGA = true;
    if (this.BGu == null)
    {
      Log.e("MicroMsg.NetSceneDownloadAppAttach", "big appMsg, info is null, msgid = , svrId".concat(String.valueOf(paramLong1)), new Object[] { Long.valueOf(paramLong2) });
      AppMethodBeat.o(9475);
      return;
    }
    paramj = new d.a();
    paramj.iLN = new aht();
    paramj.iLO = new ahu();
    paramj.uri = "/cgi-bin/micromsg-bin/downloadappattach";
    paramj.funcId = 221;
    paramj.iLP = 106;
    paramj.respCmdId = 1000000106;
    this.rr = paramj.aXF();
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
    this.BGu = null;
    this.BGw = -1L;
    this.mediaId = "";
    this.msgId = 0L;
    this.dTX = null;
    this.iYT = "";
    this.startTime = 0L;
    this.BGx = -1;
    this.BGy = "";
    this.type = 0;
    this.retCode = 0;
    this.BGz = false;
    this.BGA = false;
    this.oNJ = 0L;
    this.qJf = false;
    this.BGB = false;
    this.iZc = new g.a()
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
          Log.i("MicroMsg.NetSceneDownloadAppAttach", "summerbig callback cdntra  ERR_CNDCOM_MEDIA_IS_DOWNLOADING clientid:%s", new Object[] { f.this.iYT });
          AppMethodBeat.o(9473);
          return 0;
        }
        if (paramAnonymousInt != 0)
        {
          a.HS(f.this.BGu.systemRowid);
          new y(com.tencent.mm.plugin.report.a.t(new Object[] { Integer.valueOf(paramAnonymousInt), Integer.valueOf(2), Long.valueOf(f.this.startTime), Long.valueOf(Util.nowMilliSecond()), Integer.valueOf(com.tencent.mm.an.c.cY(MMApplicationContext.getContext())), Integer.valueOf(com.tencent.mm.i.a.MediaType_FILE), Integer.valueOf(0), "" })).bfK();
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
        f.this.BGu = a.s(paramAnonymousString, f.this.msgId);
        if (f.this.BGu == null)
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
        if (f.this.BGu.field_status == 102L)
        {
          Log.i("MicroMsg.NetSceneDownloadAppAttach", "summerbig dancy attach download has paused, status:%d", new Object[] { Long.valueOf(f.this.BGu.field_status) });
          com.tencent.mm.an.f.baQ().Ob(f.this.iYT);
          MMHandlerThread.postToMainThread(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(9467);
              f.a(f.this, 3, paramAnonymousInt, "attach  has paused, status=" + f.this.BGu.field_status, f.this);
              AppMethodBeat.o(9467);
            }
          });
          AppMethodBeat.o(9473);
          return 0;
        }
        if (paramAnonymousc != null)
        {
          if (paramAnonymousc.field_finishedLength == f.this.BGu.field_totalLen)
          {
            Log.i("MicroMsg.NetSceneDownloadAppAttach", "summerbig callback cdntra ignore progress 100%");
            AppMethodBeat.o(9473);
            return 0;
          }
          if (f.this.BGu.field_offset > paramAnonymousc.field_finishedLength)
          {
            Log.e("MicroMsg.NetSceneDownloadAppAttach", "summerbig callback cdnEndProc error oldpos:%d newpos:%d", new Object[] { Long.valueOf(f.this.BGu.field_offset), Long.valueOf(paramAnonymousc.field_finishedLength) });
            a.HS(f.this.BGu.systemRowid);
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
          f.this.BGu.field_offset = paramAnonymousc.field_finishedLength;
          com.tencent.mm.plugin.r.a.cgO().a(f.this.BGu, new String[0]);
          if (f.this.iYO != null) {
            MMHandlerThread.postToMainThread(new Runnable()
            {
              public final void run()
              {
                AppMethodBeat.i(9469);
                f.this.iYO.a((int)f.this.BGu.field_offset, (int)f.this.BGu.field_totalLen, f.this);
                AppMethodBeat.o(9469);
              }
            });
          }
          Log.d("MicroMsg.NetSceneDownloadAppAttach", "summerbig callback cdntra progresscallback id:%s finish:%d total:%d", new Object[] { f.this.iYT, Long.valueOf(paramAnonymousc.field_finishedLength), Long.valueOf(paramAnonymousc.field_toltalLength) });
          AppMethodBeat.o(9473);
          return 0;
        }
        if (paramAnonymousd != null)
        {
          if (paramAnonymousd.field_retCode == 0) {
            break label1001;
          }
          a.HS(f.this.BGu.systemRowid);
          Log.e("MicroMsg.NetSceneDownloadAppAttach", "summerbig callback cdntra sceneResult.retCode :%d", new Object[] { Integer.valueOf(paramAnonymousd.field_retCode) });
          new y(com.tencent.mm.plugin.report.a.t(new Object[] { Integer.valueOf(paramAnonymousd.field_retCode), Integer.valueOf(2), Long.valueOf(f.this.startTime), Long.valueOf(Util.nowMilliSecond()), Integer.valueOf(com.tencent.mm.an.c.cY(MMApplicationContext.getContext())), Integer.valueOf(com.tencent.mm.i.a.MediaType_FILE), Long.valueOf(f.this.BGu.field_totalLen), paramAnonymousd.field_transInfo, "", "", "", "", "", "", "", paramAnonymousd.gqk })).bfK();
          if (paramAnonymousd.field_retCode != 0) {
            new w(com.tencent.mm.plugin.report.a.t(new Object[] { Integer.valueOf(paramAnonymousd.field_retCode), Integer.valueOf(2), Long.valueOf(f.this.startTime), Long.valueOf(Util.nowMilliSecond()), Integer.valueOf(com.tencent.mm.an.c.cY(MMApplicationContext.getContext())), Integer.valueOf(com.tencent.mm.i.a.MediaType_FILE), Long.valueOf(f.this.BGu.field_totalLen), paramAnonymousd.field_transInfo, "", "", "", "", "", "", "", paramAnonymousd.gqk })).bfK();
          }
          if (f.this.iYO != null) {
            MMHandlerThread.postToMainThread(new Runnable()
            {
              public final void run()
              {
                AppMethodBeat.i(9470);
                f.this.iYO.a((int)f.this.BGu.field_offset, (int)f.this.BGu.field_totalLen, f.this);
                AppMethodBeat.o(9470);
              }
            });
          }
          if (paramAnonymousd.field_retCode == 0) {
            break label1293;
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
          label1001:
          new o(f.this.BGy).am(new o(f.this.BGu.field_fileFullPath));
          f.this.BGu.field_status = 199L;
          f.this.BGu.field_offset = f.this.BGu.field_totalLen;
          com.tencent.mm.plugin.r.a.cgO().a(f.this.BGu, new String[0]);
          h.CyF.idkeyStat(198L, 45L, f.this.BGu.field_totalLen, false);
          h.CyF.idkeyStat(198L, 46L, 1L, false);
          paramAnonymousc = h.CyF;
          if (f.this.dTX == null)
          {
            paramAnonymousString = "";
            label1141:
            if (!ab.Eq(paramAnonymousString)) {
              break label1248;
            }
          }
          label1248:
          for (long l = 48L;; l = 47L)
          {
            paramAnonymousc.idkeyStat(198L, l, 1L, false);
            paramAnonymousString = ((l)com.tencent.mm.kernel.g.af(l.class)).eiy().Hb(f.this.BGu.field_msgInfoId);
            if (paramAnonymousString.field_status != 5) {
              break label1256;
            }
            paramAnonymousString.setStatus(3);
            ((l)com.tencent.mm.kernel.g.af(l.class)).eiy().a(paramAnonymousString.field_msgId, paramAnonymousString);
            break;
            paramAnonymousString = f.this.dTX.field_talker;
            break label1141;
          }
          label1256:
          ((l)com.tencent.mm.kernel.g.af(l.class)).eiy().a(new i.c(paramAnonymousString.field_talker, "update", paramAnonymousString));
          break;
          label1293:
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
    this.BGu = paramc;
    this.BGz = true;
    this.mediaId = this.BGu.field_mediaId;
    this.iYO = null;
    this.type = 0;
    if (paramc == null)
    {
      Log.e("MicroMsg.NetSceneDownloadAppAttach", "summerbig <init>, info is null, mediaId = " + this.mediaId);
      AppMethodBeat.o(9476);
      return;
    }
    d.a locala = new d.a();
    locala.iLN = new aht();
    locala.iLO = new ahu();
    locala.uri = "/cgi-bin/micromsg-bin/downloadappattach";
    locala.funcId = 221;
    locala.iLP = 106;
    locala.respCmdId = 1000000106;
    this.rr = locala.aXF();
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
    this.BGu = null;
    this.BGw = -1L;
    this.mediaId = "";
    this.msgId = 0L;
    this.dTX = null;
    this.iYT = "";
    this.startTime = 0L;
    this.BGx = -1;
    this.BGy = "";
    this.type = 0;
    this.retCode = 0;
    this.BGz = false;
    this.BGA = false;
    this.oNJ = 0L;
    this.qJf = false;
    this.BGB = false;
    this.iZc = new g.a()
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
          Log.i("MicroMsg.NetSceneDownloadAppAttach", "summerbig callback cdntra  ERR_CNDCOM_MEDIA_IS_DOWNLOADING clientid:%s", new Object[] { f.this.iYT });
          AppMethodBeat.o(9473);
          return 0;
        }
        if (paramAnonymousInt != 0)
        {
          a.HS(f.this.BGu.systemRowid);
          new y(com.tencent.mm.plugin.report.a.t(new Object[] { Integer.valueOf(paramAnonymousInt), Integer.valueOf(2), Long.valueOf(f.this.startTime), Long.valueOf(Util.nowMilliSecond()), Integer.valueOf(com.tencent.mm.an.c.cY(MMApplicationContext.getContext())), Integer.valueOf(com.tencent.mm.i.a.MediaType_FILE), Integer.valueOf(0), "" })).bfK();
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
        f.this.BGu = a.s(paramAnonymousString, f.this.msgId);
        if (f.this.BGu == null)
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
        if (f.this.BGu.field_status == 102L)
        {
          Log.i("MicroMsg.NetSceneDownloadAppAttach", "summerbig dancy attach download has paused, status:%d", new Object[] { Long.valueOf(f.this.BGu.field_status) });
          com.tencent.mm.an.f.baQ().Ob(f.this.iYT);
          MMHandlerThread.postToMainThread(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(9467);
              f.a(f.this, 3, paramAnonymousInt, "attach  has paused, status=" + f.this.BGu.field_status, f.this);
              AppMethodBeat.o(9467);
            }
          });
          AppMethodBeat.o(9473);
          return 0;
        }
        if (paramAnonymousc != null)
        {
          if (paramAnonymousc.field_finishedLength == f.this.BGu.field_totalLen)
          {
            Log.i("MicroMsg.NetSceneDownloadAppAttach", "summerbig callback cdntra ignore progress 100%");
            AppMethodBeat.o(9473);
            return 0;
          }
          if (f.this.BGu.field_offset > paramAnonymousc.field_finishedLength)
          {
            Log.e("MicroMsg.NetSceneDownloadAppAttach", "summerbig callback cdnEndProc error oldpos:%d newpos:%d", new Object[] { Long.valueOf(f.this.BGu.field_offset), Long.valueOf(paramAnonymousc.field_finishedLength) });
            a.HS(f.this.BGu.systemRowid);
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
          f.this.BGu.field_offset = paramAnonymousc.field_finishedLength;
          com.tencent.mm.plugin.r.a.cgO().a(f.this.BGu, new String[0]);
          if (f.this.iYO != null) {
            MMHandlerThread.postToMainThread(new Runnable()
            {
              public final void run()
              {
                AppMethodBeat.i(9469);
                f.this.iYO.a((int)f.this.BGu.field_offset, (int)f.this.BGu.field_totalLen, f.this);
                AppMethodBeat.o(9469);
              }
            });
          }
          Log.d("MicroMsg.NetSceneDownloadAppAttach", "summerbig callback cdntra progresscallback id:%s finish:%d total:%d", new Object[] { f.this.iYT, Long.valueOf(paramAnonymousc.field_finishedLength), Long.valueOf(paramAnonymousc.field_toltalLength) });
          AppMethodBeat.o(9473);
          return 0;
        }
        if (paramAnonymousd != null)
        {
          if (paramAnonymousd.field_retCode == 0) {
            break label1001;
          }
          a.HS(f.this.BGu.systemRowid);
          Log.e("MicroMsg.NetSceneDownloadAppAttach", "summerbig callback cdntra sceneResult.retCode :%d", new Object[] { Integer.valueOf(paramAnonymousd.field_retCode) });
          new y(com.tencent.mm.plugin.report.a.t(new Object[] { Integer.valueOf(paramAnonymousd.field_retCode), Integer.valueOf(2), Long.valueOf(f.this.startTime), Long.valueOf(Util.nowMilliSecond()), Integer.valueOf(com.tencent.mm.an.c.cY(MMApplicationContext.getContext())), Integer.valueOf(com.tencent.mm.i.a.MediaType_FILE), Long.valueOf(f.this.BGu.field_totalLen), paramAnonymousd.field_transInfo, "", "", "", "", "", "", "", paramAnonymousd.gqk })).bfK();
          if (paramAnonymousd.field_retCode != 0) {
            new w(com.tencent.mm.plugin.report.a.t(new Object[] { Integer.valueOf(paramAnonymousd.field_retCode), Integer.valueOf(2), Long.valueOf(f.this.startTime), Long.valueOf(Util.nowMilliSecond()), Integer.valueOf(com.tencent.mm.an.c.cY(MMApplicationContext.getContext())), Integer.valueOf(com.tencent.mm.i.a.MediaType_FILE), Long.valueOf(f.this.BGu.field_totalLen), paramAnonymousd.field_transInfo, "", "", "", "", "", "", "", paramAnonymousd.gqk })).bfK();
          }
          if (f.this.iYO != null) {
            MMHandlerThread.postToMainThread(new Runnable()
            {
              public final void run()
              {
                AppMethodBeat.i(9470);
                f.this.iYO.a((int)f.this.BGu.field_offset, (int)f.this.BGu.field_totalLen, f.this);
                AppMethodBeat.o(9470);
              }
            });
          }
          if (paramAnonymousd.field_retCode == 0) {
            break label1293;
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
          label1001:
          new o(f.this.BGy).am(new o(f.this.BGu.field_fileFullPath));
          f.this.BGu.field_status = 199L;
          f.this.BGu.field_offset = f.this.BGu.field_totalLen;
          com.tencent.mm.plugin.r.a.cgO().a(f.this.BGu, new String[0]);
          h.CyF.idkeyStat(198L, 45L, f.this.BGu.field_totalLen, false);
          h.CyF.idkeyStat(198L, 46L, 1L, false);
          paramAnonymousc = h.CyF;
          if (f.this.dTX == null)
          {
            paramAnonymousString = "";
            label1141:
            if (!ab.Eq(paramAnonymousString)) {
              break label1248;
            }
          }
          label1248:
          for (long l = 48L;; l = 47L)
          {
            paramAnonymousc.idkeyStat(198L, l, 1L, false);
            paramAnonymousString = ((l)com.tencent.mm.kernel.g.af(l.class)).eiy().Hb(f.this.BGu.field_msgInfoId);
            if (paramAnonymousString.field_status != 5) {
              break label1256;
            }
            paramAnonymousString.setStatus(3);
            ((l)com.tencent.mm.kernel.g.af(l.class)).eiy().a(paramAnonymousString.field_msgId, paramAnonymousString);
            break;
            paramAnonymousString = f.this.dTX.field_talker;
            break label1141;
          }
          label1256:
          ((l)com.tencent.mm.kernel.g.af(l.class)).eiy().a(new i.c(paramAnonymousString.field_talker, "update", paramAnonymousString));
          break;
          label1293:
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
    this.iYO = paramj;
    this.type = 0;
    this.BGu = com.tencent.mm.plugin.r.a.cgO().bdx(paramString);
    if (this.BGu == null) {
      this.BGu = com.tencent.mm.plugin.r.a.cgO().Mp(paramLong);
    }
    if (this.BGu == null)
    {
      Log.e("MicroMsg.NetSceneDownloadAppAttach", "summerbig <init>, info is null, mediaId = ".concat(String.valueOf(paramString)));
      AppMethodBeat.o(9477);
      return;
    }
    paramString = new d.a();
    paramString.iLN = new aht();
    paramString.iLO = new ahu();
    paramString.uri = "/cgi-bin/micromsg-bin/downloadappattach";
    paramString.funcId = 221;
    paramString.iLP = 106;
    paramString.respCmdId = 1000000106;
    this.rr = paramString.aXF();
    Log.d("MicroMsg.NetSceneDownloadAppAttach", "summerbig NetSceneDownloadAppAttach , type[%d], info fullpath[%s], field_type[%d], signature[%s], stack[%s]", new Object[] { Integer.valueOf(0), this.BGu.field_fileFullPath, Long.valueOf(this.BGu.field_type), this.BGu.field_signature, Util.getStack() });
    AppMethodBeat.o(9477);
  }
  
  private void g(int paramInt1, int paramInt2, String paramString, q paramq)
  {
    AppMethodBeat.i(9482);
    if (this.callback != null)
    {
      this.callback.onSceneEnd(paramInt1, paramInt2, paramString, paramq);
      if (this.BGu != null)
      {
        long l = this.BGu.field_msgInfoId;
        paramString = ((l)com.tencent.mm.kernel.g.af(l.class)).eiy().Hb(l);
        if ((paramInt1 == 0) && (paramInt2 == 0))
        {
          ((com.tencent.mm.plugin.comm.a.b)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.comm.a.b.class)).a(this.qJf, String.valueOf(l), paramString.field_msgSvrId, true);
          AppMethodBeat.o(9482);
          return;
        }
        ((com.tencent.mm.plugin.comm.a.b)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.comm.a.b.class)).a(this.qJf, String.valueOf(l), paramString.field_msgSvrId, false);
      }
    }
    AppMethodBeat.o(9482);
  }
  
  public final void a(a parama)
  {
    AppMethodBeat.i(9479);
    if (!this.BGz)
    {
      com.tencent.mm.an.f.baQ().Oc(this.iYT);
      this.BGu = com.tencent.mm.plugin.r.a.cgO().Mp(this.msgId);
      if (this.BGu == null)
      {
        Log.i("MicroMsg.NetSceneDownloadAppAttach", "pause get by msgid  %是is null then get by mediaId %s", new Object[] { Long.valueOf(this.msgId), this.mediaId });
        this.BGu = com.tencent.mm.plugin.r.a.cgO().bdx(this.mediaId);
      }
    }
    Log.i("MicroMsg.NetSceneDownloadAppAttach", "summerbig pause listener[%s], info[%s], justSaveFile[%b], stack[%s]", new Object[] { parama, this.BGu, Boolean.valueOf(this.BGz), Util.getStack() });
    if (this.BGu == null)
    {
      AppMethodBeat.o(9479);
      return;
    }
    if ((this.BGu.field_status == 101L) && (parama != null)) {
      parama.eIn();
    }
    this.BGu.field_status = 102L;
    if (!this.BGz) {
      Log.i("MicroMsg.NetSceneDownloadAppAttach", "pause done %s", new Object[] { Boolean.valueOf(com.tencent.mm.plugin.r.a.cgO().a(this.BGu, new String[0])) });
    }
    AppMethodBeat.o(9479);
  }
  
  public final int doScene(com.tencent.mm.network.g paramg, com.tencent.mm.ak.i parami)
  {
    AppMethodBeat.i(9480);
    this.callback = parami;
    if (this.BGu == null)
    {
      Log.e("MicroMsg.NetSceneDownloadAppAttach", com.tencent.mm.compatible.util.f.apq() + " get info failed mediaId:" + this.mediaId);
      this.retCode = (-10000 - com.tencent.mm.compatible.util.f.getLine());
      AppMethodBeat.o(9480);
      return -1;
    }
    this.dTX = ((l)com.tencent.mm.kernel.g.af(l.class)).eiy().Hb(this.msgId);
    if ((this.dTX == null) || (this.dTX.field_msgId != this.msgId))
    {
      Log.e("MicroMsg.NetSceneDownloadAppAttach", com.tencent.mm.compatible.util.f.apq() + " get msginfo failed mediaId:%s  msgId:%d", new Object[] { this.mediaId, Long.valueOf(this.msgId) });
      this.retCode = (-10000 - com.tencent.mm.compatible.util.f.getLine());
      AppMethodBeat.o(9480);
      return -1;
    }
    if (this.startTime == 0L)
    {
      this.startTime = Util.nowMilliSecond();
      this.BGx = ((int)this.BGu.field_offset);
    }
    if (this.oNJ != 0L)
    {
      parami = (aht)this.rr.iLK.iLR;
      parami.UserName = com.tencent.mm.model.z.aTY();
      parami.BsF = ((int)this.BGu.field_totalLen);
      parami.BsG = ((int)this.BGu.field_offset);
      parami.BsH = 0;
      parami.oUv = 40;
      parami.Brn = this.oNJ;
      i = dispatch(paramg, this.rr, this);
      AppMethodBeat.o(9480);
      return i;
    }
    Object localObject = this.dTX.field_content;
    parami = (com.tencent.mm.ak.i)localObject;
    if (ab.Eq(this.dTX.field_talker))
    {
      i = bp.Kp(this.dTX.field_content);
      parami = (com.tencent.mm.ak.i)localObject;
      if (i != -1) {
        parami = (this.dTX.field_content + " ").substring(i + 2).trim();
      }
    }
    parami = k.b.HD(Util.processXml(parami));
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
      Log.i("MicroMsg.NetSceneDownloadAppAttach", "summerbig cdntra checkUseCdn msgid:%d total:%d fullpath:%s fileid:%s aeskey:%s ", new Object[] { Long.valueOf(this.msgId), Long.valueOf(this.BGu.field_totalLen), this.BGu.field_fileFullPath, parami.iwW, Util.secPrint(parami.aesKey) });
      if (((Util.isNullOrNil(parami.iwW)) && (Util.isNullOrNil(parami.iwN))) || (Util.isNullOrNil(parami.aesKey)))
      {
        Log.w("MicroMsg.NetSceneDownloadAppAttach", "summerbig cdntra checkUseCdn msgId:%d Not use CDN  cdnAttachUrl:%s aes:%s ", new Object[] { Long.valueOf(this.msgId), parami.iwW, Util.secPrint(parami.aesKey) });
        i = 0;
      }
      else
      {
        this.iYT = com.tencent.mm.an.c.a("downattach", this.BGu.field_createTime, this.dTX.field_talker, this.BGw);
        if (Util.isNullOrNil(this.iYT))
        {
          Log.w("MicroMsg.NetSceneDownloadAppAttach", "summerbig cdntra genClientId failed not use cdn rowid:%d", new Object[] { Long.valueOf(this.BGw) });
          i = 0;
        }
        else
        {
          com.tencent.mm.vfs.s.boN(com.tencent.mm.vfs.s.boZ(this.BGu.field_fileFullPath));
          this.BGy = (this.BGu.field_fileFullPath + "_tmp");
          localObject = new com.tencent.mm.i.g();
          ((com.tencent.mm.i.g)localObject).taskName = "task_NetSceneDownloadAppAttach";
          ((com.tencent.mm.i.g)localObject).field_mediaId = this.iYT;
          ((com.tencent.mm.i.g)localObject).field_fullpath = this.BGy;
          if ((parami.iwM != 0) || (parami.iwI > 26214400))
          {
            i = com.tencent.mm.i.a.gpO;
            label765:
            ((com.tencent.mm.i.g)localObject).field_fileType = i;
            ((com.tencent.mm.i.g)localObject).field_totalLen = ((int)this.BGu.field_totalLen);
            ((com.tencent.mm.i.g)localObject).field_aesKey = parami.aesKey;
            ((com.tencent.mm.i.g)localObject).field_fileId = parami.iwW;
            ((com.tencent.mm.i.g)localObject).field_svr_signature = this.BGu.field_signature;
            ((com.tencent.mm.i.g)localObject).field_fake_bigfile_signature_aeskey = this.BGu.field_fakeAeskey;
            ((com.tencent.mm.i.g)localObject).field_fake_bigfile_signature = this.BGu.field_fakeSignature;
            ((com.tencent.mm.i.g)localObject).field_onlycheckexist = false;
            ((com.tencent.mm.i.g)localObject).field_priority = com.tencent.mm.i.a.gpM;
            ((com.tencent.mm.i.g)localObject).gqy = this.iZc;
            if (!ab.Eq(this.dTX.field_talker)) {
              break label1095;
            }
            i = 1;
            label876:
            ((com.tencent.mm.i.g)localObject).field_chattype = i;
            if ((!com.tencent.mm.an.c.baL()) || ((parami.iwM == 0) && (parami.iwI <= 26214400))) {
              break label1100;
            }
          }
          label1095:
          label1100:
          for (boolean bool = true;; bool = false)
          {
            ((com.tencent.mm.i.g)localObject).field_use_multithread = bool;
            if (!Util.isNullOrNil(parami.iwN))
            {
              ((com.tencent.mm.i.g)localObject).field_fileType = 19;
              ((com.tencent.mm.i.g)localObject).field_authKey = parami.iwT;
              ((com.tencent.mm.i.g)localObject).gqB = parami.iwN;
              ((com.tencent.mm.i.g)localObject).field_fileId = "";
            }
            Log.i("MicroMsg.NetSceneDownloadAppAttach", "summerbig checkUseCdn addRecvTask taskInfo field_use_multithread[%s], field_fileType[%d], fileFullPath[%s], aeskey[%s], signature[%s], faeskey[%s], fsignature[%s], onlycheckexist[%s]", new Object[] { Boolean.valueOf(((com.tencent.mm.i.g)localObject).field_use_multithread), Integer.valueOf(((com.tencent.mm.i.g)localObject).field_fileType), ((com.tencent.mm.i.g)localObject).field_fullpath, Util.secPrint(((com.tencent.mm.i.g)localObject).field_aesKey), Util.secPrint(((com.tencent.mm.i.g)localObject).field_svr_signature), Util.secPrint(((com.tencent.mm.i.g)localObject).field_fake_bigfile_signature_aeskey), Util.secPrint(((com.tencent.mm.i.g)localObject).field_fake_bigfile_signature), Boolean.valueOf(((com.tencent.mm.i.g)localObject).field_onlycheckexist) });
            if (com.tencent.mm.an.f.baQ().b((com.tencent.mm.i.g)localObject, -1)) {
              break label1106;
            }
            Log.e("MicroMsg.NetSceneDownloadAppAttach", "summerbig cdntra addSendTask failed.");
            this.iYT = "";
            i = 0;
            break;
            i = com.tencent.mm.i.a.MediaType_FILE;
            break label765;
            i = 0;
            break label876;
          }
          label1106:
          if (this.BGu.field_isUseCdn != 1)
          {
            this.BGu.field_isUseCdn = 1;
            bool = com.tencent.mm.plugin.r.a.cgO().a(this.BGu, new String[0]);
            if (!bool)
            {
              Log.e("MicroMsg.NetSceneDownloadAppAttach", "summerbig checkUseCdn update info ret:".concat(String.valueOf(bool)));
              this.retCode = (-10000 - com.tencent.mm.compatible.util.f.getLine());
              g(3, -1, "", this);
              i = 0;
              continue;
            }
          }
          i = 1;
        }
      }
    }
    if (this.BGu.field_status == 102L)
    {
      this.BGu.field_status = 101L;
      if (!this.BGz) {
        com.tencent.mm.plugin.r.a.cgO().a(this.BGu, new String[0]);
      }
    }
    this.BGw = this.BGu.systemRowid;
    if ((Util.isNullOrNil(this.BGu.field_mediaSvrId)) && (this.oNJ == 0L))
    {
      Log.e("MicroMsg.NetSceneDownloadAppAttach", "checkArgs : mediaId is null");
      this.retCode = (-10000 - com.tencent.mm.compatible.util.f.getLine());
      AppMethodBeat.o(9480);
      return -1;
    }
    if ((this.BGu.field_totalLen <= 0L) || (this.BGu.field_totalLen > 26214400L))
    {
      Log.e("MicroMsg.NetSceneDownloadAppAttach", "checkArgs : totalLen is invalid, totalLen = " + this.BGu.field_totalLen);
      this.retCode = (-10000 - com.tencent.mm.compatible.util.f.getLine());
      AppMethodBeat.o(9480);
      return -1;
    }
    if ((Util.isNullOrNil(this.BGu.field_fileFullPath)) && (this.oNJ == 0L))
    {
      Log.e("MicroMsg.NetSceneDownloadAppAttach", "checkArgs : fileFullPath is null");
      this.retCode = (-10000 - com.tencent.mm.compatible.util.f.getLine());
      AppMethodBeat.o(9480);
      return -1;
    }
    int j = (int)com.tencent.mm.vfs.s.boW(this.BGu.field_fileFullPath);
    int i = j;
    if (this.BGB)
    {
      i = j - 6;
      if (i <= 0) {
        break label1523;
      }
    }
    while (i != this.BGu.field_offset)
    {
      Log.e("MicroMsg.NetSceneDownloadAppAttach", "checkArgs : fileFullPath is invalid, fileLength = " + i + ", info.field_offset = " + this.BGu.field_offset);
      this.retCode = (-10000 - com.tencent.mm.compatible.util.f.getLine());
      AppMethodBeat.o(9480);
      return -1;
      label1523:
      i = 0;
    }
    Log.i("MicroMsg.NetSceneDownloadAppAttach", "downing attach by non cdn, appId: %s,  mediaId: %s, sdkVer: %d", new Object[] { this.BGu.field_appId, this.BGu.field_mediaSvrId, Long.valueOf(this.BGu.field_sdkVer) });
    parami = (aht)this.rr.iLK.iLR;
    parami.jfi = this.BGu.field_appId;
    parami.jfl = this.BGu.field_mediaSvrId;
    parami.KIy = ((int)this.BGu.field_sdkVer);
    parami.UserName = com.tencent.mm.model.z.aTY();
    parami.BsF = ((int)this.BGu.field_totalLen);
    parami.BsG = ((int)this.BGu.field_offset);
    parami.BsH = 0;
    if (this.oNJ != 0L) {
      parami.Brn = this.oNJ;
    }
    if (this.type != 0) {}
    for (parami.oUv = this.type;; parami.oUv = ((int)this.BGu.field_type))
    {
      i = dispatch(paramg, this.rr, this);
      AppMethodBeat.o(9480);
      return i;
    }
  }
  
  public final void eIm()
  {
    AppMethodBeat.i(9478);
    this.BGB = true;
    if (this.BGB)
    {
      String str = this.BGu.field_fileFullPath;
      byte[] arrayOfByte = "#!AMR\n".getBytes();
      com.tencent.mm.vfs.s.e(str, arrayOfByte, arrayOfByte.length);
    }
    AppMethodBeat.o(9478);
  }
  
  public final String getMediaId()
  {
    if (this.BGu == null) {
      return "";
    }
    return this.BGu.field_mediaSvrId;
  }
  
  public final int getType()
  {
    return 221;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, com.tencent.mm.network.s params, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(9481);
    Log.d("MicroMsg.NetSceneDownloadAppAttach", "onGYNetEnd : errType = " + paramInt2 + ", errCode = " + paramInt3);
    if ((paramInt2 == 3) && (paramInt3 == -1) && (!Util.isNullOrNil(this.iYT)))
    {
      Log.w("MicroMsg.NetSceneDownloadAppAttach", "cdntra using cdn trans,  wait cdn service callback! clientid:%s", new Object[] { this.iYT });
      AppMethodBeat.o(9481);
      return;
    }
    if ((paramInt2 != 0) || (paramInt3 != 0))
    {
      Log.e("MicroMsg.NetSceneDownloadAppAttach", "onGYNetEnd : errType = " + paramInt2 + ", errCode = " + paramInt3);
      this.retCode = (-10000 - com.tencent.mm.compatible.util.f.getLine());
      if (paramInt2 == 4) {
        h.CyF.a(10420, new Object[] { Integer.valueOf(paramInt3), Integer.valueOf(2), Long.valueOf(this.startTime), Long.valueOf(Util.nowMilliSecond()), Integer.valueOf(com.tencent.mm.an.c.cY(MMApplicationContext.getContext())), Integer.valueOf(com.tencent.mm.i.a.MediaType_FILE), Integer.valueOf(0) });
      }
      g(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(9481);
      return;
    }
    paramString = (ahu)((com.tencent.mm.ak.d)params).iLL.iLR;
    this.BGu.field_totalLen = paramString.BsF;
    if ((paramString.jfl != null) && (!paramString.jfl.equals(this.BGu.field_mediaSvrId)))
    {
      Log.e("MicroMsg.NetSceneDownloadAppAttach", "argument is not consistent");
      this.retCode = (-10000 - com.tencent.mm.compatible.util.f.getLine());
      g(3, -1, "", this);
      AppMethodBeat.o(9481);
      return;
    }
    if (paramString.BsG != this.BGu.field_offset)
    {
      Log.e("MicroMsg.NetSceneDownloadAppAttach", "startPos, totalLen is incorrect startpos:" + paramString.BsG);
      this.retCode = (-10000 - com.tencent.mm.compatible.util.f.getLine());
      g(3, -1, "", this);
      AppMethodBeat.o(9481);
      return;
    }
    if (paramString.BsH + this.BGu.field_offset > this.BGu.field_totalLen)
    {
      Log.e("MicroMsg.NetSceneDownloadAppAttach", "data buffer is incorrect datalen:" + paramString.BsH + " off:" + this.BGu.field_offset + " total?:" + this.BGu.field_totalLen);
      this.retCode = (-10000 - com.tencent.mm.compatible.util.f.getLine());
      g(3, -1, "", this);
      AppMethodBeat.o(9481);
      return;
    }
    paramArrayOfByte = com.tencent.mm.platformtools.z.a(paramString.BsI);
    if ((paramArrayOfByte == null) || (paramArrayOfByte.length == 0) || (paramArrayOfByte.length != paramString.BsH))
    {
      Log.e("MicroMsg.NetSceneDownloadAppAttach", "data buffer is incorrect");
      this.retCode = (-10000 - com.tencent.mm.compatible.util.f.getLine());
      g(3, -1, "", this);
      AppMethodBeat.o(9481);
      return;
    }
    if (a.s(this.mediaId, this.msgId) == null)
    {
      Log.e("MicroMsg.NetSceneDownloadAppAttach", "append to file failed, msg maybe revoked or deleted. msgId:%d", new Object[] { Long.valueOf(this.BGu.field_msgInfoId) });
      this.retCode = (-10000 - com.tencent.mm.compatible.util.f.getLine());
      g(3, -1, "", this);
      AppMethodBeat.o(9481);
      return;
    }
    params = new String(paramArrayOfByte);
    Log.d("MicroMsg.NetSceneDownloadAppAttach", "dancy download big appmsg : %s", new Object[] { Boolean.valueOf(this.BGA) });
    ca localca;
    StringBuffer localStringBuffer;
    if ((this.BGu.field_offset < this.BGu.field_totalLen) && (this.BGA))
    {
      localca = ((l)com.tencent.mm.kernel.g.af(l.class)).eiy().Hb(this.BGu.field_msgInfoId);
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
        break label1044;
      }
      if (!ab.Eq(localca.field_talker)) {
        break label1032;
      }
      if (!Util.isNullOrNil(localca.field_content))
      {
        params = localca.field_content.split("\n", 2)[0];
        localStringBuffer = new StringBuffer();
        this.BGu.field_fullXml = (params + "\n");
        params = new StringBuffer();
        params.append(this.BGu.field_fullXml).append(paramString);
        this.BGu.field_fullXml = params.toString();
      }
    }
    for (;;)
    {
      localca.setContent(this.BGu.field_fullXml);
      ((l)com.tencent.mm.kernel.g.af(l.class)).eiy().a(this.BGu.field_msgInfoId, localca);
      Log.d("MicroMsg.NetSceneDownloadAppAttach", "dancy download full xml succed! xml: [%s]", new Object[] { paramString });
      paramInt1 = com.tencent.mm.vfs.s.e(this.BGu.field_fileFullPath, paramArrayOfByte, paramArrayOfByte.length);
      if ((Util.isNullOrNil(this.BGu.field_fileFullPath)) || (paramInt1 == 0)) {
        break;
      }
      Log.e("MicroMsg.NetSceneDownloadAppAttach", "append to file failed:".concat(String.valueOf(paramInt1)));
      this.retCode = (-10000 - com.tencent.mm.compatible.util.f.getLine());
      g(3, -1, "", this);
      AppMethodBeat.o(9481);
      return;
      label1032:
      this.BGu.field_fullXml = paramString;
      continue;
      label1044:
      if (!localca.field_content.startsWith("<msg>"))
      {
        params = new StringBuffer();
        params.append(localca.field_content).append(paramString);
        this.BGu.field_fullXml = params.toString();
      }
      if ((paramString.endsWith("</appmsg>")) || (this.BGu.field_offset + paramArrayOfByte.length == this.BGu.field_totalLen))
      {
        if (ab.Eq(localca.field_talker))
        {
          params = localca.field_content.split("\n", 2);
          Object localObject = params[0];
          localStringBuffer = new StringBuffer();
          localObject = localStringBuffer.append((String)localObject).append("\n<msg>");
          if (params.length > 1) {}
          for (params = params[1];; params = "")
          {
            ((StringBuffer)localObject).append(params).append(paramString).append("</msg>");
            this.BGu.field_fullXml = localStringBuffer.toString();
            break;
          }
        }
        params = new StringBuffer();
        params.append("<msg>").append(this.BGu.field_fullXml).append("</msg>");
        this.BGu.field_fullXml = params.toString();
      }
    }
    paramString = this.BGu;
    long l = paramString.field_offset;
    paramString.field_offset = (paramArrayOfByte.length + l);
    if (this.BGu.field_offset == this.BGu.field_totalLen) {
      this.BGu.field_status = 199L;
    }
    if (this.iYO != null) {
      MMHandlerThread.postToMainThread(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(9474);
          f.this.iYO.a((int)f.this.BGu.field_offset, (int)f.this.BGu.field_totalLen, f.this);
          AppMethodBeat.o(9474);
        }
      });
    }
    if (this.BGz) {}
    for (boolean bool = true; !bool; bool = com.tencent.mm.plugin.r.a.cgO().a(this.BGu, new String[0]))
    {
      Log.e("MicroMsg.NetSceneDownloadAppAttach", "onGYNetEnd update info ret:".concat(String.valueOf(paramInt1)));
      this.retCode = (-10000 - com.tencent.mm.compatible.util.f.getLine());
      g(3, -1, "", this);
      AppMethodBeat.o(9481);
      return;
    }
    if (this.BGu.field_status == 199L)
    {
      h.CyF.a(10420, new Object[] { Integer.valueOf(0), Integer.valueOf(2), Long.valueOf(this.startTime), Long.valueOf(Util.nowMilliSecond()), Integer.valueOf(com.tencent.mm.an.c.cY(MMApplicationContext.getContext())), Integer.valueOf(com.tencent.mm.i.a.MediaType_FILE), Long.valueOf(this.BGu.field_totalLen - this.BGx) });
      paramString = ((l)com.tencent.mm.kernel.g.af(l.class)).eiy().Hb(this.BGu.field_msgInfoId);
      ((l)com.tencent.mm.kernel.g.af(l.class)).eiy().a(new i.c(paramString.field_talker, "update", paramString));
      g(0, 0, "", this);
      AppMethodBeat.o(9481);
      return;
    }
    if (this.BGu.field_status == 102L)
    {
      g(3, -1, "", this);
      this.retCode = -20102;
      AppMethodBeat.o(9481);
      return;
    }
    if (doScene(dispatcher(), this.callback) < 0)
    {
      Log.e("MicroMsg.NetSceneDownloadAppAttach", "onGYNetEnd : doScene fail");
      g(3, -1, "", this);
    }
    AppMethodBeat.o(9481);
  }
  
  public final int securityLimitCount()
  {
    return 400;
  }
  
  public final q.b securityVerificationChecked(com.tencent.mm.network.s params)
  {
    return q.b.iMq;
  }
  
  public static abstract interface a
  {
    public abstract void eIn();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.record.b.f
 * JD-Core Version:    0.7.0.1
 */