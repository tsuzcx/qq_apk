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
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.util.e;
import com.tencent.mm.sdk.a.b;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.f;
import com.tencent.mm.sdk.platformtools.g;
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
  
  private static String abY()
  {
    AppMethodBeat.i(106801);
    StringBuilder localStringBuilder = new StringBuilder(256);
    StringBuilderPrinter localStringBuilderPrinter = new StringBuilderPrinter(localStringBuilder);
    Object localObject2 = ah.getContext();
    localStringBuilderPrinter.println("#accinfo.revision=" + f.REV);
    localStringBuilderPrinter.println("#accinfo.build=" + f.TIME + ":" + f.HOSTNAME + ":" + g.bWu);
    Object localObject3 = new StringBuilder("#accinfo.env=");
    Object localObject1;
    if (b.foreground) {
      localObject1 = "f";
    }
    for (;;)
    {
      localStringBuilderPrinter.println((String)localObject1 + ":" + Thread.currentThread().getName() + ":" + b.ymf);
      try
      {
        localObject1 = Environment.getDataDirectory();
        localObject3 = new StatFs(((File)localObject1).getPath());
        StatFs localStatFs = new StatFs(e.eQx);
        localObject1 = String.format("%dMB %s:%d:%d:%d %s:%d:%d:%d", new Object[] { Integer.valueOf(((ActivityManager)((Context)localObject2).getSystemService("activity")).getMemoryClass()), ((File)localObject1).getAbsolutePath(), Integer.valueOf(((StatFs)localObject3).getBlockSize()), Integer.valueOf(((StatFs)localObject3).getBlockCount()), Integer.valueOf(((StatFs)localObject3).getAvailableBlocks()), e.eQx, Integer.valueOf(localStatFs.getBlockSize()), Integer.valueOf(localStatFs.getBlockCount()), Integer.valueOf(localStatFs.getAvailableBlocks()) });
        localStringBuilderPrinter.println("#accinfo.data=".concat(String.valueOf(localObject1)));
        localObject1 = new Date();
        localObject2 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSSZ", Locale.getDefault());
        localStringBuilderPrinter.println("#accinfo.crashTime=" + ((SimpleDateFormat)localObject2).format((Date)localObject1));
        localStringBuilderPrinter.println("#crashContent=");
        localObject1 = localStringBuilder.toString();
        AppMethodBeat.o(106801);
        return localObject1;
        localObject1 = "b";
      }
      catch (Exception localException)
      {
        for (;;)
        {
          ab.e("MicroMsg.MMSurfaceTextureWrap", "check data size failed :%s", new Object[] { localException.getMessage() });
          String str = "";
        }
      }
    }
  }
  
  public final void attachToGLContext(int paramInt)
  {
    AppMethodBeat.i(106802);
    ab.i("MicroMsg.MMSurfaceTextureWrap", "detect texture problem, attachToGLContext");
    this.mSurfaceTexture.attachToGLContext(paramInt);
    AppMethodBeat.o(106802);
  }
  
  public final void detachFromGLContext()
  {
    AppMethodBeat.i(106800);
    ab.i("MicroMsg.MMSurfaceTextureWrap", "detect texture problem, detachFromGLContext");
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
          localObject1 = abY() + " detect texture problem error code = " + i + ", detach = true, and error = " + bool;
          b.G(Base64.encodeToString(((String)localObject1).getBytes(), 2), "DetachFromGLContext");
          ab.w("MicroMsg.MMSurfaceTextureWrap", (String)localObject1);
          ab.i("MicroMsg.MMSurfaceTextureWrap", "detect texture problem, err %s hasDetach %s hasError %s", new Object[] { Integer.valueOf(i), Boolean.TRUE, Boolean.valueOf(bool) });
          AppMethodBeat.o(106800);
          return;
        }
        catch (IllegalArgumentException localIllegalArgumentException)
        {
          ab.printErrStackTrace("MicroMsg.MMSurfaceTextureWrap", localIllegalArgumentException, "%s", new Object[] { "detect texture problem, IllegalArgumentException" });
          String str1;
          return;
        }
        catch (IllegalAccessException localIllegalAccessException)
        {
          ab.printErrStackTrace("MicroMsg.MMSurfaceTextureWrap", localIllegalAccessException, "%s", new Object[] { "detect texture problem, IllegalAccessException" });
          String str2;
          return;
        }
        catch (InvocationTargetException localInvocationTargetException)
        {
          ab.printErrStackTrace("MicroMsg.MMSurfaceTextureWrap", localInvocationTargetException, "%s", new Object[] { "detect texture problem, InvocationTargetException" });
          String str3;
          return;
        }
        catch (NoSuchMethodException localNoSuchMethodException)
        {
          ab.printErrStackTrace("MicroMsg.MMSurfaceTextureWrap", localNoSuchMethodException, "%s", new Object[] { "detect texture problem, NoSuchMethodException" });
          String str4;
          return;
        }
        catch (Exception localException2)
        {
          ab.printErrStackTrace("MicroMsg.MMSurfaceTextureWrap", localException2, "%s", new Object[] { "detect texture problem, Exception" });
          String str5;
          return;
        }
        finally
        {
          boolean bool;
          String str6 = abY() + " detect texture problem error code = 0, detach = false, and error = " + bool;
          b.G(Base64.encodeToString(str6.getBytes(), 2), "DetachFromGLContext");
          ab.w("MicroMsg.MMSurfaceTextureWrap", str6);
          ab.i("MicroMsg.MMSurfaceTextureWrap", "detect texture problem, err %s hasDetach %s hasError %s", new Object[] { Integer.valueOf(0), Boolean.FALSE, Boolean.valueOf(bool) });
          AppMethodBeat.o(106800);
        }
        localException1 = localException1;
        ab.printErrStackTrace("MicroMsg.MMSurfaceTextureWrap", localException1, "%s", new Object[] { "detect texture problem, RuntimeException detachFromGLContext" });
        bool = true;
      }
    }
    if (bool) {}
    AppMethodBeat.o(106800);
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(106806);
    boolean bool = this.mSurfaceTexture.equals(paramObject);
    AppMethodBeat.o(106806);
    return bool;
  }
  
  public final long getTimestamp()
  {
    AppMethodBeat.i(106804);
    ab.i("MicroMsg.MMSurfaceTextureWrap", "detect texture problem, getTimestamp");
    long l = this.mSurfaceTexture.getTimestamp();
    AppMethodBeat.o(106804);
    return l;
  }
  
  public final void getTransformMatrix(float[] paramArrayOfFloat)
  {
    AppMethodBeat.i(106803);
    ab.i("MicroMsg.MMSurfaceTextureWrap", "detect texture problem, getTransformMatrix");
    this.mSurfaceTexture.getTransformMatrix(paramArrayOfFloat);
    AppMethodBeat.o(106803);
  }
  
  public final int hashCode()
  {
    AppMethodBeat.i(106807);
    int i = this.mSurfaceTexture.hashCode();
    AppMethodBeat.o(106807);
    return i;
  }
  
  public final void release()
  {
    AppMethodBeat.i(106805);
    super.release();
    ab.i("MicroMsg.MMSurfaceTextureWrap", "detect texture problem, release");
    this.mSurfaceTexture.release();
    AppMethodBeat.o(106805);
  }
  
  @TargetApi(19)
  public final void releaseTexImage()
  {
    AppMethodBeat.i(106809);
    ab.i("MicroMsg.MMSurfaceTextureWrap", "detect texture problem, releaseTexImage");
    this.mSurfaceTexture.releaseTexImage();
    AppMethodBeat.o(106809);
  }
  
  public final void setDefaultBufferSize(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(106798);
    ab.i("MicroMsg.MMSurfaceTextureWrap", "detect texture problem, setDefaultBufferSize");
    this.mSurfaceTexture.setDefaultBufferSize(paramInt1, paramInt2);
    AppMethodBeat.o(106798);
  }
  
  public final void setOnFrameAvailableListener(SurfaceTexture.OnFrameAvailableListener paramOnFrameAvailableListener)
  {
    AppMethodBeat.i(106797);
    ab.i("MicroMsg.MMSurfaceTextureWrap", "detect texture problem, setOnFrameAvailableListener");
    this.mSurfaceTexture.setOnFrameAvailableListener(paramOnFrameAvailableListener);
    AppMethodBeat.o(106797);
  }
  
  public final String toString()
  {
    AppMethodBeat.i(106808);
    String str = this.mSurfaceTexture.toString();
    AppMethodBeat.o(106808);
    return str;
  }
  
  public final void updateTexImage()
  {
    AppMethodBeat.i(106799);
    ab.i("MicroMsg.MMSurfaceTextureWrap", "detect texture problem, updateTexImage");
    this.mSurfaceTexture.updateTexImage();
    AppMethodBeat.o(106799);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.base.r
 * JD-Core Version:    0.7.0.1
 */