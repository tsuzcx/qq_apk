package com.tencent.mm.pluginsdk.model;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.b.g;
import com.tencent.mm.bt.a.a.a;
import com.tencent.mm.kernel.b;
import com.tencent.mm.kernel.h;
import com.tencent.mm.platformtools.s;
import com.tencent.mm.platformtools.s.a;
import com.tencent.mm.platformtools.s.b;
import com.tencent.mm.plugin.image.d;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;

public final class w
  implements s
{
  public static String bpO(String paramString)
  {
    AppMethodBeat.i(116445);
    if (h.aHE().aGM())
    {
      String str = d.eIC();
      StringBuilder localStringBuilder = new StringBuilder();
      h.aHE();
      paramString = String.format("%s%s", new Object[] { str, g.getMessageDigest((b.aGq() + paramString).getBytes()) });
      AppMethodBeat.o(116445);
      return paramString;
    }
    AppMethodBeat.o(116445);
    return "";
  }
  
  public final Bitmap a(Bitmap paramBitmap, s.a parama, String paramString)
  {
    AppMethodBeat.i(116449);
    if (s.a.mEp == parama)
    {
      AppMethodBeat.o(116449);
      throw null;
    }
    AppMethodBeat.o(116449);
    return paramBitmap;
  }
  
  public final void a(s.a parama)
  {
    if (parama == s.a.mEp) {
      throw null;
    }
  }
  
  public final s.b bvp()
  {
    return null;
  }
  
  public final String bvq()
  {
    AppMethodBeat.i(116446);
    AppMethodBeat.o(116446);
    throw null;
  }
  
  public final String bvr()
  {
    AppMethodBeat.i(116447);
    AppMethodBeat.o(116447);
    throw null;
  }
  
  public final String bvs()
  {
    throw null;
  }
  
  public final boolean bvt()
  {
    return false;
  }
  
  public final Bitmap bvu()
  {
    AppMethodBeat.i(116453);
    Bitmap localBitmap = BitmapFactory.decodeResource(MMApplicationContext.getContext().getResources(), a.a.nosdcard_chatting_bg);
    AppMethodBeat.o(116453);
    return localBitmap;
  }
  
  public final void bvv()
  {
    AppMethodBeat.i(116450);
    Util.nowMilliSecond();
    AppMethodBeat.o(116450);
    throw null;
  }
  
  public final void bvw()
  {
    AppMethodBeat.i(196865);
    Util.nowMilliSecond();
    AppMethodBeat.o(196865);
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
 * Qualified Name:     com.tencent.mm.pluginsdk.model.w
 * JD-Core Version:    0.7.0.1
 */