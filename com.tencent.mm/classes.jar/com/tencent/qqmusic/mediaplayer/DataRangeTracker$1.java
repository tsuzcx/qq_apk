package com.tencent.qqmusic.mediaplayer;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Comparator;

class DataRangeTracker$1
  implements Comparator<DataRangeTracker.Range>
{
  DataRangeTracker$1(DataRangeTracker paramDataRangeTracker) {}
  
  public int compare(DataRangeTracker.Range paramRange1, DataRangeTracker.Range paramRange2)
  {
    AppMethodBeat.i(104779);
    int i = (int)(DataRangeTracker.Range.access$200(paramRange1) - DataRangeTracker.Range.access$200(paramRange2));
    AppMethodBeat.o(104779);
    return i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.qqmusic.mediaplayer.DataRangeTracker.1
 * JD-Core Version:    0.7.0.1
 */