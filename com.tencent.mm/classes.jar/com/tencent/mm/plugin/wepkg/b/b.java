package com.tencent.mm.plugin.wepkg.b;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.storage.ISQLiteDatabase;
import com.tencent.mm.sdk.storage.MAutoStorage;

public final class b
  extends MAutoStorage<a>
{
  private static b JLU;
  public static final String[] SQL_CREATE;
  private static final Object lock;
  private ISQLiteDatabase kLX;
  
  static
  {
    AppMethodBeat.i(110561);
    SQL_CREATE = new String[] { MAutoStorage.getCreateSQLs(a.iBg, "WePkgDiffPackage") };
    lock = new Object();
    AppMethodBeat.o(110561);
  }
  
  private b(ISQLiteDatabase paramISQLiteDatabase)
  {
    super(paramISQLiteDatabase, a.iBg, "WePkgDiffPackage", a.INDEX_CREATE);
    this.kLX = paramISQLiteDatabase;
  }
  
  private boolean bAh()
  {
    return this.kLX != null;
  }
  
  public static b gkD()
  {
    AppMethodBeat.i(110558);
    if (JLU == null) {}
    synchronized (lock)
    {
      if ((JLU == null) || (!JLU.bAh())) {
        JLU = new b(g.aAh().hqK);
      }
      ??? = JLU;
      AppMethodBeat.o(110558);
      return ???;
    }
  }
  
  public final a bcj(String paramString)
  {
    AppMethodBeat.i(110559);
    if ((!bAh()) || (Util.isNullOrNil(paramString)))
    {
      AppMethodBeat.o(110559);
      return null;
    }
    paramString = rawQuery(String.format("select * from %s where %s=%s", new Object[] { "WePkgDiffPackage", "pkgId", "'" + paramString + "'" }), new String[0]);
    if (paramString != null)
    {
      if (paramString.moveToFirst())
      {
        a locala = new a();
        locala.convertFrom(paramString);
        paramString.close();
        AppMethodBeat.o(110559);
        return locala;
      }
      paramString.close();
      AppMethodBeat.o(110559);
      return null;
    }
    AppMethodBeat.o(110559);
    return null;
  }
  
  public final boolean gC(String paramString)
  {
    AppMethodBeat.i(110560);
    if ((!bAh()) || (Util.isNullOrNil(paramString)))
    {
      AppMethodBeat.o(110560);
      return false;
    }
    boolean bool = execSQL("WePkgDiffPackage", String.format("delete from %s where %s=%s", new Object[] { "WePkgDiffPackage", "pkgId", "'" + paramString + "'" }));
    AppMethodBeat.o(110560);
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.wepkg.b.b
 * JD-Core Version:    0.7.0.1
 */