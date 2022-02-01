package com.tencent.mm.plugin.music.model.e;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.b.f;
import com.tencent.mm.sdk.storage.ISQLiteDatabase;
import com.tencent.mm.sdk.storage.MAutoStorage;

public final class d
  extends MAutoStorage<c>
{
  public f<String, c> LNJ;
  public ISQLiteDatabase db;
  
  public d(ISQLiteDatabase paramISQLiteDatabase)
  {
    super(paramISQLiteDatabase, c.info, "PieceMusicInfo", null);
    AppMethodBeat.i(63179);
    this.db = paramISQLiteDatabase;
    this.LNJ = new com.tencent.mm.memory.a.c(20);
    AppMethodBeat.o(63179);
  }
  
  public final c aPh(String paramString)
  {
    AppMethodBeat.i(63180);
    if (this.LNJ.get(paramString) != null)
    {
      paramString = (c)this.LNJ.get(paramString);
      AppMethodBeat.o(63180);
      return paramString;
    }
    Object localObject = String.format("Select * From PieceMusicInfo Where musicId=?", new Object[0]);
    localObject = this.db.rawQuery((String)localObject, new String[] { paramString }, 2);
    if ((localObject != null) && (((Cursor)localObject).moveToFirst()))
    {
      c localc = new c();
      localc.convertFrom((Cursor)localObject);
      ((Cursor)localObject).close();
      this.LNJ.put(paramString, localc);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.music.model.e.d
 * JD-Core Version:    0.7.0.1
 */