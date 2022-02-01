package com.tencent.mm.plugin.multitalk.d;

import android.graphics.Paint;
import android.graphics.Rect;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ab.i;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.expt.b.b;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.plugin.multitalk.model.o;
import com.tencent.mm.plugin.multitalk.model.z;
import com.tencent.mm.pluginsdk.e.b;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.sdk.platformtools.j;
import com.tencent.pb.common.b.a.a.a.ay;
import com.tencent.pb.talkroom.sdk.MultiTalkGroup;
import com.tencent.wecall.talkroom.model.TalkRoom;
import com.tencent.wecall.talkroom.model.c;
import d.l;
import java.util.Iterator;
import java.util.List;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/multitalk/utils/MultitalkUtils;", "", "()V", "TAG", "", "canReceiveScreenCast", "", "getLocalConfigNavPopWording", "getMemberId", "", "username", "getMulitalkMemberListSizeWording", "getMultitalkMaxLimitedNumber", "getMultitalkScreenCastTitle", "getMultitalkWaitingAcceptWording", "getScreenCastTitleContent", "context", "Landroid/content/Context;", "nickName", "getTextWidth", "content", "textPix", "", "screenCastUseHW", "plugin-multitalk_release"})
public final class e
{
  public static final e wxn;
  
  static
  {
    AppMethodBeat.i(178995);
    wxn = new e();
    AppMethodBeat.o(178995);
  }
  
  public static final int asV(String paramString)
  {
    AppMethodBeat.i(178994);
    Object localObject;
    int i;
    if (!bu.isNullOrNil(paramString))
    {
      localObject = z.dtK();
      d.g.b.p.g(localObject, "SubCoreMultiTalk.getMultiTalkManager()");
      if (((o)localObject).dsT() != null)
      {
        localObject = z.dtK();
        d.g.b.p.g(localObject, "SubCoreMultiTalk.getMultiTalkManager()");
        localObject = ((o)localObject).dsT().fXP();
        if (z.dtK().asB((String)localObject)) {
          i = com.tencent.mm.plugin.multitalk.b.p.wmO.asf(paramString);
        }
      }
    }
    for (;;)
    {
      AppMethodBeat.o(178994);
      return i;
      localObject = c.gdW().bbC((String)localObject);
      if (localObject != null)
      {
        localObject = ((TalkRoom)localObject).gdQ().iterator();
        for (;;)
        {
          if (((Iterator)localObject).hasNext())
          {
            a.ay localay = (a.ay)((Iterator)localObject).next();
            if (d.g.b.p.i(localay.duC, paramString))
            {
              i = localay.pcE;
              break;
            }
          }
        }
      }
      i = -1;
    }
  }
  
  public static final int duB()
  {
    AppMethodBeat.i(178993);
    int i = ((b)g.ab(b.class)).a(b.a.qNW, e.b.FbL);
    AppMethodBeat.o(178993);
    return i;
  }
  
  public static boolean duC()
  {
    AppMethodBeat.i(191041);
    if ((j.DEBUG) || (j.IS_FLAVOR_RED))
    {
      AppMethodBeat.o(191041);
      return true;
    }
    if (((b)g.ab(b.class)).a(b.a.qNX, 0) == 1)
    {
      AppMethodBeat.o(191041);
      return true;
    }
    AppMethodBeat.o(191041);
    return false;
  }
  
  public static boolean duD()
  {
    AppMethodBeat.i(191042);
    if (((b)g.ab(b.class)).a(b.a.qNY, 0) == 1)
    {
      AppMethodBeat.o(191042);
      return true;
    }
    AppMethodBeat.o(191042);
    return false;
  }
  
  public static String duE()
  {
    AppMethodBeat.i(191043);
    String str = duG();
    if (!bu.isNullOrNil(str)) {
      try
      {
        str = new i(str).optString("screen_cast_title");
        AppMethodBeat.o(191043);
        return str;
      }
      catch (Exception localException)
      {
        ae.printErrStackTrace("MicroMsg.MultitalkUtils", (Throwable)localException, "getMultitalkWaitingAcceptWording error", new Object[0]);
      }
    }
    AppMethodBeat.o(191043);
    return null;
  }
  
  public static final String duF()
  {
    AppMethodBeat.i(191044);
    String str = duG();
    if (!bu.isNullOrNil(str)) {
      try
      {
        str = new i(str).optString("waiting");
        AppMethodBeat.o(191044);
        return str;
      }
      catch (Exception localException)
      {
        ae.printErrStackTrace("MicroMsg.MultitalkUtils", (Throwable)localException, "getMultitalkWaitingAcceptWording error", new Object[0]);
      }
    }
    AppMethodBeat.o(191044);
    return null;
  }
  
  private static String duG()
  {
    AppMethodBeat.i(191045);
    Object localObject = ((b)g.ab(b.class)).a(b.a.qNM, "");
    if (!bu.isNullOrNil((String)localObject)) {
      try
      {
        localObject = new i((String)localObject);
        String str = ad.fom();
        ae.i("MicroMsg.MultitalkUtils", "getMultitalkNavpopWording, langCode:%s", new Object[] { str });
        localObject = ((i)localObject).optString(str);
        AppMethodBeat.o(191045);
        return localObject;
      }
      catch (Exception localException)
      {
        ae.printErrStackTrace("MicroMsg.MultitalkUtils", (Throwable)localException, "getMultitalkNavpopWording error", new Object[0]);
      }
    }
    AppMethodBeat.o(191045);
    return null;
  }
  
  public static final String duH()
  {
    AppMethodBeat.i(191046);
    String str = duG();
    if (!bu.isNullOrNil(str)) {
      try
      {
        str = new i(str).optString("talking");
        AppMethodBeat.o(191046);
        return str;
      }
      catch (Exception localException)
      {
        ae.printErrStackTrace("MicroMsg.MultitalkUtils", (Throwable)localException, "getMulitalkMemberListSizeWording error", new Object[0]);
      }
    }
    AppMethodBeat.o(191046);
    return null;
  }
  
  public static int k(String paramString, float paramFloat)
  {
    AppMethodBeat.i(191047);
    Rect localRect = new Rect();
    Paint localPaint = new Paint();
    localPaint.setTextSize(paramFloat);
    localPaint.getTextBounds(paramString, 0, paramString.length(), localRect);
    int i = localRect.width();
    AppMethodBeat.o(191047);
    return i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.multitalk.d.e
 * JD-Core Version:    0.7.0.1
 */