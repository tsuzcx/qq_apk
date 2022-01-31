package com.tencent.mm.view.footer;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import com.tencent.mm.api.d;
import com.tencent.mm.bo.a.g;
import com.tencent.mm.bt.b;

public final class c
  extends a
{
  private Bitmap wyy;
  private Bitmap wyz;
  
  public c(Context paramContext, b paramb)
  {
    super(paramContext, paramb);
  }
  
  protected final boolean IS(int paramInt)
  {
    boolean bool = super.IS(paramInt);
    switch (c.1.soJ[IR(paramInt).ordinal()])
    {
    default: 
      return bool;
    }
    return false;
  }
  
  protected final Bitmap a(d paramd, boolean paramBoolean)
  {
    Bitmap localBitmap = null;
    if (paramd == d.buQ)
    {
      if (paramBoolean) {
        localBitmap = this.wyz;
      }
    }
    else {
      return localBitmap;
    }
    return this.wyy;
  }
  
  protected final void cLD()
  {
    super.cLD();
    this.wyy = com.tencent.mm.sdk.platformtools.c.q(getResources().getDrawable(a.g.crop_video_unselected));
    this.wyz = com.tencent.mm.sdk.platformtools.c.q(getResources().getDrawable(a.g.crop_video_selected));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.view.footer.c
 * JD-Core Version:    0.7.0.1
 */