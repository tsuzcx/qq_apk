package com.tencent.tmassistantsdk.downloadclient;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.tmassistantsdk.network.GetAppSimpleDetailEngine;
import com.tencent.tmassistantsdk.protocol.jce.AppDetailParam;
import com.tencent.tmassistantsdk.protocol.jce.AppSimpleDetail;
import com.tencent.tmassistantsdk.util.TMLog;
import java.util.ArrayList;
import java.util.Iterator;

public class TMAssistantDownloadSDKURLTool
  implements ITMAssistantExchangeURLListenner
{
  protected static final String TAG = "TMAssistantDownloadSDKExchangeURL";
  protected static TMAssistantDownloadSDKURLTool mInstance = null;
  protected GetAppSimpleDetailEngine engine;
  protected ITMAssistantExchangeURLListenner mListener;
  
  private TMAssistantDownloadSDKURLTool(ITMAssistantExchangeURLListenner paramITMAssistantExchangeURLListenner)
  {
    AppMethodBeat.i(101917);
    this.mListener = null;
    this.engine = null;
    if (paramITMAssistantExchangeURLListenner != null)
    {
      this.mListener = paramITMAssistantExchangeURLListenner;
      this.engine = new GetAppSimpleDetailEngine(this.mListener);
      AppMethodBeat.o(101917);
      return;
    }
    TMLog.e("TMAssistantDownloadSDKExchangeURL", "ITMAssistantExchangeURLListenner listener shouldn't be null!");
    AppMethodBeat.o(101917);
  }
  
  public static TMAssistantDownloadSDKURLTool getInstance(ITMAssistantExchangeURLListenner paramITMAssistantExchangeURLListenner)
  {
    try
    {
      AppMethodBeat.i(101918);
      if (mInstance == null) {
        mInstance = new TMAssistantDownloadSDKURLTool(paramITMAssistantExchangeURLListenner);
      }
      paramITMAssistantExchangeURLListenner = mInstance;
      AppMethodBeat.o(101918);
      return paramITMAssistantExchangeURLListenner;
    }
    finally {}
  }
  
  public void exchangeUrlsFromPackageNames(ArrayList<String> paramArrayList)
  {
    AppMethodBeat.i(101919);
    if (paramArrayList != null)
    {
      ArrayList localArrayList = new ArrayList();
      paramArrayList = paramArrayList.iterator();
      while (paramArrayList.hasNext())
      {
        String[] arrayOfString = ((String)paramArrayList.next()).split(";");
        if ((arrayOfString != null) && (arrayOfString.length > 0))
        {
          AppDetailParam localAppDetailParam = new AppDetailParam();
          localAppDetailParam.packageName = arrayOfString[0];
          if (arrayOfString.length > 1) {
            localAppDetailParam.channelId = arrayOfString[1];
          }
          localArrayList.add(localAppDetailParam);
        }
      }
      if ((localArrayList.size() > 0) && (this.engine != null)) {
        this.engine.sendReuqest(localArrayList);
      }
      AppMethodBeat.o(101919);
      return;
    }
    TMLog.w("TMAssistantDownloadSDKExchangeURL", "packageNames is null!");
    AppMethodBeat.o(101919);
  }
  
  public void onExchangedURLSucceed(ArrayList<AppSimpleDetail> paramArrayList, boolean paramBoolean)
  {
    AppMethodBeat.i(101920);
    if (this.mListener != null) {
      this.mListener.onExchangedURLSucceed(paramArrayList, paramBoolean);
    }
    AppMethodBeat.o(101920);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.tmassistantsdk.downloadclient.TMAssistantDownloadSDKURLTool
 * JD-Core Version:    0.7.0.1
 */