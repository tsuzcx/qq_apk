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
import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import org.json.JSONException;
import org.json.JSONObject;

public class YtSDKKitFramework
{
  private static final String TAG;
  private static YtSDKKitFramework instance;
  private static final String version = "1.0.8.67-wx";
  private Rect detectRect;
  private IYtSDKKitFrameworkEventListener eventListener;
  private int networkRequestTimeoutMS;
  private Rect previewRect;
  
  static
  {
    AppMethodBeat.i(192700);
    TAG = YtSDKKitFramework.class.getSimpleName();
    AppMethodBeat.o(192700);
  }
  
  private YtSDKKitFramework()
  {
    AppMethodBeat.i(192688);
    this.previewRect = new Rect(0, 0, 480, 640);
    this.detectRect = new Rect(10, 110, 470, 530);
    this.networkRequestTimeoutMS = 60000;
    AppMethodBeat.o(192688);
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
      AppMethodBeat.i(192690);
      if (instance == null) {
        instance = new YtSDKKitFramework();
      }
      YtSDKKitFramework localYtSDKKitFramework = instance;
      AppMethodBeat.o(192690);
      return localYtSDKKitFramework;
    }
    finally {}
  }
  
  private YtFSMBaseState parseStateFrom(String paramString, JSONObject paramJSONObject)
  {
    AppMethodBeat.i(192689);
    for (;;)
    {
      try
      {
        YtFSMBaseState localYtFSMBaseState = (YtFSMBaseState)Class.forName(paramString).getConstructor(new Class[0]).newInstance(new Object[0]);
        YtLogger.e(TAG, "Parse state " + paramString + "failed:" + localThrowable1.getMessage());
      }
      catch (Throwable localThrowable1)
      {
        try
        {
          localYtFSMBaseState.loadStateWith(paramString, paramJSONObject);
          paramJSONObject = localYtFSMBaseState;
          AppMethodBeat.o(192689);
          return paramJSONObject;
        }
        catch (Throwable localThrowable2)
        {
          for (;;)
          {
            paramJSONObject = localThrowable1;
            Object localObject = localThrowable2;
          }
        }
        localThrowable1 = localThrowable1;
        paramJSONObject = null;
      }
    }
  }
  
  public int deInit()
  {
    AppMethodBeat.i(192692);
    YtLogger.i(TAG, "sdkkit framework 1.0.8.67-wx deinit");
    YtSDKKitNetHelper.clearInstance();
    YtFSM.getInstance().stop();
    YtFSM.clearInstance();
    YtSDKStats.getInstance().exitState();
    YtSDKStats.clearInstance();
    AppMethodBeat.o(192692);
    return 0;
  }
  
  public void doPause()
  {
    AppMethodBeat.i(192697);
    YtFSM.getInstance().handlePauseEvent();
    AppMethodBeat.o(192697);
  }
  
  public void doResume()
  {
    AppMethodBeat.i(192698);
    YtFSM.getInstance().handleResumeEvent();
    AppMethodBeat.o(192698);
  }
  
  public void fireEvent(YtFrameworkFireEventType paramYtFrameworkFireEventType, Object paramObject)
  {
    AppMethodBeat.i(192694);
    YtFSM.getInstance().handleEvent(paramYtFrameworkFireEventType, paramObject);
    AppMethodBeat.o(192694);
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
    AppMethodBeat.i(192699);
    YtSDKPlatformContext localYtSDKPlatformContext = YtFSM.getInstance().getContext();
    AppMethodBeat.o(192699);
    return localYtSDKPlatformContext;
  }
  
  public Rect getPreviewRect()
  {
    return this.previewRect;
  }
  
  public int init(YtSDKPlatformContext paramYtSDKPlatformContext, JSONObject paramJSONObject, YtSDKKitFrameworkWorkMode paramYtSDKKitFrameworkWorkMode, ArrayList<String> paramArrayList, IYtSDKKitFrameworkEventListener paramIYtSDKKitFrameworkEventListener)
  {
    AppMethodBeat.i(192691);
    YtLogger.i(TAG, "sdkkit framework 1.0.8.67-wx init");
    if (paramYtSDKPlatformContext == null)
    {
      YtLogger.e(TAG, "Context cannot be null");
      AppMethodBeat.o(192691);
      return -1;
    }
    if (paramArrayList.isEmpty())
    {
      YtLogger.e(TAG, "Pipeline state name cannot be empty");
      AppMethodBeat.o(192691);
      return -1;
    }
    if (paramIYtSDKKitFrameworkEventListener == null)
    {
      YtLogger.e(TAG, "Event listener cannot be null");
      AppMethodBeat.o(192691);
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
        AppMethodBeat.o(192691);
        return 0;
      }
      catch (JSONException paramYtSDKPlatformContext)
      {
        YtLogger.e(TAG, "failed to get priority " + paramYtSDKPlatformContext.getLocalizedMessage());
      }
      int i = -8;
    }
  }
  
  public void reset()
  {
    AppMethodBeat.i(192693);
    new Handler(Looper.getMainLooper()).post(new Runnable()
    {
      public void run()
      {
        AppMethodBeat.i(192680);
        YtSDKStats.getInstance().reset();
        YtFSM.getInstance().reset();
        AppMethodBeat.o(192680);
      }
    });
    AppMethodBeat.o(192693);
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
    AppMethodBeat.i(192696);
    YtFSM.getInstance().updateSDKSetting(paramJSONObject);
    AppMethodBeat.o(192696);
  }
  
  public int updateWithFrameData(byte[] paramArrayOfByte, int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(192695);
    long l = System.currentTimeMillis();
    if (l <= 946684800000L)
    {
      AppMethodBeat.o(192695);
      return 3145731;
    }
    YtFSM.getInstance().update(paramArrayOfByte, paramInt1, paramInt2, paramInt3, l);
    AppMethodBeat.o(192695);
    return 0;
  }
  
  public String version()
  {
    return "1.0.8.67-wx";
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
      AppMethodBeat.i(192683);
      YT_EVENT_TRIGGER_BEGIN_LIVENESS = new YtFrameworkFireEventType("YT_EVENT_TRIGGER_BEGIN_LIVENESS", 0);
      YT_EVENT_TRIGGER_CANCEL_LIVENESS = new YtFrameworkFireEventType("YT_EVENT_TRIGGER_CANCEL_LIVENESS", 1);
      $VALUES = new YtFrameworkFireEventType[] { YT_EVENT_TRIGGER_BEGIN_LIVENESS, YT_EVENT_TRIGGER_CANCEL_LIVENESS };
      AppMethodBeat.o(192683);
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
      AppMethodBeat.i(192687);
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
      AppMethodBeat.o(192687);
    }
    
    private YtSDKKitFrameworkWorkMode(int paramInt)
    {
      this.value = paramInt;
    }
    
    public static YtSDKKitFrameworkWorkMode valueOf(int paramInt)
    {
      AppMethodBeat.i(192686);
      if (map.get(Integer.valueOf(paramInt)) == null)
      {
        localYtSDKKitFrameworkWorkMode = YT_FW_UNKNOWN;
        AppMethodBeat.o(192686);
        return localYtSDKKitFrameworkWorkMode;
      }
      YtSDKKitFrameworkWorkMode localYtSDKKitFrameworkWorkMode = (YtSDKKitFrameworkWorkMode)map.get(Integer.valueOf(paramInt));
      AppMethodBeat.o(192686);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.youtu.sdkkitframework.framework.YtSDKKitFramework
 * JD-Core Version:    0.7.0.1
 */