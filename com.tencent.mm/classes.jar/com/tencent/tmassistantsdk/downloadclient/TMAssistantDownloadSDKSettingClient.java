package com.tencent.tmassistantsdk.downloadclient;

import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.tmassistantsdk.aidl.ITMAssistantDownloadSDKServiceCallback;
import com.tencent.tmassistantsdk.aidl.ITMAssistantDownloadSDKServiceInterface;
import com.tencent.tmassistantsdk.aidl.ITMAssistantDownloadSDKServiceInterface.Stub;

public class TMAssistantDownloadSDKSettingClient
  extends TMAssistantDownloadSDKClientBase
{
  protected static final String DOWNDLOADSDKSERVICENAME = "com.tencent.TMAssistantDownloadSDKService";
  
  public TMAssistantDownloadSDKSettingClient(Context paramContext, String paramString)
  {
    super(paramContext, paramString, "com.tencent.TMAssistantDownloadSDKService");
  }
  
  protected Intent getBindServiceIntent()
  {
    AppMethodBeat.i(101915);
    Intent localIntent = new Intent(this.mContext, Class.forName(this.mDwonloadServiceName));
    AppMethodBeat.o(101915);
    return localIntent;
  }
  
  /* Error */
  public int getVersion()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: ldc 47
    //   4: invokestatic 23	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   7: aload_0
    //   8: invokespecial 51	com/tencent/tmassistantsdk/downloadclient/TMAssistantDownloadSDKClientBase:getServiceInterface	()Landroid/os/IInterface;
    //   11: checkcast 53	com/tencent/tmassistantsdk/aidl/ITMAssistantDownloadSDKServiceInterface
    //   14: astore_2
    //   15: aload_2
    //   16: ifnull +19 -> 35
    //   19: aload_2
    //   20: invokeinterface 56 1 0
    //   25: istore_1
    //   26: ldc 47
    //   28: invokestatic 44	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   31: aload_0
    //   32: monitorexit
    //   33: iload_1
    //   34: ireturn
    //   35: aload_0
    //   36: invokespecial 60	com/tencent/tmassistantsdk/downloadclient/TMAssistantDownloadSDKClientBase:initTMAssistantDownloadSDK	()Z
    //   39: pop
    //   40: iconst_0
    //   41: istore_1
    //   42: ldc 47
    //   44: invokestatic 44	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   47: goto -16 -> 31
    //   50: astore_2
    //   51: aload_0
    //   52: monitorexit
    //   53: aload_2
    //   54: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	55	0	this	TMAssistantDownloadSDKSettingClient
    //   25	17	1	i	int
    //   14	6	2	localITMAssistantDownloadSDKServiceInterface	ITMAssistantDownloadSDKServiceInterface
    //   50	4	2	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	15	50	finally
    //   19	31	50	finally
    //   35	40	50	finally
    //   42	47	50	finally
  }
  
  /* Error */
  public boolean isAllDownloadFinished()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: ldc 62
    //   4: invokestatic 23	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   7: aload_0
    //   8: invokespecial 51	com/tencent/tmassistantsdk/downloadclient/TMAssistantDownloadSDKClientBase:getServiceInterface	()Landroid/os/IInterface;
    //   11: checkcast 53	com/tencent/tmassistantsdk/aidl/ITMAssistantDownloadSDKServiceInterface
    //   14: astore_2
    //   15: aload_2
    //   16: ifnull +19 -> 35
    //   19: aload_2
    //   20: invokeinterface 64 1 0
    //   25: istore_1
    //   26: ldc 62
    //   28: invokestatic 44	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   31: aload_0
    //   32: monitorexit
    //   33: iload_1
    //   34: ireturn
    //   35: aload_0
    //   36: invokespecial 60	com/tencent/tmassistantsdk/downloadclient/TMAssistantDownloadSDKClientBase:initTMAssistantDownloadSDK	()Z
    //   39: pop
    //   40: iconst_0
    //   41: istore_1
    //   42: goto -16 -> 26
    //   45: astore_2
    //   46: aload_0
    //   47: monitorexit
    //   48: aload_2
    //   49: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	50	0	this	TMAssistantDownloadSDKSettingClient
    //   25	17	1	bool	boolean
    //   14	6	2	localITMAssistantDownloadSDKServiceInterface	ITMAssistantDownloadSDKServiceInterface
    //   45	4	2	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	15	45	finally
    //   19	26	45	finally
    //   26	31	45	finally
    //   35	40	45	finally
  }
  
  protected void onDownloadSDKServiceInvalid() {}
  
  protected void registerServiceCallback()
  {
    AppMethodBeat.i(101914);
    ((ITMAssistantDownloadSDKServiceInterface)this.mServiceInterface).registerDownloadTaskCallback(this.mClientKey, (ITMAssistantDownloadSDKServiceCallback)this.mServiceCallback);
    AppMethodBeat.o(101914);
  }
  
  public void setDownloadSDKMaxTaskNum(int paramInt)
  {
    for (;;)
    {
      try
      {
        AppMethodBeat.i(101911);
        if ((paramInt <= 0) || (paramInt > 10))
        {
          AppMethodBeat.o(101911);
          return;
        }
        ITMAssistantDownloadSDKServiceInterface localITMAssistantDownloadSDKServiceInterface = (ITMAssistantDownloadSDKServiceInterface)super.getServiceInterface();
        if (localITMAssistantDownloadSDKServiceInterface != null)
        {
          localITMAssistantDownloadSDKServiceInterface.setServiceSetingMaxTaskNum(paramInt);
          AppMethodBeat.o(101911);
          continue;
        }
        super.initTMAssistantDownloadSDK();
      }
      finally {}
      AppMethodBeat.o(101911);
    }
  }
  
  /* Error */
  public void setDownloadSDKWifiOnly(boolean paramBoolean)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: ldc 92
    //   4: invokestatic 23	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   7: aload_0
    //   8: invokespecial 51	com/tencent/tmassistantsdk/downloadclient/TMAssistantDownloadSDKClientBase:getServiceInterface	()Landroid/os/IInterface;
    //   11: checkcast 53	com/tencent/tmassistantsdk/aidl/ITMAssistantDownloadSDKServiceInterface
    //   14: astore_2
    //   15: aload_2
    //   16: ifnull +18 -> 34
    //   19: aload_2
    //   20: iload_1
    //   21: invokeinterface 95 2 0
    //   26: ldc 92
    //   28: invokestatic 44	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   31: aload_0
    //   32: monitorexit
    //   33: return
    //   34: aload_0
    //   35: invokespecial 60	com/tencent/tmassistantsdk/downloadclient/TMAssistantDownloadSDKClientBase:initTMAssistantDownloadSDK	()Z
    //   38: pop
    //   39: ldc 92
    //   41: invokestatic 44	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   44: goto -13 -> 31
    //   47: astore_2
    //   48: aload_0
    //   49: monitorexit
    //   50: aload_2
    //   51: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	52	0	this	TMAssistantDownloadSDKSettingClient
    //   0	52	1	paramBoolean	boolean
    //   14	6	2	localITMAssistantDownloadSDKServiceInterface	ITMAssistantDownloadSDKServiceInterface
    //   47	4	2	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	15	47	finally
    //   19	31	47	finally
    //   34	44	47	finally
  }
  
  protected void stubAsInterface(IBinder paramIBinder)
  {
    AppMethodBeat.i(101913);
    this.mServiceInterface = ITMAssistantDownloadSDKServiceInterface.Stub.asInterface(paramIBinder);
    AppMethodBeat.o(101913);
  }
  
  protected void unRegisterServiceCallback()
  {
    AppMethodBeat.i(101916);
    ((ITMAssistantDownloadSDKServiceInterface)this.mServiceInterface).unregisterDownloadTaskCallback(this.mClientKey, (ITMAssistantDownloadSDKServiceCallback)this.mServiceCallback);
    AppMethodBeat.o(101916);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.tmassistantsdk.downloadclient.TMAssistantDownloadSDKSettingClient
 * JD-Core Version:    0.7.0.1
 */