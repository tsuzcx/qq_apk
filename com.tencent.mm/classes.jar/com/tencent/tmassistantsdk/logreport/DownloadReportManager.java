package com.tencent.tmassistantsdk.logreport;

import android.net.Proxy;
import android.text.TextUtils;
import com.tencent.tmassistantsdk.protocol.jce.DownloadChunkLogInfo;
import com.tencent.tmassistantsdk.storage.table.BaseLogTable;
import com.tencent.tmassistantsdk.storage.table.DownloadLogTable;
import com.tencent.tmassistantsdk.util.GlobalUtil;
import com.tencent.tmassistantsdk.util.TMLog;

public class DownloadReportManager
  extends BaseReportManager
{
  protected static final String TAG = "DownloadReportManager";
  protected static DownloadReportManager mInstance = null;
  
  public static DownloadReportManager getInstance()
  {
    try
    {
      if (mInstance == null) {
        mInstance = new DownloadReportManager();
      }
      DownloadReportManager localDownloadReportManager = mInstance;
      return localDownloadReportManager;
    }
    finally {}
  }
  
  public DownloadChunkLogInfo createNewChunkLogInfo(byte paramByte)
  {
    TMLog.i("DownloadReportManager", "createNewChunkLogInfo");
    DownloadChunkLogInfo localDownloadChunkLogInfo = new DownloadChunkLogInfo();
    localDownloadChunkLogInfo.type = paramByte;
    localDownloadChunkLogInfo.networkOperator = GlobalUtil.getInstance().getNetworkOperator();
    localDownloadChunkLogInfo.networkType = GlobalUtil.getInstance().getNetworkType();
    if (!TextUtils.isEmpty(Proxy.getDefaultHost())) {}
    for (int i = 1;; i = 0)
    {
      localDownloadChunkLogInfo.isWap = ((byte)i);
      localDownloadChunkLogInfo.startTime = System.currentTimeMillis();
      return localDownloadChunkLogInfo;
    }
  }
  
  protected BaseLogTable getLogTable()
  {
    return DownloadLogTable.getInstance();
  }
  
  protected byte getReportType()
  {
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.tmassistantsdk.logreport.DownloadReportManager
 * JD-Core Version:    0.7.0.1
 */