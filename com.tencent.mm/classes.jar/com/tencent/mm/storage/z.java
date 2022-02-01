package com.tencent.mm.storage;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.at;
import com.tencent.mm.j.a.a.c;
import com.tencent.mm.j.a.a.d;
import com.tencent.mm.sdk.e.c.a;
import java.lang.reflect.Field;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public final class z
  extends at
{
  protected static c.a info;
  
  static
  {
    AppMethodBeat.i(43167);
    c.a locala = new c.a();
    locala.GvF = new Field[6];
    locala.columns = new String[7];
    StringBuilder localStringBuilder = new StringBuilder();
    locala.columns[0] = "username";
    locala.GvH.put("username", "TEXT default ''  PRIMARY KEY ");
    localStringBuilder.append(" username TEXT default ''  PRIMARY KEY ");
    localStringBuilder.append(", ");
    locala.GvG = "username";
    locala.columns[1] = "lastPushSeq";
    locala.GvH.put("lastPushSeq", "LONG");
    localStringBuilder.append(" lastPushSeq LONG");
    localStringBuilder.append(", ");
    locala.columns[2] = "lastLocalSeq";
    locala.GvH.put("lastLocalSeq", "LONG");
    localStringBuilder.append(" lastLocalSeq LONG");
    localStringBuilder.append(", ");
    locala.columns[3] = "lastPushCreateTime";
    locala.GvH.put("lastPushCreateTime", "LONG");
    localStringBuilder.append(" lastPushCreateTime LONG");
    localStringBuilder.append(", ");
    locala.columns[4] = "lastLocalCreateTime";
    locala.GvH.put("lastLocalCreateTime", "LONG");
    localStringBuilder.append(" lastLocalCreateTime LONG");
    localStringBuilder.append(", ");
    locala.columns[5] = "seqBlockInfo";
    locala.GvH.put("seqBlockInfo", "BLOB");
    localStringBuilder.append(" seqBlockInfo BLOB");
    locala.columns[6] = "rowid";
    locala.sql = localStringBuilder.toString();
    info = locala;
    AppMethodBeat.o(43167);
  }
  
  public final List<c> AM(long paramLong)
  {
    AppMethodBeat.i(43164);
    LinkedList localLinkedList = new LinkedList();
    if (this.field_seqBlockInfo == null)
    {
      AppMethodBeat.o(43164);
      return localLinkedList;
    }
    Iterator localIterator = this.field_seqBlockInfo.fCc.iterator();
    while (localIterator.hasNext())
    {
      c localc = (c)localIterator.next();
      if (localc.fCb <= paramLong) {
        localLinkedList.add(localc);
      }
    }
    AppMethodBeat.o(43164);
    return localLinkedList;
  }
  
  public final List<c> AN(long paramLong)
  {
    AppMethodBeat.i(43165);
    LinkedList localLinkedList = new LinkedList();
    if (this.field_seqBlockInfo == null)
    {
      AppMethodBeat.o(43165);
      return localLinkedList;
    }
    Iterator localIterator = this.field_seqBlockInfo.fCc.iterator();
    while (localIterator.hasNext())
    {
      c localc = (c)localIterator.next();
      if (localc.fBY > paramLong) {
        localLinkedList.add(localc);
      }
    }
    AppMethodBeat.o(43165);
    return localLinkedList;
  }
  
  public final c.a getDBInfo()
  {
    return info;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(43166);
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("username:").append(this.field_username).append(" ");
    ((StringBuilder)localObject).append("lastLocalSeq:").append(this.field_lastLocalSeq).append(" ");
    ((StringBuilder)localObject).append("lastPushSeq:").append(this.field_lastPushSeq).append(" ");
    if (this.field_seqBlockInfo != null)
    {
      ((StringBuilder)localObject).append("block:");
      Iterator localIterator = this.field_seqBlockInfo.fCc.iterator();
      while (localIterator.hasNext())
      {
        c localc = (c)localIterator.next();
        ((StringBuilder)localObject).append("[").append(localc.fBY).append(":").append(localc.fBZ).append("][").append(localc.fCa).append(":").append(localc.fCb).append("] | ");
      }
    }
    localObject = ((StringBuilder)localObject).toString();
    AppMethodBeat.o(43166);
    return localObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.storage.z
 * JD-Core Version:    0.7.0.1
 */