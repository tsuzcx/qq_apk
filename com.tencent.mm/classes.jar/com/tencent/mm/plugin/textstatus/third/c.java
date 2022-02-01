package com.tencent.mm.plugin.textstatus.third;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.util.Base64;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.p;
import com.tencent.mm.plugin.textstatus.f.g;
import com.tencent.mm.plugin.textstatus.proto.TextStatusExtInfo;
import com.tencent.mm.plugin.textstatus.proto.ab;
import com.tencent.mm.plugin.textstatus.proto.r;
import com.tencent.mm.sdk.platformtools.Log;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.LinkedList;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.a.b;
import kotlin.g.b.u;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/textstatus/third/GetBrandTask;", "Lcom/tencent/mm/plugin/textstatus/api/IGetBrandTask;", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "context", "Landroid/app/Activity;", "url", "", "scanSource", "", "notifyFinishCallback", "Ljava/lang/Runnable;", "(Landroid/app/Activity;Ljava/lang/String;ILjava/lang/Runnable;)V", "contextRef", "Ljava/lang/ref/WeakReference;", "kotlin.jvm.PlatformType", "getContextRef", "()Ljava/lang/ref/WeakReference;", "isCancel", "", "()Z", "setCancel", "(Z)V", "netSceneRef", "Lcom/tencent/mm/modelbase/NetSceneBase;", "getNetSceneRef", "setNetSceneRef", "(Ljava/lang/ref/WeakReference;)V", "getNotifyFinishCallback", "()Ljava/lang/Runnable;", "onSceneEndRef", "Lcom/tencent/mm/plugin/textstatus/logic/WeakOnSceneEnd;", "getOnSceneEndRef", "()Lcom/tencent/mm/plugin/textstatus/logic/WeakOnSceneEnd;", "setOnSceneEndRef", "(Lcom/tencent/mm/plugin/textstatus/logic/WeakOnSceneEnd;)V", "getScanSource", "()I", "getUrl", "()Ljava/lang/String;", "cancel", "", "doTask", "onSceneEnd", "errType", "errCode", "errMsg", "scene", "preprocessExtInfo", "extInfoIn", "Lcom/tencent/mm/plugin/textstatus/proto/TextStatusExtInfo;", "callback", "Lkotlin/Function1;", "Companion", "plugin-textstatus_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class c
  implements com.tencent.mm.am.h, com.tencent.mm.plugin.textstatus.a.c
{
  public static final c.a TuF;
  final int TuG;
  final Runnable TuH;
  public WeakReference<p> TuI;
  public g TuJ;
  final WeakReference<Activity> contextRef;
  boolean nzW;
  public final String url;
  
  static
  {
    AppMethodBeat.i(290110);
    TuF = new c.a((byte)0);
    AppMethodBeat.o(290110);
  }
  
  public c(Activity paramActivity, String paramString, int paramInt, Runnable paramRunnable)
  {
    AppMethodBeat.i(290105);
    this.url = paramString;
    this.TuG = paramInt;
    this.TuH = paramRunnable;
    this.contextRef = new WeakReference(paramActivity);
    AppMethodBeat.o(290105);
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, p paramp)
  {
    AppMethodBeat.i(290127);
    if ((paramp instanceof com.tencent.mm.plugin.textstatus.h.d))
    {
      com.tencent.mm.kernel.h.aZW().b(((com.tencent.mm.plugin.textstatus.h.d)paramp).getType(), (com.tencent.mm.am.h)this.TuJ);
      if (this.nzW)
      {
        AppMethodBeat.o(290127);
        return;
      }
      paramString = ((com.tencent.mm.plugin.textstatus.h.d)paramp).TmI;
      if (paramString != null) {
        break label119;
      }
      paramInt1 = -1;
      Log.i("MicroMsg.TextStatus.GetBrandTask", kotlin.g.b.s.X("GetBrandInfo templates:", Integer.valueOf(paramInt1)));
      paramString = ((com.tencent.mm.plugin.textstatus.h.d)paramp).TmI;
      if (paramString != null) {
        break label155;
      }
      paramString = null;
    }
    for (;;)
    {
      if (paramString == null)
      {
        paramString = ((c)this).TuH;
        if (paramString != null) {
          paramString.run();
        }
      }
      AppMethodBeat.o(290127);
      return;
      label119:
      paramString = paramString.Tpx;
      if (paramString == null)
      {
        paramInt1 = -1;
        break;
      }
      paramString = paramString.Tpq;
      if (paramString == null)
      {
        paramInt1 = -1;
        break;
      }
      paramInt1 = paramString.size();
      break;
      label155:
      paramString = paramString.Tpx;
      if (paramString == null)
      {
        paramString = null;
      }
      else
      {
        paramString = paramString.Tpq;
        if (paramString != null) {
          break label183;
        }
        paramString = null;
      }
    }
    label183:
    paramp = paramString.iterator();
    while (paramp.hasNext())
    {
      paramString = (com.tencent.mm.plugin.textstatus.proto.s)paramp.next();
      switch (paramString.wuj)
      {
      default: 
        break;
      case 1: 
        Log.i("MicroMsg.TextStatus.GetBrandTask", kotlin.g.b.s.X("GetBrandInfo templates url:", paramString.url));
        paramp = new Intent();
        paramp.putExtra("rawUrl", paramString.url);
        paramString = (Activity)this.contextRef.get();
        if (paramString != null) {
          com.tencent.mm.br.c.b((Context)paramString, "webview", ".ui.tools.WebViewUI", paramp);
        }
        paramString = this.TuH;
        if (paramString != null) {
          paramString.run();
        }
        break;
      }
    }
    for (;;)
    {
      paramString = ah.aiuX;
      break;
      paramp = new TextStatusExtInfo();
      paramp.parseFrom(Base64.decode(paramString.ext_info, 0));
      Log.i("MicroMsg.TextStatus.GetBrandTask", kotlin.g.b.s.X("GetBrandInfo templates extInfo:", com.tencent.mm.plugin.textstatus.util.d.e(paramp)));
      paramString = (b)new b(this);
      a.Tuv.a(paramp, (b)new c.c(paramString));
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "extInfoOut", "Lcom/tencent/mm/plugin/textstatus/proto/TextStatusExtInfo;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class b
    extends u
    implements b<TextStatusExtInfo, ah>
  {
    b(c paramc)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.textstatus.third.c
 * JD-Core Version:    0.7.0.1
 */