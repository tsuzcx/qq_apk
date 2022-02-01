package com.tencent.mm.plugin.wepkg.b;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.e.j;
import com.tencent.mm.sdk.platformtools.bs;

public final class b
  extends j<a>
{
  private static b CZG;
  public static final String[] SQL_CREATE;
  private static final Object lock;
  private com.tencent.mm.sdk.e.e jnc;
  
  static
  {
    AppMethodBeat.i(110561);
    SQL_CREATE = new String[] { j.getCreateSQLs(a.hlR, "WePkgDiffPackage") };
    lock = new Object();
    AppMethodBeat.o(110561);
  }
  
  private b(com.tencent.mm.sdk.e.e parame)
  {
    super(parame, a.hlR, "WePkgDiffPackage", a.INDEX_CREATE);
    this.jnc = parame;
  }
  
  private boolean baH()
  {
    return this.jnc != null;
  }
  
  public static b eIR()
  {
    AppMethodBeat.i(110558);
    if (CZG == null) {}
    synchronized (lock)
    {
      if ((CZG == null) || (!CZG.baH())) {
        CZG = new b(g.agR().ghG);
      }
      ??? = CZG;
      AppMethodBeat.o(110558);
      return ???;
    }
  }
  
  public final a aEV(String paramString)
  {
    AppMethodBeat.i(110559);
    if ((!baH()) || (bs.isNullOrNil(paramString)))
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
  
  public final boolean zB(String paramString)
  {
    AppMethodBeat.i(110560);
    if ((!baH()) || (bs.isNullOrNil(paramString)))
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