package com.tencent.mm.plugin.multitalk.d;

import android.graphics.Paint;
import android.graphics.Rect;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ab.i;
import com.tencent.mm.compatible.deviceinfo.ae;
import com.tencent.mm.compatible.deviceinfo.k;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.expt.b.b;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.plugin.multitalk.model.ac;
import com.tencent.mm.plugin.multitalk.model.q;
import com.tencent.mm.pluginsdk.e.b;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.pb.common.b.a.a.a.bb;
import com.tencent.pb.talkroom.sdk.MultiTalkGroup;
import com.tencent.wecall.talkroom.model.TalkRoom;
import com.tencent.wecall.talkroom.model.c;
import java.util.Iterator;
import java.util.List;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/multitalk/utils/MultitalkUtils;", "", "()V", "TAG", "", "canReceiveScreenCast", "", "checkMultitalkBlackBoardProjectCanUse", "checkMultitalkScreenProjectCanUse", "getLocalConfigNavPopWording", "getMemberId", "", "username", "getMulitalkMemberListSizeWording", "getMultitalkMaxLimitedNumber", "getMultitalkScreenCastTitle", "getMultitalkWaitingAcceptWording", "getProjectFpsSetting", "getScreenCastTitleContent", "context", "Landroid/content/Context;", "nickName", "getTextWidth", "content", "textPix", "", "screenCastUseHW", "plugin-multitalk_release"})
public final class e
{
  public static final e zZc;
  
  static
  {
    AppMethodBeat.i(178995);
    zZc = new e();
    AppMethodBeat.o(178995);
  }
  
  public static final int aGF(String paramString)
  {
    AppMethodBeat.i(178994);
    Object localObject;
    int i;
    if (!Util.isNullOrNil(paramString))
    {
      localObject = ac.eom();
      kotlin.g.b.p.g(localObject, "SubCoreMultiTalk.getMultiTalkManager()");
      if (((q)localObject).enn() != null)
      {
        localObject = ac.eom();
        kotlin.g.b.p.g(localObject, "SubCoreMultiTalk.getMultiTalkManager()");
        localObject = ((q)localObject).enn().hjv();
        if (ac.eom().aFW((String)localObject)) {
          i = com.tencent.mm.plugin.multitalk.b.p.zHS.aFz(paramString);
        }
      }
    }
    for (;;)
    {
      AppMethodBeat.o(178994);
      return i;
      localObject = c.hqY().brg((String)localObject);
      if (localObject != null)
      {
        localObject = ((TalkRoom)localObject).hqS().iterator();
        for (;;)
        {
          if (((Iterator)localObject).hasNext())
          {
            a.bb localbb = (a.bb)((Iterator)localObject).next();
            if (kotlin.g.b.p.j(localbb.dLN, paramString))
            {
              i = localbb.qrD;
              break;
            }
          }
        }
      }
      i = -1;
    }
  }
  
  public static final int epZ()
  {
    AppMethodBeat.i(178993);
    int i = ((b)g.af(b.class)).a(b.a.skV, e.b.JSF);
    AppMethodBeat.o(178993);
    return i;
  }
  
  public static final boolean eqa()
  {
    AppMethodBeat.i(240098);
    boolean bool;
    switch (ae.gKE.gHl)
    {
    case 0: 
    default: 
      bool = ((b)g.af(b.class)).a(b.a.skW, false);
      AppMethodBeat.o(240098);
      return bool;
    case -1: 
      if ((BuildInfo.IS_FLAVOR_RED) || (BuildInfo.DEBUG))
      {
        AppMethodBeat.o(240098);
        return true;
      }
      bool = ((b)g.af(b.class)).a(b.a.skW, false);
      AppMethodBeat.o(240098);
      return bool;
    case 2: 
      AppMethodBeat.o(240098);
      return false;
    }
    AppMethodBeat.o(240098);
    return true;
  }
  
  public static final boolean eqb()
  {
    AppMethodBeat.i(240099);
    boolean bool;
    switch (ae.gKE.gHm)
    {
    case 0: 
    default: 
      bool = ((b)g.af(b.class)).a(b.a.skX, false);
      AppMethodBeat.o(240099);
      return bool;
    case -1: 
      if ((BuildInfo.IS_FLAVOR_RED) || (BuildInfo.DEBUG))
      {
        AppMethodBeat.o(240099);
        return true;
      }
      bool = ((b)g.af(b.class)).a(b.a.skX, false);
      AppMethodBeat.o(240099);
      return bool;
    case 2: 
      AppMethodBeat.o(240099);
      return false;
    }
    AppMethodBeat.o(240099);
    return true;
  }
  
  public static final int eqc()
  {
    AppMethodBeat.i(240100);
    int i = ((b)g.af(b.class)).a(b.a.skZ, 5);
    AppMethodBeat.o(240100);
    return i;
  }
  
  public static boolean eqd()
  {
    AppMethodBeat.i(240101);
    boolean bool;
    switch (ae.gKE.gHl)
    {
    case 0: 
    default: 
      bool = ((b)g.af(b.class)).a(b.a.skY, false);
      AppMethodBeat.o(240101);
      return bool;
    case -1: 
      if ((BuildInfo.IS_FLAVOR_RED) || (BuildInfo.DEBUG))
      {
        AppMethodBeat.o(240101);
        return true;
      }
      bool = ((b)g.af(b.class)).a(b.a.skY, false);
      AppMethodBeat.o(240101);
      return bool;
    case 2: 
      AppMethodBeat.o(240101);
      return false;
    }
    AppMethodBeat.o(240101);
    return true;
  }
  
  public static boolean eqe()
  {
    AppMethodBeat.i(240102);
    if (((b)g.af(b.class)).a(b.a.sla, 0) == 1)
    {
      AppMethodBeat.o(240102);
      return true;
    }
    AppMethodBeat.o(240102);
    return false;
  }
  
  public static String eqf()
  {
    AppMethodBeat.i(240103);
    String str = eqh();
    if (!Util.isNullOrNil(str)) {
      try
      {
        str = new i(str).optString("screen_cast_title");
        AppMethodBeat.o(240103);
        return str;
      }
      catch (Exception localException)
      {
        Log.printErrStackTrace("MicroMsg.MultitalkUtils", (Throwable)localException, "getMultitalkWaitingAcceptWording error", new Object[0]);
      }
    }
    AppMethodBeat.o(240103);
    return null;
  }
  
  public static final String eqg()
  {
    AppMethodBeat.i(240104);
    String str = eqh();
    if (!Util.isNullOrNil(str)) {
      try
      {
        str = new i(str).optString("waiting");
        AppMethodBeat.o(240104);
        return str;
      }
      catch (Exception localException)
      {
        Log.printErrStackTrace("MicroMsg.MultitalkUtils", (Throwable)localException, "getMultitalkWaitingAcceptWording error", new Object[0]);
      }
    }
    AppMethodBeat.o(240104);
    return null;
  }
  
  private static String eqh()
  {
    AppMethodBeat.i(240105);
    Object localObject = ((b)g.af(b.class)).a(b.a.skK, "");
    if (!Util.isNullOrNil((String)localObject)) {
      try
      {
        localObject = new i((String)localObject);
        String str = LocaleUtil.getApplicationLanguage();
        Log.i("MicroMsg.MultitalkUtils", "getMultitalkNavpopWording, langCode:%s", new Object[] { str });
        localObject = ((i)localObject).optString(str);
        AppMethodBeat.o(240105);
        return localObject;
      }
      catch (Exception localException)
      {
        Log.printErrStackTrace("MicroMsg.MultitalkUtils", (Throwable)localException, "getMultitalkNavpopWording error", new Object[0]);
      }
    }
    AppMethodBeat.o(240105);
    return null;
  }
  
  public static final String eqi()
  {
    AppMethodBeat.i(240106);
    String str = eqh();
    if (!Util.isNullOrNil(str)) {
      try
      {
        str = new i(str).optString("talking");
        AppMethodBeat.o(240106);
        return str;
      }
      catch (Exception localException)
      {
        Log.printErrStackTrace("MicroMsg.MultitalkUtils", (Throwable)localException, "getMulitalkMemberListSizeWording error", new Object[0]);
      }
    }
    AppMethodBeat.o(240106);
    return null;
  }
  
  public static int i(String paramString, float paramFloat)
  {
    AppMethodBeat.i(240107);
    Rect localRect = new Rect();
    Paint localPaint = new Paint();
    localPaint.setTextSize(paramFloat);
    localPaint.getTextBounds(paramString, 0, paramString.length(), localRect);
    int i = localRect.width();
    AppMethodBeat.o(240107);
    return i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.multitalk.d.e
 * JD-Core Version:    0.7.0.1
 */