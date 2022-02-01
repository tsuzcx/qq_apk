package com.tencent.tav.coremedia;

import com.tencent.matrix.trace.core.AppMethodBeat;

public class CMTimeMapping
{
  private CMTimeRange source;
  private CMTimeRange target;
  
  public CMTimeMapping(CMTimeRange paramCMTimeRange1, CMTimeRange paramCMTimeRange2)
  {
    AppMethodBeat.i(219440);
    this.source = paramCMTimeRange1.clone();
    this.target = paramCMTimeRange2.clone();
    AppMethodBeat.o(219440);
  }
  
  public CMTimeRange getSource()
  {
    return this.source;
  }
  
  public CMTimeRange getTarget()
  {
    return this.target;
  }
  
  public void setSource(CMTimeRange paramCMTimeRange)
  {
    AppMethodBeat.i(219441);
    this.source = paramCMTimeRange.clone();
    AppMethodBeat.o(219441);
  }
  
  public void setTarget(CMTimeRange paramCMTimeRange)
  {
    AppMethodBeat.i(219442);
    this.target = paramCMTimeRange.clone();
    AppMethodBeat.o(219442);
  }
  
  public String toString()
  {
    AppMethodBeat.i(219443);
    String str = "CMTimeMapping{source=" + this.source.toSimpleString() + ", target=" + this.target.toSimpleString() + '}';
    AppMethodBeat.o(219443);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.tav.coremedia.CMTimeMapping
 * JD-Core Version:    0.7.0.1
 */