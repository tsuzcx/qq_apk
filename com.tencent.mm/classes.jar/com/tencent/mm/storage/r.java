package com.tencent.mm.storage;

import android.database.Cursor;
import android.os.Looper;
import com.tencent.mm.cf.h;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.messenger.foundation.a.j;
import com.tencent.mm.sdk.e.c;
import com.tencent.mm.sdk.e.i;
import com.tencent.mm.sdk.e.k;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

public final class r
  extends i<q>
{
  public static final String[] cqY = { "CREATE  INDEX IF NOT EXISTS msg_svr_id_index ON BizTimeLineInfo ( msgSvrId ) ", "CREATE  INDEX IF NOT EXISTS talker_index ON BizTimeLineInfo ( talker ) ", "CREATE  INDEX IF NOT EXISTS  order_flag_index ON BizTimeLineInfo ( orderFlag ) ", "CREATE  INDEX IF NOT EXISTS  status_order_flag_index ON BizTimeLineInfo ( status,orderFlag ) ", "CREATE  INDEX IF NOT EXISTS  has_show_talker_index ON BizTimeLineInfo ( hasShow,talker ) ", "CREATE  INDEX IF NOT EXISTS  status_talker_index ON BizTimeLineInfo ( status,talker ) ", "CREATE  INDEX IF NOT EXISTS  has_show_place_top_index ON BizTimeLineInfo ( hasShow,placeTop ) ", "CREATE  INDEX IF NOT EXISTS  order_flag_place_top_index ON BizTimeLineInfo ( orderFlag,placeTop ) " };
  public static final String[] dXp = { i.a(q.buS, "BizTimeLineInfo") };
  public final h dXo;
  private final k<c, a> umW = new r.1(this);
  private final long umX = 10L;
  private AtomicLong umY = new AtomicLong(10L);
  private long umZ = 10L;
  
  public r(h paramh)
  {
    super(paramh, q.buS, "BizTimeLineInfo", cqY);
    this.dXo = paramh;
    ctI();
  }
  
  private void ctI()
  {
    for (;;)
    {
      try
      {
        this.umZ = (ctJ() >> 32);
        if (this.umZ < 10L) {
          this.umZ = 10L;
        }
        q localq = ctD();
        if (localq == null)
        {
          y.w("MicroMsg.BizTimeLineInfoStorage", "initGroupId is null, id %d", new Object[] { Long.valueOf(this.umZ) });
          return;
        }
        if (localq.field_status == 4)
        {
          this.umY.set(this.umZ + 1L);
          y.i("MicroMsg.BizTimeLineInfoStorage", "initGroupId id %d/%d, status %d", new Object[] { Long.valueOf(this.umY.longValue()), Long.valueOf(this.umZ), Integer.valueOf(localq.field_status) });
        }
        else
        {
          this.umY.set(this.umZ);
        }
      }
      finally {}
    }
  }
  
  private long ctJ()
  {
    try
    {
      Cursor localCursor = this.dXo.a("select max(orderFlag) from BizTimeLineInfo", null, 2);
      long l = 0L;
      if (localCursor.moveToFirst()) {
        l = localCursor.getLong(0);
      }
      localCursor.close();
      return l;
    }
    finally {}
  }
  
  private void hA(long paramLong)
  {
    try
    {
      this.umZ = Math.max(paramLong, this.umZ);
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public static List<q> m(Cursor paramCursor)
  {
    LinkedList localLinkedList = new LinkedList();
    while (paramCursor.moveToNext())
    {
      q localq = new q();
      localq.d(paramCursor);
      localLinkedList.add(localq);
    }
    paramCursor.close();
    return localLinkedList;
  }
  
  public final q D(long paramLong, String paramString)
  {
    q localq = new q();
    paramString = this.dXo.a("BizTimeLineInfo", null, paramString + "=?", new String[] { String.valueOf(paramLong) }, null, null, null, 2);
    if (paramString.moveToFirst())
    {
      localq.d(paramString);
      paramString.close();
      return localq;
    }
    paramString.close();
    return null;
  }
  
  public final boolean Hr(String paramString)
  {
    q localq = new q();
    localq.field_talker = paramString;
    boolean bool = super.a(localq, false, new String[] { "talker" });
    paramString = new a();
    paramString.talker = localq.field_talker;
    paramString.igD = localq;
    paramString.unb = r.b.une;
    b(paramString);
    return bool;
  }
  
  public final List<q> W(int paramInt, long paramLong)
  {
    h localh = this.dXo;
    String str = "orderFlag DESC limit " + paramInt;
    return m(localh.query("BizTimeLineInfo", null, "orderFlag<?", new String[] { String.valueOf(paramLong) }, null, null, str));
  }
  
  public final void a(c paramc)
  {
    this.umW.remove(paramc);
  }
  
  public final void a(c paramc, Looper paramLooper)
  {
    this.umW.a(paramc, paramLooper);
  }
  
  public final void aaI(String paramString)
  {
    if (bk.bl(paramString)) {
      return;
    }
    if (((j)g.r(j.class)).Fw().abl(paramString).Bl()) {}
    for (int i = 1;; i = 0)
    {
      Object localObject = "update BizTimeLineInfo set placeTop = " + i + " where status != 4 and talker = '" + paramString + "'";
      this.dXo.gk("BizTimeLineInfo", (String)localObject);
      localObject = ctD();
      if ((localObject != null) && (paramString.equals(((q)localObject).field_talker)))
      {
        ((q)localObject).field_placeTop = i;
        super.b((c)localObject, false, new String[] { "msgSvrId" });
      }
      paramString = new a();
      paramString.unb = r.b.unf;
      b(paramString);
      return;
    }
  }
  
  public final q aaJ(String paramString)
  {
    Object localObject = null;
    paramString = "SELECT * FROM BizTimeLineInfo where talker = '" + paramString + "'  order by orderFlag DESC limit 1";
    Cursor localCursor = this.dXo.a(paramString, null, 0);
    paramString = localObject;
    if (localCursor.moveToFirst())
    {
      paramString = new q();
      paramString.d(localCursor);
    }
    localCursor.close();
    return paramString;
  }
  
  public final void b(a parama)
  {
    if (this.umW.bV(parama)) {
      this.umW.doNotify();
    }
  }
  
  public final q ctD()
  {
    q localq = null;
    Cursor localCursor = this.dXo.a("SELECT * FROM BizTimeLineInfo order by orderFlag DESC limit 1", null, 0);
    if (localCursor.moveToFirst())
    {
      localq = new q();
      localq.d(localCursor);
    }
    localCursor.close();
    return localq;
  }
  
  public final void ctE()
  {
    y.d("MicroMsg.BizTimeLineInfoStorage", "resetUnShow ret = %b", new Object[] { Boolean.valueOf(this.dXo.gk("BizTimeLineInfo", "update BizTimeLineInfo set hasShow = 1 where hasShow != 1 ")) });
    a locala = new a();
    locala.unb = r.b.unf;
    locala.unc = true;
    b(locala);
  }
  
  public final int ctF()
  {
    int i = 0;
    Cursor localCursor = this.dXo.a("SELECT count(*) FROM BizTimeLineInfo where hasShow != 1 ", null, 0);
    if (localCursor.moveToFirst()) {
      i = localCursor.getInt(0);
    }
    localCursor.close();
    return i;
  }
  
  public final long ctG()
  {
    try
    {
      long l = this.umZ;
      return l;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public final long ctH()
  {
    try
    {
      long l = this.umY.incrementAndGet();
      return l;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public final long cty()
  {
    try
    {
      long l = this.umY.longValue();
      return l;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public final boolean g(q paramq)
  {
    boolean bool = super.a(paramq, false);
    hA(paramq.cty());
    a locala = new a();
    locala.talker = paramq.field_talker;
    locala.igD = paramq;
    locala.unb = r.b.und;
    b(locala);
    return bool;
  }
  
  public final boolean h(q paramq)
  {
    boolean bool = super.b(paramq, false, new String[] { "msgSvrId" });
    a locala = new a();
    locala.talker = paramq.field_talker;
    locala.igD = paramq;
    locala.unb = r.b.unf;
    b(locala);
    return bool;
  }
  
  public final boolean h(List<q> paramList, boolean paramBoolean)
  {
    if (bk.dk(paramList)) {
      return false;
    }
    long l = this.dXo.eV(Thread.currentThread().getId());
    Object localObject = paramList.iterator();
    while (((Iterator)localObject).hasNext()) {
      super.b((q)((Iterator)localObject).next(), false, new String[] { "msgSvrId" });
    }
    this.dXo.hI(l);
    if (!paramBoolean) {
      return true;
    }
    localObject = new a();
    ((a)localObject).list = paramList;
    ((a)localObject).unb = r.b.unf;
    b((a)localObject);
    return true;
  }
  
  public final List<q> hx(long paramLong)
  {
    return m(this.dXo.query("BizTimeLineInfo", null, "orderFlag>=?", new String[] { String.valueOf(paramLong) }, null, null, "orderFlag DESC"));
  }
  
  public final int hy(long paramLong)
  {
    int i = 0;
    Object localObject = "SELECT count(*) FROM BizTimeLineInfo where status != 4 and orderFlag >= " + (0x0 & paramLong);
    localObject = this.dXo.a((String)localObject, null, 0);
    if (((Cursor)localObject).moveToFirst()) {
      i = ((Cursor)localObject).getInt(0);
    }
    ((Cursor)localObject).close();
    return i;
  }
  
  public final void hz(long paramLong)
  {
    Object localObject = new q();
    ((q)localObject).field_msgId = paramLong;
    super.a((c)localObject, false, new String[] { "msgId" });
    localObject = new a();
    ((a)localObject).unb = r.b.une;
    b((a)localObject);
  }
  
  public static final class a
  {
    public q igD;
    public List<q> list;
    public String talker;
    public r.b unb = r.b.und;
    public boolean unc = false;
  }
  
  public static abstract interface c
  {
    public abstract void a(r.a parama);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.storage.r
 * JD-Core Version:    0.7.0.1
 */