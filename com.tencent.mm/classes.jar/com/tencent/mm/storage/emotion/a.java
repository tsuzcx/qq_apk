package com.tencent.mm.storage.emotion;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.bg;
import com.tencent.mm.sdk.e.c.a;
import java.lang.reflect.Field;
import java.util.Map;

public final class a
  extends bg
{
  protected static c.a info;
  
  static
  {
    AppMethodBeat.i(183925);
    c.a locala = new c.a();
    locala.IBL = new Field[3];
    locala.columns = new String[4];
    StringBuilder localStringBuilder = new StringBuilder();
    locala.columns[0] = "designerUin";
    locala.IBN.put("designerUin", "INTEGER");
    localStringBuilder.append(" designerUin INTEGER");
    localStringBuilder.append(", ");
    locala.columns[1] = "productId";
    locala.IBN.put("productId", "TEXT");
    localStringBuilder.append(" productId TEXT");
    localStringBuilder.append(", ");
    locala.columns[2] = "syncTime";
    locala.IBN.put("syncTime", "INTEGER");
    localStringBuilder.append(" syncTime INTEGER");
    locala.columns[3] = "rowid";
    locala.sql = localStringBuilder.toString();
    info = locala;
    AppMethodBeat.o(183925);
  }
  
  public final c.a getDBInfo()
  {
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.storage.emotion.a
 * JD-Core Version:    0.7.0.1
 */