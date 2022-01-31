package com.tencent.tmassistantsdk.logreport;

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
      if (mInstance == null) {
        mInstance = new UpdateInfoReportManager();
      }
      UpdateInfoReportManager localUpdateInfoReportManager = mInstance;
      return localUpdateInfoReportManager;
    }
    finally {}
  }
  
  public UpdateInfoLog createUpdateInfoLog(String paramString, long paramLong)
  {
    TMLog.i("UpdateInfoReportManager", "createUpdateInfoLog");
    UpdateInfoLog localUpdateInfoLog = new UpdateInfoLog();
    localUpdateInfoLog.packageName = paramString;
    localUpdateInfoLog.appid = paramLong;
    return localUpdateInfoLog;
  }
  
  protected BaseLogTable getLogTable()
  {
    return UpdateInfoLogTable.getInstance();
  }
  
  protected byte getReportType()
  {
    return 2;
  }
  
  public class UpdateLogConst
  {
    public static final int ACTION_CHECKYYB_INSTALLED = 100;
    public static final int ACTION_DOWNLOAD_SUCCESS = 102;
    public static final int ACTION_INSTALL_SUCCESS = 103;
    public static final int ACTION_POP_INSTALL_DIALOG = 104;
    public static final int ACTION_START_DOWNLOAD = 101;
    public static final byte UPDATE_TYPE_NORMAL = 1;
    public static final byte UPDATE_TYPE_SAVE_NETWORK_TRAFFIC = 2;
    public static final byte UPDATE_TYPE_UNKNOWN = 0;
    public static final int YYB_IGNORE = 0;
    public static final int YYB_INSTALLED = 1;
    public static final int YYB_NOT_INSTALL = 2;
    
    public UpdateLogConst() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.tmassistantsdk.logreport.UpdateInfoReportManager
 * JD-Core Version:    0.7.0.1
 */