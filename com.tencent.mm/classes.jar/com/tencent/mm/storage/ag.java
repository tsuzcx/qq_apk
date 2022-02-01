package com.tencent.mm.storage;

import android.database.Cursor;
import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.storage.IAutoDBItem;
import com.tencent.mm.sdk.storage.MAutoStorage;
import com.tencent.mm.sdk.storage.MStorageEvent;
import com.tencent.threadpool.i;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

public final class ag
  extends MAutoStorage<ab>
{
  public static final String[] INDEX_CREATE;
  public static final String[] SQL_CREATE;
  private final MStorageEvent<ac.c, ac.a> acFL;
  int acFN;
  private final long acGD;
  private AtomicLong acGE;
  public final com.tencent.mm.storagebase.h omV;
  private boolean omW;
  
  static
  {
    AppMethodBeat.i(124702);
    SQL_CREATE = new String[] { MAutoStorage.getCreateSQLs(ab.info, "BizTimeLineSingleMsgInfo") };
    INDEX_CREATE = new String[] { "CREATE  INDEX IF NOT EXISTS msg_svr_id_index ON BizTimeLineSingleMsgInfo ( msgSvrId ) ", "CREATE  INDEX IF NOT EXISTS talker_index ON BizTimeLineSingleMsgInfo ( talker ) ", "CREATE  INDEX IF NOT EXISTS  create_time_index ON BizTimeLineSingleMsgInfo ( createTime ) ", "CREATE  INDEX IF NOT EXISTS  status_talker_index ON BizTimeLineSingleMsgInfo ( status,talker ) ", "CREATE  INDEX IF NOT EXISTS  status_talker_id_index ON BizTimeLineSingleMsgInfo ( status,talkerId ) ", "CREATE  INDEX IF NOT EXISTS  status_create_time_index ON BizTimeLineSingleMsgInfo ( status,createTime ) ", "CREATE  INDEX IF NOT EXISTS  type_order_flag_index ON BizTimeLineSingleMsgInfo ( type,orderFlag ) " };
    AppMethodBeat.o(124702);
  }
  
  public ag(com.tencent.mm.storagebase.h paramh)
  {
    super(paramh, ab.info, "BizTimeLineSingleMsgInfo", INDEX_CREATE);
    AppMethodBeat.i(124691);
    this.acFL = new MStorageEvent() {};
    this.acFN = 100;
    this.omW = false;
    this.acGD = -50000000L;
    this.acGE = new AtomicLong(-50000000L);
    this.omV = paramh;
    AppMethodBeat.o(124691);
  }
  
  public static List<ab> s(Cursor paramCursor)
  {
    AppMethodBeat.i(124694);
    LinkedList localLinkedList = new LinkedList();
    while (paramCursor.moveToNext())
    {
      ab localab = new ab();
      localab.convertFrom(paramCursor);
      localLinkedList.add(localab);
    }
    paramCursor.close();
    AppMethodBeat.o(124694);
    return localLinkedList;
  }
  
  public final boolean E(ab paramab)
  {
    AppMethodBeat.i(124692);
    boolean bool = super.insertNotify(paramab, false);
    ac.a locala = new ac.a();
    locala.talker = paramab.field_talker;
    locala.vGS = paramab;
    locala.acFX = ac.b.acFZ;
    a(locala);
    if (!this.omW)
    {
      this.omW = true;
      com.tencent.threadpool.h.ahAA.a(new ag.3(this), 1000L, "BizTimeLineInfoStorageThread");
    }
    AppMethodBeat.o(124692);
    return bool;
  }
  
  public final boolean F(ab paramab)
  {
    AppMethodBeat.i(124693);
    boolean bool = super.updateNotify(paramab, false, new String[] { "msgSvrId" });
    ac.a locala = new ac.a();
    locala.talker = paramab.field_talker;
    locala.vGS = paramab;
    locala.acFX = ac.b.acGb;
    a(locala);
    AppMethodBeat.o(124693);
    return bool;
  }
  
  public final void a(ac.a parama)
  {
    AppMethodBeat.i(124688);
    if (this.acFL.event(parama)) {
      this.acFL.doNotify();
    }
    AppMethodBeat.o(124688);
  }
  
  public final void a(ac.c paramc)
  {
    AppMethodBeat.i(124690);
    this.acFL.remove(paramc);
    AppMethodBeat.o(124690);
  }
  
  public final void a(ac.c paramc, Looper paramLooper)
  {
    AppMethodBeat.i(124689);
    this.acFL.add(paramc, paramLooper);
    AppMethodBeat.o(124689);
  }
  
  public final boolean aLw(String paramString)
  {
    AppMethodBeat.i(124699);
    ab localab = new ab();
    localab.field_talker = paramString;
    boolean bool = super.delete(localab, false, new String[] { "talker" });
    paramString = new ac.a();
    paramString.talker = localab.field_talker;
    paramString.vGS = localab;
    paramString.acFX = ac.b.acGa;
    a(paramString);
    AppMethodBeat.o(124699);
    return bool;
  }
  
  public final ab aq(long paramLong, String paramString)
  {
    AppMethodBeat.i(248537);
    ab localab = new ab();
    paramString = this.omV.query("BizTimeLineSingleMsgInfo", null, paramString + "=?", new String[] { String.valueOf(paramLong) }, null, null, null, 2);
    if (paramString.moveToFirst())
    {
      localab.convertFrom(paramString);
      paramString.close();
      AppMethodBeat.o(248537);
      return localab;
    }
    paramString.close();
    AppMethodBeat.o(248537);
    return null;
  }
  
  public final void bSr()
  {
    AppMethodBeat.i(248555);
    com.tencent.threadpool.h.ahAA.a(new ag.2(this), 10L, "BizTimeLineInfoStorageDeleteThread");
    AppMethodBeat.o(248555);
  }
  
  public final int dkF()
  {
    int i = 0;
    AppMethodBeat.i(124697);
    Cursor localCursor = this.omV.rawQuery("SELECT count(*) FROM BizTimeLineSingleMsgInfo where status != 4", null);
    if (localCursor.moveToFirst()) {
      i = localCursor.getInt(0);
    }
    localCursor.close();
    AppMethodBeat.o(124697);
    return i;
  }
  
  public final ab iZb()
  {
    ab localab = null;
    AppMethodBeat.i(124696);
    Cursor localCursor = this.omV.rawQuery("SELECT * FROM BizTimeLineSingleMsgInfo where status != 4 order by createTime DESC limit 1", null);
    if (localCursor.moveToFirst())
    {
      localab = new ab();
      localab.convertFrom(localCursor);
    }
    localCursor.close();
    AppMethodBeat.o(124696);
    return localab;
  }
  
  public final long iZc()
  {
    ab localab = null;
    try
    {
      AppMethodBeat.i(248568);
      if (this.acGE.longValue() == -50000000L)
      {
        Cursor localCursor = this.omV.rawQuery("SELECT * FROM BizTimeLineSingleMsgInfo where type=10100 or type=318767153 order by createTime DESC limit 1", null);
        if (localCursor.moveToFirst())
        {
          localab = new ab();
          localab.convertFrom(localCursor);
        }
        localCursor.close();
        if (localab != null) {
          this.acGE.set(localab.field_msgId);
        }
      }
      long l = this.acGE.incrementAndGet();
      AppMethodBeat.o(248568);
      return l;
    }
    finally {}
  }
  
  public final void yQ(long paramLong)
  {
    AppMethodBeat.i(124700);
    Object localObject = new ab();
    ((ab)localObject).field_msgId = paramLong;
    super.delete((IAutoDBItem)localObject, false, new String[] { "msgId" });
    localObject = new ac.a();
    ((ac.a)localObject).acFX = ac.b.acGa;
    a((ac.a)localObject);
    AppMethodBeat.o(124700);
  }
  
  public final int yZ(long paramLong)
  {
    int i = 0;
    AppMethodBeat.i(124698);
    Object localObject = "SELECT count(*) FROM BizTimeLineSingleMsgInfo where status != 4 and talkerId = " + paramLong + " ";
    localObject = this.omV.rawQuery((String)localObject, null);
    if (((Cursor)localObject).moveToFirst()) {
      i = ((Cursor)localObject).getInt(0);
    }
    ((Cursor)localObject).close();
    AppMethodBeat.o(124698);
    return i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     com.tencent.mm.storage.ag
 * JD-Core Version:    0.7.0.1
 */