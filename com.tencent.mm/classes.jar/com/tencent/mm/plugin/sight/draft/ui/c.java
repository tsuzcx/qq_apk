package com.tencent.mm.plugin.sight.draft.ui;

import android.graphics.Bitmap;
import com.tencent.mm.a.f;
import com.tencent.mm.model.aw;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.sdk.platformtools.d;
import java.lang.ref.WeakReference;

public abstract class c
{
  f<String, Bitmap> qVm = new com.tencent.mm.memory.a.c(24);
  private Bitmap qVn;
  
  private Bitmap cmY()
  {
    if (this.qVn == null) {
      this.qVn = d.Na(2131231843);
    }
    return this.qVn;
  }
  
  public abstract void r(String paramString, Bitmap paramBitmap);
  
  public final Bitmap x(String paramString1, String paramString2, boolean paramBoolean)
  {
    if (bo.isNullOrNil(paramString1)) {
      localObject = cmY();
    }
    Bitmap localBitmap;
    do
    {
      return localObject;
      localBitmap = (Bitmap)this.qVm.get(paramString1);
      localObject = localBitmap;
    } while (localBitmap != null);
    Object localObject = new c.a((byte)0);
    ((c.a)localObject).key = paramString1;
    ((c.a)localObject).path = paramString2;
    ((c.a)localObject).qVo = paramBoolean;
    ((c.a)localObject).qVp = new WeakReference(this);
    if (paramBoolean) {
      aw.RO().ac((Runnable)localObject);
    }
    do
    {
      return cmY();
      ((c.a)localObject).run();
      paramString1 = (Bitmap)this.qVm.get(paramString1);
    } while (paramString1 == null);
    return paramString1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.sight.draft.ui.c
 * JD-Core Version:    0.7.0.1
 */