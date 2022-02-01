package com.tencent.mm.pluginsdk.model.app;

import android.database.Cursor;
import android.os.SystemClock;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.c.b;
import com.tencent.mm.am.c.c;
import com.tencent.mm.am.p;
import com.tencent.mm.am.s;
import com.tencent.mm.am.z.a;
import com.tencent.mm.autogen.b.fi;
import com.tencent.mm.compatible.util.f.a;
import com.tencent.mm.message.a.b;
import com.tencent.mm.message.k.b;
import com.tencent.mm.model.bh;
import com.tencent.mm.model.br;
import com.tencent.mm.plugin.messenger.foundation.a.a.i;
import com.tencent.mm.plugin.record.model.g;
import com.tencent.mm.pluginsdk.h.c.a;
import com.tencent.mm.protocal.protobuf.exg;
import com.tencent.mm.protocal.protobuf.exh;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.MTimerHandler;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.storage.ISQLiteDatabase;
import com.tencent.mm.storage.au;
import com.tencent.mm.storage.cc;
import com.tencent.mm.ui.chatting.viewitems.o;
import com.tencent.mm.ui.chatting.viewitems.o.d;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public final class ar$a
  implements com.tencent.mm.am.h
{
  private static int pae = 0;
  private HashMap<Long, String> XTn;
  Queue<Long> hxE;
  Queue<Long> hxF;
  Map<Long, f.a> hxG;
  private boolean hxH;
  private boolean hxI;
  int hxJ;
  private long hxK;
  f.a hxM;
  private MTimerHandler hxN;
  private boolean running;
  
  public ar$a()
  {
    AppMethodBeat.i(31101);
    this.XTn = new HashMap();
    this.hxE = new LinkedList();
    this.hxF = new LinkedList();
    this.hxG = new HashMap();
    this.hxH = false;
    this.hxI = false;
    this.running = false;
    this.hxJ = 0;
    this.hxK = 0L;
    this.hxM = new f.a();
    this.hxN = new MTimerHandler(bh.baH().getLooper(), new ar.a.5(this), false);
    bh.aZW().a(220, this);
    bh.aZW().a(221, this);
    bh.aZW().a(222, this);
    AppMethodBeat.o(31101);
  }
  
  public static void a(long paramLong, String paramString, int paramInt, a parama)
  {
    AppMethodBeat.i(244947);
    bh.aZW().a(new ak(paramLong, paramString, paramInt, parama), 0);
    AppMethodBeat.o(244947);
  }
  
  private void a(final c paramc, final cc paramcc, final long paramLong, String paramString1, String paramString2)
  {
    AppMethodBeat.i(244961);
    if (paramc.field_totalLen > 26214400L)
    {
      paramString2 = k.b.Hf(Util.processXml(paramcc.field_content));
      bh.aZW().a(new com.tencent.mm.pluginsdk.h.c(paramString2, paramc.field_fileFullPath, paramcc.field_talker, new c.a()
      {
        public final void a(String paramAnonymousString1, String paramAnonymousString2, String paramAnonymousString3, String paramAnonymousString4, String paramAnonymousString5, String paramAnonymousString6, long paramAnonymousLong)
        {
          AppMethodBeat.i(244881);
          if (Util.isNullOrNil(paramAnonymousString4))
          {
            paramcc.setStatus(5);
            bh.bCz();
            com.tencent.mm.model.c.bzD().a(paramcc.field_msgId, paramcc);
            paramAnonymousString2 = new cc();
            paramAnonymousString2.setCreateTime(br.JN(paramcc.field_talker));
            paramAnonymousString2.BS(paramcc.field_talker);
            paramAnonymousString2.setContent(paramAnonymousString1);
            paramAnonymousString2.setType(10000);
            paramAnonymousString2.setStatus(6);
            paramAnonymousString2.pI(0);
            bh.bCz();
            com.tencent.mm.model.c.bzD().ba(paramAnonymousString2);
            ar.a.a(ar.a.this);
            AppMethodBeat.o(244881);
            return;
          }
          paramc.field_signature = paramAnonymousString4;
          paramc.field_fakeAeskey = paramAnonymousString5;
          paramc.field_fakeSignature = paramAnonymousString6;
          paramc.field_lastModifyTime = Util.nowMilliSecond();
          paramAnonymousString4 = paramcc.field_content;
          paramAnonymousString1 = paramAnonymousString4;
          if (au.bwE(paramcc.field_talker))
          {
            int i = br.JG(paramcc.field_content);
            paramAnonymousString1 = paramAnonymousString4;
            if (i != -1) {
              paramAnonymousString1 = (paramcc.field_content + " ").substring(i + 2).trim();
            }
          }
          paramAnonymousString1 = k.b.Hf(Util.processXml(paramAnonymousString1));
          if (paramAnonymousString1 != null)
          {
            paramAnonymousString1.filemd5 = paramAnonymousString2;
            paramAnonymousString1.aesKey = paramAnonymousString3;
            paramAnonymousString1.nRd = ((int)paramAnonymousLong);
            bh.bCz();
            paramAnonymousString2 = com.tencent.mm.model.c.bzD().sl(paramc.field_msgInfoId);
            paramAnonymousString2.setContent(k.b.a(paramAnonymousString1, null, null));
            bh.bCz();
            com.tencent.mm.model.c.bzD().a(paramAnonymousString2.field_msgId, paramAnonymousString2);
          }
          as.cWJ().a(paramc, new String[0]);
          paramAnonymousString1 = new an(paramLong, null, this.rma);
          bh.aZW().a(paramAnonymousString1, 0);
          AppMethodBeat.o(244881);
        }
      }), 0);
      AppMethodBeat.o(244961);
      return;
    }
    paramc = new an(paramLong, paramString2, paramString1);
    bh.aZW().a(paramc, 0);
    AppMethodBeat.o(244961);
  }
  
  private void aHh()
  {
    AppMethodBeat.i(31110);
    this.hxG.clear();
    this.hxE.clear();
    this.hxF.clear();
    this.hxI = false;
    this.hxH = false;
    this.running = false;
    Log.d("MicroMsg.SceneAppMsg", "Finish service use time(ms):" + this.hxM.aPY());
    AppMethodBeat.o(31110);
  }
  
  public static void ap(long paramLong, String paramString)
  {
    AppMethodBeat.i(31105);
    bh.aZW().a(new ak(paramLong, paramString, null), 0);
    AppMethodBeat.o(31105);
  }
  
  private boolean bOI()
  {
    AppMethodBeat.i(31108);
    for (;;)
    {
      try
      {
        localObject2 = as.cWJ().rawQuery("select *  , rowid  from appattach where status = 101", new String[0]);
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
        Object localObject1 = as.cWJ();
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
        if (!this.hxG.containsKey(Long.valueOf(localc.systemRowid))) {
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
        n.tn(localc.systemRowid);
        continue;
        this.hxE.offer(Long.valueOf(localc.systemRowid));
        this.hxG.put(Long.valueOf(localc.systemRowid), null);
        continue;
        Log.d("MicroMsg.SceneAppMsg", "summerbig GetNeedRun procing:" + this.hxG.size() + " [recv:" + this.hxF.size() + ",send:" + this.hxE.size() + "]");
        if (this.hxF.size() + this.hxE.size() != 0) {
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
  
  public static void j(long paramLong, String paramString1, String paramString2)
  {
    AppMethodBeat.i(244943);
    bh.aZW().a(new ak(paramLong, paramString1, paramString2), 0);
    AppMethodBeat.o(244943);
  }
  
  public static void tm(long paramLong)
  {
    AppMethodBeat.i(31104);
    bh.aZW().a(new ak(paramLong, null, null), 0);
    AppMethodBeat.o(31104);
  }
  
  public final void ao(long paramLong, String paramString)
  {
    AppMethodBeat.i(31103);
    this.XTn.put(Long.valueOf(paramLong), paramString);
    AppMethodBeat.o(31103);
  }
  
  protected final void finalize()
  {
    AppMethodBeat.i(31102);
    bh.aZW().b(220, this);
    bh.aZW().b(221, this);
    bh.aZW().b(222, this);
    this.XTn.clear();
    super.finalize();
    AppMethodBeat.o(31102);
  }
  
  public final void onSceneEnd(final int paramInt1, final int paramInt2, String paramString, final p paramp)
  {
    AppMethodBeat.i(31109);
    Log.d("MicroMsg.SceneAppMsg", "summersafecdn onSceneEnd type:%d errType:%d errCode:%d", new Object[] { Integer.valueOf(paramp.getType()), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    bh.baH().postToWorker(new Runnable()
    {
      public final void run()
      {
        int i = 0;
        AppMethodBeat.i(31097);
        ar.a.gmF();
        long l1;
        long l2;
        if (paramp.getType() == 222)
        {
          Log.d("MicroMsg.SceneAppMsg", "onSceneEnd  SendAppMsg errtype:" + paramInt1 + " errCode:" + paramInt2);
          i = 0;
          l1 = -1L;
          long l3 = 0L;
          l2 = l3;
          if (l1 != -1L)
          {
            l2 = l3;
            if (ar.a.this.hxG.get(Long.valueOf(l1)) != null)
            {
              l2 = ((f.a)ar.a.this.hxG.get(Long.valueOf(l1))).aPY();
              ar.a.this.hxG.remove(Long.valueOf(l1));
            }
          }
          Log.d("MicroMsg.SceneAppMsg", "onSceneEnd SceneType:" + paramp.getType() + " errtype:" + paramInt1 + " errCode:" + paramInt2 + " retCode:" + i + " rowid:" + l1 + " time:" + l2);
          if (paramInt1 != 0) {
            ar.a.e(ar.a.this);
          }
          Log.d("MicroMsg.SceneAppMsg", "onSceneEnd  inCnt:" + ar.a.pae + " stop:" + ar.a.f(ar.a.this) + " running:" + ar.a.g(ar.a.this) + " recving:" + ar.a.h(ar.a.this) + " sending:" + ar.a.i(ar.a.this));
          if (ar.a.f(ar.a.this) <= 0) {
            break label650;
          }
          ar.a.j(ar.a.this);
        }
        for (;;)
        {
          ar.a.iIG();
          AppMethodBeat.o(31097);
          return;
          if (paramp.getType() == 221)
          {
            ar.a.b(ar.a.this);
            l1 = ((g)paramp).NAf;
            i = ((g)paramp).retCode;
            break;
          }
          if (paramp.getType() == 220)
          {
            ar.a.c(ar.a.this);
            l1 = ((an)paramp).NAf;
            int j = ((an)paramp).retCode;
            Object localObject = (an)paramp;
            if (((an)localObject).NAc == null) {}
            for (localObject = null;; localObject = ((an)localObject).NAc.field_mediaSvrId)
            {
              l2 = ((an)paramp).iIF();
              String str = (String)ar.a.d(ar.a.this).remove(Long.valueOf(l2));
              if (!Util.isNullOrNil(((an)paramp).oHX)) {
                i = 1;
              }
              if ((i == 0) && (!((an)paramp).XTe) && (!Util.isNullOrNil((String)localObject)))
              {
                c localc = new c();
                as.cWJ().get(l1, localc);
                if (localc.systemRowid == l1)
                {
                  n.a(localc.field_msgInfoId, (String)localObject, null, true);
                  Log.d("MicroMsg.SceneAppMsg", "onSceneEnd, finish update app attach, start send app msg");
                  ar.a.ap(localc.field_msgInfoId, str);
                }
              }
              i = j;
              break;
            }
          }
          Log.e("MicroMsg.SceneAppMsg", "onSceneEnd Error SceneType:" + paramp.getType());
          ar.a.iIG();
          AppMethodBeat.o(31097);
          return;
          label650:
          if ((!ar.a.i(ar.a.this)) && (!ar.a.h(ar.a.this))) {
            ar.a.k(ar.a.this);
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
    bh.baH().postToWorker(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(244882);
        long l = System.currentTimeMillis() - ar.a.l(ar.a.this);
        Log.d("MicroMsg.SceneAppMsg", "summerbig Try Run service runningFlag:" + ar.a.g(ar.a.this) + " timeWait:" + l + " sending:" + ar.a.i(ar.a.this) + " recving:" + ar.a.h(ar.a.this));
        if (ar.a.g(ar.a.this))
        {
          if (l < 180000L)
          {
            AppMethodBeat.o(244882);
            return;
          }
          Log.e("MicroMsg.SceneAppMsg", "summerbig ERR: Try Run service runningFlag:" + ar.a.g(ar.a.this) + " timeWait:" + l + ">=MAX_TIME_WAIT sending:" + ar.a.i(ar.a.this) + " recving:" + ar.a.h(ar.a.this));
        }
        ar.a.m(ar.a.this);
        ar.a.c(ar.a.this);
        ar.a.n(ar.a.this);
        ar.a.b(ar.a.this);
        ar.a.this.hxM.lYS = SystemClock.elapsedRealtime();
        ar.a.o(ar.a.this).startTimer(10L);
        AppMethodBeat.o(244882);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.model.app.ar.a
 * JD-Core Version:    0.7.0.1
 */