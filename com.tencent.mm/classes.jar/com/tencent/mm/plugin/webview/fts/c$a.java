package com.tencent.mm.plugin.webview.fts;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ay.i;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.sns.b.n;
import com.tencent.mm.protocal.protobuf.TimeLineObject;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;

public final class c$a
  implements Runnable
{
  public boolean IOp;
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
        Object localObject = ((n)g.af(n.class)).PM(localJSONArray.getString(i));
        g.aAi();
        localObject = i.a(g.aAh().hqG, (TimeLineObject)localObject, 9, null);
        if (localObject != null) {
          localArrayList.add(localObject);
        }
        i += 1;
      }
      if (!this.IOp) {
        break label132;
      }
    }
    catch (Exception localException)
    {
      Log.printErrStackTrace("MicroMsg.WebSearch.FTSWebViewLogic", localException, "", new Object[0]);
      AppMethodBeat.o(77890);
      return;
    }
    if (this.IOi.IOe == null)
    {
      label132:
      this.IOi.IOe = localException;
      AppMethodBeat.o(77890);
      return;
    }
    this.IOi.IOe.addAll(localException);
    AppMethodBeat.o(77890);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.fts.c.a
 * JD-Core Version:    0.7.0.1
 */