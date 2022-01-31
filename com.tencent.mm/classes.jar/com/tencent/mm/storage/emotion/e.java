package com.tencent.mm.storage.emotion;

import com.tencent.mm.h.c.bb;
import com.tencent.mm.sdk.e.c.a;
import java.lang.reflect.Field;
import java.util.Map;

public final class e
  extends bb
{
  protected static c.a buS;
  
  static
  {
    c.a locala = new c.a();
    locala.ujL = new Field[2];
    locala.columns = new String[3];
    StringBuilder localStringBuilder = new StringBuilder();
    locala.columns[0] = "groupID";
    locala.ujN.put("groupID", "TEXT");
    localStringBuilder.append(" groupID TEXT");
    localStringBuilder.append(", ");
    locala.columns[1] = "desc";
    locala.ujN.put("desc", "TEXT");
    localStringBuilder.append(" desc TEXT");
    locala.columns[2] = "rowid";
    locala.sql = localStringBuilder.toString();
    buS = locala;
  }
  
  public e() {}
  
  public e(String paramString1, String paramString2)
  {
    this.field_groupID = paramString1;
    this.field_desc = paramString2;
  }
  
  protected final c.a rM()
  {
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.storage.emotion.e
 * JD-Core Version:    0.7.0.1
 */