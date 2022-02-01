package com.tencent.trtc;

import com.tencent.matrix.trace.core.AppMethodBeat;

public class TRTCCloudDef$TRTCLocalRecordingParams
{
  public String filePath = "";
  public int interval = -1;
  public int recordType = 2;
  
  public String toString()
  {
    AppMethodBeat.i(211284);
    String str = "filePath=" + this.filePath + ", recordType=" + this.recordType + ", interval=" + this.interval;
    AppMethodBeat.o(211284);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.trtc.TRTCCloudDef.TRTCLocalRecordingParams
 * JD-Core Version:    0.7.0.1
 */