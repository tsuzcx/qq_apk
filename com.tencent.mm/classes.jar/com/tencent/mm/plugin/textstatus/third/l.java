package com.tencent.mm.plugin.textstatus.third;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.ResultReceiver;
import android.util.Base64;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.p;
import com.tencent.mm.br.c;
import com.tencent.mm.plugin.textstatus.a.h;
import com.tencent.mm.plugin.textstatus.a.w;
import com.tencent.mm.plugin.textstatus.a.w.a;
import com.tencent.mm.plugin.textstatus.a.y;
import com.tencent.mm.plugin.textstatus.a.z;
import com.tencent.mm.plugin.textstatus.f.g;
import com.tencent.mm.plugin.textstatus.proto.TextStatusExtInfo;
import com.tencent.mm.plugin.textstatus.proto.ab;
import com.tencent.mm.plugin.textstatus.proto.bl;
import com.tencent.mm.plugin.textstatus.proto.r;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.base.k;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.LinkedList;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.a.b;
import kotlin.g.b.u;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/textstatus/third/TextStatusActionTask;", "Lcom/tencent/mm/plugin/textstatus/api/ITextStatusActionTask;", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "context", "Landroid/content/Context;", "param", "Lcom/tencent/mm/plugin/textstatus/api/TextStatusActionParam;", "callback", "Lcom/tencent/mm/plugin/textstatus/api/TextStatusActionCallback;", "(Landroid/content/Context;Lcom/tencent/mm/plugin/textstatus/api/TextStatusActionParam;Lcom/tencent/mm/plugin/textstatus/api/TextStatusActionCallback;)V", "getCallback", "()Lcom/tencent/mm/plugin/textstatus/api/TextStatusActionCallback;", "contextRef", "Ljava/lang/ref/WeakReference;", "kotlin.jvm.PlatformType", "getContextRef", "()Ljava/lang/ref/WeakReference;", "isCancel", "", "()Z", "setCancel", "(Z)V", "mTipDialog", "Landroid/app/ProgressDialog;", "netSceneRef", "Lcom/tencent/mm/modelbase/NetSceneBase;", "getNetSceneRef", "setNetSceneRef", "(Ljava/lang/ref/WeakReference;)V", "onSceneEndRef", "Lcom/tencent/mm/plugin/textstatus/logic/WeakOnSceneEnd;", "getOnSceneEndRef", "()Lcom/tencent/mm/plugin/textstatus/logic/WeakOnSceneEnd;", "setOnSceneEndRef", "(Lcom/tencent/mm/plugin/textstatus/logic/WeakOnSceneEnd;)V", "getParam", "()Lcom/tencent/mm/plugin/textstatus/api/TextStatusActionParam;", "cancel", "", "dismissDialog", "doTask", "getTextStatusSignatureExtInfo", "Lcom/tencent/mm/plugin/textstatus/proto/TextStatusSignatureExtInfo;", "jumpSetStatus", "extInfoOut", "Lcom/tencent/mm/plugin/textstatus/proto/TextStatusExtInfo;", "onSceneEnd", "errType", "", "errCode", "errMsg", "", "scene", "preprocessExtInfo", "extInfoIn", "Lkotlin/Function1;", "Companion", "plugin-textstatus_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class l
  implements com.tencent.mm.am.h, com.tencent.mm.plugin.textstatus.a.q
{
  public static final l.a Tvb;
  private final z ThX;
  private WeakReference<p> TuI;
  private g TuJ;
  final y Tvc;
  private final WeakReference<Context> contextRef;
  boolean nzW;
  private ProgressDialog vEG;
  
  static
  {
    AppMethodBeat.i(290185);
    Tvb = new l.a((byte)0);
    AppMethodBeat.o(290185);
  }
  
  public l(Context paramContext, z paramz, y paramy)
  {
    AppMethodBeat.i(290137);
    this.ThX = paramz;
    this.Tvc = paramy;
    this.contextRef = new WeakReference(paramContext);
    AppMethodBeat.o(290137);
  }
  
  private static final void a(l paraml, DialogInterface paramDialogInterface)
  {
    AppMethodBeat.i(290176);
    kotlin.g.b.s.u(paraml, "this$0");
    paraml.vEG = null;
    paraml.cancel();
    AppMethodBeat.o(290176);
  }
  
  private void aDM()
  {
    AppMethodBeat.i(290151);
    ProgressDialog localProgressDialog = this.vEG;
    if (localProgressDialog != null) {
      localProgressDialog.dismiss();
    }
    this.vEG = null;
    AppMethodBeat.o(290151);
  }
  
  private final void d(TextStatusExtInfo paramTextStatusExtInfo)
  {
    AppMethodBeat.i(290163);
    w localw = new w.a().ThS;
    if (paramTextStatusExtInfo != null) {
      localw.Tog = paramTextStatusExtInfo;
    }
    localw.Toi = this.ThX.Toz;
    localw.Tos = this.ThX.ToA;
    localw.Tou = this.ThX.Tou;
    paramTextStatusExtInfo = new TextStatusActionTask.jumpSetStatus.setStatusCallback.1(this);
    Context localContext = (Context)this.contextRef.get();
    if ((localContext != null) && ((!(localContext instanceof Activity)) || (!((Activity)localContext).isFinishing()))) {
      ((com.tencent.mm.plugin.textstatus.a.n)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.textstatus.a.n.class)).a(localContext, localw, (ResultReceiver)paramTextStatusExtInfo);
    }
    aDM();
    AppMethodBeat.o(290163);
  }
  
  private final bl hId()
  {
    AppMethodBeat.i(290145);
    Object localObject = (CharSequence)this.ThX.Tox;
    if ((localObject == null) || (kotlin.n.n.bp((CharSequence)localObject))) {}
    for (int i = 1; i == 0; i = 0)
    {
      AppMethodBeat.o(290145);
      return null;
    }
    localObject = new bl();
    CharSequence localCharSequence = (CharSequence)this.ThX.Tov;
    if ((localCharSequence == null) || (kotlin.n.n.bp(localCharSequence)))
    {
      i = 1;
      if (i == 0) {
        ((bl)localObject).Tow = this.ThX.Tow;
      }
      localCharSequence = (CharSequence)this.ThX.ToB;
      if ((localCharSequence != null) && (!kotlin.n.n.bp(localCharSequence))) {
        break label182;
      }
      i = 1;
      label116:
      if (i == 0) {
        ((bl)localObject).ToB = this.ThX.ToB;
      }
      localCharSequence = (CharSequence)this.ThX.ToC;
      if ((localCharSequence != null) && (!kotlin.n.n.bp(localCharSequence))) {
        break label187;
      }
    }
    label182:
    label187:
    for (i = 1;; i = 0)
    {
      if (i == 0) {
        ((bl)localObject).ToC = this.ThX.ToC;
      }
      AppMethodBeat.o(290145);
      return localObject;
      i = 0;
      break;
      i = 0;
      break label116;
    }
  }
  
  public final void cancel()
  {
    AppMethodBeat.i(290206);
    this.nzW = true;
    Object localObject = this.TuI;
    if (localObject != null)
    {
      localObject = (p)((WeakReference)localObject).get();
      if (localObject != null) {
        com.tencent.mm.kernel.h.aZW().a((p)localObject);
      }
    }
    localObject = this.vEG;
    if (localObject != null) {
      ((ProgressDialog)localObject).dismiss();
    }
    AppMethodBeat.o(290206);
  }
  
  public final void hIe()
  {
    AppMethodBeat.i(290201);
    Object localObject = new com.tencent.mm.plugin.textstatus.h.d(this.ThX.Tox, this.ThX.Tov, hId());
    g localg = new g((com.tencent.mm.am.h)this);
    com.tencent.mm.kernel.h.aZW().a(((com.tencent.mm.plugin.textstatus.h.d)localObject).getType(), (com.tencent.mm.am.h)localg);
    this.TuJ = localg;
    com.tencent.mm.kernel.h.aZW().a((p)localObject, 0);
    this.TuI = new WeakReference(localObject);
    if (this.ThX.Toy != true)
    {
      localObject = (Context)this.contextRef.get();
      if ((localObject != null) && ((localObject instanceof Activity)))
      {
        ((Context)localObject).getString(a.h.app_tip);
        this.vEG = ((ProgressDialog)k.b((Context)localObject, ((Context)localObject).getString(a.h.loading_tips), true, new l..ExternalSyntheticLambda0(this)));
      }
    }
    AppMethodBeat.o(290201);
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, p paramp)
  {
    AppMethodBeat.i(290220);
    if ((paramp instanceof com.tencent.mm.plugin.textstatus.h.d))
    {
      com.tencent.mm.kernel.h.aZW().b(((com.tencent.mm.plugin.textstatus.h.d)paramp).getType(), (com.tencent.mm.am.h)this.TuJ);
      if (this.nzW)
      {
        AppMethodBeat.o(290220);
        return;
      }
      if ((paramInt1 != 0) || (paramInt2 != 0))
      {
        aDM();
        paramString = this.Tvc;
        if (paramString != null) {
          paramString.onFinishAction(1, "err rsp", new com.tencent.mm.plugin.textstatus.proto.q());
        }
        AppMethodBeat.o(290220);
        return;
      }
      paramString = ((com.tencent.mm.plugin.textstatus.h.d)paramp).TmI;
      if (paramString == null)
      {
        paramInt1 = -1;
        label109:
        Log.i("MicroMsg.TextStatus.TextStatusActionTask", kotlin.g.b.s.X("GetBrandInfo templates:", Integer.valueOf(paramInt1)));
        paramString = ((com.tencent.mm.plugin.textstatus.h.d)paramp).TmI;
        if (paramString != null) {
          break label313;
        }
        paramString = null;
        label140:
        if (paramString != null) {
          break label321;
        }
      }
      label313:
      label321:
      for (Object localObject = null;; localObject = paramString.Tpq)
      {
        if ((localObject == null) || (paramString.Tpq.size() == 0))
        {
          Log.i("MicroMsg.TextStatus.TextStatusActionTask", "templates is null");
          d(null);
        }
        paramString = ((com.tencent.mm.plugin.textstatus.h.d)paramp).TmI;
        if (paramString == null) {
          break label553;
        }
        paramString = paramString.Tpx;
        if (paramString == null) {
          break label553;
        }
        paramString = paramString.Tpq;
        if (paramString == null) {
          break label553;
        }
        paramString = paramString.iterator();
        if (!paramString.hasNext()) {
          break label523;
        }
        paramString = (com.tencent.mm.plugin.textstatus.proto.s)paramString.next();
        switch (paramString.wuj)
        {
        default: 
          Log.i("MicroMsg.TextStatus.TextStatusActionTask", "action is weird error");
          d(null);
          AppMethodBeat.o(290220);
          return;
          paramString = paramString.Tpx;
          if (paramString == null)
          {
            paramInt1 = -1;
            break label109;
          }
          paramString = paramString.Tpq;
          if (paramString == null)
          {
            paramInt1 = -1;
            break label109;
          }
          paramInt1 = paramString.size();
          break label109;
          paramString = paramString.Tpx;
          break label140;
        }
      }
      Log.i("MicroMsg.TextStatus.TextStatusActionTask", kotlin.g.b.s.X("GetBrandInfo templates url:", paramString.url));
      paramp = new Intent();
      paramp.putExtra("rawUrl", paramString.url);
      paramString = (Context)this.contextRef.get();
      if (paramString != null) {
        c.b(paramString, "webview", ".ui.tools.WebViewUI", paramp);
      }
      aDM();
      paramString = this.Tvc;
      if (paramString != null)
      {
        paramp = new com.tencent.mm.plugin.textstatus.proto.q();
        paramp.action = 1;
        localObject = ah.aiuX;
        paramString.onFinishAction(0, null, paramp);
      }
      AppMethodBeat.o(290220);
      return;
      paramp = new TextStatusExtInfo();
      paramp.parseFrom(Base64.decode(paramString.ext_info, 0));
      Log.i("MicroMsg.TextStatus.TextStatusActionTask", kotlin.g.b.s.X("GetBrandInfo templates extInfo:", com.tencent.mm.plugin.textstatus.util.d.e(paramp)));
      paramString = (b)new b(this);
      a.Tuv.a(paramp, (b)new l.c(paramString));
      AppMethodBeat.o(290220);
      return;
      label523:
      paramString = this.Tvc;
      if (paramString != null) {
        paramString.onFinishAction(1, "not valid templates found", new com.tencent.mm.plugin.textstatus.proto.q());
      }
      aDM();
    }
    label553:
    AppMethodBeat.o(290220);
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "extInfoOut", "Lcom/tencent/mm/plugin/textstatus/proto/TextStatusExtInfo;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class b
    extends u
    implements b<TextStatusExtInfo, ah>
  {
    b(l paraml)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.textstatus.third.l
 * JD-Core Version:    0.7.0.1
 */