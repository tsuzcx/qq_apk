package com.tencent.youtu.sdkkitframework.framework;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.ColorMatrixColorFilter;
import android.graphics.Rect;
import android.hardware.Camera;
import android.os.Handler;
import android.os.Looper;
import android.widget.RelativeLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.youtu.sdkkitframework.common.YtLogger;
import com.tencent.youtu.sdkkitframework.common.YtSDKStats;
import com.tencent.youtu.sdkkitframework.net.YtSDKKitNetHelper;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import org.json.JSONException;
import org.json.JSONObject;

public class YtSDKKitFramework
{
  private static final String TAG;
  private static YtSDKKitFramework instance;
  private static final String version = "1.0.8.81.1-wx";
  private Rect detectRect;
  private IYtSDKKitFrameworkEventListener eventListener;
  private int networkRequestTimeoutMS;
  private Rect previewRect;
  
  static
  {
    AppMethodBeat.i(218077);
    TAG = YtSDKKitFramework.class.getSimpleName();
    AppMethodBeat.o(218077);
  }
  
  private YtSDKKitFramework()
  {
    AppMethodBeat.i(218065);
    this.previewRect = new Rect(0, 0, 480, 640);
    this.detectRect = new Rect(10, 110, 470, 530);
    this.networkRequestTimeoutMS = 60000;
    AppMethodBeat.o(218065);
  }
  
  public static void clearInstance()
  {
    try
    {
      instance = null;
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public static YtSDKKitFramework getInstance()
  {
    try
    {
      AppMethodBeat.i(218070);
      if (instance == null) {
        instance = new YtSDKKitFramework();
      }
      YtSDKKitFramework localYtSDKKitFramework = instance;
      AppMethodBeat.o(218070);
      return localYtSDKKitFramework;
    }
    finally {}
  }
  
  /* Error */
  private YtFSMBaseState parseStateFrom(String paramString, JSONObject paramJSONObject)
  {
    // Byte code:
    //   0: ldc 87
    //   2: invokestatic 49	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: aload_1
    //   6: invokestatic 91	java/lang/Class:forName	(Ljava/lang/String;)Ljava/lang/Class;
    //   9: iconst_0
    //   10: anewarray 51	java/lang/Class
    //   13: invokevirtual 95	java/lang/Class:getConstructor	([Ljava/lang/Class;)Ljava/lang/reflect/Constructor;
    //   16: iconst_0
    //   17: anewarray 4	java/lang/Object
    //   20: invokevirtual 101	java/lang/reflect/Constructor:newInstance	([Ljava/lang/Object;)Ljava/lang/Object;
    //   23: checkcast 103	com/tencent/youtu/sdkkitframework/framework/YtFSMBaseState
    //   26: astore_3
    //   27: aload_3
    //   28: aload_1
    //   29: aload_2
    //   30: invokevirtual 107	com/tencent/youtu/sdkkitframework/framework/YtFSMBaseState:loadStateWith	(Ljava/lang/String;Lorg/json/JSONObject;)V
    //   33: aload_3
    //   34: astore_2
    //   35: ldc 87
    //   37: invokestatic 60	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   40: aload_2
    //   41: areturn
    //   42: astore_3
    //   43: aconst_null
    //   44: astore_2
    //   45: getstatic 57	com/tencent/youtu/sdkkitframework/framework/YtSDKKitFramework:TAG	Ljava/lang/String;
    //   48: new 109	java/lang/StringBuilder
    //   51: dup
    //   52: ldc 111
    //   54: invokespecial 114	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   57: aload_1
    //   58: invokevirtual 118	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   61: ldc 120
    //   63: invokevirtual 118	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   66: aload_3
    //   67: invokevirtual 125	java/lang/Throwable:getMessage	()Ljava/lang/String;
    //   70: invokevirtual 118	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   73: invokevirtual 128	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   76: invokestatic 134	com/tencent/youtu/sdkkitframework/common/YtLogger:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   79: goto -44 -> 35
    //   82: astore 4
    //   84: aload_3
    //   85: astore_2
    //   86: aload 4
    //   88: astore_3
    //   89: goto -44 -> 45
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	92	0	this	YtSDKKitFramework
    //   0	92	1	paramString	String
    //   0	92	2	paramJSONObject	JSONObject
    //   26	8	3	localYtFSMBaseState	YtFSMBaseState
    //   42	43	3	localObject1	Object
    //   88	1	3	localObject2	Object
    //   82	5	4	localObject3	Object
    // Exception table:
    //   from	to	target	type
    //   5	27	42	finally
    //   27	33	82	finally
  }
  
  public int deInit()
  {
    AppMethodBeat.i(218094);
    YtLogger.i(TAG, "sdkkit framework 1.0.8.81.1-wx deinit");
    YtSDKKitNetHelper.clearInstance();
    YtFSM.getInstance().stop();
    YtFSM.clearInstance();
    YtSDKStats.getInstance().exitState();
    YtSDKStats.clearInstance();
    AppMethodBeat.o(218094);
    return 0;
  }
  
  public void doPause()
  {
    AppMethodBeat.i(218127);
    YtFSM.getInstance().handlePauseEvent();
    AppMethodBeat.o(218127);
  }
  
  public void doResume()
  {
    AppMethodBeat.i(218131);
    YtFSM.getInstance().handleResumeEvent();
    AppMethodBeat.o(218131);
  }
  
  public void fireEvent(YtFrameworkFireEventType paramYtFrameworkFireEventType, Object paramObject)
  {
    AppMethodBeat.i(218108);
    YtFSM.getInstance().handleEvent(paramYtFrameworkFireEventType, paramObject);
    AppMethodBeat.o(218108);
  }
  
  public Rect getDetectRect()
  {
    return this.detectRect;
  }
  
  public int getNetworkRequestTimeoutMS()
  {
    return this.networkRequestTimeoutMS;
  }
  
  public YtSDKPlatformContext getPlatformContext()
  {
    AppMethodBeat.i(218134);
    YtSDKPlatformContext localYtSDKPlatformContext = YtFSM.getInstance().getContext();
    AppMethodBeat.o(218134);
    return localYtSDKPlatformContext;
  }
  
  public Rect getPreviewRect()
  {
    return this.previewRect;
  }
  
  public int init(YtSDKPlatformContext paramYtSDKPlatformContext, JSONObject paramJSONObject, YtSDKKitFrameworkWorkMode paramYtSDKKitFrameworkWorkMode, ArrayList<String> paramArrayList, IYtSDKKitFrameworkEventListener paramIYtSDKKitFrameworkEventListener)
  {
    AppMethodBeat.i(218088);
    YtLogger.i(TAG, "sdkkit framework 1.0.8.81.1-wx init");
    if (paramYtSDKPlatformContext == null)
    {
      YtLogger.e(TAG, "Context cannot be null");
      AppMethodBeat.o(218088);
      return -1;
    }
    if (paramArrayList.isEmpty())
    {
      YtLogger.e(TAG, "Pipeline state name cannot be empty");
      AppMethodBeat.o(218088);
      return -1;
    }
    if (paramIYtSDKKitFrameworkEventListener == null)
    {
      YtLogger.e(TAG, "Event listener cannot be null");
      AppMethodBeat.o(218088);
      return -1;
    }
    YtFSM.getInstance().stop();
    YtFSM.getInstance().setEventListener(paramIYtSDKKitFrameworkEventListener);
    YtFSM.getInstance().setContext(paramYtSDKPlatformContext);
    paramYtSDKPlatformContext = paramArrayList.iterator();
    while (paramYtSDKPlatformContext.hasNext())
    {
      paramIYtSDKKitFrameworkEventListener = parseStateFrom((String)paramYtSDKPlatformContext.next(), paramJSONObject);
      YtFSM.getInstance().registerState(paramIYtSDKKitFrameworkEventListener);
    }
    if (paramJSONObject.has("thread_priority")) {}
    for (;;)
    {
      try
      {
        i = paramJSONObject.getInt("thread_priority");
        YtFSM.getInstance().start((String)paramArrayList.get(0), paramYtSDKKitFrameworkWorkMode, i);
        AppMethodBeat.o(218088);
        return 0;
      }
      catch (JSONException paramYtSDKPlatformContext)
      {
        YtLogger.e(TAG, "failed to get priority " + paramYtSDKPlatformContext.getLocalizedMessage());
      }
      int i = -20;
    }
  }
  
  public void reset()
  {
    AppMethodBeat.i(218101);
    new Handler(Looper.getMainLooper()).post(new Runnable()
    {
      public void run()
      {
        AppMethodBeat.i(218130);
        YtSDKStats.getInstance().reset();
        YtFSM.getInstance().reset();
        AppMethodBeat.o(218130);
      }
    });
    AppMethodBeat.o(218101);
  }
  
  public void setDetectRect(Rect paramRect)
  {
    this.detectRect = paramRect;
  }
  
  public void setNetworkRequestTimeoutMS(int paramInt)
  {
    int i = paramInt;
    if (paramInt < 0) {
      i = 0;
    }
    this.networkRequestTimeoutMS = i;
  }
  
  public void setPreviewRect(Rect paramRect)
  {
    this.previewRect = paramRect;
  }
  
  public void updateSDKSetting(JSONObject paramJSONObject)
  {
    AppMethodBeat.i(218124);
    YtFSM.getInstance().updateSDKSetting(paramJSONObject);
    AppMethodBeat.o(218124);
  }
  
  public int updateWithFrameData(byte[] paramArrayOfByte, int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(218116);
    long l = System.currentTimeMillis();
    if (l <= 946684800000L)
    {
      AppMethodBeat.o(218116);
      return 3145731;
    }
    YtFSM.getInstance().update(paramArrayOfByte, paramInt1, paramInt2, paramInt3, l);
    AppMethodBeat.o(218116);
    return 0;
  }
  
  public String version()
  {
    return "1.0.8.81.1-wx";
  }
  
  public static abstract interface IYTBaseFunctionListener
  {
    public abstract String base64Encode(byte[] paramArrayOfByte, int paramInt);
    
    public abstract byte[] getVoiceData();
  }
  
  public static abstract interface IYTReflectListener
  {
    public abstract float onGetAppBrightness();
    
    public abstract void onReflectEvent(ColorMatrixColorFilter paramColorMatrixColorFilter, float paramFloat);
    
    public abstract void onReflectStart(long paramLong);
  }
  
  public static abstract interface IYtSDKKitFrameworkEventListener
  {
    public abstract void onFrameworkEvent(HashMap<String, Object> paramHashMap);
    
    public abstract void onNetworkRequestEvent(String paramString1, String paramString2, HashMap<String, String> paramHashMap, YtSDKKitFramework.IYtSDKKitNetResponseParser paramIYtSDKKitNetResponseParser);
  }
  
  public static enum YtFrameworkFireEventType
  {
    static
    {
      AppMethodBeat.i(218093);
      YT_EVENT_TRIGGER_BEGIN_LIVENESS = new YtFrameworkFireEventType("YT_EVENT_TRIGGER_BEGIN_LIVENESS", 0);
      YT_EVENT_TRIGGER_CANCEL_LIVENESS = new YtFrameworkFireEventType("YT_EVENT_TRIGGER_CANCEL_LIVENESS", 1);
      $VALUES = new YtFrameworkFireEventType[] { YT_EVENT_TRIGGER_BEGIN_LIVENESS, YT_EVENT_TRIGGER_CANCEL_LIVENESS };
      AppMethodBeat.o(218093);
    }
    
    private YtFrameworkFireEventType() {}
  }
  
  public static enum YtSDKKitFrameworkWorkMode
  {
    private static HashMap<Integer, YtSDKKitFrameworkWorkMode> map;
    private int value;
    
    static
    {
      int i = 0;
      AppMethodBeat.i(218118);
      YT_FW_UNKNOWN = new YtSDKKitFrameworkWorkMode("YT_FW_UNKNOWN", 0, 0);
      YT_FW_OCR_TYPE = new YtSDKKitFrameworkWorkMode("YT_FW_OCR_TYPE", 1, 1);
      YT_FW_SILENT_TYPE = new YtSDKKitFrameworkWorkMode("YT_FW_SILENT_TYPE", 2, 2);
      YT_FW_ACTION_TYPE = new YtSDKKitFrameworkWorkMode("YT_FW_ACTION_TYPE", 3, 3);
      YT_FW_REFLECT_TYPE = new YtSDKKitFrameworkWorkMode("YT_FW_REFLECT_TYPE", 4, 4);
      YT_FW_ACTREFLECT_TYPE = new YtSDKKitFrameworkWorkMode("YT_FW_ACTREFLECT_TYPE", 5, 5);
      YT_FW_LIPREAD_TYPE = new YtSDKKitFrameworkWorkMode("YT_FW_LIPREAD_TYPE", 6, 6);
      YT_FW_DETECTONLY_TYPE = new YtSDKKitFrameworkWorkMode("YT_FW_DETECTONLY_TYPE", 7, 7);
      YT_FW_OCR_VIID_TYPE = new YtSDKKitFrameworkWorkMode("YT_FW_OCR_VIID_TYPE", 8, 8);
      $VALUES = new YtSDKKitFrameworkWorkMode[] { YT_FW_UNKNOWN, YT_FW_OCR_TYPE, YT_FW_SILENT_TYPE, YT_FW_ACTION_TYPE, YT_FW_REFLECT_TYPE, YT_FW_ACTREFLECT_TYPE, YT_FW_LIPREAD_TYPE, YT_FW_DETECTONLY_TYPE, YT_FW_OCR_VIID_TYPE };
      map = new HashMap();
      YtSDKKitFrameworkWorkMode[] arrayOfYtSDKKitFrameworkWorkMode = values();
      int j = arrayOfYtSDKKitFrameworkWorkMode.length;
      while (i < j)
      {
        YtSDKKitFrameworkWorkMode localYtSDKKitFrameworkWorkMode = arrayOfYtSDKKitFrameworkWorkMode[i];
        map.put(Integer.valueOf(localYtSDKKitFrameworkWorkMode.value), localYtSDKKitFrameworkWorkMode);
        i += 1;
      }
      AppMethodBeat.o(218118);
    }
    
    private YtSDKKitFrameworkWorkMode(int paramInt)
    {
      this.value = paramInt;
    }
    
    public static YtSDKKitFrameworkWorkMode valueOf(int paramInt)
    {
      AppMethodBeat.i(218112);
      if (map.get(Integer.valueOf(paramInt)) == null)
      {
        localYtSDKKitFrameworkWorkMode = YT_FW_UNKNOWN;
        AppMethodBeat.o(218112);
        return localYtSDKKitFrameworkWorkMode;
      }
      YtSDKKitFrameworkWorkMode localYtSDKKitFrameworkWorkMode = (YtSDKKitFrameworkWorkMode)map.get(Integer.valueOf(paramInt));
      AppMethodBeat.o(218112);
      return localYtSDKKitFrameworkWorkMode;
    }
    
    public final int getValue()
    {
      return this.value;
    }
  }
  
  public static class YtSDKPlatformContext
  {
    public YtSDKKitFramework.IYTBaseFunctionListener baseFunctionListener;
    public Context currentAppContext;
    public Camera currentCamera;
    public int currentCameraId;
    public int currentRotateState;
    public int imageToComapreType = 0;
    public Bitmap imageToCompare;
    public RelativeLayout reflectLayout;
    public YtSDKKitFramework.IYTReflectListener reflectListener;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.youtu.sdkkitframework.framework.YtSDKKitFramework
 * JD-Core Version:    0.7.0.1
 */