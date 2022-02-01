package com.tencent.mm.storage;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.f.c.d;
import com.tencent.mm.model.c.a;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.storage.IAutoDBItem.MAutoDBInfo;
import java.io.Serializable;
import java.lang.reflect.Field;
import java.util.Map;

public final class c
  extends d
  implements Serializable
{
  protected static IAutoDBItem.MAutoDBInfo info;
  private Map<String, String> Vct = null;
  
  static
  {
    AppMethodBeat.i(153160);
    IAutoDBItem.MAutoDBInfo localMAutoDBInfo = new IAutoDBItem.MAutoDBInfo();
    localMAutoDBInfo.fields = new Field[9];
    localMAutoDBInfo.columns = new String[10];
    StringBuilder localStringBuilder = new StringBuilder();
    localMAutoDBInfo.columns[0] = "layerId";
    localMAutoDBInfo.colsMap.put("layerId", "TEXT PRIMARY KEY ");
    localStringBuilder.append(" layerId TEXT PRIMARY KEY ");
    localStringBuilder.append(", ");
    localMAutoDBInfo.primaryKey = "layerId";
    localMAutoDBInfo.columns[1] = "business";
    localMAutoDBInfo.colsMap.put("business", "TEXT");
    localStringBuilder.append(" business TEXT");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[2] = "expId";
    localMAutoDBInfo.colsMap.put("expId", "TEXT");
    localStringBuilder.append(" expId TEXT");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[3] = "sequence";
    localMAutoDBInfo.colsMap.put("sequence", "LONG");
    localStringBuilder.append(" sequence LONG");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[4] = "prioritylevel";
    localMAutoDBInfo.colsMap.put("prioritylevel", "INTEGER default '0' ");
    localStringBuilder.append(" prioritylevel INTEGER default '0' ");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[5] = "startTime";
    localMAutoDBInfo.colsMap.put("startTime", "LONG");
    localStringBuilder.append(" startTime LONG");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[6] = "endTime";
    localMAutoDBInfo.colsMap.put("endTime", "LONG");
    localStringBuilder.append(" endTime LONG");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[7] = "needReport";
    localMAutoDBInfo.colsMap.put("needReport", "INTEGER");
    localStringBuilder.append(" needReport INTEGER");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[8] = "rawXML";
    localMAutoDBInfo.colsMap.put("rawXML", "TEXT default '' ");
    localStringBuilder.append(" rawXML TEXT default '' ");
    localMAutoDBInfo.columns[9] = "rowid";
    localMAutoDBInfo.sql = localStringBuilder.toString();
    info = localMAutoDBInfo;
    AppMethodBeat.o(153160);
  }
  
  public final IAutoDBItem.MAutoDBInfo getDBInfo()
  {
    return info;
  }
  
  public final Map<String, String> hvz()
  {
    AppMethodBeat.i(153159);
    if (this.Vct == null) {
      this.Vct = a.Sx(this.field_rawXML);
    }
    Map localMap = this.Vct;
    AppMethodBeat.o(153159);
    return localMap;
  }
  
  public final boolean isValid()
  {
    AppMethodBeat.i(153158);
    long l = Util.nowSecond();
    if ((l >= this.field_startTime) && (l <= this.field_endTime))
    {
      AppMethodBeat.o(153158);
      return true;
    }
    AppMethodBeat.o(153158);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.storage.c
 * JD-Core Version:    0.7.0.1
 */