package com.tencent.mm.storage;

import android.database.Cursor;
import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cg.h;
import com.tencent.mm.sdk.e.l;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

public final class r
  extends com.tencent.mm.sdk.e.j<q>
{
  public static final String[] INDEX_CREATE;
  public static final String[] SQL_CREATE;
  public static final String[] ywC;
  private static final com.tencent.mm.a.f<Long, Boolean> ywE;
  public final h fnw;
  private final l<c, r.a> ywD;
  public boolean ywF;
  private final long ywG;
  private AtomicLong ywH;
  private long ywI;
  private long ywJ;
  
  static
  {
    AppMethodBeat.i(11893);
    SQL_CREATE = new String[] { com.tencent.mm.sdk.e.j.getCreateSQLs(q.info, "BizTimeLineInfo") };
    INDEX_CREATE = new String[] { "CREATE  INDEX IF NOT EXISTS msg_svr_id_index ON BizTimeLineInfo ( msgSvrId ) ", "CREATE  INDEX IF NOT EXISTS msg_id_index ON BizTimeLineInfo ( msgId ) ", "CREATE  INDEX IF NOT EXISTS talker_index ON BizTimeLineInfo ( talker ) ", "CREATE  INDEX IF NOT EXISTS  order_flag_index ON BizTimeLineInfo ( orderFlag ) ", "CREATE  INDEX IF NOT EXISTS  has_show_talker_index ON BizTimeLineInfo ( hasShow,talker ) ", "CREATE  INDEX IF NOT EXISTS  status_talker_index ON BizTimeLineInfo ( status,talker ) ", "CREATE  INDEX IF NOT EXISTS  has_show_place_top_index ON BizTimeLineInfo ( hasShow,placeTop ) ", "CREATE  INDEX IF NOT EXISTS  order_flag_place_top_index ON BizTimeLineInfo ( orderFlag,placeTop ) ", "CREATE  INDEX IF NOT EXISTS  talker_id_order_flag_index ON BizTimeLineInfo ( talkerId,orderFlag ) " };
    ywC = new String[] { "CREATE  INDEX IF NOT EXISTS  order_flag_status_index ON BizTimeLineInfo ( orderFlag,status ) ", "CREATE  INDEX IF NOT EXISTS  order_flag_has_show_index ON BizTimeLineInfo ( orderFlag,hasShow ) " };
    ywE = new com.tencent.mm.memory.a.c(3);
    AppMethodBeat.o(11893);
  }
  
  public r(h paramh)
  {
    super(paramh, q.info, "BizTimeLineInfo", INDEX_CREATE);
    AppMethodBeat.i(11867);
    this.ywD = new r.1(this);
    this.ywF = true;
    this.ywG = 10L;
    this.ywH = new AtomicLong(10L);
    this.ywI = 10L;
    this.fnw = paramh;
    dwh();
    AppMethodBeat.o(11867);
  }
  
  private void dwh()
  {
    for (;;)
    {
      try
      {
        AppMethodBeat.i(11890);
        this.ywI = (dwj() >> 32);
        if (this.ywI < 10L) {
          this.ywI = 10L;
        }
        q localq = dwc();
        if (localq == null)
        {
          ab.w("MicroMsg.BizTimeLineInfoStorage", "initGroupId is null, id %d", new Object[] { Long.valueOf(this.ywI) });
          AppMethodBeat.o(11890);
          return;
        }
        if (localq.field_status == 4)
        {
          this.ywH.set(this.ywI + 1L);
          this.ywJ = this.ywH.longValue();
          ab.i("MicroMsg.BizTimeLineInfoStorage", "initGroupId id %d/%d, status %d", new Object[] { Long.valueOf(this.ywH.longValue()), Long.valueOf(this.ywI), Integer.valueOf(localq.field_status) });
          AppMethodBeat.o(11890);
        }
        else
        {
          this.ywH.set(this.ywI);
        }
      }
      finally {}
    }
  }
  
  private long dwj()
  {
    try
    {
      AppMethodBeat.i(11891);
      Cursor localCursor = this.fnw.a("select max(orderFlag) from BizTimeLineInfo", null, 2);
      long l = 0L;
      if (localCursor.moveToFirst())
      {
        l = localCursor.getLong(0);
        localCursor.close();
      }
      AppMethodBeat.o(11891);
      return l;
    }
    finally {}
  }
  
  public static List<q> n(Cursor paramCursor)
  {
    AppMethodBeat.i(11876);
    LinkedList localLinkedList = new LinkedList();
    while (paramCursor.moveToNext())
    {
      q localq = new q();
      localq.convertFrom(paramCursor);
      localLinkedList.add(localq);
    }
    paramCursor.close();
    AppMethodBeat.o(11876);
    return localLinkedList;
  }
  
  private void oh(long paramLong)
  {
    try
    {
      AppMethodBeat.i(11887);
      this.ywI = Math.max(paramLong, this.ywI);
      AppMethodBeat.o(11887);
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public final q C(long paramLong, String paramString)
  {
    AppMethodBeat.i(11872);
    q localq = new q();
    paramString = this.fnw.a("BizTimeLineInfo", null, paramString + "=?", new String[] { String.valueOf(paramLong) }, null, null, null, 2);
    if (paramString.moveToFirst())
    {
      localq.convertFrom(paramString);
      paramString.close();
      AppMethodBeat.o(11872);
      return localq;
    }
    paramString.close();
    AppMethodBeat.o(11872);
    return null;
  }
  
  public final boolean Td(String paramString)
  {
    AppMethodBeat.i(11885);
    q localq = new q();
    localq.field_talker = paramString;
    boolean bool = super.delete(localq, false, new String[] { "talker" });
    paramString = new r.a();
    paramString.talker = localq.field_talker;
    paramString.jWv = localq;
    paramString.ywM = r.b.ywP;
    a(paramString);
    AppMethodBeat.o(11885);
    return bool;
  }
  
  public final void a(r.a parama)
  {
    AppMethodBeat.i(11864);
    if (this.ywD.cy(parama)) {
      this.ywD.doNotify();
    }
    AppMethodBeat.o(11864);
  }
  
  public final void a(c paramc)
  {
    AppMethodBeat.i(11866);
    this.ywD.remove(paramc);
    AppMethodBeat.o(11866);
  }
  
  public final void a(c paramc, Looper paramLooper)
  {
    AppMethodBeat.i(11865);
    this.ywD.a(paramc, paramLooper);
    AppMethodBeat.o(11865);
  }
  
  public final List<q> al(int paramInt, long paramLong)
  {
    AppMethodBeat.i(11873);
    Object localObject = this.fnw;
    String str = "orderFlag DESC limit ".concat(String.valueOf(paramInt));
    localObject = n(((h)localObject).query("BizTimeLineInfo", null, "orderFlag<?", new String[] { String.valueOf(paramLong) }, null, null, str));
    AppMethodBeat.o(11873);
    return localObject;
  }
  
  public final void aqT(String paramString)
  {
    AppMethodBeat.i(11870);
    if (bo.isNullOrNil(paramString))
    {
      AppMethodBeat.o(11870);
      return;
    }
    if (((com.tencent.mm.plugin.messenger.foundation.a.j)com.tencent.mm.kernel.g.E(com.tencent.mm.plugin.messenger.foundation.a.j.class)).YA().arw(paramString).Oa()) {}
    for (int i = 1;; i = 0)
    {
      Object localObject = "update BizTimeLineInfo set placeTop = " + i + " where status > 4 and talker = '" + paramString + "'";
      this.fnw.execSQL("BizTimeLineInfo", (String)localObject);
      localObject = "update BizTimeLineInfo set placeTop = " + i + " where status < 4 and talker = '" + paramString + "'";
      this.fnw.execSQL("BizTimeLineInfo", (String)localObject);
      localObject = dwc();
      if ((localObject != null) && (paramString.equals(((q)localObject).field_talker)))
      {
        ((q)localObject).field_placeTop = i;
        super.updateNotify((com.tencent.mm.sdk.e.c)localObject, false, new String[] { "msgSvrId" });
      }
      paramString = new r.a();
      paramString.ywM = r.b.ywQ;
      a(paramString);
      AppMethodBeat.o(11870);
      return;
    }
  }
  
  public final long dvU()
  {
    try
    {
      AppMethodBeat.i(11888);
      long l = this.ywH.longValue();
      AppMethodBeat.o(11888);
      return l;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public final List<q> dwb()
  {
    AppMethodBeat.i(11874);
    List localList = n(this.fnw.query("BizTimeLineInfo", null, null, null, null, null, "orderFlag DESC limit 10"));
    AppMethodBeat.o(11874);
    return localList;
  }
  
  public final q dwc()
  {
    q localq = null;
    AppMethodBeat.i(11877);
    Cursor localCursor = this.fnw.a("SELECT * FROM BizTimeLineInfo order by orderFlag DESC limit 1", null, 0);
    if (localCursor.moveToFirst())
    {
      localq = new q();
      localq.convertFrom(localCursor);
    }
    localCursor.close();
    AppMethodBeat.o(11877);
    return localq;
  }
  
  public final q dwd()
  {
    q localq = null;
    AppMethodBeat.i(11879);
    Cursor localCursor = this.fnw.a("SELECT * FROM BizTimeLineInfo order by orderFlag asc limit 1", null, 0);
    if (localCursor.moveToFirst())
    {
      localq = new q();
      localq.convertFrom(localCursor);
    }
    localCursor.close();
    AppMethodBeat.o(11879);
    return localq;
  }
  
  public final void dwe()
  {
    AppMethodBeat.i(11882);
    q localq = dwc();
    if (localq == null)
    {
      AppMethodBeat.o(11882);
      return;
    }
    oe(localq.field_orderFlag);
    AppMethodBeat.o(11882);
  }
  
  public final long dwf()
  {
    try
    {
      long l = this.ywI;
      return l;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public final long dwg()
  {
    try
    {
      AppMethodBeat.i(11889);
      long l = this.ywH.incrementAndGet();
      AppMethodBeat.o(11889);
      return l;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public final int dwi()
  {
    int i = 0;
    AppMethodBeat.i(151390);
    Cursor localCursor = this.fnw.a("SELECT count(*) FROM BizTimeLineInfo", null, 0);
    if (localCursor.moveToFirst()) {
      i = localCursor.getInt(0);
    }
    localCursor.close();
    AppMethodBeat.o(151390);
    return i;
  }
  
  public final boolean ew(List<q> paramList)
  {
    AppMethodBeat.i(11871);
    if (bo.es(paramList))
    {
      AppMethodBeat.o(11871);
      return false;
    }
    com.tencent.mm.cm.g.dTg().h(new r.4(this, paramList));
    AppMethodBeat.o(11871);
    return true;
  }
  
  public final boolean h(q paramq)
  {
    AppMethodBeat.i(11868);
    boolean bool = super.insertNotify(paramq, false);
    oh(paramq.dvU());
    r.a locala = new r.a();
    locala.talker = paramq.field_talker;
    locala.jWv = paramq;
    locala.ywM = r.b.ywO;
    a(locala);
    AppMethodBeat.o(11868);
    return bool;
  }
  
  public final boolean i(q paramq)
  {
    AppMethodBeat.i(11869);
    boolean bool = super.updateNotify(paramq, false, new String[] { "msgSvrId" });
    r.a locala = new r.a();
    locala.talker = paramq.field_talker;
    locala.jWv = paramq;
    locala.ywM = r.b.ywQ;
    a(locala);
    AppMethodBeat.o(11869);
    return bool;
  }
  
  public final List<q> oa(long paramLong)
  {
    AppMethodBeat.i(11875);
    List localList = n(this.fnw.query("BizTimeLineInfo", null, "orderFlag>=?", new String[] { String.valueOf(paramLong) }, null, null, "orderFlag DESC"));
    AppMethodBeat.o(11875);
    return localList;
  }
  
  public final q ob(long paramLong)
  {
    q localq = null;
    AppMethodBeat.i(11878);
    Object localObject = "SELECT * FROM BizTimeLineInfo where talkerId = " + paramLong + "  order by orderFlag DESC limit 1";
    localObject = this.fnw.a((String)localObject, null, 0);
    if (((Cursor)localObject).moveToFirst())
    {
      localq = new q();
      localq.convertFrom((Cursor)localObject);
    }
    ((Cursor)localObject).close();
    AppMethodBeat.o(11878);
    return localq;
  }
  
  public final void oc(long paramLong)
  {
    AppMethodBeat.i(11880);
    if (od(paramLong) > 2000)
    {
      localObject = C(paramLong, "orderFlag");
      if (localObject != null)
      {
        ((q)localObject).field_status = 4;
        i((q)localObject);
      }
      AppMethodBeat.o(11880);
      return;
    }
    long l1 = System.currentTimeMillis();
    long l2 = 0x0 & paramLong;
    Object localObject = "update BizTimeLineInfo set status = 4 where orderFlag >= " + l2 + " and status > 4";
    this.fnw.execSQL("BizTimeLineInfo", (String)localObject);
    localObject = "update BizTimeLineInfo set status = 4 where orderFlag >= " + l2 + " and status < 4";
    this.fnw.execSQL("BizTimeLineInfo", (String)localObject);
    ab.d("MicroMsg.BizTimeLineInfoStorage", "resetUnread cost %d", new Object[] { Long.valueOf(System.currentTimeMillis() - l1) });
    ywE.f(Long.valueOf(paramLong), Boolean.TRUE);
    AppMethodBeat.o(11880);
  }
  
  public final int od(long paramLong)
  {
    AppMethodBeat.i(11881);
    Object localObject = (Boolean)ywE.get(Long.valueOf(paramLong));
    if ((localObject != null) && (((Boolean)localObject).booleanValue()))
    {
      AppMethodBeat.o(11881);
      return 0;
    }
    long l1 = System.currentTimeMillis();
    long l2 = 0x0 & paramLong;
    localObject = "SELECT count(*) FROM BizTimeLineInfo where orderFlag >= " + l2 + " and status > 4";
    localObject = this.fnw.a((String)localObject, null, 0);
    if (((Cursor)localObject).moveToFirst()) {}
    for (int j = ((Cursor)localObject).getInt(0);; j = 0)
    {
      ((Cursor)localObject).close();
      localObject = "SELECT count(*) FROM BizTimeLineInfo where orderFlag >= " + l2 + " and status < 4";
      localObject = this.fnw.a((String)localObject, null, 0);
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
        ywE.f(Long.valueOf(paramLong), Boolean.TRUE);
      }
      ab.d("MicroMsg.BizTimeLineInfoStorage", "getUnread cost %d", new Object[] { Long.valueOf(System.currentTimeMillis() - l1) });
      AppMethodBeat.o(11881);
      return j;
    }
  }
  
  public final void oe(long paramLong)
  {
    AppMethodBeat.i(11883);
    com.tencent.mm.cm.g.dTg().h(new r.6(this, paramLong)).b(new r.5(this));
    AppMethodBeat.o(11883);
  }
  
  public final int of(long paramLong)
  {
    AppMethodBeat.i(11884);
    long l = System.currentTimeMillis();
    Object localObject = "SELECT count(*) FROM BizTimeLineInfo where orderFlag >= " + (0x0 & paramLong) + " and hasShow < 1 ";
    localObject = this.fnw.a((String)localObject, null, 0);
    if (((Cursor)localObject).moveToFirst()) {}
    for (int i = ((Cursor)localObject).getInt(0);; i = 0)
    {
      ab.d("MicroMsg.BizTimeLineInfoStorage", "getUnShowCount count = %d,cost = %d", new Object[] { Integer.valueOf(i), Long.valueOf(System.currentTimeMillis() - l) });
      ((Cursor)localObject).close();
      if (i > 2000)
      {
        if (this.ywJ == this.ywH.longValue()) {
          dwg();
        }
        AppMethodBeat.o(11884);
        return 0;
      }
      AppMethodBeat.o(11884);
      return i;
    }
  }
  
  public final void og(long paramLong)
  {
    AppMethodBeat.i(11886);
    Object localObject = new q();
    ((q)localObject).field_msgId = paramLong;
    super.delete((com.tencent.mm.sdk.e.c)localObject, false, new String[] { "msgId" });
    localObject = new r.a();
    ((r.a)localObject).ywM = r.b.ywP;
    a((r.a)localObject);
    AppMethodBeat.o(11886);
  }
  
  public static abstract interface c
  {
    public abstract void a(Object paramObject, r.a parama);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.storage.r
 * JD-Core Version:    0.7.0.1
 */