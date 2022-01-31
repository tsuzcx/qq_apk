package com.tencent.mm.plugin.topstory.ui.home;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.HashMap;
import org.json.JSONArray;

final class d$1
  implements Runnable
{
  d$1(d paramd, int paramInt, String paramString) {}
  
  public final void run()
  {
    AppMethodBeat.i(1700);
    try
    {
      Object localObject = (String)this.thI.thF.get(Integer.valueOf(this.thG));
      if (bo.isNullOrNil((String)localObject)) {}
      for (localObject = new JSONArray();; localObject = new JSONArray((String)localObject))
      {
        ((JSONArray)localObject).put(this.thH);
        this.thI.bp(this.thG, ((JSONArray)localObject).toString());
        ab.i("MicroMsg.TopStory.TopStoryWebViewMgr", "addNegDocId finish: %s, %s", new Object[] { Integer.valueOf(this.thG), this.thH });
        AppMethodBeat.o(1700);
        return;
      }
      return;
    }
    catch (Exception localException)
    {
      ab.e("MicroMsg.TopStory.TopStoryWebViewMgr", "addNegDocId, exception: " + localException.getMessage());
      AppMethodBeat.o(1700);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.topstory.ui.home.d.1
 * JD-Core Version:    0.7.0.1
 */