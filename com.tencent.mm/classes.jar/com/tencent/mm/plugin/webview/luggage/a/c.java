package com.tencent.mm.plugin.webview.luggage.a;

import com.tencent.luggage.d.d;
import com.tencent.luggage.d.p;
import com.tencent.luggage.d.s;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.webview.luggage.j;
import java.util.Iterator;
import java.util.LinkedList;
import org.json.JSONObject;

public final class c
{
  public static void b(String paramString, final JSONObject paramJSONObject)
  {
    AppMethodBeat.i(268491);
    Iterator localIterator = j.gUQ().iterator();
    while (localIterator.hasNext()) {
      ((s)localIterator.next()).crX.a(new d()
      {
        public final JSONObject NU()
        {
          return paramJSONObject;
        }
        
        public final String name()
        {
          return this.nAF;
        }
      });
    }
    AppMethodBeat.o(268491);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.luggage.a.c
 * JD-Core Version:    0.7.0.1
 */