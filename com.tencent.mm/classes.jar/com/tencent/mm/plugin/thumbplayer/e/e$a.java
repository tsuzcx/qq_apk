package com.tencent.mm.plugin.thumbplayer.e;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import kotlin.a.ak;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/thumbplayer/model/TPMediaSEInfo$Companion;", "", "()V", "FinderMVTrackFeature_Photo", "", "FinderMVTrackFeature_SlowVideo", "FinderMVTrackFeature_Video", "isSupportFeature", "", "featureList", "", "plugin-thumbplayer_release"})
public final class e$a
{
  public static boolean ix(List<Integer> paramList)
  {
    AppMethodBeat.i(192907);
    p.k(paramList, "featureList");
    Set localSet = ak.setOf(new Integer[] { Integer.valueOf(0), Integer.valueOf(1), Integer.valueOf(2) });
    paramList = ((Iterable)paramList).iterator();
    while (paramList.hasNext()) {
      if (!localSet.contains(Integer.valueOf(((Number)paramList.next()).intValue())))
      {
        AppMethodBeat.o(192907);
        return false;
      }
    }
    AppMethodBeat.o(192907);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.thumbplayer.e.e.a
 * JD-Core Version:    0.7.0.1
 */