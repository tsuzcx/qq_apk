package com.tencent.thumbplayer.core.downloadproxy.service;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.thumbplayer.core.downloadproxy.aidl.ITPPlayListenerAidl;
import com.tencent.thumbplayer.core.downloadproxy.api.ITPPlayListener;
import com.tencent.thumbplayer.core.downloadproxy.utils.TPDLProxyLog;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

class TPDownloadProxyService$DownloadProxy$1
  implements ITPPlayListener
{
  TPDownloadProxyService$DownloadProxy$1(TPDownloadProxyService.DownloadProxy paramDownloadProxy, ITPPlayListenerAidl paramITPPlayListenerAidl) {}
  
  public long getAdvRemainTime()
  {
    AppMethodBeat.i(191551);
    try
    {
      if (this.val$playListener != null)
      {
        long l = this.val$playListener.getAdvRemainTime();
        AppMethodBeat.o(191551);
        return l;
      }
    }
    catch (Throwable localThrowable)
    {
      TPDLProxyLog.e("TPDownloadProxyService", 0, "tpdlnative", "getAdvRemainTime failed, error:" + localThrowable.toString());
      AppMethodBeat.o(191551);
    }
    return -1L;
  }
  
  public String getContentType(long paramLong, String paramString)
  {
    AppMethodBeat.i(191558);
    try
    {
      if (this.val$playListener != null)
      {
        paramString = this.val$playListener.getContentType(paramLong, paramString);
        AppMethodBeat.o(191558);
        return paramString;
      }
    }
    catch (Throwable paramString)
    {
      TPDLProxyLog.e("TPDownloadProxyService", 0, "tpdlnative", "getContentType key failed, error:" + paramString.toString());
      AppMethodBeat.o(191558);
    }
    return "";
  }
  
  public int getCurrentPlayClipNo()
  {
    AppMethodBeat.i(191550);
    try
    {
      if (this.val$playListener != null)
      {
        int i = this.val$playListener.getCurrentPlayClipNo();
        AppMethodBeat.o(191550);
        return i;
      }
    }
    catch (Throwable localThrowable)
    {
      TPDLProxyLog.e("TPDownloadProxyService", 0, "tpdlnative", "getCurrentPlayClipInfo failed, error:" + localThrowable.toString());
      AppMethodBeat.o(191550);
    }
    return -1;
  }
  
  public long getCurrentPosition()
  {
    AppMethodBeat.i(191549);
    try
    {
      if (this.val$playListener != null)
      {
        long l = this.val$playListener.getCurrentPosition();
        AppMethodBeat.o(191549);
        return l;
      }
    }
    catch (Throwable localThrowable)
    {
      TPDLProxyLog.e("TPDownloadProxyService", 0, "tpdlnative", "getCurrentPosition failed, error:" + localThrowable.toString());
      AppMethodBeat.o(191549);
    }
    return -1L;
  }
  
  public String getDataFilePath(long paramLong, String paramString)
  {
    AppMethodBeat.i(191559);
    try
    {
      if (this.val$playListener != null)
      {
        paramString = this.val$playListener.getDataFilePath(paramLong, paramString);
        AppMethodBeat.o(191559);
        return paramString;
      }
    }
    catch (Throwable paramString)
    {
      TPDLProxyLog.e("TPDownloadProxyService", 0, "tpdlnative", "getDataFilePath key failed, error:" + paramString.toString());
      AppMethodBeat.o(191559);
    }
    return "";
  }
  
  public long getDataTotalSize(long paramLong, String paramString)
  {
    AppMethodBeat.i(191557);
    try
    {
      if (this.val$playListener != null)
      {
        paramLong = this.val$playListener.getDataTotalSize(paramLong, paramString);
        AppMethodBeat.o(191557);
        return paramLong;
      }
    }
    catch (Throwable paramString)
    {
      TPDLProxyLog.e("TPDownloadProxyService", 0, "tpdlnative", "getDataTotalSize key failed, error:" + paramString.toString());
      AppMethodBeat.o(191557);
    }
    return -1L;
  }
  
  public Object getPlayInfo(long paramLong)
  {
    AppMethodBeat.i(191552);
    try
    {
      String str = this.val$playListener.getPlayInfo(Long.toString(paramLong));
      AppMethodBeat.o(191552);
      return str;
    }
    catch (Throwable localThrowable)
    {
      TPDLProxyLog.e("TPDownloadProxyService", 0, "tpdlnative", "getPlayInfo type failed, error:" + localThrowable.toString());
      AppMethodBeat.o(191552);
    }
    return null;
  }
  
  public Object getPlayInfo(String paramString)
  {
    AppMethodBeat.i(191553);
    try
    {
      paramString = this.val$playListener.getPlayInfo(paramString);
      AppMethodBeat.o(191553);
      return paramString;
    }
    catch (Throwable paramString)
    {
      TPDLProxyLog.e("TPDownloadProxyService", 0, "tpdlnative", "getPlayInfo key failed, error:" + paramString.toString());
      AppMethodBeat.o(191553);
    }
    return null;
  }
  
  public long getPlayerBufferLength()
  {
    AppMethodBeat.i(191548);
    try
    {
      if (this.val$playListener != null)
      {
        long l = this.val$playListener.getPlayerBufferLength();
        AppMethodBeat.o(191548);
        return l;
      }
    }
    catch (Throwable localThrowable)
    {
      TPDLProxyLog.e("TPDownloadProxyService", 0, "tpdlnative", "getPlayerBufferLength failed, error:" + localThrowable.toString());
      AppMethodBeat.o(191548);
    }
    return -1L;
  }
  
  public void onDownloadCdnUrlExpired(Map<String, String> paramMap)
  {
    AppMethodBeat.i(191545);
    try
    {
      if (this.val$playListener != null) {
        this.val$playListener.onDownloadCdnUrlExpired(paramMap);
      }
      AppMethodBeat.o(191545);
      return;
    }
    catch (Throwable paramMap)
    {
      TPDLProxyLog.e("TPDownloadProxyService", 0, "tpdlnative", "onDownloadCdnUrlExpired failed, error:" + paramMap.toString());
      AppMethodBeat.o(191545);
    }
  }
  
  public void onDownloadCdnUrlInfoUpdate(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    AppMethodBeat.i(191544);
    try
    {
      if (this.val$playListener != null) {
        this.val$playListener.onDownloadCdnUrlInfoUpdate(paramString1, paramString2, paramString3, paramString4);
      }
      AppMethodBeat.o(191544);
      return;
    }
    catch (Throwable paramString1)
    {
      TPDLProxyLog.e("TPDownloadProxyService", 0, "tpdlnative", "onDownloadCdnUrlInfoUpdate failed, error:" + paramString1.toString());
      AppMethodBeat.o(191544);
    }
  }
  
  public void onDownloadCdnUrlUpdate(String paramString)
  {
    AppMethodBeat.i(191543);
    try
    {
      if (this.val$playListener != null) {
        this.val$playListener.onDownloadCdnUrlUpdate(paramString);
      }
      AppMethodBeat.o(191543);
      return;
    }
    catch (Throwable paramString)
    {
      TPDLProxyLog.e("TPDownloadProxyService", 0, "tpdlnative", "onDownloadCdnUrlUpdate failed, error:" + paramString.toString());
      AppMethodBeat.o(191543);
    }
  }
  
  public void onDownloadError(int paramInt1, int paramInt2, String paramString)
  {
    AppMethodBeat.i(191541);
    try
    {
      if (this.val$playListener != null) {
        this.val$playListener.onDownloadError(paramInt1, paramInt2, paramString);
      }
      AppMethodBeat.o(191541);
      return;
    }
    catch (Throwable paramString)
    {
      TPDLProxyLog.e("TPDownloadProxyService", 0, "tpdlnative", "onDownloadError failed, error:" + paramString.toString());
      AppMethodBeat.o(191541);
    }
  }
  
  public void onDownloadFinish()
  {
    AppMethodBeat.i(191540);
    try
    {
      if (this.val$playListener != null) {
        this.val$playListener.onDownloadFinish();
      }
      AppMethodBeat.o(191540);
      return;
    }
    catch (Throwable localThrowable)
    {
      TPDLProxyLog.e("TPDownloadProxyService", 0, "tpdlnative", "onDownlaodFinish failed, error:" + localThrowable.toString());
      AppMethodBeat.o(191540);
    }
  }
  
  public void onDownloadProgressUpdate(int paramInt1, int paramInt2, long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(191539);
    try
    {
      if (this.val$playListener != null) {
        this.val$playListener.onDownloadProgressUpdate(paramInt1, paramInt2, paramLong1, paramLong2);
      }
      AppMethodBeat.o(191539);
      return;
    }
    catch (Throwable localThrowable)
    {
      TPDLProxyLog.e("TPDownloadProxyService", 0, "tpdlnative", "onDownlaodProgressUpdate failed, error:" + localThrowable.toString());
      AppMethodBeat.o(191539);
    }
  }
  
  public void onDownloadProtocolUpdate(String paramString1, String paramString2)
  {
    AppMethodBeat.i(191547);
    try
    {
      if (this.val$playListener != null) {
        this.val$playListener.onDownloadProtocolUpdate(paramString1, paramString2);
      }
      AppMethodBeat.o(191547);
      return;
    }
    catch (Throwable paramString1)
    {
      TPDLProxyLog.e("TPDownloadProxyService", 0, "tpdlnative", "onDownloadProtocolUpdate failed, error:" + paramString1.toString());
      AppMethodBeat.o(191547);
    }
  }
  
  public void onDownloadStatusUpdate(int paramInt)
  {
    AppMethodBeat.i(191546);
    try
    {
      if (this.val$playListener != null) {
        this.val$playListener.onDownloadStatusUpdate(paramInt);
      }
      AppMethodBeat.o(191546);
      return;
    }
    catch (Throwable localThrowable)
    {
      TPDLProxyLog.e("TPDownloadProxyService", 0, "tpdlnative", "onDownloadStatusUpdate failed, error:" + localThrowable.toString());
      AppMethodBeat.o(191546);
    }
  }
  
  public Object onPlayCallback(int paramInt, Object paramObject1, Object paramObject2, Object paramObject3, Object paramObject4)
  {
    AppMethodBeat.i(191542);
    try
    {
      paramObject4 = new ArrayList();
      if (paramObject1 != null) {
        paramObject4.add(paramObject1);
      }
      if (paramObject2 != null) {
        paramObject4.add(paramObject2);
      }
      if (paramObject3 != null) {
        paramObject4.add(paramObject3);
      }
      if (this.val$playListener != null) {
        this.val$playListener.onPlayCallback(paramInt, paramObject4);
      }
    }
    catch (Throwable paramObject1)
    {
      for (;;)
      {
        TPDLProxyLog.e("TPDownloadProxyService", 0, "tpdlnative", "onPlayCallback failed, error:" + paramObject1.toString());
      }
    }
    AppMethodBeat.o(191542);
    return null;
  }
  
  public int onReadData(long paramLong1, String paramString, long paramLong2, long paramLong3)
  {
    AppMethodBeat.i(191555);
    try
    {
      if (this.val$playListener != null)
      {
        int i = this.val$playListener.onReadData(paramLong1, paramString, paramLong2, paramLong3);
        AppMethodBeat.o(191555);
        return i;
      }
    }
    catch (Throwable paramString)
    {
      TPDLProxyLog.e("TPDownloadProxyService", 0, "tpdlnative", "onReadData key failed, error:" + paramString.toString());
      AppMethodBeat.o(191555);
    }
    return -1;
  }
  
  public int onStartReadData(long paramLong1, String paramString, long paramLong2, long paramLong3)
  {
    AppMethodBeat.i(191554);
    try
    {
      if (this.val$playListener != null)
      {
        int i = this.val$playListener.onStartReadData(paramLong1, paramString, paramLong2, paramLong3);
        AppMethodBeat.o(191554);
        return i;
      }
    }
    catch (Throwable paramString)
    {
      TPDLProxyLog.e("TPDownloadProxyService", 0, "tpdlnative", "onStartReadData key failed, error:" + paramString.toString());
      AppMethodBeat.o(191554);
    }
    return -1;
  }
  
  public int onStopReadData(long paramLong, String paramString)
  {
    AppMethodBeat.i(191556);
    try
    {
      if (this.val$playListener != null)
      {
        int i = this.val$playListener.onStopReadData(paramLong, paramString);
        AppMethodBeat.o(191556);
        return i;
      }
    }
    catch (Throwable paramString)
    {
      TPDLProxyLog.e("TPDownloadProxyService", 0, "tpdlnative", "onStopReadData key failed, error:" + paramString.toString());
      AppMethodBeat.o(191556);
    }
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.thumbplayer.core.downloadproxy.service.TPDownloadProxyService.DownloadProxy.1
 * JD-Core Version:    0.7.0.1
 */