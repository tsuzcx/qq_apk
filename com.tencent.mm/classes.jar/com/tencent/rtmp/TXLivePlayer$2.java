package com.tencent.rtmp;

import com.tencent.liteav.basic.log.TXCLog;
import com.tencent.liteav.basic.structs.TXSVideoFrame;
import com.tencent.liteav.n;
import com.tencent.matrix.trace.core.AppMethodBeat;

class TXLivePlayer$2
  implements n
{
  TXLivePlayer$2(TXLivePlayer paramTXLivePlayer) {}
  
  public void onRenderVideoFrame(String paramString, int paramInt, TXSVideoFrame paramTXSVideoFrame)
  {
    AppMethodBeat.i(146985);
    if ((paramTXSVideoFrame == null) || (paramTXSVideoFrame.width <= 0) || (paramTXSVideoFrame.height <= 0))
    {
      AppMethodBeat.o(146985);
      return;
    }
    paramString = TXLivePlayer.access$200(this.this$0);
    TXLivePlayer.access$202(this.this$0, null);
    TXLivePlayer.ITXVideoRawDataListener localITXVideoRawDataListener = TXLivePlayer.access$300(this.this$0);
    if ((localITXVideoRawDataListener != null) && (paramString != null))
    {
      if (paramString.length >= paramTXSVideoFrame.width * paramTXSVideoFrame.height * 3 / 2)
      {
        paramTXSVideoFrame.loadI420Array(paramString);
        localITXVideoRawDataListener.onVideoRawDataAvailable(paramString, paramTXSVideoFrame.width, paramTXSVideoFrame.height, (int)paramTXSVideoFrame.pts);
        paramTXSVideoFrame.release();
        AppMethodBeat.o(146985);
        return;
      }
      TXCLog.e("TXLivePlayer", "raw data buffer length is too large");
    }
    AppMethodBeat.o(146985);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.rtmp.TXLivePlayer.2
 * JD-Core Version:    0.7.0.1
 */