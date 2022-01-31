package com.tencent.tmassistantsdk.logreport;

import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.tmassistantsdk.openSDK.opensdktomsdk.TMOpenSDKAuthorizedInfo;
import com.tencent.tmassistantsdk.protocol.jce.TipsInfoLog;
import com.tencent.tmassistantsdk.storage.table.BaseLogTable;
import com.tencent.tmassistantsdk.storage.table.TipsInfoLogTable;
import com.tencent.tmassistantsdk.util.TMLog;

public class TipsInfoReportManager
  extends BaseReportManager
{
  protected static final String TAG = "TipsInfoReportManager";
  protected static TipsInfoReportManager mInstance = null;
  
  public static TipsInfoReportManager getInstance()
  {
    try
    {
      if (mInstance == null) {
        mInstance = new TipsInfoReportManager();
      }
      TipsInfoReportManager localTipsInfoReportManager = mInstance;
      return localTipsInfoReportManager;
    }
    finally {}
  }
  
  public TipsInfoLog createTipsInfoLog(TMOpenSDKAuthorizedInfo paramTMOpenSDKAuthorizedInfo)
  {
    TMLog.i("TipsInfoReportManager", "createTipsInfoLog");
    if (paramTMOpenSDKAuthorizedInfo == null) {
      return null;
    }
    TipsInfoLog localTipsInfoLog = new TipsInfoLog();
    localTipsInfoLog.userId = paramTMOpenSDKAuthorizedInfo.userId;
    localTipsInfoLog.userIdType = paramTMOpenSDKAuthorizedInfo.userIdType;
    localTipsInfoLog.gamePackageName = paramTMOpenSDKAuthorizedInfo.gamePackageName;
    localTipsInfoLog.gameVersionCode = bk.getInt(paramTMOpenSDKAuthorizedInfo.gameVersionCode, 0);
    localTipsInfoLog.gameChannelId = paramTMOpenSDKAuthorizedInfo.gameChannelId;
    return localTipsInfoLog;
  }
  
  protected BaseLogTable getLogTable()
  {
    return TipsInfoLogTable.getInstance();
  }
  
  protected byte getReportType()
  {
    return 1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.tmassistantsdk.logreport.TipsInfoReportManager
 * JD-Core Version:    0.7.0.1
 */