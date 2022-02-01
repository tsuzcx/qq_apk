package com.tencent.mm.plugin.sight.draft.ui;

import android.graphics.Bitmap;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.az;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.bs;
import java.lang.ref.WeakReference;

public abstract class c
{
  com.tencent.mm.b.f<String, Bitmap> xFa = new com.tencent.mm.memory.a.c(24);
  private Bitmap xFb;
  
  private Bitmap dEY()
  {
    if (this.xFb == null) {
      this.xFb = com.tencent.mm.sdk.platformtools.f.Yo(2131691012);
    }
    return this.xFb;
  }
  
  public abstract void s(String paramString, Bitmap paramBitmap);
  
  public final Bitmap x(String paramString1, String paramString2, boolean paramBoolean)
  {
    if (bs.isNullOrNil(paramString1)) {
      localObject = dEY();
    }
    Bitmap localBitmap;
    do
    {
      return localObject;
      localBitmap = (Bitmap)this.xFa.get(paramString1);
      localObject = localBitmap;
    } while (localBitmap != null);
    Object localObject = new a((byte)0);
    ((a)localObject).key = paramString1;
    ((a)localObject).path = paramString2;
    ((a)localObject).xFc = paramBoolean;
    ((a)localObject).xFd = new WeakReference(this);
    if (paramBoolean) {
      az.agU().az((Runnable)localObject);
    }
    do
    {
      return dEY();
      ((a)localObject).run();
      paramString1 = (Bitmap)this.xFa.get(paramString1);
    } while (paramString1 == null);
    return paramString1;
  }
  
  static final class a
    implements Runnable
  {
    String key;
    String path;
    boolean xFc;
    WeakReference<c> xFd;
    
    public final void run()
    {
      AppMethodBeat.i(28693);
      Bitmap localBitmap = com.tencent.mm.sdk.platformtools.f.aKz(this.path);
      Object localObject = (c)this.xFd.get();
      if (localObject != null)
      {
        if ((!bs.isNullOrNil(this.key)) && (localBitmap != null)) {
          ((c)localObject).xFa.put(this.key, localBitmap);
        }
        localObject = new c.b((byte)0);
        ((c.b)localObject).key = this.key;
        ((c.b)localObject).sRG = localBitmap;
        ((c.b)localObject).xFd = this.xFd;
        if (this.xFc) {
          ap.f((Runnable)localObject);
        }
      }
      AppMethodBeat.o(28693);
    }
  }
  
  static final class b
    implements Runnable
  {
    String key;
    Bitmap sRG;
    WeakReference<c> xFd;
    
    public final void run()
    {
      AppMethodBeat.i(28694);
      c localc = (c)this.xFd.get();
      if (localc != null) {
        localc.s(this.key, this.sRG);
      }
      AppMethodBeat.o(28694);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.sight.draft.ui.c
 * JD-Core Version:    0.7.0.1
 */