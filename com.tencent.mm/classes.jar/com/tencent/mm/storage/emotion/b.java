package com.tencent.mm.storage.emotion;

import com.tencent.mm.h.c.ba;
import com.tencent.mm.sdk.e.c.a;
import java.lang.reflect.Field;
import java.util.Map;

public final class b
  extends ba
{
  protected static c.a buS;
  
  static
  {
    c.a locala = new c.a();
    locala.ujL = new Field[7];
    locala.columns = new String[8];
    StringBuilder localStringBuilder = new StringBuilder();
    locala.columns[0] = "md5_lang";
    locala.ujN.put("md5_lang", "TEXT PRIMARY KEY  COLLATE NOCASE ");
    localStringBuilder.append(" md5_lang TEXT PRIMARY KEY  COLLATE NOCASE ");
    localStringBuilder.append(", ");
    locala.ujM = "md5_lang";
    locala.columns[1] = "md5";
    locala.ujN.put("md5", "TEXT COLLATE NOCASE ");
    localStringBuilder.append(" md5 TEXT COLLATE NOCASE ");
    localStringBuilder.append(", ");
    locala.columns[2] = "lang";
    locala.ujN.put("lang", "TEXT COLLATE NOCASE ");
    localStringBuilder.append(" lang TEXT COLLATE NOCASE ");
    localStringBuilder.append(", ");
    locala.columns[3] = "desc";
    locala.ujN.put("desc", "TEXT");
    localStringBuilder.append(" desc TEXT");
    localStringBuilder.append(", ");
    locala.columns[4] = "groupId";
    locala.ujN.put("groupId", "TEXT default '' ");
    localStringBuilder.append(" groupId TEXT default '' ");
    localStringBuilder.append(", ");
    locala.columns[5] = "click_flag";
    locala.ujN.put("click_flag", "INTEGER");
    localStringBuilder.append(" click_flag INTEGER");
    localStringBuilder.append(", ");
    locala.columns[6] = "download_flag";
    locala.ujN.put("download_flag", "INTEGER");
    localStringBuilder.append(" download_flag INTEGER");
    locala.columns[7] = "rowid";
    locala.sql = localStringBuilder.toString();
    buS = locala;
  }
  
  public final String Wv()
  {
    if (this.field_md5 == null) {
      return "";
    }
    return this.field_md5;
  }
  
  protected final c.a rM()
  {
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.storage.emotion.b
 * JD-Core Version:    0.7.0.1
 */