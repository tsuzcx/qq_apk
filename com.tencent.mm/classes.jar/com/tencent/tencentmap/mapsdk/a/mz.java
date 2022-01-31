package com.tencent.tencentmap.mapsdk.a;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.BitmapFactory;
import com.tencent.map.lib.f;
import com.tencent.map.lib.gl.JNICallback.j;
import com.tencent.map.lib.gl.JNICallback.k;
import java.lang.ref.WeakReference;
import java.util.Arrays;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.microedition.khronos.opengles.GL10;

public class mz
  extends ln
  implements JNICallback.j, JNICallback.k
{
  ne a;
  private WeakReference<nd> b;
  private mw c;
  private volatile int d = -1;
  private volatile ExecutorService e = null;
  
  public mz(nd paramnd, ne paramne)
  {
    if ((paramnd == null) || (paramnd.a() == null)) {
      return;
    }
    f localf = paramnd.a().getMap();
    this.c = mw.a(paramnd.a().getContext().getApplicationContext());
    this.b = new WeakReference(paramnd);
    this.a = paramne;
    localf.a(this);
    localf.a(this);
    this.d = localf.e(false);
  }
  
  private boolean a(String paramString)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (paramString != null)
    {
      bool1 = bool2;
      if (paramString.length() > 0)
      {
        paramString = Pattern.compile("version=\\d+").matcher(paramString);
        bool1 = bool2;
        if (paramString.find())
        {
          paramString = paramString.group();
          bool1 = bool2;
          if (Integer.parseInt(paramString.substring(paramString.indexOf("=") + 1)) == nb.c()) {
            bool1 = true;
          }
        }
      }
    }
    return bool1;
  }
  
  private qb b(String paramString)
  {
    if ((paramString == null) || (paramString.length() == 0)) {
      return null;
    }
    int i = paramString.lastIndexOf("foreignLanguage");
    return qb.valueOf(paramString.substring("foreignLanguage".length() + 1 + i));
  }
  
  public Bitmap a(byte[] paramArrayOfByte)
  {
    if ((this.b == null) || (this.b.get() == null) || (this.d == -1)) {
      return null;
    }
    Object localObject = new om();
    ((om)localObject).a(paramArrayOfByte);
    localObject = new oi(((om)localObject).a(), ((om)localObject).b(), ((om)localObject).c(), 0, this.a.a());
    Bitmap localBitmap = this.c.a((oi)localObject);
    if (localBitmap != null) {
      return localBitmap;
    }
    localObject = this.a.a(((oi)localObject).a(), ((oi)localObject).b(), ((oi)localObject).c());
    if (localObject == null) {
      return null;
    }
    localObject = ((String)localObject).getBytes();
    Arrays.fill(paramArrayOfByte, (byte)0);
    System.arraycopy(localObject, 0, paramArrayOfByte, 0, localObject.length);
    return null;
  }
  
  public void a(final String paramString, final byte[] paramArrayOfByte1, final byte[] paramArrayOfByte2)
  {
    if (this.e == null) {}
    try
    {
      if (this.e == null) {
        this.e = Executors.newSingleThreadExecutor();
      }
      if (!this.e.isShutdown()) {
        this.e.execute(new Runnable()
        {
          public void run()
          {
            if (!mz.a(mz.this, paramString)) {}
            Object localObject;
            Bitmap localBitmap;
            do
            {
              return;
              localObject = new om();
              ((om)localObject).a(paramArrayOfByte1);
              localObject = new oi(((om)localObject).a(), ((om)localObject).b(), ((om)localObject).c(), 0, mz.b(mz.this, paramString));
              localBitmap = BitmapFactory.decodeByteArray(paramArrayOfByte2, 0, paramArrayOfByte2.length);
            } while (localBitmap == null);
            if ((mz.a(mz.this) != null) && (mz.a(mz.this).get() != null)) {
              ((nd)mz.a(mz.this).get()).a(1);
            }
            mz.b(mz.this).a(li.a(localBitmap, Bitmap.CompressFormat.PNG), (oi)localObject);
          }
        });
      }
      return;
    }
    finally {}
  }
  
  public void a(GL10 paramGL10) {}
  
  public boolean a()
  {
    return false;
  }
  
  public boolean a(float paramFloat1, float paramFloat2)
  {
    return false;
  }
  
  public void b() {}
  
  public void c() {}
  
  public void d()
  {
    if ((this.b != null) && (this.b.get() != null))
    {
      Object localObject = ((nd)this.b.get()).a();
      if ((localObject != null) && (((ma)localObject).getMap() != null))
      {
        localObject = ((ma)localObject).getMap();
        ((f)localObject).a(null);
        ((f)localObject).a(null);
        ((f)localObject).h(this.d);
        this.d = -1;
      }
    }
  }
  
  public void e()
  {
    if ((this.d != -1) && (this.b != null) && (this.b.get() != null)) {
      ((nd)this.b.get()).a().getMap().i(this.d);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.tencentmap.mapsdk.a.mz
 * JD-Core Version:    0.7.0.1
 */