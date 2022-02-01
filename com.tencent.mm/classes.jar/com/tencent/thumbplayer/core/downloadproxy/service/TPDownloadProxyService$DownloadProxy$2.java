package com.tencent.thumbplayer.core.downloadproxy.service;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.thumbplayer.core.downloadproxy.aidl.ITPPlayListenerAidl;
import com.tencent.thumbplayer.core.downloadproxy.api.ITPPlayListener;
import com.tencent.thumbplayer.core.downloadproxy.utils.TPDLProxyLog;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

class TPDownloadProxyService$DownloadProxy$2
  implements ITPPlayListener
{
  TPDownloadProxyService$DownloadProxy$2(TPDownloadProxyService.DownloadProxy paramDownloadProxy, ITPPlayListenerAidl paramITPPlayListenerAidl) {}
  
  public long getAdvRemainTime()
  {
    AppMethodBeat.i(210068);
    try
    {
      if (this.val$playListener != null)
      {
        long l = this.val$playListener.getAdvRemainTime();
        AppMethodBeat.o(210068);
        return l;
      }
    }
    catch (Throwable localThrowable)
    {
      TPDLProxyLog.e("TPDownloadProxyService", 0, "tpdlnative", "getAdvRemainTime failed, error:" + localThrowable.toString());
      AppMethodBeat.o(210068);
    }
    return -1L;
  }
  
  public String getContentType(int paramInt, String paramString)
  {
    AppMethodBeat.i(210076);
    try
    {
      if (this.val$playListener != null)
      {
        paramString = this.val$playListener.getContentType(paramInt, paramString);
        AppMethodBeat.o(210076);
        return paramString;
      }
    }
    catch (Throwable paramString)
    {
      TPDLProxyLog.e("TPDownloadProxyService", 0, "tpdlnative", "getContentType key failed, error:" + paramString.toString());
      AppMethodBeat.o(210076);
    }
    return "";
  }
  
  public int getCurrentPlayClipNo()
  {
    AppMethodBeat.i(210067);
    try
    {
      if (this.val$playListener != null)
      {
        int i = this.val$playListener.getCurrentPlayClipNo();
        AppMethodBeat.o(210067);
        return i;
      }
    }
    catch (Throwable localThrowable)
    {
      TPDLProxyLog.e("TPDownloadProxyService", 0, "tpdlnative", "getCurrentPlayClipNo failed, error:" + localThrowable.toString());
      AppMethodBeat.o(210067);
    }
    return -1;
  }
  
  public long getCurrentPosition()
  {
    AppMethodBeat.i(210066);
    try
    {
      if (this.val$playListener != null)
      {
        long l = this.val$playListener.getCurrentPosition();
        AppMethodBeat.o(210066);
        return l;
      }
    }
    catch (Throwable localThrowable)
    {
      TPDLProxyLog.e("TPDownloadProxyService", 0, "tpdlnative", "getCurrentPosition failed, error:" + localThrowable.toString());
      AppMethodBeat.o(210066);
    }
    return -1L;
  }
  
  public String getDataFilePath(int paramInt, String paramString)
  {
    AppMethodBeat.i(210075);
    try
    {
      if (this.val$playListener != null)
      {
        paramString = this.val$playListener.getDataFilePath(paramInt, paramString);
        AppMethodBeat.o(210075);
        return paramString;
      }
    }
    catch (Throwable paramString)
    {
      TPDLProxyLog.e("TPDownloadProxyService", 0, "tpdlnative", "getDataFilePath key failed, error:" + paramString.toString());
      AppMethodBeat.o(210075);
    }
    return "";
  }
  
  public long getDataTotalSize(int paramInt, String paramString)
  {
    AppMethodBeat.i(210074);
    try
    {
      if (this.val$playListener != null)
      {
        long l = this.val$playListener.getDataTotalSize(paramInt, paramString);
        AppMethodBeat.o(210074);
        return l;
      }
    }
    catch (Throwable paramString)
    {
      TPDLProxyLog.e("TPDownloadProxyService", 0, "tpdlnative", "getDataTotalSize key failed, error:" + paramString.toString());
      AppMethodBeat.o(210074);
    }
    return -1L;
  }
  
  public Object getPlayInfo(long paramLong)
  {
    AppMethodBeat.i(210069);
    try
    {
      if (this.val$playListener != null)
      {
        String str = this.val$playListener.getPlayInfo(Long.toString(paramLong));
        AppMethodBeat.o(210069);
        return str;
      }
    }
    catch (Throwable localThrowable)
    {
      TPDLProxyLog.e("TPDownloadProxyService", 0, "tpdlnative", "getPlayInfo type failed, error:" + localThrowable.toString());
      AppMethodBeat.o(210069);
    }
    return null;
  }
  
  public Object getPlayInfo(String paramString)
  {
    AppMethodBeat.i(210070);
    try
    {
      if (this.val$playListener != null)
      {
        paramString = this.val$playListener.getPlayInfo(paramString);
        AppMethodBeat.o(210070);
        return paramString;
      }
    }
    catch (Throwable paramString)
    {
      TPDLProxyLog.e("TPDownloadProxyService", 0, "tpdlnative", "getPlayInfo key failed, error:" + paramString.toString());
      AppMethodBeat.o(210070);
    }
    return null;
  }
  
  public long getPlayerBufferLength()
  {
    AppMethodBeat.i(210065);
    try
    {
      if (this.val$playListener != null)
      {
        long l = this.val$playListener.getPlayerBufferLength();
        AppMethodBeat.o(210065);
        return l;
      }
    }
    catch (Throwable localThrowable)
    {
      TPDLProxyLog.e("TPDownloadProxyService", 0, "tpdlnative", "getPlayerBufferLength failed, error:" + localThrowable.toString());
      AppMethodBeat.o(210065);
    }
    return -1L;
  }
  
  public void onDownloadCdnUrlExpired(Map<String, String> paramMap)
  {
    AppMethodBeat.i(210062);
    try
    {
      if (this.val$playListener != null) {
        this.val$playListener.onDownloadCdnUrlExpired(paramMap);
      }
      AppMethodBeat.o(210062);
      return;
    }
    catch (Throwable paramMap)
    {
      TPDLProxyLog.e("TPDownloadProxyService", 0, "tpdlnative", "onDownloadCdnUrlExpired failed, error:" + paramMap.toString());
      AppMethodBeat.o(210062);
    }
  }
  
  public void onDownloadCdnUrlInfoUpdate(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    AppMethodBeat.i(210061);
    try
    {
      if (this.val$playListener != null) {
        this.val$playListener.onDownloadCdnUrlInfoUpdate(paramString1, paramString2, paramString3, paramString4);
      }
      AppMethodBeat.o(210061);
      return;
    }
    catch (Throwable paramString1)
    {
      TPDLProxyLog.e("TPDownloadProxyService", 0, "tpdlnative", "onDownloadCdnUrlInfoUpdate failed, error:" + paramString1.toString());
      AppMethodBeat.o(210061);
    }
  }
  
  public void onDownloadCdnUrlUpdate(String paramString)
  {
    AppMethodBeat.i(210060);
    try
    {
      if (this.val$playListener != null) {
        this.val$playListener.onDownloadCdnUrlUpdate(paramString);
      }
      AppMethodBeat.o(210060);
      return;
    }
    catch (Throwable paramString)
    {
      TPDLProxyLog.e("TPDownloadProxyService", 0, "tpdlnative", "onDownloadCdnUrlUpdate failed, error:" + paramString.toString());
      AppMethodBeat.o(210060);
    }
  }
  
  public void onDownloadError(int paramInt1, int paramInt2, String paramString)
  {
    AppMethodBeat.i(210058);
    try
    {
      if (this.val$playListener != null) {
        this.val$playListener.onDownloadError(paramInt1, paramInt2, paramString);
      }
      AppMethodBeat.o(210058);
      return;
    }
    catch (Throwable paramString)
    {
      TPDLProxyLog.e("TPDownloadProxyService", 0, "tpdlnative", "onDownloadError failed, error:" + paramString.toString());
      AppMethodBeat.o(210058);
    }
  }
  
  public void onDownloadFinish()
  {
    AppMethodBeat.i(210057);
    try
    {
      if (this.val$playListener != null) {
        this.val$playListener.onDownloadFinish();
      }
      AppMethodBeat.o(210057);
      return;
    }
    catch (Throwable localThrowable)
    {
      TPDLProxyLog.e("TPDownloadProxyService", 0, "tpdlnative", "onDownloadFinish failed, error:" + localThrowable.toString());
      AppMethodBeat.o(210057);
    }
  }
  
  public void onDownloadProgressUpdate(int paramInt1, int paramInt2, long paramLong1, long paramLong2, String paramString)
  {
    AppMethodBeat.i(210056);
    try
    {
      if (this.val$playListener != null) {
        this.val$playListener.onDownloadProgressUpdate(paramInt1, paramInt2, paramLong1, paramLong2, paramString);
      }
      AppMethodBeat.o(210056);
      return;
    }
    catch (Throwable paramString)
    {
      TPDLProxyLog.e("TPDownloadProxyService", 0, "tpdlnative", "onDownloadProgressUpdate failed, error:" + paramString.toString());
      AppMethodBeat.o(210056);
    }
  }
  
  public void onDownloadProtocolUpdate(String paramString1, String paramString2)
  {
    AppMethodBeat.i(210064);
    try
    {
      if (this.val$playListener != null) {
        this.val$playListener.onDownloadProtocolUpdate(paramString1, paramString2);
      }
      AppMethodBeat.o(210064);
      return;
    }
    catch (Throwable paramString1)
    {
      TPDLProxyLog.e("TPDownloadProxyService", 0, "tpdlnative", "onDownloadProtocolUpdate failed, error:" + paramString1.toString());
      AppMethodBeat.o(210064);
    }
  }
  
  public void onDownloadStatusUpdate(int paramInt)
  {
    AppMethodBeat.i(210063);
    try
    {
      if (this.val$playListener != null) {
        this.val$playListener.onDownloadStatusUpdate(paramInt);
      }
      AppMethodBeat.o(210063);
      return;
    }
    catch (Throwable localThrowable)
    {
      TPDLProxyLog.e("TPDownloadProxyService", 0, "tpdlnative", "onDownloadStatusUpdate failed, error:" + localThrowable.toString());
      AppMethodBeat.o(210063);
    }
  }
  
  public Object onPlayCallback(int paramInt, Object paramObject1, Object paramObject2, Object paramObject3, Object paramObject4)
  {
    AppMethodBeat.i(210059);
    try
    {
      paramObject4 = new ArrayList();
      if (paramObject1 != null) {
        paramObject4.add(paramObject1);
      }
      if (paramObject1 != null) {
        paramObject4.add(paramObject2);
      }
      if (paramObject1 != null) {
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
    AppMethodBeat.o(210059);
    return null;
  }
  
  public int onReadData(int paramInt, String paramString, long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(210072);
    try
    {
      if (this.val$playListener != null)
      {
        paramInt = this.val$playListener.onReadData(paramInt, paramString, paramLong1, paramLong2);
        AppMethodBeat.o(210072);
        return paramInt;
      }
    }
    catch (Throwable paramString)
    {
      TPDLProxyLog.e("TPDownloadProxyService", 0, "tpdlnative", "onReadData key failed, error:" + paramString.toString());
      AppMethodBeat.o(210072);
    }
    return -1;
  }
  
  public int onStartReadData(int paramInt, String paramString, long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(210071);
    try
    {
      if (this.val$playListener != null)
      {
        paramInt = this.val$playListener.onStartReadData(paramInt, paramString, paramLong1, paramLong2);
        AppMethodBeat.o(210071);
        return paramInt;
      }
    }
    catch (Throwable paramString)
    {
      TPDLProxyLog.e("TPDownloadProxyService", 0, "tpdlnative", "onStartReadData key failed, error:" + paramString.toString());
      AppMethodBeat.o(210071);
    }
    return -1;
  }
  
  public int onStopReadData(int paramInt1, String paramString, int paramInt2)
  {
    AppMethodBeat.i(210073);
    try
    {
      if (this.val$playListener != null)
      {
        paramInt1 = this.val$playListener.onStopReadData(paramInt1, paramString, paramInt2);
        AppMethodBeat.o(210073);
        return paramInt1;
      }
    }
    catch (Throwable paramString)
    {
      TPDLProxyLog.e("TPDownloadProxyService", 0, "tpdlnative", "onStopReadData key failed, error:" + paramString.toString());
      AppMethodBeat.o(210073);
    }
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.thumbplayer.core.downloadproxy.service.TPDownloadProxyService.DownloadProxy.2
 * JD-Core Version:    0.7.0.1
 */