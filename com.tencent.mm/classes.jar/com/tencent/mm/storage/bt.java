package com.tencent.mm.storage;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.ei;
import com.tencent.mm.sdk.e.c.a;
import java.lang.reflect.Field;
import java.util.Map;

public class bt
  extends ei
{
  public static c.a info;
  protected static Field[] yrK;
  
  static
  {
    AppMethodBeat.i(60234);
    yrK = ei.getValidFields(bt.class);
    c.a locala = new c.a();
    locala.yrK = new Field[11];
    locala.columns = new String[12];
    StringBuilder localStringBuilder = new StringBuilder();
    locala.columns[0] = "svrid";
    locala.yrM.put("svrid", "LONG default '0'  PRIMARY KEY ");
    localStringBuilder.append(" svrid LONG default '0'  PRIMARY KEY ");
    localStringBuilder.append(", ");
    locala.yrL = "svrid";
    locala.columns[1] = "status";
    locala.yrM.put("status", "INTEGER");
    localStringBuilder.append(" status INTEGER");
    localStringBuilder.append(", ");
    locala.columns[2] = "type";
    locala.yrM.put("type", "INTEGER");
    localStringBuilder.append(" type INTEGER");
    localStringBuilder.append(", ");
    locala.columns[3] = "scene";
    locala.yrM.put("scene", "INTEGER");
    localStringBuilder.append(" scene INTEGER");
    localStringBuilder.append(", ");
    locala.columns[4] = "createtime";
    locala.yrM.put("createtime", "LONG");
    localStringBuilder.append(" createtime LONG");
    localStringBuilder.append(", ");
    locala.columns[5] = "talker";
    locala.yrM.put("talker", "TEXT");
    localStringBuilder.append(" talker TEXT");
    localStringBuilder.append(", ");
    locala.columns[6] = "content";
    locala.yrM.put("content", "TEXT");
    localStringBuilder.append(" content TEXT");
    localStringBuilder.append(", ");
    locala.columns[7] = "sayhiuser";
    locala.yrM.put("sayhiuser", "TEXT");
    localStringBuilder.append(" sayhiuser TEXT");
    localStringBuilder.append(", ");
    locala.columns[8] = "sayhicontent";
    locala.yrM.put("sayhicontent", "TEXT");
    localStringBuilder.append(" sayhicontent TEXT");
    localStringBuilder.append(", ");
    locala.columns[9] = "imgpath";
    locala.yrM.put("imgpath", "TEXT");
    localStringBuilder.append(" imgpath TEXT");
    localStringBuilder.append(", ");
    locala.columns[10] = "isSend";
    locala.yrM.put("isSend", "INTEGER");
    localStringBuilder.append(" isSend INTEGER");
    locala.columns[11] = "rowid";
    locala.sql = localStringBuilder.toString();
    info = locala;
    AppMethodBeat.o(60234);
  }
  
  public c.a getDBInfo()
  {
    return info;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.storage.bt
 * JD-Core Version:    0.7.0.1
 */