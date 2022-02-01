package com.tencent.mm.plugin.multitalk.ui.widget.projector;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/multitalk/ui/widget/projector/ScreenConfig$MoreItem;", "", "name", "", "func", "", "(Ljava/lang/String;I)V", "getFunc", "()I", "setFunc", "(I)V", "getName", "()Ljava/lang/String;", "setName", "(Ljava/lang/String;)V", "component1", "component2", "copy", "equals", "", "other", "hashCode", "toString", "plugin-multitalk_release"})
public final class e$c
{
  String name;
  int zWi;
  
  public e$c(String paramString, int paramInt)
  {
    AppMethodBeat.i(239928);
    this.name = paramString;
    this.zWi = paramInt;
    AppMethodBeat.o(239928);
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(239931);
    if (this != paramObject)
    {
      if ((paramObject instanceof c))
      {
        paramObject = (c)paramObject;
        if ((!p.j(this.name, paramObject.name)) || (this.zWi != paramObject.zWi)) {}
      }
    }
    else
    {
      AppMethodBeat.o(239931);
      return true;
    }
    AppMethodBeat.o(239931);
    return false;
  }
  
  public final int hashCode()
  {
    AppMethodBeat.i(239930);
    String str = this.name;
    if (str != null) {}
    for (int i = str.hashCode();; i = 0)
    {
      int j = this.zWi;
      AppMethodBeat.o(239930);
      return i * 31 + j;
    }
  }
  
  public final String toString()
  {
    AppMethodBeat.i(239929);
    String str = "MoreItem(name=" + this.name + ", func=" + this.zWi + ")";
    AppMethodBeat.o(239929);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.multitalk.ui.widget.projector.e.c
 * JD-Core Version:    0.7.0.1
 */