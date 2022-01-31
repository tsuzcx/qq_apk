package com.tencent.tmassistantsdk.logreport;

import com.qq.taf.jce.JceStruct;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.tmassistantsdk.network.PostHttpRequest;
import com.tencent.tmassistantsdk.protocol.ProtocolPackage;
import com.tencent.tmassistantsdk.protocol.jce.ReportLogRequest;
import com.tencent.tmassistantsdk.protocol.jce.ReportLogResponse;
import com.tencent.tmassistantsdk.storage.table.BaseLogTable.DataWrapper;
import com.tencent.tmassistantsdk.util.GlobalUtil;
import com.tencent.tmassistantsdk.util.TMLog;

public class LogReportHttpRequest
  extends PostHttpRequest
{
  protected ILogReportHttpListener mListener = null;
  
  public void onFinished(JceStruct paramJceStruct1, JceStruct paramJceStruct2, int paramInt)
  {
    AppMethodBeat.i(75816);
    if (paramJceStruct2 == null)
    {
      AppMethodBeat.o(75816);
      return;
    }
    if ((this.mListener != null) && (paramInt == 0))
    {
      if ((paramJceStruct2 instanceof ReportLogResponse))
      {
        if (((ReportLogResponse)paramJceStruct2).ret == 0)
        {
          this.mListener.onLogReprotHttpRequestFinish(this, true);
          AppMethodBeat.o(75816);
          return;
        }
        this.mListener.onLogReprotHttpRequestFinish(this, false);
        AppMethodBeat.o(75816);
        return;
      }
      TMLog.i("LogReportHttpRequest", "response isn't instanceof ReportLogResponse !");
      AppMethodBeat.o(75816);
      return;
    }
    TMLog.i("LogReportHttpRequest", "mListener is null !");
    AppMethodBeat.o(75816);
  }
  
  public boolean sendLogDataToServer(byte paramByte, BaseLogTable.DataWrapper paramDataWrapper)
  {
    AppMethodBeat.i(75815);
    if (paramDataWrapper == null)
    {
      AppMethodBeat.o(75815);
      return false;
    }
    String str = GlobalUtil.getAppPackageName(GlobalUtil.getInstance().getContext());
    int i = GlobalUtil.getAppVersionCode(GlobalUtil.getInstance().getContext());
    boolean bool = super.sendRequest((ReportLogRequest)ProtocolPackage.buildReportRequest(paramByte, paramDataWrapper.dataList, str, i, ""));
    AppMethodBeat.o(75815);
    return bool;
  }
  
  public void setmListener(ILogReportHttpListener paramILogReportHttpListener)
  {
    this.mListener = paramILogReportHttpListener;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.tmassistantsdk.logreport.LogReportHttpRequest
 * JD-Core Version:    0.7.0.1
 */