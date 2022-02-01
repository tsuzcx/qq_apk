package com.tencent.mm.storage;

import android.text.SpannableStringBuilder;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.ab;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.plugin.messenger.foundation.a.n;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.XmlParser;
import java.util.Map;
import kotlin.g.a.a;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"cacheAvatarUrl", "", "cacheFollowMsgId", "", "cacheFollowValues", "", "cacheMsgId", "cacheUrlMsgId", "cacheValues", "checkNewDyeingTemplate", "", "info", "Lcom/tencent/mm/storage/BizTimeLineInfo;", "checkShowDigesNum", "getArticleUrl", "getAvatarUrl", "getDisplayName", "getDyeingDigest", "getDyeingTemplateWord", "Landroid/text/SpannableStringBuilder;", "index", "", "getFollowDisplayName", "getFollowDyeingTemplateWord", "getFollowValue", "getIconUrl", "getItemShowType", "getMsgType", "getUnreadCount", "getUserName", "getValue", "hasOfficialAccountRedDot", "isDyeingTemplateToTimeline", "msg", "Lcom/tencent/mm/storage/MsgInfo;", "msgCluster", "onDyeingTemplateClick", "", "context", "Landroid/content/Context;", "reportMsgNotify", "username", "actionType", "notifyType", "notifyMsgId", "notifyRow", "sessionId", "scene", "enterId", "setFollowMaxLine", "view", "Landroid/widget/TextView;", "setMaxLine", "plugin-biz_release"})
public final class ag
{
  private static long Vft;
  private static String Vfu;
  private static long Vfv;
  private static Map<String, String> Vfw;
  private static long Vfx;
  private static Map<String, String> Vfy;
  
  public static final String M(z paramz)
  {
    AppMethodBeat.i(206136);
    p.k(paramz, "info");
    a locala = (a)new a(paramz);
    Object localObject1 = "";
    Object localObject2;
    String str;
    if ((paramz.hwH()) || (paramz.hwG()))
    {
      localObject2 = S(paramz);
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
        if (paramz.hwE()) {
          localObject2 = (String)locala.invoke();
        }
      }
      AppMethodBeat.o(206136);
      return localObject2;
      if (paramz.hwE())
      {
        localObject2 = Q(paramz);
        str = ".msg.appmsg.mmreader.notify_msg.";
      }
      else
      {
        localObject2 = null;
        str = null;
      }
    }
  }
  
  public static final String N(z paramz)
  {
    AppMethodBeat.i(206138);
    p.k(paramz, "info");
    String str = "";
    Map localMap = Q(paramz);
    if (localMap == null)
    {
      AppMethodBeat.o(206138);
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
    AppMethodBeat.o(206138);
    return paramz;
  }
  
  public static final String O(z paramz)
  {
    AppMethodBeat.i(206140);
    p.k(paramz, "info");
    if ((paramz.field_msgId == Vft) && (Vfu != null))
    {
      paramz = Vfu;
      if (paramz == null) {
        p.iCn();
      }
      AppMethodBeat.o(206140);
      return paramz;
    }
    Object localObject1 = "";
    Object localObject2 = XmlParser.parseXml(paramz.field_content, "avatar_url", null);
    if (localObject2 == null)
    {
      AppMethodBeat.o(206140);
      return "";
    }
    if (localObject2 != null)
    {
      localObject2 = (String)((Map)localObject2).get(".avatar_url");
      localObject1 = localObject2;
      if (localObject2 == null) {
        localObject1 = "";
      }
      Vfu = (String)localObject1;
      Vft = paramz.field_msgId;
    }
    AppMethodBeat.o(206140);
    return localObject1;
  }
  
  public static final boolean P(z paramz)
  {
    AppMethodBeat.i(206147);
    p.k(paramz, "info");
    if (!paramz.hwE())
    {
      AppMethodBeat.o(206147);
      return false;
    }
    paramz = Q(paramz);
    if (paramz == null)
    {
      AppMethodBeat.o(206147);
      return false;
    }
    if ((paramz != null) && (!Util.isNullOrNil((String)paramz.get(".msg.appmsg.mmreader.notify_msg.act"))))
    {
      AppMethodBeat.o(206147);
      return true;
    }
    Log.i("MicroMsg.BizTimeLineStorageLogicExKt", "checkNewDyeingTemplate false");
    AppMethodBeat.o(206147);
    return false;
  }
  
  public static final Map<String, String> Q(z paramz)
  {
    AppMethodBeat.i(206148);
    if ((paramz.field_msgId == Vfv) && (Vfw != null))
    {
      paramz = Vfw;
      AppMethodBeat.o(206148);
      return paramz;
    }
    Vfv = paramz.field_msgId;
    paramz = XmlParser.parseXml(paramz.field_content, "msg", null);
    Vfw = paramz;
    AppMethodBeat.o(206148);
    return paramz;
  }
  
  public static final String R(z paramz)
  {
    AppMethodBeat.i(206155);
    p.k(paramz, "info");
    String str = "";
    Map localMap = S(paramz);
    if (localMap == null)
    {
      AppMethodBeat.o(206155);
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
    AppMethodBeat.o(206155);
    return paramz;
  }
  
  private static final Map<String, String> S(z paramz)
  {
    AppMethodBeat.i(206158);
    if ((paramz.field_msgId == Vfx) && (Vfy != null))
    {
      paramz = Vfy;
      AppMethodBeat.o(206158);
      return paramz;
    }
    Vfx = paramz.field_msgId;
    paramz = XmlParser.parseXml(paramz.apc(), "msgsource", null);
    Vfy = paramz;
    AppMethodBeat.o(206158);
    return paramz;
  }
  
  public static final void a(z paramz, int paramInt, TextView paramTextView)
  {
    AppMethodBeat.i(206131);
    p.k(paramz, "info");
    p.k(paramTextView, "view");
    Map localMap = Q(paramz);
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
      AppMethodBeat.o(206131);
      return;
      paramz = Integer.valueOf(paramInt);
      break;
    }
  }
  
  public static final void a(String paramString, int paramInt1, int paramInt2, long paramLong, int paramInt3, int paramInt4, int paramInt5, int paramInt6)
  {
    AppMethodBeat.i(206151);
    int i = (int)(System.currentTimeMillis() / 1000L);
    com.tencent.mm.plugin.report.service.h.IzE.a(17750, new Object[] { paramString, Integer.valueOf(i), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Long.valueOf(paramLong), Integer.valueOf(paramInt3), Integer.valueOf(paramInt4), Integer.valueOf(paramInt5), Integer.valueOf(paramInt6) });
    AppMethodBeat.o(206151);
  }
  
  public static final void b(z paramz, int paramInt, TextView paramTextView)
  {
    AppMethodBeat.i(206154);
    p.k(paramz, "info");
    p.k(paramTextView, "view");
    Map localMap = S(paramz);
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
      AppMethodBeat.o(206154);
      return;
      paramz = Integer.valueOf(paramInt);
      break;
    }
  }
  
  public static final int f(z paramz)
  {
    AppMethodBeat.i(206142);
    p.k(paramz, "info");
    paramz = Q(paramz);
    if (paramz == null)
    {
      AppMethodBeat.o(206142);
      return 0;
    }
    if (paramz != null) {}
    for (int i = Util.getInt((String)paramz.get(".msg.appmsg.mmreader.notify_msg.scene"), 0);; i = 0)
    {
      AppMethodBeat.o(206142);
      return i;
    }
  }
  
  public static final boolean f(ca paramca, String paramString)
  {
    AppMethodBeat.i(206129);
    if (paramca == null)
    {
      AppMethodBeat.o(206129);
      return false;
    }
    if (paramca.hzw() != true)
    {
      Log.i("MicroMsg.BizTimeLineStorageLogicExKt", "isDyeingTemplateToTimeline isTemplateMsg false");
      AppMethodBeat.o(206129);
      return false;
    }
    if (!ab.QR(paramString))
    {
      Log.i("MicroMsg.BizTimeLineStorageLogicExKt", "isDyeingTemplateToTimeline isMsgClusterNotifyMessage = false");
      AppMethodBeat.o(206129);
      return false;
    }
    paramString = (com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.expt.b.b.class);
    if ((paramString != null) && (paramString.a(b.a.vAJ, 1) == 1)) {}
    for (int i = 1; i == 0; i = 0)
    {
      Log.i("MicroMsg.BizTimeLineStorageLogicExKt", "isDyeingTemplateToTimeline open = false");
      AppMethodBeat.o(206129);
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
        AppMethodBeat.o(206129);
        return true;
      }
      AppMethodBeat.o(206129);
      return false;
    }
    Log.i("MicroMsg.BizTimeLineStorageLogicExKt", "isDyeingTemplateToTimeline false");
    AppMethodBeat.o(206129);
    return false;
  }
  
  public static final int hxB()
  {
    AppMethodBeat.i(206144);
    Object localObject = com.tencent.mm.kernel.h.ae(n.class);
    p.j(localObject, "service(IMessengerStorage::class.java)");
    localObject = ((n)localObject).bbR();
    if (localObject != null)
    {
      localObject = ((bw)localObject).bwx("officialaccounts");
      if (localObject != null) {}
    }
    else
    {
      AppMethodBeat.o(206144);
      return 0;
    }
    if (((az)localObject).apz() <= 0)
    {
      if (((((az)localObject).rp(8388608)) || (((az)localObject).rp(2097152))) && (((az)localObject).apC() > 0))
      {
        AppMethodBeat.o(206144);
        return 1;
      }
      AppMethodBeat.o(206144);
      return 0;
    }
    if ((!((az)localObject).rp(16)) && (!((az)localObject).rp(64)))
    {
      AppMethodBeat.o(206144);
      return 0;
    }
    AppMethodBeat.o(206144);
    return 1;
  }
  
  public static final SpannableStringBuilder j(z paramz, int paramInt)
  {
    AppMethodBeat.i(206133);
    p.k(paramz, "info");
    SpannableStringBuilder localSpannableStringBuilder = new SpannableStringBuilder();
    Map localMap = Q(paramz);
    if (localMap == null)
    {
      AppMethodBeat.o(206133);
      return localSpannableStringBuilder;
    }
    if ((localMap != null) && (Util.isNullOrNil((String)localMap.get(".msg.appmsg.mmreader.notify_msg.act"))))
    {
      AppMethodBeat.o(206133);
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
      AppMethodBeat.o(206133);
      return localSpannableStringBuilder;
    }
  }
  
  public static final SpannableStringBuilder k(z paramz, int paramInt)
  {
    AppMethodBeat.i(206152);
    p.k(paramz, "info");
    SpannableStringBuilder localSpannableStringBuilder = new SpannableStringBuilder();
    Map localMap = S(paramz);
    if (localMap == null)
    {
      AppMethodBeat.o(206152);
      return localSpannableStringBuilder;
    }
    if ((localMap != null) && (Util.isNullOrNil((String)localMap.get(".msgsource.notify_msg.act"))))
    {
      AppMethodBeat.o(206152);
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
      AppMethodBeat.o(206152);
      return localSpannableStringBuilder;
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<no name provided>", "", "invoke"})
  static final class a
    extends q
    implements a<String>
  {
    a(z paramz)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.storage.ag
 * JD-Core Version:    0.7.0.1
 */