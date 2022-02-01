package com.tencent.tmassistantsdk.openSDK;

import android.content.Context;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.tmassistantsdk.protocol.ProtocolPackage;
import com.tencent.tmassistantsdk.util.Base64;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class OpenSDKTool4Assistant
{
  public static final int ACTION_TYPE_APP_DETAIL = 2;
  public static final int ACTION_TYPE_AUTHORIZED = 3;
  public static final int ACTION_TYPE_DOWNLOAD_TASKLIST = 1;
  public static final int ACTION_TYPE_RELATE = 4;
  public static final int ACTION_TYPE_WEBVIEW = 5;
  public static final int BATCH_REQUEST_TYPE_GET_STATE = 3;
  public static final int BATCH_REQUEST_TYPE_PAUSE_ALL = 6;
  public static final int BATCH_REQUEST_TYPE_PAUSE_SPECIFIED_APPS = 8;
  public static final int BATCH_REQUEST_TYPE_RESUME_ALL = 5;
  public static final int BATCH_REQUEST_TYPE_RESUME_SPECIFIED_APPS = 7;
  public static final int BATCH_REQUEST_TYPE_SHOW_ALL = 2;
  public static final int BATCH_REQUEST_TYPE_START_ALL = 1;
  public static final int BATCH_REQUEST_TYPE_START_SPECIFIED_APPS = 4;
  protected static final String CRYPT_KEY = "ji*9^&43U0X-~./(";
  public static final String DOWNLOADSTATECHANGED_RECEIVERPERMISSION = "com.tencent.qqdownloader.stateChangedReceiverPermission";
  public static final String EXTRA_ERROR_CODE = "errorCode";
  public static final String EXTRA_ERROR_MSG = "errorMsg";
  public static final String EXTRA_HOST_PAGECKAGENAME = "hostPackageName";
  public static final String EXTRA_HOST_VERSION = "hostVersion";
  public static final String EXTRA_SNGAPPID = "sngAppId";
  public static final String EXTRA_STATE = "state";
  public static final String EXTRA_TASK_APKID = "taskApkId";
  public static final String EXTRA_TASK_APPID = "taskAppId";
  public static final String EXTRA_TASK_ID = "taskId";
  public static final String EXTRA_TASK_PACKAGENAME = "taskPackageName";
  public static final String EXTRA_TASK_VERSION = "taskVersion";
  public static final String EXTRA_UIN = "uin";
  public static final String EXTRA_UINTYPE = "uinType";
  public static final String EXTRA_VIA = "via";
  public static final String OPENSDK_ACTION_NAME = "com.tencent.assistantOpenSDK.downloadStateChange.action";
  public static final String STATE_CHANGED_PARAM = "stateChangedParam";
  
  public static String decryptUri(String paramString)
  {
    AppMethodBeat.i(102095);
    paramString = new String(ProtocolPackage.decrypt(Base64.decode(paramString, 0), "ji*9^&43U0X-~./(".getBytes()));
    AppMethodBeat.o(102095);
    return paramString;
  }
  
  public static String encryptUri(String paramString)
  {
    AppMethodBeat.i(102094);
    paramString = Base64.encodeToString(ProtocolPackage.encrypt(paramString.getBytes(), "ji*9^&43U0X-~./(".getBytes()), 0);
    AppMethodBeat.o(102094);
    return paramString;
  }
  
  public static void sendDownloadStateChanged(Context paramContext, Map<String, String> paramMap)
  {
    AppMethodBeat.i(102093);
    Intent localIntent = new Intent("com.tencent.assistantOpenSDK.downloadStateChange.action");
    paramMap = paramMap.entrySet().iterator();
    while (paramMap.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)paramMap.next();
      localIntent.putExtra((String)localEntry.getKey(), (String)localEntry.getValue());
    }
    paramContext.sendBroadcast(localIntent);
    AppMethodBeat.o(102093);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.tmassistantsdk.openSDK.OpenSDKTool4Assistant
 * JD-Core Version:    0.7.0.1
 */