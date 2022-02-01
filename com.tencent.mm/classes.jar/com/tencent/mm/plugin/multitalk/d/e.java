package com.tencent.mm.plugin.multitalk.d;

import android.graphics.Paint;
import android.graphics.Rect;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ad.i;
import com.tencent.mm.compatible.deviceinfo.af;
import com.tencent.mm.compatible.deviceinfo.k;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.expt.b.b;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.plugin.multitalk.b.o;
import com.tencent.mm.plugin.multitalk.model.ad;
import com.tencent.mm.plugin.multitalk.model.q;
import com.tencent.mm.pluginsdk.e.b;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MultiProcessMMKV;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.pb.common.b.a.a.a.ba;
import com.tencent.pb.talkroom.sdk.MultiTalkGroup;
import com.tencent.wecall.talkroom.model.TalkRoom;
import com.tencent.wecall.talkroom.model.c;
import java.util.Iterator;
import java.util.List;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/multitalk/utils/MultitalkUtils;", "", "()V", "ENCODE_MAX_VOLUME_USER", "", "KV_NAME", "", "LINK_TO_NET_CHANGE_SETTING_COST_MAX", "LINK_TO_NET_CHANGE_SETTING_NET_TIP", "SCREEN_PROJECT_HAS_BEEN_EDUCATED", "TAG", "applyScreenProjectionHasBeenEducate", "", "canReceiveScreenCast", "", "checkFileScreenUseFuncDoodle", "checkMultitalkBlackBoardProjectCanUse", "checkMultitalkSDKApply", "checkMultitalkScreenProjectCanUse", "checkScreenProjectionHasBeenEducate", "getLocalConfigNavPopWording", "getMMKV", "Lcom/tencent/mm/sdk/platformtools/MultiProcessMMKV;", "getMemberId", "username", "getMulitalkMemberListSizeWording", "getMultitalkMaxLimitedNumber", "getMultitalkScreenCastTitle", "getMultitalkWaitingAcceptWording", "getProjectFpsSetting", "getScreenCastTitleContent", "context", "Landroid/content/Context;", "nickName", "getTextWidth", "content", "textPix", "", "screenCastUseHW", "plugin-multitalk_release"})
public final class e
{
  public static final e FEP;
  
  static
  {
    AppMethodBeat.i(178995);
    FEP = new e();
    AppMethodBeat.o(178995);
  }
  
  public static final int aQT(String paramString)
  {
    AppMethodBeat.i(178994);
    Object localObject;
    int i;
    if (!Util.isNullOrNil(paramString))
    {
      localObject = ad.eYc();
      p.j(localObject, "SubCoreMultiTalk.getMultiTalkManager()");
      if (((q)localObject).eXb() != null)
      {
        localObject = ad.eYc();
        p.j(localObject, "SubCoreMultiTalk.getMultiTalkManager()");
        localObject = ((q)localObject).eXb().ilf();
        if (ad.eYc().aQj((String)localObject)) {
          i = o.Fne.aPJ(paramString);
        }
      }
    }
    for (;;)
    {
      AppMethodBeat.o(178994);
      return i;
      localObject = c.iuI().bEf((String)localObject);
      if (localObject != null)
      {
        localObject = ((TalkRoom)localObject).iuC().iterator();
        for (;;)
        {
          if (((Iterator)localObject).hasNext())
          {
            a.ba localba = (a.ba)((Iterator)localObject).next();
            if (p.h(localba.fEC, paramString))
            {
              i = localba.tQm;
              break;
            }
          }
        }
      }
      i = -1;
    }
  }
  
  private static MultiProcessMMKV aal()
  {
    AppMethodBeat.i(199184);
    MultiProcessMMKV localMultiProcessMMKV = MultiProcessMMKV.getMMKV("mmkv_screen_project_info");
    p.j(localMultiProcessMMKV, "MultiProcessMMKV.getMMKV(KV_NAME)");
    AppMethodBeat.o(199184);
    return localMultiProcessMMKV;
  }
  
  public static final int eZN()
  {
    AppMethodBeat.i(178993);
    int i = ((b)h.ae(b.class)).a(b.a.vVy, e.b.QRK);
    AppMethodBeat.o(178993);
    return i;
  }
  
  public static final boolean eZO()
  {
    AppMethodBeat.i(199186);
    boolean bool = aal().getBoolean("screen_project_has_been_educated", false);
    AppMethodBeat.o(199186);
    return bool;
  }
  
  public static final void eZP()
  {
    AppMethodBeat.i(199189);
    aal().putBoolean("screen_project_has_been_educated", true);
    AppMethodBeat.o(199189);
  }
  
  public static final int eZQ()
  {
    AppMethodBeat.i(199192);
    int i;
    switch (af.juS.jry)
    {
    case 0: 
    default: 
      i = ((b)h.ae(b.class)).a(b.a.vZx, 0);
      AppMethodBeat.o(199192);
      return i;
    case -1: 
      i = ((b)h.ae(b.class)).a(b.a.vZx, 0);
      AppMethodBeat.o(199192);
      return i;
    case 2: 
      AppMethodBeat.o(199192);
      return 0;
    }
    AppMethodBeat.o(199192);
    return 1;
  }
  
  public static final boolean eZR()
  {
    AppMethodBeat.i(199194);
    boolean bool = ((b)h.ae(b.class)).a(b.a.vVm, false);
    AppMethodBeat.o(199194);
    return bool;
  }
  
  public static final boolean eZS()
  {
    AppMethodBeat.i(199197);
    boolean bool;
    switch (af.juS.jrx)
    {
    case 0: 
    default: 
      bool = ((b)h.ae(b.class)).a(b.a.vVz, false);
      AppMethodBeat.o(199197);
      return bool;
    case -1: 
      if ((BuildInfo.IS_FLAVOR_RED) || (BuildInfo.DEBUG))
      {
        AppMethodBeat.o(199197);
        return true;
      }
      bool = ((b)h.ae(b.class)).a(b.a.vVz, false);
      AppMethodBeat.o(199197);
      return bool;
    case 2: 
      AppMethodBeat.o(199197);
      return false;
    }
    AppMethodBeat.o(199197);
    return true;
  }
  
  public static final int eZT()
  {
    AppMethodBeat.i(199199);
    int i = ((b)h.ae(b.class)).a(b.a.vVC, 5);
    AppMethodBeat.o(199199);
    return i;
  }
  
  public static boolean eZU()
  {
    AppMethodBeat.i(199207);
    boolean bool;
    switch (af.juS.jrx)
    {
    case 0: 
    default: 
      bool = ((b)h.ae(b.class)).a(b.a.vVB, false);
      AppMethodBeat.o(199207);
      return bool;
    case -1: 
      if ((BuildInfo.IS_FLAVOR_RED) || (BuildInfo.DEBUG))
      {
        AppMethodBeat.o(199207);
        return true;
      }
      bool = ((b)h.ae(b.class)).a(b.a.vVB, false);
      AppMethodBeat.o(199207);
      return bool;
    case 2: 
      AppMethodBeat.o(199207);
      return false;
    }
    AppMethodBeat.o(199207);
    return true;
  }
  
  public static boolean eZV()
  {
    AppMethodBeat.i(199210);
    if (((b)h.ae(b.class)).a(b.a.vVD, 0) == 1)
    {
      AppMethodBeat.o(199210);
      return true;
    }
    AppMethodBeat.o(199210);
    return false;
  }
  
  public static String eZW()
  {
    AppMethodBeat.i(199211);
    String str = eZY();
    if (!Util.isNullOrNil(str)) {
      try
      {
        str = new i(str).optString("screen_cast_title");
        AppMethodBeat.o(199211);
        return str;
      }
      catch (Exception localException)
      {
        Log.printErrStackTrace("MicroMsg.MultitalkUtils", (Throwable)localException, "getMultitalkWaitingAcceptWording error", new Object[0]);
      }
    }
    AppMethodBeat.o(199211);
    return null;
  }
  
  public static final String eZX()
  {
    AppMethodBeat.i(199213);
    String str = eZY();
    if (!Util.isNullOrNil(str)) {
      try
      {
        str = new i(str).optString("waiting");
        AppMethodBeat.o(199213);
        return str;
      }
      catch (Exception localException)
      {
        Log.printErrStackTrace("MicroMsg.MultitalkUtils", (Throwable)localException, "getMultitalkWaitingAcceptWording error", new Object[0]);
      }
    }
    AppMethodBeat.o(199213);
    return null;
  }
  
  private static String eZY()
  {
    AppMethodBeat.i(199215);
    Object localObject = ((b)h.ae(b.class)).a(b.a.vVl, "");
    if (!Util.isNullOrNil((String)localObject)) {
      try
      {
        localObject = new i((String)localObject);
        String str = LocaleUtil.getApplicationLanguage();
        Log.i("MicroMsg.MultitalkUtils", "getMultitalkNavpopWording, langCode:%s", new Object[] { str });
        localObject = ((i)localObject).optString(str);
        AppMethodBeat.o(199215);
        return localObject;
      }
      catch (Exception localException)
      {
        Log.printErrStackTrace("MicroMsg.MultitalkUtils", (Throwable)localException, "getMultitalkNavpopWording error", new Object[0]);
      }
    }
    AppMethodBeat.o(199215);
    return null;
  }
  
  public static final String eZZ()
  {
    AppMethodBeat.i(199218);
    String str = eZY();
    if (!Util.isNullOrNil(str)) {
      try
      {
        str = new i(str).optString("talking");
        AppMethodBeat.o(199218);
        return str;
      }
      catch (Exception localException)
      {
        Log.printErrStackTrace("MicroMsg.MultitalkUtils", (Throwable)localException, "getMulitalkMemberListSizeWording error", new Object[0]);
      }
    }
    AppMethodBeat.o(199218);
    return null;
  }
  
  public static int j(String paramString, float paramFloat)
  {
    AppMethodBeat.i(199220);
    Rect localRect = new Rect();
    Paint localPaint = new Paint();
    localPaint.setTextSize(paramFloat);
    localPaint.getTextBounds(paramString, 0, paramString.length(), localRect);
    int i = localRect.width();
    AppMethodBeat.o(199220);
    return i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.multitalk.d.e
 * JD-Core Version:    0.7.0.1
 */