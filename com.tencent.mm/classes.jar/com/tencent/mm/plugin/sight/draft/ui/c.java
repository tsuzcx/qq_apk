package com.tencent.mm.plugin.sight.draft.ui;

import android.graphics.Bitmap;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.b.f;
import com.tencent.mm.model.ba;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.sdk.platformtools.g;
import java.lang.ref.WeakReference;

public abstract class c
{
  f<String, Bitmap> yTK = new com.tencent.mm.memory.a.c(24);
  private Bitmap yTL;
  
  private Bitmap dQA()
  {
    if (this.yTL == null) {
      this.yTL = g.aat(2131691012);
    }
    return this.yTL;
  }
  
  public abstract void s(String paramString, Bitmap paramBitmap);
  
  public final Bitmap x(String paramString1, String paramString2, boolean paramBoolean)
  {
    if (bt.isNullOrNil(paramString1)) {
      localObject = dQA();
    }
    Bitmap localBitmap;
    do
    {
      return localObject;
      localBitmap = (Bitmap)this.yTK.get(paramString1);
      localObject = localBitmap;
    } while (localBitmap != null);
    Object localObject = new a((byte)0);
    ((a)localObject).key = paramString1;
    ((a)localObject).path = paramString2;
    ((a)localObject).yTM = paramBoolean;
    ((a)localObject).yTN = new WeakReference(this);
    if (paramBoolean) {
      ba.ajF().ay((Runnable)localObject);
    }
    do
    {
      return dQA();
      ((a)localObject).run();
      paramString1 = (Bitmap)this.yTK.get(paramString1);
    } while (paramString1 == null);
    return paramString1;
  }
  
  static final class a
    implements Runnable
  {
    String key;
    String path;
    boolean yTM;
    WeakReference<c> yTN;
    
    public final void run()
    {
      AppMethodBeat.i(28693);
      Bitmap localBitmap = g.aQf(this.path);
      Object localObject = (c)this.yTN.get();
      if (localObject != null)
      {
        if ((!bt.isNullOrNil(this.key)) && (localBitmap != null)) {
          ((c)localObject).yTK.put(this.key, localBitmap);
        }
        localObject = new c.b((byte)0);
        ((c.b)localObject).key = this.key;
        ((c.b)localObject).tOk = localBitmap;
        ((c.b)localObject).yTN = this.yTN;
        if (this.yTM) {
          aq.f((Runnable)localObject);
        }
      }
      AppMethodBeat.o(28693);
    }
  }
  
  static final class b
    implements Runnable
  {
    String key;
    Bitmap tOk;
    WeakReference<c> yTN;
    
    public final void run()
    {
      AppMethodBeat.i(28694);
      c localc = (c)this.yTN.get();
      if (localc != null) {
        localc.s(this.key, this.tOk);
      }
      AppMethodBeat.o(28694);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.sight.draft.ui.c
 * JD-Core Version:    0.7.0.1
 */