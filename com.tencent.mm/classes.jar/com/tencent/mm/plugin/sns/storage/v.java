package com.tencent.mm.plugin.sns.storage;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.fo;
import com.tencent.mm.protocal.protobuf.cmf;
import com.tencent.mm.sdk.e.c.a;
import java.lang.reflect.Field;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public final class v
  extends fo
{
  protected static c.a info;
  public int xjo;
  
  static
  {
    AppMethodBeat.i(97623);
    c.a locala = new c.a();
    locala.EYt = new Field[4];
    locala.columns = new String[5];
    StringBuilder localStringBuilder = new StringBuilder();
    locala.columns[0] = "tagId";
    locala.EYv.put("tagId", "LONG default '0' ");
    localStringBuilder.append(" tagId LONG default '0' ");
    localStringBuilder.append(", ");
    locala.columns[1] = "tagName";
    locala.EYv.put("tagName", "TEXT default '' ");
    localStringBuilder.append(" tagName TEXT default '' ");
    localStringBuilder.append(", ");
    locala.columns[2] = "count";
    locala.EYv.put("count", "INTEGER default '0' ");
    localStringBuilder.append(" count INTEGER default '0' ");
    localStringBuilder.append(", ");
    locala.columns[3] = "memberList";
    locala.EYv.put("memberList", "TEXT default '' ");
    localStringBuilder.append(" memberList TEXT default '' ");
    locala.columns[4] = "rowid";
    locala.sql = localStringBuilder.toString();
    info = locala;
    AppMethodBeat.o(97623);
  }
  
  public final void convertFrom(Cursor paramCursor)
  {
    AppMethodBeat.i(97622);
    super.convertFrom(paramCursor);
    this.xjo = ((int)this.systemRowid);
    AppMethodBeat.o(97622);
  }
  
  public final void fz(List<cmf> paramList)
  {
    AppMethodBeat.i(97621);
    this.field_memberList = "";
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      cmf localcmf = (cmf)paramList.next();
      this.field_memberList = (this.field_memberList + localcmf.Ehn + ",");
    }
    AppMethodBeat.o(97621);
  }
  
  public final c.a getDBInfo()
  {
    return info;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.storage.v
 * JD-Core Version:    0.7.0.1
 */