package com.tencent.mm.pluginsdk.ui;

import android.graphics.Bitmap;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.aj.b;
import com.tencent.mm.aj.c;
import com.tencent.mm.aj.e.a;
import com.tencent.mm.bx.a.a;
import com.tencent.mm.bx.a.a.a;
import com.tencent.mm.sdk.platformtools.BitmapUtil;

public final class d
  extends j
  implements e.a
{
  a Kbi;
  int Kbj;
  
  public d(String paramString)
  {
    this(paramString, (byte)0);
  }
  
  private d(String paramString, byte paramByte)
  {
    super(new a(a.b.gov()), paramString, (byte)0);
    AppMethodBeat.i(152121);
    this.Kbi = ((a)this.Boe);
    AppMethodBeat.o(152121);
  }
  
  static final class a
    implements j.a
  {
    private j.a Boe;
    b Kbk = null;
    Bitmap pqA = null;
    
    public a(j.a parama)
    {
      this.Boe = parama;
    }
    
    private Bitmap bes(String paramString)
    {
      AppMethodBeat.i(223842);
      if (gox())
      {
        a locala = a.a.NAL;
        if (locala != null)
        {
          paramString = locala.aCX(bet(paramString));
          AppMethodBeat.o(223842);
          return paramString;
        }
      }
      AppMethodBeat.o(223842);
      return null;
    }
    
    private String bet(String paramString)
    {
      AppMethodBeat.i(223844);
      paramString = paramString + "-" + this.Kbk.iJZ;
      AppMethodBeat.o(223844);
      return paramString;
    }
    
    private boolean gox()
    {
      return (this.Kbk != null) && (this.Kbk.iJZ > 0.0F);
    }
    
    private void v(String paramString, Bitmap paramBitmap)
    {
      AppMethodBeat.i(223843);
      if ((paramBitmap != null) && (gox()))
      {
        a locala = a.a.NAL;
        if (locala != null) {
          locala.p(bet(paramString), paramBitmap);
        }
      }
      AppMethodBeat.o(223843);
    }
    
    public final Bitmap Wg()
    {
      AppMethodBeat.i(152119);
      Bitmap localBitmap;
      if ((this.pqA != null) && (!this.pqA.isRecycled()))
      {
        localBitmap = this.pqA;
        AppMethodBeat.o(152119);
        return localBitmap;
      }
      if (this.Boe != null)
      {
        localBitmap = this.Boe.Wg();
        AppMethodBeat.o(152119);
        return localBitmap;
      }
      AppMethodBeat.o(152119);
      return null;
    }
    
    public final Bitmap a(String paramString, int paramInt1, int paramInt2, int paramInt3)
    {
      AppMethodBeat.i(152116);
      Bitmap localBitmap = bes(paramString);
      if ((localBitmap != null) && (!localBitmap.isRecycled()))
      {
        AppMethodBeat.o(152116);
        return localBitmap;
      }
      if (this.Boe != null) {
        localBitmap = this.Boe.a(paramString, paramInt1, paramInt2, paramInt3);
      }
      localBitmap = aJ(localBitmap);
      v(paramString, localBitmap);
      AppMethodBeat.o(152116);
      return localBitmap;
    }
    
    public final void a(j paramj)
    {
      AppMethodBeat.i(152120);
      if (this.Boe != null) {
        this.Boe.a(paramj);
      }
      AppMethodBeat.o(152120);
    }
    
    final Bitmap aJ(Bitmap paramBitmap)
    {
      AppMethodBeat.i(223841);
      Bitmap localBitmap = paramBitmap;
      if (paramBitmap != null)
      {
        localBitmap = paramBitmap;
        if (!paramBitmap.isRecycled())
        {
          localBitmap = paramBitmap;
          if (gox()) {
            localBitmap = BitmapUtil.getRoundedCornerBitmap(paramBitmap, false, this.Kbk.iJZ * paramBitmap.getWidth());
          }
        }
      }
      AppMethodBeat.o(223841);
      return localBitmap;
    }
    
    public final Bitmap fZ(String paramString)
    {
      AppMethodBeat.i(152117);
      Bitmap localBitmap = bes(paramString);
      if ((localBitmap != null) && (!localBitmap.isRecycled()))
      {
        AppMethodBeat.o(152117);
        return localBitmap;
      }
      if (this.Kbk != null) {
        localBitmap = c.a(paramString, false, -1, this.Kbk);
      }
      for (;;)
      {
        localBitmap = aJ(localBitmap);
        v(paramString, localBitmap);
        AppMethodBeat.o(152117);
        return localBitmap;
        if (this.Boe != null) {
          localBitmap = this.Boe.fZ(paramString);
        }
      }
    }
    
    public final Bitmap ga(String paramString)
    {
      AppMethodBeat.i(152118);
      Bitmap localBitmap = bes(paramString);
      if ((localBitmap != null) && (!localBitmap.isRecycled()))
      {
        AppMethodBeat.o(152118);
        return localBitmap;
      }
      if (this.Boe != null)
      {
        paramString = this.Boe.ga(paramString);
        AppMethodBeat.o(152118);
        return paramString;
      }
      AppMethodBeat.o(152118);
      return null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.d
 * JD-Core Version:    0.7.0.1
 */