package com.tencent.mm.sdk.storage.sql;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/sdk/storage/sql/SelectSql$Builder$Limit;", "", "limit", "", "offset", "(II)V", "getLimit", "()I", "getOffset", "component1", "component2", "copy", "equals", "", "other", "hashCode", "toString", "", "wechat-sdk_release"}, k=1, mv={1, 5, 1}, xi=48)
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
    AppMethodBeat.i(244366);
    Limit localLimit = new Limit(paramInt1, paramInt2);
    AppMethodBeat.o(244366);
    return localLimit;
  }
  
  public final boolean equals(Object paramObject)
  {
    if (this == paramObject) {}
    do
    {
      return true;
      if (!(paramObject instanceof Limit)) {
        return false;
      }
      paramObject = (Limit)paramObject;
      if (this.limit != paramObject.limit) {
        return false;
      }
    } while (this.offset == paramObject.offset);
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
    AppMethodBeat.i(244371);
    String str = "Limit(limit=" + this.limit + ", offset=" + this.offset + ')';
    AppMethodBeat.o(244371);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.sdk.storage.sql.SelectSql.Builder.Limit
 * JD-Core Version:    0.7.0.1
 */