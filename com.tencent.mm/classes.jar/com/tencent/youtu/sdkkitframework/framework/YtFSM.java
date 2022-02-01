package com.tencent.youtu.sdkkitframework.framework;

import android.os.Process;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.youtu.sdkkitframework.common.YtLogger;
import com.tencent.youtu.sdkkitframework.common.YtSDKStats;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import org.json.JSONObject;

public class YtFSM
{
  private static final String TAG;
  private static YtFSM instance;
  private YtFSMUpdateData currentData;
  private YtFSMBaseState currentState;
  private YtSDKKitFramework.YtSDKKitFrameworkWorkMode currentWorkMode;
  private YtSDKKitFramework.IYtSDKKitFrameworkEventListener eventListener;
  private ConcurrentLinkedQueue<Object> eventQueue;
  private String firstStateName;
  private boolean isStarted;
  private boolean needEventHandler;
  private YtSDKKitFramework.YtSDKPlatformContext sdkPlatformContex;
  private Lock startStopLock;
  private Lock stateLock;
  private HashMap<String, YtFSMBaseState> stateMap;
  private Thread updateEventHandler;
  private ConcurrentLinkedQueue<YtFSMUpdateData> updateQueue;
  
  static
  {
    AppMethodBeat.i(218133);
    TAG = YtFSM.class.getSimpleName();
    AppMethodBeat.o(218133);
  }
  
  private YtFSM()
  {
    AppMethodBeat.i(218069);
    this.currentWorkMode = YtSDKKitFramework.YtSDKKitFrameworkWorkMode.YT_FW_UNKNOWN;
    this.isStarted = false;
    this.needEventHandler = false;
    this.stateMap = new HashMap();
    this.currentData = new YtFSMUpdateData(null);
    this.stateLock = new ReentrantLock();
    this.startStopLock = new ReentrantLock();
    this.updateQueue = new ConcurrentLinkedQueue();
    this.eventQueue = new ConcurrentLinkedQueue();
    AppMethodBeat.o(218069);
  }
  
  public static void clearInstance()
  {
    try
    {
      if (instance != null) {
        instance = null;
      }
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public static YtFSM getInstance()
  {
    try
    {
      AppMethodBeat.i(218073);
      if (instance == null) {
        instance = new YtFSM();
      }
      YtFSM localYtFSM = instance;
      AppMethodBeat.o(218073);
      return localYtFSM;
    }
    finally {}
  }
  
  public void cleanUpQueue()
  {
    AppMethodBeat.i(218233);
    this.updateQueue.clear();
    AppMethodBeat.o(218233);
  }
  
  public YtSDKKitFramework.YtSDKPlatformContext getContext()
  {
    AppMethodBeat.i(218228);
    if (this.sdkPlatformContex == null) {
      this.sdkPlatformContex = new YtSDKKitFramework.YtSDKPlatformContext();
    }
    YtSDKKitFramework.YtSDKPlatformContext localYtSDKPlatformContext = this.sdkPlatformContex;
    AppMethodBeat.o(218228);
    return localYtSDKPlatformContext;
  }
  
  public YtFSMBaseState getStateByName(String paramString)
  {
    AppMethodBeat.i(218197);
    if (this.stateMap.containsKey(paramString))
    {
      paramString = (YtFSMBaseState)this.stateMap.get(paramString);
      AppMethodBeat.o(218197);
      return paramString;
    }
    AppMethodBeat.o(218197);
    return null;
  }
  
  public YtSDKKitFramework.YtSDKKitFrameworkWorkMode getWorkMode()
  {
    return this.currentWorkMode;
  }
  
  public void handleEvent(YtSDKKitFramework.YtFrameworkFireEventType paramYtFrameworkFireEventType, Object paramObject)
  {
    AppMethodBeat.i(218156);
    try
    {
      this.eventQueue.add(new YtFSMFireEventData(paramYtFrameworkFireEventType, paramObject));
      AppMethodBeat.o(218156);
      return;
    }
    catch (Exception paramYtFrameworkFireEventType)
    {
      YtLogger.e(TAG, "Handle event failed:" + paramYtFrameworkFireEventType.getLocalizedMessage());
      AppMethodBeat.o(218156);
    }
  }
  
  public void handlePauseEvent()
  {
    AppMethodBeat.i(218170);
    Iterator localIterator = this.stateMap.values().iterator();
    while (localIterator.hasNext()) {
      ((YtFSMBaseState)localIterator.next()).onPause();
    }
    AppMethodBeat.o(218170);
  }
  
  public void handleResumeEvent()
  {
    AppMethodBeat.i(218176);
    Iterator localIterator = this.stateMap.values().iterator();
    while (localIterator.hasNext()) {
      ((YtFSMBaseState)localIterator.next()).onResume();
    }
    AppMethodBeat.o(218176);
  }
  
  public int registerState(YtFSMBaseState paramYtFSMBaseState)
  {
    AppMethodBeat.i(218181);
    YtSDKStats.getInstance().registerStateName(paramYtFSMBaseState.getStateSimpleName());
    this.stateMap.put(paramYtFSMBaseState.getStateName(), paramYtFSMBaseState);
    AppMethodBeat.o(218181);
    return 0;
  }
  
  public void reset()
  {
    AppMethodBeat.i(218152);
    YtLogger.i(TAG, "FSM reset work mode " + this.currentWorkMode);
    try
    {
      this.eventQueue.add("reset");
      AppMethodBeat.o(218152);
      return;
    }
    catch (Exception localException)
    {
      YtLogger.e(TAG, "handle reset failed:" + localException.getLocalizedMessage());
      AppMethodBeat.o(218152);
    }
  }
  
  public void sendFSMEvent(HashMap<String, Object> paramHashMap)
  {
    AppMethodBeat.i(218202);
    if (this.eventListener != null)
    {
      if (paramHashMap.containsKey("process_action")) {
        YtLogger.d(TAG, "send framework event result: " + paramHashMap.get("process_action") + " errorcode:" + paramHashMap.get("error_code"));
      }
      this.eventListener.onFrameworkEvent(paramHashMap);
      AppMethodBeat.o(218202);
      return;
    }
    YtLogger.e(TAG, "Event listener not init");
    AppMethodBeat.o(218202);
  }
  
  public void sendNetworkRequest(final String paramString1, String paramString2, String paramString3, HashMap<String, String> paramHashMap, YtSDKKitFramework.IYtSDKKitNetResponseParser paramIYtSDKKitNetResponseParser)
  {
    AppMethodBeat.i(218207);
    if (this.eventListener != null)
    {
      sendFSMEvent(new HashMap() {});
      this.eventListener.onNetworkRequestEvent(paramString2, paramString3, paramHashMap, paramIYtSDKKitNetResponseParser);
      AppMethodBeat.o(218207);
      return;
    }
    YtLogger.e(TAG, "Event listener not init");
    AppMethodBeat.o(218207);
  }
  
  public void setContext(YtSDKKitFramework.YtSDKPlatformContext paramYtSDKPlatformContext)
  {
    this.sdkPlatformContex = paramYtSDKPlatformContext;
  }
  
  public void setEventListener(YtSDKKitFramework.IYtSDKKitFrameworkEventListener paramIYtSDKKitFrameworkEventListener)
  {
    this.eventListener = paramIYtSDKKitFrameworkEventListener;
  }
  
  /* Error */
  public void start(String paramString, YtSDKKitFramework.YtSDKKitFrameworkWorkMode paramYtSDKKitFrameworkWorkMode, final int paramInt)
  {
    // Byte code:
    //   0: ldc_w 308
    //   3: invokestatic 54	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: getstatic 62	com/tencent/youtu/sdkkitframework/framework/YtFSM:TAG	Ljava/lang/String;
    //   9: ldc_w 310
    //   12: aload_2
    //   13: invokestatic 316	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   16: invokevirtual 320	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   19: invokestatic 259	com/tencent/youtu/sdkkitframework/common/YtLogger:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   22: aload_0
    //   23: getfield 98	com/tencent/youtu/sdkkitframework/framework/YtFSM:startStopLock	Ljava/util/concurrent/locks/Lock;
    //   26: invokeinterface 325 1 0
    //   31: aload_0
    //   32: getfield 79	com/tencent/youtu/sdkkitframework/framework/YtFSM:isStarted	Z
    //   35: ifne +122 -> 157
    //   38: aload_0
    //   39: aload_1
    //   40: putfield 120	com/tencent/youtu/sdkkitframework/framework/YtFSM:firstStateName	Ljava/lang/String;
    //   43: aload_0
    //   44: aload_2
    //   45: putfield 77	com/tencent/youtu/sdkkitframework/framework/YtFSM:currentWorkMode	Lcom/tencent/youtu/sdkkitframework/framework/YtSDKKitFramework$YtSDKKitFrameworkWorkMode;
    //   48: aload_0
    //   49: iconst_1
    //   50: putfield 79	com/tencent/youtu/sdkkitframework/framework/YtFSM:isStarted	Z
    //   53: aload_0
    //   54: iconst_1
    //   55: putfield 81	com/tencent/youtu/sdkkitframework/framework/YtFSM:needEventHandler	Z
    //   58: aload_0
    //   59: getfield 86	com/tencent/youtu/sdkkitframework/framework/YtFSM:stateMap	Ljava/util/HashMap;
    //   62: aload_0
    //   63: getfield 120	com/tencent/youtu/sdkkitframework/framework/YtFSM:firstStateName	Ljava/lang/String;
    //   66: invokevirtual 157	java/util/HashMap:containsKey	(Ljava/lang/Object;)Z
    //   69: ifeq +104 -> 173
    //   72: getstatic 62	com/tencent/youtu/sdkkitframework/framework/YtFSM:TAG	Ljava/lang/String;
    //   75: ldc_w 327
    //   78: aload_1
    //   79: invokestatic 316	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   82: invokevirtual 320	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   85: invokestatic 279	com/tencent/youtu/sdkkitframework/common/YtLogger:d	(Ljava/lang/String;Ljava/lang/Object;)V
    //   88: aload_0
    //   89: aload_0
    //   90: getfield 86	com/tencent/youtu/sdkkitframework/framework/YtFSM:stateMap	Ljava/util/HashMap;
    //   93: aload_0
    //   94: getfield 120	com/tencent/youtu/sdkkitframework/framework/YtFSM:firstStateName	Ljava/lang/String;
    //   97: invokevirtual 161	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   100: checkcast 163	com/tencent/youtu/sdkkitframework/framework/YtFSMBaseState
    //   103: putfield 125	com/tencent/youtu/sdkkitframework/framework/YtFSM:currentState	Lcom/tencent/youtu/sdkkitframework/framework/YtFSMBaseState;
    //   106: aload_0
    //   107: getfield 125	com/tencent/youtu/sdkkitframework/framework/YtFSM:currentState	Lcom/tencent/youtu/sdkkitframework/framework/YtFSMBaseState;
    //   110: invokevirtual 330	com/tencent/youtu/sdkkitframework/framework/YtFSMBaseState:enter	()V
    //   113: aload_0
    //   114: getfield 103	com/tencent/youtu/sdkkitframework/framework/YtFSM:updateQueue	Ljava/util/concurrent/ConcurrentLinkedQueue;
    //   117: invokevirtual 142	java/util/concurrent/ConcurrentLinkedQueue:clear	()V
    //   120: aload_0
    //   121: new 332	java/lang/Thread
    //   124: dup
    //   125: new 6	com/tencent/youtu/sdkkitframework/framework/YtFSM$1
    //   128: dup
    //   129: aload_0
    //   130: iload_3
    //   131: invokespecial 335	com/tencent/youtu/sdkkitframework/framework/YtFSM$1:<init>	(Lcom/tencent/youtu/sdkkitframework/framework/YtFSM;I)V
    //   134: invokespecial 338	java/lang/Thread:<init>	(Ljava/lang/Runnable;)V
    //   137: putfield 340	com/tencent/youtu/sdkkitframework/framework/YtFSM:updateEventHandler	Ljava/lang/Thread;
    //   140: aload_0
    //   141: getfield 340	com/tencent/youtu/sdkkitframework/framework/YtFSM:updateEventHandler	Ljava/lang/Thread;
    //   144: ldc_w 342
    //   147: invokevirtual 345	java/lang/Thread:setName	(Ljava/lang/String;)V
    //   150: aload_0
    //   151: getfield 340	com/tencent/youtu/sdkkitframework/framework/YtFSM:updateEventHandler	Ljava/lang/Thread;
    //   154: invokevirtual 347	java/lang/Thread:start	()V
    //   157: aload_0
    //   158: getfield 98	com/tencent/youtu/sdkkitframework/framework/YtFSM:startStopLock	Ljava/util/concurrent/locks/Lock;
    //   161: invokeinterface 350 1 0
    //   166: ldc_w 308
    //   169: invokestatic 65	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   172: return
    //   173: getstatic 62	com/tencent/youtu/sdkkitframework/framework/YtFSM:TAG	Ljava/lang/String;
    //   176: new 178	java/lang/StringBuilder
    //   179: dup
    //   180: ldc_w 352
    //   183: invokespecial 183	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   186: aload_1
    //   187: invokevirtual 190	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   190: ldc_w 354
    //   193: invokevirtual 190	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   196: invokevirtual 193	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   199: invokestatic 199	com/tencent/youtu/sdkkitframework/common/YtLogger:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   202: goto -89 -> 113
    //   205: astore_1
    //   206: getstatic 62	com/tencent/youtu/sdkkitframework/framework/YtFSM:TAG	Ljava/lang/String;
    //   209: aload_1
    //   210: invokevirtual 186	java/lang/Exception:getLocalizedMessage	()Ljava/lang/String;
    //   213: invokestatic 199	com/tencent/youtu/sdkkitframework/common/YtLogger:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   216: aload_0
    //   217: getfield 98	com/tencent/youtu/sdkkitframework/framework/YtFSM:startStopLock	Ljava/util/concurrent/locks/Lock;
    //   220: invokeinterface 350 1 0
    //   225: ldc_w 308
    //   228: invokestatic 65	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   231: return
    //   232: astore_1
    //   233: aload_0
    //   234: getfield 98	com/tencent/youtu/sdkkitframework/framework/YtFSM:startStopLock	Ljava/util/concurrent/locks/Lock;
    //   237: invokeinterface 350 1 0
    //   242: ldc_w 308
    //   245: invokestatic 65	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   248: aload_1
    //   249: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	250	0	this	YtFSM
    //   0	250	1	paramString	String
    //   0	250	2	paramYtSDKKitFrameworkWorkMode	YtSDKKitFramework.YtSDKKitFrameworkWorkMode
    //   0	250	3	paramInt	int
    // Exception table:
    //   from	to	target	type
    //   22	113	205	java/lang/Exception
    //   113	157	205	java/lang/Exception
    //   173	202	205	java/lang/Exception
    //   22	113	232	finally
    //   113	157	232	finally
    //   173	202	232	finally
    //   206	216	232	finally
  }
  
  /* Error */
  public void stop()
  {
    // Byte code:
    //   0: ldc_w 358
    //   3: invokestatic 54	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: getstatic 62	com/tencent/youtu/sdkkitframework/framework/YtFSM:TAG	Ljava/lang/String;
    //   9: new 178	java/lang/StringBuilder
    //   12: dup
    //   13: ldc_w 360
    //   16: invokespecial 183	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   19: aload_0
    //   20: getfield 77	com/tencent/youtu/sdkkitframework/framework/YtFSM:currentWorkMode	Lcom/tencent/youtu/sdkkitframework/framework/YtSDKKitFramework$YtSDKKitFrameworkWorkMode;
    //   23: invokevirtual 257	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   26: invokevirtual 193	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   29: invokestatic 259	com/tencent/youtu/sdkkitframework/common/YtLogger:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   32: aload_0
    //   33: getfield 98	com/tencent/youtu/sdkkitframework/framework/YtFSM:startStopLock	Ljava/util/concurrent/locks/Lock;
    //   36: invokeinterface 325 1 0
    //   41: aload_0
    //   42: iconst_0
    //   43: putfield 81	com/tencent/youtu/sdkkitframework/framework/YtFSM:needEventHandler	Z
    //   46: aload_0
    //   47: getfield 340	com/tencent/youtu/sdkkitframework/framework/YtFSM:updateEventHandler	Ljava/lang/Thread;
    //   50: ifnull +20 -> 70
    //   53: aload_0
    //   54: getfield 340	com/tencent/youtu/sdkkitframework/framework/YtFSM:updateEventHandler	Ljava/lang/Thread;
    //   57: invokevirtual 363	java/lang/Thread:isAlive	()Z
    //   60: ifeq +10 -> 70
    //   63: aload_0
    //   64: getfield 340	com/tencent/youtu/sdkkitframework/framework/YtFSM:updateEventHandler	Ljava/lang/Thread;
    //   67: invokevirtual 366	java/lang/Thread:join	()V
    //   70: aload_0
    //   71: getfield 79	com/tencent/youtu/sdkkitframework/framework/YtFSM:isStarted	Z
    //   74: iconst_1
    //   75: if_icmpne +86 -> 161
    //   78: aload_0
    //   79: iconst_0
    //   80: putfield 79	com/tencent/youtu/sdkkitframework/framework/YtFSM:isStarted	Z
    //   83: aload_0
    //   84: getfield 86	com/tencent/youtu/sdkkitframework/framework/YtFSM:stateMap	Ljava/util/HashMap;
    //   87: invokevirtual 205	java/util/HashMap:values	()Ljava/util/Collection;
    //   90: invokeinterface 211 1 0
    //   95: astore_1
    //   96: aload_1
    //   97: invokeinterface 217 1 0
    //   102: ifeq +45 -> 147
    //   105: aload_1
    //   106: invokeinterface 221 1 0
    //   111: checkcast 163	com/tencent/youtu/sdkkitframework/framework/YtFSMBaseState
    //   114: invokevirtual 369	com/tencent/youtu/sdkkitframework/framework/YtFSMBaseState:unload	()V
    //   117: goto -21 -> 96
    //   120: astore_1
    //   121: getstatic 62	com/tencent/youtu/sdkkitframework/framework/YtFSM:TAG	Ljava/lang/String;
    //   124: aload_1
    //   125: invokevirtual 370	java/lang/InterruptedException:getLocalizedMessage	()Ljava/lang/String;
    //   128: invokestatic 199	com/tencent/youtu/sdkkitframework/common/YtLogger:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   131: aload_0
    //   132: getfield 98	com/tencent/youtu/sdkkitframework/framework/YtFSM:startStopLock	Ljava/util/concurrent/locks/Lock;
    //   135: invokeinterface 350 1 0
    //   140: ldc_w 358
    //   143: invokestatic 65	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   146: return
    //   147: aload_0
    //   148: getfield 86	com/tencent/youtu/sdkkitframework/framework/YtFSM:stateMap	Ljava/util/HashMap;
    //   151: invokevirtual 371	java/util/HashMap:clear	()V
    //   154: aload_0
    //   155: getfield 103	com/tencent/youtu/sdkkitframework/framework/YtFSM:updateQueue	Ljava/util/concurrent/ConcurrentLinkedQueue;
    //   158: invokevirtual 142	java/util/concurrent/ConcurrentLinkedQueue:clear	()V
    //   161: aload_0
    //   162: getfield 98	com/tencent/youtu/sdkkitframework/framework/YtFSM:startStopLock	Ljava/util/concurrent/locks/Lock;
    //   165: invokeinterface 350 1 0
    //   170: ldc_w 358
    //   173: invokestatic 65	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   176: return
    //   177: astore_1
    //   178: aload_0
    //   179: getfield 98	com/tencent/youtu/sdkkitframework/framework/YtFSM:startStopLock	Ljava/util/concurrent/locks/Lock;
    //   182: invokeinterface 350 1 0
    //   187: ldc_w 358
    //   190: invokestatic 65	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   193: aload_1
    //   194: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	195	0	this	YtFSM
    //   95	11	1	localIterator	Iterator
    //   120	5	1	localInterruptedException	InterruptedException
    //   177	17	1	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   32	70	120	java/lang/InterruptedException
    //   70	96	120	java/lang/InterruptedException
    //   96	117	120	java/lang/InterruptedException
    //   147	161	120	java/lang/InterruptedException
    //   32	70	177	finally
    //   70	96	177	finally
    //   96	117	177	finally
    //   121	131	177	finally
    //   147	161	177	finally
  }
  
  public int transitNextRound(String paramString)
  {
    AppMethodBeat.i(218192);
    int i;
    if (this.stateMap.containsKey(paramString))
    {
      this.currentState.exit();
      YtLogger.d(TAG, "transitnextround set current state:".concat(String.valueOf(paramString)));
      this.currentState = ((YtFSMBaseState)this.stateMap.get(paramString));
      this.currentState.enter();
      i = 0;
    }
    for (;;)
    {
      AppMethodBeat.o(218192);
      return i;
      i = -1;
      YtLogger.e(TAG, "transitnextround faild:" + paramString + " state is not found");
    }
  }
  
  public int transitNow(String paramString)
  {
    AppMethodBeat.i(218187);
    int i;
    if (this.stateMap.containsKey(paramString))
    {
      this.currentState.exit();
      YtLogger.d(TAG, "transitnow set current state:".concat(String.valueOf(paramString)));
      this.currentState = ((YtFSMBaseState)this.stateMap.get(paramString));
      this.currentState.enter();
      if (this.currentData == null) {
        break label155;
      }
      this.currentState.update(this.currentData.imageData, this.currentData.imageWidth, this.currentData.imageHeight, this.currentData.imageType, this.currentData.timeStamp);
      i = 0;
    }
    for (;;)
    {
      AppMethodBeat.o(218187);
      return i;
      i = -1;
      YtLogger.e(TAG, "transitnow failed:" + paramString + " state is not found");
      continue;
      label155:
      i = 0;
    }
  }
  
  public void update(byte[] paramArrayOfByte, int paramInt1, int paramInt2, int paramInt3, long paramLong)
  {
    AppMethodBeat.i(218159);
    if (this.isStarted)
    {
      YtFSMUpdateData localYtFSMUpdateData = new YtFSMUpdateData(null);
      localYtFSMUpdateData.imageData = paramArrayOfByte;
      localYtFSMUpdateData.imageWidth = paramInt1;
      localYtFSMUpdateData.imageHeight = paramInt2;
      localYtFSMUpdateData.imageType = paramInt3;
      localYtFSMUpdateData.timeStamp = paramLong;
      if (this.updateQueue.size() >= 10)
      {
        this.updateQueue.poll();
        YtLogger.w(TAG, "drop frame");
      }
      this.updateQueue.add(localYtFSMUpdateData);
      YtLogger.d(TAG, "debug_thread queue size:" + this.updateQueue.size());
    }
    AppMethodBeat.o(218159);
  }
  
  public void updateSDKSetting(JSONObject paramJSONObject)
  {
    AppMethodBeat.i(218164);
    Iterator localIterator = this.stateMap.values().iterator();
    while (localIterator.hasNext()) {
      ((YtFSMBaseState)localIterator.next()).updateSDKSetting(paramJSONObject);
    }
    AppMethodBeat.o(218164);
  }
  
  class YtFSMFireEventData
  {
    YtSDKKitFramework.YtFrameworkFireEventType eventType;
    Object extraData;
    
    public YtFSMFireEventData(YtSDKKitFramework.YtFrameworkFireEventType paramYtFrameworkFireEventType, Object paramObject)
    {
      this.eventType = paramYtFrameworkFireEventType;
      this.extraData = paramObject;
    }
  }
  
  class YtFSMUpdateData
  {
    byte[] imageData;
    int imageHeight;
    int imageType;
    int imageWidth;
    long timeStamp;
    
    private YtFSMUpdateData() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.youtu.sdkkitframework.framework.YtFSM
 * JD-Core Version:    0.7.0.1
 */