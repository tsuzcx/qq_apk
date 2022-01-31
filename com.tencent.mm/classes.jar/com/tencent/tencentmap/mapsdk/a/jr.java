package com.tencent.tencentmap.mapsdk.a;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.RectF;
import android.util.DisplayMetrics;
import com.tencent.map.lib.b;
import com.tencent.map.lib.d;
import com.tencent.map.lib.gl.JNICallback.IconImageInfo;
import com.tencent.map.lib.util.StringUtil;
import com.tencent.map.lib.util.SystemUtil;
import com.tencent.map.lib.util.a;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.lang.ref.WeakReference;
import java.util.concurrent.Semaphore;

public class jr
{
  private WeakReference<Context> a;
  private ik b;
  private jt c;
  private float d = 1.0F;
  private b e;
  private Semaphore f = new Semaphore(1);
  private Semaphore g = new Semaphore(1);
  
  public jr(Context paramContext, ik paramik, jt paramjt, b paramb)
  {
    this.a = new WeakReference(paramContext);
    this.b = paramik;
    this.c = paramjt;
    this.e = paramb;
    this.d = SystemUtil.getDensity(paramContext);
  }
  
  private int a(int paramInt)
  {
    return (0xFF0000 & paramInt) >> 16 | (paramInt & 0xFF) << 16 | 0xFF00FFFF & paramInt & 0xFFFFFF00;
  }
  
  private Bitmap a(String paramString, Bitmap.Config paramConfig, boolean paramBoolean)
  {
    if ((!new File(paramString).exists()) || (this.a == null) || (this.a.get() == null)) {
      return null;
    }
    BitmapFactory.Options localOptions = new BitmapFactory.Options();
    localOptions.inPreferredConfig = paramConfig;
    if (paramBoolean)
    {
      localOptions.inDensity = 320;
      localOptions.inTargetDensity = ((Context)this.a.get()).getResources().getDisplayMetrics().densityDpi;
    }
    try
    {
      paramString = BitmapFactory.decodeFile(paramString, localOptions);
      return paramString;
    }
    catch (OutOfMemoryError paramString) {}
    return null;
  }
  
  private boolean a(File paramFile, String paramString, byte[] paramArrayOfByte, Semaphore paramSemaphore)
  {
    if ((paramFile == null) || (StringUtil.isEmpty(paramString)) || (paramArrayOfByte == null) || (paramArrayOfByte.length == 0)) {}
    for (;;)
    {
      return false;
      Object localObject = paramString + "_" + paramArrayOfByte.hashCode();
      try
      {
        if (!paramFile.exists()) {
          paramFile.mkdirs();
        }
        localObject = new File(paramFile, (String)localObject);
        if (((File)localObject).exists()) {
          ((File)localObject).delete();
        }
        ((File)localObject).createNewFile();
        FileOutputStream localFileOutputStream = new FileOutputStream((File)localObject);
        localFileOutputStream.write(paramArrayOfByte);
        localFileOutputStream.flush();
        localFileOutputStream.close();
        paramArrayOfByte = a.a(paramArrayOfByte);
      }
      catch (Exception paramFile)
      {
        boolean bool;
        label142:
        paramSemaphore.release();
        return false;
      }
      try
      {
        bool = paramArrayOfByte.equals(a.a((File)localObject));
        if (!bool) {}
      }
      catch (FileNotFoundException paramArrayOfByte)
      {
        break label142;
      }
    }
    paramArrayOfByte = new File(paramFile, paramString);
    paramFile = new File(paramFile, paramString + ".bak");
    if ((paramFile.exists()) && (!paramFile.delete()))
    {
      paramFile.deleteOnExit();
      return false;
    }
    paramSemaphore.acquire();
    if ((paramArrayOfByte.exists()) && (!paramArrayOfByte.renameTo(paramFile)))
    {
      if (!((File)localObject).delete()) {
        ((File)localObject).deleteOnExit();
      }
      paramSemaphore.release();
      return false;
    }
    if (!((File)localObject).renameTo(paramArrayOfByte))
    {
      paramFile.renameTo(paramArrayOfByte);
      if (!((File)localObject).delete()) {
        ((File)localObject).deleteOnExit();
      }
      paramSemaphore.release();
      return false;
    }
    if (!paramFile.delete()) {
      paramFile.deleteOnExit();
    }
    paramSemaphore.release();
    return true;
  }
  
  private Bitmap c(String paramString)
  {
    paramString = paramString.substring(14);
    if (StringUtil.isEmpty(paramString)) {}
    int i;
    int j;
    long l1;
    long l2;
    float f1;
    do
    {
      do
      {
        return null;
        paramString = paramString.split(", ");
      } while ((paramString == null) || (paramString.length < 5));
      i = Integer.parseInt(paramString[0]);
      j = Integer.parseInt(paramString[1]);
      l1 = Long.parseLong(paramString[2]);
      l2 = Long.parseLong(paramString[3]);
      f1 = Float.parseFloat(paramString[4]);
    } while ((i < 0) || (j < 0));
    paramString = new Paint();
    paramString.setAntiAlias(true);
    paramString.setStrokeWidth(f1);
    paramString.setStyle(Paint.Style.STROKE);
    paramString.setColor(a((int)l2));
    Bitmap localBitmap = Bitmap.createBitmap(i, j, Bitmap.Config.ARGB_8888);
    Canvas localCanvas = new Canvas(localBitmap);
    localCanvas.drawColor(a((int)l1));
    RectF localRectF = new RectF();
    localRectF.left = 0.0F;
    localRectF.top = 0.0F;
    localRectF.right = i;
    localRectF.bottom = j;
    localCanvas.drawRoundRect(localRectF, i >> 3, j >> 3, paramString);
    return localBitmap;
  }
  
  public JNICallback.IconImageInfo a(String paramString)
  {
    JNICallback.IconImageInfo localIconImageInfo = new JNICallback.IconImageInfo();
    localIconImageInfo.scale = this.d;
    localIconImageInfo.anchorPointX1 = 0.5F;
    localIconImageInfo.anchorPointY1 = 0.5F;
    localIconImageInfo.bitmap = a(paramString, Bitmap.Config.RGB_565, false);
    return localIconImageInfo;
  }
  
  public void a()
  {
    try
    {
      this.f.acquire();
      return;
    }
    catch (InterruptedException localInterruptedException) {}
  }
  
  public boolean a(String paramString, byte[] paramArrayOfByte)
  {
    if (this.c == null) {
      return false;
    }
    return a(new File(this.c.c()), paramString, paramArrayOfByte, this.f);
  }
  
  public JNICallback.IconImageInfo b(String paramString)
  {
    if (this.e == null) {
      return null;
    }
    JNICallback.IconImageInfo localIconImageInfo = new JNICallback.IconImageInfo();
    localIconImageInfo.anchorPointX1 = 0.5F;
    localIconImageInfo.anchorPointY1 = 0.5F;
    if ((paramString != null) && (paramString.startsWith("drawRoundRect")))
    {
      localIconImageInfo.scale = 1.0F;
      localIconImageInfo.bitmap = c(paramString);
      return localIconImageInfo;
    }
    try
    {
      this.g.acquire();
      Bitmap localBitmap = this.e.a(paramString);
      this.g.release();
      localIconImageInfo.scale = this.d;
      localIconImageInfo.bitmap = localBitmap;
      if ((localBitmap == null) && (!paramString.equals("compass.png"))) {
        d.b("Failed to get texture for: " + paramString);
      }
      return localIconImageInfo;
    }
    catch (InterruptedException paramString) {}
    return null;
  }
  
  public void b()
  {
    this.f.release();
  }
  
  public boolean b(String paramString, byte[] paramArrayOfByte)
  {
    if (this.c == null) {
      return false;
    }
    return a(new File(this.c.d()), paramString, paramArrayOfByte, this.g);
  }
  
  public void c()
  {
    this.b.f().a("");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.tencentmap.mapsdk.a.jr
 * JD-Core Version:    0.7.0.1
 */