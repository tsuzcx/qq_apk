package com.tencent.mm.pluginsdk;

import com.tencent.c.a.a.a.b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ad.i;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.findersdk.a.ak;
import com.tencent.mm.plugin.sns.ad.h.a;
import com.tencent.mm.plugin.sns.b.e;
import com.tencent.mm.pluginsdk.ui.tools.o;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/pluginsdk/BusinessViewHandler;", "", "()V", "Companion", "plugin-biz_release"})
public final class d
{
  public static final a QRI;
  
  static
  {
    AppMethodBeat.i(124791);
    QRI = new a((byte)0);
    AppMethodBeat.o(124791);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/pluginsdk/BusinessViewHandler$Companion;", "", "()V", "TAG", "", "handle", "", "businessType", "appid", "extInfo", "openId", "handleEmergencyContact", "", "handleOpenAdCanvas", "handleOpenGameHaoWan", "handleShareToHaoKan", "handleUpdateRoomToOpenImChatroom", "isSameAccount", "plugin-biz_release"})
  public static final class a
  {
    public static boolean M(String paramString1, String paramString2, String paramString3, String paramString4)
    {
      AppMethodBeat.i(210807);
      if (paramString1 == null)
      {
        AppMethodBeat.o(210807);
        return false;
      }
      boolean bool = o.nv(paramString2, paramString4);
      Log.i("MicroMsg.BusinessViewHandler", "handle businessType=" + paramString1 + ", isSameAccount = " + bool);
      switch (paramString1.hashCode())
      {
      default: 
      case 1783390588: 
        do
        {
          AppMethodBeat.o(210807);
          return false;
        } while (!paramString1.equals("nativeOpenAdCanvas"));
        p.k(paramString1, "businessType");
      }
      for (;;)
      {
        try
        {
          paramString4 = new i(paramString3);
          l = Util.safeParseLong(paramString4.optString("canvasId"));
          str = paramString4.optString("uxInfo");
          paramString4 = a.e(l, paramString2, str);
          a.fU(paramString4, 3);
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
        AppMethodBeat.o(210807);
        return true;
        if (!paramString1.equals("nativeShareToGameLive")) {
          break;
        }
        ((b)h.ag(b.class)).gameLiveShare(paramString1, paramString2, paramString3);
        AppMethodBeat.o(210807);
        return true;
        if (!paramString1.equals("nativeEmergencyContact")) {
          break;
        }
        p.k(paramString1, "businessType");
        o.d(paramString1, "testExtMsg", paramString2, -3, "testErrMsg");
        AppMethodBeat.o(210807);
        return true;
        if (!paramString1.equals("nativeShareToHaokan")) {
          break;
        }
        p.k(paramString1, "businessType");
        ((com.tencent.mm.plugin.topstory.a.g)h.ae(com.tencent.mm.plugin.topstory.a.g.class)).aQ(paramString1, paramString2, paramString3);
        AppMethodBeat.o(210807);
        return true;
        if (!paramString1.equals("nativeUpdateRoomToOpenImChatroom")) {
          break;
        }
        p.k(paramString1, "businessType");
        o.k(paramString1, paramString2, paramString3, bool);
        AppMethodBeat.o(210807);
        return true;
        if (!paramString1.equals("nativeShareToGameHaoWan")) {
          break;
        }
        p.k(paramString1, "businessType");
        ((com.tencent.mm.plugin.game.api.g)h.ae(com.tencent.mm.plugin.game.api.g.class)).aj(paramString1, paramString2, paramString3);
        AppMethodBeat.o(210807);
        return true;
        if (!paramString1.equals("nativeShareToVideoChannels")) {
          break;
        }
        ((ak)h.ag(ak.class)).sdkShare(paramString1, paramString2, paramString3);
        AppMethodBeat.o(210807);
        return true;
        paramString1 = ((e)h.ae(e.class)).aYm(str);
        ((e)h.ae(e.class)).a(l, paramString1, paramString4, 29);
        a.fU(paramString4, 4);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.d
 * JD-Core Version:    0.7.0.1
 */