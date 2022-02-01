package com.tencent.mm.storage;

import android.database.Cursor;
import android.os.Looper;
import com.tencent.mars.smc.IDKey;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.e.j;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.storagebase.h;
import com.tencent.mm.vending.c.a;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

public final class x
  extends j<w>
{
  public static final String[] IIJ;
  private static final com.tencent.mm.b.f<Long, Boolean> IIL;
  public static final String[] INDEX_CREATE;
  public static final String[] SQL_CREATE;
  private final com.tencent.mm.sdk.e.l<c, a> IIK;
  public boolean IIM;
  private final long IIN;
  private AtomicLong IIO;
  private long IIP;
  private long IIQ;
  private final long IIR;
  private AtomicLong IIS;
  public final h hKK;
  
  static
  {
    AppMethodBeat.i(124655);
    SQL_CREATE = new String[] { j.getCreateSQLs(w.info, "BizTimeLineInfo") };
    INDEX_CREATE = new String[] { "CREATE  INDEX IF NOT EXISTS msg_id_index ON BizTimeLineInfo ( msgId ) ", "CREATE  INDEX IF NOT EXISTS  has_show_talker_index ON BizTimeLineInfo ( hasShow,talker ) ", "CREATE  INDEX IF NOT EXISTS  has_show_place_top_index ON BizTimeLineInfo ( hasShow,placeTop ) ", "CREATE  INDEX IF NOT EXISTS  order_flag_place_top_index ON BizTimeLineInfo ( orderFlag,placeTop ) ", "CREATE  INDEX IF NOT EXISTS  talker_id_order_flag_index ON BizTimeLineInfo ( talkerId,orderFlag ) " };
    IIJ = new String[] { "CREATE  INDEX IF NOT EXISTS  biz_status_talker_index ON BizTimeLineInfo ( status,talker ) ", "CREATE  INDEX IF NOT EXISTS  biz_msg_svr_id_index ON BizTimeLineInfo ( msgSvrId ) ", "CREATE  INDEX IF NOT EXISTS  biz_talker_index ON BizTimeLineInfo ( talker ) ", "CREATE  INDEX IF NOT EXISTS  order_flag_status_index ON BizTimeLineInfo ( orderFlag,status ) ", "CREATE  INDEX IF NOT EXISTS  order_flag_has_show_index ON BizTimeLineInfo ( orderFlag,hasShow ) ", "CREATE  INDEX IF NOT EXISTS  biz_client_msg_id_index ON BizTimeLineInfo ( bizClientMsgId ) ", "CREATE  INDEX IF NOT EXISTS  is_read_order_flag_index ON BizTimeLineInfo ( isRead,orderFlag ) ", "CREATE  INDEX IF NOT EXISTS  biz_type_order_flag_index ON BizTimeLineInfo ( type,orderFlag ) ", "CREATE  INDEX IF NOT EXISTS  biz_type_is_read_index ON BizTimeLineInfo ( type,isRead ) ", "CREATE  INDEX IF NOT EXISTS  biz_create_time_index ON BizTimeLineInfo ( createTime ) ", "CREATE  INDEX IF NOT EXISTS  recommend_card_id_index ON BizTimeLineInfo ( recommendCardId ) " };
    IIL = new com.tencent.mm.memory.a.c(30);
    AppMethodBeat.o(124655);
  }
  
  public x(h paramh)
  {
    super(paramh, w.info, "BizTimeLineInfo", INDEX_CREATE);
    AppMethodBeat.i(124624);
    this.IIK = new com.tencent.mm.sdk.e.l() {};
    this.IIM = true;
    this.IIN = 10L;
    this.IIO = new AtomicLong(10L);
    this.IIP = 10L;
    this.IIR = -5000000L;
    this.IIS = new AtomicLong(-5000000L);
    this.hKK = paramh;
    ftu();
    AppMethodBeat.o(124624);
  }
  
  private void DV(long paramLong)
  {
    try
    {
      AppMethodBeat.i(124646);
      this.IIP = Math.max(paramLong, this.IIP);
      AppMethodBeat.o(124646);
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  private void ftu()
  {
    for (;;)
    {
      try
      {
        AppMethodBeat.i(124649);
        this.IIP = (ftw() >> 32);
        if (this.IIP < 10L) {
          this.IIP = 10L;
        }
        w localw = ftp();
        if (localw == null)
        {
          ae.w("MicroMsg.BizTimeLineInfoStorage", "initGroupId is null, id %d", new Object[] { Long.valueOf(this.IIP) });
          AppMethodBeat.o(124649);
          return;
        }
        if (localw.field_status == 4)
        {
          this.IIO.set(this.IIP + 1L);
          this.IIQ = this.IIO.longValue();
          ae.i("MicroMsg.BizTimeLineInfoStorage", "initGroupId id %d/%d, status %d", new Object[] { Long.valueOf(this.IIO.longValue()), Long.valueOf(this.IIP), Integer.valueOf(localw.field_status) });
          AppMethodBeat.o(124649);
        }
        else
        {
          this.IIO.set(this.IIP);
        }
      }
      finally {}
    }
  }
  
  private long ftw()
  {
    try
    {
      AppMethodBeat.i(124651);
      Cursor localCursor = this.hKK.a("select max(orderFlag) from BizTimeLineInfo", null, 2);
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
  
  public final w DL(long paramLong)
  {
    AppMethodBeat.i(124629);
    w localw = N(paramLong, "orderFlag");
    AppMethodBeat.o(124629);
    return localw;
  }
  
  public final w DM(long paramLong)
  {
    AppMethodBeat.i(224210);
    w localw = N(paramLong, "msgId");
    AppMethodBeat.o(224210);
    return localw;
  }
  
  public final List<w> DN(long paramLong)
  {
    AppMethodBeat.i(188976);
    List localList = o(this.hKK.query("BizTimeLineInfo", null, "orderFlag>?", new String[] { String.valueOf(paramLong) }, null, null, "orderFlag DESC limit 5"));
    AppMethodBeat.o(188976);
    return localList;
  }
  
  public final List<w> DO(long paramLong)
  {
    AppMethodBeat.i(124634);
    List localList = o(this.hKK.query("BizTimeLineInfo", null, "orderFlag>=?", new String[] { String.valueOf(paramLong) }, null, null, "orderFlag DESC"));
    AppMethodBeat.o(124634);
    return localList;
  }
  
  public final w DP(long paramLong)
  {
    w localw = null;
    AppMethodBeat.i(124637);
    Object localObject = "SELECT * FROM BizTimeLineInfo where talkerId = " + paramLong + "  order by orderFlag DESC limit 1";
    localObject = this.hKK.a((String)localObject, null, 0);
    if (((Cursor)localObject).moveToFirst())
    {
      localw = new w();
      localw.convertFrom((Cursor)localObject);
    }
    ((Cursor)localObject).close();
    AppMethodBeat.o(124637);
    return localw;
  }
  
  public final void DQ(long paramLong)
  {
    AppMethodBeat.i(124638);
    if (DR(paramLong) > 2000)
    {
      localObject = DL(paramLong);
      if (localObject != null)
      {
        ((w)localObject).field_status = 4;
        q((w)localObject);
      }
      AppMethodBeat.o(124638);
      return;
    }
    long l1 = System.currentTimeMillis();
    long l2 = 0x0 & paramLong;
    Object localObject = "update BizTimeLineInfo set status = 4 where orderFlag >= " + l2 + " and status > 4";
    this.hKK.execSQL("BizTimeLineInfo", (String)localObject);
    localObject = "update BizTimeLineInfo set status = 4 where orderFlag >= " + l2 + " and status < 4";
    this.hKK.execSQL("BizTimeLineInfo", (String)localObject);
    ae.d("MicroMsg.BizTimeLineInfoStorage", "resetUnread cost %d", new Object[] { Long.valueOf(System.currentTimeMillis() - l1) });
    IIL.q(Long.valueOf(paramLong), Boolean.TRUE);
    AppMethodBeat.o(124638);
  }
  
  public final int DR(long paramLong)
  {
    AppMethodBeat.i(124639);
    Object localObject = (Boolean)IIL.get(Long.valueOf(paramLong));
    if ((localObject != null) && (((Boolean)localObject).booleanValue()))
    {
      AppMethodBeat.o(124639);
      return 0;
    }
    long l1 = System.currentTimeMillis();
    long l2 = 0x0 & paramLong;
    localObject = "SELECT count(*) FROM BizTimeLineInfo where orderFlag >= " + l2 + " and status > 4";
    localObject = this.hKK.a((String)localObject, null, 0);
    if (((Cursor)localObject).moveToFirst()) {}
    for (int j = ((Cursor)localObject).getInt(0);; j = 0)
    {
      ((Cursor)localObject).close();
      localObject = "SELECT count(*) FROM BizTimeLineInfo where orderFlag >= " + l2 + " and status < 4";
      localObject = this.hKK.a((String)localObject, null, 0);
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
        IIL.q(Long.valueOf(paramLong), Boolean.TRUE);
      }
      ae.d("MicroMsg.BizTimeLineInfoStorage", "getUnread cost %d", new Object[] { Long.valueOf(System.currentTimeMillis() - l1) });
      AppMethodBeat.o(124639);
      return j;
    }
  }
  
  public final void DS(final long paramLong)
  {
    AppMethodBeat.i(124641);
    com.tencent.mm.cm.g.fWL().h(new a() {}).b(new a() {});
    AppMethodBeat.o(124641);
  }
  
  public final int DT(long paramLong)
  {
    AppMethodBeat.i(124643);
    long l = System.currentTimeMillis();
    Object localObject = "SELECT count(*) FROM BizTimeLineInfo where orderFlag >= " + (0x0 & paramLong) + " and hasShow < 1 ";
    localObject = this.hKK.a((String)localObject, null, 0);
    if (((Cursor)localObject).moveToFirst()) {}
    for (int i = ((Cursor)localObject).getInt(0);; i = 0)
    {
      ae.d("MicroMsg.BizTimeLineInfoStorage", "getUnShowCount count = %d,cost = %d", new Object[] { Integer.valueOf(i), Long.valueOf(System.currentTimeMillis() - l) });
      ((Cursor)localObject).close();
      if (i > 2000)
      {
        if (this.IIQ == this.IIO.longValue()) {
          ftt();
        }
        AppMethodBeat.o(124643);
        return 0;
      }
      AppMethodBeat.o(124643);
      return i;
    }
  }
  
  public final void DU(long paramLong)
  {
    AppMethodBeat.i(124645);
    Object localObject = new w();
    ((w)localObject).field_msgId = paramLong;
    super.delete((com.tencent.mm.sdk.e.c)localObject, false, new String[] { "msgId" });
    localObject = new a();
    ((a)localObject).IIW = b.IIZ;
    a((a)localObject);
    AppMethodBeat.o(124645);
  }
  
  public final w DW(long paramLong)
  {
    w localw = null;
    AppMethodBeat.i(124653);
    Object localObject = "SELECT * FROM BizTimeLineInfo where type=620757041 and orderFlag > ".concat(String.valueOf(paramLong));
    localObject = this.hKK.a((String)localObject, null, 0);
    if (((Cursor)localObject).moveToFirst())
    {
      localw = new w();
      localw.convertFrom((Cursor)localObject);
    }
    ((Cursor)localObject).close();
    AppMethodBeat.o(124653);
    return localw;
  }
  
  public final w N(long paramLong, String paramString)
  {
    AppMethodBeat.i(124631);
    w localw = new w();
    paramString = this.hKK.a("BizTimeLineInfo", null, paramString + "=?", new String[] { String.valueOf(paramLong) }, null, null, null, 2);
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
    if (this.IIK.dW(parama)) {
      this.IIK.doNotify();
    }
    AppMethodBeat.o(124621);
  }
  
  public final void a(c paramc)
  {
    AppMethodBeat.i(124623);
    this.IIK.remove(paramc);
    AppMethodBeat.o(124623);
  }
  
  public final void a(c paramc, Looper paramLooper)
  {
    AppMethodBeat.i(124622);
    this.IIK.a(paramc, paramLooper);
    AppMethodBeat.o(124622);
  }
  
  public final List<w> aP(int paramInt, long paramLong)
  {
    AppMethodBeat.i(124632);
    Object localObject = this.hKK;
    String str = "orderFlag DESC limit ".concat(String.valueOf(paramInt));
    localObject = o(((h)localObject).query("BizTimeLineInfo", null, "orderFlag<?", new String[] { String.valueOf(paramLong) }, null, null, str));
    AppMethodBeat.o(124632);
    return localObject;
  }
  
  public final void aUa(String paramString)
  {
    AppMethodBeat.i(124627);
    if (bu.isNullOrNil(paramString))
    {
      AppMethodBeat.o(124627);
      return;
    }
    if (((com.tencent.mm.plugin.messenger.foundation.a.l)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.l.class)).azF().BH(paramString).adB()) {}
    for (int i = 1;; i = 0)
    {
      Object localObject = "update BizTimeLineInfo set placeTop = " + i + " where status > 4 and talker = '" + paramString + "'";
      this.hKK.execSQL("BizTimeLineInfo", (String)localObject);
      localObject = "update BizTimeLineInfo set placeTop = " + i + " where status < 4 and talker = '" + paramString + "'";
      this.hKK.execSQL("BizTimeLineInfo", (String)localObject);
      localObject = ftp();
      if ((localObject != null) && (paramString.equals(((w)localObject).field_talker)))
      {
        ((w)localObject).field_placeTop = i;
        super.updateNotify((com.tencent.mm.sdk.e.c)localObject, false, new String[] { "msgSvrId" });
      }
      paramString = new a();
      paramString.IIW = b.IJa;
      a(paramString);
      AppMethodBeat.o(124627);
      return;
    }
  }
  
  public final w aUb(String paramString)
  {
    Object localObject = null;
    AppMethodBeat.i(188981);
    if (paramString == null)
    {
      AppMethodBeat.o(188981);
      return null;
    }
    paramString = "SELECT * FROM BizTimeLineInfo where type=620757041 and recommendCardId='" + paramString + "'";
    Cursor localCursor = this.hKK.a(paramString, null, 0);
    paramString = localObject;
    if (localCursor.moveToFirst())
    {
      paramString = new w();
      paramString.convertFrom(localCursor);
    }
    localCursor.close();
    AppMethodBeat.o(188981);
    return paramString;
  }
  
  public final List<w> abn(int paramInt)
  {
    AppMethodBeat.i(124633);
    List localList = o(this.hKK.query("BizTimeLineInfo", null, null, null, null, null, "orderFlag DESC limit ".concat(String.valueOf(paramInt))));
    AppMethodBeat.o(124633);
    return localList;
  }
  
  public final List<w> abo(int paramInt)
  {
    AppMethodBeat.i(188977);
    List localList = o(this.hKK.query("BizTimeLineInfo", null, "type=?", new String[] { String.valueOf(paramInt) }, null, null, "orderFlag DESC limit 1"));
    AppMethodBeat.o(188977);
    return localList;
  }
  
  public final w abp(int paramInt)
  {
    Object localObject3 = null;
    AppMethodBeat.i(188979);
    Object localObject1 = "SELECT * FROM BizTimeLineInfo order by orderFlag DESC limit 1 offset ".concat(String.valueOf(paramInt));
    Object localObject2 = this.hKK.a((String)localObject1, null, 0);
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
        if (((w)localObject1).fsY() >= fts()) {}
      }
      else
      {
        long l = fts();
        localObject1 = "SELECT * FROM BizTimeLineInfo where orderFlag > " + (l << 32) + " order by orderFlag asc limit 1";
        localObject2 = this.hKK.a((String)localObject1, null, 0);
        localObject1 = localObject3;
        if (((Cursor)localObject2).moveToFirst())
        {
          localObject1 = new w();
          ((w)localObject1).convertFrom((Cursor)localObject2);
        }
        ((Cursor)localObject2).close();
        localObject2 = localObject1;
      }
      AppMethodBeat.o(188979);
      return localObject2;
      localObject1 = null;
    }
  }
  
  public final w abq(int paramInt)
  {
    w localw = null;
    AppMethodBeat.i(188980);
    Object localObject = "SELECT * FROM BizTimeLineInfo order by orderFlag DESC limit 1 offset ".concat(String.valueOf(paramInt));
    localObject = this.hKK.a((String)localObject, null, 0);
    if (((Cursor)localObject).moveToFirst())
    {
      localw = new w();
      localw.convertFrom((Cursor)localObject);
    }
    ((Cursor)localObject).close();
    AppMethodBeat.o(188980);
    return localw;
  }
  
  public final boolean aqS(String paramString)
  {
    AppMethodBeat.i(124644);
    w localw = new w();
    localw.field_talker = paramString;
    boolean bool = super.delete(localw, false, new String[] { "talker" });
    paramString = new a();
    paramString.talker = localw.field_talker;
    paramString.ogW = localw;
    paramString.IIW = b.IIZ;
    a(paramString);
    AppMethodBeat.o(124644);
    return bool;
  }
  
  public final boolean b(w paramw, boolean paramBoolean)
  {
    AppMethodBeat.i(188974);
    boolean bool = super.updateNotify(paramw, false, new String[] { "msgId" });
    if (paramBoolean)
    {
      a locala = new a();
      locala.talker = paramw.field_talker;
      locala.ogW = paramw;
      locala.IIW = b.IJa;
      a(locala);
    }
    AppMethodBeat.o(188974);
    return bool;
  }
  
  public final long fsY()
  {
    try
    {
      AppMethodBeat.i(124647);
      long l = this.IIO.longValue();
      AppMethodBeat.o(124647);
      return l;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public final w fto()
  {
    w localw = null;
    AppMethodBeat.i(188978);
    Object localObject = String.format("SELECT * FROM %s WHERE %s = %d order by %s  DESC limit 1", new Object[] { "BizTimeLineInfo", "type", Integer.valueOf(637534257), "orderFlag" });
    localObject = this.hKK.a((String)localObject, null, 0);
    if (((Cursor)localObject).moveToFirst())
    {
      localw = new w();
      localw.convertFrom((Cursor)localObject);
    }
    ((Cursor)localObject).close();
    AppMethodBeat.o(188978);
    return localw;
  }
  
  public final w ftp()
  {
    w localw = null;
    AppMethodBeat.i(124636);
    Cursor localCursor = this.hKK.a("SELECT * FROM BizTimeLineInfo order by orderFlag DESC limit 1", null, 0);
    if (localCursor.moveToFirst())
    {
      localw = new w();
      localw.convertFrom(localCursor);
    }
    localCursor.close();
    AppMethodBeat.o(124636);
    return localw;
  }
  
  public final void ftq()
  {
    AppMethodBeat.i(124640);
    w localw = ftp();
    if (localw == null)
    {
      AppMethodBeat.o(124640);
      return;
    }
    DS(localw.field_orderFlag);
    AppMethodBeat.o(124640);
  }
  
  public final int ftr()
  {
    AppMethodBeat.i(124642);
    w localw = ftp();
    if (localw == null)
    {
      AppMethodBeat.o(124642);
      return 0;
    }
    int i = DT(localw.field_orderFlag);
    AppMethodBeat.o(124642);
    return i;
  }
  
  public final long fts()
  {
    try
    {
      long l = this.IIP;
      return l;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public final long ftt()
  {
    try
    {
      AppMethodBeat.i(124648);
      long l = this.IIO.incrementAndGet();
      AppMethodBeat.o(124648);
      return l;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public final int ftv()
  {
    int i = 0;
    AppMethodBeat.i(124650);
    Cursor localCursor = this.hKK.a("SELECT count(*) FROM BizTimeLineInfo", null, 0);
    if (localCursor.moveToFirst()) {
      i = localCursor.getInt(0);
    }
    localCursor.close();
    AppMethodBeat.o(124650);
    return i;
  }
  
  public final long ftx()
  {
    w localw = null;
    try
    {
      AppMethodBeat.i(124652);
      if (this.IIS.longValue() == -5000000L)
      {
        Cursor localCursor = this.hKK.a("SELECT * FROM BizTimeLineInfo where type=620757041 or type=637534257 order by msgId DESC limit 1", null, 0);
        if (localCursor.moveToFirst())
        {
          localw = new w();
          localw.convertFrom(localCursor);
        }
        localCursor.close();
        if (localw != null) {
          this.IIS.set(localw.field_msgId);
        }
      }
      long l = this.IIS.incrementAndGet();
      AppMethodBeat.o(124652);
      return l;
    }
    finally {}
  }
  
  public final boolean hz(final List<w> paramList)
  {
    AppMethodBeat.i(124628);
    if (bu.ht(paramList))
    {
      AppMethodBeat.o(124628);
      return false;
    }
    com.tencent.mm.cm.g.fWL().h(new a() {});
    AppMethodBeat.o(124628);
    return true;
  }
  
  public final boolean p(w paramw)
  {
    AppMethodBeat.i(124625);
    boolean bool = super.insertNotify(paramw, false);
    DV(paramw.fsY());
    a locala = new a();
    locala.talker = paramw.field_talker;
    locala.ogW = paramw;
    locala.IIW = b.IIY;
    a(locala);
    AppMethodBeat.o(124625);
    return bool;
  }
  
  public final boolean q(w paramw)
  {
    AppMethodBeat.i(124626);
    boolean bool = super.updateNotify(paramw, false, new String[] { "msgSvrId" });
    a locala = new a();
    locala.talker = paramw.field_talker;
    locala.ogW = paramw;
    locala.IIW = b.IJa;
    a(locala);
    AppMethodBeat.o(124626);
    return bool;
  }
  
  public static final class a
  {
    public x.b IIW = x.b.IIY;
    public boolean IIX = false;
    public List<w> list;
    public w ogW;
    public String talker;
  }
  
  public static enum b
  {
    static
    {
      AppMethodBeat.i(124620);
      IIY = new b("INSERT", 0);
      IIZ = new b("DELETE", 1);
      IJa = new b("UPDATE", 2);
      IJb = new b("RE_SORT", 3);
      IJc = new b[] { IIY, IIZ, IJa, IJb };
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