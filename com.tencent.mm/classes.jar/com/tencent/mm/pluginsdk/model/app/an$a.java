package com.tencent.mm.pluginsdk.model.app;

import android.database.Cursor;
import android.os.SystemClock;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ag.k.b;
import com.tencent.mm.ak.q;
import com.tencent.mm.ak.t;
import com.tencent.mm.compatible.util.f.a;
import com.tencent.mm.g.c.eo;
import com.tencent.mm.model.ab;
import com.tencent.mm.model.bg;
import com.tencent.mm.model.bp;
import com.tencent.mm.plugin.record.b.f;
import com.tencent.mm.pluginsdk.g.c.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.MTimerHandler;
import com.tencent.mm.sdk.platformtools.MTimerHandler.CallBack;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.storage.ISQLiteDatabase;
import com.tencent.mm.storage.ca;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public final class an$a
  implements com.tencent.mm.ak.i
{
  private static int jrr = 0;
  private HashMap<Long, String> JWW;
  Queue<Long> dAA;
  Queue<Long> dAB;
  Map<Long, f.a> dAC;
  private boolean dAD;
  private boolean dAE;
  int dAF;
  private long dAG;
  f.a dAI;
  private MTimerHandler dAJ;
  private boolean running;
  
  public an$a()
  {
    AppMethodBeat.i(31101);
    this.JWW = new HashMap();
    this.dAA = new LinkedList();
    this.dAB = new LinkedList();
    this.dAC = new HashMap();
    this.dAD = false;
    this.dAE = false;
    this.running = false;
    this.dAF = 0;
    this.dAG = 0L;
    this.dAI = new f.a();
    this.dAJ = new MTimerHandler(bg.aAk().getLooper(), new MTimerHandler.CallBack()
    {
      public final boolean onTimerExpired()
      {
        AppMethodBeat.i(31099);
        an.a.j(an.a.this);
        AppMethodBeat.o(31099);
        return false;
      }
      
      public final String toString()
      {
        AppMethodBeat.i(31100);
        String str = super.toString() + "|scenePusher";
        AppMethodBeat.o(31100);
        return str;
      }
    }, false);
    bg.azz().a(220, this);
    bg.azz().a(221, this);
    bg.azz().a(222, this);
    AppMethodBeat.o(31101);
  }
  
  public static void HR(long paramLong)
  {
    AppMethodBeat.i(31104);
    bg.azz().a(new ag(paramLong, null, null), 0);
    AppMethodBeat.o(31104);
  }
  
  public static void Q(long paramLong, String paramString)
  {
    AppMethodBeat.i(31105);
    bg.azz().a(new ag(paramLong, paramString, null), 0);
    AppMethodBeat.o(31105);
  }
  
  public static void a(long paramLong, String paramString, int paramInt, a parama)
  {
    AppMethodBeat.i(31107);
    bg.azz().a(new ag(paramLong, paramString, paramInt, parama), 0);
    AppMethodBeat.o(31107);
  }
  
  private void aax()
  {
    AppMethodBeat.i(31110);
    this.dAC.clear();
    this.dAA.clear();
    this.dAB.clear();
    this.dAE = false;
    this.dAD = false;
    this.running = false;
    Log.d("MicroMsg.SceneAppMsg", "Finish service use time(ms):" + this.dAI.apr());
    AppMethodBeat.o(31110);
  }
  
  private boolean bhF()
  {
    AppMethodBeat.i(31108);
    for (;;)
    {
      try
      {
        localObject2 = ao.cgO().rawQuery("select *  , rowid  from appattach where status = 101", new String[0]);
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
        Object localObject1 = ao.cgO();
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
        if (!this.dAC.containsKey(Long.valueOf(localc.systemRowid))) {
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
        m.HS(localc.systemRowid);
        continue;
        this.dAA.offer(Long.valueOf(localc.systemRowid));
        this.dAC.put(Long.valueOf(localc.systemRowid), null);
        continue;
        Log.d("MicroMsg.SceneAppMsg", "summerbig GetNeedRun procing:" + this.dAC.size() + " [recv:" + this.dAB.size() + ",send:" + this.dAA.size() + "]");
        if (this.dAB.size() + this.dAA.size() != 0) {
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
  
  public static void f(long paramLong, String paramString1, String paramString2)
  {
    AppMethodBeat.i(31106);
    bg.azz().a(new ag(paramLong, paramString1, paramString2), 0);
    AppMethodBeat.o(31106);
  }
  
  public final void P(long paramLong, String paramString)
  {
    AppMethodBeat.i(31103);
    this.JWW.put(Long.valueOf(paramLong), paramString);
    AppMethodBeat.o(31103);
  }
  
  protected final void finalize()
  {
    AppMethodBeat.i(31102);
    bg.azz().b(220, this);
    bg.azz().b(221, this);
    bg.azz().b(222, this);
    this.JWW.clear();
    super.finalize();
    AppMethodBeat.o(31102);
  }
  
  public final void onSceneEnd(final int paramInt1, final int paramInt2, String paramString, final q paramq)
  {
    AppMethodBeat.i(31109);
    Log.d("MicroMsg.SceneAppMsg", "summersafecdn onSceneEnd type:%d errType:%d errCode:%d", new Object[] { Integer.valueOf(paramq.getType()), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    bg.aAk().postToWorker(new Runnable()
    {
      public final void run()
      {
        int i = 0;
        AppMethodBeat.i(31095);
        an.a.aYz();
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
            if (an.a.this.dAC.get(Long.valueOf(l1)) != null)
            {
              l2 = ((f.a)an.a.this.dAC.get(Long.valueOf(l1))).apr();
              an.a.this.dAC.remove(Long.valueOf(l1));
            }
          }
          Log.d("MicroMsg.SceneAppMsg", "onSceneEnd SceneType:" + paramq.getType() + " errtype:" + paramInt1 + " errCode:" + paramInt2 + " retCode:" + i + " rowid:" + l1 + " time:" + l2);
          if (paramInt1 != 0) {
            an.a.e(an.a.this);
          }
          Log.d("MicroMsg.SceneAppMsg", "onSceneEnd  inCnt:" + an.a.jrr + " stop:" + an.a.f(an.a.this) + " running:" + an.a.g(an.a.this) + " recving:" + an.a.h(an.a.this) + " sending:" + an.a.i(an.a.this));
          if (an.a.f(an.a.this) <= 0) {
            break label650;
          }
          an.a.j(an.a.this);
        }
        for (;;)
        {
          an.a.bhI();
          AppMethodBeat.o(31095);
          return;
          if (paramq.getType() == 221)
          {
            an.a.b(an.a.this);
            l1 = ((f)paramq).BGw;
            i = ((f)paramq).retCode;
            break;
          }
          if (paramq.getType() == 220)
          {
            an.a.c(an.a.this);
            l1 = ((aj)paramq).BGw;
            int j = ((aj)paramq).retCode;
            Object localObject = (aj)paramq;
            if (((aj)localObject).BGu == null) {}
            for (localObject = null;; localObject = ((aj)localObject).BGu.field_mediaSvrId)
            {
              l2 = ((aj)paramq).gnc();
              String str = (String)an.a.d(an.a.this).remove(Long.valueOf(l2));
              if (!Util.isNullOrNil(((aj)paramq).iYT)) {
                i = 1;
              }
              if ((i == 0) && (!((aj)paramq).JWN) && (!Util.isNullOrNil((String)localObject)))
              {
                c localc = new c();
                ao.cgO().get(l1, localc);
                if (localc.systemRowid == l1)
                {
                  m.a(localc.field_msgInfoId, (String)localObject, null, true);
                  Log.d("MicroMsg.SceneAppMsg", "onSceneEnd, finish update app attach, start send app msg");
                  an.a.Q(localc.field_msgInfoId, str);
                }
              }
              i = j;
              break;
            }
          }
          Log.e("MicroMsg.SceneAppMsg", "onSceneEnd Error SceneType:" + paramq.getType());
          an.a.bhI();
          AppMethodBeat.o(31095);
          return;
          label650:
          if ((!an.a.i(an.a.this)) && (!an.a.h(an.a.this))) {
            an.a.k(an.a.this);
          }
        }
      }
      
      public final String toString()
      {
        AppMethodBeat.i(31096);
        String str = super.toString() + "|onSceneEnd";
        AppMethodBeat.o(31096);
        return str;
      }
    });
    AppMethodBeat.o(31109);
  }
  
  public final void run()
  {
    AppMethodBeat.i(31111);
    bg.aAk().postToWorker(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(31097);
        long l = System.currentTimeMillis() - an.a.l(an.a.this);
        Log.d("MicroMsg.SceneAppMsg", "summerbig Try Run service runningFlag:" + an.a.g(an.a.this) + " timeWait:" + l + " sending:" + an.a.i(an.a.this) + " recving:" + an.a.h(an.a.this));
        if (an.a.g(an.a.this))
        {
          if (l < 180000L)
          {
            AppMethodBeat.o(31097);
            return;
          }
          Log.e("MicroMsg.SceneAppMsg", "summerbig ERR: Try Run service runningFlag:" + an.a.g(an.a.this) + " timeWait:" + l + ">=MAX_TIME_WAIT sending:" + an.a.i(an.a.this) + " recving:" + an.a.h(an.a.this));
        }
        an.a.m(an.a.this);
        an.a.c(an.a.this);
        an.a.n(an.a.this);
        an.a.b(an.a.this);
        an.a.this.dAI.gLm = SystemClock.elapsedRealtime();
        an.a.o(an.a.this).startTimer(10L);
        AppMethodBeat.o(31097);
      }
      
      public final String toString()
      {
        AppMethodBeat.i(31098);
        String str = super.toString() + "|run";
        AppMethodBeat.o(31098);
        return str;
      }
    });
    AppMethodBeat.o(31111);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.model.app.an.a
 * JD-Core Version:    0.7.0.1
 */