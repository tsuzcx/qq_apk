package com.tencent.mm.plugin.wepkg.b;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.f;
import com.tencent.mm.kernel.h;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.storage.ISQLiteDatabase;
import com.tencent.mm.sdk.storage.MAutoStorage;

public final class b
  extends MAutoStorage<a>
{
  public static final String[] SQL_CREATE;
  private static b XEM;
  private static final Object lock;
  private ISQLiteDatabase qFJ;
  
  static
  {
    AppMethodBeat.i(110561);
    SQL_CREATE = new String[] { MAutoStorage.getCreateSQLs(a.nVV, "WePkgDiffPackage") };
    lock = new Object();
    AppMethodBeat.o(110561);
  }
  
  private b(ISQLiteDatabase paramISQLiteDatabase)
  {
    super(paramISQLiteDatabase, a.nVV, "WePkgDiffPackage", a.INDEX_CREATE);
    this.qFJ = paramISQLiteDatabase;
  }
  
  private boolean ckW()
  {
    return this.qFJ != null;
  }
  
  public static b iFc()
  {
    AppMethodBeat.i(110558);
    if (XEM == null) {}
    synchronized (lock)
    {
      if ((XEM == null) || (!XEM.ckW())) {
        XEM = new b(h.baE().mCN);
      }
      ??? = XEM;
      AppMethodBeat.o(110558);
      return ???;
    }
  }
  
  public final a bnX(String paramString)
  {
    AppMethodBeat.i(110559);
    if ((!ckW()) || (Util.isNullOrNil(paramString)))
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
  
  public final boolean iP(String paramString)
  {
    AppMethodBeat.i(110560);
    if ((!ckW()) || (Util.isNullOrNil(paramString)))
    {
      AppMethodBeat.o(110560);
      return false;
    }
    boolean bool = execSQL("WePkgDiffPackage", String.format("delete from %s where %s=%s", new Object[] { "WePkgDiffPackage", "pkgId", "'" + paramString + "'" }));
    AppMethodBeat.o(110560);
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.wepkg.b.b
 * JD-Core Version:    0.7.0.1
 */