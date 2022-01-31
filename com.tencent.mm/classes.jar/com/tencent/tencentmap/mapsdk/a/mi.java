package com.tencent.tencentmap.mapsdk.a;

import android.content.Context;
import android.graphics.Bitmap;
import com.tencent.map.lib.f;
import com.tencent.map.lib.gl.JNICallback.b;
import com.tencent.map.lib.gl.JNICallback.c;
import java.lang.ref.WeakReference;
import java.util.Arrays;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class mi
  implements JNICallback.b, JNICallback.c, ml.b
{
  private WeakReference<ma> a;
  private WeakReference<f> b;
  private mk c;
  private mw d;
  private w e = null;
  private int f = -1;
  private volatile ExecutorService g = null;
  
  public mi(ma paramma)
  {
    this.a = new WeakReference(paramma);
    this.b = new WeakReference(paramma.getMap());
    this.e = w.a(paramma.getContext().getApplicationContext());
    this.c = new mk(this.e);
    this.d = mw.a(paramma.getContext().getApplicationContext());
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
          if (Integer.parseInt(paramString.substring(paramString.indexOf("=") + 1)) == this.e.b("handDrawMapVer")) {
            bool1 = true;
          }
        }
      }
    }
    return bool1;
  }
  
  public int a()
  {
    if ((this.b != null) && (this.b.get() != null))
    {
      this.f = ((f)this.b.get()).E();
      if (this.f != -1) {
        ((f)this.b.get()).a(this.f, 4, 20);
      }
    }
    return this.f;
  }
  
  public Bitmap a(byte[] paramArrayOfByte)
  {
    if ((this.a.get() == null) || (this.f == -1)) {
      localObject = null;
    }
    om localom;
    Bitmap localBitmap;
    do
    {
      return localObject;
      localom = new om();
      localom.a(paramArrayOfByte);
      localObject = new oi(localom.a(), localom.b(), localom.c(), 1);
      localBitmap = this.d.a((oi)localObject);
      localObject = localBitmap;
    } while (localBitmap != null);
    Object localObject = this.c.a(localom.a(), localom.b(), localom.c());
    if (localObject == null) {
      return null;
    }
    localObject = ((String)localObject).getBytes();
    Arrays.fill(paramArrayOfByte, (byte)0);
    System.arraycopy(localObject, 0, paramArrayOfByte, 0, localObject.length);
    return null;
  }
  
  public void a(JNICallback.b paramb)
  {
    if ((this.b != null) && (this.b.get() != null)) {
      ((f)this.b.get()).a(paramb);
    }
  }
  
  public void a(JNICallback.c paramc)
  {
    if ((this.b != null) && (this.b.get() != null)) {
      ((f)this.b.get()).a(paramc);
    }
  }
  
  public void a(String paramString, byte[] paramArrayOfByte1, byte[] paramArrayOfByte2)
  {
    if ((paramArrayOfByte2 == null) || (paramArrayOfByte1 == null) || (paramArrayOfByte2.length == 0) || (paramArrayOfByte1.length == 0)) {}
    for (;;)
    {
      return;
      if (this.g == null) {}
      try
      {
        if (this.g == null) {
          this.g = Executors.newSingleThreadExecutor();
        }
        if (this.g.isShutdown()) {
          continue;
        }
        this.g.execute(new mi.1(this, paramString, paramArrayOfByte1, paramArrayOfByte2));
        return;
      }
      finally {}
    }
  }
  
  public void a(boolean paramBoolean)
  {
    if (paramBoolean) {
      c();
    }
  }
  
  public void b()
  {
    if ((this.b != null) && (this.b.get() != null) && (this.f != -1))
    {
      f localf = (f)this.b.get();
      localf.a(null);
      localf.a(null);
      localf.h(this.f);
      this.f = -1;
    }
  }
  
  public void c()
  {
    if ((this.b != null) && (this.b.get() != null) && (this.f != -2147483648)) {
      ((f)this.b.get()).i(this.f);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.tencentmap.mapsdk.a.mi
 * JD-Core Version:    0.7.0.1
 */