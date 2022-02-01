package com.tencent.mm.plugin.mv.ui.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.mv.a.e;
import com.tencent.mm.view.recyclerview.a;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/mv/ui/convert/MvConvertData;", "Lcom/tencent/mm/view/recyclerview/ConvertData;", "mv", "Lcom/tencent/mm/plugin/mv/model/MusicMv;", "(Lcom/tencent/mm/plugin/mv/model/MusicMv;)V", "getMv", "()Lcom/tencent/mm/plugin/mv/model/MusicMv;", "setMv", "getItemId", "", "getItemType", "", "hasMv", "", "plugin-mv_release"})
public final class b
  implements a
{
  public e ArY;
  
  public b(e parame)
  {
    AppMethodBeat.i(257002);
    this.ArY = parame;
    AppMethodBeat.o(257002);
  }
  
  public final int cxn()
  {
    return 0;
  }
  
  public final long lT()
  {
    AppMethodBeat.i(257001);
    Long localLong2 = this.ArY.ApB;
    Long localLong1 = localLong2;
    if (localLong2 == null) {
      localLong1 = this.ArY.ApE;
    }
    if (localLong1 != null)
    {
      long l = localLong1.longValue();
      AppMethodBeat.o(257001);
      return l;
    }
    AppMethodBeat.o(257001);
    return 0L;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.mv.ui.a.b
 * JD-Core Version:    0.7.0.1
 */