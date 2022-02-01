package com.tencent.thumbplayer.e;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.thumbplayer.api.proxy.ITPPreloadProxy.IPreloadListener;
import com.tencent.thumbplayer.core.downloadproxy.api.ITPPlayListener;
import com.tencent.thumbplayer.utils.g;
import java.util.Map;

public final class d
  implements ITPPreloadProxy.IPreloadListener, ITPPlayListener
{
  private String tag;
  
  public d(String paramString)
  {
    this.tag = paramString;
  }
  
  public final long getAdvRemainTime()
  {
    AppMethodBeat.i(227026);
    g.i(this.tag, " empty proxy player listener , notify , getAdvRemainTime");
    AppMethodBeat.o(227026);
    return 0L;
  }
  
  public final String getContentType(int paramInt, String paramString)
  {
    return null;
  }
  
  public final int getCurrentPlayClipNo()
  {
    AppMethodBeat.i(227020);
    g.i(this.tag, " empty proxy player listener , notify , getCurrentPlayClipNo");
    AppMethodBeat.o(227020);
    return 0;
  }
  
  public final long getCurrentPosition()
  {
    AppMethodBeat.i(227014);
    g.i(this.tag, " empty proxy player listener , notify , getCurrentPosition");
    AppMethodBeat.o(227014);
    return 0L;
  }
  
  public final String getDataFilePath(int paramInt, String paramString)
  {
    return null;
  }
  
  public final long getDataTotalSize(int paramInt, String paramString)
  {
    return 0L;
  }
  
  public final Object getPlayInfo(long paramLong)
  {
    AppMethodBeat.i(227030);
    g.i(this.tag, " empty proxy player listener , notify , getPlayInfo with type : ".concat(String.valueOf(paramLong)));
    AppMethodBeat.o(227030);
    return null;
  }
  
  public final Object getPlayInfo(String paramString)
  {
    AppMethodBeat.i(227035);
    g.i(this.tag, " empty proxy player listener , notify , getPlayInfo with key : ".concat(String.valueOf(paramString)));
    AppMethodBeat.o(227035);
    return null;
  }
  
  public final long getPlayerBufferLength()
  {
    AppMethodBeat.i(227010);
    g.i(this.tag, " empty proxy player listener , notify , getPlayerBufferLength");
    AppMethodBeat.o(227010);
    return 0L;
  }
  
  public final void onDownloadCdnUrlExpired(Map<String, String> paramMap) {}
  
  public final void onDownloadCdnUrlInfoUpdate(String paramString1, String paramString2, String paramString3, String paramString4) {}
  
  public final void onDownloadCdnUrlUpdate(String paramString) {}
  
  public final void onDownloadError(int paramInt1, int paramInt2, String paramString) {}
  
  public final void onDownloadFinish() {}
  
  public final void onDownloadProgressUpdate(int paramInt1, int paramInt2, long paramLong1, long paramLong2, String paramString)
  {
    AppMethodBeat.i(226982);
    g.i(this.tag, " empty proxy player listener , notify , onPlayProgress, current : " + paramLong1 + ", total : " + paramLong2);
    AppMethodBeat.o(226982);
  }
  
  public final void onDownloadProtocolUpdate(String paramString1, String paramString2) {}
  
  public final void onDownloadStatusUpdate(int paramInt) {}
  
  public final Object onPlayCallback(int paramInt, Object paramObject1, Object paramObject2, Object paramObject3, Object paramObject4)
  {
    AppMethodBeat.i(227005);
    g.i(this.tag, " empty proxy player listener , notify , onPlayCallback, messageType : " + paramInt + ",ext1:" + paramObject1 + ",ext2:" + paramObject2 + ",ext3" + paramObject3 + ",ext4" + paramObject4);
    AppMethodBeat.o(227005);
    return null;
  }
  
  public final void onPrepareDownloadProgressUpdate(int paramInt1, int paramInt2, long paramLong1, long paramLong2) {}
  
  public final void onPrepareError()
  {
    AppMethodBeat.i(227082);
    g.i(this.tag, " empty proxy player listener , notify , onPrepareError : ");
    AppMethodBeat.o(227082);
  }
  
  public final void onPrepareSuccess()
  {
    AppMethodBeat.i(227072);
    g.i(this.tag, " empty proxy player listener , notify , onPrepareSuccess : ");
    AppMethodBeat.o(227072);
  }
  
  public final int onReadData(int paramInt, String paramString, long paramLong1, long paramLong2)
  {
    return 0;
  }
  
  public final int onStartReadData(int paramInt, String paramString, long paramLong1, long paramLong2)
  {
    return 0;
  }
  
  public final int onStopReadData(int paramInt1, String paramString, int paramInt2)
  {
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.thumbplayer.e.d
 * JD-Core Version:    0.7.0.1
 */