package com.tencent.mm.plugin.webview.luggage;

import android.os.Bundle;
import android.os.Parcelable;
import com.tencent.mm.ipcinvoker.wx_extension.service.ToolsProcessIPCService;
import com.tencent.mm.plugin.downloader.model.c;
import com.tencent.mm.plugin.downloader.model.k;
import com.tencent.mm.sdk.platformtools.y;
import org.json.JSONException;
import org.json.JSONObject;

public final class b
  implements k
{
  public final void b(long paramLong, int paramInt, boolean paramBoolean)
  {
    Object localObject = c.dk(paramLong);
    if (localObject != null) {}
    for (localObject = ((com.tencent.mm.plugin.downloader.f.a)localObject).field_appId;; localObject = "")
    {
      JSONObject localJSONObject = new JSONObject();
      try
      {
        localJSONObject.put("appid", localObject);
        localJSONObject.put("download_id", paramLong);
        localJSONObject.put("state", "download_fail");
        localObject = new Bundle();
        ((Bundle)localObject).putString("name", "wxdownload:state_change");
        ((Bundle)localObject).putString("data", localJSONObject.toString());
        ToolsProcessIPCService.a((Parcelable)localObject, com.tencent.mm.plugin.webview.luggage.a.a.class);
        return;
      }
      catch (JSONException localJSONException) {}
    }
  }
  
  public final void b(long paramLong, String paramString, boolean paramBoolean)
  {
    paramString = c.dk(paramLong);
    if (paramString != null) {}
    for (paramString = paramString.field_appId;; paramString = "")
    {
      JSONObject localJSONObject = new JSONObject();
      try
      {
        localJSONObject.put("appid", paramString);
        localJSONObject.put("download_id", paramLong);
        localJSONObject.put("state", "download_succ");
        paramString = new Bundle();
        paramString.putString("name", "wxdownload:state_change");
        paramString.putString("data", localJSONObject.toString());
        ToolsProcessIPCService.a(paramString, com.tencent.mm.plugin.webview.luggage.a.a.class);
        return;
      }
      catch (JSONException paramString) {}
    }
  }
  
  public final void cy(long paramLong)
  {
    Object localObject = c.dk(paramLong);
    if ((localObject == null) || (((com.tencent.mm.plugin.downloader.f.a)localObject).field_totalSize == 0L))
    {
      y.w("MicroMsg.LuggageDownloadCallback", "loadDownloadProgress failed, downloadId = " + paramLong);
      return;
    }
    int i = (int)(((com.tencent.mm.plugin.downloader.f.a)localObject).field_downloadedSize / ((com.tencent.mm.plugin.downloader.f.a)localObject).field_totalSize * 100.0D);
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("appid", ((com.tencent.mm.plugin.downloader.f.a)localObject).field_appId);
      localJSONObject.put("download_id", paramLong);
      localJSONObject.put("progress", i);
      localObject = new Bundle();
      ((Bundle)localObject).putString("name", "wxdownload:progress_change");
      ((Bundle)localObject).putString("data", localJSONObject.toString());
      ToolsProcessIPCService.a((Parcelable)localObject, com.tencent.mm.plugin.webview.luggage.a.a.class);
      return;
    }
    catch (JSONException localJSONException) {}
  }
  
  public final void cz(long paramLong) {}
  
  public final void k(long paramLong, String paramString)
  {
    paramString = c.dk(paramLong);
    if (paramString != null) {}
    for (paramString = paramString.field_appId;; paramString = "")
    {
      JSONObject localJSONObject = new JSONObject();
      try
      {
        localJSONObject.put("appid", paramString);
        localJSONObject.put("download_id", paramLong);
        localJSONObject.put("state", "download_resumed");
        paramString = new Bundle();
        paramString.putString("name", "wxdownload:state_change");
        paramString.putString("data", localJSONObject.toString());
        ToolsProcessIPCService.a(paramString, com.tencent.mm.plugin.webview.luggage.a.a.class);
        return;
      }
      catch (JSONException paramString) {}
    }
  }
  
  public final void onTaskPaused(long paramLong)
  {
    Object localObject = c.dk(paramLong);
    if (localObject != null) {}
    for (localObject = ((com.tencent.mm.plugin.downloader.f.a)localObject).field_appId;; localObject = "")
    {
      JSONObject localJSONObject = new JSONObject();
      try
      {
        localJSONObject.put("appid", localObject);
        localJSONObject.put("download_id", paramLong);
        localJSONObject.put("state", "download_pause");
        localObject = new Bundle();
        ((Bundle)localObject).putString("name", "wxdownload:state_change");
        ((Bundle)localObject).putString("data", localJSONObject.toString());
        ToolsProcessIPCService.a((Parcelable)localObject, com.tencent.mm.plugin.webview.luggage.a.a.class);
        return;
      }
      catch (JSONException localJSONException) {}
    }
  }
  
  public final void onTaskRemoved(long paramLong)
  {
    Object localObject = c.dk(paramLong);
    if (localObject != null) {}
    for (localObject = ((com.tencent.mm.plugin.downloader.f.a)localObject).field_appId;; localObject = "")
    {
      JSONObject localJSONObject = new JSONObject();
      try
      {
        localJSONObject.put("appid", localObject);
        localJSONObject.put("download_id", paramLong);
        localJSONObject.put("state", "download_removed");
        localObject = new Bundle();
        ((Bundle)localObject).putString("name", "wxdownload:state_change");
        ((Bundle)localObject).putString("data", localJSONObject.toString());
        ToolsProcessIPCService.a((Parcelable)localObject, com.tencent.mm.plugin.webview.luggage.a.a.class);
        return;
      }
      catch (JSONException localJSONException) {}
    }
  }
  
  public final void onTaskStarted(long paramLong, String paramString)
  {
    paramString = c.dk(paramLong);
    if (paramString != null) {}
    for (paramString = paramString.field_appId;; paramString = "")
    {
      JSONObject localJSONObject = new JSONObject();
      try
      {
        localJSONObject.put("appid", paramString);
        localJSONObject.put("download_id", paramLong);
        localJSONObject.put("state", "download_start");
        paramString = new Bundle();
        paramString.putString("name", "wxdownload:state_change");
        paramString.putString("data", localJSONObject.toString());
        ToolsProcessIPCService.a(paramString, com.tencent.mm.plugin.webview.luggage.a.a.class);
        return;
      }
      catch (JSONException paramString) {}
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.luggage.b
 * JD-Core Version:    0.7.0.1
 */