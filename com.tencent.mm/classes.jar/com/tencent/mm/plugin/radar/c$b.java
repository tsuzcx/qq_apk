package com.tencent.mm.plugin.radar;

import a.d.b.g;
import a.k;
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

public final class c$b
  implements i.a
{
  private Bitmap bwa;
  private final f<String, WeakReference<Bitmap>> naw = new f(15);
  private Bitmap nkr;
  
  c$b()
  {
    try
    {
      Object localObject1 = ae.getContext();
      g.j(localObject1, "MMApplicationContext.getContext()");
      this.bwa = BackwardSupportUtil.b.a(((Context)localObject1).getAssets().open("avatar/default_nor_avatar.png"), a.getDensity(null));
      localObject1 = this.bwa;
      localObject2 = this.bwa;
      if (localObject2 == null) {
        g.cUk();
      }
      this.nkr = com.tencent.mm.sdk.platformtools.c.a((Bitmap)localObject1, false, ((Bitmap)localObject2).getWidth() / 2);
      return;
    }
    catch (IOException localIOException)
    {
      Object localObject2 = c.nkq;
      y.printErrStackTrace(c.access$getTAG$cp(), (Throwable)localIOException, "", new Object[0]);
    }
  }
  
  public final void a(i parami)
  {
    g.k(parami, "drawable");
    if ((parami instanceof d.a)) {
      o.JQ().a((d.a)parami);
    }
  }
  
  public final Bitmap b(String paramString, int paramInt1, int paramInt2, int paramInt3)
  {
    g.k(paramString, "tag");
    return null;
  }
  
  public final Bitmap ch(String paramString)
  {
    g.k(paramString, "tag");
    Object localObject1 = (WeakReference)this.naw.get(paramString);
    if ((localObject1 != null) && (((WeakReference)localObject1).get() != null))
    {
      Object localObject2 = ((WeakReference)localObject1).get();
      if (localObject2 == null) {
        throw new k("null cannot be cast to non-null type android.graphics.Bitmap");
      }
      if ((!((Bitmap)localObject2).isRecycled()) && (!(g.e((Bitmap)((WeakReference)localObject1).get(), this.bwa) ^ true))) {}
    }
    else
    {
      localObject1 = b.jY(paramString);
      if ((localObject1 == null) || (((Bitmap)localObject1).isRecycled())) {
        return this.nkr;
      }
      localObject1 = com.tencent.mm.sdk.platformtools.c.a((Bitmap)localObject1, false, ((Bitmap)localObject1).getWidth() / 2);
      this.naw.f(paramString, new WeakReference(localObject1));
      return localObject1;
    }
    return (Bitmap)((WeakReference)localObject1).get();
  }
  
  public final Bitmap ci(String paramString)
  {
    g.k(paramString, "tag");
    return null;
  }
  
  public final Bitmap sG()
  {
    return this.bwa;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.radar.c.b
 * JD-Core Version:    0.7.0.1
 */