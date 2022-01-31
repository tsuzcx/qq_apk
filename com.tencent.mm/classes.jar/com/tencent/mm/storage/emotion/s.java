package com.tencent.mm.storage.emotion;

import com.tencent.mm.h.c.eb;
import com.tencent.mm.sdk.e.c.a;
import java.lang.reflect.Field;
import java.util.Map;

public final class s
  extends eb
{
  protected static c.a buS;
  
  static
  {
    c.a locala = new c.a();
    locala.ujL = new Field[2];
    locala.columns = new String[3];
    StringBuilder localStringBuilder = new StringBuilder();
    locala.columns[0] = "key";
    locala.ujN.put("key", "TEXT PRIMARY KEY ");
    localStringBuilder.append(" key TEXT PRIMARY KEY ");
    localStringBuilder.append(", ");
    locala.ujM = "key";
    locala.columns[1] = "position";
    locala.ujN.put("position", "INTEGER");
    localStringBuilder.append(" position INTEGER");
    locala.columns[2] = "rowid";
    locala.sql = localStringBuilder.toString();
    buS = locala;
  }
  
  public s() {}
  
  public s(int paramInt, String paramString)
  {
    this.field_position = paramInt;
    this.field_key = paramString;
  }
  
  protected final c.a rM()
  {
    return null;
  }
  
  public final String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("index:").append(this.field_position);
    localStringBuilder.append("key  :").append(this.field_key);
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.storage.emotion.s
 * JD-Core Version:    0.7.0.1
 */