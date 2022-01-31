package com.tencent.mm.storage;

import com.tencent.mm.h.c.an;
import com.tencent.mm.k.a.a.c;
import com.tencent.mm.k.a.a.d;
import com.tencent.mm.sdk.e.c.a;
import java.lang.reflect.Field;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public final class w
  extends an
{
  protected static c.a buS;
  
  static
  {
    c.a locala = new c.a();
    locala.ujL = new Field[6];
    locala.columns = new String[7];
    StringBuilder localStringBuilder = new StringBuilder();
    locala.columns[0] = "username";
    locala.ujN.put("username", "TEXT default ''  PRIMARY KEY ");
    localStringBuilder.append(" username TEXT default ''  PRIMARY KEY ");
    localStringBuilder.append(", ");
    locala.ujM = "username";
    locala.columns[1] = "lastPushSeq";
    locala.ujN.put("lastPushSeq", "LONG");
    localStringBuilder.append(" lastPushSeq LONG");
    localStringBuilder.append(", ");
    locala.columns[2] = "lastLocalSeq";
    locala.ujN.put("lastLocalSeq", "LONG");
    localStringBuilder.append(" lastLocalSeq LONG");
    localStringBuilder.append(", ");
    locala.columns[3] = "lastPushCreateTime";
    locala.ujN.put("lastPushCreateTime", "LONG");
    localStringBuilder.append(" lastPushCreateTime LONG");
    localStringBuilder.append(", ");
    locala.columns[4] = "lastLocalCreateTime";
    locala.ujN.put("lastLocalCreateTime", "LONG");
    localStringBuilder.append(" lastLocalCreateTime LONG");
    localStringBuilder.append(", ");
    locala.columns[5] = "seqBlockInfo";
    locala.ujN.put("seqBlockInfo", "BLOB");
    localStringBuilder.append(" seqBlockInfo BLOB");
    locala.columns[6] = "rowid";
    locala.sql = localStringBuilder.toString();
    buS = locala;
  }
  
  public final List<c> hD(long paramLong)
  {
    LinkedList localLinkedList = new LinkedList();
    if (this.field_seqBlockInfo == null) {
      return localLinkedList;
    }
    Iterator localIterator = this.field_seqBlockInfo.dtR.iterator();
    while (localIterator.hasNext())
    {
      c localc = (c)localIterator.next();
      if (localc.dtQ <= paramLong) {
        localLinkedList.add(localc);
      }
    }
    return localLinkedList;
  }
  
  protected final c.a rM()
  {
    return buS;
  }
  
  public final String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("username:").append(this.field_username).append(" ");
    localStringBuilder.append("lastLocalSeq:").append(this.field_lastLocalSeq).append(" ");
    localStringBuilder.append("lastPushSeq:").append(this.field_lastPushSeq).append(" ");
    if (this.field_seqBlockInfo != null)
    {
      localStringBuilder.append("block:");
      Iterator localIterator = this.field_seqBlockInfo.dtR.iterator();
      while (localIterator.hasNext())
      {
        c localc = (c)localIterator.next();
        localStringBuilder.append("[").append(localc.dtN).append(":").append(localc.dtO).append("][").append(localc.dtP).append(":").append(localc.dtQ).append("] | ");
      }
    }
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.storage.w
 * JD-Core Version:    0.7.0.1
 */