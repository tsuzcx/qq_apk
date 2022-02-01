package com.tencent.youtu.ytagreflectlivecheck.requester;

import com.tencent.matrix.trace.core.AppMethodBeat;

public class LiveStyleRequester$YTLiveStyleReq
{
  public String app_id;
  public LiveStyleRequester.SeleceData select_data;
  
  public LiveStyleRequester$YTLiveStyleReq(float paramFloat, String paramString)
  {
    AppMethodBeat.i(43403);
    this.select_data = new LiveStyleRequester.SeleceData(paramFloat);
    this.app_id = paramString;
    AppMethodBeat.o(43403);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.youtu.ytagreflectlivecheck.requester.LiveStyleRequester.YTLiveStyleReq
 * JD-Core Version:    0.7.0.1
 */