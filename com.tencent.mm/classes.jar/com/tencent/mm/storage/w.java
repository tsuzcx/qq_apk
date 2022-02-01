package com.tencent.mm.storage;

import android.database.Cursor;
import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.e.c;
import com.tencent.mm.sdk.e.j;
import com.tencent.mm.sdk.e.l;
import com.tencent.mm.storagebase.h;
import java.util.LinkedList;
import java.util.List;

public final class w
  extends j<t>
{
  public static final String[] INDEX_CREATE;
  public static final String[] SQL_CREATE;
  private final l<u.c, u.a> GCe;
  public final h hpA;
  
  static
  {
    AppMethodBeat.i(124702);
    SQL_CREATE = new String[] { j.getCreateSQLs(t.info, "BizTimeLineSingleMsgInfo") };
    INDEX_CREATE = new String[] { "CREATE  INDEX IF NOT EXISTS msg_svr_id_index ON BizTimeLineSingleMsgInfo ( msgSvrId ) ", "CREATE  INDEX IF NOT EXISTS talker_index ON BizTimeLineSingleMsgInfo ( talker ) ", "CREATE  INDEX IF NOT EXISTS  create_time_index ON BizTimeLineSingleMsgInfo ( createTime ) ", "CREATE  INDEX IF NOT EXISTS  status_talker_index ON BizTimeLineSingleMsgInfo ( status,talker ) ", "CREATE  INDEX IF NOT EXISTS  status_talker_id_index ON BizTimeLineSingleMsgInfo ( status,talkerId ) ", "CREATE  INDEX IF NOT EXISTS  status_create_time_index ON BizTimeLineSingleMsgInfo ( status,createTime ) ", "CREATE  INDEX IF NOT EXISTS  system_reject_id_index ON BizTimeLineSingleMsgInfo ( bizRejectMsgId ) " };
    AppMethodBeat.o(124702);
  }
  
  public w(h paramh)
  {
    super(paramh, t.info, "BizTimeLineSingleMsgInfo", INDEX_CREATE);
    AppMethodBeat.i(124691);
    this.GCe = new l() {};
    this.hpA = paramh;
    AppMethodBeat.o(124691);
  }
  
  public static List<t> o(Cursor paramCursor)
  {
    AppMethodBeat.i(124694);
    LinkedList localLinkedList = new LinkedList();
    while (paramCursor.moveToNext())
    {
      t localt = new t();
      localt.convertFrom(paramCursor);
      localLinkedList.add(localt);
    }
    paramCursor.close();
    AppMethodBeat.o(124694);
    return localLinkedList;
  }
  
  public final void AF(long paramLong)
  {
    AppMethodBeat.i(124700);
    Object localObject = new t();
    ((t)localObject).field_msgId = paramLong;
    super.delete((c)localObject, false, new String[] { "msgId" });
    localObject = new u.a();
    ((u.a)localObject).GCq = u.b.GCt;
    a((u.a)localObject);
    AppMethodBeat.o(124700);
  }
  
  public final int AL(long paramLong)
  {
    int i = 0;
    AppMethodBeat.i(124698);
    Object localObject = "SELECT count(*) FROM BizTimeLineSingleMsgInfo where status != 4 and talkerId = " + paramLong + " ";
    localObject = this.hpA.a((String)localObject, null, 0);
    if (((Cursor)localObject).moveToFirst()) {
      i = ((Cursor)localObject).getInt(0);
    }
    ((Cursor)localObject).close();
    AppMethodBeat.o(124698);
    return i;
  }
  
  public final void a(u.a parama)
  {
    AppMethodBeat.i(124688);
    if (this.GCe.dS(parama)) {
      this.GCe.doNotify();
    }
    AppMethodBeat.o(124688);
  }
  
  public final void a(u.c paramc)
  {
    AppMethodBeat.i(124690);
    this.GCe.remove(paramc);
    AppMethodBeat.o(124690);
  }
  
  public final void a(u.c paramc, Looper paramLooper)
  {
    AppMethodBeat.i(124689);
    this.GCe.a(paramc, paramLooper);
    AppMethodBeat.o(124689);
  }
  
  public final boolean alb(String paramString)
  {
    AppMethodBeat.i(124699);
    t localt = new t();
    localt.field_talker = paramString;
    boolean bool = super.delete(localt, false, new String[] { "talker" });
    paramString = new u.a();
    paramString.talker = localt.field_talker;
    paramString.nAa = localt;
    paramString.GCq = u.b.GCt;
    a(paramString);
    AppMethodBeat.o(124699);
    return bool;
  }
  
  public final int bQe()
  {
    int i = 0;
    AppMethodBeat.i(124697);
    Cursor localCursor = this.hpA.a("SELECT count(*) FROM BizTimeLineSingleMsgInfo where status != 4", null, 0);
    if (localCursor.moveToFirst()) {
      i = localCursor.getInt(0);
    }
    localCursor.close();
    AppMethodBeat.o(124697);
    return i;
  }
  
  public final t eZI()
  {
    t localt = null;
    AppMethodBeat.i(124696);
    Cursor localCursor = this.hpA.a("SELECT * FROM BizTimeLineSingleMsgInfo where status != 4 order by createTime DESC limit 1", null, 0);
    if (localCursor.moveToFirst())
    {
      localt = new t();
      localt.convertFrom(localCursor);
    }
    localCursor.close();
    AppMethodBeat.o(124696);
    return localt;
  }
  
  public final t eZr()
  {
    t localt = null;
    AppMethodBeat.i(124695);
    Cursor localCursor = this.hpA.a("SELECT * FROM BizTimeLineSingleMsgInfo order by createTime DESC limit 1", null, 0);
    if (localCursor.moveToFirst())
    {
      localt = new t();
      localt.convertFrom(localCursor);
    }
    localCursor.close();
    AppMethodBeat.o(124695);
    return localt;
  }
  
  public final boolean j(t paramt)
  {
    AppMethodBeat.i(124692);
    boolean bool = super.insertNotify(paramt, false);
    u.a locala = new u.a();
    locala.talker = paramt.field_talker;
    locala.nAa = paramt;
    locala.GCq = u.b.GCs;
    a(locala);
    AppMethodBeat.o(124692);
    return bool;
  }
  
  public final boolean k(t paramt)
  {
    AppMethodBeat.i(124693);
    boolean bool = super.updateNotify(paramt, false, new String[] { "msgSvrId" });
    u.a locala = new u.a();
    locala.talker = paramt.field_talker;
    locala.nAa = paramt;
    locala.GCq = u.b.GCu;
    a(locala);
    AppMethodBeat.o(124693);
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.storage.w
 * JD-Core Version:    0.7.0.1
 */