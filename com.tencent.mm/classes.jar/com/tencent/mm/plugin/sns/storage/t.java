package com.tencent.mm.plugin.sns.storage;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.es;
import com.tencent.mm.protocal.protobuf.bwc;
import com.tencent.mm.sdk.e.c.a;
import java.lang.reflect.Field;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public final class t
  extends es
{
  protected static c.a info;
  public int rDH;
  
  static
  {
    AppMethodBeat.i(38004);
    c.a locala = new c.a();
    locala.yrK = new Field[4];
    locala.columns = new String[5];
    StringBuilder localStringBuilder = new StringBuilder();
    locala.columns[0] = "tagId";
    locala.yrM.put("tagId", "LONG default '0' ");
    localStringBuilder.append(" tagId LONG default '0' ");
    localStringBuilder.append(", ");
    locala.columns[1] = "tagName";
    locala.yrM.put("tagName", "TEXT default '' ");
    localStringBuilder.append(" tagName TEXT default '' ");
    localStringBuilder.append(", ");
    locala.columns[2] = "count";
    locala.yrM.put("count", "INTEGER default '0' ");
    localStringBuilder.append(" count INTEGER default '0' ");
    localStringBuilder.append(", ");
    locala.columns[3] = "memberList";
    locala.yrM.put("memberList", "TEXT default '' ");
    localStringBuilder.append(" memberList TEXT default '' ");
    locala.columns[4] = "rowid";
    locala.sql = localStringBuilder.toString();
    info = locala;
    AppMethodBeat.o(38004);
  }
  
  public final void convertFrom(Cursor paramCursor)
  {
    AppMethodBeat.i(38003);
    super.convertFrom(paramCursor);
    this.rDH = ((int)this.systemRowid);
    AppMethodBeat.o(38003);
  }
  
  public final void dj(List<bwc> paramList)
  {
    AppMethodBeat.i(38002);
    this.field_memberList = "";
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      bwc localbwc = (bwc)paramList.next();
      this.field_memberList = (this.field_memberList + localbwc.xJE + ",");
    }
    AppMethodBeat.o(38002);
  }
  
  public final c.a getDBInfo()
  {
    return info;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.storage.t
 * JD-Core Version:    0.7.0.1
 */