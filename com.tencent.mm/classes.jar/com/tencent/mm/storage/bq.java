package com.tencent.mm.storage;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.cu;
import com.tencent.mm.sdk.storage.IAutoDBItem.MAutoDBInfo;
import java.lang.reflect.Field;
import java.util.Map;

public final class bq
  extends cu
{
  protected static IAutoDBItem.MAutoDBInfo info;
  
  static
  {
    AppMethodBeat.i(225990);
    IAutoDBItem.MAutoDBInfo localMAutoDBInfo = new IAutoDBItem.MAutoDBInfo();
    localMAutoDBInfo.fields = new Field[3];
    localMAutoDBInfo.columns = new String[4];
    StringBuilder localStringBuilder = new StringBuilder();
    localMAutoDBInfo.columns[0] = "encryptUsername";
    localMAutoDBInfo.colsMap.put("encryptUsername", "TEXT default ''  PRIMARY KEY ");
    localStringBuilder.append(" encryptUsername TEXT default ''  PRIMARY KEY ");
    localStringBuilder.append(", ");
    localMAutoDBInfo.primaryKey = "encryptUsername";
    localMAutoDBInfo.columns[1] = "username";
    localMAutoDBInfo.colsMap.put("username", "TEXT default '' ");
    localStringBuilder.append(" username TEXT default '' ");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[2] = "modifyTime";
    localMAutoDBInfo.colsMap.put("modifyTime", "LONG default '0' ");
    localStringBuilder.append(" modifyTime LONG default '0' ");
    localMAutoDBInfo.columns[3] = "rowid";
    localMAutoDBInfo.sql = localStringBuilder.toString();
    info = localMAutoDBInfo;
    AppMethodBeat.o(225990);
  }
  
  public bq()
  {
    AppMethodBeat.i(225989);
    this.field_encryptUsername = "";
    this.field_username = "";
    AppMethodBeat.o(225989);
  }
  
  public bq(String paramString)
  {
    this();
    AppMethodBeat.i(225988);
    String str = paramString;
    if (paramString == null) {
      str = "";
    }
    this.field_encryptUsername = str;
    this.field_modifyTime = System.currentTimeMillis();
    AppMethodBeat.o(225988);
  }
  
  public final IAutoDBItem.MAutoDBInfo getDBInfo()
  {
    return info;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.storage.bq
 * JD-Core Version:    0.7.0.1
 */