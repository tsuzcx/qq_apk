package com.tencent.mm.storage;

import android.database.Cursor;
import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cg.h;
import com.tencent.mm.sdk.e.c;
import com.tencent.mm.sdk.e.j;
import com.tencent.mm.sdk.e.l;
import java.util.LinkedList;
import java.util.List;

public final class t
  extends j<q>
{
  public static final String[] INDEX_CREATE;
  public static final String[] SQL_CREATE;
  public final h fnw;
  private final l<r.c, r.a> ywD;
  
  static
  {
    AppMethodBeat.i(11917);
    SQL_CREATE = new String[] { j.getCreateSQLs(q.info, "BizTimeLineSingleMsgInfo") };
    INDEX_CREATE = new String[] { "CREATE  INDEX IF NOT EXISTS msg_svr_id_index ON BizTimeLineSingleMsgInfo ( msgSvrId ) ", "CREATE  INDEX IF NOT EXISTS talker_index ON BizTimeLineSingleMsgInfo ( talker ) ", "CREATE  INDEX IF NOT EXISTS  create_time_index ON BizTimeLineSingleMsgInfo ( createTime ) ", "CREATE  INDEX IF NOT EXISTS  status_talker_index ON BizTimeLineSingleMsgInfo ( status,talker ) ", "CREATE  INDEX IF NOT EXISTS  status_talker_id_index ON BizTimeLineSingleMsgInfo ( status,talkerId ) ", "CREATE  INDEX IF NOT EXISTS  status_create_time_index ON BizTimeLineSingleMsgInfo ( status,createTime ) " };
    AppMethodBeat.o(11917);
  }
  
  public t(h paramh)
  {
    super(paramh, q.info, "BizTimeLineSingleMsgInfo", INDEX_CREATE);
    AppMethodBeat.i(11907);
    this.ywD = new t.1(this);
    this.fnw = paramh;
    AppMethodBeat.o(11907);
  }
  
  public static List<q> n(Cursor paramCursor)
  {
    AppMethodBeat.i(11910);
    LinkedList localLinkedList = new LinkedList();
    while (paramCursor.moveToNext())
    {
      q localq = new q();
      localq.convertFrom(paramCursor);
      localLinkedList.add(localq);
    }
    paramCursor.close();
    AppMethodBeat.o(11910);
    return localLinkedList;
  }
  
  public final boolean Td(String paramString)
  {
    AppMethodBeat.i(11914);
    q localq = new q();
    localq.field_talker = paramString;
    boolean bool = super.delete(localq, false, new String[] { "talker" });
    paramString = new r.a();
    paramString.talker = localq.field_talker;
    paramString.jWv = localq;
    paramString.ywM = r.b.ywP;
    a(paramString);
    AppMethodBeat.o(11914);
    return bool;
  }
  
  public final void a(r.a parama)
  {
    AppMethodBeat.i(11904);
    if (this.ywD.cy(parama)) {
      this.ywD.doNotify();
    }
    AppMethodBeat.o(11904);
  }
  
  public final void a(r.c paramc)
  {
    AppMethodBeat.i(11906);
    this.ywD.remove(paramc);
    AppMethodBeat.o(11906);
  }
  
  public final void a(r.c paramc, Looper paramLooper)
  {
    AppMethodBeat.i(11905);
    this.ywD.a(paramc, paramLooper);
    AppMethodBeat.o(11905);
  }
  
  public final int bbZ()
  {
    int i = 0;
    AppMethodBeat.i(11912);
    Cursor localCursor = this.fnw.a("SELECT count(*) FROM BizTimeLineSingleMsgInfo where status != 4", null, 0);
    if (localCursor.moveToFirst()) {
      i = localCursor.getInt(0);
    }
    localCursor.close();
    AppMethodBeat.o(11912);
    return i;
  }
  
  public final q dwl()
  {
    q localq = null;
    AppMethodBeat.i(11911);
    Cursor localCursor = this.fnw.a("SELECT * FROM BizTimeLineSingleMsgInfo where status != 4 order by createTime DESC limit 1", null, 0);
    if (localCursor.moveToFirst())
    {
      localq = new q();
      localq.convertFrom(localCursor);
    }
    localCursor.close();
    AppMethodBeat.o(11911);
    return localq;
  }
  
  public final boolean h(q paramq)
  {
    AppMethodBeat.i(11908);
    boolean bool = super.insertNotify(paramq, false);
    r.a locala = new r.a();
    locala.talker = paramq.field_talker;
    locala.jWv = paramq;
    locala.ywM = r.b.ywO;
    a(locala);
    AppMethodBeat.o(11908);
    return bool;
  }
  
  public final boolean i(q paramq)
  {
    AppMethodBeat.i(11909);
    boolean bool = super.updateNotify(paramq, false, new String[] { "msgSvrId" });
    r.a locala = new r.a();
    locala.talker = paramq.field_talker;
    locala.jWv = paramq;
    locala.ywM = r.b.ywQ;
    a(locala);
    AppMethodBeat.o(11909);
    return bool;
  }
  
  public final void og(long paramLong)
  {
    AppMethodBeat.i(11915);
    Object localObject = new q();
    ((q)localObject).field_msgId = paramLong;
    super.delete((c)localObject, false, new String[] { "msgId" });
    localObject = new r.a();
    ((r.a)localObject).ywM = r.b.ywP;
    a((r.a)localObject);
    AppMethodBeat.o(11915);
  }
  
  public final int ok(long paramLong)
  {
    int i = 0;
    AppMethodBeat.i(11913);
    Object localObject = "SELECT count(*) FROM BizTimeLineSingleMsgInfo where status != 4 and talkerId = " + paramLong + " ";
    localObject = this.fnw.a((String)localObject, null, 0);
    if (((Cursor)localObject).moveToFirst()) {
      i = ((Cursor)localObject).getInt(0);
    }
    ((Cursor)localObject).close();
    AppMethodBeat.o(11913);
    return i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.storage.t
 * JD-Core Version:    0.7.0.1
 */