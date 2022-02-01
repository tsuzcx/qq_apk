package com.tencent.mm.plugin.multitalk.e;

import android.graphics.Paint;
import android.graphics.Rect;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.deviceinfo.af;
import com.tencent.mm.compatible.deviceinfo.k;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.expt.b.c.a;
import com.tencent.mm.plugin.multitalk.c.j;
import com.tencent.mm.plugin.multitalk.c.o;
import com.tencent.mm.plugin.multitalk.model.ac;
import com.tencent.mm.plugin.multitalk.model.p;
import com.tencent.mm.pluginsdk.e.b;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MultiProcessMMKV;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.pb.common.b.a.a.a.ba;
import com.tencent.pb.talkroom.sdk.MultiTalkGroup;
import com.tencent.wecall.talkroom.model.TalkRoom;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/multitalk/utils/MultitalkUtils;", "", "()V", "ENCODE_MAX_VOLUME_USER", "", "KV_NAME", "", "LINK_TO_NET_CHANGE_SETTING_COST_MAX", "LINK_TO_NET_CHANGE_SETTING_NET_TIP", "SCREEN_PROJECT_HAS_BEEN_EDUCATED", "TAG", "applyScreenProjectionHasBeenEducate", "", "canReceiveScreenCast", "", "checkFileScreenUseFuncDoodle", "checkMultitalkBlackBoardProjectCanUse", "checkMultitalkSDKApply", "checkMultitalkScreenProjectCanUse", "checkScreenProjectionHasBeenEducate", "getLocalConfigNavPopWording", "getMMKV", "Lcom/tencent/mm/sdk/platformtools/MultiProcessMMKV;", "getMemberId", "username", "getMulitalkMemberListSizeWording", "getMultitalkMaxLimitedNumber", "getMultitalkScreenCastTitle", "getMultitalkWaitingAcceptWording", "getProjectFpsSetting", "getScreenCastTitleContent", "context", "Landroid/content/Context;", "nickName", "getTextWidth", "content", "textPix", "", "screenCastUseHW", "plugin-multitalk_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class f
{
  public static final f LAR;
  
  static
  {
    AppMethodBeat.i(178995);
    LAR = new f();
    AppMethodBeat.o(178995);
  }
  
  private static MultiProcessMMKV aBP()
  {
    AppMethodBeat.i(284618);
    MultiProcessMMKV localMultiProcessMMKV = MultiProcessMMKV.getMMKV("mmkv_screen_project_info");
    s.s(localMultiProcessMMKV, "getMMKV(KV_NAME)");
    AppMethodBeat.o(284618);
    return localMultiProcessMMKV;
  }
  
  public static final int aNL(String paramString)
  {
    int j = -1;
    AppMethodBeat.i(178994);
    int i = j;
    Object localObject;
    if (!Util.isNullOrNil(paramString))
    {
      i = j;
      if (ac.ggS().Lol != null)
      {
        localObject = ac.ggS().Lol.LiU;
        if (!ac.ggS().aNe((String)localObject)) {
          break label74;
        }
        paramString = o.Ljn.LiH.aMF(paramString);
        if (paramString == null) {
          break label141;
        }
        i = paramString.wTC;
      }
    }
    for (;;)
    {
      AppMethodBeat.o(178994);
      return i;
      label74:
      localObject = com.tencent.wecall.talkroom.model.c.ked().bGE((String)localObject);
      i = j;
      if (localObject != null)
      {
        localObject = ((TalkRoom)localObject).kdY().iterator();
        a.ba localba;
        do
        {
          i = j;
          if (!((Iterator)localObject).hasNext()) {
            break;
          }
          localba = (a.ba)((Iterator)localObject).next();
        } while (!s.p(localba.hJs, paramString));
        i = localba.wTC;
        continue;
        label141:
        i = -1;
      }
    }
  }
  
  public static final int giS()
  {
    AppMethodBeat.i(178993);
    int i = ((com.tencent.mm.plugin.expt.b.c)h.ax(com.tencent.mm.plugin.expt.b.c.class)).a(c.a.zoc, e.b.XNy);
    AppMethodBeat.o(178993);
    return i;
  }
  
  public static final boolean giT()
  {
    AppMethodBeat.i(284620);
    boolean bool = aBP().getBoolean("screen_project_has_been_educated", false);
    AppMethodBeat.o(284620);
    return bool;
  }
  
  public static final void giU()
  {
    AppMethodBeat.i(284623);
    aBP().putBoolean("screen_project_has_been_educated", true);
    AppMethodBeat.o(284623);
  }
  
  public static final int giV()
  {
    AppMethodBeat.i(284628);
    int i;
    switch (af.lYj.lUM)
    {
    case 0: 
    default: 
      i = ((com.tencent.mm.plugin.expt.b.c)h.ax(com.tencent.mm.plugin.expt.b.c.class)).a(c.a.zsY, 0);
      AppMethodBeat.o(284628);
      return i;
    case -1: 
      i = ((com.tencent.mm.plugin.expt.b.c)h.ax(com.tencent.mm.plugin.expt.b.c.class)).a(c.a.zsY, 0);
      AppMethodBeat.o(284628);
      return i;
    case 2: 
      AppMethodBeat.o(284628);
      return 0;
    }
    AppMethodBeat.o(284628);
    return 1;
  }
  
  public static final boolean giW()
  {
    AppMethodBeat.i(284634);
    boolean bool = ((com.tencent.mm.plugin.expt.b.c)h.ax(com.tencent.mm.plugin.expt.b.c.class)).a(c.a.znQ, false);
    AppMethodBeat.o(284634);
    return bool;
  }
  
  public static final boolean giX()
  {
    AppMethodBeat.i(284643);
    if (!BuildInfo.IS_ARM64)
    {
      AppMethodBeat.o(284643);
      return false;
    }
    boolean bool;
    switch (af.lYj.lUL)
    {
    case 0: 
    default: 
      bool = ((com.tencent.mm.plugin.expt.b.c)h.ax(com.tencent.mm.plugin.expt.b.c.class)).a(c.a.zod, false);
      AppMethodBeat.o(284643);
      return bool;
    case -1: 
      if ((BuildInfo.IS_FLAVOR_RED) || (BuildInfo.DEBUG))
      {
        AppMethodBeat.o(284643);
        return true;
      }
      bool = ((com.tencent.mm.plugin.expt.b.c)h.ax(com.tencent.mm.plugin.expt.b.c.class)).a(c.a.zod, false);
      AppMethodBeat.o(284643);
      return bool;
    case 2: 
      AppMethodBeat.o(284643);
      return false;
    }
    AppMethodBeat.o(284643);
    return true;
  }
  
  public static final int giY()
  {
    AppMethodBeat.i(284648);
    int i = ((com.tencent.mm.plugin.expt.b.c)h.ax(com.tencent.mm.plugin.expt.b.c.class)).a(c.a.zog, 5);
    AppMethodBeat.o(284648);
    return i;
  }
  
  public static boolean giZ()
  {
    AppMethodBeat.i(284662);
    boolean bool;
    switch (af.lYj.lUL)
    {
    case 0: 
    default: 
      bool = ((com.tencent.mm.plugin.expt.b.c)h.ax(com.tencent.mm.plugin.expt.b.c.class)).a(c.a.zof, true);
      AppMethodBeat.o(284662);
      return bool;
    case -1: 
      if ((BuildInfo.IS_FLAVOR_RED) || (BuildInfo.DEBUG))
      {
        AppMethodBeat.o(284662);
        return true;
      }
      bool = ((com.tencent.mm.plugin.expt.b.c)h.ax(com.tencent.mm.plugin.expt.b.c.class)).a(c.a.zof, true);
      AppMethodBeat.o(284662);
      return bool;
    case 2: 
      AppMethodBeat.o(284662);
      return false;
    }
    AppMethodBeat.o(284662);
    return true;
  }
  
  public static boolean gja()
  {
    AppMethodBeat.i(284665);
    if (((com.tencent.mm.plugin.expt.b.c)h.ax(com.tencent.mm.plugin.expt.b.c.class)).a(c.a.zoh, 0) == 1)
    {
      AppMethodBeat.o(284665);
      return true;
    }
    AppMethodBeat.o(284665);
    return false;
  }
  
  public static String gjb()
  {
    AppMethodBeat.i(284671);
    String str = gjd();
    if (!Util.isNullOrNil(str)) {
      try
      {
        str = new com.tencent.mm.ad.i(str).optString("screen_cast_title");
        AppMethodBeat.o(284671);
        return str;
      }
      catch (Exception localException)
      {
        Log.printErrStackTrace("MicroMsg.MultitalkUtils", (Throwable)localException, "getMultitalkWaitingAcceptWording error", new Object[0]);
      }
    }
    AppMethodBeat.o(284671);
    return null;
  }
  
  public static final String gjc()
  {
    AppMethodBeat.i(284676);
    String str = gjd();
    if (!Util.isNullOrNil(str)) {
      try
      {
        str = new com.tencent.mm.ad.i(str).optString("waiting");
        AppMethodBeat.o(284676);
        return str;
      }
      catch (Exception localException)
      {
        Log.printErrStackTrace("MicroMsg.MultitalkUtils", (Throwable)localException, "getMultitalkWaitingAcceptWording error", new Object[0]);
      }
    }
    AppMethodBeat.o(284676);
    return null;
  }
  
  private static String gjd()
  {
    AppMethodBeat.i(284682);
    Object localObject = ((com.tencent.mm.plugin.expt.b.c)h.ax(com.tencent.mm.plugin.expt.b.c.class)).a(c.a.znP, "");
    if (!Util.isNullOrNil((String)localObject)) {
      try
      {
        localObject = new com.tencent.mm.ad.i((String)localObject);
        String str = LocaleUtil.getApplicationLanguage();
        Log.i("MicroMsg.MultitalkUtils", "getMultitalkNavpopWording, langCode:%s", new Object[] { str });
        localObject = ((com.tencent.mm.ad.i)localObject).optString(str);
        AppMethodBeat.o(284682);
        return localObject;
      }
      catch (Exception localException)
      {
        Log.printErrStackTrace("MicroMsg.MultitalkUtils", (Throwable)localException, "getMultitalkNavpopWording error", new Object[0]);
      }
    }
    AppMethodBeat.o(284682);
    return null;
  }
  
  public static final String gje()
  {
    AppMethodBeat.i(284688);
    String str = gjd();
    if (!Util.isNullOrNil(str)) {
      try
      {
        str = new com.tencent.mm.ad.i(str).optString("talking");
        AppMethodBeat.o(284688);
        return str;
      }
      catch (Exception localException)
      {
        Log.printErrStackTrace("MicroMsg.MultitalkUtils", (Throwable)localException, "getMulitalkMemberListSizeWording error", new Object[0]);
      }
    }
    AppMethodBeat.o(284688);
    return null;
  }
  
  public static int k(String paramString, float paramFloat)
  {
    AppMethodBeat.i(284692);
    Rect localRect = new Rect();
    Paint localPaint = new Paint();
    localPaint.setTextSize(paramFloat);
    localPaint.getTextBounds(paramString, 0, paramString.length(), localRect);
    int i = localRect.width();
    AppMethodBeat.o(284692);
    return i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.multitalk.e.f
 * JD-Core Version:    0.7.0.1
 */