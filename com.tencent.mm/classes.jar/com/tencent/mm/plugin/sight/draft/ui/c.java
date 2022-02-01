package com.tencent.mm.plugin.sight.draft.ui;

import android.graphics.Bitmap;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.b.f;
import com.tencent.mm.model.bg;
import com.tencent.mm.sdk.platformtools.BitmapUtil;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import java.lang.ref.WeakReference;

public abstract class c
{
  f<String, Bitmap> DoK = new com.tencent.mm.memory.a.c(24);
  private Bitmap DoL;
  
  private Bitmap eVX()
  {
    if (this.DoL == null) {
      this.DoL = BitmapUtil.getBitmapNative(2131691311);
    }
    return this.DoL;
  }
  
  public abstract void s(String paramString, Bitmap paramBitmap);
  
  public final Bitmap z(String paramString1, String paramString2, boolean paramBoolean)
  {
    if (Util.isNullOrNil(paramString1)) {
      localObject = eVX();
    }
    Bitmap localBitmap;
    do
    {
      return localObject;
      localBitmap = (Bitmap)this.DoK.get(paramString1);
      localObject = localBitmap;
    } while (localBitmap != null);
    Object localObject = new a((byte)0);
    ((a)localObject).key = paramString1;
    ((a)localObject).path = paramString2;
    ((a)localObject).DoM = paramBoolean;
    ((a)localObject).DoN = new WeakReference(this);
    if (paramBoolean) {
      bg.aAk().postToWorker((Runnable)localObject);
    }
    do
    {
      return eVX();
      ((a)localObject).run();
      paramString1 = (Bitmap)this.DoK.get(paramString1);
    } while (paramString1 == null);
    return paramString1;
  }
  
  static final class a
    implements Runnable
  {
    boolean DoM;
    WeakReference<c> DoN;
    String key;
    String path;
    
    public final void run()
    {
      AppMethodBeat.i(28693);
      Bitmap localBitmap = BitmapUtil.getBitmapNative(this.path);
      Object localObject = (c)this.DoN.get();
      if (localObject != null)
      {
        if ((!Util.isNullOrNil(this.key)) && (localBitmap != null)) {
          ((c)localObject).DoK.put(this.key, localBitmap);
        }
        localObject = new c.b((byte)0);
        ((c.b)localObject).key = this.key;
        ((c.b)localObject).xqp = localBitmap;
        ((c.b)localObject).DoN = this.DoN;
        if (this.DoM) {
          MMHandlerThread.postToMainThread((Runnable)localObject);
        }
      }
      AppMethodBeat.o(28693);
    }
  }
  
  static final class b
    implements Runnable
  {
    WeakReference<c> DoN;
    String key;
    Bitmap xqp;
    
    public final void run()
    {
      AppMethodBeat.i(28694);
      c localc = (c)this.DoN.get();
      if (localc != null) {
        localc.s(this.key, this.xqp);
      }
      AppMethodBeat.o(28694);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.sight.draft.ui.c
 * JD-Core Version:    0.7.0.1
 */