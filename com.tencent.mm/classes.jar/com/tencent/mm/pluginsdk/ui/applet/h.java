package com.tencent.mm.pluginsdk.ui.applet;

import android.content.Context;
import com.tencent.mm.ui.base.o;
import com.tencent.mm.ui.s;
import com.tencent.mm.ui.widget.a.c;
import com.tencent.mm.ui.widget.a.c.a;

public final class h
  implements com.tencent.mm.pluginsdk.h
{
  public final o a(s params, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, q.a parama)
  {
    return g.a(params, paramString1, paramString2, paramString3, paramString4, paramString5, parama);
  }
  
  public final void a(Context paramContext, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, q.a parama)
  {
    paramContext = new g.a(paramContext);
    paramContext.bM(paramString1).WF(paramString2).sco = paramString3;
    paramContext.WG(paramString5).cmJ();
    paramContext.scn.aeC(paramString4);
    paramContext.a(parama).few.show();
  }
  
  public final void a(s params, String paramString1, String paramString2, String paramString3, q.a parama)
  {
    g.a(params, paramString1, paramString2, paramString3, parama);
  }
  
  public final c b(s params, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, q.a parama)
  {
    return g.b(params, paramString1, paramString2, paramString3, paramString4, paramString5, parama);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.applet.h
 * JD-Core Version:    0.7.0.1
 */