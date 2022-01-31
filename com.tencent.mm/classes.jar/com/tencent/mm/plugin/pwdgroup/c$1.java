package com.tencent.mm.plugin.pwdgroup;

import android.content.Context;
import android.content.res.AssetManager;
import android.graphics.Bitmap;
import com.tencent.mm.a.f;
import com.tencent.mm.ag.b;
import com.tencent.mm.ag.d;
import com.tencent.mm.ag.d.a;
import com.tencent.mm.ag.o;
import com.tencent.mm.cb.a;
import com.tencent.mm.pluginsdk.ui.i;
import com.tencent.mm.pluginsdk.ui.i.a;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.b;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.y;
import java.io.IOException;
import java.lang.ref.WeakReference;

final class c$1
  implements i.a
{
  private Bitmap bwa = null;
  private f<String, WeakReference<Bitmap>> naw;
  
  c$1(c paramc)
  {
    try
    {
      this.bwa = BackwardSupportUtil.b.a(ae.getContext().getAssets().open("avatar/default_nor_avatar.png"), a.getDensity(null));
      this.naw = new f(15);
      return;
    }
    catch (IOException paramc)
    {
      for (;;)
      {
        y.printErrStackTrace("MicroMsg.Facing.SubCorePwdGroup", paramc, "", new Object[0]);
      }
    }
  }
  
  public final void a(i parami)
  {
    if ((parami instanceof d.a)) {
      o.JQ().a((d.a)parami);
    }
  }
  
  public final Bitmap b(String paramString, int paramInt1, int paramInt2, int paramInt3)
  {
    return null;
  }
  
  public final Bitmap ch(String paramString)
  {
    Object localObject = (WeakReference)this.naw.get(paramString);
    if ((localObject == null) || (((WeakReference)localObject).get() == null) || (((Bitmap)((WeakReference)localObject).get()).isRecycled()) || (((WeakReference)localObject).get() != this.bwa))
    {
      localObject = b.a(paramString, false, -1);
      if ((localObject == null) || (((Bitmap)localObject).isRecycled())) {
        return this.bwa;
      }
      this.naw.f(paramString, new WeakReference(localObject));
      return localObject;
    }
    return (Bitmap)((WeakReference)localObject).get();
  }
  
  public final Bitmap ci(String paramString)
  {
    return null;
  }
  
  public final Bitmap sG()
  {
    return this.bwa;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.pwdgroup.c.1
 * JD-Core Version:    0.7.0.1
 */