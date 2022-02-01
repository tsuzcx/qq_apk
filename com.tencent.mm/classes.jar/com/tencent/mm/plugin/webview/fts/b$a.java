package com.tencent.mm.plugin.webview.fts;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ay.h;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.sns.b.n;
import com.tencent.mm.protocal.protobuf.TimeLineObject;
import com.tencent.mm.sdk.platformtools.ac;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;

public final class b$a
  implements Runnable
{
  public boolean CgY;
  public String data;
  
  private b$a(b paramb) {}
  
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
        Object localObject = ((n)g.ab(n.class)).Ds(localJSONArray.getString(i));
        g.agS();
        localObject = h.a(g.agR().ghC, (TimeLineObject)localObject, 9);
        if (localObject != null) {
          localArrayList.add(localObject);
        }
        i += 1;
      }
      if (!this.CgY) {
        break label131;
      }
    }
    catch (Exception localException)
    {
      ac.printErrStackTrace("MicroMsg.WebSearch.FTSWebViewLogic", localException, "", new Object[0]);
      AppMethodBeat.o(77890);
      return;
    }
    if (this.CgT.CgP == null)
    {
      label131:
      this.CgT.CgP = localException;
      AppMethodBeat.o(77890);
      return;
    }
    this.CgT.CgP.addAll(localException);
    AppMethodBeat.o(77890);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.fts.b.a
 * JD-Core Version:    0.7.0.1
 */