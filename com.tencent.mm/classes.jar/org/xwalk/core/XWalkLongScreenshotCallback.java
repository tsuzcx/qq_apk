package org.xwalk.core;

import android.graphics.Bitmap;
import com.tencent.xweb.q;
import java.io.File;

public abstract class XWalkLongScreenshotCallback
  implements q
{
  private Object bridge;
  private XWalkCoreWrapper coreWrapper;
  private ReflectMethod getCacheFileDirMethod = new ReflectMethod(null, "", new Class[0]);
  private ReflectMethod getMaxHeightSupportedMethod = new ReflectMethod(null, "", new Class[0]);
  private ReflectMethod getResultFileDirMethod = new ReflectMethod(null, "", new Class[0]);
  private ReflectMethod onLongScreenshotFinishedIntStringMethod = new ReflectMethod(null, "", new Class[0]);
  private ReflectMethod overrideScreenshotBitmapMethod = new ReflectMethod(null, "", new Class[0]);
  
  public XWalkLongScreenshotCallback()
  {
    reflectionInit();
  }
  
  protected Object getBridge()
  {
    return this.bridge;
  }
  
  public File getCacheFileDir()
  {
    try
    {
      File localFile = (File)this.getCacheFileDirMethod.invoke(new Object[0]);
      return localFile;
    }
    catch (RuntimeException localRuntimeException)
    {
      if (this.coreWrapper == null) {
        throw new RuntimeException("Crosswalk's APIs are not ready yet");
      }
      XWalkCoreWrapper.handleRuntimeError(localRuntimeException);
    }
    return null;
  }
  
  public int getMaxHeightSupported()
  {
    try
    {
      int i = ((Integer)this.getMaxHeightSupportedMethod.invoke(new Object[0])).intValue();
      return i;
    }
    catch (RuntimeException localRuntimeException)
    {
      if (this.coreWrapper == null) {
        throw new RuntimeException("Crosswalk's APIs are not ready yet");
      }
      XWalkCoreWrapper.handleRuntimeError(localRuntimeException);
    }
    return 0;
  }
  
  public File getResultFileDir()
  {
    try
    {
      File localFile = (File)this.getResultFileDirMethod.invoke(new Object[0]);
      return localFile;
    }
    catch (RuntimeException localRuntimeException)
    {
      if (this.coreWrapper == null) {
        throw new RuntimeException("Crosswalk's APIs are not ready yet");
      }
      XWalkCoreWrapper.handleRuntimeError(localRuntimeException);
    }
    return null;
  }
  
  public void onLongScreenshotFinished(int paramInt, String paramString)
  {
    try
    {
      this.onLongScreenshotFinishedIntStringMethod.invoke(new Object[] { Integer.valueOf(paramInt), paramString });
      return;
    }
    catch (RuntimeException paramString)
    {
      if (this.coreWrapper == null) {
        throw new RuntimeException("Crosswalk's APIs are not ready yet");
      }
      XWalkCoreWrapper.handleRuntimeError(paramString);
    }
  }
  
  public Bitmap overrideScreenshot(Bitmap paramBitmap)
  {
    try
    {
      paramBitmap = (Bitmap)this.overrideScreenshotBitmapMethod.invoke(new Object[] { paramBitmap });
      return paramBitmap;
    }
    catch (RuntimeException paramBitmap)
    {
      if (this.coreWrapper == null) {
        throw new RuntimeException("Crosswalk's APIs are not ready yet");
      }
      XWalkCoreWrapper.handleRuntimeError(paramBitmap);
    }
    return null;
  }
  
  void reflectionInit()
  {
    this.coreWrapper = XWalkCoreWrapper.getInstance();
    if (this.coreWrapper == null) {
      XWalkCoreWrapper.reserveReflectObject(this);
    }
    do
    {
      return;
      localObject = this.coreWrapper.getBridgeClass("XWalkLongScreenshotCallbackBridge");
    } while (localObject == null);
    Object localObject = new ReflectConstructor((Class)localObject, new Class[] { Object.class });
    try
    {
      this.bridge = ((ReflectConstructor)localObject).newInstance(new Object[] { this });
      this.onLongScreenshotFinishedIntStringMethod.init(this.bridge, null, "onLongScreenshotFinishedSuper", new Class[] { Integer.TYPE, String.class });
      this.getCacheFileDirMethod.init(this.bridge, null, "getCacheFileDirMethodSuper", new Class[0]);
      this.getResultFileDirMethod.init(this.bridge, null, "getResultFileDirMethodSuper", new Class[0]);
      this.overrideScreenshotBitmapMethod.init(this.bridge, null, "overrideScreenshotBitmapMethodSuper", new Class[] { Bitmap.class });
      this.getMaxHeightSupportedMethod.init(this.bridge, null, "getMaxHeightSupported", new Class[0]);
      return;
    }
    catch (UnsupportedOperationException localUnsupportedOperationException) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     org.xwalk.core.XWalkLongScreenshotCallback
 * JD-Core Version:    0.7.0.1
 */