package com.tencent.mm.storage;

import android.content.ContentValues;
import android.database.Cursor;
import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cp.g;
import com.tencent.mm.memory.a.c;
import com.tencent.mm.model.br;
import com.tencent.mm.plugin.messenger.foundation.a.n;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.storage.IAutoDBItem;
import com.tencent.mm.sdk.storage.MAutoStorage;
import com.tencent.mm.sdk.storage.MStorageEvent;
import com.tencent.mm.vending.c.a;
import com.tencent.threadpool.i;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

public final class ac
  extends MAutoStorage<ab>
{
  public static final String[] INDEX_CREATE;
  public static final String[] SQL_CREATE;
  public static final String[] acFK;
  private static final com.tencent.mm.b.f<Long, Boolean> acFM;
  private final MStorageEvent<c, a> acFL;
  int acFN;
  public boolean acFO;
  private AtomicLong acFP;
  private long acFQ;
  private long acFR;
  private final long acFS;
  private AtomicLong acFT;
  public final com.tencent.mm.storagebase.h omV;
  
  static
  {
    AppMethodBeat.i(124655);
    SQL_CREATE = new String[] { MAutoStorage.getCreateSQLs(ab.info, "BizTimeLineInfo") };
    INDEX_CREATE = new String[] { "CREATE  INDEX IF NOT EXISTS msg_id_index ON BizTimeLineInfo ( msgId ) ", "CREATE  INDEX IF NOT EXISTS  has_show_talker_index ON BizTimeLineInfo ( hasShow,talker ) ", "CREATE  INDEX IF NOT EXISTS  has_show_place_top_index ON BizTimeLineInfo ( hasShow,placeTop ) ", "CREATE  INDEX IF NOT EXISTS  order_flag_place_top_index ON BizTimeLineInfo ( orderFlag,placeTop ) ", "CREATE  INDEX IF NOT EXISTS  talker_id_order_flag_index ON BizTimeLineInfo ( talkerId,orderFlag ) " };
    acFK = new String[] { "CREATE  INDEX IF NOT EXISTS  biz_status_talker_index ON BizTimeLineInfo ( status,talker ) ", "CREATE  INDEX IF NOT EXISTS  biz_msg_svr_id_index ON BizTimeLineInfo ( msgSvrId ) ", "CREATE  INDEX IF NOT EXISTS  biz_talker_index ON BizTimeLineInfo ( talker ) ", "CREATE  INDEX IF NOT EXISTS  order_flag_status_index ON BizTimeLineInfo ( orderFlag,status ) ", "CREATE  INDEX IF NOT EXISTS  order_flag_has_show_index ON BizTimeLineInfo ( orderFlag,hasShow ) ", "CREATE  INDEX IF NOT EXISTS  is_read_order_flag_index ON BizTimeLineInfo ( isRead,orderFlag ) ", "CREATE  INDEX IF NOT EXISTS  is_read_msg_id_index ON BizTimeLineInfo ( isRead,msgId ) ", "CREATE  INDEX IF NOT EXISTS  biz_type_order_flag_isread_index ON BizTimeLineInfo ( type,orderFlag,isRead ) ", "CREATE  INDEX IF NOT EXISTS  biz_type_is_read_index ON BizTimeLineInfo ( type,isRead ) ", "CREATE  INDEX IF NOT EXISTS  biz_create_time_index ON BizTimeLineInfo ( createTime ) ", "CREATE  INDEX IF NOT EXISTS  recommend_card_id_index ON BizTimeLineInfo ( recommendCardId ) " };
    acFM = new c(30);
    AppMethodBeat.o(124655);
  }
  
  public ac(com.tencent.mm.storagebase.h paramh)
  {
    super(paramh, ab.info, "BizTimeLineInfo", INDEX_CREATE);
    AppMethodBeat.i(124624);
    this.acFL = new MStorageEvent() {};
    this.acFN = 100;
    this.acFO = true;
    this.acFP = new AtomicLong(10L);
    this.acFQ = 10L;
    this.acFS = -5000000L;
    this.acFT = new AtomicLong(-5000000L);
    this.omV = paramh;
    iYF();
    AppMethodBeat.o(124624);
  }
  
  private void iYC()
  {
    try
    {
      AppMethodBeat.i(248506);
      ab localab = iYx();
      if (localab != null) {
        this.acFQ = Math.min(localab.iYa(), this.acFQ);
      }
      AppMethodBeat.o(248506);
      return;
    }
    finally {}
  }
  
  private void iYF()
  {
    for (;;)
    {
      try
      {
        AppMethodBeat.i(124649);
        this.acFQ = (iYG() >> 32);
        if (this.acFQ < 10L) {
          this.acFQ = 10L;
        }
        ab localab = iYx();
        if (localab == null)
        {
          Log.w("MicroMsg.BizTimeLineInfoStorage", "initGroupId is null, id %d", new Object[] { Long.valueOf(this.acFQ) });
          AppMethodBeat.o(124649);
          return;
        }
        if (localab.field_status == 4)
        {
          this.acFP.set(this.acFQ + 1L);
          this.acFR = this.acFP.longValue();
          Log.i("MicroMsg.BizTimeLineInfoStorage", "initGroupId id %d/%d, status %d", new Object[] { Long.valueOf(this.acFP.longValue()), Long.valueOf(this.acFQ), Integer.valueOf(localab.field_status) });
          AppMethodBeat.o(124649);
        }
        else
        {
          this.acFP.set(this.acFQ);
        }
      }
      finally {}
    }
  }
  
  private long iYG()
  {
    try
    {
      AppMethodBeat.i(124651);
      Cursor localCursor = this.omV.rawQuery("select max(orderFlag) from BizTimeLineInfo", null, 2);
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
  
  public static List<ab> s(Cursor paramCursor)
  {
    AppMethodBeat.i(124635);
    LinkedList localLinkedList = new LinkedList();
    while (paramCursor.moveToNext())
    {
      ab localab = new ab();
      localab.convertFrom(paramCursor);
      localLinkedList.add(localab);
    }
    paramCursor.close();
    AppMethodBeat.o(124635);
    return localLinkedList;
  }
  
  private int yI(long paramLong)
  {
    int i = 0;
    AppMethodBeat.i(248495);
    Object localObject = "SELECT count(*) FROM BizTimeLineInfo where isRead != 1 and orderFlag >= " + (0x0 & paramLong) + " and orderFlag < " + paramLong;
    localObject = this.omV.rawQuery((String)localObject, null);
    if (((Cursor)localObject).moveToFirst()) {
      i = ((Cursor)localObject).getInt(0);
    }
    ((Cursor)localObject).close();
    AppMethodBeat.o(248495);
    return i;
  }
  
  private void yR(long paramLong)
  {
    try
    {
      AppMethodBeat.i(124646);
      this.acFQ = Math.max(paramLong, this.acFQ);
      AppMethodBeat.o(124646);
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public final boolean E(ab paramab)
  {
    AppMethodBeat.i(124625);
    boolean bool = c(paramab, true);
    AppMethodBeat.o(124625);
    return bool;
  }
  
  public final boolean F(ab paramab)
  {
    AppMethodBeat.i(124626);
    boolean bool = super.updateNotify(paramab, false, new String[] { "msgSvrId" });
    a locala = new a();
    locala.talker = paramab.field_talker;
    locala.vGS = paramab;
    locala.acFX = b.acGb;
    a(locala);
    AppMethodBeat.o(124626);
    return bool;
  }
  
  public final boolean G(ab paramab)
  {
    AppMethodBeat.i(248577);
    if (paramab.field_isRead == 1)
    {
      AppMethodBeat.o(248577);
      return false;
    }
    com.tencent.threadpool.h.ahAA.g(new ac.6(this, paramab), "updateUnReadStatus");
    AppMethodBeat.o(248577);
    return true;
  }
  
  public final void a(a parama)
  {
    AppMethodBeat.i(124621);
    if (this.acFL.event(parama)) {
      this.acFL.doNotify();
    }
    AppMethodBeat.o(124621);
  }
  
  public final void a(c paramc)
  {
    AppMethodBeat.i(124623);
    this.acFL.remove(paramc);
    AppMethodBeat.o(124623);
  }
  
  public final void a(c paramc, Looper paramLooper)
  {
    AppMethodBeat.i(124622);
    this.acFL.add(paramc, paramLooper);
    AppMethodBeat.o(124622);
  }
  
  public final boolean aLw(String paramString)
  {
    AppMethodBeat.i(124644);
    Log.i("MicroMsg.BizTimeLineInfoStorage", "deleteByTalker: %s", new Object[] { paramString });
    ab localab = new ab();
    localab.field_talker = paramString;
    boolean bool = super.delete(localab, false, new String[] { "talker" });
    paramString = new a();
    paramString.talker = localab.field_talker;
    paramString.vGS = localab;
    paramString.acFX = b.acGa;
    a(paramString);
    iYC();
    AppMethodBeat.o(124644);
    return bool;
  }
  
  public final ab aq(long paramLong, String paramString)
  {
    AppMethodBeat.i(124631);
    ab localab = new ab();
    paramString = this.omV.query("BizTimeLineInfo", null, paramString + "=?", new String[] { String.valueOf(paramLong) }, null, null, null, 2);
    if (paramString.moveToFirst())
    {
      localab.convertFrom(paramString);
      paramString.close();
      AppMethodBeat.o(124631);
      return localab;
    }
    paramString.close();
    AppMethodBeat.o(124631);
    return null;
  }
  
  public final List<ab> ayA(int paramInt)
  {
    AppMethodBeat.i(124633);
    List localList = s(this.omV.query("BizTimeLineInfo", null, null, null, null, null, "orderFlag DESC limit ".concat(String.valueOf(paramInt))));
    AppMethodBeat.o(124633);
    return localList;
  }
  
  public final ab ayB(int paramInt)
  {
    Object localObject3 = null;
    AppMethodBeat.i(248697);
    Object localObject1 = "SELECT * FROM BizTimeLineInfo order by orderFlag DESC limit 1 offset ".concat(String.valueOf(paramInt));
    Object localObject2 = this.omV.rawQuery((String)localObject1, null);
    if (((Cursor)localObject2).moveToFirst())
    {
      localObject1 = new ab();
      ((ab)localObject1).convertFrom((Cursor)localObject2);
    }
    for (;;)
    {
      ((Cursor)localObject2).close();
      if (localObject1 != null)
      {
        localObject2 = localObject1;
        if (((ab)localObject1).iYa() >= iYD()) {}
      }
      else
      {
        long l = iYD();
        localObject1 = "SELECT * FROM BizTimeLineInfo where orderFlag > " + (l << 32) + " order by orderFlag asc limit 1";
        localObject2 = this.omV.rawQuery((String)localObject1, null);
        localObject1 = localObject3;
        if (((Cursor)localObject2).moveToFirst())
        {
          localObject1 = new ab();
          ((ab)localObject1).convertFrom((Cursor)localObject2);
        }
        ((Cursor)localObject2).close();
        localObject2 = localObject1;
      }
      AppMethodBeat.o(248697);
      return localObject2;
      localObject1 = null;
    }
  }
  
  public final void ayC(int paramInt)
  {
    AppMethodBeat.i(248714);
    Object localObject = String.format("DELETE FROM %s WHERE %s = %d and isRead = %d", new Object[] { "BizTimeLineInfo", "type", Integer.valueOf(637534257), Integer.valueOf(paramInt) });
    Log.i("MicroMsg.BizTimeLineInfoStorage", "deleteMsgByTypeAndExposeStatus type:%d ret:%b", new Object[] { Integer.valueOf(637534257), Boolean.valueOf(this.omV.execSQL("BizTimeLineInfo", (String)localObject)) });
    localObject = new a();
    ((a)localObject).acFX = b.acGa;
    a((a)localObject);
    AppMethodBeat.o(248714);
  }
  
  public final void bSr()
  {
    AppMethodBeat.i(248682);
    com.tencent.threadpool.h.ahAA.a(new ac.3(this), 10L, "BizTimeLineInfoStorageDeleteThread");
    AppMethodBeat.o(248682);
  }
  
  public final List<ab> bp(int paramInt, long paramLong)
  {
    AppMethodBeat.i(124632);
    Object localObject = this.omV;
    String str = "orderFlag DESC limit ".concat(String.valueOf(paramInt));
    localObject = s(((com.tencent.mm.storagebase.h)localObject).query("BizTimeLineInfo", null, "orderFlag<?", new String[] { String.valueOf(paramLong) }, null, null, str));
    AppMethodBeat.o(124632);
    return localObject;
  }
  
  public final void bvA(String paramString)
  {
    AppMethodBeat.i(124627);
    if (Util.isNullOrNil(paramString))
    {
      AppMethodBeat.o(124627);
      return;
    }
    if (((n)com.tencent.mm.kernel.h.ax(n.class)).bzA().JE(paramString).aSQ()) {}
    for (int i = 1;; i = 0)
    {
      Object localObject = "update BizTimeLineInfo set placeTop = " + i + " where status > 4 and talker = '" + paramString + "'";
      this.omV.execSQL("BizTimeLineInfo", (String)localObject);
      localObject = "update BizTimeLineInfo set placeTop = " + i + " where status < 4 and talker = '" + paramString + "'";
      this.omV.execSQL("BizTimeLineInfo", (String)localObject);
      localObject = iYx();
      if ((localObject != null) && (paramString.equals(((ab)localObject).field_talker)))
      {
        ((ab)localObject).field_placeTop = i;
        super.updateNotify((IAutoDBItem)localObject, false, new String[] { "msgSvrId" });
      }
      paramString = new a();
      paramString.acFX = b.acGb;
      a(paramString);
      AppMethodBeat.o(124627);
      return;
    }
  }
  
  public final ab bvB(String paramString)
  {
    Object localObject = null;
    AppMethodBeat.i(248722);
    if (paramString == null)
    {
      AppMethodBeat.o(248722);
      return null;
    }
    paramString = "SELECT * FROM BizTimeLineInfo where type=620757041 and recommendCardId='" + paramString + "'";
    Cursor localCursor = this.omV.rawQuery(paramString, null);
    paramString = localObject;
    if (localCursor.moveToFirst())
    {
      paramString = new ab();
      paramString.convertFrom(localCursor);
    }
    localCursor.close();
    AppMethodBeat.o(248722);
    return paramString;
  }
  
  public final boolean c(ab paramab, boolean paramBoolean)
  {
    AppMethodBeat.i(248543);
    boolean bool = super.insertNotify(paramab, false);
    if (paramBoolean) {
      yR(paramab.iYa());
    }
    a locala = new a();
    locala.talker = paramab.field_talker;
    locala.vGS = paramab;
    locala.acFX = b.acFZ;
    a(locala);
    AppMethodBeat.o(248543);
    return bool;
  }
  
  public final boolean d(ab paramab, boolean paramBoolean)
  {
    AppMethodBeat.i(248553);
    boolean bool = super.updateNotify(paramab, false, new String[] { "msgId" });
    if (paramBoolean)
    {
      a locala = new a();
      locala.talker = paramab.field_talker;
      locala.vGS = paramab;
      locala.acFX = b.acGb;
      a(locala);
    }
    AppMethodBeat.o(248553);
    return bool;
  }
  
  public final int dWF()
  {
    int i = 0;
    AppMethodBeat.i(124650);
    Cursor localCursor = this.omV.rawQuery("SELECT count(*) FROM BizTimeLineInfo", null);
    if (localCursor.moveToFirst()) {
      i = localCursor.getInt(0);
    }
    localCursor.close();
    AppMethodBeat.o(124650);
    return i;
  }
  
  public final List<ab> g(int paramInt1, long paramLong1, long paramLong2, int paramInt2)
  {
    AppMethodBeat.i(248630);
    LinkedList localLinkedList = new LinkedList();
    int j = Math.min(20, paramInt1);
    int i = 0;
    long l1 = iYD() << 32;
    long l2 = System.currentTimeMillis();
    Object localObject1 = af.acGt;
    if (af.ayJ(paramInt2))
    {
      l1 = paramLong2 & 0x0;
      localObject1 = " and orderFlag < " + paramLong2 + " ";
    }
    for (paramLong2 = l1;; paramLong2 = l1)
    {
      paramInt2 = 0;
      String str;
      Object localObject2;
      int k;
      if (paramInt2 == 0)
      {
        j = Math.min(j, paramInt1 - localLinkedList.size());
        if (j > 0)
        {
          str = "SELECT * FROM BizTimeLineInfo where  isRead = 0 and orderFlag >= " + paramLong2 + (String)localObject1 + " and createTime >= " + paramLong1 + " and bitFlag&1073741824 = 0 order by orderFlag ASC limit " + j + " offset " + i;
          localObject2 = s(this.omV.rawQuery(str, null));
          localLinkedList.addAll((Collection)localObject2);
          k = ((List)localObject2).size();
          if (k < j) {}
          for (paramInt2 = 1;; paramInt2 = 0)
          {
            i += j;
            Log.d("MicroMsg.BizTimeLineInfoStorage", "getUnReadListNew sql = %s, localLimit=%d, tmpListSize=%d", new Object[] { str, Integer.valueOf(j), Integer.valueOf(k) });
            break;
          }
        }
      }
      paramInt2 = Math.min(20, paramInt1 - localLinkedList.size());
      i = 0;
      j = 0;
      if (j == 0)
      {
        k = localLinkedList.size();
        j = Math.min(paramInt2, paramInt1 - k);
        if (j > 0)
        {
          str = "";
          if (k > 0)
          {
            str = "and msgId not in (";
            paramInt2 = 0;
            if (paramInt2 < k)
            {
              localObject2 = new StringBuilder().append(str);
              if (paramInt2 > 0) {}
              for (str = ",";; str = "")
              {
                str = str + ((ab)localLinkedList.get(paramInt2)).field_msgId;
                paramInt2 += 1;
                break;
              }
            }
            str = str + ")";
          }
          str = "SELECT * FROM BizTimeLineInfo where  isRead = 0 " + (String)localObject1 + str + " order by orderFlag DESC limit " + j + " offset " + i;
          localObject2 = s(this.omV.rawQuery(str, null));
          k = ((List)localObject2).size();
          if (k < j) {}
          for (paramInt2 = 1;; paramInt2 = 0)
          {
            localLinkedList.addAll((Collection)localObject2);
            Log.d("MicroMsg.BizTimeLineInfoStorage", "getUnReadListNew sql2 = %s, localLimit=%d, tmpListSize=%d", new Object[] { str, Integer.valueOf(j), Integer.valueOf(k) });
            k = i + j;
            i = j;
            j = paramInt2;
            paramInt2 = i;
            i = k;
            break;
          }
        }
      }
      Log.d("MicroMsg.BizTimeLineInfoStorage", "getUnReadListNew cost %d, size = %d", new Object[] { Long.valueOf(System.currentTimeMillis() - l2), Integer.valueOf(localLinkedList.size()) });
      AppMethodBeat.o(248630);
      return localLinkedList;
      localObject1 = "";
    }
  }
  
  public final void iYA()
  {
    AppMethodBeat.i(124640);
    ab localab = iYx();
    if (localab == null)
    {
      AppMethodBeat.o(124640);
      return;
    }
    yO(localab.field_orderFlag);
    AppMethodBeat.o(124640);
  }
  
  public final int iYB()
  {
    AppMethodBeat.i(124642);
    ab localab = iYx();
    if (localab == null)
    {
      AppMethodBeat.o(124642);
      return 0;
    }
    int i = yP(localab.field_orderFlag);
    AppMethodBeat.o(124642);
    return i;
  }
  
  public final long iYD()
  {
    try
    {
      long l = this.acFQ;
      return l;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public final long iYE()
  {
    try
    {
      AppMethodBeat.i(124648);
      long l = this.acFP.incrementAndGet();
      AppMethodBeat.o(124648);
      return l;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public final long iYH()
  {
    ab localab = null;
    try
    {
      AppMethodBeat.i(124652);
      if (this.acFT.longValue() == -5000000L)
      {
        Cursor localCursor = this.omV.rawQuery("SELECT * FROM BizTimeLineInfo where type=620757041 or type=637534257 order by msgId DESC limit 1", null);
        if (localCursor.moveToFirst())
        {
          localab = new ab();
          localab.convertFrom(localCursor);
        }
        localCursor.close();
        if (localab != null) {
          this.acFT.set(localab.field_msgId);
        }
      }
      long l = this.acFT.incrementAndGet();
      AppMethodBeat.o(124652);
      return l;
    }
    finally {}
  }
  
  public final void iYI()
  {
    AppMethodBeat.i(248709);
    Object localObject = String.format("DELETE FROM %s WHERE type = %d and createTime < %d", new Object[] { "BizTimeLineInfo", Integer.valueOf(637534257), Long.valueOf(br.bCJ() - 86400000L) });
    Log.d("MicroMsg.BizTimeLineInfoStorage", "deleteExposedAdMsgByType ret:%b, sql=%s", new Object[] { Boolean.valueOf(this.omV.execSQL("BizTimeLineInfo", (String)localObject)), localObject });
    localObject = new a();
    ((a)localObject).acFX = b.acGa;
    a((a)localObject);
    AppMethodBeat.o(248709);
  }
  
  public final void iYJ()
  {
    AppMethodBeat.i(248720);
    Object localObject = String.format("DELETE FROM %s WHERE %s = %d", new Object[] { "BizTimeLineInfo", "type", Integer.valueOf(637534257) });
    Log.i("MicroMsg.BizTimeLineInfoStorage", "deleteAllMsgByType type:%d ret:%b", new Object[] { Integer.valueOf(637534257), Boolean.valueOf(this.omV.execSQL("BizTimeLineInfo", (String)localObject)) });
    localObject = new a();
    ((a)localObject).acFX = b.acGa;
    a((a)localObject);
    AppMethodBeat.o(248720);
  }
  
  public final long iYa()
  {
    try
    {
      AppMethodBeat.i(124647);
      long l = this.acFP.longValue();
      AppMethodBeat.o(124647);
      return l;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public final ab iYw()
  {
    ab localab = null;
    AppMethodBeat.i(248615);
    Object localObject = String.format("SELECT * FROM %s WHERE %s = %d order by %s  DESC limit 1", new Object[] { "BizTimeLineInfo", "type", Integer.valueOf(637534257), "orderFlag" });
    localObject = this.omV.rawQuery((String)localObject, null);
    if (((Cursor)localObject).moveToFirst())
    {
      localab = new ab();
      localab.convertFrom((Cursor)localObject);
    }
    ((Cursor)localObject).close();
    AppMethodBeat.o(248615);
    return localab;
  }
  
  public final ab iYx()
  {
    ab localab = null;
    AppMethodBeat.i(124636);
    Cursor localCursor = this.omV.rawQuery("SELECT * FROM BizTimeLineInfo order by orderFlag DESC limit 1", null);
    if (localCursor.moveToFirst())
    {
      localab = new ab();
      localab.convertFrom(localCursor);
    }
    localCursor.close();
    AppMethodBeat.o(124636);
    return localab;
  }
  
  public final ab iYy()
  {
    ab localab = null;
    AppMethodBeat.i(248638);
    Cursor localCursor = this.omV.rawQuery("SELECT * FROM BizTimeLineInfo where type !=637534257 order by createTime DESC limit 1", null);
    if (localCursor.moveToFirst())
    {
      localab = new ab();
      localab.convertFrom(localCursor);
    }
    localCursor.close();
    AppMethodBeat.o(248638);
    return localab;
  }
  
  public final long iYz()
  {
    AppMethodBeat.i(248643);
    Cursor localCursor = this.omV.rawQuery("SELECT createTime FROM BizTimeLineInfo where type !=637534257 order by createTime DESC limit 1", null);
    long l = 0L;
    if (localCursor.moveToFirst()) {
      l = localCursor.getLong(0);
    }
    localCursor.close();
    AppMethodBeat.o(248643);
    return l;
  }
  
  public final boolean mH(List<ab> paramList)
  {
    AppMethodBeat.i(248567);
    if (Util.isNullOrNil(paramList))
    {
      AppMethodBeat.o(248567);
      return false;
    }
    long l = this.omV.beginTransaction(Thread.currentThread().getId());
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      ab localab = (ab)paramList.next();
      ContentValues localContentValues = new ContentValues();
      localContentValues.put("orderFlag", Long.valueOf(localab.field_orderFlag));
      localContentValues.put("bitFlag", Integer.valueOf(localab.field_bitFlag));
      localContentValues.put("status", Integer.valueOf(3));
      if (localab.acFx)
      {
        localContentValues.put("hasShow", Integer.valueOf(0));
        localContentValues.put("isRead", Integer.valueOf(0));
      }
      localContentValues.put("rankSessionId", localab.field_rankSessionId);
      this.omV.update("BizTimeLineInfo", localContentValues, "msgId = ?", new String[] { localab.field_msgId });
    }
    Log.i("MicroMsg.BizTimeLineInfoStorage", "batResortBizTimeLineInfo ret=%d", new Object[] { Integer.valueOf(this.omV.endTransaction(l)) });
    com.tencent.threadpool.h.ahAA.bk(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(248810);
        ac.a locala = new ac.a();
        locala.acFX = ac.b.acGc;
        ac.this.a(locala);
        AppMethodBeat.o(248810);
      }
    });
    AppMethodBeat.o(248567);
    return true;
  }
  
  public final List<ab> nT(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(248610);
    Object localObject = this.omV;
    String str = "orderFlag DESC limit ".concat(String.valueOf(paramInt2));
    localObject = s(((com.tencent.mm.storagebase.h)localObject).query("BizTimeLineInfo", null, "type=?", new String[] { String.valueOf(paramInt1) }, null, null, str));
    AppMethodBeat.o(248610);
    return localObject;
  }
  
  public final ab yF(long paramLong)
  {
    AppMethodBeat.i(124629);
    ab localab = aq(paramLong, "orderFlag");
    AppMethodBeat.o(124629);
    return localab;
  }
  
  public final List<ab> yG(long paramLong)
  {
    AppMethodBeat.i(248595);
    List localList = s(this.omV.query("BizTimeLineInfo", null, "orderFlag>?", new String[] { String.valueOf(paramLong) }, null, null, "orderFlag DESC limit 5"));
    AppMethodBeat.o(248595);
    return localList;
  }
  
  public final List<ab> yH(long paramLong)
  {
    AppMethodBeat.i(124634);
    List localList = s(this.omV.query("BizTimeLineInfo", null, "orderFlag>=?", new String[] { String.valueOf(paramLong) }, null, null, "orderFlag DESC"));
    AppMethodBeat.o(124634);
    return localList;
  }
  
  public final int yJ(long paramLong)
  {
    int i = -1;
    AppMethodBeat.i(248624);
    if (yI(paramLong) <= 0)
    {
      Log.i("MicroMsg.BizTimeLineInfoStorage", "getMaxWeightByOrderFlag unReadCount < 0");
      AppMethodBeat.o(248624);
      return -1;
    }
    Object localObject = String.format("SELECT orderFlag FROM %s WHERE isRead = 1 and orderFlag <= %d and orderFlag >= %d order by orderFlag ASC limit 1", new Object[] { "BizTimeLineInfo", Long.valueOf(paramLong), Long.valueOf(0x0 & paramLong) });
    localObject = this.omV.rawQuery((String)localObject, null);
    if (((Cursor)localObject).moveToFirst()) {
      i = (int)((((Cursor)localObject).getLong(0) & 0xFF000000) >> 24) - 1;
    }
    ((Cursor)localObject).close();
    if (i < 0) {
      Log.i("MicroMsg.BizTimeLineInfoStorage", "getMaxWeightByOrderFlag weight < 0");
    }
    AppMethodBeat.o(248624);
    return i;
  }
  
  public final ab yK(long paramLong)
  {
    ab localab = null;
    AppMethodBeat.i(124637);
    Object localObject = "SELECT * FROM BizTimeLineInfo where talkerId = " + paramLong + "  order by orderFlag DESC limit 1";
    localObject = this.omV.rawQuery((String)localObject, null);
    if (((Cursor)localObject).moveToFirst())
    {
      localab = new ab();
      localab.convertFrom((Cursor)localObject);
    }
    ((Cursor)localObject).close();
    AppMethodBeat.o(124637);
    return localab;
  }
  
  public final void yL(long paramLong)
  {
    AppMethodBeat.i(124638);
    long l1 = System.currentTimeMillis();
    long l2 = 0x0 & paramLong;
    String str = "update BizTimeLineInfo set status = 4 where orderFlag >= " + l2 + " and status > 4";
    this.omV.execSQL("BizTimeLineInfo", str);
    str = "update BizTimeLineInfo set status = 4 where orderFlag >= " + l2 + " and status < 4";
    this.omV.execSQL("BizTimeLineInfo", str);
    Log.d("MicroMsg.BizTimeLineInfoStorage", "resetUnread cost %d", new Object[] { Long.valueOf(System.currentTimeMillis() - l1) });
    acFM.B(Long.valueOf(paramLong), Boolean.TRUE);
    AppMethodBeat.o(124638);
  }
  
  public final int yM(long paramLong)
  {
    AppMethodBeat.i(124639);
    Object localObject = (Boolean)acFM.get(Long.valueOf(paramLong));
    if ((localObject != null) && (((Boolean)localObject).booleanValue()))
    {
      AppMethodBeat.o(124639);
      return 0;
    }
    long l1 = System.currentTimeMillis();
    long l2 = 0x0 & paramLong;
    localObject = "SELECT count(*) FROM BizTimeLineInfo where orderFlag >= " + l2 + " and status > 4";
    localObject = this.omV.rawQuery((String)localObject, null);
    if (((Cursor)localObject).moveToFirst()) {}
    for (int i = ((Cursor)localObject).getInt(0);; i = 0)
    {
      ((Cursor)localObject).close();
      localObject = "SELECT count(*) FROM BizTimeLineInfo where orderFlag >= " + l2 + " and status < 4";
      localObject = this.omV.rawQuery((String)localObject, null);
      int j = i;
      if (((Cursor)localObject).moveToFirst()) {
        j = i + ((Cursor)localObject).getInt(0);
      }
      ((Cursor)localObject).close();
      if (j == 0) {
        acFM.B(Long.valueOf(paramLong), Boolean.TRUE);
      }
      Log.d("MicroMsg.BizTimeLineInfoStorage", "getUnread cost %d", new Object[] { Long.valueOf(System.currentTimeMillis() - l1) });
      AppMethodBeat.o(124639);
      return j;
    }
  }
  
  public final ab yN(long paramLong)
  {
    AppMethodBeat.i(248655);
    Object localObject = "SELECT * FROM BizTimeLineInfo where orderFlag < " + (paramLong << 32) + " ORDER BY orderFlag desc LIMIT 1 ";
    localObject = this.omV.rawQuery((String)localObject, null);
    ab localab = new ab();
    if (((Cursor)localObject).moveToFirst())
    {
      localab.convertFrom((Cursor)localObject);
      ((Cursor)localObject).close();
      AppMethodBeat.o(248655);
      return localab;
    }
    ((Cursor)localObject).close();
    AppMethodBeat.o(248655);
    return null;
  }
  
  public final void yO(long paramLong)
  {
    AppMethodBeat.i(124641);
    g.jPX().h(new ac.2(this, paramLong)).b(new a() {});
    AppMethodBeat.o(124641);
  }
  
  public final int yP(long paramLong)
  {
    AppMethodBeat.i(124643);
    long l = System.currentTimeMillis();
    Object localObject = "SELECT count(*) FROM BizTimeLineInfo where orderFlag >= " + (0x0 & paramLong) + " and hasShow < 1 ";
    localObject = this.omV.rawQuery((String)localObject, null);
    if (((Cursor)localObject).moveToFirst()) {}
    for (int i = ((Cursor)localObject).getInt(0);; i = 0)
    {
      Log.d("MicroMsg.BizTimeLineInfoStorage", "getUnShowCount count = %d,cost = %d", new Object[] { Integer.valueOf(i), Long.valueOf(System.currentTimeMillis() - l) });
      ((Cursor)localObject).close();
      if (i > 2000)
      {
        if (this.acFR == this.acFP.longValue()) {
          iYE();
        }
        AppMethodBeat.o(124643);
        return 0;
      }
      AppMethodBeat.o(124643);
      return i;
    }
  }
  
  public final void yQ(long paramLong)
  {
    AppMethodBeat.i(124645);
    Log.i("MicroMsg.BizTimeLineInfoStorage", "deleteById: %d", new Object[] { Long.valueOf(paramLong) });
    Object localObject = new ab();
    ((ab)localObject).field_msgId = paramLong;
    super.delete((IAutoDBItem)localObject, false, new String[] { "msgId" });
    localObject = new a();
    ((a)localObject).acFX = b.acGa;
    a((a)localObject);
    iYC();
    AppMethodBeat.o(124645);
  }
  
  public final ab yS(long paramLong)
  {
    ab localab = null;
    AppMethodBeat.i(124653);
    Object localObject = "SELECT * FROM BizTimeLineInfo where type=620757041 and orderFlag > ".concat(String.valueOf(paramLong));
    localObject = this.omV.rawQuery((String)localObject, null);
    if (((Cursor)localObject).moveToFirst())
    {
      localab = new ab();
      localab.convertFrom((Cursor)localObject);
    }
    ((Cursor)localObject).close();
    AppMethodBeat.o(124653);
    return localab;
  }
  
  public final ab yT(long paramLong)
  {
    ab localab = null;
    AppMethodBeat.i(248704);
    Object localObject = "SELECT * FROM BizTimeLineInfo where type=637534257 and orderFlag > ".concat(String.valueOf(paramLong));
    localObject = this.omV.rawQuery((String)localObject, null);
    if (((Cursor)localObject).moveToFirst())
    {
      localab = new ab();
      localab.convertFrom((Cursor)localObject);
    }
    ((Cursor)localObject).close();
    AppMethodBeat.o(248704);
    return localab;
  }
  
  public static final class a
  {
    public ac.b acFX = ac.b.acFZ;
    public boolean acFY = false;
    public List<ab> list;
    public String talker;
    public ab vGS;
  }
  
  public static enum b
  {
    static
    {
      AppMethodBeat.i(124620);
      acFZ = new b("INSERT", 0);
      acGa = new b("DELETE", 1);
      acGb = new b("UPDATE", 2);
      acGc = new b("RE_SORT", 3);
      acGd = new b[] { acFZ, acGa, acGb, acGc };
      AppMethodBeat.o(124620);
    }
    
    private b() {}
  }
  
  public static abstract interface c
  {
    public abstract void onNotifyChange(Object paramObject, ac.a parama);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     com.tencent.mm.storage.ac
 * JD-Core Version:    0.7.0.1
 */