package com.tencent.mm.pluginsdk.model;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.b.g;
import com.tencent.mm.bl.a.a.a;
import com.tencent.mm.kernel.b;
import com.tencent.mm.kernel.h;
import com.tencent.mm.platformtools.p;
import com.tencent.mm.platformtools.p.a;
import com.tencent.mm.platformtools.p.b;
import com.tencent.mm.plugin.image.d;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;

public final class y
  implements p
{
  public static String bpF(String paramString)
  {
    AppMethodBeat.i(116445);
    if (h.baC().aZN())
    {
      String str = d.fQD();
      StringBuilder localStringBuilder = new StringBuilder();
      h.baC();
      paramString = String.format("%s%s", new Object[] { str, g.getMessageDigest((b.aZs() + paramString).getBytes()) });
      AppMethodBeat.o(116445);
      return paramString;
    }
    AppMethodBeat.o(116445);
    return "";
  }
  
  public final Bitmap a(Bitmap paramBitmap, p.a parama, String paramString)
  {
    AppMethodBeat.i(116449);
    if (p.a.pAS == parama)
    {
      AppMethodBeat.o(116449);
      throw null;
    }
    AppMethodBeat.o(116449);
    return paramBitmap;
  }
  
  public final void a(p.a parama)
  {
    if (parama == p.a.pAS) {
      throw null;
    }
  }
  
  public final p.b bTB()
  {
    return null;
  }
  
  public final String bTC()
  {
    AppMethodBeat.i(116446);
    AppMethodBeat.o(116446);
    throw null;
  }
  
  public final String bTD()
  {
    AppMethodBeat.i(116447);
    AppMethodBeat.o(116447);
    throw null;
  }
  
  public final String bTE()
  {
    throw null;
  }
  
  public final boolean bTF()
  {
    return false;
  }
  
  public final boolean bTG()
  {
    throw null;
  }
  
  public final Bitmap bTH()
  {
    AppMethodBeat.i(116453);
    Bitmap localBitmap = BitmapFactory.decodeResource(MMApplicationContext.getContext().getResources(), a.a.nosdcard_chatting_bg);
    AppMethodBeat.o(116453);
    return localBitmap;
  }
  
  public final void bTI()
  {
    AppMethodBeat.i(116450);
    Util.nowMilliSecond();
    AppMethodBeat.o(116450);
    throw null;
  }
  
  public final void bTJ()
  {
    AppMethodBeat.i(244774);
    Util.nowMilliSecond();
    AppMethodBeat.o(244774);
    throw null;
  }
  
  public final String getCacheKey()
  {
    AppMethodBeat.i(116448);
    new StringBuilder();
    AppMethodBeat.o(116448);
    throw null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.model.y
 * JD-Core Version:    0.7.0.1
 */