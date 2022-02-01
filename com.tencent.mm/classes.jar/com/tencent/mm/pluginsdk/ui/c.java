package com.tencent.mm.pluginsdk.ui;

import android.graphics.Bitmap;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b;
import com.tencent.mm.ak.e.a;
import com.tencent.mm.by.a.a;
import com.tencent.mm.by.a.a.a;
import com.tencent.mm.sdk.platformtools.f;

public final class c
  extends i
  implements e.a
{
  private a BUA;
  private int BUB;
  
  public c(String paramString)
  {
    this(paramString, (byte)0);
  }
  
  private c(String paramString, byte paramByte)
  {
    super(new a(a.b.exg()), paramString, (byte)0);
    AppMethodBeat.i(152121);
    this.BUA = ((a)this.uIa);
    AppMethodBeat.o(152121);
  }
  
  private void ar(Bitmap paramBitmap)
  {
    AppMethodBeat.i(190787);
    if (this.BUA != null) {
      this.BUA.as(paramBitmap);
    }
    AppMethodBeat.o(190787);
  }
  
  public final void UE(int paramInt)
  {
    AppMethodBeat.i(152122);
    if ((this.BUB == paramInt) && (this.BUA != null) && (this.BUA.mVW != null) && (!this.BUA.mVW.isRecycled()))
    {
      AppMethodBeat.o(152122);
      return;
    }
    this.BUB = paramInt;
    ar(f.Wf(paramInt));
    AppMethodBeat.o(152122);
  }
  
  public final void a(b paramb)
  {
    if (this.BUA != null) {
      this.BUA.BUC = paramb;
    }
  }
  
  static final class a
    implements i.a
  {
    b BUC = null;
    Bitmap mVW = null;
    private i.a uIa;
    
    public a(i.a parama)
    {
      this.uIa = parama;
    }
    
    private String aBA(String paramString)
    {
      AppMethodBeat.i(190786);
      paramString = paramString + "-" + this.BUC.gTi;
      AppMethodBeat.o(190786);
      return paramString;
    }
    
    private Bitmap aBz(String paramString)
    {
      AppMethodBeat.i(190784);
      if (exh())
      {
        a locala = a.a.EKY;
        if (locala != null)
        {
          paramString = locala.aeS(aBA(paramString));
          AppMethodBeat.o(190784);
          return paramString;
        }
      }
      AppMethodBeat.o(190784);
      return null;
    }
    
    private Bitmap at(Bitmap paramBitmap)
    {
      AppMethodBeat.i(190783);
      Bitmap localBitmap = paramBitmap;
      if (paramBitmap != null)
      {
        localBitmap = paramBitmap;
        if (!paramBitmap.isRecycled())
        {
          localBitmap = paramBitmap;
          if (exh()) {
            localBitmap = f.a(paramBitmap, false, this.BUC.gTi * paramBitmap.getWidth());
          }
        }
      }
      AppMethodBeat.o(190783);
      return localBitmap;
    }
    
    private boolean exh()
    {
      return (this.BUC != null) && (this.BUC.gTi > 0.0F);
    }
    
    private void w(String paramString, Bitmap paramBitmap)
    {
      AppMethodBeat.i(190785);
      if ((paramBitmap != null) && (exh()))
      {
        a locala = a.a.EKY;
        if (locala != null) {
          locala.q(aBA(paramString), paramBitmap);
        }
      }
      AppMethodBeat.o(190785);
    }
    
    public final Bitmap Ky()
    {
      AppMethodBeat.i(152119);
      Bitmap localBitmap;
      if ((this.mVW != null) && (!this.mVW.isRecycled()))
      {
        localBitmap = this.mVW;
        AppMethodBeat.o(152119);
        return localBitmap;
      }
      if (this.uIa != null)
      {
        localBitmap = this.uIa.Ky();
        AppMethodBeat.o(152119);
        return localBitmap;
      }
      AppMethodBeat.o(152119);
      return null;
    }
    
    public final Bitmap a(String paramString, int paramInt1, int paramInt2, int paramInt3)
    {
      AppMethodBeat.i(152116);
      Bitmap localBitmap = aBz(paramString);
      if ((localBitmap != null) && (!localBitmap.isRecycled()))
      {
        AppMethodBeat.o(152116);
        return localBitmap;
      }
      if (this.uIa != null) {
        localBitmap = this.uIa.a(paramString, paramInt1, paramInt2, paramInt3);
      }
      localBitmap = at(localBitmap);
      w(paramString, localBitmap);
      AppMethodBeat.o(152116);
      return localBitmap;
    }
    
    public final void a(i parami)
    {
      AppMethodBeat.i(152120);
      if (this.uIa != null) {
        this.uIa.a(parami);
      }
      AppMethodBeat.o(152120);
    }
    
    public final void as(Bitmap paramBitmap)
    {
      AppMethodBeat.i(190782);
      this.mVW = paramBitmap;
      this.mVW = at(this.mVW);
      AppMethodBeat.o(190782);
    }
    
    public final Bitmap ew(String paramString)
    {
      AppMethodBeat.i(152117);
      Bitmap localBitmap = aBz(paramString);
      if ((localBitmap != null) && (!localBitmap.isRecycled()))
      {
        AppMethodBeat.o(152117);
        return localBitmap;
      }
      if (this.BUC != null) {
        localBitmap = com.tencent.mm.ak.c.a(paramString, false, -1, this.BUC);
      }
      for (;;)
      {
        localBitmap = at(localBitmap);
        w(paramString, localBitmap);
        AppMethodBeat.o(152117);
        return localBitmap;
        if (this.uIa != null) {
          localBitmap = this.uIa.ew(paramString);
        }
      }
    }
    
    public final Bitmap ex(String paramString)
    {
      AppMethodBeat.i(152118);
      Bitmap localBitmap = aBz(paramString);
      if ((localBitmap != null) && (!localBitmap.isRecycled()))
      {
        AppMethodBeat.o(152118);
        return localBitmap;
      }
      if (this.uIa != null)
      {
        paramString = this.uIa.ex(paramString);
        AppMethodBeat.o(152118);
        return paramString;
      }
      AppMethodBeat.o(152118);
      return null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.c
 * JD-Core Version:    0.7.0.1
 */