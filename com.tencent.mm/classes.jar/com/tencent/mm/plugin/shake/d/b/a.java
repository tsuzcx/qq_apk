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
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.sdk.platformtools.f;
import java.io.IOException;

public final class a
  extends BitmapDrawable
  implements u.a
{
  private static final Paint hfD;
  private static Bitmap xzv;
  private int gKi;
  private ImageView qSI;
  private int type;
  private String username;
  private String xzt;
  private s xzu;
  
  static
  {
    AppMethodBeat.i(28358);
    Paint localPaint = new Paint();
    hfD = localPaint;
    localPaint.setAntiAlias(true);
    hfD.setFilterBitmap(true);
    AppMethodBeat.o(28358);
  }
  
  private static Bitmap ap(View paramView, int paramInt)
  {
    AppMethodBeat.i(28355);
    if (paramView == null)
    {
      paramView = xzv;
      AppMethodBeat.o(28355);
      return paramView;
    }
    int i = paramView.getMeasuredWidth();
    int j = paramView.getMeasuredHeight();
    if (((xzv != null) && (xzv.getWidth() == i)) || (paramInt > 0)) {}
    for (;;)
    {
      try
      {
        xzv = f.A(paramView.getResources().getDrawable(paramInt));
        if ((xzv.getWidth() != i) && (i > 0) && (j > 0)) {
          xzv = Bitmap.createScaledBitmap(xzv, i, j, true);
        }
      }
      catch (IOException paramView)
      {
        ac.printErrStackTrace("MicroMsg.ShakeAvatarDrawable", paramView, "", new Object[0]);
        continue;
      }
      paramView = xzv;
      AppMethodBeat.o(28355);
      return paramView;
      xzv = BackwardSupportUtil.b.b(ai.getContext().getAssets().open("avatar/default_nor_avatar.png"), com.tencent.mm.cc.a.getDensity(null));
    }
  }
  
  public static String apw(String paramString)
  {
    AppMethodBeat.i(28357);
    if (bs.isNullOrNil(paramString))
    {
      ac.w("MicroMsg.ShakeAvatarDrawable", "getStoragePath: but url is null");
      AppMethodBeat.o(28357);
      return null;
    }
    String str = i.dDP();
    if (bs.isNullOrNil(str))
    {
      ac.w("MicroMsg.ShakeAvatarDrawable", "getStoragePath, but save dir is null");
      AppMethodBeat.o(28357);
      return null;
    }
    paramString = String.format("%s/%s", new Object[] { str, g.getMessageDigest(paramString.getBytes()) });
    AppMethodBeat.o(28357);
    return paramString;
  }
  
  public final void draw(Canvas paramCanvas)
  {
    AppMethodBeat.i(28354);
    ac.i("MicroMsg.ShakeAvatarDrawable", "album username[%s], url[%s], type[%d], attr[%s]", new Object[] { this.username, this.xzt, Integer.valueOf(this.type), toString() });
    if ((4 != this.type) && ((!k.NN(this.type)) || (6 == this.type)))
    {
      AppMethodBeat.o(28354);
      return;
    }
    Object localObject2 = null;
    Object localObject1;
    if (4 == this.type)
    {
      this.xzu = new a(this.xzt);
      localObject1 = u.a(this.xzu);
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
        ac.i("MicroMsg.ShakeAvatarDrawable", "bm is null or recycled, album url[%s]", new Object[] { this.xzt });
        localObject2 = ap(this.qSI, this.gKi);
      }
      if (localObject2 != null) {
        paramCanvas.drawBitmap((Bitmap)localObject2, null, getBounds(), hfD);
      }
      AppMethodBeat.o(28354);
      return;
      localObject1 = localObject2;
      if (k.NN(this.type))
      {
        localObject1 = localObject2;
        if (6 != this.type)
        {
          this.xzu = new b(this.xzt);
          localObject1 = u.a(this.xzu);
        }
      }
    }
  }
  
  public final void k(String paramString, final Bitmap paramBitmap)
  {
    AppMethodBeat.i(28356);
    ac.i("MicroMsg.ShakeAvatarDrawable", "type[%d] notifyKey[%s] albumUrl[%s]", new Object[] { Integer.valueOf(this.type), paramString, this.xzt });
    if ((this.xzu != null) && (paramString.equals(this.xzu.aNn())) && ((4 == this.type) || ((k.NN(this.type)) && (6 != this.type)))) {
      this.qSI.post(new Runnable()
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
    private String xzt;
    
    public a(String paramString)
    {
      this.xzt = paramString;
    }
    
    public final Bitmap a(Bitmap paramBitmap, s.a parama, String paramString)
    {
      AppMethodBeat.i(28353);
      if (s.a.iuo == parama) {}
      try
      {
        f.a(paramBitmap, 100, Bitmap.CompressFormat.PNG, a.apw(this.xzt), false);
        ac.d("MicroMsg.ShakeAvatarDrawable", "get bitmap, from %s", new Object[] { parama.toString() });
        AppMethodBeat.o(28353);
        return paramBitmap;
      }
      catch (IOException paramString)
      {
        for (;;)
        {
          ac.printErrStackTrace("MicroMsg.ShakeAvatarDrawable", paramString, "", new Object[0]);
          ac.w("MicroMsg.ShakeAvatarDrawable", "save bitmap fail");
        }
      }
    }
    
    public final void a(s.a parama, String paramString) {}
    
    public final s.b aNk()
    {
      return null;
    }
    
    public final String aNl()
    {
      AppMethodBeat.i(28351);
      String str = a.apw(this.xzt);
      AppMethodBeat.o(28351);
      return str;
    }
    
    public final String aNm()
    {
      return this.xzt;
    }
    
    public final String aNn()
    {
      return this.xzt;
    }
    
    public final boolean aNo()
    {
      return true;
    }
    
    public final boolean aNp()
    {
      return false;
    }
    
    public final Bitmap aNq()
    {
      AppMethodBeat.i(28352);
      Bitmap localBitmap = BitmapFactory.decodeResource(ai.getContext().getResources(), 2131233476);
      AppMethodBeat.o(28352);
      return localBitmap;
    }
    
    public final void aNr() {}
    
    public final void aa(String paramString, boolean paramBoolean) {}
    
    public final String getCacheKey()
    {
      return this.xzt;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.shake.d.b.a
 * JD-Core Version:    0.7.0.1
 */