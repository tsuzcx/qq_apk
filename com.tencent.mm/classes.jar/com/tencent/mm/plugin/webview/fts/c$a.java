package com.tencent.mm.plugin.webview.fts;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ay.h;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.sns.b.n;
import com.tencent.mm.protocal.protobuf.TimeLineObject;
import com.tencent.mm.sdk.platformtools.ae;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;

public final class c$a
  implements Runnable
{
  public boolean Ecd;
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
        Object localObject = ((n)g.ab(n.class)).GZ(localJSONArray.getString(i));
        g.ajS();
        localObject = h.a(g.ajR().gDT, (TimeLineObject)localObject, 9);
        if (localObject != null) {
          localArrayList.add(localObject);
        }
        i += 1;
      }
      if (!this.Ecd) {
        break label131;
      }
    }
    catch (Exception localException)
    {
      ae.printErrStackTrace("MicroMsg.WebSearch.FTSWebViewLogic", localException, "", new Object[0]);
      AppMethodBeat.o(77890);
      return;
    }
    if (this.EbY.EbU == null)
    {
      label131:
      this.EbY.EbU = localException;
      AppMethodBeat.o(77890);
      return;
    }
    this.EbY.EbU.addAll(localException);
    AppMethodBeat.o(77890);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.fts.c.a
 * JD-Core Version:    0.7.0.1
 */