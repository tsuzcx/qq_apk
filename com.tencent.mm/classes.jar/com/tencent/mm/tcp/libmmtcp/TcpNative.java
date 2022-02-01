package com.tencent.mm.tcp.libmmtcp;

import com.tencent.matrix.trace.core.AppMethodBeat;

public class TcpNative
{
  public static int INIT_ERROR = -1002;
  public static int NEW_TCP_ERROR;
  public static int REPEAT_INIT_ERROR;
  public static int SEND_BUFFER_ERROR = -1003;
  public static String TAG = "TcpNative";
  private boolean initCallBackFlag;
  volatile long mNativeInst;
  
  static
  {
    NEW_TCP_ERROR = -1000;
    REPEAT_INIT_ERROR = -1001;
  }
  
  public TcpNative(long paramLong1, long paramLong2, long paramLong3)
  {
    AppMethodBeat.i(233727);
    this.mNativeInst = 0L;
    this.initCallBackFlag = false;
    new StringBuilder("TcpNative isolate_ptr:").append(paramLong1).append(",context_ptr:").append(paramLong2).append(",uvloop_ptr:").append(paramLong3);
    this.mNativeInst = initBindingTcp(paramLong1, paramLong2, paramLong3);
    AppMethodBeat.o(233727);
  }
  
  private native void destoryBindingTcp(long paramLong);
  
  private native long initBindingTcp(long paramLong1, long paramLong2, long paramLong3);
  
  private native int initCallBack(long paramLong, NativeCallBackInterface paramNativeCallBackInterface);
  
  private native void serviceReceive(String paramString1, int paramInt, String paramString2);
  
  private native void testBindingTcp(long paramLong);
  
  private native void testBindingTcp2(long paramLong);
  
  private native void testBindingTcpServer(long paramLong);
  
  private native void updateNativeInterface(long paramLong1, long paramLong2);
  
  public int InitCallBack(final NativeCallBackInterface paramNativeCallBackInterface)
  {
    AppMethodBeat.i(233737);
    if (this.mNativeInst == -1L)
    {
      i = NEW_TCP_ERROR;
      AppMethodBeat.o(233737);
      return i;
    }
    if (!this.initCallBackFlag)
    {
      i = initCallBack(this.mNativeInst, new NativeCallBackInterface()
      {
        public void onCallBack(long paramAnonymousLong, String paramAnonymousString)
        {
          AppMethodBeat.i(233704);
          paramNativeCallBackInterface.onCallBack(paramAnonymousLong, paramAnonymousString);
          AppMethodBeat.o(233704);
        }
      });
      if (i == 0)
      {
        this.initCallBackFlag = true;
        AppMethodBeat.o(233737);
        return i;
      }
      i = INIT_ERROR;
      AppMethodBeat.o(233737);
      return i;
    }
    int i = REPEAT_INIT_ERROR;
    AppMethodBeat.o(233737);
    return i;
  }
  
  public void destoryTcp()
  {
    AppMethodBeat.i(233733);
    if (this.mNativeInst == -1L)
    {
      AppMethodBeat.o(233733);
      return;
    }
    if (this.initCallBackFlag)
    {
      this.initCallBackFlag = false;
      destoryBindingTcp(this.mNativeInst);
      this.mNativeInst = -1L;
    }
    AppMethodBeat.o(233733);
  }
  
  public void testBind()
  {
    AppMethodBeat.i(233744);
    if (this.mNativeInst == -1L)
    {
      AppMethodBeat.o(233744);
      return;
    }
    testBindingTcp(this.mNativeInst);
    AppMethodBeat.o(233744);
  }
  
  public void testBind2()
  {
    AppMethodBeat.i(233749);
    if (this.mNativeInst == -1L)
    {
      AppMethodBeat.o(233749);
      return;
    }
    testBindingTcp(this.mNativeInst);
    AppMethodBeat.o(233749);
  }
  
  public void testBindServer()
  {
    AppMethodBeat.i(233747);
    if (this.mNativeInst == -1L)
    {
      AppMethodBeat.o(233747);
      return;
    }
    testBindingTcpServer(this.mNativeInst);
    AppMethodBeat.o(233747);
  }
  
  public void testServiceReceive(String paramString1, int paramInt, String paramString2)
  {
    AppMethodBeat.i(233753);
    if (this.mNativeInst == -1L)
    {
      AppMethodBeat.o(233753);
      return;
    }
    serviceReceive(paramString1, paramInt, paramString2);
    AppMethodBeat.o(233753);
  }
  
  public void update(long paramLong)
  {
    AppMethodBeat.i(233741);
    if (this.mNativeInst == -1L)
    {
      AppMethodBeat.o(233741);
      return;
    }
    updateNativeInterface(this.mNativeInst, paramLong);
    AppMethodBeat.o(233741);
  }
  
  public static abstract interface NativeCallBackInterface
  {
    public abstract void onCallBack(long paramLong, String paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.tcp.libmmtcp.TcpNative
 * JD-Core Version:    0.7.0.1
 */