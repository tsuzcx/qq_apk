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
    AppMethodBeat.i(190212);
    try
    {
      if (this.val$playListener != null)
      {
        long l = this.val$playListener.getAdvRemainTime();
        AppMethodBeat.o(190212);
        return l;
      }
    }
    catch (Throwable localThrowable)
    {
      TPDLProxyLog.e("TPDownloadProxyService", 0, "tpdlnative", "getAdvRemainTime failed, error:" + localThrowable.toString());
      AppMethodBeat.o(190212);
    }
    return -1L;
  }
  
  public String getContentType(long paramLong, String paramString)
  {
    AppMethodBeat.i(190219);
    try
    {
      if (this.val$playListener != null)
      {
        paramString = this.val$playListener.getContentType(paramLong, paramString);
        AppMethodBeat.o(190219);
        return paramString;
      }
    }
    catch (Throwable paramString)
    {
      TPDLProxyLog.e("TPDownloadProxyService", 0, "tpdlnative", "getContentType key failed, error:" + paramString.toString());
      AppMethodBeat.o(190219);
    }
    return "";
  }
  
  public int getCurrentPlayClipNo()
  {
    AppMethodBeat.i(190211);
    try
    {
      if (this.val$playListener != null)
      {
        int i = this.val$playListener.getCurrentPlayClipNo();
        AppMethodBeat.o(190211);
        return i;
      }
    }
    catch (Throwable localThrowable)
    {
      TPDLProxyLog.e("TPDownloadProxyService", 0, "tpdlnative", "getCurrentPlayClipNo failed, error:" + localThrowable.toString());
      AppMethodBeat.o(190211);
    }
    return -1;
  }
  
  public long getCurrentPosition()
  {
    AppMethodBeat.i(190210);
    try
    {
      if (this.val$playListener != null)
      {
        long l = this.val$playListener.getCurrentPosition();
        AppMethodBeat.o(190210);
        return l;
      }
    }
    catch (Throwable localThrowable)
    {
      TPDLProxyLog.e("TPDownloadProxyService", 0, "tpdlnative", "getCurrentPosition failed, error:" + localThrowable.toString());
      AppMethodBeat.o(190210);
    }
    return -1L;
  }
  
  public String getDataFilePath(long paramLong, String paramString)
  {
    AppMethodBeat.i(190220);
    try
    {
      if (this.val$playListener != null)
      {
        paramString = this.val$playListener.getDataFilePath(paramLong, paramString);
        AppMethodBeat.o(190220);
        return paramString;
      }
    }
    catch (Throwable paramString)
    {
      TPDLProxyLog.e("TPDownloadProxyService", 0, "tpdlnative", "getDataFilePath key failed, error:" + paramString.toString());
      AppMethodBeat.o(190220);
    }
    return "";
  }
  
  public long getDataTotalSize(long paramLong, String paramString)
  {
    AppMethodBeat.i(190218);
    try
    {
      if (this.val$playListener != null)
      {
        paramLong = this.val$playListener.getDataTotalSize(paramLong, paramString);
        AppMethodBeat.o(190218);
        return paramLong;
      }
    }
    catch (Throwable paramString)
    {
      TPDLProxyLog.e("TPDownloadProxyService", 0, "tpdlnative", "getDataTotalSize key failed, error:" + paramString.toString());
      AppMethodBeat.o(190218);
    }
    return -1L;
  }
  
  public Object getPlayInfo(long paramLong)
  {
    AppMethodBeat.i(190213);
    try
    {
      if (this.val$playListener != null)
      {
        String str = this.val$playListener.getPlayInfo(Long.toString(paramLong));
        AppMethodBeat.o(190213);
        return str;
      }
    }
    catch (Throwable localThrowable)
    {
      TPDLProxyLog.e("TPDownloadProxyService", 0, "tpdlnative", "getPlayInfo type failed, error:" + localThrowable.toString());
      AppMethodBeat.o(190213);
    }
    return null;
  }
  
  public Object getPlayInfo(String paramString)
  {
    AppMethodBeat.i(190214);
    try
    {
      if (this.val$playListener != null)
      {
        paramString = this.val$playListener.getPlayInfo(paramString);
        AppMethodBeat.o(190214);
        return paramString;
      }
    }
    catch (Throwable paramString)
    {
      TPDLProxyLog.e("TPDownloadProxyService", 0, "tpdlnative", "getPlayInfo key failed, error:" + paramString.toString());
      AppMethodBeat.o(190214);
    }
    return null;
  }
  
  public long getPlayerBufferLength()
  {
    AppMethodBeat.i(190209);
    try
    {
      if (this.val$playListener != null)
      {
        long l = this.val$playListener.getPlayerBufferLength();
        AppMethodBeat.o(190209);
        return l;
      }
    }
    catch (Throwable localThrowable)
    {
      TPDLProxyLog.e("TPDownloadProxyService", 0, "tpdlnative", "getPlayerBufferLength failed, error:" + localThrowable.toString());
      AppMethodBeat.o(190209);
    }
    return -1L;
  }
  
  public void onDownloadCdnUrlExpired(Map<String, String> paramMap)
  {
    AppMethodBeat.i(190206);
    try
    {
      if (this.val$playListener != null) {
        this.val$playListener.onDownloadCdnUrlExpired(paramMap);
      }
      AppMethodBeat.o(190206);
      return;
    }
    catch (Throwable paramMap)
    {
      TPDLProxyLog.e("TPDownloadProxyService", 0, "tpdlnative", "onDownloadCdnUrlExpired failed, error:" + paramMap.toString());
      AppMethodBeat.o(190206);
    }
  }
  
  public void onDownloadCdnUrlInfoUpdate(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    AppMethodBeat.i(190205);
    try
    {
      if (this.val$playListener != null) {
        this.val$playListener.onDownloadCdnUrlInfoUpdate(paramString1, paramString2, paramString3, paramString4);
      }
      AppMethodBeat.o(190205);
      return;
    }
    catch (Throwable paramString1)
    {
      TPDLProxyLog.e("TPDownloadProxyService", 0, "tpdlnative", "onDownloadCdnUrlInfoUpdate failed, error:" + paramString1.toString());
      AppMethodBeat.o(190205);
    }
  }
  
  public void onDownloadCdnUrlUpdate(String paramString)
  {
    AppMethodBeat.i(190204);
    try
    {
      if (this.val$playListener != null) {
        this.val$playListener.onDownloadCdnUrlUpdate(paramString);
      }
      AppMethodBeat.o(190204);
      return;
    }
    catch (Throwable paramString)
    {
      TPDLProxyLog.e("TPDownloadProxyService", 0, "tpdlnative", "onDownloadCdnUrlUpdate failed, error:" + paramString.toString());
      AppMethodBeat.o(190204);
    }
  }
  
  public void onDownloadError(int paramInt1, int paramInt2, String paramString)
  {
    AppMethodBeat.i(190202);
    try
    {
      if (this.val$playListener != null) {
        this.val$playListener.onDownloadError(paramInt1, paramInt2, paramString);
      }
      AppMethodBeat.o(190202);
      return;
    }
    catch (Throwable paramString)
    {
      TPDLProxyLog.e("TPDownloadProxyService", 0, "tpdlnative", "onDownloadError failed, error:" + paramString.toString());
      AppMethodBeat.o(190202);
    }
  }
  
  public void onDownloadFinish()
  {
    AppMethodBeat.i(190201);
    try
    {
      if (this.val$playListener != null) {
        this.val$playListener.onDownloadFinish();
      }
      AppMethodBeat.o(190201);
      return;
    }
    catch (Throwable localThrowable)
    {
      TPDLProxyLog.e("TPDownloadProxyService", 0, "tpdlnative", "onDownloadFinish failed, error:" + localThrowable.toString());
      AppMethodBeat.o(190201);
    }
  }
  
  public void onDownloadProgressUpdate(int paramInt1, int paramInt2, long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(190200);
    try
    {
      if (this.val$playListener != null) {
        this.val$playListener.onDownloadProgressUpdate(paramInt1, paramInt2, paramLong1, paramLong2);
      }
      AppMethodBeat.o(190200);
      return;
    }
    catch (Throwable localThrowable)
    {
      TPDLProxyLog.e("TPDownloadProxyService", 0, "tpdlnative", "onDownloadProgressUpdate failed, error:" + localThrowable.toString());
      AppMethodBeat.o(190200);
    }
  }
  
  public void onDownloadProtocolUpdate(String paramString1, String paramString2)
  {
    AppMethodBeat.i(190208);
    try
    {
      if (this.val$playListener != null) {
        this.val$playListener.onDownloadProtocolUpdate(paramString1, paramString2);
      }
      AppMethodBeat.o(190208);
      return;
    }
    catch (Throwable paramString1)
    {
      TPDLProxyLog.e("TPDownloadProxyService", 0, "tpdlnative", "onDownloadProtocolUpdate failed, error:" + paramString1.toString());
      AppMethodBeat.o(190208);
    }
  }
  
  public void onDownloadStatusUpdate(int paramInt)
  {
    AppMethodBeat.i(190207);
    try
    {
      if (this.val$playListener != null) {
        this.val$playListener.onDownloadStatusUpdate(paramInt);
      }
      AppMethodBeat.o(190207);
      return;
    }
    catch (Throwable localThrowable)
    {
      TPDLProxyLog.e("TPDownloadProxyService", 0, "tpdlnative", "onDownloadStatusUpdate failed, error:" + localThrowable.toString());
      AppMethodBeat.o(190207);
    }
  }
  
  public Object onPlayCallback(int paramInt, Object paramObject1, Object paramObject2, Object paramObject3, Object paramObject4)
  {
    AppMethodBeat.i(190203);
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
    AppMethodBeat.o(190203);
    return null;
  }
  
  public int onReadData(long paramLong1, String paramString, long paramLong2, long paramLong3)
  {
    AppMethodBeat.i(190216);
    try
    {
      if (this.val$playListener != null)
      {
        int i = this.val$playListener.onReadData(paramLong1, paramString, paramLong2, paramLong3);
        AppMethodBeat.o(190216);
        return i;
      }
    }
    catch (Throwable paramString)
    {
      TPDLProxyLog.e("TPDownloadProxyService", 0, "tpdlnative", "onReadData key failed, error:" + paramString.toString());
      AppMethodBeat.o(190216);
    }
    return -1;
  }
  
  public int onStartReadData(long paramLong1, String paramString, long paramLong2, long paramLong3)
  {
    AppMethodBeat.i(190215);
    try
    {
      if (this.val$playListener != null)
      {
        int i = this.val$playListener.onStartReadData(paramLong1, paramString, paramLong2, paramLong3);
        AppMethodBeat.o(190215);
        return i;
      }
    }
    catch (Throwable paramString)
    {
      TPDLProxyLog.e("TPDownloadProxyService", 0, "tpdlnative", "onStartReadData key failed, error:" + paramString.toString());
      AppMethodBeat.o(190215);
    }
    return -1;
  }
  
  public int onStopReadData(long paramLong, String paramString)
  {
    AppMethodBeat.i(190217);
    try
    {
      if (this.val$playListener != null)
      {
        int i = this.val$playListener.onStopReadData(paramLong, paramString);
        AppMethodBeat.o(190217);
        return i;
      }
    }
    catch (Throwable paramString)
    {
      TPDLProxyLog.e("TPDownloadProxyService", 0, "tpdlnative", "onStopReadData key failed, error:" + paramString.toString());
      AppMethodBeat.o(190217);
    }
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.thumbplayer.core.downloadproxy.service.TPDownloadProxyService.DownloadProxy.2
 * JD-Core Version:    0.7.0.1
 */