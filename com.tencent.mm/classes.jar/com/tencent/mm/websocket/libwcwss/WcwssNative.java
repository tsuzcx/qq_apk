package com.tencent.mm.websocket.libwcwss;

import android.support.annotation.Keep;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.HashMap;

@Keep
public class WcwssNative
{
  public static int INIT_ERROR;
  public static int NEW_WCWSS_ERROR;
  public static int REPEAT_INIT_ERROR;
  public static String TAG;
  private static HashMap<String, IWcWssWebSocketListener> gMapCallbacks;
  protected static Object listenerlock;
  protected static Object lock;
  private static IWcWssReportListener mCallerWcWssReportListener;
  private static IWcWssReportListener mWcWssReportListener;
  private static IWcWssWebSocketListener mWcWssWebSocketListener;
  
  static
  {
    AppMethodBeat.i(3504);
    TAG = "WcwssNative";
    NEW_WCWSS_ERROR = -1000;
    REPEAT_INIT_ERROR = -1001;
    INIT_ERROR = -1002;
    gMapCallbacks = new HashMap();
    mCallerWcWssReportListener = null;
    lock = new Object();
    listenerlock = new Object();
    mWcWssWebSocketListener = new IWcWssWebSocketListener()
    {
      public final int doCertificateVerify(String paramAnonymousString1, long paramAnonymousLong, String paramAnonymousString2, byte[][] paramAnonymousArrayOfByte)
      {
        AppMethodBeat.i(3492);
        WcwssNative.IWcWssWebSocketListener localIWcWssWebSocketListener = null;
        synchronized (WcwssNative.listenerlock)
        {
          if (WcwssNative.gMapCallbacks.containsKey(paramAnonymousString1)) {
            localIWcWssWebSocketListener = (WcwssNative.IWcWssWebSocketListener)WcwssNative.gMapCallbacks.get(paramAnonymousString1);
          }
          if (localIWcWssWebSocketListener != null)
          {
            int i = localIWcWssWebSocketListener.doCertificateVerify(paramAnonymousString1, paramAnonymousLong, paramAnonymousString2, paramAnonymousArrayOfByte);
            AppMethodBeat.o(3492);
            return i;
          }
        }
        paramAnonymousString1 = WcwssNative.TAG;
        AppMethodBeat.o(3492);
        return -1;
      }
      
      public final void onStateChange(String paramAnonymousString, long paramAnonymousLong, int paramAnonymousInt)
      {
        AppMethodBeat.i(3491);
        WcwssNative.IWcWssWebSocketListener localIWcWssWebSocketListener = null;
        synchronized (WcwssNative.listenerlock)
        {
          if (WcwssNative.gMapCallbacks.containsKey(paramAnonymousString)) {
            localIWcWssWebSocketListener = (WcwssNative.IWcWssWebSocketListener)WcwssNative.gMapCallbacks.get(paramAnonymousString);
          }
          if (localIWcWssWebSocketListener != null)
          {
            localIWcWssWebSocketListener.onStateChange(paramAnonymousString, paramAnonymousLong, paramAnonymousInt);
            AppMethodBeat.o(3491);
            return;
          }
        }
        paramAnonymousString = WcwssNative.TAG;
        AppMethodBeat.o(3491);
      }
    };
    mWcWssReportListener = new IWcWssReportListener()
    {
      public final int getNetworkType()
      {
        AppMethodBeat.i(3493);
        synchronized (WcwssNative.lock)
        {
          if (WcwssNative.mCallerWcWssReportListener != null)
          {
            int i = WcwssNative.mCallerWcWssReportListener.getNetworkType();
            AppMethodBeat.o(3493);
            return i;
          }
          AppMethodBeat.o(3493);
          return -1;
        }
      }
      
      public final void onIdKeyStat(int[] paramAnonymousArrayOfInt1, int[] paramAnonymousArrayOfInt2, int[] paramAnonymousArrayOfInt3)
      {
        AppMethodBeat.i(3495);
        synchronized (WcwssNative.lock)
        {
          if (WcwssNative.mCallerWcWssReportListener != null) {
            WcwssNative.mCallerWcWssReportListener.onIdKeyStat(paramAnonymousArrayOfInt1, paramAnonymousArrayOfInt2, paramAnonymousArrayOfInt3);
          }
          AppMethodBeat.o(3495);
          return;
        }
      }
      
      public final void onKvStat(int paramAnonymousInt, String paramAnonymousString)
      {
        AppMethodBeat.i(3494);
        synchronized (WcwssNative.lock)
        {
          if (WcwssNative.mCallerWcWssReportListener != null) {
            WcwssNative.mCallerWcWssReportListener.onKvStat(paramAnonymousInt, paramAnonymousString);
          }
          AppMethodBeat.o(3494);
          return;
        }
      }
    };
    AppMethodBeat.o(3504);
  }
  
  private static native void destoryBindingWcwss(int paramInt);
  
  @Keep
  public static void destoryWcwss(String arg0)
  {
    AppMethodBeat.i(3497);
    destoryBindingWcwss(Integer.parseInt(???));
    int i = 0;
    synchronized (listenerlock)
    {
      gMapCallbacks.remove(???);
      if (gMapCallbacks.size() <= 0) {
        i = 1;
      }
      if (i == 0) {
        break label87;
      }
    }
    synchronized (lock)
    {
      mCallerWcWssReportListener = null;
      AppMethodBeat.o(3497);
      return;
      ??? = finally;
      AppMethodBeat.o(3497);
      throw ???;
    }
    label87:
    AppMethodBeat.o(3497);
  }
  
  @Keep
  public static void doOnRunningState(String paramString)
  {
    AppMethodBeat.i(3502);
    doOnRunningStateWcwss(paramString);
    AppMethodBeat.o(3502);
  }
  
  private static native void doOnRunningStateWcwss(String paramString);
  
  private static native int initBindingWcwss(long paramLong1, long paramLong2, long paramLong3);
  
  private static native int initCallBack(IWcWssWebSocketListener paramIWcWssWebSocketListener, IWcWssReportListener paramIWcWssReportListener);
  
  @Keep
  public static void initConfig(String paramString, HashMap<String, String> paramHashMap)
  {
    AppMethodBeat.i(3499);
    initConfigWcwss(paramString, paramHashMap);
    AppMethodBeat.o(3499);
  }
  
  private static native void initConfigWcwss(String paramString, HashMap<String, String> paramHashMap);
  
  @Keep
  public static void initConfigWhiteBlack(String paramString, ArrayList<String> paramArrayList1, ArrayList<String> paramArrayList2)
  {
    AppMethodBeat.i(3500);
    initConfigWhiteBlackList(paramString, paramArrayList1, paramArrayList2);
    AppMethodBeat.o(3500);
  }
  
  private static native void initConfigWhiteBlackList(String paramString, ArrayList<String> paramArrayList1, ArrayList<String> paramArrayList2);
  
  @Keep
  public static String initWcwss(long paramLong1, long paramLong2, long paramLong3)
  {
    AppMethodBeat.i(192981);
    int i = initBindingWcwss(paramLong1, paramLong2, paramLong3);
    AppMethodBeat.o(192981);
    return String.valueOf(i);
  }
  
  @Keep
  public static int setCallback(String paramString, IWcWssWebSocketListener paramIWcWssWebSocketListener, IWcWssReportListener arg2)
  {
    AppMethodBeat.i(3498);
    int i;
    if (paramString == null)
    {
      i = NEW_WCWSS_ERROR;
      AppMethodBeat.o(3498);
      return i;
    }
    synchronized (listenerlock)
    {
      if (gMapCallbacks.containsKey(paramString))
      {
        i = REPEAT_INIT_ERROR;
        AppMethodBeat.o(3498);
        return i;
      }
      synchronized (lock)
      {
        if (mCallerWcWssReportListener == null)
        {
          mCallerWcWssReportListener = ???;
          initCallBack(mWcWssWebSocketListener, mWcWssReportListener);
        }
      }
    }
    synchronized (listenerlock)
    {
      gMapCallbacks.put(paramString, paramIWcWssWebSocketListener);
      AppMethodBeat.o(3498);
      return 0;
      paramString = finally;
      AppMethodBeat.o(3498);
      throw paramString;
      paramString = finally;
      AppMethodBeat.o(3498);
      throw paramString;
    }
  }
  
  private static native void testBindingWcwss(int paramInt);
  
  @Keep
  public static void updateInterface(String paramString, long paramLong, int paramInt)
  {
    AppMethodBeat.i(3501);
    updateNativeInterface(paramString, paramLong, paramInt);
    AppMethodBeat.o(3501);
  }
  
  private static native void updateNativeInterface(String paramString, long paramLong, int paramInt);
  
  public void testBindWcwss(String paramString)
  {
    AppMethodBeat.i(3503);
    testBindingWcwss(Integer.parseInt(paramString));
    AppMethodBeat.o(3503);
  }
  
  @Keep
  public static abstract interface IWcWssReportListener
  {
    @Keep
    public abstract int getNetworkType();
    
    @Keep
    public abstract void onIdKeyStat(int[] paramArrayOfInt1, int[] paramArrayOfInt2, int[] paramArrayOfInt3);
    
    @Keep
    public abstract void onKvStat(int paramInt, String paramString);
  }
  
  @Keep
  public static abstract interface IWcWssWebSocketListener
  {
    @Keep
    public abstract int doCertificateVerify(String paramString1, long paramLong, String paramString2, byte[][] paramArrayOfByte);
    
    @Keep
    public abstract void onStateChange(String paramString, long paramLong, int paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.websocket.libwcwss.WcwssNative
 * JD-Core Version:    0.7.0.1
 */