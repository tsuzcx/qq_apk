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
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.sdk.platformtools.h;
import java.io.IOException;

public final class a
  extends BitmapDrawable
  implements u.a
{
  private static final Paint hAz;
  private static Bitmap zep;
  private int hgH;
  private ImageView rKW;
  private int type;
  private String username;
  private String zen;
  private s zeo;
  
  static
  {
    AppMethodBeat.i(28358);
    Paint localPaint = new Paint();
    hAz = localPaint;
    localPaint.setAntiAlias(true);
    hAz.setFilterBitmap(true);
    AppMethodBeat.o(28358);
  }
  
  private static Bitmap aq(View paramView, int paramInt)
  {
    AppMethodBeat.i(28355);
    if (paramView == null)
    {
      paramView = zep;
      AppMethodBeat.o(28355);
      return paramView;
    }
    int i = paramView.getMeasuredWidth();
    int j = paramView.getMeasuredHeight();
    if (((zep != null) && (zep.getWidth() == i)) || (paramInt > 0)) {}
    for (;;)
    {
      try
      {
        zep = h.B(paramView.getResources().getDrawable(paramInt));
        if ((zep.getWidth() != i) && (i > 0) && (j > 0)) {
          zep = Bitmap.createScaledBitmap(zep, i, j, true);
        }
      }
      catch (IOException paramView)
      {
        ae.printErrStackTrace("MicroMsg.ShakeAvatarDrawable", paramView, "", new Object[0]);
        continue;
      }
      paramView = zep;
      AppMethodBeat.o(28355);
      return paramView;
      zep = BackwardSupportUtil.b.b(ak.getContext().getAssets().open("avatar/default_nor_avatar.png"), com.tencent.mm.cb.a.getDensity(null));
    }
  }
  
  public static String avR(String paramString)
  {
    AppMethodBeat.i(28357);
    if (bu.isNullOrNil(paramString))
    {
      ae.w("MicroMsg.ShakeAvatarDrawable", "getStoragePath: but url is null");
      AppMethodBeat.o(28357);
      return null;
    }
    String str = i.dSP();
    if (bu.isNullOrNil(str))
    {
      ae.w("MicroMsg.ShakeAvatarDrawable", "getStoragePath, but save dir is null");
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
    ae.i("MicroMsg.ShakeAvatarDrawable", "album username[%s], url[%s], type[%d], attr[%s]", new Object[] { this.username, this.zen, Integer.valueOf(this.type), toString() });
    if ((4 != this.type) && ((!k.PX(this.type)) || (6 == this.type)))
    {
      AppMethodBeat.o(28354);
      return;
    }
    Object localObject2 = null;
    Object localObject1;
    if (4 == this.type)
    {
      this.zeo = new a(this.zen);
      localObject1 = u.a(this.zeo);
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
        ae.i("MicroMsg.ShakeAvatarDrawable", "bm is null or recycled, album url[%s]", new Object[] { this.zen });
        localObject2 = aq(this.rKW, this.hgH);
      }
      if (localObject2 != null) {
        paramCanvas.drawBitmap((Bitmap)localObject2, null, getBounds(), hAz);
      }
      AppMethodBeat.o(28354);
      return;
      localObject1 = localObject2;
      if (k.PX(this.type))
      {
        localObject1 = localObject2;
        if (6 != this.type)
        {
          this.zeo = new b(this.zen);
          localObject1 = u.a(this.zeo);
        }
      }
    }
  }
  
  public final void k(String paramString, final Bitmap paramBitmap)
  {
    AppMethodBeat.i(28356);
    ae.i("MicroMsg.ShakeAvatarDrawable", "type[%d] notifyKey[%s] albumUrl[%s]", new Object[] { Integer.valueOf(this.type), paramString, this.zen });
    if ((this.zeo != null) && (paramString.equals(this.zeo.aQX())) && ((4 == this.type) || ((k.PX(this.type)) && (6 != this.type)))) {
      this.rKW.post(new Runnable()
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
    private String zen;
    
    public a(String paramString)
    {
      this.zen = paramString;
    }
    
    public final Bitmap a(Bitmap paramBitmap, s.a parama, String paramString)
    {
      AppMethodBeat.i(28353);
      if (s.a.iQl == parama) {}
      try
      {
        h.a(paramBitmap, 100, Bitmap.CompressFormat.PNG, a.avR(this.zen), false);
        ae.d("MicroMsg.ShakeAvatarDrawable", "get bitmap, from %s", new Object[] { parama.toString() });
        AppMethodBeat.o(28353);
        return paramBitmap;
      }
      catch (IOException paramString)
      {
        for (;;)
        {
          ae.printErrStackTrace("MicroMsg.ShakeAvatarDrawable", paramString, "", new Object[0]);
          ae.w("MicroMsg.ShakeAvatarDrawable", "save bitmap fail");
        }
      }
    }
    
    public final void a(s.a parama, String paramString) {}
    
    public final s.b aQU()
    {
      return null;
    }
    
    public final String aQV()
    {
      AppMethodBeat.i(28351);
      String str = a.avR(this.zen);
      AppMethodBeat.o(28351);
      return str;
    }
    
    public final String aQW()
    {
      return this.zen;
    }
    
    public final String aQX()
    {
      return this.zen;
    }
    
    public final boolean aQY()
    {
      return true;
    }
    
    public final boolean aQZ()
    {
      return false;
    }
    
    public final Bitmap aRa()
    {
      AppMethodBeat.i(28352);
      Bitmap localBitmap = BitmapFactory.decodeResource(ak.getContext().getResources(), 2131233476);
      AppMethodBeat.o(28352);
      return localBitmap;
    }
    
    public final void aRb() {}
    
    public final void aa(String paramString, boolean paramBoolean) {}
    
    public final String getCacheKey()
    {
      return this.zen;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.shake.d.b.a
 * JD-Core Version:    0.7.0.1
 */