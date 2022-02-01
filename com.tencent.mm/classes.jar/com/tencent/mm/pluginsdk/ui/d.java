package com.tencent.mm.pluginsdk.ui;

import android.graphics.Bitmap;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.by.a.a;
import com.tencent.mm.by.a.a.a;
import com.tencent.mm.modelavatar.AvatarStorage.a;
import com.tencent.mm.modelavatar.c;
import com.tencent.mm.sdk.platformtools.BitmapUtil;

public final class d
  extends j
  implements AvatarStorage.a
{
  a XXS;
  int XXT;
  
  public d(String paramString)
  {
    this(paramString, (byte)0);
  }
  
  private d(String paramString, byte paramByte)
  {
    super(new a(a.b.iKa()), paramString, (byte)0);
    AppMethodBeat.i(152121);
    this.XXS = ((a)this.Ngk);
    AppMethodBeat.o(152121);
  }
  
  static final class a
    implements j.a
  {
    private j.a Ngk;
    c XXU = null;
    Bitmap hkp = null;
    
    public a(j.a parama)
    {
      this.Ngk = parama;
    }
    
    private Bitmap bqD(String paramString)
    {
      AppMethodBeat.i(245097);
      if (iKb())
      {
        a locala = a.a.acjy;
        if (locala != null)
        {
          paramString = locala.aKc(bqE(paramString));
          AppMethodBeat.o(245097);
          return paramString;
        }
      }
      AppMethodBeat.o(245097);
      return null;
    }
    
    private String bqE(String paramString)
    {
      AppMethodBeat.i(245103);
      paramString = paramString + "-" + this.XXU.orF;
      AppMethodBeat.o(245103);
      return paramString;
    }
    
    private boolean iKb()
    {
      return (this.XXU != null) && (this.XXU.orF > 0.0F);
    }
    
    private void v(String paramString, Bitmap paramBitmap)
    {
      AppMethodBeat.i(245100);
      if ((paramBitmap != null) && (iKb()))
      {
        a locala = a.a.acjy;
        if (locala != null) {
          locala.p(bqE(paramString), paramBitmap);
        }
      }
      AppMethodBeat.o(245100);
    }
    
    public final void a(j paramj)
    {
      AppMethodBeat.i(152120);
      if (this.Ngk != null) {
        this.Ngk.a(paramj);
      }
      AppMethodBeat.o(152120);
    }
    
    public final Bitmap aCj()
    {
      AppMethodBeat.i(152119);
      Bitmap localBitmap;
      if ((this.hkp != null) && (!this.hkp.isRecycled()))
      {
        localBitmap = this.hkp;
        AppMethodBeat.o(152119);
        return localBitmap;
      }
      if (this.Ngk != null)
      {
        localBitmap = this.Ngk.aCj();
        AppMethodBeat.o(152119);
        return localBitmap;
      }
      AppMethodBeat.o(152119);
      return null;
    }
    
    final Bitmap aZ(Bitmap paramBitmap)
    {
      AppMethodBeat.i(245108);
      Bitmap localBitmap = paramBitmap;
      if (paramBitmap != null)
      {
        localBitmap = paramBitmap;
        if (!paramBitmap.isRecycled())
        {
          localBitmap = paramBitmap;
          if (iKb()) {
            localBitmap = BitmapUtil.getRoundedCornerBitmap(paramBitmap, false, this.XXU.orF * paramBitmap.getWidth());
          }
        }
      }
      AppMethodBeat.o(245108);
      return localBitmap;
    }
    
    public final Bitmap b(String paramString, int paramInt1, int paramInt2, int paramInt3)
    {
      AppMethodBeat.i(152116);
      Bitmap localBitmap = bqD(paramString);
      if ((localBitmap != null) && (!localBitmap.isRecycled()))
      {
        AppMethodBeat.o(152116);
        return localBitmap;
      }
      if (this.Ngk != null) {
        localBitmap = this.Ngk.b(paramString, paramInt1, paramInt2, paramInt3);
      }
      localBitmap = aZ(localBitmap);
      v(paramString, localBitmap);
      AppMethodBeat.o(152116);
      return localBitmap;
    }
    
    public final Bitmap ik(String paramString)
    {
      AppMethodBeat.i(152118);
      Bitmap localBitmap = bqD(paramString);
      if ((localBitmap != null) && (!localBitmap.isRecycled()))
      {
        AppMethodBeat.o(152118);
        return localBitmap;
      }
      if (this.Ngk != null)
      {
        paramString = this.Ngk.ik(paramString);
        AppMethodBeat.o(152118);
        return paramString;
      }
      AppMethodBeat.o(152118);
      return null;
    }
    
    public final Bitmap loadBitmap(String paramString)
    {
      AppMethodBeat.i(152117);
      Bitmap localBitmap = bqD(paramString);
      if ((localBitmap != null) && (!localBitmap.isRecycled()))
      {
        AppMethodBeat.o(152117);
        return localBitmap;
      }
      if (this.XXU != null) {
        localBitmap = com.tencent.mm.modelavatar.d.a(paramString, false, -1, this.XXU);
      }
      for (;;)
      {
        localBitmap = aZ(localBitmap);
        v(paramString, localBitmap);
        AppMethodBeat.o(152117);
        return localBitmap;
        if (this.Ngk != null) {
          localBitmap = this.Ngk.loadBitmap(paramString);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.d
 * JD-Core Version:    0.7.0.1
 */