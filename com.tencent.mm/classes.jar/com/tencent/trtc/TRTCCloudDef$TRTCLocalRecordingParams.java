package com.tencent.trtc;

import com.tencent.matrix.trace.core.AppMethodBeat;

public class TRTCCloudDef$TRTCLocalRecordingParams
{
  public String filePath = "";
  public int interval = -1;
  public int recordType = 2;
  
  public String toString()
  {
    AppMethodBeat.i(216115);
    String str = "filePath=" + this.filePath + ", recordType=" + this.recordType + ", interval=" + this.interval;
    AppMethodBeat.o(216115);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.trtc.TRTCCloudDef.TRTCLocalRecordingParams
 * JD-Core Version:    0.7.0.1
 */