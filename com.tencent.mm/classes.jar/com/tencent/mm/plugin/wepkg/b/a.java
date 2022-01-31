package com.tencent.mm.plugin.wepkg.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.fo;
import com.tencent.mm.sdk.e.c.a;
import java.lang.reflect.Field;
import java.util.Map;

public final class a
  extends fo
{
  public static final c.a fkk;
  
  static
  {
    AppMethodBeat.i(63386);
    c.a locala = new c.a();
    locala.yrK = new Field[8];
    locala.columns = new String[9];
    StringBuilder localStringBuilder = new StringBuilder();
    locala.columns[0] = "pkgId";
    locala.yrM.put("pkgId", "TEXT PRIMARY KEY ");
    localStringBuilder.append(" pkgId TEXT PRIMARY KEY ");
    localStringBuilder.append(", ");
    locala.yrL = "pkgId";
    locala.columns[1] = "version";
    locala.yrM.put("version", "TEXT");
    localStringBuilder.append(" version TEXT");
    localStringBuilder.append(", ");
    locala.columns[2] = "oldVersion";
    locala.yrM.put("oldVersion", "TEXT");
    localStringBuilder.append(" oldVersion TEXT");
    localStringBuilder.append(", ");
    locala.columns[3] = "oldPath";
    locala.yrM.put("oldPath", "TEXT");
    localStringBuilder.append(" oldPath TEXT");
    localStringBuilder.append(", ");
    locala.columns[4] = "md5";
    locala.yrM.put("md5", "TEXT");
    localStringBuilder.append(" md5 TEXT");
    localStringBuilder.append(", ");
    locala.columns[5] = "downloadUrl";
    locala.yrM.put("downloadUrl", "TEXT");
    localStringBuilder.append(" downloadUrl TEXT");
    localStringBuilder.append(", ");
    locala.columns[6] = "pkgSize";
    locala.yrM.put("pkgSize", "INTEGER");
    localStringBuilder.append(" pkgSize INTEGER");
    localStringBuilder.append(", ");
    locala.columns[7] = "downloadNetType";
    locala.yrM.put("downloadNetType", "INTEGER");
    localStringBuilder.append(" downloadNetType INTEGER");
    locala.columns[8] = "rowid";
    locala.sql = localStringBuilder.toString();
    fkk = locala;
    AppMethodBeat.o(63386);
  }
  
  public final c.a getDBInfo()
  {
    return fkk;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.wepkg.b.a
 * JD-Core Version:    0.7.0.1
 */