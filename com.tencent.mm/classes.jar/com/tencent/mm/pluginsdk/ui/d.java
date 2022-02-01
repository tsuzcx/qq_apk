package com.tencent.mm.pluginsdk.ui;

import android.graphics.Bitmap;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.c;
import com.tencent.mm.am.f.a;
import com.tencent.mm.ce.a.a;
import com.tencent.mm.ce.a.a.a;
import com.tencent.mm.sdk.platformtools.BitmapUtil;

public final class d
  extends j
  implements f.a
{
  a RbN;
  int RbO;
  
  public d(String paramString)
  {
    this(paramString, (byte)0);
  }
  
  private d(String paramString, byte paramByte)
  {
    super(new a(a.b.hjf()), paramString, (byte)0);
    AppMethodBeat.i(152121);
    this.RbN = ((a)this.Hix);
    AppMethodBeat.o(152121);
  }
  
  static final class a
    implements j.a
  {
    private j.a Hix;
    c RbP = null;
    Bitmap fgf = null;
    
    public a(j.a parama)
    {
      this.Hix = parama;
    }
    
    private Bitmap bqO(String paramString)
    {
      AppMethodBeat.i(228455);
      if (hjh())
      {
        a locala = a.a.UOn;
        if (locala != null)
        {
          paramString = locala.aNh(bqP(paramString));
          AppMethodBeat.o(228455);
          return paramString;
        }
      }
      AppMethodBeat.o(228455);
      return null;
    }
    
    private String bqP(String paramString)
    {
      AppMethodBeat.i(228464);
      paramString = paramString + "-" + this.RbP.lAe;
      AppMethodBeat.o(228464);
      return paramString;
    }
    
    private boolean hjh()
    {
      return (this.RbP != null) && (this.RbP.lAe > 0.0F);
    }
    
    private void v(String paramString, Bitmap paramBitmap)
    {
      AppMethodBeat.i(228460);
      if ((paramBitmap != null) && (hjh()))
      {
        a locala = a.a.UOn;
        if (locala != null) {
          locala.p(bqP(paramString), paramBitmap);
        }
      }
      AppMethodBeat.o(228460);
    }
    
    public final void a(j paramj)
    {
      AppMethodBeat.i(152120);
      if (this.Hix != null) {
        this.Hix.a(paramj);
      }
      AppMethodBeat.o(152120);
    }
    
    final Bitmap aG(Bitmap paramBitmap)
    {
      AppMethodBeat.i(228453);
      Bitmap localBitmap = paramBitmap;
      if (paramBitmap != null)
      {
        localBitmap = paramBitmap;
        if (!paramBitmap.isRecycled())
        {
          localBitmap = paramBitmap;
          if (hjh()) {
            localBitmap = BitmapUtil.getRoundedCornerBitmap(paramBitmap, false, this.RbP.lAe * paramBitmap.getWidth());
          }
        }
      }
      AppMethodBeat.o(228453);
      return localBitmap;
    }
    
    public final Bitmap aaC()
    {
      AppMethodBeat.i(152119);
      Bitmap localBitmap;
      if ((this.fgf != null) && (!this.fgf.isRecycled()))
      {
        localBitmap = this.fgf;
        AppMethodBeat.o(152119);
        return localBitmap;
      }
      if (this.Hix != null)
      {
        localBitmap = this.Hix.aaC();
        AppMethodBeat.o(152119);
        return localBitmap;
      }
      AppMethodBeat.o(152119);
      return null;
    }
    
    public final Bitmap b(String paramString, int paramInt1, int paramInt2, int paramInt3)
    {
      AppMethodBeat.i(152116);
      Bitmap localBitmap = bqO(paramString);
      if ((localBitmap != null) && (!localBitmap.isRecycled()))
      {
        AppMethodBeat.o(152116);
        return localBitmap;
      }
      if (this.Hix != null) {
        localBitmap = this.Hix.b(paramString, paramInt1, paramInt2, paramInt3);
      }
      localBitmap = aG(localBitmap);
      v(paramString, localBitmap);
      AppMethodBeat.o(152116);
      return localBitmap;
    }
    
    public final Bitmap gJ(String paramString)
    {
      AppMethodBeat.i(152117);
      Bitmap localBitmap = bqO(paramString);
      if ((localBitmap != null) && (!localBitmap.isRecycled()))
      {
        AppMethodBeat.o(152117);
        return localBitmap;
      }
      if (this.RbP != null) {
        localBitmap = com.tencent.mm.am.d.a(paramString, false, -1, this.RbP);
      }
      for (;;)
      {
        localBitmap = aG(localBitmap);
        v(paramString, localBitmap);
        AppMethodBeat.o(152117);
        return localBitmap;
        if (this.Hix != null) {
          localBitmap = this.Hix.gJ(paramString);
        }
      }
    }
    
    public final Bitmap gK(String paramString)
    {
      AppMethodBeat.i(152118);
      Bitmap localBitmap = bqO(paramString);
      if ((localBitmap != null) && (!localBitmap.isRecycled()))
      {
        AppMethodBeat.o(152118);
        return localBitmap;
      }
      if (this.Hix != null)
      {
        paramString = this.Hix.gK(paramString);
        AppMethodBeat.o(152118);
        return paramString;
      }
      AppMethodBeat.o(152118);
      return null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.d
 * JD-Core Version:    0.7.0.1
 */