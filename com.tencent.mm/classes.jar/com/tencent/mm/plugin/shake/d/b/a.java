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
import com.tencent.mm.R.g;
import com.tencent.mm.a.g;
import com.tencent.mm.platformtools.v;
import com.tencent.mm.platformtools.v.a;
import com.tencent.mm.platformtools.v.b;
import com.tencent.mm.platformtools.x;
import com.tencent.mm.platformtools.x.a;
import com.tencent.mm.plugin.shake.d.a.i;
import com.tencent.mm.plugin.shake.d.a.k;
import com.tencent.mm.plugin.shake.e.b;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.b;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.c;
import com.tencent.mm.sdk.platformtools.y;
import java.io.IOException;

public final class a
  extends BitmapDrawable
  implements x.a
{
  private static final Paint dPt;
  private static Bitmap obg;
  private ImageView khQ;
  private int lgC;
  private String obe;
  private v obf;
  private int type;
  private String username;
  
  static
  {
    Paint localPaint = new Paint();
    dPt = localPaint;
    localPaint.setAntiAlias(true);
    dPt.setFilterBitmap(true);
  }
  
  public static String KR(String paramString)
  {
    if (bk.bl(paramString))
    {
      y.w("MicroMsg.ShakeAvatarDrawable", "getStoragePath: but url is null");
      return null;
    }
    String str = i.bAy();
    if (bk.bl(str))
    {
      y.w("MicroMsg.ShakeAvatarDrawable", "getStoragePath, but save dir is null");
      return null;
    }
    return String.format("%s/%s", new Object[] { str, g.o(paramString.getBytes()) });
  }
  
  private static Bitmap O(View paramView, int paramInt)
  {
    if (paramView == null) {
      return obg;
    }
    int i = paramView.getMeasuredWidth();
    int j = paramView.getMeasuredHeight();
    if (((obg != null) && (obg.getWidth() == i)) || (paramInt > 0)) {}
    for (;;)
    {
      try
      {
        obg = c.q(paramView.getResources().getDrawable(paramInt));
        if ((obg.getWidth() != i) && (i > 0) && (j > 0)) {
          obg = Bitmap.createScaledBitmap(obg, i, j, true);
        }
      }
      catch (IOException paramView)
      {
        y.printErrStackTrace("MicroMsg.ShakeAvatarDrawable", paramView, "", new Object[0]);
        continue;
      }
      return obg;
      obg = BackwardSupportUtil.b.a(ae.getContext().getAssets().open("avatar/default_nor_avatar.png"), com.tencent.mm.cb.a.getDensity(null));
    }
  }
  
  public final void draw(Canvas paramCanvas)
  {
    y.i("MicroMsg.ShakeAvatarDrawable", "album username[%s], url[%s], type[%d], attr[%s]", new Object[] { this.username, this.obe, Integer.valueOf(this.type), toString() });
    if ((4 != this.type) && ((!k.xo(this.type)) || (6 == this.type))) {
      return;
    }
    Bitmap localBitmap1;
    if (4 == this.type)
    {
      this.obf = new a(this.obe);
      localBitmap1 = x.a(this.obf);
    }
    for (;;)
    {
      Bitmap localBitmap2;
      if (localBitmap1 != null)
      {
        localBitmap2 = localBitmap1;
        if (!localBitmap1.isRecycled()) {}
      }
      else
      {
        y.i("MicroMsg.ShakeAvatarDrawable", "bm is null or recycled, album url[%s]", new Object[] { this.obe });
        localBitmap2 = O(this.khQ, this.lgC);
      }
      if (localBitmap2 == null) {
        break;
      }
      paramCanvas.drawBitmap(localBitmap2, null, getBounds(), dPt);
      return;
      if ((k.xo(this.type)) && (6 != this.type))
      {
        this.obf = new b(this.obe);
        localBitmap1 = x.a(this.obf);
      }
      else
      {
        localBitmap1 = null;
      }
    }
  }
  
  public final void l(String paramString, final Bitmap paramBitmap)
  {
    y.i("MicroMsg.ShakeAvatarDrawable", "type[%d] notifyKey[%s] albumUrl[%s]", new Object[] { Integer.valueOf(this.type), paramString, this.obe });
    if ((this.obf != null) && (paramString.equals(this.obf.UQ())) && ((4 == this.type) || ((k.xo(this.type)) && (6 != this.type)))) {
      this.khQ.post(new Runnable()
      {
        public final void run()
        {
          a.a(a.this).setImageBitmap(paramBitmap);
        }
      });
    }
  }
  
  private static final class a
    implements v
  {
    private String obe;
    
    public a(String paramString)
    {
      this.obe = paramString;
    }
    
    public final void S(String paramString, boolean paramBoolean) {}
    
    public final v.b UN()
    {
      return null;
    }
    
    public final String UO()
    {
      return a.KR(this.obe);
    }
    
    public final String UP()
    {
      return this.obe;
    }
    
    public final String UQ()
    {
      return this.obe;
    }
    
    public final boolean UR()
    {
      return true;
    }
    
    public final boolean US()
    {
      return false;
    }
    
    public final Bitmap UT()
    {
      return BitmapFactory.decodeResource(ae.getContext().getResources(), R.g.nosdcard_chatting_bg);
    }
    
    public final void UU() {}
    
    public final Bitmap a(Bitmap paramBitmap, v.a parama, String paramString)
    {
      if (v.a.eRD == parama) {}
      try
      {
        c.a(paramBitmap, 100, Bitmap.CompressFormat.PNG, a.KR(this.obe), false);
        y.d("MicroMsg.ShakeAvatarDrawable", "get bitmap, from %s", new Object[] { parama.toString() });
        return paramBitmap;
      }
      catch (IOException paramString)
      {
        for (;;)
        {
          y.printErrStackTrace("MicroMsg.ShakeAvatarDrawable", paramString, "", new Object[0]);
          y.w("MicroMsg.ShakeAvatarDrawable", "save bitmap fail");
        }
      }
    }
    
    public final void a(v.a parama, String paramString) {}
    
    public final String getCacheKey()
    {
      return this.obe;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.shake.d.b.a
 * JD-Core Version:    0.7.0.1
 */