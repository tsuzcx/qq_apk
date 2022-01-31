package com.tencent.mm.plugin.subapp.c;

import com.tencent.mm.h.c.eo;
import com.tencent.mm.sdk.e.c.a;
import java.lang.reflect.Field;
import java.util.Map;

public final class g
  extends eo
{
  protected static c.a buS;
  int bcw = -1;
  
  static
  {
    c.a locala = new c.a();
    locala.ujL = new Field[17];
    locala.columns = new String[18];
    StringBuilder localStringBuilder = new StringBuilder();
    locala.columns[0] = "filename";
    locala.ujN.put("filename", "TEXT");
    localStringBuilder.append(" filename TEXT");
    localStringBuilder.append(", ");
    locala.columns[1] = "user";
    locala.ujN.put("user", "TEXT");
    localStringBuilder.append(" user TEXT");
    localStringBuilder.append(", ");
    locala.columns[2] = "msgid";
    locala.ujN.put("msgid", "LONG");
    localStringBuilder.append(" msgid LONG");
    localStringBuilder.append(", ");
    locala.columns[3] = "offset";
    locala.ujN.put("offset", "INTEGER");
    localStringBuilder.append(" offset INTEGER");
    localStringBuilder.append(", ");
    locala.columns[4] = "filenowsize";
    locala.ujN.put("filenowsize", "INTEGER");
    localStringBuilder.append(" filenowsize INTEGER");
    localStringBuilder.append(", ");
    locala.columns[5] = "totallen";
    locala.ujN.put("totallen", "INTEGER");
    localStringBuilder.append(" totallen INTEGER");
    localStringBuilder.append(", ");
    locala.columns[6] = "status";
    locala.ujN.put("status", "INTEGER");
    localStringBuilder.append(" status INTEGER");
    localStringBuilder.append(", ");
    locala.columns[7] = "createtime";
    locala.ujN.put("createtime", "LONG");
    localStringBuilder.append(" createtime LONG");
    localStringBuilder.append(", ");
    locala.columns[8] = "lastmodifytime";
    locala.ujN.put("lastmodifytime", "LONG");
    localStringBuilder.append(" lastmodifytime LONG");
    localStringBuilder.append(", ");
    locala.columns[9] = "clientid";
    locala.ujN.put("clientid", "TEXT");
    localStringBuilder.append(" clientid TEXT");
    localStringBuilder.append(", ");
    locala.columns[10] = "voicelenght";
    locala.ujN.put("voicelenght", "INTEGER");
    localStringBuilder.append(" voicelenght INTEGER");
    localStringBuilder.append(", ");
    locala.columns[11] = "msglocalid";
    locala.ujN.put("msglocalid", "INTEGER");
    localStringBuilder.append(" msglocalid INTEGER");
    localStringBuilder.append(", ");
    locala.columns[12] = "human";
    locala.ujN.put("human", "TEXT");
    localStringBuilder.append(" human TEXT");
    localStringBuilder.append(", ");
    locala.columns[13] = "voiceformat";
    locala.ujN.put("voiceformat", "INTEGER");
    localStringBuilder.append(" voiceformat INTEGER");
    localStringBuilder.append(", ");
    locala.columns[14] = "nettimes";
    locala.ujN.put("nettimes", "INTEGER");
    localStringBuilder.append(" nettimes INTEGER");
    localStringBuilder.append(", ");
    locala.columns[15] = "reserved1";
    locala.ujN.put("reserved1", "INTEGER");
    localStringBuilder.append(" reserved1 INTEGER");
    localStringBuilder.append(", ");
    locala.columns[16] = "reserved2";
    locala.ujN.put("reserved2", "TEXT");
    localStringBuilder.append(" reserved2 TEXT");
    locala.columns[17] = "rowid";
    locala.sql = localStringBuilder.toString();
    buS = locala;
  }
  
  public final boolean Tk()
  {
    return ((this.field_status > 1) && (this.field_status <= 3)) || (this.field_status == 8);
  }
  
  protected final c.a rM()
  {
    return buS;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.subapp.c.g
 * JD-Core Version:    0.7.0.1
 */