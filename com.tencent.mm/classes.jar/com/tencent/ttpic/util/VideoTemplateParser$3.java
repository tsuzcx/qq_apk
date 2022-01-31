package com.tencent.ttpic.util;

import android.util.Pair;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Comparator;

final class VideoTemplateParser$3
  implements Comparator<Pair<Float, Integer>>
{
  public final int compare(Pair<Float, Integer> paramPair1, Pair<Float, Integer> paramPair2)
  {
    AppMethodBeat.i(84231);
    int i = ((Float)paramPair1.first).compareTo((Float)paramPair2.first);
    AppMethodBeat.o(84231);
    return i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.ttpic.util.VideoTemplateParser.3
 * JD-Core Version:    0.7.0.1
 */