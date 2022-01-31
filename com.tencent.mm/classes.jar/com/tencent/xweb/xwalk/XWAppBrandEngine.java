package com.tencent.xweb.xwalk;

import android.os.Handler;
import android.support.annotation.Keep;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.util.k;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Timer;

public class XWAppBrandEngine
{
  public static XWAppBrandEngine.b BJr;
  private int BJn;
  private HashMap<Integer, XWAppBrandEngine.a> BJo;
  private boolean BJp;
  public ArrayList<Runnable> BJq;
  private Handler mHandler;
  private long mInstance;
  private Timer mTimer;
  
  static
  {
    AppMethodBeat.i(4172);
    ClassLoader localClassLoader = XWAppBrandEngine.class.getClassLoader();
    k.a("mmv8", localClassLoader);
    k.a("jsengine", localClassLoader);
    BJr = null;
    AppMethodBeat.o(4172);
  }
  
  public XWAppBrandEngine()
  {
    AppMethodBeat.i(4168);
    this.mTimer = new Timer();
    this.BJn = 0;
    this.BJo = new HashMap();
    this.BJp = false;
    this.BJq = new ArrayList();
    this.mHandler = new Handler();
    this.mInstance = nativeCreated();
    AppMethodBeat.o(4168);
  }
  
  private native void addJsInterface(long paramLong, Object paramObject, String paramString);
  
  private native String evaluateJavascript(long paramLong, String paramString);
  
  private native ByteBuffer getNativeBuffer(long paramLong, int paramInt);
  
  private native int getNativeBufferId(long paramLong);
  
  private native long nativeCreated();
  
  private native void nativeFinalize(long paramLong);
  
  private native void notifyClearTimer(long paramLong, int paramInt);
  
  private native boolean notifyRunTimer(long paramLong, int paramInt);
  
  private native boolean removeJsInterface(long paramLong, String paramString);
  
  @Keep
  public static void reportException(String paramString1, String paramString2, long paramLong)
  {
    if (BJr != null) {}
  }
  
  private native void setNativeBuffer(long paramLong, int paramInt, ByteBuffer paramByteBuffer);
  
  @Keep
  public void clearTimer(int paramInt)
  {
    AppMethodBeat.i(4170);
    if (!this.BJo.containsKey(Integer.valueOf(paramInt)))
    {
      AppMethodBeat.o(4170);
      return;
    }
    ((XWAppBrandEngine.a)this.BJo.get(Integer.valueOf(paramInt))).cancel();
    this.BJo.remove(Integer.valueOf(paramInt));
    AppMethodBeat.o(4170);
  }
  
  @Keep
  public void onLog(int paramInt, String paramString) {}
  
  @Keep
  public int setTimer(int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(4169);
    int j = this.BJn + 1;
    this.BJn = j;
    XWAppBrandEngine.a locala = new XWAppBrandEngine.a(this, j, paramBoolean);
    this.BJo.put(Integer.valueOf(j), locala);
    int i = paramInt;
    if (paramInt <= 0) {
      i = 1;
    }
    if (paramBoolean) {
      this.mTimer.schedule(locala, i, i);
    }
    for (;;)
    {
      AppMethodBeat.o(4169);
      return j;
      this.mTimer.schedule(locala, i);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.xweb.xwalk.XWAppBrandEngine
 * JD-Core Version:    0.7.0.1
 */