package com.tencent.mm.plugin.wepkg.b;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.e.j;
import com.tencent.mm.sdk.platformtools.bu;

public final class b
  extends j<a>
{
  private static b EWb;
  public static final String[] SQL_CREATE;
  private static final Object lock;
  private com.tencent.mm.sdk.e.e jKa;
  
  static
  {
    AppMethodBeat.i(110561);
    SQL_CREATE = new String[] { j.getCreateSQLs(a.hGW, "WePkgDiffPackage") };
    lock = new Object();
    AppMethodBeat.o(110561);
  }
  
  private b(com.tencent.mm.sdk.e.e parame)
  {
    super(parame, a.hGW, "WePkgDiffPackage", a.INDEX_CREATE);
    this.jKa = parame;
  }
  
  private boolean beO()
  {
    return this.jKa != null;
  }
  
  public static b fbx()
  {
    AppMethodBeat.i(110558);
    if (EWb == null) {}
    synchronized (lock)
    {
      if ((EWb == null) || (!EWb.beO())) {
        EWb = new b(g.ajR().gDX);
      }
      ??? = EWb;
      AppMethodBeat.o(110558);
      return ???;
    }
  }
  
  public final boolean Dc(String paramString)
  {
    AppMethodBeat.i(110560);
    if ((!beO()) || (bu.isNullOrNil(paramString)))
    {
      AppMethodBeat.o(110560);
      return false;
    }
    boolean bool = execSQL("WePkgDiffPackage", String.format("delete from %s where %s=%s", new Object[] { "WePkgDiffPackage", "pkgId", "'" + paramString + "'" }));
    AppMethodBeat.o(110560);
    return bool;
  }
  
  public final a aLR(String paramString)
  {
    AppMethodBeat.i(110559);
    if ((!beO()) || (bu.isNullOrNil(paramString)))
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