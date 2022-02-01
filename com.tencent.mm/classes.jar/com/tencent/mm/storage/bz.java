package com.tencent.mm.storage;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.fz;
import com.tencent.mm.sdk.e.c.a;
import java.lang.reflect.Field;
import java.util.Map;

public final class bz
  extends fz
{
  protected static c.a info;
  
  static
  {
    AppMethodBeat.i(43306);
    c.a locala = new c.a();
    locala.GvF = new Field[5];
    locala.columns = new String[6];
    StringBuilder localStringBuilder = new StringBuilder();
    locala.columns[0] = "encryptUsername";
    locala.GvH.put("encryptUsername", "TEXT default ''  PRIMARY KEY ");
    localStringBuilder.append(" encryptUsername TEXT default ''  PRIMARY KEY ");
    localStringBuilder.append(", ");
    locala.GvG = "encryptUsername";
    locala.columns[1] = "conRemark";
    locala.GvH.put("conRemark", "TEXT default '' ");
    localStringBuilder.append(" conRemark TEXT default '' ");
    localStringBuilder.append(", ");
    locala.columns[2] = "contactLabels";
    locala.GvH.put("contactLabels", "TEXT default '' ");
    localStringBuilder.append(" contactLabels TEXT default '' ");
    localStringBuilder.append(", ");
    locala.columns[3] = "conDescription";
    locala.GvH.put("conDescription", "TEXT default '' ");
    localStringBuilder.append(" conDescription TEXT default '' ");
    localStringBuilder.append(", ");
    locala.columns[4] = "conPhone";
    locala.GvH.put("conPhone", "TEXT default '' ");
    localStringBuilder.append(" conPhone TEXT default '' ");
    locala.columns[5] = "rowid";
    locala.sql = localStringBuilder.toString();
    info = locala;
    AppMethodBeat.o(43306);
  }
  
  public bz()
  {
    AppMethodBeat.i(43304);
    this.field_encryptUsername = "";
    this.field_conRemark = "";
    AppMethodBeat.o(43304);
  }
  
  public bz(String paramString)
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
  
  public bz(String paramString1, String paramString2)
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
  
  public final String Tm()
  {
    return this.field_conRemark;
  }
  
  public final String Tq()
  {
    return this.field_encryptUsername;
  }
  
  protected final Object clone()
  {
    AppMethodBeat.i(43305);
    Object localObject = super.clone();
    AppMethodBeat.o(43305);
    return localObject;
  }
  
  public final c.a getDBInfo()
  {
    return info;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.storage.bz
 * JD-Core Version:    0.7.0.1
 */