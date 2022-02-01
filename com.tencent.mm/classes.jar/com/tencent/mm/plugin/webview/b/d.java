package com.tencent.mm.plugin.webview.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.gs;
import com.tencent.mm.sdk.e.c.a;
import java.lang.reflect.Field;
import java.util.Map;

public final class d
  extends gs
{
  protected static c.a info;
  
  static
  {
    AppMethodBeat.i(77856);
    c.a locala = new c.a();
    locala.GvF = new Field[6];
    locala.columns = new String[7];
    StringBuilder localStringBuilder = new StringBuilder();
    locala.columns[0] = "recordId";
    locala.GvH.put("recordId", "TEXT PRIMARY KEY ");
    localStringBuilder.append(" recordId TEXT PRIMARY KEY ");
    localStringBuilder.append(", ");
    locala.GvG = "recordId";
    locala.columns[1] = "link";
    locala.GvH.put("link", "TEXT");
    localStringBuilder.append(" link TEXT");
    localStringBuilder.append(", ");
    locala.columns[2] = "title";
    locala.GvH.put("title", "TEXT");
    localStringBuilder.append(" title TEXT");
    localStringBuilder.append(", ");
    locala.columns[3] = "source";
    locala.GvH.put("source", "TEXT");
    localStringBuilder.append(" source TEXT");
    localStringBuilder.append(", ");
    locala.columns[4] = "imgUrl";
    locala.GvH.put("imgUrl", "TEXT");
    localStringBuilder.append(" imgUrl TEXT");
    localStringBuilder.append(", ");
    locala.columns[5] = "timeStamp";
    locala.GvH.put("timeStamp", "LONG");
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