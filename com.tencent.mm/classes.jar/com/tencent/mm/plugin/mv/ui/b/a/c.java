package com.tencent.mm.plugin.mv.ui.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.livebase.redux.a;
import com.tencent.mm.plugin.mv.model.b.e;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/mv/ui/redux/album/SelectAction;", "Lcom/tencent/mm/plugin/livebase/redux/IReduxAction;", "source", "Lcom/tencent/mm/plugin/mv/ui/redux/album/SelectAction$SelectActionSource;", "item", "Lcom/tencent/mm/plugin/mv/model/preview/MvPreviewLiveItem;", "(Lcom/tencent/mm/plugin/mv/ui/redux/album/SelectAction$SelectActionSource;Lcom/tencent/mm/plugin/mv/model/preview/MvPreviewLiveItem;)V", "getItem", "()Lcom/tencent/mm/plugin/mv/model/preview/MvPreviewLiveItem;", "getSource", "()Lcom/tencent/mm/plugin/mv/ui/redux/album/SelectAction$SelectActionSource;", "component1", "component2", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "SelectActionSource", "plugin-mv_release"})
public final class c
  implements a
{
  public final a Ghl;
  public final e Ghm;
  
  public c(a parama, e parame)
  {
    AppMethodBeat.i(228097);
    this.Ghl = parama;
    this.Ghm = parame;
    AppMethodBeat.o(228097);
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(228104);
    if (this != paramObject)
    {
      if ((paramObject instanceof c))
      {
        paramObject = (c)paramObject;
        if ((!p.h(this.Ghl, paramObject.Ghl)) || (!p.h(this.Ghm, paramObject.Ghm))) {}
      }
    }
    else
    {
      AppMethodBeat.o(228104);
      return true;
    }
    AppMethodBeat.o(228104);
    return false;
  }
  
  public final int hashCode()
  {
    int j = 0;
    AppMethodBeat.i(228102);
    Object localObject = this.Ghl;
    if (localObject != null) {}
    for (int i = localObject.hashCode();; i = 0)
    {
      localObject = this.Ghm;
      if (localObject != null) {
        j = localObject.hashCode();
      }
      AppMethodBeat.o(228102);
      return i * 31 + j;
    }
  }
  
  public final String toString()
  {
    AppMethodBeat.i(228100);
    String str = "SelectAction(source=" + this.Ghl + ", item=" + this.Ghm + ")";
    AppMethodBeat.o(228100);
    return str;
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/mv/ui/redux/album/SelectAction$SelectActionSource;", "", "(Ljava/lang/String;I)V", "Gallery", "Select", "CheckBox", "plugin-mv_release"})
  public static enum a
  {
    static
    {
      AppMethodBeat.i(225391);
      a locala1 = new a("Gallery", 0);
      Ghn = locala1;
      a locala2 = new a("Select", 1);
      Gho = locala2;
      a locala3 = new a("CheckBox", 2);
      Ghp = locala3;
      Ghq = new a[] { locala1, locala2, locala3 };
      AppMethodBeat.o(225391);
    }
    
    private a() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.mv.ui.b.a.c
 * JD-Core Version:    0.7.0.1
 */