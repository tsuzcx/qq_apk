package com.tencent.mm.storage.emotion;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.bi;
import com.tencent.mm.sdk.e.c.a;
import java.lang.reflect.Field;
import java.util.Map;

public final class d
  extends bi
{
  protected static c.a info;
  
  static
  {
    AppMethodBeat.i(105049);
    c.a locala = new c.a();
    locala.GvF = new Field[7];
    locala.columns = new String[8];
    StringBuilder localStringBuilder = new StringBuilder();
    locala.columns[0] = "md5_lang";
    locala.GvH.put("md5_lang", "TEXT PRIMARY KEY  COLLATE NOCASE ");
    localStringBuilder.append(" md5_lang TEXT PRIMARY KEY  COLLATE NOCASE ");
    localStringBuilder.append(", ");
    locala.GvG = "md5_lang";
    locala.columns[1] = "md5";
    locala.GvH.put("md5", "TEXT COLLATE NOCASE ");
    localStringBuilder.append(" md5 TEXT COLLATE NOCASE ");
    localStringBuilder.append(", ");
    locala.columns[2] = "lang";
    locala.GvH.put("lang", "TEXT COLLATE NOCASE ");
    localStringBuilder.append(" lang TEXT COLLATE NOCASE ");
    localStringBuilder.append(", ");
    locala.columns[3] = "desc";
    locala.GvH.put("desc", "TEXT");
    localStringBuilder.append(" desc TEXT");
    localStringBuilder.append(", ");
    locala.columns[4] = "groupId";
    locala.GvH.put("groupId", "TEXT default '' ");
    localStringBuilder.append(" groupId TEXT default '' ");
    localStringBuilder.append(", ");
    locala.columns[5] = "click_flag";
    locala.GvH.put("click_flag", "INTEGER");
    localStringBuilder.append(" click_flag INTEGER");
    localStringBuilder.append(", ");
    locala.columns[6] = "download_flag";
    locala.GvH.put("download_flag", "INTEGER");
    localStringBuilder.append(" download_flag INTEGER");
    locala.columns[7] = "rowid";
    locala.sql = localStringBuilder.toString();
    info = locala;
    AppMethodBeat.o(105049);
  }
  
  public final String JC()
  {
    if (this.field_md5 == null) {
      return "";
    }
    return this.field_md5;
  }
  
  public final c.a getDBInfo()
  {
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.storage.emotion.d
 * JD-Core Version:    0.7.0.1
 */