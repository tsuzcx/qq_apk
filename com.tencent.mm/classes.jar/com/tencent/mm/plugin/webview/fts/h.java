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
  public final List<Map<Object, b>> IOC;
  private final MMHandler ndA;
  
  public h(MMHandler paramMMHandler)
  {
    AppMethodBeat.i(210839);
    this.IOC = new ArrayList();
    int i = 0;
    while (i < 3)
    {
      this.IOC.add(new HashMap());
      i += 1;
    }
    this.ndA = paramMMHandler;
    AppMethodBeat.o(210839);
  }
  
  public final void a(final int paramInt, final Object paramObject1, final Object paramObject2, final a parama)
  {
    AppMethodBeat.i(210842);
    this.ndA.post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(210838);
        Log.i("MicroMsg.WebSearch.PGetController", "step_cgiEnd type:%s reqTag:%s cgiResult:%s", new Object[] { Integer.valueOf(paramInt), paramObject1, paramObject2 });
        h.b localb = (h.b)((Map)h.this.IOC.get(paramInt)).get(paramObject1);
        if (localb == null)
        {
          Log.e("MicroMsg.WebSearch.PGetController", "step_cgiEnd weird null");
          AppMethodBeat.o(210838);
          return;
        }
        localb.ION = paramObject2;
        localb.IOL = true;
        if (localb.IOK)
        {
          if (parama != null) {
            parama.a(localb);
          }
          ((Map)h.this.IOC.get(paramInt)).remove(paramObject1);
        }
        AppMethodBeat.o(210838);
      }
    });
    AppMethodBeat.o(210842);
  }
  
  public final void a(final int paramInt, final Object paramObject1, final Object paramObject2, final Runnable paramRunnable, final a parama)
  {
    AppMethodBeat.i(210841);
    if (paramObject1 == null)
    {
      Log.e("MicroMsg.WebSearch.PGetController", "step_getJsApi tag is null");
      AppMethodBeat.o(210841);
      return;
    }
    this.ndA.post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(210837);
        Log.i("MicroMsg.WebSearch.PGetController", "step_getJsApi type:%s, reqTag:%s, jsParams:%s", new Object[] { Integer.valueOf(paramInt), paramObject1, paramObject2 });
        h.b localb2 = (h.b)((Map)h.this.IOC.get(paramInt)).get(paramObject1);
        h.b localb1 = localb2;
        if (localb2 == null)
        {
          localb1 = new h.b();
          ((Map)h.this.IOC.get(paramInt)).put(paramObject1, localb1);
        }
        localb1.IOK = true;
        localb1.IOM = paramObject2;
        if (!localb1.IOJ)
        {
          paramRunnable.run();
          h.this.p(paramInt, paramObject1);
          AppMethodBeat.o(210837);
          return;
        }
        if (localb1.IOL)
        {
          Log.i("MicroMsg.WebSearch.PGetController", "step_getJsApi preget hit type:%s, reqTag:%s, jsParams:%s", new Object[] { Integer.valueOf(paramInt), paramObject1, paramObject2 });
          if (parama != null) {
            parama.a(localb1);
          }
          ((Map)h.this.IOC.get(paramInt)).remove(paramObject1);
        }
        AppMethodBeat.o(210837);
      }
    });
    AppMethodBeat.o(210841);
  }
  
  public final void p(final int paramInt, final Object paramObject)
  {
    AppMethodBeat.i(210840);
    if (paramObject == null)
    {
      Log.e("MicroMsg.WebSearch.PGetController", "step_doCgiReq tag is null");
      AppMethodBeat.o(210840);
      return;
    }
    this.ndA.post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(210836);
        Log.i("MicroMsg.WebSearch.PGetController", "step_doCgiReq type:%s, reqTag:%s", new Object[] { Integer.valueOf(paramInt), paramObject });
        h.b localb2 = (h.b)((Map)h.this.IOC.get(paramInt)).get(paramObject);
        h.b localb1 = localb2;
        if (localb2 == null)
        {
          localb1 = new h.b();
          ((Map)h.this.IOC.get(paramInt)).put(paramObject, localb1);
        }
        localb1.IOJ = true;
        AppMethodBeat.o(210836);
      }
    });
    AppMethodBeat.o(210840);
  }
  
  static abstract interface a
  {
    public abstract void a(h.b paramb);
  }
  
  public static final class b
  {
    boolean IOJ;
    boolean IOK;
    boolean IOL;
    public Object IOM;
    public Object ION;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.fts.h
 * JD-Core Version:    0.7.0.1
 */