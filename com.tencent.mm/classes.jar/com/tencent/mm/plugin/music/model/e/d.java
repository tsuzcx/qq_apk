package com.tencent.mm.plugin.music.model.e;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.b.f;
import com.tencent.mm.sdk.e.e;
import com.tencent.mm.sdk.e.j;

public final class d
  extends j<c>
{
  public e db;
  public f<String, c> tXI;
  
  public d(e parame)
  {
    super(parame, c.info, "PieceMusicInfo", null);
    AppMethodBeat.i(63179);
    this.db = parame;
    this.tXI = new com.tencent.mm.memory.a.c(20);
    AppMethodBeat.o(63179);
  }
  
  public final c aiQ(String paramString)
  {
    AppMethodBeat.i(63180);
    if (this.tXI.get(paramString) != null)
    {
      paramString = (c)this.tXI.get(paramString);
      AppMethodBeat.o(63180);
      return paramString;
    }
    Object localObject = String.format("Select * From PieceMusicInfo Where musicId=?", new Object[0]);
    localObject = this.db.a((String)localObject, new String[] { paramString }, 2);
    if ((localObject != null) && (((Cursor)localObject).moveToFirst()))
    {
      c localc = new c();
      localc.convertFrom((Cursor)localObject);
      ((Cursor)localObject).close();
      this.tXI.put(paramString, localc);
      AppMethodBeat.o(63180);
      return localc;
    }
    if (localObject != null) {
      ((Cursor)localObject).close();
    }
    AppMethodBeat.o(63180);
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.music.model.e.d
 * JD-Core Version:    0.7.0.1
 */