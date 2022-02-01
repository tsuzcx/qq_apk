package com.tencent.mm.storage;

import android.database.Cursor;
import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.storage.IAutoDBItem;
import com.tencent.mm.sdk.storage.MAutoStorage;
import com.tencent.mm.sdk.storage.MStorageEvent;
import com.tencent.mm.storagebase.h;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

public final class ae
  extends MAutoStorage<z>
{
  public static final String[] INDEX_CREATE;
  public static final String[] SQL_CREATE;
  private final MStorageEvent<aa.c, aa.a> NQt;
  private final long NRt;
  private AtomicLong NRu;
  public final h iFy;
  
  static
  {
    AppMethodBeat.i(124702);
    SQL_CREATE = new String[] { MAutoStorage.getCreateSQLs(z.info, "BizTimeLineSingleMsgInfo") };
    INDEX_CREATE = new String[] { "CREATE  INDEX IF NOT EXISTS msg_svr_id_index ON BizTimeLineSingleMsgInfo ( msgSvrId ) ", "CREATE  INDEX IF NOT EXISTS talker_index ON BizTimeLineSingleMsgInfo ( talker ) ", "CREATE  INDEX IF NOT EXISTS  create_time_index ON BizTimeLineSingleMsgInfo ( createTime ) ", "CREATE  INDEX IF NOT EXISTS  status_talker_index ON BizTimeLineSingleMsgInfo ( status,talker ) ", "CREATE  INDEX IF NOT EXISTS  status_talker_id_index ON BizTimeLineSingleMsgInfo ( status,talkerId ) ", "CREATE  INDEX IF NOT EXISTS  status_create_time_index ON BizTimeLineSingleMsgInfo ( status,createTime ) ", "CREATE  INDEX IF NOT EXISTS  type_order_flag_index ON BizTimeLineSingleMsgInfo ( type,orderFlag ) " };
    AppMethodBeat.o(124702);
  }
  
  public ae(h paramh)
  {
    super(paramh, z.info, "BizTimeLineSingleMsgInfo", INDEX_CREATE);
    AppMethodBeat.i(124691);
    this.NQt = new MStorageEvent() {};
    this.NRt = -50000000L;
    this.NRu = new AtomicLong(-50000000L);
    this.iFy = paramh;
    AppMethodBeat.o(124691);
  }
  
  public static List<z> o(Cursor paramCursor)
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
  
  public final boolean B(z paramz)
  {
    AppMethodBeat.i(124692);
    boolean bool = super.insertNotify(paramz, false);
    aa.a locala = new aa.a();
    locala.talker = paramz.field_talker;
    locala.psm = paramz;
    locala.NQE = aa.b.NQG;
    a(locala);
    AppMethodBeat.o(124692);
    return bool;
  }
  
  public final boolean C(z paramz)
  {
    AppMethodBeat.i(124693);
    boolean bool = super.updateNotify(paramz, false, new String[] { "msgSvrId" });
    aa.a locala = new aa.a();
    locala.talker = paramz.field_talker;
    locala.psm = paramz;
    locala.NQE = aa.b.NQI;
    a(locala);
    AppMethodBeat.o(124693);
    return bool;
  }
  
  public final z MM(long paramLong)
  {
    AppMethodBeat.i(258700);
    z localz = R(paramLong, "msgId");
    AppMethodBeat.o(258700);
    return localz;
  }
  
  public final void MX(long paramLong)
  {
    AppMethodBeat.i(124700);
    Object localObject = new z();
    ((z)localObject).field_msgId = paramLong;
    super.delete((IAutoDBItem)localObject, false, new String[] { "msgId" });
    localObject = new aa.a();
    ((aa.a)localObject).NQE = aa.b.NQH;
    a((aa.a)localObject);
    AppMethodBeat.o(124700);
  }
  
  public final int Ne(long paramLong)
  {
    int i = 0;
    AppMethodBeat.i(124698);
    Object localObject = "SELECT count(*) FROM BizTimeLineSingleMsgInfo where status != 4 and talkerId = " + paramLong + " ";
    localObject = this.iFy.rawQuery((String)localObject, null);
    if (((Cursor)localObject).moveToFirst()) {
      i = ((Cursor)localObject).getInt(0);
    }
    ((Cursor)localObject).close();
    AppMethodBeat.o(124698);
    return i;
  }
  
  public final z R(long paramLong, String paramString)
  {
    AppMethodBeat.i(212370);
    z localz = new z();
    paramString = this.iFy.query("BizTimeLineSingleMsgInfo", null, paramString + "=?", new String[] { String.valueOf(paramLong) }, null, null, null, 2);
    if (paramString.moveToFirst())
    {
      localz.convertFrom(paramString);
      paramString.close();
      AppMethodBeat.o(212370);
      return localz;
    }
    paramString.close();
    AppMethodBeat.o(212370);
    return null;
  }
  
  public final void a(aa.a parama)
  {
    AppMethodBeat.i(124688);
    if (this.NQt.event(parama)) {
      this.NQt.doNotify();
    }
    AppMethodBeat.o(124688);
  }
  
  public final void a(aa.c paramc)
  {
    AppMethodBeat.i(124690);
    this.NQt.remove(paramc);
    AppMethodBeat.o(124690);
  }
  
  public final void a(aa.c paramc, Looper paramLooper)
  {
    AppMethodBeat.i(124689);
    this.NQt.add(paramc, paramLooper);
    AppMethodBeat.o(124689);
  }
  
  public final boolean aEn(String paramString)
  {
    AppMethodBeat.i(124699);
    z localz = new z();
    localz.field_talker = paramString;
    boolean bool = super.delete(localz, false, new String[] { "talker" });
    paramString = new aa.a();
    paramString.talker = localz.field_talker;
    paramString.psm = localz;
    paramString.NQE = aa.b.NQH;
    a(paramString);
    AppMethodBeat.o(124699);
    return bool;
  }
  
  public final int ctM()
  {
    int i = 0;
    AppMethodBeat.i(124697);
    Cursor localCursor = this.iFy.rawQuery("SELECT count(*) FROM BizTimeLineSingleMsgInfo where status != 4", null);
    if (localCursor.moveToFirst()) {
      i = localCursor.getInt(0);
    }
    localCursor.close();
    AppMethodBeat.o(124697);
    return i;
  }
  
  public final z gAM()
  {
    z localz = null;
    AppMethodBeat.i(124695);
    Cursor localCursor = this.iFy.rawQuery("SELECT * FROM BizTimeLineSingleMsgInfo order by createTime DESC limit 1", null);
    if (localCursor.moveToFirst())
    {
      localz = new z();
      localz.convertFrom(localCursor);
    }
    localCursor.close();
    AppMethodBeat.o(124695);
    return localz;
  }
  
  public final z gBn()
  {
    z localz = null;
    AppMethodBeat.i(124696);
    Cursor localCursor = this.iFy.rawQuery("SELECT * FROM BizTimeLineSingleMsgInfo where status != 4 order by createTime DESC limit 1", null);
    if (localCursor.moveToFirst())
    {
      localz = new z();
      localz.convertFrom(localCursor);
    }
    localCursor.close();
    AppMethodBeat.o(124696);
    return localz;
  }
  
  public final long gBo()
  {
    z localz = null;
    try
    {
      AppMethodBeat.i(212371);
      if (this.NRu.longValue() == -50000000L)
      {
        Cursor localCursor = this.iFy.rawQuery("SELECT * FROM BizTimeLineSingleMsgInfo where type=10100 or type=318767153 order by createTime DESC limit 1", null);
        if (localCursor.moveToFirst())
        {
          localz = new z();
          localz.convertFrom(localCursor);
        }
        localCursor.close();
        if (localz != null) {
          this.NRu.set(localz.field_msgId);
        }
      }
      long l = this.NRu.incrementAndGet();
      AppMethodBeat.o(212371);
      return l;
    }
    finally {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.storage.ae
 * JD-Core Version:    0.7.0.1
 */