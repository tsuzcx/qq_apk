package com.tencent.mm.pluginsdk;

import com.tencent.d.a.a.a.b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ad.i;
import com.tencent.mm.plugin.findersdk.a.cn;
import com.tencent.mm.plugin.sns.ad.i.a;
import com.tencent.mm.plugin.sns.c.e;
import com.tencent.mm.plugin.topstory.a.f;
import com.tencent.mm.pluginsdk.ui.tools.n;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/pluginsdk/BusinessViewHandler;", "", "()V", "Companion", "plugin-biz_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class d
{
  public static final a XNw;
  
  static
  {
    AppMethodBeat.i(124791);
    XNw = new a((byte)0);
    AppMethodBeat.o(124791);
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/pluginsdk/BusinessViewHandler$Companion;", "", "()V", "TAG", "", "handle", "", "businessType", "appid", "extInfo", "openId", "handleEmergencyContact", "", "handleOpenAdCanvas", "handleOpenGameHaoWan", "handleShareToHaoKan", "handleUpdateRoomToOpenImChatroom", "isSameAccount", "plugin-biz_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a
  {
    public static boolean P(String paramString1, String paramString2, String paramString3, String paramString4)
    {
      AppMethodBeat.i(244487);
      if (paramString1 == null)
      {
        AppMethodBeat.o(244487);
        return false;
      }
      boolean bool = n.ps(paramString2, paramString4);
      Log.i("MicroMsg.BusinessViewHandler", "handle businessType=" + paramString1 + ", isSameAccount = " + bool);
      switch (paramString1.hashCode())
      {
      default: 
      case 1783390588: 
        do
        {
          AppMethodBeat.o(244487);
          return false;
        } while (!paramString1.equals("nativeOpenAdCanvas"));
        s.u(paramString1, "businessType");
      }
      for (;;)
      {
        try
        {
          paramString4 = new i(paramString3);
          l = Util.safeParseLong(paramString4.optString("canvasId"));
          str = paramString4.optString("uxInfo");
          paramString4 = a.f(l, paramString2, str);
          a.gN(paramString4, 3);
          Log.i("MicroMsg.BusinessViewHandler", "handleOpenAdCanvas, appid=" + paramString2 + ", bType=" + paramString1 + ", extInfo=" + paramString3);
          bool = Util.isNullOrNil(str);
          if (!bool) {
            if (l != 0L) {
              continue;
            }
          }
        }
        catch (Exception paramString1)
        {
          long l;
          String str;
          Log.e("MicroMsg.BusinessViewHandler", "handleOpenAdCanvas ex", new Object[] { paramString1.getMessage() });
          continue;
        }
        AppMethodBeat.o(244487);
        return true;
        if (!paramString1.equals("nativeShareToGameLive")) {
          break;
        }
        ((b)com.tencent.mm.kernel.h.az(b.class)).gameLiveShare(paramString1, paramString2, paramString3, bool);
        AppMethodBeat.o(244487);
        return true;
        if (!paramString1.equals("nativeEmergencyContact")) {
          break;
        }
        s.u(paramString1, "businessType");
        n.d(paramString1, "testExtMsg", paramString2, -3, "testErrMsg");
        AppMethodBeat.o(244487);
        return true;
        if (!paramString1.equals("nativeShareToHaokan")) {
          break;
        }
        s.u(paramString1, "businessType");
        ((f)com.tencent.mm.kernel.h.ax(f.class)).bi(paramString1, paramString2, paramString3);
        AppMethodBeat.o(244487);
        return true;
        if (!paramString1.equals("nativeUpdateRoomToOpenImChatroom")) {
          break;
        }
        s.u(paramString1, "businessType");
        n.l(paramString1, paramString2, paramString3, bool);
        AppMethodBeat.o(244487);
        return true;
        if (!paramString1.equals("nativeShareToGameHaoWan")) {
          break;
        }
        s.u(paramString1, "businessType");
        ((com.tencent.mm.plugin.game.api.h)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.game.api.h.class)).at(paramString1, paramString2, paramString3);
        AppMethodBeat.o(244487);
        return true;
        if (!paramString1.equals("nativeShareToVideoChannels")) {
          break;
        }
        ((cn)com.tencent.mm.kernel.h.az(cn.class)).sdkShare(paramString1, paramString2, paramString3);
        AppMethodBeat.o(244487);
        return true;
        paramString1 = ((e)com.tencent.mm.kernel.h.ax(e.class)).aWg(str);
        ((e)com.tencent.mm.kernel.h.ax(e.class)).a(l, paramString1, paramString4, 29);
        a.gN(paramString4, 4);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.d
 * JD-Core Version:    0.7.0.1
 */