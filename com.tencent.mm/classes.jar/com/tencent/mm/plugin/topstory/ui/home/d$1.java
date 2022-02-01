package com.tencent.mm.plugin.topstory.ui.home;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import java.util.HashMap;
import org.json.JSONArray;

final class d$1
  implements Runnable
{
  d$1(d paramd, int paramInt, String paramString) {}
  
  public final void run()
  {
    AppMethodBeat.i(126059);
    try
    {
      Object localObject = (String)this.BLi.BLg.get(Integer.valueOf(this.BLh));
      if (bu.isNullOrNil((String)localObject)) {}
      for (localObject = new JSONArray();; localObject = new JSONArray((String)localObject))
      {
        ((JSONArray)localObject).put(this.tPT);
        this.BLi.cl(this.BLh, ((JSONArray)localObject).toString());
        ae.i("MicroMsg.TopStory.TopStoryWebViewMgr", "addNegDocId finish: %s, %s", new Object[] { Integer.valueOf(this.BLh), this.tPT });
        AppMethodBeat.o(126059);
        return;
      }
      return;
    }
    catch (Exception localException)
    {
      ae.e("MicroMsg.TopStory.TopStoryWebViewMgr", "addNegDocId, exception: " + localException.getMessage());
      AppMethodBeat.o(126059);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.topstory.ui.home.d.1
 * JD-Core Version:    0.7.0.1
 */