package com.tencent.tmassistantsdk.downloadclient;

import android.os.Bundle;
import android.os.HandlerThread;
import android.os.Message;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.threadpool.j.a;
import com.tencent.tmassistantsdk.util.ParamPair;
import com.tencent.tmassistantsdk.util.TMLog;
import java.util.ArrayList;
import java.util.Iterator;

public class TMAssistantDownloadSDKMessageThread
  extends MMHandler
{
  private static TMAssistantDownloadSDKMessageThread mInstance = null;
  private static HandlerThread mMessagehandlerThread = null;
  private static final int postActionResult = 4;
  private static final int postSDKServiceInvalidMessage = 3;
  private static final int postTaskProgressChangedMessage = 2;
  private static final int postTaskStateChangedMessage = 1;
  
  private TMAssistantDownloadSDKMessageThread(a parama)
  {
    super(parama);
  }
  
  public static TMAssistantDownloadSDKMessageThread getInstance()
  {
    try
    {
      AppMethodBeat.i(101903);
      if (mInstance == null) {
        mInstance = new TMAssistantDownloadSDKMessageThread(a.bFV("TMAssistantDownloadSDKMessageThread"));
      }
      TMAssistantDownloadSDKMessageThread localTMAssistantDownloadSDKMessageThread = mInstance;
      AppMethodBeat.o(101903);
      return localTMAssistantDownloadSDKMessageThread;
    }
    finally {}
  }
  
  public void handleMessage(Message paramMessage)
  {
    AppMethodBeat.i(101904);
    super.handleMessage(paramMessage);
    switch (paramMessage.what)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(101904);
      return;
      Object localObject2 = (ParamPair)paramMessage.obj;
      Object localObject1 = (TMAssistantDownloadSDKClient)((ParamPair)localObject2).mFirstParam;
      localObject2 = (ITMAssistantDownloadSDKClientListener)((ParamPair)localObject2).mSecondParam;
      paramMessage = paramMessage.getData();
      String str1 = paramMessage.getString("url");
      int i = paramMessage.getInt("state");
      int j = paramMessage.getInt("errorCode");
      String str2 = paramMessage.getString("errorMsg");
      boolean bool1 = paramMessage.getBoolean("hasChangeUrl");
      boolean bool2 = paramMessage.getBoolean("autoRetry");
      if (localObject2 != null)
      {
        ((ITMAssistantDownloadSDKClientListener)localObject2).OnDownloadSDKTaskStateChanged((TMAssistantDownloadSDKClient)localObject1, str1, i, j, str2, bool1, bool2);
        AppMethodBeat.o(101904);
        return;
        localObject2 = (ParamPair)paramMessage.obj;
        localObject1 = (TMAssistantDownloadSDKClient)((ParamPair)localObject2).mFirstParam;
        localObject2 = (ITMAssistantDownloadSDKClientListener)((ParamPair)localObject2).mSecondParam;
        paramMessage = paramMessage.getData();
        str1 = paramMessage.getString("url");
        long l1 = paramMessage.getLong("receiveDataLen");
        long l2 = paramMessage.getLong("totalDataLen");
        if (localObject2 != null)
        {
          ((ITMAssistantDownloadSDKClientListener)localObject2).OnDownloadSDKTaskProgressChanged((TMAssistantDownloadSDKClient)localObject1, str1, l1, l2);
          AppMethodBeat.o(101904);
          return;
          localObject1 = (ParamPair)paramMessage.obj;
          paramMessage = (TMAssistantDownloadSDKClient)((ParamPair)localObject1).mFirstParam;
          localObject1 = (ITMAssistantDownloadSDKClientListener)((ParamPair)localObject1).mSecondParam;
          if (localObject1 != null)
          {
            ((ITMAssistantDownloadSDKClientListener)localObject1).OnDwonloadSDKServiceInvalid(paramMessage);
            AppMethodBeat.o(101904);
            return;
            localObject1 = (ParamPair)paramMessage.obj;
            paramMessage = (byte[])((ParamPair)localObject1).mFirstParam;
            localObject1 = (ArrayList)((ParamPair)localObject1).mSecondParam;
            if (localObject1 != null)
            {
              localObject1 = ((ArrayList)localObject1).iterator();
              while (((Iterator)localObject1).hasNext())
              {
                localObject2 = (IAssistantOnActionListener)((Iterator)localObject1).next();
                if (localObject2 != null) {
                  ((IAssistantOnActionListener)localObject2).onActionResult(paramMessage);
                }
              }
            }
          }
        }
      }
    }
  }
  
  public void postActionResult(byte[] paramArrayOfByte, ArrayList<IAssistantOnActionListener> paramArrayList)
  {
    AppMethodBeat.i(101908);
    if ((paramArrayOfByte != null) && (paramArrayList != null))
    {
      Message localMessage = getInstance().obtainMessage();
      localMessage.what = 4;
      localMessage.obj = new ParamPair(paramArrayOfByte, paramArrayList);
      localMessage.sendToTarget();
    }
    AppMethodBeat.o(101908);
  }
  
  public void postSDKServiceInvalidMessage(TMAssistantDownloadSDKClient paramTMAssistantDownloadSDKClient, ITMAssistantDownloadSDKClientListener paramITMAssistantDownloadSDKClientListener)
  {
    AppMethodBeat.i(101907);
    if ((paramITMAssistantDownloadSDKClientListener == null) || (paramTMAssistantDownloadSDKClient == null))
    {
      AppMethodBeat.o(101907);
      return;
    }
    Message localMessage = getInstance().obtainMessage();
    localMessage.what = 3;
    localMessage.obj = new ParamPair(paramTMAssistantDownloadSDKClient, paramITMAssistantDownloadSDKClientListener);
    localMessage.sendToTarget();
    AppMethodBeat.o(101907);
  }
  
  public void postTaskProgressChangedMessage(TMAssistantDownloadSDKClient paramTMAssistantDownloadSDKClient, ITMAssistantDownloadSDKClientListener paramITMAssistantDownloadSDKClientListener, String paramString, long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(101906);
    if ((paramITMAssistantDownloadSDKClientListener == null) || (paramTMAssistantDownloadSDKClient == null))
    {
      TMLog.i("TMAssistantDownloadSDKMessageThread", "listenr:" + paramITMAssistantDownloadSDKClientListener + " === sdkClient" + paramTMAssistantDownloadSDKClient);
      AppMethodBeat.o(101906);
      return;
    }
    Message localMessage = getInstance().obtainMessage();
    localMessage.what = 2;
    localMessage.obj = new ParamPair(paramTMAssistantDownloadSDKClient, paramITMAssistantDownloadSDKClientListener);
    paramTMAssistantDownloadSDKClient = new Bundle();
    paramTMAssistantDownloadSDKClient.putString("url", paramString);
    paramTMAssistantDownloadSDKClient.putLong("receiveDataLen", paramLong1);
    paramTMAssistantDownloadSDKClient.putLong("totalDataLen", paramLong2);
    localMessage.setData(paramTMAssistantDownloadSDKClient);
    localMessage.sendToTarget();
    AppMethodBeat.o(101906);
  }
  
  public void postTaskStateChangedMessage(TMAssistantDownloadSDKClient paramTMAssistantDownloadSDKClient, ITMAssistantDownloadSDKClientListener paramITMAssistantDownloadSDKClientListener, String paramString1, int paramInt1, int paramInt2, String paramString2, boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(101905);
    if ((paramITMAssistantDownloadSDKClientListener == null) || (paramTMAssistantDownloadSDKClient == null))
    {
      AppMethodBeat.o(101905);
      return;
    }
    Message localMessage = getInstance().obtainMessage();
    localMessage.what = 1;
    localMessage.obj = new ParamPair(paramTMAssistantDownloadSDKClient, paramITMAssistantDownloadSDKClientListener);
    paramTMAssistantDownloadSDKClient = new Bundle();
    paramTMAssistantDownloadSDKClient.putString("url", paramString1);
    paramTMAssistantDownloadSDKClient.putInt("state", paramInt1);
    paramTMAssistantDownloadSDKClient.putInt("errorCode", paramInt2);
    paramTMAssistantDownloadSDKClient.putString("errorMsg", paramString2);
    paramTMAssistantDownloadSDKClient.putBoolean("hasChangeUrl", paramBoolean1);
    paramTMAssistantDownloadSDKClient.putBoolean("autoRetry", paramBoolean2);
    localMessage.setData(paramTMAssistantDownloadSDKClient);
    localMessage.sendToTarget();
    AppMethodBeat.o(101905);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.tmassistantsdk.downloadclient.TMAssistantDownloadSDKMessageThread
 * JD-Core Version:    0.7.0.1
 */