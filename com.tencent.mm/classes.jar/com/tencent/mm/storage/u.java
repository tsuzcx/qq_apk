package com.tencent.mm.storage;

import android.database.Cursor;
import android.os.Looper;
import com.tencent.mars.smc.IDKey;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.messenger.foundation.a.k;
import com.tencent.mm.sdk.e.j;
import com.tencent.mm.sdk.e.l;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.vending.c.a;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

public final class u
  extends j<t>
{
  public static final String[] GCd;
  private static final com.tencent.mm.b.f<Long, Boolean> GCf;
  public static final String[] INDEX_CREATE;
  public static final String[] SQL_CREATE;
  private final l<c, a> GCe;
  public boolean GCg;
  private final long GCh;
  private AtomicLong GCi;
  private long GCj;
  private long GCk;
  private final long GCl;
  private AtomicLong GCm;
  public final com.tencent.mm.storagebase.h hpA;
  
  static
  {
    AppMethodBeat.i(124655);
    SQL_CREATE = new String[] { j.getCreateSQLs(t.info, "BizTimeLineInfo") };
    INDEX_CREATE = new String[] { "CREATE  INDEX IF NOT EXISTS msg_svr_id_index ON BizTimeLineInfo ( msgSvrId ) ", "CREATE  INDEX IF NOT EXISTS msg_id_index ON BizTimeLineInfo ( msgId ) ", "CREATE  INDEX IF NOT EXISTS talker_index ON BizTimeLineInfo ( talker ) ", "CREATE  INDEX IF NOT EXISTS  has_show_talker_index ON BizTimeLineInfo ( hasShow,talker ) ", "CREATE  INDEX IF NOT EXISTS  status_talker_index ON BizTimeLineInfo ( status,talker ) ", "CREATE  INDEX IF NOT EXISTS  has_show_place_top_index ON BizTimeLineInfo ( hasShow,placeTop ) ", "CREATE  INDEX IF NOT EXISTS  order_flag_place_top_index ON BizTimeLineInfo ( orderFlag,placeTop ) ", "CREATE  INDEX IF NOT EXISTS  talker_id_order_flag_index ON BizTimeLineInfo ( talkerId,orderFlag ) " };
    GCd = new String[] { "CREATE  INDEX IF NOT EXISTS  order_flag_status_index ON BizTimeLineInfo ( orderFlag,status ) ", "CREATE  INDEX IF NOT EXISTS  order_flag_has_show_index ON BizTimeLineInfo ( orderFlag,hasShow ) ", "CREATE  INDEX IF NOT EXISTS  biz_client_msg_id_index ON BizTimeLineInfo ( bizClientMsgId ) ", "CREATE  INDEX IF NOT EXISTS  is_read_order_flag_index ON BizTimeLineInfo ( isRead,orderFlag ) ", "CREATE  INDEX IF NOT EXISTS  type_order_flag_index ON BizTimeLineInfo ( type,orderFlag ) ", "CREATE  INDEX IF NOT EXISTS  biz_create_time_index ON BizTimeLineInfo ( createTime ) " };
    GCf = new com.tencent.mm.memory.a.c(30);
    AppMethodBeat.o(124655);
  }
  
  public u(com.tencent.mm.storagebase.h paramh)
  {
    super(paramh, t.info, "BizTimeLineInfo", INDEX_CREATE);
    AppMethodBeat.i(124624);
    this.GCe = new l() {};
    this.GCg = true;
    this.GCh = 10L;
    this.GCi = new AtomicLong(10L);
    this.GCj = 10L;
    this.GCl = -5000000L;
    this.GCm = new AtomicLong(-5000000L);
    this.hpA = paramh;
    eZw();
    AppMethodBeat.o(124624);
  }
  
  private void AG(long paramLong)
  {
    try
    {
      AppMethodBeat.i(124646);
      this.GCj = Math.max(paramLong, this.GCj);
      AppMethodBeat.o(124646);
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  private t H(long paramLong, String paramString)
  {
    AppMethodBeat.i(124631);
    t localt = new t();
    paramString = this.hpA.a("BizTimeLineInfo", null, paramString + "=?", new String[] { String.valueOf(paramLong) }, null, null, null, 2);
    if (paramString.moveToFirst())
    {
      localt.convertFrom(paramString);
      paramString.close();
      AppMethodBeat.o(124631);
      return localt;
    }
    paramString.close();
    AppMethodBeat.o(124631);
    return null;
  }
  
  private void eZw()
  {
    for (;;)
    {
      try
      {
        AppMethodBeat.i(124649);
        this.GCj = (eZy() >> 32);
        if (this.GCj < 10L) {
          this.GCj = 10L;
        }
        t localt = eZr();
        if (localt == null)
        {
          ac.w("MicroMsg.BizTimeLineInfoStorage", "initGroupId is null, id %d", new Object[] { Long.valueOf(this.GCj) });
          AppMethodBeat.o(124649);
          return;
        }
        if (localt.field_status == 4)
        {
          this.GCi.set(this.GCj + 1L);
          this.GCk = this.GCi.longValue();
          ac.i("MicroMsg.BizTimeLineInfoStorage", "initGroupId id %d/%d, status %d", new Object[] { Long.valueOf(this.GCi.longValue()), Long.valueOf(this.GCj), Integer.valueOf(localt.field_status) });
          AppMethodBeat.o(124649);
        }
        else
        {
          this.GCi.set(this.GCj);
        }
      }
      finally {}
    }
  }
  
  private long eZy()
  {
    try
    {
      AppMethodBeat.i(124651);
      Cursor localCursor = this.hpA.a("select max(orderFlag) from BizTimeLineInfo", null, 2);
      long l = 0L;
      if (localCursor.moveToFirst())
      {
        l = localCursor.getLong(0);
        localCursor.close();
      }
      AppMethodBeat.o(124651);
      return l;
    }
    finally {}
  }
  
  static List<t> o(Cursor paramCursor)
  {
    AppMethodBeat.i(124635);
    LinkedList localLinkedList = new LinkedList();
    while (paramCursor.moveToNext())
    {
      t localt = new t();
      localt.convertFrom(paramCursor);
      localLinkedList.add(localt);
    }
    paramCursor.close();
    AppMethodBeat.o(124635);
    return localLinkedList;
  }
  
  public final t AA(long paramLong)
  {
    t localt = null;
    AppMethodBeat.i(124637);
    Object localObject = "SELECT * FROM BizTimeLineInfo where talkerId = " + paramLong + "  order by orderFlag DESC limit 1";
    localObject = this.hpA.a((String)localObject, null, 0);
    if (((Cursor)localObject).moveToFirst())
    {
      localt = new t();
      localt.convertFrom((Cursor)localObject);
    }
    ((Cursor)localObject).close();
    AppMethodBeat.o(124637);
    return localt;
  }
  
  public final void AB(long paramLong)
  {
    AppMethodBeat.i(124638);
    if (AC(paramLong) > 2000)
    {
      localObject = Aw(paramLong);
      if (localObject != null)
      {
        ((t)localObject).field_status = 4;
        k((t)localObject);
      }
      AppMethodBeat.o(124638);
      return;
    }
    long l1 = System.currentTimeMillis();
    long l2 = 0x0 & paramLong;
    Object localObject = "update BizTimeLineInfo set status = 4 where orderFlag >= " + l2 + " and status > 4";
    this.hpA.execSQL("BizTimeLineInfo", (String)localObject);
    localObject = "update BizTimeLineInfo set status = 4 where orderFlag >= " + l2 + " and status < 4";
    this.hpA.execSQL("BizTimeLineInfo", (String)localObject);
    ac.d("MicroMsg.BizTimeLineInfoStorage", "resetUnread cost %d", new Object[] { Long.valueOf(System.currentTimeMillis() - l1) });
    GCf.o(Long.valueOf(paramLong), Boolean.TRUE);
    AppMethodBeat.o(124638);
  }
  
  public final int AC(long paramLong)
  {
    AppMethodBeat.i(124639);
    Object localObject = (Boolean)GCf.get(Long.valueOf(paramLong));
    if ((localObject != null) && (((Boolean)localObject).booleanValue()))
    {
      AppMethodBeat.o(124639);
      return 0;
    }
    long l1 = System.currentTimeMillis();
    long l2 = 0x0 & paramLong;
    localObject = "SELECT count(*) FROM BizTimeLineInfo where orderFlag >= " + l2 + " and status > 4";
    localObject = this.hpA.a((String)localObject, null, 0);
    if (((Cursor)localObject).moveToFirst()) {}
    for (int j = ((Cursor)localObject).getInt(0);; j = 0)
    {
      ((Cursor)localObject).close();
      localObject = "SELECT count(*) FROM BizTimeLineInfo where orderFlag >= " + l2 + " and status < 4";
      localObject = this.hpA.a((String)localObject, null, 0);
      int i = j;
      if (((Cursor)localObject).moveToFirst()) {
        i = j + ((Cursor)localObject).getInt(0);
      }
      ((Cursor)localObject).close();
      j = i;
      if (i > 2000) {
        j = 0;
      }
      if (j == 0) {
        GCf.o(Long.valueOf(paramLong), Boolean.TRUE);
      }
      ac.d("MicroMsg.BizTimeLineInfoStorage", "getUnread cost %d", new Object[] { Long.valueOf(System.currentTimeMillis() - l1) });
      AppMethodBeat.o(124639);
      return j;
    }
  }
  
  public final void AD(final long paramLong)
  {
    AppMethodBeat.i(124641);
    com.tencent.mm.cn.g.fBc().h(new a() {}).b(new a() {});
    AppMethodBeat.o(124641);
  }
  
  public final int AE(long paramLong)
  {
    AppMethodBeat.i(124643);
    long l = System.currentTimeMillis();
    Object localObject = "SELECT count(*) FROM BizTimeLineInfo where orderFlag >= " + (0x0 & paramLong) + " and hasShow < 1 ";
    localObject = this.hpA.a((String)localObject, null, 0);
    if (((Cursor)localObject).moveToFirst()) {}
    for (int i = ((Cursor)localObject).getInt(0);; i = 0)
    {
      ac.d("MicroMsg.BizTimeLineInfoStorage", "getUnShowCount count = %d,cost = %d", new Object[] { Integer.valueOf(i), Long.valueOf(System.currentTimeMillis() - l) });
      ((Cursor)localObject).close();
      if (i > 2000)
      {
        if (this.GCk == this.GCi.longValue()) {
          eZv();
        }
        AppMethodBeat.o(124643);
        return 0;
      }
      AppMethodBeat.o(124643);
      return i;
    }
  }
  
  public final void AF(long paramLong)
  {
    AppMethodBeat.i(124645);
    Object localObject = new t();
    ((t)localObject).field_msgId = paramLong;
    super.delete((com.tencent.mm.sdk.e.c)localObject, false, new String[] { "msgId" });
    localObject = new a();
    ((a)localObject).GCq = b.GCt;
    a((a)localObject);
    AppMethodBeat.o(124645);
  }
  
  public final t AH(long paramLong)
  {
    t localt = null;
    AppMethodBeat.i(124653);
    Object localObject = "SELECT * FROM BizTimeLineInfo where type=620757041 and orderFlag > ".concat(String.valueOf(paramLong));
    localObject = this.hpA.a((String)localObject, null, 0);
    if (((Cursor)localObject).moveToFirst())
    {
      localt = new t();
      localt.convertFrom((Cursor)localObject);
    }
    ((Cursor)localObject).close();
    AppMethodBeat.o(124653);
    return localt;
  }
  
  public final t Aw(long paramLong)
  {
    AppMethodBeat.i(124629);
    t localt = H(paramLong, "orderFlag");
    AppMethodBeat.o(124629);
    return localt;
  }
  
  public final t Ax(long paramLong)
  {
    AppMethodBeat.i(124630);
    t localt = H(paramLong, "msgId");
    AppMethodBeat.o(124630);
    return localt;
  }
  
  public final List<t> Ay(long paramLong)
  {
    AppMethodBeat.i(209582);
    List localList = o(this.hpA.query("BizTimeLineInfo", null, "orderFlag>?", new String[] { String.valueOf(paramLong) }, null, null, "orderFlag DESC limit 5"));
    AppMethodBeat.o(209582);
    return localList;
  }
  
  public final List<t> Az(long paramLong)
  {
    AppMethodBeat.i(124634);
    List localList = o(this.hpA.query("BizTimeLineInfo", null, "orderFlag>=?", new String[] { String.valueOf(paramLong) }, null, null, "orderFlag DESC"));
    AppMethodBeat.o(124634);
    return localList;
  }
  
  public final List<t> Yz(int paramInt)
  {
    AppMethodBeat.i(124633);
    List localList = o(this.hpA.query("BizTimeLineInfo", null, null, null, null, null, "orderFlag DESC limit ".concat(String.valueOf(paramInt))));
    AppMethodBeat.o(124633);
    return localList;
  }
  
  public final void a(a parama)
  {
    AppMethodBeat.i(124621);
    if (this.GCe.dS(parama)) {
      this.GCe.doNotify();
    }
    AppMethodBeat.o(124621);
  }
  
  public final void a(c paramc)
  {
    AppMethodBeat.i(124623);
    this.GCe.remove(paramc);
    AppMethodBeat.o(124623);
  }
  
  public final void a(c paramc, Looper paramLooper)
  {
    AppMethodBeat.i(124622);
    this.GCe.a(paramc, paramLooper);
    AppMethodBeat.o(124622);
  }
  
  public final List<t> aF(int paramInt, long paramLong)
  {
    AppMethodBeat.i(124632);
    Object localObject = this.hpA;
    String str = "orderFlag DESC limit ".concat(String.valueOf(paramInt));
    localObject = o(((com.tencent.mm.storagebase.h)localObject).query("BizTimeLineInfo", null, "orderFlag<?", new String[] { String.valueOf(paramLong) }, null, null, str));
    AppMethodBeat.o(124632);
    return localObject;
  }
  
  public final void aMR(String paramString)
  {
    AppMethodBeat.i(124627);
    if (bs.isNullOrNil(paramString))
    {
      AppMethodBeat.o(124627);
      return;
    }
    if (((k)com.tencent.mm.kernel.g.ab(k.class)).awB().aNt(paramString).aaN()) {}
    for (int i = 1;; i = 0)
    {
      Object localObject = "update BizTimeLineInfo set placeTop = " + i + " where status > 4 and talker = '" + paramString + "'";
      this.hpA.execSQL("BizTimeLineInfo", (String)localObject);
      localObject = "update BizTimeLineInfo set placeTop = " + i + " where status < 4 and talker = '" + paramString + "'";
      this.hpA.execSQL("BizTimeLineInfo", (String)localObject);
      localObject = eZr();
      if ((localObject != null) && (paramString.equals(((t)localObject).field_talker)))
      {
        ((t)localObject).field_placeTop = i;
        super.updateNotify((com.tencent.mm.sdk.e.c)localObject, false, new String[] { "msgSvrId" });
      }
      paramString = new a();
      paramString.GCq = b.GCu;
      a(paramString);
      AppMethodBeat.o(124627);
      return;
    }
  }
  
  public final boolean alb(String paramString)
  {
    AppMethodBeat.i(124644);
    t localt = new t();
    localt.field_talker = paramString;
    boolean bool = super.delete(localt, false, new String[] { "talker" });
    paramString = new a();
    paramString.talker = localt.field_talker;
    paramString.nAa = localt;
    paramString.GCq = b.GCt;
    a(paramString);
    AppMethodBeat.o(124644);
    return bool;
  }
  
  public final long eZh()
  {
    try
    {
      AppMethodBeat.i(124647);
      long l = this.GCi.longValue();
      AppMethodBeat.o(124647);
      return l;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public final t eZr()
  {
    t localt = null;
    AppMethodBeat.i(124636);
    Cursor localCursor = this.hpA.a("SELECT * FROM BizTimeLineInfo order by orderFlag DESC limit 1", null, 0);
    if (localCursor.moveToFirst())
    {
      localt = new t();
      localt.convertFrom(localCursor);
    }
    localCursor.close();
    AppMethodBeat.o(124636);
    return localt;
  }
  
  public final void eZs()
  {
    AppMethodBeat.i(124640);
    t localt = eZr();
    if (localt == null)
    {
      AppMethodBeat.o(124640);
      return;
    }
    AD(localt.field_orderFlag);
    AppMethodBeat.o(124640);
  }
  
  public final int eZt()
  {
    AppMethodBeat.i(124642);
    t localt = eZr();
    if (localt == null)
    {
      AppMethodBeat.o(124642);
      return 0;
    }
    int i = AE(localt.field_orderFlag);
    AppMethodBeat.o(124642);
    return i;
  }
  
  public final long eZu()
  {
    try
    {
      long l = this.GCj;
      return l;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public final long eZv()
  {
    try
    {
      AppMethodBeat.i(124648);
      long l = this.GCi.incrementAndGet();
      AppMethodBeat.o(124648);
      return l;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public final int eZx()
  {
    int i = 0;
    AppMethodBeat.i(124650);
    Cursor localCursor = this.hpA.a("SELECT count(*) FROM BizTimeLineInfo", null, 0);
    if (localCursor.moveToFirst()) {
      i = localCursor.getInt(0);
    }
    localCursor.close();
    AppMethodBeat.o(124650);
    return i;
  }
  
  public final long eZz()
  {
    t localt = null;
    try
    {
      AppMethodBeat.i(124652);
      if (this.GCm.longValue() == -5000000L)
      {
        Cursor localCursor = this.hpA.a("SELECT * FROM BizTimeLineInfo where type=620757041 order by orderFlag DESC limit 1", null, 0);
        if (localCursor.moveToFirst())
        {
          localt = new t();
          localt.convertFrom(localCursor);
        }
        localCursor.close();
        if (localt != null) {
          this.GCm.set(localt.field_msgId);
        }
      }
      long l = this.GCm.incrementAndGet();
      AppMethodBeat.o(124652);
      return l;
    }
    finally {}
  }
  
  public final boolean hd(final List<t> paramList)
  {
    AppMethodBeat.i(124628);
    if (bs.gY(paramList))
    {
      AppMethodBeat.o(124628);
      return false;
    }
    com.tencent.mm.cn.g.fBc().h(new a() {});
    AppMethodBeat.o(124628);
    return true;
  }
  
  public final boolean j(t paramt)
  {
    AppMethodBeat.i(124625);
    boolean bool = super.insertNotify(paramt, false);
    AG(paramt.eZh());
    a locala = new a();
    locala.talker = paramt.field_talker;
    locala.nAa = paramt;
    locala.GCq = b.GCs;
    a(locala);
    AppMethodBeat.o(124625);
    return bool;
  }
  
  public final boolean k(t paramt)
  {
    AppMethodBeat.i(124626);
    boolean bool = super.updateNotify(paramt, false, new String[] { "msgSvrId" });
    a locala = new a();
    locala.talker = paramt.field_talker;
    locala.nAa = paramt;
    locala.GCq = b.GCu;
    a(locala);
    AppMethodBeat.o(124626);
    return bool;
  }
  
  public static final class a
  {
    public u.b GCq = u.b.GCs;
    public boolean GCr = false;
    public List<t> list;
    public t nAa;
    public String talker;
  }
  
  public static enum b
  {
    static
    {
      AppMethodBeat.i(124620);
      GCs = new b("INSERT", 0);
      GCt = new b("DELETE", 1);
      GCu = new b("UPDATE", 2);
      GCv = new b("RE_SORT", 3);
      GCw = new b[] { GCs, GCt, GCu, GCv };
      AppMethodBeat.o(124620);
    }
    
    private b() {}
  }
  
  public static abstract interface c
  {
    public abstract void a(Object paramObject, u.a parama);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.storage.u
 * JD-Core Version:    0.7.0.1
 */