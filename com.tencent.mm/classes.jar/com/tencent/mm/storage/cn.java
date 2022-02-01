package com.tencent.mm.storage;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.gv;
import com.tencent.mm.sdk.storage.IAutoDBItem.MAutoDBInfo;
import java.lang.reflect.Field;
import java.util.Map;

public final class cn
  extends gv
{
  protected static IAutoDBItem.MAutoDBInfo info;
  
  static
  {
    AppMethodBeat.i(43306);
    IAutoDBItem.MAutoDBInfo localMAutoDBInfo = new IAutoDBItem.MAutoDBInfo();
    localMAutoDBInfo.fields = new Field[5];
    localMAutoDBInfo.columns = new String[6];
    StringBuilder localStringBuilder = new StringBuilder();
    localMAutoDBInfo.columns[0] = "encryptUsername";
    localMAutoDBInfo.colsMap.put("encryptUsername", "TEXT default ''  PRIMARY KEY ");
    localStringBuilder.append(" encryptUsername TEXT default ''  PRIMARY KEY ");
    localStringBuilder.append(", ");
    localMAutoDBInfo.primaryKey = "encryptUsername";
    localMAutoDBInfo.columns[1] = "conRemark";
    localMAutoDBInfo.colsMap.put("conRemark", "TEXT default '' ");
    localStringBuilder.append(" conRemark TEXT default '' ");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[2] = "contactLabels";
    localMAutoDBInfo.colsMap.put("contactLabels", "TEXT default '' ");
    localStringBuilder.append(" contactLabels TEXT default '' ");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[3] = "conDescription";
    localMAutoDBInfo.colsMap.put("conDescription", "TEXT default '' ");
    localStringBuilder.append(" conDescription TEXT default '' ");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[4] = "conPhone";
    localMAutoDBInfo.colsMap.put("conPhone", "TEXT default '' ");
    localStringBuilder.append(" conPhone TEXT default '' ");
    localMAutoDBInfo.columns[5] = "rowid";
    localMAutoDBInfo.sql = localStringBuilder.toString();
    info = localMAutoDBInfo;
    AppMethodBeat.o(43306);
  }
  
  public cn()
  {
    AppMethodBeat.i(43304);
    this.field_encryptUsername = "";
    this.field_conRemark = "";
    AppMethodBeat.o(43304);
  }
  
  public cn(String paramString)
  {
    this();
    AppMethodBeat.i(43302);
    this.field_conRemark = "";
    String str = paramString;
    if (paramString == null) {
      str = "";
    }
    this.field_encryptUsername = str;
    AppMethodBeat.o(43302);
  }
  
  public cn(String paramString1, String paramString2)
  {
    this();
    AppMethodBeat.i(43303);
    String str = paramString1;
    if (paramString1 == null) {
      str = "";
    }
    this.field_encryptUsername = str;
    paramString1 = paramString2;
    if (paramString2 == null) {
      paramString1 = "";
    }
    this.field_conRemark = paramString1;
    AppMethodBeat.o(43303);
  }
  
  public final String ajB()
  {
    return this.field_encryptUsername;
  }
  
  public final String ajy()
  {
    return this.field_conRemark;
  }
  
  protected final Object clone()
  {
    AppMethodBeat.i(43305);
    Object localObject = super.clone();
    AppMethodBeat.o(43305);
    return localObject;
  }
  
  public final IAutoDBItem.MAutoDBInfo getDBInfo()
  {
    return info;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.storage.cn
 * JD-Core Version:    0.7.0.1
 */