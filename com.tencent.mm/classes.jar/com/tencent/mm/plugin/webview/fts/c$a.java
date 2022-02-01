package com.tencent.mm.plugin.webview.fts;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.az.h;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.sns.b.n;
import com.tencent.mm.protocal.protobuf.TimeLineObject;
import com.tencent.mm.sdk.platformtools.ad;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;

public final class c$a
  implements Runnable
{
  public boolean DKf;
  public String data;
  
  private c$a(c paramc) {}
  
  public final void run()
  {
    AppMethodBeat.i(77890);
    ArrayList localArrayList = new ArrayList();
    try
    {
      JSONArray localJSONArray = new JSONArray(this.data);
      int i = 0;
      while (i < localJSONArray.length())
      {
        Object localObject = ((n)g.ab(n.class)).Gx(localJSONArray.getString(i));
        g.ajD();
        localObject = h.a(g.ajC().gBm, (TimeLineObject)localObject, 9);
        if (localObject != null) {
          localArrayList.add(localObject);
        }
        i += 1;
      }
      if (!this.DKf) {
        break label131;
      }
    }
    catch (Exception localException)
    {
      ad.printErrStackTrace("MicroMsg.WebSearch.FTSWebViewLogic", localException, "", new Object[0]);
      AppMethodBeat.o(77890);
      return;
    }
    if (this.DKa.DJW == null)
    {
      label131:
      this.DKa.DJW = localException;
      AppMethodBeat.o(77890);
      return;
    }
    this.DKa.DJW.addAll(localException);
    AppMethodBeat.o(77890);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.fts.c.a
 * JD-Core Version:    0.7.0.1
 */