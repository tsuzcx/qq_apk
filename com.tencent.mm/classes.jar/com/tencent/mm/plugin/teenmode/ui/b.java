package com.tencent.mm.plugin.teenmode.ui;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.view.View;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.h;
import com.tencent.mm.message.k.b;
import com.tencent.mm.message.m;
import com.tencent.mm.modelimage.j;
import com.tencent.mm.modelimage.loader.a.c.a;
import com.tencent.mm.modelimage.r;
import com.tencent.mm.plugin.teenmode.a.f;
import com.tencent.mm.plugin.teenmode.a.g;
import com.tencent.mm.plugin.teenmode.a.a.a;
import com.tencent.mm.plugin.teenmode.a.a.b;
import com.tencent.mm.pluginsdk.model.y;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.XmlParser;
import java.util.Map;
import kotlin.Metadata;
import kotlin.g.b.s;
import kotlin.n.n;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/teenmode/ui/BizAuthorizationFiller;", "Lcom/tencent/mm/plugin/teenmode/api/AuthorizationFiller;", "()V", "fillByStateGuardian", "", "context", "Landroid/content/Context;", "state", "Lcom/tencent/mm/plugin/teenmode/api/AuthorizationFiller$State;", "holder", "Lcom/tencent/mm/plugin/teenmode/api/AuthorizationFiller$Holder;", "isMpArticle", "", "fillByStateWard", "getBizTypeDesc", "", "initMsgItem", "initState", "onFill", "plugin-teenmode_release"}, k=1, mv={1, 5, 1}, xi=48)
public class b
  extends com.tencent.mm.plugin.teenmode.a.a
{
  public static void a(Context paramContext, a.b paramb, a.a parama, boolean paramBoolean)
  {
    AppMethodBeat.i(279007);
    s.u(paramContext, "context");
    s.u(paramb, "state");
    if (parama == null)
    {
      AppMethodBeat.o(279007);
      return;
    }
    if (parama == null) {
      localObject1 = null;
    }
    while (localObject1 == null)
    {
      AppMethodBeat.o(279007);
      return;
      localObject1 = parama.SYk;
      if (localObject1 == null) {
        localObject1 = null;
      } else {
        localObject1 = (com.tencent.mm.message.a.c)((k.b)localObject1).aK(com.tencent.mm.message.a.c.class);
      }
    }
    Object localObject1 = XmlParser.parseXml(((com.tencent.mm.message.a.c)localObject1).nVJ, "content", null);
    if (localObject1 == null)
    {
      AppMethodBeat.o(279007);
      return;
    }
    localObject1 = (String)((Map)localObject1).get(".content");
    if (localObject1 == null)
    {
      AppMethodBeat.o(279007);
      return;
    }
    Object localObject2 = k.b.Hf((String)localObject1);
    if (localObject2 == null)
    {
      AppMethodBeat.o(279007);
      return;
    }
    localObject1 = ((k.b)localObject2).title;
    Object localObject3 = parama.SYs;
    Object localObject4 = (CharSequence)localObject1;
    if ((localObject4 == null) || (n.bp((CharSequence)localObject4)))
    {
      i = 1;
      if (i == 0) {
        break label461;
      }
      if (!paramBoolean) {
        break label449;
      }
      localObject1 = paramContext.getString(a.g.app_url_mp);
      label198:
      localObject1 = (CharSequence)localObject1;
      label205:
      ((TextView)localObject3).setText((CharSequence)localObject1);
      localObject3 = ((k.b)localObject2).thumburl;
      localObject1 = ((k.b)localObject2).url;
      parama.SYq.setImageResource(a.f.app_attach_file_icon_webpage);
      parama.SYq.setScaleType(ImageView.ScaleType.CENTER_CROP);
      localObject2 = (CharSequence)localObject3;
      if ((localObject2 != null) && (!n.bp((CharSequence)localObject2))) {
        break label471;
      }
      i = 1;
      label269:
      if (i != 0) {
        break label477;
      }
      localObject2 = r.bKe();
      localObject4 = parama.SYq;
      c.a locala = new c.a();
      locala.oKB = a.f.app_attach_file_icon_webpage;
      locala.oKJ = true;
      locala.oKp = true;
      locala.fullPath = y.bpF((String)localObject3);
      ((com.tencent.mm.modelimage.loader.a)localObject2).a((String)localObject3, (ImageView)localObject4, locala.eG(132, 132).bKx());
      label347:
      float f = com.tencent.mm.cd.a.fromDPToPix(paramContext, 4);
      localObject2 = com.tencent.mm.plugin.bizui.a.a.vtB;
      com.tencent.mm.plugin.bizui.a.a.v((View)parama.SYq, f);
      if ((!parama.hEo()) && (paramb != a.b.SYw)) {
        break label516;
      }
    }
    label516:
    for (int i = 1;; i = 0)
    {
      if (i == 0) {
        break label522;
      }
      if (paramBoolean) {
        ((com.tencent.mm.plugin.brandservice.api.c)h.ax(com.tencent.mm.plugin.brandservice.api.c.class)).a((String)localObject1, -1, 3, new Object[0]);
      }
      parama.SYp.setOnClickListener(new b..ExternalSyntheticLambda0(paramBoolean, (String)localObject1, paramContext));
      AppMethodBeat.o(279007);
      return;
      i = 0;
      break;
      label449:
      localObject1 = paramContext.getString(a.g.app_url);
      break label198;
      label461:
      localObject1 = (CharSequence)localObject1;
      break label205;
      label471:
      i = 0;
      break label269;
      label477:
      if (Util.isNullOrNil(parama.SYl)) {
        break label347;
      }
      localObject2 = r.bKa().a(parama.SYl, com.tencent.mm.cd.a.getDensity(paramContext), false);
      parama.SYq.setImageBitmap((Bitmap)localObject2);
      break label347;
    }
    label522:
    parama.SYp.setOnClickListener(null);
    AppMethodBeat.o(279007);
  }
  
  private static final void a(boolean paramBoolean, String paramString, Context paramContext, View paramView)
  {
    AppMethodBeat.i(279045);
    Object localObject = new Object();
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.fv(paramBoolean);
    localb.cH(paramString);
    localb.cH(paramContext);
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/teenmode/ui/BizAuthorizationFiller", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    s.u(paramContext, "$context");
    int i;
    if (paramBoolean)
    {
      paramView = new Intent();
      paramString = m.e(paramString, 3, 10000, (int)(System.currentTimeMillis() / 1000L));
      if ((((com.tencent.mm.plugin.brandservice.api.c)h.ax(com.tencent.mm.plugin.brandservice.api.c.class)).GV(3)) && (((com.tencent.mm.plugin.brandservice.api.c)h.ax(com.tencent.mm.plugin.brandservice.api.c.class)).a(paramContext, paramString, -1, 3, 10000, paramView)))
      {
        i = 1;
        if (i == 0)
        {
          paramView.putExtra("rawUrl", paramString);
          com.tencent.mm.br.c.b(paramContext, "webview", ".ui.tools.WebViewUI", paramView);
        }
      }
    }
    for (;;)
    {
      com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/teenmode/ui/BizAuthorizationFiller", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(279045);
      return;
      i = 0;
      break;
      paramView = new Intent();
      paramView.putExtra("rawUrl", paramString);
      paramView.putExtra("key_enable_teen_mode_check", true);
      com.tencent.mm.br.c.b(paramContext, "webview", ".ui.tools.WebViewUI", paramView);
    }
  }
  
  public static void b(Context paramContext, a.b paramb, a.a parama)
  {
    AppMethodBeat.i(279014);
    s.u(paramContext, "context");
    s.u(paramb, "state");
    if (parama == null)
    {
      AppMethodBeat.o(279014);
      return;
    }
    if (parama.hEo())
    {
      c(paramContext, paramb, parama);
      AppMethodBeat.o(279014);
      return;
    }
    d(paramContext, paramb, parama);
    AppMethodBeat.o(279014);
  }
  
  private static void c(Context paramContext, a.b paramb, a.a parama)
  {
    AppMethodBeat.i(279023);
    switch (b.a.$EnumSwitchMapping$0[paramb.ordinal()])
    {
    }
    for (;;)
    {
      AppMethodBeat.o(279023);
      return;
      parama.pmf.setText((CharSequence)paramContext.getString(a.g.SWV));
      AppMethodBeat.o(279023);
      return;
      parama.pmf.setText((CharSequence)paramContext.getString(a.g.SWU));
      AppMethodBeat.o(279023);
      return;
      parama.pmf.setText((CharSequence)paramContext.getString(a.g.SWT));
      AppMethodBeat.o(279023);
      return;
      parama.pmf.setText((CharSequence)paramContext.getString(a.g.SWW));
    }
  }
  
  private static void d(Context paramContext, a.b paramb, a.a parama)
  {
    AppMethodBeat.i(279031);
    switch (b.a.$EnumSwitchMapping$0[paramb.ordinal()])
    {
    }
    for (;;)
    {
      AppMethodBeat.o(279031);
      return;
      parama.pmf.setText((CharSequence)paramContext.getString(a.g.SWZ));
      AppMethodBeat.o(279031);
      return;
      parama.pmf.setText((CharSequence)paramContext.getString(a.g.SWY));
      AppMethodBeat.o(279031);
      return;
      parama.pmf.setText((CharSequence)paramContext.getString(a.g.SWX));
      AppMethodBeat.o(279031);
      return;
      parama.pmf.setText((CharSequence)paramContext.getString(a.g.SXa));
    }
  }
  
  public void a(Context paramContext, a.b paramb, a.a parama)
  {
    AppMethodBeat.i(279065);
    s.u(paramContext, "context");
    s.u(paramb, "state");
    if (parama == null)
    {
      AppMethodBeat.o(279065);
      return;
    }
    paramContext = parama.SYp;
    if (paramContext == null) {}
    for (paramContext = null;; paramContext = paramContext.getContext())
    {
      Context localContext = paramContext;
      if (paramContext == null) {
        localContext = MMApplicationContext.getContext();
      }
      s.s(localContext, "context");
      b(localContext, paramb, parama);
      a(localContext, paramb, parama, true);
      AppMethodBeat.o(279065);
      return;
    }
  }
  
  public String gV(Context paramContext)
  {
    AppMethodBeat.i(279057);
    s.u(paramContext, "context");
    paramContext = paramContext.getString(a.g.webview_teen_mode_mp_biz_desc);
    s.s(paramContext, "context.getString(R.stri…ew_teen_mode_mp_biz_desc)");
    AppMethodBeat.o(279057);
    return paramContext;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.teenmode.ui.b
 * JD-Core Version:    0.7.0.1
 */