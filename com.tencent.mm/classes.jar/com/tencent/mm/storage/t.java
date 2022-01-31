package com.tencent.mm.storage;

import android.database.Cursor;
import android.os.Looper;
import com.tencent.mm.cf.h;
import com.tencent.mm.sdk.e.c;
import com.tencent.mm.sdk.e.i;
import com.tencent.mm.sdk.e.k;
import java.util.LinkedList;
import java.util.List;

public final class t
  extends i<q>
{
  public static final String[] cqY = { "CREATE  INDEX IF NOT EXISTS msg_svr_id_index ON BizTimeLineSingleMsgInfo ( msgSvrId ) ", "CREATE  INDEX IF NOT EXISTS talker_index ON BizTimeLineSingleMsgInfo ( talker ) ", "CREATE  INDEX IF NOT EXISTS  create_time_index ON BizTimeLineSingleMsgInfo ( createTime ) ", "CREATE  INDEX IF NOT EXISTS  status_talker_index ON BizTimeLineSingleMsgInfo ( status,talker ) " };
  public static final String[] dXp = { i.a(q.buS, "BizTimeLineSingleMsgInfo") };
  public final h dXo;
  private final k<r.c, r.a> umW = new t.1(this);
  
  public t(h paramh)
  {
    super(paramh, q.buS, "BizTimeLineSingleMsgInfo", cqY);
    this.dXo = paramh;
  }
  
  public static List<q> m(Cursor paramCursor)
  {
    LinkedList localLinkedList = new LinkedList();
    while (paramCursor.moveToNext())
    {
      q localq = new q();
      localq.d(paramCursor);
      localLinkedList.add(localq);
    }
    paramCursor.close();
    return localLinkedList;
  }
  
  public final boolean Hr(String paramString)
  {
    q localq = new q();
    localq.field_talker = paramString;
    boolean bool = super.a(localq, false, new String[] { "talker" });
    paramString = new r.a();
    paramString.talker = localq.field_talker;
    paramString.igD = localq;
    paramString.unb = r.b.une;
    b(paramString);
    return bool;
  }
  
  public final void a(r.c paramc)
  {
    this.umW.remove(paramc);
  }
  
  public final void a(r.c paramc, Looper paramLooper)
  {
    this.umW.a(paramc, paramLooper);
  }
  
  public final int aAo()
  {
    int i = 0;
    Cursor localCursor = this.dXo.a("SELECT count(*) FROM BizTimeLineSingleMsgInfo where status != 4", null, 0);
    if (localCursor.moveToFirst()) {
      i = localCursor.getInt(0);
    }
    localCursor.close();
    return i;
  }
  
  public final void b(r.a parama)
  {
    if (this.umW.bV(parama)) {
      this.umW.doNotify();
    }
  }
  
  public final boolean g(q paramq)
  {
    boolean bool = super.a(paramq, false);
    r.a locala = new r.a();
    locala.talker = paramq.field_talker;
    locala.igD = paramq;
    locala.unb = r.b.und;
    b(locala);
    return bool;
  }
  
  public final boolean h(q paramq)
  {
    boolean bool = super.b(paramq, false, new String[] { "msgSvrId" });
    r.a locala = new r.a();
    locala.talker = paramq.field_talker;
    locala.igD = paramq;
    locala.unb = r.b.unf;
    b(locala);
    return bool;
  }
  
  public final void hz(long paramLong)
  {
    Object localObject = new q();
    ((q)localObject).field_msgId = paramLong;
    super.a((c)localObject, false, new String[] { "msgId" });
    localObject = new r.a();
    ((r.a)localObject).unb = r.b.une;
    b((r.a)localObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.storage.t
 * JD-Core Version:    0.7.0.1
 */