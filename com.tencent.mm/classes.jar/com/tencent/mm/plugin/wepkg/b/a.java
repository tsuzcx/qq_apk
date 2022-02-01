package com.tencent.mm.plugin.wepkg.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.gq;
import com.tencent.mm.sdk.e.c.a;
import java.lang.reflect.Field;
import java.util.Map;

public final class a
  extends gq
{
  public static final c.a hlR;
  
  static
  {
    AppMethodBeat.i(110557);
    c.a locala = new c.a();
    locala.GvF = new Field[8];
    locala.columns = new String[9];
    StringBuilder localStringBuilder = new StringBuilder();
    locala.columns[0] = "pkgId";
    locala.GvH.put("pkgId", "TEXT PRIMARY KEY ");
    localStringBuilder.append(" pkgId TEXT PRIMARY KEY ");
    localStringBuilder.append(", ");
    locala.GvG = "pkgId";
    locala.columns[1] = "version";
    locala.GvH.put("version", "TEXT");
    localStringBuilder.append(" version TEXT");
    localStringBuilder.append(", ");
    locala.columns[2] = "oldVersion";
    locala.GvH.put("oldVersion", "TEXT");
    localStringBuilder.append(" oldVersion TEXT");
    localStringBuilder.append(", ");
    locala.columns[3] = "oldPath";
    locala.GvH.put("oldPath", "TEXT");
    localStringBuilder.append(" oldPath TEXT");
    localStringBuilder.append(", ");
    locala.columns[4] = "md5";
    locala.GvH.put("md5", "TEXT");
    localStringBuilder.append(" md5 TEXT");
    localStringBuilder.append(", ");
    locala.columns[5] = "downloadUrl";
    locala.GvH.put("downloadUrl", "TEXT");
    localStringBuilder.append(" downloadUrl TEXT");
    localStringBuilder.append(", ");
    locala.columns[6] = "pkgSize";
    locala.GvH.put("pkgSize", "INTEGER");
    localStringBuilder.append(" pkgSize INTEGER");
    localStringBuilder.append(", ");
    locala.columns[7] = "downloadNetType";
    locala.GvH.put("downloadNetType", "INTEGER");
    localStringBuilder.append(" downloadNetType INTEGER");
    locala.columns[8] = "rowid";
    locala.sql = localStringBuilder.toString();
    hlR = locala;
    AppMethodBeat.o(110557);
  }
  
  public final c.a getDBInfo()
  {
    return hlR;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.wepkg.b.a
 * JD-Core Version:    0.7.0.1
 */