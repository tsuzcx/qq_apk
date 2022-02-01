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
  private final l<x.c, x.a> Iou;
  private final long Ipg;
  private AtomicLong Iph;
  public final h hHS;
  
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
    this.Iou = new l() {};
    this.Ipg = -50000000L;
    this.Iph = new AtomicLong(-50000000L);
    this.hHS = paramh;
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
  
  public final int DB(long paramLong)
  {
    int i = 0;
    AppMethodBeat.i(124698);
    Object localObject = "SELECT count(*) FROM BizTimeLineSingleMsgInfo where status != 4 and talkerId = " + paramLong + " ";
    localObject = this.hHS.a((String)localObject, null, 0);
    if (((Cursor)localObject).moveToFirst()) {
      i = ((Cursor)localObject).getInt(0);
    }
    ((Cursor)localObject).close();
    AppMethodBeat.o(124698);
    return i;
  }
  
  public final void Dv(long paramLong)
  {
    AppMethodBeat.i(124700);
    Object localObject = new w();
    ((w)localObject).field_msgId = paramLong;
    super.delete((c)localObject, false, new String[] { "msgId" });
    localObject = new x.a();
    ((x.a)localObject).IoG = x.b.IoJ;
    a((x.a)localObject);
    AppMethodBeat.o(124700);
  }
  
  public final void a(x.a parama)
  {
    AppMethodBeat.i(124688);
    if (this.Iou.dV(parama)) {
      this.Iou.doNotify();
    }
    AppMethodBeat.o(124688);
  }
  
  public final void a(x.c paramc)
  {
    AppMethodBeat.i(124690);
    this.Iou.remove(paramc);
    AppMethodBeat.o(124690);
  }
  
  public final void a(x.c paramc, Looper paramLooper)
  {
    AppMethodBeat.i(124689);
    this.Iou.a(paramc, paramLooper);
    AppMethodBeat.o(124689);
  }
  
  public final boolean apN(String paramString)
  {
    AppMethodBeat.i(124699);
    w localw = new w();
    localw.field_talker = paramString;
    boolean bool = super.delete(localw, false, new String[] { "talker" });
    paramString = new x.a();
    paramString.talker = localw.field_talker;
    paramString.obf = localw;
    paramString.IoG = x.b.IoJ;
    a(paramString);
    AppMethodBeat.o(124699);
    return bool;
  }
  
  public final int bUJ()
  {
    int i = 0;
    AppMethodBeat.i(124697);
    Cursor localCursor = this.hHS.a("SELECT count(*) FROM BizTimeLineSingleMsgInfo where status != 4", null, 0);
    if (localCursor.moveToFirst()) {
      i = localCursor.getInt(0);
    }
    localCursor.close();
    AppMethodBeat.o(124697);
    return i;
  }
  
  public final w fpJ()
  {
    w localw = null;
    AppMethodBeat.i(124696);
    Cursor localCursor = this.hHS.a("SELECT * FROM BizTimeLineSingleMsgInfo where status != 4 order by createTime DESC limit 1", null, 0);
    if (localCursor.moveToFirst())
    {
      localw = new w();
      localw.convertFrom(localCursor);
    }
    localCursor.close();
    AppMethodBeat.o(124696);
    return localw;
  }
  
  public final long fpK()
  {
    w localw = null;
    try
    {
      AppMethodBeat.i(207282);
      if (this.Iph.longValue() == -50000000L)
      {
        Cursor localCursor = this.hHS.a("SELECT * FROM BizTimeLineSingleMsgInfo where type=10100 order by createTime DESC limit 1", null, 0);
        if (localCursor.moveToFirst())
        {
          localw = new w();
          localw.convertFrom(localCursor);
        }
        localCursor.close();
        if (localw != null) {
          this.Iph.set(localw.field_msgId);
        }
      }
      long l = this.Iph.incrementAndGet();
      AppMethodBeat.o(207282);
      return l;
    }
    finally {}
  }
  
  public final w fpq()
  {
    w localw = null;
    AppMethodBeat.i(124695);
    Cursor localCursor = this.hHS.a("SELECT * FROM BizTimeLineSingleMsgInfo order by createTime DESC limit 1", null, 0);
    if (localCursor.moveToFirst())
    {
      localw = new w();
      localw.convertFrom(localCursor);
    }
    localCursor.close();
    AppMethodBeat.o(124695);
    return localw;
  }
  
  public final boolean o(w paramw)
  {
    AppMethodBeat.i(124692);
    boolean bool = super.insertNotify(paramw, false);
    x.a locala = new x.a();
    locala.talker = paramw.field_talker;
    locala.obf = paramw;
    locala.IoG = x.b.IoI;
    a(locala);
    AppMethodBeat.o(124692);
    return bool;
  }
  
  public final boolean p(w paramw)
  {
    AppMethodBeat.i(124693);
    boolean bool = super.updateNotify(paramw, false, new String[] { "msgSvrId" });
    x.a locala = new x.a();
    locala.talker = paramw.field_talker;
    locala.obf = paramw;
    locala.IoG = x.b.IoK;
    a(locala);
    AppMethodBeat.o(124693);
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.storage.z
 * JD-Core Version:    0.7.0.1
 */