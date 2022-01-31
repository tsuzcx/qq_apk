package com.tencent.mm.plugin.order.b;

import android.database.Cursor;
import com.tencent.mm.sdk.e.e;
import com.tencent.mm.sdk.e.i;

public final class b
  extends i<a>
{
  public static final String[] dXp = { i.a(a.buS, "OrderCommonMsgXml") };
  private e dXw;
  
  public b(e parame)
  {
    super(parame, a.buS, "OrderCommonMsgXml", null);
    this.dXw = parame;
  }
  
  public final boolean a(a parama)
  {
    return super.b(parama);
  }
  
  public final Cursor aAn()
  {
    return this.dXw.rawQuery("select * from OrderCommonMsgXml order by msgId desc", null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.order.b.b
 * JD-Core Version:    0.7.0.1
 */