package com.tencent.mm.pluginsdk.ui.applet;

import android.content.Context;
import android.content.res.Resources;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.pluginsdk.j;
import com.tencent.mm.storage.bd;
import com.tencent.mm.storage.emotion.f;
import com.tencent.mm.ui.s;
import com.tencent.mm.ui.widget.a.d;
import com.tencent.mm.ui.widget.a.d.a;

public final class p
  implements j
{
  public final com.tencent.mm.ui.base.o a(s params, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, y.a parama)
  {
    AppMethodBeat.i(31416);
    params = o.a(params, paramString1, paramString2, paramString3, paramString4, paramString5, parama);
    AppMethodBeat.o(31416);
    return params;
  }
  
  public final d a(Context paramContext, String paramString1, View paramView, String paramString2, y.a parama)
  {
    AppMethodBeat.i(31419);
    paramContext = new o.a(paramContext).dP(paramString1).fT(paramView).l(Boolean.TRUE).fcC();
    paramContext.EVV = paramString2;
    paramContext = paramContext.a(parama).jcs;
    AppMethodBeat.o(31419);
    return paramContext;
  }
  
  public final void a(Context paramContext, String paramString1, String paramString2, String paramString3, y.a parama)
  {
    AppMethodBeat.i(31421);
    paramContext = new o.a(paramContext);
    paramContext.dP(paramString1);
    paramContext.aMU(paramString2);
    paramContext.l(Boolean.TRUE);
    paramContext.EVV = paramString3;
    paramContext.a(parama).jcs.show();
    AppMethodBeat.o(31421);
  }
  
  public final void a(Context paramContext, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, y.a parama)
  {
    AppMethodBeat.i(31420);
    paramContext = new o.a(paramContext);
    paramContext.dP(paramString1).aMS(paramString2).EVV = paramString3;
    paramContext.aMT(paramString5).fcB();
    paramContext.EVU.aXK(paramString4);
    paramContext.a(parama).jcs.show();
    AppMethodBeat.o(31420);
  }
  
  public final void a(s params, String paramString1, String paramString2, String paramString3, y.a parama)
  {
    AppMethodBeat.i(31417);
    o.a(params, paramString1, paramString2, paramString3, parama);
    AppMethodBeat.o(31417);
  }
  
  public final d b(s params, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, y.a parama)
  {
    AppMethodBeat.i(31418);
    params = o.b(params, paramString1, paramString2, paramString3, paramString4, paramString5, parama);
    AppMethodBeat.o(31418);
    return params;
  }
  
  public final void b(Context paramContext, String paramString1, String paramString2, String paramString3, y.a parama)
  {
    AppMethodBeat.i(31422);
    paramString2 = bd.frc().ILn.aUK(paramString2);
    o.a locala = new o.a(paramContext);
    paramString1 = locala.dP(paramString1);
    o.a(paramString1.mContext, paramString1.EVU, paramString2, paramString3);
    paramString1.EVU.yP(false);
    paramString1.l(Boolean.FALSE).YR(2131755884);
    locala.aMR(paramContext.getResources().getString(2131762564));
    locala.a(parama).jcs.show();
    AppMethodBeat.o(31422);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.applet.p
 * JD-Core Version:    0.7.0.1
 */