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
import com.tencent.mm.loader.j.b;
import com.tencent.mm.sdk.crash.CrashReportFactory;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import com.tencent.mm.sdk.platformtools.ChannelUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import java.io.File;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

@TargetApi(16)
final class s
  extends SurfaceTexture
{
  public SurfaceTexture mSurfaceTexture = null;
  
  public s()
  {
    super(0);
  }
  
  private static String aXy()
  {
    AppMethodBeat.i(142160);
    StringBuilder localStringBuilder = new StringBuilder(256);
    StringBuilderPrinter localStringBuilderPrinter = new StringBuilderPrinter(localStringBuilder);
    Object localObject2 = MMApplicationContext.getContext();
    localStringBuilderPrinter.println("#accinfo.revision=" + BuildInfo.REV);
    localStringBuilderPrinter.println("#accinfo.build=" + BuildInfo.TIME + ":" + BuildInfo.HOSTNAME + ":" + ChannelUtil.channelId);
    Object localObject3 = new StringBuilder("#accinfo.env=");
    Object localObject1;
    if (CrashReportFactory.foreground) {
      localObject1 = "f";
    }
    for (;;)
    {
      localStringBuilderPrinter.println((String)localObject1 + ":" + Thread.currentThread().getName() + ":" + CrashReportFactory.currentActivity);
      try
      {
        localObject1 = new StatFs(Environment.getDataDirectory().getPath());
        localObject3 = new StatFs(b.aKD());
        localObject1 = String.format("%dMB %s:%d:%d:%d %s:%d:%d:%d", new Object[] { Integer.valueOf(((ActivityManager)((Context)localObject2).getSystemService("activity")).getMemoryClass()), Environment.getDataDirectory().getAbsolutePath(), Integer.valueOf(((StatFs)localObject1).getBlockSize()), Integer.valueOf(((StatFs)localObject1).getBlockCount()), Integer.valueOf(((StatFs)localObject1).getAvailableBlocks()), b.aKD(), Integer.valueOf(((StatFs)localObject3).getBlockSize()), Integer.valueOf(((StatFs)localObject3).getBlockCount()), Integer.valueOf(((StatFs)localObject3).getAvailableBlocks()) });
        localStringBuilderPrinter.println("#accinfo.data=".concat(String.valueOf(localObject1)));
        localObject1 = new Date();
        localObject2 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSSZ", Locale.getDefault());
        localStringBuilderPrinter.println("#accinfo.crashTime=" + ((SimpleDateFormat)localObject2).format((Date)localObject1));
        localStringBuilderPrinter.println("#crashContent=");
        localObject1 = localStringBuilder.toString();
        AppMethodBeat.o(142160);
        return localObject1;
        localObject1 = "b";
      }
      catch (Exception localException)
      {
        for (;;)
        {
          Log.e("MicroMsg.MMSurfaceTextureWrap", "check data size failed :%s", new Object[] { localException.getMessage() });
          String str = "";
        }
      }
    }
  }
  
  public final void attachToGLContext(int paramInt)
  {
    AppMethodBeat.i(142161);
    Log.i("MicroMsg.MMSurfaceTextureWrap", "detect texture problem, attachToGLContext");
    this.mSurfaceTexture.attachToGLContext(paramInt);
    AppMethodBeat.o(142161);
  }
  
  public final void detachFromGLContext()
  {
    AppMethodBeat.i(142159);
    Log.i("MicroMsg.MMSurfaceTextureWrap", "detect texture problem, detachFromGLContext");
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
          localObject1 = aXy() + " detect texture problem error code = " + i + ", detach = true, and error = " + bool;
          CrashReportFactory.reportRawMessage(Base64.encodeToString(((String)localObject1).getBytes(), 2), "DetachFromGLContext");
          Log.w("MicroMsg.MMSurfaceTextureWrap", (String)localObject1);
          Log.i("MicroMsg.MMSurfaceTextureWrap", "detect texture problem, err %s hasDetach %s hasError %s", new Object[] { Integer.valueOf(i), Boolean.TRUE, Boolean.valueOf(bool) });
          AppMethodBeat.o(142159);
          return;
        }
        catch (IllegalArgumentException localIllegalArgumentException)
        {
          Log.printErrStackTrace("MicroMsg.MMSurfaceTextureWrap", localIllegalArgumentException, "%s", new Object[] { "detect texture problem, IllegalArgumentException" });
          String str1;
          return;
        }
        catch (IllegalAccessException localIllegalAccessException)
        {
          Log.printErrStackTrace("MicroMsg.MMSurfaceTextureWrap", localIllegalAccessException, "%s", new Object[] { "detect texture problem, IllegalAccessException" });
          String str2;
          return;
        }
        catch (InvocationTargetException localInvocationTargetException)
        {
          Log.printErrStackTrace("MicroMsg.MMSurfaceTextureWrap", localInvocationTargetException, "%s", new Object[] { "detect texture problem, InvocationTargetException" });
          String str3;
          return;
        }
        catch (NoSuchMethodException localNoSuchMethodException)
        {
          Log.printErrStackTrace("MicroMsg.MMSurfaceTextureWrap", localNoSuchMethodException, "%s", new Object[] { "detect texture problem, NoSuchMethodException" });
          String str4;
          return;
        }
        catch (Exception localException2)
        {
          Log.printErrStackTrace("MicroMsg.MMSurfaceTextureWrap", localException2, "%s", new Object[] { "detect texture problem, Exception" });
          String str5;
          return;
        }
        finally
        {
          boolean bool;
          String str6 = aXy() + " detect texture problem error code = 0, detach = false, and error = " + bool;
          CrashReportFactory.reportRawMessage(Base64.encodeToString(str6.getBytes(), 2), "DetachFromGLContext");
          Log.w("MicroMsg.MMSurfaceTextureWrap", str6);
          Log.i("MicroMsg.MMSurfaceTextureWrap", "detect texture problem, err %s hasDetach %s hasError %s", new Object[] { Integer.valueOf(0), Boolean.FALSE, Boolean.valueOf(bool) });
          AppMethodBeat.o(142159);
        }
        localException1 = localException1;
        Log.printErrStackTrace("MicroMsg.MMSurfaceTextureWrap", localException1, "%s", new Object[] { "detect texture problem, RuntimeException detachFromGLContext" });
        bool = true;
      }
    }
    if (bool) {}
    AppMethodBeat.o(142159);
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(142165);
    boolean bool = this.mSurfaceTexture.equals(paramObject);
    AppMethodBeat.o(142165);
    return bool;
  }
  
  public final long getTimestamp()
  {
    AppMethodBeat.i(142163);
    Log.i("MicroMsg.MMSurfaceTextureWrap", "detect texture problem, getTimestamp");
    long l = this.mSurfaceTexture.getTimestamp();
    AppMethodBeat.o(142163);
    return l;
  }
  
  public final void getTransformMatrix(float[] paramArrayOfFloat)
  {
    AppMethodBeat.i(142162);
    Log.i("MicroMsg.MMSurfaceTextureWrap", "detect texture problem, getTransformMatrix");
    this.mSurfaceTexture.getTransformMatrix(paramArrayOfFloat);
    AppMethodBeat.o(142162);
  }
  
  public final int hashCode()
  {
    AppMethodBeat.i(142166);
    int i = this.mSurfaceTexture.hashCode();
    AppMethodBeat.o(142166);
    return i;
  }
  
  public final void release()
  {
    AppMethodBeat.i(142164);
    super.release();
    Log.i("MicroMsg.MMSurfaceTextureWrap", "detect texture problem, release");
    this.mSurfaceTexture.release();
    AppMethodBeat.o(142164);
  }
  
  @TargetApi(19)
  public final void releaseTexImage()
  {
    AppMethodBeat.i(142168);
    Log.i("MicroMsg.MMSurfaceTextureWrap", "detect texture problem, releaseTexImage");
    this.mSurfaceTexture.releaseTexImage();
    AppMethodBeat.o(142168);
  }
  
  public final void setDefaultBufferSize(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(142157);
    Log.i("MicroMsg.MMSurfaceTextureWrap", "detect texture problem, setDefaultBufferSize");
    this.mSurfaceTexture.setDefaultBufferSize(paramInt1, paramInt2);
    AppMethodBeat.o(142157);
  }
  
  public final void setOnFrameAvailableListener(SurfaceTexture.OnFrameAvailableListener paramOnFrameAvailableListener)
  {
    AppMethodBeat.i(142156);
    Log.i("MicroMsg.MMSurfaceTextureWrap", "detect texture problem, setOnFrameAvailableListener");
    this.mSurfaceTexture.setOnFrameAvailableListener(paramOnFrameAvailableListener);
    AppMethodBeat.o(142156);
  }
  
  public final String toString()
  {
    AppMethodBeat.i(142167);
    String str = this.mSurfaceTexture.toString();
    AppMethodBeat.o(142167);
    return str;
  }
  
  public final void updateTexImage()
  {
    AppMethodBeat.i(142158);
    Log.i("MicroMsg.MMSurfaceTextureWrap", "detect texture problem, updateTexImage");
    this.mSurfaceTexture.updateTexImage();
    AppMethodBeat.o(142158);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.base.s
 * JD-Core Version:    0.7.0.1
 */