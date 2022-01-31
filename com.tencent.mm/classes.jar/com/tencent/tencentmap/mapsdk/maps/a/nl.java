package com.tencent.tencentmap.mapsdk.maps.a;

import android.content.Context;
import android.graphics.Bitmap;
import com.tencent.map.lib.f;
import com.tencent.map.lib.gl.JNICallback.k;
import com.tencent.map.lib.gl.JNICallback.l;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.tencentmap.mapsdk.a.bc;
import com.tencent.tencentmap.mapsdk.a.be;
import com.tencent.tencentmap.mapsdk.a.cy;
import java.lang.ref.WeakReference;
import java.util.Arrays;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.microedition.khronos.opengles.GL10;

public class nl
  extends jx
  implements JNICallback.k, JNICallback.l
{
  nq a;
  private WeakReference<np> b;
  private ni c;
  private volatile int d;
  private volatile ExecutorService e;
  
  public nl(np paramnp, nq paramnq)
  {
    AppMethodBeat.i(149493);
    this.d = -1;
    this.e = null;
    if ((paramnp == null) || (paramnp.a() == null))
    {
      AppMethodBeat.o(149493);
      return;
    }
    f localf = paramnp.a().b();
    this.c = ni.a(paramnp.a().i().getApplicationContext());
    this.b = new WeakReference(paramnp);
    this.a = paramnq;
    localf.a(this);
    localf.a(this);
    this.d = localf.e(false);
    AppMethodBeat.o(149493);
  }
  
  private boolean a(String paramString)
  {
    AppMethodBeat.i(149498);
    if ((paramString != null) && (paramString.length() > 0))
    {
      paramString = Pattern.compile("version=\\d+").matcher(paramString);
      if (paramString.find())
      {
        paramString = paramString.group();
        if (Integer.parseInt(paramString.substring(paramString.indexOf("=") + 1)) == nn.c())
        {
          AppMethodBeat.o(149498);
          return true;
        }
        AppMethodBeat.o(149498);
        return false;
      }
    }
    AppMethodBeat.o(149498);
    return false;
  }
  
  private cy b(String paramString)
  {
    AppMethodBeat.i(149499);
    if ((paramString == null) || (paramString.length() == 0))
    {
      AppMethodBeat.o(149499);
      return null;
    }
    int i = paramString.lastIndexOf("foreignLanguage");
    paramString = cy.valueOf(paramString.substring("foreignLanguage".length() + 1 + i));
    AppMethodBeat.o(149499);
    return paramString;
  }
  
  public Bitmap a(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(149495);
    if ((this.b == null) || (this.b.get() == null) || (this.d == -1))
    {
      AppMethodBeat.o(149495);
      return null;
    }
    Object localObject = new be();
    ((be)localObject).a(paramArrayOfByte);
    localObject = new bc(((be)localObject).a(), ((be)localObject).b(), ((be)localObject).c(), 0, this.a.a());
    Bitmap localBitmap = this.c.a((bc)localObject);
    if (localBitmap != null)
    {
      AppMethodBeat.o(149495);
      return localBitmap;
    }
    localObject = this.a.a(((bc)localObject).a(), ((bc)localObject).b(), ((bc)localObject).c());
    if (localObject == null)
    {
      AppMethodBeat.o(149495);
      return null;
    }
    localObject = ((String)localObject).getBytes();
    Arrays.fill(paramArrayOfByte, (byte)0);
    System.arraycopy(localObject, 0, paramArrayOfByte, 0, localObject.length);
    AppMethodBeat.o(149495);
    return null;
  }
  
  public void a(String paramString, byte[] paramArrayOfByte1, byte[] paramArrayOfByte2)
  {
    AppMethodBeat.i(149496);
    if (this.e == null) {}
    try
    {
      if (this.e == null) {
        this.e = Executors.newSingleThreadExecutor();
      }
      if (!this.e.isShutdown()) {
        this.e.execute(new nl.1(this, paramString, paramArrayOfByte1, paramArrayOfByte2));
      }
      AppMethodBeat.o(149496);
      return;
    }
    finally
    {
      AppMethodBeat.o(149496);
    }
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
    AppMethodBeat.i(149494);
    if ((this.b != null) && (this.b.get() != null))
    {
      Object localObject = ((np)this.b.get()).a();
      if ((localObject != null) && (((kx)localObject).b() != null))
      {
        localObject = ((kx)localObject).b();
        ((f)localObject).a(null);
        ((f)localObject).a(null);
        ((f)localObject).i(this.d);
        this.d = -1;
      }
    }
    AppMethodBeat.o(149494);
  }
  
  public void e()
  {
    AppMethodBeat.i(149497);
    if ((this.d != -1) && (this.b != null) && (this.b.get() != null)) {
      ((np)this.b.get()).a().b().j(this.d);
    }
    AppMethodBeat.o(149497);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.tencentmap.mapsdk.maps.a.nl
 * JD-Core Version:    0.7.0.1
 */