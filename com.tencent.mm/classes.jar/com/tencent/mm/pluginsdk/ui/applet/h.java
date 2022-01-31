package com.tencent.mm.pluginsdk.ui.applet;

import android.content.Context;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.pluginsdk.i;
import com.tencent.mm.ui.base.o;
import com.tencent.mm.ui.q;
import com.tencent.mm.ui.widget.b.c;
import com.tencent.mm.ui.widget.b.c.a;

public final class h
  implements i
{
  public final o a(q paramq, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, q.a parama)
  {
    AppMethodBeat.i(27711);
    paramq = g.a(paramq, paramString1, paramString2, paramString3, paramString4, paramString5, parama);
    AppMethodBeat.o(27711);
    return paramq;
  }
  
  public final c a(Context paramContext, String paramString1, View paramView, String paramString2, q.a parama)
  {
    AppMethodBeat.i(27714);
    paramContext = new g.a(paramContext).cq(paramString1).eC(paramView).i(Boolean.TRUE).dnA();
    paramContext.vTu = paramString2;
    paramContext = paramContext.a(parama).gwf;
    AppMethodBeat.o(27714);
    return paramContext;
  }
  
  public final void a(Context paramContext, String paramString1, String paramString2, String paramString3, q.a parama)
  {
    AppMethodBeat.i(27716);
    paramContext = new g.a(paramContext);
    paramContext.cq(paramString1);
    paramContext.amo(paramString2);
    paramContext.i(Boolean.TRUE);
    paramContext.vTu = paramString3;
    paramContext.a(parama).gwf.show();
    AppMethodBeat.o(27716);
  }
  
  public final void a(Context paramContext, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, q.a parama)
  {
    AppMethodBeat.i(27715);
    paramContext = new g.a(paramContext);
    paramContext.cq(paramString1).amm(paramString2).vTu = paramString3;
    paramContext.amn(paramString5).dnz();
    paramContext.vTt.avq(paramString4);
    paramContext.a(parama).gwf.show();
    AppMethodBeat.o(27715);
  }
  
  public final void a(q paramq, String paramString1, String paramString2, String paramString3, q.a parama)
  {
    AppMethodBeat.i(27712);
    g.a(paramq, paramString1, paramString2, paramString3, parama);
    AppMethodBeat.o(27712);
  }
  
  public final c b(q paramq, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, q.a parama)
  {
    AppMethodBeat.i(27713);
    paramq = g.b(paramq, paramString1, paramString2, paramString3, paramString4, paramString5, parama);
    AppMethodBeat.o(27713);
    return paramq;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.applet.h
 * JD-Core Version:    0.7.0.1
 */