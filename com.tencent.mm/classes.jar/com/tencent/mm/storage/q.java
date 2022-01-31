package com.tencent.mm.storage;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.ah;
import com.tencent.mm.sdk.e.c.a;
import java.lang.reflect.Field;
import java.util.Map;

public final class q
  extends ah
{
  protected static c.a info;
  public boolean ywA = false;
  public boolean ywB = false;
  
  static
  {
    AppMethodBeat.i(11853);
    c.a locala = new c.a();
    locala.yrK = new Field[17];
    locala.columns = new String[18];
    StringBuilder localStringBuilder = new StringBuilder();
    locala.columns[0] = "msgId";
    locala.yrM.put("msgId", "LONG PRIMARY KEY ");
    localStringBuilder.append(" msgId LONG PRIMARY KEY ");
    localStringBuilder.append(", ");
    locala.yrL = "msgId";
    locala.columns[1] = "msgSvrId";
    locala.yrM.put("msgSvrId", "LONG");
    localStringBuilder.append(" msgSvrId LONG");
    localStringBuilder.append(", ");
    locala.columns[2] = "type";
    locala.yrM.put("type", "INTEGER");
    localStringBuilder.append(" type INTEGER");
    localStringBuilder.append(", ");
    locala.columns[3] = "status";
    locala.yrM.put("status", "INTEGER");
    localStringBuilder.append(" status INTEGER");
    localStringBuilder.append(", ");
    locala.columns[4] = "createTime";
    locala.yrM.put("createTime", "LONG");
    localStringBuilder.append(" createTime LONG");
    localStringBuilder.append(", ");
    locala.columns[5] = "talker";
    locala.yrM.put("talker", "TEXT");
    localStringBuilder.append(" talker TEXT");
    localStringBuilder.append(", ");
    locala.columns[6] = "content";
    locala.yrM.put("content", "TEXT default '' ");
    localStringBuilder.append(" content TEXT default '' ");
    localStringBuilder.append(", ");
    locala.columns[7] = "imgPath";
    locala.yrM.put("imgPath", "TEXT");
    localStringBuilder.append(" imgPath TEXT");
    localStringBuilder.append(", ");
    locala.columns[8] = "lvbuffer";
    locala.yrM.put("lvbuffer", "BLOB");
    localStringBuilder.append(" lvbuffer BLOB");
    localStringBuilder.append(", ");
    locala.columns[9] = "talkerId";
    locala.yrM.put("talkerId", "INTEGER");
    localStringBuilder.append(" talkerId INTEGER");
    localStringBuilder.append(", ");
    locala.columns[10] = "isExpand";
    locala.yrM.put("isExpand", "INTEGER");
    localStringBuilder.append(" isExpand INTEGER");
    localStringBuilder.append(", ");
    locala.columns[11] = "orderFlag";
    locala.yrM.put("orderFlag", "LONG default '0' ");
    localStringBuilder.append(" orderFlag LONG default '0' ");
    localStringBuilder.append(", ");
    locala.columns[12] = "hasShow";
    locala.yrM.put("hasShow", "INTEGER default '1' ");
    localStringBuilder.append(" hasShow INTEGER default '1' ");
    localStringBuilder.append(", ");
    locala.columns[13] = "placeTop";
    locala.yrM.put("placeTop", "INTEGER default '1' ");
    localStringBuilder.append(" placeTop INTEGER default '1' ");
    localStringBuilder.append(", ");
    locala.columns[14] = "appMsgStatInfoProto";
    locala.yrM.put("appMsgStatInfoProto", "BLOB");
    localStringBuilder.append(" appMsgStatInfoProto BLOB");
    localStringBuilder.append(", ");
    locala.columns[15] = "isRead";
    locala.yrM.put("isRead", "INTEGER default '0' ");
    localStringBuilder.append(" isRead INTEGER default '0' ");
    localStringBuilder.append(", ");
    locala.columns[16] = "bitFlag";
    locala.yrM.put("bitFlag", "INTEGER default '0' ");
    localStringBuilder.append(" bitFlag INTEGER default '0' ");
    locala.columns[17] = "rowid";
    locala.sql = localStringBuilder.toString();
    info = locala;
    AppMethodBeat.o(11853);
  }
  
  public final long dvU()
  {
    return (this.field_orderFlag & 0x0) >> 32;
  }
  
  public final boolean dvV()
  {
    return this.field_type == 285212721;
  }
  
  public final boolean dvW()
  {
    return this.field_type == 34;
  }
  
  public final boolean dvX()
  {
    switch (this.field_type)
    {
    default: 
      return false;
    }
    return true;
  }
  
  public final boolean dvY()
  {
    AppMethodBeat.i(11852);
    if (dvU() == 1L)
    {
      AppMethodBeat.o(11852);
      return true;
    }
    AppMethodBeat.o(11852);
    return false;
  }
  
  public final boolean dvZ()
  {
    return (this.field_bitFlag & 0x1) != 0;
  }
  
  public final void dwa()
  {
    this.field_bitFlag |= 0x1;
  }
  
  public final c.a getDBInfo()
  {
    return info;
  }
  
  public final boolean isText()
  {
    switch (this.field_type)
    {
    default: 
      return false;
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.storage.q
 * JD-Core Version:    0.7.0.1
 */