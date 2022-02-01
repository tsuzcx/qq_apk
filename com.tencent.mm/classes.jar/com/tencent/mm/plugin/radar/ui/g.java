package com.tencent.mm.plugin.radar.ui;

import android.content.Context;
import android.content.res.Resources;
import android.util.DisplayMetrics;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.cqz;
import com.tencent.mm.protocal.protobuf.crc;
import d.g.b.p;
import d.l;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/radar/ui/RadarUtils;", "", "()V", "getEncodeUsername", "", "member", "Lcom/tencent/mm/protocal/protobuf/RadarChatRoomMember;", "Lcom/tencent/mm/protocal/protobuf/RadarSearchMember;", "getUsername", "lowerThanXHDPI", "", "context", "Landroid/content/Context;", "plugin-radar_release"})
public final class g
{
  public static final g xAX;
  
  static
  {
    AppMethodBeat.i(138730);
    xAX = new g();
    AppMethodBeat.o(138730);
  }
  
  public static String a(cqz paramcqz)
  {
    if (paramcqz != null)
    {
      String str = paramcqz.Gzj;
      Object localObject = str;
      if (str == null)
      {
        paramcqz = paramcqz.nIJ;
        localObject = paramcqz;
        if (paramcqz == null) {
          localObject = "";
        }
      }
      paramcqz = (cqz)localObject;
      if (localObject != null) {}
    }
    else
    {
      paramcqz = "";
    }
    return paramcqz;
  }
  
  public static String b(crc paramcrc)
  {
    AppMethodBeat.i(138728);
    p.h(paramcrc, "member");
    String str = paramcrc.nIJ;
    Object localObject = str;
    if (str == null)
    {
      paramcrc = paramcrc.Gzj;
      localObject = paramcrc;
      if (paramcrc == null) {
        localObject = "";
      }
    }
    AppMethodBeat.o(138728);
    return localObject;
  }
  
  public static String c(crc paramcrc)
  {
    if (paramcrc != null)
    {
      String str = paramcrc.Gzj;
      Object localObject = str;
      if (str == null)
      {
        paramcrc = paramcrc.nIJ;
        localObject = paramcrc;
        if (paramcrc == null) {
          localObject = "";
        }
      }
      paramcrc = (crc)localObject;
      if (localObject != null) {}
    }
    else
    {
      paramcrc = "";
    }
    return paramcrc;
  }
  
  public static boolean gd(Context paramContext)
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.radar.ui.g
 * JD-Core Version:    0.7.0.1
 */