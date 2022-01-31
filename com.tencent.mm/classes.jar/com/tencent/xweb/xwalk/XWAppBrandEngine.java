package com.tencent.xweb.xwalk;

import android.os.Handler;
import android.support.annotation.Keep;
import com.tencent.mm.compatible.util.k;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Timer;

public class XWAppBrandEngine
{
  public static XWAppBrandEngine.b xlC = null;
  private int bkn = 0;
  private HashMap<Integer, XWAppBrandEngine.a> bko = new HashMap();
  private Handler mHandler = new Handler();
  long mInstance = nativeCreated();
  private Timer mTimer = new Timer();
  private boolean xlA = false;
  public ArrayList<Runnable> xlB = new ArrayList();
  
  static
  {
    ClassLoader localClassLoader = XWAppBrandEngine.class.getClassLoader();
    k.b("mmv8", localClassLoader);
    k.b("jsengine", localClassLoader);
  }
  
  private native long nativeCreated();
  
  private native void notifyClearTimer(long paramLong, int paramInt);
  
  private native boolean notifyRunTimer(long paramLong, int paramInt);
  
  private native boolean removeJsInterface(long paramLong, String paramString);
  
  @Keep
  public static void reportException(String paramString1, String paramString2, long paramLong)
  {
    if (xlC != null) {}
  }
  
  native void addJsInterface(long paramLong, Object paramObject, String paramString);
  
  @Keep
  public void clearTimer(int paramInt)
  {
    if (!this.bko.containsKey(Integer.valueOf(paramInt))) {
      return;
    }
    ((XWAppBrandEngine.a)this.bko.get(Integer.valueOf(paramInt))).cancel();
    this.bko.remove(Integer.valueOf(paramInt));
  }
  
  native String evaluateJavascript(long paramLong, String paramString);
  
  native ByteBuffer getNativeBuffer(long paramLong, int paramInt);
  
  native int getNativeBufferId(long paramLong);
  
  native void nativeFinalize(long paramLong);
  
  @Keep
  public void onLog(int paramInt, String paramString) {}
  
  native void setNativeBuffer(long paramLong, int paramInt, ByteBuffer paramByteBuffer);
  
  @Keep
  public int setTimer(int paramInt, boolean paramBoolean)
  {
    int j = this.bkn + 1;
    this.bkn = j;
    XWAppBrandEngine.a locala = new XWAppBrandEngine.a(this, j, paramBoolean);
    this.bko.put(Integer.valueOf(j), locala);
    int i = paramInt;
    if (paramInt <= 0) {
      i = 1;
    }
    if (paramBoolean)
    {
      this.mTimer.schedule(locala, i, i);
      return j;
    }
    this.mTimer.schedule(locala, i);
    return j;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.xweb.xwalk.XWAppBrandEngine
 * JD-Core Version:    0.7.0.1
 */