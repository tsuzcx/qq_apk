package com.tencent.ttpic.util;

import android.util.Pair;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Comparator;

final class VideoTemplateParser$4
  implements Comparator<Pair<Float, ? extends Object>>
{
  public final int compare(Pair<Float, ? extends Object> paramPair1, Pair<Float, ? extends Object> paramPair2)
  {
    AppMethodBeat.i(84233);
    int i = ((Float)paramPair1.first).compareTo((Float)paramPair2.first);
    AppMethodBeat.o(84233);
    return i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.ttpic.util.VideoTemplateParser.4
 * JD-Core Version:    0.7.0.1
 */