package com.tencent.mm.plugin.radar.ui;

import android.content.Context;
import android.content.res.Resources;
import android.util.DisplayMetrics;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.cgc;
import com.tencent.mm.protocal.protobuf.cgf;
import d.g.b.k;
import d.l;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/radar/ui/RadarUtils;", "", "()V", "getEncodeUsername", "", "member", "Lcom/tencent/mm/protocal/protobuf/RadarChatRoomMember;", "Lcom/tencent/mm/protocal/protobuf/RadarSearchMember;", "getUsername", "lowerThanXHDPI", "", "context", "Landroid/content/Context;", "plugin-radar_release"})
public final class g
{
  public static final g uUC;
  
  static
  {
    AppMethodBeat.i(138730);
    uUC = new g();
    AppMethodBeat.o(138730);
  }
  
  public static String a(cgc paramcgc)
  {
    if (paramcgc != null)
    {
      String str = paramcgc.DfI;
      Object localObject = str;
      if (str == null)
      {
        paramcgc = paramcgc.mAQ;
        localObject = paramcgc;
        if (paramcgc == null) {
          localObject = "";
        }
      }
      paramcgc = (cgc)localObject;
      if (localObject != null) {}
    }
    else
    {
      paramcgc = "";
    }
    return paramcgc;
  }
  
  public static String b(cgf paramcgf)
  {
    AppMethodBeat.i(138728);
    k.h(paramcgf, "member");
    String str = paramcgf.mAQ;
    Object localObject = str;
    if (str == null)
    {
      paramcgf = paramcgf.DfI;
      localObject = paramcgf;
      if (paramcgf == null) {
        localObject = "";
      }
    }
    AppMethodBeat.o(138728);
    return localObject;
  }
  
  public static String c(cgf paramcgf)
  {
    if (paramcgf != null)
    {
      String str = paramcgf.DfI;
      Object localObject = str;
      if (str == null)
      {
        paramcgf = paramcgf.mAQ;
        localObject = paramcgf;
        if (paramcgf == null) {
          localObject = "";
        }
      }
      paramcgf = (cgf)localObject;
      if (localObject != null) {}
    }
    else
    {
      paramcgf = "";
    }
    return paramcgf;
  }
  
  public static boolean fH(Context paramContext)
  {
    AppMethodBeat.i(138729);
    k.h(paramContext, "context");
    paramContext = paramContext.getResources();
    k.g(paramContext, "context.resources");
    if (paramContext.getDisplayMetrics().densityDpi <= 240)
    {
      AppMethodBeat.o(138729);
      return true;
    }
    AppMethodBeat.o(138729);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.radar.ui.g
 * JD-Core Version:    0.7.0.1
 */