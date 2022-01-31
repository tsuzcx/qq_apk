package com.tencent.mm.storage;

import com.tencent.mm.h.c.ei;
import com.tencent.mm.sdk.e.c.a;
import java.lang.reflect.Field;
import java.util.Map;

public final class bv
  extends ei
{
  protected static c.a buS;
  
  static
  {
    c.a locala = new c.a();
    locala.ujL = new Field[5];
    locala.columns = new String[6];
    StringBuilder localStringBuilder = new StringBuilder();
    locala.columns[0] = "encryptUsername";
    locala.ujN.put("encryptUsername", "TEXT default ''  PRIMARY KEY ");
    localStringBuilder.append(" encryptUsername TEXT default ''  PRIMARY KEY ");
    localStringBuilder.append(", ");
    locala.ujM = "encryptUsername";
    locala.columns[1] = "conRemark";
    locala.ujN.put("conRemark", "TEXT default '' ");
    localStringBuilder.append(" conRemark TEXT default '' ");
    localStringBuilder.append(", ");
    locala.columns[2] = "contactLabels";
    locala.ujN.put("contactLabels", "TEXT default '' ");
    localStringBuilder.append(" contactLabels TEXT default '' ");
    localStringBuilder.append(", ");
    locala.columns[3] = "conDescription";
    locala.ujN.put("conDescription", "TEXT default '' ");
    localStringBuilder.append(" conDescription TEXT default '' ");
    localStringBuilder.append(", ");
    locala.columns[4] = "conPhone";
    locala.ujN.put("conPhone", "TEXT default '' ");
    localStringBuilder.append(" conPhone TEXT default '' ");
    locala.columns[5] = "rowid";
    locala.sql = localStringBuilder.toString();
    buS = locala;
  }
  
  public bv()
  {
    this.field_encryptUsername = "";
    this.field_conRemark = "";
  }
  
  public bv(String paramString)
  {
    this();
    this.field_conRemark = "";
    String str = paramString;
    if (paramString == null) {
      str = "";
    }
    this.field_encryptUsername = str;
  }
  
  public bv(String paramString1, String paramString2)
  {
    this();
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
  }
  
  protected final Object clone()
  {
    return super.clone();
  }
  
  protected final c.a rM()
  {
    return buS;
  }
  
  public final String vl()
  {
    return this.field_conRemark;
  }
  
  public final String vp()
  {
    return this.field_encryptUsername;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.storage.bv
 * JD-Core Version:    0.7.0.1
 */