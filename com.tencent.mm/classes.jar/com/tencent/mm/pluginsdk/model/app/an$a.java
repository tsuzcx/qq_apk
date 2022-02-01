package com.tencent.mm.pluginsdk.model.app;

import android.database.Cursor;
import android.os.HandlerThread;
import android.os.SystemClock;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ah.k.b;
import com.tencent.mm.ak.n;
import com.tencent.mm.ak.q;
import com.tencent.mm.compatible.util.f.a;
import com.tencent.mm.g.c.ei;
import com.tencent.mm.model.bc;
import com.tencent.mm.model.bl;
import com.tencent.mm.model.x;
import com.tencent.mm.plugin.messenger.foundation.a.a.i;
import com.tencent.mm.pluginsdk.g.c.a;
import com.tencent.mm.sdk.e.e;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ar;
import com.tencent.mm.sdk.platformtools.aw;
import com.tencent.mm.sdk.platformtools.aw.a;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.storage.bv;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public final class an$a
  implements com.tencent.mm.ak.f
{
  private static int djw = 0;
  private HashMap<Long, String> Fgf;
  Queue<Long> djp;
  Queue<Long> djq;
  Map<Long, f.a> djr;
  private boolean djs;
  private boolean djt;
  int dju;
  private long djv;
  f.a djy;
  private aw djz;
  private boolean running;
  
  public an$a()
  {
    AppMethodBeat.i(31101);
    this.Fgf = new HashMap();
    this.djp = new LinkedList();
    this.djq = new LinkedList();
    this.djr = new HashMap();
    this.djs = false;
    this.djt = false;
    this.running = false;
    this.dju = 0;
    this.djv = 0L;
    this.djy = new f.a();
    this.djz = new aw(bc.ajU().IxZ.getLooper(), new aw.a()
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
    bc.ajj().a(220, this);
    bc.ajj().a(221, this);
    bc.ajj().a(222, this);
    AppMethodBeat.o(31101);
  }
  
  public static void L(long paramLong, String paramString)
  {
    AppMethodBeat.i(31105);
    bc.ajj().a(new ag(paramLong, paramString, null), 0);
    AppMethodBeat.o(31105);
  }
  
  private void Qd()
  {
    AppMethodBeat.i(31110);
    this.djr.clear();
    this.djp.clear();
    this.djq.clear();
    this.djt = false;
    this.djs = false;
    this.running = false;
    ae.d("MicroMsg.SceneAppMsg", "Finish service use time(ms):" + this.djy.abs());
    AppMethodBeat.o(31110);
  }
  
  public static void a(long paramLong, String paramString, int paramInt, a parama)
  {
    AppMethodBeat.i(31107);
    bc.ajj().a(new ag(paramLong, paramString, paramInt, parama), 0);
    AppMethodBeat.o(31107);
  }
  
  private boolean aNC()
  {
    AppMethodBeat.i(31108);
    for (;;)
    {
      try
      {
        localObject2 = ao.bJV().rawQuery("select *  , rowid  from appattach where status = 101", new String[0]);
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
        ae.printErrStackTrace("MicroMsg.SceneAppMsg", localIllegalStateException, "", new Object[0]);
        Object localObject1 = ao.bJV();
        Object localObject2 = " update appattach set status = 198 , lastModifyTime = " + bu.aRi() + " where status = 101";
        ((d)localObject1).db.execSQL("appattach", (String)localObject2);
        ((d)localObject1).doNotify();
        localObject1 = null;
        continue;
        long l = System.currentTimeMillis() / 1000L;
        localObject2 = bu.DA(l);
        localObject1 = ((List)localObject1).iterator();
        if (!((Iterator)localObject1).hasNext()) {
          continue;
        }
        c localc = (c)((Iterator)localObject1).next();
        if (!this.djr.containsKey(Long.valueOf(localc.systemRowid))) {
          continue;
        }
        ae.d("MicroMsg.SceneAppMsg", "summerbig File is Already running:" + localc.systemRowid);
        continue;
        ae.d("MicroMsg.SceneAppMsg", "summerbig Get file:" + localc.field_fileFullPath + " status:" + localc.field_status + " create:(" + bu.DA(localc.field_createTime) + "," + bu.DA(localc.field_createTime / 1000L) + ", last:" + bu.DA(localc.field_lastModifyTime) + " now:" + bu.DA(l) + " " + (l - localc.field_lastModifyTime));
        if (!localc.field_isUpload) {
          continue;
        }
        if ((l - localc.field_lastModifyTime <= 600L) || (localc.field_status != 101L)) {
          continue;
        }
        ae.e("MicroMsg.SceneAppMsg", "summerbig time out file: " + localc.field_fileFullPath + " last:" + bu.DA(localc.field_lastModifyTime) + " now:" + (String)localObject2);
        m.zc(localc.systemRowid);
        continue;
        this.djp.offer(Long.valueOf(localc.systemRowid));
        this.djr.put(Long.valueOf(localc.systemRowid), null);
        continue;
        ae.d("MicroMsg.SceneAppMsg", "summerbig GetNeedRun procing:" + this.djr.size() + " [recv:" + this.djq.size() + ",send:" + this.djp.size() + "]");
        if (this.djq.size() + this.djp.size() != 0) {
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
      ae.d("MicroMsg.AppAttachInfoStorage", "getUnfinishInfo resCount:".concat(String.valueOf(j)));
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
    bc.ajj().a(new ag(paramLong, paramString1, paramString2), 0);
    AppMethodBeat.o(31106);
  }
  
  public static void zb(long paramLong)
  {
    AppMethodBeat.i(31104);
    bc.ajj().a(new ag(paramLong, null, null), 0);
    AppMethodBeat.o(31104);
  }
  
  public final void K(long paramLong, String paramString)
  {
    AppMethodBeat.i(31103);
    this.Fgf.put(Long.valueOf(paramLong), paramString);
    AppMethodBeat.o(31103);
  }
  
  protected final void finalize()
  {
    AppMethodBeat.i(31102);
    bc.ajj().b(220, this);
    bc.ajj().b(221, this);
    bc.ajj().b(222, this);
    this.Fgf.clear();
    super.finalize();
    AppMethodBeat.o(31102);
  }
  
  public final void onSceneEnd(final int paramInt1, final int paramInt2, String paramString, final n paramn)
  {
    AppMethodBeat.i(31109);
    ae.d("MicroMsg.SceneAppMsg", "summersafecdn onSceneEnd type:%d errType:%d errCode:%d", new Object[] { Integer.valueOf(paramn.getType()), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    bc.ajU().aw(new Runnable()
    {
      public final void run()
      {
        int i = 0;
        AppMethodBeat.i(31095);
        an.a.Qe();
        long l1;
        long l2;
        if (paramn.getType() == 222)
        {
          ae.d("MicroMsg.SceneAppMsg", "onSceneEnd  SendAppMsg errtype:" + paramInt1 + " errCode:" + paramInt2);
          i = 0;
          l1 = -1L;
          long l3 = 0L;
          l2 = l3;
          if (l1 != -1L)
          {
            l2 = l3;
            if (an.a.this.djr.get(Long.valueOf(l1)) != null)
            {
              l2 = ((f.a)an.a.this.djr.get(Long.valueOf(l1))).abs();
              an.a.this.djr.remove(Long.valueOf(l1));
            }
          }
          ae.d("MicroMsg.SceneAppMsg", "onSceneEnd SceneType:" + paramn.getType() + " errtype:" + paramInt1 + " errCode:" + paramInt2 + " retCode:" + i + " rowid:" + l1 + " time:" + l2);
          if (paramInt1 != 0) {
            an.a.e(an.a.this);
          }
          ae.d("MicroMsg.SceneAppMsg", "onSceneEnd  inCnt:" + an.a.djw + " stop:" + an.a.f(an.a.this) + " running:" + an.a.g(an.a.this) + " recving:" + an.a.h(an.a.this) + " sending:" + an.a.i(an.a.this));
          if (an.a.f(an.a.this) <= 0) {
            break label650;
          }
          an.a.j(an.a.this);
        }
        for (;;)
        {
          an.a.Qf();
          AppMethodBeat.o(31095);
          return;
          if (paramn.getType() == 221)
          {
            an.a.b(an.a.this);
            l1 = ((com.tencent.mm.plugin.record.b.f)paramn).xGx;
            i = ((com.tencent.mm.plugin.record.b.f)paramn).retCode;
            break;
          }
          if (paramn.getType() == 220)
          {
            an.a.c(an.a.this);
            l1 = ((aj)paramn).xGx;
            int j = ((aj)paramn).retCode;
            Object localObject = (aj)paramn;
            if (((aj)localObject).xGv == null) {}
            for (localObject = null;; localObject = ((aj)localObject).xGv.field_mediaSvrId)
            {
              l2 = ((aj)paramn).fdR();
              String str = (String)an.a.d(an.a.this).remove(Long.valueOf(l2));
              if (!bu.isNullOrNil(((aj)paramn).idX)) {
                i = 1;
              }
              if ((i == 0) && (!((aj)paramn).FfW) && (!bu.isNullOrNil((String)localObject)))
              {
                c localc = new c();
                ao.bJV().get(l1, localc);
                if (localc.systemRowid == l1)
                {
                  m.a(localc.field_msgInfoId, (String)localObject, null, true);
                  ae.d("MicroMsg.SceneAppMsg", "onSceneEnd, finish update app attach, start send app msg");
                  an.a.L(localc.field_msgInfoId, str);
                }
              }
              i = j;
              break;
            }
          }
          ae.e("MicroMsg.SceneAppMsg", "onSceneEnd Error SceneType:" + paramn.getType());
          an.a.Qf();
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
    bc.ajU().aw(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(31097);
        long l = System.currentTimeMillis() - an.a.l(an.a.this);
        ae.d("MicroMsg.SceneAppMsg", "summerbig Try Run service runningFlag:" + an.a.g(an.a.this) + " timeWait:" + l + " sending:" + an.a.i(an.a.this) + " recving:" + an.a.h(an.a.this));
        if (an.a.g(an.a.this))
        {
          if (l < 180000L)
          {
            AppMethodBeat.o(31097);
            return;
          }
          ae.e("MicroMsg.SceneAppMsg", "summerbig ERR: Try Run service runningFlag:" + an.a.g(an.a.this) + " timeWait:" + l + ">=MAX_TIME_WAIT sending:" + an.a.i(an.a.this) + " recving:" + an.a.h(an.a.this));
        }
        an.a.m(an.a.this);
        an.a.c(an.a.this);
        an.a.n(an.a.this);
        an.a.b(an.a.this);
        an.a.this.djy.gfF = SystemClock.elapsedRealtime();
        an.a.o(an.a.this).ay(10L, 10L);
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
 * Qualified Name:     com.tencent.mm.pluginsdk.model.app.an.a
 * JD-Core Version:    0.7.0.1
 */