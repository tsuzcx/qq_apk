package com.tencent.mm.storage.emotion;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.bk;
import com.tencent.mm.sdk.e.c.a;
import java.lang.reflect.Field;
import java.util.Map;

public final class h
  extends bk
{
  protected static c.a info;
  
  static
  {
    AppMethodBeat.i(105105);
    c.a locala = new c.a();
    locala.GvF = new Field[2];
    locala.columns = new String[3];
    StringBuilder localStringBuilder = new StringBuilder();
    locala.columns[0] = "groupID";
    locala.GvH.put("groupID", "TEXT");
    localStringBuilder.append(" groupID TEXT");
    localStringBuilder.append(", ");
    locala.columns[1] = "desc";
    locala.GvH.put("desc", "TEXT");
    localStringBuilder.append(" desc TEXT");
    locala.columns[2] = "rowid";
    locala.sql = localStringBuilder.toString();
    info = locala;
    AppMethodBeat.o(105105);
  }
  
  public h() {}
  
  public h(String paramString1, String paramString2)
  {
    this.field_groupID = paramString1;
    this.field_desc = paramString2;
  }
  
  public final c.a getDBInfo()
  {
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.storage.emotion.h
 * JD-Core Version:    0.7.0.1
 */