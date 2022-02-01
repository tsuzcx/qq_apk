package com.tencent.mm.storage;

import android.content.ContentValues;
import android.database.Cursor;
import android.os.Looper;
import com.tencent.f.i;
import com.tencent.mars.smc.IDKey;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.memory.a.c;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.storage.IAutoDBItem;
import com.tencent.mm.sdk.storage.MAutoStorage;
import com.tencent.mm.sdk.storage.MStorageEvent;
import com.tencent.mm.vending.c.a;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

public final class aa
  extends MAutoStorage<z>
{
  public static final String[] INDEX_CREATE;
  public static final String[] NQs;
  private static final com.tencent.mm.b.f<Long, Boolean> NQu;
  public static final String[] SQL_CREATE;
  private AtomicLong NQA;
  private final MStorageEvent<c, a> NQt;
  public boolean NQv;
  private AtomicLong NQw;
  private long NQx;
  private long NQy;
  private final long NQz;
  public final com.tencent.mm.storagebase.h iFy;
  
  static
  {
    AppMethodBeat.i(124655);
    SQL_CREATE = new String[] { MAutoStorage.getCreateSQLs(z.info, "BizTimeLineInfo") };
    INDEX_CREATE = new String[] { "CREATE  INDEX IF NOT EXISTS msg_id_index ON BizTimeLineInfo ( msgId ) ", "CREATE  INDEX IF NOT EXISTS  has_show_talker_index ON BizTimeLineInfo ( hasShow,talker ) ", "CREATE  INDEX IF NOT EXISTS  has_show_place_top_index ON BizTimeLineInfo ( hasShow,placeTop ) ", "CREATE  INDEX IF NOT EXISTS  order_flag_place_top_index ON BizTimeLineInfo ( orderFlag,placeTop ) ", "CREATE  INDEX IF NOT EXISTS  talker_id_order_flag_index ON BizTimeLineInfo ( talkerId,orderFlag ) " };
    NQs = new String[] { "CREATE  INDEX IF NOT EXISTS  biz_status_talker_index ON BizTimeLineInfo ( status,talker ) ", "CREATE  INDEX IF NOT EXISTS  biz_msg_svr_id_index ON BizTimeLineInfo ( msgSvrId ) ", "CREATE  INDEX IF NOT EXISTS  biz_talker_index ON BizTimeLineInfo ( talker ) ", "CREATE  INDEX IF NOT EXISTS  order_flag_status_index ON BizTimeLineInfo ( orderFlag,status ) ", "CREATE  INDEX IF NOT EXISTS  order_flag_has_show_index ON BizTimeLineInfo ( orderFlag,hasShow ) ", "CREATE  INDEX IF NOT EXISTS  biz_client_msg_id_index ON BizTimeLineInfo ( bizClientMsgId ) ", "CREATE  INDEX IF NOT EXISTS  is_read_order_flag_index ON BizTimeLineInfo ( isRead,orderFlag ) ", "CREATE  INDEX IF NOT EXISTS  is_read_msg_id_index ON BizTimeLineInfo ( isRead,msgId ) ", "CREATE  INDEX IF NOT EXISTS  biz_type_order_flag_isread_index ON BizTimeLineInfo ( type,orderFlag,isRead ) ", "CREATE  INDEX IF NOT EXISTS  biz_type_is_read_index ON BizTimeLineInfo ( type,isRead ) ", "CREATE  INDEX IF NOT EXISTS  biz_create_time_index ON BizTimeLineInfo ( createTime ) ", "CREATE  INDEX IF NOT EXISTS  recommend_card_id_index ON BizTimeLineInfo ( recommendCardId ) " };
    NQu = new c(30);
    AppMethodBeat.o(124655);
  }
  
  public aa(com.tencent.mm.storagebase.h paramh)
  {
    super(paramh, z.info, "BizTimeLineInfo", INDEX_CREATE);
    AppMethodBeat.i(124624);
    this.NQt = new MStorageEvent() {};
    this.NQv = true;
    this.NQw = new AtomicLong(10L);
    this.NQx = 10L;
    this.NQz = -5000000L;
    this.NQA = new AtomicLong(-5000000L);
    this.iFy = paramh;
    gAU();
    AppMethodBeat.o(124624);
  }
  
  private void MY(long paramLong)
  {
    try
    {
      AppMethodBeat.i(124646);
      this.NQx = Math.max(paramLong, this.NQx);
      AppMethodBeat.o(124646);
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  private void gAU()
  {
    for (;;)
    {
      try
      {
        AppMethodBeat.i(124649);
        this.NQx = (gAV() >> 32);
        if (this.NQx < 10L) {
          this.NQx = 10L;
        }
        z localz = gAM();
        if (localz == null)
        {
          Log.w("MicroMsg.BizTimeLineInfoStorage", "initGroupId is null, id %d", new Object[] { Long.valueOf(this.NQx) });
          AppMethodBeat.o(124649);
          return;
        }
        if (localz.field_status == 4)
        {
          this.NQw.set(this.NQx + 1L);
          this.NQy = this.NQw.longValue();
          Log.i("MicroMsg.BizTimeLineInfoStorage", "initGroupId id %d/%d, status %d", new Object[] { Long.valueOf(this.NQw.longValue()), Long.valueOf(this.NQx), Integer.valueOf(localz.field_status) });
          AppMethodBeat.o(124649);
        }
        else
        {
          this.NQw.set(this.NQx);
        }
      }
      finally {}
    }
  }
  
  private long gAV()
  {
    try
    {
      AppMethodBeat.i(124651);
      Cursor localCursor = this.iFy.rawQuery("select max(orderFlag) from BizTimeLineInfo", null, 2);
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
  
  public static List<z> o(Cursor paramCursor)
  {
    AppMethodBeat.i(124635);
    LinkedList localLinkedList = new LinkedList();
    while (paramCursor.moveToNext())
    {
      z localz = new z();
      localz.convertFrom(paramCursor);
      localLinkedList.add(localz);
    }
    paramCursor.close();
    AppMethodBeat.o(124635);
    return localLinkedList;
  }
  
  public final boolean B(z paramz)
  {
    AppMethodBeat.i(124625);
    boolean bool = b(paramz, true);
    AppMethodBeat.o(124625);
    return bool;
  }
  
  public final boolean C(z paramz)
  {
    AppMethodBeat.i(124626);
    boolean bool = super.updateNotify(paramz, false, new String[] { "msgSvrId" });
    a locala = new a();
    locala.talker = paramz.field_talker;
    locala.psm = paramz;
    locala.NQE = b.NQI;
    a(locala);
    AppMethodBeat.o(124626);
    return bool;
  }
  
  public final boolean D(z paramz)
  {
    AppMethodBeat.i(212340);
    Object localObject = new ContentValues();
    ((ContentValues)localObject).put("content", paramz.field_content);
    ((ContentValues)localObject).put("createTime", Long.valueOf(paramz.field_createTime));
    int i = this.iFy.update("BizTimeLineInfo", (ContentValues)localObject, " msgId = ?", new String[] { paramz.field_msgId });
    if (i > 0)
    {
      localObject = new a();
      ((a)localObject).talker = paramz.field_talker;
      ((a)localObject).list = new LinkedList();
      ((a)localObject).list.add(paramz);
      ((a)localObject).NQE = b.NQI;
      a((a)localObject);
    }
    if (i > 0)
    {
      AppMethodBeat.o(212340);
      return true;
    }
    AppMethodBeat.o(212340);
    return false;
  }
  
  public final z ML(long paramLong)
  {
    AppMethodBeat.i(124629);
    z localz = R(paramLong, "orderFlag");
    AppMethodBeat.o(124629);
    return localz;
  }
  
  public final z MM(long paramLong)
  {
    AppMethodBeat.i(258699);
    z localz = R(paramLong, "msgId");
    AppMethodBeat.o(258699);
    return localz;
  }
  
  public final List<z> MN(long paramLong)
  {
    AppMethodBeat.i(212344);
    List localList = o(this.iFy.query("BizTimeLineInfo", null, "orderFlag>?", new String[] { String.valueOf(paramLong) }, null, null, "orderFlag DESC limit 5"));
    AppMethodBeat.o(212344);
    return localList;
  }
  
  public final List<z> MO(long paramLong)
  {
    AppMethodBeat.i(124634);
    List localList = o(this.iFy.query("BizTimeLineInfo", null, "orderFlag>=?", new String[] { String.valueOf(paramLong) }, null, null, "orderFlag DESC"));
    AppMethodBeat.o(124634);
    return localList;
  }
  
  public final z MP(long paramLong)
  {
    z localz = null;
    AppMethodBeat.i(124637);
    Object localObject = "SELECT * FROM BizTimeLineInfo where talkerId = " + paramLong + "  order by orderFlag DESC limit 1";
    localObject = this.iFy.rawQuery((String)localObject, null);
    if (((Cursor)localObject).moveToFirst())
    {
      localz = new z();
      localz.convertFrom((Cursor)localObject);
    }
    ((Cursor)localObject).close();
    AppMethodBeat.o(124637);
    return localz;
  }
  
  public final void MQ(long paramLong)
  {
    AppMethodBeat.i(124638);
    if (MR(paramLong) > 2000)
    {
      localObject = ML(paramLong);
      if (localObject != null)
      {
        ((z)localObject).field_status = 4;
        C((z)localObject);
      }
      AppMethodBeat.o(124638);
      return;
    }
    long l1 = System.currentTimeMillis();
    long l2 = 0x0 & paramLong;
    Object localObject = "update BizTimeLineInfo set status = 4 where orderFlag >= " + l2 + " and status > 4";
    this.iFy.execSQL("BizTimeLineInfo", (String)localObject);
    localObject = "update BizTimeLineInfo set status = 4 where orderFlag >= " + l2 + " and status < 4";
    this.iFy.execSQL("BizTimeLineInfo", (String)localObject);
    Log.d("MicroMsg.BizTimeLineInfoStorage", "resetUnread cost %d", new Object[] { Long.valueOf(System.currentTimeMillis() - l1) });
    NQu.x(Long.valueOf(paramLong), Boolean.TRUE);
    AppMethodBeat.o(124638);
  }
  
  public final int MR(long paramLong)
  {
    AppMethodBeat.i(124639);
    Object localObject = (Boolean)NQu.get(Long.valueOf(paramLong));
    if ((localObject != null) && (((Boolean)localObject).booleanValue()))
    {
      AppMethodBeat.o(124639);
      return 0;
    }
    long l1 = System.currentTimeMillis();
    long l2 = 0x0 & paramLong;
    localObject = "SELECT count(*) FROM BizTimeLineInfo where orderFlag >= " + l2 + " and status > 4";
    localObject = this.iFy.rawQuery((String)localObject, null);
    if (((Cursor)localObject).moveToFirst()) {}
    for (int j = ((Cursor)localObject).getInt(0);; j = 0)
    {
      ((Cursor)localObject).close();
      localObject = "SELECT count(*) FROM BizTimeLineInfo where orderFlag >= " + l2 + " and status < 4";
      localObject = this.iFy.rawQuery((String)localObject, null);
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
        NQu.x(Long.valueOf(paramLong), Boolean.TRUE);
      }
      Log.d("MicroMsg.BizTimeLineInfoStorage", "getUnread cost %d", new Object[] { Long.valueOf(System.currentTimeMillis() - l1) });
      AppMethodBeat.o(124639);
      return j;
    }
  }
  
  public final int MS(long paramLong)
  {
    int i = 0;
    AppMethodBeat.i(212352);
    Object localObject = "SELECT count(*) FROM BizTimeLineInfo where orderFlag >= ".concat(String.valueOf(paramLong << 32));
    localObject = this.iFy.rawQuery((String)localObject, null);
    if (((Cursor)localObject).moveToFirst()) {
      i = ((Cursor)localObject).getInt(0);
    }
    ((Cursor)localObject).close();
    AppMethodBeat.o(212352);
    return i;
  }
  
  public final int MT(long paramLong)
  {
    int i = 0;
    AppMethodBeat.i(212353);
    Object localObject = "SELECT count(*) FROM BizTimeLineInfo where type = 620757041 and orderFlag < " + (paramLong << 32) + " and orderFlag >= " + (paramLong - 1L << 32);
    localObject = this.iFy.rawQuery((String)localObject, null);
    if (((Cursor)localObject).moveToFirst()) {
      i = ((Cursor)localObject).getInt(0);
    }
    ((Cursor)localObject).close();
    AppMethodBeat.o(212353);
    return i;
  }
  
  public final z MU(long paramLong)
  {
    AppMethodBeat.i(212354);
    Object localObject = "SELECT * FROM BizTimeLineInfo where orderFlag < " + (paramLong << 32) + " ORDER BY orderFlag desc LIMIT 1 ";
    localObject = this.iFy.rawQuery((String)localObject, null);
    z localz = new z();
    if (((Cursor)localObject).moveToFirst())
    {
      localz.convertFrom((Cursor)localObject);
      ((Cursor)localObject).close();
      AppMethodBeat.o(212354);
      return localz;
    }
    ((Cursor)localObject).close();
    AppMethodBeat.o(212354);
    return null;
  }
  
  public final void MV(final long paramLong)
  {
    AppMethodBeat.i(124641);
    com.tencent.mm.co.g.hio().h(new a() {}).b(new a() {});
    AppMethodBeat.o(124641);
  }
  
  public final int MW(long paramLong)
  {
    AppMethodBeat.i(124643);
    long l = System.currentTimeMillis();
    Object localObject = "SELECT count(*) FROM BizTimeLineInfo where orderFlag >= " + (0x0 & paramLong) + " and hasShow < 1 ";
    localObject = this.iFy.rawQuery((String)localObject, null);
    if (((Cursor)localObject).moveToFirst()) {}
    for (int i = ((Cursor)localObject).getInt(0);; i = 0)
    {
      Log.d("MicroMsg.BizTimeLineInfoStorage", "getUnShowCount count = %d,cost = %d", new Object[] { Integer.valueOf(i), Long.valueOf(System.currentTimeMillis() - l) });
      ((Cursor)localObject).close();
      if (i > 2000)
      {
        if (this.NQy == this.NQw.longValue()) {
          gAT();
        }
        AppMethodBeat.o(124643);
        return 0;
      }
      AppMethodBeat.o(124643);
      return i;
    }
  }
  
  public final void MX(long paramLong)
  {
    AppMethodBeat.i(124645);
    Object localObject = new z();
    ((z)localObject).field_msgId = paramLong;
    super.delete((IAutoDBItem)localObject, false, new String[] { "msgId" });
    localObject = new a();
    ((a)localObject).NQE = b.NQH;
    a((a)localObject);
    AppMethodBeat.o(124645);
  }
  
  public final z MZ(long paramLong)
  {
    z localz = null;
    AppMethodBeat.i(124653);
    Object localObject = "SELECT * FROM BizTimeLineInfo where type=620757041 and orderFlag > ".concat(String.valueOf(paramLong));
    localObject = this.iFy.rawQuery((String)localObject, null);
    if (((Cursor)localObject).moveToFirst())
    {
      localz = new z();
      localz.convertFrom((Cursor)localObject);
    }
    ((Cursor)localObject).close();
    AppMethodBeat.o(124653);
    return localz;
  }
  
  public final z R(long paramLong, String paramString)
  {
    AppMethodBeat.i(124631);
    z localz = new z();
    paramString = this.iFy.query("BizTimeLineInfo", null, paramString + "=?", new String[] { String.valueOf(paramLong) }, null, null, null, 2);
    if (paramString.moveToFirst())
    {
      localz.convertFrom(paramString);
      paramString.close();
      AppMethodBeat.o(124631);
      return localz;
    }
    paramString.close();
    AppMethodBeat.o(124631);
    return null;
  }
  
  public final void a(a parama)
  {
    AppMethodBeat.i(124621);
    if (this.NQt.event(parama)) {
      this.NQt.doNotify();
    }
    AppMethodBeat.o(124621);
  }
  
  public final void a(c paramc)
  {
    AppMethodBeat.i(124623);
    this.NQt.remove(paramc);
    AppMethodBeat.o(124623);
  }
  
  public final void a(c paramc, Looper paramLooper)
  {
    AppMethodBeat.i(124622);
    this.NQt.add(paramc, paramLooper);
    AppMethodBeat.o(124622);
  }
  
  public final boolean aEn(String paramString)
  {
    AppMethodBeat.i(124644);
    z localz = new z();
    localz.field_talker = paramString;
    boolean bool = super.delete(localz, false, new String[] { "talker" });
    paramString = new a();
    paramString.talker = localz.field_talker;
    paramString.psm = localz;
    paramString.NQE = b.NQH;
    a(paramString);
    AppMethodBeat.o(124644);
    return bool;
  }
  
  public final List<z> aU(int paramInt, long paramLong)
  {
    AppMethodBeat.i(124632);
    Object localObject = this.iFy;
    String str = "orderFlag DESC limit ".concat(String.valueOf(paramInt));
    localObject = o(((com.tencent.mm.storagebase.h)localObject).query("BizTimeLineInfo", null, "orderFlag<?", new String[] { String.valueOf(paramLong) }, null, null, str));
    AppMethodBeat.o(124632);
    return localObject;
  }
  
  public final List<z> aV(int paramInt, long paramLong)
  {
    AppMethodBeat.i(212348);
    long l1 = gAS();
    long l2 = System.currentTimeMillis();
    String str = "SELECT * FROM BizTimeLineInfo where  isRead = 0 and orderFlag >= " + (l1 << 32) + " and createTime >= " + paramLong + " and bitFlag&1073741824 = 0 order by orderFlag ASC limit " + paramInt;
    Log.d("MicroMsg.BizTimeLineInfoStorage", "getUnReadListNew sql = %s", new Object[] { str });
    List localList = o(this.iFy.rawQuery(str, null));
    int j = localList.size();
    if (j < paramInt)
    {
      str = "";
      if (j > 0)
      {
        str = "and msgId not in (";
        int i = 0;
        if (i < j)
        {
          StringBuilder localStringBuilder = new StringBuilder().append(str);
          if (i > 0) {}
          for (str = ",";; str = "")
          {
            str = str + ((z)localList.get(i)).field_msgId;
            i += 1;
            break;
          }
        }
        str = str + ")";
      }
      str = "SELECT * FROM BizTimeLineInfo where  isRead = 0 " + str + " order by orderFlag DESC limit " + (paramInt - j);
      Log.d("MicroMsg.BizTimeLineInfoStorage", "getUnReadListNew sql2 = %s", new Object[] { str });
      localList.addAll(o(this.iFy.rawQuery(str, null)));
    }
    Log.d("MicroMsg.BizTimeLineInfoStorage", "getUnReadListNew cost %d", new Object[] { Long.valueOf(System.currentTimeMillis() - l2) });
    AppMethodBeat.o(212348);
    return localList;
  }
  
  public final List<z> ajT(int paramInt)
  {
    AppMethodBeat.i(124633);
    List localList = o(this.iFy.query("BizTimeLineInfo", null, null, null, null, null, "orderFlag DESC limit ".concat(String.valueOf(paramInt))));
    AppMethodBeat.o(124633);
    return localList;
  }
  
  public final List<z> ajU(int paramInt)
  {
    AppMethodBeat.i(212347);
    long l = System.currentTimeMillis();
    Object localObject = this.iFy;
    String str = "orderFlag DESC limit ".concat(String.valueOf(paramInt));
    localObject = o(((com.tencent.mm.storagebase.h)localObject).query("BizTimeLineInfo", null, "isRead=?", new String[] { "0" }, null, null, str));
    Log.d("MicroMsg.BizTimeLineInfoStorage", "getUnReadList cost %d", new Object[] { Long.valueOf(System.currentTimeMillis() - l) });
    AppMethodBeat.o(212347);
    return localObject;
  }
  
  public final z ajV(int paramInt)
  {
    Object localObject3 = null;
    AppMethodBeat.i(212355);
    Object localObject1 = "SELECT * FROM BizTimeLineInfo order by orderFlag DESC limit 1 offset ".concat(String.valueOf(paramInt));
    Object localObject2 = this.iFy.rawQuery((String)localObject1, null);
    if (((Cursor)localObject2).moveToFirst())
    {
      localObject1 = new z();
      ((z)localObject1).convertFrom((Cursor)localObject2);
    }
    for (;;)
    {
      ((Cursor)localObject2).close();
      if (localObject1 != null)
      {
        localObject2 = localObject1;
        if (((z)localObject1).gAo() >= gAS()) {}
      }
      else
      {
        long l = gAS();
        localObject1 = "SELECT * FROM BizTimeLineInfo where orderFlag > " + (l << 32) + " order by orderFlag asc limit 1";
        localObject2 = this.iFy.rawQuery((String)localObject1, null);
        localObject1 = localObject3;
        if (((Cursor)localObject2).moveToFirst())
        {
          localObject1 = new z();
          ((z)localObject1).convertFrom((Cursor)localObject2);
        }
        ((Cursor)localObject2).close();
        localObject2 = localObject1;
      }
      AppMethodBeat.o(212355);
      return localObject2;
      localObject1 = null;
    }
  }
  
  public final z ajW(int paramInt)
  {
    z localz = null;
    AppMethodBeat.i(212356);
    Object localObject = "SELECT * FROM BizTimeLineInfo order by orderFlag DESC limit 1 offset ".concat(String.valueOf(paramInt));
    localObject = this.iFy.rawQuery((String)localObject, null);
    if (((Cursor)localObject).moveToFirst())
    {
      localz = new z();
      localz.convertFrom((Cursor)localObject);
    }
    ((Cursor)localObject).close();
    AppMethodBeat.o(212356);
    return localz;
  }
  
  public final void ajX(int paramInt)
  {
    AppMethodBeat.i(212357);
    Object localObject = String.format("DELETE FROM %s WHERE %s = %d and isRead = %d", new Object[] { "BizTimeLineInfo", "type", Integer.valueOf(637534257), Integer.valueOf(paramInt) });
    Log.i("MicroMsg.BizTimeLineInfoStorage", "deleteByType type:%d ret:%b", new Object[] { Integer.valueOf(637534257), Boolean.valueOf(this.iFy.execSQL("BizTimeLineInfo", (String)localObject)) });
    localObject = new a();
    ((a)localObject).NQE = b.NQH;
    a((a)localObject);
    AppMethodBeat.o(212357);
  }
  
  public final boolean b(z paramz, boolean paramBoolean)
  {
    AppMethodBeat.i(212338);
    boolean bool = super.insertNotify(paramz, false);
    if (paramBoolean) {
      MY(paramz.gAo());
    }
    a locala = new a();
    locala.talker = paramz.field_talker;
    locala.psm = paramz;
    locala.NQE = b.NQG;
    a(locala);
    AppMethodBeat.o(212338);
    return bool;
  }
  
  public final void biW(String paramString)
  {
    AppMethodBeat.i(124627);
    if (Util.isNullOrNil(paramString))
    {
      AppMethodBeat.o(124627);
      return;
    }
    if (((l)com.tencent.mm.kernel.g.af(l.class)).aSN().Kn(paramString).arE()) {}
    for (int i = 1;; i = 0)
    {
      Object localObject = "update BizTimeLineInfo set placeTop = " + i + " where status > 4 and talker = '" + paramString + "'";
      this.iFy.execSQL("BizTimeLineInfo", (String)localObject);
      localObject = "update BizTimeLineInfo set placeTop = " + i + " where status < 4 and talker = '" + paramString + "'";
      this.iFy.execSQL("BizTimeLineInfo", (String)localObject);
      localObject = gAM();
      if ((localObject != null) && (paramString.equals(((z)localObject).field_talker)))
      {
        ((z)localObject).field_placeTop = i;
        super.updateNotify((IAutoDBItem)localObject, false, new String[] { "msgSvrId" });
      }
      paramString = new a();
      paramString.NQE = b.NQI;
      a(paramString);
      AppMethodBeat.o(124627);
      return;
    }
  }
  
  public final z biX(String paramString)
  {
    AppMethodBeat.i(212342);
    if (Util.isNullOrNil(paramString))
    {
      AppMethodBeat.o(212342);
      return null;
    }
    z localz = new z();
    paramString = this.iFy.query("BizTimeLineInfo", null, "bizClientMsgId=?", new String[] { String.valueOf(paramString) }, null, null, null, 2);
    if (paramString.moveToFirst())
    {
      localz.convertFrom(paramString);
      paramString.close();
      AppMethodBeat.o(212342);
      return localz;
    }
    paramString.close();
    AppMethodBeat.o(212342);
    return null;
  }
  
  public final z biY(String paramString)
  {
    Object localObject = null;
    AppMethodBeat.i(212358);
    if (paramString == null)
    {
      AppMethodBeat.o(212358);
      return null;
    }
    paramString = "SELECT * FROM BizTimeLineInfo where type=620757041 and recommendCardId='" + paramString + "'";
    Cursor localCursor = this.iFy.rawQuery(paramString, null);
    paramString = localObject;
    if (localCursor.moveToFirst())
    {
      paramString = new z();
      paramString.convertFrom(localCursor);
    }
    localCursor.close();
    AppMethodBeat.o(212358);
    return paramString;
  }
  
  public final boolean c(z paramz, boolean paramBoolean)
  {
    AppMethodBeat.i(212339);
    boolean bool = super.updateNotify(paramz, false, new String[] { "msgId" });
    if (paramBoolean)
    {
      a locala = new a();
      locala.talker = paramz.field_talker;
      locala.psm = paramz;
      locala.NQE = b.NQI;
      a(locala);
    }
    AppMethodBeat.o(212339);
    return bool;
  }
  
  public final int cZm()
  {
    int i = 0;
    AppMethodBeat.i(124650);
    Cursor localCursor = this.iFy.rawQuery("SELECT count(*) FROM BizTimeLineInfo", null);
    if (localCursor.moveToFirst()) {
      i = localCursor.getInt(0);
    }
    localCursor.close();
    AppMethodBeat.o(124650);
    return i;
  }
  
  public final z gAL()
  {
    z localz = null;
    AppMethodBeat.i(212346);
    Object localObject = String.format("SELECT * FROM %s WHERE %s = %d order by %s  DESC limit 1", new Object[] { "BizTimeLineInfo", "type", Integer.valueOf(637534257), "orderFlag" });
    localObject = this.iFy.rawQuery((String)localObject, null);
    if (((Cursor)localObject).moveToFirst())
    {
      localz = new z();
      localz.convertFrom((Cursor)localObject);
    }
    ((Cursor)localObject).close();
    AppMethodBeat.o(212346);
    return localz;
  }
  
  public final z gAM()
  {
    z localz = null;
    AppMethodBeat.i(124636);
    Cursor localCursor = this.iFy.rawQuery("SELECT * FROM BizTimeLineInfo order by orderFlag DESC limit 1", null);
    if (localCursor.moveToFirst())
    {
      localz = new z();
      localz.convertFrom(localCursor);
    }
    localCursor.close();
    AppMethodBeat.o(124636);
    return localz;
  }
  
  public final z gAN()
  {
    z localz = null;
    AppMethodBeat.i(212349);
    Cursor localCursor = this.iFy.rawQuery("SELECT * FROM BizTimeLineInfo order by createTime DESC limit 1", null);
    if (localCursor.moveToFirst())
    {
      localz = new z();
      localz.convertFrom(localCursor);
    }
    localCursor.close();
    AppMethodBeat.o(212349);
    return localz;
  }
  
  public final long gAO()
  {
    AppMethodBeat.i(212350);
    Cursor localCursor = this.iFy.rawQuery("SELECT createTime FROM BizTimeLineInfo order by createTime DESC limit 1", null);
    long l = 0L;
    if (localCursor.moveToFirst()) {
      l = localCursor.getLong(0);
    }
    localCursor.close();
    AppMethodBeat.o(212350);
    return l;
  }
  
  public final z gAP()
  {
    z localz = null;
    AppMethodBeat.i(212351);
    Cursor localCursor = this.iFy.rawQuery("SELECT * FROM BizTimeLineInfo order by orderFlag asc limit 1", null);
    if (localCursor.moveToFirst())
    {
      localz = new z();
      localz.convertFrom(localCursor);
    }
    localCursor.close();
    AppMethodBeat.o(212351);
    return localz;
  }
  
  public final void gAQ()
  {
    AppMethodBeat.i(124640);
    z localz = gAM();
    if (localz == null)
    {
      AppMethodBeat.o(124640);
      return;
    }
    MV(localz.field_orderFlag);
    AppMethodBeat.o(124640);
  }
  
  public final int gAR()
  {
    AppMethodBeat.i(124642);
    z localz = gAM();
    if (localz == null)
    {
      AppMethodBeat.o(124642);
      return 0;
    }
    int i = MW(localz.field_orderFlag);
    AppMethodBeat.o(124642);
    return i;
  }
  
  public final long gAS()
  {
    try
    {
      long l = this.NQx;
      return l;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public final long gAT()
  {
    try
    {
      AppMethodBeat.i(124648);
      long l = this.NQw.incrementAndGet();
      AppMethodBeat.o(124648);
      return l;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public final long gAW()
  {
    z localz = null;
    try
    {
      AppMethodBeat.i(124652);
      if (this.NQA.longValue() == -5000000L)
      {
        Cursor localCursor = this.iFy.rawQuery("SELECT * FROM BizTimeLineInfo where type=620757041 or type=637534257 order by msgId DESC limit 1", null);
        if (localCursor.moveToFirst())
        {
          localz = new z();
          localz.convertFrom(localCursor);
        }
        localCursor.close();
        if (localz != null) {
          this.NQA.set(localz.field_msgId);
        }
      }
      long l = this.NQA.incrementAndGet();
      AppMethodBeat.o(124652);
      return l;
    }
    finally {}
  }
  
  public final long gAo()
  {
    try
    {
      AppMethodBeat.i(124647);
      long l = this.NQw.longValue();
      AppMethodBeat.o(124647);
      return l;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public final boolean iD(List<z> paramList)
  {
    AppMethodBeat.i(212341);
    if (Util.isNullOrNil(paramList))
    {
      AppMethodBeat.o(212341);
      return false;
    }
    long l = this.iFy.beginTransaction(Thread.currentThread().getId());
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      z localz = (z)paramList.next();
      ContentValues localContentValues = new ContentValues();
      localContentValues.put("orderFlag", Long.valueOf(localz.field_orderFlag));
      localContentValues.put("bitFlag", Integer.valueOf(localz.field_bitFlag));
      localContentValues.put("status", Integer.valueOf(3));
      if (localz.NQl)
      {
        localContentValues.put("hasShow", Integer.valueOf(0));
        localContentValues.put("isRead", Integer.valueOf(0));
      }
      localContentValues.put("rankSessionId", localz.field_rankSessionId);
      this.iFy.update("BizTimeLineInfo", localContentValues, "msgId = ?", new String[] { localz.field_msgId });
    }
    Log.i("MicroMsg.BizTimeLineInfoStorage", "batResortBizTimeLineInfo ret=%d", new Object[] { Integer.valueOf(this.iFy.endTransaction(l)) });
    com.tencent.f.h.RTc.aV(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(212336);
        aa.a locala = new aa.a();
        locala.NQE = aa.b.NQJ;
        aa.this.a(locala);
        AppMethodBeat.o(212336);
      }
    });
    AppMethodBeat.o(212341);
    return true;
  }
  
  public final List<z> kL(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(212345);
    Object localObject = this.iFy;
    String str = "orderFlag DESC limit ".concat(String.valueOf(paramInt2));
    localObject = o(((com.tencent.mm.storagebase.h)localObject).query("BizTimeLineInfo", null, "type=?", new String[] { String.valueOf(paramInt1) }, null, null, str));
    AppMethodBeat.o(212345);
    return localObject;
  }
  
  public static final class a
  {
    public aa.b NQE = aa.b.NQG;
    public boolean NQF = false;
    public List<z> list;
    public z psm;
    public String talker;
  }
  
  public static enum b
  {
    static
    {
      AppMethodBeat.i(124620);
      NQG = new b("INSERT", 0);
      NQH = new b("DELETE", 1);
      NQI = new b("UPDATE", 2);
      NQJ = new b("RE_SORT", 3);
      NQK = new b[] { NQG, NQH, NQI, NQJ };
      AppMethodBeat.o(124620);
    }
    
    private b() {}
  }
  
  public static abstract interface c
  {
    public abstract void a(Object paramObject, aa.a parama);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.storage.aa
 * JD-Core Version:    0.7.0.1
 */