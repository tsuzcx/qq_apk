package com.tencent.mm.plugin.webview.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.go;
import com.tencent.mm.sdk.e.c.a;
import java.lang.reflect.Field;
import java.util.Map;

public final class d
  extends go
{
  protected static c.a info;
  
  static
  {
    AppMethodBeat.i(77856);
    c.a locala = new c.a();
    locala.EYt = new Field[6];
    locala.columns = new String[7];
    StringBuilder localStringBuilder = new StringBuilder();
    locala.columns[0] = "recordId";
    locala.EYv.put("recordId", "TEXT PRIMARY KEY ");
    localStringBuilder.append(" recordId TEXT PRIMARY KEY ");
    localStringBuilder.append(", ");
    locala.EYu = "recordId";
    locala.columns[1] = "link";
    locala.EYv.put("link", "TEXT");
    localStringBuilder.append(" link TEXT");
    localStringBuilder.append(", ");
    locala.columns[2] = "title";
    locala.EYv.put("title", "TEXT");
    localStringBuilder.append(" title TEXT");
    localStringBuilder.append(", ");
    locala.columns[3] = "source";
    locala.EYv.put("source", "TEXT");
    localStringBuilder.append(" source TEXT");
    localStringBuilder.append(", ");
    locala.columns[4] = "imgUrl";
    locala.EYv.put("imgUrl", "TEXT");
    localStringBuilder.append(" imgUrl TEXT");
    localStringBuilder.append(", ");
    locala.columns[5] = "timeStamp";
    locala.EYv.put("timeStamp", "LONG");
    localStringBuilder.append(" timeStamp LONG");
    locala.columns[6] = "rowid";
    locala.sql = localStringBuilder.toString();
    info = locala;
    AppMethodBeat.o(77856);
  }
  
  public final c.a getDBInfo()
  {
    return info;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.b.d
 * JD-Core Version:    0.7.0.1
 */