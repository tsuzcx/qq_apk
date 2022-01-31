package com.tencent.mm.plugin.sight.draft.ui;

import android.graphics.Bitmap;
import com.tencent.mm.R.k;
import com.tencent.mm.a.f;
import com.tencent.mm.model.au;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.bk;
import java.lang.ref.WeakReference;

public abstract class c
{
  f<String, Bitmap> ogX = new f(24);
  private Bitmap ogY;
  
  private Bitmap bBy()
  {
    if (this.ogY == null) {
      this.ogY = com.tencent.mm.sdk.platformtools.c.EX(R.k.panel_icon_pic);
    }
    return this.ogY;
  }
  
  public abstract void p(String paramString, Bitmap paramBitmap);
  
  public final Bitmap r(String paramString1, String paramString2, boolean paramBoolean)
  {
    if (bk.bl(paramString1)) {
      localObject = bBy();
    }
    Bitmap localBitmap;
    do
    {
      return localObject;
      localBitmap = (Bitmap)this.ogX.get(paramString1);
      localObject = localBitmap;
    } while (localBitmap != null);
    Object localObject = new c.a((byte)0);
    ((c.a)localObject).key = paramString1;
    ((c.a)localObject).path = paramString2;
    ((c.a)localObject).ogZ = paramBoolean;
    ((c.a)localObject).oha = new WeakReference(this);
    if (paramBoolean) {
      au.DS().O((Runnable)localObject);
    }
    do
    {
      return bBy();
      ((c.a)localObject).run();
      paramString1 = (Bitmap)this.ogX.get(paramString1);
    } while (paramString1 == null);
    return paramString1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.sight.draft.ui.c
 * JD-Core Version:    0.7.0.1
 */