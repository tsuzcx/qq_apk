package com.tencent.mm.plugin.wepkg.b;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.e.j;
import com.tencent.mm.sdk.platformtools.bt;

public final class b
  extends j<a>
{
  private static b BHy;
  public static final String[] SQL_CREATE;
  private static final Object lock;
  private com.tencent.mm.sdk.e.e iMV;
  
  static
  {
    AppMethodBeat.i(110561);
    SQL_CREATE = new String[] { j.getCreateSQLs(a.gLr, "WePkgDiffPackage") };
    lock = new Object();
    AppMethodBeat.o(110561);
  }
  
  private b(com.tencent.mm.sdk.e.e parame)
  {
    super(parame, a.gLr, "WePkgDiffPackage", a.INDEX_CREATE);
    this.iMV = parame;
  }
  
  private boolean aTJ()
  {
    return this.iMV != null;
  }
  
  public static b ety()
  {
    AppMethodBeat.i(110558);
    if (BHy == null) {}
    synchronized (lock)
    {
      if ((BHy == null) || (!BHy.aTJ())) {
        BHy = new b(g.afB().gda);
      }
      ??? = BHy;
      AppMethodBeat.o(110558);
      return ???;
    }
  }
  
  public final a azE(String paramString)
  {
    AppMethodBeat.i(110559);
    if ((!aTJ()) || (bt.isNullOrNil(paramString)))
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
  
  public final boolean vv(String paramString)
  {
    AppMethodBeat.i(110560);
    if ((!aTJ()) || (bt.isNullOrNil(paramString)))
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