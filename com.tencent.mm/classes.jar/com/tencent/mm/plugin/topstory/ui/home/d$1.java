package com.tencent.mm.plugin.topstory.ui.home;

import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import java.util.HashMap;
import org.json.JSONArray;

final class d$1
  implements Runnable
{
  d$1(d paramd, int paramInt, String paramString) {}
  
  public final void run()
  {
    try
    {
      Object localObject = (String)this.pEm.pEj.get(Integer.valueOf(this.pEk));
      if (bk.bl((String)localObject)) {}
      for (localObject = new JSONArray();; localObject = new JSONArray((String)localObject))
      {
        ((JSONArray)localObject).put(this.pEl);
        this.pEm.aL(this.pEk, ((JSONArray)localObject).toString());
        y.i("MicroMsg.TopStory.TopStoryWebViewMgr", "addNegDocId finish: %s, %s", new Object[] { Integer.valueOf(this.pEk), this.pEl });
        return;
      }
      return;
    }
    catch (Exception localException)
    {
      y.e("MicroMsg.TopStory.TopStoryWebViewMgr", "addNegDocId, exception: " + localException.getMessage());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.topstory.ui.home.d.1
 * JD-Core Version:    0.7.0.1
 */