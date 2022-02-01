package com.tencent.mm.plugin.shake.d.b;

import android.content.Context;
import android.content.res.AssetManager;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.drawable.BitmapDrawable;
import android.view.View;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.b.g;
import com.tencent.mm.platformtools.s;
import com.tencent.mm.platformtools.s.a;
import com.tencent.mm.platformtools.s.b;
import com.tencent.mm.platformtools.u;
import com.tencent.mm.platformtools.u.a;
import com.tencent.mm.plugin.shake.d.a.i;
import com.tencent.mm.plugin.shake.d.a.k;
import com.tencent.mm.plugin.shake.e.b;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.b;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.sdk.platformtools.f;
import java.io.IOException;

public final class a
  extends BitmapDrawable
  implements u.a
{
  private static final Paint gFc;
  private static Bitmap woe;
  private int gjx;
  private ImageView qkg;
  private int type;
  private String username;
  private String woc;
  private s wod;
  
  static
  {
    AppMethodBeat.i(28358);
    Paint localPaint = new Paint();
    gFc = localPaint;
    localPaint.setAntiAlias(true);
    gFc.setFilterBitmap(true);
    AppMethodBeat.o(28358);
  }
  
  public static String akx(String paramString)
  {
    AppMethodBeat.i(28357);
    if (bt.isNullOrNil(paramString))
    {
      ad.w("MicroMsg.ShakeAvatarDrawable", "getStoragePath: but url is null");
      AppMethodBeat.o(28357);
      return null;
    }
    String str = i.dpF();
    if (bt.isNullOrNil(str))
    {
      ad.w("MicroMsg.ShakeAvatarDrawable", "getStoragePath, but save dir is null");
      AppMethodBeat.o(28357);
      return null;
    }
    paramString = String.format("%s/%s", new Object[] { str, g.getMessageDigest(paramString.getBytes()) });
    AppMethodBeat.o(28357);
    return paramString;
  }
  
  private static Bitmap ao(View paramView, int paramInt)
  {
    AppMethodBeat.i(28355);
    if (paramView == null)
    {
      paramView = woe;
      AppMethodBeat.o(28355);
      return paramView;
    }
    int i = paramView.getMeasuredWidth();
    int j = paramView.getMeasuredHeight();
    if (((woe != null) && (woe.getWidth() == i)) || (paramInt > 0)) {}
    for (;;)
    {
      try
      {
        woe = f.B(paramView.getResources().getDrawable(paramInt));
        if ((woe.getWidth() != i) && (i > 0) && (j > 0)) {
          woe = Bitmap.createScaledBitmap(woe, i, j, true);
        }
      }
      catch (IOException paramView)
      {
        ad.printErrStackTrace("MicroMsg.ShakeAvatarDrawable", paramView, "", new Object[0]);
        continue;
      }
      paramView = woe;
      AppMethodBeat.o(28355);
      return paramView;
      woe = BackwardSupportUtil.b.b(aj.getContext().getAssets().open("avatar/default_nor_avatar.png"), com.tencent.mm.cd.a.getDensity(null));
    }
  }
  
  public final void draw(Canvas paramCanvas)
  {
    AppMethodBeat.i(28354);
    ad.i("MicroMsg.ShakeAvatarDrawable", "album username[%s], url[%s], type[%d], attr[%s]", new Object[] { this.username, this.woc, Integer.valueOf(this.type), toString() });
    if ((4 != this.type) && ((!k.LN(this.type)) || (6 == this.type)))
    {
      AppMethodBeat.o(28354);
      return;
    }
    Object localObject2 = null;
    Object localObject1;
    if (4 == this.type)
    {
      this.wod = new a(this.woc);
      localObject1 = u.a(this.wod);
    }
    for (;;)
    {
      if (localObject1 != null)
      {
        localObject2 = localObject1;
        if (!((Bitmap)localObject1).isRecycled()) {}
      }
      else
      {
        ad.i("MicroMsg.ShakeAvatarDrawable", "bm is null or recycled, album url[%s]", new Object[] { this.woc });
        localObject2 = ao(this.qkg, this.gjx);
      }
      if (localObject2 != null) {
        paramCanvas.drawBitmap((Bitmap)localObject2, null, getBounds(), gFc);
      }
      AppMethodBeat.o(28354);
      return;
      localObject1 = localObject2;
      if (k.LN(this.type))
      {
        localObject1 = localObject2;
        if (6 != this.type)
        {
          this.wod = new b(this.woc);
          localObject1 = u.a(this.wod);
        }
      }
    }
  }
  
  public final void l(String paramString, final Bitmap paramBitmap)
  {
    AppMethodBeat.i(28356);
    ad.i("MicroMsg.ShakeAvatarDrawable", "type[%d] notifyKey[%s] albumUrl[%s]", new Object[] { Integer.valueOf(this.type), paramString, this.woc });
    if ((this.wod != null) && (paramString.equals(this.wod.aGA())) && ((4 == this.type) || ((k.LN(this.type)) && (6 != this.type)))) {
      this.qkg.post(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(28350);
          a.a(a.this).setImageBitmap(paramBitmap);
          AppMethodBeat.o(28350);
        }
      });
    }
    AppMethodBeat.o(28356);
  }
  
  static final class a
    implements s
  {
    private String woc;
    
    public a(String paramString)
    {
      this.woc = paramString;
    }
    
    public final void Z(String paramString, boolean paramBoolean) {}
    
    public final Bitmap a(Bitmap paramBitmap, s.a parama, String paramString)
    {
      AppMethodBeat.i(28353);
      if (s.a.hUk == parama) {}
      try
      {
        f.a(paramBitmap, 100, Bitmap.CompressFormat.PNG, a.akx(this.woc), false);
        ad.d("MicroMsg.ShakeAvatarDrawable", "get bitmap, from %s", new Object[] { parama.toString() });
        AppMethodBeat.o(28353);
        return paramBitmap;
      }
      catch (IOException paramString)
      {
        for (;;)
        {
          ad.printErrStackTrace("MicroMsg.ShakeAvatarDrawable", paramString, "", new Object[0]);
          ad.w("MicroMsg.ShakeAvatarDrawable", "save bitmap fail");
        }
      }
    }
    
    public final void a(s.a parama, String paramString) {}
    
    public final String aGA()
    {
      return this.woc;
    }
    
    public final boolean aGB()
    {
      return true;
    }
    
    public final boolean aGC()
    {
      return false;
    }
    
    public final Bitmap aGD()
    {
      AppMethodBeat.i(28352);
      Bitmap localBitmap = BitmapFactory.decodeResource(aj.getContext().getResources(), 2131233476);
      AppMethodBeat.o(28352);
      return localBitmap;
    }
    
    public final void aGE() {}
    
    public final s.b aGx()
    {
      return null;
    }
    
    public final String aGy()
    {
      AppMethodBeat.i(28351);
      String str = a.akx(this.woc);
      AppMethodBeat.o(28351);
      return str;
    }
    
    public final String aGz()
    {
      return this.woc;
    }
    
    public final String getCacheKey()
    {
      return this.woc;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.shake.d.b.a
 * JD-Core Version:    0.7.0.1
 */