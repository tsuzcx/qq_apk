package com.tencent.mm.plugin.webview.fts;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public final class h
{
  public final List<Map<Object, b>> PKT;
  private final MMHandler qdR;
  
  public h(MMHandler paramMMHandler)
  {
    AppMethodBeat.i(216116);
    this.PKT = new ArrayList();
    int i = 0;
    while (i < 3)
    {
      this.PKT.add(new HashMap());
      i += 1;
    }
    this.qdR = paramMMHandler;
    AppMethodBeat.o(216116);
  }
  
  public final void a(final int paramInt, final Object paramObject1, final Object paramObject2, final a parama)
  {
    AppMethodBeat.i(216121);
    this.qdR.post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(265033);
        Log.i("MicroMsg.WebSearch.PGetController", "step_cgiEnd type:%s reqTag:%s cgiResult:%s", new Object[] { Integer.valueOf(paramInt), paramObject1, paramObject2 });
        h.b localb = (h.b)((Map)h.this.PKT.get(paramInt)).get(paramObject1);
        if (localb == null)
        {
          Log.e("MicroMsg.WebSearch.PGetController", "step_cgiEnd weird null");
          AppMethodBeat.o(265033);
          return;
        }
        localb.PLe = paramObject2;
        localb.PLc = true;
        if (localb.PLb)
        {
          if (parama != null) {
            parama.a(localb);
          }
          ((Map)h.this.PKT.get(paramInt)).remove(paramObject1);
        }
        AppMethodBeat.o(265033);
      }
    });
    AppMethodBeat.o(216121);
  }
  
  public final void a(final int paramInt, final Object paramObject1, final Object paramObject2, final Runnable paramRunnable, final a parama)
  {
    AppMethodBeat.i(216120);
    if (paramObject1 == null)
    {
      Log.e("MicroMsg.WebSearch.PGetController", "step_getJsApi tag is null");
      AppMethodBeat.o(216120);
      return;
    }
    this.qdR.post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(267541);
        Log.i("MicroMsg.WebSearch.PGetController", "step_getJsApi type:%s, reqTag:%s, jsParams:%s", new Object[] { Integer.valueOf(paramInt), paramObject1, paramObject2 });
        h.b localb2 = (h.b)((Map)h.this.PKT.get(paramInt)).get(paramObject1);
        h.b localb1 = localb2;
        if (localb2 == null)
        {
          localb1 = new h.b();
          ((Map)h.this.PKT.get(paramInt)).put(paramObject1, localb1);
        }
        localb1.PLb = true;
        localb1.PLd = paramObject2;
        if (!localb1.PLa)
        {
          paramRunnable.run();
          h.this.t(paramInt, paramObject1);
          AppMethodBeat.o(267541);
          return;
        }
        if (localb1.PLc)
        {
          Log.i("MicroMsg.WebSearch.PGetController", "step_getJsApi preget hit type:%s, reqTag:%s, jsParams:%s", new Object[] { Integer.valueOf(paramInt), paramObject1, paramObject2 });
          if (parama != null) {
            parama.a(localb1);
          }
          ((Map)h.this.PKT.get(paramInt)).remove(paramObject1);
        }
        AppMethodBeat.o(267541);
      }
    });
    AppMethodBeat.o(216120);
  }
  
  public final void t(final int paramInt, final Object paramObject)
  {
    AppMethodBeat.i(216118);
    if (paramObject == null)
    {
      Log.e("MicroMsg.WebSearch.PGetController", "step_doCgiReq tag is null");
      AppMethodBeat.o(216118);
      return;
    }
    this.qdR.post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(215282);
        Log.i("MicroMsg.WebSearch.PGetController", "step_doCgiReq type:%s, reqTag:%s", new Object[] { Integer.valueOf(paramInt), paramObject });
        h.b localb2 = (h.b)((Map)h.this.PKT.get(paramInt)).get(paramObject);
        h.b localb1 = localb2;
        if (localb2 == null)
        {
          localb1 = new h.b();
          ((Map)h.this.PKT.get(paramInt)).put(paramObject, localb1);
        }
        localb1.PLa = true;
        AppMethodBeat.o(215282);
      }
    });
    AppMethodBeat.o(216118);
  }
  
  static abstract interface a
  {
    public abstract void a(h.b paramb);
  }
  
  public static final class b
  {
    boolean PLa;
    boolean PLb;
    boolean PLc;
    public Object PLd;
    public Object PLe;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.fts.h
 * JD-Core Version:    0.7.0.1
 */