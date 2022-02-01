package com.tencent.mm.plugin.multitalk.c;

import android.graphics.Paint;
import android.graphics.Rect;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.expt.b.b;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.plugin.multitalk.model.o;
import com.tencent.mm.plugin.multitalk.model.z;
import com.tencent.mm.pluginsdk.e.b;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.pb.common.b.a.a.a.ay;
import com.tencent.pb.talkroom.sdk.MultiTalkGroup;
import com.tencent.wecall.talkroom.model.TalkRoom;
import com.tencent.wecall.talkroom.model.c;
import d.g.b.p;
import d.l;
import java.util.Iterator;
import java.util.List;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/multitalk/utils/MultitalkUtils;", "", "()V", "TAG", "", "canReceiveScreenCast", "", "getLocalConfigNavPopWording", "getMemberId", "", "username", "getMulitalkMemberListSizeWording", "getMultitalkMaxLimitedNumber", "getMultitalkScreenCastTitle", "getMultitalkWaitingAcceptWording", "getScreenCastTitleContent", "context", "Landroid/content/Context;", "nickName", "getTextWidth", "content", "textPix", "", "screenCastUseHW", "plugin-multitalk_release"})
public final class e
{
  public static final e whJ;
  
  static
  {
    AppMethodBeat.i(178995);
    whJ = new e();
    AppMethodBeat.o(178995);
  }
  
  public static final int arI(String paramString)
  {
    AppMethodBeat.i(178994);
    a.ay localay;
    if (!bt.isNullOrNil(paramString))
    {
      Object localObject = z.dqx();
      p.g(localObject, "SubCoreMultiTalk.getMultiTalkManager()");
      if (((o)localObject).dpI() != null)
      {
        localObject = z.dqx();
        p.g(localObject, "SubCoreMultiTalk.getMultiTalkManager()");
        localObject = ((o)localObject).dpI().fTp();
        localObject = c.fZv().aZZ((String)localObject);
        if (localObject != null)
        {
          localObject = ((TalkRoom)localObject).fZp().iterator();
          do
          {
            if (!((Iterator)localObject).hasNext()) {
              break;
            }
            localay = (a.ay)((Iterator)localObject).next();
          } while (!p.i(localay.dtx, paramString));
        }
      }
    }
    for (int i = localay.oWb;; i = -1)
    {
      AppMethodBeat.o(178994);
      return i;
    }
  }
  
  public static final int drp()
  {
    AppMethodBeat.i(178993);
    int i = ((b)g.ab(b.class)).a(b.a.qGq, e.b.EJn);
    AppMethodBeat.o(178993);
    return i;
  }
  
  public static boolean drq()
  {
    AppMethodBeat.i(206767);
    if ((com.tencent.mm.sdk.platformtools.i.DEBUG) || (com.tencent.mm.sdk.platformtools.i.IS_FLAVOR_RED))
    {
      AppMethodBeat.o(206767);
      return true;
    }
    if (((b)g.ab(b.class)).a(b.a.qGr, 0) == 1)
    {
      AppMethodBeat.o(206767);
      return true;
    }
    AppMethodBeat.o(206767);
    return false;
  }
  
  public static boolean drr()
  {
    AppMethodBeat.i(206768);
    if (((b)g.ab(b.class)).a(b.a.qGs, 0) == 1)
    {
      AppMethodBeat.o(206768);
      return true;
    }
    AppMethodBeat.o(206768);
    return false;
  }
  
  public static String drs()
  {
    AppMethodBeat.i(206769);
    String str = dru();
    if (!bt.isNullOrNil(str)) {
      try
      {
        str = new com.tencent.mm.ac.i(str).optString("screen_cast_title");
        AppMethodBeat.o(206769);
        return str;
      }
      catch (Exception localException)
      {
        ad.printErrStackTrace("MicroMsg.MultitalkUtils", (Throwable)localException, "getMultitalkWaitingAcceptWording error", new Object[0]);
      }
    }
    AppMethodBeat.o(206769);
    return null;
  }
  
  public static final String drt()
  {
    AppMethodBeat.i(206770);
    String str = dru();
    if (!bt.isNullOrNil(str)) {
      try
      {
        str = new com.tencent.mm.ac.i(str).optString("waiting");
        AppMethodBeat.o(206770);
        return str;
      }
      catch (Exception localException)
      {
        ad.printErrStackTrace("MicroMsg.MultitalkUtils", (Throwable)localException, "getMultitalkWaitingAcceptWording error", new Object[0]);
      }
    }
    AppMethodBeat.o(206770);
    return null;
  }
  
  private static String dru()
  {
    AppMethodBeat.i(206771);
    Object localObject = ((b)g.ab(b.class)).a(b.a.qGg, "");
    if (!bt.isNullOrNil((String)localObject)) {
      try
      {
        localObject = new com.tencent.mm.ac.i((String)localObject);
        String str = ac.fks();
        ad.i("MicroMsg.MultitalkUtils", "getMultitalkNavpopWording, langCode:%s", new Object[] { str });
        localObject = ((com.tencent.mm.ac.i)localObject).optString(str);
        AppMethodBeat.o(206771);
        return localObject;
      }
      catch (Exception localException)
      {
        ad.printErrStackTrace("MicroMsg.MultitalkUtils", (Throwable)localException, "getMultitalkNavpopWording error", new Object[0]);
      }
    }
    AppMethodBeat.o(206771);
    return null;
  }
  
  public static final String drv()
  {
    AppMethodBeat.i(206772);
    String str = dru();
    if (!bt.isNullOrNil(str)) {
      try
      {
        str = new com.tencent.mm.ac.i(str).optString("talking");
        AppMethodBeat.o(206772);
        return str;
      }
      catch (Exception localException)
      {
        ad.printErrStackTrace("MicroMsg.MultitalkUtils", (Throwable)localException, "getMulitalkMemberListSizeWording error", new Object[0]);
      }
    }
    AppMethodBeat.o(206772);
    return null;
  }
  
  public static int k(String paramString, float paramFloat)
  {
    AppMethodBeat.i(206773);
    Rect localRect = new Rect();
    Paint localPaint = new Paint();
    localPaint.setTextSize(paramFloat);
    localPaint.getTextBounds(paramString, 0, paramString.length(), localRect);
    int i = localRect.width();
    AppMethodBeat.o(206773);
    return i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.multitalk.c.e
 * JD-Core Version:    0.7.0.1
 */