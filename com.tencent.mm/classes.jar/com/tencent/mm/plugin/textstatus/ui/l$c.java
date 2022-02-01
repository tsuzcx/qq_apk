package com.tencent.mm.plugin.textstatus.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/textstatus/ui/TextStatusPagerUIC$RedInfo;", "", "showType", "", "count", "(II)V", "getCount", "()I", "setCount", "(I)V", "getShowType", "setShowType", "component1", "component2", "copy", "equals", "", "other", "hashCode", "toString", "", "Companion", "plugin-textstatus_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class l$c
{
  public static final a TzZ;
  int count = 0;
  int hAN = 0;
  
  static
  {
    AppMethodBeat.i(291289);
    TzZ = new a((byte)0);
    AppMethodBeat.o(291289);
  }
  
  public final boolean equals(Object paramObject)
  {
    if (this == paramObject) {}
    do
    {
      return true;
      if (!(paramObject instanceof c)) {
        return false;
      }
      paramObject = (c)paramObject;
      if (this.hAN != paramObject.hAN) {
        return false;
      }
    } while (this.count == paramObject.count);
    return false;
  }
  
  public final int hashCode()
  {
    return this.hAN * 31 + this.count;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(291299);
    String str = "RedInfo(showType=" + this.hAN + ", count=" + this.count + ')';
    AppMethodBeat.o(291299);
    return str;
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/textstatus/ui/TextStatusPagerUIC$RedInfo$Companion;", "", "()V", "SHOW_TYPE_CNT", "", "SHOW_TYPE_NONE", "SHOW_TYPE_POINT", "plugin-textstatus_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.textstatus.ui.l.c
 * JD-Core Version:    0.7.0.1
 */