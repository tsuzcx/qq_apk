package com.tencent.tmassistantsdk.logreport;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.bt;
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
      AppMethodBeat.i(102069);
      if (mInstance == null) {
        mInstance = new TipsInfoReportManager();
      }
      TipsInfoReportManager localTipsInfoReportManager = mInstance;
      AppMethodBeat.o(102069);
      return localTipsInfoReportManager;
    }
    finally {}
  }
  
  public TipsInfoLog createTipsInfoLog(TMOpenSDKAuthorizedInfo paramTMOpenSDKAuthorizedInfo)
  {
    AppMethodBeat.i(102070);
    TMLog.i("TipsInfoReportManager", "createTipsInfoLog");
    if (paramTMOpenSDKAuthorizedInfo == null)
    {
      AppMethodBeat.o(102070);
      return null;
    }
    TipsInfoLog localTipsInfoLog = new TipsInfoLog();
    localTipsInfoLog.userId = paramTMOpenSDKAuthorizedInfo.userId;
    localTipsInfoLog.userIdType = paramTMOpenSDKAuthorizedInfo.userIdType;
    localTipsInfoLog.gamePackageName = paramTMOpenSDKAuthorizedInfo.gamePackageName;
    localTipsInfoLog.gameVersionCode = bt.getInt(paramTMOpenSDKAuthorizedInfo.gameVersionCode, 0);
    localTipsInfoLog.gameChannelId = paramTMOpenSDKAuthorizedInfo.gameChannelId;
    AppMethodBeat.o(102070);
    return localTipsInfoLog;
  }
  
  protected BaseLogTable getLogTable()
  {
    AppMethodBeat.i(102071);
    TipsInfoLogTable localTipsInfoLogTable = TipsInfoLogTable.getInstance();
    AppMethodBeat.o(102071);
    return localTipsInfoLogTable;
  }
  
  protected byte getReportType()
  {
    return 1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.tmassistantsdk.logreport.TipsInfoReportManager
 * JD-Core Version:    0.7.0.1
 */