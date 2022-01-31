package com.tencent.mm.ui.base;

import android.annotation.TargetApi;
import android.app.ActivityManager;
import android.content.Context;
import android.graphics.SurfaceTexture;
import android.graphics.SurfaceTexture.OnFrameAvailableListener;
import android.os.Environment;
import android.os.StatFs;
import android.util.Base64;
import android.util.StringBuilderPrinter;
import com.tencent.mm.sdk.a.b;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.d;
import com.tencent.mm.sdk.platformtools.y;
import java.io.File;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

@TargetApi(16)
final class r
  extends SurfaceTexture
{
  public SurfaceTexture mSurfaceTexture = null;
  
  public r()
  {
    super(0);
  }
  
  private static String Jb()
  {
    StringBuilder localStringBuilder = new StringBuilder(256);
    StringBuilderPrinter localStringBuilderPrinter = new StringBuilderPrinter(localStringBuilder);
    Object localObject2 = ae.getContext();
    localStringBuilderPrinter.println("#accinfo.revision=" + d.REV);
    localStringBuilderPrinter.println("#accinfo.build=" + d.TIME + ":" + d.HOSTNAME + ":" + com.tencent.mm.sdk.platformtools.e.bvj);
    Object localObject3 = new StringBuilder("#accinfo.env=");
    Object localObject1;
    if (b.foreground) {
      localObject1 = "f";
    }
    for (;;)
    {
      localStringBuilderPrinter.println((String)localObject1 + ":" + Thread.currentThread().getName() + ":" + b.udL);
      try
      {
        localObject1 = Environment.getDataDirectory();
        localObject3 = new StatFs(((File)localObject1).getPath());
        StatFs localStatFs = new StatFs(com.tencent.mm.compatible.util.e.bkF);
        localObject1 = String.format("%dMB %s:%d:%d:%d %s:%d:%d:%d", new Object[] { Integer.valueOf(((ActivityManager)((Context)localObject2).getSystemService("activity")).getMemoryClass()), ((File)localObject1).getAbsolutePath(), Integer.valueOf(((StatFs)localObject3).getBlockSize()), Integer.valueOf(((StatFs)localObject3).getBlockCount()), Integer.valueOf(((StatFs)localObject3).getAvailableBlocks()), com.tencent.mm.compatible.util.e.bkF, Integer.valueOf(localStatFs.getBlockSize()), Integer.valueOf(localStatFs.getBlockCount()), Integer.valueOf(localStatFs.getAvailableBlocks()) });
        localStringBuilderPrinter.println("#accinfo.data=" + (String)localObject1);
        localObject1 = new Date();
        localObject2 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSSZ", Locale.getDefault());
        localStringBuilderPrinter.println("#accinfo.crashTime=" + ((SimpleDateFormat)localObject2).format((Date)localObject1));
        localStringBuilderPrinter.println("#crashContent=");
        return localStringBuilder.toString();
        localObject1 = "b";
      }
      catch (Exception localException)
      {
        for (;;)
        {
          y.e("MicroMsg.MMSurfaceTextureWrap", "check data size failed :%s", new Object[] { localException.getMessage() });
          String str = "";
        }
      }
    }
  }
  
  public final void attachToGLContext(int paramInt)
  {
    y.i("MicroMsg.MMSurfaceTextureWrap", "detect texture problem, attachToGLContext");
    this.mSurfaceTexture.attachToGLContext(paramInt);
  }
  
  public final void detachFromGLContext()
  {
    y.i("MicroMsg.MMSurfaceTextureWrap", "detect texture problem, detachFromGLContext");
    try
    {
      this.mSurfaceTexture.detachFromGLContext();
      bool = false;
    }
    catch (Exception localException1)
    {
      for (;;)
      {
        try
        {
          Object localObject1 = SurfaceTexture.class.getDeclaredMethod("nativeDetachFromGLContext", new Class[0]);
          ((Method)localObject1).setAccessible(true);
          int i = ((Integer)((Method)localObject1).invoke(this.mSurfaceTexture, new Object[0])).intValue();
          localObject1 = Jb() + " detect texture problem error code = " + i + ", detach = true, and error = " + bool;
          b.t(Base64.encodeToString(((String)localObject1).getBytes(), 2), "DetachFromGLContext");
          y.w("MicroMsg.MMSurfaceTextureWrap", (String)localObject1);
          y.i("MicroMsg.MMSurfaceTextureWrap", "detect texture problem, err %s hasDetach %s hasError %s", new Object[] { Integer.valueOf(i), Boolean.valueOf(true), Boolean.valueOf(bool) });
          return;
        }
        catch (IllegalArgumentException localIllegalArgumentException)
        {
          y.printErrStackTrace("MicroMsg.MMSurfaceTextureWrap", localIllegalArgumentException, "%s", new Object[] { "detect texture problem, IllegalArgumentException" });
          String str1;
          return;
        }
        catch (IllegalAccessException localIllegalAccessException)
        {
          y.printErrStackTrace("MicroMsg.MMSurfaceTextureWrap", localIllegalAccessException, "%s", new Object[] { "detect texture problem, IllegalAccessException" });
          String str2;
          return;
        }
        catch (InvocationTargetException localInvocationTargetException)
        {
          y.printErrStackTrace("MicroMsg.MMSurfaceTextureWrap", localInvocationTargetException, "%s", new Object[] { "detect texture problem, InvocationTargetException" });
          String str3;
          return;
        }
        catch (NoSuchMethodException localNoSuchMethodException)
        {
          y.printErrStackTrace("MicroMsg.MMSurfaceTextureWrap", localNoSuchMethodException, "%s", new Object[] { "detect texture problem, NoSuchMethodException" });
          String str4;
          return;
        }
        catch (Exception localException2)
        {
          y.printErrStackTrace("MicroMsg.MMSurfaceTextureWrap", localException2, "%s", new Object[] { "detect texture problem, Exception" });
          String str5;
          return;
        }
        finally
        {
          boolean bool;
          String str6 = Jb() + " detect texture problem error code = 0, detach = false, and error = " + bool;
          b.t(Base64.encodeToString(str6.getBytes(), 2), "DetachFromGLContext");
          y.w("MicroMsg.MMSurfaceTextureWrap", str6);
          y.i("MicroMsg.MMSurfaceTextureWrap", "detect texture problem, err %s hasDetach %s hasError %s", new Object[] { Integer.valueOf(0), Boolean.valueOf(false), Boolean.valueOf(bool) });
        }
        localException1 = localException1;
        y.printErrStackTrace("MicroMsg.MMSurfaceTextureWrap", localException1, "%s", new Object[] { "detect texture problem, RuntimeException detachFromGLContext" });
        bool = true;
      }
    }
    if (!bool) {}
  }
  
  public final boolean equals(Object paramObject)
  {
    return this.mSurfaceTexture.equals(paramObject);
  }
  
  public final long getTimestamp()
  {
    y.i("MicroMsg.MMSurfaceTextureWrap", "detect texture problem, getTimestamp");
    return this.mSurfaceTexture.getTimestamp();
  }
  
  public final void getTransformMatrix(float[] paramArrayOfFloat)
  {
    y.i("MicroMsg.MMSurfaceTextureWrap", "detect texture problem, getTransformMatrix");
    this.mSurfaceTexture.getTransformMatrix(paramArrayOfFloat);
  }
  
  public final int hashCode()
  {
    return this.mSurfaceTexture.hashCode();
  }
  
  public final void release()
  {
    super.release();
    y.i("MicroMsg.MMSurfaceTextureWrap", "detect texture problem, release");
    this.mSurfaceTexture.release();
  }
  
  @TargetApi(19)
  public final void releaseTexImage()
  {
    y.i("MicroMsg.MMSurfaceTextureWrap", "detect texture problem, releaseTexImage");
    this.mSurfaceTexture.releaseTexImage();
  }
  
  public final void setDefaultBufferSize(int paramInt1, int paramInt2)
  {
    y.i("MicroMsg.MMSurfaceTextureWrap", "detect texture problem, setDefaultBufferSize");
    this.mSurfaceTexture.setDefaultBufferSize(paramInt1, paramInt2);
  }
  
  public final void setOnFrameAvailableListener(SurfaceTexture.OnFrameAvailableListener paramOnFrameAvailableListener)
  {
    y.i("MicroMsg.MMSurfaceTextureWrap", "detect texture problem, setOnFrameAvailableListener");
    this.mSurfaceTexture.setOnFrameAvailableListener(paramOnFrameAvailableListener);
  }
  
  public final String toString()
  {
    return this.mSurfaceTexture.toString();
  }
  
  public final void updateTexImage()
  {
    y.i("MicroMsg.MMSurfaceTextureWrap", "detect texture problem, updateTexImage");
    this.mSurfaceTexture.updateTexImage();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.base.r
 * JD-Core Version:    0.7.0.1
 */