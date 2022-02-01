package com.tencent.mm.storage;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.fs;
import com.tencent.mm.sdk.e.c.a;
import java.lang.reflect.Field;
import java.util.Map;

public class ce
  extends fs
{
  protected static Field[] IBL;
  public static c.a info;
  
  static
  {
    AppMethodBeat.i(43301);
    IBL = fs.getValidFields(ce.class);
    c.a locala = new c.a();
    locala.IBL = new Field[11];
    locala.columns = new String[12];
    StringBuilder localStringBuilder = new StringBuilder();
    locala.columns[0] = "svrid";
    locala.IBN.put("svrid", "LONG default '0'  PRIMARY KEY ");
    localStringBuilder.append(" svrid LONG default '0'  PRIMARY KEY ");
    localStringBuilder.append(", ");
    locala.IBM = "svrid";
    locala.columns[1] = "status";
    locala.IBN.put("status", "INTEGER");
    localStringBuilder.append(" status INTEGER");
    localStringBuilder.append(", ");
    locala.columns[2] = "type";
    locala.IBN.put("type", "INTEGER");
    localStringBuilder.append(" type INTEGER");
    localStringBuilder.append(", ");
    locala.columns[3] = "scene";
    locala.IBN.put("scene", "INTEGER");
    localStringBuilder.append(" scene INTEGER");
    localStringBuilder.append(", ");
    locala.columns[4] = "createtime";
    locala.IBN.put("createtime", "LONG");
    localStringBuilder.append(" createtime LONG");
    localStringBuilder.append(", ");
    locala.columns[5] = "talker";
    locala.IBN.put("talker", "TEXT");
    localStringBuilder.append(" talker TEXT");
    localStringBuilder.append(", ");
    locala.columns[6] = "content";
    locala.IBN.put("content", "TEXT");
    localStringBuilder.append(" content TEXT");
    localStringBuilder.append(", ");
    locala.columns[7] = "sayhiuser";
    locala.IBN.put("sayhiuser", "TEXT");
    localStringBuilder.append(" sayhiuser TEXT");
    localStringBuilder.append(", ");
    locala.columns[8] = "sayhicontent";
    locala.IBN.put("sayhicontent", "TEXT");
    localStringBuilder.append(" sayhicontent TEXT");
    localStringBuilder.append(", ");
    locala.columns[9] = "imgpath";
    locala.IBN.put("imgpath", "TEXT");
    localStringBuilder.append(" imgpath TEXT");
    localStringBuilder.append(", ");
    locala.columns[10] = "isSend";
    locala.IBN.put("isSend", "INTEGER");
    localStringBuilder.append(" isSend INTEGER");
    locala.columns[11] = "rowid";
    locala.sql = localStringBuilder.toString();
    info = locala;
    AppMethodBeat.o(43301);
  }
  
  public c.a getDBInfo()
  {
    return info;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.storage.ce
 * JD-Core Version:    0.7.0.1
 */