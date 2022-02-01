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
import java.io.IOException;

public final class a
  extends BitmapDrawable
  implements u.a
{
  private static final Paint hxL;
  private static Bitmap yOf;
  private int hdT;
  private ImageView rCL;
  private int type;
  private String username;
  private String yOd;
  private s yOe;
  
  static
  {
    AppMethodBeat.i(28358);
    Paint localPaint = new Paint();
    hxL = localPaint;
    localPaint.setAntiAlias(true);
    hxL.setFilterBitmap(true);
    AppMethodBeat.o(28358);
  }
  
  private static Bitmap aq(View paramView, int paramInt)
  {
    AppMethodBeat.i(28355);
    if (paramView == null)
    {
      paramView = yOf;
      AppMethodBeat.o(28355);
      return paramView;
    }
    int i = paramView.getMeasuredWidth();
    int j = paramView.getMeasuredHeight();
    if (((yOf != null) && (yOf.getWidth() == i)) || (paramInt > 0)) {}
    for (;;)
    {
      try
      {
        yOf = com.tencent.mm.sdk.platformtools.g.A(paramView.getResources().getDrawable(paramInt));
        if ((yOf.getWidth() != i) && (i > 0) && (j > 0)) {
          yOf = Bitmap.createScaledBitmap(yOf, i, j, true);
        }
      }
      catch (IOException paramView)
      {
        ad.printErrStackTrace("MicroMsg.ShakeAvatarDrawable", paramView, "", new Object[0]);
        continue;
      }
      paramView = yOf;
      AppMethodBeat.o(28355);
      return paramView;
      yOf = BackwardSupportUtil.b.b(aj.getContext().getAssets().open("avatar/default_nor_avatar.png"), com.tencent.mm.cc.a.getDensity(null));
    }
  }
  
  public static String auC(String paramString)
  {
    AppMethodBeat.i(28357);
    if (bt.isNullOrNil(paramString))
    {
      ad.w("MicroMsg.ShakeAvatarDrawable", "getStoragePath: but url is null");
      AppMethodBeat.o(28357);
      return null;
    }
    String str = i.dPs();
    if (bt.isNullOrNil(str))
    {
      ad.w("MicroMsg.ShakeAvatarDrawable", "getStoragePath, but save dir is null");
      AppMethodBeat.o(28357);
      return null;
    }
    paramString = String.format("%s/%s", new Object[] { str, com.tencent.mm.b.g.getMessageDigest(paramString.getBytes()) });
    AppMethodBeat.o(28357);
    return paramString;
  }
  
  public final void draw(Canvas paramCanvas)
  {
    AppMethodBeat.i(28354);
    ad.i("MicroMsg.ShakeAvatarDrawable", "album username[%s], url[%s], type[%d], attr[%s]", new Object[] { this.username, this.yOd, Integer.valueOf(this.type), toString() });
    if ((4 != this.type) && ((!k.Pq(this.type)) || (6 == this.type)))
    {
      AppMethodBeat.o(28354);
      return;
    }
    Object localObject2 = null;
    Object localObject1;
    if (4 == this.type)
    {
      this.yOe = new a(this.yOd);
      localObject1 = u.a(this.yOe);
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
        ad.i("MicroMsg.ShakeAvatarDrawable", "bm is null or recycled, album url[%s]", new Object[] { this.yOd });
        localObject2 = aq(this.rCL, this.hdT);
      }
      if (localObject2 != null) {
        paramCanvas.drawBitmap((Bitmap)localObject2, null, getBounds(), hxL);
      }
      AppMethodBeat.o(28354);
      return;
      localObject1 = localObject2;
      if (k.Pq(this.type))
      {
        localObject1 = localObject2;
        if (6 != this.type)
        {
          this.yOe = new b(this.yOd);
          localObject1 = u.a(this.yOe);
        }
      }
    }
  }
  
  public final void k(String paramString, final Bitmap paramBitmap)
  {
    AppMethodBeat.i(28356);
    ad.i("MicroMsg.ShakeAvatarDrawable", "type[%d] notifyKey[%s] albumUrl[%s]", new Object[] { Integer.valueOf(this.type), paramString, this.yOd });
    if ((this.yOe != null) && (paramString.equals(this.yOe.aQy())) && ((4 == this.type) || ((k.Pq(this.type)) && (6 != this.type)))) {
      this.rCL.post(new Runnable()
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
    private String yOd;
    
    public a(String paramString)
    {
      this.yOd = paramString;
    }
    
    public final Bitmap a(Bitmap paramBitmap, s.a parama, String paramString)
    {
      AppMethodBeat.i(28353);
      if (s.a.iNr == parama) {}
      try
      {
        com.tencent.mm.sdk.platformtools.g.a(paramBitmap, 100, Bitmap.CompressFormat.PNG, a.auC(this.yOd), false);
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
    
    public final boolean aQA()
    {
      return false;
    }
    
    public final Bitmap aQB()
    {
      AppMethodBeat.i(28352);
      Bitmap localBitmap = BitmapFactory.decodeResource(aj.getContext().getResources(), 2131233476);
      AppMethodBeat.o(28352);
      return localBitmap;
    }
    
    public final void aQC() {}
    
    public final s.b aQv()
    {
      return null;
    }
    
    public final String aQw()
    {
      AppMethodBeat.i(28351);
      String str = a.auC(this.yOd);
      AppMethodBeat.o(28351);
      return str;
    }
    
    public final String aQx()
    {
      return this.yOd;
    }
    
    public final String aQy()
    {
      return this.yOd;
    }
    
    public final boolean aQz()
    {
      return true;
    }
    
    public final void aa(String paramString, boolean paramBoolean) {}
    
    public final String getCacheKey()
    {
      return this.yOd;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.shake.d.b.a
 * JD-Core Version:    0.7.0.1
 */