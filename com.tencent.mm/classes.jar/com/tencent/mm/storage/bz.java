package com.tencent.mm.storage;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.fc;
import com.tencent.mm.sdk.e.c.a;
import java.lang.reflect.Field;
import java.util.Map;

public final class bz
  extends fc
{
  protected static c.a info;
  
  static
  {
    AppMethodBeat.i(29070);
    c.a locala = new c.a();
    locala.yrK = new Field[3];
    locala.columns = new String[4];
    StringBuilder localStringBuilder = new StringBuilder();
    locala.columns[0] = "openId";
    locala.yrM.put("openId", "TEXT PRIMARY KEY ");
    localStringBuilder.append(" openId TEXT PRIMARY KEY ");
    localStringBuilder.append(", ");
    locala.yrL = "openId";
    locala.columns[1] = "appId";
    locala.yrM.put("appId", "TEXT");
    localStringBuilder.append(" appId TEXT");
    localStringBuilder.append(", ");
    locala.columns[2] = "username";
    locala.yrM.put("username", "TEXT");
    localStringBuilder.append(" username TEXT");
    locala.columns[3] = "rowid";
    locala.sql = localStringBuilder.toString();
    info = locala;
    AppMethodBeat.o(29070);
  }
  
  public bz() {}
  
  public bz(String paramString1, String paramString2, String paramString3)
  {
    this.field_appId = paramString1;
    this.field_username = paramString2;
    this.field_openId = paramString3;
  }
  
  public final c.a getDBInfo()
  {
    return info;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.storage.bz
 * JD-Core Version:    0.7.0.1
 */