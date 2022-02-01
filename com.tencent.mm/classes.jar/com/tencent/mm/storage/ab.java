package com.tencent.mm.storage;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.x;
import com.tencent.mm.plugin.expt.b.b;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.sdk.platformtools.bx;
import d.g.a.a;
import d.g.b.p;
import d.g.b.q;
import d.z;
import java.util.Map;

@d.l(gjZ={1, 1, 16}, gka={""}, gkb={"cacheMsgId", "", "cacheValues", "", "", "checkNewDyeingTemplate", "", "info", "Lcom/tencent/mm/storage/BizTimeLineInfo;", "getArticleUrl", "getDisplayName", "getDyeingDigest", "getDyeingTemplateWord", "Landroid/text/SpannableStringBuilder;", "getIconUrl", "getItemShowType", "", "getMsgType", "getUnreadCount", "getUserName", "getValue", "hasOfficialAccountRedDot", "isDyeingTemplateToTimeline", "msg", "Lcom/tencent/mm/storage/MsgInfo;", "msgCluster", "onDyeingTemplateClick", "", "context", "Landroid/content/Context;", "reportMsgNotify", "username", "actionType", "notifyType", "notifyMsgId", "notifyRow", "sessionId", "scene", "enterId", "plugin-biz_release"})
public final class ab
{
  private static long IJD;
  private static Map<String, String> IJE;
  
  public static final void a(String paramString, int paramInt1, int paramInt2, long paramLong, int paramInt3, int paramInt4, int paramInt5, int paramInt6)
  {
    AppMethodBeat.i(224215);
    int i = (int)(System.currentTimeMillis() / 1000L);
    com.tencent.mm.plugin.report.service.g.yxI.f(17750, new Object[] { paramString, Integer.valueOf(i), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Long.valueOf(paramLong), Integer.valueOf(paramInt3), Integer.valueOf(paramInt4), Integer.valueOf(paramInt5), Integer.valueOf(paramInt6) });
    AppMethodBeat.o(224215);
  }
  
  public static final int d(w paramw)
  {
    AppMethodBeat.i(224212);
    p.h(paramw, "info");
    paramw = w(paramw);
    if (paramw == null)
    {
      AppMethodBeat.o(224212);
      return 0;
    }
    if (paramw != null) {}
    for (int i = bu.getInt((String)paramw.get(".msg.appmsg.mmreader.notify_msg.scene"), 0);; i = 0)
    {
      AppMethodBeat.o(224212);
      return i;
    }
  }
  
  public static final boolean d(bv parambv, String paramString)
  {
    AppMethodBeat.i(188856);
    if (parambv == null)
    {
      AppMethodBeat.o(188856);
      return false;
    }
    if (!x.AT(paramString))
    {
      ae.i("MicroMsg.BizTimeLineStorageLogicExKt", "isDyeingTemplateToTimeline isMsgClusterNotifyMessage = false");
      AppMethodBeat.o(188856);
      return false;
    }
    if (!y.bOd())
    {
      ae.i("MicroMsg.BizTimeLineStorageLogicExKt", "isDyeingTemplateToTimeline isBizTimeLineOpen = false");
      AppMethodBeat.o(188856);
      return false;
    }
    paramString = (b)com.tencent.mm.kernel.g.ab(b.class);
    if ((paramString != null) && (paramString.a(b.a.qBv, 1) == 1)) {}
    for (int i = 1; i == 0; i = 0)
    {
      ae.i("MicroMsg.BizTimeLineStorageLogicExKt", "isDyeingTemplateToTimeline open = false");
      AppMethodBeat.o(188856);
      return false;
    }
    parambv = bx.M(parambv.getContent(), "msg");
    if (parambv != null)
    {
      parambv = (String)parambv.get(".msg.appmsg.mmreader.notify_msg.act");
      if (!bu.isNullOrNil(parambv)) {}
      for (boolean bool = true;; bool = false)
      {
        ae.i("MicroMsg.BizTimeLineStorageLogicExKt", "isDyeingTemplateToTimeline notifyMsg = %s", new Object[] { Boolean.valueOf(bool) });
        if (bu.isNullOrNil(parambv)) {
          break;
        }
        AppMethodBeat.o(188856);
        return true;
      }
      AppMethodBeat.o(188856);
      return false;
    }
    ae.i("MicroMsg.BizTimeLineStorageLogicExKt", "isDyeingTemplateToTimeline false");
    AppMethodBeat.o(188856);
    return false;
  }
  
  public static final int fxj()
  {
    AppMethodBeat.i(224213);
    Object localObject = com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.l.class);
    p.g(localObject, "service(IMessengerStorage::class.java)");
    localObject = ((com.tencent.mm.plugin.messenger.foundation.a.l)localObject).azL();
    if (localObject != null)
    {
      localObject = ((br)localObject).aVa("officialaccounts");
      if (localObject != null) {}
    }
    else
    {
      AppMethodBeat.o(224213);
      return 0;
    }
    if (((au)localObject).VS() <= 0)
    {
      if (((((au)localObject).lS(8388608)) || (((au)localObject).lS(2097152))) && (((au)localObject).VT() > 0))
      {
        AppMethodBeat.o(224213);
        return 1;
      }
      AppMethodBeat.o(224213);
      return 0;
    }
    if ((y.bOd()) && (!((au)localObject).lS(16)) && (!((au)localObject).lS(64)))
    {
      AppMethodBeat.o(224213);
      return 0;
    }
    AppMethodBeat.o(224213);
    return 1;
  }
  
  public static final String u(w paramw)
  {
    AppMethodBeat.i(188857);
    p.h(paramw, "info");
    Map localMap = w(paramw);
    if (localMap == null)
    {
      AppMethodBeat.o(188857);
      return "";
    }
    if ((localMap != null) && (bu.isNullOrNil((String)localMap.get(".msg.appmsg.mmreader.notify_msg.act"))))
    {
      AppMethodBeat.o(188857);
      return "";
    }
    paramw = (String)localMap.get(".msg.appmsg.mmreader.notify_msg.title");
    if (paramw == null) {
      paramw = "";
    }
    for (;;)
    {
      String str = "";
      int i = 0;
      if (i <= 10)
      {
        StringBuilder localStringBuilder = new StringBuilder(".msg.appmsg.mmreader.notify_msg.msg.item");
        if (i == 0) {}
        for (Object localObject = "";; localObject = Integer.valueOf(i))
        {
          localObject = (String)localMap.get(localObject + ".content");
          if (bu.isNullOrNil((String)localObject)) {
            break label176;
          }
          str = str + (String)localObject;
          i += 1;
          break;
        }
      }
      label176:
      paramw = "" + paramw;
      paramw = paramw + ":";
      paramw = paramw + str;
      AppMethodBeat.o(188857);
      return paramw;
    }
  }
  
  public static final String v(w paramw)
  {
    AppMethodBeat.i(188858);
    p.h(paramw, "info");
    String str = "";
    Map localMap = w(paramw);
    if (localMap == null)
    {
      AppMethodBeat.o(188858);
      return "";
    }
    paramw = str;
    if (localMap != null)
    {
      str = (String)localMap.get(".msg.appmsg.mmreader.notify_msg.publisher_username");
      paramw = str;
      if (str == null) {
        paramw = "";
      }
    }
    AppMethodBeat.o(188858);
    return paramw;
  }
  
  public static final Map<String, String> w(w paramw)
  {
    AppMethodBeat.i(188859);
    if ((paramw.field_msgId == IJD) && (IJE != null))
    {
      paramw = IJE;
      AppMethodBeat.o(188859);
      return paramw;
    }
    IJD = paramw.field_msgId;
    paramw = bx.M(paramw.field_content, "msg");
    IJE = paramw;
    AppMethodBeat.o(188859);
    return paramw;
  }
  
  public static final boolean x(w paramw)
  {
    AppMethodBeat.i(224214);
    p.h(paramw, "info");
    if (!paramw.fte())
    {
      AppMethodBeat.o(224214);
      return false;
    }
    paramw = w(paramw);
    if (paramw == null)
    {
      AppMethodBeat.o(224214);
      return false;
    }
    if ((paramw != null) && (!bu.isNullOrNil((String)paramw.get(".msg.appmsg.mmreader.notify_msg.act"))))
    {
      AppMethodBeat.o(224214);
      return true;
    }
    ae.i("MicroMsg.BizTimeLineStorageLogicExKt", "checkNewDyeingTemplate false");
    AppMethodBeat.o(224214);
    return false;
  }
  
  @d.l(gjZ={1, 1, 16}, gka={""}, gkb={"<no name provided>", "", "invoke"})
  public static final class d
    extends q
    implements a<z>
  {
    public d(Map paramMap, w paramw, Context paramContext)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.storage.ab
 * JD-Core Version:    0.7.0.1
 */