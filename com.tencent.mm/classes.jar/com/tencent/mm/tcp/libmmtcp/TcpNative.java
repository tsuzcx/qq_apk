package com.tencent.mm.tcp.libmmtcp;

import androidx.annotation.Keep;
import com.tencent.matrix.trace.core.AppMethodBeat;

@Keep
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
  
  @Keep
  public TcpNative(long paramLong1, long paramLong2, long paramLong3)
  {
    AppMethodBeat.i(195574);
    this.mNativeInst = 0L;
    this.initCallBackFlag = false;
    new StringBuilder("TcpNative isolate_ptr:").append(paramLong1).append(",context_ptr:").append(paramLong2).append(",uvloop_ptr:").append(paramLong3);
    this.mNativeInst = initBindingTcp(paramLong1, paramLong2, paramLong3);
    AppMethodBeat.o(195574);
  }
  
  private native void destoryBindingTcp(long paramLong);
  
  private native long initBindingTcp(long paramLong1, long paramLong2, long paramLong3);
  
  private native int initCallBack(long paramLong, NativeCallBackInterface paramNativeCallBackInterface);
  
  private native void serviceReceive(String paramString1, int paramInt, String paramString2);
  
  private native void testBindingTcp(long paramLong);
  
  private native void testBindingTcp2(long paramLong);
  
  private native void testBindingTcpServer(long paramLong);
  
  private native void updateNativeInterface(long paramLong1, long paramLong2);
  
  @Keep
  public int InitCallBack(final NativeCallBackInterface paramNativeCallBackInterface)
  {
    AppMethodBeat.i(195578);
    if (this.mNativeInst == -1L)
    {
      i = NEW_TCP_ERROR;
      AppMethodBeat.o(195578);
      return i;
    }
    if (!this.initCallBackFlag)
    {
      i = initCallBack(this.mNativeInst, new NativeCallBackInterface()
      {
        @Keep
        public void onCallBack(long paramAnonymousLong, String paramAnonymousString)
        {
          AppMethodBeat.i(195565);
          paramNativeCallBackInterface.onCallBack(paramAnonymousLong, paramAnonymousString);
          AppMethodBeat.o(195565);
        }
      });
      if (i == 0)
      {
        this.initCallBackFlag = true;
        AppMethodBeat.o(195578);
        return i;
      }
      i = INIT_ERROR;
      AppMethodBeat.o(195578);
      return i;
    }
    int i = REPEAT_INIT_ERROR;
    AppMethodBeat.o(195578);
    return i;
  }
  
  @Keep
  public void destoryTcp()
  {
    AppMethodBeat.i(195575);
    if (this.mNativeInst == -1L)
    {
      AppMethodBeat.o(195575);
      return;
    }
    if (this.initCallBackFlag)
    {
      this.initCallBackFlag = false;
      destoryBindingTcp(this.mNativeInst);
      this.mNativeInst = -1L;
    }
    AppMethodBeat.o(195575);
  }
  
  public void testBind()
  {
    AppMethodBeat.i(195582);
    if (this.mNativeInst == -1L)
    {
      AppMethodBeat.o(195582);
      return;
    }
    testBindingTcp(this.mNativeInst);
    AppMethodBeat.o(195582);
  }
  
  public void testBind2()
  {
    AppMethodBeat.i(195588);
    if (this.mNativeInst == -1L)
    {
      AppMethodBeat.o(195588);
      return;
    }
    testBindingTcp(this.mNativeInst);
    AppMethodBeat.o(195588);
  }
  
  public void testBindServer()
  {
    AppMethodBeat.i(195585);
    if (this.mNativeInst == -1L)
    {
      AppMethodBeat.o(195585);
      return;
    }
    testBindingTcpServer(this.mNativeInst);
    AppMethodBeat.o(195585);
  }
  
  public void testServiceReceive(String paramString1, int paramInt, String paramString2)
  {
    AppMethodBeat.i(195590);
    if (this.mNativeInst == -1L)
    {
      AppMethodBeat.o(195590);
      return;
    }
    serviceReceive(paramString1, paramInt, paramString2);
    AppMethodBeat.o(195590);
  }
  
  @Keep
  public void update(long paramLong)
  {
    AppMethodBeat.i(195581);
    if (this.mNativeInst == -1L)
    {
      AppMethodBeat.o(195581);
      return;
    }
    updateNativeInterface(this.mNativeInst, paramLong);
    AppMethodBeat.o(195581);
  }
  
  @Keep
  public static abstract interface NativeCallBackInterface
  {
    @Keep
    public abstract void onCallBack(long paramLong, String paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.tcp.libmmtcp.TcpNative
 * JD-Core Version:    0.7.0.1
 */