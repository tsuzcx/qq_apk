package com.tencent.mm.pluginsdk.ui;

import android.graphics.Bitmap;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.aj.b;
import com.tencent.mm.aj.e.a;
import com.tencent.mm.bx.a.a;
import com.tencent.mm.bx.a.a.a;
import com.tencent.mm.sdk.platformtools.f;

public final class c
  extends i
  implements e.a
{
  private a DmQ;
  private int DmR;
  
  public c(String paramString)
  {
    this(paramString, (byte)0);
  }
  
  private c(String paramString, byte paramByte)
  {
    super(new a(a.b.eMA()), paramString, (byte)0);
    AppMethodBeat.i(152121);
    this.DmQ = ((a)this.vQR);
    AppMethodBeat.o(152121);
  }
  
  private void at(Bitmap paramBitmap)
  {
    AppMethodBeat.i(192691);
    if (this.DmQ != null) {
      this.DmQ.au(paramBitmap);
    }
    AppMethodBeat.o(192691);
  }
  
  public final void WO(int paramInt)
  {
    AppMethodBeat.i(152122);
    if ((this.DmR == paramInt) && (this.DmQ != null) && (this.DmQ.nyv != null) && (!this.DmQ.nyv.isRecycled()))
    {
      AppMethodBeat.o(152122);
      return;
    }
    this.DmR = paramInt;
    at(f.Yo(paramInt));
    AppMethodBeat.o(152122);
  }
  
  public final void a(b paramb)
  {
    if (this.DmQ != null) {
      this.DmQ.DmS = paramb;
    }
  }
  
  static final class a
    implements i.a
  {
    b DmS = null;
    Bitmap nyv = null;
    private i.a vQR;
    
    public a(i.a parama)
    {
      this.vQR = parama;
    }
    
    private Bitmap aGR(String paramString)
    {
      AppMethodBeat.i(192688);
      if (eMB())
      {
        a locala = a.a.Gik;
        if (locala != null)
        {
          paramString = locala.ajM(aGS(paramString));
          AppMethodBeat.o(192688);
          return paramString;
        }
      }
      AppMethodBeat.o(192688);
      return null;
    }
    
    private String aGS(String paramString)
    {
      AppMethodBeat.i(192690);
      paramString = paramString + "-" + this.DmS.htH;
      AppMethodBeat.o(192690);
      return paramString;
    }
    
    private Bitmap av(Bitmap paramBitmap)
    {
      AppMethodBeat.i(192687);
      Bitmap localBitmap = paramBitmap;
      if (paramBitmap != null)
      {
        localBitmap = paramBitmap;
        if (!paramBitmap.isRecycled())
        {
          localBitmap = paramBitmap;
          if (eMB()) {
            localBitmap = f.a(paramBitmap, false, this.DmS.htH * paramBitmap.getWidth());
          }
        }
      }
      AppMethodBeat.o(192687);
      return localBitmap;
    }
    
    private boolean eMB()
    {
      return (this.DmS != null) && (this.DmS.htH > 0.0F);
    }
    
    private void v(String paramString, Bitmap paramBitmap)
    {
      AppMethodBeat.i(192689);
      if ((paramBitmap != null) && (eMB()))
      {
        a locala = a.a.Gik;
        if (locala != null) {
          locala.p(aGS(paramString), paramBitmap);
        }
      }
      AppMethodBeat.o(192689);
    }
    
    public final Bitmap Kj()
    {
      AppMethodBeat.i(152119);
      Bitmap localBitmap;
      if ((this.nyv != null) && (!this.nyv.isRecycled()))
      {
        localBitmap = this.nyv;
        AppMethodBeat.o(152119);
        return localBitmap;
      }
      if (this.vQR != null)
      {
        localBitmap = this.vQR.Kj();
        AppMethodBeat.o(152119);
        return localBitmap;
      }
      AppMethodBeat.o(152119);
      return null;
    }
    
    public final Bitmap a(String paramString, int paramInt1, int paramInt2, int paramInt3)
    {
      AppMethodBeat.i(152116);
      Bitmap localBitmap = aGR(paramString);
      if ((localBitmap != null) && (!localBitmap.isRecycled()))
      {
        AppMethodBeat.o(152116);
        return localBitmap;
      }
      if (this.vQR != null) {
        localBitmap = this.vQR.a(paramString, paramInt1, paramInt2, paramInt3);
      }
      localBitmap = av(localBitmap);
      v(paramString, localBitmap);
      AppMethodBeat.o(152116);
      return localBitmap;
    }
    
    public final void a(i parami)
    {
      AppMethodBeat.i(152120);
      if (this.vQR != null) {
        this.vQR.a(parami);
      }
      AppMethodBeat.o(152120);
    }
    
    public final void au(Bitmap paramBitmap)
    {
      AppMethodBeat.i(192686);
      this.nyv = paramBitmap;
      this.nyv = av(this.nyv);
      AppMethodBeat.o(192686);
    }
    
    public final Bitmap el(String paramString)
    {
      AppMethodBeat.i(152117);
      Bitmap localBitmap = aGR(paramString);
      if ((localBitmap != null) && (!localBitmap.isRecycled()))
      {
        AppMethodBeat.o(152117);
        return localBitmap;
      }
      if (this.DmS != null) {
        localBitmap = com.tencent.mm.aj.c.a(paramString, false, -1, this.DmS);
      }
      for (;;)
      {
        localBitmap = av(localBitmap);
        v(paramString, localBitmap);
        AppMethodBeat.o(152117);
        return localBitmap;
        if (this.vQR != null) {
          localBitmap = this.vQR.el(paramString);
        }
      }
    }
    
    public final Bitmap em(String paramString)
    {
      AppMethodBeat.i(152118);
      Bitmap localBitmap = aGR(paramString);
      if ((localBitmap != null) && (!localBitmap.isRecycled()))
      {
        AppMethodBeat.o(152118);
        return localBitmap;
      }
      if (this.vQR != null)
      {
        paramString = this.vQR.em(paramString);
        AppMethodBeat.o(152118);
        return paramString;
      }
      AppMethodBeat.o(152118);
      return null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.c
 * JD-Core Version:    0.7.0.1
 */