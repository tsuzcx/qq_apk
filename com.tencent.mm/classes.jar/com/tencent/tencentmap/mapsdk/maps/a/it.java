package com.tencent.tencentmap.mapsdk.maps.a;

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
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.lang.ref.WeakReference;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class it
{
  private WeakReference<Context> a;
  private hl b;
  private iv c;
  private float d;
  private b e;
  private nr f;
  private Lock g;
  private Lock h;
  
  public it(Context paramContext, hl paramhl, iv paramiv, b paramb)
  {
    AppMethodBeat.i(148647);
    this.d = 1.0F;
    this.g = new ReentrantLock();
    this.h = new ReentrantLock();
    this.a = new WeakReference(paramContext);
    this.b = paramhl;
    this.c = paramiv;
    this.e = paramb;
    this.d = SystemUtil.getDensity(paramContext);
    if ((paramhl != null) && (paramhl.b() != null) && (paramhl.b().get() != null)) {
      this.f = ((ic)paramhl.b().get()).o();
    }
    AppMethodBeat.o(148647);
  }
  
  private int a(int paramInt)
  {
    return (0xFF0000 & paramInt) >> 16 | (paramInt & 0xFF) << 16 | 0xFF00FFFF & paramInt & 0xFFFFFF00;
  }
  
  private Bitmap a(String paramString, Bitmap.Config paramConfig, boolean paramBoolean)
  {
    AppMethodBeat.i(148654);
    if ((!new File(paramString).exists()) || (this.a == null) || (this.a.get() == null))
    {
      AppMethodBeat.o(148654);
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
      AppMethodBeat.o(148654);
      return paramString;
    }
    catch (OutOfMemoryError paramString)
    {
      AppMethodBeat.o(148654);
    }
    return null;
  }
  
  private boolean a(File paramFile, String paramString, byte[] paramArrayOfByte, Lock paramLock)
  {
    AppMethodBeat.i(148655);
    if ((paramFile == null) || (StringUtil.isEmpty(paramString)) || (paramArrayOfByte == null) || (paramArrayOfByte.length == 0))
    {
      AppMethodBeat.o(148655);
      return false;
    }
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
      try
      {
        boolean bool = paramArrayOfByte.equals(a.a((File)localObject));
        if (!bool)
        {
          AppMethodBeat.o(148655);
          return false;
        }
      }
      catch (FileNotFoundException paramArrayOfByte)
      {
        paramArrayOfByte = new File(paramFile, paramString);
        paramFile = new File(paramFile, paramString + ".bak");
        if ((paramFile.exists()) && (!paramFile.delete()))
        {
          paramFile.deleteOnExit();
          AppMethodBeat.o(148655);
          return false;
        }
        try
        {
          paramLock.lock();
          if ((paramArrayOfByte.exists()) && (!paramArrayOfByte.renameTo(paramFile)))
          {
            if (!((File)localObject).delete()) {
              ((File)localObject).deleteOnExit();
            }
            return false;
          }
          if (!((File)localObject).renameTo(paramArrayOfByte))
          {
            paramFile.renameTo(paramArrayOfByte);
            if (!((File)localObject).delete()) {
              ((File)localObject).deleteOnExit();
            }
            return false;
          }
          if (!paramFile.delete()) {
            paramFile.deleteOnExit();
          }
          return true;
        }
        finally
        {
          paramLock.unlock();
          AppMethodBeat.o(148655);
        }
      }
      return false;
    }
    catch (Exception paramFile)
    {
      AppMethodBeat.o(148655);
    }
  }
  
  private Bitmap c(String paramString)
  {
    AppMethodBeat.i(148656);
    paramString = paramString.substring(14);
    if (StringUtil.isEmpty(paramString))
    {
      AppMethodBeat.o(148656);
      return null;
    }
    paramString = paramString.split(", ");
    if ((paramString == null) || (paramString.length < 5))
    {
      AppMethodBeat.o(148656);
      return null;
    }
    int i = Integer.parseInt(paramString[0]);
    int j = Integer.parseInt(paramString[1]);
    long l1 = Long.parseLong(paramString[2]);
    long l2 = Long.parseLong(paramString[3]);
    float f1 = Float.parseFloat(paramString[4]);
    if ((i < 0) || (j < 0))
    {
      AppMethodBeat.o(148656);
      return null;
    }
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
    AppMethodBeat.o(148656);
    return localBitmap;
  }
  
  public JNICallback.IconImageInfo a(String paramString)
  {
    AppMethodBeat.i(148648);
    JNICallback.IconImageInfo localIconImageInfo = new JNICallback.IconImageInfo();
    localIconImageInfo.scale = this.d;
    localIconImageInfo.anchorPointX1 = 0.5F;
    localIconImageInfo.anchorPointY1 = 0.5F;
    localIconImageInfo.bitmap = a(paramString, Bitmap.Config.RGB_565, false);
    AppMethodBeat.o(148648);
    return localIconImageInfo;
  }
  
  public void a()
  {
    AppMethodBeat.i(99872);
    this.g.lock();
    AppMethodBeat.o(99872);
  }
  
  public boolean a(String paramString, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(148651);
    if (this.c == null)
    {
      AppMethodBeat.o(148651);
      return false;
    }
    boolean bool = a(new File(this.c.c()), paramString, paramArrayOfByte, this.g);
    AppMethodBeat.o(148651);
    return bool;
  }
  
  public JNICallback.IconImageInfo b(String paramString)
  {
    AppMethodBeat.i(148649);
    if (this.e == null)
    {
      AppMethodBeat.o(148649);
      return null;
    }
    localIconImageInfo = new JNICallback.IconImageInfo();
    localIconImageInfo.anchorPointX1 = 0.5F;
    localIconImageInfo.anchorPointY1 = 0.5F;
    if ((paramString != null) && (paramString.startsWith("drawRoundRect")))
    {
      localIconImageInfo.scale = 1.0F;
      localIconImageInfo.bitmap = c(paramString);
      if ((localIconImageInfo.bitmap == null) && (this.f != null)) {
        this.f.a(System.currentTimeMillis(), paramString);
      }
      AppMethodBeat.o(148649);
      return localIconImageInfo;
    }
    try
    {
      this.h.lock();
      Bitmap localBitmap = this.e.a(paramString);
      return null;
    }
    finally
    {
      try
      {
        this.h.unlock();
        localIconImageInfo.scale = this.d;
        localIconImageInfo.bitmap = localBitmap;
        if ((localBitmap == null) && (!paramString.equals("compass.png"))) {
          d.b("Failed to get texture for: ".concat(String.valueOf(paramString)));
        }
        if ((localIconImageInfo.bitmap == null) && (this.f != null)) {
          this.f.a(System.currentTimeMillis(), paramString);
        }
        AppMethodBeat.o(148649);
        return localIconImageInfo;
      }
      catch (Exception localException)
      {
        if ((localIconImageInfo.bitmap != null) || (this.f == null)) {
          break label250;
        }
        this.f.a(System.currentTimeMillis(), paramString);
        AppMethodBeat.o(148649);
      }
      localObject = finally;
      this.h.unlock();
      AppMethodBeat.o(148649);
    }
  }
  
  public void b()
  {
    AppMethodBeat.i(148650);
    this.g.unlock();
    AppMethodBeat.o(148650);
  }
  
  public boolean b(String paramString, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(148652);
    if (this.c == null)
    {
      AppMethodBeat.o(148652);
      return false;
    }
    boolean bool = a(new File(this.c.d()), paramString, paramArrayOfByte, this.h);
    AppMethodBeat.o(148652);
    return bool;
  }
  
  public void c()
  {
    AppMethodBeat.i(148653);
    this.b.f().b("");
    AppMethodBeat.o(148653);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.tencentmap.mapsdk.maps.a.it
 * JD-Core Version:    0.7.0.1
 */