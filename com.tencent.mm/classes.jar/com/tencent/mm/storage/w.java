package com.tencent.mm.storage;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.ao;
import com.tencent.mm.j.a.a.c;
import com.tencent.mm.j.a.a.d;
import com.tencent.mm.sdk.e.c.a;
import java.lang.reflect.Field;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public final class w
  extends ao
{
  protected static c.a info;
  
  static
  {
    AppMethodBeat.i(60106);
    c.a locala = new c.a();
    locala.yrK = new Field[6];
    locala.columns = new String[7];
    StringBuilder localStringBuilder = new StringBuilder();
    locala.columns[0] = "username";
    locala.yrM.put("username", "TEXT default ''  PRIMARY KEY ");
    localStringBuilder.append(" username TEXT default ''  PRIMARY KEY ");
    localStringBuilder.append(", ");
    locala.yrL = "username";
    locala.columns[1] = "lastPushSeq";
    locala.yrM.put("lastPushSeq", "LONG");
    localStringBuilder.append(" lastPushSeq LONG");
    localStringBuilder.append(", ");
    locala.columns[2] = "lastLocalSeq";
    locala.yrM.put("lastLocalSeq", "LONG");
    localStringBuilder.append(" lastLocalSeq LONG");
    localStringBuilder.append(", ");
    locala.columns[3] = "lastPushCreateTime";
    locala.yrM.put("lastPushCreateTime", "LONG");
    localStringBuilder.append(" lastPushCreateTime LONG");
    localStringBuilder.append(", ");
    locala.columns[4] = "lastLocalCreateTime";
    locala.yrM.put("lastLocalCreateTime", "LONG");
    localStringBuilder.append(" lastLocalCreateTime LONG");
    localStringBuilder.append(", ");
    locala.columns[5] = "seqBlockInfo";
    locala.yrM.put("seqBlockInfo", "BLOB");
    localStringBuilder.append(" seqBlockInfo BLOB");
    locala.columns[6] = "rowid";
    locala.sql = localStringBuilder.toString();
    info = locala;
    AppMethodBeat.o(60106);
  }
  
  public final c.a getDBInfo()
  {
    return info;
  }
  
  public final List<c> ol(long paramLong)
  {
    AppMethodBeat.i(60103);
    LinkedList localLinkedList = new LinkedList();
    if (this.field_seqBlockInfo == null)
    {
      AppMethodBeat.o(60103);
      return localLinkedList;
    }
    Iterator localIterator = this.field_seqBlockInfo.elE.iterator();
    while (localIterator.hasNext())
    {
      c localc = (c)localIterator.next();
      if (localc.elD <= paramLong) {
        localLinkedList.add(localc);
      }
    }
    AppMethodBeat.o(60103);
    return localLinkedList;
  }
  
  public final List<c> om(long paramLong)
  {
    AppMethodBeat.i(60104);
    LinkedList localLinkedList = new LinkedList();
    if (this.field_seqBlockInfo == null)
    {
      AppMethodBeat.o(60104);
      return localLinkedList;
    }
    Iterator localIterator = this.field_seqBlockInfo.elE.iterator();
    while (localIterator.hasNext())
    {
      c localc = (c)localIterator.next();
      if (localc.elA > paramLong) {
        localLinkedList.add(localc);
      }
    }
    AppMethodBeat.o(60104);
    return localLinkedList;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(60105);
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("username:").append(this.field_username).append(" ");
    ((StringBuilder)localObject).append("lastLocalSeq:").append(this.field_lastLocalSeq).append(" ");
    ((StringBuilder)localObject).append("lastPushSeq:").append(this.field_lastPushSeq).append(" ");
    if (this.field_seqBlockInfo != null)
    {
      ((StringBuilder)localObject).append("block:");
      Iterator localIterator = this.field_seqBlockInfo.elE.iterator();
      while (localIterator.hasNext())
      {
        c localc = (c)localIterator.next();
        ((StringBuilder)localObject).append("[").append(localc.elA).append(":").append(localc.elB).append("][").append(localc.elC).append(":").append(localc.elD).append("] | ");
      }
    }
    localObject = ((StringBuilder)localObject).toString();
    AppMethodBeat.o(60105);
    return localObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.storage.w
 * JD-Core Version:    0.7.0.1
 */