package com.tencent.mm.plugin.sns.storage;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.gm;
import com.tencent.mm.protocal.protobuf.dqi;
import com.tencent.mm.sdk.storage.IAutoDBItem.MAutoDBInfo;
import java.lang.reflect.Field;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public final class s
  extends gm
{
  protected static IAutoDBItem.MAutoDBInfo info;
  public int EmS;
  
  static
  {
    AppMethodBeat.i(97623);
    IAutoDBItem.MAutoDBInfo localMAutoDBInfo = new IAutoDBItem.MAutoDBInfo();
    localMAutoDBInfo.fields = new Field[4];
    localMAutoDBInfo.columns = new String[5];
    StringBuilder localStringBuilder = new StringBuilder();
    localMAutoDBInfo.columns[0] = "tagId";
    localMAutoDBInfo.colsMap.put("tagId", "LONG default '0' ");
    localStringBuilder.append(" tagId LONG default '0' ");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[1] = "tagName";
    localMAutoDBInfo.colsMap.put("tagName", "TEXT default '' ");
    localStringBuilder.append(" tagName TEXT default '' ");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[2] = "count";
    localMAutoDBInfo.colsMap.put("count", "INTEGER default '0' ");
    localStringBuilder.append(" count INTEGER default '0' ");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[3] = "memberList";
    localMAutoDBInfo.colsMap.put("memberList", "TEXT default '' ");
    localStringBuilder.append(" memberList TEXT default '' ");
    localMAutoDBInfo.columns[4] = "rowid";
    localMAutoDBInfo.sql = localStringBuilder.toString();
    info = localMAutoDBInfo;
    AppMethodBeat.o(97623);
  }
  
  public final void convertFrom(Cursor paramCursor)
  {
    AppMethodBeat.i(97622);
    super.convertFrom(paramCursor);
    this.EmS = ((int)this.systemRowid);
    AppMethodBeat.o(97622);
  }
  
  public final void gX(List<dqi> paramList)
  {
    AppMethodBeat.i(97621);
    this.field_memberList = "";
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      dqi localdqi = (dqi)paramList.next();
      this.field_memberList = (this.field_memberList + localdqi.MTo + ",");
    }
    AppMethodBeat.o(97621);
  }
  
  public final IAutoDBItem.MAutoDBInfo getDBInfo()
  {
    return info;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.storage.s
 * JD-Core Version:    0.7.0.1
 */