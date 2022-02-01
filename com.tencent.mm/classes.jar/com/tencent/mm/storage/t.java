package com.tencent.mm.storage;

import android.database.Cursor;
import android.os.Looper;
import com.tencent.mars.smc.IDKey;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.messenger.foundation.a.k;
import com.tencent.mm.sdk.e.j;
import com.tencent.mm.sdk.e.l;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.vending.c.a;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

public final class t
  extends j<s>
{
  public static final String[] Fet;
  private static final com.tencent.mm.b.f<Long, Boolean> Fev;
  public static final String[] INDEX_CREATE;
  public static final String[] SQL_CREATE;
  private long FeA;
  private final long FeB;
  private AtomicLong FeC;
  private final l<c, a> Feu;
  public boolean Few;
  private final long Fex;
  private AtomicLong Fey;
  private long Fez;
  public final com.tencent.mm.storagebase.h gPa;
  
  static
  {
    AppMethodBeat.i(124655);
    SQL_CREATE = new String[] { j.getCreateSQLs(s.info, "BizTimeLineInfo") };
    INDEX_CREATE = new String[] { "CREATE  INDEX IF NOT EXISTS msg_svr_id_index ON BizTimeLineInfo ( msgSvrId ) ", "CREATE  INDEX IF NOT EXISTS msg_id_index ON BizTimeLineInfo ( msgId ) ", "CREATE  INDEX IF NOT EXISTS talker_index ON BizTimeLineInfo ( talker ) ", "CREATE  INDEX IF NOT EXISTS  has_show_talker_index ON BizTimeLineInfo ( hasShow,talker ) ", "CREATE  INDEX IF NOT EXISTS  status_talker_index ON BizTimeLineInfo ( status,talker ) ", "CREATE  INDEX IF NOT EXISTS  has_show_place_top_index ON BizTimeLineInfo ( hasShow,placeTop ) ", "CREATE  INDEX IF NOT EXISTS  order_flag_place_top_index ON BizTimeLineInfo ( orderFlag,placeTop ) ", "CREATE  INDEX IF NOT EXISTS  talker_id_order_flag_index ON BizTimeLineInfo ( talkerId,orderFlag ) " };
    Fet = new String[] { "CREATE  INDEX IF NOT EXISTS  order_flag_status_index ON BizTimeLineInfo ( orderFlag,status ) ", "CREATE  INDEX IF NOT EXISTS  order_flag_has_show_index ON BizTimeLineInfo ( orderFlag,hasShow ) ", "CREATE  INDEX IF NOT EXISTS  biz_client_msg_id_index ON BizTimeLineInfo ( bizClientMsgId ) ", "CREATE  INDEX IF NOT EXISTS  is_read_order_flag_index ON BizTimeLineInfo ( isRead,orderFlag ) ", "CREATE  INDEX IF NOT EXISTS  type_order_flag_index ON BizTimeLineInfo ( type,orderFlag ) ", "CREATE  INDEX IF NOT EXISTS  biz_create_time_index ON BizTimeLineInfo ( createTime ) " };
    Fev = new com.tencent.mm.memory.a.c(30);
    AppMethodBeat.o(124655);
  }
  
  public t(com.tencent.mm.storagebase.h paramh)
  {
    super(paramh, s.info, "BizTimeLineInfo", INDEX_CREATE);
    AppMethodBeat.i(124624);
    this.Feu = new l() {};
    this.Few = true;
    this.Fex = 10L;
    this.Fey = new AtomicLong(10L);
    this.Fez = 10L;
    this.FeB = -5000000L;
    this.FeC = new AtomicLong(-5000000L);
    this.gPa = paramh;
    eJZ();
    AppMethodBeat.o(124624);
  }
  
  private s J(long paramLong, String paramString)
  {
    AppMethodBeat.i(124631);
    s locals = new s();
    paramString = this.gPa.a("BizTimeLineInfo", null, paramString + "=?", new String[] { String.valueOf(paramLong) }, null, null, null, 2);
    if (paramString.moveToFirst())
    {
      locals.convertFrom(paramString);
      paramString.close();
      AppMethodBeat.o(124631);
      return locals;
    }
    paramString.close();
    AppMethodBeat.o(124631);
    return null;
  }
  
  private void eJZ()
  {
    for (;;)
    {
      try
      {
        AppMethodBeat.i(124649);
        this.Fez = (eKb() >> 32);
        if (this.Fez < 10L) {
          this.Fez = 10L;
        }
        s locals = eJU();
        if (locals == null)
        {
          ad.w("MicroMsg.BizTimeLineInfoStorage", "initGroupId is null, id %d", new Object[] { Long.valueOf(this.Fez) });
          AppMethodBeat.o(124649);
          return;
        }
        if (locals.field_status == 4)
        {
          this.Fey.set(this.Fez + 1L);
          this.FeA = this.Fey.longValue();
          ad.i("MicroMsg.BizTimeLineInfoStorage", "initGroupId id %d/%d, status %d", new Object[] { Long.valueOf(this.Fey.longValue()), Long.valueOf(this.Fez), Integer.valueOf(locals.field_status) });
          AppMethodBeat.o(124649);
        }
        else
        {
          this.Fey.set(this.Fez);
        }
      }
      finally {}
    }
  }
  
  private long eKb()
  {
    try
    {
      AppMethodBeat.i(124651);
      Cursor localCursor = this.gPa.a("select max(orderFlag) from BizTimeLineInfo", null, 2);
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
  
  static List<s> p(Cursor paramCursor)
  {
    AppMethodBeat.i(124635);
    LinkedList localLinkedList = new LinkedList();
    while (paramCursor.moveToNext())
    {
      s locals = new s();
      locals.convertFrom(paramCursor);
      localLinkedList.add(locals);
    }
    paramCursor.close();
    AppMethodBeat.o(124635);
    return localLinkedList;
  }
  
  private void wd(long paramLong)
  {
    try
    {
      AppMethodBeat.i(124646);
      this.Fez = Math.max(paramLong, this.Fez);
      AppMethodBeat.o(124646);
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public final List<s> Wp(int paramInt)
  {
    AppMethodBeat.i(124633);
    List localList = p(this.gPa.query("BizTimeLineInfo", null, null, null, null, null, "orderFlag DESC limit ".concat(String.valueOf(paramInt))));
    AppMethodBeat.o(124633);
    return localList;
  }
  
  public final void a(a parama)
  {
    AppMethodBeat.i(124621);
    if (this.Feu.dR(parama)) {
      this.Feu.doNotify();
    }
    AppMethodBeat.o(124621);
  }
  
  public final void a(c paramc)
  {
    AppMethodBeat.i(124623);
    this.Feu.remove(paramc);
    AppMethodBeat.o(124623);
  }
  
  public final void a(c paramc, Looper paramLooper)
  {
    AppMethodBeat.i(124622);
    this.Feu.a(paramc, paramLooper);
    AppMethodBeat.o(124622);
  }
  
  public final List<s> aF(int paramInt, long paramLong)
  {
    AppMethodBeat.i(124632);
    Object localObject = this.gPa;
    String str = "orderFlag DESC limit ".concat(String.valueOf(paramInt));
    localObject = p(((com.tencent.mm.storagebase.h)localObject).query("BizTimeLineInfo", null, "orderFlag<?", new String[] { String.valueOf(paramLong) }, null, null, str));
    AppMethodBeat.o(124632);
    return localObject;
  }
  
  public final void aHw(String paramString)
  {
    AppMethodBeat.i(124627);
    if (bt.isNullOrNil(paramString))
    {
      AppMethodBeat.o(124627);
      return;
    }
    if (((k)com.tencent.mm.kernel.g.ab(k.class)).apM().aHY(paramString).ZS()) {}
    for (int i = 1;; i = 0)
    {
      Object localObject = "update BizTimeLineInfo set placeTop = " + i + " where status > 4 and talker = '" + paramString + "'";
      this.gPa.execSQL("BizTimeLineInfo", (String)localObject);
      localObject = "update BizTimeLineInfo set placeTop = " + i + " where status < 4 and talker = '" + paramString + "'";
      this.gPa.execSQL("BizTimeLineInfo", (String)localObject);
      localObject = eJU();
      if ((localObject != null) && (paramString.equals(((s)localObject).field_talker)))
      {
        ((s)localObject).field_placeTop = i;
        super.updateNotify((com.tencent.mm.sdk.e.c)localObject, false, new String[] { "msgSvrId" });
      }
      paramString = new a();
      paramString.FeG = b.FeK;
      a(paramString);
      AppMethodBeat.o(124627);
      return;
    }
  }
  
  public final boolean agh(String paramString)
  {
    AppMethodBeat.i(124644);
    s locals = new s();
    locals.field_talker = paramString;
    boolean bool = super.delete(locals, false, new String[] { "talker" });
    paramString = new a();
    paramString.talker = locals.field_talker;
    paramString.mXB = locals;
    paramString.FeG = b.FeJ;
    a(paramString);
    AppMethodBeat.o(124644);
    return bool;
  }
  
  public final long eJJ()
  {
    try
    {
      AppMethodBeat.i(124647);
      long l = this.Fey.longValue();
      AppMethodBeat.o(124647);
      return l;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public final s eJU()
  {
    s locals = null;
    AppMethodBeat.i(124636);
    Cursor localCursor = this.gPa.a("SELECT * FROM BizTimeLineInfo order by orderFlag DESC limit 1", null, 0);
    if (localCursor.moveToFirst())
    {
      locals = new s();
      locals.convertFrom(localCursor);
    }
    localCursor.close();
    AppMethodBeat.o(124636);
    return locals;
  }
  
  public final void eJV()
  {
    AppMethodBeat.i(124640);
    s locals = eJU();
    if (locals == null)
    {
      AppMethodBeat.o(124640);
      return;
    }
    wa(locals.field_orderFlag);
    AppMethodBeat.o(124640);
  }
  
  public final int eJW()
  {
    AppMethodBeat.i(124642);
    s locals = eJU();
    if (locals == null)
    {
      AppMethodBeat.o(124642);
      return 0;
    }
    int i = wb(locals.field_orderFlag);
    AppMethodBeat.o(124642);
    return i;
  }
  
  public final long eJX()
  {
    try
    {
      long l = this.Fez;
      return l;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public final long eJY()
  {
    try
    {
      AppMethodBeat.i(124648);
      long l = this.Fey.incrementAndGet();
      AppMethodBeat.o(124648);
      return l;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public final int eKa()
  {
    int i = 0;
    AppMethodBeat.i(124650);
    Cursor localCursor = this.gPa.a("SELECT count(*) FROM BizTimeLineInfo", null, 0);
    if (localCursor.moveToFirst()) {
      i = localCursor.getInt(0);
    }
    localCursor.close();
    AppMethodBeat.o(124650);
    return i;
  }
  
  public final long eKc()
  {
    s locals = null;
    try
    {
      AppMethodBeat.i(124652);
      if (this.FeC.longValue() == -5000000L)
      {
        Cursor localCursor = this.gPa.a("SELECT * FROM BizTimeLineInfo where type=620757041 order by orderFlag DESC limit 1", null, 0);
        if (localCursor.moveToFirst())
        {
          locals = new s();
          locals.convertFrom(localCursor);
        }
        localCursor.close();
        if (locals != null) {
          this.FeC.set(locals.field_msgId);
        }
      }
      long l = this.FeC.incrementAndGet();
      AppMethodBeat.o(124652);
      return l;
    }
    finally {}
  }
  
  public final boolean gQ(final List<s> paramList)
  {
    AppMethodBeat.i(124628);
    if (bt.gL(paramList))
    {
      AppMethodBeat.o(124628);
      return false;
    }
    com.tencent.mm.co.g.fkM().h(new a() {});
    AppMethodBeat.o(124628);
    return true;
  }
  
  public final boolean j(s params)
  {
    AppMethodBeat.i(124625);
    boolean bool = super.insertNotify(params, false);
    wd(params.eJJ());
    a locala = new a();
    locala.talker = params.field_talker;
    locala.mXB = params;
    locala.FeG = b.FeI;
    a(locala);
    AppMethodBeat.o(124625);
    return bool;
  }
  
  public final boolean k(s params)
  {
    AppMethodBeat.i(124626);
    boolean bool = super.updateNotify(params, false, new String[] { "msgSvrId" });
    a locala = new a();
    locala.talker = params.field_talker;
    locala.mXB = params;
    locala.FeG = b.FeK;
    a(locala);
    AppMethodBeat.o(124626);
    return bool;
  }
  
  public final s vT(long paramLong)
  {
    AppMethodBeat.i(124629);
    s locals = J(paramLong, "orderFlag");
    AppMethodBeat.o(124629);
    return locals;
  }
  
  public final s vU(long paramLong)
  {
    AppMethodBeat.i(124630);
    s locals = J(paramLong, "msgId");
    AppMethodBeat.o(124630);
    return locals;
  }
  
  public final List<s> vV(long paramLong)
  {
    AppMethodBeat.i(191103);
    List localList = p(this.gPa.query("BizTimeLineInfo", null, "orderFlag>?", new String[] { String.valueOf(paramLong) }, null, null, "orderFlag DESC limit 5"));
    AppMethodBeat.o(191103);
    return localList;
  }
  
  public final List<s> vW(long paramLong)
  {
    AppMethodBeat.i(124634);
    List localList = p(this.gPa.query("BizTimeLineInfo", null, "orderFlag>=?", new String[] { String.valueOf(paramLong) }, null, null, "orderFlag DESC"));
    AppMethodBeat.o(124634);
    return localList;
  }
  
  public final s vX(long paramLong)
  {
    s locals = null;
    AppMethodBeat.i(124637);
    Object localObject = "SELECT * FROM BizTimeLineInfo where talkerId = " + paramLong + "  order by orderFlag DESC limit 1";
    localObject = this.gPa.a((String)localObject, null, 0);
    if (((Cursor)localObject).moveToFirst())
    {
      locals = new s();
      locals.convertFrom((Cursor)localObject);
    }
    ((Cursor)localObject).close();
    AppMethodBeat.o(124637);
    return locals;
  }
  
  public final void vY(long paramLong)
  {
    AppMethodBeat.i(124638);
    if (vZ(paramLong) > 2000)
    {
      localObject = vT(paramLong);
      if (localObject != null)
      {
        ((s)localObject).field_status = 4;
        k((s)localObject);
      }
      AppMethodBeat.o(124638);
      return;
    }
    long l1 = System.currentTimeMillis();
    long l2 = 0x0 & paramLong;
    Object localObject = "update BizTimeLineInfo set status = 4 where orderFlag >= " + l2 + " and status > 4";
    this.gPa.execSQL("BizTimeLineInfo", (String)localObject);
    localObject = "update BizTimeLineInfo set status = 4 where orderFlag >= " + l2 + " and status < 4";
    this.gPa.execSQL("BizTimeLineInfo", (String)localObject);
    ad.d("MicroMsg.BizTimeLineInfoStorage", "resetUnread cost %d", new Object[] { Long.valueOf(System.currentTimeMillis() - l1) });
    Fev.o(Long.valueOf(paramLong), Boolean.TRUE);
    AppMethodBeat.o(124638);
  }
  
  public final int vZ(long paramLong)
  {
    AppMethodBeat.i(124639);
    Object localObject = (Boolean)Fev.get(Long.valueOf(paramLong));
    if ((localObject != null) && (((Boolean)localObject).booleanValue()))
    {
      AppMethodBeat.o(124639);
      return 0;
    }
    long l1 = System.currentTimeMillis();
    long l2 = 0x0 & paramLong;
    localObject = "SELECT count(*) FROM BizTimeLineInfo where orderFlag >= " + l2 + " and status > 4";
    localObject = this.gPa.a((String)localObject, null, 0);
    if (((Cursor)localObject).moveToFirst()) {}
    for (int j = ((Cursor)localObject).getInt(0);; j = 0)
    {
      ((Cursor)localObject).close();
      localObject = "SELECT count(*) FROM BizTimeLineInfo where orderFlag >= " + l2 + " and status < 4";
      localObject = this.gPa.a((String)localObject, null, 0);
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
        Fev.o(Long.valueOf(paramLong), Boolean.TRUE);
      }
      ad.d("MicroMsg.BizTimeLineInfoStorage", "getUnread cost %d", new Object[] { Long.valueOf(System.currentTimeMillis() - l1) });
      AppMethodBeat.o(124639);
      return j;
    }
  }
  
  public final void wa(final long paramLong)
  {
    AppMethodBeat.i(124641);
    com.tencent.mm.co.g.fkM().h(new a() {}).b(new a() {});
    AppMethodBeat.o(124641);
  }
  
  public final int wb(long paramLong)
  {
    AppMethodBeat.i(124643);
    long l = System.currentTimeMillis();
    Object localObject = "SELECT count(*) FROM BizTimeLineInfo where orderFlag >= " + (0x0 & paramLong) + " and hasShow < 1 ";
    localObject = this.gPa.a((String)localObject, null, 0);
    if (((Cursor)localObject).moveToFirst()) {}
    for (int i = ((Cursor)localObject).getInt(0);; i = 0)
    {
      ad.d("MicroMsg.BizTimeLineInfoStorage", "getUnShowCount count = %d,cost = %d", new Object[] { Integer.valueOf(i), Long.valueOf(System.currentTimeMillis() - l) });
      ((Cursor)localObject).close();
      if (i > 2000)
      {
        if (this.FeA == this.Fey.longValue()) {
          eJY();
        }
        AppMethodBeat.o(124643);
        return 0;
      }
      AppMethodBeat.o(124643);
      return i;
    }
  }
  
  public final void wc(long paramLong)
  {
    AppMethodBeat.i(124645);
    Object localObject = new s();
    ((s)localObject).field_msgId = paramLong;
    super.delete((com.tencent.mm.sdk.e.c)localObject, false, new String[] { "msgId" });
    localObject = new a();
    ((a)localObject).FeG = b.FeJ;
    a((a)localObject);
    AppMethodBeat.o(124645);
  }
  
  public final s we(long paramLong)
  {
    s locals = null;
    AppMethodBeat.i(124653);
    Object localObject = "SELECT * FROM BizTimeLineInfo where type=620757041 and orderFlag > ".concat(String.valueOf(paramLong));
    localObject = this.gPa.a((String)localObject, null, 0);
    if (((Cursor)localObject).moveToFirst())
    {
      locals = new s();
      locals.convertFrom((Cursor)localObject);
    }
    ((Cursor)localObject).close();
    AppMethodBeat.o(124653);
    return locals;
  }
  
  public static final class a
  {
    public t.b FeG = t.b.FeI;
    public boolean FeH = false;
    public List<s> list;
    public s mXB;
    public String talker;
  }
  
  public static enum b
  {
    static
    {
      AppMethodBeat.i(124620);
      FeI = new b("INSERT", 0);
      FeJ = new b("DELETE", 1);
      FeK = new b("UPDATE", 2);
      FeL = new b("RE_SORT", 3);
      FeM = new b[] { FeI, FeJ, FeK, FeL };
      AppMethodBeat.o(124620);
    }
    
    private b() {}
  }
  
  public static abstract interface c
  {
    public abstract void a(Object paramObject, t.a parama);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.storage.t
 * JD-Core Version:    0.7.0.1
 */