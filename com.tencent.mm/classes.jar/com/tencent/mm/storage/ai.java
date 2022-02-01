package com.tencent.mm.storage;

import android.text.SpannableStringBuilder;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.af;
import com.tencent.mm.autogen.b.ap;
import com.tencent.mm.autogen.b.bd;
import com.tencent.mm.autogen.b.fi;
import com.tencent.mm.plugin.expt.b.c;
import com.tencent.mm.plugin.expt.b.c.a;
import com.tencent.mm.plugin.messenger.foundation.a.n;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MultiProcessMMKV;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.XmlParser;
import java.util.Map;
import kotlin.Metadata;
import kotlin.g.a.a;
import kotlin.g.a.b;
import kotlin.g.b.s;
import kotlin.g.b.u;

@Metadata(d1={""}, d2={"cacheAvatarUrl", "", "cacheFollowMsgId", "", "cacheFollowValues", "", "cacheMsgId", "cacheUrlMsgId", "cacheValues", "checkNewDyeingTemplate", "", "info", "Lcom/tencent/mm/storage/BizTimeLineInfo;", "checkShowDigesNum", "getArticleUrl", "getAvatarUrl", "getDisplayName", "getDyeingDigest", "getDyeingTemplateWord", "Landroid/text/SpannableStringBuilder;", "index", "", "getFollowDisplayName", "getFollowDyeingTemplateWord", "getFollowValue", "getIconUrl", "getItemShowType", "getMsgType", "getUnreadCount", "getUserName", "getValue", "hasOfficialAccountRedDot", "isDyeingTemplateToTimeline", "msg", "Lcom/tencent/mm/storage/MsgInfo;", "msgCluster", "onDyeingTemplateClick", "", "context", "Landroid/content/Context;", "reportMsgNotify", "username", "actionType", "notifyType", "notifyMsgId", "notifyRow", "sessionId", "scene", "enterId", "setFollowMaxLine", "view", "Landroid/widget/TextView;", "setMaxLine", "plugin-biz_release"}, k=2, mv={1, 5, 1}, xi=48)
public final class ai
{
  private static long acGI;
  private static String acGJ;
  private static long acGK;
  private static Map<String, String> acGL;
  private static long acGM;
  private static Map<String, String> acGN;
  
  public static final String L(ab paramab)
  {
    AppMethodBeat.i(248521);
    s.u(paramab, "info");
    a locala = (a)new a(paramab);
    Object localObject1 = "";
    Object localObject2;
    String str;
    if ((paramab.iYl()) || (paramab.iYk()))
    {
      localObject2 = R(paramab);
      str = ".msgsource.notify_msg.";
    }
    for (;;)
    {
      if (localObject2 != null)
      {
        localObject2 = (String)((Map)localObject2).get(s.X(str, "box_digest"));
        localObject1 = localObject2;
        if (localObject2 == null) {
          localObject1 = "";
        }
      }
      localObject2 = localObject1;
      if (Util.isNullOrNil((String)localObject1))
      {
        localObject2 = localObject1;
        if (paramab.iYi()) {
          localObject2 = (String)locala.invoke();
        }
      }
      AppMethodBeat.o(248521);
      return localObject2;
      if (paramab.iYi())
      {
        localObject2 = P(paramab);
        str = ".msg.appmsg.mmreader.notify_msg.";
      }
      else
      {
        localObject2 = null;
        str = null;
      }
    }
  }
  
  public static final String M(ab paramab)
  {
    AppMethodBeat.i(248526);
    s.u(paramab, "info");
    paramab = P(paramab);
    if (paramab == null)
    {
      AppMethodBeat.o(248526);
      return "";
    }
    paramab = (String)paramab.get(".msg.appmsg.mmreader.notify_msg.publisher_username");
    if (paramab == null)
    {
      AppMethodBeat.o(248526);
      return "";
    }
    AppMethodBeat.o(248526);
    return paramab;
  }
  
  public static final String N(ab paramab)
  {
    AppMethodBeat.i(248539);
    s.u(paramab, "info");
    if ((paramab.field_msgId == acGI) && (acGJ != null))
    {
      paramab = acGJ;
      s.checkNotNull(paramab);
      AppMethodBeat.o(248539);
      return paramab;
    }
    Object localObject = XmlParser.parseXml(paramab.field_content, "avatar_url", null);
    if (localObject == null)
    {
      AppMethodBeat.o(248539);
      return "";
    }
    String str = (String)((Map)localObject).get(".avatar_url");
    localObject = str;
    if (str == null) {
      localObject = "";
    }
    acGJ = (String)localObject;
    acGI = paramab.field_msgId;
    AppMethodBeat.o(248539);
    return localObject;
  }
  
  public static final boolean O(ab paramab)
  {
    AppMethodBeat.i(248560);
    s.u(paramab, "info");
    if (!paramab.iYi())
    {
      AppMethodBeat.o(248560);
      return false;
    }
    paramab = P(paramab);
    if (paramab == null)
    {
      AppMethodBeat.o(248560);
      return false;
    }
    if (!Util.isNullOrNil((String)paramab.get(".msg.appmsg.mmreader.notify_msg.act")))
    {
      AppMethodBeat.o(248560);
      return true;
    }
    Log.i("MicroMsg.BizTimeLineStorageLogicExKt", "checkNewDyeingTemplate false");
    AppMethodBeat.o(248560);
    return false;
  }
  
  public static final Map<String, String> P(ab paramab)
  {
    AppMethodBeat.i(248571);
    if ((paramab.field_msgId == acGK) && (acGL != null))
    {
      paramab = acGL;
      AppMethodBeat.o(248571);
      return paramab;
    }
    acGK = paramab.field_msgId;
    paramab = XmlParser.parseXml(paramab.field_content, "msg", null);
    acGL = paramab;
    AppMethodBeat.o(248571);
    return paramab;
  }
  
  public static final String Q(ab paramab)
  {
    AppMethodBeat.i(248594);
    s.u(paramab, "info");
    Map localMap = R(paramab);
    if (localMap == null)
    {
      AppMethodBeat.o(248594);
      return "";
    }
    StringBuilder localStringBuilder = new StringBuilder();
    String str = (String)localMap.get(".msgsource.notify_msg.title2");
    paramab = str;
    if (str == null) {
      paramab = "";
    }
    localStringBuilder = localStringBuilder.append(paramab).append(' ');
    str = (String)localMap.get(".msgsource.notify_msg.action");
    paramab = str;
    if (str == null) {
      paramab = "";
    }
    paramab = paramab;
    AppMethodBeat.o(248594);
    return paramab;
  }
  
  private static final Map<String, String> R(ab paramab)
  {
    AppMethodBeat.i(248598);
    if ((paramab.field_msgId == acGM) && (acGN != null))
    {
      paramab = acGN;
      AppMethodBeat.o(248598);
      return paramab;
    }
    acGM = paramab.field_msgId;
    paramab = XmlParser.parseXml(paramab.jUr, "msgsource", null);
    acGN = paramab;
    AppMethodBeat.o(248598);
    return paramab;
  }
  
  public static final void a(ab paramab, int paramInt, TextView paramTextView)
  {
    AppMethodBeat.i(248512);
    s.u(paramab, "info");
    s.u(paramTextView, "view");
    Map localMap = P(paramab);
    if (localMap != null) {
      if (paramInt == 0)
      {
        paramab = "";
        paramab = s.X(".msg.appmsg.mmreader.notify_msg.msg.item", paramab);
        Log.i("MicroMsg.BizTimeLineStorageLogicExKt", String.valueOf(localMap.get(s.X(paramab, ".max_line_count"))));
        if (Util.isNullOrNil((String)localMap.get(s.X(paramab, ".max_line_count")))) {
          break label134;
        }
      }
    }
    label134:
    for (paramInt = Util.getInt((String)localMap.get(s.X(paramab, ".max_line_count")), 2);; paramInt = 0)
    {
      int i = paramInt;
      if (paramInt == 0) {
        i = 2147483647;
      }
      paramTextView.setMaxLines(i);
      AppMethodBeat.o(248512);
      return;
      paramab = Integer.valueOf(paramInt);
      break;
    }
  }
  
  public static final void a(String paramString, int paramInt1, int paramInt2, long paramLong, int paramInt3, int paramInt4, int paramInt5, int paramInt6)
  {
    AppMethodBeat.i(248578);
    int i = (int)(System.currentTimeMillis() / 1000L);
    com.tencent.mm.plugin.report.service.h.OAn.b(17750, new Object[] { paramString, Integer.valueOf(i), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Long.valueOf(paramLong), Integer.valueOf(paramInt3), Integer.valueOf(paramInt4), Integer.valueOf(paramInt5), Integer.valueOf(paramInt6) });
    AppMethodBeat.o(248578);
  }
  
  public static final void b(ab paramab, int paramInt, TextView paramTextView)
  {
    AppMethodBeat.i(248587);
    s.u(paramab, "info");
    s.u(paramTextView, "view");
    Map localMap = R(paramab);
    if (localMap != null) {
      if (paramInt == 0)
      {
        paramab = "";
        paramab = s.X(".msgsource.notify_msg.msg.item", paramab);
        Log.i("MicroMsg.BizTimeLineStorageLogicExKt", String.valueOf(localMap.get(s.X(paramab, ".max_line_count"))));
        if (Util.isNullOrNil((String)localMap.get(s.X(paramab, ".max_line_count")))) {
          break label137;
        }
      }
    }
    label137:
    for (paramInt = Util.getInt((String)localMap.get(s.X(paramab, ".max_line_count")), 2);; paramInt = 0)
    {
      int i = paramInt;
      if (paramInt == 0) {
        i = 2147483647;
      }
      paramTextView.setMaxLines(i);
      AppMethodBeat.o(248587);
      return;
      paramab = Integer.valueOf(paramInt);
      break;
    }
  }
  
  public static final int h(ab paramab)
  {
    AppMethodBeat.i(248546);
    s.u(paramab, "info");
    paramab = P(paramab);
    if (paramab == null)
    {
      AppMethodBeat.o(248546);
      return 0;
    }
    int i = Util.getInt((String)paramab.get(".msg.appmsg.mmreader.notify_msg.scene"), 0);
    AppMethodBeat.o(248546);
    return i;
  }
  
  public static final SpannableStringBuilder h(ab paramab, int paramInt)
  {
    AppMethodBeat.i(248516);
    s.u(paramab, "info");
    SpannableStringBuilder localSpannableStringBuilder = new SpannableStringBuilder();
    Map localMap = P(paramab);
    if (localMap == null)
    {
      AppMethodBeat.o(248516);
      return localSpannableStringBuilder;
    }
    if (Util.isNullOrNil((String)localMap.get(".msg.appmsg.mmreader.notify_msg.act")))
    {
      AppMethodBeat.o(248516);
      return localSpannableStringBuilder;
    }
    b localb = (b)new ai.b(localMap);
    if (paramInt == 0) {}
    for (paramab = "";; paramab = Integer.valueOf(paramInt))
    {
      paramab = s.X(".msg.appmsg.mmreader.notify_msg.msg.item", paramab);
      if (!Util.isNullOrNil((String)localMap.get(s.X(paramab, ".content")))) {
        localSpannableStringBuilder.append((CharSequence)localb.invoke(paramab));
      }
      AppMethodBeat.o(248516);
      return localSpannableStringBuilder;
    }
  }
  
  public static final boolean h(cc paramcc, String paramString)
  {
    AppMethodBeat.i(248509);
    if (paramcc == null)
    {
      AppMethodBeat.o(248509);
      return false;
    }
    if (paramcc.jbz() == true) {}
    for (int i = 1; i == 0; i = 0)
    {
      Log.i("MicroMsg.BizTimeLineStorageLogicExKt", "isDyeingTemplateToTimeline isTemplateMsg false");
      AppMethodBeat.o(248509);
      return false;
    }
    if (!au.bwv(paramString))
    {
      Log.i("MicroMsg.BizTimeLineStorageLogicExKt", "isDyeingTemplateToTimeline isMsgClusterNotifyMessage = false");
      AppMethodBeat.o(248509);
      return false;
    }
    paramString = (c)com.tencent.mm.kernel.h.ax(c.class);
    if ((paramString != null) && (paramString.a(c.a.yOx, 1) == 1)) {}
    for (i = 1; i == 0; i = 0)
    {
      Log.i("MicroMsg.BizTimeLineStorageLogicExKt", "isDyeingTemplateToTimeline open = false");
      AppMethodBeat.o(248509);
      return false;
    }
    paramcc = XmlParser.parseXml(paramcc.field_content, "msg", null);
    if (paramcc != null)
    {
      paramcc = (String)paramcc.get(".msg.appmsg.mmreader.notify_msg.act");
      if (!Util.isNullOrNil(paramcc)) {}
      for (boolean bool = true;; bool = false)
      {
        Log.i("MicroMsg.BizTimeLineStorageLogicExKt", "isDyeingTemplateToTimeline notifyMsg = %s", new Object[] { Boolean.valueOf(bool) });
        if (Util.isNullOrNil(paramcc)) {
          break;
        }
        AppMethodBeat.o(248509);
        return true;
      }
      AppMethodBeat.o(248509);
      return false;
    }
    Log.i("MicroMsg.BizTimeLineStorageLogicExKt", "isDyeingTemplateToTimeline false");
    AppMethodBeat.o(248509);
    return false;
  }
  
  public static final SpannableStringBuilder i(ab paramab, int paramInt)
  {
    AppMethodBeat.i(248583);
    s.u(paramab, "info");
    SpannableStringBuilder localSpannableStringBuilder = new SpannableStringBuilder();
    Map localMap = R(paramab);
    if (localMap == null)
    {
      AppMethodBeat.o(248583);
      return localSpannableStringBuilder;
    }
    if (Util.isNullOrNil((String)localMap.get(".msgsource.notify_msg.act")))
    {
      AppMethodBeat.o(248583);
      return localSpannableStringBuilder;
    }
    b localb = (b)new ai.c(localMap);
    if (paramInt == 0) {}
    for (paramab = "";; paramab = Integer.valueOf(paramInt))
    {
      paramab = s.X(".msgsource.notify_msg.msg.item", paramab);
      if (!Util.isNullOrNil((String)localMap.get(s.X(paramab, ".content")))) {
        localSpannableStringBuilder.append((CharSequence)localb.invoke(paramab));
      }
      AppMethodBeat.o(248583);
      return localSpannableStringBuilder;
    }
  }
  
  public static final int iZe()
  {
    AppMethodBeat.i(248554);
    Object localObject = ((n)com.tencent.mm.kernel.h.ax(n.class)).bzG();
    if (localObject == null) {}
    for (localObject = null; localObject == null; localObject = ((by)localObject).bxM("officialaccounts"))
    {
      AppMethodBeat.o(248554);
      return 0;
    }
    if (((bd)localObject).field_unReadCount <= 0)
    {
      if (((((bb)localObject).rx(8388608)) || (((bb)localObject).rx(2097152))) && (((bd)localObject).field_unReadMuteCount > 0))
      {
        AppMethodBeat.o(248554);
        return 1;
      }
      AppMethodBeat.o(248554);
      return 0;
    }
    if ((!((bb)localObject).rx(16)) && (!((bb)localObject).rx(64)))
    {
      AppMethodBeat.o(248554);
      return 0;
    }
    AppMethodBeat.o(248554);
    return 1;
  }
  
  public static final boolean iZf()
  {
    boolean bool2 = true;
    AppMethodBeat.i(248565);
    long l = MultiProcessMMKV.getSingleMMKV("brandService").decodeLong("BizLastMsgId");
    boolean bool1 = bool2;
    if (l < 0L)
    {
      Object localObject = af.bHo().aq(l, "msgId");
      bool1 = bool2;
      if (localObject != null)
      {
        bool1 = bool2;
        if (((ab)localObject).iYi())
        {
          localObject = P((ab)localObject);
          if (localObject == null)
          {
            AppMethodBeat.o(248565);
            return true;
          }
          if (Util.getInt((String)((Map)localObject).get(".msg.appmsg.mmreader.notify_msg.is_show_msg_count"), 1) != 1) {
            break label109;
          }
        }
      }
    }
    label109:
    for (bool1 = true;; bool1 = false)
    {
      AppMethodBeat.o(248565);
      return bool1;
    }
  }
  
  @Metadata(d1={""}, d2={"<no name provided>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class a
    extends u
    implements a<String>
  {
    a(ab paramab)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     com.tencent.mm.storage.ai
 * JD-Core Version:    0.7.0.1
 */