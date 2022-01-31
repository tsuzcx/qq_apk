package com.tencent.mm.plugin.sight.base;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.bo;

public final class a
{
  public int eRw = 0;
  public int eVA = 0;
  public int fzT = 0;
  public int height = 0;
  public int qSh = 0;
  public int qSi = 0;
  public int qSj = 0;
  public int qSk = 0;
  public int qSl = 0;
  public int qSm = 0;
  public int videoBitrate = 0;
  public int width = 0;
  
  public final int cmu()
  {
    AppMethodBeat.i(117301);
    int i = bo.nX(this.eVA);
    AppMethodBeat.o(117301);
    return i;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(117302);
    String str = "[ videoDuration: " + this.eVA + " videoBitrate: " + this.videoBitrate + " width: " + this.width + " height: " + this.height + " frameRate: " + this.eRw + " audioChannel: " + this.qSh + " audioBitrate: " + this.fzT + " useABA: " + this.qSi + " useMinMaxQP: " + this.qSj + " bitrateAdaptiveUp: " + this.qSk + " bitrateAdaptiveDown: " + this.qSl + " resolutionAdjust: " + this.qSm + "]";
    AppMethodBeat.o(117302);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.sight.base.a
 * JD-Core Version:    0.7.0.1
 */