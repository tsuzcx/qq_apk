package com.tencent.mm.plugin.teenmode.ui;

import android.content.Context;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.message.a.c;
import com.tencent.mm.message.k.b;
import com.tencent.mm.plugin.teenmode.a.a;
import com.tencent.mm.plugin.teenmode.a.a.a;
import com.tencent.mm.plugin.teenmode.a.a.b;
import com.tencent.mm.sdk.platformtools.XmlParser;
import java.util.Map;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/teenmode/ui/DefaultAuthorizationFiller;", "Lcom/tencent/mm/plugin/teenmode/api/AuthorizationFiller;", "()V", "getBizTypeDesc", "", "context", "Landroid/content/Context;", "onFill", "", "state", "Lcom/tencent/mm/plugin/teenmode/api/AuthorizationFiller$State;", "holder", "Lcom/tencent/mm/plugin/teenmode/api/AuthorizationFiller$Holder;", "plugin-teenmode_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class d
  extends a
{
  public final void a(Context paramContext, a.b paramb, a.a parama)
  {
    AppMethodBeat.i(279013);
    s.u(paramContext, "context");
    s.u(paramb, "state");
    if (parama == null) {
      paramContext = null;
    }
    for (;;)
    {
      if (paramContext != null)
      {
        paramContext = XmlParser.parseXml(paramContext.nVJ, "msg", null);
        parama.SYs.setText((CharSequence)paramContext.get(".msg.appmsg.title"));
      }
      AppMethodBeat.o(279013);
      return;
      paramContext = parama.SYk;
      if (paramContext == null) {
        paramContext = null;
      } else {
        paramContext = (c)paramContext.aK(c.class);
      }
    }
  }
  
  public final String gV(Context paramContext)
  {
    AppMethodBeat.i(279003);
    s.u(paramContext, "context");
    AppMethodBeat.o(279003);
    return "未知类型";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.teenmode.ui.d
 * JD-Core Version:    0.7.0.1
 */