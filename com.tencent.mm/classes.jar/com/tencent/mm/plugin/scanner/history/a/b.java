package com.tencent.mm.plugin.scanner.history.a;

import android.database.Cursor;
import com.tencent.mm.sdk.e.e;
import com.tencent.mm.sdk.e.i;

public final class b
  extends i<a>
{
  public static final String[] dXp = { i.a(a.buS, "ScanHistoryItem") };
  public e dXw;
  
  public b(e parame)
  {
    super(parame, a.buS, "ScanHistoryItem", null);
    this.dXw = parame;
  }
  
  public final Cursor aAn()
  {
    return this.dXw.rawQuery("select * from ScanHistoryItem order by ScanTime desc", null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.scanner.history.a.b
 * JD-Core Version:    0.7.0.1
 */