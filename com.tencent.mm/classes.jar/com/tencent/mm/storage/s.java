package com.tencent.mm.storage;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.am;
import com.tencent.mm.protocal.protobuf.dap;
import com.tencent.mm.protocal.protobuf.dau;
import com.tencent.mm.sdk.e.c.a;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import java.io.IOException;
import java.lang.reflect.Field;
import java.util.Map;

public final class s
  extends am
{
  protected static c.a info;
  public boolean Fep = false;
  public boolean Feq = false;
  public boolean Fer = false;
  public dau Fes = null;
  public int nah = -1;
  
  static
  {
    AppMethodBeat.i(124608);
    c.a locala = new c.a();
    locala.EYt = new Field[20];
    locala.columns = new String[21];
    StringBuilder localStringBuilder = new StringBuilder();
    locala.columns[0] = "msgId";
    locala.EYv.put("msgId", "LONG PRIMARY KEY ");
    localStringBuilder.append(" msgId LONG PRIMARY KEY ");
    localStringBuilder.append(", ");
    locala.EYu = "msgId";
    locala.columns[1] = "msgSvrId";
    locala.EYv.put("msgSvrId", "LONG");
    localStringBuilder.append(" msgSvrId LONG");
    localStringBuilder.append(", ");
    locala.columns[2] = "type";
    locala.EYv.put("type", "INTEGER");
    localStringBuilder.append(" type INTEGER");
    localStringBuilder.append(", ");
    locala.columns[3] = "status";
    locala.EYv.put("status", "INTEGER");
    localStringBuilder.append(" status INTEGER");
    localStringBuilder.append(", ");
    locala.columns[4] = "createTime";
    locala.EYv.put("createTime", "LONG");
    localStringBuilder.append(" createTime LONG");
    localStringBuilder.append(", ");
    locala.columns[5] = "talker";
    locala.EYv.put("talker", "TEXT");
    localStringBuilder.append(" talker TEXT");
    localStringBuilder.append(", ");
    locala.columns[6] = "content";
    locala.EYv.put("content", "TEXT default '' ");
    localStringBuilder.append(" content TEXT default '' ");
    localStringBuilder.append(", ");
    locala.columns[7] = "imgPath";
    locala.EYv.put("imgPath", "TEXT");
    localStringBuilder.append(" imgPath TEXT");
    localStringBuilder.append(", ");
    locala.columns[8] = "lvbuffer";
    locala.EYv.put("lvbuffer", "BLOB");
    localStringBuilder.append(" lvbuffer BLOB");
    localStringBuilder.append(", ");
    locala.columns[9] = "talkerId";
    locala.EYv.put("talkerId", "INTEGER");
    localStringBuilder.append(" talkerId INTEGER");
    localStringBuilder.append(", ");
    locala.columns[10] = "isExpand";
    locala.EYv.put("isExpand", "INTEGER");
    localStringBuilder.append(" isExpand INTEGER");
    localStringBuilder.append(", ");
    locala.columns[11] = "orderFlag";
    locala.EYv.put("orderFlag", "LONG default '0' ");
    localStringBuilder.append(" orderFlag LONG default '0' ");
    localStringBuilder.append(", ");
    locala.columns[12] = "hasShow";
    locala.EYv.put("hasShow", "INTEGER default '1' ");
    localStringBuilder.append(" hasShow INTEGER default '1' ");
    localStringBuilder.append(", ");
    locala.columns[13] = "placeTop";
    locala.EYv.put("placeTop", "INTEGER default '1' ");
    localStringBuilder.append(" placeTop INTEGER default '1' ");
    localStringBuilder.append(", ");
    locala.columns[14] = "appMsgStatInfoProto";
    locala.EYv.put("appMsgStatInfoProto", "BLOB");
    localStringBuilder.append(" appMsgStatInfoProto BLOB");
    localStringBuilder.append(", ");
    locala.columns[15] = "isRead";
    locala.EYv.put("isRead", "INTEGER default '0' ");
    localStringBuilder.append(" isRead INTEGER default '0' ");
    localStringBuilder.append(", ");
    locala.columns[16] = "bitFlag";
    locala.EYv.put("bitFlag", "INTEGER default '0' ");
    localStringBuilder.append(" bitFlag INTEGER default '0' ");
    localStringBuilder.append(", ");
    locala.columns[17] = "bizRejectMsgId";
    locala.EYv.put("bizRejectMsgId", "LONG default '0' ");
    localStringBuilder.append(" bizRejectMsgId LONG default '0' ");
    localStringBuilder.append(", ");
    locala.columns[18] = "bizClientMsgId";
    locala.EYv.put("bizClientMsgId", "TEXT default '' ");
    localStringBuilder.append(" bizClientMsgId TEXT default '' ");
    localStringBuilder.append(", ");
    locala.columns[19] = "rankSessionId";
    locala.EYv.put("rankSessionId", "TEXT default '' ");
    localStringBuilder.append(" rankSessionId TEXT default '' ");
    locala.columns[20] = "rowid";
    locala.sql = localStringBuilder.toString();
    info = locala;
    AppMethodBeat.o(124608);
  }
  
  private static byte[] c(dau paramdau)
  {
    AppMethodBeat.i(124607);
    if (paramdau == null)
    {
      AppMethodBeat.o(124607);
      return null;
    }
    try
    {
      paramdau = paramdau.toByteArray();
      AppMethodBeat.o(124607);
      return paramdau;
    }
    catch (IOException paramdau)
    {
      ad.w("MicroMsg.BizTimeLineInfo", "getTLRecCardBytes toByteArray ex %s", new Object[] { paramdau.getMessage() });
      AppMethodBeat.o(124607);
    }
    return null;
  }
  
  public final void b(dau paramdau)
  {
    AppMethodBeat.i(124606);
    this.Fes = paramdau;
    N(c(paramdau));
    AppMethodBeat.o(124606);
  }
  
  public final long eJJ()
  {
    return (this.field_orderFlag & 0x0) >> 32;
  }
  
  public final long eJK()
  {
    return (this.field_orderFlag & 0xFF000000) >> 24;
  }
  
  public final boolean eJL()
  {
    return this.field_type == 285212721;
  }
  
  public final boolean eJM()
  {
    return this.field_type == 620757041;
  }
  
  public final boolean eJN()
  {
    return this.field_type == 34;
  }
  
  public final boolean eJO()
  {
    switch (this.field_type)
    {
    default: 
      return false;
    }
    return true;
  }
  
  public final boolean eJP()
  {
    return this.field_type == 10002;
  }
  
  public final boolean eJQ()
  {
    AppMethodBeat.i(124603);
    if (eJJ() == 1L)
    {
      AppMethodBeat.o(124603);
      return true;
    }
    AppMethodBeat.o(124603);
    return false;
  }
  
  public final dap eJR()
  {
    AppMethodBeat.i(124604);
    Object localObject = eJS();
    if (localObject == null)
    {
      AppMethodBeat.o(124604);
      return null;
    }
    localObject = ((dau)localObject).Esz;
    AppMethodBeat.o(124604);
    return localObject;
  }
  
  public final dau eJS()
  {
    AppMethodBeat.i(124605);
    if (bt.cw(this.esi))
    {
      AppMethodBeat.o(124605);
      return null;
    }
    dau localdau;
    if (this.Fes != null)
    {
      localdau = this.Fes;
      AppMethodBeat.o(124605);
      return localdau;
    }
    this.Fes = new dau();
    try
    {
      this.Fes.parseFrom(this.esi);
      localdau = this.Fes;
      AppMethodBeat.o(124605);
      return localdau;
    }
    catch (IOException localIOException)
    {
      for (;;)
      {
        ad.w("MicroMsg.BizTimeLineInfo", "getTLRecCard parseFrom ex %s", new Object[] { localIOException.getMessage() });
        this.Fes = null;
      }
    }
  }
  
  public final boolean eJT()
  {
    return (this.field_bitFlag & 0x1) != 0;
  }
  
  public final c.a getDBInfo()
  {
    return info;
  }
  
  public final void hu(int paramInt)
  {
    this.field_bitFlag |= paramInt;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.storage.s
 * JD-Core Version:    0.7.0.1
 */