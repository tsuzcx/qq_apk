package com.tencent.mm.pluginsdk.model.app;

import android.database.Cursor;
import android.os.HandlerThread;
import android.os.SystemClock;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.k.b;
import com.tencent.mm.al.g;
import com.tencent.mm.al.n;
import com.tencent.mm.al.q;
import com.tencent.mm.compatible.util.f.a;
import com.tencent.mm.g.c.du;
import com.tencent.mm.model.az;
import com.tencent.mm.model.bi;
import com.tencent.mm.model.w;
import com.tencent.mm.plugin.messenger.foundation.a.a.h;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.av;
import com.tencent.mm.sdk.platformtools.av.a;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.bl;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public final class ao$a
  implements g
{
  private static int cZH = 0;
  private HashMap<Long, String> BQE;
  Queue<Long> cZA;
  Queue<Long> cZB;
  Map<Long, f.a> cZC;
  private boolean cZD;
  private boolean cZE;
  int cZF;
  private long cZG;
  f.a cZJ;
  private av cZK;
  private boolean running;
  
  public ao$a()
  {
    AppMethodBeat.i(31101);
    this.BQE = new HashMap();
    this.cZA = new LinkedList();
    this.cZB = new LinkedList();
    this.cZC = new HashMap();
    this.cZD = false;
    this.cZE = false;
    this.running = false;
    this.cZF = 0;
    this.cZG = 0L;
    this.cZJ = new f.a();
    this.cZK = new av(az.afE().EUN.getLooper(), new av.a()
    {
      public final boolean onTimerExpired()
      {
        AppMethodBeat.i(31099);
        ao.a.i(ao.a.this);
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
    az.aeS().a(220, this);
    az.aeS().a(221, this);
    az.aeS().a(222, this);
    AppMethodBeat.o(31101);
  }
  
  public static void H(long paramLong, String paramString)
  {
    AppMethodBeat.i(31105);
    az.aeS().a(new ah(paramLong, paramString, null), 0);
    AppMethodBeat.o(31105);
  }
  
  private void Oy()
  {
    AppMethodBeat.i(31110);
    this.cZC.clear();
    this.cZA.clear();
    this.cZB.clear();
    this.cZE = false;
    this.cZD = false;
    this.running = false;
    ad.d("MicroMsg.SceneAppMsg", "Finish service use time(ms):" + this.cZJ.XK());
    AppMethodBeat.o(31110);
  }
  
  public static void a(long paramLong, String paramString, int paramInt, a parama)
  {
    AppMethodBeat.i(31107);
    az.aeS().a(new ah(paramLong, paramString, paramInt, parama), 0);
    AppMethodBeat.o(31107);
  }
  
  private boolean aDd()
  {
    AppMethodBeat.i(31108);
    for (;;)
    {
      try
      {
        localObject2 = ap.bxS().rawQuery("select *  , rowid  from appattach where status = 101", new String[0]);
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
        ad.printErrStackTrace("MicroMsg.SceneAppMsg", localIllegalStateException, "", new Object[0]);
        Object localObject1 = ap.bxS();
        Object localObject2 = " update appattach set status = 198 , lastModifyTime = " + bt.aGK() + " where status = 101";
        ((d)localObject1).db.execSQL("appattach", (String)localObject2);
        ((d)localObject1).doNotify();
        localObject1 = null;
        continue;
        long l = System.currentTimeMillis() / 1000L;
        localObject2 = bt.vJ(l);
        localObject1 = ((List)localObject1).iterator();
        if (!((Iterator)localObject1).hasNext()) {
          continue;
        }
        c localc = (c)((Iterator)localObject1).next();
        if (!this.cZC.containsKey(Long.valueOf(localc.systemRowid))) {
          continue;
        }
        ad.d("MicroMsg.SceneAppMsg", "summerbig File is Already running:" + localc.systemRowid);
        continue;
        ad.d("MicroMsg.SceneAppMsg", "summerbig Get file:" + localc.field_fileFullPath + " status:" + localc.field_status + " create:(" + bt.vJ(localc.field_createTime) + "," + bt.vJ(localc.field_createTime / 1000L) + ", last:" + bt.vJ(localc.field_lastModifyTime) + " now:" + bt.vJ(l) + " " + (l - localc.field_lastModifyTime));
        if (!localc.field_isUpload) {
          continue;
        }
        if ((l - localc.field_lastModifyTime <= 600L) || (localc.field_status != 101L)) {
          continue;
        }
        ad.e("MicroMsg.SceneAppMsg", "summerbig time out file: " + localc.field_fileFullPath + " last:" + bt.vJ(localc.field_lastModifyTime) + " now:" + (String)localObject2);
        m.rO(localc.systemRowid);
        continue;
        this.cZA.offer(Long.valueOf(localc.systemRowid));
        this.cZC.put(Long.valueOf(localc.systemRowid), null);
        continue;
        ad.d("MicroMsg.SceneAppMsg", "summerbig GetNeedRun procing:" + this.cZC.size() + " [recv:" + this.cZB.size() + ",send:" + this.cZA.size() + "]");
        if (this.cZB.size() + this.cZA.size() != 0) {
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
      ad.d("MicroMsg.AppAttachInfoStorage", "getUnfinishInfo resCount:".concat(String.valueOf(j)));
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
  
  public static void e(long paramLong, String paramString1, String paramString2)
  {
    AppMethodBeat.i(31106);
    az.aeS().a(new ah(paramLong, paramString1, paramString2), 0);
    AppMethodBeat.o(31106);
  }
  
  public static void rN(long paramLong)
  {
    AppMethodBeat.i(31104);
    az.aeS().a(new ah(paramLong, null, null), 0);
    AppMethodBeat.o(31104);
  }
  
  public final void G(long paramLong, String paramString)
  {
    AppMethodBeat.i(31103);
    this.BQE.put(Long.valueOf(paramLong), paramString);
    AppMethodBeat.o(31103);
  }
  
  protected final void finalize()
  {
    AppMethodBeat.i(31102);
    az.aeS().b(220, this);
    az.aeS().b(221, this);
    az.aeS().b(222, this);
    this.BQE.clear();
    super.finalize();
    AppMethodBeat.o(31102);
  }
  
  public final void onSceneEnd(final int paramInt1, final int paramInt2, String paramString, final n paramn)
  {
    AppMethodBeat.i(31109);
    ad.d("MicroMsg.SceneAppMsg", "summersafecdn onSceneEnd type:%d errType:%d errCode:%d", new Object[] { Integer.valueOf(paramn.getType()), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    az.afE().ax(new Runnable()
    {
      public final void run()
      {
        int i = 0;
        AppMethodBeat.i(31095);
        ao.a.access$008();
        long l1;
        long l2;
        if (paramn.getType() == 222)
        {
          ad.d("MicroMsg.SceneAppMsg", "onSceneEnd  SendAppMsg errtype:" + paramInt1 + " errCode:" + paramInt2);
          i = 0;
          l1 = -1L;
          long l3 = 0L;
          l2 = l3;
          if (l1 != -1L)
          {
            l2 = l3;
            if (ao.a.this.cZC.get(Long.valueOf(l1)) != null)
            {
              l2 = ((f.a)ao.a.this.cZC.get(Long.valueOf(l1))).XK();
              ao.a.this.cZC.remove(Long.valueOf(l1));
            }
          }
          ad.d("MicroMsg.SceneAppMsg", "onSceneEnd SceneType:" + paramn.getType() + " errtype:" + paramInt1 + " errCode:" + paramInt2 + " retCode:" + i + " rowid:" + l1 + " time:" + l2);
          if (paramInt1 != 0) {
            ao.a.d(ao.a.this);
          }
          ad.d("MicroMsg.SceneAppMsg", "onSceneEnd  inCnt:" + ao.a.cZH + " stop:" + ao.a.e(ao.a.this) + " running:" + ao.a.f(ao.a.this) + " recving:" + ao.a.g(ao.a.this) + " sending:" + ao.a.h(ao.a.this));
          if (ao.a.e(ao.a.this) <= 0) {
            break label661;
          }
          ao.a.i(ao.a.this);
        }
        for (;;)
        {
          ao.a.Oz();
          AppMethodBeat.o(31095);
          return;
          if (paramn.getType() == 221)
          {
            ao.a.a(ao.a.this);
            l1 = ((com.tencent.mm.plugin.record.b.e)paramn).vab;
            i = ((com.tencent.mm.plugin.record.b.e)paramn).retCode;
            break;
          }
          if (paramn.getType() == 220)
          {
            ao.a.b(ao.a.this);
            l2 = ((ak)paramn).vab;
            int j = ((ak)paramn).retCode;
            Object localObject1 = (ak)paramn;
            label461:
            Object localObject2;
            if (((ak)localObject1).uZZ == null)
            {
              localObject1 = null;
              localObject2 = (ak)paramn;
              if (((ak)localObject2).uZZ != null) {
                break label611;
              }
            }
            label611:
            for (l1 = 0L;; l1 = ((ak)localObject2).uZZ.field_msgInfoId)
            {
              localObject2 = (String)ao.a.c(ao.a.this).remove(Long.valueOf(l1));
              if (!bt.isNullOrNil(((ak)paramn).hhN)) {
                i = 1;
              }
              if ((i == 0) && (!bt.isNullOrNil((String)localObject1)))
              {
                c localc = new c();
                ap.bxS().get(l2, localc);
                if (localc.systemRowid == l2)
                {
                  m.a(localc.field_msgInfoId, (String)localObject1, null, true);
                  ad.d("MicroMsg.SceneAppMsg", "onSceneEnd, finish update app attach, start send app msg");
                  ao.a.H(localc.field_msgInfoId, (String)localObject2);
                }
              }
              i = j;
              l1 = l2;
              break;
              localObject1 = ((ak)localObject1).uZZ.field_mediaSvrId;
              break label461;
            }
          }
          ad.e("MicroMsg.SceneAppMsg", "onSceneEnd Error SceneType:" + paramn.getType());
          ao.a.Oz();
          AppMethodBeat.o(31095);
          return;
          label661:
          if ((!ao.a.h(ao.a.this)) && (!ao.a.g(ao.a.this))) {
            ao.a.j(ao.a.this);
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
    az.afE().ax(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(31097);
        long l = System.currentTimeMillis() - ao.a.k(ao.a.this);
        ad.d("MicroMsg.SceneAppMsg", "summerbig Try Run service runningFlag:" + ao.a.f(ao.a.this) + " timeWait:" + l + " sending:" + ao.a.h(ao.a.this) + " recving:" + ao.a.g(ao.a.this));
        if (ao.a.f(ao.a.this))
        {
          if (l < 180000L)
          {
            AppMethodBeat.o(31097);
            return;
          }
          ad.e("MicroMsg.SceneAppMsg", "summerbig ERR: Try Run service runningFlag:" + ao.a.f(ao.a.this) + " timeWait:" + l + ">=MAX_TIME_WAIT sending:" + ao.a.h(ao.a.this) + " recving:" + ao.a.g(ao.a.this));
        }
        ao.a.l(ao.a.this);
        ao.a.b(ao.a.this);
        ao.a.m(ao.a.this);
        ao.a.a(ao.a.this);
        ao.a.this.cZJ.fGp = SystemClock.elapsedRealtime();
        ao.a.n(ao.a.this).av(10L, 10L);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.model.app.ao.a
 * JD-Core Version:    0.7.0.1
 */