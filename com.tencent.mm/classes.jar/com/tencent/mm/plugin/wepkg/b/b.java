package com.tencent.mm.plugin.wepkg.b;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.e.j;
import com.tencent.mm.sdk.platformtools.bo;

public final class b
  extends j<a>
{
  public static final String[] SQL_CREATE;
  private static final Object lock;
  private static b vEM;
  private com.tencent.mm.sdk.e.e gVl;
  
  static
  {
    AppMethodBeat.i(63390);
    SQL_CREATE = new String[] { j.getCreateSQLs(a.fkk, "WePkgDiffPackage") };
    lock = new Object();
    AppMethodBeat.o(63390);
  }
  
  private b(com.tencent.mm.sdk.e.e parame)
  {
    super(parame, a.fkk, "WePkgDiffPackage", a.INDEX_CREATE);
    this.gVl = parame;
  }
  
  private boolean ayz()
  {
    return this.gVl != null;
  }
  
  public static b dko()
  {
    AppMethodBeat.i(63387);
    if (vEM == null) {}
    synchronized (lock)
    {
      if ((vEM == null) || (!vEM.ayz())) {
        vEM = new b(g.RL().eHS);
      }
      ??? = vEM;
      AppMethodBeat.o(63387);
      return ???;
    }
  }
  
  public final a akl(String paramString)
  {
    AppMethodBeat.i(63388);
    if ((!ayz()) || (bo.isNullOrNil(paramString)))
    {
      AppMethodBeat.o(63388);
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
        AppMethodBeat.o(63388);
        return locala;
      }
      paramString.close();
      AppMethodBeat.o(63388);
      return null;
    }
    AppMethodBeat.o(63388);
    return null;
  }
  
  public final boolean qD(String paramString)
  {
    AppMethodBeat.i(63389);
    if ((!ayz()) || (bo.isNullOrNil(paramString)))
    {
      AppMethodBeat.o(63389);
      return false;
    }
    boolean bool = execSQL("WePkgDiffPackage", String.format("delete from %s where %s=%s", new Object[] { "WePkgDiffPackage", "pkgId", "'" + paramString + "'" }));
    AppMethodBeat.o(63389);
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.wepkg.b.b
 * JD-Core Version:    0.7.0.1
 */