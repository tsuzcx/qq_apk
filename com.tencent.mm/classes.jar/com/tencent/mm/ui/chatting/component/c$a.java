package com.tencent.mm.ui.chatting.component;

import android.view.View;
import android.view.View.OnAttachStateChangeListener;
import androidx.compose.a.q.a..ExternalSyntheticBackport0;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.storage.cc;
import com.tencent.mm.ui.chatting.d.a;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/ui/chatting/component/AppMsgWxaReportComponent$Companion;", "", "()V", "ACTION_CLICK", "", "ACTION_EXPOSE", "CHAT_ROOM_USER_COUNT_NOT_CHAT_ROOM", "DEBUG", "", "getDEBUG$annotations", "MSG_VIEW_EXPOSE_PERCENT_THRESHOLD", "", "TAG", "", "WXA_MSG_TYPE_DYNAMIC", "WXA_MSG_TYPE_FINDER", "WXA_MSG_TYPE_NORMAL", "WXA_MSG_TYPE_PROFILE", "tryMarkAppMsgWxaViewClick", "", "chattingContext", "Lcom/tencent/mm/ui/chatting/context/ChattingContext;", "view", "Landroid/view/View;", "msg", "Lcom/tencent/mm/storage/MsgInfo;", "tryMarkAppMsgWxaViewExpose", "isNullOrEmpty", "Lcom/tencent/mm/ui/chatting/component/AppMsgWxaReportComponent$Companion$LongList;", "AppMsgWxaStatHelpfulInfo", "AppMsgWxaStatInfo", "AppMsgWxaType", "AppMsgWxaViewAttachStateChangeListener", "CachedAppMsgContent", "CachedMsgInfo", "CachedStatHelpfulInfo", "ChattingStatInfo", "LongList", "ParseHelpfulInfoContext", "StatefulAppMsgWxaStatInfo", "app_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class c$a
{
  static boolean a(i parami)
  {
    boolean bool = false;
    if (parami != null) {
      if (parami.aeoS > 0) {
        break label23;
      }
    }
    label23:
    for (int i = 1;; i = 0)
    {
      if (i != 0) {
        bool = true;
      }
      return bool;
    }
  }
  
  public static void c(a parama, View paramView, cc paramcc)
  {
    AppMethodBeat.i(255953);
    if (parama == null)
    {
      AppMethodBeat.o(255953);
      return;
    }
    if (paramView == null)
    {
      AppMethodBeat.o(255953);
      return;
    }
    if (paramcc == null)
    {
      AppMethodBeat.o(255953);
      return;
    }
    com.tencent.mm.ui.chatting.component.api.c localc = (com.tencent.mm.ui.chatting.component.api.c)parama.cm(com.tencent.mm.ui.chatting.component.api.c.class);
    if (localc != null) {
      localc.a(parama, paramView, paramcc);
    }
    AppMethodBeat.o(255953);
  }
  
  public static void d(a parama, View paramView, cc paramcc)
  {
    AppMethodBeat.i(255959);
    if (parama == null)
    {
      AppMethodBeat.o(255959);
      return;
    }
    if (paramView == null)
    {
      AppMethodBeat.o(255959);
      return;
    }
    if (paramcc == null)
    {
      AppMethodBeat.o(255959);
      return;
    }
    com.tencent.mm.ui.chatting.component.api.c localc = (com.tencent.mm.ui.chatting.component.api.c)parama.cm(com.tencent.mm.ui.chatting.component.api.c.class);
    if (localc != null) {
      localc.b(parama, paramView, paramcc);
    }
    AppMethodBeat.o(255959);
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/ui/chatting/component/AppMsgWxaReportComponent$Companion$AppMsgWxaStatInfo;", "", "msgId", "", "wxaMsgId", "wxaMsgType", "", "wxaMsgSenderUsername", "", "appId", "username", "enterPath", "scene", "(JJILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;I)V", "_exposeTimePeriod", "_hardCodeExposed", "", "getAppId", "()Ljava/lang/String;", "curExposeStartTime", "getEnterPath", "exposeTimePeriod", "getExposeTimePeriod", "()J", "hardCodeExposed", "getHardCodeExposed", "()Z", "isExposed", "isExposedBeforeBackground", "isRevoked", "getMsgId", "getScene", "()I", "getUsername", "getWxaMsgId", "getWxaMsgSenderUsername", "getWxaMsgType", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "copy", "equals", "other", "hashCode", "markBackground", "", "markEndExpose", "curTimeMills", "(Ljava/lang/Long;)V", "markExpose", "markForeground", "markRevoked", "markStartExpose", "toString", "app_release"}, k=1, mv={1, 5, 1}, xi=48)
  static final class b
  {
    private long aeoA;
    boolean aeoB;
    boolean aeoC;
    boolean aeoD;
    final long aeow;
    final int aeox;
    final String aeoy;
    private long aeoz;
    final String appId;
    final long msgId;
    final String qAF;
    final int scene;
    final String username;
    
    public b(long paramLong1, long paramLong2, int paramInt1, String paramString1, String paramString2, String paramString3, String paramString4, int paramInt2)
    {
      AppMethodBeat.i(255913);
      this.msgId = paramLong1;
      this.aeow = paramLong2;
      this.aeox = paramInt1;
      this.aeoy = paramString1;
      this.appId = paramString2;
      this.username = paramString3;
      this.qAF = paramString4;
      this.scene = paramInt2;
      this.aeoA = -1L;
      AppMethodBeat.o(255913);
    }
    
    public final boolean equals(Object paramObject)
    {
      AppMethodBeat.i(255944);
      if (this == paramObject)
      {
        AppMethodBeat.o(255944);
        return true;
      }
      if (!(paramObject instanceof b))
      {
        AppMethodBeat.o(255944);
        return false;
      }
      paramObject = (b)paramObject;
      if (this.msgId != paramObject.msgId)
      {
        AppMethodBeat.o(255944);
        return false;
      }
      if (this.aeow != paramObject.aeow)
      {
        AppMethodBeat.o(255944);
        return false;
      }
      if (this.aeox != paramObject.aeox)
      {
        AppMethodBeat.o(255944);
        return false;
      }
      if (!s.p(this.aeoy, paramObject.aeoy))
      {
        AppMethodBeat.o(255944);
        return false;
      }
      if (!s.p(this.appId, paramObject.appId))
      {
        AppMethodBeat.o(255944);
        return false;
      }
      if (!s.p(this.username, paramObject.username))
      {
        AppMethodBeat.o(255944);
        return false;
      }
      if (!s.p(this.qAF, paramObject.qAF))
      {
        AppMethodBeat.o(255944);
        return false;
      }
      if (this.scene != paramObject.scene)
      {
        AppMethodBeat.o(255944);
        return false;
      }
      AppMethodBeat.o(255944);
      return true;
    }
    
    public final int hashCode()
    {
      AppMethodBeat.i(255937);
      int i = q.a..ExternalSyntheticBackport0.m(this.msgId);
      int j = q.a..ExternalSyntheticBackport0.m(this.aeow);
      int k = this.aeox;
      int m = this.aeoy.hashCode();
      int n = this.appId.hashCode();
      int i1 = this.username.hashCode();
      int i2 = this.qAF.hashCode();
      int i3 = this.scene;
      AppMethodBeat.o(255937);
      return ((((((i * 31 + j) * 31 + k) * 31 + m) * 31 + n) * 31 + i1) * 31 + i2) * 31 + i3;
    }
    
    public final boolean jqM()
    {
      return 0L < this.aeoA;
    }
    
    public final long jqN()
    {
      AppMethodBeat.i(255920);
      if (jqM())
      {
        l = System.currentTimeMillis();
        this.aeoz += l - this.aeoA;
        this.aeoA = l;
      }
      long l = this.aeoz;
      AppMethodBeat.o(255920);
      return l;
    }
    
    public final String toString()
    {
      AppMethodBeat.i(255935);
      String str = "AppMsgWxaStatInfo(msgId=" + this.msgId + ", wxaMsgId=" + this.aeow + ", wxaMsgType=" + this.aeox + ", wxaMsgSenderUsername='" + this.aeoy + "', appId='" + this.appId + "', username='" + this.username + "', enterPath='" + this.qAF + "', scene=" + this.scene + ", exposeTimePeriod=" + jqN() + ')';
      AppMethodBeat.o(255935);
      return str;
    }
    
    public final void v(Long paramLong)
    {
      AppMethodBeat.i(255924);
      Log.i("MicroMsg.AppMsgWxaReportComponent", s.X("markStartExpose, msgId: ", Long.valueOf(this.msgId)));
      if ((this.aeoD) || (jqM()))
      {
        Log.i("MicroMsg.AppMsgWxaReportComponent", "markStartExpose, already revoked or exposed");
        AppMethodBeat.o(255924);
        return;
      }
      if (paramLong == null) {}
      for (long l = System.currentTimeMillis();; l = paramLong.longValue())
      {
        this.aeoA = l;
        AppMethodBeat.o(255924);
        return;
      }
    }
    
    public final void w(Long paramLong)
    {
      AppMethodBeat.i(255930);
      Log.i("MicroMsg.AppMsgWxaReportComponent", s.X("markEndExpose, msgId: ", Long.valueOf(this.msgId)));
      if ((this.aeoD) || (!jqM()))
      {
        Log.i("MicroMsg.AppMsgWxaReportComponent", "markEndExpose, already revoked or has not exposed");
        AppMethodBeat.o(255930);
        return;
      }
      long l2 = this.aeoz;
      if (paramLong == null) {}
      for (long l1 = System.currentTimeMillis();; l1 = paramLong.longValue())
      {
        this.aeoz = (l1 - this.aeoA + l2);
        this.aeoA = -1L;
        AppMethodBeat.o(255930);
        return;
      }
    }
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/ui/chatting/component/AppMsgWxaReportComponent$Companion$AppMsgWxaViewAttachStateChangeListener;", "Landroid/view/View$OnAttachStateChangeListener;", "statefulStatInfo", "Lcom/tencent/mm/ui/chatting/component/AppMsgWxaReportComponent$Companion$StatefulAppMsgWxaStatInfo;", "(Lcom/tencent/mm/ui/chatting/component/AppMsgWxaReportComponent$Companion$StatefulAppMsgWxaStatInfo;)V", "name", "", "onViewAttachedToWindow", "", "v", "Landroid/view/View;", "onViewDetachedFromWindow", "toString", "app_release"}, k=1, mv={1, 5, 1}, xi=48)
  static final class d
    implements View.OnAttachStateChangeListener
  {
    private final c.a.k aeoO;
    private final String name;
    
    public d(c.a.k paramk)
    {
      AppMethodBeat.i(255904);
      this.aeoO = paramk;
      this.name = s.X("AppMsgWxaViewAttachStateChangeListener#", Long.valueOf(this.aeoO.aeoV.msgId));
      AppMethodBeat.o(255904);
    }
    
    public final void onViewAttachedToWindow(View paramView)
    {
      AppMethodBeat.i(255909);
      if (c.access$getDEBUG$cp()) {
        Log.d("MicroMsg.AppMsgWxaReportComponent", s.X("onViewAttachedToWindow, name: ", this.name));
      }
      AppMethodBeat.o(255909);
    }
    
    public final void onViewDetachedFromWindow(View paramView)
    {
      AppMethodBeat.i(255915);
      if (c.access$getDEBUG$cp()) {
        Log.d("MicroMsg.AppMsgWxaReportComponent", s.X("onViewDetachedFromWindow, name: ", this.name));
      }
      this.aeoO.aeoV.w(null);
      AppMethodBeat.o(255915);
    }
    
    public final String toString()
    {
      return this.name;
    }
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/ui/chatting/component/AppMsgWxaReportComponent$Companion$LongList;", "", "initCapacity", "", "(I)V", "elements", "", "newIndex", "add", "", "element", "", "clear", "contains", "", "forEach", "action", "Lkotlin/Function1;", "grow", "newCapacity", "isEmpty", "toString", "", "app_release"}, k=1, mv={1, 5, 1}, xi=48)
  static final class i
  {
    long[] aeoR;
    int aeoS;
    
    public i(int paramInt)
    {
      AppMethodBeat.i(255873);
      this.aeoR = new long[paramInt];
      AppMethodBeat.o(255873);
    }
    
    public final boolean contains(long paramLong)
    {
      if (this.aeoS <= 0) {}
      int k;
      do
      {
        return false;
        k = this.aeoS;
      } while (k <= 0);
      int j;
      for (int i = 0;; i = j)
      {
        j = i + 1;
        if (paramLong == this.aeoR[i]) {
          return true;
        }
        if (j >= k) {
          break;
        }
      }
    }
    
    public final String toString()
    {
      AppMethodBeat.i(255880);
      Object localObject1 = new StringBuilder().append(hashCode()).append('#');
      Object localObject2 = Arrays.copyOf(this.aeoR, this.aeoS);
      s.s(localObject2, "java.util.Arrays.copyOf(this, newSize)");
      localObject2 = Arrays.toString((long[])localObject2);
      s.s(localObject2, "java.util.Arrays.toString(this)");
      localObject1 = (String)localObject2;
      AppMethodBeat.o(255880);
      return localObject1;
    }
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/ui/chatting/component/AppMsgWxaReportComponent$Companion$StatefulAppMsgWxaStatInfo;", "", "statInfo", "Lcom/tencent/mm/ui/chatting/component/AppMsgWxaReportComponent$Companion$AppMsgWxaStatInfo;", "(Lcom/tencent/mm/ui/chatting/component/AppMsgWxaReportComponent$Companion$AppMsgWxaStatInfo;)V", "hasClicked", "", "getStatInfo", "()Lcom/tencent/mm/ui/chatting/component/AppMsgWxaReportComponent$Companion$AppMsgWxaStatInfo;", "component1", "copy", "equals", "other", "hashCode", "", "markClick", "toString", "", "app_release"}, k=1, mv={1, 5, 1}, xi=48)
  static final class k
  {
    final c.a.b aeoV;
    boolean ihE;
    
    public k(c.a.b paramb)
    {
      AppMethodBeat.i(255875);
      this.aeoV = paramb;
      AppMethodBeat.o(255875);
    }
    
    public final boolean equals(Object paramObject)
    {
      AppMethodBeat.i(255885);
      if (this == paramObject)
      {
        AppMethodBeat.o(255885);
        return true;
      }
      if (!(paramObject instanceof k))
      {
        AppMethodBeat.o(255885);
        return false;
      }
      paramObject = (k)paramObject;
      if (!s.p(this.aeoV, paramObject.aeoV))
      {
        AppMethodBeat.o(255885);
        return false;
      }
      AppMethodBeat.o(255885);
      return true;
    }
    
    public final int hashCode()
    {
      AppMethodBeat.i(255882);
      int i = this.aeoV.hashCode();
      AppMethodBeat.o(255882);
      return i;
    }
    
    public final String toString()
    {
      AppMethodBeat.i(255879);
      String str = "StatefulAppMsgWxaStatInfo(statInfo=" + this.aeoV + ')';
      AppMethodBeat.o(255879);
      return str;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.component.c.a
 * JD-Core Version:    0.7.0.1
 */