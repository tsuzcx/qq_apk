package com.tencent.mm.pluginsdk.model.app;

import android.database.Cursor;
import android.os.SystemClock;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.aj.a.b;
import com.tencent.mm.aj.k.b;
import com.tencent.mm.an.aa.a;
import com.tencent.mm.an.d.b;
import com.tencent.mm.an.d.c;
import com.tencent.mm.an.q;
import com.tencent.mm.an.t;
import com.tencent.mm.compatible.util.f.a;
import com.tencent.mm.f.c.et;
import com.tencent.mm.kernel.h;
import com.tencent.mm.model.ab;
import com.tencent.mm.model.bh;
import com.tencent.mm.model.bq;
import com.tencent.mm.plugin.messenger.foundation.a.n;
import com.tencent.mm.plugin.record.b.f;
import com.tencent.mm.pluginsdk.h.c.a;
import com.tencent.mm.protocal.protobuf.edp;
import com.tencent.mm.protocal.protobuf.edq;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.MTimerHandler;
import com.tencent.mm.sdk.platformtools.MTimerHandler.CallBack;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.storage.ISQLiteDatabase;
import com.tencent.mm.storage.ca;
import com.tencent.mm.ui.chatting.viewitems.o;
import com.tencent.mm.ui.chatting.viewitems.o.d;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public final class an$a
  implements com.tencent.mm.an.i
{
  private static int mgU = 0;
  private HashMap<Long, String> QXp;
  Queue<Long> ftp;
  Queue<Long> ftq;
  Map<Long, f.a> ftr;
  private boolean fts;
  private boolean ftt;
  int ftu;
  private long ftv;
  f.a ftx;
  private MTimerHandler fty;
  private boolean running;
  
  public an$a()
  {
    AppMethodBeat.i(31101);
    this.QXp = new HashMap();
    this.ftp = new LinkedList();
    this.ftq = new LinkedList();
    this.ftr = new HashMap();
    this.fts = false;
    this.ftt = false;
    this.running = false;
    this.ftu = 0;
    this.ftv = 0L;
    this.ftx = new f.a();
    this.fty = new MTimerHandler(bh.aHJ().getLooper(), new MTimerHandler.CallBack()
    {
      public final boolean onTimerExpired()
      {
        AppMethodBeat.i(265607);
        an.a.j(an.a.this);
        AppMethodBeat.o(265607);
        return false;
      }
      
      public final String toString()
      {
        AppMethodBeat.i(265608);
        String str = super.toString() + "|scenePusher";
        AppMethodBeat.o(265608);
        return str;
      }
    }, false);
    bh.aGY().a(220, this);
    bh.aGY().a(221, this);
    bh.aGY().a(222, this);
    AppMethodBeat.o(31101);
  }
  
  public static void Pm(long paramLong)
  {
    AppMethodBeat.i(31104);
    bh.aGY().a(new ag(paramLong, null, null), 0);
    AppMethodBeat.o(31104);
  }
  
  public static void a(long paramLong, String paramString, int paramInt, a parama)
  {
    AppMethodBeat.i(287054);
    bh.aGY().a(new ag(paramLong, paramString, paramInt, parama), 0);
    AppMethodBeat.o(287054);
  }
  
  private void a(final c paramc, final ca paramca, final long paramLong, String paramString1, String paramString2)
  {
    AppMethodBeat.i(287056);
    if (paramc.field_totalLen > 26214400L)
    {
      paramString2 = k.b.OQ(Util.processXml(paramca.field_content));
      bh.aGY().a(new com.tencent.mm.pluginsdk.h.c(paramString2, paramc.field_fileFullPath, paramca.field_talker, new c.a()
      {
        public final void a(String paramAnonymousString1, String paramAnonymousString2, String paramAnonymousString3, String paramAnonymousString4, String paramAnonymousString5, String paramAnonymousString6, long paramAnonymousLong)
        {
          AppMethodBeat.i(278892);
          if (Util.isNullOrNil(paramAnonymousString4))
          {
            paramca.setStatus(5);
            bh.beI();
            com.tencent.mm.model.c.bbO().a(paramca.field_msgId, paramca);
            paramAnonymousString2 = new ca();
            paramAnonymousString2.setCreateTime(bq.RP(paramca.field_talker));
            paramAnonymousString2.Jm(paramca.field_talker);
            paramAnonymousString2.setContent(paramAnonymousString1);
            paramAnonymousString2.setType(10000);
            paramAnonymousString2.setStatus(6);
            paramAnonymousString2.pJ(0);
            bh.beI();
            com.tencent.mm.model.c.bbO().aM(paramAnonymousString2);
            an.a.a(an.a.this);
            AppMethodBeat.o(278892);
            return;
          }
          paramc.field_signature = paramAnonymousString4;
          paramc.field_fakeAeskey = paramAnonymousString5;
          paramc.field_fakeSignature = paramAnonymousString6;
          paramc.field_lastModifyTime = Util.nowMilliSecond();
          paramAnonymousString4 = paramca.field_content;
          paramAnonymousString1 = paramAnonymousString4;
          if (ab.Lj(paramca.field_talker))
          {
            int i = bq.RI(paramca.field_content);
            paramAnonymousString1 = paramAnonymousString4;
            if (i != -1) {
              paramAnonymousString1 = (paramca.field_content + " ").substring(i + 2).trim();
            }
          }
          paramAnonymousString1 = k.b.OQ(Util.processXml(paramAnonymousString1));
          if (paramAnonymousString1 != null)
          {
            paramAnonymousString1.filemd5 = paramAnonymousString2;
            paramAnonymousString1.aesKey = paramAnonymousString3;
            paramAnonymousString1.llX = ((int)paramAnonymousLong);
            bh.beI();
            paramAnonymousString2 = com.tencent.mm.model.c.bbO().Oq(paramc.field_msgInfoId);
            paramAnonymousString2.setContent(k.b.a(paramAnonymousString1, null, null));
            bh.beI();
            com.tencent.mm.model.c.bbO().a(paramAnonymousString2.field_msgId, paramAnonymousString2);
          }
          ao.ctZ().a(paramc, new String[0]);
          paramAnonymousString1 = new aj(paramLong, null, this.oiy);
          bh.aGY().a(paramAnonymousString1, 0);
          AppMethodBeat.o(278892);
        }
      }), 0);
      AppMethodBeat.o(287056);
      return;
    }
    paramc = new aj(paramLong, paramString2, paramString1);
    bh.aGY().a(paramc, 0);
    AppMethodBeat.o(287056);
  }
  
  public static void ac(long paramLong, String paramString)
  {
    AppMethodBeat.i(31105);
    bh.aGY().a(new ag(paramLong, paramString, null), 0);
    AppMethodBeat.o(31105);
  }
  
  private void afk()
  {
    AppMethodBeat.i(31110);
    this.ftr.clear();
    this.ftp.clear();
    this.ftq.clear();
    this.ftt = false;
    this.fts = false;
    this.running = false;
    Log.d("MicroMsg.SceneAppMsg", "Finish service use time(ms):" + this.ftx.avE());
    AppMethodBeat.o(31110);
  }
  
  private boolean brc()
  {
    AppMethodBeat.i(31108);
    for (;;)
    {
      try
      {
        localObject2 = ao.ctZ().rawQuery("select *  , rowid  from appattach where status = 101", new String[0]);
        if (localObject2 != null) {
          continue;
        }
        localArrayList = null;
      }
      catch (IllegalStateException localIllegalStateException)
      {
        ArrayList localArrayList;
        int j;
        int i;
        Log.printErrStackTrace("MicroMsg.SceneAppMsg", localIllegalStateException, "", new Object[0]);
        Object localObject1 = ao.ctZ();
        Object localObject2 = " update appattach set status = 198 , lastModifyTime = " + Util.nowSecond() + " where status = 101";
        ((d)localObject1).db.execSQL("appattach", (String)localObject2);
        ((d)localObject1).doNotify();
        localObject1 = null;
        continue;
        long l = System.currentTimeMillis() / 1000L;
        localObject2 = Util.formatUnixTime(l);
        localObject1 = ((List)localObject1).iterator();
        if (!((Iterator)localObject1).hasNext()) {
          continue;
        }
        c localc = (c)((Iterator)localObject1).next();
        if (!this.ftr.containsKey(Long.valueOf(localc.systemRowid))) {
          continue;
        }
        Log.d("MicroMsg.SceneAppMsg", "summerbig File is Already running:" + localc.systemRowid);
        continue;
        Log.d("MicroMsg.SceneAppMsg", "summerbig Get file:" + localc.field_fileFullPath + " status:" + localc.field_status + " create:(" + Util.formatUnixTime(localc.field_createTime) + "," + Util.formatUnixTime(localc.field_createTime / 1000L) + ", last:" + Util.formatUnixTime(localc.field_lastModifyTime) + " now:" + Util.formatUnixTime(l) + " " + (l - localc.field_lastModifyTime));
        if (!localc.field_isUpload) {
          continue;
        }
        if ((l - localc.field_lastModifyTime <= 600L) || (localc.field_status != 101L)) {
          continue;
        }
        Log.e("MicroMsg.SceneAppMsg", "summerbig time out file: " + localc.field_fileFullPath + " last:" + Util.formatUnixTime(localc.field_lastModifyTime) + " now:" + (String)localObject2);
        m.Pn(localc.systemRowid);
        continue;
        this.ftp.offer(Long.valueOf(localc.systemRowid));
        this.ftr.put(Long.valueOf(localc.systemRowid), null);
        continue;
        Log.d("MicroMsg.SceneAppMsg", "summerbig GetNeedRun procing:" + this.ftr.size() + " [recv:" + this.ftq.size() + ",send:" + this.ftp.size() + "]");
        if (this.ftq.size() + this.ftp.size() != 0) {
          continue;
        }
        AppMethodBeat.o(31108);
        return false;
        AppMethodBeat.o(31108);
      }
      if ((localArrayList != null) && (localArrayList.size() != 0)) {
        continue;
      }
      AppMethodBeat.o(31108);
      return false;
      j = ((Cursor)localObject2).getCount();
      Log.d("MicroMsg.AppAttachInfoStorage", "getUnfinishInfo resCount:".concat(String.valueOf(j)));
      if (j == 0)
      {
        ((Cursor)localObject2).close();
        localArrayList = null;
      }
      else
      {
        localArrayList = new ArrayList();
        i = 0;
        if (i < j)
        {
          ((Cursor)localObject2).moveToPosition(i);
          localc = new c();
          localc.convertFrom((Cursor)localObject2);
          localArrayList.add(localc);
          i += 1;
        }
        else
        {
          ((Cursor)localObject2).close();
        }
      }
    }
    return true;
  }
  
  public static void h(long paramLong, String paramString1, String paramString2)
  {
    AppMethodBeat.i(287053);
    bh.aGY().a(new ag(paramLong, paramString1, paramString2), 0);
    AppMethodBeat.o(287053);
  }
  
  public final void ab(long paramLong, String paramString)
  {
    AppMethodBeat.i(31103);
    this.QXp.put(Long.valueOf(paramLong), paramString);
    AppMethodBeat.o(31103);
  }
  
  protected final void finalize()
  {
    AppMethodBeat.i(31102);
    bh.aGY().b(220, this);
    bh.aGY().b(221, this);
    bh.aGY().b(222, this);
    this.QXp.clear();
    super.finalize();
    AppMethodBeat.o(31102);
  }
  
  public final void onSceneEnd(final int paramInt1, final int paramInt2, String paramString, final q paramq)
  {
    AppMethodBeat.i(31109);
    Log.d("MicroMsg.SceneAppMsg", "summersafecdn onSceneEnd type:%d errType:%d errCode:%d", new Object[] { Integer.valueOf(paramq.getType()), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    bh.aHJ().postToWorker(new Runnable()
    {
      public final void run()
      {
        int i = 0;
        AppMethodBeat.i(31097);
        an.a.fdC();
        long l1;
        long l2;
        if (paramq.getType() == 222)
        {
          Log.d("MicroMsg.SceneAppMsg", "onSceneEnd  SendAppMsg errtype:" + paramInt1 + " errCode:" + paramInt2);
          i = 0;
          l1 = -1L;
          long l3 = 0L;
          l2 = l3;
          if (l1 != -1L)
          {
            l2 = l3;
            if (an.a.this.ftr.get(Long.valueOf(l1)) != null)
            {
              l2 = ((f.a)an.a.this.ftr.get(Long.valueOf(l1))).avE();
              an.a.this.ftr.remove(Long.valueOf(l1));
            }
          }
          Log.d("MicroMsg.SceneAppMsg", "onSceneEnd SceneType:" + paramq.getType() + " errtype:" + paramInt1 + " errCode:" + paramInt2 + " retCode:" + i + " rowid:" + l1 + " time:" + l2);
          if (paramInt1 != 0) {
            an.a.e(an.a.this);
          }
          Log.d("MicroMsg.SceneAppMsg", "onSceneEnd  inCnt:" + an.a.Yx() + " stop:" + an.a.f(an.a.this) + " running:" + an.a.g(an.a.this) + " recving:" + an.a.h(an.a.this) + " sending:" + an.a.i(an.a.this));
          if (an.a.f(an.a.this) <= 0) {
            break label649;
          }
          an.a.j(an.a.this);
        }
        for (;;)
        {
          an.a.hhE();
          AppMethodBeat.o(31097);
          return;
          if (paramq.getType() == 221)
          {
            an.a.b(an.a.this);
            l1 = ((f)paramq).HCC;
            i = ((f)paramq).retCode;
            break;
          }
          if (paramq.getType() == 220)
          {
            an.a.c(an.a.this);
            l1 = ((aj)paramq).HCC;
            int j = ((aj)paramq).retCode;
            Object localObject = (aj)paramq;
            if (((aj)localObject).HCz == null) {}
            for (localObject = null;; localObject = ((aj)localObject).HCz.field_mediaSvrId)
            {
              l2 = ((aj)paramq).hhD();
              String str = (String)an.a.d(an.a.this).remove(Long.valueOf(l2));
              if (!Util.isNullOrNil(((aj)paramq).lPn)) {
                i = 1;
              }
              if ((i == 0) && (!((aj)paramq).QXg) && (!Util.isNullOrNil((String)localObject)))
              {
                c localc = new c();
                ao.ctZ().get(l1, localc);
                if (localc.systemRowid == l1)
                {
                  m.a(localc.field_msgInfoId, (String)localObject, null);
                  Log.d("MicroMsg.SceneAppMsg", "onSceneEnd, finish update app attach, start send app msg");
                  an.a.ac(localc.field_msgInfoId, str);
                }
              }
              i = j;
              break;
            }
          }
          Log.e("MicroMsg.SceneAppMsg", "onSceneEnd Error SceneType:" + paramq.getType());
          an.a.hhE();
          AppMethodBeat.o(31097);
          return;
          label649:
          if ((!an.a.i(an.a.this)) && (!an.a.h(an.a.this))) {
            an.a.k(an.a.this);
          }
        }
      }
      
      public final String toString()
      {
        AppMethodBeat.i(31098);
        String str = super.toString() + "|onSceneEnd";
        AppMethodBeat.o(31098);
        return str;
      }
    });
    AppMethodBeat.o(31109);
  }
  
  public final void run()
  {
    AppMethodBeat.i(31111);
    bh.aHJ().postToWorker(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(276666);
        long l = System.currentTimeMillis() - an.a.l(an.a.this);
        Log.d("MicroMsg.SceneAppMsg", "summerbig Try Run service runningFlag:" + an.a.g(an.a.this) + " timeWait:" + l + " sending:" + an.a.i(an.a.this) + " recving:" + an.a.h(an.a.this));
        if (an.a.g(an.a.this))
        {
          if (l < 180000L)
          {
            AppMethodBeat.o(276666);
            return;
          }
          Log.e("MicroMsg.SceneAppMsg", "summerbig ERR: Try Run service runningFlag:" + an.a.g(an.a.this) + " timeWait:" + l + ">=MAX_TIME_WAIT sending:" + an.a.i(an.a.this) + " recving:" + an.a.h(an.a.this));
        }
        an.a.m(an.a.this);
        an.a.c(an.a.this);
        an.a.n(an.a.this);
        an.a.b(an.a.this);
        an.a.this.ftx.jvB = SystemClock.elapsedRealtime();
        an.a.o(an.a.this).startTimer(10L);
        AppMethodBeat.o(276666);
      }
      
      public final String toString()
      {
        AppMethodBeat.i(31100);
        String str = super.toString() + "|run";
        AppMethodBeat.o(31100);
        return str;
      }
    });
    AppMethodBeat.o(31111);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.model.app.an.a
 * JD-Core Version:    0.7.0.1
 */