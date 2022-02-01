package com.tencent.mm.plugin.profile.ui.tab;

import android.content.res.Resources;
import android.util.DisplayMetrics;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.cao;
import com.tencent.mm.protocal.protobuf.qm;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import java.util.Iterator;
import java.util.LinkedList;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"dpToPixel", "", "getDpToPixel", "(F)F", "resToPixel", "", "getResToPixel", "(I)I", "findBlockWording", "", "funcFlagBit", "bizProfileV2Resp", "Lcom/tencent/mm/protocal/protobuf/BizProfileV2Resp;", "listBlockWording", "msgListFooterWording", "videoListFooterWording", "app_release"}, k=2, mv={1, 5, 1}, xi=48)
public final class a
{
  public static final String a(int paramInt, qm paramqm)
  {
    AppMethodBeat.i(305882);
    if (paramqm == null)
    {
      AppMethodBeat.o(305882);
      return null;
    }
    if ((paramqm.YRD & paramInt) == 0)
    {
      AppMethodBeat.o(305882);
      return null;
    }
    paramqm = paramqm.YVr;
    if (paramqm == null)
    {
      AppMethodBeat.o(305882);
      return null;
    }
    paramqm = paramqm.iterator();
    while (paramqm.hasNext())
    {
      cao localcao = (cao)paramqm.next();
      if (localcao.YRD == paramInt)
      {
        paramqm = localcao.IHZ;
        AppMethodBeat.o(305882);
        return paramqm;
      }
    }
    AppMethodBeat.o(305882);
    return null;
  }
  
  public static final String b(qm paramqm)
  {
    AppMethodBeat.i(305876);
    paramqm = a(4, paramqm);
    AppMethodBeat.o(305876);
    return paramqm;
  }
  
  public static final float gCw()
  {
    AppMethodBeat.i(305872);
    float f = MMApplicationContext.getResources().getDisplayMetrics().density;
    AppMethodBeat.o(305872);
    return f * 8.0F + 0.5F;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.profile.ui.tab.a
 * JD-Core Version:    0.7.0.1
 */