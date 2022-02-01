package com.tencent.mm.pluginsdk.ui;

import android.graphics.Bitmap;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b;
import com.tencent.mm.ak.c;
import com.tencent.mm.ak.e.a;
import com.tencent.mm.by.a.a;
import com.tencent.mm.by.a.a.a;
import com.tencent.mm.sdk.platformtools.g;

public final class d
  extends j
  implements e.a
{
  private a ERV;
  private int ERW;
  
  public d(String paramString)
  {
    this(paramString, (byte)0);
  }
  
  private d(String paramString, byte paramByte)
  {
    super(new a(a.b.fbx()), paramString, (byte)0);
    AppMethodBeat.i(152121);
    this.ERV = ((a)this.wYb);
    AppMethodBeat.o(152121);
  }
  
  private void av(Bitmap paramBitmap)
  {
    AppMethodBeat.i(195445);
    if (this.ERV != null) {
      this.ERV.aw(paramBitmap);
    }
    AppMethodBeat.o(195445);
  }
  
  public final void YK(int paramInt)
  {
    AppMethodBeat.i(152122);
    if ((this.ERW == paramInt) && (this.ERV != null) && (this.ERV.nZT != null) && (!this.ERV.nZT.isRecycled()))
    {
      AppMethodBeat.o(152122);
      return;
    }
    this.ERW = paramInt;
    av(g.aat(paramInt));
    AppMethodBeat.o(152122);
  }
  
  public final void a(b paramb)
  {
    if (this.ERV != null) {
      this.ERV.ERX = paramb;
    }
  }
  
  static final class a
    implements j.a
  {
    b ERX = null;
    Bitmap nZT = null;
    private j.a wYb;
    
    public a(j.a parama)
    {
      this.wYb = parama;
    }
    
    private Bitmap aMu(String paramString)
    {
      AppMethodBeat.i(195442);
      if (fbz())
      {
        a locala = a.a.HTy;
        if (locala != null)
        {
          paramString = locala.aoz(aMv(paramString));
          AppMethodBeat.o(195442);
          return paramString;
        }
      }
      AppMethodBeat.o(195442);
      return null;
    }
    
    private String aMv(String paramString)
    {
      AppMethodBeat.i(195444);
      paramString = paramString + "-" + this.ERX.hLZ;
      AppMethodBeat.o(195444);
      return paramString;
    }
    
    private Bitmap ax(Bitmap paramBitmap)
    {
      AppMethodBeat.i(195441);
      Bitmap localBitmap = paramBitmap;
      if (paramBitmap != null)
      {
        localBitmap = paramBitmap;
        if (!paramBitmap.isRecycled())
        {
          localBitmap = paramBitmap;
          if (fbz()) {
            localBitmap = g.a(paramBitmap, false, this.ERX.hLZ * paramBitmap.getWidth());
          }
        }
      }
      AppMethodBeat.o(195441);
      return localBitmap;
    }
    
    private boolean fbz()
    {
      return (this.ERX != null) && (this.ERX.hLZ > 0.0F);
    }
    
    private void v(String paramString, Bitmap paramBitmap)
    {
      AppMethodBeat.i(195443);
      if ((paramBitmap != null) && (fbz()))
      {
        a locala = a.a.HTy;
        if (locala != null) {
          locala.p(aMv(paramString), paramBitmap);
        }
      }
      AppMethodBeat.o(195443);
    }
    
    public final Bitmap LL()
    {
      AppMethodBeat.i(152119);
      Bitmap localBitmap;
      if ((this.nZT != null) && (!this.nZT.isRecycled()))
      {
        localBitmap = this.nZT;
        AppMethodBeat.o(152119);
        return localBitmap;
      }
      if (this.wYb != null)
      {
        localBitmap = this.wYb.LL();
        AppMethodBeat.o(152119);
        return localBitmap;
      }
      AppMethodBeat.o(152119);
      return null;
    }
    
    public final Bitmap a(String paramString, int paramInt1, int paramInt2, int paramInt3)
    {
      AppMethodBeat.i(152116);
      Bitmap localBitmap = aMu(paramString);
      if ((localBitmap != null) && (!localBitmap.isRecycled()))
      {
        AppMethodBeat.o(152116);
        return localBitmap;
      }
      if (this.wYb != null) {
        localBitmap = this.wYb.a(paramString, paramInt1, paramInt2, paramInt3);
      }
      localBitmap = ax(localBitmap);
      v(paramString, localBitmap);
      AppMethodBeat.o(152116);
      return localBitmap;
    }
    
    public final void a(j paramj)
    {
      AppMethodBeat.i(152120);
      if (this.wYb != null) {
        this.wYb.a(paramj);
      }
      AppMethodBeat.o(152120);
    }
    
    public final void aw(Bitmap paramBitmap)
    {
      AppMethodBeat.i(195440);
      this.nZT = paramBitmap;
      this.nZT = ax(this.nZT);
      AppMethodBeat.o(195440);
    }
    
    public final Bitmap fg(String paramString)
    {
      AppMethodBeat.i(152117);
      Bitmap localBitmap = aMu(paramString);
      if ((localBitmap != null) && (!localBitmap.isRecycled()))
      {
        AppMethodBeat.o(152117);
        return localBitmap;
      }
      if (this.ERX != null) {
        localBitmap = c.a(paramString, false, -1, this.ERX);
      }
      for (;;)
      {
        localBitmap = ax(localBitmap);
        v(paramString, localBitmap);
        AppMethodBeat.o(152117);
        return localBitmap;
        if (this.wYb != null) {
          localBitmap = this.wYb.fg(paramString);
        }
      }
    }
    
    public final Bitmap fh(String paramString)
    {
      AppMethodBeat.i(152118);
      Bitmap localBitmap = aMu(paramString);
      if ((localBitmap != null) && (!localBitmap.isRecycled()))
      {
        AppMethodBeat.o(152118);
        return localBitmap;
      }
      if (this.wYb != null)
      {
        paramString = this.wYb.fh(paramString);
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