package com.tencent.mm.storage;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.dv;
import com.tencent.mm.sdk.e.c.a;
import java.lang.reflect.Field;
import java.util.Map;

public final class bs
  extends dv
{
  public static c.a info;
  
  static
  {
    AppMethodBeat.i(43200);
    c.a locala = new c.a();
    locala.IBL = new Field[14];
    locala.columns = new String[15];
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
    localStringBuilder.append(", ");
    locala.columns[11] = "sayhiencryptuser";
    locala.IBN.put("sayhiencryptuser", "TEXT");
    localStringBuilder.append(" sayhiencryptuser TEXT");
    localStringBuilder.append(", ");
    locala.columns[12] = "ticket";
    locala.IBN.put("ticket", "TEXT");
    localStringBuilder.append(" ticket TEXT");
    localStringBuilder.append(", ");
    locala.columns[13] = "flag";
    locala.IBN.put("flag", "INTEGER");
    localStringBuilder.append(" flag INTEGER");
    locala.columns[14] = "rowid";
    locala.sql = localStringBuilder.toString();
    info = locala;
    AppMethodBeat.o(43200);
  }
  
  public final c.a getDBInfo()
  {
    return info;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.storage.bs
 * JD-Core Version:    0.7.0.1
 */