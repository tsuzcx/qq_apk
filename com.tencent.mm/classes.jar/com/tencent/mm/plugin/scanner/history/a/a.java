package com.tencent.mm.plugin.scanner.history.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.fo;
import com.tencent.mm.sdk.e.c.a;
import java.lang.reflect.Field;
import java.util.Map;

public final class a
  extends fo
{
  public static c.a info;
  
  static
  {
    AppMethodBeat.i(51587);
    c.a locala = new c.a();
    locala.IBL = new Field[6];
    locala.columns = new String[7];
    StringBuilder localStringBuilder = new StringBuilder();
    locala.columns[0] = "productId";
    locala.IBN.put("productId", "TEXT PRIMARY KEY ");
    localStringBuilder.append(" productId TEXT PRIMARY KEY ");
    localStringBuilder.append(", ");
    locala.IBM = "productId";
    locala.columns[1] = "xmlContent";
    locala.IBN.put("xmlContent", "TEXT");
    localStringBuilder.append(" xmlContent TEXT");
    localStringBuilder.append(", ");
    locala.columns[2] = "ScanTime";
    locala.IBN.put("ScanTime", "LONG");
    localStringBuilder.append(" ScanTime LONG");
    localStringBuilder.append(", ");
    locala.columns[3] = "funcType";
    locala.IBN.put("funcType", "INTEGER");
    localStringBuilder.append(" funcType INTEGER");
    localStringBuilder.append(", ");
    locala.columns[4] = "qrcodeUrl";
    locala.IBN.put("qrcodeUrl", "TEXT");
    localStringBuilder.append(" qrcodeUrl TEXT");
    localStringBuilder.append(", ");
    locala.columns[5] = "scene";
    locala.IBN.put("scene", "INTEGER");
    localStringBuilder.append(" scene INTEGER");
    locala.columns[6] = "rowid";
    locala.sql = localStringBuilder.toString();
    info = locala;
    AppMethodBeat.o(51587);
  }
  
  public final c.a getDBInfo()
  {
    return info;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.scanner.history.a.a
 * JD-Core Version:    0.7.0.1
 */