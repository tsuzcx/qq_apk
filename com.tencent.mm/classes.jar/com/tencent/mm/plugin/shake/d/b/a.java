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
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.sdk.platformtools.d;
import java.io.IOException;

public final class a
  extends BitmapDrawable
  implements x.a
{
  private static final Paint feS;
  private static Bitmap qPp;
  private ImageView mCy;
  private int nEx;
  private String qPn;
  private v qPo;
  private int type;
  private String username;
  
  static
  {
    AppMethodBeat.i(24688);
    Paint localPaint = new Paint();
    feS = localPaint;
    localPaint.setAntiAlias(true);
    feS.setFilterBitmap(true);
    AppMethodBeat.o(24688);
  }
  
  public static String WX(String paramString)
  {
    AppMethodBeat.i(24687);
    if (bo.isNullOrNil(paramString))
    {
      ab.w("MicroMsg.ShakeAvatarDrawable", "getStoragePath: but url is null");
      AppMethodBeat.o(24687);
      return null;
    }
    String str = i.clS();
    if (bo.isNullOrNil(str))
    {
      ab.w("MicroMsg.ShakeAvatarDrawable", "getStoragePath, but save dir is null");
      AppMethodBeat.o(24687);
      return null;
    }
    paramString = String.format("%s/%s", new Object[] { str, g.w(paramString.getBytes()) });
    AppMethodBeat.o(24687);
    return paramString;
  }
  
  private static Bitmap af(View paramView, int paramInt)
  {
    AppMethodBeat.i(24685);
    if (paramView == null)
    {
      paramView = qPp;
      AppMethodBeat.o(24685);
      return paramView;
    }
    int i = paramView.getMeasuredWidth();
    int j = paramView.getMeasuredHeight();
    if (((qPp != null) && (qPp.getWidth() == i)) || (paramInt > 0)) {}
    for (;;)
    {
      try
      {
        qPp = d.u(paramView.getResources().getDrawable(paramInt));
        if ((qPp.getWidth() != i) && (i > 0) && (j > 0)) {
          qPp = Bitmap.createScaledBitmap(qPp, i, j, true);
        }
      }
      catch (IOException paramView)
      {
        ab.printErrStackTrace("MicroMsg.ShakeAvatarDrawable", paramView, "", new Object[0]);
        continue;
      }
      paramView = qPp;
      AppMethodBeat.o(24685);
      return paramView;
      qPp = BackwardSupportUtil.b.b(ah.getContext().getAssets().open("avatar/default_nor_avatar.png"), com.tencent.mm.cb.a.getDensity(null));
    }
  }
  
  public final void draw(Canvas paramCanvas)
  {
    AppMethodBeat.i(24684);
    ab.i("MicroMsg.ShakeAvatarDrawable", "album username[%s], url[%s], type[%d], attr[%s]", new Object[] { this.username, this.qPn, Integer.valueOf(this.type), toString() });
    if ((4 != this.type) && ((!k.Do(this.type)) || (6 == this.type)))
    {
      AppMethodBeat.o(24684);
      return;
    }
    Object localObject2 = null;
    Object localObject1;
    if (4 == this.type)
    {
      this.qPo = new a(this.qPn);
      localObject1 = x.a(this.qPo);
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
        ab.i("MicroMsg.ShakeAvatarDrawable", "bm is null or recycled, album url[%s]", new Object[] { this.qPn });
        localObject2 = af(this.mCy, this.nEx);
      }
      if (localObject2 != null) {
        paramCanvas.drawBitmap((Bitmap)localObject2, null, getBounds(), feS);
      }
      AppMethodBeat.o(24684);
      return;
      localObject1 = localObject2;
      if (k.Do(this.type))
      {
        localObject1 = localObject2;
        if (6 != this.type)
        {
          this.qPo = new b(this.qPn);
          localObject1 = x.a(this.qPo);
        }
      }
    }
  }
  
  public final void m(String paramString, final Bitmap paramBitmap)
  {
    AppMethodBeat.i(24686);
    ab.i("MicroMsg.ShakeAvatarDrawable", "type[%d] notifyKey[%s] albumUrl[%s]", new Object[] { Integer.valueOf(this.type), paramString, this.qPn });
    if ((this.qPo != null) && (paramString.equals(this.qPo.aop())) && ((4 == this.type) || ((k.Do(this.type)) && (6 != this.type)))) {
      this.mCy.post(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(24680);
          a.a(a.this).setImageBitmap(paramBitmap);
          AppMethodBeat.o(24680);
        }
      });
    }
    AppMethodBeat.o(24686);
  }
  
  static final class a
    implements v
  {
    private String qPn;
    
    public a(String paramString)
    {
      this.qPn = paramString;
    }
    
    public final void W(String paramString, boolean paramBoolean) {}
    
    public final Bitmap a(Bitmap paramBitmap, v.a parama, String paramString)
    {
      AppMethodBeat.i(24683);
      if (v.a.gjx == parama) {}
      try
      {
        d.a(paramBitmap, 100, Bitmap.CompressFormat.PNG, a.WX(this.qPn), false);
        ab.d("MicroMsg.ShakeAvatarDrawable", "get bitmap, from %s", new Object[] { parama.toString() });
        AppMethodBeat.o(24683);
        return paramBitmap;
      }
      catch (IOException paramString)
      {
        for (;;)
        {
          ab.printErrStackTrace("MicroMsg.ShakeAvatarDrawable", paramString, "", new Object[0]);
          ab.w("MicroMsg.ShakeAvatarDrawable", "save bitmap fail");
        }
      }
    }
    
    public final void a(v.a parama, String paramString) {}
    
    public final v.b aom()
    {
      return null;
    }
    
    public final String aon()
    {
      AppMethodBeat.i(24681);
      String str = a.WX(this.qPn);
      AppMethodBeat.o(24681);
      return str;
    }
    
    public final String aoo()
    {
      return this.qPn;
    }
    
    public final String aop()
    {
      return this.qPn;
    }
    
    public final boolean aoq()
    {
      return true;
    }
    
    public final boolean aor()
    {
      return false;
    }
    
    public final Bitmap aos()
    {
      AppMethodBeat.i(24682);
      Bitmap localBitmap = BitmapFactory.decodeResource(ah.getContext().getResources(), 2130839821);
      AppMethodBeat.o(24682);
      return localBitmap;
    }
    
    public final void aot() {}
    
    public final String getCacheKey()
    {
      return this.qPn;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.shake.d.b.a
 * JD-Core Version:    0.7.0.1
 */