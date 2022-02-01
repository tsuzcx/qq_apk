package com.tencent.mm.plugin.wepkg.b;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.e.j;
import com.tencent.mm.sdk.platformtools.bt;

public final class b
  extends j<a>
{
  private static b EDF;
  public static final String[] SQL_CREATE;
  private static final Object lock;
  private com.tencent.mm.sdk.e.e jHa;
  
  static
  {
    AppMethodBeat.i(110561);
    SQL_CREATE = new String[] { j.getCreateSQLs(a.hEe, "WePkgDiffPackage") };
    lock = new Object();
    AppMethodBeat.o(110561);
  }
  
  private b(com.tencent.mm.sdk.e.e parame)
  {
    super(parame, a.hEe, "WePkgDiffPackage", a.INDEX_CREATE);
    this.jHa = parame;
  }
  
  private boolean beh()
  {
    return this.jHa != null;
  }
  
  public static b eXL()
  {
    AppMethodBeat.i(110558);
    if (EDF == null) {}
    synchronized (lock)
    {
      if ((EDF == null) || (!EDF.beh())) {
        EDF = new b(g.ajC().gBq);
      }
      ??? = EDF;
      AppMethodBeat.o(110558);
      return ???;
    }
  }
  
  public final boolean CA(String paramString)
  {
    AppMethodBeat.i(110560);
    if ((!beh()) || (bt.isNullOrNil(paramString)))
    {
      AppMethodBeat.o(110560);
      return false;
    }
    boolean bool = execSQL("WePkgDiffPackage", String.format("delete from %s where %s=%s", new Object[] { "WePkgDiffPackage", "pkgId", "'" + paramString + "'" }));
    AppMethodBeat.o(110560);
    return bool;
  }
  
  public final a aKv(String paramString)
  {
    AppMethodBeat.i(110559);
    if ((!beh()) || (bt.isNullOrNil(paramString)))
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
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.wepkg.b.b
 * JD-Core Version:    0.7.0.1
 */