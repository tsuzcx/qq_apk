package com.tencent.mm.storage;

import android.content.ContentValues;
import android.database.Cursor;
import android.os.Looper;
import com.tencent.e.i;
import com.tencent.mars.smc.IDKey;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cw.g;
import com.tencent.mm.memory.a.c;
import com.tencent.mm.plugin.messenger.foundation.a.n;
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
  public static final String[] SQL_CREATE;
  public static final String[] Veo;
  private static final com.tencent.mm.b.f<Long, Boolean> Veq;
  private final MStorageEvent<c, a> Vep;
  int Ver;
  public boolean Ves;
  private AtomicLong Vet;
  private long Veu;
  private long Vev;
  private final long Vew;
  private AtomicLong Vex;
  public final com.tencent.mm.storagebase.h lvy;
  
  static
  {
    AppMethodBeat.i(124655);
    SQL_CREATE = new String[] { MAutoStorage.getCreateSQLs(z.info, "BizTimeLineInfo") };
    INDEX_CREATE = new String[] { "CREATE  INDEX IF NOT EXISTS msg_id_index ON BizTimeLineInfo ( msgId ) ", "CREATE  INDEX IF NOT EXISTS  has_show_talker_index ON BizTimeLineInfo ( hasShow,talker ) ", "CREATE  INDEX IF NOT EXISTS  has_show_place_top_index ON BizTimeLineInfo ( hasShow,placeTop ) ", "CREATE  INDEX IF NOT EXISTS  order_flag_place_top_index ON BizTimeLineInfo ( orderFlag,placeTop ) ", "CREATE  INDEX IF NOT EXISTS  talker_id_order_flag_index ON BizTimeLineInfo ( talkerId,orderFlag ) " };
    Veo = new String[] { "CREATE  INDEX IF NOT EXISTS  biz_status_talker_index ON BizTimeLineInfo ( status,talker ) ", "CREATE  INDEX IF NOT EXISTS  biz_msg_svr_id_index ON BizTimeLineInfo ( msgSvrId ) ", "CREATE  INDEX IF NOT EXISTS  biz_talker_index ON BizTimeLineInfo ( talker ) ", "CREATE  INDEX IF NOT EXISTS  order_flag_status_index ON BizTimeLineInfo ( orderFlag,status ) ", "CREATE  INDEX IF NOT EXISTS  order_flag_has_show_index ON BizTimeLineInfo ( orderFlag,hasShow ) ", "CREATE  INDEX IF NOT EXISTS  is_read_order_flag_index ON BizTimeLineInfo ( isRead,orderFlag ) ", "CREATE  INDEX IF NOT EXISTS  is_read_msg_id_index ON BizTimeLineInfo ( isRead,msgId ) ", "CREATE  INDEX IF NOT EXISTS  biz_type_order_flag_isread_index ON BizTimeLineInfo ( type,orderFlag,isRead ) ", "CREATE  INDEX IF NOT EXISTS  biz_type_is_read_index ON BizTimeLineInfo ( type,isRead ) ", "CREATE  INDEX IF NOT EXISTS  biz_create_time_index ON BizTimeLineInfo ( createTime ) ", "CREATE  INDEX IF NOT EXISTS  recommend_card_id_index ON BizTimeLineInfo ( recommendCardId ) " };
    Veq = new c(30);
    AppMethodBeat.o(124655);
  }
  
  public aa(com.tencent.mm.storagebase.h paramh)
  {
    super(paramh, z.info, "BizTimeLineInfo", INDEX_CREATE);
    AppMethodBeat.i(124624);
    this.Vep = new MStorageEvent() {};
    this.Ver = 100;
    this.Ves = true;
    this.Vet = new AtomicLong(10L);
    this.Veu = 10L;
    this.Vew = -5000000L;
    this.Vex = new AtomicLong(-5000000L);
    this.lvy = paramh;
    hxd();
    AppMethodBeat.o(124624);
  }
  
  private void UJ(long paramLong)
  {
    try
    {
      AppMethodBeat.i(124646);
      this.Veu = Math.max(paramLong, this.Veu);
      AppMethodBeat.o(124646);
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  private void hxd()
  {
    for (;;)
    {
      try
      {
        AppMethodBeat.i(124649);
        this.Veu = (hxe() >> 32);
        if (this.Veu < 10L) {
          this.Veu = 10L;
        }
        z localz = hwU();
        if (localz == null)
        {
          Log.w("MicroMsg.BizTimeLineInfoStorage", "initGroupId is null, id %d", new Object[] { Long.valueOf(this.Veu) });
          AppMethodBeat.o(124649);
          return;
        }
        if (localz.field_status == 4)
        {
          this.Vet.set(this.Veu + 1L);
          this.Vev = this.Vet.longValue();
          Log.i("MicroMsg.BizTimeLineInfoStorage", "initGroupId id %d/%d, status %d", new Object[] { Long.valueOf(this.Vet.longValue()), Long.valueOf(this.Veu), Integer.valueOf(localz.field_status) });
          AppMethodBeat.o(124649);
        }
        else
        {
          this.Vet.set(this.Veu);
        }
      }
      finally {}
    }
  }
  
  private long hxe()
  {
    try
    {
      AppMethodBeat.i(124651);
      Cursor localCursor = this.lvy.rawQuery("select max(orderFlag) from BizTimeLineInfo", null, 2);
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
  
  public static List<z> r(Cursor paramCursor)
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
  
  public final boolean F(z paramz)
  {
    AppMethodBeat.i(124625);
    boolean bool = c(paramz, true);
    AppMethodBeat.o(124625);
    return bool;
  }
  
  public final boolean G(z paramz)
  {
    AppMethodBeat.i(124626);
    boolean bool = super.updateNotify(paramz, false, new String[] { "msgSvrId" });
    a locala = new a();
    locala.talker = paramz.field_talker;
    locala.sBt = paramz;
    locala.VeB = b.VeF;
    a(locala);
    AppMethodBeat.o(124626);
    return bool;
  }
  
  public final boolean H(z paramz)
  {
    AppMethodBeat.i(207518);
    Object localObject = new ContentValues();
    ((ContentValues)localObject).put("content", paramz.field_content);
    ((ContentValues)localObject).put("createTime", Long.valueOf(paramz.field_createTime));
    int i = this.lvy.update("BizTimeLineInfo", (ContentValues)localObject, " msgId = ?", new String[] { paramz.field_msgId });
    if (i > 0)
    {
      localObject = new a();
      ((a)localObject).talker = paramz.field_talker;
      ((a)localObject).list = new LinkedList();
      ((a)localObject).list.add(paramz);
      ((a)localObject).VeB = b.VeF;
      a((a)localObject);
    }
    if (i > 0)
    {
      AppMethodBeat.o(207518);
      return true;
    }
    AppMethodBeat.o(207518);
    return false;
  }
  
  public final z UA(long paramLong)
  {
    z localz = null;
    AppMethodBeat.i(124637);
    Object localObject = "SELECT * FROM BizTimeLineInfo where talkerId = " + paramLong + "  order by orderFlag DESC limit 1";
    localObject = this.lvy.rawQuery((String)localObject, null);
    if (((Cursor)localObject).moveToFirst())
    {
      localz = new z();
      localz.convertFrom((Cursor)localObject);
    }
    ((Cursor)localObject).close();
    AppMethodBeat.o(124637);
    return localz;
  }
  
  public final void UB(long paramLong)
  {
    AppMethodBeat.i(124638);
    if (UC(paramLong) > 2000)
    {
      localObject = Uv(paramLong);
      if (localObject != null)
      {
        ((z)localObject).field_status = 4;
        G((z)localObject);
      }
      AppMethodBeat.o(124638);
      return;
    }
    long l1 = System.currentTimeMillis();
    long l2 = 0x0 & paramLong;
    Object localObject = "update BizTimeLineInfo set status = 4 where orderFlag >= " + l2 + " and status > 4";
    this.lvy.execSQL("BizTimeLineInfo", (String)localObject);
    localObject = "update BizTimeLineInfo set status = 4 where orderFlag >= " + l2 + " and status < 4";
    this.lvy.execSQL("BizTimeLineInfo", (String)localObject);
    Log.d("MicroMsg.BizTimeLineInfoStorage", "resetUnread cost %d", new Object[] { Long.valueOf(System.currentTimeMillis() - l1) });
    Veq.q(Long.valueOf(paramLong), Boolean.TRUE);
    AppMethodBeat.o(124638);
  }
  
  public final int UC(long paramLong)
  {
    AppMethodBeat.i(124639);
    Object localObject = (Boolean)Veq.get(Long.valueOf(paramLong));
    if ((localObject != null) && (((Boolean)localObject).booleanValue()))
    {
      AppMethodBeat.o(124639);
      return 0;
    }
    long l1 = System.currentTimeMillis();
    long l2 = 0x0 & paramLong;
    localObject = "SELECT count(*) FROM BizTimeLineInfo where orderFlag >= " + l2 + " and status > 4";
    localObject = this.lvy.rawQuery((String)localObject, null);
    if (((Cursor)localObject).moveToFirst()) {}
    for (int j = ((Cursor)localObject).getInt(0);; j = 0)
    {
      ((Cursor)localObject).close();
      localObject = "SELECT count(*) FROM BizTimeLineInfo where orderFlag >= " + l2 + " and status < 4";
      localObject = this.lvy.rawQuery((String)localObject, null);
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
        Veq.q(Long.valueOf(paramLong), Boolean.TRUE);
      }
      Log.d("MicroMsg.BizTimeLineInfoStorage", "getUnread cost %d", new Object[] { Long.valueOf(System.currentTimeMillis() - l1) });
      AppMethodBeat.o(124639);
      return j;
    }
  }
  
  public final int UD(long paramLong)
  {
    int i = 0;
    AppMethodBeat.i(207563);
    Object localObject = "SELECT count(*) FROM BizTimeLineInfo where orderFlag >= ".concat(String.valueOf(paramLong << 32));
    localObject = this.lvy.rawQuery((String)localObject, null);
    if (((Cursor)localObject).moveToFirst()) {
      i = ((Cursor)localObject).getInt(0);
    }
    ((Cursor)localObject).close();
    AppMethodBeat.o(207563);
    return i;
  }
  
  public final int UE(long paramLong)
  {
    int i = 0;
    AppMethodBeat.i(207565);
    Object localObject = "SELECT count(*) FROM BizTimeLineInfo where type = 620757041 and orderFlag < " + (paramLong << 32) + " and orderFlag >= " + (paramLong - 1L << 32);
    localObject = this.lvy.rawQuery((String)localObject, null);
    if (((Cursor)localObject).moveToFirst()) {
      i = ((Cursor)localObject).getInt(0);
    }
    ((Cursor)localObject).close();
    AppMethodBeat.o(207565);
    return i;
  }
  
  public final z UF(long paramLong)
  {
    AppMethodBeat.i(207566);
    Object localObject = "SELECT * FROM BizTimeLineInfo where orderFlag < " + (paramLong << 32) + " ORDER BY orderFlag desc LIMIT 1 ";
    localObject = this.lvy.rawQuery((String)localObject, null);
    z localz = new z();
    if (((Cursor)localObject).moveToFirst())
    {
      localz.convertFrom((Cursor)localObject);
      ((Cursor)localObject).close();
      AppMethodBeat.o(207566);
      return localz;
    }
    ((Cursor)localObject).close();
    AppMethodBeat.o(207566);
    return null;
  }
  
  public final void UG(final long paramLong)
  {
    AppMethodBeat.i(124641);
    g.ijP().h(new a() {}).b(new a() {});
    AppMethodBeat.o(124641);
  }
  
  public final int UH(long paramLong)
  {
    AppMethodBeat.i(124643);
    long l = System.currentTimeMillis();
    Object localObject = "SELECT count(*) FROM BizTimeLineInfo where orderFlag >= " + (0x0 & paramLong) + " and hasShow < 1 ";
    localObject = this.lvy.rawQuery((String)localObject, null);
    if (((Cursor)localObject).moveToFirst()) {}
    for (int i = ((Cursor)localObject).getInt(0);; i = 0)
    {
      Log.d("MicroMsg.BizTimeLineInfoStorage", "getUnShowCount count = %d,cost = %d", new Object[] { Integer.valueOf(i), Long.valueOf(System.currentTimeMillis() - l) });
      ((Cursor)localObject).close();
      if (i > 2000)
      {
        if (this.Vev == this.Vet.longValue()) {
          hxc();
        }
        AppMethodBeat.o(124643);
        return 0;
      }
      AppMethodBeat.o(124643);
      return i;
    }
  }
  
  public final void UI(long paramLong)
  {
    AppMethodBeat.i(124645);
    Object localObject = new z();
    ((z)localObject).field_msgId = paramLong;
    super.delete((IAutoDBItem)localObject, false, new String[] { "msgId" });
    localObject = new a();
    ((a)localObject).VeB = b.VeE;
    a((a)localObject);
    AppMethodBeat.o(124645);
  }
  
  public final z UK(long paramLong)
  {
    z localz = null;
    AppMethodBeat.i(124653);
    Object localObject = "SELECT * FROM BizTimeLineInfo where type=620757041 and orderFlag > ".concat(String.valueOf(paramLong));
    localObject = this.lvy.rawQuery((String)localObject, null);
    if (((Cursor)localObject).moveToFirst())
    {
      localz = new z();
      localz.convertFrom((Cursor)localObject);
    }
    ((Cursor)localObject).close();
    AppMethodBeat.o(124653);
    return localz;
  }
  
  public final z Uv(long paramLong)
  {
    AppMethodBeat.i(124629);
    z localz = ad(paramLong, "orderFlag");
    AppMethodBeat.o(124629);
    return localz;
  }
  
  public final z Uw(long paramLong)
  {
    AppMethodBeat.i(292866);
    z localz = ad(paramLong, "msgId");
    AppMethodBeat.o(292866);
    return localz;
  }
  
  public final List<z> Ux(long paramLong)
  {
    AppMethodBeat.i(207533);
    List localList = r(this.lvy.query("BizTimeLineInfo", null, "orderFlag>?", new String[] { String.valueOf(paramLong) }, null, null, "orderFlag DESC limit 5"));
    AppMethodBeat.o(207533);
    return localList;
  }
  
  public final List<z> Uy(long paramLong)
  {
    AppMethodBeat.i(124634);
    List localList = r(this.lvy.query("BizTimeLineInfo", null, "orderFlag>=?", new String[] { String.valueOf(paramLong) }, null, null, "orderFlag DESC"));
    AppMethodBeat.o(124634);
    return localList;
  }
  
  public final int Uz(long paramLong)
  {
    AppMethodBeat.i(207542);
    Object localObject = "SELECT count(*) FROM BizTimeLineInfo where isRead != 1 and orderFlag >= " + (paramLong & 0x0) + " and orderFlag < " + paramLong;
    localObject = this.lvy.rawQuery((String)localObject, null);
    if (((Cursor)localObject).moveToFirst()) {}
    for (int i = ((Cursor)localObject).getInt(0);; i = 0)
    {
      ((Cursor)localObject).close();
      if (i <= 0)
      {
        Log.i("MicroMsg.BizTimeLineInfoStorage", "getMaxWeightByOrderFlag unReadCount < 0");
        AppMethodBeat.o(207542);
        return -1;
      }
      localObject = String.format("SELECT orderFlag FROM %s WHERE isRead = 1 and orderFlag <= %d and orderFlag >= %d order by orderFlag ASC limit 1", new Object[] { "BizTimeLineInfo", Long.valueOf(paramLong), Long.valueOf(paramLong & 0x0) });
      localObject = this.lvy.rawQuery((String)localObject, null);
      if (((Cursor)localObject).moveToFirst()) {}
      for (i = (int)((((Cursor)localObject).getLong(0) & 0xFF000000) >> 24) - 1;; i = -1)
      {
        ((Cursor)localObject).close();
        if (i < 0) {
          Log.i("MicroMsg.BizTimeLineInfoStorage", "getMaxWeightByOrderFlag weight < 0");
        }
        AppMethodBeat.o(207542);
        return i;
      }
    }
  }
  
  public final void a(a parama)
  {
    AppMethodBeat.i(124621);
    if (this.Vep.event(parama)) {
      this.Vep.doNotify();
    }
    AppMethodBeat.o(124621);
  }
  
  public final void a(c paramc)
  {
    AppMethodBeat.i(124623);
    this.Vep.remove(paramc);
    AppMethodBeat.o(124623);
  }
  
  public final void a(c paramc, Looper paramLooper)
  {
    AppMethodBeat.i(124622);
    this.Vep.add(paramc, paramLooper);
    AppMethodBeat.o(124622);
  }
  
  public final boolean aOx(String paramString)
  {
    AppMethodBeat.i(124644);
    z localz = new z();
    localz.field_talker = paramString;
    boolean bool = super.delete(localz, false, new String[] { "talker" });
    paramString = new a();
    paramString.talker = localz.field_talker;
    paramString.sBt = localz;
    paramString.VeB = b.VeE;
    a(paramString);
    AppMethodBeat.o(124644);
    return bool;
  }
  
  public final z ad(long paramLong, String paramString)
  {
    AppMethodBeat.i(124631);
    z localz = new z();
    paramString = this.lvy.query("BizTimeLineInfo", null, paramString + "=?", new String[] { String.valueOf(paramLong) }, null, null, null, 2);
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
  
  public final List<z> aso(int paramInt)
  {
    AppMethodBeat.i(124633);
    List localList = r(this.lvy.query("BizTimeLineInfo", null, null, null, null, null, "orderFlag DESC limit ".concat(String.valueOf(paramInt))));
    AppMethodBeat.o(124633);
    return localList;
  }
  
  public final z asp(int paramInt)
  {
    Object localObject3 = null;
    AppMethodBeat.i(207589);
    Object localObject1 = "SELECT * FROM BizTimeLineInfo order by orderFlag DESC limit 1 offset ".concat(String.valueOf(paramInt));
    Object localObject2 = this.lvy.rawQuery((String)localObject1, null);
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
        if (((z)localObject1).hwv() >= hxb()) {}
      }
      else
      {
        long l = hxb();
        localObject1 = "SELECT * FROM BizTimeLineInfo where orderFlag > " + (l << 32) + " order by orderFlag asc limit 1";
        localObject2 = this.lvy.rawQuery((String)localObject1, null);
        localObject1 = localObject3;
        if (((Cursor)localObject2).moveToFirst())
        {
          localObject1 = new z();
          ((z)localObject1).convertFrom((Cursor)localObject2);
        }
        ((Cursor)localObject2).close();
        localObject2 = localObject1;
      }
      AppMethodBeat.o(207589);
      return localObject2;
      localObject1 = null;
    }
  }
  
  public final z asq(int paramInt)
  {
    z localz = null;
    AppMethodBeat.i(207596);
    Object localObject = "SELECT * FROM BizTimeLineInfo order by orderFlag DESC limit 1 offset ".concat(String.valueOf(paramInt));
    localObject = this.lvy.rawQuery((String)localObject, null);
    if (((Cursor)localObject).moveToFirst())
    {
      localz = new z();
      localz.convertFrom((Cursor)localObject);
    }
    ((Cursor)localObject).close();
    AppMethodBeat.o(207596);
    return localz;
  }
  
  public final void asr(int paramInt)
  {
    AppMethodBeat.i(207599);
    Object localObject = String.format("DELETE FROM %s WHERE %s = %d and isRead = %d", new Object[] { "BizTimeLineInfo", "type", Integer.valueOf(637534257), Integer.valueOf(paramInt) });
    Log.i("MicroMsg.BizTimeLineInfoStorage", "deleteByType type:%d ret:%b", new Object[] { Integer.valueOf(637534257), Boolean.valueOf(this.lvy.execSQL("BizTimeLineInfo", (String)localObject)) });
    localObject = new a();
    ((a)localObject).VeB = b.VeE;
    a((a)localObject);
    AppMethodBeat.o(207599);
  }
  
  public final List<z> bg(int paramInt, long paramLong)
  {
    AppMethodBeat.i(124632);
    Object localObject = this.lvy;
    String str = "orderFlag DESC limit ".concat(String.valueOf(paramInt));
    localObject = r(((com.tencent.mm.storagebase.h)localObject).query("BizTimeLineInfo", null, "orderFlag<?", new String[] { String.valueOf(paramLong) }, null, null, str));
    AppMethodBeat.o(124632);
    return localObject;
  }
  
  public final void bvs(String paramString)
  {
    AppMethodBeat.i(124627);
    if (Util.isNullOrNil(paramString))
    {
      AppMethodBeat.o(124627);
      return;
    }
    if (((n)com.tencent.mm.kernel.h.ae(n.class)).bbL().RG(paramString).ayn()) {}
    for (int i = 1;; i = 0)
    {
      Object localObject = "update BizTimeLineInfo set placeTop = " + i + " where status > 4 and talker = '" + paramString + "'";
      this.lvy.execSQL("BizTimeLineInfo", (String)localObject);
      localObject = "update BizTimeLineInfo set placeTop = " + i + " where status < 4 and talker = '" + paramString + "'";
      this.lvy.execSQL("BizTimeLineInfo", (String)localObject);
      localObject = hwU();
      if ((localObject != null) && (paramString.equals(((z)localObject).field_talker)))
      {
        ((z)localObject).field_placeTop = i;
        super.updateNotify((IAutoDBItem)localObject, false, new String[] { "msgSvrId" });
      }
      paramString = new a();
      paramString.VeB = b.VeF;
      a(paramString);
      AppMethodBeat.o(124627);
      return;
    }
  }
  
  public final z bvt(String paramString)
  {
    Object localObject = null;
    AppMethodBeat.i(207603);
    if (paramString == null)
    {
      AppMethodBeat.o(207603);
      return null;
    }
    paramString = "SELECT * FROM BizTimeLineInfo where type=620757041 and recommendCardId='" + paramString + "'";
    Cursor localCursor = this.lvy.rawQuery(paramString, null);
    paramString = localObject;
    if (localCursor.moveToFirst())
    {
      paramString = new z();
      paramString.convertFrom(localCursor);
    }
    localCursor.close();
    AppMethodBeat.o(207603);
    return paramString;
  }
  
  public final boolean c(z paramz, boolean paramBoolean)
  {
    AppMethodBeat.i(207515);
    boolean bool = super.insertNotify(paramz, false);
    if (paramBoolean) {
      UJ(paramz.hwv());
    }
    a locala = new a();
    locala.talker = paramz.field_talker;
    locala.sBt = paramz;
    locala.VeB = b.VeD;
    a(locala);
    AppMethodBeat.o(207515);
    return bool;
  }
  
  public final boolean d(z paramz, boolean paramBoolean)
  {
    AppMethodBeat.i(207517);
    boolean bool = super.updateNotify(paramz, false, new String[] { "msgId" });
    if (paramBoolean)
    {
      a locala = new a();
      locala.talker = paramz.field_talker;
      locala.sBt = paramz;
      locala.VeB = b.VeF;
      a(locala);
    }
    AppMethodBeat.o(207517);
    return bool;
  }
  
  public final int dpe()
  {
    int i = 0;
    AppMethodBeat.i(124650);
    Cursor localCursor = this.lvy.rawQuery("SELECT count(*) FROM BizTimeLineInfo", null);
    if (localCursor.moveToFirst()) {
      i = localCursor.getInt(0);
    }
    localCursor.close();
    AppMethodBeat.o(124650);
    return i;
  }
  
  public final List<z> g(int paramInt1, long paramLong1, long paramLong2, int paramInt2)
  {
    AppMethodBeat.i(207545);
    long l1 = hxb() << 32;
    long l2 = System.currentTimeMillis();
    Object localObject = ad.Vfe;
    if (ad.asx(paramInt2))
    {
      l1 = paramLong2 & 0x0;
      localObject = " and orderFlag < " + paramLong2 + " ";
    }
    for (paramLong2 = l1;; paramLong2 = l1)
    {
      String str = "SELECT * FROM BizTimeLineInfo where  isRead = 0 and orderFlag >= " + paramLong2 + (String)localObject + " and createTime >= " + paramLong1 + " and bitFlag&1073741824 = 0 order by orderFlag ASC limit " + paramInt1;
      Log.d("MicroMsg.BizTimeLineInfoStorage", "getUnReadListNew sql = %s", new Object[] { str });
      List localList = r(this.lvy.rawQuery(str, null));
      int i = localList.size();
      if (i < paramInt1)
      {
        str = "";
        if (i > 0)
        {
          str = "and msgId not in (";
          paramInt2 = 0;
          if (paramInt2 < i)
          {
            StringBuilder localStringBuilder = new StringBuilder().append(str);
            if (paramInt2 > 0) {}
            for (str = ",";; str = "")
            {
              str = str + ((z)localList.get(paramInt2)).field_msgId;
              paramInt2 += 1;
              break;
            }
          }
          str = str + ")";
        }
        localObject = "SELECT * FROM BizTimeLineInfo where  isRead = 0 " + (String)localObject + str + " order by orderFlag DESC limit " + (paramInt1 - i);
        Log.d("MicroMsg.BizTimeLineInfoStorage", "getUnReadListNew sql2 = %s", new Object[] { localObject });
        localList.addAll(r(this.lvy.rawQuery((String)localObject, null)));
      }
      Log.d("MicroMsg.BizTimeLineInfoStorage", "getUnReadListNew cost %d", new Object[] { Long.valueOf(System.currentTimeMillis() - l2) });
      AppMethodBeat.o(207545);
      return localList;
      localObject = "";
    }
  }
  
  public final z hwT()
  {
    z localz = null;
    AppMethodBeat.i(207541);
    Object localObject = String.format("SELECT * FROM %s WHERE %s = %d order by %s  DESC limit 1", new Object[] { "BizTimeLineInfo", "type", Integer.valueOf(637534257), "orderFlag" });
    localObject = this.lvy.rawQuery((String)localObject, null);
    if (((Cursor)localObject).moveToFirst())
    {
      localz = new z();
      localz.convertFrom((Cursor)localObject);
    }
    ((Cursor)localObject).close();
    AppMethodBeat.o(207541);
    return localz;
  }
  
  public final z hwU()
  {
    z localz = null;
    AppMethodBeat.i(124636);
    Cursor localCursor = this.lvy.rawQuery("SELECT * FROM BizTimeLineInfo order by orderFlag DESC limit 1", null);
    if (localCursor.moveToFirst())
    {
      localz = new z();
      localz.convertFrom(localCursor);
    }
    localCursor.close();
    AppMethodBeat.o(124636);
    return localz;
  }
  
  public final z hwV()
  {
    z localz = null;
    AppMethodBeat.i(207549);
    Cursor localCursor = this.lvy.rawQuery("SELECT * FROM BizTimeLineInfo where type !=637534257 order by createTime DESC limit 1", null);
    if (localCursor.moveToFirst())
    {
      localz = new z();
      localz.convertFrom(localCursor);
    }
    localCursor.close();
    AppMethodBeat.o(207549);
    return localz;
  }
  
  public final long hwW()
  {
    AppMethodBeat.i(207552);
    Cursor localCursor = this.lvy.rawQuery("SELECT createTime FROM BizTimeLineInfo where type !=637534257 order by createTime DESC limit 1", null);
    long l = 0L;
    if (localCursor.moveToFirst()) {
      l = localCursor.getLong(0);
    }
    localCursor.close();
    AppMethodBeat.o(207552);
    return l;
  }
  
  public final z hwX()
  {
    z localz = null;
    AppMethodBeat.i(207557);
    Cursor localCursor = this.lvy.rawQuery("SELECT * FROM BizTimeLineInfo order by orderFlag asc limit 1", null);
    if (localCursor.moveToFirst())
    {
      localz = new z();
      localz.convertFrom(localCursor);
    }
    localCursor.close();
    AppMethodBeat.o(207557);
    return localz;
  }
  
  public final void hwY()
  {
    AppMethodBeat.i(124640);
    z localz = hwU();
    if (localz == null)
    {
      AppMethodBeat.o(124640);
      return;
    }
    UG(localz.field_orderFlag);
    AppMethodBeat.o(124640);
  }
  
  public final int hwZ()
  {
    AppMethodBeat.i(124642);
    z localz = hwU();
    if (localz == null)
    {
      AppMethodBeat.o(124642);
      return 0;
    }
    int i = UH(localz.field_orderFlag);
    AppMethodBeat.o(124642);
    return i;
  }
  
  public final long hwv()
  {
    try
    {
      AppMethodBeat.i(124647);
      long l = this.Vet.longValue();
      AppMethodBeat.o(124647);
      return l;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public final void hxa()
  {
    AppMethodBeat.i(207575);
    com.tencent.e.h.ZvG.a(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(124611);
        int i = aa.this.dpe();
        if (i > 0)
        {
          Object localObject = aa.this;
          int j = ((aa)localObject).Ver;
          ((aa)localObject).Ver = (j - 1);
          if (j > 0)
          {
            Log.i("MicroMsg.BizTimeLineInfoStorage", "deleteTable start");
            localObject = String.format("DELETE FROM %s WHERE %s IN ( SELECT %s FROM %s ORDER BY %s LIMIT %d )", new Object[] { "BizTimeLineInfo", "orderFlag", "orderFlag", "BizTimeLineInfo", "orderFlag", Integer.valueOf(100) });
            Log.i("MicroMsg.BizTimeLineInfoStorage", "deleteTable end ret=%b", new Object[] { Boolean.valueOf(aa.a(aa.this).execSQL("BizTimeLineInfo", (String)localObject)) });
            aa.this.hxa();
          }
        }
        Log.i("MicroMsg.BizTimeLineInfoStorage", "deleteTable count: %d", new Object[] { Integer.valueOf(i) });
        AppMethodBeat.o(124611);
      }
    }, 10L, "BizTimeLineInfoStorageDeleteThread");
    AppMethodBeat.o(207575);
  }
  
  public final long hxb()
  {
    try
    {
      long l = this.Veu;
      return l;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public final long hxc()
  {
    try
    {
      AppMethodBeat.i(124648);
      long l = this.Vet.incrementAndGet();
      AppMethodBeat.o(124648);
      return l;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public final long hxf()
  {
    z localz = null;
    try
    {
      AppMethodBeat.i(124652);
      if (this.Vex.longValue() == -5000000L)
      {
        Cursor localCursor = this.lvy.rawQuery("SELECT * FROM BizTimeLineInfo where type=620757041 or type=637534257 order by msgId DESC limit 1", null);
        if (localCursor.moveToFirst())
        {
          localz = new z();
          localz.convertFrom(localCursor);
        }
        localCursor.close();
        if (localz != null) {
          this.Vex.set(localz.field_msgId);
        }
      }
      long l = this.Vex.incrementAndGet();
      AppMethodBeat.o(124652);
      return l;
    }
    finally {}
  }
  
  public final boolean jv(List<z> paramList)
  {
    AppMethodBeat.i(207525);
    if (Util.isNullOrNil(paramList))
    {
      AppMethodBeat.o(207525);
      return false;
    }
    long l = this.lvy.beginTransaction(Thread.currentThread().getId());
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      z localz = (z)paramList.next();
      ContentValues localContentValues = new ContentValues();
      localContentValues.put("orderFlag", Long.valueOf(localz.field_orderFlag));
      localContentValues.put("bitFlag", Integer.valueOf(localz.field_bitFlag));
      localContentValues.put("status", Integer.valueOf(3));
      if (localz.Ved)
      {
        localContentValues.put("hasShow", Integer.valueOf(0));
        localContentValues.put("isRead", Integer.valueOf(0));
      }
      localContentValues.put("rankSessionId", localz.field_rankSessionId);
      this.lvy.update("BizTimeLineInfo", localContentValues, "msgId = ?", new String[] { localz.field_msgId });
    }
    Log.i("MicroMsg.BizTimeLineInfoStorage", "batResortBizTimeLineInfo ret=%d", new Object[] { Integer.valueOf(this.lvy.endTransaction(l)) });
    com.tencent.e.h.ZvG.bc(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(207296);
        aa.a locala = new aa.a();
        locala.VeB = aa.b.VeG;
        aa.this.a(locala);
        AppMethodBeat.o(207296);
      }
    });
    AppMethodBeat.o(207525);
    return true;
  }
  
  public final List<z> md(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(207539);
    Object localObject = this.lvy;
    String str = "orderFlag DESC limit ".concat(String.valueOf(paramInt2));
    localObject = r(((com.tencent.mm.storagebase.h)localObject).query("BizTimeLineInfo", null, "type=?", new String[] { String.valueOf(paramInt1) }, null, null, str));
    AppMethodBeat.o(207539);
    return localObject;
  }
  
  public static final class a
  {
    public aa.b VeB = aa.b.VeD;
    public boolean VeC = false;
    public List<z> list;
    public z sBt;
    public String talker;
  }
  
  public static enum b
  {
    static
    {
      AppMethodBeat.i(124620);
      VeD = new b("INSERT", 0);
      VeE = new b("DELETE", 1);
      VeF = new b("UPDATE", 2);
      VeG = new b("RE_SORT", 3);
      VeH = new b[] { VeD, VeE, VeF, VeG };
      AppMethodBeat.o(124620);
    }
    
    private b() {}
  }
  
  public static abstract interface c
  {
    public abstract void a(Object paramObject, aa.a parama);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.storage.aa
 * JD-Core Version:    0.7.0.1
 */