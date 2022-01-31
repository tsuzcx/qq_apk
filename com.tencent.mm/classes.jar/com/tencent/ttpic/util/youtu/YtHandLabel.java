package com.tencent.ttpic.util.youtu;

import com.tencent.matrix.trace.core.AppMethodBeat;

public class YtHandLabel
{
  private static final int LOST_TIME_INTERVAL = 300;
  private static final String TAG;
  public long lostStartTimestamp;
  public String name = "";
  public int value = -1;
  
  static
  {
    AppMethodBeat.i(84417);
    TAG = YtHandLabel.class.getSimpleName();
    AppMethodBeat.o(84417);
  }
  
  public boolean isConsiderLost()
  {
    AppMethodBeat.i(84416);
    if (System.currentTimeMillis() - this.lostStartTimestamp > 300L)
    {
      AppMethodBeat.o(84416);
      return true;
    }
    AppMethodBeat.o(84416);
    return false;
  }
  
  public void reset()
  {
    this.value = -1;
    this.name = "";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.ttpic.util.youtu.YtHandLabel
 * JD-Core Version:    0.7.0.1
 */