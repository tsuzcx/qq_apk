package com.tencent.mm.plugin.profile.ui.tab;

import android.content.res.Resources;
import android.util.DisplayMetrics;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.bmu;
import com.tencent.mm.protocal.protobuf.pd;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import java.util.Iterator;
import java.util.LinkedList;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"dpToPixel", "", "getDpToPixel", "(F)F", "resToPixel", "", "getResToPixel", "(I)I", "findBlockWording", "", "funcFlagBit", "bizProfileV2Resp", "Lcom/tencent/mm/protocal/protobuf/BizProfileV2Resp;", "listBlockWording", "msgListFooterWording", "videoListFooterWording", "app_release"})
public final class a
{
  public static final String a(int paramInt, pd parampd)
  {
    AppMethodBeat.i(266146);
    if (parampd == null)
    {
      AppMethodBeat.o(266146);
      return null;
    }
    if ((parampd.RUc & paramInt) == 0)
    {
      AppMethodBeat.o(266146);
      return null;
    }
    parampd = parampd.RXy;
    if (parampd == null)
    {
      AppMethodBeat.o(266146);
      return null;
    }
    parampd = parampd.iterator();
    while (parampd.hasNext())
    {
      bmu localbmu = (bmu)parampd.next();
      if (localbmu.RUc == paramInt)
      {
        parampd = localbmu.CNP;
        AppMethodBeat.o(266146);
        return parampd;
      }
    }
    AppMethodBeat.o(266146);
    return null;
  }
  
  public static final float frs()
  {
    AppMethodBeat.i(266145);
    Resources localResources = MMApplicationContext.getResources();
    p.j(localResources, "MMApplicationContext.getResources()");
    float f = localResources.getDisplayMetrics().density;
    AppMethodBeat.o(266145);
    return f * 8.0F + 0.5F;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.profile.ui.tab.a
 * JD-Core Version:    0.7.0.1
 */