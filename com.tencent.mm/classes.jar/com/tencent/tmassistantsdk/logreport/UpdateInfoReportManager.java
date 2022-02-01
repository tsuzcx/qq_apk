package com.tencent.tmassistantsdk.logreport;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.tmassistantsdk.protocol.jce.UpdateInfoLog;
import com.tencent.tmassistantsdk.storage.table.BaseLogTable;
import com.tencent.tmassistantsdk.storage.table.UpdateInfoLogTable;
import com.tencent.tmassistantsdk.util.TMLog;

public class UpdateInfoReportManager
  extends BaseReportManager
{
  protected static final String TAG = "UpdateInfoReportManager";
  protected static UpdateInfoReportManager mInstance = null;
  
  public static UpdateInfoReportManager getInstance()
  {
    try
    {
      AppMethodBeat.i(102072);
      if (mInstance == null) {
        mInstance = new UpdateInfoReportManager();
      }
      UpdateInfoReportManager localUpdateInfoReportManager = mInstance;
      AppMethodBeat.o(102072);
      return localUpdateInfoReportManager;
    }
    finally {}
  }
  
  public UpdateInfoLog createUpdateInfoLog(String paramString, long paramLong)
  {
    AppMethodBeat.i(102073);
    TMLog.i("UpdateInfoReportManager", "createUpdateInfoLog");
    UpdateInfoLog localUpdateInfoLog = new UpdateInfoLog();
    localUpdateInfoLog.packageName = paramString;
    localUpdateInfoLog.appid = paramLong;
    AppMethodBeat.o(102073);
    return localUpdateInfoLog;
  }
  
  protected BaseLogTable getLogTable()
  {
    AppMethodBeat.i(102074);
    UpdateInfoLogTable localUpdateInfoLogTable = UpdateInfoLogTable.getInstance();
    AppMethodBeat.o(102074);
    return localUpdateInfoLogTable;
  }
  
  protected byte getReportType()
  {
    return 2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.tmassistantsdk.logreport.UpdateInfoReportManager
 * JD-Core Version:    0.7.0.1
 */