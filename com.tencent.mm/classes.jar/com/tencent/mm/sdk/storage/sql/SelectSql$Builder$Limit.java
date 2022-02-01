package com.tencent.mm.sdk.storage.sql;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/sdk/storage/sql/SelectSql$Builder$Limit;", "", "limit", "", "offset", "(II)V", "getLimit", "()I", "getOffset", "component1", "component2", "copy", "equals", "", "other", "hashCode", "toString", "", "wechat-sdk_release"})
public final class SelectSql$Builder$Limit
{
  private final int limit;
  private final int offset;
  
  public SelectSql$Builder$Limit(int paramInt1, int paramInt2)
  {
    this.limit = paramInt1;
    this.offset = paramInt2;
  }
  
  public final int component1()
  {
    return this.limit;
  }
  
  public final int component2()
  {
    return this.offset;
  }
  
  public final Limit copy(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(186670);
    Limit localLimit = new Limit(paramInt1, paramInt2);
    AppMethodBeat.o(186670);
    return localLimit;
  }
  
  public final boolean equals(Object paramObject)
  {
    if (this != paramObject)
    {
      if ((paramObject instanceof Limit))
      {
        paramObject = (Limit)paramObject;
        if ((this.limit != paramObject.limit) || (this.offset != paramObject.offset)) {}
      }
    }
    else {
      return true;
    }
    return false;
  }
  
  public final int getLimit()
  {
    return this.limit;
  }
  
  public final int getOffset()
  {
    return this.offset;
  }
  
  public final int hashCode()
  {
    return this.limit * 31 + this.offset;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(186678);
    String str = "Limit(limit=" + this.limit + ", offset=" + this.offset + ")";
    AppMethodBeat.o(186678);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.sdk.storage.sql.SelectSql.Builder.Limit
 * JD-Core Version:    0.7.0.1
 */