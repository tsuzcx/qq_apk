package com.tencent.mm.plugin.multitalk.ui.widget.projector;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/multitalk/ui/widget/projector/ScreenConfig$MoreItem;", "", "name", "", "func", "", "(Ljava/lang/String;I)V", "getFunc", "()I", "setFunc", "(I)V", "getName", "()Ljava/lang/String;", "setName", "(Ljava/lang/String;)V", "component1", "component2", "copy", "equals", "", "other", "hashCode", "toString", "plugin-multitalk_release"})
public final class e$c
{
  int FBR;
  String name;
  
  public e$c(String paramString)
  {
    AppMethodBeat.i(196854);
    this.name = paramString;
    this.FBR = 8;
    AppMethodBeat.o(196854);
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(196858);
    if (this != paramObject)
    {
      if ((paramObject instanceof c))
      {
        paramObject = (c)paramObject;
        if ((!p.h(this.name, paramObject.name)) || (this.FBR != paramObject.FBR)) {}
      }
    }
    else
    {
      AppMethodBeat.o(196858);
      return true;
    }
    AppMethodBeat.o(196858);
    return false;
  }
  
  public final int hashCode()
  {
    AppMethodBeat.i(196857);
    String str = this.name;
    if (str != null) {}
    for (int i = str.hashCode();; i = 0)
    {
      int j = this.FBR;
      AppMethodBeat.o(196857);
      return i * 31 + j;
    }
  }
  
  public final String toString()
  {
    AppMethodBeat.i(196856);
    String str = "MoreItem(name=" + this.name + ", func=" + this.FBR + ")";
    AppMethodBeat.o(196856);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.multitalk.ui.widget.projector.e.c
 * JD-Core Version:    0.7.0.1
 */