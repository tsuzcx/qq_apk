package com.tencent.mm.storage;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.am;
import com.tencent.mm.protocal.protobuf.dgb;
import com.tencent.mm.protocal.protobuf.dgg;
import com.tencent.mm.sdk.e.c.a;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import java.io.IOException;
import java.lang.reflect.Field;
import java.util.Map;

public final class t
  extends am
{
  protected static c.a info;
  public boolean GBZ = false;
  public boolean GCa = false;
  public boolean GCb = false;
  public dgg GCc = null;
  public int nCF = -1;
  
  static
  {
    AppMethodBeat.i(124608);
    c.a locala = new c.a();
    locala.GvF = new Field[20];
    locala.columns = new String[21];
    StringBuilder localStringBuilder = new StringBuilder();
    locala.columns[0] = "msgId";
    locala.GvH.put("msgId", "LONG PRIMARY KEY ");
    localStringBuilder.append(" msgId LONG PRIMARY KEY ");
    localStringBuilder.append(", ");
    locala.GvG = "msgId";
    locala.columns[1] = "msgSvrId";
    locala.GvH.put("msgSvrId", "LONG");
    localStringBuilder.append(" msgSvrId LONG");
    localStringBuilder.append(", ");
    locala.columns[2] = "type";
    locala.GvH.put("type", "INTEGER");
    localStringBuilder.append(" type INTEGER");
    localStringBuilder.append(", ");
    locala.columns[3] = "status";
    locala.GvH.put("status", "INTEGER");
    localStringBuilder.append(" status INTEGER");
    localStringBuilder.append(", ");
    locala.columns[4] = "createTime";
    locala.GvH.put("createTime", "LONG");
    localStringBuilder.append(" createTime LONG");
    localStringBuilder.append(", ");
    locala.columns[5] = "talker";
    locala.GvH.put("talker", "TEXT");
    localStringBuilder.append(" talker TEXT");
    localStringBuilder.append(", ");
    locala.columns[6] = "content";
    locala.GvH.put("content", "TEXT default '' ");
    localStringBuilder.append(" content TEXT default '' ");
    localStringBuilder.append(", ");
    locala.columns[7] = "imgPath";
    locala.GvH.put("imgPath", "TEXT");
    localStringBuilder.append(" imgPath TEXT");
    localStringBuilder.append(", ");
    locala.columns[8] = "lvbuffer";
    locala.GvH.put("lvbuffer", "BLOB");
    localStringBuilder.append(" lvbuffer BLOB");
    localStringBuilder.append(", ");
    locala.columns[9] = "talkerId";
    locala.GvH.put("talkerId", "INTEGER");
    localStringBuilder.append(" talkerId INTEGER");
    localStringBuilder.append(", ");
    locala.columns[10] = "isExpand";
    locala.GvH.put("isExpand", "INTEGER");
    localStringBuilder.append(" isExpand INTEGER");
    localStringBuilder.append(", ");
    locala.columns[11] = "orderFlag";
    locala.GvH.put("orderFlag", "LONG default '0' ");
    localStringBuilder.append(" orderFlag LONG default '0' ");
    localStringBuilder.append(", ");
    locala.columns[12] = "hasShow";
    locala.GvH.put("hasShow", "INTEGER default '1' ");
    localStringBuilder.append(" hasShow INTEGER default '1' ");
    localStringBuilder.append(", ");
    locala.columns[13] = "placeTop";
    locala.GvH.put("placeTop", "INTEGER default '1' ");
    localStringBuilder.append(" placeTop INTEGER default '1' ");
    localStringBuilder.append(", ");
    locala.columns[14] = "appMsgStatInfoProto";
    locala.GvH.put("appMsgStatInfoProto", "BLOB");
    localStringBuilder.append(" appMsgStatInfoProto BLOB");
    localStringBuilder.append(", ");
    locala.columns[15] = "isRead";
    locala.GvH.put("isRead", "INTEGER default '0' ");
    localStringBuilder.append(" isRead INTEGER default '0' ");
    localStringBuilder.append(", ");
    locala.columns[16] = "bitFlag";
    locala.GvH.put("bitFlag", "INTEGER default '0' ");
    localStringBuilder.append(" bitFlag INTEGER default '0' ");
    localStringBuilder.append(", ");
    locala.columns[17] = "bizRejectMsgId";
    locala.GvH.put("bizRejectMsgId", "LONG default '0' ");
    localStringBuilder.append(" bizRejectMsgId LONG default '0' ");
    localStringBuilder.append(", ");
    locala.columns[18] = "bizClientMsgId";
    locala.GvH.put("bizClientMsgId", "TEXT default '' ");
    localStringBuilder.append(" bizClientMsgId TEXT default '' ");
    localStringBuilder.append(", ");
    locala.columns[19] = "rankSessionId";
    locala.GvH.put("rankSessionId", "TEXT default '' ");
    localStringBuilder.append(" rankSessionId TEXT default '' ");
    locala.columns[20] = "rowid";
    locala.sql = localStringBuilder.toString();
    info = locala;
    AppMethodBeat.o(124608);
  }
  
  private static byte[] c(dgg paramdgg)
  {
    AppMethodBeat.i(124607);
    if (paramdgg == null)
    {
      AppMethodBeat.o(124607);
      return null;
    }
    try
    {
      paramdgg = paramdgg.toByteArray();
      AppMethodBeat.o(124607);
      return paramdgg;
    }
    catch (IOException paramdgg)
    {
      ac.w("MicroMsg.BizTimeLineInfo", "getTLRecCardBytes toByteArray ex %s", new Object[] { paramdgg.getMessage() });
      AppMethodBeat.o(124607);
    }
    return null;
  }
  
  public final void b(dgg paramdgg)
  {
    AppMethodBeat.i(124606);
    this.GCc = paramdgg;
    L(c(paramdgg));
    AppMethodBeat.o(124606);
  }
  
  public final long eZh()
  {
    return (this.field_orderFlag & 0x0) >> 32;
  }
  
  public final long eZi()
  {
    return (this.field_orderFlag & 0xFF000000) >> 24;
  }
  
  public final boolean eZj()
  {
    return this.field_type == 285212721;
  }
  
  public final boolean eZk()
  {
    return this.field_type == 620757041;
  }
  
  public final boolean eZl()
  {
    return this.field_type == 34;
  }
  
  public final boolean eZm()
  {
    switch (this.field_type)
    {
    default: 
      return false;
    }
    return true;
  }
  
  public final boolean eZn()
  {
    return this.field_type == 10002;
  }
  
  public final boolean eZo()
  {
    AppMethodBeat.i(124603);
    if (eZh() == 1L)
    {
      AppMethodBeat.o(124603);
      return true;
    }
    AppMethodBeat.o(124603);
    return false;
  }
  
  public final dgb eZp()
  {
    AppMethodBeat.i(124604);
    Object localObject = eZq();
    if (localObject == null)
    {
      AppMethodBeat.o(124604);
      return null;
    }
    localObject = ((dgg)localObject).FPB;
    AppMethodBeat.o(124604);
    return localObject;
  }
  
  public final dgg eZq()
  {
    AppMethodBeat.i(124605);
    if (bs.cv(this.eum))
    {
      AppMethodBeat.o(124605);
      return null;
    }
    dgg localdgg;
    if (this.GCc != null)
    {
      localdgg = this.GCc;
      AppMethodBeat.o(124605);
      return localdgg;
    }
    this.GCc = new dgg();
    try
    {
      this.GCc.parseFrom(this.eum);
      localdgg = this.GCc;
      AppMethodBeat.o(124605);
      return localdgg;
    }
    catch (IOException localIOException)
    {
      for (;;)
      {
        ac.w("MicroMsg.BizTimeLineInfo", "getTLRecCard parseFrom ex %s", new Object[] { localIOException.getMessage() });
        this.GCc = null;
      }
    }
  }
  
  public final c.a getDBInfo()
  {
    return info;
  }
  
  public final boolean hc(int paramInt)
  {
    return (this.field_bitFlag & paramInt) != 0;
  }
  
  public final void hd(int paramInt)
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.storage.t
 * JD-Core Version:    0.7.0.1
 */