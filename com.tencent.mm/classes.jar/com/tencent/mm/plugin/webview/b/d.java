package com.tencent.mm.plugin.webview.b;

import com.tencent.mm.h.c.fb;
import com.tencent.mm.sdk.e.c.a;
import java.lang.reflect.Field;
import java.util.Map;

public final class d
  extends fb
{
  protected static c.a buS;
  
  static
  {
    c.a locala = new c.a();
    locala.ujL = new Field[6];
    locala.columns = new String[7];
    StringBuilder localStringBuilder = new StringBuilder();
    locala.columns[0] = "recordId";
    locala.ujN.put("recordId", "TEXT PRIMARY KEY ");
    localStringBuilder.append(" recordId TEXT PRIMARY KEY ");
    localStringBuilder.append(", ");
    locala.ujM = "recordId";
    locala.columns[1] = "link";
    locala.ujN.put("link", "TEXT");
    localStringBuilder.append(" link TEXT");
    localStringBuilder.append(", ");
    locala.columns[2] = "title";
    locala.ujN.put("title", "TEXT");
    localStringBuilder.append(" title TEXT");
    localStringBuilder.append(", ");
    locala.columns[3] = "source";
    locala.ujN.put("source", "TEXT");
    localStringBuilder.append(" source TEXT");
    localStringBuilder.append(", ");
    locala.columns[4] = "imgUrl";
    locala.ujN.put("imgUrl", "TEXT");
    localStringBuilder.append(" imgUrl TEXT");
    localStringBuilder.append(", ");
    locala.columns[5] = "timeStamp";
    locala.ujN.put("timeStamp", "LONG");
    localStringBuilder.append(" timeStamp LONG");
    locala.columns[6] = "rowid";
    locala.sql = localStringBuilder.toString();
    buS = locala;
  }
  
  protected final c.a rM()
  {
    return buS;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.b.d
 * JD-Core Version:    0.7.0.1
 */