package com.tencent.mm.plugin.radar.ui;

import android.content.Context;
import android.content.res.Resources;
import android.util.DisplayMetrics;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.dsq;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/radar/ui/RadarUtils;", "", "()V", "getEncodeUsername", "", "member", "Lcom/tencent/mm/protocal/protobuf/RadarChatRoomMember;", "Lcom/tencent/mm/protocal/protobuf/RadarSearchMember;", "getUsername", "lowerThanXHDPI", "", "context", "Landroid/content/Context;", "plugin-radar_release"})
public final class g
{
  public static final g Hwt;
  
  static
  {
    AppMethodBeat.i(138730);
    Hwt = new g();
    AppMethodBeat.o(138730);
  }
  
  public static String a(dsq paramdsq)
  {
    AppMethodBeat.i(138728);
    p.k(paramdsq, "member");
    String str = paramdsq.UserName;
    Object localObject = str;
    if (str == null)
    {
      paramdsq = paramdsq.Sxx;
      localObject = paramdsq;
      if (paramdsq == null) {
        localObject = "";
      }
    }
    AppMethodBeat.o(138728);
    return localObject;
  }
  
  public static String b(dsq paramdsq)
  {
    if (paramdsq != null)
    {
      String str = paramdsq.Sxx;
      Object localObject = str;
      if (str == null)
      {
        paramdsq = paramdsq.UserName;
        localObject = paramdsq;
        if (paramdsq == null) {
          localObject = "";
        }
      }
      paramdsq = (dsq)localObject;
      if (localObject != null) {}
    }
    else
    {
      paramdsq = "";
    }
    return paramdsq;
  }
  
  public static boolean hM(Context paramContext)
  {
    AppMethodBeat.i(138729);
    p.k(paramContext, "context");
    paramContext = paramContext.getResources();
    p.j(paramContext, "context.resources");
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