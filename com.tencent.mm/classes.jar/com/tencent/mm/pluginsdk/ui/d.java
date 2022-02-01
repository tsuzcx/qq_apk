package com.tencent.mm.pluginsdk.ui;

import android.graphics.Bitmap;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.aj.b;
import com.tencent.mm.aj.c;
import com.tencent.mm.aj.e.a;
import com.tencent.mm.bx.a.a;
import com.tencent.mm.bx.a.a.a;
import com.tencent.mm.sdk.platformtools.h;

public final class d
  extends j
  implements e.a
{
  private a Fkq;
  private int Fkr;
  
  public d(String paramString)
  {
    this(paramString, (byte)0);
  }
  
  private d(String paramString, byte paramByte)
  {
    super(new a(a.b.ffl()), paramString, (byte)0);
    AppMethodBeat.i(152121);
    this.Fkq = ((a)this.xnS);
    AppMethodBeat.o(152121);
  }
  
  private void aw(Bitmap paramBitmap)
  {
    AppMethodBeat.i(218898);
    if (this.Fkq != null) {
      this.Fkq.ax(paramBitmap);
    }
    AppMethodBeat.o(218898);
  }
  
  public final void Zq(int paramInt)
  {
    AppMethodBeat.i(152122);
    if ((this.Fkr == paramInt) && (this.Fkq != null) && (this.Fkq.ofD != null) && (!this.Fkq.ofD.isRecycled()))
    {
      AppMethodBeat.o(152122);
      return;
    }
    this.Fkr = paramInt;
    aw(h.aaZ(paramInt));
    AppMethodBeat.o(152122);
  }
  
  public final void a(b paramb)
  {
    if (this.Fkq != null) {
      this.Fkq.Fks = paramb;
    }
  }
  
  static final class a
    implements j.a
  {
    b Fks = null;
    Bitmap ofD = null;
    private j.a xnS;
    
    public a(j.a parama)
    {
      this.xnS = parama;
    }
    
    private Bitmap aNQ(String paramString)
    {
      AppMethodBeat.i(218895);
      if (ffn())
      {
        a locala = a.a.InF;
        if (locala != null)
        {
          paramString = locala.apE(aNR(paramString));
          AppMethodBeat.o(218895);
          return paramString;
        }
      }
      AppMethodBeat.o(218895);
      return null;
    }
    
    private String aNR(String paramString)
    {
      AppMethodBeat.i(218897);
      paramString = paramString + "-" + this.Fks.hOS;
      AppMethodBeat.o(218897);
      return paramString;
    }
    
    private Bitmap ay(Bitmap paramBitmap)
    {
      AppMethodBeat.i(218894);
      Bitmap localBitmap = paramBitmap;
      if (paramBitmap != null)
      {
        localBitmap = paramBitmap;
        if (!paramBitmap.isRecycled())
        {
          localBitmap = paramBitmap;
          if (ffn()) {
            localBitmap = h.a(paramBitmap, false, this.Fks.hOS * paramBitmap.getWidth());
          }
        }
      }
      AppMethodBeat.o(218894);
      return localBitmap;
    }
    
    private boolean ffn()
    {
      return (this.Fks != null) && (this.Fks.hOS > 0.0F);
    }
    
    private void v(String paramString, Bitmap paramBitmap)
    {
      AppMethodBeat.i(218896);
      if ((paramBitmap != null) && (ffn()))
      {
        a locala = a.a.InF;
        if (locala != null) {
          locala.p(aNR(paramString), paramBitmap);
        }
      }
      AppMethodBeat.o(218896);
    }
    
    public final Bitmap LT()
    {
      AppMethodBeat.i(152119);
      Bitmap localBitmap;
      if ((this.ofD != null) && (!this.ofD.isRecycled()))
      {
        localBitmap = this.ofD;
        AppMethodBeat.o(152119);
        return localBitmap;
      }
      if (this.xnS != null)
      {
        localBitmap = this.xnS.LT();
        AppMethodBeat.o(152119);
        return localBitmap;
      }
      AppMethodBeat.o(152119);
      return null;
    }
    
    public final Bitmap a(String paramString, int paramInt1, int paramInt2, int paramInt3)
    {
      AppMethodBeat.i(152116);
      Bitmap localBitmap = aNQ(paramString);
      if ((localBitmap != null) && (!localBitmap.isRecycled()))
      {
        AppMethodBeat.o(152116);
        return localBitmap;
      }
      if (this.xnS != null) {
        localBitmap = this.xnS.a(paramString, paramInt1, paramInt2, paramInt3);
      }
      localBitmap = ay(localBitmap);
      v(paramString, localBitmap);
      AppMethodBeat.o(152116);
      return localBitmap;
    }
    
    public final void a(j paramj)
    {
      AppMethodBeat.i(152120);
      if (this.xnS != null) {
        this.xnS.a(paramj);
      }
      AppMethodBeat.o(152120);
    }
    
    public final void ax(Bitmap paramBitmap)
    {
      AppMethodBeat.i(218893);
      this.ofD = paramBitmap;
      this.ofD = ay(this.ofD);
      AppMethodBeat.o(218893);
    }
    
    public final Bitmap fl(String paramString)
    {
      AppMethodBeat.i(152117);
      Bitmap localBitmap = aNQ(paramString);
      if ((localBitmap != null) && (!localBitmap.isRecycled()))
      {
        AppMethodBeat.o(152117);
        return localBitmap;
      }
      if (this.Fks != null) {
        localBitmap = c.a(paramString, false, -1, this.Fks);
      }
      for (;;)
      {
        localBitmap = ay(localBitmap);
        v(paramString, localBitmap);
        AppMethodBeat.o(152117);
        return localBitmap;
        if (this.xnS != null) {
          localBitmap = this.xnS.fl(paramString);
        }
      }
    }
    
    public final Bitmap fm(String paramString)
    {
      AppMethodBeat.i(152118);
      Bitmap localBitmap = aNQ(paramString);
      if ((localBitmap != null) && (!localBitmap.isRecycled()))
      {
        AppMethodBeat.o(152118);
        return localBitmap;
      }
      if (this.xnS != null)
      {
        paramString = this.xnS.fm(paramString);
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