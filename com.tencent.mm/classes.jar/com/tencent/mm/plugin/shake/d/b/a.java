package com.tencent.mm.plugin.shake.d.b;

import android.content.Context;
import android.content.res.AssetManager;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.drawable.BitmapDrawable;
import android.view.View;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.b.g;
import com.tencent.mm.platformtools.s;
import com.tencent.mm.platformtools.u;
import com.tencent.mm.platformtools.u.a;
import com.tencent.mm.plugin.shake.d.a.i;
import com.tencent.mm.plugin.shake.d.a.k;
import com.tencent.mm.plugin.shake.e.b;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.BitmapFactory;
import com.tencent.mm.sdk.platformtools.BitmapUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import java.io.IOException;

public final class a
  extends BitmapDrawable
  implements u.a
{
  private static Bitmap Djh;
  private static final Paint iuG;
  private String Djf;
  private s Djg;
  private int hZB;
  private ImageView tkI;
  private int type;
  private String username;
  
  static
  {
    AppMethodBeat.i(28358);
    Paint localPaint = new Paint();
    iuG = localPaint;
    localPaint.setAntiAlias(true);
    iuG.setFilterBitmap(true);
    AppMethodBeat.o(28358);
  }
  
  public static String aKj(String paramString)
  {
    AppMethodBeat.i(28357);
    if (Util.isNullOrNil(paramString))
    {
      Log.w("MicroMsg.ShakeAvatarDrawable", "getStoragePath: but url is null");
      AppMethodBeat.o(28357);
      return null;
    }
    String str = i.eUQ();
    if (Util.isNullOrNil(str))
    {
      Log.w("MicroMsg.ShakeAvatarDrawable", "getStoragePath, but save dir is null");
      AppMethodBeat.o(28357);
      return null;
    }
    paramString = String.format("%s/%s", new Object[] { str, g.getMessageDigest(paramString.getBytes()) });
    AppMethodBeat.o(28357);
    return paramString;
  }
  
  private static Bitmap as(View paramView, int paramInt)
  {
    AppMethodBeat.i(28355);
    if (paramView == null)
    {
      paramView = Djh;
      AppMethodBeat.o(28355);
      return paramView;
    }
    int i = paramView.getMeasuredWidth();
    int j = paramView.getMeasuredHeight();
    if (((Djh != null) && (Djh.getWidth() == i)) || (paramInt > 0)) {}
    for (;;)
    {
      try
      {
        Djh = BitmapUtil.transformDrawableToBitmap(paramView.getResources().getDrawable(paramInt));
        if ((Djh.getWidth() != i) && (i > 0) && (j > 0)) {
          Djh = Bitmap.createScaledBitmap(Djh, i, j, true);
        }
      }
      catch (IOException paramView)
      {
        Log.printErrStackTrace("MicroMsg.ShakeAvatarDrawable", paramView, "", new Object[0]);
        continue;
      }
      paramView = Djh;
      AppMethodBeat.o(28355);
      return paramView;
      Djh = BackwardSupportUtil.BitmapFactory.decodeStream(MMApplicationContext.getContext().getAssets().open("avatar/default_nor_avatar.png"), com.tencent.mm.cb.a.getDensity(null));
    }
  }
  
  public final void draw(Canvas paramCanvas)
  {
    AppMethodBeat.i(28354);
    Log.i("MicroMsg.ShakeAvatarDrawable", "album username[%s], url[%s], type[%d], attr[%s]", new Object[] { this.username, this.Djf, Integer.valueOf(this.type), toString() });
    if ((4 != this.type) && ((!k.XA(this.type)) || (6 == this.type)))
    {
      AppMethodBeat.o(28354);
      return;
    }
    Object localObject2 = null;
    Object localObject1;
    if (4 == this.type)
    {
      this.Djg = new a.a(this.Djf);
      localObject1 = u.a(this.Djg);
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
        Log.i("MicroMsg.ShakeAvatarDrawable", "bm is null or recycled, album url[%s]", new Object[] { this.Djf });
        localObject2 = as(this.tkI, this.hZB);
      }
      if (localObject2 != null) {
        paramCanvas.drawBitmap((Bitmap)localObject2, null, getBounds(), iuG);
      }
      AppMethodBeat.o(28354);
      return;
      localObject1 = localObject2;
      if (k.XA(this.type))
      {
        localObject1 = localObject2;
        if (6 != this.type)
        {
          this.Djg = new b(this.Djf);
          localObject1 = u.a(this.Djg);
        }
      }
    }
  }
  
  public final void k(String paramString, final Bitmap paramBitmap)
  {
    AppMethodBeat.i(28356);
    Log.i("MicroMsg.ShakeAvatarDrawable", "type[%d] notifyKey[%s] albumUrl[%s]", new Object[] { Integer.valueOf(this.type), paramString, this.Djf });
    if ((this.Djg != null) && (paramString.equals(this.Djg.blC())) && ((4 == this.type) || ((k.XA(this.type)) && (6 != this.type)))) {
      this.tkI.post(new Runnable()
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
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.shake.d.b.a
 * JD-Core Version:    0.7.0.1
 */