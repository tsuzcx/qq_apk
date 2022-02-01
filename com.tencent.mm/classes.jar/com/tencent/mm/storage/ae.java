package com.tencent.mm.storage;

import android.database.Cursor;
import android.os.Looper;
import com.tencent.e.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.storage.IAutoDBItem;
import com.tencent.mm.sdk.storage.MAutoStorage;
import com.tencent.mm.sdk.storage.MStorageEvent;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

public final class ae
  extends MAutoStorage<z>
{
  public static final String[] INDEX_CREATE;
  public static final String[] SQL_CREATE;
  private final MStorageEvent<aa.c, aa.a> Vep;
  int Ver;
  private final long Vfo;
  private AtomicLong Vfp;
  public final com.tencent.mm.storagebase.h lvy;
  private boolean lvz;
  
  static
  {
    AppMethodBeat.i(124702);
    SQL_CREATE = new String[] { MAutoStorage.getCreateSQLs(z.info, "BizTimeLineSingleMsgInfo") };
    INDEX_CREATE = new String[] { "CREATE  INDEX IF NOT EXISTS msg_svr_id_index ON BizTimeLineSingleMsgInfo ( msgSvrId ) ", "CREATE  INDEX IF NOT EXISTS talker_index ON BizTimeLineSingleMsgInfo ( talker ) ", "CREATE  INDEX IF NOT EXISTS  create_time_index ON BizTimeLineSingleMsgInfo ( createTime ) ", "CREATE  INDEX IF NOT EXISTS  status_talker_index ON BizTimeLineSingleMsgInfo ( status,talker ) ", "CREATE  INDEX IF NOT EXISTS  status_talker_id_index ON BizTimeLineSingleMsgInfo ( status,talkerId ) ", "CREATE  INDEX IF NOT EXISTS  status_create_time_index ON BizTimeLineSingleMsgInfo ( status,createTime ) ", "CREATE  INDEX IF NOT EXISTS  type_order_flag_index ON BizTimeLineSingleMsgInfo ( type,orderFlag ) " };
    AppMethodBeat.o(124702);
  }
  
  public ae(com.tencent.mm.storagebase.h paramh)
  {
    super(paramh, z.info, "BizTimeLineSingleMsgInfo", INDEX_CREATE);
    AppMethodBeat.i(124691);
    this.Vep = new MStorageEvent() {};
    this.Ver = 100;
    this.lvz = false;
    this.Vfo = -50000000L;
    this.Vfp = new AtomicLong(-50000000L);
    this.lvy = paramh;
    AppMethodBeat.o(124691);
  }
  
  public static List<z> r(Cursor paramCursor)
  {
    AppMethodBeat.i(124694);
    LinkedList localLinkedList = new LinkedList();
    while (paramCursor.moveToNext())
    {
      z localz = new z();
      localz.convertFrom(paramCursor);
      localLinkedList.add(localz);
    }
    paramCursor.close();
    AppMethodBeat.o(124694);
    return localLinkedList;
  }
  
  public final boolean F(z paramz)
  {
    AppMethodBeat.i(124692);
    boolean bool = super.insertNotify(paramz, false);
    aa.a locala = new aa.a();
    locala.talker = paramz.field_talker;
    locala.sBt = paramz;
    locala.VeB = aa.b.VeD;
    a(locala);
    if (!this.lvz)
    {
      this.lvz = true;
      com.tencent.e.h.ZvG.a(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(207368);
          ae localae = ae.this;
          long l = System.currentTimeMillis();
          int i = localae.getCount();
          if (i > 2000)
          {
            String str = String.format("DELETE FROM %s WHERE %s IN ( SELECT %s FROM %s ORDER BY %s LIMIT %d )", new Object[] { "BizTimeLineSingleMsgInfo", "msgSvrId", "msgSvrId", "BizTimeLineSingleMsgInfo", "createTime", Integer.valueOf(100) });
            localae.lvy.execSQL("BizTimeLineSingleMsgInfo", str);
            Log.i("MicroMsg.BizTimeLineSingleMsgStorage", "deleteTooOldData delete cost: %d, count: %d", new Object[] { Long.valueOf(System.currentTimeMillis() - l), Integer.valueOf(i) });
          }
          for (;;)
          {
            ae.b(ae.this);
            AppMethodBeat.o(207368);
            return;
            Log.i("MicroMsg.BizTimeLineSingleMsgStorage", "deleteTooOldData count: %d", new Object[] { Integer.valueOf(i) });
          }
        }
      }, 1000L, "BizTimeLineInfoStorageThread");
    }
    AppMethodBeat.o(124692);
    return bool;
  }
  
  public final boolean G(z paramz)
  {
    AppMethodBeat.i(124693);
    boolean bool = super.updateNotify(paramz, false, new String[] { "msgSvrId" });
    aa.a locala = new aa.a();
    locala.talker = paramz.field_talker;
    locala.sBt = paramz;
    locala.VeB = aa.b.VeF;
    a(locala);
    AppMethodBeat.o(124693);
    return bool;
  }
  
  public final void UI(long paramLong)
  {
    AppMethodBeat.i(124700);
    Object localObject = new z();
    ((z)localObject).field_msgId = paramLong;
    super.delete((IAutoDBItem)localObject, false, new String[] { "msgId" });
    localObject = new aa.a();
    ((aa.a)localObject).VeB = aa.b.VeE;
    a((aa.a)localObject);
    AppMethodBeat.o(124700);
  }
  
  public final int UQ(long paramLong)
  {
    int i = 0;
    AppMethodBeat.i(124698);
    Object localObject = "SELECT count(*) FROM BizTimeLineSingleMsgInfo where status != 4 and talkerId = " + paramLong + " ";
    localObject = this.lvy.rawQuery((String)localObject, null);
    if (((Cursor)localObject).moveToFirst()) {
      i = ((Cursor)localObject).getInt(0);
    }
    ((Cursor)localObject).close();
    AppMethodBeat.o(124698);
    return i;
  }
  
  public final z Uw(long paramLong)
  {
    AppMethodBeat.i(292874);
    z localz = ad(paramLong, "msgId");
    AppMethodBeat.o(292874);
    return localz;
  }
  
  public final void a(aa.a parama)
  {
    AppMethodBeat.i(124688);
    if (this.Vep.event(parama)) {
      this.Vep.doNotify();
    }
    AppMethodBeat.o(124688);
  }
  
  public final void a(aa.c paramc)
  {
    AppMethodBeat.i(124690);
    this.Vep.remove(paramc);
    AppMethodBeat.o(124690);
  }
  
  public final void a(aa.c paramc, Looper paramLooper)
  {
    AppMethodBeat.i(124689);
    this.Vep.add(paramc, paramLooper);
    AppMethodBeat.o(124689);
  }
  
  public final boolean aOx(String paramString)
  {
    AppMethodBeat.i(124699);
    z localz = new z();
    localz.field_talker = paramString;
    boolean bool = super.delete(localz, false, new String[] { "talker" });
    paramString = new aa.a();
    paramString.talker = localz.field_talker;
    paramString.sBt = localz;
    paramString.VeB = aa.b.VeE;
    a(paramString);
    AppMethodBeat.o(124699);
    return bool;
  }
  
  public final z ad(long paramLong, String paramString)
  {
    AppMethodBeat.i(209811);
    z localz = new z();
    paramString = this.lvy.query("BizTimeLineSingleMsgInfo", null, paramString + "=?", new String[] { String.valueOf(paramLong) }, null, null, null, 2);
    if (paramString.moveToFirst())
    {
      localz.convertFrom(paramString);
      paramString.close();
      AppMethodBeat.o(209811);
      return localz;
    }
    paramString.close();
    AppMethodBeat.o(209811);
    return null;
  }
  
  public final int cHo()
  {
    int i = 0;
    AppMethodBeat.i(124697);
    Cursor localCursor = this.lvy.rawQuery("SELECT count(*) FROM BizTimeLineSingleMsgInfo where status != 4", null);
    if (localCursor.moveToFirst()) {
      i = localCursor.getInt(0);
    }
    localCursor.close();
    AppMethodBeat.o(124697);
    return i;
  }
  
  public final z hwU()
  {
    z localz = null;
    AppMethodBeat.i(124695);
    Cursor localCursor = this.lvy.rawQuery("SELECT * FROM BizTimeLineSingleMsgInfo order by createTime DESC limit 1", null);
    if (localCursor.moveToFirst())
    {
      localz = new z();
      localz.convertFrom(localCursor);
    }
    localCursor.close();
    AppMethodBeat.o(124695);
    return localz;
  }
  
  public final void hxa()
  {
    AppMethodBeat.i(209818);
    com.tencent.e.h.ZvG.a(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(207109);
        int i = ae.this.getCount();
        if (i > 0)
        {
          Object localObject = ae.this;
          int j = ((ae)localObject).Ver;
          ((ae)localObject).Ver = (j - 1);
          if (j > 0)
          {
            Log.i("MicroMsg.BizTimeLineSingleMsgStorage", "deleteTable start");
            localObject = String.format("DELETE FROM %s WHERE %s IN ( SELECT %s FROM %s ORDER BY %s LIMIT %d )", new Object[] { "BizTimeLineSingleMsgInfo", "msgSvrId", "msgSvrId", "BizTimeLineSingleMsgInfo", "createTime", Integer.valueOf(100) });
            Log.i("MicroMsg.BizTimeLineSingleMsgStorage", "deleteTable end ret=%b", new Object[] { Boolean.valueOf(ae.a(ae.this).execSQL("BizTimeLineSingleMsgInfo", (String)localObject)) });
            ae.this.hxa();
          }
        }
        Log.i("MicroMsg.BizTimeLineSingleMsgStorage", "deleteTable count: %d", new Object[] { Integer.valueOf(i) });
        AppMethodBeat.o(207109);
      }
    }, 10L, "BizTimeLineInfoStorageDeleteThread");
    AppMethodBeat.o(209818);
  }
  
  public final z hxy()
  {
    z localz = null;
    AppMethodBeat.i(124696);
    Cursor localCursor = this.lvy.rawQuery("SELECT * FROM BizTimeLineSingleMsgInfo where status != 4 order by createTime DESC limit 1", null);
    if (localCursor.moveToFirst())
    {
      localz = new z();
      localz.convertFrom(localCursor);
    }
    localCursor.close();
    AppMethodBeat.o(124696);
    return localz;
  }
  
  public final long hxz()
  {
    z localz = null;
    try
    {
      AppMethodBeat.i(209819);
      if (this.Vfp.longValue() == -50000000L)
      {
        Cursor localCursor = this.lvy.rawQuery("SELECT * FROM BizTimeLineSingleMsgInfo where type=10100 or type=318767153 order by createTime DESC limit 1", null);
        if (localCursor.moveToFirst())
        {
          localz = new z();
          localz.convertFrom(localCursor);
        }
        localCursor.close();
        if (localz != null) {
          this.Vfp.set(localz.field_msgId);
        }
      }
      long l = this.Vfp.incrementAndGet();
      AppMethodBeat.o(209819);
      return l;
    }
    finally {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.storage.ae
 * JD-Core Version:    0.7.0.1
 */