package com.tencent.mm.plugin.radar.ui;

import android.content.Context;
import android.content.res.Resources;
import android.util.DisplayMetrics;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.ell;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/radar/ui/RadarUtils;", "", "()V", "getEncodeUsername", "", "member", "Lcom/tencent/mm/protocal/protobuf/RadarChatRoomMember;", "Lcom/tencent/mm/protocal/protobuf/RadarSearchMember;", "getUsername", "lowerThanXHDPI", "", "context", "Landroid/content/Context;", "plugin-radar_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class d
{
  public static final d Nua;
  
  static
  {
    AppMethodBeat.i(138730);
    Nua = new d();
    AppMethodBeat.o(138730);
  }
  
  public static String a(ell paramell)
  {
    AppMethodBeat.i(138728);
    s.u(paramell, "member");
    String str = paramell.UserName;
    if (str == null)
    {
      paramell = paramell.Zyp;
      if (paramell == null)
      {
        AppMethodBeat.o(138728);
        return "";
      }
      AppMethodBeat.o(138728);
      return paramell;
    }
    AppMethodBeat.o(138728);
    return str;
  }
  
  public static String b(ell paramell)
  {
    Object localObject;
    if (paramell == null) {
      localObject = "";
    }
    do
    {
      String str;
      do
      {
        return localObject;
        str = paramell.Zyp;
        localObject = str;
      } while (str != null);
      paramell = paramell.UserName;
      localObject = paramell;
    } while (paramell != null);
    return "";
  }
  
  public static boolean jn(Context paramContext)
  {
    AppMethodBeat.i(138729);
    s.u(paramContext, "context");
    if (paramContext.getResources().getDisplayMetrics().densityDpi <= 240)
    {
      AppMethodBeat.o(138729);
      return true;
    }
    AppMethodBeat.o(138729);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     com.tencent.mm.plugin.radar.ui.d
 * JD-Core Version:    0.7.0.1
 */