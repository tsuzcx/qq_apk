package com.tencent.mm.plugin.mv.ui.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.mv.model.f;
import com.tencent.mm.view.recyclerview.a;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/mv/ui/convert/MvConvertData;", "Lcom/tencent/mm/view/recyclerview/ConvertData;", "mv", "Lcom/tencent/mm/plugin/mv/model/MusicMv;", "(Lcom/tencent/mm/plugin/mv/model/MusicMv;)V", "getMv", "()Lcom/tencent/mm/plugin/mv/model/MusicMv;", "setMv", "getItemId", "", "getItemType", "", "hasMv", "", "plugin-mv_release"})
public final class b
  implements a
{
  public f GfI;
  
  public b(f paramf)
  {
    AppMethodBeat.i(225992);
    this.GfI = paramf;
    AppMethodBeat.o(225992);
  }
  
  public final int bAQ()
  {
    return 0;
  }
  
  public final long mf()
  {
    AppMethodBeat.i(225988);
    Long localLong2 = this.GfI.Gbi;
    Long localLong1 = localLong2;
    if (localLong2 == null) {
      localLong1 = this.GfI.Gbl;
    }
    if (localLong1 != null)
    {
      long l = localLong1.longValue();
      AppMethodBeat.o(225988);
      return l;
    }
    AppMethodBeat.o(225988);
    return 0L;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.mv.ui.a.b
 * JD-Core Version:    0.7.0.1
 */