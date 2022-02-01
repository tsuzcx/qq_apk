package com.tencent.thumbplayer.f;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.thumbplayer.core.downloadproxy.api.ITPPlayListener;
import java.util.Map;

public final class d
  implements ITPPlayListener
{
  private String tag;
  
  public d(String paramString)
  {
    this.tag = paramString;
  }
  
  public final long getAdvRemainTime()
  {
    AppMethodBeat.i(194629);
    com.tencent.thumbplayer.utils.d.i(this.tag, " empty proxy player listener , notify , getAdvRemainTime");
    AppMethodBeat.o(194629);
    return 0L;
  }
  
  public final String getContentType(long paramLong, String paramString)
  {
    return null;
  }
  
  public final int getCurrentPlayClipNo()
  {
    AppMethodBeat.i(194628);
    com.tencent.thumbplayer.utils.d.i(this.tag, " empty proxy player listener , notify , getCurrentPlayClipNo");
    AppMethodBeat.o(194628);
    return 0;
  }
  
  public final long getCurrentPosition()
  {
    AppMethodBeat.i(194627);
    com.tencent.thumbplayer.utils.d.i(this.tag, " empty proxy player listener , notify , getCurrentPosition");
    AppMethodBeat.o(194627);
    return 0L;
  }
  
  public final String getDataFilePath(long paramLong, String paramString)
  {
    return null;
  }
  
  public final long getDataTotalSize(long paramLong, String paramString)
  {
    return 0L;
  }
  
  public final Object getPlayInfo(long paramLong)
  {
    AppMethodBeat.i(194630);
    com.tencent.thumbplayer.utils.d.i(this.tag, " empty proxy player listener , notify , getPlayInfo with type : ".concat(String.valueOf(paramLong)));
    AppMethodBeat.o(194630);
    return null;
  }
  
  public final Object getPlayInfo(String paramString)
  {
    AppMethodBeat.i(194631);
    com.tencent.thumbplayer.utils.d.i(this.tag, " empty proxy player listener , notify , getPlayInfo with key : ".concat(String.valueOf(paramString)));
    AppMethodBeat.o(194631);
    return null;
  }
  
  public final long getPlayerBufferLength()
  {
    AppMethodBeat.i(194626);
    com.tencent.thumbplayer.utils.d.i(this.tag, " empty proxy player listener , notify , getPlayerBufferLength");
    AppMethodBeat.o(194626);
    return 0L;
  }
  
  public final void onDownloadCdnUrlExpired(Map<String, String> paramMap) {}
  
  public final void onDownloadCdnUrlInfoUpdate(String paramString1, String paramString2, String paramString3, String paramString4) {}
  
  public final void onDownloadCdnUrlUpdate(String paramString) {}
  
  public final void onDownloadError(int paramInt1, int paramInt2, String paramString) {}
  
  public final void onDownloadFinish() {}
  
  public final void onDownloadProgressUpdate(int paramInt1, int paramInt2, long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(194624);
    com.tencent.thumbplayer.utils.d.i(this.tag, " empty proxy player listener , notify , onPlayProgress, current : " + paramLong1 + ", total : " + paramLong2);
    AppMethodBeat.o(194624);
  }
  
  public final void onDownloadProtocolUpdate(String paramString1, String paramString2) {}
  
  public final void onDownloadStatusUpdate(int paramInt) {}
  
  public final Object onPlayCallback(int paramInt, Object paramObject1, Object paramObject2, Object paramObject3, Object paramObject4)
  {
    AppMethodBeat.i(194625);
    com.tencent.thumbplayer.utils.d.i(this.tag, " empty proxy player listener , notify , onPlayCallback, messageType : " + paramInt + ",ext1:" + paramObject1 + ",ext2:" + paramObject2 + ",ext3" + paramObject3 + ",ext4" + paramObject4);
    AppMethodBeat.o(194625);
    return null;
  }
  
  public final int onReadData(long paramLong1, String paramString, long paramLong2, long paramLong3)
  {
    return 0;
  }
  
  public final int onStartReadData(long paramLong1, String paramString, long paramLong2, long paramLong3)
  {
    return 0;
  }
  
  public final int onStopReadData(long paramLong, String paramString)
  {
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.thumbplayer.f.d
 * JD-Core Version:    0.7.0.1
 */