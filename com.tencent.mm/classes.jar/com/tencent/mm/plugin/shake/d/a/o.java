package com.tencent.mm.plugin.shake.d.a;

import android.database.Cursor;
import com.tencent.mm.sdk.e.e;
import com.tencent.mm.sdk.e.i;

public final class o
  extends i<n>
{
  public static final String[] cqY = new String[0];
  public static final String[] dXp = { i.a(n.buS, "shaketvhistory") };
  public e dXw;
  
  public o(e parame)
  {
    super(parame, n.buS, "shaketvhistory", dXp);
    this.dXw = parame;
  }
  
  public final Cursor bAA()
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("SELECT * FROM shaketvhistory ORDER BY createtime DESC");
    localObject = ((StringBuilder)localObject).toString();
    return this.dXw.rawQuery((String)localObject, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.shake.d.a.o
 * JD-Core Version:    0.7.0.1
 */