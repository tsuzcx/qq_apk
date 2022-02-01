package com.tencent.mm.plugin.subapp.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.gb;
import com.tencent.mm.sdk.e.c.a;
import java.lang.reflect.Field;
import java.util.Map;

public final class g
  extends gb
{
  protected static c.a info;
  int dtM = -1;
  
  static
  {
    AppMethodBeat.i(28963);
    c.a locala = new c.a();
    locala.EYt = new Field[17];
    locala.columns = new String[18];
    StringBuilder localStringBuilder = new StringBuilder();
    locala.columns[0] = "filename";
    locala.EYv.put("filename", "TEXT");
    localStringBuilder.append(" filename TEXT");
    localStringBuilder.append(", ");
    locala.columns[1] = "user";
    locala.EYv.put("user", "TEXT");
    localStringBuilder.append(" user TEXT");
    localStringBuilder.append(", ");
    locala.columns[2] = "msgid";
    locala.EYv.put("msgid", "LONG");
    localStringBuilder.append(" msgid LONG");
    localStringBuilder.append(", ");
    locala.columns[3] = "offset";
    locala.EYv.put("offset", "INTEGER");
    localStringBuilder.append(" offset INTEGER");
    localStringBuilder.append(", ");
    locala.columns[4] = "filenowsize";
    locala.EYv.put("filenowsize", "INTEGER");
    localStringBuilder.append(" filenowsize INTEGER");
    localStringBuilder.append(", ");
    locala.columns[5] = "totallen";
    locala.EYv.put("totallen", "INTEGER");
    localStringBuilder.append(" totallen INTEGER");
    localStringBuilder.append(", ");
    locala.columns[6] = "status";
    locala.EYv.put("status", "INTEGER");
    localStringBuilder.append(" status INTEGER");
    localStringBuilder.append(", ");
    locala.columns[7] = "createtime";
    locala.EYv.put("createtime", "LONG");
    localStringBuilder.append(" createtime LONG");
    localStringBuilder.append(", ");
    locala.columns[8] = "lastmodifytime";
    locala.EYv.put("lastmodifytime", "LONG");
    localStringBuilder.append(" lastmodifytime LONG");
    localStringBuilder.append(", ");
    locala.columns[9] = "clientid";
    locala.EYv.put("clientid", "TEXT");
    localStringBuilder.append(" clientid TEXT");
    localStringBuilder.append(", ");
    locala.columns[10] = "voicelenght";
    locala.EYv.put("voicelenght", "INTEGER");
    localStringBuilder.append(" voicelenght INTEGER");
    localStringBuilder.append(", ");
    locala.columns[11] = "msglocalid";
    locala.EYv.put("msglocalid", "INTEGER");
    localStringBuilder.append(" msglocalid INTEGER");
    localStringBuilder.append(", ");
    locala.columns[12] = "human";
    locala.EYv.put("human", "TEXT");
    localStringBuilder.append(" human TEXT");
    localStringBuilder.append(", ");
    locala.columns[13] = "voiceformat";
    locala.EYv.put("voiceformat", "INTEGER");
    localStringBuilder.append(" voiceformat INTEGER");
    localStringBuilder.append(", ");
    locala.columns[14] = "nettimes";
    locala.EYv.put("nettimes", "INTEGER");
    localStringBuilder.append(" nettimes INTEGER");
    localStringBuilder.append(", ");
    locala.columns[15] = "reserved1";
    locala.EYv.put("reserved1", "INTEGER");
    localStringBuilder.append(" reserved1 INTEGER");
    localStringBuilder.append(", ");
    locala.columns[16] = "reserved2";
    locala.EYv.put("reserved2", "TEXT");
    localStringBuilder.append(" reserved2 TEXT");
    locala.columns[17] = "rowid";
    locala.sql = localStringBuilder.toString();
    info = locala;
    AppMethodBeat.o(28963);
  }
  
  public final boolean aDC()
  {
    return ((this.field_status > 1) && (this.field_status <= 3)) || (this.field_status == 8);
  }
  
  public final c.a getDBInfo()
  {
    return info;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.subapp.d.g
 * JD-Core Version:    0.7.0.1
 */