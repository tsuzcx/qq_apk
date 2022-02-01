package com.tencent.mm.plugin.profile.ui.tab;

import android.content.res.Resources;
import android.util.DisplayMetrics;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.bfu;
import com.tencent.mm.protocal.protobuf.ph;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import java.util.Iterator;
import java.util.LinkedList;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"dpToPixel", "", "getDpToPixel", "(F)F", "resToPixel", "", "getResToPixel", "(I)I", "findBlockWording", "", "funcFlagBit", "bizProfileV2Resp", "Lcom/tencent/mm/protocal/protobuf/BizProfileV2Resp;", "listBlockWording", "msgListFooterWording", "videoListFooterWording", "app_release"})
public final class a
{
  public static final String a(int paramInt, ph paramph)
  {
    AppMethodBeat.i(230663);
    if (paramph == null)
    {
      AppMethodBeat.o(230663);
      return null;
    }
    if ((paramph.KTf & paramInt) == 0)
    {
      AppMethodBeat.o(230663);
      return null;
    }
    paramph = paramph.KWk;
    if (paramph == null)
    {
      AppMethodBeat.o(230663);
      return null;
    }
    paramph = paramph.iterator();
    while (paramph.hasNext())
    {
      bfu localbfu = (bfu)paramph.next();
      if (localbfu.KTf == paramInt)
      {
        paramph = localbfu.xJH;
        AppMethodBeat.o(230663);
        return paramph;
      }
    }
    AppMethodBeat.o(230663);
    return null;
  }
  
  public static final float eFy()
  {
    AppMethodBeat.i(230662);
    Resources localResources = MMApplicationContext.getResources();
    p.g(localResources, "MMApplicationContext.getResources()");
    float f = localResources.getDisplayMetrics().density;
    AppMethodBeat.o(230662);
    return f * 8.0F + 0.5F;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.profile.ui.tab.a
 * JD-Core Version:    0.7.0.1
 */