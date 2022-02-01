package com.tencent.mm.plugin.webview.ui.tools.floatball;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import androidx.compose.a.q.a..ExternalSyntheticBackport0;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ipcinvoker.type.IPCVoid;
import com.tencent.mm.ipcinvoker.wx_extension.service.ToolsMpProcessIPCService;
import com.tencent.mm.ipcinvoker.wx_extension.service.ToolsProcessIPCService;
import com.tencent.mm.plugin.ball.c.e;
import com.tencent.mm.plugin.ball.model.BallInfo;
import com.tencent.mm.plugin.brandservice.api.c;
import com.tencent.mm.plugin.multitask.model.MultiTaskInfo;
import com.tencent.mm.plugin.webview.core.BaseWebViewController;
import com.tencent.mm.protocal.protobuf.ghm;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.threadpool.i;
import java.lang.ref.SoftReference;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.b.s;
import kotlin.g.b.u;
import kotlin.j;
import kotlin.n.n;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/webview/ui/tools/floatball/WebViewFloatBallMgr;", "", "()V", "TAG", "", "floatBallInfoEventListener", "Lcom/tencent/mm/plugin/ball/api/OnFloatBallInfoEventListener;", "removedMap", "Ljava/util/concurrent/ConcurrentHashMap;", "", "getRemovedMap", "()Ljava/util/concurrent/ConcurrentHashMap;", "useNewFloatBall", "getUseNewFloatBall$annotations", "getUseNewFloatBall", "()Z", "useNewFloatBall$delegate", "Lkotlin/Lazy;", "webViewCtlMap", "Ljava/lang/ref/SoftReference;", "Lcom/tencent/mm/plugin/webview/core/WebViewController;", "getWebViewCtlMap", "addFloatBallInfoEventListener", "", "doOnFloatBallInfoExposed", "ballInfo", "Lcom/tencent/mm/plugin/webview/ui/tools/floatball/WebViewFloatBallMgr$WebViewFloatBallDataObject;", "doOnFloatBallInfoRemoved", "getController", "id", "onBallRemove", "intent", "Landroid/content/Intent;", "onFloatBallInfoClick", "info", "Lcom/tencent/mm/plugin/multitask/model/MultiTaskInfo;", "onFloatBallInfoExposed", "onFloatBallInfoRemoved", "setController", "controller", "WebViewFloatBallDataObject", "plugin-webview_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class d
{
  public static final d XbW;
  private static final j XbX;
  private static final ConcurrentHashMap<String, SoftReference<com.tencent.mm.plugin.webview.core.k>> XbY;
  private static final ConcurrentHashMap<String, Boolean> XbZ;
  private static final e roL;
  
  static
  {
    AppMethodBeat.i(296349);
    XbW = new d();
    XbX = kotlin.k.cm((kotlin.g.a.a)d.Xcc);
    XbY = new ConcurrentHashMap();
    XbZ = new ConcurrentHashMap();
    roL = (e)new c();
    AppMethodBeat.o(296349);
  }
  
  public static void a(a parama)
  {
    AppMethodBeat.i(296306);
    com.tencent.threadpool.h.ahAA.g(new d..ExternalSyntheticLambda3(parama), "WebViewFloatBallThread");
    AppMethodBeat.o(296306);
  }
  
  public static void a(String paramString, com.tencent.mm.plugin.webview.core.k paramk)
  {
    AppMethodBeat.i(296290);
    s.u(paramString, "id");
    s.u(paramk, "controller");
    ((Map)XbY).put(paramString, new SoftReference(paramk));
    AppMethodBeat.o(296290);
  }
  
  public static void b(a parama)
  {
    AppMethodBeat.i(296309);
    if (Math.abs(System.currentTimeMillis() - parama.vjF) < 1800000L)
    {
      AppMethodBeat.o(296309);
      return;
    }
    com.tencent.threadpool.h.ahAA.g(new d..ExternalSyntheticLambda4(parama), "WebViewFloatBallThread");
    AppMethodBeat.o(296309);
  }
  
  private static final void b(String paramString, com.tencent.mm.plugin.webview.core.k paramk)
  {
    AppMethodBeat.i(296346);
    XbY.remove(paramString);
    if (paramk.WwE)
    {
      com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(1553L, 11L, 1L, false);
      paramk.isB();
    }
    AppMethodBeat.o(296346);
  }
  
  private static void bP(Intent paramIntent)
  {
    AppMethodBeat.i(296314);
    try
    {
      String str = paramIntent.getStringExtra("float_ball_key");
      if (!Util.isNullOrNil(str))
      {
        s.checkNotNull(str);
        com.tencent.mm.plugin.webview.core.k localk = bmc(str);
        if (localk != null)
        {
          Log.i("MicroMsg.WebViewFloatBallManager", s.X("onBallRemove ", paramIntent.getStringExtra("rawUrl")));
          com.tencent.threadpool.h.ahAA.bk(new d..ExternalSyntheticLambda5(str, localk));
          AppMethodBeat.o(296314);
          return;
        }
      }
    }
    catch (Exception paramIntent)
    {
      Log.e("MicroMsg.WebViewFloatBallManager", s.X("onRemove is null, ", paramIntent.getMessage()));
      AppMethodBeat.o(296314);
    }
  }
  
  public static com.tencent.mm.plugin.webview.core.k bmc(String paramString)
  {
    AppMethodBeat.i(296285);
    s.u(paramString, "id");
    paramString = (SoftReference)XbY.get(paramString);
    if (paramString == null)
    {
      AppMethodBeat.o(296285);
      return null;
    }
    paramString = (com.tencent.mm.plugin.webview.core.k)paramString.get();
    AppMethodBeat.o(296285);
    return paramString;
  }
  
  private static final void c(Intent paramIntent, com.tencent.mm.ipcinvoker.f paramf)
  {
    AppMethodBeat.i(296325);
    s.s(paramIntent, "intent");
    bP(paramIntent);
    AppMethodBeat.o(296325);
  }
  
  private static final void c(a parama)
  {
    AppMethodBeat.i(296333);
    Intent localIntent = new Intent();
    localIntent.putExtra("rawUrl", parama.idu);
    if (Util.isNullOrNil(parama.key))
    {
      AppMethodBeat.o(296333);
      return;
    }
    localIntent.putExtra("float_ball_key", parama.key);
    parama = parama.Xca;
    if (parama == null)
    {
      AppMethodBeat.o(296333);
      return;
    }
    if (n.T("com.tencent.mm:toolsmp", parama, true))
    {
      parama = ToolsMpProcessIPCService.PROCESS_NAME;
      s.s(parama, "PROCESS_NAME");
      com.tencent.mm.ipcinvoker.a.a(parama, (Parcelable)localIntent, d..ExternalSyntheticLambda0.INSTANCE);
      AppMethodBeat.o(296333);
      return;
    }
    parama = ToolsProcessIPCService.PROCESS_NAME;
    s.s(parama, "PROCESS_NAME");
    com.tencent.mm.ipcinvoker.a.a(parama, (Parcelable)localIntent, d..ExternalSyntheticLambda2.INSTANCE);
    AppMethodBeat.o(296333);
  }
  
  private static final void d(Intent paramIntent, com.tencent.mm.ipcinvoker.f paramf)
  {
    AppMethodBeat.i(296329);
    s.s(paramIntent, "intent");
    bP(paramIntent);
    AppMethodBeat.o(296329);
  }
  
  private static final void d(a parama)
  {
    AppMethodBeat.i(296344);
    Object localObject1 = (CharSequence)parama.idu;
    if ((localObject1 == null) || (n.bp((CharSequence)localObject1))) {}
    for (int i = 1; (i != 0) || (Util.isNullOrNil(parama.key)) || (XbZ.containsKey(parama.key)); i = 0)
    {
      AppMethodBeat.o(296344);
      return;
    }
    localObject1 = parama.idu;
    Object localObject2 = (c)com.tencent.mm.kernel.h.ax(c.class);
    if ((localObject2 != null) && (((c)localObject2).aiy((String)localObject1) == true)) {}
    for (i = 1;; i = 0)
    {
      if (i != 0)
      {
        localObject1 = new Intent();
        ((Intent)localObject1).putExtra("rawUrl", parama.idu);
        ((Intent)localObject1).putExtra("float_ball_key", parama.key);
        localObject2 = ToolsMpProcessIPCService.PROCESS_NAME;
        s.s(localObject2, "PROCESS_NAME");
        com.tencent.mm.ipcinvoker.a.a((String)localObject2, (Parcelable)localObject1, d..ExternalSyntheticLambda1.INSTANCE, (kotlin.g.a.b)new b(parama));
      }
      AppMethodBeat.o(296344);
      return;
    }
  }
  
  private static final void e(Intent paramIntent, com.tencent.mm.ipcinvoker.f paramf)
  {
    AppMethodBeat.i(296339);
    com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(1553L, 10L, 1L, false);
    s.s(paramIntent, "intent");
    bP(paramIntent);
    if (paramf != null) {
      paramf.onCallback(new IPCVoid());
    }
    AppMethodBeat.o(296339);
  }
  
  public static void iuI()
  {
    AppMethodBeat.i(296297);
    com.tencent.threadpool.h.ahAA.o(d..ExternalSyntheticLambda6.INSTANCE, 10000L);
    AppMethodBeat.o(296297);
  }
  
  public static final boolean izQ()
  {
    AppMethodBeat.i(296275);
    boolean bool = ((Boolean)XbX.getValue()).booleanValue();
    AppMethodBeat.o(296275);
    return bool;
  }
  
  public static ConcurrentHashMap<String, Boolean> izR()
  {
    return XbZ;
  }
  
  private static final void izS()
  {
    AppMethodBeat.i(296321);
    com.tencent.mm.plugin.ball.c.b localb = (com.tencent.mm.plugin.ball.c.b)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.ball.c.b.class);
    if (localb != null) {
      localb.a(2, roL);
    }
    AppMethodBeat.o(296321);
  }
  
  public static void s(MultiTaskInfo paramMultiTaskInfo)
  {
    AppMethodBeat.i(296300);
    if (paramMultiTaskInfo == null)
    {
      AppMethodBeat.o(296300);
      return;
    }
    Object localObject = new ghm();
    String str1;
    try
    {
      ((ghm)localObject).parseFrom(paramMultiTaskInfo.field_data);
      str1 = ((ghm)localObject).idu;
      if (str1 == null)
      {
        AppMethodBeat.o(296300);
        return;
      }
    }
    finally
    {
      Log.e("MicroMsg.WebViewFloatBallManager", "WebMultiTaskData parse fail", new Object[] { paramMultiTaskInfo });
      AppMethodBeat.o(296300);
      return;
    }
    localObject = ((ghm)localObject).acdU;
    String str2 = paramMultiTaskInfo.field_id;
    if (str2 == null)
    {
      AppMethodBeat.o(296300);
      return;
    }
    a(new a(str1, (String)localObject, str2, paramMultiTaskInfo.field_updateTime));
    AppMethodBeat.o(296300);
  }
  
  public static void t(MultiTaskInfo paramMultiTaskInfo)
  {
    AppMethodBeat.i(296301);
    if (paramMultiTaskInfo == null)
    {
      AppMethodBeat.o(296301);
      return;
    }
    Object localObject = new ghm();
    String str1;
    try
    {
      ((ghm)localObject).parseFrom(paramMultiTaskInfo.field_data);
      str1 = ((ghm)localObject).idu;
      if (str1 == null)
      {
        AppMethodBeat.o(296301);
        return;
      }
    }
    finally
    {
      Log.e("MicroMsg.WebViewFloatBallManager", "WebMultiTaskData parse fail", new Object[] { paramMultiTaskInfo });
      AppMethodBeat.o(296301);
      return;
    }
    localObject = ((ghm)localObject).acdU;
    String str2 = paramMultiTaskInfo.field_id;
    if (str2 == null)
    {
      AppMethodBeat.o(296301);
      return;
    }
    b(new a(str1, (String)localObject, str2, paramMultiTaskInfo.field_updateTime));
    AppMethodBeat.o(296301);
  }
  
  public static void u(MultiTaskInfo paramMultiTaskInfo)
  {
    AppMethodBeat.i(296303);
    if (paramMultiTaskInfo == null)
    {
      AppMethodBeat.o(296303);
      return;
    }
    XbZ.remove(paramMultiTaskInfo.field_id);
    AppMethodBeat.o(296303);
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/webview/ui/tools/floatball/WebViewFloatBallMgr$WebViewFloatBallDataObject;", "", "rawUrl", "", "currentProcess", "key", "activeTime", "", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;J)V", "getActiveTime", "()J", "getCurrentProcess", "()Ljava/lang/String;", "getKey", "getRawUrl", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "", "toString", "plugin-webview_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a
  {
    final String Xca;
    final String idu;
    final String key;
    final long vjF;
    
    public a(String paramString1, String paramString2, String paramString3, long paramLong)
    {
      AppMethodBeat.i(296265);
      this.idu = paramString1;
      this.Xca = paramString2;
      this.key = paramString3;
      this.vjF = paramLong;
      AppMethodBeat.o(296265);
    }
    
    public final boolean equals(Object paramObject)
    {
      AppMethodBeat.i(296282);
      if (this == paramObject)
      {
        AppMethodBeat.o(296282);
        return true;
      }
      if (!(paramObject instanceof a))
      {
        AppMethodBeat.o(296282);
        return false;
      }
      paramObject = (a)paramObject;
      if (!s.p(this.idu, paramObject.idu))
      {
        AppMethodBeat.o(296282);
        return false;
      }
      if (!s.p(this.Xca, paramObject.Xca))
      {
        AppMethodBeat.o(296282);
        return false;
      }
      if (!s.p(this.key, paramObject.key))
      {
        AppMethodBeat.o(296282);
        return false;
      }
      if (this.vjF != paramObject.vjF)
      {
        AppMethodBeat.o(296282);
        return false;
      }
      AppMethodBeat.o(296282);
      return true;
    }
    
    public final int hashCode()
    {
      AppMethodBeat.i(296274);
      int j = this.idu.hashCode();
      if (this.Xca == null) {}
      for (int i = 0;; i = this.Xca.hashCode())
      {
        int k = this.key.hashCode();
        int m = q.a..ExternalSyntheticBackport0.m(this.vjF);
        AppMethodBeat.o(296274);
        return ((i + j * 31) * 31 + k) * 31 + m;
      }
    }
    
    public final String toString()
    {
      AppMethodBeat.i(296270);
      String str = "WebViewFloatBallDataObject(rawUrl=" + this.idu + ", currentProcess=" + this.Xca + ", key=" + this.key + ", activeTime=" + this.vjF + ')';
      AppMethodBeat.o(296270);
      return str;
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "it", "Lcom/tencent/mm/ipcinvoker/type/IPCVoid;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class b
    extends u
    implements kotlin.g.a.b<IPCVoid, ah>
  {
    b(d.a parama)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/webview/ui/tools/floatball/WebViewFloatBallMgr$floatBallInfoEventListener$1", "Lcom/tencent/mm/plugin/ball/api/OnFloatBallInfoEventListenerAdapter;", "onFloatBallInfoClicked", "", "ballInfo", "Lcom/tencent/mm/plugin/ball/model/BallInfo;", "onFloatBallInfoExposed", "onFloatBallInfoRemoved", "plugin-webview_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class c
    extends com.tencent.mm.plugin.ball.c.f
  {
    public final void b(BallInfo paramBallInfo) {}
    
    public final void c(BallInfo paramBallInfo)
    {
      AppMethodBeat.i(296281);
      if (paramBallInfo == null)
      {
        AppMethodBeat.o(296281);
        return;
      }
      String str1 = paramBallInfo.oSS.getString("rawUrl");
      if (str1 == null)
      {
        AppMethodBeat.o(296281);
        return;
      }
      String str2 = paramBallInfo.oSS.getString("webviewCurrentProcess");
      String str3 = paramBallInfo.oSS.getString("float_ball_key");
      if (str3 == null)
      {
        AppMethodBeat.o(296281);
        return;
      }
      d locald = d.XbW;
      d.a(new d.a(str1, str2, str3, paramBallInfo.vjF));
      AppMethodBeat.o(296281);
    }
    
    public final void d(BallInfo paramBallInfo)
    {
      AppMethodBeat.i(296287);
      if (paramBallInfo == null)
      {
        AppMethodBeat.o(296287);
        return;
      }
      String str1 = paramBallInfo.oSS.getString("rawUrl");
      if (str1 == null)
      {
        AppMethodBeat.o(296287);
        return;
      }
      String str2 = paramBallInfo.oSS.getString("webviewCurrentProcess");
      String str3 = paramBallInfo.oSS.getString("float_ball_key");
      if (str3 == null)
      {
        AppMethodBeat.o(296287);
        return;
      }
      d locald = d.XbW;
      d.b(new d.a(str1, str2, str3, paramBallInfo.vjF));
      AppMethodBeat.o(296287);
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class d
    extends u
    implements kotlin.g.a.a<Boolean>
  {
    public static final d Xcc;
    
    static
    {
      AppMethodBeat.i(296266);
      Xcc = new d();
      AppMethodBeat.o(296266);
    }
    
    d()
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes13.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.floatball.d
 * JD-Core Version:    0.7.0.1
 */