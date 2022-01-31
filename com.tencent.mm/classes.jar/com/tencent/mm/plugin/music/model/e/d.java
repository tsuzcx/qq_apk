package com.tencent.mm.plugin.music.model.e;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.a.f;
import com.tencent.mm.sdk.e.e;
import com.tencent.mm.sdk.e.j;

public final class d
  extends j<c>
{
  public e db;
  public f<String, c> pax;
  
  public d(e parame)
  {
    super(parame, c.info, "PieceMusicInfo", null);
    AppMethodBeat.i(105041);
    this.db = parame;
    this.pax = new com.tencent.mm.memory.a.c(20);
    AppMethodBeat.o(105041);
  }
  
  public final c VD(String paramString)
  {
    AppMethodBeat.i(105042);
    if (this.pax.get(paramString) != null)
    {
      paramString = (c)this.pax.get(paramString);
      AppMethodBeat.o(105042);
      return paramString;
    }
    Object localObject = String.format("Select * From PieceMusicInfo Where musicId=?", new Object[0]);
    localObject = this.db.a((String)localObject, new String[] { paramString }, 2);
    if ((localObject != null) && (((Cursor)localObject).moveToFirst()))
    {
      c localc = new c();
      localc.convertFrom((Cursor)localObject);
      ((Cursor)localObject).close();
      this.pax.put(paramString, localc);
      AppMethodBeat.o(105042);
      return localc;
    }
    if (localObject != null) {
      ((Cursor)localObject).close();
    }
    AppMethodBeat.o(105042);
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.music.model.e.d
 * JD-Core Version:    0.7.0.1
 */