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

public final class v
  extends j<s>
{
  public static final String[] INDEX_CREATE;
  public static final String[] SQL_CREATE;
  private final l<t.c, t.a> Feu;
  public final h gPa;
  
  static
  {
    AppMethodBeat.i(124702);
    SQL_CREATE = new String[] { j.getCreateSQLs(s.info, "BizTimeLineSingleMsgInfo") };
    INDEX_CREATE = new String[] { "CREATE  INDEX IF NOT EXISTS msg_svr_id_index ON BizTimeLineSingleMsgInfo ( msgSvrId ) ", "CREATE  INDEX IF NOT EXISTS talker_index ON BizTimeLineSingleMsgInfo ( talker ) ", "CREATE  INDEX IF NOT EXISTS  create_time_index ON BizTimeLineSingleMsgInfo ( createTime ) ", "CREATE  INDEX IF NOT EXISTS  status_talker_index ON BizTimeLineSingleMsgInfo ( status,talker ) ", "CREATE  INDEX IF NOT EXISTS  status_talker_id_index ON BizTimeLineSingleMsgInfo ( status,talkerId ) ", "CREATE  INDEX IF NOT EXISTS  status_create_time_index ON BizTimeLineSingleMsgInfo ( status,createTime ) ", "CREATE  INDEX IF NOT EXISTS  system_reject_id_index ON BizTimeLineSingleMsgInfo ( bizRejectMsgId ) " };
    AppMethodBeat.o(124702);
  }
  
  public v(h paramh)
  {
    super(paramh, s.info, "BizTimeLineSingleMsgInfo", INDEX_CREATE);
    AppMethodBeat.i(124691);
    this.Feu = new l() {};
    this.gPa = paramh;
    AppMethodBeat.o(124691);
  }
  
  public static List<s> p(Cursor paramCursor)
  {
    AppMethodBeat.i(124694);
    LinkedList localLinkedList = new LinkedList();
    while (paramCursor.moveToNext())
    {
      s locals = new s();
      locals.convertFrom(paramCursor);
      localLinkedList.add(locals);
    }
    paramCursor.close();
    AppMethodBeat.o(124694);
    return localLinkedList;
  }
  
  public final void a(t.a parama)
  {
    AppMethodBeat.i(124688);
    if (this.Feu.dR(parama)) {
      this.Feu.doNotify();
    }
    AppMethodBeat.o(124688);
  }
  
  public final void a(t.c paramc)
  {
    AppMethodBeat.i(124690);
    this.Feu.remove(paramc);
    AppMethodBeat.o(124690);
  }
  
  public final void a(t.c paramc, Looper paramLooper)
  {
    AppMethodBeat.i(124689);
    this.Feu.a(paramc, paramLooper);
    AppMethodBeat.o(124689);
  }
  
  public final boolean agh(String paramString)
  {
    AppMethodBeat.i(124699);
    s locals = new s();
    locals.field_talker = paramString;
    boolean bool = super.delete(locals, false, new String[] { "talker" });
    paramString = new t.a();
    paramString.talker = locals.field_talker;
    paramString.mXB = locals;
    paramString.FeG = t.b.FeJ;
    a(paramString);
    AppMethodBeat.o(124699);
    return bool;
  }
  
  public final int bIR()
  {
    int i = 0;
    AppMethodBeat.i(124697);
    Cursor localCursor = this.gPa.a("SELECT count(*) FROM BizTimeLineSingleMsgInfo where status != 4", null, 0);
    if (localCursor.moveToFirst()) {
      i = localCursor.getInt(0);
    }
    localCursor.close();
    AppMethodBeat.o(124697);
    return i;
  }
  
  public final s eJU()
  {
    s locals = null;
    AppMethodBeat.i(124695);
    Cursor localCursor = this.gPa.a("SELECT * FROM BizTimeLineSingleMsgInfo order by createTime DESC limit 1", null, 0);
    if (localCursor.moveToFirst())
    {
      locals = new s();
      locals.convertFrom(localCursor);
    }
    localCursor.close();
    AppMethodBeat.o(124695);
    return locals;
  }
  
  public final s eKl()
  {
    s locals = null;
    AppMethodBeat.i(124696);
    Cursor localCursor = this.gPa.a("SELECT * FROM BizTimeLineSingleMsgInfo where status != 4 order by createTime DESC limit 1", null, 0);
    if (localCursor.moveToFirst())
    {
      locals = new s();
      locals.convertFrom(localCursor);
    }
    localCursor.close();
    AppMethodBeat.o(124696);
    return locals;
  }
  
  public final boolean j(s params)
  {
    AppMethodBeat.i(124692);
    boolean bool = super.insertNotify(params, false);
    t.a locala = new t.a();
    locala.talker = params.field_talker;
    locala.mXB = params;
    locala.FeG = t.b.FeI;
    a(locala);
    AppMethodBeat.o(124692);
    return bool;
  }
  
  public final boolean k(s params)
  {
    AppMethodBeat.i(124693);
    boolean bool = super.updateNotify(params, false, new String[] { "msgSvrId" });
    t.a locala = new t.a();
    locala.talker = params.field_talker;
    locala.mXB = params;
    locala.FeG = t.b.FeK;
    a(locala);
    AppMethodBeat.o(124693);
    return bool;
  }
  
  public final void wc(long paramLong)
  {
    AppMethodBeat.i(124700);
    Object localObject = new s();
    ((s)localObject).field_msgId = paramLong;
    super.delete((c)localObject, false, new String[] { "msgId" });
    localObject = new t.a();
    ((t.a)localObject).FeG = t.b.FeJ;
    a((t.a)localObject);
    AppMethodBeat.o(124700);
  }
  
  public final int wi(long paramLong)
  {
    int i = 0;
    AppMethodBeat.i(124698);
    Object localObject = "SELECT count(*) FROM BizTimeLineSingleMsgInfo where status != 4 and talkerId = " + paramLong + " ";
    localObject = this.gPa.a((String)localObject, null, 0);
    if (((Cursor)localObject).moveToFirst()) {
      i = ((Cursor)localObject).getInt(0);
    }
    ((Cursor)localObject).close();
    AppMethodBeat.o(124698);
    return i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.storage.v
 * JD-Core Version:    0.7.0.1
 */