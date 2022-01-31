package com.tencent.mm.plugin.webview.fts;

import com.tencent.mm.model.au;
import com.tencent.mm.model.c;
import com.tencent.mm.plugin.sns.b.m;
import com.tencent.mm.protocal.c.bxk;
import com.tencent.mm.sdk.platformtools.y;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;

public final class b$a
  implements Runnable
{
  public String data;
  public boolean qZj;
  
  private b$a(b paramb) {}
  
  public final void run()
  {
    ArrayList localArrayList = new ArrayList();
    try
    {
      JSONArray localJSONArray = new JSONArray(this.data);
      int i = 0;
      while (i < localJSONArray.length())
      {
        Object localObject = ((m)com.tencent.mm.kernel.g.r(m.class)).nn(localJSONArray.getString(i));
        au.Hx();
        localObject = com.tencent.mm.av.g.a(c.FU(), (bxk)localObject, 9);
        if (localObject != null) {
          localArrayList.add(localObject);
        }
        i += 1;
      }
      if (!this.qZj) {
        break label118;
      }
    }
    catch (Exception localException)
    {
      y.printErrStackTrace("MicroMsg.FTS.FTSWebViewLogic", localException, "", new Object[0]);
      return;
    }
    if (this.qZb.qYY == null)
    {
      label118:
      this.qZb.qYY = localException;
      return;
    }
    this.qZb.qYY.addAll(localException);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.fts.b.a
 * JD-Core Version:    0.7.0.1
 */