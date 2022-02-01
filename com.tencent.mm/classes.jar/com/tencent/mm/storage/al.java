package com.tencent.mm.storage;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.b.ax;
import com.tencent.mm.h.a.a.c;
import com.tencent.mm.h.a.a.d;
import com.tencent.mm.sdk.storage.IAutoDBItem.MAutoDBInfo;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class al
  extends ax
{
  protected static IAutoDBItem.MAutoDBInfo info;
  
  static
  {
    AppMethodBeat.i(43167);
    info = ax.aJm();
    AppMethodBeat.o(43167);
  }
  
  public final IAutoDBItem.MAutoDBInfo getDBInfo()
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
      Iterator localIterator = this.field_seqBlockInfo.lPT.iterator();
      while (localIterator.hasNext())
      {
        c localc = (c)localIterator.next();
        ((StringBuilder)localObject).append("[").append(localc.lPP).append(":").append(localc.lPQ).append("][").append(localc.lPR).append(":").append(localc.lPS).append("] | ");
      }
    }
    localObject = ((StringBuilder)localObject).toString();
    AppMethodBeat.o(43166);
    return localObject;
  }
  
  public final List<c> za(long paramLong)
  {
    AppMethodBeat.i(43164);
    LinkedList localLinkedList = new LinkedList();
    if (this.field_seqBlockInfo == null)
    {
      AppMethodBeat.o(43164);
      return localLinkedList;
    }
    Iterator localIterator = this.field_seqBlockInfo.lPT.iterator();
    while (localIterator.hasNext())
    {
      c localc = (c)localIterator.next();
      if (localc.lPS <= paramLong) {
        localLinkedList.add(localc);
      }
    }
    AppMethodBeat.o(43164);
    return localLinkedList;
  }
  
  public final List<c> zb(long paramLong)
  {
    AppMethodBeat.i(43165);
    LinkedList localLinkedList = new LinkedList();
    if (this.field_seqBlockInfo == null)
    {
      AppMethodBeat.o(43165);
      return localLinkedList;
    }
    Iterator localIterator = this.field_seqBlockInfo.lPT.iterator();
    while (localIterator.hasNext())
    {
      c localc = (c)localIterator.next();
      if (localc.lPP > paramLong) {
        localLinkedList.add(localc);
      }
    }
    AppMethodBeat.o(43165);
    return localLinkedList;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.storage.al
 * JD-Core Version:    0.7.0.1
 */