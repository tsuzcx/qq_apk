package com.tencent.mm.plugin.mv.ui.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.mv.model.b.e;
import com.tencent.mm.sdk.statecenter.BaseStateAction;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/mv/ui/state/album/SelectAction;", "Lcom/tencent/mm/sdk/statecenter/BaseStateAction;", "source", "Lcom/tencent/mm/plugin/mv/ui/state/album/SelectAction$SelectActionSource;", "item", "Lcom/tencent/mm/plugin/mv/model/preview/MvPreviewLiveItem;", "(Lcom/tencent/mm/plugin/mv/ui/state/album/SelectAction$SelectActionSource;Lcom/tencent/mm/plugin/mv/model/preview/MvPreviewLiveItem;)V", "getItem", "()Lcom/tencent/mm/plugin/mv/model/preview/MvPreviewLiveItem;", "getSource", "()Lcom/tencent/mm/plugin/mv/ui/state/album/SelectAction$SelectActionSource;", "component1", "component2", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "SelectActionSource", "plugin-mv_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class c
  extends BaseStateAction
{
  public final a McY;
  public final e McZ;
  
  public c(a parama, e parame)
  {
    AppMethodBeat.i(286468);
    this.McY = parama;
    this.McZ = parame;
    AppMethodBeat.o(286468);
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(286491);
    if (this == paramObject)
    {
      AppMethodBeat.o(286491);
      return true;
    }
    if (!(paramObject instanceof c))
    {
      AppMethodBeat.o(286491);
      return false;
    }
    paramObject = (c)paramObject;
    if (this.McY != paramObject.McY)
    {
      AppMethodBeat.o(286491);
      return false;
    }
    if (!s.p(this.McZ, paramObject.McZ))
    {
      AppMethodBeat.o(286491);
      return false;
    }
    AppMethodBeat.o(286491);
    return true;
  }
  
  public final int hashCode()
  {
    AppMethodBeat.i(286483);
    int i = this.McY.hashCode();
    int j = this.McZ.hashCode();
    AppMethodBeat.o(286483);
    return i * 31 + j;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(286475);
    String str = "SelectAction(source=" + this.McY + ", item=" + this.McZ + ')';
    AppMethodBeat.o(286475);
    return str;
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/mv/ui/state/album/SelectAction$SelectActionSource;", "", "(Ljava/lang/String;I)V", "Gallery", "Select", "CheckBox", "plugin-mv_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static enum a
  {
    static
    {
      AppMethodBeat.i(286488);
      Mda = new a("Gallery", 0);
      Mdb = new a("Select", 1);
      Mdc = new a("CheckBox", 2);
      Mdd = new a[] { Mda, Mdb, Mdc };
      AppMethodBeat.o(286488);
    }
    
    private a() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.mv.ui.b.a.c
 * JD-Core Version:    0.7.0.1
 */