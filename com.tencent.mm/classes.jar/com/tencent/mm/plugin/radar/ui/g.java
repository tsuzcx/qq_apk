package com.tencent.mm.plugin.radar.ui;

import android.content.Context;
import android.content.res.Resources;
import android.util.DisplayMetrics;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.clf;
import com.tencent.mm.protocal.protobuf.cli;
import d.g.b.k;
import d.l;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/radar/ui/RadarUtils;", "", "()V", "getEncodeUsername", "", "member", "Lcom/tencent/mm/protocal/protobuf/RadarChatRoomMember;", "Lcom/tencent/mm/protocal/protobuf/RadarSearchMember;", "getUsername", "lowerThanXHDPI", "", "context", "Landroid/content/Context;", "plugin-radar_release"})
public final class g
{
  public static final g wdr;
  
  static
  {
    AppMethodBeat.i(138730);
    wdr = new g();
    AppMethodBeat.o(138730);
  }
  
  public static String a(clf paramclf)
  {
    if (paramclf != null)
    {
      String str = paramclf.EyO;
      Object localObject = str;
      if (str == null)
      {
        paramclf = paramclf.ncR;
        localObject = paramclf;
        if (paramclf == null) {
          localObject = "";
        }
      }
      paramclf = (clf)localObject;
      if (localObject != null) {}
    }
    else
    {
      paramclf = "";
    }
    return paramclf;
  }
  
  public static String b(cli paramcli)
  {
    AppMethodBeat.i(138728);
    k.h(paramcli, "member");
    String str = paramcli.ncR;
    Object localObject = str;
    if (str == null)
    {
      paramcli = paramcli.EyO;
      localObject = paramcli;
      if (paramcli == null) {
        localObject = "";
      }
    }
    AppMethodBeat.o(138728);
    return localObject;
  }
  
  public static String c(cli paramcli)
  {
    if (paramcli != null)
    {
      String str = paramcli.EyO;
      Object localObject = str;
      if (str == null)
      {
        paramcli = paramcli.ncR;
        localObject = paramcli;
        if (paramcli == null) {
          localObject = "";
        }
      }
      paramcli = (cli)localObject;
      if (localObject != null) {}
    }
    else
    {
      paramcli = "";
    }
    return paramcli;
  }
  
  public static boolean fS(Context paramContext)
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.radar.ui.g
 * JD-Core Version:    0.7.0.1
 */