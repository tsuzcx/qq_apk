package com.tencent.tmassistantsdk.logreport;

import com.qq.taf.jce.JceStruct;
import com.tencent.tmassistantsdk.protocol.ProtocolPackage;
import com.tencent.tmassistantsdk.storage.table.BaseLogTable;
import com.tencent.tmassistantsdk.storage.table.BaseLogTable.DataWrapper;
import com.tencent.tmassistantsdk.util.GlobalUtil;
import com.tencent.tmassistantsdk.util.TMLog;
import java.util.ArrayList;
import java.util.List;

public abstract class BaseReportManager
  implements ILogReportHttpListener
{
  public static final int MAX_READ_COUNT = 1000;
  protected static final String TAG = "BaseReportManager";
  protected final List<Long> idLists = new ArrayList();
  protected int maxReportCount = 0;
  protected LogReportHttpRequest reportRequest = null;
  
  public void addLogData(JceStruct paramJceStruct)
  {
    try
    {
      TMLog.i("BaseReportManager", "addLogData,loginfo");
      if (paramJceStruct != null)
      {
        paramJceStruct = ProtocolPackage.jceStructToUTF8Byte(paramJceStruct);
        getLogTable().save(paramJceStruct);
      }
      return;
    }
    finally {}
  }
  
  public void cancleRequest()
  {
    if (this.reportRequest != null)
    {
      this.reportRequest.cancleRequest();
      this.reportRequest = null;
    }
  }
  
  public void destroy()
  {
    this.reportRequest = null;
    this.idLists.clear();
  }
  
  protected abstract BaseLogTable getLogTable();
  
  protected abstract byte getReportType();
  
  public void onLogReprotHttpRequestFinish(LogReportHttpRequest paramLogReportHttpRequest, boolean paramBoolean)
  {
    TMLog.i("BaseReportManager", "onLogReprotHttpRequestFinish,result:".concat(String.valueOf(paramBoolean)));
    if ((paramBoolean) && (this.idLists != null) && (this.idLists.size() > 0)) {
      getLogTable().delete(this.idLists);
    }
    this.reportRequest = null;
    this.idLists.clear();
    if ((paramBoolean) && (this.maxReportCount < 5))
    {
      TMLog.i("BaseReportManager", "onLogReprotHttpRequestFinish wifi is true reportlog go on,result:" + paramBoolean + " count:" + this.maxReportCount);
      reportLogData();
      this.maxReportCount += 1;
    }
  }
  
  public void reportLogData()
  {
    boolean bool2 = false;
    for (;;)
    {
      try
      {
        bool1 = GlobalUtil.getInstance().canReportValue();
        if (!bool1) {
          return;
        }
        TMLog.i("BaseReportManager", "reportLogData,request:" + this.reportRequest);
        if (this.reportRequest != null) {
          continue;
        }
        this.reportRequest = new LogReportHttpRequest();
        this.reportRequest.setmListener(this);
        BaseLogTable.DataWrapper localDataWrapper1 = getLogTable().getDatas(1000);
        TMLog.i("BaseReportManager", "readLogDataAndSendToServer,wrappterCount:" + localDataWrapper1.dataList.size());
        bool1 = bool2;
        if (localDataWrapper1 != null)
        {
          if (localDataWrapper1.dataList.size() <= 0) {
            bool1 = bool2;
          }
        }
        else
        {
          if (bool1) {
            continue;
          }
          this.maxReportCount = 0;
          this.reportRequest = null;
          continue;
        }
        this.idLists.addAll(localDataWrapper2.idList);
      }
      finally {}
      boolean bool1 = this.reportRequest.sendLogDataToServer(getReportType(), localDataWrapper2);
    }
  }
  
  public void resetMaxReportCount()
  {
    this.maxReportCount = 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.tmassistantsdk.logreport.BaseReportManager
 * JD-Core Version:    0.7.0.1
 */