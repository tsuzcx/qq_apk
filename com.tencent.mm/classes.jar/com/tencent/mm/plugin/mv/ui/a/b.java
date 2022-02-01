package com.tencent.mm.plugin.mv.ui.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.mv.model.f;
import com.tencent.mm.view.recyclerview.a;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/mv/ui/convert/MvConvertData;", "Lcom/tencent/mm/view/recyclerview/ConvertData;", "mv", "Lcom/tencent/mm/plugin/mv/model/MusicMv;", "(Lcom/tencent/mm/plugin/mv/model/MusicMv;)V", "getMv", "()Lcom/tencent/mm/plugin/mv/model/MusicMv;", "setMv", "getItemId", "", "getItemType", "", "hasMv", "", "plugin-mv_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class b
  implements a
{
  public f MaX;
  
  public b(f paramf)
  {
    AppMethodBeat.i(288167);
    this.MaX = paramf;
    AppMethodBeat.o(288167);
  }
  
  public final long bZA()
  {
    AppMethodBeat.i(288171);
    Long localLong = this.MaX.LXg;
    if (localLong == null)
    {
      localLong = this.MaX.LXj;
      if (localLong == null)
      {
        AppMethodBeat.o(288171);
        return 0L;
      }
      l = localLong.longValue();
      AppMethodBeat.o(288171);
      return l;
    }
    long l = localLong.longValue();
    AppMethodBeat.o(288171);
    return l;
  }
  
  public final int bZB()
  {
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.mv.ui.a.b
 * JD-Core Version:    0.7.0.1
 */