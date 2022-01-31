package com.tencent.ttpic.util;

import android.util.Pair;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Comparator;

final class VideoTemplateParser$5
  implements Comparator<Pair<Float, Double>>
{
  public final int compare(Pair<Float, Double> paramPair1, Pair<Float, Double> paramPair2)
  {
    AppMethodBeat.i(84235);
    int i = ((Float)paramPair1.first).compareTo((Float)paramPair2.first);
    AppMethodBeat.o(84235);
    return i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.ttpic.util.VideoTemplateParser.5
 * JD-Core Version:    0.7.0.1
 */