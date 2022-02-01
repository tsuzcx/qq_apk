package com.tencent.mm.storage;

import android.content.Context;
import android.text.SpannableStringBuilder;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.XmlParser;
import java.util.Map;
import kotlin.g.a.a;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.x;

@kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"cacheFollowMsgId", "", "cacheFollowValues", "", "", "cacheMsgId", "cacheValues", "checkNewDyeingTemplate", "", "info", "Lcom/tencent/mm/storage/BizTimeLineInfo;", "checkShowDigesNum", "getArticleUrl", "getDisplayName", "getDyeingDigest", "getDyeingTemplateWord", "Landroid/text/SpannableStringBuilder;", "index", "", "getFollowDisplayName", "getFollowDyeingTemplateWord", "getFollowValue", "getIconUrl", "getItemShowType", "getMsgType", "getUnreadCount", "getUserName", "getValue", "hasOfficialAccountRedDot", "isDyeingTemplateToTimeline", "msg", "Lcom/tencent/mm/storage/MsgInfo;", "msgCluster", "onDyeingTemplateClick", "", "context", "Landroid/content/Context;", "reportMsgNotify", "username", "actionType", "notifyType", "notifyMsgId", "notifyRow", "sessionId", "scene", "enterId", "setFollowMaxLine", "view", "Landroid/widget/TextView;", "setMaxLine", "plugin-biz_release"})
public final class ag
{
  private static long NRA;
  private static Map<String, String> NRB;
  private static long NRy;
  private static Map<String, String> NRz;
  
  public static final String H(z paramz)
  {
    AppMethodBeat.i(212668);
    p.h(paramz, "info");
    a locala = (a)new a(paramz);
    Object localObject1 = "";
    Object localObject2;
    String str;
    if ((paramz.isText()) || (paramz.gAz()))
    {
      localObject2 = M(paramz);
      str = ".msgsource.notify_msg.";
    }
    for (;;)
    {
      if (localObject2 != null)
      {
        localObject2 = (String)((Map)localObject2).get(str + "box_digest");
        localObject1 = localObject2;
        if (localObject2 == null) {
          localObject1 = "";
        }
      }
      localObject2 = localObject1;
      if (Util.isNullOrNil((String)localObject1))
      {
        localObject2 = localObject1;
        if (paramz.gAx()) {
          localObject2 = (String)locala.invoke();
        }
      }
      AppMethodBeat.o(212668);
      return localObject2;
      if (paramz.gAx())
      {
        localObject2 = K(paramz);
        str = ".msg.appmsg.mmreader.notify_msg.";
      }
      else
      {
        localObject2 = null;
        str = null;
      }
    }
  }
  
  public static final String I(z paramz)
  {
    AppMethodBeat.i(212669);
    p.h(paramz, "info");
    String str = "";
    Map localMap = K(paramz);
    if (localMap == null)
    {
      AppMethodBeat.o(212669);
      return "";
    }
    paramz = str;
    if (localMap != null)
    {
      str = (String)localMap.get(".msg.appmsg.mmreader.notify_msg.publisher_username");
      paramz = str;
      if (str == null) {
        paramz = "";
      }
    }
    AppMethodBeat.o(212669);
    return paramz;
  }
  
  public static final boolean J(z paramz)
  {
    AppMethodBeat.i(212672);
    p.h(paramz, "info");
    if (!paramz.gAx())
    {
      AppMethodBeat.o(212672);
      return false;
    }
    paramz = K(paramz);
    if (paramz == null)
    {
      AppMethodBeat.o(212672);
      return false;
    }
    if ((paramz != null) && (!Util.isNullOrNil((String)paramz.get(".msg.appmsg.mmreader.notify_msg.act"))))
    {
      AppMethodBeat.o(212672);
      return true;
    }
    Log.i("MicroMsg.BizTimeLineStorageLogicExKt", "checkNewDyeingTemplate false");
    AppMethodBeat.o(212672);
    return false;
  }
  
  public static final Map<String, String> K(z paramz)
  {
    AppMethodBeat.i(212673);
    if ((paramz.field_msgId == NRy) && (NRz != null))
    {
      paramz = NRz;
      AppMethodBeat.o(212673);
      return paramz;
    }
    NRy = paramz.field_msgId;
    paramz = XmlParser.parseXml(paramz.field_content, "msg", null);
    NRz = paramz;
    AppMethodBeat.o(212673);
    return paramz;
  }
  
  public static final String L(z paramz)
  {
    AppMethodBeat.i(212677);
    p.h(paramz, "info");
    String str = "";
    Map localMap = M(paramz);
    if (localMap == null)
    {
      AppMethodBeat.o(212677);
      return "";
    }
    paramz = str;
    if (localMap != null)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      str = (String)localMap.get(".msgsource.notify_msg.title2");
      paramz = str;
      if (str == null) {
        paramz = "";
      }
      localStringBuilder = localStringBuilder.append(paramz).append(' ');
      str = (String)localMap.get(".msgsource.notify_msg.action");
      paramz = str;
      if (str == null) {
        paramz = "";
      }
      paramz = paramz;
    }
    AppMethodBeat.o(212677);
    return paramz;
  }
  
  private static final Map<String, String> M(z paramz)
  {
    AppMethodBeat.i(212678);
    if ((paramz.field_msgId == NRA) && (NRB != null))
    {
      paramz = NRB;
      AppMethodBeat.o(212678);
      return paramz;
    }
    NRA = paramz.field_msgId;
    paramz = XmlParser.parseXml(paramz.ajw(), "msgsource", null);
    NRB = paramz;
    AppMethodBeat.o(212678);
    return paramz;
  }
  
  public static final void a(z paramz, int paramInt, TextView paramTextView)
  {
    AppMethodBeat.i(212666);
    p.h(paramz, "info");
    p.h(paramTextView, "view");
    Map localMap = K(paramz);
    if (localMap != null)
    {
      StringBuilder localStringBuilder = new StringBuilder(".msg.appmsg.mmreader.notify_msg.msg.item");
      if (paramInt == 0)
      {
        paramz = "";
        paramz = paramz;
        Log.i("MicroMsg.BizTimeLineStorageLogicExKt", String.valueOf(localMap.get(paramz + ".max_line_count")));
        if (Util.isNullOrNil((String)localMap.get(paramz + ".max_line_count"))) {
          break label187;
        }
      }
    }
    label187:
    for (paramInt = Util.getInt((String)localMap.get(paramz + ".max_line_count"), 2);; paramInt = 0)
    {
      int i = paramInt;
      if (paramInt == 0) {
        i = 2147483647;
      }
      paramTextView.setMaxLines(i);
      AppMethodBeat.o(212666);
      return;
      paramz = Integer.valueOf(paramInt);
      break;
    }
  }
  
  public static final void a(String paramString, int paramInt1, int paramInt2, long paramLong, int paramInt3, int paramInt4, int paramInt5, int paramInt6)
  {
    AppMethodBeat.i(212674);
    int i = (int)(System.currentTimeMillis() / 1000L);
    h.CyF.a(17750, new Object[] { paramString, Integer.valueOf(i), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Long.valueOf(paramLong), Integer.valueOf(paramInt3), Integer.valueOf(paramInt4), Integer.valueOf(paramInt5), Integer.valueOf(paramInt6) });
    AppMethodBeat.o(212674);
  }
  
  public static final void b(z paramz, int paramInt, TextView paramTextView)
  {
    AppMethodBeat.i(212676);
    p.h(paramz, "info");
    p.h(paramTextView, "view");
    Map localMap = M(paramz);
    if (localMap != null)
    {
      StringBuilder localStringBuilder = new StringBuilder(".msgsource.notify_msg.msg.item");
      if (paramInt == 0)
      {
        paramz = "";
        paramz = paramz;
        Log.i("MicroMsg.BizTimeLineStorageLogicExKt", String.valueOf(localMap.get(paramz + ".max_line_count")));
        if (Util.isNullOrNil((String)localMap.get(paramz + ".max_line_count"))) {
          break label190;
        }
      }
    }
    label190:
    for (paramInt = Util.getInt((String)localMap.get(paramz + ".max_line_count"), 2);; paramInt = 0)
    {
      int i = paramInt;
      if (paramInt == 0) {
        i = 2147483647;
      }
      paramTextView.setMaxLines(i);
      AppMethodBeat.o(212676);
      return;
      paramz = Integer.valueOf(paramInt);
      break;
    }
  }
  
  public static final boolean d(ca paramca, String paramString)
  {
    AppMethodBeat.i(212665);
    if (paramca == null)
    {
      AppMethodBeat.o(212665);
      return false;
    }
    if (paramca.gDj() != true)
    {
      Log.i("MicroMsg.BizTimeLineStorageLogicExKt", "isDyeingTemplateToTimeline isTemplateMsg false");
      AppMethodBeat.o(212665);
      return false;
    }
    if (!com.tencent.mm.model.ab.Jy(paramString))
    {
      Log.i("MicroMsg.BizTimeLineStorageLogicExKt", "isDyeingTemplateToTimeline isMsgClusterNotifyMessage = false");
      AppMethodBeat.o(212665);
      return false;
    }
    if (!ab.clc())
    {
      Log.i("MicroMsg.BizTimeLineStorageLogicExKt", "isDyeingTemplateToTimeline isBizTimeLineOpen = false");
      AppMethodBeat.o(212665);
      return false;
    }
    paramString = (com.tencent.mm.plugin.expt.b.b)g.af(com.tencent.mm.plugin.expt.b.b.class);
    if ((paramString != null) && (paramString.a(b.a.rUe, 1) == 1)) {}
    for (int i = 1; i == 0; i = 0)
    {
      Log.i("MicroMsg.BizTimeLineStorageLogicExKt", "isDyeingTemplateToTimeline open = false");
      AppMethodBeat.o(212665);
      return false;
    }
    paramca = XmlParser.parseXml(paramca.getContent(), "msg", null);
    if (paramca != null)
    {
      paramca = (String)paramca.get(".msg.appmsg.mmreader.notify_msg.act");
      if (!Util.isNullOrNil(paramca)) {}
      for (boolean bool = true;; bool = false)
      {
        Log.i("MicroMsg.BizTimeLineStorageLogicExKt", "isDyeingTemplateToTimeline notifyMsg = %s", new Object[] { Boolean.valueOf(bool) });
        if (Util.isNullOrNil(paramca)) {
          break;
        }
        AppMethodBeat.o(212665);
        return true;
      }
      AppMethodBeat.o(212665);
      return false;
    }
    Log.i("MicroMsg.BizTimeLineStorageLogicExKt", "isDyeingTemplateToTimeline false");
    AppMethodBeat.o(212665);
    return false;
  }
  
  public static final int f(z paramz)
  {
    AppMethodBeat.i(212670);
    p.h(paramz, "info");
    paramz = K(paramz);
    if (paramz == null)
    {
      AppMethodBeat.o(212670);
      return 0;
    }
    if (paramz != null) {}
    for (int i = Util.getInt((String)paramz.get(".msg.appmsg.mmreader.notify_msg.scene"), 0);; i = 0)
    {
      AppMethodBeat.o(212670);
      return i;
    }
  }
  
  public static final int gBq()
  {
    AppMethodBeat.i(212671);
    Object localObject = g.af(com.tencent.mm.plugin.messenger.foundation.a.l.class);
    p.g(localObject, "service(IMessengerStorage::class.java)");
    localObject = ((com.tencent.mm.plugin.messenger.foundation.a.l)localObject).aST();
    if (localObject != null)
    {
      localObject = ((bw)localObject).bjY("officialaccounts");
      if (localObject != null) {}
    }
    else
    {
      AppMethodBeat.o(212671);
      return 0;
    }
    if (((az)localObject).ajG() <= 0)
    {
      if (((((az)localObject).oV(8388608)) || (((az)localObject).oV(2097152))) && (((az)localObject).ajH() > 0))
      {
        AppMethodBeat.o(212671);
        return 1;
      }
      AppMethodBeat.o(212671);
      return 0;
    }
    if ((ab.clc()) && (!((az)localObject).oV(16)) && (!((az)localObject).oV(64)))
    {
      AppMethodBeat.o(212671);
      return 0;
    }
    AppMethodBeat.o(212671);
    return 1;
  }
  
  public static final SpannableStringBuilder h(z paramz, int paramInt)
  {
    AppMethodBeat.i(212667);
    p.h(paramz, "info");
    SpannableStringBuilder localSpannableStringBuilder = new SpannableStringBuilder();
    Map localMap = K(paramz);
    if (localMap == null)
    {
      AppMethodBeat.o(212667);
      return localSpannableStringBuilder;
    }
    if ((localMap != null) && (Util.isNullOrNil((String)localMap.get(".msg.appmsg.mmreader.notify_msg.act"))))
    {
      AppMethodBeat.o(212667);
      return localSpannableStringBuilder;
    }
    kotlin.g.a.b localb = (kotlin.g.a.b)new ag.b(localMap);
    StringBuilder localStringBuilder = new StringBuilder(".msg.appmsg.mmreader.notify_msg.msg.item");
    if (paramInt == 0) {}
    for (paramz = "";; paramz = Integer.valueOf(paramInt))
    {
      paramz = paramz;
      if (!Util.isNullOrNil((String)localMap.get(paramz + ".content"))) {
        localSpannableStringBuilder.append((CharSequence)localb.invoke(paramz));
      }
      AppMethodBeat.o(212667);
      return localSpannableStringBuilder;
    }
  }
  
  public static final SpannableStringBuilder i(z paramz, int paramInt)
  {
    AppMethodBeat.i(212675);
    p.h(paramz, "info");
    SpannableStringBuilder localSpannableStringBuilder = new SpannableStringBuilder();
    Map localMap = M(paramz);
    if (localMap == null)
    {
      AppMethodBeat.o(212675);
      return localSpannableStringBuilder;
    }
    if ((localMap != null) && (Util.isNullOrNil((String)localMap.get(".msgsource.notify_msg.act"))))
    {
      AppMethodBeat.o(212675);
      return localSpannableStringBuilder;
    }
    kotlin.g.a.b localb = (kotlin.g.a.b)new ag.c(localMap);
    StringBuilder localStringBuilder = new StringBuilder(".msgsource.notify_msg.msg.item");
    if (paramInt == 0) {}
    for (paramz = "";; paramz = Integer.valueOf(paramInt))
    {
      paramz = paramz;
      if (!Util.isNullOrNil((String)localMap.get(paramz + ".content"))) {
        localSpannableStringBuilder.append((CharSequence)localb.invoke(paramz));
      }
      AppMethodBeat.o(212675);
      return localSpannableStringBuilder;
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<no name provided>", "", "invoke"})
  static final class a
    extends q
    implements a<String>
  {
    a(z paramz)
    {
      super();
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<no name provided>", "", "invoke"})
  public static final class d
    extends q
    implements a<x>
  {
    public d(z paramz, Map paramMap, Context paramContext)
    {
      super();
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<no name provided>", "", "invoke"})
  public static final class e
    extends q
    implements a<x>
  {
    public e(Map paramMap, z paramz, Context paramContext)
    {
      super();
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<no name provided>", "", "invoke"})
  public static final class f
    extends q
    implements a<x>
  {
    public f(Map paramMap, z paramz, Context paramContext)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.storage.ag
 * JD-Core Version:    0.7.0.1
 */