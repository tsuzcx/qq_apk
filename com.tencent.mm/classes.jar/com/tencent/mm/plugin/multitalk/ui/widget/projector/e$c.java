package com.tencent.mm.plugin.multitalk.ui.widget.projector;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/multitalk/ui/widget/projector/ScreenConfig$MoreItem;", "", "name", "", "func", "", "(Ljava/lang/String;I)V", "getFunc", "()I", "setFunc", "(I)V", "getName", "()Ljava/lang/String;", "setName", "(Ljava/lang/String;)V", "component1", "component2", "copy", "equals", "", "other", "hashCode", "toString", "plugin-multitalk_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class e$c
{
  int LxR;
  String name;
  
  public e$c(String paramString)
  {
    AppMethodBeat.i(285962);
    this.name = paramString;
    this.LxR = 8;
    AppMethodBeat.o(285962);
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(285978);
    if (this == paramObject)
    {
      AppMethodBeat.o(285978);
      return true;
    }
    if (!(paramObject instanceof c))
    {
      AppMethodBeat.o(285978);
      return false;
    }
    paramObject = (c)paramObject;
    if (!s.p(this.name, paramObject.name))
    {
      AppMethodBeat.o(285978);
      return false;
    }
    if (this.LxR != paramObject.LxR)
    {
      AppMethodBeat.o(285978);
      return false;
    }
    AppMethodBeat.o(285978);
    return true;
  }
  
  public final int hashCode()
  {
    AppMethodBeat.i(285972);
    int i = this.name.hashCode();
    int j = this.LxR;
    AppMethodBeat.o(285972);
    return i * 31 + j;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(285966);
    String str = "MoreItem(name=" + this.name + ", func=" + this.LxR + ')';
    AppMethodBeat.o(285966);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.multitalk.ui.widget.projector.e.c
 * JD-Core Version:    0.7.0.1
 */