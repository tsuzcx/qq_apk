package com.tencent.mm.plugin.radar.ui;

import android.content.Context;
import android.content.res.Resources;
import android.util.DisplayMetrics;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.cqf;
import com.tencent.mm.protocal.protobuf.cqi;
import d.g.b.p;
import d.l;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/radar/ui/RadarUtils;", "", "()V", "getEncodeUsername", "", "member", "Lcom/tencent/mm/protocal/protobuf/RadarChatRoomMember;", "Lcom/tencent/mm/protocal/protobuf/RadarSearchMember;", "getUsername", "lowerThanXHDPI", "", "context", "Landroid/content/Context;", "plugin-radar_release"})
public final class g
{
  public static final g xla;
  
  static
  {
    AppMethodBeat.i(138730);
    xla = new g();
    AppMethodBeat.o(138730);
  }
  
  public static String a(cqf paramcqf)
  {
    if (paramcqf != null)
    {
      String str = paramcqf.GgA;
      Object localObject = str;
      if (str == null)
      {
        paramcqf = paramcqf.nDo;
        localObject = paramcqf;
        if (paramcqf == null) {
          localObject = "";
        }
      }
      paramcqf = (cqf)localObject;
      if (localObject != null) {}
    }
    else
    {
      paramcqf = "";
    }
    return paramcqf;
  }
  
  public static String b(cqi paramcqi)
  {
    AppMethodBeat.i(138728);
    p.h(paramcqi, "member");
    String str = paramcqi.nDo;
    Object localObject = str;
    if (str == null)
    {
      paramcqi = paramcqi.GgA;
      localObject = paramcqi;
      if (paramcqi == null) {
        localObject = "";
      }
    }
    AppMethodBeat.o(138728);
    return localObject;
  }
  
  public static String c(cqi paramcqi)
  {
    if (paramcqi != null)
    {
      String str = paramcqi.GgA;
      Object localObject = str;
      if (str == null)
      {
        paramcqi = paramcqi.nDo;
        localObject = paramcqi;
        if (paramcqi == null) {
          localObject = "";
        }
      }
      paramcqi = (cqi)localObject;
      if (localObject != null) {}
    }
    else
    {
      paramcqi = "";
    }
    return paramcqi;
  }
  
  public static boolean fX(Context paramContext)
  {
    AppMethodBeat.i(138729);
    p.h(paramContext, "context");
    paramContext = paramContext.getResources();
    p.g(paramContext, "context.resources");
    if (paramContext.getDisplayMetrics().densityDpi <= 240)
    {
      AppMethodBeat.o(138729);
      return true;
    }
    AppMethodBeat.o(138729);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.radar.ui.g
 * JD-Core Version:    0.7.0.1
 */