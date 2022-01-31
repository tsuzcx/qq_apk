package com.tencent.mm.udp.libmmudp;

import android.support.annotation.Keep;
import com.tencent.matrix.trace.core.AppMethodBeat;

@Keep
public class UdpNative
{
  public static int INIT_ERROR = -1002;
  public static int NEW_UDP_ERROR = -1000;
  public static int REPEAT_INIT_ERROR = -1001;
  public static int SEND_BUFFER_ERROR = -1003;
  private boolean initCallBackFlag;
  volatile long mNativeInst;
  
  @Keep
  public UdpNative(long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(152194);
    this.mNativeInst = 0L;
    this.initCallBackFlag = false;
    this.mNativeInst = initBindingUdp(paramLong1, paramLong2);
    AppMethodBeat.o(152194);
  }
  
  private native void destoryBindingUdp(long paramLong);
  
  private native long initBindingUdp(long paramLong1, long paramLong2);
  
  private native int initCallBack(long paramLong, UdpNative.NativeCallBackInterface paramNativeCallBackInterface);
  
  private native void serviceReceive(String paramString, int paramInt);
  
  private native void testBindingUdp(long paramLong);
  
  private native void testBindingUdp2(long paramLong);
  
  private native void updateNativeInterface(long paramLong);
  
  @Keep
  public int InitCallBack(UdpNative.NativeCallBackInterface paramNativeCallBackInterface)
  {
    AppMethodBeat.i(96566);
    if (this.mNativeInst == -1L)
    {
      i = NEW_UDP_ERROR;
      AppMethodBeat.o(96566);
      return i;
    }
    if (!this.initCallBackFlag)
    {
      i = initCallBack(this.mNativeInst, new UdpNative.1(this, paramNativeCallBackInterface));
      if (i == 0)
      {
        this.initCallBackFlag = true;
        AppMethodBeat.o(96566);
        return i;
      }
      i = INIT_ERROR;
      AppMethodBeat.o(96566);
      return i;
    }
    int i = REPEAT_INIT_ERROR;
    AppMethodBeat.o(96566);
    return i;
  }
  
  @Keep
  public void destoryUdp()
  {
    AppMethodBeat.i(96564);
    if (this.mNativeInst == -1L)
    {
      AppMethodBeat.o(96564);
      return;
    }
    if (this.initCallBackFlag)
    {
      this.initCallBackFlag = false;
      destoryBindingUdp(this.mNativeInst);
      this.mNativeInst = -1L;
    }
    AppMethodBeat.o(96564);
  }
  
  public void testBind()
  {
    AppMethodBeat.i(152196);
    if (this.mNativeInst == -1L)
    {
      AppMethodBeat.o(152196);
      return;
    }
    testBindingUdp(this.mNativeInst);
    AppMethodBeat.o(152196);
  }
  
  public void testBind2()
  {
    AppMethodBeat.i(152197);
    if (this.mNativeInst == -1L)
    {
      AppMethodBeat.o(152197);
      return;
    }
    testBindingUdp2(this.mNativeInst);
    AppMethodBeat.o(152197);
  }
  
  @Keep
  public void update()
  {
    AppMethodBeat.i(152195);
    if (this.mNativeInst == -1L)
    {
      AppMethodBeat.o(152195);
      return;
    }
    updateNativeInterface(this.mNativeInst);
    AppMethodBeat.o(152195);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.udp.libmmudp.UdpNative
 * JD-Core Version:    0.7.0.1
 */