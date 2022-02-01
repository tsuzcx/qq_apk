package com.tencent.mm.plugin.teenmode.ui;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.kernel.h;
import com.tencent.mm.message.a.c;
import com.tencent.mm.message.k.b;
import com.tencent.mm.modelimage.loader.a.c.a;
import com.tencent.mm.modelimage.r;
import com.tencent.mm.plugin.appbrand.api.g;
import com.tencent.mm.plugin.appbrand.service.t;
import com.tencent.mm.plugin.teenmode.a.c;
import com.tencent.mm.plugin.teenmode.a.g;
import com.tencent.mm.plugin.teenmode.a.a.a;
import com.tencent.mm.plugin.teenmode.a.a.b;
import com.tencent.mm.sdk.platformtools.XmlParser;
import com.tencent.mm.ui.widget.imageview.WeImageView;
import java.util.Map;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/teenmode/ui/AppBrandAuthorizationFiller;", "Lcom/tencent/mm/plugin/teenmode/api/AuthorizationFiller;", "()V", "fillByState", "", "context", "Landroid/content/Context;", "state", "Lcom/tencent/mm/plugin/teenmode/api/AuthorizationFiller$State;", "holder", "Lcom/tencent/mm/plugin/teenmode/api/AuthorizationFiller$Holder;", "isGuardian", "", "fillByStateGuardian", "fillByStateWard", "getBizTypeDesc", "", "onFill", "plugin-teenmode_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class a
  extends com.tencent.mm.plugin.teenmode.a.a
{
  private static final void a(k.b paramb, Context paramContext, View paramView)
  {
    AppMethodBeat.i(278992);
    Object localObject = new Object();
    b localb = new b();
    localb.cH(paramb);
    localb.cH(paramContext);
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/teenmode/ui/AppBrandAuthorizationFiller", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    s.u(paramContext, "$context");
    if (paramb == null)
    {
      com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/teenmode/ui/AppBrandAuthorizationFiller", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(278992);
      return;
    }
    paramView = (t)h.ax(t.class);
    localObject = new g();
    ((g)localObject).username = paramb.nTD;
    ((g)localObject).scene = 1212;
    ((g)localObject).version = paramb.nTX;
    paramb = ah.aiuX;
    paramView.a(paramContext, (g)localObject);
    com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/teenmode/ui/AppBrandAuthorizationFiller", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(278992);
  }
  
  public final void a(Context paramContext, a.b paramb, a.a parama)
  {
    AppMethodBeat.i(279025);
    s.u(paramContext, "context");
    s.u(paramb, "state");
    if (parama == null)
    {
      AppMethodBeat.o(279025);
      return;
    }
    Object localObject = XmlParser.parseXml(((c)parama.SYk.aK(c.class)).nVJ, "content", null);
    if (localObject == null)
    {
      AppMethodBeat.o(279025);
      return;
    }
    localObject = (String)((Map)localObject).get(".content");
    if (localObject == null)
    {
      AppMethodBeat.o(279025);
      return;
    }
    localObject = k.b.Hf((String)localObject);
    boolean bool = parama.hEo();
    int i;
    if ((bool) || (paramb == a.b.SYw))
    {
      i = 1;
      if (localObject != null)
      {
        parama.SYs.setText((CharSequence)((k.b)localObject).title);
        com.tencent.mm.modelimage.loader.a locala = r.bKe();
        String str = ((k.b)localObject).thumburl;
        ImageView localImageView = parama.SYq;
        c.a locala1 = new c.a();
        locala1.nrc = true;
        locala1.oKE = a.c.we_app_icon;
        ah localah = ah.aiuX;
        locala.a(str, localImageView, locala1.bKx());
      }
      if (!bool) {
        break label358;
      }
      parama.SYt.setVisibility(0);
      switch (a.a.$EnumSwitchMapping$0[paramb.ordinal()])
      {
      }
    }
    for (;;)
    {
      if (i == 0) {
        break label495;
      }
      parama.SYp.setOnClickListener(new a..ExternalSyntheticLambda0((k.b)localObject, paramContext));
      AppMethodBeat.o(279025);
      return;
      i = 0;
      break;
      parama.pmf.setText((CharSequence)paramContext.getString(a.g.SWV));
      continue;
      parama.pmf.setText((CharSequence)paramContext.getString(a.g.SWU));
      continue;
      parama.pmf.setText((CharSequence)paramContext.getString(a.g.SWT));
      continue;
      parama.pmf.setText((CharSequence)paramContext.getString(a.g.SWW));
      continue;
      label358:
      parama.SYt.setVisibility(8);
      switch (a.a.$EnumSwitchMapping$0[paramb.ordinal()])
      {
      default: 
        break;
      case 1: 
        parama.pmf.setText((CharSequence)paramContext.getString(a.g.SWZ));
        break;
      case 2: 
        parama.SYt.setVisibility(0);
        parama.pmf.setText((CharSequence)paramContext.getString(a.g.SWY));
        break;
      case 3: 
        parama.pmf.setText((CharSequence)paramContext.getString(a.g.SWX));
        break;
      case 4: 
        parama.pmf.setText((CharSequence)paramContext.getString(a.g.SXa));
      }
    }
    label495:
    parama.SYp.setOnClickListener(null);
    AppMethodBeat.o(279025);
  }
  
  public final String gV(Context paramContext)
  {
    AppMethodBeat.i(279006);
    s.u(paramContext, "context");
    paramContext = paramContext.getString(a.g.appbrand_app_name);
    s.s(paramContext, "context.getString(R.string.appbrand_app_name)");
    AppMethodBeat.o(279006);
    return paramContext;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.teenmode.ui.a
 * JD-Core Version:    0.7.0.1
 */