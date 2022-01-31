package com.tencent.recovery.wx.service;

import android.content.Intent;
import android.os.Build;
import android.os.Build.VERSION;
import com.tencent.recovery.log.RecoveryLog;
import com.tencent.recovery.model.RecoveryHandleItem;
import com.tencent.recovery.report.RecoveryReporter;
import com.tencent.recovery.service.RecoveryUploadService;
import com.tencent.recovery.util.Util;
import com.tencent.recovery.wx.util.EncryptUtil;
import com.tencent.recovery.wx.util.PByteArray;
import com.tencent.recovery.wx.util.WXUtil;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

public class WXRecoveryUploadService
  extends RecoveryUploadService
{
  private static final String TAG = "Recovery.WXRecoveryUploadService";
  private static final String UNIT_REPORT_TAG = "RecoveryHandle";
  
  private static int compareVersion(String paramString1, String paramString2)
  {
    int i = 0;
    try
    {
      int j = Integer.decode(paramString1).intValue();
      int k = Integer.decode(paramString2).intValue();
      if (j > k) {
        i = 1;
      }
      while (k <= j) {
        return i;
      }
      return -1;
    }
    catch (Exception paramString1) {}
    return 0;
  }
  
  public static String convertStreamToString(InputStream paramInputStream)
  {
    if (paramInputStream == null) {
      return "";
    }
    BufferedReader localBufferedReader = new BufferedReader(new InputStreamReader(paramInputStream));
    StringBuilder localStringBuilder = new StringBuilder();
    try
    {
      for (;;)
      {
        String str = localBufferedReader.readLine();
        if (str == null) {
          break;
        }
        localStringBuilder.append(str + "\n");
      }
      try
      {
        paramInputStream.close();
        throw localObject;
      }
      catch (IOException paramInputStream)
      {
        for (;;)
        {
          RecoveryLog.printErrStackTrace("Recovery.WXRecoveryUploadService", paramInputStream, "", new Object[0]);
        }
      }
    }
    catch (IOException localIOException)
    {
      localIOException = localIOException;
      RecoveryLog.printErrStackTrace("Recovery.WXRecoveryUploadService", localIOException, "", new Object[0]);
      try
      {
        paramInputStream.close();
        for (;;)
        {
          return localStringBuilder.toString();
          try
          {
            paramInputStream.close();
          }
          catch (IOException paramInputStream)
          {
            RecoveryLog.printErrStackTrace("Recovery.WXRecoveryUploadService", paramInputStream, "", new Object[0]);
          }
        }
      }
      catch (IOException paramInputStream)
      {
        for (;;)
        {
          RecoveryLog.printErrStackTrace("Recovery.WXRecoveryUploadService", paramInputStream, "", new Object[0]);
        }
      }
    }
    finally {}
  }
  
  private boolean pushData(JSONArray paramJSONArray, String paramString)
  {
    try
    {
      Object localObject1 = WXUtil.hx(this);
      Object localObject2 = "android-" + Build.VERSION.SDK_INT;
      paramJSONArray = new JSONObject().put("head", new JSONObject().put("protocol_ver", 1).put("phone", Build.MANUFACTURER + "-" + Build.MODEL).put("os_ver", localObject2).put("report_time", System.currentTimeMillis())).put("items", paramJSONArray).toString().getBytes();
      int i = paramJSONArray.length;
      String str = EncryptUtil.o(String.format("weixin#$()%d%d", new Object[] { Integer.decode(paramString), Integer.valueOf(i) }).getBytes()).toLowerCase();
      byte[] arrayOfByte = EncryptUtil.l(paramJSONArray);
      paramJSONArray = new PByteArray();
      EncryptUtil.a(paramJSONArray, arrayOfByte, str.getBytes());
      localObject2 = new StringBuilder(256).append("http://support.weixin.qq.com/cgi-bin/mmsupport-bin/stackreport?version=").append(paramString).append("&devicetype=").append((String)localObject2).append("&filelength=").append(i).append("&sum=").append(str).append("&reporttype=1&NewReportType=110");
      if ((localObject1 != null) && (((String)localObject1).length() != 0)) {
        ((StringBuilder)localObject2).append("&username=").append((String)localObject1);
      }
      localObject1 = (HttpURLConnection)new URL(((StringBuilder)localObject2).toString()).openConnection();
      ((HttpURLConnection)localObject1).setRequestMethod("POST");
      ((HttpURLConnection)localObject1).setReadTimeout(20000);
      ((HttpURLConnection)localObject1).setConnectTimeout(10000);
      ((HttpURLConnection)localObject1).setRequestProperty("content-type", "binary/octet-stream");
      ((HttpURLConnection)localObject1).setDoOutput(true);
      ((HttpURLConnection)localObject1).setDoInput(true);
      ((HttpURLConnection)localObject1).connect();
      localObject2 = ((HttpURLConnection)localObject1).getOutputStream();
      ((OutputStream)localObject2).write(paramJSONArray.value);
      ((OutputStream)localObject2).flush();
      ((OutputStream)localObject2).close();
      if (((HttpURLConnection)localObject1).getResponseCode() != 200)
      {
        paramJSONArray = convertStreamToString(((HttpURLConnection)localObject1).getErrorStream());
        localObject2 = convertStreamToString(((HttpURLConnection)localObject1).getInputStream());
        RecoveryLog.i("Recovery.WXRecoveryUploadService", "POST returned: %d %s %s %s", new Object[] { Integer.valueOf(((HttpURLConnection)localObject1).getResponseCode()), paramString, paramJSONArray, localObject2 });
        return false;
      }
      RecoveryLog.i("Recovery.WXRecoveryUploadService", "POST returned success %s", new Object[] { paramString });
      return true;
    }
    catch (Exception paramJSONArray)
    {
      RecoveryLog.printErrStackTrace("Recovery.WXRecoveryUploadService", paramJSONArray, "pushData", new Object[0]);
    }
    return false;
  }
  
  protected boolean tryToUploadData()
  {
    Object localObject = new Intent();
    ((Intent)localObject).setPackage(getPackageName());
    ((Intent)localObject).setAction("com.tecent.mm.intent.action.RECOVERY_STATUS_UPLOAD");
    sendBroadcast((Intent)localObject);
    localObject = RecoveryReporter.a(this, "HandleStatus", RecoveryHandleItem.class);
    boolean bool = uploadData((List)localObject);
    if ((((List)localObject).size() == 0) || (bool)) {
      RecoveryReporter.bJ(this, "HandleStatus");
    }
    return bool;
  }
  
  protected boolean uploadData(List<RecoveryHandleItem> paramList)
  {
    int i = Util.hs(this);
    JSONArray localJSONArray = new JSONArray();
    Object localObject1 = "0x26070333";
    Iterator localIterator = paramList.iterator();
    Object localObject2;
    if (localIterator.hasNext()) {
      localObject2 = (RecoveryHandleItem)localIterator.next();
    }
    label220:
    for (;;)
    {
      try
      {
        localJSONArray.put(new JSONObject().put("tag", "RecoveryHandle").put("info", ((RecoveryHandleItem)localObject2).key).put("uin", ((RecoveryHandleItem)localObject2).dCX).put("deviceUUID", i).put("time", Util.ik(((RecoveryHandleItem)localObject2).timestamp)).put("cver", ((RecoveryHandleItem)localObject2).clientVersion).put("processName", ((RecoveryHandleItem)localObject2).processName).put("phoneStatus", ((RecoveryHandleItem)localObject2).wKW));
        if (compareVersion(((RecoveryHandleItem)localObject2).clientVersion, (String)localObject1) <= 0) {
          break label220;
        }
        localObject2 = ((RecoveryHandleItem)localObject2).clientVersion;
        localObject1 = localObject2;
      }
      catch (Exception localException) {}
      boolean bool = pushData(localJSONArray, (String)localObject1);
      RecoveryLog.i("Recovery.WXRecoveryUploadService", "upload result %b %d", new Object[] { Boolean.valueOf(bool), Integer.valueOf(paramList.size()) });
      return bool;
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.recovery.wx.service.WXRecoveryUploadService
 * JD-Core Version:    0.7.0.1
 */