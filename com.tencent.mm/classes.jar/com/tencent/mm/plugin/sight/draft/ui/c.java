package com.tencent.mm.plugin.sight.draft.ui;

import android.graphics.Bitmap;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.b.f;
import com.tencent.mm.model.bc;
import com.tencent.mm.sdk.platformtools.ar;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.sdk.platformtools.h;
import java.lang.ref.WeakReference;

public abstract class c
{
  f<String, Bitmap> zjU = new com.tencent.mm.memory.a.c(24);
  private Bitmap zjV;
  
  private Bitmap dTX()
  {
    if (this.zjV == null) {
      this.zjV = h.aaZ(2131691012);
    }
    return this.zjV;
  }
  
  public abstract void s(String paramString, Bitmap paramBitmap);
  
  public final Bitmap x(String paramString1, String paramString2, boolean paramBoolean)
  {
    if (bu.isNullOrNil(paramString1)) {
      localObject = dTX();
    }
    Bitmap localBitmap;
    do
    {
      return localObject;
      localBitmap = (Bitmap)this.zjU.get(paramString1);
      localObject = localBitmap;
    } while (localBitmap != null);
    Object localObject = new a((byte)0);
    ((a)localObject).key = paramString1;
    ((a)localObject).path = paramString2;
    ((a)localObject).zjW = paramBoolean;
    ((a)localObject).zjX = new WeakReference(this);
    if (paramBoolean) {
      bc.ajU().aw((Runnable)localObject);
    }
    do
    {
      return dTX();
      ((a)localObject).run();
      paramString1 = (Bitmap)this.zjU.get(paramString1);
    } while (paramString1 == null);
    return paramString1;
  }
  
  static final class a
    implements Runnable
  {
    String key;
    String path;
    boolean zjW;
    WeakReference<c> zjX;
    
    public final void run()
    {
      AppMethodBeat.i(28693);
      Bitmap localBitmap = h.aRC(this.path);
      Object localObject = (c)this.zjX.get();
      if (localObject != null)
      {
        if ((!bu.isNullOrNil(this.key)) && (localBitmap != null)) {
          ((c)localObject).zjU.put(this.key, localBitmap);
        }
        localObject = new c.b((byte)0);
        ((c.b)localObject).key = this.key;
        ((c.b)localObject).tZb = localBitmap;
        ((c.b)localObject).zjX = this.zjX;
        if (this.zjW) {
          ar.f((Runnable)localObject);
        }
      }
      AppMethodBeat.o(28693);
    }
  }
  
  static final class b
    implements Runnable
  {
    String key;
    Bitmap tZb;
    WeakReference<c> zjX;
    
    public final void run()
    {
      AppMethodBeat.i(28694);
      c localc = (c)this.zjX.get();
      if (localc != null) {
        localc.s(this.key, this.tZb);
      }
      AppMethodBeat.o(28694);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.sight.draft.ui.c
 * JD-Core Version:    0.7.0.1
 */