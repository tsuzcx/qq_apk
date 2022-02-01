package com.tencent.mm.plugin.radar.ui;

import android.content.Context;
import android.content.res.Resources;
import android.util.DisplayMetrics;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.diy;
import com.tencent.mm.protocal.protobuf.djb;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/radar/ui/RadarUtils;", "", "()V", "getEncodeUsername", "", "member", "Lcom/tencent/mm/protocal/protobuf/RadarChatRoomMember;", "Lcom/tencent/mm/protocal/protobuf/RadarSearchMember;", "getUsername", "lowerThanXHDPI", "", "context", "Landroid/content/Context;", "plugin-radar_release"})
public final class g
{
  public static final g BAY;
  
  static
  {
    AppMethodBeat.i(138730);
    BAY = new g();
    AppMethodBeat.o(138730);
  }
  
  public static String a(diy paramdiy)
  {
    if (paramdiy != null)
    {
      String str = paramdiy.LuX;
      Object localObject = str;
      if (str == null)
      {
        paramdiy = paramdiy.UserName;
        localObject = paramdiy;
        if (paramdiy == null) {
          localObject = "";
        }
      }
      paramdiy = (diy)localObject;
      if (localObject != null) {}
    }
    else
    {
      paramdiy = "";
    }
    return paramdiy;
  }
  
  public static String b(djb paramdjb)
  {
    AppMethodBeat.i(138728);
    p.h(paramdjb, "member");
    String str = paramdjb.UserName;
    Object localObject = str;
    if (str == null)
    {
      paramdjb = paramdjb.LuX;
      localObject = paramdjb;
      if (paramdjb == null) {
        localObject = "";
      }
    }
    AppMethodBeat.o(138728);
    return localObject;
  }
  
  public static String c(djb paramdjb)
  {
    if (paramdjb != null)
    {
      String str = paramdjb.LuX;
      Object localObject = str;
      if (str == null)
      {
        paramdjb = paramdjb.UserName;
        localObject = paramdjb;
        if (paramdjb == null) {
          localObject = "";
        }
      }
      paramdjb = (djb)localObject;
      if (localObject != null) {}
    }
    else
    {
      paramdjb = "";
    }
    return paramdjb;
  }
  
  public static boolean gM(Context paramContext)
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.radar.ui.g
 * JD-Core Version:    0.7.0.1
 */