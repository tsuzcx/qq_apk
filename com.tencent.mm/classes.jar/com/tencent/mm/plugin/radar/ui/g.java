package com.tencent.mm.plugin.radar.ui;

import a.f.b.j;
import a.l;
import android.content.Context;
import android.content.res.Resources;
import android.util.DisplayMetrics;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.brd;
import com.tencent.mm.protocal.protobuf.brg;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"Lcom/tencent/mm/plugin/radar/ui/RadarUtils;", "", "()V", "getEncodeUsername", "", "member", "Lcom/tencent/mm/protocal/protobuf/RadarChatRoomMember;", "Lcom/tencent/mm/protocal/protobuf/RadarSearchMember;", "getUsername", "lowerThanXHDPI", "", "context", "Landroid/content/Context;", "plugin-radar_release"})
public final class g
{
  public static final g pSH;
  
  static
  {
    AppMethodBeat.i(103079);
    pSH = new g();
    AppMethodBeat.o(103079);
  }
  
  public static String a(brd parambrd)
  {
    if (parambrd != null)
    {
      String str = parambrd.wSo;
      Object localObject = str;
      if (str == null)
      {
        parambrd = parambrd.jJA;
        localObject = parambrd;
        if (parambrd == null) {
          localObject = "";
        }
      }
      parambrd = (brd)localObject;
      if (localObject != null) {}
    }
    else
    {
      parambrd = "";
    }
    return parambrd;
  }
  
  public static String b(brg parambrg)
  {
    AppMethodBeat.i(103077);
    j.q(parambrg, "member");
    String str = parambrg.jJA;
    Object localObject = str;
    if (str == null)
    {
      parambrg = parambrg.wSo;
      localObject = parambrg;
      if (parambrg == null) {
        localObject = "";
      }
    }
    AppMethodBeat.o(103077);
    return localObject;
  }
  
  public static String c(brg parambrg)
  {
    if (parambrg != null)
    {
      String str = parambrg.wSo;
      Object localObject = str;
      if (str == null)
      {
        parambrg = parambrg.jJA;
        localObject = parambrg;
        if (parambrg == null) {
          localObject = "";
        }
      }
      parambrg = (brg)localObject;
      if (localObject != null) {}
    }
    else
    {
      parambrg = "";
    }
    return parambrg;
  }
  
  public static boolean eM(Context paramContext)
  {
    AppMethodBeat.i(103078);
    j.q(paramContext, "context");
    paramContext = paramContext.getResources();
    j.p(paramContext, "context.resources");
    if (paramContext.getDisplayMetrics().densityDpi <= 240)
    {
      AppMethodBeat.o(103078);
      return true;
    }
    AppMethodBeat.o(103078);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.radar.ui.g
 * JD-Core Version:    0.7.0.1
 */