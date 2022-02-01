package com.tencent.mm.pluginsdk.ui.applet;

import android.content.Context;
import android.content.res.Resources;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.pluginsdk.i;
import com.tencent.mm.storage.aw;
import com.tencent.mm.storage.emotion.f;
import com.tencent.mm.ui.r;
import com.tencent.mm.ui.widget.a.d;
import com.tencent.mm.ui.widget.a.d.a;

public final class p
  implements i
{
  public final com.tencent.mm.ui.base.o a(r paramr, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, y.a parama)
  {
    AppMethodBeat.i(31416);
    paramr = o.a(paramr, paramString1, paramString2, paramString3, paramString4, paramString5, parama);
    AppMethodBeat.o(31416);
    return paramr;
  }
  
  public final d a(Context paramContext, String paramString1, View paramView, String paramString2, y.a parama)
  {
    AppMethodBeat.i(31419);
    paramContext = new o.a(paramContext).dL(paramString1).fr(paramView).i(Boolean.TRUE).eyj();
    paramContext.BYB = paramString2;
    paramContext = paramContext.a(parama).ijc;
    AppMethodBeat.o(31419);
    return paramContext;
  }
  
  public final void a(Context paramContext, String paramString1, String paramString2, String paramString3, y.a parama)
  {
    AppMethodBeat.i(31421);
    paramContext = new o.a(paramContext);
    paramContext.dL(paramString1);
    paramContext.aBZ(paramString2);
    paramContext.i(Boolean.TRUE);
    paramContext.BYB = paramString3;
    paramContext.a(parama).ijc.show();
    AppMethodBeat.o(31421);
  }
  
  public final void a(Context paramContext, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, y.a parama)
  {
    AppMethodBeat.i(31420);
    paramContext = new o.a(paramContext);
    paramContext.dL(paramString1).aBX(paramString2).BYB = paramString3;
    paramContext.aBY(paramString5).eyi();
    paramContext.BYA.aMk(paramString4);
    paramContext.a(parama).ijc.show();
    AppMethodBeat.o(31420);
  }
  
  public final void a(r paramr, String paramString1, String paramString2, String paramString3, y.a parama)
  {
    AppMethodBeat.i(31417);
    o.a(paramr, paramString1, paramString2, paramString3, parama);
    AppMethodBeat.o(31417);
  }
  
  public final d b(r paramr, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, y.a parama)
  {
    AppMethodBeat.i(31418);
    paramr = o.b(paramr, paramString1, paramString2, paramString3, paramString4, paramString5, parama);
    AppMethodBeat.o(31418);
    return paramr;
  }
  
  public final void b(Context paramContext, String paramString1, String paramString2, String paramString3, y.a parama)
  {
    AppMethodBeat.i(31422);
    paramString2 = aw.eLx().FyY.aJx(paramString2);
    o.a locala = new o.a(paramContext);
    paramString1 = locala.dL(paramString1);
    o.a(paramString1.mContext, paramString1.BYA, paramString2, paramString3);
    paramString1.BYA.wV(false);
    paramString1.i(Boolean.FALSE).UL(2131755884);
    locala.aBW(paramContext.getResources().getString(2131762564));
    locala.a(parama).ijc.show();
    AppMethodBeat.o(31422);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.applet.p
 * JD-Core Version:    0.7.0.1
 */