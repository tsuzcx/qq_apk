package com.tencent.mm.pluginsdk.model.app;

import android.database.Cursor;
import android.os.HandlerThread;
import android.os.SystemClock;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ah.k.b;
import com.tencent.mm.ak.g;
import com.tencent.mm.ak.n;
import com.tencent.mm.ak.q;
import com.tencent.mm.compatible.util.f.a;
import com.tencent.mm.g.c.dy;
import com.tencent.mm.model.az;
import com.tencent.mm.model.bi;
import com.tencent.mm.model.w;
import com.tencent.mm.plugin.messenger.foundation.a.a.h;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.au;
import com.tencent.mm.sdk.platformtools.au.a;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.storage.bo;
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
  private static int cXd = 0;
  private HashMap<Long, String> DiT;
  Queue<Long> cWW;
  Queue<Long> cWX;
  Map<Long, f.a> cWY;
  private boolean cWZ;
  private boolean cXa;
  int cXb;
  private long cXc;
  f.a cXf;
  private au cXg;
  private boolean running;
  
  public ao$a()
  {
    AppMethodBeat.i(31101);
    this.DiT = new HashMap();
    this.cWW = new LinkedList();
    this.cWX = new LinkedList();
    this.cWY = new HashMap();
    this.cWZ = false;
    this.cXa = false;
    this.running = false;
    this.cXb = 0;
    this.cXc = 0L;
    this.cXf = new f.a();
    this.cXg = new au(az.agU().GrZ.getLooper(), new au.a()
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
    az.agi().a(220, this);
    az.agi().a(221, this);
    az.agi().a(222, this);
    AppMethodBeat.o(31101);
  }
  
  public static void F(long paramLong, String paramString)
  {
    AppMethodBeat.i(31105);
    az.agi().a(new ah(paramLong, paramString, null), 0);
    AppMethodBeat.o(31105);
  }
  
  private void Ou()
  {
    AppMethodBeat.i(31110);
    this.cWY.clear();
    this.cWW.clear();
    this.cWX.clear();
    this.cXa = false;
    this.cWZ = false;
    this.running = false;
    ac.d("MicroMsg.SceneAppMsg", "Finish service use time(ms):" + this.cXf.YH());
    AppMethodBeat.o(31110);
  }
  
  public static void a(long paramLong, String paramString, int paramInt, a parama)
  {
    AppMethodBeat.i(31107);
    az.agi().a(new ah(paramLong, paramString, paramInt, parama), 0);
    AppMethodBeat.o(31107);
  }
  
  private boolean aJU()
  {
    AppMethodBeat.i(31108);
    for (;;)
    {
      try
      {
        localObject2 = ap.bEO().rawQuery("select *  , rowid  from appattach where status = 101", new String[0]);
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
        ac.printErrStackTrace("MicroMsg.SceneAppMsg", localIllegalStateException, "", new Object[0]);
        Object localObject1 = ap.bEO();
        Object localObject2 = " update appattach set status = 198 , lastModifyTime = " + bs.aNx() + " where status = 101";
        ((d)localObject1).db.execSQL("appattach", (String)localObject2);
        ((d)localObject1).doNotify();
        localObject1 = null;
        continue;
        long l = System.currentTimeMillis() / 1000L;
        localObject2 = bs.Am(l);
        localObject1 = ((List)localObject1).iterator();
        if (!((Iterator)localObject1).hasNext()) {
          continue;
        }
        c localc = (c)((Iterator)localObject1).next();
        if (!this.cWY.containsKey(Long.valueOf(localc.systemRowid))) {
          continue;
        }
        ac.d("MicroMsg.SceneAppMsg", "summerbig File is Already running:" + localc.systemRowid);
        continue;
        ac.d("MicroMsg.SceneAppMsg", "summerbig Get file:" + localc.field_fileFullPath + " status:" + localc.field_status + " create:(" + bs.Am(localc.field_createTime) + "," + bs.Am(localc.field_createTime / 1000L) + ", last:" + bs.Am(localc.field_lastModifyTime) + " now:" + bs.Am(l) + " " + (l - localc.field_lastModifyTime));
        if (!localc.field_isUpload) {
          continue;
        }
        if ((l - localc.field_lastModifyTime <= 600L) || (localc.field_status != 101L)) {
          continue;
        }
        ac.e("MicroMsg.SceneAppMsg", "summerbig time out file: " + localc.field_fileFullPath + " last:" + bs.Am(localc.field_lastModifyTime) + " now:" + (String)localObject2);
        m.wr(localc.systemRowid);
        continue;
        this.cWW.offer(Long.valueOf(localc.systemRowid));
        this.cWY.put(Long.valueOf(localc.systemRowid), null);
        continue;
        ac.d("MicroMsg.SceneAppMsg", "summerbig GetNeedRun procing:" + this.cWY.size() + " [recv:" + this.cWX.size() + ",send:" + this.cWW.size() + "]");
        if (this.cWX.size() + this.cWW.size() != 0) {
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
      ac.d("MicroMsg.AppAttachInfoStorage", "getUnfinishInfo resCount:".concat(String.valueOf(j)));
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
    az.agi().a(new ah(paramLong, paramString1, paramString2), 0);
    AppMethodBeat.o(31106);
  }
  
  public static void wq(long paramLong)
  {
    AppMethodBeat.i(31104);
    az.agi().a(new ah(paramLong, null, null), 0);
    AppMethodBeat.o(31104);
  }
  
  public final void E(long paramLong, String paramString)
  {
    AppMethodBeat.i(31103);
    this.DiT.put(Long.valueOf(paramLong), paramString);
    AppMethodBeat.o(31103);
  }
  
  protected final void finalize()
  {
    AppMethodBeat.i(31102);
    az.agi().b(220, this);
    az.agi().b(221, this);
    az.agi().b(222, this);
    this.DiT.clear();
    super.finalize();
    AppMethodBeat.o(31102);
  }
  
  public final void onSceneEnd(final int paramInt1, final int paramInt2, String paramString, final n paramn)
  {
    AppMethodBeat.i(31109);
    ac.d("MicroMsg.SceneAppMsg", "summersafecdn onSceneEnd type:%d errType:%d errCode:%d", new Object[] { Integer.valueOf(paramn.getType()), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    az.agU().az(new Runnable()
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
          ac.d("MicroMsg.SceneAppMsg", "onSceneEnd  SendAppMsg errtype:" + paramInt1 + " errCode:" + paramInt2);
          i = 0;
          l1 = -1L;
          long l3 = 0L;
          l2 = l3;
          if (l1 != -1L)
          {
            l2 = l3;
            if (ao.a.this.cWY.get(Long.valueOf(l1)) != null)
            {
              l2 = ((f.a)ao.a.this.cWY.get(Long.valueOf(l1))).YH();
              ao.a.this.cWY.remove(Long.valueOf(l1));
            }
          }
          ac.d("MicroMsg.SceneAppMsg", "onSceneEnd SceneType:" + paramn.getType() + " errtype:" + paramInt1 + " errCode:" + paramInt2 + " retCode:" + i + " rowid:" + l1 + " time:" + l2);
          if (paramInt1 != 0) {
            ao.a.d(ao.a.this);
          }
          ac.d("MicroMsg.SceneAppMsg", "onSceneEnd  inCnt:" + ao.a.cXd + " stop:" + ao.a.e(ao.a.this) + " running:" + ao.a.f(ao.a.this) + " recving:" + ao.a.g(ao.a.this) + " sending:" + ao.a.h(ao.a.this));
          if (ao.a.e(ao.a.this) <= 0) {
            break label661;
          }
          ao.a.i(ao.a.this);
        }
        for (;;)
        {
          ao.a.Ov();
          AppMethodBeat.o(31095);
          return;
          if (paramn.getType() == 221)
          {
            ao.a.a(ao.a.this);
            l1 = ((com.tencent.mm.plugin.record.b.e)paramn).wiP;
            i = ((com.tencent.mm.plugin.record.b.e)paramn).retCode;
            break;
          }
          if (paramn.getType() == 220)
          {
            ao.a.b(ao.a.this);
            l2 = ((ak)paramn).wiP;
            int j = ((ak)paramn).retCode;
            Object localObject1 = (ak)paramn;
            label461:
            Object localObject2;
            if (((ak)localObject1).wiN == null)
            {
              localObject1 = null;
              localObject2 = (ak)paramn;
              if (((ak)localObject2).wiN != null) {
                break label611;
              }
            }
            label611:
            for (l1 = 0L;; l1 = ((ak)localObject2).wiN.field_msgInfoId)
            {
              localObject2 = (String)ao.a.c(ao.a.this).remove(Long.valueOf(l1));
              if (!bs.isNullOrNil(((ak)paramn).hIq)) {
                i = 1;
              }
              if ((i == 0) && (!bs.isNullOrNil((String)localObject1)))
              {
                c localc = new c();
                ap.bEO().get(l2, localc);
                if (localc.systemRowid == l2)
                {
                  m.a(localc.field_msgInfoId, (String)localObject1, null, true);
                  ac.d("MicroMsg.SceneAppMsg", "onSceneEnd, finish update app attach, start send app msg");
                  ao.a.F(localc.field_msgInfoId, (String)localObject2);
                }
              }
              i = j;
              l1 = l2;
              break;
              localObject1 = ((ak)localObject1).wiN.field_mediaSvrId;
              break label461;
            }
          }
          ac.e("MicroMsg.SceneAppMsg", "onSceneEnd Error SceneType:" + paramn.getType());
          ao.a.Ov();
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
    az.agU().az(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(31097);
        long l = System.currentTimeMillis() - ao.a.k(ao.a.this);
        ac.d("MicroMsg.SceneAppMsg", "summerbig Try Run service runningFlag:" + ao.a.f(ao.a.this) + " timeWait:" + l + " sending:" + ao.a.h(ao.a.this) + " recving:" + ao.a.g(ao.a.this));
        if (ao.a.f(ao.a.this))
        {
          if (l < 180000L)
          {
            AppMethodBeat.o(31097);
            return;
          }
          ac.e("MicroMsg.SceneAppMsg", "summerbig ERR: Try Run service runningFlag:" + ao.a.f(ao.a.this) + " timeWait:" + l + ">=MAX_TIME_WAIT sending:" + ao.a.h(ao.a.this) + " recving:" + ao.a.g(ao.a.this));
        }
        ao.a.l(ao.a.this);
        ao.a.b(ao.a.this);
        ao.a.m(ao.a.this);
        ao.a.a(ao.a.this);
        ao.a.this.cXf.fJW = SystemClock.elapsedRealtime();
        ao.a.n(ao.a.this).au(10L, 10L);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.model.app.ao.a
 * JD-Core Version:    0.7.0.1
 */