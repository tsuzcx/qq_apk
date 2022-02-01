package com.tencent.youtu.ytagreflectlivecheck.requester;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.youtu.ytcommon.tools.YTLogger;
import com.tencent.youtu.ytcommon.tools.wejson.WeJson;

public class LiveStyleResponse
{
  private static String TAG = "LiveStyleResponse";
  public String action_data;
  public String color_data;
  public String data;
  public int errorcode;
  public String errormsg;
  public String originResponse;
  public LiveStyleResponse responseParsed;
  public int type;
  
  public void parseResponse(String paramString)
  {
    AppMethodBeat.i(43404);
    try
    {
      this.responseParsed = ((LiveStyleResponse)new WeJson().fromJson(paramString, LiveStyleResponse.class));
      this.originResponse = paramString;
      AppMethodBeat.o(43404);
      return;
    }
    catch (Exception localException)
    {
      this.responseParsed = null;
      this.originResponse = null;
      YTLogger.w(TAG, "[LiveStyleResponse.onGetLiveStyle] parse response failed. error: " + localException + " response: " + paramString);
      AppMethodBeat.o(43404);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.youtu.ytagreflectlivecheck.requester.LiveStyleResponse
 * JD-Core Version:    0.7.0.1
 */