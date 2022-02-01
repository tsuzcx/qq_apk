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
import java.util.concurrent.atomic.AtomicLong;

public final class z
  extends j<w>
{
  public static final String[] INDEX_CREATE;
  public static final String[] SQL_CREATE;
  private final l<x.c, x.a> IIK;
  private final long IJy;
  private AtomicLong IJz;
  public final h hKK;
  
  static
  {
    AppMethodBeat.i(124702);
    SQL_CREATE = new String[] { j.getCreateSQLs(w.info, "BizTimeLineSingleMsgInfo") };
    INDEX_CREATE = new String[] { "CREATE  INDEX IF NOT EXISTS msg_svr_id_index ON BizTimeLineSingleMsgInfo ( msgSvrId ) ", "CREATE  INDEX IF NOT EXISTS talker_index ON BizTimeLineSingleMsgInfo ( talker ) ", "CREATE  INDEX IF NOT EXISTS  create_time_index ON BizTimeLineSingleMsgInfo ( createTime ) ", "CREATE  INDEX IF NOT EXISTS  status_talker_index ON BizTimeLineSingleMsgInfo ( status,talker ) ", "CREATE  INDEX IF NOT EXISTS  status_talker_id_index ON BizTimeLineSingleMsgInfo ( status,talkerId ) ", "CREATE  INDEX IF NOT EXISTS  status_create_time_index ON BizTimeLineSingleMsgInfo ( status,createTime ) ", "CREATE  INDEX IF NOT EXISTS  type_order_flag_index ON BizTimeLineSingleMsgInfo ( type,orderFlag ) " };
    AppMethodBeat.o(124702);
  }
  
  public z(h paramh)
  {
    super(paramh, w.info, "BizTimeLineSingleMsgInfo", INDEX_CREATE);
    AppMethodBeat.i(124691);
    this.IIK = new l() {};
    this.IJy = -50000000L;
    this.IJz = new AtomicLong(-50000000L);
    this.hKK = paramh;
    AppMethodBeat.o(124691);
  }
  
  public static List<w> o(Cursor paramCursor)
  {
    AppMethodBeat.i(124694);
    LinkedList localLinkedList = new LinkedList();
    while (paramCursor.moveToNext())
    {
      w localw = new w();
      localw.convertFrom(paramCursor);
      localLinkedList.add(localw);
    }
    paramCursor.close();
    AppMethodBeat.o(124694);
    return localLinkedList;
  }
  
  public final w DM(long paramLong)
  {
    AppMethodBeat.i(224211);
    w localw = N(paramLong, "msgId");
    AppMethodBeat.o(224211);
    return localw;
  }
  
  public final void DU(long paramLong)
  {
    AppMethodBeat.i(124700);
    Object localObject = new w();
    ((w)localObject).field_msgId = paramLong;
    super.delete((c)localObject, false, new String[] { "msgId" });
    localObject = new x.a();
    ((x.a)localObject).IIW = x.b.IIZ;
    a((x.a)localObject);
    AppMethodBeat.o(124700);
  }
  
  public final int Ea(long paramLong)
  {
    int i = 0;
    AppMethodBeat.i(124698);
    Object localObject = "SELECT count(*) FROM BizTimeLineSingleMsgInfo where status != 4 and talkerId = " + paramLong + " ";
    localObject = this.hKK.a((String)localObject, null, 0);
    if (((Cursor)localObject).moveToFirst()) {
      i = ((Cursor)localObject).getInt(0);
    }
    ((Cursor)localObject).close();
    AppMethodBeat.o(124698);
    return i;
  }
  
  public final w N(long paramLong, String paramString)
  {
    AppMethodBeat.i(188988);
    w localw = new w();
    paramString = this.hKK.a("BizTimeLineSingleMsgInfo", null, paramString + "=?", new String[] { String.valueOf(paramLong) }, null, null, null, 2);
    if (paramString.moveToFirst())
    {
      localw.convertFrom(paramString);
      paramString.close();
      AppMethodBeat.o(188988);
      return localw;
    }
    paramString.close();
    AppMethodBeat.o(188988);
    return null;
  }
  
  public final void a(x.a parama)
  {
    AppMethodBeat.i(124688);
    if (this.IIK.dW(parama)) {
      this.IIK.doNotify();
    }
    AppMethodBeat.o(124688);
  }
  
  public final void a(x.c paramc)
  {
    AppMethodBeat.i(124690);
    this.IIK.remove(paramc);
    AppMethodBeat.o(124690);
  }
  
  public final void a(x.c paramc, Looper paramLooper)
  {
    AppMethodBeat.i(124689);
    this.IIK.a(paramc, paramLooper);
    AppMethodBeat.o(124689);
  }
  
  public final boolean aqS(String paramString)
  {
    AppMethodBeat.i(124699);
    w localw = new w();
    localw.field_talker = paramString;
    boolean bool = super.delete(localw, false, new String[] { "talker" });
    paramString = new x.a();
    paramString.talker = localw.field_talker;
    paramString.ogW = localw;
    paramString.IIW = x.b.IIZ;
    a(paramString);
    AppMethodBeat.o(124699);
    return bool;
  }
  
  public final int bVY()
  {
    int i = 0;
    AppMethodBeat.i(124697);
    Cursor localCursor = this.hKK.a("SELECT count(*) FROM BizTimeLineSingleMsgInfo where status != 4", null, 0);
    if (localCursor.moveToFirst()) {
      i = localCursor.getInt(0);
    }
    localCursor.close();
    AppMethodBeat.o(124697);
    return i;
  }
  
  public final w ftJ()
  {
    w localw = null;
    AppMethodBeat.i(124696);
    Cursor localCursor = this.hKK.a("SELECT * FROM BizTimeLineSingleMsgInfo where status != 4 order by createTime DESC limit 1", null, 0);
    if (localCursor.moveToFirst())
    {
      localw = new w();
      localw.convertFrom(localCursor);
    }
    localCursor.close();
    AppMethodBeat.o(124696);
    return localw;
  }
  
  public final long ftK()
  {
    w localw = null;
    try
    {
      AppMethodBeat.i(188989);
      if (this.IJz.longValue() == -50000000L)
      {
        Cursor localCursor = this.hKK.a("SELECT * FROM BizTimeLineSingleMsgInfo where type=10100 or type=318767153 order by createTime DESC limit 1", null, 0);
        if (localCursor.moveToFirst())
        {
          localw = new w();
          localw.convertFrom(localCursor);
        }
        localCursor.close();
        if (localw != null) {
          this.IJz.set(localw.field_msgId);
        }
      }
      long l = this.IJz.incrementAndGet();
      AppMethodBeat.o(188989);
      return l;
    }
    finally {}
  }
  
  public final w ftp()
  {
    w localw = null;
    AppMethodBeat.i(124695);
    Cursor localCursor = this.hKK.a("SELECT * FROM BizTimeLineSingleMsgInfo order by createTime DESC limit 1", null, 0);
    if (localCursor.moveToFirst())
    {
      localw = new w();
      localw.convertFrom(localCursor);
    }
    localCursor.close();
    AppMethodBeat.o(124695);
    return localw;
  }
  
  public final boolean p(w paramw)
  {
    AppMethodBeat.i(124692);
    boolean bool = super.insertNotify(paramw, false);
    x.a locala = new x.a();
    locala.talker = paramw.field_talker;
    locala.ogW = paramw;
    locala.IIW = x.b.IIY;
    a(locala);
    AppMethodBeat.o(124692);
    return bool;
  }
  
  public final boolean q(w paramw)
  {
    AppMethodBeat.i(124693);
    boolean bool = super.updateNotify(paramw, false, new String[] { "msgSvrId" });
    x.a locala = new x.a();
    locala.talker = paramw.field_talker;
    locala.ogW = paramw;
    locala.IIW = x.b.IJa;
    a(locala);
    AppMethodBeat.o(124693);
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.storage.z
 * JD-Core Version:    0.7.0.1
 */