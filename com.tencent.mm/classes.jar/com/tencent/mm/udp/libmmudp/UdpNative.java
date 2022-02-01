package com.tencent.mm.udp.libmmudp;

import android.support.annotation.Keep;
import com.tencent.matrix.trace.core.AppMethodBeat;

@Keep
public class UdpNative
{
  public static int INIT_ERROR = -1002;
  public static int NEW_UDP_ERROR;
  public static int REPEAT_INIT_ERROR;
  public static int SEND_BUFFER_ERROR = -1003;
  public static String TAG = "UdpNative";
  private boolean initCallBackFlag;
  volatile long mNativeInst;
  
  static
  {
    NEW_UDP_ERROR = -1000;
    REPEAT_INIT_ERROR = -1001;
  }
  
  @Keep
  public UdpNative(long paramLong1, long paramLong2, long paramLong3)
  {
    AppMethodBeat.i(187808);
    this.mNativeInst = 0L;
    this.initCallBackFlag = false;
    new StringBuilder("UdpNative isolate_ptr:").append(paramLong1).append(",context_ptr:").append(paramLong2).append(",uvloop_ptr:").append(paramLong3);
    this.mNativeInst = initBindingUdp(paramLong1, paramLong2, paramLong3);
    AppMethodBeat.o(187808);
  }
  
  private native void destoryBindingUdp(long paramLong);
  
  private native long initBindingUdp(long paramLong1, long paramLong2, long paramLong3);
  
  private native int initCallBack(long paramLong, NativeCallBackInterface paramNativeCallBackInterface);
  
  private native void serviceReceive(String paramString1, int paramInt, String paramString2);
  
  private native void testBindingUdp(long paramLong);
  
  private native void testBindingUdp2(long paramLong);
  
  private native void updateNativeInterface(long paramLong1, long paramLong2);
  
  @Keep
  public int InitCallBack(final NativeCallBackInterface paramNativeCallBackInterface)
  {
    AppMethodBeat.i(62491);
    if (this.mNativeInst == -1L)
    {
      i = NEW_UDP_ERROR;
      AppMethodBeat.o(62491);
      return i;
    }
    if (!this.initCallBackFlag)
    {
      i = initCallBack(this.mNativeInst, new NativeCallBackInterface()
      {
        @Keep
        public void onCallBack(long paramAnonymousLong, String paramAnonymousString)
        {
          AppMethodBeat.i(62488);
          paramNativeCallBackInterface.onCallBack(paramAnonymousLong, paramAnonymousString);
          AppMethodBeat.o(62488);
        }
      });
      if (i == 0)
      {
        this.initCallBackFlag = true;
        AppMethodBeat.o(62491);
        return i;
      }
      i = INIT_ERROR;
      AppMethodBeat.o(62491);
      return i;
    }
    int i = REPEAT_INIT_ERROR;
    AppMethodBeat.o(62491);
    return i;
  }
  
  @Keep
  public void destoryUdp()
  {
    AppMethodBeat.i(62490);
    if (this.mNativeInst == -1L)
    {
      AppMethodBeat.o(62490);
      return;
    }
    if (this.initCallBackFlag)
    {
      this.initCallBackFlag = false;
      destoryBindingUdp(this.mNativeInst);
      this.mNativeInst = -1L;
    }
    AppMethodBeat.o(62490);
  }
  
  public void testBind()
  {
    AppMethodBeat.i(62493);
    if (this.mNativeInst == -1L)
    {
      AppMethodBeat.o(62493);
      return;
    }
    testBindingUdp(this.mNativeInst);
    AppMethodBeat.o(62493);
  }
  
  public void testBind2()
  {
    AppMethodBeat.i(62494);
    if (this.mNativeInst == -1L)
    {
      AppMethodBeat.o(62494);
      return;
    }
    testBindingUdp2(this.mNativeInst);
    AppMethodBeat.o(62494);
  }
  
  public void testServiceReceive(String paramString1, int paramInt, String paramString2)
  {
    AppMethodBeat.i(62495);
    if (this.mNativeInst == -1L)
    {
      AppMethodBeat.o(62495);
      return;
    }
    serviceReceive(paramString1, paramInt, paramString2);
    AppMethodBeat.o(62495);
  }
  
  @Keep
  public void update(long paramLong)
  {
    AppMethodBeat.i(62492);
    if (this.mNativeInst == -1L)
    {
      AppMethodBeat.o(62492);
      return;
    }
    updateNativeInterface(this.mNativeInst, paramLong);
    AppMethodBeat.o(62492);
  }
  
  @Keep
  public static abstract interface NativeCallBackInterface
  {
    @Keep
    public abstract void onCallBack(long paramLong, String paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.udp.libmmudp.UdpNative
 * JD-Core Version:    0.7.0.1
 */