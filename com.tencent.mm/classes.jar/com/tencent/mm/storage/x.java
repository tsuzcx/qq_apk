package com.tencent.mm.storage;

import android.database.Cursor;
import android.os.Looper;
import com.tencent.mars.smc.IDKey;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.e.j;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storagebase.h;
import com.tencent.mm.vending.c.a;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

public final class x
  extends j<w>
{
  public static final String[] INDEX_CREATE;
  public static final String[] Iot;
  private static final com.tencent.mm.b.f<Long, Boolean> Iov;
  public static final String[] SQL_CREATE;
  private long IoA;
  private final long IoB;
  private AtomicLong IoC;
  private final com.tencent.mm.sdk.e.l<c, a> Iou;
  public boolean Iow;
  private final long Iox;
  private AtomicLong Ioy;
  private long Ioz;
  public final h hHS;
  
  static
  {
    AppMethodBeat.i(124655);
    SQL_CREATE = new String[] { j.getCreateSQLs(w.info, "BizTimeLineInfo") };
    INDEX_CREATE = new String[] { "CREATE  INDEX IF NOT EXISTS msg_id_index ON BizTimeLineInfo ( msgId ) ", "CREATE  INDEX IF NOT EXISTS  has_show_talker_index ON BizTimeLineInfo ( hasShow,talker ) ", "CREATE  INDEX IF NOT EXISTS  has_show_place_top_index ON BizTimeLineInfo ( hasShow,placeTop ) ", "CREATE  INDEX IF NOT EXISTS  order_flag_place_top_index ON BizTimeLineInfo ( orderFlag,placeTop ) ", "CREATE  INDEX IF NOT EXISTS  talker_id_order_flag_index ON BizTimeLineInfo ( talkerId,orderFlag ) " };
    Iot = new String[] { "CREATE  INDEX IF NOT EXISTS  biz_status_talker_index ON BizTimeLineInfo ( status,talker ) ", "CREATE  INDEX IF NOT EXISTS  biz_msg_svr_id_index ON BizTimeLineInfo ( msgSvrId ) ", "CREATE  INDEX IF NOT EXISTS  biz_talker_index ON BizTimeLineInfo ( talker ) ", "CREATE  INDEX IF NOT EXISTS  order_flag_status_index ON BizTimeLineInfo ( orderFlag,status ) ", "CREATE  INDEX IF NOT EXISTS  order_flag_has_show_index ON BizTimeLineInfo ( orderFlag,hasShow ) ", "CREATE  INDEX IF NOT EXISTS  biz_client_msg_id_index ON BizTimeLineInfo ( bizClientMsgId ) ", "CREATE  INDEX IF NOT EXISTS  is_read_order_flag_index ON BizTimeLineInfo ( isRead,orderFlag ) ", "CREATE  INDEX IF NOT EXISTS  biz_type_order_flag_index ON BizTimeLineInfo ( type,orderFlag ) ", "CREATE  INDEX IF NOT EXISTS  biz_create_time_index ON BizTimeLineInfo ( createTime ) " };
    Iov = new com.tencent.mm.memory.a.c(30);
    AppMethodBeat.o(124655);
  }
  
  public x(h paramh)
  {
    super(paramh, w.info, "BizTimeLineInfo", INDEX_CREATE);
    AppMethodBeat.i(124624);
    this.Iou = new com.tencent.mm.sdk.e.l() {};
    this.Iow = true;
    this.Iox = 10L;
    this.Ioy = new AtomicLong(10L);
    this.Ioz = 10L;
    this.IoB = -5000000L;
    this.IoC = new AtomicLong(-5000000L);
    this.hHS = paramh;
    fpv();
    AppMethodBeat.o(124624);
  }
  
  private void Dw(long paramLong)
  {
    try
    {
      AppMethodBeat.i(124646);
      this.Ioz = Math.max(paramLong, this.Ioz);
      AppMethodBeat.o(124646);
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  private void fpv()
  {
    for (;;)
    {
      try
      {
        AppMethodBeat.i(124649);
        this.Ioz = (fpx() >> 32);
        if (this.Ioz < 10L) {
          this.Ioz = 10L;
        }
        w localw = fpq();
        if (localw == null)
        {
          ad.w("MicroMsg.BizTimeLineInfoStorage", "initGroupId is null, id %d", new Object[] { Long.valueOf(this.Ioz) });
          AppMethodBeat.o(124649);
          return;
        }
        if (localw.field_status == 4)
        {
          this.Ioy.set(this.Ioz + 1L);
          this.IoA = this.Ioy.longValue();
          ad.i("MicroMsg.BizTimeLineInfoStorage", "initGroupId id %d/%d, status %d", new Object[] { Long.valueOf(this.Ioy.longValue()), Long.valueOf(this.Ioz), Integer.valueOf(localw.field_status) });
          AppMethodBeat.o(124649);
        }
        else
        {
          this.Ioy.set(this.Ioz);
        }
      }
      finally {}
    }
  }
  
  private long fpx()
  {
    try
    {
      AppMethodBeat.i(124651);
      Cursor localCursor = this.hHS.a("select max(orderFlag) from BizTimeLineInfo", null, 2);
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
  
  static List<w> o(Cursor paramCursor)
  {
    AppMethodBeat.i(124635);
    LinkedList localLinkedList = new LinkedList();
    while (paramCursor.moveToNext())
    {
      w localw = new w();
      localw.convertFrom(paramCursor);
      localLinkedList.add(localw);
    }
    paramCursor.close();
    AppMethodBeat.o(124635);
    return localLinkedList;
  }
  
  public final w Dm(long paramLong)
  {
    AppMethodBeat.i(124629);
    w localw = M(paramLong, "orderFlag");
    AppMethodBeat.o(124629);
    return localw;
  }
  
  public final w Dn(long paramLong)
  {
    AppMethodBeat.i(221609);
    w localw = M(paramLong, "msgId");
    AppMethodBeat.o(221609);
    return localw;
  }
  
  public final List<w> Do(long paramLong)
  {
    AppMethodBeat.i(207275);
    List localList = o(this.hHS.query("BizTimeLineInfo", null, "orderFlag>?", new String[] { String.valueOf(paramLong) }, null, null, "orderFlag DESC limit 5"));
    AppMethodBeat.o(207275);
    return localList;
  }
  
  public final List<w> Dp(long paramLong)
  {
    AppMethodBeat.i(124634);
    List localList = o(this.hHS.query("BizTimeLineInfo", null, "orderFlag>=?", new String[] { String.valueOf(paramLong) }, null, null, "orderFlag DESC"));
    AppMethodBeat.o(124634);
    return localList;
  }
  
  public final w Dq(long paramLong)
  {
    w localw = null;
    AppMethodBeat.i(124637);
    Object localObject = "SELECT * FROM BizTimeLineInfo where talkerId = " + paramLong + "  order by orderFlag DESC limit 1";
    localObject = this.hHS.a((String)localObject, null, 0);
    if (((Cursor)localObject).moveToFirst())
    {
      localw = new w();
      localw.convertFrom((Cursor)localObject);
    }
    ((Cursor)localObject).close();
    AppMethodBeat.o(124637);
    return localw;
  }
  
  public final void Dr(long paramLong)
  {
    AppMethodBeat.i(124638);
    if (Ds(paramLong) > 2000)
    {
      localObject = Dm(paramLong);
      if (localObject != null)
      {
        ((w)localObject).field_status = 4;
        p((w)localObject);
      }
      AppMethodBeat.o(124638);
      return;
    }
    long l1 = System.currentTimeMillis();
    long l2 = 0x0 & paramLong;
    Object localObject = "update BizTimeLineInfo set status = 4 where orderFlag >= " + l2 + " and status > 4";
    this.hHS.execSQL("BizTimeLineInfo", (String)localObject);
    localObject = "update BizTimeLineInfo set status = 4 where orderFlag >= " + l2 + " and status < 4";
    this.hHS.execSQL("BizTimeLineInfo", (String)localObject);
    ad.d("MicroMsg.BizTimeLineInfoStorage", "resetUnread cost %d", new Object[] { Long.valueOf(System.currentTimeMillis() - l1) });
    Iov.q(Long.valueOf(paramLong), Boolean.TRUE);
    AppMethodBeat.o(124638);
  }
  
  public final int Ds(long paramLong)
  {
    AppMethodBeat.i(124639);
    Object localObject = (Boolean)Iov.get(Long.valueOf(paramLong));
    if ((localObject != null) && (((Boolean)localObject).booleanValue()))
    {
      AppMethodBeat.o(124639);
      return 0;
    }
    long l1 = System.currentTimeMillis();
    long l2 = 0x0 & paramLong;
    localObject = "SELECT count(*) FROM BizTimeLineInfo where orderFlag >= " + l2 + " and status > 4";
    localObject = this.hHS.a((String)localObject, null, 0);
    if (((Cursor)localObject).moveToFirst()) {}
    for (int j = ((Cursor)localObject).getInt(0);; j = 0)
    {
      ((Cursor)localObject).close();
      localObject = "SELECT count(*) FROM BizTimeLineInfo where orderFlag >= " + l2 + " and status < 4";
      localObject = this.hHS.a((String)localObject, null, 0);
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
        Iov.q(Long.valueOf(paramLong), Boolean.TRUE);
      }
      ad.d("MicroMsg.BizTimeLineInfoStorage", "getUnread cost %d", new Object[] { Long.valueOf(System.currentTimeMillis() - l1) });
      AppMethodBeat.o(124639);
      return j;
    }
  }
  
  public final void Dt(final long paramLong)
  {
    AppMethodBeat.i(124641);
    com.tencent.mm.cn.g.fSm().h(new a() {}).b(new a() {});
    AppMethodBeat.o(124641);
  }
  
  public final int Du(long paramLong)
  {
    AppMethodBeat.i(124643);
    long l = System.currentTimeMillis();
    Object localObject = "SELECT count(*) FROM BizTimeLineInfo where orderFlag >= " + (0x0 & paramLong) + " and hasShow < 1 ";
    localObject = this.hHS.a((String)localObject, null, 0);
    if (((Cursor)localObject).moveToFirst()) {}
    for (int i = ((Cursor)localObject).getInt(0);; i = 0)
    {
      ad.d("MicroMsg.BizTimeLineInfoStorage", "getUnShowCount count = %d,cost = %d", new Object[] { Integer.valueOf(i), Long.valueOf(System.currentTimeMillis() - l) });
      ((Cursor)localObject).close();
      if (i > 2000)
      {
        if (this.IoA == this.Ioy.longValue()) {
          fpu();
        }
        AppMethodBeat.o(124643);
        return 0;
      }
      AppMethodBeat.o(124643);
      return i;
    }
  }
  
  public final void Dv(long paramLong)
  {
    AppMethodBeat.i(124645);
    Object localObject = new w();
    ((w)localObject).field_msgId = paramLong;
    super.delete((com.tencent.mm.sdk.e.c)localObject, false, new String[] { "msgId" });
    localObject = new a();
    ((a)localObject).IoG = b.IoJ;
    a((a)localObject);
    AppMethodBeat.o(124645);
  }
  
  public final w Dx(long paramLong)
  {
    w localw = null;
    AppMethodBeat.i(124653);
    Object localObject = "SELECT * FROM BizTimeLineInfo where type=620757041 and orderFlag > ".concat(String.valueOf(paramLong));
    localObject = this.hHS.a((String)localObject, null, 0);
    if (((Cursor)localObject).moveToFirst())
    {
      localw = new w();
      localw.convertFrom((Cursor)localObject);
    }
    ((Cursor)localObject).close();
    AppMethodBeat.o(124653);
    return localw;
  }
  
  public final w M(long paramLong, String paramString)
  {
    AppMethodBeat.i(124631);
    w localw = new w();
    paramString = this.hHS.a("BizTimeLineInfo", null, paramString + "=?", new String[] { String.valueOf(paramLong) }, null, null, null, 2);
    if (paramString.moveToFirst())
    {
      localw.convertFrom(paramString);
      paramString.close();
      AppMethodBeat.o(124631);
      return localw;
    }
    paramString.close();
    AppMethodBeat.o(124631);
    return null;
  }
  
  public final void a(a parama)
  {
    AppMethodBeat.i(124621);
    if (this.Iou.dV(parama)) {
      this.Iou.doNotify();
    }
    AppMethodBeat.o(124621);
  }
  
  public final void a(c paramc)
  {
    AppMethodBeat.i(124623);
    this.Iou.remove(paramc);
    AppMethodBeat.o(124623);
  }
  
  public final void a(c paramc, Looper paramLooper)
  {
    AppMethodBeat.i(124622);
    this.Iou.a(paramc, paramLooper);
    AppMethodBeat.o(124622);
  }
  
  public final List<w> aP(int paramInt, long paramLong)
  {
    AppMethodBeat.i(124632);
    Object localObject = this.hHS;
    String str = "orderFlag DESC limit ".concat(String.valueOf(paramInt));
    localObject = o(((h)localObject).query("BizTimeLineInfo", null, "orderFlag<?", new String[] { String.valueOf(paramLong) }, null, null, str));
    AppMethodBeat.o(124632);
    return localObject;
  }
  
  public final void aSD(String paramString)
  {
    AppMethodBeat.i(124627);
    if (bt.isNullOrNil(paramString))
    {
      AppMethodBeat.o(124627);
      return;
    }
    if (((com.tencent.mm.plugin.messenger.foundation.a.l)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.l.class)).azp().Bf(paramString).adq()) {}
    for (int i = 1;; i = 0)
    {
      Object localObject = "update BizTimeLineInfo set placeTop = " + i + " where status > 4 and talker = '" + paramString + "'";
      this.hHS.execSQL("BizTimeLineInfo", (String)localObject);
      localObject = "update BizTimeLineInfo set placeTop = " + i + " where status < 4 and talker = '" + paramString + "'";
      this.hHS.execSQL("BizTimeLineInfo", (String)localObject);
      localObject = fpq();
      if ((localObject != null) && (paramString.equals(((w)localObject).field_talker)))
      {
        ((w)localObject).field_placeTop = i;
        super.updateNotify((com.tencent.mm.sdk.e.c)localObject, false, new String[] { "msgSvrId" });
      }
      paramString = new a();
      paramString.IoG = b.IoK;
      a(paramString);
      AppMethodBeat.o(124627);
      return;
    }
  }
  
  public final List<w> aaG(int paramInt)
  {
    AppMethodBeat.i(124633);
    List localList = o(this.hHS.query("BizTimeLineInfo", null, null, null, null, null, "orderFlag DESC limit ".concat(String.valueOf(paramInt))));
    AppMethodBeat.o(124633);
    return localList;
  }
  
  public final List<w> aaH(int paramInt)
  {
    AppMethodBeat.i(207276);
    List localList = o(this.hHS.query("BizTimeLineInfo", null, "type=?", new String[] { String.valueOf(paramInt) }, null, null, "orderFlag DESC limit 1"));
    AppMethodBeat.o(207276);
    return localList;
  }
  
  public final w aaI(int paramInt)
  {
    Object localObject3 = null;
    AppMethodBeat.i(207277);
    Object localObject1 = "SELECT * FROM BizTimeLineInfo order by orderFlag DESC limit 1 offset ".concat(String.valueOf(paramInt));
    Object localObject2 = this.hHS.a((String)localObject1, null, 0);
    if (((Cursor)localObject2).moveToFirst())
    {
      localObject1 = new w();
      ((w)localObject1).convertFrom((Cursor)localObject2);
    }
    for (;;)
    {
      ((Cursor)localObject2).close();
      if (localObject1 != null)
      {
        localObject2 = localObject1;
        if (((w)localObject1).fpb() >= fpt()) {}
      }
      else
      {
        long l = fpt();
        localObject1 = "SELECT * FROM BizTimeLineInfo where orderFlag > " + (l << 32) + " order by orderFlag asc limit 1";
        localObject2 = this.hHS.a((String)localObject1, null, 0);
        localObject1 = localObject3;
        if (((Cursor)localObject2).moveToFirst())
        {
          localObject1 = new w();
          ((w)localObject1).convertFrom((Cursor)localObject2);
        }
        ((Cursor)localObject2).close();
        localObject2 = localObject1;
      }
      AppMethodBeat.o(207277);
      return localObject2;
      localObject1 = null;
    }
  }
  
  public final boolean apN(String paramString)
  {
    AppMethodBeat.i(124644);
    w localw = new w();
    localw.field_talker = paramString;
    boolean bool = super.delete(localw, false, new String[] { "talker" });
    paramString = new a();
    paramString.talker = localw.field_talker;
    paramString.obf = localw;
    paramString.IoG = b.IoJ;
    a(paramString);
    AppMethodBeat.o(124644);
    return bool;
  }
  
  public final long fpb()
  {
    try
    {
      AppMethodBeat.i(124647);
      long l = this.Ioy.longValue();
      AppMethodBeat.o(124647);
      return l;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public final w fpq()
  {
    w localw = null;
    AppMethodBeat.i(124636);
    Cursor localCursor = this.hHS.a("SELECT * FROM BizTimeLineInfo order by orderFlag DESC limit 1", null, 0);
    if (localCursor.moveToFirst())
    {
      localw = new w();
      localw.convertFrom(localCursor);
    }
    localCursor.close();
    AppMethodBeat.o(124636);
    return localw;
  }
  
  public final void fpr()
  {
    AppMethodBeat.i(124640);
    w localw = fpq();
    if (localw == null)
    {
      AppMethodBeat.o(124640);
      return;
    }
    Dt(localw.field_orderFlag);
    AppMethodBeat.o(124640);
  }
  
  public final int fps()
  {
    AppMethodBeat.i(124642);
    w localw = fpq();
    if (localw == null)
    {
      AppMethodBeat.o(124642);
      return 0;
    }
    int i = Du(localw.field_orderFlag);
    AppMethodBeat.o(124642);
    return i;
  }
  
  public final long fpt()
  {
    try
    {
      long l = this.Ioz;
      return l;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public final long fpu()
  {
    try
    {
      AppMethodBeat.i(124648);
      long l = this.Ioy.incrementAndGet();
      AppMethodBeat.o(124648);
      return l;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public final int fpw()
  {
    int i = 0;
    AppMethodBeat.i(124650);
    Cursor localCursor = this.hHS.a("SELECT count(*) FROM BizTimeLineInfo", null, 0);
    if (localCursor.moveToFirst()) {
      i = localCursor.getInt(0);
    }
    localCursor.close();
    AppMethodBeat.o(124650);
    return i;
  }
  
  public final long fpy()
  {
    w localw = null;
    try
    {
      AppMethodBeat.i(124652);
      if (this.IoC.longValue() == -5000000L)
      {
        Cursor localCursor = this.hHS.a("SELECT * FROM BizTimeLineInfo where type=620757041 or type=637534257 order by msgId DESC limit 1", null, 0);
        if (localCursor.moveToFirst())
        {
          localw = new w();
          localw.convertFrom(localCursor);
        }
        localCursor.close();
        if (localw != null) {
          this.IoC.set(localw.field_msgId);
        }
      }
      long l = this.IoC.incrementAndGet();
      AppMethodBeat.o(124652);
      return l;
    }
    finally {}
  }
  
  public final boolean hp(final List<w> paramList)
  {
    AppMethodBeat.i(124628);
    if (bt.hj(paramList))
    {
      AppMethodBeat.o(124628);
      return false;
    }
    com.tencent.mm.cn.g.fSm().h(new a() {});
    AppMethodBeat.o(124628);
    return true;
  }
  
  public final boolean o(w paramw)
  {
    AppMethodBeat.i(124625);
    boolean bool = super.insertNotify(paramw, false);
    Dw(paramw.fpb());
    a locala = new a();
    locala.talker = paramw.field_talker;
    locala.obf = paramw;
    locala.IoG = b.IoI;
    a(locala);
    AppMethodBeat.o(124625);
    return bool;
  }
  
  public final boolean p(w paramw)
  {
    AppMethodBeat.i(124626);
    boolean bool = super.updateNotify(paramw, false, new String[] { "msgSvrId" });
    a locala = new a();
    locala.talker = paramw.field_talker;
    locala.obf = paramw;
    locala.IoG = b.IoK;
    a(locala);
    AppMethodBeat.o(124626);
    return bool;
  }
  
  public final boolean q(w paramw)
  {
    AppMethodBeat.i(207273);
    boolean bool = super.updateNotify(paramw, false, new String[] { "msgId" });
    AppMethodBeat.o(207273);
    return bool;
  }
  
  public static final class a
  {
    public x.b IoG = x.b.IoI;
    public boolean IoH = false;
    public List<w> list;
    public w obf;
    public String talker;
  }
  
  public static enum b
  {
    static
    {
      AppMethodBeat.i(124620);
      IoI = new b("INSERT", 0);
      IoJ = new b("DELETE", 1);
      IoK = new b("UPDATE", 2);
      IoL = new b("RE_SORT", 3);
      IoM = new b[] { IoI, IoJ, IoK, IoL };
      AppMethodBeat.o(124620);
    }
    
    private b() {}
  }
  
  public static abstract interface c
  {
    public abstract void a(Object paramObject, x.a parama);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.storage.x
 * JD-Core Version:    0.7.0.1
 */