package com.tencent.mm.plugin.sight.draft.ui;

import android.graphics.Bitmap;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R.k;
import com.tencent.mm.b.f;
import com.tencent.mm.model.bh;
import com.tencent.mm.sdk.platformtools.BitmapUtil;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import java.lang.ref.WeakReference;

public abstract class c
{
  f<String, Bitmap> Jup = new com.tencent.mm.memory.a.c(24);
  private Bitmap Juq;
  
  private Bitmap fJa()
  {
    if (this.Juq == null) {
      this.Juq = BitmapUtil.getBitmapNative(R.k.panel_icon_pic);
    }
    return this.Juq;
  }
  
  public final Bitmap B(String paramString1, String paramString2, boolean paramBoolean)
  {
    if (Util.isNullOrNil(paramString1)) {
      localObject = fJa();
    }
    Bitmap localBitmap;
    do
    {
      return localObject;
      localBitmap = (Bitmap)this.Jup.get(paramString1);
      localObject = localBitmap;
    } while (localBitmap != null);
    Object localObject = new a((byte)0);
    ((a)localObject).key = paramString1;
    ((a)localObject).path = paramString2;
    ((a)localObject).Jur = paramBoolean;
    ((a)localObject).Jus = new WeakReference(this);
    if (paramBoolean) {
      bh.aHJ().postToWorker((Runnable)localObject);
    }
    do
    {
      return fJa();
      ((a)localObject).run();
      paramString1 = (Bitmap)this.Jup.get(paramString1);
    } while (paramString1 == null);
    return paramString1;
  }
  
  public abstract void s(String paramString, Bitmap paramBitmap);
  
  static final class a
    implements Runnable
  {
    boolean Jur;
    WeakReference<c> Jus;
    String key;
    String path;
    
    public final void run()
    {
      AppMethodBeat.i(28693);
      Bitmap localBitmap = BitmapUtil.getBitmapNative(this.path);
      Object localObject = (c)this.Jus.get();
      if (localObject != null)
      {
        if ((!Util.isNullOrNil(this.key)) && (localBitmap != null)) {
          ((c)localObject).Jup.put(this.key, localBitmap);
        }
        localObject = new c.b((byte)0);
        ((c.b)localObject).key = this.key;
        ((c.b)localObject).tJN = localBitmap;
        ((c.b)localObject).Jus = this.Jus;
        if (this.Jur) {
          MMHandlerThread.postToMainThread((Runnable)localObject);
        }
      }
      AppMethodBeat.o(28693);
    }
  }
  
  static final class b
    implements Runnable
  {
    WeakReference<c> Jus;
    String key;
    Bitmap tJN;
    
    public final void run()
    {
      AppMethodBeat.i(28694);
      c localc = (c)this.Jus.get();
      if (localc != null) {
        localc.s(this.key, this.tJN);
      }
      AppMethodBeat.o(28694);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.sight.draft.ui.c
 * JD-Core Version:    0.7.0.1
 */