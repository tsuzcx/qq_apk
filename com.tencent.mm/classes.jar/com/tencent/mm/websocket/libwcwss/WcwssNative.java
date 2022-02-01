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
  private volatile boolean initCallBackFlag = false;
  private volatile long mNativeInst = 0L;
  private volatile String mStrNativeInst = "0";
  
  static
  {
    AppMethodBeat.i(3504);
    TAG = "WcwssNative";
    NEW_WCWSS_ERROR = -1000;
    REPEAT_INIT_ERROR = -1001;
    INIT_ERROR = -1002;
    AppMethodBeat.o(3504);
  }
  
  private native void destoryBindingWcwss(long paramLong);
  
  private native void doOnRunningStateWcwss(String paramString, long paramLong);
  
  private native long initBindingWcwss(long paramLong1, long paramLong2, long paramLong3);
  
  private native int initCallBack(long paramLong, IWcWssWebSocketListener paramIWcWssWebSocketListener, IWcWssReportListener paramIWcWssReportListener);
  
  private native void initConfigWcwss(String paramString, long paramLong, HashMap<String, String> paramHashMap);
  
  private native void initConfigWhiteBlackList(String paramString, long paramLong, ArrayList<String> paramArrayList1, ArrayList<String> paramArrayList2);
  
  private native void testBindingWcwss(long paramLong);
  
  private native void updateNativeInterface(String paramString, long paramLong1, long paramLong2, int paramInt);
  
  @Keep
  public void destoryWcwss()
  {
    AppMethodBeat.i(219376);
    new StringBuilder("WcwssNative MMWcWss destoryWcwss mNativeInst:").append(this.mNativeInst);
    if (this.mNativeInst <= 0L)
    {
      AppMethodBeat.o(219376);
      return;
    }
    if (this.initCallBackFlag)
    {
      this.initCallBackFlag = false;
      destoryBindingWcwss(this.mNativeInst);
      this.mNativeInst = -1L;
    }
    AppMethodBeat.o(219376);
  }
  
  @Keep
  public void doOnRunningState()
  {
    AppMethodBeat.i(219381);
    doOnRunningStateWcwss(this.mStrNativeInst, this.mNativeInst);
    AppMethodBeat.o(219381);
  }
  
  @Keep
  public void initConfig(HashMap<String, String> paramHashMap)
  {
    AppMethodBeat.i(219378);
    initConfigWcwss(this.mStrNativeInst, this.mNativeInst, paramHashMap);
    AppMethodBeat.o(219378);
  }
  
  @Keep
  public void initConfigWhiteBlack(ArrayList<String> paramArrayList1, ArrayList<String> paramArrayList2)
  {
    AppMethodBeat.i(219379);
    initConfigWhiteBlackList(this.mStrNativeInst, this.mNativeInst, paramArrayList1, paramArrayList2);
    AppMethodBeat.o(219379);
  }
  
  @Keep
  public String initWcwss(long paramLong1, long paramLong2, long paramLong3)
  {
    AppMethodBeat.i(219375);
    this.mNativeInst = initBindingWcwss(paramLong1, paramLong2, paramLong3);
    this.mStrNativeInst = String.valueOf(this.mNativeInst);
    new StringBuilder("WcwssNative MMWcWss initWcwss str_contextId:").append(this.mStrNativeInst);
    String str = this.mStrNativeInst;
    AppMethodBeat.o(219375);
    return str;
  }
  
  @Keep
  public int setCallback(IWcWssWebSocketListener paramIWcWssWebSocketListener, IWcWssReportListener paramIWcWssReportListener)
  {
    AppMethodBeat.i(219377);
    if (this.mNativeInst <= 0L)
    {
      i = NEW_WCWSS_ERROR;
      AppMethodBeat.o(219377);
      return i;
    }
    if (!this.initCallBackFlag)
    {
      i = initCallBack(this.mNativeInst, paramIWcWssWebSocketListener, paramIWcWssReportListener);
      if (i == 0)
      {
        this.initCallBackFlag = true;
        AppMethodBeat.o(219377);
        return i;
      }
      i = INIT_ERROR;
      AppMethodBeat.o(219377);
      return i;
    }
    int i = REPEAT_INIT_ERROR;
    AppMethodBeat.o(219377);
    return i;
  }
  
  public void testBindWcwss(String paramString)
  {
    AppMethodBeat.i(3503);
    testBindingWcwss(Long.parseLong(paramString));
    AppMethodBeat.o(3503);
  }
  
  @Keep
  public void updateInterface(long paramLong, int paramInt)
  {
    AppMethodBeat.i(219380);
    updateNativeInterface(this.mStrNativeInst, this.mNativeInst, paramLong, paramInt);
    AppMethodBeat.o(219380);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.websocket.libwcwss.WcwssNative
 * JD-Core Version:    0.7.0.1
 */