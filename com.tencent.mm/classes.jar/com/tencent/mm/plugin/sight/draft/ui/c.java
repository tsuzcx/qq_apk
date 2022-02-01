package com.tencent.mm.plugin.sight.draft.ui;

import android.graphics.Bitmap;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.az;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.bt;
import java.lang.ref.WeakReference;

public abstract class c
{
  com.tencent.mm.b.f<String, Bitmap> wtK = new com.tencent.mm.memory.a.c(24);
  private Bitmap wtL;
  
  private Bitmap dqP()
  {
    if (this.wtL == null) {
      this.wtL = com.tencent.mm.sdk.platformtools.f.Wf(2131691012);
    }
    return this.wtL;
  }
  
  public abstract void t(String paramString, Bitmap paramBitmap);
  
  public final Bitmap x(String paramString1, String paramString2, boolean paramBoolean)
  {
    if (bt.isNullOrNil(paramString1)) {
      localObject = dqP();
    }
    Bitmap localBitmap;
    do
    {
      return localObject;
      localBitmap = (Bitmap)this.wtK.get(paramString1);
      localObject = localBitmap;
    } while (localBitmap != null);
    Object localObject = new a((byte)0);
    ((a)localObject).key = paramString1;
    ((a)localObject).path = paramString2;
    ((a)localObject).wtM = paramBoolean;
    ((a)localObject).wtN = new WeakReference(this);
    if (paramBoolean) {
      az.afE().ax((Runnable)localObject);
    }
    do
    {
      return dqP();
      ((a)localObject).run();
      paramString1 = (Bitmap)this.wtK.get(paramString1);
    } while (paramString1 == null);
    return paramString1;
  }
  
  static final class a
    implements Runnable
  {
    String key;
    String path;
    boolean wtM;
    WeakReference<c> wtN;
    
    public final void run()
    {
      AppMethodBeat.i(28693);
      Bitmap localBitmap = com.tencent.mm.sdk.platformtools.f.aFi(this.path);
      Object localObject = (c)this.wtN.get();
      if (localObject != null)
      {
        if ((!bt.isNullOrNil(this.key)) && (localBitmap != null)) {
          ((c)localObject).wtK.put(this.key, localBitmap);
        }
        localObject = new c.b((byte)0);
        ((c.b)localObject).key = this.key;
        ((c.b)localObject).rJR = localBitmap;
        ((c.b)localObject).wtN = this.wtN;
        if (this.wtM) {
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
    Bitmap rJR;
    WeakReference<c> wtN;
    
    public final void run()
    {
      AppMethodBeat.i(28694);
      c localc = (c)this.wtN.get();
      if (localc != null) {
        localc.t(this.key, this.rJR);
      }
      AppMethodBeat.o(28694);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.sight.draft.ui.c
 * JD-Core Version:    0.7.0.1
 */